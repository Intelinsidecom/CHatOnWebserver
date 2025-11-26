package com.sec.chaton.buddy;

import android.database.Cursor;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.database.task.BuddyBlockTask;

/* renamed from: com.sec.chaton.buddy.e */
/* loaded from: classes.dex */
class C0112e implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f656a;

    C0112e(BuddyFragment buddyFragment) {
        this.f656a = buddyFragment;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        if (!z) {
            if (this.f656a.f435Z != null) {
                this.f656a.f435Z.dismiss();
                return;
            }
            return;
        }
        if (i == 1) {
            Cursor cursor = (Cursor) obj;
            if (cursor.getCount() <= 0) {
                NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyBlockTask(this.f656a.f449e, this.f656a.f428S, 2, false));
                return;
            } else {
                cursor.close();
                NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyBlockTask(this.f656a.f449e, this.f656a.f428S, 2, true));
                return;
            }
        }
        if (i != 2) {
            if (i == 4) {
            }
        } else if (this.f656a.getActivity() != null) {
            if (this.f656a.f435Z != null) {
                this.f656a.f435Z.dismiss();
            }
            Toast.makeText(this.f656a.f453i, this.f656a.getResources().getString(C0062R.string.buddy_profile_block_toast_success, this.f656a.f428S.m673b()), 0).show();
            this.f656a.f431V.m527a();
        }
    }
}
