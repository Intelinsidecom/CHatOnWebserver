package com.sec.vip.amschaton;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import com.sec.vip.amschaton.fragment.AMSComposerFragment;
import com.sec.vip.amschaton.fragment.AMSFragment;
import com.sec.vip.amschaton.fragment.AMSListFragment;
import com.sec.vip.amschaton.fragment.AMSPlayerFragment;
import com.sec.vip.amschaton.fragment.AMSPreviewFragment;
import com.sec.vip.amschaton.fragment.InterfaceC3474av;

/* loaded from: classes.dex */
public class BaseAMSActivity extends BaseSinglePaneActivity implements InterfaceC3474av {

    /* renamed from: a */
    private int f12355a;

    /* renamed from: c */
    private Fragment m12073c(Intent intent) {
        Fragment aMSComposerFragment = null;
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras == null) {
            this.f12355a = 0;
            aMSComposerFragment = new AMSListFragment();
        } else {
            int i = extras.getInt("AMS_ACTION", -1);
            if (i == 5) {
                switch (this.f12355a) {
                    case 0:
                    case 4:
                        finish();
                        break;
                    case 1:
                    case 3:
                    default:
                        this.f12355a = 0;
                        aMSComposerFragment = new AMSListFragment();
                        break;
                    case 2:
                        aMSComposerFragment = new AMSComposerFragment();
                        break;
                }
            } else {
                this.f12355a = i;
                switch (this.f12355a) {
                    case 0:
                        aMSComposerFragment = new AMSListFragment();
                        break;
                    case 1:
                    case 2:
                        aMSComposerFragment = new AMSPreviewFragment();
                        break;
                    case 3:
                        aMSComposerFragment = new AMSComposerFragment();
                        break;
                    case 4:
                        aMSComposerFragment = new AMSPlayerFragment();
                        break;
                    case 5:
                        break;
                    default:
                        this.f12355a = 0;
                        aMSComposerFragment = new AMSListFragment();
                        break;
                }
            }
        }
        if (aMSComposerFragment != null) {
            aMSComposerFragment.setArguments(m3082b(intent));
        }
        return aMSComposerFragment;
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return m12073c(getIntent());
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        int i = -1;
        super.onResume();
        if (GlobalApplication.m6456e()) {
            Resources resources = CommonApplication.m11493l().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ams_layout_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ams_layout_height);
            if (resources.getConfiguration().orientation != 1) {
                dimensionPixelSize2 = -1;
                i = dimensionPixelSize;
            }
            getWindow().setLayout(i, dimensionPixelSize2);
        }
    }

    /* renamed from: a */
    private void m12072a(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_controller, fragment, "com.sec.chaton:single_pane_fragment").commit();
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f12355a != 4) {
            Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            intent.putExtra("ACTION", 2006);
            startActivity(intent);
        }
        super.finish();
    }

    @Override // com.sec.chaton.base.BaseActivity
    /* renamed from: a */
    public void mo3084a(Intent intent) {
        if (intent.getIntExtra("AMS_ACTION", -1) > -1) {
            Fragment fragmentM12073c = m12073c(intent);
            if (fragmentM12073c != null) {
                m12072a(fragmentM12073c);
                return;
            }
            return;
        }
        super.mo3084a(intent);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        boolean zOnSupportOptionsItemSelected = super.onSupportOptionsItemSelected(menuItem);
        if (!zOnSupportOptionsItemSelected && menuItem.getItemId() == 16908332) {
            ((AMSFragment) m3089b()).mo12415c();
            zOnSupportOptionsItemSelected = true;
        }
        supportInvalidateOptionsMenu();
        return zOnSupportOptionsItemSelected;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        ((AMSFragment) m3089b()).mo12415c();
        supportInvalidateOptionsMenu();
    }

    @Override // com.sec.vip.amschaton.fragment.InterfaceC3474av
    /* renamed from: c */
    public void mo11978c() {
        finish();
    }
}
