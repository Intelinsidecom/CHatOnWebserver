package com.android.p029ex.editstyledtext;

import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.bd */
/* loaded from: classes.dex */
public class C0391bd extends InputConnectionWrapper {

    /* renamed from: a */
    EditStyledText f947a;

    public C0391bd(InputConnection inputConnection, EditStyledText editStyledText) {
        super(inputConnection, true);
        this.f947a = editStyledText;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        Log.d("EditStyledText", "--- commitText:");
        this.f947a.f874g.m1404h();
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        Log.d("EditStyledText", "--- finishcomposing:");
        if (!this.f947a.m1300n() && !this.f947a.m1287a() && !this.f947a.m1298l()) {
            this.f947a.m1289c();
        }
        return super.finishComposingText();
    }
}
