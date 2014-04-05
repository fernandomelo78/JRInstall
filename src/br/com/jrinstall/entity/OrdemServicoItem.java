/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.entity;

import br.com.jrinstall.service.OrdemDeServicoService;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ordem_servico_item")
@NamedQueries({
    @NamedQuery(name = "OrdemServicoItem.findAll", query = "SELECT o FROM OrdemServicoItem o"),
    @NamedQuery(name = "OrdemServicoItem.findByIdOrdemServicoItem", query = "SELECT o FROM OrdemServicoItem o WHERE o.idOrdemServicoItem = :idOrdemServicoItem"),
    @NamedQuery(name = "OrdemServicoItem.findByIdMaterial", query = "SELECT o FROM OrdemServicoItem o WHERE o.material.idMaterial = :idMaterial")})
public class OrdemServicoItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdemServicoItem")
    private Integer idOrdemServicoItem;
    @JoinColumn(name = "idOrdemServico", referencedColumnName = "idOrdemServico")
    @ManyToOne
    private OrdemServico ordemServico;
    @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial")
    @ManyToOne
    private Material material;
    @Column(name = "Quantidade")
    private Integer quantidade;
    @Column(name = "Valor_unitario")
    private double valorUnitario;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private double valorTotal;

    public OrdemServicoItem() {
    }

    public OrdemServicoItem(Integer idOrdemServicoItem) {
        this.idOrdemServicoItem = idOrdemServicoItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getIdOrdemServicoItem() {
        return idOrdemServicoItem;
    }

    public void setIdOrdemServicoItem(Integer idOrdemServicoItem) {
        this.idOrdemServicoItem = idOrdemServicoItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemServicoItem != null ? idOrdemServicoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServicoItem)) {
            return false;
        }
        OrdemServicoItem other = (OrdemServicoItem) object;
        if ((this.idOrdemServicoItem == null && other.idOrdemServicoItem != null) || (this.idOrdemServicoItem != null && !this.idOrdemServicoItem.equals(other.idOrdemServicoItem))) {
            return false;
        }
        return true;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    @Override
    public String toString() {
        return "br.com.jrinstall.entity.OrdemServicoItem[ idOrdemServicoItem=" + idOrdemServicoItem + " ]";
    }

}
