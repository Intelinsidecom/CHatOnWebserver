package com.sec.widget;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.l */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC5169l implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f18911a;

    ViewOnFocusChangeListenerC5169l(EditTextWithClearButton editTextWithClearButton) {
        this.f18911a = editTextWithClearButton;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        View viewFindViewById = this.f18911a.findViewById(R.id.EditTextClearlayout);
        if (!view.hasFocus()) {
            this.f18911a.m19632b();
            viewFindViewById.setBackgroundDrawable(this.f18911a.getResources().getDrawable(R.drawable.input_line_normal));
        } else {
            viewFindViewById.setBackgroundDrawable(this.f18911a.getResources().getDrawable(R.drawable.input_line_focus));
        }
    }
}
