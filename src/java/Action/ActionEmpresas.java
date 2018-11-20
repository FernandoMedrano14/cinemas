
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.EmpresasActionForm;
import Mantenimiento.EmpresasMantenimiento;
import Persistencia.Empresas;
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
public class ActionEmpresas extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarempresa";
    private static final String ERROR = "errorempresa";
    private static final String CONFIRMARID = "consultaridempresa";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminarempresas";
    private static final String CONSULTAR = "consultarempresas";
    private static final String MODIFICAR = "modificarempresas";
    private static final String MOSTRAR = "confirmacion";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        EmpresasActionForm formEmp = (EmpresasActionForm) form;

        Integer idEmpresa = formEmp.getIdEmpresa();
        String nombre = formEmp.getNombre();
        String direccion = formEmp.getDireccion();
        String telefono = formEmp.getTelefono();
        String nit = formEmp.getNit();
        String numeroRegistro = formEmp.getNumeroRegistro();
        String giro = formEmp.getGiro();
        String action = formEmp.getAction();

        if (action.equals("Iniciar")) {
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            List<Empresas> listaEmpresa = emp.consultartodo();
            formEmp.setListaEmpresa(listaEmpresa);
            return mapping.findForward(CONSULTAR);
        }

        if (action.equals("Nueva")) {
            System.out.println("Entrando al accion");
            String advertencia = "";

            if (idEmpresa != 0) {
                advertencia = "Este usuario ya existe";
            }
            if (nombre == null || nombre.equals("")) {
                advertencia = "*Es necesario agragar el nombre<br>";
            }

            if (direccion == null || direccion.equals("")) {
                advertencia = "*se necesita ingresar la direccion<br>";
            }

            if (telefono == null || telefono.equals("")) {
                advertencia = "*se necesita ingresar el telefono<br>";
            }

            if (nit == null || nit.equals("")) {
                advertencia = "*se necesita ingresar el numero de Nit<br>";
            }

            if (numeroRegistro == null || numeroRegistro.equals("")) {
                advertencia = "*se necesita ingresar el numero de Registro<br>";
            }

            if (giro == null || giro.equals("")) {
                advertencia = "*se necesita ingresar el numero de Registro<br>";
            }
            System.out.println(advertencia);
            if (!advertencia.equals("")) {
                formEmp.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);

            }

            Empresas e = new Empresas();
            e.setIdEmpresa(idEmpresa);
            e.setNombre(nombre);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setNit(nit);
            e.setNumeroRegistro(numeroRegistro);
            e.setGiro(giro);

            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            if (emp.guardarEmpresa(e)) {
                formEmp.setError("<div class='alert alert-success'>Su Empresa ha sido registrada</div>");
                formEmp.setNombre("");
                formEmp.setDireccion("");
                formEmp.setTelefono("");
                formEmp.setNit("");
                formEmp.setNumeroRegistro("");
                formEmp.setGiro("");
                List<Empresas> listaEmpresa = emp.consultartodo();
                formEmp.setListaEmpresa(listaEmpresa);
                return mapping.findForward(GUARDAR);
            } else {
                formEmp.setError("<div class='alert alert-danger'>Ocurrio un error al crear la Empresa.</div>");
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("consultar")) {
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            List<Empresas> listaEmpresa = emp.consultartodo();
            if (listaEmpresa == null) {
                formEmp.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                formEmp.setListaEmpresa(listaEmpresa);
                return mapping.findForward(MOSTRAR);
            }
        }

        if (action.equals("Modificar")) {
            System.out.println("Entra el accion");
            String advertencia = "";
            Empresas e = new Empresas();
            e.setIdEmpresa(idEmpresa);
            e.setNombre(nombre);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setNit(nit);
            e.setNumeroRegistro(numeroRegistro);
            e.setGiro(giro);
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            if (emp.modificarEmpresa(e)) {
                formEmp.setIdEmpresa(0);
                formEmp.setNombre("");
                formEmp.setDireccion("");
                formEmp.setTelefono("");
                formEmp.setNit("");
                formEmp.setNumeroRegistro("");
                formEmp.setGiro("");

                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> la empresa ha sido modificado.\n</div>");
                request.setAttribute("advertencia", advertencia);
                List<Empresas> listaEmpresa = emp.consultartodo();
                formEmp.setListaEmpresa(listaEmpresa);
                return mapping.findForward(MODIFICAR);
            } else {
                formEmp.setError("<div class='alert alert-danger'>Ocurrio un error al modificar la Empresa.</div>");
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("Eliminar")) {
            String advertencia = "";
            
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            if (emp.eliminar(idEmpresa) == 0) {
                formEmp.setError("<div class='alert alert-danger'>Ocurrio un error al eliminar la Empresa.</div>");
                return mapping.findForward(ERROR);
            } else {
                formEmp.setIdEmpresa(0);
                formEmp.setNombre("");
                formEmp.setDireccion("");
                formEmp.setTelefono("");
                formEmp.setNit("");
                formEmp.setNumeroRegistro("");
                formEmp.setGiro("");
                List<Empresas> listaEmpresa = emp.consultartodo();
                formEmp.setListaEmpresa(listaEmpresa);
                formEmp.setIdEmpresa(idEmpresa);
                return mapping.findForward(ELIMINAR);
            }
            
        }

        if (action.equals("buscarId")) {

            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            Empresas e = emp.consultarEmpresa(idRecibido);
            formEmp.setIdEmpresa(e.getIdEmpresa());
            formEmp.setNombre(e.getNombre());
            formEmp.setDireccion(e.getDireccion());
            formEmp.setTelefono(e.getTelefono());
            formEmp.setNit(e.getNit());
            formEmp.setNumeroRegistro(e.getNumeroRegistro());
            formEmp.setGiro(e.getGiro());

            List<Empresas> listaEmpresa = emp.consultartodo();
            formEmp.setListaEmpresa(listaEmpresa);

            return mapping.findForward(CONFIRMARID);
        }

        return mapping.findForward(CONFIRMACION);
    }

}

