package com.sec.chaton.hide;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.BuddyDialog;

/* compiled from: HideBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC2367b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2366a f8442a;

    ViewOnClickListenerC2367b(C2366a c2366a) {
        this.f8442a = c2366a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        Intent intent = new Intent(this.f8442a.getContext(), (Class<?>) BuddyDialog.class);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f8442a.f8432a.get(iIntValue).f3484a);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f8442a.f8432a.get(iIntValue).f3485b);
        this.f8442a.getContext().startActivity(intent);
    }
}
