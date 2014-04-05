/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.service;

import br.com.jrinstall.Interface.Action;
import br.com.jrinstall.entity.Cliente;
import br.com.jrinstall.entity.Material;
import br.com.jrinstall.entity.OrdemServico;
import br.com.jrinstall.entity.OrdemServicoItem;
import br.com.jrinstall.helper.HibernateHelper;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author fernando
 */
public class OrdemDeServicoService implements Action {

    private OrdemServico ordemServico;
    private OrdemServicoItem item;
    private Cliente cliente;

    public OrdemDeServicoService() {
    
    
    }

    @Override
    public Object Save(Object obj) throws HibernateException {
        ordemServico = (OrdemServico) obj;
        try {
            ordemServico = (OrdemServico) HibernateHelper.saveOrUpdate(ordemServico);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar Ordem de Serviço: " + ex.getMessage());
        }
        return ordemServico;
    }

    public OrdemServicoItem SaveItem(OrdemServicoItem item) throws HibernateException {
        try {
            item = (OrdemServicoItem) HibernateHelper.saveOrUpdate(item);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar Ordem de Serviço: " + ex.getMessage());
        }
        return item;
    }

    @Override
    public Boolean delete(Object obj) throws HibernateException{
        try {
            return HibernateHelper.delete(obj);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao excluir: " + ex.getMessage());
        }    
    }
    
    @Override
    public List<Object> getListByHQL(String hql) throws HibernateException{
        List lista = new ArrayList();
        try {
            lista = HibernateHelper.execHQL(hql);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Ordem de serviço.");
        }
        return lista;
    }

    @Override
    public Object getById(Integer id) {
        ordemServico = new OrdemServico();
        try {
            ordemServico = (OrdemServico) HibernateHelper.getById(OrdemServico.class, id);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Ordem de Serviço.");
        }
        return ordemServico;
    }

}
