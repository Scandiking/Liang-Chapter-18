/*
Tower of Hanoi
Modify Listing 18.8, TowerOfHanoi.java, so the program finds the number of moves needed to move n disks from tower A to
tower B. Hint: use a static variable and increment it every time the method is called.
 */

import java.util.Scanner;

public class Section_18_18 {
    private static int moveCount = 0;
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the number of disks: ");
        int n = scanscan.nextInt();

        // Reset move counter
        moveCount = 0;

        // Solve Tower of Hanoi
        moveDisks(n, 'A', 'B', 'C');

        // Display the total number of moves
        System.out.print("Total moves needed: " + moveCount);

        scanscan.close();
    }

    // Recursive method to solve Tower of Hanoi
    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveCount++; // Increment move counter
            return;
        }

        // Move n-1 disks from 'A' to 'C' using 'B'
        moveDisks(n-1, fromTower, auxTower, toTower);

        // Move nth disk from 'A' to 'B'
        System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        moveCount++; // Increment move counter

        // Move n-1 disks from 'C' to 'B' using 'A'
        moveDisks(n-1, auxTower, toTower, fromTower);
    }
}


