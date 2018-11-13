
package Mantenimiento;

import Persistencia.Ventas;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class VentasMantenimiento {

    Ventas ven;
    SessionFactory factory;
    Session session;

    public VentasMantenimiento() {
        ven = new Ventas();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarVenta(Ventas v) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(v);
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

    public Ventas consultarVenta(int idVenta) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            ven = (Ventas) session.get(Ventas.class, idVenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return ven;
    }

    public int eliminar(int idVenta) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            ven = (Ventas) session.get(Ventas.class, idVenta);
            session.delete(ven);
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
        List<Ventas> listaven = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Ventas");
            listaven = (List<Ventas>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listaven;
    }

   public boolean modificarVenta(Ventas v) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(v);
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
