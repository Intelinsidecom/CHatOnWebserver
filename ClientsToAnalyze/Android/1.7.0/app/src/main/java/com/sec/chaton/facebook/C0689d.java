package com.sec.chaton.facebook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

/* compiled from: FacebookInvitationCardSelectActivity.java */
/* renamed from: com.sec.chaton.facebook.d */
/* loaded from: classes.dex */
class C0689d extends ArrayAdapter {
    public C0689d(Context context, int i, int i2, Integer[] numArr) {
        super(context, i, i2, numArr);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) super.getView(i, view, viewGroup);
        checkedTextView.setCompoundDrawablesWithIntrinsicBounds(((Integer) getItem(i)).intValue(), 0, 0, 0);
        checkedTextView.setText("");
        return checkedTextView;
    }
}
