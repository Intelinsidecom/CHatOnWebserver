package com.sec.chaton.buddy;

import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1722ae;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bg */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0295bg implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1392a;

    ViewOnFocusChangeListenerC0295bg(BuddyFragment buddyFragment) {
        this.f1392a = buddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f1392a.f922J = true;
            this.f1392a.f926N.setVisibility(0);
            if (this.f1392a.f964aa.length() >= 30) {
                String strSubstring = this.f1392a.f964aa.substring(0, 30);
                this.f1392a.f924L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
                this.f1392a.f924L.setText(strSubstring);
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1392a.getActivity().getSystemService("input_method");
            inputMethodManager.showSoftInputFromInputMethod(this.f1392a.f924L.getWindowToken(), 0);
            this.f1392a.f924L.setBackgroundResource(R.drawable.btn_search_dialog_xml);
            if (GlobalApplication.m3265f()) {
                this.f1392a.f924L.setTextColor(this.f1392a.getResources().getColor(R.color.color_edittext_normal));
            } else {
                this.f1392a.f924L.setTextColor(this.f1392a.getResources().getColor(R.color.black));
            }
            inputMethodManager.showSoftInput(this.f1392a.f924L, 1);
            this.f1392a.f926N.setEnabled(true);
            this.f1392a.f924L.setPadding((int) C1722ae.m5895b(12.0f), 0, 0, 0);
            this.f1392a.f924L.setShowClear(true);
            return;
        }
        this.f1392a.f926N.setVisibility(8);
        this.f1392a.f922J = false;
        if (GlobalApplication.m3265f()) {
            this.f1392a.f924L.setTextColor(this.f1392a.getResources().getColor(R.color.buddylist_search_edittext_text_color));
        } else {
            this.f1392a.f924L.setBackgroundResource(R.drawable.co_textfield_search_empty_02);
        }
        this.f1392a.f924L.setText(this.f1392a.f964aa);
        if (!GlobalApplication.m3265f()) {
            this.f1392a.f924L.setTextColor(this.f1392a.getResources().getColor(R.color.white));
        }
        this.f1392a.f924L.setNextFocusDownId(R.id.buddy_search);
        this.f1392a.f926N.setEnabled(false);
        this.f1392a.f924L.setShowClear(false);
    }
}
