
package Mantenimiento;


import Persistencia.Horarios;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class HorariosMantenimiento {

    Horarios hor;
    SessionFactory factory;
    Session session;

    public HorariosMantenimiento() {
        hor = new Horarios();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarHorario(Horarios h) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(h);
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

    public Horarios consultarHorario(int idHorario) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            hor = (Horarios) session.get(Horarios.class, idHorario);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return hor;
    }

    public int eliminar(int idHorario) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            hor = (Horarios) session.get(Horarios.class, idHorario);
            session.delete(hor);
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
        List<Horarios> listahor = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Horarios");
            listahor = (List<Horarios>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listahor;
    }

   public boolean modificarHorario(Horarios h) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(h);
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
