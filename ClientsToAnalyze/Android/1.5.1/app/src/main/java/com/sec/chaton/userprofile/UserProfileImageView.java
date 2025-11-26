package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.control.ProfileControl;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.chaton.widget.SMSProgressBar;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class UserProfileImageView extends BaseActivity {

    /* renamed from: b */
    public static final String f3501b = UserProfileImageView.class.getSimpleName();

    /* renamed from: a */
    String f3502a;

    /* renamed from: c */
    View.OnClickListener f3503c;

    /* renamed from: d */
    private Context f3504d;

    /* renamed from: e */
    private Button f3505e;

    /* renamed from: f */
    private Button f3506f;

    /* renamed from: h */
    private ImageView f3508h;

    /* renamed from: i */
    private Uri f3509i;

    /* renamed from: l */
    private ProgressDialog f3512l;

    /* renamed from: m */
    private ProfileControl f3513m;

    /* renamed from: n */
    private int f3514n;

    /* renamed from: o */
    private int f3515o;

    /* renamed from: p */
    private int f3516p;

    /* renamed from: q */
    private File f3517q;

    /* renamed from: r */
    private File f3518r;

    /* renamed from: s */
    private File f3519s;

    /* renamed from: t */
    private String f3520t;

    /* renamed from: u */
    private boolean f3521u;

    /* renamed from: v */
    private boolean f3522v;

    /* renamed from: w */
    private Handler f3523w;

    /* renamed from: g */
    private ProgressDialog f3507g = null;

    /* renamed from: j */
    private boolean f3510j = false;

    /* renamed from: k */
    private boolean f3511k = true;

    public UserProfileImageView() {
        this.f3502a = StorageStateInfoUtil.m3677a() ? GlobalApplication.m2386d().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
        this.f3517q = new File(this.f3502a + "/profile/");
        this.f3518r = GlobalApplication.m2387e().getFilesDir().getAbsoluteFile();
        this.f3520t = "";
        this.f3521u = false;
        this.f3522v = false;
        this.f3503c = new ViewOnClickListenerC0568av(this);
        this.f3523w = new HandlerC0566at(this);
    }

    /* renamed from: d */
    private void m3441d() throws Resources.NotFoundException {
        this.f3512l = (ProgressDialog) new SMSProgressBar(this.f3504d).onCreate(C0062R.string.dialog_userprofile_updating);
        this.f3513m = new ProfileControl(this.f3523w);
        this.f3508h = (ImageView) findViewById(C0062R.id.profile_big_image);
        this.f3505e = (Button) findViewById(C0062R.id.profile_ok);
        this.f3505e.setOnClickListener(this.f3503c);
        this.f3506f = (Button) findViewById(C0062R.id.profile_cancel);
        this.f3506f.setOnClickListener(this.f3503c);
        Display defaultDisplay = ((WindowManager) this.f3504d.getSystemService("window")).getDefaultDisplay();
        ChatONLogWriter.m3506b("w:" + defaultDisplay.getWidth(), getClass().getSimpleName());
        ChatONLogWriter.m3506b("h:" + defaultDisplay.getHeight(), getClass().getSimpleName());
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if (width < 480 || height < 600) {
            this.f3514n = 350;
            this.f3515o = 350;
            this.f3516p = 350;
        } else {
            this.f3514n = 600;
            this.f3515o = 600;
            this.f3516p = 800;
        }
        m3447g();
    }

    /* renamed from: e */
    private void m3443e() throws Throwable {
        try {
            this.f3510j = true;
            if (!this.f3511k || this.f3519s.length() <= 1000000) {
                this.f3513m.m2066a(this.f3519s.getPath());
                this.f3512l.show();
            } else {
                File fileM3351a = UserProfileDetail.m3351a(this.f3504d, this.f3519s);
                if (fileM3351a != null) {
                    this.f3513m.m2066a(fileM3351a.getPath());
                    this.f3512l.show();
                }
            }
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            m3445f();
        }
    }

    /* renamed from: f */
    private void m3445f() {
        try {
            this.f3508h.setImageResource(C0062R.drawable.co_default_image_add);
            m3451a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m3447g() throws Resources.NotFoundException {
        ChatONLogWriter.m3511e("UserProfile initialize() - img status: " + ChatONPref.m3519a().getString("profile_image_status", ""), getClass().getSimpleName());
        if (!ChatONPref.m3519a().getString("profile_image_status", "").equals("updated")) {
            m3445f();
            return;
        }
        File file = new File(this.f3518r, "myprofile.png_");
        ChatONLogWriter.m3506b("photoFile=" + file, getClass().getSimpleName());
        if (file.exists()) {
            new AsyncTaskC0565as(this, file).execute(new Void[0]);
        } else {
            m3445f();
            Toast.makeText(this.f3504d, C0062R.string.setting_profile_image_not_exist, 1);
        }
    }

    /* renamed from: h */
    private void m3449h() {
        if (!m3452b() || !m3453c()) {
            ChatONLogWriter.m3499a("[deleteTempFolder] External Storage Is Not Available or Writable!", f3501b);
            return;
        }
        String[] list = new File(ChatOnGraphics.f3636b).list();
        if (list != null) {
            for (String str : list) {
                ChatONLogWriter.m3506b("[Delete File] " + ChatOnGraphics.f3636b + str + " : " + new File(ChatOnGraphics.f3636b + str).delete(), f3501b);
            }
        }
    }

    /* renamed from: i */
    private void m3450i() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f3521u = true;
            this.f3522v = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f3521u = true;
            this.f3522v = false;
        } else {
            this.f3521u = false;
            this.f3522v = false;
        }
    }

    /* renamed from: a */
    public void m3451a() {
        try {
            if (!this.f3517q.canRead()) {
                this.f3517q.mkdirs();
            }
            m3449h();
            this.f3520t = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f3519s = new File(this.f3517q + "/", this.f3520t);
            ChatONLogWriter.m3506b("[Create File] " + this.f3517q.toString() + this.f3520t + " : " + this.f3519s.createNewFile(), f3501b);
            this.f3509i = Uri.fromFile(this.f3519s);
            if ("mounted".equals(Environment.getExternalStorageState())) {
                new AlertDialog.Builder(this.f3504d).setIcon(C0062R.drawable.ic_dialog_menu_generic).setTitle(C0062R.string.select_photo).setItems(ChatONPref.m3519a().getString("profile_image_status", "").equals("updated") ? C0062R.array.selphoto : C0062R.array.selphoto_first, new DialogInterfaceOnClickListenerC0567au(this)).create().show();
            } else {
                Toast.makeText(this.f3504d, getString(C0062R.string.toast_sdcard_amount), 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m3452b() {
        m3450i();
        return this.f3521u;
    }

    /* renamed from: c */
    protected boolean m3453c() {
        m3450i();
        return this.f3522v;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        System.gc();
        switch (i) {
            case 3:
                if (i2 == -1) {
                    if (new File(ChatOnGraphics.f3636b + "/" + this.f3520t).length() > 0) {
                        try {
                            this.f3508h.setImageBitmap(Bitmap.createScaledBitmap(ChatOnGraphics.m3541b(this.f3504d, Uri.parse(this.f3517q + "/" + this.f3520t), this.f3516p), this.f3516p, this.f3516p, true));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        m3443e();
                        break;
                    } else {
                        ChatONLogWriter.m3499a("Crop return null!", f3501b);
                        break;
                    }
                }
                break;
            case 4:
                if (new File(ChatOnGraphics.f3636b + "/" + this.f3520t).length() > 0) {
                    Intent intent2 = new Intent("com.android.camera.action.CROP");
                    intent2.setDataAndType(this.f3509i, "image/*");
                    intent2.putExtra("outputX", this.f3514n);
                    intent2.putExtra("outputY", this.f3515o);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("scale", true);
                    intent2.putExtra("return-data", false);
                    intent2.putExtra("output", this.f3509i);
                    intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                    startActivityForResult(intent2, 3);
                    break;
                } else {
                    ChatONLogWriter.m3499a("Camera capture is fail!", f3501b);
                    break;
                }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_profile_image_view);
        this.f3504d = this;
        m3441d();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
