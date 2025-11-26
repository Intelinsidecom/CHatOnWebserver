package com.sec.vip.amschaton.ics;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.DialogC1548m;
import com.sec.vip.amschaton.InterfaceC1397bg;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.GeneralHeaderView;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSBgFrameSelectionActivity extends Activity implements InterfaceC1397bg {

    /* renamed from: b */
    private final String f5170b = "bg_org_hp";

    /* renamed from: c */
    private final String f5171c = "AMS_Skin_%02d.png";

    /* renamed from: d */
    private String[] f5172d = null;

    /* renamed from: e */
    private Bitmap[] f5173e = null;

    /* renamed from: f */
    private int f5174f = 0;

    /* renamed from: g */
    private int f5175g = -16777216;

    /* renamed from: h */
    private C1511bo f5176h = null;

    /* renamed from: a */
    DialogC1548m f5169a = null;

    /* renamed from: i */
    private GeneralHeaderView f5177i = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_frame);
        m5331h();
        Bundle extras = getIntent().getExtras();
        this.f5174f = extras.getInt("BACKGROUND_INDEX", 0);
        this.f5175g = extras.getInt("BACKGROUND_COLOR");
        this.f5172d = new String[12];
        for (int i = 0; i < 12; i++) {
            this.f5172d[i] = String.format("AMS_Skin_%02d.png", Integer.valueOf(i + 1));
        }
        this.f5173e = new Bitmap[this.f5172d.length];
        this.f5176h = new C1511bo(this, this);
        GridView gridView = (GridView) findViewById(R.id.gridview_frame);
        gridView.setAdapter((ListAdapter) this.f5176h);
        gridView.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        gridView.setOnItemClickListener(new C1482am(this, gridView));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m5323d();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    m5315a(intent.getExtras());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5322c() {
        if (this.f5169a != null) {
            this.f5169a.dismiss();
            this.f5169a = null;
        }
        this.f5169a = new DialogC1548m(this);
        this.f5169a.m5624a(this.f5175g);
        this.f5169a.m5625a(this);
        this.f5169a.show();
    }

    /* renamed from: d */
    private void m5323d() {
        if (this.f5169a != null && this.f5169a.isShowing()) {
            m5322c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5325e() {
        new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_add_frame_title).setItems(R.array.ams_strarr_add_bg_image, new DialogInterfaceOnClickListenerC1484ao(this)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1481al(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5314a(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", i);
        startActivityForResult(intent, 0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        C1341p.m4660c("[onResume]", getClass().getName());
        super.onResume();
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() throws Throwable {
        this.f5174f = -2;
        this.f5175g = this.f5169a.m5623a();
        this.f5176h.m5614a();
        m5327f();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00de  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5327f() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSBgFrameSelectionActivity.m5327f():void");
    }

    /* renamed from: a */
    private void m5317a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5320b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m5315a(Bundle bundle) {
        if (bundle == null) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("AMS_FRAME", 1001);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5329g() {
        finish();
    }

    /* renamed from: h */
    private void m5331h() {
        this.f5177i = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f5177i.setText(R.string.ams_background);
        this.f5177i.setButtonImageResource(0);
        this.f5177i.setBackClickListener(new ViewOnClickListenerC1483an(this));
    }
}
