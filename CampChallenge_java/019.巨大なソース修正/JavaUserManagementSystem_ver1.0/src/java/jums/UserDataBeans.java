/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;

/**
 *
 * @author takizawaryoutarou
 */
public class UserDataBeans implements Serializable {

//各フィールドの宣言
    private String name = "";
    private String year = "0";
    private String month = "0";
    private String day = "0";
    private String tell1 = "";
    private String tell2 = "";
    private String tell3 = "";
    private int type = 0;
    private String comment = "";

//戻り値をフィールドの値とするメソッド(get〇〇())と引数をフィールドの値に設定するメソッド(set〇〇(String 〇〇))の宣言
//フォームで受け取った値をset〇〇(String 〇〇)の引数にすることで受け取った値がフィールドの値になる
//これによってget〇〇()メソッドの値が決定される(フィールドの値が戻り値の為)    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTell1() {
        return tell1;
    }

    public void setTell1(String tell) {
        this.tell1 = tell;
    }

    public String getTell2() {
        return tell2;
    }

    public void setTell2(String tell) {
        this.tell2 = tell;
    }

    public String getTell3() {
        return tell3;
    }

    public void setTell3(String tell) {
        this.tell3 = tell;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UserDataBeans() {
    }

}
