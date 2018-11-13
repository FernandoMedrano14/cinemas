
package Mantenimiento;


import Persistencia.Salas;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class SalasMantenimiento {

    Salas sal;
    SessionFactory factory;
    Session session;

    public SalasMantenimiento() {
        sal = new Salas();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarSala(Salas s) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(s);
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

    public Salas consultarSala(int idSala) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            sal = (Salas) session.get(Salas.class, idSala);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return sal;
    }

    public int eliminar(int idSala) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            sal = (Salas) session.get(Salas.class, idSala);
            session.delete(sal);
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
        List<Salas> listasal = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Salas");
            listasal = (List<Salas>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listasal;
    }

   public boolean modificarSala (Salas s) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(s);
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
