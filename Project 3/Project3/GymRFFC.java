package Project3; 
import java.util.*; 
public class GymRFFC{  
    //Creating a Interface for Gym
    interface gym1{
        void getCash(int points); 
        void totalMembers(); 
    }

    //Craeting Abstract Class for Gym
    abstract static class Store{
        HashMap<String, Integer> store = new HashMap<>(); 
        int balance,item_price,points; 
        Store(){
            store.put("Muscle Blaze", 150);
            store.put("GNC", 100);
            store.put("MyProtein", 70);
            store.put("T-Shirt", 80);
            store.put("Sling-Bag", 60);
            store.put("RedBull", 100); 
        }
    }
    
    //Craeting Abstract Class for Gym
    static abstract class Gym extends Store implements gym1{
        Boolean[] schedule=new Boolean[30];  
        static int members=0; 
        int cash;   
        int points; 
        int guest;
        int day;
        double plan; 
        public void getCash(int points){
            this.cash=points/100; 
            points=points/100+points&100; 
            System.out.println("Converted Points to, Total Cash: "+cash);
        }
        //Constructor fot Abstract Class 
        Gym(){
            members++; 
        } 
        //Getting Total Member Count
        public void totalMembers(){
            System.out.println("Total Members are: "+members);
        }
    } 

    static class Basic_plan extends Gym{ 
        double plan=9.99; 
        Basic_plan(){
            this.guest=0; 
            this.points=0;
            this.day=1;
            for(int i=0;i<schedule.length;i++){
                schedule[i]=false; 
            }
        }
        void getPlanDetails(){
            System.out.println("Basic Plan Cost is: "+plan);
            System.out.println("Guest Privilages Cost 10$ per session");
            System.out.println("Group Fitness Cost 5$ per Session"); 
        }
        void setPoints(int p){
            this.points=p; 
        }
        int getPoint(){
            return points; 
        }
        void isMembershipValid(){
            if(schedule[30]==true){
                System.out.println("Membership has Not Expired");
            } 
            else{
                System.out.println("Membership has Expired");
            }
        } 
        void setNoGuest(int g){
            this.guest+=g; 
        } 
        int getNoGuest(){
            return guest; 
        }
        //guest privilages for Basic Plan
        void guestPrivilages() throws Exception{
            if(this.guest<1){
                throw new Exception("Not Enought Guest");
            }
            if(this.points>=(10*getNoGuest())){
                points=points-(10*getNoGuest());
                System.out.println("Guest Privilages For Basic Plan");
            }
            else{
                System.out.println("Not Enough Money");
            }
        } 
        void bookGroupFitnessSession(){
            System.out.println("Group Fitness For Basic Plan");
            if(this.points>=(5*getNoGuest())){
                this.points=this.points-5*getNoGuest();
                System.out.println("Group Fitness For Basic Plan");
            }
            else{
                System.out.println("Group Fitness Not Accesible");
            }
        }
        void present(int d){ 
            schedule[d]=true; 
            points+=10; 
        }
        void getAttendance(){
            for (int i = 0; i< schedule.length; i++) {             
                if(schedule[i]==true){
                    System.out.println("Attended Class on date: "+i);
                }
                else{
                    System.out.println("Not Attended Class on: "+i);
                }
            }
        }
        void oneOnOne(int date_to_Book,int present_Day) throws Exception{
            if(date_to_Book-present_Day>=1 && points>=10){
                points=points-10; 
                System.out.println("One on One Session Booked");
            }
            else{
                throw new Exception("Points are Not Enough"); 
            }
        } 
        void buyProduct(String item) throws Exception{ 
            item_price=store.get(item);
            if(this.points>=item_price){
                this.points=points-item_price; 
                System.out.println("Purchasing "+item+" Remaining Points are: "+points);
            }
            else{
                throw new Exception("Cannot Buy Item"); 
            } 
        }
    }
    
