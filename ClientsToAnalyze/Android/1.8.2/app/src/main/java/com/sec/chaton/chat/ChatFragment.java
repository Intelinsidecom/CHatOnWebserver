package com.sec.chaton.chat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0229at;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyChatInfoActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.coolots.C0529i;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.multimedia.emoticon.C0962h;
import com.sec.chaton.multimedia.emoticon.C0968n;
import com.sec.chaton.multimedia.emoticon.EmoticonSelectionView;
import com.sec.chaton.multimedia.emoticon.InterfaceC0967m;
import com.sec.chaton.multimedia.image.C0983a;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.multimedia.skin.C1012j;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcard.VCardReadContactActivity;
import com.sec.chaton.p007a.p008a.C0100a;
import com.sec.chaton.p007a.p008a.EnumC0104e;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.C0635g;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p015d.p016a.AsyncTaskC0534ab;
import com.sec.chaton.p015d.p016a.AsyncTaskC0608x;
import com.sec.chaton.p015d.p016a.C0577br;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p020f.C0719g;
import com.sec.chaton.p020f.DialogC0713a;
import com.sec.chaton.p020f.InterfaceC0718f;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.p022h.p025c.C0777a;
import com.sec.chaton.p022h.p025c.C0779c;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.settings.SettingActivity;
import com.sec.chaton.trunk.database.C1589e;
import com.sec.chaton.trunk.p048b.C1542a;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.util.C1722ae;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.util.EnumC1748bd;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.p056b.C1816b;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.common.p056b.p060d.C1828c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import com.sec.widget.HeightChangedListView;
import com.sec.widget.InterfaceC2154z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import twitter4j.MediaEntity;
import twitter4j.Query;

/* loaded from: classes.dex */
public class ChatFragment extends Fragment implements MediaPlayer.OnCompletionListener, View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC0454a, InterfaceC0495bi, InterfaceC0496bj, InterfaceC0718f, InterfaceC0967m {

    /* renamed from: cl */
    private static int f1747cl;

    /* renamed from: A */
    public String f1760A;

    /* renamed from: F */
    EnumC0695j f1765F;

    /* renamed from: G */
    String f1766G;

    /* renamed from: H */
    int f1767H;

    /* renamed from: I */
    String f1768I;

    /* renamed from: L */
    public ProgressDialog f1771L;

    /* renamed from: X */
    private C0666j f1783X;

    /* renamed from: aA */
    private String f1786aA;

    /* renamed from: aB */
    private String f1787aB;

    /* renamed from: aC */
    private String f1788aC;

    /* renamed from: aD */
    private String f1789aD;

    /* renamed from: aE */
    private String f1790aE;

    /* renamed from: aF */
    private String f1791aF;

    /* renamed from: aG */
    private String f1792aG;

    /* renamed from: aH */
    private int f1793aH;

    /* renamed from: aI */
    private int f1794aI;

    /* renamed from: aJ */
    private Uri f1795aJ;

    /* renamed from: aK */
    private String f1796aK;

    /* renamed from: aM */
    private long f1798aM;

    /* renamed from: aN */
    private boolean f1799aN;

    /* renamed from: aO */
    private EditText f1800aO;

    /* renamed from: aP */
    private TextView f1801aP;

    /* renamed from: aQ */
    private String f1802aQ;

    /* renamed from: aR */
    private String f1803aR;

    /* renamed from: aS */
    private String f1804aS;

    /* renamed from: aT */
    private String f1805aT;

    /* renamed from: aU */
    private String f1806aU;

    /* renamed from: aV */
    private Bitmap f1807aV;

    /* renamed from: aW */
    private boolean f1808aW;

    /* renamed from: aX */
    private String f1809aX;

    /* renamed from: aY */
    private int f1810aY;

    /* renamed from: aZ */
    private String f1811aZ;

    /* renamed from: ab */
    private LinearLayout f1813ab;

    /* renamed from: ac */
    private ImageView f1814ac;

    /* renamed from: ad */
    private ImageButton f1815ad;

    /* renamed from: ae */
    private String f1816ae;

    /* renamed from: af */
    private String f1817af;

    /* renamed from: ah */
    private ImageButton f1819ah;

    /* renamed from: ai */
    private ImageButton f1820ai;

    /* renamed from: aj */
    private Button f1821aj;

    /* renamed from: ak */
    private Button f1822ak;

    /* renamed from: al */
    private Button f1823al;

    /* renamed from: am */
    private Button f1824am;

    /* renamed from: an */
    private Button f1825an;

    /* renamed from: ao */
    private RelativeLayout f1826ao;

    /* renamed from: ap */
    private HeightChangedListView f1827ap;

    /* renamed from: aq */
    private ViewOnClickListenerC0477as f1828aq;

    /* renamed from: ar */
    private Cursor f1829ar;

    /* renamed from: at */
    private C0639k f1831at;

    /* renamed from: aw */
    private ArrayList f1834aw;

    /* renamed from: ax */
    private HashMap f1835ax;

    /* renamed from: ay */
    private Long f1836ay;

    /* renamed from: az */
    private String f1837az;

    /* renamed from: bE */
    private ProgressDialog f1842bE;

    /* renamed from: bG */
    private FrameLayout f1844bG;

    /* renamed from: bH */
    private Button f1845bH;

    /* renamed from: bI */
    private InputMethodManager f1846bI;

    /* renamed from: bJ */
    private TextView f1847bJ;

    /* renamed from: bK */
    private TextView f1848bK;

    /* renamed from: bL */
    private ImageView f1849bL;

    /* renamed from: bM */
    private ImageView f1850bM;

    /* renamed from: bN */
    private ImageView f1851bN;

    /* renamed from: bO */
    private EmoticonSelectionView f1852bO;

    /* renamed from: bP */
    private C1798b f1853bP;

    /* renamed from: bQ */
    private Bundle f1854bQ;

    /* renamed from: bR */
    private C0635g f1855bR;

    /* renamed from: bS */
    private boolean f1856bS;

    /* renamed from: bT */
    private int f1857bT;

    /* renamed from: bU */
    private AlertDialog.Builder f1858bU;

    /* renamed from: bZ */
    private ProgressDialog f1863bZ;

    /* renamed from: ba */
    private String f1864ba;

    /* renamed from: bb */
    private String f1865bb;

    /* renamed from: ca */
    private View f1890ca;

    /* renamed from: cb */
    private DialogC0713a f1891cb;

    /* renamed from: cj */
    private C1821b f1898cj;

    /* renamed from: cn */
    private C1542a f1900cn;

    /* renamed from: o */
    LinearLayout f1902o;

    /* renamed from: p */
    LinearLayout f1903p;

    /* renamed from: q */
    LinearLayout f1904q;

    /* renamed from: r */
    LinearLayout f1905r;

    /* renamed from: s */
    LinearLayout f1906s;

    /* renamed from: t */
    TextView f1907t;

    /* renamed from: z */
    public String f1912z;

    /* renamed from: a */
    public static final String f1742a = ChatFragment.class.getSimpleName();

    /* renamed from: b */
    public static int f1743b = 0;

    /* renamed from: c */
    public static boolean f1744c = false;

    /* renamed from: d */
    public static String f1748d = "extra fileuri";

    /* renamed from: e */
    public static String f1749e = "extra participant";

    /* renamed from: f */
    public static String f1750f = "extra title";

    /* renamed from: g */
    public static String f1751g = "extra vcalendar";

    /* renamed from: h */
    public static String f1752h = "extra vard name";

    /* renamed from: i */
    public static String f1753i = "extra initchat";

    /* renamed from: j */
    public static String f1754j = "extra showinput";

    /* renamed from: k */
    public static String f1755k = "extra chagetitle";

    /* renamed from: l */
    public static String f1756l = "extra invite";

    /* renamed from: m */
    public static String f1757m = "extra int";

    /* renamed from: n */
    public static String f1758n = "extra inbox nobi";

    /* renamed from: u */
    static boolean f1759u = false;

    /* renamed from: cf */
    private static int f1745cf = 30;

    /* renamed from: ck */
    private static ArrayList f1746ck = new ArrayList();

    /* renamed from: W */
    private Object f1782W = new Object();

    /* renamed from: Y */
    private boolean f1784Y = false;

    /* renamed from: Z */
    private File f1785Z = null;

    /* renamed from: aa */
    private EnumC0699n f1812aa = null;

    /* renamed from: ag */
    private boolean f1818ag = false;

    /* renamed from: v */
    public boolean f1908v = false;

    /* renamed from: w */
    public boolean f1909w = false;

    /* renamed from: x */
    public boolean f1910x = false;

    /* renamed from: y */
    public Boolean f1911y = false;

    /* renamed from: as */
    private ProgressDialog f1830as = null;

    /* renamed from: au */
    private int f1832au = 1;

    /* renamed from: av */
    private String f1833av = null;

    /* renamed from: B */
    public boolean f1761B = true;

    /* renamed from: C */
    public String f1762C = "";

    /* renamed from: D */
    public int f1763D = 0;

    /* renamed from: aL */
    private boolean f1797aL = true;

    /* renamed from: E */
    String f1764E = null;

    /* renamed from: bc */
    private boolean f1866bc = false;

    /* renamed from: bd */
    private boolean f1867bd = false;

    /* renamed from: be */
    private boolean f1868be = false;

    /* renamed from: bf */
    private boolean f1869bf = false;

    /* renamed from: bg */
    private BitmapDrawable f1870bg = null;

    /* renamed from: bh */
    private BitmapDrawable f1871bh = null;

    /* renamed from: bi */
    private BitmapDrawable f1872bi = null;

    /* renamed from: bj */
    private BitmapDrawable f1873bj = null;

    /* renamed from: bk */
    private BitmapDrawable f1874bk = null;

    /* renamed from: bl */
    private BitmapDrawable f1875bl = null;

    /* renamed from: bm */
    private BitmapDrawable f1876bm = null;

    /* renamed from: bn */
    private BitmapDrawable f1877bn = null;

    /* renamed from: bo */
    private BitmapDrawable f1878bo = null;

    /* renamed from: bp */
    private BitmapDrawable f1879bp = null;

    /* renamed from: bq */
    private BitmapDrawable f1880bq = null;

    /* renamed from: br */
    private Bitmap f1881br = null;

    /* renamed from: bs */
    private Bitmap f1882bs = null;

    /* renamed from: bt */
    private Bitmap f1883bt = null;

    /* renamed from: bu */
    private Bitmap f1884bu = null;

    /* renamed from: bv */
    private Bitmap f1885bv = null;

    /* renamed from: bw */
    private Bitmap f1886bw = null;

    /* renamed from: bx */
    private Bitmap f1887bx = null;

    /* renamed from: by */
    private Bitmap f1888by = null;

    /* renamed from: bz */
    private Bitmap f1889bz = null;

    /* renamed from: bA */
    private Bitmap f1838bA = null;

    /* renamed from: bB */
    private Bitmap f1839bB = null;

    /* renamed from: bC */
    private Bitmap f1840bC = null;

    /* renamed from: bD */
    private int f1841bD = 0;

    /* renamed from: bF */
    private boolean f1843bF = false;

    /* renamed from: J */
    Dialog f1769J = null;

    /* renamed from: K */
    ArrayList f1770K = new ArrayList();

    /* renamed from: bV */
    private AlertDialog f1859bV = null;

    /* renamed from: bW */
    private final long f1860bW = 10485760;

    /* renamed from: bX */
    private final long f1861bX = 3145728;

    /* renamed from: bY */
    private boolean f1862bY = false;

    /* renamed from: M */
    public boolean f1772M = true;

    /* renamed from: cc */
    private ArrayList f1892cc = new ArrayList();

    /* renamed from: cd */
    private boolean f1893cd = false;

    /* renamed from: ce */
    private Toast f1894ce = null;

    /* renamed from: cg */
    private int f1895cg = f1745cf;

    /* renamed from: ch */
    private boolean f1896ch = true;

    /* renamed from: ci */
    private boolean f1897ci = true;

    /* renamed from: cm */
    private InterfaceC2154z f1899cm = new C0485b(this);

    /* renamed from: N */
    AdapterView.OnItemSelectedListener f1773N = new C0497c(this);

    /* renamed from: co */
    private Handler f1901co = new HandlerC0500f(this);

    /* renamed from: O */
    View.OnClickListener f1774O = new ViewOnClickListenerC0512r(this);

    /* renamed from: P */
    ContentObserver f1775P = new C0513s(this, new Handler());

    /* renamed from: Q */
    ContentObserver f1776Q = new C0514t(this, new Handler());

    /* renamed from: R */
    ContentObserver f1777R = new C0515u(this, new Handler());

    /* renamed from: S */
    ContentObserver f1778S = new C0516v(this, new Handler());

    /* renamed from: T */
    ContentObserver f1779T = new C0517w(this, new Handler());

    /* renamed from: U */
    Handler f1780U = new HandlerC0518x(this);

    /* renamed from: V */
    InterfaceC0667k f1781V = new C0520z(this);

    /* renamed from: a */
    static /* synthetic */ int m2498a(ChatFragment chatFragment, int i) {
        int i2 = chatFragment.f1895cg + i;
        chatFragment.f1895cg = i2;
        return i2;
    }

    /* renamed from: a */
    static /* synthetic */ String m2504a(ChatFragment chatFragment, Object obj) {
        String str = chatFragment.f1786aA + obj;
        chatFragment.f1786aA = str;
        return str;
    }

    /* renamed from: e */
    static /* synthetic */ int m2534e(ChatFragment chatFragment, int i) {
        int i2 = chatFragment.f1793aH + i;
        chatFragment.f1793aH = i2;
        return i2;
    }

