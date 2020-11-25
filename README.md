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

## Directory Structure

```
cz2002-assignment
├── classes
│   ├── AdminManager.class
│   ├── Choice.class
│   ├── Course.class
│   ├── CourseIndex$1.class
│   ├── CourseIndex.class
│   ├── Index$1.class
│   ├── Index.class
│   ├── Lesson.class
│   ├── LoginManager.class
│   ├── LoginPage.class
│   ├── SerialEditor.class
│   ├── Student.class
│   ├── StudentManager.class
│   └── Test.class
├── data
│   ├── course.ser
│   ├── loginDetails.ser
│   ├── loginTiming.ser
│   ├── student.ser
│   └── student.txt
├── doc
│   ├── AdminManager.html
│   ├── allclasses-index.html
│   ├── allpackages-index.html
│   ├── Choice.html
│   ├── class-use
│   │   ├── AdminManager.html
│   │   ├── Choice.html
│   │   ├── Course.html
│   │   ├── CourseIndex.html
│   │   ├── Index.html
│   │   ├── Lesson.html
│   │   ├── LoginManager.html
│   │   ├── LoginPage.html
│   │   ├── SerialEditor.html
│   │   ├── Student.html
│   │   ├── StudentManager.html
│   │   └── Test.html
│   ├── constant-values.html
│   ├── Course.html
│   ├── CourseIndex.html
│   ├── deprecated-list.html
│   ├── element-list
│   ├── help-doc.html
│   ├── index-files
│   │   ├── index-10.html
│   │   ├── index-11.html
│   │   ├── index-12.html
│   │   ├── index-13.html
│   │   ├── index-14.html
│   │   ├── index-15.html
│   │   ├── index-1.html
│   │   ├── index-2.html
│   │   ├── index-3.html
│   │   ├── index-4.html
│   │   ├── index-5.html
│   │   ├── index-6.html
│   │   ├── index-7.html
│   │   ├── index-8.html
│   │   └── index-9.html
│   ├── index.html
│   ├── Lesson.html
│   ├── LoginManager.html
│   ├── LoginPage.html
│   ├── member-search-index.js
│   ├── member-search-index.zip
│   ├── overview-tree.html
│   ├── package-search-index.js
│   ├── package-search-index.zip
│   ├── package-summary.html
│   ├── package-tree.html
│   ├── package-use.html
│   ├── resources
│   │   ├── glass.png
│   │   └── x.png
│   ├── script-dir
│   │   ├── external
│   │   │   └── jquery
│   │   │       └── jquery.js
│   │   ├── images
│   │   │   ├── ui-bg_glass_55_fbf9ee_1x400.png
│   │   │   ├── ui-bg_glass_65_dadada_1x400.png
│   │   │   ├── ui-bg_glass_75_dadada_1x400.png
│   │   │   ├── ui-bg_glass_75_e6e6e6_1x400.png
│   │   │   ├── ui-bg_glass_95_fef1ec_1x400.png
│   │   │   ├── ui-bg_highlight-soft_75_cccccc_1x100.png
│   │   │   ├── ui-icons_222222_256x240.png
│   │   │   ├── ui-icons_2e83ff_256x240.png
│   │   │   ├── ui-icons_454545_256x240.png
│   │   │   ├── ui-icons_888888_256x240.png
│   │   │   └── ui-icons_cd0a0a_256x240.png
│   │   ├── jquery-3.4.1.js
│   │   ├── jquery-ui.css
│   │   ├── jquery-ui.js
│   │   ├── jquery-ui.min.css
│   │   ├── jquery-ui.min.js
│   │   ├── jquery-ui.structure.css
│   │   ├── jquery-ui.structure.min.css
│   │   ├── jszip
│   │   │   └── dist
│   │   │       ├── jszip.js
│   │   │       └── jszip.min.js
│   │   └── jszip-utils
│   │       └── dist
│   │           ├── jszip-utils-ie.js
│   │           ├── jszip-utils-ie.min.js
│   │           ├── jszip-utils.js
│   │           └── jszip-utils.min.js
│   ├── script.js
│   ├── search.js
│   ├── SerialEditor.html
│   ├── serialized-form.html
│   ├── Student.html
│   ├── StudentManager.html
│   ├── stylesheet.css
│   ├── system-properties.html
│   ├── Test.html
│   ├── type-search-index.js
│   └── type-search-index.zip
├── lib
│   ├── activation.jar
│   ├── javax.mail.jar
│   └── mail.jar
├── Makefile
├── MANIFEST.MF
├── README.md
├── src
│   ├── AdminManager.java
│   ├── Choice.java
│   ├── CourseIndex.java
│   ├── Course.java
│   ├── Lesson.java
│   ├── LoginManager.java
│   ├── LoginPage.java
│   ├── SerialEditor.java
│   ├── Student.java
│   ├── StudentManager.java
│   └── Test.java
└── stars.jar
```

