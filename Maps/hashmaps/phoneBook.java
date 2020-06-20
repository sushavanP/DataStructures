package dataStructures.Maps.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class phoneBook
{
    public static void main(String []argh){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> phoneBook = new HashMap<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String name = sc.next();
            int phone = sc.nextInt();
            phoneBook.put(name, phone);
        }
        int i = 0;
        while(i < n){
            String s = sc.next();
            if(phoneBook.containsKey(s)){
                System.out.println(s+"="+phoneBook.get(s));
            }
            else{
                System.out.println("Not found");
            }
            i++;
        }
        sc.close();
    }
}
