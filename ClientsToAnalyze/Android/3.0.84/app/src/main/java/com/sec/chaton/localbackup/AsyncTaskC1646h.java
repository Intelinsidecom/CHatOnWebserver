package com.sec.chaton.localbackup;

import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.h */
/* loaded from: classes.dex */
class AsyncTaskC1646h extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    C1658q f6108a;

    /* renamed from: b */
    final /* synthetic */ ActivityLocalBackup f6109b;

    private AsyncTaskC1646h(ActivityLocalBackup activityLocalBackup) {
        this.f6109b = activityLocalBackup;
        this.f6108a = new C1658q();
    }

    /* synthetic */ AsyncTaskC1646h(ActivityLocalBackup activityLocalBackup, C1615c c1615c) {
        this(activityLocalBackup);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f6109b.m6799e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        try {
            this.f6108a.m6942a(EnumC1661t.FILE_ENCRYPT, this.f6108a.m6938a(EnumC1660s.DECRYPT, (String) null), this.f6108a.m6940a("local-backup.db.crypt"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            C3250y.m11443a(e, ActivityLocalBackup.f5943a);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (this.f6109b.f5950h) {
            if (this.f6109b.f5949g != null) {
                this.f6109b.f5949g.dismiss();
            }
            if (!bool.booleanValue()) {
                C3641ai.m13210a(this.f6109b.f5945c, R.string.backup_failed, 1).show();
            } else {
                C3250y.m11450b("[File encryption] complete " + this, getClass().getSimpleName());
                this.f6109b.m6805a();
                if (this.f6109b.f5951i) {
                    C3641ai.m13210a(this.f6109b.f5945c, R.string.auto_backup_enabled, 1).show();
                    this.f6109b.f5951i = false;
                } else {
                    C3641ai.m13210a(this.f6109b.f5945c, R.string.backup_completed, 1).show();
                }
            }
            this.f6109b.f5953k = null;
        }
    }
}
