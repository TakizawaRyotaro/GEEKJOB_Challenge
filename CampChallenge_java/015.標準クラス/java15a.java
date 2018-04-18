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
public class java15a {
    
    public static void main(String[] args) {
        
//(22~25行)うまくいかない

//2016年(1970年から46年後)の日付情報を持つインスタンスを生成        
//        Date someday = new Date(46*365*24*60*60*1000l);
////タイムスタンプの表示        
//       System.out.print(someday.getTime());
        
////Calendarインスタンス[c]を作成
       Calendar c = Calendar.getInstance();
////[c]に情報を与える       
       c.set(2016, 0, 1, 0, 0, 0);
////[c]のタイムスタンプを表示       
       System.out.println(c.getTimeInMillis());
      
    }
    
}
