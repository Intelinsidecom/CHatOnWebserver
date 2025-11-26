package com.sec.chaton.chat;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.C0351cu;
import com.sec.chaton.p016a.C0366di;
import com.sec.chaton.p016a.C0369dl;
import com.sec.chaton.p016a.C0388ed;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1447o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1456x;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1372p;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.chat.fd */
/* loaded from: classes.dex */
public class C1089fd {

    /* renamed from: a */
    private static final String f4350a = C1089fd.class.getSimpleName();

    /* renamed from: b */
    private static C1089fd f4351b;

    /* renamed from: a */
    public static synchronized C1089fd m5358a() {
        if (f4351b == null) {
            f4351b = new C1089fd();
        }
        return f4351b;
    }

    private C1089fd() {
    }

    /* renamed from: a */
    public void m5365a(String str, String str2, long j) {
        ContentResolver contentResolver = GlobalApplication.m11493l().getContentResolver();
        if (j == 0) {
            long jM6110a = C1370n.m6110a(contentResolver, str);
            if (jM6110a == 0) {
                j = System.currentTimeMillis();
            } else {
                j = jM6110a + 1;
            }
        }
        C1370n.m6104a(contentResolver, str2, j);
        C1370n.m6104a(contentResolver, C3159aa.m10962a().m10979a("chaton_id", ""), j);
        if (C1381y.m6212b(contentResolver, str) > 1) {
            C1381y.m6219d(contentResolver, str, C3159aa.m10962a().m10979a("chaton_id", ""));
        }
        C1373q.m6190b(contentResolver, str);
        if (C3250y.f11735c) {
            C3250y.m11453c("7001(SESSION_DEACTIVATED) - time : " + j, f4350a);
        }
    }

