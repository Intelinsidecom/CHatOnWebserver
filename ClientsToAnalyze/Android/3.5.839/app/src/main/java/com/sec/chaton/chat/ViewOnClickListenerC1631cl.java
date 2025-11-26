package com.sec.chaton.chat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cl */
/* loaded from: classes.dex */
class ViewOnClickListenerC1631cl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6158a;

    ViewOnClickListenerC1631cl(ChatFragment chatFragment) {
        this.f6158a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6158a.f5551at == EnumC2214ab.AMS) {
            if (!C4822an.m18206P() && !C4822an.m18207Q()) {
                if (C2948h.m12190a().m12192a(this.f6158a.f5624cN, EnumC2949i.Animessage)) {
                    Intent intentM12138a = null;
                    if (this.f6158a.f5550as != null) {
                        intentM12138a = C2921a.m12139a(this.f6158a.f5624cN, this.f6158a.f5550as.getPath());
                    } else if (this.f6158a.f5512aE != null) {
                        intentM12138a = C2921a.m12138a(this.f6158a.f5624cN, Uri.parse(this.f6158a.f5512aE));
                    }
                    if (intentM12138a != null) {
                        this.f6158a.startActivity(intentM12138a);
                        return;
                    }
                    return;
                }
                try {
                    if (C4859bx.m18396c()) {
                        this.f6158a.startActivity(C2921a.m12141i(this.f6158a.f5624cN));
                    } else {
                        this.f6158a.startActivity(C2921a.m12142j(this.f6158a.f5624cN));
                    }
                    return;
                } catch (ActivityNotFoundException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, ChatFragment.f5461a);
                        return;
                    }
                    return;
                }
            }
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
        }
    }
}
