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
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.settings.downloads.C2598ck;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.StateButton;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3350l;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class FragmentSkinChange3 extends Fragment {

    /* renamed from: a */
    public static int f9172a = 5;

    /* renamed from: b */
    public static int f9173b = 6;

    /* renamed from: c */
    public static int f9174c = 7;

    /* renamed from: A */
    private LinearLayout f9175A;

    /* renamed from: B */
    private String f9176B;

    /* renamed from: D */
    private boolean f9178D;

    /* renamed from: E */
    private File f9179E;

    /* renamed from: F */
    private File f9180F;

    /* renamed from: G */
    private Uri f9181G;

    /* renamed from: H */
    private int f9182H;

    /* renamed from: I */
    private int f9183I;

    /* renamed from: K */
    private View f9185K;

    /* renamed from: O */
    private C3326c f9189O;

    /* renamed from: S */
    private boolean f9193S;

    /* renamed from: k */
    private String f9201k;

    /* renamed from: l */
    private String f9202l;

    /* renamed from: m */
    private String f9203m;

    /* renamed from: n */
    private String f9204n;

    /* renamed from: o */
    private ImageView f9205o;

    /* renamed from: p */
    private LinearLayout f9206p;

    /* renamed from: q */
    private LinearLayout f9207q;

    /* renamed from: r */
    private StateButton f9208r;

    /* renamed from: s */
    private StateButton f9209s;

    /* renamed from: t */
    private StateButton f9210t;

    /* renamed from: v */
    private boolean f9212v;

    /* renamed from: w */
    private GridView f9213w;

    /* renamed from: x */
    private GridView f9214x;

    /* renamed from: y */
    private C2672ei f9215y;

    /* renamed from: z */
    private ImageView f9216z;

    /* renamed from: f */
    private final int f9196f = 0;

    /* renamed from: g */
    private final int f9197g = 1;

    /* renamed from: h */
    private final int f9198h = 2;

    /* renamed from: i */
    private final int f9199i = 3;

    /* renamed from: j */
    private final int f9200j = 4;

    /* renamed from: u */
    private int f9211u = f9173b;

    /* renamed from: C */
    private boolean f9177C = false;

    /* renamed from: J */
    private BitmapDrawable f9184J = null;

    /* renamed from: L */
    private Toast f9186L = null;

    /* renamed from: M */
    private Toast f9187M = null;

    /* renamed from: N */
    private String f9188N = "";

    /* renamed from: d */
    String f9194d = PrefFragmentChats.ALL_CHAT;

    /* renamed from: P */
    private Bitmap f9190P = null;

    /* renamed from: Q */
    private Bitmap f9191Q = null;

    /* renamed from: R */
    private BitmapDrawable f9192R = null;

    /* renamed from: e */
    AdapterView.OnItemClickListener f9195e = new C2664ea(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        if (C3250y.f11735c) {
            C3250y.m11453c("[onCreate]", getClass().getSimpleName());
        }
        if (C3223ck.m11327a()) {
            this.f9179E = new File(GlobalApplication.m6447a().getExternalFilesDir(null).getAbsolutePath() + "/skins/");
        } else {
            this.f9179E = null;
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5, new ThreadFactoryC2662dz(this));
        BaseActivity.m3083b(this, true);
        this.f9189O = new C3326c(executorServiceNewFixedThreadPool);
        this.f9211u = f9173b;
        this.f9212v = true;
        if (bundle != null) {
            if (bundle.containsKey("setting_change_skin")) {
                this.f9201k = bundle.getString("setting_change_skin");
            }
            if (bundle.containsKey("setting_change_skin_type")) {
                this.f9202l = bundle.getString("setting_change_skin_type");
            }
            if (bundle.containsKey("setting_change_bubble_send")) {
                this.f9203m = bundle.getString("setting_change_bubble_send");
            }
            if (bundle.containsKey("setting_change_bubble_receive")) {
                this.f9204n = bundle.getString("setting_change_bubble_receive");
            }
            if (bundle.containsKey("new_skin_filename")) {
                this.f9188N = bundle.getString("new_skin_filename");
            }
            if (bundle.containsKey("tab_type")) {
                this.f9211u = bundle.getInt("tab_type");
            }
            if (bundle.containsKey("tab_state")) {
                this.f9212v = bundle.getBoolean("tab_state");
            }
            if (bundle.containsKey("captureUri")) {
                this.f9181G = Uri.parse(bundle.getString("captureUri"));
            }
            if (bundle.containsKey("popup_status")) {
                this.f9178D = bundle.getBoolean("popup_status");
            }
        } else {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.f9193S = intent.getBooleanExtra("called_from_downloads", false);
            }
        }
        if (this.f9178D) {
            m9134a(this.f9179E);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* renamed from: a */
    public void m9151a() {
        this.f9215y.changeCursor(getActivity().getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Skin).buildUpon().appendEncodedPath("install").build(), null, null, null, "install DESC"));
        this.f9215y.notifyDataSetInvalidated();
    }

    /* renamed from: b */
    public void m9155b() {
        this.f9215y.changeCursor(getActivity().getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Skin).buildUpon().appendEncodedPath("install").build(), null, null, null, "install DESC"));
        this.f9215y.notifyDataSetInvalidated();
    }

    /* renamed from: c */
    public void m9157c() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_id", "reference_id", "item_id", "item_type", "name", "install", "expiration_time", "new", "special", "extras"});
        matrixCursor.newRow().add(0).add(0).add("skin_add").add(null).add(null).add(0).add(0).add(0).add(0).add(null);
        if (this.f9176B.equals("Y")) {
            matrixCursor.newRow().add(0).add(0).add("skin_myskin.png_").add(null).add(null).add(0).add(0).add(0).add(0).add(null);
        }
        this.f9215y.changeCursor(new MergeCursor(new Cursor[]{matrixCursor, getActivity().getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Skin).buildUpon().appendPath("install").build(), null, null, null, "install DESC")}));
        this.f9215y.notifyDataSetInvalidated();
    }

    /* renamed from: a */
    public void m9153a(String str, String str2) {
        for (int i = 0; i < this.f9213w.getChildCount(); i++) {
            C2673ej c2673ej = (C2673ej) this.f9213w.getChildAt(i).getTag();
            if (c2673ej != null) {
                if (this.f9211u == f9174c) {
                    if (c2673ej.f9946b.equals(str)) {
                        c2673ej.f9952h.setVisibility(0);
                        C3159aa.m10962a().m10986b("setting_change_skin", str);
                        C3159aa.m10962a().m10986b("setting_change_skin_type", str2);
                        this.f9201k = str;
                        this.f9202l = str2;
                    } else {
                        c2673ej.f9952h.setVisibility(8);
                    }
                } else if (c2673ej.f9945a.equals(str)) {
                    c2673ej.f9952h.setVisibility(0);
                    if (this.f9211u == f9172a) {
                        C3159aa.m10962a().m10986b("setting_change_bubble_send", str);
                        this.f9203m = str;
                    } else {
                        C3159aa.m10962a().m10986b("setting_change_bubble_receive", str);
                        this.f9204n = str;
                    }
                } else {
                    c2673ej.f9952h.setVisibility(8);
                }
            } else {
                return;
            }
        }
        if (this.f9187M != null) {
            this.f9187M.cancel();
        }
        this.f9187M = C3641ai.m13210a(getActivity(), R.string.toast_save_media, 0);
        this.f9187M.show();
    }

    /* renamed from: b */
    public void m9156b(String str, String str2) {
        for (int i = 0; i < this.f9214x.getChildCount(); i++) {
            C2673ej c2673ej = (C2673ej) this.f9214x.getChildAt(i).getTag();
            if (c2673ej != null) {
                if (this.f9211u == f9174c) {
                    if (c2673ej.f9946b.equals(str)) {
                        c2673ej.f9952h.setVisibility(0);
                        C3159aa.m10962a().m10986b("setting_change_skin", str);
                        C3159aa.m10962a().m10986b("setting_change_skin_type", str2);
                        this.f9201k = str;
                        this.f9202l = str2;
                    } else {
                        c2673ej.f9952h.setVisibility(8);
                    }
                } else if (c2673ej.f9945a.equals(str)) {
                    c2673ej.f9952h.setVisibility(0);
                    if (this.f9211u == f9172a) {
                        C3159aa.m10962a().m10986b("setting_change_bubble_send", str);
                        this.f9203m = str;
                    } else {
                        C3159aa.m10962a().m10986b("setting_change_bubble_receive", str);
                        this.f9204n = str;
                    }
                } else {
                    c2673ej.f9952h.setVisibility(8);
                }
            } else {
                return;
            }
        }
        C3641ai.m13210a(getActivity(), R.string.toast_save_media, 0).show();
    }

    /* renamed from: a */
    public void m9152a(int i) {
        if (this.f9213w == null) {
            this.f9214x.invalidateViews();
        } else {
            this.f9213w.invalidateViews();
        }
        if (i == f9172a) {
            this.f9209s.setSelected(true);
            this.f9208r.setSelected(false);
            this.f9210t.setSelected(false);
            m9155b();
            return;
        }
        if (i == f9174c) {
            this.f9210t.setSelected(true);
            this.f9209s.setSelected(false);
            this.f9208r.setSelected(false);
            m9157c();
            return;
        }
        this.f9208r.setSelected(true);
        this.f9209s.setSelected(false);
        this.f9210t.setSelected(false);
        m9151a();
    }

    /* renamed from: a */
    public void m9154a(boolean z) {
        if (z) {
            if (this.f9214x == null) {
                this.f9216z.setBackgroundResource(R.drawable.list_ic_arrow_up);
                this.f9175A.setVisibility(8);
                this.f9212v = false;
                return;
            } else {
                if (GlobalApplication.m6456e()) {
                    this.f9216z.setBackgroundResource(R.drawable.list_ic_arrow_up);
                } else {
                    this.f9216z.setBackgroundResource(R.drawable.list_ic_arrow_down_land);
                }
                this.f9175A.setVisibility(8);
                this.f9212v = false;
                return;
            }
        }
        if (this.f9214x == null) {
            this.f9216z.setBackgroundResource(R.drawable.list_ic_arrow_down);
            this.f9175A.setVisibility(0);
            this.f9212v = true;
        } else {
            if (GlobalApplication.m6456e()) {
                this.f9216z.setBackgroundResource(R.drawable.list_ic_arrow_down);
            } else {
                this.f9216z.setBackgroundResource(R.drawable.list_ic_arrow_up_land);
            }
            this.f9175A.setVisibility(0);
            this.f9212v = true;
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9185K = layoutInflater.inflate(R.layout.layout_change_skin3, viewGroup, false);
        this.f9216z = (ImageView) this.f9185K.findViewById(R.id.button_sliding);
        this.f9216z.setOnClickListener(new ViewOnClickListenerC2665eb(this));
        this.f9215y = new C2672ei(getActivity(), null, this.f9189O);
        this.f9213w = (GridView) this.f9185K.findViewById(R.id.grid_contents);
        if (this.f9213w != null) {
            this.f9213w.setOnItemClickListener(this.f9195e);
            this.f9213w.setAdapter((ListAdapter) this.f9215y);
        }
        this.f9214x = (GridView) this.f9185K.findViewById(R.id.grid_contents_h);
        if (this.f9214x != null) {
            this.f9214x.setOnItemClickListener(this.f9195e);
            this.f9214x.setAdapter((ListAdapter) this.f9215y);
        }
        this.f9175A = (LinearLayout) this.f9185K.findViewById(R.id.layout_bottom);
        this.f9208r = (StateButton) this.f9185K.findViewById(R.id.btn_buddies);
        this.f9208r.setOnClickListener(new ViewOnClickListenerC2666ec(this));
        this.f9209s = (StateButton) this.f9185K.findViewById(R.id.btn_me);
        this.f9209s.setOnClickListener(new ViewOnClickListenerC2667ed(this));
        this.f9210t = (StateButton) this.f9185K.findViewById(R.id.btn_background);
        this.f9210t.setOnClickListener(new ViewOnClickListenerC2668ee(this));
        this.f9205o = (ImageView) this.f9185K.findViewById(R.id.change_skin_bg);
        if (this.f9185K.findViewById(R.id.lLayoutSndContent) != null) {
            this.f9206p = (LinearLayout) this.f9185K.findViewById(R.id.lLayoutSndContent);
        }
        if (this.f9185K.findViewById(R.id.lLayoutSndContent) != null) {
            this.f9207q = (LinearLayout) this.f9185K.findViewById(R.id.textRecvContent);
        }
        setHasOptionsMenu(true);
        return this.f9185K;
    }

    /* renamed from: d */
    public boolean m9158d() {
        File file;
        if (!"Y".equals(this.f9176B) || (file = new File(C3350l.m11800a(GlobalApplication.m6447a().getApplicationContext()), "/skins/")) == null || new File(file, this.f9201k) == null) {
            return false;
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("setting_change_skin", this.f9201k);
        bundle.putString("setting_change_skin_type", this.f9202l);
        bundle.putString("setting_change_bubble_send", this.f9203m);
        bundle.putString("setting_change_bubble_receive", this.f9204n);
        bundle.putString("new_skin_filename", this.f9188N);
        bundle.putInt("tab_type", this.f9211u);
        bundle.putBoolean("tab_state", this.f9212v);
        bundle.putBoolean("popup_status", this.f9178D);
        if (this.f9181G != null) {
            bundle.putString("captureUri", this.f9181G.toString());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) throws Throwable {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            if (bundle.containsKey("tab_state")) {
                this.f9212v = bundle.getBoolean("tab_state");
            }
            if (bundle.containsKey("tab_type")) {
                this.f9211u = bundle.getInt("tab_type");
            }
        }
        m9145i();
    }

    /* renamed from: i */
    private void m9145i() throws Throwable {
        this.f9212v = !this.f9212v;
        this.f9201k = C3159aa.m10962a().m10979a("setting_change_skin", "-1");
        this.f9202l = C3159aa.m10962a().m10979a("setting_change_skin_type", "pa");
        this.f9203m = C3159aa.m10962a().m10979a("setting_change_bubble_send", "-1");
        this.f9204n = C3159aa.m10962a().m10979a("setting_change_bubble_receive", "-1");
        this.f9176B = C3159aa.m10962a().m10979a("set_my_bg", "N");
        if (C3223ck.m11327a()) {
            File file = new File(this.f9179E, "skin_myskin.png_");
            if (file != null && file.exists() && this.f9201k == "skin_myskin.png_") {
                this.f9201k = "skin_myskin.png_";
                this.f9202l = "ma";
                C3159aa.m10962a().m10986b("set_my_bg", "Y");
                C3159aa.m10962a().m10986b("setting_change_skin", this.f9201k);
                C3159aa.m10962a().m10986b("setting_change_skin_type", this.f9202l);
                this.f9176B = "Y";
            }
        } else {
            this.f9176B = "N";
        }
        if (!m9158d() && !C2591cd.m9574b(getActivity(), this.f9201k)) {
            this.f9201k = "-1";
            this.f9202l = "pa";
            C3159aa.m10962a().m10986b("setting_change_skin", this.f9201k);
            C3159aa.m10962a().m10986b("setting_change_skin_type", this.f9202l);
        }
        if (!C2591cd.m9574b(getActivity(), this.f9203m)) {
            this.f9203m = "-1";
            C3159aa.m10962a().m10986b("setting_change_bubble_send", this.f9203m);
        }
        if (!C2591cd.m9574b(getActivity(), this.f9204n)) {
            this.f9204n = "-1";
            C3159aa.m10962a().m10986b("setting_change_bubble_receive", this.f9204n);
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("[onActivityCreated] Skin id: " + this.f9201k + " Send Bubble: " + this.f9203m + " Receive Bubble:" + this.f9204n, getClass().getSimpleName());
        }
        m9161g();
        m9162h();
        if (this.f9201k.equals("skin_myskin.png_")) {
            m9149k();
        } else {
            m9159e();
        }
        if (this.f9206p != null) {
            Drawable drawableM9584g = C2591cd.m9584g(getActivity(), this.f9203m);
            if (drawableM9584g != null) {
                this.f9206p.setBackgroundDrawable(drawableM9584g);
            } else {
                this.f9206p.setBackgroundResource(R.drawable.bubble_send_01_normal);
            }
        }
        if (this.f9207q != null) {
            Drawable drawableM9586i = C2591cd.m9586i(getActivity(), this.f9204n);
            if (drawableM9586i != null) {
                this.f9207q.setBackgroundDrawable(drawableM9586i);
            } else {
                this.f9207q.setBackgroundResource(R.drawable.bubble_receive_01_normal);
            }
        }
    }

    /* renamed from: e */
    public void m9159e() throws Throwable {
        C2598ck c2598ckM9582f = C2591cd.m9582f(getActivity(), this.f9201k);
        if (c2598ckM9582f == null) {
            m9160f();
        } else {
            if (this.f9202l.equals("pa")) {
                this.f9192R = new BitmapDrawable(c2598ckM9582f.f9826b);
                this.f9192R.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                this.f9205o.setBackgroundDrawable(this.f9192R);
                return;
            }
            this.f9205o.setImageBitmap(c2598ckM9582f.f9826b);
        }
    }

    /* renamed from: f */
    public void m9160f() {
        this.f9192R = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
        this.f9192R.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f9205o.setBackgroundDrawable(this.f9192R);
    }

    /* renamed from: g */
    public void m9161g() {
        Bundle arguments = getArguments();
        m9154a(this.f9212v);
        this.f9215y.m9678a(this.f9211u);
        m9152a(this.f9211u);
        if (arguments.containsKey(PrefFragmentChats.TYPE)) {
            this.f9194d = arguments.getString(PrefFragmentChats.TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m9146j();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        if (this.f9183I == 0 || this.f9182H == 0) {
            m9146j();
        }
        m9145i();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.download_menu, menu);
        if (this.f9193S) {
            menu.findItem(R.id.menu_download).setVisible(false);
        } else {
            menu.findItem(R.id.menu_download).setVisible(true);
            C3228cp.m11346b(menu.findItem(R.id.menu_download));
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_download);
        if (!this.f9193S && menuItemFindItem != null) {
            if (C2591cd.m9580e() > 0) {
                C3228cp.m11344a(menuItemFindItem, true);
            } else {
                C3228cp.m11344a(menuItemFindItem, false);
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
        if (C3250y.f11735c) {
            C3250y.m11453c("[onDestroy] Skin id: " + this.f9201k + " Send Bubble: " + this.f9203m + " Receive Bubble:" + this.f9204n, getClass().getSimpleName());
        }
        this.f9189O.m11731a();
        this.f9190P = null;
        this.f9191Q = null;
        this.f9192R = null;
    }

    /* renamed from: j */
    private void m9146j() {
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        this.f9182H = windowManager.getDefaultDisplay().getWidth();
        this.f9183I = windowManager.getDefaultDisplay().getHeight();
        C3250y.m11450b("1. windows size=width:" + this.f9182H + " height:" + this.f9183I, getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m9149k() {
        Configuration configuration = getResources().getConfiguration();
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        if (configuration.orientation == 2) {
            this.f9191Q = C3162ad.m10993a(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C3172an.m11085a(59.0f));
            if (this.f9191Q == null) {
                this.f9205o.setBackgroundDrawable(this.f9184J);
                return;
            } else {
                this.f9205o.setImageBitmap(this.f9191Q);
                return;
            }
        }
        Bitmap bitmapM11010b = C3162ad.m11010b(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C3172an.m11085a(59.0f));
        if (bitmapM11010b == null) {
            this.f9205o.setBackgroundDrawable(this.f9184J);
        } else {
            this.f9205o.setImageBitmap(bitmapM11010b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9134a(File file) throws IOException {
        int i;
        try {
            if (!file.exists()) {
                file.mkdir();
            }
            this.f9180F = null;
            this.f9180F = new File(this.f9179E, "skin_myskin.png_");
            this.f9180F.createNewFile();
            this.f9181G = Uri.fromFile(this.f9180F);
            this.f9188N = this.f9180F.getName();
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (this.f9186L == null) {
                    this.f9186L = C3641ai.m13211a(getActivity(), getString(R.string.sdcard_not_found), 1);
                }
                this.f9186L.show();
                return;
            }
            if (C3171am.m11077o()) {
                i = R.array.selphoto_first;
            } else {
                i = R.array.selphoto_first_nocamera_nodelete;
            }
            this.f9178D = true;
            AbstractC3271a abstractC3271aMo11497a = AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.mypage_profile_add_photo).mo11497a(i, new DialogInterfaceOnClickListenerC2669ef(this));
            abstractC3271aMo11497a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2670eg(this));
            abstractC3271aMo11497a.mo11498a(new DialogInterfaceOnCancelListenerC2671eh(this));
            abstractC3271aMo11497a.mo11505a().show();
            if (this.f9177C) {
                abstractC3271aMo11497a.mo11505a().dismiss();
            }
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 2:
                try {
                    this.f9190P = null;
                    this.f9190P = Bitmap.createScaledBitmap(C3162ad.m11012b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), this.f9183I), this.f9182H, this.f9183I, true);
                    C3162ad.m11005a(C3162ad.m11006a(this.f9190P), "/skins/", this.f9188N);
                    this.f9205o.setImageBitmap(this.f9190P);
                    this.f9176B = "Y";
                    C3159aa.m10962a().m10986b("set_my_bg", "Y");
                    this.f9201k = "skin_myskin.png_";
                    this.f9202l = "ma";
                    C3159aa.m10962a().m10986b("setting_change_skin", "skin_myskin.png_");
                    C3159aa.m10962a().m10986b("setting_change_skin_type", "ma");
                    C3641ai.m13210a(getActivity(), R.string.toast_save_media, 0).show();
                    m9157c();
                    System.gc();
                    break;
                } catch (Exception e) {
                    C3250y.m11443a(e, getClass().getSimpleName());
                    return;
                }
            case 3:
                if (intent == null) {
                    C3250y.m11450b("Gallery Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    C3250y.m11450b("2. windows size=width:" + this.f9182H + " height:" + this.f9183I, getClass().getSimpleName());
                    this.f9181G = intent.getData();
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f9181G, "image/*");
                    intent2.putExtra("outputX", this.f9182H);
                    intent2.putExtra("outputY", this.f9183I);
                    intent2.putExtra("aspectX", 2);
                    intent2.putExtra("aspectY", 3);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 2);
                    break;
                }
            case 4:
                if (i2 == -1) {
                    C3250y.m11450b("2. windows size=width:" + this.f9182H + " height:" + this.f9183I, getClass().getSimpleName());
                    Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f9181G, "image/*");
                    intent3.putExtra("outputX", this.f9182H);
                    intent3.putExtra("outputY", this.f9183I);
                    intent3.putExtra("aspectX", 2);
                    intent3.putExtra("aspectY", 3);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 2);
                    break;
                } else {
                    C3250y.m11450b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* renamed from: h */
    public void m9162h() {
        if (this.f9201k.equals("skin_01")) {
            this.f9201k = "-1";
        } else if (this.f9201k.equals("skin_bg_02")) {
            this.f9201k = "-2";
        } else if (this.f9201k.equals("skin_bg_03")) {
            this.f9201k = "-3";
        } else if (this.f9201k.equals("skin_bg_04")) {
            this.f9201k = "-4";
        } else if (this.f9201k.equals("skin_bg_05")) {
            this.f9201k = "-5";
        }
        if (this.f9203m.equals("bubble_01")) {
            this.f9203m = "-1";
        } else if (this.f9203m.equals("bubble_02")) {
            this.f9203m = "-2";
        } else if (this.f9203m.equals("bubble_03")) {
            this.f9203m = "-3";
        } else if (this.f9203m.equals("bubble_04")) {
            this.f9203m = "-4";
        } else if (this.f9203m.equals("bubble_05")) {
            this.f9203m = "-5";
        }
        if (this.f9204n.equals("bubble_01")) {
            this.f9204n = "-1";
            return;
        }
        if (this.f9204n.equals("bubble_02")) {
            this.f9204n = "-2";
            return;
        }
        if (this.f9204n.equals("bubble_03")) {
            this.f9204n = "-3";
        } else if (this.f9204n.equals("bubble_04")) {
            this.f9204n = "-4";
        } else if (this.f9204n.equals("bubble_05")) {
            this.f9204n = "-5";
        }
    }
}
