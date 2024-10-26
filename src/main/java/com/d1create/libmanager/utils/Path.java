package com.d1create.libmanager.utils;

//custom made class to store Paths
public class Path {
    public final String working_directory = System.getProperty("user.dir");
    public final String data_path = working_directory + "/classes/data/";
}
