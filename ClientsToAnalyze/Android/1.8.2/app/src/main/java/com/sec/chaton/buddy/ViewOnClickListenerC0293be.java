package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.C0694i;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC0293be implements View.OnClickListener {

    /* renamed from: a */
    InputMethodManager f1389a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f1390b;

    ViewOnClickListenerC0293be(BuddyFragment buddyFragment) {
        this.f1390b = buddyFragment;
        this.f1389a = (InputMethodManager) this.f1390b.getActivity().getSystemService("input_method");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1390b.f924L.getText().toString().matches(".*,.*")) {
            Toast.makeText(this.f1390b.getActivity(), R.string.group_name_save, 0).show();
            this.f1390b.f924L.setText(this.f1390b.f924L.getText().toString().replace(",", ""));
        }
        if (this.f1390b.f921I) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_title", this.f1390b.f924L.getText().toString());
            contentValues.put("inbox_title_fixed", "Y");
            if (this.f1390b.f1018t.getContentResolver().update(C0694i.f2616a, contentValues, "inbox_no='" + this.f1390b.f934V + "'", null) > 0) {
                Toast.makeText(this.f1390b.getActivity(), R.string.buddy_profile_saveprofile_toast_success, 0).show();
                this.f1390b.f964aa = this.f1390b.f924L.getText().toString();
            } else {
                Toast.makeText(this.f1390b.getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        } else {
            Toast.makeText(this.f1390b.getActivity(), R.string.buddy_profile_saveprofile_toast_success, 0).show();
            this.f1390b.f936X = this.f1390b.f924L.getText().toString();
            this.f1390b.f964aa = this.f1390b.f924L.getText().toString();
        }
        this.f1390b.f923K = true;
        this.f1390b.f925M.requestFocus();
        this.f1389a.hideSoftInputFromWindow(this.f1390b.f924L.getWindowToken(), 0);
    }
}
