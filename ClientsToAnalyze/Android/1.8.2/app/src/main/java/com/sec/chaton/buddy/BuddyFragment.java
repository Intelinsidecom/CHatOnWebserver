package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.honeycomb.BuddySelectFragment;
import com.sec.chaton.buddy.honeycomb.InterfaceC0432o;
import com.sec.chaton.buddy.p010a.C0255a;
import com.sec.chaton.buddy.p010a.C0256b;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.InterfaceC0454a;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.coolots.C0529i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.p015d.p016a.C0577br;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.C0692g;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0680g;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1722ae;
import com.sec.chaton.util.C1725ah;
import com.sec.chaton.util.C1734aq;
import com.sec.chaton.util.C1741ax;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import com.sec.widget.ChoicePanel;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.FastScrollableExpandableListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import twitter4j.MediaEntity;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class BuddyFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, InterfaceC0221al, InterfaceC0432o, InterfaceC0454a {

    /* renamed from: a */
    public static final String f908a = BuddyFragment.class.getSimpleName();

    /* renamed from: aZ */
    private static int f909aZ = 1;

    /* renamed from: ba */
    private static int f910ba = 2;

    /* renamed from: bb */
    private static int f911bb = 3;

    /* renamed from: bc */
    private static HashMap f912bc = new HashMap();

    /* renamed from: A */
    private Button f913A;

    /* renamed from: B */
    private Button f914B;

    /* renamed from: C */
    private TextView f915C;

    /* renamed from: D */
    private LinearLayout f916D;

    /* renamed from: E */
    private ImageButton f917E;

    /* renamed from: F */
    private EditText f918F;

    /* renamed from: G */
    private C1798b f919G;

    /* renamed from: H */
    private TextView f920H;

    /* renamed from: I */
    private boolean f921I;

    /* renamed from: J */
    private boolean f922J;

    /* renamed from: K */
    private boolean f923K;

    /* renamed from: L */
    private EditTextWithClearButton f924L;

    /* renamed from: M */
    private EditText f925M;

    /* renamed from: N */
    private Button f926N;

    /* renamed from: O */
    private RelativeLayout f927O;

    /* renamed from: P */
    private RelativeLayout f928P;

    /* renamed from: Q */
    private ImageButton f929Q;

    /* renamed from: R */
    private ImageButton f930R;

    /* renamed from: S */
    private TextView f931S;

    /* renamed from: T */
    private RelativeLayout f932T;

    /* renamed from: U */
    private Button f933U;

    /* renamed from: V */
    private String f934V;

    /* renamed from: W */
    private String f935W;

    /* renamed from: X */
    private String f936X;

    /* renamed from: Y */
    private int f937Y;

    /* renamed from: Z */
    private String[] f938Z;

    /* renamed from: aA */
    private AlertDialog f939aA;

    /* renamed from: aB */
    private boolean f940aB;

    /* renamed from: aC */
    private boolean f941aC;

    /* renamed from: aD */
    private boolean f942aD;

    /* renamed from: aE */
    private boolean f943aE;

    /* renamed from: aF */
    private int f944aF;

    /* renamed from: aG */
    private String f945aG;

    /* renamed from: aH */
    private String f946aH;

    /* renamed from: aI */
    private ArrayList f947aI;

    /* renamed from: aJ */
    private ArrayList f948aJ;

    /* renamed from: aK */
    private ArrayList f949aK;

    /* renamed from: aL */
    private ArrayList f950aL;

    /* renamed from: aM */
    private HashSet f951aM;

    /* renamed from: aN */
    private Toast f952aN;

    /* renamed from: aO */
    private Menu f953aO;

    /* renamed from: aP */
    private String f954aP;

    /* renamed from: aQ */
    private EnumC0448x f955aQ;

    /* renamed from: aR */
    private String f956aR;

    /* renamed from: aS */
    private int f957aS;

    /* renamed from: aT */
    private TextView f958aT;

    /* renamed from: aU */
    private C1798b f959aU;

    /* renamed from: aV */
    private boolean f960aV;

    /* renamed from: aW */
    private boolean f961aW;

    /* renamed from: aX */
    private InterfaceC0302bn f962aX;

    /* renamed from: aY */
    private int f963aY;

    /* renamed from: aa */
    private String f964aa;

    /* renamed from: ab */
    private LinearLayout f965ab;

    /* renamed from: ac */
    private Bundle f966ac;

    /* renamed from: ad */
    private int f967ad;

    /* renamed from: ae */
    private int f968ae;

    /* renamed from: af */
    private int f969af;

    /* renamed from: ag */
    private String[] f970ag;

    /* renamed from: ah */
    private String[] f971ah;

    /* renamed from: ai */
    private ArrayList f972ai;

    /* renamed from: aj */
    private ArrayList f973aj;

    /* renamed from: ak */
    private final ArrayList f974ak;

    /* renamed from: al */
    private final ArrayList f975al;

    /* renamed from: am */
    private final ArrayList f976am;

    /* renamed from: an */
    private final ArrayList f977an;

    /* renamed from: ao */
    private C0257c f978ao;

    /* renamed from: ap */
    private ImageView f979ap;

    /* renamed from: aq */
    private C0442r f980aq;

    /* renamed from: ar */
    private C0300bl f981ar;

    /* renamed from: as */
    private C0301bm f982as;

    /* renamed from: at */
    private ChoicePanel f983at;

    /* renamed from: au */
    private LinearLayout f984au;

    /* renamed from: av */
    private TextView f985av;

    /* renamed from: aw */
    private String f986aw;

    /* renamed from: ax */
    private MenuItem f987ax;

    /* renamed from: ay */
    private boolean f988ay;

    /* renamed from: az */
    private ProgressDialog f989az;

    /* renamed from: b */
    boolean f990b;

    /* renamed from: bd */
    private boolean f991bd;

    /* renamed from: be */
    private TextWatcher f992be;

    /* renamed from: bf */
    private TextWatcher f993bf;

    /* renamed from: bg */
    private int f994bg;

    /* renamed from: bh */
    private int f995bh;

    /* renamed from: bi */
    private int f996bi;

    /* renamed from: bj */
    private InterfaceC0298bj f997bj;

    /* renamed from: bk */
    private View.OnClickListener f998bk;

    /* renamed from: bl */
    private C1741ax f999bl;

    /* renamed from: bm */
    private InterfaceC1745ba f1000bm;

    /* renamed from: c */
    View.OnClickListener f1001c;

    /* renamed from: d */
    AdapterView.OnItemSelectedListener f1002d;

    /* renamed from: e */
    MenuItem.OnMenuItemClickListener f1003e;

    /* renamed from: f */
    Handler f1004f;

    /* renamed from: g */
    InterfaceC0677d f1005g;

    /* renamed from: h */
    InterfaceC0677d f1006h;

    /* renamed from: i */
    InterfaceC0677d f1007i;

    /* renamed from: j */
    ContentObserver f1008j;

    /* renamed from: k */
    AdapterView.OnItemSelectedListener f1009k;

    /* renamed from: l */
    private Toast f1010l;

    /* renamed from: m */
    private String f1011m;

    /* renamed from: n */
    private int f1012n;

    /* renamed from: o */
    private int f1013o;

    /* renamed from: p */
    private int f1014p;

    /* renamed from: q */
    private int f1015q;

    /* renamed from: r */
    private int f1016r;

    /* renamed from: s */
    private int f1017s;

    /* renamed from: t */
    private Context f1018t;

    /* renamed from: u */
    private LinearLayout f1019u;

    /* renamed from: v */
    private LinearLayout f1020v;

    /* renamed from: w */
    private FastScrollableExpandableListView f1021w;

    /* renamed from: x */
    private LinearLayout f1022x;

    /* renamed from: y */
    private LinearLayout f1023y;

    /* renamed from: z */
    private EditTextWithClearButton f1024z;

    /* renamed from: a */
    public void m2037a(boolean z) {
        this.f960aV = z;
    }

    /* renamed from: b */
    public void m2042b(boolean z) {
        this.f961aW = z;
    }

    public BuddyFragment() {
        this.f1011m = "";
        this.f1012n = 0;
        this.f1013o = -1;
        this.f1014p = -1;
        this.f1015q = 0;
        this.f1016r = 0;
        this.f1017s = 0;
        this.f921I = false;
        this.f922J = false;
        this.f923K = false;
        this.f967ad = 11;
        this.f968ae = 0;
        this.f969af = 1;
        this.f970ag = null;
        this.f971ah = null;
        this.f972ai = new ArrayList();
        this.f973aj = new ArrayList();
        this.f974ak = new ArrayList();
        this.f975al = new ArrayList();
        this.f976am = new ArrayList();
        this.f977an = new ArrayList();
        this.f981ar = null;
        this.f982as = null;
        this.f988ay = false;
        this.f989az = null;
        this.f939aA = null;
        this.f940aB = true;
        this.f941aC = false;
        this.f942aD = false;
        this.f943aE = false;
        this.f947aI = new ArrayList();
        this.f948aJ = new ArrayList();
        this.f949aK = new ArrayList();
        this.f950aL = null;
        this.f953aO = null;
        this.f954aP = null;
        this.f960aV = false;
        this.f990b = true;
        this.f961aW = false;
        this.f962aX = null;
        this.f991bd = false;
        this.f992be = new C0264af(this);
        this.f993bf = new C0265ag(this);
        this.f1001c = new ViewOnClickListenerC0267ai(this);
        this.f1002d = new C0268aj(this);
        this.f1003e = new MenuItemOnMenuItemClickListenerC0270al(this);
        this.f1004f = new HandlerC0271am(this);
        this.f1005g = new C0273ao(this);
        this.f1006h = new C0274ap(this);
        this.f1007i = new C0277as(this);
        this.f1008j = new C0278at(this, new Handler());
        this.f996bi = 0;
        this.f997bj = new C0281aw(this);
        this.f998bk = new ViewOnClickListenerC0284az(this);
        this.f1009k = new C0289ba(this);
        this.f1000bm = new C0290bb(this);
    }

    public BuddyFragment(InterfaceC0302bn interfaceC0302bn) {
        this.f1011m = "";
        this.f1012n = 0;
        this.f1013o = -1;
        this.f1014p = -1;
        this.f1015q = 0;
        this.f1016r = 0;
        this.f1017s = 0;
        this.f921I = false;
        this.f922J = false;
        this.f923K = false;
        this.f967ad = 11;
        this.f968ae = 0;
        this.f969af = 1;
        this.f970ag = null;
        this.f971ah = null;
        this.f972ai = new ArrayList();
        this.f973aj = new ArrayList();
        this.f974ak = new ArrayList();
        this.f975al = new ArrayList();
        this.f976am = new ArrayList();
        this.f977an = new ArrayList();
        this.f981ar = null;
        this.f982as = null;
        this.f988ay = false;
        this.f989az = null;
        this.f939aA = null;
        this.f940aB = true;
        this.f941aC = false;
        this.f942aD = false;
        this.f943aE = false;
        this.f947aI = new ArrayList();
        this.f948aJ = new ArrayList();
        this.f949aK = new ArrayList();
        this.f950aL = null;
        this.f953aO = null;
        this.f954aP = null;
        this.f960aV = false;
        this.f990b = true;
        this.f961aW = false;
        this.f962aX = null;
        this.f991bd = false;
        this.f992be = new C0264af(this);
        this.f993bf = new C0265ag(this);
        this.f1001c = new ViewOnClickListenerC0267ai(this);
        this.f1002d = new C0268aj(this);
        this.f1003e = new MenuItemOnMenuItemClickListenerC0270al(this);
        this.f1004f = new HandlerC0271am(this);
        this.f1005g = new C0273ao(this);
        this.f1006h = new C0274ap(this);
        this.f1007i = new C0277as(this);
        this.f1008j = new C0278at(this, new Handler());
        this.f996bi = 0;
        this.f997bj = new C0281aw(this);
        this.f998bk = new ViewOnClickListenerC0284az(this);
        this.f1009k = new C0289ba(this);
        this.f1000bm = new C0290bb(this);
        this.f962aX = interfaceC0302bn;
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
        BaseActivity.m1827a(this, true);
        this.f940aB = true;
        C1786r.m6067f("onTabSelected() : " + this.f940aB, f908a);
        if (this.f941aC && this.f980aq != null) {
            this.f981ar.m2370a();
        }
        if (GlobalApplication.m3265f()) {
            m2021u();
        }
        m2057n();
        this.f941aC = false;
        if (this.f999bl != null) {
            this.f999bl.m5929a();
        }
    }

    /* renamed from: u */
    private void m2021u() {
        if (this.f954aP != null && this.f1017s == 0 && this.f969af == 1) {
            C1786r.m6067f("onTabSelected() :  state to be restored ", f908a);
            C1786r.m6067f("onTabSelected() :  buddy " + this.f954aP + " state to be restored ", f908a);
            if (this.f980aq != null) {
                this.f980aq.m2462b((String) null);
                this.f980aq.m2455a(this.f954aP, this.f955aQ);
            }
            if (this.f954aP.startsWith("0999")) {
                this.f981ar.m2376b(this.f954aP);
                return;
            } else {
                this.f981ar.m2373a(this.f954aP);
                return;
            }
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyBuddyFragment(), "container").commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        C1786r.m6067f("onAttach()", f908a);
        super.onAttach(activity);
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
        BaseActivity.m1827a(this, false);
        if (this.f980aq != null) {
            this.f980aq.m2455a((String) null, EnumC0448x.NONE);
        }
        m1922M();
        m1925N();
        m1917J();
        if (GlobalApplication.m3265f() && this.f980aq != null) {
            this.f980aq.m2462b((String) null);
        }
        this.f940aB = false;
        C1786r.m6067f("onTabUnSelected() : " + this.f940aB, f908a);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String[] strArr = new String[m1929P().size()];
        Iterator it = m1929P().iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = (String) it.next();
            i++;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putStringArray("array", strArr);
        bundle.putBundle("Blind_check_save", bundle2);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C1786r.m6067f("onCreate()", f908a);
        super.onCreate(bundle);
        this.f1018t = getActivity();
        this.f981ar = new C0300bl(this);
        this.f982as = new C0301bm(this);
        this.f952aN = C2153y.m7536a(this.f1018t, (CharSequence) null, 0);
        this.f1018t.getContentResolver().registerContentObserver(C0688c.f2606a, true, this.f1008j);
        this.f1018t.getContentResolver().registerContentObserver(C0692g.f2614a, true, this.f1008j);
        this.f1018t.getContentResolver().registerContentObserver(C0691f.f2613a, true, this.f1008j);
        this.f1018t.getContentResolver().registerContentObserver(C0702q.f2645a, true, this.f1008j);
        this.f1018t.getContentResolver().registerContentObserver(C0704s.f2647a, true, this.f1008j);
        if (bundle != null) {
            this.f948aJ.clear();
            for (String str : bundle.getBundle("Blind_check_save").getStringArray("array")) {
                this.f948aJ.add(str);
            }
        } else {
            this.f948aJ = null;
        }
        m1931Q();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6067f("onCreateView()", f908a);
        return layoutInflater.inflate(R.layout.buddy_layout2, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C1786r.m6067f("onActivityCreated()", f908a);
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f944aF = arguments.getInt("content_type");
                C1786r.m6064d("Buddy content_type:" + this.f944aF);
                this.f943aE = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f945aG = arguments.getString("download_uri");
                C1786r.m6064d("Buddy download_uri:" + this.f945aG);
            }
            if (arguments.containsKey("sub_content")) {
                this.f946aH = arguments.getString("sub_content");
                C1786r.m6064d("Buddy sub_content:" + this.f946aH);
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f1011m = arguments.getString("forward_sender_name");
                C1786r.m6064d("Buddy mForwardSenderName:" + this.f1011m);
            }
        }
        m1913H();
        m2023v();
        if (this.f969af == 9) {
            this.f947aI.clear();
            this.f947aI = getArguments().getStringArrayList("ACTIVITY_PURPOSE_ARG");
        }
        if (this.f940aB) {
            this.f981ar.m2370a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        C1786r.m6067f("onStart() : " + this.f940aB, f908a);
        super.onStart();
        if (GlobalApplication.m3265f()) {
            if (this.f969af == 10 || this.f969af == 11) {
                BaseActivity.m1829b(this, true);
                this.f918F = (EditText) getActivity().findViewById(R.id.buddy_select_group_name_edit);
                if (this.f918F != null) {
                    this.f918F.addTextChangedListener(this.f993bf);
                    if (this.f969af == 10) {
                    }
                    return;
                }
                return;
            }
            if (this.f969af == 2 || this.f969af == 3 || this.f969af == 13 || this.f969af == 6 || this.f969af == 14 || this.f969af == 15 || this.f969af == 18 || this.f969af == 17 || this.f969af == 19) {
                BaseActivity.m1829b(this, true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ((this.f1017s != 1 && this.f1017s != 2) || !this.f991bd || this.f941aC) {
            this.f991bd = true;
            boolean z = C1789u.m6075a().getBoolean("recomned_receive", true);
            this.f940aB = true;
            C1786r.m6067f("onResume() : " + this.f940aB, f908a);
            C1786r.m6067f("isChanged : " + this.f941aC, f908a);
            this.f981ar.m2370a();
            this.f981ar.m2374b();
            this.f1024z.addTextChangedListener(this.f992be);
            if (!this.f941aC) {
                this.f941aC = false;
            }
            if (this.f969af == 1) {
                this.f981ar.m2377c();
            }
            if (this.f958aT != null) {
                if (z) {
                    Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0702q.f2645a, null, "type='200'", null, null);
                    int count = cursorQuery.getCount();
                    cursorQuery.close();
                    m2040b(count);
                    this.f917E.setEnabled(true);
                    return;
                }
                if (!z) {
                    m2040b(0);
                    if (m2047e() < 1) {
                        this.f917E.setEnabled(false);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f940aB = false;
        if (!this.f988ay || this.f976am.size() == 0) {
        }
        this.f1024z.removeTextChangedListener(this.f992be);
        m1911G();
        C1786r.m6067f("onPause() : " + this.f940aB, f908a);
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        C1786r.m6067f("onStop()", f908a);
        try {
            this.f1024z.removeTextChangedListener(this.f992be);
        } catch (Exception e) {
        }
        m1922M();
        m1925N();
        if (GlobalApplication.m3265f()) {
            if ((this.f969af == 10 || this.f969af == 11) && this.f918F != null) {
                this.f918F.removeTextChangedListener(this.f993bf);
            }
            if (this.f989az != null && this.f989az.isShowing()) {
                this.f989az.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f980aq != null) {
            this.f980aq.m2465e();
        }
        this.f1018t.getContentResolver().unregisterContentObserver(this.f1008j);
        super.onDestroy();
    }

    /* renamed from: v */
    private void m2023v() {
        C1786r.m6067f("initView()", f908a);
        this.f1019u = (LinearLayout) getView().findViewById(R.id.buddy_list_layout);
        this.f1020v = (LinearLayout) getView().findViewById(R.id.tell_friends_layout);
        this.f916D = (LinearLayout) getView().findViewById(R.id.buddy_list_noresult_layout);
        this.f920H = (TextView) getView().findViewById(R.id.title_menu);
        this.f924L = (EditTextWithClearButton) getView().findViewById(R.id.edit_title);
        this.f924L.setShowClear(false);
        this.f925M = (EditText) getView().findViewById(R.id.tmp_title);
        this.f926N = (Button) getView().findViewById(R.id.buddy_menu_save);
        this.f927O = (RelativeLayout) getView().findViewById(R.id.chat_title_bar);
        this.f965ab = (LinearLayout) getView().findViewById(R.id.searcdh_bar);
        this.f984au = (LinearLayout) getView().findViewById(R.id.select_all_bar);
        this.f985av = (TextView) getView().findViewById(R.id.selected_buddy_count);
        if (GlobalApplication.m3265f()) {
            this.f928P = (RelativeLayout) getView().findViewById(R.id.honeycomb_bar);
            this.f929Q = (ImageButton) getView().findViewById(R.id.chatprofile_menu_back);
            this.f930R = (ImageButton) getView().findViewById(R.id.chatprofile_menu_invite);
            this.f931S = (TextView) getView().findViewById(R.id.honeycomb_title);
            this.f932T = (RelativeLayout) getView().findViewById(R.id.buddy_layout_main);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1797a(getResources().getString(R.string.buddy_list_optionmenu_sortby), R.drawable.list_by));
            arrayList.add(new C1797a(getResources().getString(R.string.buddy_list_optionmenu_addgroup), R.drawable.add_group));
            arrayList.add(new C1797a(getResources().getString(R.string.buddy_list_tell_friends_button), R.drawable.add_buddies_tell_friends));
            if (AbstractC0521a.m2697a(getActivity())) {
                if (C0577br.m2769h() && C0577br.m2770i()) {
                    arrayList.add(new C1797a(getResources().getString(R.string.menu_voice_call), R.drawable.chaton_voice));
                    arrayList.add(new C1797a(getResources().getString(R.string.menu_video_call), R.drawable.chaton_video));
                } else if (!C0577br.m2769h() && C0577br.m2770i()) {
                    arrayList.add(new C1797a(getResources().getString(R.string.menu_video_call), R.drawable.chaton_video));
                } else if (C0577br.m2769h() && !C0577br.m2770i()) {
                    arrayList.add(new C1797a(getResources().getString(R.string.menu_voice_call), R.drawable.chaton_voice));
                }
            }
            this.f919G = new C1798b(this.f1018t, arrayList);
        }
        this.f1021w = (FastScrollableExpandableListView) getView().findViewById(R.id.buddy_list);
        this.f1021w.setOnGroupClickListener(this);
        this.f1021w.setOnGroupCollapseListener(this);
        this.f1021w.setOnGroupExpandListener(this);
        this.f1021w.setOnChildClickListener(this);
        this.f1024z = (EditTextWithClearButton) getView().findViewById(R.id.buddy_search);
        this.f1024z.setShowSearch(true);
        this.f1024z.setMaxLengthString(R.string.toast_text_max_Length);
        this.f1022x = (LinearLayout) getView().findViewById(R.id.buddy_menu_bar);
        this.f1023y = (LinearLayout) getView().findViewById(R.id.lLayoutProfile);
        this.f915C = (TextView) getView().findViewById(R.id.textNames);
        this.f913A = (Button) getView().findViewById(R.id.add_buddies_button);
        this.f914B = (Button) getView().findViewById(R.id.buddy_menu_invite);
        this.f983at = (ChoicePanel) getView().findViewById(R.id.buddy_choice_select_member_panel);
        this.f983at.setButtonClickListener(this.f998bk);
        this.f917E = (ImageButton) getView().findViewById(R.id.buddylist_add_buddy_button);
        this.f917E.setOnClickListener(new ViewOnClickListenerC0263ae(this));
        this.f967ad = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getInt("BUDDY_SORT_STYLE", 11);
        if (this.f967ad == 13) {
            this.f967ad = 11;
        }
        this.f966ac = getArguments();
        if (this.f966ac == null) {
            this.f969af = 1;
            this.f968ae = this.f967ad;
        } else {
            this.f969af = this.f966ac.getInt("ACTIVITY_PURPOSE", 1);
        }
        if (this.f969af == 16) {
            this.f969af = 1;
        }
        if (this.f969af == 1) {
            this.f917E.setVisibility(0);
            this.f958aT = (TextView) getView().findViewById(R.id.buddy_suggestion_badge);
            getView().findViewById(R.id.layout_suggestion).setVisibility(0);
        } else {
            this.f917E.setVisibility(8);
            if (this.f958aT != null) {
                this.f958aT.setVisibility(8);
            }
            getView().findViewById(R.id.layout_suggestion).setVisibility(8);
        }
        if (this.f969af == 13) {
            this.f956aR = "voip";
        } else if (this.f969af == 17) {
            this.f956aR = "call";
        } else if (this.f969af == 18) {
            this.f956aR = "vcall";
        }
        if (this.f969af == 2 || this.f969af == 3 || this.f969af == 12 || this.f969af == 13 || this.f969af == 14 || this.f969af == 15 || this.f969af == 10 || this.f969af == 11 || this.f969af == 5 || this.f969af == 8 || this.f969af == 19) {
            this.f1017s = 2;
        } else if (this.f969af == 17 || this.f969af == 18) {
            this.f1016r = C1789u.m6075a().getInt(this.f969af == 17 ? "group_voice_call_max_count" : "group_video_call_max_count", 4);
            C1786r.m6067f("BuddyFragment mMaxCount: " + this.f1016r, f908a);
            if (this.f953aO != null) {
                m2051h().findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            }
            if (this.f1016r == 1) {
                this.f1017s = 0;
            } else {
                this.f1017s = 2;
            }
            this.f1013o = 1;
            this.f1012n = 0;
            if (this.f969af == 17) {
                this.f1014p = C1789u.m6075a().getInt("group_voice_call_max_count", 4) - 1;
                this.f1015q = R.string.buddy_list_select_maximum_failed;
            } else if (this.f969af == 18) {
                this.f1014p = C1789u.m6075a().getInt("group_video_call_max_count", 4) - 1;
                this.f1015q = R.string.buddy_list_select_maximum_failed;
            }
        } else if (this.f969af == 9) {
            this.f1017s = 1;
        } else if (this.f969af == 1 || this.f969af == 6) {
            this.f1017s = 0;
        }
        if (this.f1017s != 0) {
            this.f1021w.setChoiceMode(2);
            this.f1021w.setItemsCanFocus(false);
        }
        if (this.f969af == 1) {
            this.f1022x.setVisibility(8);
            registerForContextMenu(this.f1021w);
        } else if (this.f969af == 6) {
            BaseActivity.m1827a(this, true);
            this.f967ad = 11;
            this.f1022x.setVisibility(8);
            this.f1024z.setVisibility(8);
            this.f925M.setVisibility(0);
            this.f1023y.setVisibility(8);
            this.f924L.setVisibility(0);
            this.f926N.setVisibility(8);
            this.f927O.setVisibility(0);
            this.f924L.setSingleLine();
            this.f964aa = this.f966ac.getString(ChatFragment.f1750f);
            this.f934V = this.f966ac.getString("inboxNO");
            this.f935W = this.f966ac.getString("buddyNO");
            this.f937Y = this.f966ac.getInt("chatType");
            this.f921I = this.f966ac.getBoolean(ChatFragment.f1753i);
            this.f938Z = this.f966ac.getStringArray(ChatFragment.f1749e);
            this.f923K = this.f966ac.getBoolean(ChatFragment.f1755k);
            this.f963aY = this.f966ac.getInt("ACTIVITY_TYPE", -1);
            if (GlobalApplication.m3265f()) {
                this.f928P.setVisibility(8);
                this.f927O.setVisibility(8);
                this.f965ab.setVisibility(8);
                if (this.f969af != 6 || !this.f966ac.getString("group profile", "profile").equals("GROUP PROFILE")) {
                    if (EnumC0695j.m3145a(this.f937Y) == EnumC0695j.GROUPCHAT) {
                        this.f931S.setText(getString(R.string.buddy_chat_profile, Integer.valueOf(this.f938Z.length + 1)));
                    } else {
                        this.f931S.setText(getString(R.string.buddy_chat_profile, Integer.valueOf(this.f938Z.length)));
                    }
                }
                this.f929Q.setOnClickListener(new ViewOnClickListenerC0276ar(this));
                this.f930R.setOnClickListener(new ViewOnClickListenerC0291bc(this));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f965ab.getLayoutParams());
            if (GlobalApplication.m3265f()) {
                this.f965ab.setBackgroundColor(getResources().getColor(R.color.white));
                this.f932T.setBackgroundColor(getResources().getColor(R.color.white));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f1019u.getLayoutParams());
                layoutParams2.addRule(3, R.id.searcdh_bar);
                this.f1021w.setBackgroundResource(R.drawable.list_bg_bottom);
                this.f1019u.setBackgroundDrawable(getResources().getDrawable(R.drawable.chaton_attach_bg));
                this.f1019u.setLayoutParams(layoutParams2);
                layoutParams.height = (int) C1722ae.m5894a(58.0f);
            } else {
                this.f965ab.setBackgroundColor(R.color.transparent);
                layoutParams.height = (int) C1722ae.m5894a(54.0f);
            }
            layoutParams.addRule(3, R.id.buddy_choice_panel);
            this.f965ab.setLayoutParams(layoutParams);
            this.f924L.setOnClickListener(new ViewOnClickListenerC0292bd(this));
            this.f926N.setOnClickListener(new ViewOnClickListenerC0293be(this));
            this.f924L.setText(this.f964aa);
            this.f924L.addTextChangedListener(new C0294bf(this));
            C1786r.m6064d("mChattitle:" + this.f964aa);
            this.f924L.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0295bg(this));
        } else {
            this.f1022x.findViewById(R.id.buddy_menu_group_chat).setVisibility(8);
            this.f1022x.findViewById(R.id.buddy_menu_broadcast).setVisibility(8);
            this.f1022x.findViewById(R.id.buddy_menu_invite).setVisibility(8);
            this.f1022x.findViewById(R.id.buddy_menu_add_group).setVisibility(8);
            this.f1022x.findViewById(R.id.buddy_menu_blind_memo).setVisibility(8);
            this.f1022x.setVisibility(0);
            if (this.f969af == 2) {
                this.f1022x.findViewById(R.id.buddy_menu_group_chat).setVisibility(0);
            } else if (this.f969af == 3) {
                this.f1022x.findViewById(R.id.buddy_menu_broadcast).setVisibility(0);
            } else if (this.f969af == 12) {
                this.f1022x.findViewById(R.id.buddy_menu_group_chat).setVisibility(0);
                this.f1022x.findViewById(R.id.buddy_menu_broadcast).setVisibility(0);
                ((TextView) this.f1022x.findViewById(R.id.buddy_menu_group_chat)).setText(R.string.menu_button_start_chat);
                ((TextView) this.f1022x.findViewById(R.id.buddy_menu_broadcast)).setText(R.string.buddy_list_menubar_broadcast);
                this.f1022x.findViewById(R.id.buddy_menu_cancel).setVisibility(8);
            } else if (this.f969af == 13) {
                this.f1022x.findViewById(R.id.buddy_menu_voice_call).setVisibility(0);
                this.f1022x.findViewById(R.id.buddy_menu_video_call).setVisibility(0);
                ((TextView) this.f1022x.findViewById(R.id.buddy_menu_voice_call)).setText(R.string.menu_voice_call);
                ((TextView) this.f1022x.findViewById(R.id.buddy_menu_video_call)).setText(R.string.menu_video_call);
                this.f1022x.findViewById(R.id.buddy_menu_voice_call).setOnClickListener(this.f1001c);
                this.f1022x.findViewById(R.id.buddy_menu_video_call).setOnClickListener(this.f1001c);
                this.f1022x.findViewById(R.id.buddy_menu_cancel).setVisibility(8);
                this.f967ad = 11;
            } else if (this.f969af == 14) {
                this.f938Z = this.f966ac.getStringArray(ChatFragment.f1749e);
                this.f1022x.findViewById(R.id.buddy_menu_voice_call).setVisibility(0);
                ((TextView) this.f1022x.findViewById(R.id.buddy_menu_voice_call)).setText(R.string.menu_voice_call);
                this.f1022x.findViewById(R.id.buddy_menu_voice_call).setOnClickListener(this.f1001c);
                this.f1022x.findViewById(R.id.buddy_menu_cancel).setVisibility(8);
                this.f967ad = 11;
            } else if (this.f969af == 15) {
                this.f938Z = this.f966ac.getStringArray(ChatFragment.f1749e);
                this.f1022x.findViewById(R.id.buddy_menu_video_call).setVisibility(0);
                ((TextView) this.f1022x.findViewById(R.id.buddy_menu_video_call)).setText(R.string.menu_video_call);
                this.f1022x.findViewById(R.id.buddy_menu_video_call).setOnClickListener(this.f1001c);
                this.f1022x.findViewById(R.id.buddy_menu_cancel).setVisibility(8);
                this.f967ad = 11;
            } else if (this.f969af == 5) {
                this.f938Z = this.f966ac.getStringArray(ChatFragment.f1749e);
                if (this.f966ac.getInt("chatType") == EnumC0695j.ONETOONE.m3146a()) {
                    this.f914B.setText(R.string.invite_create_groupchat);
                    this.f914B.setTextSize(0, getActivity().getResources().getDimension(R.dimen.text_size_invite_create_groupchat));
                }
                this.f914B.setVisibility(0);
                this.f967ad = 11;
                if (GlobalApplication.m3265f()) {
                    BaseActivity.m1829b(this, true);
                }
            } else if (this.f969af == 8) {
                this.f967ad = 11;
                this.f1022x.setVisibility(8);
            } else if (this.f969af == 9) {
                this.f1022x.findViewById(R.id.buddy_menu_blind_memo).setVisibility(0);
                BaseActivity.m1829b(this, true);
            } else if (this.f969af == 10) {
                this.f1022x.findViewById(R.id.buddy_menu_add_group).setVisibility(0);
            } else if (this.f969af == 19) {
                this.f1022x.findViewById(R.id.buddy_menu_block_buddies).setVisibility(0);
                BaseActivity.m1829b(this, true);
            }
        }
        this.f1022x.findViewById(R.id.buddy_menu_group_chat).setOnClickListener(this.f1001c);
        this.f1022x.findViewById(R.id.buddy_menu_broadcast).setOnClickListener(this.f1001c);
        this.f1022x.findViewById(R.id.buddy_menu_invite).setOnClickListener(this.f1001c);
        this.f1022x.findViewById(R.id.buddy_menu_add_group).setOnClickListener(this.f1001c);
        this.f1022x.findViewById(R.id.buddy_menu_cancel).setOnClickListener(this.f1001c);
        this.f1022x.findViewById(R.id.buddy_menu_blind_memo).setOnClickListener(this.f1001c);
        this.f913A.setOnClickListener(new ViewOnClickListenerC0296bh(this));
        if ((this.f969af == 10 || this.f969af == 5 || this.f969af == 2 || this.f969af == 3 || this.f969af == 11 || this.f969af == 17 || this.f969af == 18 || this.f969af == 14) && GlobalApplication.m3265f()) {
            m2024w();
        }
        if (GlobalApplication.m3265f()) {
            this.f1022x.setVisibility(8);
        }
    }

    /* renamed from: w */
    private void m2024w() {
        m2033a(-1);
    }

    /* renamed from: a */
    void m2033a(int i) {
        String string = null;
        if (GlobalApplication.m3265f()) {
            if (this.f969af == 10) {
                string = getString(R.string.buddy_list_optionmenu_addgroup);
            } else if (this.f969af == 2) {
                string = getString(R.string.menu_button_start_chat);
            } else if (this.f969af == 3) {
                string = getString(R.string.buddy_list_optionmenu_broadcast);
            } else if (this.f969af == 5) {
                string = getString(R.string.buddy_select_no_list_select_buddies);
            } else if (this.f969af == 11) {
                string = getString(R.string.buddy_list_contextual_menu_group_profile);
            } else if (this.f969af == 12) {
                string = getString(R.string.menu_chat);
            } else if (this.f969af == 13) {
                string = getString(R.string.menu_call);
            } else if (this.f969af == 14) {
                string = getString(R.string.menu_voice_call);
            } else if (this.f969af == 15) {
                string = getString(R.string.menu_video_call);
            } else if (this.f969af == 7) {
                this.f920H.setVisibility(8);
            } else if (this.f969af == 19) {
                string = getString(R.string.block_list_add_buddies);
            }
            if (string != null) {
                if (i >= 0) {
                    string = string + " (" + i + ")";
                }
                if (this.f969af != 6 || !this.f966ac.getString("group profile", "profile").equals("GROUP PROFILE")) {
                    getActivity().getActionBar().setTitle(string);
                }
            }
            this.f920H.setVisibility(8);
            return;
        }
        if (this.f969af != 1) {
            if (this.f969af == 2) {
                this.f920H.setVisibility(0);
                string = getString(R.string.buddy_list_optionmenu_groupchat);
            } else if (this.f969af == 3) {
                string = getString(R.string.buddy_list_optionmenu_broadcast);
            } else if (this.f969af == 5) {
                string = getString(R.string.chat_view_menu_invite);
            } else if (this.f969af == 6) {
                string = EnumC0695j.m3145a(this.f937Y) == EnumC0695j.GROUPCHAT ? getString(R.string.buddy_chat_profile, Integer.valueOf(this.f938Z.length + 1)) : getString(R.string.buddy_chat_profile, Integer.valueOf(this.f938Z.length));
            } else if (this.f969af != 8) {
                if (this.f969af == 9) {
                    string = getString(R.string.mypage_buddies_say);
                } else if (this.f969af == 10) {
                    string = getString(R.string.buddy_list_optionmenu_addgroup);
                } else if (this.f969af == 19) {
                    string = getString(R.string.block_list_add_buddies);
                }
            }
        }
        if (string != null) {
            if (i >= 0) {
                string = string + " (" + i + ")";
            }
            this.f920H.setVisibility(0);
            this.f920H.setText(string);
            return;
        }
        this.f920H.setVisibility(8);
    }

    /* renamed from: a */
    public void m2036a(String str, boolean z, String str2, CheckBox checkBox) {
        if (!z) {
            if (m2027x()) {
                checkBox.setChecked(true);
                this.f980aq.m2456a(str, checkBox.isChecked());
                if (this.f1017s == 2) {
                    this.f983at.m7439a(str, str2);
                }
            } else {
                m2029y();
            }
        } else {
            checkBox.setChecked(false);
            this.f980aq.m2456a(str, checkBox.isChecked());
            if (this.f1017s == 2) {
                this.f983at.m7438a(str);
            }
        }
        m1921L();
        this.f1021w.invalidateViews();
        if (m1927O().size() >= 1) {
            if (this.f953aO != null) {
                m2051h().findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                return;
            }
            return;
        }
        if (this.f953aO != null) {
            m2051h().findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
            m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        }
    }

    /* renamed from: x */
    private boolean m2027x() {
        if (this.f1014p == -1) {
            return true;
        }
        int size = m1927O().size();
        C1786r.m6061b("canSelectMore check=" + size + ", def=" + this.f1012n + ", min=" + this.f1013o + ", max=" + this.f1014p, f908a);
        return size + this.f1012n < this.f1014p;
    }

    /* renamed from: y */
    private void m2029y() {
        C1786r.m6061b("showSelectionReachedMaximumPopup " + this.f1014p, f908a);
        m1955a((CharSequence) this.f1018t.getString(this.f1015q, Integer.valueOf(this.f1014p)));
    }

    /* renamed from: a */
    private void m1955a(CharSequence charSequence) {
        Toast toastM7536a = 0 == 0 ? C2153y.m7536a(this.f1018t, (CharSequence) null, 0) : null;
        toastM7536a.setText(charSequence);
        toastM7536a.show();
    }

    /* renamed from: c */
    public void m2043c() {
        HashSet hashSetM1927O = m1927O();
        if (hashSetM1927O.size() > 0) {
            if (hashSetM1927O.size() + 1 > 199) {
                Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 198), 0).show();
            }
            Intent intentM585a = HomeActivity.m585a((Context) getActivity(), true);
            if (hashSetM1927O.size() == 1) {
                intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
            } else {
                intentM585a.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
            }
            intentM585a.putExtra("receivers", (String[]) hashSetM1927O.toArray(new String[0]));
            if (this.f943aE) {
                intentM585a.putExtra("content_type", this.f944aF);
                intentM585a.putExtra("download_uri", this.f945aG);
                intentM585a.putExtra("sub_content", this.f946aH);
                intentM585a.putExtra("forward_sender_name", this.f1011m);
            }
            startActivity(intentM585a);
        }
    }

    /* renamed from: d */
    public void m2045d() {
        HashSet hashSetM1927O = m1927O();
        if (hashSetM1927O.size() > 0) {
            if (hashSetM1927O.size() <= 200) {
                Intent intentM585a = HomeActivity.m585a((Context) getActivity(), true);
                intentM585a.putExtra("chatType", EnumC0695j.BROADCAST.m3146a());
                intentM585a.putExtra("receivers", (String[]) hashSetM1927O.toArray(new String[0]));
                if (this.f943aE) {
                    intentM585a.putExtra("content_type", this.f944aF);
                    intentM585a.putExtra("download_uri", this.f945aG);
                    intentM585a.putExtra("sub_content", this.f946aH);
                    intentM585a.putExtra("forward_sender_name", this.f1011m);
                }
                startActivity(intentM585a);
                return;
            }
            Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m2031z() {
        this.f969af = 7;
        this.f1019u.setVisibility(8);
        this.f1020v.setVisibility(0);
        this.f917E.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m1898A() {
        if (this.f969af == 7) {
            this.f969af = 1;
        }
        C1786r.m6067f("viewBuddyList() : " + this.f969af, f908a);
        this.f1019u.setVisibility(0);
        this.f1020v.setVisibility(8);
        this.f917E.setEnabled(true);
        if (this.f969af == 6 && this.f1021w.getFooterViewsCount() == 0) {
            View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.chat_info_footer, (ViewGroup) this.f1021w, false);
            this.f1021w.addFooterView(viewInflate);
            this.f933U = (Button) viewInflate.findViewById(R.id.invite_button);
            if (this.f990b) {
                this.f933U.setVisibility(8);
            } else {
                this.f933U.setVisibility(0);
            }
            this.f933U.setOnClickListener(new ViewOnClickListenerC0297bi(this));
        }
        if (this.f980aq == null) {
            this.f980aq = new C0442r(this.f1021w, getActivity(), this.f974ak, R.layout.buddy_adapter_group_item, this.f975al, R.layout.buddy_adapter_child_item, this.f1017s != 0, this.f967ad, this.f1022x, this.f953aO, this.f969af, this.f920H, this.f966ac, this);
            this.f1021w.setAdapter(this.f980aq);
        }
        m1901B();
        if (this.f1017s == 1 || this.f1017s == 2) {
            if (this.f969af == 10 || this.f969af == 5 || this.f969af == 3 || this.f969af == 2 || this.f969af == 9 || this.f969af == 11 || this.f969af == 8 || this.f969af == 18 || this.f969af == 17 || this.f969af == 19) {
                this.f980aq.m2461b(this.f983at);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m1901B() {
        C1786r.m6067f("refreshList()", f908a);
        this.f1024z.removeTextChangedListener(this.f992be);
        this.f1024z.setText("");
        this.f1024z.addTextChangedListener(this.f992be);
        if (this.f980aq != null) {
            this.f980aq.m2451a(this.f967ad);
            this.f981ar.m2371a(this.f967ad);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m1903C() {
        this.f988ay = false;
        if (this.f967ad == 11) {
            this.f1021w.setFastScrollEnabled(true);
        }
        this.f980aq.m2451a(this.f967ad);
        this.f1021w.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f916D.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        m1975b(this.f972ai, this.f973aj);
        m1915I();
    }

    /* renamed from: a */
    private boolean m1957a(Cursor cursor) {
        C1786r.m6061b("addFavoriteDataSetFromCursor " + cursor, f908a);
        ArrayList arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("group_type");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_name");
        int columnIndex4 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex5 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex6 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex7 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex8 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex9 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex10 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex11 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex12 = cursor.getColumnIndex("relation_send");
        int columnIndex13 = cursor.getColumnIndex("relation_received");
        int columnIndex14 = cursor.getColumnIndex("relation_point");
        int columnIndex15 = cursor.getColumnIndex("relation_icon");
        int columnIndex16 = cursor.getColumnIndex("relation_increase");
        int columnIndex17 = cursor.getColumnIndex("relation_rank");
        int columnIndex18 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex21 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex22 = cursor.getColumnIndex("buddy_extra_info");
        cursor.moveToPosition(-1);
        while (cursor.moveToNext() && cursor.getInt(columnIndex) <= 1) {
            arrayList.add(new C0257c(cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), cursor.getString(columnIndex7), !"Y".equals(cursor.getString(columnIndex8)), cursor.getInt(columnIndex9), cursor.getString(columnIndex10), "Y".equals(cursor.getString(columnIndex11)), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), cursor.getInt(columnIndex18), "Y".equals(cursor.getString(columnIndex19)), "Y".equals(cursor.getString(columnIndex20)), cursor.getInt(columnIndex21), cursor.getString(columnIndex22)));
        }
        if (arrayList.size() > 0) {
            this.f972ai.add(new C0255a(1, getResources().getString(R.string.buddy_list_group_favorites), arrayList.size(), 1, false, false, 0));
            this.f973aj.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: b */
    private boolean m1976b(Cursor cursor) {
        String string;
        String string2;
        String[] strArrSplit;
        C1786r.m6061b("addGroupDataSetFromCursor " + cursor, f908a);
        ArrayList arrayList = new ArrayList();
        if (!GlobalApplication.m3265f() || this.f969af != 11) {
            string = null;
        } else {
            string = getArguments().getString("ACTIVITY_PURPOSE_ARG");
        }
        int columnIndex = cursor.getColumnIndex("group_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_email");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_is_new");
        cursor.moveToPrevious();
        while (cursor.moveToNext() && (string2 = cursor.getString(columnIndex)) != null && string2.length() != 0) {
            C0257c c0257c = new C0257c(cursor.getString(columnIndex2), cursor.getString(columnIndex), null, null, null, null, true, 0, cursor.getString(columnIndex), "Y".equals(cursor.getString(columnIndex5)), 0, 0, 0, 0, 0, 0, 0, false, false);
            HashMap map = new HashMap();
            String str = "%%" + cursor.getString(columnIndex2) + "%%";
            c0257c.m2326b(true);
            String[] strArrSplit2 = null;
            if (cursor.getString(columnIndex3) != null) {
                strArrSplit2 = cursor.getString(columnIndex3).split(str);
            }
            if (cursor.getString(columnIndex4) == null) {
                strArrSplit = null;
            } else {
                strArrSplit = cursor.getString(columnIndex4).split(str);
            }
            if (strArrSplit2 != null && strArrSplit != null) {
                if (strArrSplit2.length > 0 && strArrSplit2.length == strArrSplit.length) {
                    for (int i = 0; i < strArrSplit2.length; i++) {
                        map.put(strArrSplit2[i], strArrSplit[i]);
                    }
                }
                c0257c.m2321a(map);
            }
            if (GlobalApplication.m3265f() && c0257c.m2318a().equals(string)) {
                this.f950aL = new ArrayList();
                if (strArrSplit2 != null && strArrSplit2.length > 0) {
                    for (String str2 : strArrSplit2) {
                        this.f950aL.add(str2);
                    }
                }
            } else {
                arrayList.add(c0257c);
            }
        }
        if (arrayList.size() > 0) {
            this.f972ai.add(new C0255a(1, getResources().getString(R.string.buddy_list_optionmenu_sortby_group), arrayList.size(), 4, false, false, 0));
            this.f973aj.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: c */
    private void m1982c(Cursor cursor) {
        int i;
        ArrayList arrayList;
        C1786r.m6061b("addBuddiesByNameDataSetFromCursor " + cursor, f908a);
        ArrayList arrayList2 = new ArrayList();
        int i2 = 2;
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("relation_send");
        int columnIndex12 = cursor.getColumnIndex("relation_received");
        int columnIndex13 = cursor.getColumnIndex("relation_point");
        int columnIndex14 = cursor.getColumnIndex("relation_icon");
        int columnIndex15 = cursor.getColumnIndex("relation_increase");
        int columnIndex16 = cursor.getColumnIndex("relation_rank");
        int columnIndex17 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex18 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex21 = cursor.getColumnIndex("buddy_extra_info");
        int columnIndex22 = cursor.getColumnIndex("group_name");
        cursor.moveToPrevious();
        ArrayList arrayList3 = arrayList2;
        char c = 0;
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex2);
            String string2 = cursor.getString(columnIndex22);
            if (string != null && string.trim().length() != 0 && (this.f969af != 10 || string2 == null || string2.length() == 0)) {
                char cM5917a = C1734aq.m5917a(Character.toUpperCase(string.charAt(0)));
                if (c == cM5917a || c == 0) {
                    i = i2;
                    arrayList = arrayList3;
                } else {
                    this.f973aj.add(arrayList3);
                    i = i2 + 1;
                    this.f972ai.add(new C0255a(i2, String.valueOf(c), arrayList3.size(), 2, false, false, 0));
                    arrayList = new ArrayList();
                }
                arrayList.add(new C0257c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21)));
                i2 = i;
                c = cM5917a;
                arrayList3 = arrayList;
            }
        }
        if (arrayList3.size() > 0) {
            int i3 = i2 + 1;
            this.f972ai.add(new C0255a(i2, String.valueOf(c), arrayList3.size(), 2, false, false, 0));
            this.f973aj.add(arrayList3);
        }
    }

    /* renamed from: d */
    private void m1986d(Cursor cursor) {
        C1786r.m6061b("addBuddiesByNameDataSetFromCursor " + cursor, f908a);
        new ArrayList();
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("relation_send");
        int columnIndex12 = cursor.getColumnIndex("relation_received");
        int columnIndex13 = cursor.getColumnIndex("relation_point");
        int columnIndex14 = cursor.getColumnIndex("relation_icon");
        int columnIndex15 = cursor.getColumnIndex("relation_increase");
        int columnIndex16 = cursor.getColumnIndex("relation_rank");
        int columnIndex17 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex18 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex21 = cursor.getColumnIndex("buddy_extra_info");
        cursor.moveToPrevious();
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex2);
            if (string != null && string.trim().length() != 0) {
                arrayList.add(new C0257c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21)));
            }
        }
        if (arrayList.size() > 0) {
            this.f972ai.add(new C0255a(2, getResources().getString(R.string.tab_buddies), arrayList.size(), 2, false, false, 0));
            this.f973aj.add(arrayList);
        }
    }

    /* renamed from: e */
    private void m1991e(Cursor cursor) {
        int i;
        C1786r.m6061b("addBuddiesByRelationDataSetFromCursor " + cursor, f908a);
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("relation_send");
        int columnIndex12 = cursor.getColumnIndex("relation_received");
        int columnIndex13 = cursor.getColumnIndex("relation_point");
        int columnIndex14 = cursor.getColumnIndex("relation_icon");
        int columnIndex15 = cursor.getColumnIndex("relation_increase");
        int columnIndex16 = cursor.getColumnIndex("relation_rank");
        int columnIndex17 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex18 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex21 = cursor.getColumnIndex("buddy_extra_info");
        cursor.moveToPrevious();
        int i3 = 0;
        while (cursor.moveToNext()) {
            int i4 = cursor.getInt(columnIndex13);
            arrayList.add(new C0257c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21)));
            i3 = cursor.getInt(columnIndex13) > 0 ? i3 + 1 : i3;
            i2 = i4;
        }
        if (arrayList.size() > 0) {
            if (i3 > 30) {
                i3 = 30;
            }
            if (arrayList.size() < i3) {
                this.f972ai.add(new C0255a(2, getResources().getString(R.string.buddy_profile_rank) + " ", arrayList.size(), 6, false, false, i2));
                this.f973aj.add(arrayList);
                return;
            }
            if (i3 <= 0) {
                i = 2;
            } else {
                ArrayList arrayList2 = new ArrayList(arrayList.subList(0, i3));
                this.f972ai.add(new C0255a(2, getResources().getString(R.string.buddy_profile_rank) + " ", arrayList2.size(), 6, false, false, i2));
                this.f973aj.add(arrayList2);
                i = 3;
            }
            ArrayList arrayList3 = new ArrayList(arrayList.subList(i3, arrayList.size()));
            int i5 = i + 1;
            this.f972ai.add(new C0255a(i, getResources().getString(R.string.tab_buddies) + " ", arrayList3.size(), 6, false, false, i2));
            this.f973aj.add(arrayList3);
        }
    }

    /* renamed from: D */
    private boolean m1905D() {
        int i;
        int i2;
        Cursor cursorQuery = getActivity().getContentResolver().query(C0704s.f2647a, null, null, null, null);
        if (cursorQuery == null) {
            return false;
        }
        C1786r.m6061b("addSpecialBuddyDataSet " + cursorQuery, f908a);
        ArrayList arrayList = new ArrayList();
        int columnIndex = cursorQuery.getColumnIndex("buddy_no");
        int columnIndex2 = cursorQuery.getColumnIndex("buddy_name");
        int columnIndex3 = cursorQuery.getColumnIndex("msgstatus");
        cursorQuery.getColumnIndex("photoloaded");
        int columnIndex4 = cursorQuery.getColumnIndex("isNew");
        cursorQuery.moveToPosition(-1);
        while (cursorQuery.moveToNext()) {
            arrayList.add(new C0257c(cursorQuery.getString(columnIndex), cursorQuery.getString(columnIndex2), cursorQuery.getString(columnIndex3), null, cursorQuery.getString(columnIndex), null, true, 0, cursorQuery.getString(columnIndex2), "Y".equals(cursorQuery.getString(columnIndex4)), 0, 0, 0, 0, 0, 0, 1, false, false));
        }
        if (arrayList.size() > 0) {
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (i3 < this.f972ai.size()) {
                C0255a c0255a = (C0255a) this.f972ai.get(i3);
                if (c0255a.m2309d() == 4) {
                    i = i4;
                    i2 = i3;
                } else if (c0255a.m2309d() == 1) {
                    i = i3;
                    i2 = i5;
                } else {
                    i = i4;
                    i2 = i5;
                }
                i3++;
                i5 = i2;
                i4 = i;
            }
            if (i5 > 0) {
                this.f972ai.add(i5 + 1, new C0255a(1, getResources().getString(R.string.buddy_suggestion_special_buddy), arrayList.size(), 7, false, false, 0));
                this.f973aj.add(arrayList);
            } else if (i4 > 0) {
                this.f972ai.add(i4 + 1, new C0255a(1, getResources().getString(R.string.buddy_suggestion_special_buddy), arrayList.size(), 7, false, false, 0));
                this.f973aj.add(arrayList);
            } else {
                this.f972ai.add(new C0255a(1, getResources().getString(R.string.buddy_suggestion_special_buddy), arrayList.size(), 7, false, false, 0));
                this.f973aj.add(arrayList);
            }
        }
        cursorQuery.close();
        return arrayList.size() > 0;
    }

    /* renamed from: E */
    private boolean m1907E() {
        C1786r.m6061b("addBirthdayDataSet", f908a);
        String str = new SimpleDateFormat("MM-dd").format(new Date());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f972ai.size(); i++) {
            C0255a c0255a = (C0255a) this.f972ai.get(i);
            if (c0255a.m2309d() == 2 || c0255a.m2309d() == 3) {
                Iterator it = ((ArrayList) this.f973aj.get(i)).iterator();
                while (it.hasNext()) {
                    C0257c c0257c = (C0257c) it.next();
                    if ((c0257c.m2333f().length() == 10 && c0257c.m2333f().substring(5).equals(str)) || (c0257c.m2333f().length() == 5 && c0257c.m2333f().equals(str))) {
                        arrayList.add(c0257c);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.f972ai.size(); i2++) {
                if (((C0255a) this.f972ai.get(i2)).m2309d() > 0) {
                    this.f972ai.add(i2, new C0255a(0, getResources().getString(R.string.buddy_list_group_birthday), arrayList.size(), 0, true, false, 0));
                    this.f973aj.add(i2, arrayList);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m1994f(Cursor cursor) {
        this.f972ai.clear();
        this.f973aj.clear();
        if (cursor.getCount() == 0 && this.f969af == 5) {
            if (GlobalApplication.m3265f()) {
                Toast.makeText(this.f1018t, getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
            } else {
                Toast.makeText(this.f1018t, getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
            }
            Intent intent = new Intent();
            intent.putExtra("receivers", new String[0]);
            getActivity().setResult(0, intent);
            getActivity().finish();
            return;
        }
        m1957a(cursor);
        if (this.f969af != 10) {
            m1976b(cursor);
        }
        if (this.f969af == 1) {
            m1905D();
        }
        if (this.f969af == 5) {
            this.f984au.setVisibility(0);
            this.f985av.setText(String.format("%d/%d", Integer.valueOf(m1927O().size()), Integer.valueOf(cursor.getCount() - this.f972ai.size())));
        }
        m1982c(cursor);
        if (C1789u.m6075a().getBoolean("Profile Birth Chk", true) && this.f969af == 1) {
            m1907E();
        }
        m1909F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m1999g(Cursor cursor) {
        this.f972ai.clear();
        this.f973aj.clear();
        m1986d(cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m2001h(Cursor cursor) {
        this.f972ai.clear();
        this.f973aj.clear();
        m1957a(cursor);
        if (this.f969af == 1) {
            m1905D();
        }
        m1991e(cursor);
        if (C1789u.m6075a().getBoolean("Profile Birth Chk", true) && this.f969af == 1) {
            m1907E();
        }
        m1909F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2003i(Cursor cursor) {
        char c;
        ArrayList arrayList;
        int i;
        int i2;
        ArrayList arrayList2;
        this.f976am.clear();
        this.f977an.clear();
        String string = this.f1024z.getText().toString();
        new ArrayList();
        if (cursor.getCount() != 0) {
            if (!cursor.isBeforeFirst()) {
                cursor.moveToPosition(-1);
            }
            int i3 = 2;
            int i4 = 0;
            char c2 = 0;
            ArrayList arrayList3 = new ArrayList();
            while (cursor.moveToNext()) {
                String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                boolean z = false;
                if (C1725ah.m5900a(string2.toUpperCase(), string.toUpperCase())) {
                    if (this.f969af == 5 || this.f969af == 8) {
                        String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                        Iterator it = this.f973aj.iterator();
                        while (true) {
                            boolean z2 = z;
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            Iterator it2 = ((ArrayList) it.next()).iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z = z2;
                                    break;
                                }
                                C0257c c0257c = (C0257c) it2.next();
                                if (!c0257c.m2350v() && string3.equals(c0257c.m2318a())) {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                break;
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (z) {
                        char cM5917a = C1734aq.m5917a(Character.toUpperCase(string2.charAt(0)));
                        if (cursor.getInt(cursor.getColumnIndex("group_relation_group")) != 1) {
                            if (c2 == cM5917a || c2 == 0) {
                                i = i4;
                                i2 = i3;
                                arrayList2 = arrayList3;
                            } else {
                                this.f977an.add(arrayList3);
                                this.f976am.add(new C0255a(i3, String.valueOf(c2), i4, 2, false, false, 0));
                                i = 0;
                                i2 = i3 + 1;
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")), cursor.getString(cursor.getColumnIndex("buddy_extra_info"))));
                            i4 = i + 1;
                            i3 = i2;
                            c = cM5917a;
                            arrayList = arrayList2;
                        }
                    }
                } else {
                    c = c2;
                    arrayList = arrayList3;
                }
                c2 = c;
                arrayList3 = arrayList;
            }
            if (c2 != 0) {
                this.f977an.add(arrayList3);
                int i5 = i3 + 1;
                this.f976am.add(new C0255a(i3, String.valueOf(c2), i4, 2, false, false, 0));
            }
            m1956a(this.f977an);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1975b(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3;
        this.f974ak.clear();
        this.f975al.clear();
        if (this.f969af == 9) {
            new ArrayList();
            if (this.f948aJ != null) {
                arrayList3 = this.f948aJ;
            } else {
                arrayList3 = this.f947aI;
            }
            if (this.f973aj.size() == 0) {
                this.f987ax.setEnabled(false);
                if (m2051h() != null) {
                    m2051h().findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                    m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) it.next()).iterator();
                while (it2.hasNext()) {
                    C0257c c0257c = (C0257c) it2.next();
                    c0257c.m2322a(true);
                    Iterator it3 = arrayList3.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            String str = (String) it3.next();
                            if (c0257c.m2318a().equals(str)) {
                                c0257c.m2322a(false);
                                C1786r.m6066e("SupplyDataToAdapter buddy set to false:" + str, f908a);
                                break;
                            }
                        }
                    }
                }
            }
            if (GlobalApplication.m3265f() && this.f973aj.size() == 0) {
                getActivity().findViewById(R.id.actionbar_menu_done).setEnabled(false);
            }
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            this.f974ak.add(new C0255a((C0255a) it4.next()));
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            ArrayList arrayList4 = (ArrayList) it5.next();
            ArrayList arrayList5 = new ArrayList();
            Iterator it6 = arrayList4.iterator();
            while (it6.hasNext()) {
                arrayList5.add(new C0257c((C0257c) it6.next()));
            }
            this.f975al.add(arrayList5);
        }
        this.f980aq.notifyDataSetChanged();
        if ((this.f969af != 10 && this.f969af != 5 && this.f969af != 2 && this.f969af != 3 && this.f969af != 17 && this.f969af != 18) || !GlobalApplication.m3265f()) {
            this.f980aq.m2457a(m2049f());
        }
    }

    /* renamed from: F */
    private void m1909F() {
        C1786r.m6061b("createNewBuddyGroup", f908a);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2338j() && !c0257c.m2350v() && !arrayList2.contains(c0257c.m2318a())) {
                    arrayList.add(c0257c);
                    arrayList2.add(c0257c.m2318a());
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f972ai.add(0, new C0255a(-1, getResources().getString(R.string.buddy_list_group_new_buddy), arrayList.size(), -1, true, false, 0));
            this.f973aj.add(0, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m2004j(Cursor cursor) throws NumberFormatException {
        C1786r.m6067f("**************** createGroupInfo() : " + cursor.getCount(), f908a);
        int i = 0;
        String str = null;
        ArrayList arrayList = new ArrayList();
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                int i2 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("_id")));
                String string = cursor.getString(cursor.getColumnIndex("group_name"));
                if (cursor.getString(cursor.getColumnIndex("buddy_no")) != null) {
                    arrayList.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y")));
                    str = string;
                    i = i2;
                } else {
                    str = string;
                    i = i2;
                }
            }
            C0256b c0256b = new C0256b(i, str, arrayList.size(), 2);
            Intent intent = new Intent(this.f1018t, (Class<?>) BuddyGroupEditActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 3);
            intent.putExtra("ACTIVITY_PURPOSE_ARG1", c0256b);
            intent.putExtra("ACTION_PURPOSE", 2);
            intent.putExtra("ACTION_PURPOSE_ARG1", c0256b);
            intent.putExtra("ACTION_PURPOSE_ARG2", arrayList);
            this.f980aq.m2462b("" + i);
            ((BaseActivity) getActivity()).mo1830a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m1911G() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.f988ay) {
            for (int i = 0; i < this.f974ak.size(); i++) {
                if (!this.f1021w.isGroupExpanded(i) && ((C0255a) this.f974ak.get(i)).m2309d() != -1) {
                    stringBuffer.append("," + ((C0255a) this.f974ak.get(i)).m2307b());
                }
            }
            if (this.f969af == 1) {
                getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putInt("BUDDY_SORT_STYLE", this.f967ad).commit();
                if (this.f967ad == 12) {
                    if (stringBuffer.toString().length() > 0) {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                        return;
                    } else {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", null).commit();
                        return;
                    }
                }
                if (this.f967ad == 11) {
                    if (stringBuffer.toString().length() > 0) {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                    } else {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", null).commit();
                    }
                }
            }
        }
    }

    /* renamed from: H */
    private void m1913H() {
        String string = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("RELATIONSHIP_FOLDER_STATE", null);
        if (string != null) {
            this.f970ag = string.split(",");
        } else {
            this.f970ag = new String[0];
        }
        String string2 = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("ALPHABET_FOLDER_STATE", null);
        if (string2 != null) {
            this.f971ah = string2.split(",");
        } else {
            this.f971ah = new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m1915I() {
        String[] strArr;
        if (this.f988ay || this.f969af == 6) {
            for (int i = 0; i < this.f974ak.size(); i++) {
                this.f1021w.expandGroup(i);
            }
            return;
        }
        if (this.f969af == 5) {
            for (int i2 = 0; i2 < this.f974ak.size(); i2++) {
                if (((C0255a) this.f974ak.get(i2)).m2309d() < 2) {
                    this.f1021w.collapseGroup(i2);
                } else {
                    this.f1021w.expandGroup(i2);
                }
            }
            return;
        }
        m1913H();
        for (int i3 = 0; i3 < this.f974ak.size(); i3++) {
            this.f1021w.expandGroup(i3);
        }
        if (this.f967ad == 12 && this.f970ag != null) {
            strArr = this.f970ag;
        } else if (this.f967ad != 11 || this.f971ah == null) {
            strArr = null;
        } else {
            strArr = this.f971ah;
        }
        if (strArr != null) {
            for (int i4 = 0; i4 < this.f974ak.size(); i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= strArr.length) {
                        break;
                    }
                    if (!((C0255a) this.f974ak.get(i4)).m2307b().equals(strArr[i5])) {
                        i5++;
                    } else {
                        this.f1021w.collapseGroup(i4);
                        break;
                    }
                }
                if (this.f969af == 1 && this.f968ae != this.f967ad && ((C0255a) this.f974ak.get(i4)).m2309d() < 2) {
                    this.f1021w.collapseGroup(i4);
                }
            }
        }
        if (this.f974ak.size() > 0 && ((C0255a) this.f974ak.get(0)).m2309d() == -1) {
            this.f1021w.expandGroup(0);
        }
        this.f968ae = this.f967ad;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        C1786r.m6067f("onCreateOptionsMenu()", f908a);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C1786r.m6067f("onPrepareOptionsMenu()", f908a);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        if (this.f969af != 6 || getActivity().getClass().equals(GroupProfileActivity.class) || this.f963aY == 101) {
            menu.clear();
            if (GlobalApplication.m3265f()) {
                if (this.f969af == 1) {
                    menu.add(0, 1, 1, getResources().getString(R.string.buddy_list_optionmenu_sortby)).setIcon(R.drawable.list_by);
                    menu.add(0, 2, 2, getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setIcon(R.drawable.add_buddy);
                    menu.add(0, 3, 3, getResources().getString(R.string.buddy_list_optionmenu_addgroup)).setIcon(R.drawable.group_add);
                    if (this.f967ad == 11) {
                        if (menu.findItem(3) == null) {
                            menu.add(0, 3, 3, getResources().getString(R.string.buddy_list_optionmenu_addgroup));
                        }
                    } else {
                        menu.removeItem(3);
                    }
                } else if (this.f969af == 10 || this.f969af == 11 || this.f969af == 2 || this.f969af == 3 || this.f969af == 5) {
                    menuInflater.inflate(R.menu.actionbar_title_done_cancel_next, menu);
                    menu.removeItem(R.id.actionbar_title_next);
                    menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                    menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                } else if (this.f969af == 9) {
                    menuInflater.inflate(R.menu.actionbar_title_done_cancel_next, menu);
                    menu.removeItem(R.id.actionbar_title_next);
                    menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                    menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                } else if (this.f969af == 6 && this.f963aY == 101) {
                    menuInflater.inflate(R.menu.actionbar_title_done_cancel_next, menu);
                    menu.removeItem(123);
                    menu.removeItem(R.id.actionbar_title_next);
                    if (!this.f960aV) {
                        menu.removeItem(R.id.actionbar_title_done);
                        menu.removeItem(R.id.actionbar_title_done_dim);
                        menu.removeItem(123);
                        menu.removeItem(R.id.actionbar_title_cancel);
                    } else if (!this.f961aW) {
                        menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                        menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                        menu.findItem(R.id.actionbar_title_cancel).setEnabled(true);
                    } else {
                        menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                        menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                        menu.findItem(R.id.actionbar_title_cancel).setEnabled(true);
                    }
                } else if (this.f969af == 6 && getActivity().getClass().equals(GroupProfileActivity.class)) {
                    menuInflater.inflate(R.menu.actionbar_title_done_cancel_next, menu);
                    menu.removeItem(123);
                    menu.removeItem(R.id.actionbar_title_next);
                    menu.removeItem(R.id.actionbar_title_done_dim);
                    menu.removeItem(R.id.actionbar_title_cancel);
                    if (!this.f960aV) {
                        menu.removeItem(R.id.actionbar_title_done);
                        menu.add(0, 123, 1, "").setIcon(R.drawable.top_menu_optionmenu).setTitle(R.string.setting_birthday_option).setShowAsAction(2);
                        int i = this.f966ac.getInt(ChatFragment.f1757m, 0);
                        if (i == 1 || i == 2) {
                            menu.removeItem(123);
                        } else {
                            menu.findItem(123).setEnabled(true);
                        }
                    } else {
                        menu.findItem(R.id.actionbar_title_done).setEnabled(true);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new C1797a(getResources().getString(R.string.buddy_list_optionmenu_editgroup), R.drawable.edit_group));
                    arrayList.add(new C1797a(getResources().getString(R.string.buddy_group_list_header_delete), R.drawable.delete));
                    this.f959aU = new C1798b(this.f1018t, arrayList);
                } else if (this.f969af == 19) {
                    menuInflater.inflate(R.menu.actionbar_title_done_cancel_next, menu);
                    menu.removeItem(R.id.actionbar_title_next);
                    menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                    menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                }
            } else if (this.f969af == 1) {
                menu.add(0, 1, 1, getResources().getString(R.string.buddy_list_optionmenu_sortby)).setIcon(R.drawable.list_by);
                menu.add(0, 2, 2, getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setIcon(R.drawable.add_buddy);
                menu.add(0, 4, 4, getResources().getString(R.string.buddy_list_optionmenu_groupchat)).setIcon(R.drawable.group_chat);
                menu.add(0, 5, 5, getResources().getString(R.string.buddy_list_optionmenu_broadcast)).setIcon(R.drawable.broadcast);
                if (C1789u.m6075a().contains("UpdateIsCritical")) {
                    menu.add(0, 6, 6, getResources().getString(R.string.buddy_list_optionmenu_setting)).setIcon(R.drawable.settings_new);
                } else {
                    menu.add(0, 6, 6, getResources().getString(R.string.buddy_list_optionmenu_setting)).setIcon(R.drawable.settings);
                }
                if (this.f967ad == 11) {
                    if (menu.findItem(3) == null) {
                        menu.add(0, 3, 3, getResources().getString(R.string.buddy_list_optionmenu_addgroup)).setIcon(R.drawable.group_add);
                    }
                } else {
                    menu.removeItem(3);
                }
            } else if (this.f969af == 7) {
                menu.clear();
                menu.add(0, 2, 2, getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setIcon(R.drawable.add_buddy);
                menu.add(0, 3, 3, getResources().getString(R.string.buddy_list_optionmenu_addgroup)).setIcon(R.drawable.group_edit);
                if (C1789u.m6075a().contains("UpdateIsCritical")) {
                    menu.add(0, 6, 6, getResources().getString(R.string.buddy_list_optionmenu_setting)).setIcon(R.drawable.settings_new);
                } else {
                    menu.add(0, 6, 6, getResources().getString(R.string.buddy_list_optionmenu_setting)).setIcon(R.drawable.settings);
                }
            } else if (this.f969af == 6) {
                menu.clear();
                if (this.f921I) {
                    menu.add(0, 7, 1, getResources().getString(R.string.buddy_list_contextual_menu_shortcut)).setEnabled(true).setIcon(R.drawable.add_shortcut);
                } else {
                    menu.add(0, 7, 1, getResources().getString(R.string.buddy_list_contextual_menu_shortcut)).setEnabled(false).setIcon(R.drawable.add_shortcut);
                }
                menu.add(0, 8, 2, getResources().getString(R.string.buddy_list_menubar_invite)).setIcon(R.drawable.invite_buddy);
            }
            this.f953aO = menu;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0337  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r10) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ArrayList arrayList;
        boolean z;
        ArrayList arrayList2;
        boolean z2 = true;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) contextMenuInfo;
        int packedPositionType = ExpandableListView.getPackedPositionType(expandableListContextMenuInfo.packedPosition);
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition);
        if (packedPositionType == 1) {
            int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListContextMenuInfo.packedPosition);
            C0257c c0257c = (C0257c) ((ArrayList) this.f975al.get(packedPositionGroup)).get(packedPositionChild);
            if (c0257c.m2350v()) {
                contextMenu.setHeaderTitle(c0257c.m2324b() + " (" + (c0257c.m2351w() != null ? c0257c.m2351w().size() : 0) + ")");
                if (GlobalApplication.m3265f()) {
                    contextMenu.add(0, 112, 1, getResources().getString(R.string.buddy_list_contextual_menu_viewprofile)).setOnMenuItemClickListener(this.f1003e);
                    contextMenu.add(0, 111, 3, getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).setOnMenuItemClickListener(this.f1003e);
                    contextMenu.add(0, 105, 2, getResources().getString(R.string.buddy_list_contextual_menu_shortcut)).setOnMenuItemClickListener(this.f1003e);
                } else {
                    contextMenu.add(0, 111, 1, getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).setOnMenuItemClickListener(this.f1003e);
                    contextMenu.add(0, 112, 2, getResources().getString(R.string.buddy_list_contextual_menu_viewprofile)).setOnMenuItemClickListener(this.f1003e);
                }
                this.f979ap = ((C0257c) ((ArrayList) this.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2347s();
                return;
            }
            this.f979ap = ((C0257c) ((ArrayList) this.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2347s();
            contextMenu.setHeaderTitle(((C0257c) ((ArrayList) this.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2324b());
            contextMenu.add(0, MediaEntity.Size.CROP, 1, getResources().getString(R.string.buddy_list_contextual_menu_viewprofile)).setOnMenuItemClickListener(this.f1003e);
            int i = 0;
            while (true) {
                if (i >= this.f972ai.size()) {
                    arrayList = null;
                    break;
                } else if (((C0255a) this.f972ai.get(i)).m2309d() != 1) {
                    i++;
                } else {
                    arrayList = (ArrayList) this.f973aj.get(i);
                    break;
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((C0257c) it.next()).m2318a().equals(((C0257c) ((ArrayList) this.f975al.get(packedPositionGroup)).get(packedPositionChild)).m2318a())) {
                        z = true;
                        break;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.f972ai.size()) {
                    arrayList2 = null;
                    break;
                } else if (((C0255a) this.f972ai.get(i2)).m2309d() != 7) {
                    i2++;
                } else {
                    arrayList2 = (ArrayList) this.f973aj.get(i2);
                    break;
                }
            }
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (((C0257c) it2.next()).m2318a().equals(c0257c.m2318a())) {
                        break;
                    }
                }
                z2 = false;
            } else {
                z2 = false;
            }
            if (c0257c.m2318a().startsWith("0999")) {
                if (z2) {
                    if (!m2039a(c0257c.m2318a())) {
                        contextMenu.add(0, 113, 2, getResources().getString(R.string.special_buddy_popup_like)).setOnMenuItemClickListener(this.f1003e);
                    } else {
                        contextMenu.add(0, 114, 2, getResources().getString(R.string.special_buddy_popup_unlike)).setOnMenuItemClickListener(this.f1003e);
                    }
                    contextMenu.add(0, 105, 3, getResources().getString(R.string.buddy_list_contextual_menu_shortcut)).setOnMenuItemClickListener(this.f1003e);
                    contextMenu.add(0, 104, 4, getResources().getString(R.string.buddy_list_contextual_menu_block)).setOnMenuItemClickListener(this.f1003e);
                }
            } else {
                if (z) {
                    contextMenu.add(0, 103, 2, getResources().getString(R.string.buddy_list_contextual_menu_removefavorites)).setOnMenuItemClickListener(this.f1003e);
                } else {
                    contextMenu.add(0, 102, 2, getResources().getString(R.string.buddy_list_contextual_menu_addfavorites)).setOnMenuItemClickListener(this.f1003e);
                }
                if (GlobalApplication.m3265f()) {
                    contextMenu.add(0, 104, 3, getResources().getString(R.string.buddy_list_contextual_menu_block)).setOnMenuItemClickListener(this.f1003e);
                    contextMenu.add(0, 105, 4, getResources().getString(R.string.buddy_list_contextual_menu_shortcut)).setOnMenuItemClickListener(this.f1003e);
                } else {
                    contextMenu.add(0, 105, 3, getResources().getString(R.string.buddy_list_contextual_menu_shortcut)).setOnMenuItemClickListener(this.f1003e);
                    contextMenu.add(0, 104, 4, getResources().getString(R.string.buddy_list_contextual_menu_block)).setOnMenuItemClickListener(this.f1003e);
                }
            }
            this.f978ao = c0257c;
        }
    }

    /* renamed from: a */
    public boolean m2039a(String str) {
        boolean zEquals;
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0704s.f2647a, null, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
            zEquals = cursorQuery.getString(cursorQuery.getColumnIndex("islike")).equals("Y");
        } else {
            zEquals = false;
        }
        cursorQuery.close();
        return zEquals;
    }

    /* renamed from: e */
    public int m2047e() {
        return this.f994bg;
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C0257c c0257c = (C0257c) ((ArrayList) this.f975al.get(i)).get(i2);
        this.f954aP = null;
        this.f955aQ = EnumC0448x.NONE;
        if (c0257c.m2350v()) {
            this.f980aq.m2462b(c0257c.m2318a());
            this.f980aq.m2455a((String) null, EnumC0448x.NONE);
            if (this.f1017s == 1 || this.f1017s == 2) {
                HashMap mapM2351w = c0257c.m2351w();
                if (mapM2351w != null && mapM2351w.size() > 0) {
                    Iterator it = mapM2351w.keySet().iterator();
                    while (it.hasNext()) {
                        String strValueOf = String.valueOf(it.next());
                        C1786r.m6067f(strValueOf + ", " + ((String) mapM2351w.get(strValueOf)), f908a);
                        if ((this.f969af == 10 || this.f969af == 11) && m1927O().size() > 199) {
                            m2056m();
                            Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                            return true;
                        }
                        if (this.f969af == 5 && this.f966ac.getStringArray(ChatFragment.f1749e).length + m1927O().size() > 199) {
                            m2056m();
                            Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                            return true;
                        }
                        if (this.f969af == 2 && m1927O().size() > 199) {
                            m2056m();
                            Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                            m2051h().findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                            m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                            return true;
                        }
                        this.f980aq.m2456a(strValueOf, true);
                    }
                    if ((this.f969af != 10 && this.f969af != 5 && this.f969af != 2 && this.f969af != 3 && this.f969af != 17 && this.f969af != 18) || !GlobalApplication.m3265f()) {
                        this.f980aq.m2460b();
                    }
                    this.f1021w.invalidateViews();
                    m2056m();
                    if (this.f969af == 17 || this.f969af == 18) {
                        if (m1927O().size() > this.f1016r - 1) {
                            if (this.f953aO != null) {
                                m2051h().findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                                m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                            }
                            m2029y();
                        } else if (this.f953aO != null) {
                            m2051h().findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                            m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                        }
                    }
                    if (GlobalApplication.m3265f()) {
                        Iterator it2 = mapM2351w.keySet().iterator();
                        while (it2.hasNext()) {
                            ArrayList arrayListM1998g = m1998g(String.valueOf(it2.next()));
                            if (arrayListM1998g != null && arrayListM1998g.size() > 0) {
                                Iterator it3 = arrayListM1998g.iterator();
                                while (it3.hasNext()) {
                                    C0257c c0257c2 = (C0257c) it3.next();
                                    c0257c2.m2322a(true);
                                    this.f997bj.mo2367a(c0257c2);
                                }
                            }
                        }
                    }
                }
            } else {
                String[] strArr = null;
                if (c0257c.m2351w() != null) {
                    strArr = (String[]) c0257c.m2351w().keySet().toArray(new String[0]);
                }
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_PURPOSE", 6);
                intent.putExtra("ACTIVITY_PURPOSE_ARG", c0257c.m2318a());
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("group profile", "GROUP PROFILE");
                intent.putExtra("ACTION_PURPOSE_ARG1", c0257c.m2324b());
                intent.putExtra("ACTION_PURPOSE_ARG2", strArr);
                intent.putExtra(ChatFragment.f1749e, strArr);
                if (c0257c.m2351w().size() == 1) {
                    intent.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                } else {
                    intent.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                }
                GroupProfileFragment groupProfileFragment = new GroupProfileFragment();
                groupProfileFragment.setArguments(intent.getExtras());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, groupProfileFragment, "container").commit();
                this.f1021w.invalidateViews();
            }
        } else if (this.f1017s == 0) {
            if (c0257c.m2318a().toString().startsWith("0999")) {
            }
            this.f980aq.m2462b((String) null);
            EnumC0448x enumC0448x = EnumC0448x.NONE;
            if (this.f969af == 1) {
                if (((C0255a) this.f974ak.get(i)).m2309d() == 0) {
                    enumC0448x = EnumC0448x.BIRTHDAY;
                } else if (((C0255a) this.f974ak.get(i)).m2309d() == 1) {
                    enumC0448x = EnumC0448x.FAVOURITE;
                } else if (((C0255a) this.f974ak.get(i)).m2309d() == -1) {
                    enumC0448x = EnumC0448x.NEWBUDDY;
                } else if (((C0255a) this.f974ak.get(i)).m2309d() == 2) {
                    enumC0448x = EnumC0448x.ALPHA;
                } else if (((C0255a) this.f974ak.get(i)).m2309d() == 7) {
                    enumC0448x = EnumC0448x.SPECIAL_BUDDY;
                } else {
                    enumC0448x = EnumC0448x.NONE;
                }
                this.f980aq.m2455a(c0257c.m2318a(), enumC0448x);
            }
            if (this.f969af == 17 || this.f969af == 18) {
                if (!new C0529i(getActivity(), new C0275aq(this), new String[]{c0257c.m2318a()}, this.f969af == 17).m2698a()) {
                    C2153y.m7536a(getActivity(), "Install Coolots app first.", 0).show();
                }
                return true;
            }
            if (c0257c.m2318a().toString().startsWith("0999")) {
                this.f981ar.m2376b(c0257c.m2318a());
            } else {
                this.f981ar.m2373a(c0257c.m2318a());
            }
            if (GlobalApplication.m3265f()) {
                this.f954aP = c0257c.m2318a();
                this.f955aQ = enumC0448x;
                if (this.f955aQ == EnumC0448x.NEWBUDDY) {
                    this.f955aQ = EnumC0448x.ALPHA;
                }
            }
        } else {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.buddy_child_check);
            if (this.f969af == 17 || this.f969af == 18) {
                if (m1996f(c0257c.m2318a())) {
                    m2036a(c0257c.m2318a(), checkBox.isChecked(), c0257c.m2324b(), checkBox);
                }
            } else {
                if (checkBox.isChecked()) {
                    checkBox.setChecked(false);
                } else {
                    checkBox.setChecked(true);
                }
                this.f980aq.m2456a(c0257c.m2318a(), checkBox.isChecked());
                if ((this.f969af != 10 && this.f969af != 5 && this.f969af != 2 && this.f969af != 3 && this.f969af != 11 && this.f969af != 17 && this.f969af != 18) || !GlobalApplication.m3265f()) {
                    this.f980aq.m2457a(m2049f());
                }
                this.f937Y = this.f966ac.getInt("chatType");
                HashSet hashSetM1927O = m1927O();
                if (this.f969af == 3 && hashSetM1927O.size() > 200) {
                    checkBox.setChecked(false);
                    this.f980aq.m2456a(c0257c.m2318a(), checkBox.isChecked());
                    Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                    m1921L();
                    return true;
                }
                if (this.f969af == 2 && hashSetM1927O.size() > 199) {
                    checkBox.setChecked(false);
                    this.f980aq.m2456a(c0257c.m2318a(), checkBox.isChecked());
                    Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                    m1921L();
                    return true;
                }
                if (this.f969af == 8 && hashSetM1927O.size() > 199) {
                    checkBox.setChecked(false);
                    this.f980aq.m2456a(c0257c.m2318a(), checkBox.isChecked());
                    Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                    m1921L();
                    return true;
                }
                if (this.f969af == 5 && this.f966ac.getStringArray(ChatFragment.f1749e).length + m1927O().size() > 199 && checkBox.isChecked()) {
                    checkBox.setChecked(false);
                    this.f980aq.m2456a(c0257c.m2318a(), checkBox.isChecked());
                    if (this.f937Y == EnumC0695j.GROUPCHAT.m3146a() || this.f937Y == EnumC0695j.ONETOONE.m3146a()) {
                        Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                    } else {
                        Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), 199), 0).show();
                    }
                    m1921L();
                    return true;
                }
                if ((this.f969af == 10 || this.f969af == 11) && m1927O().size() > 199 && checkBox.isChecked()) {
                    checkBox.setChecked(false);
                    this.f980aq.m2456a(c0257c.m2318a(), checkBox.isChecked());
                    Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                    m1921L();
                    return true;
                }
                m1921L();
                this.f1021w.invalidateViews();
                m2056m();
                this.f997bj.mo2367a(c0257c);
            }
        }
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return this.f969af == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m1917J() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f1024z.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: K */
    private void m1919K() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f975al.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (!c0257c.m2350v()) {
                    if (c0257c.m2345q()) {
                        hashSet.add(c0257c.m2318a());
                        i2++;
                    } else {
                        i++;
                    }
                }
            }
        }
        C1786r.m6067f("mCheckedCount:" + i2 + "  mUnCheckedCount:" + i, f908a);
        String str = String.format("%d/%d", Integer.valueOf(hashSet.size()), Integer.valueOf(m2047e()));
        if (this.f1017s == 2) {
            this.f984au.setVisibility(0);
            this.f985av.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m1921L() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = this.f975al.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2345q()) {
                    hashSet.add(c0257c.m2318a());
                } else {
                    hashSet2.add(c0257c.m2318a());
                }
            }
        }
        m1919K();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            Iterator it4 = this.f973aj.iterator();
            while (it4.hasNext()) {
                Iterator it5 = ((ArrayList) it4.next()).iterator();
                while (it5.hasNext()) {
                    C0257c c0257c2 = (C0257c) it5.next();
                    if (c0257c2.m2318a().equals(str)) {
                        c0257c2.m2322a(true);
                    }
                }
            }
        }
        Iterator it6 = hashSet2.iterator();
        while (it6.hasNext()) {
            String str2 = (String) it6.next();
            Iterator it7 = this.f973aj.iterator();
            while (it7.hasNext()) {
                Iterator it8 = ((ArrayList) it7.next()).iterator();
                while (it8.hasNext()) {
                    C0257c c0257c3 = (C0257c) it8.next();
                    if (c0257c3.m2318a().equals(str2)) {
                        c0257c3.m2322a(false);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1956a(ArrayList arrayList) {
        Iterator it = m1927O().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((ArrayList) it2.next()).iterator();
                while (it3.hasNext()) {
                    C0257c c0257c = (C0257c) it3.next();
                    if (c0257c.m2318a().equals(str)) {
                        c0257c.m2322a(true);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m2041b(String str) {
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2318a().equals(str)) {
                    c0257c.m2322a(false);
                }
            }
        }
    }

    /* renamed from: f */
    public ArrayList m2049f() {
        C1786r.m6067f("* getPreviousSelectList()", f908a);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2345q() && !arrayList.contains(c0257c.m2318a())) {
                    arrayList.add(c0257c.m2318a());
                }
            }
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        C1786r.m6067f("onActivityResult()", f908a);
        if (i == 1) {
            if (i2 == -1) {
                C1786r.m6067f("Add buddy success", f908a);
                if (this.f981ar != null) {
                    this.f981ar.m2370a();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 5 && i2 == -1 && !GlobalApplication.m3265f()) {
            String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
            Intent intent2 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent2.putExtra("receivers", stringArrayExtra);
            intent2.putExtra("inboxNO", this.f934V);
            intent2.putExtra("buddyNO", this.f935W);
            intent2.putExtra("chatType", this.f937Y);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
        }
        if (GlobalApplication.m3265f()) {
            if (i == 11 && i2 == -1) {
                String stringExtra = intent.getStringExtra("ACTIVITY_PURPOSE_ARG");
                if (stringExtra == null) {
                    stringExtra = "0";
                }
                String stringExtra2 = intent.getStringExtra("ACTIVITY_PURPOSE_ARG2");
                if (stringExtra == null) {
                }
                if (this.f980aq.m2463c() != null) {
                    if (this.f980aq.m2463c().equals(stringExtra)) {
                        if (stringExtra2 == null) {
                            if (getFragmentManager().findFragmentById(R.id.fragment_container) instanceof BuddySelectFragment) {
                                String stringExtra3 = intent.getStringExtra("ACTIVITY_PURPOSE_ARG");
                                C1786r.m6067f("************ Group no : " + stringExtra3, f908a);
                                if (stringExtra3 != null) {
                                    this.f982as.m2382a(stringExtra3);
                                }
                            }
                        } else if (getFragmentManager().findFragmentById(R.id.fragment_container) instanceof BuddySelectFragment) {
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyBuddyFragment(), "container").commitAllowingStateLoss();
                        }
                    }
                } else {
                    return;
                }
            }
            if (i != 13 || i2 == -1) {
            }
        }
    }

    /* renamed from: M */
    private void m1922M() {
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2338j() || c0257c.m2349u() || c0257c.m2348t()) {
                    this.f981ar.m2379d();
                    return;
                }
            }
        }
    }

    /* renamed from: N */
    private void m1925N() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2350v() && c0257c.m2338j()) {
                    stringBuffer.append(c0257c.m2318a() + ",");
                }
            }
        }
        if (this.f969af != 10 && stringBuffer.toString().length() > 0) {
            this.f981ar.m2381e();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        new Timer(true).schedule(new C0279au(this, new Handler()), 100L);
    }

    /* renamed from: g */
    public void m2050g() {
        if (!this.f921I && this.f936X == null) {
            if (EnumC0695j.m3145a(this.f937Y) == EnumC0695j.GROUPCHAT) {
                this.f936X += this.f964aa + " (" + (this.f938Z.length + 1) + ")";
            } else if (EnumC0695j.m3145a(this.f937Y) == EnumC0695j.BROADCAST) {
                this.f936X += this.f964aa + " (" + this.f938Z.length + ")";
            } else {
                this.f936X = this.f964aa;
            }
            this.f936X = this.f964aa;
        }
        if (this.f936X != null) {
            if (EnumC0695j.m3145a(this.f937Y) == EnumC0695j.GROUPCHAT) {
                this.f936X += " (" + (this.f938Z.length + 1) + ")";
            } else if (EnumC0695j.m3145a(this.f937Y) == EnumC0695j.BROADCAST) {
                this.f936X += " (" + this.f938Z.length + ")";
            } else {
                this.f936X = this.f964aa;
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0454a
    public boolean isBackKeyIgnore() {
        if (this.f969af != 6) {
            return true;
        }
        C1786r.m6064d("mEditTitle.isFocusable()" + this.f924L.isFocused());
        if (!this.f924L.isFocused()) {
            m2050g();
            Intent intent = new Intent();
            intent.putExtra("receivers", (String[]) null);
            intent.putExtra(ChatFragment.f1753i, this.f936X);
            intent.putExtra(ChatFragment.f1755k, this.f923K);
            getActivity().setResult(-1, intent);
            getActivity().finish();
            C1786r.m6064d("not focus");
            return true;
        }
        this.f925M.requestFocus();
        C1786r.m6064d("focus");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public HashSet m1927O() {
        HashSet hashSet = new HashSet();
        m1921L();
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2345q()) {
                    hashSet.add(c0257c.m2318a());
                }
            }
        }
        return hashSet;
    }

    /* renamed from: P */
    private HashSet m1929P() {
        HashSet hashSet = new HashSet();
        m1921L();
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (!c0257c.m2345q()) {
                    hashSet.add(c0257c.m2318a());
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C0257c m1947a(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2318a().equals(str)) {
                    return c0257c;
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    private boolean m1996f(String str) {
        if (this.f956aR == null) {
            return true;
        }
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2318a().equals(str)) {
                    return m2038a(c0257c);
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m2038a(C0257c c0257c) {
        return this.f956aR == null || c0257c.m2350v() || c0257c.m2323a(this.f956aR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public ArrayList m1998g(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f973aj.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2318a().equals(str)) {
                    arrayList.add(c0257c);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m2034a(InterfaceC0298bj interfaceC0298bj) {
        this.f997bj = interfaceC0298bj;
    }

    @Override // com.sec.chaton.buddy.honeycomb.InterfaceC0432o
    /* renamed from: c */
    public void mo2044c(String str) {
        C1786r.m6067f("onBuddyRemove() : " + str, f908a);
        this.f980aq.m2456a(str, false);
        m2041b(str);
        this.f980aq.m2457a(m2049f());
        this.f1021w.invalidateViews();
    }

    /* renamed from: a */
    public ArrayList m2032a(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            arrayList4.add(str);
            arrayList5.add(str);
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (!arrayList.contains(str2)) {
                arrayList4.add(str2);
                arrayList5.add(str2);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList4.remove((String) it3.next());
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            arrayList5.remove((String) it4.next());
        }
        arrayList3.add(arrayList4);
        arrayList3.add(arrayList5);
        return arrayList3;
    }

    /* renamed from: h */
    public Menu m2051h() {
        return this.f953aO;
    }

    /* renamed from: i */
    public C1798b m2052i() {
        return this.f919G;
    }

    /* renamed from: j */
    public AdapterView.OnItemSelectedListener m2053j() {
        return this.f1002d;
    }

    /* renamed from: d */
    public void m2046d(String str) {
        C1786r.m6067f("NEW GROUP NAME : " + str, f908a);
        C1786r.m6067f("MEMBER COUNT  : " + this.f938Z.length, f908a);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f938Z.length; i++) {
            arrayList.add(this.f938Z[i]);
        }
        arrayList.add(0, str);
        C0668l.m3077a(new C0668l(), 2, new C0680g(this.f1007i, (String[]) arrayList.toArray(new String[0]), 2));
    }

    /* renamed from: k */
    public void m2054k() throws NumberFormatException {
        Intent intent;
        if (this.f969af == 10 || this.f969af == 11) {
            HashSet hashSetM1927O = m1927O();
            if (hashSetM1927O.size() > 0) {
                C1786r.m6067f("NEW GROUP NAME : " + this.f966ac.getString("ACTION_PURPOSE_ARG1"), f908a);
                C1786r.m6067f("MEMBER COUNT  : " + hashSetM1927O.size(), f908a);
                this.f989az = ProgressDialogC1806j.m6141a(this.f1018t, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                ArrayList arrayList = new ArrayList();
                Iterator it = hashSetM1927O.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                if (this.f969af == 10) {
                    arrayList.add(0, this.f966ac.getString("ACTIVITY_PURPOSE_ARG2"));
                    C0668l.m3077a(new C0668l(), 2, new C0680g(this.f1007i, (String[]) arrayList.toArray(new String[0]), 2));
                    getActivity().finish();
                    Toast.makeText(this.f1018t, R.string.buddy_new_group_created, 0).show();
                    return;
                }
                arrayList.add(0, this.f966ac.getString("ACTION_PURPOSE_ARG1"));
                int i = Integer.parseInt(getArguments().getString("ACTIVITY_PURPOSE_ARG"));
                C0680g c0680g = new C0680g(this.f1005g, (String[]) arrayList.toArray(new String[0]), 3);
                c0680g.m3100b(i);
                C0668l.m3077a(new C0668l(), 3, c0680g);
                Intent intent2 = new Intent(this.f1018t, (Class<?>) GroupProfileActivity.class);
                intent2.setFlags(67108864);
                intent2.putExtra("ACTIVITY_PURPOSE", 6);
                intent2.putExtra("ACTIVITY_PURPOSE_ARG", getArguments().getString("ACTIVITY_PURPOSE_ARG"));
                intent2.putExtra("BUDDY_SORT_STYLE", 11);
                intent2.putExtra("group profile", "GROUP PROFILE");
                intent2.putExtra("ACTION_PURPOSE_ARG1", this.f966ac.getString("ACTION_PURPOSE_ARG1"));
                intent2.putExtra("ACTION_PURPOSE_ARG2", (String[]) hashSetM1927O.toArray(new String[0]));
                intent2.putExtra(ChatFragment.f1749e, (String[]) hashSetM1927O.toArray(new String[0]));
                startActivityForResult(intent2, 6);
                return;
            }
            return;
        }
        if (this.f969af == 2) {
            HashSet hashSetM1927O2 = m1927O();
            String[] strArr = (String[]) hashSetM1927O2.toArray(new String[0]);
            if (hashSetM1927O2.size() > 0) {
                Intent intentM585a = HomeActivity.m585a((Context) getActivity(), true);
                if (hashSetM1927O2.size() == 1) {
                    intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                } else {
                    intentM585a.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                }
                intentM585a.putExtra("receivers", strArr);
                if (this.f943aE) {
                    intentM585a.putExtra("content_type", this.f944aF);
                    intentM585a.putExtra("download_uri", this.f945aG);
                    intentM585a.putExtra("sub_content", this.f946aH);
                    intentM585a.putExtra("forward_sender_name", this.f1011m);
                }
                startActivity(intentM585a);
                return;
            }
            return;
        }
        if (this.f969af == 3) {
            HashSet hashSetM1927O3 = m1927O();
            String[] strArr2 = (String[]) hashSetM1927O3.toArray(new String[0]);
            if (hashSetM1927O3.size() > 0) {
                Intent intentM585a2 = HomeActivity.m585a((Context) getActivity(), true);
                intentM585a2.putExtra("chatType", EnumC0695j.BROADCAST.m3146a());
                intentM585a2.putExtra("receivers", strArr2);
                if (this.f943aE) {
                    intentM585a2.putExtra("content_type", this.f944aF);
                    intentM585a2.putExtra("download_uri", this.f945aG);
                    intentM585a2.putExtra("sub_content", this.f946aH);
                    intentM585a2.putExtra("forward_sender_name", this.f1011m);
                }
                startActivity(intentM585a2);
                return;
            }
            return;
        }
        if (this.f969af == 5) {
            HashSet hashSetM1927O4 = m1927O();
            C1786r.m6067f("checkedBuddySet.size() : " + hashSetM1927O4.size(), f908a);
            C1786r.m6067f("mBundle.getStringArray(ChatFragment.EXTRA_PARTICIPANT).length : " + this.f966ac.getStringArray(ChatFragment.f1749e).length, f908a);
            C1786r.m6067f("mBundle.getInt(ChatFragment.KEY_CHAT_TYPE) : " + this.f966ac.getInt("chatType"), f908a);
            int i2 = this.f966ac.getInt("chatType");
            if (hashSetM1927O4.size() > 0) {
                if (i2 == EnumC0695j.GROUPCHAT.m3146a() || i2 == EnumC0695j.ONETOONE.m3146a()) {
                    if (this.f966ac.getStringArray(ChatFragment.f1749e).length + hashSetM1927O4.size() > 199) {
                        Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                        return;
                    }
                } else if (i2 == EnumC0695j.BROADCAST.m3146a() && this.f966ac.getStringArray(ChatFragment.f1749e).length + hashSetM1927O4.size() > 200) {
                    Toast.makeText(this.f1018t, String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                    return;
                }
                if (!GlobalApplication.m3265f()) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("receivers", (String[]) hashSetM1927O4.toArray(new String[0]));
                    getActivity().setResult(-1, intent3);
                    getActivity().finish();
                    return;
                }
                this.f934V = this.f966ac.getString("inboxNO");
                this.f937Y = this.f966ac.getInt("chatType");
                this.f921I = this.f966ac.getBoolean(ChatFragment.f1753i);
                ArrayList arrayList2 = new ArrayList();
                if (EnumC0695j.m3145a(this.f937Y) == EnumC0695j.ONETOONE || !this.f921I) {
                    for (String str : this.f966ac.getStringArray(ChatFragment.f1749e)) {
                        arrayList2.add(str);
                    }
                }
                String[] strArr3 = (String[]) hashSetM1927O4.toArray(new String[0]);
                for (String str2 : strArr3) {
                    arrayList2.add(str2);
                }
                if (EnumC0695j.m3145a(this.f937Y) == EnumC0695j.ONETOONE) {
                    Intent intentM585a3 = HomeActivity.m585a((Context) getActivity(), true);
                    intentM585a3.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                    intentM585a3.putExtra("receivers", (String[]) arrayList2.toArray(new String[0]));
                    intent = intentM585a3;
                } else {
                    Intent intentM585a4 = HomeActivity.m585a((Context) getActivity(), true);
                    intentM585a4.setFlags(67108864);
                    intentM585a4.putExtra("receivers", (String[]) arrayList2.toArray(new String[0]));
                    intentM585a4.putExtra("chatType", this.f937Y);
                    intentM585a4.putExtra(ChatFragment.f1756l, true);
                    if (this.f921I) {
                        intentM585a4.putExtra("inboxNO", this.f934V);
                        intent = intentM585a4;
                    } else {
                        intent = intentM585a4;
                    }
                }
                startActivity(intent);
                return;
            }
            return;
        }
        if (this.f969af == 9) {
            String[] strArr4 = (String[]) m1929P().toArray(new String[0]);
            ArrayList arrayList3 = new ArrayList();
            for (String str3 : strArr4) {
                arrayList3.add(str3);
            }
            ArrayList arrayListM2032a = m2032a(arrayList3, this.f947aI);
            this.f947aI.clear();
            this.f947aI = arrayList3;
            ArrayList arrayList4 = (ArrayList) arrayListM2032a.get(0);
            ArrayList arrayList5 = (ArrayList) arrayListM2032a.get(1);
            C0638j c0638j = new C0638j(this.f1004f);
            if (arrayList4.size() == 0 && arrayList5.size() == 0) {
                getActivity().finish();
                return;
            }
            c0638j.m2900a(arrayList5, arrayList4);
            this.f989az = ProgressDialogC1806j.m6141a(this.f1018t, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            this.f989az.show();
            this.f1024z.setText("");
            getActivity().finish();
            return;
        }
        if (this.f969af == 17 || this.f969af == 18) {
            HashSet hashSetM1927O5 = m1927O();
            if (hashSetM1927O5.size() > 0) {
                if (!new C0529i(getActivity(), new C0282ax(this), (String[]) hashSetM1927O5.toArray(new String[0]), this.f969af == 17).m2698a()) {
                    Toast.makeText(getActivity(), "Install Coolots app first.", 0).show();
                    return;
                }
                return;
            }
            return;
        }
        if (this.f969af == 19) {
            for (String str4 : (String[]) m1927O().toArray(new String[0])) {
                this.f949aK.add(str4);
            }
            this.f989az = ProgressDialogC1806j.m6141a(this.f1018t, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            this.f989az.show();
            new C0632d(this.f1004f).m2850b(this.f949aK);
            this.f1024z.setText("");
        }
    }

    /* renamed from: a */
    public void m2035a(String str, String str2) {
        this.f1010l = Toast.makeText(getActivity().getApplicationContext(), R.string.trunk_toast_deleted, 0);
        C1786r.m6067f("Parul: deleteGroup() ", f908a);
        new AlertDialogBuilderC2120a(this.f1018t).setTitle(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).setMessage(String.format(getResources().getString(R.string.groupname_will_be_deleted_message), str2)).setNegativeButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0283ay(this, str)).setPositiveButton(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
    }

    /* renamed from: l */
    public void m2055l() {
        this.f981ar.m2370a();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m2048e(java.lang.String r9) {
        /*
            r8 = this;
            r7 = 1
            r6 = 0
            java.lang.String r0 = "isBuddy()"
            java.lang.String r1 = com.sec.chaton.buddy.BuddyFragment.f908a
            com.sec.chaton.util.C1786r.m6061b(r0, r1)
            android.net.Uri r1 = com.sec.chaton.p017e.C0688c.m3121a(r9)
            android.support.v4.app.FragmentActivity r0 = r8.getActivity()     // Catch: java.lang.Exception -> L57
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L57
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L57
            r3 = 0
            java.lang.String r4 = "buddy_no"
            r2[r3] = r4     // Catch: java.lang.Exception -> L57
            java.lang.String r3 = "buddy_no = ? "
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L57
            r5 = 0
            r4[r5] = r9     // Catch: java.lang.Exception -> L57
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L57
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L57
            r0.<init>()     // Catch: java.lang.Exception -> L57
            java.lang.String r2 = "buddyLookup = "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> L57
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L57
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L57
            java.lang.String r2 = com.sec.chaton.buddy.BuddyFragment.f908a     // Catch: java.lang.Exception -> L57
            com.sec.chaton.util.C1786r.m6061b(r0, r2)     // Catch: java.lang.Exception -> L57
            if (r1 == 0) goto L62
            int r0 = r1.getCount()     // Catch: java.lang.Exception -> L57
            if (r0 <= 0) goto L62
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Exception -> L57
            if (r0 == 0) goto L62
            r0 = r7
        L51:
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.lang.Exception -> L60
        L56:
            return r0
        L57:
            r0 = move-exception
            r1 = r0
            r0 = r6
        L5a:
            java.lang.String r2 = com.sec.chaton.buddy.BuddyFragment.f908a
            com.sec.chaton.util.C1786r.m6056a(r1, r2)
            goto L56
        L60:
            r1 = move-exception
            goto L5a
        L62:
            r0 = r6
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m2048e(java.lang.String):boolean");
    }

    /* renamed from: m */
    public void m2056m() {
        HashSet hashSetM1927O = m1927O();
        if (hashSetM1927O != null && hashSetM1927O.size() > 0) {
            if (this.f962aX != null) {
                this.f962aX.mo2229b();
                if (m2051h() != null) {
                    if (this.f969af == 2 || this.f969af == 3 || this.f969af == 18 || this.f969af == 17 || this.f969af == 8 || this.f969af == 11 || this.f969af == 9 || this.f969af == 5 || this.f969af == 10 || this.f969af == 19) {
                        m2051h().findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                        m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.f962aX != null) {
            this.f962aX.mo2228a();
            if (m2051h() != null) {
                if (this.f969af == 2 || this.f969af == 3 || this.f969af == 18 || this.f969af == 17 || this.f969af == 8 || this.f969af == 11 || this.f969af == 9 || this.f969af == 5 || this.f969af == 10 || this.f969af == 19) {
                    m2051h().findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                    m2051h().findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m1954a(InterfaceC0299bk interfaceC0299bk, String str) {
        C1786r.m6061b("Suraj registerForProfileUIupdates listener = " + interfaceC0299bk + " buddyNo = " + str, f908a);
        if (!f912bc.containsValue(interfaceC0299bk)) {
            f912bc.put(str, interfaceC0299bk);
        }
    }

    /* renamed from: b */
    public static synchronized void m1974b(InterfaceC0299bk interfaceC0299bk, String str) {
        C1786r.m6066e("Suraj unregisterForProfileUIupdates listener = " + interfaceC0299bk, f908a);
        if (f912bc.containsValue(interfaceC0299bk)) {
            f912bc.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m1950a(int i, String str) {
        Iterator it = f912bc.keySet().iterator();
        if (it.hasNext()) {
            for (InterfaceC0299bk interfaceC0299bk : f912bc.values()) {
                C1786r.m6063c("Suraj dispatchProfileUIupdates listener = " + interfaceC0299bk + " buddyNo = " + str, f908a);
                if (str.equals(it.next())) {
                    if (i == f909aZ) {
                        interfaceC0299bk.mo2173a();
                    } else if (i == f910ba) {
                        interfaceC0299bk.mo2174b();
                    } else if (i == f911bb) {
                        interfaceC0299bk.mo2175c();
                    }
                } else {
                    C1786r.m6063c("Suraj listener does not correspond to buddy!!! ", f908a);
                }
            }
        }
    }

    /* renamed from: b */
    public void m2040b(int i) {
        if (this.f958aT != null) {
            if (i > 0) {
                this.f958aT.setVisibility(0);
                if (i >= 100) {
                    this.f958aT.setText(R.string.chat_max_unread);
                    this.f958aT.setTextSize(0, this.f958aT.getResources().getDimension(R.dimen.text_size_10));
                    return;
                }
                this.f958aT.setText(String.valueOf(i));
                if (i >= 10) {
                    this.f958aT.setTextSize(0, this.f958aT.getResources().getDimension(R.dimen.text_size_12));
                    return;
                } else {
                    this.f958aT.setTextSize(0, this.f958aT.getResources().getDimension(R.dimen.text_size_13));
                    return;
                }
            }
            this.f958aT.setVisibility(8);
        }
    }

    /* renamed from: n */
    public void m2057n() {
        int i = 0;
        if (this.f969af == 1 && this.f972ai.size() > 0) {
            boolean z = C1789u.m6075a().getBoolean("Profile Birth Chk", true);
            C1786r.m6067f("onStart() isShowBirthdayCategory : " + z, f908a);
            if (z) {
                while (true) {
                    int i2 = i;
                    if (i2 < this.f972ai.size()) {
                        if (((C0255a) this.f972ai.get(i2)).m2309d() != 0) {
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    } else {
                        if (m1907E()) {
                            m1975b(this.f972ai, this.f973aj);
                            return;
                        }
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = i;
                    if (i3 < this.f972ai.size()) {
                        if (((C0255a) this.f972ai.get(i3)).m2309d() != 0) {
                            i = i3 + 1;
                        } else {
                            this.f972ai.remove(i3);
                            this.f973aj.remove(i3);
                            m1975b(this.f972ai, this.f973aj);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: o */
    public C1798b m2058o() {
        return this.f959aU;
    }

    /* renamed from: p */
    public AdapterView.OnItemSelectedListener m2059p() {
        return this.f1009k;
    }

    /* renamed from: Q */
    private void m1931Q() {
        this.f999bl = new C1741ax();
        this.f999bl.m5931a("get_all_buddies_in_buddylist", this.f1000bm, 60000L, "last_sync_time_get_all_buddies_in_buddylist");
    }
}
