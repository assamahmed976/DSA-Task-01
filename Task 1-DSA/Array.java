import java.util.Scanner;

public class array {

    private static Scanner sc = new Scanner(System.in);

    private int[] bookStorage;

    private int counter;

    public array(int capacity) {
        bookStorage = new int[capacity];
        counter = 0;
    }

    // Add book ID at last
    public void add() {
        System.out.println("\nEnter a Book ID to add:");

        int value = sc.nextInt();

        if (value == 0) {
            System.out.println("\nError: Invalid Book ID, Zero is Not a Valid ID");
            return;
        }

        if (counter == bookStorage.length) {
            System.out.println("\nError: Shelf is Full");
            return;
        }

        bookStorage[counter] = value;
        counter++;
        System.out.println("Book ID " + value + " is added to the shelf");
    }

    // Fill the shelf with Book IDs
    public void fill() {
        if (counter == bookStorage.length) {
            System.out.println("\nError: Shelf is Full");
            return;
        }

        int emptySlots[] = new int[bookStorage.length];
        int slotN = 0;

        for (int i = 0; i < bookStorage.length; i++) {
            if (bookStorage[i] == 0) {
                emptySlots[slotN] = i;
                slotN++;
            }
        }

        int value = 0;
        int index = 0;

        do {
            do {
                System.out.println("Enter a Book ID to add:");
                value = sc.nextInt();

                if (value == 0) {
                    System.out.println("Error: Invalid Book ID, Zero is Not a Valid ID");
                }
            } while (value == 0);

            bookStorage[emptySlots[index]] = value;
            counter++;
            index++;

            System.out.println("Book ID " + value + " is added to the shelf");

        } while (counter < bookStorage.length);

        System.out.println("\nShelf is Full");
    }

    // Insert Book ID at specific index
    public void insert() {
        System.out.println("Enter the index where you want to add the Book ID:");
        int index = sc.nextInt();

        System.out.println("Enter a Book ID to add:");
        int value = sc.nextInt();

        if (index < 0 || index >= bookStorage.length) {
            System.out.println("Error: Invalid Index");
            return;
        }

        if (value == 0) {
            System.out.println("Error: Invalid Book ID, Zero is Not a Valid ID");
            return;
        }

        if (counter == bookStorage.length) {
            System.out.println("Book ID " + value + "\nError: Shelf is Full, So you cannot insert a new Book ID");
            return;
        } else {
            for (int i = counter; i > index; i--) {
                bookStorage[i] = bookStorage[i - 1];
            }

            bookStorage[index] = value;

            System.out.println("Book ID " + value + " is added at index " + index + " and previous Book IDs are shifted to the next index");
            counter++;
        }
    }

    // Update Book ID at specific index
    public void Update() {
        System.out.println("Enter the index of the Book ID to update:");
        int index = sc.nextInt();

        System.out.println("Enter the new Book ID:");
        int value = sc.nextInt();

        if (index < 0 || index >= bookStorage.length) {
            System.out.println("Error: Invalid Index");
            return;
        }

        if (value == 0) {
            System.out.println("Error: Invalid Book ID, Zero is Not a Valid ID");
            return;
        }

        bookStorage[index] = value;
        System.out.println("Book ID at index " + index + " is updated to " + value);
    }

    // Delete the Last Book ID
    public void removeLast() {
        if (counter == 0) {
            System.out.println("Error: Shelf is Empty");
            return;
        }

        bookStorage[counter - 1] = 0;
        counter--;
        System.out.println("Last Book ID is deleted from the shelf");
    }

    // Delete Book ID from specific index
    public void Delete() {
        System.out.println("Enter the index of the Book ID to delete:");
        int index = sc.nextInt();

        if (counter == 0) {
            System.out.println("Error: Shelf is Empty");
            return;
        }

        if (index < 0 || index >= counter) {
            System.out.println("Error: Invalid Index");
            Display();
            return;
        }

        for (int i = index; i < counter - 1; i++) {
            bookStorage[i] = bookStorage[i + 1];
        }

        bookStorage[counter - 1] = 0;
        counter--;

        System.out.println("Book ID at index " + index + " is deleted from the shelf");
    }

    // Display all Book IDs
    public void Display() {
        if (counter == 0) {
            System.out.println("Error: Shelf is Empty");
            return;
        }

        System.out.println("\nDisplaying all Book IDs on the shelf:");
        for (int i = 0; i < counter; i++) {
            System.out.print(bookStorage[i] + "\t");
        }

        System.out.println("\nTotal number of books on the shelf: " + counter);
    }

    // Search for a Book ID
    public void Search() {
        if (counter == 0) {
            System.out.println("Error: Shelf is Empty");
            return;
        }

        System.out.println("Enter a Book ID to search:");
        int value = sc.nextInt();

        for (int i = 0; i < counter; i++) {
            if (bookStorage[i] == value) {
                System.out.println("Book ID " + value + " is found at index " + i);
                return;
            }
        }

        System.out.println("Book ID " + value + " is not found on the shelf");
    }

    // Get Book ID by index
    public void SearchByIndex() {
        if (counter == 0) {
            System.out.println("Error: Shelf is Empty");
            return;
        }

        System.out.println("Enter the index of the Book ID to search:");
        int index = sc.nextInt();

        if (index < 0 || index >= counter) {
            System.out.println("Error: Invalid Index");
            return;
        }

        System.out.println("Book ID at index " + index + " is: " + bookStorage[index]);
    }

    // Display current number of books
    public void CurrentSize() {
        System.out.println("Current number of books on the shelf: " + counter);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the maximum number of books the shelf can hold:");
        int capacity = sc.nextInt();

        array q1 = new array(capacity);

        int menu = 0;

        do {
            System.out.println("\n----- LIBRARY BOOK MENU -----");
            System.out.println("1. Add Book ID");
            System.out.println("2. Insert Book ID at Specific Index");
            System.out.println("3. Fill the Shelf with Book IDs");
            System.out.println("4. Delete Last Book ID");
            System.out.println("5. Delete Book ID by Index");
            System.out.println("6. Display All Book IDs");
            System.out.println("7. Search for a Book ID");
            System.out.println("8. Get Book ID at Index");
            System.out.println("9. Update Book ID");
            System.out.println("10. Display Current Number of Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            menu = sc.nextInt();

            if (menu == 1) {
                q1.add();
            } else if (menu == 2) {
                q1.insert();
            } else if (menu == 3) {
                q1.fill();
            } else if (menu == 4) {
                q1.removeLast();
            } else if (menu == 5) {
                q1.Delete();
            } else if (menu == 6) {
                q1.Display();
            } else if (menu == 7) {
                q1.Search();
            } else if (menu == 8) {
                q1.SearchByIndex();
            } else if (menu == 9) {
                q1.Update();
            } else if (menu == 10) {
                q1.CurrentSize();
            } else if (menu == 11) {
                System.out.println("Exiting the Library Book Management System...");
                break;
            } else {
                System.out.println("Invalid choice");
            }

        } while (menu != 11);

        sc.close();
    }
}