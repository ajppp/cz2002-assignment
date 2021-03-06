JFLAGS = -g
JC = javac
JAVADOC = javadoc
JAR = jar

RM = rm -rf

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Choice.java \
		  AdminManager.java \
		  Course.java \
		  CourseIndex.java \
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

all: compile test run

classes: $(CLASSES:.java=.class)

compile:
	$(JC) $(SOURCE) -cp "$(DEPENDENCIES)" -d $(CLASSPATH)

clean:
	$(RM) $(DATA) $(CLASSPATH)

jar:
	$(JAR) cfm stars.jar MANIFEST.MF -C $(CLASSPATH) .

test: 
	$(RM) $(DATA)
	java -cp "$(CLASSPATH):$(DEPENDENCIES)" Test > data/student.txt

run: show
	java -cp "$(CLASSPATH):$(DEPENDENCIES)" Choice

show:
	cat data/student.txt

javadoc:
	$(JAVADOC) -cp "$(DEPENDENCIES)"
