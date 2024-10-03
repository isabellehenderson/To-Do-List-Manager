import java.util.*;
import java.io.*;

// This class is a to-do list manager. It takes in user input to
// determine how to edit the to-do list and then edits a list according
// to the user's choices.
public class TodoListManager {
    public static final boolean EXTENSION_FLAG = false;

    // Gives users a list of possible options to edit their todo list.
    //
    // @throws FileNotFoundException if specified file does not exist
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scan = new Scanner(System.in);
        List<String> todos = new ArrayList<>();
        String option = "";
        System.out.println("Welcome to your TODO List Manager!");

        while(!option.equalsIgnoreCase("Q")){
            System.out.println("What would you like to do?"); 
            System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? ");
            option = scan.nextLine();

            if(option.equalsIgnoreCase("A") && !EXTENSION_FLAG){
                addItem(scan, todos);
                printTodos(todos);
            } else if(option.equalsIgnoreCase("A") && EXTENSION_FLAG){
                System.out.print("Would you like to add more than 1 item (Y/N)? ");
                String yesNo = scan.nextLine();

                if(yesNo.equalsIgnoreCase("Y")){
                    addMultipleItems(scan, todos);
                    printTodos(todos);
                } else if(yesNo.equalsIgnoreCase("N")){
                    addItem(scan, todos);
                    printTodos(todos);
                } else {
                    System.out.println("Unknown Input: " + yesNo);
                }
                
            } else if (option.equalsIgnoreCase("M")){
                markItemAsDone(scan, todos);
                printTodos(todos);
            } else if (option.equalsIgnoreCase("L")){
                loadItems(scan, todos);
                printTodos(todos);
            } else if (option.equalsIgnoreCase("S")){
                saveItems(scan, todos);
                printTodos(todos);
            } else if (!option.equalsIgnoreCase("Q")) {
                System.out.println("Unknown input: " + option);
                printTodos(todos);
            }
        }
        
    }

    // Prints out the updated list of todos, numbered. Or if list is empty,
    // prints a message to the console.
    //
    // @param List<String> todos - the current list of todos
    public static void printTodos(List<String> todos) {
        int listSize = todos.size();
        System.out.println("Today's TODOs:");
               
        if(listSize == 0){ // checks if list is empty
            System.out.println("  You have nothing to do yet today! Relax!");
        } else {
            for(int i = 0; i < todos.size(); i++){
                System.out.println("  " + (i + 1) + ": " + todos.get(i));
            }
        }
    }

    // Adds an item to the todo list, either in a specified spot or 
    // to the end of the current list.
    //
    // @param Scanner console - the scanner that takes user input
    // @param List<String> todos - the current list of todos to be added to
    public static void addItem(Scanner console, List<String> todos) {
        int listSize = todos.size();
        System.out.print("What would you like to add? ");
        String item = console.nextLine();
        
        if(listSize > 0){ // checks if list is empty
            System.out.print("Where in the list should it be (1-" + (listSize + 1) 
                + ")? (Enter for end): ");
            String input = console.nextLine();
            if(input.equals("")){ // checks for enter
                todos.add(item);
            } else {
                int num = Integer.parseInt(input); 
                todos.add((num - 1), item);
            }
        } else {
            todos.add(item);
        }
    }

    // Adds multiple items to the list at once, either in a 
    // specified spot or at the end of the list.
    //
    // @param Scanner console - the scanner that takes user input
    // @param List<String> todos - the current list of todos to be added to
    public static void addMultipleItems(Scanner console, List<String> todos) {
        int listSize = todos.size();
        System.out.print("What would you like to add? ");
        String adding = console.nextLine();


        while(!adding.equalsIgnoreCase("Q")){

            if(listSize > 0){ // checks if list is empty
                System.out.print("Where in the list should it be (1-" + (listSize + 1) 
                    + ")? (Enter for end): ");
                String input = console.nextLine();
                if(input.equals("")){ // checks for enter
                    todos.add(adding);
                } else {
                    int num = Integer.parseInt(input); 
                    todos.add((num - 1), adding);
                }
            } else {
                todos.add(adding);
            }
            
            printTodos(todos); 
            System.out.print("Next item (Press Q to quit )? ");
            adding = console.nextLine();
            listSize = todos.size();
           
        }

    }

    // Removes items from the todo list that user marks as done. Or if list 
    // is empty, prints a message to the console.
    //
    // @param Scanner console - the scanner that takes user input
    // @param List<String> todos - the current list of todos to be added to
    public static void markItemAsDone(Scanner console, List<String> todos) {
        int listSize = todos.size();
        
        if(listSize == 0){ // checks if list is empty
           System.out.println("All done! Nothing left to mark as done!");  
        } else {
            System.out.print("Which item did you complete (1-" + listSize + ")? ");
            String input = console.nextLine();
            int num = Integer.parseInt(input); 
            todos.remove(num - 1);
        }

    }

    // Loads items into a todo list from scan of a file indicated by the user.
    //
    // @param Scanner console - the scanner that takes user input
    // @param List<String> todos - the current list of todos to load file items into
    // @throws FileNotFoundException if specified file does not exist
    public static void loadItems(Scanner console, List<String> todos)
                                throws FileNotFoundException {
        System.out.print("File name? ");
        String fileName = console.nextLine();
        Scanner fileScan = new Scanner(new File(fileName));
        todos.clear();

        while(fileScan.hasNextLine()){
            String item = fileScan.nextLine();
            todos.add(item);
        }   
    }

    // Saves current todo list to a file indicated by the user.
    //
    // @param Scanner console - the scanner that takes user input
    // @param List<String> todos - the current list of todos to be saved
    // @throws FileNotFoundException if specified file does not exist
    public static void saveItems(Scanner console, List<String> todos)
                                throws FileNotFoundException {
        System.out.print("File name? ");
        String fileName = console.nextLine();
        File todoFile = new File(fileName);
        PrintStream output = new PrintStream(todoFile);
        
        for(int i = 0; i < todos.size(); i++){
            output.println(todos.get(i));
        }
    }

}