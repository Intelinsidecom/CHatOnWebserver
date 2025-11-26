package com.sec.chaton.database.task;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.database.helper.BuddyGroupDatabaseHelper;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.global.GlobalApplication;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyGroupAddTask extends AbstractQueryTask {

    /* renamed from: a */
    private String f1788a;

    /* renamed from: b */
    private ArrayList f1789b;

    /* renamed from: c */
    private int f1790c;

    public BuddyGroupAddTask(AbstractQueryTask.OnQueryTaskResult onQueryTaskResult, String str, int i) {
        super(onQueryTaskResult, new Handler(Looper.getMainLooper()));
        this.f1788a = str;
        this.f1790c = i;
    }

    public BuddyGroupAddTask(AbstractQueryTask.OnQueryTaskResult onQueryTaskResult, String[] strArr, int i) {
        super(onQueryTaskResult, new Handler(Looper.getMainLooper()));
        this.f1790c = i;
        this.f1788a = strArr[0];
        this.f1789b = new ArrayList();
        for (int i2 = 1; i2 < strArr.length; i2++) {
            this.f1789b.add(strArr[i2]);
        }
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask
    /* renamed from: a */
    public Object mo2320a() {
        ContentResolver contentResolver = GlobalApplication.m2387e().getContentResolver();
        if (this.f1790c != 2) {
            return Integer.valueOf(BuddyGroupDatabaseHelper.m2232e(contentResolver, this.f1788a));
        }
        BuddyGroupDatabaseHelper.m2230c(contentResolver, this.f1788a);
        int iM2231d = BuddyGroupDatabaseHelper.m2231d(contentResolver, this.f1788a);
        BuddyGroupDatabaseHelper.m2226a(contentResolver, iM2231d, this.f1789b);
        return Integer.valueOf(iM2231d);
    }
}
