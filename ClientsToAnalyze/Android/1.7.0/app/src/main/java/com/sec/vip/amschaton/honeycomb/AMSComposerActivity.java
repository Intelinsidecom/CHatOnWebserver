package com.sec.vip.amschaton.honeycomb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C1369af;
import com.sec.vip.amschaton.C1385av;
import com.sec.vip.amschaton.C1395be;
import com.sec.vip.amschaton.C1561z;
import com.sec.vip.amschaton.InterfaceC1368ae;
import com.sec.vip.amschaton.InterfaceC1375al;
import com.sec.vip.amschaton.InterfaceC1397bg;
import com.sec.vip.amschaton.InterfaceC1552q;
import com.sec.vip.amschaton.InterfaceC1553r;
import com.sec.vip.amschaton.ViewOnClickListenerC1382as;
import com.sec.widget.AlertDialogBuilderC1625m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSComposerActivity extends AMSActivity implements View.OnClickListener, InterfaceC1375al, InterfaceC1552q, InterfaceC1553r {

    /* renamed from: a */
    public static boolean f4934a = true;

    /* renamed from: b */
    public static boolean f4935b = false;

    /* renamed from: A */
    private AMSDrawManager f4936A;

    /* renamed from: P */
    private String f4951P;

    /* renamed from: W */
    private int f4958W;

    /* renamed from: X */
    private int f4959X;

    /* renamed from: n */
    private ImageView f4964n;

    /* renamed from: o */
    private ImageView f4965o;

    /* renamed from: p */
    private ImageView f4966p;

    /* renamed from: q */
    private ImageView f4967q;

    /* renamed from: r */
    private ImageView f4968r;

    /* renamed from: s */
    private ImageView f4969s;

    /* renamed from: t */
    private ImageView f4970t;

    /* renamed from: u */
    private ImageView f4971u;

    /* renamed from: z */
    private PopupWindow f4976z;

    /* renamed from: c */
    private float f4963c = 1.0f;

    /* renamed from: v */
    private Bitmap f4972v = null;

    /* renamed from: w */
    private Bitmap f4973w = null;

    /* renamed from: x */
    private Bitmap f4974x = null;

    /* renamed from: y */
    private Bitmap f4975y = null;

    /* renamed from: B */
    private int f4937B = 2000;

    /* renamed from: C */
    private int f4938C = 2002;

    /* renamed from: D */
    private int f4939D = 0;

    /* renamed from: E */
    private int f4940E = 0;

    /* renamed from: F */
    private int f4941F = -16777216;

    /* renamed from: G */
    private int f4942G = -16777216;

    /* renamed from: H */
    private int f4943H = 2;

    /* renamed from: I */
    private boolean f4944I = false;

    /* renamed from: J */
    private boolean f4945J = false;

    /* renamed from: K */
    private InterfaceC1397bg f4946K = null;

    /* renamed from: L */
    private RelativeLayout f4947L = null;

    /* renamed from: M */
    private ViewOnClickListenerC1382as f4948M = null;

    /* renamed from: N */
    private int f4949N = 0;

    /* renamed from: O */
    private boolean f4950O = true;

    /* renamed from: Q */
    private boolean f4952Q = true;

    /* renamed from: R */
    private boolean f4953R = false;

    /* renamed from: S */
    private boolean f4954S = false;

    /* renamed from: T */
    private int f4955T = -2;

    /* renamed from: U */
    private boolean f4956U = true;

    /* renamed from: V */
    private RelativeLayout f4957V = null;

    /* renamed from: Y */
    private boolean f4960Y = false;

    /* renamed from: Z */
    private Handler f4961Z = new HandlerC1406ab(this);

    /* renamed from: aa */
    private InterfaceC1368ae f4962aa = new C1445d(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        f4935b = false;
        m5032E();
        m4741d();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4951P = extras.getString("AMS_FILE_PATH");
            this.f4953R = extras.getBoolean("AMS_SAVE_FLAG", false);
            this.f4954S = extras.getBoolean("AMS_EDIT_FLAG", false);
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f4951P = null;
        }
        this.f4952Q = this.f4951P == null;
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f4956U = true;
            this.f4963c = getWindowManager().getDefaultDisplay().getWidth() / 480.0f;
        } else if (configuration.orientation == 2) {
            this.f4956U = false;
            this.f4963c = getWindowManager().getDefaultDisplay().getHeight() / 480.0f;
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.ams_ics_layout_composer);
        m5101n();
        m5107p();
        m5109q();
        if (AMSStampSelectionActivity.f5018a) {
            if (C1561z.m5654a().m5665c() > 0) {
                this.f4949N = (C1561z.m5654a().m5665c() + 1000) - 1;
            } else {
                this.f4949N = 0;
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        if (f4934a && this.f4953R && this.f4936A.m4806t()) {
            m5085i();
        }
        if (this.f4972v != null) {
            this.f4972v.recycle();
            this.f4972v = null;
        }
        if (this.f4973w != null) {
            this.f4973w.recycle();
            this.f4973w = null;
        }
        if (this.f4974x != null) {
            this.f4974x.recycle();
            this.f4974x = null;
        }
        if (this.f4975y != null) {
            this.f4975y.recycle();
            this.f4975y = null;
        }
        if (this.f4936A != null) {
            this.f4936A.m4807u();
            this.f4936A = null;
        }
        this.f4960Y = false;
        f4935b = true;
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1341p.m4660c("[onResume]", getClass().getName());
        f4934a = true;
        m4739b();
        invalidateOptionsMenu();
        if (this.f4945J && this.f4948M != null) {
            m5043a(this.f4948M.m4962b(), true);
        }
        super.onResume();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        C1341p.m4660c("[onPause]", getClass().getName());
        if (this.f4945J && this.f4948M != null) {
            m5043a(this.f4948M.m4962b(), false);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1341p.m4660c("[onRestoreInstanceState]", getClass().getName());
        if (bundle != null && bundle.getBoolean("SI_SAVE_TEMP_AMS", false)) {
            this.f4953R = bundle.getBoolean("SI_SAVE_FLAG", this.f4953R);
            this.f4954S = bundle.getBoolean("SI_EDIT_FLAG", this.f4954S);
            this.f4951P = f4627i;
            m5052b(3000);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1341p.m4660c("[onSaveInstanceState]", getClass().getName());
        boolean z = true;
        if (this.f4936A.m4806t()) {
            if (!m5067d(false)) {
                C1341p.m4660c("[onSaveInstanceState] Cannot save temp AMS file!", getClass().getName());
                z = false;
            }
            bundle.putBoolean("SI_SAVE_FLAG", this.f4953R);
            bundle.putBoolean("SI_EDIT_FLAG", this.f4954S);
        } else {
            z = false;
        }
        bundle.putBoolean("SI_SAVE_TEMP_AMS", z);
        f4934a = false;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f4956U = true;
        } else if (configuration.orientation == 2) {
            this.f4956U = false;
        }
        setContentView(R.layout.ams_ics_layout_composer);
        m5104o();
        m5107p();
        if (this.f4936A != null) {
            this.f4936A.m4809w();
        }
        m5111r();
        if (this.f4945J && this.f4948M != null) {
            m5056b(this.f4948M.m4962b().getText().toString());
            m5071e(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f4945J) {
            m5071e(false);
            return;
        }
        if (!this.f4953R || !this.f4936A.m4806t()) {
            f4934a = false;
        }
        m5038a();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        Bundle extras;
        switch (i) {
            case 3:
                if (i2 == -1 && (extras = intent.getExtras()) != null) {
                    int i3 = extras.getInt("AMS_FRAME", 1002);
                    if (i3 == 1000) {
                        m5117w();
                        break;
                    } else if (i3 == 1003) {
                        int i4 = extras.getInt("BACKGROUND_COLOR", -16777216);
                        this.f4936A.m4776a(Color.red(i4), Color.green(i4), Color.blue(i4), true);
                        this.f4936A.m4793g();
                        m5034G();
                        break;
                    } else {
                        Bitmap bitmapM5035a = m5035a(intent, extras);
                        if (bitmapM5035a != null) {
                            m5041a(bitmapM5035a);
                            bitmapM5035a.recycle();
                            File file = new File(f4628j);
                            if (file.exists()) {
                                file.delete();
                                break;
                            }
                        }
                    }
                }
                break;
            case 11:
                if (i2 != -1) {
                    if (this.f4936A.m4791e() == null) {
                        if (this.f4949N > C1561z.m5654a().m5670f()) {
                            Bitmap bitmapM5664b = C1561z.m5654a().m5664b(this.f4949N - 1000, false);
                            if (bitmapM5664b == null) {
                                this.f4949N = 0;
                            } else {
                                bitmapM5664b.recycle();
                            }
                        }
                        this.f4936A.m4775a(3, this.f4949N, 0, 0);
                        m5076g(this.f4937B);
                        break;
                    }
                } else {
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        this.f4949N = extras2.getInt("AMS_STAMP_INDEX", 0);
                        if (this.f4949N < 0 || this.f4949N > C1561z.m5654a().m5670f()) {
                            Bitmap bitmapM5664b2 = C1561z.m5654a().m5664b(this.f4949N - 1000, false);
                            if (bitmapM5664b2 == null) {
                                this.f4949N = 0;
                            } else {
                                bitmapM5664b2.recycle();
                            }
                        }
                        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 3);
                        int[] iArr = {sharedPreferences.getInt("AMS_STAMP_PREF_00", -1), sharedPreferences.getInt("AMS_STAMP_PREF_01", -1), sharedPreferences.getInt("AMS_STAMP_PREF_02", -1), sharedPreferences.getInt("AMS_STAMP_PREF_03", -1)};
                        int i5 = iArr[0];
                        int i6 = 0;
                        while (i6 < 4) {
                            int i7 = iArr[i6];
                            iArr[i6] = i5;
                            if (i7 != this.f4949N) {
                                i6++;
                                i5 = i7;
                            } else {
                                iArr[0] = this.f4949N;
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                                this.f4936A.m4775a(3, this.f4949N, 0, 0);
                                m5076g(this.f4937B);
                                m5033F();
                                break;
                            }
                        }
                        iArr[0] = this.f4949N;
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                        this.f4936A.m4775a(3, this.f4949N, 0, 0);
                        m5076g(this.f4937B);
                        m5033F();
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        m5071e(false);
        switch (view.getId()) {
            case R.id.btn_tool_background_image /* 2131427399 */:
                m5115u();
                break;
            case R.id.btn_tool_pen /* 2131427400 */:
                if (this.f4976z == null || !this.f4976z.isShowing()) {
                    m5090j();
                    break;
                }
                break;
            case R.id.btn_tool_stamp_shape /* 2131427401 */:
                m5116v();
                break;
            case R.id.btn_tool_text /* 2131427402 */:
                if (this.f4976z == null || !this.f4976z.isShowing()) {
                    m5093k();
                    break;
                }
                break;
            case R.id.btn_preview /* 2131427404 */:
                if (!this.f4960Y) {
                    this.f4960Y = true;
                    m5118x();
                    break;
                }
                break;
            case R.id.btn_undo /* 2131427405 */:
                this.f4936A.m4797k();
                break;
            case R.id.btn_redo /* 2131427406 */:
                this.f4936A.m4798l();
                break;
            case R.id.btn_send /* 2131427407 */:
                m5120z();
                break;
        }
        invalidateOptionsMenu();
    }

    /* renamed from: a */
    private void m5038a() {
        f4934a = false;
        if (!this.f4953R || !this.f4936A.m4803q()) {
            m5082h();
        } else {
            new AlertDialogBuilderC1625m(this).setMessage(R.string.ams_msg_exit_with_save).setPositiveButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC1407ac(this)).setNegativeButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC1405aa(this)).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5082h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5085i() {
        if (!this.f4936A.m4780a(f4624f + m5037a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m4738a(R.string.ams_error_ams_file_save);
        } else {
            m4738a(R.string.ams_msg_saved);
        }
    }

    /* renamed from: b */
    private void m5052b(int i) {
        new Thread(new RunnableC1465x(this, i)).start();
    }

    /* renamed from: j */
    private void m5090j() throws Resources.NotFoundException {
        m5086i(false);
        this.f4936A.setEditMode(false, false);
        this.f4937B = 2002;
        m5060c(this.f4937B);
        if (this.f4938C != this.f4937B) {
            this.f4936A.m4775a(1, this.f4939D, this.f4941F, this.f4940E);
            this.f4938C = this.f4937B;
            m5076g(this.f4937B);
            m5034G();
            return;
        }
        this.f4938C = this.f4937B;
        m5112s();
    }

    /* renamed from: k */
    private void m5093k() throws Resources.NotFoundException {
        this.f4937B = 2003;
        m5060c(this.f4937B);
        if (this.f4938C != 2003) {
            this.f4936A.setEditMode(false, false);
            this.f4936A.m4775a(2, 0, this.f4942G, this.f4943H);
            this.f4938C = this.f4937B;
            m5076g(this.f4937B);
            m5034G();
            m5086i(true);
            return;
        }
        this.f4938C = this.f4937B;
        m5114t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5096l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5098m() {
        if (!this.f4968r.isEnabled() && this.f4936A.m4803q()) {
            this.f4968r.setEnabled(true);
        } else if (this.f4968r.isEnabled() && !this.f4936A.m4803q()) {
            this.f4968r.setEnabled(false);
        }
        if (!this.f4969s.isEnabled() && this.f4936A.m4804r()) {
            this.f4969s.setEnabled(true);
        } else if (this.f4969s.isEnabled() && !this.f4936A.m4804r()) {
            this.f4969s.setEnabled(false);
        }
        if (!this.f4970t.isEnabled() && this.f4936A.m4806t()) {
            this.f4970t.setEnabled(true);
            this.f4971u.setEnabled(true);
        } else if (this.f4970t.isEnabled() && !this.f4936A.m4806t()) {
            this.f4970t.setEnabled(false);
            this.f4971u.setEnabled(false);
        }
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5060c(int i) throws Resources.NotFoundException {
        m5064d(i);
        m5076g(i);
    }

    /* renamed from: d */
    private void m5064d(int i) {
        int[] iArr = {2002, 2003, 2005, 2001};
        ImageView[] imageViewArr = {this.f4965o, this.f4966p, this.f4967q, this.f4964n};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(false);
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i) {
                imageViewArr[i3].setSelected(true);
            }
        }
    }

    /* renamed from: n */
    private void m5101n() throws Resources.NotFoundException {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_actionbar_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_top_menu_height);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_bottom_menu_height);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_canvas_margin);
        if (this.f4956U) {
            this.f4958W = width;
        } else {
            this.f4958W = (((height - dimensionPixelSize) - dimensionPixelSize2) - dimensionPixelSize3) - (dimensionPixelSize4 * 2);
        }
        C1341p.m4660c("[createComposer] Composer Size = " + this.f4958W, getClass().getSimpleName());
        this.f4959X = this.f4958W;
        if (this.f4936A != null) {
            this.f4936A.m4807u();
            this.f4936A = null;
        }
        this.f4936A = new AMSDrawManager(this, this.f4958W, this.f4959X);
        this.f4936A.m4772a();
        this.f4936A.setEnableZoom(true);
        this.f4936A.setPlayMode(false);
        this.f4936A.setOnTextInputRequestListener(this);
        this.f4936A.setOnObjectListener(this);
        this.f4936A.setOnTouchTextArea(this);
        this.f4936A.setEraserSize(this.f4940E);
        if (!this.f4952Q) {
            m5117w();
        }
        m5104o();
    }

    /* renamed from: o */
    private void m5104o() {
        if (this.f4957V != null) {
            this.f4957V.removeAllViews();
            this.f4957V = null;
        }
        this.f4957V = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f4957V.setLayoutParams(layoutParams);
        this.f4957V.addView(this.f4936A);
    }

    /* renamed from: p */
    private void m5107p() throws Resources.NotFoundException {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        relativeLayout.addView(this.f4957V);
        this.f4964n = (ImageView) findViewById(R.id.btn_tool_background_image);
        this.f4965o = (ImageView) findViewById(R.id.btn_tool_pen);
        this.f4966p = (ImageView) findViewById(R.id.btn_tool_text);
        this.f4967q = (ImageView) findViewById(R.id.btn_tool_stamp_shape);
        this.f4968r = (ImageView) findViewById(R.id.btn_undo);
        this.f4969s = (ImageView) findViewById(R.id.btn_redo);
        this.f4970t = (ImageView) findViewById(R.id.btn_preview);
        this.f4971u = (ImageView) findViewById(R.id.btn_send);
        this.f4964n.setOnClickListener(this);
        this.f4965o.setOnClickListener(this);
        this.f4966p.setOnClickListener(this);
        this.f4967q.setOnClickListener(this);
        this.f4968r.setOnClickListener(this);
        this.f4969s.setOnClickListener(this);
        this.f4970t.setOnClickListener(this);
        this.f4971u.setOnClickListener(this);
        if (!this.f4952Q) {
            m5052b(3000);
        }
        this.f4968r.setEnabled(this.f4936A.m4803q());
        this.f4969s.setEnabled(this.f4936A.m4804r());
        this.f4970t.setEnabled(this.f4936A.m4806t());
        this.f4971u.setEnabled(this.f4936A.m4806t());
        m5096l();
        m5060c(this.f4937B);
        m5052b(3001);
    }

    /* renamed from: q */
    private void m5109q() throws Resources.NotFoundException {
        this.f4937B = 2002;
        this.f4938C = this.f4937B;
        this.f4936A.m4775a(1, this.f4939D, this.f4941F, this.f4940E);
        m5060c(this.f4937B);
        m5052b(3001);
    }

    /* renamed from: r */
    private void m5111r() throws Resources.NotFoundException {
        if (this.f4976z != null && this.f4976z.isShowing()) {
            m5057b(false);
            switch (this.f4937B) {
                case 2002:
                    m5112s();
                    break;
                case 2003:
                    m5114t();
                    break;
            }
        }
    }

    /* renamed from: b */
    private boolean m5057b(boolean z) throws Resources.NotFoundException {
        this.f4937B = this.f4938C;
        if (this.f4976z == null) {
            m5060c(this.f4937B);
            return false;
        }
        if (!this.f4976z.isShowing()) {
            m5060c(this.f4937B);
            return false;
        }
        if (z) {
            new View(this).post(new RunnableC1464w(this));
        } else {
            this.f4976z.dismiss();
            m5060c(this.f4937B);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5040a(int i, int i2, int i3) throws Resources.NotFoundException {
        this.f4939D = i;
        this.f4940E = i2;
        this.f4941F = i3;
        this.f4936A.m4775a(1, this.f4939D, this.f4941F, this.f4940E);
        m5034G();
        m5076g(this.f4937B);
        m5033F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5039a(int i, int i2) throws Resources.NotFoundException {
        this.f4943H = i;
        this.f4942G = i2;
        if (this.f4936A.m4791e() == null) {
            this.f4936A.m4775a(2, 0, this.f4942G, this.f4943H);
        } else {
            this.f4936A.m4774a(0, this.f4942G, this.f4943H);
        }
        m5034G();
        m5076g(this.f4937B);
        m5053b(this.f4942G, this.f4943H);
        m5033F();
    }

    /* renamed from: s */
    private void m5112s() {
        C1369af c1369af = new C1369af(this, R.layout.ams_ics2_layout_tool_pen_popup, this.f4965o, this.f4956U);
        c1369af.m4919a(this.f4939D);
        c1369af.m4920b(this.f4940E);
        c1369af.m4921c(this.f4941F);
        c1369af.m5649a(new C1467z(this, c1369af));
        this.f4976z = c1369af;
    }

    /* renamed from: t */
    private void m5114t() {
        C1395be c1395be = new C1395be(this, R.layout.ams_ics2_layout_tool_text_popup, this.f4966p, this.f4956U);
        c1395be.m4999a(this.f4943H);
        c1395be.m5000b(this.f4942G);
        c1395be.m5649a(new C1466y(this, c1395be));
        this.f4976z = c1395be;
    }

    /* renamed from: u */
    private void m5115u() throws Resources.NotFoundException {
        m5086i(false);
        Intent intent = new Intent(this, (Class<?>) AMSBgFrameSelectionActivity.class);
        intent.putExtra("BACKGROUND_COLOR", this.f4936A.m4782b());
        intent.putExtra("BACKGROUND_INDEX", this.f4955T);
        startActivityForResult(intent, 3);
    }

    /* renamed from: v */
    private void m5116v() throws Resources.NotFoundException {
        m5086i(false);
        this.f4936A.setEditMode(false, false);
        this.f4937B = 2005;
        m5060c(this.f4937B);
        if (this.f4938C != 2005 && !this.f4950O) {
            this.f4936A.m4775a(3, this.f4949N, 0, 0);
            this.f4938C = this.f4937B;
            m5076g(this.f4937B);
            m5034G();
            return;
        }
        if (this.f4950O) {
            this.f4950O = false;
            this.f4936A.m4775a(3, this.f4949N, 0, 0);
            this.f4938C = this.f4937B;
            m5076g(this.f4937B);
            m5034G();
        }
        this.f4938C = this.f4937B;
        Intent intent = new Intent(this, (Class<?>) AMSStampSelectionActivity.class);
        intent.putExtra("AMS_STAMP_INDEX", this.f4949N);
        startActivityForResult(intent, 11);
    }

    /* renamed from: e */
    private void m5068e(int i) {
        f4934a = false;
        if (!this.f4953R || !this.f4936A.m4803q()) {
            m5072f(i);
        } else {
            new AlertDialogBuilderC1625m(this).setMessage(R.string.ams_msg_exit_with_save).setPositiveButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC1462u(this, i)).setNegativeButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC1463v(this, i)).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5072f(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2001);
        intent.putExtra("AMS_TAB_ID", i);
        intent.putExtra("AMS_SAVE_FLAG", this.f4953R);
        startActivity(intent);
        finish();
    }

    /* renamed from: w */
    private void m5117w() {
        if (this.f4936A != null) {
            this.f4936A.m4776a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, true);
            this.f4936A.m4793g();
            m5034G();
        }
    }

    /* renamed from: a */
    private void m5041a(Bitmap bitmap) {
        this.f4936A.m4777a(bitmap, true);
        this.f4936A.setEditMode(false, true);
        m5034G();
    }

    /* renamed from: x */
    private void m5118x() {
        if (!m5067d(false)) {
            this.f4960Y = false;
            return;
        }
        f4934a = false;
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2004);
        intent.putExtra("AMS_FILE_PATH", f4627i);
        intent.putExtra("AMS_SAVE_FLAG", this.f4953R);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m5119y() throws Resources.NotFoundException {
        if (this.f4936A != null) {
            this.f4953R = false;
            m5101n();
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            relativeLayout.addView(this.f4957V);
            m5109q();
            m5098m();
        }
    }

    /* renamed from: z */
    private void m5120z() {
        if (this.f4936A != null) {
            if (!this.f4936A.m4806t()) {
                m4738a(R.string.ams_msg_empty_ams);
            } else {
                new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_title_send).setItems(R.array.ams_strarr_sending_mode, new DialogInterfaceOnClickListenerC1447f(this)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1449h(this)).create().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m5059c(boolean z) {
        String str = f4624f + m5037a("A", System.currentTimeMillis(), ".jpg");
        if (!this.f4936A.m4780a(str)) {
            m4738a(R.string.ams_error_ams_file_save);
            return null;
        }
        File file = new File(str);
        if (file.length() < 1048576 || !z) {
            return str;
        }
        file.delete();
        new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_btn_send).setMessage(String.format("%s\n(%d/%d)", getResources().getString(R.string.ams_msg_exceed_limit), Long.valueOf(file.length()), 1048576)).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1448g(this)).create().show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[PHI: r3
  0x0061: PHI (r3v1 long) = (r3v17 long), (r3v18 long), (r3v19 long), (r3v20 long), (r3v21 long), (r3v22 long) binds: [B:3:0x0028, B:32:0x007b, B:24:0x006e, B:15:0x0057, B:19:0x005e, B:9:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.FileOutputStream] */
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m5028A() throws java.lang.Throwable {
        /*
            r7 = this;
            r1 = 0
            r6 = 480(0x1e0, float:6.73E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.sec.vip.amschaton.honeycomb.AMSComposerActivity.f4629k
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "I"
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = ".jpg"
            java.lang.String r2 = r7.m5037a(r2, r3, r5)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f4936A
            boolean r2 = r2.m4793g()
            if (r2 == 0) goto L61
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f4936A
            android.graphics.Bitmap r2 = r2.m4792f()
            if (r2 == 0) goto L7b
            r3 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r6, r6, r3)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L52 java.io.IOException -> L69 java.lang.Throwable -> L89
            r3.<init>(r0)     // Catch: java.io.FileNotFoundException -> L52 java.io.IOException -> L69 java.lang.Throwable -> L89
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r5 = 80
            r2.compress(r4, r5, r3)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r2.recycle()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r3.flush()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r3.close()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L92
        L51:
            return r0
        L52:
            r2 = move-exception
            r3 = r1
        L54:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L51
        L5d:
            r0 = move-exception
        L5e:
            r0.printStackTrace()
        L61:
            r0 = 2131558802(0x7f0d0192, float:1.874293E38)
            r7.m4738a(r0)
            r0 = r1
            goto L51
        L69:
            r2 = move-exception
            r3 = r1
        L6b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L74
            goto L51
        L74:
            r0 = move-exception
            goto L5e
        L76:
            r0 = move-exception
            r0.printStackTrace()
        L7a:
            throw r1
        L7b:
            java.lang.String r0 = "Bitmap main is null"
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1341p.m4651a(r0, r2)
            goto L61
        L89:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L8c:
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.io.IOException -> L76
            goto L51
        L92:
            r0 = move-exception
            goto L5e
        L94:
            r1 = move-exception
            goto L8c
        L96:
            r2 = move-exception
            goto L6b
        L98:
            r2 = move-exception
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.AMSComposerActivity.m5028A():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5049a(String str, boolean z) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", z);
        startActivity(intent);
        finish();
    }

    /* renamed from: d */
    private boolean m5067d(boolean z) {
        if (this.f4936A == null) {
            C1341p.m4651a("[startAMSPreview] mAMSComposer is NULL!", getClass().getSimpleName());
            return false;
        }
        if (!z && !this.f4936A.m4806t()) {
            C1341p.m4651a("[startAMSPreview] Empty AMS file!", getClass().getSimpleName());
            return false;
        }
        File file = new File(f4627i);
        if (file.exists()) {
            file.delete();
        }
        if (!this.f4936A.m4780a(f4627i)) {
            C1341p.m4651a("[startAMSPreview] Fail to save AMS file!", getClass().getSimpleName());
            return false;
        }
        this.f4936A.setEditMode(false, false);
        return true;
    }

    /* renamed from: B */
    private Context m5029B() {
        return this;
    }

    /* renamed from: a */
    private Drawable m5036a(int i, int i2, int i3, int i4) throws Resources.NotFoundException {
        Drawable drawable;
        Drawable drawable2;
        if (i != 1) {
            return null;
        }
        if (this.f4972v != null) {
            this.f4972v.recycle();
            this.f4972v = null;
        }
        if (this.f4973w != null) {
            this.f4973w.recycle();
            this.f4973w = null;
        }
        int i5 = (int) (this.f4963c * 80.0f);
        int i6 = (int) (this.f4963c * 80.0f);
        Rect rect = new Rect(-50, 0, i5 - 50, i6);
        float f = 50 + (i5 * 0.5f);
        float f2 = i6 * 0.5f;
        if (!this.f4956U) {
            i5 = (int) (102.0f * this.f4963c);
            i6 = (int) (150.0f * this.f4963c);
            rect.set(0, -50, i5, i6 - 50);
            f = i5 * 0.5f;
            f2 = (i6 * 0.5f) + 50;
        }
        this.f4972v = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        this.f4973w = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f4972v);
        Canvas canvas2 = new Canvas(this.f4973w);
        switch (i2) {
            case 1:
                drawable = getResources().getDrawable(R.drawable.toolbar_pen_02);
                drawable2 = getResources().getDrawable(R.drawable.toolbar_pen_02);
                break;
            case 2:
                drawable = getResources().getDrawable(R.drawable.toolbar_pen_04);
                drawable2 = getResources().getDrawable(R.drawable.toolbar_pen_04);
                break;
            case 3:
                drawable = getResources().getDrawable(R.drawable.toolbar_pen_03);
                drawable2 = getResources().getDrawable(R.drawable.toolbar_pen_03);
                break;
            default:
                drawable = getResources().getDrawable(R.drawable.toolbar_pen_01);
                drawable2 = getResources().getDrawable(R.drawable.toolbar_pen_01);
                break;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        drawable2.setBounds(rect);
        drawable2.draw(canvas2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(-16777216);
        float f3 = this.f4940E * 2.5f * this.f4963c;
        canvas.drawCircle(f, f2, f3, paint);
        canvas2.drawCircle(f, f2, f3, paint);
        paint.setColor(this.f4941F);
        float f4 = f3 - 2.0f;
        canvas.drawCircle(f, f2, f4, paint);
        canvas2.drawCircle(f, f2, f4, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f4972v);
        bitmapDrawable.setTargetDensity(this.f4972v.getDensity());
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.f4973w);
        bitmapDrawable2.setTargetDensity(this.f4973w.getDensity());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, bitmapDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, bitmapDrawable2);
        return stateListDrawable;
    }

    /* renamed from: C */
    private Bitmap m5030C() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (this.f4963c * 80.0f), (int) (this.f4963c * 80.0f), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawARGB(0, 0, 0, 0);
        C1385av c1385av = new C1385av(2, this.f4942G, this.f4943H, false, this.f4958W, this.f4959X);
        c1385av.mo4887a(this.f4963c * 2.0f);
        c1385av.m4980b("Aa");
        int iM4981j = c1385av.m4981j();
        int iM4982k = c1385av.m4982k();
        c1385av.m5287a(bitmapCreateBitmap);
        c1385av.mo4973a((r7 - iM4981j) * 0.5f, (r8 - iM4982k) * 0.5f, "Aa", MotionEventCompat.ACTION_MASK);
        c1385av.mo5304c();
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private Bitmap m5035a(Intent intent, Bundle bundle) {
        Bitmap bitmapDecodeFile;
        if (bundle.getBoolean("exceed_size", true)) {
            C1341p.m4658b("[getBitmapFromExtras] exceed_size is true!", getClass().getSimpleName());
            String string = bundle.getString("temp_file_path");
            if (string == null) {
                return null;
            }
            C1341p.m4658b("tmpFilePath : " + string, getClass().getSimpleName());
            bitmapDecodeFile = BitmapFactory.decodeFile(string);
            if (bitmapDecodeFile == null) {
                return null;
            }
            File file = new File(string);
            if (file.exists()) {
                file.delete();
            }
        } else {
            C1341p.m4658b("[getBitmapFromExtras] exceed_size is false!", getClass().getSimpleName());
            bitmapDecodeFile = (Bitmap) bundle.getParcelable("data");
        }
        C1341p.m4658b("[getBitmapFromExtras] bmp width and height : " + bitmapDecodeFile.getWidth() + "," + bitmapDecodeFile.getHeight(), getClass().getSimpleName());
        return bitmapDecodeFile;
    }

    /* renamed from: a */
    private String m5037a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m5043a(EditText editText, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(editText, 2);
        } else {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5071e(boolean z) {
        if (this.f4947L != null && this.f4948M != null) {
            this.f4945J = z;
            this.f4947L.setVisibility(z ? 0 : 8);
            invalidateOptionsMenu();
            m5043a(this.f4948M.m4962b(), z);
        }
    }

    /* renamed from: b */
    private void m5056b(String str) {
        if (this.f4947L != null) {
            this.f4947L = null;
        }
        this.f4947L = (RelativeLayout) findViewById(R.id.layout_text_input);
        this.f4947L.setOnClickListener(new ViewOnClickListenerC1446e(this));
        if (this.f4948M != null) {
            this.f4948M = null;
        }
        this.f4948M = new ViewOnClickListenerC1382as(this, 128);
        if (str != null) {
            this.f4948M.m4961a(str);
        }
        this.f4948M.m4959a(this.f4962aa);
        this.f4946K = new C1431b(this);
        this.f4948M.m4960a(this.f4946K);
    }

    @Override // com.sec.vip.amschaton.InterfaceC1552q
    /* renamed from: a */
    public boolean mo5122a(String str) {
        m5056b(str);
        m5071e(true);
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1375al
    /* renamed from: a */
    public boolean mo4925a(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
                this.f4953R = true;
                m5096l();
                m5098m();
                break;
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        m5042a(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ams_ics_option_menu_composer, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Resources.NotFoundException {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (this.f4945J) {
                    m5071e(false);
                    return true;
                }
                if (!this.f4953R || !this.f4936A.m4806t()) {
                    f4934a = false;
                }
                m5038a();
                return true;
            case R.id.menu_item_create_new /* 2131428248 */:
                m5031D();
                return true;
            case R.id.menu_item_my_works /* 2131428250 */:
                m5068e(1000);
                return true;
            case R.id.menu_item_samples /* 2131428252 */:
                m5068e(1001);
                return true;
            case R.id.menu_btn_done_text /* 2131428255 */:
                if (this.f4946K == null) {
                    return true;
                }
                this.f4946K.mo4927b();
                m5086i(false);
                return true;
            case R.id.menu_btn_cancel_text /* 2131428256 */:
                if (this.f4946K == null) {
                    return true;
                }
                this.f4946K.mo4926a();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: D */
    private void m5031D() throws Resources.NotFoundException {
        if (!this.f4953R || !this.f4936A.m4803q()) {
            m5119y();
            return;
        }
        TextView textView = new TextView(this);
        textView.setText(R.string.ams_msg_exit_with_save);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setPadding(0, 30, 8, 30);
        textView.setGravity(17);
        new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_title_create_new).setView(textView).setPositiveButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC1404a(this)).setNegativeButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC1444c(this)).create().show();
    }

    /* renamed from: E */
    private void m5032E() {
        this.f4937B = 2002;
        this.f4939D = 0;
        this.f4941F = -16777216;
        this.f4940E = 5;
        this.f4943H = 2;
        this.f4942G = -16777216;
    }

    /* renamed from: F */
    private void m5033F() {
    }

    /* renamed from: f */
    private void m5075f(boolean z) throws Resources.NotFoundException {
        if (z) {
            this.f4965o.setScaleType(ImageView.ScaleType.CENTER);
            this.f4965o.setImageResource(R.drawable.button_pen);
            return;
        }
        Drawable drawableM5036a = m5036a(1, this.f4939D, this.f4941F, this.f4940E);
        if (drawableM5036a == null) {
            this.f4965o.setScaleType(ImageView.ScaleType.CENTER);
            this.f4965o.setImageResource(R.drawable.button_pen);
        } else {
            this.f4965o.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f4965o.setImageDrawable(drawableM5036a);
        }
        m5034G();
    }

    /* renamed from: g */
    private void m5079g(boolean z) {
        if (this.f4974x != null) {
            this.f4974x.recycle();
            this.f4974x = null;
        }
        if (z) {
            this.f4966p.setScaleType(ImageView.ScaleType.CENTER);
            this.f4966p.setImageResource(R.drawable.button_text);
            return;
        }
        this.f4974x = m5030C();
        if (this.f4974x == null) {
            this.f4966p.setScaleType(ImageView.ScaleType.CENTER);
            this.f4966p.setImageResource(R.drawable.button_text);
        } else {
            this.f4966p.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f4966p.setImageBitmap(this.f4974x);
        }
        m5034G();
    }

    /* renamed from: h */
    private void m5083h(boolean z) throws Resources.NotFoundException {
        int dimensionPixelOffset = m5029B().getResources().getDimensionPixelOffset(R.dimen.ams_stamp_button_padding);
        this.f4967q.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        if (this.f4975y != null) {
            this.f4975y.recycle();
            this.f4975y = null;
        }
        if (z) {
            this.f4967q.setPadding(0, 0, 0, 0);
            this.f4967q.setScaleType(ImageView.ScaleType.CENTER);
            this.f4967q.setImageResource(R.drawable.button_stamp);
            return;
        }
        if (this.f4949N < C1561z.m5654a().m5670f()) {
            this.f4975y = C1561z.m5654a().m5657a(this.f4949N, false);
        } else {
            this.f4975y = C1561z.m5654a().m5664b(this.f4949N - 1000, false);
        }
        if (this.f4975y == null) {
            this.f4967q.setPadding(0, 0, 0, 0);
            this.f4967q.setScaleType(ImageView.ScaleType.CENTER);
            this.f4967q.setImageResource(R.drawable.button_stamp);
        } else {
            this.f4967q.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f4967q.setImageBitmap(this.f4975y);
        }
        m5034G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5076g(int i) throws Resources.NotFoundException {
        switch (i) {
            case 2002:
                m5075f(false);
                break;
            case 2003:
                m5079g(false);
                break;
            case 2005:
                m5083h(false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m5034G() {
        this.f4936A.m4808v();
    }

    /* renamed from: a */
    private void m5042a(Menu menu) {
        menu.setGroupVisible(R.id.menu_group_buttons, true);
        menu.setGroupEnabled(R.id.menu_group_buttons, true);
        menu.setGroupVisible(R.id.menu_group_buttons_text, false);
        if (this.f4945J) {
            menu.setGroupVisible(R.id.menu_group_buttons, false);
            menu.setGroupVisible(R.id.menu_group_buttons_text, true);
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_btn_done_text);
            if (menuItemFindItem != null) {
                menuItemFindItem.setEnabled(this.f4944I);
            }
        }
    }

    /* renamed from: b */
    private void m5053b(int i, int i2) {
        if (this.f4936A != null && this.f4936A.m4769A()) {
            this.f4936A.m4770a(i, i2);
        }
    }

    /* renamed from: i */
    private void m5086i(boolean z) throws Resources.NotFoundException {
        if (this.f4936A != null) {
            if (this.f4936A.m4769A()) {
                this.f4936A.m4811y();
            }
            if (z) {
                this.f4936A.m4810x();
            }
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC1553r
    /* renamed from: a */
    public void mo5121a(boolean z) {
    }
}
