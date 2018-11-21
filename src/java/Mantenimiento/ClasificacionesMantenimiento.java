package Mantenimiento;

import Persistencia.Clasificaciones;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClasificacionesMantenimiento {

    Clasificaciones cla;
    SessionFactory factory;
    Session session;

    public ClasificacionesMantenimiento() {

        cla = new Clasificaciones();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarClasificacion(Clasificaciones c) {

        boolean r = false;
        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            r = true;
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error en mantenimiento" + ex);
                r = false;
            }
        }
        System.out.println(r);
        return r;
    }

    public Clasificaciones consultarClasificaciones(int idClasificacion) {

        session = factory.openSession();
        try {
            session.beginTransaction();
            cla = (Clasificaciones) session.get(Clasificaciones.class, idClasificacion);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }

        return cla;
    }

    public int eliminar(int idClasificacion) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            cla = (Clasificaciones) session.get(Clasificaciones.class, idClasificacion);
            session.delete(cla);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 0;
            }

        } finally {
            session.close();
        }
        return flag;
    }

    public List consultartodo() {
        List<Clasificaciones> listacla = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Clasificaciones");
            listacla = (List<Clasificaciones>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR EN MANTENIMIENTO. " + e);
        } finally {

        }
        return listacla;
    }
    
     public boolean modificarEmpresa(Clasificaciones c) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
            r = true;
        }catch(Exception ex){
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                r = false;
            }
        } finally {
            session.close();
        }
        return r;
    }
}
