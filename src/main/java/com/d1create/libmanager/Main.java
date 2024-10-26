package com.d1create.libmanager;


import java.util.ArrayList;

import com.d1create.libmanager.commands.add;
import com.d1create.libmanager.commands.help;
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
                help.DoCommand();
            }
            else if(cur_arguement.equals("-a")){
                add.DoCommand(cur_arguement);
            }
        }



    }
}