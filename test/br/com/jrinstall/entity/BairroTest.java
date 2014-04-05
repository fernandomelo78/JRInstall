/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.entity;

import br.com.jrinstall.helper.HibernateFactory;
import br.com.jrinstall.service.BairroService;
import br.com.jrinstall.service.CidadeService;
import br.com.jrinstall.service.ClienteService;
import java.util.ArrayList;
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
public class BairroTest {

    private Bairro bairro;
    private BairroService service;

    public BairroTest() {
        HibernateFactory.OpenSessionFactory();
        service = new BairroService();
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
    private Bairro novoBairro() {
        bairro = new Bairro();

        bairro.setDescricaoBairro("Roçado");

        return bairro;
    }

    @Test
    public void testSaveBairro() {
        System.out.println("Save Bairro");
        bairro = new Bairro();
        bairro = novoBairro();
        service.Save(bairro);
        assertTrue(bairro.getIdBairro() != 0);
    }

    @Test
    public void testGetBairroById() {
        System.out.println("Get Bairro by ID");
        bairro = new Bairro();
        bairro = (Bairro) service.getById(2);
        assertTrue(bairro != null);
    }

    @Test
    public void testUpdateBairro() {
        System.out.println("Update Bairro by ID");
        bairro = new Bairro();
        List bairros = new ArrayList();
        bairros = service.getListByHQL("Select b From Bairro b order by b.idBairro");

        bairro = (Bairro) bairros.get((bairros.size() - 1));
        bairro.setDescricaoBairro("R Alterado");
        service.Save(bairro);
        bairro = null;
        bairro = (Bairro) bairros.get((bairros.size() - 1));
        bairro = (Bairro) service.getById(bairro.getIdBairro());
        assertTrue(bairro.getDescricaoBairro().equalsIgnoreCase("R Alterado"));
    }

    @Test
    public void getListByHQLTest() {
        System.out.println("Get Bairro by HQL");
        bairro = new Bairro();
        List bairros = new ArrayList();
        bairros = service.getListByHQL("Select b From Bairro b where b.descricaoBairro like '% %'");
        assertTrue(bairros.size() > 0);
    }

   @Test
    public void DeleteBairroTest() {
        System.out.println("Get Bairro by ID");
        bairro = new Bairro();
        List bairros = new ArrayList();
        bairros = service.getListByHQL("Select b From Bairro b order by b.idBairro");

        bairro = (Bairro) bairros.get((bairros.size() - 1));
        
        assertTrue(service.delete(bairro));
    }

}
