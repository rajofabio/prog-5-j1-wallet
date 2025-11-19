package org.example;


public class Main {
    public static void main(String[] args) {

        Wallet wallet = new Wallet();
        wallet.setColor("Black");
        wallet.setWeight(150);
        wallet.setBrand("Gucci");

        System.out.println(" Wallet Created ");
        System.out.println(wallet);

        wallet.addMoney(100);
        System.out.println("\nAfter adding 100:");
        System.out.println("Balance: " + wallet.getMoney());

        System.out.println("\nChecking balance:");
        System.out.println("At least 50? " + wallet.checkMoney(50));
        System.out.println("At least 150? " + wallet.checkMoney(150));

        wallet.addCard("Visa");
        wallet.addCard("CIN");
        wallet.addCard("DrivingLicense");
        System.out.println("\nCards in wallet: " + wallet.getCardHolder());

        System.out.println("\nSimulating wallet loss:");
        wallet.lost();


        wallet.addMoney(50);
        wallet.addCard("CIN");
        System.out.println("Balance after attempting to add money: " + wallet.getMoney());
        System.out.println("Cards after attempting to add: " + wallet.getCardHolder());


        System.out.println("\nFinal wallet state:");
        System.out.println(wallet);
    }
}
