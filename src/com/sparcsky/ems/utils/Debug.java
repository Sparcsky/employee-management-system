package com.sparcsky.ems.utils;

import java.io.PrintWriter;

public class Debug {
    private static Debug ourInstance = new Debug();
    private static PrintWriter writer;

    public static Debug getInstance() {
        return ourInstance;
    }

    private Debug() {
    }

    public void init(PrintWriter writer) {
        Debug.writer = writer;
    }

    public static void print(String error) {
        writer.print(error);
    }

}
