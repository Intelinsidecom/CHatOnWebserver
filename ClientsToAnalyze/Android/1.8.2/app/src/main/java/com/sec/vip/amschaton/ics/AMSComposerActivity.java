package com.sec.vip.amschaton.ics;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C1849ai;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.DialogC1841aa;
import com.sec.vip.amschaton.DialogC1873bf;
import com.sec.vip.amschaton.InterfaceC1872be;
import com.sec.vip.amschaton.InterfaceC1879bl;
import com.sec.vip.amschaton.InterfaceC2061k;
import com.sec.vip.amschaton.InterfaceC2063m;
import com.sec.vip.amschaton.InterfaceC2075y;
import com.sec.vip.amschaton.ViewOnClickListenerC1875bh;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2134f;
import com.sec.widget.GeneralHeaderView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSComposerActivity extends AMSActivity implements View.OnClickListener, InterfaceC2061k, InterfaceC2063m, InterfaceC2075y {

    /* renamed from: l */
    public static boolean f7138l = true;

    /* renamed from: m */
    public static boolean f7139m = false;

    /* renamed from: A */
    private ImageView f7140A;

    /* renamed from: B */
    private ImageView f7141B;

    /* renamed from: C */
    private ImageView f7142C;

    /* renamed from: H */
    private PopupWindow f7147H;

    /* renamed from: I */
    private AMSDrawManager f7148I;

    /* renamed from: Z */
    private String f7165Z;

    /* renamed from: ah */
    private int f7173ah;

    /* renamed from: ai */
    private int f7174ai;

    /* renamed from: o */
    private ImageView f7182o;

    /* renamed from: p */
    private ImageView f7183p;

    /* renamed from: q */
    private ImageView f7184q;

    /* renamed from: r */
    private ImageView f7185r;

    /* renamed from: s */
    private ImageView f7186s;

    /* renamed from: t */
    private ImageView f7187t;

    /* renamed from: u */
    private ImageView f7188u;

    /* renamed from: v */
    private ImageView f7189v;

    /* renamed from: w */
    private ImageView f7190w;

    /* renamed from: x */
    private LinearLayout f7191x;

    /* renamed from: y */
    private ImageView f7192y;

    /* renamed from: z */
    private TextView f7193z;

    /* renamed from: n */
    private float f7181n = 1.0f;

    /* renamed from: D */
    private Bitmap f7143D = null;

    /* renamed from: E */
    private Bitmap f7144E = null;

    /* renamed from: F */
    private Bitmap f7145F = null;

    /* renamed from: G */
    private Bitmap f7146G = null;

    /* renamed from: J */
    private int f7149J = 2000;

    /* renamed from: K */
    private int f7150K = 2002;

    /* renamed from: L */
    private int f7151L = 4001;

    /* renamed from: M */
    private boolean f7152M = false;

    /* renamed from: N */
    private int f7153N = 0;

    /* renamed from: O */
    private int f7154O = 0;

    /* renamed from: P */
    private int f7155P = -16777216;

    /* renamed from: Q */
    private int f7156Q = -16777216;

    /* renamed from: R */
    private int f7157R = 2;

    /* renamed from: S */
    private DialogC1873bf f7158S = null;

    /* renamed from: T */
    private boolean f7159T = false;

    /* renamed from: U */
    private boolean f7160U = false;

    /* renamed from: V */
    private InterfaceC1872be f7161V = null;

    /* renamed from: W */
    private RelativeLayout f7162W = null;

    /* renamed from: X */
    private ViewOnClickListenerC1875bh f7163X = null;

    /* renamed from: Y */
    private int f7164Y = 0;

    /* renamed from: aa */
    private boolean f7166aa = true;

    /* renamed from: ab */
    private boolean f7167ab = false;

    /* renamed from: ac */
    private boolean f7168ac = false;

    /* renamed from: ad */
    private String f7169ad = "";

    /* renamed from: ae */
    private int f7170ae = -2;

    /* renamed from: af */
    private boolean f7171af = true;

    /* renamed from: ag */
    private RelativeLayout f7172ag = null;

    /* renamed from: aj */
    private boolean f7175aj = false;

    /* renamed from: ak */
    private View f7176ak = null;

    /* renamed from: al */
    private View f7177al = null;

    /* renamed from: am */
    private GeneralHeaderView f7178am = null;

    /* renamed from: an */
    private Handler f7179an = new HandlerC2058y(this);

    /* renamed from: ao */
    private InterfaceC1879bl f7180ao = new C2045l(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        f7139m = false;
        this.f7152M = false;
        m6887G();
        m6264c();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7165Z = extras.getString("AMS_FILE_PATH");
            this.f7167ab = extras.getBoolean("AMS_SAVE_FLAG", false);
            this.f7168ac = extras.getBoolean("AMS_EDIT_FLAG", false);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f7165Z = null;
        }
        this.f7166aa = this.f7165Z == null;
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f7171af = true;
            this.f7181n = getWindowManager().getDefaultDisplay().getWidth() / 480.0f;
        } else if (configuration.orientation == 2) {
            this.f7171af = false;
            this.f7181n = getWindowManager().getDefaultDisplay().getHeight() / 480.0f;
        }
        setContentView(R.layout.ams_ics_layout_composer);
        m6976o();
        m6983q();
        m6984r();
        if (AMSStampSelectionActivity.f7231l) {
            if (C1849ai.m6394a().m6405c() > 0) {
                this.f7164Y = (C1849ai.m6394a().m6405c() + 1000) - 1;
            } else {
                this.f7164Y = 0;
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        if (f7138l && this.f7167ab && this.f7148I.m6327t() && !this.f7152M) {
            m6956j();
        }
        if (this.f7143D != null) {
            this.f7143D.recycle();
            this.f7143D = null;
        }
        if (this.f7144E != null) {
            this.f7144E.recycle();
            this.f7144E = null;
        }
        if (this.f7145F != null) {
            this.f7145F.recycle();
            this.f7145F = null;
        }
        if (this.f7146G != null) {
            this.f7146G.recycle();
            this.f7146G = null;
        }
        if (this.f7148I != null) {
            this.f7148I.m6328u();
            this.f7148I = null;
        }
        this.f7175aj = false;
        f7139m = true;
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6063c("[onResume]", getClass().getName());
        f7138l = true;
        m6261a();
        if (this.f7160U && this.f7163X != null) {
            m6900a(this.f7163X.m6495b(), true);
        }
        super.onResume();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        C1786r.m6063c("[onPause]", getClass().getName());
        if (this.f7160U && this.f7163X != null) {
            m6900a(this.f7163X.m6495b(), false);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1786r.m6063c("[onRestoreInstanceState]", getClass().getName());
        if (bundle != null && bundle.getBoolean("SI_SAVE_TEMP_AMS", false)) {
            this.f7167ab = bundle.getBoolean("SI_SAVE_FLAG", this.f7167ab);
            this.f7168ac = bundle.getBoolean("SI_EDIT_FLAG", this.f7168ac);
            this.f7165Z = f6614g;
            m6909b(3000);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1786r.m6063c("[onSaveInstanceState]", getClass().getName());
        boolean z = true;
        if (this.f7148I.m6327t()) {
            if (!m6931e(false)) {
                C1786r.m6063c("[onSaveInstanceState] Cannot save temp AMS file!", getClass().getName());
                z = false;
            }
            bundle.putBoolean("SI_SAVE_FLAG", this.f7167ab);
            bundle.putBoolean("SI_EDIT_FLAG", this.f7168ac);
        } else {
            z = false;
        }
        bundle.putBoolean("SI_SAVE_TEMP_AMS", z);
        f7138l = false;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f7171af = true;
        } else if (configuration.orientation == 2) {
            this.f7171af = false;
        }
        setContentView(R.layout.ams_ics_layout_composer);
        m6980p();
        m6983q();
        if (this.f7148I != null) {
            this.f7148I.m6330w();
        }
        if (this.f7147H != null && this.f7147H.isShowing()) {
            m6921c(false);
        }
        if (this.f7160U && this.f7163X != null) {
            m6914b(this.f7163X.m6495b().getText().toString());
            m6936f(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f7160U) {
            m6936f(false);
            return;
        }
        if (!this.f7167ab || !this.f7148I.m6327t()) {
            f7138l = false;
        }
        m6937g();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        Bundle extras;
        switch (i) {
            case 3:
                if (i2 == -1 && (extras = intent.getExtras()) != null) {
                    if (extras.getInt("AMS_FRAME", 1001) == 1002) {
                        int i3 = extras.getInt("BACKGROUND_COLOR", -16777216);
                        this.f7148I.m6297a(Color.red(i3), Color.green(i3), Color.blue(i3), true);
                        this.f7148I.m6314g();
                        m6889I();
                        break;
                    } else {
                        Bitmap bitmapM6894a = m6894a(intent, extras);
                        if (bitmapM6894a != null) {
                            m6898a(bitmapM6894a);
                            bitmapM6894a.recycle();
                            File file = new File(f6615h);
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
                    if (this.f7148I.m6312e() == null) {
                        if (this.f7164Y > C1849ai.m6394a().m6410f()) {
                            Bitmap bitmapM6404b = C1849ai.m6394a().m6404b(this.f7164Y - 1000, false);
                            if (bitmapM6404b == null) {
                                this.f7164Y = 0;
                            } else {
                                bitmapM6404b.recycle();
                            }
                        }
                        this.f7148I.m6296a(3, this.f7164Y, 0, 0);
                        m6977o(this.f7149J);
                        break;
                    }
                } else {
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        this.f7164Y = extras2.getInt("AMS_STAMP_INDEX", 0);
                        if (this.f7164Y < 0 || this.f7164Y > C1849ai.m6394a().m6410f()) {
                            Bitmap bitmapM6404b2 = C1849ai.m6394a().m6404b(this.f7164Y - 1000, false);
                            if (bitmapM6404b2 == null) {
                                this.f7164Y = 0;
                            } else {
                                bitmapM6404b2.recycle();
                            }
                        }
                        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 3);
                        int[] iArr = {sharedPreferences.getInt("AMS_STAMP_PREF_00", -1), sharedPreferences.getInt("AMS_STAMP_PREF_01", -1), sharedPreferences.getInt("AMS_STAMP_PREF_02", -1), sharedPreferences.getInt("AMS_STAMP_PREF_03", -1)};
                        int i4 = iArr[0];
                        int i5 = 0;
                        while (i5 < 4) {
                            int i6 = iArr[i5];
                            iArr[i5] = i4;
                            if (i6 != this.f7164Y) {
                                i5++;
                                i4 = i6;
                            } else {
                                iArr[0] = this.f7164Y;
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                                this.f7148I.m6296a(3, this.f7164Y, 0, 0);
                                m6977o(this.f7149J);
                                m6888H();
                                break;
                            }
                        }
                        iArr[0] = this.f7164Y;
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                        this.f7148I.m6296a(3, this.f7164Y, 0, 0);
                        m6977o(this.f7149J);
                        m6888H();
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        m6936f(false);
        switch (view.getId()) {
            case R.id.btn_tool_background_image /* 2131492945 */:
                m6997x();
                break;
            case R.id.btn_tool_pen /* 2131492946 */:
                m6961k();
                break;
            case R.id.btn_tool_stamp_shape /* 2131492947 */:
                m6999y();
                break;
            case R.id.btn_tool_text /* 2131492948 */:
                m6965l();
                break;
            case R.id.btn_preview /* 2131492950 */:
                if (!this.f7175aj) {
                    this.f7175aj = true;
                    m6880A();
                    break;
                }
                break;
            case R.id.btn_undo /* 2131492951 */:
                this.f7148I.m6318k();
                break;
            case R.id.btn_redo /* 2131492952 */:
                this.f7148I.m6319l();
                break;
            case R.id.btn_send /* 2131492953 */:
                m6883C();
                break;
            case R.id.btn_pen_style /* 2131493009 */:
                if (this.f7147H == null || !this.f7147H.isShowing()) {
                    m6987s();
                    break;
                }
                break;
            case R.id.btn_pen_size /* 2131493010 */:
                if (this.f7147H == null || !this.f7147H.isShowing()) {
                    m6988t();
                    break;
                }
                break;
            case R.id.btn_pen_color /* 2131493011 */:
                if (this.f7147H == null || !this.f7147H.isShowing()) {
                    m6990u();
                    break;
                }
                break;
            case R.id.btn_text_size /* 2131493015 */:
                if (this.f7147H == null || !this.f7147H.isShowing()) {
                    m6993v();
                    break;
                }
                break;
            case R.id.btn_text_color /* 2131493016 */:
                if (this.f7147H == null || !this.f7147H.isShowing()) {
                    m6994w();
                    break;
                }
                break;
        }
    }

    /* renamed from: b */
    private void m6915b(boolean z) {
        if (z) {
            getWindow().clearFlags(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
        } else {
            getWindow().addFlags(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6937g() {
        f7138l = false;
        if (!this.f7167ab || !this.f7148I.m6324q()) {
            m6946h();
        } else {
            new AlertDialogBuilderC2120a(this).setMessage(R.string.ams_msg_exit_with_save).setNegativeButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC2047n(this)).setPositiveButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC2039f(this)).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6946h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6950i() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2006);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6956j() {
        if (!this.f7148I.m6301a(f6610c + m6895a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m6262a(R.string.ams_error_ams_file_save);
        } else {
            m6262a(R.string.ams_msg_saved);
        }
    }

    /* renamed from: b */
    private void m6909b(int i) {
        new Thread(new RunnableC1980ac(this, i)).start();
    }

    /* renamed from: k */
    private void m6961k() throws Resources.NotFoundException {
        m6958j(false);
        this.f7148I.setEditMode(false, false);
        this.f7149J = 2002;
        m6918c(this.f7149J);
        this.f7148I.m6296a(1, this.f7153N, this.f7155P, this.f7154O);
        this.f7150K = this.f7149J;
        m6889I();
        m6981p(this.f7149J);
    }

    /* renamed from: l */
    private void m6965l() throws Resources.NotFoundException {
        this.f7148I.setEditMode(false, false);
        this.f7149J = 2003;
        m6918c(this.f7149J);
        this.f7148I.m6296a(2, 0, this.f7156Q, this.f7157R);
        this.f7150K = this.f7149J;
        m6977o(this.f7149J);
        m6889I();
        m6981p(this.f7149J);
        m6958j(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m6968m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m6972n() {
        if (!this.f7186s.isEnabled() && this.f7148I.m6324q()) {
            this.f7186s.setEnabled(true);
        } else if (this.f7186s.isEnabled() && !this.f7148I.m6324q()) {
            this.f7186s.setEnabled(false);
        }
        if (!this.f7187t.isEnabled() && this.f7148I.m6325r()) {
            this.f7187t.setEnabled(true);
        } else if (this.f7187t.isEnabled() && !this.f7148I.m6325r()) {
            this.f7187t.setEnabled(false);
        }
        if (!this.f7188u.isEnabled() && this.f7148I.m6327t()) {
            this.f7188u.setEnabled(true);
            this.f7189v.setEnabled(true);
        } else if (this.f7188u.isEnabled() && !this.f7148I.m6327t()) {
            this.f7188u.setEnabled(false);
            this.f7189v.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6918c(int i) throws Resources.NotFoundException {
        m6925d(i);
        m6977o(i);
    }

    /* renamed from: d */
    private void m6925d(int i) {
        int[] iArr = {2002, 2003, 2005, 2001};
        ImageView[] imageViewArr = {this.f7183p, this.f7184q, this.f7185r, this.f7182o};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(false);
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i) {
                imageViewArr[i3].setSelected(true);
            }
        }
    }

    /* renamed from: o */
    private void m6976o() throws Resources.NotFoundException {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ams_ics_titlebar_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_canvas_margin);
        if (width >= height) {
            width = (height - dimensionPixelSize) - (dimensionPixelSize2 * 2);
        }
        this.f7173ah = width;
        C1786r.m6063c("[createComposer] Composer Size = " + this.f7173ah, getClass().getSimpleName());
        this.f7174ai = this.f7173ah;
        if (this.f7148I != null) {
            this.f7148I.m6328u();
            this.f7148I = null;
        }
        this.f7148I = new AMSDrawManager(this, this.f7173ah, this.f7174ai);
        this.f7148I.m6293a();
        this.f7148I.setEnableZoom(true);
        this.f7148I.setPlayMode(false);
        this.f7148I.setOnTextInputRequestListener(this);
        this.f7148I.setOnObjectListener(this);
        this.f7148I.setOnTouchTextArea(this);
        this.f7148I.setEraserSize(this.f7154O);
        this.f7169ad = "";
        if (!this.f7166aa) {
            m7000z();
        }
        m6980p();
    }

    /* renamed from: p */
    private void m6980p() {
        if (this.f7172ag != null) {
            this.f7172ag.removeAllViews();
            this.f7172ag = null;
        }
        this.f7172ag = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f7172ag.setLayoutParams(layoutParams);
        this.f7172ag.addView(this.f7148I);
    }

    /* renamed from: q */
    private void m6983q() throws Resources.NotFoundException {
        m6892L();
        m6915b(this.f7171af);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        relativeLayout.addView(this.f7172ag);
        this.f7182o = (ImageView) findViewById(R.id.btn_tool_background_image);
        this.f7183p = (ImageView) findViewById(R.id.btn_tool_pen);
        this.f7184q = (ImageView) findViewById(R.id.btn_tool_text);
        this.f7185r = (ImageView) findViewById(R.id.btn_tool_stamp_shape);
        this.f7186s = (ImageView) findViewById(R.id.btn_undo);
        this.f7187t = (ImageView) findViewById(R.id.btn_redo);
        this.f7188u = (ImageView) findViewById(R.id.btn_preview);
        this.f7189v = (ImageView) findViewById(R.id.btn_send);
        m6890J();
        this.f7182o.setOnClickListener(this);
        this.f7183p.setOnClickListener(this);
        this.f7184q.setOnClickListener(this);
        this.f7185r.setOnClickListener(this);
        this.f7186s.setOnClickListener(this);
        this.f7187t.setOnClickListener(this);
        this.f7188u.setOnClickListener(this);
        this.f7189v.setOnClickListener(this);
        if (!this.f7166aa) {
            m6909b(3000);
        }
        this.f7186s.setEnabled(this.f7148I.m6324q());
        this.f7187t.setEnabled(this.f7148I.m6325r());
        this.f7188u.setEnabled(this.f7148I.m6327t());
        this.f7189v.setEnabled(this.f7148I.m6327t());
        m6968m();
        m6918c(this.f7149J);
        m6909b(3001);
    }

    /* renamed from: r */
    private void m6984r() throws Resources.NotFoundException {
        this.f7149J = 2002;
        this.f7150K = this.f7149J;
        this.f7148I.m6296a(1, this.f7153N, this.f7155P, this.f7154O);
        m6918c(this.f7149J);
        m6909b(3001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m6921c(boolean z) throws Resources.NotFoundException {
        this.f7149J = this.f7150K;
        if (this.f7147H == null) {
            m6918c(this.f7149J);
            return false;
        }
        if (!this.f7147H.isShowing()) {
            m6918c(this.f7149J);
            return false;
        }
        if (z) {
            new View(this).post(new RunnableC1981ad(this));
        } else {
            this.f7147H.dismiss();
            m6918c(this.f7149J);
        }
        return true;
    }

    /* renamed from: e */
    private void m6927e(int i) {
        int i2 = R.drawable.ams_toolbar_icon_pen_01;
        switch (i) {
            case 1:
                i2 = R.drawable.ams_toolbar_icon_pen_02;
                break;
            case 2:
                i2 = R.drawable.ams_toolbar_icon_pen_04;
                break;
            case 3:
                i2 = R.drawable.ams_toolbar_icon_pen_03;
                break;
        }
        this.f7190w.setImageResource(i2);
    }

    /* renamed from: f */
    private void m6932f(int i) {
    }

    /* renamed from: g */
    private void m6938g(int i) {
        int[] iArr = {R.drawable.ams_text_icon01, R.drawable.ams_text_icon02, R.drawable.ams_text_icon03, R.drawable.ams_text_icon04, R.drawable.ams_text_icon05};
        if (i >= 0 && i < iArr.length) {
            this.f7141B.setImageResource(iArr[i]);
        }
    }

    /* renamed from: h */
    private int m6943h(int i) {
        int[] iArr = {R.drawable.ams_color_icon01, R.drawable.ams_color_icon02, R.drawable.ams_color_icon03, R.drawable.ams_color_icon04, R.drawable.ams_color_icon05, R.drawable.ams_color_icon06, R.drawable.ams_color_icon07, R.drawable.ams_color_icon08, R.drawable.ams_color_icon09, R.drawable.ams_color_icon10, R.drawable.ams_color_icon11, R.drawable.ams_color_icon12, R.drawable.ams_color_icon13, R.drawable.ams_color_icon14, R.drawable.ams_color_icon15};
        int[] iArr2 = {R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        int i2 = 0;
        for (int i3 = 0; i3 < 15; i3++) {
            if (i == getResources().getColor(iArr2[i3])) {
                i2 = i3;
            }
        }
        return iArr[i2];
    }

    /* renamed from: i */
    private void m6951i(int i) {
        this.f7140A.setImageResource(m6943h(i));
    }

    /* renamed from: j */
    private void m6957j(int i) {
        this.f7142C.setImageResource(m6943h(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6897a(int i, int i2, int i3) throws Resources.NotFoundException {
        this.f7153N = i;
        this.f7154O = i2;
        this.f7155P = i3;
        this.f7148I.m6296a(1, this.f7153N, this.f7155P, this.f7154O);
        m6927e(this.f7153N);
        m6932f(this.f7154O);
        m6951i(this.f7155P);
        m6889I();
        m6977o(this.f7149J);
        m6888H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6896a(int i, int i2) throws Resources.NotFoundException {
        this.f7157R = i;
        this.f7156Q = i2;
        if (this.f7148I.m6312e() == null) {
            this.f7148I.m6296a(2, 0, this.f7156Q, this.f7157R);
        } else {
            this.f7148I.m6295a(0, this.f7156Q, this.f7157R);
        }
        m6938g(this.f7157R);
        m6957j(this.f7156Q);
        m6889I();
        m6977o(this.f7149J);
        m6910b(this.f7156Q, this.f7157R);
        m6888H();
    }

    /* renamed from: s */
    private void m6987s() {
        this.f7151L = 4001;
        m6962k(this.f7151L);
        C1851ak c1851ak = new C1851ak(this, R.layout.ams_ics_layout_popup_pen_style, this.f7190w, this.f7171af);
        c1851ak.m6429a(this.f7153N);
        c1851ak.m6441a(new C1982ae(this, c1851ak));
        this.f7147H = c1851ak;
    }

    /* renamed from: t */
    private void m6988t() {
        this.f7151L = 4002;
        m6962k(this.f7151L);
        C1851ak c1851ak = new C1851ak(this, R.layout.ams_ics_layout_popup_pen_size, this.f7191x, this.f7171af);
        c1851ak.m6431b(this.f7154O);
        c1851ak.m6441a(new C1983af(this, c1851ak));
        this.f7147H = c1851ak;
    }

    /* renamed from: u */
    private void m6990u() {
        this.f7151L = 4003;
        m6962k(this.f7151L);
        C1851ak c1851ak = new C1851ak(this, R.layout.ams_ics_layout_popup_color, this.f7140A, this.f7171af);
        c1851ak.m6433c(this.f7155P);
        c1851ak.m6441a(new C1984ag(this, c1851ak));
        this.f7147H = c1851ak;
    }

    /* renamed from: v */
    private void m6993v() {
        this.f7151L = 4002;
        m6966l(this.f7151L);
        C1851ak c1851ak = new C1851ak(this, R.layout.ams_ics_layout_popup_text_size, this.f7141B, this.f7171af);
        c1851ak.m6431b(this.f7157R);
        c1851ak.m6441a(new C1985ah(this, c1851ak));
        this.f7147H = c1851ak;
    }

    /* renamed from: w */
    private void m6994w() {
        this.f7151L = 4003;
        m6966l(this.f7151L);
        C1851ak c1851ak = new C1851ak(this, R.layout.ams_ics_layout_popup_color, this.f7142C, this.f7171af);
        c1851ak.m6433c(this.f7156Q);
        c1851ak.m6441a(new C2040g(this, c1851ak));
        this.f7147H = c1851ak;
    }

    /* renamed from: k */
    private void m6962k(int i) {
        if (this.f7149J == 2002) {
            this.f7190w.setSelected(false);
            this.f7191x.setSelected(false);
            this.f7192y.setSelected(false);
            this.f7193z.setSelected(false);
            this.f7140A.setSelected(false);
            switch (i) {
                case 4001:
                    this.f7190w.setSelected(true);
                    break;
                case 4002:
                    this.f7191x.setSelected(true);
                    this.f7192y.setSelected(true);
                    break;
                case 4003:
                    this.f7140A.setSelected(true);
                    break;
            }
        }
    }

    /* renamed from: l */
    private void m6966l(int i) {
        if (this.f7149J == 2003) {
            this.f7141B.setSelected(false);
            this.f7142C.setSelected(false);
            switch (i) {
                case 4002:
                    this.f7141B.setSelected(true);
                    break;
                case 4003:
                    this.f7142C.setSelected(true);
                    break;
            }
        }
    }

    /* renamed from: x */
    private void m6997x() {
        m6958j(false);
        Intent intent = new Intent(this, (Class<?>) AMSBgFrameSelectionActivity.class);
        intent.putExtra("BACKGROUND_COLOR", this.f7148I.m6303b());
        intent.putExtra("BACKGROUND_INDEX", this.f7170ae);
        startActivityForResult(intent, 3);
    }

    /* renamed from: y */
    private void m6999y() throws Resources.NotFoundException {
        m6958j(false);
        this.f7148I.setEditMode(false, false);
        this.f7149J = 2005;
        m6918c(this.f7149J);
        this.f7148I.m6296a(3, this.f7164Y, 0, 0);
        this.f7150K = this.f7149J;
        m6977o(this.f7149J);
        m6889I();
        Intent intent = new Intent(this, (Class<?>) AMSStampSelectionActivity.class);
        intent.putExtra("AMS_STAMP_INDEX", this.f7164Y);
        startActivityForResult(intent, 11);
    }

    /* renamed from: m */
    private void m6969m(int i) {
        f7138l = false;
        if (!this.f7167ab || !this.f7148I.m6324q()) {
            m6973n(i);
        } else {
            new AlertDialogBuilderC2120a(this).setMessage(R.string.ams_msg_exit_with_save).setNegativeButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC2042i(this, i)).setPositiveButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC2041h(this, i)).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m6973n(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2001);
        intent.putExtra("AMS_TAB_ID", i);
        intent.putExtra("AMS_SAVE_FLAG", this.f7167ab);
        startActivity(intent);
        finish();
    }

    /* renamed from: z */
    private void m7000z() {
        if (this.f7148I != null) {
            this.f7148I.m6297a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, true);
            this.f7148I.m6314g();
            m6889I();
        }
    }

    /* renamed from: a */
    private void m6898a(Bitmap bitmap) {
        this.f7148I.m6298a(bitmap, true);
        this.f7148I.setEditMode(false, true);
        m6889I();
    }

    /* renamed from: A */
    private void m6880A() {
        if (!m6931e(false)) {
            this.f7175aj = false;
            return;
        }
        f7138l = false;
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2004);
        intent.putExtra("AMS_FILE_PATH", f6614g);
        intent.putExtra("AMS_SAVE_FLAG", this.f7167ab);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m6882B() throws Resources.NotFoundException {
        if (this.f7148I != null) {
            this.f7167ab = false;
            m6976o();
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            relativeLayout.addView(this.f7172ag);
            m6984r();
            m6972n();
            if (this.f7176ak != null) {
                m6911b(this.f7176ak, this.f7176ak.getVisibility() == 0);
            }
            if (this.f7177al != null) {
                m6911b(this.f7177al, this.f7177al.getVisibility() == 0);
            }
        }
    }

    /* renamed from: C */
    private void m6883C() {
        if (this.f7148I != null) {
            if (!this.f7148I.m6327t()) {
                m6262a(R.string.ams_msg_empty_ams);
                return;
            }
            DialogC1841aa dialogC1841aa = new DialogC1841aa(this);
            dialogC1841aa.m6393a(0, R.string.ams_send_as_animation, true);
            dialogC1841aa.m6393a(1, R.string.ams_send_as_image, true);
            dialogC1841aa.m6393a(2, R.string.ams_save_and_exit, false);
            dialogC1841aa.m6392a(new C2043j(this));
            dialogC1841aa.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String m6924d(boolean z) {
        String str = f6610c + m6895a("A", System.currentTimeMillis(), ".jpg");
        if (!this.f7148I.m6301a(str)) {
            m6262a(R.string.ams_error_ams_file_save);
            this.f7152M = false;
            return null;
        }
        this.f7152M = true;
        File file = new File(str);
        if (file.length() < 1048576 || !z) {
            return str;
        }
        file.delete();
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_btn_send).setMessage(String.format("%s\n(%d/%d)", getResources().getString(R.string.ams_msg_exceed_limit), Long.valueOf(file.length()), 1048576)).setNegativeButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC2044k(this)).create().show();
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
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m6884D() throws java.lang.Throwable {
        /*
            r7 = this;
            r1 = 0
            r6 = 480(0x1e0, float:6.73E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.sec.vip.amschaton.ics.AMSComposerActivity.f6616i
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "I"
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = ".jpg"
            java.lang.String r2 = r7.m6895a(r2, r3, r5)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f7148I
            boolean r2 = r2.m6314g()
            if (r2 == 0) goto L61
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f7148I
            android.graphics.Bitmap r2 = r2.m6313f()
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
            r0 = 2131427694(0x7f0b016e, float:1.8477011E38)
            r7.m6262a(r0)
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
            com.sec.chaton.util.C1786r.m6054a(r0, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSComposerActivity.m6884D():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6907a(String str, int i) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_SEND_METHOD", i);
        startActivity(intent);
        finish();
    }

    /* renamed from: e */
    private boolean m6931e(boolean z) {
        if (this.f7148I == null) {
            C1786r.m6054a("[startAMSPreview] mAMSComposer is NULL!", getClass().getSimpleName());
            return false;
        }
        if (!z && !this.f7148I.m6327t()) {
            C1786r.m6054a("[startAMSPreview] Empty AMS file!", getClass().getSimpleName());
            return false;
        }
        File file = new File(f6614g);
        if (file.exists()) {
            file.delete();
        }
        if (!this.f7148I.m6301a(f6614g)) {
            C1786r.m6054a("[startAMSPreview] Fail to save AMS file!", getClass().getSimpleName());
            return false;
        }
        this.f7148I.setEditMode(false, false);
        return true;
    }

    /* renamed from: E */
    private Context m6885E() {
        return this;
    }

    /* renamed from: a */
    private Bitmap m6894a(Intent intent, Bundle bundle) {
        Bitmap bitmapDecodeFile;
        if (bundle.getBoolean("exceed_size", true)) {
            C1786r.m6061b("[getBitmapFromExtras] exceed_size is true!", getClass().getSimpleName());
            String string = bundle.getString("temp_file_path");
            if (string == null) {
                return null;
            }
            C1786r.m6061b("tmpFilePath : " + string, getClass().getSimpleName());
            bitmapDecodeFile = BitmapFactory.decodeFile(string);
            if (bitmapDecodeFile == null) {
                return null;
            }
            File file = new File(string);
            if (file.exists()) {
                file.delete();
            }
        } else {
            C1786r.m6061b("[getBitmapFromExtras] exceed_size is false!", getClass().getSimpleName());
            bitmapDecodeFile = (Bitmap) bundle.getParcelable("data");
        }
        C1786r.m6061b("[getBitmapFromExtras] bmp width and height : " + bitmapDecodeFile.getWidth() + "," + bitmapDecodeFile.getHeight(), getClass().getSimpleName());
        return bitmapDecodeFile;
    }

    /* renamed from: a */
    private String m6895a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m6900a(EditText editText, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(editText, 2);
        } else {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6936f(boolean z) {
        if (this.f7162W != null && this.f7163X != null) {
            m6900a(this.f7163X.m6495b(), z);
            this.f7160U = z;
            if (z) {
                this.f7162W.setVisibility(0);
                m6893M();
                m6942g(this.f7159T);
            } else {
                this.f7162W.setVisibility(8);
                m6892L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6942g(boolean z) {
        if (this.f7178am != null && this.f7160U) {
            this.f7178am.setButtonEnabled(z);
        }
    }

    /* renamed from: b */
    private void m6914b(String str) {
        if (this.f7162W != null) {
            this.f7162W = null;
        }
        this.f7162W = (RelativeLayout) findViewById(R.id.layout_text_input);
        this.f7162W.setOnClickListener(new ViewOnClickListenerC2046m(this));
        if (this.f7163X != null) {
            this.f7163X = null;
        }
        this.f7163X = new ViewOnClickListenerC1875bh(this, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
        if (str != null) {
            this.f7163X.m6494a(str);
        }
        this.f7163X.m6493a(this.f7180ao);
        this.f7161V = new C2048o(this);
        this.f7163X.m6492a(this.f7161V);
    }

    @Override // com.sec.vip.amschaton.InterfaceC2075y
    /* renamed from: a */
    public boolean mo6667a(String str) {
        m6914b(str);
        m6936f(true);
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC2061k
    /* renamed from: a */
    public boolean mo6666a(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
                this.f7167ab = true;
                m6968m();
                m6972n();
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
            case R.id.menu_item_create_new /* 2131494141 */:
                m6886F();
                break;
            case R.id.menu_item_my_works /* 2131494143 */:
                m6969m(1000);
                break;
            case R.id.menu_item_samples /* 2131494145 */:
                m6969m(1001);
                break;
        }
        return true;
    }

    /* renamed from: F */
    private void m6886F() throws Resources.NotFoundException {
        if (!this.f7167ab || !this.f7148I.m6324q()) {
            m6882B();
        } else {
            new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_title_create_new).setMessage(R.string.ams_msg_exit_with_save).setNegativeButton(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC2050q(this)).setPositiveButton(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC2049p(this)).create().show();
        }
    }

    /* renamed from: G */
    private void m6887G() {
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 1);
        this.f7155P = sharedPreferences.getInt("AMS_PEN_COLOR", -16777216);
        this.f7154O = sharedPreferences.getInt("AMS_PEN_SIZE", 5);
        this.f7157R = sharedPreferences.getInt("AMS_TEXT_SIZE", 2);
        this.f7156Q = sharedPreferences.getInt("AMS_TEXT_COLOR", -16777216);
    }

    /* renamed from: H */
    private void m6888H() {
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 3);
        sharedPreferences.edit().putInt("AMS_TOOL_TYPE", this.f7149J).commit();
        sharedPreferences.edit().putInt("AMS_PEN_STYLE", this.f7153N).commit();
        sharedPreferences.edit().putInt("AMS_PEN_SIZE", this.f7154O).commit();
        sharedPreferences.edit().putInt("AMS_PEN_COLOR", this.f7155P).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_SIZE", this.f7157R).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_COLOR", this.f7156Q).commit();
    }

    /* renamed from: h */
    private void m6948h(boolean z) throws Resources.NotFoundException {
        int dimensionPixelOffset = m6885E().getResources().getDimensionPixelOffset(R.dimen.ams_stamp_button_padding);
        this.f7185r.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        if (this.f7146G != null) {
            this.f7146G.recycle();
            this.f7146G = null;
        }
        if (z) {
            this.f7185r.setPadding(0, 0, 0, 0);
            this.f7185r.setScaleType(ImageView.ScaleType.CENTER);
            this.f7185r.setImageResource(R.drawable.ams_ics_selector_stamp);
            return;
        }
        if (this.f7164Y < C1849ai.m6394a().m6410f()) {
            this.f7146G = C1849ai.m6394a().m6397a(this.f7164Y, false);
        } else {
            this.f7146G = C1849ai.m6394a().m6404b(this.f7164Y - 1000, false);
        }
        if (this.f7146G == null) {
            this.f7185r.setPadding(0, 0, 0, 0);
            this.f7185r.setScaleType(ImageView.ScaleType.CENTER);
            this.f7185r.setImageResource(R.drawable.ams_ics_selector_stamp);
        } else {
            this.f7185r.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f7185r.setImageBitmap(this.f7146G);
        }
        m6889I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m6977o(int i) throws Resources.NotFoundException {
        switch (i) {
            case 2005:
                m6948h(false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m6889I() {
        this.f7148I.m6329v();
    }

    /* renamed from: J */
    private void m6890J() {
        boolean z = this.f7176ak != null && this.f7176ak.getVisibility() == 0;
        this.f7176ak = ((ViewStub) findViewById(R.id.stub_text_slide_menu)).inflate();
        this.f7176ak.setOnTouchListener(new ViewOnTouchListenerC2051r(this));
        this.f7141B = (ImageView) this.f7176ak.findViewById(R.id.btn_text_size);
        this.f7142C = (ImageView) this.f7176ak.findViewById(R.id.btn_text_color);
        this.f7141B.setOnClickListener(this);
        this.f7142C.setOnClickListener(this);
        m6966l(this.f7151L);
        m6938g(this.f7157R);
        m6957j(this.f7156Q);
        this.f7176ak.findViewById(R.id.btn_close).setOnClickListener(new ViewOnClickListenerC2052s(this));
        if (z) {
            this.f7176ak.setVisibility(0);
        } else {
            this.f7176ak.setVisibility(4);
        }
        boolean z2 = this.f7177al != null && this.f7177al.getVisibility() == 0;
        this.f7177al = ((ViewStub) findViewById(R.id.stub_pen_slide_menu)).inflate();
        this.f7177al.setOnTouchListener(new ViewOnTouchListenerC2053t(this));
        this.f7190w = (ImageView) this.f7177al.findViewById(R.id.btn_pen_style);
        this.f7191x = (LinearLayout) this.f7177al.findViewById(R.id.btn_pen_size);
        this.f7192y = (ImageView) this.f7177al.findViewById(R.id.iv_pen_size);
        this.f7193z = (TextView) this.f7177al.findViewById(R.id.text_pen_size);
        this.f7140A = (ImageView) this.f7177al.findViewById(R.id.btn_pen_color);
        this.f7190w.setOnClickListener(this);
        this.f7191x.setOnClickListener(this);
        this.f7140A.setOnClickListener(this);
        this.f7193z.setText("" + this.f7154O + "px");
        m6962k(this.f7151L);
        m6927e(this.f7153N);
        m6932f(this.f7154O);
        m6951i(this.f7155P);
        this.f7177al.findViewById(R.id.btn_close).setOnClickListener(new ViewOnClickListenerC2054u(this));
        if (z2) {
            this.f7177al.setVisibility(0);
        } else {
            this.f7177al.setVisibility(4);
        }
    }

    /* renamed from: p */
    private void m6981p(int i) throws Resources.NotFoundException {
        switch (i) {
            case 2002:
                m6899a(this.f7177al, true);
                break;
            case 2003:
                m6899a(this.f7176ak, true);
                break;
        }
    }

    /* renamed from: a */
    private void m6899a(View view, boolean z) throws Resources.NotFoundException {
        if (view != null) {
            if (z) {
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_ics_tool_selection_panel_appear);
                view.startAnimation(animationLoadAnimation);
                animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC2055v(this, view));
            } else {
                view.setVisibility(0);
            }
            m6952i(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6911b(View view, boolean z) throws Resources.NotFoundException {
        if (view != null) {
            if (z) {
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_ics_tool_selection_panel_disappear);
                view.startAnimation(animationLoadAnimation);
                animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC2056w(this, view));
            } else {
                view.setVisibility(8);
            }
            m6952i(true);
        }
    }

    /* renamed from: i */
    private void m6952i(boolean z) {
        if (this.f7182o != null && this.f7183p != null && this.f7185r != null && this.f7184q != null) {
            this.f7182o.setFocusable(z);
            this.f7183p.setFocusable(z);
            this.f7185r.setFocusable(z);
            this.f7184q.setFocusable(z);
        }
    }

    /* renamed from: K */
    private void m6891K() {
        this.f7178am = (GeneralHeaderView) findViewById(R.id.view_titlebar);
    }

    /* renamed from: L */
    private void m6892L() {
        m6891K();
        this.f7178am.setText(R.string.ams_app_name);
        this.f7178am.setButtonImageResource(R.drawable.general_btn_down_arrow_xml);
        this.f7178am.setBackClickListener(new ViewOnClickListenerC2057x(this));
        this.f7178am.setButtonClickListener(new ViewOnClickListenerC2059z(this, new C2134f(this)));
    }

    /* renamed from: M */
    private void m6893M() {
        m6891K();
        this.f7178am.setText(R.string.ams_title_text);
        this.f7178am.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
        this.f7178am.setBackClickListener(new ViewOnClickListenerC1978aa(this));
        this.f7178am.setButtonClickListener(new ViewOnClickListenerC1979ab(this));
    }

    /* renamed from: b */
    private void m6910b(int i, int i2) {
        if (this.f7148I != null && this.f7148I.m6290A()) {
            this.f7148I.m6291a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6958j(boolean z) {
        if (this.f7148I != null) {
            if (this.f7148I.m6290A()) {
                this.f7148I.m6332y();
            }
            if (z) {
                this.f7148I.m6331x();
            }
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC2063m
    /* renamed from: a */
    public void mo6665a(boolean z) throws Resources.NotFoundException {
        if (this.f7176ak != null) {
            if (!z && this.f7176ak.getVisibility() == 0) {
                m6911b(this.f7176ak, true);
            } else if (z) {
                if (this.f7176ak.getVisibility() == 8 || this.f7176ak.getVisibility() == 4) {
                    m6899a(this.f7176ak, true);
                }
            }
        }
    }
}
