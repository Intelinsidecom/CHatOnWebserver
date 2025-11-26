package com.sec.chaton.p025d.p027b;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0658k;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: RelationUpdateTask.java */
/* renamed from: com.sec.chaton.d.b.c */
/* loaded from: classes.dex */
public class C0640c extends AbstractC0647j {

    /* renamed from: e */
    private static boolean f2231e = false;

    /* renamed from: f */
    private static ArrayList f2232f = new ArrayList();

    /* renamed from: a */
    String f2233a;

    /* renamed from: b */
    Cursor f2234b;

    /* renamed from: c */
    Cursor f2235c;

    /* renamed from: g */
    private ContentResolver f2236g;

    /* renamed from: h */
    private ArrayList f2237h;

    /* renamed from: i */
    private ArrayList f2238i;

    /* renamed from: a */
    public static void m2962a(InterfaceC0642e interfaceC0642e) {
        f2232f.add(interfaceC0642e);
    }

    /* renamed from: b */
    public static void m2965b(InterfaceC0642e interfaceC0642e) {
        if (f2232f.contains(interfaceC0642e)) {
            f2232f.remove(interfaceC0642e);
        }
    }

    /* renamed from: b */
    public static boolean m2966b() {
        return f2231e;
    }

    /* renamed from: d */
    private static void m2967d() {
        Iterator it = f2232f.iterator();
        while (it.hasNext()) {
            ((InterfaceC0642e) it.next()).mo2971a();
        }
    }

    public C0640c(InterfaceC0641d interfaceC0641d, String str, ArrayList arrayList) {
        super(interfaceC0641d);
        this.f2236g = GlobalApplication.m3100a().getContentResolver();
        this.f2233a = str;
        this.f2237h = new ArrayList();
        this.f2238i = new ArrayList();
    }

    @Override // com.sec.chaton.p025d.p027b.AbstractC0647j
    /* renamed from: a */
    public Object mo2950a() throws RemoteException, OperationApplicationException {
        try {
            m2970c();
            f2231e = true;
            this.f2236g.insert(C0658k.m2992b(), null);
            List listM2961a = m2961a(this.f2233a);
            for (int i = 0; i < listM2961a.size(); i++) {
                this.f2237h.clear();
                this.f2238i.clear();
                String str = (String) listM2961a.get(i);
                if (i > 6) {
                    break;
                }
                String str2 = (String) listM2961a.get(i + 1);
                C1341p.m4658b("LastWeekDates:---- day_1 =" + str2 + " day_2=" + str, "RelationUpdateTask");
                this.f2234b = this.f2236g.query(C0658k.m2990a(), null, "relation_date = ? and buddy_relation_hide = 'N' ", new String[]{str2}, "relation_point DESC, relation_last_msg_time LIMIT 30");
                m2968a(this.f2234b);
                this.f2235c = this.f2236g.query(C0658k.m2990a(), null, "relation_date = ? and buddy_relation_hide = 'N' ", new String[]{str}, "relation_point DESC, relation_last_msg_time  LIMIT 30");
                m2969b(this.f2235c);
                m2964a(this.f2237h, this.f2238i);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.f2237h.size(); i2++) {
                    ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0658k.f2285a);
                    builderNewUpdate.withValue("relation_rank", Integer.valueOf(((C0363a) this.f2237h.get(i2)).m2330p()));
                    builderNewUpdate.withValue("relation_icon", Integer.valueOf(((C0363a) this.f2237h.get(i2)).m2328n()));
                    builderNewUpdate.withValue("relation_increase", Integer.valueOf(((C0363a) this.f2237h.get(i2)).m2329o()));
                    builderNewUpdate.withSelection("relation_buddy_id = ? AND relation_date = ? ", new String[]{((C0363a) this.f2237h.get(i2)).m2308a(), str2});
                    arrayList.add(builderNewUpdate.build());
                }
                try {
                    this.f2236g.applyBatch("com.sec.chaton.provider", arrayList);
                } catch (Exception e) {
                    C1341p.m4653a(e, getClass().getSimpleName());
                }
            }
            C1323bs.m4579a("relation_update_day", this.f2233a);
            f2231e = false;
            m2967d();
        } catch (Exception e2) {
        }
        return null;
    }

    /* renamed from: a */
    private List m2961a(String str) {
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
    public void m2968a(Cursor cursor) {
        this.f2237h.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f2237h.add(new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
        }
        cursor.close();
        m2963a(this.f2237h);
    }

    /* renamed from: a */
    private static void m2963a(ArrayList arrayList) {
        int i = 0;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i + 1;
            ((C0363a) arrayList.get(i2)).m2317c(i3);
            ((C0363a) arrayList.get(i2)).m2309a(m2960a(((C0363a) arrayList.get(i2)).m2325k() + ((C0363a) arrayList.get(i2)).m2326l(), i3, arrayList.size()));
            i2++;
            i = i3;
        }
    }

    /* renamed from: a */
    private static int m2960a(int i, int i2, int i3) {
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
    public void m2969b(Cursor cursor) {
        C1341p.m4658b("B_relationCnt=" + cursor.getCount(), "RelationUpdateTask");
        this.f2238i.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f2238i.add(new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
        }
        cursor.close();
    }

    /* renamed from: a */
    private static void m2964a(ArrayList arrayList, ArrayList arrayList2) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (((C0363a) arrayList.get(i)).m2308a().equals(((C0363a) arrayList2.get(i2)).m2308a())) {
                    ((C0363a) arrayList.get(i)).m2315b(((C0363a) arrayList2.get(i2)).m2330p() - ((C0363a) arrayList.get(i)).m2330p());
                }
            }
        }
    }

    /* renamed from: c */
    public void m2970c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -8);
        String str = simpleDateFormat.format(new Date(calendar.getTimeInMillis()));
        this.f2236g.delete(C0658k.f2285a, "relation_date < ? ", new String[]{str});
        C1341p.m4658b("under" + str + "interaction data deleted", getClass().getSimpleName());
    }
}
