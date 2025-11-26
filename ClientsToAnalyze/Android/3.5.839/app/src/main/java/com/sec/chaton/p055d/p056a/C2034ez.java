package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2187am;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: UnBlockTask.java */
/* renamed from: com.sec.chaton.d.a.ez */
/* loaded from: classes.dex */
public class C2034ez extends AbstractC1900a {

    /* renamed from: b */
    private String f7438b;

    public C2034ez(C2454e c2454e, String str) {
        super(c2454e);
        this.f7438b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            new C2128i(null).m9504a(true);
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            arrayList.add(C2187am.m9779a(this.f7438b));
            ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
            Cursor cursorQuery = contentResolver.query(C2220ah.f7942a, new String[]{"participants_country_code", "participants_is_auth"}, "participants_buddy_no=?", new String[]{this.f7438b}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(1);
                int i = -1;
                if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                    i = 0;
                }
                arrayList.add(C2176ab.m9669a(this.f7438b, i));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (arrayList.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            }
        }
    }
}
