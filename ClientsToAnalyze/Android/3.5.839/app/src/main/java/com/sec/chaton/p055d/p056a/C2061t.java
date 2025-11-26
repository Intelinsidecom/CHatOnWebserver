package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.C0895dv;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2216ad;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.util.ArrayList;

/* compiled from: CancelMessageTask.java */
/* renamed from: com.sec.chaton.d.a.t */
/* loaded from: classes.dex */
public class C2061t extends AbstractC1981d {

    /* renamed from: h */
    private String f7522h;

    /* renamed from: i */
    private String f7523i;

    /* renamed from: j */
    private String f7524j;

    /* renamed from: k */
    private EnumC2300t f7525k;

    /* renamed from: l */
    private String f7526l;

    /* renamed from: m */
    private long f7527m;

    /* renamed from: n */
    private ContentResolver f7528n;

    /* renamed from: o */
    private long f7529o;

    /* renamed from: p */
    private String f7530p;

    /* renamed from: q */
    private String f7531q;

    public C2061t(Handler handler, String str, String str2, EnumC2300t enumC2300t, String str3, long j) {
        super(handler);
        this.f7522h = "CancelMessageTask";
        this.f7190f = -1L;
        this.f7523i = str;
        this.f7524j = str2;
        this.f7525k = enumC2300t;
        this.f7526l = str3;
        this.f7527m = j;
        this.f7528n = GlobalApplication.m18732r().getContentResolver();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x010f A[DONT_GENERATE] */
    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sec.chaton.p067j.C2426ao mo9093b() {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.C2061t.mo9093b():com.sec.chaton.j.ao");
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        super.mo9092a(i, obj, obj2);
        Message message = new Message();
        message.what = 44;
        if (obj2 != null) {
            C0895dv c0895dv = (C0895dv) ((C2426ao) obj2).m10513c();
            C1734gg.m8599a(this.f7523i, c0895dv, this.f7522h);
            message.obj = new C0788l(m9195a(c0895dv.m4701h().m5229d(), this.f7527m, C4809aa.m18104a().m18121a("chaton_id", "")), i, this.f7527m);
            this.f7186b.sendMessage(message);
            return;
        }
        if ((!mo9104a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C2198l.m9953f(GlobalApplication.m18732r().getContentResolver(), this.f7523i);
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7523i}));
        }
        C4904y.m18641c("Result NULL", this.f7522h);
        message.obj = new C0788l(false, i);
        this.f7186b.sendMessage(message);
    }

    /* renamed from: a */
    private boolean m9195a(int i, long j, String str) throws Throwable {
        boolean z;
        ContentProviderOperation contentProviderOperation;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (i == 1000 || i == 1001) {
            boolean zM10039a = C2204r.m10039a(arrayList, j, str);
            boolean z2 = !C4809aa.m18104a().m18121a("chaton_id", "").equals(str);
            String strM10028a = C2204r.m10028a(String.valueOf(j), z2);
            ContentProviderOperation contentProviderOperationM10012a = C2204r.m10012a(zM10039a, j, strM10028a, z2);
            if (contentProviderOperationM10012a != null) {
                arrayList.add(contentProviderOperationM10012a);
            } else if (C4904y.f17872b) {
                C4904y.m18639b("updateWithdraw - inboxOperaion is null, inboxNo(" + strM10028a + ")", this.f7522h);
            }
            if (i == 1001) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Partially Successful", this.f7522h);
                }
                arrayList.add(m9194a(i));
            }
            z = true;
            contentProviderOperation = contentProviderOperationM10012a;
        } else {
            if (i == 8200) {
                C4904y.m18641c("fail casue by FOUND_UNDO_NOT_SUPPORTING_DEVICE", this.f7522h);
            }
            ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2306z.f8229a);
            builderNewUpdate.withSelection("_id=?", new String[]{String.valueOf(this.f7527m)});
            builderNewUpdate.withValue("message_status", Integer.valueOf(EnumC2216ad.WITHDRAW_FAIL.m10083a()));
            arrayList.add(builderNewUpdate.build());
            arrayList.add(m9194a(i));
            contentProviderOperation = null;
            z = false;
        }
        try {
            if (arrayList.size() > 0) {
                GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                if (contentProviderOperation != null) {
                    C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7523i}));
                    C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
                }
            }
            return z;
        } catch (Exception e) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18635a(e, this.f7522h);
            return false;
        }
    }

    /* renamed from: a */
    private ContentProviderOperation m9194a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d,%s", Integer.valueOf(EnumC2231as.CANCELED_MESSAGE_FAILURE.m10100a()), String.valueOf(i))).append(Config.KEYVALUE_SPLIT);
        return C2204r.m10010a(this.f7523i, sb.toString(), this.f7529o + 1, C4809aa.m18104a().m18121a("chaton_id", ""));
    }
}
