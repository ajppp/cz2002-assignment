# CZ2002-MySTARS

MySTARS is a terminal-based application to handle the management and registration of courses by students. This assignment was done for CZ2002 Object Oriented Design and Programming in the academic Year 2020-2021 Sem 1.

## Usage

Clone or download this repository and follow the instructions below:

### MacOS or Linux

This will compile, run and initialise the application with pre-loaded data and students. It will also show the student IDs which can be used to log in to the student accounts. 
The text file containing the student IDs is in the directory data

`$ make all`

To continue running the application after exiting

`$ make run`

If you want to clear all the changes made and delete all data

`$ make clear`

To create new data

`$ make test`

For any other functions, please check the Makefile

### Windows

Run the jar file from the command prompt with:

`$ java -jar stars.jar`

If you need to restart the application with only the pre-loaded data without any changes, please delete this directory and download a new copy from [the repository](https://github.com/ajppp/cz2002-assignment)

### Data

Data is already generated for you under the Test class. There are 15 students and 5 admin accounts. The student user IDs are stored in data/student.txt This file is not used in the run-time of the application and is only used for ease of use and testing. The password for all students are set to be password

There are 5 admins and their ID and Password are as follows:

- Claudia Claudia123
- Elroy Elroy123
- Isabela Isabela123
- Lianran Lianran123
- Jethro Jethro123

## Built With

Vim

## Tested

Tried on Linux, MacOS and Windows terminal, working as of 25-11-2020

## Authors

DSAI2 Group 2

- Aurelio Jethro Prahara
- Claudia Beth Ong
- Lian Ran
- Isabela Angus
- Elroy Ang

## Documentation

JavaDoc is in the doc directory. 
