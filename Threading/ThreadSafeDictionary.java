package Threading;

import java.util.HashMap;
import java.util.Map;

public class ThreadSafeDictionary {
   private final Map<String , Integer>  dictionary = new HashMap<>();

   public synchronized void put(String key , Integer value){
       dictionary.put(key , value);
   }

   public synchronized Integer get(String key){
       return dictionary.get(key);
   }

    public static void main(String[] args) {
 ThreadSafeDictionary threadSafeDictionary = new ThreadSafeDictionary();
 threadSafeDictionary.put("Apple " , 20);
 threadSafeDictionary.put("Banana" , 30);

        System.out.println(threadSafeDictionary.get("Banana"));
    }
}
