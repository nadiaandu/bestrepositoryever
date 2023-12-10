package org.example;

public class ThisIsFun {
    int a;
    int b;

    public void setData(int a, int b) {
        this.a = a;
        this.b = b;

    } // this keyword cant be used with static

    public static void main(String[] args) {


        ThisIsFun tif = new ThisIsFun();
        tif.setData(4,3);
        System.out.println(tif.a);
        System.out.println(tif.b);
    }

}
