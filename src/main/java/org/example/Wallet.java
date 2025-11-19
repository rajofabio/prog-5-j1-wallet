package org.example;



import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public final class Wallet {

    private String color;
    private double weight;
    private String brand;
    private double money;
    private List<String> cardHolder;
    private boolean isLost;

    public Wallet() {
        this.cardHolder = new ArrayList<>();
        this.money = 0.0;
        this.isLost = false;
    }


    public void addMoney(double amount) {
        if (isLost) {
            throw new IllegalStateException("The wallet is lost");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount: must be positive");
        }
        this.money += amount;
    }

    public boolean checkMoney(double amount) {
        if (isLost) {
            throw new IllegalStateException("The wallet is lost");
        }

        return this.money >= amount;
    }

    public void addCard(String cardName) {
        if (isLost) {
            throw new IllegalStateException("The wallet is lost");
        }
        this.cardHolder.add(cardName);
    }


    public void lost() {
        this.money = 0;
        this.cardHolder.clear();
        this.isLost = true;

    }

    public double getMoney() {
        if (isLost) {
            throw new IllegalStateException("The wallet is lost");
        }

        return money;
    }

    public List<String> getCardHolder() {
        if (isLost) {
            throw new IllegalStateException("The wallet is lost");
        }

        return cardHolder;
    }
}
