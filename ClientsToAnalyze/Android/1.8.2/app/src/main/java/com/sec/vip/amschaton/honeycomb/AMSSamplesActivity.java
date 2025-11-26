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
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.vip.amschaton.AMSActionBarView;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C2064n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSSamplesActivity extends AMSActivity {

    /* renamed from: m */
    private boolean f6996m = false;

    /* renamed from: n */
    private GridView f6997n = null;

    /* renamed from: o */
    private C1941bv f6998o = null;

    /* renamed from: p */
    private ProgressDialog f6999p = null;

    /* renamed from: q */
    private ArrayList f7000q = null;

    /* renamed from: r */
    private int f7001r = 0;

    /* renamed from: l */
    AMSActionBarView f6995l = null;

    /* renamed from: s */
    private Handler f7002s = new HandlerC1939bt(this);

    /* renamed from: t */
    private View.OnClickListener f7003t = new ViewOnClickListenerC1940bu(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_samples);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6996m = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m6802p();
        this.f6997n = (GridView) findViewById(R.id.grid_basic_file_list);
        this.f6997n.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        registerForContextMenu(this.f6997n);
        this.f6997n.setOnItemLongClickListener(new C1935bp(this));
        this.f6997n.setOnItemClickListener(new C1936bq(this));
        m6794i();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        m6798l();
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        C1786r.m6063c("[onPause]", getClass().getName());
        super.onPause();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6063c("[onResume]", getClass().getName());
        super.onResume();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m6792h();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1786r.m6063c("[onRestoreInstanceState]", getClass().getName());
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1786r.m6063c("[onSaveInstanceState]", getClass().getName());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view == this.f6997n) {
            contextMenu.setHeaderTitle(R.string.ams_app_name);
            getMenuInflater().inflate(R.menu.ams_ics2_context_menu_samples, contextMenu);
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        String strM7185a = C2064n.m7173a().m7185a(this.f7001r);
        if (strM7185a == null) {
            C1786r.m6054a("amsFile is NULL!", getClass().getSimpleName());
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_play /* 2131494136 */:
                m6782a(strM7185a);
                break;
            case R.id.context_menu_item_send /* 2131494137 */:
                m6785b(strM7185a);
                break;
            case R.id.context_menu_item_edit /* 2131494138 */:
                m6783a(strM7185a, false);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public Context m6790g() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6792h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6782a(String str) {
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
    public void m6783a(String str, boolean z) {
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
    private void m6785b(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
        finish();
    }

    /* renamed from: i */
    private void m6794i() {
        new AsyncTaskC1943bx(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6796j() {
        if (this.f6998o != null) {
            this.f6998o = null;
        }
        this.f6998o = new C1941bv(this);
        this.f6997n.setAdapter((ListAdapter) this.f6998o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m6797k() {
        C1786r.m6063c("loadAMSFilesBitmap", getClass().getSimpleName());
        C2064n c2064nM7173a = C2064n.m7173a();
        if (this.f7000q == null) {
            this.f7000q = new ArrayList();
            int iM7187b = c2064nM7173a.m7187b();
            for (int i = 0; i < iM7187b; i++) {
                this.f7000q.add(c2064nM7173a.m7184a(i, false));
            }
        }
    }

    /* renamed from: l */
    private void m6798l() {
        C1786r.m6063c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f7000q != null) {
            int size = this.f7000q.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7000q.get(i)).recycle();
            }
            this.f7000q.clear();
            this.f7000q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m6799m() {
        if (this.f6999p != null) {
            this.f6999p = null;
        }
        this.f6999p = new ProgressDialogC1806j(this);
        this.f6999p.setProgressStyle(0);
        this.f6999p.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f6999p.isShowing()) {
            this.f6999p.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m6800n() {
        if (this.f6999p.isShowing()) {
            this.f6999p.dismiss();
        }
    }

    /* renamed from: o */
    private void m6801o() {
        this.f6995l = (AMSActionBarView) findViewById(R.id.actionbar);
    }

    /* renamed from: p */
    private void m6802p() {
        m6801o();
        this.f6995l.setTitleText(R.string.ams_app_name);
        this.f6995l.setHomeClickListener(this.f7003t);
        this.f6995l.setMoreOptionIconVisibility(false);
        this.f6995l.setActionButtonLayoutVisibility(false);
    }
}
