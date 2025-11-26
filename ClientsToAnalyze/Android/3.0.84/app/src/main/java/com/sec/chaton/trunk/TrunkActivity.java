package com.sec.chaton.trunk;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.common.actionbar.AbstractC3284a;

/* loaded from: classes.dex */
public class TrunkActivity extends BaseSinglePaneActivity implements InterfaceC3039cm {

    /* renamed from: a */
    private TrunkView f10500a;

    /* renamed from: b */
    private InterfaceC3063q f10501b;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10501b = (InterfaceC3063q) m3089b();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f10500a = new TrunkView();
        this.f10501b = this.f10500a;
        return this.f10500a;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f10501b != null && !this.f10501b.mo10410a()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                onBackPressed();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.trunk.InterfaceC3039cm
    /* renamed from: a */
    public void mo1316a(String str, String str2, String str3, String str4, EnumC3026g enumC3026g, int i, boolean z) {
        Intent intent = new Intent();
        intent.setClass(this, TrunkPageActivity.class);
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNo", str2);
        intent.putExtra("itemId", str3);
        intent.putExtra("isvalid", z);
        startActivity(intent);
    }

    /* renamed from: c */
    public AbstractC3284a m10181c() {
        return m11543k();
    }
}
