/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joe
 */
public class Test {

    public static void main(String[] args) {
        cbbb cb = new cbbb();
        NewClass nc = new NewClass();
        Animal dog = new dog();
        Animal brid = new brid();
        Animal am = new Animal();
        act(dog);
        act(brid);
        act(am);
//        nc.air(2, 5);
//        cb.air(2, 5);
//        cb.show(1, 3);
    }

    //測試多型
    public static void act(Animal animal) {
        animal.move();
    }
}

//測試多型
class Animal {

    public void Animal() {
        System.out.println("animal建構元");
    }

    protected void move() {
        System.out.println("散步");
    }
}

//測試多型
class dog extends Animal {

    @Override
    protected void move() {
        System.out.println("跑步");
    }
}

//測試多型
class brid extends Animal {

    @Override
    protected void move() {
        System.out.println("起飛");
    }
}

//測試繼承和覆寫
class NewClass {

    public void NewClass() { //父類別建構元
        System.out.println("呼叫NC建構元");
    }

    void air(int i, int x) { //父類別方法
        int sum = i + x;
        System.out.println("父類型 : 空氣值 : " + sum);
    }
}

//cbbb繼承newclass
class cbbb extends NewClass {

    public void cbbb() { //子類別建構元
        System.out.println("呼叫cbbb建構元");
    }

    void show(int i, int x) {
        int sum = i + x;
        System.out.println("airr : " + sum);
    }

    //覆寫newclass裡面的父類別方法
    @Override
    void air(int i, int x) {
        int sum = i * x;
        System.out.println("覆寫父類別的方法 : " + sum);
    }
}
