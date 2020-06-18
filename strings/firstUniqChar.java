package dataStructures.strings;

public class firstUniqChar
{
    public int firstUniqChar(String s) {
        int n = s.length(), i;
        for(i = 0; i < n; i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                System.out.println(s.charAt(i));
                return i;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        firstUniqChar fs = new firstUniqChar();
        String s = "aaaaabbbbaaacccdeeee";
        System.out.println(fs.firstUniqChar(s));
    }
}
