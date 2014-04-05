/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jrinstall.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "tipo_servico")
@NamedQueries({
    @NamedQuery(name = "TipoServico.findAll", query = "SELECT t FROM TipoServico t"),
    @NamedQuery(name = "TipoServico.findByIdTipoServico", query = "SELECT t FROM TipoServico t WHERE t.idTipoServico = :idTipoServico")})
public class TipoServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoServico")
    private Integer idTipoServico;
    @Column(name = "descricao_tipo_servico")
    private String descricaoTipoServico;
    @OneToMany(mappedBy = "TipoServico")
    private List<OrdemServico> ordemServicoList;

    public TipoServico() {
    }

    public TipoServico(Integer idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

    public Integer getIdTipoServico() {
        return idTipoServico;
    }

    public void setIdTipoServico(Integer idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

    public String getDescricaoTipoServico() {
        return descricaoTipoServico;
    }

    public void setDescricaoTipoServico(String descricaoTipoServico) {
        this.descricaoTipoServico = descricaoTipoServico;
    }

    public List<OrdemServico> getOrdemServicoList() {
        return ordemServicoList;
    }

    public void setOrdemServicoList(List<OrdemServico> ordemServicoList) {
        this.ordemServicoList = ordemServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServico != null ? idTipoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServico)) {
            return false;
        }
        TipoServico other = (TipoServico) object;
        if ((this.idTipoServico == null && other.idTipoServico != null) || (this.idTipoServico != null && !this.idTipoServico.equals(other.idTipoServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricaoTipoServico;
    }
    
}
