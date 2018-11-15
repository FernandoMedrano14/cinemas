
package Mantenimiento;

import Persistencia.Sucursales;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class SucursalesMantenimiento {

    Sucursales suc;
    SessionFactory factory;
    Session session;

    public SucursalesMantenimiento() {
        suc = new Sucursales();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarSucursal(Sucursales s) {
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

    public Sucursales consultarSucursal(int idSucursal) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            suc = (Sucursales) session.get(Sucursales.class, idSucursal);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return suc;
    }

    public int eliminar(int idSucursal) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            suc = (Sucursales) session.get(Sucursales.class, idSucursal);
            session.delete(suc);
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
        List<Sucursales> listasuc = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Sucursales");
            listasuc = (List<Sucursales>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listasuc;
    }

   public boolean modificarSucursal(Sucursales s) {
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
