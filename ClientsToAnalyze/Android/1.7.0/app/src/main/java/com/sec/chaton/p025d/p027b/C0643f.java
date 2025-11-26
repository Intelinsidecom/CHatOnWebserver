package com.sec.chaton.p025d.p027b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1323bs;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyBlockTask.java */
/* renamed from: com.sec.chaton.d.b.f */
/* loaded from: classes.dex */
public class C0643f extends AbstractC0647j {

    /* renamed from: a */
    private C0363a f2239a;

    /* renamed from: b */
    private boolean f2240b;

    /* renamed from: c */
    private int f2241c;

    public C0643f(InterfaceC0641d interfaceC0641d, C0363a c0363a, int i, boolean z) {
        super(interfaceC0641d, new Handler(Looper.getMainLooper()));
        this.f2239a = c0363a;
        this.f2241c = i;
        this.f2240b = z;
    }

    @Override // com.sec.chaton.p025d.p027b.AbstractC0647j
    /* renamed from: a */
    public Object mo2950a() {
        if (this.f2241c == 1) {
            Cursor cursorM2882a = C0633m.m2882a(GlobalApplication.m3100a().getContentResolver(), this.f2239a);
            if (cursorM2882a == null) {
                return true;
            }
            return cursorM2882a;
        }
        if (this.f2241c == 2) {
            ContentResolver contentResolver = GlobalApplication.m3100a().getContentResolver();
            C0633m.m2884a(contentResolver, this.f2239a, this.f2240b);
            ArrayList arrayListM2873e = C0631k.m2873e(contentResolver, this.f2239a.m2308a());
            if (arrayListM2873e != null && arrayListM2873e.size() > 0) {
                Iterator it = arrayListM2873e.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    C0631k.m2871d(contentResolver, str, this.f2239a.m2308a());
                    C0634n.m2909b(contentResolver, str);
                    C0635o.m2948c(contentResolver, str, String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.LEAVE.m3010a()), this.f2239a.m2308a(), C0520a.m2713a(this.f2239a.m2314b())), C1323bs.m4575a().getString("msisdn", ""));
                }
            }
        }
        return true;
    }
}
