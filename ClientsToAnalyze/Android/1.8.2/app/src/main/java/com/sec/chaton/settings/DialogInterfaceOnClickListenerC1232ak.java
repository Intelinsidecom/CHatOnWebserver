package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.sec.chaton.R;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1232ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1231aj f4773a;

    DialogInterfaceOnClickListenerC1232ak(ViewOnClickListenerC1231aj viewOnClickListenerC1231aj) {
        this.f4773a = viewOnClickListenerC1231aj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        RunnableC1228ag runnableC1228ag = null;
        if (this.f4773a.f4772b.f4535q != null) {
            this.f4773a.f4772b.f4536r = ProgressDialogC1806j.m6141a(this.f4773a.f4772b.f4535q, null, this.f4773a.f4772b.getResources().getString(R.string.settings_deleting_account), true);
            C1781m.m6023b(false);
            try {
                SharedPreferences.Editor editorEdit = this.f4773a.f4772b.f4535q.getSharedPreferences("password_lock", 0).edit();
                editorEdit.clear();
                editorEdit.commit();
            } catch (Exception e) {
                C1786r.m6054a("Unable to clear password preference", getClass().getSimpleName());
            }
            new AsyncTaskC1233al(this.f4773a.f4772b, runnableC1228ag).execute(new Void[0]);
        }
    }
}
