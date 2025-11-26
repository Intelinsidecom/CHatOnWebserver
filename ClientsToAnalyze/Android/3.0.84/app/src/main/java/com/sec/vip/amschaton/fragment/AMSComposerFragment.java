package com.sec.vip.amschaton.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.renren.android.feed.FeedPublishRequestParam;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSBgSelectionActivity;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSStampSelectionActivity;
import com.sec.vip.amschaton.C3399aa;
import com.sec.vip.amschaton.C3402ad;
import com.sec.vip.amschaton.C3410al;
import com.sec.vip.amschaton.C3412an;
import com.sec.vip.amschaton.C3421aw;
import com.sec.vip.amschaton.C3424az;
import com.sec.vip.amschaton.C3425b;
import com.sec.vip.amschaton.C3576i;
import com.sec.vip.amschaton.C3584q;
import com.sec.vip.amschaton.InterfaceC3400ab;
import com.sec.vip.amschaton.InterfaceC3434bi;
import com.sec.vip.amschaton.InterfaceC3441bp;
import com.sec.vip.amschaton.InterfaceC3581n;
import com.sec.vip.amschaton.InterfaceC3583p;
import com.sec.vip.amschaton.ViewOnClickListenerC3437bl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSComposerFragment extends AMSFragment implements View.OnClickListener, InterfaceC3400ab, InterfaceC3581n, InterfaceC3583p {

    /* renamed from: a */
    public static boolean f12651a = true;

    /* renamed from: b */
    public static boolean f12652b = true;

    /* renamed from: A */
    private C3421aw f12653A;

    /* renamed from: B */
    private AMSDrawManager f12654B;

    /* renamed from: E */
    private int f12657E;

    /* renamed from: F */
    private int f12658F;

    /* renamed from: G */
    private int[] f12659G;

    /* renamed from: H */
    private int[] f12660H;

    /* renamed from: K */
    private boolean f12663K;

    /* renamed from: L */
    private boolean f12664L;

    /* renamed from: M */
    private InterfaceC3434bi f12665M;

    /* renamed from: N */
    private RelativeLayout f12666N;

    /* renamed from: O */
    private ViewOnClickListenerC3437bl f12667O;

    /* renamed from: Q */
    private int f12669Q;

    /* renamed from: U */
    private String f12673U;

    /* renamed from: W */
    private boolean f12675W;

    /* renamed from: X */
    private boolean f12676X;

    /* renamed from: Y */
    private boolean f12677Y;

    /* renamed from: aa */
    private RelativeLayout f12679aa;

    /* renamed from: ab */
    private int f12680ab;

    /* renamed from: ac */
    private int f12681ac;

    /* renamed from: ad */
    private boolean f12682ad;

    /* renamed from: ae */
    private boolean f12683ae;

    /* renamed from: af */
    private boolean f12684af;

    /* renamed from: aj */
    private DisplayMetrics f12688aj;

    /* renamed from: an */
    private Bitmap f12692an;

    /* renamed from: ao */
    private Bitmap f12693ao;

    /* renamed from: p */
    private ImageButton f12699p;

    /* renamed from: q */
    private ImageButton f12700q;

    /* renamed from: r */
    private ImageButton f12701r;

    /* renamed from: s */
    private ImageButton f12702s;

    /* renamed from: t */
    private ImageView f12703t;

    /* renamed from: u */
    private ImageView f12704u;

    /* renamed from: v */
    private ImageView f12705v;

    /* renamed from: w */
    private ImageView f12706w;

    /* renamed from: x */
    private Bitmap f12707x;

    /* renamed from: y */
    private Bitmap f12708y;

    /* renamed from: z */
    private MenuItem f12709z;

    /* renamed from: m */
    private Bitmap f12696m = null;

    /* renamed from: n */
    private int f12697n = -1;

    /* renamed from: o */
    private float f12698o = 1.0f;

    /* renamed from: C */
    private int f12655C = 2000;

    /* renamed from: D */
    private int f12656D = 2002;

    /* renamed from: I */
    private int f12661I = -16777216;

    /* renamed from: J */
    private int f12662J = 2;

    /* renamed from: P */
    private RelativeLayout f12668P = null;

    /* renamed from: R */
    private boolean f12670R = true;

    /* renamed from: S */
    private int f12671S = 0;

    /* renamed from: T */
    private int f12672T = 1000;

    /* renamed from: V */
    private boolean f12674V = true;

    /* renamed from: Z */
    private boolean f12678Z = true;

    /* renamed from: ag */
    private boolean f12685ag = true;

    /* renamed from: ah */
    private boolean f12686ah = false;

    /* renamed from: ai */
    private boolean f12687ai = false;

    /* renamed from: ak */
    private ProgressDialog f12689ak = null;

    /* renamed from: c */
    String f12695c = null;

    /* renamed from: al */
    private AsyncTaskC3469aq f12690al = null;

    /* renamed from: am */
    private InterfaceC3441bp f12691am = new C3453aa(this);

    /* renamed from: ap */
    private Handler f12694ap = new HandlerC3460ah(this);

    /* renamed from: b */
    private void m12441b(int i) throws Resources.NotFoundException {
        if (i == 3000) {
            if (this.f12654B != null && this.f12673U != null) {
                switch (this.f12654B.m12002a(this.f12673U)) {
                    case 1:
                        m12524a(R.string.ams_msg_minor_version_changed);
                        break;
                    case 2:
                        m12524a(R.string.ams_msg_major_version_changed);
                        break;
                    case 3:
                        m12524a(R.string.chat_view_memory_error);
                        break;
                    case 4:
                        m12524a(R.string.ams_msg_invalid_ams_file);
                        C3250y.m11442a("Load Error", getClass().getSimpleName());
                        break;
                    default:
                        if (!this.f12654B.m12038s()) {
                            m12524a(R.string.ams_msg_edit_protection);
                            break;
                        } else {
                            this.f12654B.m12026g();
                            this.f12654B.setPlayMode(false);
                            m12419D();
                            m12474h();
                            this.f12674V = true;
                            break;
                        }
                }
                return;
            }
            return;
        }
        if (i == 3001) {
            m12465f(this.f12655C);
        }
    }

    @Override // com.sec.vip.amschaton.fragment.AMSFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12688aj = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.f12688aj);
        BaseActivity.m3081a(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_ams_composer, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) throws Resources.NotFoundException {
        boolean z;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        m12425a();
        if (bundle != null) {
            if (bundle.getBoolean("SI_SAVE_TEMP_AMS", false)) {
                this.f12675W = bundle.getBoolean("SI_SAVE_FLAG", this.f12675W);
                this.f12676X = bundle.getBoolean("SI_EDIT_FLAG", this.f12676X);
                this.f12673U = AMSActivity.f12274g;
                m12441b(3000);
            }
            this.f12655C = bundle.getInt("SI_CURRENT_TOOL_MODE", 2002);
            z = false;
        } else if (arguments != null) {
            this.f12673U = arguments.getString("AMS_FILE_PATH");
            this.f12675W = arguments.getBoolean("AMS_SAVE_FLAG", false);
            this.f12676X = arguments.getBoolean("AMS_EDIT_FLAG", false);
            z = arguments.getBoolean("AMS_PEN_STATE_DEFAULT", true);
        } else {
            C3250y.m11450b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f12673U = null;
            z = true;
        }
        f12652b = false;
        this.f12677Y = false;
        this.f12686ah = false;
        this.f12674V = this.f12673U == null || TextUtils.isEmpty(this.f12673U);
        this.f12659G = new int[5];
        this.f12660H = new int[5];
        m12472g(z);
        m12418C();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 1) {
            this.f12678Z = true;
            this.f12698o = getActivity().getWindowManager().getDefaultDisplay().getWidth() / 480.0f;
        } else if (configuration.orientation == 2) {
            this.f12678Z = false;
            this.f12698o = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 480.0f;
        }
        if (m12479i()) {
            m12486k();
            m12460e(this.f12655C);
            if (z) {
                m12511w();
            }
            if (arguments != null) {
                this.f12671S = arguments.getInt("BACKGROUND_INDEX", 0);
                this.f12672T = arguments.getInt("AMS_FRAME", 1000);
                if (this.f12672T == 1001) {
                    Bitmap bitmapM12422a = m12422a(arguments);
                    if (bitmapM12422a != null) {
                        m12428a(bitmapM12422a);
                        bitmapM12422a.recycle();
                        File file = new File(f12720k);
                        if (file.exists()) {
                            file.delete();
                        }
                    } else {
                        return;
                    }
                }
            }
            if (bundle != null && bundle.getBoolean("restore_background", false)) {
                this.f12696m = (Bitmap) bundle.getParcelable("BgBitmapParcel");
                this.f12697n = bundle.getInt("bgColor", -1);
                this.f12672T = bundle.getInt("BgType", 1000);
                if (this.f12672T == 1004) {
                    this.f12654B.m12009a(Color.red(this.f12697n), Color.green(this.f12697n), Color.blue(this.f12697n), true);
                    this.f12654B.m12026g();
                    m12419D();
                } else if (this.f12696m != null) {
                    m12428a(this.f12696m);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f12676X) {
            getActivity().setTitle(R.string.ams_optmenu_edit);
        } else {
            getActivity().setTitle(R.string.ams_title_create_new);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        f12651a = true;
        if (this.f12664L && this.f12667O != null) {
            m12429a(this.f12667O.m12317b(), false);
            m12462e(true);
        } else {
            m12462e(false);
        }
        this.f12683ae = false;
        this.f12684af = false;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        View viewFindViewById;
        super.onConfigurationChanged(configuration);
        m12425a();
        if (configuration.orientation == 1) {
            this.f12678Z = true;
        } else if (configuration.orientation == 2) {
            this.f12678Z = false;
        }
        int id = getActivity().getCurrentFocus() != null ? getActivity().getCurrentFocus().getId() : 0;
        String string = "";
        if (this.f12664L && this.f12667O != null) {
            EditText editText = (EditText) getView().findViewById(R.id.edit_text_input);
            editText.getSelectionStart();
            editText.getSelectionEnd();
            string = this.f12667O.m12317b().getText().toString();
        }
        m12482j();
        m12486k();
        if (this.f12654B != null) {
            this.f12654B.m12042w();
        }
        m12488l();
        if (this.f12664L && this.f12667O != null) {
            m12445b(string);
            m12462e(true);
        }
        if (!this.f12670R) {
            m12465f(2005);
        }
        if (id > 0 && (viewFindViewById = getView().findViewById(id)) != null) {
            viewFindViewById.requestFocus();
        }
    }

    /* renamed from: a */
    private void m12425a() {
        if (getResources().getConfiguration().orientation == 1) {
            this.f12668P = (RelativeLayout) getView().findViewById(R.id.ams_port);
            getView().findViewById(R.id.ams_port).setVisibility(0);
            getView().findViewById(R.id.ams_land).setVisibility(8);
        } else if (GlobalApplication.m6456e()) {
            this.f12668P = (RelativeLayout) getView().findViewById(R.id.ams_port);
            getView().findViewById(R.id.ams_port).setVisibility(0);
            getView().findViewById(R.id.ams_land).setVisibility(8);
        } else {
            this.f12668P = (RelativeLayout) getView().findViewById(R.id.ams_land);
            getView().findViewById(R.id.ams_port).setVisibility(8);
            getView().findViewById(R.id.ams_land).setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (this.f12664L && this.f12667O != null) {
            m12429a(this.f12667O.m12317b(), false);
        }
        if (this.f12690al != null) {
            this.f12690al.cancel(true);
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        boolean z = true;
        if (this.f12654B.m12039t()) {
            if (!m12457d(false)) {
                C3250y.m11453c("[onSaveInstanceState] Cannot save temp AMS file!", getClass().getName());
                z = false;
            }
            bundle.putBoolean("SI_SAVE_FLAG", this.f12675W);
            bundle.putBoolean("SI_EDIT_FLAG", this.f12676X);
        } else if (this.f12672T != 1000) {
            bundle.putBoolean("restore_background", true);
            bundle.putInt("BgType", this.f12672T);
            if (this.f12672T == 1004) {
                bundle.putInt("bgColor", this.f12697n);
                z = false;
            } else if (this.f12696m != null) {
                bundle.putParcelable("BgBitmapParcel", this.f12696m);
                z = false;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        bundle.putBoolean("SI_SAVE_TEMP_AMS", z);
        bundle.putInt("SI_CURRENT_TOOL_MODE", this.f12655C);
        f12651a = false;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (f12651a && this.f12675W && this.f12654B.m12039t() && !this.f12677Y) {
            m12459e();
        }
        if (this.f12707x != null) {
            this.f12707x = null;
        }
        if (this.f12708y != null) {
            this.f12708y.recycle();
            this.f12708y = null;
        }
        if (this.f12654B != null) {
            this.f12654B.m12040u();
            this.f12654B = null;
        }
        this.f12682ad = false;
        f12652b = true;
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f12664L) {
            menuInflater.inflate(R.menu.done_menu, menu);
        } else {
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
            if (this.f12654B != null && this.f12654B.m12039t()) {
                menu.findItem(R.id.menu_done).setEnabled(true);
            } else {
                menu.findItem(R.id.menu_done).setEnabled(false);
            }
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.f12709z = menu.findItem(R.id.menu_done);
        if (this.f12664L) {
            if (this.f12667O != null && !TextUtils.isEmpty(this.f12667O.m12313a())) {
                this.f12709z.setEnabled(true);
            } else {
                this.f12709z.setEnabled(false);
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_cancel /* 2131166603 */:
                mo12415c();
                break;
            case R.id.menu_done /* 2131166604 */:
                if (this.f12664L) {
                    if (this.f12667O != null) {
                        m12429a(this.f12667O.m12317b(), false);
                    }
                    new Handler().postDelayed(new RunnableC3461ai(this), 100L);
                    break;
                } else {
                    m12514y();
                    break;
                }
        }
        m12474h();
        return false;
    }

    @Override // com.sec.vip.amschaton.fragment.AMSFragment
    /* renamed from: c */
    public void mo12415c() {
        if (this.f12664L) {
            m12462e(false);
            if (this.f12667O != null) {
                this.f12667O.m12318c();
                return;
            }
            return;
        }
        m12440b();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        Bitmap bitmapM12177a;
        Bundle extras;
        switch (i) {
            case 3:
                if (i2 == -1 && (extras = intent.getExtras()) != null) {
                    this.f12671S = extras.getInt("BACKGROUND_INDEX", 0);
                    this.f12672T = extras.getInt("AMS_FRAME", 1000);
                    boolean z = this.f12675W;
                    this.f12675W = true;
                    this.f12696m = null;
                    this.f12697n = -1;
                    if (this.f12672T == 1000) {
                        m12502s();
                        break;
                    } else if (this.f12672T == 1004) {
                        int i3 = extras.getInt("BACKGROUND_COLOR", -16777216);
                        this.f12697n = i3;
                        int iRed = Color.red(i3);
                        int iGreen = Color.green(i3);
                        int iBlue = Color.blue(i3);
                        this.f12687ai = true;
                        this.f12654B.m12009a(iRed, iGreen, iBlue, true);
                        this.f12654B.m12026g();
                        m12419D();
                        break;
                    } else if (this.f12672T == 1001) {
                        Bitmap bitmapM12422a = m12422a(extras);
                        if (bitmapM12422a != null) {
                            m12428a(bitmapM12422a);
                            File file = new File(AMSActivity.f12275h);
                            if (file.exists()) {
                                file.delete();
                                break;
                            }
                        }
                    } else if (this.f12672T == 1003) {
                        Bitmap bitmapM12277a = C3425b.m12268a().m12277a(getActivity().getAssets(), extras.getInt("BG_SKIN_INDEX", 0), true);
                        if (bitmapM12277a != null) {
                            m12428a(bitmapM12277a);
                            break;
                        }
                    } else if (this.f12672T == 1002) {
                        Bitmap bitmapM12275a = C3425b.m12268a().m12275a((Context) getActivity(), extras.getInt("BG_SKIN_INDEX", 0), true);
                        if (bitmapM12275a != null) {
                            m12428a(bitmapM12275a);
                            break;
                        }
                    } else {
                        this.f12672T = 1000;
                        this.f12675W = z;
                        break;
                    }
                }
                break;
            case 11:
                if (i2 != -1) {
                    if (this.f12654B.m12024e() == null) {
                        if (this.f12669Q > C3410al.m12173a().m12208k()) {
                            Bitmap bitmapM12198e = C3410al.m12173a().m12198e(this.f12669Q - 20000, false);
                            if (bitmapM12198e == null) {
                                this.f12669Q = 0;
                            } else {
                                bitmapM12198e.recycle();
                            }
                        }
                        this.f12654B.m12008a(3, this.f12669Q, 0, 0);
                        m12465f(this.f12655C);
                        break;
                    }
                } else {
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        this.f12669Q = extras2.getInt("AMS_STAMP_INDEX", 0);
                        if (this.f12669Q < 0 || this.f12669Q > C3410al.m12173a().m12208k()) {
                            if (this.f12669Q < 30000) {
                                bitmapM12177a = C3410al.m12173a().m12198e(this.f12669Q - 20000, false);
                            } else if (this.f12669Q < 40000) {
                                bitmapM12177a = C3410al.m12173a().m12187b(this.f12669Q - 30000, false);
                            } else {
                                bitmapM12177a = C3410al.m12173a().m12177a(this.f12669Q - 40000, false);
                            }
                            if (bitmapM12177a == null) {
                                this.f12669Q = 0;
                            } else {
                                bitmapM12177a.recycle();
                            }
                        }
                        this.f12654B.m12008a(3, this.f12669Q, 0, 0);
                        m12465f(this.f12655C);
                        m12418C();
                        break;
                    }
                }
                break;
        }
        m12474h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        m12462e(false);
        switch (view.getId()) {
            case R.id.btn_tool_background_image /* 2131165735 */:
                if (!this.f12683ae && !this.f12684af) {
                    this.f12684af = true;
                    m12498q();
                    break;
                }
                break;
            case R.id.btn_tool_pen /* 2131165736 */:
                if (this.f12653A == null || !this.f12653A.isShowing()) {
                    m12464f();
                    break;
                }
                break;
            case R.id.btn_tool_stamp_shape /* 2131165737 */:
                if (!this.f12683ae && !this.f12684af) {
                    this.f12683ae = true;
                    m12501r();
                    break;
                }
                break;
            case R.id.btn_tool_text /* 2131165738 */:
                if (this.f12653A == null || !this.f12653A.isShowing()) {
                    m12470g();
                    break;
                }
                break;
            case R.id.btn_preview /* 2131165742 */:
                if (!this.f12682ad) {
                    this.f12682ad = true;
                    m12504t();
                    break;
                }
                break;
            case R.id.btn_undo /* 2131165743 */:
                m12420E();
                break;
            case R.id.btn_redo /* 2131165744 */:
                m12421F();
                break;
            case R.id.btn_clear /* 2131165745 */:
                m12417B();
                break;
        }
    }

    /* renamed from: b */
    private void m12440b() {
        f12651a = false;
        if (!this.f12675W || !this.f12654B.m12036q() || !this.f12654B.m12039t()) {
            super.mo12415c();
        } else {
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_app_name).mo11506b(R.string.ams_msg_exit_with_save).mo11515d(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC3463ak(this)).mo11507b(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC3462aj(this)).mo11505a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12459e() {
        if (!m12452c(AMSActivity.f12270c + m12424a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m12524a(R.string.ams_error_ams_file_save);
        } else {
            m12524a(R.string.ams_msg_saved);
        }
    }

    /* renamed from: f */
    private void m12464f() throws Resources.NotFoundException {
        m12487k(false);
        if (this.f12654B != null) {
            this.f12654B.setEditMode(false, false);
        }
        this.f12655C = 2002;
        m12449c(this.f12655C);
        if (this.f12656D != this.f12655C) {
            if (this.f12654B != null) {
                this.f12654B.m12008a(1, this.f12657E, this.f12659G[this.f12657E], this.f12660H[this.f12657E]);
            }
            this.f12656D = this.f12655C;
            m12465f(this.f12655C);
            m12419D();
            return;
        }
        this.f12656D = this.f12655C;
        m12490m();
    }

    /* renamed from: g */
    private void m12470g() throws Resources.NotFoundException {
        this.f12655C = 2003;
        m12449c(this.f12655C);
        if (this.f12656D != 2003) {
            this.f12654B.setEditMode(false, false);
            this.f12654B.m12008a(2, 0, this.f12661I, this.f12662J);
            this.f12656D = this.f12655C;
            m12465f(this.f12655C);
            m12419D();
            m12487k(true);
            return;
        }
        this.f12656D = this.f12655C;
        m12495o();
    }

    /* renamed from: h */
    private void m12474h() {
        if (this.f12654B != null) {
            this.f12703t.setEnabled(this.f12654B.m12036q());
            this.f12704u.setEnabled(this.f12654B.m12037r());
            this.f12705v.setEnabled(this.f12654B.m12039t());
            if (!this.f12687ai && this.f12672T == 1000 && !this.f12703t.isEnabled()) {
                this.f12706w.setEnabled(false);
            } else {
                this.f12706w.setEnabled(this.f12687ai | this.f12654B.m12039t());
            }
            getActivity().supportInvalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12449c(int i) throws Resources.NotFoundException {
        m12454d(i);
        m12465f(i);
    }

    /* renamed from: d */
    private void m12454d(int i) {
        int[] iArr = {2002, 2003, 2005, 2001};
        ImageButton[] imageButtonArr = {this.f12700q, this.f12701r, this.f12702s, this.f12699p};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                imageButtonArr[i2].setSelected(true);
            } else {
                imageButtonArr[i2].setSelected(false);
            }
        }
    }

    /* renamed from: i */
    private boolean m12479i() throws Resources.NotFoundException {
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ams_ics_titlebar_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ams_ics_composer_canvas_margin);
        if (width >= height) {
            width = (height - dimensionPixelSize) - (dimensionPixelSize2 * 2);
        }
        this.f12680ab = width;
        C3250y.m11453c("[createComposer] Composer Size = " + this.f12680ab, getClass().getSimpleName());
        this.f12681ac = this.f12680ab;
        if (this.f12654B != null) {
            this.f12654B.m12040u();
            this.f12654B = null;
        }
        this.f12654B = new AMSDrawManager(getActivity(), this.f12680ab, this.f12681ac);
        if (!this.f12654B.m12005a()) {
            m12529d();
            return false;
        }
        this.f12654B.setEnableZoom(true);
        this.f12654B.setPlayMode(false);
        this.f12654B.setOnTextInputRequestListener(this);
        this.f12654B.setOnObjectListener(this);
        this.f12654B.setOnTouchTextArea(this);
        this.f12654B.setEraserSize(this.f12660H[4]);
        if (!this.f12674V) {
            m12502s();
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AMSPref", 1);
        if (!sharedPreferences.getBoolean("AMS_BG_SET_FLAG", false)) {
            this.f12687ai = false;
            sharedPreferences.edit().putBoolean("AMS_BG_SET_FLAG", this.f12687ai).commit();
        }
        m12482j();
        return true;
    }

    /* renamed from: j */
    private void m12482j() {
        if (this.f12679aa != null) {
            this.f12679aa.removeAllViews();
            this.f12679aa = null;
        }
        this.f12679aa = new RelativeLayout(getActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f12679aa.setLayoutParams(layoutParams);
        this.f12679aa.addView(this.f12654B);
    }

    /* renamed from: k */
    private void m12486k() throws Resources.NotFoundException {
        RelativeLayout relativeLayout = (RelativeLayout) this.f12668P.findViewById(R.id.layout_ams);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            relativeLayout.addView(this.f12679aa);
        }
        this.f12699p = (ImageButton) this.f12668P.findViewById(R.id.btn_tool_background_image);
        this.f12700q = (ImageButton) this.f12668P.findViewById(R.id.btn_tool_pen);
        this.f12701r = (ImageButton) this.f12668P.findViewById(R.id.btn_tool_text);
        this.f12702s = (ImageButton) this.f12668P.findViewById(R.id.btn_tool_stamp_shape);
        this.f12703t = (ImageView) this.f12668P.findViewById(R.id.btn_undo);
        this.f12704u = (ImageView) this.f12668P.findViewById(R.id.btn_redo);
        this.f12705v = (ImageView) this.f12668P.findViewById(R.id.btn_preview);
        this.f12706w = (ImageView) this.f12668P.findViewById(R.id.btn_clear);
        this.f12699p.setOnClickListener(this);
        this.f12700q.setOnClickListener(this);
        this.f12701r.setOnClickListener(this);
        this.f12702s.setOnClickListener(this);
        this.f12703t.setOnClickListener(this);
        this.f12704u.setOnClickListener(this);
        this.f12705v.setOnClickListener(this);
        this.f12706w.setOnClickListener(this);
        if (!this.f12674V) {
            this.f12654B.setPlayMode(true);
            m12441b(3000);
        }
        m12474h();
        m12449c(this.f12655C);
        m12441b(3001);
    }

    /* renamed from: e */
    private void m12460e(int i) throws Resources.NotFoundException {
        this.f12655C = i;
        this.f12656D = this.f12655C;
        switch (i) {
            case 2003:
                this.f12654B.m12008a(2, 0, this.f12661I, this.f12662J);
                break;
            case 2004:
            default:
                this.f12654B.m12008a(1, this.f12657E, this.f12659G[this.f12657E], this.f12660H[this.f12657E]);
                break;
            case 2005:
                this.f12654B.m12008a(3, this.f12669Q, 0, 0);
                break;
        }
        m12449c(this.f12655C);
        m12441b(3001);
    }

    /* renamed from: l */
    private void m12488l() throws Resources.NotFoundException {
        if (this.f12653A != null && this.f12653A.isShowing()) {
            C3576i c3576iM12244g = this.f12653A.m12244g();
            boolean z = c3576iM12244g != null && c3576iM12244g.m12773c();
            m12446b(false);
            switch (this.f12655C) {
                case 2002:
                    if (z) {
                        m12434a(c3576iM12244g);
                        break;
                    } else {
                        m12490m();
                        break;
                    }
                case 2003:
                    if (z) {
                        m12444b(c3576iM12244g);
                        break;
                    } else {
                        m12495o();
                        break;
                    }
            }
        }
    }

    /* renamed from: b */
    private boolean m12446b(boolean z) throws Resources.NotFoundException {
        this.f12655C = this.f12656D;
        if (this.f12653A == null) {
            m12449c(this.f12655C);
            return false;
        }
        if (!this.f12653A.isShowing()) {
            m12449c(this.f12655C);
            return false;
        }
        if (z) {
            new View(getActivity()).post(new RunnableC3464al(this));
        } else {
            this.f12653A.dismiss();
            m12449c(this.f12655C);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12427a(int i, int i2, int i3) throws Resources.NotFoundException {
        this.f12657E = i;
        this.f12660H[this.f12657E] = i2;
        this.f12659G[this.f12657E] = i3;
        this.f12654B.m12008a(1, this.f12657E, this.f12659G[this.f12657E], this.f12660H[this.f12657E]);
        m12419D();
        m12465f(this.f12655C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12426a(int i, int i2) throws Resources.NotFoundException {
        this.f12662J = i;
        this.f12661I = i2;
        if (this.f12654B.m12024e() == null) {
            this.f12654B.m12008a(2, 0, this.f12661I, this.f12662J);
        } else {
            this.f12654B.m12007a(0, this.f12661I, this.f12662J);
        }
        m12419D();
        m12465f(this.f12655C);
        m12442b(this.f12661I, this.f12662J);
    }

    /* renamed from: m */
    private void m12490m() {
        this.f12653A = m12492n();
    }

    /* renamed from: a */
    private void m12434a(C3576i c3576i) {
        C3412an c3412anM12492n = m12492n();
        c3412anM12492n.m12241a(c3576i);
        c3412anM12492n.m12232d();
        this.f12653A = c3412anM12492n;
    }

    /* renamed from: n */
    private C3412an m12492n() {
        boolean z = this.f12678Z;
        if (GlobalApplication.m6456e()) {
            z = true;
        }
        C3412an c3412an = new C3412an(getActivity(), R.layout.layout_ams_popup_pen, this.f12700q, z);
        c3412an.m12227a(this.f12657E);
        c3412an.m12229b(this.f12660H[this.f12657E]);
        c3412an.m12231c(this.f12659G[this.f12657E]);
        c3412an.m12240a(new C3465am(this, c3412an));
        c3412an.m12239a(new C3466an(this));
        return c3412an;
    }

    /* renamed from: o */
    private void m12495o() {
        this.f12653A = m12497p();
    }

    /* renamed from: b */
    private void m12444b(C3576i c3576i) {
        C3424az c3424azM12497p = m12497p();
        c3424azM12497p.m12241a(c3576i);
        c3424azM12497p.m12266c();
        this.f12653A = c3424azM12497p;
    }

    /* renamed from: p */
    private C3424az m12497p() {
        boolean z = this.f12678Z;
        if (GlobalApplication.m6456e()) {
            z = true;
        }
        C3424az c3424az = new C3424az(getActivity(), R.layout.layout_ams_popup_text, this.f12701r, z);
        c3424az.m12263a(this.f12662J);
        c3424az.m12265b(this.f12661I);
        c3424az.m12240a(new C3467ao(this, c3424az));
        c3424az.m12239a(new C3468ap(this));
        return c3424az;
    }

    /* renamed from: q */
    private void m12498q() {
        m12487k(false);
        if (this.f12654B != null) {
            Intent intent = new Intent(getActivity(), (Class<?>) AMSBgSelectionActivity.class);
            intent.putExtra("BACKGROUND_COLOR", this.f12654B.m12016b());
            intent.putExtra("BACKGROUND_INDEX", this.f12671S);
            intent.putExtra("AMS_FRAME", this.f12672T);
            startActivityForResult(intent, 3);
        }
    }

    /* renamed from: r */
    private void m12501r() throws Resources.NotFoundException {
        m12487k(false);
        if (this.f12654B != null) {
            this.f12654B.setEditMode(false, false);
        }
        this.f12655C = 2005;
        m12454d(this.f12655C);
        if (this.f12656D != 2005 && !this.f12670R) {
            if (this.f12654B != null) {
                this.f12654B.m12008a(3, this.f12669Q, 0, 0);
            }
            this.f12656D = this.f12655C;
            m12465f(this.f12655C);
            m12419D();
            m12418C();
            this.f12683ae = false;
            return;
        }
        if (this.f12670R) {
            this.f12670R = false;
            if (this.f12654B != null) {
                this.f12654B.m12008a(3, this.f12669Q, 0, 0);
            }
            this.f12656D = this.f12655C;
            m12419D();
        }
        m12418C();
        Intent intent = new Intent(getActivity(), (Class<?>) AMSStampSelectionActivity.class);
        intent.putExtra("AMS_STAMP_INDEX", this.f12669Q);
        startActivityForResult(intent, 11);
    }

    /* renamed from: s */
    private void m12502s() {
        if (this.f12654B != null) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AMSPref", 1);
            if (!sharedPreferences.getBoolean("AMS_BG_SET_FLAG", false)) {
                this.f12687ai = false;
                sharedPreferences.edit().putBoolean("AMS_BG_SET_FLAG", this.f12687ai).commit();
            }
            this.f12654B.m12009a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, true);
            this.f12654B.m12026g();
            m12419D();
        }
    }

    /* renamed from: a */
    private void m12428a(Bitmap bitmap) {
        this.f12687ai = true;
        this.f12696m = bitmap;
        this.f12654B.m12010a(bitmap, true);
        this.f12654B.setEditMode(false, true);
        m12419D();
    }

    /* renamed from: t */
    private void m12504t() {
        this.f12690al = new AsyncTaskC3469aq(this, null);
        this.f12690al.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m12507u() {
        if (getActivity() != null) {
            if (this.f12689ak == null) {
                this.f12689ak = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f12689ak.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m12509v() {
        if (getActivity() != null && this.f12689ak != null) {
            this.f12689ak.dismiss();
        }
    }

    /* renamed from: w */
    private void m12511w() {
        if (C3410al.m12173a().m12193d() > 0) {
            this.f12669Q = 40000;
        } else if (C3410al.m12173a().m12203h() > 0) {
            this.f12669Q = 20000;
        } else {
            this.f12669Q = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m12512x() throws Resources.NotFoundException {
        if (this.f12654B != null) {
            this.f12675W = false;
            m12479i();
            RelativeLayout relativeLayout = (RelativeLayout) this.f12668P.findViewById(R.id.layout_ams);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            relativeLayout.addView(this.f12679aa);
            m12460e(this.f12655C);
            m12474h();
        }
    }

    /* renamed from: y */
    private void m12514y() {
        if (this.f12654B != null) {
            if (!this.f12654B.m12039t()) {
                m12524a(R.string.ams_msg_empty_ams);
                return;
            }
            C3402ad c3402ad = new C3402ad(getActivity());
            c3402ad.m12171a(0, R.string.ams_send_as_animation, true);
            c3402ad.m12171a(1, R.string.ams_send_as_image, true);
            c3402ad.m12171a(2, R.string.ams_save_and_exit, true);
            c3402ad.m12170a(new C3454ab(this));
            c3402ad.m12172b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m12448c(boolean z) {
        String str = AMSActivity.f12270c + m12424a("A", System.currentTimeMillis(), ".jpg");
        if (!m12452c(str)) {
            m12524a(R.string.ams_error_ams_file_save);
            this.f12677Y = false;
            return null;
        }
        this.f12677Y = true;
        File file = new File(str);
        if (file.length() < 1048576 || !z) {
            return str;
        }
        file.delete();
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_send).mo11509b(String.format("%s\n(%d/%d)", getResources().getString(R.string.ams_msg_exceed_limit), Long.valueOf(file.length()), Integer.valueOf(FeedPublishRequestParam.MESSAGE_TOO_LONG))).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3455ac(this)).mo11505a().show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[PHI: r3
  0x0061: PHI (r3v1 long) = (r3v17 long), (r3v18 long), (r3v19 long), (r3v20 long), (r3v21 long), (r3v22 long) binds: [B:3:0x0028, B:32:0x007b, B:24:0x006e, B:15:0x0057, B:19:0x005e, B:9:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.FileOutputStream] */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m12517z() throws java.lang.Throwable {
        /*
            r7 = this;
            r1 = 0
            r6 = 480(0x1e0, float:6.73E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.sec.vip.amschaton.AMSActivity.f12271d
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "I"
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = ".jpg"
            java.lang.String r2 = r7.m12424a(r2, r3, r5)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f12654B
            boolean r2 = r2.m12026g()
            if (r2 == 0) goto L61
            com.sec.vip.amschaton.AMSDrawManager r2 = r7.f12654B
            android.graphics.Bitmap r2 = r2.m12025f()
            if (r2 == 0) goto L7b
            r3 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r6, r6, r3)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L52 java.io.IOException -> L69 java.lang.Throwable -> L89
            r3.<init>(r0)     // Catch: java.io.FileNotFoundException -> L52 java.io.IOException -> L69 java.lang.Throwable -> L89
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r5 = 80
            r2.compress(r4, r5, r3)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r2.recycle()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r3.flush()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            r3.close()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96 java.io.FileNotFoundException -> L98
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L92
        L51:
            return r0
        L52:
            r2 = move-exception
            r3 = r1
        L54:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L51
        L5d:
            r0 = move-exception
        L5e:
            r0.printStackTrace()
        L61:
            r0 = 2131427562(0x7f0b00ea, float:1.8476744E38)
            r7.m12524a(r0)
            r0 = r1
            goto L51
        L69:
            r2 = move-exception
            r3 = r1
        L6b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L74
            goto L51
        L74:
            r0 = move-exception
            goto L5e
        L76:
            r0 = move-exception
            r0.printStackTrace()
        L7a:
            throw r1
        L7b:
            java.lang.String r0 = "Bitmap main is null"
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r0, r2)
            goto L61
        L89:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L8c:
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.io.IOException -> L76
            goto L51
        L92:
            r0 = move-exception
            goto L5e
        L94:
            r1 = move-exception
            goto L8c
        L96:
            r2 = move-exception
            goto L6b
        L98:
            r2 = move-exception
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.fragment.AMSComposerFragment.m12517z():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12435a(String str, String str2, int i) {
        int i2 = 2002;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(AMSActivity.f12269b)) {
                i2 = 2000;
            } else if (str.startsWith(AMSActivity.f12270c)) {
                i2 = 2001;
            }
        }
        m12526a(str, str2, i2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m12457d(boolean z) {
        if (this.f12654B == null) {
            C3250y.m11442a("[startAMSPreview] mAMSComposer is NULL!", getClass().getSimpleName());
            return false;
        }
        if (!z && !this.f12654B.m12039t()) {
            C3250y.m11442a("[startAMSPreview] Empty AMS file!", getClass().getSimpleName());
            return false;
        }
        File file = new File(AMSActivity.f12274g);
        if (file.exists()) {
            file.delete();
        }
        if (!this.f12654B.m12015a(AMSActivity.f12274g, this.f12688aj, false)) {
            C3250y.m11442a("[startAMSPreview] Fail to save AMS file!", getClass().getSimpleName());
            return false;
        }
        this.f12654B.setEditMode(false, false);
        return true;
    }

    /* renamed from: a */
    private Drawable m12423a(int i, int i2, int i3, int i4) throws Resources.NotFoundException {
        Drawable drawable;
        Drawable drawable2;
        if (i != 1) {
            return null;
        }
        if (this.f12692an != null) {
            this.f12692an.recycle();
            this.f12692an = null;
        }
        if (this.f12693ao != null) {
            this.f12693ao.recycle();
            this.f12693ao = null;
        }
        switch (i2) {
            case 1:
                drawable = getResources().getDrawable(R.drawable.ams_tool_pen_normal_h_02);
                drawable2 = getResources().getDrawable(R.drawable.ams_tool_pen_press_h_02);
                break;
            case 2:
                drawable = getResources().getDrawable(R.drawable.ams_tool_pen_normal_h_04);
                drawable2 = getResources().getDrawable(R.drawable.ams_tool_pen_press_h_04);
                break;
            case 3:
                drawable = getResources().getDrawable(R.drawable.ams_tool_pen_normal_h_03);
                drawable2 = getResources().getDrawable(R.drawable.ams_tool_pen_press_h_03);
                break;
            default:
                drawable = getResources().getDrawable(R.drawable.ams_tool_pen_normal_h_01);
                drawable2 = getResources().getDrawable(R.drawable.ams_tool_pen_press_h_01);
                break;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Rect rect = new Rect(0, 0, intrinsicWidth, intrinsicHeight);
        this.f12692an = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        this.f12693ao = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f12692an);
        Canvas canvas2 = new Canvas(this.f12693ao);
        canvas.drawColor(i3);
        canvas2.drawColor(i3);
        drawable.setBounds(rect);
        drawable.draw(canvas);
        drawable2.setBounds(rect);
        drawable2.draw(canvas2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.f12692an);
        bitmapDrawable.setTargetDensity(this.f12692an.getDensity());
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(getResources(), this.f12693ao);
        bitmapDrawable2.setTargetDensity(this.f12693ao.getDensity());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919, -16842913}, bitmapDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, bitmapDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, bitmapDrawable2);
        return stateListDrawable;
    }

    /* renamed from: A */
    private Bitmap m12416A() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (this.f12698o * 80.0f), (int) (this.f12698o * 80.0f), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawARGB(0, 0, 0, 0);
        C3399aa c3399aa = new C3399aa(2, this.f12661I, this.f12662J, false, this.f12680ab, this.f12681ac);
        c3399aa.mo12131a(this.f12698o * 2.0f);
        c3399aa.m12145b("Aa");
        int iM12150l = c3399aa.m12150l();
        int iM12151m = c3399aa.m12151m();
        c3399aa.m12819a(bitmapCreateBitmap);
        c3399aa.mo12136a((r7 - iM12150l) * 0.5f, (r8 - iM12151m) * 0.5f, "Aa", MotionEventCompat.ACTION_MASK);
        c3399aa.mo12853e();
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private Bitmap m12422a(Bundle bundle) {
        Bitmap bitmapDecodeFile;
        if (bundle.getBoolean("exceed_size", true)) {
            String string = bundle.getString("temp_file_path");
            if (string != null && (bitmapDecodeFile = BitmapFactory.decodeFile(string)) != null) {
                File file = new File(string);
                if (file.exists()) {
                    file.delete();
                    return bitmapDecodeFile;
                }
                return bitmapDecodeFile;
            }
            return null;
        }
        return (Bitmap) bundle.getParcelable(SlookAirButtonFrequentContactAdapter.DATA);
    }

    /* renamed from: a */
    private String m12424a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m12429a(EditText editText, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(editText, 2);
        } else {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12462e(boolean z) {
        if (this.f12666N != null && this.f12667O != null) {
            m12429a(this.f12667O.m12317b(), z);
            this.f12664L = z;
            if (z) {
                this.f12666N.setVisibility(0);
                m12467f(this.f12663K);
                getActivity().setTitle(R.string.ams_title_text);
            } else {
                this.f12666N.setVisibility(8);
                if (this.f12676X) {
                    getActivity().setTitle(R.string.ams_optmenu_edit);
                } else {
                    getActivity().setTitle(R.string.ams_title_create_new);
                }
            }
            getActivity().supportInvalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12467f(boolean z) {
        if (this.f12709z != null) {
            this.f12709z.setEnabled(z);
        }
    }

    /* renamed from: b */
    private void m12445b(String str) {
        if (this.f12666N != null) {
            this.f12666N = null;
        }
        if (getResources().getConfiguration().orientation == 1) {
            getView().findViewById(R.id.ams_land).findViewById(R.id.layout_text_input).setVisibility(8);
            getView().findViewById(R.id.ams_port).findViewById(R.id.layout_text_input).setVisibility(0);
        } else {
            getView().findViewById(R.id.ams_land).findViewById(R.id.layout_text_input).setVisibility(0);
            getView().findViewById(R.id.ams_port).findViewById(R.id.layout_text_input).setVisibility(8);
        }
        this.f12666N = (RelativeLayout) this.f12668P.findViewById(R.id.layout_text_input);
        this.f12666N.setOnClickListener(new ViewOnClickListenerC3456ad(this));
        if (this.f12667O != null) {
            this.f12667O = null;
        }
        this.f12667O = new ViewOnClickListenerC3437bl(this.f12668P, getActivity(), 128);
        if (str != null) {
            this.f12667O.m12316a(str);
        }
        this.f12667O.m12315a(this.f12691am);
        this.f12665M = new C3457ae(this);
        this.f12667O.m12314a(this.f12665M);
    }

    @Override // com.sec.vip.amschaton.InterfaceC3400ab
    /* renamed from: a */
    public boolean mo12152a(String str) {
        m12445b(str);
        m12462e(true);
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3581n
    /* renamed from: a */
    public boolean mo12519a(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
            case 4:
                this.f12675W = true;
                m12474h();
                break;
        }
        return false;
    }

    /* renamed from: B */
    private void m12417B() throws Resources.NotFoundException {
        if (!this.f12675W || !this.f12654B.m12036q()) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AMSPref", 1);
            this.f12687ai = false;
            sharedPreferences.edit().putBoolean("AMS_BG_SET_FLAG", this.f12687ai).commit();
            m12512x();
            return;
        }
        View viewInflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.ams_ics_layout_popup_msg, (ViewGroup) getView().findViewById(R.id.layout_root));
        ((TextView) viewInflate.findViewById(R.id.ams_dialog_message)).setText(R.string.ams_msg_exit_with_save);
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_clear_all).mo11502a(true).mo11508b(viewInflate).mo11515d(R.string.ams_btn_save, new DialogInterfaceOnClickListenerC3459ag(this)).mo11507b(R.string.ams_btn_do_not_save, new DialogInterfaceOnClickListenerC3458af(this)).mo11505a().show();
    }

    /* renamed from: g */
    private void m12472g(boolean z) {
        if (z) {
            this.f12655C = 2002;
            this.f12657E = 0;
            this.f12658F = this.f12657E;
            this.f12659G[0] = -16777216;
            this.f12659G[1] = -16777216;
            this.f12659G[3] = -16777216;
            this.f12659G[2] = -16777216;
            this.f12660H[0] = 5;
            this.f12660H[1] = 5;
            this.f12660H[3] = 5;
            this.f12660H[2] = 5;
            this.f12660H[4] = 5;
            this.f12662J = 2;
            this.f12661I = -16777216;
            this.f12669Q = 0;
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AMSPref", 1);
        this.f12655C = sharedPreferences.getInt("AMS_TOOL_TYPE", 2000);
        this.f12657E = sharedPreferences.getInt("AMS_PEN_STYLE", 0);
        this.f12658F = this.f12657E;
        this.f12659G[0] = sharedPreferences.getInt("AMS_PEN_LINE_COLOR", -16777216);
        this.f12659G[1] = sharedPreferences.getInt("AMS_PEN_BLUR_COLOR", -16777216);
        this.f12659G[2] = sharedPreferences.getInt("AMS_CPEN_MARKER_COLOR", -16777216);
        this.f12659G[3] = sharedPreferences.getInt("AMS_PEN_DOT_COLOR", -16777216);
        this.f12660H[0] = sharedPreferences.getInt("AMS_PEN_LINE", 3);
        this.f12660H[1] = sharedPreferences.getInt("AMS_PEN_BLUR_SIZE", 3);
        this.f12660H[2] = sharedPreferences.getInt("AMS_PEN_MARKER_SIZE", 3);
        this.f12660H[3] = sharedPreferences.getInt("AMS_PEN_DOT_SIZE", 3);
        this.f12660H[4] = sharedPreferences.getInt("AMS_PEN_ERASER_SIZE", 5);
        this.f12662J = sharedPreferences.getInt("AMS_TEXT_SIZE", 2);
        this.f12661I = sharedPreferences.getInt("AMS_TEXT_COLOR", -16777216);
        this.f12669Q = sharedPreferences.getInt("AMS_STAMP_STYLE", 0);
        this.f12687ai = sharedPreferences.getBoolean("AMS_BG_SET_FLAG", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m12418C() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AMSPref", 3);
        sharedPreferences.edit().putInt("AMS_TOOL_TYPE", this.f12655C).commit();
        sharedPreferences.edit().putInt("AMS_PEN_STYLE", this.f12657E).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE_COLOR", this.f12659G[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_COLOR", this.f12659G[1]).commit();
        sharedPreferences.edit().putInt("AMS_CPEN_MARKER_COLOR", this.f12659G[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_COLOR", this.f12659G[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_LINE", this.f12660H[0]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_BLUR_SIZE", this.f12660H[1]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_MARKER_SIZE", this.f12660H[2]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_DOT_SIZE", this.f12660H[3]).commit();
        sharedPreferences.edit().putInt("AMS_PEN_ERASER_SIZE", this.f12660H[4]).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_SIZE", this.f12662J).commit();
        sharedPreferences.edit().putInt("AMS_TEXT_COLOR", this.f12661I).commit();
        sharedPreferences.edit().putInt("AMS_STAMP_STYLE", this.f12669Q).commit();
        sharedPreferences.edit().putBoolean("AMS_BG_SET_FLAG", this.f12687ai).commit();
    }

    /* renamed from: h */
    private void m12476h(boolean z) throws Resources.NotFoundException {
        int i;
        if (z) {
            this.f12700q.setImageResource(R.drawable.actionbar_ic_edit);
            return;
        }
        if (this.f12685ag) {
            Drawable drawableM12423a = m12423a(1, this.f12657E, this.f12659G[this.f12657E], this.f12660H[this.f12657E]);
            if (drawableM12423a == null) {
                this.f12700q.setImageResource(R.drawable.actionbar_ic_edit);
            } else {
                this.f12700q.setImageDrawable(drawableM12423a);
            }
            m12419D();
            return;
        }
        switch (this.f12657E) {
            case 1:
                i = R.drawable.ams_tool_pen_normal_h_02;
                break;
            case 2:
                i = R.drawable.ams_tool_pen_normal_h_04;
                break;
            case 3:
                i = R.drawable.ams_tool_pen_normal_h_03;
                break;
            default:
                i = R.drawable.ams_tool_pen_normal_h_01;
                break;
        }
        this.f12700q.setImageResource(i);
    }

    /* renamed from: i */
    private void m12478i(boolean z) {
        if (this.f12707x != null) {
            this.f12707x = null;
        }
        if (z) {
            this.f12701r.setImageResource(R.drawable.ams_btn_ic_create_text);
            return;
        }
        this.f12707x = m12416A();
        if (this.f12707x == null) {
            this.f12701r.setImageResource(R.drawable.ams_btn_ic_create_text);
        } else {
            this.f12701r.setImageBitmap(this.f12707x);
        }
        m12419D();
    }

    /* renamed from: j */
    private void m12483j(boolean z) {
        int i = getActivity() != null ? getActivity().getResources().getDisplayMetrics().densityDpi : 0;
        if (this.f12708y != null) {
            this.f12708y.recycle();
            this.f12708y = null;
        }
        if (z) {
            this.f12702s.setPadding(0, 0, 0, 0);
            this.f12702s.setImageResource(R.drawable.ams_btn_ic_create_stamp);
            return;
        }
        if (this.f12669Q < C3410al.m12173a().m12208k()) {
            if (i > 240) {
                this.f12708y = C3410al.m12173a().m12195d(this.f12669Q, true);
            } else {
                this.f12708y = C3410al.m12173a().m12195d(this.f12669Q, false);
            }
        } else if (this.f12669Q < 30000) {
            if (i > 240) {
                this.f12708y = C3410al.m12173a().m12198e(this.f12669Q - 20000, true);
            } else {
                this.f12708y = C3410al.m12173a().m12198e(this.f12669Q - 20000, false);
            }
        } else if (this.f12669Q < 40000) {
            if (i > 240) {
                this.f12708y = C3410al.m12173a().m12187b(this.f12669Q - 30000, true);
            } else {
                this.f12708y = C3410al.m12173a().m12187b(this.f12669Q - 30000, false);
            }
        } else if (i > 240) {
            this.f12708y = C3410al.m12173a().m12177a(this.f12669Q - 40000, true);
        } else {
            this.f12708y = C3410al.m12173a().m12177a(this.f12669Q - 40000, false);
        }
        if (this.f12708y == null) {
            this.f12702s.setPadding(0, 0, 0, 0);
            this.f12702s.setImageResource(R.drawable.ams_btn_ic_create_stamp);
        } else {
            this.f12702s.setImageBitmap(this.f12708y);
        }
        m12419D();
    }

    /* renamed from: f */
    private void m12465f(int i) throws Resources.NotFoundException {
        m12476h(false);
        switch (i) {
            case 2003:
                m12478i(true);
                break;
            case 2005:
                m12483j(false);
                break;
        }
    }

    /* renamed from: D */
    private void m12419D() {
        if (this.f12654B != null) {
            this.f12654B.m12041v();
        }
    }

    /* renamed from: b */
    private void m12442b(int i, int i2) {
        if (this.f12654B != null && this.f12654B.m12001A()) {
            this.f12654B.m12003a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m12487k(boolean z) {
        if (this.f12654B != null) {
            if (this.f12654B.m12001A()) {
                this.f12654B.m12044y();
            }
            if (z) {
                this.f12654B.m12043x();
            }
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC3583p
    /* renamed from: a */
    public void mo12518a(boolean z) {
    }

    /* renamed from: E */
    private void m12420E() {
        if (!this.f12686ah) {
            new AsyncTaskC3470ar(this, null).execute(Boolean.TRUE);
        }
    }

    /* renamed from: F */
    private void m12421F() {
        if (!this.f12686ah) {
            new AsyncTaskC3470ar(this, null).execute(Boolean.FALSE);
        }
    }

    /* renamed from: c */
    private boolean m12452c(String str) {
        if (this.f12654B != null && this.f12654B.m12014a(str, this.f12688aj)) {
            return C3584q.m12778a().m12797a(getActivity(), str, 1001);
        }
        return false;
    }
}
