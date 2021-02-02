package Stack._0844;

class Solution{
    public static Boolean backspaceCompare(String S, String T){
        return Solution.shorted(S).equals( Solution.shorted(T));
    }

    private static String shorted(String str){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i <= str.length() - 1; i++){
            if(str.charAt(i) == '#'){
                if(sb.length() == 0)
                    continue;
                sb.deleteCharAt(sb.length()-1);
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
