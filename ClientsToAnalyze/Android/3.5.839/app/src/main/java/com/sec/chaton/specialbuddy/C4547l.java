package com.sec.chaton.specialbuddy;

import android.text.TextUtils;
import com.sec.chaton.util.C4904y;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONLiveMainFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.l */
/* loaded from: classes.dex */
public class C4547l {

    /* renamed from: a */
    final String f16408a;

    /* renamed from: b */
    final String f16409b;

    /* renamed from: c */
    private String f16410c;

    /* renamed from: d */
    private Boolean f16411d;

    /* synthetic */ C4547l(String str, boolean z, C4543h c4543h) {
        this(str, z);
    }

    private C4547l(String str, boolean z) {
        this.f16408a = "buddyid";
        this.f16409b = "follow";
        this.f16410c = str;
        this.f16411d = Boolean.valueOf(z);
    }

    /* renamed from: b */
    private boolean m17243b() {
        return (TextUtils.isEmpty(this.f16410c) || this.f16411d == null) ? false : true;
    }

    /* renamed from: a */
    public String m17244a() {
        if (!m17243b()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("getJsonString(), error : hasPairAll() == false ", ChatONLiveMainFragment.f16291a);
            }
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("buddyid", this.f16410c);
            jSONObject.put("follow", this.f16411d.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, ChatONLiveMainFragment.f16291a);
            }
            return "";
        }
    }
}
