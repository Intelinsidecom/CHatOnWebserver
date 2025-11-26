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
import java.net.URL;
import java.util.ArrayList;
import weibo4android.Weibo;

/* loaded from: classes.dex */
public class TellFriendsWeiboActivity extends ListActivity {

    /* renamed from: H */
    private long f5055H;

    /* renamed from: y */
    private ImageView f5079y;

    /* renamed from: b */
    private static final String f5049b = TellFriendsWeiboActivity.class.getSimpleName();

    /* renamed from: C */
    private static String f5047C = null;

    /* renamed from: D */
    private static URL f5048D = null;

    /* renamed from: c */
    private ProgressDialog f5057c = null;

    /* renamed from: d */
    private Weibo f5058d = null;

    /* renamed from: e */
    private AsyncTaskC1414co f5059e = null;

    /* renamed from: f */
    private ArrayList f5060f = new ArrayList();

    /* renamed from: g */
    private ArrayList f5061g = new ArrayList();

    /* renamed from: h */
    private ArrayList f5062h = new ArrayList();

    /* renamed from: i */
    private long[] f5063i = null;

    /* renamed from: j */
    private long[] f5064j = null;

    /* renamed from: k */
    private Context f5065k = null;

    /* renamed from: l */
    private long f5066l = -1;

    /* renamed from: m */
    private long f5067m = -1;

    /* renamed from: n */
    private int f5068n = 0;

    /* renamed from: o */
    private int f5069o = 0;

    /* renamed from: p */
    private int f5070p = 0;

    /* renamed from: q */
    private boolean f5071q = true;

    /* renamed from: r */
    private boolean f5072r = false;

    /* renamed from: s */
    private boolean f5073s = false;

    /* renamed from: t */
    private boolean f5074t = false;

    /* renamed from: u */
    private View f5075u = null;

    /* renamed from: v */
    private C1418cs f5076v = null;

    /* renamed from: w */
    private AsyncTaskC1420cu f5077w = null;

    /* renamed from: x */
    private AsyncTaskC1415cp f5078x = null;

    /* renamed from: z */
    private boolean f5080z = false;

    /* renamed from: A */
    private int f5050A = 0;

    /* renamed from: B */
    private int f5051B = 0;

    /* renamed from: E */
    private AsyncTaskC1412cm f5052E = null;

    /* renamed from: F */
    private AlertDialog f5053F = null;

    /* renamed from: G */
    private boolean f5054G = false;

