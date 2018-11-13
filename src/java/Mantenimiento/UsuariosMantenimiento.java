
package Mantenimiento;

import Persistencia.Usuarios;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class UsuariosMantenimiento {

    Usuarios usu;
    SessionFactory factory;
    Session session;

    public UsuariosMantenimiento() {
        usu = new Usuarios();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarUsuario(Usuarios u) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(u);
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

    public Usuarios consultarUsuario(int idUsuario) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            usu = (Usuarios) session.get(Usuarios.class, idUsuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return usu;
    }

    public int eliminar(int idUsuario) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            usu = (Usuarios) session.get(Usuarios.class, idUsuario);
            session.delete(usu);
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
        List<Usuarios> listausu = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Usuarios");
            listausu = (List<Usuarios>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
           
        }
        return listausu;
    }

   public boolean modificarUsuario(Usuarios u) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(u);
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
