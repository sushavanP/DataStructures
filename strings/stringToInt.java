package dataStructures.strings;

public class stringToInt
{
    public int Atoi(String str){
        int n = str.length();
        if(n == 0) return 0;

        str = str.trim();
        char sign = '+';
        double val = 0.0d;
        int index = 0;
        StringBuilder sb = new StringBuilder();

        if(str.charAt(0) == '+' || str.charAt(0) == '-'){
            sign = str.charAt(0);
            index++;
        }

        for(int i = index; i < n; i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                sb.append(str.charAt(i));
            else break;
        }

        String s = sb.length() == 0 ? "0" : sb.toString();
        val = Double.parseDouble(s);

        if(sign == '-')
            val = -1 * val;

        if(val > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(val < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)Math.round(val);
    }
    public static void main(String[] args){
        stringToInt s = new stringToInt();
        String str = " -4587 is the mvp. ";
        System.out.println("The number is: " + s.Atoi(str));
    }
}
