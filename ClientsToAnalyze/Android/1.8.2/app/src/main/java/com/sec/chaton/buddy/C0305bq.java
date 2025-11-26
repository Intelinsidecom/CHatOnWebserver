package com.sec.chaton.buddy;

import android.content.Intent;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;

/* compiled from: BuddyGroupActivity.java */
/* renamed from: com.sec.chaton.buddy.bq */
/* loaded from: classes.dex */
class C0305bq implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupActivity f1416a;

    C0305bq(BuddyGroupActivity buddyGroupActivity) {
        this.f1416a = buddyGroupActivity;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (z && i == 3) {
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0) {
                Intent intent = new Intent(this.f1416a.f1030i, (Class<?>) BuddyActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 10);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", this.f1416a.f1027c.getText().toString());
                this.f1416a.startActivity(intent);
                this.f1416a.finish();
                return;
            }
            Toast.makeText(this.f1416a, this.f1416a.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
        }
    }
}
