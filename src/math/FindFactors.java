package math;

public class FindFactors {
    public static void printFactors(int n){
        // i * i <= n is same thing as i <= Math.sqrt(n)
        for(int i = 1; i * i <= n; ++i){
            if(n % i == 0){
                int oneFactor = i;
                int secondFactor = n / i;
                System.out.println(oneFactor + " " + secondFactor);
            }
        }
    }

    public static void main(String[] args) {
        int n = 56;
        printFactors(56);
    }
}
