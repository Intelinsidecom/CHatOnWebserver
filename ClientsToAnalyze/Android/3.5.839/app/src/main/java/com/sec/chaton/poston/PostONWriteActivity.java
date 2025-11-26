package com.sec.chaton.poston;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.userprofile.MyPageFragment;

/* loaded from: classes.dex */
public class PostONWriteActivity extends BaseSinglePaneActivity implements InterfaceC3005bw {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new PostONWriteFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (((InterfaceC2984bb) m6162g()).mo12346a()) {
                return super.onKeyDown(i, keyEvent);
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.sec.chaton.poston.InterfaceC3005bw
    /* renamed from: a */
    public void mo12287a(boolean z, String str, String str2, String str3) {
        Intent intent;
        if (z) {
            intent = new Intent(this, (Class<?>) MyPageFragment.class);
        } else {
            intent = new Intent(this, (Class<?>) BuddyProfileFragment.class);
        }
        intent.putExtra("HAS_MORE", str);
        intent.putExtra("END_TIME", str2);
        intent.putExtra("IS_BLIND", str3);
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.poston.InterfaceC3005bw
    /* renamed from: h */
    public void mo12288h() {
        finish();
    }
}
