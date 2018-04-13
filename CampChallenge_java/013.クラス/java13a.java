/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java13;

/**
 *
 * @author takizawaryoutarou
 */
//Humanクラスの宣言
class Hum {
    
//フィールドの宣言   
    public String name = "";
    public int age = 0;
    
//第1メソッドの宣言
    public void set0Hum(String n, int a) {
//引数をフィールドへ格納
        this.name = n;
        this.age = a;
    }
//第２メソッドの宣言
    public void set1Hum() {
//フィールドの値を画面に表示    
        System.out.print(name);
        System.out.print(age);
    }
}
//java13a(実行クラス)の作成
public class java13a {

    public static void main(String[] args) {
//hitoインスタンスを生成
        Hum hito = new Hum();
//hitoインスタンスのメソッド利用
        hito.set0Hum("滝澤遼太郎", 23);
        hito.set1Hum();
    }
}
