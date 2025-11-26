package com.sec.chaton.userprofile;

import android.R;
import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class SetCoverstoryActivity extends BaseSinglePaneActivity implements InterfaceC4783co {

    /* renamed from: n */
    private static final String f17358n = SetCoverstoryActivity.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public SetCoverstoryFragment mo2967f() {
        String string;
        String string2;
        String string3 = null;
        boolean z = false;
        if (getIntent().getExtras() != null) {
            string2 = getIntent().getExtras().getString("url");
            string = getIntent().getExtras().getString("filename");
            string3 = getIntent().getExtras().getString("id");
            z = getIntent().getExtras().getBoolean("is_current_coverstory");
            if (C4904y.f17872b && string != null) {
                C4904y.m18639b("onCreatePane() url : " + string2 + ", filename : " + string + ", id : " + string3, getClass().getSimpleName());
            }
        } else {
            string = null;
            string2 = null;
        }
        return new SetCoverstoryFragment(string2, string, string3, z);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.userprofile.InterfaceC4783co
    /* renamed from: i */
    public void mo18030i() {
        Intent intentM3014a = TabActivity.m3014a(getApplicationContext());
        intentM3014a.putExtra("callMyPageTab", true);
        startActivity(intentM3014a);
        finish();
    }
}
