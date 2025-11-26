package com.sec.chaton.smsplugin.p112ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SqliteWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemProperties;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.ClipboardManager;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.BootstrapActivity;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1011aj;
import com.sec.chaton.C1015an;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.chat.C1735gh;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.hugefiletransfer.HugeFileUploadService;
import com.sec.chaton.multimedia.audio.DialogC2747w;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2098bd;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p061g.C2346e;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.privateplugin.data.SetSpamReq;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.privateplugin.p088a.C3033b;
import com.sec.chaton.settings.ActivityChat;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.smsplugin.C3778a;
import com.sec.chaton.smsplugin.C3781b;
import com.sec.chaton.smsplugin.C3805c;
import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.TempFileProvider;
import com.sec.chaton.smsplugin.multimedia.emoticon.InterfaceC3922b;
import com.sec.chaton.smsplugin.multimedia.emoticon.SmsEmoticonSelectionView;
import com.sec.chaton.smsplugin.multimedia.geotag.MmsGeotagActivity;
import com.sec.chaton.smsplugin.multimedia.vcalendar.MmsVCalendarListActivity2;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p102b.C3799r;
import com.sec.chaton.smsplugin.p102b.InterfaceC3788g;
import com.sec.chaton.smsplugin.p102b.InterfaceC3804w;
import com.sec.chaton.smsplugin.p103c.C3809d;
import com.sec.chaton.smsplugin.p103c.DialogC3806a;
import com.sec.chaton.smsplugin.p103c.InterfaceC3810e;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3876aa;
import com.sec.chaton.smsplugin.p111h.C3880c;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3895r;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.p112ui.widget.ChoicePanel;
import com.sec.chaton.smsplugin.p112ui.widget.ClearableRecipientEditor;
import com.sec.chaton.smsplugin.p112ui.widget.MmsMyEditText;
import com.sec.chaton.smsplugin.provider.C3942a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.log.collector.C5043h;
import com.sec.common.widget.HoneycombLinearLayout;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5103z;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class PluginComposeMessageActivity extends BaseActivity implements View.OnClickListener, TextView.OnEditorActionListener, InterfaceC3788g, InterfaceC3804w, InterfaceC3810e, InterfaceC3922b, InterfaceC4174db {

    /* renamed from: bG */
    private static volatile C3789h f14919bG;

    /* renamed from: bK */
    private static final String f14920bK;

    /* renamed from: bL */
    private static final String f14921bL;

    /* renamed from: bM */
    private static final String f14922bM;

    /* renamed from: n */
    public static String f14923n = "cmas_title";

    /* renamed from: o */
    public static String f14924o = "cmas_type";

    /* renamed from: s */
    public static String f14925s = "extra fileuri";

    /* renamed from: t */
    public static String f14926t = "extra vcalendar";

    /* renamed from: u */
    public static String f14927u = "extra vard name";

    /* renamed from: w */
    static HashMap<String, C4258ge> f14928w = new HashMap<>();

    /* renamed from: F */
    private ContentResolver f14934F;

    /* renamed from: G */
    private C3790i f14935G;

    /* renamed from: H */
    private boolean f14936H;

    /* renamed from: J */
    private ChoicePanel f14938J;

    /* renamed from: K */
    private View f14939K;

    /* renamed from: L */
    private View f14940L;

    /* renamed from: M */
    private ImageButton f14941M;

    /* renamed from: N */
    private ImageButton f14942N;

    /* renamed from: O */
    private MmsMyEditText f14943O;

    /* renamed from: P */
    private LinearLayout f14944P;

    /* renamed from: Q */
    private LinearLayout f14945Q;

    /* renamed from: R */
    private LinearLayout f14946R;

    /* renamed from: S */
    private TextView f14947S;

    /* renamed from: T */
    private TextView f14948T;

    /* renamed from: U */
    private ImageButton f14949U;

    /* renamed from: V */
    private EditText f14950V;

    /* renamed from: W */
    private AttachmentEditor f14951W;

    /* renamed from: X */
    private View f14952X;

    /* renamed from: Y */
    private MessageListView f14953Y;

    /* renamed from: Z */
    private RecipientsEditor f14954Z;

    /* renamed from: aA */
    private long f14955aA;

    /* renamed from: aG */
    private ViewGroup f14961aG;

    /* renamed from: aH */
    private FrameLayout f14962aH;

    /* renamed from: aJ */
    private View f14964aJ;

    /* renamed from: aK */
    private View f14965aK;

    /* renamed from: aM */
    private FrameLayout f14967aM;

    /* renamed from: aN */
    private ImageView f14968aN;

    /* renamed from: aO */
    private Bitmap f14969aO;

    /* renamed from: aP */
    private String f14970aP;

    /* renamed from: aQ */
    private String f14971aQ;

    /* renamed from: aR */
    private String f14972aR;

    /* renamed from: aS */
    private String f14973aS;

    /* renamed from: aT */
    private String f14974aT;

    /* renamed from: aV */
    private LinearLayout f14976aV;

    /* renamed from: aW */
    private CheckBox f14977aW;

    /* renamed from: aX */
    private Menu f14978aX;

    /* renamed from: aY */
    private View f14979aY;

    /* renamed from: aZ */
    private LinearLayout f14980aZ;

    /* renamed from: aa */
    private ImageView f14981aa;

    /* renamed from: ab */
    private LinearLayout f14982ab;

    /* renamed from: ac */
    private LinearLayout f14983ac;

    /* renamed from: ad */
    private HoneycombLinearLayout f14984ad;

    /* renamed from: ae */
    private ImageButton f14985ae;

    /* renamed from: af */
    private ImageButton f14986af;

    /* renamed from: ag */
    private HoneycombLinearLayout f14987ag;

    /* renamed from: ah */
    private ImageButton f14988ah;

    /* renamed from: ai */
    private LinearLayout f14989ai;

    /* renamed from: aj */
    private TextView f14990aj;

    /* renamed from: ak */
    private LinearLayout f14991ak;

    /* renamed from: al */
    private boolean f14992al;

    /* renamed from: am */
    private boolean f14993am;

    /* renamed from: ao */
    private boolean f14995ao;

    /* renamed from: ap */
    private C3799r f14996ap;

    /* renamed from: ar */
    private AlertDialog f14998ar;

    /* renamed from: as */
    private ProgressDialog f14999as;

    /* renamed from: au */
    private boolean f15001au;

    /* renamed from: av */
    private int f15002av;

    /* renamed from: aw */
    private boolean f15003aw;

    /* renamed from: ax */
    private Intent f15004ax;

    /* renamed from: ay */
    private String f15005ay;

    /* renamed from: bH */
    private C3942a f15013bH;

    /* renamed from: ba */
    private TextView f15024ba;

    /* renamed from: bb */
    private ViewGroup f15025bb;

    /* renamed from: bc */
    private TextView f15026bc;

    /* renamed from: bd */
    private ImageView f15027bd;

    /* renamed from: be */
    private C2098bd f15028be;

    /* renamed from: bg */
    private String f15030bg;

    /* renamed from: bn */
    private FrameLayout f15037bn;

    /* renamed from: bo */
    private DialogC2747w f15038bo;

    /* renamed from: bq */
    private boolean f15040bq;

    /* renamed from: br */
    private InputMethodManager f15041br;

    /* renamed from: bs */
    private SharedPreferences f15042bs;

    /* renamed from: bt */
    private SharedPreferencesOnSharedPreferenceChangeListenerC4261gh f15043bt;

    /* renamed from: bv */
    private String f15045bv;

    /* renamed from: bw */
    private C3789h f15046bw;

    /* renamed from: p */
    public C4110as f15050p;

    /* renamed from: q */
    DialogC3806a f15051q;

    /* renamed from: r */
    ArrayList<C3809d> f15052r;

    /* renamed from: D */
    private String f14932D = "";

    /* renamed from: E */
    private int f14933E = 0;

    /* renamed from: I */
    private boolean f14937I = false;

    /* renamed from: an */
    private boolean f14994an = false;

    /* renamed from: aq */
    private String f14997aq = "";

    /* renamed from: at */
    private InterfaceC4936e f15000at = null;

    /* renamed from: az */
    private int f15006az = -1;

    /* renamed from: aB */
    private final boolean f14956aB = false;

    /* renamed from: aC */
    private final String f14957aC = null;

    /* renamed from: aD */
    private final String f14958aD = null;

    /* renamed from: aE */
    private final boolean f14959aE = false;

    /* renamed from: aF */
    private CharSequence f14960aF = null;

    /* renamed from: aI */
    private SmsEmoticonSelectionView f14963aI = null;

    /* renamed from: aL */
    private String[] f14966aL = null;

    /* renamed from: v */
    String f15053v = null;

    /* renamed from: aU */
    private boolean f14975aU = false;

    /* renamed from: bf */
    private ProgressDialog f15029bf = null;

    /* renamed from: bh */
    private boolean f15031bh = false;

    /* renamed from: bi */
    private Vibrator f15032bi = null;

    /* renamed from: bj */
    private boolean f15033bj = false;

    /* renamed from: bk */
    private boolean f15034bk = false;

    /* renamed from: bl */
    private boolean f15035bl = false;

    /* renamed from: bm */
    private boolean f15036bm = false;

    /* renamed from: bp */
    private boolean f15039bp = false;

    /* renamed from: bu */
    private boolean f15044bu = false;

    /* renamed from: bx */
    private final Handler f15047bx = new HandlerC4175dc(this);

    /* renamed from: by */
    private final Handler f15048by = new HandlerC4186dn(this);

    /* renamed from: bz */
    private final View.OnKeyListener f15049bz = new ViewOnKeyListenerC4201eb(this);

    /* renamed from: bA */
    private final Runnable f15007bA = new RunnableC4212em(this);

    /* renamed from: x */
    boolean f15054x = false;

    /* renamed from: bB */
    private final TextWatcher f15008bB = new C4235fi(this);

    /* renamed from: bC */
    private final View.OnCreateContextMenuListener f15009bC = new ViewOnCreateContextMenuListenerC4246ft(this);

    /* renamed from: bD */
    private final View.OnCreateContextMenuListener f15010bD = new ViewOnCreateContextMenuListenerC4248fv(this);

    /* renamed from: bE */
    private final IntentFilter f15011bE = new IntentFilter("com.sec.chaton.smsplugin.PROGRESS_STATUS");

    /* renamed from: bF */
    private final BroadcastReceiver f15012bF = new C4176dd(this);

    /* renamed from: y */
    Runnable f15055y = new RunnableC4190dr(this);

    /* renamed from: bI */
    private final Handler f15014bI = new HandlerC4195dw(this);

    /* renamed from: bJ */
    private final InterfaceC4158cm f15015bJ = new C4200ea(this);

    /* renamed from: z */
    public View.OnClickListener f15056z = new ViewOnClickListenerC4208ei(this);

    /* renamed from: A */
    public View.OnClickListener f14929A = new ViewOnClickListenerC4211el(this);

    /* renamed from: bN */
    private final TextWatcher f15016bN = new C4213en(this);

    /* renamed from: bO */
    private final TextWatcher f15017bO = new C4214eo(this);

    /* renamed from: bP */
    private final InterfaceC4115ax f15018bP = new C4221ev(this);

    /* renamed from: bQ */
    private final Handler f15019bQ = new HandlerC4222ew(this);

    /* renamed from: bR */
    private final View.OnClickListener f15020bR = new ViewOnClickListenerC4229fc(this);

    /* renamed from: bS */
    private final Handler f15021bS = new HandlerC4233fg(this);

    /* renamed from: B */
    public final Handler f14930B = new HandlerC4240fn(this);

    /* renamed from: C */
    Handler f14931C = new HandlerC4244fr(this);

    /* renamed from: bT */
    private long f15022bT = -1;

    /* renamed from: bU */
    private String f15023bU = "";

    static {
        f14928w.put("en-UK", new C4258ge(R.array.english_uk_array, R.array.english_uk_code_array));
        f14928w.put("zh-CN", new C4258ge(R.array.chinese_array, R.array.chinese_code_array));
        f14928w.put("ko-KR", new C4258ge(R.array.korean_array, R.array.korean_code_array));
        f14928w.put("en-US", new C4258ge(R.array.english_us_array, R.array.english_us_code_array));
        f14928w.put("fr-FR", new C4258ge(R.array.french_array, R.array.french_code_array));
        f14928w.put("de-DE", new C4258ge(R.array.german_array, R.array.german_code_array));
        f14928w.put("it-IT", new C4258ge(R.array.italian_array, R.array.italian_code_array));
        f14928w.put("ja-JP", new C4258ge(R.array.japanese_array, R.array.japanese_code_array));
        f14928w.put("es-ES", new C4258ge(R.array.spanish_array, R.array.spanish_code_array));
        f14928w.put("pt-PT", new C4258ge(R.array.portuguese_array, R.array.portuguese_code_array));
        f14920bK = MediaStore.Video.Media.getContentUri("external").toString();
        f14921bL = MediaStore.Images.Media.getContentUri("external").toString();
        f14922bM = MediaStore.Audio.Media.getContentUri("external").toString();
    }

    /* renamed from: c */
    public static void m16048c(String str) {
        try {
            Thread threadCurrentThread = Thread.currentThread();
            C3890m.m14996b("Mms/compose", "[" + threadCurrentThread.getId() + "] [" + threadCurrentThread.getStackTrace()[3].getMethodName() + "] " + str);
        } catch (NoSuchMethodError e) {
            C3890m.m14997c("Mms/compose", "NoSuchMethodError :e " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m16096p() {
        Uri uriM14450c = this.f14996ap.m14450c(false);
        if (uriM14450c != null) {
            Intent intent = new Intent(this, (Class<?>) SlideshowEditActivity.class);
            intent.setData(uriM14450c);
            startActivityForResult(intent, 106);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C4108aq m15929a(String str, long j, boolean z) {
        return this.f15050p.m16323a(str, j, z ? this.f15050p.getCursor() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public boolean m16099q() {
        Cursor cursor = this.f15050p.getCursor();
        if (!cursor.isClosed() && !cursor.isBeforeFirst() && !cursor.isAfterLast()) {
            return true;
        }
        C3890m.m14995a("Mms/compose", "Bad cursor.", new RuntimeException());
        return false;
    }

    /* renamed from: r */
    private void m16101r() {
        m15964a("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m15964a(java.lang.CharSequence r13) {
        /*
            r12 = this;
            r11 = 80
            r10 = 3
            r3 = 0
            r2 = 1
            com.sec.chaton.smsplugin.b.r r4 = r12.f14996ap
            int[] r1 = android.telephony.SmsMessage.calculateLength(r13, r3)
            r5 = r1[r3]
            r0 = r1[r2]
            r6 = 2
            r6 = r1[r6]
            r7 = r1[r10]
            boolean r1 = com.sec.chaton.smsplugin.C3847e.m14677ai()
            if (r1 != r2) goto L1e
            if (r10 != r7) goto L1e
            int r0 = r0 * 2
        L1e:
            com.sec.chaton.util.ab r1 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r8 = "pref_key_auto_transform_to_mms"
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)
            java.lang.Boolean r1 = r1.m18119a(r8, r9)
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L40
            java.lang.String r1 = "450"
            java.lang.String r8 = com.sec.chaton.util.C4822an.m18243k()
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L4f
        L40:
            boolean r1 = com.sec.chaton.smsplugin.C3847e.m14677ai()
            if (r1 != r2) goto La1
            com.sec.chaton.smsplugin.b.r r1 = r12.f14996ap
            if (r0 <= r11) goto La1
            com.sec.chaton.smsplugin.b.r r1 = r12.f14996ap
            r1.m14449b(r2, r2)
        L4f:
            if (r0 != 0) goto L57
            boolean r1 = r4.m14470t()
            if (r1 == 0) goto L5b
        L57:
            boolean r1 = r12.f14975aU
            if (r1 != r2) goto Lb0
        L5b:
            android.widget.LinearLayout r1 = r12.f14944P
            r3 = 8
            r1.setVisibility(r3)
        L62:
            boolean r1 = r4.m14470t()
            r12.m16074f(r1)
            boolean r1 = r4.m14470t()
            if (r1 != 0) goto La0
            boolean r1 = com.sec.chaton.smsplugin.C3847e.m14677ai()
            if (r1 != r2) goto Lb6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.sec.chaton.smsplugin.b.r r2 = r12.f14996ap
            int r0 = 80 - r0
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)
            com.sec.chaton.smsplugin.b.r r1 = r12.f14996ap
            java.lang.String r1 = java.lang.String.valueOf(r11)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.widget.TextView r1 = r12.f14947S
            r1.setText(r0)
        La0:
            return
        La1:
            com.sec.chaton.smsplugin.b.r r8 = r12.f14996ap
            int r1 = com.sec.chaton.smsplugin.C3847e.m14643a()
            if (r5 <= r1) goto Lae
            r1 = r2
        Laa:
            r8.m14449b(r1, r2)
            goto L4f
        Lae:
            r1 = r3
            goto Laa
        Lb0:
            android.widget.LinearLayout r1 = r12.f14944P
            r1.setVisibility(r3)
            goto L62
        Lb6:
            if (r10 != r7) goto Le3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r6 * 2
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)
            int r0 = r0 + r6
            int r0 = r0 * 2
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.widget.TextView r1 = r12.f14947S
            r1.setText(r0)
            goto La0
        Le3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)
            int r0 = r0 + r6
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.widget.TextView r1 = r12.f14947S
            r1.setText(r0)
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity.m15964a(java.lang.CharSequence):void");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i >= 0) {
            this.f15001au = true;
        }
        super.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m16102s() throws IOException {
        HandlerC4175dc handlerC4175dc = null;
        if (this.f14943O.length() == 0 || this.f14943O.getVisibility() == 8) {
            this.f14944P.setVisibility(8);
        }
        if (C4822an.m18243k() == null || C4822an.m18244l() == null) {
            AbstractC4932a.m18733a(this).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(getResources().getString(R.string.provision_no_signal)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC4223ex(this)).mo18751b(false).mo18745a().show();
            return;
        }
        if (C3847e.m14693ay()) {
            C4809aa.m18104a().m18124a("pref_key_1st_sms_message_sent_time", Long.valueOf(C4809aa.m18104a().m18118a("pref_key_1st_sms_message_sent_time", System.currentTimeMillis())));
        }
        if (!m15878E()) {
            if (C3847e.m14652aC() && C4822an.m18218a() && !TextUtils.isEmpty(this.f14996ap.m14472v())) {
                m15981aH();
                return;
            } else {
                m16090j(true);
                return;
            }
        }
        boolean zM14470t = this.f14996ap.m14470t();
        if (this.f14954Z.m16173c(zM14470t)) {
            if (this.f14954Z.m16171b(zM14470t)) {
                AbstractC4932a.m18733a(this).mo18753c(android.R.drawable.ic_dialog_alert).mo18740a(m15930a(R.string.has_invalid_recipient, this.f14954Z.m16174d(zM14470t))).mo18746b(R.string.invalid_recipient_message).mo18756d(R.string.try_to_send, new DialogInterfaceOnClickListenerC4263gj(this, handlerC4175dc)).mo18747b(R.string.no, new DialogInterfaceOnClickListenerC4250fx(this, handlerC4175dc)).mo18752b();
                return;
            } else {
                AbstractC4932a.m18733a(this).mo18753c(android.R.drawable.ic_dialog_alert).mo18734a(R.string.cannot_send_message).mo18746b(R.string.cannot_send_message_reason).mo18756d(R.string.yes, new DialogInterfaceOnClickListenerC4250fx(this, handlerC4175dc)).mo18752b();
                return;
            }
        }
        if (C3847e.m14652aC() && C4822an.m18218a() && !TextUtils.isEmpty(this.f14996ap.m14472v())) {
            m15981aH();
        } else {
            m16090j(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m16105u() {
        int iM14708n = C3847e.m14708n();
        if (iM14708n != Integer.MAX_VALUE) {
            int iM15983aa = m15983aa();
            boolean z = iM15983aa > iM14708n;
            if (iM15983aa != this.f15002av) {
                this.f15002av = iM15983aa;
                if (z) {
                    Toast.makeText(this, getString(R.string.too_many_recipients, new Object[]{Integer.valueOf(iM15983aa), Integer.valueOf(iM14708n)}), 1).show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15942a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        try {
            m15941a(contextMenu, view, ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        } catch (ClassCastException e) {
            C3890m.m14999e("Mms/compose", "bad menuInfo");
        }
    }

    /* renamed from: a */
    private Uri m15926a(ListView listView, int i) {
        int i2;
        CharSequence charSequence;
        int i3 = -1;
        MessageListItem messageListItem = (MessageListItem) listView.getChildAt(i);
        if (messageListItem == null) {
            return null;
        }
        TextView textView = (TextView) messageListItem.findViewById(R.id.text_view);
        if (textView != null) {
            CharSequence text = textView.getText();
            int selectionStart = textView.getSelectionStart();
            int selectionEnd = textView.getSelectionEnd();
            charSequence = text;
            i2 = selectionStart;
            i3 = selectionEnd;
        } else {
            i2 = -1;
            charSequence = null;
        }
        if (i2 != i3) {
            URLSpan[] uRLSpanArr = (URLSpan[]) ((Spanned) charSequence).getSpans(Math.min(i2, i3), Math.max(i2, i3), URLSpan.class);
            if (uRLSpanArr.length == 1) {
                return Uri.parse(uRLSpanArr[0].getURL());
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m15941a(ContextMenu contextMenu, View view, int i) {
        Uri uriM15926a = m15926a((ListView) view, i);
        if (uriM15926a != null) {
            Intent intent = new Intent((String) null, uriM15926a);
            intent.addCategory("android.intent.category.SELECTED_ALTERNATIVE");
            contextMenu.addIntentOptions(0, 0, 0, new ComponentName(this, (Class<?>) PluginComposeMessageActivity.class), null, intent, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15959a(C4108aq c4108aq) {
        if ("sms".equals(c4108aq.f15267b)) {
            m16031b(c4108aq);
        } else {
            m16047c(c4108aq);
        }
        if (c4108aq.m16317t() && this.f15050p.getCount() <= 1) {
            m16113y();
        }
    }

    /* renamed from: b */
    private void m16031b(C4108aq c4108aq) {
        synchronized (this.f14935G) {
            if (this.f14935G.m14365j() <= 1) {
                this.f14935G.m14361f();
            }
        }
        this.f14934F.delete(ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, c4108aq.f15268c), null, null);
        this.f14996ap.m14438a((CharSequence) c4108aq.f15277l);
    }

    /* renamed from: c */
    private void m16047c(C4108aq c4108aq) {
        C3799r c3799rM14392a = C3799r.m14392a(this, c4108aq.f15283r);
        if (c3799rM14392a != null) {
            this.f14996ap.m14465o();
            this.f14996ap = c3799rM14392a;
            this.f14996ap.m14436a(this.f14935G);
            invalidateOptionsMenu();
            m16084h(false);
            this.f14996ap.m14439a((CharSequence) c4108aq.f15286u, false);
            if (this.f14996ap.m14460j()) {
                m16058d(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m16066e(String str) {
        ((ClipboardManager) getSystemService("clipboard")).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16057d(C4108aq c4108aq) {
        Intent intentM15925a = m15925a((Context) this, 0L);
        intentM15925a.putExtra("forwarded_message", true);
        if (c4108aq.f15267b.equals("sms")) {
            intentM15925a.putExtra("sms_body", c4108aq.f15277l);
        } else {
            C5103z c5103z = new C5103z();
            c5103z.m19312a(c4108aq.f15287v.m14909b(this));
            try {
                intentM15925a.putExtra("msg_uri", C5097t.m19426a(this).m19447a(c5103z, Telephony.Mms.Draft.CONTENT_URI));
            } catch (C5111c e) {
                C3890m.m14999e("Mms/compose", "Failed to copy message: " + c4108aq.f15283r);
                Toast.makeText(this, R.string.cannot_save_message, 0).show();
                return;
            }
        }
        intentM15925a.setClassName(this, "com.sec.chaton.smsplugin.ui.ForwardMessageActivity");
        if (this.f14938J != null) {
            this.f14938J.m16535b();
        }
        startActivity(intentM15925a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15961a(C4108aq c4108aq, boolean z) {
        Uri uri;
        if ("sms".equals(c4108aq.f15267b)) {
            if (c4108aq.m16309l()) {
                uri = C4149cd.f15441b;
            } else {
                uri = Telephony.Sms.CONTENT_URI;
            }
        } else {
            uri = Telephony.Mms.CONTENT_URI;
        }
        Uri uriWithAppendedId = ContentUris.withAppendedId(uri, c4108aq.f15268c);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("locked", Integer.valueOf(z ? 1 : 0));
        new Thread(new RunnableC4249fw(this, uriWithAppendedId, contentValues), "lockMessage").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15969a(long j) {
        C5086i c5086iM14893b;
        try {
            c5086iM14893b = C3870p.m14893b(this, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j));
        } catch (C5111c e) {
            C3890m.m14999e("Mms/compose", "haveSomethingToCopyToSDCard can't load pdu body: " + j);
            c5086iM14893b = null;
        }
        if (c5086iM14893b == null) {
            return false;
        }
        int iM19333b = c5086iM14893b.m19333b();
        for (int i = 0; i < iM19333b; i++) {
            String str = new String(c5086iM14893b.m19328a(i).m19394g());
            m16048c("[CMA] haveSomethingToCopyToSDCard: part[" + i + "] contentType=" + str);
            if (C5077a.m19288b(str) || C5077a.m19291d(str) || C5077a.m19290c(str) || C5077a.m19293f(str) || C5077a.m19292e(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m16033b(long j) {
        return m16075f(m16051d(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m16049c(long j) {
        boolean zM15973a = false;
        C5086i c5086iM14893b = null;
        try {
            c5086iM14893b = C3870p.m14893b(this, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j));
        } catch (C5111c e) {
            C3890m.m14999e("Mms/compose", "copyToDrmProvider can't load pdu body: " + j);
        }
        if (c5086iM14893b != null) {
            int iM19333b = c5086iM14893b.m19333b();
            zM15973a = true;
            for (int i = 0; i < iM19333b; i++) {
                C5094q c5094qM19328a = c5086iM14893b.m19328a(i);
                if (C5077a.m19294g(new String(c5094qM19328a.m19394g()))) {
                    zM15973a &= m15973a(c5094qM19328a);
                }
            }
        }
        return zM15973a;
    }

    /* renamed from: d */
    private String m16051d(long j) {
        C5086i c5086iM14893b;
        try {
            c5086iM14893b = C3870p.m14893b(this, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j));
        } catch (C5111c e) {
            C3890m.m14999e("Mms/compose", "getDrmMimeType can't load pdu body: " + j);
            c5086iM14893b = null;
        }
        if (c5086iM14893b != null) {
            int iM19333b = c5086iM14893b.m19333b();
            for (int i = 0; i < iM19333b && !C5077a.m19294g(new String(c5086iM14893b.m19328a(i).m19394g())); i++) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public int m16060e(long j) {
        if (m16075f(m16051d(j))) {
            return R.string.save_ringtone;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m15921a(long j, boolean z) {
        if (m16075f(m16051d(j))) {
            return z ? R.string.saved_ringtone : R.string.saved_ringtone_fail;
        }
        return 0;
    }

    /* renamed from: f */
    private boolean m16075f(String str) {
        return str != null && str.startsWith("audio/");
    }

    /* renamed from: a */
    private boolean m15973a(C5094q c5094q) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = this.f14934F.openInputStream(c5094q.m19383b());
                if (!(inputStreamOpenInputStream instanceof FileInputStream)) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            C3890m.m14995a("Mms/compose", "IOException caught while closing stream", e);
                        }
                    }
                    return true;
                }
                byte[] bArrM19397i = c5094q.m19397i();
                if (bArrM19397i == null) {
                    bArrM19397i = c5094q.m19398j();
                }
                if (bArrM19397i == null) {
                    bArrM19397i = c5094q.m19390e();
                }
                String str = new String(bArrM19397i);
                int iIndexOf = str.indexOf(".");
                if (iIndexOf == -1) {
                    new String(c5094q.m19394g());
                } else {
                    str.substring(0, iIndexOf);
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e2) {
                        C3890m.m14995a("Mms/compose", "IOException caught while closing stream", e2);
                    }
                }
                return false;
            } catch (IOException e3) {
                C3890m.m14995a("Mms/compose", "IOException caught while opening or reading stream", e3);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        C3890m.m14995a("Mms/compose", "IOException caught while closing stream", e4);
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    C3890m.m14995a("Mms/compose", "IOException caught while closing stream", e5);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public C3789h m16107v() {
        if (m15878E()) {
            if (f14919bG == null) {
                synchronized (PluginComposeMessageActivity.class) {
                    if (f14919bG == null) {
                        f14919bG = new C3789h();
                    }
                }
            }
            return f14919bG;
        }
        return this.f14935G.m14362g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m16109w() {
        C3789h c3789hM14462l = this.f14996ap.m14462l();
        if (c3789hM14462l != null && this.f14954Z != null) {
            int size = c3789hM14462l.size();
            this.f15005ay = c3789hM14462l.m14308a();
            if (this.f14938J != null) {
                this.f14938J.m16535b();
                if (size == 0) {
                    this.f14938J.setVisibility(8);
                } else if (size > 0) {
                    this.f14938J.setVisibility(0);
                    Iterator<C3782a> it = c3789hM14462l.iterator();
                    while (it.hasNext()) {
                        String strM14262d = it.next().m14262d();
                        this.f14938J.m16533a(strM14262d, C3782a.m14207a(strM14262d));
                    }
                }
            }
            this.f14954Z.getText().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public boolean m16111x() {
        if (this.f14954Z == null || this.f14954Z.getText() == null) {
            return true;
        }
        String string = this.f14954Z.getText().toString();
        return TextUtils.isEmpty(string) || C4149cd.m16429c(string);
    }

    /* renamed from: f */
    public void m16125f() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(R.string.discard_message);
        builder.setMessage(R.string.enter_valid_recipient);
        builder.setPositiveButton(R.string.ok_button, new DialogInterfaceOnClickListenerC4177de(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m16032b(int i) {
        if (i <= 25) {
            return false;
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        abstractC4932aM18733a.mo18753c(android.R.drawable.ic_dialog_alert);
        abstractC4932aM18733a.mo18749b(getResources().getString(R.string.max_recipient_limit_exceed, 25));
        abstractC4932aM18733a.mo18756d(R.string.ok_button, new DialogInterfaceOnClickListenerC4178df(this));
        abstractC4932aM18733a.mo18734a(R.string.chat_alert).mo18752b();
        return true;
    }

    /* renamed from: y */
    private void m16113y() {
        if (!m15878E()) {
            C3789h c3789hM16107v = m16107v();
            ViewStub viewStub = (ViewStub) findViewById(R.id.recipients_editor_stub);
            if (viewStub != null) {
                View viewInflate = viewStub.inflate();
                this.f14938J = (ChoicePanel) viewInflate.findViewById(R.id.recipient_choice_panel);
                this.f14954Z = (RecipientsEditor) ((ClearableRecipientEditor) viewInflate.findViewById(R.id.recipients_editor)).findViewById(R.id.clearable_text1);
                this.f14981aa = (ImageView) viewInflate.findViewById(R.id.recipients_picker);
            } else {
                this.f14938J = (ChoicePanel) findViewById(R.id.recipient_choice_panel);
                this.f14954Z = (RecipientsEditor) ((ClearableRecipientEditor) findViewById(R.id.recipients_editor)).findViewById(R.id.clearable_text1);
                this.f14954Z.setVisibility(0);
                this.f14981aa = (ImageView) findViewById(R.id.recipients_picker);
            }
            this.f14938J.setButtonClickListener(this.f15020bR);
            this.f14981aa.setOnClickListener(this);
            this.f14954Z.setAdapter(new C4279gz(this));
            this.f14954Z.m16169a(c3789hM16107v);
            this.f14954Z.setOnCreateContextMenuListener(this.f15009bC);
            this.f14954Z.addTextChangedListener(this.f15008bB);
            this.f14954Z.setOnItemClickListener(new C4179dg(this));
            this.f14954Z.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4180dh(this));
            this.f14939K.setVisibility(0);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        HandlerC4175dc handlerC4175dc = null;
        C3896s.m15044b("CREATE COMPOSER", "Mms/compose");
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!m16121b(intent)) {
            m15970a(getResources().getConfiguration());
            setContentView(R.layout.compose_message_activity);
            setProgressBarVisibility(false);
            getWindow().setSoftInputMode(18);
            m16007am();
            m15911V();
            m16010an();
            m16132n();
            this.f14934F = getContentResolver();
            this.f15013bH = new C3942a(this.f14934F);
            this.f15028be = new C2098bd(this.f15021bS);
            m15893M();
            this.f14966aL = null;
            if (intent.hasExtra("disable")) {
                getWindow().addFlags(4194304);
                intent.removeExtra("disable");
            }
            if (intent.hasExtra(f14924o)) {
                this.f14933E = intent.getIntExtra(f14924o, 0);
                this.f14994an = true;
            }
            m16118a(bundle, 0L);
            this.f14960aF = this.f14996ap.m14444b();
            this.f15041br = (InputMethodManager) getSystemService("input_method");
            this.f15042bs = CommonApplication.m18732r().getSharedPreferences("ChatON", 0);
            this.f15043bt = new SharedPreferencesOnSharedPreferenceChangeListenerC4261gh(this, handlerC4175dc);
            this.f15042bs.registerOnSharedPreferenceChangeListener(this.f15043bt);
            this.f14931C.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m16115z() {
        if (!C4809aa.m18104a().m18119a("do_not_show_again_charge_dialog", (Boolean) false).booleanValue() && !this.f15044bu && !C3847e.m14649a(this.f14933E)) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
            View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.commenttextview);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_packet_chekcbox);
            textView.setText(R.string.charged_for_sms);
            checkBox.setChecked(false);
            checkBox.setText(R.string.large_file_do_not_show_again);
            linearLayout.setVisibility(0);
            checkBox.setVisibility(0);
            abstractC4932aM18733a.mo18734a(R.string.alert_inform).mo18748b(viewInflate).mo18742a(true).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4181di(this, checkBox));
            abstractC4932aM18733a.mo18745a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m15869A() {
        if (!C4809aa.m18104a().m18119a("do_not_show_again_charge_dialog_for_mms", (Boolean) false).booleanValue() && this.f14996ap.m14470t()) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
            View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.commenttextview);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_packet_chekcbox);
            textView.setText(R.string.freesms_mms_charge_popup_text);
            checkBox.setChecked(false);
            checkBox.setText(R.string.large_file_do_not_show_again);
            linearLayout.setVisibility(0);
            checkBox.setVisibility(0);
            abstractC4932aM18733a.mo18734a(R.string.alert_inform).mo18748b(viewInflate).mo18742a(true).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4182dj(this, checkBox));
            abstractC4932aM18733a.mo18745a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16058d(boolean z) {
        if (this.f14950V == null) {
            if (z) {
                this.f14950V = (EditText) findViewById(R.id.subject);
                this.f14950V.setFilters(new InputFilter[]{new InputFilter.LengthFilter(C3847e.m14635S())});
            } else {
                return;
            }
        }
        this.f14950V.setOnKeyListener(z ? this.f15049bz : null);
        if (z) {
            this.f14950V.addTextChangedListener(this.f15017bO);
        } else {
            this.f14950V.removeTextChangedListener(this.f15017bO);
        }
        this.f14950V.setText(this.f14996ap.m14459i());
        this.f14950V.setVisibility(z ? 0 : 8);
        m15872B();
    }

    /* renamed from: B */
    private void m15872B() {
        this.f14939K.setVisibility(m15880F() || m15878E() ? 0 : 8);
    }

    /* renamed from: a */
    public void m16118a(Bundle bundle, long j) {
        this.f14996ap = C3799r.m14391a(this);
        this.f14937I = false;
        m15940a(bundle);
        m16048c("savedInstanceState = " + bundle + " intent = " + getIntent() + " mConversation = " + this.f14935G);
        m15915X();
        if (this.f14937I) {
            m16016as();
        }
        boolean z = bundle == null && (m15899P() || m15898O());
        C3896s.m15044b("intentHandled = " + z, "Mms/compose");
        if (!z && !this.f15039bp) {
            try {
                m15917Y();
            } catch (C3778a e) {
                if (!(e instanceof C3805c) && (e instanceof C3781b)) {
                }
                C4149cd.m16410a((Context) this, getString(R.string.exceed_message_size_limitation), getString(R.string.msg_unable_to_attach_file_size_too_large));
                this.f14996ap.m14436a(this.f14935G);
                this.f14996ap.m14465o();
                this.f14996ap.m14434a();
                m16101r();
            }
            C3896s.m15044b("Load draft", "Mms/compose");
        }
        this.f14996ap.m14436a(this.f14935G);
        C3896s.m15044b("mConversation.getThreadId() = " + this.f14935G.m14359d() + "mConversation.getMessageCount() = " + this.f14935G.m14365j(), "Mms/compose");
        if (this.f14935G.m14359d() <= 0 || this.f14935G.m14365j() == 0 || this.f15039bp) {
            m15876D();
            m16113y();
            m16109w();
            C3896s.m15044b("Show panel", "Mms/compose");
            getWindow().setSoftInputMode(20);
        } else {
            m15876D();
            C3896s.m15044b("Hide panel", "Mms/compose");
        }
        invalidateOptionsMenu();
        m15988ac();
        m16084h(false);
        m15903R();
        m16067e(this.f14992al);
        m16048c("update title, mConversation=" + this.f14935G.toString());
        m16133o();
        if (!C3847e.m14654aE() && C4822an.m18223b()) {
            m16115z();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        C3790i c3790iM14319a;
        super.onNewIntent(intent);
        setIntent(intent);
        long jM14359d = 0;
        if (this.f14935G != null) {
            jM14359d = this.f14935G.m14359d();
        }
        long longExtra = intent.getLongExtra("thread_id", 0L);
        Uri data = intent.getData();
        if (longExtra > 0) {
            c3790iM14319a = C3790i.m14317a((Context) this, longExtra, false);
        } else {
            if (this.f14935G != null && this.f14935G.m14359d() == 0) {
                this.f14996ap.m14461k();
            }
            if (intent.hasExtra("receiver_array")) {
                this.f14966aL = intent.getStringArrayExtra("receiver_array");
            }
            if (this.f14966aL != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f14966aL) {
                    m16048c("###onNewIntent: receivers number=" + str);
                    arrayList.add(C3789h.m14307c(C3782a.m14228c(str)));
                }
                c3790iM14319a = C3790i.m14320a((Context) this, C3789h.m14301a((Iterable<String>) arrayList, false), false);
            } else {
                c3790iM14319a = C3790i.m14319a((Context) this, data, false);
            }
        }
        m16048c("onNewIntent: data=" + data + ", thread_id extra is " + longExtra + ", new conversation=" + c3790iM14319a + ", mConversation=" + this.f14935G);
        boolean z = this.f14935G != null && (c3790iM14319a.m14359d() == this.f14935G.m14359d() || this.f14935G.m14359d() == 0) && c3790iM14319a.equals(this.f14935G);
        c3790iM14319a.m14353a(true);
        if (z) {
            m16048c("onNewIntent: same conversation");
            if (this.f14935G.m14359d() == 0) {
                this.f14935G = c3790iM14319a;
                this.f14996ap.m14436a(this.f14935G);
                invalidateOptionsMenu();
            }
            this.f14935G.m14355b();
        } else {
            m16048c("onNewIntent: different conversation");
            this.f15036bm = true;
            m16088i(false);
            m16118a((Bundle) null, jM14359d);
        }
        m16126g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m15874C() {
        if (this.f14996ap.m14469s() != this.f14935G) {
            C3811d.m14484a("PluginComposeMessageActivity: mWorkingMessage.mConversation=" + this.f14996ap.m14469s() + ", mConversation=" + this.f14935G + ", MISMATCH!", this);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        C3890m.m14997c("Mms/compose", "onrestart called");
        if (this.f14996ap.m14467q()) {
            if (this.f14996ap.m14454d()) {
                m16048c("onRestart: mWorkingMessage.unDiscard()");
                this.f14996ap.m14466p();
                m15874C();
                return;
            }
            if (m15878E()) {
                m16048c("onRestart: goToPluginConversationList");
                C3890m.m14997c("Mms/compose", "onrestart discard finish");
                finish();
                return;
            }
            if (!this.f15039bp) {
                m16048c("onRestart: loadDraft");
                try {
                    m15917Y();
                    this.f14996ap.m14436a(this.f14935G);
                    this.f14951W.m15723a(this.f14996ap);
                    invalidateOptionsMenu();
                } catch (C3778a e) {
                    if (!(e instanceof C3805c) && (e instanceof C3781b)) {
                    }
                    C4149cd.m16410a((Context) this, getString(R.string.exceed_message_size_limitation), getString(R.string.msg_unable_to_attach_file_size_too_large));
                    this.f14996ap.m14436a(this.f14935G);
                    this.f14996ap.m14465o();
                    this.f14996ap.m14434a();
                    m16101r();
                }
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f15035bl = false;
        this.f14935G.m14353a(true);
        m15990ad();
        registerReceiver(this.f15012bF, this.f15011bE);
        if (!this.f15039bp) {
            m16126g();
        }
        m16048c("update title, mConversation=" + this.f14935G.toString());
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* renamed from: g */
    public void m16126g() {
        m15913W();
        m15901Q();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("recipients", m16107v().m14308a());
        this.f14996ap.m14435a(bundle);
        if (this.f14936H) {
            bundle.putBoolean("exit_on_sent", this.f14936H);
        }
        Cursor cursor = (Cursor) this.f15050p.getItem(this.f14953Y.getFirstVisiblePosition());
        if (cursor != null) {
            try {
                this.f15022bT = cursor.getLong(1);
                this.f15023bU = cursor.getString(0);
            } catch (Exception e) {
                C3890m.m14997c("Mms/compose", "CursorIndexOutOfBoundsException was happen");
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m16000ai();
        m16048c("update title, mConversation=" + this.f14935G.toString());
        C3789h c3789hM16107v = (this.f14938J == null || this.f14938J.getChildCount() <= 0) ? m16107v() : C3789h.m14301a((Iterable<String>) this.f14938J.m16536c(), true);
        if (!m15977aD()) {
            new C4264gk(this, this.f15048by, c3789hM16107v).start();
        } else {
            m15978aE();
        }
        long jM14359d = this.f14935G.m14359d();
        C1813b.m8906b().m8937c(Long.toString(jM14359d));
        this.f15013bH.m15234a(this.f15019bQ, 1804, (Object) null, jM14359d, c3789hM16107v);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m16002aj();
        if (this.f15050p != null && this.f14953Y.getLastVisiblePosition() >= this.f15050p.getCount() - 1) {
            this.f15006az = Integer.MAX_VALUE;
        } else {
            this.f15006az = this.f14953Y.getFirstVisiblePosition();
        }
        C3890m.m14994a("Mms/compose", "onPause: mSavedScrollPosition=" + this.f15006az);
        getWindow().clearFlags(4194304);
        m16004ak();
        C1813b.m8906b().m8939d(Long.toString(this.f14935G.m14359d()));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        CursorAdapter cursorAdapter;
        super.onStop();
        if (!this.f15001au) {
            this.f14966aL = null;
            if (this.f14935G != null) {
                this.f14935G.m14353a(false);
            }
            if (this.f15050p != null) {
                this.f15050p.changeCursor(null);
            }
            if (this.f14954Z != null && (cursorAdapter = (CursorAdapter) this.f14954Z.getAdapter()) != null) {
                cursorAdapter.changeCursor(null);
            }
            m16088i(true);
            m16048c("save draft");
            unregisterReceiver(this.f15012bF);
            if (this.f14935G != null) {
                long jM14359d = this.f14935G.m14359d();
                C3789h c3789hM14362g = this.f14935G.m14362g();
                if (jM14359d > 0) {
                    this.f15013bH.m15234a(this.f15019bQ, 0, (Object) null, jM14359d, c3789hM14362g);
                }
            }
            this.f15013bH.m15242a(this.f15019bQ, (Object) null, 1803);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C2349a.m10301a("sms_feature")) {
            if (this.f15029bf != null && this.f15029bf.isShowing()) {
                this.f15029bf.dismiss();
            }
            this.f15029bf = null;
            m16013ap();
            if (this.f15042bs != null) {
                this.f15042bs.unregisterOnSharedPreferenceChangeListener(this.f15043bt);
            }
            C0991aa.m6037a().m18962d(new C1015an(new String[0]));
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (m15970a(configuration)) {
            m16084h(m15880F());
        }
        m16067e(this.f14992al);
        if (!this.f14993am) {
            m15975aB();
        }
    }

    /* renamed from: a */
    private boolean m15970a(Configuration configuration) {
        this.f14992al = configuration.keyboardHidden == 1;
        boolean z = configuration.orientation == 2;
        if (this.f14993am == z) {
            return false;
        }
        this.f14993am = z;
        return true;
    }

    /* renamed from: e */
    private void m16067e(boolean z) {
        if (z) {
            if (this.f14954Z != null) {
                this.f14954Z.setFocusableInTouchMode(true);
            }
            if (this.f14950V != null) {
                this.f14950V.setFocusableInTouchMode(true);
            }
            this.f14943O.setFocusableInTouchMode(true);
            if (C3847e.m14654aE() && !this.f14996ap.m14470t()) {
                this.f14943O.setHint(getString(R.string.freesms_display_remain_count, new Object[]{Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue())}));
                return;
            } else {
                this.f14943O.setHint(R.string.type_to_compose_sms_message);
                return;
            }
        }
        if (this.f14954Z != null) {
            this.f14954Z.setFocusable(false);
        }
        if (this.f14950V != null) {
            this.f14950V.setFocusable(false);
        }
        this.f14943O.setFocusable(false);
        this.f14943O.setHint(R.string.open_keyboard_to_compose_message);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        m15992ae();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            m15992ae();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) throws IOException {
        switch (i) {
            case 4:
                if (this.f14975aU) {
                    m16130l();
                    return true;
                }
                if (m16006al()) {
                    m15995ag();
                    return true;
                }
                m15965a(new RunnableC4183dk(this));
                return true;
            case 23:
                if (m15920Z()) {
                    m16102s();
                    return true;
                }
                break;
            case 66:
                if (m15920Z() && C4809aa.m18104a().m18119a("Setting enter key", (Boolean) false).booleanValue()) {
                    m16102s();
                    return true;
                }
                break;
            case 67:
                if (this.f15050p != null && this.f14953Y.isFocused()) {
                    try {
                        Cursor cursor = (Cursor) this.f14953Y.getSelectedItem();
                        if (cursor != null) {
                            boolean z = cursor.getInt(20) != 0;
                            m15936a(new DialogInterfaceOnClickListenerC4251fy(this, cursor.getLong(1), cursor.getString(0), z), z);
                            return true;
                        }
                    } catch (ClassCastException e) {
                        C3890m.m14995a("Mms/compose", "Unexpected ClassCastException.", e);
                        return super.onKeyDown(i, keyEvent);
                    }
                }
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? super.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15965a(Runnable runnable) {
        HandlerC4175dc handlerC4175dc = null;
        C3890m.m14997c("Mms/compose", "exitPluginComposeMessageActivity");
        this.f15035bl = true;
        this.f15031bh = false;
        if (!this.f14996ap.m14454d()) {
            runnable.run();
            return;
        }
        if (this.f14938J != null) {
            if (this.f14938J.getChildCount() == 0) {
                C4149cd.m16402a(this, new DialogInterfaceOnClickListenerC4256gc(this, handlerC4175dc));
                return;
            } else if (this.f14938J.getChildCount() > 0 && !this.f14938J.m16534a(this.f14996ap.m14470t())) {
                C4149cd.m16402a(this, new DialogInterfaceOnClickListenerC4256gc(this, handlerC4175dc));
                return;
            }
        }
        runnable.run();
    }

    /* renamed from: D */
    private void m15876D() {
        if (this.f14954Z != null) {
            this.f14954Z.removeTextChangedListener(this.f15008bB);
            this.f14954Z.setVisibility(8);
            m15872B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public boolean m15878E() {
        return this.f14954Z != null && this.f14954Z.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public boolean m15880F() {
        return this.f14950V != null && this.f14950V.getVisibility() == 0;
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3804w
    /* renamed from: a */
    public void mo14473a() {
        runOnUiThread(new RunnableC4184dl(this));
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3804w
    /* renamed from: b_ */
    public void mo14477b_(boolean z) {
        runOnUiThread(new RunnableC4185dm(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m16074f(boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        this.f15033bj = this.f15034bk;
        this.f15034bk = z;
        if (z) {
            linearLayout = this.f14946R;
            linearLayout2 = this.f14945Q;
            if (!this.f15033bj && this.f15034bk && C4809aa.m18104a().m18119a("pref_key_vibrate_on_switching_to_mms", (Boolean) true).booleanValue()) {
                m16068f(100L);
            }
        } else {
            linearLayout = this.f14945Q;
            linearLayout2 = this.f14946R;
        }
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3804w
    /* renamed from: b */
    public void mo14476b() {
        runOnUiThread(this.f15055y);
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3804w
    /* renamed from: a */
    public void mo14475a(Uri uri, String str) {
        if (this.f15050p.getCount() == 0) {
            m16048c("onMessageSent");
            if (!this.f15039bp) {
                m15913W();
            }
        }
        String strM15012a = null;
        if (C4822an.m18203M()) {
            Context contextM18732r = CommonApplication.m18732r();
            strM15012a = C3892o.m15012a(contextM18732r, contextM18732r.getContentResolver(), this.f15046bw);
        }
        if (C3847e.m14652aC() && !TextUtils.isEmpty(str)) {
            m15938a(uri, str, strM15012a);
        }
        if (C4822an.m18203M()) {
            if (strM15012a != null) {
                this.f15039bp = true;
            } else {
                this.f15039bp = false;
            }
            if (this.f15039bp) {
                Intent intentM2921a = IntentControllerActivity.m2921a(CommonApplication.m18732r(), 1);
                intentM2921a.putExtra("callChatList", true);
                intentM2921a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                intentM2921a.putExtra("buddyNO", strM15012a);
                intentM2921a.putExtra("roomType", EnumC2301u.NORMAL.m10212a());
                startActivity(intentM2921a);
            }
        }
        runOnUiThread(new RunnableC4191ds(this));
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3804w
    /* renamed from: a */
    public void mo14474a(int i) {
        runOnUiThread(new RunnableC4192dt(this, i));
    }

    /* renamed from: G */
    private boolean m15882G() {
        C3789h c3789hM16107v = m16107v();
        return c3789hM16107v.size() == 1 && !c3789hM16107v.m14311b() && !c3789hM16107v.isEmpty() && m15971a(c3789hM16107v);
    }

    /* renamed from: H */
    private void m15883H() {
        if (m15882G()) {
            startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + C3789h.m14307c(m16107v().get(0).m14262d()))));
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        this.f14978aX = menu;
        if (!m15977aD()) {
            getMenuInflater().inflate(R.menu.composer_menu, menu);
            return true;
        }
        return true;
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        if (!m15977aD()) {
            Cursor cursor = this.f15050p.getCursor();
            if (!m15882G() || m16006al()) {
                menu.findItem(R.id.composer_menu_call_recipient).setVisible(false);
            }
            MenuItem menuItemFindItem = menu.findItem(R.id.composer_menu_send_invitation);
            if (C3847e.m14693ay() && m15983aa() == 1) {
                C3782a c3782aM14204a = null;
                if (m16107v().size() == 1) {
                    c3782aM14204a = m16107v().get(0);
                } else if (this.f14938J.m16531a() == 1) {
                    c3782aM14204a = C3782a.m14204a(this.f14938J.m16536c().get(0), false);
                }
                if (m16034b(c3782aM14204a)) {
                    menuItemFindItem.setVisible(false);
                } else {
                    menuItemFindItem.setVisible(true);
                }
            } else {
                menuItemFindItem.setVisible(false);
            }
            MenuItem menuItemFindItem2 = menu.findItem(R.id.composer_menu_alert);
            if (m15878E() || m16107v().size() > 1) {
                menu.removeItem(R.id.composer_menu_alert);
            } else if (C2198l.m9956i(getContentResolver(), String.valueOf(this.f14935G.m14359d()))) {
                menuItemFindItem2.setTitle(R.string.chaton_live_buddy_alert_off).setIcon(R.drawable.more_option_alert_off_white);
            } else {
                menuItemFindItem2.setTitle(R.string.chaton_live_buddy_alert_on).setIcon(R.drawable.more_option_alert_white);
            }
            MenuItem menuItemFindItem3 = menu.findItem(R.id.composer_menu_message_room_info);
            if (cursor == null || cursor.getCount() == 0) {
                menuItemFindItem3.setVisible(false);
            } else if (!C4822an.m18218a()) {
                menuItemFindItem3.setTitle(R.string.menu_message_room_info);
            }
            MenuItem menuItemFindItem4 = menu.findItem(R.id.chat_menu_setting);
            if (cursor == null || cursor.getCount() == 0 || !C4822an.m18218a()) {
                menuItemFindItem4.setVisible(false);
            }
            MenuItem menuItemFindItem5 = menu.findItem(R.id.composer_menu_delete_messages);
            if (cursor == null || cursor.getCount() == 0) {
                menuItemFindItem5.setVisible(false);
            } else if (!C4822an.m18218a()) {
                menuItemFindItem5.setTitle(R.string.menu_delete_messages);
            }
            MenuItem menuItemFindItem6 = menu.findItem(R.id.composer_menu_delete_thread);
            if (cursor == null || cursor.getCount() == 0) {
                menuItemFindItem6.setVisible(false);
            } else if (!C4822an.m18218a()) {
                menuItemFindItem6.setTitle(R.string.menu_close_message_room);
            }
            menu.findItem(R.id.composer_menu_debug_dumd).setVisible(false);
            menu.findItem(R.id.composer_menu_add_recipient).setVisible(false);
            if (this.f14975aU) {
                MenuItem menuItemFindItem7 = menu.findItem(R.id.composer_menu_delete_confirm);
                int iM16335c = this.f15050p.m16335c();
                if (iM16335c > 0) {
                    menuItemFindItem7.setEnabled(true);
                    if (iM16335c == this.f15050p.getCount()) {
                        this.f14977aW.setChecked(true);
                    } else {
                        this.f14977aW.setChecked(false);
                    }
                } else {
                    menuItemFindItem7.setEnabled(false);
                }
                menu.setGroupVisible(R.id.composer_menu_group, false);
            } else {
                menu.setGroupVisible(R.id.composer_menu_group_delete, false);
            }
        }
        return true;
    }

    /* renamed from: I */
    private void m15885I() {
        if (this.f15029bf != null && this.f15029bf.isShowing()) {
            this.f15029bf.dismiss();
        }
        this.f15029bf = new ProgressDialog(this);
        this.f15029bf.setMessage(CommonApplication.m18732r().getString(R.string.buddy_list_progress_dialog_message));
        this.f15029bf.setCancelable(false);
        this.f15029bf.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) throws Resources.NotFoundException, IOException {
        switch (menuItem.getItemId()) {
            case 2:
                m16080g(false);
                return true;
            case 3:
                this.f14996ap.m14465o();
                finish();
                return true;
            case 4:
                if (m15920Z()) {
                    m16102s();
                }
                return true;
            case 9:
                if (C4149cd.m16435f(this, this.f14935G.m14362g().get(0).m14262d())) {
                    Toast.makeText(this, R.string.noti_unregistered_as_spamnumber, 0).show();
                }
                return true;
            case 10:
                C4149cd.m16434e(this, this.f14935G.m14362g().get(0).m14262d());
                return true;
            case 12:
                C3789h c3789hM16107v = m16107v();
                if (c3789hM16107v.size() == 1 && c3789hM16107v.get(0).m14271m()) {
                    Intent intent = new Intent("android.intent.action.VIEW", c3789hM16107v.get(0).m14268j());
                    intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
                    startActivity(intent);
                }
                return true;
            case 19:
                onSearchRequested();
                return true;
            case 26:
                m15997ah();
                return true;
            case android.R.id.home:
                if (this.f14975aU) {
                    m16130l();
                } else {
                    m15965a(new RunnableC4193du(this));
                }
                return true;
            case R.id.chat_menu_setting /* 2131166635 */:
                m15888J();
                return true;
            case R.id.composer_menu_call_recipient /* 2131166687 */:
                m15883H();
                return true;
            case R.id.composer_menu_add_recipient /* 2131166688 */:
                m15889K();
                return true;
            case R.id.composer_menu_send_invitation /* 2131166689 */:
                m15906S();
                return true;
            case R.id.composer_menu_message_room_info /* 2131166690 */:
                m15891L();
                return true;
            case R.id.composer_menu_alert /* 2131166691 */:
                String strValueOf = String.valueOf(this.f14935G.m14359d());
                if (C2198l.m9956i(getContentResolver(), strValueOf)) {
                    C2198l.m9913a(CommonApplication.m18732r().getContentResolver(), strValueOf, false);
                } else {
                    C2198l.m9913a(CommonApplication.m18732r().getContentResolver(), strValueOf, true);
                }
                new C4264gk(this, this.f15048by, m15878E() ? this.f14954Z.m16168a(false) : m16107v()).start();
                return true;
            case R.id.composer_menu_delete_messages /* 2131166692 */:
                Message.obtain(this.f15047bx, 12).sendToTarget();
                if (m16006al()) {
                    m15995ag();
                }
                m16129k();
                return true;
            case R.id.composer_menu_delete_thread /* 2131166693 */:
                if (m16006al()) {
                    m15995ag();
                }
                ArrayList arrayList = new ArrayList(1);
                long jM14359d = this.f14935G.m14359d();
                arrayList.add(Long.valueOf(jM14359d));
                this.f15013bH.m15245c(this.f15019bQ, 1805, arrayList, jM14359d);
                return true;
            case R.id.composer_menu_debug_dumd /* 2131166694 */:
                this.f14996ap.m14468r();
                C3790i.m14347p();
                C3811d.m14483a(this);
                return true;
            case R.id.composer_menu_delete_cancel /* 2131166696 */:
                if (this.f14975aU) {
                    m16130l();
                }
                return true;
            case R.id.composer_menu_delete_confirm /* 2131166697 */:
                DialogInterfaceOnClickListenerC4252fz dialogInterfaceOnClickListenerC4252fz = new DialogInterfaceOnClickListenerC4252fz(this, true);
                if (this.f15050p.m16338d()) {
                    m15962a(dialogInterfaceOnClickListenerC4252fz, true);
                } else {
                    m15962a(dialogInterfaceOnClickListenerC4252fz, false);
                }
                return true;
            default:
                return true;
        }
    }

    /* renamed from: J */
    private void m15888J() {
        startActivityForResult(new Intent(this, (Class<?>) ActivityChat.class), 113);
    }

    /* renamed from: K */
    private void m15889K() {
        if (this.f14935G != null) {
            Intent intent = new Intent(this, (Class<?>) PluginComposeMessageActivity.class);
            intent.putExtra("add_recipient_message", true);
            C3789h c3789hM14362g = this.f14935G.m14362g();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= c3789hM14362g.size()) {
                    break;
                }
                sb.append(c3789hM14362g.get(i2).m14262d());
                if (i2 < c3789hM14362g.size() - 1) {
                    sb.append(Config.KEYVALUE_SPLIT);
                }
                i = i2 + 1;
            }
            intent.putExtra("recipients", sb.toString());
            if (this.f14996ap != null) {
                if (this.f14996ap.m14456f()) {
                    C5103z c5103z = new C5103z();
                    c5103z.m19312a(this.f14996ap.m14457g().m14909b(this));
                    try {
                        intent.putExtra("msg_uri", C5097t.m19426a(this).m19447a(c5103z, Telephony.Mms.Draft.CONTENT_URI));
                    } catch (C5111c e) {
                        C3890m.m14999e("Mms/compose", "Failed to save draft message: ");
                    }
                }
                String string = this.f14996ap.m14444b().toString();
                if (string != null && string.length() > 0) {
                    intent.putExtra("sms_body", string);
                }
            }
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m15891L() {
        Intent intent = new Intent(this, (Class<?>) MessagingInfoActivity.class);
        intent.putExtra(MessagingInfoActivity.f14857o, this.f15024ba.getText());
        intent.putExtra(MessagingInfoActivity.f14856n, String.valueOf(this.f14935G.m14359d()));
        intent.putExtra(MessagingInfoActivity.f14858p, m16107v().m14313c());
        intent.putExtra(MessagingInfoActivity.f14859q, m16107v().size() > 1 ? MessagingInfoActivity.f14864v : MessagingInfoActivity.f14863u);
        startActivityForResult(intent, 112);
    }

    /* renamed from: b */
    private void m16024b(int i, boolean z) {
        C3869o c3869o;
        C3870p c3870pM14457g = this.f14996ap.m14457g();
        int iM14855b = (!z || c3870pM14457g == null || (c3869o = c3870pM14457g.get(0)) == null) ? 0 : c3869o.m14855b();
        switch (i) {
            case 0:
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2113", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2113", false);
                }
                C4149cd.m16427c(this, 100);
                break;
            case 1:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", TempFileProvider.f13544a);
                startActivityForResult(intent, 101);
                break;
            case 2:
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2114", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2114", false);
                }
                C4149cd.m16421b(this, 102);
                break;
            case 3:
                long jM15923a = m15923a(c3870pM14457g, iM14855b);
                if (jM15923a > 0) {
                    C4149cd.m16422b(this, 103, jM15923a);
                    break;
                } else {
                    Toast.makeText(this, getString(R.string.message_too_big_for_video), 0).show();
                    break;
                }
            case 4:
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2115", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2115", false);
                }
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(this, R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    AbstractC4932a.m18733a(this).mo18740a(getString(R.string.menu_chat_insert)).mo18751b(true).mo18744a(new CharSequence[]{getString(R.string.attach_voice_recorded_file), getString(R.string.attach_voice_create_recording)}, new DialogInterfaceOnClickListenerC4194dv(this)).mo18745a().show();
                    break;
                }
            case 6:
                m16096p();
                break;
            case 7:
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2116", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2116", false);
                }
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setData(Uri.parse("content://com.android.contacts/data/phones"));
                startActivityForResult(intent2, 20);
                break;
            case 8:
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2117", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2117", false);
                }
                startActivityForResult(new Intent(this, (Class<?>) MmsVCalendarListActivity2.class), 26);
                break;
            case 9:
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2118", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2118", false);
                }
                Intent intent3 = new Intent("android.intent.action.PICK");
                intent3.putExtra("image_location", true);
                intent3.setClassName(this, MmsGeotagActivity.class.getName());
                startActivityForResult(intent3, 36);
                break;
        }
    }

    /* renamed from: a */
    public static long m15923a(C3870p c3870p, int i) {
        long jM14697c = C3847e.m14697c() - 1024;
        if (c3870p != null) {
            return (jM14697c - c3870p.m14907b()) + i;
        }
        return jM14697c;
    }

    /* renamed from: h */
    public static boolean m16085h() {
        return CommonApplication.m18732r().getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    /* renamed from: M */
    private void m15893M() {
        this.f15052r = new ArrayList<>();
        this.f15052r.add(new C3809d(CommonApplication.m18732r().getResources(), R.string.menu_multimedia_picture, R.drawable.co_attach_p_image_normal, 0));
        if (m16085h()) {
            this.f15052r.add(new C3809d(CommonApplication.m18732r().getResources(), R.string.menu_multimedia_capture_picture, R.drawable.co_attach_p_camera_normal, 1));
        }
        this.f15052r.add(new C3809d(CommonApplication.m18732r().getResources(), R.string.menu_multimedia_video, R.drawable.co_attach_p_video_normal, 2));
        this.f15052r.add(new C3809d(CommonApplication.m18732r().getResources(), R.string.media_voice, R.drawable.co_attach_p_voice_normal, 4));
        this.f15052r.add(new C3809d(CommonApplication.m18732r().getResources(), R.string.media_contact, R.drawable.co_attach_p_contact_normal, 7));
        this.f15052r.add(new C3809d(CommonApplication.m18732r().getResources(), R.string.media_calendar, R.drawable.co_attach_p_calendar_normal, 8));
        if (C1427a.m7518a()) {
            this.f15052r.add(new C3809d(CommonApplication.m18732r().getResources(), R.string.media_map, R.drawable.co_attach_p_location_normal, 9));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m16080g(boolean z) {
        m15995ag();
        m15895N();
        if (this.f15051q == null) {
            this.f15051q = new DialogC3806a(this, this.f15052r, z);
        }
        if (!this.f15051q.isShowing()) {
            this.f15051q.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m15895N() {
        if (this.f14953Y != null) {
            this.f14953Y.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws IOException {
        C3782a c3782aM14204a;
        Cursor cursorQuery;
        C3799r c3799rM14392a;
        HashMap map;
        m16048c("requestCode=" + i + ", resultCode=" + i2 + ", data=" + intent);
        super.onActivityResult(i, i2, intent);
        this.f15040bq = true;
        this.f15001au = false;
        if (this.f14996ap.m14455e()) {
            this.f14996ap.m14464n();
        }
        if (i == 109) {
            this.f14996ap.m14446b(this.f14935G);
        }
        if (i == 113 && this.f15050p != null) {
            m16007am();
            m15979aF();
            m15980aG();
        }
        if (i2 != -1) {
            m16048c("bail due to resultCode=" + i2);
        }
        switch (i) {
            case 20:
                if (intent != null && (cursorQuery = getContentResolver().query(intent.getData(), null, null, null, null)) != null && cursorQuery.moveToFirst()) {
                    cursorQuery.moveToFirst();
                    m16069f(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, cursorQuery.getString(cursorQuery.getColumnIndex("lookup"))), false);
                    m16025b(cursorQuery);
                    break;
                }
                break;
            case 26:
                if (intent != null) {
                    m16069f(Uri.fromFile(new File(intent.getStringExtra(f14925s))), false);
                    break;
                }
                break;
            case 36:
                Bitmap bitmap = (Bitmap) intent.getExtras().get("map_image");
                if (bitmap == null) {
                    C3890m.m14999e("Mms/compose", "onActivityResult REQUEST_CODE_PICK_LOCATION mapImage is null");
                    break;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
                    C5094q c5094q = new C5094q();
                    c5094q.m19381a(byteArrayOutputStream.toByteArray());
                    c5094q.m19389e("image/jpg".getBytes());
                    Uri uriM14450c = this.f14996ap.m14450c(false);
                    C5097t c5097tM19426a = C5097t.m19426a(this);
                    long id = uriM14450c != null ? ContentUris.parseId(uriM14450c) : 0L;
                    if (id != 0) {
                        try {
                            m16026b(c5097tM19426a.m19445a(c5094q, id), true);
                        } catch (C5111c e) {
                            e.printStackTrace();
                        }
                    }
                    this.f14943O.setText(intent.getStringExtra("location"));
                    break;
                }
            case 100:
                if (intent != null) {
                    m15939a(intent.getData(), false);
                    break;
                }
                break;
            case 101:
                m15939a(Uri.fromFile(new File(TempFileProvider.m14189a(this))), false);
                break;
            case 102:
                if (intent != null) {
                    m16043c(intent.getData(), false);
                    break;
                }
                break;
            case 103:
                m16043c(TempFileProvider.m14187a(".3gp", null, this), false);
                break;
            case 104:
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                if (!Settings.System.DEFAULT_RINGTONE_URI.equals(uri)) {
                    m16063e(uri, false);
                    break;
                }
                break;
            case 105:
                if (intent != null) {
                    m16063e(intent.getData(), false);
                    break;
                }
                break;
            case 106:
                if (intent != null && (c3799rM14392a = C3799r.m14392a(this, intent.getData())) != null) {
                    this.f14996ap = c3799rM14392a;
                    this.f14996ap.m14436a(this.f14935G);
                    m16084h(false);
                    m15988ac();
                    invalidateOptionsMenu();
                    break;
                }
                break;
            case 107:
                if (intent.getBooleanExtra("exit_ecm_result", false)) {
                    m16090j(false);
                    break;
                }
                break;
            case 108:
                if (C3847e.m14651aB()) {
                    if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            C5179v.m19810a(this, R.string.trunk_network_not_available, 0).show();
                            break;
                        } else {
                            C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
                            C1002i.m6059a(true);
                            break;
                        }
                    } else {
                        if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                            C4809aa.m18104a().m18128b("Setting Sync TimeInMillis", String.valueOf(System.currentTimeMillis()));
                        }
                        new C2128i(null).m9497a("localsms");
                        break;
                    }
                } else if (this.f15004ax != null) {
                    String stringExtra = this.f15004ax.getStringExtra("email");
                    if (stringExtra == null) {
                        stringExtra = this.f15004ax.getStringExtra("phone");
                    }
                    if (stringExtra != null && (c3782aM14204a = C3782a.m14204a(stringExtra, false)) != null) {
                        c3782aM14204a.m14261c();
                        break;
                    }
                }
                break;
            case 109:
                if (intent != null) {
                    m16042c(intent);
                    break;
                }
                break;
            case 110:
                if (intent != null && (map = (HashMap) intent.getExtra("result")) != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        arrayList.add(C3789h.m14307c(C3782a.m14228c((String) it.next())));
                    }
                    if (arrayList.size() > 0) {
                        if (this.f14996ap.m14463m() == null) {
                            this.f14996ap.m14441a(arrayList);
                        } else if (arrayList.size() > 0) {
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                this.f14996ap.m14440a((String) it2.next());
                            }
                        }
                        m16109w();
                    }
                    m15988ac();
                    break;
                }
                break;
            case 111:
                C2346e.m10272a(this, i2, intent, false, new HandlerC4257gd(this));
                break;
            case 112:
                this.f15019bQ.sendEmptyMessage(i2);
                break;
            case 201:
                this.f14943O.setText(intent.getStringExtra("target_text"));
                m16102s();
                if (i2 == -1) {
                    this.f14943O.setText("");
                    break;
                }
                break;
            default:
                m16048c("bail due to unknown requestCode=" + i);
                break;
        }
    }

    /* renamed from: c */
    private void m16042c(Intent intent) {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("com.android.contacts.extra.PHONE_URIS");
        int length = parcelableArrayExtra != null ? parcelableArrayExtra.length : 0;
        int iM14708n = C3847e.m14708n();
        if (iM14708n == Integer.MAX_VALUE || length <= iM14708n) {
            Handler handler = new Handler();
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle(getText(R.string.pick_too_many_recipients));
            progressDialog.setMessage(getText(R.string.adding_recipients));
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            RunnableC4196dx runnableC4196dx = new RunnableC4196dx(this, progressDialog);
            handler.postDelayed(runnableC4196dx, 1000L);
            new Thread(new RunnableC4197dy(this, parcelableArrayExtra, handler, runnableC4196dx, progressDialog)).start();
            return;
        }
        AbstractC4932a.m18733a(this).mo18734a(R.string.pick_too_many_recipients).mo18753c(android.R.drawable.ic_dialog_alert).mo18749b(getString(R.string.too_many_recipients, new Object[]{Integer.valueOf(length), Integer.valueOf(iM14708n)})).mo18756d(android.R.string.ok, null).mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15934a(int i, int i2, Uri uri) {
        if (i != 0) {
            runOnUiThread(new RunnableC4202ec(this, i));
        }
    }

    /* renamed from: a */
    private void m15939a(Uri uri, boolean z) {
        m15966a(new RunnableC4203ed(this, uri, z), R.string.adding_attachments_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16026b(Uri uri, boolean z) {
        m16048c("append=" + z + ", uri=" + uri);
        int iM14433a = this.f14996ap.m14433a(1, uri, z);
        if (iM14433a == -4 || iM14433a == -2 || iM14433a == -8) {
            m16048c("resize image " + uri);
            C4149cd.m16404a(this, uri, this.f15047bx, this.f15015bJ, z);
        } else {
            m15934a(iM14433a, R.string.type_picture, uri);
        }
    }

    /* renamed from: c */
    private void m16043c(Uri uri, boolean z) {
        m15966a(new RunnableC4204ee(this, uri, z), R.string.adding_attachments_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16054d(Uri uri, boolean z) {
        if (uri != null) {
            m15934a(this.f14996ap.m14433a(2, uri, z), R.string.type_video, uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m16063e(Uri uri, boolean z) {
        if (uri != null) {
            m15934a(this.f14996ap.m14433a(3, uri, z), R.string.type_audio, uri);
        }
    }

    /* renamed from: a */
    private void m15966a(Runnable runnable, int i) {
        new AsyncTaskC4259gf(this, i).execute(runnable);
    }

    /* renamed from: f */
    private void m16069f(Uri uri, boolean z) {
        m15966a(new RunnableC4205ef(this, uri, z), R.string.adding_attachments_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m16077g(Uri uri, boolean z) {
        if (uri != null) {
            m15934a(this.f14996ap.m14433a(5, uri, z), R.string.type_raw, uri);
        }
    }

    /* renamed from: O */
    private boolean m15898O() {
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("forwarded_message", false)) {
            return false;
        }
        Uri uri = (Uri) intent.getParcelableExtra("msg_uri");
        if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
            m16048c("" + uri);
        }
        if (uri != null) {
            this.f14996ap = C3799r.m14392a(this, uri);
            if (this.f14996ap != null) {
                this.f14996ap.m14439a((CharSequence) intent.getStringExtra("subject"), false);
            }
        } else {
            this.f14996ap.m14438a((CharSequence) intent.getStringExtra("sms_body"));
        }
        this.f15050p.changeCursor(null);
        return true;
    }

    /* renamed from: P */
    private boolean m15899P() {
        int iMin;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        String type = intent.getType();
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action)) {
            if (extras.containsKey("android.intent.extra.STREAM")) {
                m15966a(new RunnableC4206eg(this, type, (Uri) extras.getParcelable("android.intent.extra.STREAM")), R.string.adding_attachments_title);
                if (extras.containsKey("android.intent.extra.TEXT")) {
                    this.f14996ap.m14438a((CharSequence) extras.getString("android.intent.extra.TEXT"));
                }
                return true;
            }
            if (!extras.containsKey("android.intent.extra.TEXT")) {
                return false;
            }
            this.f14996ap.m14438a((CharSequence) extras.getString("android.intent.extra.TEXT"));
            return true;
        }
        if (!"android.intent.action.SEND_MULTIPLE".equals(action) || !extras.containsKey("android.intent.extra.STREAM")) {
            return false;
        }
        C3870p c3870pM14457g = this.f14996ap.m14457g();
        ArrayList parcelableArrayList = extras.getParcelableArrayList("android.intent.extra.STREAM");
        int size = c3870pM14457g != null ? c3870pM14457g.size() : 0;
        int size2 = parcelableArrayList.size();
        if (size2 + size > 10) {
            iMin = Math.min(10 - size, size2);
            Toast.makeText(this, getString(R.string.too_many_attachments, new Object[]{10, Integer.valueOf(iMin)}), 1).show();
        } else {
            iMin = size2;
        }
        m15966a(new RunnableC4207eh(this, iMin, parcelableArrayList, type), R.string.adding_attachments_title);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15967a(String str, Uri uri, boolean z) {
        if (uri != null) {
            boolean zEquals = "*/*".equals(str);
            if (str.startsWith("image/") || (zEquals && uri.toString().startsWith(f14921bL))) {
                m16026b(uri, z);
                return;
            }
            if (str.startsWith("video/") || (zEquals && uri.toString().startsWith(f14920bK))) {
                m16054d(uri, z);
                return;
            }
            if (str.startsWith("audio/") || (zEquals && uri.toString().startsWith(f14922bM))) {
                m16063e(uri, z);
            } else if (str.equalsIgnoreCase("text/x-vCard") || str.equalsIgnoreCase("text/x-vCalendar")) {
                m16069f(uri, z);
            }
        }
    }

    /* renamed from: a */
    private String m15930a(int i, String str) {
        return getResources().getString(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public void m15901Q() {
        m16101r();
        if (this.f14996ap.m14456f()) {
            this.f14941M.setEnabled(false);
        } else {
            this.f14941M.setEnabled(true);
        }
        if (!this.f14975aU && !m15977aD()) {
            this.f14940L.setVisibility(0);
            if (this.f14943O.length() > 0) {
                this.f14944P.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public void m15903R() {
        m15901Q();
        CharSequence charSequenceM14444b = this.f14996ap.m14444b();
        if (charSequenceM14444b != null) {
            CharSequence charSequenceM11709a = C2799k.m11709a(this, charSequenceM14444b.toString(), (int) (this.f14943O.getLineHeight() * 1.2f));
            if (!TextUtils.isEmpty(charSequenceM11709a)) {
                this.f14943O.setTextKeepState(charSequenceM11709a);
                this.f14943O.setSelection(this.f14943O.getText().length());
                return;
            }
            return;
        }
        this.f14943O.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m16084h(boolean z) {
        this.f14952X.setVisibility(this.f14951W.m15723a(this.f14996ap) ? 0 : 8);
        m16058d(z || this.f14996ap.m14460j());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        int size;
        if (view == this.f14941M) {
            m16080g(false);
            return;
        }
        if (view == this.f14942N) {
            if (C3847e.m14694az()) {
                if (!m16006al()) {
                    m15994af();
                } else {
                    m15995ag();
                }
                m15895N();
                return;
            }
            return;
        }
        if (view == this.f14949U && m15920Z()) {
            if (this.f14996ap.m14470t()) {
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2112", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2112", false);
                }
            } else if (C4822an.m18218a()) {
                C5043h.m19179a().m19185a("2001", "2111", false);
            } else {
                C5043h.m19179a().m19185a("0201", "2111", false);
            }
            m15995ag();
            m15895N();
            if (this.f14938J != null && this.f14938J.m16531a() == 0) {
                if (this.f14954Z.m16167a() == 0) {
                    this.f14954Z.requestFocus();
                    return;
                }
                this.f14996ap.m14441a(this.f14954Z.m16170b());
                m16109w();
                m16123c(this.f14996ap.m14470t());
                return;
            }
            m16123c(this.f14996ap.m14470t());
            return;
        }
        if (view.equals(this.f14981aa)) {
            if (this.f15054x) {
                if (this.f14954Z != null && m16111x()) {
                    C3789h c3789hM16168a = this.f14954Z.m16168a(false);
                    if (c3789hM16168a.size() > 0) {
                        if (this.f14996ap.m14463m() == null) {
                            this.f14996ap.m14441a(new ArrayList(Arrays.asList(c3789hM16168a.m14313c())));
                        } else if (c3789hM16168a.m14313c().length > 0) {
                            if (this.f14996ap.m14463m() == null) {
                                size = c3789hM16168a.m14313c().length;
                            } else {
                                size = this.f14996ap.m14462l().size() + c3789hM16168a.m14313c().length;
                            }
                            if (!m16032b(size)) {
                                for (String str : c3789hM16168a.m14313c()) {
                                    this.f14996ap.m14440a(str);
                                }
                            } else {
                                return;
                            }
                        }
                        m16109w();
                        return;
                    }
                    return;
                }
                m16125f();
                return;
            }
            m15908T();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public void m15906S() {
        String[] strArrM14313c;
        if (C4822an.m18218a()) {
            if (this.f14938J != null && m15878E()) {
                strArrM14313c = (String[]) this.f14938J.m16536c().toArray(new String[0]);
            } else {
                strArrM14313c = m16107v().m14313c();
            }
            if (strArrM14313c != null && strArrM14313c.length != 0) {
                int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(this, R.string.popup_no_network_connection, 0).show();
                    return;
                }
                if (C3847e.m14691aw()) {
                    AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
                    abstractC4932aM18733a.mo18740a(getResources().getString(R.string.send_invite_message));
                    View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_freesms_invitation_send_popup, (ViewGroup) null);
                    m15943a((TextView) viewInflate.findViewById(R.id.popupContent02), GlobalApplication.m10283b().getString(R.string.invite_message_lite, "\nwww.chaton.com/invite.html"), "www.chaton.com/invite.html", -16776961);
                    abstractC4932aM18733a.mo18748b(viewInflate);
                    abstractC4932aM18733a.mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC4209ej(this, strArrM14313c));
                    abstractC4932aM18733a.mo18741a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC4210ek(this)).mo18745a();
                    abstractC4932aM18733a.mo18745a().show();
                    return;
                }
                String str = strArrM14313c[0];
                if (str.length() > 7) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    m15885I();
                    this.f15028be.m9377a(arrayList, EnumC2463n.UI);
                    return;
                }
                Toast.makeText(CommonApplication.m18732r(), R.string.buddy_list_dialog_addbuddy_failed_invalid_phonenumber, 0).show();
                return;
            }
            Toast.makeText(CommonApplication.m18732r(), R.string.buddy_list_dialog_addbuddy_failed_invalid_phonenumber, 0).show();
            return;
        }
        this.f14997aq = GlobalApplication.m10283b().getString(R.string.invite_message_lite, "\nwww.chaton.com/invite.html");
        this.f14943O.setText(this.f14997aq);
    }

    /* renamed from: a */
    public static void m15943a(TextView textView, String str, String str2, int i) {
        textView.setText(str, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable) textView.getText();
        int iIndexOf = str.indexOf(str2);
        spannable.setSpan(new ForegroundColorSpan(i), iIndexOf, str2.length() + iIndexOf, 33);
    }

    /* renamed from: T */
    private void m15908T() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) BuddyActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 1000);
        intent.putExtra("fromsms", "true");
        intent.putExtra("max", 25 - m15983aa());
        startActivityForResult(intent, 110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public void m15910U() {
        startActivityForResult(C2346e.m10270a(this), 111);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) throws IOException {
        if (keyEvent != null) {
            C3890m.m14999e("Mms/compose", "actionId:" + i + " KeyEvent:" + keyEvent);
            if (i == 4 || (keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 0 && !C4809aa.m18104a().m18119a("Setting enter key", (Boolean) false).booleanValue())) {
                return false;
            }
            if (keyEvent.isShiftPressed()) {
                return false;
            }
            if (!m15920Z()) {
                return true;
            }
            m16102s();
            return true;
        }
        if (!m15920Z()) {
            return true;
        }
        m16102s();
        return true;
    }

    /* renamed from: V */
    private void m15911V() {
        this.f14967aM = (FrameLayout) findViewById(R.id.rootLayout);
        this.f14967aM.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4215ep(this));
        this.f14968aN = (ImageView) findViewById(R.id.imagebackgroup);
        this.f14962aH = (FrameLayout) findViewById(R.id.messageLayout);
        this.f14953Y = (MessageListView) findViewById(R.id.history);
        this.f14953Y.setDivider(null);
        this.f14953Y.setClipToPadding(false);
        this.f14953Y.setClipChildren(false);
        this.f14961aG = (ViewGroup) findViewById(R.id.emoticonLayout);
        this.f14940L = findViewById(R.id.messageInputLayout);
        this.f14941M = (ImageButton) findViewById(R.id.btnAdd);
        this.f14941M.setOnClickListener(this);
        this.f14942N = (ImageButton) findViewById(R.id.btnChatImage);
        if (C3847e.m14694az()) {
            this.f14942N.setOnClickListener(this);
        } else {
            this.f14942N.setVisibility(8);
        }
        this.f14943O = (MmsMyEditText) findViewById(R.id.embedded_text_editor);
        this.f14943O.setOnEditorActionListener(this);
        this.f14943O.addTextChangedListener(this.f15016bN);
        this.f14943O.setFilters(new InputFilter[]{new InputFilter.LengthFilter(C3847e.m14709o())});
        this.f14944P = (LinearLayout) findViewById(R.id.floating_menu_layout);
        this.f14945Q = (LinearLayout) findViewById(R.id.text_counter_layout);
        this.f14946R = (LinearLayout) findViewById(R.id.text_mms_layout);
        this.f14947S = (TextView) findViewById(R.id.text_counter);
        this.f14948T = (TextView) findViewById(R.id.text_mms);
        this.f14949U = (ImageButton) findViewById(R.id.send_button);
        this.f14949U.setOnClickListener(this);
        this.f14939K = findViewById(R.id.recipients_subject_linear);
        this.f14939K.setFocusable(false);
        this.f14951W = (AttachmentEditor) findViewById(R.id.attachment_editor);
        this.f14951W.setHandler(this.f15047bx);
        this.f14952X = findViewById(R.id.attachment_editor_scroll_view);
        this.f14976aV = (LinearLayout) findViewById(R.id.message_select_all);
        this.f14977aW = (CheckBox) findViewById(R.id.message_select_all_chButton);
        if (C3847e.m14651aB()) {
            this.f14982ab = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.message_unknown_layout, (ViewGroup) this.f14953Y, false);
            this.f14953Y.addHeaderView(this.f14982ab);
            this.f14983ac = (LinearLayout) findViewById(R.id.unknown_tab_layout);
            this.f14984ad = (HoneycombLinearLayout) findViewById(R.id.unknown_tab_before_add_to_spam);
            this.f14985ae = (ImageButton) findViewById(R.id.unknown_add_to_contact_tab);
            this.f14986af = (ImageButton) findViewById(R.id.unknown_add_to_spam_tab);
            this.f14987ag = (HoneycombLinearLayout) findViewById(R.id.unknown_tab_after_add_to_spam);
            this.f14988ah = (ImageButton) findViewById(R.id.unknown_remove_from_spam_tab);
            this.f14989ai = (LinearLayout) findViewById(R.id.spam_warning_stamp_layout);
            this.f14990aj = (TextView) findViewById(R.id.spam_warning_stamp_text);
            this.f14991ak = (LinearLayout) findViewById(R.id.spam_request_progress);
        }
        this.f15037bn = (FrameLayout) findViewById(R.id.messageListViewFrameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15936a(DialogInterface.OnClickListener onClickListener, boolean z) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        abstractC4932aM18733a.mo18734a(R.string.menu_chat_delete);
        abstractC4932aM18733a.mo18746b(z ? R.string.confirm_delete_locked_message : R.string.confirm_delete_message);
        abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, onClickListener);
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: a */
    private void m15962a(DialogInterfaceOnClickListenerC4252fz dialogInterfaceOnClickListenerC4252fz, boolean z) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.commenttextview);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_packet_chekcbox);
        textView.setText(R.string.confirm_delete_messages);
        checkBox.setText(getString(R.string.delete_unlocked));
        if (!z) {
            linearLayout.setVisibility(8);
            checkBox.setVisibility(8);
        } else {
            dialogInterfaceOnClickListenerC4252fz.m16465a(checkBox.isChecked());
            checkBox.setOnClickListener(new ViewOnClickListenerC4216eq(this, dialogInterfaceOnClickListenerC4252fz));
            linearLayout.setVisibility(0);
            checkBox.setVisibility(0);
        }
        abstractC4932aM18733a.mo18734a(R.string.menu_chat_delete).mo18748b(viewInflate).mo18742a(true).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null).mo18756d(R.string.dialog_ok, dialogInterfaceOnClickListenerC4252fz);
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15968a(String str, String str2, String str3, int i) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.commenttextview);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_packet_chekcbox);
        textView.setText(str2);
        if (TextUtils.isEmpty(str3)) {
            linearLayout.setVisibility(8);
            checkBox.setVisibility(8);
        } else {
            checkBox.setChecked(false);
            checkBox.setText(str3);
            linearLayout.setVisibility(0);
            checkBox.setVisibility(0);
        }
        abstractC4932aM18733a.mo18740a(str).mo18748b(viewInflate).mo18742a(true).mo18751b(true).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4218es(this, i, checkBox)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4217er(this, i, checkBox));
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public void m15913W() {
        Uri uriM14357c = this.f14935G.m14357c();
        if (uriM14357c == null) {
            m16048c("##### startMsgListQuery: conversationUri is null, bail!");
            return;
        }
        long jM14359d = this.f14935G.m14359d();
        m16048c("startMsgListQuery for " + uriM14357c + ", threadId=" + jM14359d);
        this.f15013bH.m15232a(9527);
        try {
            this.f15013bH.m15237a(this.f15019bQ, 9527, Long.valueOf(jM14359d), C3847e.m14679ak() ? C4110as.f15298l : C4110as.f15299m, jM14359d);
        } catch (SQLiteException e) {
            SqliteWrapper.checkSQLiteException(this, e);
        }
    }

    /* renamed from: X */
    private void m15915X() {
        if (this.f15050p == null || this.f14937I) {
            String stringExtra = getIntent().getStringExtra("highlight");
            if (stringExtra != null) {
                this.f15022bT = getIntent().getLongExtra("select_id", -1L);
                this.f15023bU = getIntent().getStringExtra("message_type");
            } else {
                this.f15022bT = -1L;
                this.f15023bU = "";
            }
            this.f15050p = new C4110as(this, null, this.f14953Y, true, stringExtra == null ? null : Pattern.compile("\\b" + Pattern.quote(stringExtra), 2));
            this.f15050p.m16329a(this.f15018bP);
            this.f15050p.m16327a(this.f15048by);
            this.f15050p.m16336c(m15983aa() > 1);
            if (C3847e.m14693ay() && m16107v().size() == 1) {
                this.f15050p.m16330a(m16034b(m16107v().get(0)));
                this.f15050p.m16328a(this.f15056z);
            }
            this.f15050p.m16332b(this.f14929A);
            this.f14953Y.setAdapter((ListAdapter) this.f15050p);
            this.f14953Y.setItemsCanFocus(false);
            this.f14953Y.setVisibility(0);
            this.f14953Y.setOnCreateContextMenuListener(this.f15010bD);
            this.f14953Y.setOnItemClickListener(new C4219et(this));
            this.f14953Y.setOnScrollListener(new C4220eu(this));
        }
    }

    /* renamed from: Y */
    private void m15917Y() {
        if (this.f14996ap.m14454d()) {
            C3890m.m14997c("Mms/compose", "called with non-empty working message");
            return;
        }
        m16048c("call WorkingMessage.loadDraft");
        this.f14996ap = C3799r.m14393a(this, this.f14935G, this.f14996ap);
        this.f14996ap.m14448b(true);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0082 -> B:28:0x0011). Please report as a decompilation issue!!! */
    /* renamed from: i */
    private void m16088i(boolean z) {
        C3890m.m14994a("Mms/compose", "saveDraft");
        if (!this.f14996ap.m14467q()) {
            if (!this.f15001au && !this.f14996ap.m14454d() && (!m15878E() || m15983aa() == 0 || !TextUtils.isEmpty(this.f14996ap.m14472v()))) {
                C3890m.m14994a("Mms/compose", "saveDraft: not worth saving");
                if (this.f15035bl || this.f15036bm) {
                    C3890m.m14994a("Mms/compose", "saveDraft: discard WorkingMessage and bail");
                    this.f14996ap.m14465o();
                    return;
                }
                return;
            }
            try {
                if (m15971a(m16107v())) {
                    this.f14996ap.m14453d(z);
                    C0991aa.m6037a().m18962d(C1011aj.m6083a(this.f14996ap.m14463m(), this.f14996ap.m14444b().toString()));
                } else {
                    this.f14996ap.m14465o();
                }
            } catch (C3805c e) {
                C3890m.m14999e("Mms/compose", "Unable to save draft. Exceed message size. Discard the message");
                this.f14996ap.m14465o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public boolean m15920Z() {
        int iM15983aa;
        if ((!C3847e.m14686ar() || C3892o.m15023b()) && (iM15983aa = m15983aa()) > 0 && iM15983aa <= C3847e.m14708n()) {
            return this.f14996ap.m14456f() || this.f14996ap.m14452c();
        }
        return false;
    }

    /* renamed from: aa */
    private int m15983aa() {
        if (this.f14938J != null && m15878E()) {
            return this.f14938J.m16531a();
        }
        return m16107v().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m16090j(boolean z) throws IOException {
        this.f14937I = false;
        C3789h c3789hM14462l = this.f14996ap.m14462l();
        if (z && Boolean.parseBoolean(SystemProperties.get("ril.cdma.inecmmode"))) {
            try {
                startActivityForResult(new Intent("android.intent.action.ACTION_SHOW_NOTICE_ECM_BLOCK_OTHERS", (Uri) null), 107);
                return;
            } catch (ActivityNotFoundException e) {
                C3890m.m14995a("Mms/compose", "Cannot find EmergencyCallbackModeExitDialog", e);
            }
        }
        if (!m15971a(m16107v())) {
            Toast.makeText(CommonApplication.m18732r(), CommonApplication.m18732r().getString(R.string.invalid_recipient_message), 0).show();
            return;
        }
        if (!this.f15003aw) {
            if (c3789hM14462l != null) {
                new C4264gk(this, this.f15048by, c3789hM14462l).start();
            }
            m16002aj();
            String string = this.f14996ap.m14444b().toString();
            if (!TextUtils.isEmpty(this.f15045bv) && this.f15030bg != null && this.f15031bh && string != null) {
                this.f14996ap.m14438a((CharSequence) ("[" + getResources().getString(R.string.app_name) + " " + getResources().getString(R.string.shop) + "] " + this.f15045bv + " " + string));
                this.f15045bv = "";
            }
            this.f14996ap.m14451c(C3789h.m14307c(this.f15005ay));
            this.f15003aw = true;
            m16000ai();
            if (this.f15030bg != null && this.f15031bh) {
                Uri uriBuild = C2255ba.f8038a.buildUpon().appendPath(this.f15030bg).build();
                long jCurrentTimeMillis = System.currentTimeMillis();
                ContentValues contentValues = new ContentValues();
                contentValues.put("sent_time", Long.valueOf(jCurrentTimeMillis));
                try {
                    CommonApplication.m18732r().getContentResolver().update(uriBuild, contentValues, null, null);
                } catch (SQLiteException e2) {
                    m16048c("SQLiteException when recent anicon updating, (in sendMessage)");
                }
                C2797i.m11705a().m19002a(this.f15030bg, true);
                this.f15031bh = false;
                if (C4822an.m18218a()) {
                    C5043h.m19179a().m19185a("2001", "2128", false);
                } else {
                    C5043h.m19179a().m19185a("0201", "2128", false);
                }
                Toast.makeText(CommonApplication.m18732r(), CommonApplication.m18732r().getString(R.string.anicon_will_be_converted), 0).show();
            }
            if (C3847e.m14694az()) {
                C2797i.m11705a().m19003a(C2799k.m11710a(this, this.f14996ap.m14444b().toString()), true);
            }
        }
        if (this.f14936H) {
        }
        if (C4822an.m18203M()) {
            this.f15046bw = c3789hM14462l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ab */
    public void m15986ab() {
        this.f14951W.m15722a();
        this.f14952X.setVisibility(8);
        m16058d(false);
        this.f14943O.requestFocus();
        this.f14943O.removeTextChangedListener(this.f15016bN);
        TextKeyListener.clear(this.f14943O.getText());
        this.f14996ap.m14437a(this.f14935G, false);
        this.f14996ap = C3799r.m14391a(this);
        this.f14996ap.m14436a(this.f14935G);
        if (m15878E() && !C3847e.m14654aE() && (!C4822an.m18203M() || !this.f15039bp)) {
            m16115z();
        }
        m15876D();
        m15903R();
        m15988ac();
        this.f14943O.addTextChangedListener(this.f15016bN);
        if (this.f14993am) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f14943O.getWindowToken(), 0);
        }
        this.f15002av = 0;
        this.f15003aw = false;
        invalidateOptionsMenu();
        this.f15050p.m16336c(m15983aa() > 1);
        if (C3847e.m14693ay() && m16107v().size() == 1) {
            this.f15050p.m16330a(m16034b(m16107v().get(0)));
            this.f15050p.m16328a(this.f15056z);
        }
        this.f15050p.m16332b(this.f14929A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ac */
    public void m15988ac() {
        boolean z = false;
        if (m15920Z()) {
            z = true;
        }
        this.f14949U.setEnabled(z);
        this.f14949U.setFocusable(z);
    }

    /* renamed from: a */
    private void m15940a(Bundle bundle) {
        Intent intent = getIntent();
        if (bundle != null) {
            setIntent(getIntent().setAction("android.intent.action.VIEW"));
            String string = bundle.getString("recipients");
            C3896s.m15044b("mConversation by recipients " + string, "Mms/compose");
            this.f14935G = C3790i.m14320a((Context) this, C3789h.m14304a(string, false, true), false);
            m16000ai();
            this.f14936H = bundle.getBoolean("exit_on_sent", false);
            this.f14996ap.m14445b(bundle);
            return;
        }
        long longExtra = intent.getLongExtra("thread_id", 0L);
        this.f14937I = intent.getBooleanExtra("add_recipient_message", false);
        if (longExtra > 0) {
            C3896s.m15044b("get mConversation by threadId " + longExtra, "Mms/compose");
            this.f14935G = C3790i.m14317a((Context) this, longExtra, false);
        } else if (this.f14937I) {
            Uri uri = (Uri) intent.getParcelableExtra("msg_uri");
            if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
                m16048c("" + uri);
            }
            if (uri != null) {
                this.f14996ap = C3799r.m14392a(this, uri);
                if (this.f14996ap == null) {
                    this.f14996ap = C3799r.m14391a(this);
                }
            }
            String stringExtra = intent.getStringExtra("recipients");
            String[] strArrSplit = null;
            if (stringExtra != null) {
                strArrSplit = stringExtra.split(Config.KEYVALUE_SPLIT);
            }
            ArrayList arrayList = new ArrayList();
            if (strArrSplit != null && strArrSplit.length > 0) {
                for (String str : strArrSplit) {
                    arrayList.add(C3789h.m14307c(str));
                }
            }
            this.f14996ap.m14441a(arrayList);
            this.f14935G = C3790i.m14316a(this);
        } else {
            Uri data = intent.getData();
            if (data != null) {
                C3896s.m15044b("get mConversation by intentData " + data, "Mms/compose");
                if (data.getPathSegments().size() < 2) {
                    this.f14966aL = new String[]{C3790i.m14323a(data)};
                }
                this.f14935G = C3790i.m14319a((Context) this, data, false);
                this.f14996ap.m14438a((CharSequence) m15931a(data));
                if (this.f14966aL != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (String str2 : this.f14966aL) {
                        arrayList2.add(C3789h.m14307c(C3782a.m14228c(str2)));
                    }
                    this.f14996ap.m14441a(arrayList2);
                }
                if (C4822an.m18203M()) {
                    Context contextM18732r = CommonApplication.m18732r();
                    if (C3892o.m15012a(contextM18732r, contextM18732r.getContentResolver(), this.f14996ap.m14462l()) != null) {
                        this.f15039bp = true;
                    }
                }
            } else if (intent.hasExtra("receiver_array")) {
                this.f14966aL = intent.getStringArrayExtra("receiver_array");
                ArrayList arrayList3 = new ArrayList();
                for (String str3 : this.f14966aL) {
                    arrayList3.add(C3789h.m14307c(C3782a.m14228c(str3)));
                }
                this.f14935G = C3790i.m14320a((Context) this, C3789h.m14302a((Iterable<String>) arrayList3, false, true), false);
                this.f14996ap.m14441a(arrayList3);
                if (C4822an.m18203M()) {
                    Context contextM18732r2 = CommonApplication.m18732r();
                    if (C3892o.m15012a(contextM18732r2, contextM18732r2.getContentResolver(), this.f14996ap.m14462l()) != null) {
                        this.f15039bp = true;
                    }
                }
            } else {
                String stringExtra2 = intent.getStringExtra("address");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    m16048c("get mConversation by address " + stringExtra2);
                    this.f14935G = C3790i.m14320a((Context) this, C3789h.m14304a(stringExtra2, false, true), false);
                    this.f14996ap.m14440a(stringExtra2);
                } else {
                    C3896s.m15044b("create new conversation", "Mms/compose");
                    this.f14935G = C3790i.m14316a(this);
                }
            }
        }
        m16000ai();
        this.f14936H = intent.getBooleanExtra("exit_on_sent", false);
        if (intent.hasExtra("sms_body")) {
            this.f14996ap.m14438a((CharSequence) intent.getStringExtra("sms_body"));
        }
        this.f14996ap.m14439a((CharSequence) intent.getStringExtra("subject"), false);
    }

    /* renamed from: ad */
    private void m15990ad() {
        if (this.f14992al) {
            if (m15878E() && TextUtils.isEmpty(this.f14954Z.getText()) && !this.f14943O.isFocused() && this.f14938J.m16531a() == 0) {
                this.f14954Z.requestFocus();
            } else {
                this.f14943O.requestFocus();
            }
        }
    }

    /* renamed from: ae */
    private void m15992ae() {
        if (this.f14995ao && hasWindowFocus()) {
            this.f14935G.m14355b();
            this.f14995ao = false;
        }
    }

    /* renamed from: af */
    private void m15994af() {
        if (this.f14963aI == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.emoticon_selection_view_height));
            this.f14963aI = new SmsEmoticonSelectionView(this);
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
            if (this.f14965aK == null) {
                this.f14965aK = layoutInflaterFrom.inflate(R.layout.actionbar_select_emoticon, (ViewGroup) null, false);
            }
            if (layoutParams.height > 0) {
                layoutParams.height -= (int) C3880c.m14962a(49.5f);
            }
            this.f14963aI.setLayoutParams(layoutParams);
            this.f14963aI.setVisibility(0);
            this.f14963aI.setEmoticonSelectedListener(this);
            this.f14961aG.addView(this.f14963aI);
            if (this.f14964aJ == null) {
                this.f14964aJ = new View(this);
                this.f14964aJ.setBackgroundColor(getResources().getColor(R.color.emoticon_under_background));
                this.f14964aJ.setOnClickListener(new ViewOnClickListenerC4224ey(this));
            }
            this.f14962aH.addView(this.f14964aJ);
            getFragmentManager().executePendingTransactions();
        }
        this.f14963aI.setVisibility(0);
        this.f14964aJ.setVisibility(0);
        invalidateOptionsMenu();
        m18784t().mo18820a(this.f14965aK);
        m18784t().mo18836e(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ag */
    public void m15995ag() {
        if (this.f14963aI != null && this.f14964aJ != null) {
            this.f14963aI.setVisibility(8);
            this.f14964aJ.setVisibility(8);
            invalidateOptionsMenu();
            m16133o();
        }
    }

    /* renamed from: ah */
    private void m15997ah() throws Resources.NotFoundException {
        boolean z;
        if (this.f14998ar == null) {
            int[] iArr = C3876aa.f13942a;
            String[] stringArray = getResources().getStringArray(R.array.default_smiley_names);
            String[] stringArray2 = getResources().getStringArray(R.array.default_smiley_texts);
            int length = stringArray.length;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        z = false;
                        break;
                    } else {
                        if (iArr[i] == iArr[i2]) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z) {
                    HashMap map = new HashMap();
                    map.put("icon", Integer.valueOf(iArr[i]));
                    map.put("name", stringArray[i]);
                    map.put("text", stringArray2[i]);
                    arrayList.add(map);
                }
            }
            SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.smiley_menu_item, new String[]{"icon", "name", "text"}, new int[]{R.id.smiley_icon, R.id.smiley_name, R.id.smiley_text});
            simpleAdapter.setViewBinder(new C4225ez(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.menu_insert_smiley));
            builder.setCancelable(true);
            builder.setAdapter(simpleAdapter, new DialogInterfaceOnClickListenerC4227fa(this, simpleAdapter));
            this.f14998ar = builder.create();
        }
        this.f14998ar.show();
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3788g
    /* renamed from: a */
    public void mo14300a(C3782a c3782a) {
        this.f15048by.post(new RunnableC4228fb(this, c3782a));
    }

    /* renamed from: ai */
    private void m16000ai() {
        C3782a.m14212a((InterfaceC3788g) this);
    }

    /* renamed from: aj */
    private void m16002aj() {
        C3782a.m14221b(this);
    }

    /* renamed from: ak */
    private void m16004ak() {
        this.f15047bx.removeCallbacks(this.f15007bA);
        this.f14999as = null;
    }

    /* renamed from: a */
    public static Intent m15925a(Context context, long j) {
        int iM14644a;
        Intent intent = new Intent(context, (Class<?>) PluginComposeMessageActivity.class);
        if (j > 0) {
            intent.setData(C3790i.m14315a(j));
        }
        if (C3847e.m14656aG() && (iM14644a = C3847e.m14644a(j)) > 0) {
            intent.putExtra(f14924o, iM14644a);
        }
        return intent;
    }

    /* renamed from: a */
    private String m15931a(Uri uri) throws UnsupportedEncodingException {
        String strDecode = null;
        if (uri != null) {
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            if (schemeSpecificPart.contains("?")) {
                String[] strArrSplit = schemeSpecificPart.substring(schemeSpecificPart.indexOf(63) + 1).split("&");
                for (String str : strArrSplit) {
                    if (str.startsWith("body=")) {
                        try {
                            strDecode = URLDecoder.decode(str.substring(5), "UTF-8");
                            break;
                        } catch (UnsupportedEncodingException e) {
                        }
                    }
                }
            }
        }
        return strDecode;
    }

    @Override // com.sec.chaton.smsplugin.p103c.InterfaceC3810e
    /* renamed from: a */
    public void mo14481a(int i, boolean z) {
        m16024b(i, z);
        this.f15051q.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15935a(ActivityNotFoundException activityNotFoundException, Intent intent) {
        Toast.makeText(CommonApplication.m18732r(), CommonApplication.m18732r().getString(R.string.content_not_supported), 0).show();
    }

    @Override // com.sec.chaton.smsplugin.multimedia.emoticon.InterfaceC3922b
    /* renamed from: a_ */
    public void mo15134a_(String str) {
        int selectionStart = this.f14943O.getSelectionStart();
        int selectionEnd = this.f14943O.getSelectionEnd();
        CharSequence charSequenceM11712b = C2799k.m11712b(this, str, (int) (this.f14943O.getLineHeight() * 1.2f));
        if ((this.f14943O.getText().length() + charSequenceM11712b.length()) - (selectionEnd - selectionStart) >= 10000) {
            Toast.makeText(CommonApplication.m18732r(), R.string.toast_text_max_Length, 0).show();
            return;
        }
        if (this.f14943O.getEditableText() != null) {
            this.f14943O.getEditableText().replace(selectionStart, selectionEnd, charSequenceM11712b, 0, charSequenceM11712b.length());
        }
        this.f14943O.setSelection(charSequenceM11712b.length() + selectionStart, selectionStart + charSequenceM11712b.length());
        this.f14943O.requestFocus();
    }

    /* renamed from: al */
    private boolean m16006al() {
        return this.f14963aI != null && this.f14963aI.getVisibility() == 0;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (m16006al()) {
            m15995ag();
            this.f14953Y.setFocusable(true);
            m15895N();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.sec.chaton.smsplugin.multimedia.emoticon.InterfaceC3922b
    /* renamed from: b */
    public void mo15135b(String str) {
        m15995ag();
        m15895N();
        File fileM13780c = C3460d.m13780c(this, str);
        if (fileM13780c != null) {
            m15939a(Uri.fromFile(fileM13780c), false);
        }
        this.f15031bh = true;
        this.f15030bg = str;
    }

    @Override // com.sec.chaton.smsplugin.multimedia.emoticon.InterfaceC3922b
    /* renamed from: a */
    public void mo15133a(String str, String str2) {
        m15995ag();
        m15895N();
        File fileM13780c = C3460d.m13780c(this, str);
        if (fileM13780c != null) {
            m15939a(Uri.fromFile(fileM13780c), false);
        }
        int length = C1427a.f5063a.split("[.]").length;
        if (!TextUtils.isEmpty(str2)) {
            if (length == 3) {
                this.f15045bv = "http://m.chaton.com/s/" + str2;
            } else {
                this.f15045bv = "http://stg.m.chaton.com/s/" + str2;
            }
        }
        this.f15031bh = true;
        this.f15030bg = str;
    }

    /* renamed from: am */
    private void m16007am() {
        this.f14970aP = C4809aa.m18104a().m18121a("setting_change_skin", "-1");
        this.f14971aQ = C4809aa.m18104a().m18121a("setting_change_skin_type", "pa");
        this.f14972aR = C4809aa.m18104a().m18121a("Default Font Size", "");
        this.f14973aS = C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1");
        this.f14974aT = C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1");
        m16127i();
        if (C4904y.f17872b) {
            C4904y.m18639b("Preference information for chat room.", "Mms/compose");
            C4904y.m18639b(" > Skin Id: " + this.f14970aP, "Mms/compose");
            C4904y.m18639b(" > Font Size: " + this.f14972aR, "Mms/compose");
            C4904y.m18639b(" > Send Bubble: " + this.f14973aS, "Mms/compose");
            C4904y.m18639b(" > Receive Bubble: " + this.f14974aT, "Mms/compose");
        }
    }

    /* renamed from: i */
    public void m16127i() {
        if (this.f14970aP.equals("skin_01")) {
            this.f14970aP = "-1";
        } else if (this.f14970aP.equals("skin_bg_02")) {
            this.f14970aP = "-2";
        } else if (this.f14970aP.equals("skin_bg_03")) {
            this.f14970aP = "-3";
        } else if (this.f14970aP.equals("skin_bg_04")) {
            this.f14970aP = "-4";
        } else if (this.f14970aP.equals("skin_bg_05")) {
            this.f14970aP = "-5";
        }
        if (this.f14973aS.equals("bubble_01")) {
            this.f14973aS = "-1";
        } else if (this.f14973aS.equals("bubble_02")) {
            this.f14973aS = "-2";
        } else if (this.f14973aS.equals("bubble_03")) {
            this.f14973aS = "-3";
        } else if (this.f14973aS.equals("bubble_04")) {
            this.f14973aS = "-4";
        } else if (this.f14973aS.equals("bubble_05")) {
            this.f14973aS = "-5";
        }
        if (this.f14974aT.equals("bubble_01")) {
            this.f14974aT = "-1";
            return;
        }
        if (this.f14974aT.equals("bubble_02")) {
            this.f14974aT = "-2";
            return;
        }
        if (this.f14974aT.equals("bubble_03")) {
            this.f14974aT = "-3";
        } else if (this.f14974aT.equals("bubble_04")) {
            this.f14974aT = "-4";
        } else if (this.f14974aT.equals("bubble_05")) {
            this.f14974aT = "-5";
        }
    }

    /* renamed from: an */
    private void m16010an() {
        if (this.f15053v == null) {
            m16011ao();
        } else {
            if (this.f15053v.equals(this.f14970aP)) {
                if (GlobalApplication.m10286e()) {
                    m16013ap();
                    m16011ao();
                    return;
                }
                return;
            }
            m16013ap();
            m16011ao();
        }
        this.f15053v = this.f14970aP;
    }

    /* renamed from: ao */
    private void m16011ao() {
        this.f14969aO = C1735gh.m8610a(getResources().getConfiguration().orientation, this.f14970aP);
        if (this.f14969aO != null) {
            if (this.f14971aQ.equals("pa")) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f14969aO);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                this.f14968aN.setBackgroundDrawable(bitmapDrawable);
                return;
            }
            this.f14968aN.setImageBitmap(this.f14969aO);
            return;
        }
        m16128j();
    }

    /* renamed from: j */
    public void m16128j() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f14968aN.setBackgroundDrawable(bitmapDrawable);
    }

    /* renamed from: ap */
    private void m16013ap() {
        if (this.f14969aO != null) {
            this.f14968aN.setImageBitmap(null);
            this.f14969aO = null;
        }
    }

    /* renamed from: k */
    public void m16129k() {
        this.f14975aU = true;
        m16131m();
        this.f14940L.setVisibility(8);
        this.f14944P.setVisibility(8);
        this.f14978aX.setGroupVisible(R.id.composer_menu_group, false);
        this.f14978aX.setGroupVisible(R.id.composer_menu_group_delete, true);
        this.f14976aV.setVisibility(0);
        this.f14976aV.setOnClickListener(new ViewOnClickListenerC4230fd(this));
        this.f14977aW.setVisibility(0);
        this.f14977aW.setChecked(false);
        this.f15050p.m16333b(this.f14975aU);
        this.f14953Y.clearChoices();
        this.f14953Y.setChoiceMode(2);
        this.f14953Y.setOnCreateContextMenuListener(null);
        this.f14953Y.requestLayout();
        invalidateOptionsMenu();
    }

    /* renamed from: a */
    public void m16119a(MessageListItem messageListItem, C4108aq c4108aq) {
        if (this.f14975aU) {
            messageListItem.setCheckBox(0, this.f15050p.m16334b(c4108aq.f15268c, c4108aq.f15267b));
            if (this.f15050p.m16335c() == this.f15050p.getCount()) {
                this.f14977aW.setChecked(true);
            } else {
                this.f14977aW.setChecked(false);
            }
            this.f14977aW.invalidate();
            invalidateOptionsMenu();
        }
    }

    /* renamed from: l */
    public void m16130l() {
        if (this.f14975aU) {
            this.f14975aU = false;
        }
        m16133o();
        this.f14940L.setVisibility(0);
        if (this.f14943O.length() > 0) {
            this.f14944P.setVisibility(0);
        }
        this.f14978aX.setGroupVisible(R.id.chat_menu_group, true);
        this.f14978aX.setGroupVisible(R.id.chat_menu_group_delete, false);
        this.f14976aV.setVisibility(8);
        this.f14977aW.setVisibility(8);
        this.f15050p.m16333b(this.f14975aU);
        this.f14953Y.setChoiceMode(0);
        this.f14953Y.setOnCreateContextMenuListener(this.f15010bD);
        this.f14953Y.setOnItemClickListener(new C4231fe(this));
        this.f14953Y.requestLayout();
        invalidateOptionsMenu();
    }

    /* renamed from: b */
    public void m16120b(boolean z) {
        this.f14977aW.setChecked(z);
    }

    /* renamed from: m */
    public void m16131m() {
        if (C4822an.m18218a()) {
            this.f15024ba.setText(R.string.chat_view_menu_delete_chats);
        } else {
            this.f15024ba.setText(R.string.chat_view_menu_delete_message);
        }
        this.f15025bb.setVisibility(8);
        this.f14980aZ.invalidate();
    }

    /* renamed from: n */
    public void m16132n() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        if (this.f14979aY == null) {
            this.f14979aY = layoutInflaterFrom.inflate(R.layout.actionbar_custom_layout_chatroom, (ViewGroup) null, false);
        }
        if (this.f15024ba == null) {
            this.f15024ba = (TextView) this.f14979aY.findViewById(R.id.chatroom_custom_title);
        }
        if (this.f14980aZ == null) {
            this.f14980aZ = (LinearLayout) this.f14979aY.findViewById(R.id.chatroom_custom_layout);
            this.f14980aZ.setFocusable(true);
            this.f14980aZ.setPadding(3, 0, 0, 0);
            this.f14980aZ.setOnClickListener(new ViewOnClickListenerC4232ff(this));
        }
        if (this.f15025bb == null) {
            this.f15025bb = (ViewGroup) this.f14979aY.findViewById(R.id.subtitle_group);
        }
        if (this.f15026bc == null) {
            this.f15026bc = (TextView) this.f14979aY.findViewById(R.id.chatroom_custom_sub_title);
        }
        if (this.f15027bd == null) {
            this.f15027bd = (ImageView) this.f14979aY.findViewById(R.id.title_alert_off_indicator);
        }
    }

    /* renamed from: o */
    public void m16133o() {
        getActionBar().setCustomView(this.f14979aY);
        getActionBar().setDisplayOptions(23);
        C3789h c3789hM16168a = m15878E() ? this.f14954Z.m16168a(false) : m16107v();
        if (!m15977aD()) {
            new C4264gk(this, this.f15048by, c3789hM16168a).start();
        } else {
            m16053d(this.f14933E);
        }
    }

    /* renamed from: b */
    private boolean m16034b(C3782a c3782a) {
        if (c3782a == null || TextUtils.isEmpty(c3782a.m14269k()) || c3782a.m14270l() == 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static void m15963a(DialogInterfaceOnClickListenerC4254ga dialogInterfaceOnClickListenerC4254ga, Collection<Long> collection, boolean z, Context context) {
        View viewInflate = View.inflate(context, R.layout.delete_thread_dialog_view, null);
        ((TextView) viewInflate.findViewById(R.id.message)).setText(R.string.chatroom_deleted_message);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.delete_locked);
        checkBox.setText(R.string.delete_unlocked);
        if (!z) {
            checkBox.setVisibility(8);
        } else {
            checkBox.setVisibility(0);
            dialogInterfaceOnClickListenerC4254ga.m16469a(checkBox.isChecked());
            checkBox.setOnClickListener(new ViewOnClickListenerC4234fh(dialogInterfaceOnClickListenerC4254ga, checkBox));
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18734a(R.string.delete);
        abstractC4932aM18733a.mo18748b(viewInflate);
        abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, dialogInterfaceOnClickListenerC4254ga);
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: c */
    void m16123c(boolean z) throws IOException {
        boolean z2 = false;
        if (1 == Settings.System.getInt(getContentResolver(), "airplane_mode_on", 0)) {
            C3890m.m14996b("Mms/compose", "networkWarningDialogAndSend : AIRPLANE_MODE_ON = true");
            z2 = true;
        } else if (!z) {
            if (!C3895r.m15038a(this, true)) {
                z2 = true;
            }
        } else if (!C3895r.m15038a(this, false)) {
            z2 = true;
        }
        if (z2) {
            m16014aq();
        } else {
            m16102s();
        }
    }

    /* renamed from: aq */
    private void m16014aq() {
        if (this.f15000at == null) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
            abstractC4932aM18733a.mo18753c(android.R.drawable.ic_dialog_alert);
            abstractC4932aM18733a.mo18734a(R.string.pop_up_attention);
            abstractC4932aM18733a.mo18746b(R.string.provision_no_signal);
            abstractC4932aM18733a.mo18756d(R.string.ok, new DialogInterfaceOnClickListenerC4236fj(this));
            this.f15000at = abstractC4932aM18733a.mo18745a();
        }
        this.f15000at.show();
    }

    /* renamed from: f */
    private synchronized void m16068f(long j) {
        if (this.f15032bi == null) {
            this.f15032bi = (Vibrator) getSystemService("vibrator");
            this.f15032bi.vibrate(j);
        }
        this.f15032bi.vibrate(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ar */
    public void m16015ar() {
        String strM16022ay = m16022ay();
        if (TextUtils.isEmpty(strM16022ay)) {
            C3890m.m14996b("Mms/compose", "[SpamWarning] showUnknownTab. Invalid unknownNumber.");
            return;
        }
        this.f14982ab.setVisibility(0);
        this.f14983ac.setVisibility(0);
        if (C4149cd.m16431d(this, strM16022ay)) {
            this.f14984ad.setVisibility(8);
            this.f14987ag.setVisibility(0);
            this.f14988ah.setOnClickListener(new ViewOnClickListenerC4237fk(this));
            return;
        }
        this.f14984ad.setVisibility(0);
        this.f14987ag.setVisibility(8);
        this.f14985ae.setOnClickListener(new ViewOnClickListenerC4238fl(this));
        this.f14986af.setOnClickListener(new ViewOnClickListenerC4239fm(this));
        if (!m16019av()) {
            Spam spam = new Spam();
            spam.setCat(Spam.CATEGORY_DEFAULT).setAct(Spam.ACTIVITY_CHECK);
            spam.setNum(strM16022ay);
            spam.setMsg("");
            SetSpamReq setSpamReq = new SetSpamReq();
            setSpamReq.setMsisdn(m16023az()).setImei(C4822an.m18228d()).setImsi(C4822an.m18238h());
            setSpamReq.setSpam(spam);
            new Thread(new C3033b(C4865cc.m18450b(EnumC4868cf.CONTACT), 34078720, setSpamReq, this.f14930B)).start();
            m16020aw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: as */
    public void m16016as() {
        this.f14982ab.setVisibility(8);
        this.f14983ac.setVisibility(8);
        this.f14984ad.setVisibility(8);
        this.f14987ag.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m16076g(long j) throws Resources.NotFoundException {
        String string;
        String strM16022ay = m16022ay();
        if (TextUtils.isEmpty(strM16022ay)) {
            C3890m.m14996b("Mms/compose", "[SpamWarning] showSpamWarningStampWithCheckResult. Invalid unknownNumber.");
            return;
        }
        this.f14989ai.setVisibility(0);
        if (j > 0) {
            string = getResources().getString(R.string.spam_check_result, PhoneNumberUtils.formatNumber(strM16022ay), Long.valueOf(j));
        } else {
            string = getResources().getString(R.string.spam_warning, PhoneNumberUtils.formatNumber(strM16022ay));
        }
        this.f14990aj.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: at */
    public void m16017at() {
        String strM16022ay = m16022ay();
        if (TextUtils.isEmpty(strM16022ay)) {
            C3890m.m14996b("Mms/compose", "[SpamWarning] showSpamWarningStamp. Invalid unknownNumber.");
        } else {
            this.f14989ai.setVisibility(0);
            this.f14990aj.setText(getResources().getString(R.string.spam_warning, PhoneNumberUtils.formatNumber(strM16022ay)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: au */
    public void m16018au() {
        this.f14989ai.setVisibility(8);
    }

    /* renamed from: av */
    private boolean m16019av() {
        if (this.f14989ai.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aw */
    public void m16020aw() {
        this.f14991ak.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ax */
    public void m16021ax() {
        this.f14991ak.setVisibility(8);
    }

    /* renamed from: d */
    public void m16124d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", str);
        bundle.putString("name", null);
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtras(bundle);
        intent.putExtra("return-data", true);
        try {
            startActivityForResult(intent, 108);
        } catch (ActivityNotFoundException e) {
            C4904y.m18635a(e, "Mms/compose");
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_contact_not_found, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m16079g(String str) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        abstractC4932aM18733a.mo18734a(R.string.alert_inform).mo18749b(getString(R.string.messaging_info_sync_contact, new Object[]{str})).mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC4241fo(this)).mo18747b(R.string.alert_dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m16083h(String str) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
        abstractC4932aM18733a.mo18734a(R.string.menu_register_as_spamnumber).mo18746b(R.string.dialog_body_confirm_add_to_spam).mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC4242fp(this, str)).mo18747b(R.string.alert_dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ay */
    public String m16022ay() {
        if (m16107v().size() == 1) {
            C3782a c3782a = m16107v().get(0);
            if (TextUtils.isEmpty(c3782a.m14269k()) && !TextUtils.isEmpty(c3782a.m14262d())) {
                return c3782a.m14262d();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* renamed from: az */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m16023az() throws android.content.res.Resources.NotFoundException {
        /*
            r9 = this;
            java.lang.String r2 = com.sec.chaton.util.C4822an.m18234f()
            com.sec.chaton.util.ab r0 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r1 = "country_code"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.m18121a(r1, r3)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto La6
            com.sec.chaton.util.ab r0 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r3 = "country_ISO"
            r4 = 0
            java.lang.String r0 = r0.m18121a(r3, r4)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L2e
            java.lang.String r0 = com.sec.chaton.util.C4822an.m18236g()
        L2e:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto La6
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            android.content.res.Resources r1 = r9.getResources()
            r4 = 2131558429(0x7f0d001d, float:1.8742174E38)
            java.lang.CharSequence[] r4 = r1.getTextArray(r4)
            android.content.res.Resources r1 = r9.getResources()
            r5 = 2131558430(0x7f0d001e, float:1.8742176E38)
            java.lang.CharSequence[] r5 = r1.getTextArray(r5)
            android.content.res.Resources r1 = r9.getResources()
            r6 = 2131558431(0x7f0d001f, float:1.8742178E38)
            java.lang.CharSequence[] r6 = r1.getTextArray(r6)
            r1 = 0
        L5b:
            int r7 = r4.length
            if (r1 >= r7) goto L68
            r7 = r6[r1]
            r8 = r5[r1]
            r3.put(r7, r8)
            int r1 = r1 + 1
            goto L5b
        L68:
            java.lang.String r0 = r0.toUpperCase()
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L74:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto La4
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto La4
            boolean r1 = r2.contains(r0)
            if (r1 != 0) goto La4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "+"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 1
            java.lang.String r1 = r2.substring(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        La3:
            return r0
        La4:
            r0 = r2
            goto La3
        La6:
            r0 = r1
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity.m16023az():java.lang.String");
    }

    /* renamed from: a */
    private static boolean m15971a(C3789h c3789h) {
        if (c3789h == null) {
            return false;
        }
        Iterator<C3782a> it = c3789h.iterator();
        while (it.hasNext()) {
            String strStripSeparators = PhoneNumberUtils.stripSeparators(it.next().m14262d());
            if (strStripSeparators.length() == 0) {
                return false;
            }
            String strM14307c = C3789h.m14307c(strStripSeparators);
            if (strM14307c.length() == 0) {
                return false;
            }
            for (int i = 0; i < strM14307c.length(); i++) {
                if (!PhoneNumberUtils.isDialable(strM14307c.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aA */
    public boolean m15974aA() {
        if (C4873ck.m18504e()) {
            return true;
        }
        AbstractC4932a.m18733a(this).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aB */
    public void m15975aB() {
        m18784t().mo18835e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aC */
    public void m15976aC() {
        m18784t().mo18837f();
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4174db
    /* renamed from: c */
    public void mo16122c() {
        this.f15041br.hideSoftInputFromWindow(this.f14943O.getWindowToken(), 0);
        m15975aB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aD */
    public boolean m15977aD() {
        return this.f14994an;
    }

    /* renamed from: aE */
    private void m15978aE() {
        this.f14940L.setVisibility(8);
        this.f14944P.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m16040c(int i) {
        switch (i) {
            case 100:
                return GlobalApplication.m10279a().getString(R.string.cmas_presidential_alerts);
            case 101:
                return GlobalApplication.m10279a().getString(R.string.cmas_extreme_alerts);
            case 102:
                return GlobalApplication.m10279a().getString(R.string.cmas_severe_alerts);
            case 103:
                return GlobalApplication.m10279a().getString(R.string.cmas_amber_alerts);
            case 104:
                return GlobalApplication.m10279a().getString(R.string.cmas_test_message_alerts);
            default:
                return GlobalApplication.m10279a().getString(R.string.cmas_all_in_one_message_thread_alerts);
        }
    }

    /* renamed from: d */
    private void m16053d(int i) {
        if (this.f14994an) {
            this.f15024ba.setText(m16040c(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15937a(Cursor cursor) {
        cursor.moveToFirst();
        C3890m.m14996b("Mms/compose", "CMASMoreInfoSetData");
        long j = cursor.getLong(cursor.getColumnIndex("sms_id"));
        int i = cursor.getInt(cursor.getColumnIndex("category"));
        int i2 = cursor.getInt(cursor.getColumnIndex("severity"));
        int i3 = cursor.getInt(cursor.getColumnIndex("urgency"));
        int i4 = cursor.getInt(cursor.getColumnIndex("certainty"));
        int i5 = cursor.getInt(cursor.getColumnIndex("thread_id"));
        String strM16393a = C4149cd.m16393a(getApplicationContext(), cursor.getLong(cursor.getColumnIndex("expires")));
        C3890m.m14996b("Mms/compose", "msgId = " + j + "string format" + String.valueOf(j));
        C3890m.m14996b("Mms/compose", "msgText " + i5 + " msgCategory " + i + " msgDate " + strM16393a + " msgSeverity " + i2 + " msgCertainity " + i4 + "msgUrgency " + i3);
        switch (i2) {
            case 0:
                this.f14932D += "\n" + getResources().getString(R.string.cmas_severity) + getResources().getString(R.string.cmas_servity_extreme);
                break;
            case 1:
                this.f14932D += "\n" + getResources().getString(R.string.cmas_severity) + getResources().getString(R.string.cmas_servity_serve);
                break;
        }
        switch (i3) {
            case 0:
                this.f14932D += "\n" + getResources().getString(R.string.cmas_urgency) + getResources().getString(R.string.cmas_urgency_immediate);
                break;
            case 1:
                this.f14932D += "\n" + getResources().getString(R.string.cmas_urgency) + getResources().getString(R.string.cmas_urgency_expected);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15960a(C4108aq c4108aq, C3790i c3790i, boolean z) {
        if (c4108aq != null && !c4108aq.f15277l.isEmpty()) {
            AbstractC4932a.m18733a(this).mo18740a(getResources().getString(R.string.message_details)).mo18749b(this.f14932D).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC4243fq(this)).mo18751b(false).mo18745a().show();
        }
        this.f14932D = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16025b(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    /* renamed from: aF */
    private void m15979aF() {
        this.f14953Y.setAdapter((ListAdapter) this.f15050p);
        this.f14953Y.setSelection(this.f14953Y.getCount());
    }

    /* renamed from: aG */
    private void m15980aG() {
        m16013ap();
        m16011ao();
    }

    /* renamed from: a */
    private void m15938a(Uri uri, String str, String str2) {
        Intent intentM2921a;
        if (uri == null) {
            C3890m.m14996b("Mms/compose", "[Large file] sending-message URI is invalid");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C3890m.m14996b("Mms/compose", "[Large file] file path is invalid");
            return;
        }
        long id = ContentUris.parseId(uri);
        Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) HugeFileUploadService.class);
        intent.putExtra("huge_file_request_id", id);
        intent.putExtra("huge_file_from_chat", false);
        intent.putExtra("inboxNO", String.valueOf(this.f14935G.m14359d()));
        intent.putExtra("chatType", m16107v().size() > 1 ? EnumC2300t.BROADCAST2.m10210a() : EnumC2300t.ONETOONE.m10210a());
        intent.setData(Uri.parse(str));
        if (TextUtils.isEmpty(str2)) {
            intentM2921a = m15925a((Context) this, this.f14935G.m14359d());
        } else {
            intentM2921a = IntentControllerActivity.m2921a(CommonApplication.m18732r(), 1);
            intentM2921a.putExtra("callChatList", true);
            intentM2921a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
            intentM2921a.putExtra("buddyNO", str2);
            intentM2921a.putExtra("roomType", EnumC2301u.NORMAL.m10212a());
        }
        intent.putExtra("huge_file_pending_intent", PendingIntent.getActivity(GlobalApplication.m18732r(), 0, intentM2921a, 134217728));
        GlobalApplication.m18732r().startService(intent);
    }

    /* renamed from: aH */
    private void m15981aH() throws IOException {
        if (C2471v.m10677a(this) != 0 && !C4809aa.m18104a().m18119a("pref_key_do_not_show_mobile_network_charge_to_send_large_file", (Boolean) false).booleanValue()) {
            Resources resources = getResources();
            m15968a(resources.getString(R.string.hugefile_sending_file), resources.getString(R.string.hugefile_waring_message), resources.getString(R.string.large_file_do_not_show_again), 7002);
        } else {
            m15982aI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aI */
    public void m15982aI() throws IOException {
        String strM14472v = this.f14996ap.m14472v();
        if (TextUtils.isEmpty(strM14472v)) {
            C3890m.m14996b("Mms/compose", "Large file path is invalid");
            return;
        }
        this.f14996ap.m14442a(false);
        this.f14996ap.m14438a((CharSequence) String.format("[%s]\n%s (%.1f MB)\n%s", getString(R.string.hugefile_large_file), new File(strM14472v).getName(), Float.valueOf(r1.length() / 1048576.0f), CommonApplication.m18732r().getString(R.string.hugefile_sending_message)));
        this.f14996ap.m14449b(true, true);
        m16090j(true);
    }

    /* renamed from: a */
    protected void m16117a(int i, int i2, Cursor cursor) {
        if (i2 == 0) {
            return;
        }
        if (this.f15022bT != -1 && !TextUtils.isEmpty(this.f15023bU)) {
            cursor.moveToPosition(-1);
            while (true) {
                if (!cursor.moveToNext()) {
                    break;
                }
                if (cursor.getLong(1) == this.f15022bT && this.f15023bU.equals(cursor.getString(0))) {
                    this.f15050p.m16325a(cursor.getPosition(), false);
                    break;
                }
            }
            this.f15022bT = -1L;
            this.f15023bU = "";
            return;
        }
        if (i < i2) {
            this.f15050p.m16325a(i2 - 1, true);
        }
    }

    /* renamed from: b */
    protected boolean m16121b(Intent intent) {
        if (!C4822an.m18218a() && C3892o.m15020a(intent) && !C4822an.m18201K()) {
            startActivity(BootstrapActivity.m2877a(this, 2));
            finish();
            return true;
        }
        if (!C4822an.m18223b() && C2349a.m10301a("sms_feature")) {
            if (C3847e.m14686ar()) {
                Intent intentM15026c = C3892o.m15026c();
                if (intentM15026c != null) {
                    startActivity(intentM15026c);
                    C3892o.m15031e();
                }
            } else if (!C4822an.m18226c()) {
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
                abstractC4932aM18733a.mo18734a(R.string.pop_up_attention).mo18749b(getResources().getString(R.string.sms_function_alert_notice)).mo18742a(true).mo18751b(true).mo18756d(R.string.popup_button_enable, new DialogInterfaceOnClickListenerC4247fu(this)).mo18754c(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4245fs(this));
                abstractC4932aM18733a.mo18745a().show();
            }
        }
        return false;
    }
}
