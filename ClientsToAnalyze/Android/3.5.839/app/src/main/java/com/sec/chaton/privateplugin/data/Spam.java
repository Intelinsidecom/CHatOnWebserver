package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class Spam {
    public static final String ACTIVITY_CANCEL = "0";
    public static final String ACTIVITY_CHECK = "2";
    public static final String ACTIVITY_REPORT = "1";
    public static final String CATEGORY_DEFAULT = "test";
    private String act;
    private String cat;
    private String msg;
    private String num;

    public Spam setNum(String str) {
        this.num = str;
        return this;
    }

    public Spam setAct(String str) {
        this.act = str;
        return this;
    }

    public Spam setMsg(String str) {
        this.msg = str;
        return this;
    }

    public Spam setCat(String str) {
        this.cat = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Spam [num=").append(this.num).append(", act=").append(this.act).append(", msg=").append(this.msg).append(", cat=").append(this.cat).append("]");
        return sb.toString();
    }
}
