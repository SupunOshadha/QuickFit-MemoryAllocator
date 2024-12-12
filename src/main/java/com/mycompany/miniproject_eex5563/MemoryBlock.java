
package com.mycompany.miniproject_eex5563;

public class MemoryBlock {
     int size;
    String blockId;
    boolean isFree; // Indicates if the block is free

    public MemoryBlock(int size, String blockId) {
        this.size = size;
        this.blockId = blockId;
        this.isFree = true;
    }
    
}
