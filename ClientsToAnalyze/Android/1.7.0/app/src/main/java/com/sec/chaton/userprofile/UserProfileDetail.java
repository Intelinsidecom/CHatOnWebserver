package com.sec.chaton.userprofile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.facebook.C0700o;
import com.sec.chaton.facebook.InterfaceC0698m;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0226y;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.trunk.p045d.C1169g;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.C1356c;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class UserProfileDetail extends BaseActivity {

    /* renamed from: A */
    private String f4219A;

    /* renamed from: B */
    private String f4220B;

    /* renamed from: D */
    private Uri f4222D;

    /* renamed from: E */
    private Context f4223E;

    /* renamed from: F */
    private LinearLayout f4224F;

    /* renamed from: G */
    private GeneralHeaderView f4225G;

    /* renamed from: H */
    private ImageButton f4226H;

    /* renamed from: K */
    private Toast f4229K;

    /* renamed from: L */
    private Toast f4230L;

    /* renamed from: k */
    private File f4242k;

    /* renamed from: o */
    private C0226y f4246o;

    /* renamed from: p */
    private ImageButton f4247p;

    /* renamed from: q */
    private TextView f4248q;

    /* renamed from: r */
    private EditText f4249r;

    /* renamed from: s */
    private TextView f4250s;

    /* renamed from: t */
    private RelativeLayout f4251t;

    /* renamed from: u */
    private RelativeLayout f4252u;

    /* renamed from: v */
    private ProgressDialog f4253v;

    /* renamed from: w */
    private View f4254w;

    /* renamed from: x */
    private View f4255x;

    /* renamed from: y */
    private TextView f4256y;

    /* renamed from: z */
    private C0700o f4257z;

    /* renamed from: b */
    private final int f4234b = 0;

    /* renamed from: c */
    private final int f4235c = 1;

    /* renamed from: d */
    private final int f4236d = 2;

    /* renamed from: e */
    private final int f4237e = 3;

    /* renamed from: f */
    private final int f4238f = 5;

    /* renamed from: g */
    private final int f4239g = 6;

    /* renamed from: a */
    String f4233a = C1327bw.m4596b();

    /* renamed from: i */
    private File f4240i = new File(this.f4233a + "/profile/");

    /* renamed from: j */
    private File f4241j = GlobalApplication.m3100a().getFilesDir().getAbsoluteFile();

    /* renamed from: l */
    private String f4243l = "";

    /* renamed from: m */
    private boolean f4244m = false;

    /* renamed from: n */
    private boolean f4245n = false;

    /* renamed from: C */
    private boolean f4221C = true;

    /* renamed from: I */
    private Handler f4227I = new HandlerC1206ac(this);

    /* renamed from: J */
    private InterfaceC0698m f4228J = new C1219ap(this);

    /* renamed from: M */
    private View.OnClickListener f4231M = new ViewOnClickListenerC1218ao(this);

    /* renamed from: N */
    private TextWatcher f4232N = new C1217an(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4223E = this;
        this.f4253v = (ProgressDialog) new C1356c(this.f4223E).m4728a(R.string.dialog_userprofile_updating);
        m4382c();
    }

    /* renamed from: c */
    private void m4382c() {
        this.f4246o = new C0226y(this.f4227I);
        setContentView(R.layout.layout_user_profile_detail);
        this.f4247p = (ImageButton) findViewById(R.id.imgbtnUPPhoto);
        this.f4226H = (ImageButton) findViewById(R.id.focus);
        this.f4226H.setFocusable(true);
        this.f4226H.setFocusableInTouchMode(true);
        this.f4226H.requestFocus();
        this.f4248q = (TextView) findViewById(R.id.user_Pno);
        this.f4224F = (LinearLayout) findViewById(R.id.linear_profile_name);
        this.f4249r = (EditText) findViewById(R.id.textPersonalName);
        this.f4249r.addTextChangedListener(this.f4232N);
        this.f4249r.setOnEditorActionListener(new C1216am(this));
        this.f4250s = (TextView) findViewById(R.id.dateDisplay);
        this.f4252u = (RelativeLayout) findViewById(R.id.rlayoutBDay);
        this.f4251t = (RelativeLayout) findViewById(R.id.rlayoutPhoneNumber);
        this.f4225G = (GeneralHeaderView) findViewById(R.id.birthday_headerView);
        this.f4225G.setButtonClickListener(new ViewOnClickListenerC1209af(this));
        m4386e();
        m4384d();
        m4388f();
        this.f4254w = findViewById(R.id.rlayout_facebook_account);
        this.f4255x = findViewById(R.id.user_facebook_account_detail);
        this.f4256y = (TextView) findViewById(R.id.user_facebook_account_id);
        if (this.f4257z == null) {
            this.f4257z = new C0700o(this, this.f4228J);
        }
        if (!C0684a.m3051c()) {
            this.f4254w.setVisibility(8);
            this.f4255x.setVisibility(8);
            this.f4256y.setVisibility(8);
            C1341p.m4662e("Facebook is not available : " + C1323bs.m4575a().getString("country_ISO", ""), "UserProfileDetail");
        }
        this.f4254w.setOnClickListener(this.f4231M);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        m4378a(this.f4257z.m3080a());
        this.f4249r.clearFocus();
        this.f4226H.requestFocus();
    }

    /* renamed from: d */
    private void m4384d() {
        this.f4219A = C1323bs.m4575a().getString("msisdn", "");
        this.f4220B = C1323bs.m4575a().getString("Push Name", "");
        this.f4248q.setText("+" + this.f4219A);
        this.f4249r.setText(this.f4220B);
        if (this.f4249r.getText().length() > 0) {
            this.f4249r.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        this.f4225G.setButtonEnabled(false);
        MyPageFragment.m4291a(this.f4250s);
        if (C1323bs.m4575a().getBoolean("show_phone_number_to_all", false)) {
            this.f4248q.setTextColor(getResources().getColor(R.color.white));
        } else {
            this.f4248q.setTextColor(getResources().getColor(R.color.gray2));
        }
    }

    /* renamed from: e */
    private void m4386e() {
        this.f4247p.setOnClickListener(new ViewOnClickListenerC1208ae(this));
        this.f4224F.setOnClickListener(new ViewOnClickListenerC1211ah(this));
        this.f4252u.setOnClickListener(new ViewOnClickListenerC1210ag(this));
        this.f4251t.setOnClickListener(new ViewOnClickListenerC1205ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4388f() {
        C1341p.m4662e("UserProfile initialize() - img status: " + C1323bs.m4575a().getString("profile_image_status", ""), "UserProfileDetail");
        if (C1323bs.m4575a().getString("profile_image_status", "").equals("updated")) {
            File file = new File(this.f4241j, "myprofile.png_");
            C1341p.m4658b("photoFile=" + file, getClass().getSimpleName());
            if (file.exists()) {
                new AsyncTaskC1204aa(this, file).execute(new Void[0]);
                return;
            } else {
                m4391h();
                return;
            }
        }
        m4391h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4390g() throws IOException {
        int i;
        try {
            m4394i();
            this.f4243l = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f4242k = new File(this.f4240i + "/", this.f4243l);
            this.f4240i.mkdir();
            C1341p.m4658b("[Create File] " + this.f4240i.toString() + this.f4243l + " : " + this.f4242k.createNewFile(), "UserProfileDetail");
            this.f4222D = Uri.fromFile(this.f4242k);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (this.f4230L == null) {
                    this.f4230L = C1619g.m5889a(this.f4223E, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f4230L.show();
            } else {
                if (C1323bs.m4575a().getString("profile_image_status", "").equals("updated")) {
                    i = R.array.selphoto;
                } else {
                    i = R.array.selphoto_first;
                }
                new AlertDialogBuilderC1625m(this.f4223E).setTitle(R.string.select_photo).setItems(i, new DialogInterfaceOnClickListenerC1207ad(this)).create().show();
            }
        } catch (IOException e) {
            C1341p.m4653a(e, UserProfileDetail.class.getSimpleName());
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f4257z.m3082a(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                    if (file.length() <= 0) {
                        C1341p.m4651a("Crop return null!", "UserProfileDetail");
                        break;
                    } else {
                        try {
                            C1169g.m4215a(file, this.f4242k);
                            this.f4246o.m874a(this.f4242k.getPath());
                            this.f4253v.show();
                            break;
                        } catch (Exception e) {
                            C1341p.m4653a(e, getClass().getSimpleName());
                            m4391h();
                            return;
                        }
                    }
                }
                break;
            case 5:
                if (intent == null) {
                    C1341p.m4658b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f4222D = intent.getData();
                    Intent intent2 = new Intent(this, (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f4222D, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
            case 6:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f4223E, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f4222D, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 3);
                    break;
                } else {
                    C1341p.m4658b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4391h() {
        try {
            this.f4247p.setImageBitmap(C1348w.m4680a(this.f4223E, R.drawable.propile_default_image));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialogC1354a progressDialogC1354a = new ProgressDialogC1354a(this);
                progressDialogC1354a.setMessage(getString(R.string.dialog_connecting_server));
                progressDialogC1354a.setIndeterminate(true);
                progressDialogC1354a.setCancelable(false);
                return progressDialogC1354a;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4378a(String str) {
        if (this.f4257z.m3085b() && str != null) {
            this.f4256y.setText(str);
            this.f4255x.setVisibility(0);
        } else {
            this.f4256y.setText(R.string.login);
            this.f4255x.setVisibility(8);
        }
    }

    /* renamed from: i */
    private void m4394i() {
        if (!m4402a() || !m4403b()) {
            C1341p.m4651a("[deleteTempFolder] External Storage Is Not Available or Writable!", "UserProfileDetail");
            if (this.f4230L == null) {
                this.f4230L = C1619g.m5889a(this.f4223E, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f4230L.show();
            return;
        }
        String strM4596b = C1327bw.m4596b();
        if (strM4596b.length() == 0) {
            this.f4230L.show();
            return;
        }
        try {
            String[] list = new File(strM4596b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C1341p.m4658b("[Delete File] " + strM4596b + "/profile/" + str + " : " + new File(strM4596b + "/profile/" + str).delete(), "UserProfileDetail");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    protected boolean m4402a() {
        m4396j();
        return this.f4244m;
    }

    /* renamed from: b */
    protected boolean m4403b() {
        m4396j();
        return this.f4245n;
    }

    /* renamed from: j */
    private void m4396j() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f4244m = true;
            this.f4245n = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f4244m = true;
            this.f4245n = false;
        } else {
            this.f4244m = false;
            this.f4245n = false;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m4382c();
        m4378a(this.f4257z.m3080a());
        this.f4249r.clearFocus();
        this.f4226H.requestFocus();
    }
}
