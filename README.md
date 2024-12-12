# Quick Fit Memory Allocator

A Java-based simulation of the Quick Fit memory allocation algorithm. This project allows users to dynamically allocate and manage memory blocks using efficient techniques to reduce allocation time and fragmentation.

## Features
- **Memory Block Management**: Add memory blocks with custom sizes and IDs.
- **Process Allocation**: Allocate processes to memory blocks efficiently using the Quick Fit algorithm.
- **Memory State Visualization**: Display the current state of memory blocks, including allocations and available blocks.
- **Splitting**: Splits larger blocks to fit smaller process sizes if exact matches are unavailable.
- **Reallocation**: Handles fragmentation effectively by managing leftover memory as separate blocks.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java-compatible IDE or terminal

## Getting Started

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/quickfit-memory-allocator.git
   ```
2. Navigate to the project directory:
   ```bash
   cd quickfit-memory-allocator
   ```
3. Open the project in your preferred Java IDE or compile using the terminal.

### Usage
1. Run the `QuickFitSimulation` class to start the program.
2. Input the number of memory blocks, their sizes, and IDs.
3. Enter the number of processes, their IDs, and sizes.
4. The program will allocate memory to processes and display the results.
5. View the final memory state.

### Example Run
#### Input:
```
Enter the number of memory blocks: 3
Enter size of block 1 (in KB): 50
Enter block ID for block 1: Block1
Enter size of block 2 (in KB): 100
Enter block ID for block 2: Block2
Enter size of block 3 (in KB): 150
Enter block ID for block 3: Block3

Enter the number of processes: 2
Enter process ID for process 1: P1
Enter size of process 1 (in KB): 50
Enter process ID for process 2: P2
Enter size of process 2 (in KB): 120
```
#### Output:
```
Process P1 allocated to Block1
Process P2 allocated to Block3 with splitting

Current Memory State:
Size 50 KB: SplitBlock(Block3) (Allocated to: Free), 
Size 100 KB: Block2 (Allocated to: Free), 
```

## Testing
This program has been tested with:
- Various combinations of memory block and process sizes
- Scenarios to evaluate splitting and reallocation

### Sample Results
| Process ID | Process Size | Allocated Block ID | Remarks                   |
|------------|--------------|--------------------|---------------------------|
| P1         | 50 KB        | Block1            | Exact size match          |
| P2         | 120 KB       | Block3            | Splitting performed       |
| P3         | 200 KB       | -                 | Insufficient memory       |

## Future Enhancements
- Add support for deallocation of processes.
- Enhance the visualization of memory allocation using a graphical interface.
- Optimize for real-world scenarios, including varying block sizes dynamically.

## License
This project is licensed under the MIT License. Feel free to use and modify it as needed.

## Author
Supun Oshadha(https://github.com/SupunOshadha)
