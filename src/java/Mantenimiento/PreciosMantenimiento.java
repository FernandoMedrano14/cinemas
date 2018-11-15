
package Mantenimiento;

import Persistencia.Precios;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class PreciosMantenimiento {

    Precios pre;
    SessionFactory factory;
    Session session;

    public PreciosMantenimiento() {
        pre = new Precios();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarPrecio(Precios p) {
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

    public Precios consultarPrecio(int idPrecio) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            pre = (Precios) session.get(Precios.class, idPrecio);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return pre;
    }

    public int eliminar(int idPrecio) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            pre = (Precios) session.get(Precios.class, idPrecio);
            session.delete(pre);
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
        List<Precios> listapre = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Precios");
            listapre = (List<Precios>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listapre;
    }

   public boolean modificarPrecio(Precios p) {
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
