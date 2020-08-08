import java.io.*;
import java.util.*;

public class PurchasingComponents {
    public static void maximumComponents(List<String> scenarios) {
        for(int i = 0; i < scenarios.size(); i++) { // Iterate through every possible scenario 
            StringTokenizer foo = new StringTokenizer(scenarios.get(i)); 
            int budget = Integer.parseInt(foo.nextToken());
            int cost = Integer.parseInt(foo.nextToken());
            int newComponent = Integer.parseInt(foo.nextToken());
    
            int initialBuy = budget / cost; // Calculate how many components are initially purchased 
            int numPurchased = initialBuy; 
    
            while(numPurchased / newComponent >= 1) { // If have enough components to return 
                int returns = numPurchased / newComponent; 
                initialBuy = initialBuy + returns; 
                numPurchased = numPurchased + returns; // Add the amount of 'refunded' components returned to total count 
                numPurchased = numPurchased - (newComponent + returns); // Subtract the components returned 
            }
            System.out.println(initialBuy);
        }
    }

    public static void main(String []args) {
        PurchasingComponents foo = new PurchasingComponents(); 
        List<String> myList = new ArrayList<>(); 
        myList.add("5 1 2");
        myList.add("6 3 3");
        myList.add("2 2 5");
        foo.maximumComponents(myList);
     }
}
