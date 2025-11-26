package com.sec.chaton.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3226cn;
import com.sec.common.actionbar.ActionBarPreferenceActivity;

/* loaded from: classes.dex */
public class BasePreferenceActivity extends ActionBarPreferenceActivity implements InterfaceC3226cn {
    private static final String TAG = BasePreferenceActivity.class.getSimpleName();

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 11) {
            ListView listView = getListView();
            ViewGroup viewGroup = (ViewGroup) getListView().getParent();
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            listView.setPadding(0, 0, 0, 0);
            viewGroup.setPadding(0, 0, 0, 0);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
                if (GlobalApplication.m6456e() && Build.VERSION.SDK_INT >= 17) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
                }
            }
            if (GlobalApplication.m6456e()) {
                viewGroup.setBackgroundColor(0);
                listView.setCacheColorHint(0);
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        showPasswordLockActivity();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onUserLeaveHint", TAG);
        }
        C3241p.m11402b(getApplicationContext());
    }

    private void showPasswordLockActivity() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", TAG);
        }
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Setting;
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Black_Setting;
    }
}
