package com.sec.chaton.userprofile;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class CoverstorySampleActivity extends BaseSinglePaneActivity implements InterfaceC3151t {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public CoverstorySampleFragment mo1193a() {
        return new CoverstorySampleFragment();
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3151t
    /* renamed from: a */
    public void mo10651a(String str, String str2, String str3) {
        C3250y.m11450b(" CoverstorySampleActivity [url] : " + str + " [filename] : " + str2 + " [id] : " + str3, "CoverstorySampleActivity");
        if (str2 == null) {
            str2 = m10650a(str);
        }
        Intent intent = new Intent(this, (Class<?>) SetCoverstoryActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("filename", str2);
        intent.putExtra("id", str3);
        if (C3159aa.m10962a().m10979a("coverstory_contentid", "").compareTo(str3) == 0) {
            intent.putExtra("is_current_coverstory", true);
        } else {
            intent.putExtra("is_current_coverstory", false);
        }
        startActivity(intent);
    }

    /* renamed from: a */
    private static String m10650a(String str) {
        String str2;
        String str3 = null;
        if (str != null && str.length() > 0) {
            String[] strArrSplit = str.split("/");
            if (strArrSplit.length > 0) {
                str2 = strArrSplit[strArrSplit.length - 1];
                if (C3250y.f11733a) {
                    C3250y.m11456e("filestr: " + str2, "CoverstorySampleActivity");
                }
            } else {
                str2 = null;
            }
            if (str2 != null) {
                String[] strArrSplit2 = str2.split("\\?");
                if (strArrSplit2.length > 0) {
                    str3 = strArrSplit2[0];
                    if (C3250y.f11733a) {
                        C3250y.m11456e("fileName: " + str3, "CoverstorySampleActivity");
                    }
                }
            }
        }
        return str3;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        C3250y.m11456e(" Kmission onSupportOptionsItemSelected item.getItemId() : " + menuItem.getItemId(), getClass().getSimpleName());
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }
}
