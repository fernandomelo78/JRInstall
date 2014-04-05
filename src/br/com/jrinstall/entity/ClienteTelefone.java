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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "cliente_telefone")
@NamedQueries({
    @NamedQuery(name = "ClienteTelefone.findAll", query = "SELECT c FROM ClienteTelefone c"),
    @NamedQuery(name = "ClienteTelefone.findByIdTelefoneCliente", query = "SELECT c FROM ClienteTelefone c WHERE c.idTelefoneCliente = :idTelefoneCliente"),
    @NamedQuery(name = "ClienteTelefone.findByNumero", query = "SELECT c FROM ClienteTelefone c WHERE c.numero = :numero")})
public class ClienteTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefoneCliente")
    private Integer idTelefoneCliente;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
     @JoinColumn(name = "idOperadoraTelefone", referencedColumnName = "idOperadoraTelefone")
    @ManyToOne(fetch = FetchType.EAGER)
     private TelefoneOperadora operadora;
     
    @Column(name = "idCliente")
    private Integer idCliente;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

     
   

    public ClienteTelefone() {
    }

    public ClienteTelefone(String nr, TelefoneOperadora op) {
        numero=nr;
        operadora = op;
        
    }

    public ClienteTelefone(Integer idTelefoneCliente, String numero) {
        this.idTelefoneCliente = idTelefoneCliente;
        this.numero = numero;
    }

    public Integer getIdTelefoneCliente() {
        return idTelefoneCliente;
    }

    public void setIdTelefoneCliente(Integer idTelefoneCliente) {
        this.idTelefoneCliente = idTelefoneCliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefoneCliente != null ? idTelefoneCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTelefone)) {
            return false;
        }
        ClienteTelefone other = (ClienteTelefone) object;
        if ((this.idTelefoneCliente == null && other.idTelefoneCliente != null) || (this.idTelefoneCliente != null && !this.idTelefoneCliente.equals(other.idTelefoneCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.jrinstall.entity.ClienteTelefone[ idTelefoneCliente=" + idTelefoneCliente + " ]";
    }

    public TelefoneOperadora getOperadora() {
        return operadora;
    }

    public void setOperadora(TelefoneOperadora operadora) {
        this.operadora = operadora;
    }

    

}
