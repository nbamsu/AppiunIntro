package InterviewTests;

public class StringRevers {
    public static void main(String[] args) {
        String word="techtorial";
        String reversed="";
        for(int i=word.length()-1; 0<=i; i--){
            reversed=reversed+word.charAt(i);
        }
//        System.out.println(reversed);
//        StringBuilder sb=new StringBuilder(word);
        System.out.println(word);
        System.out.println(reversed);
    }
}
