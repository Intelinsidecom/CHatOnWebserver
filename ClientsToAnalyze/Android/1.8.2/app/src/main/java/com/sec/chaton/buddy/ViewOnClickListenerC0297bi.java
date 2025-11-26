package com.sec.chaton.buddy;

import android.net.Uri;
import android.view.View;
import com.sec.chaton.p017e.C0688c;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bi */
/* loaded from: classes.dex */
class ViewOnClickListenerC0297bi implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1394a;

    ViewOnClickListenerC0297bi(BuddyFragment buddyFragment) {
        this.f1394a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = "";
        Uri uriM3120a = C0688c.m3120a();
        String[] strArr = this.f1394a.f938Z;
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr.length > 0) {
            String str2 = "buddy_no NOT IN ( ";
            for (String str3 : strArr) {
                stringBuffer.append(", '" + str3 + "'");
            }
            str = str2 + stringBuffer.toString().substring(1) + " )";
        }
        this.f1394a.f981ar.f1409o.startQuery(HttpResponseCode.f7897OK, null, uriM3120a, null, str, null, null);
    }
}
