/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.PreciosActionForm;
import Actionform.SucursalesActionForm;
import Mantenimiento.PreciosMantenimiento;
import Mantenimiento.SucursalesMantenimiento;
import Persistencia.Precios;
import Persistencia.Sucursales;
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
public class PreciosAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarprecios";
    private static final String ERROR = "errorprecios";
    private static final String CONFIRMARID = "consultaridprecios";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarprecios";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        PreciosActionForm bean = (PreciosActionForm) form;
        int idPrecio = bean.getIdPrecio();
        int idSucursal = bean.getIdSucursal();
        double precio = bean.getPrecio();
        String descripcion = bean.getDescripcion();
        String action = bean.getAction();

        if (action.equals("Iniciar")) {
            //se carga la lista de Sucursales
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursales = su.consultartodo();
            //sec arga la lista de precios
            PreciosMantenimiento pre = new PreciosMantenimiento();
            List<Precios> listaPrecios = pre.consultartodo();

            bean.setListaPrecios(listaPrecios);
            bean.setListaSucursales(listaSucursales);

            request.getSession().setAttribute("listaPrecios", listaPrecios);
            request.getSession().setAttribute("listaSucursales", listaSucursales);
            return mapping.findForward(CONSULTAR);
        }

        if (action.equals("Nuevo")) {
            PreciosMantenimiento pre = new PreciosMantenimiento();
            String advertencia = "";

            if (descripcion == null || descripcion.equals("")) {
                advertencia = "*se necesita ingresar el nombre del Titulo<br>";
            }

            if (!advertencia.equals("")) {
                bean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }

            Precios pr = new Precios();
            pr.setIdPrecio(idPrecio);

            Sucursales s = new Sucursales();
            s.setIdSucursal(idSucursal);
            pr.setSucursales(s);

            pr.setPrecio(precio);
            pr.setDescripcion(descripcion);
            if (pre.guardarPrecio(pr)) {
                bean.setError("<div class='alert alert-success'>La Pelicula ha sido registrada</div>");
                bean.setPrecio(0.0);
                bean.setDescripcion("");
                List<Precios> listaPrecios = pre.consultartodo();
                bean.setListaPrecios(listaPrecios);
                return mapping.findForward(GUARDAR);
            } else {
                bean.setError("Problema al guardar el regisro");
                return mapping.findForward(ERROR);
            }
        }

        if (action.equals("consultar")) {
            //se carga la lista de Sucursales
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursales = su.consultartodo();
            SucursalesActionForm sform = new SucursalesActionForm();

            sform.setListaSucursal(listaSucursales);
            request.getSession().setAttribute("listaSucursales", listaSucursales);

            PreciosMantenimiento pre = new PreciosMantenimiento();
            List<Precios> listaPrecios = pre.consultartodo();
            if (listaPrecios == null) {
                bean.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                bean.setListaPrecios(listaPrecios);
                return mapping.findForward(MOSTRAR);
            }
        }
        if (action.equals("Eliminar")) {
            PreciosMantenimiento pre = new PreciosMantenimiento();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            if (pre.eliminar(idRecibido) == 0) {
                bean.setError("<span style='color:red'>No se pudo eliminar el registro de Precios" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                List<Precios> listaPrecios = pre.consultartodo();
                bean.setListaPrecios(listaPrecios);
                return mapping.findForward(ELIMINAR);
            }
        }

        if (action.equals("Modificar")) {
            String advertencia = "";
            Precios pr = new Precios();
            pr.setIdPrecio(idPrecio);

            Sucursales s = new Sucursales();
            s.setIdSucursal(idSucursal);
            pr.setSucursales(s);

            pr.setPrecio(precio);
            pr.setDescripcion(descripcion);

            PreciosMantenimiento pre = new PreciosMantenimiento();
            if (pre.modificarPrecio(pr)) {
                bean.setIdPrecio(0);
                bean.setIdSucursal(0);
                bean.setPrecio(0.0);
                bean.setDescripcion("");
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> la empresa ha sido modificado.\n</div>");
                request.setAttribute("advertencia", advertencia);
                List<Precios> listaPrecios = pre.consultartodo();
                bean.setListaPrecios(listaPrecios);
                return mapping.findForward(MODIFICAR);
            }
        }

        if(action.equals("bucarId")){
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            //se carga la lista de sucursales
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursales = su.consultartodo();
            SucursalesActionForm sform = new SucursalesActionForm();
            sform.setListaSucursal(listaSucursales);
            request.getSession().setAttribute("listaSucursales", listaSucursales);
            
            PreciosMantenimiento pre = new PreciosMantenimiento();
            Precios pr = pre.consultarPrecio(idPrecio);
            
            bean.setIdPrecio(idPrecio);
            bean.setIdSucursal(pr.getSucursales().getIdSucursal());
            bean.setPrecio(precio);
            bean.setDescripcion(descripcion);
            
            return mapping.findForward(CONFIRMARID);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
