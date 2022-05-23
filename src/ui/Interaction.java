package ui;

import hamburgers.components.ComponentSize;
import hamburgers.components.sauce.Sauce;
import hamburgers.components.vegetables.Vegetables;
import hamburgers.userbuilders.abstractions.HamburgerBuilder;
import hamburgers.userbuilders.implementation.DefaultHamburgerBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Interaction {
    private final Scanner scanner = new Scanner(System.in);
    private HamburgerBuilder builder = new DefaultHamburgerBuilder();
    private ComponentSize size = ComponentSize.MEDIUM;
    private double extra = 0;

    public void menu() {
        while (true) {
            System.out.println(MenuStrings.m);
            int index = read();
            switch (index) {
                case 0 -> System.exit(0);
                case 1 -> readGallery();
                case 2 -> menu2();
                default -> System.out.println(MenuStrings.mError);
            }
        }
    }

    private void readGallery() {
        try {
            var fis = new FileInputStream("burgers.txt");
            var str = new String(fis.readAllBytes());
            if (str.isBlank()){
                System.out.println("Галерея пуста");
            } else {
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("Не могу получить доступ к файлу \"burgers.txt\"");
            System.out.println("Чтобы получить файл нужно создать хотя бы один бургер");
        }
    }

    private void menu2() {
        while (true) {
            System.out.println(MenuStrings.m2);
            int index = read();
            switch (index) {
                case 0:
                    return;
                case 1:
                    bread();
                    break;
                case 2:
                    burger();
                    break;
                case 3:
                    sauce();
                    break;
                case 4:
                    vegs();
                    break;
                case 5:
                    crust();
                    break;
                case 6:
                    sesame();
                    break;
                case 7:
                    size();
                    break;
                case 8:
                    save();
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }
        }
    }

    private void save() {
        var h = builder.build();
        h.print(System.out);
        try {
            var ps = new PrintStream(new FileOutputStream("burgers.txt", true), true);
            h.print(ps);
        } catch (Exception e) {
            System.out.println("Не удалось записать иинформаицю в файл");
            e.printStackTrace();
        }
        System.out.println();
        builder = new DefaultHamburgerBuilder();
    }

    private void size() {
        while (true) {
            System.out.println(MenuStrings.m27);
            switch (read()) {
                case 1:
                    builder.withSize(ComponentSize.SMALL);
                    size = ComponentSize.SMALL;
                    return;
                case 2:
                    builder.withSize(ComponentSize.MEDIUM);
                    size = ComponentSize.MEDIUM;
                    return;
                case 3:
                    builder.withSize(ComponentSize.BIG);
                    size = ComponentSize.BIG;
                    return;
                case 4:
                    builder.withSize(ComponentSize.LARGE);
                    size = ComponentSize.LARGE;
                    return;
                case 5:
                    builder.withSize(ComponentSize.EXTRA_LARGE);
                    size = ComponentSize.EXTRA_LARGE;
                    return;
                case 6:
                    builder.withSize(ComponentSize.LONG);
                    size = ComponentSize.LONG;
                    return;
                case 7:
                    builder.withSize(ComponentSize.EXTRA_LONG);
                    size = ComponentSize.EXTRA_LONG;
                    return;
                case 0:
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }

        }
    }

    private void sesame() {
        builder.withoutSesame();
        System.out.println(MenuStrings.m26);
    }

    private void crust() {
        builder.withoutCrust();
        System.out.println(MenuStrings.m25);
    }

    private void vegs() {
        extra = 0;
        while (true) {
            System.out.println(MenuStrings.m24);

            switch (read()) {
                case 1:
                    vegs2();
                    builder.addTomato().more((int) extra);
                    System.out.println(MenuStrings.mAdded);
                    return;
                case 2:
                    vegs2();
                    builder.addCucumber().more((int) extra);
                    System.out.println(MenuStrings.mAdded);
                    return;
                case 0:
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }
        }
    }

    private void vegs2() {
        while (true) {
            var amount = size.getMultiplier() * Vegetables.DEFAULT_AMOUNT + extra;
            if (amount < 0) amount = 0;
            System.out.println("Сейчас " + amount + " штук");
            System.out.println(MenuStrings.m23x);
            switch (read()) {
                case 1:
                    System.out.println(MenuStrings.mAdd);
                    extra += read();
                    break;
                case 2:
                    System.out.println(MenuStrings.mAdd);
                    extra -= read();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }
        }
    }

    private void sauce() {
        extra = 0;
        while (true) {
            System.out.println(MenuStrings.m23);
            switch (read()) {
                case 1:
                    sauce2();
                    builder.addCheeseSauce().more((int) extra);
                    return;
                case 2:
                    sauce2();
                    builder.addSweetAndSourSauce().more((int) extra);
                    return;
                case 3:
                    sauce2();
                    builder.addSalsaSauce().more((int) extra);
                    return;
                case 0:
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }
        }
    }

    private void sauce2() {
        while (true) {
            var amount = size.getMultiplier() * Sauce.DEFAULT_AMOUNT + extra;
            if (amount < 0) amount = 0;
            System.out.println("Сейчас " + amount + " грамм");
            System.out.println(MenuStrings.m23x);
            switch (read()) {
                case 1:
                    System.out.println(MenuStrings.mAdd);
                    extra += read();
                    break;
                case 2:
                    System.out.println(MenuStrings.mAdd);
                    extra -= read();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }
        }
    }

    private void burger() {
        System.out.println(MenuStrings.m22);
        while (true)
            switch (read()) {
                case 1:
                    builder.addChickenBurger();
                    System.out.println(MenuStrings.mAdded);
                    return;
                case 2:
                    builder.addPorkBurger();
                    System.out.println(MenuStrings.mAdded);
                    return;
                case 3:
                    builder.addBeefBurger();
                    System.out.println(MenuStrings.mAdded);
                    return;
                case 0:
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }
    }

    private void bread() {
        System.out.println(MenuStrings.m21);
        while (true)
            switch (read()) {
                case 1:
                    builder.addWhiteBread();
                    System.out.println(MenuStrings.mAdded);
                    return;
                case 2:
                    builder.addRyeBread();
                    System.out.println(MenuStrings.mAdded);
                    return;
                case 0:
                    return;
                default:
                    System.out.println(MenuStrings.mError);
            }
    }

    public int read() {
        while (true) {
            try {
                var l = scanner.nextLine();
                return Integer.parseInt(l);
            } catch (Exception ignored) {
            }
        }
    }
}
