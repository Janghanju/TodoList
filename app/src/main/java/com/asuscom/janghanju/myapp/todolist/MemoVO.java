package com.asuscom.janghanju.myapp.todolist;

/**
 * Created by MacBook on 2018. 1. 18..
 */

public class MemoVO {

    private long id ;
    private String strDate ;
    private String strTime ;

    public MemoVO() {

    }

    public MemoVO(String strDate, String strTime, String strMemo) {
        this.strDate = strDate;
        this.strTime = strTime;
        this.strMemo = strMemo;
    }

    public MemoVO(long id, String strTime, String strMemo) {
        this.id = id;
        this.strDate = strDate;
        this.strTime = strTime;
        this.strMemo = strMemo;
    }

    public long getId() {
        return id;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getStrMemo() {
        return strMemo;
    }

    public void setStrMemo(String strMemo) {
        this.strMemo = strMemo;
    }

    private String strMemo ;
}
