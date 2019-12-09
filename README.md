# Title: A perdictive implementation of conway's game of life

## Project Summary

This project is an implementation of Conway's Game of Life. The intended use of this simulation is for discovering oscillators of order less than 15 by comparing a series of generations of bounded Conway matrices. As this is a chaotic simulation, an initial array will be generated at random, this is more beneficial when running a simulation of a system whose evolution directly depends of the initial state of the system. In order to find stable state oscillators in an efficient manor that is not exponetially more costly in memory and runtime, the program will create a linked list of generated matrices with a list length of 15 that will remove the head matrix once the limit is reached. This allows for a static number of comparisions to be performed for matrices of all sizes. The program will run until an oscillator is detected. The user will see corresponding statistics about the simulator once the stable state is reached. At that time the user may save the initial matrix for later use or study. 
The goal is to generate a series of matrix transformations based on Conway's rules for the game of life. Matrices 

generate an n x m matrix of random 1s and 0s