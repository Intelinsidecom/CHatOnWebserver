package com.sec.chaton.shop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.log.collector.C5043h;

/* loaded from: classes.dex */
public class ChatONShopActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    static final String f13328n = BaseSinglePaneActivity.class.getSimpleName();

    /* renamed from: o */
    private InterfaceC1061c f13329o;

    /* renamed from: p */
    private boolean f13330p = false;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        ChatONShopFragment chatONShopFragment = new ChatONShopFragment();
        if (chatONShopFragment instanceof InterfaceC1061c) {
            this.f13329o = chatONShopFragment;
        }
        C5043h.m19179a().m19185a("4000", "2105", false);
        return chatONShopFragment;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.f13330p = true;
        super.onStop();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        this.f13330p = false;
        super.onStart();
    }

    /* renamed from: h */
    public boolean m13974h() {
        return this.f13330p;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f13329o = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        boolean zOnBackKeyPressed = false;
        if (this.f13329o != null) {
            zOnBackKeyPressed = this.f13329o.onBackKeyPressed();
        }
        if (!zOnBackKeyPressed) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C4904y.m18639b("onCreate()", getClass().getSimpleName());
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setTitle(R.string.more_chaton_shop_name);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
