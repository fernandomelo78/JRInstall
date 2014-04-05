/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jrinstall.service;

import br.com.jrinstall.Interface.Action;
import br.com.jrinstall.entity.Material;
import br.com.jrinstall.helper.HibernateHelper;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author fernando
 */
public class MaterialService implements Action{
    
     private Material material;


    @Override
    public Object Save(Object obj) throws  HibernateException{

        material = (Material) obj;

        try {

            material = (Material) HibernateHelper.saveOrUpdate(material);

        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao salvar Material: " + ex.getMessage());
        }

        return material;
    }

    @Override
    public Boolean delete(Object obj) throws  HibernateException{
        material = (Material) obj;
        if ((material.getIdMaterial()!= null)) {
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
            throw new HibernateException("Erro ao consulta o Material.");
        }
        return materiais;
    }

    @Override
    public Object getById(Integer id) throws  HibernateException{
        material = new Material();
        try {
            material = (Material) HibernateHelper.getById(Material.class, id);
        } catch (HibernateException ex) {
            throw new HibernateException("Erro ao consulta o Material.");
        }
        return material;
    }
    
}
