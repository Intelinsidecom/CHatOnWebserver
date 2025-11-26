package com.sec.chaton.specialbuddy.p117a;

import android.database.Cursor;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2704l;
import com.sec.chaton.p055d.C2140u;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2213aa;
import com.sec.chaton.p057e.EnumC2215ac;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: LiveChatFeedbackTask.java */
/* renamed from: com.sec.chaton.specialbuddy.a.d */
/* loaded from: classes.dex */
public class AsyncTaskC4528d extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    static final String f16391a = AsyncTaskC4528d.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws ExecutionException, InterruptedException {
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2306z.m10228g(), null, null, null, null);
        List<C4526b> listM17222a = m17222a(cursorQuery);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (listM17222a == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("livechat, nothing to report", f16391a);
            }
        } else {
            int size = listM17222a.size();
            if (C4904y.f17872b) {
                C4904y.m18639b("livechat, report, total count : " + size, f16391a);
            }
            for (int i = 0; i < size; i += 100) {
                int i2 = i + 100;
                if (i2 > size) {
                    i2 = size;
                }
                try {
                    C2140u.m9588a(null, listM17222a.subList(i, i2)).get();
                } catch (InterruptedException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f16391a);
                    }
                } catch (CancellationException e2) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, f16391a);
                    }
                } catch (ExecutionException e3) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e3, f16391a);
                    }
                }
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("livechat, total elapsed in : " + c2704lM11323b.m11325d(), f16391a);
            }
        }
        return null;
    }

    /* renamed from: a */
    private List<C4526b> m17222a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("message_sever_id");
        int columnIndex2 = cursor.getColumnIndex("message_sender");
        int columnIndex3 = cursor.getColumnIndex("message_time");
        int columnIndex4 = cursor.getColumnIndex("message_is_read");
        int columnIndex5 = cursor.getColumnIndex("message_is_ack");
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            Long lValueOf = Long.valueOf(cursor.getLong(columnIndex));
            String string = cursor.getString(columnIndex2);
            long j = cursor.getLong(columnIndex3);
            int i = cursor.getInt(columnIndex5);
            int i2 = cursor.getInt(columnIndex4);
            if (i == EnumC2213aa.ACK_NOT_YET.m10069a()) {
                arrayList.add(new C4525a(lValueOf.longValue(), string, j));
            }
            if (i2 == EnumC2215ac.READ_LOCAL.m10080a()) {
                arrayList.add(new C4530f(lValueOf.longValue(), string));
            }
        }
        return arrayList;
    }
}
