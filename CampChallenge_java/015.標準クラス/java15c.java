/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java15;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author takizawaryoutarou
 */
public class java15c {

    public static void main(String[] args) {
//Calendarインスタンス[c]を作成
        Calendar c = Calendar.getInstance();
//[c]に2016年11月4日10時0分0秒の情報を与える 
        c.set(2016, 10, 4, 10, 0, 0);
//[c]のタイムスタンプを表示
        System.out.println(c.getTimeInMillis());
//[c]のタイムスタンプを持つDate型の[d]を作成        
        Date d = new Date(1478221200231l);
//SampleDateFormatインスタンスの[Sdf]を作成        
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//formatメソッドを利用して日付情報を文字列[dateString]に変換して表示
        String dateString = sdf.format(d);        
        System.out.println(dateString);
    }
}
