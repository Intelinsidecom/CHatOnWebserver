package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC0480av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0484az f2011a;

    /* renamed from: b */
    final /* synthetic */ String f2012b;

    /* renamed from: c */
    final /* synthetic */ ViewOnClickListenerC0477as f2013c;

    ViewOnClickListenerC0480av(ViewOnClickListenerC0477as viewOnClickListenerC0477as, C0484az c0484az, String str) {
        this.f2013c = viewOnClickListenerC0477as;
        this.f2011a = c0484az;
        this.f2012b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        if (((CheckBox) view).isChecked()) {
            this.f2013c.f1973L.put(Long.valueOf(this.f2011a.f2041a), true);
        } else {
            this.f2013c.f1973L.put(Long.valueOf(this.f2011a.f2041a), false);
        }
        long j2 = 0;
        Iterator it = this.f2013c.f1973L.entrySet().iterator();
        while (true) {
            j = j2;
            if (!it.hasNext()) {
                break;
            } else {
                j2 = ((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue() ? j + 1 : j;
            }
        }
        long size = this.f2013c.f1973L.size() - j;
        long j3 = this.f2013c.f1975N + this.f2013c.f1974M;
        if (j3 == size) {
            this.f2013c.f1978Q = EnumC0487ba.SELECT_NONE;
            this.f2013c.f1980S = EnumC0487ba.SELECT_NONE;
            this.f2013c.f1979R = EnumC0487ba.SELECT_NONE;
        } else if (j3 == j) {
            this.f2013c.f1978Q = EnumC0487ba.SELECT_ALL;
            this.f2013c.f1980S = EnumC0487ba.SELECT_NONE;
            this.f2013c.f1979R = EnumC0487ba.SELECT_NONE;
        } else if (this.f2013c.f1975N == size) {
            this.f2013c.f1978Q = EnumC0487ba.SELECT_NONE;
            this.f2013c.f1980S = EnumC0487ba.SELECT_NONE;
        } else if (this.f2013c.f1975N == j) {
            this.f2013c.f1978Q = EnumC0487ba.SELECT_NONE;
            this.f2013c.f1980S = EnumC0487ba.SELECT_ALL;
        } else {
            if (this.f2013c.f1978Q == EnumC0487ba.SELECT_ALL || this.f2013c.f1978Q == EnumC0487ba.SELECT_PART) {
                this.f2013c.f1978Q = EnumC0487ba.SELECT_PART;
            } else {
                this.f2013c.f1978Q = EnumC0487ba.SELECT_NONE;
            }
            if (this.f2013c.f1980S == EnumC0487ba.SELECT_ALL || this.f2013c.f1980S == EnumC0487ba.SELECT_PART) {
                this.f2013c.f1980S = EnumC0487ba.SELECT_PART;
            } else {
                this.f2013c.f1980S = EnumC0487ba.SELECT_NONE;
            }
        }
        this.f2013c.m2663a(this.f2011a.f2022D, this.f2011a.f2023E, this.f2012b);
        this.f2013c.f1963B.invalidateViews();
    }
}
