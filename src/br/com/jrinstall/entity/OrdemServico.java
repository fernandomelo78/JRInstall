/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



/**
 *
 * @author fernando
 */
@Entity
@Table(name = "ordem_servico")
@NamedQueries({
    @NamedQuery(name = "OrdemServico.findAll", query = "SELECT o FROM OrdemServico o"),
    @NamedQuery(name = "OrdemServico.findByIdOrdemServico", query = "SELECT o FROM OrdemServico o WHERE o.idOrdemServico = :idOrdemServico"),
    @NamedQuery(name = "OrdemServico.findByFinalizado", query = "SELECT o FROM OrdemServico o WHERE o.finalizado = :finalizado")})
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdemServico")
    private Integer idOrdemServico;
    //@Column(name = "idCliente")
    //private Integer idCliente;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne
    private Cliente cliente;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "data_execucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExecucao;
    @Column(name = "Termino_garantia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminogarantia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor_servico")
    private Double valorservico;
    @Lob
    @Column(name = "OBS_OS")
    private String obsOs;
    @Basic(optional = false)
    @Column(name = "finalizado")
    private boolean finalizado;
    @JoinColumn(name = "idTipoServico", referencedColumnName = "idTipoServico")
    @ManyToOne
    private TipoServico TipoServico;
        @Column(name = "UsuarioCadastro")
    private String usuarioCadastro;

    @OneToMany(mappedBy = "ordemServico", fetch = FetchType.EAGER)
    private List<OrdemServicoItem> ordemServicoItemList;

   // @Transient
    // private Cliente cliente;
    public OrdemServico() {
    }

    public OrdemServico(Integer idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public OrdemServico(Integer idOrdemServico, boolean finalizado) {
        this.idOrdemServico = idOrdemServico;
        this.finalizado = finalizado;
    }

    public Integer getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(Integer idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Date getTerminogarantia() {
        return terminogarantia;
    }

    public void setTerminogarantia(Date terminogarantia) {
        this.terminogarantia = terminogarantia;
    }

    public Double getValorservico() {
        return valorservico;
    }

    public void setValorservico(Double valorservico) {
        this.valorservico = valorservico;
    }

    public String getObsOs() {
        return obsOs;
    }

    public void setObsOs(String obsOs) {
        this.obsOs = obsOs;
    }

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public TipoServico getTipoServico() {
        return TipoServico;
    }

    public void setTipoServico(TipoServico TipoServico) {
        this.TipoServico = TipoServico;
    }

    public List<OrdemServicoItem> getOrdemServicoItemList() {
        return ordemServicoItemList;
    }

    public void setOrdemServicoItemList(List<OrdemServicoItem> ordemServicoItemList) {
        this.ordemServicoItemList = ordemServicoItemList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemServico != null ? idOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        if ((this.idOrdemServico == null && other.idOrdemServico != null) || (this.idOrdemServico != null && !this.idOrdemServico.equals(other.idOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idOrdemServico.toString();
    }
    
        public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }


}
