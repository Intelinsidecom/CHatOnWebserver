package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.msgsend.ChatONMsgEntity;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageControlBase.java */
/* renamed from: com.sec.chaton.d.ac */
/* loaded from: classes.dex */
public abstract class AbstractC2070ac {

    /* renamed from: c */
    protected String f7551c;

    /* renamed from: d */
    protected EnumC2300t f7552d;

    /* renamed from: e */
    protected String f7553e;

    /* renamed from: f */
    protected final Object f7554f = new Object();

    /* renamed from: g */
    protected List<Handler> f7555g = new ArrayList();

    /* renamed from: a */
    public abstract long mo9203a(long j, EnumC2300t enumC2300t, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC2214ab enumC2214ab, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9208a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9209a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, String str3);

    /* renamed from: a */
    public abstract long mo9213a(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9216a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, boolean z, long j2, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9219a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, long j, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9221a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9222a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n, String str4, String str5);

    /* renamed from: a */
    public abstract long mo9226a(EnumC2214ab enumC2214ab, String str, String[] strArr, String[] strArr2);

    /* renamed from: a */
    public abstract long mo9227a(EnumC2300t enumC2300t, String str);

    /* renamed from: a */
    public abstract long mo9229a(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9231a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract long mo9232a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, String str4, EnumC2706n enumC2706n, String str5, String str6);

    /* renamed from: a */
    public abstract long mo9238a(File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n, String str6, String str7);

    /* renamed from: a */
    public abstract long mo9240a(String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2, String str3);

    /* renamed from: a */
    public abstract long mo9241a(String str, String[] strArr, String[] strArr2, boolean z);

    /* renamed from: a */
    public abstract void mo9243a(long j);

    /* renamed from: a */
    public abstract void mo9244a(String str);

    /* renamed from: a */
    public abstract boolean mo9245a(long j, String str, String str2, String str3, EnumC2214ab enumC2214ab, String str4, int i, String[] strArr);

    /* renamed from: a */
    public abstract boolean mo9247a(EnumC2300t enumC2300t, String str, Long l, String str2, String str3, long j);

    /* renamed from: a */
    public abstract boolean mo9248a(EnumC2300t enumC2300t, String str, Long l, String str2, String str3, long j, boolean z);

    /* renamed from: a */
    public abstract boolean mo9251a(File file, boolean z, String str, String str2, String str3, EnumC2214ab enumC2214ab, ArrayList<String> arrayList, EnumC2706n enumC2706n);

    /* renamed from: a */
    public abstract boolean mo9252a(String str, String str2, int i);

    /* renamed from: b */
    public abstract long mo9262b(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n);

    /* renamed from: b */
    public abstract void mo9266b(long j);

    /* renamed from: c */
    public abstract long mo9271c(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n);

    /* renamed from: c */
    public abstract boolean mo9272c();

    /* renamed from: d */
    public abstract void mo9274d();

    /* renamed from: e */
    public abstract boolean mo9276e();

    /* renamed from: f */
    public abstract void mo9278f();

    public AbstractC2070ac(String str, EnumC2300t enumC2300t) {
        this.f7551c = str;
        this.f7553e = str;
        this.f7552d = enumC2300t;
    }

    /* renamed from: a */
    public boolean m9249a(ChatONMsgEntity chatONMsgEntity, String[] strArr) {
        return mo9245a(chatONMsgEntity.m11260e().longValue(), chatONMsgEntity.m11262g(), chatONMsgEntity.m11263h(), chatONMsgEntity.m11264i(), chatONMsgEntity.m11261f(), chatONMsgEntity.m11265j(), chatONMsgEntity.m11266k(), strArr);
    }

