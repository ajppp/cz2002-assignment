/**
 * The class contains the details about all lessons for a particular index
 */
public class Lesson implements java.io.Serializable{
    private static final long serialVersionUID = 8L;
    private int lessonType;
    private int lessonDay;
    private int startPeriod;
    private int endPeriod;
    private String venue;

    /**
     * This constructor defines a lesson
     * @param lessonType the type which the lesson is conducted; whether it is lecture, tutorial, lab or seminar
     * @param lessonDay the day which the lesson falls on
     * @param startPeriod the starting time of the lesson
     * @param endPeriod the ending time of the lesson
     * @param venue the venue which the lesson is held at
     */
    public Lesson(int lessonType, int lessonDay, int startPeriod, int endPeriod, String venue){
        this.lessonType = lessonType;
        this.lessonDay = lessonDay;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.venue = venue;
    }

    /**
     * @return the type which the lesson is conducted; whether it is lecture, tutorial, lab or seminar
     */
    public int getLessonType() {
        return lessonType;
    }


    /**
     * @param lessonType the type which the lesson is conducted; whether it is lecture, tutorial, lab or seminar
     */
    public void setLessonType(int lessonType){
        this.lessonType = lessonType;
    }

    /**
     * @return the conversion from integer to string version of lessonType
     */
    public String getLessonTypeStr() {
        String lessonTypeStr;
        switch (lessonType){
            case 1:
                lessonTypeStr = "Lecture";
                break;
            case 2:
                lessonTypeStr = "Tutorial";
                break;
            case 3:
                lessonTypeStr = "Lab";
                break;
            case 4: 
                lessonTypeStr = "Seminar";
                break;
            default:
                lessonTypeStr = "Lecture";
        }
        return lessonTypeStr;
    }
    
    /**
     * @return the day which the lesson falls on
     */
    public int getLessonDay() {
        return lessonDay;
    }

    /**
     * @return the conversion from integer to string version of lessonDay
     */
    public String getLessonDayStr(){
        String lessonDayStr;
        switch (lessonDay){
            case 1:
                lessonDayStr = "Monday";
                break;
            case 2:
                lessonDayStr = "Tuesday";
                break;
            case 3:
                lessonDayStr = "Wednesday";
                break;
            case 4:
                lessonDayStr = "Thursday";
                break;
            case 5:
                lessonDayStr = "Friday";
                break;
            default:
                lessonDayStr = "Saturday";
                break;
        }
        return lessonDayStr;
    }

    /**
     * @param lessonDay the day which the lesson falls on
     */
    public void setLessonDay(int lessonDay){
        this.lessonDay = lessonDay;
    }

    /**
     * @return the starting time of the lesson
     */
    public int getStartPeriod(){
        return startPeriod;
    }

    /**
     * @param startPeriod the starting time of the lesson
     */
    public void setStartPeriod(int startPeriod){
        this.startPeriod = startPeriod;
    }

    /**
     * @return the ending time of the lesson
     */
    public int getEndPeriod(){
        return endPeriod;
    }

    /**
     * @param endPeriod the ending time of the lesson
     */
    public void setEndPeriod(int endPeriod){
        this.endPeriod = endPeriod;
    }

    /**
     * @return the conversion from datetime format to string version of startPeriod
     */
    public String getStartTime(){
        return Integer.toString((100 * startPeriod) + 830);
    }

    /**
     * @return the conversion from datetime format to string version of endPeriod
     */
    public String getEndTime(){
        return Integer.toString((100 * endPeriod) + 830);
    }

    /**
     * @return the venue which the lesson is held at
     */
    public String getVenue() {
        return this.venue;
    }

    /**
     * @param venue the venue which the lesson is held at
     */
    public void setVenue(String venue){
        this.venue = venue;
    }

    
}
