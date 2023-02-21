package javaTask;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Palindrome {
    @Test
    void isNumberPalindrome(){
        isPalindrome(11211);
    }
    static void isPalindrome(int target){

        int number = target;
        int reverse = 0;
        while (number > 0){
        reverse = (reverse * 10) + number % 10;
        number = number/ 10;
    }
        Assert.assertEquals(target,reverse, "They are not palindrome");
    }

    static void isPalindrome(String str){
        int start = str.charAt(0);
        int end = str.charAt(str.length()-1);

        while (start < end){
            if (str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }else {
                break;
            }
        }
    }


}
