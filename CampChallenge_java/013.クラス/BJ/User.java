/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJ;

import java.util.ArrayList;

/**
 *
 * @author takizawaryoutarou
 */
class User extends Human {
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





    

