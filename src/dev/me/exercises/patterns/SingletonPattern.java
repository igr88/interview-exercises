package dev.me.exercises.patterns;

import java.util.Scanner;

class Singleton {
    private static Singleton instance;
    public String str;

    private Singleton() {
        this.str = "";
    }

    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonPattern {

    public static void main(String[] args) {
       try(Scanner console = new Scanner(System.in)) {
           var string = console.nextLine();

           var s1 = Singleton.getSingleInstance();
           s1.str += "Hello I am a singleton! Let me say ";

           var s2 = Singleton.getSingleInstance();
           s2.str += string;

           var s3 = Singleton.getSingleInstance();
           s3.str += " to you";

           System.out.println(Singleton.getSingleInstance().str);
       }
    }
}
