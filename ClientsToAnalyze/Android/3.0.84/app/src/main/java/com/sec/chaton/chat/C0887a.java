package com.sec.chaton.chat;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

/* compiled from: AdaptableSwitch.java */
/* renamed from: com.sec.chaton.chat.a */
/* loaded from: classes.dex */
public class C0887a {

    /* renamed from: a */
    Switch f3777a;

    /* renamed from: b */
    CheckBox f3778b;

    /* renamed from: c */
    EnumC0949b f3779c;

    /* renamed from: a */
    public void m5084a(Switch r2) {
        this.f3779c = EnumC0949b.SWITCH;
        this.f3777a = r2;
        this.f3778b = null;
    }

    /* renamed from: a */
    public void m5082a(CheckBox checkBox) {
        this.f3779c = EnumC0949b.CHECKBOX;
        this.f3777a = null;
        this.f3778b = checkBox;
    }

    /* renamed from: a */
    public void m5085a(boolean z) {
        if (this.f3779c == EnumC0949b.SWITCH) {
            this.f3777a.setChecked(z);
        } else {
            this.f3778b.setChecked(z);
        }
    }

    /* renamed from: a */
    public boolean m5086a() {
        return this.f3779c == EnumC0949b.SWITCH ? this.f3777a.isChecked() : this.f3778b.isChecked();
    }

    /* renamed from: a */
    public void m5083a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.f3779c == EnumC0949b.SWITCH) {
            this.f3777a.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            this.f3778b.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }
}
