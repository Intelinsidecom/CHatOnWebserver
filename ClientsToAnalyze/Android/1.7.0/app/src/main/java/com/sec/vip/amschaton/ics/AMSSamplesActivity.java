package com.sec.vip.amschaton.ics;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C1364aa;
import com.sec.widget.GeneralHeaderView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSSamplesActivity extends AMSActivity {

    /* renamed from: a */
    private boolean f5255a = false;

    /* renamed from: b */
    private GridView f5256b = null;

    /* renamed from: c */
    private C1485ap f5257c = null;

    /* renamed from: n */
    private ProgressDialog f5258n = null;

    /* renamed from: o */
    private ArrayList f5259o = null;

    /* renamed from: p */
    private GeneralHeaderView f5260p = null;

    /* renamed from: q */
    private int f5261q = 0;

    /* renamed from: r */
    private Handler f5262r = new HandlerC1535q(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_samples);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f5255a = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m5561m();
        this.f5256b = (GridView) findViewById(R.id.grid_basic_file_list);
        this.f5256b.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        registerForContextMenu(this.f5256b);
        this.f5256b.setOnItemLongClickListener(new C1536r(this));
        this.f5256b.setOnItemClickListener(new C1534p(this));
        m5556i();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        m5560l();
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        C1341p.m4660c("[onPause]", getClass().getName());
        super.onPause();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1341p.m4660c("[onResume]", getClass().getName());
        super.onResume();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m5555h();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1341p.m4660c("[onRestoreInstanceState]", getClass().getName());
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1341p.m4660c("[onSaveInstanceState]", getClass().getName());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view == this.f5256b) {
            getMenuInflater().inflate(R.menu.ams_ics2_context_menu_samples, contextMenu);
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        String strM4877a = C1364aa.m4865a().m4877a(this.f5261q);
        if (strM4877a == null) {
            C1341p.m4651a("amsFile is NULL!", getClass().getSimpleName());
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_play /* 2131428243 */:
                m5545a(strM4877a);
                break;
            case R.id.context_menu_item_send /* 2131428244 */:
                m5548b(strM4877a);
                break;
            case R.id.context_menu_item_edit /* 2131428245 */:
                m5546a(strM4877a, false);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Context m5541a() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5555h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5545a(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2002);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", 2000);
        intent.putExtra("AMS_DIRECT_PLAY", true);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5546a(String str, boolean z) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2003);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_SAVE_FILE", z);
        intent.putExtra("AMS_EDIT_FLAG", true);
        startActivity(intent);
        finish();
    }

    /* renamed from: b */
    private void m5548b(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
        finish();
    }

    /* renamed from: i */
    private void m5556i() {
        new AsyncTaskC1493ax(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5558j() {
        if (this.f5257c != null) {
            this.f5257c = null;
        }
        this.f5257c = new C1485ap(this);
        this.f5256b.setAdapter((ListAdapter) this.f5257c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5559k() {
        C1341p.m4660c("loadAMSFilesBitmap", getClass().getSimpleName());
        C1364aa c1364aaM4865a = C1364aa.m4865a();
        if (this.f5259o == null) {
            this.f5259o = new ArrayList();
            int iM4879b = c1364aaM4865a.m4879b();
            for (int i = 0; i < iM4879b; i++) {
                this.f5259o.add(c1364aaM4865a.m4876a(i, false));
            }
        }
    }

    /* renamed from: l */
    private void m5560l() {
        C1341p.m4660c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f5259o != null) {
            int size = this.f5259o.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5259o.get(i)).recycle();
            }
            this.f5259o.clear();
            this.f5259o = null;
        }
    }

    /* renamed from: m */
    private void m5561m() {
        this.f5260p = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f5260p.setText(R.string.ams_title_samples);
        this.f5260p.setButtonImageResource(0);
        this.f5260p.setBackClickListener(new ViewOnClickListenerC1533o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m5562n() {
        if (this.f5258n != null) {
            this.f5258n = null;
        }
        this.f5258n = new ProgressDialogC1354a(this);
        this.f5258n.setProgressStyle(0);
        this.f5258n.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f5258n.isShowing()) {
            this.f5258n.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m5563o() {
        if (this.f5258n.isShowing()) {
            this.f5258n.dismiss();
        }
    }
}
