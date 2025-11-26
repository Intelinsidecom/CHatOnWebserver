package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;
import twitter4j.Twitter;

/* loaded from: classes.dex */
public class TWFollowingsListActivity extends ListActivity {

    /* renamed from: x */
    private ImageView f5037x;

    /* renamed from: b */
    private static final String f5010b = TWFollowingsListActivity.class.getSimpleName();

    /* renamed from: B */
    private static String f5009B = null;

    /* renamed from: c */
    private ProgressDialog f5016c = null;

    /* renamed from: d */
    private Twitter f5017d = null;

    /* renamed from: e */
    private AsyncTaskC1386bn f5018e = null;

    /* renamed from: f */
    private ArrayList f5019f = new ArrayList();

    /* renamed from: g */
    private ArrayList f5020g = new ArrayList();

    /* renamed from: h */
    private ArrayList f5021h = new ArrayList();

    /* renamed from: i */
    private long[] f5022i = null;

    /* renamed from: j */
    private Context f5023j = null;

    /* renamed from: k */
    private long f5024k = -1;

    /* renamed from: l */
    private long f5025l = -1;

    /* renamed from: m */
    private int f5026m = 0;

    /* renamed from: n */
    private int f5027n = 0;

    /* renamed from: o */
    private int f5028o = 0;

    /* renamed from: p */
    private boolean f5029p = true;

    /* renamed from: q */
    private boolean f5030q = false;

    /* renamed from: r */
    private boolean f5031r = false;

    /* renamed from: s */
    private boolean f5032s = false;

    /* renamed from: t */
    private View f5033t = null;

    /* renamed from: u */
    private C1387bo f5034u = null;

    /* renamed from: v */
    private AsyncTaskC1391bs f5035v = null;

    /* renamed from: w */
    private AsyncTaskC1389bq f5036w = null;

    /* renamed from: y */
    private boolean f5038y = false;

    /* renamed from: z */
    private int f5039z = 0;

    /* renamed from: A */
    private int f5011A = 0;

    /* renamed from: C */
    private AsyncTaskC1384bl f5012C = null;

    /* renamed from: D */
    private AlertDialog f5013D = null;

    /* renamed from: E */
    private boolean f5014E = false;

    /* renamed from: a */
    Handler f5015a = new HandlerC1378bf(this);

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f5016c != null && this.f5016c.isShowing()) {
            this.f5016c.dismiss();
            this.f5016c = null;
        }
        if (this.f5018e != null) {
            this.f5018e.cancel(true);
            this.f5018e = null;
        }
        if (this.f5035v != null) {
            this.f5035v.cancel(true);
            this.f5035v = null;
        }
        if (this.f5012C != null) {
            this.f5012C.cancel(true);
            C1786r.m6063c("onDestroy() \t: Invite task was canceled.", getClass().getSimpleName());
            this.f5012C = null;
        }
        if (this.f5013D != null) {
            this.f5013D.dismiss();
            this.f5013D = null;
        }
        if (this.f5036w != null) {
            this.f5036w.cancel(true);
            this.f5036w = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f5016c != null && this.f5016c.isShowing()) {
            this.f5016c.dismiss();
            this.f5016c = null;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_tell_friends_via_list);
        this.f5023j = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_tellfriends_post_download, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tellfriends_post_download)).setText(getResources().getString(R.string.tellfriends_twitter_post));
        getListView().addHeaderView(viewInflate, null, false);
        this.f5033t = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.twitter_followings_list_header, (ViewGroup) null);
        getListView().addFooterView(this.f5033t);
        this.f5033t.setVisibility(8);
        getListView().setClickable(false);
        getListView().setFocusable(false);
        getListView().setFocusableInTouchMode(false);
        if (Build.VERSION.SDK_INT < 11) {
            this.f5014E = true;
        } else {
            this.f5014E = false;
        }
        this.f5037x = (ImageView) findViewById(R.id.footer_divider);
        this.f5037x.setVisibility(8);
        if (this.f5034u == null) {
            this.f5034u = new C1387bo(this, this.f5023j, R.layout.layout_tell_friends_via_cell, this.f5019f, this);
            this.f5034u.m5130b(this.f5026m);
            setListAdapter(this.f5034u);
            this.f5019f.clear();
            this.f5034u.notifyDataSetInvalidated();
        }
        C1376bd c1376bd = new C1376bd(this);
        ViewOnTouchListenerC1377be viewOnTouchListenerC1377be = new ViewOnTouchListenerC1377be(this);
        getListView().setOnScrollListener(c1376bd);
        getListView().setOnTouchListener(viewOnTouchListenerC1377be);
    }

    /* renamed from: a */
    public void m4924a() {
        this.f5019f = null;
        this.f5019f = new ArrayList();
        this.f5016c = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
        this.f5016c.setCancelable(false);
        this.f5016c.setOnKeyListener(new DialogInterfaceOnKeyListenerC1379bg(this));
        this.f5016c.show();
        this.f5016c.setOnDismissListener(new DialogInterfaceOnDismissListenerC1380bh(this));
        this.f5024k = -1L;
        m4925a(this.f5024k, true);
    }

    /* renamed from: b */
    public void m4927b() {
        this.f5027n++;
        if (this.f5022i.length < this.f5026m) {
            if (this.f5019f.size() == this.f5022i.length) {
                m4925a(this.f5025l, false);
                return;
            } else {
                m4926a(this.f5022i, false);
                return;
            }
        }
        if (this.f5022i.length == this.f5026m) {
            m4926a(this.f5022i, false);
        }
    }

    /* renamed from: a */
    public void m4926a(long[] jArr, boolean z) {
        this.f5031r = z;
        if (this.f5016c == null || (this.f5016c != null && !this.f5016c.isShowing())) {
            this.f5016c = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
            this.f5016c.setCancelable(false);
            this.f5016c.setOnKeyListener(new DialogInterfaceOnKeyListenerC1381bi(this));
            this.f5016c.show();
            this.f5016c.setOnDismissListener(new DialogInterfaceOnDismissListenerC1382bj(this));
        }
        if (this.f5018e != null) {
            this.f5016c.dismiss();
            this.f5016c = null;
        } else {
            this.f5018e = (AsyncTaskC1386bn) new AsyncTaskC1386bn(this).execute(this.f5022i);
        }
    }

    /* renamed from: a */
    public void m4925a(long j, boolean z) {
        long j2;
        this.f5024k = j;
        if (this.f5035v == null) {
            if (z) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            this.f5035v = (AsyncTaskC1391bs) new AsyncTaskC1391bs(this).execute(Long.valueOf(this.f5024k), Long.valueOf(j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4906f() {
        int iM3420a = C0809s.m3420a(this);
        if (-3 == iM3420a) {
            m4893b(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM3420a) {
            m4893b(getResources().getString(R.string.toast_network_unable));
        }
    }

    /* renamed from: b */
    private void m4893b(String str) {
        Toast.makeText(this, str, 0).show();
    }

    /* renamed from: c */
    public void m4928c() {
        this.f5035v = null;
        if (!this.f5038y) {
            if (this.f5033t.getVisibility() == 8) {
                this.f5033t.setVisibility(0);
            }
        } else {
            getListView().removeFooterView(this.f5033t);
        }
        this.f5037x.setVisibility(0);
        setSelection((this.f5028o - this.f5011A) + 2);
        if (this.f5016c != null && this.f5016c.isShowing()) {
            this.f5016c.dismiss();
            this.f5016c = null;
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4907g();
    }

    /* renamed from: g */
    private void m4907g() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
