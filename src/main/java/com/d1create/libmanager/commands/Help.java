package com.d1create.libmanager.commands;

import com.d1create.libmanager.utils.Basic;

public class Help {
    public static void DoCommand(){
        Basic.print("-h,--help    Show a list of all commands and their functions");
        Basic.print("-a    Add a book using the Syntax --> Title-Description-ReleaseYear");
    }
}
