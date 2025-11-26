package com.sec.chaton.userprofile;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.facebook.C0725f;
import com.sec.chaton.facebook.InterfaceC0736q;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.C0647s;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class UserProfileDetail extends BaseActivity {

    /* renamed from: a */
    protected static int f6017a = 0;

    /* renamed from: A */
    private ImageView f6018A;

    /* renamed from: B */
    private EditText f6019B;

    /* renamed from: C */
    private EditText f6020C;

    /* renamed from: D */
    private TextView f6021D;

    /* renamed from: E */
    private ProgressDialog f6022E;

    /* renamed from: F */
    private C0725f f6023F;

    /* renamed from: G */
    private String f6024G;

    /* renamed from: H */
    private String f6025H;

    /* renamed from: J */
    private Uri f6027J;

    /* renamed from: K */
    private Context f6028K;

    /* renamed from: N */
    private String f6031N;

    /* renamed from: R */
    private boolean f6035R;

    /* renamed from: S */
    private C0633e f6036S;

    /* renamed from: T */
    private CheckBox f6037T;

    /* renamed from: U */
    private TextView f6038U;

    /* renamed from: V */
    private TextView f6039V;

    /* renamed from: W */
    private LinearLayout f6040W;

    /* renamed from: X */
    private CheckBox f6041X;

    /* renamed from: Y */
    private SimpleDateFormat f6042Y;

    /* renamed from: Z */
    private String f6043Z;

    /* renamed from: ab */
    private String f6045ab;

    /* renamed from: ac */
    private String f6046ac;

    /* renamed from: ad */
    private AlertDialogC1696f f6047ad;

    /* renamed from: al */
    private Toast f6055al;

    /* renamed from: am */
    private Toast f6056am;

    /* renamed from: c */
    SimpleDateFormat f6059c;

    /* renamed from: d */
    SimpleDateFormat f6060d;

    /* renamed from: v */
    private File f6075v;

    /* renamed from: z */
    private C0647s f6079z;

    /* renamed from: j */
    private final int f6063j = 0;

    /* renamed from: k */
    private final int f6064k = 1;

    /* renamed from: l */
    private final int f6065l = 2;

    /* renamed from: m */
    private final int f6066m = 3;

    /* renamed from: n */
    private final int f6067n = 5;

    /* renamed from: o */
    private final int f6068o = 6;

    /* renamed from: p */
    private final int f6069p = 7;

    /* renamed from: q */
    private String f6070q = "UserProfileDetail";

    /* renamed from: r */
    private boolean f6071r = false;

    /* renamed from: s */
    private boolean f6072s = false;

    /* renamed from: b */
    String f6058b = C1767bw.m6003b();

    /* renamed from: t */
    private File f6073t = new File(this.f6058b + "/profile/");

    /* renamed from: u */
    private File f6074u = GlobalApplication.m3260b().getFilesDir().getAbsoluteFile();

    /* renamed from: w */
    private String f6076w = "";

    /* renamed from: x */
    private boolean f6077x = false;

    /* renamed from: y */
    private boolean f6078y = false;

    /* renamed from: I */
    private boolean f6026I = true;

    /* renamed from: L */
    private boolean f6029L = false;

    /* renamed from: M */
    private boolean f6030M = false;

    /* renamed from: O */
    private boolean f6032O = false;

    /* renamed from: P */
    private boolean f6033P = false;

    /* renamed from: Q */
    private boolean f6034Q = false;

    /* renamed from: aa */
    private Calendar f6044aa = Calendar.getInstance();

    /* renamed from: ae */
    private boolean f6048ae = false;

    /* renamed from: af */
    private boolean f6049af = false;

    /* renamed from: e */
    boolean f6061e = false;

    /* renamed from: ag */
    private TextWatcher f6050ag = new C1685ch(this);

    /* renamed from: ah */
    private InterfaceC1698h f6051ah = new C1686ci(this);

    /* renamed from: i */
    CompoundButton.OnCheckedChangeListener f6062i = new C1687cj(this);

    /* renamed from: ai */
    private View.OnClickListener f6052ai = new ViewOnClickListenerC1688ck(this);

    /* renamed from: aj */
    private Handler f6053aj = new HandlerC1676bz(this);

    /* renamed from: ak */
    private InterfaceC0736q f6054ak = new C1680cc(this);

    /* renamed from: an */
    private View.OnClickListener f6057an = new ViewOnClickListenerC1681cd(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6028K = this;
        this.f6022E = (ProgressDialog) new C1805i(this.f6028K).m6139a(R.string.dialog_userprofile_updating);
        m5739f();
        getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
    }

    /* renamed from: f */
    private void m5739f() {
        this.f6079z = new C0647s(this.f6053aj);
        setContentView(R.layout.layout_user_profile_detail);
        this.f6029L = false;
        this.f6018A = (ImageView) findViewById(R.id.imgbtnUPPhoto);
        this.f6018A.requestFocus();
        this.f6019B = (EditText) findViewById(R.id.textPersonalName);
        this.f6025H = C1789u.m6075a().getString("Push Name", "");
        this.f6019B.setText(this.f6025H);
        this.f6019B.setSelection(this.f6019B.length());
        this.f6019B.addTextChangedListener(new C1673bw(this));
        this.f6020C = (EditText) findViewById(R.id.statusMsgText);
        this.f6020C.setText(C1789u.m6075a().getString("status_message", ""));
        this.f6020C.setSelection(this.f6020C.length());
        this.f6020C.addTextChangedListener(new C1682ce(this));
        this.f6021D = (TextView) findViewById(R.id.dateDisplay);
        String str = "+" + C1789u.m6075a().getString("msisdn", "");
        this.f6039V = (TextView) findViewById(R.id.phone_number_text);
        this.f6039V.setText(str);
        this.f6038U = (TextView) findViewById(R.id.phone_number_privacy_message);
        if (C1789u.m6075a().getBoolean("show_phone_number_to_all", false)) {
            this.f6038U.setText(getResources().getString(R.string.phone_number_privacy_guide));
        } else {
            this.f6038U.setText(getResources().getString(R.string.phone_number_privacy_guide_off));
        }
        this.f6037T = (CheckBox) findViewById(R.id.phone_number_checkbox);
        this.f6037T.setChecked(C1789u.m6075a().getBoolean("show_phone_number_to_all", false));
        this.f6032O = C1789u.m6075a().getBoolean("show_phone_number_to_all", false);
        this.f6037T.setOnClickListener(this.f6052ai);
        this.f6037T.setOnCheckedChangeListener(new C1683cf(this));
        this.f6040W = (LinearLayout) findViewById(R.id.llayoutBDay);
        this.f6059c = new SimpleDateFormat("yyyy-MM-dd");
        this.f6060d = new SimpleDateFormat("MM-dd");
        this.f6042Y = new SimpleDateFormat("MM-dd");
        C1786r.m6066e("mOption : " + this.f6031N, getClass().getSimpleName());
        this.f6041X = (CheckBox) findViewById(R.id.birthday_check);
        this.f6041X.setChecked(C1789u.m6075a().getBoolean("birthday_show", false));
        this.f6033P = C1789u.m6075a().getBoolean("birthday_show", false);
        C1786r.m6066e("setChecked : " + C1789u.m6075a().getBoolean("birthday_show", false), getClass().getSimpleName());
        this.f6041X.setOnCheckedChangeListener(this.f6062i);
        this.f6034Q = C1789u.m6075a().getBoolean("birthday_year_show", false);
        m5745i();
        this.f6031N = C1789u.m6075a().getString("birthday_type", "");
        this.f6045ab = C1789u.m6075a().getString("birthday", "");
        m5743h();
        m5741g();
        m5756o();
        invalidateOptionsMenu();
    }

    /* renamed from: g */
    private void m5741g() {
        new Date();
        if ("FULL".equals(this.f6031N)) {
            try {
                this.f6059c.parse(this.f6045ab);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.f6021D.setText(MyPageFragment.m5579a(this.f6045ab));
            return;
        }
        if ("SHORT".equals(this.f6031N)) {
            String[] strArrSplit = this.f6045ab.split("-");
            String str = strArrSplit[1] + "-" + strArrSplit[2];
            try {
                this.f6042Y.parse(str);
            } catch (ParseException e2) {
                C1786r.m6056a(e2, getClass().getSimpleName());
            }
            this.f6021D.setText(MyPageFragment.m5579a(str));
            return;
        }
        if ("DONT".equals(this.f6031N)) {
            if (this.f6045ab != null && !"".equals(this.f6045ab)) {
                if (!this.f6045ab.startsWith("0000")) {
                    if (C1789u.m6075a().getBoolean("birthday_year_show", false)) {
                        this.f6021D.setText(MyPageFragment.m5579a(this.f6045ab));
                        return;
                    }
                    String[] strArrSplit2 = this.f6045ab.split("-");
                    this.f6021D.setText(MyPageFragment.m5579a(strArrSplit2[1] + "-" + strArrSplit2[2]));
                    return;
                }
                this.f6021D.setText(getResources().getString(R.string.add_your_birthday));
                return;
            }
            this.f6021D.setText(getResources().getString(R.string.add_your_birthday));
            return;
        }
        this.f6021D.setText(getResources().getString(R.string.add_your_birthday));
        C1789u.m6076a("birthday_show", (Boolean) false);
        this.f6041X.setChecked(false);
    }

    /* renamed from: h */
    private void m5743h() {
        if ("FULL".equals(this.f6031N)) {
            this.f6021D.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
            return;
        }
        if ("SHORT".equals(this.f6031N)) {
            this.f6021D.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
        } else if ("DONT".equals(this.f6031N)) {
            this.f6021D.setTextColor(Color.parseColor("#9A9A9A"));
        } else {
            this.f6021D.setTextColor(Color.parseColor("#9A9A9A"));
        }
    }

    /* renamed from: i */
    private void m5745i() {
        this.f6040W.setOnClickListener(new ViewOnClickListenerC1684cg(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5746j() throws NumberFormatException {
        int i = Calendar.getInstance().get(1);
        int i2 = Calendar.getInstance().get(2);
        int i3 = Calendar.getInstance().get(5);
        C1786r.m6061b("[editBirthDay] mBirthDay=" + this.f6045ab, getClass().getSimpleName());
        if (this.f6045ab != null && !"".equals(this.f6045ab)) {
            String[] strArrSplit = this.f6045ab.split("-");
            i = Integer.parseInt(strArrSplit[0]);
            i2 = Integer.parseInt(strArrSplit[1]) - 1;
            i3 = Integer.parseInt(strArrSplit[2]);
        }
        if ("FULL".equals(this.f6031N)) {
            this.f6035R = true;
            m5776a(i, i2, i3, 0);
        } else if ("SHORT".equals(this.f6031N)) {
            this.f6035R = true;
            m5776a(i, i2, i3, 1);
        } else {
            m5776a(i, i2, i3, 0);
        }
    }

    /* renamed from: a */
    protected void m5776a(int i, int i2, int i3, int i4) {
        this.f6047ad = null;
        switch (i4) {
            case 0:
                this.f6047ad = new AlertDialogC1696f(this.f6028K, this.f6051ah, i, i2, i3);
                break;
            case 1:
                this.f6047ad = new AlertDialogC1696f(this.f6028K, this.f6051ah, i, i2, i3);
                break;
        }
        if (this.f6047ad != null) {
            this.f6047ad.m5810a(i, i2, i3);
            this.f6047ad.show();
        }
    }

    /* renamed from: a */
    public void m5775a() {
        this.f6031N = "FULL";
        if ("".equals(this.f6045ab)) {
            this.f6045ab = m5778c();
        }
        C1786r.m6061b("onClick::mBirthDay" + this.f6045ab, getClass().getSimpleName());
        this.f6046ac = MyPageFragment.m5579a(this.f6045ab);
        this.f6021D.setText(this.f6046ac);
        this.f6021D.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }

    /* renamed from: b */
    public void m5777b() {
        this.f6031N = "SHORT";
        if ("".equals(this.f6045ab)) {
            this.f6045ab = m5778c();
        }
        this.f6046ac = MyPageFragment.m5579a(this.f6045ab.substring(5, 10));
        this.f6021D.setText(this.f6046ac);
        this.f6021D.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }

    /* renamed from: c */
    public String m5778c() {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        C1786r.m6061b("toDay=" + str, getClass().getSimpleName());
        return str;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onStart();
        m5755n();
        m5759p();
        m5749k();
    }

    /* renamed from: k */
    private void m5749k() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5751l() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f6019B.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5753m() {
        if (!this.f6019B.getText().toString().equals(C1789u.m6075a().getString("Push Name", "")) || !this.f6020C.getText().toString().equals(C1789u.m6075a().getString("status_message", ""))) {
            if (this.f6019B.getText().toString().replaceAll(" ", "").replaceAll("\n", "").trim().length() >= 1) {
                this.f6029L = true;
            }
        } else {
            this.f6029L = false;
        }
        invalidateOptionsMenu();
    }

    /* renamed from: n */
    private void m5755n() throws Resources.NotFoundException {
        this.f6024G = C1789u.m6075a().getString("msisdn", "");
        MyPageFragment.m5582a(this.f6021D);
    }

    /* renamed from: o */
    private void m5756o() {
        this.f6018A.setOnClickListener(new ViewOnClickListenerC1689cl(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m5759p() {
        C1786r.m6066e("UserProfile initialize() - img status: " + C1789u.m6075a().getString("profile_image_status", ""), "UserProfileDetail");
        if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
            File file = new File(this.f6074u, "myprofile.png_");
            C1786r.m6061b("photoFile=" + file, getClass().getSimpleName());
            if (file.exists()) {
                new AsyncTaskC1674bx(this, file).execute(new Void[0]);
                return;
            } else {
                m5762r();
                return;
            }
        }
        m5762r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m5761q() throws IOException {
        int i;
        try {
            if (!this.f6073t.canRead()) {
                this.f6073t.mkdirs();
            }
            m5765s();
            this.f6076w = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f6075v = new File(this.f6073t + "/", this.f6076w);
            this.f6073t.mkdir();
            C1786r.m6061b("[Create File] " + this.f6073t.toString() + this.f6076w + " : " + this.f6075v.createNewFile(), this.f6070q);
            this.f6027J = Uri.fromFile(this.f6075v);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (this.f6056am == null) {
                    this.f6056am = Toast.makeText(this.f6028K, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f6056am.show();
            } else {
                if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
                    i = R.array.selphoto;
                } else {
                    i = R.array.selphoto_first;
                }
                new AlertDialogBuilderC2120a(this.f6028K).setTitle(R.string.select_photo).setItems(i, new DialogInterfaceOnClickListenerC1675by(this)).setNeutralButton(R.string.cancel, (DialogInterface.OnClickListener) null).create().show();
            }
        } catch (IOException e) {
            C1786r.m6056a(e, UserProfileDetail.class.getSimpleName());
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    if (new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath()).length() <= 0) {
                        C1786r.m6054a("Crop return null!", this.f6070q);
                        break;
                    } else {
                        try {
                            C1791w.m6092a(C1791w.m6093a(Bitmap.createScaledBitmap(C1791w.m6100b(this, Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true)), "/profile/", this.f6076w);
                            if (this.f6026I && this.f6075v.length() > 1000000) {
                                File fileM6094a = C1791w.m6094a(this, this.f6075v);
                                if (fileM6094a != null) {
                                    this.f6079z.m2964a(fileM6094a.getPath());
                                    this.f6022E.show();
                                }
                            } else {
                                this.f6079z.m2964a(this.f6075v.getPath());
                                this.f6022E.show();
                            }
                            break;
                        } catch (Exception e) {
                            C1786r.m6056a(e, getClass().getSimpleName());
                            m5762r();
                            break;
                        }
                    }
                }
                break;
            case 5:
                if (intent == null) {
                    C1786r.m6061b("Crop Return is NULL", getClass().getSimpleName());
                    return;
                }
                this.f6027J = intent.getData();
                Intent intent2 = new Intent(this, (Class<?>) ImageModify.class);
                intent2.setDataAndType(this.f6027J, "image/*");
                intent2.putExtra("outputX", 600);
                intent2.putExtra("outputY", 600);
                intent2.putExtra("aspectX", 1);
                intent2.putExtra("aspectY", 1);
                intent2.putExtra("return-data", true);
                startActivityForResult(intent2, 3);
                this.f6030M = true;
                break;
            case 6:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f6028K, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f6027J, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 3);
                    this.f6030M = true;
                    break;
                } else {
                    C1786r.m6061b("Camera Return is NULL", getClass().getSimpleName());
                    return;
                }
            case 7:
                if (i2 == -1) {
                    this.f6029L = true;
                    break;
                }
                break;
        }
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m5762r() {
        try {
            this.f6018A.setImageBitmap(C1746bb.m5940a(this.f6028K, R.drawable.mypage_noimage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialogC1806j progressDialogC1806j = new ProgressDialogC1806j(this);
                progressDialogC1806j.setMessage(getString(R.string.dialog_connecting_server));
                progressDialogC1806j.setIndeterminate(true);
                progressDialogC1806j.setCancelable(false);
                return progressDialogC1806j;
            default:
                return null;
        }
    }

    /* renamed from: s */
    private void m5765s() {
        if (!m5779d() || !m5780e()) {
            C1786r.m6054a("[deleteTempFolder] External Storage Is Not Available or Writable!", this.f6070q);
            if (this.f6056am == null) {
                this.f6056am = Toast.makeText(this.f6028K, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f6056am.show();
            return;
        }
        String strM6003b = C1767bw.m6003b();
        if (strM6003b.length() == 0) {
            this.f6056am.show();
            return;
        }
        try {
            String[] list = new File(strM6003b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C1786r.m6061b("[Delete File] " + strM6003b + "/profile/" + str + " : " + new File(strM6003b + "/profile/" + str).delete(), this.f6070q);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    protected boolean m5779d() {
        m5767t();
        return this.f6077x;
    }

    /* renamed from: e */
    protected boolean m5780e() {
        m5767t();
        return this.f6078y;
    }

    /* renamed from: t */
    private void m5767t() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f6077x = true;
            this.f6078y = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f6077x = true;
            this.f6078y = false;
        } else {
            this.f6077x = false;
            this.f6078y = false;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.clear();
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.removeItem(R.id.actionbar_title_next);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f6030M) {
            menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
            return true;
        }
        if (this.f6029L || this.f6048ae || this.f6049af) {
            menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        } else {
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                break;
            case R.id.actionbar_title_done /* 2131494130 */:
                this.f6072s = true;
                C0107h c0107h = new C0107h();
                m5751l();
                if (!TextUtils.isEmpty(this.f6019B.getText().toString())) {
                    c0107h.m683a(this.f6019B.getText().toString());
                    if (C1786r.m6058a(this.f6020C.getText().toString())) {
                        this.f6020C.setText("");
                        C1786r.m6051a(1);
                        Toast.makeText(this.f6028K, "Log On", 1).show();
                        break;
                    } else {
                        if (this.f6020C.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() <= 0) {
                            c0107h.m685b("");
                        } else {
                            c0107h.m685b(this.f6020C.getText().toString());
                        }
                        if (this.f6032O != this.f6037T.isChecked()) {
                            C1786r.m6061b("Raghavendra exit 8", getClass().getSimpleName());
                            this.f6036S = new C0633e(this.f6053aj);
                            this.f6036S.m2870b(this.f6037T.isChecked());
                        }
                        this.f6061e = this.f6041X.isChecked();
                        if (this.f6061e) {
                            C1786r.m6061b("Raghavendra exit 10", getClass().getSimpleName());
                            this.f6043Z = m5774a(this.f6031N, c0107h);
                        } else {
                            C1786r.m6061b("Raghavendra exit 11", getClass().getSimpleName());
                            this.f6043Z = m5774a("DONT", c0107h);
                        }
                        this.f6079z.m2963a(c0107h, this.f6043Z);
                        f6017a++;
                        this.f6022E.show();
                        break;
                    }
                } else {
                    Toast.makeText(this.f6028K, R.string.regist_enter_push_name, 0).show();
                    break;
                }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    protected String m5774a(String str, C0107h c0107h) {
        C1786r.m6061b("[sendBirthday] mBirthDay=" + this.f6045ab, getClass().getSimpleName());
        C1789u.m6075a().getString("birthday_type", "");
        C1789u.m6075a().getString("birthday", "");
        C1789u.m6075a().getBoolean("birthday_year_show", false);
        if ("FULL".equals(str)) {
            this.f6035R = true;
            c0107h.m687c(this.f6045ab);
            return "FULL";
        }
        if ("SHORT".equals(str)) {
            this.f6035R = true;
            c0107h.m687c(this.f6045ab);
            return "SHORT";
        }
        this.f6035R = false;
        c0107h.m687c(this.f6045ab);
        return "DONT";
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        C1786r.m6066e("onDestroy", getClass().getSimpleName());
        if (this.f6036S != null) {
            this.f6036S.m2879e();
        }
        super.onDestroy();
    }
}
