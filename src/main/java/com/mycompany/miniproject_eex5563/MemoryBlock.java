
package com.mycompany.miniproject_eex5563;

public class MemoryBlock {
    int size;                     
    String blockId;
    boolean isFree;              

    public MemoryBlock(int size, String blockId) {
        this.size = size;        // Initializes the block's size
        this.blockId = blockId;  // Assigns the unique block ID.
        this.isFree = true;      //Initially, the block is unallocated.
    }
    
}
