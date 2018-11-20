/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.GenerosActionForm;
import Mantenimiento.GenerosMantenimiento;
import Persistencia.Generos;
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
public class GeneroAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String CONFIRMACION = "confirmarGenero";
    private static final String ERROR = "errorgenero";
    private static final String CONFIRMARID = "consultaridgenero";
    private static final String GUARDAR = "guardarGenero";
    private static final String ELIMINAR = "eliminarGenero";
    private static final String CONSULTAR = "consultarGenero";
    private static final String MODIFICAR = "modificarGenero";
    private static final String MOSTRAR = "confirmacion";
 
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
        
        GenerosActionForm bean = (GenerosActionForm) form;
        
        Integer idGenero = bean.getIdGenero();
        String genero = bean.getGenero();
        String action  = bean.getAction();
        
        if(action.equals("Iniciar")){
            GenerosMantenimiento ge = new GenerosMantenimiento();
            List<Generos> listaGeneros = ge.consultartodo();
            bean.setListaGeneros(listaGeneros);
            return mapping.findForward(CONSULTAR);
        }
        
        if(action.equals("Nueva")){   
            String advertencia = "";

            if (idGenero != 0) {
                advertencia = "Este usuario ya existe";
            }
            if (genero == null || genero.equals("")) {
                advertencia = "*Es necesario agragar el genero<br>";
            }
            if (!advertencia.equals("")) {
                bean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }
            
            Generos g = new Generos();
            g.setIdGenero(idGenero);
            g.setGenero(genero);
            
            GenerosMantenimiento ge = new GenerosMantenimiento();
            if(ge.guardarGenero(g)){
                bean.setError("<div class='alert alert-success'>Su Genero ha sido registrado</div>");
                bean.setGenero("");
                List<Generos> listaGeneros = ge.consultartodo();
                bean.setListaGeneros(listaGeneros);
                return mapping.findForward(GUARDAR);
            } else {
                bean.setError("<div class='alert alert-danger'>Ocurrio un error al crear el Genero.</div>");
                return mapping.findForward(ERROR);
            }
        }
        
        if(action.equals("consultar")){
            GenerosMantenimiento ge = new GenerosMantenimiento();
            List<Generos> listaGeneros = ge.consultartodo();
            if(listaGeneros == null){
                bean.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                bean.setListaGeneros(listaGeneros);
                return mapping.findForward(MOSTRAR);
            }
        }
        
        if(action.equals("Modificar")){
            String advertencia = "";
            Generos g = new Generos();
            g.setIdGenero(idGenero);
            g.setGenero(genero);
            
            GenerosMantenimiento ge = new GenerosMantenimiento();
            if(ge.modificarGenero(g)){
                bean.setIdGenero(0);
                bean.setGenero("");
                advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> el genero ha sido modificado.\n</div>");
                request.setAttribute("advertencia", advertencia);
                List<Generos> listaGeneros = ge.consultartodo();
                bean.setListaGeneros(listaGeneros);
                return mapping.findForward(MODIFICAR);
            } else {
                bean.setError("<div class='alert alert-danger'>Ocurrio un error al modificar el genereo.</div>");
                return mapping.findForward(ERROR);
            }
        }
        
        if(action.equals("Eliminar")){
            String advertencia = "";
            GenerosMantenimiento ge = new GenerosMantenimiento();
            if(ge.eliminar(idGenero) == 0){
                bean.setError("<div class='alert alert-danger'>Ocurrio un error al eliminar el Genero.</div>");
                return mapping.findForward(ERROR);
            } else {
                bean.setIdGenero(0);
                bean.setGenero("");
                List<Generos> listaGeneros = ge.consultartodo();
                bean.setListaGeneros(listaGeneros);
                bean.setIdGenero(idGenero);
                return mapping.findForward(ELIMINAR);
            }
        }
        
        if(action.equals("buscarId")){
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            GenerosMantenimiento ge = new GenerosMantenimiento();
            Generos g = ge.consultarGenero(idRecibido);
            bean.setIdGenero(g.getIdGenero());
            bean.setGenero(g.getGenero());
            
            List<Generos> listaGeneros = ge.consultartodo();
            bean.setListaGeneros(listaGeneros);
            return mapping.findForward(CONFIRMARID);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
