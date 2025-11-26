package com.sec.chaton.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.motion.MREvent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0725k;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.coolots.C0613d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.multimedia.audio.RecordAudio;
import com.sec.chaton.multimedia.geotag.GeotagActivity;
import com.sec.chaton.multimedia.p034a.C0758a;
import com.sec.chaton.multimedia.p034a.C0759b;
import com.sec.chaton.multimedia.p034a.C0760c;
import com.sec.chaton.multimedia.p034a.C0762e;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcalendar.VCalendarListActivity2;
import com.sec.chaton.multimedia.vcard.VCardReadContactActivity;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p013a.p014a.C0159bh;
import com.sec.chaton.p015b.p016a.C0258f;
import com.sec.chaton.p015b.p016a.EnumC0255c;
import com.sec.chaton.p018c.C0476aa;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.p018c.p019a.C0473j;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p031h.C0717b;
import com.sec.chaton.p031h.DialogC0716a;
import com.sec.chaton.p031h.InterfaceC0720e;
import com.sec.chaton.p032i.C0722a;
import com.sec.chaton.p032i.InterfaceC0723b;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1301ax;
import com.sec.chaton.util.C1311bg;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1346u;
import com.sec.chaton.widget.C1356c;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.p007b.p008a.p011c.C0119d;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.C1632t;
import com.sec.widget.HeightChangedListView;
import com.sec.widget.InterfaceC1618f;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Timer;

/* loaded from: classes.dex */
public class ChatFragment extends Fragment implements MediaPlayer.OnCompletionListener, View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC0531ag, InterfaceC0532ah, InterfaceC0720e, InterfaceC0723b {

    /* renamed from: aC */
    private static EditText f1726aC;

    /* renamed from: A */
    int f1740A;

    /* renamed from: B */
    String f1741B;

    /* renamed from: E */
    public ProgressDialog f1744E;

    /* renamed from: G */
    AnimationDrawable f1746G;

    /* renamed from: U */
    private C0630j f1760U;

    /* renamed from: V */
    private ImageButton f1761V;

    /* renamed from: W */
    private ImageButton f1762W;

    /* renamed from: X */
    private Button f1763X;

    /* renamed from: Y */
    private Button f1764Y;

    /* renamed from: Z */
    private Button f1765Z;

    /* renamed from: aA */
    private long f1766aA;

    /* renamed from: aB */
    private boolean f1767aB;

    /* renamed from: aD */
    private C0758a f1768aD;

    /* renamed from: aE */
    private C0758a f1769aE;

    /* renamed from: aF */
    private String f1770aF;

    /* renamed from: aG */
    private String f1771aG;

    /* renamed from: aH */
    private String f1772aH;

    /* renamed from: aI */
    private String f1773aI;

    /* renamed from: aJ */
    private int f1774aJ;

    /* renamed from: aK */
    private String f1775aK;

    /* renamed from: aL */
    private String f1776aL;

    /* renamed from: aM */
    private String f1777aM;

    /* renamed from: aa */
    private Button f1791aa;

    /* renamed from: ab */
    private Button f1792ab;

    /* renamed from: ac */
    private LinearLayout f1793ac;

    /* renamed from: ad */
    private HeightChangedListView f1794ad;

    /* renamed from: ae */
    private ViewOnClickListenerC0603t f1795ae;

    /* renamed from: af */
    private Cursor f1796af;

    /* renamed from: ag */
    private Toast f1797ag;

    /* renamed from: ai */
    private C0223v f1799ai;

    /* renamed from: al */
    private ArrayList f1802al;

    /* renamed from: am */
    private HashMap f1803am;

    /* renamed from: an */
    private Long f1804an;

    /* renamed from: ao */
    private String f1805ao;

    /* renamed from: ap */
    private String f1806ap;

    /* renamed from: aq */
    private String f1807aq;

    /* renamed from: ar */
    private String f1808ar;

    /* renamed from: as */
    private String f1809as;

    /* renamed from: at */
    private String f1810at;

    /* renamed from: au */
    private String f1811au;

    /* renamed from: av */
    private String f1812av;

    /* renamed from: aw */
    private int f1813aw;

    /* renamed from: ax */
    private int f1814ax;

    /* renamed from: ay */
    private Uri f1815ay;

    /* renamed from: az */
    private boolean f1816az;

    /* renamed from: bA */
    private int f1817bA;

    /* renamed from: bC */
    private String f1819bC;

    /* renamed from: bE */
    private C1632t f1821bE;

    /* renamed from: bF */
    private int f1822bF;

    /* renamed from: bG */
    private SharedPreferences f1823bG;

    /* renamed from: bI */
    private C0119d f1825bI;

    /* renamed from: bM */
    private InterfaceC0604u f1828bM;

    /* renamed from: bd */
    private Button f1832bd;

    /* renamed from: be */
    private CheckBox f1833be;

    /* renamed from: bf */
    private InputMethodManager f1834bf;

    /* renamed from: bg */
    private ImageView f1835bg;

    /* renamed from: bh */
    private ImageView f1836bh;

    /* renamed from: bi */
    private GridView f1837bi;

    /* renamed from: bj */
    private GridView f1838bj;

    /* renamed from: bk */
    private ScrollView f1839bk;

    /* renamed from: bl */
    private Bundle f1840bl;

    /* renamed from: bm */
    private int f1841bm;

    /* renamed from: bn */
    private AlertDialogBuilderC1625m f1842bn;

    /* renamed from: br */
    private ImageButton f1846br;

    /* renamed from: bu */
    private DialogC0716a f1849bu;

    /* renamed from: bz */
    private int f1853bz;

    /* renamed from: l */
    LinearLayout f1854l;

    /* renamed from: m */
    LinearLayout f1855m;

    /* renamed from: n */
    LinearLayout f1856n;

    /* renamed from: t */
    public String f1861t;

    /* renamed from: u */
    public String f1862u;

    /* renamed from: y */
    EnumC0665r f1866y;

    /* renamed from: z */
    String f1867z;

    /* renamed from: a */
    public static final String f1725a = ChatFragment.class.getSimpleName();

    /* renamed from: b */
    public static String f1727b = "extra fileuri";

    /* renamed from: c */
    public static String f1730c = "extra participant";

    /* renamed from: d */
    public static String f1731d = "extra title";

    /* renamed from: e */
    public static String f1732e = "extra vcalendar";

    /* renamed from: f */
    public static String f1733f = "extra vard name";

    /* renamed from: g */
    public static String f1734g = "extra initchat";

    /* renamed from: h */
    public static String f1735h = "extra showinput";

    /* renamed from: i */
    public static String f1736i = "extra chagetitle";

    /* renamed from: j */
    public static String f1737j = "extra invite";

    /* renamed from: k */
    public static String f1738k = "extra inbox nobi";

    /* renamed from: o */
    static boolean f1739o = false;

    /* renamed from: bx */
    private static int f1729bx = 30;

    /* renamed from: bJ */
    private static ArrayList f1728bJ = new ArrayList();

    /* renamed from: T */
    private Object f1759T = new Object();

    /* renamed from: p */
    public boolean f1857p = false;

    /* renamed from: q */
    public boolean f1858q = false;

    /* renamed from: r */
    public boolean f1859r = false;

    /* renamed from: s */
    public Boolean f1860s = false;

    /* renamed from: ah */
    private ProgressDialog f1798ah = null;

    /* renamed from: aj */
    private int f1800aj = 1;

    /* renamed from: ak */
    private String f1801ak = null;

    /* renamed from: v */
    public boolean f1863v = true;

    /* renamed from: w */
    public String f1864w = "";

    /* renamed from: x */
    public int f1865x = 0;

    /* renamed from: aN */
    private boolean f1778aN = false;

    /* renamed from: aO */
    private boolean f1779aO = false;

    /* renamed from: aP */
    private boolean f1780aP = false;

    /* renamed from: aQ */
    private boolean f1781aQ = false;

    /* renamed from: aR */
    private BitmapDrawable f1782aR = null;

    /* renamed from: aS */
    private BitmapDrawable f1783aS = null;

    /* renamed from: aT */
    private BitmapDrawable f1784aT = null;

    /* renamed from: aU */
    private BitmapDrawable f1785aU = null;

    /* renamed from: aV */
    private BitmapDrawable f1786aV = null;

    /* renamed from: aW */
    private BitmapDrawable f1787aW = null;

    /* renamed from: aX */
    private BitmapDrawable f1788aX = null;

    /* renamed from: aY */
    private BitmapDrawable f1789aY = null;

    /* renamed from: aZ */
    private BitmapDrawable f1790aZ = null;

    /* renamed from: ba */
    private Bitmap f1829ba = null;

    /* renamed from: bb */
    private Bitmap f1830bb = null;

    /* renamed from: bc */
    private int f1831bc = 0;

    /* renamed from: C */
    Dialog f1742C = null;

    /* renamed from: D */
    ArrayList f1743D = new ArrayList();

    /* renamed from: bo */
    private final long f1843bo = 10485760;

    /* renamed from: bp */
    private final long f1844bp = 3145728;

    /* renamed from: bq */
    private boolean f1845bq = false;

    /* renamed from: F */
    public boolean f1745F = true;

    /* renamed from: bs */
    private int f1847bs = 0;

    /* renamed from: bt */
    private int f1848bt = 0;

    /* renamed from: bv */
    private boolean f1850bv = false;

    /* renamed from: bw */
    private Toast f1851bw = null;

    /* renamed from: by */
    private int f1852by = f1729bx;

    /* renamed from: bB */
    private boolean f1818bB = true;

    /* renamed from: bD */
    private boolean f1820bD = false;

    /* renamed from: bH */
    private boolean f1824bH = false;

    /* renamed from: H */
    AlertDialog f1747H = null;

    /* renamed from: I */
    LinearLayout f1748I = null;

    /* renamed from: J */
    int f1749J = 0;

    /* renamed from: K */
    int f1750K = 0;

    /* renamed from: bK */
    private int[] f1826bK = {0, 270, 180, 90};

    /* renamed from: bL */
    private InterfaceC1618f f1827bL = new C0530af(this);

    /* renamed from: L */
    View.OnClickListener f1751L = new ViewOnClickListenerC0568bh(this);

    /* renamed from: M */
    ContentObserver f1752M = new C0567bg(this, new Handler());

    /* renamed from: N */
    ContentObserver f1753N = new C0573bm(this, new Handler());

    /* renamed from: O */
    ContentObserver f1754O = new C0574bn(this, new Handler());

    /* renamed from: P */
    ContentObserver f1755P = new C0575bo(this, new Handler());

    /* renamed from: Q */
    ContentObserver f1756Q = new C0582bv(this, new Handler());

    /* renamed from: R */
    Handler f1757R = new HandlerC0581bu(this);

    /* renamed from: S */
    InterfaceC0626f f1758S = new C0580bt(this);

    /* renamed from: a */
    static /* synthetic */ int m2617a(ChatFragment chatFragment, int i) {
        int i2 = chatFragment.f1852by + i;
        chatFragment.f1852by = i2;
        return i2;
    }

    /* renamed from: a */
    static /* synthetic */ String m2622a(ChatFragment chatFragment, Object obj) {
        String str = chatFragment.f1806ap + obj;
        chatFragment.f1806ap = str;
        return str;
    }

