package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: UnBlockTask.java */
/* renamed from: com.sec.chaton.d.a.eb */
/* loaded from: classes.dex */
public class C1255eb extends AbstractC1145a {

    /* renamed from: b */
    private String f4823b;

    public C1255eb(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4823b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            new C1330h(null).m5727a(true);
            new C1330h(null).m5736c();
            ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
            Cursor cursorQuery = contentResolver.query(C1457y.f5415a, new String[]{"participants_country_code", "participants_is_auth"}, "participants_buddy_no=?", new String[]{this.f4823b}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(1);
                int i = -1;
                if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                    i = 0;
                }
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                arrayList.add(C1381y.m6205a(this.f4823b, i));
                contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
