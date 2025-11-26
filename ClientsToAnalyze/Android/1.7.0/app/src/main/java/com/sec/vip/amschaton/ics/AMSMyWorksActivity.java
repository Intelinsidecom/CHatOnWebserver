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
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSMyWorksActivity extends AMSActivity {

    /* renamed from: a */
    private boolean f5224a = false;

    /* renamed from: b */
    private GridView f5225b = null;

    /* renamed from: c */
    private C1492aw f5226c = null;

    /* renamed from: n */
    private boolean f5227n = false;

    /* renamed from: o */
    private ProgressDialog f5228o = null;

    /* renamed from: p */
    private ArrayList f5229p = null;

    /* renamed from: q */
    private GeneralHeaderView f5230q = null;

    /* renamed from: r */
    private int f5231r = 0;

    /* renamed from: s */
    private Handler f5232s = new HandlerC1488as(this);

    /* renamed from: t */
    private Handler f5233t = new HandlerC1489at(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_my_works);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f5224a = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m5471s();
        this.f5225b = (GridView) findViewById(R.id.grid_user_file_list);
        this.f5225b.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        registerForContextMenu(this.f5225b);
        this.f5225b.setOnItemLongClickListener(new C1486aq(this));
        this.f5225b.setOnItemClickListener(new C1487ar(this));
        m5467o();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        m5470r();
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
        m5457h();
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
        if (view == this.f5225b) {
            getMenuInflater().inflate(R.menu.ams_ics2_context_menu_my_works, contextMenu);
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        String strM4881b = C1364aa.m4865a().m4881b(this.f5231r);
        if (strM4881b == null) {
            C1341p.m4651a("amsFile is NULL!", getClass().getSimpleName());
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_play /* 2131428243 */:
                m5443a(strM4881b);
                break;
            case R.id.context_menu_item_send /* 2131428244 */:
                m5447b(strM4881b);
                break;
            case R.id.context_menu_item_edit /* 2131428245 */:
                m5444a(strM4881b, false);
                break;
            case R.id.context_menu_item_delete /* 2131428246 */:
                if (!m5451c(strM4881b)) {
                    C1341p.m4651a("Selected item was not deleted!", getClass().getSimpleName());
                    break;
                }
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Context m5438a() {
        return this;
    }

    /* renamed from: h */
    private void m5457h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5443a(String str) {
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
    public void m5444a(String str, boolean z) {
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
    private void m5447b(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
        finish();
    }

    /* renamed from: c */
    private boolean m5451c(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        m4738a(R.string.ams_msg_deleted);
        m5467o();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5458i() {
        if (this.f5227n) {
            m5446a(true, false);
            m5462k();
            m5446a(true, true);
        } else {
            m5446a(false, false);
        }
        this.f5227n = this.f5227n ? false : true;
        m5464l();
    }

    /* renamed from: a */
    private void m5446a(boolean z, boolean z2) {
        m5445a(z);
        m5448b(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5461j() {
        if (this.f5227n) {
            m5466n();
            this.f5227n = !this.f5227n;
            m5464l();
            m5446a(true, true);
            return;
        }
        m5457h();
    }

    /* renamed from: k */
    private void m5462k() {
        String strM4881b;
        boolean[] zArrM5465m = m5465m();
        if (zArrM5465m != null) {
            int length = zArrM5465m.length;
            for (int i = 0; i < length; i++) {
                if (zArrM5465m[i] && (strM4881b = C1364aa.m4865a().m4881b(i)) != null) {
                    File file = new File(strM4881b);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
            if (length > 0) {
                m4738a(R.string.ams_msg_deleted);
                m5467o();
            }
        }
    }

    /* renamed from: l */
    private void m5464l() {
        if (this.f5226c != null) {
            this.f5226c.m5608c();
        }
    }

    /* renamed from: m */
    private boolean[] m5465m() {
        if (this.f5226c == null) {
            return null;
        }
        return this.f5226c.m5606a();
    }

    /* renamed from: n */
    private void m5466n() {
        if (this.f5226c != null) {
            this.f5226c.m5607b();
        }
    }

    /* renamed from: o */
    private void m5467o() {
        new AsyncTaskC1494ay(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m5468p() {
        if (this.f5226c != null) {
            this.f5226c = null;
        }
        this.f5226c = new C1492aw(this);
        this.f5226c.m5605a(this.f5232s);
        this.f5225b.setAdapter((ListAdapter) this.f5226c);
        m5464l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m5469q() {
        C1341p.m4660c("loadAMSFilesBitmap", getClass().getSimpleName());
        C1364aa c1364aaM4865a = C1364aa.m4865a();
        if (this.f5229p != null) {
            int size = this.f5229p.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5229p.get(i)).recycle();
            }
            this.f5229p.clear();
            this.f5229p = null;
        }
        this.f5229p = new ArrayList();
        int iM4882c = c1364aaM4865a.m4882c();
        for (int i2 = 0; i2 < iM4882c; i2++) {
            this.f5229p.add(c1364aaM4865a.m4880b(i2, false));
        }
    }

    /* renamed from: r */
    private void m5470r() {
        C1341p.m4660c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f5229p != null) {
            int size = this.f5229p.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5229p.get(i)).recycle();
            }
            this.f5229p.clear();
            this.f5229p = null;
        }
    }

    /* renamed from: s */
    private void m5471s() {
        this.f5230q = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f5230q.setText(R.string.ams_title_my_works);
        this.f5230q.setButtonImageResource(R.drawable.general_btn_icon_delete_xml);
        this.f5230q.setBackClickListener(new ViewOnClickListenerC1490au(this));
        this.f5230q.setButtonClickListener(new ViewOnClickListenerC1491av(this));
    }

    /* renamed from: a */
    private void m5445a(boolean z) {
        if (this.f5230q != null) {
            this.f5230q.setButtonImageResource(z ? R.drawable.general_btn_icon_delete_xml : R.drawable.general_btn_icon_complete_xml);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5448b(boolean z) {
        if (this.f5230q != null) {
            this.f5230q.setButtonEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m5472t() {
        if (this.f5228o != null) {
            this.f5228o = null;
        }
        this.f5228o = new ProgressDialogC1354a(this);
        this.f5228o.setProgressStyle(0);
        this.f5228o.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f5228o.isShowing()) {
            this.f5228o.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m5473u() {
        if (this.f5228o.isShowing()) {
            this.f5228o.dismiss();
        }
    }
}
