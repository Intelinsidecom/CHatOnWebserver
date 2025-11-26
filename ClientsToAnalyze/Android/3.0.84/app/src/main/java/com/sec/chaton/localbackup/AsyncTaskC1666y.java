package com.sec.chaton.localbackup;

import android.content.Intent;
import android.os.AsyncTask;
import com.sec.chaton.localbackup.chatlist.ChatListActivity;
import com.sec.chaton.localbackup.database.C1642b;
import com.sec.chaton.util.C3159aa;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.y */
/* loaded from: classes.dex */
class AsyncTaskC1666y extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    C1658q f6151a;

    /* renamed from: b */
    final /* synthetic */ SecretKeyView f6152b;

    private AsyncTaskC1666y(SecretKeyView secretKeyView) {
        this.f6152b = secretKeyView;
        this.f6151a = new C1658q();
    }

    /* synthetic */ AsyncTaskC1666y(SecretKeyView secretKeyView, C1662u c1662u) {
        this(secretKeyView);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f6152b.m6829c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        try {
            this.f6151a.m6942a(EnumC1661t.FILE_DECRYPT, this.f6152b.f5972i, this.f6152b.f5978o);
            C1642b.m6920b();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (this.f6152b.f5981r != null) {
            if (this.f6152b.f5975l != null) {
                this.f6152b.f5975l.dismiss();
            }
            if (bool.booleanValue()) {
                Intent intent = new Intent(this.f6152b.getActivity(), (Class<?>) ChatListActivity.class);
                intent.putExtra(BackupListView.f5955a, this.f6152b.f5979p);
                this.f6152b.startActivity(intent);
                this.f6152b.f5984u.mo6807a(false);
            } else {
                C3159aa.m10962a().m10986b("backup_checkkey", "");
                this.f6152b.m6826b();
                this.f6152b.f5966c.setText("");
            }
            this.f6152b.f5982s = null;
        }
    }
}
