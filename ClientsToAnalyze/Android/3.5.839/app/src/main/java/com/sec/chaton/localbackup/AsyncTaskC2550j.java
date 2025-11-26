package com.sec.chaton.localbackup;

import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.j */
/* loaded from: classes.dex */
class AsyncTaskC2550j extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    C2560s f9156a;

    /* renamed from: b */
    final /* synthetic */ ActivityLocalBackup f9157b;

    private AsyncTaskC2550j(ActivityLocalBackup activityLocalBackup) {
        this.f9157b = activityLocalBackup;
        this.f9156a = new C2560s();
    }

    /* synthetic */ AsyncTaskC2550j(ActivityLocalBackup activityLocalBackup, C2517c c2517c) {
        this(activityLocalBackup);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f9157b.m10827e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) throws Throwable {
        try {
            this.f9156a.m10973a(EnumC2563v.FILE_ENCRYPT, this.f9156a.m10969a(EnumC2562u.DECRYPT, (String) null), this.f9156a.m10971a("local-backup.db.crypt"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            C4904y.m18635a(e, ActivityLocalBackup.f8983a);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (this.f9157b.f8990h) {
            if (this.f9157b.f8989g != null) {
                this.f9157b.f8989g.dismiss();
            }
            if (!bool.booleanValue()) {
                C5179v.m19810a(this.f9157b.f8985c, R.string.backup_failed, 1).show();
            } else {
                C4904y.m18639b("[File encryption] complete " + this, getClass().getSimpleName());
                this.f9157b.m10833a();
                if (this.f9157b.f8991i) {
                    C5179v.m19810a(this.f9157b.f8985c, R.string.auto_backup_enabled, 1).show();
                    this.f9157b.f8991i = false;
                } else {
                    C5179v.m19810a(this.f9157b.f8985c, R.string.backup_completed, 1).show();
                }
            }
            this.f9157b.f8994l = null;
        }
    }
}
