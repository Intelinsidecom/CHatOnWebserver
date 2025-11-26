package com.sec.chaton.hide;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.BuddyDialog;

/* compiled from: HideBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1511b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1510a f5567a;

    ViewOnClickListenerC1511b(C1510a c1510a) {
        this.f5567a = c1510a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        Intent intent = new Intent(this.f5567a.getContext(), (Class<?>) BuddyDialog.class);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f5567a.f5557a.get(iIntValue).f5572a);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f5567a.f5557a.get(iIntValue).f5573b);
        this.f5567a.getContext().startActivity(intent);
    }
}
