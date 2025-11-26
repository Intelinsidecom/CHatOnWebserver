package com.sec.chaton.chat;

import android.net.Uri;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.ds */
/* loaded from: classes.dex */
class ViewOnClickListenerC1050ds implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4161a;

    ViewOnClickListenerC1050ds(ChatInfoFragment chatInfoFragment) {
        this.f4161a = chatInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f4161a.f3740h, R.string.popup_no_network_connection, 0).show();
            return;
        }
        if (this.f4161a.f3753u != null) {
            Uri uriM6305a = C1441i.m6305a();
            String str = "";
            String[] strArr = this.f4161a.f3744l;
            StringBuffer stringBuffer = new StringBuffer();
            if (strArr.length > 0) {
                String str2 = "buddy_no NOT IN ( ";
                for (String str3 : strArr) {
                    stringBuffer.append(", '" + str3 + "'");
                }
                str = str2 + stringBuffer.toString().substring(1) + " )";
            }
            this.f4161a.f3753u.startQuery(70, null, uriM6305a, null, str, null, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
        }
    }
}
