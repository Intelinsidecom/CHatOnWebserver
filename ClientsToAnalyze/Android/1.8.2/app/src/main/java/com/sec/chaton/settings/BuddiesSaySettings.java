package com.sec.chaton.settings;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0240a;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.InterfaceC0302bn;
import com.sec.chaton.chat.InterfaceC0454a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddiesSaySettings extends BaseMultiPaneActivity implements InterfaceC0302bn {

    /* renamed from: a */
    public static final String f4573a = BuddiesSaySettings.class.getSimpleName();

    /* renamed from: b */
    final String f4574b;

    /* renamed from: c */
    private InterfaceC0454a f4575c;

    /* renamed from: d */
    private BuddyFragment f4576d;

    /* renamed from: e */
    private InterfaceC0302bn f4577e;

    /* renamed from: i */
    private Context f4578i;

    /* renamed from: j */
    private C0638j f4579j;

    /* renamed from: k */
    private ArrayList f4580k;

    /* renamed from: l */
    private ArrayList f4581l;

    /* renamed from: m */
    private ProgressDialog f4582m;

    /* renamed from: n */
    private boolean f4583n;

    /* renamed from: o */
    private Handler f4584o;

    public BuddiesSaySettings() {
        this.f4574b = C1767bw.m6002a() ? GlobalApplication.m3256a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
        this.f4580k = new ArrayList();
        this.f4581l = new ArrayList();
        this.f4584o = new HandlerC1262bn(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_buddy_select);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        this.f4578i = this;
        this.f4579j = new C0638j(this.f4584o);
        this.f4579j.m2895a();
        this.f4582m = ProgressDialogC1806j.m6141a(this.f4578i, null, getResources().getString(R.string.wait_sending), true);
        this.f4582m.setCancelable(true);
        this.f4582m.setCanceledOnTouchOutside(false);
        this.f4582m.setOnCancelListener(new DialogInterfaceOnCancelListenerC1261bm(this));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws NumberFormatException {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                return true;
            case R.id.actionbar_title_change /* 2131494129 */:
            default:
                return super.onOptionsItemSelected(menuItem);
            case R.id.actionbar_title_done /* 2131494130 */:
                this.f4576d.m2054k();
                return true;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f4575c == null || this.f4575c.isBackKeyIgnore()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0240a mo608a(String str) {
        return super.mo608a(str);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0302bn
    /* renamed from: a */
    public void mo2228a() {
    }

    @Override // com.sec.chaton.buddy.InterfaceC0302bn
    /* renamed from: b */
    public void mo2229b() {
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f4579j != null) {
            this.f4579j.m2901b();
            this.f4579j.m2903c();
        }
    }
}
