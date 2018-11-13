
package Mantenimiento;

import Persistencia.Peliculas;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class PeliculasMantenimiento {

    Peliculas pel;
    SessionFactory factory;
    Session session;

    public PeliculasMantenimiento() {
        pel = new Peliculas();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarPelicula(Peliculas p) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(p);
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

    public Peliculas consultarPelicula(int idPelicula) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            pel = (Peliculas) session.get(Peliculas.class, idPelicula);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return pel;
    }

    public int eliminar(int idPelicula) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            pel = (Peliculas) session.get(Peliculas.class, idPelicula);
            session.delete(pel);
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
        List<Peliculas> listapel = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Peliculas");
            listapel = (List<Peliculas>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listapel;
    }

   public boolean modificarPelicula(Peliculas p) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(p);
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
