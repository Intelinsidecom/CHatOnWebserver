package com.sec.vip.amschaton;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: A */
    private ImageView f4021A;

    /* renamed from: B */
    private ImageView f4022B;

    /* renamed from: z */
    private ImageView f4039z;

    /* renamed from: m */
    private String f4026m = null;

    /* renamed from: n */
    private ImageView f4027n = null;

    /* renamed from: o */
    private AnimationDrawable f4028o = null;

    /* renamed from: p */
    private Button f4029p = null;

    /* renamed from: q */
    private Button f4030q = null;

    /* renamed from: r */
    private int f4031r = MsgResultCode.SUCCESS;

    /* renamed from: s */
    private int f4032s = MsgResultCode.UNKNOWN_MESSAGE_TYPE;

    /* renamed from: t */
    private int f4033t = 0;

    /* renamed from: u */
    private boolean f4034u = false;

    /* renamed from: v */
    private boolean f4035v = false;

    /* renamed from: w */
    private boolean f4036w = false;

    /* renamed from: x */
    private float f4037x = 0.0f;

    /* renamed from: y */
    private ProgressBar f4038y = null;

    /* renamed from: C */
    private View.OnClickListener f4023C = new ViewOnClickListenerC0639am(this);

    /* renamed from: D */
    private Handler f4024D = new HandlerC0638al(this);

    /* renamed from: E */
    private Handler f4025E = new HandlerC0637ak(this);

    /* renamed from: a */
    private String m4011a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m4012a(int i) throws IllegalStateException, Resources.NotFoundException, IOException {
        AMSFileInfo aMSFileInfoM4026c = m4026c(this.f4033t);
        if (aMSFileInfoM4026c == null) {
            return;
        }
        this.f4086a.m4197c();
        this.f4026m = aMSFileInfoM4026c.m3898a();
        m4016a(this.f4026m);
        m4028c(this.f4034u);
        m4030d(false);
        m4048p();
        m4017a(this.f4036w);
        if (this.f4036w) {
            m4049q();
        }
    }

    /* renamed from: a */
    private void m4015a(TextInputDialog textInputDialog) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(textInputDialog.m4182b(), 2);
        textInputDialog.m4182b().setOnFocusChangeListener(new ViewOnFocusChangeListenerC0633ag(this, textInputDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4016a(String str) throws IllegalStateException, Resources.NotFoundException, IOException {
        this.f4036w = this.f4086a.m4195a(str, true);
        if (!this.f4036w) {
            ((AMSDrawManager) this.f4086a.m4200f()).setBitmapForAMS(str);
            this.f4034u = false;
            return;
        }
        ((AMSDrawManager) this.f4086a.m4200f()).setBitmapForAMS(null);
        this.f4034u = ((AMSDrawManager) this.f4086a.m4200f()).m3849g();
        this.f4038y.setMax(this.f4086a.m4201g());
        this.f4038y.setProgress(0);
        if (this.f4031r != 1002 && this.f4031r != 1001) {
            this.f4086a.m4193a(true);
            return;
        }
        m4046n();
        m4017a(true);
        m4050r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4017a(boolean z) {
        if (z) {
            this.f4039z.setVisibility(0);
            this.f4086a.m4200f().setOnClickListener(this.f4023C);
        } else {
            this.f4039z.setVisibility(8);
            this.f4086a.m4200f().setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4019a(String str, String str2) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (FileNotFoundException e) {
            ChatONLogWriter.m3499a("[copy] File not found", getClass().getSimpleName());
            e.printStackTrace();
            fileInputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(str2, false);
        } catch (FileNotFoundException e2) {
            ChatONLogWriter.m3499a("FileOutputStream Failed", getClass().getSimpleName());
            e2.printStackTrace();
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            try {
                fileInputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return false;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            } catch (IOException e4) {
                ChatONLogWriter.m3499a("[copy] Write Failed", getClass().getSimpleName());
                e4.printStackTrace();
            }
        }
        fileOutputStream.flush();
        try {
            fileOutputStream.close();
        } catch (IOException e5) {
            ChatONLogWriter.m3499a("[copy] Output close Failed", getClass().getSimpleName());
            e5.printStackTrace();
        }
        try {
            fileInputStream.close();
        } catch (IOException e6) {
            ChatONLogWriter.m3499a("[copy] Input flush Failed", getClass().getSimpleName());
            e6.printStackTrace();
        }
        Toast.makeText(this, C0062R.string.ams_msg_saved, 0).show();
        return true;
    }

    /* renamed from: b */
    private int m4020b(String str) {
        switch (this.f4032s) {
            case MsgResultCode.UNEXPECTED_MESSAGE /* 2001 */:
                return AMSFileManager.m3931a().m3946b(str);
            default:
                return AMSFileManager.m3931a().m3942a(str);
        }
    }

    /* renamed from: b */
    private void m4022b(int i) {
        switch (i) {
            case 1002:
                this.f4029p.setText(C0062R.string.ams_btn_save);
                break;
            default:
                this.f4029p.setText(C0062R.string.ams_btn_send);
                break;
        }
    }

    /* renamed from: b */
    private void m4024b(boolean z) {
        if (z) {
            this.f4038y.setVisibility(0);
        } else {
            this.f4038y.setVisibility(4);
        }
    }

    /* renamed from: c */
    private AMSFileInfo m4026c(int i) {
        switch (this.f4032s) {
            case MsgResultCode.UNEXPECTED_MESSAGE /* 2001 */:
                return AMSFileManager.m3931a().m3950d(i);
            default:
                return AMSFileManager.m3931a().m3943a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4028c(boolean z) {
        if (z) {
            this.f4027n.setVisibility(0);
        } else {
            this.f4027n.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4030d(boolean z) {
        if (z && this.f4034u && (this.f4086a.m4199e() & 1) == 1) {
            this.f4028o.stop();
            this.f4028o.start();
            return;
        }
        this.f4028o.stop();
        if (this.f4035v) {
            return;
        }
        this.f4027n.setBackgroundDrawable(getResources().getDrawable(C0062R.drawable.ams_anim_bgm_playing));
        this.f4028o = (AnimationDrawable) this.f4027n.getBackground();
    }

    /* renamed from: d */
    private boolean m4031d(int i) {
        switch (this.f4032s) {
            case MsgResultCode.UNEXPECTED_MESSAGE /* 2001 */:
                return AMSFileManager.m3931a().m3951e(i);
            default:
                return AMSFileManager.m3931a().m3947b(i);
        }
    }

    /* renamed from: e */
    private boolean m4033e(int i) {
        switch (this.f4032s) {
            case MsgResultCode.UNEXPECTED_MESSAGE /* 2001 */:
                return AMSFileManager.m3931a().m3952f(i);
            default:
                return AMSFileManager.m3931a().m3949c(i);
        }
    }

    /* renamed from: i */
    private void m4038i() throws IOException {
        String str = f3810g + this.f4026m.substring(this.f4026m.lastIndexOf(47) + 1);
        ChatONLogWriter.m3506b("targetPath     : " + str, getClass().getSimpleName());
        ChatONLogWriter.m3506b("mTargetFilePath: " + this.f4026m, getClass().getSimpleName());
        if (this.f4026m.equals("/" + str)) {
            m4039j();
        } else {
            m4019a(this.f4026m, str);
        }
    }

    /* renamed from: j */
    private boolean m4039j() {
        TextInputDialog textInputDialog = new TextInputDialog(this, C0062R.style.AMSCustomDialogTheme, 64);
        textInputDialog.m4181a(m4011a("A", System.currentTimeMillis(), ""));
        textInputDialog.m4183b("\\/:*?\"<>|");
        textInputDialog.m4180a(new C0632af(this, textInputDialog));
        textInputDialog.show();
        m4015a(textInputDialog);
        return true;
    }

    /* renamed from: k */
    private void m4042k() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C0062R.id.layout_ams);
        relativeLayout.addView(this.f4087b);
        this.f4039z = new ImageView(this);
        this.f4039z.setImageDrawable(getResources().getDrawable(C0062R.drawable.ams_basic_selector_play));
        this.f4039z.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f4039z.setLayoutParams(layoutParams);
        this.f4089d.addView(this.f4039z);
        this.f4039z.setOnClickListener(this.f4023C);
        this.f4039z.setVisibility(8);
        relativeLayout.addView(this.f4089d);
        this.f4021A = (ImageView) findViewById(C0062R.id.iv_btn_next);
        this.f4021A.setOnClickListener(this);
        this.f4022B = (ImageView) findViewById(C0062R.id.iv_btn_prev);
        this.f4022B.setOnClickListener(this);
        this.f4038y = (ProgressBar) findViewById(C0062R.id.progressbar);
        this.f4038y.setMax(this.f4086a.m4201g());
        this.f4038y.setProgress(0);
        this.f4086a.m4190a(this.f4024D);
        m4024b(true);
        this.f4086a.m4192a(new C0640an(this));
        this.f4086a.m4200f().setOnClickListener(this.f4023C);
        this.f4086a.m4200f().setOnTouchListener(this);
    }

    /* renamed from: l */
    private void m4043l() throws IllegalStateException, Resources.NotFoundException, IOException {
        if (this.f4031r == 1002 || this.f4031r == 1001 || (this.f4086a.m4199e() & 1) == 1 || !m4031d(this.f4033t)) {
            return;
        }
        int i = this.f4033t + 1;
        this.f4033t = i;
        m4012a(i);
    }

    /* renamed from: m */
    private void m4045m() throws IllegalStateException, Resources.NotFoundException, IOException {
        if (this.f4031r == 1002 || this.f4031r == 1001 || (this.f4086a.m4199e() & 1) == 1 || !m4033e(this.f4033t)) {
            return;
        }
        int i = this.f4033t - 1;
        this.f4033t = i;
        m4012a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m4046n() throws IllegalStateException {
        this.f4086a.m4189a();
        m4030d(true);
        m4048p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m4047o() throws IllegalStateException {
        this.f4086a.m4196b();
        m4030d(false);
        m4048p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m4048p() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C0062R.id.layout_button);
        if ((this.f4086a.m4199e() & 1) == 1) {
            linearLayout.setVisibility(4);
        } else {
            linearLayout.setVisibility(0);
        }
        if (this.f4031r == 1002 || this.f4031r == 1001 || (this.f4086a.m4199e() & 1) == 1) {
            this.f4021A.setVisibility(4);
            this.f4022B.setVisibility(4);
            return;
        }
        if (m4031d(this.f4033t)) {
            this.f4021A.setVisibility(0);
        } else {
            this.f4021A.setVisibility(4);
        }
        if (m4033e(this.f4033t)) {
            this.f4022B.setVisibility(0);
        } else {
            this.f4022B.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m4049q() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, C0062R.anim.anim_viewer_control_panel_appear);
        this.f4089d.startAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC0636aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m4050r() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, C0062R.anim.anim_viewer_control_panel_disappear);
        this.f4089d.startAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC0635ai(this));
    }

    /* renamed from: s */
    private void m4051s() {
        startActivity(new Intent(this, (Class<?>) AMSComposerActivity.class));
        finish();
    }

    /* renamed from: t */
    private void m4052t() {
        Intent intent = new Intent(this, (Class<?>) AMSComposerActivity.class);
        intent.putExtra("AMS_FILE_PATH", this.f4026m);
        startActivity(intent);
        finish();
    }

    /* renamed from: u */
    private void m4053u() throws IllegalStateException {
        if (this.f4032s == 2000) {
            Toast.makeText(this, C0062R.string.ams_msg_cannot_delete_file, 0).show();
            return;
        }
        m4047o();
        m4048p();
        File file = new File(this.f4026m);
        if (file.exists()) {
            file.delete();
        }
        Toast.makeText(this, C0062R.string.ams_msg_deleted, 0).show();
        finish();
    }

    /* renamed from: v */
    private void m4054v() throws IllegalStateException, IOException {
        String str;
        this.f4086a.m4193a(true);
        if (this.f4026m == null) {
            return;
        }
        if (this.f4031r == 1000) {
            str = new String(this.f4026m);
        } else {
            if (this.f4031r != 1001) {
                ChatONLogWriter.m3506b("Not support sending file!", getClass().getSimpleName());
                return;
            }
            AMSDrawManager aMSDrawManager = (AMSDrawManager) this.f4086a.m4200f();
            String str2 = f3810g + m4011a("A", System.currentTimeMillis(), ".jpg");
            if (!aMSDrawManager.m3838a(str2)) {
                Toast.makeText(this, C0062R.string.ams_error_ams_file_save, 0).show();
                return;
            } else {
                str = new String(str2);
                AMSComposerActivity.f3824a = false;
            }
        }
        if (str != null) {
            Intent intent = new Intent(this, (Class<?>) AMSFileListActivity.class);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("AMS_FILE_PATH", str);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public Context m4055w() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, Resources.NotFoundException, IOException {
        switch (view.getId()) {
            case C0062R.id.btn_cancel /* 2131427352 */:
                finish();
                break;
            case C0062R.id.btn_send /* 2131427396 */:
                if (this.f4031r != 1002) {
                    m4054v();
                    break;
                } else {
                    m4038i();
                    break;
                }
            case C0062R.id.iv_btn_prev /* 2131427450 */:
                m4045m();
                break;
            case C0062R.id.iv_btn_next /* 2131427451 */:
                m4043l();
                break;
        }
        m4048p();
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4026m = extras.getString("AMS_FILE_PATH");
            this.f4031r = extras.getInt("VIEWER_MODE", 1002);
            this.f4032s = extras.getInt("AMS_FILE_TYPE", MsgResultCode.UNKNOWN_MESSAGE_TYPE);
        } else {
            ChatONLogWriter.m3506b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f4026m = "";
        }
        if (this.f4026m.length() < 1) {
            Toast.makeText(this, C0062R.string.ams_msg_invalid_ams_file, 0).show();
            finish();
            return;
        }
        if (this.f4031r == 1002 && (!m3717g() || !m3718h())) {
            ChatONLogWriter.m3499a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            Toast.makeText(this, C0062R.string.ams_sdcard_unmounted_msg, 0).show();
            finish();
            return;
        }
        setContentView(C0062R.layout.ams_player_layout);
        m4109a();
        m3712b();
        this.f4033t = m4020b(this.f4026m);
        this.f4027n = (ImageView) findViewById(C0062R.id.image_bgm_playing);
        this.f4027n.setVisibility(8);
        this.f4028o = (AnimationDrawable) this.f4027n.getBackground();
        m4042k();
        this.f4029p = (Button) findViewById(C0062R.id.btn_send);
        this.f4029p.setOnClickListener(this);
        this.f4030q = (Button) findViewById(C0062R.id.btn_cancel);
        this.f4030q.setOnClickListener(this);
        m4022b(this.f4031r);
        new Thread(new RunnableC0634ah(this)).start();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f4031r != 1000) {
            return true;
        }
        getMenuInflater().inflate(C0062R.menu.ams_player_option_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalStateException {
        switch (menuItem.getItemId()) {
            case C0062R.id.menu_create_new /* 2131428115 */:
                m4051s();
                break;
            case C0062R.id.menu_delete /* 2131428124 */:
                m4053u();
                break;
            case C0062R.id.menu_edit /* 2131428126 */:
                m4052t();
                break;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f4031r == 1000) {
            if (this.f4032s == 2000) {
                menu.setGroupVisible(C0062R.id.menu_group_delete, false);
            } else {
                menu.setGroupVisible(C0062R.id.menu_group_delete, true);
            }
            menu.setGroupVisible(C0062R.id.menu_group_edit, this.f4086a.m4202h());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws IllegalStateException, Resources.NotFoundException, IOException {
        if ((this.f4086a.m4199e() & 1) == 1) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f4037x = motionEvent.getX();
                break;
            case 1:
                float x = motionEvent.getX() - this.f4037x;
                if (x > 150.0f) {
                    m4045m();
                    return true;
                }
                if (x < -150.0f) {
                    m4043l();
                    return true;
                }
                break;
        }
        return false;
    }
}
