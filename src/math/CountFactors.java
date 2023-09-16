package math;


public class CountFactors {

    final static int countFactors(int num){
        int count = 0;
        for(int i=1; i<=(int)Math.sqrt(num); i++){
            if(num % i == 0){
                int first = i;
                int second = num/i;
                System.out.println("first " + first + ", second " + second);
                if(first == second){
                    count = count + 1;
                }else{
                    count = count + 2;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countFactors(25));
    }
}
