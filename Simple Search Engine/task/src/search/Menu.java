package search;

import java.util.Scanner;

public class Menu {
    Options op;
    Database db;
    enum Options {
        FIND(1),
        PRINT(2),
        EXIT(0);

        Options(int i) {
        }
    }



    Menu(Database db) {
        this.db = db;
    }

    public void menu() {

        System.out.println("\n=== Menu ===\n" +
                "1. Find a book\n" +
                "2. Print all books\n" +
                "0. Exit");

        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        switch (i) {
            case 0:
                this.op = Options.EXIT;
                break;
            case 1:
                this.op = Options.FIND;
                break;
            case 2:
                this.op = Options.PRINT;
                break;
            default:
                System.out.println("Wrong input");
                return;

        }


        switch (op) {
            case FIND:
                db.search();
                break;
            case PRINT:
                db.printAll();
                break;
            case EXIT:
                System.out.println("Bye!");
                System.exit(0);
                break;
        }
    }


}
