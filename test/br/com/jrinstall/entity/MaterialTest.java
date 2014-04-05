/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.entity;

import br.com.jrinstall.helper.HibernateFactory;
import br.com.jrinstall.service.CidadeService;
import br.com.jrinstall.service.MaterialService;
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
public class MaterialTest {

    private Material material;
    List materiais = new ArrayList();
    private MaterialService service;

    public MaterialTest() {
        HibernateFactory.OpenSessionFactory();
        service = new MaterialService();
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
    private Material novoMaterial() {
        material = new Material();
        material.setDescricaomaterial("Mão de Obra :" + GregorianCalendar.getInstance().getTime());
        material.setValorPadrao(80.32);
        return material;
    }

    @Test
    public void testSaveMaterial() {
        System.out.println("Save Material");
        material = new Material();
        material = novoMaterial();
        service.Save(material);
        assertTrue(material.getIdMaterial() != 0);
    }

    @Test
    public void testGetMaterialById() {
        System.out.println("Get Material by ID");
        materiais = new ArrayList();
        materiais = service.getListByHQL("Select m From Material m order by m.idMaterial");
        material = (Material) materiais.get((materiais.size() - 1));
        Material material1 = new Material();
        material1 = (Material) service.getById(material.getIdMaterial());
        assertTrue(material1.getIdMaterial() != null);
    }

    @Test
    public void testUpdateMaterial() {
        System.out.println("Update Material by ID");
        material = new Material();
        materiais = new ArrayList();
        materiais = service.getListByHQL("Select m From Material m order by m.idMaterial");

        material = (Material) materiais.get((materiais.size() - 1));
        material.setDescricaomaterial("Material Alterado");
        service.Save(material);
        material = null;
        material = (Material) materiais.get((materiais.size() - 1));
        material = (Material) service.getById(material.getIdMaterial());
        assertTrue(material.getDescricaomaterial().equalsIgnoreCase("Material Alterado"));
    }

    @Test
    public void getListByHQLTest() {
        System.out.println("Get Material Alterado by HQL");
        material = new Material();
        materiais = new ArrayList();
        materiais = service.getListByHQL("Select m From Material m where m.descricaomaterial like '% %'");
        assertTrue(materiais.size() > 0);
    }

    @Test
    public void DeleteMaterialTest() {
        System.out.println("Delete Material");
        material = new Material();
        material = novoMaterial();
        service.Save(material);
        assertTrue(service.delete(material));
    }

}
