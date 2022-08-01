package search;

import java.util.*;

public class Database {
    ArrayList<String> database;
    Map<String, ArrayList<Integer>> map;

    Database(ArrayList<String> database) {
        this.database = database;
        mapping();
    }

    void searchAll(String[] term) {
        int found = 0;
        int counter = 0;
        int termLength = term.length;
        ArrayList<Integer> foundIndexes = new ArrayList<>();
        for (int i = 0; i < database.size(); i++) {
            for (String s : term) {
                if (database.get(i).toLowerCase().contains(s.toLowerCase())) {
                    counter++;
                }
            }
            if (counter == termLength) {
                if (!foundIndexes.contains(i)) {
                    found++;
                    foundIndexes.add(i);
                }
            }
            counter = 0;
        }

        if (found > 0) {
            System.out.println(found + " books found: ");
            for (Integer foundIndex : foundIndexes) {
                System.out.println(database.get(foundIndex));
            }
        } else {
            System.out.println("No matching book found.");
        }

    }

    void searchAny(String[] term) {
        int found = 0;
        ArrayList<Integer> foundIndexes = new ArrayList<>();

        for (int i = 0; i < database.size(); i++) {
            for (String s : term) {
                if (database.get(i).toLowerCase().contains(s.toLowerCase())) {
                    if (!foundIndexes.contains(i)) {
                        foundIndexes.add(i);
                        found++;
                    }
                }
            }
        }
        if (found > 0) {
            System.out.println(found + " books found: ");
            for (Integer foundIndex : foundIndexes) {
                System.out.println(database.get(foundIndex));
            }
        } else {
            System.out.println("No matching book found.");
        }
    }

    public void searchNone(String[] term) {
        int found = 0;
        int counter = 0;
        ArrayList<Integer> foundIndexes = new ArrayList<>();

        for (int i = 0; i < database.size(); i++) {
            for (String s : term) {
                if (database.get(i).toLowerCase().contains(s.toLowerCase())) {
                    counter++;
                }
            }
            if (counter == 0) {
                if (!foundIndexes.contains(i)) {
                    foundIndexes.add(i);
                    found++;
                }
            }
            counter = 0;
        }

        if (found > 0) {
            System.out.println(found + " books found: ");
            for (Integer foundIndex : foundIndexes) {
                System.out.println(database.get(foundIndex));
            }
        } else {
            System.out.println("No matching book found.");
        }
    }

    public void search() {

        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        Scanner scanner = new Scanner(System.in);
        String strategy = scanner.nextLine();
        String[] searchTerm;

        switch (strategy.toUpperCase()) {
            case "ALL":
                System.out.println("Enter data to search books:");
                searchTerm = scanner.nextLine().split(" ");
                searchAll(searchTerm);
                break;
            case "ANY":
                System.out.println("Enter data to search books:");
                searchTerm = scanner.nextLine().split(" ");
                searchAny(searchTerm);
                break;
            case "NONE":
                System.out.println("Enter data to search books:");
                searchTerm = scanner.nextLine().split(" ");
                searchNone(searchTerm);
                break;
            default:
                System.out.println("Wrong input!");
        }



        /*if (map.get(searchTerm.toLowerCase()) == null) {
            System.out.println("No matching book found.");
        } else {
            int count = map.get(searchTerm.toLowerCase()).size();
            System.out.println(count + " books found: ");
            for (int i = 0; i < map.get(searchTerm.toLowerCase()).size(); i++) {
                System.out.println(database.get(map.get(searchTerm.toLowerCase()).get(i)));
            }
        }

        boolean found = false;
        for (String s : database) {
            if (s.toLowerCase().contains(searchTerm.toLowerCase())) {
                if (!found) {
                    System.out.println(count + " books found: ");
                }
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }*/

    }

    public void printAll() {
        System.out.println("=== List of books ===");
        for (String s : database) {
            System.out.println(s);
        }
    }

    public void mapping() {
        this.map = new HashMap<>();
        for (int i = 0; i < database.size(); i++) {
            String[] strings = database.get(i).split(" ");
            for (int x = 0; x < strings.length; x++) {
                if (map.containsKey(strings[x].toLowerCase())) {
                    map.get(strings[x].toLowerCase()).add(i);
                } else {
                    map.put(strings[x].toLowerCase(), new ArrayList<>());
                    map.get(strings[x].toLowerCase()).add(i);
                }
            }
        }
    }
}
