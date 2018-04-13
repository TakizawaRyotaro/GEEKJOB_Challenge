/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJ;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author takizawaryoutarou
 */
//抽象クラス[Human]を継承 
class Dealer extends Human {

//ArrayListの変数[cards]を用意する    
    protected ArrayList<Integer> cards = new ArrayList<Integer>();

//全てのカード(・13枚*4 ・10以上の数は10とみなす)を持たせる初期処理)
    protected Dealer() {
        for (int i = 1; i <= 4; i++) {
            for (int t = 1; t <= 13; t++) {
                if (t >= 10) {
                    cards.add(10);
                } else {
                    cards.add(t);
                }

            }
        }
    }
    Random rand = new Random();

    //公開メソッド(cardsからランダムで2枚のカードを戻り値とする)[deal]を用意        
    public ArrayList<Integer> deal() {
        ArrayList<Integer> arraydeal = new ArrayList();
        Integer index = 0;
        int x = 0;
        //2回繰り返す
        for (int d = 1; d <= 2; d++) {
            //cardsから格納された要素の中のカードの数をランダムに引き出す
            index = rand.nextInt(cards.size());
            //山札から一枚取得したデータを変数に代入(ランダム)
            //取得した数字をarraydealに追加
            //山札から取得したデータを削除
            x = cards.get(index);
            arraydeal.add(x);
            cards.remove(x);
        }
        return arraydeal;
    }

//公開メソッド(cardsからランダムで1枚のカードを戻り値とする)[hit]を用意
    public ArrayList<Integer> hit() {
        ArrayList<Integer> arrayhit = new ArrayList();
        Integer index = 0;
        int y = 0;
        //cardsから格納された要素の中のカードの数をランダムに引き出す
        index = rand.nextInt(cards.size());
        //山札から一枚取得したデータを変数に代入(ランダム)
        //取得した数字をarrayhitに追加
        //山札から取得したデータを削除
        y = cards.get(index);
        arrayhit.add(y);
        cards.remove(y);
        return arrayhit;

    }

//abstractな公開メソッド[open]を用意
    public int open() {
//myCardsのカードの合計値を返却   
        int Total = 0;
        for (int value : myCards) {
            Total = Total + value;
        }
        return Total;
    }

//abstractな公開メソッドでArrayList(setCards)を引数としている[setCard]を用意
    public void setCard(ArrayList<Integer> setCards) {

//ArrayListで貰ったカード情報をmyCardsに追加するように実施
//setCardsの要素数未満の値(実際のトランプの値)を設定する
        for (int s = 0; s < setCards.size(); s++) {
//setCardsで所得した値[s]をmyCardsに追加    
            myCards.add(setCards.get(s));
        }
    }

//abstractな公開メソッド[checkSum]を用意
    public boolean checkSum() {
//myCardsを確認してまだカードが必要なら(カードの合計値が17未満)true、いらなければfolseを返却    
        if (open() < 17) {
            return true;
        } else {
            return false;

        }

    }
}
