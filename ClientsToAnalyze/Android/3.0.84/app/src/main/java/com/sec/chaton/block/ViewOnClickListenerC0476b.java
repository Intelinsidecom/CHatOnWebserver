package com.sec.chaton.block;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.BuddyDialog;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0476b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0472a f1587a;

    ViewOnClickListenerC0476b(C0472a c0472a) {
        this.f1587a = c0472a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        Intent intent = new Intent(this.f1587a.getContext(), (Class<?>) BuddyDialog.class);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f1587a.f1570a.get(iIntValue).f1584a);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f1587a.f1570a.get(iIntValue).f1585b);
        this.f1587a.getContext().startActivity(intent);
    }
}
