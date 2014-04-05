/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jrinstall.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "operadora_telefone")
@NamedQueries({
    @NamedQuery(name = "TelefoneOperadora.findAll", query = "SELECT t FROM TelefoneOperadora t"),
    @NamedQuery(name = "TelefoneOperadora.findByIdOperadoraTelefone", query = "SELECT t FROM TelefoneOperadora t WHERE t.idOperadoraTelefone = :idOperadoraTelefone"),
    @NamedQuery(name = "TelefoneOperadora.findByDescricaoOperadora", query = "SELECT t FROM TelefoneOperadora t WHERE t.descricaoOperadora = :descricaoOperadora")})
public class TelefoneOperadora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperadoraTelefone")
    private Integer idOperadoraTelefone;
    @Basic(optional = false)
    @Column(name = "descricao_operadora")
    private String descricaoOperadora;


    public TelefoneOperadora() {
    }

    public TelefoneOperadora(Integer idOperadoraTelefone) {
        this.idOperadoraTelefone = idOperadoraTelefone;
    }

    public TelefoneOperadora(Integer idOperadoraTelefone, String descricaoOperadora) {
        this.idOperadoraTelefone = idOperadoraTelefone;
        this.descricaoOperadora = descricaoOperadora;
    }

    public Integer getIdOperadoraTelefone() {
        return idOperadoraTelefone;
    }

    public void setIdOperadoraTelefone(Integer idOperadoraTelefone) {
        this.idOperadoraTelefone = idOperadoraTelefone;
    }

    public String getDescricaoOperadora() {
        return descricaoOperadora;
    }

    public void setDescricaoOperadora(String descricaoOperadora) {
        this.descricaoOperadora = descricaoOperadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperadoraTelefone != null ? idOperadoraTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneOperadora)) {
            return false;
        }
        TelefoneOperadora other = (TelefoneOperadora) object;
        if ((this.idOperadoraTelefone == null && other.idOperadoraTelefone != null) || (this.idOperadoraTelefone != null && !this.idOperadoraTelefone.equals(other.idOperadoraTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jrinstall.entity.TelefoneOperadora[ idOperadoraTelefone=" + idOperadoraTelefone + " ]";
    }
    
}
