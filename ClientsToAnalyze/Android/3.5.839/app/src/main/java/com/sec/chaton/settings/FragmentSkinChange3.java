package com.sec.chaton.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1735gh;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.settings.p096a.C3481y;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.StateButton;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5048n;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class FragmentSkinChange3 extends Fragment {

    /* renamed from: a */
    public static int f12733a = 5;

    /* renamed from: b */
    public static int f12734b = 6;

    /* renamed from: c */
    public static int f12735c = 7;

    /* renamed from: A */
    private LinearLayout f12736A;

    /* renamed from: B */
    private String f12737B;

    /* renamed from: D */
    private boolean f12739D;

    /* renamed from: E */
    private File f12740E;

    /* renamed from: F */
    private File f12741F;

    /* renamed from: G */
    private Uri f12742G;

    /* renamed from: H */
    private int f12743H;

    /* renamed from: I */
    private int f12744I;

    /* renamed from: K */
    private View f12746K;

    /* renamed from: P */
    private C5007c f12751P;

    /* renamed from: k */
    private String f12762k;

    /* renamed from: l */
    private String f12763l;

    /* renamed from: m */
    private String f12764m;

    /* renamed from: n */
    private String f12765n;

    /* renamed from: o */
    private ImageView f12766o;

    /* renamed from: p */
    private LinearLayout f12767p;

    /* renamed from: q */
    private LinearLayout f12768q;

    /* renamed from: r */
    private StateButton f12769r;

    /* renamed from: s */
    private StateButton f12770s;

    /* renamed from: t */
    private StateButton f12771t;

    /* renamed from: v */
    private boolean f12773v;

    /* renamed from: w */
    private GridView f12774w;

    /* renamed from: x */
    private GridView f12775x;

    /* renamed from: y */
    private C3622fe f12776y;

    /* renamed from: z */
    private ImageView f12777z;

    /* renamed from: f */
    private final int f12757f = 0;

    /* renamed from: g */
    private final int f12758g = 1;

    /* renamed from: h */
    private final int f12759h = 2;

    /* renamed from: i */
    private final int f12760i = 3;

    /* renamed from: j */
    private final int f12761j = 4;

    /* renamed from: u */
    private int f12772u = f12734b;

    /* renamed from: C */
    private boolean f12738C = false;

    /* renamed from: J */
    private BitmapDrawable f12745J = null;

    /* renamed from: L */
    private Toast f12747L = null;

    /* renamed from: M */
    private Toast f12748M = null;

    /* renamed from: N */
    private String f12749N = "";

    /* renamed from: O */
    private AbstractC4932a f12750O = null;

    /* renamed from: d */
    String f12755d = "all_chat";

    /* renamed from: Q */
    private Bitmap f12752Q = null;

    /* renamed from: R */
    private Bitmap f12753R = null;

    /* renamed from: S */
    private BitmapDrawable f12754S = null;

    /* renamed from: e */
    AdapterView.OnItemClickListener f12756e = new C3613ew(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C4904y.f17873c) {
            C4904y.m18641c("[onCreate]", getClass().getSimpleName());
        }
        if (C4873ck.m18500a()) {
            this.f12740E = new File(GlobalApplication.m10279a().getExternalFilesDir(null).getAbsolutePath() + "/skins/");
        } else {
            this.f12740E = null;
        }
        this.f12751P = new C5007c(Executors.newFixedThreadPool(5, new ThreadFactoryC3612ev(this)));
        this.f12772u = f12734b;
        this.f12773v = true;
        if (bundle != null) {
            if (bundle.containsKey("setting_change_skin")) {
                this.f12762k = bundle.getString("setting_change_skin");
            }
            if (bundle.containsKey("setting_change_skin_type")) {
                this.f12763l = bundle.getString("setting_change_skin_type");
            }
            if (bundle.containsKey("setting_change_bubble_send")) {
                this.f12764m = bundle.getString("setting_change_bubble_send");
            }
            if (bundle.containsKey("setting_change_bubble_receive")) {
                this.f12765n = bundle.getString("setting_change_bubble_receive");
            }
            if (bundle.containsKey("new_skin_filename")) {
                this.f12749N = bundle.getString("new_skin_filename");
            }
            if (bundle.containsKey("tab_type")) {
                this.f12772u = bundle.getInt("tab_type");
            }
            if (bundle.containsKey("tab_state")) {
                this.f12773v = bundle.getBoolean("tab_state");
            }
            if (bundle.containsKey("captureUri")) {
                this.f12742G = Uri.parse(bundle.getString("captureUri"));
            }
            if (bundle.containsKey("popup_status")) {
                this.f12739D = bundle.getBoolean("popup_status");
            }
        }
        if (this.f12739D) {
            m13627l();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* renamed from: a */
    public void m13632a() {
        this.f12776y.mo875a(getActivity().getContentResolver().query(C2257bc.m10121a(EnumC2258bd.Skin).buildUpon().appendEncodedPath("install").build(), null, null, null, "install DESC"));
        this.f12776y.notifyDataSetInvalidated();
    }

    /* renamed from: b */
    public void m13636b() {
        this.f12776y.mo875a(getActivity().getContentResolver().query(C2257bc.m10121a(EnumC2258bd.Skin).buildUpon().appendEncodedPath("install").build(), null, null, null, "install DESC"));
        this.f12776y.notifyDataSetInvalidated();
    }

    /* renamed from: c */
    public void m13638c() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_id", "reference_id", "item_id", "item_type", "name", "install", "expiration_time", "new", "special", "extras"});
        matrixCursor.newRow().add(0).add(0).add("skin_add").add(null).add(null).add(0).add(0).add(0).add(0).add(null);
        if (this.f12737B.equals("Y")) {
            matrixCursor.newRow().add(0).add(0).add("skin_myskin.png_").add(null).add(null).add(0).add(0).add(0).add(0).add(null);
        }
        this.f12776y.mo875a(new MergeCursor(new Cursor[]{matrixCursor, getActivity().getContentResolver().query(C2257bc.f8039a, null, "item_type IN ('" + EnumC2258bd.SkinTheme.m10123a() + "', '" + EnumC2258bd.Skin.m10123a() + "')", null, "install DESC")}));
        this.f12776y.notifyDataSetInvalidated();
    }

    /* renamed from: a */
    public void m13634a(String str, String str2, String str3) {
        for (int i = 0; i < this.f12774w.getChildCount(); i++) {
            C3623ff c3623ff = (C3623ff) this.f12774w.getChildAt(i).getTag();
            if (c3623ff != null) {
                if (this.f12772u == f12735c) {
                    if (c3623ff.f13163b.equals(str)) {
                        c3623ff.f13170i.setVisibility(0);
                        if (EnumC2258bd.Skin.m10123a().equals(str2)) {
                            C1735gh.m8615a(str, str3);
                        } else {
                            C1735gh.m8616a(str, str3, true);
                        }
                        this.f12762k = str;
                        this.f12763l = str3;
                    } else {
                        c3623ff.f13170i.setVisibility(8);
                    }
                } else if (c3623ff.f13162a.equals(str)) {
                    c3623ff.f13170i.setVisibility(0);
                    if (this.f12772u == f12733a) {
                        C1735gh.m8623c(str);
                        this.f12764m = str;
                    } else {
                        C1735gh.m8625d(str);
                        this.f12765n = str;
                    }
                } else {
                    c3623ff.f13170i.setVisibility(8);
                }
            } else {
                return;
            }
        }
        if (this.f12748M != null) {
            this.f12748M.cancel();
        }
        this.f12748M = C5179v.m19810a(getActivity(), R.string.toast_save_media, 0);
        this.f12748M.show();
    }

    /* renamed from: b */
    public void m13637b(String str, String str2, String str3) {
        for (int i = 0; i < this.f12775x.getChildCount(); i++) {
            C3623ff c3623ff = (C3623ff) this.f12775x.getChildAt(i).getTag();
            if (c3623ff != null) {
                if (this.f12772u == f12735c) {
                    if (c3623ff.f13163b.equals(str)) {
                        c3623ff.f13170i.setVisibility(0);
                        if (EnumC2258bd.Skin.m10123a().equals(str2)) {
                            C1735gh.m8615a(str, str3);
                        } else {
                            C1735gh.m8616a(str, str3, true);
                        }
                        this.f12762k = str;
                        this.f12763l = str3;
                    } else {
                        c3623ff.f13170i.setVisibility(8);
                    }
                } else if (c3623ff.f13162a.equals(str)) {
                    c3623ff.f13170i.setVisibility(0);
                    if (this.f12772u == f12733a) {
                        C1735gh.m8623c(str);
                        this.f12764m = str;
                    } else {
                        C1735gh.m8625d(str);
                        this.f12765n = str;
                    }
                } else {
                    c3623ff.f13170i.setVisibility(8);
                }
            } else {
                return;
            }
        }
        if (this.f12748M != null) {
            this.f12748M.cancel();
        }
        this.f12748M = C5179v.m19810a(getActivity(), R.string.toast_save_media, 0);
        this.f12748M.show();
    }

    /* renamed from: a */
    public void m13633a(int i) {
        if (this.f12774w == null) {
            this.f12775x.invalidateViews();
        } else {
            this.f12774w.invalidateViews();
        }
        if (i == f12733a) {
            this.f12770s.setSelected(true);
            this.f12769r.setSelected(false);
            this.f12771t.setSelected(false);
            m13636b();
            return;
        }
        if (i == f12735c) {
            this.f12771t.setSelected(true);
            this.f12770s.setSelected(false);
            this.f12769r.setSelected(false);
            m13638c();
            return;
        }
        this.f12769r.setSelected(true);
        this.f12770s.setSelected(false);
        this.f12771t.setSelected(false);
        m13632a();
    }

    /* renamed from: a */
    public void m13635a(boolean z) {
        if (z) {
            if (this.f12775x == null) {
                this.f12777z.setImageResource(R.drawable.list_ic_arrow_up);
                this.f12736A.setVisibility(8);
                this.f12773v = false;
                return;
            } else {
                this.f12777z.setImageResource(R.drawable.list_ic_arrow_down_land);
                this.f12736A.setVisibility(8);
                this.f12773v = false;
                return;
            }
        }
        if (this.f12775x == null) {
            this.f12777z.setImageResource(R.drawable.list_ic_arrow_down);
            this.f12736A.setVisibility(0);
            this.f12773v = true;
        } else {
            this.f12777z.setImageResource(R.drawable.list_ic_arrow_up_land);
            this.f12736A.setVisibility(0);
            this.f12773v = true;
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12746K = layoutInflater.inflate(R.layout.layout_change_skin3, viewGroup, false);
        this.f12777z = (ImageView) this.f12746K.findViewById(R.id.button_sliding);
        this.f12777z.setOnClickListener(new ViewOnClickListenerC3614ex(this));
        this.f12776y = new C3622fe(getActivity(), null, this.f12751P);
        this.f12774w = (GridView) this.f12746K.findViewById(R.id.grid_contents);
        if (this.f12774w != null) {
            this.f12774w.setOnItemClickListener(this.f12756e);
            this.f12774w.setAdapter((ListAdapter) this.f12776y);
        }
        this.f12775x = (GridView) this.f12746K.findViewById(R.id.grid_contents_h);
        if (this.f12775x != null) {
            this.f12775x.setOnItemClickListener(this.f12756e);
            this.f12775x.setAdapter((ListAdapter) this.f12776y);
        }
        this.f12736A = (LinearLayout) this.f12746K.findViewById(R.id.layout_bottom);
        this.f12769r = (StateButton) this.f12746K.findViewById(R.id.btn_buddies);
        this.f12769r.setOnClickListener(new ViewOnClickListenerC3615ey(this));
        this.f12770s = (StateButton) this.f12746K.findViewById(R.id.btn_me);
        this.f12770s.setOnClickListener(new ViewOnClickListenerC3616ez(this));
        this.f12771t = (StateButton) this.f12746K.findViewById(R.id.btn_background);
        this.f12771t.setOnClickListener(new ViewOnClickListenerC3618fa(this));
        this.f12766o = (ImageView) this.f12746K.findViewById(R.id.change_skin_bg);
        if (this.f12746K.findViewById(R.id.lLayoutSndContent) != null) {
            this.f12767p = (LinearLayout) this.f12746K.findViewById(R.id.lLayoutSndContent);
        }
        if (this.f12746K.findViewById(R.id.lLayoutSndContent) != null) {
            this.f12768q = (LinearLayout) this.f12746K.findViewById(R.id.textRecvContent);
        }
        setHasOptionsMenu(true);
        return this.f12746K;
    }

    /* renamed from: d */
    public boolean m13639d() {
        File file;
        if (!"Y".equals(this.f12737B) || (file = new File(C5048n.m19190a(GlobalApplication.m10279a().getApplicationContext()), "/skins/")) == null || new File(file, this.f12762k) == null) {
            return false;
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("setting_change_skin", this.f12762k);
        bundle.putString("setting_change_skin_type", this.f12763l);
        bundle.putString("setting_change_bubble_send", this.f12764m);
        bundle.putString("setting_change_bubble_receive", this.f12765n);
        bundle.putString("new_skin_filename", this.f12749N);
        bundle.putInt("tab_type", this.f12772u);
        bundle.putBoolean("tab_state", this.f12773v);
        bundle.putBoolean("popup_status", this.f12739D);
        if (this.f12742G != null) {
            bundle.putString("captureUri", this.f12742G.toString());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) throws IOException {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            if (bundle.containsKey("tab_state")) {
                this.f12773v = bundle.getBoolean("tab_state");
            }
            if (bundle.containsKey("tab_type")) {
                this.f12772u = bundle.getInt("tab_type");
            }
        }
        m13621i();
    }

    /* renamed from: i */
    private void m13621i() throws IOException {
        this.f12773v = !this.f12773v;
        this.f12762k = C4809aa.m18104a().m18121a("setting_change_skin", "-1");
        this.f12763l = C4809aa.m18104a().m18121a("setting_change_skin_type", "pa");
        this.f12764m = C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1");
        this.f12765n = C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1");
        this.f12737B = C4809aa.m18104a().m18121a("set_my_bg", "N");
        if (C4873ck.m18500a()) {
            File file = new File(this.f12740E, "skin_myskin.png_");
            if (file != null && file.exists() && this.f12762k.equals("skin_myskin.png_")) {
                this.f12762k = "skin_myskin.png_";
                this.f12763l = "ma";
                C4809aa.m18104a().m18128b("set_my_bg", "Y");
                C1735gh.m8615a(this.f12762k, this.f12763l);
                this.f12737B = "Y";
            }
        } else {
            this.f12737B = "N";
        }
        if (!m13639d() && !C3474r.m13826b(getActivity(), this.f12762k, true)) {
            this.f12762k = "-1";
            this.f12763l = "pa";
            C1735gh.m8615a(this.f12762k, this.f12763l);
        }
        if (!C3474r.m13825b(getActivity(), this.f12764m)) {
            this.f12764m = "-1";
            C1735gh.m8623c(this.f12764m);
        }
        if (!C3474r.m13825b(getActivity(), this.f12765n)) {
            this.f12765n = "-1";
            C1735gh.m8625d(this.f12765n);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[onActivityCreated] Skin id: " + this.f12762k + " Send Bubble: " + this.f12764m + " Receive Bubble:" + this.f12765n, getClass().getSimpleName());
        }
        m13642g();
        m13643h();
        if (this.f12762k.equals("skin_myskin.png_")) {
            m13625k();
        } else {
            m13640e();
        }
        if (this.f12767p != null) {
            Drawable drawableM13838g = C3474r.m13838g(getActivity(), this.f12764m);
            if (drawableM13838g != null) {
                this.f12767p.setBackgroundDrawable(drawableM13838g);
            } else {
                this.f12767p.setBackgroundResource(R.drawable.bubble_send_01_normal);
            }
        }
        if (this.f12768q != null) {
            Drawable drawableM13840i = C3474r.m13840i(getActivity(), this.f12765n);
            if (drawableM13840i != null) {
                this.f12768q.setBackgroundDrawable(drawableM13840i);
            } else {
                this.f12768q.setBackgroundResource(R.drawable.bubble_receive_01_normal);
            }
        }
    }

    /* renamed from: e */
    public void m13640e() throws IOException {
        C3481y c3481yM13837f = C3474r.m13837f(getActivity(), this.f12762k, true);
        if (c3481yM13837f == null) {
            m13641f();
            return;
        }
        if (this.f12763l.equals("pa")) {
            this.f12754S = new BitmapDrawable(CommonApplication.m18732r().getResources(), c3481yM13837f.f12970b);
            this.f12754S.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            this.f12766o.setImageBitmap(null);
            this.f12766o.setBackgroundDrawable(this.f12754S);
            return;
        }
        this.f12766o.setBackgroundDrawable(null);
        this.f12766o.setImageBitmap(c3481yM13837f.f12970b);
    }

    /* renamed from: f */
    public void m13641f() {
        this.f12754S = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
        this.f12754S.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f12766o.setBackgroundDrawable(this.f12754S);
    }

    /* renamed from: g */
    public void m13642g() {
        Bundle arguments = getArguments();
        m13635a(this.f12773v);
        this.f12776y.m13901a(this.f12772u);
        m13633a(this.f12772u);
        if (arguments.containsKey("type")) {
            this.f12755d = arguments.getString("type");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m13623j();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws IOException {
        super.onResume();
        if (this.f12744I == 0 || this.f12743H == 0) {
            m13623j();
        }
        m13621i();
        getActivity().mo51u_();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.download_menu, menu);
        C4880cr.m18526b(menu.findItem(R.id.menu_download));
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_download);
        if (menuItemFindItem != null) {
            if (C3474r.m13822b() > 0) {
                C4880cr.m18524a(menuItemFindItem, true);
            } else {
                C4880cr.m18524a(menuItemFindItem, false);
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C4904y.f17873c) {
            C4904y.m18641c("[onDestroy] Skin id: " + this.f12762k + " Send Bubble: " + this.f12764m + " Receive Bubble:" + this.f12765n, getClass().getSimpleName());
        }
        this.f12751P.m19014a();
        this.f12752Q = null;
        this.f12753R = null;
        this.f12754S = null;
    }

    /* renamed from: j */
    private void m13623j() {
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        this.f12743H = windowManager.getDefaultDisplay().getWidth();
        this.f12744I = windowManager.getDefaultDisplay().getHeight();
        C4904y.m18639b("1. windows size=width:" + this.f12743H + " height:" + this.f12744I, getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m13625k() {
        Configuration configuration = getResources().getConfiguration();
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        if (configuration.orientation == 2) {
            this.f12753R = C4812ad.m18139a(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C5034k.m19088a(59.0f));
            if (this.f12753R == null) {
                this.f12766o.setBackgroundDrawable(this.f12745J);
                return;
            } else {
                this.f12766o.setImageBitmap(this.f12753R);
                return;
            }
        }
        Bitmap bitmapM18156b = C4812ad.m18156b(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C5034k.m19088a(59.0f));
        if (bitmapM18156b == null) {
            this.f12766o.setBackgroundDrawable(this.f12745J);
        } else {
            this.f12766o.setImageBitmap(bitmapM18156b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13609a(File file) throws IOException {
        try {
            if (!file.exists()) {
                file.mkdir();
            }
            this.f12741F = null;
            this.f12741F = new File(this.f12740E, "skin_myskin.png_");
            this.f12741F.createNewFile();
            this.f12749N = this.f12741F.getName();
            m13627l();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    /* renamed from: l */
    private void m13627l() {
        int i;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            if (this.f12747L == null) {
                this.f12747L = C5179v.m19811a(getActivity(), getString(R.string.sdcard_not_found), 1);
            }
            this.f12747L.show();
            return;
        }
        if (C4822an.m18251s()) {
            i = R.array.selphoto_first;
        } else {
            i = R.array.selphoto_first_nocamera_nodelete;
        }
        this.f12739D = true;
        this.f12750O = AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.mypage_profile_add_photo).mo18736a(i, new DialogInterfaceOnClickListenerC3619fb(this));
        this.f12750O.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3620fc(this));
        this.f12750O.mo18737a(new DialogInterfaceOnCancelListenerC3621fd(this));
        this.f12750O.mo18745a().show();
        if (this.f12738C) {
            this.f12750O.mo18745a().dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 2:
                if (i2 != -1) {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("Crop_image cancel", getClass().getSimpleName());
                        break;
                    }
                } else {
                    try {
                        this.f12752Q = null;
                        this.f12752Q = Bitmap.createScaledBitmap(C4812ad.m18157b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), this.f12744I), this.f12743H, this.f12744I, true);
                        C4812ad.m18150a(C4812ad.m18151a(this.f12752Q), "/skins/", this.f12749N);
                        this.f12766o.setImageBitmap(this.f12752Q);
                        this.f12737B = "Y";
                        C4809aa.m18104a().m18128b("set_my_bg", "Y");
                        this.f12762k = "skin_myskin.png_";
                        this.f12763l = "ma";
                        C1735gh.m8615a("skin_myskin.png_", "ma");
                        C5179v.m19810a(getActivity(), R.string.toast_save_media, 0).show();
                        if (this.f12776y != null) {
                            this.f12776y.m13902c();
                        }
                        m13638c();
                        System.gc();
                        break;
                    } catch (Exception e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                        return;
                    }
                }
                break;
            case 3:
                if (intent == null) {
                    C4904y.m18639b("Gallery Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    C4904y.m18639b("2. windows size=width:" + this.f12743H + " height:" + this.f12744I, getClass().getSimpleName());
                    this.f12742G = intent.getData();
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f12742G, "image/*");
                    intent2.putExtra("outputX", this.f12743H);
                    intent2.putExtra("outputY", this.f12744I);
                    intent2.putExtra("aspectX", 2);
                    intent2.putExtra("aspectY", 3);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 2);
                    break;
                }
            case 4:
                if (i2 == -1) {
                    C4904y.m18639b("2. windows size=width:" + this.f12743H + " height:" + this.f12744I, getClass().getSimpleName());
                    Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f12742G, "image/*");
                    intent3.putExtra("outputX", this.f12743H);
                    intent3.putExtra("outputY", this.f12744I);
                    intent3.putExtra("aspectX", 2);
                    intent3.putExtra("aspectY", 3);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 2);
                    break;
                } else {
                    C4904y.m18639b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* renamed from: h */
    public void m13643h() {
        if (this.f12762k.equals("skin_01")) {
            this.f12762k = "-1";
        } else if (this.f12762k.equals("skin_bg_02")) {
            this.f12762k = "-2";
        } else if (this.f12762k.equals("skin_bg_03")) {
            this.f12762k = "-3";
        } else if (this.f12762k.equals("skin_bg_04")) {
            this.f12762k = "-4";
        } else if (this.f12762k.equals("skin_bg_05")) {
            this.f12762k = "-5";
        }
        if (this.f12764m.equals("bubble_01")) {
            this.f12764m = "-1";
        } else if (this.f12764m.equals("bubble_02")) {
            this.f12764m = "-2";
        } else if (this.f12764m.equals("bubble_03")) {
            this.f12764m = "-3";
        } else if (this.f12764m.equals("bubble_04")) {
            this.f12764m = "-4";
        } else if (this.f12764m.equals("bubble_05")) {
            this.f12764m = "-5";
        }
        if (this.f12765n.equals("bubble_01")) {
            this.f12765n = "-1";
            return;
        }
        if (this.f12765n.equals("bubble_02")) {
            this.f12765n = "-2";
            return;
        }
        if (this.f12765n.equals("bubble_03")) {
            this.f12765n = "-3";
        } else if (this.f12765n.equals("bubble_04")) {
            this.f12765n = "-4";
        } else if (this.f12765n.equals("bubble_05")) {
            this.f12765n = "-5";
        }
    }
}
