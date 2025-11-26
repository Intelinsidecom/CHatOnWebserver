package com.sec.chaton.block;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BlockActivity extends BaseMultiPaneActivity {

    /* renamed from: a */
    static boolean f780a = false;

    /* renamed from: b */
    static ProgressDialog f781b;

    /* renamed from: e */
    BlockFragment f784e;

    /* renamed from: k */
    private ListView f787k;

    /* renamed from: l */
    private ArrayList f788l;

    /* renamed from: m */
    private C0632d f789m;

    /* renamed from: n */
    private C0245e f790n;

    /* renamed from: o */
    private LinearLayout f791o;

    /* renamed from: p */
    private boolean f792p;

    /* renamed from: q */
    private boolean f793q;

    /* renamed from: r */
    private C0632d f794r;

    /* renamed from: c */
    Dialog f782c = null;

    /* renamed from: d */
    ArrayList f783d = new ArrayList();

    /* renamed from: i */
    public Handler f785i = new HandlerC0243c(this);

    /* renamed from: j */
    Handler f786j = new HandlerC0244d(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        setTitle(R.string.settings_blocked);
        setContentView(R.layout.layout_blocked);
        this.f788l = new ArrayList();
        this.f784e = new BlockFragment();
        f781b = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
        f781b.setCancelable(true);
        f781b.setCanceledOnTouchOutside(false);
        this.f791o = (LinearLayout) findViewById(R.id.no_item_layout);
        this.f790n = new C0245e(this, R.layout.layout_blocked, this.f788l, this.f791o, true);
        this.f789m = new C0632d(this.f785i);
        this.f789m.m2844a();
        f781b.show();
        f781b.setOnCancelListener(new DialogInterfaceOnCancelListenerC0241a(this));
        this.f787k = (ListView) findViewById(R.id.list);
        this.f787k.setAdapter((ListAdapter) this.f790n);
        this.f787k.setOnItemClickListener(new C0242b(this));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.clear();
        getMenuInflater().inflate(R.menu.actionbar_menu_done_cancel, menu);
        menu.removeItem(R.id.actionbar_menu_delete_group);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.actionbar_menu_done).setEnabled(this.f793q);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
            case R.id.actionbar_menu_cancel /* 2131494122 */:
                finish();
                break;
            case R.id.actionbar_menu_done /* 2131494123 */:
                Iterator it = this.f788l.iterator();
                while (it.hasNext()) {
                    C0253m c0253m = (C0253m) it.next();
                    if (c0253m.f840e) {
                        this.f783d.add(c0253m.f837b);
                    }
                }
                this.f794r = new C0632d(this.f786j);
                this.f794r.m2848a(this.f783d);
                f781b.setCancelable(false);
                f781b.show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1839a() {
        if (this.f788l != null) {
            Iterator it = this.f788l.iterator();
            int i = 0;
            while (it.hasNext()) {
                i = ((C0253m) it.next()).f840e ? i + 1 : i;
            }
            this.f793q = i > 0;
            invalidateOptionsMenu();
        }
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
}
