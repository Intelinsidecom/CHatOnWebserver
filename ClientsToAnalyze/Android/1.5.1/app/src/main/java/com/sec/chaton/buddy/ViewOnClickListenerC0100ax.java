package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.buddy.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC0100ax implements View.OnClickListener {

    /* renamed from: a */
    InputMethodManager f642a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f643b;

    ViewOnClickListenerC0100ax(BuddyFragment buddyFragment) {
        this.f643b = buddyFragment;
        this.f642a = (InputMethodManager) this.f643b.getActivity().getSystemService("input_method");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f643b.f465u) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_title", this.f643b.f467w.getText().toString());
            contentValues.put("inbox_title_fixed", "Y");
            if (this.f643b.f453i.getContentResolver().update(ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no='" + this.f643b.f410A + "'", null) > 0) {
                Toast.makeText(this.f643b.getActivity(), C0062R.string.buddy_profile_saveprofile_toast_success, 0).show();
                this.f643b.f414E = this.f643b.f467w.getText().toString();
            } else {
                Toast.makeText(this.f643b.getActivity(), C0062R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        } else {
            Toast.makeText(this.f643b.getActivity(), C0062R.string.buddy_profile_saveprofile_toast_success, 0).show();
            this.f643b.f411B = this.f643b.f467w.getText().toString();
            this.f643b.f414E = this.f643b.f467w.getText().toString();
        }
        this.f643b.f468x.requestFocus();
        this.f642a.hideSoftInputFromWindow(this.f643b.f467w.getWindowToken(), 0);
    }
}