    static {
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_animation_msg, R.drawable.chat_insert_icon_ams, 9));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_picture, R.drawable.chat_insert_icon_pictures, 0));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_capture_picture, R.drawable.chat_insert_icon_takepicture, 1));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_video, R.drawable.chat_insert_icon_video, 2));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_record_video, R.drawable.chat_insert_icon_record_video, 3));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_reocrd_audio, R.drawable.chat_insert_icon_record_voice, 4));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_contact, R.drawable.chat_insert_icon_contact, 6));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_file, R.drawable.chat_insert_icon_file, 10));
        f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_calendar, R.drawable.chat_insert_icon_calendar, 7));
        if (C0452a.m2468a()) {
            f1746ck.add(new C0719g(GlobalApplication.m3262c(), R.string.menu_multimedia_geo_tag, R.drawable.chat_insert_icon_location, 8));
        }
        f1747cl = 0;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1898cj = new C1821b();
        View viewInflate = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        m2571t();
        this.f1808aW = C1789u.m6075a().getBoolean("Setting enter key", false);
        this.f1904q = (LinearLayout) viewInflate.findViewById(R.id.lLayoutProfile);
        this.f1906s = (LinearLayout) viewInflate.findViewById(R.id.optionBar);
        this.f1907t = (TextView) viewInflate.findViewById(R.id.textBroadcast);
        this.f1902o = (LinearLayout) viewInflate.findViewById(R.id.ldeletetop);
        this.f1903p = (LinearLayout) viewInflate.findViewById(R.id.ldeletebot);
        this.f1905r = (LinearLayout) viewInflate.findViewById(R.id.lLayoutMsgEdit);
        this.f1852bO = (EmoticonSelectionView) viewInflate.findViewById(R.id.scrollemoticon);
        this.f1852bO.setEmoticonSelectedListener(this);
        this.f1827ap = (HeightChangedListView) viewInflate.findViewById(R.id.chat_listview);
        this.f1827ap.setOnHeightChangedListener(this.f1899cm);
        this.f1827ap.setOnItemSelectedListener(new C0509o(this));
        this.f1890ca = viewInflate.findViewById(R.id.previewText);
        this.f1890ca.setOnClickListener(this);
        if (GlobalApplication.m3265f()) {
            this.f1826ao = (RelativeLayout) viewInflate.findViewById(R.id.honeycomb_deletetop);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1797a(getResources().getString(R.string.chat_profile), R.drawable.chat_info));
            arrayList.add(new C1797a(getResources().getString(R.string.chat_view_menu_invite), R.drawable.invite_buddy));
            arrayList.add(new C1797a(getResources().getString(R.string.chat_view_menu_close), R.drawable.close_chat));
            arrayList.add(new C1797a(getResources().getString(R.string.backup), R.drawable.backup_message));
            if (AbstractC0521a.m2697a(getActivity()) && AbstractC0521a.m2697a(getActivity())) {
                if (EnumC0695j.m3145a(getArguments().getInt("chatType")) == EnumC0695j.ONETOONE) {
                    if (C0577br.m2769h() && C0577br.m2765b(this.f1833av)) {
                        arrayList.add(new C1797a(getResources().getString(R.string.menu_voice_call), R.drawable.chaton_voice));
                    }
                    if (C0577br.m2770i() && C0577br.m2766c(this.f1833av)) {
                        arrayList.add(new C1797a(getResources().getString(R.string.menu_video_call), R.drawable.chaton_video));
                    }
                } else {
                    if (C1789u.m6075a().getInt("group_voice_call_max_count", 4) > 1 && C0577br.m2769h()) {
                        arrayList.add(new C1797a(getResources().getString(R.string.menu_voice_call), R.drawable.chaton_voice));
                    }
                    if (C1789u.m6075a().getInt("group_video_call_max_count", 4) > 1 && C0577br.m2770i()) {
                        arrayList.add(new C1797a(getResources().getString(R.string.menu_video_call), R.drawable.chaton_video));
                    }
                }
            }
            this.f1853bP = new C1798b(getActivity(), arrayList);
        }
        this.f1844bG = (FrameLayout) viewInflate.findViewById(R.id.imageTrunkBg);
        this.f1844bG.setOnClickListener(new ViewOnClickListenerC0519y(this));
        this.f1845bH = (Button) viewInflate.findViewById(R.id.btnChatSend);
        this.f1845bH.setOnClickListener(this);
        this.f1800aO = (EditText) viewInflate.findViewById(R.id.editChatMsg);
        this.f1800aO.addTextChangedListener(new C0467ai(this));
        this.f1800aO.setOnEditorActionListener(new C0468aj(this));
        this.f1800aO.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC0469ak(this));
        this.f1800aO.setOnClickListener(new ViewOnClickListenerC0470al(this));
        this.f1827ap.setOnScrollListener(new C0471am(this));
        this.f1820ai = (ImageButton) viewInflate.findViewById(R.id.btnChatImage);
        this.f1820ai.setOnClickListener(this);
        this.f1819ah = (ImageButton) viewInflate.findViewById(R.id.btnAdd);
        this.f1819ah.setOnClickListener(this);
        this.f1822ak = (Button) viewInflate.findViewById(R.id.btnDelCancel);
        this.f1822ak.setOnClickListener(this);
        this.f1821aj = (Button) viewInflate.findViewById(R.id.btnDelete);
        this.f1821aj.setOnClickListener(this);
        this.f1823al = (Button) viewInflate.findViewById(R.id.btnRangeAll);
        this.f1823al.setOnClickListener(this.f1774O);
        this.f1824am = (Button) viewInflate.findViewById(R.id.btnRangeRcv);
        this.f1824am.setOnClickListener(this.f1774O);
        this.f1825an = (Button) viewInflate.findViewById(R.id.btnRangeSnt);
        this.f1825an.setOnClickListener(this.f1774O);
        this.f1801aP = (TextView) viewInflate.findViewById(R.id.chatTitle);
        this.f1847bJ = (TextView) viewInflate.findViewById(R.id.unReadCount);
        this.f1849bL = (ProfileImageView) viewInflate.findViewById(R.id.Chaticon);
        this.f1850bM = (ImageView) viewInflate.findViewById(R.id.imagebackgroup);
        this.f1850bM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f1851bN = (ImageView) viewInflate.findViewById(R.id.imageline);
        this.f1848bK = (TextView) viewInflate.findViewById(R.id.title_menu);
        this.f1848bK.setVisibility(8);
        this.f1847bJ.setVisibility(8);
        this.f1813ab = (LinearLayout) viewInflate.findViewById(R.id.mMedia_layout);
        this.f1814ac = (ImageView) viewInflate.findViewById(R.id.mMedia_imageView);
        this.f1815ad = (ImageButton) viewInflate.findViewById(R.id.mMedia_del_btn);
        this.f1815ad.setOnClickListener(new ViewOnClickListenerC0472an(this));
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        C1786r.m6064d("w:" + defaultDisplay.getWidth());
        C1786r.m6064d("h:" + defaultDisplay.getHeight());
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            if (GlobalApplication.m3265f()) {
                m2587a(125);
            }
        } else if (configuration.orientation == 1 && GlobalApplication.m3265f()) {
            m2587a(85);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("address", "000");
        intent.setType("vnd.android-dir/mms-sms");
        this.f1896ch = BuddyProfileFragment.m2132a(getActivity(), intent);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT < 14) {
            this.f1843bF = true;
        }
        this.f1799aN = true;
        this.f1798aM = 0L;
        this.f1834aw = new ArrayList();
        synchronized (this.f1782W) {
            this.f1835ax = new HashMap();
        }
        this.f1855bR = new C0635g(new Handler());
        this.f1846bI = (InputMethodManager) getActivity().getSystemService("input_method");
        this.f1900cn = new C1542a(GlobalApplication.m3260b(), this.f1901co);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.f1846bI.hideSoftInputFromWindow(this.f1800aO.getApplicationWindowToken(), 0);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f1800aO.getWindowToken(), 0);
        this.f1852bO.setVisibility(8);
        if (this.f1891cb != null && this.f1891cb.isShowing()) {
            this.f1891cb.dismiss();
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2527c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f1900cn.m5401a(arrayList);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f1783X = new C0666j(getActivity().getContentResolver(), this.f1781V);
        this.f1854bQ = getArguments();
        if (this.f1854bQ != null && this.f1854bQ.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("InBoxNO : ");
            if (this.f1854bQ.containsKey("inboxNO")) {
                this.f1912z = this.f1854bQ.getString("inboxNO");
                sb.append(this.f1912z);
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("ChatType : ");
            if (this.f1854bQ.containsKey("chatType")) {
                this.f1765F = EnumC0695j.m3145a(this.f1854bQ.getInt("chatType"));
                if (this.f1765F != null) {
                    sb.append(this.f1765F.toString());
                }
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("Participants : ");
            if (this.f1854bQ.containsKey("receivers")) {
                String[] stringArray = this.f1854bQ.getStringArray("receivers");
                if (this.f1765F == EnumC0695j.ONETOONE) {
                    this.f1760A = stringArray[0];
                }
                synchronized (this.f1782W) {
                    for (String str : stringArray) {
                        this.f1834aw.add(str);
                        this.f1835ax.put(str, new C0100a(str));
                        sb.append(str + " ");
                    }
                }
            } else {
                sb.append("Not Contained");
            }
            C1786r.m6066e(sb.toString(), getClass().getSimpleName());
            sb.append("KEY_GROUP_NAME : ");
            if (this.f1854bQ.containsKey("groupnmae")) {
                this.f1768I = this.f1854bQ.getString("groupnmae");
                sb.append(this.f1768I.toString());
                C1786r.m6064d("mGroupName:" + this.f1768I);
                m2511a(this.f1768I, (TextView.BufferType) null);
                this.f1786aA = this.f1768I;
                this.f1792aG = this.f1768I;
            }
            if (this.f1912z == null) {
                this.f1783X.startQuery(8, null, C0694i.f2616a, null, "inbox_chat_type=" + EnumC0695j.BROADCAST.m3146a(), null, null);
            }
            if (this.f1854bQ.containsKey("content_type")) {
                this.f1810aY = this.f1854bQ.getInt("content_type");
                getActivity().getIntent().removeExtra("content_type");
                C1786r.m6064d("ChatView content_type:" + this.f1810aY);
                this.f1867bd = true;
            }
            if (this.f1854bQ.containsKey("forward_sender_name")) {
                this.f1809aX = this.f1854bQ.getString("forward_sender_name");
                C1786r.m6064d("ChatView forward_sender_name:" + this.f1809aX);
            }
            if (this.f1854bQ.containsKey("download_uri")) {
                this.f1811aZ = this.f1854bQ.getString("download_uri");
                C1786r.m6064d("ChatView download_uri:" + this.f1811aZ);
            }
            if (this.f1854bQ.containsKey("sub_content")) {
                this.f1864ba = this.f1854bQ.getString("sub_content");
                C1786r.m6064d("ChatView sub_content:" + this.f1864ba);
            }
            if (this.f1854bQ.containsKey(f1754j)) {
                this.f1841bD = this.f1854bQ.getInt(f1754j);
                C1786r.m6064d("misShowinput:" + this.f1841bD);
            }
            if (this.f1854bQ.containsKey(f1753i)) {
                this.f1865bb = this.f1854bQ.getString(f1753i);
                this.f1869bf = this.f1854bQ.getBoolean(f1755k);
                if (this.f1869bf) {
                    m2511a(this.f1865bb, TextView.BufferType.NORMAL);
                    this.f1786aA = this.f1865bb;
                    this.f1792aG = this.f1786aA;
                    this.f1866bc = true;
                }
            }
            if (this.f1854bQ.containsKey(f1756l)) {
                this.f1868be = this.f1854bQ.getBoolean(f1756l);
            }
            if (this.f1854bQ.containsKey("inboxValid")) {
                this.f1797aL = this.f1854bQ.getBoolean("inboxValid");
                if (!this.f1797aL && this.f1905r.isShown()) {
                    this.f1905r.setVisibility(8);
                }
            }
            if (this.f1854bQ.containsKey("lastTempMessage")) {
                this.f1762C = this.f1854bQ.getString("lastTempMessage");
            }
            this.f1832au = this.f1854bQ.getInt("showPhoneNumber", 1);
            this.f1833av = this.f1854bQ.getString("extraInfo");
        }
        registerForContextMenu(this.f1827ap);
        BaseActivity.m1827a(this, true);
        if (this.f1765F == EnumC0695j.GROUPCHAT) {
        }
        if (this.f1765F == EnumC0695j.ONETOONE) {
            C1746bb.m5945a(getActivity()).m5959a(this.f1849bL, this.f1760A);
        } else if (this.f1765F == EnumC0695j.GROUPCHAT) {
            C1746bb.m5945a(getActivity()).m5958a(this.f1849bL, EnumC1748bd.CHAT_GROUP);
        } else if (this.f1765F == EnumC0695j.BROADCAST) {
            C1746bb.m5945a(getActivity()).m5958a(this.f1849bL, EnumC1748bd.BROADCAST);
            this.f1844bG.setVisibility(4);
        }
        this.f1849bL.setOnClickListener(this);
        this.f1828aq = new ViewOnClickListenerC0477as(getActivity(), this.f1827ap, R.layout.item_balloon_skin0, null, this.f1765F, null, this.f1821aj, this.f1898cj);
        this.f1827ap.setAdapter((ListAdapter) this.f1828aq);
        this.f1828aq.m2665a(this);
        this.f1830as = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.media_file_download);
        this.f1771L = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.setting_webview_please_wait);
        this.f1856bS = false;
        this.f1863bZ = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_geo_loading);
        m2532d("");
    }

    /* renamed from: a */
    public void m2586a() {
        if (!this.f1910x) {
            this.f1800aO.requestFocus();
            new Timer(true).schedule(new C0501g(this, new Handler()), 100L);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (f1744c) {
            f1744c = false;
        }
        this.f1893cd = false;
        if (GlobalApplication.m3265f()) {
            this.f1862bY = true;
        }
        m2571t();
        C1786r.m6061b("onResume - QUERY_INBOX", getClass().getSimpleName());
        if (this.f1912z == null && this.f1765F == EnumC0695j.ONETOONE) {
            this.f1783X.startQuery(1, null, C0694i.m3144d(), null, "buddy_no=?", new String[]{(String) this.f1834aw.get(0), this.f1766G}, null);
        } else {
            if (TextUtils.isEmpty(this.f1912z)) {
                this.f1912z = "";
            }
            this.f1783X.startQuery(1, null, C0694i.m3139a(), null, "inbox_no=?", new String[]{this.f1912z}, null);
        }
        PushReceiver.m4324a(this);
        getActivity().getContentResolver().registerContentObserver(C0698m.f2626a, true, this.f1777R);
        if (!TextUtils.isEmpty(this.f1766G)) {
            this.f1783X.startQuery(9, null, C1589e.f5703a, null, "session_id=?", new String[]{this.f1766G}, null);
        }
        getActivity().getContentResolver().registerContentObserver(C1589e.f5703a, true, this.f1775P);
        getActivity().getContentResolver().registerContentObserver(C0694i.f2616a, true, this.f1779T);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f1893cd = true;
        this.f1762C = this.f1800aO.getText().toString();
        m2559n();
        getActivity().getContentResolver().unregisterContentObserver(this.f1777R);
        getActivity().getContentResolver().unregisterContentObserver(this.f1776Q);
        getActivity().getContentResolver().unregisterContentObserver(this.f1775P);
        getActivity().getContentResolver().unregisterContentObserver(this.f1779T);
        if (this.f1831at != null) {
            this.f1831at.m2930a(SystemClock.elapsedRealtime() + 480000);
            this.f1831at.f2484b = false;
        }
        GlobalApplication.f2776b = null;
        PushReceiver.m4324a((InterfaceC0495bi) null);
        if (this.f1863bZ != null && this.f1863bZ.isShowing()) {
            this.f1863bZ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m2554l() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f1783X.startUpdate(4, null, C0694i.f2616a, contentValues, "inbox_no='" + this.f1912z + "'", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public boolean m2557m() {
        if (this.f1893cd) {
            return false;
        }
        GlobalApplication.f2776b = this.f1912z;
        this.f1831at = C0639k.m2904a(this.f1780U, this.f1912z, this.f1765F);
        if (this.f1831at == null) {
            return false;
        }
        this.f1831at.m2940a(this.f1766G);
        this.f1831at.m2935a(this);
        if (!this.f1831at.f2484b) {
            this.f1831at.f2484b = true;
        } else {
            this.f1831at.m2959k();
        }
        return true;
    }

    /* renamed from: n */
    private void m2559n() {
        if (!TextUtils.isEmpty(this.f1912z)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_last_temp_msg", this.f1800aO.getText().toString());
            this.f1783X.startUpdate(-1, null, C0694i.f2616a, contentValues, "inbox_no=?", new String[]{this.f1912z});
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case 1:
                if (this.f1797aL) {
                    Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                    intent.putExtra("ACTIVITY_PURPOSE", 5);
                    intent.putExtra("chatType", this.f1765F.m3146a());
                    synchronized (this.f1782W) {
                        intent.putExtra(f1749e, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]));
                    }
                    startActivityForResult(intent, 4);
                    this.f1908v = true;
                }
                return true;
            case 2:
            case 3:
            case 6:
            default:
                return true;
            case 4:
                f1759u = false;
                m2600a(this.f1912z, this.f1765F, this.f1766G, this.f1789aD);
                return true;
            case 5:
                if (this.f1827ap.getCount() != 0) {
                    this.f1828aq.m2672c();
                    if (this.f1828aq != null) {
                        this.f1828aq.m2664a(EnumC0487ba.SELECT_NONE);
                        this.f1828aq.m2671b(EnumC0487ba.SELECT_NONE);
                        this.f1828aq.m2673c(EnumC0487ba.SELECT_NONE);
                    }
                    BaseActivity.m1827a(this, false);
                    this.f1783X.startQuery(12, null, C0698m.m3156c(this.f1912z), null, null, null, null);
                } else {
                    Toast.makeText(getActivity(), R.string.toast_no_delete_data, 0).show();
                }
                return true;
            case 7:
                startActivity(new Intent(getActivity(), (Class<?>) (GlobalApplication.m3265f() ? SettingActivity.class : ActivitySettings.class)));
                return true;
            case 8:
            case 9:
                if (this.f1765F == EnumC0695j.ONETOONE) {
                    if (!new C0529i(getActivity(), new C0503i(this), new String[]{this.f1760A}, menuItem.getItemId() == 8).m2698a()) {
                        Toast.makeText(getActivity(), "Install Coolots app first.", 0).show();
                    }
                } else {
                    Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                    intent2.putExtra("ACTIVITY_PURPOSE", menuItem.getItemId() == 8 ? 14 : 15);
                    intent2.putExtra("chatType", this.f1765F.m3146a());
                    synchronized (this.f1782W) {
                        intent2.putExtra(f1749e, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]));
                    }
                    startActivity(intent2);
                }
                return true;
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        String string;
        boolean z;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        Cursor cursor = (Cursor) this.f1827ap.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        C0639k c0639kM2914b = C0639k.m2914b(this.f1912z);
        String string2 = cursor.getString(cursor.getColumnIndex("message_sender"));
        if (!C1789u.m6075a().getString("msisdn", "").equals(string2)) {
            if ((c0639kM2914b != null ? (AsyncTaskC0608x) c0639kM2914b.f2486d.get(Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_sever_id")))) : null) != null) {
                Toast.makeText(view.getContext(), R.string.media_file_download, 0).show();
                return;
            }
        } else {
            if ((c0639kM2914b != null ? (AsyncTaskC0534ab) c0639kM2914b.f2485c.get(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")))) : null) != null) {
                Toast.makeText(view.getContext(), R.string.media_file_upload, 0).show();
                return;
            }
        }
        String string3 = cursor.getString(cursor.getColumnIndex("_id"));
        String string4 = cursor.getString(cursor.getColumnIndex("message_content"));
        EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        String string5 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        if (string4 != null && enumC0699nM3160a != EnumC0699n.SYSTEM) {
            contextMenu.clear();
            if (enumC0699nM3160a == EnumC0699n.TEXT) {
                contextMenu.add(R.string.chat_view_menu_copy).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0504j(this, string4));
            }
            switch (C0466ah.f1933a[enumC0699nM3160a.ordinal()]) {
                case 2:
                    if (m2538e(string4)) {
                        string = getString(R.string.chat_emoticon);
                        break;
                    } else {
                        string = getString(R.string.dialog_header_text);
                        break;
                    }
                case 3:
                    string = getString(R.string.anicon_download_list_title);
                    break;
                case 4:
                default:
                    string = getString(R.string.dialog_header_text);
                    break;
                case 5:
                    string = getString(R.string.media_photo);
                    break;
                case 6:
                    string = getString(R.string.media_video);
                    break;
                case 7:
                    string = getString(R.string.media_map);
                    break;
                case 8:
                    string = getString(R.string.media_voice);
                    break;
                case 9:
                    string = getString(R.string.media_contact);
                    break;
                case 10:
                    string = getString(R.string.media_calendar);
                    break;
                case 11:
                    string = getString(R.string.menu_multimedia_file);
                    break;
            }
            contextMenu.setHeaderTitle(C0968n.m3825a(getActivity(), string, (int) (this.f1800aO.getLineHeight() * 1.2f)));
            contextMenu.add(R.string.chat_view_menu_delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0505k(this, string3));
            if (enumC0699nM3160a == EnumC0699n.TEXT || enumC0699nM3160a == EnumC0699n.GEO) {
                z = true;
            } else {
                z = (TextUtils.isEmpty(string5) || C0452a.f1724c.equals(string5) || string5.contains("thumbnail") || !C1767bw.m6002a()) ? false : true;
            }
            if (z) {
                contextMenu.add(R.string.chatview_menu_forward).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0506l(this, enumC0699nM3160a, string4, string5));
                if (enumC0699nM3160a == EnumC0699n.TEXT && !C1789u.m6075a().getString("msisdn", "").equals(string2)) {
                    contextMenu.add(R.string.chatview_menu_forward_with_sender).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0507m(this, string2, enumC0699nM3160a, string4, string5));
                }
                if (enumC0699nM3160a == EnumC0699n.IMAGE) {
                    contextMenu.add(R.string.trunk_opt_header_share).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0508n(this, string5));
                }
            }
            if (enumC0699nM3160a == EnumC0699n.TEXT) {
            }
        }
    }

    /* renamed from: a */
    public void m2596a(EnumC0699n enumC0699n, String str, String str2, String str3) {
        Intent intent = new Intent(getActivity(), (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC0699n.m3162a());
        intent.putExtra("inboxNO", this.f1912z);
        if (enumC0699n == EnumC0699n.TEXT || enumC0699n == EnumC0699n.GEO) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("forward_sender_name", str3);
        }
        intent.putExtra("chatType", this.f1765F.m3146a());
        startActivity(intent);
    }

    /* renamed from: a */
    public void m2600a(String str, EnumC0695j enumC0695j, String str2, String str3) {
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(getActivity());
        alertDialogBuilderC2120a.setTitle(R.string.menu_chat_close);
        alertDialogBuilderC2120a.setMessage(R.string.dialog_title_msgbox_delete).setCancelable(true).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0511q(this)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0510p(this, str2, enumC0695j, str));
        alertDialogBuilderC2120a.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m2560o() {
        C1783o.m6036a((C1767bw.m6002a() ? GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath()) + "/" + this.f1912z);
        this.f1831at.m2954f();
        if (GlobalApplication.m3265f()) {
            HomeTabletFragment.m628a(getFragmentManager(), new HomeTabletFragment.EmptyFragment());
        } else {
            getActivity().finish();
        }
    }

    /* renamed from: p */
    private void m2562p() {
        this.f1852bO.setVisibility(8);
        this.f1909w = false;
        this.f1846bI.hideSoftInputFromWindow(this.f1800aO.getWindowToken(), 0);
        if (this.f1891cb == null) {
            this.f1891cb = new DialogC0713a(this, null, f1746ck);
        }
        if (!this.f1891cb.isShowing()) {
            this.f1891cb.show();
        }
    }

    /* renamed from: a */
    public void m2597a(File file) {
        C1786r.m6061b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(getActivity(), (Class<?>) ImageModify.class);
        intent.setDataAndType(Uri.fromFile(file), "image/*");
        intent.putExtra("return-data", true);
        intent.putExtra("sendMode", true);
        startActivityForResult(intent, 16);
    }

    /* renamed from: a */
    public void m2588a(Uri uri) {
        C1786r.m6061b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(getActivity(), (Class<?>) ImageModify.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("return-data", true);
        intent.putExtra("sendMode", true);
        startActivityForResult(intent, 16);
    }

    /* renamed from: a */
    public void m2598a(File file, String str, String str2) {
        if (file != null) {
            String upperCase = str.toUpperCase();
            if ("MP4".equals(upperCase) || "3GP".equals(upperCase)) {
                String str3 = "." + upperCase.toUpperCase();
                if (file.length() > 10485760) {
                    Toast.makeText(getActivity(), getResources().getString(R.string.record_video_dialog_limit_title_max_size_reached) + "(10 MB)", 0).show();
                    return;
                } else if (TextUtils.isEmpty(this.f1766G) || this.f1765F == EnumC0695j.BROADCAST) {
                    m2583a(file, EnumC0699n.VIDEO, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), true, null, str2);
                    return;
                } else {
                    m2583a(file, EnumC0699n.VIDEO, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), false, null, str2);
                    return;
                }
            }
            new AlertDialogBuilderC2120a(getActivity()).setTitle(getActivity().getResources().getString(R.string.ams_attention_title)).setMessage(getActivity().getResources().getString(R.string.toast_supported_format)).setNegativeButton(getActivity().getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
        }
    }

    /* renamed from: b */
    public void m2603b() {
        if (this.f1891cb.isShowing()) {
            this.f1891cb.dismiss();
        }
    }

    /* renamed from: a */
    public void m2601a(String[] strArr) {
        int i = 0;
        synchronized (this.f1782W) {
            if (this.f1765F == EnumC0695j.ONETOONE) {
                while (i < strArr.length) {
                    this.f1834aw.add(strArr[i]);
                    this.f1835ax.put(strArr[i], new C0100a(strArr[i]));
                    i++;
                }
                Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                intent.putExtra("receivers", (String[]) this.f1834aw.toArray(new String[0]));
                String string = this.f1800aO.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    intent.putExtra("lastTempMessage", string);
                }
                if (GlobalApplication.m3265f()) {
                    ((BaseActivity) getActivity()).mo1830a(intent);
                } else {
                    startActivity(intent);
                    getActivity().finish();
                }
            } else if (this.f1765F == EnumC0695j.BROADCAST) {
                if (!this.f1761B) {
                    this.f1834aw = new ArrayList();
                    this.f1835ax = new HashMap();
                    while (i < strArr.length) {
                        this.f1834aw.add(strArr[i]);
                        this.f1835ax.put(strArr[i], new C0100a(strArr[i]));
                        i++;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (i < strArr.length) {
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.INVITE.m3171a()), strArr[i], C0493bg.m2684a(C0657a.m2983c(getActivity().getContentResolver(), strArr[i])))).append(";");
                        C0670n.m3087c(getActivity().getContentResolver(), this.f1912z, strArr[i]);
                        this.f1834aw.add(strArr[i]);
                        this.f1835ax.put(strArr[i], new C0100a(strArr[i]));
                        i++;
                    }
                    C0665i.m3062a(this.f1783X, 1, this.f1912z, sb.toString(), C1789u.m6075a().getString("msisdn", ""));
                    C0660d.m3023a(this.f1783X, 4, this.f1912z, this.f1834aw.size());
                }
                C0660d.m3027b(getActivity().getContentResolver(), this.f1912z);
            } else if (TextUtils.isEmpty(this.f1766G)) {
                if (GlobalApplication.m3265f() && !this.f1761B) {
                    this.f1834aw = new ArrayList();
                    this.f1835ax = new HashMap();
                    while (i < strArr.length) {
                        this.f1834aw.add(strArr[i]);
                        this.f1835ax.put(strArr[i], new C0100a(strArr[i]));
                        i++;
                    }
                } else {
                    while (i < strArr.length) {
                        this.f1834aw.add(strArr[i]);
                        this.f1835ax.put(strArr[i], new C0100a(strArr[i]));
                        i++;
                    }
                }
            } else {
                this.f1831at.m2939a(EnumC0699n.TEXT, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), strArr);
                if (!this.f1771L.isShowing()) {
                    this.f1771L.show();
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        String string;
        if (i2 == -1) {
            String strSubstring = "";
            switch (i) {
                case 0:
                    C1786r.m6061b("[SendingMedia] Start - Capture Picture", getClass().getSimpleName());
                    if (this.f1795aJ == null) {
                        Toast.makeText(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        break;
                    } else {
                        if (this.f1795aJ.toString() != null && this.f1795aJ.toString().contains("file://")) {
                            string = this.f1795aJ.toString().substring(7);
                        } else {
                            string = this.f1795aJ.toString();
                        }
                        m2597a(new File(string));
                        break;
                    }
                    break;
                case 1:
                    C1786r.m6061b("[SendingMedia] Start - Picture", getClass().getSimpleName());
                    if (intent != null && intent.getData() != null) {
                        if (GlobalApplication.m3265f()) {
                            m2588a(intent.getData());
                            break;
                        } else {
                            Cursor cursorQuery = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
                            String string2 = null;
                            while (cursorQuery.moveToNext()) {
                                string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            }
                            m2597a(new File(string2));
                            break;
                        }
                    }
                    break;
                case 4:
                    this.f1910x = false;
                    this.f1841bD = 1;
                    m2601a(intent.getStringArrayExtra("receivers"));
                    break;
                case 5:
                    C1786r.m6061b("[SendingMedia] Start - Calendar", getClass().getSimpleName());
                    System.gc();
                    if (intent != null) {
                        File file = new File(intent.getStringExtra(f1748d));
                        String stringExtra = intent.getStringExtra(f1751g);
                        StringTokenizer stringTokenizer = new StringTokenizer(intent.getStringExtra(f1748d), ".");
                        while (stringTokenizer.hasMoreTokens()) {
                            strSubstring = stringTokenizer.nextToken();
                        }
                        String str = "." + strSubstring.toUpperCase();
                        if (TextUtils.isEmpty(this.f1766G) || this.f1765F == EnumC0695j.BROADCAST) {
                            if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                                this.f1771L.show();
                            }
                            m2582a(file, EnumC0699n.CALENDAR, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), true, stringExtra);
                            break;
                        } else {
                            m2582a(file, EnumC0699n.CALENDAR, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), false, stringExtra);
                            break;
                        }
                    }
                    break;
                case 6:
                    C1786r.m6061b("[SendingMedia] Start - Geo tag", getClass().getSimpleName());
                    if (intent != null && intent.getStringExtra("GEOPOINT") != null) {
                        if (TextUtils.isEmpty(this.f1766G) || this.f1765F == EnumC0695j.BROADCAST || "null".equals(this.f1766G)) {
                        }
                        this.f1841bD = 0;
                        this.f1910x = false;
                        m2586a();
                        this.f1814ac.setBackgroundDrawable(getResources().getDrawable(R.drawable.messenger_chat_location));
                        this.f1813ab.setVisibility(0);
                        this.f1784Y = true;
                        this.f1845bH.setEnabled(true);
                        this.f1785Z = null;
                        this.f1812aa = EnumC0699n.GEO;
                        this.f1816ae = intent.getStringExtra("GEOPOINT");
                        this.f1817af = intent.getStringExtra("GEOADDRESS");
                        m2595a(this.f1812aa);
                        m2565q();
                        break;
                    }
                    break;
                case 7:
                    if (intent != null && intent.getData() != null) {
                        m2521b(intent.getData());
                        break;
                    }
                    break;
                case 10:
                    C1786r.m6061b("[SendingMedia] Start - Record Audio", getClass().getSimpleName());
                    System.gc();
                    if (intent != null) {
                        File file2 = new File(intent.getStringExtra(f1748d));
                        StringTokenizer stringTokenizer2 = new StringTokenizer(intent.getStringExtra(f1748d), ".");
                        while (stringTokenizer2.hasMoreTokens()) {
                            strSubstring = stringTokenizer2.nextToken();
                        }
                        String str2 = "." + strSubstring.toUpperCase();
                        if (TextUtils.isEmpty(this.f1766G) || this.f1765F == EnumC0695j.BROADCAST) {
                            if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                                this.f1771L.show();
                            }
                            m2582a(file2, EnumC0699n.AUDIO, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), true, null);
                            break;
                        } else {
                            m2582a(file2, EnumC0699n.AUDIO, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), false, null);
                            break;
                        }
                    }
                    break;
                case 11:
                    C1786r.m6061b("[SendingMedia] Start - Video", getClass().getSimpleName());
                    if (intent != null && intent.getData() != null) {
                        try {
                            Cursor cursorQuery2 = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
                            String string3 = "";
                            if (cursorQuery2 != null) {
                                while (cursorQuery2.moveToNext()) {
                                    int columnIndex = cursorQuery2.getColumnIndex("_data");
                                    if (columnIndex != -1) {
                                        string3 = cursorQuery2.getString(columnIndex);
                                    } else {
                                        new AlertDialogBuilderC2120a(getActivity()).setTitle(getActivity().getResources().getString(R.string.ams_attention_title)).setMessage(getActivity().getResources().getString(R.string.toast_supported_format)).setNegativeButton(getActivity().getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                                    }
                                }
                            } else {
                                string3 = intent.getData().toString();
                                if (string3 != null && string3.contains("file://")) {
                                    string3 = string3.substring(7);
                                }
                            }
                            File file3 = new File(string3);
                            StringTokenizer stringTokenizer3 = new StringTokenizer(string3, ".");
                            while (stringTokenizer3.hasMoreTokens()) {
                                stringTokenizer3.nextToken();
                            }
                            if (file3 != null) {
                                if (file3.length() > 10485760) {
                                    C2153y.m7536a(getActivity(), getResources().getString(R.string.record_video_dialog_limit_title_max_size_reached), 0).show();
                                } else {
                                    this.f1841bD = 0;
                                    this.f1910x = false;
                                    m2586a();
                                    C0983a c0983a = new C0983a(file3.getPath(), file3.getPath(), false, false);
                                    c0983a.m6172a((View) this.f1814ac);
                                    this.f1898cj.m6190a(this.f1814ac, c0983a);
                                    this.f1813ab.setVisibility(0);
                                    this.f1784Y = true;
                                    this.f1845bH.setEnabled(true);
                                    this.f1785Z = file3;
                                    this.f1812aa = EnumC0699n.VIDEO;
                                    this.f1816ae = null;
                                }
                            }
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                                break;
                            }
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "File loading error.", 0).show();
                            return;
                        }
                    }
                    break;
                case C0229at.HorizontalSrollView_android_background /* 12 */:
                    C1786r.m6061b("[SendingMedia] Start - Record Video", getClass().getSimpleName());
                    if (intent != null && intent.getData() != null) {
                        Cursor cursorQuery3 = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
                        File file4 = null;
                        if (cursorQuery3 != null) {
                            while (cursorQuery3.moveToNext()) {
                                String string4 = cursorQuery3.getString(cursorQuery3.getColumnIndex("_data"));
                                C1786r.m6064d("MimeTypeMap:" + string4);
                                file4 = new File(string4);
                                StringTokenizer stringTokenizer4 = new StringTokenizer(string4, ".");
                                while (stringTokenizer4.hasMoreTokens()) {
                                    stringTokenizer4.nextToken();
                                }
                            }
                        }
                        if (file4 != null) {
                            if (file4.length() > 10485760) {
                                Toast.makeText(getActivity(), getResources().getString(R.string.record_video_dialog_limit_title_max_size_reached) + "(10 MB)", 0).show();
                            } else {
                                this.f1841bD = 0;
                                this.f1910x = false;
                                m2586a();
                                C0983a c0983a2 = new C0983a(file4.getPath(), file4.getPath(), false, false);
                                c0983a2.m6172a((View) this.f1814ac);
                                this.f1898cj.m6190a(this.f1814ac, c0983a2);
                                this.f1813ab.setVisibility(0);
                                this.f1784Y = true;
                                this.f1845bH.setEnabled(true);
                                this.f1785Z = file4;
                                this.f1812aa = EnumC0699n.VIDEO;
                            }
                        }
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                            break;
                        }
                    }
                    break;
                case C0229at.HorizontalSrollView_android_padding /* 13 */:
                    if (intent.getBooleanExtra("SAVE", false)) {
                        C2153y.m7535a(getActivity(), R.string.toast_save_media, 0).show();
                        break;
                    } else {
                        C2153y.m7535a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                        break;
                    }
                case C0229at.HorizontalSrollView_android_paddingLeft /* 14 */:
                    if (intent.getBooleanExtra("SAVE", false)) {
                        C2153y.m7535a(getActivity(), R.string.toast_save_media, 0).show();
                        break;
                    } else {
                        C2153y.m7535a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                        break;
                    }
                case C0229at.HorizontalSrollView_android_paddingTop /* 15 */:
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        String string5 = extras.getString("AMS_FILE_PATH");
                        boolean z = extras.getBoolean("AMS_WITH_TEXT", false);
                        if (string5 != null) {
                            File file5 = new File(string5);
                            if (!z) {
                                if (TextUtils.isEmpty(this.f1766G) || this.f1765F == EnumC0695j.BROADCAST) {
                                    if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                                        this.f1771L.show();
                                    }
                                    m2582a(new File(string5), EnumC0699n.IMAGE, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), true, null);
                                } else {
                                    m2582a(new File(string5), EnumC0699n.IMAGE, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), false, null);
                                }
                            }
                            if (z) {
                                this.f1841bD = 0;
                                this.f1910x = false;
                                m2586a();
                                C0983a c0983a3 = new C0983a(string5, string5, true, false);
                                c0983a3.m6172a((View) this.f1814ac);
                                this.f1898cj.m6190a(this.f1814ac, c0983a3);
                                this.f1813ab.setVisibility(0);
                                this.f1784Y = true;
                                this.f1845bH.setEnabled(true);
                                this.f1785Z = file5;
                                this.f1812aa = EnumC0699n.IMAGE;
                                this.f1816ae = null;
                                break;
                            }
                        }
                    }
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    if (intent != null && intent.getExtras() != null) {
                        String string6 = intent.getExtras().getString("temp_file_path");
                        boolean z2 = intent.getExtras().getBoolean("sendWithText");
                        File file6 = new File(string6);
                        if (string6 != null) {
                            strSubstring = string6.substring(string6.lastIndexOf(".") + 1);
                        }
                        if (file6 != null) {
                            String upperCase = strSubstring.toUpperCase();
                            if ("JPEG".equals(upperCase) || "JPG".equals(upperCase) || "PNG".equals(upperCase)) {
                                String str3 = "." + upperCase.toUpperCase();
                                File fileM2502a = null;
                                if (!m2523b(file6) || (fileM2502a = m2502a(getActivity(), file6, (String) null)) != null) {
                                    if (fileM2502a == null) {
                                        fileM2502a = file6;
                                    }
                                    if (!z2) {
                                        boolean z3 = false;
                                        if (this.f1766G == null || this.f1765F == EnumC0695j.BROADCAST) {
                                            if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                                                this.f1771L.show();
                                            }
                                            z3 = true;
                                        }
                                        m2582a(fileM2502a, EnumC0699n.IMAGE, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), z3, null);
                                    }
                                    if (z2) {
                                        this.f1841bD = 0;
                                        this.f1910x = false;
                                        m2586a();
                                        C0983a c0983a4 = new C0983a(String.valueOf(System.currentTimeMillis()), fileM2502a.getPath(), true, false);
                                        c0983a4.m6172a((View) this.f1814ac);
                                        this.f1898cj.m6190a(this.f1814ac, c0983a4);
                                        this.f1813ab.setVisibility(0);
                                        this.f1784Y = true;
                                        this.f1845bH.setEnabled(true);
                                        this.f1785Z = fileM2502a;
                                        this.f1812aa = EnumC0699n.IMAGE;
                                        break;
                                    }
                                }
                            } else {
                                new AlertDialogBuilderC2120a(getActivity()).setTitle(getActivity().getResources().getString(R.string.ams_attention_title)).setMessage(getActivity().getResources().getString(R.string.toast_supported_format)).setNegativeButton(getActivity().getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                                break;
                            }
                        }
                    }
                    break;
                case C0229at.HorizontalSrollView_android_paddingBottom /* 17 */:
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    this.f1865bb = intent.getStringExtra(f1753i);
                    this.f1869bf = intent.getBooleanExtra(f1755k, false);
                    C1786r.m6064d("mTmpTitle:" + this.f1792aG);
                    C1786r.m6064d("arrayResult:" + stringArrayExtra);
                    if (stringArrayExtra == null) {
                        C1786r.m6064d("null arrayResult");
                    } else {
                        C1786r.m6064d("Not null arrayResult");
                    }
                    if (this.f1869bf) {
                        C1786r.m6064d("mTmpTitle not null!!!");
                        this.f1792aG = this.f1865bb;
                        m2511a(this.f1792aG, TextView.BufferType.NORMAL);
                        this.f1786aA = this.f1792aG;
                    }
                    if (stringArrayExtra != null) {
                        m2601a(stringArrayExtra);
                        break;
                    }
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    C1786r.m6061b("[SendingMedia] Start - Document", getClass().getSimpleName());
                    if (this.f1831at == null) {
                        C2153y.m7535a(getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        break;
                    } else {
                        String strDecode = Uri.decode(intent.getData().toString());
                        if (strDecode.startsWith("file://")) {
                            strDecode = strDecode.substring(7);
                        }
                        File file7 = null;
                        if (intent != null && strDecode != null) {
                            file7 = new File(strDecode);
                        }
                        StringTokenizer stringTokenizer5 = new StringTokenizer(strDecode, ".");
                        while (stringTokenizer5.hasMoreTokens()) {
                            stringTokenizer5.nextToken();
                        }
                        boolean z4 = false;
                        if (this.f1766G == null || this.f1765F == EnumC0695j.BROADCAST) {
                            if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                                this.f1771L.show();
                            }
                            z4 = true;
                        }
                        if (file7.length() > 10485760) {
                            Toast.makeText(getActivity(), getResources().getString(R.string.record_video_dialog_limit_title_max_size_reached) + " (10 MB)", 0).show();
                            break;
                        } else {
                            m2582a(file7, EnumC0699n.DOCUMENT, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), z4, file7.getName());
                            break;
                        }
                    }
                    break;
                case 19:
                    if (intent != null) {
                        C1786r.m6061b("[SendingMedia] Start - Contact", getClass().getSimpleName());
                        System.gc();
                        intent.getStringExtra(f1748d);
                        File file8 = new File(intent.getStringExtra(f1748d));
                        String stringExtra2 = intent.getStringExtra(f1752h);
                        C1786r.m6064d("EXTRA_VCARD:" + stringExtra2);
                        StringTokenizer stringTokenizer6 = new StringTokenizer(intent.getStringExtra(f1748d), ".");
                        while (stringTokenizer6.hasMoreTokens()) {
                            strSubstring = stringTokenizer6.nextToken();
                        }
                        String str4 = "." + strSubstring.toUpperCase();
                        if (TextUtils.isEmpty(this.f1766G) || this.f1765F == EnumC0695j.BROADCAST) {
                            if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                                this.f1771L.show();
                            }
                            m2582a(file8, EnumC0699n.CONTACT, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), true, stringExtra2);
                            break;
                        } else {
                            m2582a(file8, EnumC0699n.CONTACT, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), false, stringExtra2);
                            break;
                        }
                    }
                    break;
                case C0229at.HorizontalSrollView_android_visibility /* 20 */:
                    if (!GlobalApplication.m3265f()) {
                        getActivity().finish();
                        break;
                    }
                    break;
            }
            return;
        }
        if (i2 == 0 && i == 16) {
            if (this.f1771L.isShowing()) {
                this.f1771L.dismiss();
            }
            m2569s();
        }
        this.f1910x = false;
        this.f1841bD = 1;
        Toast.makeText(getActivity(), R.string.cancel, 1);
    }

    /* renamed from: b */
    private void m2521b(Uri uri) {
        Intent intent = new Intent(getActivity(), (Class<?>) VCardReadContactActivity.class);
        intent.putExtra("inbox_NO", this.f1912z);
        intent.putExtra("contactUri", uri.toString());
        startActivityForResult(intent, 19);
    }

    /* renamed from: a */
    public void m2595a(EnumC0699n enumC0699n) {
        boolean z;
        if (this.f1766G == null || this.f1765F == EnumC0695j.BROADCAST || "null".equals(this.f1766G)) {
            if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                this.f1771L.show();
            }
            z = true;
        } else {
            z = false;
        }
        switch (C0466ah.f1933a[enumC0699n.ordinal()]) {
            case 3:
                this.f1831at.m2948b(-1L, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), z, this.f1796aK, -1L);
                break;
            case 5:
            case 8:
            case 9:
            case 10:
                m2583a(this.f1785Z, this.f1812aa, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), z, this.f1816ae, this.f1800aO.getText().toString().trim());
                break;
            case 6:
                StringTokenizer stringTokenizer = new StringTokenizer(this.f1785Z.getName(), ".");
                String strNextToken = "";
                while (stringTokenizer.hasMoreTokens()) {
                    strNextToken = stringTokenizer.nextToken();
                }
                m2598a(this.f1785Z, strNextToken, this.f1800aO.getText().toString().trim());
                break;
            case 7:
                this.f1831at.m2926a(this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), (TextUtils.isEmpty(this.f1766G) || this.f1765F == EnumC0695j.BROADCAST || "null".equals(this.f1766G)) ? true : z, this.f1816ae, this.f1817af);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m2565q() {
        this.f1813ab.setVisibility(8);
        this.f1784Y = false;
        this.f1785Z = null;
        this.f1812aa = null;
        this.f1816ae = null;
        this.f1817af = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0060 -> B:11:0x0054). Please report as a decompilation issue!!! */
    /* renamed from: b */
    public static boolean m2523b(File file) {
        BitmapFactory.Options options;
        boolean z = true;
        C1786r.m6061b("[ShouldBeResized]: " + file.getName(), GlobalApplication.m3260b().getClass().getName());
        if (file.length() <= 512000) {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            } catch (Exception e) {
                C1786r.m6054a("Exception", GlobalApplication.m3260b().getClass().getName());
            }
            if (options.outWidth < options.outHeight ? !(options.outHeight > 1024 || options.outWidth > 768) : !(options.outWidth > 1024 || options.outHeight > 768)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x028d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0243 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2 A[Catch: all -> 0x0347, Exception -> 0x034d, FileNotFoundException -> 0x0354, OutOfMemoryError -> 0x035b, TryCatch #15 {FileNotFoundException -> 0x0354, Exception -> 0x034d, OutOfMemoryError -> 0x035b, all -> 0x0347, blocks: (B:22:0x00a9, B:23:0x00ac, B:25:0x00b2, B:26:0x00bf, B:28:0x00e1, B:29:0x00e4, B:30:0x0104, B:31:0x0113, B:53:0x018c, B:51:0x017d), top: B:149:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e1 A[Catch: all -> 0x0347, Exception -> 0x034d, FileNotFoundException -> 0x0354, OutOfMemoryError -> 0x035b, TryCatch #15 {FileNotFoundException -> 0x0354, Exception -> 0x034d, OutOfMemoryError -> 0x035b, all -> 0x0347, blocks: (B:22:0x00a9, B:23:0x00ac, B:25:0x00b2, B:26:0x00bf, B:28:0x00e1, B:29:0x00e4, B:30:0x0104, B:31:0x0113, B:53:0x018c, B:51:0x017d), top: B:149:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017d A[Catch: all -> 0x0347, Exception -> 0x034d, FileNotFoundException -> 0x0354, OutOfMemoryError -> 0x035b, TRY_ENTER, TryCatch #15 {FileNotFoundException -> 0x0354, Exception -> 0x034d, OutOfMemoryError -> 0x035b, all -> 0x0347, blocks: (B:22:0x00a9, B:23:0x00ac, B:25:0x00b2, B:26:0x00bf, B:28:0x00e1, B:29:0x00e4, B:30:0x0104, B:31:0x0113, B:53:0x018c, B:51:0x017d), top: B:149:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02d2  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v17, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v23, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v32, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileOutputStream] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m2502a(android.content.Context r10, java.io.File r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 869
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.m2502a(android.content.Context, java.io.File, java.lang.String):java.io.File");
    }

    /* renamed from: c */
    public void m2605c() {
        getActivity().getContentResolver().registerContentObserver(C0701p.m3164a(this.f1912z), true, this.f1776Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m2506a(String str, int i) {
        int i2 = 70;
        if (this.f1843bF) {
            i2 = 45;
        }
        if (str.length() > i2) {
            return (str.substring(0, i2) + "...") + " (" + i + ")";
        }
        return str + " (" + i + ")";
    }

    /* renamed from: d */
    public void m2606d() {
        String[] strArrSplit;
        if (this.f1867bd) {
            this.f1846bI.hideSoftInputFromWindow(this.f1800aO.getWindowToken(), 0);
            if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.TEXT) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(this.f1809aX)) {
                    sb.append(getString(R.string.original_name)).append(" : ").append(this.f1809aX).append("\n----------------\n");
                }
                if (!TextUtils.isEmpty(this.f1811aZ)) {
                    String string = sb.append(this.f1811aZ).toString();
                    if (string.length() > 2000) {
                        string = string.substring(0, 1999);
                    }
                    CharSequence charSequenceM3825a = C0968n.m3825a(getActivity(), string, (int) C1722ae.m5894a(26.0f));
                    this.f1800aO.setText(charSequenceM3825a);
                    this.f1800aO.setSelection(charSequenceM3825a.length());
                    return;
                }
                return;
            }
            if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.GEO) {
                if (TextUtils.isEmpty(this.f1766G) || "null".equals(this.f1766G)) {
                    if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                        this.f1771L.show();
                    }
                    this.f1831at.m2941a(this.f1912z, EnumC0699n.m3160a(this.f1810aY), this.f1765F, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), this.f1811aZ);
                    return;
                }
                this.f1831at.m2938a(EnumC0699n.m3160a(this.f1810aY), this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), this.f1811aZ);
                return;
            }
            if (!C1767bw.m6002a()) {
                C1786r.m6054a("[sendForward()] No sdcard", f1742a);
                return;
            }
            C1786r.m6061b("Forward download_uri:" + this.f1811aZ, f1742a);
            C1786r.m6061b("Forward content:" + this.f1864ba, f1742a);
            StringTokenizer stringTokenizer = new StringTokenizer(this.f1811aZ, ".");
            String strNextToken = "";
            while (stringTokenizer.hasMoreTokens() && !this.f1811aZ.startsWith("content://")) {
                strNextToken = stringTokenizer.nextToken();
            }
            String upperCase = strNextToken.toUpperCase();
            File file = null;
            if (this.f1811aZ.startsWith("file://")) {
                file = new File(this.f1811aZ.substring(7));
            }
            if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.VIDEO) {
                if ("MP4".equals(upperCase) || "3GP".equals(upperCase)) {
                    if (file != null && file.length() > 10485760) {
                        C2153y.m7535a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                        return;
                    }
                } else {
                    new AlertDialogBuilderC2120a(getActivity()).setTitle(getActivity().getResources().getString(R.string.ams_attention_title)).setMessage(getActivity().getResources().getString(R.string.toast_supported_format)).setNegativeButton(getActivity().getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                    return;
                }
            } else if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.AUDIO) {
                if ("MP3".equals(upperCase) || "3GP".equals(upperCase) || "AAC".equals(upperCase) || "AMR".equals(upperCase) || "AMR-NB".equals(upperCase)) {
                    if (file != null && file.length() > 3145728) {
                        C2153y.m7535a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                        return;
                    }
                } else {
                    new AlertDialogBuilderC2120a(getActivity()).setTitle(getActivity().getResources().getString(R.string.ams_attention_title)).setMessage(getActivity().getResources().getString(R.string.toast_supported_format)).setNegativeButton(getActivity().getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                    return;
                }
            }
            boolean z = false;
            if (TextUtils.isEmpty(this.f1766G) || "null".equals(this.f1766G)) {
                z = true;
            }
            String str = "." + upperCase;
            if (this.f1864ba == null) {
                strArrSplit = null;
            } else {
                strArrSplit = this.f1864ba.split("\n");
            }
            if (strArrSplit != null && strArrSplit.length > 4 && file != null) {
                String strSubstring = null;
                if (strArrSplit.length > 6 && Query.MIXED.equals(strArrSplit[0])) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 6; i < strArrSplit.length; i++) {
                        stringBuffer.append(strArrSplit[i] + "\n");
                    }
                    strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                }
                if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.IMAGE || EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.VIDEO) {
                    boolean z2 = EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.IMAGE;
                    this.f1841bD = 0;
                    this.f1910x = false;
                    m2586a();
                    C0983a c0983a = new C0983a(file.getPath(), file.getPath(), z2, false);
                    c0983a.m6172a((View) this.f1814ac);
                    this.f1898cj.m6190a(this.f1814ac, c0983a);
                    this.f1813ab.setVisibility(0);
                    this.f1784Y = true;
                    this.f1845bH.setEnabled(true);
                    this.f1785Z = file;
                    this.f1812aa = EnumC0699n.m3160a(this.f1810aY);
                    this.f1816ae = null;
                    if (!TextUtils.isEmpty(strSubstring)) {
                        CharSequence charSequenceM3825a2 = C0968n.m3825a(getActivity(), strSubstring, (int) C1722ae.m5894a(26.0f));
                        this.f1800aO.setText(charSequenceM3825a2);
                        this.f1800aO.setSelection(charSequenceM3825a2.length());
                        return;
                    }
                    return;
                }
                String strM6032a = C1783o.m6032a(this.f1811aZ, GlobalApplication.m3256a().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f1912z, file.getName());
                Long lValueOf = Long.valueOf(C1735ar.m5918a());
                C0665i.m3043a(GlobalApplication.m3260b().getContentResolver(), String.valueOf(lValueOf), this.f1912z, EnumC0699n.m3160a(this.f1810aY), strM6032a, this.f1834aw.size(), this.f1864ba);
                C0665i.m3054a(GlobalApplication.m3260b().getContentResolver(), lValueOf, true);
                if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.CONTACT || EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.CALENDAR || EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.DOCUMENT) {
                    C0665i.m3055a(GlobalApplication.m3260b().getContentResolver(), this.f1912z, lValueOf, strArrSplit[5]);
                }
                if (z && this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                    this.f1771L.show();
                }
                this.f1831at.m2923a(lValueOf.longValue(), this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), z, strArrSplit.length > 5 ? strArrSplit[5] : null, file, str, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], EnumC0699n.m3160a(this.f1810aY), strSubstring);
                return;
            }
            if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.IMAGE && (file == null || !C1598g.m5509c(file.getPath()))) {
                m2588a(Uri.parse(this.f1811aZ));
                return;
            }
            if (EnumC0699n.m3160a(this.f1810aY) == EnumC0699n.CONTACT) {
            }
            if (file != null) {
                if (z && this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                    this.f1771L.show();
                }
                m2582a(file, EnumC0699n.m3160a(this.f1810aY), this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[0]), z, this.f1864ba);
            }
        }
    }

    /* renamed from: e */
    public void m2607e() throws IOException {
        if (this.f1834aw.size() == 0) {
            if (this.f1894ce == null) {
                this.f1894ce = Toast.makeText(getActivity(), R.string.chat_title_no_buddies, 0);
            }
            this.f1894ce.show();
            return;
        }
        String string = this.f1800aO.getText().toString();
        if (this.f1800aO.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0 && !this.f1784Y) {
            TextKeyListener.clear(this.f1800aO.getText());
            return;
        }
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            Toast.makeText(getActivity(), R.string.toast_network_unable, 0).show();
            return;
        }
        if (this.f1784Y) {
            m2595a(this.f1812aa);
            m2565q();
        } else if (TextUtils.isEmpty(this.f1766G) || "null".equals(this.f1766G)) {
            if (this.f1765F != EnumC0695j.BROADCAST && !this.f1771L.isShowing()) {
                this.f1771L.show();
            }
            this.f1831at.m2941a(this.f1912z, EnumC0699n.TEXT, this.f1765F, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), string);
        } else {
            this.f1831at.m2938a(EnumC0699n.TEXT, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), string);
        }
        C0962h.m3819a().m6170a(C0968n.m3827a(getActivity(), this.f1800aO.getText().toString()), true);
        this.f1909w = false;
        this.f1852bO.setVisibility(8);
        TextKeyListener.clear(this.f1800aO.getText());
        this.f1827ap.setSelectionFromTop(this.f1827ap.getCount(), 0);
        m2608f();
        this.f1895cg = f1745cf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        String strSubstring;
        String strSubstring2;
        HashMap mapM2661a;
        HashMap mapM2669b;
        boolean z;
        HashMap mapM2669b2;
        boolean z2 = true;
        switch (view.getId()) {
            case R.id.lLayoutProfile /* 2131493101 */:
                if (this.f1786aA != null) {
                    Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                    intent.putExtra("ACTIVITY_PURPOSE", 6);
                    C1786r.m6064d("namelist:" + this.f1786aA);
                    if (this.f1765F != EnumC0695j.ONETOONE) {
                        strSubstring2 = this.f1786aA.substring(0, this.f1786aA.length() - (Integer.toString(this.f1834aw.size()).length() + 3));
                    } else {
                        strSubstring2 = this.f1786aA;
                    }
                    intent.putExtra(f1753i, this.f1761B);
                    intent.putExtra(f1750f, strSubstring2);
                    intent.putExtra("inboxNO", this.f1912z);
                    intent.putExtra("chatType", this.f1765F.m3146a());
                    intent.putExtra(f1755k, this.f1869bf);
                    intent.putExtra("buddyNO", this.f1760A);
                    intent.putExtra("inboxValid", this.f1797aL);
                    synchronized (this.f1782W) {
                        intent.putExtra(f1749e, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]));
                    }
                    if (this.f1862bY) {
                        ((BaseActivity) getActivity()).mo1830a(intent);
                        return;
                    } else {
                        startActivityForResult(intent, 17);
                        return;
                    }
                }
                return;
            case R.id.Chaticon /* 2131493235 */:
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyChatInfoActivity.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 6);
                C1786r.m6064d("namelist:" + this.f1786aA);
                if (this.f1765F != EnumC0695j.ONETOONE) {
                    strSubstring = this.f1786aA.substring(0, this.f1786aA.length() - (Integer.toString(this.f1834aw.size()).length() + 3));
                } else {
                    strSubstring = this.f1786aA;
                }
                intent2.putExtra(f1753i, this.f1761B);
                intent2.putExtra(f1750f, strSubstring);
                intent2.putExtra("inboxNO", this.f1912z);
                intent2.putExtra("chatType", this.f1765F.m3146a());
                intent2.putExtra(f1755k, this.f1869bf);
                intent2.putExtra(f1758n, this.f1799aN);
                intent2.putExtra(f1757m, 2);
                synchronized (this.f1782W) {
                    intent2.putExtra(f1749e, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]));
                }
                intent2.putExtra("ACTIVITY_TYPE", MediaEntity.Size.CROP);
                startActivityForResult(intent2, 17);
                return;
            case R.id.previewText /* 2131493246 */:
                this.f1827ap.setSelection(this.f1827ap.getCount() - 1);
                m2608f();
                return;
            case R.id.btnAdd /* 2131493250 */:
                int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
                if (-3 == iM3420a || -2 == iM3420a) {
                    Toast.makeText(getActivity(), R.string.toast_network_unable, 0).show();
                    return;
                } else {
                    if (this.f1834aw.size() == 0) {
                        if (this.f1894ce == null) {
                            this.f1894ce = Toast.makeText(getActivity(), R.string.chat_title_no_buddies, 0);
                        }
                        this.f1894ce.show();
                        return;
                    }
                    m2562p();
                    return;
                }
            case R.id.btnChatImage /* 2131493251 */:
                if (!this.f1909w) {
                    this.f1846bI.hideSoftInputFromWindow(this.f1800aO.getApplicationWindowToken(), 0);
                    this.f1852bO.setVisibility(0);
                    this.f1909w = true;
                    return;
                } else {
                    this.f1852bO.setVisibility(8);
                    this.f1909w = false;
                    return;
                }
            case R.id.btnChatSend /* 2131493253 */:
                m2607e();
                return;
            case R.id.btnDelete /* 2131493256 */:
                Boolean bool = false;
                if (this.f1828aq.m2674d() == EnumC0487ba.SELECT_ALL || this.f1828aq.m2674d() == EnumC0487ba.SELECT_PART || this.f1828aq.m2676f() == EnumC0487ba.SELECT_ALL || this.f1828aq.m2676f() == EnumC0487ba.SELECT_PART || this.f1828aq.m2675e() == EnumC0487ba.SELECT_ALL || this.f1828aq.m2675e() == EnumC0487ba.SELECT_PART) {
                    bool = true;
                } else {
                    HashMap mapM2661a2 = this.f1828aq.m2661a();
                    if (mapM2661a2 != null && !mapM2661a2.isEmpty()) {
                        Iterator it = mapM2661a2.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                                    bool = true;
                                }
                            }
                        }
                    }
                    if (!bool.booleanValue() && (mapM2669b2 = this.f1828aq.m2669b()) != null && !mapM2669b2.isEmpty()) {
                        Iterator it2 = mapM2669b2.entrySet().iterator();
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
                    if (this.f1828aq.m2674d() == EnumC0487ba.SELECT_ALL) {
                        this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND message_type != ? AND message_type != ?", new String[]{this.f1912z, Integer.toString(0), Integer.toString(3)});
                    } else if (this.f1828aq.m2676f() == EnumC0487ba.SELECT_ALL) {
                        this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND message_sender != ? AND message_type != ?", new String[]{this.f1912z, C1789u.m6075a().getString("msisdn", ""), Integer.toString(3)});
                    } else if (this.f1828aq.m2675e() == EnumC0487ba.SELECT_ALL) {
                        this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND message_sender = ? AND message_type != ?", new String[]{this.f1912z, C1789u.m6075a().getString("msisdn", ""), Integer.toString(0)});
                    } else if (this.f1828aq.m2674d() == EnumC0487ba.SELECT_PART || this.f1828aq.m2676f() == EnumC0487ba.SELECT_PART || this.f1828aq.m2675e() == EnumC0487ba.SELECT_PART) {
                        if ((this.f1828aq.m2674d() == EnumC0487ba.SELECT_PART || this.f1828aq.m2675e() == EnumC0487ba.SELECT_PART) && (mapM2661a = this.f1828aq.m2661a()) != null && !mapM2661a.isEmpty()) {
                            StringBuilder sb = new StringBuilder();
                            for (Map.Entry entry : mapM2661a.entrySet()) {
                                if (!((Boolean) entry.getValue()).booleanValue()) {
                                    sb.append(((Long) entry.getKey()).toString()).append(",");
                                }
                            }
                            if (sb.length() > 0) {
                                sb.setLength(sb.length() - 1);
                                this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND _id NOT IN (" + sb.toString() + ") AND message_type != ? AND message_type != ?", new String[]{this.f1912z, Integer.toString(0), Integer.toString(3)});
                            } else {
                                this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND message_sender = ? AND message_type != ? AND message_type != ?", new String[]{this.f1912z, C1789u.m6075a().getString("msisdn", ""), Integer.toString(0), Integer.toString(3)});
                            }
                        }
                        if ((this.f1828aq.m2674d() == EnumC0487ba.SELECT_PART || this.f1828aq.m2676f() == EnumC0487ba.SELECT_PART) && (mapM2669b = this.f1828aq.m2669b()) != null && !mapM2669b.isEmpty()) {
                            StringBuilder sb2 = new StringBuilder();
                            for (Map.Entry entry2 : mapM2669b.entrySet()) {
                                if (!((Boolean) entry2.getValue()).booleanValue()) {
                                    sb2.append(((Long) entry2.getKey()).toString()).append(",");
                                }
                            }
                            if (sb2.length() > 0) {
                                sb2.setLength(sb2.length() - 1);
                                this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND message_sever_id NOT IN (" + sb2.toString() + ") AND message_type != ? AND message_type != ?", new String[]{this.f1912z, Integer.toString(0), Integer.toString(3)});
                            } else {
                                this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND message_sender != ? AND message_type != ? AND message_type != ?", new String[]{this.f1912z, C1789u.m6075a().getString("msisdn", ""), Integer.toString(0), Integer.toString(3)});
                            }
                        }
                    } else {
                        HashMap mapM2661a3 = this.f1828aq.m2661a();
                        if (mapM2661a3 == null || mapM2661a3.isEmpty()) {
                            z = true;
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            for (Map.Entry entry3 : mapM2661a3.entrySet()) {
                                if (((Boolean) entry3.getValue()).booleanValue()) {
                                    sb3.append(((Long) entry3.getKey()).toString()).append(",");
                                }
                            }
                            if (sb3.length() > 0) {
                                sb3.setLength(sb3.length() - 1);
                                this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND _id IN (" + sb3.toString() + ") AND message_type != ?", new String[]{this.f1912z, Integer.toString(0)});
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        HashMap mapM2669b3 = this.f1828aq.m2669b();
                        if (mapM2669b3 != null && !mapM2669b3.isEmpty()) {
                            StringBuilder sb4 = new StringBuilder();
                            for (Map.Entry entry4 : mapM2669b3.entrySet()) {
                                if (((Boolean) entry4.getValue()).booleanValue()) {
                                    sb4.append(((Long) entry4.getKey()).toString()).append(",");
                                }
                            }
                            if (sb4.length() > 0) {
                                sb4.setLength(sb4.length() - 1);
                                this.f1783X.startDelete(3, null, C0698m.f2626a, "message_inbox_no = ? AND message_sever_id IN (" + sb4.toString() + ") AND message_type != ?", new String[]{this.f1912z, Integer.toString(3)});
                            } else {
                                z2 = false;
                            }
                        }
                        if (!z && !z2) {
                            Toast.makeText(getActivity(), R.string.toast_no_delete_data, 0).show();
                        }
                    }
                    this.f1827ap.clearChoices();
                    return;
                }
                Toast.makeText(getActivity(), R.string.toast_no_delete_data, 0).show();
                return;
            case R.id.btnDelCancel /* 2131493257 */:
                this.f1827ap.setChoiceMode(0);
                this.f1827ap.setTranscriptMode(2);
                BaseActivity.m1827a(this, true);
                this.f1827ap.clearChoices();
                this.f1902o.setVisibility(8);
                this.f1903p.setVisibility(8);
                if (GlobalApplication.m3265f()) {
                    this.f1826ao.setVisibility(8);
                }
                this.f1848bK.setVisibility(8);
                this.f1904q.setVisibility(0);
                this.f1905r.setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0496bj
    /* renamed from: a */
    public void mo2594a(View view, String str, String str2) {
    }

    @Override // com.sec.chaton.chat.InterfaceC0496bj
    /* renamed from: a */
    public void mo2592a(View view, long j, boolean z) {
        CharSequence[] charSequenceArr;
        if (this.f1797aL && view != null && view.getParent() != null) {
            if (this.f1834aw.size() == 0) {
                if (this.f1894ce == null) {
                    this.f1894ce = Toast.makeText(getActivity(), R.string.chat_title_no_buddies, 0);
                }
                this.f1894ce.show();
                return;
            }
            if (z && this.f1832au != 1 && this.f1896ch) {
                charSequenceArr = new CharSequence[]{GlobalApplication.m3262c().getString(R.string.view_send_sms), GlobalApplication.m3262c().getString(R.string.view_resend), GlobalApplication.m3262c().getString(R.string.menu_chat_delete)};
            } else {
                charSequenceArr = new CharSequence[]{GlobalApplication.m3262c().getString(R.string.view_resend), GlobalApplication.m3262c().getString(R.string.menu_chat_delete)};
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            int positionForView = this.f1827ap.getPositionForView(view);
            Cursor cursor = this.f1828aq.getCursor();
            cursor.moveToPosition(positionForView);
            String strM2585a = m2585a(cursor);
            if (GlobalApplication.m3265f()) {
                builder.setTitle(strM2585a);
            }
            builder.setItems(charSequenceArr, new DialogInterfaceOnClickListenerC0459aa(this, view, z, j));
            builder.setCancelable(true);
            builder.show();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0496bj
    /* renamed from: a */
    public void mo2589a(View view) {
        if (view != null && view.getParent() != null) {
            int positionForView = this.f1827ap.getPositionForView(view);
            Cursor cursor = this.f1828aq.getCursor();
            cursor.moveToPosition(positionForView);
            EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            int i = cursor.getInt(cursor.getColumnIndex("message_stored_ext"));
            C1786r.m6061b("[onItemClickListener] view:" + view + " v.getTag():" + view.getTag(), getClass().getName());
            if (enumC0699nM3160a == EnumC0699n.TEXT || enumC0699nM3160a == EnumC0699n.SYSTEM) {
                this.f1846bI.hideSoftInputFromWindow(this.f1800aO.getWindowToken(), 0);
                return;
            }
            View view2 = (View) view.getTag();
            if (this.f1842bE == null) {
                this.f1842bE = new ProgressDialog(new ContextThemeWrapper(getActivity(), R.style.CustomProgressDialogtheme));
                this.f1842bE.setProgressStyle(1);
                this.f1842bE.setMessage(getResources().getString(R.string.media_file_download));
            }
            this.f1842bE.setButton(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0460ab(this, j));
            this.f1842bE.setOnCancelListener(new DialogInterfaceOnCancelListenerC0461ac(this, j));
            if (view.getId() == R.id.download_completed) {
                if (!C0777a.m3326a().m3328a(j)) {
                    C0777a.m3326a().m3327a(view2, this, this.f1780U, positionForView, string2, false, string, j, enumC0699nM3160a, this.f1765F, string4);
                    return;
                }
                return;
            }
            if (view.getId() == R.id.imageSndContent) {
                C1786r.m6064d("file uri:" + string2);
                if (enumC0699nM3160a == EnumC0699n.VIDEO) {
                    ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                    return;
                }
                if (enumC0699nM3160a == EnumC0699n.IMAGE) {
                    if (string3 != null && string3.contains("thumbnail")) {
                        if (C1767bw.m6002a()) {
                            string3 = string3.replace("thumbnail/", "");
                        } else {
                            Toast.makeText(getActivity(), R.string.sdcard_not_found, 0).show();
                            return;
                        }
                    }
                    ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                    return;
                }
                if (enumC0699nM3160a != EnumC0699n.ANICON) {
                    getActivity().startActivity(new Intent("android.intent.action.VIEW"));
                    return;
                }
                return;
            }
            if ((view.getId() == R.id.imageRcvContent && enumC0699nM3160a != EnumC0699n.ANICON) || view.getId() == R.id.download_completed) {
                if (string3 == null || string3.length() == 0 || ((i == 0 && string3.contains("thumbnail")) || ((i == 1 && string3.contains("thumbnail")) || C0452a.f1724c.equals(string3) || (i == 0 && C1767bw.m6002a())))) {
                    if ((enumC0699nM3160a == EnumC0699n.VIDEO && !C1767bw.m6002a()) || (enumC0699nM3160a == EnumC0699n.AUDIO && !C1767bw.m6002a())) {
                        Toast.makeText(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    }
                    if (!C0777a.m3326a().m3328a(j)) {
                        C0777a.m3326a().m3327a(view2, this, this.f1780U, positionForView, string2, false, string, j, enumC0699nM3160a, this.f1765F, string4);
                    }
                    if (enumC0699nM3160a == EnumC0699n.IMAGE) {
                        ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                        return;
                    }
                    this.f1842bE.show();
                    this.f1842bE.setProgress(0);
                    AsyncTaskC0608x asyncTaskC0608xM3330b = C0777a.m3326a().m3330b(j);
                    if (asyncTaskC0608xM3330b != null) {
                        asyncTaskC0608xM3330b.m2790a(this.f1842bE);
                        return;
                    }
                    return;
                }
                ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                return;
            }
            if ((view.getId() == R.id.imageEtcSndContent || view.getId() == R.id.lLayoutSndContent) && enumC0699nM3160a != EnumC0699n.ANICON) {
                if (enumC0699nM3160a == EnumC0699n.CALENDAR) {
                    if (!C1767bw.m6002a()) {
                        Toast.makeText(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    }
                    if (string3 != null) {
                        if (this.f1863bZ != null) {
                            this.f1863bZ.show();
                        }
                        Intent intent = new Intent(getActivity(), (Class<?>) VCalendarDetailActivity2.class);
                        intent.putExtra("ACTIVITY_PURPOSE", 3);
                        intent.putExtra("URI", string3);
                        getActivity().startActivity(intent);
                        return;
                    }
                    return;
                }
                if (enumC0699nM3160a == EnumC0699n.CONTACT) {
                    if (!C1767bw.m6002a()) {
                        Toast.makeText(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    } else {
                        if (!f1744c) {
                            ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                            f1744c = true;
                            return;
                        }
                        return;
                    }
                }
                if (enumC0699nM3160a == EnumC0699n.GEO) {
                    ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string2, this.f1830as, j);
                    return;
                }
                if (enumC0699nM3160a == EnumC0699n.AUDIO) {
                    if (!C1767bw.m6002a()) {
                        Toast.makeText(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    } else {
                        ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                        return;
                    }
                }
                if (enumC0699nM3160a == EnumC0699n.DOCUMENT) {
                    ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                    return;
                } else {
                    ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                    return;
                }
            }
            if ((view.getId() == R.id.imageEtcContent || view.getId() == R.id.lLayoutRcvContent || view.getId() == R.id.download_completed) && enumC0699nM3160a != EnumC0699n.ANICON) {
                if (string3 == null || string3.length() == 0 || C0452a.f1724c.equals(string3) || string3.contains("thumbnail") || ((!C1767bw.m6002a() && i == 1) || (C1767bw.m6002a() && i == 0))) {
                    if (enumC0699nM3160a == EnumC0699n.GEO) {
                        if (!C0452a.m2468a()) {
                            Toast.makeText(getActivity(), R.string.toast_googleMAP_unavailable, 0).show();
                            return;
                        } else {
                            ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string2, this.f1830as, j);
                            return;
                        }
                    }
                    if (enumC0699nM3160a == EnumC0699n.AUDIO && !C1767bw.m6002a()) {
                        Toast.makeText(getActivity(), R.string.sdcard_not_found, 0).show();
                        return;
                    }
                    if (!C0777a.m3326a().m3328a(j)) {
                        C0777a.m3326a().m3327a(view2, this, this.f1780U, positionForView, string2, false, string, j, enumC0699nM3160a, this.f1765F, string4);
                    }
                    if (enumC0699nM3160a == EnumC0699n.IMAGE) {
                        ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                        return;
                    }
                    this.f1842bE.show();
                    this.f1842bE.setProgress(0);
                    AsyncTaskC0608x asyncTaskC0608xM3330b2 = C0777a.m3326a().m3330b(j);
                    if (asyncTaskC0608xM3330b2 != null) {
                        asyncTaskC0608xM3330b2.m2790a(this.f1842bE);
                        return;
                    }
                    return;
                }
                if (enumC0699nM3160a == EnumC0699n.CALENDAR && this.f1863bZ != null) {
                    this.f1863bZ.show();
                }
                ViewOnClickListenerC0477as.m2630a(this, enumC0699nM3160a, string3, this.f1830as, j);
                return;
            }
            this.f1846bI.hideSoftInputFromWindow(this.f1800aO.getWindowToken(), 0);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public void allowWithPush(String str, int i, String str2, String str3, EnumC0695j enumC0695j) {
        if (enumC0695j == EnumC0695j.BROADCAST || str3 == null || "null".equals(str3)) {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            C0639k c0639kM2904a = C0639k.m2904a(this.f1780U, strValueOf, enumC0695j);
            if (c0639kM2904a != null) {
                c0639kM2904a.m2947a(strValueOf, str, i);
                c0639kM2904a.m2944a(true);
                c0639kM2904a.m2951c(this.f1912z);
                this.f1831at.m2930a(Long.MAX_VALUE);
                c0639kM2904a.m2945a(EnumC0695j.BROADCAST, str2, this.f1836ay, str3, this.f1912z);
                return;
            }
            return;
        }
        this.f1831at.m2954f();
        this.f1831at.m2947a(this.f1912z, str, i);
        this.f1831at.m2945a(enumC0695j, str2, this.f1836ay, str3, this.f1912z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2512a(String str, EnumC0699n enumC0699n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f1834aw.size(); i++) {
            sb.append("+" + ((String) this.f1834aw.get(i)) + ";");
        }
        Intent intentM6157a = C1816b.m6157a(sb.substring(0, sb.length() - 1), str);
        startActivity(intentM6157a);
        startActivity(intentM6157a);
    }

    @Override // com.sec.chaton.chat.InterfaceC0496bj
    /* renamed from: a */
    public void mo2591a(View view, long j, EnumC0699n enumC0699n) {
        C0779c.m3335a().m3340b(j);
        m2569s();
    }

    @Override // com.sec.chaton.chat.InterfaceC0496bj
    /* renamed from: a */
    public void mo2590a(View view, long j) {
        C0777a.m3326a().m3331c(j);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
    }

    @Override // com.sec.chaton.chat.InterfaceC0496bj
    /* renamed from: a */
    public void mo2593a(View view, ProfileImageView profileImageView, String str, String str2) {
        Intent intent = new Intent(getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", str);
        intent.putExtra("PROFILE_BUDDY_NAME", str2);
        intent.setFlags(67108864);
        startActivityForResult(intent, 20);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f3  */
    @Override // com.sec.chaton.p020f.InterfaceC0718f
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo2602a(java.lang.Object r8, int r9) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.mo2602a(java.lang.Object, int):boolean");
    }

    /* renamed from: a */
    public void m2587a(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f1823al.getLayoutParams());
        layoutParams.addRule(0, R.id.btnDelete);
        layoutParams.setMargins(0, (int) C1722ae.m5895b(2.0f), 0, 0);
        layoutParams.width = (int) C1722ae.m5895b(i);
        this.f1823al.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f1821aj.getLayoutParams());
        layoutParams2.addRule(0, R.id.btnDelCancel);
        layoutParams2.setMargins((int) C1722ae.m5895b(12.0f), (int) C1722ae.m5895b(2.0f), 0, 0);
        layoutParams2.width = (int) C1722ae.m5895b(i);
        this.f1821aj.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f1822ak.getLayoutParams());
        layoutParams3.addRule(11);
        layoutParams3.setMargins((int) C1722ae.m5895b(12.0f), (int) C1722ae.m5895b(2.0f), (int) C1722ae.m5895b(12.0f), 0);
        layoutParams3.width = (int) C1722ae.m5895b(i);
        this.f1822ak.setLayoutParams(layoutParams3);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1818ag = true;
        if (GlobalApplication.m3265f()) {
            if (configuration.orientation == 2) {
                m2587a(125);
            } else if (configuration.orientation == 1) {
                m2587a(85);
            }
        }
        m2511a(this.f1786aA, TextView.BufferType.NORMAL);
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        C1786r.m6064d("w:" + defaultDisplay.getWidth());
        C1786r.m6064d("h:" + defaultDisplay.getHeight());
        new Timer(true).schedule(new C0462ad(this, new Handler()), 300L);
        if (this.f1891cb != null && this.f1891cb.isShowing()) {
            this.f1891cb.m3190a();
        } else {
            this.f1891cb = null;
        }
        m2511a(this.f1786aA, (TextView.BufferType) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2511a(String str, TextView.BufferType bufferType) {
        String str2;
        if (str != null) {
            String strReplace = str.replace(",", ", ");
            int i = 30;
            int i2 = 25;
            if (this.f1843bF) {
                i = 20;
                i2 = 18;
            }
            if (GlobalApplication.m3260b().getResources().getConfiguration().orientation != 1 || strReplace.length() <= i) {
                str2 = strReplace;
            } else {
                String strSubstring = "";
                if (strReplace.contains("(") && strReplace.contains(")")) {
                    strSubstring = strReplace.substring(strReplace.length() - 4);
                }
                str2 = strReplace.substring(0, i2) + "..." + strSubstring;
            }
            this.f1801aP.setText(str2);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0454a
    public boolean isBackKeyIgnore() {
        if (this.f1827ap.getChoiceMode() == 2) {
            this.f1827ap.setChoiceMode(0);
            this.f1827ap.setTranscriptMode(2);
            BaseActivity.m1827a(this, true);
            this.f1827ap.clearChoices();
            this.f1902o.setVisibility(8);
            this.f1903p.setVisibility(8);
            this.f1848bK.setVisibility(8);
            this.f1904q.setVisibility(0);
            this.f1905r.setVisibility(0);
            return false;
        }
        if (!this.f1909w) {
            return true;
        }
        this.f1852bO.setVisibility(8);
        this.f1909w = false;
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        C1786r.m6064d("onContextItemSelected!!!!");
        return super.onContextItemSelected(menuItem);
    }

    /* renamed from: r */
    private void m2566r() {
        if (this.f1882bs != null) {
            this.f1882bs.recycle();
            this.f1882bs = null;
        }
        if (this.f1883bt != null) {
            this.f1883bt.recycle();
            this.f1883bt = null;
        }
        if (this.f1884bu != null) {
            this.f1884bu.recycle();
            this.f1884bu = null;
        }
        if (this.f1885bv != null) {
            this.f1885bv.recycle();
            this.f1885bv = null;
        }
        if (this.f1886bw != null) {
            this.f1886bw.recycle();
            this.f1886bw = null;
        }
        if (this.f1887bx != null) {
            this.f1887bx.recycle();
            this.f1887bx = null;
        }
        if (this.f1888by != null) {
            this.f1888by.recycle();
            this.f1888by = null;
        }
        if (this.f1889bz != null) {
            this.f1889bz.recycle();
            this.f1889bz = null;
        }
        if (this.f1838bA != null) {
            this.f1838bA.recycle();
            this.f1838bA = null;
        }
        if (this.f1839bB != null) {
            this.f1839bB.recycle();
            this.f1839bB = null;
        }
        if (this.f1840bC != null) {
            this.f1840bC.recycle();
            this.f1840bC = null;
        }
        if (this.f1882bs != null) {
            this.f1882bs.recycle();
            this.f1882bs = null;
        }
        if (this.f1881br != null) {
            this.f1881br.recycle();
            this.f1881br = null;
        }
        this.f1871bh = null;
        this.f1872bi = null;
        this.f1873bj = null;
        this.f1874bk = null;
        this.f1875bl = null;
        this.f1876bm = null;
        this.f1877bn = null;
        this.f1878bo = null;
        this.f1879bp = null;
        this.f1880bq = null;
        if (this.f1850bM != null) {
            this.f1850bM.setBackgroundDrawable(null);
        }
        System.gc();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f1852bO.setVisibility(8);
        this.f1852bO = null;
        Cursor cursor = this.f1828aq.getCursor();
        if (cursor != null) {
            cursor.close();
        }
        if (this.f1829ar != null) {
            this.f1829ar.close();
            this.f1829ar = null;
        }
        this.f1828aq = null;
        m2566r();
        this.f1846bI.hideSoftInputFromWindow(this.f1800aO.getApplicationWindowToken(), 0);
        super.onDestroy();
    }

    /* renamed from: a */
    public AlertDialog.Builder m2584a(EnumC0104e enumC0104e) {
        this.f1858bU = new AlertDialog.Builder(getActivity());
        if (enumC0104e == EnumC0104e.END_APP) {
            this.f1858bU.setMessage(R.string.provision_error_end).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0464af(this));
            return this.f1858bU;
        }
        if (enumC0104e == EnumC0104e.RESTART_APP) {
            this.f1858bU.setMessage(R.string.auth_error_restart).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0465ag(this));
            return this.f1858bU;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m2532d(String str) {
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_msg_box);
        if (fragmentFindFragmentById instanceof MsgboxFragment) {
            ((MsgboxFragment) fragmentFindFragmentById).m3533a(this.f1912z);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public void setPreviewText(int i) {
        this.f1895cg += i;
        this.f1783X.startQuery(0, null, C0698m.m3148a(this.f1895cg), null, "message_inbox_no=?", new String[]{this.f1912z}, null);
        this.f1890ca.setVisibility(0);
    }

    /* renamed from: f */
    public void m2608f() {
        if (this.f1827ap != null) {
            this.f1827ap.setTranscriptMode(2);
            this.f1772M = true;
        }
        this.f1890ca.setVisibility(4);
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public C1798b getMenu() {
        return this.f1853bP;
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public AdapterView.OnItemSelectedListener getMenuListener() {
        return this.f1773N;
    }

    /* renamed from: g */
    public void m2609g() {
        StringBuilder sb = new StringBuilder();
        boolean zM3024a = C0660d.m3024a(getActivity(), this.f1912z);
        Iterator it = this.f1835ax.entrySet().iterator();
        while (it.hasNext()) {
            C0100a c0100a = (C0100a) ((Map.Entry) it.next()).getValue();
            if (zM3024a) {
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.MEMBER.m3171a()), c0100a.m656b(), C0493bg.m2684a(C0657a.m2983c(getActivity().getContentResolver(), c0100a.m656b()))));
            } else {
                String strM2507a = m2507a(c0100a.m654a(), this.f1912z);
                String strM656b = strM2507a == null ? c0100a.m656b() : strM2507a;
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.MEMBER.m3171a()), strM656b, C0493bg.m2684a(strM656b)));
            }
            if (this.f1765F != EnumC0695j.ONETOONE && !it.hasNext()) {
                sb.append(" (").append(this.f1834aw.size()).append(")");
            }
            sb.append(";");
        }
        C0665i.m3071b(getActivity().getContentResolver(), this.f1912z, sb.toString());
    }

    /* renamed from: a */
    private String m2507a(String str, String str2) {
        Cursor cursorQuery = getActivity().getContentResolver().query(C0698m.f2626a, new String[]{"message_content"}, "message_inbox_no='" + str2 + "'", null, null);
        if (cursorQuery != null) {
            String strM2689b = null;
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
                if (string != null) {
                    String[] strArrSplit = string.split(";");
                    if (strArrSplit.length > 0) {
                        int length = strArrSplit.length;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                String[] strArrSplit2 = strArrSplit[i].split(",");
                                if (strArrSplit2.length > 2) {
                                    try {
                                        if (strArrSplit2[1].trim().equals(str)) {
                                            strM2689b = C0493bg.m2689b(strArrSplit2[2].replace('\n', ' '));
                                            break;
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                                i++;
                            }
                        }
                    }
                }
            }
            cursorQuery.close();
            if (strM2689b != null) {
                return strM2689b;
            }
        }
        return null;
    }

    /* renamed from: s */
    private void m2569s() {
        C1786r.m6061b("setChatForwardCancel invoked", getClass().getSimpleName());
        this.f1867bd = false;
        this.f1810aY = -1;
        this.f1811aZ = null;
        this.f1864ba = null;
        if (this.f1854bQ.containsKey("content_type")) {
            getActivity().getIntent().removeExtra("content_type");
        }
        if (this.f1854bQ.containsKey("download_uri")) {
            getActivity().getIntent().removeExtra("download_uri");
        }
        if (this.f1854bQ.containsKey("sub_content")) {
            getActivity().getIntent().removeExtra("sub_content");
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC0967m
    /* renamed from: a */
    public void mo2599a(String str) {
        int selectionStart = this.f1800aO.getSelectionStart();
        int selectionEnd = this.f1800aO.getSelectionEnd();
        CharSequence charSequenceM3828b = C0968n.m3828b(getActivity(), str, (int) (this.f1800aO.getLineHeight() * 1.2f));
        if ((this.f1800aO.getText().length() + charSequenceM3828b.length()) - (selectionEnd - selectionStart) >= 2000) {
            Toast.makeText(GlobalApplication.m3260b(), R.string.toast_text_max_Length, 0).show();
        } else {
            this.f1800aO.getEditableText().replace(selectionStart, selectionEnd, charSequenceM3828b, 0, charSequenceM3828b.length());
            this.f1800aO.setSelection(charSequenceM3828b.length() + selectionStart, selectionStart + charSequenceM3828b.length());
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC0967m
    /* renamed from: b */
    public void mo2604b(String str) {
        this.f1852bO.setVisibility(8);
        this.f1909w = false;
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            Toast.makeText(getActivity(), R.string.toast_network_unable, 0).show();
            return;
        }
        boolean z = TextUtils.isEmpty(this.f1766G) || "null".equals(this.f1766G);
        this.f1772M = true;
        this.f1827ap.setTranscriptMode(2);
        this.f1831at.m2948b(-1L, this.f1765F, this.f1766G, (String[]) this.f1834aw.toArray(new String[this.f1834aw.size()]), z, str, -1L);
    }

    /* renamed from: a */
    public String m2585a(Cursor cursor) {
        switch (C0466ah.f1933a[EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type"))).ordinal()]) {
            case 2:
                return getString(R.string.dialog_header_text);
            case 3:
                return getString(R.string.anicon_download_list_title);
            case 4:
            default:
                return "";
            case 5:
                return getString(R.string.media_photo);
            case 6:
                return getString(R.string.media_video);
            case 7:
                return getString(R.string.media_map);
            case 8:
                return getString(R.string.media_voice);
            case 9:
                return getString(R.string.media_contact);
            case 10:
                return getString(R.string.media_calendar);
            case 11:
                return getString(R.string.menu_multimedia_file);
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC0967m
    /* renamed from: h */
    public void mo2610h() {
        this.f1852bO.setVisibility(8);
        this.f1909w = false;
    }

    /* renamed from: a */
    public long m2582a(File file, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2) {
        if (file.length() > 10485760) {
            C2153y.m7535a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
            return -1L;
        }
        this.f1827ap.setSelectionFromTop(this.f1827ap.getCount(), 0);
        this.f1772M = true;
        this.f1827ap.setTranscriptMode(2);
        return this.f1831at.m2927a(file, enumC0699n, enumC0695j, str, strArr, z, str2);
    }

    /* renamed from: a */
    public long m2583a(File file, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, String str3) {
        if (file.length() > 10485760) {
            C2153y.m7535a(getActivity(), R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
            return -1L;
        }
        this.f1827ap.setSelectionFromTop(this.f1827ap.getCount(), 0);
        this.f1772M = true;
        this.f1827ap.setTranscriptMode(2);
        return this.f1831at.m2928a(file, enumC0699n, enumC0695j, str, strArr, z, str2, str3);
    }

    /* renamed from: e */
    private boolean m2538e(String str) {
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        while (matcher.find()) {
            str = str.replace(matcher.group(), "");
        }
        return str.length() == 0;
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public boolean enableAutoScroll() {
        return this.f1772M;
    }

    /* renamed from: t */
    private void m2571t() {
        this.f1802aQ = C1789u.m6075a().getString("setting_change_skin", "-1");
        this.f1803aR = C1789u.m6075a().getString("setting_change_skin_type", "pa");
        this.f1804aS = C1789u.m6075a().getString("Default Font Size", "");
        this.f1805aT = C1789u.m6075a().getString("setting_change_bubble_send", "-1");
        this.f1806aU = C1789u.m6075a().getString("setting_change_bubble_receive", "-1");
        this.f1808aW = C1789u.m6075a().getBoolean("Setting enter key", false);
        m2611i();
        if (C1786r.f6452b) {
            C1786r.m6061b("Preference information for chat room.", f1742a);
            C1786r.m6061b(C1828c.m6207a(" > Skin Id: ", this.f1802aQ), f1742a);
            C1786r.m6061b(C1828c.m6207a(" > Font Size: ", this.f1804aS), f1742a);
            C1786r.m6061b(C1828c.m6207a(" > Send Bubble: ", this.f1805aT), f1742a);
            C1786r.m6061b(C1828c.m6207a(" > Receive Bubble: ", this.f1806aU), f1742a);
            C1786r.m6061b(C1828c.m6207a(" > Send With Enter: ", Boolean.valueOf(this.f1808aW)), f1742a);
        }
    }

    /* renamed from: i */
    public void m2611i() {
        if (this.f1802aQ.equals("skin_01")) {
            this.f1802aQ = "-1";
        } else if (this.f1802aQ.equals("skin_bg_02")) {
            this.f1802aQ = "-2";
        } else if (this.f1802aQ.equals("skin_bg_03")) {
            this.f1802aQ = "-3";
        } else if (this.f1802aQ.equals("skin_bg_04")) {
            this.f1802aQ = "-4";
        }
        if (this.f1805aT.equals("bubble_01")) {
            this.f1805aT = "-1";
        } else if (this.f1805aT.equals("bubble_02")) {
            this.f1805aT = "-2";
        } else if (this.f1805aT.equals("bubble_03")) {
            this.f1805aT = "-3";
        } else if (this.f1805aT.equals("bubble_04")) {
            this.f1805aT = "-4";
        }
        if (!this.f1806aU.equals("bubble_01")) {
            if (!this.f1806aU.equals("bubble_02")) {
                if (!this.f1806aU.equals("bubble_03")) {
                    if (this.f1806aU.equals("bubble_04")) {
                        this.f1806aU = "-4";
                        return;
                    }
                    return;
                }
                this.f1806aU = "-3";
                return;
            }
            this.f1806aU = "-2";
            return;
        }
        this.f1806aU = "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m2573u() {
        this.f1828aq.m2666a(this.f1805aT, this.f1806aU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m2575v() {
        if (this.f1764E == null) {
            m2577w();
        } else if (!this.f1764E.equals(this.f1802aQ)) {
            m2579x();
            m2577w();
        } else {
            return;
        }
        this.f1764E = this.f1802aQ;
    }

    /* renamed from: w */
    private void m2577w() {
        this.f1807aV = m2540f(this.f1802aQ);
        if (this.f1807aV != null) {
            if (this.f1803aR.equals("pa")) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f1807aV);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                this.f1850bM.setBackgroundDrawable(bitmapDrawable);
                return;
            }
            this.f1850bM.setImageBitmap(this.f1807aV);
            return;
        }
        m2612j();
    }

    /* renamed from: j */
    public void m2612j() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f1850bM.setBackgroundDrawable(bitmapDrawable);
    }

    /* renamed from: x */
    private void m2579x() {
        if (this.f1807aV != null) {
            this.f1850bM.setImageBitmap(null);
            this.f1807aV.recycle();
            this.f1807aV = null;
        }
    }

    /* renamed from: f */
    private Bitmap m2540f(String str) {
        if ("skin_myskin.png_".equals(str)) {
            if (getResources().getConfiguration().orientation == 2) {
                return C1791w.m6084a(getActivity(), C1816b.m6159b(), C1816b.m6160c(), (int) C1722ae.m5894a(59.0f));
            }
            return C1791w.m6098b(getActivity(), C1816b.m6159b(), C1816b.m6160c(), (int) C1722ae.m5894a(59.0f));
        }
        C1012j c1012jM3949f = C1003c.m3949f(getActivity(), this.f1802aQ);
        if (c1012jM3949f == null) {
            return null;
        }
        return c1012jM3949f.f3710b;
    }
}
