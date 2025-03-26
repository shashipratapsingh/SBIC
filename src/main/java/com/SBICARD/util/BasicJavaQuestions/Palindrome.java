package com.SBICARD.util.BasicJavaQuestions;

public class Palindrome {
    public static void main(String [] args){
        String str="MadaT"; //output madaM
        String stringBuilder= new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(stringBuilder))
            System.out.println("It is Palindrome number");
        else
            System.out.println("It is Not Palindrome number");
    }
}
