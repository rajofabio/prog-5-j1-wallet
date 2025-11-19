import org.example.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet();
        wallet.setColor("Black");
        wallet.setWeight(150);
        wallet.setBrand("Gucci");
    }

    @Test
    void testAddMoney() {
        wallet.addMoney(100);
        assertEquals(100, wallet.getMoney());

        // Test exception pour montant négatif
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            wallet.addMoney(-50);
        });
        assertEquals("Invalid amount: must be positive", exception.getMessage());
    }

    @Test
    void testCheckMoney() {
        wallet.addMoney(100);
        assertTrue(wallet.checkMoney(50));
        assertFalse(wallet.checkMoney(150));
    }

    @Test
    void testAddCard() {
        wallet.addCard("Visa");
        wallet.addCard("MasterCard");
        assertEquals(2, wallet.getCardHolder().size());
        assertTrue(wallet.getCardHolder().contains("Visa"));
        assertTrue(wallet.getCardHolder().contains("MasterCard"));
    }

}
