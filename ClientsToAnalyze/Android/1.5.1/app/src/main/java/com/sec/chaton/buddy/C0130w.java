package com.sec.chaton.buddy;

import android.database.Cursor;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.database.task.BuddyBlockTask;

/* renamed from: com.sec.chaton.buddy.w */
/* loaded from: classes.dex */
class C0130w implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f716a;

    C0130w(BuddyProfileActivity buddyProfileActivity) {
        this.f716a = buddyProfileActivity;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        if (!z) {
            if (this.f716a.f561H != null) {
                this.f716a.f561H.dismiss();
            }
            if (i == 2) {
                this.f716a.f558E.setEnabled(true);
                this.f716a.f556C.setEnabled(true);
                return;
            }
            return;
        }
        if (i == 1) {
            Cursor cursor = (Cursor) obj;
            if (cursor.getCount() <= 0) {
                NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyBlockTask(this.f716a.f580e, this.f716a.f585j, 2, false));
                return;
            } else {
                cursor.close();
                NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyBlockTask(this.f716a.f580e, this.f716a.f585j, 2, true));
                return;
            }
        }
        if (i == 2) {
            if (this.f716a.f561H != null) {
                this.f716a.f561H.dismiss();
            }
            Toast.makeText(this.f716a.f584i, this.f716a.getResources().getString(C0062R.string.buddy_profile_block_toast_success, this.f716a.f585j.m673b()), 0).show();
            if (this.f716a.f558E != null) {
                this.f716a.f558E.setEnabled(true);
            }
            this.f716a.f556C.setEnabled(true);
            this.f716a.setResult(-1);
            this.f716a.finish();
        }
    }
}
