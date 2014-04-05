/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.entity;

import br.com.jrinstall.helper.HibernateFactory;
import br.com.jrinstall.service.ClienteService;
import br.com.jrinstall.service.MaterialService;
import br.com.jrinstall.service.OrdemDeServicoService;
import br.com.jrinstall.service.TipoDeServicoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class OrdemDeServicoTest {

    private OrdemServico ordemDeServico;
    private OrdemServicoItem item;
    private OrdemDeServicoService service;
    private ClienteService clienteService;
    private Cliente cliente;
    private List lista;

    public OrdemDeServicoTest() {
        HibernateFactory.OpenSessionFactory();
        service = new OrdemDeServicoService();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBairro method, of class Cliente.
     */
    private OrdemServico novaOrdemServico(Cliente cliente, TipoServico tipoServico) {
        ordemDeServico = new OrdemServico();
        ordemDeServico.setCliente(cliente);
        ordemDeServico.setTipoServico(tipoServico);
        ordemDeServico.setDataCadastro(new GregorianCalendar().getTime());
        ordemDeServico.setObsOs("Teste de cadastro");
        ordemDeServico.setValorservico(0.0);
        ordemDeServico.setFinalizado(false);
        return ordemDeServico;
    }

    private OrdemServicoItem novoItem(OrdemServico ordemServico, Material material) {
        item = new OrdemServicoItem();
        item.setOrdemServico(ordemServico);
        item.setMaterial(material);
        item.setValorUnitario(material.getValorPadrao());
        return item;
    }

    private Cliente novoCliente() {
        cliente = new Cliente();
        cliente.setNome("Fernando");
        cliente.setBairro(new Bairro(1));
        cliente.setCidade(new Cidade(1));
        cliente.setUsuarioCadastro("Teste");
        cliente.setDataCadastro(new Date());
        clienteService = new ClienteService();
        clienteService.Save(cliente);
        return cliente;
    }

    private TipoServico novoTipoServico() {
        TipoServico ts = new TipoServico();
        ts.setDescricaoTipoServico("Visita Técnica :" + GregorianCalendar.getInstance().getTime());
        TipoDeServicoService TSS = new TipoDeServicoService();
        TSS.Save(ts);
        return ts;
    }

    private Material novoMaterial() {
        Material m = new Material();
        m.setDescricaomaterial("Material :" + GregorianCalendar.getInstance().getTime());
        m.setValorPadrao(7.38d);
        MaterialService ms = new MaterialService();
        ms.Save(m);
        return m;
    }

    @Test
    public void testSaveOrdemServico() {
        System.out.println("Save Ordem de Servico");

        ordemDeServico = novaOrdemServico(novoCliente(), novoTipoServico());
        clienteService = new ClienteService();
        service.Save(ordemDeServico);
        assertTrue(ordemDeServico.getIdOrdemServico() != 0);
    }

    @Test
    public void testSaveOrdemServicoItem() {
        System.out.println("Save Item Ordem de Servico");

        ordemDeServico = novaOrdemServico(novoCliente(), novoTipoServico());
        clienteService = new ClienteService();
        service.Save(ordemDeServico);
        Material m = new Material();
        m = novoMaterial();
        item = novoItem(ordemDeServico, m);
        service.SaveItem(item);
        assertTrue(item.getIdOrdemServicoItem() != 0);
    }

    @Test
    public void testGetNamedQuery() {
        lista = new ArrayList();
        lista = service.getListByHQL("SELECT o FROM OrdemServico o");
        assertTrue(lista.size() >= 0);
    }

    @Test
    public void testGetById() {
        ordemDeServico = novaOrdemServico(novoCliente(), novoTipoServico());
        clienteService = new ClienteService();
        service.Save(ordemDeServico);
        Material m = new Material();
        m = novoMaterial();
        item = novoItem(ordemDeServico, m);
        service.SaveItem(item);

        lista = new ArrayList();
        lista = service.getListByHQL("SELECT o FROM OrdemServico o");

        ordemDeServico = new OrdemServico();
        ordemDeServico = (OrdemServico) lista.get(lista.size() - 1);
        ordemDeServico = (OrdemServico) service.getById(ordemDeServico.getIdOrdemServico());
        for (OrdemServicoItem item : ordemDeServico.getOrdemServicoItemList()) {
            System.out.println("Item: " + item.getValorUnitario());
        }
        assertTrue(lista.size() >= 0);
    }

}
