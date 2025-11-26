package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyItem;

/* renamed from: com.sec.chaton.userprofile.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC0594r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3592a;

    /* renamed from: b */
    final /* synthetic */ C0546a f3593b;

    ViewOnClickListenerC0594r(C0546a c0546a, int i) {
        this.f3593b = c0546a;
        this.f3592a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f3593b.getContext());
        builder.setIcon(C0062R.drawable.ic_dialog_menu_generic);
        builder.setTitle(((BuddyItem) this.f3593b.getItem(this.f3592a)).m673b());
        builder.setMessage(String.format(this.f3593b.getContext().getResources().getString(C0062R.string.settings_hide_interaction_with), ((BuddyItem) this.f3593b.getItem(this.f3592a)).m673b()));
        builder.setPositiveButton(C0062R.string.done, new DialogInterfaceOnClickListenerC0563aq(this));
        builder.setNeutralButton(C0062R.string.cancel, new DialogInterfaceOnClickListenerC0564ar(this));
        builder.show();
    }
}
