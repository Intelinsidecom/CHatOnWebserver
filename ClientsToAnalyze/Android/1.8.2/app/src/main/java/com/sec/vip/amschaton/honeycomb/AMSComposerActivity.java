package com.sec.vip.amschaton.honeycomb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActionBarView;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSEditText;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C1849ai;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.C1860at;
import com.sec.vip.amschaton.C1862av;
import com.sec.vip.amschaton.C2074x;
import com.sec.vip.amschaton.DialogC1841aa;
import com.sec.vip.amschaton.InterfaceC1872be;
import com.sec.vip.amschaton.InterfaceC1879bl;
import com.sec.vip.amschaton.InterfaceC2061k;
import com.sec.vip.amschaton.InterfaceC2063m;
import com.sec.vip.amschaton.InterfaceC2075y;
import com.sec.vip.amschaton.ViewOnClickListenerC1875bh;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSComposerActivity extends AMSActivity implements View.OnClickListener, InterfaceC2061k, InterfaceC2063m, InterfaceC2075y {

    /* renamed from: l */
    public static boolean f6910l = true;

    /* renamed from: m */
    public static boolean f6911m = true;

    /* renamed from: B */
    private C1860at f6913B;

    /* renamed from: C */
    private AMSDrawManager f6914C;

    /* renamed from: S */
    private String f6930S;

    /* renamed from: aa */
    private int f6938aa;

    /* renamed from: ab */
    private int f6939ab;

    /* renamed from: p */
    private ImageView f6951p;

    /* renamed from: q */
    private ImageView f6952q;

    /* renamed from: r */
    private ImageView f6953r;

    /* renamed from: s */
    private ImageView f6954s;

    /* renamed from: t */
    private ImageView f6955t;

    /* renamed from: u */
    private ImageView f6956u;

    /* renamed from: v */
    private ImageView f6957v;

    /* renamed from: w */
    private ImageView f6958w;

    /* renamed from: o */
    private float f6950o = 1.0f;

    /* renamed from: x */
    private Bitmap f6959x = null;

    /* renamed from: y */
    private Bitmap f6960y = null;

    /* renamed from: z */
    private Bitmap f6961z = null;

    /* renamed from: A */
    private Bitmap f6912A = null;

    /* renamed from: D */
    private int f6915D = 2000;

    /* renamed from: E */
    private int f6916E = 2002;

    /* renamed from: F */
    private int f6917F = 0;

    /* renamed from: G */
    private int f6918G = 0;

    /* renamed from: H */
    private int[] f6919H = null;

    /* renamed from: I */
    private int[] f6920I = null;

    /* renamed from: J */
    private int f6921J = -16777216;

    /* renamed from: K */
    private int f6922K = 2;

    /* renamed from: L */
    private boolean f6923L = false;

    /* renamed from: M */
    private boolean f6924M = false;

    /* renamed from: N */
    private InterfaceC1872be f6925N = null;

    /* renamed from: O */
    private RelativeLayout f6926O = null;

    /* renamed from: P */
    private ViewOnClickListenerC1875bh f6927P = null;

    /* renamed from: Q */
    private int f6928Q = 0;

    /* renamed from: R */
    private boolean f6929R = true;

    /* renamed from: T */
    private boolean f6931T = true;

    /* renamed from: U */
    private boolean f6932U = false;

    /* renamed from: V */
    private boolean f6933V = false;

    /* renamed from: W */
    private boolean f6934W = false;

    /* renamed from: X */
    private int f6935X = -3;

    /* renamed from: Y */
    private boolean f6936Y = true;

    /* renamed from: Z */
    private RelativeLayout f6937Z = null;

    /* renamed from: ac */
    private boolean f6940ac = false;

    /* renamed from: ad */
    private boolean f6941ad = false;

    /* renamed from: ae */
    private boolean f6942ae = false;

    /* renamed from: n */
    AMSActionBarView f6949n = null;

    /* renamed from: af */
    private AMSEditText f6943af = null;

    /* renamed from: ag */
    private boolean f6944ag = false;

    /* renamed from: ah */
    private Handler f6945ah = new HandlerC1969t(this);

    /* renamed from: ai */
    private InterfaceC1879bl f6946ai = new C1956g(this);

    /* renamed from: aj */
    private View.OnClickListener f6947aj = new ViewOnClickListenerC1961l(this);

    /* renamed from: ak */
    private Handler f6948ak = new HandlerC1968s(this);

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        boolean z;
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        f6911m = false;
        this.f6934W = false;
        this.f6944ag = false;
        m6264c();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6930S = extras.getString("AMS_FILE_PATH");
            this.f6932U = extras.getBoolean("AMS_SAVE_FLAG", false);
            this.f6933V = extras.getBoolean("AMS_EDIT_FLAG", false);
            z = extras.getBoolean("AMS_PEN_STATE_DEFAULT", true);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f6930S = null;
            z = true;
        }
        this.f6931T = this.f6930S == null;
        this.f6919H = new int[5];
        this.f6920I = new int[5];
        m6612g(z);
        m6558E();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f6936Y = true;
            this.f6950o = getWindowManager().getDefaultDisplay().getWidth() / 480.0f;
        } else if (configuration.orientation == 2) {
            this.f6936Y = false;
            this.f6950o = getWindowManager().getDefaultDisplay().getHeight() / 480.0f;
        }
        setContentView(R.layout.ams_ics_layout_composer);
        m6585b(this.f6936Y);
        m6556C();
        if (!m6642o()) {
            C1786r.m6054a("Out of memory exception!", getClass().getSimpleName());
            return;
        }
        m6645q();
        m6597e(2002);
        if (z && AMSStampSelectionActivity.f7004l) {
            if (C1849ai.m6394a().m6405c() > 0) {
                this.f6928Q = (C1849ai.m6394a().m6405c() + 1000) - 1;
            } else {
                this.f6928Q = 0;
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        if (f6910l && this.f6932U && this.f6914C.m6327t() && !this.f6934W) {
            m6625j();
        }
        if (this.f6959x != null) {
            this.f6959x.recycle();
            this.f6959x = null;
        }
        if (this.f6960y != null) {
            this.f6960y.recycle();
            this.f6960y = null;
        }
        if (this.f6961z != null) {
            this.f6961z.recycle();
            this.f6961z = null;
        }
        if (this.f6912A != null) {
            this.f6912A.recycle();
            this.f6912A = null;
        }
        if (this.f6914C != null) {
            this.f6914C.m6328u();
            this.f6914C = null;
        }
        this.f6940ac = false;
        f6911m = true;
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6063c("[onResume]", getClass().getName());
        f6910l = true;
        m6261a();
        if (this.f6924M) {
            m6572a((EditText) this.f6943af, true);
        }
        this.f6941ad = false;
        this.f6942ae = false;
        super.onResume();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        C1786r.m6063c("[onPause]", getClass().getName());
        if (this.f6924M) {
            m6572a((EditText) this.f6943af, false);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) throws Resources.NotFoundException {
        C1786r.m6063c("[onRestoreInstanceState]", getClass().getName());
        if (bundle != null) {
            if (bundle.getBoolean("SI_SAVE_TEMP_AMS", false)) {
                this.f6932U = bundle.getBoolean("SI_SAVE_FLAG", this.f6932U);
                this.f6933V = bundle.getBoolean("SI_EDIT_FLAG", this.f6933V);
                this.f6930S = f6614g;
                m6580b(3000);
            }
            this.f6915D = bundle.getInt("SI_CURRENT_TOOL_MODE", 2002);
            m6597e(this.f6915D);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1786r.m6063c("[onSaveInstanceState]", getClass().getName());
        boolean z = true;
        if (this.f6914C.m6327t()) {
            if (!m6596d(false)) {
                C1786r.m6063c("[onSaveInstanceState] Cannot save temp AMS file!", getClass().getName());
                z = false;
            }
            bundle.putBoolean("SI_SAVE_FLAG", this.f6932U);
            bundle.putBoolean("SI_EDIT_FLAG", this.f6933V);
        } else {
            z = false;
        }
        bundle.putBoolean("SI_SAVE_TEMP_AMS", z);
        bundle.putInt("SI_CURRENT_TOOL_MODE", this.f6915D);
        f6910l = false;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f6936Y = true;
        } else if (configuration.orientation == 2) {
            this.f6936Y = false;
        }
        m6585b(this.f6936Y);
        if (this.f6914C != null) {
            this.f6914C.m6330w();
        }
        if (this.f6924M) {
            m6601e(true);
        }
        if (!this.f6929R) {
            m6616h(2005);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f6924M) {
            m6601e(false);
            if (this.f6927P != null) {
                this.f6927P.m6496c();
                return;
            }
            return;
        }
        if (!this.f6932U || !this.f6914C.m6327t()) {
            f6910l = false;
        }
        m6607g();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        Bundle extras;
        String string;
        switch (i) {
            case 3:
                if (i2 == -1 && (extras = intent.getExtras()) != null) {
                    this.f6935X = extras.getInt("BACKGROUND_INDEX", -3);
                    int i3 = extras.getInt("AMS_FRAME", 1002);
                    if (i3 == 1000) {
                        m6656v();
                        break;
                    } else if (i3 == 1003) {
                        int i4 = extras.getInt("BACKGROUND_COLOR", -16777216);
                        this.f6914C.m6297a(Color.red(i4), Color.green(i4), Color.blue(i4), true);
                        this.f6914C.m6314g();
                        m6559F();
                        break;
                    } else if (i3 == 1001) {
                        Bitmap bitmapM6565a = m6565a(intent, extras);
                        if (bitmapM6565a != null) {
                            m6571a(bitmapM6565a);
                            bitmapM6565a.recycle();
                            File file = new File(f6615h);
                            if (file.exists()) {
                                file.delete();
                                break;
                            }
                        }
                    } else if (i3 == 1002 && (string = extras.getString("BG_SKIN_PATH")) != null) {
                        try {
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getAssets().open(string));
                            if (bitmapDecodeStream != null) {
                                m6571a(bitmapDecodeStream);
                                break;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                break;
            case 11:
                if (i2 != -1) {
                    if (this.f6914C.m6312e() == null) {
                        if (this.f6928Q > C1849ai.m6394a().m6410f()) {
                            Bitmap bitmapM6404b = C1849ai.m6394a().m6404b(this.f6928Q - 1000, false);
                            if (bitmapM6404b == null) {
                                this.f6928Q = 0;
                            } else {
                                bitmapM6404b.recycle();
                            }
                        }
                        this.f6914C.m6296a(3, this.f6928Q, 0, 0);
                        m6616h(this.f6915D);
                        break;
                    }
                } else {
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        this.f6928Q = extras2.getInt("AMS_STAMP_INDEX", 0);
                        if (this.f6928Q < 0 || this.f6928Q > C1849ai.m6394a().m6410f()) {
                            Bitmap bitmapM6404b2 = C1849ai.m6394a().m6404b(this.f6928Q - 1000, false);
                            if (bitmapM6404b2 == null) {
                                this.f6928Q = 0;
                            } else {
                                bitmapM6404b2.recycle();
                            }
                        }
                        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 3);
                        int[] iArr = {sharedPreferences.getInt("AMS_STAMP_PREF_00", -1), sharedPreferences.getInt("AMS_STAMP_PREF_01", -1), sharedPreferences.getInt("AMS_STAMP_PREF_02", -1), sharedPreferences.getInt("AMS_STAMP_PREF_03", -1)};
                        int i5 = iArr[0];
                        int i6 = 0;
                        while (i6 < 4) {
                            int i7 = iArr[i6];
                            iArr[i6] = i5;
                            if (i7 != this.f6928Q) {
                                i6++;
                                i5 = i7;
                            } else {
                                iArr[0] = this.f6928Q;
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                                sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                                this.f6914C.m6296a(3, this.f6928Q, 0, 0);
                                m6616h(this.f6915D);
                                m6558E();
                                break;
                            }
                        }
                        iArr[0] = this.f6928Q;
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
                        sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
                        this.f6914C.m6296a(3, this.f6928Q, 0, 0);
                        m6616h(this.f6915D);
                        m6558E();
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        m6601e(false);
        switch (view.getId()) {
            case R.id.btn_tool_background_image /* 2131492945 */:
                if (!this.f6941ad && !this.f6942ae) {
                    this.f6942ae = true;
                    m6651t();
                    break;
                }
                break;
            case R.id.btn_tool_pen /* 2131492946 */:
                if (this.f6913B == null || !this.f6913B.isShowing()) {
                    m6629k();
                    break;
                }
                break;
            case R.id.btn_tool_stamp_shape /* 2131492947 */:
                if (!this.f6941ad && !this.f6942ae) {
                    this.f6941ad = true;
                    m6654u();
                    break;
                }
                break;
            case R.id.btn_tool_text /* 2131492948 */:
                if (this.f6913B == null || !this.f6913B.isShowing()) {
                    m6632l();
                    break;
                }
                break;
            case R.id.btn_preview /* 2131492950 */:
                if (!this.f6940ac) {
                    this.f6940ac = true;
                    m6657w();
                    break;
                }
                break;
            case R.id.btn_undo /* 2131492951 */:
                m6563J();
                break;
            case R.id.btn_redo /* 2131492952 */:
                m6564K();
                break;
            case R.id.btn_send /* 2131492953 */:
                m6661y();
                break;
        }
    }

    /* renamed from: b */
    private void m6585b(boolean z) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ams_ics_container_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ams_ics_container_height);
        if (!z) {
            dimensionPixelSize2 = -1;
        }
        getWindow().setLayout(dimensionPixelSize, dimensionPixelSize2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6607g() {
        f6910l = false;
        if (!this.f6932U || !this.f6914C.m6324q()) {
            m6615h();
        } else {
            m6570a(R.string.ams_app_name, R.string.ams_msg_exit_with_save, new DialogInterfaceOnClickListenerC1954e(this), new DialogInterfaceOnClickListenerC1965p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6615h() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2000);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6620i() {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2006);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6625j() {
        if (!this.f6914C.m6301a(f6610c + m6567a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m6262a(R.string.ams_error_ams_file_save);
        } else {
            m6262a(R.string.ams_msg_saved);
        }
    }

    /* renamed from: b */
    private void m6580b(int i) {
        new Thread(new RunnableC1970u(this, i)).start();
    }

    /* renamed from: k */
    private void m6629k() throws Resources.NotFoundException {
        m6630k(false);
        this.f6914C.setEditMode(false, false);
        this.f6915D = 2002;
        m6590c(this.f6915D);
        if (this.f6916E != this.f6915D) {
            this.f6914C.m6296a(1, this.f6917F, this.f6919H[this.f6917F], this.f6920I[this.f6917F]);
            this.f6916E = this.f6915D;
            m6616h(this.f6915D);
            m6559F();
            return;
        }
        this.f6916E = this.f6915D;
        m6648r();
    }

    /* renamed from: l */
    private void m6632l() throws Resources.NotFoundException {
        this.f6915D = 2003;
        m6590c(this.f6915D);
        if (this.f6916E != 2003) {
            this.f6914C.setEditMode(false, false);
            this.f6914C.m6296a(2, 0, this.f6921J, this.f6922K);
            this.f6916E = this.f6915D;
            m6616h(this.f6915D);
            m6559F();
            m6630k(true);
            return;
        }
        this.f6916E = this.f6915D;
        m6649s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m6634m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m6637n() {
        if (!this.f6955t.isEnabled() && this.f6914C.m6324q()) {
            this.f6955t.setEnabled(true);
        } else if (this.f6955t.isEnabled() && !this.f6914C.m6324q()) {
            this.f6955t.setEnabled(false);
        }
        if (!this.f6956u.isEnabled() && this.f6914C.m6325r()) {
            this.f6956u.setEnabled(true);
        } else if (this.f6956u.isEnabled() && !this.f6914C.m6325r()) {
            this.f6956u.setEnabled(false);
        }
        if (!this.f6957v.isEnabled() && this.f6914C.m6327t()) {
            this.f6957v.setEnabled(true);
            this.f6958w.setEnabled(true);
        } else if (this.f6957v.isEnabled() && !this.f6914C.m6327t()) {
            this.f6957v.setEnabled(false);
            this.f6958w.setEnabled(false);
        }
    }

    /* renamed from: c */
    private void m6590c(int i) throws Resources.NotFoundException {
        m6593d(i);
        m6616h(i);
    }

    /* renamed from: d */
    private void m6593d(int i) {
        int[] iArr = {2002, 2003, 2005, 2001};
        ImageView[] imageViewArr = {this.f6952q, this.f6953r, this.f6954s, this.f6951p};
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
    private boolean m6642o() throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ams_ics_container_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ams_ics_actionbar_height);
        this.f6938aa = (((dimensionPixelSize - dimensionPixelSize2) - getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_top_menu_height)) - getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_bottom_menu_height)) - (getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_canvas_margin) * 2);
        C1786r.m6063c("[createComposer] Composer Size = " + this.f6938aa, getClass().getSimpleName());
        this.f6939ab = this.f6938aa;
        if (this.f6914C != null) {
            this.f6914C.m6328u();
            this.f6914C = null;
        }
        this.f6914C = new AMSDrawManager(this, this.f6938aa, this.f6939ab);
        if (!this.f6914C.m6293a()) {
            m6615h();
            return false;
        }
        this.f6914C.setEnableZoom(true);
        this.f6914C.setPlayMode(false);
        this.f6914C.setOnTextInputRequestListener(this);
        this.f6914C.setOnObjectListener(this);
        this.f6914C.setOnTouchTextArea(this);
        this.f6914C.setEraserSize(this.f6920I[4]);
        if (!this.f6931T) {
            m6656v();
        }
        m6644p();
        return true;
    }

    /* renamed from: p */
    private void m6644p() {
        if (this.f6937Z != null) {
            this.f6937Z.removeAllViews();
            this.f6937Z = null;
        }
        this.f6937Z = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f6937Z.setLayoutParams(layoutParams);
        this.f6937Z.addView(this.f6914C);
    }

    /* renamed from: q */
    private void m6645q() throws Resources.NotFoundException {
        m6561H();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        relativeLayout.addView(this.f6937Z);
        this.f6951p = (ImageView) findViewById(R.id.btn_tool_background_image);
        this.f6952q = (ImageView) findViewById(R.id.btn_tool_pen);
        this.f6953r = (ImageView) findViewById(R.id.btn_tool_text);
        this.f6954s = (ImageView) findViewById(R.id.btn_tool_stamp_shape);
        this.f6955t = (ImageView) findViewById(R.id.btn_undo);
        this.f6956u = (ImageView) findViewById(R.id.btn_redo);
        this.f6957v = (ImageView) findViewById(R.id.btn_preview);
        this.f6958w = (ImageView) findViewById(R.id.btn_send);
        this.f6951p.setOnClickListener(this);
        this.f6952q.setOnClickListener(this);
        this.f6953r.setOnClickListener(this);
        this.f6954s.setOnClickListener(this);
        this.f6955t.setOnClickListener(this);
        this.f6956u.setOnClickListener(this);
        this.f6957v.setOnClickListener(this);
        this.f6958w.setOnClickListener(this);
        if (!this.f6931T) {
            m6580b(3000);
        }
        this.f6955t.setEnabled(this.f6914C.m6324q());
        this.f6956u.setEnabled(this.f6914C.m6325r());
        this.f6957v.setEnabled(this.f6914C.m6327t());
        this.f6958w.setEnabled(this.f6914C.m6327t());
        m6634m();
        m6590c(this.f6915D);
        m6580b(3001);
    }

    /* renamed from: e */
    private void m6597e(int i) throws Resources.NotFoundException {
        this.f6915D = i;
        this.f6916E = this.f6915D;
        switch (i) {
            case 2003:
                this.f6914C.m6296a(2, 0, this.f6921J, this.f6922K);
                break;
            default:
                this.f6914C.m6296a(1, this.f6917F, this.f6919H[this.f6917F], this.f6920I[this.f6917F]);
                break;
        }
        m6590c(this.f6915D);
        m6580b(3001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6569a(int i, int i2, int i3) throws Resources.NotFoundException {
        this.f6917F = i;
        this.f6920I[this.f6917F] = i2;
        this.f6919H[this.f6917F] = i3;
        this.f6914C.m6296a(1, this.f6917F, this.f6919H[this.f6917F], this.f6920I[this.f6917F]);
        m6559F();
        m6616h(this.f6915D);
        m6558E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6568a(int i, int i2) throws Resources.NotFoundException {
        this.f6922K = i;
        this.f6921J = i2;
        if (this.f6914C.m6312e() == null) {
            this.f6914C.m6296a(2, 0, this.f6921J, this.f6922K);
        } else {
            this.f6914C.m6295a(0, this.f6921J, this.f6922K);
        }
        m6559F();
        m6616h(this.f6915D);
        m6581b(this.f6921J, this.f6922K);
        m6558E();
    }

    /* renamed from: r */
    private void m6648r() {
        C1851ak c1851ak = new C1851ak(this, R.layout.ams_ics2_layout_tool_pen_popup, this.f6952q, this.f6936Y);
        c1851ak.m6429a(this.f6917F);
        c1851ak.m6431b(this.f6920I[this.f6917F]);
        c1851ak.m6433c(this.f6919H[this.f6917F]);
        c1851ak.m6441a(new C1971v(this, c1851ak));
        this.f6913B = c1851ak;
    }

    /* renamed from: s */
    private void m6649s() {
        C1862av c1862av = new C1862av(this, R.layout.ams_ics2_layout_tool_text_popup, this.f6953r, this.f6936Y);
        c1862av.m6462a(this.f6922K);
        c1862av.m6464b(this.f6921J);
        c1862av.m6441a(new C1972w(this, c1862av));
        this.f6913B = c1862av;
    }

    /* renamed from: t */
    private void m6651t() {
        m6630k(false);
        Intent intent = new Intent(this, (Class<?>) AMSBgFrameSelectionActivity.class);
        intent.putExtra("BACKGROUND_COLOR", this.f6914C.m6303b());
        intent.putExtra("BACKGROUND_INDEX", this.f6935X);
        startActivityForResult(intent, 3);
    }

    /* renamed from: u */
    private void m6654u() throws Resources.NotFoundException {
        m6630k(false);
        this.f6914C.setEditMode(false, false);
        this.f6915D = 2005;
        m6593d(this.f6915D);
        if (this.f6916E != 2005 && !this.f6929R) {
            this.f6914C.m6296a(3, this.f6928Q, 0, 0);
            this.f6916E = this.f6915D;
            m6616h(this.f6915D);
            m6559F();
            m6558E();
            this.f6941ad = false;
            return;
        }
        if (this.f6929R) {
            this.f6929R = false;
            this.f6914C.m6296a(3, this.f6928Q, 0, 0);
            this.f6916E = this.f6915D;
            m6559F();
        }
        m6558E();
        Intent intent = new Intent(this, (Class<?>) AMSStampSelectionActivity.class);
        intent.putExtra("AMS_STAMP_INDEX", this.f6928Q);
        startActivityForResult(intent, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6602f(int i) {
        f6910l = false;
        if (!this.f6932U || !this.f6914C.m6324q()) {
            m6608g(i);
        } else {
            m6570a(R.string.ams_app_name, R.string.ams_msg_exit_with_save, new DialogInterfaceOnClickListenerC1973x(this, i), new DialogInterfaceOnClickListenerC1974y(this, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6608g(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2001);
        intent.putExtra("AMS_TAB_ID", i);
        intent.putExtra("AMS_SAVE_FLAG", this.f6932U);
        startActivity(intent);
        finish();
    }

    /* renamed from: v */
    private void m6656v() {
        if (this.f6914C != null) {
            this.f6914C.m6297a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, true);
            this.f6914C.m6314g();
            m6559F();
        }
    }

    /* renamed from: a */
    private void m6571a(Bitmap bitmap) {
        this.f6914C.m6298a(bitmap, true);
        this.f6914C.setEditMode(false, true);
        m6559F();
    }

    /* renamed from: w */
    private void m6657w() {
        if (!m6596d(false)) {
            this.f6940ac = false;
            return;
        }
        f6910l = false;
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2004);
        intent.putExtra("AMS_FILE_PATH", f6614g);
        intent.putExtra("AMS_SAVE_FLAG", this.f6932U);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m6659x() throws Resources.NotFoundException {
        if (this.f6914C != null) {
            this.f6932U = false;
            m6642o();
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            relativeLayout.addView(this.f6937Z);
            m6597e(2002);
            m6637n();
        }
    }

    /* renamed from: y */
    private void m6661y() {
        if (this.f6914C != null) {
            if (!this.f6914C.m6327t()) {
                m6262a(R.string.ams_msg_empty_ams);
                return;
            }
            DialogC1841aa dialogC1841aa = new DialogC1841aa(this);
            dialogC1841aa.m6393a(0, R.string.ams_send_as_animation, true);
            dialogC1841aa.m6393a(1, R.string.ams_send_as_image, true);
            dialogC1841aa.m6393a(2, R.string.ams_save_and_exit, false);
            dialogC1841aa.m6392a(new C1975z(this));
            dialogC1841aa.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m6589c(boolean z) {
        String str = f6610c + m6567a("A", System.currentTimeMillis(), ".jpg");
        if (!this.f6914C.m6301a(str)) {
            m6262a(R.string.ams_error_ams_file_save);
            this.f6934W = false;
            return null;
        }
        this.f6934W = true;
        File file = new File(str);
        if (file.length() < 1048576 || !z) {
            return str;
        }
        file.delete();
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_btn_send).setMessage(String.format("%s\n(%d/%d)", getResources().getString(R.string.ams_msg_exceed_limit), Long.valueOf(file.length()), 1048576)).setPositiveButton(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC1955f(this)).create().show();
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
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m6663z() throws java.lang.Throwable {
        /*
            r7 = this;
            r1 = 0
            r6 = 480(0x1e0, float:6.73E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.sec.vip.amschaton.honeycomb.AMSComposerActivity.f6616i
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "I"
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = ".jpg"
            java.lang.String r2 = r7.m6567a(r2, r3, r5)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f6914C
            boolean r2 = r2.m6314g()
            if (r2 == 0) goto L61
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f6914C
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.AMSComposerActivity.m6663z():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6578a(String str, int i) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_SEND_METHOD", i);
        startActivity(intent);
        finish();
    }

    /* renamed from: d */
    private boolean m6596d(boolean z) {
        if (this.f6914C == null) {
            C1786r.m6054a("[startAMSPreview] mAMSComposer is NULL!", getClass().getSimpleName());
            return false;
        }
        if (!z && !this.f6914C.m6327t()) {
            C1786r.m6054a("[startAMSPreview] Empty AMS file!", getClass().getSimpleName());
            return false;
        }
        File file = new File(f6614g);
        if (file.exists()) {
            file.delete();
        }
        if (!this.f6914C.m6301a(f6614g)) {
            C1786r.m6054a("[startAMSPreview] Fail to save AMS file!", getClass().getSimpleName());
            return false;
        }
        this.f6914C.setEditMode(false, false);
        return true;
    }

    /* renamed from: A */
    private Context m6552A() {
        return this;
    }

    /* renamed from: a */
    private Drawable m6566a(int i, int i2, int i3, int i4) throws Resources.NotFoundException {
        Drawable drawable;
        Drawable drawable2;
        if (i != 1) {
            return null;
        }
        if (this.f6959x != null) {
            this.f6959x.recycle();
            this.f6959x = null;
        }
        if (this.f6960y != null) {
            this.f6960y.recycle();
            this.f6960y = null;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ams_ics2_pen_button_preview_icon_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ams_ics2_pen_button_preview_icon_height);
        Rect rect = new Rect(0, 0, dimensionPixelSize, dimensionPixelSize2);
        this.f6959x = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        this.f6960y = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f6959x);
        Canvas canvas2 = new Canvas(this.f6960y);
        switch (i2) {
            case 1:
                drawable = m6552A().getResources().getDrawable(R.drawable.button_pen02_normal);
                drawable2 = m6552A().getResources().getDrawable(R.drawable.button_pen02_select);
                break;
            case 2:
                drawable = m6552A().getResources().getDrawable(R.drawable.button_pen04_normal);
                drawable2 = m6552A().getResources().getDrawable(R.drawable.button_pen04_select);
                break;
            case 3:
                drawable = m6552A().getResources().getDrawable(R.drawable.button_pen03_normal);
                drawable2 = m6552A().getResources().getDrawable(R.drawable.button_pen03_select);
                break;
            default:
                drawable = m6552A().getResources().getDrawable(R.drawable.button_pen01_normal);
                drawable2 = m6552A().getResources().getDrawable(R.drawable.button_pen01_select);
                break;
        }
        canvas.drawColor(i3);
        canvas2.drawColor(i3);
        drawable.setBounds(rect);
        drawable.draw(canvas);
        drawable2.setBounds(rect);
        drawable2.draw(canvas2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f6959x);
        bitmapDrawable.setTargetDensity(this.f6959x.getDensity());
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.f6960y);
        bitmapDrawable2.setTargetDensity(this.f6960y.getDensity());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919, -16842913}, bitmapDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, bitmapDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, bitmapDrawable2);
        return stateListDrawable;
    }

    /* renamed from: B */
    private Bitmap m6554B() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (this.f6950o * 80.0f), (int) (this.f6950o * 80.0f), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawARGB(0, 0, 0, 0);
        C2074x c2074x = new C2074x(2, this.f6921J, this.f6922K, false, this.f6938aa, this.f6939ab);
        c2074x.mo7194a(this.f6950o * 2.0f);
        c2074x.m7254b("Aa");
        int iM7255j = c2074x.m7255j();
        int iM7256k = c2074x.m7256k();
        c2074x.m7199a(bitmapCreateBitmap);
        c2074x.mo7217a((r7 - iM7255j) * 0.5f, (r8 - iM7256k) * 0.5f, "Aa", MotionEventCompat.ACTION_MASK);
        c2074x.mo7229c();
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private Bitmap m6565a(Intent intent, Bundle bundle) {
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
    private String m6567a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m6572a(EditText editText, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(editText, 2);
        } else {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6601e(boolean z) {
        if (this.f6926O != null && this.f6927P != null) {
            m6572a(this.f6943af, z);
            this.f6924M = z;
            if (z) {
                this.f6926O.setVisibility(0);
                m6562I();
                m6606f(this.f6923L);
            } else {
                this.f6926O.setVisibility(8);
                m6561H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6606f(boolean z) {
        if (this.f6949n != null && this.f6924M) {
            this.f6949n.m6248a(5000, z);
        }
    }

    /* renamed from: C */
    private void m6556C() {
        if (this.f6926O != null) {
            this.f6926O = null;
        }
        this.f6926O = (RelativeLayout) findViewById(R.id.layout_text_input);
        this.f6926O.setOnClickListener(new ViewOnClickListenerC1957h(this));
        this.f6943af = (AMSEditText) findViewById(R.id.edit_text_input);
    }

    /* renamed from: b */
    private void m6584b(String str) {
        if (this.f6927P != null) {
            this.f6927P = null;
        }
        this.f6927P = new ViewOnClickListenerC1875bh(this, this.f6943af, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
        if (str != null) {
            this.f6927P.m6494a(str);
        }
        this.f6927P.m6493a(this.f6946ai);
        this.f6925N = new C1958i(this);
        this.f6927P.m6492a(this.f6925N);
    }

    @Override // com.sec.vip.amschaton.InterfaceC2075y
    /* renamed from: a */
    public boolean mo6667a(String str) {
        m6584b(str);
        m6601e(true);
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC2061k
    /* renamed from: a */
    public boolean mo6666a(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
            case 4:
                this.f6932U = true;
                m6634m();
                m6637n();
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m6557D() throws Resources.NotFoundException {
        if (!this.f6932U || !this.f6914C.m6324q()) {
            m6659x();
        } else {
            m6570a(R.string.ams_title_create_new, R.string.ams_msg_exit_with_save, new DialogInterfaceOnClickListenerC1959j(this), new DialogInterfaceOnClickListenerC1960k(this));
        }
    }

    /* renamed from: a */
    private void m6570a(int i, int i2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        TextView textView = new TextView(this);
        textView.setText(i2);
        textView.setTextSize(18.0f);
        textView.setTextColor(-16777216);
        textView.setPadding(0, 30, 8, 30);
        textView.setGravity(17);
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this);
        if (i > 0) {
            alertDialogBuilderC2120a.setTitle(i);
        }
        alertDialogBuilderC2120a.setView(textView);
        alertDialogBuilderC2120a.setNegativeButton(R.string.ams_btn_save, onClickListener);
        alertDialogBuilderC2120a.setPositiveButton(R.string.ams_btn_do_not_save, onClickListener2);
        alertDialogBuilderC2120a.create().show();
    }

    /* renamed from: g */
    private void m6612g(boolean z) {
        if (z) {
            this.f6915D = 2002;
            this.f6917F = 0;
            this.f6918G = this.f6917F;
            this.f6919H[0] = -16777216;
            this.f6919H[1] = -16777216;
            this.f6919H[3] = -16777216;
            this.f6919H[2] = -16777216;
            this.f6920I[0] = 5;
            this.f6920I[1] = 5;
            this.f6920I[3] = 5;
            this.f6920I[2] = 5;
            this.f6920I[4] = 5;
            this.f6922K = 2;
            this.f6921J = -16777216;
            this.f6928Q = 0;
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 1);
        this.f6915D = sharedPreferences.getInt("AMS_TOOL_TYPE", 2000);
        this.f6917F = sharedPreferences.getInt("AMS_PEN_STYLE", 0);
        this.f6918G = this.f6917F;
        this.f6919H[0] = sharedPreferences.getInt("AMS_PEN_LINE_COLOR", -16777216);
        this.f6919H[1] = sharedPreferences.getInt("AMS_PEN_BLUR_COLOR", -16777216);
        this.f6919H[2] = sharedPreferences.getInt("AMS_CPEN_MARKER_COLOR", -16777216);
        this.f6919H[3] = sharedPreferences.getInt("AMS_PEN_DOT_COLOR", -16777216);
        this.f6920I[0] = sharedPreferences.getInt("AMS_PEN_LINE", 3);
        this.f6920I[1] = sharedPreferences.getInt("AMS_PEN_BLUR_SIZE", 3);
        this.f6920I[2] = sharedPreferences.getInt("AMS_PEN_MARKER_SIZE", 3);
        this.f6920I[3] = sharedPreferences.getInt("AMS_PEN_DOT_SIZE", 3);
        this.f6920I[4] = sharedPreferences.getInt("AMS_PEN_ERASER_SIZE", 5);
        this.f6922K = sharedPreferences.getInt("AMS_TEXT_SIZE", 2);
        this.f6921J = sharedPreferences.getInt("AMS_TEXT_COLOR", -16777216);
        this.f6928Q = sharedPreferences.getInt("AMS_STAMP_STYLE", 0);
    }

    /* renamed from: E */
    private void m6558E() {
        SharedPreferences sharedPreferences = getSharedPreferences("AMSPref", 3);
        sharedPreferences.edit().putInt("AMS_TOOL_TYPE", this.f6915D).commit();
        sharedPreferences.edit().putInt("AMS_PEN_STYLE", this.f6917F).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE_COLOR", this.f6919H[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_COLOR", this.f6919H[1]).commit();
        sharedPreferences.edit().putInt("AMS_CPEN_MARKER_COLOR", this.f6919H[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_COLOR", this.f6919H[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE", this.f6920I[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_SIZE", this.f6920I[1]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_MARKER_SIZE", this.f6920I[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_SIZE", this.f6920I[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_ERASER_SIZE", this.f6920I[4]).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_SIZE", this.f6922K).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_COLOR", this.f6921J).commit();
        sharedPreferences.edit().putInt("AMS_STAMP_STYLE", this.f6928Q).commit();
    }

    /* renamed from: h */
    private void m6617h(boolean z) throws Resources.NotFoundException {
        if (z) {
            this.f6952q.setScaleType(ImageView.ScaleType.CENTER);
            this.f6952q.setImageResource(R.drawable.ams_ics2_selector_button_top_pen);
            return;
        }
        Drawable drawableM6566a = m6566a(1, this.f6917F, this.f6919H[this.f6917F], this.f6920I[this.f6917F]);
        if (drawableM6566a == null) {
            this.f6952q.setScaleType(ImageView.ScaleType.CENTER);
            this.f6952q.setImageResource(R.drawable.ams_ics2_selector_button_top_pen);
        } else {
            this.f6952q.setScaleType(ImageView.ScaleType.CENTER);
            this.f6952q.setImageDrawable(drawableM6566a);
        }
        m6559F();
    }

    /* renamed from: i */
    private void m6621i(boolean z) {
        if (this.f6961z != null) {
            this.f6961z.recycle();
            this.f6961z = null;
        }
        if (z) {
            this.f6953r.setScaleType(ImageView.ScaleType.CENTER);
            this.f6953r.setImageResource(R.drawable.ams_ics2_selector_button_top_text);
            return;
        }
        this.f6961z = m6554B();
        if (this.f6961z == null) {
            this.f6953r.setScaleType(ImageView.ScaleType.CENTER);
            this.f6953r.setImageResource(R.drawable.ams_ics2_selector_button_top_text);
        } else {
            this.f6953r.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f6953r.setImageBitmap(this.f6961z);
        }
        m6559F();
    }

    /* renamed from: j */
    private void m6626j(boolean z) throws Resources.NotFoundException {
        int dimensionPixelOffset = m6552A().getResources().getDimensionPixelOffset(R.dimen.ams_stamp_button_padding);
        this.f6954s.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        if (this.f6912A != null) {
            this.f6912A.recycle();
            this.f6912A = null;
        }
        if (z) {
            this.f6954s.setPadding(0, 0, 0, 0);
            this.f6954s.setScaleType(ImageView.ScaleType.CENTER);
            this.f6954s.setImageResource(R.drawable.ams_ics2_selector_button_top_stamp);
            return;
        }
        if (this.f6928Q < C1849ai.m6394a().m6410f()) {
            this.f6912A = C1849ai.m6394a().m6397a(this.f6928Q, false);
        } else {
            this.f6912A = C1849ai.m6394a().m6404b(this.f6928Q - 1000, false);
        }
        if (this.f6912A == null) {
            this.f6954s.setPadding(0, 0, 0, 0);
            this.f6954s.setScaleType(ImageView.ScaleType.CENTER);
            this.f6954s.setImageResource(R.drawable.ams_ics2_selector_button_top_stamp);
        } else {
            this.f6954s.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f6954s.setImageBitmap(this.f6912A);
        }
        m6559F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6616h(int i) throws Resources.NotFoundException {
        m6617h(false);
        switch (i) {
            case 2003:
                m6621i(true);
                break;
            case 2005:
                m6626j(false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m6559F() {
        if (this.f6914C != null) {
            this.f6914C.m6329v();
        }
    }

    /* renamed from: b */
    private void m6581b(int i, int i2) {
        if (this.f6914C != null && this.f6914C.m6290A()) {
            this.f6914C.m6291a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m6630k(boolean z) {
        if (this.f6914C != null) {
            if (this.f6914C.m6290A()) {
                this.f6914C.m6332y();
            }
            if (z) {
                this.f6914C.m6331x();
            }
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC2063m
    /* renamed from: a */
    public void mo6665a(boolean z) {
    }

    /* renamed from: G */
    private void m6560G() {
        this.f6949n = (AMSActionBarView) findViewById(R.id.actionbar);
    }

    /* renamed from: H */
    private void m6561H() {
        m6560G();
        this.f6949n.setTitleText(R.string.ams_app_name);
        this.f6949n.setHomeClickListener(this.f6947aj);
        this.f6949n.setMoreOptionMenuPopup();
        this.f6949n.m6247a(R.string.ams_optmenu_create_new, R.drawable.ams_create_new, (View.OnClickListener) new ViewOnClickListenerC1962m(this), true);
        this.f6949n.m6247a(R.string.ams_title_my_works, R.drawable.ams_myworks, (View.OnClickListener) new ViewOnClickListenerC1963n(this), true);
        this.f6949n.m6247a(R.string.ams_title_samples, R.drawable.ams_sample, (View.OnClickListener) new ViewOnClickListenerC1964o(this), false);
        this.f6949n.setMoreOptionIconVisibility(true);
        this.f6949n.setActionButtonLayoutVisibility(false);
    }

    /* renamed from: I */
    private void m6562I() {
        m6560G();
        this.f6949n.setTitleText(R.string.ams_title_text);
        this.f6949n.setHomeClickListener(this.f6947aj);
        this.f6949n.m6244a();
        this.f6949n.m6246a(R.drawable.ams_ics_selector_title_ic_cancel, R.string.ams_btn_cancel, new ViewOnClickListenerC1966q(this), 5001);
        this.f6949n.m6246a(R.drawable.ams_ics_selector_title_ic_check, R.string.ams_btn_done, new ViewOnClickListenerC1967r(this), 5000);
        this.f6949n.setMoreOptionIconVisibility(false);
        this.f6949n.setActionButtonLayoutVisibility(true);
    }

    /* renamed from: J */
    private void m6563J() {
        if (!this.f6944ag) {
            new AsyncTaskC1893aa(this, null).execute(Boolean.TRUE);
        }
    }

    /* renamed from: K */
    private void m6564K() {
        if (!this.f6944ag) {
            new AsyncTaskC1893aa(this, null).execute(Boolean.FALSE);
        }
    }
}
