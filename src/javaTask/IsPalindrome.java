package javaTask;

public class IsPalindrome {
    public static void main(String[] args) {
        numberIsPalindrome(121);
    }
    static void numberIsPalindrome(int number){
        int num = number;
        int reverse = 0;
        while (num > 0){
            num = num % 10;
            reverse = reverse * 10 + num;
            num = num / 10;
        }
        if (reverse == number){
            System.out.println("is palindrome");
        }else {
            System.out.println("is not palindrome");
        }
    }
}
