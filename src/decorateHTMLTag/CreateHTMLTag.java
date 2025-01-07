package decorateHTMLTag;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateHTMLTag {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter text to create an HTML tag out of: ");
        String text = keyboard.nextLine();

        // Select the base tag (HTML tag to be created)
        int choice = 0;
        boolean status = true;
        HTMLTag tag = null;

        // Allow the user to choose which type of tag to create
        do {
            System.out.println("Enter: \n1) to create an <h> tag\n" +
                    "2) to create a <div> tag\n" +
                    "3) to create an <input> tag\n" +
                    "4) to create a <p> tag");
            try {
                choice = keyboard.nextInt();
                while (choice < 1 || choice > 4) {
                    System.out.print("Invalid choice. Please re-enter: ");
                    choice = keyboard.nextInt();
                }
                status = false;
                keyboard.nextLine();  // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid data.");
                keyboard.nextLine();
            }
        } while (status);

        //create the tag based on user choice
        switch (choice) {
            case 1:
                tag = createHTag(text, keyboard);
                break;
            case 2:
                tag = createDivTag(text, keyboard);
                break;
            case 3:
                tag = createInputTag(text, keyboard);
                break;
            case 4:
                tag = createPTag(text, keyboard);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        //allow the user to add decorators
        int decoratorChoice = 0;
        HTMLTag decoratedTag = tag; 

        while (decoratorChoice != 7) {
            do {
                System.out.println("Enter: \n1) to add a <small> tag\n" +
                        "2) to add an <i> tag\n" +
                        "3) to add a <u> tag\n" +
                        "4) to add an <a> tag\n" +
                        "5) to add a <strong> tag\n" +
                        "6) to add an <em> tag\n" +
                        "7) when done adding tags");
                try {
                    decoratorChoice = keyboard.nextInt();
                    while (decoratorChoice < 1 || decoratorChoice > 7) {
                        System.out.print("Invalid choice. Please re-enter: ");
                        decoratorChoice = keyboard.nextInt();
                    }
                    //once status becomes false, will leave loop since no exception was thrown
                    status = false;
                    keyboard.nextLine(); 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid data.");
                    keyboard.nextLine();
                }
            } while (status);

            //based on users choice, will continue to add decorator tags
            switch (decoratorChoice) {
                case 1:
                	//passing the tag into the external decorator
                    decoratedTag = new SmallDecoratorTag(decoratedTag);
                    break;
                case 2:
                    decoratedTag = new IDecoratorTag(decoratedTag);
                    break;
                case 3:
                    decoratedTag = new UDecoratorTag(decoratedTag);
                    break;
                case 4:
                    System.out.print("Enter the href for the <a> tag (or leave blank): ");
                    String href = keyboard.nextLine();
                    decoratedTag = new ADecoratorTag(decoratedTag, href);
                    break;
                case 5:
                    decoratedTag = new StrongDecoratorTag(decoratedTag); 
                    break;
                case 6:
                    decoratedTag = new EmDecoratorTag(decoratedTag); 
                    break;
                case 7:
                    // Display the final tag when done
                    System.out.println("Final HTML Tag: " + decoratedTag.getHTMLTag());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    //create <h> tag
    public static HTMLTag createHTag(String text, Scanner keyboard) {
        System.out.print("Enter the number for the <h> tag (1-6): ");
        int tagNum = keyboard.nextInt();
        keyboard.nextLine();  
        return new HTag(text, tagNum);
    }

    //create <div> tag
    public static HTMLTag createDivTag(String text, Scanner keyboard) {
        System.out.print("Enter the name for the <div> tag (or leave blank): ");
        String name = keyboard.nextLine();
        System.out.print("Enter the id for the <div> tag (or leave blank): ");
        String id = keyboard.nextLine();
        //returns new DivTag object that contains all information from user
        return new DivTag(text, name, id);
    }

    //create <input> tag
    public static HTMLTag createInputTag(String text, Scanner keyboard) {
        System.out.print("Enter the type for the <input> tag (or leave blank): ");
        String type = keyboard.nextLine();
        System.out.print("Enter the name for the <input> tag (or leave blank): ");
        String name = keyboard.nextLine();
        System.out.print("Enter the id for the <input> tag (or leave blank): ");
        String id = keyboard.nextLine();
        System.out.print("Enter the value for the <input> tag (or leave blank): ");
        String value = keyboard.nextLine();
        System.out.print("Enter the onclick for the <input> tag (or leave blank): ");
        String onclick = keyboard.nextLine();
        return new InputTag(text, name, id, type, onclick, value);
    }

    // Create <p> tag
    public static HTMLTag createPTag(String text, Scanner keyboard) {
        System.out.print("Enter the name for the <p> tag (or leave blank): ");
        String name = keyboard.nextLine();
        System.out.print("Enter the id for the <p> tag (or leave blank): ");
        String id = keyboard.nextLine();
        return new PTag(text, name, id);
    }
}
