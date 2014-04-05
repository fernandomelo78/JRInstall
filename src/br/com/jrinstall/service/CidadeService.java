/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jrinstall.service;

import br.com.jrinstall.Interface.Action;
import br.com.jrinstall.entity.Cidade;
import br.com.jrinstall.helper.HibernateHelper;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author fernando
 */
public class CidadeService implements Action{
    
       private Cidade cidade;


    @Override
    public Object Save(Object obj) throws  HibernateException{

        cidade = (Cidade) obj;

        try {

            cidade = (Cidade) HibernateHelper.saveOrUpdate(cidade);

        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar Cidade: " + ex.getMessage());
        }

        return cidade;
    }

    @Override
    public Boolean delete(Object obj) throws  HibernateException{
        cidade = (Cidade) obj;
        if ((cidade.getIdCidade()!= null)) {
            return HibernateHelper.delete(obj);
        } else {
            return false;
        }
    }

    @Override
    public List<Object> getListByHQL(String hql) throws  HibernateException{
        List clientes = new ArrayList();
        try {
            clientes = HibernateHelper.execHQL(hql);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Cidade.");
        }
        return clientes;
    }
    
    
    public List<Object> getListByNamedQuery(String query) throws  HibernateException{
        List clientes = new ArrayList();
        try {
            clientes = HibernateHelper.execQuery(query);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Cidade.");
        }
        return clientes;
    }


    @Override
    public Object getById(Integer id) throws  HibernateException{
        cidade = new Cidade();
        try {
            cidade = (Cidade) HibernateHelper.getById(Cidade.class, id);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Cidade.");
        }
        return cidade;
    }
    
}
