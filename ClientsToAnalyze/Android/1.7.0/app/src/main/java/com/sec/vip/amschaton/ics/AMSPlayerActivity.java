package com.sec.vip.amschaton.ics;

import android.app.Dialog;
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
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.AMSViewerActivity;
import com.sec.vip.amschaton.DialogC1379ap;
import com.sec.vip.amschaton.InterfaceC1547l;
import com.sec.vip.amschaton.RunnableC1550o;
import com.sec.widget.GeneralHeaderView;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity {

    /* renamed from: s */
    private ImageView f5247s;

    /* renamed from: t */
    private ImageView f5248t;

    /* renamed from: n */
    private String f5242n = null;

    /* renamed from: o */
    private int f5243o = 1000;

    /* renamed from: p */
    private int f5244p = 2000;

    /* renamed from: q */
    private boolean f5245q = false;

    /* renamed from: r */
    private SeekBar f5246r = null;

    /* renamed from: u */
    private RelativeLayout f5249u = null;

    /* renamed from: v */
    private LinearLayout f5250v = null;

    /* renamed from: w */
    private boolean f5251w = true;

    /* renamed from: x */
    private boolean f5252x = false;

    /* renamed from: y */
    private boolean f5253y = true;

    /* renamed from: z */
    private Handler f5254z = new Handler();

    /* renamed from: A */
    private boolean f5234A = false;

    /* renamed from: B */
    private GeneralHeaderView f5235B = null;

    /* renamed from: C */
    private boolean f5236C = true;

    /* renamed from: D */
    private boolean f5237D = false;

    /* renamed from: E */
    private View.OnClickListener f5238E = new ViewOnClickListenerC1516bt(this);

    /* renamed from: F */
    private InterfaceC1547l f5239F = new C1515bs(this);

    /* renamed from: G */
    private Handler f5240G = new HandlerC1514br(this);

    /* renamed from: H */
    private Runnable f5241H = new RunnableC1501be(this);

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f5242n = extras.getString("AMS_FILE_PATH");
            this.f5243o = extras.getInt("VIEWER_MODE", 1002);
            this.f5244p = extras.getInt("AMS_FILE_TYPE", 2001);
            if (this.f5243o == 1000) {
                this.f5253y = extras.getBoolean("AMS_DIRECT_PLAY", true);
            }
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f5242n = "";
        }
        if (this.f5242n.length() < 1) {
            m4738a(R.string.ams_msg_invalid_ams_file);
            m5505h();
            return;
        }
        if (this.f5243o == 1002 && (!m4743f() || !m4744g())) {
            C1341p.m4651a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            m4738a(R.string.ams_sdcard_unmounted_msg);
            m5505h();
            return;
        }
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f5251w = true;
        } else if (configuration.orientation == 2) {
            this.f5251w = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        if (mo4836a(this.f5251w)) {
            m5516l();
            m5517m();
            m5485b(this.f5243o);
            m5531t();
            new Thread(new RunnableC1512bp(this)).start();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f5251w = true;
        } else if (configuration.orientation == 2) {
            this.f5251w = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        m4835a();
        m5516l();
        m5485b(this.f5243o);
        m5524p();
        this.f5240G.sendEmptyMessage(1001);
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity, android.app.Activity
    protected void onDestroy() {
        this.f5234A = false;
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() throws Resources.NotFoundException {
        C1341p.m4660c("[onPause]", getClass().getName());
        m5493d(false);
        if (!this.f5251w) {
            m5499f(true);
        }
        m5522o();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m5505h();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1341p.m4660c("[onRestoreInstanceState]", getClass().getName());
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1341p.m4660c("[onSaveInstanceState]", getClass().getName());
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5505h() {
        if (this.f5243o == 1001) {
            if (!AMSComposerActivity.f5179b) {
                C1341p.m4660c("AMSComposerActivity is not destroyed yet", getClass().getName());
                return;
            }
            Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("ACTION", 2000);
            intent.putExtra("AMS_FILE_PATH", f4627i);
            startActivity(intent);
            finish();
            return;
        }
        if (this.f5243o == 1000) {
            Intent intent2 = new Intent(this, (Class<?>) AMSFileListActivity.class);
            intent2.addFlags(536870912);
            intent2.addFlags(67108864);
            intent2.putExtra("ACTION", 2000);
            intent2.putExtra("AMS_FILE_TYPE", this.f5244p);
            startActivity(intent2);
            finish();
            return;
        }
        if (this.f5243o == 1002) {
            finish();
        }
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity
    /* renamed from: a */
    protected boolean mo4836a(boolean z) {
        if (super.mo4836a(z)) {
            return true;
        }
        m5505h();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5509i() throws Throwable {
        if (this.f5243o == 1002) {
            m5512j();
            return;
        }
        if (!this.f5234A) {
            this.f5234A = true;
            m5526q();
        }
        m5524p();
    }

    /* renamed from: j */
    private void m5512j() throws Throwable {
        String str = f4624f + this.f5242n.substring(this.f5242n.lastIndexOf(47) + 1);
        C1341p.m4658b("targetPath     : " + str, getClass().getSimpleName());
        C1341p.m4658b("mTargetFilePath: " + this.f5242n, getClass().getSimpleName());
        if (("/" + str).equals(this.f5242n)) {
            m5514k();
        } else {
            m5483a(this.f5242n, str);
        }
    }

    /* renamed from: a */
    private void m5476a(DialogC1379ap dialogC1379ap) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(dialogC1379ap.m4942b(), 2);
        dialogC1379ap.m4942b().setOnFocusChangeListener(new ViewOnFocusChangeListenerC1520bx(this, dialogC1379ap));
    }

    /* renamed from: k */
    private boolean m5514k() {
        DialogC1379ap dialogC1379ap = new DialogC1379ap(this, R.style.AMSCustomDialogTheme, 64);
        dialogC1379ap.m4941a(m5475a("A", System.currentTimeMillis(), ""));
        dialogC1379ap.m4943b("\\/:*?\"<>|");
        dialogC1379ap.m4940a(new C1519bw(this, dialogC1379ap));
        dialogC1379ap.show();
        m5476a(dialogC1379ap);
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
    public boolean m5483a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSPlayerActivity.m5483a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: l */
    private void m5516l() throws Resources.NotFoundException {
        m5528r();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f4703c, this.f4703c);
        C1341p.m4661d("## mViewerSize = " + this.f4703c, getClass().getName());
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f4702b);
        this.f5247s = new ImageView(this);
        this.f5247s.setImageResource(R.drawable.ams_ics2_selector_player_overlay_btn_play);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f5247s.setLayoutParams(layoutParams2);
        this.f5247s.setOnClickListener(this.f5238E);
        this.f5248t = (ImageView) findViewById(R.id.btn_play_pause);
        this.f5248t.setOnClickListener(this.f5238E);
        this.f5249u = new RelativeLayout(this);
        this.f5249u.setLayoutParams(new RelativeLayout.LayoutParams(this.f4703c, this.f4703c));
        this.f5249u.addView(this.f5247s);
        m5496e(false);
        relativeLayout.addView(this.f5249u);
        this.f5250v = (LinearLayout) findViewById(R.id.layout_status);
        if (!this.f5251w) {
            m5501g(false);
        }
        this.f5246r = (SeekBar) findViewById(R.id.progressbar);
        this.f5246r.setOnTouchListener(new ViewOnTouchListenerC1518bv(this));
        this.f5246r.setMax(RunnableC1550o.f5386a);
        this.f5246r.setProgress(0);
        m5491c(true);
    }

    /* renamed from: m */
    private void m5517m() {
        this.f4701a.m5632a(this.f5239F);
        this.f4701a.m5631a(new C1517bu(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5488b(boolean z) {
        this.f4702b.setOnClickListener(z ? this.f5238E : null);
    }

    /* renamed from: c */
    private void m5491c(boolean z) {
        this.f5246r.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5480a(String str) throws Resources.NotFoundException {
        this.f5245q = this.f4701a.m5635a(str, false);
        if (this.f5245q) {
            ((AMSDrawManager) this.f4701a.m5643i()).setBitmapForAMS(null);
            m5488b(true);
            this.f5246r.setMax(RunnableC1550o.f5386a);
            this.f5246r.setProgress(0);
            if (this.f5253y) {
                m5520n();
                m5496e(false);
                if (!this.f5251w) {
                    m5501g(false);
                    return;
                }
                return;
            }
            this.f4701a.m5633a(true);
            m5524p();
            m5493d(false);
            if (!this.f5251w && !this.f5252x) {
                m5499f(true);
                return;
            }
            return;
        }
        m5488b(false);
        ((AMSDrawManager) this.f4701a.m5643i()).setBitmapForAMS(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m5520n() {
        boolean zM4789c = new AMSDrawManager(this).m4789c(this.f5242n);
        if (this.f5236C && !zM4789c) {
            this.f5237D = false;
            Dialog dialog = new Dialog(this, R.style.AMSIcsDialogTheme);
            dialog.getWindow().requestFeature(1);
            dialog.setContentView(R.layout.ams_ics_layout_attention_dialog);
            CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkbox_never_show_again);
            checkBox.setOnClickListener(new ViewOnClickListenerC1513bq(this));
            checkBox.setOnCheckedChangeListener(new C1509bm(this));
            dialog.findViewById(R.id.text_never_show_again).setOnClickListener(new ViewOnClickListenerC1507bk(this));
            dialog.findViewById(R.id.text_never_show_again).setOnTouchListener(new ViewOnTouchListenerC1508bl(this, checkBox));
            ((Button) dialog.findViewById(R.id.btn_ok)).setOnClickListener(new ViewOnClickListenerC1505bi(this, dialog));
            dialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC1506bj(this));
            dialog.show();
            return;
        }
        this.f4701a.m5636b();
        m5524p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m5522o() {
        this.f4701a.m5637c();
        m5524p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m5524p() {
        if ((this.f4701a.m5642h() & 1) == 1) {
            m5506h(false);
            this.f5248t.setImageResource(R.drawable.ams_ics_selector_player_pause);
        } else {
            m5506h(true);
            this.f5248t.setImageResource(R.drawable.ams_ics_selector_player_play);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5493d(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f5249u.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1503bg(this));
            return;
        }
        this.f5249u.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5496e(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f5249u.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1504bh(this));
            return;
        }
        this.f5249u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5499f(boolean z) throws Resources.NotFoundException {
        if (z) {
            this.f5254z.removeCallbacks(this.f5241H);
            this.f5254z.postDelayed(this.f5241H, 2500L);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f5235B.startAnimation(animationLoadAnimation);
            this.f5250v.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1502bf(this));
            return;
        }
        this.f5235B.setVisibility(0);
        this.f5250v.setVisibility(0);
        this.f5252x = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5501g(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f5235B.startAnimation(animationLoadAnimation);
            this.f5250v.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1500bd(this));
            return;
        }
        this.f5235B.setVisibility(8);
        this.f5250v.setVisibility(8);
        this.f5252x = false;
    }

    /* renamed from: h */
    private void m5506h(boolean z) {
        if (this.f5235B != null) {
            this.f5235B.setButtonEnabled(z);
        }
    }

    /* renamed from: b */
    private void m5485b(int i) {
        switch (i) {
            case 1002:
                m5510i(false);
                break;
            default:
                m5510i(true);
                break;
        }
    }

    /* renamed from: q */
    private void m5526q() {
        String str;
        this.f4701a.m5633a(true);
        if (this.f5242n == null) {
            this.f5234A = false;
            return;
        }
        if (this.f5243o == 1000) {
            str = this.f5242n;
        } else if (this.f5243o == 1001) {
            AMSDrawManager aMSDrawManager = (AMSDrawManager) this.f4701a.m5643i();
            String str2 = f4624f + m5475a("A", System.currentTimeMillis(), ".jpg");
            if (!aMSDrawManager.m4780a(str2)) {
                this.f5234A = false;
                m4738a(R.string.ams_error_ams_file_save);
                return;
            } else {
                AMSComposerActivity.f5178a = false;
                str = str2;
            }
        } else {
            this.f5234A = false;
            C1341p.m4658b("Not support sending file!", getClass().getSimpleName());
            return;
        }
        if (str == null) {
            this.f5234A = false;
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
    private String m5475a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: r */
    private void m5528r() {
        this.f5235B = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f5235B.setText(R.string.ams_app_name);
        m5530s();
        this.f5235B.setButtonImageResource(R.drawable.general_btn_icon_send_xml);
        this.f5235B.setBackClickListener(new ViewOnClickListenerC1495az(this));
        this.f5235B.setButtonClickListener(new ViewOnClickListenerC1497ba(this));
    }

    /* renamed from: s */
    private void m5530s() {
        if (this.f5235B != null) {
            this.f5235B.setTextSize(getResources().getDimension(R.dimen.ams_ics2_title_text_size) / getResources().getDisplayMetrics().density);
        }
    }

    /* renamed from: i */
    private void m5510i(boolean z) {
        if (this.f5235B != null) {
            if (z) {
                this.f5235B.setButtonImageResource(R.drawable.general_btn_icon_send_xml);
            } else {
                this.f5235B.setButtonImageResource(R.drawable.general_btn_icon_save_xml);
            }
        }
    }

    /* renamed from: t */
    private void m5531t() {
        this.f5236C = getSharedPreferences("AMSPref", 1).getBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m5533u() {
        getSharedPreferences("AMSPref", 3).edit().putBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", this.f5236C).commit();
    }
}
