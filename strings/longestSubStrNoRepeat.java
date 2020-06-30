/*
    Sliding window algorithm.
*/
package dataStructures.strings;

import java.util.HashSet;

public class longestSubStrNoRepeat
{
    public int lengthOfSubstring(String s){
        int start = 0; //starting index of the string.
        int slide = 0; //index that slides.
        int max = 0;

        HashSet<Character> hash_set = new HashSet<>();
        while(slide < s.length()){
            if(!hash_set.contains(s.charAt(slide))){
                hash_set.add(s.charAt(slide));
                max = Math.max(hash_set.size(), max);
                slide++;
            }else{
                hash_set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }
    public static void main(String[] args){
        longestSubStrNoRepeat str = new longestSubStrNoRepeat();
        String s = "abcabcbb";
        System.out.println("The length is: " + str.lengthOfSubstring(s));
    }
}
