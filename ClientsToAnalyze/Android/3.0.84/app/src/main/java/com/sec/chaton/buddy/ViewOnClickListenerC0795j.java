package com.sec.chaton.buddy;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.registration.CountryActivity;
import com.sec.chaton.util.C3197bl;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import java.io.UnsupportedEncodingException;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0795j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3089a;

    ViewOnClickListenerC0795j(AddBuddyFragment addBuddyFragment) {
        this.f3089a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (!C3197bl.m11159a()) {
            switch (view.getId()) {
                case R.id.btnCancel /* 2131165298 */:
                    this.f3089a.f1695p.setText("");
                    break;
                case R.id.listItemButton /* 2131165659 */:
                case R.id.image2 /* 2131165911 */:
                    this.f3089a.m3175a(false);
                    break;
                case R.id.tabAddBuddyBySuggestion /* 2131165699 */:
                    this.f3089a.m3197a();
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11846a("00030021");
                    }
                    this.f3089a.m3166a(view);
                    break;
                case R.id.tabAddBuddyByTellFriends /* 2131165701 */:
                    this.f3089a.m3197a();
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11846a("00030022");
                    }
                    this.f3089a.m3166a(view);
                    break;
                case R.id.tabAddBuddyByPhone /* 2131165702 */:
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11846a("00030023");
                    }
                    this.f3089a.f1695p.requestFocus();
                    this.f3089a.m3167a((EditText) this.f3089a.f1695p, true);
                    this.f3089a.m3166a(view);
                    break;
                case R.id.tabAddBuddyById /* 2131165703 */:
                    if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                        C3358h.m11842a().m11846a("00030024");
                    }
                    this.f3089a.f1699t.requestFocus();
                    this.f3089a.m3167a((EditText) this.f3089a.f1699t, true);
                    this.f3089a.m3166a(view);
                    break;
                case R.id.editCountryName /* 2131165708 */:
                    Intent intent = new Intent(this.f3089a.f1676X, (Class<?>) CountryActivity.class);
                    intent.putExtra("ADD_BUDDY_TYPE", 100);
                    intent.putExtra("needBackKey", true);
                    this.f3089a.startActivityForResult(intent, 16);
                    break;
            }
        }
    }
}
