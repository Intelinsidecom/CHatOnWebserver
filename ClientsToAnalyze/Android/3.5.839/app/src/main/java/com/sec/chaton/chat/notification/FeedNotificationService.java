package com.sec.chaton.chat.notification;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p065io.entry.FeedNotificationEntry;
import com.sec.chaton.p065io.entry.inner.FeedNotificationUpdateEntry;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class FeedNotificationService extends IntentService {

    /* renamed from: a */
    public static String f6707a = "type";

    /* renamed from: b */
    public static String f6708b = Config.NOTIFICATION_INTENT_APP_DATA;

    /* renamed from: c */
    private final String f6709c;

    /* renamed from: d */
    private final String f6710d;

    /* renamed from: e */
    private FeedNotificationUpdateEntry f6711e;

    public FeedNotificationService() {
        super("FeedNotificationService");
        this.f6709c = getClass().getSimpleName();
        this.f6710d = "updates";
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        String stringExtra = intent.getStringExtra(f6708b);
        if (TextUtils.isEmpty(stringExtra)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("app data is null. return", this.f6709c);
                return;
            }
            return;
        }
        try {
            FeedNotificationEntry feedNotificationEntry = (FeedNotificationEntry) new C2477a(stringExtra).m10709a(FeedNotificationEntry.class);
            if ("updates".equals(feedNotificationEntry.type)) {
                this.f6711e = feedNotificationEntry.contents;
                m8819b();
            }
        } catch (Exception e) {
            C4904y.m18635a(e, this.f6709c);
        }
    }

    /* renamed from: a */
    private ArrayList<C1821j> m8818a() {
        ArrayList<C1821j> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(this.f6711e.buddy_id_1)) {
            arrayList.add(new C1821j(this.f6711e.buddy_id_1, this.f6711e.buddy_name_1, this.f6711e.msisdn));
        }
        if (!TextUtils.isEmpty(this.f6711e.buddy_id_2)) {
            arrayList.add(new C1821j(this.f6711e.buddy_id_2, this.f6711e.buddy_name_2, ""));
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m8819b() throws Throwable {
        Cursor cursorQuery;
        if (TextUtils.isEmpty(this.f6711e.action)) {
            return;
        }
        EnumC1822k enumC1822kM8953a = EnumC1822k.m8953a(this.f6711e.action);
        ArrayList<C1821j> arrayListM8818a = m8818a();
        if (EnumC1822k.UNDEFINED == enumC1822kM8953a) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Undefined action", this.f6709c);
            }
            C1820i.m8948a().m8951a(this.f6711e.service, this.f6711e.action, arrayListM8818a, this.f6711e.timestamp, this.f6711e.deeplink, this.f6711e.defaulttext, this.f6711e.buddy_count);
            return;
        }
        if (EnumC1822k.INVITE == enumC1822kM8953a || EnumC1822k.JOIN == enumC1822kM8953a || EnumC1822k.RECOMMEND == enumC1822kM8953a) {
            try {
                cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2289i.f8196a, null, "buddy_no =? ", new String[]{this.f6711e.buddy_id_1}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            if (Spam.ACTIVITY_REPORT.equals(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_contact_buddy")))) {
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("The buddy has been already on buddy list. Do not notify to user:" + this.f6711e.buddy_id_1, this.f6709c);
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (EnumC1822k.INVITE == enumC1822kM8953a || EnumC1822k.JOIN == enumC1822kM8953a) {
                    new C2128i(null).m9495a();
                    if (!TextUtils.isEmpty(arrayListM8818a.get(0).f6893c)) {
                        String strM9879c = C2192f.m9879c(arrayListM8818a.get(0).f6893c);
                        if (!TextUtils.isEmpty(strM9879c)) {
                            arrayListM8818a.get(0).f6892b = strM9879c;
                        }
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[handleUpdateNotification] name:" + arrayListM8818a.get(0).f6892b, this.f6709c);
                        }
                    }
                } else if (EnumC1822k.RECOMMEND == enumC1822kM8953a) {
                    new C2128i(null).m9530g();
                }
                if (!C2496n.m10757a(CommonApplication.m18732r(), this.f6711e.buddy_id_1).exists()) {
                    try {
                        try {
                            Bitmap bitmap = C2496n.m10758a(CommonApplication.m18732r(), this.f6711e.buddy_id_1, 160).get();
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (ExecutionException e2) {
                        e2.printStackTrace();
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        } else {
            if (EnumC1822k.UPDATE == enumC1822kM8953a) {
                try {
                    C2496n.m10790e(CommonApplication.m18732r(), this.f6711e.buddy_id_1).get();
                    Bitmap bitmap2 = C2496n.m10758a(CommonApplication.m18732r(), this.f6711e.buddy_id_1, 160).get();
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        bitmap2.recycle();
                    }
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                } catch (ExecutionException e4) {
                    e4.printStackTrace();
                }
            }
            for (int i = 0; i < arrayListM8818a.size(); i++) {
                if (!TextUtils.isEmpty(arrayListM8818a.get(i).f6891a)) {
                    String strM9827c = C2190d.m9827c(CommonApplication.m18732r().getContentResolver(), arrayListM8818a.get(i).f6891a);
                    if (!arrayListM8818a.get(i).f6891a.equals(strM9827c)) {
                        arrayListM8818a.get(i).f6892b = strM9827c;
                    }
                    if (C4904y.f17873c) {
                        C4904y.m18641c("[handleUpdateNotification] buddyId:" + arrayListM8818a.get(i).f6891a + ", name:" + arrayListM8818a.get(i).f6892b, this.f6709c);
                    }
                }
            }
        }
        C1820i.m8948a().m8951a(this.f6711e.service, this.f6711e.action, arrayListM8818a, this.f6711e.timestamp, this.f6711e.deeplink, this.f6711e.defaulttext, this.f6711e.buddy_count);
    }
}
