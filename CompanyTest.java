

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * A classe de teste CompanyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class CompanyTest
{
    private Company company;
    private User client1;
    private User client2;
    private User seller1;
    private User seller2;
    private Property property1;
    private Property property2;

    /**
     * Construtor default para a classe de teste CompanyTest
     */
    public CompanyTest()
    {
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        company = new Company();
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        property1 = new Property("Apartment", 100000);
        property2 = new Property("House", 200000);
    }
    
    @Test
    public void testConstructor() {
        assertNotNull(company.getClients()); // Verifica se a lista de clientes não é nula
        assertNotNull(company.getSellers()); // Verifica se a lista de vendedores não é nula
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testFindSellerOfTheYear() {
        // Crie uma instância da classe Company
        Company company = new Company();
        
        // Crie algumas vendas fictícias para o ano atual
        LocalDate currentDate = LocalDate.now();
        User client = new User("Cliente", "123456789", "cliente@example.com");
        User seller = new User("Vendedor", "987654321", "vendedor@example.com");
        Property property = new Property("Casa", 100000.0);
        
        // Adicione as vendas à empresa
        company.createSell(client, seller, property);
        
        // Encontre o vendedor do ano atual
        String sellerOfTheYear = company.findSellerOfTheYear(currentDate.getYear());
        
        // Verifique se o vendedor retornado não é nulo
        assertNotNull(sellerOfTheYear);
        
        // Verifique se o vendedor retornado é o vendedor correto
        assertEquals(seller.getName(), sellerOfTheYear);
    }
    
    
    
    @Test
    public void testCreateSell() {
        company.registerClient(client1);
        company.registerClient(client2);
        company.registerSeller(seller1);
        company.registerSeller(seller2);
        company.registerProperty(property1);
        company.registerProperty(property2);
        
        company.createSell(client1, seller1, property1);
        company.createSell(client2, seller2, property2);
        
        // Verifica se a venda foi criada corretamente
        assertTrue(company.getSells().size() == 2);
        assertTrue(company.getSells().contains(new Sell(client1, seller1, property1)));
        assertTrue(company.getSells().contains(new Sell(client2, seller2, property2)));
    }
    
    @Test
    public void testRegisterClient() {
        User client = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        company.registerClient(client);
        
        assertEquals(1, company.getClients().size());
        assertTrue(company.getClients().contains(client));
    }

    @Test
    public void testRegisterClients() {
        User client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        User client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        company.registerClient(client1);
        company.registerClient(client2);
        
        assertEquals(2, company.getClients().size());
        assertTrue(company.getClients().contains(client1));
        assertTrue(company.getClients().contains(client2));
    }
    

    
    @Test
    public void testRegisterClientDuplicate() {
        User client = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        
        // Registrar o cliente duas vezes
        company.registerClient(client);
        company.registerClient(client);
        
        // Verificar se há apenas uma entrada na lista de clientes
        assertEquals(1, company.getClients().size());
        
        // Verificar se o cliente registrado é o mesmo que tentamos registrar duas vezes
        assertTrue(company.getClients().contains(client));
    }
    
    @Test
    public void testCalculateSellsOfTheYear() {
        // Crie uma instância da classe Company
        Company company = new Company();
        
        // Crie algumas vendas fictícias para o ano atual
        LocalDate currentDate = LocalDate.now();
        User client = new User("Cliente", "123456789", "cliente@example.com");
        User seller = new User("Vendedor", "987654321", "vendedor@example.com");
        Property property = new Property("Casa", 100000.0);
        
        // Adicione as vendas à empresa
        company.createSell(client, seller, property);
        
        // Obtenha as vendas do ano atual
        int sellsOfYear = company.calculateSellsOfTheYear(Integer.valueOf(currentDate.getYear()));
        
        // Verifique se a lista de vendas não está vazia
        assertFalse(sellsOfYear==0);
        
        // Verifique se as vendas estão corretas
        assertEquals(1, sellsOfYear);

    }
    
    @Test
    public void testRegisterClientNull() {
        // Tentativa de registrar um cliente nulo
        company.registerClient(null);
        
        // Verificar se a lista de clientes está vazia
        assertTrue(company.getClients().isEmpty());
    }
 
}
