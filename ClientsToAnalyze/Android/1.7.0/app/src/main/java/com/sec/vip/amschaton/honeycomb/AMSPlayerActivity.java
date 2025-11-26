package com.sec.vip.amschaton.honeycomb;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
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
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity implements View.OnClickListener {

    /* renamed from: s */
    private ImageView f5003s;

    /* renamed from: t */
    private ImageView f5004t;

    /* renamed from: n */
    private String f4998n = null;

    /* renamed from: o */
    private int f4999o = 1000;

    /* renamed from: p */
    private int f5000p = 2000;

    /* renamed from: q */
    private boolean f5001q = false;

    /* renamed from: r */
    private SeekBar f5002r = null;

    /* renamed from: u */
    private RelativeLayout f5005u = null;

    /* renamed from: v */
    private LinearLayout f5006v = null;

    /* renamed from: w */
    private boolean f5007w = true;

    /* renamed from: x */
    private boolean f5008x = true;

    /* renamed from: y */
    private boolean f5009y = false;

    /* renamed from: z */
    private boolean f5010z = true;

    /* renamed from: A */
    private Handler f4988A = new Handler();

    /* renamed from: B */
    private boolean f4989B = false;

    /* renamed from: C */
    private boolean f4990C = true;

    /* renamed from: D */
    private boolean f4991D = false;

    /* renamed from: E */
    private boolean f4992E = true;

    /* renamed from: F */
    private boolean f4993F = true;

    /* renamed from: G */
    private View.OnClickListener f4994G = new ViewOnClickListenerC1440bi(this);

    /* renamed from: H */
    private InterfaceC1547l f4995H = new C1441bj(this);

    /* renamed from: I */
    private Handler f4996I = new HandlerC1439bh(this);

    /* renamed from: J */
    private Runnable f4997J = new RunnableC1422ar(this);

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4998n = extras.getString("AMS_FILE_PATH");
            this.f4999o = extras.getInt("VIEWER_MODE", 1002);
            this.f5000p = extras.getInt("AMS_FILE_TYPE", 2001);
            if (this.f4999o == 1000) {
                this.f5010z = extras.getBoolean("AMS_DIRECT_PLAY", true);
            }
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f4998n = "";
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        if (this.f4998n.length() < 1) {
            m4738a(R.string.ams_msg_invalid_ams_file);
            m5186i();
            return;
        }
        if (this.f4999o == 1002 && (!m4743f() || !m4744g())) {
            C1341p.m4651a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            m4738a(R.string.ams_sdcard_unmounted_msg);
            m5186i();
            return;
        }
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f5008x = true;
        } else if (configuration.orientation == 2) {
            this.f5008x = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        mo4836a(this.f5008x);
        m5193l();
        m5194m();
        m5162b(this.f4999o);
        m5205r();
        new Thread(new RunnableC1433bb(this)).start();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.f5008x = true;
        } else if (configuration.orientation == 2) {
            this.f5008x = false;
        }
        setContentView(R.layout.ams_ics_layout_player);
        m4835a();
        m5193l();
        m5162b(this.f4999o);
        m5201p();
        this.f4996I.sendEmptyMessage(1001);
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity, android.app.Activity
    protected void onDestroy() {
        this.f4989B = false;
        super.onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
        m5201p();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() throws Resources.NotFoundException {
        C1341p.m4660c("[onPause]", getClass().getName());
        m5175f(false);
        if (!this.f5007w) {
            m5182h(true);
        }
        m5199o();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m5186i();
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

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ams_ics_option_menu_player, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                m5186i();
                return true;
            case R.id.menu_btn_send /* 2131428261 */:
                if (this.f4999o == 1002) {
                    m5189j();
                } else {
                    if (!this.f4989B) {
                        this.f4989B = true;
                        m5203q();
                    }
                    m5201p();
                    return true;
                }
            default:
                return false;
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_btn_send);
        if (menuItemFindItem != null) {
            if (this.f4992E) {
                menuItemFindItem.setIcon(R.drawable.ams_ics_selector_title_ic_check);
                menuItemFindItem.setTitle(R.string.ams_btn_send);
            } else {
                menuItemFindItem.setIcon(R.drawable.ams_ics_selector_title_ic_check);
                menuItemFindItem.setTitle(R.string.ams_btn_save);
            }
            menuItemFindItem.setEnabled(this.f4993F);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: b */
    private void m5165b(boolean z) {
        this.f4992E = z;
        invalidateOptionsMenu();
    }

    /* renamed from: c */
    private void m5168c(boolean z) {
        this.f4993F = z;
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public Context m5181h() {
        return this;
    }

    /* renamed from: i */
    private void m5186i() {
        if ((this.f4701a.m5642h() & 1) == 1) {
            m5199o();
        }
        if (this.f4999o == 1001) {
            new Thread(new RunnableC1434bc(this)).start();
            return;
        }
        if (this.f4999o == 1000) {
            Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("ACTION", 2000);
            intent.putExtra("AMS_FILE_TYPE", this.f5000p);
            startActivity(intent);
            finish();
            return;
        }
        if (this.f4999o == 1002) {
            finish();
        }
    }

    /* renamed from: j */
    private void m5189j() throws Throwable {
        String str = f4624f + this.f4998n.substring(this.f4998n.lastIndexOf(47) + 1);
        C1341p.m4658b("targetPath     : " + str, getClass().getSimpleName());
        C1341p.m4658b("mTargetFilePath: " + this.f4998n, getClass().getSimpleName());
        if (("/" + str).equals(this.f4998n)) {
            m5191k();
        } else {
            m5160a(this.f4998n, str);
        }
    }

    /* renamed from: a */
    private void m5153a(DialogC1379ap dialogC1379ap) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(dialogC1379ap.m4942b(), 2);
        dialogC1379ap.m4942b().setOnFocusChangeListener(new ViewOnFocusChangeListenerC1437bf(this, dialogC1379ap));
    }

    /* renamed from: k */
    private boolean m5191k() {
        DialogC1379ap dialogC1379ap = new DialogC1379ap(this, R.style.AMSCustomDialogTheme, 64);
        dialogC1379ap.m4941a(m5152a("A", System.currentTimeMillis(), ""));
        dialogC1379ap.m4943b("\\/:*?\"<>|");
        dialogC1379ap.m4940a(new C1438bg(this, dialogC1379ap));
        dialogC1379ap.show();
        m5153a(dialogC1379ap);
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
    public boolean m5160a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.AMSPlayerActivity.m5160a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: l */
    private void m5193l() throws Resources.NotFoundException {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_ams);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f4703c, this.f4703c);
        C1341p.m4661d("## mViewerSize = " + this.f4703c, getClass().getName());
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f4702b);
        this.f5003s = new ImageView(this);
        this.f5003s.setImageResource(R.drawable.ams_ics2_selector_player_overlay_btn_play);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f5003s.setLayoutParams(layoutParams2);
        this.f5003s.setOnClickListener(this.f4994G);
        this.f5004t = (ImageView) findViewById(R.id.btn_play_pause);
        this.f5004t.setOnClickListener(this.f4994G);
        this.f5005u = new RelativeLayout(this);
        this.f5005u.setLayoutParams(new RelativeLayout.LayoutParams(this.f4703c, this.f4703c));
        this.f5005u.addView(this.f5003s);
        m5179g(false);
        relativeLayout.addView(this.f5005u);
        this.f5006v = (LinearLayout) findViewById(R.id.layout_status);
        if (!this.f5007w) {
            m5187i(false);
        }
        this.f5002r = (SeekBar) findViewById(R.id.progressbar);
        this.f5002r.setOnTouchListener(new ViewOnTouchListenerC1435bd(this));
        this.f5002r.setMax(RunnableC1550o.f5386a);
        this.f5002r.setProgress(0);
        m5173e(true);
    }

    /* renamed from: m */
    private void m5194m() {
        this.f4701a.m5632a(this.f4995H);
        this.f4701a.m5631a(new C1436be(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5171d(boolean z) {
        this.f4702b.setOnClickListener(z ? this.f4994G : null);
    }

    /* renamed from: e */
    private void m5173e(boolean z) {
        this.f5002r.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5157a(String str) throws Resources.NotFoundException {
        this.f5001q = this.f4701a.m5635a(str, false);
        if (this.f5001q) {
            ((AMSDrawManager) this.f4701a.m5643i()).setBitmapForAMS(null);
            m5171d(true);
            this.f5002r.setMax(RunnableC1550o.f5386a);
            this.f5002r.setProgress(0);
            if (this.f5010z) {
                m5197n();
                m5179g(false);
                if (!this.f5007w) {
                    m5187i(false);
                    return;
                }
                return;
            }
            this.f4701a.m5633a(true);
            m5201p();
            m5175f(false);
            if (!this.f5007w && !this.f5009y) {
                m5182h(true);
                return;
            }
            return;
        }
        m5171d(false);
        ((AMSDrawManager) this.f4701a.m5643i()).setBitmapForAMS(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m5197n() {
        boolean zM4789c = new AMSDrawManager(this).m4789c(this.f4998n);
        if (this.f4990C && !zM4789c) {
            this.f4991D = false;
            Dialog dialog = new Dialog(this, R.style.AMSIcsDialogTheme);
            dialog.getWindow().requestFeature(1);
            dialog.setContentView(R.layout.ams_ics_layout_attention_dialog);
            CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkbox_never_show_again);
            checkBox.setOnClickListener(new ViewOnClickListenerC1425au(this));
            checkBox.setOnCheckedChangeListener(new C1426av(this));
            dialog.findViewById(R.id.text_never_show_again).setOnClickListener(new ViewOnClickListenerC1420ap(this));
            dialog.findViewById(R.id.text_never_show_again).setOnTouchListener(new ViewOnTouchListenerC1419ao(this, checkBox));
            ((Button) dialog.findViewById(R.id.btn_ok)).setOnClickListener(new ViewOnClickListenerC1418an(this, dialog));
            dialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC1417am(this));
            dialog.show();
            return;
        }
        this.f4701a.m5636b();
        m5201p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m5199o() {
        this.f4701a.m5637c();
        m5201p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m5201p() {
        if ((this.f4701a.m5642h() & 1) == 1) {
            m5168c(false);
            this.f5004t.setImageResource(R.drawable.ams_ics_selector_player_pause);
        } else {
            m5168c(true);
            this.f5004t.setImageResource(R.drawable.ams_ics_selector_player_play);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5175f(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f5005u.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1424at(this));
            return;
        }
        this.f5005u.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5179g(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f5005u.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1423as(this));
            return;
        }
        this.f5005u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5182h(boolean z) throws Resources.NotFoundException {
        if (z) {
            this.f4988A.removeCallbacks(this.f4997J);
            this.f4988A.postDelayed(this.f4997J, 2500L);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_appear);
            this.f5006v.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1421aq(this));
            return;
        }
        this.f5006v.setVisibility(0);
        this.f5009y = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5187i(boolean z) throws Resources.NotFoundException {
        if (z) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_viewer_control_panel_disappear);
            this.f5006v.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1427aw(this));
        } else {
            this.f5006v.setVisibility(8);
            this.f5009y = false;
        }
    }

    /* renamed from: b */
    private void m5162b(int i) {
        switch (i) {
            case 1002:
                m5165b(false);
                break;
            default:
                m5165b(true);
                break;
        }
    }

    /* renamed from: q */
    private void m5203q() {
        String str;
        this.f4701a.m5633a(true);
        if (this.f4998n == null) {
            this.f4989B = false;
            return;
        }
        if (this.f4999o == 1000) {
            str = this.f4998n;
        } else if (this.f4999o == 1001) {
            AMSDrawManager aMSDrawManager = (AMSDrawManager) this.f4701a.m5643i();
            String str2 = f4624f + m5152a("A", System.currentTimeMillis(), ".jpg");
            if (!aMSDrawManager.m4780a(str2)) {
                this.f4989B = false;
                m4738a(R.string.ams_error_ams_file_save);
                return;
            } else {
                com.sec.vip.amschaton.ics.AMSComposerActivity.f5178a = false;
                str = str2;
            }
        } else {
            this.f4989B = false;
            C1341p.m4658b("Not support sending file!", getClass().getSimpleName());
            return;
        }
        if (str == null) {
            this.f4989B = false;
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
    private String m5152a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: r */
    private void m5205r() {
        this.f4990C = getSharedPreferences("AMSPref", 1).getBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m5207s() {
        getSharedPreferences("AMSPref", 3).edit().putBoolean("AMS_PLAYER_NEVER_SHOW_AGAIN", this.f4990C).commit();
    }
}
