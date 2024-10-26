package com.d1create.libmanager.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class BookHandler {
    //save all books to a file using a FileWriter
    public void SaveBooks(ArrayList<Book> books, String RAW_save_path) {
        try {
            File SaveFile = new File(RAW_save_path + ".txt");
            FileWriter BookWriter = new FileWriter(SaveFile);
            for (int i = 0; i < books.size(); i++) {
                Book Cur_Book = books.get(i);
                //basically, the line will go like [book1name-book1desc-book1year!book2name-book2desc-book1year]
                //yes, why not make an overly complicated and useless system
                BookWriter.write(Cur_Book.name() + "-" + Cur_Book.description() + "-"+ String.valueOf(Cur_Book.year_released()) + "!");
            }
            BookWriter.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
            Basic.print("Something went wrong when writing the data!");
        } catch (Exception e) {
            Basic.print("Something Went Wrong");
        }

    }

    // load a file of books to an array - more detail below
    public void LoadBooks(ArrayList<Book> books, String RAW_save_path) {
        try {
            char[] data = ReadFileFull(RAW_save_path);

            String title = "";
            String description = "";
            short release_year = 0;
            short num_dash = 0;
            
            //if the charachter is ! then everything resets to original value
            //if charachter is a - then you increment the num_dash
            //if num_dash is 0 then you are appending to the title, if it is 1 then description, if it is 2 then its release year
            for(int i=0;i<data.length;i++){
                char charachter = data[i];
                if(charachter == '!'){
                    books.add(new Book(title,description,release_year));
                    title = "";
                    description = "";
                    release_year = 0;
                    num_dash = 0;
                }
                else if(charachter=='-'){
                    num_dash++;
                }
                else{
                    if(num_dash==0){title += charachter;}
                    else if(num_dash==1){description += charachter;}
                    else if(num_dash==2){release_year += (short) charachter;}
                }
            }
        }
        //how could an exception occur? idk but it will
        catch (Exception e) {
            e.printStackTrace();
            Basic.print("Something went wrong when reading the data!");
        }

    }

    //read a file and return its contents as a char array
    public char[] ReadFileFull(String path){
        try{
            File file = new File(path);
            FileReader reader = new FileReader(file);
            char[] fileContents = new char[(int) file.length()];
            reader.read(fileContents);
            reader.close();

            return fileContents;
        }
        catch(Exception e){
            e.printStackTrace();
            return new char[0];//return empty array if case of exception
        }   
    }
}
