package com.sec.vip.amschaton.ics;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.AMSViewerActivity;
import com.sec.vip.amschaton.DialogC1873bf;
import com.sec.vip.amschaton.InterfaceC1882bo;
import com.sec.vip.amschaton.RunnableC1880bm;
import com.sec.widget.GeneralHeaderView;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity {

    /* renamed from: u */
    private ImageView f7218u;

    /* renamed from: v */
    private ImageView f7219v;

    /* renamed from: p */
    private String f7213p = null;

    /* renamed from: q */
    private int f7214q = 1000;

    /* renamed from: r */
    private int f7215r = 2000;

    /* renamed from: s */
    private boolean f7216s = false;

    /* renamed from: t */
    private SeekBar f7217t = null;

    /* renamed from: w */
    private RelativeLayout f7220w = null;

    /* renamed from: x */
    private LinearLayout f7221x = null;

    /* renamed from: y */
    private boolean f7222y = true;

    /* renamed from: z */
    private boolean f7223z = false;

    /* renamed from: A */
    private boolean f7203A = true;

    /* renamed from: B */
    private Handler f7204B = new Handler();

    /* renamed from: C */
    private boolean f7205C = false;

    /* renamed from: D */
    private GeneralHeaderView f7206D = null;

    /* renamed from: E */
    private boolean f7207E = true;

    /* renamed from: F */
    private boolean f7208F = false;

    /* renamed from: G */
    private View.OnClickListener f7209G = new ViewOnClickListenerC2017bm(this);

    /* renamed from: H */
    private InterfaceC1882bo f7210H = new C2018bn(this);

    /* renamed from: I */
    private Handler f7211I = new HandlerC2019bo(this);

    /* renamed from: J */
    private Runnable f7212J = new RunnableC2007bc(this);

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7213p = extras.getString("AMS_FILE_PATH");
            this.f7214q = extras.getInt("VIEWER_MODE", 1002);
            this.f7215r = extras.getInt("AMS_FILE_TYPE", 2001);
            if (this.f7214q == 1000) {
                this.f7203A = extras.getBoolean("AMS_DIRECT_PLAY", true);
            }
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f7213p = "";
        }
        if (this.f7213p.length() < 1) {
            m6262a(R.string.ams_msg_invalid_ams_file);
            m7068i();
            return;
        }
        if (this.f7214q == 1002 && (!m6266e() || !m6267f())) {
            C1786r.m6054a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            m6262a(R.string.ams_sdcard_unmounted_msg);
            m7068i();
            return;
        }
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f7222y = true;
        } else if (configuration.orientation == 2) {
            this.f7222y = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        mo6360a(this.f7222y);
        m7076m();
        m7079n();
        m7044b(this.f7214q);
        m7090t();
        new Thread(new RunnableC1997at(this)).start();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f7222y = true;
        } else if (configuration.orientation == 2) {
            this.f7222y = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        m6361g();
        m7076m();
        m7044b(this.f7214q);
        m7085q();
        this.f7211I.sendEmptyMessage(1001);
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity, android.app.Activity
    protected void onDestroy() {
        this.f7205C = false;
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() throws IllegalStateException, Resources.NotFoundException {
        C1786r.m6063c("[onPause]", getClass().getName());
        m7053d(false);
        if (!this.f7222y) {
            m7057f(true);
        }
        m7083p();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onBackPressed() throws IllegalStateException {
        m7068i();
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
    /* renamed from: h */
    public Context m7063h() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7068i() throws IllegalStateException {
        if ((this.f6688l.m6514g() & 1) == 1) {
            m7083p();
        }
        if (this.f7214q == 1001) {
            new Thread(new RunnableC2009be(this)).start();
            return;
        }
        if (this.f7214q == 1000) {
            Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("ACTION", 2000);
            intent.putExtra("AMS_FILE_TYPE", this.f7215r);
            startActivity(intent);
            finish();
            return;
        }
        if (this.f7214q == 1002) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7071j() throws Throwable {
        if (this.f7214q == 1002) {
            m7072k();
            return;
        }
        if (!this.f7205C) {
            this.f7205C = true;
            m7087r();
        }
        m7085q();
    }

    /* renamed from: k */
    private void m7072k() throws Throwable {
        String str = f6610c + this.f7213p.substring(this.f7213p.lastIndexOf(47) + 1);
        C1786r.m6061b("targetPath     : " + str, getClass().getSimpleName());
        C1786r.m6061b("mTargetFilePath: " + this.f7213p, getClass().getSimpleName());
        if (("/" + str).equals(this.f7213p)) {
            m7075l();
        } else {
            m7042a(this.f7213p, str);
        }
    }

    /* renamed from: a */
    private void m7035a(DialogC1873bf dialogC1873bf) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(dialogC1873bf.m6480b(), 2);
        dialogC1873bf.m6480b().setOnFocusChangeListener(new ViewOnFocusChangeListenerC2013bi(this, dialogC1873bf));
    }

    /* renamed from: l */
    private boolean m7075l() {
        DialogC1873bf dialogC1873bf = new DialogC1873bf(this, R.style.AMSCustomDialogTheme, 64);
        dialogC1873bf.m6479a(m7034a("A", System.currentTimeMillis(), ""));
        dialogC1873bf.m6481b("\\/:*?\"<>|");
        dialogC1873bf.m6478a(new C2014bj(this, dialogC1873bf));
        dialogC1873bf.show();
        m7035a(dialogC1873bf);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m7042a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSPlayerActivity.m7042a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: m */
    private void m7076m() throws Resources.NotFoundException {
        m7089s();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f6690n, this.f6690n);
        C1786r.m6065d("## mViewerSize = " + this.f6690n, getClass().getName());
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f6689m);
        this.f7218u = new ImageView(this);
        this.f7218u.setBackgroundResource(R.drawable.ams_ics_selector_btn_play_bg);
        this.f7218u.setImageResource(R.drawable.ams_ics_selector_btn_play);
        this.f7218u.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ams_ics_play_button_width), getResources().getDimensionPixelSize(R.dimen.ams_ics_play_button_width));
        layoutParams2.addRule(13);
        this.f7218u.setLayoutParams(layoutParams2);
        this.f7218u.setOnClickListener(this.f7209G);
        this.f7219v = (ImageView) findViewById(R.id.btn_play_pause);
        this.f7219v.setOnClickListener(this.f7209G);
        this.f7220w = new RelativeLayout(this);
        this.f7220w.setLayoutParams(new RelativeLayout.LayoutParams(this.f6690n, this.f6690n));
        this.f7220w.addView(this.f7218u);
        m7055e(false);
        relativeLayout.addView(this.f7220w);
        this.f7221x = (LinearLayout) findViewById(R.id.layout_status);
        if (!this.f7222y) {
            m7061g(false);
        }
        this.f7217t = (SeekBar) findViewById(R.id.progressbar);
        this.f7217t.setOnTouchListener(new ViewOnTouchListenerC2015bk(this));
        this.f7217t.setMax(RunnableC1880bm.f6869a);
        this.f7217t.setProgress(0);
        m7050c(true);
    }

    /* renamed from: n */
    private void m7079n() {
        this.f6688l.m6504a(this.f7210H);
        this.f6688l.m6503a(new C2016bl(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7047b(boolean z) {
        this.f6689m.setOnClickListener(z ? this.f7209G : null);
    }

    /* renamed from: c */
    private void m7050c(boolean z) {
        this.f7217t.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7039a(String str) throws IllegalStateException, Resources.NotFoundException {
        this.f7216s = this.f6688l.m6507a(str, false);
        if (this.f7216s) {
            ((AMSDrawManager) this.f6688l.m6515h()).setBitmapForAMS(null);
            m7047b(true);
            this.f7217t.setMax(RunnableC1880bm.f6869a);
            this.f7217t.setProgress(0);
            if (this.f7203A) {
                m7081o();
                m7055e(false);
                if (!this.f7222y) {
                    m7061g(false);
                    return;
                }
                return;
            }
            this.f6688l.m6505a(true);
            m7085q();
            m7053d(false);
            if (!this.f7222y && !this.f7223z) {
                m7057f(true);
                return;
            }
            return;
        }
        m7047b(false);
        ((AMSDrawManager) this.f6688l.m6515h()).setBitmapForAMS(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m7081o() throws IllegalStateException {
        boolean zM6310c = new AMSDrawManager(this).m6310c(this.f7213p);
        if (this.f7207E && !zM6310c) {
            this.f7208F = false;
            Dialog dialog = new Dialog(this, R.style.AMSIcsDialogTheme);
            dialog.getWindow().requestFeature(1);
            dialog.setContentView(R.layout.ams_ics_layout_attention_dialog);
            CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkbox_never_show_again);
            checkBox.setOnClickListener(new ViewOnClickListenerC1998au(this));
            checkBox.setOnCheckedChangeListener(new C1999av(this));
            dialog.findViewById(R.id.text_never_show_again).setOnClickListener(new ViewOnClickListenerC2000aw(this));
            dialog.findViewById(R.id.text_never_show_again).setOnTouchListener(new ViewOnTouchListenerC2001ax(this, checkBox));
            ((Button) dialog.findViewById(R.id.btn_ok)).setOnClickListener(new ViewOnClickListenerC2002ay(this, dialog));
            dialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC2003az(this));
            dialog.show();
            return;
        }
        this.f6688l.m6508b();
        m7085q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m7083p() throws IllegalStateException {
        this.f6688l.m6510c();
        m7085q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m7085q() {
        if ((this.f6688l.m6514g() & 1) == 1) {
            m7064h(false);
            this.f7219v.setImageResource(R.drawable.ams_ics_selector_player_pause);
        } else {
            m7064h(true);
            this.f7219v.setImageResource(R.drawable.ams_ics_selector_player_play);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7053d(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f7220w.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC2005ba(this));
            return;
        }
        this.f7220w.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7055e(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f7220w.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC2006bb(this));
            return;
        }
        this.f7220w.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7057f(boolean z) throws Resources.NotFoundException {
        if (z) {
            this.f7204B.removeCallbacks(this.f7212J);
            this.f7204B.postDelayed(this.f7212J, 2500L);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f7206D.startAnimation(animationLoadAnimation);
            this.f7221x.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC2008bd(this));
            return;
        }
        this.f7206D.setVisibility(0);
        this.f7221x.setVisibility(0);
        this.f7223z = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m7061g(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f7206D.startAnimation(animationLoadAnimation);
            this.f7221x.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC2010bf(this));
            return;
        }
        this.f7206D.setVisibility(8);
        this.f7221x.setVisibility(8);
        this.f7223z = false;
    }

    /* renamed from: h */
    private void m7064h(boolean z) {
        if (this.f7206D != null) {
            this.f7206D.setButtonEnabled(z);
        }
    }

    /* renamed from: b */
    private void m7044b(int i) {
        switch (i) {
            case 1002:
                m7069i(false);
                break;
            default:
                m7069i(true);
                break;
        }
    }

    /* renamed from: r */
    private void m7087r() throws IllegalStateException {
        String str;
        this.f6688l.m6505a(true);
        if (this.f7213p == null) {
            this.f7205C = false;
            return;
        }
        if (this.f7214q == 1000) {
            str = this.f7213p;
        } else if (this.f7214q == 1001) {
            AMSDrawManager aMSDrawManager = (AMSDrawManager) this.f6688l.m6515h();
            String str2 = f6610c + m7034a("A", System.currentTimeMillis(), ".jpg");
            if (!aMSDrawManager.m6301a(str2)) {
                this.f7205C = false;
                m6262a(R.string.ams_error_ams_file_save);
                return;
            } else {
                AMSComposerActivity.f7138l = false;
                str = str2;
            }
        } else {
            this.f7205C = false;
            C1786r.m6061b("Not support sending file!", getClass().getSimpleName());
            return;
        }
        if (str == null) {
            this.f7205C = false;
            return;
        }
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        startActivity(intent);
        finish();
    }

    /* renamed from: a */
    private String m7034a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: s */
    private void m7089s() {
        this.f7206D = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f7206D.setText(R.string.ams_app_name);
        this.f7206D.setButtonImageResource(R.drawable.general_btn_icon_send_xml);
        this.f7206D.setBackClickListener(new ViewOnClickListenerC2011bg(this));
        this.f7206D.setButtonClickListener(new ViewOnClickListenerC2012bh(this));
    }

    /* renamed from: i */
    private void m7069i(boolean z) {
        if (this.f7206D != null) {
            if (z) {
                this.f7206D.setButtonImageResource(R.drawable.general_btn_icon_send_xml);
            } else {
                this.f7206D.setButtonImageResource(R.drawable.general_btn_icon_save_xml);
            }
        }
    }

    /* renamed from: t */
    private void m7090t() {
        this.f7207E = getSharedPreferences("AMSPref", 1).getBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m7092u() {
        getSharedPreferences("AMSPref", 3).edit().putBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", this.f7207E).commit();
    }
}
