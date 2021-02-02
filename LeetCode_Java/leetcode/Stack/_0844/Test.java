package Stack._0844;

class Test{
    public static void main(String[] args) {
        String str1 = "ab#c";
        String str2 = "ad##c";
        String str3 = "##c";

        System.out.println(Solution.backspaceCompare(str3,str2));
    }
}