
package Mantenimiento;

import Persistencia.Funciones;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class FuncionesMantenimiento {

    Funciones fun;
    SessionFactory factory;
    Session session;

    public FuncionesMantenimiento() {
        fun = new Funciones();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarFuncion(Funciones f) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(f);
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

    public Funciones consultarFuncion(int idFuncion) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            fun = (Funciones) session.get(Funciones.class, idFuncion);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return fun;
    }

    public int eliminar(int idFuncion) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            fun = (Funciones) session.get(Funciones.class, idFuncion);
            session.delete(fun);
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
        List<Funciones> listafun = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Funciones");
            listafun = (List<Funciones>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listafun;
    }

   public boolean modificarEmpresa(Funciones f) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(f);
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
