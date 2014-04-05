/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jrinstall.service;

import br.com.jrinstall.Interface.Action;
import br.com.jrinstall.entity.Bairro;
import br.com.jrinstall.entity.Cidade;
import br.com.jrinstall.helper.HibernateHelper;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author fernando
 */
public class BairroService implements Action{
    
     private Bairro bairro;


    @Override
    public Object Save(Object obj) throws  HibernateException{

        bairro = (Bairro) obj;

        try {

            bairro = (Bairro) HibernateHelper.saveOrUpdate(bairro);

        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar Bairro: " + ex.getMessage());
        }

        return bairro;
    }

    @Override
    public Boolean delete(Object obj) throws  HibernateException{
        bairro = (Bairro) obj;
        if ((bairro.getIdBairro()!= null)) {
            return HibernateHelper.delete(obj);
        } else {
            return false;
        }
    }

    @Override
    public List<Object> getListByHQL(String hql) throws  HibernateException{
        List bairros = new ArrayList();
        try {
            bairros = HibernateHelper.execHQL(hql);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Bairro.");
        }
        return bairros;
    }

    @Override
    public Object getById(Integer id) throws  HibernateException{
        bairro = new Bairro();
        try {
            bairro = (Bairro) HibernateHelper.getById(Bairro.class, id);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Bairro.");
        }
        return bairro;
    }
    
    
}
