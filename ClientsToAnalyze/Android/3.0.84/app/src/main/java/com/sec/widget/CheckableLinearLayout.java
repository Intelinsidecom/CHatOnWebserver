package com.sec.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class CheckableLinearLayout extends LinearLayout implements Checkable {

    /* renamed from: a */
    final String f13341a;

    /* renamed from: b */
    final String f13342b;

    /* renamed from: c */
    final String f13343c;

    /* renamed from: d */
    int f13344d;

    /* renamed from: e */
    int f13345e;

    /* renamed from: f */
    Checkable f13346f;

    public CheckableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13341a = "http://schemas.android.com/apk/res/com.sec.chaton";
        this.f13342b = "checkable_single";
        this.f13343c = "checkable_multiple";
        this.f13344d = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/com.sec.chaton", "checkable_single", -1);
        this.f13345e = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/com.sec.chaton", "checkable_multiple", -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View viewFindViewById = findViewById(this.f13344d);
        View viewFindViewById2 = findViewById(this.f13345e);
        if (viewFindViewById != 0 && viewFindViewById.getVisibility() == 0) {
            this.f13346f = (Checkable) viewFindViewById;
        } else if (viewFindViewById2 != 0 && viewFindViewById2.getVisibility() == 0) {
            this.f13346f = (Checkable) viewFindViewById2;
        } else {
            this.f13346f = null;
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f13346f != null) {
            this.f13346f.setChecked(z);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (this.f13346f == null) {
            return false;
        }
        return this.f13346f.isChecked();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (this.f13346f != null) {
            this.f13346f.toggle();
        }
    }
}
