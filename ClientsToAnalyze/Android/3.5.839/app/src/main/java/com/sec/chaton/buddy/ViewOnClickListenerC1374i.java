package com.sec.chaton.buddy;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.registration.CountryActivity;
import com.sec.chaton.util.C4847bl;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC1374i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4974a;

    ViewOnClickListenerC1374i(AddBuddyFragment addBuddyFragment) {
        this.f4974a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (!C4847bl.m18333a()) {
            switch (view.getId()) {
                case R.id.tabAddBuddyBySuggestion /* 2131165755 */:
                    this.f4974a.m6237a(view);
                    break;
                case R.id.tabAddBuddyByPhone /* 2131165757 */:
                    this.f4974a.m6237a(view);
                    break;
                case R.id.tabAddBuddyById /* 2131165758 */:
                    this.f4974a.m6237a(view);
                    break;
                case R.id.tabAddBuddyByTellFriends /* 2131165759 */:
                    this.f4974a.m6237a(view);
                    break;
                case R.id.editCountryName /* 2131165764 */:
                    Intent intent = new Intent(this.f4974a.f3528V, (Class<?>) CountryActivity.class);
                    intent.putExtra("ADD_BUDDY_TYPE", 100);
                    intent.putExtra("needBackKey", true);
                    this.f4974a.startActivityForResult(intent, 16);
                    break;
                case R.id.image2 /* 2131165831 */:
                    int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        C5179v.m19810a(this.f4974a.f3528V, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        this.f4974a.m6243a(false);
                        break;
                    }
                case R.id.btnCancel /* 2131166329 */:
                    this.f4974a.f3544o.setText("");
                    break;
            }
        }
    }
}
