package com.sec.vip.amschaton.honeycomb;

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
import com.sec.vip.amschaton.AMSActionBarView;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.AMSViewerActivity;
import com.sec.vip.amschaton.DialogC1873bf;
import com.sec.vip.amschaton.InterfaceC1882bo;
import com.sec.vip.amschaton.RunnableC1880bm;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity implements View.OnClickListener {

    /* renamed from: u */
    private ImageView f6989u;

    /* renamed from: v */
    private ImageView f6990v;

    /* renamed from: q */
    private String f6985q = null;

    /* renamed from: r */
    private int f6986r = 1000;

    /* renamed from: s */
    private int f6987s = 2000;

    /* renamed from: t */
    private SeekBar f6988t = null;

    /* renamed from: w */
    private RelativeLayout f6991w = null;

    /* renamed from: x */
    private LinearLayout f6992x = null;

    /* renamed from: y */
    private boolean f6993y = true;

    /* renamed from: z */
    private boolean f6994z = true;

    /* renamed from: A */
    private boolean f6973A = false;

    /* renamed from: B */
    private boolean f6974B = true;

    /* renamed from: C */
    private Handler f6975C = new Handler();

    /* renamed from: D */
    private boolean f6976D = false;

    /* renamed from: E */
    private boolean f6977E = true;

    /* renamed from: F */
    private boolean f6978F = false;

    /* renamed from: G */
    private boolean f6979G = true;

    /* renamed from: p */
    AMSActionBarView f6984p = null;

    /* renamed from: H */
    private View.OnClickListener f6980H = new ViewOnClickListenerC1931bl(this);

    /* renamed from: I */
    private InterfaceC1882bo f6981I = new C1932bm(this);

    /* renamed from: J */
    private Runnable f6982J = new RunnableC1921bb(this);

    /* renamed from: K */
    private View.OnClickListener f6983K = new ViewOnClickListenerC1925bf(this);

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6985q = extras.getString("AMS_FILE_PATH");
            this.f6986r = extras.getInt("VIEWER_MODE", 1002);
            this.f6987s = extras.getInt("AMS_FILE_TYPE", 2001);
            if (this.f6986r == 1000) {
                this.f6974B = extras.getBoolean("AMS_DIRECT_PLAY", true);
            }
            this.f6979G = extras.getBoolean("AMS_SAVE_FLAG", true);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f6985q = "";
        }
        if (this.f6985q.length() < 1) {
            m6262a(R.string.ams_msg_invalid_ams_file);
            m6744i();
            return;
        }
        if (this.f6986r == 1002 && (!m6266e() || !m6267f())) {
            C1786r.m6054a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            m6262a(R.string.ams_sdcard_unmounted_msg);
            m6744i();
            return;
        }
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f6994z = true;
        } else if (configuration.orientation == 2) {
            this.f6994z = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        if (mo6360a(this.f6994z)) {
            m6753m();
            m6756n();
            m6720b(this.f6986r);
            m6770u();
            m6715a(this.f6985q);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalStateException, Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f6994z = true;
        } else if (configuration.orientation == 2) {
            this.f6994z = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        if (!m6361g()) {
            m6262a(R.string.trunk_toast_loading_failed);
            m6744i();
            return;
        }
        m6753m();
        m6720b(this.f6986r);
        m6765s();
        if (!this.f6691o) {
            m6760p();
        }
        m6758o();
        if ((this.f6688l.m6514g() & 1) != 1) {
            m6732e(false);
        }
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity, android.app.Activity
    protected void onDestroy() {
        this.f6976D = false;
        super.onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
        m6765s();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() throws IllegalStateException, Resources.NotFoundException {
        C1786r.m6063c("[onPause]", getClass().getName());
        m6737g(false);
        if (!this.f6993y) {
            m6745i(true);
        }
        m6763r();
        super.onPause();
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onBackPressed() throws IllegalStateException {
        m6744i();
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

    /* renamed from: b */
    private void m6723b(boolean z) {
        if (this.f6984p != null) {
            if (z) {
                this.f6984p.m6250b(5000, R.string.ams_btn_send);
            } else {
                this.f6984p.m6250b(5000, R.string.ams_btn_save);
            }
        }
    }

    /* renamed from: c */
    private void m6725c(boolean z) {
        if (this.f6984p != null) {
            this.f6984p.m6248a(5000, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public Context m6739h() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6744i() throws IllegalStateException {
        if (this.f6688l != null && (this.f6688l.m6514g() & 1) == 1) {
            m6763r();
        }
        if (this.f6986r == 1001) {
            new Thread(new RunnableC1913au(this)).start();
            return;
        }
        if (this.f6986r == 1000) {
            Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("ACTION", 2000);
            intent.putExtra("AMS_FILE_TYPE", this.f6987s);
            startActivity(intent);
            finish();
            return;
        }
        if (this.f6986r == 1002) {
            finish();
        }
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity
    /* renamed from: a */
    protected boolean mo6360a(boolean z) throws IllegalStateException {
        if (super.mo6360a(z)) {
            return true;
        }
        m6744i();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6747j() throws Throwable {
        if (this.f6986r == 1002) {
            m6749k();
            return;
        }
        if (!this.f6976D) {
            this.f6976D = true;
            if ((this.f6688l.m6514g() & 1) == 1) {
                m6732e(false);
                m6737g(false);
                m6763r();
            }
            m6768t();
        }
        m6765s();
    }

    /* renamed from: k */
    private void m6749k() throws Throwable {
        String str = f6610c + this.f6985q.substring(this.f6985q.lastIndexOf(47) + 1);
        C1786r.m6061b("targetPath     : " + str, getClass().getSimpleName());
        C1786r.m6061b("mTargetFilePath: " + this.f6985q, getClass().getSimpleName());
        if (("/" + str).equals(this.f6985q)) {
            m6752l();
        } else {
            m6718a(this.f6985q, str);
        }
    }

    /* renamed from: a */
    private void m6712a(DialogC1873bf dialogC1873bf) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(dialogC1873bf.m6480b(), 2);
        dialogC1873bf.m6480b().setOnFocusChangeListener(new ViewOnFocusChangeListenerC1924be(this, dialogC1873bf));
    }

    /* renamed from: l */
    private boolean m6752l() {
        DialogC1873bf dialogC1873bf = new DialogC1873bf(this, R.style.AMSCustomDialogTheme, 64);
        dialogC1873bf.m6479a(m6711a("A", System.currentTimeMillis(), ""));
        dialogC1873bf.m6481b("\\/:*?\"<>|");
        dialogC1873bf.m6478a(new C1928bi(this, dialogC1873bf));
        dialogC1873bf.show();
        m6712a(dialogC1873bf);
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
    public boolean m6718a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.AMSPlayerActivity.m6718a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: m */
    private void m6753m() throws Resources.NotFoundException {
        m6776x();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f6690n, this.f6690n);
        C1786r.m6065d("## mViewerSize = " + this.f6690n, getClass().getName());
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f6689m);
        this.f6989u = new ImageView(this);
        this.f6989u.setImageResource(R.drawable.ams_ics2_selector_player_overlay_btn_play);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f6989u.setLayoutParams(layoutParams2);
        this.f6989u.setOnClickListener(this.f6980H);
        this.f6990v = (ImageView) findViewById(R.id.btn_play_pause);
        this.f6990v.setOnClickListener(this.f6980H);
        this.f6991w = new RelativeLayout(this);
        this.f6991w.setLayoutParams(new RelativeLayout.LayoutParams(this.f6690n, this.f6690n));
        this.f6991w.addView(this.f6989u);
        m6741h(false);
        relativeLayout.addView(this.f6991w);
        this.f6992x = (LinearLayout) findViewById(R.id.layout_status);
        if (!this.f6993y) {
            m6748j(false);
        }
        this.f6988t = (SeekBar) findViewById(R.id.progressbar);
        this.f6988t.setOnTouchListener(new ViewOnTouchListenerC1929bj(this));
        this.f6988t.setMax(RunnableC1880bm.f6869a);
        this.f6988t.setProgress(0);
        m6733f(true);
    }

    /* renamed from: n */
    private void m6756n() {
        if (this.f6688l == null) {
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
        } else {
            this.f6688l.m6504a(this.f6981I);
            this.f6688l.m6503a(new C1930bk(this));
        }
    }

    /* renamed from: d */
    private void m6728d(boolean z) {
        this.f6689m.setOnClickListener(z ? this.f6980H : null);
        m6732e(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6732e(boolean z) {
        if (this.f6689m != null) {
            this.f6689m.setEnabled(z);
        }
    }

    /* renamed from: f */
    private void m6733f(boolean z) {
        this.f6988t.setVisibility(z ? 0 : 4);
    }

    /* renamed from: a */
    private void m6715a(String str) throws IllegalStateException, Resources.NotFoundException {
        if (this.f6688l == null) {
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        this.f6691o = this.f6688l.m6507a(str, false);
        if (this.f6691o) {
            ((AMSDrawManager) this.f6688l.m6515h()).setBitmapForAMS(null);
            m6728d(true);
            this.f6988t.setMax(RunnableC1880bm.f6869a);
            this.f6988t.setProgress(0);
            if (this.f6974B) {
                m6762q();
                m6741h(false);
                if (!this.f6993y) {
                    m6748j(false);
                    return;
                }
                return;
            }
            this.f6688l.m6505a(true);
            m6765s();
            m6737g(false);
            if (!this.f6993y && !this.f6973A) {
                m6745i(true);
                return;
            }
            return;
        }
        m6728d(true);
        ((AMSDrawManager) this.f6688l.m6515h()).setBitmapForAMS(str);
        m6760p();
        if (!this.f6993y && !this.f6973A) {
            m6745i(true);
        }
    }

    /* renamed from: o */
    private void m6758o() throws Resources.NotFoundException {
        if (this.f6688l == null) {
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        if (!this.f6691o) {
            m6728d(true);
            if (!this.f6993y) {
                m6745i(true);
                return;
            }
            return;
        }
        m6728d(true);
        this.f6988t.setProgress(this.f6688l.m6502a());
        if ((this.f6688l.m6514g() & 1) != 1) {
            m6737g(false);
            if (!this.f6993y) {
                m6745i(true);
            }
        }
        m6765s();
    }

    /* renamed from: p */
    private void m6760p() {
        m6725c(false);
        this.f6990v.setEnabled(false);
        this.f6990v.setImageResource(R.drawable.ams_ics_selector_player_play);
        this.f6991w.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m6762q() throws IllegalStateException {
        if (this.f6688l == null) {
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        boolean zM6326s = ((AMSDrawManager) this.f6688l.m6515h()).m6326s();
        if (this.f6977E && !zM6326s) {
            this.f6978F = false;
            Dialog dialog = new Dialog(this, R.style.AMSIcsDialogTheme);
            dialog.getWindow().requestFeature(1);
            dialog.setContentView(R.layout.ams_ics_layout_attention_dialog);
            CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkbox_never_show_again);
            checkBox.setOnClickListener(new ViewOnClickListenerC1933bn(this));
            checkBox.setOnCheckedChangeListener(new C1934bo(this));
            dialog.findViewById(R.id.text_never_show_again).setOnClickListener(new ViewOnClickListenerC1914av(this));
            dialog.findViewById(R.id.text_never_show_again).setOnTouchListener(new ViewOnTouchListenerC1915aw(this, checkBox));
            ((Button) dialog.findViewById(R.id.btn_ok)).setOnClickListener(new ViewOnClickListenerC1916ax(this, dialog));
            dialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC1917ay(this));
            dialog.show();
            return;
        }
        this.f6688l.m6508b();
        m6765s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m6763r() throws IllegalStateException {
        if (this.f6688l == null) {
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
        } else {
            this.f6688l.m6510c();
            m6765s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m6765s() {
        if (this.f6688l == null) {
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        if ((this.f6688l.m6514g() & 1) == 1) {
            if (this.f6986r == 1002) {
                m6725c(false);
            } else {
                m6725c(true);
            }
            this.f6990v.setImageResource(R.drawable.ams_ics_selector_player_pause);
            return;
        }
        m6725c(true);
        this.f6990v.setImageResource(R.drawable.ams_ics_selector_player_play);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6737g(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f6991w.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1918az(this));
            return;
        }
        this.f6991w.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6741h(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f6991w.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1920ba(this));
            return;
        }
        this.f6991w.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6745i(boolean z) throws Resources.NotFoundException {
        if (z) {
            this.f6975C.removeCallbacks(this.f6982J);
            this.f6975C.postDelayed(this.f6982J, 2500L);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f6992x.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1922bc(this));
            return;
        }
        this.f6992x.setVisibility(0);
        this.f6973A = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6748j(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f6992x.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1923bd(this));
        } else {
            this.f6992x.setVisibility(8);
            this.f6973A = false;
        }
    }

    /* renamed from: b */
    private void m6720b(int i) {
        switch (i) {
            case 1002:
                m6723b(false);
                break;
            default:
                m6723b(true);
                break;
        }
    }

    /* renamed from: t */
    private void m6768t() throws IllegalStateException {
        String str;
        if (this.f6688l == null) {
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        if (this.f6985q == null) {
            this.f6976D = false;
            return;
        }
        if (this.f6986r == 1000) {
            this.f6688l.m6505a(true);
            str = this.f6985q;
        } else if (this.f6986r == 1001) {
            this.f6688l.m6505a(true);
            AMSComposerActivity.f6910l = false;
            if (!this.f6979G) {
                this.f6976D = false;
                m6716a(this.f6985q, 1);
                return;
            }
            AMSDrawManager aMSDrawManager = (AMSDrawManager) this.f6688l.m6515h();
            String str2 = f6610c + m6711a("A", System.currentTimeMillis(), ".jpg");
            if (!aMSDrawManager.m6301a(str2)) {
                this.f6976D = false;
                m6262a(R.string.ams_error_ams_file_save);
                return;
            }
            str = str2;
        } else {
            this.f6976D = false;
            C1786r.m6061b("Not support sending file!", getClass().getSimpleName());
            return;
        }
        if (str == null) {
            this.f6976D = false;
        } else {
            m6716a(str, 1);
        }
    }

    /* renamed from: a */
    private void m6716a(String str, int i) {
        Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_SEND_METHOD", i);
        startActivity(intent);
        finish();
    }

    /* renamed from: a */
    private String m6711a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: u */
    private void m6770u() {
        this.f6977E = getSharedPreferences("AMSPref", 1).getBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m6772v() {
        getSharedPreferences("AMSPref", 3).edit().putBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", this.f6977E).commit();
    }

    /* renamed from: w */
    private void m6773w() {
        this.f6984p = (AMSActionBarView) findViewById(R.id.actionbar);
    }

    /* renamed from: x */
    private void m6776x() {
        m6773w();
        this.f6984p.setTitleText(R.string.ams_app_name);
        this.f6984p.setHomeClickListener(this.f6983K);
        this.f6984p.m6244a();
        this.f6984p.m6246a(R.drawable.ams_ics_selector_title_ic_cancel, R.string.ams_btn_cancel, new ViewOnClickListenerC1926bg(this), 5001);
        this.f6984p.m6246a(R.drawable.ams_ics_selector_title_ic_check, R.string.ams_btn_send, new ViewOnClickListenerC1927bh(this), 5000);
        this.f6984p.setMoreOptionIconVisibility(false);
        this.f6984p.setActionButtonLayoutVisibility(true);
    }
}
