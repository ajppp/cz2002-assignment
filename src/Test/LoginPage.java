import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class LoginPage implements java.io.Serializable{
    private static final long serialVersionUID = 5L;
    private Date startLoginTime;
    private Date endLoginTime;

    public LoginPage(Date startLoginTime, Date endLoginTime){
        this.startLoginTime = startLoginTime;
        this.endLoginTime = endLoginTime;
    }

    public LoginPage(){}

    public Date getStartLoginTime(){
        return startLoginTime;
    }

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
    public void setStartLoginTime(Date startLoginTime){ // will think about the parameter again
        this.startLoginTime = startLoginTime;
    }

    public void setEndLoginTime(Date endLoginTime){
        this.endLoginTime = endLoginTime;
    }

    // need to have a getCurTime method in login console class
    public boolean compareCurrentTime(Date curTime){
        if (curTime.after(startLoginTime) && curTime.before(endLoginTime)){
            return true;
        }
        else {
            return false;
        }
    }  
}
