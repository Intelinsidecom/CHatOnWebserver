package com.sec.chaton.chat;

import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.motion.MotionRecognitionManager;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.sec.multiwindow.MultiWindowManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.sec.chaton.C2310s;
import com.sec.chaton.EnumC3073u;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC0459d;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.chat.p023a.AbstractC0888a;
import com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x;
import com.sec.chaton.chat.p023a.C0902f;
import com.sec.chaton.chat.p023a.C0910n;
import com.sec.chaton.chat.p023a.InterfaceC0907k;
import com.sec.chaton.chat.p023a.InterfaceC0908l;
import com.sec.chaton.chat.p023a.InterfaceC0909m;
import com.sec.chaton.chat.p023a.InterfaceC0911o;
import com.sec.chaton.chat.p023a.InterfaceC0912p;
import com.sec.chaton.chat.p024b.C0951b;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.chat.p024b.C0958i;
import com.sec.chaton.chat.p024b.C0963n;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.multimedia.audio.AsyncTaskC1779k;
import com.sec.chaton.multimedia.audio.C1769a;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.multimedia.audio.VoiceListActivity;
import com.sec.chaton.multimedia.doc.EnumC1794a;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.multimedia.emoticon.C1833h;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.multimedia.emoticon.EmoticonSelectionView;
import com.sec.chaton.multimedia.emoticon.InterfaceC1834i;
import com.sec.chaton.multimedia.emoticon.ams.EnumC1807d;
import com.sec.chaton.multimedia.emoticon.anicon.C1821k;
import com.sec.chaton.multimedia.geotag.GeotagActivity;
import com.sec.chaton.multimedia.image.C1874c;
import com.sec.chaton.multimedia.image.ImagePagerActivity;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.multimedia.p048a.AsyncTaskC1767a;
import com.sec.chaton.multimedia.text.DetailTextView;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcalendar.VCalendarListActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.multimedia.vcard.VCardReadContactActivity;
import com.sec.chaton.p016a.p017a.C0264a;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1414e;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p030f.C1478g;
import com.sec.chaton.p030f.DialogC1472a;
import com.sec.chaton.p030f.InterfaceC1477f;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.p035io.entry.MessageType4Entry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.p040c.AsyncTaskC1557c;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.p037j.p040c.RunnableC1563i;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.settings.EnumC2504dk;
import com.sec.chaton.settings.downloads.C2570bj;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.settings.downloads.C2598ck;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings.downloads.EnumC2651z;
import com.sec.chaton.specialbuddy.C2930k;
import com.sec.chaton.trunk.p058a.C2949a;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3175aq;
import com.sec.chaton.util.C3188bc;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3238m;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3246u;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3208bw;
import com.sec.chaton.widget.AlertDialogC3256c;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import com.sec.spp.push.Config;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import com.sec.widget.HeightChangedListView;
import com.sec.widget.InterfaceC3643ak;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Timer;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.p072a.p073a.p074a.p075a.C3702j;
import twitter4j.Query;

/* loaded from: classes.dex */
public class ChatFragment extends Fragment implements MediaPlayer.OnCompletionListener, View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC0459d, InterfaceC1091ff, InterfaceC1093fh, InterfaceC1477f, InterfaceC1834i, InterfaceC3643ak {

    /* renamed from: A */
    String f3499A;

    /* renamed from: C */
    public ProgressDialog f3501C;

    /* renamed from: D */
    public ProgressDialog f3502D;

    /* renamed from: I */
    public boolean f3507I;

    /* renamed from: J */
    DialogC1472a f3508J;

    /* renamed from: K */
    ArrayList<C1478g> f3509K;

    /* renamed from: aA */
    private LinearLayout f3525aA;

    /* renamed from: aB */
    private HeightChangedListView f3526aB;

    /* renamed from: aC */
    private C1067ei f3527aC;

    /* renamed from: aD */
    private Toast f3528aD;

    /* renamed from: aF */
    private C1337o f3530aF;

    /* renamed from: aG */
    private C2949a f3531aG;

    /* renamed from: aL */
    private ArrayList<String> f3536aL;

    /* renamed from: aM */
    private HashMap<String, C0264a> f3537aM;

    /* renamed from: aN */
    private Long f3538aN;

    /* renamed from: aO */
    private String f3539aO;

    /* renamed from: aP */
    private String f3540aP;

    /* renamed from: aQ */
    private String f3541aQ;

    /* renamed from: aR */
    private String f3542aR;

    /* renamed from: aS */
    private String f3543aS;

    /* renamed from: aT */
    private String f3544aT;

    /* renamed from: aU */
    private String f3545aU;

    /* renamed from: aV */
    private String f3546aV;

    /* renamed from: aY */
    private int f3549aY;

    /* renamed from: aZ */
    private int f3550aZ;

    /* renamed from: aa */
    private C1377u f3551aa;

    /* renamed from: ab */
    private Menu f3552ab;

    /* renamed from: ad */
    private C0045a f3554ad;

    /* renamed from: ah */
    private LinearLayout f3558ah;

    /* renamed from: ai */
    private ImageView f3559ai;

    /* renamed from: aj */
    private ImageView f3560aj;

    /* renamed from: ak */
    private ImageButton f3561ak;

    /* renamed from: al */
    private boolean f3562al;

    /* renamed from: an */
    private String f3564an;

    /* renamed from: ao */
    private String f3565ao;

    /* renamed from: ap */
    private ImageButton f3566ap;

    /* renamed from: aq */
    private ImageButton f3567aq;

    /* renamed from: ar */
    private CheckedTextView f3568ar;

    /* renamed from: as */
    private FrameLayout f3569as;

    /* renamed from: at */
    private FrameLayout f3570at;

    /* renamed from: au */
    private View f3571au;

    /* renamed from: av */
    private LinearLayout f3572av;

    /* renamed from: aw */
    private Button f3573aw;

    /* renamed from: ax */
    private Button f3574ax;

    /* renamed from: ay */
    private Button f3575ay;

    /* renamed from: az */
    private TextView f3576az;

    /* renamed from: b */
    View f3577b;

    /* renamed from: bD */
    private Bitmap f3581bD;

    /* renamed from: bE */
    private ImageButton f3582bE;

    /* renamed from: bF */
    private ImageButton f3583bF;

    /* renamed from: bG */
    private InputMethodManager f3584bG;

    /* renamed from: bH */
    private ImageView f3585bH;

    /* renamed from: bI */
    private ViewGroup f3586bI;

    /* renamed from: bJ */
    private EmoticonSelectionView f3587bJ;

    /* renamed from: bK */
    private Bundle f3588bK;

    /* renamed from: bL */
    private int f3589bL;

    /* renamed from: bM */
    private AbstractC3271a f3590bM;

    /* renamed from: bN */
    private View f3591bN;

    /* renamed from: bV */
    private String f3599bV;

    /* renamed from: bW */
    private C3326c f3600bW;

    /* renamed from: bX */
    private AlertDialogC3256c f3601bX;

    /* renamed from: bY */
    private Intent f3602bY;

    /* renamed from: bZ */
    private ImageButton f3603bZ;

    /* renamed from: bc */
    private String f3606bc;

    /* renamed from: bd */
    private int f3607bd;

    /* renamed from: be */
    private Uri f3608be;

    /* renamed from: bf */
    private boolean f3609bf;

    /* renamed from: bg */
    private boolean f3610bg;

    /* renamed from: bh */
    private long f3611bh;

    /* renamed from: bi */
    private boolean f3612bi;

    /* renamed from: bj */
    private MyEditText f3613bj;

    /* renamed from: bk */
    private String f3614bk;

    /* renamed from: bl */
    private String f3615bl;

    /* renamed from: bm */
    private String f3616bm;

    /* renamed from: bn */
    private String f3617bn;

    /* renamed from: bo */
    private String f3618bo;

    /* renamed from: bp */
    private String f3619bp;

    /* renamed from: bq */
    private boolean f3620bq;

    /* renamed from: br */
    private boolean f3621br;

    /* renamed from: bs */
    private int f3622bs;

    /* renamed from: bt */
    private String f3623bt;

    /* renamed from: bu */
    private String f3624bu;

    /* renamed from: bv */
    private String f3625bv;

    /* renamed from: bw */
    private boolean f3626bw;

    /* renamed from: bx */
    private String f3627bx;

    /* renamed from: c */
    ProfileImageView f3630c;

    /* renamed from: cE */
    private View f3635cE;

    /* renamed from: cF */
    private View f3636cF;

    /* renamed from: cG */
    private ImageView f3637cG;

    /* renamed from: cH */
    private ViewGroup f3638cH;

    /* renamed from: cI */
    private TextView f3639cI;

    /* renamed from: cJ */
    private TextView f3640cJ;

    /* renamed from: cK */
    private LinearLayout f3641cK;

    /* renamed from: cL */
    private View f3642cL;

    /* renamed from: cM */
    private String f3643cM;

    /* renamed from: cN */
    private String f3644cN;

    /* renamed from: cS */
    private boolean f3647cS;

    /* renamed from: cT */
    private boolean f3648cT;

    /* renamed from: cU */
    private ImageView f3649cU;

    /* renamed from: cV */
    private ImageView f3650cV;

    /* renamed from: cW */
    private String f3651cW;

    /* renamed from: cX */
    private String f3652cX;

    /* renamed from: cY */
    private String f3653cY;

    /* renamed from: cZ */
    private CallableC1073eo f3654cZ;

    /* renamed from: ca */
    private LinearLayout f3655ca;

    /* renamed from: cb */
    private AsyncTaskC1779k f3656cb;

    /* renamed from: cc */
    private FrameLayout f3657cc;

    /* renamed from: cd */
    private LinearLayout f3658cd;

    /* renamed from: ce */
    private DataSetObserver f3659ce;

    /* renamed from: cf */
    private C1769a f3660cf;

    /* renamed from: ci */
    private LinearLayout f3663ci;

    /* renamed from: cj */
    private ImageView f3664cj;

    /* renamed from: ck */
    private TextView f3665ck;

    /* renamed from: cl */
    private Dialog f3666cl;

    /* renamed from: cm */
    private String f3667cm;

    /* renamed from: cn */
    private String f3668cn;

    /* renamed from: co */
    private String f3669co;

    /* renamed from: cp */
    private C3702j<EnumC1455w, AbstractC0888a> f3670cp;

    /* renamed from: cq */
    private ArrayList<PreviewData> f3671cq;

    /* renamed from: cr */
    private Activity f3672cr;

    /* renamed from: cs */
    private String f3673cs;

    /* renamed from: cw */
    private View.OnDragListener f3677cw;

    /* renamed from: cx */
    private View.OnDragListener f3678cx;

    /* renamed from: cy */
    private int f3679cy;

    /* renamed from: cz */
    private String f3680cz;

    /* renamed from: d */
    TextView f3681d;

    /* renamed from: de */
    private C1078et f3685de;

    /* renamed from: dg */
    private RelativeLayout f3687dg;

    /* renamed from: dh */
    private boolean f3688dh;

    /* renamed from: di */
    private SlookAirButton f3689di;

    /* renamed from: dj */
    private SlookAirButton f3690dj;

    /* renamed from: dk */
    private SlookAirButton f3691dk;

    /* renamed from: dm */
    private AsyncTaskC1041dj f3693dm;

    /* renamed from: dn */
    private Bitmap f3694dn;

    /* renamed from: dp */
    private ArrayList<String> f3696dp;

    /* renamed from: r */
    public String f3703r;

    /* renamed from: s */
    public String f3704s;

    /* renamed from: x */
    EnumC1450r f3709x;

    /* renamed from: y */
    String f3710y;

    /* renamed from: z */
    int f3711z;

    /* renamed from: a */
    public static final String f3484a = ChatFragment.class.getSimpleName();

    /* renamed from: e */
    public static String f3488e = "extra fileuri";

    /* renamed from: f */
    public static String f3489f = "extra participant";

    /* renamed from: g */
    public static String f3490g = "extra title";

    /* renamed from: h */
    public static String f3491h = "extra vcalendar";

    /* renamed from: i */
    public static String f3492i = "extra vard name";

    /* renamed from: j */
    public static String f3493j = "extra initchat";

    /* renamed from: k */
    public static String f3494k = "extra showinput";

    /* renamed from: l */
    public static String f3495l = "extra chagetitle";

    /* renamed from: m */
    public static String f3496m = "extra invite";

    /* renamed from: n */
    public static String f3497n = "extra inbox nobi";

    /* renamed from: o */
    static boolean f3498o = false;

    /* renamed from: cP */
    private static String f3485cP = "Korean";

    /* renamed from: cQ */
    private static String f3486cQ = "English US";

    /* renamed from: dd */
    private static String f3487dd = null;

    /* renamed from: Z */
    private Object f3524Z = new Object();

    /* renamed from: ac */
    private boolean f3553ac = false;

    /* renamed from: ae */
    private File f3555ae = null;

    /* renamed from: af */
    private EnumC1455w f3556af = null;

    /* renamed from: ag */
    private EnumC1807d f3557ag = null;

    /* renamed from: am */
    private boolean f3563am = false;

    /* renamed from: p */
    public boolean f3701p = false;

    /* renamed from: q */
    public Boolean f3702q = false;

    /* renamed from: aE */
    private ProgressDialog f3529aE = null;

    /* renamed from: aH */
    private int f3532aH = 0;

    /* renamed from: aI */
    private String f3533aI = null;

    /* renamed from: aJ */
    private String f3534aJ = null;

    /* renamed from: aK */
    private boolean f3535aK = false;

    /* renamed from: t */
    public boolean f3705t = true;

    /* renamed from: u */
    public boolean f3706u = false;

    /* renamed from: v */
    public String f3707v = "";

    /* renamed from: w */
    public int f3708w = 0;

    /* renamed from: aW */
    private long f3547aW = 0;

    /* renamed from: aX */
    private String f3548aX = "0";

    /* renamed from: ba */
    private boolean f3604ba = false;

    /* renamed from: bb */
    private boolean f3605bb = false;

    /* renamed from: by */
    private boolean f3628by = false;

    /* renamed from: bz */
    private boolean f3629bz = false;

    /* renamed from: bA */
    private boolean f3578bA = false;

    /* renamed from: bB */
    private boolean f3579bB = false;

    /* renamed from: bC */
    private EnumC3073u f3580bC = EnumC3073u.INSIDE;

    /* renamed from: B */
    ArrayList<C0513c> f3500B = new ArrayList<>();

    /* renamed from: E */
    public boolean f3503E = true;

    /* renamed from: bO */
    private int f3592bO = 0;

    /* renamed from: bP */
    private boolean f3593bP = true;

    /* renamed from: bQ */
    private boolean f3594bQ = false;

    /* renamed from: bR */
    private final int f3595bR = 30;

    /* renamed from: bS */
    private final int f3596bS = 20;

    /* renamed from: bT */
    private int f3597bT = 30;

    /* renamed from: bU */
    private boolean f3598bU = true;

    /* renamed from: F */
    InterfaceC3274d f3504F = null;

    /* renamed from: G */
    InterfaceC3274d f3505G = null;

    /* renamed from: H */
    String f3506H = null;

    /* renamed from: cg */
    private final String f3661cg = "TRANS_FAIL";

    /* renamed from: ch */
    private final String f3662ch = "RECV_SUCC";

    /* renamed from: ct */
    private Bitmap f3674ct = null;

    /* renamed from: cu */
    private String f3675cu = C3223ck.m11329c() + "/flag/";

    /* renamed from: cv */
    private final int f3676cv = 1;

    /* renamed from: cA */
    private boolean f3631cA = false;

    /* renamed from: cB */
    private boolean f3632cB = false;

    /* renamed from: cC */
    private boolean f3633cC = false;

    /* renamed from: cD */
    private boolean f3634cD = false;

    /* renamed from: cO */
    private boolean f3645cO = false;

    /* renamed from: cR */
    private boolean f3646cR = false;

    /* renamed from: L */
    File f3510L = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();

    /* renamed from: da */
    private ProgressDialog f3682da = null;

    /* renamed from: db */
    private boolean f3683db = false;

    /* renamed from: dc */
    private boolean f3684dc = false;

    /* renamed from: df */
    private ArrayList<String> f3686df = new ArrayList<>();

    /* renamed from: dl */
    private C1029cy f3692dl = null;

    /* renamed from: do */
    private boolean f3695do = false;

    /* renamed from: dq */
    private BroadcastReceiver f3697dq = new C1004c(this);

    /* renamed from: dr */
    private Handler f3698dr = new HandlerC1099k(this);

    /* renamed from: M */
    ContentObserver f3511M = new C0941as(this, new Handler());

    /* renamed from: N */
    ContentObserver f3512N = new C0942at(this, new Handler());

    /* renamed from: O */
    ContentObserver f3513O = new C0943au(this, new Handler());

    /* renamed from: P */
    Handler f3514P = new HandlerC0944av(this);

    /* renamed from: Q */
    ContentObserver f3515Q = new C0945aw(this, new Handler());

    /* renamed from: R */
    ContentObserver f3516R = new C0946ax(this, new Handler());

    /* renamed from: S */
    ContentObserver f3517S = new C0948az(this, new Handler());

    /* renamed from: T */
    Handler f3518T = new HandlerC0966ba(this);

    /* renamed from: U */
    InterfaceC1378v f3519U = new C0979bb(this);

    /* renamed from: V */
    View.OnClickListener f3520V = new ViewOnClickListenerC0989bl(this);

    /* renamed from: ds */
    private View.OnClickListener f3699ds = new ViewOnClickListenerC0991bn(this);

    /* renamed from: W */
    Handler f3521W = new HandlerC0996bs(this);

    /* renamed from: X */
    Handler f3522X = new HandlerC1008cd(this);

    /* renamed from: Y */
    InterfaceC1413d f3523Y = new C1010cf(this);

    /* renamed from: dt */
    private SlookAirButton.ItemSelectListener f3700dt = new C1020cp(this);

    /* renamed from: a */
    static /* synthetic */ String m4739a(ChatFragment chatFragment, Object obj) {
        String str = chatFragment.f3540aP + obj;
        chatFragment.f3540aP = str;
        return str;
    }

