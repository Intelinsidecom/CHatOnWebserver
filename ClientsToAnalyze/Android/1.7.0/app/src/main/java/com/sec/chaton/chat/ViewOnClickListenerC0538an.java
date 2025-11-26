package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.an */
/* loaded from: classes.dex */
class ViewOnClickListenerC0538an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0606w f1891a;

    /* renamed from: b */
    final /* synthetic */ String f1892b;

    /* renamed from: c */
    final /* synthetic */ ViewOnClickListenerC0603t f1893c;

    ViewOnClickListenerC0538an(ViewOnClickListenerC0603t viewOnClickListenerC0603t, C0606w c0606w, String str) {
        this.f1893c = viewOnClickListenerC0603t;
        this.f1891a = c0606w;
        this.f1892b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        if (((CheckBox) view).isChecked()) {
            this.f1893c.f2049D.put(Long.valueOf(this.f1891a.f2114a), true);
        } else {
            this.f1893c.f2049D.put(Long.valueOf(this.f1891a.f2114a), false);
        }
        long j2 = 0;
        Iterator it = this.f1893c.f2049D.entrySet().iterator();
        while (true) {
            j = j2;
            if (!it.hasNext()) {
                break;
            } else {
                j2 = ((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue() ? j + 1 : j;
            }
        }
        long size = this.f1893c.f2049D.size() - j;
        long j3 = this.f1893c.f2051F + this.f1893c.f2050E;
        if (j3 == size) {
            this.f1893c.f2054I = EnumC0542ar.SELECT_NONE;
            this.f1893c.f2056K = EnumC0542ar.SELECT_NONE;
            this.f1893c.f2055J = EnumC0542ar.SELECT_NONE;
        } else if (j3 == j) {
            this.f1893c.f2054I = EnumC0542ar.SELECT_ALL;
            this.f1893c.f2056K = EnumC0542ar.SELECT_NONE;
            this.f1893c.f2055J = EnumC0542ar.SELECT_NONE;
        } else if (this.f1893c.f2051F == size) {
            this.f1893c.f2054I = EnumC0542ar.SELECT_NONE;
            this.f1893c.f2056K = EnumC0542ar.SELECT_NONE;
        } else if (this.f1893c.f2051F == j) {
            this.f1893c.f2054I = EnumC0542ar.SELECT_NONE;
            this.f1893c.f2056K = EnumC0542ar.SELECT_ALL;
        } else {
            if (this.f1893c.f2054I == EnumC0542ar.SELECT_ALL || this.f1893c.f2054I == EnumC0542ar.SELECT_PART) {
                this.f1893c.f2054I = EnumC0542ar.SELECT_PART;
            } else {
                this.f1893c.f2054I = EnumC0542ar.SELECT_NONE;
            }
            if (this.f1893c.f2056K == EnumC0542ar.SELECT_ALL || this.f1893c.f2056K == EnumC0542ar.SELECT_PART) {
                this.f1893c.f2056K = EnumC0542ar.SELECT_PART;
            } else {
                this.f1893c.f2056K = EnumC0542ar.SELECT_NONE;
            }
        }
        this.f1893c.m2815a(this.f1891a.f2089A, this.f1891a.f2090B, this.f1892b);
        this.f1893c.f2080t.invalidateViews();
    }
}
