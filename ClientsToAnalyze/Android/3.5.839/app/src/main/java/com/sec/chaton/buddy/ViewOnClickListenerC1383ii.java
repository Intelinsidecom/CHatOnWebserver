package com.sec.chaton.buddy;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.chaton.buddy.p050a.C1107d;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ii */
/* loaded from: classes.dex */
class ViewOnClickListenerC1383ii implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1107d f4986a;

    /* renamed from: b */
    final /* synthetic */ SpecialBuddyFragment f4987b;

    ViewOnClickListenerC1383ii(SpecialBuddyFragment specialBuddyFragment, C1107d c1107d) {
        this.f4987b = specialBuddyFragment;
        this.f4986a = c1107d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strReplace = this.f4986a.m7091h().replace(" ", "");
        if (!strReplace.startsWith("https://") && !strReplace.startsWith("http://")) {
            strReplace = "http://" + strReplace;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(strReplace));
        this.f4987b.startActivity(intent);
    }
}
