package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int waterQuantity = 400;
    private static int milkQuantity = 540;
    private static int coffeeBeansQuantity = 120;
    private static int cupsQuantity = 9;
    private static int moneyQuantity = 550;


    public static void main(String[] args) {
        coffeeMachineInit();
    }

    private static void coffeeMachineInit() {
        chooseAction();
    }

    private static void chooseAction() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();
            if (action.equals("buy")) {
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                String coffeeType = scanner.nextLine();
                if (coffeeType.equals("back")) {
                    continue;
                } else if (coffeeType.equals("1")) {
                    makeEspresso();
                } else if (coffeeType.equals("2")) {
                    makeLatte();
                } else if (coffeeType.equals("3")) {
                    makeCappuccino();
                }
            } else if (action.equals("fill")) {
                fillAction();
            } else if (action.equals("take")) {
                takeAction();
            } else if (action.equals("remaining")) {
                printMachineSupplies();
            } else if (action.equals("exit")) {
                break;
            }
        }
    }

    private static void printMachineSupplies() {
        System.out.println();
        System.out.println("The coffee machine has:\n" +
                waterQuantity + " ml of water\n" +
                milkQuantity + " ml of milk\n" +
                coffeeBeansQuantity + " g of coffee beans\n" +
                cupsQuantity + " disposable cups\n" +
                "$" + moneyQuantity + " of money");
    }

    private static void takeAction() {
        System.out.println("I gave you $" + moneyQuantity);
        moneyQuantity = 0;
    }

    private static void fillAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int waterAddedQuantity = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milkAddedQuantity = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int coffeeBeansAddedQuantity = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int cupsAddedQuantity = scanner.nextInt();
        waterQuantity += waterAddedQuantity;
        milkQuantity += milkAddedQuantity;
        coffeeBeansQuantity += coffeeBeansAddedQuantity;
        cupsQuantity += cupsAddedQuantity;
    }


    private static void makeEspresso() {
        int waterQuantityNeeded = 250;
        int milkQuantityNeeded = 0;
        int coffeeBeansQuantityNeeded = 16;
        int moneyEarned = 4;
        if (checkResources(waterQuantityNeeded, milkQuantityNeeded, coffeeBeansQuantityNeeded)) {
            useResources(waterQuantityNeeded, milkQuantityNeeded, coffeeBeansQuantityNeeded, moneyEarned);
        }
    }

    private static void makeLatte() {
        int waterQuantityNeeded = 350;
        int milkQuantityNeeded = 75;
        int coffeeBeansQuantityNeeded = 20;
        int moneyEarned = 7;
        if (checkResources(waterQuantityNeeded, milkQuantityNeeded, coffeeBeansQuantityNeeded)) {
            useResources(waterQuantityNeeded, milkQuantityNeeded, coffeeBeansQuantityNeeded, moneyEarned);
        }
    }

    private static void makeCappuccino() {
        int waterQuantityNeeded = 200;
        int milkQuantityNeeded = 100;
        int coffeeBeansQuantityNeeded = 12;
        int moneyEarned = 6;
        if (checkResources(waterQuantityNeeded, milkQuantityNeeded, coffeeBeansQuantityNeeded)) {
            useResources(waterQuantityNeeded, milkQuantityNeeded, coffeeBeansQuantityNeeded, moneyEarned);
        }
    }

    private static void useResources(int waterQuantityNeeded, int milkQuantityNeeded, int coffeeBeansQuantityNeeded, int moneyEarned) {
        waterQuantity -= waterQuantityNeeded;
        milkQuantity -= milkQuantityNeeded;
        coffeeBeansQuantity -= coffeeBeansQuantityNeeded;
        moneyQuantity += moneyEarned;
        cupsQuantity--;
    }

    private static boolean checkResources(int waterQuantityNeeded, int milkQuantityNeeded, int coffeeBeansQuantityNeeded) {
        boolean enoughResources = true;
        if (waterQuantityNeeded > waterQuantity) {
            System.out.println("Sorry, not enough water!");
            enoughResources = false;
        } else if (milkQuantityNeeded > milkQuantity) {
            System.out.println("Sorry, not enough milk!");
            enoughResources = false;
        } else if (coffeeBeansQuantityNeeded > coffeeBeansQuantity) {
            System.out.println("Sorry, not enough coffee beans!");
            enoughResources = false;
        } else if (cupsQuantity < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            enoughResources = false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }
        return enoughResources;
    }


}
