package br.com.jrinstall.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.jrinstall.entity.*;
import br.com.jrinstall.helper.HibernateFactory;
import br.com.jrinstall.service.MaterialService;
import br.com.jrinstall.service.TipoDeServicoService;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernando
 */
public class TipoDeServicoTest {

    private TipoServico tipoServico;
    List lista = new ArrayList();
    private TipoDeServicoService service;

    public TipoDeServicoTest() {
        HibernateFactory.OpenSessionFactory();
        service = new TipoDeServicoService();
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
    private TipoServico novoTipoServico() {
        tipoServico = new TipoServico();
        tipoServico.setDescricaoTipoServico("Visita Técnica :" + GregorianCalendar.getInstance().getTime());
        return tipoServico;
    }

    @Test
    public void testSaveTipoServico() {
        System.out.println("Save TipoServico");
        tipoServico = new TipoServico();
        tipoServico = novoTipoServico();
        service.Save(tipoServico);
        assertTrue(tipoServico.getIdTipoServico() != 0);
    }

    @Test
    public void testGetTipoServicoById() {
        System.out.println("Get TipoServico by ID");
        lista = new ArrayList();
        lista = service.getListByHQL("Select tp From TipoServico tp order by tp.idTipoServico");
        tipoServico = (TipoServico) lista.get((lista.size() - 1));
        TipoServico tp = new TipoServico();
        tp = (TipoServico) service.getById(tipoServico.getIdTipoServico());
        assertTrue(tp.getIdTipoServico() != null);
    }

    @Test
    public void testUpdateTipoServico() {
        System.out.println("Update TipoServico by ID");
        tipoServico = new TipoServico();
        lista = new ArrayList();
        lista = service.getListByHQL("Select tp From TipoServico tp order by tp.idTipoServico");

        tipoServico = (TipoServico) lista.get((lista.size() - 1));
        tipoServico.setDescricaoTipoServico("Tipo Serviço Alterado");
        service.Save(tipoServico);
        tipoServico = null;
        tipoServico = (TipoServico) lista.get((lista.size() - 1));
        tipoServico = (TipoServico) service.getById(tipoServico.getIdTipoServico());
        assertTrue(tipoServico.getDescricaoTipoServico().equalsIgnoreCase("Tipo Serviço Alterado"));
    }

    @Test
    public void getListByHQLTest() {
        System.out.println("Get Tipo Serviço by HQL");
        tipoServico = new TipoServico();
        lista = new ArrayList();
        lista = service.getListByHQL("Select tp From TipoServico tp where tp.descricaoTipoServico like '% %'");
        assertTrue(lista.size() > 0);
    }

    @Test
    public void DeleteMaterialTest() {
        System.out.println("Delete TipoServico");
        tipoServico = novoTipoServico();
        service.Save(tipoServico);

        assertTrue(service.delete(tipoServico));
    }

}
