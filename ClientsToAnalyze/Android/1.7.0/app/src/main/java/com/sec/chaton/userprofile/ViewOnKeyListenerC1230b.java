package com.sec.chaton.userprofile;

import android.hardware.motion.MREvent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.b */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1230b implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4310a;

    ViewOnKeyListenerC1230b(MyPageFragment myPageFragment) {
        this.f4310a = myPageFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case MREvent.TILT_BACK /* 23 */:
                case MREvent.BLOW /* 66 */:
                    if (this.f4310a.f4141c != null) {
                        if (!this.f4310a.f4141c.equals(this.f4310a.f4121S)) {
                            if (!this.f4310a.f4141c.equals(this.f4310a.f4123U)) {
                                if (!this.f4310a.f4141c.equals(this.f4310a.f4126X)) {
                                    if (!this.f4310a.f4141c.equals(this.f4310a.f4124V)) {
                                        if (this.f4310a.f4141c.equals(this.f4310a.f4125W)) {
                                            ((LinearLayout) this.f4310a.f4141c.findViewById(R.id.user_profile_birthday)).performClick();
                                        }
                                    } else {
                                        ((LinearLayout) this.f4310a.f4141c.findViewById(R.id.user_profile_phone)).performClick();
                                    }
                                } else {
                                    ((LinearLayout) this.f4310a.f4141c.findViewById(R.id.interaction_title)).performClick();
                                }
                            } else {
                                ((TextView) this.f4310a.f4141c.findViewById(R.id.textPersonalMsg)).performClick();
                            }
                        } else {
                            ((LinearLayout) this.f4310a.f4141c.findViewById(R.id.layout3)).performClick();
                        }
                        return true;
                    }
                default:
                    return false;
            }
        }
        return false;
    }
}
