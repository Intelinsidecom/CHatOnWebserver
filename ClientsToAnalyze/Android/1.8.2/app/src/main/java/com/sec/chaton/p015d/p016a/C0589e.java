package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.account.C0210g;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p028io.entry.GetBuddyList;
import com.sec.chaton.p028io.entry.inner.Address;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.p028io.entry.inner.SpecialUser;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: AddBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.e */
/* loaded from: classes.dex */
public class C0589e extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2335d;

    /* renamed from: e */
    private ContentResolver f2336e;

    public C0589e(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2335d = str;
        this.f2336e = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(this.f2335d, ",");
        String strM6112a = "";
        C1793y c1793y = new C1793y();
        while (stringTokenizer.hasMoreTokens()) {
            Address address = new Address();
            address.value = stringTokenizer.nextToken();
            arrayList.add(address);
            strM6112a = c1793y.m6112a(arrayList);
        }
        C1786r.m6066e("\n" + strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        if (c0101b.m671d() != null) {
            Iterator it = ((GetBuddyList) c0101b.m671d()).buddy.iterator();
            while (it.hasNext()) {
                Buddy buddy = (Buddy) it.next();
                C1786r.m6061b("Buddy NO : " + buddy.value + ", Name : " + buddy.name + ", StatusMessage : " + buddy.status + ", orgnum : " + buddy.orgnum + ", showphonenumber : " + buddy.showphonenumber + ", einfo : " + buddy.einfo, getClass().getSimpleName());
                C1746bb.m5945a(GlobalApplication.m3260b()).m5961a(buddy.value);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                if (this.f2335d.startsWith("+0999")) {
                    arrayList.add(C0555aw.m2753a(m2783a(buddy.value)));
                    arrayList.add(C0555aw.m2754a(buddy.value));
                } else {
                    arrayList.add(C0657a.m2982c(buddy));
                }
                this.f2336e.applyBatch("com.sec.chaton.provider", arrayList);
            }
            C0210g.m1810a(GlobalApplication.m3260b(), ((GetBuddyList) c0101b.m671d()).buddy);
            new C0633e(null).m2865a(true);
            new C0633e(null).m2854a(-1, -1);
        }
    }

    /* renamed from: a */
    private SpecialUser m2783a(String str) {
        SpecialUser specialUser = new SpecialUser();
        Cursor cursorQuery = this.f2336e.query(C0702q.f2645a, null, "buddy_no='" + str.replace("+", "") + "'", null, null);
        try {
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                if (!string.equals(str)) {
                    cursorQuery.moveToNext();
                } else {
                    specialUser.specialuserid = string;
                    specialUser.name = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                    specialUser.description = cursorQuery.getString(cursorQuery.getColumnIndex("description"));
                    specialUser.followcount = cursorQuery.getString(cursorQuery.getColumnIndex("followcount"));
                    specialUser.likecount = cursorQuery.getString(cursorQuery.getColumnIndex("likecount"));
                    specialUser.msgstatus = cursorQuery.getString(cursorQuery.getColumnIndex("msgstatus"));
                    specialUser.photoloaded = cursorQuery.getString(cursorQuery.getColumnIndex("photoloaded"));
                    specialUser.status = cursorQuery.getString(cursorQuery.getColumnIndex("status"));
                    specialUser.url = cursorQuery.getString(cursorQuery.getColumnIndex(RtspHeaders.Values.URL));
                    specialUser.weburl = cursorQuery.getString(cursorQuery.getColumnIndex("weburl"));
                    return specialUser;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return specialUser;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
