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
		  LoginManager.java \
		  LoginPage.java \
		  Schedule.java \
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
