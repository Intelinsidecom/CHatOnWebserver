package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.p046a.C0867cu;
import com.sec.chaton.p046a.C0929fb;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2215ac;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.Iterator;
import java.util.List;

/* compiled from: ReadMessageTask.java */
/* renamed from: com.sec.chaton.d.a.eb */
/* loaded from: classes.dex */
public class C2010eb extends AbstractC1981d {

    /* renamed from: h */
    private String f7380h;

    /* renamed from: i */
    private String f7381i;

    /* renamed from: j */
    private EnumC2300t f7382j;

    /* renamed from: k */
    private ContentResolver f7383k;

    /* renamed from: l */
    private List<C0867cu> f7384l;

    public C2010eb(Handler handler, EnumC2300t enumC2300t, String str, String str2) {
        super(handler);
        this.f7380h = str;
        this.f7381i = str2;
        this.f7382j = enumC2300t;
        this.f7383k = CommonApplication.m18732r().getContentResolver();
        this.f7190f = -1L;
    }

    public C2010eb(List<C0867cu> list, Handler handler, EnumC2300t enumC2300t, String str, String str2) {
        super(handler);
        this.f7380h = str;
        this.f7381i = str2;
        this.f7382j = enumC2300t;
        this.f7384l = list;
        this.f7383k = CommonApplication.m18732r().getContentResolver();
        this.f7190f = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x019b A[PHI: r1
  0x019b: PHI (r1v37 android.database.Cursor) = (r1v36 android.database.Cursor), (r1v39 android.database.Cursor) binds: [B:34:0x0199, B:61:0x0261] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x021d  */
    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sec.chaton.p067j.C2426ao mo9093b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.C2010eb.mo9093b():com.sec.chaton.j.ao");
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        int iM5229d;
        super.mo9092a(i, obj, obj2);
        Message message = new Message();
        message.what = 38;
        if (obj2 != null) {
            C0929fb c0929fb = (C0929fb) ((C2426ao) obj2).m10513c();
            C1734gg.m8604a(this.f7381i, c0929fb, "ReadMessageTask");
            if (c0929fb.m5116f() == null) {
                iM5229d = -1;
            } else {
                iM5229d = c0929fb.m5116f().m5229d();
            }
            if (iM5229d == 1000) {
                message.obj = new C0788l(true, iM5229d);
                StringBuilder sb = new StringBuilder();
                Iterator<C0867cu> it = this.f7384l.iterator();
                while (it.hasNext()) {
                    sb.append(", '" + it.next().m4208h() + "'");
                }
                String str = "message_sever_id IN ( " + sb.toString().substring(1) + " )";
                ContentValues contentValues = new ContentValues();
                contentValues.put("message_is_read", Integer.valueOf(EnumC2215ac.READ_SERVER.m10080a()));
                this.f7383k.update(C2306z.f8229a, contentValues, str, null);
            } else {
                message.obj = new C0788l(false, i);
            }
        } else {
            if (i == 1) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("do not request read message", getClass().getSimpleName());
                    return;
                }
                return;
            }
            if ((!mo9104a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
                C2198l.m9953f(this.f7383k, this.f7381i);
                C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7381i}));
            }
            if (C4904y.f17873c) {
                C4904y.m18641c("Fail to send ReadMessage", getClass().getSimpleName());
            }
            message.obj = new C0788l(false, i);
        }
        this.f7186b.sendMessage(message);
    }
}
