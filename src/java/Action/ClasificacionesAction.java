/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.ClasificacionesActionForm;
import Mantenimiento.ClasificacionesMantenimiento;
import Persistencia.Clasificaciones;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author david.floresusam
 */
public class ClasificacionesAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarclasificacion";
    private static final String ERROR = "errorclasificacion";
    private static final String CONFIRMARID = "consultaridclasificacion";
    private static final String GUARDAR = "guardarclasificaciones";
    private static final String ELIMINAR = "eliminarclasificaciones";
    private static final String CONSULTAR = "consultarclasificaciones";
    private static final String MODIFICAR = "modificarclasificaciones";
    private static final String MOSTRAR = "confirmarclasificaciones";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ClasificacionesActionForm formCla = (ClasificacionesActionForm) form;
        Integer idClasificacion = formCla.getIdClasificacion();
        String tipoClasificacion = formCla.getTipoClasificacion();
        String detalleClasificacion = formCla.getDetalleClasificacion();
        String action = formCla.getAction();
        String mensaje;

        if (action.equals("Iniciar")) {
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            List<Clasificaciones> listaClasificacion = cla.consultartodo();
            formCla.setListaClasificacion(listaClasificacion);
            return mapping.findForward(CONSULTAR);
        }

        if (action.equals("Nueva")) {
            System.out.println("Evento Nueva");
            Clasificaciones c = new Clasificaciones();
            c.setIdClasificacion(0);
            c.setTipoClasificacion(tipoClasificacion);
            c.setDetalleClasificacion(detalleClasificacion);

            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            if (cla.guardarClasificacion(c)) {
                formCla.setTipoClasificacion("");
                formCla.setDetalleClasificacion("");
                List<Clasificaciones> listaClasificacion = cla.consultartodo();
                formCla.setListaClasificacion(listaClasificacion);
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
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            List<Clasificaciones> listaClasificacion = cla.consultartodo();
            if (listaClasificacion.isEmpty()) {
                mensaje = "No hay datos para mostrar";
                request.setAttribute("info", mensaje);
                return mapping.findForward(ERROR);
            } else {
                formCla.setListaClasificacion(listaClasificacion);
                return mapping.findForward(MOSTRAR);
            }
        }

        if (action.equals("Modificar")) {
            Clasificaciones c = new Clasificaciones();
            c.setIdClasificacion(idClasificacion);
            c.setTipoClasificacion(tipoClasificacion);
            c.setDetalleClasificacion(detalleClasificacion);

            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            if (cla.modificarClasificacion(c)) {
                formCla.setIdClasificacion(0);
                formCla.setTipoClasificacion("");
                formCla.setDetalleClasificacion("");

                mensaje = "Éxito al modificar";
                request.setAttribute("mensaje", mensaje);
                List<Clasificaciones> listaClasificacion = cla.consultartodo();
                formCla.setListaClasificacion(listaClasificacion);
                return mapping.findForward(MODIFICAR);
            } else {
                formCla.setIdClasificacion(0);
                formCla.setTipoClasificacion("");
                formCla.setDetalleClasificacion("");
                
                mensaje = "Ocurrió un error al modificar";
                request.setAttribute("error", mensaje);
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("Eliminar")) {
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            if (cla.eliminar(idClasificacion) == 0) {
                List<Clasificaciones> listaClasificacion = cla.consultartodo();
                formCla.setListaClasificacion(listaClasificacion);
                formCla.setIdClasificacion(0);
                mensaje = "Ocurrió un error al eliminar";
                request.setAttribute("error", mensaje);
                return mapping.findForward(ERROR);
            } else {
                formCla.setIdClasificacion(0);
                formCla.setTipoClasificacion("");
                formCla.setDetalleClasificacion("");
                List<Clasificaciones> listaClasificacion = cla.consultartodo();
                formCla.setListaClasificacion(listaClasificacion);
                mensaje = "Éxito al eliminar";
                request.setAttribute("mensaje", mensaje);
                return mapping.findForward(ELIMINAR);
            }
        }

        if (action.equals("buscarId")) {

            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            Clasificaciones c = cla.consultarClasificaciones(idRecibido);
            formCla.setIdClasificacion(c.getIdClasificacion());
            formCla.setTipoClasificacion(c.getTipoClasificacion());
            formCla.setDetalleClasificacion(c.getDetalleClasificacion());

            List<Clasificaciones> listaClasificacion = cla.consultartodo();
            formCla.setListaClasificacion(listaClasificacion);

            return mapping.findForward(CONFIRMARID);
        }

        return mapping.findForward(CONFIRMACION);
    }
}
