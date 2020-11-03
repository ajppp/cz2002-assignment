public class Lesson {
    private int lessonType;
    private int lessonDay;
    private int startPeriod;
    private int endPeriod;
    private String lessonVenue;

    public Lesson(int lessonType, int lessonDay, int startPeriod, int endPeriod, String venue){
        this.lessonType = lessonType;
        this.lessonDay = lessonDay;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.lessonVenue = venue;
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

    public int getStartPeriod(){
            return startPeriod;
    }

    public void setStartPeriod(int startPeriod){
        this.startPeriod = startPeriod;
    }
    
    public int getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod){
        this.endPeriod = endPeriod;
    }

    public String getVenue() {
        return lessonVenue;
    }

    public void setVenue(String venue){
        lessonVenue = venue;
    }
    
    
}
