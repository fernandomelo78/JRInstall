/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.helper;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Fernando
 */
public class HibernateHelper {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory.isClosed()) {HibernateFactory.OpenSessionFactory();}
         return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory aSF) {
        sessionFactory = aSF;
    }

    public static Session getManagedSession(boolean forceTransaction) {
        Session s = sessionFactory.getCurrentSession();
        if (forceTransaction && !s.getTransaction().isActive()) {
            s.beginTransaction();
        }

        return s;
    }

    public static Session getManagedSession() {
        return getManagedSession(true);
    }

    public static Transaction getTransaction() {
        return getManagedSession(false).getTransaction();

    }

    public static List execQuery(String nameQuery) throws HibernateException {
        return execQuery(nameQuery, null);
    }

    public static List execQuery(String nameQuery, Map params) throws HibernateException {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.getNamedQuery(nameQuery);
            if (params != null && params.size() > 0) {
                Iterator itParamNames = params.keySet().iterator();
                while (itParamNames.hasNext()) {
                    String paramName = (String) itParamNames.next();
                    Object value = params.get(paramName);
                    query.setParameter(paramName, value);
                }
            }
            List retorno = query.list();
            tx.commit();
            return retorno;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw new HibernateException(hbe.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List execQuery(String nameQuery, Map params, int MaxResult) throws HibernateException {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.getNamedQuery(nameQuery);
            if (params != null && params.size() > 0) {
                Iterator itParamNames = params.keySet().iterator();
                while (itParamNames.hasNext()) {
                    String paramName = (String) itParamNames.next();
                    Object value = params.get(paramName);
                    query.setParameter(paramName, value);
                }
            }
            query.setMaxResults(MaxResult);
            List retorno = query.list();
            tx.commit();
            return retorno;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw new HibernateException(hbe.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static Object execNameQuery(String nameQuery, Map params) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.getNamedQuery(nameQuery);
            if (params != null && params.size() > 0) {
                Iterator itParamNames = params.keySet().iterator();
                while (itParamNames.hasNext()) {
                    String paramName = (String) itParamNames.next();
                    Object value = params.get(paramName);
                    query.setParameter(paramName, value);
                }
            }
            //List lista = query.list();
            Object retorno = query.uniqueResult();//lista.get(0);
            tx.commit();
            return retorno;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            MetodosUteis.showMsg("Consulta não foi executada.\n" + hbe.getMessage());
            //throw new HibernateException(hbe.getMessage());
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List execQuery(String nameQuery, Map params, Boolean closeSession) throws HibernateException {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.getNamedQuery(nameQuery);
            if (params != null && params.size() > 0) {
                Iterator itParamNames = params.keySet().iterator();
                while (itParamNames.hasNext()) {
                    String paramName = (String) itParamNames.next();
                    Object value = params.get(paramName);
                    query.setParameter(paramName, value);
                }
            }
            List retorno = query.list();
            tx.commit();
            return retorno;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw new HibernateException(hbe.getMessage());
        } finally {
            if (closeSession) {
                if (session != null) {
                    session.close();
                }
            }
        }
    }

    public static List execHQL(String hql) throws HibernateException {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            List retorno = query.list();
            tx.commit();
            return retorno;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw new HibernateException(hbe.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    

    public static Object save(Object obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
          
        } catch (HibernateException hbe) {
            //hbe.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
            MetodosUteis.showMsg("Erro: \n" + hbe.getMessage());

        } catch (Exception e) {
            MetodosUteis.showMsg("Erro de  Exception.\n" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return obj;
    }

    public static Boolean update(Object obj) {
        Session session = null;
        Transaction tx = null;
        Boolean saida = false;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            saida = true;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw new HibernateException(hbe.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return saida;
    }

    public static Object saveOrUpdate(Object obj) throws HibernateException{
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        }catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw  new HibernateException(hbe.getMessage());

        } catch (Exception e) {
            throw  new HibernateException(e.getMessage());
            //MetodosUteis.showMsg("Erro ao atualizar:" + e.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return obj;
    }

    public static Object getById(Class klass, Serializable id)
            throws HibernateException {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Object obj = session.get(klass, id);
            tx.commit();
            return obj;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw new HibernateException(hbe.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static Boolean delete(Object obj) throws HibernateException {
        Session session = null;
        Transaction tx = null;
        Boolean saida = false;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            saida = true;
        } catch (HibernateException hbe) {
            if (tx != null) {
                tx.rollback();
            }
            throw new HibernateException(hbe.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return saida;
    }
}
