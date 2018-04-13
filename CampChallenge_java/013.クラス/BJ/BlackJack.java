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
public class BlackJack {

    public static void main(String[] args) {
//Userクラスをインスタンス化    
        User user = new User();
//Dealerクラスをインスタンス化
        Dealer dealer = new Dealer();

//(ディーラーが)DealerとUserにカードを2枚配り、DealerとUserはカードを手札として受け取る
        ArrayList setCards = dealer.deal();
        dealer.setCard(setCards);
        setCards = dealer.deal();
        user.setCard(setCards);
        System.out.println("ディーラーはカード" + dealer.myCards.get(0) + "と" + dealer.myCards.get(1) + "を配られました(合計値" + dealer.open() + ")");
        System.out.println("あなたはカード" + user.myCards.get(0) + "と" + user.myCards.get(1) + "を配られました(合計値" + user.open() + ")");
        if (dealer.open() == 21) {
            System.out.println("ディーラー側のナチュラルによりあなたの負けです");
        } else if (user.open() == 21) {
            System.out.println("あなた側のナチュラルによりあなたの勝ちです");
        }
//(ユーザー)手札の数字の数を確認して17以上でスタンド、16以下でヒット(ディーラーからカードを1枚貰い手札に加える)
        int countU = 1;
        while (user.open() < 17) {
            setCards = dealer.hit();
            user.setCard(setCards);
            countU++;
            System.out.println("あなたはカードの合計値が16以下なのでヒットして" + user.myCards.get(countU) + "を配られました(合計値" + user.open() + ")");
        }

//(ディーラー)手札の数字の数を確認して17以上でスタンド、16以下でヒット(ディーラーからカードを1枚貰い手札に加える)
        int countD = 1;
        while (dealer.open() < 17) {
            setCards = dealer.hit();
            dealer.setCard(setCards);
            countD++;
            System.out.println("ディーラーはカードの合計値が16以下なのでヒットして" + dealer.myCards.get(countD) + "を配られました(合計値" + dealer.open() + ")");

        }

//手札の公開→結果発表
//ユーザーとディーラーの手札の合計で結果を判断する
        if (user.open() > 21) {
            System.out.println("あなたの手札の合計値は" + user.open() + "でバーストしたのであなたの負けです");
        } else if (dealer.open() > 21) {
            System.out.println("ディーラーの手札の合計値は" + dealer.open() + "でバーストしたのであなたの勝ちです");
        } else if (user.open() < dealer.open()) {
            System.out.println("あなたの手札の合計値は" + user.open() + "で、ディーラーの手札の合計値は" + dealer.open() + "なのであなたの負けです");
        } else if (user.open() > dealer.open()) {
            System.out.println("あなたの手札の合計値は" + user.open() + "で、ディーラーの手札の合計値は" + dealer.open() + "なのであなたの勝ちです");
        } else {
            System.out.println("あなたの手札の合計値は" + user.open() + "で、ディーラーの手札の合計値は" + dealer.open() + "なので引き分けです");
        }
    }
}
