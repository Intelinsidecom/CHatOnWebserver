package com.sec.chaton.poston;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.multimedia.p079b.AsyncTaskC2751a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p049b.ContextMenuC1056a;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2074ag;
import com.sec.chaton.p057e.C2223ak;
import com.sec.chaton.p057e.C2225am;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p065io.entry.GetPostONCommentList;
import com.sec.chaton.p065io.entry.inner.PostONCommentList;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4869cg;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5035l;
import com.sec.common.util.p133a.C5017a;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class PostONDetailFragment extends Fragment implements InterfaceC3020o, InterfaceC3028w {

    /* renamed from: A */
    private TextView f10886A;

    /* renamed from: B */
    private Context f10887B;

    /* renamed from: C */
    private ImageView f10888C;

    /* renamed from: D */
    private String f10889D;

    /* renamed from: E */
    private String f10890E;

    /* renamed from: F */
    private String f10891F;

    /* renamed from: G */
    private String f10892G;

    /* renamed from: H */
    private String f10893H;

    /* renamed from: I */
    private String f10894I;

    /* renamed from: J */
    private String f10895J;

    /* renamed from: K */
    private String f10896K;

    /* renamed from: L */
    private String f10897L;

    /* renamed from: M */
    private String f10898M;

    /* renamed from: N */
    private String f10899N;

    /* renamed from: O */
    private String f10900O;

    /* renamed from: P */
    private String f10901P;

    /* renamed from: Q */
    private String f10902Q;

    /* renamed from: R */
    private ListView f10903R;

    /* renamed from: S */
    private C3018m f10904S;

    /* renamed from: U */
    private C2074ag f10906U;

    /* renamed from: V */
    private String f10907V;

    /* renamed from: W */
    private String f10908W;

    /* renamed from: X */
    private String f10909X;

    /* renamed from: Y */
    private ProgressDialog f10910Y;

    /* renamed from: Z */
    private TextView f10911Z;

    /* renamed from: aA */
    private C2210x f10912aA;

    /* renamed from: aa */
    private TextView f10919aa;

    /* renamed from: ab */
    private FrameLayout f10920ab;

    /* renamed from: ac */
    private View f10921ac;

    /* renamed from: ad */
    private ImageButton f10922ad;

    /* renamed from: ae */
    private EditText f10923ae;

    /* renamed from: af */
    private InputMethodManager f10924af;

    /* renamed from: ag */
    private Menu f10925ag;

    /* renamed from: ah */
    private InterfaceC4936e f10926ah;

    /* renamed from: ai */
    private InterfaceC4936e f10927ai;

    /* renamed from: aj */
    private FrameLayout f10928aj;

    /* renamed from: ak */
    private boolean f10929ak;

    /* renamed from: al */
    private C5007c f10930al;

    /* renamed from: am */
    private LayoutInflater f10931am;

    /* renamed from: an */
    private boolean f10932an;

    /* renamed from: ao */
    private boolean f10933ao;

    /* renamed from: ap */
    private boolean f10934ap;

    /* renamed from: aq */
    private boolean f10935aq;

    /* renamed from: ar */
    private boolean f10936ar;

    /* renamed from: as */
    private LinearLayout f10937as;

    /* renamed from: at */
    private TextView f10938at;

    /* renamed from: au */
    private int f10939au;

    /* renamed from: av */
    private String f10940av;

    /* renamed from: aw */
    private File f10941aw;

    /* renamed from: ay */
    private AlertDialogC4916i f10942ay;

    /* renamed from: t */
    private View f10945t;

    /* renamed from: u */
    private View f10946u;

    /* renamed from: v */
    private View f10947v;

    /* renamed from: w */
    private View f10948w;

    /* renamed from: x */
    private ImageView f10949x;

    /* renamed from: y */
    private TextView f10950y;

    /* renamed from: z */
    private TextView f10951z;

    /* renamed from: a */
    public static String f10867a = "POSTON_BUDDYID";

    /* renamed from: b */
    public static String f10869b = "POSTON_SENDER";

    /* renamed from: c */
    public static String f10870c = "POSTON_SENDER_NAME";

    /* renamed from: d */
    public static String f10871d = "POSTON_REG_TIME";

    /* renamed from: e */
    public static String f10872e = "POSTON_FORMATTED_TIME";

    /* renamed from: f */
    public static String f10873f = "POSTON";

    /* renamed from: g */
    public static String f10874g = "POSTON_COMMENT_COUNT";

    /* renamed from: h */
    public static String f10875h = "POSTON_COMMENT_UPDATED";

    /* renamed from: i */
    public static String f10876i = "POSTON_ID";

    /* renamed from: j */
    public static String f10877j = "POSTON_MULTIMEDIA_URL";

    /* renamed from: k */
    public static String f10878k = "POSTON_META_TYPE";

    /* renamed from: l */
    public static String f10879l = "POSTON_SENDER_NO";

    /* renamed from: m */
    public static String f10880m = "POSTON_GEO_TAG";

    /* renamed from: n */
    public static String f10881n = "POSTON_ISFROM";

    /* renamed from: o */
    public static String f10882o = "POSTON_CALLED_FROM";

    /* renamed from: p */
    public static String f10883p = "FROM_PAGER";

    /* renamed from: q */
    public static String f10884q = "FROM_LINK_PROCESSOR";

    /* renamed from: r */
    public static final String f10885r = PostONDetailFragment.class.getSimpleName();

    /* renamed from: ax */
    private static String f10868ax = C4873ck.m18502c() + "/poston/";

    /* renamed from: T */
    private ArrayList<C3021p> f10905T = new ArrayList<>();

    /* renamed from: az */
    private String f10943az = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");

    /* renamed from: aB */
    private final int f10913aB = 1;

    /* renamed from: aC */
    private final int f10914aC = 2;

    /* renamed from: aD */
    private Handler f10915aD = new HandlerC2977av(this);

    /* renamed from: aE */
    private View.OnClickListener f10916aE = new ViewOnClickListenerC2978aw(this);

    /* renamed from: s */
    AbsListView.OnScrollListener f10944s = new C2956aa(this);

    /* renamed from: aF */
    private Handler f10917aF = new HandlerC2957ab(this);

    /* renamed from: aG */
    private InterfaceC2211y f10918aG = new C2964ai(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10912aA = new C2210x(getActivity().getContentResolver(), this.f10918aG);
        this.f10907V = "";
        this.f10908W = "";
        this.f10926ah = null;
        this.f10929ak = true;
        m12232c();
    }

    /* renamed from: c */
    private void m12232c() {
        this.f10906U = new C2074ag(this.f10917aF);
        this.f10889D = C4809aa.m18104a().m18121a("chaton_id", "");
        C4809aa.m18104a().m18121a("msisdn", "");
        Bundle extras = getActivity().getIntent().getExtras();
        this.f10902Q = extras.getString(f10881n);
        if (f10884q.equals(this.f10902Q)) {
            this.f10896K = extras.getString(f10876i);
            this.f10890E = extras.getString(f10867a);
        } else {
            this.f10890E = extras.getString(f10867a);
            this.f10891F = extras.getString(f10870c);
            this.f10892G = extras.getString(f10871d);
            this.f10893H = extras.getString(f10872e);
            this.f10894I = extras.getString(f10873f);
            this.f10895J = extras.getString(f10874g);
            this.f10896K = extras.getString(f10876i);
            this.f10897L = extras.getString(f10877j);
            this.f10898M = extras.getString(f10878k);
            this.f10899N = extras.getString(f10882o);
            this.f10900O = extras.getString(f10879l);
            this.f10901P = extras.getString(f10880m);
        }
        this.f10924af = (InputMethodManager) getActivity().getSystemService("input_method");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseActivity.m6160a((Fragment) this, true);
        this.f10887B = CommonApplication.m18732r();
        this.f10930al = new C5007c();
        this.f10931am = (LayoutInflater) this.f10887B.getSystemService("layout_inflater");
        this.f10910Y = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.wait_sending);
        this.f10945t = layoutInflater.inflate(R.layout.layout_poston_comment_list, viewGroup, false);
        this.f10946u = layoutInflater.inflate(R.layout.layout_common_detail, (ViewGroup) null);
        this.f10949x = (ImageView) this.f10946u.findViewById(R.id.image1);
        this.f10950y = (TextView) this.f10946u.findViewById(R.id.text2);
        this.f10951z = (TextView) this.f10946u.findViewById(R.id.text1);
        this.f10886A = (TextView) this.f10946u.findViewById(R.id.text3);
        this.f10888C = (ImageView) this.f10946u.findViewById(R.id.image2);
        this.f10920ab = (FrameLayout) this.f10946u.findViewById(R.id.space1);
        this.f10937as = (LinearLayout) this.f10945t.findViewById(R.id.floating_menu_layout);
        this.f10938at = (TextView) this.f10945t.findViewById(R.id.text_counter);
        this.f10937as.setVisibility(8);
        this.f10886A.setAutoLinkMask(15);
        this.f10921ac = this.f10945t.findViewById(R.id.bottomContentLayout);
        this.f10923ae = (EditText) this.f10921ac.findViewById(R.id.edit_text1);
        this.f10923ae.setHint(R.string.trunk_item_write_a_comment);
        this.f10923ae.setMaxLines(5);
        this.f10922ad = (ImageButton) this.f10921ac.findViewById(R.id.button2);
        this.f10922ad.setBackgroundResource(R.drawable.button6);
        this.f10922ad.setContentDescription(getString(R.string.buddy_group_edit_menubar_add));
        this.f10922ad.setImageResource(R.drawable.chat_btn_icon_send);
        ((ImageButton) this.f10921ac.findViewById(R.id.button1)).setVisibility(8);
        ImageView imageView = new ImageView(this.f10887B);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageDrawable(this.f10887B.getResources().getDrawable(R.drawable.chat_btn_play));
        ((FrameLayout.LayoutParams) this.f10920ab.getLayoutParams()).gravity = 16;
        this.f10920ab.addView(imageView);
        this.f10920ab.setVisibility(8);
        this.f10940av = f10868ax + this.f10890E;
        this.f10947v = layoutInflater.inflate(R.layout.layout_poston_comment_header2, (ViewGroup) null);
        this.f10948w = this.f10947v.findViewById(R.id.poston_comment_location);
        this.f10919aa = (TextView) this.f10948w.findViewById(R.id.location);
        this.f10919aa.setOnClickListener(this.f10916aE);
        this.f10911Z = (TextView) this.f10947v.findViewById(R.id.poston_comment_sub_title).findViewById(R.id.text1);
        this.f10911Z.setCompoundDrawablesWithIntrinsicBounds(R.drawable.co_list_ic_comment, 0, 0, 0);
        this.f10911Z.setCompoundDrawablesWithIntrinsicBounds(R.drawable.co_list_ic_comment, 0, 0, 0);
        this.f10928aj = (FrameLayout) this.f10947v.findViewById(R.id.poston_comment_loading_progressbar);
        if (C1427a.m7518a()) {
            this.f10948w.setVisibility(0);
        } else {
            this.f10948w.setVisibility(8);
        }
        if (f10884q.equals(this.f10902Q)) {
            if (this.f10896K != null && this.f10890E != null) {
                this.f10906U.m9301e(this.f10896K, this.f10890E);
                this.f10910Y.show();
            }
        } else {
            m12240e();
        }
        this.f10923ae.setFilters(new InputFilter[]{new C4902w(getActivity(), 140)});
        this.f10923ae.addTextChangedListener(new C3029x(this));
        this.f10923ae.setOnEditorActionListener(new C2971ap(this));
        this.f10922ad.setEnabled(false);
        this.f10922ad.setOnClickListener(new ViewOnClickListenerC2972aq(this));
        this.f10903R = (ListView) this.f10945t.findViewById(R.id.poston_comment_list);
        registerForContextMenu(this.f10903R);
        this.f10903R.addHeaderView(this.f10946u, null, false);
        this.f10903R.addHeaderView(this.f10947v, null, false);
        this.f10905T.clear();
        this.f10904S = new C3018m(this.f10903R, getActivity(), this.f10905T, R.layout.list_item_common_10, this.f10890E);
        this.f10904S.m12381a(this);
        this.f10903R.setAdapter((ListAdapter) this.f10904S);
        this.f10903R.setScrollbarFadingEnabled(true);
        this.f10903R.setOnScrollListener(this.f10944s);
        m12236d();
        if (!f10884q.equals(this.f10902Q)) {
            m12279b();
        }
        return this.f10945t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12236d() {
        this.f10927ai = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.poston_title)).mo18751b(false).mo18749b(getResources().getString(R.string.trunk_content_deleted)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2973ar(this)).mo18745a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12240e() {
        m12244f();
        m12248g();
        m12251h();
        this.f10950y.setText(this.f10893H);
        this.f10886A.setText(this.f10894I);
    }

    /* renamed from: f */
    private void m12244f() {
        if (this.f10901P != null && this.f10901P.length() > 0) {
            this.f10948w.setVisibility(0);
            String strM12218a = m12218a(this.f10901P);
            if (strM12218a != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("setLocationView addr = " + strM12218a, f10885r);
                }
                this.f10919aa.setText(strM12218a);
                C5035l.m19114a(this.f10919aa);
                this.f10919aa.setTag(this.f10901P);
                return;
            }
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("setLocationView no location", f10885r);
        }
        this.f10948w.setVisibility(8);
    }

    /* renamed from: a */
    private String m12218a(String str) {
        if (str.length() > 1) {
            StringTokenizer stringTokenizer = new StringTokenizer(str.substring(1, str.length() - 1), ",");
            String str2 = "";
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                int i2 = i + 1;
                String strNextToken = stringTokenizer.nextToken();
                if (i2 < 3 || TextUtils.isEmpty(strNextToken)) {
                    strNextToken = str2;
                } else if (str2.length() != 0) {
                    strNextToken = str2 + "," + strNextToken;
                }
                str2 = strNextToken;
                i = i2;
            }
            return str2;
        }
        return null;
    }

    /* renamed from: g */
    private void m12248g() {
        m12223a(false);
        m12229b(false);
        if (this.f10897L != null && !this.f10898M.equals(C3009d.f11133d)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("setImageView has Multimedia", f10885r);
            }
            this.f10888C.setVisibility(0);
            this.f10941aw = new File(this.f10940av, this.f10897L.split("/")[r0.length - 1]);
            if (this.f10941aw.exists() && this.f10941aw.length() > 0) {
                m12223a(true);
                m12229b(true);
            }
            if (this.f10898M.equals(C3009d.f11132c)) {
                this.f10920ab.setVisibility(0);
                this.f10888C.setOnClickListener(new ViewOnClickListenerC2974as(this));
            } else {
                this.f10920ab.setVisibility(8);
                this.f10888C.setOnClickListener(null);
            }
            this.f10930al.m19023b(this.f10888C, new CallableC2983ba(this.f10897L, this.f10890E, this.f10898M.equals(C3009d.f11131b), CallableC2983ba.f11083c, CallableC2983ba.f11084d, this.f10915aD));
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("setImageView has No Multimedia", f10885r);
        }
        this.f10888C.setVisibility(8);
        if (!TextUtils.isEmpty(this.f10894I)) {
            m12223a(true);
        }
    }

    /* renamed from: h */
    private void m12251h() {
        if (this.f10900O.equals(this.f10889D)) {
            C2496n.m10763a(this.f10949x, EnumC2498p.ROUND);
            this.f10951z.setText(R.string.setting_interaction_me);
        } else {
            C2496n.m10765a(this.f10949x, this.f10900O, EnumC2498p.ROUND);
            this.f10951z.setText(this.f10891F);
        }
        if (C4822an.m18218a()) {
            this.f10949x.setBackgroundResource(R.drawable.circle_background);
        }
        this.f10949x.setOnClickListener(new ViewOnClickListenerC2975at(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m12254i() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f10887B, R.string.sdcard_not_found, 0).show();
            return;
        }
        if (this.f10942ay == null) {
            this.f10942ay = new AlertDialogC4916i(getActivity());
            this.f10942ay.setTitle(R.string.download_title);
            this.f10942ay.setMessage(getString(R.string.anicon_file_downloading));
            this.f10942ay.setCancelable(false);
        }
        this.f10942ay.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2976au(this));
        this.f10942ay.show();
        this.f10942ay.m18719a(0);
        try {
            C5017a.m19064a().m19068a(this.f10915aD, this.f10897L + this.f10943az, this.f10941aw, null);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f10885r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m12226b(String str) {
        if (str.length() > 1) {
            StringTokenizer stringTokenizer = new StringTokenizer(str.substring(1, str.length() - 1), ",");
            if (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    return strNextToken + "," + stringTokenizer.nextToken();
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C4904y.m18639b("onPrepareOptionMenu...", getClass().getSimpleName());
        this.f10925ag.clear();
        if ((this.f10890E != null && this.f10890E.equals(this.f10889D)) || (this.f10900O != null && this.f10900O.equals(this.f10889D))) {
            this.f10925ag.add(0, 1, 1, getString(R.string.save)).setIcon(R.drawable.more_option_save_white);
            this.f10925ag.add(0, 2, 2, getString(R.string.trunk_btn_share)).setIcon(R.drawable.more_option_share_white);
            this.f10925ag.add(0, 3, 3, R.string.chat_view_menu_delete).setIcon(R.drawable.more_option_delete_white);
            this.f10925ag.findItem(3).setEnabled(true);
        } else {
            this.f10925ag.add(0, 1, 1, getString(R.string.save)).setIcon(R.drawable.more_option_save_white);
            this.f10925ag.add(0, 2, 2, getString(R.string.trunk_btn_share)).setIcon(R.drawable.more_option_share_white);
        }
        if (this.f10932an) {
            this.f10925ag.findItem(2).setVisible(true);
        } else {
            this.f10925ag.findItem(2).setVisible(false);
        }
        if (this.f10933ao) {
            this.f10925ag.findItem(1).setVisible(true);
        } else {
            this.f10925ag.findItem(1).setVisible(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f10925ag = menu;
        super.onCreateOptionsMenu(this.f10925ag, menuInflater);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                m12257j();
                return true;
            case 2:
                m12260k();
                return true;
            case 3:
                this.f10926ah = AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.memo_delete_context_menu).mo18746b(R.string.ams_delete_single_item).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3031z(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3030y(this)).mo18752b();
                return true;
            case android.R.id.home:
                ((InterfaceC2979ax) getActivity()).mo12200a(this.f10911Z.getText().toString(), this.f10935aq);
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12223a(boolean z) {
        this.f10932an = z;
        if (this.f10925ag != null && this.f10925ag.findItem(2) != null) {
            if (z) {
                this.f10925ag.findItem(2).setVisible(true);
            } else {
                this.f10925ag.findItem(2).setVisible(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12229b(boolean z) {
        this.f10933ao = z;
        if (this.f10925ag != null && this.f10925ag.findItem(1) != null) {
            if (z) {
                this.f10925ag.findItem(1).setVisible(true);
            } else {
                this.f10925ag.findItem(1).setVisible(false);
            }
        }
    }

    /* renamed from: b */
    public void m12279b() {
        this.f10928aj.setVisibility(0);
        this.f10929ak = true;
        this.f10906U.m9300d(this.f10890E, this.f10896K);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f10910Y != null) {
            this.f10910Y.dismiss();
        }
        if (this.f10926ah != null) {
            this.f10926ah.dismiss();
        }
        if (this.f10927ai != null) {
            this.f10927ai.dismiss();
        }
        this.f10906U.m9299d();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f10942ay != null && this.f10942ay.isShowing()) {
            C5017a.m19064a().m19070a(this.f10915aD, this.f10897L + this.f10943az);
            this.f10942ay.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12227b(C0778b c0778b, boolean z) {
        m12219a(((GetPostONCommentList) c0778b.m3110e()).commentlist, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12219a(PostONCommentList postONCommentList, boolean z) {
        if (postONCommentList != null) {
            this.f10907V = postONCommentList.hasmore;
            this.f10908W = postONCommentList.endtime;
            this.f10909X = postONCommentList.totalcount;
            if (this.f10890E != null && this.f10890E.equals(this.f10889D) && !TextUtils.isEmpty(this.f10896K)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_comment_count", this.f10909X);
                contentValues.put("unread_comment_count", Spam.ACTIVITY_CANCEL);
                if (this.f10908W != null && z) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("order_msec", this.f10908W);
                    this.f10912aA.startUpdate(2, null, C2225am.f7951a, contentValues2, "poston_id = ?  AND order_msec < ? ", new String[]{this.f10896K, this.f10908W});
                }
                this.f10912aA.startUpdate(2, null, C2225am.f7951a, contentValues, "poston_id = ? ", new String[]{this.f10896K});
            }
            this.f10912aA.startQuery(1, null, C2223ak.f7948b, null, null, null, null);
        }
    }

    /* renamed from: a */
    public void m12277a(C0778b c0778b, boolean z) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            m12227b(c0778b, z);
        } else if (c0778b.m3111f() == 90016 || c0778b.m3111f() == 93503) {
            if (this.f10927ai == null) {
                m12236d();
            }
            this.f10927ai.show();
        } else {
            if (this.f10910Y != null) {
                this.f10910Y.dismiss();
            }
            if (this.f10928aj != null) {
                this.f10928aj.setVisibility(8);
            }
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
            } else {
                C5179v.m19810a(getActivity(), R.string.toast_network_unable, 0).show();
            }
            this.f10905T.clear();
            if (this.f10904S != null) {
                this.f10904S.notifyDataSetChanged();
            }
        }
        this.f10929ak = false;
    }

    /* renamed from: j */
    private void m12257j() {
        if (!C4847bl.m18333a()) {
            if (!C4873ck.m18500a()) {
                C5179v.m19810a(this.f10887B, R.string.sdcard_not_found, 0).show();
                return;
            }
            String str = this.f10897L.split("/")[r0.length - 1];
            if (C4904y.f17872b) {
                C4904y.m18639b("saveMedia File : " + this.f10940av + "/" + str, f10885r);
            }
            AsyncTaskC2751a.m11541a(this.f10940av + "/" + str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", null, false).execute(new String[0]);
        }
    }

    /* renamed from: k */
    private void m12260k() {
        Intent intentM18493a = null;
        if (!C4847bl.m18333a()) {
            if (this.f10897L != null) {
                String str = this.f10897L.split("/")[r0.length - 1];
                if (C3009d.f11131b.equals(this.f10898M)) {
                    intentM18493a = C4869cg.m18494a((Context) getActivity(), getString(R.string.trunk_opt_header_share), this.f10940av + "/" + str, (String) null, (String) null, false);
                } else if (C3009d.f11132c.equals(this.f10898M)) {
                    intentM18493a = C4869cg.m18492a(getActivity(), getString(R.string.trunk_opt_header_share), this.f10940av + "/" + str, (String) null, (String) null);
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("shareMedia File : " + this.f10940av + "/" + str, f10885r);
                }
            } else if (!TextUtils.isEmpty(this.f10894I)) {
                intentM18493a = C4869cg.m18493a(getActivity(), getString(R.string.trunk_opt_header_share), this.f10894I, (String) null, (String) null, EnumC2214ab.TEXT);
            }
            if (intentM18493a != null) {
                startActivity(intentM18493a);
            }
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC3020o
    /* renamed from: a */
    public void mo12278a(String str, String str2) {
        if (!C4847bl.m18333a()) {
            ((InterfaceC2979ax) getActivity()).mo12199a(str, str2);
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC1056a contextMenuC1056a = new ContextMenuC1056a(this.f10887B, contextMenu);
        C3021p c3021p = (C3021p) this.f10903R.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (c3021p != null && !this.f10903R.getAdapter().isEmpty()) {
            String strM12385d = c3021p.m12385d();
            String strM12382a = c3021p.m12382a();
            String strM12386e = c3021p.m12386e();
            if (strM12385d != null && strM12382a != null) {
                if (this.f10890E.equals(this.f10889D)) {
                    if (this.f10889D.equals(strM12382a)) {
                        contextMenuC1056a.setHeaderTitle(R.string.setting_interaction_me);
                    } else {
                        contextMenuC1056a.setHeaderTitle(c3021p.m12383b());
                    }
                    contextMenuC1056a.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2965aj(this, strM12382a, strM12385d, strM12386e));
                    return;
                }
                if (this.f10889D.equals(c3021p.m12382a())) {
                    contextMenuC1056a.setHeaderTitle(R.string.setting_interaction_me);
                    contextMenuC1056a.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2968am(this, strM12385d, strM12386e));
                }
            }
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC3028w
    /* renamed from: a */
    public void mo12276a() {
        ((InterfaceC2979ax) getActivity()).mo12200a(this.f10911Z.getText().toString(), this.f10935aq);
    }
}
