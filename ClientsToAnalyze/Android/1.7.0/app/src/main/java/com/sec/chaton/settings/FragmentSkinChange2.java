package com.sec.chaton.settings;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1301ax;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import com.sec.widget.HorizontalListView;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class FragmentSkinChange2 extends Fragment {

    /* renamed from: A */
    private static BitmapDrawable f3518A;

    /* renamed from: B */
    private static final String[] f3519B = {"skin_add", "pad_chat_bg_01", "skin_bg_02", "skin_bg_03", "skin_bg_04", "skin_bg_05", "skin_bg_06", "skin_bg_07", "skin_bg_08", "skin_bg_09"};

    /* renamed from: C */
    private static final String[] f3520C = {"skin_add", "skin_myskin.png_", "pad_chat_bg_01", "skin_bg_02", "skin_bg_03", "skin_bg_04", "skin_bg_05", "skin_bg_06", "skin_bg_07", "skin_bg_08", "skin_bg_09"};

    /* renamed from: D */
    private static final String[] f3521D = {"bubble_01", "bubble_02", "bubble_03", "bubble_04", "bubble_05", "bubble_06"};

    /* renamed from: z */
    private static BitmapDrawable f3522z;

    /* renamed from: N */
    private View f3532N;

    /* renamed from: j */
    private String f3545j;

    /* renamed from: k */
    private String f3546k;

    /* renamed from: l */
    private String f3547l;

    /* renamed from: m */
    private ImageView f3548m;

    /* renamed from: n */
    private LinearLayout f3549n;

    /* renamed from: o */
    private LinearLayout f3550o;

    /* renamed from: p */
    private GeneralHeaderView f3551p;

    /* renamed from: q */
    private Gallery f3552q;

    /* renamed from: r */
    private HorizontalListView f3553r;

    /* renamed from: s */
    private HorizontalListView f3554s;

    /* renamed from: t */
    private C1060cd f3555t;

    /* renamed from: u */
    private File f3556u;

    /* renamed from: v */
    private File f3557v;

    /* renamed from: w */
    private Uri f3558w;

    /* renamed from: x */
    private int f3559x;

    /* renamed from: y */
    private int f3560y;

    /* renamed from: h */
    private final int f3543h = 0;

    /* renamed from: i */
    private final int f3544i = 2;

    /* renamed from: E */
    private BitmapDrawable f3523E = null;

    /* renamed from: F */
    private BitmapDrawable f3524F = null;

    /* renamed from: G */
    private BitmapDrawable f3525G = null;

    /* renamed from: H */
    private BitmapDrawable f3526H = null;

    /* renamed from: I */
    private BitmapDrawable f3527I = null;

    /* renamed from: J */
    private BitmapDrawable f3528J = null;

    /* renamed from: K */
    private BitmapDrawable f3529K = null;

    /* renamed from: L */
    private BitmapDrawable f3530L = null;

    /* renamed from: M */
    private BitmapDrawable f3531M = null;

    /* renamed from: O */
    private Toast f3533O = null;

    /* renamed from: P */
    private String f3534P = "";

    /* renamed from: Q */
    private String f3535Q = "";

    /* renamed from: a */
    AdapterView.OnItemClickListener f3536a = new C1083o(this);

    /* renamed from: b */
    AdapterView.OnItemSelectedListener f3537b = new C1079k(this);

    /* renamed from: c */
    AdapterView.OnItemSelectedListener f3538c = new C1080l(this);

    /* renamed from: d */
    AdapterView.OnItemClickListener f3539d = new C1077i(this);

    /* renamed from: e */
    AdapterView.OnItemLongClickListener f3540e = new C1078j(this);

    /* renamed from: f */
    AdapterView.OnItemClickListener f3541f = new C1075g(this);

    /* renamed from: g */
    AdapterView.OnItemClickListener f3542g = new C1076h(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments.containsKey("change_mode")) {
            this.f3534P = arguments.getString("change_mode");
        }
        if (C1327bw.m4595a()) {
            this.f3556u = new File(GlobalApplication.m3105f().getExternalFilesDir(null).getAbsolutePath() + "/skins/");
        } else {
            this.f3556u = null;
        }
        this.f3523E = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.pad_chat_bg_01));
        this.f3523E.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3524F = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_02));
        this.f3524F.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3525G = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_03));
        this.f3525G.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3526H = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_04));
        this.f3526H.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3527I = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_05));
        this.f3527I.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3528J = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_06));
        this.f3528J.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3529K = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_07));
        this.f3529K.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3530L = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_08));
        this.f3530L.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3531M = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_09));
        this.f3531M.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        BaseActivity.m2043b(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3532N = layoutInflater.inflate(R.layout.layout_change_skin2, viewGroup, false);
        this.f3551p = (GeneralHeaderView) this.f3532N.findViewById(R.id.header);
        if (this.f3551p != null) {
            this.f3551p.setButtonClickListener(new ViewOnClickListenerC1082n(this));
            if (this.f3534P.equals("change_background")) {
                this.f3551p.setText(getString(R.string.settings_change_background));
            } else {
                this.f3551p.setText(getString(R.string.settings_change_bubble));
            }
        }
        this.f3548m = (ImageView) this.f3532N.findViewById(R.id.change_skin_bg);
        if (this.f3532N.findViewById(R.id.lLayoutSndContent) != null) {
            this.f3549n = (LinearLayout) this.f3532N.findViewById(R.id.lLayoutSndContent);
        }
        if (this.f3532N.findViewById(R.id.lLayoutSndContent) != null) {
            this.f3550o = (LinearLayout) this.f3532N.findViewById(R.id.textRecvContent);
        }
        this.f3552q = (Gallery) this.f3532N.findViewById(R.id.list_bg_horizontal);
        this.f3553r = (HorizontalListView) this.f3532N.findViewById(R.id.list_bubble_horizontal_send);
        this.f3554s = (HorizontalListView) this.f3532N.findViewById(R.id.list_bubble_horizontal_receive);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3552q.getLayoutParams();
        this.f3552q.getLayoutParams();
        marginLayoutParams.setMargins(-((displayMetrics.widthPixels / 2) + 70), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        if (this.f3534P.equals("change_background")) {
            this.f3552q.setVisibility(0);
            this.f3553r.setVisibility(8);
            this.f3554s.setVisibility(8);
        } else {
            this.f3552q.setVisibility(8);
            this.f3553r.setVisibility(0);
            this.f3554s.setVisibility(0);
        }
        return this.f3532N;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f3555t = null;
        this.f3545j = C1323bs.m4575a().getString("setting_change_skin", "pad_chat_bg_01");
        this.f3546k = C1323bs.m4575a().getString("setting_change_bubble_send", "bubble_01");
        this.f3547l = C1323bs.m4575a().getString("setting_change_bubble_receive", "bubble_01");
        if (bundle != null) {
            if (bundle.containsKey("setting_change_skin")) {
                this.f3545j = bundle.getString("setting_change_skin");
            }
            if (bundle.containsKey("setting_change_bubble_send")) {
                this.f3546k = bundle.getString("setting_change_bubble_send");
            }
            if (bundle.containsKey("setting_change_bubble_receive")) {
                this.f3547l = bundle.getString("setting_change_bubble_receive");
            }
            if (bundle.containsKey("new_skin_filename")) {
                this.f3535Q = bundle.getString("new_skin_filename");
            }
        }
        if (this.f3545j.equals("skin_myskin.png_")) {
            m3865b();
        } else {
            this.f3548m.setBackgroundDrawable(m3855a(this.f3545j));
        }
        if (this.f3549n != null) {
            this.f3549n.setBackgroundResource(m3866c(this.f3546k));
        }
        if (this.f3550o != null) {
            this.f3550o.setBackgroundResource(m3870d(this.f3547l));
        }
        C1029b c1029b = new C1029b(this, getActivity(), f3521D, "send_bubble");
        C1029b c1029b2 = new C1029b(this, getActivity(), f3521D, "receive_bubble");
        if (this.f3556u != null) {
            File file = new File(this.f3556u, "skin_myskin.png_");
            if (file.exists() && file.length() > 0) {
                this.f3555t = new C1060cd(this, getActivity(), f3520C);
            } else {
                this.f3555t = new C1060cd(this, getActivity(), f3519B);
            }
        } else {
            this.f3555t = new C1060cd(this, getActivity(), f3519B);
        }
        this.f3552q.setAdapter((SpinnerAdapter) this.f3555t);
        this.f3553r.setAdapter((ListAdapter) c1029b);
        this.f3554s.setAdapter((ListAdapter) c1029b2);
        this.f3552q.setOnItemClickListener(this.f3539d);
        this.f3553r.setOnItemClickListener(this.f3541f);
        this.f3553r.setOnItemSelectedListener(this.f3537b);
        this.f3554s.setOnItemClickListener(this.f3542g);
        this.f3554s.setOnItemSelectedListener(this.f3538c);
        this.f3552q.setSelected(false);
        this.f3552q.setSelection(2);
        this.f3552q.setFocusableInTouchMode(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m3859a();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f3560y == 0 || this.f3559x == 0) {
            m3859a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f3518A = null;
        f3522z = null;
    }

    /* renamed from: a */
    private void m3859a() {
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        this.f3559x = windowManager.getDefaultDisplay().getWidth();
        this.f3560y = windowManager.getDefaultDisplay().getHeight();
        C1341p.m4658b("1. windows size=width:" + this.f3559x + " height:" + this.f3560y, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("setting_change_skin", this.f3545j);
        bundle.putString("setting_change_bubble_send", this.f3546k);
        bundle.putString("setting_change_bubble_receive", this.f3547l);
        bundle.putString("new_skin_filename", this.f3535Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public BitmapDrawable m3855a(String str) {
        if (str.equals("pad_chat_bg_01")) {
            return this.f3523E;
        }
        if (str.equals("skin_bg_02")) {
            return this.f3524F;
        }
        if (str.equals("skin_bg_03")) {
            return this.f3525G;
        }
        if (str.equals("skin_bg_04")) {
            return this.f3526H;
        }
        if (str.equals("skin_bg_05")) {
            return this.f3527I;
        }
        if (str.equals("skin_bg_06")) {
            return this.f3528J;
        }
        if (str.equals("skin_bg_07")) {
            return this.f3529K;
        }
        if (str.equals("skin_bg_08")) {
            return this.f3530L;
        }
        if (str.equals("skin_bg_09")) {
            return this.f3531M;
        }
        return this.f3523E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3865b() {
        Configuration configuration = getResources().getConfiguration();
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        if (configuration.orientation == 2) {
            Bitmap bitmapM4496a = C1294aq.m4496a(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C1301ax.m4544a(59.0f));
            if (bitmapM4496a == null) {
                this.f3548m.setBackgroundDrawable(this.f3523E);
                return;
            } else {
                this.f3548m.setImageBitmap(bitmapM4496a);
                return;
            }
        }
        Bitmap bitmapM4510b = C1294aq.m4510b(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C1301ax.m4544a(59.0f));
        if (bitmapM4510b == null) {
            this.f3548m.setBackgroundDrawable(this.f3523E);
        } else {
            this.f3548m.setImageBitmap(bitmapM4510b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public BitmapDrawable m3863b(String str) {
        if (str.equals("pad_chat_bg_01")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_01));
        }
        if (str.equals("skin_bg_02")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_02));
        }
        if (str.equals("skin_bg_03")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_03));
        }
        if (str.equals("skin_bg_04")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_04));
        }
        if (str.equals("skin_bg_05")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_05));
        }
        if (str.equals("skin_bg_06")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_06));
        }
        if (str.equals("skin_bg_07")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_07));
        }
        if (str.equals("skin_bg_08")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_08));
        }
        if (str.equals("skin_bg_09")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_09));
        }
        if (str.equals("skin_myskin.png_")) {
            try {
                if (C1327bw.m4595a() && this.f3556u != null) {
                    if (f3522z == null) {
                        f3522z = new BitmapDrawable(C1294aq.m4511b(getActivity(), Uri.parse(this.f3556u + "/" + str)));
                    }
                    return f3522z;
                }
                return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thum_skin_bg_default));
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getSimpleName());
            }
        }
        if (str.equals("skin_add")) {
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thum_skin_bg_default));
        }
        return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thum_skin_bg_default));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m3866c(String str) {
        if (str.equals("bubble_01")) {
            return R.drawable.bubble_send_01_normal;
        }
        if (str.equals("bubble_02")) {
            return R.drawable.bubble_send_02_normal;
        }
        if (str.equals("bubble_03")) {
            return R.drawable.bubble_send_03_normal;
        }
        if (str.equals("bubble_04")) {
            return R.drawable.bubble_send_04_normal;
        }
        if (str.equals("bubble_05")) {
            return R.drawable.bubble_send_05_normal;
        }
        return str.equals("bubble_06") ? R.drawable.bubble_send_06_normal : R.drawable.bubble_send_01_normal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m3870d(String str) {
        if (str.equals("bubble_01")) {
            return R.drawable.bubble_receive_01_normal;
        }
        if (str.equals("bubble_02")) {
            return R.drawable.bubble_receive_02_normal;
        }
        if (str.equals("bubble_03")) {
            return R.drawable.bubble_receive_03_normal;
        }
        if (str.equals("bubble_04")) {
            return R.drawable.bubble_receive_04_normal;
        }
        if (str.equals("bubble_05")) {
            return R.drawable.bubble_receive_05_normal;
        }
        return str.equals("bubble_06") ? R.drawable.bubble_receive_06_normal : R.drawable.bubble_receive_01_normal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public int m3872e(String str) {
        if (str.equals("bubble_01")) {
            return R.drawable.thumb_bubble_01;
        }
        if (str.equals("bubble_02")) {
            return R.drawable.thumb_bubble_03;
        }
        if (str.equals("bubble_03")) {
            return R.drawable.thumb_bubble_05;
        }
        if (str.equals("bubble_04")) {
            return R.drawable.thumb_bubble_07;
        }
        if (str.equals("bubble_05")) {
            return R.drawable.thumb_bubble_11;
        }
        return str.equals("bubble_06") ? R.drawable.thumb_bubble_09 : R.drawable.thumb_bubble_01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public int m3876f(String str) {
        if (str.equals("bubble_01")) {
            return R.drawable.thumb_bubble_02;
        }
        if (str.equals("bubble_02")) {
            return R.drawable.thumb_bubble_04;
        }
        if (str.equals("bubble_03")) {
            return R.drawable.thumb_bubble_06;
        }
        if (str.equals("bubble_04")) {
            return R.drawable.thumb_bubble_08;
        }
        if (str.equals("bubble_05")) {
            return R.drawable.thumb_bubble_12;
        }
        return str.equals("bubble_06") ? R.drawable.thumb_bubble_10 : R.drawable.thumb_bubble_02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3861a(File file) throws IOException {
        try {
            if (!file.exists()) {
                file.mkdir();
            }
            this.f3557v = null;
            this.f3557v = new File(this.f3556u, "skin_myskin.png_");
            this.f3557v.createNewFile();
            this.f3558w = Uri.fromFile(this.f3557v);
            this.f3535Q = this.f3557v.getName();
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (this.f3533O == null) {
                    this.f3533O = C1619g.m5889a(getActivity(), getString(R.string.toast_sdcard_amount), 1);
                }
                this.f3533O.show();
            } else {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                startActivityForResult(intent, 2);
            }
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            C1341p.m4658b("Gallery Return is NULL", getClass().getSimpleName());
        }
        switch (i) {
            case 0:
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C1294aq.m4512b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), this.f3560y), this.f3559x, this.f3560y, true);
                    C1294aq.m4505a(C1294aq.m4506a(bitmapCreateScaledBitmap), "/skins/", this.f3535Q);
                    this.f3548m.setImageBitmap(bitmapCreateScaledBitmap);
                    this.f3545j = "skin_myskin.png_";
                    f3522z = null;
                    if (this.f3555t.getCount() == f3519B.length) {
                        this.f3555t.m3952a(f3520C);
                    }
                    this.f3555t.notifyDataSetChanged();
                    break;
                } catch (Exception e) {
                    C1341p.m4653a(e, getClass().getSimpleName());
                    return;
                }
            case 2:
                C1341p.m4658b("2. windows size=width:" + this.f3559x + " height:" + this.f3560y, getClass().getSimpleName());
                this.f3558w = intent.getData();
                Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                intent2.setDataAndType(this.f3558w, "image/*");
                intent2.putExtra("outputX", this.f3559x);
                intent2.putExtra("outputY", this.f3560y);
                intent2.putExtra("aspectX", 2);
                intent2.putExtra("aspectY", 3);
                intent2.putExtra("return-data", true);
                startActivityForResult(intent2, 0);
                break;
        }
    }
}
