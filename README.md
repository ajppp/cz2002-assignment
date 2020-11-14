# CZ2002-MySTARS
---

The application is a terminal-based application to handle the management and registration of courses by students. 

---
## How to test (for cloud)
1. clone the repository
```bash
git clone https://github.com/ajppp/cz2002-assignment.git
```

2. go to the test directory and generate the data
```bash
cd cz2002-assignment/src/Test/
make data
```

3. delete all the class files
```bash
make clean
```

4. test the main function 
```bash
make
make run
```
