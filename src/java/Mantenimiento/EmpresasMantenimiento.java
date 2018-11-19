
package Mantenimiento;

import Persistencia.Empresas;
import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jose.melendezusam
 */
public class EmpresasMantenimiento {

    Empresas emp;
    SessionFactory factory;
    Session session;

    public EmpresasMantenimiento() {
        emp = new Empresas();
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }

    public boolean guardarEmpresa(Empresas e) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            r = true;
        }catch(Exception ex){
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error: "+ex);
                r = false;
            }
        } finally {
            session.close();
        }
        System.out.println(r);
        return r;
    }

    public Empresas consultarEmpresa(int idEmpresa) {
        session = factory.openSession();
        try {
            session.beginTransaction();
            emp = (Empresas) session.get(Empresas.class, idEmpresa);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return emp;
    }

    public int eliminar(int idEmpresa) {
        session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            emp = (Empresas) session.get(Empresas.class, idEmpresa);
            session.delete(emp);
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
        List<Empresas> listaemp = null;
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Empresas");
            listaemp = (List<Empresas>) query.list();

        } catch (Exception e) {
            System.out.println("ERROR. " + e);
        } finally {
            
        }
        return listaemp;
    }

   public boolean modificarEmpresa(Empresas e) {
        boolean r = false;
        try {
            session.beginTransaction();
            session.update(e);
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
