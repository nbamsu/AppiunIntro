package InterviewTests;

public class FindMissingNumberArray {
    public static void main(String[] args) {
        int [] num={1,2,3,4,6,7,8,9};//39
        int formula=9*10/2;//45
        int sum=0;
        for(int i=0;i<num.length;i++){
            sum+=num[i];
        }
        int result=formula-sum;
        System.out.println(result);
    }
}
