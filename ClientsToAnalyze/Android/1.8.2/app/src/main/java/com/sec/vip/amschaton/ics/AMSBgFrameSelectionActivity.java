package com.sec.vip.amschaton.ics;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.DialogC1888e;
import com.sec.vip.amschaton.InterfaceC1872be;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.GeneralHeaderView;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSBgFrameSelectionActivity extends Activity implements InterfaceC1872be {

    /* renamed from: b */
    private final String f7130b = "bg_org_hp";

    /* renamed from: c */
    private final String f7131c = "AMS_Skin_%02d.png";

    /* renamed from: d */
    private String[] f7132d = null;

    /* renamed from: e */
    private Bitmap[] f7133e = null;

    /* renamed from: f */
    private int f7134f = 0;

    /* renamed from: g */
    private int f7135g = -16777216;

    /* renamed from: h */
    private C2038e f7136h = null;

    /* renamed from: a */
    DialogC1888e f7129a = null;

    /* renamed from: i */
    private GeneralHeaderView f7137i = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_frame);
        m6878h();
        Bundle extras = getIntent().getExtras();
        this.f7134f = extras.getInt("BACKGROUND_INDEX", 0);
        this.f7135g = extras.getInt("BACKGROUND_COLOR");
        this.f7132d = new String[12];
        for (int i = 0; i < 12; i++) {
            this.f7132d[i] = String.format("AMS_Skin_%02d.png", Integer.valueOf(i + 1));
        }
        this.f7133e = new Bitmap[this.f7132d.length];
        this.f7136h = new C2038e(this, this);
        GridView gridView = (GridView) findViewById(R.id.gridview_frame);
        gridView.setAdapter((ListAdapter) this.f7136h);
        gridView.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        gridView.setOnItemClickListener(new C1977a(this, gridView));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6870d();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    m6862a(intent.getExtras());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6869c() {
        if (this.f7129a != null) {
            this.f7129a.dismiss();
            this.f7129a = null;
        }
        this.f7129a = new DialogC1888e(this);
        this.f7129a.m6527a(this.f7135g);
        this.f7129a.m6528a(this);
        this.f7129a.show();
    }

    /* renamed from: d */
    private void m6870d() {
        if (this.f7129a != null && this.f7129a.isShowing()) {
            m6869c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6872e() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_add_frame_title).setItems(R.array.ams_strarr_add_bg_image, new DialogInterfaceOnClickListenerC2031c(this)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC2004b(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6861a(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", i);
        startActivityForResult(intent, 0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        C1786r.m6063c("[onResume]", getClass().getName());
        super.onResume();
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Throwable {
        this.f7134f = -2;
        this.f7135g = this.f7129a.m6526a();
        this.f7136h.m7171a();
        m6874f();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6874f() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSBgFrameSelectionActivity.m6874f():void");
    }

    /* renamed from: a */
    private void m6864a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m6867b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m6862a(Bundle bundle) {
        if (bundle == null) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("AMS_FRAME", 1000);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6876g() {
        finish();
    }

    /* renamed from: h */
    private void m6878h() {
        this.f7137i = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f7137i.setText(R.string.ams_title_frame);
        this.f7137i.setButtonImageResource(0);
        this.f7137i.setBackClickListener(new ViewOnClickListenerC2037d(this));
    }
}
