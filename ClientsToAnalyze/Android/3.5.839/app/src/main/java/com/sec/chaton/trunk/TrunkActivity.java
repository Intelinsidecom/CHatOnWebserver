package com.sec.chaton.trunk;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.common.actionbar.AbstractC4946a;

/* loaded from: classes.dex */
public class TrunkActivity extends BaseSinglePaneActivity implements InterfaceC4659cq {

    /* renamed from: n */
    private TrunkView f16439n;

    /* renamed from: o */
    private InterfaceC4683q f16440o;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f16440o = (InterfaceC4683q) m6162g();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f16439n = new TrunkView();
        this.f16440o = this.f16439n;
        return this.f16439n;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f16440o != null && !this.f16440o.mo17507a()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                onBackPressed();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.trunk.InterfaceC4659cq
    /* renamed from: a */
    public void mo3086a(String str, String str2, String str3, String str4, EnumC4642g enumC4642g, int i, boolean z) {
        Intent intent = new Intent();
        intent.setClass(this, TrunkPageActivity.class);
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNo", str2);
        intent.putExtra("itemId", str3);
        intent.putExtra("isvalid", z);
        startActivity(intent);
    }

    /* renamed from: h */
    public AbstractC4946a m17269h() {
        return m18784t();
    }
}
