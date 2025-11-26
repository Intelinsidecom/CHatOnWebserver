package com.sec.widget;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.y */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3691y implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f13620a;

    ViewOnFocusChangeListenerC3691y(EditTextWithClearButton editTextWithClearButton) {
        this.f13620a = editTextWithClearButton;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        View viewFindViewById = this.f13620a.findViewById(R.id.EditTextClearlayout);
        if (!view.hasFocus()) {
            this.f13620a.m13100b();
            viewFindViewById.setBackgroundDrawable(this.f13620a.getResources().getDrawable(R.drawable.input_line_normal));
        } else {
            viewFindViewById.setBackgroundDrawable(this.f13620a.getResources().getDrawable(R.drawable.input_line_focus));
        }
    }
}
