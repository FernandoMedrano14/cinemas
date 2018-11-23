
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Actionform.FuncionesActionForm;
import Actionform.HorariosActionForm;
import Actionform.PeliculasActionForm;
import Actionform.PreciosActionForm;
import Mantenimiento.FuncionesMantenimiento;
import Mantenimiento.HorariosMantenimiento;
import Mantenimiento.PeliculasMantenimiento;
import Mantenimiento.PreciosMantenimiento;
import Persistencia.Funciones;
import Persistencia.Horarios;
import Persistencia.Peliculas;
import Persistencia.Precios;
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

    private static final String CONFIRMACION = "confirmarfuncion";
    private static final String ERROR = "errorfuncion";
    private static final String CONFIRMARID = "consultaridfuncion";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarfuncion";
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
            PeliculasMantenimiento peli = new PeliculasMantenimiento();
            List<Peliculas> listaPeliculas = peli.consultartodo();
            //lista de precios
            PreciosMantenimiento pre = new PreciosMantenimiento();
            List<Precios> listaPrecio = pre.consultartodo();
            //lista de Funciones
            FuncionesMantenimiento func = new FuncionesMantenimiento();
            List<Funciones> listaFunciones = func.consultartodo();
            
            bean.setListaFunciones(listaFunciones);
            bean.setListaHorario(listaHorario);
            bean.setListaPeliculas(listaPeliculas);
            bean.setListaPrecio(listaPrecio);
            
            request.getSession().setAttribute("listaHorario", listaHorario);
            request.getSession().setAttribute("listaPeliculas", listaPeliculas);
            request.getSession().setAttribute("listaPrecio", listaPrecio);
            request.getSession().setAttribute("listaFunciones", listaFunciones);
        } else {
            bean.setError("<span style='color:red'> Problemas al cargar la lista");
            System.out.println("problema al cargar la lista");
        }
            
        if(action.equals("Nueva")){
            FuncionesMantenimiento func = new FuncionesMantenimiento();
            System.out.println("Entra al accion");
            String advertencia = "";

            if (estado == null || estado.equals("")) {
                advertencia = "*se necesita ingresar el numero de Nit<br>";
            }
            
            if (!ERROR.equals("")) {
                bean.setError("<div class='alert alert-danger'>" + ERROR + "</div>");
                return mapping.findForward(ERROR);
            }
            
            Funciones f = new Funciones();
            f.setIdFuncion(idFuncion);
            
            Horarios h = new Horarios();
            h.setIdHorario(idHorario);
            f.setHorarios(h);
            
            Peliculas p = new Peliculas();
            p.setIdPelicula(idPelicula);
            f.setPeliculas(p);
            
            Precios pre = new Precios();
            pre.setIdPrecio(idPrecio);
            f.setPrecios(pre);
            
            f.setEstado(estado);
            
            if(func.guardarFuncion(f)){
                bean.setError("<div class='alert alert-success'>La Funcion ha sido registrada</div>");
                bean.setEstado("");
                List<Funciones> listaFunciones = func.consultartodo();
                bean.setListaFunciones(listaFunciones);
                return mapping.findForward(GUARDAR);
            }
        }
        
        if(action.equals("consultar")){
            //lista de horario
            HorariosMantenimiento hman = new HorariosMantenimiento();
            List<Horarios> listaHorario = hman.consultartodo();
            HorariosActionForm hform = new HorariosActionForm();
            //lista de peliculas
            PeliculasMantenimiento peli = new PeliculasMantenimiento();
            List<Peliculas> listaPeliculas = peli.consultartodo();
            PeliculasActionForm pform = new PeliculasActionForm();
            //lista de precios
            PreciosMantenimiento pre = new PreciosMantenimiento();
            List<Precios> listaPrecio = pre.consultartodo();
            PreciosActionForm preform = new PreciosActionForm();
           
            
            hform.setListaHorario(listaHorario);
            request.getSession().setAttribute("listaHorario", listaHorario);
            
            pform.setListaPeliculas(listaPeliculas);
            request.getSession().setAttribute("listaPeliculas", listaPeliculas);
            
            preform.setListaPrecios(listaPrecio);
            request.getSession().setAttribute("listaPrecio", listaPrecio);
            
            //lista de Funciones
            FuncionesMantenimiento func = new FuncionesMantenimiento();
            List<Funciones> listaFunciones = func.consultartodo();
            if(listaFunciones == null){
                bean.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                bean.setListaFunciones(listaFunciones);
                return mapping.findForward(MOSTRAR);
            }
        }
        
        if(action.equals("Eliminar")){
            FuncionesMantenimiento fu = new FuncionesMantenimiento();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            
            if(fu.eliminar(idFuncion) == 0){
                bean.setError("<span style='color:red'>No se pudo eliminar el registro de Funcion" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                List<Funciones> listaFunciones = fu.consultartodo();
                bean.setListaFunciones(listaFunciones);
                return mapping.findForward(ELIMINAR);
            }
        }
        
        if(action.equals("Modifiar")){
            Funciones f = new Funciones();
            f.setIdFuncion(idFuncion);
            
            Horarios h = new Horarios();
            h.setIdHorario(idHorario);
            f.setHorarios(h);
            
            Peliculas p = new Peliculas();
            p.setIdPelicula(idPelicula);
            f.setPeliculas(p);
            
            Precios pre = new Precios();
            pre.setIdPrecio(idPrecio);
            f.setPrecios(pre);
            
            f.setEstado(estado);
            FuncionesMantenimiento fu = new FuncionesMantenimiento();
            fu.modificarEmpresa(f);
            bean.setError("<div class='alert alert-success'>Su funcion ha sido actualizada.</div>");
            bean.setEstado(f.getEstado());
            return mapping.findForward(MODIFICAR);
        }
        
        if(action.equals("buscarId")){
            HorariosMantenimiento hor = new HorariosMantenimiento();
            List<Horarios> listaHorarios = hor.consultartodo();
            FuncionesActionForm fform = new FuncionesActionForm();
            fform.setListaHorario(listaHorarios);
            request.getSession().setAttribute("listaHorarios", listaHorarios);
            
            PeliculasMantenimiento peli = new PeliculasMantenimiento();
            List<Peliculas> listaPeliculas = peli.consultartodo();
            fform.setListaPeliculas(listaPeliculas);
            request.getSession().setAttribute("listaPeliculas", listaPeliculas);
            
            PreciosMantenimiento pre = new PreciosMantenimiento();
            List<Precios> listaPrecio = pre.consultartodo();
            fform.setListaPrecio(listaPrecio);
            request.getSession().setAttribute("listaPrecio", listaPrecio);
            
            FuncionesMantenimiento fu = new FuncionesMantenimiento();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            Funciones f = fu.consultarFuncion(idRecibido);
            
            bean.setIdFuncion(idFuncion);
            bean.setIdHorario(f.getHorarios().getIdHorario());
            bean.setIdPelicula(f.getPeliculas().getIdPelicula());
            bean.setIdPrecio(f.getPrecios().getIdPrecio());
            bean.setEstado(estado);
            
            return mapping.findForward(CONFIRMARID);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
