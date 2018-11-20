
package Mantenimiento;

import Persistencia.Generos;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class GenerosMantenimiento {

    Generos gen;
    SessionFactory factory;
    Session session;

    public GenerosMantenimiento() {
        gen = new Generos();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarGenero(Generos g) {
        System.out.println("Entra al mantenimiento");
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(g);
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

    public Generos consultarGenero(int idGenero) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            gen = (Generos) session.get(Generos.class, idGenero);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return gen;
    }

    public int eliminar(int idGenero) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            gen = (Generos) session.get(Generos.class, idGenero);
            session.delete(gen);
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
        List<Generos> listagen = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Generos");
            listagen = (List<Generos>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
           
        }
        return listagen;
    }

   public boolean modificarGenero(Generos g) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(g);
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
