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

        printMachineSupplies();
        chooseAction();
        printMachineSupplies();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write how many ml of water the coffee machine has: ");
//        int quantityOfWaterInMachine = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has: ");
//        int quantityOfMilkInMachine = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        int quantityOfCoffeeBeansInMachine = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need: ");
//        int quantityOfCoffeeCupsRequested = scanner.nextInt();
//
//        int cupsOfCoffeeAvailable = calculateMinimumQuantityOfCupsAvailable(quantityOfWaterInMachine, quantityOfMilkInMachine, quantityOfCoffeeBeansInMachine);
//
//        if (quantityOfCoffeeCupsRequested == cupsOfCoffeeAvailable) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (quantityOfCoffeeCupsRequested > cupsOfCoffeeAvailable) {
//            System.out.println("No, I can make only " + cupsOfCoffeeAvailable + " cup(s) of coffee");
//        } else if (quantityOfCoffeeCupsRequested < cupsOfCoffeeAvailable) {
//            System.out.println("Yes, I can make that amount of coffee (and even " +
//                    (cupsOfCoffeeAvailable - quantityOfCoffeeCupsRequested) + " more than that)");
//        } else if (cupsOfCoffeeAvailable == 0) {
//            System.out.println("No, I can make only 0 cup(s) of coffee");
//        }

    }

    private static void printMachineSupplies() {
        System.out.println();
        System.out.println("The coffee machine has:\n" +
                waterQuantity + " ml of water\n" +
                milkQuantity + " ml of milk\n" +
                coffeeBeansQuantity + " g of coffee beans\n" +
                cupsQuantity + " disposable cups\n" +
                "$" + moneyQuantity + " of money\n");
    }

    private static void chooseAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine();
        if (action.equals("buy")) {
            buyAction();
        } else if (action.equals("fill")) {
            fillAction();
        } else if (action.equals("take")) {
            takeAction();
        }
    }

    private static void takeAction() {
        Scanner scanner = new Scanner(System.in);
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

    private static void buyAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeType = scanner.nextInt();
        System.out.println();
        if (coffeeType == 1) {
            makeEspresso();
        } else if (coffeeType == 2) {
            makeLatte();
        } else if (coffeeType == 3) {
            makeCappuccino();
        }
    }

    private static void makeEspresso() {
        waterQuantity -= 250;
        coffeeBeansQuantity -= 16;
        moneyQuantity += 4;
        cupsQuantity--;
    }

    private static void makeLatte() {
        waterQuantity -= 350;
        milkQuantity -= 75;
        coffeeBeansQuantity -= 20;
        moneyQuantity += 7;
        cupsQuantity--;
    }

    private static void makeCappuccino() {
        waterQuantity -= 200;
        milkQuantity -= 100;
        coffeeBeansQuantity -= 12;
        moneyQuantity += 6;
        cupsQuantity--;
    }


    private static int calculateMinimumQuantityOfCupsAvailable(int quantityOfWaterInMachine, int quantityOfMilkInMachine,
                                                               int quantityOfCoffeeBeansInMachine) {
        int cups = Math.min(Math.min(quantityOfWaterInMachine / 200, quantityOfMilkInMachine / 50), quantityOfCoffeeBeansInMachine / 15);
        return cups;
    }

    private static int calculateWaterQuantityNeeded(int numberOfCoffeeCups) {
        return numberOfCoffeeCups * 200;
    }

    private static int calculateMilkQuantityNeeded(int numberOfCoffeeCups) {
        return numberOfCoffeeCups * 50;
    }

    private static int calculateCoffeeBeansQuantityNeeded(int numberOfCoffeeCups) {
        return numberOfCoffeeCups * 15;
    }


    private static void printCoffeeProcess() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }


}
