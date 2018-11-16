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
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarempresas";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";
    
    EmpresasMantenimiento emp = new EmpresasMantenimiento();
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        EmpresasActionForm formEmp = (EmpresasActionForm) form;
        Integer idEmpresa = formEmp.getIdEmpresa();
        String nombre = formEmp.getNombre();
        String direccion = formEmp.getDireccion();
        String telefono = formEmp.getTelefono();
        String nit = formEmp.getNit();
        String numeroRegistro = formEmp.getNumeroRegisto();
        String giro = formEmp.getGiro();
        String action = formEmp.getAction();
        
        if (action.equals("Iniciar")) {
            List<Empresas> listaEmpresa = emp.consultartodo();
            formEmp.setListaEmpresa(listaEmpresa);
            return mapping.findForward(CONSULTAR);
        } else {
            formEmp.setError("<span style='color:red'> Problemas al cargar la lista");
            System.out.println("problema al cargar la lista");
        }
        
        if (action.equals("Agregar")) {
            String advertencia = "";

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
            
            
         if(emp.guardarEmpresa(e)){
             formEmp.setError("<div class='alert alert-success'>Su Empresa ha sido registrada</div>");
             formEmp.setNombre(nombre);
             formEmp.setDireccion(direccion);
             formEmp.setTelefono(telefono);
             formEmp.setNit(nit);
             formEmp.setNumeroRegisto(numeroRegistro);
             formEmp.setGiro(giro);
             List<Empresas> listaEmpresa = emp.consultartodo();
             formEmp.setListaEmpresa(listaEmpresa);
             return mapping.findForward(CONSULTAR);
         } else {
           formEmp.setError("<div class='alert alert-danger'>Ocurrio un error al crear la Empresa.</div>");
                return mapping.findForward(ERROR);  
         }
        }
        
        if (action.equals("consultar")){
            List<Empresas> listaEmpresa = emp.consultartodo();
            if(listaEmpresa == null){
                formEmp.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                formEmp.setListaEmpresa(listaEmpresa);
                return mapping.findForward(MOSTRAR);
            }
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
