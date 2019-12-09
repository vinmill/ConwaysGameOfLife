# Title: A perdictive implementation of conway's game of life

## Project Summary

This project is an implementation of Conway's Game of Life. The intended use of this simulation is for discovering oscillators of order less than 15 by comparing a series of generations of bounded Conway matrices. As this is a chaotic simulation, an initial array will be generated at random, this is more beneficial when running a simulation of a system whose evolution directly depends of the initial state of the system. In order to find stable state oscillators in an efficient manor that is not exponetially more costly in memory and runtime, the program will create a linked list of generated matrices with a list length of 15 that will remove the head matrix once the limit is reached. This allows for a static number of comparisions to be performed for matrices of all sizes. The program will run until an oscillator is detected. The user will see corresponding statistics about the simulator once the stable state is reached. At that time the user may save the initial matrix for later use or study. 


## Algorithm

The general rules for the game of life are as follows:

1. There should be no explosive growth.
2. There should exist small initial patterns with chaotic, unpredictable outcomes.
3. There should be potential for von Neumann universal constructors.
4. The rules should be as simple as possible, whilst adhering to the above constraints.

For each cell in the matrix the following rules will be followed.

For each cell there will be a method that will count the number of living cells immediately surrounding the cell. For example consider this 3 x 3 matrix:

Matrix:
010
111
010

Counting the living cells surrouding the cell at position (2,2) gives us the following result: 4

Rules for living cells:

1. If a cell is living and has a neighboring sum of less than 2, it will die of loneliness.
2. If a cell is living and has a neighboring sum of greater than 3, it will die of overpopulation.
3. If a cell is living and has a neighboring population of 2 or 3 it will live on.

Rules for dead cells:

1. If a cell is dead and has a neighboring population of 3, it will become alive.
2. If a cell is dead and has a neighboring population of less than 3 it will remain dead.
3. If a cell is dead and has a neighboring population of more than 3 it will remain dead.

### Classes and methods

#### GameOfLife

This method will have initializing random arrays for given parameter, returning a matrix to the console, generating new matrices, evaluating the matrix at a given position, counting living neighbors of an array at a given position.

#### LinkedMatrices

This method will be in charge of creating a double linked list of matrices, appending new matrices  searching for nodes, comparing nodes, finding matching nodes. This method will essentially be the runner for the mathcing process.

The delete method will be used for deleting and reassigning the head of the linked list. This will allow for cleanup when comparing the stem of the linked list to the other nodes.

#### Nodes

This method will be in charge of returning node values, setting linked node pointers, and retrieving linked nodes

#### Main

This method while contain all the methods for console i/o, instructions, and runners for the  simulation. This will also contain methods for serializing configuration objects for later use in simulations.

#### Configuration

This method will contain the getters and setters for creating Configuration objects. The Configuration object will contain an initial matrix that can be used for instantiating GameOfLife matrices in the case that you want to study a simulation further. Other information about the configuration will also be store in the object including dimensions, number of generations before a stable state is reached, and maximum period of the terminating stable state.