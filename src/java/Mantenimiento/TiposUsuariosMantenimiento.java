
package Mantenimiento;

import Persistencia.TiposUsuarios;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class TiposUsuariosMantenimiento {

    TiposUsuarios tpu;
    SessionFactory factory;
    Session session;

    public TiposUsuariosMantenimiento() {
        tpu = new TiposUsuarios();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarTipoUsuario(TiposUsuarios tu) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(tu);
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

    public TiposUsuarios consultarTipoUsuario(int idTipoUsuario) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            tpu = (TiposUsuarios) session.get(TiposUsuarios.class, idTipoUsuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return tpu;
    }

    public int eliminar(int idTipoUsuario) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            tpu = (TiposUsuarios) session.get(TiposUsuarios.class, idTipoUsuario);
            session.delete(tpu);
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
        List<TiposUsuarios> listatpu = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from TiposUsuarios");
            listatpu = (List<TiposUsuarios>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
           
        }
        return listatpu;
    }

   public boolean modificarTipoUsuario(TiposUsuarios tu) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(tu);
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
