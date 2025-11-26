package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p027i.C0818a;
import com.sec.chaton.p027i.C0821d;
import com.sec.chaton.p027i.InterfaceC0820c;
import com.sec.chaton.p028io.entry.inner.Address;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.d.a.bw */
/* loaded from: classes.dex */
public class C0582bw extends AbstractRunnableC0532a {

    /* renamed from: d */
    InterfaceC0820c f2313d;

    /* renamed from: e */
    private ArrayList f2314e;

    /* renamed from: f */
    private ArrayList f2315f;

    /* renamed from: g */
    private ArrayList f2316g;

    /* renamed from: h */
    private ArrayList f2317h;

    /* renamed from: i */
    private String f2318i;

    /* renamed from: j */
    private String f2319j;

    /* renamed from: k */
    private int f2320k;

    public C0582bw(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
        this.f2318i = null;
        this.f2319j = null;
        this.f2320k = 0;
        this.f2313d = new C0583bx(this);
        this.f2316g = new ArrayList();
        this.f2317h = new ArrayList();
        this.f2314e = new ArrayList();
        this.f2315f = new ArrayList();
    }

    public C0582bw(Handler handler, C0798h c0798h, String str, String str2) {
        super(handler, c0798h);
        this.f2318i = null;
        this.f2319j = null;
        this.f2320k = 0;
        this.f2313d = new C0583bx(this);
        this.f2316g = new ArrayList();
        this.f2317h = new ArrayList();
        this.f2314e = new ArrayList();
        this.f2315f = new ArrayList();
        this.f2318i = str;
        this.f2319j = str2;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6061b("Cotact Compare Start", getClass().getSimpleName());
        C0818a.m3461a(this.f2313d);
        C1786r.m6061b("Cotact Compare End", getClass().getSimpleName());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2316g.iterator();
        while (it.hasNext()) {
            C0821d c0821d = (C0821d) it.next();
            if (c0821d.m3462a().length() >= 8) {
                Address address = new Address();
                if (c0821d.m3462a().length() > 64) {
                    C1786r.m6066e("Number is too long : " + c0821d.m3462a(), getClass().getSimpleName());
                } else {
                    if (c0821d.m3464c() != null) {
                        if (c0821d.m3464c().length() < 48) {
                            address.name = c0821d.m3464c();
                        } else {
                            address.name = c0821d.m3464c().substring(0, 48);
                        }
                    }
                    address.value = c0821d.m3462a();
                    arrayList.add(address);
                }
            }
        }
        Iterator it2 = this.f2317h.iterator();
        while (it2.hasNext()) {
            C0821d c0821d2 = (C0821d) it2.next();
            Address address2 = new Address();
            address2.value = c0821d2.m3462a();
            arrayList.add(address2);
        }
        if (this.f2318i != null && this.f2319j != null) {
            Address address3 = new Address();
            address3.value = this.f2319j;
            address3.name = this.f2318i;
            arrayList.add(address3);
        }
        this.f2320k = arrayList.size();
        if (arrayList.size() == 0) {
            m2709b();
        }
        C1786r.m6063c("Sent Contact Count : " + arrayList.size(), getClass().getSimpleName());
        String strM6112a = new C1793y().m6112a(arrayList);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        if (c0101b.m665b() != EnumC0803m.ERROR) {
            ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
            Iterator it = this.f2317h.iterator();
            while (it.hasNext()) {
                C0821d c0821d = (C0821d) it.next();
                Cursor cursorQuery = contentResolver.query(C0688c.f2606a, null, "buddy_raw_contact_id = ? and buddy_orginal_number = ?", new String[]{String.valueOf(c0821d.m3463b()), c0821d.m3462a()}, null);
                C1786r.m6061b("afterRequest deletedPerson " + c0821d.m3463b() + ", name=" + c0821d.m3464c() + ", num=" + c0821d.m3462a(), getClass().getSimpleName());
                while (cursorQuery.moveToNext()) {
                    this.f2314e.add(C0657a.m2976a(String.valueOf(c0821d.m3463b()), c0821d.m3462a(), cursorQuery.getString(cursorQuery.getColumnIndex("buddy_push_name"))));
                }
                cursorQuery.close();
            }
            C1786r.m6066e("Start making local Contact", getClass().getSimpleName());
            if (this.f2314e.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", this.f2314e);
            }
            if (this.f2315f.size() > 0) {
                contentResolver.applyBatch("com.android.contacts", this.f2315f);
            }
            C1786r.m6066e("End making local Contact", getClass().getSimpleName());
        }
    }

    /* renamed from: f */
    public int m2775f() {
        return this.f2320k;
    }
}
