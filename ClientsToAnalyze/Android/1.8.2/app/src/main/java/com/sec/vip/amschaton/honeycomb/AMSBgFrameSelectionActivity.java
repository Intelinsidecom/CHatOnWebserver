package com.sec.vip.amschaton.honeycomb;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActionBarView;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.DialogC1891h;
import com.sec.vip.amschaton.InterfaceC1872be;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class AMSBgFrameSelectionActivity extends AMSActivity implements InterfaceC1872be {

    /* renamed from: n */
    private final String f6903n = "bg_org_hp";

    /* renamed from: o */
    private final String f6904o = "AMS_Skin_%02d.png";

    /* renamed from: p */
    private String[] f6905p = null;

    /* renamed from: q */
    private Bitmap[] f6906q = null;

    /* renamed from: r */
    private int f6907r = 0;

    /* renamed from: s */
    private int f6908s = -16777216;

    /* renamed from: t */
    private C1953d f6909t = null;

    /* renamed from: l */
    DialogC1891h f6901l = null;

    /* renamed from: m */
    AMSActionBarView f6902m = null;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_frame);
        Bundle extras = getIntent().getExtras();
        this.f6907r = extras.getInt("BACKGROUND_INDEX", -3);
        this.f6908s = extras.getInt("BACKGROUND_COLOR");
        this.f6905p = new String[12];
        for (int i = 0; i < 12; i++) {
            this.f6905p[i] = String.format("AMS_Skin_%02d.png", Integer.valueOf(i + 1));
        }
        this.f6906q = new Bitmap[this.f6905p.length];
        this.f6909t = new C1953d(this, this);
        m6551l();
        GridView gridView = (GridView) findViewById(R.id.gridview_frame);
        gridView.setAdapter((ListAdapter) this.f6909t);
        gridView.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        gridView.setOnItemClickListener(new C1892a(this, gridView));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6547h();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    m6537a(intent.getExtras());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6546g() {
        if (this.f6901l != null) {
            this.f6901l.dismiss();
            this.f6901l = null;
        }
        this.f6901l = new DialogC1891h(this);
        this.f6901l.m6534a(this.f6908s);
        this.f6901l.m6535a(this);
        this.f6901l.show();
    }

    /* renamed from: h */
    private void m6547h() {
        if (this.f6901l != null && this.f6901l.isShowing()) {
            m6546g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6548i() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_add_frame_title).setItems(R.array.ams_strarr_add_bg_image, new DialogInterfaceOnClickListenerC1946c(this)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1919b(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6539b(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", i);
        startActivityForResult(intent, 0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6063c("[onResume]", getClass().getName());
        super.onResume();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        C1786r.m6063c("[onPause]", getClass().getName());
        super.onPause();
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() {
        this.f6907r = -2;
        this.f6908s = this.f6901l.m6533a();
        this.f6909t.m6858a();
        m6549j();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        if (this.f6901l != null && this.f6901l.isShowing()) {
            this.f6901l.dismiss();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6549j() {
        Bundle bundle = new Bundle();
        bundle.putInt("BACKGROUND_INDEX", this.f6907r);
        if (this.f6907r < 0) {
            if (this.f6907r == -2) {
                bundle.putInt("AMS_FRAME", 1003);
                bundle.putInt("BACKGROUND_COLOR", this.f6908s);
            } else {
                bundle.putInt("AMS_FRAME", 1000);
            }
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(-1, intent);
        } else {
            String str = this.f6905p[this.f6907r];
            bundle.putInt("AMS_FRAME", 1002);
            bundle.putString("BG_SKIN_PATH", "bg_org_hp/" + str);
            Intent intent2 = new Intent();
            intent2.putExtras(bundle);
            setResult(-1, intent2);
        }
        finish();
    }

    /* renamed from: a */
    private void m6537a(Bundle bundle) {
        if (bundle == null) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("AMS_FRAME", 1001);
        intent.putExtra("BACKGROUND_INDEX", this.f6907r);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: k */
    private void m6550k() {
        this.f6902m = (AMSActionBarView) findViewById(R.id.actionbar);
    }

    /* renamed from: l */
    private void m6551l() {
        m6550k();
        this.f6902m.setTitleText(R.string.ams_app_name);
        this.f6902m.setMoreOptionIconVisibility(false);
        this.f6902m.setActionButtonLayoutVisibility(false);
    }
}
