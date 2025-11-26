package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ea */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0663ea implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2882a;

    /* renamed from: b */
    final /* synthetic */ Uri f2883b;

    /* renamed from: c */
    final /* synthetic */ BuddyInfoFragment f2884c;

    DialogInterfaceOnClickListenerC0663ea(BuddyInfoFragment buddyInfoFragment, String str, Uri uri) {
        this.f2884c = buddyInfoFragment;
        this.f2882a = str;
        this.f2883b = uri;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.f2882a);
        bundle.putString("name", this.f2884c.f1975e.m3976c());
        if (this.f2884c.f1975e.m3978e() != null) {
            bundle.putString("email", this.f2884c.f1975e.m3978e());
        }
        Intent intent = new Intent("android.intent.action.INSERT", this.f2883b);
        intent.putExtras(bundle);
        intent.putExtra("return-data", true);
        try {
            this.f2884c.startActivityForResult(intent, 5);
        } catch (ActivityNotFoundException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            C3641ai.m13210a(this.f2884c.f1963K, R.string.toast_contact_not_found, 0).show();
        }
        dialogInterface.dismiss();
    }
}
