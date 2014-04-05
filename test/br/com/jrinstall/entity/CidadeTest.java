/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.entity;

import br.com.jrinstall.helper.HibernateFactory;
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
public class CidadeTest {

    private Cidade cidade;
    private CidadeService service;

    public CidadeTest() {
        HibernateFactory.OpenSessionFactory();
        service = new CidadeService();
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
    private Cidade novaCidade() {
        cidade = new Cidade();

        cidade.setDescricaoCidade("São José");

        return cidade;
    }

    @Test
    public void testSaveCidade() {
        System.out.println("Save Cidade");
        cidade = new Cidade();
        cidade = novaCidade();
        service.Save(cidade);
        assertTrue(cidade.getIdCidade() != 0);
    }

    @Test
    public void testGetCidadeById() {
        System.out.println("Get Cidade by ID");
        cidade = new Cidade();
        cidade = (Cidade) service.getById(2);
        assertTrue(cidade != null);
    }

    @Test
    public void testUpdateCidade() {
        System.out.println("Update Cidade by ID");
        cidade = new Cidade();
                List cidades = new ArrayList();
        cidades = service.getListByHQL("Select c From Cidade c order by c.idCidade");
        
        cidade = (Cidade) cidades.get((cidades.size() - 1));
        cidade.setDescricaoCidade("SJ Alterada");
        service.Save(cidade);
        cidade = null;
        cidade = (Cidade) cidades.get((cidades.size() - 1));
        cidade = (Cidade) service.getById(cidade.getIdCidade());
        assertTrue(cidade.getDescricaoCidade().equalsIgnoreCase("SJ Alterada"));
    }

    @Test
    public void getListByHQLTest() {
        System.out.println("Get SJ Alterada by HQL");
        cidade = new Cidade();
        List cidades = new ArrayList();
        cidades = service.getListByHQL("Select c From Cidade c where c.descricaoCidade like '% %'");
        assertTrue(cidades.size() > 0);
    }

    @Test
    public void DeleteCidadeTest() {
        System.out.println("Get Cidade by ID");
        cidade = new Cidade(4);
        assertTrue(service.delete(cidade));
    }

}
