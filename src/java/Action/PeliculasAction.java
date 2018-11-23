package Action;

import Actionform.ClasificacionesActionForm;
import Actionform.EmpresasActionForm;
import Actionform.GenerosActionForm;
import Actionform.PeliculasActionForm;
import Mantenimiento.ClasificacionesMantenimiento;
import Mantenimiento.EmpresasMantenimiento;
import Mantenimiento.GenerosMantenimiento;
import Mantenimiento.PeliculasMantenimiento;
import Persistencia.Clasificaciones;
import Persistencia.Empresas;
import Persistencia.Generos;
import Persistencia.Peliculas;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PeliculasAction extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmarpelicula";
    private static final String ERROR = "errorpelicula";
    private static final String CONFIRMARID = "consultaridpelicula";
    private static final String GUARDAR = "guardar";
    private static final String ELIMINAR = "eliminar";
    private static final String CONSULTAR = "consultarpelicula";
    private static final String MODIFICAR = "modificar";
    private static final String MOSTRAR = "confirmacion";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        PeliculasActionForm bean = (PeliculasActionForm) form;
        int idPelicula = bean.getIdPelicula();
        int idEmpresa = bean.getIdEmpresa();
        int idGenero = bean.getIdGenero();
        int idClasificaciones = bean.getIdClasificaciones();
        String titulo = bean.getTitulo();
        String duracion = bean.getDuracion();
        String actores = bean.getDuracion();
        String sinopsis = bean.getSipnosis();
        String imagen = bean.getImagen();
        String estado = bean.getEstado();
        String action = bean.getAction();

        if (action.equals("Iniciar")) {
            //se carga lista de empresas
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            List<Empresas> listaEmpresas = emp.consultartodo();
            //se carga lista de generos
            GenerosMantenimiento ge = new GenerosMantenimiento();
            List<Generos> listaGeneros = ge.consultartodo();
            //se carga lista de Peliculas
            PeliculasMantenimiento pe = new PeliculasMantenimiento();
            List<Peliculas> listaPeliculas = pe.consultartodo();
            //se carga lista de Clasificaciones
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            List<Clasificaciones> listaClasificaciones = cla.consultartodo();
            
            bean.setListaEmpresas(listaEmpresas);
            bean.setListaGeneros(listaGeneros);
            bean.setListaPeliculas(listaPeliculas);
            bean.setListaClasificaciones(listaClasificaciones);
            
            request.getSession().setAttribute("listaEmpresas", listaEmpresas);
            request.getSession().setAttribute("listaGeneros", listaGeneros);
            request.getSession().setAttribute("listaPeliculas", listaPeliculas);
            request.getSession().setAttribute("listaClasificaciones", listaClasificaciones);
            return mapping.findForward(CONSULTAR);
        }

        if (action.equals("Nueva")) {
            PeliculasMantenimiento pe = new PeliculasMantenimiento();
            String advertencia = "";

            if (titulo == null || titulo.equals("")) {
                advertencia = "*se necesita ingresar el nombre del Titulo<br>";
            }
            if (duracion == null || duracion.equals("")) {
                advertencia = "*se necesita ingresar el tiempo de duracion<br>";
            }
            if (actores == null || actores.equals("")) {
                advertencia = "*se necesita ingresar el numero de Nit<br>";
            }
            if (sinopsis == null || sinopsis.equals("")) {
                advertencia = "*se necesita ingresar la sipnosis<br>";
            }
            if (imagen == null || imagen.equals("")) {
                advertencia = "*se necesita ingresar la imagen<br>";
            }
            if (estado == null || estado.equals("")) {
                advertencia = "*se necesita ingresar el numero de Nit<br>";
            }
            System.out.println(advertencia);
            if (!advertencia.equals("")) {
                bean.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(ERROR);
            }
            Peliculas p = new Peliculas();
            p.setIdPelicula(idPelicula);

            Generos g = new Generos();
            g.setIdGenero(idGenero);
            p.setGeneros(g);

            Empresas e = new Empresas();
            e.setIdEmpresa(idEmpresa);
            p.setEmpresas(e);

            Clasificaciones c = new Clasificaciones();
            c.setIdClasificacion(idClasificaciones);
            p.setClasificaciones(c);
            
            p.setTitulo(titulo);
            p.setDuracion(duracion);
            p.setActores(actores);
            p.setSinopsis(sinopsis);
            p.setImagen(imagen);
            p.setEstado(estado);

            if (pe.guardarPelicula(p)) {
                bean.setError("<div class='alert alert-success'>La Funcion ha sido registrada</div>");
                bean.setTitulo("");
                p.setDuracion("");
                p.setActores("");
                p.setDirectores("");
                p.setSinopsis("");
                p.setImagen("");
                p.setEstado("");
                List<Peliculas> listaPeliculas = pe.consultartodo();
                bean.setListaPeliculas(listaPeliculas);
                return mapping.findForward(GUARDAR);
            } else {
                bean.setError("Problema al guardar el regisro");
                return mapping.findForward(ERROR);
            }
        }
        
        if(action.equals("consultar")){
            //se carga lista de empresas
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            List<Empresas> listaEmpresas = emp.consultartodo();
            EmpresasActionForm eform = new EmpresasActionForm();
            //se carga lista de generos
            GenerosMantenimiento ge = new GenerosMantenimiento();
            List<Generos> listaGeneros = ge.consultartodo();
            GenerosActionForm gform = new GenerosActionForm();
            //se carga lista de Clasificaciones
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            List<Clasificaciones> listaClasificaciones = cla.consultartodo();
            ClasificacionesActionForm cform = new ClasificacionesActionForm();
            
            eform.setListaEmpresa(listaEmpresas);
            request.getSession().setAttribute("listaEmpresas", listaEmpresas);
            
            gform.setListaGeneros(listaGeneros);
            request.getSession().setAttribute("listaGeneros", listaGeneros);
            
            cform.setListaClasificacion(listaClasificaciones);
            request.getSession().setAttribute("listaClasificaciones", listaClasificaciones);
            
            //se carga lista de Peliculas
            PeliculasMantenimiento pe = new PeliculasMantenimiento();
            List<Peliculas> listaPeliculas = pe.consultartodo();
            if(listaPeliculas == null){
                bean.setError("<span style='color:red'>No se encontraron registros" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                bean.setListaPeliculas(listaPeliculas);
                return mapping.findForward(MOSTRAR);
            }
        }

        if(action.equals("Eliminar")){
            PeliculasMantenimiento pe = new PeliculasMantenimiento();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            
            if(pe.eliminar(idRecibido)==0){
                bean.setError("<span style='color:red'>No se pudo eliminar el registro de Funcion" + "<br></span>");
                return mapping.findForward(ERROR);
            } else {
                List<Peliculas> listaPeliculas = pe.consultartodo();
                bean.setListaPeliculas(listaPeliculas);
                return mapping.findForward(ELIMINAR);
            }
        }
        
        if(action.equals("Modificar")){
            String advertencia = "";
            Peliculas p = new Peliculas();
            p.setIdPelicula(idPelicula);
            
            Empresas e = new Empresas();
            e.setIdEmpresa(idEmpresa);
            p.setEmpresas(e);
            
            Generos g = new Generos();
            g.setIdGenero(idGenero);
            p.setGeneros(g);
            
            Clasificaciones c = new Clasificaciones();
            c.setIdClasificacion(idClasificaciones);
            p.setClasificaciones(c);
            
            p.setTitulo(titulo);
            p.setDuracion(duracion);
            p.setActores(actores);
            p.setDirectores(actores);
            p.setSinopsis(sinopsis);
            p.setImagen(imagen);
            p.setEstado(estado);
            
            PeliculasMantenimiento pe = new PeliculasMantenimiento();
            if(pe.modificarPelicula(p)){
             bean.setIdPelicula(0);
             bean.setIdEmpresa(0);
             bean.setIdClasificaciones(0);
             bean.setIdGenero(0);
             bean.setTitulo("");
             bean.setDuracion("");
             bean.setDirectores("");
             bean.setSipnosis("");
             bean.setImagen("");
             bean.setEstado("");
             advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> la empresa ha sido modificado.\n</div>");
             request.setAttribute("advertencia", advertencia);
             List<Peliculas> listaPeliculas = pe.consultartodo();
             bean.setListaPeliculas(listaPeliculas);
             return mapping.findForward(MODIFICAR);
            }
        }
        
        if(action.equals("buscarId")){
            int idRecibido = (Integer.parseInt(request.getParameter("id")));
            
            //se carga lista de empresas
            EmpresasMantenimiento emp = new EmpresasMantenimiento();
            List<Empresas> listaEmpresas = emp.consultartodo();
            EmpresasActionForm eform = new EmpresasActionForm();
            eform.setListaEmpresa(listaEmpresas);
            request.getSession().setAttribute("listaEmpresas", listaEmpresas);
            //se carga lista de generos
            GenerosMantenimiento ge = new GenerosMantenimiento();
            List<Generos> listaGeneros = ge.consultartodo();
            GenerosActionForm gform = new GenerosActionForm();
            gform.setListaGeneros(listaGeneros);
            request.getSession().setAttribute("listaGeneros", listaGeneros);
            //se carga lista de Clasificaciones
            ClasificacionesMantenimiento cla = new ClasificacionesMantenimiento();
            List<Clasificaciones> listaClasificaciones = cla.consultartodo();
            ClasificacionesActionForm cform = new ClasificacionesActionForm();
            cform.setListaClasificacion(listaClasificaciones);
            request.getSession().setAttribute("listaClasificaciones", listaClasificaciones);
            
            PeliculasMantenimiento pe = new PeliculasMantenimiento();
            Peliculas p = pe.consultarPelicula(idRecibido);
            
            bean.setIdPelicula(idPelicula);
            bean.setIdEmpresa(p.getEmpresas().getIdEmpresa());
            bean.setIdGenero(p.getGeneros().getIdGenero());
            bean.setIdClasificaciones(p.getClasificaciones().getIdClasificacion());
            bean.setTitulo(titulo);
            bean.setDuracion(duracion);
            bean.setDirectores(actores);
            bean.setSipnosis(sinopsis);
            bean.setImagen(imagen);
            bean.setEstado(estado);
            
            return mapping.findForward(CONFIRMARID);
        }
        
        return mapping.findForward(CONFIRMACION);
    }
}
