package com.sec.vip.amschaton.honeycomb;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.DialogC1548m;
import com.sec.vip.amschaton.InterfaceC1397bg;
import com.sec.widget.AlertDialogBuilderC1625m;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSBgFrameSelectionActivity extends Activity implements InterfaceC1397bg {

    /* renamed from: b */
    private final String f4927b = "bg_org_hp";

    /* renamed from: c */
    private final String f4928c = "AMS_Skin_%02d.png";

    /* renamed from: d */
    private String[] f4929d = null;

    /* renamed from: e */
    private Bitmap[] f4930e = null;

    /* renamed from: f */
    private int f4931f = 0;

    /* renamed from: g */
    private int f4932g = -16777216;

    /* renamed from: h */
    private C1451j f4933h = null;

    /* renamed from: a */
    DialogC1548m f4926a = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_frame);
        Bundle extras = getIntent().getExtras();
        this.f4931f = extras.getInt("BACKGROUND_INDEX", 0);
        this.f4932g = extras.getInt("BACKGROUND_COLOR");
        this.f4929d = new String[12];
        for (int i = 0; i < 12; i++) {
            this.f4929d[i] = String.format("AMS_Skin_%02d.png", Integer.valueOf(i + 1));
        }
        this.f4930e = new Bitmap[this.f4929d.length];
        this.f4933h = new C1451j(this, this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        GridView gridView = (GridView) findViewById(R.id.gridview_frame);
        gridView.setAdapter((ListAdapter) this.f4933h);
        gridView.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        gridView.setOnItemClickListener(new C1459r(this, gridView));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m5022d();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    m5014a(intent.getExtras());
                    break;
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5021c() {
        if (this.f4926a != null) {
            this.f4926a.dismiss();
            this.f4926a = null;
        }
        this.f4926a = new DialogC1548m(this);
        this.f4926a.m5624a(this.f4932g);
        this.f4926a.m5625a(this);
        this.f4926a.show();
    }

    /* renamed from: d */
    private void m5022d() {
        if (this.f4926a != null && this.f4926a.isShowing()) {
            m5021c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5024e() {
        new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_add_frame_title).setItems(R.array.ams_strarr_add_bg_image, new DialogInterfaceOnClickListenerC1461t(this)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1460s(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5013a(int i) {
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
        this.f4931f = -2;
        this.f4932g = this.f4926a.m5623a();
        this.f4933h.m5273a();
        m5026f();
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
    public void m5026f() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.AMSBgFrameSelectionActivity.m5026f():void");
    }

    /* renamed from: a */
    private void m5016a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5019b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m5014a(Bundle bundle) {
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
}
