package dataStructures.strings;

public class longestCommonPrefix
{
    public String commonPrefix(String [] strings){
        if(strings.length == 0) return "";

        String prefix = strings[0];
        for(int i = 1; i < strings.length; i++){
            while(strings[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
    public static void main(String[] args){
        longestCommonPrefix str = new longestCommonPrefix();
        String strings[] = new String[]{"flower", "flow", "flight"};
        System.out.println("The longest common prefix is: " + str.commonPrefix(strings));
    }
}
