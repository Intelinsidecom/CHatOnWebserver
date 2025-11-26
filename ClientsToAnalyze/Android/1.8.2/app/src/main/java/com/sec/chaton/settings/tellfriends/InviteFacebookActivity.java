package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.tellfriends.p046a.C1343a;
import com.sec.chaton.settings.tellfriends.p046a.C1345c;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class InviteFacebookActivity extends ListActivity {

    /* renamed from: a */
    public static C1374bb f4943a;

    /* renamed from: k */
    private static final String f4944k = InviteFacebookActivity.class.getSimpleName();

    /* renamed from: g */
    ImageView f4951g;

    /* renamed from: l */
    private String f4955l;

    /* renamed from: p */
    private boolean f4959p;

    /* renamed from: s */
    private Cursor f4962s;

    /* renamed from: t */
    private C1345c f4963t;

    /* renamed from: v */
    private LinearLayout f4965v;

    /* renamed from: z */
    private ProgressDialog f4969z;

    /* renamed from: b */
    public boolean f4946b = true;

    /* renamed from: c */
    int f4947c = 0;

    /* renamed from: d */
    int f4948d = 0;

    /* renamed from: e */
    int f4949e = 0;

    /* renamed from: f */
    Context f4950f = null;

    /* renamed from: m */
    private boolean f4956m = false;

    /* renamed from: n */
    private ArrayList f4957n = new ArrayList();

    /* renamed from: o */
    private ArrayList f4958o = new ArrayList();

    /* renamed from: q */
    private C1468q f4960q = null;

    /* renamed from: r */
    private C1343a f4961r = null;

    /* renamed from: u */
    private ArrayList f4964u = new ArrayList();

    /* renamed from: w */
    private InterfaceC1368aw f4966w = new C1462k(this);

    /* renamed from: x */
    private InterfaceC1371az f4967x = new C1463l(this);

    /* renamed from: y */
    private InterfaceC1370ay f4968y = new C1464m(this);

    /* renamed from: A */
    private AlertDialog f4945A = null;

    /* renamed from: h */
    int f4952h = 0;

    /* renamed from: i */
    int f4953i = 0;

    /* renamed from: j */
    Handler f4954j = new HandlerC1467p(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        C1461j c1461j = null;
        int i = 0;
        super.onCreate(bundle);
        setContentView(R.layout.layout_tell_friends_via_list);
        this.f4950f = this;
        this.f4955l = getIntent().getStringExtra("snsType");
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_tellfriends_post_download, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tellfriends_post_download);
        textView.setText(getResources().getString(R.string.tellfriends_facebook_post));
        textView.setTextColor(R.color.black);
        getListView().addHeaderView(viewInflate, null, false);
        getListView().setClickable(false);
        getListView().setFocusable(false);
        getListView().setItemsCanFocus(true);
        getListView().dispatchSetSelected(false);
        getListView().setFocusableInTouchMode(false);
        if (Build.VERSION.SDK_INT < 11) {
            this.f4956m = true;
        } else {
            this.f4956m = false;
        }
        this.f4951g = (ImageView) findViewById(R.id.footer_divider);
        this.f4951g.setVisibility(8);
        this.f4960q = new C1468q(this, this, i, this.f4957n, c1461j);
        setListAdapter(this.f4960q);
        this.f4960q.notifyDataSetInvalidated();
        if ("facebook".equals(this.f4955l)) {
            f4943a = new C1374bb(this);
        }
        getListView().setOnScrollListener(new C1461j(this));
        m4808e();
        try {
            m4799b();
        } catch (Exception e) {
            C1786r.m6054a("CheckFacebookInviteHistory() error : " + e.toString(), f4944k);
        }
        this.f4965v = (LinearLayout) findViewById(R.id.no_list_layout);
    }

    /* renamed from: b */
    private void m4799b() throws SQLException {
        C1786r.m6061b("CheckFacebookInviteHistory()", f4944k);
        String strM5125c = f4943a.m5125c();
        String string = null;
        C1786r.m6061b("userID : " + strM5125c, f4944k);
        if (this.f4961r == null) {
            C1786r.m6063c("mDbOpenHelper == null", f4944k);
            this.f4961r = new C1343a(this.f4950f);
            this.f4961r.m5072a();
            Cursor cursorM5076e = this.f4961r.m5076e();
            while (cursorM5076e.moveToNext()) {
                string = cursorM5076e.getString(cursorM5076e.getColumnIndex("uid"));
            }
            cursorM5076e.close();
            if (!strM5125c.equals(string)) {
                C1786r.m6063c("userID_temp is false", f4944k);
                this.f4961r.m5073b();
                this.f4961r.m5071a(strM5125c);
            }
            m4803c();
        }
    }

    /* renamed from: c */
    private void m4803c() {
        C1786r.m6061b("doWhileCursorToArray()", f4944k);
        this.f4964u.clear();
        this.f4962s = null;
        this.f4962s = this.f4961r.m5075d();
        while (this.f4962s.moveToNext()) {
            this.f4963t = new C1345c(this.f4962s.getInt(this.f4962s.getColumnIndex("_id")), this.f4962s.getString(this.f4962s.getColumnIndex("uid")), this.f4962s.getString(this.f4962s.getColumnIndex("name")));
            this.f4964u.add(this.f4963t);
        }
        this.f4962s.close();
    }

    /* renamed from: d */
    private void m4806d() {
        if (this.f4961r != null) {
            this.f4961r.m5074c();
            this.f4961r = null;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        m4806d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4794a(int i) {
        if (this.f4958o.size() > i) {
            C1471t c1471t = (C1471t) this.f4958o.get(i);
            C1373ba c1373ba = (C1373ba) this.f4957n.get(i);
            if (c1373ba.f5205d == null) {
                m4796a(c1373ba.f5204c.toString(), c1471t.f5383b, Integer.toString(i));
                this.f4952h++;
            } else {
                c1471t.f5383b.setBackgroundDrawable(c1373ba.f5205d);
            }
        }
    }

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        f4943a.m5119a();
        m4810f();
        m4806d();
    }

    /* renamed from: a */
    private void m4796a(String str, ImageView imageView, String str2) {
        AsyncTaskC1470s asyncTaskC1470s = new AsyncTaskC1470s(this);
        if (this.f4956m) {
            asyncTaskC1470s.execute(str, imageView, str2);
        } else {
            asyncTaskC1470s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str, imageView, str2);
        }
    }

    /* renamed from: e */
    private void m4808e() {
        m4801b(true);
        f4943a.m5120a(this.f4966w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4810f() {
        m4815i();
        m4813h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4797a(boolean z) {
        if (this.f4945A == null) {
            this.f4945A = new AlertDialogBuilderC2120a(this).setTitle(getResources().getString(R.string.toast_error)).setMessage(getResources().getString(R.string.toast_network_unable)).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1465n(this)).create();
        }
        this.f4945A.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4811g() {
        m4797a(true);
    }

    /* renamed from: h */
    private void m4813h() {
        if (this.f4945A != null && this.f4945A.isShowing()) {
            this.f4945A.dismiss();
            this.f4945A = null;
        }
    }

    /* renamed from: b */
    private void m4801b(boolean z) {
        C1786r.m6054a("showProgressDialog()", f4944k);
        if (this.f4969z == null) {
            C1786r.m6054a("showProgressDialog() \t- null, create and show", f4944k);
            this.f4969z = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
            this.f4969z.setCancelable(z);
            this.f4969z.setCanceledOnTouchOutside(false);
            this.f4969z.setOnCancelListener(new DialogInterfaceOnCancelListenerC1466o(this));
        } else {
            C1786r.m6054a("showProgressDialog() \t- not null. show", f4944k);
        }
        this.f4969z.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4815i() {
        C1786r.m6054a("dismissProgressDialog() \t- mProgressDialog : " + this.f4969z, f4944k);
        if (this.f4969z != null) {
            this.f4969z.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        f4943a.mo5102a(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
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
