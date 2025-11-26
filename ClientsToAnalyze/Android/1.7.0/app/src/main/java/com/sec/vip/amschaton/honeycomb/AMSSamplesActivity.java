package com.sec.vip.amschaton.honeycomb;

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
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSSamplesActivity extends AMSActivity {

    /* renamed from: a */
    private boolean f5011a = false;

    /* renamed from: b */
    private GridView f5012b = null;

    /* renamed from: c */
    private C1414aj f5013c = null;

    /* renamed from: n */
    private ProgressDialog f5014n = null;

    /* renamed from: o */
    private ArrayList f5015o = null;

    /* renamed from: p */
    private int f5016p = 0;

    /* renamed from: q */
    private Handler f5017q = new HandlerC1432ba(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_samples);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f5011a = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.f5012b = (GridView) findViewById(R.id.grid_basic_file_list);
        this.f5012b.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        registerForContextMenu(this.f5012b);
        this.f5012b.setOnItemLongClickListener(new C1430az(this));
        this.f5012b.setOnItemClickListener(new C1429ay(this));
        m5229i();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        m5232l();
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
        m5227h();
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

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                m5227h();
                return true;
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view == this.f5012b) {
            getMenuInflater().inflate(R.menu.ams_ics2_context_menu_samples, contextMenu);
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        String strM4877a = C1364aa.m4865a().m4877a(this.f5016p);
        if (strM4877a == null) {
            C1341p.m4651a("amsFile is NULL!", getClass().getSimpleName());
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_play /* 2131428243 */:
                m5218a(strM4877a);
                break;
            case R.id.context_menu_item_send /* 2131428244 */:
                m5221b(strM4877a);
                break;
            case R.id.context_menu_item_edit /* 2131428245 */:
                m5219a(strM4877a, false);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Context m5214a() {
        return this;
    }

    /* renamed from: h */
    private void m5227h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5218a(String str) {
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
    public void m5219a(String str, boolean z) {
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
    private void m5221b(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
        finish();
    }

    /* renamed from: i */
    private void m5229i() {
        new AsyncTaskC1450i(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5230j() {
        if (this.f5013c != null) {
            this.f5013c = null;
        }
        this.f5013c = new C1414aj(this);
        this.f5012b.setAdapter((ListAdapter) this.f5013c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5231k() {
        C1341p.m4660c("loadAMSFilesBitmap", getClass().getSimpleName());
        C1364aa c1364aaM4865a = C1364aa.m4865a();
        if (this.f5015o == null) {
            this.f5015o = new ArrayList();
            int iM4879b = c1364aaM4865a.m4879b();
            for (int i = 0; i < iM4879b; i++) {
                this.f5015o.add(c1364aaM4865a.m4876a(i, false));
            }
        }
    }

    /* renamed from: l */
    private void m5232l() {
        C1341p.m4660c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f5015o != null) {
            int size = this.f5015o.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5015o.get(i)).recycle();
            }
            this.f5015o.clear();
            this.f5015o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5233m() {
        if (this.f5014n != null) {
            this.f5014n = null;
        }
        this.f5014n = new ProgressDialogC1354a(this);
        this.f5014n.setProgressStyle(0);
        this.f5014n.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f5014n.isShowing()) {
            this.f5014n.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m5234n() {
        if (this.f5014n.isShowing()) {
            this.f5014n.dismiss();
        }
    }
}
