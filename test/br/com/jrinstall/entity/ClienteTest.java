/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.entity;

import br.com.jrinstall.helper.HibernateFactory;
import br.com.jrinstall.service.ClienteService;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ClienteTest {

    private Cliente cliente;
    private ClienteService service;

    public ClienteTest() {
        HibernateFactory.OpenSessionFactory();
        service = new ClienteService();
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
    private Cliente novoCliente() {
        cliente = new Cliente();
        cliente.setNome("Fernando");
        cliente.setBairro(new Bairro(1));
        cliente.setCidade(new Cidade(1));
        cliente.setUsuarioCadastro("Teste");
        cliente.setDataCadastro(new Date());
       // List<ClienteTelefone> telefones = new ArrayList<>();
        ///telefones.add(new ClienteTelefone("99999999", new TelefoneOperadora(5)));
       // cliente.setTelefones(telefones);
        return cliente;
    }

    @Test
    public void testSaveCliente() {
        System.out.println("Save Cliente");
        cliente = new Cliente();
        cliente = novoCliente();
        service.Save(cliente);
        assertTrue(cliente.getIdCliente() != 0);
    }

    @Test
    public void testSaveTelefone() {
        System.out.println("Save Telefone");
        cliente = new Cliente();
        cliente = novoCliente();
        cliente.setNome("Data " + GregorianCalendar.getInstance().getTime());
        service.Save(cliente);

        ClienteTelefone telefone = new ClienteTelefone("(48) 30343988", new TelefoneOperadora(1));
        telefone.setIdCliente(cliente.getIdCliente());
        service.SaveTelefone(telefone);
        assertTrue(telefone.getIdTelefoneCliente() != 0);
    }

    @Test
    public void testGetClienteById() {
        System.out.println("Get Cliente by ID");
        cliente = new Cliente();
        cliente = (Cliente) service.getById(getIdClienteAleatorio());
        assertTrue(cliente != null);
    }

    @Test
    public void testGetClienteCompleto() {
        System.out.println("Get Cliente by ID");
        Map param = new HashMap();
        param.put("idCliente", getIdClienteAleatorio());
        cliente = (Cliente) service.getByNamedQuery("Cliente.findByIdCliente", param);
        System.out.println("Cidade" + cliente.getCidade().getDescricaoCidade());
        System.out.println("Bairro" + cliente.getBairro().getDescricaoBairro());
        System.out.println("Telefones e Operadore: " + cliente.getTelefones().size());
        for (ClienteTelefone telefone : cliente.getTelefones()) {
            System.out.println(telefone.getNumero() + " - : " + telefone.getOperadora().getDescricaoOperadora());
        }
        assertTrue(cliente != null);
    }

    private Integer getIdClienteAleatorio() {
        List clientes = new ArrayList();
        clientes = service.getListByHQL("Select c From Cliente c");
        Cliente obj = null;
        if (clientes.size() > 0) {
            obj = (Cliente) clientes.get(0);
        }
        return obj.getIdCliente();
    }

    @Test
    public void testUpdateCliente() {
        System.out.println("Update Cliente by ID");
        Integer id = getIdClienteAleatorio();
        cliente = new Cliente();
        cliente = (Cliente) service.getById(id);
        cliente.setNome("Cliente Alterado");
        service.Save(cliente);
        cliente = null;
        cliente = (Cliente) service.getById(id);
        assertTrue(cliente.getNome().equalsIgnoreCase("Cliente Alterado"));
    }

    @Test
    public void getListByHQLTest() {
        System.out.println("Get Cliente by HQL");
        cliente = new Cliente();
        List clientes = new ArrayList();
        clientes = service.getListByHQL("Select c From Cliente c where c.nome like '%Fernando%'");
        assertTrue(clientes.size() > 0);
    }

    //@Test
    public void DeleteClienteTest() {
        System.out.println("Get Cliente by ID");
        cliente = new Cliente(getIdClienteAleatorio());
        assertTrue(service.delete(cliente));
    }

}
