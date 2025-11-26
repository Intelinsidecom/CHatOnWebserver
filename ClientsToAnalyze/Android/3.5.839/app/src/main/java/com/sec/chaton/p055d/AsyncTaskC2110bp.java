package com.sec.chaton.p055d;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p065io.entry.inner.GetSnsFriends;
import com.sec.chaton.sns.p113a.C4368e;
import java.util.List;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.bp */
/* loaded from: classes.dex */
class AsyncTaskC2110bp extends AsyncTask<List<GetSnsFriends>, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ C2105bk f7659a;

    private AsyncTaskC2110bp(C2105bk c2105bk) {
        this.f7659a = c2105bk;
    }

    /* synthetic */ AsyncTaskC2110bp(C2105bk c2105bk, C2106bl c2106bl) {
        this(c2105bk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(List<GetSnsFriends>... listArr) throws RemoteException, OperationApplicationException {
        int i = 0;
        List<GetSnsFriends> list = listArr[0];
        ContentResolver contentResolver = this.f7659a.f7643g.getContentResolver();
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (this.f7659a.f7648l == C4368e.f15815a) {
                    this.f7659a.f7641e.add(C2181ag.m9739a(list.get(i2).userid, list.get(i2).username, Long.valueOf(this.f7659a.m9416k().getTime())));
                } else if (this.f7659a.f7648l == C4368e.f15818d) {
                    this.f7659a.f7641e.add(C2181ag.m9741c(list.get(i2).userid, list.get(i2).username, Long.valueOf(this.f7659a.m9416k().getTime())));
                } else if (this.f7659a.f7648l == C4368e.f15820f) {
                    this.f7659a.f7641e.add(C2181ag.m9740b(list.get(i2).userid, list.get(i2).username, Long.valueOf(this.f7659a.m9416k().getTime())));
                }
                i = i2 + 1;
            } else {
                try {
                    contentResolver.applyBatch("com.sec.chaton.provider", this.f7659a.f7641e);
                    return null;
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                    return null;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        super.onPostExecute(r3);
        this.f7659a.m9398a(1301);
    }
}