    /* renamed from: a */
    public long m9220a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3) {
        return m9223a(enumC2214ab, enumC2300t, str, strArr, str2, str3, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9225a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        return m9224a(enumC2214ab, enumC2300t, str, strArr, str2, str3, EnumC2706n.f9699d, str4, str5);
    }

    /* renamed from: a */
    public long m9223a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, EnumC2706n enumC2706n) {
        return m9259b(enumC2214ab, enumC2300t, str, strArr, str2, str3, -1L, enumC2706n);
    }

    /* renamed from: a */
    public long m9224a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, EnumC2706n enumC2706n, String str4, String str5) {
        return m9260b(enumC2214ab, enumC2300t, str, strArr, str2, str3, -1L, enumC2706n, str4, str5);
    }

    /* renamed from: b */
    public long m9260b(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n, String str4, String str5) {
        return mo9222a(enumC2214ab, enumC2300t, str, strArr, str2, str3, j, enumC2706n, str4, str5);
    }

    /* renamed from: b */
    public long m9259b(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        return mo9221a(enumC2214ab, enumC2300t, str, strArr, str2, str3, j, enumC2706n);
    }

    /* renamed from: a */
    public long m9228a(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3) {
        return m9230a(enumC2300t, str, strArr, str2, str3, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9230a(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, EnumC2706n enumC2706n) {
        return m9273d(enumC2300t, str, strArr, str2, str3, -1L, enumC2706n);
    }

    /* renamed from: d */
    public long m9273d(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        return mo9229a(enumC2300t, str, strArr, str2, str3, j, enumC2706n);
    }

    /* renamed from: b */
    public long m9261b(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3) {
        return m9275e(enumC2300t, str, strArr, str2, str3, -1L, EnumC2706n.f9699d);
    }

    /* renamed from: e */
    public long m9275e(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        return mo9262b(enumC2300t, str, strArr, str2, str3, j, enumC2706n);
    }

    /* renamed from: c */
    public long m9270c(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3) {
        return m9277f(enumC2300t, str, strArr, str2, str3, -1L, EnumC2706n.f9699d);
    }

    /* renamed from: f */
    public long m9277f(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        return mo9271c(enumC2300t, str, strArr, str2, str3, j, enumC2706n);
    }

    /* renamed from: a */
    public long m9218a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2) {
        return mo9219a(enumC2214ab, enumC2300t, str, strArr, str2, -1L, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9234a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, EnumC2706n enumC2706n) {
        return m9263b(enumC2300t, str, strArr, z, str2, -1L, (String) null, enumC2706n);
    }

    /* renamed from: a */
    public long m9235a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, String str3) {
        return m9236a(enumC2300t, str, strArr, z, str2, str3, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9236a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, String str3, EnumC2706n enumC2706n) {
        return m9263b(enumC2300t, str, strArr, z, str2, -1L, str3, enumC2706n);
    }

    /* renamed from: b */
    public long m9263b(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, EnumC2706n enumC2706n) {
        return mo9231a(enumC2300t, str, strArr, z, str2, j, str3, enumC2706n);
    }

    /* renamed from: a */
    public long m9237a(File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, EnumC2706n enumC2706n) {
        return m9265b(file, str, enumC2214ab, enumC2300t, str2, strArr, z, str3, null, null, enumC2706n, null, null);
    }

    /* renamed from: a */
    public long m9239a(File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, String str6, String str7) {
        return m9265b(file, str, enumC2214ab, enumC2300t, str2, strArr, z, str3, str4, str5, EnumC2706n.f9699d, str6, str7);
    }

    /* renamed from: b */
    public long m9265b(File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n, String str6, String str7) {
        return mo9238a(file, str, enumC2214ab, enumC2300t, str2, strArr, z, str3, str4, str5, enumC2706n, str6, str7);
    }

    /* renamed from: a */
    public boolean m9250a(File file, boolean z, String str, String str2, String str3, EnumC2214ab enumC2214ab, ArrayList<String> arrayList) {
        return m9268b(file, z, str, str2, str3, enumC2214ab, arrayList, EnumC2706n.f9699d);
    }

    /* renamed from: b */
    public boolean m9268b(File file, boolean z, String str, String str2, String str3, EnumC2214ab enumC2214ab, ArrayList<String> arrayList, EnumC2706n enumC2706n) {
        return mo9251a(file, z, str, str2, str3, enumC2214ab, arrayList, enumC2706n);
    }

    /* renamed from: a */
    public long m9233a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, String str4, String str5, String str6) {
        return m9264b(enumC2300t, str, strArr, z, str2, j, str3, str4, EnumC2706n.f9699d, str5, str6);
    }

    /* renamed from: b */
    public long m9264b(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, String str4, EnumC2706n enumC2706n, String str5, String str6) {
        return mo9232a(enumC2300t, str, strArr, z, str2, j, str3, str4, enumC2706n, str5, str6);
    }

    /* renamed from: a */
    public long m9206a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2) {
        return m9210a(j, enumC2300t, str, strArr, z, str2, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9210a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, EnumC2706n enumC2706n) {
        return m9256b(j, enumC2300t, str, strArr, z, str2, -1L, enumC2706n);
    }

    /* renamed from: a */
    public long m9207a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2) {
        return m9256b(j, enumC2300t, str, strArr, z, str2, j2, EnumC2706n.f9699d);
    }

    /* renamed from: b */
    public long m9256b(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, EnumC2706n enumC2706n) {
        return mo9208a(j, enumC2300t, str, strArr, z, str2, j2, enumC2706n);
    }

    /* renamed from: a */
    public long m9214a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, boolean z) {
        return m9217a(j, str, enumC2214ab, enumC2300t, str2, strArr, str3, z, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9217a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, boolean z, EnumC2706n enumC2706n) {
        return m9258b(j, str, enumC2214ab, enumC2300t, str2, strArr, str3, z, -1L, enumC2706n);
    }

    /* renamed from: a */
    public long m9215a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, boolean z, long j2) {
        return m9258b(j, str, enumC2214ab, enumC2300t, str2, strArr, str3, z, j2, EnumC2706n.f9699d);
    }

    /* renamed from: b */
    public long m9258b(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, boolean z, long j2, EnumC2706n enumC2706n) {
        return mo9216a(j, str, enumC2214ab, enumC2300t, str2, strArr, str3, z, j2, enumC2706n);
    }

    /* renamed from: a */
    public long m9204a(long j, EnumC2300t enumC2300t, String str, String[] strArr, String str2) {
        return m9205a(j, enumC2300t, str, strArr, str2, -1L);
    }

    /* renamed from: a */
    public long m9205a(long j, EnumC2300t enumC2300t, String str, String[] strArr, String str2, long j2) {
        return m9215a(j, this.f7551c, EnumC2214ab.POLL, enumC2300t, str, strArr, str2, TextUtils.isEmpty(str), j2);
    }

    /* renamed from: b */
    public long m9254b(long j, EnumC2300t enumC2300t, String str, String[] strArr, String str2) {
        return m9255b(j, enumC2300t, str, strArr, str2, -1L);
    }

    /* renamed from: b */
    public long m9255b(long j, EnumC2300t enumC2300t, String str, String[] strArr, String str2, long j2) {
        return m9215a(j, this.f7551c, EnumC2214ab.APPLINK, enumC2300t, str, strArr, str2, TextUtils.isEmpty(str), j2);
    }

    /* renamed from: a */
    public long m9211a(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, EnumC2706n enumC2706n) {
        return m9257b(j, file, str, enumC2214ab, enumC2300t, str2, strArr, z, str3, null, null, enumC2706n);
    }

    /* renamed from: a */
    public long m9212a(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4) {
        return m9257b(j, file, str, enumC2214ab, enumC2300t, str2, strArr, z, str3, str4, null, EnumC2706n.f9699d);
    }

    /* renamed from: b */
    public long m9257b(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n) {
        return mo9213a(j, file, str, enumC2214ab, enumC2300t, str2, strArr, z, str3, str4, str5, enumC2706n);
    }

    /* renamed from: a */
    public long m9202a(long j, EnumC2300t enumC2300t, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC2214ab enumC2214ab) {
        return m9253b(j, enumC2300t, str, str2, strArr, z, str3, str4, enumC2214ab, EnumC2706n.f9699d);
    }

    /* renamed from: b */
    public long m9253b(long j, EnumC2300t enumC2300t, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC2214ab enumC2214ab, EnumC2706n enumC2706n) {
        return mo9203a(j, enumC2300t, str, str2, strArr, z, str3, str4, enumC2214ab, enumC2706n);
    }

    /* renamed from: c */
    public long m9269c(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, String str3) {
        return mo9209a(j, enumC2300t, str, strArr, z, str2, j2, str3);
    }

    /* renamed from: a */
    public boolean m9246a(Handler handler) {
        boolean zAdd;
        synchronized (this.f7554f) {
            if (this.f7555g.contains(handler)) {
                zAdd = true;
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("addHandler : " + handler.toString(), getClass().getSimpleName());
                }
                zAdd = this.f7555g.add(handler);
            }
        }
        return zAdd;
    }

    /* renamed from: b */
    public boolean m9267b(Handler handler) {
        boolean zRemove;
        if (C4904y.f17872b) {
            C4904y.m18639b("removeHandler : " + handler.toString(), getClass().getSimpleName());
        }
        synchronized (this.f7554f) {
            zRemove = this.f7555g.remove(handler);
        }
        return zRemove;
    }

    /* renamed from: a */
    protected void m9242a(int i, int i2, int i3, Object obj, long j) {
        synchronized (this.f7554f) {
            for (Handler handler : this.f7555g) {
                Message messageObtain = Message.obtain();
                messageObtain.arg1 = i;
                messageObtain.arg2 = i2;
                messageObtain.what = i3;
                messageObtain.obj = C1770hp.m8778a(j, obj);
                handler.sendMessage(messageObtain);
            }
        }
        C4904y.m18639b("RequestID : " + String.valueOf(j), getClass().getSimpleName());
    }

    /* renamed from: r */
    public boolean mo9279r() {
        return true;
    }

    /* renamed from: s */
    public void mo9280s() {
    }
}
