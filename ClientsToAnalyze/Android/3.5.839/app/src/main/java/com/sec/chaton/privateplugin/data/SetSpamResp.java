package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class SetSpamResp {
    private String cat;
    private String cnt;
    private String coc;
    private String code;
    private String desc;
    private String msisdn;
    private String pbty;
    private String reg;
    private Boolean spamer;

    public String getSpamMSISDN() {
        return this.msisdn;
    }

    public String getSpamDate() {
        return this.reg;
    }

    public String getSpamCount() {
        return this.cnt;
    }

    public boolean isSpamer() {
        return this.spamer.booleanValue();
    }

    public String getSpamProbability() {
        return this.pbty;
    }

    public String getSpamCategory() {
        return this.cat;
    }

    public String getSpamCode() {
        return this.code;
    }

    public String getSpamDescription() {
        return this.desc;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SetSpamResp [msisdn=").append(this.msisdn).append(", coc=").append(this.coc).append(", reg=").append(this.reg).append(", cnt=").append(this.cnt).append(", pbty=").append(this.pbty).append(", cat=").append(this.cat).append(", code=").append(this.code).append(", desc=").append(this.desc).append("]");
        return sb.toString();
    }
}
