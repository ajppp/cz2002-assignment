JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Choice.java \
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

test: 
	java Test

run:
	java Choice
