package com.sec.chaton.database.task;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RelationUpdateTask extends AbstractQueryTask {

    /* renamed from: e */
    private static boolean f1808e = false;

    /* renamed from: f */
    private static ArrayList f1809f = new ArrayList();

    /* renamed from: a */
    String f1810a;

    /* renamed from: b */
    Cursor f1811b;

    /* renamed from: c */
    Cursor f1812c;

    /* renamed from: g */
    private ContentResolver f1813g;

    /* renamed from: h */
    private ArrayList f1814h;

    /* renamed from: i */
    private ArrayList f1815i;

    public interface RelationUpdateStatus {
        /* renamed from: a */
        void mo2338a();
    }

    public RelationUpdateTask(AbstractQueryTask.OnQueryTaskResult onQueryTaskResult, String str, ArrayList arrayList) {
        super(onQueryTaskResult);
        this.f1813g = GlobalApplication.m2387e().getContentResolver();
        this.f1810a = str;
        this.f1814h = new ArrayList();
        this.f1815i = new ArrayList();
    }

    /* renamed from: a */
    private static int m2328a(int i, int i2, int i3) {
        int i4 = 5;
        if (i == 0) {
            i4 = 0;
        } else if (i2 > 5) {
            i4 = (i2 / i3) / 100 > 60 ? 1 : (i2 / i3) / 100 > 70 ? 2 : (i2 / i3) / 100 > 80 ? 3 : 4;
        }
        ChatONLogWriter.m3506b("CheckRelationLevel::relatioin_sum=" + i + "CheckRelationLevel::relatioin_top_which=" + i2 + "CheckRelationLevel::relatioin_level=" + i4 + "CheckRelationLevel::relatioin_level_size=" + i3, null);
        return i4;
    }

    /* renamed from: a */
    private List m2329a(String str) {
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
    public static void m2330a(RelationUpdateStatus relationUpdateStatus) {
        f1809f.add(relationUpdateStatus);
    }

    /* renamed from: a */
    private static void m2331a(ArrayList arrayList) {
        int i = 0;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i + 1;
            ((BuddyItem) arrayList.get(i2)).m677c(i3);
            ((BuddyItem) arrayList.get(i2)).m669a(m2328a(((BuddyItem) arrayList.get(i2)).m686k() + ((BuddyItem) arrayList.get(i2)).m687l(), i3, arrayList.size()));
            i2++;
            i = i3;
        }
    }

    /* renamed from: a */
    private static void m2332a(ArrayList arrayList, ArrayList arrayList2) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (((BuddyItem) arrayList.get(i)).m668a().equals(((BuddyItem) arrayList2.get(i2)).m668a())) {
                    ((BuddyItem) arrayList.get(i)).m674b(((BuddyItem) arrayList2.get(i2)).m691p() - ((BuddyItem) arrayList.get(i)).m691p());
                }
            }
        }
    }

    /* renamed from: b */
    public static void m2333b(RelationUpdateStatus relationUpdateStatus) {
        if (f1809f.contains(relationUpdateStatus)) {
            f1809f.remove(relationUpdateStatus);
        }
    }

    /* renamed from: b */
    public static boolean m2334b() {
        return f1808e;
    }

    /* renamed from: c */
    private static void m2335c() {
        Iterator it = f1809f.iterator();
        while (it.hasNext()) {
            ((RelationUpdateStatus) it.next()).mo2338a();
        }
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask
    /* renamed from: a */
    public Object mo2320a() throws RemoteException, OperationApplicationException {
        try {
            f1808e = true;
            ChatONLogWriter.m3506b("message table query once a day start...", getClass().getSimpleName());
            this.f1813g.insert(ChatONContract.RelationTable.m2203b(), null);
            ChatONLogWriter.m3506b("message table query once a day end.", getClass().getSimpleName());
            List listM2329a = m2329a(this.f1810a);
            for (int i = 0; i < listM2329a.size(); i++) {
                this.f1814h.clear();
                this.f1815i.clear();
                String str = (String) listM2329a.get(i);
                if (i > 6) {
                    break;
                }
                String str2 = (String) listM2329a.get(i + 1);
                ChatONLogWriter.m3506b("LastWeekDates:---- day_1 =" + str2 + " day_2=" + str, "RelationUpdateTask");
                this.f1811b = this.f1813g.query(ChatONContract.RelationTable.m2201a(), null, "relation_date = ? and buddy_relation_hide = 'N' ", new String[]{str2}, "relation_point DESC, relation_last_msg_time LIMIT 30");
                m2336a(this.f1811b);
                this.f1812c = this.f1813g.query(ChatONContract.RelationTable.m2201a(), null, "relation_date = ? and buddy_relation_hide = 'N' ", new String[]{str}, "relation_point DESC, relation_last_msg_time  LIMIT 30");
                m2337b(this.f1812c);
                m2332a(this.f1814h, this.f1815i);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.f1814h.size(); i2++) {
                    ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(ChatONContract.RelationTable.f1742a);
                    builderNewUpdate.withValue("relation_rank", Integer.valueOf(((BuddyItem) this.f1814h.get(i2)).m691p()));
                    builderNewUpdate.withValue("relation_icon", Integer.valueOf(((BuddyItem) this.f1814h.get(i2)).m689n()));
                    builderNewUpdate.withValue("relation_increase", Integer.valueOf(((BuddyItem) this.f1814h.get(i2)).m690o()));
                    builderNewUpdate.withSelection("relation_buddy_id = ? AND relation_date = ? ", new String[]{((BuddyItem) this.f1814h.get(i2)).m668a(), str2});
                    arrayList.add(builderNewUpdate.build());
                }
                try {
                    this.f1813g.applyBatch("com.sec.chaton.provider", arrayList);
                } catch (Exception e) {
                    ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                }
            }
            ChatONPref.m3523a("relation_update_day", this.f1810a);
            f1808e = false;
            m2335c();
        } catch (Exception e2) {
            ChatONLogWriter.m3506b("relation table update Failed", getClass().getSimpleName());
        }
        return null;
    }

    /* renamed from: a */
    public void m2336a(Cursor cursor) {
        ChatONLogWriter.m3506b("Y_relationCnt=" + cursor.getCount(), "RelationUpdateTask");
        this.f1814h.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f1814h.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
            ChatONLogWriter.m3506b("Y_BuddyName=" + cursor.getString(cursor.getColumnIndex("buddy_name")) + "Y_BuddyPoint=" + cursor.getInt(cursor.getColumnIndex("relation_point")), "RelationUpdateTask");
        }
        cursor.close();
        m2331a(this.f1814h);
        ChatONLogWriter.m3506b("Interaction summary :\n", null);
        for (int i = 0; i < this.f1814h.size(); i++) {
            ChatONLogWriter.m3506b(" rank=" + ((BuddyItem) this.f1814h.get(i)).m691p() + "name=" + ((BuddyItem) this.f1814h.get(i)).m673b() + " ::point=" + ((BuddyItem) this.f1814h.get(i)).m688m() + " ::no=" + ((BuddyItem) this.f1814h.get(i)).m668a(), null);
        }
    }

    /* renamed from: b */
    public void m2337b(Cursor cursor) {
        ChatONLogWriter.m3506b("B_relationCnt=" + cursor.getCount(), "RelationUpdateTask");
        this.f1815i.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f1815i.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
            ChatONLogWriter.m3506b("B_BuddyName=" + cursor.getString(cursor.getColumnIndex("buddy_name")) + "B_BuddyPoint=" + cursor.getInt(cursor.getColumnIndex("relation_point")), "RelationUpdateTask");
        }
        cursor.close();
    }
}
