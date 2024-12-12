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
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numBlocks; i++) {
            System.out.print("Enter size of block " + (i + 1) + " (in KB): ");
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter block ID for block " + (i + 1) + ": ");
            String blockId = scanner.nextLine();
            allocator.addMemoryBlock(size, blockId);
        }

        // Input processes
        System.out.print("\nEnter the number of processes: ");
        int numProcesses = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter process ID for process " + (i + 1) + ": ");
            String processId = scanner.nextLine();
            System.out.print("Enter size of process " + (i + 1) + " (in KB): ");
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            processes.add(new Process(processId, size));
        }

        // Allocate memory to processes
        for (Process process : processes) {
            allocator.allocateMemory(process);
        }

        // Display final memory state
        allocator.displayMemoryState();

        scanner.close();
    }
}






