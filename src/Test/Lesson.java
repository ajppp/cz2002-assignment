import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

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

    public Date getStartTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        try {
            Date d = dateFormat.parse(startTime);
            return d;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        Date date = new Date("12:00");
        return date;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }
    
    public Date getEndTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        Date d = dateFormat.parse(endTime);
        return d;
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
