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

        // tester montant négatif
        assertThrows(IllegalArgumentException.class, () -> wallet.addMoney(-50));
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

    @Test
    void testLostWallet() {
        wallet.addMoney(100);
        wallet.addCard("Visa");

        wallet.lost();


        assertThrows(IllegalStateException.class, () -> wallet.getMoney());
        assertThrows(IllegalStateException.class, () -> wallet.getCardHolder());
        assertThrows(IllegalStateException.class, () -> wallet.addMoney(50));
        assertThrows(IllegalStateException.class, () -> wallet.addCard("MasterCard"));
        assertThrows(IllegalStateException.class, () -> wallet.checkMoney(10));
    }
}
