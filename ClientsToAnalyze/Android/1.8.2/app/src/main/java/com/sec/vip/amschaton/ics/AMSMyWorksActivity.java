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
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSMyWorksActivity extends AMSActivity {

    /* renamed from: l */
    private boolean f7194l = false;

    /* renamed from: m */
    private GridView f7195m = null;

    /* renamed from: n */
    private C1994aq f7196n = null;

    /* renamed from: o */
    private boolean f7197o = false;

    /* renamed from: p */
    private ProgressDialog f7198p = null;

    /* renamed from: q */
    private ArrayList f7199q = null;

    /* renamed from: r */
    private GeneralHeaderView f7200r = null;

    /* renamed from: s */
    private Handler f7201s = new HandlerC1989al(this);

    /* renamed from: t */
    private Handler f7202t = new HandlerC1990am(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_my_works);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7194l = extras.getBoolean("AMS_SAVE_FLAG", false);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m7030p();
        this.f7195m = (GridView) findViewById(R.id.grid_user_file_list);
        this.f7195m.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        this.f7195m.setOnItemClickListener(new C1986ai(this));
        m7026l();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        m7029o();
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
        m7019h();
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
    public Context m7016g() {
        return this;
    }

    /* renamed from: h */
    private void m7019h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7005a(String str) {
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
    public void m7006a(String str, boolean z) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7020i() {
        if (this.f7197o) {
            m7024k();
            m7007a(false);
            m7010b(true);
            m7012c(true);
            this.f7196n.m7166c();
            return;
        }
        m7007a(true);
        m7010b(false);
        m7012c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7023j() {
        if (this.f7197o) {
            this.f7196n.m7165b();
            m7007a(false);
            m7010b(true);
            m7012c(true);
            return;
        }
        m7019h();
    }

    /* renamed from: a */
    private void m7007a(boolean z) {
        if (z) {
            this.f7197o = true;
        } else {
            this.f7197o = false;
        }
        this.f7196n.m7166c();
    }

    /* renamed from: k */
    private void m7024k() {
        String strM7189b;
        boolean[] zArrM7164a = this.f7196n.m7164a();
        if (zArrM7164a != null) {
            int length = zArrM7164a.length;
            for (int i = 0; i < length; i++) {
                if (zArrM7164a[i] && (strM7189b = C2064n.m7173a().m7189b(i)) != null) {
                    File file = new File(strM7189b);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
            if (length > 0) {
                m6262a(R.string.ams_msg_deleted);
                m7026l();
            }
        }
    }

    /* renamed from: l */
    private void m7026l() {
        new AsyncTaskC1993ap(this, null).execute("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m7027m() {
        if (this.f7196n != null) {
            this.f7196n = null;
        }
        this.f7196n = new C1994aq(this);
        this.f7196n.m7163a(this.f7201s);
        this.f7195m.setAdapter((ListAdapter) this.f7196n);
        this.f7196n.m7166c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m7028n() {
        C1786r.m6063c("loadAMSFilesBitmap", getClass().getSimpleName());
        C2064n c2064nM7173a = C2064n.m7173a();
        if (this.f7199q != null) {
            int size = this.f7199q.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7199q.get(i)).recycle();
            }
            this.f7199q.clear();
            this.f7199q = null;
        }
        this.f7199q = new ArrayList();
        int iM7190c = c2064nM7173a.m7190c();
        for (int i2 = 0; i2 < iM7190c; i2++) {
            this.f7199q.add(c2064nM7173a.m7188b(i2, false));
        }
    }

    /* renamed from: o */
    private void m7029o() {
        C1786r.m6063c("releaseAMSFilesBitmap", getClass().getSimpleName());
        if (this.f7199q != null) {
            int size = this.f7199q.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7199q.get(i)).recycle();
            }
            this.f7199q.clear();
            this.f7199q = null;
        }
    }

    /* renamed from: p */
    private void m7030p() {
        this.f7200r = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f7200r.setText(R.string.ams_title_my_works);
        this.f7200r.setButtonImageResource(R.drawable.general_btn_icon_delete_xml);
        this.f7200r.setBackClickListener(new ViewOnClickListenerC1991an(this));
        this.f7200r.setButtonClickListener(new ViewOnClickListenerC1992ao(this));
    }

    /* renamed from: b */
    private void m7010b(boolean z) {
        if (this.f7200r != null) {
            if (z) {
                this.f7200r.setButtonImageResource(R.drawable.general_btn_icon_delete_xml);
            } else {
                this.f7200r.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7012c(boolean z) {
        if (this.f7200r != null) {
            this.f7200r.setButtonEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m7031q() {
        if (this.f7198p != null) {
            this.f7198p = null;
        }
        this.f7198p = new ProgressDialogC1806j(this);
        this.f7198p.setProgressStyle(0);
        this.f7198p.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        if (!this.f7198p.isShowing()) {
            this.f7198p.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m7032r() {
        if (this.f7198p.isShowing()) {
            this.f7198p.dismiss();
        }
    }
}
