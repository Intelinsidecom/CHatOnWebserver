package com.sec.chaton.database.task;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.global.GlobalApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyBlockTask extends AbstractQueryTask {

    /* renamed from: a */
    private BuddyItem f1783a;

    /* renamed from: b */
    private boolean f1784b;

    /* renamed from: c */
    private int f1785c;

    public BuddyBlockTask(AbstractQueryTask.OnQueryTaskResult onQueryTaskResult, BuddyItem buddyItem, int i, boolean z) {
        super(onQueryTaskResult, new Handler(Looper.getMainLooper()));
        this.f1783a = buddyItem;
        this.f1785c = i;
        this.f1784b = z;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask
    /* renamed from: a */
    public Object mo2320a() {
        if (this.f1785c == 1) {
            Cursor cursorM2219a = BuddyDatabaseHelper.m2219a(GlobalApplication.m2387e().getContentResolver(), this.f1783a);
            if (cursorM2219a == null) {
                return true;
            }
            return cursorM2219a;
        }
        if (this.f1785c == 2) {
            ContentResolver contentResolver = GlobalApplication.m2387e().getContentResolver();
            BuddyDatabaseHelper.m2221a(contentResolver, this.f1783a, this.f1784b);
            ArrayList arrayListM2318e = ParticipantDatabaseHelper.m2318e(contentResolver, this.f1783a.m668a());
            if (arrayListM2318e != null && arrayListM2318e.size() > 0) {
                Iterator it = arrayListM2318e.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    ParticipantDatabaseHelper.m2316d(contentResolver, str, this.f1783a.m668a());
                    InBoxDatabaseHelper.m2260c(contentResolver, str);
                    MessageDatabaseHelper.m2297b(contentResolver, str, String.format("%s,%s,%s", "LEAVE", this.f1783a.m668a(), ChatUtil.m795a(this.f1783a.m673b())));
                }
            }
        }
        return true;
    }
}