    static {
        f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_animation_msg, R.drawable.chat_insert_icon_ams, 9));
        f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_picture, R.drawable.chat_insert_icon_pictures, 0));
        if (C1336k.m4624b(GlobalApplication.m3100a())) {
            f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_capture_picture, R.drawable.chat_insert_icon_takepicture, 1));
        }
        f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_video, R.drawable.chat_insert_icon_video, 2));
        if (C1336k.m4624b(GlobalApplication.m3100a())) {
            f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_record_video, R.drawable.chat_insert_icon_record_video, 3));
        }
        f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_reocrd_audio, R.drawable.chat_insert_icon_record_voice, 4));
        f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_contact, R.drawable.chat_insert_icon_contact, 6));
        f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_calendar, R.drawable.chat_insert_icon_calendar, 7));
        if (C0684a.m3049a()) {
            f1728bJ.add(new C0717b(GlobalApplication.m3106g(), R.string.menu_multimedia_geo_tag, R.drawable.chat_insert_icon_location, 8));
        }
    }

    /* renamed from: a */
    public boolean m2699a(View view) {
        if (this.f1821bE == null) {
            return false;
        }
        this.f1821bE.m5919a(view);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1825bI = new C0119d();
        this.f1822bF = (int) getResources().getDimension(R.dimen.chat_fragment_hearder_height);
        this.f1782aR = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.pad_chat_bg_01));
        this.f1782aR.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1783aS = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_02));
        this.f1783aS.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1784aT = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_03));
        this.f1784aT.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1785aU = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_04));
        this.f1785aU.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1786aV = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_05));
        this.f1786aV.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1787aW = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_06));
        this.f1787aW.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1788aX = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_07));
        this.f1788aX.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1789aY = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_08));
        this.f1789aY.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1790aZ = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_09));
        this.f1790aZ.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        View viewInflate = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        this.f1770aF = C1323bs.m4575a().getString("setting_change_skin", "");
        this.f1771aG = C1323bs.m4575a().getString("Default Font Size", "");
        this.f1772aH = C1323bs.m4575a().getString("setting_change_bubble_send", "");
        this.f1773aI = C1323bs.m4575a().getString("setting_change_bubble_receive", "");
        this.f1854l = (LinearLayout) viewInflate.findViewById(R.id.ldeletetop);
        this.f1855m = (LinearLayout) viewInflate.findViewById(R.id.ldeletebot);
        this.f1856n = (LinearLayout) viewInflate.findViewById(R.id.lLayoutMsgEdit);
        this.f1793ac = (LinearLayout) viewInflate.findViewById(R.id.linearemoticontop);
        this.f1748I = (LinearLayout) viewInflate.findViewById(R.id.rLayoutChatParent);
        this.f1839bk = (ScrollView) viewInflate.findViewById(R.id.scrollemoticon);
        this.f1794ad = (HeightChangedListView) viewInflate.findViewById(R.id.chat_listview);
        this.f1794ad.setOnHeightChangedListener(this.f1827bL);
        ((ChatActivity) getActivity()).m2597c();
        this.f1846br = (ImageButton) viewInflate.findViewById(R.id.previewText);
        this.f1846br.setOnClickListener(new ViewOnClickListenerC0529ae(this));
        f1726aC = (EditText) viewInflate.findViewById(R.id.editChatMsg);
        f1726aC.addTextChangedListener(new C0528ad(this));
        f1726aC.setOnEditorActionListener(new C0527ac(this));
        f1726aC.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC0526ab(this));
        f1726aC.setOnClickListener(new ViewOnClickListenerC0525aa(this));
        this.f1794ad.setOnScrollListener(new C0609z(this));
        this.f1832bd = (Button) viewInflate.findViewById(R.id.btnChatSend);
        this.f1832bd.setOnClickListener(this);
        this.f1762W = (ImageButton) viewInflate.findViewById(R.id.btnChatImage);
        this.f1762W.setOnClickListener(this);
        this.f1761V = (ImageButton) viewInflate.findViewById(R.id.btnAdd);
        this.f1761V.setOnClickListener(this);
        this.f1764Y = (Button) viewInflate.findViewById(R.id.btnDelCancel);
        this.f1764Y.setOnClickListener(this);
        this.f1763X = (Button) viewInflate.findViewById(R.id.btnDelete);
        this.f1763X.setOnClickListener(this);
        this.f1765Z = (Button) viewInflate.findViewById(R.id.btnRangeAll);
        this.f1765Z.setOnClickListener(this.f1751L);
        this.f1791aa = (Button) viewInflate.findViewById(R.id.btnRangeRcv);
        this.f1791aa.setOnClickListener(this.f1751L);
        this.f1792ab = (Button) viewInflate.findViewById(R.id.btnRangeSnt);
        this.f1792ab.setOnClickListener(this.f1751L);
        this.f1833be = (CheckBox) viewInflate.findViewById(R.id.chkEditTrans);
        this.f1835bg = (ImageView) viewInflate.findViewById(R.id.imagebackgroup);
        this.f1836bh = (ImageView) viewInflate.findViewById(R.id.imageline);
        this.f1833be.setVisibility(8);
        this.f1768aD = new C0758a(GlobalApplication.m3100a(), 1);
        this.f1837bi = (GridView) viewInflate.findViewById(R.id.emoticonGrid1);
        if (this.f1768aD.m3186b()) {
            this.f1837bi.setAdapter((ListAdapter) new C0759b(getActivity(), 0, this.f1768aD, 1));
        }
        this.f1837bi.setOnItemClickListener(this);
        this.f1838bj = (GridView) viewInflate.findViewById(R.id.emoticonGrid0);
        this.f1769aE = new C0758a(GlobalApplication.m3100a(), 2);
        this.f1838bj.setAdapter((ListAdapter) new C0759b(getActivity(), 0, this.f1769aE, 2));
        this.f1838bj.setOnItemClickListener(this);
        this.f1838bj.setOnScrollListener(new C0608y(this));
        if (this.f1837bi.getCount() != 0) {
            this.f1793ac.setVisibility(0);
            this.f1836bh.setVisibility(0);
        } else {
            this.f1793ac.setVisibility(8);
            this.f1836bh.setVisibility(8);
        }
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        C1341p.m4659c("w:" + defaultDisplay.getWidth());
        C1341p.m4659c("h:" + defaultDisplay.getHeight());
        if (defaultDisplay.getRotation() == 0 || defaultDisplay.getRotation() == 2) {
            this.f1749J = defaultDisplay.getHeight();
            this.f1750K = defaultDisplay.getWidth();
        } else {
            this.f1749J = defaultDisplay.getWidth();
            this.f1750K = defaultDisplay.getHeight();
        }
        m2688a(defaultDisplay);
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            m2686a(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else if (configuration.orientation == 1) {
            m2702b(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("address", "000");
        intent.setType("vnd.android-dir/mms-sms");
        this.f1818bB = BuddyProfileActivity.m2254a(getActivity(), intent);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f1825bI.m601a();
        this.f1795ae.m2813a();
        this.f1794ad.setAdapter((ListAdapter) null);
        this.f1795ae.changeCursor(null);
    }

    /* renamed from: a */
    public void m2688a(Display display) {
        int iM4545b = (int) (C1301ax.m4545b(display.getWidth()) / 42.6d);
        C0759b.f2582a = iM4545b;
        float count = this.f1838bj.getCount() / iM4545b;
        String strSubstring = Float.toString(count).substring(2);
        C1341p.m4659c("ch:" + ((int) ((((int) count) + 1) * 45.5d)));
        if (!"0".equals(strSubstring)) {
            this.f1838bj.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) C1301ax.m4544a((int) ((((int) count) + 1) * 45.5d))));
            C1341p.m4659c("rowcount" + (((int) count) + 1));
        } else {
            this.f1838bj.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) C1301ax.m4544a((int) (((int) count) * 45.5d))));
            C1341p.m4659c("rowcount" + ((int) count));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1816az = true;
        this.f1767aB = true;
        this.f1766aA = 0L;
        this.f1802al = new ArrayList();
        synchronized (this.f1759T) {
            this.f1803am = new HashMap();
        }
        this.f1834bf = (InputMethodManager) getActivity().getSystemService("input_method");
        this.f1797ag = C1619g.m5889a(GlobalApplication.m3100a(), (CharSequence) null, 0);
        this.f1821bE = new C1632t(this);
        this.f1823bG = C1323bs.m4575a();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.f1834bf.hideSoftInputFromWindow(f1726aC.getApplicationWindowToken(), 0);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(f1726aC.getWindowToken(), 0);
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1760U = new C0630j(getActivity().getContentResolver(), this.f1758S);
        this.f1840bl = getArguments();
        if (this.f1840bl != null && this.f1840bl.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("InBoxNO : ");
            if (this.f1840bl.containsKey("inboxNO")) {
                this.f1861t = this.f1840bl.getString("inboxNO");
                sb.append(this.f1861t);
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("ChatType : ");
            if (this.f1840bl.containsKey("chatType")) {
                this.f1866y = EnumC0665r.m3011a(this.f1840bl.getInt("chatType"));
                if (this.f1866y != null) {
                    sb.append(this.f1866y.toString());
                }
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("Participants : ");
            if (this.f1840bl.containsKey("receivers")) {
                String[] stringArray = this.f1840bl.getStringArray("receivers");
                if (this.f1866y == EnumC0665r.ONETOONE) {
                    this.f1862u = stringArray[0];
                }
                synchronized (this.f1759T) {
                    for (String str : stringArray) {
                        this.f1802al.add(str);
                        this.f1803am.put(str, new C0258f(str));
                        sb.append(str + " ");
                    }
                }
            } else {
                sb.append("Not Contained");
            }
            C1341p.m4662e(sb.toString(), getClass().getSimpleName());
            sb.append("KEY_GROUP_NAME : ");
            if (this.f1840bl.containsKey("groupnmae")) {
                this.f1741B = this.f1840bl.getString("groupnmae");
                sb.append(this.f1741B.toString());
                C1341p.m4659c("mGroupName:" + this.f1741B);
                this.f1806ap = this.f1741B;
                this.f1812av = this.f1741B;
            }
            if (this.f1861t == null) {
                this.f1760U.startQuery(8, null, C0671x.f2315a, null, "inbox_chat_type=" + EnumC0665r.BROADCAST.m3012a(), null, null);
            }
            if (this.f1840bl.containsKey("content_type")) {
                this.f1774aJ = this.f1840bl.getInt("content_type");
                this.f1840bl.remove("content_type");
                C1341p.m4659c("ChatView content_type:" + this.f1774aJ);
                this.f1779aO = true;
            }
            if (this.f1840bl.containsKey("download_uri")) {
                this.f1775aK = this.f1840bl.getString("download_uri");
                C1341p.m4659c("ChatView download_uri:" + this.f1775aK);
            }
            if (this.f1840bl.containsKey("sub_content")) {
                this.f1776aL = this.f1840bl.getString("sub_content");
                C1341p.m4659c("ChatView sub_content:" + this.f1776aL);
            }
            if (this.f1840bl.containsKey(f1735h)) {
                this.f1831bc = this.f1840bl.getInt(f1735h);
                C1341p.m4659c("misShowinput:" + this.f1831bc);
            }
            if (this.f1840bl.containsKey(f1734g)) {
                this.f1777aM = this.f1840bl.getString(f1734g);
                this.f1781aQ = this.f1840bl.getBoolean(f1736i);
                if (this.f1781aQ) {
                    this.f1806ap = this.f1777aM;
                    this.f1812av = this.f1806ap;
                    this.f1778aN = true;
                }
            }
            if (this.f1840bl.containsKey(f1737j)) {
                this.f1780aP = this.f1840bl.getBoolean(f1737j);
            }
            if (this.f1840bl.containsKey("inboxValid")) {
                this.f1816az = this.f1840bl.getBoolean("inboxValid");
                if (!this.f1816az) {
                    this.f1856n.setVisibility(8);
                }
            }
            if (this.f1840bl.containsKey("lastTempMessage")) {
                this.f1864w = this.f1840bl.getString("lastTempMessage");
            }
            this.f1800aj = this.f1840bl.getInt("showPhoneNumber", 1);
            this.f1801ak = this.f1840bl.getString("extraInfo");
            if (this.f1840bl.containsKey("groupId")) {
                this.f1819bC = this.f1840bl.getString("groupId");
            }
        }
        registerForContextMenu(this.f1794ad);
        BaseActivity.m2041a(this, true);
        this.f1853bz = getActivity().getResources().getDimensionPixelSize(R.dimen.bubble_marginTop);
        this.f1817bA = getActivity().getResources().getDimensionPixelSize(R.dimen.bubble_re_marginTop);
        this.f1795ae = new ViewOnClickListenerC0603t(getActivity(), this.f1794ad, R.layout.item_balloon_skin0, null, this.f1866y, null, this.f1763X, this.f1853bz, this.f1817bA, this.f1825bI);
        this.f1794ad.setAdapter((ListAdapter) this.f1795ae);
        this.f1795ae.m2816a(this);
        this.f1798ah = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.media_file_download);
        this.f1744E = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.setting_webview_please_wait);
        m2625a("");
        if ("file".equals(this.f1840bl.getString(C0725k.f2451b))) {
            m2673s();
            this.f1840bl.remove(C0725k.f2451b);
        }
        ((ChatActivity) getActivity()).f1715o = this.f1861t;
    }

    /* renamed from: a */
    public void m2684a() {
        if (!this.f1859r) {
            f1726aC.requestFocus();
            new Timer(true).schedule(new C0607x(this, new Handler()), 100L);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f1850bv = false;
        ChatActivity.m2590a(false);
        this.f1835bg.setImageBitmap(null);
        this.f1770aF = C1323bs.m4575a().getString("setting_change_skin", "");
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            m2686a(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else if (configuration.orientation == 1) {
            m2702b(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        if (!this.f1771aG.equals(C1323bs.m4575a().getString("Default Font Size", "")) || !this.f1772aH.equals(C1323bs.m4575a().getString("setting_change_bubble_send", "")) || !this.f1773aI.equals(C1323bs.m4575a().getString("setting_change_bubble_receive", ""))) {
            this.f1771aG = C1323bs.m4575a().getString("Default Font Size", "");
            this.f1772aH = C1323bs.m4575a().getString("setting_change_bubble_send", "");
            this.f1773aI = C1323bs.m4575a().getString("setting_change_bubble_receive", "");
            this.f1795ae = new ViewOnClickListenerC0603t(getActivity(), this.f1794ad, R.layout.item_balloon_skin0, null, this.f1866y, null, this.f1763X, this.f1853bz, this.f1817bA, this.f1825bI);
            this.f1794ad.setAdapter((ListAdapter) this.f1795ae);
            this.f1795ae.m2816a(this);
        }
        C1341p.m4658b("onResume - QUERY_INBOX", getClass().getSimpleName());
        if (TextUtils.isEmpty(this.f1861t)) {
            String str = "";
            String str2 = "";
            if (this.f1866y == EnumC0665r.ONETOONE) {
                str = (String) this.f1802al.get(0);
                str2 = "buddy_no=?";
            } else if (this.f1866y == EnumC0665r.GROUPCHAT) {
                str = this.f1819bC;
                str2 = "inbox_no = ( SELECT inbox_no FROM inbox_buddy_relation WHERE buddy_no = ? )";
            }
            if (TextUtils.isEmpty(str)) {
                this.f1760U.startQuery(1, null, C0671x.m3037a(), null, "inbox_no=?", new String[]{""}, null);
            } else {
                this.f1760U.startQuery(1, null, C0671x.m3043d(), null, str2, new String[]{str, this.f1867z, String.valueOf(this.f1866y.m3012a())}, null);
            }
        } else {
            this.f1760U.startQuery(1, null, C0671x.m3037a(), null, "inbox_no=?", new String[]{this.f1861t}, null);
        }
        PushReceiver.m3651a(this);
        getActivity().getContentResolver().registerContentObserver(C0662o.f2289a, true, this.f1753N);
        getActivity().getContentResolver().registerContentObserver(C0671x.f2315a, true, this.f1756Q);
        getActivity().getContentResolver().registerContentObserver(C0662o.m3005d(), false, this.f1754O);
        if (EnumC0665r.ONETOONE == this.f1866y) {
            this.f1820bD = C0722a.m3116a(getActivity()).m3120a(getActivity(), this);
        }
        if (this.f1820bD && !this.f1823bG.getBoolean("Motion do not ask", false) && C0722a.m3116a(getActivity()).m3118a(getActivity(), this.f1801ak, this.f1800aj) > 0) {
            m2659l();
        }
    }

    /* renamed from: l */
    private void m2659l() {
        if (C0722a.m3116a(getActivity()).m3121b(getActivity())) {
            m2662m();
        } else {
            m2664n();
        }
    }

    /* renamed from: m */
    private void m2662m() {
        if (!this.f1824bH) {
            this.f1824bH = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            FragmentActivity activity = getActivity();
            getActivity();
            View viewInflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.motion_dialog_guide_on, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img);
            TextView textView = (TextView) viewInflate.findViewById(R.id.message_1);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox);
            textView.setText(R.string.pickup_dialog_message_1);
            imageView.setBackgroundResource(R.drawable.motion_moving_zoom_p);
            this.f1746G = (AnimationDrawable) imageView.getBackground();
            builder.setView(viewInflate);
            builder.setTitle(R.string.learn_about_tilt);
            checkBox.setChecked(false);
            new Handler().postDelayed(new RunnableC0546av(this), 95L);
            checkBox.setOnCheckedChangeListener(new C0545au(this));
            checkBox.setOnClickListener(new ViewOnClickListenerC0544at(this));
            builder.setPositiveButton(R.string.done, new DialogInterfaceOnClickListenerC0543as(this));
            this.f1747H = builder.create();
            this.f1747H.show();
        }
    }

    /* renamed from: n */
    private void m2664n() {
        if (!this.f1824bH) {
            this.f1824bH = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            FragmentActivity activity = getActivity();
            getActivity();
            View viewInflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.motion_dialog_guide_off, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img);
            TextView textView = (TextView) viewInflate.findViewById(R.id.message_1);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.message_3);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox);
            textView.setText(R.string.pickup_dialog_message_1);
            imageView.setBackgroundResource(R.drawable.motion_moving_zoom_p);
            this.f1746G = (AnimationDrawable) imageView.getBackground();
            textView2.setText(R.string.pickup_dialog_message_4);
            builder.setView(viewInflate);
            builder.setTitle(R.string.learn_about_tilt);
            checkBox.setChecked(false);
            new Handler().postDelayed(new RunnableC0550az(this), 95L);
            checkBox.setOnCheckedChangeListener(new C0549ay(this));
            checkBox.setOnClickListener(new ViewOnClickListenerC0548ax(this));
            if (Build.VERSION.SDK_INT < 11) {
                builder.setPositiveButton(R.string.use_motion, new DialogInterfaceOnClickListenerC0547aw(this));
                builder.setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0562bb(this));
            } else {
                builder.setNegativeButton(R.string.use_motion, new DialogInterfaceOnClickListenerC0553ba(this));
                builder.setPositiveButton(R.string.cancel, new DialogInterfaceOnClickListenerC0563bc(this));
            }
            this.f1747H = builder.create();
            this.f1747H.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f1850bv = true;
        ChatActivity.m2590a(false);
        m2670q();
        getActivity().getContentResolver().unregisterContentObserver(this.f1753N);
        getActivity().getContentResolver().unregisterContentObserver(this.f1752M);
        getActivity().getContentResolver().unregisterContentObserver(this.f1756Q);
        getActivity().getContentResolver().unregisterContentObserver(this.f1754O);
        if (this.f1799ai != null) {
            this.f1799ai.m841a(SystemClock.elapsedRealtime() + 480000);
        }
        C0476aa.m2436a().m2441c();
        GlobalApplication.f2408b = null;
        PushReceiver.m3651a((ChatFragment) null);
        this.f1768aD.m3191g();
        if (this.f1820bD) {
            C0722a.m3116a(getActivity()).m3122b(getActivity(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m2666o() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f1760U.startUpdate(4, null, C0671x.f2315a, contentValues, "inbox_no='" + this.f1861t + "'", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public boolean m2668p() {
        if (this.f1850bv) {
            return false;
        }
        GlobalApplication.f2408b = this.f1861t;
        this.f1799ai = C0223v.m806a(this.f1861t, this.f1866y);
        if (this.f1799ai == null) {
            return false;
        }
        this.f1799ai.m848a(this.f1757R);
        this.f1799ai.m846a(this.f1867z);
        C0476aa.m2436a().m2440b();
        return true;
    }

    /* renamed from: q */
    private void m2670q() {
        if (!TextUtils.isEmpty(this.f1861t)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_last_temp_msg", f1726aC.getText().toString());
            this.f1760U.startUpdate(-1, null, C0671x.f2315a, contentValues, "inbox_no=?", new String[]{this.f1861t});
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.add(0, 1, 1, R.string.chat_view_menu_info2).setIcon(R.drawable.ic_menu_details_notification_program_info);
        menu.add(0, 2, 1, R.string.chat_view_menu_invite).setIcon(R.drawable.invite_buddy);
        menu.add(0, 5, 2, R.string.chat_view_menu_close).setIcon(R.drawable.close_chat);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem menuItemFindItem = menu.findItem(1);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(this.f1816az);
        }
        MenuItem menuItemFindItem2 = menu.findItem(2);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setEnabled(this.f1816az);
        }
        menu.removeItem(9);
        menu.removeItem(10);
        if (AbstractC0617h.m2831a(getActivity())) {
            if (this.f1866y == EnumC0665r.ONETOONE) {
                if (C0159bh.m694g() && C0159bh.m691b(this.f1801ak)) {
                    menu.add(0, 9, 4, R.string.menu_voice_call).setIcon(R.drawable.voice_chat).setEnabled(C0159bh.m689a(this.f1801ak));
                }
                if (C0159bh.m695h() && C0159bh.m692c(this.f1801ak)) {
                    menu.add(0, 10, 5, R.string.menu_video_call).setIcon(R.drawable.video_chat).setEnabled(C0159bh.m689a(this.f1801ak));
                }
            } else {
                menu.add(0, 9, 4, R.string.menu_voice_call).setIcon(R.drawable.voice_chat).setEnabled(C1323bs.m4575a().getInt("group_voice_call_max_count", 1) > 1 && C0159bh.m694g());
                menu.add(0, 10, 4, R.string.menu_video_call).setIcon(R.drawable.video_chat).setEnabled(C1323bs.m4575a().getInt("group_video_call_max_count", 1) > 1 && C0159bh.m695h());
            }
            MenuItem menuItemFindItem3 = menu.findItem(9);
            if (menuItemFindItem3 != null && menuItemFindItem3.isEnabled()) {
                menuItemFindItem3.setEnabled(this.f1816az);
            }
            MenuItem menuItemFindItem4 = menu.findItem(10);
            if (menuItemFindItem4 != null && menuItemFindItem4.isEnabled()) {
                menuItemFindItem4.setEnabled(this.f1816az);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String strSubstring;
        super.onOptionsItemSelected(menuItem);
        ChatActivity.m2590a(false);
        switch (menuItem.getItemId()) {
            case 1:
                if (this.f1816az && this.f1806ap != null) {
                    Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                    intent.putExtra("ACTIVITY_PURPOSE", 6);
                    C1341p.m4659c("namelist:" + this.f1806ap);
                    if (this.f1866y != EnumC0665r.ONETOONE) {
                        strSubstring = this.f1806ap.substring(0, this.f1806ap.length() - (Integer.toString(this.f1802al.size()).length() + 3));
                    } else {
                        strSubstring = this.f1806ap;
                    }
                    intent.putExtra(f1734g, this.f1863v);
                    intent.putExtra(f1731d, strSubstring);
                    intent.putExtra("inboxNO", this.f1861t);
                    intent.putExtra("chatType", this.f1866y.m3012a());
                    intent.putExtra(f1736i, this.f1781aQ);
                    intent.putExtra("buddyNO", this.f1862u);
                    intent.putExtra("inboxValid", this.f1816az);
                    synchronized (this.f1759T) {
                        intent.putExtra(f1730c, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]));
                    }
                    if (this.f1845bq) {
                        ((BaseActivity) getActivity()).mo2044a(intent);
                    } else {
                        startActivityForResult(intent, 17);
                    }
                }
                return true;
            case 2:
                int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                if (-3 == iM2526a || -2 == iM2526a) {
                    C1619g.m5888a(getActivity(), R.string.popup_no_network_connection, 0).show();
                } else if (this.f1816az) {
                    Uri uriM3026b = C0667t.m3026b();
                    String str = "";
                    String[] strArr = (String[]) this.f1802al.toArray(new String[this.f1802al.size()]);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (strArr.length > 0) {
                        String str2 = "buddy_no NOT IN ( ";
                        for (String str3 : strArr) {
                            stringBuffer.append(", '" + str3 + "'");
                        }
                        str = str2 + stringBuffer.toString().substring(1) + " )";
                    }
                    this.f1760U.startQuery(13, null, uriM3026b, null, str, null, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
                }
                return true;
            case 3:
            case 4:
            case 7:
            default:
                return true;
            case 5:
                f1739o = false;
                int iM2526a2 = C0502i.m2526a(GlobalApplication.m3100a());
                if (-3 == iM2526a2 || -2 == iM2526a2) {
                    C1619g.m5888a(getActivity(), R.string.popup_no_network_connection, 0).show();
                } else {
                    m2697a(this.f1861t, this.f1866y, this.f1867z, this.f1809as);
                }
                return true;
            case 6:
                if (this.f1794ad.getCount() != 0) {
                    this.f1795ae.m2826d();
                    BaseActivity.m2041a(this, false);
                    this.f1760U.startQuery(12, null, C0662o.m3003c(this.f1861t), null, null, null, null);
                } else {
                    C1619g.m5888a(getActivity(), R.string.toast_no_delete_data, 0).show();
                }
                return true;
            case 8:
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                return true;
            case 9:
            case 10:
                if (this.f1816az) {
                    if (this.f1866y == EnumC0665r.ONETOONE) {
                        if (!new C0613d(getActivity(), new C0570bj(this), new String[]{this.f1862u}, menuItem.getItemId() == 9).m2832b()) {
                            C1619g.m5889a(getActivity(), "Install Coolots app first.", 0).show();
                        }
                    } else {
                        Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                        intent2.putExtra("ACTIVITY_PURPOSE", menuItem.getItemId() == 9 ? 14 : 15);
                        intent2.putExtra("chatType", this.f1866y.m3012a());
                        intent2.putExtra("range", 3);
                        synchronized (this.f1759T) {
                            intent2.putExtra(f1730c, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]));
                        }
                        startActivity(intent2);
                    }
                }
                return true;
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        String string;
        boolean z;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        Cursor cursor = (Cursor) this.f1794ad.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        String string2 = cursor.getString(cursor.getColumnIndex("_id"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_content"));
        EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        String string4 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        if (enumC0651dM2976a != EnumC0651d.SYSTEM) {
            if (enumC0651dM2976a != EnumC0651d.TEXT || string3 != null) {
                contextMenu.clear();
                if (enumC0651dM2976a == EnumC0651d.TEXT) {
                    contextMenu.add(R.string.chat_view_menu_copy).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0569bi(this, string3));
                }
                switch (C0540ap.f1895a[enumC0651dM2976a.ordinal()]) {
                    case 1:
                        string = getString(R.string.dialog_header_text);
                        break;
                    case 2:
                        string = getString(R.string.media_photo);
                        break;
                    case 3:
                        string = getString(R.string.media_voice);
                        break;
                    case 4:
                        string = getString(R.string.media_calendar);
                        break;
                    case 5:
                        string = getString(R.string.media_contact);
                        break;
                    case 6:
                        string = getString(R.string.media_map);
                        break;
                    case 7:
                        string = getString(R.string.media_video);
                        break;
                    default:
                        string = getString(R.string.dialog_header_text);
                        break;
                }
                contextMenu.setHeaderTitle(new C0760c(getActivity().getResources(), string, (int) C1301ax.m4544a(30.0f)));
                contextMenu.add(R.string.chat_view_menu_delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0572bl(this, string2));
                if (enumC0651dM2976a == EnumC0651d.TEXT || enumC0651dM2976a == EnumC0651d.GEO) {
                    z = true;
                } else {
                    z = (TextUtils.isEmpty(string4) || C0684a.f2332c.equals(string4) || string4.contains("thumbnail") || !C1327bw.m4595a() || string3 == null) ? false : true;
                }
                if (z) {
                    contextMenu.add(R.string.chatview_menu_forward).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0571bk(this, enumC0651dM2976a, string3, string4));
                }
                if (enumC0651dM2976a == EnumC0651d.TEXT) {
                }
            }
        }
    }

    /* renamed from: a */
    public void m2697a(String str, EnumC0665r enumC0665r, String str2, String str3) {
        AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.dialog_title_msgbox_delete);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        textView.setPadding(0, 20, 8, 20);
        textView.setGravity(17);
        alertDialogBuilderC1625m.setTitle(R.string.menu_chat_close);
        alertDialogBuilderC1625m.setView(textView).setCancelable(true).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0565be(this, str2, enumC0665r, str)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0566bf(this));
        alertDialogBuilderC1625m.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m2672r() {
        C1324bt.m4585a((C1327bw.m4595a() ? GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3100a().getFilesDir().getAbsolutePath()) + "/" + this.f1861t);
        this.f1799ai.m857f();
        getActivity().finish();
    }

    /* renamed from: s */
    private void m2673s() {
        this.f1839bk.setVisibility(8);
        this.f1858q = false;
        this.f1834bf.hideSoftInputFromWindow(f1726aC.getWindowToken(), 0);
        if (this.f1849bu == null) {
            this.f1849bu = new DialogC0716a(this, null, f1728bJ);
        }
        if (!this.f1849bu.isShowing()) {
            this.f1849bu.show();
        }
    }

    /* renamed from: a */
    public void m2694a(File file) {
        C1341p.m4658b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(getActivity(), (Class<?>) ImageModify.class);
        intent.setDataAndType(Uri.fromFile(file), "image/*");
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 16);
    }

    /* renamed from: a */
    public void m2687a(Uri uri) {
        C1341p.m4658b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(getActivity(), (Class<?>) ImageModify.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 16);
    }

    /* renamed from: a */
    public void m2695a(File file, String str) {
        if (file != null) {
            String upperCase = str.toUpperCase();
            if ("MP4".equals(upperCase) || "3GP".equals(upperCase)) {
                String str2 = "." + upperCase.toUpperCase();
                if (file.length() > 10485760) {
                    C1619g.m5888a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                    return;
                }
                if (TextUtils.isEmpty(this.f1867z) || this.f1866y == EnumC0665r.BROADCAST) {
                    if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                        this.f1744E.show();
                    }
                    this.f1799ai.m838a(file, EnumC0651d.VIDEO, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), true, (String) null);
                    return;
                }
                this.f1799ai.m838a(file, EnumC0651d.VIDEO, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), false, (String) null);
                return;
            }
            C1619g.m5889a(getActivity(), getActivity().getResources().getString(R.string.toast_supported_format) + " (" + upperCase + ")", 0).show();
        }
    }

    /* renamed from: a */
    public void m2698a(String[] strArr) {
        int i = 0;
        synchronized (this.f1759T) {
            if (this.f1866y == EnumC0665r.ONETOONE) {
                while (i < strArr.length) {
                    this.f1802al.add(strArr[i]);
                    this.f1803am.put(strArr[i], new C0258f(strArr[i]));
                    i++;
                }
                Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                intent.putExtra("receivers", (String[]) this.f1802al.toArray(new String[0]));
                String string = f1726aC.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    intent.putExtra("lastTempMessage", string);
                }
                startActivity(intent);
                getActivity().finish();
            } else if (this.f1866y == EnumC0665r.BROADCAST) {
                if (!this.f1863v) {
                    this.f1802al = new ArrayList();
                    this.f1803am = new HashMap();
                    while (i < strArr.length) {
                        this.f1802al.add(strArr[i]);
                        this.f1803am.put(strArr[i], new C0258f(strArr[i]));
                        i++;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (i < strArr.length) {
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.INVITE.m3010a()), strArr[i], C0520a.m2713a(C0633m.m2883a(getActivity().getContentResolver(), strArr[i])))).append(";");
                        C0631k.m2868c(getActivity().getContentResolver(), this.f1861t, strArr[i]);
                        this.f1802al.add(strArr[i]);
                        this.f1803am.put(strArr[i], new C0258f(strArr[i]));
                        i++;
                    }
                    C0635o.m2937a(this.f1760U, 1, this.f1861t, sb.toString(), C1323bs.m4575a().getString("msisdn", ""));
                    C0634n.m2908a(this.f1760U, 4, this.f1861t, this.f1802al.size());
                }
            } else if (TextUtils.isEmpty(this.f1867z)) {
                while (i < strArr.length) {
                    this.f1802al.add(strArr[i]);
                    this.f1803am.put(strArr[i], new C0258f(strArr[i]));
                    i++;
                }
            } else {
                this.f1799ai.m834a(EnumC0651d.TEXT, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), strArr);
                if (!this.f1744E.isShowing()) {
                    this.f1744E.show();
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        File fileM4564a;
        String string;
        boolean z;
        String string2;
        boolean z2 = true;
        if (i2 == -1) {
            String strSubstring = "";
            switch (i) {
                case 0:
                    C1341p.m4658b("[SendingMedia] Start - Capture Picture", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    if (this.f1815ay.toString() != null && this.f1815ay.toString().contains("file://")) {
                        string2 = this.f1815ay.toString().substring(7);
                    } else {
                        string2 = this.f1815ay.toString();
                    }
                    m2694a(new File(string2));
                    return;
                case 1:
                    C1341p.m4658b("[SendingMedia] Start - Picture", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    } else {
                        if (intent != null && intent.getData() != null) {
                            m2687a(intent.getData());
                            return;
                        }
                        return;
                    }
                case 2:
                case 3:
                case 8:
                case 9:
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                case 19:
                default:
                    return;
                case 4:
                    this.f1859r = false;
                    this.f1831bc = 1;
                    m2698a(intent.getStringArrayExtra("receivers"));
                    return;
                case 5:
                    C1341p.m4658b("[SendingMedia] Start - Calendar", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    File file = new File(intent.getStringExtra(f1727b));
                    String stringExtra = intent.getStringExtra(f1732e);
                    StringTokenizer stringTokenizer = new StringTokenizer(intent.getStringExtra(f1727b), ".");
                    while (stringTokenizer.hasMoreTokens()) {
                        strSubstring = stringTokenizer.nextToken();
                    }
                    String str = "." + strSubstring.toUpperCase();
                    if (TextUtils.isEmpty(this.f1867z) || this.f1866y == EnumC0665r.BROADCAST) {
                        if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                            this.f1744E.show();
                        }
                        this.f1799ai.m838a(file, EnumC0651d.CALENDAR, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), true, stringExtra);
                        return;
                    }
                    this.f1799ai.m838a(file, EnumC0651d.CALENDAR, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), false, stringExtra);
                    return;
                case 6:
                    C1341p.m4658b("[SendingMedia] Start - Geo tag", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    if (intent != null && intent.getStringExtra("GEOPOINT") != null) {
                        if (TextUtils.isEmpty(this.f1867z) || this.f1866y == EnumC0665r.BROADCAST || "null".equals(this.f1867z)) {
                            if (this.f1866y != EnumC0665r.BROADCAST) {
                                this.f1744E.show();
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        synchronized (this.f1759T) {
                            this.f1799ai.m836a(this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]), z, intent.getStringExtra("GEOPOINT"));
                        }
                        return;
                    }
                    return;
                case 7:
                    C1341p.m4658b("[SendingMedia] Start - Contact", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    File file2 = new File(intent.getStringExtra(f1727b));
                    String stringExtra2 = intent.getStringExtra(f1733f);
                    C1341p.m4659c("EXTRA_VCARD:" + stringExtra2);
                    StringTokenizer stringTokenizer2 = new StringTokenizer(intent.getStringExtra(f1727b), ".");
                    while (stringTokenizer2.hasMoreTokens()) {
                        strSubstring = stringTokenizer2.nextToken();
                    }
                    String str2 = "." + strSubstring.toUpperCase();
                    if (TextUtils.isEmpty(this.f1867z) || this.f1866y == EnumC0665r.BROADCAST) {
                        if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                            this.f1744E.show();
                        }
                        this.f1799ai.m838a(file2, EnumC0651d.CONTACT, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), true, stringExtra2);
                        return;
                    }
                    this.f1799ai.m838a(file2, EnumC0651d.CONTACT, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), false, stringExtra2);
                    return;
                case 10:
                    C1341p.m4658b("[SendingMedia] Start - Record Audio", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    File file3 = new File(intent.getStringExtra(f1727b));
                    StringTokenizer stringTokenizer3 = new StringTokenizer(intent.getStringExtra(f1727b), ".");
                    while (stringTokenizer3.hasMoreTokens()) {
                        strSubstring = stringTokenizer3.nextToken();
                    }
                    String str3 = "." + strSubstring.toUpperCase();
                    if (TextUtils.isEmpty(this.f1867z) || this.f1866y == EnumC0665r.BROADCAST) {
                        if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                            this.f1744E.show();
                        }
                        this.f1799ai.m838a(file3, EnumC0651d.AUDIO, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), true, (String) null);
                        return;
                    }
                    this.f1799ai.m838a(file3, EnumC0651d.AUDIO, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), false, (String) null);
                    return;
                case 11:
                    C1341p.m4658b("[SendingMedia] Start - Video", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    if (intent != null && intent.getData() != null) {
                        Cursor cursorQuery = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
                        String string3 = "";
                        if (cursorQuery != null) {
                            while (cursorQuery.moveToNext()) {
                                int columnIndex = cursorQuery.getColumnIndex("_data");
                                if (columnIndex != -1) {
                                    string3 = cursorQuery.getString(columnIndex);
                                } else {
                                    C1619g.m5888a(getActivity(), R.string.toast_error, 0).show();
                                    return;
                                }
                            }
                        } else {
                            string3 = intent.getData().toString();
                            if (string3.contains("file://")) {
                                string3 = string3.substring(7);
                            }
                        }
                        File file4 = new File(string3);
                        StringTokenizer stringTokenizer4 = new StringTokenizer(string3, ".");
                        String strNextToken = "";
                        while (stringTokenizer4.hasMoreTokens()) {
                            strNextToken = stringTokenizer4.nextToken();
                        }
                        m2695a(file4, strNextToken);
                        return;
                    }
                    return;
                case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                    C1341p.m4658b("[SendingMedia] Start - Record Video", getClass().getSimpleName());
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    if (intent != null && intent.getData() != null) {
                        Cursor cursorQuery2 = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
                        File file5 = null;
                        String strNextToken2 = "";
                        while (cursorQuery2.moveToNext()) {
                            String string4 = cursorQuery2.getString(cursorQuery2.getColumnIndex("_data"));
                            C1341p.m4659c("MimeTypeMap:" + string4);
                            file5 = new File(string4);
                            StringTokenizer stringTokenizer5 = new StringTokenizer(string4, ".");
                            while (stringTokenizer5.hasMoreTokens()) {
                                strNextToken2 = stringTokenizer5.nextToken();
                            }
                        }
                        if (file5 != null) {
                            String str4 = "." + strNextToken2.toUpperCase();
                            if (file5.length() > 10485760) {
                                C1619g.m5889a(getActivity(), getResources().getString(R.string.record_video_dialog_limit_title_max_size_reached), 0).show();
                                return;
                            }
                            if (TextUtils.isEmpty(this.f1867z) || this.f1866y == EnumC0665r.BROADCAST) {
                                if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                                    this.f1744E.show();
                                }
                                this.f1799ai.m838a(file5, EnumC0651d.VIDEO, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), true, (String) null);
                                return;
                            }
                            this.f1799ai.m838a(file5, EnumC0651d.VIDEO, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), false, (String) null);
                            return;
                        }
                        return;
                    }
                    return;
                case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                    if (intent.getBooleanExtra("SAVE", false)) {
                        C1619g.m5888a(getActivity(), R.string.toast_save_media, 0).show();
                        return;
                    } else {
                        C1619g.m5888a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                        return;
                    }
                case 14:
                    if (intent.getBooleanExtra("SAVE", false)) {
                        C1619g.m5888a(getActivity(), R.string.toast_save_media, 0).show();
                        return;
                    } else {
                        C1619g.m5888a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                        return;
                    }
                case 15:
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    Bundle extras = intent.getExtras();
                    if (extras != null && (string = extras.getString("AMS_FILE_PATH")) != null) {
                        if (TextUtils.isEmpty(this.f1867z) || this.f1866y == EnumC0665r.BROADCAST) {
                            if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                                this.f1744E.show();
                            }
                            this.f1799ai.m838a(new File(string), EnumC0651d.IMAGE, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), true, (String) null);
                            return;
                        }
                        this.f1799ai.m838a(new File(string), EnumC0651d.IMAGE, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), false, (String) null);
                        return;
                    }
                    return;
                case 16:
                    if (this.f1799ai == null) {
                        C1619g.m5888a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    if (intent != null && intent.getExtras() != null) {
                        String string5 = intent.getExtras().getString("temp_file_path");
                        File file6 = new File(string5);
                        if (string5 != null) {
                            strSubstring = string5.substring(string5.lastIndexOf(".") + 1);
                        }
                        if (file6 != null) {
                            String upperCase = strSubstring.toUpperCase();
                            if ("JPEG".equals(upperCase) || "JPG".equals(upperCase) || "PNG".equals(upperCase)) {
                                String str5 = "." + upperCase.toUpperCase();
                                if (C1311bg.m4565a(file6)) {
                                    fileM4564a = C1311bg.m4564a(getActivity(), file6, this.f1861t, null);
                                    if (fileM4564a == null) {
                                        return;
                                    }
                                } else {
                                    fileM4564a = null;
                                }
                                if (fileM4564a == null) {
                                    fileM4564a = file6;
                                }
                                if (this.f1867z != null && this.f1866y != EnumC0665r.BROADCAST) {
                                    z2 = false;
                                } else if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                                    this.f1744E.show();
                                }
                                this.f1799ai.m838a(fileM4564a, EnumC0651d.IMAGE, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), z2, (String) null);
                                return;
                            }
                            C1619g.m5889a(getActivity(), getActivity().getResources().getString(R.string.toast_supported_format) + " (" + upperCase + ")", 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_1 /* 17 */:
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    this.f1777aM = intent.getStringExtra(f1734g);
                    this.f1781aQ = intent.getBooleanExtra(f1736i, false);
                    C1341p.m4659c("mTmpTitle:" + this.f1812av);
                    C1341p.m4659c("arrayResult:" + stringArrayExtra);
                    if (stringArrayExtra == null) {
                        C1341p.m4659c("null arrayResult");
                    } else {
                        C1341p.m4659c("Not null arrayResult");
                    }
                    if (this.f1781aQ) {
                        if (this.f1866y == EnumC0665r.GROUPCHAT) {
                            String str6 = "" + this.f1812av + " (" + (this.f1802al.size() + 1) + ")";
                        } else if (this.f1866y == EnumC0665r.BROADCAST) {
                            ((ChatActivity) getActivity()).m2598c("" + this.f1812av + " (" + this.f1802al.size() + ")");
                        } else {
                            String str7 = this.f1812av;
                        }
                        C1341p.m4659c("mTmpTitle not null!!!");
                        this.f1812av = this.f1777aM;
                        String str8 = this.f1812av;
                        this.f1806ap = this.f1812av;
                    }
                    if (stringArrayExtra != null) {
                        m2698a(stringArrayExtra);
                        return;
                    }
                    return;
                case MREvent.TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
                    getActivity().finish();
                    return;
            }
        }
        this.f1859r = false;
        this.f1831bc = 1;
        C1619g.m5888a(getActivity(), R.string.cancel, 1);
    }

    /* renamed from: b */
    public void m2701b() {
        getActivity().getContentResolver().registerContentObserver(C0654g.m2980a(this.f1861t), true, this.f1752M);
    }

    /* renamed from: c */
    public void m2704c() {
        if (this.f1779aO) {
            this.f1834bf.hideSoftInputFromWindow(f1726aC.getWindowToken(), 0);
            if (EnumC0651d.m2976a(this.f1774aJ) == EnumC0651d.TEXT || EnumC0651d.m2976a(this.f1774aJ) == EnumC0651d.GEO) {
                synchronized (this.f1759T) {
                    if (TextUtils.isEmpty(this.f1867z) || "null".equals(this.f1867z)) {
                        if (this.f1775aK.length() > 2000) {
                            C1619g.m5888a(GlobalApplication.m3100a(), R.string.toast_text_max_Length, 0).show();
                            return;
                        }
                        if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                            this.f1744E.show();
                        }
                        this.f1799ai.m839a(this.f1861t, EnumC0651d.m2976a(this.f1774aJ), this.f1866y, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]), this.f1775aK);
                    } else {
                        this.f1799ai.m832a(EnumC0651d.m2976a(this.f1774aJ), this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]), this.f1775aK);
                    }
                    return;
                }
            }
            if (!C1327bw.m4595a()) {
                C1341p.m4651a("[sendForward()] No sdcard", f1725a);
                return;
            }
            C1341p.m4658b("Forward download_uri:" + this.f1775aK, f1725a);
            C1341p.m4658b("Forward content:" + this.f1776aL, f1725a);
            StringTokenizer stringTokenizer = new StringTokenizer(this.f1775aK, ".");
            String strNextToken = "";
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            String upperCase = strNextToken.toUpperCase();
            File file = new File(URI.create(this.f1775aK));
            if (EnumC0651d.m2976a(this.f1774aJ) == EnumC0651d.VIDEO) {
                if (!"MP4".equals(upperCase) && !"3GP".equals(upperCase)) {
                    C1619g.m5889a(getActivity(), getActivity().getResources().getString(R.string.toast_supported_format) + " (" + upperCase + ")", 0).show();
                    return;
                } else if (file.length() > 10485760) {
                    C1619g.m5888a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                    return;
                }
            } else if (EnumC0651d.m2976a(this.f1774aJ) == EnumC0651d.AUDIO) {
                if (!"MP3".equals(upperCase) && !"3GP".equals(upperCase) && !"AAC".equals(upperCase) && !"AMR".equals(upperCase) && !"AMR-NB".equals(upperCase)) {
                    C1619g.m5889a(getActivity(), getActivity().getResources().getString(R.string.toast_supported_format) + " (" + upperCase + ")", 0).show();
                    return;
                } else if (file.length() > 3145728) {
                    C1619g.m5888a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                    return;
                }
            }
            boolean z = TextUtils.isEmpty(this.f1867z) || "null".equals(this.f1867z);
            String str = "." + upperCase;
            String[] strArrSplit = this.f1776aL != null ? this.f1776aL.split("\n") : null;
            if (strArrSplit != null && strArrSplit.length > 4) {
                String strM4581a = C1324bt.m4581a(this.f1775aK, GlobalApplication.m3105f().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f1861t, file.getName());
                Long lValueOf = Long.valueOf(C1325bu.m4591a());
                C0635o.m2943b(GlobalApplication.m3100a().getContentResolver(), String.valueOf(lValueOf), this.f1861t, EnumC0651d.m2976a(this.f1774aJ), strM4581a, this.f1802al.size());
                C0635o.m2924a(GlobalApplication.m3100a().getContentResolver(), lValueOf, true);
                if (EnumC0651d.m2976a(this.f1774aJ) == EnumC0651d.CONTACT || EnumC0651d.m2976a(this.f1774aJ) == EnumC0651d.CALENDAR) {
                    C0635o.m2935a(GlobalApplication.m3100a().getContentResolver(), this.f1861t, lValueOf, strArrSplit[5]);
                }
                if (z && this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                    this.f1744E.show();
                }
                this.f1799ai.m828a(lValueOf.longValue(), this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]), z, strArrSplit.length > 5 ? strArrSplit[5] : null, file, str, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], EnumC0651d.m2976a(this.f1774aJ));
                return;
            }
            if (EnumC0651d.m2976a(this.f1774aJ) == EnumC0651d.IMAGE && !C1165c.m4207c(file.getPath())) {
                m2694a(file);
                return;
            }
            if (z && this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                this.f1744E.show();
            }
            this.f1799ai.m838a(file, EnumC0651d.m2976a(this.f1774aJ), this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[0]), z, this.f1776aL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap mapM2821b;
        HashMap mapM2824c;
        boolean z;
        HashMap mapM2824c2;
        boolean z2 = true;
        switch (view.getId()) {
            case R.id.btnAdd /* 2131427622 */:
                int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                if (-3 == iM2526a || -2 == iM2526a) {
                    this.f1797ag.setText(R.string.popup_no_network_connection);
                    this.f1797ag.setDuration(0);
                    this.f1797ag.show();
                    break;
                } else if (this.f1802al.size() == 0) {
                    if (this.f1851bw == null) {
                        this.f1851bw = C1619g.m5888a(getActivity(), R.string.chat_title_no_buddies, 0);
                    }
                    this.f1851bw.show();
                    break;
                } else {
                    m2673s();
                    break;
                }
                break;
            case R.id.btnChatImage /* 2131427623 */:
                if (!this.f1858q) {
                    this.f1839bk.setVisibility(0);
                    this.f1858q = true;
                } else {
                    this.f1839bk.setVisibility(8);
                    this.f1858q = false;
                }
                ChatActivity.m2590a(false);
                break;
            case R.id.btnChatSend /* 2131427625 */:
                m2707i();
                break;
            case R.id.btnDelete /* 2131427627 */:
                Boolean bool = false;
                if (this.f1795ae.m2827e() == EnumC0542ar.SELECT_ALL || this.f1795ae.m2827e() == EnumC0542ar.SELECT_PART || this.f1795ae.m2829g() == EnumC0542ar.SELECT_ALL || this.f1795ae.m2829g() == EnumC0542ar.SELECT_PART || this.f1795ae.m2828f() == EnumC0542ar.SELECT_ALL || this.f1795ae.m2828f() == EnumC0542ar.SELECT_PART) {
                    bool = true;
                } else {
                    HashMap mapM2821b2 = this.f1795ae.m2821b();
                    if (mapM2821b2 != null && !mapM2821b2.isEmpty()) {
                        Iterator it = mapM2821b2.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                                    bool = true;
                                }
                            }
                        }
                    }
                    if (!bool.booleanValue() && (mapM2824c2 = this.f1795ae.m2824c()) != null && !mapM2824c2.isEmpty()) {
                        Iterator it2 = mapM2824c2.entrySet().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (((Boolean) ((Map.Entry) it2.next()).getValue()).booleanValue()) {
                                    bool = true;
                                }
                            }
                        }
                    }
                }
                if (bool.booleanValue()) {
                    if (this.f1795ae.m2827e() == EnumC0542ar.SELECT_ALL) {
                        this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND message_type != ? AND message_type != ?", new String[]{this.f1861t, Integer.toString(0), Integer.toString(3)});
                    } else if (this.f1795ae.m2829g() == EnumC0542ar.SELECT_ALL) {
                        this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND message_sender != ? AND message_type != ?", new String[]{this.f1861t, C1323bs.m4575a().getString("msisdn", ""), Integer.toString(3)});
                    } else if (this.f1795ae.m2828f() == EnumC0542ar.SELECT_ALL) {
                        this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND message_sender = ? AND message_type != ?", new String[]{this.f1861t, C1323bs.m4575a().getString("msisdn", ""), Integer.toString(0)});
                    } else if (this.f1795ae.m2827e() == EnumC0542ar.SELECT_PART || this.f1795ae.m2829g() == EnumC0542ar.SELECT_PART || this.f1795ae.m2828f() == EnumC0542ar.SELECT_PART) {
                        if ((this.f1795ae.m2827e() == EnumC0542ar.SELECT_PART || this.f1795ae.m2828f() == EnumC0542ar.SELECT_PART) && (mapM2821b = this.f1795ae.m2821b()) != null && !mapM2821b.isEmpty()) {
                            StringBuilder sb = new StringBuilder();
                            for (Map.Entry entry : mapM2821b.entrySet()) {
                                if (!((Boolean) entry.getValue()).booleanValue()) {
                                    sb.append(((Long) entry.getKey()).toString()).append(",");
                                }
                            }
                            if (sb.length() > 0) {
                                sb.setLength(sb.length() - 1);
                                this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND _id NOT IN (" + sb.toString() + ") AND message_type != ? AND message_type != ?", new String[]{this.f1861t, Integer.toString(0), Integer.toString(3)});
                            } else {
                                this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND message_sender = ? AND message_type != ? AND message_type != ?", new String[]{this.f1861t, C1323bs.m4575a().getString("msisdn", ""), Integer.toString(0), Integer.toString(3)});
                            }
                        }
                        if ((this.f1795ae.m2827e() == EnumC0542ar.SELECT_PART || this.f1795ae.m2829g() == EnumC0542ar.SELECT_PART) && (mapM2824c = this.f1795ae.m2824c()) != null && !mapM2824c.isEmpty()) {
                            StringBuilder sb2 = new StringBuilder();
                            for (Map.Entry entry2 : mapM2824c.entrySet()) {
                                if (!((Boolean) entry2.getValue()).booleanValue()) {
                                    sb2.append(((Long) entry2.getKey()).toString()).append(",");
                                }
                            }
                            if (sb2.length() > 0) {
                                sb2.setLength(sb2.length() - 1);
                                this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND message_sever_id NOT IN (" + sb2.toString() + ") AND message_type != ? AND message_type != ?", new String[]{this.f1861t, Integer.toString(0), Integer.toString(3)});
                            } else {
                                this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND message_sender != ? AND message_type != ? AND message_type != ?", new String[]{this.f1861t, C1323bs.m4575a().getString("msisdn", ""), Integer.toString(0), Integer.toString(3)});
                            }
                        }
                    } else {
                        HashMap mapM2821b3 = this.f1795ae.m2821b();
                        if (mapM2821b3 == null || mapM2821b3.isEmpty()) {
                            z = true;
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            for (Map.Entry entry3 : mapM2821b3.entrySet()) {
                                if (((Boolean) entry3.getValue()).booleanValue()) {
                                    sb3.append(((Long) entry3.getKey()).toString()).append(",");
                                }
                            }
                            if (sb3.length() > 0) {
                                sb3.setLength(sb3.length() - 1);
                                this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND _id IN (" + sb3.toString() + ") AND message_type != ?", new String[]{this.f1861t, Integer.toString(0)});
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        HashMap mapM2824c3 = this.f1795ae.m2824c();
                        if (mapM2824c3 != null && !mapM2824c3.isEmpty()) {
                            StringBuilder sb4 = new StringBuilder();
                            for (Map.Entry entry4 : mapM2824c3.entrySet()) {
                                if (((Boolean) entry4.getValue()).booleanValue()) {
                                    sb4.append(((Long) entry4.getKey()).toString()).append(",");
                                }
                            }
                            if (sb4.length() > 0) {
                                sb4.setLength(sb4.length() - 1);
                                this.f1760U.startDelete(3, null, C0662o.f2289a, "message_inbox_no = ? AND message_sever_id IN (" + sb4.toString() + ") AND message_type != ?", new String[]{this.f1861t, Integer.toString(3)});
                            } else {
                                z2 = false;
                            }
                        }
                        if (!z && !z2) {
                            C1619g.m5888a(getActivity(), R.string.toast_no_delete_data, 0).show();
                        }
                    }
                    this.f1794ad.clearChoices();
                } else {
                    C1619g.m5888a(getActivity(), R.string.toast_no_delete_data, 0).show();
                }
                this.f1795ae.m2826d();
                this.f1795ae.m2817a(EnumC0542ar.SELECT_NONE);
                this.f1795ae.m2823b(EnumC0542ar.SELECT_NONE);
                this.f1795ae.m2825c(EnumC0542ar.SELECT_NONE);
                break;
            case R.id.btnDelCancel /* 2131427628 */:
                this.f1794ad.setChoiceMode(0);
                BaseActivity.m2041a(this, true);
                this.f1794ad.clearChoices();
                this.f1854l.setVisibility(8);
                this.f1855m.setVisibility(8);
                if (this.f1816az) {
                    this.f1856n.setVisibility(0);
                }
                this.f1795ae.m2826d();
                this.f1795ae.m2817a(EnumC0542ar.SELECT_NONE);
                this.f1795ae.m2823b(EnumC0542ar.SELECT_NONE);
                this.f1795ae.m2825c(EnumC0542ar.SELECT_NONE);
                break;
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0532ah
    /* renamed from: a */
    public void mo2693a(View view, String str, String str2) {
    }

    @Override // com.sec.chaton.chat.InterfaceC0532ah
    /* renamed from: a */
    public void mo2691a(View view, long j, boolean z) {
        CharSequence[] charSequenceArr;
        if (this.f1816az) {
            if (this.f1802al.size() == 0) {
                if (this.f1851bw == null) {
                    this.f1851bw = C1619g.m5888a(getActivity(), R.string.chat_title_no_buddies, 0);
                }
                this.f1851bw.show();
                return;
            }
            int positionForView = this.f1794ad.getPositionForView(view);
            Cursor cursor = this.f1795ae.getCursor();
            cursor.moveToPosition(positionForView);
            if (z && this.f1800aj != 1 && this.f1818bB) {
                charSequenceArr = new CharSequence[]{GlobalApplication.m3106g().getString(R.string.chat_send_sms), GlobalApplication.m3106g().getString(R.string.view_resend), GlobalApplication.m3106g().getString(R.string.menu_chat_delete)};
            } else {
                charSequenceArr = new CharSequence[]{GlobalApplication.m3106g().getString(R.string.view_resend), GlobalApplication.m3106g().getString(R.string.menu_chat_delete)};
            }
            String strM2683a = m2683a(cursor);
            AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
            alertDialogBuilderC1625m.setTitle(strM2683a);
            alertDialogBuilderC1625m.setItems(charSequenceArr, new DialogInterfaceOnClickListenerC0579bs(this, view, j, z));
            alertDialogBuilderC1625m.setCancelable(true);
            alertDialogBuilderC1625m.show();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0532ah
    /* renamed from: b */
    public void mo2703b(View view) {
        if (!C1346u.m4676a() && view != null && view.getParent() != null) {
            int positionForView = this.f1794ad.getPositionForView(view);
            Cursor cursor = this.f1795ae.getCursor();
            cursor.moveToPosition(positionForView);
            EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            int i = cursor.getInt(cursor.getColumnIndex("message_stored_ext"));
            C1341p.m4658b("[onItemClickListener] view:" + view + " v.getTag():" + view.getTag(), getClass().getName());
            if (enumC0651dM2976a == EnumC0651d.TEXT || enumC0651dM2976a == EnumC0651d.SYSTEM) {
                this.f1834bf.hideSoftInputFromWindow(f1726aC.getWindowToken(), 0);
                return;
            }
            View view2 = (View) view.getTag();
            if (view.getId() == R.id.imageSndContent) {
                C1341p.m4659c("file uri:" + string2);
                if (enumC0651dM2976a == EnumC0651d.VIDEO) {
                    if (!C1336k.m4631h() || !C1336k.m4632i()) {
                        C1619g.m5888a(getActivity(), R.string.chatroom_unable_to_record_during_call, 0).show();
                        return;
                    } else {
                        ViewOnClickListenerC0603t.m2788a(this, enumC0651dM2976a, string3, this.f1798ah);
                        return;
                    }
                }
                if (enumC0651dM2976a == EnumC0651d.IMAGE) {
                    if (string3 != null && string3.contains("thumbnail")) {
                        if (C1327bw.m4595a()) {
                            string3 = string3.replace("thumbnail/", "");
                        } else {
                            C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                            return;
                        }
                    }
                    ViewOnClickListenerC0603t.m2788a(this, enumC0651dM2976a, string3, this.f1798ah);
                    return;
                }
                getActivity().startActivity(new Intent("android.intent.action.VIEW"));
                return;
            }
            if (view.getId() == R.id.imageRcvContent || view.getId() == R.id.download_completed) {
                if (string3 == null || string3.length() == 0 || ((i == 0 && string3.contains("thumbnail")) || ((i == 1 && string3.contains("thumbnail")) || C0684a.f2332c.equals(string3) || (i == 0 && C1327bw.m4595a())))) {
                    if (enumC0651dM2976a == EnumC0651d.VIDEO && !C1327bw.m4595a()) {
                        C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    } else {
                        if (!C0473j.m2410a().m2412a(j)) {
                            C0473j.m2410a().m2411a(view2, this, this.f1757R, positionForView, string2, false, string, j, enumC0651dM2976a, this.f1866y, string4);
                            return;
                        }
                        return;
                    }
                }
                if (enumC0651dM2976a == EnumC0651d.VIDEO && (!C1336k.m4631h() || !C1336k.m4632i())) {
                    C1619g.m5888a(getActivity(), R.string.chatroom_unable_to_record_during_call, 0).show();
                    return;
                } else {
                    ViewOnClickListenerC0603t.m2788a(this, enumC0651dM2976a, string3, this.f1798ah);
                    return;
                }
            }
            if (view.getId() == R.id.imageEtcSndContent || view.getId() == R.id.lLayoutSndContent) {
                if (enumC0651dM2976a == EnumC0651d.CALENDAR) {
                    if (!C1327bw.m4595a()) {
                        C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    } else {
                        if (string3 != null) {
                            Intent intent = new Intent(getActivity(), (Class<?>) VCalendarDetailActivity2.class);
                            intent.putExtra("ACTIVITY_PURPOSE", 3);
                            intent.putExtra("URI", string3);
                            getActivity().startActivity(intent);
                            return;
                        }
                        return;
                    }
                }
                if (enumC0651dM2976a == EnumC0651d.CONTACT) {
                    if (!C1327bw.m4595a()) {
                        C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    } else {
                        ViewOnClickListenerC0603t.m2788a(this, enumC0651dM2976a, string3, this.f1798ah);
                        return;
                    }
                }
                if (enumC0651dM2976a == EnumC0651d.GEO) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string2.toString(), "\n");
                    String strNextToken = null;
                    while (stringTokenizer.hasMoreTokens()) {
                        strNextToken = stringTokenizer.nextToken();
                    }
                    Intent intent2 = new Intent(getActivity(), (Class<?>) GeotagActivity.class);
                    intent2.putExtra("Geo Point", strNextToken);
                    getActivity().startActivity(intent2);
                    return;
                }
                if (enumC0651dM2976a == EnumC0651d.AUDIO) {
                    if (!C1327bw.m4595a()) {
                        C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    } else {
                        ViewOnClickListenerC0603t.m2788a(this, enumC0651dM2976a, string3, this.f1798ah);
                        return;
                    }
                }
                return;
            }
            if (view.getId() == R.id.imageEtcContent || view.getId() == R.id.lLayoutRcvContent || view.getId() == R.id.download_completed) {
                if (string3 == null || string3.length() == 0 || C0684a.f2332c.equals(string3)) {
                    if (enumC0651dM2976a == EnumC0651d.GEO) {
                        if (!C0684a.m3049a()) {
                            C1619g.m5888a(getActivity(), R.string.toast_googleMAP_unavailable, 0).show();
                            return;
                        }
                        StringTokenizer stringTokenizer2 = new StringTokenizer(string2.toString(), "\n");
                        String strNextToken2 = null;
                        while (stringTokenizer2.hasMoreTokens()) {
                            strNextToken2 = stringTokenizer2.nextToken();
                        }
                        Intent intent3 = new Intent(getActivity(), (Class<?>) GeotagActivity.class);
                        intent3.putExtra("Geo Point", strNextToken2);
                        getActivity().startActivity(intent3);
                        return;
                    }
                    if (!C1327bw.m4595a()) {
                        C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    } else {
                        if (!C0473j.m2410a().m2412a(j)) {
                            C0473j.m2410a().m2411a(view2, this, this.f1757R, positionForView, string2, false, string, j, enumC0651dM2976a, this.f1866y, string4);
                            return;
                        }
                        return;
                    }
                }
                if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                    return;
                } else {
                    ViewOnClickListenerC0603t.m2788a(this, enumC0651dM2976a, string3, this.f1798ah);
                    return;
                }
            }
            this.f1834bf.hideSoftInputFromWindow(f1726aC.getWindowToken(), 0);
        }
    }

    /* renamed from: a */
    public void m2696a(String str, int i, String str2, String str3, EnumC0665r enumC0665r) {
        if (enumC0665r == EnumC0665r.BROADCAST || str3 == null || "null".equals(str3)) {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            C0223v c0223vM806a = C0223v.m806a(strValueOf, enumC0665r);
            if (c0223vM806a != null) {
                c0223vM806a.m848a(this.f1757R);
                c0223vM806a.m851a(strValueOf, str, i);
                c0223vM806a.m847a(true);
                c0223vM806a.m854c(this.f1861t);
                this.f1799ai.m841a(Long.MAX_VALUE);
                c0223vM806a.m849a(EnumC0665r.BROADCAST, str2, this.f1804an, "", this.f1861t, this.f1766aA);
                return;
            }
            return;
        }
        this.f1799ai.m857f();
        this.f1799ai.m851a(this.f1861t, str, i);
        this.f1799ai.m850a(enumC0665r, str2, this.f1804an, str3, this.f1861t, this.f1766aA, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2626a(String str, EnumC0651d enumC0651d) {
        if (this.f1866y == EnumC0665r.ONETOONE) {
            Cursor cursorM2887b = C0633m.m2887b(GlobalApplication.m3100a().getContentResolver(), this.f1862u);
            if (cursorM2887b != null && cursorM2887b.getCount() > 0) {
                cursorM2887b.moveToFirst();
                if (!cursorM2887b.getString(cursorM2887b.getColumnIndex("buddy_show_phone_number")).equals("Y")) {
                    String string = cursorM2887b.getString(cursorM2887b.getColumnIndex("buddy_orginal_number"));
                    String string2 = cursorM2887b.getString(cursorM2887b.getColumnIndex("buddy_no"));
                    if (TextUtils.isEmpty(string)) {
                        string = string2;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (enumC0651d == EnumC0651d.TEXT) {
                        intent.putExtra("sms_body", str);
                    }
                    C1341p.m4659c("number:" + string);
                    intent.putExtra("sms_body", str);
                    intent.putExtra("address", string);
                    intent.setType("vnd.android-dir/mms-sms");
                    startActivity(intent);
                }
            }
            if (cursorM2887b != null) {
                cursorM2887b.close();
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0532ah
    /* renamed from: a */
    public void mo2690a(View view, long j, EnumC0651d enumC0651d) {
        C0468e.m2389a().m2393b(j);
    }

    @Override // com.sec.chaton.chat.InterfaceC0532ah
    /* renamed from: a */
    public void mo2689a(View view, long j) {
        C0473j.m2410a().m2415c(j);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
    }

    @Override // com.sec.chaton.chat.InterfaceC0532ah
    /* renamed from: a */
    public void mo2692a(View view, ProfileImageView profileImageView, String str, String str2) {
        Intent intent = new Intent(getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", str);
        intent.putExtra("PROFILE_BUDDY_NAME", str2);
        intent.setFlags(67108864);
        startActivityForResult(intent, 20);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.chaton.p031h.InterfaceC0720e
    /* renamed from: a */
    public boolean mo2700a(Object obj, int i) {
        ChatActivity.m2590a(false);
        switch (i) {
            case 0:
                if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent = new Intent("android.intent.action.PICK");
                    intent.setType("image/*");
                    if (!BuddyProfileActivity.m2254a(getActivity(), intent)) {
                        intent = new Intent();
                        intent.setAction("android.intent.action.GET_CONTENT");
                        intent.setType("image/*");
                    }
                    startActivityForResult(intent, 1);
                    this.f1857p = true;
                }
                return false;
            case 1:
                if (!C1336k.m4631h() || !C1336k.m4632i()) {
                    C1619g.m5888a(getActivity(), R.string.recordvideo_unable_to_record_during_call, 0).show();
                } else if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                    this.f1815ay = null;
                    this.f1815ay = Uri.fromFile(new File(C1327bw.m4595a() ? GlobalApplication.m3100a().getExternalCacheDir() : GlobalApplication.m3100a().getCacheDir(), "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));
                    intent2.putExtra("output", this.f1815ay);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 0);
                    this.f1857p = true;
                }
                return false;
            case 2:
                if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
                    intent3.setType("video/*");
                    startActivityForResult(Intent.createChooser(intent3, getActivity().getResources().getString(R.string.dialog_select_video)), 11);
                }
                return false;
            case 3:
                if (!C1336k.m4631h() || !C1336k.m4632i()) {
                    C1619g.m5888a(getActivity(), R.string.recordvideo_unable_to_record_during_call, 0).show();
                } else if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent4 = new Intent("android.media.action.VIDEO_CAPTURE");
                    intent4.putExtra("android.intent.extra.videoQuality", 1);
                    intent4.putExtra("return-data", true);
                    intent4.putExtra("android.intent.extra.sizeLimit", 9961472L);
                    intent4.putExtra("video-size", "720x480");
                    startActivityForResult(intent4, 12);
                }
                return false;
            case 4:
                if (!C1336k.m4631h() || !C1336k.m4632i()) {
                    C1619g.m5888a(getActivity(), R.string.recordaudio_unable_to_record_during_call, 0).show();
                } else if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent5 = new Intent(getActivity(), (Class<?>) RecordAudio.class);
                    intent5.putExtra("inbox_NO", this.f1861t);
                    startActivityForResult(intent5, 10);
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent6 = new Intent(getActivity(), (Class<?>) VCardReadContactActivity.class);
                    intent6.putExtra("inbox_NO", this.f1861t);
                    startActivityForResult(intent6, 7);
                    this.f1857p = true;
                }
                return false;
            case 7:
                if (!C1327bw.m4595a()) {
                    C1619g.m5888a(getActivity(), R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent7 = new Intent(getActivity(), (Class<?>) VCalendarListActivity2.class);
                    intent7.putExtra("inbox_NO", this.f1861t);
                    startActivityForResult(intent7, 5);
                    this.f1857p = true;
                }
                return false;
            case 8:
                Intent intent8 = new Intent(getActivity(), (Class<?>) GeotagActivity.class);
                intent8.putExtra("current only", false);
                startActivityForResult(intent8, 6);
                return false;
            case 9:
                startActivityForResult(new Intent(getActivity(), (Class<?>) AMSFileListActivity.class), 15);
                return false;
        }
    }

    /* renamed from: a */
    public void m2686a(int i, int i2) {
        this.f1835bg.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        if ("skin_bg_02".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1783aS);
            return;
        }
        if ("pad_chat_bg_01".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1782aR);
            return;
        }
        if ("skin_bg_04".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1785aU);
            return;
        }
        if ("skin_bg_05".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1786aV);
            return;
        }
        if ("skin_bg_06".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1787aW);
            return;
        }
        if ("skin_bg_03".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1784aT);
            return;
        }
        if ("skin_bg_07".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1788aX);
            return;
        }
        if ("skin_bg_08".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1789aY);
            return;
        }
        if ("skin_bg_09".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1790aZ);
            return;
        }
        if ("skin_myskin.png_".equals(this.f1770aF)) {
            if (this.f1830bb == null) {
                this.f1830bb = C1294aq.m4496a(getActivity(), i, i2, (int) C1301ax.m4544a(59.0f));
            }
            if (this.f1830bb == null) {
                this.f1835bg.setBackgroundDrawable(this.f1782aR);
                return;
            } else {
                this.f1835bg.setImageBitmap(this.f1830bb);
                return;
            }
        }
        this.f1835bg.setBackgroundDrawable(this.f1782aR);
    }

    /* renamed from: b */
    public void m2702b(int i, int i2) {
        this.f1835bg.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        if ("skin_bg_02".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1783aS);
            return;
        }
        if ("pad_chat_bg_01".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1782aR);
            return;
        }
        if ("skin_bg_04".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1785aU);
            return;
        }
        if ("skin_bg_05".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1786aV);
            return;
        }
        if ("skin_bg_06".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1787aW);
            return;
        }
        if ("skin_bg_03".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1784aT);
            return;
        }
        if ("skin_bg_07".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1788aX);
            return;
        }
        if ("skin_bg_08".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1789aY);
            return;
        }
        if ("skin_bg_09".equals(this.f1770aF)) {
            this.f1835bg.setBackgroundDrawable(this.f1790aZ);
            return;
        }
        if ("skin_myskin.png_".equals(this.f1770aF)) {
            if (this.f1829ba == null) {
                this.f1829ba = C1294aq.m4510b(getActivity(), i, i2, (int) C1301ax.m4544a(59.0f));
            }
            if (this.f1829ba == null) {
                this.f1835bg.setBackgroundDrawable(this.f1782aR);
                return;
            } else {
                this.f1835bg.setImageBitmap(this.f1829ba);
                return;
            }
        }
        this.f1835bg.setBackgroundDrawable(this.f1782aR);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f1866y == EnumC0665r.BROADCAST) {
            ((ChatActivity) getActivity()).m2598c(this.f1806ap);
        }
        super.onConfigurationChanged(configuration);
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        C1341p.m4659c("root w:" + this.f1835bg.getWidth());
        C1341p.m4659c("root h:" + this.f1835bg.getHeight());
        if (configuration.orientation == 2) {
            m2686a(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else if (configuration.orientation == 1) {
            m2702b(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        new Timer(true).schedule(new C0578br(this, new Handler()), 300L);
    }

    @Override // com.sec.chaton.chat.InterfaceC0531ag
    /* renamed from: d */
    public boolean mo2202d() {
        if (this.f1794ad.getChoiceMode() == 2) {
            this.f1794ad.setChoiceMode(0);
            BaseActivity.m2041a(this, true);
            this.f1794ad.clearChoices();
            this.f1854l.setVisibility(8);
            this.f1855m.setVisibility(8);
            if (!this.f1816az) {
                return false;
            }
            this.f1856n.setVisibility(0);
            return false;
        }
        if (!this.f1858q) {
            return true;
        }
        this.f1839bk.setVisibility(8);
        this.f1858q = false;
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0760c c0760c = null;
        if (adapterView.getId() == R.id.emoticonGrid0) {
            C1341p.m4659c("editText.getText().length()+usageManagerbottom.getitem().get((int) id).mKey.length():" + (((C0762e) this.f1769aE.m3184a().get((int) j)).f2595a.length() + f1726aC.getText().length()));
            C0760c c0760c2 = new C0760c(getActivity().getResources(), ((C0762e) this.f1769aE.m3184a().get((int) j)).f2595a, (int) (f1726aC.getLineHeight() * 1.2f));
            this.f1768aD.m3185a(((C0762e) this.f1769aE.m3184a().get((int) j)).f2595a, ((C0762e) this.f1769aE.m3184a().get((int) j)).f2596b, (int) j);
            c0760c = c0760c2;
        } else if (adapterView.getId() == R.id.emoticonGrid1) {
            C1341p.m4659c("editText.getText().length()+usageManager.getitem().get((int) id).mKey.length():" + f1726aC.getText().length() + ((C0762e) this.f1768aD.m3184a().get((int) j)).f2595a.length());
            c0760c = new C0760c(getActivity().getResources(), ((C0762e) this.f1768aD.m3184a().get((int) j)).f2595a, (int) (f1726aC.getLineHeight() * 1.2f));
        }
        if (c0760c != null) {
            c0760c.m3202a(f1726aC);
        }
        Collections.sort(this.f1768aD.m3188d().m3203a());
        this.f1837bi.setAdapter((ListAdapter) new C0759b(getActivity(), 0, this.f1768aD, 1));
        this.f1793ac.setVisibility(0);
        this.f1836bh.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        C1341p.m4659c("onContextItemSelected!!!!");
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f1834bf != null && f1726aC != null) {
            this.f1834bf.hideSoftInputFromWindow(f1726aC.getApplicationWindowToken(), 0);
        }
        if (this.f1799ai != null) {
            this.f1799ai.m853b(this.f1757R);
        }
        super.onDestroy();
    }

    /* renamed from: a */
    public AlertDialogBuilderC1625m m2682a(EnumC0255c enumC0255c) {
        this.f1842bn = new AlertDialogBuilderC1625m(getActivity());
        if (enumC0255c == EnumC0255c.END_APP) {
            this.f1842bn.setMessage(R.string.provision_error_end).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0577bq(this));
            return this.f1842bn;
        }
        if (enumC0255c == EnumC0255c.RESTART_APP) {
            this.f1842bn.setMessage(R.string.auth_error_restart).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0576bp(this));
            return this.f1842bn;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2625a(String str) {
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_msg_box);
        if (fragmentFindFragmentById instanceof MsgboxFragment) {
            ((MsgboxFragment) fragmentFindFragmentById).m3175a(this.f1861t);
        }
    }

    /* renamed from: a */
    public void m2685a(int i) {
        this.f1847bs += i;
        this.f1852by += i;
        this.f1760U.startQuery(0, null, C0662o.m2995a(this.f1852by), null, "message_inbox_no=?", new String[]{this.f1861t}, null);
        this.f1846br.setVisibility(0);
    }

    /* renamed from: e */
    public void m2705e() {
        if (this.f1794ad != null) {
            this.f1794ad.setTranscriptMode(2);
            this.f1745F = true;
        }
        this.f1846br.setVisibility(4);
    }

    /* renamed from: a */
    public String m2683a(Cursor cursor) {
        switch (C0540ap.f1895a[EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type"))).ordinal()]) {
            case 1:
                return getString(R.string.dialog_header_text);
            case 2:
                return getString(R.string.media_photo);
            case 3:
                return getString(R.string.media_voice);
            case 4:
                return getString(R.string.media_calendar);
            case 5:
                return getString(R.string.media_contact);
            case 6:
                return getString(R.string.media_map);
            case 7:
                return getString(R.string.media_video);
            default:
                return "";
        }
    }

    @Override // com.sec.chaton.p032i.InterfaceC0723b
    /* renamed from: f */
    public void mo2293f() {
        Uri uri;
        C1341p.m4658b("onDirectCall", getClass().getSimpleName());
        if (C0722a.m3116a(getActivity()).m3121b(getActivity())) {
            Cursor cursorM2887b = C0633m.m2887b(GlobalApplication.m3100a().getContentResolver(), this.f1862u);
            if (cursorM2887b != null && cursorM2887b.getCount() > 0) {
                cursorM2887b.moveToFirst();
                String string = cursorM2887b.getString(cursorM2887b.getColumnIndex("buddy_orginal_number"));
                String string2 = cursorM2887b.getString(cursorM2887b.getColumnIndex("buddy_no"));
                if (C0722a.m3116a(getActivity()).m3118a(getActivity(), this.f1801ak, this.f1800aj) == 1) {
                    if (!TextUtils.isEmpty(string)) {
                        uri = Uri.parse("tel:" + string);
                    } else {
                        uri = Uri.parse("tel:+" + string2);
                    }
                    Intent intent = new Intent("android.intent.action.CALL", uri);
                    intent.setFlags(268435456);
                    try {
                        startActivityForResult(intent, 0);
                    } catch (ActivityNotFoundException e) {
                        C1341p.m4653a(e, getClass().getSimpleName());
                    }
                    C1341p.m4658b("onDirectCall-Normal Call", getClass().getSimpleName());
                } else if (C0722a.m3116a(getActivity()).m3118a(getActivity(), this.f1801ak, this.f1800aj) == 2) {
                    if (!new C0613d(getActivity(), new C0539ao(this), new String[]{this.f1862u}, true).m2832b()) {
                        C1619g.m5889a(getActivity(), "Install Coolots app first.", 0).show();
                    }
                    C1341p.m4658b("onDirectCall-VOIP Call", getClass().getSimpleName());
                } else {
                    C1341p.m4658b("onDirectCall-No Call", getClass().getSimpleName());
                }
            }
            if (cursorM2887b != null) {
                cursorM2887b.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1828bM = (InterfaceC0604u) activity;
    }

    /* renamed from: g */
    public void m2706g() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f1803am.entrySet().iterator();
        while (it.hasNext()) {
            C0258f c0258f = (C0258f) ((Map.Entry) it.next()).getValue();
            sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.MEMBER.m3010a()), c0258f.m919a(), C0520a.m2713a(C0633m.m2883a(getActivity().getContentResolver(), c0258f.m919a()))));
            if (this.f1866y != EnumC0665r.ONETOONE && !it.hasNext()) {
                sb.append(" (").append(this.f1802al.size()).append(")");
            }
            sb.append(";");
        }
        C0635o.m2945b(getActivity().getContentResolver(), this.f1861t, sb.toString());
    }

    /* renamed from: h */
    public static EditText m2651h() {
        return f1726aC;
    }

    /* renamed from: i */
    public void m2707i() {
        if (this.f1802al.size() == 0) {
            if (this.f1851bw == null) {
                this.f1851bw = C1619g.m5888a(getActivity(), R.string.chat_title_no_buddies, 0);
            }
            this.f1851bw.show();
            return;
        }
        if (f1726aC.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            f1726aC.setText("");
            return;
        }
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            this.f1797ag.setText(R.string.popup_no_network_connection);
            this.f1797ag.setDuration(0);
            this.f1797ag.show();
            return;
        }
        if (f1726aC.length() > 2000) {
            this.f1797ag.setText(R.string.toast_text_max_Length);
            this.f1797ag.setDuration(0);
            this.f1797ag.show();
            f1726aC.setText("");
            return;
        }
        synchronized (this.f1759T) {
            if (TextUtils.isEmpty(this.f1867z) || "null".equals(this.f1867z)) {
                if (this.f1866y != EnumC0665r.BROADCAST && !this.f1744E.isShowing()) {
                    this.f1744E.show();
                }
                this.f1799ai.m839a(this.f1861t, EnumC0651d.TEXT, this.f1866y, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]), f1726aC.getText().toString());
            } else {
                this.f1799ai.m832a(EnumC0651d.TEXT, this.f1866y, this.f1867z, (String[]) this.f1802al.toArray(new String[this.f1802al.size()]), f1726aC.getText().toString());
            }
        }
        this.f1858q = false;
        this.f1839bk.setVisibility(8);
        f1726aC.setText("");
        if (!f1726aC.hasFocus()) {
            f1726aC.requestFocus();
        }
        ChatActivity.m2590a(false);
        this.f1745F = true;
        this.f1794ad.setTranscriptMode(2);
        m2705e();
        this.f1852by = f1729bx;
    }
}
