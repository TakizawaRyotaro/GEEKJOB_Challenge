/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java15;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author takizawaryoutarou
 */
public class java15j {

    public static void main(String[] args) {
//文字列型の変数[word]に値[wo]を代入    
        String word = "wo";
//呼び出すStringオブジェクトの末尾に文字列の値[rd]を付け加えて表示
        System.out.println(word.concat("rd"));

        try {
//ファイルオープン            
            File fp = new File("java15j.txt");
//FileWriterのインスタンス[fw]を作成            
            FileWriter fw = new FileWriter(fp);
//BufferedWriterのインスタンス[bw]を作成して書き込みを行う            
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("文字列の語尾に文字列を追加する処理");
//bw.newLine();で改行する            
            bw.newLine();
            bw.write("2018-04-17 19:00 開始");
            bw.newLine();
            bw.write("2018-04-17 20:00 終了");
//ファイルクローズ            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
