package com.sec.chaton.p017e.p019b;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0703r;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: RelationUpdateTask.java */
/* renamed from: com.sec.chaton.e.b.m */
/* loaded from: classes.dex */
public class C0686m extends AbstractC0674a {

    /* renamed from: e */
    private static boolean f2598e = false;

    /* renamed from: f */
    private static ArrayList f2599f = new ArrayList();

    /* renamed from: b */
    String f2600b;

    /* renamed from: c */
    Cursor f2601c;

    /* renamed from: d */
    Cursor f2602d;

    /* renamed from: g */
    private ContentResolver f2603g;

    /* renamed from: h */
    private ArrayList f2604h;

    /* renamed from: i */
    private ArrayList f2605i;

    /* renamed from: a */
    public static void m3110a(InterfaceC0687n interfaceC0687n) {
        f2599f.add(interfaceC0687n);
    }

    /* renamed from: b */
    public static void m3113b(InterfaceC0687n interfaceC0687n) {
        if (f2599f.contains(interfaceC0687n)) {
            f2599f.remove(interfaceC0687n);
        }
    }

    /* renamed from: b */
    public static boolean m3114b() {
        return f2598e;
    }

    /* renamed from: d */
    private static void m3115d() {
        Iterator it = f2599f.iterator();
        while (it.hasNext()) {
            ((InterfaceC0687n) it.next()).mo3119a();
        }
    }

    public C0686m(InterfaceC0677d interfaceC0677d, String str, ArrayList arrayList) {
        super(interfaceC0677d);
        this.f2603g = GlobalApplication.m3260b().getContentResolver();
        this.f2600b = str;
        this.f2604h = new ArrayList();
        this.f2605i = new ArrayList();
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() throws RemoteException, OperationApplicationException {
        try {
            m3118c();
            f2598e = true;
            this.f2603g.insert(C0703r.m3168b(), null);
            List listM3109a = m3109a(this.f2600b);
            for (int i = 0; i < listM3109a.size(); i++) {
                this.f2604h.clear();
                this.f2605i.clear();
                String str = (String) listM3109a.get(i);
                if (i > 6) {
                    break;
                }
                String str2 = (String) listM3109a.get(i + 1);
                C1786r.m6061b("LastWeekDates:---- day_1 =" + str2 + " day_2=" + str, "RelationUpdateTask");
                this.f2601c = this.f2603g.query(C0703r.m3166a(), null, "relation_date = ? and buddy_relation_hide = 'N' ", new String[]{str2}, "relation_point DESC, relation_last_msg_time LIMIT 30");
                m3116a(this.f2601c);
                this.f2602d = this.f2603g.query(C0703r.m3166a(), null, "relation_date = ? and buddy_relation_hide = 'N' ", new String[]{str}, "relation_point DESC, relation_last_msg_time  LIMIT 30");
                m3117b(this.f2602d);
                m3112a(this.f2604h, this.f2605i);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.f2604h.size(); i2++) {
                    ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0703r.f2646a);
                    builderNewUpdate.withValue("relation_rank", Integer.valueOf(((C0257c) this.f2604h.get(i2)).m2344p()));
                    builderNewUpdate.withValue("relation_icon", Integer.valueOf(((C0257c) this.f2604h.get(i2)).m2342n()));
                    builderNewUpdate.withValue("relation_increase", Integer.valueOf(((C0257c) this.f2604h.get(i2)).m2343o()));
                    builderNewUpdate.withSelection("relation_buddy_id = ? AND relation_date = ? ", new String[]{((C0257c) this.f2604h.get(i2)).m2318a(), str2});
                    arrayList.add(builderNewUpdate.build());
                }
                try {
                    this.f2603g.applyBatch("com.sec.chaton.provider", arrayList);
                } catch (Exception e) {
                    C1786r.m6056a(e, getClass().getSimpleName());
                }
            }
            C1789u.m6079a("relation_update_day", this.f2600b);
            f2598e = false;
            m3115d();
        } catch (Exception e2) {
        }
        return null;
    }

    /* renamed from: a */
    private List m3109a(String str) {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 8; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -i);
            arrayList.add(simpleDateFormat.format(new Date(calendar.getTimeInMillis())));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public void m3116a(Cursor cursor) {
        this.f2604h.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f2604h.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
        }
        cursor.close();
        m3111a(this.f2604h);
    }

    /* renamed from: a */
    private static void m3111a(ArrayList arrayList) {
        int i = 0;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i + 1;
            ((C0257c) arrayList.get(i2)).m2334f(i3);
            ((C0257c) arrayList.get(i2)).m2330d(m3108a(((C0257c) arrayList.get(i2)).m2339k() + ((C0257c) arrayList.get(i2)).m2340l(), i3, arrayList.size()));
            i2++;
            i = i3;
        }
    }

    /* renamed from: a */
    private static int m3108a(int i, int i2, int i3) {
        float f = (i2 / i3) * 100.0f;
        if (i == 0) {
            return 0;
        }
        if (i2 <= 5) {
            return 5;
        }
        if (f < 40.0f) {
            return 4;
        }
        if (f <= 40.0f || f >= 70.0f) {
            return (f <= 70.0f || f >= 90.0f) ? 1 : 2;
        }
        return 3;
    }

    /* renamed from: b */
    public void m3117b(Cursor cursor) {
        C1786r.m6061b("B_relationCnt=" + cursor.getCount(), "RelationUpdateTask");
        this.f2605i.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f2605i.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
        }
        cursor.close();
    }

    /* renamed from: a */
    private static void m3112a(ArrayList arrayList, ArrayList arrayList2) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (((C0257c) arrayList.get(i)).m2318a().equals(((C0257c) arrayList2.get(i2)).m2318a())) {
                    ((C0257c) arrayList.get(i)).m2332e(((C0257c) arrayList2.get(i2)).m2344p() - ((C0257c) arrayList.get(i)).m2344p());
                }
            }
        }
    }

    /* renamed from: c */
    public void m3118c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -8);
        String str = simpleDateFormat.format(new Date(calendar.getTimeInMillis()));
        this.f2603g.delete(C0703r.f2646a, "relation_date < ? ", new String[]{str});
        C1786r.m6061b("under" + str + "interaction data deleted", getClass().getSimpleName());
    }
}
