package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p030g.C0709a;
import com.sec.chaton.p030g.C0710b;
import com.sec.chaton.p030g.InterfaceC0712d;
import com.sec.chaton.p033io.entry.inner.Address;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: UploadAddressTask.java */
/* renamed from: com.sec.chaton.a.a.bk */
/* loaded from: classes.dex */
public class C0162bk extends AbstractRunnableC0153bb {

    /* renamed from: a */
    InterfaceC0712d f380a;

    /* renamed from: b */
    private ArrayList f381b;

    /* renamed from: f */
    private ArrayList f382f;

    /* renamed from: g */
    private ArrayList f383g;

    /* renamed from: h */
    private ArrayList f384h;

    /* renamed from: i */
    private int f385i;

    public C0162bk(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
        this.f385i = 0;
        this.f380a = new C0131ag(this);
        this.f383g = new ArrayList();
        this.f384h = new ArrayList();
        this.f381b = new ArrayList();
        this.f382f = new ArrayList();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4658b("Cotact Compare Start", getClass().getSimpleName());
        C0710b.m3098a(this.f380a);
        C1341p.m4658b("Cotact Compare End", getClass().getSimpleName());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f383g.iterator();
        while (it.hasNext()) {
            C0709a c0709a = (C0709a) it.next();
            if (c0709a.m3095a().length() >= 8) {
                Address address = new Address();
                if (c0709a.m3095a().length() > 64) {
                    C1341p.m4662e("Number is too long : " + c0709a.m3095a(), getClass().getSimpleName());
                } else {
                    if (c0709a.m3097c() != null) {
                        if (c0709a.m3097c().length() < 48) {
                            address.name = c0709a.m3097c();
                        } else {
                            address.name = c0709a.m3097c().substring(0, 48);
                        }
                    }
                    address.value = c0709a.m3095a();
                    arrayList.add(address);
                }
            }
        }
        Iterator it2 = this.f384h.iterator();
        while (it2.hasNext()) {
            C0709a c0709a2 = (C0709a) it2.next();
            Address address2 = new Address();
            address2.value = c0709a2.m3095a();
            arrayList.add(address2);
        }
        this.f385i = arrayList.size();
        if (arrayList.size() == 0) {
            m685c();
        }
        C1341p.m4660c("Sent Contact Count : " + arrayList.size(), getClass().getSimpleName());
        String strM4714a = new C1349x().m4714a(arrayList);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        if (c0259g.m928b() != EnumC0518y.ERROR) {
            ContentResolver contentResolver = GlobalApplication.m3100a().getContentResolver();
            Iterator it = this.f384h.iterator();
            while (it.hasNext()) {
                C0709a c0709a = (C0709a) it.next();
                Cursor cursorQuery = contentResolver.query(C0667t.f2310a, null, "buddy_raw_contact_id = ? and buddy_orginal_number = ?", new String[]{String.valueOf(c0709a.m3096b()), c0709a.m3095a()}, null);
                C1341p.m4658b("afterRequest deletedPerson " + c0709a.m3096b() + ", name=" + c0709a.m3097c() + ", num=" + c0709a.m3095a(), getClass().getSimpleName());
                while (cursorQuery.moveToNext()) {
                    this.f381b.add(C0633m.m2881a(String.valueOf(c0709a.m3096b()), c0709a.m3095a(), cursorQuery.getString(cursorQuery.getColumnIndex("buddy_push_name"))));
                }
                cursorQuery.close();
            }
            C1341p.m4662e("Start making local Contact", getClass().getSimpleName());
            if (this.f381b.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", this.f381b);
            }
            if (this.f382f.size() > 0) {
                contentResolver.applyBatch("com.android.contacts", this.f382f);
            }
            C1341p.m4662e("End making local Contact", getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public int m700b() {
        return this.f385i;
    }
}
