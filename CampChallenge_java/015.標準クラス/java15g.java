/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java15;

/**
 *
 * @author takizawaryoutarou
 */
public class java15g {

    public static void main(String[] args) {
//文字列型の変数[NG1]を宣言        
        String NG1 = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
//([NG1]の値の「I」を「い」に置き換えた)文字列型の変数[NG2]を宣言
        String NG2 = NG1.replace("I", "い");
//([NG2]の値の「U」を「う」に置き換えた)文字列型の変数[OK]を宣言して表示する
        String OK = NG2.replace("U", "う");
        System.out.println(OK);
    }

}
