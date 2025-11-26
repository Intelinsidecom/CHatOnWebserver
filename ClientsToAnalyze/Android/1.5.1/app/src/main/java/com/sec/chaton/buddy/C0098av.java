package com.sec.chaton.buddy;

import android.content.Intent;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.task.AbstractQueryTask;

/* renamed from: com.sec.chaton.buddy.av */
/* loaded from: classes.dex */
class C0098av implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f640a;

    C0098av(BuddyGroupActivity buddyGroupActivity) {
        this.f640a = buddyGroupActivity;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        if (z && i == 3) {
            if (((Integer) obj).intValue() != 0) {
                Toast.makeText(this.f640a, this.f640a.getResources().getString(C0062R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
                return;
            }
            Intent intent = new Intent(this.f640a.f485f, (Class<?>) BuddyActivity2.class);
            intent.putExtra("ACTIVITY_PURPOSE", 10);
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            intent.putExtra("ACTIVITY_PURPOSE_ARG2", this.f640a.f482c.getText().toString());
            this.f640a.startActivity(intent);
            this.f640a.finish();
        }
    }
}
