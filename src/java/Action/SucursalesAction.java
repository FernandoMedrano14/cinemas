/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.EmpresasActionForm;
import Actionform.SucursalesActionForm;
import Mantenimiento.EmpresasMantenimiento;
import Mantenimiento.SucursalesMantenimiento;
import Persistencia.Empresas;
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
public class SucursalesAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarsucursal";
    private static final String ERROR = "errorsucursal";
    private static final String CONFIRMARID = "consultaridsucursal";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarsucursal";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        SucursalesActionForm bean = (SucursalesActionForm) form;
        
        int idSucursal = bean.getIdEmpresa();
        int idEmpresa = bean.getIdEmpresa();
        String nombreSucursal = bean.getNombreSucursal();
        String direccionSucursal = bean.getDireccionSucursal();
        String telefono = bean.getTelelfono();
        String action = bean.getAction();
        
        if(action.equals("Iniciar")){
            //se carga lista de emrpesas
            EmpresasMantenimiento e = new EmpresasMantenimiento();
            List<Empresas> listaEmpresa = e.consultartodo();
            //se carga lista sucursales
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursal = su.consultartodo();
            
            bean.setListaEmpresa(listaEmpresa);
            bean.setListaSucursal(listaSucursal);
            
            request.getSession().setAttribute("listaSucursales", listaSucursal);
            request.getSession().setAttribute("listaEmpresa", listaEmpresa);
            return mapping.findForward(CONSULTAR);
        }
        
        if(action.equals("Nuevo")){
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            String advertencia = "";
            
            if (nombreSucursal == null || nombreSucursal.equals("")) {
                advertencia = "*se necesita ingresar el nombre de la sucursal<br>";
            }
            if (direccionSucursal == null || direccionSucursal.equals("")) {
                advertencia = "*se necesita ingresar la direccion de la sucursal<br>";
            }
            if (telefono == null || telefono.equals("")) {
                advertencia = "*se necesita ingresar el telefono de la sucursal<br>";
            }
            if (!advertencia.equals("")) {
                bean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }

            Sucursales suc = new Sucursales();
            suc.setIdSucursal(idSucursal);
            
            Empresas e = new Empresas();
            e.setIdEmpresa(idEmpresa);
            suc.setEmpresas(e);
            
            suc.setNombreSucursal(nombreSucursal);
            suc.setDireccionSucursal(direccionSucursal);
            suc.setTelefono(telefono);
            if(su.guardarSucursal(suc)){
                bean.setError("<div class='alert alert-success'>El Precio ha sido registrado</div>");
                bean.setNombreSucursal("");
                bean.setDireccionSucursal("");
                bean.setTelelfono("");
                List<Sucursales> listaSucursal = su.consultartodo();
                bean.setListaSucursal(listaSucursal);
                return mapping.findForward(GUARDAR);
            } else {
                bean.setError("Problema al guardar el regisro");
                return mapping.findForward(ERROR);
            }
        }
        
        if(action.equals("consultar")){
            //se carga lista de emrpesas
            EmpresasMantenimiento e = new EmpresasMantenimiento();
            List<Empresas> listaEmpresa = e.consultartodo();
            EmpresasActionForm eform = new EmpresasActionForm();
            
            eform.setListaEmpresa(listaEmpresa);
            request.getSession().setAttribute("listaEmpresa", listaEmpresa);
            
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            List<Sucursales> listaSucursal = su.consultartodo();
            if(listaSucursal == null){
                bean.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                bean.setListaSucursal(listaSucursal);
                return mapping.findForward(MOSTRAR);
            }
        }
        
        if(action.equals("Eliminar")){
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            if(su.eliminar(idRecibido)==0){
                bean.setError("<span style='color:red'>No se pudo eliminar el registro de Precios" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                List<Sucursales> listaSucursal = su.consultartodo();
                bean.setListaSucursal(listaSucursal);
                return mapping.findForward(ELIMINAR);
            }
        }
        
        if(action.equals("Modificar")){
            String advertencia = "";
            Sucursales s = new Sucursales();
            s.setIdSucursal(idSucursal);
            
            Empresas e = new Empresas();
            e.setIdEmpresa(idEmpresa);
            s.setEmpresas(e);
            
            s.setNombreSucursal(nombreSucursal);
            s.setDireccionSucursal(direccionSucursal);
            s.setTelefono(telefono);
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            if(su.modificarSucursal(s)){
                bean.setIdSucursal(0);
                bean.setIdEmpresa(0);
                bean.setNombreSucursal("");
                bean.setDireccionSucursal("");
                bean.setTelelfono("");
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> la empresa ha sido modificado.\n</div>");
                request.setAttribute("advertencia", advertencia);
                List<Sucursales> listaSucursal = su.consultartodo();
                bean.setListaSucursal(listaSucursal);
                return mapping.findForward(MODIFICAR);
            }
        }
        
        if(action.equals("buscarId")){
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            //se carga lista de emrpesas
            EmpresasMantenimiento e = new EmpresasMantenimiento();
            List<Empresas> listaEmpresa = e.consultartodo();
            EmpresasActionForm eform = new EmpresasActionForm();
            eform.setListaEmpresa(listaEmpresa);
            request.getSession().setAttribute("listaEmpresa", listaEmpresa);
            
            SucursalesMantenimiento su = new SucursalesMantenimiento();
            Sucursales s = su.consultarSucursal(idRecibido);
            bean.setIdSucursal(idSucursal);
            bean.setIdEmpresa(s.getEmpresas().getIdEmpresa());
            bean.setNombreSucursal(nombreSucursal);
            bean.setDireccionSucursal(direccionSucursal);
            bean.setTelelfono(telefono);
            return mapping.findForward(CONFIRMARID);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
