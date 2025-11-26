package com.sec.chaton.chat;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

/* compiled from: AdaptableSwitch.java */
/* renamed from: com.sec.chaton.chat.a */
/* loaded from: classes.dex */
public class C1505a {

    /* renamed from: a */
    Switch f5837a;

    /* renamed from: b */
    CheckBox f5838b;

    /* renamed from: c */
    EnumC1580b f5839c = EnumC1580b.SWITCH;

    /* renamed from: a */
    public void m8354a(Switch r2) {
        this.f5839c = EnumC1580b.SWITCH;
        this.f5837a = r2;
        this.f5838b = null;
    }

    /* renamed from: a */
    public void m8352a(CheckBox checkBox) {
        this.f5839c = EnumC1580b.CHECKBOX;
        this.f5837a = null;
        this.f5838b = checkBox;
    }

    /* renamed from: a */
    public void m8355a(boolean z) {
        if (this.f5839c == EnumC1580b.SWITCH) {
            if (this.f5837a != null) {
                this.f5837a.setChecked(z);
            }
        } else if (this.f5838b != null) {
            this.f5838b.setChecked(z);
        }
    }

    /* renamed from: a */
    public boolean m8356a() {
        if (this.f5839c == EnumC1580b.SWITCH) {
            return this.f5837a.isChecked();
        }
        return this.f5838b.isChecked();
    }

    /* renamed from: a */
    public void m8353a(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.f5839c == EnumC1580b.SWITCH) {
            this.f5837a.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            this.f5838b.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }
}
