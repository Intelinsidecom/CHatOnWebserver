package com.sec.chaton.database.task;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.database.helper.BuddyGroupDatabaseHelper;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class BuddyGroupDeleteTask extends AbstractQueryTask {

    /* renamed from: a */
    private long[] f1791a;

    public BuddyGroupDeleteTask(AbstractQueryTask.OnQueryTaskResult onQueryTaskResult, int i) {
        super(onQueryTaskResult, new Handler(Looper.getMainLooper()));
        this.f1791a = new long[]{i};
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask
    /* renamed from: a */
    public Object mo2320a() {
        for (long j : this.f1791a) {
            BuddyGroupDatabaseHelper.m2227a(GlobalApplication.m2387e().getContentResolver(), String.valueOf(j));
            BuddyGroupDatabaseHelper.m2229b(GlobalApplication.m2387e().getContentResolver(), String.valueOf(j));
        }
        return this.f1791a;
    }
}
