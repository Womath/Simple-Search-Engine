package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--data")) {
                path = args[i + 1];
            }
        }
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<String> database = new ArrayList<>();
        while (scanner.hasNextLine()) {
            database.add(scanner.nextLine());
        }

        scanner.close();

        Database db = new Database(database);
        Menu menu = new Menu(db);

        while (true) {
            menu.menu();
        }


    }
}
