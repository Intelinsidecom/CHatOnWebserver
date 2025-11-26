package com.sec.chaton.p017e.p019b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyBlockTask.java */
/* renamed from: com.sec.chaton.e.b.e */
/* loaded from: classes.dex */
public class C0678e extends AbstractC0674a {

    /* renamed from: b */
    private C0257c f2568b;

    /* renamed from: c */
    private boolean f2569c;

    /* renamed from: d */
    private int f2570d;

    public C0678e(InterfaceC0677d interfaceC0677d, C0257c c0257c, int i, boolean z) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2568b = c0257c;
        this.f2570d = i;
        this.f2569c = z;
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() {
        if (this.f2570d == 1) {
            Cursor cursorM2977a = C0657a.m2977a(GlobalApplication.m3260b().getContentResolver(), this.f2568b);
            if (cursorM2977a == null) {
                return true;
            }
            return cursorM2977a;
        }
        if (this.f2570d == 2) {
            ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
            C0657a.m2978a(contentResolver, this.f2568b, this.f2569c);
            ArrayList arrayListM3092e = C0670n.m3092e(contentResolver, this.f2568b.m2318a());
            if (arrayListM3092e != null && arrayListM3092e.size() > 0) {
                Iterator it = arrayListM3092e.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    C0670n.m3090d(contentResolver, str, this.f2568b.m2318a());
                    C0660d.m3028c(contentResolver, str);
                    C0665i.m3073c(contentResolver, str, String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.LEAVE.m3171a()), this.f2568b.m2318a(), C0493bg.m2684a(this.f2568b.m2324b())), C1789u.m6075a().getString("msisdn", ""));
                }
            }
        }
        return true;
    }
}
