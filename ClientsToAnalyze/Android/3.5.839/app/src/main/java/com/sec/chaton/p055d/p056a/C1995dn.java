package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.EnumC2213aa;
import com.sec.chaton.p057e.EnumC2215ac;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p065io.entry.LiveChatFeedbackResponseEntry;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.specialbuddy.p117a.C4526b;
import com.sec.chaton.specialbuddy.p117a.C4529e;
import com.sec.chaton.specialbuddy.p117a.EnumC4527c;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LiveChatFeedbackHttpTask.java */
/* renamed from: com.sec.chaton.d.a.dn */
/* loaded from: classes.dex */
public class C1995dn extends AbstractC1900a {

    /* renamed from: b */
    private final String f7330b;

    /* renamed from: c */
    private List<C4526b> f7331c;

    public C1995dn(C2454e c2454e, List<C4526b> list) {
        super(c2454e);
        this.f7330b = getClass().getName();
        this.f7331c = list;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() throws JSONException {
        if (C4904y.f17872b) {
            C4904y.m18639b("livechat, feedback, Http task beforeRequest().", this.f7330b);
        }
        String strM18121a = C4809aa.m18104a().m18121a("chaton_id", "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("receiver", strM18121a);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (C4526b c4526b : this.f7331c) {
            switch (C1996do.f7332a[c4526b.m17221b().ordinal()]) {
                case 1:
                    JSONObject jSONObjectMo17220a = c4526b.mo17220a();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("livechat, write packet. TYPE_ACK. " + c4526b, this.f7330b);
                    }
                    if (jSONObjectMo17220a != null) {
                        jSONArray.put(jSONObjectMo17220a);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    JSONObject jSONObjectMo17220a2 = c4526b.mo17220a();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("livechat, write packet. TYPE_READ. " + c4526b, this.f7330b);
                    }
                    if (jSONObjectMo17220a2 != null) {
                        jSONArray2.put(jSONObjectMo17220a2);
                        break;
                    } else {
                        break;
                    }
            }
        }
        jSONObject.put("reportlist", jSONArray);
        jSONObject.put("readlist", jSONArray2);
        return C4529e.m17224a(jSONObject.toString());
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (C4904y.f17872b) {
            C4904y.m18639b("livechat, feedback, Http task afterRequest().", this.f7330b);
        }
        c0778b.m3105a();
        int iM3114i = c0778b.m3114i();
        EnumC2464o enumC2464oM3107b = c0778b.m3107b();
        boolean zN = c0778b.m18954n();
        LiveChatFeedbackResponseEntry liveChatFeedbackResponseEntry = (LiveChatFeedbackResponseEntry) c0778b.m3110e();
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("afterRequest(), connectionSuccess(%s), httpResultCode(%s), httpStatus(%d), resultEntry(%s)", Boolean.valueOf(zN), enumC2464oM3107b, Integer.valueOf(iM3114i), liveChatFeedbackResponseEntry), this.f7330b);
        }
        if (zN) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_is_ack", Integer.valueOf(EnumC2213aa.ACK_DONE.m10069a()));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("message_is_read", Integer.valueOf(EnumC2215ac.READ_SERVER.m10080a()));
            for (C4526b c4526b : this.f7331c) {
                if (c4526b.m17221b() == EnumC4527c.TYPE_ACK) {
                    arrayList.add(C2204r.m10011a("message_sever_id =? ", new String[]{String.valueOf(c4526b.f16385c)}, contentValues));
                }
                if (c4526b.m17221b() == EnumC4527c.TYPE_READ) {
                    arrayList.add(C2204r.m10011a("message_sever_id =? ", new String[]{String.valueOf(c4526b.f16385c)}, contentValues2));
                }
            }
            GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        }
    }
}
