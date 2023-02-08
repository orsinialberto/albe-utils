package org.example;

import java.util.Scanner;

public class App {

    public static final String WRITE_CSV = "writeCsv";
    public static final String CONVERT_JSON_TO_YAML = "convertJsonToYaml";
    public static final String DISTINCT_LINE = "distinctLine";
    public static final String EXIT = "exit";

    public static void main(String[] args ) throws Exception {

        System.out.println("Hi boss, what do you want me to do?");

        Processor processor = null;
        boolean run = true;
        boolean execute = true;

        while (run) {

            final Scanner keyboard = new Scanner(System.in);
            String command = keyboard.nextLine();

            switch (command) {
                case "help":
                    System.out.println("Command:");
                    System.out.println(WRITE_CSV + ": generate a random csv");
                    System.out.println(CONVERT_JSON_TO_YAML + ": convert json to yaml");
                    System.out.println(DISTINCT_LINE + ": select distinct line of file");
                    System.out.println(EXIT + ": exit from the program");
                    execute = false;
                    break;
                case WRITE_CSV:
                    final Scanner keyboard2 = new Scanner(System.in);
                    System.out.println("How many lines should the file contain?");
                    int lines = keyboard2.nextInt();
                    final Scanner keyboard3 = new Scanner(System.in);
                    System.out.println("Where should I save the file?");
                    String path = keyboard3.nextLine();
                    processor = new ObjectToCsvWriter(lines, path);
                    break;
                case CONVERT_JSON_TO_YAML:
                    processor = new JsonToYamlWriter();
                    break;
                case DISTINCT_LINE:
                    processor = new DistinctLineConverter();
                    break;
                case EXIT:
                    run = false;
                    execute = false;
                    break;
                default:
                    System.out.println("Command not found. Write 'help' for command list");
                    execute = false;
                    break;
            }

            if (execute) {
                processor.run();
            }

            execute = true;

            System.out.println("Anything else?");
        }




    }
}
