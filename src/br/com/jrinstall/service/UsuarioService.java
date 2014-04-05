/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.service;

import br.com.jrinstall.Interface.Action;
import br.com.jrinstall.entity.Usuario;
import br.com.jrinstall.helper.HibernateHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
public class UsuarioService implements Action {

    private Usuario usuario;
    private Map param;

    @Override
    public Object Save(Object obj) {
        usuario = (Usuario) obj;

        if (null != usuario.getIdUsuario()) {
            return HibernateHelper.save(usuario);
        } else {
            if (UsuarioExiste(usuario)) {
                return false;
            } else {
                return HibernateHelper.saveOrUpdate(usuario);
            }
        }
    }

    public boolean validaLogin(Usuario usuario) {
        Usuario user = new Usuario();
        param = new HashMap();
        param.put("usuario", usuario.getUsuario());
        param.put("senha", usuario.getSenha());

        user = (Usuario) HibernateHelper.execNameQuery("Usuario.findByLogin", param);
        if (user != null) {
            usuario.setIdUsuario(user.getIdUsuario());
            usuario.setAdministrador(user.getAdministrador());
        }
        return (user != null ? true : false);
    }

    public boolean UsuarioExiste(Usuario usuario) {
        param = new HashMap();
        param.put("usuario", usuario.getUsuario());

        return (HibernateHelper.execNameQuery("Usuario.findByUsuario", param) != null ? true : false);
    }

    public List<Object> getList() {
        return HibernateHelper.execQuery("Usuario.findAll");
    }

    @Override
    public Boolean delete(Object obj) {
        Usuario user = (Usuario) obj;
        return HibernateHelper.delete(user);
    }

    @Override
    public List<Object> getListByHQL(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
