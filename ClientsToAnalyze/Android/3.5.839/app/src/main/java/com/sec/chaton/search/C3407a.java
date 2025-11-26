package com.sec.chaton.search;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: QueryParser.java */
/* renamed from: com.sec.chaton.search.a */
/* loaded from: classes.dex */
public class C3407a {

    /* renamed from: a */
    List<String> f12369a;

    public C3407a() {
        this.f12369a = null;
        this.f12369a = new ArrayList();
    }

    /* renamed from: a */
    public String[] m13219a(String str) {
        Matcher matcher = Pattern.compile("\\[([^\\[]+)\\]").matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            Log.d("SearchQuery", "regexParser b : " + strGroup);
            String strReplaceAll = strGroup.replaceAll("^\\[|\\]$", "");
            if ("&".equals(strReplaceAll)) {
                this.f12369a.add("AND");
            } else if ("|".equals(strReplaceAll)) {
                this.f12369a.add("OR");
            } else {
                this.f12369a.add(strReplaceAll);
            }
            Log.d("SearchQuery", "regexParser : " + strReplaceAll);
        }
        return (String[]) this.f12369a.toArray(new String[this.f12369a.size()]);
    }
}
