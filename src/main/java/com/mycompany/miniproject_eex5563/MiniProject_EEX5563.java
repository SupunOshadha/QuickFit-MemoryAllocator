package com.mycompany.miniproject_eex5563;

import java.util.*;

public class MiniProject_EEX5563{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuickFitAllocator allocator = new QuickFitAllocator();

        System.out.println("----------------Welcome to the Quick Fit Memory Allocator Simulation!------------");

        // Input memory blocks
        System.out.print("Enter the number of memory blocks: ");
        int numBlocks = scanner.nextInt();
        scanner.nextLine(); // newline

        for (int i = 0; i < numBlocks; i++) {
            System.out.print("Enter size of block " + (i + 1) + " (in KB): ");
            int size = scanner.nextInt();
            scanner.nextLine(); //  newline
            System.out.print("Enter block ID for block " + (i + 1) + ": ");
            String blockId = scanner.nextLine();
            allocator.addMemoryBlock(size, blockId);
        }
        
        // Display initial memory state
        System.out.println("\nInitial Memory State:");
        allocator.displayMemoryState();
        
        // Input processes
        System.out.print("\nEnter the number of processes: ");
        int numProcesses = scanner.nextInt();
        scanner.nextLine(); //  newline

        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter process ID for process " + (i + 1) + ": ");
            String processId = scanner.nextLine();
            System.out.print("Enter size of process " + (i + 1) + " (in KB): ");
            int size = scanner.nextInt();
            scanner.nextLine(); //  newline
            processes.add(new Process(processId, size));
        }

        // Allocate memory to processes
        System.out.println("--------------------------------");
        System.out.println("\nAllocating memory to proceses:");
        for (Process process : processes) {
            allocator.allocateMemory(process);
        }

        // Display final memory state
        System.out.println("\nFinal Memory State:");
        allocator.displayMemoryState();
        
         // Display free and allocated blocks separately
        System.out.println("\nFree Memory Blocks:");
        allocator.displayFreeBlocks();
        
        System.out.println("\nAllocated Memory Blocks:");
        allocator.displayAllocatedBlocks();
        
        scanner.close();
    }
}






