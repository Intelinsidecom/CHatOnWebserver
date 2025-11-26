package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.au */
/* loaded from: classes.dex */
class ViewOnClickListenerC0479au implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0484az f2008a;

    /* renamed from: b */
    final /* synthetic */ String f2009b;

    /* renamed from: c */
    final /* synthetic */ ViewOnClickListenerC0477as f2010c;

    ViewOnClickListenerC0479au(ViewOnClickListenerC0477as viewOnClickListenerC0477as, C0484az c0484az, String str) {
        this.f2010c = viewOnClickListenerC0477as;
        this.f2008a = c0484az;
        this.f2009b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        if (((CheckBox) view).isChecked()) {
            this.f2010c.f1972K.put(Long.valueOf(this.f2008a.f2041a), true);
        } else {
            this.f2010c.f1972K.put(Long.valueOf(this.f2008a.f2041a), false);
        }
        long j2 = 0;
        Iterator it = this.f2010c.f1972K.entrySet().iterator();
        while (true) {
            j = j2;
            if (!it.hasNext()) {
                break;
            } else {
                j2 = ((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue() ? j + 1 : j;
            }
        }
        long size = this.f2010c.f1972K.size() - j;
        long j3 = this.f2010c.f1975N + this.f2010c.f1974M;
        if (j3 == size) {
            this.f2010c.f1978Q = EnumC0487ba.SELECT_NONE;
            this.f2010c.f1980S = EnumC0487ba.SELECT_NONE;
            this.f2010c.f1979R = EnumC0487ba.SELECT_NONE;
        } else if (j3 == j) {
            this.f2010c.f1978Q = EnumC0487ba.SELECT_ALL;
            this.f2010c.f1980S = EnumC0487ba.SELECT_NONE;
            this.f2010c.f1979R = EnumC0487ba.SELECT_NONE;
        } else if (this.f2010c.f1974M == size) {
            this.f2010c.f1978Q = EnumC0487ba.SELECT_NONE;
            this.f2010c.f1979R = EnumC0487ba.SELECT_NONE;
        } else if (this.f2010c.f1974M == j) {
            this.f2010c.f1978Q = EnumC0487ba.SELECT_NONE;
            this.f2010c.f1979R = EnumC0487ba.SELECT_ALL;
        } else {
            if (this.f2010c.f1978Q == EnumC0487ba.SELECT_ALL || this.f2010c.f1978Q == EnumC0487ba.SELECT_PART) {
                this.f2010c.f1978Q = EnumC0487ba.SELECT_PART;
            } else {
                this.f2010c.f1978Q = EnumC0487ba.SELECT_NONE;
            }
            if (this.f2010c.f1979R == EnumC0487ba.SELECT_ALL || this.f2010c.f1979R == EnumC0487ba.SELECT_PART) {
                this.f2010c.f1979R = EnumC0487ba.SELECT_PART;
            } else {
                this.f2010c.f1979R = EnumC0487ba.SELECT_NONE;
            }
        }
        this.f2010c.m2663a(this.f2008a.f2035Q, this.f2008a.f2023E, this.f2009b);
        this.f2010c.f1963B.invalidateViews();
    }
}
