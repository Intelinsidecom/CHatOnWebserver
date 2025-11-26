package com.sec.chaton.userprofile;

import android.R;
import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class CoverstorySampleActivity extends BaseSinglePaneActivity implements InterfaceC4796o {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public CoverstorySampleFragment mo2967f() {
        return new CoverstorySampleFragment();
    }

    @Override // com.sec.chaton.userprofile.InterfaceC4796o
    /* renamed from: a */
    public void mo17805a(String str, String str2, String str3) {
        C4904y.m18639b(" CoverstorySampleActivity [url] : " + str + " [filename] : " + str2 + " [id] : " + str3, "CoverstorySampleActivity");
        if (str2 == null) {
            str2 = m17804b(str);
        }
        Intent intent = new Intent(this, (Class<?>) SetCoverstoryActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("filename", str2);
        intent.putExtra("id", str3);
        if (C4809aa.m18104a().m18121a("coverstory_contentid", "").compareTo(str3) == 0) {
            intent.putExtra("is_current_coverstory", true);
        } else {
            intent.putExtra("is_current_coverstory", false);
        }
        startActivity(intent);
    }

    /* renamed from: b */
    private static String m17804b(String str) {
        String str2;
        String str3 = null;
        if (str != null && str.length() > 0) {
            String[] strArrSplit = str.split("/");
            if (strArrSplit.length > 0) {
                str2 = strArrSplit[strArrSplit.length - 1];
                if (C4904y.f17871a) {
                    C4904y.m18646e("filestr: " + str2, "CoverstorySampleActivity");
                }
            } else {
                str2 = null;
            }
            if (str2 != null) {
                String[] strArrSplit2 = str2.split("\\?");
                if (strArrSplit2.length > 0) {
                    str3 = strArrSplit2[0];
                    if (C4904y.f17871a) {
                        C4904y.m18646e("fileName: " + str3, "CoverstorySampleActivity");
                    }
                }
            }
        }
        return str3;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        C4904y.m18646e("onSupportOptionsItemSelected item.getItemId() : " + menuItem.getItemId(), getClass().getSimpleName());
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
