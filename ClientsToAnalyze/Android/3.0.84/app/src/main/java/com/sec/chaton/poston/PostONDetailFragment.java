package com.sec.chaton.poston;

import android.app.ProgressDialog;
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
import com.sec.chaton.multimedia.p048a.AsyncTaskC1767a;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1344v;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3348j;
import com.sec.common.util.p070a.C3332a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class PostONDetailFragment extends Fragment implements InterfaceC2024o {

    /* renamed from: A */
    private ImageView f7503A;

    /* renamed from: B */
    private String f7504B;

    /* renamed from: C */
    private String f7505C;

    /* renamed from: D */
    private String f7506D;

    /* renamed from: E */
    private String f7507E;

    /* renamed from: F */
    private String f7508F;

    /* renamed from: G */
    private String f7509G;

    /* renamed from: H */
    private String f7510H;

    /* renamed from: I */
    private String f7511I;

    /* renamed from: J */
    private String f7512J;

    /* renamed from: K */
    private String f7513K;

    /* renamed from: L */
    private String f7514L;

    /* renamed from: M */
    private String f7515M;

    /* renamed from: N */
    private String f7516N;

    /* renamed from: O */
    private String f7517O;

    /* renamed from: P */
    private String f7518P;

    /* renamed from: Q */
    private ListView f7519Q;

    /* renamed from: R */
    private C2022m f7520R;

    /* renamed from: T */
    private C1344v f7522T;

    /* renamed from: U */
    private String f7523U;

    /* renamed from: V */
    private String f7524V;

    /* renamed from: W */
    private ProgressDialog f7525W;

    /* renamed from: X */
    private TextView f7526X;

    /* renamed from: Y */
    private TextView f7527Y;

    /* renamed from: Z */
    private FrameLayout f7528Z;

    /* renamed from: aa */
    private FrameLayout f7529aa;

    /* renamed from: ab */
    private ImageButton f7530ab;

    /* renamed from: ac */
    private EditText f7531ac;

    /* renamed from: ad */
    private InputMethodManager f7532ad;

    /* renamed from: ae */
    private Menu f7533ae;

    /* renamed from: af */
    private ProgressDialog f7534af;

    /* renamed from: ag */
    private int f7535ag;

    /* renamed from: ah */
    private InterfaceC3274d f7536ah;

    /* renamed from: ai */
    private FrameLayout f7537ai;

    /* renamed from: aj */
    private boolean f7538aj;

    /* renamed from: ak */
    private boolean f7539ak;

    /* renamed from: al */
    private C3326c f7540al;

    /* renamed from: am */
    private LayoutInflater f7541am;

    /* renamed from: an */
    private boolean f7542an;

    /* renamed from: ao */
    private boolean f7543ao;

    /* renamed from: ap */
    private String f7544ap;

    /* renamed from: aq */
    private File f7545aq;

    /* renamed from: as */
    private ProgressDialog f7546as;

    /* renamed from: r */
    private View f7552r;

    /* renamed from: s */
    private View f7553s;

    /* renamed from: t */
    private View f7554t;

    /* renamed from: u */
    private View f7555u;

    /* renamed from: v */
    private ImageView f7556v;

    /* renamed from: w */
    private TextView f7557w;

    /* renamed from: x */
    private TextView f7558x;

    /* renamed from: y */
    private TextView f7559y;

    /* renamed from: z */
    private Context f7560z;

    /* renamed from: a */
    public static String f7486a = "POSTON_BUDDYID";

    /* renamed from: b */
    public static String f7488b = "POSTON_SENDER";

    /* renamed from: c */
    public static String f7489c = "POSTON_SENDER_NAME";

    /* renamed from: d */
    public static String f7490d = "POSTON_REG_TIME";

    /* renamed from: e */
    public static String f7491e = "POSTON_FORMATTED_TIME";

    /* renamed from: f */
    public static String f7492f = "POSTON";

    /* renamed from: g */
    public static String f7493g = "POSTON_COMMENT_COUNT";

    /* renamed from: h */
    public static String f7494h = "POSTON_ID";

    /* renamed from: i */
    public static String f7495i = "POSTON_MULTIMEDIA_URL";

    /* renamed from: j */
    public static String f7496j = "POSTON_META_TYPE";

    /* renamed from: k */
    public static String f7497k = "POSTON_SENDER_NO";

    /* renamed from: l */
    public static String f7498l = "POSTON_GEO_TAG";

    /* renamed from: m */
    public static String f7499m = "POSTON_ISFROM";

    /* renamed from: n */
    public static String f7500n = "POSTON_CALLED_FROM";

    /* renamed from: o */
    public static String f7501o = "FROM_PAGER";

    /* renamed from: p */
    public static final String f7502p = PostONDetailFragment.class.getSimpleName();

    /* renamed from: ar */
    private static String f7487ar = C3223ck.m11329c() + "/poston/";

    /* renamed from: S */
    private ArrayList<C2025p> f7521S = new ArrayList<>();

    /* renamed from: at */
    private String f7547at = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");

    /* renamed from: au */
    private Handler f7548au = new HandlerC1978ar(this);

    /* renamed from: av */
    private View.OnClickListener f7549av = new ViewOnClickListenerC1979as(this);

    /* renamed from: q */
    AbsListView.OnScrollListener f7551q = new C2033x(this);

    /* renamed from: aw */
    private Handler f7550aw = new HandlerC2034y(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7523U = "";
        this.f7524V = "";
        this.f7534af = null;
        this.f7536ah = null;
        this.f7538aj = true;
        m7930a();
    }

    /* renamed from: a */
    private void m7930a() {
        this.f7522T = new C1344v(this.f7550aw);
        this.f7504B = C3159aa.m10962a().m10979a("chaton_id", "");
        C3159aa.m10962a().m10979a("msisdn", "");
        Bundle extras = getActivity().getIntent().getExtras();
        this.f7505C = extras.getString(f7486a);
        this.f7506D = extras.getString(f7488b);
        this.f7507E = extras.getString(f7489c);
        this.f7508F = extras.getString(f7490d);
        this.f7509G = extras.getString(f7491e);
        this.f7510H = extras.getString(f7492f);
        this.f7511I = extras.getString(f7493g);
        this.f7512J = extras.getString(f7494h);
        this.f7513K = extras.getString(f7495i);
        this.f7514L = extras.getString(f7496j);
        this.f7515M = extras.getString(f7500n);
        this.f7516N = extras.getString(f7497k);
        this.f7517O = extras.getString(f7498l);
        this.f7518P = extras.getString(f7499m);
        if ("MY_PAGE".equals(this.f7515M)) {
            this.f7539ak = true;
        } else {
            this.f7539ak = false;
        }
        this.f7532ad = (InputMethodManager) getActivity().getSystemService("input_method");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseActivity.m3081a(this, true);
        this.f7560z = CommonApplication.m11493l();
        this.f7540al = new C3326c();
        this.f7541am = (LayoutInflater) this.f7560z.getSystemService("layout_inflater");
        this.f7552r = layoutInflater.inflate(R.layout.layout_poston_comment_list, viewGroup, false);
        this.f7553s = layoutInflater.inflate(R.layout.layout_common_detail, (ViewGroup) null);
        this.f7556v = (ImageView) this.f7553s.findViewById(R.id.image1);
        this.f7557w = (TextView) this.f7553s.findViewById(R.id.text2);
        this.f7558x = (TextView) this.f7553s.findViewById(R.id.text1);
        this.f7559y = (TextView) this.f7553s.findViewById(R.id.text3);
        this.f7503A = (ImageView) this.f7553s.findViewById(R.id.image2);
        this.f7528Z = (FrameLayout) this.f7553s.findViewById(R.id.space1);
        this.f7529aa = (FrameLayout) this.f7553s.findViewById(R.id.imageframe);
        this.f7559y.setAutoLinkMask(15);
        ImageView imageView = new ImageView(this.f7560z);
        imageView.setImageDrawable(this.f7560z.getResources().getDrawable(R.drawable.chat_btn_play));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f7528Z.addView(imageView);
        this.f7528Z.setVisibility(8);
        this.f7544ap = f7487ar + this.f7505C;
        this.f7554t = layoutInflater.inflate(R.layout.layout_poston_comment_header2, (ViewGroup) null);
        this.f7555u = (LinearLayout) this.f7554t.findViewById(R.id.poston_comment_location);
        this.f7527Y = (TextView) this.f7555u.findViewById(R.id.location);
        this.f7527Y.setOnClickListener(this.f7549av);
        this.f7526X = (TextView) ((LinearLayout) this.f7554t.findViewById(R.id.poston_comment_sub_title)).findViewById(R.id.text1);
        this.f7526X.setCompoundDrawablesWithIntrinsicBounds(R.drawable.co_list_ic_comment, 0, 0, 0);
        this.f7537ai = (FrameLayout) this.f7554t.findViewById(R.id.poston_comment_loading_progressbar);
        if (C0816a.m4365a()) {
            this.f7555u.setVisibility(0);
        } else {
            this.f7555u.setVisibility(8);
        }
        m7935b();
        m7939c();
        C3205bt.m11182a(this.f7560z).m11210a(this.f7556v, this.f7516N);
        this.f7556v.setOnClickListener(new ViewOnClickListenerC2032w(this));
        if (this.f7504B.equals(this.f7516N)) {
            this.f7558x.setText(R.string.setting_interaction_me);
        } else {
            this.f7558x.setText(this.f7507E);
        }
        this.f7557w.setText(this.f7509G);
        this.f7559y.setText(this.f7510H);
        this.f7531ac = (EditText) this.f7552r.findViewById(R.id.postOnCommentEdit);
        this.f7531ac.setFilters(new InputFilter[]{new C3248w(getActivity(), 140)});
        this.f7531ac.addTextChangedListener(new C1974an(this));
        this.f7530ab = (ImageButton) this.f7552r.findViewById(R.id.postOnCommentSendBtn);
        this.f7530ab.setEnabled(false);
        this.f7530ab.setOnClickListener(new ViewOnClickListenerC1975ao(this));
        this.f7519Q = (ListView) this.f7552r.findViewById(R.id.poston_comment_list);
        registerForContextMenu(this.f7519Q);
        this.f7525W = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.wait_sending);
        this.f7519Q.addHeaderView(this.f7553s, null, true);
        this.f7519Q.addHeaderView(this.f7554t, null, false);
        this.f7519Q.setItemsCanFocus(true);
        this.f7521S.clear();
        this.f7520R = new C2022m(this.f7519Q, getActivity(), this.f7521S, R.layout.list_item_poston_comment, this.f7505C);
        this.f7520R.m8061a(this);
        this.f7519Q.setAdapter((ListAdapter) this.f7520R);
        this.f7519Q.setScrollbarFadingEnabled(true);
        this.f7519Q.setOnScrollListener(this.f7551q);
        m7968a(0, (ProgressDialog) null);
        return this.f7552r;
    }

    /* renamed from: b */
    private void m7935b() {
        if (this.f7517O != null && this.f7517O.length() > 0) {
            this.f7555u.setVisibility(0);
            String strM7934b = m7934b(this.f7517O);
            if (strM7934b != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("setLocationView addr = " + strM7934b, f7502p);
                }
                this.f7527Y.setText(strM7934b);
                C3348j.m11796a(this.f7527Y);
                this.f7527Y.setTag(this.f7517O);
                return;
            }
            return;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("setLocationView no location", f7502p);
        }
        this.f7555u.setVisibility(8);
    }

    /* renamed from: b */
    private String m7934b(String str) {
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

    /* renamed from: c */
    private void m7939c() {
        m7932a(false);
        m7937b(false);
        if (this.f7513K != null && !this.f7514L.equals(C2013d.f7737d)) {
            if (C3250y.f11734b) {
                C3250y.m11450b("setImageView has Multimedia", f7502p);
            }
            this.f7503A.setVisibility(0);
            this.f7545aq = new File(this.f7544ap, this.f7513K.split("/")[r0.length - 1]);
            if (this.f7545aq.exists() && this.f7545aq.length() > 0) {
                m7932a(true);
                m7937b(true);
            }
            if (this.f7514L.equals(C2013d.f7736c)) {
                this.f7528Z.setVisibility(0);
                this.f7529aa.setFocusable(true);
                this.f7529aa.setBackground(getActivity().getResources().getDrawable(R.drawable.mypage_profile_image_selector));
                this.f7529aa.setOnClickListener(new ViewOnClickListenerC1976ap(this));
            } else {
                this.f7528Z.setVisibility(8);
                this.f7503A.setOnClickListener(null);
            }
            CallableC1986az callableC1986az = new CallableC1986az(this.f7513K, this.f7505C, this.f7514L.equals(C2013d.f7735b), CallableC1986az.f7684c, CallableC1986az.f7685d, this.f7548au);
            if (callableC1986az != null) {
                this.f7540al.m11730a(this.f7503A, callableC1986az);
                return;
            }
            return;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("setImageView has No Multimedia", f7502p);
        }
        this.f7503A.setVisibility(8);
        if (!TextUtils.isEmpty(this.f7510H)) {
            m7932a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7942d() {
        if (this.f7546as == null) {
            this.f7546as = new ProgressDialog(getActivity());
            this.f7546as.setProgressStyle(1);
            this.f7546as.setMessage(getResources().getString(R.string.media_file_download));
            this.f7546as.setCancelable(false);
        }
        this.f7546as.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1977aq(this));
        this.f7546as.show();
        this.f7546as.setProgress(0);
        try {
            C3332a.m11750a().m11754a(this.f7548au, this.f7513K + this.f7547at, this.f7545aq, null);
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f7502p);
            }
        }
    }

    /* renamed from: a */
    String m7967a(String str) {
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
        C3250y.m11450b("onPrepareOptionMenu...", getClass().getSimpleName());
        this.f7533ae.clear();
        if (!this.f7505C.equals(this.f7504B) && !this.f7506D.equals(this.f7504B)) {
            this.f7533ae.add(0, 1, 1, getString(R.string.save)).setIcon(R.drawable.more_option_save_white);
            this.f7533ae.add(0, 2, 2, getString(R.string.trunk_btn_share)).setIcon(R.drawable.more_option_share_white);
        } else {
            this.f7533ae.add(0, 1, 1, getString(R.string.save)).setIcon(R.drawable.more_option_save_white);
            this.f7533ae.add(0, 2, 2, getString(R.string.trunk_btn_share)).setIcon(R.drawable.more_option_share_white);
            this.f7533ae.add(0, 3, 3, R.string.chat_view_menu_delete).setIcon(R.drawable.more_option_delete_white);
            this.f7533ae.findItem(3).setEnabled(true);
        }
        if (this.f7542an) {
            this.f7533ae.findItem(2).setVisible(true);
        } else {
            this.f7533ae.findItem(2).setVisible(false);
        }
        if (this.f7543ao) {
            this.f7533ae.findItem(1).setVisible(true);
        } else {
            this.f7533ae.findItem(1).setVisible(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f7533ae = menu;
        super.onCreateOptionsMenu(this.f7533ae, menuInflater);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                m7944e();
                return true;
            case 2:
                m7946f();
                return true;
            case 3:
                this.f7536ah = AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.memo_delete_context_menu).mo11506b(R.string.trunk_item_deleted).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1981au(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1980at(this)).mo11512b();
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7932a(boolean z) {
        this.f7542an = z;
        if (this.f7533ae != null && this.f7533ae.findItem(2) != null) {
            if (z) {
                this.f7533ae.findItem(2).setVisible(true);
            } else {
                this.f7533ae.findItem(2).setVisible(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7937b(boolean z) {
        this.f7543ao = z;
        if (this.f7533ae != null && this.f7533ae.findItem(1) != null) {
            if (z) {
                this.f7533ae.findItem(1).setVisible(true);
            } else {
                this.f7533ae.findItem(1).setVisible(false);
            }
        }
    }

    /* renamed from: a */
    public void m7968a(int i, ProgressDialog progressDialog) {
        if (progressDialog != null) {
            this.f7534af = progressDialog;
            this.f7535ag = i;
        } else {
            this.f7537ai.setVisibility(0);
        }
        this.f7538aj = true;
        this.f7522T.m5925d(this.f7505C, this.f7512J);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f7525W != null) {
            this.f7525W.dismiss();
        }
        if (this.f7534af != null) {
            this.f7534af.dismiss();
        }
        if (this.f7536ah != null) {
            this.f7536ah.dismiss();
        }
        this.f7522T.m5924d();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroy();
        if (this.f7546as != null && this.f7546as.isShowing()) {
            C3332a.m11750a().m11756a(this.f7548au, this.f7513K + this.f7547at);
            this.f7546as.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01a9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7969a(com.sec.chaton.p016a.p017a.C0267d r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.poston.PostONDetailFragment.m7969a(com.sec.chaton.a.a.d):void");
    }

    /* renamed from: e */
    private void m7944e() {
        if (!C3197bl.m11159a()) {
            if (!C3223ck.m11327a()) {
                C3641ai.m13210a(this.f7560z, R.string.sdcard_not_found, 0).show();
                return;
            }
            String str = this.f7513K.split("/")[r0.length - 1];
            if (C3250y.f11734b) {
                C3250y.m11450b("saveMedia File : " + this.f7544ap + "/" + str, f7502p);
            }
            new AsyncTaskC1767a(this.f7544ap + "/" + str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", false).execute(new String[0]);
        }
    }

    /* renamed from: f */
    private void m7946f() {
        Intent intentM11321a = null;
        if (!C3197bl.m11159a()) {
            if (this.f7513K != null) {
                String str = this.f7513K.split("/")[r0.length - 1];
                if (C2013d.f7735b.equals(this.f7514L)) {
                    intentM11321a = C3220ch.m11320a(getActivity(), getString(R.string.trunk_opt_header_share), this.f7544ap + "/" + str, (String) null, (String) null);
                } else if (C2013d.f7736c.equals(this.f7514L)) {
                    intentM11321a = C3220ch.m11326b(getActivity(), getString(R.string.trunk_opt_header_share), this.f7544ap + "/" + str, null, null);
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("shareMedia File : " + this.f7544ap + "/" + str, f7502p);
                }
            } else if (!TextUtils.isEmpty(this.f7510H)) {
                intentM11321a = C3220ch.m11321a(getActivity(), getString(R.string.trunk_opt_header_share), this.f7510H, (String) null, (String) null, EnumC1455w.TEXT);
            }
            if (intentM11321a != null) {
                startActivity(intentM11321a);
            }
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2024o
    /* renamed from: a */
    public void mo7970a(String str, String str2) {
        if (!C3197bl.m11159a()) {
            ((InterfaceC1982av) getActivity()).mo7923a(str, str2);
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(this.f7560z, contextMenu);
        C2025p c2025p = (C2025p) this.f7519Q.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (c2025p != null && !this.f7519Q.getAdapter().isEmpty()) {
            String strM8065d = c2025p.m8065d();
            String strM8062a = c2025p.m8062a();
            String strM8066e = c2025p.m8066e();
            if (strM8065d != null && strM8062a != null) {
                if (this.f7505C.equals(this.f7504B)) {
                    if (this.f7504B.equals(strM8062a)) {
                        contextMenuC0453a.setHeaderTitle(R.string.setting_interaction_me);
                    } else {
                        contextMenuC0453a.setHeaderTitle(c2025p.m8063b());
                    }
                    contextMenuC0453a.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1968ah(this, strM8062a, strM8065d, strM8066e));
                    return;
                }
                if (this.f7504B.equals(c2025p.m8062a())) {
                    contextMenuC0453a.setHeaderTitle(R.string.setting_interaction_me);
                    contextMenuC0453a.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1971ak(this, strM8065d, strM8066e));
                }
            }
        }
    }
}
