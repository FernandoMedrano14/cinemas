/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

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
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(CONFIRMACION);
    }
}