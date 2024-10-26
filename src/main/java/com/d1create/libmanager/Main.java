package com.d1create.libmanager;


import java.util.ArrayList;

import com.d1create.libmanager.commands.AddBook;
import com.d1create.libmanager.commands.Help;
import com.d1create.libmanager.utils.Basic;
import com.d1create.libmanager.utils.Book;
import com.d1create.libmanager.utils.BookHandler;
import com.d1create.libmanager.utils.Path;

public class Main {
    public static void main(String[] args) {
        //initalise classes
        BookHandler book_handler = new BookHandler();
        
        //inialise variables
        final ArrayList<Book> book_list = new ArrayList<Book>();
        final Path path_data = new Path();
        //edit variables
        book_handler.LoadBooks(book_list, (path_data.data_path + "example.txt") );

        //add logic(cmd line tool)
        for(int i=0;i<args.length;i++){
            String cur_arguement = args[i];

            if(cur_arguement.equals("-h") || cur_arguement.equals("--help")){
                Help.DoCommand();
            }
            else if(cur_arguement.equals("-a")){
                AddBook.DoCommand(book_list,cur_arguement);
            }
            else if(cur_arguement.equals("-l")){
                for(int index=0;index<book_list.size();index++){
                    Book Current_Book = book_list.get(index);
                    System.out.printf("Title:%s,Description:%s,YearReleased%s",Current_Book.name(),Current_Book.description(),String.valueOf(Current_Book.year_released()));
                }
            }
        }



    }
}