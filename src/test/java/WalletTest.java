

import org.example.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertEquals(100.0, wallet.getMoney(), 0.001);

        wallet.addMoney(-50);
        assertEquals(100.0, wallet.getMoney(), 0.001);
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
        List<String> cards = wallet.getCardHolder();
        assertEquals(2, cards.size());
        assertTrue(cards.contains("Visa"));
        assertTrue(cards.contains("MasterCard"));
    }

    @Test
    void testLostWallet() {
        wallet.addMoney(100);
        wallet.addCard("Visa");
        wallet.lost();


        assertEquals(0.0, wallet.getMoney(), 0.001, "Money should be 0 after lost");
        assertTrue(wallet.getCardHolder().isEmpty(), "Cards should be empty after lost");


        wallet.addMoney(50);
        wallet.addCard("CarteVisa");
        assertEquals(0.0, wallet.getMoney(), 0.001, "Money cannot be added after lost");
        assertTrue(wallet.getCardHolder().isEmpty(), "Cards cannot be added after lost");
        assertFalse(wallet.checkMoney(10), "Check money should return false after lost");
    }
}
