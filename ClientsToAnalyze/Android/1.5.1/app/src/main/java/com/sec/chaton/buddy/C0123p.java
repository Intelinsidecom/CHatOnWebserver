package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.task.AbstractQueryTask;

/* renamed from: com.sec.chaton.buddy.p */
/* loaded from: classes.dex */
class C0123p implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f704a;

    C0123p(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f704a = buddyGroupEditActivity;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        if (z) {
            if (i == 1) {
                this.f704a.setResult(-1);
                this.f704a.finish();
                return;
            }
            if (i == 3) {
                if (((Integer) obj).intValue() != 0) {
                    Toast.makeText(this.f704a, this.f704a.getResources().getString(C0062R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_name", this.f704a.f500M);
                this.f704a.f498K.startUpdate(1, this.f704a.f500M, ChatONContract.GroupTable.f1716a, contentValues, "_id = ? ", new String[]{String.valueOf(this.f704a.f509g.m663a())});
                return;
            }
            if (i == 2) {
                this.f704a.getSupportLoaderManager().mo37a(this.f704a.f499L, null, this.f704a.f513k);
                this.f704a.m567f();
            } else if (i == 4) {
                this.f704a.finish();
            }
        }
    }
}
