
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

public class ActionEmpresas extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarempresa";
    private static final String ERROR = "errorempresa";
    private static final String CONFIRMARID = "consultaridempresa";
    private static final String GUARDAR = "guardarempresas";
    private static final String ELIMINAR = "eliminarempresas";
    private static final String CONSULTAR = "consultarempresas";
    private static final String MODIFICAR = "modificarempresas";
    private static final String MOSTRAR = "confirmarempresas";

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
        String mensaje;

        if (action.equals("Iniciar")) {
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            List<Empresas> listaEmpresa = emp.consultartodo();
            formEmp.setListaEmpresa(listaEmpresa);
            return mapping.findForward(CONSULTAR);
        }

        if (action.equals("Nueva")) {
            Empresas e = new Empresas();
            e.setIdEmpresa(0);
            e.setNombre(nombre);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setNit(nit);
            e.setNumeroRegistro(numeroRegistro);
            e.setGiro(giro);

            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            if (emp.guardarEmpresa(e)) {
                formEmp.setNombre("");
                formEmp.setDireccion("");
                formEmp.setTelefono("");
                formEmp.setNit("");
                formEmp.setNumeroRegistro("");
                formEmp.setGiro("");
                List<Empresas> listaEmpresa = emp.consultartodo();
                formEmp.setListaEmpresa(listaEmpresa);
                mensaje = "Éxito al guardar";
                request.setAttribute("mensaje", mensaje);
                return mapping.findForward(GUARDAR);
            } else {
                mensaje = "Ocurrió un error al tratar de guardar los datos";
                request.setAttribute("error", mensaje);
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("consultar")) {
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            List<Empresas> listaEmpresa = emp.consultartodo();
            if (listaEmpresa.isEmpty()) {
                mensaje = "No hay datos para mostrar";
                request.setAttribute("info", mensaje);
                return mapping.findForward(ERROR);
            } else {
                formEmp.setListaEmpresa(listaEmpresa);
                return mapping.findForward(MOSTRAR);
            }
        }

        if (action.equals("Modificar")) {
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

                mensaje = "Éxito al modificar";
                request.setAttribute("mensaje", mensaje);
                List<Empresas> listaEmpresa = emp.consultartodo();
                formEmp.setListaEmpresa(listaEmpresa);
                return mapping.findForward(MODIFICAR);
            } else {
                formEmp.setIdEmpresa(0);
                formEmp.setNombre("");
                formEmp.setDireccion("");
                formEmp.setTelefono("");
                formEmp.setNit("");
                formEmp.setNumeroRegistro("");
                formEmp.setGiro("");
                
                mensaje = "Ocurrió un error al modificar";
                request.setAttribute("error", mensaje);
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("Eliminar")) {
            EmpresasMantenimiento emp = new EmpresasMantenimiento();            
            if (emp.eliminar(idEmpresa) == 0) {
                List<Empresas> listaEmpresa = emp.consultartodo();
                formEmp.setIdEmpresa(0);
                formEmp.setListaEmpresa(listaEmpresa);
                mensaje = "Ocurrió un error al eliminar";
                request.setAttribute("error", mensaje);
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
                mensaje = "Éxito al eliminar";
                request.setAttribute("mensaje", mensaje);
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