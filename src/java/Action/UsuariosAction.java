/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.UsuariosActionForm;
import Mantenimiento.EmpresasMantenimiento;
import Mantenimiento.Encriptacion;
import Mantenimiento.TiposUsuariosMantenimiento;
import Mantenimiento.UsuariosMantenimiento;
import Persistencia.Empresas;
import Persistencia.TiposUsuarios;
import Persistencia.Usuarios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author fernando.medranousam
 */
public class UsuariosAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarusuario";
    private static final String ERROR = "errorusuario";
    private static final String CONFIRMARID = "consultaridusuario";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarUsuario";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        UsuariosActionForm bean = (UsuariosActionForm) form;
        System.out.println("CARGO USUARIOS");
        if (bean.getAction().equals("iniciar")) {
            UsuariosMantenimiento manto = new UsuariosMantenimiento();
            List<Usuarios> listausuarios = manto.consultartodo();
            bean.setListaUsuario(listausuarios);

            TiposUsuariosMantenimiento mantoTiposUusarios = new TiposUsuariosMantenimiento();
            List<TiposUsuarios> listaTiposUsuarios = mantoTiposUusarios.consultartodo();
            bean.setListaTiposUsuarios(listaTiposUsuarios);

            EmpresasMantenimiento em = new EmpresasMantenimiento();
            List<Empresas> listaEmpresas = em.consultartodo();
            bean.setListaEmpresas(listaEmpresas);

            return mapping.findForward(CONSULTAR);
        }

        if (bean.getAction().equals("guardar")) {
            System.out.println("Estoy Guardando");
            UsuariosMantenimiento mantoUsuarios = new UsuariosMantenimiento();
            Usuarios u = new Usuarios();
            u.setIdUsuario(0);
            TiposUsuarios tiposUsuarios = new TiposUsuarios();
            tiposUsuarios.setIdTipoUsuario(bean.getIdTipoUsuario());
            u.setTiposUsuarios(tiposUsuarios);
            Empresas e = new Empresas();
            e.setIdEmpresa(bean.getIdEmpresa());
            u.setEmpresas(e);
            u.setNickname(bean.getNickname());
            u.setNombres(bean.getNombres());
            u.setApellidos(bean.getApellidos());
            u.setCorreo(bean.getCorreo());
            Encriptacion encrip = new Encriptacion();
            u.setContrasenia(encrip.Encriptacion(bean.getContrasenia()));
            if (!mantoUsuarios.buscarCorreoExistente(u.getCorreo())) {
                if (!mantoUsuarios.buscarUsuariosExistente(u.getNickname())) {
                    if (mantoUsuarios.guardarUsuario(u)) {
                        bean.setNombres("");
                        bean.setApellidos("");
                        bean.setNickname("");
                        bean.setCorreo("");
                        UsuariosMantenimiento manto = new UsuariosMantenimiento();
                        List<Usuarios> listausuarios = manto.consultartodo();
                        bean.setListaUsuario(listausuarios);

                        TiposUsuariosMantenimiento mantoTiposUusarios = new TiposUsuariosMantenimiento();
                        List<TiposUsuarios> listaTiposUsuarios = mantoTiposUusarios.consultartodo();
                        bean.setListaTiposUsuarios(listaTiposUsuarios);

                        EmpresasMantenimiento em = new EmpresasMantenimiento();
                        List<Empresas> listaEmpresas = em.consultartodo();
                        bean.setListaEmpresas(listaEmpresas);
                    }
                }
            }
            return mapping.findForward(CONSULTAR);
        }

        return mapping.findForward(CONFIRMACION);
    }
}
