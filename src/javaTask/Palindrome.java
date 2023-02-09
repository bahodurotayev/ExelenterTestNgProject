package javaTask;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Palindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(11211);
        System.out.println(palindrome);
    }
    static boolean isPalindrome(int target){
        int number = target;
        int reverse = 0;
        while (number > 0){
        reverse = (reverse * 10) + number % 10;
        number = number/ 10;
    }
        return reverse == target;
    }
}
