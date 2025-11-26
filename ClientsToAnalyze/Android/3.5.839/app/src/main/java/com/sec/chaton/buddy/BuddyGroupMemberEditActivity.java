package com.sec.chaton.buddy;

import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class BuddyGroupMemberEditActivity extends BaseSinglePaneActivity implements InterfaceC1261dv {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new BuddyGroupMemberEditFragment();
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: a */
    public void mo6198a(int i) {
        m6612c(i);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: b */
    public void mo6199b(int i) {
    }

    /* renamed from: c */
    private void m6612c(int i) {
        C4904y.m18639b("setTitleView() : " + i, getClass().getSimpleName());
        String string = null;
        if (getIntent().getIntExtra("ACTIVITY_PURPOSE", 1) == 19) {
            string = getString(R.string.buddy_selected);
        }
        if (string != null) {
            if (i >= 0) {
                string = string + " (" + i + ")";
            }
            setTitle(string);
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m6159a(this);
    }
}
