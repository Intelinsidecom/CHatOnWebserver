package com.sds.coolots.common.controller.translation.data;

import com.sds.coolots.common.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.sds.coolots.common.controller.translation.data.a */
/* loaded from: classes.dex */
public class C1250a {

    /* renamed from: a */
    private static final String f3010a = "[TranslationList]";

    /* renamed from: b */
    private HashMap f3011b;

    /* renamed from: c */
    private void m2904c() {
        if (this.f3011b == null) {
            this.f3011b = new HashMap();
        }
    }

    /* renamed from: c */
    private void m2905c(String str) {
        Log.m2958e(f3010a + str);
    }

    /* renamed from: d */
    private void m2906d(String str) {
        Log.m2963i(f3010a + str);
    }

    /* renamed from: a */
    public int m2907a() {
        m2904c();
        return this.f3011b.size();
    }

    /* renamed from: a */
    public void m2908a(TranslationDisplayData translationDisplayData) {
        m2904c();
        if (this.f3011b.get(translationDisplayData.getID()) != null) {
            ((TranslationDisplayData) this.f3011b.get(translationDisplayData.getID())).setData(translationDisplayData);
        } else {
            this.f3011b.put(translationDisplayData.getID(), translationDisplayData);
        }
    }

    /* renamed from: a */
    public void m2909a(String str) {
        m2904c();
        if (this.f3011b.get(str) != null) {
            ((TranslationDisplayData) this.f3011b.get(str)).dispose();
            this.f3011b.remove(str);
        }
    }

    /* renamed from: a */
    public void m2910a(String str, String str2) {
        m2912b(str).setRecognizedText(str2);
        m2912b(str).setNowRecognizing(false);
    }

    /* renamed from: a */
    public void m2911a(String str, boolean z) {
        m2912b(str).setNowTTSPlaying(z);
    }

    /* renamed from: b */
    public TranslationDisplayData m2912b(String str) {
        m2904c();
        return (TranslationDisplayData) this.f3011b.get(str);
    }

    /* renamed from: b */
    public void m2913b() {
        if (this.f3011b != null) {
            Iterator it = this.f3011b.keySet().iterator();
            while (it.hasNext()) {
                ((TranslationDisplayData) this.f3011b.get(it.next())).dispose();
            }
            this.f3011b.clear();
            this.f3011b = null;
        }
    }

    /* renamed from: b */
    public void m2914b(String str, String str2) {
        m2912b(str).setTranslatedText(str2);
        m2912b(str).setNowTranslating(false);
    }

    public String toString() {
        if (this.f3011b == null || this.f3011b.isEmpty()) {
            return "Empty list";
        }
        String str = null;
        Iterator it = this.f3011b.keySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String str3 = (String) it.next();
            str = String.valueOf(str2) + "\n[" + str3 + "] " + ((TranslationDisplayData) this.f3011b.get(str3)).toString();
        }
    }
}
