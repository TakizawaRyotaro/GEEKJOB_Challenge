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

//Hum(親クラス)を継承してManクラスを宣言
class Man extends Hum {
    
//set2Humを独自のメソッドとして実装   
    public void set2Hum() {
//フィールドの値をクリアする処理
        this.name = null;
        this.age = 0;

    }
}
//java13bクラス(実行クラス)を作成
public class java13b {

    public static void main(String[] ages) {
//継承を利用してManクラスのインスタンスを作成    
        Man takizawa = new Man();
//独自に実装したメソッドset2Humと親クラスに実装されていたメソッドset1Humを利用
        takizawa.set1Hum();
        takizawa.set2Hum();

    }
}
