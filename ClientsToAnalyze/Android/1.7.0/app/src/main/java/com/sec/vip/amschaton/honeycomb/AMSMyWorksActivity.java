package com.sec.vip.amschaton.honeycomb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.Menu;
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
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSMyWorksActivity extends AMSActivity {

    /* renamed from: a */
    private boolean f4977a = false;

    /* renamed from: b */
    private GridView f4978b = null;

    /* renamed from: c */
    private C1452k f4979c = null;

    /* renamed from: n */
    private boolean f4980n = false;

    /* renamed from: o */
    private boolean f4981o = true;

    /* renamed from: p */
    private boolean f4982p = true;

    /* renamed from: q */
    private ProgressDialog f4983q = null;

    /* renamed from: r */
    private ArrayList f4984r = null;

    /* renamed from: s */
    private int f4985s = 0;

    /* renamed from: t */
    private Handler f4986t = new HandlerC1456o(this);

    /* renamed from: u */
    private Handler f4987u = new HandlerC1458q(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_my_works);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4977a = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.f4978b = (GridView) findViewById(R.id.grid_user_file_list);
        this.f4978b.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        registerForContextMenu(this.f4978b);
        this.f4978b.setOnItemLongClickListener(new C1457p(this));
        this.f4978b.setOnItemClickListener(new C1455n(this));
        m5146j();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        m5149m();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ams_ics_option_menu_my_works, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                m5143h();
                return true;
            case R.id.menu_btn_cancel /* 2131428259 */:
                if (!this.f4980n) {
                    return true;
                }
                this.f4979c.m5279b();
                m5136c(false);
                m5131a(true);
                m5133b(true);
                return true;
            case R.id.menu_btn_delete /* 2131428260 */:
                if (this.f4980n) {
                    m5144i();
                    m5136c(false);
                    m5131a(true);
                    m5133b(true);
                    this.f4979c.m5280c();
                    return true;
                }
                m5136c(true);
                m5131a(false);
                m5133b(false);
                return true;
            default:
                return false;
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_btn_delete);
        if (menuItemFindItem != null) {
            if (this.f4981o) {
                menuItemFindItem.setIcon(R.drawable.ams_ics_selector_title_ic_delete);
                menuItemFindItem.setTitle(R.string.ams_btn_delete);
            } else {
                menuItemFindItem.setIcon(R.drawable.ams_ics_selector_title_ic_check);
                menuItemFindItem.setTitle(R.string.ams_btn_done);
            }
            menuItemFindItem.setEnabled(this.f4982p);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_btn_cancel);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(this.f4980n);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m5143h();
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
        if (view == this.f4978b) {
            getMenuInflater().inflate(R.menu.ams_ics2_context_menu_my_works, contextMenu);
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        String strM4881b = C1364aa.m4865a().m4881b(this.f4985s);
        if (strM4881b == null) {
            C1341p.m4651a("amsFile is NULL!", getClass().getSimpleName());
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_play /* 2131428243 */:
                m5129a(strM4881b);
                break;
            case R.id.context_menu_item_send /* 2131428244 */:
                m5132b(strM4881b);
                break;
            case R.id.context_menu_item_edit /* 2131428245 */:
                m5130a(strM4881b, false);
                break;
            case R.id.context_menu_item_delete /* 2131428246 */:
                if (!m5137c(strM4881b)) {
                    C1341p.m4651a("Selected item was not deleted!", getClass().getSimpleName());
                    break;
                }
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* renamed from: a */
    private void m5131a(boolean z) {
        this.f4981o = z;
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5133b(boolean z) {
        this.f4982p = z;
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Context m5124a() {
        return this;
    }

    /* renamed from: h */
    private void m5143h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5129a(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2002);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", 2001);
        intent.putExtra("AMS_DIRECT_PLAY", true);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5130a(String str, boolean z) {
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
    private void m5132b(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
        finish();
    }

    /* renamed from: c */
    private boolean m5137c(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        m4738a(R.string.ams_msg_deleted);
        m5146j();
        return true;
    }

    /* renamed from: c */
    private void m5136c(boolean z) {
        if (z) {
            this.f4980n = true;
        } else {
            this.f4980n = false;
        }
        this.f4979c.m5280c();
    }

    /* renamed from: i */
    private void m5144i() {
        String strM4881b;
        boolean[] zArrM5278a = this.f4979c.m5278a();
        if (zArrM5278a != null) {
            int length = zArrM5278a.length;
            for (int i = 0; i < length; i++) {
                if (zArrM5278a[i] && (strM4881b = C1364aa.m4865a().m4881b(i)) != null) {
                    File file = new File(strM4881b);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
            if (length > 0) {
                m4738a(R.string.ams_msg_deleted);
                m5146j();
            }
        }
    }

    /* renamed from: j */
    private void m5146j() {
        new AsyncTaskC1408ad(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5147k() {
        if (this.f4979c != null) {
            this.f4979c = null;
        }
        this.f4979c = new C1452k(this);
        this.f4979c.m5277a(this.f4986t);
        this.f4978b.setAdapter((ListAdapter) this.f4979c);
        this.f4979c.m5280c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5148l() {
        C1341p.m4660c("loadAMSFilesBitmap", getClass().getSimpleName());
        C1364aa c1364aaM4865a = C1364aa.m4865a();
        if (this.f4984r != null) {
            int size = this.f4984r.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f4984r.get(i)).recycle();
            }
            this.f4984r.clear();
            this.f4984r = null;
        }
        this.f4984r = new ArrayList();
        int iM4882c = c1364aaM4865a.m4882c();
        for (int i2 = 0; i2 < iM4882c; i2++) {
            this.f4984r.add(c1364aaM4865a.m4880b(i2, false));
        }
    }

    /* renamed from: m */
    private void m5149m() {
        C1341p.m4660c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f4984r != null) {
            int size = this.f4984r.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f4984r.get(i)).recycle();
            }
            this.f4984r.clear();
            this.f4984r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m5150n() {
        if (this.f4983q != null) {
            this.f4983q = null;
        }
        this.f4983q = new ProgressDialogC1354a(this);
        this.f4983q.setProgressStyle(0);
        this.f4983q.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f4983q.isShowing()) {
            this.f4983q.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m5151o() {
        if (this.f4983q.isShowing()) {
            this.f4983q.dismiss();
        }
    }
}
