package com.sec.vip.amschaton.ics;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C2064n;
import com.sec.widget.GeneralHeaderView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSSamplesActivity extends AMSActivity {

    /* renamed from: l */
    private boolean f7224l = false;

    /* renamed from: m */
    private GridView f7225m = null;

    /* renamed from: n */
    private C2025bu f7226n = null;

    /* renamed from: o */
    private ProgressDialog f7227o = null;

    /* renamed from: p */
    private ArrayList f7228p = null;

    /* renamed from: q */
    private GeneralHeaderView f7229q = null;

    /* renamed from: r */
    private Handler f7230r = new HandlerC2023bs(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_samples);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7224l = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m7118m();
        this.f7225m = (GridView) findViewById(R.id.grid_basic_file_list);
        this.f7225m.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        this.f7225m.setOnItemClickListener(new C2020bp(this));
        m7113i();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        m7117l();
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
        m7112h();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public Context m7109g() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7112h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7102a(String str) {
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
    public void m7103a(String str, boolean z) {
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

    /* renamed from: i */
    private void m7113i() {
        new AsyncTaskC2027bw(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7115j() {
        if (this.f7226n != null) {
            this.f7226n = null;
        }
        this.f7226n = new C2025bu(this);
        this.f7225m.setAdapter((ListAdapter) this.f7226n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m7116k() {
        C1786r.m6063c("loadAMSFilesBitmap", getClass().getSimpleName());
        C2064n c2064nM7173a = C2064n.m7173a();
        if (this.f7228p == null) {
            this.f7228p = new ArrayList();
            int iM7187b = c2064nM7173a.m7187b();
            for (int i = 0; i < iM7187b; i++) {
                this.f7228p.add(c2064nM7173a.m7184a(i, false));
            }
        }
    }

    /* renamed from: l */
    private void m7117l() {
        C1786r.m6063c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f7228p != null) {
            int size = this.f7228p.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7228p.get(i)).recycle();
            }
            this.f7228p.clear();
            this.f7228p = null;
        }
    }

    /* renamed from: m */
    private void m7118m() {
        this.f7229q = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f7229q.setText(R.string.ams_title_samples);
        this.f7229q.setButtonImageResource(0);
        this.f7229q.setBackClickListener(new ViewOnClickListenerC2024bt(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m7119n() {
        if (this.f7227o != null) {
            this.f7227o = null;
        }
        this.f7227o = new ProgressDialogC1806j(this);
        this.f7227o.setProgressStyle(0);
        this.f7227o.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f7227o.isShowing()) {
            this.f7227o.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m7120o() {
        if (this.f7227o.isShowing()) {
            this.f7227o.dismiss();
        }
    }
}
