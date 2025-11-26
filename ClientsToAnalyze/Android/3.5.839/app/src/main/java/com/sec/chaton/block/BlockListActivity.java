package com.sec.chaton.block;

import android.R;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.InterfaceC1261dv;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class BlockListActivity extends BaseSinglePaneActivity implements InterfaceC1261dv {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new BlockListFragment();
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

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: a */
    public void mo6198a(int i) {
        m6197c(i);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: b */
    public void mo6199b(int i) {
    }

    /* renamed from: c */
    private void m6197c(int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("setTitleView() : " + i, getClass().getSimpleName());
        }
        String string = getString(com.sec.chaton.R.string.buddy_select);
        if (string != null) {
            if (i >= 0) {
                string = string + " (" + i + ")";
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("setTitleView() : " + string, getClass().getSimpleName());
            }
            setTitle(string);
        }
    }
}
