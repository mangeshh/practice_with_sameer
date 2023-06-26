package math;

public class CheckPrime {
    public static boolean isPrime(int n){
        // Any prime number has only 2 factors (1 and itself)
        for(int i = 2; i * i <= n; ++i){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 37;
        if(isPrime(n)){
            System.out.println(n + " is a prime number");
        }
        else{
            System.out.println(n + " is not a prime number");
        }
    }
}
