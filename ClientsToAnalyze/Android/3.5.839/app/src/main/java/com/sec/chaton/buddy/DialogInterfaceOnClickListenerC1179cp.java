package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import java.util.HashMap;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1179cp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f4406a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f4407b;

    DialogInterfaceOnClickListenerC1179cp(BuddyFragment buddyFragment, Intent intent) {
        this.f4407b = buddyFragment;
        this.f4406a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4407b.m6461b((HashMap<String, String>) this.f4406a.getSerializableExtra("KEY_SELECTED_RESULT_FOR_COMPOSER"));
    }
}
