/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.UsuariosActionForm;
import Mantenimiento.TiposUsuariosMantenimiento;
import Mantenimiento.UsuariosMantenimiento;
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
        
        if(bean.getAction().equals("iniciar")){
            UsuariosMantenimiento manto = new UsuariosMantenimiento();
            List<Usuarios> listausuarios = manto.consultartodo();
            bean.setListaUsuario(listausuarios);
            TiposUsuariosMantenimiento mantoTiposUusarios = new TiposUsuariosMantenimiento();
            List<TiposUsuarios> listaTiposUsuarios = mantoTiposUusarios.consultartodo();
            bean.setListaTiposUsuarios(listaTiposUsuarios);
            return mapping.findForward(CONSULTAR);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
