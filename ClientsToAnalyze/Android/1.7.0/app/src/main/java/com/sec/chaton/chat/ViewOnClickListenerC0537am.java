package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.am */
/* loaded from: classes.dex */
class ViewOnClickListenerC0537am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0606w f1888a;

    /* renamed from: b */
    final /* synthetic */ String f1889b;

    /* renamed from: c */
    final /* synthetic */ ViewOnClickListenerC0603t f1890c;

    ViewOnClickListenerC0537am(ViewOnClickListenerC0603t viewOnClickListenerC0603t, C0606w c0606w, String str) {
        this.f1890c = viewOnClickListenerC0603t;
        this.f1888a = c0606w;
        this.f1889b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        if (((CheckBox) view).isChecked()) {
            this.f1890c.f2048C.put(Long.valueOf(this.f1888a.f2114a), true);
        } else {
            this.f1890c.f2048C.put(Long.valueOf(this.f1888a.f2114a), false);
        }
        long j2 = 0;
        Iterator it = this.f1890c.f2048C.entrySet().iterator();
        while (true) {
            j = j2;
            if (!it.hasNext()) {
                break;
            } else {
                j2 = ((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue() ? j + 1 : j;
            }
        }
        long size = this.f1890c.f2048C.size() - j;
        long j3 = this.f1890c.f2051F + this.f1890c.f2050E;
        if (j3 == size) {
            this.f1890c.f2054I = EnumC0542ar.SELECT_NONE;
            this.f1890c.f2056K = EnumC0542ar.SELECT_NONE;
            this.f1890c.f2055J = EnumC0542ar.SELECT_NONE;
        } else if (j3 == j) {
            this.f1890c.f2054I = EnumC0542ar.SELECT_ALL;
            this.f1890c.f2056K = EnumC0542ar.SELECT_NONE;
            this.f1890c.f2055J = EnumC0542ar.SELECT_NONE;
        } else if (this.f1890c.f2050E == size) {
            this.f1890c.f2054I = EnumC0542ar.SELECT_NONE;
            this.f1890c.f2055J = EnumC0542ar.SELECT_NONE;
        } else if (this.f1890c.f2050E == j) {
            this.f1890c.f2054I = EnumC0542ar.SELECT_NONE;
            this.f1890c.f2055J = EnumC0542ar.SELECT_ALL;
        } else {
            if (this.f1890c.f2054I == EnumC0542ar.SELECT_ALL || this.f1890c.f2054I == EnumC0542ar.SELECT_PART) {
                this.f1890c.f2054I = EnumC0542ar.SELECT_PART;
            } else {
                this.f1890c.f2054I = EnumC0542ar.SELECT_NONE;
            }
            if (this.f1890c.f2055J == EnumC0542ar.SELECT_ALL || this.f1890c.f2055J == EnumC0542ar.SELECT_PART) {
                this.f1890c.f2055J = EnumC0542ar.SELECT_PART;
            } else {
                this.f1890c.f2055J = EnumC0542ar.SELECT_NONE;
            }
        }
        this.f1890c.m2815a(this.f1888a.f2102N, this.f1888a.f2090B, this.f1889b);
        this.f1890c.f2080t.invalidateViews();
    }
}
