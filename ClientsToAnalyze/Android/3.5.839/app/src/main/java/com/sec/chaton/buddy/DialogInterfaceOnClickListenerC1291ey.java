package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ey */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1291ey implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4825a;

    /* renamed from: b */
    final /* synthetic */ Uri f4826b;

    /* renamed from: c */
    final /* synthetic */ BuddyInfoFragment f4827c;

    DialogInterfaceOnClickListenerC1291ey(BuddyInfoFragment buddyInfoFragment, String str, Uri uri) {
        this.f4827c = buddyInfoFragment;
        this.f4825a = str;
        this.f4826b = uri;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.f4825a);
        bundle.putString("name", this.f4827c.f3865k.m7051b());
        if (this.f4827c.f3865k.m7055d() != null) {
            bundle.putString("email", this.f4827c.f3865k.m7055d());
        }
        Intent intent = new Intent("android.intent.action.INSERT", this.f4826b);
        intent.putExtras(bundle);
        intent.putExtra("return-data", true);
        try {
            this.f4827c.startActivityForResult(intent, 5);
        } catch (ActivityNotFoundException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            C5179v.m19810a(this.f4827c.f3845O, R.string.toast_contact_not_found, 0).show();
        }
        dialogInterface.dismiss();
    }
}
