package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.shop.ChatONShopActivity;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class ActivityFontChange extends BaseSinglePaneActivity implements InterfaceC3598eh {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new FragmentFontChange();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_download) {
            Intent intent = new Intent(CommonApplication.m18732r(), (Class<?>) ChatONShopActivity.class);
            intent.putExtra("page_name", 2);
            intent.putExtra("category_id", 3L);
            startActivity(intent);
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_cancel) {
            finish();
            return true;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.settings.InterfaceC3598eh
    /* renamed from: h */
    public void mo13390h() {
        finish();
    }
}
