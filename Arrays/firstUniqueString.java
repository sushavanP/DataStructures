package dataStructures.Arrays;

public class firstUniqueString
{
    public char firstUniqChar(String s){
        int [] ch = new int[26];
        for(char c : s.toCharArray())
            ch[c - 'a']++;
        for(char c :s.toCharArray()){
            if(ch[c - 'a'] == 1)
                return c;
        }
        return '_';
    }
    public static void main(String [] args){
        firstUniqueString fs = new firstUniqueString();
        String s = "aaaaabbbbaaacccdeeee";
        System.out.println(fs.firstUniqChar(s));
    }
}
