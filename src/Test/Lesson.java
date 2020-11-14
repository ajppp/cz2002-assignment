public class Lesson {
    private int lessonType;
    private int lessonDay;
    private int startPeriod;
    private int endPeriod;
    private String venue;

    public Lesson(int lessonType, int lessonDay, int startPeriod, int endPeriod, String venue){
        this.lessonType = lessonType;
        this.lessonDay = lessonDay;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.venue = venue;
    }

    public int getLessonType() {
        return lessonType;
    }


    public void setLessonType(int lessonType){
        this.lessonType = lessonType;
    }

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
    public int getLessonDay() {
        return lessonDay;
    }

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

    public void setLessonDay(int lessonDay){
        this.lessonDay = lessonDay;
    }

/*
 *    public Date getStartTime() throws Exception {
 *        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
 *        try {
 *            Date d = dateFormat.parse(startTime);
 *            return d;
 *        } catch (java.text.ParseException e) {
 *            e.printStackTrace();
 *        }
 *        Date date = new Date("12:00");
 *        return date;
 *    }
 *
 *    public void setStartTime(String startTime){
 *        this.startTime = startTime;
 *    }
 *    
 *    public Date getEndTime() throws Exception {
 *        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
 *        Date d = dateFormat.parse(endTime);
 *        return d;
 *    }
 *
 *    public void setEndTime(String endTime){
 *        this.endTime = endTime;
 *    }
 */

    public int getStartPeriod(){
        return startPeriod;
    }

    public void setStartPeriod(int startPeriod){
        this.startPeriod = startPeriod;
    }

    public int getEndPeriod(){
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod){
        this.endPeriod = endPeriod;
    }

    public String getStartTime(){
        return Integer.toString((100 * startPeriod) + 830);
    }

    public String getEndTime(){
        return Integer.toString((100 * endPeriod) + 830);
    }

    public String getVenue() {
        return this.venue;
    }

    public void setVenue(String venue){
        this.venue = venue;
    }

    
}
