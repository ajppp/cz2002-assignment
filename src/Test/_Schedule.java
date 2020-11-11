public class _Schedule {
    private int[][][] timetable;
    // how to make the array consist of strings and int? or is it impossible lols

    public _Schedule(int[][][] timetable){
        this.timetable = timetable;
    }

    public boolean compareClash(int startTime, int endTime, String[] days, String ignoredIndex){
        // 1. convert starttime and endtime into array indices, unless we already pass in index values?
        // in main, take in user input as int already 
        for (int i=0; i<days.length+1; i++){
            for (int j=startTime; j<endTime; j++){
                if (timetable[j][i][0] != null && timetable[j][i][0] != ignoredIndex){
                    return false;
                }
            }
        }
        return true;
    }

    public void dropIndex(String droppedIndex){
        for (int i = 0; i < timetable.length+1; i++){
            for (int j = 0; j < timetable[i].length+1; j++){
                if (timetable[i][j][0] == droppedIndex) {
                    timetable[i][j][0] = null;
                }
            }
                
        }
    }
    
    public void addIndex(String index, String startTime, String endTime, String[] days){
        for (int i = 0; i < days.length+1; i++){
            for (int j = startTime; j < endTime+1; j++){
            }    
        }
    }
    
    public void addIndex(String index, int startTime, int endTime, String[] days){
        for (int i = 0; i < days.length+1; i++){
            for (int j = startTime; j < endTime; j++){
                timetable[j][i][0] = index;
            }
        }
    }
}
    

