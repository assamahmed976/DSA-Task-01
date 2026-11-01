package Queue;
import java.util.Scanner;

public class queue {

    private static Scanner sc = new Scanner(System.in);

    private int[] numbers;
    private int front;
    private int rear;

    // Constructor
    public queue(int capacity) {
        numbers = new int[capacity];
        front = 0;
        rear = -1;
    }

    // Enqueue - Add value at the rear
    public void Enqueue() {
        System.out.println("\nEnter a token number: ");
        int value = sc.nextInt();

        if (isFullQueue()) {
            System.out.println("\nError: Queue is Full");
            return;
        }

        rear++;
        numbers[rear] = value;

        System.out.println(value + " is added to the Queue");
    }

    // Dequeue - Remove value from the front
    public void Dequeue() {
        if (isEmptyQueue()) {
            System.out.println("\nError: Queue is Empty");
            return;
        }

        int value = numbers[front];
        front++;

        System.out.println("Token " + value + " is removed from the Queue");
    }

    // Display - Show values from front to rear
    public void Display() {
        if (isEmptyQueue()) {
            System.out.println("\nError: Queue is Empty");
            return;
        }

        System.out.println("\nValues in Queue from Front to Rear:");
        for (int i = front; i <= rear; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
    }

    // Size - Show current number of elements
    public void CurrentSize() {
        int size = rear - front + 1;
        System.out.println("\nCurrent size of Queue is: " + size);
    }

    // isEmpty
    public void isEmpty() {
        if (isEmptyQueue()) {
            System.out.println("\nQueue is Empty");
        } else {
            System.out.println("\nQueue is not Empty");
        }
    }

    // isFull
    public void isFull() {
        if (isFullQueue()) {
            System.out.println("\nQueue is Full");
        } else {
            System.out.println("\nQueue is not Full");
        }
    }

    // Internal isEmpty check
    private boolean isEmptyQueue() {
        return front > rear;
    }

    // Internal isFull check
    private boolean isFullQueue() {
        return rear == numbers.length - 1;
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the maximum capacity of Queue:");
        int capacity = sc.nextInt();

        queue q1 = new queue(capacity);

        int menu = 0;

        do {
            System.out.println("\n----- QUEUE MENU -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            menu = sc.nextInt();

            if (menu == 1) {
                q1.Enqueue();
            } else if (menu == 2) {
                q1.Dequeue();
            } else if (menu == 3) {
                q1.Display();
            } else if (menu == 4) {
                q1.CurrentSize();
            } else if (menu == 5) {
                q1.isEmpty();
            } else if (menu == 6) {
                q1.isFull();
            } else if (menu == 7) {
                System.out.println("\nExiting the program...");
            } else {
                System.out.println("\nInvalid choice");
            }

        } while (menu != 7);

        sc.close();
    }
}