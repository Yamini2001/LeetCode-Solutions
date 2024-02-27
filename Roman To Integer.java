public class Main{
    public static int romanToInt(String s) {
        // Write your code here
        int result = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            switch(ch){
                case 'I':
                    result+=(result>=5)?-1:1;
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    result+=(result>=50)?-10:10;
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    result+=(result>=500)?-100:100;
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;
            }
        }
        return result;
    }
}
