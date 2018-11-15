/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.EmpresasActionForm;
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

    
    private static final String SUCCESS = "success";
    private static final String error = "error";
    private static final String confirmarID = "consultarID";
    private static final String guardar = "guardar";
    private static final String eliminar = "eliminar";
    private static final String consultar = "consultarTodo";
    private static final String modificar = "modificar";
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        EmpresasActionForm formEmp = (EmpresasActionForm) form;
        
        
        return mapping.findForward(SUCCESS);
    }
}
