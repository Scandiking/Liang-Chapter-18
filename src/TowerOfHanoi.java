import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);
        System.out.println("Enter the number of disks to display: ");
        int n = scanscan.nextInt();

        // Find the solution recursively
        System.out.println("The moves are: ");
        moveDisks(n, 'A', 'B', 'C');
    }

        // The method for finding the solution to move n disks from fromTower to toTower with auxTower
    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        if (n == 1) { // Stopping condition
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        } else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
        }
    }

