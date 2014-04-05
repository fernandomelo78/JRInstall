/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jrinstall.service;

import br.com.jrinstall.Interface.Action;
import br.com.jrinstall.entity.Material;
import br.com.jrinstall.entity.TipoServico;
import br.com.jrinstall.helper.HibernateHelper;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author fernando
 */
public class TipoDeServicoService implements Action{
    
     private TipoServico tipoDeServico;


    @Override
    public Object Save(Object obj) throws  HibernateException{

        tipoDeServico = (TipoServico) obj;

        try {

            tipoDeServico = (TipoServico) HibernateHelper.saveOrUpdate(tipoDeServico);

        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar TipoServico: " + ex.getMessage());
        }

        return tipoDeServico;
    }

    @Override
    public Boolean delete(Object obj) throws  HibernateException{
        tipoDeServico = (TipoServico) obj;
        if ((tipoDeServico.getIdTipoServico()!= null)) {
            return HibernateHelper.delete(obj);
        } else {
            return false;
        }
    }

    @Override
    public List<Object> getListByHQL(String hql) throws  HibernateException{
        List materiais = new ArrayList();
        try {
            materiais = HibernateHelper.execHQL(hql);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o TipoServico.");
        }
        return materiais;
    }

    @Override
    public Object getById(Integer id) throws  HibernateException{
        tipoDeServico = new TipoServico();
        try {
            tipoDeServico = (TipoServico) HibernateHelper.getById(TipoServico.class, id);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o TipoServico.");
        }
        return tipoDeServico;
    }
    
}
