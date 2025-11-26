package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.buddy.bc */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0106bc implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f649a;

    ViewOnFocusChangeListenerC0106bc(BuddyFragment buddyFragment) {
        this.f649a = buddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) throws Resources.NotFoundException {
        if (!z) {
            this.f649a.f469y.setVisibility(8);
            this.f649a.f466v = false;
            this.f649a.f467w.setBackgroundResource(C0062R.drawable.co_textfield_search_empty_02);
            this.f649a.f467w.setCompoundDrawables(null, null, null, null);
            this.f649a.f467w.setText(this.f649a.f414E);
            this.f649a.f467w.setTextColor(this.f649a.getResources().getColor(C0062R.color.white));
            this.f649a.f467w.setNextFocusDownId(C0062R.id.buddy_search);
            this.f649a.f469y.setEnabled(false);
            this.f649a.f467w.setOnTouchListener(null);
            return;
        }
        this.f649a.f466v = true;
        this.f649a.f469y.setVisibility(0);
        if (this.f649a.f414E.length() >= 30) {
            String strSubstring = this.f649a.f414E.substring(0, 30);
            this.f649a.f467w.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
            this.f649a.f467w.setText(strSubstring);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.f649a.getActivity().getSystemService("input_method");
        inputMethodManager.showSoftInputFromInputMethod(this.f649a.f467w.getWindowToken(), 0);
        this.f649a.f467w.setBackgroundResource(C0062R.drawable.btn_search_dialog_xml);
        this.f649a.f467w.setTextColor(this.f649a.getResources().getColor(C0062R.color.black));
        Drawable drawable = this.f649a.getResources().getDrawable(C0062R.drawable.btn_del);
        drawable.setBounds(0, 2, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f649a.f467w.setCompoundDrawables(null, null, drawable, null);
        inputMethodManager.showSoftInput(this.f649a.f467w, 1);
        this.f649a.f469y.setEnabled(true);
        this.f649a.f467w.setOnTouchListener(new ViewOnTouchListenerC0083ag(this, drawable));
    }
}
