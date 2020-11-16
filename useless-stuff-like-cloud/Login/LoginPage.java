package src.Login;
import java.util.*;


public class LoginPage implements java.io.Serializable{
    private static final long serialVersionUID = 5L;
    private Date startLoginTime;
    private Date endLoginTime;

    private LoginPage(Date startLoginTime, Date endLoginTime){
        this.startLoginTime = startLoginTime;
        this.endLoginTime = endLoginTime;
    }

    private Date getStartLoginTime(){
        return startLoginTime;
    }

    private Date getEndLoginTime(){
        return endLoginTime;
    }

    //only can be done by admin
    private void setStartLoginTime(Date startLoginTime){ // will think about the parameter again
        this.startLoginTime = startLoginTime;
    }

    private void setEndLoginTime(Date endLoginTime){
        this.endLoginTime = endLoginTime;
    }

    // need to have a getCurTime method in login console class
    private boolean compareCurrentTime(Date curTime){
        if (curTime.after(startLoginTime) && curTime.before(endLoginTime)){
            return true;
        }
        else {
            return false;
        }
    }  
}
