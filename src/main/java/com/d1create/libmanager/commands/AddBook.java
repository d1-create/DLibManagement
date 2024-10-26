package com.d1create.libmanager.commands;

import java.util.ArrayList;

import com.d1create.libmanager.utils.Basic;
import com.d1create.libmanager.utils.Book;

//add a book to the main list
public class AddBook {
    public static void DoCommand(ArrayList<Book> BookData,String cur_arguement){
        //find the part after the argument that has the detail
        String arguement_detail = cur_arguement.substring(Basic.CharFirstAppearance(cur_arguement,'a')+1, cur_arguement.length());

        //the variables storing the data we need to collect from the string
        String title = "";
        String description = "";
        Short release_year = 0;
        short dashes = 0;

        //turn the string into an array 
        char[] argument_detail_array = arguement_detail.toCharArray();

        //for loop looping through and using a custom algorithim to seperate data
        for(int i=0;i<arguement_detail.length();i++){
            char current_letter = argument_detail_array[i];
            if(current_letter=='-'){
                dashes++;
            }
            //love or hate the syntax it works
            else{
                if(dashes==0){title += String.valueOf(current_letter);}
                else if(dashes==1){description += String.valueOf(current_letter);}
                else if(dashes==2){release_year = Short.parseShort(String.valueOf(current_letter));}
            }
        }

        BookData.add(new Book(title, description, release_year));
        Basic.print("Added Book with!" + "\n" + "Title" + title + "\nDescription:" + description + "\nReleaseYear:" + String.valueOf(release_year));

    }
}
