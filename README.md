# Trouble-Shooting-Search-
-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleShootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile troubleShootSearchp/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=<debug level> 


-----------------------------------------------------------------------
## Description:
This project provide an online trouble shooter for customers. For each distinct products of the given four which are
in the form of ArrayList of strings we find the Exact match, Naive Stemming match, Semantic match with respective
the user input text and synonyms given.


