/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author takizawaryoutarou
 */
public class java15h {

    public static void main(String[] args) {
//Fileクラスのインスタンス[fp]を作成、ファイルオープンする。
        try {
            File fp = new File("test.txt");
//FileWriterクラスのインスタンス[fw]を作成し、自己紹介の書き込みを行う。 
            FileWriter fw = new FileWriter(fp);
            fw.write("滝澤遼太郎です！");
//ファイルをクローズする。            
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
