JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = AbstractCourse.java \
		  Choice.java \
		  Course.java \
		  Index.java \
		  Lesson.java \
		  LessonDay.java \
		  LessonType.java \
		  LoginPage.java \
		  Main.java \
		  SerialEditor.java \
		  Student.java\


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

data: 
	$(JC) $(JFLAGS) Test.java
	java Test
	$(RM) Test.class

run:
	java Main
