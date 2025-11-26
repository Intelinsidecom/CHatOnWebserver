package com.sec.chaton.msgbox;

import android.os.AsyncTask;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.p057e.p058a.C2198l;
import java.util.ArrayList;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.as */
/* loaded from: classes.dex */
class AsyncTaskC2627as extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9476a;

    AsyncTaskC2627as(MsgboxFragment msgboxFragment) {
        this.f9476a = msgboxFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr[0]);
        C2198l.m9932a(this.f9476a.getActivity().getContentResolver(), (ArrayList<String>) arrayList);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        C1813b.m8906b().m8934b(C1813b.f6835d);
        super.onPostExecute(r3);
    }
}
