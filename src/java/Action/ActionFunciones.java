/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.FuncionesActionForm;
import Mantenimiento.FuncionesMantenimiento;
import Mantenimiento.HorariosMantenimiento;
import Persistencia.Horarios;
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
public class ActionFunciones extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";
    private static final String CONFIRMACION = "confirmarempresa";
    private static final String ERROR = "errorempresa";
    private static final String CONFIRMARID = "consultaridempresa";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarempresas";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";
    
    FuncionesMantenimiento fun = new FuncionesMantenimiento();
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        FuncionesActionForm bean = (FuncionesActionForm) form;
        
        int idFuncion = bean.getIdFuncion();
        int idHorario = bean.getIdHorario();
        int idPelicula = bean.getIdPelicula();
        int idPrecio = bean.getIdPrecio();
        String estado = bean.getEstado();
        String action  =bean.getAction();
        
        if(action.equals("Ingresar")){
            //lista de horario
            HorariosMantenimiento hman = new HorariosMantenimiento();
            List<Horarios> listaHorario = hman.consultartodo();
            
            //lista de peliculas
        }
        
        
        return mapping.findForward(SUCCESS);
    }
}
