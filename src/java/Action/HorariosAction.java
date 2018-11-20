/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.HorariosActionForm;
import Mantenimiento.HorariosMantenimiento;
import Mantenimiento.SalasMantenimiento;
import Persistencia.Horarios;
import Persistencia.Salas;
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
public class HorariosAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarhorario";
    private static final String ERROR = "errorhorario";
    private static final String CONFIRMARID = "consultaridhorario";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarhorario";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        HorariosActionForm bean = (HorariosActionForm) form;
        int idHorario = bean.getIdHorario();
        int idSala = bean.getIdSala();
        String horario = bean.getHorario();
        String action = bean.getAction();
        
        if(action.equals("Iniciar")){
            //lista de horario
            HorariosMantenimiento hor = new HorariosMantenimiento();
            List<Horarios> listaHorario = hor.consultartodo();
            //lista de salas
            SalasMantenimiento sa = new SalasMantenimiento();
            List<Salas> listaSala = sa.consultartodo();
            
            //se cargan las listas
            bean.setListaHorario(listaHorario);
            bean.setListaSala(listaSala);
            return mapping.findForward(CONSULTAR);
        }
        
        if(action.equals("Nueva")){
            String advertencia = "";
            
            if(idHorario!=0){
                advertencia = "este usuario ya existe";
            }
            if (horario == null || horario.equals("")) {
                advertencia = "*Es necesario agragar el horario<br>";
            }
            if (!advertencia.equals("")) {
                bean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }
            
            Horarios h = new Horarios();
            h.setIdHorario(idHorario);
            h.setIdSala(idSala);
            h.setHorario(horario);
            
            HorariosMantenimiento hor = new HorariosMantenimiento();
            if(hor.guardarHorario(h)){
                bean.setError("<div class='alert alert-success'>Su Horario ha sido registrada</div>");
                bean.setHorario("");
                List<Horarios> listaHorario = hor.consultartodo();
                return mapping.findForward(GUARDAR);
            } else {
                bean.setError("<div class='alert alert-danger'>Ocurrio un error al crear el Horaio.</div>");
                return mapping.findForward(ERROR);
            }
        }
        
        if(action.equals("consultar")){
            HorariosMantenimiento hor = new HorariosMantenimiento();
            List<Horarios> listaHorario = hor.consultartodo();
            if(listaHorario == null){
                bean.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                bean.setListaHorario(listaHorario);
                return mapping.findForward(MOSTRAR);
            }
        }
        
        if(action.equals("Modificar")){
            String advertencia = "";
            Horarios h = new Horarios();
            h.setIdHorario(idHorario);
            h.setIdSala(idSala);
            h.setHorario(horario);
            
            HorariosMantenimiento hor = new HorariosMantenimiento();
            
            if(hor.modificarHorario(h)){
                bean.setIdHorario(0);
                bean.setIdSala(0);
                bean.setHorario("");
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> la empresa ha sido modificado.\n</div>");
                request.setAttribute("advertencia", advertencia);
                List<Horarios> listaHorario = hor.consultartodo();
                bean.setListaHorario(listaHorario);
                return mapping.findForward(MODIFICAR);
            }
        }
        
        if(action.equals("ELiminar")){
            String advertencia = "";
            
            HorariosMantenimiento hor = new HorariosMantenimiento();
            
            if(hor.eliminar(idHorario) ==0){
                bean.setError("<div class='alert alert-danger'>Ocurrio un error al eliminar la Empresa.</div>");
                return mapping.findForward(ERROR);
            } else {
                bean.setIdHorario(0);
                bean.setIdSala(0);
                bean.setHorario("");
                List<Horarios> listaHorario = hor.consultartodo();
                bean.setListaHorario(listaHorario);
                bean.setIdHorario(idHorario);
                return mapping.findForward(ELIMINAR);
            }
        }
        
        if(action.equals("buscarId")){
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            HorariosMantenimiento hor = new HorariosMantenimiento();
            Horarios h = hor.consultarHorario(idRecibido);
            bean.setIdHorario(h.getIdHorario());
            bean.setIdSala(h.getIdSala());
            bean.setHorario(h.getHorario());
            
            List<Horarios> listaHorario = hor.consultartodo();
            bean.setListaHorario(listaHorario);
            return mapping.findForward(CONFIRMARID);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
