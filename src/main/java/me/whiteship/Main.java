package me.whiteship;

public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
    }
}