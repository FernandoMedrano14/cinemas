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

        if (action.equals("Iniciar")) {
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            List<Clasificaciones> listaClasificacion = cla.consultartodo();
            formCla.setListaClasificacion(listaClasificacion);
            return mapping.findForward(CONSULTAR);
        }

        if (action.equals("Nueva")) {
            String advertencia = "";

            if (idClasificacion != 0) {
                advertencia = "Esta clasificacion ya existe";
            }

            if (tipoClasificacion == null || tipoClasificacion.equals("")) {
                advertencia = "*Es necesario agregar el tipo de clasificacion";
            }

            if (detalleClasificacion == null || detalleClasificacion.equals("")) {
                advertencia = "*Es necesario agregar detalle a la clasificacion";
            }

            System.out.println(advertencia);
            if (!advertencia.equals("")) {
                formCla.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }

            Clasificaciones c = new Clasificaciones();
            c.setIdClasificacion(idClasificacion);
            c.setTipoClasificacion(tipoClasificacion);
            c.setDetalleClasificacion(detalleClasificacion);

            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            if (cla.guardarClasificacion(c)) {
                formCla.setError("<div class='alert alert-success'>Esta clasificacion ya ha sido registrada</div>");
                formCla.setTipoClasificacion("");
                formCla.setDetalleClasificacion("");
                List<Clasificaciones> listaClasificacion = cla.consultartodo();
                formCla.setListaClasificacion(listaClasificacion);
                return mapping.findForward(GUARDAR);
            } else {
                formCla.setError("<div class='alert alert-danger'>Ocurrio un error al crear la Empresa.</div>");
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("consultar")) {
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            List<Clasificaciones> listaClasificacion = cla.consultartodo();
            if (listaClasificacion == null) {
                formCla.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                formCla.setListaClasificacion(listaClasificacion);
                return mapping.findForward(MOSTRAR);
            }
        }

        if (action.equals("Modificar")) {
            System.out.println("Entra el accion");
            String advertencia = "";
            Clasificaciones c = new Clasificaciones();
            c.setIdClasificacion(idClasificacion);
            c.setTipoClasificacion(tipoClasificacion);
            c.setDetalleClasificacion(detalleClasificacion);

            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            if (cla.modificarEmpresa(c)) {
                formCla.setIdClasificacion(0);
                formCla.setTipoClasificacion("");
                formCla.setDetalleClasificacion("");

                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> la clasificacion ha sido modificada.\n</div>");
                request.setAttribute("advertencia", advertencia);
                List<Clasificaciones> listaClasificacion = cla.consultartodo();
                formCla.setListaClasificacion(listaClasificacion);
                return mapping.findForward(MODIFICAR);
            } else {
                formCla.setError("<div class='alert alert-danger'>Ocurrio un error al modificar la clasificacion.</div>");
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("Eliminar")) {
            String advertencia = "";

            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            if (cla.eliminar(idClasificacion) == 0) {
                formCla.setError("<div class='alert alert-danger'>Ocurrio un error al eliminar la clasificacion.</div>");
                return mapping.findForward(ERROR);
            } else {
                formCla.setIdClasificacion(0);
                formCla.setTipoClasificacion("");
                formCla.setDetalleClasificacion("");
                List<Clasificaciones> listaClasificacion = cla.consultartodo();
                formCla.setListaClasificacion(listaClasificacion);
                formCla.setIdClasificacion(idClasificacion);
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
