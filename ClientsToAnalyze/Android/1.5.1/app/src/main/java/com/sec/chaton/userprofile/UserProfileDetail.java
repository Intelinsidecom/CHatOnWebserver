package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.HomeTabFragment;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.control.ProfileControl;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.chaton.widget.SMSProgressBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class UserProfileDetail extends BaseActivity implements HomeTabFragment.OnTabChangeListener {

    /* renamed from: A */
    private TextView f3383A;

    /* renamed from: B */
    private TextView f3384B;

    /* renamed from: C */
    private RelativeLayout f3385C;

    /* renamed from: D */
    private RelativeLayout f3386D;

    /* renamed from: E */
    private ProgressDialog f3387E;

    /* renamed from: F */
    private View f3388F;

    /* renamed from: G */
    private View f3389G;

    /* renamed from: H */
    private TextView f3390H;

    /* renamed from: I */
    private FacebookManager f3391I;

    /* renamed from: J */
    private String f3392J;

    /* renamed from: K */
    private String f3393K;

    /* renamed from: L */
    private String f3394L;

    /* renamed from: M */
    private String f3395M;

    /* renamed from: N */
    private boolean f3396N;

    /* renamed from: O */
    private boolean f3397O;

    /* renamed from: P */
    private boolean f3398P;

    /* renamed from: Q */
    private Uri f3399Q;

    /* renamed from: R */
    private InputMethodManager f3400R;

    /* renamed from: S */
    private String f3401S;

    /* renamed from: T */
    private boolean f3402T;

    /* renamed from: U */
    private LinearLayout f3403U;

    /* renamed from: V */
    private Handler f3404V;

    /* renamed from: W */
    private FacebookManager.OnResultListener f3405W;

    /* renamed from: X */
    private View.OnClickListener f3406X;

    /* renamed from: e */
    String f3411e;

    /* renamed from: f */
    Context f3412f;

    /* renamed from: g */
    SharedPreferences.OnSharedPreferenceChangeListener f3413g;

    /* renamed from: n */
    private File f3420n;

    /* renamed from: o */
    private File f3421o;

    /* renamed from: p */
    private File f3422p;

    /* renamed from: q */
    private String f3423q;

    /* renamed from: r */
    private int f3424r;

    /* renamed from: s */
    private int f3425s;

    /* renamed from: t */
    private boolean f3426t;

    /* renamed from: u */
    private boolean f3427u;

    /* renamed from: v */
    private Calendar f3428v;

    /* renamed from: w */
    private ProfileControl f3429w;

    /* renamed from: x */
    private ImageButton f3430x;

    /* renamed from: y */
    private TextView f3431y;

    /* renamed from: z */
    private TextView f3432z;

    /* renamed from: h */
    private SimpleDateFormat f3414h = new SimpleDateFormat("MM-dd");

    /* renamed from: a */
    SimpleDateFormat f3407a = new SimpleDateFormat("MM-dd");

    /* renamed from: b */
    SimpleDateFormat f3408b = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    /* renamed from: c */
    SimpleDateFormat f3409c = new SimpleDateFormat("MM dd, yyyy");

    /* renamed from: d */
    SimpleDateFormat f3410d = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: i */
    private final int f3415i = 0;

    /* renamed from: j */
    private final int f3416j = 1;

    /* renamed from: k */
    private final int f3417k = 2;

    /* renamed from: l */
    private final int f3418l = 3;

    /* renamed from: m */
    private final int f3419m = 4;

    public UserProfileDetail() {
        this.f3411e = StorageStateInfoUtil.m3677a() ? GlobalApplication.m2386d().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
        this.f3420n = new File(this.f3411e + "/profile/");
        this.f3421o = GlobalApplication.m2387e().getFilesDir().getAbsoluteFile();
        this.f3423q = "";
        this.f3426t = false;
        this.f3427u = false;
        this.f3428v = Calendar.getInstance();
        this.f3396N = true;
        this.f3397O = false;
        this.f3398P = true;
        this.f3402T = false;
        this.f3413g = new SharedPreferencesOnSharedPreferenceChangeListenerC0554ah(this);
        this.f3404V = new HandlerC0557ak(this);
        this.f3405W = new C0556aj(this);
        this.f3406X = new ViewOnClickListenerC0555ai(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static File m3351a(Context context, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream3;
        File file2;
        int i;
        int i2;
        try {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream3);
                    int width = bitmapDecodeStream.getWidth();
                    int height = bitmapDecodeStream.getHeight();
                    if (width <= 1024 && height <= 768) {
                        i = width;
                        i2 = height;
                    } else if (width * 768 > height * 1024) {
                        i2 = (height * 1024) / width;
                        i = 1024;
                    } else {
                        i = (width * 768) / height;
                        i2 = 768;
                    }
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, i, i2, true);
                    File file3 = new File(context.getCacheDir(), "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
                    FileOutputStream fileOutputStream4 = new FileOutputStream(file3);
                    if (bitmapCreateScaledBitmap != null) {
                        try {
                            if (bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream4)) {
                                if (fileInputStream3 != null) {
                                    try {
                                        fileInputStream3.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                        return null;
                                    }
                                }
                                if (fileOutputStream4 != null) {
                                    try {
                                        fileOutputStream4.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                        return null;
                                    }
                                }
                                return file3;
                            }
                        } catch (FileNotFoundException e3) {
                            fileInputStream2 = fileInputStream3;
                            fileOutputStream3 = fileOutputStream4;
                            ChatONLogWriter.m3499a("FileNotFoundException", context.getClass().getName());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            file2 = 0;
                            return file2;
                        } catch (Exception e6) {
                            fileInputStream2 = fileInputStream3;
                            fileOutputStream2 = fileOutputStream4;
                            ChatONLogWriter.m3499a("Exception", context.getClass().getName());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            file2 = 0;
                            return file2;
                        } catch (Throwable th) {
                            fileInputStream = fileInputStream3;
                            th = th;
                            fileOutputStream = fileOutputStream4;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            throw th;
                        }
                    }
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                            return null;
                        }
                    }
                    if (fileOutputStream4 != null) {
                        try {
                            fileOutputStream4.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                            return null;
                        }
                    }
                    return null;
                } catch (FileNotFoundException e13) {
                    fileInputStream2 = fileInputStream3;
                    fileOutputStream3 = null;
                } catch (Exception e14) {
                    fileInputStream2 = fileInputStream3;
                    fileOutputStream2 = null;
                } catch (Throwable th2) {
                    fileInputStream = fileInputStream3;
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (FileNotFoundException e15) {
                fileOutputStream3 = null;
                fileInputStream2 = null;
            } catch (Exception e16) {
                fileOutputStream2 = null;
                fileInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = null;
            }
        } catch (Throwable th4) {
            fileInputStream = fileInputStream2;
            fileOutputStream = file2;
            th = th4;
        }
    }

    /* renamed from: a */
    public static String m3354a(String str) throws NumberFormatException {
        String str2;
        ChatONLogWriter.m3506b("org birthday=" + str, "UserProfileDetail.changeDateFormat");
        try {
            if (str.length() == 10) {
                Integer.parseInt(str.substring(0, 4));
                str2 = str.substring(8, 10) + " " + new SimpleDateFormat("dd MMM, yyyy", Locale.US).format(new SimpleDateFormat("yyyy-MM-dd").parse(str)).substring(3, 12);
                ChatONLogWriter.m3506b("formattedDate=" + str2, "UserProfileDetail");
            } else {
                str2 = new SimpleDateFormat("dd MMM", Locale.US).format(new SimpleDateFormat("MM-dd").parse(str));
                ChatONLogWriter.m3506b("result=" + str2, "UserProfileDetail");
                ChatONLogWriter.m3506b("************* FORMATED BIRTHDAY : " + str2, null);
            }
            return str2;
        } catch (Exception e) {
            ChatONLogWriter.m3506b("************* FORMATED BIRTHDAY ERROR : " + e.toString(), null);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3358b(String str) {
        if (!this.f3391I.m2356b() || str == null) {
            this.f3390H.setText(C0062R.string.login);
            this.f3389G.setVisibility(8);
        } else {
            this.f3390H.setText(str);
            this.f3389G.setVisibility(0);
        }
    }

    /* renamed from: e */
    private void m3364e() {
        this.f3429w = new ProfileControl(this.f3404V);
        this.f3400R = (InputMethodManager) this.f3412f.getSystemService("input_method");
        ChatONLogWriter.m3506b("onCreateView...", getClass().getSimpleName());
        setContentView(C0062R.layout.layout_user_profile_detail);
        this.f3430x = (ImageButton) findViewById(C0062R.id.imgbtnUPPhoto);
        this.f3430x.requestFocus();
        this.f3431y = (TextView) findViewById(C0062R.id.user_Pno);
        this.f3403U = (LinearLayout) findViewById(C0062R.id.linear_profile_name);
        this.f3383A = (TextView) findViewById(C0062R.id.textPersonalName);
        this.f3384B = (TextView) findViewById(C0062R.id.dateDisplay);
        this.f3386D = (RelativeLayout) findViewById(C0062R.id.rlayoutBDay);
        this.f3385C = (RelativeLayout) findViewById(C0062R.id.rlayoutPhoneNumber);
        m3366f();
        m3372i();
        m3368g();
        this.f3388F = findViewById(C0062R.id.rlayout_facebook_account);
        this.f3389G = findViewById(C0062R.id.user_facebook_account_detail);
        this.f3390H = (TextView) findViewById(C0062R.id.user_facebook_account_id);
        if (this.f3391I == null) {
            this.f3391I = new FacebookManager(this, this.f3405W);
        }
        m3358b(this.f3391I.m2350a());
        this.f3388F.setOnClickListener(this.f3406X);
        Display defaultDisplay = ((WindowManager) this.f3412f.getSystemService("window")).getDefaultDisplay();
        ChatONLogWriter.m3506b("width:" + defaultDisplay.getWidth(), getClass().getSimpleName());
        ChatONLogWriter.m3506b("height:" + defaultDisplay.getHeight(), getClass().getSimpleName());
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if (width < 480 || height < 600) {
            this.f3424r = 350;
            this.f3425s = 350;
        } else {
            this.f3424r = 600;
            this.f3425s = 600;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3366f() {
        this.f3392J = ChatONPref.m3519a().getString("msisdn", "");
        this.f3393K = ChatONPref.m3519a().getString("Push Name", "");
        this.f3394L = ChatONPref.m3519a().getString("birthday", getResources().getString(C0062R.string.add_your_birthday));
        this.f3395M = ChatONPref.m3519a().getString("birthday_type", "");
        this.f3431y.setText("+" + this.f3392J);
        this.f3383A.setText(this.f3393K);
        if (this.f3383A.getText().length() > 0) {
            this.f3383A.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f3383A.setPadding(11, 10, 11, 20);
        }
        m3370h();
        if (ChatONPref.m3519a().getBoolean("show_phone_number_to_all", false)) {
            this.f3431y.setTextColor(getResources().getColor(C0062R.color.white));
        } else {
            this.f3431y.setTextColor(getResources().getColor(C0062R.color.gray2));
        }
    }

    /* renamed from: g */
    private void m3368g() {
        this.f3430x.setOnClickListener(new ViewOnClickListenerC0551ae(this));
        this.f3403U.setOnClickListener(new ViewOnClickListenerC0550ad(this));
        this.f3386D.setOnClickListener(new ViewOnClickListenerC0553ag(this));
        this.f3385C.setOnClickListener(new ViewOnClickListenerC0552af(this));
    }

    /* renamed from: h */
    private void m3370h() {
        new Date();
        if (this.f3395M.equals("FULL")) {
            try {
                this.f3410d.parse(this.f3394L);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.f3384B.setText(m3354a(this.f3394L));
            return;
        }
        if (!this.f3395M.equals("SHORT")) {
            if (this.f3394L.equals(getResources().getString(C0062R.string.add_your_birthday))) {
                this.f3384B.setText(getResources().getString(C0062R.string.add_your_birthday));
                return;
            } else {
                this.f3384B.setText(getResources().getString(C0062R.string.add_your_birthday));
                return;
            }
        }
        String[] strArrSplit = this.f3394L.split("-");
        String str = strArrSplit[1] + "-" + strArrSplit[2];
        try {
            this.f3414h.parse(str);
        } catch (ParseException e2) {
            ChatONLogWriter.m3501a(e2, getClass().getSimpleName());
        }
        this.f3384B.setText(m3354a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3372i() {
        ChatONLogWriter.m3511e("UserProfile initialize() - img status: " + ChatONPref.m3519a().getString("profile_image_status", ""), "UserProfileDetail");
        if (!ChatONPref.m3519a().getString("profile_image_status", "").equals("updated")) {
            m3376k();
            return;
        }
        File file = new File(this.f3421o, "myprofile.png_");
        ChatONLogWriter.m3506b("photoFile=" + file, getClass().getSimpleName());
        if (file.exists()) {
            new AsyncTaskC0549ac(this, file).execute(new Void[0]);
        } else {
            m3376k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3373j() {
        try {
            if (!this.f3420n.canRead()) {
                this.f3420n.mkdirs();
            }
            m3378l();
            this.f3423q = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f3422p = new File(this.f3420n + "/", this.f3423q);
            ChatONLogWriter.m3506b("[Create File] " + this.f3420n.toString() + this.f3423q + " : " + this.f3422p.createNewFile(), "UserProfileDetail");
            this.f3399Q = Uri.fromFile(this.f3422p);
            if ("mounted".equals(Environment.getExternalStorageState())) {
                new AlertDialog.Builder(this.f3412f).setIcon(C0062R.drawable.ic_dialog_menu_generic).setTitle(C0062R.string.select_photo).setItems(ChatONPref.m3519a().getString("profile_image_status", "").equals("updated") ? C0062R.array.selphoto : C0062R.array.selphoto_first, new DialogInterfaceOnClickListenerC0548ab(this)).create().show();
            } else {
                Toast.makeText(this.f3412f, getString(C0062R.string.toast_sdcard_amount), 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m3376k() {
        try {
            this.f3430x.setImageResource(C0062R.drawable.co_default_image_add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private void m3378l() {
        if (!m3383c() || !m3384d()) {
            ChatONLogWriter.m3499a("[deleteTempFolder] External Storage Is Not Available or Writable!", "UserProfileDetail");
            return;
        }
        String[] list = new File(ChatOnGraphics.f3636b).list();
        if (list != null) {
            for (String str : list) {
                ChatONLogWriter.m3506b("[Delete File] " + ChatOnGraphics.f3636b + str + " : " + new File(ChatOnGraphics.f3636b + str).delete(), "UserProfileDetail");
            }
        }
    }

    /* renamed from: m */
    private void m3379m() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f3426t = true;
            this.f3427u = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f3426t = true;
            this.f3427u = false;
        } else {
            this.f3426t = false;
            this.f3427u = false;
        }
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: a */
    public void mo390a() {
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: b */
    public void mo391b() {
    }

    /* renamed from: c */
    protected boolean m3383c() {
        m3379m();
        return this.f3426t;
    }

    /* renamed from: d */
    protected boolean m3384d() {
        m3379m();
        return this.f3427u;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        this.f3391I.m2352a(i, i2, intent);
        System.gc();
        switch (i) {
            case 3:
                if (i2 == -1) {
                    if (new File(ChatOnGraphics.f3636b + "/" + this.f3423q).length() <= 0) {
                        ChatONLogWriter.m3499a("Crop return null!", "UserProfileDetail");
                        break;
                    } else {
                        try {
                            this.f3397O = true;
                            if (!this.f3398P || this.f3422p.length() <= 1000000) {
                                this.f3429w.m2066a(this.f3422p.getPath());
                                this.f3387E.show();
                            } else {
                                File fileM3536a = ChatOnGraphics.m3536a(this.f3412f, this.f3422p);
                                if (fileM3536a != null) {
                                    this.f3429w.m2066a(fileM3536a.getPath());
                                    this.f3387E.show();
                                }
                            }
                            break;
                        } catch (Exception e) {
                            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                            m3376k();
                            return;
                        }
                    }
                }
                break;
            case 4:
                if (new File(ChatOnGraphics.f3636b + "/" + this.f3423q).length() > 0) {
                    Intent intent2 = new Intent("com.android.camera.action.CROP");
                    intent2.setDataAndType(this.f3399Q, "image/*");
                    intent2.putExtra("outputX", this.f3424r);
                    intent2.putExtra("outputY", this.f3425s);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("scale", true);
                    intent2.putExtra("return-data", false);
                    intent2.putExtra("output", this.f3399Q);
                    intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                    startActivityForResult(intent2, 3);
                    break;
                } else {
                    ChatONLogWriter.m3499a("Camera capture is fail!", "UserProfileDetail");
                    break;
                }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3412f = this;
        this.f3387E = (ProgressDialog) new SMSProgressBar(this.f3412f).onCreate(C0062R.string.dialog_userprofile_updating);
        m3364e();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(C0062R.string.dialog_connecting_server));
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                return progressDialog;
            default:
                return null;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatONPref.m3519a().unregisterOnSharedPreferenceChangeListener(this.f3413g);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatONPref.m3519a().registerOnSharedPreferenceChangeListener(this.f3413g);
        ChatONLogWriter.m3506b("onResume:isTake=" + this.f3397O, getClass().getSimpleName());
        m3364e();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }
}
