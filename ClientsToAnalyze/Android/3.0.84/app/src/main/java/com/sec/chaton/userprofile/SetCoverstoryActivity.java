package com.sec.chaton.userprofile;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MenuItem;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class SetCoverstoryActivity extends BaseSinglePaneActivity implements InterfaceC3133ce {

    /* renamed from: a */
    private static final String f11266a = SetCoverstoryActivity.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SetCoverstoryFragment mo1193a() {
        String string;
        String string2;
        String string3 = null;
        boolean z = false;
        if (getIntent().getExtras() != null) {
            string2 = getIntent().getExtras().getString("url");
            string = getIntent().getExtras().getString("filename");
            string3 = getIntent().getExtras().getString("id");
            z = getIntent().getExtras().getBoolean("is_current_coverstory");
            if (C3250y.f11734b && string != null) {
                C3250y.m11450b("onCreatePane() url : " + string2 + ", filename : " + string + ", id : " + string3, getClass().getSimpleName());
            }
        } else {
            string = null;
            string2 = null;
        }
        return new SetCoverstoryFragment(string2, string, string3, z);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3133ce
    /* renamed from: d */
    public void mo10874d() {
        Intent intentM1226a = TabActivity.m1226a(getApplicationContext());
        intentM1226a.putExtra("callMyPageTab", true);
        startActivity(intentM1226a);
        finish();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }
}
