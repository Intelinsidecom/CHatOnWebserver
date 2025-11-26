package com.sec.chaton.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.sec.chaton.widget.AdaptableEditText;
import com.sec.chaton.widget.AdaptableTextView;

/* compiled from: ActivityHelper.java */
/* renamed from: com.sec.chaton.base.b */
/* loaded from: classes.dex */
final class LayoutInflaterFactory2C1060b implements LayoutInflater.Factory2 {
    LayoutInflaterFactory2C1060b() {
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (str.equals("TextView")) {
            return new AdaptableTextView(context, attributeSet);
        }
        if (str.equals("EditText")) {
            return new AdaptableEditText(context, attributeSet);
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (str.equals("TextView")) {
            return new AdaptableTextView(context, attributeSet);
        }
        if (str.equals("EditText")) {
            return new AdaptableEditText(context, attributeSet);
        }
        return null;
    }
}
