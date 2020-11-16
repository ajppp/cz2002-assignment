JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = AbstractCourse.java \
		  Choice.java \
		  Course.java \
		  EraserClass.java \
		  Index.java \
		  Lesson.java \
		  LoginManager.java \
		  LoginPage.java \
		  PasswordField.java \
		  SerialEditor.java \
		  Student.java \
		  Test.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

data: 
	$(JC) $(JFLAGS) Test.java
	java Test
	$(RM) Test.class

run:
	java Choice
