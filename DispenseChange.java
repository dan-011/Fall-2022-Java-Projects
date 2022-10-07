import java.util.Hashtable;

public class DispenseChange {
    public static void main(String[] args){
        int change = Integer.parseInt(args[0]);
        Hashtable<Integer, String> coins = new Hashtable<Integer, String>();
        coins.put(25, "quarters");
        coins.put(10, "dimes");
        coins.put(5, "nickels and");
        coins.put(1, "pennies");
        int count;
        int[] order = {25, 10, 5, 1};
        System.out.println(change + " cents in coins can be given as:");
        for(int den : order){
            count = 0;
            while(change >= den){
                count++;
                change -= den;
            }
            System.out.println(count + " " + coins.get(den));
        }

    }
}
