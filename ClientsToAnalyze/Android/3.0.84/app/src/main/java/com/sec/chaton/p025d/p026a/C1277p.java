package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p016a.C0400o;
import com.sec.chaton.p016a.C0403r;
import com.sec.chaton.p016a.C0404s;
import com.sec.chaton.p016a.C0406u;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AnswerBackTask.java */
/* renamed from: com.sec.chaton.d.a.p */
/* loaded from: classes.dex */
public class C1277p extends AbstractC1199c {

    /* renamed from: h */
    private C0400o f4884h;

    /* renamed from: i */
    private ContentResolver f4885i;

    public C1277p(Handler handler, C0400o c0400o) {
        super(handler);
        this.f4884h = c0400o;
        this.f4885i = CommonApplication.m11493l().getContentResolver();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v46, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        C0404s c0404sNewBuilder = C0403r.newBuilder();
        List<C0406u> listM2907c = this.f4884h.m2907c();
        HashMap map = new HashMap();
        Long.valueOf(0L);
        for (C0406u c0406u : listM2907c) {
            Long lValueOf = Long.valueOf(c0406u.m2975f());
            String strM2973d = c0406u.m2973d();
            if (!TextUtils.isEmpty(strM2973d) && !strM2973d.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                map.put(lValueOf, Integer.valueOf(map.containsKey(lValueOf) ? ((Integer) map.get(lValueOf)).intValue() + 1 : 1));
            }
            c0404sNewBuilder.m2952a(c0406u);
        }
        if (C3250y.f11738f) {
            StringBuilder sb = new StringBuilder();
            sb.append("ch@t[c <~~ s]received= MsgID : ");
            for (int i = 0; i < listM2907c.size(); i++) {
                sb.append(listM2907c.get(i).m2975f() + ",");
            }
            sb.append(" API type : ").append(10);
            C3250y.m11457f(sb.toString(), getClass().getSimpleName());
        }
        ?? arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            try {
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1454v.m6343a());
                builderNewUpdate.withValue("message_sever_id", entry.getKey()).withValue("count", entry.getValue());
                arrayList.add(builderNewUpdate.build());
            } catch (Throwable th) {
                arrayList.clear();
                throw th;
            }
        }
        try {
            if (arrayList.size() > 0) {
                this.f4885i.applyBatch("com.sec.chaton.provider", arrayList);
            }
        } catch (Exception e) {
            C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
        }
        arrayList.clear();
        arrayList = "uid";
        c0404sNewBuilder.m2953a(C3159aa.m10962a().m10979a("uid", ""));
        if (C3250y.f11734b) {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < this.f4884h.m2907c().size(); i2++) {
                sb2.append("[" + i2 + "]MsgID = " + this.f4884h.m2905a(i2).m2975f()).append(", Receiver = " + this.f4884h.m2905a(i2).m2973d());
            }
            C3250y.m11453c("ch@t[" + this.f4884h.getClass().getSimpleName() + "]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", AnswerbackItemsCount : " + this.f4884h.m2908d() + ",Items : " + sb2.toString(), getClass().getSimpleName());
            StringBuilder sb3 = new StringBuilder();
            for (int i3 = 0; i3 < c0404sNewBuilder.m2960f().size(); i3++) {
                sb3.append("[" + i3 + "]MsgID = " + c0404sNewBuilder.m2954a(i3).m2975f()).append(", Receiver = " + c0404sNewBuilder.m2954a(i3).m2973d());
            }
            C3250y.m11453c("ch@t[" + c0404sNewBuilder.getClass().getSimpleName() + "]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", AnswerbackItemsCount : " + c0404sNewBuilder.m2961g() + ",Items : " + sb3.toString(), getClass().getSimpleName());
        }
        if (C3250y.f11738f) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ch@t[c ~~> s] MsgID : ");
            for (int i4 = 0; i4 < c0404sNewBuilder.m2960f().size(); i4++) {
                sb4.append(c0404sNewBuilder.m2954a(i4).m2975f() + ",");
            }
            sb4.append(" API type : ").append(11);
            C3250y.m11457f(sb4.toString(), getClass().getSimpleName());
        }
        C1549ah c1549ah = new C1549ah();
        c1549ah.m6581a(c0404sNewBuilder.build()).m6579a(11);
        return c1549ah.m6584b();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) {
    }
}
