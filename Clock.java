import java.util.*;

class Clock {
    
    int hr, min;
    
    Clock(int hr, int min){
        this.hr = hr;
        this.min = min;
    }
    
    public double calculateHourHand(){
        //Considering 12 as origin. When hour hand between two, using min/60 we can calculate where exactly is the hr hand in between.
        //For 12 hr 360 degree, so for 1 hr 30 degree
        
        double h_angle = (hr + min/60.0) * 30;
        return h_angle;
    }
    
    public int calculateMinuteHand(){
        
        //For 60 min 360 degree, so for 1 min 6 degree
        
        int m_angle = min * 6;
        return m_angle;
    }
    
    public double findAngle(){
        
        double diff;
        double h_angle = calculateHourHand();
        int m_angle = calculateMinuteHand();
        
        if(m_angle>h_angle) diff = m_angle - h_angle;
        else                diff = h_angle - m_angle;
        
        if(diff > 180)  return (360-diff);
        return diff;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int hr, min;
        
        System.out.print("Enter time hour : ");
        hr = sc.nextInt();
        System.out.print("\nEnter time minute : ");
        min = sc.nextInt();
        
        Clock C1 = new Clock(hr,min);
        System.out.println("\nAngle between hour and minute hand is : " + C1.findAngle());
    }
}