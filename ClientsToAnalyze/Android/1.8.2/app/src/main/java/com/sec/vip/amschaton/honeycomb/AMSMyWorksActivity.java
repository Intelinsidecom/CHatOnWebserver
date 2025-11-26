package com.sec.vip.amschaton.honeycomb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.vip.amschaton.AMSActionBarView;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C2064n;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSMyWorksActivity extends AMSActivity {

    /* renamed from: m */
    private boolean f6963m = false;

    /* renamed from: n */
    private GridView f6964n = null;

    /* renamed from: o */
    private C1910ar f6965o = null;

    /* renamed from: p */
    private int f6966p = 2000;

    /* renamed from: q */
    private ProgressDialog f6967q = null;

    /* renamed from: r */
    private ArrayList f6968r = null;

    /* renamed from: s */
    private int f6969s = 0;

    /* renamed from: l */
    AMSActionBarView f6962l = null;

    /* renamed from: t */
    private Handler f6970t = new HandlerC1906an(this);

    /* renamed from: u */
    private Handler f6971u = new HandlerC1907ao(this);

    /* renamed from: v */
    private View.OnClickListener f6972v = new ViewOnClickListenerC1908ap(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_my_works);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6963m = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m6709w();
        this.f6964n = (GridView) findViewById(R.id.grid_user_file_list);
        this.f6964n.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        registerForContextMenu(this.f6964n);
        this.f6964n.setOnItemLongClickListener(new C1894ab(this));
        this.f6964n.setOnItemClickListener(new C1897ae(this));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_file_list);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.ams_ics_layout_my_works_noitems, (ViewGroup) null);
        linearLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        this.f6964n.setEmptyView(viewInflate);
        viewInflate.setVisibility(4);
        m6702p();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        m6705s();
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
        m6690h();
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
        if (view == this.f6964n) {
            contextMenu.setHeaderTitle(R.string.ams_app_name);
            getMenuInflater().inflate(R.menu.ams_ics2_context_menu_my_works, contextMenu);
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        String strM7189b = C2064n.m7173a().m7189b(this.f6969s);
        if (strM7189b == null) {
            C1786r.m6054a("amsFile is NULL!", getClass().getSimpleName());
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_play /* 2131494136 */:
                m6674a(strM7189b);
                break;
            case R.id.context_menu_item_send /* 2131494137 */:
                m6679b(strM7189b);
                break;
            case R.id.context_menu_item_edit /* 2131494138 */:
                if (new AMSDrawManager(m6687g()).m6310c(strM7189b)) {
                    this.f6964n.setOnItemClickListener(null);
                    m6675a(strM7189b, false);
                    break;
                } else if (Build.VERSION.SDK_INT > 11) {
                    new AlertDialogBuilderC2120a(m6687g()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setPositiveButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1903ak(this)).setNegativeButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1902aj(this, strM7189b)).create().show();
                    break;
                } else {
                    new AlertDialogBuilderC2120a(m6687g()).setTitle(R.string.ams_attention_title).setMessage(R.string.ams_attention_non_editable).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1905am(this, strM7189b)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1904al(this)).create().show();
                    break;
                }
            case R.id.context_menu_item_delete /* 2131494139 */:
                if (!m6683c(strM7189b)) {
                    C1786r.m6054a("Selected item was not deleted!", getClass().getSimpleName());
                    break;
                }
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public Context m6687g() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6690h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6674a(String str) {
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
    public void m6675a(String str, boolean z) {
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
    private void m6679b(String str) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
        finish();
    }

    /* renamed from: c */
    private boolean m6683c(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        m6262a(R.string.ams_msg_deleted);
        m6702p();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6691i() {
        switch (this.f6966p) {
            case 2000:
                m6690h();
                break;
            case 2001:
                m6678b(2002);
                m6670a(2002, false);
                m6680b(true);
                m6699m();
                break;
            case 2002:
                m6678b(2001);
                m6670a(2001, false);
                m6680b(false);
                m6697l();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6693j() {
        switch (this.f6966p) {
            case 2000:
            case 2001:
                m6690h();
                break;
            case 2002:
                m6701o();
                m6678b(2001);
                m6680b(false);
                m6699m();
                break;
        }
    }

    /* renamed from: b */
    private void m6678b(int i) {
        this.f6966p = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6670a(int i, boolean z) {
        m6682c(i);
        m6676a(z);
    }

    /* renamed from: k */
    private void m6695k() {
        if (C2064n.m7173a().m7190c() > 0) {
            m6678b(2001);
        } else {
            m6678b(2000);
        }
        m6670a(this.f6966p, true);
    }

    /* renamed from: l */
    private void m6697l() {
        String strM7189b;
        boolean[] zArrM6700n = m6700n();
        if (zArrM6700n != null) {
            int length = zArrM6700n.length;
            for (int i = 0; i < length; i++) {
                if (zArrM6700n[i] && (strM7189b = C2064n.m7173a().m7189b(i)) != null) {
                    File file = new File(strM7189b);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
            if (length > 0) {
                m6262a(R.string.ams_msg_deleted);
                m6702p();
            }
        }
    }

    /* renamed from: m */
    private void m6699m() {
        if (this.f6965o != null) {
            this.f6965o.m6853c();
        }
    }

    /* renamed from: n */
    private boolean[] m6700n() {
        if (this.f6965o == null) {
            return null;
        }
        return this.f6965o.m6851a();
    }

    /* renamed from: o */
    private void m6701o() {
        if (this.f6965o != null) {
            this.f6965o.m6852b();
        }
    }

    /* renamed from: p */
    private void m6702p() {
        new AsyncTaskC1909aq(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m6703q() {
        if (this.f6965o != null) {
            this.f6965o = null;
        }
        this.f6965o = new C1910ar(this);
        this.f6965o.m6850a(this.f6970t);
        this.f6964n.setAdapter((ListAdapter) this.f6965o);
        m6695k();
        m6699m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m6704r() {
        C1786r.m6063c("loadAMSFilesBitmap", getClass().getSimpleName());
        C2064n c2064nM7173a = C2064n.m7173a();
        if (this.f6968r != null) {
            int size = this.f6968r.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f6968r.get(i)).recycle();
            }
            this.f6968r.clear();
            this.f6968r = null;
        }
        this.f6968r = new ArrayList();
        int iM7190c = c2064nM7173a.m7190c();
        for (int i2 = 0; i2 < iM7190c; i2++) {
            this.f6968r.add(c2064nM7173a.m7188b(i2, false));
        }
    }

    /* renamed from: s */
    private void m6705s() {
        C1786r.m6063c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f6968r != null) {
            int size = this.f6968r.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f6968r.get(i)).recycle();
            }
            this.f6968r.clear();
            this.f6968r = null;
        }
    }

    /* renamed from: c */
    private void m6682c(int i) {
        int i2 = R.drawable.ams_ics_selector_title_ic_check;
        if (this.f6962l != null) {
            int i3 = R.string.ams_btn_delete;
            switch (i) {
                case 2000:
                    i3 = R.string.ams_btn_create;
                    break;
                case 2001:
                default:
                    i2 = R.drawable.ams_ics_selector_title_ic_delete;
                    break;
                case 2002:
                    i3 = R.string.ams_btn_done;
                    break;
            }
            this.f6962l.m6245a(5000, i2);
            this.f6962l.m6250b(5000, i3);
        }
    }

    /* renamed from: a */
    private void m6676a(boolean z) {
        if (this.f6962l != null) {
            this.f6962l.m6248a(5000, z);
        }
    }

    /* renamed from: b */
    private void m6680b(boolean z) {
        if (this.f6962l != null) {
            this.f6962l.m6251b(5001, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m6706t() {
        if (this.f6967q != null) {
            this.f6967q = null;
        }
        this.f6967q = new ProgressDialogC1806j(this);
        this.f6967q.setProgressStyle(0);
        this.f6967q.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f6967q.isShowing()) {
            this.f6967q.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m6707u() {
        if (this.f6967q.isShowing()) {
            this.f6967q.dismiss();
        }
    }

    /* renamed from: v */
    private void m6708v() {
        this.f6962l = (AMSActionBarView) findViewById(R.id.actionbar);
    }

    /* renamed from: w */
    private void m6709w() {
        m6708v();
        this.f6962l.setTitleText(R.string.ams_app_name);
        this.f6962l.setHomeClickListener(this.f6972v);
        this.f6962l.m6244a();
        this.f6962l.m6246a(R.drawable.ams_ics_selector_title_ic_cancel, R.string.ams_btn_cancel, new ViewOnClickListenerC1895ac(this), 5001);
        this.f6962l.m6246a(R.drawable.ams_ics_selector_title_ic_delete, R.string.ams_btn_delete, new ViewOnClickListenerC1896ad(this), 5000);
        this.f6962l.setMoreOptionIconVisibility(false);
        this.f6962l.setActionButtonLayoutVisibility(true);
        m6680b(false);
    }
}
