

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste PropertyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class PropertyTest
{
    /**
     * Construtor default para a classe de teste PropertyTest
     */
    public PropertyTest()
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
    }
    
    @Test
    public void testConstructor() {
        Property property1 = new Property("T3 Monte Belo", 150000.0);
        
        assertEquals("T3 Monte Belo", property1.getDescription());
        assertEquals(150000.0, property1.getPrice(), 0.001);

    }
    
    @Test
    public void testToString() {
        Property property = new Property();
        property.setDescription("Casa espaçosa");
        property.setPrice(100000); // Supondo que o preço seja 100000 euros

        String expected = "Descrição: Casa espaçosa\nPreço: 100000 Euros";
        String actual = property.toString();

        assertEquals(expected, actual.replace(".0", "")); // Remover ".0" para lidar com a formatação do preço
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
}
