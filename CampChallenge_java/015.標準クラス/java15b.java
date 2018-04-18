/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java15;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author takizawaryoutarou
 */
public class java15b {

    public static void main(String[] args) {
//Date型[now]を現在の日時で作成        
        Date now = new Date();
        
//SampleDateFormatインスタンスの[Sdf]を作成        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        
//formatメソッドを利用して日付情報を文字列[dateString]に変換して表示        
        String dateString = sdf.format(now);
        System.out.print(dateString);

    }

}