    static class Fox_plan extends Gym{
        double plan=19.99; 
        Fox_plan(){
            this.points=0; 
            this.day=1; 
            this.guest=0;
            for(int i=0;i<schedule.length;i++){
                schedule[i]=false; 
            }
        } 
        void getPlanDetails(){
            System.out.println("Fox Plan Cost is: "+plan);
            System.out.println("Free Guest Privilages");
            System.out.println("Free Group Fitness");
        }
        void setPoints(int p){
            this.points=p; 
        }
        int getPoint(){
            return points; 
        }
        void isMembershipValid(){
            if(schedule[30]==true){
                System.out.println("Membership is Valid");
            } 
            else{
                System.out.println("Membership Not Valid");
            }
        } 
        void setNoGuest(int g){
            this.guest+=g; 
        } 
        int getNoGuest(){
            return guest; 
        }
        void guestPrivilages() throws Exception{
            if(this.guest<1){
                throw new Exception("Not Enought Guest");
            }
            System.out.println("Guest Privilages are Free In Fox Plan");
        } 
        void bookGroupFitnessSession(){
            System.out.println("Group Fitness is Free in Fox Plan");
        }
        void present(int d){ 
            schedule[d]=true; 
            points+=10; 
        }
        void getAttendance(){
            for (int i = 0; i< schedule.length; i++) {             
                if(schedule[i]==true){
                    System.out.println("Attended Class on date: "+i);
                }
                else{
                    System.out.println("Not Attended Class on: "+i);
                }
            }
        }
        void oneOnOne(int date_to_Book,int present_Day) throws Exception{
            if(date_to_Book-present_Day>=1 && points>=10){
                points=points-10; 
                System.out.println("One on One Session Booked");
            }
            else{
                throw new Exception("Points are Not Enough"); 
            }
        } 
        void buyProduct(String item) throws Exception{ 
            item_price=store.get(item);
            if(this.points>=item_price){
                this.points=points-item_price; 
                System.out.println("Purchasing "+item+" Remaining Points are: "+points);
            }
            else{
                throw new Exception(); 
            } 
        }
    }
    
    
    public static void main(String[] args) throws Exception { 
        System.out.println("==============RFFC GYM=======================");
        System.out.println("Welcome to RFFC GYM, There are 2 plans availabe,\n 1.Basic Plan-9.99$ per month\n 2.Fox Plan-19.99& per month");
        System.out.println("Please do Visit The Gym Store");
        System.out.println("==============Member 1=======================");
        Basic_plan member1=new Basic_plan(); 
        member1.getPlanDetails();
        member1.setNoGuest(5); 
        member1.bookGroupFitnessSession(); 
        member1.setPoints(400);
        member1.buyProduct("Sling-Bag");
        member1.getCash(member1.points);   

        System.out.println("==============Member 2=======================");
        Fox_plan member2=new Fox_plan();
        member2.getPlanDetails();
        member2.setNoGuest(5);
        member2.setPoints(5);
        member2.present(8); 
        member2.oneOnOne(16, 12); 
        System.out.println("Points for Member 2 are: "+member2.getPoint()); 

        System.out.println("==============Member 3=======================");
        Basic_plan member3=new Basic_plan();
        member3.setNoGuest(1);
        member3.setPoints(140);
        member3.guestPrivilages();
        member3.buyProduct("GNC");
        member3.totalMembers();   

        System.out.println("==============Member 4=======================");
        Fox_plan member4=new Fox_plan(); 
        member4.present(1);
        member4.present(5);
        member4.getPoint(); 
        member4.setNoGuest(5);
        member4.bookGroupFitnessSession(); 
        member4.totalMembers(); 

        System.out.println("==============Member 5=======================");
        Fox_plan member5=new Fox_plan(); 
        member5.setPoints(100);
        member5.getCash(member5.points); 
        member5.guestPrivilages();
        member5.totalMembers(); 
    }
}