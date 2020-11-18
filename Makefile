JFLAGS = -g
JC = javac

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

SOURCE = src/*
		
default: compile

classes: $(CLASSES:.java=.class)

compile:
	$(JC) $(SOURCE) -cp "$(DEPENDENCIES)" -d $(CLASSPATH)

clean:
	$(RM) $(DATA) $(CLASSES)

test: 
	$(RM) $(DATA)
	java -cp "$(CLASSPATH):$(DEPENDENCIES)" Test

run:
	java -cp "$(CLASSPATH):$(DEPENDENCIES)" Choice
