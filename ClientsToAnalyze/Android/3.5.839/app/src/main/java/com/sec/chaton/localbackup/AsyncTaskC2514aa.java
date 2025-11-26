package com.sec.chaton.localbackup;

import android.content.Intent;
import android.os.AsyncTask;
import com.sec.chaton.localbackup.chatlist.ChatListActivity;
import com.sec.chaton.localbackup.database.C2544b;
import com.sec.chaton.util.C4809aa;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.aa */
/* loaded from: classes.dex */
class AsyncTaskC2514aa extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    C2560s f9050a;

    /* renamed from: b */
    final /* synthetic */ SecretKeyView f9051b;

    private AsyncTaskC2514aa(SecretKeyView secretKeyView) {
        this.f9051b = secretKeyView;
        this.f9050a = new C2560s();
    }

    /* synthetic */ AsyncTaskC2514aa(SecretKeyView secretKeyView, C2564w c2564w) {
        this(secretKeyView);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f9051b.m10857c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) throws Throwable {
        try {
            this.f9050a.m10973a(EnumC2563v.FILE_DECRYPT, this.f9051b.f9014i, this.f9051b.f9020o);
            C2544b.m10952b();
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
        if (this.f9051b.f9023r != null) {
            if (this.f9051b.f9017l != null) {
                this.f9051b.f9017l.dismiss();
            }
            if (bool.booleanValue()) {
                Intent intent = new Intent(this.f9051b.getActivity(), (Class<?>) ChatListActivity.class);
                intent.putExtra(BackupListView.f8996a, this.f9051b.f9021p);
                this.f9051b.startActivity(intent);
                this.f9051b.f9026u.mo10835b(false);
            } else {
                C4809aa.m18104a().m18128b("backup_checkkey", "");
                this.f9051b.m10854b();
                this.f9051b.f9008c.setText("");
            }
            this.f9051b.f9024s = null;
        }
    }
}
