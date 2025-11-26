package com.sec.chaton.settings;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.util.InterfaceC4876cn;
import com.sec.common.actionbar.ActionBarPreferenceActivity;

/* loaded from: classes.dex */
public class BasePreferenceActivity extends ActionBarPreferenceActivity implements InterfaceC4876cn {
    private static final String TAG = BasePreferenceActivity.class.getSimpleName();

    @Override // com.sec.common.actionbar.ActionBarPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 11) {
            ListView listView = getListView();
            ViewGroup viewGroup = (ViewGroup) getListView().getParent();
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            listView.setPadding(0, 0, 0, 0);
            viewGroup.setPadding(0, 0, 0, 0);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            }
            viewGroup.setBackgroundColor(0);
            listView.setCacheColorHint(0);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        C1059a.m6163a(this);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C1059a.m6170f(this);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1059a.m6167c(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onPause();
        C1059a.m6166b(this);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        C1059a.m6168d(this);
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1059a.m6171g(this);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1059a.m6169e(this);
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Setting;
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_Setting;
    }
}
