package com.sec.chaton.buddy;

import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.task.AbstractQueryTask;

/* renamed from: com.sec.chaton.buddy.d */
/* loaded from: classes.dex */
class C0111d implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f655a;

    C0111d(BuddyFragment buddyFragment) {
        this.f655a = buddyFragment;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        if (this.f655a.getActivity() != null && z && i == 2) {
            Toast.makeText(this.f655a.f453i, this.f655a.getResources().getString(C0062R.string.buddy_profile_block_toast_success, ((BuddyItem) obj).m673b()), 0).show();
            this.f655a.m498i();
        }
    }
}
