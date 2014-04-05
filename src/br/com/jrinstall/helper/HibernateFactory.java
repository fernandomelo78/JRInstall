/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Fernando
 */
public class HibernateFactory {
    
    
    public static void OpenSessionFactory() {
        try {
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            HibernateHelper.setSessionFactory(sf);
        } catch (Exception ex) {
            MetodosUteis.showMsg("Banco de Dados não localizado.\n" + ex.getMessage());
        }
    }
    
    public static void CloseSessionFactory() {
        SessionFactory sf = HibernateHelper.getSessionFactory();
        sf.close();
    }
}
