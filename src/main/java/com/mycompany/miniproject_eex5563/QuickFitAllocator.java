
package com.mycompany.miniproject_eex5563;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class QuickFitAllocator {
    private Map<Integer, LinkedList<MemoryBlock>> memoryBlocks;

    public QuickFitAllocator() {
        memoryBlocks = new HashMap<>();
    }

    public void addMemoryBlock(int size, String blockId) {
        memoryBlocks.computeIfAbsent(size, k -> new LinkedList<>())
                    .add(new MemoryBlock(size, blockId));
    }

    public void allocateMemory(Process process) {
        int processSize = process.size;

        // Check for an exact size match
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

        // If no exact match, find the next available block
        for (int size : memoryBlocks.keySet()) {
            if (size >= processSize) {
                LinkedList<MemoryBlock> blocks = memoryBlocks.get(size);
                for (MemoryBlock block : blocks) {
                    if (block.isFree) {
                        block.isFree = false;

                        // Splitting logic if block is larger than needed
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
        System.out.println("\nCurrent Memory State:");
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
}
