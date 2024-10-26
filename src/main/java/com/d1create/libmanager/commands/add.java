package com.d1create.libmanager.commands;

import com.d1create.libmanager.utils.Basic;

//add a book to the main list
public class add {
    public static void DoCommand(String cur_arguement){
        short argument_introduction_index =(short) Basic.CharFirstAppearance(cur_arguement,'a');
        String arguement_detail = cur_arguement.substring(Basic.CharFirstAppearance(cur_arguement,'a')+1, cur_arguement.length());
    }

    public void SanitizeInput(String arguement_detail){
        
    }
}