    /* renamed from: a */
    Handler f5056a = new HandlerC1407ch(this);

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f5057c != null && this.f5057c.isShowing()) {
            this.f5057c.dismiss();
            this.f5057c = null;
        }
        if (this.f5059e != null) {
            this.f5059e.cancel(true);
            this.f5059e = null;
        }
        if (this.f5077w != null) {
            this.f5077w.cancel(true);
            this.f5077w = null;
        }
        if (this.f5052E != null) {
            this.f5052E.cancel(true);
            C1786r.m6063c("onDestroy() \t: Invite task was canceled.", getClass().getSimpleName());
            this.f5052E = null;
        }
        if (this.f5053F != null) {
            this.f5053F.dismiss();
            this.f5053F = null;
        }
        if (this.f5078x != null) {
            this.f5078x.cancel(true);
            this.f5078x = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f5057c != null && this.f5057c.isShowing()) {
            this.f5057c.dismiss();
            this.f5057c = null;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_tell_friends_via_list);
        this.f5065k = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_tellfriends_post_download, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tellfriends_post_download)).setText(getResources().getString(R.string.tellfriends_weibo_post));
        getListView().addHeaderView(viewInflate, null, false);
        this.f5075u = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.twitter_followings_list_header, (ViewGroup) null);
        getListView().addFooterView(this.f5075u);
        this.f5075u.setVisibility(8);
        getListView().setClickable(false);
        getListView().setFocusable(false);
        getListView().setFocusableInTouchMode(false);
        if (Build.VERSION.SDK_INT < 11) {
            this.f5054G = true;
        } else {
            this.f5054G = false;
        }
        this.f5079y = (ImageView) findViewById(R.id.footer_divider);
        this.f5079y.setVisibility(8);
        if (this.f5076v == null) {
            this.f5076v = new C1418cs(this, this.f5065k, R.layout.layout_tell_friends_via_cell, this.f5060f, this);
            this.f5076v.m5155b(this.f5068n);
            setListAdapter(this.f5076v);
            this.f5060f.clear();
            this.f5076v.notifyDataSetInvalidated();
        }
        C1405cf c1405cf = new C1405cf(this);
        ViewOnTouchListenerC1406cg viewOnTouchListenerC1406cg = new ViewOnTouchListenerC1406cg(this);
        getListView().setOnScrollListener(c1405cf);
        getListView().setOnTouchListener(viewOnTouchListenerC1406cg);
    }

    /* renamed from: a */
    public void m4989a() {
        this.f5060f = null;
        this.f5060f = new ArrayList();
        this.f5057c = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
        this.f5057c.setCancelable(false);
        this.f5057c.setOnKeyListener(new DialogInterfaceOnKeyListenerC1408ci(this));
        this.f5057c.show();
        this.f5057c.setOnDismissListener(new DialogInterfaceOnDismissListenerC1409cj(this));
        this.f5066l = -1L;
        m4990a(this.f5066l, true);
    }

    /* renamed from: b */
    public void m4992b() {
        this.f5069o++;
        if (this.f5063i.length < this.f5068n) {
            m4991a(this.f5063i, false);
        } else if (this.f5063i.length == this.f5068n) {
            m4991a(this.f5063i, false);
        }
    }

    /* renamed from: a */
    public void m4991a(long[] jArr, boolean z) {
        this.f5073s = z;
        if (this.f5057c == null || (this.f5057c != null && !this.f5057c.isShowing())) {
            this.f5057c = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
            this.f5057c.setCancelable(false);
            this.f5057c.setOnKeyListener(new DialogInterfaceOnKeyListenerC1410ck(this));
            this.f5057c.show();
            this.f5057c.setOnDismissListener(new DialogInterfaceOnDismissListenerC1411cl(this));
        }
        if (this.f5059e != null) {
            this.f5057c.dismiss();
            this.f5057c = null;
        } else {
            this.f5059e = (AsyncTaskC1414co) new AsyncTaskC1414co(this).execute(this.f5063i);
        }
    }

    /* renamed from: a */
    public void m4990a(long j, boolean z) {
        long j2;
        this.f5066l = j;
        if (this.f5077w == null) {
            if (z) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            this.f5077w = (AsyncTaskC1420cu) new AsyncTaskC1420cu(this).execute(Long.valueOf(this.f5066l), Long.valueOf(j2));
        }
    }

    /* renamed from: a */
    private void m4947a(boolean z) {
        int iM3420a = C0809s.m3420a(this);
        if (-3 == iM3420a) {
            m4953b(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM3420a) {
            m4953b(getResources().getString(R.string.toast_network_unable));
        }
    }

    /* renamed from: b */
    private void m4953b(String str) {
        Toast.makeText(this, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4968g() {
        m4947a(true);
    }

    /* renamed from: c */
    public void m4993c() {
        this.f5077w = null;
        if (!this.f5080z) {
            if (this.f5075u.getVisibility() == 8) {
                this.f5075u.setVisibility(0);
            }
        } else {
            getListView().removeFooterView(this.f5075u);
        }
        this.f5079y.setVisibility(0);
        setSelection((this.f5070p - this.f5051B) + 2);
        if (this.f5057c != null && this.f5057c.isShowing()) {
            this.f5057c.dismiss();
            this.f5057c = null;
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
        m4971h();
    }

    /* renamed from: h */
    private void m4971h() {
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
            actionBar.setTitle(R.string.tellfriends_via_weibo);
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
