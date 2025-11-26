package com.sec.chaton.specialbuddy;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0672p;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import com.sec.widget.DropPanelMenu;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpecialBuddyInfo extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    Context f5404a;

    /* renamed from: e */
    DropPanelMenu f5408e;

    /* renamed from: i */
    ProfileImageView f5409i;

    /* renamed from: j */
    TextView f5410j;

    /* renamed from: k */
    String f5411k;

    /* renamed from: l */
    String f5412l;

    /* renamed from: m */
    String f5413m;

    /* renamed from: q */
    private ListView f5417q;

    /* renamed from: r */
    private C1798b f5418r;

    /* renamed from: t */
    private C1797a f5420t;

    /* renamed from: b */
    Button f5405b = null;

    /* renamed from: c */
    Button f5406c = null;

    /* renamed from: d */
    CheckBox f5407d = null;

    /* renamed from: s */
    private ArrayList f5419s = new ArrayList();

    /* renamed from: u */
    private ProgressDialogC1806j f5421u = null;

    /* renamed from: n */
    InterfaceC0677d f5414n = new C1508e(this);

    /* renamed from: o */
    Handler f5415o = new HandlerC1509f(this);

    /* renamed from: p */
    AdapterView.OnItemSelectedListener f5416p = new C1510g(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5404a = this;
        setContentView(R.layout.layout_special_buddy_info);
        this.f5405b = (Button) findViewById(R.id.spbd_profile_block_button);
        if (this.f5405b != null) {
            this.f5405b.setOnClickListener(this);
        }
        this.f5406c = (Button) findViewById(R.id.spbd_profile_unblock_button);
        if (this.f5406c != null) {
            this.f5406c.setOnClickListener(this);
        }
        this.f5407d = (CheckBox) findViewById(R.id.spbd_alert_check);
        if (this.f5407d != null) {
            this.f5407d.setOnClickListener(this);
        }
        this.f5408e = new DropPanelMenu(this);
        this.f5420t = new C1797a(getResources().getString(R.string.chat_view_menu_close), R.drawable.close_chat);
        this.f5419s.add(this.f5420t);
        Intent intent = getIntent();
        this.f5411k = intent.getStringExtra("buddy_no");
        this.f5412l = intent.getStringExtra("buddy_name");
        this.f5413m = intent.getStringExtra("inbox_no");
        this.f5409i = (ProfileImageView) findViewById(R.id.spbd_profile_image);
        C1746bb.m5945a(this).m5959a(this.f5409i, this.f5411k);
        this.f5410j = (TextView) findViewById(R.id.spbd_profile_name);
        this.f5410j.setText(this.f5412l);
        m5212a();
        m5213b();
        this.f5417q = (ListView) findViewById(R.id.itemOptions);
        this.f5417q.setAdapter((ListAdapter) m5214c());
        this.f5417q.setOnItemSelectedListener(m5215d());
        this.f5417q.setVisibility(8);
        this.f5417q.setOnItemClickListener(new C1504a(this));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            if (Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
            }
        }
        setTitle(R.string.buddy_suggestion_special_buddy);
    }

    /* renamed from: a */
    void m5212a() {
        if (C0672p.m3096c(this, this.f5411k)) {
            this.f5405b.setVisibility(0);
            this.f5406c.setVisibility(8);
        } else {
            this.f5405b.setVisibility(8);
            this.f5406c.setVisibility(0);
        }
    }

    /* renamed from: b */
    protected void m5213b() {
        Cursor cursorQuery = getContentResolver().query(C0694i.f2616a, new String[]{"inbox_enable_noti"}, "inbox_no=?", new String[]{this.f5413m}, null);
        if (cursorQuery != null) {
            if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti"));
            cursorQuery.close();
            if ("N".equals(string)) {
                this.f5407d.setChecked(false);
            } else {
                this.f5407d.setChecked(true);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_more_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 4:
                m5209e();
                return true;
            case android.R.id.home:
                finish();
                break;
            case R.id.actionbar_menu_more_option /* 2131494125 */:
                if (this.f5417q.getVisibility() == 8) {
                    this.f5417q.setVisibility(0);
                    break;
                } else {
                    this.f5417q.setVisibility(8);
                    break;
                }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m5209e() {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            C2153y.m7535a(this, R.string.popup_no_network_connection, 0).show();
            return false;
        }
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this);
        alertDialogBuilderC2120a.setTitle(R.string.menu_chat_close);
        alertDialogBuilderC2120a.setMessage(R.string.chat_deleted_popup);
        alertDialogBuilderC2120a.setCancelable(true).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1506c(this)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1505b(this));
        alertDialogBuilderC2120a.show();
        return true;
    }

    /* renamed from: a */
    private boolean m5206a(View view) {
        if (this.f5408e == null) {
            return false;
        }
        this.f5408e.m7448a(view);
        return true;
    }

    /* renamed from: f */
    private void m5210f() {
        if (!isFinishing()) {
            if (this.f5421u == null) {
                this.f5421u = new ProgressDialogC1806j(this, false);
                this.f5421u.setMessage(getString(R.string.dialog_connecting_server));
                this.f5421u.setOnKeyListener(new DialogInterfaceOnKeyListenerC1507d(this));
            } else if (!this.f5421u.isShowing()) {
                this.f5421u.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5211g() {
        if (!isFinishing() && this.f5421u != null && this.f5421u.isShowing()) {
            this.f5421u.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_button1 /* 2131493301 */:
                m5206a(view);
                break;
            case R.id.spbd_alert_check /* 2131493850 */:
                C0660d.m3008a(GlobalApplication.m3260b().getContentResolver(), this.f5413m, this.f5407d.isChecked());
                break;
            case R.id.spbd_profile_block_button /* 2131493851 */:
                m5210f();
                new C0632d(this.f5415o).m2847a(this.f5411k, 1);
                break;
            case R.id.spbd_profile_unblock_button /* 2131493852 */:
                m5210f();
                new C0632d(this.f5415o).m2846a(this.f5411k);
                break;
        }
    }

    /* renamed from: c */
    public C1798b m5214c() {
        this.f5418r = new C1798b(this, this.f5419s);
        return this.f5418r;
    }

    /* renamed from: d */
    public AdapterView.OnItemSelectedListener m5215d() {
        return this.f5416p;
    }
}
