package com.sec.chaton.p027e.p029b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.util.C3159aa;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyBlockTask.java */
/* renamed from: com.sec.chaton.e.b.g */
/* loaded from: classes.dex */
public class C1416g extends AbstractC1410a {

    /* renamed from: c */
    private C0513c f5255c;

    /* renamed from: d */
    private boolean f5256d;

    /* renamed from: e */
    private int f5257e;

    public C1416g(InterfaceC1413d interfaceC1413d, C0513c c0513c, int i, boolean z) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5255c = c0513c;
        this.f5257e = i;
        this.f5256d = z;
    }

    @Override // com.sec.chaton.p027e.p029b.AbstractC1410a
    /* renamed from: a */
    public Object mo6263a() {
        ArrayList<String> arrayListM6225g;
        if (this.f5257e == 1) {
            Cursor cursorM6024a = C1360d.m6024a(CommonApplication.m11493l().getContentResolver(), this.f5255c);
            if (cursorM6024a == null) {
                return true;
            }
            return cursorM6024a;
        }
        if (this.f5257e == 2) {
            ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
            C1360d.m6028a(contentResolver, this.f5255c, this.f5256d);
            if (this.f5255c != null && (arrayListM6225g = C1381y.m6225g(contentResolver, this.f5255c.m3975b())) != null && arrayListM6225g.size() > 0) {
                Iterator<String> it = arrayListM6225g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    C1381y.m6219d(contentResolver, next, this.f5255c.m3975b());
                    C1370n.m6136c(contentResolver, next);
                    C1373q.m6194c(contentResolver, next, String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.LEAVE.m6248a()), this.f5255c.m3975b(), C1075eq.m5318a(this.f5255c.m3976c())), C3159aa.m10962a().m10979a("chaton_id", ""));
                }
            }
        }
        return true;
    }
}
