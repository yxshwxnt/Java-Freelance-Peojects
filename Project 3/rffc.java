import java.util.*; 
/*
 * @author: 
 */


public class rffc{
    static class Not_enough_pts extends Exception{
        Not_enough_pts(String message){
            super(message);
            System.out.println(message);
        }
        Not_enough_pts(){
            System.out.println("Not Enough Points"); 
        }
    }

    static class membership{
        static int memem1=Basic_plan.getMembersCount();
        static int memem2=Fox_plan.getMembersCount();
        static int totalmem=memem1+memem2; 
        static  int getMembersCountTot(){
            return totalmem; 
        }
    }

    abstract static class Store{
        HashMap<String, Integer> map = new HashMap<>(); 
        int balance,item_price,points; 
        Store(){
            map.put("Shoes", 150);
            map.put("Energy Drink", 100);
            map.put("Creatine", 70);
            map.put("TrackPants", 80);
            map.put("Bag", 60);
            map.put("Soya Milk", 20); 
        }
        void showStoreItems(){
            System.out.println("Items Aailable in Gym are: ");
            for(Map.Entry m : map.entrySet()){    
                System.out.println(m.getKey()+" "+m.getValue());    
            }  
        }
    }

    static abstract class Gym extends Store{
        Boolean[] month=new Boolean[30]; 
        int cash;  
        void Points_to_cash(int points){
            this.cash=points/100; 
            points=points/100+points&100; 
            System.out.println("Cash Availabe is: "+cash+"$");
        }
        Gym(){
            System.out.println("Gym is Accesible");
        }
    } 

    static class Basic_plan extends Gym{ 
        double price=9.99; 
        int points; 
        int guest;
        int day;
        static int members=0; 
        Boolean[] month=new Boolean[30]; 
        //Calling COnstructor For Basic Plan
        Basic_plan(){
            System.out.println("Basic Plan Member Created");
            this.points=0;
            this.day=1;
            this.guest=0; 
            this.members++;
            for(int i=0;i<month.length;i++){
                month[i]=false; 
            }
        }
        static int getMembersCount(){
            return members; 
        }
        void setPoints(int p){
            this.points=p; 
        }
        int getPoint(){
            return points; 
        }
        void isMembershipValid(){
            if(month[30]==true){
                System.out.println("Membership is Valid");
            } 
            else{
                System.out.println("Membership Not Valid");
            }
        } 
        void setGuests(int g){
            this.guest+=g; 
        } 
        int getGuests(){
            return guest; 
        }
        void Equipments(){
            System.out.println("Equipments are accesible"); 
        } 
        void guestPrivilages(){
            if(this.points>=(10*getGuests())){
                points=points-(10*getGuests());
                System.out.println("Guest Privilages For Basic Plan");
            }
            else{
                System.out.println("Not Enough Money");
            }
        } 
        void groupFitness(){
            System.out.println("Group Fitness For Basic Plan");
            if(this.points>=(5*getGuests())){
                this.points=this.points-5*getGuests();
                System.out.println("Group Fitness For Basic Plan");
            }
            else{
                System.out.println("Group Fitness Not Accesible");
            }
        }
        void present(int d){ 
            month[d]=true; 
            points+=10; 
        }
        void getAttendance(){
            for (int i = 0; i< month.length; i++) {             
                if(month[i]==true){
                    System.out.println("Attended Class on date: "+i);
                }
                else{
                    System.out.println("Not Attended Class on: "+i);
                }
            }
        }
        void oneToOne(int booking_date,int curr_date){
            if(booking_date-curr_date>=1 && points>=10){
                points=points-10; 
                System.out.println("Booking One To One Session.........");
            }
            else{
                System.out.println("Cannout book one to one session");
            }
        } 
        void buyItem(String item) throws Not_enough_pts{ 
            item_price=map.get(item);
            if(this.points>=item_price){
                this.points=points-item_price; 
                System.out.println("Purchasing "+item+" Remaining Points are: "+points);
            }
            else{
                throw new Not_enough_pts(); 
            } 
        }
    }
    
    
    
    static class Fox_plan extends Gym{
        double price=19.99; 
        int points; 
        int guest;
        int day; 
        static int members=0; 
        Boolean[] month=new Boolean[30]; 
        //Calling COnstructor For Fox Plan
        Fox_plan(){
            System.out.println("Fox Plan Member Created");
            this.points=0; 
            this.day=1; 
            this.guest=0;
            this.members++; 
            for(int i=0;i<month.length;i++){
                month[i]=false; 
            }
        } 
        static int getMembersCount(){
            return members; 
        }
        void setPoints(int p){
            this.points=p; 
        }
        int getPoint(){
            return points; 
        }
        void isMembershipValid(){
            if(month[30]==true){
                System.out.println("Membership is Valid");
            } 
            else{
                System.out.println("Membership Not Valid");
            }
        } 
        void setGuests(int g){
            this.guest+=g; 
        } 
        int getGuests(){
            return guest; 
        }
        void Equipments(){
            System.out.println("Equipments are accesible"); 
        } 
        void guestPrivilages(){
            System.out.println("Guest Privilages are Free In Fox Plan");
        } 
        void groupFitness(){
            System.out.println("Group Fitness is Free in Fox Plan");
        }
        void present(int d){ 
            month[d]=true; 
            points+=10; 
        }
        void getAttendance(){
            for (int i = 0; i< month.length; i++) {             
                if(month[i]==true){
                    System.out.println("Attended Class on date: "+i);
                }
                else{
                    System.out.println("Not Attended Class on: "+i);
                }
            }
        }
        void oneToOne(int booking_date,int curr_date){
            if(booking_date-curr_date>=1 && points>=10){
                points=points-10; 
                System.out.println("Booking One To One Session.........");
            }
            else{
                System.out.println("Cannout book one to one session");
            }
        }
        void buyItem(String item) throws Not_enough_pts{ 
            item_price=map.get(item);
            if(this.points>=item_price){
                this.points=points-item_price; 
                System.out.println("Purchasing "+item+" Remaining Points are: "+points);
            }
            else{
                throw new Not_enough_pts(); 
            } 
        }
    }
    

    public static void main(String[] args) throws rffc.Not_enough_pts {
        Fox_plan mem1=new Fox_plan(); 
        mem1.Equipments();
        mem1.setGuests(5); 
        mem1.groupFitness(); 
        mem1.setPoints(400);
        mem1.showStoreItems();
        mem1.buyItem("Shoes");
        mem1.Points_to_cash(mem1.points);  

        Basic_plan mem2=new Basic_plan();
        mem2.setGuests(5);
        mem2.setPoints(5);
        mem2.present(8); 
        mem2.present(2); 
        mem2.present(3); 
        mem2.present(5); 
        mem2.getAttendance(); 
        System.out.println("Points for Member 2 are: "+mem2.getPoint()); 

        Basic_plan mem3=new Basic_plan();
        mem3.setGuests(1);
        mem3.setPoints(140);
        mem3.guestPrivilages();
        mem3.buyItem("Creatine");
        mem3.oneToOne(9, 4);

        membership mem4=new membership(); 
        System.out.println("Total Members are: "+ mem4.getMembersCountTot()); 


    }
}