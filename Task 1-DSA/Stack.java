package stack;

import java.util.Scanner;

public class stack {
    private static Scanner sc = new Scanner(System.in);
    private int[] numbers;
    private int top;

    public stack(int capacity) {
        numbers = new int[capacity];
        top = -1;
    }

    ///add at last
    public void push() {
        System.out.println("Enter a number to add:");
        int value = sc.nextInt();
        if (value == 0) {
            System.out.println("\nError: Invalid Value ,Zero is Not a Valid");
            return;
        }
        if (top == numbers.length - 1) {
            System.out.println("\nError: Array is Full");
            return;
        }

        top++;
        numbers[top] = value;
        System.out.println(value + " is added in Array");
    }

    ///add at last
    public void pop() {
        if (top == -1) {
            System.out.println("\nError: Stack is Empty");
            return;
        }

        int value = numbers[top];
        top--;

        System.out.println(value + " is removed from Stack");
    }

    //Display all values of the array
    public void Display() {
        if (top == -1) {
            System.out.println("\nError: Empty Array");
            return;
        }

        System.out.println("\nValues in Stack from Top to Bottom:");
        for (int i = top; i >= 0; i--) {
            System.out.print(numbers[i] + "\t");
        }
    }

    public void CurrentSize() {
        System.out.println("Current size of array is: " + (top + 1));
    }

    public void isEmpty() {
        if (top == -1) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty");
        }
    }

    public void isFull() {
        if (top == numbers.length - 1) {
            System.out.println("Array is full");
        } else {
            System.out.println("Array is not full");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array:");
        int capacity = sc.nextInt();
        stack q1 = new stack(capacity);
        int menu = 0;

        do {
            System.out.println("\n\n1 to PUSH");
            System.out.println("2 to POP");
            System.out.println("3 to DISPLAY");
            System.out.println("4 to SIZE");
            System.out.println("5 to ISEMPTY");
            System.out.println("6 to ISFULL");
            System.out.println("7 to EXIT");
            menu = sc.nextInt();

            if (menu == 1) {
                q1.push();
            } else if (menu == 2) {
                q1.pop();
            } else if (menu == 3) {
                q1.Display();
            } else if (menu == 4) {
                q1.CurrentSize();
            } else if (menu == 5) {
                q1.isEmpty();
            } else if (menu == 6) {
                q1.isFull();
            } else if (menu == 7) {
                System.out.println("Exiting the program...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        } while (menu != 7);

        sc.close();
    }
}