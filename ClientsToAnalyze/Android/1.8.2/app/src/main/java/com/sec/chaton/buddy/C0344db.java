package com.sec.chaton.buddy;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0678e;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.db */
/* loaded from: classes.dex */
class C0344db implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1487a;

    C0344db(BuddyProfileFragment buddyProfileFragment) {
        this.f1487a = buddyProfileFragment;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (!z) {
            if (this.f1487a.f1112U != null && this.f1487a.f1112U.isShowing()) {
                this.f1487a.f1112U.dismiss();
            }
            if (i == 2) {
                this.f1487a.f1109R.setEnabled(true);
                this.f1487a.f1107P.setEnabled(true);
                return;
            }
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1487a.f1149k, this.f1487a.f1158t, 2, true));
                    return;
                } else {
                    C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1487a.f1149k, this.f1487a.f1158t, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            if (this.f1487a.f1112U != null && this.f1487a.f1112U.isShowing()) {
                this.f1487a.f1112U.dismiss();
            }
            Toast.makeText(this.f1487a.f1157s, this.f1487a.f1157s.getString(R.string.buddy_profile_block_toast_success, this.f1487a.f1158t.m2324b()), 0).show();
            if (this.f1487a.f1109R != null) {
                this.f1487a.f1109R.setEnabled(true);
            }
            this.f1487a.f1107P.setEnabled(true);
            if (this.f1487a.getActivity() != null) {
                FragmentActivity activity = this.f1487a.getActivity();
                this.f1487a.getActivity();
                activity.setResult(-1);
                this.f1487a.getActivity().finish();
            }
        }
    }
}
