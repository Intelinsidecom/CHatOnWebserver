package com.sec.chaton.smsplugin.spam;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class SpamlistDeleteLayout extends LinearLayout implements Checkable {

    /* renamed from: a */
    int f14398a;

    /* renamed from: b */
    CheckBox f14399b;

    public SpamlistDeleteLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14398a = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "checkable", 0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        this.f14399b = (CheckBox) findViewById(this.f14398a);
        if (this.f14399b == null) {
            return false;
        }
        return this.f14399b.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.f14399b = (CheckBox) findViewById(this.f14398a);
        if (this.f14399b != null) {
            this.f14399b.setChecked(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f14399b = (CheckBox) findViewById(this.f14398a);
        if (this.f14399b != null) {
            this.f14399b.toggle();
        }
    }
}
