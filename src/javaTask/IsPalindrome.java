package javaTask;

public class IsPalindrome {
    public static void main(String[] args) {
        numberIsPalindrome(121);
    }
    static void numberIsPalindrome(int number){

        int reverse = 0;
        int reminder;
        int temp = number;

        while (temp != 0){
            reminder = temp % 10;
            reverse = reverse * 10 + reminder;
            temp = temp / 10;
        }

        if (reverse == number){
            System.out.println("is palindrome");
        }else {
            System.out.println("is not palindrome");
        }
    }

}
