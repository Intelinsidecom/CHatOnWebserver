package com.sec.chaton.database.task;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.database.helper.BuddyGroupDatabaseHelper;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.global.GlobalApplication;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyGroupRemoveBuddyTask extends AbstractQueryTask {

    /* renamed from: a */
    private int f1792a;

    /* renamed from: b */
    private ArrayList f1793b;

    public BuddyGroupRemoveBuddyTask(AbstractQueryTask.OnQueryTaskResult onQueryTaskResult, int i, ArrayList arrayList) {
        super(onQueryTaskResult, new Handler(Looper.getMainLooper()));
        this.f1792a = i;
        this.f1793b = arrayList;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask
    /* renamed from: a */
    public Object mo2320a() {
        BuddyGroupDatabaseHelper.m2228b(GlobalApplication.m2387e().getContentResolver(), this.f1792a, this.f1793b);
        return true;
    }
}
