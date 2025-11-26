package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.inner.SpecialUser;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: FollowSpecialBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.ae */
/* loaded from: classes.dex */
public class C0537ae extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2199d;

    /* renamed from: e */
    private String f2200e;

    /* renamed from: f */
    private SpecialUser f2201f;

    /* renamed from: g */
    private ContentResolver f2202g;

    public C0537ae(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2199d = str;
        this.f2201f = new SpecialUser();
        this.f2202g = GlobalApplication.m3260b().getContentResolver();
        Cursor cursorQuery = this.f2202g.query(C0702q.f2645a, null, "buddy_no='" + this.f2199d + "'", null, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            this.f2201f.specialuserid = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
            this.f2201f.name = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
            this.f2201f.description = cursorQuery.getString(cursorQuery.getColumnIndex("description"));
            this.f2201f.followcount = cursorQuery.getString(cursorQuery.getColumnIndex("followcount"));
            this.f2201f.likecount = cursorQuery.getString(cursorQuery.getColumnIndex("likecount"));
            this.f2201f.msgstatus = cursorQuery.getString(cursorQuery.getColumnIndex("msgstatus"));
            this.f2201f.photoloaded = cursorQuery.getString(cursorQuery.getColumnIndex("photoloaded"));
            this.f2201f.status = cursorQuery.getString(cursorQuery.getColumnIndex("status"));
            this.f2201f.url = cursorQuery.getString(cursorQuery.getColumnIndex(RtspHeaders.Values.URL));
            this.f2201f.weburl = cursorQuery.getString(cursorQuery.getColumnIndex("weburl"));
        }
        this.f2200e = this.f2201f.name;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f2199d);
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            C1786r.m6061b("Special Buddy NO : " + this.f2199d + " Special Buddy Name : " + this.f2200e, getClass().getSimpleName());
            if (this.f2199d != null && this.f2200e != null) {
                SpecialUser specialUser = this.f2201f;
                toString();
                specialUser.followcount = String.valueOf(c0101b.m671d());
                arrayList.add(C0555aw.m2753a(this.f2201f));
            }
            arrayList.add(C0555aw.m2754a(this.f2199d));
            this.f2202g.applyBatch("com.sec.chaton.provider", arrayList);
            return;
        }
        C1786r.m6061b("Buddy NO : " + this.f2199d, getClass().getSimpleName());
        arrayList.add(C0555aw.m2754a(this.f2199d));
        this.f2202g.applyBatch("com.sec.chaton.provider", arrayList);
    }
}
