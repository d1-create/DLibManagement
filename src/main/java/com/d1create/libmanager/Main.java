package com.d1create.libmanager;


import java.util.ArrayList;

import com.d1create.libmanager.utils.Basic;
import com.d1create.libmanager.utils.Book;
import com.d1create.libmanager.utils.BookHandler;

public class Main {
    public static void main(String[] args) {
        //initalise classes
        BookHandler book_handler = new BookHandler();

        //inialise variables
        final ArrayList<Book> book_list = new ArrayList<Book>();
        final String working_directory = System.getProperty("user.dir");

        //edit variables
        book_handler.LoadBooks(book_list, (working_directory + "/src/main/resources/data/example.txt") );
        Basic basic_func = new Basic();

        //add logic(cmd line tool)
        for(int i=0;i<args.length;i++){
            String cur_arguement = args[i];

            if(cur_arguement.equals("-h") || cur_arguement.equals("--help")){
                Basic.print("-a AddBook(Title,Description,ReleaseYear)");
            }
            else if(cur_arguement.equals("-a")){//TODO
                short argument_introduction_index=(short) basic_func.CharFirstAppearance(cur_arguement,'a');
                String arguement_detail = cur_arguement.substring(basic_func.CharFirstAppearance(cur_arguement,'a'), cur_arguement.length());

            }
        }



    }
}