package binary_numbers;

public class BinaryForm {
    public static void main(String[] args) {
        String binary = "";
        int n = 9;
        int originalNumber = n;
        while(n > 0){
            if(n % 2 == 1){
                binary = "1" + binary;
            }
            else{
                binary = "0" + binary;
            }
            n /= 2;
        }
        System.out.println("Binary form of " + originalNumber + " is " + binary);
    }
}
