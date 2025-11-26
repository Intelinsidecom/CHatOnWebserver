package com.sec.vip.amschaton;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;
import java.io.File;

/* loaded from: classes.dex */
public class AMSFileListActivity extends AMSActivity implements View.OnClickListener {

    /* renamed from: a */
    private GridView f3940a = null;

    /* renamed from: b */
    private GridView f3941b = null;

    /* renamed from: c */
    private C0665bl f3942c = null;

    /* renamed from: d */
    private C0648av f3943d = null;

    /* renamed from: m */
    private LinearLayout f3944m = null;

    /* renamed from: n */
    private Button f3945n = null;

    /* renamed from: o */
    private Button f3946o = null;

    /* renamed from: p */
    private boolean f3947p = false;

    /* renamed from: q */
    private TabHost f3948q = null;

    /* renamed from: r */
    private ProgressDialog f3949r = null;

    /* renamed from: s */
    private Handler f3950s = new HandlerC0656bc(this);

    /* renamed from: t */
    private Handler f3951t = new HandlerC0655bb(this);

    /* renamed from: a */
    private RelativeLayout m3903a(Context context, int i, int i2) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(C0062R.layout.ams_file_list_tab_indicator, (ViewGroup) this.f3948q.getTabWidget(), false);
        ((ImageView) relativeLayout.findViewById(C0062R.id.icon)).setImageDrawable(getResources().getDrawable(i2));
        ((TextView) relativeLayout.findViewById(C0062R.id.title)).setText(i);
        return relativeLayout;
    }

    /* renamed from: a */
    private void m3904a() {
        AMSFileInfo aMSFileInfoM3950d;
        boolean[] zArrM4226a = this.f3943d.m4226a();
        if (zArrM4226a == null) {
            return;
        }
        int length = zArrM4226a.length;
        for (int i = 0; i < length; i++) {
            if (zArrM4226a[i] && (aMSFileInfoM3950d = AMSFileManager.m3931a().m3950d(i)) != null) {
                File file = new File(aMSFileInfoM3950d.m3898a());
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        if (length > 0) {
            Toast.makeText(this, C0062R.string.ams_msg_deleted, 0).show();
            m3923i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3905a(int i, boolean z) {
        Dialog dialog = new Dialog(this, C0062R.style.AMSCustomDialogTheme);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0062R.layout.ams_filelist_context_menu_layout);
        if (this.f3947p) {
            return;
        }
        if (z) {
            AMSFileInfo aMSFileInfoM3943a = AMSFileManager.m3931a().m3943a(i);
            if (aMSFileInfoM3943a == null) {
                ChatONLogWriter.m3499a("amsFile is NULL!", getClass().getSimpleName());
                return;
            }
            ((ImageView) dialog.findViewById(C0062R.id.iv_play)).setOnClickListener(new ViewOnClickListenerC0661bh(this, aMSFileInfoM3943a, dialog));
            ((ImageView) dialog.findViewById(C0062R.id.iv_send)).setOnClickListener(new ViewOnClickListenerC0660bg(this, aMSFileInfoM3943a, dialog));
            ((ImageView) dialog.findViewById(C0062R.id.iv_tab_line)).setVisibility(8);
            ((ImageView) dialog.findViewById(C0062R.id.iv_delete)).setVisibility(8);
        } else {
            AMSFileInfo aMSFileInfoM3950d = AMSFileManager.m3931a().m3950d(i);
            if (aMSFileInfoM3950d == null) {
                ChatONLogWriter.m3499a("amsFile is NULL!", getClass().getSimpleName());
                return;
            } else {
                ((ImageView) dialog.findViewById(C0062R.id.iv_play)).setOnClickListener(new ViewOnClickListenerC0659bf(this, aMSFileInfoM3950d, dialog));
                ((ImageView) dialog.findViewById(C0062R.id.iv_send)).setOnClickListener(new ViewOnClickListenerC0705h(this, aMSFileInfoM3950d, dialog));
                ((ImageView) dialog.findViewById(C0062R.id.iv_delete)).setOnClickListener(new ViewOnClickListenerC0704g(this, aMSFileInfoM3950d, dialog));
            }
        }
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3909a(String str) {
        if (str != null) {
            Intent intent = new Intent();
            intent.putExtra("AMS_FILE_PATH", str);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /* renamed from: a */
    public void m3910a(String str, int i) {
        Intent intent = new Intent(this, (Class<?>) AMSPlayerActivity.class);
        intent.putExtra("VIEWER_MODE", MsgResultCode.SUCCESS);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", i);
        startActivity(intent);
    }

    /* renamed from: a */
    private void m3911a(String str, int i, int i2, int i3) {
        TabHost.TabSpec tabSpecNewTabSpec = this.f3948q.newTabSpec(str);
        tabSpecNewTabSpec.setContent(i3);
        tabSpecNewTabSpec.setIndicator(m3903a(this.f3948q.getContext(), i, i2));
        this.f3948q.addTab(tabSpecNewTabSpec);
    }

    /* renamed from: a */
    private void m3912a(boolean z) {
        if (z) {
            this.f3947p = true;
            this.f3944m.setVisibility(0);
        } else {
            this.f3947p = false;
            this.f3944m.setVisibility(8);
        }
        this.f3945n.setEnabled(false);
        this.f3942c.m4229a();
        this.f3943d.m4228c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m3916b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        Toast.makeText(this, C0062R.string.ams_msg_deleted, 0).show();
        m3923i();
        return true;
    }

    /* renamed from: i */
    private void m3923i() {
        new AsyncTaskC0719v(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3924j() {
        if (this.f3942c != null) {
            this.f3942c = null;
        }
        this.f3942c = new C0665bl(this);
        this.f3940a.setAdapter((ListAdapter) this.f3942c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m3925k() {
        if (this.f3943d != null) {
            this.f3943d = null;
        }
        this.f3943d = new C0648av(this);
        this.f3943d.m4225a(this.f3950s);
        this.f3941b.setAdapter((ListAdapter) this.f3943d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m3926l() {
        startActivity(new Intent(this, (Class<?>) AMSComposerActivity.class));
    }

    /* renamed from: m */
    private void m3927m() {
        if (!m3717g() || !m3718h()) {
            ChatONLogWriter.m3499a("[deleteTempFolder] External Storage Is Not Available or Writable!", getClass().getSimpleName());
            return;
        }
        String[] list = new File(f3812i).list();
        ChatONLogWriter.m3506b("[deleteTempFolder] fileList.length : " + list.length, getClass().getSimpleName());
        for (String str : list) {
            ChatONLogWriter.m3506b(f3812i + str + " : " + new File(f3812i + str).delete(), getClass().getSimpleName());
        }
    }

    /* renamed from: n */
    private void m3928n() {
        this.f3949r = new ProgressDialog(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m3929o() {
        this.f3949r.setMessage(getString(C0062R.string.ams_msg_progress_ams_file_loading));
        this.f3949r.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m3930p() {
        this.f3949r.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_cancel /* 2131427352 */:
                this.f3943d.m4227b();
                m3912a(false);
                break;
            case C0062R.id.btn_delete /* 2131427436 */:
                m3904a();
                m3912a(false);
                break;
        }
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.ams_file_list_layout);
        if (!m3717g() || !m3718h()) {
            ChatONLogWriter.m3499a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            Toast.makeText(this, C0062R.string.ams_sdcard_unmounted_msg, 0).show();
            finish();
            return;
        }
        this.f3948q = (TabHost) findViewById(C0062R.id.tab_host);
        this.f3948q.setup();
        m3911a("tab1", C0062R.string.ams_title_sample_message, C0062R.drawable.ams_file_list_sample_tab_icon, C0062R.id.layout_basic_file);
        m3911a("tab2", C0062R.string.ams_title_my_message, C0062R.drawable.ams_file_list_mymsg_tab_icon, C0062R.id.layout_user_file);
        this.f3948q.getTabWidget().setStripEnabled(true);
        this.f3948q.setCurrentTabByTag("tab2");
        this.f3940a = (GridView) findViewById(C0062R.id.grid_basic_file_list);
        this.f3941b = (GridView) findViewById(C0062R.id.grid_user_file_list);
        this.f3940a.setSelector(C0062R.drawable.ams_grid_selector_dummy);
        this.f3941b.setSelector(C0062R.drawable.ams_grid_selector_dummy);
        this.f3940a.setOnItemClickListener(new C0662bi(this));
        this.f3940a.setOnItemLongClickListener(new C0663bj(this));
        this.f3941b.setOnItemClickListener(new C0658be(this));
        this.f3941b.setOnItemLongClickListener(new C0657bd(this));
        this.f3944m = (LinearLayout) findViewById(C0062R.id.layout_button);
        this.f3944m.setVisibility(8);
        this.f3945n = (Button) findViewById(C0062R.id.btn_delete);
        this.f3945n.setOnClickListener(this);
        this.f3945n.setEnabled(false);
        this.f3946o = (Button) findViewById(C0062R.id.btn_cancel);
        this.f3946o.setOnClickListener(this);
        m3928n();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0062R.menu.ams_filelist_option_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        m3927m();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            m3909a(extras.getString("AMS_FILE_PATH"));
        } else {
            ChatONLogWriter.m3499a("bundle is NULL!", getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case C0062R.id.menu_create_message /* 2131428122 */:
                m3926l();
                break;
            case C0062R.id.menu_delete /* 2131428124 */:
                m3912a(true);
                break;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(C0062R.id.menu_group_delete, (this.f3948q.getCurrentTab() == 0 || AMSFileManager.m3931a().m3948c() == 0) ? false : true);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        m3923i();
        super.onResume();
    }
}