    /* renamed from: a */
    public void m5362a(Handler handler, String str, EnumC1450r enumC1450r, C0369dl c0369dl) throws RemoteException, OperationApplicationException {
        try {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
            C0366di c0366diM2500j = c0369dl.m2500j();
            if (enumC1450r == EnumC1450r.ONETOONE) {
                String strM6146j = C1370n.m6146j(contentResolver, m5359a(arrayList, contentResolver, str, c0366diM2500j));
                if (!TextUtils.isEmpty(strM6146j)) {
                    Message message = new Message();
                    message.what = 107;
                    message.obj = new C0272i(true, 7100);
                    handler.sendMessage(message);
                    if (C3250y.f11735c) {
                        C3250y.m11453c("merge(new inbox to old) start - old:" + str + ",new:" + strM6146j, f4350a);
                    }
                    m5366a(arrayList, contentResolver, str, strM6146j, c0366diM2500j);
                    Message message2 = new Message();
                    message2.what = 107;
                    message2.obj = new C0272i(true, 7101);
                    handler.sendMessage(message2);
                    if (C3250y.f11735c) {
                        C3250y.m11453c("merge(new inbox to old) finish - old:" + str + ",new:" + c0366diM2500j, f4350a);
                    }
                }
                m5368a(arrayList, c0366diM2500j, str);
                m5370b(arrayList, c0366diM2500j, str);
            }
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            if (C3250y.f11735c) {
                C3250y.m11453c("7006(NON_WEB_USER_DETECTED) - inboxNo" + str, f4350a);
            }
        } catch (OperationApplicationException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f4350a);
            }
        } catch (RemoteException e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f4350a);
            }
        }
    }

    /* renamed from: a */
    public void m5361a(Handler handler, String str, C0369dl c0369dl) throws RemoteException, OperationApplicationException {
        try {
            ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            C0388ed c0388edM2498h = c0369dl.m2498h();
            String strM2733i = c0388edM2498h.m2733i();
            String strM6135b = C1370n.m6135b(contentResolver, strM2733i);
            if (!TextUtils.isEmpty(strM6135b)) {
                Message message = new Message();
                message.what = 107;
                message.obj = new C0272i(true, 7100);
                handler.sendMessage(message);
                if (C3250y.f11735c) {
                    C3250y.m11453c("merge(new inbox to old) start - old:" + str + ",new:" + strM6135b, f4350a);
                }
                m5367a(arrayList, contentResolver, str, strM6135b, c0388edM2498h);
                Message message2 = new Message();
                message2.what = 107;
                message2.obj = new C0272i(true, 7101);
                handler.sendMessage(message2);
                if (C3250y.f11735c) {
                    C3250y.m11453c("merge(new inbox to old) finish - old:" + str + ",new:" + strM6135b, f4350a);
                }
            } else {
                m5371b(arrayList, c0388edM2498h, str);
            }
            m5372c(arrayList, c0388edM2498h, str);
            m5373d(arrayList, c0388edM2498h, str);
            String strM5895d = C1337o.m5813d(str).m5895d();
            if (!TextUtils.isEmpty(strM5895d)) {
                arrayList.add(C1370n.m6112a(contentResolver, strM5895d, strM2733i));
            }
            String strM5360a = m5360a(arrayList, contentResolver, str, c0388edM2498h, true);
            m5369a(arrayList, c0388edM2498h, str);
            C1337o.m5813d(str).m5894c(strM2733i);
            C1337o.m5813d(str).m5872a(strM5360a);
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            C1335m.m5784a((Handler) null, str, strM2733i, 0L);
            if (C3250y.f11735c) {
                m5364a("7002(SESSION_TRANSITED) - Session ID : " + strM2733i, c0388edM2498h);
            }
        } catch (OperationApplicationException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f4350a);
            }
        } catch (RemoteException e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f4350a);
            }
        }
    }

    /* renamed from: a */
    public void m5363a(String str, C0369dl c0369dl) throws RemoteException, OperationApplicationException {
        try {
            ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            C0388ed c0388edM2498h = c0369dl.m2498h();
            String strM5360a = m5360a(arrayList, contentResolver, str, c0388edM2498h, false);
            arrayList.add(C1381y.m6213b(str, C3159aa.m10962a().m10979a("chaton_id", "")));
            m5373d(arrayList, c0388edM2498h, str);
            m5374e(arrayList, c0388edM2498h, str);
            long jM2728d = c0388edM2498h.m2728d();
            arrayList.add(C1370n.m6114a(str, jM2728d));
            C1337o.m5813d(str).m5867a(jM2728d);
            C1337o.m5813d(str).m5872a(strM5360a);
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            C1335m.m5784a((Handler) null, str, C1337o.m5813d(str).m5895d(), 0L);
            if (C3250y.f11735c) {
                m5364a("7003(SESSION_MERGED) - SessionMerge timestap : " + jM2728d, c0388edM2498h);
            }
        } catch (OperationApplicationException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f4350a);
            }
        } catch (RemoteException e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f4350a);
            }
        }
    }

    /* renamed from: a */
    public void m5364a(String str, C0388ed c0388ed) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(", CurrentMemberList : ");
        Iterator<String> it = c0388ed.m2729e().iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        sb.append("MembershipChangesList : ");
        for (C0351cu c0351cu : c0388ed.m2731g()) {
            String strM2335d = c0351cu.m2335d();
            sb.append("(old:").append(strM2335d).append(",new:").append(c0351cu.m2337f()).append("), ");
        }
        C3250y.m11453c(sb.toString(), f4350a);
    }

    /* renamed from: a */
    public void m5367a(ArrayList<ContentProviderOperation> arrayList, ContentResolver contentResolver, String str, String str2, C0388ed c0388ed) {
        C1372p c1372pM6140d = C1370n.m6140d(contentResolver, str);
        if (c1372pM6140d == null) {
            C3250y.m11442a("mergeToOldInbox - oldInboxData is null", f4350a);
            return;
        }
        Uri uri = C1449q.f5381a;
        arrayList.add(ContentProviderOperation.newDelete(uri).withSelection("inbox_no=?", new String[]{str}).build());
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_old_session_id", c1372pM6140d.f5130i);
        if (TextUtils.isEmpty(c1372pM6140d.f5141t)) {
            contentValues.put("inbox_old_no", str2);
        } else {
            contentValues.put("inbox_old_no", c1372pM6140d.f5141t + "," + str2);
        }
        arrayList.add(ContentProviderOperation.newUpdate(uri).withSelection("inbox_no=?", new String[]{str2}).withValues(contentValues).build());
        Uri uri2 = C1454v.f5393a;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("message_inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri2).withSelection("message_inbox_no=?", new String[]{str2}).withValues(contentValues2).build());
        Uri uri3 = C1457y.f5415a;
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("participants_inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri3).withSelection("participants_inbox_no=?", new String[]{str2}).withValues(contentValues3).build());
        Uri uri4 = C1447o.f5379a;
        ContentValues contentValues4 = new ContentValues();
        contentValues4.put("inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri4).withSelection("inbox_no =?", new String[]{str2}).withValues(contentValues4).build());
    }

    /* renamed from: a */
    public String m5360a(ArrayList<ContentProviderOperation> arrayList, ContentResolver contentResolver, String str, C0388ed c0388ed, boolean z) {
        String str2;
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        Uri uri = C1456x.f5414a;
        sb.append("update mapping_participant : ");
        for (C0351cu c0351cu : c0388ed.m2731g()) {
            String strM2335d = c0351cu.m2335d();
            String strM2337f = c0351cu.m2337f();
            if (strM2337f.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                if (z) {
                    sb.append("(old:").append(strM2335d).append(",new:").append(strM2337f).append(") -> transited to my number - invalid,");
                    str2 = str3;
                } else {
                    arrayList.add(C1381y.m6213b(str, strM2335d));
                    sb.append("(old:").append(strM2335d).append(",new:").append(strM2337f).append(") -> delete my number,");
                    str2 = str3;
                }
            } else {
                arrayList.add(C1381y.m6214b(str, strM2335d, strM2337f));
                sb.append("(old:").append(strM2335d).append(",new:").append(strM2337f).append(") -> update");
                str2 = strM2337f;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("participants_buddy_no", strM2337f);
            contentValues.put("participants_old_buddy_no", strM2335d);
            arrayList.add(ContentProviderOperation.newInsert(uri).withValues(contentValues).build());
            str3 = str2;
        }
        C3250y.m11453c(sb.toString(), f4350a);
        return str3;
    }

    /* renamed from: a */
    public void m5369a(ArrayList<ContentProviderOperation> arrayList, C0388ed c0388ed, String str) {
        for (C0351cu c0351cu : c0388ed.m2731g()) {
            String strM2335d = c0351cu.m2335d();
            String strM2337f = c0351cu.m2337f();
            String[] strArr = {strM2335d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("buddy_no", strM2337f);
            arrayList.add(C1370n.m6134b("buddy_no=? AND inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: a */
    public String m5359a(ArrayList<ContentProviderOperation> arrayList, ContentResolver contentResolver, String str, C0366di c0366di) {
        String str2;
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        Uri uri = C1456x.f5414a;
        sb.append("update mapping_participant : ");
        for (C0351cu c0351cu : c0366di.m2468c()) {
            String strM2335d = c0351cu.m2335d();
            String strM2337f = c0351cu.m2337f();
            if (strM2337f.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                sb.append("(old:").append(strM2335d).append(",new:").append(strM2337f).append(") -> transited to my number - invalid,");
                str2 = str3;
            } else {
                arrayList.add(C1381y.m6214b(str, strM2335d, strM2337f));
                sb.append("(old:").append(strM2335d).append(",new:").append(strM2337f).append(") -> update");
                str2 = strM2337f;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("participants_buddy_no", strM2337f);
            contentValues.put("participants_old_buddy_no", strM2335d);
            arrayList.add(ContentProviderOperation.newInsert(uri).withValues(contentValues).build());
            str3 = str2;
        }
        C3250y.m11453c(sb.toString(), f4350a);
        return str3;
    }

    /* renamed from: a */
    public void m5368a(ArrayList<ContentProviderOperation> arrayList, C0366di c0366di, String str) {
        for (C0351cu c0351cu : c0366di.m2468c()) {
            String strM2335d = c0351cu.m2335d();
            String strM2337f = c0351cu.m2337f();
            String[] strArr = {strM2335d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("buddy_no", strM2337f);
            arrayList.add(C1370n.m6134b("buddy_no=? AND inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: b */
    public void m5370b(ArrayList<ContentProviderOperation> arrayList, C0366di c0366di, String str) {
        for (C0351cu c0351cu : c0366di.m2468c()) {
            String strM2335d = c0351cu.m2335d();
            String strM2337f = c0351cu.m2337f();
            String[] strArr = {strM2335d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", strM2337f);
            arrayList.add(C1373q.m6165a("message_sender=? AND message_inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: a */
    public void m5366a(ArrayList<ContentProviderOperation> arrayList, ContentResolver contentResolver, String str, String str2, C0366di c0366di) {
        C1372p c1372pM6140d = C1370n.m6140d(contentResolver, str);
        Uri uri = C1449q.f5381a;
        arrayList.add(ContentProviderOperation.newDelete(uri).withSelection("inbox_no=?", new String[]{str}).build());
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_old_session_id", c1372pM6140d.f5130i);
        if (TextUtils.isEmpty(c1372pM6140d.f5141t)) {
            contentValues.put("inbox_old_no", str2);
        } else {
            contentValues.put("inbox_old_no", c1372pM6140d.f5141t + "," + str2);
        }
        arrayList.add(ContentProviderOperation.newUpdate(uri).withSelection("inbox_no=?", new String[]{str2}).withValues(contentValues).build());
        Uri uri2 = C1454v.f5393a;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("message_inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri2).withSelection("message_inbox_no=?", new String[]{str2}).withValues(contentValues2).build());
        Uri uri3 = C1457y.f5415a;
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("participants_inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri3).withSelection("participants_inbox_no=?", new String[]{str2}).withValues(contentValues3).build());
        Uri uri4 = C1447o.f5379a;
        ContentValues contentValues4 = new ContentValues();
        contentValues4.put("inbox_no", str);
        arrayList.add(ContentProviderOperation.newUpdate(uri4).withSelection("inbox_no =?", new String[]{str2}).withValues(contentValues4).build());
    }

    /* renamed from: b */
    public void m5371b(ArrayList<ContentProviderOperation> arrayList, C0388ed c0388ed, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_session_id", c0388ed.m2733i());
        arrayList.add(C1370n.m6116a("inbox_no=?", new String[]{str}, contentValues));
    }

    /* renamed from: c */
    public void m5372c(ArrayList<ContentProviderOperation> arrayList, C0388ed c0388ed, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_session_id", c0388ed.m2733i());
        arrayList.add(C1373q.m6165a("message_inbox_no=?", new String[]{str}, contentValues));
    }

    /* renamed from: d */
    public void m5373d(ArrayList<ContentProviderOperation> arrayList, C0388ed c0388ed, String str) {
        for (C0351cu c0351cu : c0388ed.m2731g()) {
            String strM2335d = c0351cu.m2335d();
            String strM2337f = c0351cu.m2337f();
            String[] strArr = {strM2335d, str};
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", strM2337f);
            arrayList.add(C1373q.m6165a("message_sender=? AND message_inbox_no =?", strArr, contentValues));
        }
    }

    /* renamed from: e */
    public void m5374e(ArrayList<ContentProviderOperation> arrayList, C0388ed c0388ed, String str) {
        int iM2730f = c0388ed.m2730f() - 1;
        String[] strArr = {C3159aa.m10962a().m10979a("chaton_id", ""), str};
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_read_status", Integer.valueOf(iM2730f));
        arrayList.add(C1373q.m6165a("message_sender=? AND message_inbox_no =? AND message_read_status > " + iM2730f, strArr, contentValues));
    }
}
