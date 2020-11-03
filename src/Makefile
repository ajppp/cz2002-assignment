JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
					Student.java\
					EraserClass.java\
					Index.java\
					Lesson.java\
					LoginPage.java\
					PasswordField.java\
					Student.java\
					FileEditor.java\
					Main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

run:
	java Main
