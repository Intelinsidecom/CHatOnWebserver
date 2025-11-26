package com.sec.vip.amschaton.ics;

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
import com.sec.widget.C1632t;
import com.sec.widget.GeneralHeaderView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSComposerActivity extends AMSActivity implements View.OnClickListener, InterfaceC1375al, InterfaceC1552q, InterfaceC1553r {

    /* renamed from: a */
    public static boolean f5178a = true;

    /* renamed from: b */
    public static boolean f5179b = false;

    /* renamed from: A */
    private AMSDrawManager f5180A;

    /* renamed from: P */
    private String f5195P;

    /* renamed from: W */
    private int f5202W;

    /* renamed from: X */
    private int f5203X;

    /* renamed from: n */
    private ImageView f5211n;

    /* renamed from: o */
    private ImageView f5212o;

    /* renamed from: p */
    private ImageView f5213p;

    /* renamed from: q */
    private ImageView f5214q;

    /* renamed from: r */
    private ImageView f5215r;

    /* renamed from: s */
    private ImageView f5216s;

    /* renamed from: t */
    private ImageView f5217t;

    /* renamed from: u */
    private ImageView f5218u;

    /* renamed from: z */
    private PopupWindow f5223z;

    /* renamed from: c */
    private float f5210c = 1.0f;

    /* renamed from: v */
    private Bitmap f5219v = null;

    /* renamed from: w */
    private Bitmap f5220w = null;

    /* renamed from: x */
    private Bitmap f5221x = null;

    /* renamed from: y */
    private Bitmap f5222y = null;

    /* renamed from: B */
    private int f5181B = 2000;

    /* renamed from: C */
    private int f5182C = 2002;

    /* renamed from: D */
    private int f5183D = 0;

    /* renamed from: E */
    private int f5184E = 0;

    /* renamed from: F */
    private int[] f5185F = null;

    /* renamed from: G */
    private int[] f5186G = null;

    /* renamed from: H */
    private int f5187H = -16777216;

    /* renamed from: I */
    private int f5188I = 2;

    /* renamed from: J */
    private boolean f5189J = false;

    /* renamed from: K */
    private boolean f5190K = false;

    /* renamed from: L */
    private InterfaceC1397bg f5191L = null;

    /* renamed from: M */
    private RelativeLayout f5192M = null;

    /* renamed from: N */
    private ViewOnClickListenerC1382as f5193N = null;

    /* renamed from: O */
    private int f5194O = 0;

    /* renamed from: Q */
    private boolean f5196Q = true;

    /* renamed from: R */
    private boolean f5197R = false;

    /* renamed from: S */
    private boolean f5198S = false;

    /* renamed from: T */
    private int f5199T = -2;

    /* renamed from: U */
    private boolean f5200U = true;

    /* renamed from: V */
    private RelativeLayout f5201V = null;

    /* renamed from: Y */
    private boolean f5204Y = false;

    /* renamed from: Z */
    private GeneralHeaderView f5205Z = null;

    /* renamed from: aa */
    private C1632t f5206aa = null;

    /* renamed from: ab */
    private boolean f5207ab = true;

    /* renamed from: ac */
    private Handler f5208ac = new HandlerC1472ac(this);

    /* renamed from: ad */
    private InterfaceC1368ae f5209ad = new C1530l(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        boolean z;
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        f5179b = false;
        m4741d();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f5195P = extras.getString("AMS_FILE_PATH");
            this.f5197R = extras.getBoolean("AMS_SAVE_FLAG", false);
            this.f5198S = extras.getBoolean("AMS_EDIT_FLAG", false);
            z = extras.getBoolean("AMS_PEN_STATE_DEFAULT", true);
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f5195P = null;
            z = true;
        }
        this.f5196Q = this.f5195P == null;
        this.f5185F = new int[5];
        this.f5186G = new int[5];
        m5391h(z);
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f5200U = true;
            this.f5210c = getWindowManager().getDefaultDisplay().getWidth() / 480.0f;
        } else if (configuration.orientation == 2) {
            this.f5200U = false;
            this.f5210c = getWindowManager().getDefaultDisplay().getHeight() / 480.0f;
        }
        setContentView(R.layout.ams_ics_layout_composer);
        m5411n();
        m5417p();
        m5419q();
        if (AMSStampSelectionActivity.f5263a) {
            if (C1561z.m5654a().m5665c() > 0) {
                this.f5194O = (C1561z.m5654a().m5665c() + 1000) - 1;
            } else {
                this.f5194O = 0;
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        if (f5178a && this.f5197R && this.f5180A.m4806t()) {
            m5393i();
        }
        if (this.f5219v != null) {
            this.f5219v.recycle();
            this.f5219v = null;
        }
        if (this.f5220w != null) {
            this.f5220w.recycle();
            this.f5220w = null;
        }
        if (this.f5221x != null) {
            this.f5221x.recycle();
            this.f5221x = null;
        }
        if (this.f5222y != null) {
            this.f5222y.recycle();
            this.f5222y = null;
        }
        if (this.f5180A != null) {
            this.f5180A.m4807u();
            this.f5180A = null;
        }
        this.f5204Y = false;
        f5179b = true;
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1341p.m4660c("[onResume]", getClass().getName());
        f5178a = true;
        m4739b();
        if (this.f5190K && this.f5193N != null) {
            m5349a(this.f5193N.m4962b(), true);
        }
        super.onResume();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        C1341p.m4660c("[onPause]", getClass().getName());
        if (this.f5190K && this.f5193N != null) {
            m5349a(this.f5193N.m4962b(), false);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1341p.m4660c("[onRestoreInstanceState]", getClass().getName());
        if (bundle != null && bundle.getBoolean("SI_SAVE_TEMP_AMS", false)) {
            this.f5197R = bundle.getBoolean("SI_SAVE_FLAG", this.f5197R);
            this.f5198S = bundle.getBoolean("SI_EDIT_FLAG", this.f5198S);
            this.f5195P = f4627i;
            m5358b(3000);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1341p.m4660c("[onSaveInstanceState]", getClass().getName());
        boolean z = true;
        if (this.f5180A.m4806t()) {
            if (!m5378e(false)) {
                C1341p.m4660c("[onSaveInstanceState] Cannot save temp AMS file!", getClass().getName());
                z = false;
            }
            bundle.putBoolean("SI_SAVE_FLAG", this.f5197R);
            bundle.putBoolean("SI_EDIT_FLAG", this.f5198S);
        } else {
            z = false;
        }
        bundle.putBoolean("SI_SAVE_TEMP_AMS", z);
        f5178a = false;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f5200U = true;
        } else if (configuration.orientation == 2) {
            this.f5200U = false;
        }
        setContentView(R.layout.ams_ics_layout_composer);
        m5414o();
        m5417p();
        if (this.f5180A != null) {
            this.f5180A.m4809w();
        }
        m5421r();
        if (this.f5190K && this.f5193N != null) {
            m5362b(this.f5193N.m4962b().getText().toString());
            m5383f(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f5190K) {
            m5383f(false);
            if (this.f5193N != null) {
                this.f5193N.m4963c();
                return;
            }
            return;
        }
        if (!this.f5197R || !this.f5180A.m4806t()) {
            f5178a = false;
        }
        m5345a();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        Bundle extras;
        switch (i) {
            case 3:
                if (i2 == -1 && (extras = intent.getExtras()) != null) {
                    int i3 = extras.getInt("AMS_FRAME", 1002);
                    if (i3 == 1000) {
                        m5431w();
                        break;
                    } else if (i3 == 1003) {
                        int i4 = extras.getInt("BACKGROUND_COLOR", -16777216);
                        this.f5180A.m4776a(Color.red(i4), Color.green(i4), Color.blue(i4), true);
                        this.f5180A.m4793g();
                        m5337F();
                        break;
                    } else {
                        Bitmap bitmapM5342a = m5342a(intent, extras);
                        if (bitmapM5342a != null) {
                            m5348a(bitmapM5342a);
                            bitmapM5342a.recycle();
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
                    if (this.f5180A.m4791e() == null) {
                        if (this.f5194O > C1561z.m5654a().m5670f()) {
                            Bitmap bitmapM5664b = C1561z.m5654a().m5664b(this.f5194O - 1000, false);
                            if (bitmapM5664b == null) {
                                this.f5194O = 0;
                            } else {
                                bitmapM5664b.recycle();
                            }
                        }
                        this.f5180A.m4775a(3, this.f5194O, 0, 0);
                        m5384g(this.f5181B);
                        break;
                    }
                } else {
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        this.f5194O = extras2.getInt("AMS_STAMP_INDEX", 0);
                        if (this.f5194O < 0 || this.f5194O > C1561z.m5654a().m5670f()) {
                            Bitmap bitmapM5664b2 = C1561z.m5654a().m5664b(this.f5194O - 1000, false);
                            if (bitmapM5664b2 == null) {
                                this.f5194O = 0;
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
                            if (i7 != this.f5194O) {
                                i6++;
                                i5 = i7;
                            } else {
                                iArr[0] = this.f5194O;
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                                this.f5180A.m4775a(3, this.f5194O, 0, 0);
                                m5384g(this.f5181B);
                                m5336E();
                                break;
                            }
                        }
                        iArr[0] = this.f5194O;
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                        this.f5180A.m4775a(3, this.f5194O, 0, 0);
                        m5384g(this.f5181B);
                        m5336E();
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        m5383f(false);
        switch (view.getId()) {
            case R.id.btn_tool_background_image /* 2131427399 */:
                m5426u();
                break;
            case R.id.btn_tool_pen /* 2131427400 */:
                if (this.f5223z == null || !this.f5223z.isShowing()) {
                    m5398j();
                    break;
                }
                break;
            case R.id.btn_tool_stamp_shape /* 2131427401 */:
                m5428v();
                break;
            case R.id.btn_tool_text /* 2131427402 */:
                if (this.f5223z == null || !this.f5223z.isShowing()) {
                    m5402k();
                    break;
                }
                break;
            case R.id.btn_preview /* 2131427404 */:
                if (!this.f5204Y) {
                    this.f5204Y = true;
                    m5433x();
                    break;
                }
                break;
            case R.id.btn_undo /* 2131427405 */:
                this.f5180A.m4797k();
                break;
            case R.id.btn_redo /* 2131427406 */:
                this.f5180A.m4798l();
                break;
            case R.id.btn_send /* 2131427407 */:
                m5436z();
                break;
        }
    }

    /* renamed from: b */
    private void m5363b(boolean z) {
        if (z) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().addFlags(1024);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5345a() {
        f5178a = false;
        if (!this.f5197R || !this.f5180A.m4803q()) {
            m5390h();
        } else {
            new AlertDialogBuilderC1625m(this).setMessage(R.string.ams_msg_exit_with_save).setPositiveButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC1477ah(this)).setNegativeButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC1476ag(this)).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5390h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5393i() {
        if (!this.f5180A.m4780a(f4624f + m5344a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m4738a(R.string.ams_error_ams_file_save);
        } else {
            m4738a(R.string.ams_msg_saved);
        }
    }

    /* renamed from: b */
    private void m5358b(int i) {
        new Thread(new RunnableC1471ab(this, i)).start();
    }

    /* renamed from: j */
    private void m5398j() throws Resources.NotFoundException {
        m5407l(false);
        this.f5180A.setEditMode(false, false);
        this.f5181B = 2002;
        m5365c(this.f5181B);
        if (this.f5182C != this.f5181B) {
            this.f5180A.m4775a(1, this.f5183D, this.f5185F[this.f5183D], this.f5186G[this.f5183D]);
            this.f5182C = this.f5181B;
            m5384g(this.f5181B);
            m5337F();
            return;
        }
        this.f5182C = this.f5181B;
        m5422s();
    }

    /* renamed from: k */
    private void m5402k() throws Resources.NotFoundException {
        this.f5181B = 2003;
        m5365c(this.f5181B);
        if (this.f5182C != 2003) {
            this.f5180A.setEditMode(false, false);
            this.f5180A.m4775a(2, 0, this.f5187H, this.f5188I);
            this.f5182C = this.f5181B;
            m5384g(this.f5181B);
            m5337F();
            m5407l(true);
            return;
        }
        this.f5182C = this.f5181B;
        m5425t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5405l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5409m() {
        if (!this.f5215r.isEnabled() && this.f5180A.m4803q()) {
            this.f5215r.setEnabled(true);
        } else if (this.f5215r.isEnabled() && !this.f5180A.m4803q()) {
            this.f5215r.setEnabled(false);
        }
        if (!this.f5216s.isEnabled() && this.f5180A.m4804r()) {
            this.f5216s.setEnabled(true);
        } else if (this.f5216s.isEnabled() && !this.f5180A.m4804r()) {
            this.f5216s.setEnabled(false);
        }
        if (!this.f5217t.isEnabled() && this.f5180A.m4806t()) {
            this.f5217t.setEnabled(true);
            this.f5218u.setEnabled(true);
        } else if (this.f5217t.isEnabled() && !this.f5180A.m4806t()) {
            this.f5217t.setEnabled(false);
            this.f5218u.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5365c(int i) throws Resources.NotFoundException {
        m5371d(i);
        m5384g(i);
    }

    /* renamed from: d */
    private void m5371d(int i) {
        int[] iArr = {2002, 2003, 2005, 2001};
        ImageView[] imageViewArr = {this.f5212o, this.f5213p, this.f5214q, this.f5211n};
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
    private void m5411n() throws Resources.NotFoundException {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ams_ics_titlebar_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_canvas_margin);
        if (width >= height) {
            width = (height - dimensionPixelSize) - (dimensionPixelSize2 * 2);
        }
        this.f5202W = width;
        C1341p.m4660c("[createComposer] Composer Size = " + this.f5202W, getClass().getSimpleName());
        this.f5203X = this.f5202W;
        if (this.f5180A != null) {
            this.f5180A.m4807u();
            this.f5180A = null;
        }
        this.f5180A = new AMSDrawManager(this, this.f5202W, this.f5203X);
        if (!this.f5180A.m4772a()) {
            m5390h();
        }
        this.f5180A.setEnableZoom(true);
        this.f5180A.setPlayMode(false);
        this.f5180A.setOnTextInputRequestListener(this);
        this.f5180A.setOnObjectListener(this);
        this.f5180A.setOnTouchTextArea(this);
        this.f5180A.setEraserSize(this.f5186G[4]);
        if (!this.f5196Q) {
            m5431w();
        }
        m5414o();
    }

    /* renamed from: o */
    private void m5414o() {
        if (this.f5201V != null) {
            this.f5201V.removeAllViews();
            this.f5201V = null;
        }
        this.f5201V = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f5201V.setLayoutParams(layoutParams);
        this.f5201V.addView(this.f5180A);
    }

    /* renamed from: p */
    private void m5417p() throws Resources.NotFoundException {
        m5339H();
        m5363b(this.f5200U);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        relativeLayout.addView(this.f5201V);
        this.f5211n = (ImageView) findViewById(R.id.btn_tool_background_image);
        this.f5212o = (ImageView) findViewById(R.id.btn_tool_pen);
        this.f5213p = (ImageView) findViewById(R.id.btn_tool_text);
        this.f5214q = (ImageView) findViewById(R.id.btn_tool_stamp_shape);
        this.f5215r = (ImageView) findViewById(R.id.btn_undo);
        this.f5216s = (ImageView) findViewById(R.id.btn_redo);
        this.f5217t = (ImageView) findViewById(R.id.btn_preview);
        this.f5218u = (ImageView) findViewById(R.id.btn_send);
        this.f5211n.setOnClickListener(this);
        this.f5212o.setOnClickListener(this);
        this.f5213p.setOnClickListener(this);
        this.f5214q.setOnClickListener(this);
        this.f5215r.setOnClickListener(this);
        this.f5216s.setOnClickListener(this);
        this.f5217t.setOnClickListener(this);
        this.f5218u.setOnClickListener(this);
        if (!this.f5196Q) {
            m5358b(3000);
        }
        this.f5215r.setEnabled(this.f5180A.m4803q());
        this.f5216s.setEnabled(this.f5180A.m4804r());
        this.f5217t.setEnabled(this.f5180A.m4806t());
        this.f5218u.setEnabled(this.f5180A.m4806t());
        m5405l();
        m5365c(this.f5181B);
        m5358b(3001);
    }

    /* renamed from: q */
    private void m5419q() throws Resources.NotFoundException {
        this.f5181B = 2002;
        this.f5182C = this.f5181B;
        this.f5180A.m4775a(1, this.f5183D, this.f5185F[this.f5183D], this.f5186G[this.f5183D]);
        m5365c(this.f5181B);
        m5358b(3001);
    }

    /* renamed from: r */
    private void m5421r() throws Resources.NotFoundException {
        if (this.f5223z != null && this.f5223z.isShowing()) {
            m5368c(false);
            switch (this.f5181B) {
                case 2002:
                    m5422s();
                    break;
                case 2003:
                    m5425t();
                    break;
            }
        }
    }

    /* renamed from: c */
    private boolean m5368c(boolean z) throws Resources.NotFoundException {
        this.f5181B = this.f5182C;
        if (this.f5223z == null) {
            m5365c(this.f5181B);
            return false;
        }
        if (!this.f5223z.isShowing()) {
            m5365c(this.f5181B);
            return false;
        }
        if (z) {
            new View(this).post(new RunnableC1470aa(this));
        } else {
            this.f5223z.dismiss();
            m5365c(this.f5181B);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5347a(int i, int i2, int i3) throws Resources.NotFoundException {
        this.f5183D = i;
        this.f5186G[this.f5183D] = i2;
        this.f5185F[this.f5183D] = i3;
        this.f5180A.m4775a(1, this.f5183D, this.f5185F[this.f5183D], this.f5186G[this.f5183D]);
        m5337F();
        m5384g(this.f5181B);
        m5336E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5346a(int i, int i2) throws Resources.NotFoundException {
        this.f5188I = i;
        this.f5187H = i2;
        if (this.f5180A.m4791e() == null) {
            this.f5180A.m4775a(2, 0, this.f5187H, this.f5188I);
        } else {
            this.f5180A.m4774a(0, this.f5187H, this.f5188I);
        }
        m5337F();
        m5384g(this.f5181B);
        m5359b(this.f5187H, this.f5188I);
        m5336E();
    }

    /* renamed from: s */
    private void m5422s() {
        C1369af c1369af = new C1369af(this, R.layout.ams_ics2_layout_tool_pen_popup, this.f5212o, this.f5200U);
        c1369af.m4919a(this.f5183D);
        c1369af.m4920b(this.f5186G[this.f5183D]);
        c1369af.m4921c(this.f5185F[this.f5183D]);
        c1369af.m5649a(new C1544z(this, c1369af));
        this.f5223z = c1369af;
    }

    /* renamed from: t */
    private void m5425t() {
        C1395be c1395be = new C1395be(this, R.layout.ams_ics2_layout_tool_text_popup, this.f5213p, this.f5200U);
        c1395be.m4999a(this.f5188I);
        c1395be.m5000b(this.f5187H);
        c1395be.m5649a(new C1475af(this, c1395be));
        this.f5223z = c1395be;
    }

    /* renamed from: u */
    private void m5426u() throws Resources.NotFoundException {
        m5407l(false);
        Intent intent = new Intent(this, (Class<?>) AMSBgFrameSelectionActivity.class);
        intent.putExtra("BACKGROUND_COLOR", this.f5180A.m4782b());
        intent.putExtra("BACKGROUND_INDEX", this.f5199T);
        startActivityForResult(intent, 3);
    }

    /* renamed from: v */
    private void m5428v() throws Resources.NotFoundException {
        m5407l(false);
        this.f5180A.setEditMode(false, false);
        this.f5181B = 2005;
        m5365c(this.f5181B);
        this.f5180A.m4775a(3, this.f5194O, 0, 0);
        this.f5182C = this.f5181B;
        m5384g(this.f5181B);
        m5337F();
        Intent intent = new Intent(this, (Class<?>) AMSStampSelectionActivity.class);
        intent.putExtra("AMS_STAMP_INDEX", this.f5194O);
        startActivityForResult(intent, 11);
    }

    /* renamed from: e */
    private void m5374e(int i) {
        f5178a = false;
        if (!this.f5197R || !this.f5180A.m4803q()) {
            m5379f(i);
        } else {
            new AlertDialogBuilderC1625m(this).setMessage(R.string.ams_msg_exit_with_save).setPositiveButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC1473ad(this, i)).setNegativeButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC1474ae(this, i)).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5379f(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2001);
        intent.putExtra("AMS_TAB_ID", i);
        intent.putExtra("AMS_SAVE_FLAG", this.f5197R);
        startActivity(intent);
        finish();
    }

    /* renamed from: w */
    private void m5431w() {
        if (this.f5180A != null) {
            this.f5180A.m4776a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, true);
            this.f5180A.m4793g();
            m5337F();
        }
    }

    /* renamed from: a */
    private void m5348a(Bitmap bitmap) {
        this.f5180A.m4777a(bitmap, true);
        this.f5180A.setEditMode(false, true);
        m5337F();
    }

    /* renamed from: x */
    private void m5433x() {
        if (!m5378e(false)) {
            this.f5204Y = false;
            return;
        }
        f5178a = false;
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2004);
        intent.putExtra("AMS_FILE_PATH", f4627i);
        intent.putExtra("AMS_SAVE_FLAG", this.f5197R);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m5435y() throws Resources.NotFoundException {
        if (this.f5180A != null) {
            this.f5197R = false;
            m5411n();
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            relativeLayout.addView(this.f5201V);
            m5419q();
            m5409m();
        }
    }

    /* renamed from: z */
    private void m5436z() {
        if (this.f5180A != null) {
            if (!this.f5180A.m4806t()) {
                m4738a(R.string.ams_msg_empty_ams);
            } else {
                new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_title_send).setItems(R.array.ams_strarr_sending_mode, new DialogInterfaceOnClickListenerC1532n(this)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1531m(this)).create().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String m5370d(boolean z) {
        String str = f4624f + m5344a("A", System.currentTimeMillis(), ".jpg");
        if (!this.f5180A.m4780a(str)) {
            m4738a(R.string.ams_error_ams_file_save);
            return null;
        }
        File file = new File(str);
        if (file.length() < 1048576 || !z) {
            return str;
        }
        file.delete();
        new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_btn_send).setMessage(String.format("%s\n(%d/%d)", getResources().getString(R.string.ams_msg_exceed_limit), Long.valueOf(file.length()), 1048576)).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1529k(this)).create().show();
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
    public java.lang.String m5332A() throws java.lang.Throwable {
        /*
            r7 = this;
            r1 = 0
            r6 = 480(0x1e0, float:6.73E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.sec.vip.amschaton.ics.AMSComposerActivity.f4629k
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "I"
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = ".jpg"
            java.lang.String r2 = r7.m5344a(r2, r3, r5)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f5180A
            boolean r2 = r2.m4793g()
            if (r2 == 0) goto L61
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f5180A
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSComposerActivity.m5332A():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5355a(String str, boolean z) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", z);
        startActivity(intent);
        finish();
    }

    /* renamed from: e */
    private boolean m5378e(boolean z) {
        if (this.f5180A == null) {
            C1341p.m4651a("[startAMSPreview] mAMSComposer is NULL!", getClass().getSimpleName());
            return false;
        }
        if (!z && !this.f5180A.m4806t()) {
            C1341p.m4651a("[startAMSPreview] Empty AMS file!", getClass().getSimpleName());
            return false;
        }
        File file = new File(f4627i);
        if (file.exists()) {
            file.delete();
        }
        if (!this.f5180A.m4780a(f4627i)) {
            C1341p.m4651a("[startAMSPreview] Fail to save AMS file!", getClass().getSimpleName());
            return false;
        }
        this.f5180A.setEditMode(false, false);
        return true;
    }

    /* renamed from: B */
    private Context m5333B() {
        return this;
    }

    /* renamed from: a */
    private Drawable m5343a(int i, int i2, int i3, int i4) throws Resources.NotFoundException {
        Drawable drawable;
        Drawable drawable2;
        if (i != 1) {
            return null;
        }
        int i5 = (int) (30.0f * this.f5210c);
        if (this.f5219v != null) {
            this.f5219v.recycle();
            this.f5219v = null;
        }
        if (this.f5220w != null) {
            this.f5220w.recycle();
            this.f5220w = null;
        }
        int i6 = (int) (150.0f * this.f5210c);
        int i7 = (int) (this.f5210c * 102.0f);
        Rect rect = new Rect(0, 0, i7, i7);
        float f = i5 + (i6 * 0.5f);
        float f2 = i7 * 0.5f;
        if (!this.f5200U) {
            i6 = (int) (this.f5210c * 102.0f);
            i7 = (int) (150.0f * this.f5210c);
            rect.set(0, 0, i6, i6);
            f = i6 * 0.5f;
            f2 = (i7 * 0.5f) + i5;
        }
        this.f5219v = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        this.f5220w = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f5219v);
        Canvas canvas2 = new Canvas(this.f5220w);
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
        float f3 = this.f5186G[this.f5183D] * 2.5f * this.f5210c;
        canvas.drawCircle(f, f2, f3, paint);
        canvas2.drawCircle(f, f2, f3, paint);
        paint.setColor(this.f5185F[this.f5183D]);
        float f4 = f3 - 2.0f;
        canvas.drawCircle(f, f2, f4, paint);
        canvas2.drawCircle(f, f2, f4, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f5219v);
        bitmapDrawable.setTargetDensity(this.f5219v.getDensity());
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.f5220w);
        bitmapDrawable2.setTargetDensity(this.f5220w.getDensity());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, bitmapDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, bitmapDrawable2);
        return stateListDrawable;
    }

    /* renamed from: C */
    private Bitmap m5334C() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (this.f5210c * 80.0f), (int) (this.f5210c * 80.0f), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawARGB(0, 0, 0, 0);
        C1385av c1385av = new C1385av(2, this.f5187H, this.f5188I, false, this.f5202W, this.f5203X);
        c1385av.mo4887a(this.f5210c * 2.0f);
        c1385av.m4980b("Aa");
        int iM4981j = c1385av.m4981j();
        int iM4982k = c1385av.m4982k();
        c1385av.m5287a(bitmapCreateBitmap);
        c1385av.mo4973a((r7 - iM4981j) * 0.5f, (r8 - iM4982k) * 0.5f, "Aa", MotionEventCompat.ACTION_MASK);
        c1385av.mo5304c();
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private Bitmap m5342a(Intent intent, Bundle bundle) {
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
    private String m5344a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m5349a(EditText editText, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(editText, 2);
        } else {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5383f(boolean z) {
        if (this.f5192M != null && this.f5193N != null) {
            m5349a(this.f5193N.m4962b(), z);
            this.f5190K = z;
            if (z) {
                this.f5192M.setVisibility(0);
                m5341J();
                m5387g(this.f5189J);
            } else {
                this.f5192M.setVisibility(8);
                m5339H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5387g(boolean z) {
        if (this.f5205Z != null && this.f5190K) {
            this.f5205Z.setButtonEnabled(z);
        }
    }

    /* renamed from: b */
    private void m5362b(String str) {
        if (this.f5192M != null) {
            this.f5192M = null;
        }
        this.f5192M = (RelativeLayout) findViewById(R.id.layout_text_input);
        this.f5192M.setOnClickListener(new ViewOnClickListenerC1527i(this));
        if (this.f5193N != null) {
            this.f5193N = null;
        }
        this.f5193N = new ViewOnClickListenerC1382as(this, 128);
        if (str != null) {
            this.f5193N.m4961a(str);
        }
        this.f5193N.m4959a(this.f5209ad);
        this.f5191L = new C1528j(this);
        this.f5193N.m4960a(this.f5191L);
    }

    @Override // com.sec.vip.amschaton.InterfaceC1552q
    /* renamed from: a */
    public boolean mo5122a(String str) {
        m5362b(str);
        m5383f(true);
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1375al
    /* renamed from: a */
    public boolean mo4925a(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
                this.f5197R = true;
                m5405l();
                m5409m();
                break;
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ams_ics_option_menu_composer, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Resources.NotFoundException {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_create_new /* 2131428248 */:
                m5335D();
                break;
            case R.id.menu_item_my_works /* 2131428250 */:
                m5374e(1000);
                break;
            case R.id.menu_item_samples /* 2131428252 */:
                m5374e(1001);
                break;
        }
        return true;
    }

    /* renamed from: D */
    private void m5335D() throws Resources.NotFoundException {
        if (!this.f5197R || !this.f5180A.m4803q()) {
            m5435y();
        } else {
            new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_title_create_new).setMessage(R.string.ams_msg_exit_with_save).setPositiveButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC1526h(this)).setNegativeButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC1525g(this)).create().show();
        }
    }

    /* renamed from: h */
    private void m5391h(boolean z) {
        if (z) {
            this.f5181B = 2002;
            this.f5183D = 0;
            this.f5184E = this.f5183D;
            this.f5185F[0] = -16777216;
            this.f5185F[1] = -16777216;
            this.f5185F[3] = -16777216;
            this.f5185F[2] = -16777216;
            this.f5186G[0] = 5;
            this.f5186G[1] = 5;
            this.f5186G[3] = 5;
            this.f5186G[2] = 5;
            this.f5186G[4] = 5;
            this.f5188I = 2;
            this.f5187H = -16777216;
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 1);
        this.f5181B = sharedPreferences.getInt("AMS_TOOL_TYPE", 2000);
        this.f5183D = sharedPreferences.getInt("AMS_PEN_STYLE", 0);
        this.f5184E = this.f5183D;
        this.f5185F[0] = sharedPreferences.getInt("AMS_PEN_LINE_COLOR", -16777216);
        this.f5185F[1] = sharedPreferences.getInt("AMS_PEN_BLUR_COLOR", -16777216);
        this.f5185F[2] = sharedPreferences.getInt("AMS_CPEN_MARKER_COLOR", -16777216);
        this.f5185F[3] = sharedPreferences.getInt("AMS_PEN_DOT_COLOR", -16777216);
        this.f5186G[0] = sharedPreferences.getInt("AMS_PEN_LINE", 3);
        this.f5186G[1] = sharedPreferences.getInt("AMS_PEN_BLUR_SIZE", 3);
        this.f5186G[2] = sharedPreferences.getInt("AMS_PEN_MARKER_SIZE", 3);
        this.f5186G[3] = sharedPreferences.getInt("AMS_PEN_DOT_SIZE", 3);
        this.f5186G[4] = sharedPreferences.getInt("AMS_PEN_ERASER_SIZE", 5);
        this.f5188I = sharedPreferences.getInt("AMS_TEXT_SIZE", 2);
        this.f5187H = sharedPreferences.getInt("AMS_TEXT_COLOR", -16777216);
    }

    /* renamed from: E */
    private void m5336E() {
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 3);
        sharedPreferences.edit().putInt("AMS_TOOL_TYPE", this.f5181B).commit();
        sharedPreferences.edit().putInt("AMS_PEN_STYLE", this.f5183D).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE_COLOR", this.f5185F[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_COLOR", this.f5185F[1]).commit();
        sharedPreferences.edit().putInt("AMS_CPEN_MARKER_COLOR", this.f5185F[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_COLOR", this.f5185F[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE", this.f5186G[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_SIZE", this.f5186G[1]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_MARKER_SIZE", this.f5186G[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_SIZE", this.f5186G[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_ERASER_SIZE", this.f5186G[4]).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_SIZE", this.f5188I).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_COLOR", this.f5187H).commit();
    }

    /* renamed from: i */
    private void m5394i(boolean z) throws Resources.NotFoundException {
        int i;
        if (z) {
            this.f5212o.setScaleType(ImageView.ScaleType.CENTER);
            this.f5212o.setImageResource(R.drawable.button_pen);
            return;
        }
        if (this.f5207ab) {
            Drawable drawableM5343a = m5343a(1, this.f5183D, this.f5185F[this.f5183D], this.f5186G[this.f5183D]);
            if (drawableM5343a == null) {
                this.f5212o.setScaleType(ImageView.ScaleType.CENTER);
                this.f5212o.setImageResource(R.drawable.button_pen);
            } else {
                this.f5212o.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f5212o.setImageDrawable(drawableM5343a);
            }
            m5337F();
            return;
        }
        switch (this.f5183D) {
            case 1:
                i = R.drawable.toolbar_pen_02;
                break;
            case 2:
                i = R.drawable.toolbar_pen_04;
                break;
            case 3:
                i = R.drawable.toolbar_pen_03;
                break;
            default:
                i = R.drawable.toolbar_pen_01;
                break;
        }
        this.f5212o.setScaleType(ImageView.ScaleType.CENTER);
        this.f5212o.setImageResource(i);
    }

    /* renamed from: j */
    private void m5399j(boolean z) {
        if (this.f5221x != null) {
            this.f5221x.recycle();
            this.f5221x = null;
        }
        if (z) {
            this.f5213p.setScaleType(ImageView.ScaleType.CENTER);
            this.f5213p.setImageResource(R.drawable.button_text);
            return;
        }
        this.f5221x = m5334C();
        if (this.f5221x == null) {
            this.f5213p.setScaleType(ImageView.ScaleType.CENTER);
            this.f5213p.setImageResource(R.drawable.button_text);
        } else {
            this.f5213p.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f5213p.setImageBitmap(this.f5221x);
        }
        m5337F();
    }

    /* renamed from: k */
    private void m5403k(boolean z) throws Resources.NotFoundException {
        int dimensionPixelOffset = m5333B().getResources().getDimensionPixelOffset(R.dimen.ams_stamp_button_padding);
        this.f5214q.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        if (this.f5222y != null) {
            this.f5222y.recycle();
            this.f5222y = null;
        }
        if (z) {
            this.f5214q.setPadding(0, 0, 0, 0);
            this.f5214q.setScaleType(ImageView.ScaleType.CENTER);
            this.f5214q.setImageResource(R.drawable.button_stamp);
            return;
        }
        if (this.f5194O < C1561z.m5654a().m5670f()) {
            this.f5222y = C1561z.m5654a().m5657a(this.f5194O, false);
        } else {
            this.f5222y = C1561z.m5654a().m5664b(this.f5194O - 1000, false);
        }
        if (this.f5222y == null) {
            this.f5214q.setPadding(0, 0, 0, 0);
            this.f5214q.setScaleType(ImageView.ScaleType.CENTER);
            this.f5214q.setImageResource(R.drawable.button_stamp);
        } else {
            this.f5214q.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f5214q.setImageBitmap(this.f5222y);
        }
        m5337F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5384g(int i) throws Resources.NotFoundException {
        m5394i(false);
        switch (i) {
            case 2003:
                m5399j(true);
                break;
            case 2005:
                m5403k(false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m5337F() {
        if (this.f5180A != null) {
            this.f5180A.m4808v();
        }
    }

    /* renamed from: G */
    private void m5338G() {
        this.f5205Z = (GeneralHeaderView) findViewById(R.id.view_titlebar);
    }

    /* renamed from: H */
    private void m5339H() {
        m5338G();
        this.f5205Z.setText(R.string.ams_app_name);
        m5340I();
        this.f5205Z.setButtonImageResource(R.drawable.general_btn_down_arrow_xml);
        this.f5205Z.setBackClickListener(new ViewOnClickListenerC1523e(this));
        this.f5206aa = new C1632t(this);
        this.f5205Z.setButtonClickListener(new ViewOnClickListenerC1524f(this));
    }

    /* renamed from: I */
    private void m5340I() {
        if (this.f5205Z != null) {
            this.f5205Z.setTextSize(getResources().getDimension(R.dimen.ams_ics2_title_text_size) / getResources().getDisplayMetrics().density);
        }
    }

    /* renamed from: J */
    private void m5341J() {
        m5338G();
        this.f5205Z.setText(R.string.ams_title_text);
        this.f5205Z.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
        this.f5205Z.setBackClickListener(new ViewOnClickListenerC1521c(this));
        this.f5205Z.setButtonClickListener(new ViewOnClickListenerC1522d(this));
    }

    /* renamed from: b */
    private void m5359b(int i, int i2) {
        if (this.f5180A != null && this.f5180A.m4769A()) {
            this.f5180A.m4770a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5407l(boolean z) throws Resources.NotFoundException {
        if (this.f5180A != null) {
            if (this.f5180A.m4769A()) {
                this.f5180A.m4811y();
            }
            if (z) {
                this.f5180A.m4810x();
            }
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC1553r
    /* renamed from: a */
    public void mo5121a(boolean z) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (!C1632t.m5917c()) {
            return super.onMenuOpened(i, menu);
        }
        this.f5206aa.m5919a(findViewById(R.id.header_button1));
        return false;
    }
}
