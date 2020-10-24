import java.time.LocalTime;

public class Lesson {
    private int lessonType;
    private int lessonDay;
    private String startTime;
    private String endTime;
    private String venue;

    public Lesson(int lessonType, int lessonDay, String startTime, String endTime, String venue){
        this.lessonType = lessonType;
        this.lessonDay = lessonDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
    }

    public int getLessonType() {
        return this.lessonType;
    }

    public void setLessonType(int lessonType){
        this.lessonType = lessonType;
    }

    public int getLessonDay() {
        return this.lessonDay;
    }

    public void setLessonDay(int lessonDay){
        this.lessonDay = lessonDay;
    }

    public LocalTime getStartTime(){
            LocalTime d = LocalTime.parse(startTime);
            return d;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }
    
    public LocalTime getEndTime() {
        return LocalTime.parse(endTime);
    }

    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    public String getVenue() {
        return this.venue;
    }

    public void setVenue(String venue){
        this.venue = venue;
    }

    
}
