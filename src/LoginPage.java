import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * This class contains the information about the date and time allowed for student to login
 */
public class LoginPage implements java.io.Serializable{
    private static final long serialVersionUID = 5L;
    private Date startLoginTime;
    private Date endLoginTime;

    /**
     * @param startLoginTime the time from which the student is allowed to log in
     * @param endLoginTime the time from which the student is not allowed to log in
     */
    public LoginPage(Date startLoginTime, Date endLoginTime){
        this.startLoginTime = startLoginTime;
        this.endLoginTime = endLoginTime;
    }

    public LoginPage(){}

    /**
     * @return the time from which the student is allowed to log in
     */
    public Date getStartLoginTime(){
        return startLoginTime;
    }

    /**
     * @return endLoginTime the time from which the student is not allowed to log in
     */
    public Date getEndLoginTime(){
        return endLoginTime;
    }

/*
 *    public Date getStartLoginTimeString(){
 *        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
 *        return formatter.format(startLoginTime);
 *    }
 *
 *    public Date getEndLoginTimeString(){
 *        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
 *        return formatter.format(endLoginTime);
 *    }
 */

    //only can be done by admin
    /**
     * The admin is allowed to set the startLoginTime for the students
     * @param startLoginTime the time from which the student is allowed to log in
     */
    public void setStartLoginTime(Date startLoginTime){ // will think about the parameter again
        this.startLoginTime = startLoginTime;
    }

    /**
     * The admin is allowed to set the endLoginTime for the students
     * @param endLoginTime the time from which the student is not allowed to log in
     */
    public void setEndLoginTime(Date endLoginTime){
        this.endLoginTime = endLoginTime;
    }

    // need to have a getCurTime method in login console class
    /**
     * Compares the current time with the stipulated login time for the students
     * @param curTime the current time which the student is trying to log in
     * @return a boolean value of true if the current time is within the stipulated time and a false if it is not
     */
    public boolean compareCurrentTime(Date curTime){
        if (curTime.after(startLoginTime) && curTime.before(endLoginTime)){
            return true;
        }
        else {
            return false;
        }
    }  
}
