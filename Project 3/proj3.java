/*
 * @author: 
 */

import java.util.*; 


interface Gym{
    public int guest=0; 
    Boolean[] month=new Boolean[30]; 

    void setPoints(int p);
    void memberShipStatus();
    void setGuest(int g);
    int getGuest();
    public void guest_privilages();
    public void getequipments(); 
    public void group_fitness();

    void classAttend(int day);
}

public class proj3{
    abstract class eqp implements Gym{
        @Override
        public
        abstract void getequipments();
    }
    public class Points_to_cash{
        public int cash; 
        Points_to_cash(int points){
            this.cash=points/100; 
            points=points/100+points&100; 
        }
        // 10 points per check in  
        // 100 points == 1$         100/10,  rem=100%10 
    }    

    static class Basic_plan implements Gym { 
        public double price=9.99; 
        int points; 
        int guest;
        int day;
        static int members=0; 
        Boolean[] month=new Boolean[30]; 
        public String equipment[]={"Bench-Press","Chest-Press","Leg-Press","Shoulder-Press"};  
        Basic_plan(){
            System.out.println("Basic Plan Created");
            this.points=0;
            this.day=1;
            this.guest=0; 
            members++;
            for(int i=0;i<month.length;i++){
                month[i]=false; 
            }
        }
        static int getMembers(){
            return members; 
        }
        public void setPoints(int p){
            this.points=p; 
        }
        int getPoints(){
            return points; 
        }
        public void memberShipStatus(){
            if(month[30]==true){
                System.out.println("Membership expired, Please Renew");
            } 
            else{
                System.out.println("Membership Not Expired");
            }
        } 
        public void setGuest(int g){
            this.guest+=g; 
        } 
        public int getGuest(){
            return guest; 
        }
        public void getequipments(){
            System.out.println("Equipments are accesible, Available Equipments"); 
            for (String s : equipment) { 
                System.out.print(s+" ");
            }
            System.out.println();
        } 
        public void guest_privilages(){
            if(points>=(10*getGuest())){
                points=points-(10*getGuest());
                System.out.println("Guest Privilages Accesible For Basic Plan");
            }
            else{
                System.out.println("Guest Privilages Not Accesible");
            }
        } 
        public void group_fitness(){
            System.out.println("Group Fitness Accesible");
            if(points>=(5*getGuest())){
                points=points-5*getGuest();
                System.out.println("Group Fitness For Basic Plan");
            }
            else{
                System.out.println("Group Fitness Not Accesible");
            }
        }
    
        public void classAttend(int day){ 
            month[day]=true; 
            // mp.put(day,true); 
            points+=10; 
        }
        void getAttendance(){
            for (int i = 0; i< month.length; i++) {            
                if(month[i]==true){
                    System.out.println("Present on date: "+i);
                }
            }
        } 
        void one_to_one(int booking_date,int curr_date){
            if(booking_date-curr_date>=1 && points>=10){
                points=points-10; 
                System.out.println("One to One Session Booked");
            }
            else{
                System.out.println("Cannout book one to one session");
            }
        }
    }
    
    
    
    static class Fox_plan implements Gym{
        int points; 
        int guest;
        int day; 
        static int members=0; 
        Boolean[] month=new Boolean[30]; 
        public double price=19.99; 
        public String equipment[]={"Bench-Press","Chest-Press","Leg-Press","Shoulder-Press"};  
        Fox_plan(){
            this.points=0; 
            this.day=1; 
            this.guest=0;
            members++; 
            for(int i=0;i<month.length;i++){
                month[i]=false; 
            }
        } 
        static int getMembers(){
            return members; 
        }
        public void setPoints(int p){
            this.points=p; 
        }
        int getPoints(){
            return points; 
        }
        public void memberShipStatus(){
            if(month[30]==true){
                System.out.println("Membership expired, please renew");
            } 
            else{
                System.out.println("Membership Not expired");
            }
        } 
        public void setGuest(int g){
            this.guest+=g; 
        } 
        public int getGuest(){
            return guest; 
        }
        public void getequipments(){
            System.out.println("Equipments are accesible, Available Equipments"); 
            for (String s : equipment) {
                System.out.print(s+" ");
            }
            System.out.println();
        } 
        public void guest_privilages(){
            System.out.println("Free Guest Privilages Accessible");
        } 
        public void group_fitness(){
            System.out.println("Group Fitness Accesible");
        }
    
        public void classAttend(int day){ 
            month[day]=true; 
            // mp.put(day,true); 
            points+=10; 
        }
        void getAttendance(){
            for (int i = 0; i< month.length; i++) {            
                if(month[i]==true){
                    System.out.println("Present on date: "+i);
                }
            }
        }
        void one_to_one(int booking_date,int curr_date){
            if(booking_date-curr_date>=1 && points>=10){
                points=points-10; 
                System.out.println("One to One Session Booked");
            }
            else{
                System.out.println("Cannout book one to one session");
            }
        }
    }
    
    static class membership{
        static int mem1=Basic_plan.getMembers();
        static int mem2=Fox_plan.getMembers();
        static int totalmem=mem1+mem2; 
        static  int getMembersTot(){
            return totalmem; 
        }
    }

    static void buy(HashMap<String, Integer> prod, String item, int points){
        if(points>=prod.get(item)){
            points=points-prod.get(item); 
            System.out.println("Bought "+item+" Remaining balance: "+points);
        }
        else{
            System.out.println("Not Enought Points");
        }
    }
    static int Store(int points,String item){
		HashMap<String, Integer> prod = new HashMap<>();
        prod.put("t-shirt", 10);
        prod.put("gym-bag", 30);
        prod.put("water-bottle", 20);
        prod.put("gloves", 20);
        prod.put("sweet-shirt", 20);
        prod.put("protien-shake", 20); 
        if(points>=prod.get(item)){
            points=points-prod.get(item); 
            System.out.println("Bought "+item+" Remaining balance: "+points);
        }
        else{
            throw new ArithmeticException("Not Enough Points");
        } 
        return points; 
    }
    public static void main(String[] args) {
        Fox_plan m1=new Fox_plan(); 
        Basic_plan m2=new Basic_plan();
        Basic_plan m3=new Basic_plan();
        m2.setGuest(5);
        m2.setPoints(5);
        m2.classAttend(8); 
        m2.classAttend(2); 
        m2.classAttend(3); 
        m2.classAttend(5); 
        m2.getAttendance(); 
        System.out.println(m2.getPoints()); 

        //member 1
        m1.getequipments();
        m1.setGuest(5); 
        m1.group_fitness(); 
        m1.setPoints(40);
        //Buying items from store
        m3.points=Store(m1.points,"protien-shake"); 

        m3.setGuest(1);
        m3.setPoints(14);
        m3.guest_privilages();
        //When Points balance is low 
        m3.points=Store(m3.points,"gym-bag"); 

        //One-to-one Sessions 
        m2.one_to_one(9, 4);

        //Getting total members 
        membership m=new membership(); 
        System.out.println("Total Members are: "+ m.getMembersTot()); 
    }
}