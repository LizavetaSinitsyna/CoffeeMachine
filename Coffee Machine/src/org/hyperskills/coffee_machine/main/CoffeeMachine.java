package org.hyperskills.coffee_machine.main;

import java.util.Scanner;

public class CoffeeMachine {


    public enum CurrentStateOfCoffeeMachine {
        CHOOSING_ACTION(true),
        CHOOSING_COFFEE(true),
        FILL(true),
        TAKE(true),
        REMAINING(true),
        EXIT(false);
        public boolean work;

        CurrentStateOfCoffeeMachine(boolean work) {
            this.work = work;
        }

    }

    CurrentStateOfCoffeeMachine currentStateOfCoffeeMachine;
    int water;
    int milk;
    int coffeeBeans;
    int cups;
    int money;

    public CurrentStateOfCoffeeMachine getRemaining(CoffeeMachine coffeeMachine) {
        System.out.println("The coffee machine has:\n" +
                this.water + " of water\n" +
                this.milk + " of milk\n" +
                this.coffeeBeans + " of coffee beans\n" +
                this.cups + " of disposable cups\n" +
                this.money + " of money");
        this.currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.CHOOSING_ACTION;
        return currentStateOfCoffeeMachine;
    }

    public CurrentStateOfCoffeeMachine choosingAction() {

        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = new Scanner(System.in).next();
        switch (action) {
            case "buy":
                currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.CHOOSING_COFFEE;
                break;
            case "fill":
                currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.FILL;
                break;
            case "take":
                currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.TAKE;
                break;
            case "remaining":
                currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.REMAINING;
                break;
            case "exit":
                currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.EXIT;
                break;

        }
        return this.currentStateOfCoffeeMachine;
    }

    public CurrentStateOfCoffeeMachine choosingCoffee(CoffeeMachine coffeeMachine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String typeOfCoffee = new Scanner(System.in).next();
        switch (typeOfCoffee) {
            case "1":
                if (this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    this.coffeeBeans -= 16;
                    this.money += 4;
                    this.cups -= 1;
                }
                break;
            case "2":
                if (this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 350;
                    this.milk -= 75;
                    this.coffeeBeans -= 20;
                    this.money += 7;
                    this.cups -= 1;
                }
                break;
            case "3":
                if (this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 200;
                    this.milk -= 100;
                    this.coffeeBeans -= 12;
                    this.money += 6;
                    this.cups -= 1;
                }
                break;
            case "back":
                this.currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.CHOOSING_ACTION;
                break;
        }
        this.currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.CHOOSING_ACTION;
        return currentStateOfCoffeeMachine;
    }

    public CurrentStateOfCoffeeMachine fill(CoffeeMachine coffeeMachine) {
        System.out.println("Write how many ml of water do you want to add: ");
        this.water += new Scanner(System.in).nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        this.milk += new Scanner(System.in).nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        this.coffeeBeans += new Scanner(System.in).nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        this.cups += new Scanner(System.in).nextInt();
        System.out.println();
        this.currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.CHOOSING_ACTION;
        return currentStateOfCoffeeMachine;
    }

    public CurrentStateOfCoffeeMachine take(CoffeeMachine coffeeMachine) {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
        System.out.println();
        this.currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.CHOOSING_ACTION;
        return currentStateOfCoffeeMachine;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.currentStateOfCoffeeMachine = CurrentStateOfCoffeeMachine.CHOOSING_ACTION;
        coffeeMachine.water = 400;
        coffeeMachine.milk = 540;
        coffeeMachine.coffeeBeans = 120;
        coffeeMachine.cups = 9;
        coffeeMachine.money = 550;

        while (coffeeMachine.currentStateOfCoffeeMachine.work) {
            switch (coffeeMachine.currentStateOfCoffeeMachine) {
                case CHOOSING_ACTION:
                    coffeeMachine.choosingAction();
                    break;
                case CHOOSING_COFFEE:
                    coffeeMachine.choosingCoffee(coffeeMachine);
                    break;
                case FILL:
                    coffeeMachine.fill(coffeeMachine);
                    break;
                case TAKE:
                    coffeeMachine.take(coffeeMachine);
                    break;
                case REMAINING:
                    coffeeMachine.getRemaining(coffeeMachine);
                    break;
            }

        }

    }
}