    /* renamed from: b */
    static /* synthetic */ int m4862b(ChatFragment chatFragment, int i) {
        int i2 = chatFragment.f3597bT + i;
        chatFragment.f3597bT = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m4676B() {
        if (this.f3526aB != null) {
            this.f3526aB.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3672cr = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3672cr = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C3250y.f11735c) {
            C3250y.m11453c("[Enter the ChatRoom] InboxNO : " + this.f3703r, getClass().getSimpleName());
        }
        this.f3609bf = true;
        this.f3612bi = true;
        this.f3611bh = 0L;
        this.f3536aL = new ArrayList<>();
        synchronized (this.f3524Z) {
            this.f3537aM = new HashMap<>();
        }
        this.f3584bG = (InputMethodManager) this.f3672cr.getSystemService("input_method");
        this.f3531aG = new C2949a(CommonApplication.m11493l(), new Handler());
        this.f3551aa = new C1377u(this.f3672cr.getContentResolver(), this.f3519U);
        this.f3598bU = C3347i.m11777a((Context) this.f3672cr);
        this.f3602bY = null;
        this.f3660cf = new C1769a(3);
        this.f3660cf.m7287a(R.raw.trans_err, "TRANS_FAIL");
        this.f3660cf.m7287a(R.raw.reception, "RECV_SUCC");
        if (bundle != null && bundle.containsKey("captureUri")) {
            this.f3608be = Uri.parse(bundle.getString("captureUri"));
        }
        this.f3554ad = new C0045a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1954g.f7468a);
        intentFilter.addAction(C1954g.f7469b);
        intentFilter.addAction(C1954g.f7470c);
        intentFilter.addAction(C1954g.f7471d);
        intentFilter.addAction(C1954g.f7472e);
        if (getActivity() != null) {
            this.f3646cR = C0952c.m5141a(getActivity());
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f3697dq, intentFilter);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3563am = false;
        this.f3600bW = new C3326c();
        this.f3696dp = new ArrayList<>();
        m4678C();
        this.f3670cp = new C3702j<>(new C0902f(), 8, (byte) 2, -1L);
        this.f3577b = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        m4822ag();
        this.f3687dg = (RelativeLayout) this.f3577b.findViewById(R.id.rootLayout);
        this.f3569as = (FrameLayout) this.f3577b.findViewById(R.id.chatinput);
        this.f3568ar = (CheckedTextView) this.f3577b.findViewById(R.id.layout_select_all_include);
        this.f3570at = (FrameLayout) this.f3577b.findViewById(R.id.rLayoutChatParent);
        this.f3568ar.setOnClickListener(this.f3699ds);
        this.f3586bI = (ViewGroup) this.f3577b.findViewById(R.id.emoticonLayout);
        this.f3526aB = (HeightChangedListView) this.f3577b.findViewById(R.id.chat_listview);
        this.f3526aB.setOnHeightChangedListener(this);
        this.f3591bN = this.f3577b.findViewById(R.id.previewText);
        this.f3591bN.setOnClickListener(this);
        this.f3582bE = (ImageButton) this.f3577b.findViewById(R.id.btnChatSend);
        this.f3582bE.setOnClickListener(this);
        this.f3582bE.setEnabled(false);
        this.f3583bF = (ImageButton) this.f3577b.findViewById(R.id.btnChatTranslate);
        this.f3583bF.setOnClickListener(this);
        this.f3613bj = (MyEditText) this.f3577b.findViewById(R.id.editChatMsg);
        this.f3613bj.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1131o(this));
        this.f3613bj.addTextChangedListener(new C1142z(this));
        this.f3613bj.setOnEditorActionListener(new C0936an(this));
        this.f3613bj.setOnEditTextImeBackListener(new C0947ay(this));
        this.f3613bj.setOnTouchListener(new ViewOnTouchListenerC0990bm(this));
        this.f3613bj.setOnClickListener(new ViewOnClickListenerC1001bx(this));
        this.f3613bj.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1014cj(this));
        if (!this.f3613bj.hasFocus()) {
            this.f3613bj.requestFocus();
        }
        this.f3663ci = (LinearLayout) this.f3577b.findViewById(R.id.layout_preview);
        this.f3663ci.setVisibility(8);
        this.f3663ci.setOnClickListener(this);
        this.f3664cj = (ImageView) this.f3577b.findViewById(R.id.previewProfile);
        this.f3665ck = (TextView) this.f3577b.findViewById(R.id.previewText2);
        this.f3526aB.setOnScrollListener(new C1024ct(this));
        this.f3567aq = (ImageButton) this.f3577b.findViewById(R.id.btnChatImage);
        this.f3567aq.setOnClickListener(this);
        this.f3566ap = (ImageButton) this.f3577b.findViewById(R.id.btnAdd);
        this.f3566ap.setOnClickListener(this);
        this.f3585bH = (ImageView) this.f3577b.findViewById(R.id.imagebackgroup);
        this.f3558ah = (LinearLayout) this.f3577b.findViewById(R.id.mMedia_layout);
        this.f3559ai = (ImageView) this.f3577b.findViewById(R.id.mMedia_imageView);
        this.f3560aj = (ImageView) this.f3577b.findViewById(R.id.anicon_icon);
        this.f3561ak = (ImageButton) this.f3577b.findViewById(R.id.mMedia_del_btn);
        this.f3561ak.setOnClickListener(new ViewOnClickListenerC1031d(this));
        this.f3528aD = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
        this.f3529aE = (ProgressDialog) new C3263j(this.f3672cr).m11487a(R.string.media_file_download);
        m5014o();
        this.f3603bZ = (ImageButton) this.f3577b.findViewById(R.id.btn_push_talk);
        this.f3655ca = (LinearLayout) this.f3577b.findViewById(R.id.inputTalkLayout);
        this.f3603bZ.setOnKeyListener(new ViewOnKeyListenerC1058e(this));
        this.f3657cc = (FrameLayout) this.f3577b.findViewById(R.id.WalkietalkieLayout);
        this.f3657cc.setOnTouchListener(null);
        this.f3657cc.setOnClickListener(null);
        this.f3658cd = (LinearLayout) this.f3577b.findViewById(R.id.transparentLayout);
        this.f3658cd.setOnTouchListener(null);
        this.f3658cd.setOnClickListener(null);
        this.f3603bZ.setOnTouchListener(null);
        this.f3603bZ.setOnLongClickListener(new ViewOnLongClickListenerC1085f(this));
        this.f3603bZ.setOnClickListener(new ViewOnClickListenerC1095g(this));
        this.f3685de = new C1078et(getActivity(), (LinearLayout) this.f3577b.findViewById(R.id.duringCall));
        this.f3571au = LayoutInflater.from(getActivity()).inflate(R.layout.chat_privacy_layout, (ViewGroup) this.f3526aB, false);
        this.f3526aB.addHeaderView(this.f3571au);
        this.f3572av = (LinearLayout) this.f3571au.findViewById(R.id.privacy_menu_layout);
        this.f3573aw = (Button) this.f3571au.findViewById(R.id.privacy_add);
        this.f3574ax = (Button) this.f3571au.findViewById(R.id.privacy_block);
        this.f3575ay = (Button) this.f3571au.findViewById(R.id.privacy_report);
        this.f3576az = (TextView) this.f3571au.findViewById(R.id.privacy_text);
        this.f3525aA = (LinearLayout) this.f3571au.findViewById(R.id.loadMoreProgress);
        if (MultiWindowManager.isMultiWindowServiceEnabled(this.f3672cr)) {
            this.f3678cx = new ViewOnDragListenerC1096h(this);
            this.f3687dg.setOnDragListener(this.f3678cx);
            this.f3677cw = new ViewOnDragListenerC1097i(this);
            this.f3613bj.setOnDragListener(this.f3677cw);
            this.f3569as.setOnDragListener(this.f3677cw);
        }
        if (C3175aq.m11088a()) {
            this.f3689di = m4866b(this.f3566ap, 2);
            this.f3690dj = m4733a((View) this.f3567aq, 2);
            new SlookWritingBuddy(this.f3613bj).setImageWritingListener(new C1098j(this));
        }
        return this.f3577b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4868b(int i) {
        if (i == 4) {
            this.f3693dm = new AsyncTaskC1041dj(this, true);
        } else if (i == 6) {
            this.f3693dm = new AsyncTaskC1041dj(this, false);
        }
        if (this.f3693dm != null) {
            m5021v();
            if (Build.VERSION.SDK_INT < 11) {
                this.f3693dm.execute(this.f3694dn);
            } else {
                this.f3693dm.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f3694dn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4775a(DragEvent dragEvent, EnumC1025cu enumC1025cu) {
        return m4774a(dragEvent.getClipData(), enumC1025cu);
    }

    /* renamed from: a */
    private boolean m4774a(ClipData clipData, EnumC1025cu enumC1025cu) throws Throwable {
        int i;
        boolean z;
        CharSequence charSequence;
        Uri uri;
        int i2;
        File file = null;
        if (clipData == null) {
            return false;
        }
        int itemCount = clipData.getItemCount();
        if (itemCount > 1) {
            int i3 = 0;
            int i4 = 0;
            Uri uri2 = null;
            CharSequence text = null;
            int i5 = 0;
            while (true) {
                if (i3 >= itemCount) {
                    int i6 = i4;
                    i = i5;
                    charSequence = text;
                    uri = uri2;
                    i2 = i6;
                    break;
                }
                ClipData.Item itemAt = clipData.getItemAt(i3);
                if (itemAt.getText() != null) {
                    text = itemAt.getText();
                } else if (itemAt.getUri() != null) {
                    uri2 = itemAt.getUri();
                    i4++;
                    i5 = i3;
                }
                if (i4 > 1) {
                    int i7 = i4;
                    i = i5;
                    charSequence = text;
                    uri = uri2;
                    i2 = i7;
                    break;
                }
                i3++;
            }
            z = (i2 != 1 || uri == null || charSequence == null) ? false : true;
        } else {
            i = 0;
            z = false;
        }
        if (itemCount < 2 || z) {
            ClipData.Item itemAt2 = clipData.getItemAt(i);
            if (itemAt2 == null) {
                return true;
            }
            Intent intent = itemAt2.getIntent();
            if (intent != null) {
                Uri uri3 = (Uri) intent.getExtras().get("android.intent.extra.STREAM");
                String string = uri3 != null ? uri3.toString() : null;
                String type = intent.getType();
                String string2 = intent.getExtras().getString("android.intent.extra.TEXT");
                if (uri3 != null && string != null && type != null) {
                    if (string.contains("file://")) {
                        file = new File(Uri.parse(string).getPath());
                    } else {
                        C3246u c3246uM11426c = C3243r.m11426c(string);
                        if (c3246uM11426c != null) {
                            file = c3246uM11426c.f11726a;
                        }
                    }
                    EnumC1455w enumC1455wM4907h = m4907h(type);
                    if (enumC1455wM4907h != null) {
                        if (enumC1455wM4907h == EnumC1455w.DOCUMENT) {
                            new Intent().setData(uri3);
                            m4869b(intent);
                        } else {
                            m4763a(enumC1025cu, file, m4907h(type), string2);
                        }
                    } else {
                        C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                    }
                    if (C3250y.f11734b) {
                        if (file != null) {
                            C3250y.m11450b("onDrag_editview generate filepath : " + file.getAbsolutePath(), f3484a);
                        } else {
                            C3250y.m11450b("onDrag_editview file is null", f3484a);
                        }
                    }
                } else {
                    C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                }
            } else if (itemAt2.getUri() != null) {
                Uri uri4 = itemAt2.getUri();
                if ("file".equals(uri4.getScheme())) {
                    Intent intent2 = new Intent();
                    File file2 = new File(uri4.getPath());
                    EnumC1794a enumC1794aM7386c = FileExplorerActivity.m7386c(itemAt2.getUri().getPath());
                    if (enumC1794aM7386c == EnumC1794a.VIDEO) {
                        m4763a(enumC1025cu, file2, EnumC1455w.VIDEO, (String) null);
                    } else if (enumC1794aM7386c == EnumC1794a.IMAGE) {
                        m4763a(enumC1025cu, file2, EnumC1455w.IMAGE, (String) null);
                    } else if (enumC1794aM7386c == EnumC1794a.DOC || enumC1794aM7386c == EnumC1794a.GUL || enumC1794aM7386c == EnumC1794a.HWP || enumC1794aM7386c == EnumC1794a.PDF || enumC1794aM7386c == EnumC1794a.PPT || enumC1794aM7386c == EnumC1794a.SNB || enumC1794aM7386c == EnumC1794a.TXT || enumC1794aM7386c == EnumC1794a.XLS) {
                        intent2.setData(uri4);
                        m4869b(intent2);
                    } else if (enumC1794aM7386c == EnumC1794a.UNKNOWN) {
                        C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                    } else {
                        C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                    }
                } else {
                    C3246u c3246uM11426c2 = C3243r.m11426c(itemAt2.getUri().toString());
                    if (c3246uM11426c2 != null && c3246uM11426c2.f11727b != null && c3246uM11426c2.f11726a != null) {
                        if (c3246uM11426c2.f11727b.contains("image/")) {
                            m4763a(enumC1025cu, c3246uM11426c2.f11726a, EnumC1455w.IMAGE, (String) null);
                        } else if (c3246uM11426c2.f11727b.contains("video/")) {
                            m4763a(enumC1025cu, c3246uM11426c2.f11726a, EnumC1455w.VIDEO, (String) null);
                        } else if (c3246uM11426c2.f11727b.contains("audio/")) {
                            m4763a(enumC1025cu, c3246uM11426c2.f11726a, EnumC1455w.AUDIO, (String) null);
                        } else {
                            C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                        }
                        if (C3250y.f11734b) {
                            C3250y.m11450b("onDrag_editview generate filepath : " + c3246uM11426c2.f11726a.getAbsolutePath(), f3484a);
                        }
                    } else {
                        C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                    }
                }
            } else if (itemAt2.getText() != null && itemAt2.getText().length() > 0) {
                if (enumC1025cu == EnumC1025cu.EditTextSpace) {
                    this.f3613bj.setText(itemAt2.getText());
                } else if (enumC1025cu == EnumC1025cu.ChatSpace) {
                    m4770a(itemAt2.getText().toString(), "", true);
                }
            } else if (itemAt2.getHtmlText() != null && !itemAt2.getHtmlText().isEmpty()) {
                if (enumC1025cu == EnumC1025cu.EditTextSpace) {
                    this.f3613bj.setText(itemAt2.getHtmlText());
                } else if (enumC1025cu == EnumC1025cu.ChatSpace) {
                    m4770a(itemAt2.getHtmlText(), "", true);
                }
            } else {
                C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
            }
            return true;
        }
        C3641ai.m13210a(this.f3672cr, R.string.multiwindow_dragNdrop_not_supported, 0).show();
        return true;
    }

    /* renamed from: C */
    private void m4678C() {
        this.f3696dp.add("image/");
        this.f3696dp.add("text/plain");
        this.f3696dp.add("video/");
        this.f3696dp.add("audio/");
        this.f3696dp.add("application/");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.chaton.p027e.EnumC1455w m4907h(java.lang.String r4) {
        /*
            r3 = this;
            r1 = 0
            java.util.ArrayList<java.lang.String> r0 = r3.f3696dp
            java.util.Iterator r0 = r0.iterator()
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L50
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = r4.contains(r0)
            if (r2 == 0) goto L50
        L19:
            java.lang.String r2 = "image/"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L24
            com.sec.chaton.e.w r1 = com.sec.chaton.p027e.EnumC1455w.IMAGE
        L23:
            return r1
        L24:
            java.lang.String r2 = "video/"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L2f
            com.sec.chaton.e.w r1 = com.sec.chaton.p027e.EnumC1455w.VIDEO
            goto L23
        L2f:
            java.lang.String r2 = "audio/"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L3a
            com.sec.chaton.e.w r1 = com.sec.chaton.p027e.EnumC1455w.AUDIO
            goto L23
        L3a:
            java.lang.String r2 = "text/plain"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L45
            com.sec.chaton.e.w r1 = com.sec.chaton.p027e.EnumC1455w.TEXT
            goto L23
        L45:
            java.lang.String r2 = "application/"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L23
            com.sec.chaton.e.w r1 = com.sec.chaton.p027e.EnumC1455w.DOCUMENT
            goto L23
        L50:
            r0 = r1
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.m4907h(java.lang.String):com.sec.chaton.e.w");
    }

    /* renamed from: a */
    private void m4763a(EnumC1025cu enumC1025cu, File file, EnumC1455w enumC1455w, String str) throws Throwable {
        if (enumC1025cu == EnumC1025cu.ChatSpace) {
            EnumC1794a enumC1794aM7386c = FileExplorerActivity.m7386c(file.getPath());
            if (enumC1455w == EnumC1455w.IMAGE) {
                if (enumC1794aM7386c == EnumC1794a.UNKNOWN) {
                    C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                    return;
                } else {
                    m4738a(file.getAbsolutePath(), false, false);
                    return;
                }
            }
            if (enumC1455w == EnumC1455w.AUDIO) {
                m4766a(file, (String) null, (String) null, enumC1455w, (String) null);
                return;
            }
            if (enumC1455w == EnumC1455w.VIDEO) {
                if (enumC1794aM7386c == EnumC1794a.UNKNOWN) {
                    C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                    return;
                } else {
                    m4766a(file, (String) null, (String) null, enumC1455w, (String) null);
                    return;
                }
            }
            if (enumC1455w == EnumC1455w.TEXT && str != null) {
                m4770a(str, "", true);
                return;
            }
            return;
        }
        if (enumC1025cu == EnumC1025cu.EditTextSpace) {
            if (enumC1455w == EnumC1455w.AUDIO) {
                m4766a(file, (String) null, (String) null, enumC1455w, (String) null);
                return;
            }
            if (enumC1455w == EnumC1455w.IMAGE || enumC1455w == EnumC1455w.VIDEO) {
                if (FileExplorerActivity.m7386c(file.getPath()) == EnumC1794a.UNKNOWN) {
                    C3641ai.m13210a(this.f3672cr, R.string.toast_supported_format, 0).show();
                    return;
                } else {
                    m4765a(file, enumC1455w, (String) null, (String) null, false);
                    return;
                }
            }
            if (enumC1455w == EnumC1455w.TEXT && str != null) {
                this.f3613bj.setText(str);
            }
        }
    }

    /* renamed from: D */
    private void m4680D() {
        this.f3509K = new ArrayList<>();
        this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_picture, R.drawable.co_attach_p_image_normal, 0));
        if (C3171am.m11077o()) {
            this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_capture_picture, R.drawable.co_attach_p_camera_normal, 1));
        }
        this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_animessage, R.drawable.co_attach_p_ams_normal, 9));
        this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_video, R.drawable.co_attach_p_video_normal, 2));
        if (C3171am.m11077o()) {
            this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_record_video, R.drawable.co_attach_p_record_normal, 3));
        }
        this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.media_voice, R.drawable.co_attach_p_voice_normal, 4));
        this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_contact, R.drawable.co_attach_p_contact_normal, 6));
        this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_files, R.drawable.co_attach_p_document_normal, 10));
        if (C0816a.m4365a()) {
            this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_geo_tag, R.drawable.co_attach_p_location_normal, 8));
        }
        this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_calendar, R.drawable.co_attach_p_calendar_normal, 7));
        if (C0816a.m4367c()) {
            this.f3509K.add(new C1478g(GlobalApplication.m6451b(), R.string.menu_multimedia_snote, R.drawable.co_attach_p_s_note_normal, 11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m4682E() {
        this.f3655ca.setVisibility(8);
        this.f3657cc.setVisibility(8);
        this.f3658cd.setVisibility(8);
        this.f3507I = false;
        if (this.f3656cb != null) {
            this.f3656cb.m7363a(true);
        }
        if (this.f3672cr != null) {
            this.f3672cr.setRequestedOrientation(-1);
            this.f3672cr.getWindow().clearFlags(128);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4915i(String str) {
        if (!TextUtils.isEmpty(str)) {
            m4766a(new File(str), (String) null, (String) null, EnumC1455w.AUDIO, (String) null);
            C1770b.m7289a().m7298a(this.f3703r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f3600bW.m11731a();
        this.f3527aC.m5292e();
        this.f3526aB.setAdapter((ListAdapter) null);
        if (MultiWindowManager.isMultiWindowServiceEnabled(this.f3672cr)) {
            this.f3677cw = null;
            this.f3678cx = null;
            this.f3687dg.setOnDragListener(null);
            this.f3613bj.setOnDragListener(null);
        }
        if (this.f3666cl != null && this.f3666cl.isShowing()) {
            this.f3666cl.dismiss();
        }
        Cursor cursor = this.f3527aC.getCursor();
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
            if (C3250y.f11734b) {
                C3250y.m11450b("The Cursor of Adapter was closed", getClass().getSimpleName());
            }
        }
        this.f3527aC.m5286a((InterfaceC1093fh) null);
        m4816ad();
        try {
            if (this.f3670cp != null) {
                this.f3670cp.mo13289d();
            }
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f3484a);
            }
        }
        if (C3175aq.m11088a()) {
            m4819ae();
            if (this.f3693dm != null) {
                this.f3693dm.cancel(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f3588bK = getArguments();
        if (this.f3588bK != null && this.f3588bK.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("InBoxNO : ");
            if (this.f3588bK.containsKey("inboxNO")) {
                this.f3703r = this.f3588bK.getString("inboxNO");
                sb.append(this.f3703r);
            } else if (bundle != null && bundle.containsKey("inbox_no")) {
                this.f3703r = bundle.getString("inbox_no");
                sb.append(this.f3703r).append(" from SavedInstance");
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("ChatType : ");
            if (this.f3588bK.containsKey("chatType")) {
                this.f3709x = EnumC1450r.m6339a(this.f3588bK.getInt("chatType"));
                if (this.f3709x != null) {
                    sb.append(this.f3709x.toString());
                }
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("Participants : ");
            if (this.f3588bK.containsKey("receivers")) {
                String[] stringArray = this.f3588bK.getStringArray("receivers");
                if (this.f3709x == EnumC1450r.ONETOONE) {
                    this.f3704s = stringArray[0];
                }
                synchronized (this.f3524Z) {
                    for (String str : stringArray) {
                        this.f3536aL.add(str);
                        this.f3537aM.put(str, new C0264a(str));
                        sb.append(str + " ");
                    }
                }
            } else {
                sb.append("Not Contained");
                if (this.f3588bK.containsKey("groupId")) {
                    String[] strArr = this.f3709x == EnumC1450r.GROUPCHAT ? (String[]) C1362f.m6060a(CommonApplication.m11493l().getContentResolver(), Integer.parseInt(this.f3588bK.getString("groupId"))).toArray(new String[0]) : null;
                    if (strArr != null) {
                        synchronized (this.f3524Z) {
                            for (String str2 : strArr) {
                                this.f3536aL.add(str2);
                                this.f3537aM.put(str2, new C0264a(str2));
                                sb.append(str2 + " ");
                            }
                        }
                    } else {
                        C3250y.m11442a("onActivityCreated() receiverList is NULL. ERROR!", getClass().getSimpleName());
                    }
                }
            }
            C3250y.m11456e(sb.toString(), getClass().getSimpleName());
            sb.append("KEY_GROUP_NAME : ");
            if (this.f3588bK.containsKey("groupnmae")) {
                this.f3499A = this.f3588bK.getString("groupnmae");
                sb.append(this.f3499A.toString());
                C3250y.m11454d("mGroupName:" + this.f3499A);
                this.f3541aQ = this.f3499A;
                this.f3639cI.setText(this.f3499A);
                this.f3540aP = this.f3499A;
                this.f3546aV = this.f3499A;
            }
            if (this.f3588bK.containsKey("content_type")) {
                this.f3622bs = this.f3588bK.getInt("content_type");
                this.f3588bK.remove("content_type");
                C3250y.m11454d("ChatView content_type:" + this.f3622bs);
                this.f3629bz = true;
            }
            if (this.f3588bK.containsKey("download_uri")) {
                this.f3623bt = this.f3588bK.getString("download_uri");
                C3250y.m11454d("ChatView download_uri:" + this.f3623bt);
            }
            if (this.f3588bK.containsKey("sub_content")) {
                this.f3624bu = this.f3588bK.getString("sub_content");
                C3250y.m11454d("ChatView sub_content:" + this.f3624bu);
            }
            if (this.f3588bK.containsKey("forward_sender_name")) {
                this.f3625bv = this.f3588bK.getString("forward_sender_name");
                C3250y.m11454d("ChatView forward_sender_name:" + this.f3625bv);
            }
            if (this.f3588bK.containsKey("is_forward_mode")) {
                this.f3626bw = this.f3588bK.getBoolean("is_forward_mode");
                C3250y.m11454d("ChatView forward_mode:" + this.f3626bw);
            }
            if (this.f3588bK.containsKey(f3494k)) {
                this.f3695do = this.f3588bK.getBoolean(f3494k);
                if (this.f3695do && this.f3613bj != null) {
                    m4984b();
                }
                C3250y.m11454d("misForceShowKeyboard:" + this.f3695do);
            }
            if (this.f3588bK.containsKey(f3493j)) {
                this.f3627bx = this.f3588bK.getString(f3493j);
                this.f3579bB = this.f3588bK.getBoolean(f3495l);
                if (this.f3579bB) {
                    this.f3540aP = this.f3627bx;
                    this.f3546aV = this.f3540aP;
                    this.f3628by = true;
                }
            }
            if (this.f3588bK.containsKey(f3496m)) {
                this.f3578bA = this.f3588bK.getBoolean(f3496m);
            }
            if (this.f3588bK.containsKey("inboxValid")) {
                this.f3609bf = this.f3588bK.getBoolean("inboxValid");
                if (!this.f3609bf) {
                    this.f3569as.setVisibility(8);
                }
            }
            if (this.f3588bK.containsKey("trunkUnreadCount")) {
                this.f3549aY = this.f3588bK.getInt("trunkUnreadCount");
            } else {
                this.f3549aY = 0;
            }
            if (this.f3588bK.containsKey("lastTempMessage")) {
                this.f3707v = this.f3588bK.getString("lastTempMessage");
            }
            if (this.f3588bK.containsKey("showPhoneNumber")) {
                this.f3532aH = this.f3588bK.getInt("showPhoneNumber", 0);
            }
            if (this.f3588bK.containsKey("extraInfo")) {
                this.f3533aI = this.f3588bK.getString("extraInfo");
            }
            if (this.f3588bK.containsKey("msisdns")) {
                this.f3534aJ = this.f3588bK.getString("msisdns");
                if (TextUtils.isEmpty(this.f3704s)) {
                    this.f3532aH = 0;
                } else if (m4998d(this.f3534aJ)) {
                    if (m4948r(this.f3534aJ).size() == 0) {
                        this.f3532aH = 0;
                    } else {
                        this.f3532aH = 1;
                    }
                }
            }
            if (this.f3588bK.containsKey("groupId")) {
                this.f3599bV = this.f3588bK.getString("groupId");
            }
            if (this.f3588bK.containsKey("is_attach_on_the_edittext")) {
                this.f3688dh = this.f3588bK.getBoolean("is_attach_on_the_edittext");
            }
            if (this.f3588bK.containsKey(C2310s.f8621e)) {
                this.f3580bC = (EnumC3073u) this.f3588bK.get(C2310s.f8621e);
            }
            if (this.f3588bK.containsKey("msgbox")) {
                this.f3631cA = true;
                m4871b(this.f3588bK);
            }
        }
        if (TextUtils.isEmpty(this.f3710y) && bundle != null && bundle.containsKey("session_id")) {
            this.f3710y = bundle.getString("session_id");
        }
        registerForContextMenu(this.f3526aB);
        BaseActivity.m3081a(this, true);
        this.f3527aC = new C1067ei(this.f3672cr, this.f3526aB, null, this.f3709x, m4782aC(), m4780aB(), this.f3600bW, this.f3670cp, this.f3700dt);
        this.f3526aB.setAdapter((ListAdapter) this.f3527aC);
        this.f3527aC.m5286a(this);
        if (this.f3588bK != null && "file".equals(this.f3588bK.getString(C2310s.f8618b))) {
            m4713U();
            this.f3588bK.remove(C2310s.f8618b);
        }
        this.f3526aB.setTranscriptMode(2);
        this.f3526aB.setSelection(this.f3526aB.getCount());
        this.f3659ce = new C1100l(this);
        this.f3527aC.registerDataSetObserver(this.f3659ce);
        m4702O();
        if (this.f3703r != null) {
            m4949s(this.f3703r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C3250y.f11735c) {
            C3250y.m11453c("[onResume() ChatRoom] InboxNO : " + this.f3703r, getClass().getSimpleName());
        }
        if (((KeyguardManager) getActivity().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f3692dl = new C1029cy(this, null);
            getActivity().registerReceiver(this.f3692dl, intentFilter);
            if (C3250y.f11735c) {
                C3250y.m11453c("keyguard is displayed. Register receiver", f3484a);
                return;
            }
            return;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("keyguard is not displayed", f3484a);
        }
        C1103a.m5432a(GlobalApplication.m11493l()).m5462b(this.f3703r);
        m4684F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m4684F() {
        this.f3594bQ = false;
        this.f3683db = false;
        m4822ag();
        m4813ab();
        this.f3514P.sendEmptyMessageDelayed(100, 10L);
        PushReceiver.m8377a(this);
        this.f3672cr.getContentResolver().registerContentObserver(C1454v.f5393a, true, this.f3512N);
        this.f3672cr.getContentResolver().registerContentObserver(C1449q.f5381a, true, this.f3517S);
        this.f3672cr.getContentResolver().registerContentObserver(C1454v.m6356e(), false, this.f3513O);
        this.f3672cr.getContentResolver().registerContentObserver(C1454v.m6343a(), false, this.f3515Q);
        C0952c.m5143c().m5156d().m5130a();
        m4686G();
        this.f3685de.m5348b();
        if (this.f3709x == EnumC1450r.ONETOONE) {
            C0958i.m5169b();
            if (!C0958i.m5166a()) {
                C0958i.m5172c();
            }
        }
        if (this.f3548aX.equals("-1")) {
            m4779aA();
        }
        this.f3632cB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m4686G() {
        boolean z = true;
        if (this.f3621br) {
            if (this.f3646cR && this.f3647cS && !this.f3648cT) {
                this.f3582bE.setVisibility(8);
                if (this.f3613bj.getText().length() > 0) {
                    this.f3603bZ.setVisibility(8);
                    this.f3583bF.setEnabled(true);
                    this.f3583bF.setVisibility(0);
                    return;
                } else {
                    if (this.f3553ac) {
                        this.f3603bZ.setVisibility(8);
                        this.f3583bF.setVisibility(8);
                        this.f3582bE.setEnabled(true);
                        this.f3582bE.setVisibility(0);
                        return;
                    }
                    this.f3603bZ.setVisibility(0);
                    this.f3583bF.setVisibility(8);
                    this.f3582bE.setVisibility(8);
                    return;
                }
            }
            this.f3583bF.setVisibility(8);
            if (this.f3553ac || this.f3613bj.getText().length() > 0) {
                this.f3603bZ.setVisibility(8);
                this.f3582bE.setVisibility(0);
                return;
            } else {
                this.f3603bZ.setVisibility(0);
                this.f3582bE.setVisibility(8);
                return;
            }
        }
        this.f3603bZ.setVisibility(8);
        if (this.f3646cR && this.f3647cS && !this.f3648cT) {
            if (this.f3613bj.getText().length() > 0) {
                this.f3583bF.setEnabled(true);
                this.f3583bF.setVisibility(0);
                this.f3582bE.setVisibility(8);
                return;
            } else if (this.f3553ac) {
                this.f3582bE.setEnabled(true);
                this.f3582bE.setVisibility(0);
                this.f3583bF.setVisibility(8);
                return;
            } else {
                this.f3583bF.setEnabled(false);
                this.f3583bF.setVisibility(0);
                this.f3582bE.setVisibility(8);
                return;
            }
        }
        ImageButton imageButton = this.f3582bE;
        if (this.f3613bj.getText().length() <= 0 && !this.f3553ac) {
            z = false;
        }
        imageButton.setEnabled(z);
        this.f3582bE.setVisibility(0);
        this.f3583bF.setVisibility(8);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (C3250y.f11735c) {
            C3250y.m11453c("[onPause() ChatRoom] InboxNO : " + this.f3703r, getClass().getSimpleName());
        }
        this.f3594bQ = true;
        if (!this.f3683db) {
            this.f3707v = this.f3613bj.getText().toString();
            m4693K();
        }
        m5013n();
        this.f3672cr.getContentResolver().unregisterContentObserver(this.f3512N);
        this.f3672cr.getContentResolver().unregisterContentObserver(this.f3511M);
        this.f3672cr.getContentResolver().unregisterContentObserver(this.f3517S);
        this.f3672cr.getContentResolver().unregisterContentObserver(this.f3513O);
        this.f3672cr.getContentResolver().unregisterContentObserver(this.f3515Q);
        if (this.f3530aF != null) {
            this.f3530aF.m5893c(SystemClock.elapsedRealtime() + 480000);
        }
        C1103a.m5432a(GlobalApplication.m11493l()).m5464c(this.f3703r);
        PushReceiver.m8377a((InterfaceC1091ff) null);
        C1770b.m7289a().m7305c();
        if (this.f3656cb != null && this.f3507I) {
            this.f3656cb.m7363a(true);
        }
        mo5019t();
        C0958i.m5172c();
        this.f3685de.m5349c();
        C2646u.f9891a.clear();
        C1821k.m7478a().m7483b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m4918j(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f3531aG.m10427a(arrayList);
    }

    /* renamed from: b */
    public void m4984b() {
        this.f3613bj.requestFocus();
        long j = 200;
        if (!this.f3613bj.isShown()) {
            j = 1000;
        }
        new Timer(true).schedule(new C1101m(this, new Handler()), j);
    }

    /* renamed from: H */
    private void m4687H() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f3551aa.startUpdate(4, null, C1449q.m6334d(), contentValues, "inbox_no = ?", new String[]{this.f3703r});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public boolean m4690I() throws Throwable {
        this.f3530aF = C1337o.m5795a(this.f3703r, this.f3709x);
        if (this.f3530aF == null) {
            C3250y.m11442a("false : mMessageControl null", getClass().getSimpleName());
            return false;
        }
        if (this.f3594bQ) {
            C3250y.m11442a("false : already paused", getClass().getSimpleName());
            return false;
        }
        this.f3530aF.m5874a(this.f3518T);
        this.f3530aF.m5894c(this.f3710y);
        this.f3530aF.m5867a(this.f3547aW);
        if (this.f3530aF.m5907p() && !C1757q.m7251b()) {
            m5021v();
        }
        if (this.f3602bY != null) {
            m4692J();
        }
        return true;
    }

    /* renamed from: J */
    private void m4692J() throws Throwable {
        switch (this.f3602bY.getIntExtra("requestCode", -1)) {
            case 0:
                m4965a(this.f3608be, true);
                break;
            case 1:
                m4965a(this.f3602bY.getData(), false);
                break;
            case 5:
                m4904g(this.f3602bY);
                break;
            case 6:
                m4892e(this.f3602bY);
                break;
            case 7:
                m4898f(this.f3602bY);
                break;
            case 9:
                m4881c(this.f3602bY);
                break;
            case 11:
            case 12:
                m4909h(this.f3602bY);
                break;
            case 15:
                m4740a(this.f3602bY);
                break;
            case 16:
            case 21:
                m4743a(this.f3602bY.getExtras());
                break;
            case 18:
                m4869b(this.f3602bY);
                break;
            case 19:
                m4887d(this.f3602bY);
                break;
            case 22:
                m4914i(this.f3602bY);
                break;
        }
        this.f3602bY = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m4693K() {
        /*
            r9 = this;
            r1 = -1
            java.lang.String r0 = r9.f3703r
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L8c
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.sec.chaton.chat.MyEditText r0 = r9.f3613bj
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.sec.chaton.chat.C1075eq.m5318a(r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.String r2 = ";"
            r0.append(r2)
            java.lang.String r2 = ""
            java.lang.String r0 = ""
            boolean r3 = r9.f3553ac
            if (r3 == 0) goto L9c
            com.sec.chaton.e.w r3 = r9.f3556af
            com.sec.chaton.e.w r6 = com.sec.chaton.p027e.EnumC1455w.IMAGE
            if (r3 == r6) goto L44
            com.sec.chaton.e.w r3 = r9.f3556af
            com.sec.chaton.e.w r6 = com.sec.chaton.p027e.EnumC1455w.AMS
            if (r3 == r6) goto L44
            com.sec.chaton.e.w r3 = r9.f3556af
            com.sec.chaton.e.w r6 = com.sec.chaton.p027e.EnumC1455w.VIDEO
            if (r3 != r6) goto L8d
        L44:
            java.io.File r3 = r9.f3555ae
            if (r3 == 0) goto L9c
            com.sec.chaton.e.w r2 = r9.f3556af
            int r3 = r2.m6364a()
            java.io.File r2 = r9.f3555ae
            java.lang.String r2 = r2.getAbsolutePath()
            boolean r6 = r9.f3562al
            if (r6 == 0) goto L5a
            java.lang.String r0 = r9.f3564an
        L5a:
            java.lang.StringBuilder r3 = r5.append(r3)
            java.lang.String r6 = ";"
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r3 = ";"
            java.lang.StringBuilder r2 = r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "inbox_last_temp_msg"
            java.lang.String r2 = r5.toString()
            r4.put(r0, r2)
            com.sec.chaton.e.a.u r0 = r9.f3551aa
            r2 = 0
            android.net.Uri r3 = com.sec.chaton.p027e.C1449q.f5381a
            java.lang.String r5 = "inbox_no=?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]
            r7 = 0
            java.lang.String r8 = r9.f3703r
            r6[r7] = r8
            r0.startUpdate(r1, r2, r3, r4, r5, r6)
        L8c:
            return
        L8d:
            com.sec.chaton.e.w r3 = r9.f3556af
            com.sec.chaton.e.w r6 = com.sec.chaton.p027e.EnumC1455w.ANICON
            if (r3 != r6) goto L9c
            com.sec.chaton.e.w r2 = r9.f3556af
            int r3 = r2.m6364a()
            java.lang.String r2 = r9.f3606bc
            goto L5a
        L9c:
            r3 = r1
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.m4693K():void");
    }

    /* renamed from: L */
    private void m4696L() {
        if (this.f3563am) {
            this.f3552ab.setGroupVisible(R.id.chat_menu_group, false);
            this.f3552ab.setGroupVisible(R.id.chat_menu_group_delete, true);
            if (this.f3527aC == null || this.f3527aC.m5291d() == EnumC1071em.SELECT_NONE) {
                this.f3552ab.findItem(R.id.chat_menu_delete_confirm).setEnabled(false);
            } else {
                this.f3552ab.findItem(R.id.chat_menu_delete_confirm).setEnabled(true);
            }
        } else {
            this.f3552ab.setGroupVisible(R.id.chat_menu_group, true);
            this.f3552ab.setGroupVisible(R.id.chat_menu_group_delete, false);
        }
        m4698M();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f3552ab = menu;
        if (!GlobalApplication.m6456e()) {
            C3228cp.m11343a(this.f3552ab.findItem(R.id.chat_menu_trunk));
            C3228cp.m11346b(this.f3552ab.findItem(R.id.chat_menu_trunk));
            m4696L();
        }
        if (GlobalApplication.m6456e()) {
            this.f3552ab.clear();
            menuInflater.inflate(R.menu.tablet_chat_menu, this.f3552ab);
            m4744a(this.f3552ab);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        if (C3250y.f11735c) {
            C3250y.m11453c("onPrepareOptionsMenu called", f3484a);
        }
        super.onPrepareOptionsMenu(menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.chat_menu_info);
        if (menuItemFindItem != null) {
            if (!this.f3705t) {
                menuItemFindItem.setEnabled(false);
            } else {
                menuItemFindItem.setEnabled(this.f3609bf);
            }
            C3228cp.m11343a(menuItemFindItem);
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.chat_menu_delete);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setEnabled(this.f3705t);
            C3228cp.m11343a(menuItemFindItem2);
        }
        MenuItem menuItemFindItem3 = menu.findItem(R.id.chat_menu_closechat);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setEnabled(this.f3705t);
            C3228cp.m11343a(menuItemFindItem3);
        }
        MenuItem menuItemFindItem4 = menu.findItem(R.id.chat_menu_forward);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setEnabled(this.f3705t);
            C3228cp.m11343a(menuItemFindItem4);
        }
        MenuItem menuItemFindItem5 = menu.findItem(R.id.chat_menu_invitebuddy);
        if (menuItemFindItem5 != null) {
            menuItemFindItem5.setEnabled(this.f3609bf);
            C3228cp.m11343a(menuItemFindItem5);
        }
        MenuItem menuItemFindItem6 = menu.findItem(R.id.chat_menu_alert);
        if (menuItemFindItem6 != null) {
            if (EnumC1450r.m6340a(this.f3709x)) {
                menu.removeItem(R.id.chat_menu_alert);
            } else if (this.f3612bi) {
                menuItemFindItem6.setTitle(R.string.chaton_live_buddy_alert_off).setIcon(R.drawable.more_option_alert_off_white);
            } else {
                menuItemFindItem6.setTitle(R.string.chaton_live_buddy_alert_on).setIcon(R.drawable.more_option_alert_white);
            }
            menuItemFindItem6.setEnabled(this.f3609bf);
            C3228cp.m11343a(menuItemFindItem6);
        }
        MenuItem menuItemFindItem7 = menu.findItem(R.id.chat_menu_translate);
        if (menuItemFindItem7 != null) {
            if (this.f3709x != EnumC1450r.ONETOONE) {
                menu.removeItem(R.id.chat_menu_translate);
            }
            menuItemFindItem7.setEnabled(this.f3609bf);
            C3228cp.m11343a(menuItemFindItem7);
        }
        MenuItem menuItemFindItem8 = menu.findItem(R.id.chat_menu_export);
        if (menuItemFindItem8 != null) {
            menuItemFindItem8.setEnabled(this.f3705t);
            C3228cp.m11343a(menuItemFindItem8);
        }
        boolean zM7903a = C1948a.m7903a(getActivity());
        if (zM7903a) {
            MenuItem menuItemFindItem9 = menu.findItem(R.id.chat_menu_chatonvoice);
            if (menuItemFindItem9 != null) {
                menuItemFindItem9.setEnabled(this.f3536aL.size() > 0 ? m4883c(false) : false);
                C3228cp.m11343a(menuItemFindItem9);
            }
        } else {
            menu.removeItem(R.id.chat_menu_chatonvoice);
        }
        if (zM7903a) {
            MenuItem menuItemFindItem10 = menu.findItem(R.id.chat_menu_chatonvideo);
            if (menuItemFindItem10 != null) {
                menuItemFindItem10.setEnabled(this.f3536aL.size() > 0 ? m4883c(true) : false);
                C3228cp.m11343a(menuItemFindItem10);
                return;
            }
            return;
        }
        menu.removeItem(R.id.chat_menu_chatonvideo);
    }

    /* renamed from: M */
    private void m4698M() {
        if (this.f3552ab == null) {
            C3250y.m11453c("mChatRoomMenu is null", f3484a);
            return;
        }
        MenuItem menuItemFindItem = this.f3552ab.findItem(R.id.chat_menu_trunk);
        if (menuItemFindItem != null) {
            if (EnumC1450r.m6340a(this.f3709x) || (this.f3587bJ != null && this.f3587bJ.isShown())) {
                menuItemFindItem.setVisible(false);
            }
            if (!GlobalApplication.m6456e()) {
                if (this.f3549aY > 0) {
                    C3228cp.m11344a(menuItemFindItem, true);
                } else {
                    C3228cp.m11344a(menuItemFindItem, false);
                }
            }
            if (GlobalApplication.m6456e()) {
                menuItemFindItem.setVisible(false);
            }
        }
    }

    /* renamed from: N */
    private void m4699N() {
        if (!GlobalApplication.m6456e()) {
            if (this.f3552ab == null) {
                C3250y.m11453c("mChatRoomMenu is null", f3484a);
                return;
            }
            MenuItem menuItemFindItem = this.f3552ab.findItem(R.id.chat_menu_trunk);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(false);
            }
        }
    }

    /* renamed from: O */
    private void m4702O() {
        if (this.f3672cr != null) {
            if (GlobalApplication.m6456e()) {
                LinearLayout linearLayout = (LinearLayout) this.f3577b.findViewById(R.id.lLayoutProfile);
                linearLayout.setVisibility(0);
                this.f3630c = (ProfileImageView) this.f3577b.findViewById(R.id.Chaticon);
                this.f3639cI = (TextView) this.f3577b.findViewById(R.id.chatTitle);
                this.f3640cJ = (TextView) this.f3577b.findViewById(R.id.textStatus);
                this.f3681d = (TextView) this.f3577b.findViewById(R.id.chatroom_trunk_menu_count);
                linearLayout.setOnClickListener(new ViewOnClickListenerC1132p(this));
                if (this.f3709x == EnumC1450r.ONETOONE && !TextUtils.isEmpty(this.f3704s)) {
                    C3205bt.m11182a(getActivity().getApplicationContext()).m11210a(this.f3630c, this.f3704s);
                } else {
                    EnumC3208bw enumC3208bw = EnumC3208bw.GROUP;
                    if (this.f3709x == EnumC1450r.BROADCAST) {
                        enumC3208bw = EnumC3208bw.BROADCAST;
                    }
                    if (this.f3599bV != null) {
                        C3205bt.m11182a(getActivity().getApplicationContext()).m11213a(this.f3630c, this.f3703r.isEmpty() ? "" + new Date().getTime() : this.f3703r, this.f3599bV, this.f3709x);
                    } else {
                        C3205bt.m11182a(getActivity().getApplicationContext()).m11209a(this.f3630c, enumC3208bw);
                    }
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.f3577b.findViewById(R.id.imageTrunk);
                relativeLayout.setOnClickListener(new ViewOnClickListenerC1133q(this));
                if (EnumC1450r.m6340a(this.f3709x)) {
                    relativeLayout.setEnabled(false);
                }
                m4747a(this.f3681d, this.f3549aY);
            }
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3672cr);
            if (this.f3635cE == null) {
                this.f3635cE = layoutInflaterFrom.inflate(R.layout.actionbar_custom_layout_chatroom, (ViewGroup) null, false);
            }
            if (!GlobalApplication.m6456e()) {
                ((ActionBarFragmentActivity) this.f3672cr).m11543k().mo11580a(this.f3635cE);
                if (this.f3639cI == null) {
                    this.f3639cI = (TextView) this.f3635cE.findViewById(R.id.chatroom_custom_title);
                }
                if (this.f3638cH == null) {
                    this.f3638cH = (ViewGroup) this.f3635cE.findViewById(R.id.subtitle_group);
                }
                if (this.f3640cJ == null) {
                    this.f3640cJ = (TextView) this.f3635cE.findViewById(R.id.chatroom_custom_sub_title);
                }
                if (this.f3637cG == null) {
                    this.f3637cG = (ImageView) this.f3635cE.findViewById(R.id.title_alert_off_indicator);
                }
            }
            if (this.f3641cK == null) {
                this.f3641cK = (LinearLayout) this.f3635cE.findViewById(R.id.chatroom_custom_layout);
                this.f3641cK.setFocusable(true);
                this.f3641cK.setPadding(3, 0, 0, 0);
                this.f3641cK.setOnClickListener(new ViewOnClickListenerC1134r(this));
            }
            if (this.f3636cF == null) {
                this.f3636cF = layoutInflaterFrom.inflate(R.layout.actionbar_custom_layout_emoticon, (ViewGroup) null, false);
            }
            ((ActionBarFragmentActivity) this.f3672cr).m11543k().mo11596e(23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public void m4703P() {
        if (this.f3609bf && this.f3705t && this.f3540aP != null && !this.f3563am) {
            Intent intent = new Intent(this.f3672cr, (Class<?>) ChatInfoActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 6);
            String str = this.f3540aP;
            intent.putExtra(f3493j, this.f3705t);
            intent.putExtra(f3490g, str);
            intent.putExtra("inboxNO", this.f3703r);
            intent.putExtra("chatType", this.f3709x.m6342a());
            intent.putExtra(f3495l, this.f3579bB);
            intent.putExtra("buddyNO", this.f3704s);
            intent.putExtra("inboxValid", this.f3609bf);
            intent.putExtra(f3497n, this.f3612bi);
            intent.putExtra("ACTIVITY_PURPOSE_ARG", true);
            synchronized (this.f3524Z) {
                intent.putExtra(f3489f, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]));
            }
            intent.putExtra("inbox_title_fixed", this.f3543aS);
            intent.putExtra("inbox_is_change_skin", this.f3706u);
            intent.putExtra("inbox_background_style", this.f3615bl);
            intent.putExtra("inbox_send_bubble_style", this.f3618bo);
            intent.putExtra("inbox_receive_bubble_style", this.f3619bp);
            if (!TextUtils.isEmpty(this.f3599bV)) {
                intent.putExtra("groupId", this.f3599bV);
            }
            intent.putExtra("sessionID", this.f3710y);
            startActivityForResult(intent, 17);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ed  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onOptionsItemSelected(android.view.MenuItem r12) {
        /*
            Method dump skipped, instructions count: 948
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    /* renamed from: Q */
    private boolean m4706Q() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = this.f3554ad.m55d(getActivity());
            try {
                C3250y.m11450b("[ChatONV] isReadyToCall : " + zM55d, f3484a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f3484a);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f3484a);
        return zM55d;
    }

    /* renamed from: R */
    private boolean m4708R() {
        boolean z = false;
        try {
            C0045a c0045a = this.f3554ad;
            if (C0045a.m37b(getActivity())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVInstalled : " + z, f3484a);
        return z;
    }

    /* renamed from: S */
    private boolean m4710S() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(getActivity(), EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVAvaiable : " + z, f3484a);
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (!this.f3563am && this.f3526aB != null) {
            ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(this.f3672cr, contextMenu);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            C1070el c1070el = (C1070el) adapterContextMenuInfo.targetView.getTag();
            if (c1070el != null && (c1070el.f4270ay instanceof AbstractViewOnClickListenerC0920x)) {
                AbstractViewOnClickListenerC0920x abstractViewOnClickListenerC0920x = (AbstractViewOnClickListenerC0920x) c1070el.f4270ay;
                contextMenuC0453a.setHeaderTitle(abstractViewOnClickListenerC0920x.mo5092a(this.f3672cr));
                contextMenuC0453a.clear();
                if (abstractViewOnClickListenerC0920x instanceof InterfaceC0907k) {
                    InterfaceC0907k interfaceC0907k = (InterfaceC0907k) abstractViewOnClickListenerC0920x;
                    if (interfaceC0907k.mo5098i()) {
                        contextMenuC0453a.add(R.string.chat_view_menu_copy).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0924ab(this, interfaceC0907k));
                    }
                }
                if (abstractViewOnClickListenerC0920x instanceof InterfaceC0909m) {
                    InterfaceC0909m interfaceC0909m = (InterfaceC0909m) abstractViewOnClickListenerC0920x;
                    if (interfaceC0909m.mo5096g()) {
                        contextMenuC0453a.add(R.string.chatview_menu_forward).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0925ac(this, interfaceC0909m));
                    }
                }
                if (abstractViewOnClickListenerC0920x instanceof InterfaceC0912p) {
                    InterfaceC0912p interfaceC0912p = (InterfaceC0912p) abstractViewOnClickListenerC0920x;
                    if (interfaceC0912p.mo5094e()) {
                        contextMenuC0453a.add(R.string.trunk_btn_share).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0926ad(this, interfaceC0912p));
                    }
                }
                if (abstractViewOnClickListenerC0920x instanceof InterfaceC0911o) {
                    InterfaceC0911o interfaceC0911o = (InterfaceC0911o) abstractViewOnClickListenerC0920x;
                    if (interfaceC0911o.mo5102k() && C3223ck.m11327a()) {
                        contextMenuC0453a.add(R.string.save).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0928af(this, interfaceC0911o));
                    }
                }
                if (this.f3709x == EnumC1450r.ONETOONE) {
                    EnumC1455w enumC1455w = c1070el.f4269ax;
                    C0952c c0952cM5143c = C0952c.m5143c();
                    String[] strArrSplit = c1070el.f4271az.split("\n");
                    if (!c1070el.f4244aF && c1070el.f4245aG == null && (Query.MIXED.equals(strArrSplit[0]) || enumC1455w == EnumC1455w.TEXT)) {
                        contextMenuC0453a.add(R.string.translate).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0929ag(this, c1070el, c0952cM5143c));
                    }
                }
                if (abstractViewOnClickListenerC0920x instanceof InterfaceC0908l) {
                    int i = adapterContextMenuInfo.position;
                    if (abstractViewOnClickListenerC0920x.mo5112b()) {
                        contextMenuC0453a.add(R.string.chat_view_menu_delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0930ah(this, i, abstractViewOnClickListenerC0920x));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Intent m4863b(EnumC1455w enumC1455w, String str, String str2) {
        Intent intent = new Intent(this.f3672cr, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC1455w.m6364a());
        intent.putExtra("inboxNO", this.f3703r);
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        intent.putExtra("chatType", this.f3709x.m6342a());
        intent.putExtra("is_forward_mode", true);
        return intent;
    }

    /* renamed from: a */
    public void m4973a(EnumC1455w enumC1455w, String str, String str2, String str3) {
        mo5019t();
        Intent intent = new Intent(this.f3672cr, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC1455w.m6364a());
        intent.putExtra("inboxNO", this.f3703r);
        if (enumC1455w == EnumC1455w.TEXT || enumC1455w == EnumC1455w.GEO) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("forward_sender_name", str3);
        }
        intent.putExtra("chatType", this.f3709x.m6342a());
        startActivity(intent);
    }

    /* renamed from: a */
    public void m4964a(long j) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
        abstractC3271aM11494a.mo11495a(R.string.ams_attention_title);
        abstractC3271aM11494a.mo11506b(R.string.buddy_mapping_resend_message);
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC0934al(this, j)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0933ak(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* renamed from: c */
    public void m4989c() {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
        abstractC3271aM11494a.mo11495a(R.string.ams_attention_title);
        abstractC3271aM11494a.mo11506b(R.string.buddy_mapping_alert_message);
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0935am(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* renamed from: d */
    public void m4994d() {
        if (this.f3505G == null || !this.f3505G.isShowing()) {
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
            abstractC3271aM11494a.mo11495a(R.string.menu_chat_close);
            abstractC3271aM11494a.mo11506b(R.string.close_chat_on_another_device);
            abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0937ao(this));
            this.f3505G = abstractC3271aM11494a.mo11505a();
            this.f3505G.show();
        }
    }

    /* renamed from: e */
    public void m4999e() {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
        abstractC3271aM11494a.mo11495a(R.string.menu_chat_close);
        if (EnumC1450r.m6340a(this.f3709x)) {
            abstractC3271aM11494a.mo11506b(R.string.chat_deleted_popup);
        } else {
            abstractC3271aM11494a.mo11506b(R.string.dialog_title_msgbox_delete);
        }
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0939aq(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0938ap(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* renamed from: f */
    public void m5004f() throws Throwable {
        if (!TextUtils.isEmpty(this.f3710y) && this.f3709x != EnumC1450r.BROADCAST) {
            if (this.f3530aF == null) {
                m4690I();
            }
            m5021v();
            this.f3530aF.m5838a(this.f3709x, this.f3710y, this.f3703r);
            return;
        }
        C1756p.m7230a(this.f3703r);
        this.f3551aa.startDelete(1, null, C1449q.f5381a, "inbox_no IN ('" + this.f3703r + "')", null);
        this.f3551aa.startDelete(2, null, C1454v.f5393a, "message_inbox_no='" + this.f3703r + "'", null);
        this.f3551aa.startDelete(3, null, C1457y.f5415a, "participants_inbox_no='" + this.f3703r + "'", null);
        C1555a.m6596a().m6600a(this.f3703r);
        C1561g.m6628a().m6635a(this.f3703r);
        m4711T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public void m4711T() {
        File[] fileArrListFiles = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().listFiles(new C0940ar(this));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                C3250y.m11450b("[Delete File] " + file + " : " + file.delete(), f3484a);
            }
        }
        C3243r.m11419a((C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/" + this.f3703r);
        this.f3530aF.m5901j();
        if (!GlobalApplication.m6456e()) {
            ((InterfaceC1027cw) getActivity()).mo4670c();
        } else {
            m4949s("");
            ((TabActivity) getActivity()).m1312a(R.id.child, new Intent(), EmptyChatFragment.class);
        }
        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.trunk_toast_deleted, 0).show();
    }

    /* renamed from: U */
    private void m4713U() {
        m4851au();
        m4676B();
        mo5019t();
        if (this.f3508J == null) {
            m4680D();
            this.f3508J = new DialogC1472a(this, this.f3509K);
        }
        if (!this.f3508J.isShowing()) {
            this.f3508J.show();
        }
    }

    /* renamed from: a */
    public void m4976a(File file, boolean z) {
        C3250y.m11450b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(this.f3672cr, (Class<?>) ImageModify.class);
        intent.setDataAndType(Uri.fromFile(file), "image/*");
        intent.putExtra("return-data", true);
        intent.putExtra("sendMode", true);
        intent.putExtra("randomFName", true);
        if (z) {
            startActivityForResult(intent, 21);
        } else {
            startActivityForResult(intent, 16);
        }
    }

    /* renamed from: a */
    public void m4965a(Uri uri, boolean z) {
        C3250y.m11450b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(this.f3672cr, (Class<?>) ImageModify.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("return-data", true);
        intent.putExtra("sendMode", true);
        intent.putExtra("randomFName", true);
        if (z) {
            startActivityForResult(intent, 21);
        } else {
            startActivityForResult(intent, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4766a(File file, String str, String str2, EnumC1455w enumC1455w, String str3) {
        if (file != null) {
            if (file.length() > 10485760) {
                C3641ai.m13210a(this.f3672cr, R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(file.getName(), ".");
            String strNextToken = null;
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            if (!C3243r.m11421a(enumC1455w, strNextToken)) {
                C3641ai.m13211a(this.f3672cr, this.f3672cr.getResources().getString(R.string.toast_supported_format) + " (" + strNextToken + ")", 0).show();
                return;
            }
            boolean z = false;
            if (TextUtils.isEmpty(this.f3710y) || this.f3709x == EnumC1450r.BROADCAST || "null".equals(this.f3710y)) {
                if (this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
                    m5021v();
                }
                z = true;
            }
            m4960a(file, strNextToken, enumC1455w, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[0]), z, str3, str, str2);
        }
    }

    /* renamed from: a */
    public void m4982a(String[] strArr) {
        int i = 0;
        synchronized (this.f3524Z) {
            if (this.f3709x == EnumC1450r.ONETOONE) {
                while (i < strArr.length) {
                    this.f3536aL.add(strArr[i]);
                    this.f3537aM.put(strArr[i], new C0264a(strArr[i]));
                    i++;
                }
                if (GlobalApplication.m6456e()) {
                    Intent intent = new Intent();
                    intent.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                    intent.putExtra("receivers", (String[]) this.f3536aL.toArray(new String[0]));
                    ((TabActivity) getActivity()).m1312a(R.id.fragment_msg_box, intent, ChatFragment.class);
                } else {
                    Intent intent2 = new Intent(this.f3672cr, (Class<?>) ChatActivity.class);
                    intent2.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                    intent2.putExtra("receivers", (String[]) this.f3536aL.toArray(new String[0]));
                    String string = this.f3613bj.getText().toString();
                    if (!TextUtils.isEmpty(string)) {
                        intent2.putExtra("lastTempMessage", string);
                    }
                    startActivity(intent2);
                    ((InterfaceC1027cw) getActivity()).mo4670c();
                }
            } else if (this.f3709x == EnumC1450r.BROADCAST) {
                if (!this.f3705t) {
                    if (this.f3536aL == null) {
                        this.f3536aL = new ArrayList<>();
                    }
                    this.f3537aM = new HashMap<>();
                    while (i < strArr.length) {
                        this.f3536aL.add(strArr[i]);
                        this.f3537aM.put(strArr[i], new C0264a(strArr[i]));
                        i++;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (i < strArr.length) {
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.INVITE.m6248a()), strArr[i], C1075eq.m5318a(C1360d.m6037b(this.f3672cr.getContentResolver(), strArr[i])))).append(Config.KEYVALUE_SPLIT);
                        C1381y.m6216c(this.f3672cr.getContentResolver(), this.f3703r, strArr[i]);
                        this.f3536aL.add(strArr[i]);
                        this.f3537aM.put(strArr[i], new C0264a(strArr[i]));
                        i++;
                    }
                    C1373q.m6181a(this.f3551aa, 1, this.f3703r, sb.toString(), C3159aa.m10962a().m10979a("chaton_id", ""));
                }
                C1370n.m6136c(this.f3672cr.getContentResolver(), this.f3703r);
            } else if (TextUtils.isEmpty(this.f3710y)) {
                while (i < strArr.length) {
                    this.f3536aL.add(strArr[i]);
                    this.f3537aM.put(strArr[i], new C0264a(strArr[i]));
                    i++;
                }
                C1370n.m6143g(this.f3672cr.getContentResolver(), this.f3703r);
            } else {
                if (this.f3530aF == null) {
                    m4690I();
                }
                if (this.f3709x == EnumC1450r.GROUPCHAT) {
                    this.f3530aF.m5856a(EnumC1455w.TEXT, this.f3710y, (String[]) this.f3536aL.toArray(new String[0]), strArr);
                } else if (this.f3709x == EnumC1450r.BROADCAST2) {
                    this.f3530aF.m5865a(this.f3710y, (String[]) this.f3536aL.toArray(new String[0]), strArr, true);
                }
                m5021v();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Capture Picture", f3484a);
                    }
                    if (this.f3608be != null) {
                        MediaScannerConnection.scanFile(this.f3672cr, new String[]{this.f3608be.getPath()}, null, null);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else if (this.f3608be != null) {
                        m4976a(new File(this.f3608be.getPath()), true);
                        break;
                    }
                    break;
                case 1:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Crop picture", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else if (intent != null && intent.getData() != null) {
                        m4965a(intent.getData(), false);
                        break;
                    }
                    break;
                case 4:
                    m4982a(intent.getStringArrayExtra("receivers"));
                    break;
                case 5:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Calendar", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4904g(intent);
                        break;
                    }
                case 6:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Geo tag", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4892e(intent);
                        break;
                    }
                case 7:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Contact", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4898f(intent);
                        break;
                    }
                case 9:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Voice", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4881c(intent);
                        break;
                    }
                case 11:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Video", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4909h(intent);
                        break;
                    }
                case 12:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Record Video", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4909h(intent);
                        break;
                    }
                case 15:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Animessage", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4740a(intent);
                        break;
                    }
                case 16:
                case 21:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Picture", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else if (intent != null && intent.getExtras() != null) {
                        m4743a(intent.getExtras());
                        break;
                    }
                    break;
                case 17:
                    if (intent.hasExtra("isClosing")) {
                        m5004f();
                        break;
                    } else {
                        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                        this.f3627bx = intent.getStringExtra(f3493j);
                        this.f3579bB = intent.getBooleanExtra(f3495l, false);
                        C3250y.m11454d("mTmpTitle:" + this.f3546aV);
                        if (stringArrayExtra == null) {
                            C3250y.m11454d("null arrayResult");
                        } else {
                            C3250y.m11454d("Not null arrayResult");
                        }
                        if (this.f3579bB) {
                            C3250y.m11454d("mTmpTitle not null!!!");
                            this.f3546aV = this.f3627bx;
                            String str = this.f3546aV;
                            this.f3541aQ = str;
                            this.f3639cI.setText(str);
                            this.f3540aP = this.f3546aV;
                        }
                        if (stringArrayExtra != null) {
                            m4982a(stringArrayExtra);
                            break;
                        }
                    }
                    break;
                case 18:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Document", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4869b(intent);
                        break;
                    }
                case 19:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - S Note", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4887d(intent);
                        break;
                    }
                case 22:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SendingMedia] Start - Multiple Pictures", f3484a);
                    }
                    if (this.f3530aF == null) {
                        m4741a(intent, i);
                        break;
                    } else {
                        m4914i(intent);
                        break;
                    }
                case 201:
                    if (i2 == -1) {
                        String stringExtra = intent.getStringExtra("source_text");
                        String stringExtra2 = intent.getStringExtra("target_text");
                        if (!TextUtils.isEmpty(stringExtra2)) {
                            m4875b(stringExtra, stringExtra2);
                        } else {
                            this.f3613bj.setText(f3487dd);
                        }
                        this.f3684dc = true;
                    }
                    if (this.f3634cD) {
                        m4984b();
                        break;
                    }
                    break;
            }
            return;
        }
        if (i == 201 && i2 == 0) {
            this.f3684dc = true;
            this.f3613bj.setText(f3487dd);
            if (this.f3634cD) {
                m4984b();
                return;
            }
            return;
        }
        if (!m4773a(i, intent)) {
            C3641ai.m13210a(this.f3672cr, R.string.cancel, 1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f3608be != null) {
            bundle.putString("captureUri", this.f3608be.toString());
        }
        if (!TextUtils.isEmpty(this.f3703r)) {
            bundle.putString("inbox_no", this.f3703r);
        }
        if (!TextUtils.isEmpty(this.f3710y)) {
            bundle.putString("session_id", this.f3710y);
        }
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    private void m4740a(Intent intent) {
        boolean z;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String string = extras.getString("AMS_FILE_PATH");
            String string2 = extras.getString("AMS_FILE_PATH_TO_MANAGE");
            boolean z2 = extras.getBoolean("AMS_WITH_TEXT", false);
            int i = extras.getInt("AMS_FILE_TYPE", 0);
            if (string != null) {
                File file = new File(string);
                EnumC1455w enumC1455w = EnumC1455w.IMAGE;
                if (C3025f.m10540b(file.getPath())) {
                    enumC1455w = EnumC1455w.AMS;
                }
                if (!z2) {
                    if (enumC1455w == EnumC1455w.AMS && i > 0) {
                        new Thread(new RunnableC1094fi(string2, i)).start();
                    }
                    if (TextUtils.isEmpty(this.f3710y) || this.f3709x == EnumC1450r.BROADCAST) {
                        if (this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
                            m5021v();
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    m4959a(new File(string), "jpg", enumC1455w, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[0]), z, (String) null);
                }
                if (z2) {
                    m4765a(file, enumC1455w, (String) null, (String) null, false);
                }
            }
        }
    }

    /* renamed from: b */
    private void m4869b(Intent intent) {
        EnumC1455w enumC1455w = EnumC1455w.DOCUMENT;
        File file = new File(intent.getData().getPath());
        EnumC1794a enumC1794aM7386c = FileExplorerActivity.m7386c(file.getName());
        if (enumC1794aM7386c == EnumC1794a.TXT || enumC1794aM7386c == EnumC1794a.SNB) {
            enumC1455w = EnumC1455w.FILE;
        } else if (enumC1794aM7386c == EnumC1794a.IMAGE) {
            enumC1455w = EnumC1455w.IMAGE;
        } else if (enumC1794aM7386c == EnumC1794a.VIDEO) {
            enumC1455w = EnumC1455w.VIDEO;
        }
        m4766a(file, (String) null, (String) null, enumC1455w, file.getName());
    }

    /* renamed from: c */
    private void m4881c(Intent intent) {
        m4766a(new File(intent.getData().getPath()), (String) null, (String) null, EnumC1455w.AUDIO, (String) null);
    }

    /* renamed from: d */
    private void m4887d(Intent intent) {
        Object obj = intent.getExtras().get("android.intent.extra.STREAM");
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.size() > 0) {
                File file = new File(((Uri) arrayList.get(0)).getPath());
                m4766a(file, (String) null, (String) null, EnumC1455w.IMAGE, file.getName());
            }
        }
    }

    /* renamed from: e */
    private void m4892e(Intent intent) {
        if (intent != null && intent.getStringExtra("GEOPOINT") != null) {
            boolean z = false;
            if (TextUtils.isEmpty(this.f3710y) || this.f3709x == EnumC1450r.BROADCAST || "null".equals(this.f3710y)) {
                if (this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
                    m5021v();
                }
                z = true;
            }
            synchronized (this.f3524Z) {
                this.f3530aF.m5851a(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, intent.getStringExtra("GEOPOINT"), intent.getStringExtra("GEOADDRESS"));
            }
        }
    }

    /* renamed from: f */
    private void m4898f(Intent intent) {
        if (intent != null) {
            m4766a(new File(intent.getStringExtra(f3488e)), (String) null, (String) null, EnumC1455w.CONTACT, intent.getStringExtra(f3492i));
        }
    }

    /* renamed from: g */
    private void m4904g(Intent intent) {
        if (intent != null) {
            m4766a(new File(intent.getStringExtra(f3488e)), (String) null, (String) null, EnumC1455w.CALENDAR, intent.getStringExtra(f3491h));
        }
    }

    /* renamed from: h */
    private void m4909h(Intent intent) throws Throwable {
        File file;
        if (intent != null && intent.getData() != null) {
            if ("file".equals(intent.getData().getScheme())) {
                file = new File(intent.getData().getPath());
            } else {
                C3246u c3246uM11426c = C3243r.m11426c(intent.getData().toString());
                file = c3246uM11426c != null ? c3246uM11426c.f11726a : null;
            }
            if (file == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("sendVideo file is null", f3484a);
                }
            } else if (file.length() > 10485760) {
                C3641ai.m13211a(getActivity(), getResources().getString(R.string.record_video_dialog_limit_title_max_size_reached), 0).show();
            } else {
                m4765a(file, EnumC1455w.VIDEO, (String) null, (String) null, false);
            }
        }
    }

    /* renamed from: i */
    private void m4914i(Intent intent) {
        if (intent != null) {
            this.f3671cq = intent.getParcelableArrayListExtra("preview_data");
            new AsyncTaskC1032da(this, null).execute(new Void[0]);
        }
    }

    /* renamed from: a */
    private void m4741a(Intent intent, int i) {
        try {
            this.f3602bY = intent;
            if (this.f3602bY == null) {
                this.f3602bY = new Intent();
            }
            this.f3602bY.putExtra("requestCode", i);
        } catch (Exception e) {
            C3250y.m11443a(e, f3484a);
        }
    }

    /* renamed from: a */
    private boolean m4773a(int i, Intent intent) {
        switch (i) {
            case 16:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m4811aa();
                    return true;
                }
                break;
            case 21:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m4723Z();
                    return true;
                }
                break;
        }
        return false;
    }

    /* renamed from: a */
    private void m4743a(Bundle bundle) throws Throwable {
        m4738a(bundle.getString("temp_file_path"), bundle.getBoolean("sendWithText", false), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public File m4738a(String str, boolean z, boolean z2) throws Throwable {
        File file;
        if ("content".equals(Uri.parse(str).getScheme())) {
            C3246u c3246uM11426c = C3243r.m11426c(str);
            file = c3246uM11426c != null ? c3246uM11426c.f11726a : null;
        } else {
            file = new File(str);
        }
        if (file != null) {
            if (C3188bc.m11135a(file)) {
                try {
                    file = C3188bc.m11136b(this.f3672cr, file, this.f3703r, null, false);
                } catch (FileNotFoundException e) {
                    C3250y.m11443a(e, f3484a);
                    file = null;
                } catch (IOException e2) {
                    C3250y.m11443a(e2, f3484a);
                    file = null;
                } catch (Exception e3) {
                    C3250y.m11443a(e3, f3484a);
                    file = null;
                } catch (OutOfMemoryError e4) {
                    C3250y.m11443a(e4, f3484a);
                    file = null;
                }
                if (file == null) {
                    return null;
                }
            }
            if (!z2) {
                if (!z) {
                    m4874b(file);
                    return file;
                }
                m4765a(file, EnumC1455w.IMAGE, (String) null, (String) null, false);
                return file;
            }
            return file;
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4874b(File file) {
        boolean z;
        if (this.f3710y == null || this.f3709x == EnumC1450r.BROADCAST) {
            if (this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
                m5021v();
            }
            z = true;
        } else {
            z = false;
        }
        m4959a(file, (String) null, EnumC1455w.IMAGE, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[0]), z, (String) null);
    }

    /* renamed from: a */
    public void m4972a(EnumC1455w enumC1455w, String str, String str2) {
        boolean z = false;
        if (TextUtils.isEmpty(this.f3710y) || this.f3709x == EnumC1450r.BROADCAST || "null".equals(this.f3710y)) {
            if (this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
                m5021v();
            }
            z = true;
        }
        if (this.f3562al) {
            m4767a(this.f3555ae, z, this.f3564an, this.f3565ao, this.f3613bj.getText().toString().trim(), this.f3556af);
            return;
        }
        String str3 = null;
        switch (C1023cs.f4106a[enumC1455w.ordinal()]) {
            case 3:
                this.f3530aF.m5848a(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, this.f3606bc, -1L, this.f3613bj.getText().toString().trim(), str2);
                return;
            case 4:
            default:
                return;
            case 5:
            case 9:
            case 10:
            case 11:
                break;
            case 6:
                if (C3025f.m10540b(this.f3555ae.getPath())) {
                    str3 = "jpg";
                    new Thread(new RunnableC1094fi(this.f3555ae.getPath(), this.f3557ag)).start();
                    break;
                }
                break;
            case 7:
                m4766a(this.f3555ae, str.trim(), str2, EnumC1455w.VIDEO, (String) null);
                return;
            case 8:
                synchronized (this.f3524Z) {
                    this.f3530aF.m5851a(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, this.f3564an, this.f3565ao);
                }
                return;
        }
        m4960a(this.f3555ae, str3, this.f3556af, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[0]), z, this.f3564an, str.trim(), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m4716V() {
        this.f3558ah.setVisibility(8);
        this.f3560aj.setVisibility(8);
        this.f3553ac = false;
        this.f3555ae = null;
        this.f3556af = null;
        this.f3564an = null;
        this.f3565ao = null;
        this.f3562al = false;
        if (TextUtils.isEmpty(this.f3613bj.getText().toString())) {
            this.f3582bE.setEnabled(false);
            this.f3583bF.setEnabled(false);
            if (this.f3621br) {
                this.f3582bE.setVisibility(8);
                this.f3603bZ.setVisibility(0);
                this.f3583bF.setVisibility(8);
            } else if (this.f3646cR && this.f3647cS && !this.f3648cT) {
                this.f3583bF.setVisibility(0);
                this.f3603bZ.setVisibility(8);
                this.f3582bE.setVisibility(8);
            } else {
                this.f3582bE.setVisibility(0);
                this.f3583bF.setVisibility(8);
                this.f3603bZ.setVisibility(8);
            }
        }
        this.f3559ai.setOnClickListener(null);
        this.f3560aj.setOnClickListener(null);
        this.f3606bc = null;
        m4693K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4765a(File file, EnumC1455w enumC1455w, String str, String str2, boolean z) {
        this.f3600bW.m11730a(this.f3559ai, new C1874c(file.getPath() + file.lastModified(), file.getPath(), enumC1455w != EnumC1455w.VIDEO, false));
        this.f3558ah.setVisibility(0);
        this.f3560aj.setVisibility(8);
        this.f3553ac = true;
        this.f3555ae = file;
        this.f3556af = enumC1455w;
        this.f3564an = str;
        this.f3565ao = str2;
        this.f3562al = z;
        if (EnumC1455w.AMS == enumC1455w) {
            this.f3559ai.setOnClickListener(this.f3520V);
        } else {
            this.f3559ai.setOnClickListener(null);
        }
        this.f3560aj.setOnClickListener(null);
        m4795aI();
        m4984b();
    }

    /* renamed from: g */
    public void m5006g() {
        this.f3672cr.getContentResolver().registerContentObserver(C1457y.m6367a(this.f3703r), true, this.f3511M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4772a(boolean z, boolean z2) {
        if (z) {
            if (this.f3660cf != null && !z2) {
                this.f3660cf.m7286a("TRANS_FAIL");
                return;
            }
            return;
        }
        if (this.f3660cf != null && z2) {
            this.f3660cf.m7286a("RECV_SUCC");
        }
    }

    /* renamed from: a */
    private void m4769a(String str, String str2, String str3) {
        if (!this.f3553ac) {
            try {
                EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(Integer.parseInt(str));
                if (enumC1455wM6358a == EnumC1455w.IMAGE || enumC1455wM6358a == EnumC1455w.AMS || enumC1455wM6358a == EnumC1455w.VIDEO) {
                    File file = new File(str2);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("restoreMediaFile uri:" + str2, f3484a);
                    }
                    if (file.exists()) {
                        if (!TextUtils.isEmpty(str3)) {
                            StringTokenizer stringTokenizer = new StringTokenizer(file.getName(), ".");
                            String strNextToken = null;
                            while (stringTokenizer.hasMoreTokens()) {
                                strNextToken = stringTokenizer.nextToken();
                            }
                            m4765a(file, enumC1455wM6358a, str3, strNextToken, true);
                            return;
                        }
                        m4765a(file, enumC1455wM6358a, (String) null, (String) null, false);
                        return;
                    }
                    return;
                }
                if (enumC1455wM6358a == EnumC1455w.ANICON) {
                    mo4986b(str2);
                }
            } catch (NumberFormatException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: h */
    public void m5007h() throws Throwable {
        File file;
        String strTrim;
        String strSubstring;
        boolean z;
        if (this.f3629bz) {
            mo5019t();
            if (EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.TEXT) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(this.f3625bv)) {
                    sb.append("Original name : ").append(this.f3625bv).append("\n----------------\n");
                }
                if (!TextUtils.isEmpty(this.f3623bt)) {
                    String string = sb.append(this.f3623bt).toString();
                    if (string.length() > 10000) {
                        string = string.substring(0, 9999);
                    }
                    if (this.f3580bC == EnumC3073u.API) {
                        if (TextUtils.isEmpty(this.f3710y) || "null".equals(this.f3710y)) {
                            if (this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
                                m5021v();
                            }
                            synchronized (this.f3524Z) {
                                this.f3530aF.m5861a(this.f3703r, EnumC1455w.m6358a(this.f3622bs), this.f3709x, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), string, (String) null);
                            }
                            return;
                        }
                        synchronized (this.f3524Z) {
                            this.f3530aF.m5853a(EnumC1455w.m6358a(this.f3622bs), this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), string, (String) null);
                        }
                        return;
                    }
                    CharSequence charSequenceM7508a = C1835j.m7508a(this.f3672cr, string, (int) C3172an.m11085a(30.0f));
                    this.f3613bj.setText(charSequenceM7508a);
                    this.f3613bj.setSelection(charSequenceM7508a.length());
                    return;
                }
                return;
            }
            if (EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.GEO) {
                if (TextUtils.isEmpty(this.f3710y) || "null".equals(this.f3710y)) {
                    if (this.f3709x != EnumC1450r.BROADCAST) {
                        m5021v();
                    }
                    z = true;
                } else {
                    z = false;
                }
                synchronized (this.f3524Z) {
                    this.f3530aF.m5852a(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, this.f3623bt, (String) null, EnumC1751k.f6455d);
                }
                return;
            }
            if (EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.APPLINK) {
                if ((TextUtils.isEmpty(this.f3710y) || "null".equals(this.f3710y)) && this.f3709x != EnumC1450r.BROADCAST) {
                    m5021v();
                }
                synchronized (this.f3524Z) {
                    this.f3530aF.m5842a(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), this.f3623bt, this.f3624bu);
                }
                return;
            }
            if (EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.LIVESHARE) {
                if ((TextUtils.isEmpty(this.f3710y) || "null".equals(this.f3710y)) && this.f3709x != EnumC1450r.BROADCAST) {
                    m5021v();
                }
                synchronized (this.f3524Z) {
                    this.f3530aF.m5884b(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), this.f3623bt, this.f3624bu);
                }
                return;
            }
            if (EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.LIVERECOMMEND) {
                if ((TextUtils.isEmpty(this.f3710y) || "null".equals(this.f3710y)) && this.f3709x != EnumC1450r.BROADCAST) {
                    m5021v();
                }
                synchronized (this.f3524Z) {
                    this.f3530aF.m5890c(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), this.f3623bt, this.f3624bu);
                }
                return;
            }
            if (EnumC1455w.m6358a(this.f3622bs) != EnumC1455w.LIVECONTENTS) {
                if (!C3223ck.m11327a()) {
                    C3250y.m11442a("[sendForward()] No sdcard", f3484a);
                    return;
                }
                C3250y.m11450b("Forward download_uri:" + this.f3623bt, f3484a);
                C3250y.m11450b("Forward content:" + this.f3624bu, f3484a);
                String str = this.f3623bt;
                boolean z2 = TextUtils.isEmpty(this.f3710y) || "null".equals(this.f3710y);
                if (this.f3626bw) {
                    String[] strArrSplit = this.f3624bu != null ? this.f3624bu.split("\n") : null;
                    if (strArrSplit != null && strArrSplit.length > 4) {
                        File file2 = str.contains("file://") ? new File(str.substring(7)) : null;
                        if (file2 != null) {
                            String strSubstring2 = file2.getName().substring(file2.getName().lastIndexOf(".") + 1);
                            if (strArrSplit.length <= 6 || !Query.MIXED.equals(strArrSplit[0])) {
                                strSubstring = null;
                            } else {
                                StringBuffer stringBuffer = new StringBuffer();
                                for (int i = 6; i < strArrSplit.length; i++) {
                                    stringBuffer.append(strArrSplit[i] + "\n");
                                }
                                strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                            }
                            if (EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.IMAGE || EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.AMS || EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.VIDEO) {
                                m4765a(file2, EnumC1455w.m6358a(this.f3622bs), this.f3624bu, strSubstring2.toUpperCase(), true);
                                if (!TextUtils.isEmpty(strSubstring)) {
                                    CharSequence charSequenceM7508a2 = C1835j.m7508a(this.f3672cr, strSubstring, (int) C3172an.m11085a(30.0f));
                                    this.f3613bj.setText(charSequenceM7508a2);
                                    try {
                                        this.f3613bj.setSelection(charSequenceM7508a2.length());
                                        return;
                                    } catch (Exception e) {
                                        C3250y.m11442a("Exception occurred while setting selection on edit text", getClass().getSimpleName());
                                        return;
                                    }
                                }
                                return;
                            }
                            m4767a(file2, z2, this.f3624bu, strSubstring2, strSubstring, EnumC1455w.m6358a(this.f3622bs));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f3588bK != null && this.f3588bK.containsKey("buddy_dragdata") && this.f3588bK.containsKey("key_clipdata")) {
                    if (this.f3588bK.getBoolean("buddy_dragdata", false)) {
                        ClipData clipData = (ClipData) this.f3588bK.getParcelable("key_clipdata");
                        if (this.f3688dh) {
                            m4774a(clipData, EnumC1025cu.EditTextSpace);
                            return;
                        } else {
                            m4774a(clipData, EnumC1025cu.ChatSpace);
                            return;
                        }
                    }
                    return;
                }
                if (str.startsWith("content:/")) {
                    C3246u c3246uM11426c = C3243r.m11426c(str);
                    file = c3246uM11426c != null ? c3246uM11426c.f11726a : null;
                } else {
                    file = str.startsWith("file:/") ? new File(Uri.parse(str).getPath()) : null;
                }
                if ((this.f3580bC == EnumC3073u.API || EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.IMAGE || EnumC1455w.m6358a(this.f3622bs) == EnumC1455w.VIDEO) && !TextUtils.isEmpty(this.f3624bu)) {
                    String str2 = this.f3624bu;
                    strTrim = C1835j.m7508a(this.f3672cr, str2.length() > 10000 ? str2.substring(0, 9999) : str2, (int) C3172an.m11085a(30.0f)).toString().trim();
                } else {
                    strTrim = null;
                }
                m4766a(file, strTrim, (String) null, EnumC1455w.m6358a(this.f3622bs), this.f3624bu);
            }
        }
    }

    /* renamed from: a */
    private void m4767a(File file, boolean z, String str, String str2, String str3, EnumC1455w enumC1455w) {
        if (z && this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
            m5021v();
        }
        this.f3530aF.m5878a(file, z, str, str2, str3, enumC1455w, this.f3536aL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        switch (view.getId()) {
            case R.id.layout_preview /* 2131165430 */:
                this.f3526aB.setSelection(this.f3526aB.getCount() - 1);
                m5010k();
                break;
            case R.id.btnAdd /* 2131165444 */:
                if (!C3197bl.m11159a()) {
                    if ((C1757q.m7251b() || m4837an()) && m4839ao() && m4834am()) {
                        m4713U();
                        break;
                    }
                }
                break;
            case R.id.btnChatImage /* 2131165445 */:
                if (!m4847as()) {
                    m4848at();
                    if (getResources().getConfiguration().orientation == 2) {
                        mo5019t();
                    }
                    this.f3526aB.setFocusable(false);
                    this.f3526aB.setItemsCanFocus(false);
                    this.f3526aB.setFocusable(false);
                    break;
                } else {
                    m4851au();
                    this.f3526aB.setFocusable(true);
                    m4676B();
                    break;
                }
            case R.id.btnChatSend /* 2131165452 */:
                this.f3613bj.requestFocus();
                m4875b(this.f3613bj.getText().toString(), (String) null);
                break;
            case R.id.btnChatTranslate /* 2131165455 */:
                if (this.f3647cS) {
                    this.f3683db = true;
                    C0952c c0952cM5143c = C0952c.m5143c();
                    Intent intent = new Intent();
                    intent.setAction("com.sec.android.app.translator.TRANSLATE");
                    intent.putExtra("do_not_use_select_result_dialog", true);
                    intent.putExtra(RtspHeaders.Values.MODE, "input");
                    String strM5157d = c0952cM5143c.m5157d(this.f3643cM);
                    String strM5157d2 = c0952cM5143c.m5157d(this.f3644cN);
                    intent.putExtra("source_language", strM5157d);
                    intent.putExtra("source_text", this.f3613bj.getText().toString());
                    intent.putExtra("target_language", strM5157d2);
                    intent.putExtra("auto_start_translation", true);
                    f3487dd = this.f3613bj.getText().toString();
                    C3250y.m11450b("Source Lang Code(DB) : " + this.f3643cM, f3484a);
                    C3250y.m11450b("Target Lang Code(DB) : " + this.f3644cN, f3484a);
                    C3250y.m11450b("Source Lang Code for S-Translator : " + strM5157d, f3484a);
                    C3250y.m11450b("Target Lang Code for S-Translator : " + strM5157d2, f3484a);
                    C3250y.m11450b("Calling Intent for translator App: com.sec.android.app.translator.TRANSLATE", getClass().getSimpleName());
                    this.f3634cD = this.f3633cC;
                    startActivityForResult(intent, 201);
                    break;
                } else {
                    m4875b(this.f3613bj.getText().toString(), (String) null);
                    break;
                }
        }
    }

    /* renamed from: a */
    private void m4770a(String str, String str2, boolean z) {
        if (C1757q.m7251b() || !m4837an()) {
        }
        if (m4839ao()) {
            if (!z && !m4841ap() && !this.f3553ac) {
                this.f3613bj.setText("");
                return;
            }
            if (!z && this.f3553ac) {
                m4972a(this.f3556af, str, str2);
                m4716V();
                return;
            }
            synchronized (this.f3524Z) {
                if (!C1337o.m5816f(this.f3710y) && !C1757q.m7251b()) {
                    if (this.f3709x != EnumC1450r.BROADCAST) {
                        m5021v();
                    }
                    this.f3530aF.m5861a(this.f3703r, EnumC1455w.TEXT, this.f3709x, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), str, str2);
                } else {
                    this.f3530aF.m5853a(EnumC1455w.TEXT, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), str, str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4875b(String str, String str2) throws IOException {
        m4770a(str, str2, false);
        C1833h.m7505b().m11719a(C1835j.m7509a(this.f3672cr, str), true);
        m4851au();
        this.f3613bj.setText("");
        this.f3526aB.setSelectionFromTop(this.f3526aB.getCount(), 0);
        m5010k();
        this.f3597bT = 30;
        m4676B();
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: a */
    public void mo4967a(View view, long j, boolean z) {
        CharSequence[] charSequenceArr;
        if (this.f3609bf && m4839ao() && view != null && view.getParent() != null) {
            int positionForView = this.f3526aB.getPositionForView(view) - 1;
            Cursor cursor = this.f3527aC.getCursor();
            cursor.moveToPosition(positionForView);
            if (z && this.f3532aH != 0 && this.f3598bU) {
                charSequenceArr = new CharSequence[]{GlobalApplication.m6451b().getString(R.string.view_resend), GlobalApplication.m6451b().getString(R.string.chat_send_sms), GlobalApplication.m6451b().getString(R.string.menu_chat_delete)};
            } else {
                charSequenceArr = new CharSequence[]{GlobalApplication.m6451b().getString(R.string.view_resend), GlobalApplication.m6451b().getString(R.string.menu_chat_delete)};
            }
            String strM6359a = EnumC1455w.m6359a(EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type"))));
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
            abstractC3271aM11494a.mo11500a(strM6359a);
            abstractC3271aM11494a.mo11504a(charSequenceArr, new DialogInterfaceOnClickListenerC0981bd(this, view, j, z));
            abstractC3271aM11494a.mo11511b(true);
            abstractC3271aM11494a.mo11512b();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1091ff
    /* renamed from: a */
    public void mo4978a(String str, int i, String str2, String str3, EnumC1450r enumC1450r) {
        if (EnumC1450r.m6341b(enumC1450r) || TextUtils.isEmpty(str3) || "null".equals(str3)) {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            C1337o c1337oM5795a = C1337o.m5795a(strValueOf, enumC1450r);
            if (c1337oM5795a != null) {
                c1337oM5795a.m5874a(this.f3518T);
                c1337oM5795a.m5880a(strValueOf, str, i);
                c1337oM5795a.m5873a(true);
                c1337oM5795a.m5897e(this.f3703r);
                this.f3530aF.m5893c(Long.MAX_VALUE);
                c1337oM5795a.m5875a(EnumC1450r.BROADCAST, str2, this.f3538aN, "", this.f3703r, this.f3611bh);
                return;
            }
            return;
        }
        this.f3530aF.m5901j();
        this.f3530aF.m5880a(this.f3703r, str, i);
        this.f3530aF.m5876a(enumC1450r, str2, this.f3538aN, str3, this.f3703r, this.f3611bh, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4768a(String str, EnumC1455w enumC1455w) {
        if (this.f3709x == EnumC1450r.ONETOONE) {
            Cursor cursorM6049e = C1360d.m6049e(CommonApplication.m11493l().getContentResolver(), this.f3704s);
            if (cursorM6049e != null && cursorM6049e.getCount() > 0) {
                cursorM6049e.moveToFirst();
                String string = cursorM6049e.getString(cursorM6049e.getColumnIndex("buddy_orginal_number"));
                String string2 = null;
                if (cursorM6049e.getColumnIndex("buddy_msisdns") > 0) {
                    string2 = cursorM6049e.getString(cursorM6049e.getColumnIndex("buddy_msisdns"));
                }
                String strM4962a = m4962a(string, string2);
                if (TextUtils.isEmpty(strM4962a)) {
                    if (cursorM6049e != null && !cursorM6049e.isClosed()) {
                        cursorM6049e.close();
                        return;
                    }
                    return;
                }
                startActivity(C3347i.m11775a(strM4962a, str));
            }
            if (cursorM6049e != null) {
                cursorM6049e.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4745a(View view, long j, String str, String str2, String str3, EnumC1455w enumC1455w, String str4, int i) {
        String str5;
        String strNextToken = "";
        File file = null;
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f3528aD.setText(R.string.popup_no_network_connection);
            this.f3528aD.setDuration(0);
            this.f3528aD.show();
            return;
        }
        if (enumC1455w == EnumC1455w.TEXT || enumC1455w == EnumC1455w.GEO || enumC1455w == EnumC1455w.ANICON || enumC1455w == EnumC1455w.POLL || enumC1455w == EnumC1455w.APPLINK || enumC1455w == EnumC1455w.LIVESHARE || enumC1455w == EnumC1455w.LIVERECOMMEND || enumC1455w == EnumC1455w.LIVECONTENTS) {
            str5 = "";
        } else {
            if (TextUtils.isEmpty(str3)) {
                C3641ai.m13210a(this.f3672cr, R.string.chat_send_recordvodeo_toast_failed, 0).show();
                return;
            }
            file = new File(Uri.parse(str3).getPath());
            StringTokenizer stringTokenizer = new StringTokenizer(str3, ".");
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            str5 = "." + strNextToken.toUpperCase();
        }
        boolean z = false;
        if (TextUtils.isEmpty(this.f3710y)) {
            if (this.f3709x != EnumC1450r.BROADCAST && !C1757q.m7251b()) {
                m5021v();
            }
            z = true;
        }
        if (enumC1455w == EnumC1455w.TEXT || enumC1455w == EnumC1455w.LIVESHARE || enumC1455w == EnumC1455w.LIVERECOMMEND || enumC1455w == EnumC1455w.LIVECONTENTS) {
            this.f3530aF.m5834a(j, str2, enumC1455w, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), str, z);
            return;
        }
        if (enumC1455w == EnumC1455w.GEO) {
            this.f3530aF.m5822a(j, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, str);
            return;
        }
        if (enumC1455w == EnumC1455w.ANICON) {
            String[] strArr = new String[0];
            String[] strArrSplit = str.split("\n");
            String strM9664c = C2646u.m9664c(strArrSplit[2]);
            if (strArrSplit.length > 6 && Query.MIXED.equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 6; i2 < strArrSplit.length; i2++) {
                    stringBuffer.append(strArrSplit[i2] + "\n");
                }
                this.f3530aF.m5883b(j, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, strM9664c, -1L, stringBuffer.toString().substring(0, stringBuffer.length() - 1));
                return;
            }
            this.f3530aF.m5883b(j, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, strM9664c, -1L, null);
            return;
        }
        if (enumC1455w == EnumC1455w.APPLINK) {
            this.f3530aF.m5881b(j, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), str);
            return;
        }
        if (enumC1455w == EnumC1455w.POLL) {
            this.f3530aF.m5820a(j, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), str);
            return;
        }
        if (i == 1 && str != null && str.trim().length() > 0) {
            this.f3530aF.m5818a(j, this.f3709x, str, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, str4, str5, enumC1455w);
            return;
        }
        if (file != null) {
            String strSubstring = null;
            if (str != null) {
                String[] strArrSplit2 = str.split("\n");
                if (strArrSplit2.length > 6) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i3 = 6; i3 < strArrSplit2.length; i3++) {
                        stringBuffer2.append(strArrSplit2[i3] + "\n");
                    }
                    strSubstring = stringBuffer2.toString().substring(0, stringBuffer2.length() - 1);
                }
            }
            this.f3530aF.m5831a(j, file, (String) null, enumC1455w, this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), z, str4, strSubstring);
            RunnableC1563i runnableC1563iM6629a = C1561g.m6628a().m6629a(j);
            if (runnableC1563iM6629a != null) {
                runnableC1563iM6629a.m6649a(new HandlerC0984bg(this, enumC1455w, view));
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: a */
    public void mo4969a(View view, String str, long j, EnumC1455w enumC1455w) {
        C1561g.m6628a().m6633a(str, j);
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: a */
    public void mo4966a(View view, long j) {
        C1555a.m6596a().m6602c(j);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: i */
    public void mo5008i() {
        if (!this.f3563am) {
            Intent intent = new Intent(this.f3672cr, (Class<?>) MeDialog.class);
            intent.putExtra("ME_DIALOG_NAME", C3159aa.m10962a().m10979a("Push Name", ""));
            intent.putExtra("ME_DIALOG_STATUSMSG", C3159aa.m10962a().m10979a("status_message", ""));
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: a */
    public void mo4968a(View view, ProfileImageView profileImageView, String str, String str2) {
        if (!this.f3563am) {
            if (GlobalApplication.m6456e()) {
                Intent intent = new Intent(this.f3672cr, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", str);
                intent.putExtra("PROFILE_BUDDY_NAME", str2);
                intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                startActivityForResult(intent, 20);
                return;
            }
            Intent intent2 = new Intent(this.f3672cr, (Class<?>) BuddyDialog.class);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
            startActivityForResult(intent2, 20);
        }
    }

    /* renamed from: W */
    private void m4717W() {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
        abstractC3271aM11494a.mo11495a(R.string.menu_chat_insert).mo11497a(R.array.attach_list, new DialogInterfaceOnClickListenerC0985bh(this));
        abstractC3271aM11494a.mo11505a().show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.chaton.p030f.InterfaceC1477f
    /* renamed from: a */
    public boolean mo4983a(int i) {
        switch (i) {
            case 0:
                m4717W();
                return false;
            case 1:
                m4723Z();
                return false;
            case 2:
                m4722Y();
                return false;
            case 3:
                m4719X();
                return false;
            case 4:
                if (!C3223ck.m11327a()) {
                    C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
                } else {
                    startActivityForResult(new Intent(this.f3672cr, (Class<?>) VoiceListActivity.class), 9);
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                if (!C3223ck.m11327a()) {
                    C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent = new Intent(this.f3672cr, (Class<?>) VCardReadContactActivity.class);
                    intent.putExtra("inbox_NO", this.f3703r);
                    startActivityForResult(intent, 7);
                }
                return false;
            case 7:
                if (!C3223ck.m11327a()) {
                    C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
                } else {
                    Intent intent2 = new Intent(this.f3672cr, (Class<?>) VCalendarListActivity2.class);
                    intent2.putExtra("inbox_NO", this.f3703r);
                    startActivityForResult(intent2, 5);
                }
                return false;
            case 8:
                Intent intent3 = new Intent(this.f3672cr, (Class<?>) GeotagActivity.class);
                intent3.putExtra("sendbutton", true);
                startActivityForResult(intent3, 6);
                return false;
            case 9:
                startActivityForResult(new Intent(this.f3672cr, (Class<?>) AMSFileListActivity.class), 15);
                return false;
            case 10:
                if (C0816a.m4366b()) {
                    Intent intent4 = new Intent();
                    intent4.setAction("com.sec.android.app.myfiles.PICK_DATA");
                    intent4.setComponent(new ComponentName("com.sec.android.app.myfiles", "com.sec.android.app.myfiles.fileselector.SingleSelectorActivity"));
                    intent4.putExtra("CONTENT_TYPE", FileExplorerActivity.m7387c());
                    try {
                        startActivityForResult(intent4, 18);
                    } catch (ActivityNotFoundException e) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("ActivityNotFound(My files)", f3484a);
                        }
                        Intent intent5 = new Intent();
                        intent5.setAction("com.sec.android.app.myfiles.PICK_DATA");
                        intent5.putExtra("CONTENT_TYPE", FileExplorerActivity.m7387c());
                        startActivityForResult(intent5, 18);
                    }
                } else {
                    startActivityForResult(new Intent(this.f3672cr, (Class<?>) FileExplorerActivity.class), 18);
                }
                return false;
            case 11:
                Intent intent6 = new Intent("android.intent.action.SNOTE_PICK");
                intent6.putExtra("SelectMode", "single");
                intent6.putExtra("ReturnType", "Imageonly");
                startActivityForResult(intent6, 19);
                return false;
        }
    }

    /* renamed from: X */
    private void m4719X() {
        if (!C3171am.m11072j() || !C3171am.m11073k()) {
            C3641ai.m13210a(this.f3672cr, R.string.recordvideo_unable_to_record_during_call, 0).show();
            return;
        }
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 1);
        intent.putExtra("return-data", true);
        intent.putExtra("android.intent.extra.sizeLimit", 9961472L);
        intent.putExtra("video-size", "720x480");
        try {
            startActivityForResult(intent, 12);
        } catch (ActivityNotFoundException e) {
            C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
        }
    }

    /* renamed from: Y */
    private void m4722Y() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("video/*");
        startActivityForResult(intent, 11);
    }

    /* renamed from: Z */
    private void m4723Z() {
        if (!C3171am.m11072j() || !C3171am.m11073k()) {
            C3641ai.m13210a(this.f3672cr, R.string.recordvideo_unable_to_record_during_call, 0).show();
            return;
        }
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.f3608be = null;
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".jpg";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//");
        if (!file.exists()) {
            file.mkdir();
        }
        this.f3608be = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//", str));
        intent.putExtra("output", this.f3608be);
        intent.putExtra("return-data", true);
        try {
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aa */
    public void m4811aa() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        if (!BuddyProfileActivity.m3573a(this.f3672cr, intent)) {
            intent = new Intent();
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
        }
        startActivityForResult(intent, 1);
    }

    /* renamed from: ab */
    private void m4813ab() {
        if (this.f3506H == null) {
            m4815ac();
        } else {
            if (this.f3506H.equals(this.f3615bl)) {
                if (GlobalApplication.m6456e()) {
                    m4816ad();
                    m4815ac();
                    return;
                }
                return;
            }
            m4816ad();
            m4815ac();
        }
        this.f3506H = this.f3615bl;
    }

    /* renamed from: ac */
    private void m4815ac() {
        this.f3581bD = m4921k(this.f3615bl);
        if (this.f3581bD != null) {
            if (this.f3616bm.equals("pa")) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f3581bD);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                this.f3585bH.setBackgroundDrawable(bitmapDrawable);
                return;
            }
            this.f3585bH.setImageBitmap(this.f3581bD);
            return;
        }
        m5009j();
    }

    /* renamed from: j */
    public void m5009j() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3585bH.setBackgroundDrawable(bitmapDrawable);
    }

    /* renamed from: ad */
    private void m4816ad() {
        if (this.f3581bD != null) {
            this.f3585bH.setImageBitmap(null);
            this.f3581bD.recycle();
            this.f3581bD = null;
        }
    }

    /* renamed from: k */
    private Bitmap m4921k(String str) throws Throwable {
        if ("skin_myskin.png_".equals(str)) {
            if (getResources().getConfiguration().orientation == 2) {
                return C3162ad.m10993a(this.f3672cr, C3347i.m11779b(), C3347i.m11780c(), (int) C3172an.m11085a(59.0f));
            }
            return C3162ad.m11010b(this.f3672cr, C3347i.m11779b(), C3347i.m11780c(), (int) C3172an.m11085a(59.0f));
        }
        C2598ck c2598ckM9582f = C2591cd.m9582f(this.f3672cr, this.f3615bl);
        if (c2598ckM9582f == null) {
            return null;
        }
        return c2598ckM9582f.f9826b;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.f3633cC) {
                if (m4847as()) {
                    mo5019t();
                } else {
                    m4798aK();
                }
            }
        } else {
            m4797aJ();
        }
        C3250y.m11454d("root w:" + this.f3585bH.getWidth());
        C3250y.m11454d("root h:" + this.f3585bH.getHeight());
    }

    @Override // com.sec.chaton.base.InterfaceC0459d
    /* renamed from: a */
    public boolean mo3094a() {
        if (this.f3633cC) {
            this.f3633cC = false;
            m4797aJ();
        }
        if (this.f3526aB.getChoiceMode() == 2) {
            m5016q();
            return true;
        }
        if (m4847as()) {
            m4851au();
            this.f3526aB.setFocusable(true);
            m4676B();
            return true;
        }
        C1770b.m7289a().m7302b();
        C1770b.m7289a().m7305c();
        C1770b.m7289a().m7307d();
        return false;
    }

    /* renamed from: ae */
    private void m4819ae() {
        if (this.f3689di != null) {
            this.f3689di.dismiss();
        }
        if (this.f3690dj != null) {
            this.f3690dj.dismiss();
        }
        if (this.f3691dk != null) {
            this.f3691dk.dismiss();
        }
    }

    /* renamed from: af */
    private void m4820af() {
        if (this.f3689di != null) {
            this.f3689di.hide();
        }
        if (this.f3690dj != null) {
            this.f3690dj.hide();
        }
        if (this.f3691dk != null) {
            this.f3691dk.hide();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        C3250y.m11454d("onContextItemSelected!!!!");
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C3250y.f11735c) {
            C3250y.m11453c("[Go out the ChatRoom] inboxNO : " + this.f3703r, getClass().getSimpleName());
        }
        if (this.f3584bG != null && this.f3613bj != null) {
            mo5019t();
            this.f3584bG = null;
        }
        if (this.f3530aF != null) {
            this.f3530aF.m5888b(this.f3518T);
            this.f3530aF = null;
        }
        super.onDestroy();
        if (this.f3660cf != null) {
            this.f3660cf.m7285a();
        }
        C1770b.m7289a().m7302b();
        C1770b.m7289a().m7305c();
        C1770b.m7289a().m7307d();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f3697dq);
    }

    /* renamed from: a */
    public AbstractC3271a m4961a(EnumC0273j enumC0273j) {
        this.f3590bM = AbstractC3271a.m11494a(this.f3672cr);
        if (enumC0273j == EnumC0273j.END_APP) {
            this.f3590bM.mo11506b(R.string.provision_error_end).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0986bi(this));
            return this.f3590bM;
        }
        if (enumC0273j == EnumC0273j.RESTART_APP) {
            this.f3590bM.mo11506b(R.string.auth_error_restart).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0987bj(this));
            return this.f3590bM;
        }
        return null;
    }

    @Override // com.sec.chaton.chat.InterfaceC1091ff
    /* renamed from: a */
    public void mo4963a(int i, String str, String str2, EnumC1455w enumC1455w) throws Resources.NotFoundException {
        String strM1329a;
        this.f3597bT += i;
        this.f3551aa.startQuery(0, null, C1454v.m6344a(this.f3597bT), null, "message_inbox_no=?", new String[]{this.f3703r}, null);
        if (str2 != null && !str2.equals(C3159aa.m10962a().m10979a("chaton_id", "")) && str != null && enumC1455w != null) {
            if (enumC1455w == EnumC1455w.TEXT) {
                if (C1075eq.m5326c(str)) {
                    str = str.substring(1);
                }
                this.f3665ck.setText(C1835j.m7508a(this.f3672cr, str, (int) C3172an.m11085a(30.0f)));
            } else if (enumC1455w == EnumC1455w.APPLINK) {
                this.f3665ck.setText(ApplinkMsgEntry.getDisplayMessage(str));
            } else {
                C0264a c0264a = this.f3537aM.get(str2);
                if (c0264a == null) {
                    strM1329a = getResources().getString(R.string.unknown);
                } else {
                    strM1329a = c0264a.m1329a();
                }
                boolean zEquals = Query.MIXED.equals(str.split("\n")[0]);
                if (this.f3709x == EnumC1450r.GROUPCHAT) {
                    this.f3665ck.setText(EnumC1455w.m6361a(enumC1455w, str, strM1329a, zEquals));
                } else if (this.f3709x == EnumC1450r.ONETOONE) {
                    this.f3665ck.setText(enumC1455w == EnumC1455w.POLL ? EnumC1455w.m6361a(enumC1455w, str, strM1329a, zEquals) : EnumC1455w.m6362a(enumC1455w, str, zEquals));
                } else {
                    return;
                }
            }
            C3205bt.m11182a(this.f3672cr).m11210a(this.f3664cj, str2);
            this.f3663ci.setVisibility(0);
        }
    }

    /* renamed from: k */
    public void m5010k() {
        if (this.f3526aB != null) {
            this.f3526aB.setTranscriptMode(2);
            this.f3503E = true;
        }
        this.f3663ci.setVisibility(8);
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC1834i
    /* renamed from: a */
    public void mo4977a(String str) {
        int selectionStart = this.f3613bj.getSelectionStart();
        int selectionEnd = this.f3613bj.getSelectionEnd();
        CharSequence charSequenceM7510b = C1835j.m7510b(this.f3672cr, str, (int) (this.f3613bj.getLineHeight() * 1.2f));
        if ((this.f3613bj.getText().length() + charSequenceM7510b.length()) - (selectionEnd - selectionStart) >= 10000) {
            Toast.makeText(CommonApplication.m11493l(), R.string.toast_text_max_Length, 0).show();
            return;
        }
        if (this.f3613bj.getEditableText() != null) {
            this.f3613bj.getEditableText().replace(selectionStart, selectionEnd, charSequenceM7510b, 0, charSequenceM7510b.length());
        }
        this.f3613bj.setSelection(charSequenceM7510b.length() + selectionStart, selectionStart + charSequenceM7510b.length());
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC1834i
    /* renamed from: b */
    public void mo4986b(String str) {
        m4851au();
        m4676B();
        this.f3526aB.setSelectionFromTop(this.f3526aB.getCount(), 0);
        this.f3503E = true;
        this.f3526aB.setTranscriptMode(2);
        this.f3606bc = str;
        EnumC2651z enumC2651zM9673i = C2646u.m9673i(this.f3672cr, str);
        if (enumC2651zM9673i == EnumC2651z.NORMAL) {
            this.f3560aj.setVisibility(8);
        } else {
            this.f3560aj.setVisibility(0);
            if (enumC2651zM9673i == EnumC2651z.SOUND) {
                this.f3560aj.setBackgroundResource(R.drawable.chat_haptic_sound_nor);
            } else if (enumC2651zM9673i == EnumC2651z.HAPTIC_SOUND) {
                this.f3560aj.setBackgroundResource(R.drawable.chat_haptic_sound_vi2_nor);
            } else {
                this.f3560aj.setBackgroundResource(R.drawable.chat_haptic_vibration_nor);
            }
        }
        AnimationDrawable animationDrawableM9654b = C2646u.m9654b(CommonApplication.m11493l(), str);
        if (animationDrawableM9654b != null) {
            this.f3559ai.setBackgroundDrawable(null);
            this.f3559ai.setImageDrawable(animationDrawableM9654b);
            if (enumC2651zM9673i != EnumC2651z.NORMAL) {
                this.f3560aj.setOnClickListener(new ViewOnClickListenerC0988bk(this));
            } else {
                this.f3560aj.setOnClickListener(null);
            }
            this.f3559ai.setOnClickListener(null);
            this.f3558ah.setVisibility(0);
            this.f3553ac = true;
            m4795aI();
            this.f3556af = EnumC1455w.ANICON;
            animationDrawableM9654b.start();
        }
        m4984b();
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC1834i
    /* renamed from: a */
    public void mo4974a(EnumC1807d enumC1807d, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("onAmsItemSelected. ItemType: ", enumC1807d, ", FilePath: ", str), f3484a);
        }
        m4851au();
        if (this.f3530aF == null) {
            C3641ai.m13210a(this.f3672cr, R.string.chat_send_recordvodeo_toast_failed, 0).show();
            return;
        }
        if (!new File(str).exists()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("Couldn't find ams file: " + str, f3484a);
            }
        } else {
            this.f3557ag = enumC1807d;
            m4765a(new File(str), EnumC1455w.AMS, (String) null, (String) null, false);
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC1834i
    /* renamed from: l */
    public void mo5011l() {
        m4851au();
        Intent intent = new Intent(this.f3672cr, (Class<?>) AMSFileListActivity.class);
        intent.putExtra("AMS_START_STATE", 1004);
        startActivityForResult(intent, 15);
    }

    /* renamed from: ag */
    private void m4822ag() {
        this.f3615bl = C3159aa.m10962a().m10979a("setting_change_skin", "-1");
        this.f3616bm = C3159aa.m10962a().m10979a("setting_change_skin_type", "pa");
        this.f3617bn = C3159aa.m10962a().m10979a("Default Font Size", "");
        this.f3618bo = C3159aa.m10962a().m10979a("setting_change_bubble_send", "-1");
        this.f3619bp = C3159aa.m10962a().m10979a("setting_change_bubble_receive", "-1");
        this.f3620bq = C3159aa.m10962a().m10977a("Setting enter key", (Boolean) false).booleanValue();
        this.f3621br = C3159aa.m10962a().m10977a("Setting push to talk", (Boolean) false).booleanValue();
        m5012m();
        if (C3250y.f11734b) {
            C3250y.m11450b("Preference information for chat room.", f3484a);
            C3250y.m11450b(C3364o.m11849a(" > Skin Id: ", this.f3615bl), f3484a);
            C3250y.m11450b(C3364o.m11849a(" > Font Size: ", this.f3617bn), f3484a);
            C3250y.m11450b(C3364o.m11849a(" > Send Bubble: ", this.f3618bo), f3484a);
            C3250y.m11450b(C3364o.m11849a(" > Receive Bubble: ", this.f3619bp), f3484a);
            C3250y.m11450b(C3364o.m11849a(" > Send With Enter: ", Boolean.valueOf(this.f3620bq)), f3484a);
            C3250y.m11450b(C3364o.m11849a(" > Push to talk: ", Boolean.valueOf(this.f3621br)), f3484a);
            C3250y.m11450b(C3364o.m11849a(" > Compatibility: ", C3159aa.m10962a().m10979a("compatibility", "")), f3484a);
        }
    }

    /* renamed from: m */
    public void m5012m() {
        if (this.f3615bl.equals("skin_01")) {
            this.f3615bl = "-1";
        } else if (this.f3615bl.equals("skin_bg_02")) {
            this.f3615bl = "-2";
        } else if (this.f3615bl.equals("skin_bg_03")) {
            this.f3615bl = "-3";
        } else if (this.f3615bl.equals("skin_bg_04")) {
            this.f3615bl = "-4";
        } else if (this.f3615bl.equals("skin_bg_05")) {
            this.f3615bl = "-5";
        }
        if (this.f3618bo.equals("bubble_01")) {
            this.f3618bo = "-1";
        } else if (this.f3618bo.equals("bubble_02")) {
            this.f3618bo = "-2";
        } else if (this.f3618bo.equals("bubble_03")) {
            this.f3618bo = "-3";
        } else if (this.f3618bo.equals("bubble_04")) {
            this.f3618bo = "-4";
        } else if (this.f3618bo.equals("bubble_05")) {
            this.f3618bo = "-5";
        }
        if (this.f3619bp.equals("bubble_01")) {
            this.f3619bp = "-1";
            return;
        }
        if (this.f3619bp.equals("bubble_02")) {
            this.f3619bp = "-2";
            return;
        }
        if (this.f3619bp.equals("bubble_03")) {
            this.f3619bp = "-3";
        } else if (this.f3619bp.equals("bubble_04")) {
            this.f3619bp = "-4";
        } else if (this.f3619bp.equals("bubble_05")) {
            this.f3619bp = "-5";
        }
    }

    @Override // com.sec.widget.InterfaceC3643ak
    /* renamed from: a */
    public void mo4970a(View view, boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("OnHeightChanged - " + String.valueOf(z), "ChatFragment");
        }
    }

    /* renamed from: a */
    public long m4959a(File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3) {
        if (file.length() > 10485760) {
            C3641ai.m13210a(this.f3672cr, R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
            return -1L;
        }
        this.f3526aB.setSelectionFromTop(this.f3526aB.getCount(), 0);
        this.f3503E = true;
        this.f3526aB.setTranscriptMode(2);
        return this.f3530aF.m5857a(file, str, enumC1455w, enumC1450r, str2, strArr, z, str3);
    }

    /* renamed from: a */
    public long m4960a(File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5) {
        if (file.length() > 10485760) {
            C3641ai.m13210a(this.f3672cr, R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
            return -1L;
        }
        this.f3526aB.setSelectionFromTop(this.f3526aB.getCount(), 0);
        this.f3503E = true;
        this.f3526aB.setTranscriptMode(2);
        return this.f3530aF.m5859a(file, str, enumC1455w, enumC1450r, str2, strArr, z, str3, str4, str5);
    }

    /* renamed from: n */
    public void m5013n() {
        if (this.f3604ba && this.f3551aa != null) {
            this.f3551aa.startDelete(3, null, C1454v.f5393a, "message_sender=? AND message_inbox_no=? AND message_content_type=?", new String[]{this.f3703r, this.f3703r, String.valueOf(EnumC1455w.SYSTEM.m6364a())});
        }
        this.f3604ba = false;
    }

    /* renamed from: o */
    public void m5014o() {
    }

    /* renamed from: p */
    public void m5015p() {
        this.f3563am = true;
        if (m4847as()) {
            m4851au();
        }
        m4696L();
        this.f3552ab.findItem(R.id.chat_menu_delete_confirm).setEnabled(false);
        this.f3639cI.setText(this.f3672cr.getString(R.string.chat_view_menu_delete_message));
        mo5019t();
        this.f3526aB.setChoiceMode(2);
        this.f3526aB.setTranscriptMode(0);
        this.f3569as.setVisibility(8);
        this.f3568ar.setVisibility(0);
        this.f3568ar.setChecked(false);
        C1770b.m7289a().m7302b();
        if (this.f3527aC != null) {
            this.f3527aC.m5285a(EnumC1071em.SELECT_NONE);
        }
    }

    /* renamed from: q */
    public void m5016q() {
        this.f3563am = false;
        m4696L();
        this.f3639cI.setText(this.f3541aQ);
        this.f3568ar.setVisibility(8);
        if (this.f3526aB != null) {
            this.f3526aB.setChoiceMode(0);
            this.f3526aB.clearChoices();
        }
        if (this.f3609bf) {
            this.f3569as.setVisibility(0);
        }
    }

    /* renamed from: r */
    public void m5017r() {
        if (!m4793aH()) {
            C3641ai.m13210a(this.f3672cr, R.string.toast_no_delete_data, 0).show();
            m5016q();
            return;
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
        abstractC3271aM11494a.mo11495a(R.string.chat_view_menu_delete_message);
        if (this.f3527aC.m5291d() == EnumC1071em.SELECT_ALL) {
            abstractC3271aM11494a.mo11506b(R.string.all_messages_will_be_deleted);
        } else {
            abstractC3271aM11494a.mo11506b(R.string.selected_messages_will_be_deleted);
        }
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0993bp(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0992bo(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ah */
    public void m4824ah() {
        int i;
        int size;
        if (this.f3709x == EnumC1450r.ONETOONE) {
            i = R.string.dialog_header_text;
            size = 0;
        } else if (this.f3709x == EnumC1450r.GROUPCHAT) {
            i = R.string.buddy_list_optionmenu_groupchat;
            size = this.f3536aL.size() + 1;
        } else if (EnumC1450r.m6340a(this.f3709x)) {
            i = R.string.buddy_list_optionmenu_broadcast;
            size = this.f3536aL.size();
        } else {
            C3250y.m11442a("unknown ChatType : " + this.f3709x, f3484a);
            i = R.string.dialog_header_text;
            size = 0;
        }
        StringBuilder sb = new StringBuilder(GlobalApplication.m6451b().getString(i));
        if (size > 0) {
            sb.append("(").append(String.valueOf(size)).append(")");
        }
        this.f3614bk = sb.toString();
        this.f3640cJ.setText(this.f3614bk);
        if (this.f3709x == EnumC1450r.ONETOONE) {
            this.f3640cJ.setVisibility(8);
        } else {
            this.f3640cJ.setVisibility(0);
        }
        m4888d(this.f3612bi);
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: a */
    public void mo4979a(boolean z) {
        if (this.f3563am) {
            this.f3552ab.findItem(R.id.chat_menu_delete_confirm).setEnabled(z);
            if (this.f3527aC.m5291d() == EnumC1071em.SELECT_ALL) {
                this.f3568ar.setChecked(true);
            } else {
                this.f3568ar.setChecked(false);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1091ff
    /* renamed from: s */
    public boolean mo5018s() {
        return this.f3503E;
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: a */
    public void mo4981a(boolean z, Cursor cursor, View view) {
        if (m4827ai() && m4829aj() && m4830ak() && m4834am()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
            if (!C1555a.m6596a().m6599a(j, false)) {
                C1555a.m6596a().m6597a(view, this, this.f3518T, cursor.getPosition(), string2, false, string, j, enumC1455wM6358a, this.f3709x, string3);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: t */
    public void mo5019t() {
        this.f3584bG.hideSoftInputFromWindow(this.f3613bj.getWindowToken(), 0);
        this.f3633cC = false;
        m4797aJ();
        if (C3175aq.m11088a()) {
            m4820af();
        }
    }

    /* renamed from: u */
    public void m5020u() {
        if (!this.f3633cC && getResources() != null) {
            Configuration configuration = getResources().getConfiguration();
            if (configuration.orientation == 2) {
                this.f3584bG.showSoftInput(this.f3613bj, 0);
                m4798aK();
            } else if (configuration.orientation == 1) {
                this.f3584bG.showSoftInput(this.f3613bj, 1);
            }
            this.f3633cC = true;
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: a */
    public void mo4980a(boolean z, Cursor cursor) {
        if (m4827ai() && m4829aj() && m4830ak()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            Intent intent = new Intent(this.f3672cr, (Class<?>) ImagePagerActivity.class);
            if (j != 0) {
                j2 = j;
            }
            intent.putExtra("messageId", j2);
            intent.putExtra("inboxNo", string);
            intent.putExtra("isValid", this.f3609bf);
            intent.putExtra("chatType", this.f3709x.m6342a());
            intent.putExtra("sessionID", this.f3710y);
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: b */
    public void mo4987b(boolean z, Cursor cursor) {
        if (m4827ai() && m4829aj() && m4830ak()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            Intent intent = new Intent(this.f3672cr, (Class<?>) ImagePagerActivity.class);
            if (j != 0) {
                j2 = j;
            }
            intent.putExtra("messageId", j2);
            intent.putExtra("inboxNo", string);
            intent.putExtra("isValid", this.f3609bf);
            intent.putExtra("chatType", this.f3709x.m6342a());
            intent.putExtra("sessionID", this.f3710y);
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: b */
    public void mo4988b(boolean z, Cursor cursor, View view) {
        if (m4827ai() && m4829aj() && m4830ak() && m4833al()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            if ((TextUtils.isEmpty(string3) || C0816a.f3113b.equals(string3)) && !C1555a.m6596a().m6598a(j)) {
                if (m4834am()) {
                    C1555a.m6596a().m6597a(view, this, this.f3518T, cursor.getPosition(), string2, false, string, j, enumC1455wM6358a, this.f3709x, string4);
                    if (z) {
                        this.f3601bX = m4867b(j);
                        this.f3601bX.m11483a(0);
                        this.f3601bX.show();
                        AsyncTaskC1557c asyncTaskC1557cM6601b = C1555a.m6596a().m6601b(j);
                        if (asyncTaskC1557cM6601b != null) {
                            asyncTaskC1557cM6601b.m6610a(this.f3601bX);
                        }
                    }
                } else {
                    return;
                }
            }
            C1770b.m7289a().m7299a(string3, j, view, z, cursor, cursor.getPosition(), this.f3518T, this.f3709x);
            C1770b.m7289a().m7298a(this.f3703r);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: c */
    public void mo4993c(boolean z, Cursor cursor, View view) {
        if (m4827ai() && m4829aj() && m4830ak()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            if (TextUtils.isEmpty(string3) || C0816a.f3113b.equals(string3)) {
                if (!C1555a.m6596a().m6598a(j) && m4834am()) {
                    C1555a.m6596a().m6597a(view, this, this.f3518T, cursor.getPosition(), string2, false, string, j, enumC1455wM6358a, this.f3709x, string4);
                    this.f3601bX = m4867b(j);
                    this.f3601bX.m11483a(0);
                    this.f3601bX.show();
                    AsyncTaskC1557c asyncTaskC1557cM6601b = C1555a.m6596a().m6601b(j);
                    if (asyncTaskC1557cM6601b != null) {
                        asyncTaskC1557cM6601b.m6610a(this.f3601bX);
                        asyncTaskC1557cM6601b.m6608a(this.f3521W);
                        return;
                    }
                    return;
                }
                return;
            }
            m4927l(string3);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: c */
    public void mo4992c(boolean z, Cursor cursor) {
        String strSubstring;
        if (m4827ai() && m4829aj()) {
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            if (!C0816a.m4365a()) {
                C3641ai.m13210a(this.f3672cr, R.string.toast_googleMAP_unavailable, 0).show();
                return;
            }
            if (!TextUtils.isEmpty(string)) {
                String[] strArrSplit = string.split("\n");
                if (strArrSplit.length > 5) {
                    if (strArrSplit.length <= 6) {
                        strSubstring = null;
                    } else {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 6; i < strArrSplit.length; i++) {
                            stringBuffer.append(strArrSplit[i] + "\n");
                        }
                        strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("http://maps.google.com/maps?q=loc:");
                    stringBuffer2.append(strArrSplit[5]);
                    if (strSubstring != null) {
                        stringBuffer2.append("(").append(strSubstring.replaceAll("[\\(\\)]", " ")).append(")");
                    }
                    try {
                        this.f3672cr.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer2.toString())));
                    } catch (ActivityNotFoundException e) {
                        C3641ai.m13210a(this.f3672cr, R.string.no_applications_can_perform_this_action, 0).show();
                    }
                }
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: d */
    public void mo4997d(boolean z, Cursor cursor, View view) {
        if (m4827ai() && m4829aj() && m4830ak()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            if (TextUtils.isEmpty(string3) || C0816a.f3113b.equals(string3)) {
                if (!C1555a.m6596a().m6598a(j) && m4834am()) {
                    C1555a.m6596a().m6597a(view, this, this.f3518T, cursor.getPosition(), string2, false, string, j, enumC1455wM6358a, this.f3709x, string4);
                    this.f3601bX = m4867b(j);
                    this.f3601bX.m11483a(0);
                    this.f3601bX.show();
                    AsyncTaskC1557c asyncTaskC1557cM6601b = C1555a.m6596a().m6601b(j);
                    if (asyncTaskC1557cM6601b != null) {
                        asyncTaskC1557cM6601b.m6610a(this.f3601bX);
                        asyncTaskC1557cM6601b.m6608a(this.f3521W);
                        return;
                    }
                    return;
                }
                return;
            }
            m4930m(string3);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: e */
    public void mo5002e(boolean z, Cursor cursor, View view) {
        if (m4827ai() && m4829aj() && m4830ak()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            if (TextUtils.isEmpty(string3) || C0816a.f3113b.equals(string3)) {
                if (!C1555a.m6596a().m6598a(j) && m4834am()) {
                    C1555a.m6596a().m6597a(view, this, this.f3518T, cursor.getPosition(), string2, false, string, j, enumC1455wM6358a, this.f3709x, string4);
                    this.f3601bX = m4867b(j);
                    this.f3601bX.m11483a(0);
                    this.f3601bX.show();
                    AsyncTaskC1557c asyncTaskC1557cM6601b = C1555a.m6596a().m6601b(j);
                    if (asyncTaskC1557cM6601b != null) {
                        asyncTaskC1557cM6601b.m6610a(this.f3601bX);
                        asyncTaskC1557cM6601b.m6608a(this.f3521W);
                        return;
                    }
                    return;
                }
                return;
            }
            m4935n(string3);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: d */
    public void mo4996d(boolean z, Cursor cursor) {
        boolean z2;
        try {
            MessageType4Entry messageType4Entry = ApplinkMsgEntry.parse(cursor.getString(cursor.getColumnIndex("message_content")));
            if (messageType4Entry instanceof ApplinkMsgEntry) {
                ApplinkMsgEntry applinkMsgEntry = (ApplinkMsgEntry) messageType4Entry;
                if (C3250y.f11734b) {
                    C3250y.m11450b("onAppLinkClickListener()", f3484a);
                    C3250y.m11450b(applinkMsgEntry.toString(), f3484a);
                }
                String appName = applinkMsgEntry.getAppName();
                ApplinkMsgEntry.ContentEntry.AppInfoEntry.ParamEntry param = applinkMsgEntry.getParam("android", "phone");
                if (param == null) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("-- not matched anything-- ", f3484a);
                        return;
                    }
                    return;
                }
                PackageManager packageManager = this.f3672cr.getPackageManager();
                try {
                } catch (PackageManager.NameNotFoundException e) {
                    C3250y.m11443a(e, f3484a);
                }
                if (packageManager.getPackageInfo(param.f5631id, 64) != null) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b(param.f5631id + " is installed", f3484a);
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    try {
                        Intent intent = new Intent("android.intent.action.SEND", Uri.parse(param.executeUri));
                        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                            if (C3250y.f11734b) {
                                C3250y.m11450b(param.f5631id + " supports this action", f3484a);
                            }
                            startActivity(intent);
                            return;
                        } else {
                            if (C3250y.f11734b) {
                                C3250y.m11450b(param.f5631id + " does not support this action", f3484a);
                                return;
                            }
                            return;
                        }
                    } catch (Exception e2) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e2, f3484a);
                            return;
                        }
                        return;
                    }
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b(param.f5631id + " is not installed", f3484a);
                }
                if (TextUtils.isEmpty(param.installUrl)) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b(param.f5631id + " does not have installUrl", f3484a);
                    }
                } else {
                    String str = param.installUrl;
                    AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
                    abstractC3271aM11494a.mo11495a(R.string.setting_category_notice);
                    abstractC3271aM11494a.mo11509b(String.format(getResources().getString(R.string.applink_popup_install), appName)).mo11511b(true).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0995br(this, str)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0994bq(this));
                    abstractC3271aM11494a.mo11512b();
                }
            }
        } catch (Exception e3) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e3, f3484a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4927l(String str) {
        Intent intent = new Intent(this.f3672cr, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 2);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m4930m(String str) {
        Intent intent = new Intent(this.f3672cr, (Class<?>) ReadVCardActivity.class);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m4935n(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse("file://" + (str.startsWith("file://") ? str.substring(6) : str)), FileExplorerActivity.m7383a(str.substring(str.lastIndexOf(".") + 1)));
            if (BuddyProfileActivity.m3573a(this.f3672cr, intent)) {
                startActivity(intent);
                return;
            }
            EnumC1794a enumC1794aM7386c = FileExplorerActivity.m7386c(str);
            if (enumC1794aM7386c == EnumC1794a.SNB) {
                AbstractC3271a.m11494a(this.f3672cr).mo11495a(R.string.setting_category_notice).mo11506b(R.string.popup_install_office_viewer).mo11515d(R.string.dialog_ok, null).mo11512b();
                return;
            }
            if (enumC1794aM7386c != EnumC1794a.UNKNOWN && enumC1794aM7386c != EnumC1794a.DIRECTORY) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                String string = getString(R.string.doc_query_viewer);
                if (enumC1794aM7386c == EnumC1794a.HWP) {
                    string = getString(R.string.doc_query_hwp);
                } else if (enumC1794aM7386c == EnumC1794a.GUL) {
                    string = getString(R.string.doc_query_gul);
                } else if (enumC1794aM7386c == EnumC1794a.XLS || enumC1794aM7386c == EnumC1794a.PDF || enumC1794aM7386c == EnumC1794a.DOC || enumC1794aM7386c == EnumC1794a.PPT) {
                    string = getString(R.string.doc_query_viewer);
                }
                String str2 = "market://search?q=" + string + "&c=apps";
                intent2.setData(Uri.parse(str2));
                boolean zM3573a = BuddyProfileActivity.m3573a(this.f3672cr, intent2);
                if (C3250y.f11734b) {
                    C3250y.m11450b("isMarketAvailable: " + zM3573a + ", strUri : " + str2, "ChatListAdapter");
                }
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
                abstractC3271aM11494a.mo11495a(R.string.setting_category_notice).mo11506b(R.string.insert_need_install_viewer).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0997bt(this, zM3573a, intent2));
                abstractC3271aM11494a.mo11512b();
            }
        }
    }

    /* renamed from: b */
    private AlertDialogC3256c m4867b(long j) {
        if (this.f3601bX == null) {
            this.f3601bX = new AlertDialogC3256c(this.f3672cr);
            this.f3601bX.setTitle(R.string.download_title);
            this.f3601bX.setMessage(getString(R.string.anicon_file_downloading));
            this.f3601bX.setCancelable(false);
        }
        this.f3601bX.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0998bu(this, j));
        return this.f3601bX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ai */
    public boolean m4827ai() {
        if (this.f3672cr != null) {
            return true;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("mAttachedActivity is null", ChatFragment.class.getSimpleName());
        }
        return false;
    }

    /* renamed from: aj */
    private boolean m4829aj() {
        return !C3197bl.m11159a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ak */
    public boolean m4830ak() {
        if (C3223ck.m11327a()) {
            return true;
        }
        C3641ai.m13210a(this.f3672cr, R.string.sdcard_not_found, 0).show();
        return false;
    }

    /* renamed from: al */
    private boolean m4833al() {
        if (C3171am.m11072j() && C3171am.m11073k()) {
            return true;
        }
        C3641ai.m13210a(this.f3672cr, R.string.chatroom_unable_to_record_during_call, 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: am */
    public boolean m4834am() {
        if (C3223ck.m11331e()) {
            return true;
        }
        AbstractC3271a.m11494a(this.f3672cr).mo11495a(R.string.pop_up_attention).mo11506b(R.string.popup_not_enough_memory).mo11515d(R.string.dialog_ok, null).mo11512b();
        return false;
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: c */
    public void mo4991c(String str) {
        Intent intent = new Intent(this.f3672cr, (Class<?>) DetailTextView.class);
        intent.putExtra("fulltext", str);
        intent.putExtra("View All", this.f3541aQ);
        startActivity(intent);
    }

    /* renamed from: an */
    private boolean m4837an() {
        return m4877b(true);
    }

    /* renamed from: b */
    private boolean m4877b(boolean z) {
        int iM6733a = C1594v.m6733a(this.f3672cr);
        if (-3 != iM6733a && -2 != iM6733a) {
            return true;
        }
        this.f3528aD.setText(R.string.popup_no_network_connection);
        this.f3528aD.setDuration(0);
        if (!z) {
            return false;
        }
        this.f3528aD.show();
        return false;
    }

    /* renamed from: ao */
    private boolean m4839ao() {
        if (!EnumC1450r.m6340a(this.f3709x) || this.f3536aL.size() != 0) {
            return true;
        }
        this.f3528aD.setText(R.string.chat_title_no_buddies);
        this.f3528aD.setDuration(0);
        this.f3528aD.show();
        return false;
    }

    /* renamed from: ap */
    private boolean m4841ap() {
        return !TextUtils.isEmpty(this.f3613bj.getText().toString().trim().replaceAll("\n", ""));
    }

    /* renamed from: v */
    public void m5021v() {
        if (this.f3501C == null) {
            this.f3501C = (ProgressDialog) new C3263j(this.f3672cr).m11487a(R.string.setting_webview_please_wait);
        }
        if (!this.f3501C.isShowing()) {
            this.f3501C.show();
        }
    }

    /* renamed from: w */
    public void m5022w() {
        if (this.f3501C != null && this.f3501C.isShowing()) {
            this.f3501C.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aq */
    public void m4843aq() {
        if (this.f3502D == null) {
            this.f3502D = (ProgressDialog) new C3263j(this.f3672cr).m11487a(R.string.chat_sync_wait);
        }
        if (!this.f3502D.isShowing()) {
            this.f3502D.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ar */
    public void m4844ar() {
        if (this.f3502D != null && this.f3502D.isShowing()) {
            this.f3502D.dismiss();
        }
    }

    /* renamed from: as */
    private boolean m4847as() {
        return this.f3587bJ != null && this.f3587bJ.getVisibility() == 0;
    }

    /* renamed from: at */
    private void m4848at() {
        if (this.f3587bJ == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Initialize emoticon selection view.", f3484a);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.emoticon_selection_view_height));
            this.f3587bJ = new EmoticonSelectionView(this.f3672cr);
            if (!GlobalApplication.m6456e()) {
                this.f3587bJ.m7439a(this.f3636cF);
                if (layoutParams.height > 0) {
                    layoutParams.height -= (int) C3172an.m11085a(49.5f);
                }
            }
            this.f3587bJ.setLayoutParams(layoutParams);
            this.f3587bJ.setVisibility(8);
            this.f3587bJ.setEmoticonSelectedListener(this);
            this.f3586bI.addView(this.f3587bJ);
            if (this.f3642cL == null) {
                this.f3642cL = new View(this.f3672cr);
                this.f3642cL.setBackgroundColor(getResources().getColor(R.color.emoticon_under_background));
                this.f3642cL.setOnClickListener(new ViewOnClickListenerC0999bv(this));
            }
            this.f3570at.addView(this.f3642cL);
            getFragmentManager().executePendingTransactions();
        }
        if (!GlobalApplication.m6456e()) {
            ((ActionBarFragmentActivity) this.f3672cr).m11543k().mo11580a(this.f3636cF);
            ((ActionBarFragmentActivity) this.f3672cr).m11543k().mo11596e(16);
            m4699N();
        }
        this.f3587bJ.setVisibility(0);
        this.f3642cL.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: au */
    public void m4851au() {
        if (this.f3587bJ != null && this.f3642cL != null) {
            this.f3587bJ.setVisibility(8);
            this.f3642cL.setVisibility(8);
            if (!GlobalApplication.m6456e()) {
                m4702O();
                if (!this.f3563am) {
                    m4696L();
                    this.f3639cI.setText(this.f3541aQ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4771a(String str, String str2, boolean z, int i) {
        Bitmap bitmapM10997a;
        String strM11082t = C3171am.m11082t();
        if (this.f3674ct == null && (!strM11082t.equalsIgnoreCase(str2) || !z)) {
            if (!z) {
                this.f3674ct = BitmapFactory.decodeResource(getResources(), R.drawable.download_ic_noti);
                m4852av();
            } else if (!"NO_SEARCH".equalsIgnoreCase(str2)) {
                if (!m4940o(str2)) {
                    this.f3673cs = str2;
                    m4943p(str2);
                } else {
                    File file = new File(this.f3675cu, str2 + ".png");
                    if (file.exists()) {
                        try {
                            if (file.length() > 0 && (bitmapM10997a = C3162ad.m10997a(GlobalApplication.m11493l(), Uri.fromFile(file))) != null) {
                                this.f3674ct = bitmapM10997a;
                                m4852av();
                            }
                        } catch (Exception e) {
                            C3250y.m11443a(e, f3484a);
                        }
                    }
                }
            }
        }
        this.f3571au.setVisibility(0);
        this.f3576az.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("\n", " ");
        }
        if (z) {
            this.f3576az.setText(getResources().getString(R.string.privacy_dialog_not_match_location_user, str));
        } else {
            this.f3576az.setText(getResources().getString(R.string.privacy_dialog_not_identified_user, str));
        }
        if (!strM11082t.equalsIgnoreCase(str2) || !z) {
            this.f3572av.setVisibility(0);
            this.f3573aw.setOnClickListener(new ViewOnClickListenerC1000bw(this));
            this.f3575ay.setOnClickListener(new ViewOnClickListenerC1002by(this));
            this.f3574ax.setOnClickListener(new ViewOnClickListenerC1003bz(this));
            return;
        }
        this.f3572av.setVisibility(8);
    }

    /* renamed from: x */
    public void m5023x() {
        String strM1329a;
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
        abstractC3271aM11494a.mo11495a(R.string.spammer_report_title);
        C0264a c0264a = this.f3537aM.get(this.f3536aL.get(0));
        if (c0264a == null) {
            strM1329a = "";
        } else {
            strM1329a = c0264a.m1329a();
        }
        abstractC3271aM11494a.mo11509b(getResources().getString(R.string.spammer_report_guide, strM1329a));
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1006cb(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1005ca(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* renamed from: av */
    private void m4852av() {
        this.f3527aC.m5284a(this.f3674ct);
        if (this.f3526aB != null) {
            this.f3526aB.invalidateViews();
        }
    }

    /* renamed from: o */
    private boolean m4940o(String str) {
        return new File(this.f3675cu).exists() && new File(this.f3675cu, new StringBuilder().append(str).append(".png").toString()).exists();
    }

    /* renamed from: p */
    private void m4943p(String str) {
        new C1330h(this.f3522X).m5756h(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aw */
    public void m4855aw() {
        this.f3576az.setVisibility(8);
        this.f3572av.setVisibility(8);
        if (this.f3674ct != null) {
            if (!this.f3674ct.isRecycled()) {
                this.f3674ct.recycle();
            }
            this.f3674ct = null;
            m4852av();
        }
    }

    /* renamed from: ax */
    private boolean m4857ax() {
        if (this.f3525aA.getVisibility() == 0) {
            if (C3250y.f11735c) {
                C3250y.m11453c("isLoadingFromServer - true", getClass().getSimpleName());
            }
            return true;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("isLoadingFromServer - false", getClass().getSimpleName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ay */
    public void m4859ay() {
        long j;
        long j2;
        this.f3593bP = false;
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            if (C3250y.f11735c) {
                C3250y.m11453c("loadMessageFromServer - network is not available", getClass().getSimpleName());
                return;
            }
            return;
        }
        if (!C3171am.m11080r()) {
            if (C3250y.f11735c) {
                C3250y.m11453c("loadMessageFromServer - did not mapping samsung account", getClass().getSimpleName());
                return;
            }
            return;
        }
        if (!m4857ax()) {
            if (this.f3548aX.equals("-1")) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("loadMessageFromServer - don't need to load more message", getClass().getSimpleName());
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(this.f3710y)) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("loadMessageFromServer - session is null, don't need to load more message", getClass().getSimpleName());
                    return;
                }
                return;
            }
            if (!this.f3609bf) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("inbox is invalid - don't need to load more message", getClass().getSimpleName());
                    return;
                }
                return;
            }
            if (this.f3548aX.equals("0")) {
                try {
                    Cursor cursor = (Cursor) this.f3526aB.getAdapter().getItem(1);
                    if (cursor != null) {
                        long j3 = cursor.getLong(cursor.getColumnIndex("message_time"));
                        if (C3250y.f11735c) {
                            C3250y.m11453c("loadMessageFromServer()-lastMsg : " + cursor.getString(cursor.getColumnIndex("message_content")), getClass().getSimpleName());
                        }
                        j2 = j3;
                    } else {
                        j2 = 0;
                    }
                    j = j2;
                } catch (Exception e) {
                    e.printStackTrace();
                    j = 0;
                }
            } else {
                j = 0;
            }
            C1335m.m5785a(this.f3522X, this.f3703r, this.f3710y, this.f3709x, this.f3548aX, Long.valueOf(j), 30);
            this.f3525aA.setVisibility(0);
            if (C3250y.f11735c) {
                C3250y.m11453c("loadMessageFromServer - inboxNo:" + this.f3703r + ",sessionId:" + this.f3710y + ",tid:" + this.f3548aX + ",count:30", getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: az */
    public void m4860az() {
        new Handler().postDelayed(new RunnableC1007cc(this), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aA */
    public void m4779aA() {
        if (this.f3525aA != null) {
            this.f3525aA.setVisibility(8);
        }
    }

    /* renamed from: aB */
    private float m4780aB() {
        String strM10979a = C3159aa.m10962a().m10979a("Default Font Size", "");
        if (C3250y.f11735c) {
            C3250y.m11453c("sizeString : " + strM10979a, f3484a);
        }
        EnumC2504dk enumC2504dkM9259a = EnumC2504dk.Normal;
        try {
            enumC2504dkM9259a = EnumC2504dk.m9259a(strM10979a);
        } catch (Exception e) {
            e.printStackTrace();
            C3250y.m11442a("cannot get font size : " + strM10979a, f3484a);
        }
        String strName = enumC2504dkM9259a.name();
        if (C3250y.f11735c) {
            C3250y.m11453c("fontSizeName : " + strName, f3484a);
        }
        if (strName.equals(EnumC2504dk.System.name())) {
            return C3171am.m11053b(this.f3672cr);
        }
        if (strName.equals(EnumC2504dk.Tiny.name())) {
            return getResources().getDimension(R.dimen.font_size_tiny);
        }
        if (strName.equals(EnumC2504dk.Small.name())) {
            return getResources().getDimension(R.dimen.font_size_small);
        }
        if (strName.equals(EnumC2504dk.Normal.name())) {
            return getResources().getDimension(R.dimen.font_size_normal);
        }
        if (strName.equals(EnumC2504dk.Large.name())) {
            return getResources().getDimension(R.dimen.font_size_large);
        }
        if (strName.equals(EnumC2504dk.Huge.name())) {
            return getResources().getDimension(R.dimen.font_size_huge);
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("unknown fontSizeName : " + strName, f3484a);
        }
        return getResources().getDimension(R.dimen.font_size_normal);
    }

    /* renamed from: aC */
    private Typeface m4782aC() {
        int iIntValue;
        try {
            iIntValue = C3159aa.m10962a().m10978a("Default Font Typeface", (Integer) (-1)).intValue();
        } catch (Exception e) {
            iIntValue = -1;
        }
        if (iIntValue == -1) {
            return Typeface.SANS_SERIF;
        }
        String path = C2570bj.m9521c(CommonApplication.m11493l(), Integer.toString(iIntValue)).getPath();
        C3250y.m11450b(path, getClass().getSimpleName());
        try {
            return Typeface.createFromFile(path);
        } catch (Exception e2) {
            C3250y.m11450b("Cannot make font from file", getClass().getSimpleName());
            return Typeface.SANS_SERIF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aD */
    public void m4784aD() {
        String str;
        if (this.f3631cA) {
            m4789aF();
            m4791aG();
            this.f3631cA = false;
            return;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("[onResume() ChatRoom] InboxNO : " + this.f3703r, getClass().getSimpleName());
        }
        C3250y.m11450b("onResume - QUERY_INBOX", getClass().getSimpleName());
        if (TextUtils.isEmpty(this.f3703r)) {
            String str2 = "";
            if (this.f3709x == EnumC1450r.ONETOONE) {
                str2 = "buddy_no=?";
                str = this.f3536aL.get(0);
            } else if (this.f3709x != EnumC1450r.GROUPCHAT) {
                str = "";
            } else {
                str2 = "inbox_no = ( SELECT inbox_no FROM inbox_buddy_relation WHERE buddy_no = ? )";
                str = this.f3599bV;
            }
            if (TextUtils.isEmpty(str)) {
                this.f3551aa.startQuery(1, null, C1449q.m6328a(), null, "inbox_no=?", new String[]{""}, null);
                return;
            } else {
                this.f3551aa.startQuery(1, null, C1449q.m6337g(), null, str2, new String[]{str, this.f3710y, String.valueOf(this.f3709x.m6342a())}, null);
                return;
            }
        }
        this.f3551aa.startQuery(1, null, C1449q.m6328a(), null, "inbox_no=?", new String[]{this.f3703r}, null);
    }

    /* renamed from: c */
    private boolean m4883c(boolean z) {
        boolean z2 = false;
        if (this.f3705t && ((this.f3709x == EnumC1450r.ONETOONE || this.f3709x == EnumC1450r.GROUPCHAT) && this.f3554ad != null && m4787aE() && !C3171am.m11059c(getActivity()))) {
            synchronized (this.f3524Z) {
                if (this.f3536aL.size() == 0 || this.f3536aL.size() > this.f3554ad.m53b(getActivity(), z) - 1) {
                    C3250y.m11450b("[ChatONV] participants limit exceed - " + (z ? SlookAirButtonRecentMediaAdapter.VIDEO_TYPE : "voice"), getClass().getSimpleName());
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("buddy_no").append(" IN (");
                    Iterator<String> it = this.f3536aL.iterator();
                    while (it.hasNext()) {
                        sb.append('\'').append(it.next()).append("',");
                    }
                    sb.deleteCharAt(sb.lastIndexOf(",")).append(")");
                    Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(C1441i.f5369a, new String[]{"buddy_extra_info", "buddy_name"}, sb.toString(), null, null);
                    if (cursorQuery != null && cursorQuery.getCount() == this.f3536aL.size()) {
                        cursorQuery.moveToFirst();
                        boolean z3 = false;
                        while (true) {
                            if (!TextUtils.isEmpty(cursorQuery.getString(0))) {
                                if (!cursorQuery.getString(0).contains("voip=1")) {
                                    C3250y.m11450b("[ChatONV] voip not supported : " + cursorQuery.getString(1), f3484a);
                                    break;
                                }
                                z3 = true;
                            }
                            if (!cursorQuery.moveToNext()) {
                                z2 = z3;
                                break;
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
        return z2;
    }

    /* renamed from: aE */
    private boolean m4787aE() {
        boolean zM37b = false;
        if (this.f3554ad != null) {
            try {
                C0045a c0045a = this.f3554ad;
                zM37b = C0045a.m37b(getActivity());
                C3250y.m11450b("[ChatONV] isInstalled : " + zM37b, f3484a);
                if (zM37b) {
                    zM37b = this.f3554ad.m55d(getActivity());
                    C3250y.m11450b("[ChatONV] isReadyToCall : " + zM37b, f3484a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            C3250y.m11450b("[ChatONV] isChatONVAvailable : " + zM37b, f3484a);
        }
        return zM37b;
    }

    /* renamed from: d */
    public boolean m4998d(String str) {
        if (TextUtils.isEmpty(this.f3704s)) {
            return false;
        }
        return ((this.f3704s.length() >= 19 && this.f3704s.startsWith("10")) || this.f3704s.startsWith("0")) && !TextUtils.isEmpty(str);
    }

    /* renamed from: a */
    public String m4962a(String str, String str2) {
        if (!m4998d(str2)) {
            if (!m4946q(str)) {
                return "+" + this.f3704s;
            }
            return str;
        }
        List<String> listM4948r = m4948r(str2);
        if (listM4948r.size() > 0) {
            return "+" + listM4948r.get(0);
        }
        return null;
    }

    /* renamed from: q */
    private boolean m4946q(String str) {
        if (TextUtils.isEmpty(this.f3704s) || this.f3704s.length() < 19 || !this.f3704s.startsWith("10") || TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public List<String> m4948r(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("chaton id : " + strNextToken, f3484a);
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("pin number : " + strNextToken, f3484a);
                } else {
                    C3250y.m11450b("msisdn: " + strNextToken, f3484a);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m4871b(Bundle bundle) {
        this.f3679cy = bundle.getInt("inbox_last_chat_type");
        this.f3710y = bundle.getString("inbox_session_id");
        this.f3538aN = Long.valueOf(bundle.getLong("inbox_last_msg_no"));
        this.f3542aR = bundle.getString("inbox_title");
        this.f3711z = bundle.getInt("_id");
        this.f3539aO = bundle.getString("inbox_server_ip");
        this.f3607bd = bundle.getInt("inbox_server_port");
        if (TextUtils.isEmpty(this.f3539aO)) {
            this.f3539aO = C3194bi.m11149a().m11154c().m11155a();
            this.f3607bd = C3194bi.m11149a().m11154c().m11158b();
        }
        this.f3543aS = bundle.getString("inbox_title_fixed");
        this.f3544aT = bundle.getString("inbox_last_msg_sender");
        this.f3680cz = bundle.getString("inbox_last_temp_msg");
        this.f3545aU = bundle.getString("buddy_name");
        this.f3549aY = bundle.getInt("inbox_trunk_unread_count");
        this.f3704s = bundle.getString("buddy_no");
        this.f3611bh = bundle.getLong("inbox_last_timestamp");
        this.f3612bi = "Y".equals(bundle.getString("inbox_enable_noti"));
        this.f3550aZ = bundle.getInt("inbox_unread_count");
        this.f3610bg = "Y".equals(bundle.getString("inbox_is_entered"));
        this.f3547aW = bundle.getLong("lasst_session_merge_time");
        this.f3548aX = bundle.getString("inbox_last_tid");
        this.f3647cS = "Y".equals(bundle.getString("inbox_enable_translate"));
        this.f3648cT = "Y".equals(bundle.getString("translate_outgoing_message"));
        this.f3643cM = bundle.getString("inbox_translate_my_language");
        if (TextUtils.isEmpty(this.f3643cM)) {
            this.f3643cM = C0952c.m5143c().m5156d().m5136d(this.f3643cM);
            this.f3645cO = false;
        } else {
            this.f3645cO = true;
        }
        this.f3644cN = bundle.getString("inbox_translate_buddy_language");
        this.f3644cN = C0952c.m5143c().m5156d().m5137e(this.f3644cN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4742a(Cursor cursor) {
        if (cursor.moveToFirst()) {
            this.f3679cy = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
            this.f3703r = cursor.getString(cursor.getColumnIndex("inbox_no"));
            if (this.f3709x == null && C3250y.f11735c) {
                C3250y.m11453c("ChatType is null", f3484a);
            }
            this.f3709x = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
            if (C3250y.f11735c) {
                C3250y.m11453c("retrieveInboxInfoFromCursor - inboxNo : " + this.f3703r + ", chatType : " + this.f3709x, f3484a);
            }
            if (this.f3679cy == 12) {
                if (!m4690I()) {
                    cursor.close();
                    return;
                }
                this.f3705t = false;
            } else {
                this.f3710y = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                this.f3538aN = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                this.f3542aR = cursor.getString(cursor.getColumnIndex("inbox_title"));
                this.f3711z = cursor.getInt(cursor.getColumnIndex("_id"));
                this.f3539aO = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
                this.f3607bd = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
                if (TextUtils.isEmpty(this.f3539aO)) {
                    this.f3539aO = C3194bi.m11149a().m11154c().m11155a();
                    this.f3607bd = C3194bi.m11149a().m11154c().m11158b();
                }
                this.f3543aS = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
                this.f3544aT = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
                this.f3680cz = cursor.getString(cursor.getColumnIndex("inbox_last_temp_msg"));
                this.f3545aU = cursor.getString(cursor.getColumnIndex("buddy_name"));
                this.f3549aY = cursor.getInt(cursor.getColumnIndex("inbox_trunk_unread_count"));
                this.f3704s = cursor.getString(cursor.getColumnIndex("buddy_no"));
                this.f3609bf = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                this.f3611bh = cursor.getLong(cursor.getColumnIndex("inbox_last_timestamp"));
                this.f3612bi = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                this.f3550aZ = cursor.getInt(cursor.getColumnIndex("inbox_unread_count"));
                this.f3610bg = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_is_entered")));
                this.f3547aW = cursor.getLong(cursor.getColumnIndex("lasst_session_merge_time"));
                this.f3548aX = cursor.getString(cursor.getColumnIndex("inbox_last_tid"));
                this.f3647cS = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_translate")));
                this.f3648cT = "Y".equals(cursor.getString(cursor.getColumnIndex("translate_outgoing_message")));
                this.f3643cM = cursor.getString(cursor.getColumnIndex("inbox_translate_my_language"));
                this.f3644cN = cursor.getString(cursor.getColumnIndex("inbox_translate_buddy_language"));
            }
            this.f3643cM = C0952c.m5143c().m5156d().m5136d(this.f3643cM);
            this.f3644cN = C0952c.m5143c().m5156d().m5137e(this.f3644cN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aF */
    public void m4789aF() {
        if (!TextUtils.isEmpty(this.f3703r)) {
            if (this.f3679cy == 12) {
                this.f3530aF.m5880a(this.f3703r, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                this.f3530aF.m5893c(Long.MAX_VALUE);
                if (!this.f3530aF.m5907p()) {
                    this.f3530aF.m5902k();
                }
                synchronized (this.f3524Z) {
                    this.f3551aa.startQuery(2, null, C1441i.m6313f(), null, "buddy_no IN" + C1075eq.m5321a(this.f3536aL), null, null);
                }
            } else {
                String[] strArrSplit = this.f3680cz.split(Config.KEYVALUE_SPLIT);
                if (strArrSplit.length > 2 && !TextUtils.isEmpty(strArrSplit[2])) {
                    m4769a(strArrSplit[1], strArrSplit[2], strArrSplit.length > 3 ? strArrSplit[3] : null);
                    m4686G();
                }
                if (TextUtils.isEmpty(this.f3707v)) {
                    this.f3707v = strArrSplit.length > 0 ? C1075eq.m5323b(strArrSplit[0]) : "";
                }
                String str = this.f3704s;
                if (this.f3709x == EnumC1450r.GROUPCHAT) {
                    str = this.f3703r;
                }
                if (m4690I()) {
                    if (this.f3707v != null) {
                        CharSequence charSequenceM7508a = C1835j.m7508a(this.f3672cr, this.f3707v, (int) (this.f3613bj.getLineHeight() * 1.2f));
                        if (!this.f3684dc && TextUtils.isEmpty(this.f3613bj.getText().toString()) && !TextUtils.isEmpty(charSequenceM7508a)) {
                            this.f3613bj.setText(charSequenceM7508a);
                            this.f3613bj.setSelection(charSequenceM7508a.length());
                        }
                    }
                    m4949s(this.f3703r);
                    if (this.f3710y != null && !"null".equals(this.f3710y) && !"".equals(this.f3710y)) {
                        if (this.f3530aF.m5880a(this.f3703r, this.f3539aO, this.f3607bd)) {
                            this.f3530aF.m5893c(Long.MAX_VALUE);
                            this.f3530aF.m5871a(this.f3709x, this.f3710y);
                            if (this.f3609bf) {
                                this.f3530aF.m5875a(this.f3709x, str, this.f3538aN, this.f3710y, this.f3703r, this.f3611bh);
                            }
                        }
                        if (this.f3709x == EnumC1450r.BROADCAST2) {
                            C1335m.m5781a((Handler) null);
                        }
                    } else {
                        this.f3530aF.m5880a(this.f3703r, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                        this.f3530aF.m5893c(Long.MAX_VALUE);
                        if (this.f3709x == EnumC1450r.BROADCAST) {
                            C1335m.m5781a((Handler) null);
                        } else if (this.f3709x == EnumC1450r.ONETOONE) {
                            if (this.f3609bf) {
                                this.f3530aF.m5871a(this.f3709x, this.f3710y);
                                this.f3530aF.m5875a(EnumC1450r.BROADCAST, str, this.f3538aN, this.f3710y, this.f3703r, this.f3611bh);
                            }
                        } else if (this.f3609bf) {
                            if (this.f3539aO == null) {
                                mo4978a(C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b(), str, this.f3710y, this.f3709x);
                            } else {
                                mo4978a(this.f3539aO, this.f3607bd, str, this.f3710y, this.f3709x);
                            }
                        }
                    }
                    if (!this.f3609bf) {
                        this.f3569as.setVisibility(8);
                        m4855aw();
                    }
                    C3250y.m11453c("initInboxInfoAndQueryParticipant_QUERY_PARTICIPANTS_AFTER_INSERTED", f3484a);
                    this.f3551aa.startQuery(5, null, C1457y.m6367a(this.f3703r), null, null, null, null);
                    m5006g();
                } else {
                    return;
                }
            }
            ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m4791aG() {
        m4687H();
        this.f3527aC.m5287a(this.f3609bf);
        C3250y.m11450b("QUERY_INBOX - QUERY_MESSAGE", getClass().getSimpleName());
        if (this.f3610bg && this.f3550aZ > 20) {
            this.f3551aa.startQuery(15, null, C1454v.m6344a(this.f3550aZ), null, "message_inbox_no=?", new String[]{this.f3703r}, null);
        } else {
            this.f3551aa.startQuery(0, null, C1454v.m6344a(this.f3597bT), null, "message_inbox_no=?", new String[]{this.f3703r}, null);
        }
        if (!this.f3610bg && this.f3705t) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_is_entered", "Y");
            this.f3551aa.startUpdate(-1, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f3703r + "'", null);
        }
        if (!TextUtils.isEmpty(this.f3667cm)) {
            this.f3530aF.m5839a(this.f3709x, this.f3710y, (String[]) this.f3536aL.toArray(new String[this.f3536aL.size()]), Long.valueOf(this.f3667cm).longValue(), this.f3668cn, this.f3669co);
            this.f3667cm = null;
        }
        if (this.f3609bf && !TextUtils.isEmpty(this.f3704s) && this.f3709x == EnumC1450r.ONETOONE) {
            this.f3551aa.startQuery(17, null, C1441i.f5369a, new String[]{"buddy_show_phone_number", "buddy_extra_info", "buddy_msisdns"}, "buddy_no = ?", new String[]{this.f3704s}, null);
        } else {
            m4855aw();
        }
        if (this.f3705t && this.f3609bf && this.f3709x != EnumC1450r.BROADCAST) {
            C1335m.m5790d(this.f3522X, this.f3710y, this.f3703r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4870b(Cursor cursor) {
        Message messageM6267c = C1414e.m6265a().m6267c();
        messageM6267c.obj = cursor;
        C1414e.m6265a().m6266b().sendMessage(messageM6267c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aH */
    public boolean m4793aH() {
        return this.f3526aB != null && this.f3526aB.getCount() > 1;
    }

    /* renamed from: a */
    private View m4730a(LayoutInflater layoutInflater, boolean z, C0887a c0887a) {
        C0952c c0952cM5143c = C0952c.m5143c();
        View viewInflate = layoutInflater.inflate(R.layout.language_translate, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.only_below_ics_translate_switch_layout);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.linearlayout_translate_incoming_msg);
        viewFindViewById.setVisibility(8);
        if (!C0963n.m5180a() && c0887a != null) {
            c0887a.m5082a((CheckBox) viewInflate.findViewById(R.id.only_below_ics_translation_on_off_checkbox));
            viewFindViewById.setVisibility(0);
        }
        if (this.f3646cR) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox_translate_incoming_msg);
        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.spinner2);
        C1028cx c1028cx = new C1028cx(this, viewGroup, (ViewGroup) viewInflate.findViewById(R.id.linearlayout_myLanguage), (ViewGroup) viewInflate.findViewById(R.id.linearlayout_buddyLanguage));
        if (c0887a != null) {
            c0887a.m5085a(this.f3647cS);
        }
        if (this.f3646cR) {
            checkBox.setChecked(this.f3648cT);
        } else {
            checkBox.setChecked(true);
            checkBox.setEnabled(false);
        }
        this.f3650cV = (ImageView) viewInflate.findViewById(R.id.me_image);
        this.f3649cU = (ImageView) viewInflate.findViewById(R.id.buddy_image);
        C3205bt.m11182a(this.f3672cr).m11231c(this.f3650cV, C3159aa.m10962a().m10979a("chaton_id", ""));
        if (!TextUtils.isEmpty(this.f3703r)) {
            if (this.f3709x == EnumC1450r.ONETOONE) {
                if (this.f3609bf) {
                    C3205bt.m11182a(this.f3672cr).m11214a(this.f3649cU, this.f3704s, false);
                } else {
                    C3205bt.m11182a(this.f3672cr).m11225b(this.f3649cU, EnumC3208bw.BUDDY);
                }
            }
            if (this.f3709x == EnumC1450r.GROUPCHAT) {
                Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(C1449q.f5381a, null, "inbox_no=?", new String[]{this.f3703r}, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("profile_url"));
                    if (!TextUtils.isEmpty(this.f3599bV) && string == null) {
                        File file = new File(this.f3510L, C3205bt.m11198e(C1362f.m6073e(GlobalApplication.m6447a().getContentResolver(), this.f3599bV)));
                        if (file.exists()) {
                            m4975a(file);
                        }
                    }
                    if ("NA".equals(string)) {
                        File file2 = new File(this.f3510L, this.f3703r + "_chat_profile.png_");
                        if (file2.exists()) {
                            this.f3649cU.setImageBitmap(C3162ad.m11000a(this.f3672cr, file2.getAbsolutePath()));
                        }
                    } else if (string == null) {
                        C3205bt.m11182a(this.f3672cr).m11225b(this.f3649cU, EnumC3208bw.GROUP);
                    } else if (m5003e(string)) {
                        this.f3654cZ = new CallableC1073eo(null, string, this.f3703r);
                        this.f3654cZ.m5311a(60, 60, GlobalApplication.m11493l().getFilesDir().getAbsolutePath(), this.f3703r + "_chat_profile.png_." + this.f3652cX, this.f3651cW);
                        this.f3600bW.m11730a(this.f3649cU, this.f3654cZ);
                    } else {
                        File file3 = new File(this.f3510L, this.f3653cY);
                        if (file3 != null && file3.exists()) {
                            m4975a(file3);
                        }
                    }
                } else {
                    C3205bt.m11182a(this.f3672cr).m11225b(this.f3649cU, EnumC3208bw.GROUP);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            if (EnumC1450r.m6340a(this.f3709x)) {
                File file4 = new File(this.f3510L, this.f3703r + "_chat_profile.png_");
                if (file4.exists()) {
                    m4975a(file4);
                } else {
                    C3205bt.m11182a(this.f3672cr).m11225b(this.f3649cU, EnumC3208bw.BROADCAST);
                }
            }
        } else {
            C3205bt.m11182a(this.f3672cr).m11225b(this.f3649cU, EnumC3208bw.BUDDY);
        }
        C0951b c0951b = new C0951b(this.f3672cr, android.R.layout.simple_spinner_item, android.R.id.text1, new ArrayList());
        C0951b c0951b2 = new C0951b(this.f3672cr, android.R.layout.simple_spinner_item, android.R.id.text1, new ArrayList());
        Iterator<String> it = c0952cM5143c.m5156d().f3922y.iterator();
        while (it.hasNext()) {
            String next = it.next();
            c0951b.add(next);
            c0951b2.add(next);
        }
        c0951b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c0951b2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) c0951b);
        spinner2.setAdapter((SpinnerAdapter) c0951b2);
        f3485cP = this.f3643cM;
        f3486cQ = this.f3644cN;
        int iM4725a = m4725a(c0952cM5143c, f3485cP, spinner);
        int iM4725a2 = m4725a(c0952cM5143c, f3486cQ, spinner2);
        spinner.setSelection(iM4725a);
        spinner2.setSelection(iM4725a2);
        f3485cP = c0952cM5143c.m5154b((String) ((ArrayAdapter) spinner.getAdapter()).getItem(iM4725a));
        f3486cQ = c0952cM5143c.m5154b((String) ((ArrayAdapter) spinner.getAdapter()).getItem(iM4725a2));
        if (!z && c0887a != null) {
            m4764a(c1028cx, c0887a.m5086a());
            c0887a.m5083a(new C1011cg(this, c1028cx));
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4764a(C1028cx c1028cx, boolean z) {
        TextView textView;
        TextView textView2;
        if (this.f3646cR) {
            m4746a(c1028cx.f4113a, z);
        } else {
            m4746a(c1028cx.f4113a, false);
        }
        m4746a(c1028cx.f4114b, z);
        Spinner spinner = (Spinner) c1028cx.f4114b.findViewById(R.id.spinner1);
        if (spinner != null && (textView2 = (TextView) spinner.findViewById(R.id.textTranslateLang)) != null) {
            if (z) {
                textView2.setTextColor(getResources().getColor(R.color.translation_popup_text_normal));
            } else {
                textView2.setTextColor(getResources().getColor(R.color.translation_popup_text_disable));
            }
        }
        m4746a(c1028cx.f4115c, z);
        Spinner spinner2 = (Spinner) c1028cx.f4115c.findViewById(R.id.spinner2);
        if (spinner2 != null && (textView = (TextView) spinner2.findViewById(R.id.textTranslateLang)) != null) {
            if (z) {
                textView.setTextColor(getResources().getColor(R.color.translation_popup_text_normal));
            } else {
                textView.setTextColor(getResources().getColor(R.color.translation_popup_text_disable));
            }
        }
    }

    /* renamed from: a */
    private void m4746a(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            viewGroup.setEnabled(z);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setEnabled(z);
            }
        }
    }

    /* renamed from: a */
    private int m4725a(C0952c c0952c, String str, Spinner spinner) {
        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        for (int i = 0; i < arrayAdapter.getCount(); i++) {
            if (str.equals(c0952c.m5154b((String) arrayAdapter.getItem(i)))) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void m4975a(File file) {
        this.f3649cU.setImageBitmap(C3162ad.m11000a(this.f3672cr, file.getAbsolutePath()));
    }

    /* renamed from: e */
    public boolean m5003e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f3652cX = str.split("filename=")[r2.length - 1];
            File[] fileArrListFiles = this.f3510L.listFiles(new C1012ch(this));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return true;
            }
            this.f3653cY = fileArrListFiles[0].getName();
            this.f3651cW = this.f3653cY.split("_chat_profile.png_")[r2.length - 1];
            return !this.f3652cX.equals(this.f3651cW);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4899f(C1070el c1070el) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3672cr);
        abstractC3271aM11494a.mo11502a(true);
        LayoutInflater layoutInflater = (LayoutInflater) this.f3672cr.getSystemService("layout_inflater");
        abstractC3271aM11494a.mo11495a(R.string.translate);
        View viewM4730a = m4730a(layoutInflater, true, (C0887a) null);
        abstractC3271aM11494a.mo11502a(true);
        abstractC3271aM11494a.mo11508b(viewM4730a);
        viewM4730a.findViewById(R.id.linearlayout_translate_incoming_msg).setVisibility(8);
        viewM4730a.findViewById(R.id.layout_auto_translate).setVisibility(8);
        Spinner spinner = (Spinner) viewM4730a.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) viewM4730a.findViewById(R.id.spinner2);
        C0952c c0952cM5143c = C0952c.m5143c();
        spinner.setOnItemSelectedListener(new C1013ci(this, c0952cM5143c, spinner, spinner2));
        spinner2.setOnItemSelectedListener(new C1016cl(this, c0952cM5143c, spinner2));
        abstractC3271aM11494a.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1017cm(this, c0952cM5143c, c1070el));
        abstractC3271aM11494a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1018cn(this));
        abstractC3271aM11494a.mo11512b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4762a(C0952c c0952c, C1070el c1070el, String str, String str2) {
        this.f3682da = new ProgressDialog(getActivity());
        this.f3682da.setMessage(getResources().getString(R.string.dialog_connecting_server));
        this.f3682da.show();
        new AsyncTaskC1030cz(this, c0952c, str, str2).execute(c1070el);
    }

    /* renamed from: aI */
    private void m4795aI() {
        Editable text = this.f3613bj.getText();
        if (text != null) {
            String string = text.toString();
            if (this.f3609bf && string.replaceAll(" ", "").replaceAll("\n", "").length() > 0) {
                this.f3582bE.setEnabled(true);
                this.f3583bF.setEnabled(true);
                if (this.f3647cS) {
                    if (this.f3648cT) {
                        this.f3583bF.setVisibility(8);
                        this.f3582bE.setVisibility(0);
                    } else {
                        this.f3583bF.setVisibility(0);
                        this.f3582bE.setVisibility(8);
                    }
                } else {
                    this.f3582bE.setVisibility(0);
                    this.f3583bF.setVisibility(8);
                }
                this.f3603bZ.setVisibility(8);
                return;
            }
            if (string.replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
                this.f3583bF.setEnabled(false);
                this.f3583bF.setVisibility(8);
                if (this.f3553ac) {
                    this.f3582bE.setEnabled(true);
                    this.f3582bE.setVisibility(0);
                    this.f3583bF.setVisibility(8);
                    this.f3603bZ.setVisibility(8);
                    return;
                }
                this.f3582bE.setEnabled(false);
                if (this.f3621br) {
                    this.f3582bE.setVisibility(8);
                    this.f3583bF.setVisibility(8);
                    this.f3603bZ.setVisibility(0);
                }
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: e */
    public void mo5001e(boolean z, Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("message_content"));
        SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10151a = C2930k.m10151a(string);
        if (specialBuddyShareContentsEntryM10151a == null) {
            C3250y.m11450b("onLiveShareClickListener(), parsing error : " + string, f3484a);
            return;
        }
        C3250y.m11450b("onLiveShareClickListener(), request entry : " + specialBuddyShareContentsEntryM10151a, f3484a);
        Intent intent = new Intent(this.f3672cr, (Class<?>) ChatActivity.class);
        intent.putExtra("specialbuddy", true);
        intent.putExtra("receivers", new String[]{String.valueOf(specialBuddyShareContentsEntryM10151a.f5658id)});
        intent.putExtra("key_intent_ctid", specialBuddyShareContentsEntryM10151a.hash);
        intent.putExtra("key_web_url", specialBuddyShareContentsEntryM10151a.url);
        intent.putExtra("key_buddy_name", specialBuddyShareContentsEntryM10151a.name);
        startActivity(intent);
    }

    @Override // com.sec.chaton.chat.InterfaceC1093fh
    /* renamed from: f */
    public void mo5005f(boolean z, Cursor cursor) {
        Intent intent;
        if (this.f3672cr != null) {
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10159c = C2930k.m10159c(string);
            if (specialBuddyRecommendBuddyEntryM10159c == null) {
                C3250y.m11450b("onLiveRecommendClickListener(), parsing error : " + string, f3484a);
                return;
            }
            boolean zM5995b = C1357af.m5995b(this.f3672cr.getContentResolver(), specialBuddyRecommendBuddyEntryM10159c.f5657id);
            C3250y.m11450b("onLIveRecommendClickListener(), request entry : " + specialBuddyRecommendBuddyEntryM10159c, f3484a);
            C3250y.m11450b("onLIveRecommendClickListener(), isInServiceLiveBuddies: " + zM5995b, f3484a);
            if (!zM5995b) {
                C3641ai.m13210a(this.f3672cr, R.string.live_unsupported_contents_message, 1).show();
                return;
            }
            if ("0999".startsWith(specialBuddyRecommendBuddyEntryM10159c.f5657id)) {
                C3250y.m11450b("onLiveRecommendClickListener(), id error : not a live buddy ", f3484a);
                return;
            }
            if (GlobalApplication.m6456e()) {
                intent = new Intent(this.f3672cr, (Class<?>) SpecialBuddyActivity.class);
            } else {
                intent = new Intent(this.f3672cr, (Class<?>) SpecialBuddyDialog.class);
            }
            intent.putExtra("specialuserid", specialBuddyRecommendBuddyEntryM10159c.f5657id);
            if (!TextUtils.isEmpty(specialBuddyRecommendBuddyEntryM10159c.name)) {
                intent.putExtra("speicalusername", specialBuddyRecommendBuddyEntryM10159c.name);
            }
            startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m4747a(TextView textView, int i) {
        if (GlobalApplication.m6456e()) {
            if (i <= 0) {
                textView.setVisibility(4);
            } else {
                textView.setVisibility(0);
                textView.setText("" + i);
            }
        }
    }

    /* renamed from: a */
    private void m4744a(Menu menu) {
        if (menu != null) {
            MenuItem menuItemFindItem = menu.findItem(R.id.chat_menu_trunk);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(false);
            }
            menu.setGroupVisible(R.id.chat_menu_group_delete, false);
        }
    }

    /* renamed from: a */
    public void m4971a(C1070el c1070el) {
        InterfaceC0908l interfaceC0908l = (AbstractViewOnClickListenerC0920x) c1070el.f4270ay;
        if (interfaceC0908l instanceof InterfaceC0907k) {
            InterfaceC0907k interfaceC0907k = (InterfaceC0907k) interfaceC0908l;
            if (interfaceC0907k.mo5098i()) {
                if (Build.VERSION.SDK_INT < 11) {
                    ((ClipboardManager) this.f3672cr.getSystemService("clipboard")).setText(interfaceC0907k.mo5099j());
                } else {
                    ((android.content.ClipboardManager) this.f3672cr.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, interfaceC0907k.mo5099j()));
                }
                C3641ai.m13210a(this.f3672cr, R.string.copied_to_clipboard, 0).show();
            }
        }
    }

    /* renamed from: b */
    public void m4985b(C1070el c1070el) {
        InterfaceC0908l interfaceC0908l = (AbstractViewOnClickListenerC0920x) c1070el.f4270ay;
        if (interfaceC0908l instanceof InterfaceC0909m) {
            InterfaceC0909m interfaceC0909m = (InterfaceC0909m) interfaceC0908l;
            if (interfaceC0909m.mo5096g()) {
                mo5019t();
                C0910n c0910nMo5097h = interfaceC0909m.mo5097h();
                startActivity(m4863b(c0910nMo5097h.f3842c, c0910nMo5097h.f3840a, c0910nMo5097h.f3841b));
            }
        }
    }

    /* renamed from: c */
    public void m4990c(C1070el c1070el) {
        InterfaceC0908l interfaceC0908l = (AbstractViewOnClickListenerC0920x) c1070el.f4270ay;
        if (interfaceC0908l instanceof InterfaceC0912p) {
            InterfaceC0912p interfaceC0912p = (InterfaceC0912p) interfaceC0908l;
            if (interfaceC0912p.mo5094e()) {
                mo5019t();
                C0910n c0910nMo5095f = interfaceC0912p.mo5095f();
                Intent intentM11321a = C3220ch.m11321a(this.f3672cr, getString(R.string.trunk_opt_header_share), c0910nMo5095f.f3840a, c0910nMo5095f.f3841b, (String) null, c0910nMo5095f.f3842c);
                if (intentM11321a != null) {
                    if ((C3159aa.m10962a().m10977a("TrunkShareCheckPopup", (Boolean) false).booleanValue() || !(c0910nMo5095f.f3842c == EnumC1455w.IMAGE || c0910nMo5095f.f3842c == EnumC1455w.AMS)) ? false : C3025f.m10540b(c0910nMo5095f.f3840a)) {
                        C3220ch.m11325a(this.f3672cr, new DialogInterfaceOnClickListenerC1019co(this, intentM11321a)).mo11512b();
                    } else {
                        startActivity(intentM11321a);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void m4995d(C1070el c1070el) {
        InterfaceC0908l interfaceC0908l = (AbstractViewOnClickListenerC0920x) c1070el.f4270ay;
        if (interfaceC0908l instanceof InterfaceC0911o) {
            InterfaceC0911o interfaceC0911o = (InterfaceC0911o) interfaceC0908l;
            if (interfaceC0911o.mo5102k() && C3223ck.m11327a()) {
                mo5019t();
                C0910n c0910nMo5101e_ = interfaceC0911o.mo5101e_();
                new AsyncTaskC1767a(c0910nMo5101e_.f3840a, c0910nMo5101e_.f3841b, true).execute(new String[0]);
            }
        }
    }

    /* renamed from: e */
    public void m5000e(C1070el c1070el) {
        AbstractViewOnClickListenerC0920x abstractViewOnClickListenerC0920x = (AbstractViewOnClickListenerC0920x) c1070el.f4270ay;
        if ((abstractViewOnClickListenerC0920x instanceof InterfaceC0908l) && abstractViewOnClickListenerC0920x.mo5112b()) {
            long jLongValue = Long.valueOf(c1070el.f4273c).longValue();
            abstractViewOnClickListenerC0920x.mo5106c_();
            C1756p.m7231a(this.f3703r, jLongValue);
            if (c1070el.f4244aF) {
                this.f3551aa.startDelete(3, null, C1454v.m6354d(), "_id='" + jLongValue + "'", null);
            } else {
                this.f3551aa.startDelete(3, null, C1454v.m6354d(), "message_sever_id='" + jLongValue + "'", null);
            }
        }
    }

    /* renamed from: a */
    private SlookAirButton m4733a(View view, int i) {
        C3238m c3238m = new C3238m(EnumC1455w.ANICON);
        c3238m.setEmptyText(getString(R.string.airbutton_no_emoticon));
        SlookAirButton slookAirButton = new SlookAirButton(view, c3238m, i);
        slookAirButton.setItemSelectListener(new C1021cq(this));
        slookAirButton.setGravity(1);
        slookAirButton.setDirection(-1);
        slookAirButton.setScrollEnabled(true);
        slookAirButton.setPosition(20, 0);
        return slookAirButton;
    }

    /* renamed from: b */
    private SlookAirButton m4866b(View view, int i) {
        C3238m c3238m = new C3238m(EnumC1455w.IMAGE);
        c3238m.setEmptyText(getString(R.string.airbutton_no_image));
        SlookAirButton slookAirButton = new SlookAirButton(view, c3238m, i);
        slookAirButton.setItemSelectListener(new C1022cr(this));
        slookAirButton.setGravity(1);
        slookAirButton.setDirection(-1);
        slookAirButton.setScrollEnabled(true);
        slookAirButton.setPosition(120, 0);
        return slookAirButton;
    }

    /* renamed from: y */
    public ArrayList<String> m5024y() {
        return this.f3536aL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aJ */
    public void m4797aJ() {
        if (this.f3672cr != null) {
            ((ActionBarFragmentActivity) this.f3672cr).m11543k().mo11595e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aK */
    public void m4798aK() {
        if (!GlobalApplication.m6456e() && this.f3672cr != null) {
            ((ActionBarFragmentActivity) this.f3672cr).m11543k().mo11597f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m4949s(String str) {
        int iM1328i;
        if (GlobalApplication.m6456e() && (getActivity() instanceof TabActivity) && (iM1328i = ((TabActivity) getActivity()).m1328i()) == R.id.fragment_msg_box) {
            MsgboxFragment msgboxFragment = (MsgboxFragment) getActivity().getSupportFragmentManager().findFragmentById(iM1328i);
            if (msgboxFragment instanceof MsgboxFragment) {
                msgboxFragment.m7070a(this.f3703r);
            }
        }
    }

    /* renamed from: d */
    private void m4888d(boolean z) {
        if (!GlobalApplication.m6456e() && this.f3640cJ != null && this.f3637cG != null) {
            int visibility = this.f3640cJ.getVisibility();
            int i = z ? 8 : 0;
            this.f3637cG.setVisibility(i);
            if (visibility == 8 && i == 8) {
                this.f3638cH.setVisibility(8);
            } else {
                this.f3638cH.setVisibility(0);
            }
        }
    }
}
