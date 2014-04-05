/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.Interface;

import java.util.List;

/**
 *
 * @author fernando
 */
public interface Action {

    Object Save(Object obj) ;

    Boolean delete(Object obj);

    List<Object> getListByHQL(String hql);

    Object getById(Integer id);

}
