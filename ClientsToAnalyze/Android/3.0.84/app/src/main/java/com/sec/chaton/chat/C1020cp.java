package com.sec.chaton.chat;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cp */
/* loaded from: classes.dex */
class C1020cp implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4103a;

    C1020cp(ChatFragment chatFragment) {
        this.f4103a = chatFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) {
        C1070el c1070el = (C1070el) obj;
        if (c1070el == null) {
            C3250y.m11442a("airButtonListener - holder is null", ChatFragment.f3484a);
            return;
        }
        EnumC1455w enumC1455w = c1070el.f4269ax;
        if (enumC1455w == EnumC1455w.TEXT) {
            if (i == 0) {
                this.f4103a.m4971a(c1070el);
                return;
            }
            if (i == 1) {
                this.f4103a.m4985b(c1070el);
                return;
            } else if (i == 2) {
                this.f4103a.m4990c(c1070el);
                return;
            } else {
                if (i == 3) {
                    this.f4103a.m5000e(c1070el);
                    return;
                }
                return;
            }
        }
        if (enumC1455w == EnumC1455w.AMS || enumC1455w == EnumC1455w.IMAGE || enumC1455w == EnumC1455w.VIDEO || enumC1455w == EnumC1455w.AUDIO || enumC1455w == EnumC1455w.CONTACT || enumC1455w == EnumC1455w.CALENDAR) {
            if (i == 0) {
                this.f4103a.m4985b(c1070el);
                return;
            } else if (i == 1) {
                this.f4103a.m4990c(c1070el);
                return;
            } else {
                if (i == 2) {
                    this.f4103a.m5000e(c1070el);
                    return;
                }
                return;
            }
        }
        if (enumC1455w == EnumC1455w.FILE) {
            if (i == 0) {
                this.f4103a.m4985b(c1070el);
                return;
            }
            if (i == 1) {
                this.f4103a.m4995d(c1070el);
                return;
            } else if (i == 2) {
                this.f4103a.m4990c(c1070el);
                return;
            } else {
                if (i == 3) {
                    this.f4103a.m5000e(c1070el);
                    return;
                }
                return;
            }
        }
        if (enumC1455w == EnumC1455w.GEO) {
            if (i == 0) {
                this.f4103a.m4985b(c1070el);
                return;
            } else {
                if (i == 1) {
                    this.f4103a.m5000e(c1070el);
                    return;
                }
                return;
            }
        }
        if (enumC1455w == EnumC1455w.ANICON && i == 0) {
            this.f4103a.m5000e(c1070el);
        }
    }
}
