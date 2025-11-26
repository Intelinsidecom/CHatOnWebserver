package com.sec.chaton.search;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: QueryParser.java */
/* renamed from: com.sec.chaton.search.a */
/* loaded from: classes.dex */
public class C2379a {

    /* renamed from: a */
    List<String> f8840a;

    public C2379a() {
        this.f8840a = null;
        this.f8840a = new ArrayList();
    }

    /* renamed from: a */
    public String[] m8838a(String str) {
        Matcher matcher = Pattern.compile("\\[([^\\[]+)\\]").matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            Log.d("SearchQuery", "regexParser b : " + strGroup);
            String strReplaceAll = strGroup.replaceAll("^\\[|\\]$", "");
            if ("&".equals(strReplaceAll)) {
                this.f8840a.add("AND");
            } else if ("|".equals(strReplaceAll)) {
                this.f8840a.add("OR");
            } else {
                this.f8840a.add(strReplaceAll);
            }
            Log.d("SearchQuery", "regexParser : " + strReplaceAll);
        }
        return (String[]) this.f8840a.toArray(new String[this.f8840a.size()]);
    }
}
