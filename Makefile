JFLAGS = -g
JC = javac
JAVADOC = javadoc

RM = rm -rf

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Choice.java \
		  AdminManager.java \
		  Course.java \
		  Index.java \
		  Lesson.java \
		  LoginManager.java \
		  LoginPage.java \
		  SerialEditor.java \
		  Student.java \
		  StudentManager.java \
		  Test.java

CLASSPATH=classes

DEPENDENCIES = lib/*

DATA = data/*

SOURCE = src/com/dsai2group2/*
		
default: compile

classes: $(CLASSES:.java=.class)

compile:
	$(JC) $(SOURCE) -cp "$(DEPENDENCIES)" -d $(CLASSPATH)

clean:
	$(RM) $(DATA) $(CLASSPATH)

test: 
	$(RM) $(DATA)
	java -cp "$(CLASSPATH):$(DEPENDENCIES)" Test > data/student.txt

run: show
	java -cp "$(CLASSPATH):$(DEPENDENCIES)" Choice

show:
	cat data/student.txt

javadoc:
	$(JAVADOC) -cp "$(DEPENDENCIES)"
