/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author takizawaryoutarou
 */
public class java15i {

    public static void main(String[] args) {
        try {
//ファイルオープン            
            File fp = new File("test.txt");
//FileReaderクラスのインスタンス[fr]を作成            
            FileReader fr = new FileReader(fp);
//BufferedReaderクラスのインスタンス[br]を作成            
            BufferedReader br = new BufferedReader(fr);
//１行読み出し            
            System.out.print(br.readLine());
//クローズ            
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
