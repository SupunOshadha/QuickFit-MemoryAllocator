
package com.mycompany.miniproject_eex5563;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class QuickFitAllocator {
    private Map<Integer, LinkedList<MemoryBlock>> memoryBlocks;

    public QuickFitAllocator() { 
        memoryBlocks = new HashMap<>();   // Initializes the memory block storage
    }

    // Adds a memory block to the allocator with the given size and block ID
    public void addMemoryBlock(int size, String blockId) {
            if (size <= 0) {  // Validate block size is positive
                System.out.println("Error: Memory block size must be greater than 0.");
                return;
        }
        memoryBlocks.computeIfAbsent(size, k -> new LinkedList<>())
                    .add(new MemoryBlock(size, blockId));
    }

    public void allocateMemory(Process process) {
        int processSize = process.size; // Look for an exact fit

        // Check for an exact size match for the process
        if (memoryBlocks.containsKey(processSize)) {
            LinkedList<MemoryBlock> blocks = memoryBlocks.get(processSize);
            for (MemoryBlock block : blocks) {
                if (block.isFree) {
                    block.isFree = false;
                    System.out.println("Process " + process.processId + " allocated to block " + block.blockId);
                    return;
                }
            }
        }

        // If no exact match, find the next available block that is large enough
        for (int size : memoryBlocks.keySet()) {
            if (size >= processSize) {
                LinkedList<MemoryBlock> blocks = memoryBlocks.get(size);
                for (MemoryBlock block : blocks) {
                    if (block.isFree) {           // Check if the block is free
                        block.isFree = false;     // Allocate the block

                        // If the block is larger than the process, split the block
                        if (block.size > processSize) {
                            int remainingSize = block.size - processSize;
                            block.size = processSize;
                            String newBlockId = "Split-" + block.blockId;
                            addMemoryBlock(remainingSize, newBlockId);
                            System.out.println("Block " + block.blockId + " split; created block " + newBlockId);
                        }

                        System.out.println("Process " + process.processId + " allocated to block " + block.blockId);
                        return;
                    }
                }
            }
        }

        System.out.println("Process " + process.processId + " could not be allocated (insufficient memory)");
    }

    public void displayMemoryState() {
        for (Map.Entry<Integer, LinkedList<MemoryBlock>> entry : memoryBlocks.entrySet()) {
            int size = entry.getKey();
            LinkedList<MemoryBlock> blocks = entry.getValue();
            System.out.print("Size " + size + " KB: ");
            for (MemoryBlock block : blocks) {
                System.out.print(block.blockId + " (Free: " + block.isFree + "), ");
            }
            System.out.println();
        }
    }
    
    // Displays all free memory blocks, grouped by size
    public void displayFreeBlocks() {
    for (Map.Entry<Integer, LinkedList<MemoryBlock>> entry : memoryBlocks.entrySet()) {
        LinkedList<MemoryBlock> blocks = entry.getValue();
        System.out.print("Size " + entry.getKey() + " KB: ");
        for (MemoryBlock block : blocks) {
            if (block.isFree) {
                System.out.print(block.blockId + ", ");
            }
        }
        System.out.println();
    }
}
     // Displays all allocated memory blocks, grouped by size
    public void displayAllocatedBlocks() {
        for (Map.Entry<Integer, LinkedList<MemoryBlock>> entry : memoryBlocks.entrySet()) {
            LinkedList<MemoryBlock> blocks = entry.getValue();
            System.out.print("Size " + entry.getKey() + " KB: ");
            for (MemoryBlock block : blocks) {
                if (!block.isFree) {
                    System.out.print(block.blockId + ", ");
                }
            }
            System.out.println();
        }
    }

}
