import java.util.HashMap;

// class QueueEmptyException extends Exception{
//     QueueEmptyException(String message){
//         super(message);
//         System.out.println(message);
//     }
//     QueueEmptyException(){
//         System.out.println("Queue is empty"); 
//     }
// }

public class temp{
    static void buy(HashMap<String, Integer> prod, String item, int points){
        if(points>=prod.get(item)){
            points=points-prod.get(item); 
            System.out.println("Bought "+item+" Remaining balance: "+points);
        }
        else{
            System.out.println("Not Enought Points");
        }
    }
    static void Store(int points,String item){
		HashMap<String, Integer> prod = new HashMap<>();
        prod.put("t-shirt", 10);
        prod.put("gym-bag", 30);
        prod.put("water-bottle", 20);
        prod.put("gloves", 20);
        prod.put("sweet-shirt", 20);
        prod.put("protien-shake", 20); 
        buy(prod,item,points);
    }
	public static void main(String[] args){ 
        Store(100,"protien-shake");
	}
}
