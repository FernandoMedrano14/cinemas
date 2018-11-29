/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.VentasActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author fernando.medranousam
 */
public class VentasAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarventa";
    private static final String ERROR = "errorventa";
    private static final String CONFIRMARID = "consultaridventa";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarventa";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        VentasActionForm bean = (VentasActionForm) form;
        int idVenta = bean.getIdVenta();
        int idFuncion = bean.getIdFuncion();
        String fechaVenta = bean.getFechaVenta();
        String nombreCliente = bean.getNombreCliente();
        int cantidad = bean.getCantidad();
        String dui = bean.getDui();
        double total = bean.getTotal();
        String estado = bean.getEstado();
        String action = bean.getAction();
        
        if(action.equals("Iniciar")){
            
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
