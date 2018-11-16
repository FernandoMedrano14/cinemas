/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.GenerosActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author fernando.medranousam
 */
public class GeneroAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String CONFIRMACION = "confirmargenero";
    private static final String ERROR = "errorgenero";
    private static final String CONFIRMARID = "consultaridgenero";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultargenero";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";

    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        GenerosActionForm bean = (GenerosActionForm) form;
        
        
        
        
        return mapping.findForward(CONFIRMACION);
    }
}
