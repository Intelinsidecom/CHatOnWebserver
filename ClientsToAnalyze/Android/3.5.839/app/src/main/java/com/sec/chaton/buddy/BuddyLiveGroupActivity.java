package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class BuddyLiveGroupActivity extends BaseSinglePaneActivity implements InterfaceC1261dv {

    /* renamed from: n */
    int f3881n = 0;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new BuddyLiveGroupFragment();
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: a */
    public void mo6198a(int i) throws Resources.NotFoundException {
        m6735c(i);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: b */
    public void mo6199b(int i) throws Resources.NotFoundException {
        this.f3881n = i;
        String string = getResources().getString(R.string.specialbuddy_livegroup_followers);
        if (string != null) {
            if (i >= 0) {
                string = string + " (" + i + ")";
            }
            setTitle(string);
        }
    }

    /* renamed from: c */
    private void m6735c(int i) throws Resources.NotFoundException {
        C4904y.m18639b("setTitleView() : " + i, getClass().getSimpleName());
        if (getIntent().getIntExtra("ACTIVITY_PURPOSE", 1) == 23) {
            if (i != 0) {
                String string = getString(R.string.buddy_select);
                if (string != null) {
                    if (i >= 0) {
                        string = string + " (" + i + ")";
                    }
                    setTitle(string);
                    return;
                }
                return;
            }
            setTitle(getResources().getString(R.string.specialbuddy_livegroup_followers) + " (" + this.f3881n + ")");
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m6159a(this);
    }
}
