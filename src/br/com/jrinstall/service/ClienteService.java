package br.com.jrinstall.service;

import br.com.jrinstall.Interface.Action;
import br.com.jrinstall.entity.Cliente;
import br.com.jrinstall.entity.ClienteTelefone;
import br.com.jrinstall.entity.TelefoneOperadora;
import br.com.jrinstall.helper.HibernateHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando
 */
public class ClienteService implements Action {

    private Cliente cliente;
    private List<ClienteTelefone> telefones;

    @Override
    public Object Save(Object obj) throws HibernateException {
        cliente = (Cliente) obj;
        try {
            cliente = (Cliente) HibernateHelper.saveOrUpdate(cliente);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar cliente: " + ex.getMessage());
        }

        return cliente;
    }

    public Object SaveTelefone(Object obj) throws HibernateException {

        ClienteTelefone telefone = (ClienteTelefone) obj;

        try {

            telefone = (ClienteTelefone) HibernateHelper.saveOrUpdate(telefone);

        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar Telefone do cliente: " + ex.getMessage());
        }

        return cliente;
    }

    @Override
    public Boolean delete(Object obj) throws HibernateException {
        if (obj instanceof Cliente) {
            cliente = (Cliente) obj;
            if ((cliente.getIdCliente() != null)) {
                return HibernateHelper.delete(obj);
            } else {
                return false;
            }
        } else {
            ClienteTelefone telefone = (ClienteTelefone) obj;
            if ((telefone.getIdTelefoneCliente() != null)) {
                return HibernateHelper.delete(obj);
            } else {
                return false;
            }

        }

    }

    @Override
    public List<Object> getListByHQL(String hql) throws HibernateException {
        List clientes = new ArrayList();
        try {
            clientes = HibernateHelper.execHQL(hql);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o cliente.");
        }
        return clientes;
    }

    @Override
    public Object getById(Integer id) throws HibernateException {
        cliente = new Cliente();
        try {
            cliente = (Cliente) HibernateHelper.getById(Cliente.class, id);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o cliente.");
        }
        return cliente;
    }


    public Object getByNamedQuery(String nameQuery, Map param) throws HibernateException {
        cliente = new Cliente();
        try {
            cliente = (Cliente) HibernateHelper.execNameQuery(nameQuery, param);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o cliente.");
        }
        return cliente;
    }

    public List<TelefoneOperadora> getListaOperadoras() throws HibernateException {
        List<TelefoneOperadora> operadoras = new ArrayList();
        try {
            operadoras = HibernateHelper.execHQL("SELECT t FROM TelefoneOperadora t");
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o cliente.");
        }
        return operadoras;
    }

}
