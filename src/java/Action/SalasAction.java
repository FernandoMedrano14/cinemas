/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.SalasActionForm;
import Actionform.SucursalesActionForm;
import Mantenimiento.SalasMantenimiento;
import Mantenimiento.SucursalesMantenimiento;
import Persistencia.Salas;
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
public class SalasAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarsala";
    private static final String ERROR = "errorsala";
    private static final String CONFIRMARID = "consultaridsala";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarsala";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)throws Exception {
        
        SalasActionForm bean = (SalasActionForm) form;
        int idSala = bean.getIdSala();
        int idSucursal = bean.getIdSucursal();
        int numeroSala = bean.getNumeroSala();
        String tipoSala = bean.getTipoSala();
        String action = bean.getAction();
        
        if(action.equals("Iniciar")){
            //se carga la lista de Sucursales
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursales = su.consultartodo();
            //se carga lista de salas
            SalasMantenimiento sa = new SalasMantenimiento();
            List<Salas> listaSalas = sa.consultartodo();
            
            bean.setListaSucursales(listaSucursales);
            bean.setListaSalas(listaSalas);
            
            request.getSession().setAttribute("listaSucursales", listaSucursales);
            request.getSession().setAttribute("listaSalas", listaSalas);
            return mapping.findForward(CONSULTAR);
        }
        
        if(action.equals("Nuevo")){
            SalasMantenimiento sa = new SalasMantenimiento();
            String advertencia = "";
            
            if (numeroSala == 0 ) {
                advertencia = "*se necesita ingresar el numero de sala<br>";
            }
            
            if (tipoSala == null || tipoSala.equals("")) {
                advertencia = "*se necesita ingresar el tipo de sala<br>";
            }
            if (!advertencia.equals("")) {
                bean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }
            
            Salas s = new Salas();
            s.setIdSala(idSala);
            
            Sucursales su = new Sucursales();
            su.setIdSucursal(idSucursal);
            s.setSucursales(su);
            
            s.setNumeroSala(numeroSala);
            s.setTipoSala(tipoSala);
            if(sa.guardarSala(s)){
                bean.setError("<div class='alert alert-success'>la Sala ha sido registrada</div>");
                bean.setNumeroSala(0);
                bean.setTipoSala("");
                return mapping.findForward(GUARDAR);
            }else {
                bean.setError("Problema al guardar el regisro");
                return mapping.findForward(ERROR);
            }
        }
        
        if(action.equals("consultar")){
            //se carga la lista de Sucursales
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursales = su.consultartodo();
            SucursalesActionForm sform = new SucursalesActionForm();

            sform.setListaSucursal(listaSucursales);
            request.getSession().setAttribute("listaSucursales", listaSucursales);

            SalasMantenimiento sa = new SalasMantenimiento();
            List<Salas> listaSalas = sa.consultartodo();
            if(listaSalas == null){
                bean.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                bean.setListaSalas(listaSalas);
                return mapping.findForward(MOSTRAR);
            }
        }
        if(action.equals("Eliminar")){
            SalasMantenimiento sa = new SalasMantenimiento();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            if(sa.eliminar(idRecibido) ==0){
                bean.setError("<span style='color:red'>No se pudo eliminar el registro de Precios" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                List<Salas> listaSalas = sa.consultartodo();
                bean.setListaSalas(listaSalas);
                return mapping.findForward(MOSTRAR);
            }
        }
        
        if(action.equals("Modificar")){
            String advertencia = "";
            Salas s = new Salas();
            s.setIdSala(idSala);
            
            Sucursales su = new Sucursales();
            su.setIdSucursal(idSucursal);
            s.setSucursales(su);
            
            s.setNumeroSala(numeroSala);
            s.setTipoSala(tipoSala);
            
            SalasMantenimiento sa = new SalasMantenimiento();
            if(sa.modificarSala(s)){
                bean.setIdSala(0);
                bean.setIdSucursal(0);
                bean.setNumeroSala(0);
                bean.setTipoSala("");
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> la empresa ha sido modificado.\n</div>");
                request.setAttribute("advertencia", advertencia);
                List<Salas> listaSalas = sa.consultartodo();
                bean.setListaSalas(listaSalas);
                return mapping.findForward(MODIFICAR);
            }
        }
        
        if(action.equals("buscarId")){
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            //se carga la lista de sucursales
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursales = su.consultartodo();
            SucursalesActionForm sform = new SucursalesActionForm();
            sform.setListaSucursal(listaSucursales);
            request.getSession().setAttribute("listaSucursales", listaSucursales);
            
            SalasMantenimiento sa = new SalasMantenimiento();
            Salas s = sa.consultarSala(idRecibido);
            bean.setIdSala(idSala);
            bean.setIdSucursal(s.getSucursales().getIdSucursal());
            bean.setNumeroSala(numeroSala);
            bean.setTipoSala(tipoSala);
            return mapping.findForward(CONFIRMARID);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
