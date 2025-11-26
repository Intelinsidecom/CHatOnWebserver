package com.sec.chaton.specialbuddy;

import android.text.TextUtils;
import com.sec.chaton.util.C3250y;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONLiveMainFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.p */
/* loaded from: classes.dex */
public class C2935p {

    /* renamed from: a */
    final String f10467a = "buddyid";

    /* renamed from: b */
    final String f10468b = "follow";

    /* renamed from: c */
    private String f10469c;

    /* renamed from: d */
    private Boolean f10470d;

    public C2935p(String str, boolean z) {
        this.f10469c = str;
        this.f10470d = Boolean.valueOf(z);
    }

    /* renamed from: b */
    private boolean m10163b() {
        return (TextUtils.isEmpty(this.f10469c) || this.f10470d == null) ? false : true;
    }

    /* renamed from: a */
    public String m10164a() {
        if (!m10163b()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("getJsonString(), error : hasPairAll() == false ", ChatONLiveMainFragment.f10403k);
            }
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("buddyid", this.f10469c);
            jSONObject.put("follow", this.f10470d.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, ChatONLiveMainFragment.f10403k);
            }
            return "";
        }
    }
}
