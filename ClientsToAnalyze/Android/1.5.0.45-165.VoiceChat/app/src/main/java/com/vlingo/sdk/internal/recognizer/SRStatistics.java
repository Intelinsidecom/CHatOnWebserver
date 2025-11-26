package com.vlingo.sdk.internal.recognizer;

import com.vlingo.sdk.internal.http.HttpUtil;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class SRStatistics {
    private String guttId;
    private Hashtable<Object, Object> stats = new Hashtable<>();
    private String type;
    public static String TYPE_ACCEPTED_TEXT = "AcceptedText";
    public static String TYPE_REC_TIMING = "RecTiming";
    public static String TYPE_USAGE_COUNTS = "UsageCounts";
    public static String STAT_ACCEPTED_TEXT = "ACCEPTED_TEXT";
    public static String STAT_BOR = "BOR";
    public static String STAT_EOS = "EOS";
    public static String STAT_EOR = "EOR";
    public static String STAT_EOD = "EOD";
    public static String STAT_SED = "SED";
    public static String STAT_RES = "RES";
    public static String STAT_PAR = "PAR";
    public static String STAT_UTT = "UTT";
    public static String STAT_KEY = "KEY";
    public static String STAT_NAV = "NAV";
    public static String STAT_WNBNAV = "WNBNAV";
    public static String STAT_PNBNAV = "PNBNAV";
    public static String STAT_WNAV = "WNAV";
    public static String STAT_NBCOR = "NBCOR";
    public static String STAT_CDEL = "CDEL";
    public static String STAT_WDEL = "WDEL";
    public static String STAT_PDEL = "PDEL";
    public static String STAT_CLR = "CLR";
    public static String STAT_CREC = "CREC";
    public static String STAT_WREC = "WREC";
    public static String STAT_PREC = "PREC";
    public static String STAT_CSEL = "CSEL";
    public static String STAT_WSEL = "WSEL";
    public static String STAT_PSEL = "PSEL";

    public SRStatistics(String guttId, String type) {
        this.guttId = guttId;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String getGuttId() {
        return this.guttId;
    }

    public void addStatistic(String name, String value) {
        this.stats.put(name, value);
    }

    public Hashtable<Object, Object> getStatistics() {
        return this.stats;
    }

    public void setStatistics(Hashtable<Object, Object> stats) {
        this.stats = stats;
    }

    public String getXML() {
        return getXML(true);
    }

    String getXML(boolean includeRootTag) {
        StringBuffer sb = new StringBuffer();
        if (includeRootTag) {
            sb.append("<Stats " + HttpUtil.genAtr("guttid", getGuttId()) + ">");
        }
        Enumeration<?> iter = getStatistics().keys();
        while (iter.hasMoreElements()) {
            String key = (String) iter.nextElement();
            String value = (String) getStatistics().get(key);
            sb.append("<Stat ");
            sb.append(HttpUtil.genAtr("n", key));
            sb.append(HttpUtil.genAtr("v", value));
            sb.append("/>");
        }
        if (includeRootTag) {
            sb.append("</Stats>");
        }
        return sb.toString();
    }
}
