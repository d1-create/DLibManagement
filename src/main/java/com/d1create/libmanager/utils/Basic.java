package com.d1create.libmanager.utils;

//fill the most basic needs to save time
public class Basic {
    public static void print(String message){
        System.out.println(message);
    }

    //find char first appearance in string - ASSUMING YOU KNOW IT IS IN THERE
    public int CharFirstAppearance(String string_to_interpret,char char_to_find){
        int index = 0;//use this bad method to stop error when compiling
        for(int i=0;i<string_to_interpret.length();i++){
            if(string_to_interpret.charAt(i)==char_to_find){
                index = i;
            }
        }
        return index;
    }
}
