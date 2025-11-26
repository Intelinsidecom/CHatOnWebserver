package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.inner.Address;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: AddBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.h */
/* loaded from: classes.dex */
public class C1269h extends AbstractC1145a {

    /* renamed from: b */
    private String f4867b;

    /* renamed from: c */
    private String f4868c;

    /* renamed from: e */
    private SpecialUser f4869e;

    /* renamed from: f */
    private ContentResolver f4870f;

    public C1269h(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4867b = str;
        this.f4869e = new SpecialUser();
        this.f4870f = CommonApplication.m11493l().getContentResolver();
        Cursor cursorQuery = this.f4870f.query(C1388af.f5186a, null, "buddy_no='" + this.f4867b.replace("+", "") + "'", null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            this.f4869e.specialuserid = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
            this.f4869e.name = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
            this.f4869e.description = cursorQuery.getString(cursorQuery.getColumnIndex("description"));
            this.f4869e.followcount = cursorQuery.getString(cursorQuery.getColumnIndex("followcount"));
            this.f4869e.likecount = cursorQuery.getString(cursorQuery.getColumnIndex("likecount"));
            this.f4869e.msgstatus = cursorQuery.getString(cursorQuery.getColumnIndex("msgstatus"));
            this.f4869e.photoloaded = cursorQuery.getString(cursorQuery.getColumnIndex("photoloaded"));
            this.f4869e.status = cursorQuery.getString(cursorQuery.getColumnIndex("status"));
            this.f4869e.url = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
            this.f4869e.weburl = cursorQuery.getString(cursorQuery.getColumnIndex("weburl"));
            cursorQuery.close();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(this.f4867b, ",");
        String strM11026a = "";
        C3164af c3164af = new C3164af();
        while (stringTokenizer.hasMoreTokens()) {
            Address address = new Address();
            address.value = stringTokenizer.nextToken();
            if (this.f4868c != null && !TextUtils.isEmpty(this.f4868c)) {
                address.name = this.f4868c;
            }
            arrayList.add(address);
            strM11026a = c3164af.m11026a(arrayList);
        }
        C3250y.m11456e("\n" + strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0267d.m1354e() != null) {
            Iterator<Buddy> it = ((GetBuddyList) c0267d.m1354e()).buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                C3250y.m11450b("Buddy NO : " + next.value + ", Name : " + next.name + ", StatusMessage : " + next.status + ", orgnum : " + next.orgnum + ", showphonenumber : " + next.showphonenumber + ", einfo : " + next.einfo, getClass().getSimpleName());
                C3205bt.m11182a(CommonApplication.m11493l()).m11227b(next.value);
                C3205bt.m11182a(CommonApplication.m11493l()).m11216a(next.value, EnumC1450r.GROUPCHAT);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                if (this.f4867b.startsWith("+0999")) {
                    arrayList.add(C1206cg.m5543a(this.f4869e));
                } else {
                    arrayList.add(C1360d.m6019a(next));
                    if (next.value != null) {
                        arrayList.add(C1206cg.m5544a(next.value));
                    }
                }
                if (next.value != null) {
                    arrayList.add(C1381y.m6205a(next.value, 0));
                }
                this.f4870f.applyBatch("com.sec.chaton.provider", arrayList);
            }
            C0423i.m3037a(CommonApplication.m11493l(), ((GetBuddyList) c0267d.m1354e()).buddy);
            new C1330h(null).m5727a(true);
            new C1330h(null).m5736c();
        }
    }
}
