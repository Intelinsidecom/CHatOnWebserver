package com.sec.chaton.settings;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.multimedia.skin.C1012j;
import com.sec.chaton.multimedia.skin.p037b.C1002c;
import com.sec.chaton.util.C1722ae;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1769by;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1791w;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.SkinSettingPanel;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class FragmentSkinChange2 extends Fragment implements InterfaceC1256bh, InterfaceC1258bj, InterfaceC1260bl {

    /* renamed from: G */
    private static BitmapDrawable f4643G;

    /* renamed from: H */
    private static BitmapDrawable f4644H;

    /* renamed from: A */
    private Button f4645A;

    /* renamed from: B */
    private File f4646B;

    /* renamed from: C */
    private File f4647C;

    /* renamed from: D */
    private Uri f4648D;

    /* renamed from: E */
    private int f4649E;

    /* renamed from: F */
    private int f4650F;

    /* renamed from: J */
    private View f4652J;

    /* renamed from: L */
    private TextView f4654L;

    /* renamed from: T */
    private C1821b f4662T;

    /* renamed from: j */
    private String f4672j;

    /* renamed from: k */
    private String f4673k;

    /* renamed from: l */
    private String f4674l;

    /* renamed from: m */
    private String f4675m;

    /* renamed from: n */
    private ImageView f4676n;

    /* renamed from: o */
    private LinearLayout f4677o;

    /* renamed from: p */
    private LinearLayout f4678p;

    /* renamed from: t */
    private SkinSettingPanel f4682t;

    /* renamed from: u */
    private RelativeLayout f4683u;

    /* renamed from: v */
    private RelativeLayout f4684v;

    /* renamed from: w */
    private RelativeLayout f4685w;

    /* renamed from: x */
    private SkinSettingPanel f4686x;

    /* renamed from: y */
    private SkinSettingPanel f4687y;

    /* renamed from: z */
    private Button f4688z;

    /* renamed from: h */
    private final int f4670h = 0;

    /* renamed from: i */
    private final int f4671i = 2;

    /* renamed from: q */
    private String f4679q = null;

    /* renamed from: r */
    private String f4680r = null;

    /* renamed from: s */
    private String f4681s = null;

    /* renamed from: I */
    private BitmapDrawable f4651I = null;

    /* renamed from: K */
    private Toast f4653K = null;

    /* renamed from: M */
    private String f4655M = "";

    /* renamed from: N */
    private String f4656N = "";

    /* renamed from: O */
    private Menu f4657O = null;

    /* renamed from: P */
    private boolean f4658P = false;

    /* renamed from: Q */
    private LinkedHashMap f4659Q = null;

    /* renamed from: R */
    private LinkedHashMap f4660R = null;

    /* renamed from: S */
    private LinkedHashMap f4661S = null;

    /* renamed from: a */
    View.OnClickListener f4663a = new ViewOnClickListenerC1282cg(this);

    /* renamed from: b */
    View.OnFocusChangeListener f4664b = new ViewOnFocusChangeListenerC1283ch(this);

    /* renamed from: c */
    View.OnFocusChangeListener f4665c = new ViewOnFocusChangeListenerC1284ci(this);

    /* renamed from: d */
    View.OnFocusChangeListener f4666d = new ViewOnFocusChangeListenerC1285cj(this);

    /* renamed from: e */
    View.OnClickListener f4667e = new ViewOnClickListenerC1286ck(this);

    /* renamed from: f */
    View.OnClickListener f4668f = new ViewOnClickListenerC1287cl(this);

    /* renamed from: g */
    View.OnClickListener f4669g = new ViewOnClickListenerC1288cm(this);

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("change_mode")) {
            this.f4655M = arguments.getString("change_mode");
        }
        if (C1767bw.m6002a()) {
            this.f4646B = new File(GlobalApplication.m3256a().getExternalFilesDir(null).getAbsolutePath() + "/skins/");
        } else {
            this.f4646B = null;
        }
        this.f4662T = new C1821b(Executors.newFixedThreadPool(5, new ThreadFactoryC1281cf(this)));
        BaseActivity.m1829b(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4652J = layoutInflater.inflate(R.layout.layout_change_skin2, viewGroup, false);
        if (GlobalApplication.m3265f()) {
            this.f4676n = (ImageView) this.f4652J.findViewById(R.id.skin_preview);
        } else {
            this.f4676n = (ImageView) this.f4652J.findViewById(R.id.change_skin_bg);
            if (this.f4676n == null) {
                this.f4676n = (ImageView) this.f4652J.findViewById(R.id.skin_preview);
            }
        }
        if (this.f4652J.findViewById(R.id.lLayoutSndContent) != null) {
            this.f4677o = (LinearLayout) this.f4652J.findViewById(R.id.lLayoutSndContent);
        }
        if (this.f4652J.findViewById(R.id.lLayoutSndContent) != null) {
            this.f4678p = (LinearLayout) this.f4652J.findViewById(R.id.textRecvContent);
        }
        if (this.f4655M.equals("change_background")) {
            if (getActivity().getActionBar() != null) {
                getActivity().getActionBar().setTitle(getString(R.string.setting_background_style));
            }
        } else if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setTitle(getString(R.string.setting_bubble_style));
        }
        this.f4654L = (TextView) this.f4652J.findViewById(R.id.textDateSkin);
        this.f4654L.setText(C1769by.m6006a(System.currentTimeMillis(), "yyyy.MM.dd"));
        this.f4682t = (SkinSettingPanel) this.f4652J.findViewById(R.id.list_bg_horizontal);
        this.f4683u = (RelativeLayout) this.f4652J.findViewById(R.id.list_bubble_horizontal_send_parent);
        this.f4684v = (RelativeLayout) this.f4652J.findViewById(R.id.list_bubble_horizontal_receive_parent);
        this.f4685w = (RelativeLayout) this.f4652J.findViewById(R.id.list_bg_horizontal_parent);
        this.f4686x = (SkinSettingPanel) this.f4652J.findViewById(R.id.list_bubble_horizontal_send);
        this.f4687y = (SkinSettingPanel) this.f4652J.findViewById(R.id.list_bubble_horizontal_receive);
        if (this.f4652J.findViewById(R.id.setSkin) != null) {
            this.f4688z = (Button) this.f4652J.findViewById(R.id.setSkin);
            this.f4688z.setOnClickListener(this.f4663a);
        }
        if (this.f4652J.findViewById(R.id.btnCancel) != null) {
            this.f4645A = (Button) this.f4652J.findViewById(R.id.btnCancel);
            this.f4645A.setOnClickListener(this.f4663a);
        }
        if (this.f4655M.equals("change_background")) {
            this.f4682t.setVisibility(0);
            this.f4685w.setVisibility(0);
            this.f4686x.setVisibility(8);
            this.f4687y.setVisibility(8);
            this.f4683u.setVisibility(8);
            this.f4684v.setVisibility(8);
        } else {
            this.f4682t.setVisibility(8);
            this.f4685w.setVisibility(8);
            this.f4683u.setVisibility(0);
            this.f4684v.setVisibility(0);
            this.f4686x.setVisibility(0);
            this.f4687y.setVisibility(0);
        }
        return this.f4652J;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String string = C1789u.m6075a().getString("setting_change_skin", "skin_01");
        this.f4672j = string;
        this.f4679q = string;
        this.f4673k = C1789u.m6075a().getString("setting_change_skin_type", "pa");
        String string2 = C1789u.m6075a().getString("setting_change_bubble_send", "bubble_01");
        this.f4674l = string2;
        this.f4680r = string2;
        String string3 = C1789u.m6075a().getString("setting_change_bubble_receive", "bubble_01");
        this.f4675m = string3;
        this.f4681s = string3;
        if (bundle != null) {
            if (bundle.containsKey("setting_change_skin")) {
                this.f4672j = bundle.getString("setting_change_skin");
            }
            if (bundle.containsKey("setting_change_skin_type")) {
                this.f4673k = bundle.getString("setting_change_skin_type");
            }
            if (bundle.containsKey("setting_change_bubble_send")) {
                this.f4674l = bundle.getString("setting_change_bubble_send");
            }
            if (bundle.containsKey("setting_change_bubble_receive")) {
                this.f4675m = bundle.getString("setting_change_bubble_receive");
            }
            if (bundle.containsKey("new_skin_filename")) {
                this.f4656N = bundle.getString("new_skin_filename");
            }
            if (this.f4655M.equals("change_background")) {
                if (this.f4679q.equals(this.f4672j)) {
                    if (this.f4657O != null) {
                        this.f4657O.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                        this.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                    }
                } else if (this.f4657O != null) {
                    this.f4657O.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                    this.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                }
            } else {
                m4669e();
            }
        }
        m4676l();
        if (this.f4672j.equals("skin_myskin.png_")) {
            m4653n();
        } else {
            m4661a();
        }
        if (this.f4677o != null) {
            Drawable drawableM3950g = C1003c.m3950g(getActivity(), this.f4674l);
            if (drawableM3950g != null) {
                this.f4677o.setBackgroundDrawable(drawableM3950g);
            } else {
                this.f4677o.setBackgroundResource(R.drawable.bubble_send_01_normal);
            }
        }
        if (this.f4678p != null) {
            Drawable drawableM3952i = C1003c.m3952i(getActivity(), this.f4675m);
            if (drawableM3952i != null) {
                this.f4678p.setBackgroundDrawable(drawableM3952i);
            } else {
                this.f4678p.setBackgroundResource(R.drawable.bubble_receive_01_normal);
            }
        }
        if (this.f4655M.equals("change_background")) {
            this.f4682t.setItemClickListener(this.f4667e);
            m4672h();
        } else {
            this.f4686x.setItemClickListener(this.f4668f);
            this.f4687y.setItemClickListener(this.f4669g);
            m4673i();
        }
    }

    /* renamed from: a */
    public void m4661a() {
        Bitmap bitmap = null;
        C1012j c1012jM3949f = C1003c.m3949f(getActivity(), this.f4672j);
        if (c1012jM3949f != null) {
            bitmap = c1012jM3949f.f3710b;
        }
        if (bitmap != null) {
            if (this.f4673k.equals("pa")) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                this.f4676n.setBackgroundDrawable(bitmapDrawable);
                return;
            }
            this.f4676n.setImageBitmap(bitmap);
            return;
        }
        m4664b();
    }

    /* renamed from: b */
    public void m4664b() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f4676n.setBackgroundDrawable(bitmapDrawable);
    }

    /* renamed from: c */
    public BitmapDrawable m4666c() {
        try {
            if (C1767bw.m6002a() && this.f4646B != null) {
                if (f4643G == null) {
                    f4643G = new BitmapDrawable(C1791w.m6099b(getActivity(), Uri.parse(this.f4646B + "/skin_myskin.png_")));
                }
                return f4643G;
            }
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_default));
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
            return new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_default));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m4652m();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f4650F == 0 || this.f4649E == 0) {
            m4652m();
        }
    }

    /* renamed from: d */
    public void m4668d() {
        C1789u.m6075a().edit().putString("setting_change_skin", this.f4672j).commit();
        C1789u.m6075a().edit().putString("new_skin_filename", this.f4656N).commit();
        C1789u.m6075a().edit().putString("setting_change_skin_type", this.f4673k).commit();
        C1789u.m6075a().edit().putString("setting_change_bubble_send", this.f4674l).commit();
        C1789u.m6075a().edit().putString("setting_change_bubble_receive", this.f4675m).commit();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f4644H = null;
        f4643G = null;
        this.f4662T.m6191a();
    }

    /* renamed from: m */
    private void m4652m() {
        if (!GlobalApplication.m3265f()) {
            WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
            this.f4649E = windowManager.getDefaultDisplay().getWidth();
            this.f4650F = windowManager.getDefaultDisplay().getHeight();
        } else {
            this.f4649E = this.f4652J.findViewById(R.id.skin_window).getWidth();
            this.f4650F = this.f4652J.findViewById(R.id.skin_window).getHeight();
        }
        C1786r.m6061b("1. windows size=width:" + this.f4649E + " height:" + this.f4650F, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("setting_change_skin", this.f4672j);
        bundle.putString("new_skin_filename", this.f4656N);
        bundle.putString("setting_change_skin_type", this.f4673k);
        bundle.putString("setting_change_bubble_send", this.f4674l);
        bundle.putString("setting_change_bubble_receive", this.f4675m);
        bundle.putString("change_mode", this.f4655M);
    }

    /* renamed from: e */
    void m4669e() {
        if (this.f4680r != null && this.f4681s != null) {
            if (this.f4680r.equals(this.f4674l) && this.f4681s.equals(this.f4675m)) {
                if (this.f4657O != null) {
                    this.f4657O.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                    this.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                }
                if (this.f4658P) {
                    this.f4657O.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                    this.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                    return;
                }
                return;
            }
            if (this.f4657O != null) {
                this.f4657O.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                this.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m4653n() {
        Configuration configuration = getResources().getConfiguration();
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        if (configuration.orientation == 2) {
            Bitmap bitmapM6084a = C1791w.m6084a(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C1722ae.m5894a(59.0f));
            if (bitmapM6084a == null) {
                this.f4676n.setBackgroundDrawable(this.f4651I);
                return;
            } else {
                this.f4676n.setImageBitmap(bitmapM6084a);
                return;
            }
        }
        Bitmap bitmapM6098b = C1791w.m6098b(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C1722ae.m5894a(59.0f));
        if (bitmapM6098b == null) {
            this.f4676n.setBackgroundDrawable(this.f4651I);
        } else {
            this.f4676n.setImageBitmap(bitmapM6098b);
        }
    }

    @Override // com.sec.chaton.settings.InterfaceC1256bh
    /* renamed from: a */
    public void mo4662a(String str, Drawable drawable) throws Resources.NotFoundException {
        C1289cn c1289cn = (C1289cn) this.f4659Q.get(str);
        if (drawable == null) {
            drawable = getResources().getDrawable(R.drawable.thumb_skin_networkerror);
        }
        c1289cn.f4837c = drawable;
    }

    @Override // com.sec.chaton.settings.InterfaceC1256bh
    /* renamed from: a */
    public void mo4663a(String str, C1012j c1012j) {
        C1289cn c1289cn = (C1289cn) this.f4659Q.get(str);
        if (c1012j != null) {
            c1289cn.f4838d = c1012j.f3710b;
        } else {
            c1289cn.f4838d = null;
        }
    }

    /* renamed from: f */
    public void m4670f() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        C1289cn c1289cn = new C1289cn(this);
        c1289cn.f4835a = "skin_add";
        c1289cn.f4837c = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.thumb_skin_bg_default));
        this.f4659Q.put(c1289cn.f4835a, c1289cn);
        View viewInflate = layoutInflater.inflate(R.layout.item_skin_bg, (ViewGroup) null, false);
        ((ImageView) viewInflate.findViewById(R.id.skin_bg)).setImageDrawable(c1289cn.f4837c);
        if (this.f4682t != null) {
            this.f4682t.m7477a(c1289cn.f4835a, viewInflate);
        }
        if (c1289cn.f4835a.equals(this.f4672j)) {
            viewInflate.setSelected(true);
        } else {
            viewInflate.setSelected(false);
        }
    }

    /* renamed from: g */
    public void m4671g() {
        boolean z;
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        if (this.f4646B != null) {
            File file = new File(this.f4646B, "skin_myskin.png_");
            z = file.exists() && file.length() > 0;
        } else {
            z = false;
        }
        C1289cn c1289cn = new C1289cn(this);
        c1289cn.f4835a = "skin_myskin.png_";
        c1289cn.f4836b = "ma";
        if (z) {
            c1289cn.f4837c = m4666c();
        } else {
            c1289cn.f4837c = null;
        }
        this.f4659Q.put(c1289cn.f4835a, c1289cn);
        View viewInflate = layoutInflater.inflate(R.layout.item_skin_bg, (ViewGroup) null, false);
        ((ImageView) viewInflate.findViewById(R.id.skin_bg)).setImageDrawable(c1289cn.f4837c);
        if (c1289cn.f4835a.equals("skin_myskin.png_") && c1289cn.f4837c == null) {
            viewInflate.setVisibility(8);
        }
        if (this.f4682t != null) {
            this.f4682t.m7477a(c1289cn.f4835a, viewInflate);
        }
        if (c1289cn.f4835a.equals(this.f4672j)) {
            viewInflate.setSelected(true);
        } else {
            viewInflate.setSelected(false);
        }
    }

    /* renamed from: h */
    public void m4672h() {
        this.f4659Q = new LinkedHashMap();
        m4670f();
        m4671g();
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        Cursor cursorQuery = getActivity().getContentResolver().query(C1002c.f3694a.buildUpon().appendPath("install").build(), null, null, null, "install DESC");
        while (cursorQuery.moveToNext()) {
            C1289cn c1289cn = new C1289cn(this);
            c1289cn.f4835a = cursorQuery.getString(cursorQuery.getColumnIndex("skin_id"));
            c1289cn.f4836b = cursorQuery.getString(cursorQuery.getColumnIndex("bg_type"));
            View viewInflate = layoutInflater.inflate(R.layout.item_skin_bg, (ViewGroup) null, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.skin_bg);
            C1255bg c1255bg = new C1255bg(c1289cn.f4835a, getActivity());
            c1255bg.m4740a((InterfaceC1256bh) this);
            this.f4662T.m6190a(imageView, c1255bg);
            this.f4659Q.put(c1289cn.f4835a, c1289cn);
            if (this.f4682t != null) {
                this.f4682t.m7477a(c1289cn.f4835a, viewInflate);
            }
            if (c1289cn.f4835a.equals(this.f4672j)) {
                viewInflate.setSelected(true);
            } else {
                viewInflate.setSelected(false);
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    @Override // com.sec.chaton.settings.InterfaceC1260bl
    /* renamed from: c */
    public void mo4667c(String str, Drawable drawable) {
        ((C1290co) this.f4660R.get(str)).f4841b = drawable;
    }

    @Override // com.sec.chaton.settings.InterfaceC1258bj
    /* renamed from: b */
    public void mo4665b(String str, Drawable drawable) {
        ((C1290co) this.f4661S.get(str)).f4841b = drawable;
    }

    /* renamed from: i */
    public void m4673i() {
        this.f4660R = new LinkedHashMap();
        this.f4661S = new LinkedHashMap();
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        Cursor cursorQuery = getActivity().getContentResolver().query(C1002c.f3694a.buildUpon().appendPath("install").build(), null, null, null, "install DESC");
        while (cursorQuery.moveToNext()) {
            C1290co c1290co = new C1290co(this);
            c1290co.f4840a = cursorQuery.getString(cursorQuery.getColumnIndex("skin_id"));
            View viewInflate = layoutInflater.inflate(R.layout.item_skin_bubble, (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.skin_bubble);
            C1259bk c1259bk = new C1259bk(c1290co.f4840a, getActivity());
            c1259bk.m4742a((InterfaceC1260bl) this);
            this.f4662T.m6190a(textView, c1259bk);
            this.f4660R.put(c1290co.f4840a, c1290co);
            if (this.f4686x != null) {
                this.f4686x.m7477a(c1290co.f4840a, viewInflate);
            }
            if (c1290co.f4840a.equals(this.f4674l)) {
                viewInflate.setSelected(true);
            } else {
                viewInflate.setSelected(false);
            }
            C1290co c1290co2 = new C1290co(this);
            c1290co2.f4840a = c1290co.f4840a;
            View viewInflate2 = layoutInflater.inflate(R.layout.item_skin_bubble, (ViewGroup) null, false);
            TextView textView2 = (TextView) viewInflate2.findViewById(R.id.skin_bubble);
            C1257bi c1257bi = new C1257bi(c1290co2.f4840a, getActivity());
            c1257bi.m4741a((InterfaceC1258bj) this);
            this.f4662T.m6190a(textView2, c1257bi);
            this.f4661S.put(c1290co2.f4840a, c1290co2);
            if (this.f4687y != null) {
                this.f4687y.m7477a(c1290co2.f4840a, viewInflate2);
            }
            if (c1290co2.f4840a.equals(this.f4675m)) {
                viewInflate2.setSelected(true);
            } else {
                viewInflate2.setSelected(false);
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4636a(File file) throws IOException {
        try {
            if (!file.exists()) {
                file.mkdir();
            }
            this.f4647C = null;
            this.f4647C = new File(this.f4646B, "skin_myskin.png_");
            this.f4647C.createNewFile();
            this.f4648D = Uri.fromFile(this.f4647C);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (this.f4653K == null) {
                    this.f4653K = Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1);
                }
                this.f4653K.show();
            } else {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                startActivityForResult(intent, 2);
            }
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            C1786r.m6061b("Gallery Return is NULL", getClass().getSimpleName());
        }
        switch (i) {
            case 0:
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C1791w.m6100b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), this.f4650F), this.f4649E, this.f4650F, true);
                    C1791w.m6092a(C1791w.m6093a(bitmapCreateScaledBitmap), "/skins/", this.f4647C.getName());
                    f4644H = new BitmapDrawable(bitmapCreateScaledBitmap);
                    this.f4676n.setImageBitmap(f4644H.getBitmap());
                    this.f4672j = "skin_myskin.png_";
                    this.f4673k = ((C1289cn) this.f4659Q.get(this.f4672j)).f4836b;
                    f4643G = null;
                    ((C1289cn) this.f4659Q.get("skin_myskin.png_")).f4837c = m4666c();
                    if (this.f4682t != null) {
                        this.f4682t.m7476a("skin_myskin.png_", ((C1289cn) this.f4659Q.get("skin_myskin.png_")).f4837c);
                    }
                    if (this.f4682t != null) {
                        this.f4682t.setSelection("skin_myskin.png_");
                    }
                    this.f4658P = true;
                    m4669e();
                    break;
                } catch (Exception e) {
                    C1786r.m6056a(e, getClass().getSimpleName());
                    return;
                }
            case 2:
                m4652m();
                C1786r.m6061b("2. windows size=width:" + this.f4649E + " height:" + this.f4650F, getClass().getSimpleName());
                if (GlobalApplication.m3265f()) {
                    this.f4648D = intent.getData();
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f4648D, "image/*");
                    intent2.putExtra("screenWidth", 0);
                    intent2.putExtra("screenHeight", 0);
                    intent2.putExtra("outputX", this.f4649E);
                    intent2.putExtra("outputY", this.f4650F);
                    intent2.putExtra("aspectX", 0);
                    intent2.putExtra("aspectY", 0);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 0);
                    break;
                } else {
                    this.f4648D = intent.getData();
                    Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f4648D, "image/*");
                    intent3.putExtra("outputX", this.f4649E);
                    intent3.putExtra("outputY", this.f4650F);
                    intent3.putExtra("aspectX", 2);
                    intent3.putExtra("aspectY", 3);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 0);
                    break;
                }
        }
    }

    /* renamed from: j */
    public void m4674j() {
        Iterator it = this.f4659Q.entrySet().iterator();
        while (it.hasNext()) {
            C1289cn c1289cn = (C1289cn) ((Map.Entry) it.next()).getValue();
            if (c1289cn.f4837c != null) {
                C1003c.m3940a(c1289cn.f4837c);
            }
            if (c1289cn.f4838d != null) {
                c1289cn.f4838d.recycle();
            }
        }
    }

    /* renamed from: k */
    public void m4675k() {
        Iterator it = this.f4660R.entrySet().iterator();
        while (it.hasNext()) {
            C1290co c1290co = (C1290co) ((Map.Entry) it.next()).getValue();
            if (c1290co.f4841b != null) {
                C1003c.m3940a(c1290co.f4841b);
            }
        }
        Iterator it2 = this.f4661S.entrySet().iterator();
        while (it2.hasNext()) {
            C1290co c1290co2 = (C1290co) ((Map.Entry) it2.next()).getValue();
            if (c1290co2.f4841b != null) {
                C1003c.m3940a(c1290co2.f4841b);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f4659Q != null) {
            m4674j();
        } else {
            m4675k();
        }
    }

    /* renamed from: l */
    public void m4676l() {
        if (this.f4672j.equals("skin_01")) {
            this.f4672j = "-1";
        } else if (this.f4672j.equals("skin_bg_02")) {
            this.f4672j = "-2";
        } else if (this.f4672j.equals("skin_bg_03")) {
            this.f4672j = "-3";
        } else if (this.f4672j.equals("skin_bg_04")) {
            this.f4672j = "-4";
        }
        if (this.f4674l.equals("bubble_01")) {
            this.f4674l = "-1";
        } else if (this.f4674l.equals("bubble_02")) {
            this.f4674l = "-2";
        } else if (this.f4674l.equals("bubble_03")) {
            this.f4674l = "-3";
        } else if (this.f4674l.equals("bubble_04")) {
            this.f4674l = "-4";
        }
        if (!this.f4675m.equals("bubble_01")) {
            if (!this.f4675m.equals("bubble_02")) {
                if (!this.f4675m.equals("bubble_03")) {
                    if (this.f4675m.equals("bubble_04")) {
                        this.f4675m = "-4";
                        return;
                    }
                    return;
                }
                this.f4675m = "-3";
                return;
            }
            this.f4675m = "-2";
            return;
        }
        this.f4675m = "-1";
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (this.f4657O == null) {
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
            menu.removeItem(R.id.actionbar_title_next);
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            this.f4657O = menu;
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_cancel /* 2131494128 */:
                getActivity().finish();
                return true;
            case R.id.actionbar_title_change /* 2131494129 */:
            default:
                return super.onOptionsItemSelected(menuItem);
            case R.id.actionbar_title_done /* 2131494130 */:
                m4668d();
                getActivity().finish();
                return true;
        }
    }
}
