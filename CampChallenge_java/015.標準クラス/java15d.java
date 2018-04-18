/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java15;

import java.util.Calendar;

/**
 *
 * @author takizawaryoutarou
 */
public class java15d {

    public static void main(String[] args) {
//Calendarインスタンス[C]と[c]を作成して情報を与える        
        Calendar C = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        C.set(2015, 0, 1, 0, 0, 0);
        c.set(2015, 12, 31, 23, 59, 59);

//確認用
//System.out.println(c.getTimeInMillis());
//System.out.println(C.getTimeInMillis());

//Cとcのタイムスタンプの差を値とする変数[x]を宣言し表示
        long x = (C.getTimeInMillis() - c.getTimeInMillis());
        System.out.println(x);
    }

}
