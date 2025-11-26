package com.sec.chaton.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteException;
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
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Vibrator;
import android.sec.multiwindow.MultiWindowManager;
import android.support.v4.app.C0014a;
import android.support.v4.app.Fragment;
import android.support.v4.content.C0096i;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1009ah;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.chat.p054a.AbstractC1506a;
import com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah;
import com.sec.chaton.chat.p054a.C1536i;
import com.sec.chaton.chat.p054a.InterfaceC1541n;
import com.sec.chaton.chat.p054a.InterfaceC1542o;
import com.sec.chaton.chat.p054a.InterfaceC1543p;
import com.sec.chaton.chat.p054a.InterfaceC1544q;
import com.sec.chaton.chat.p054a.InterfaceC1545r;
import com.sec.chaton.chat.p054a.InterfaceC1547t;
import com.sec.chaton.chat.p054a.InterfaceC1548u;
import com.sec.chaton.chat.p054a.InterfaceC1549v;
import com.sec.chaton.chat.translate.C1849b;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.chat.translate.C1856i;
import com.sec.chaton.chat.translate.C1865r;
import com.sec.chaton.chat.translate.TranslatorActivity;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.hugefiletransfer.AsyncTaskC2389c;
import com.sec.chaton.msgbox.C2608a;
import com.sec.chaton.msgbox.C2660e;
import com.sec.chaton.msgbox.C2679x;
import com.sec.chaton.msgbox.C2680y;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.multimedia.audio.C2723a;
import com.sec.chaton.multimedia.audio.C2726b;
import com.sec.chaton.multimedia.audio.DialogC2747w;
import com.sec.chaton.multimedia.doc.EnumC2758b;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.multimedia.emoticon.EmoticonSelectionView;
import com.sec.chaton.multimedia.emoticon.InterfaceC2798j;
import com.sec.chaton.multimedia.emoticon.anicon.C2780l;
import com.sec.chaton.multimedia.emoticon.p080a.EnumC2768a;
import com.sec.chaton.multimedia.geotag.GeotagActivity;
import com.sec.chaton.multimedia.image.C2815a;
import com.sec.chaton.multimedia.image.C2844d;
import com.sec.chaton.multimedia.image.ImagePagerActivity;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.multimedia.p078a.C2722d;
import com.sec.chaton.multimedia.p078a.DialogC2719a;
import com.sec.chaton.multimedia.p079b.AsyncTaskC2754d;
import com.sec.chaton.multimedia.p079b.C2756f;
import com.sec.chaton.multimedia.text.DetailTextView;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcalendar.VCalendarListActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.multimedia.vcard.VCardReadContactActivity;
import com.sec.chaton.p046a.p047a.C0777a;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p049b.ContextMenuC1056a;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.AbstractC2070ac;
import com.sec.chaton.p055d.C2098bd;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p055d.C2136q;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p055d.p056a.C1998dq;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2302v;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2216ad;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p060f.C2337g;
import com.sec.chaton.p060f.DialogC2331a;
import com.sec.chaton.p060f.InterfaceC2336f;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.p065io.entry.InboxExtraEntry;
import com.sec.chaton.p065io.entry.MessageType4Entry;
import com.sec.chaton.p065io.entry.inner.TopicChatType;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.p070c.AsyncTaskC2436c;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.settings.ActivityChat;
import com.sec.chaton.settings.EnumC3594ed;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.C3471o;
import com.sec.chaton.settings.p096a.EnumC3465i;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.C4110as;
import com.sec.chaton.smsplugin.p112ui.MessageListItem;
import com.sec.chaton.smsplugin.provider.C3942a;
import com.sec.chaton.smsplugin.provider.C3960r;
import com.sec.chaton.smsplugin.provider.C3961s;
import com.sec.chaton.smsplugin.transaction.BackgroundSenderService;
import com.sec.chaton.smsplugin.transaction.SmsReceiverService;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.trunk.TrunkActivity;
import com.sec.chaton.trunk.p118a.C4565a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4825aq;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4887j;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4899t;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.chaton.util.EnumC4900u;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5047m;
import com.sec.common.util.C5052r;
import com.sec.common.util.log.collector.C5043h;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5103z;
import com.sec.google.android.p134a.p136b.C5108d;
import com.sec.spp.push.Config;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import com.sec.widget.HeightChangedListView;
import com.sec.widget.InterfaceC5181x;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Timer;
import org.json.JSONException;
import org.p138a.p139a.p140a.p141a.C5214j;

/* loaded from: classes.dex */
public class ChatFragment extends Fragment implements MediaPlayer.OnCompletionListener, View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC1061c, InterfaceC1762hh, InterfaceC1773hs, InterfaceC1786ie, InterfaceC2336f, InterfaceC2798j, InterfaceC5181x {

    /* renamed from: P */
    public static String f5459P;

    /* renamed from: Q */
    public static String f5460Q;

    /* renamed from: E */
    String f5488E;

    /* renamed from: F */
    int f5489F;

    /* renamed from: G */
    String f5490G;

    /* renamed from: I */
    public ProgressDialog f5492I;

    /* renamed from: J */
    public ProgressDialog f5493J;

    /* renamed from: M */
    public boolean f5496M;

    /* renamed from: N */
    DialogC2331a f5497N;

    /* renamed from: O */
    ArrayList<C2337g> f5498O;

    /* renamed from: S */
    C2608a f5500S;

    /* renamed from: aA */
    private boolean f5508aA;

    /* renamed from: aC */
    private String f5510aC;

    /* renamed from: aD */
    private String f5511aD;

    /* renamed from: aE */
    private String f5512aE;

    /* renamed from: aF */
    private DialogC2747w f5513aF;

    /* renamed from: aG */
    private C1669dw f5514aG;

    /* renamed from: aH */
    private ImageButton f5515aH;

    /* renamed from: aI */
    private ImageButton f5516aI;

    /* renamed from: aJ */
    private CheckedTextView f5517aJ;

    /* renamed from: aK */
    private FrameLayout f5518aK;

    /* renamed from: aL */
    private FrameLayout f5519aL;

    /* renamed from: aM */
    private ViewGroup f5520aM;

    /* renamed from: aN */
    private LinearLayout f5521aN;

    /* renamed from: aO */
    private LinearLayout f5522aO;

    /* renamed from: aP */
    private LinearLayout f5523aP;

    /* renamed from: aQ */
    private LinearLayout f5524aQ;

    /* renamed from: aR */
    private TextView f5525aR;

    /* renamed from: aS */
    private LinearLayout f5526aS;

    /* renamed from: aT */
    private HeightChangedListView f5527aT;

    /* renamed from: aU */
    private C1723fw f5528aU;

    /* renamed from: aV */
    private Toast f5529aV;

    /* renamed from: aX */
    private AbstractC2070ac f5531aX;

    /* renamed from: aY */
    private C4565a f5532aY;

    /* renamed from: ao */
    private C2210x f5546ao;

    /* renamed from: ap */
    private Menu f5547ap;

    /* renamed from: ar */
    private C0416a f5549ar;

    /* renamed from: aw */
    private LinearLayout f5554aw;

    /* renamed from: ax */
    private ImageView f5555ax;

    /* renamed from: ay */
    private ImageView f5556ay;

    /* renamed from: az */
    private ImageButton f5557az;

    /* renamed from: b */
    View f5558b;

    /* renamed from: bA */
    private Uri f5559bA;

    /* renamed from: bB */
    private boolean f5560bB;

    /* renamed from: bC */
    private boolean f5561bC;

    /* renamed from: bD */
    private long f5562bD;

    /* renamed from: bE */
    private boolean f5563bE;

    /* renamed from: bF */
    private MyEditText f5564bF;

    /* renamed from: bG */
    private String f5565bG;

    /* renamed from: bH */
    private ImageView f5566bH;

    /* renamed from: bI */
    private String f5567bI;

    /* renamed from: bJ */
    private String f5568bJ;

    /* renamed from: bK */
    private String f5569bK;

    /* renamed from: bL */
    private String f5570bL;

    /* renamed from: bM */
    private String f5571bM;

    /* renamed from: bN */
    private boolean f5572bN;

    /* renamed from: bO */
    private boolean f5573bO;

    /* renamed from: bP */
    private int f5574bP;

    /* renamed from: bQ */
    private String f5575bQ;

    /* renamed from: bR */
    private String f5576bR;

    /* renamed from: bS */
    private String f5577bS;

    /* renamed from: bT */
    private boolean f5578bT;

    /* renamed from: bU */
    private String f5579bU;

    /* renamed from: bd */
    private ArrayList<String> f5588bd;

    /* renamed from: be */
    private ArrayList<String> f5589be;

    /* renamed from: bf */
    private ArrayList<String> f5590bf;

    /* renamed from: bg */
    private HashMap<String, C0777a> f5591bg;

    /* renamed from: bh */
    private ArrayList<C0777a> f5592bh;

    /* renamed from: bi */
    private Long f5593bi;

    /* renamed from: bj */
    private String f5594bj;

    /* renamed from: bk */
    private String f5595bk;

    /* renamed from: bl */
    private String f5596bl;

    /* renamed from: bm */
    private String f5597bm;

    /* renamed from: bn */
    private String f5598bn;

    /* renamed from: bo */
    private String f5599bo;

    /* renamed from: bp */
    private String f5600bp;

    /* renamed from: bq */
    private String f5601bq;

    /* renamed from: bt */
    private TopicChatType f5604bt;

    /* renamed from: bu */
    private int f5605bu;

    /* renamed from: bv */
    private int f5606bv;

    /* renamed from: bw */
    private int f5607bw;

    /* renamed from: by */
    private String f5609by;

    /* renamed from: bz */
    private int f5610bz;

    /* renamed from: cA */
    private LinearLayout f5611cA;

    /* renamed from: cB */
    private C1779hy f5612cB;

    /* renamed from: cD */
    private DataSetObserver f5614cD;

    /* renamed from: cE */
    private C2723a f5615cE;

    /* renamed from: cH */
    private LinearLayout f5618cH;

    /* renamed from: cI */
    private ImageView f5619cI;

    /* renamed from: cJ */
    private TextView f5620cJ;

    /* renamed from: cK */
    private Dialog f5621cK;

    /* renamed from: cL */
    private C5214j<EnumC2214ab, AbstractC1506a> f5622cL;

    /* renamed from: cM */
    private ArrayList<PreviewData> f5623cM;

    /* renamed from: cN */
    private Activity f5624cN;

    /* renamed from: cO */
    private boolean f5625cO;

    /* renamed from: cP */
    private String f5626cP;

    /* renamed from: cT */
    private View.OnDragListener f5630cT;

    /* renamed from: cU */
    private View.OnDragListener f5631cU;

    /* renamed from: cV */
    private int f5632cV;

    /* renamed from: cW */
    private String f5633cW;

    /* renamed from: cc */
    private Bitmap f5639cc;

    /* renamed from: ce */
    private ImageButton f5641ce;

    /* renamed from: cf */
    private ImageButton f5642cf;

    /* renamed from: cg */
    private InputMethodManager f5643cg;

    /* renamed from: ch */
    private ImageView f5644ch;

    /* renamed from: ci */
    private ViewGroup f5645ci;

    /* renamed from: cj */
    private EmoticonSelectionView f5646cj;

    /* renamed from: ck */
    private Bundle f5647ck;

    /* renamed from: cl */
    private int f5648cl;

    /* renamed from: cm */
    private AbstractC4932a f5649cm;

    /* renamed from: cn */
    private View f5650cn;

    /* renamed from: cv */
    private String f5658cv;

    /* renamed from: cw */
    private C5007c f5659cw;

    /* renamed from: cx */
    private AlertDialogC4916i f5660cx;

    /* renamed from: cy */
    private Intent f5661cy;

    /* renamed from: cz */
    private ImageButton f5662cz;

    /* renamed from: dA */
    private View f5663dA;

    /* renamed from: dH */
    private C1743gp f5669dH;

    /* renamed from: dJ */
    private RelativeLayout f5671dJ;

    /* renamed from: dK */
    private boolean f5672dK;

    /* renamed from: dL */
    private SlookAirButton f5673dL;

    /* renamed from: dM */
    private SlookAirButton f5674dM;

    /* renamed from: dN */
    private SlookAirButton f5675dN;

    /* renamed from: dO */
    private AsyncTaskC1687en f5676dO;

    /* renamed from: dP */
    private Bitmap f5677dP;

    /* renamed from: dS */
    private ArrayList<String> f5680dS;

    /* renamed from: dT */
    private ListView f5681dT;

    /* renamed from: dY */
    private DrawerLayout f5686dY;

    /* renamed from: dZ */
    private C0014a f5687dZ;

    /* renamed from: da */
    private View f5688da;

    /* renamed from: db */
    private View f5689db;

    /* renamed from: dc */
    private ImageView f5690dc;

    /* renamed from: dd */
    private ViewGroup f5691dd;

    /* renamed from: de */
    private TextView f5692de;

    /* renamed from: df */
    private TextView f5693df;

    /* renamed from: dg */
    private LinearLayout f5694dg;

    /* renamed from: dh */
    private View f5695dh;

    /* renamed from: di */
    private int f5696di;

    /* renamed from: dn */
    private boolean f5699dn;

    /* renamed from: do */
    private boolean f5700do;

    /* renamed from: dp */
    private ImageView f5701dp;

    /* renamed from: dq */
    private ImageView f5702dq;

    /* renamed from: dr */
    private FrameLayout f5703dr;

    /* renamed from: ds */
    private LinearLayout f5704ds;

    /* renamed from: dt */
    private TextView f5705dt;

    /* renamed from: du */
    private TextView f5706du;

    /* renamed from: dv */
    private FrameLayout f5707dv;

    /* renamed from: dw */
    private LinearLayout f5708dw;

    /* renamed from: dx */
    private TextView f5709dx;

    /* renamed from: dy */
    private TextView f5710dy;

    /* renamed from: dz */
    private View f5711dz;

    /* renamed from: eH */
    private FrameLayout f5719eH;

    /* renamed from: eI */
    private Animation f5720eI;

    /* renamed from: ea */
    private LinearLayout f5722ea;

    /* renamed from: eb */
    private LinearLayout f5723eb;

    /* renamed from: ec */
    private ImageView f5724ec;

    /* renamed from: ed */
    private TextView f5725ed;

    /* renamed from: ee */
    private TextView f5726ee;

    /* renamed from: ef */
    private LinearLayout f5727ef;

    /* renamed from: eg */
    private ImageView f5728eg;

    /* renamed from: eh */
    private WindowManager f5729eh;

    /* renamed from: ei */
    private AsyncTaskC2754d f5730ei;

    /* renamed from: ej */
    private C3790i f5731ej;

    /* renamed from: ek */
    private C3942a f5732ek;

    /* renamed from: el */
    private ContentResolver f5733el;

    /* renamed from: em */
    private C2098bd f5734em;

    /* renamed from: en */
    private C2660e f5735en;

    /* renamed from: es */
    private LinearLayout f5740es;

    /* renamed from: et */
    private LinearLayout f5741et;

    /* renamed from: eu */
    private LinearLayout f5742eu;

    /* renamed from: ev */
    private TextView f5743ev;

    /* renamed from: ew */
    private TextView f5744ew;

    /* renamed from: ex */
    private long f5745ex;

    /* renamed from: ez */
    private C1763hi f5747ez;

    /* renamed from: v */
    public String f5750v;

    /* renamed from: w */
    public String f5751w;

    /* renamed from: x */
    public String f5752x;

    /* renamed from: a */
    public static final String f5461a = ChatFragment.class.getSimpleName();

    /* renamed from: c */
    public static String f5464c = "extra fileuri";

    /* renamed from: d */
    public static String f5465d = "extra participant";

    /* renamed from: e */
    public static String f5469e = "extra title";

    /* renamed from: f */
    public static String f5470f = "extra vcalendar";

    /* renamed from: g */
    public static String f5471g = "extra vard name";

    /* renamed from: h */
    public static String f5472h = "extra initchat";

    /* renamed from: i */
    public static String f5473i = "extra showinput";

    /* renamed from: j */
    public static String f5474j = "extra chagetitle";

    /* renamed from: k */
    public static String f5475k = "extra invite";

    /* renamed from: l */
    public static String f5476l = "extra inbox nobi";

    /* renamed from: m */
    public static String f5477m = "mms image";

    /* renamed from: n */
    public static String f5478n = "mms video";

    /* renamed from: o */
    public static String f5479o = "mms audio";

    /* renamed from: p */
    public static String f5480p = "mms contact";

    /* renamed from: q */
    public static String f5481q = "mms calendar";

    /* renamed from: r */
    public static String f5482r = "mms location";

    /* renamed from: s */
    static boolean f5483s = false;

    /* renamed from: dk */
    private static String f5467dk = "Korean";

    /* renamed from: dl */
    private static String f5468dl = "English US";

    /* renamed from: dE */
    private static String f5466dE = null;

    /* renamed from: al */
    public static boolean f5462al = false;

    /* renamed from: am */
    public static long f5463am = -1;

    /* renamed from: an */
    private final Object f5545an = new Object();

    /* renamed from: aq */
    private boolean f5548aq = false;

    /* renamed from: as */
    private File f5550as = null;

    /* renamed from: at */
    private EnumC2214ab f5551at = null;

    /* renamed from: au */
    private boolean f5552au = false;

    /* renamed from: av */
    private EnumC2768a f5553av = null;

    /* renamed from: aB */
    private boolean f5509aB = false;

    /* renamed from: t */
    public boolean f5748t = false;

    /* renamed from: u */
    public Boolean f5749u = false;

    /* renamed from: aW */
    private ProgressDialog f5530aW = null;

    /* renamed from: aZ */
    private int f5533aZ = 0;

    /* renamed from: ba */
    private String f5585ba = null;

    /* renamed from: bb */
    private String f5586bb = null;

    /* renamed from: bc */
    private boolean f5587bc = false;

    /* renamed from: y */
    public boolean f5753y = true;

    /* renamed from: z */
    public boolean f5754z = false;

    /* renamed from: A */
    public String f5484A = "";

    /* renamed from: B */
    public int f5485B = 0;

    /* renamed from: br */
    private long f5602br = 0;

    /* renamed from: bs */
    private String f5603bs = Spam.ACTIVITY_CANCEL;

    /* renamed from: bx */
    private boolean f5608bx = false;

    /* renamed from: bV */
    private boolean f5580bV = false;

    /* renamed from: bW */
    private boolean f5581bW = false;

    /* renamed from: bX */
    private boolean f5582bX = false;

    /* renamed from: bY */
    private boolean f5583bY = false;

    /* renamed from: bZ */
    private EnumC1094bm f5584bZ = EnumC1094bm.INSIDE;

    /* renamed from: ca */
    private EnumC2301u f5637ca = EnumC2301u.NORMAL;

    /* renamed from: cb */
    private final boolean f5638cb = false;

    /* renamed from: C */
    boolean f5486C = false;

    /* renamed from: D */
    EnumC2300t f5487D = EnumC2300t.UNKNOWN;

    /* renamed from: cd */
    private EnumC1109f f5640cd = EnumC1109f.NONE;

    /* renamed from: H */
    ArrayList<C1106c> f5491H = new ArrayList<>();

    /* renamed from: co */
    private int f5651co = 0;

    /* renamed from: cp */
    private boolean f5652cp = true;

    /* renamed from: cq */
    private int f5653cq = 0;

    /* renamed from: cr */
    private boolean f5654cr = false;

    /* renamed from: cs */
    private final int f5655cs = 20;

    /* renamed from: ct */
    private int f5656ct = 100;

    /* renamed from: cu */
    private boolean f5657cu = true;

    /* renamed from: K */
    InterfaceC4936e f5494K = null;

    /* renamed from: L */
    InterfaceC4936e f5495L = null;

    /* renamed from: cC */
    private boolean f5613cC = false;

    /* renamed from: cF */
    private final String f5616cF = "TRANS_FAIL";

    /* renamed from: cG */
    private final String f5617cG = "RECV_SUCC";

    /* renamed from: cQ */
    private Bitmap f5627cQ = null;

    /* renamed from: cR */
    private final String f5628cR = C4873ck.m18502c() + "/flag/";

    /* renamed from: cS */
    private final int f5629cS = 1;

    /* renamed from: cX */
    private boolean f5634cX = false;

    /* renamed from: cY */
    private boolean f5635cY = false;

    /* renamed from: cZ */
    private boolean f5636cZ = false;

    /* renamed from: dj */
    private boolean f5697dj = false;

    /* renamed from: dm */
    private boolean f5698dm = false;

    /* renamed from: R */
    File f5499R = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile();

    /* renamed from: dB */
    private ProgressDialog f5664dB = null;

    /* renamed from: dC */
    private boolean f5665dC = false;

    /* renamed from: dD */
    private boolean f5666dD = false;

    /* renamed from: dF */
    private boolean f5667dF = false;

    /* renamed from: dG */
    private String f5668dG = null;

    /* renamed from: dI */
    private final ArrayList<String> f5670dI = new ArrayList<>();

    /* renamed from: dQ */
    private boolean f5678dQ = false;

    /* renamed from: dR */
    private C1671dy f5679dR = null;

    /* renamed from: dU */
    private final boolean f5682dU = false;

    /* renamed from: dV */
    private boolean f5683dV = false;

    /* renamed from: dW */
    private final boolean f5684dW = false;

    /* renamed from: dX */
    private final int f5685dX = 100;

    /* renamed from: T */
    boolean f5501T = false;

    /* renamed from: U */
    boolean f5502U = false;

    /* renamed from: eo */
    private Vibrator f5736eo = null;

    /* renamed from: ep */
    private boolean f5737ep = false;

    /* renamed from: eq */
    private boolean f5738eq = false;

    /* renamed from: er */
    private int f5739er = 0;

    /* renamed from: ey */
    private final BroadcastReceiver f5746ey = new C1646d(this);

    /* renamed from: eA */
    private final Handler f5712eA = new HandlerC1875v(this);

    /* renamed from: V */
    Handler f5503V = new HandlerC1878y(this);

    /* renamed from: W */
    ContentObserver f5504W = new C1879z(this, new Handler());

    /* renamed from: eB */
    private final Handler f5713eB = new HandlerC1600bh(this);

    /* renamed from: eC */
    private final Handler f5714eC = new HandlerC1602bj(this);

    /* renamed from: X */
    ContentObserver f5505X = null;

    /* renamed from: Y */
    ContentObserver f5506Y = null;

    /* renamed from: Z */
    ContentObserver f5507Z = null;

    /* renamed from: aa */
    Handler f5534aa = new HandlerC1607bo(this);

    /* renamed from: eD */
    private final Handler f5715eD = new HandlerC1608bp(this);

    /* renamed from: ab */
    ContentObserver f5535ab = new C1610br(this, new Handler());

    /* renamed from: ac */
    Handler f5536ac = new HandlerC1611bs(this);

    /* renamed from: ad */
    InterfaceC2211y f5537ad = new C1612bt(this);

    /* renamed from: ae */
    View.OnClickListener f5538ae = new ViewOnClickListenerC1631cl(this);

    /* renamed from: eE */
    private final View.OnClickListener f5716eE = new ViewOnClickListenerC1632cm(this);

    /* renamed from: af */
    Handler f5539af = new HandlerC1638cs(this);

    /* renamed from: ag */
    Handler f5540ag = new HandlerC1649dc(this);

    /* renamed from: ah */
    InterfaceC2243d f5541ah = new C1650dd(this);

    /* renamed from: ai */
    Handler f5542ai = new HandlerC1651de(this);

    /* renamed from: aj */
    ContentObserver f5543aj = new C1652df(this, new Handler());

    /* renamed from: ak */
    ContentObserver f5544ak = new C1655di(this, new Handler());

    /* renamed from: eF */
    private final SlookAirButton.ItemSelectListener f5717eF = new C1662dp(this);

    /* renamed from: eG */
    private final Handler f5718eG = new HandlerC1788j(this);

    /* renamed from: eJ */
    private final Animation.AnimationListener f5721eJ = new AnimationAnimationListenerC1790l(this);

    /* renamed from: a */
    static /* synthetic */ String m7896a(ChatFragment chatFragment, Object obj) {
        String str = chatFragment.f5595bk + obj;
        chatFragment.f5595bk = str;
        return str;
    }

    /* renamed from: l */
    static /* synthetic */ int m8178l(ChatFragment chatFragment, int i) {
        int i2 = chatFragment.f5656ct + i;
        chatFragment.f5656ct = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m7833D() {
        if (this.f5527aT != null) {
            this.f5527aT.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5624cN = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5624cN = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C1646d c1646d = null;
        super.onCreate(bundle);
        if (C4904y.f17873c) {
            C4904y.m18641c("[Enter the ChatRoom] InboxNO : " + this.f5750v, getClass().getSimpleName());
        }
        this.f5560bB = true;
        this.f5563bE = true;
        this.f5562bD = 0L;
        this.f5588bd = new ArrayList<>();
        this.f5589be = new ArrayList<>();
        this.f5590bf = new ArrayList<>();
        synchronized (this.f5545an) {
            this.f5591bg = new HashMap<>();
        }
        this.f5592bh = new ArrayList<>();
        this.f5643cg = (InputMethodManager) this.f5624cN.getSystemService("input_method");
        this.f5532aY = new C4565a(CommonApplication.m18732r(), new Handler());
        this.f5546ao = new C2210x(this.f5624cN.getContentResolver(), this.f5537ad);
        this.f5657cu = C5034k.m19094a((Context) this.f5624cN);
        this.f5661cy = null;
        this.f5615cE = new C2723a(3);
        this.f5615cE.m11427a(R.raw.trans_err, "TRANS_FAIL");
        this.f5615cE.m11427a(R.raw.reception, "RECV_SUCC");
        if (bundle != null && bundle.containsKey("captureUri")) {
            this.f5559bA = Uri.parse(bundle.getString("captureUri"));
        }
        this.f5549ar = new C0416a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C2948h.f10844a);
        intentFilter.addAction(C2948h.f10845b);
        intentFilter.addAction(C2948h.f10846c);
        intentFilter.addAction(C2948h.f10847d);
        intentFilter.addAction(C2948h.f10848e);
        if (getActivity() != null) {
            this.f5698dm = C1850c.m9021a(getActivity());
            if (!C2349a.m10301a("chaton_translator")) {
                C0096i.m358a(getActivity()).m362a(this.f5746ey, intentFilter);
            }
        }
        this.f5514aG = new C1669dw(this, c1646d);
        C0991aa.m6037a().m18959a(this.f5514aG);
        this.f5734em = new C2098bd(this.f5718eG);
        if (C2349a.m10301a("sms_feature")) {
            C3790i.m14333b(GlobalApplication.m18732r());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5509aB = false;
        this.f5659cw = new C5007c();
        this.f5680dS = new ArrayList<>();
        m7843I();
        this.f5622cL = new C5214j<>(new C1536i(), 8, (byte) 2, -1L);
        this.f5558b = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        m8044as();
        this.f5671dJ = (RelativeLayout) this.f5558b.findViewById(R.id.rootLayout);
        this.f5518aK = (FrameLayout) this.f5558b.findViewById(R.id.chatinput);
        this.f5517aJ = (CheckedTextView) this.f5558b.findViewById(R.id.layout_select_all_include);
        this.f5519aL = (FrameLayout) this.f5558b.findViewById(R.id.rLayoutChatParent);
        this.f5517aJ.setOnClickListener(this.f5716eE);
        this.f5729eh = (WindowManager) GlobalApplication.m18732r().getSystemService("window");
        this.f5645ci = (ViewGroup) this.f5558b.findViewById(R.id.emoticonLayout);
        this.f5527aT = (HeightChangedListView) this.f5558b.findViewById(R.id.chat_listview);
        this.f5527aT.setOnHeightChangedListener(this);
        this.f5650cn = this.f5558b.findViewById(R.id.previewText);
        this.f5650cn.setOnClickListener(this);
        this.f5641ce = (ImageButton) this.f5558b.findViewById(R.id.btnChatSend);
        this.f5641ce.setOnClickListener(this);
        this.f5641ce.setEnabled(false);
        this.f5642cf = (ImageButton) this.f5558b.findViewById(R.id.btnChatTranslate);
        this.f5642cf.setOnClickListener(this);
        this.f5564bF = (MyEditText) this.f5558b.findViewById(R.id.editChatMsg);
        this.f5564bF.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1877x(this));
        this.f5564bF.addTextChangedListener(new C1563aj(this));
        this.f5564bF.setOnEditorActionListener(new C1577ax(this));
        this.f5564bF.setOnEditTextImeBackListener(new C1603bk(this));
        this.f5564bF.setOnTouchListener(new ViewOnTouchListenerC1616bx(this));
        this.f5564bF.setOnClickListener(new ViewOnClickListenerC1630ck(this));
        if (!this.f5564bF.hasFocus()) {
            this.f5564bF.requestFocus();
        }
        this.f5740es = (LinearLayout) this.f5558b.findViewById(R.id.floating_menu_layout);
        this.f5741et = (LinearLayout) this.f5558b.findViewById(R.id.text_counter_layout);
        this.f5742eu = (LinearLayout) this.f5558b.findViewById(R.id.text_mms_layout);
        this.f5743ev = (TextView) this.f5558b.findViewById(R.id.text_counter);
        this.f5744ew = (TextView) this.f5558b.findViewById(R.id.text_mms);
        this.f5740es.setVisibility(8);
        this.f5618cH = (LinearLayout) this.f5558b.findViewById(R.id.layout_preview);
        this.f5618cH.setVisibility(8);
        this.f5618cH.setOnClickListener(this);
        this.f5619cI = (ImageView) this.f5558b.findViewById(R.id.previewProfile);
        this.f5620cJ = (TextView) this.f5558b.findViewById(R.id.previewText2);
        this.f5527aT.setOnScrollListener(new C1641cv(this));
        this.f5516aI = (ImageButton) this.f5558b.findViewById(R.id.btnChatImage);
        this.f5516aI.setOnClickListener(this);
        this.f5515aH = (ImageButton) this.f5558b.findViewById(R.id.btnAdd);
        this.f5515aH.setOnClickListener(this);
        this.f5644ch = (ImageView) this.f5558b.findViewById(R.id.imagebackgroup);
        this.f5554aw = (LinearLayout) this.f5558b.findViewById(R.id.mMedia_layout);
        this.f5555ax = (ImageView) this.f5558b.findViewById(R.id.mMedia_imageView);
        this.f5556ay = (ImageView) this.f5558b.findViewById(R.id.anicon_icon);
        this.f5557az = (ImageButton) this.f5558b.findViewById(R.id.mMedia_del_btn);
        this.f5557az.setOnClickListener(new ViewOnClickListenerC1653dg(this));
        this.f5529aV = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
        this.f5530aW = (ProgressDialog) new C4923p(this.f5624cN).m18724a(R.string.media_file_download);
        m8268m();
        this.f5662cz = (ImageButton) this.f5558b.findViewById(R.id.btn_push_talk);
        this.f5662cz.setOnKeyListener(new ViewOnKeyListenerC1673e(this));
        this.f5611cA = (LinearLayout) this.f5558b.findViewById(R.id.transparentLayout);
        this.f5611cA.setOnTouchListener(null);
        this.f5611cA.setOnClickListener(null);
        this.f5662cz.setOnTouchListener(null);
        this.f5662cz.setOnLongClickListener(new ViewOnLongClickListenerC1792n(this));
        this.f5662cz.setOnClickListener(new ViewOnClickListenerC1838o(this));
        this.f5669dH = C1743gp.m8675a(getActivity(), (LinearLayout) this.f5558b.findViewById(R.id.duringCall));
        this.f5520aM = (ViewGroup) LayoutInflater.from(getActivity()).inflate(R.layout.chat_privacy_layout, (ViewGroup) this.f5527aT, false);
        this.f5527aT.addHeaderView(this.f5520aM);
        this.f5521aN = (LinearLayout) this.f5520aM.findViewById(R.id.privacy_menu_layout);
        this.f5522aO = (LinearLayout) this.f5520aM.findViewById(R.id.privacy_add);
        this.f5523aP = (LinearLayout) this.f5520aM.findViewById(R.id.privacy_block);
        this.f5524aQ = (LinearLayout) this.f5520aM.findViewById(R.id.privacy_report);
        this.f5525aR = (TextView) this.f5520aM.findViewById(R.id.privacy_text);
        this.f5526aS = (LinearLayout) this.f5520aM.findViewById(R.id.loadMoreProgress);
        m7837F();
        m7835E();
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            this.f5686dY = (DrawerLayout) this.f5558b.findViewById(R.id.mDrawerLayout);
            this.f5722ea = (LinearLayout) this.f5558b.findViewById(R.id.listview_linearlayout);
            this.f5681dT = (ListView) this.f5686dY.findViewById(R.id.left_drawer);
            this.f5723eb = (LinearLayout) this.f5686dY.findViewById(R.id.empty_list_view);
            this.f5723eb.setBackgroundColor(getResources().getColor(R.color.chat_draw_menu_background_color));
            this.f5724ec = (ImageView) this.f5723eb.findViewById(R.id.image1);
            this.f5724ec.setImageResource(R.drawable.no_contents_chat);
            this.f5725ed = (TextView) this.f5723eb.findViewById(R.id.text1);
            this.f5725ed.setText(getResources().getString(R.string.no_chats));
            this.f5726ee = (TextView) this.f5723eb.findViewById(R.id.text2);
            this.f5726ee.setText(getResources().getString(R.string.chatlist_no_chat_2));
            this.f5681dT.setEmptyView(this.f5723eb);
            m7902a(layoutInflater.inflate(R.layout.draw_menu_info_layout, (ViewGroup) null, false));
            this.f5681dT.setOnItemClickListener(this);
            this.f5687dZ = new C1839p(this, this.f5624cN, this.f5686dY, R.drawable.actionbar_ic_send, R.string.draw_menu_msg, R.string.ams_never_show_again);
            this.f5686dY.setDrawerListener(this.f5687dZ);
        } else {
            this.f5686dY = (DrawerLayout) this.f5558b.findViewById(R.id.mDrawerLayout);
            this.f5686dY.setDrawerLockMode(1);
        }
        m8036ao();
        if (C4878cp.m18516a().m18518b(EnumC4879cq.CHAT_VOICE)) {
            this.f5503V.sendEmptyMessageDelayed(0, 1000L);
        }
        if (getResources().getConfiguration().orientation == 2) {
            this.f5564bF.setMaxLines(4);
        }
        return this.f5558b;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: E */
    private void m7835E() {
        if (C4825aq.m18259a()) {
            this.f5673dL = m8062b(this.f5515aH, 2);
            this.f5674dM = m7888a((View) this.f5516aI, 2);
            new SlookWritingBuddy(this.f5564bF).setImageWritingListener(new C1840q(this));
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: F */
    private void m7837F() {
        if (Build.VERSION.SDK_INT >= 11 && MultiWindowManager.isMultiWindowServiceEnabled(this.f5624cN)) {
            this.f5631cU = new ViewOnDragListenerC1842s(this);
            this.f5671dJ.setOnDragListener(this.f5631cU);
            this.f5630cT = new ViewOnDragListenerC1843t(this);
            this.f5564bF.setOnDragListener(this.f5630cT);
            this.f5518aK.setOnDragListener(this.f5630cT);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: G */
    private void m7839G() {
        if (MultiWindowManager.isMultiWindowServiceEnabled(this.f5624cN)) {
            this.f5630cT = null;
            this.f5631cU = null;
            this.f5671dJ.setOnDragListener(null);
            this.f5564bF.setOnDragListener(null);
        }
    }

    /* renamed from: H */
    private void m7840H() {
        mo8272q();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2003, 262184, -3);
        layoutParams.gravity = 51;
        C4809aa.m18105a("show_draw_menu_info", (Boolean) true);
        this.f5729eh.addView(this.f5727ef, layoutParams);
    }

    /* renamed from: a */
    private void m7902a(View view) {
        if (!C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
            this.f5727ef = (LinearLayout) view;
            this.f5728eg = (ImageView) this.f5727ef.findViewById(R.id.closeinfo);
            this.f5728eg.setOnClickListener(new ViewOnClickListenerC1874u(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8124c(boolean z) {
        if (this.f5624cN != null && ((ChatActivity) this.f5624cN).m18784t() != null) {
            ((ChatActivity) this.f5624cN).m18784t().mo18833d(z);
        }
        if (this.f5547ap != null && this.f5547ap.findItem(R.id.chat_menu_trunk) != null) {
            this.f5547ap.findItem(R.id.chat_menu_trunk).setEnabled(z);
        }
        if (this.f5694dg != null) {
            if (this.f5637ca == EnumC2301u.LIVE) {
                this.f5694dg.setClickable(false);
            } else {
                this.f5694dg.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m8064b(int i) {
        if (i == 4) {
            this.f5676dO = new AsyncTaskC1687en(this, true);
        } else if (i == 6 || i == 15) {
            this.f5676dO = new AsyncTaskC1687en(this, false);
        } else {
            this.f5676dO = null;
        }
        if (this.f5676dO != null) {
            m8274s();
            if (Build.VERSION.SDK_INT < 11) {
                this.f5676dO.execute(this.f5677dP);
            } else {
                this.f5676dO.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f5677dP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    /* renamed from: a */
    public boolean m7952a(DragEvent dragEvent, EnumC1665ds enumC1665ds) {
        return m7951a(dragEvent.getClipData(), enumC1665ds);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private boolean m7951a(ClipData clipData, EnumC1665ds enumC1665ds) {
        File file;
        CharSequence charSequence;
        Uri uri;
        int i;
        String string = null;
        boolean z = false;
        int i2 = 0;
        if (clipData != null) {
            int itemCount = clipData.getItemCount();
            if (itemCount > 1) {
                Uri uri2 = null;
                int i3 = 0;
                int i4 = 0;
                CharSequence text = null;
                int i5 = 0;
                while (true) {
                    if (i5 >= itemCount) {
                        int i6 = i4;
                        i2 = i3;
                        charSequence = text;
                        uri = uri2;
                        i = i6;
                        break;
                    }
                    ClipData.Item itemAt = clipData.getItemAt(i5);
                    if (itemAt.getText() != null) {
                        text = itemAt.getText();
                    } else if (itemAt.getUri() != null) {
                        uri2 = itemAt.getUri();
                        i4++;
                        i3 = i5;
                    }
                    if (i4 > 1) {
                        int i7 = i4;
                        i2 = i3;
                        charSequence = text;
                        uri = uri2;
                        i = i7;
                        break;
                    }
                    i5++;
                }
                if (i == 1 && uri != null && charSequence != null) {
                    z = true;
                }
            }
            if (itemCount < 2 || z) {
                ClipData.Item itemAt2 = clipData.getItemAt(i2);
                if (itemAt2 != null) {
                    Intent intent = itemAt2.getIntent();
                    if (intent != null) {
                        Uri uri3 = (Uri) intent.getExtras().get("android.intent.extra.STREAM");
                        if (uri3 != null) {
                            string = uri3.toString();
                        }
                        String type = intent.getType();
                        String string2 = intent.getExtras().getString("android.intent.extra.TEXT");
                        if (uri3 != null && string != null && type != null) {
                            if (string.contains("file://")) {
                                file = new File(Uri.parse(string).getPath());
                            } else {
                                C4899t c4899tM18615c = C4894o.m18615c(string);
                                if (c4899tM18615c == null) {
                                    file = null;
                                } else {
                                    file = c4899tM18615c.f17859a;
                                }
                            }
                            EnumC2214ab enumC2214abM8168j = m8168j(type);
                            if (enumC2214abM8168j != null) {
                                if (enumC2214abM8168j == EnumC2214ab.DOCUMENT) {
                                    new Intent().setData(uri3);
                                    m8120c(intent);
                                } else {
                                    m7927a(enumC1665ds, file, m8168j(type), string2);
                                }
                            } else {
                                C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                            }
                            if (C4904y.f17872b) {
                                if (file != null) {
                                    C4904y.m18639b("onDrag_editview generate filepath : " + file.getAbsolutePath(), f5461a);
                                } else {
                                    C4904y.m18639b("onDrag_editview file is null", f5461a);
                                }
                            }
                        } else {
                            C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                        }
                    } else if (Build.VERSION.SDK_INT >= 11 && itemAt2.getUri() != null) {
                        Uri uri4 = itemAt2.getUri();
                        if ("file".equals(uri4.getScheme())) {
                            Intent intent2 = new Intent();
                            File file2 = new File(uri4.getPath());
                            EnumC2758b enumC2758bM11581d = FileExplorerActivity.m11581d(itemAt2.getUri().getPath());
                            if (this.f5637ca == EnumC2301u.LIVE && enumC2758bM11581d != EnumC2758b.VIDEO && enumC2758bM11581d != EnumC2758b.IMAGE) {
                                enumC2758bM11581d = EnumC2758b.UNKNOWN;
                            }
                            if (enumC2758bM11581d == EnumC2758b.VIDEO) {
                                m7927a(enumC1665ds, file2, EnumC2214ab.VIDEO, (String) null);
                            } else if (enumC2758bM11581d == EnumC2758b.IMAGE) {
                                m7927a(enumC1665ds, file2, EnumC2214ab.IMAGE, (String) null);
                            } else if (enumC2758bM11581d == EnumC2758b.DOC || enumC2758bM11581d == EnumC2758b.GUL || enumC2758bM11581d == EnumC2758b.HWP || enumC2758bM11581d == EnumC2758b.PDF || enumC2758bM11581d == EnumC2758b.PPT || enumC2758bM11581d == EnumC2758b.SNB || enumC2758bM11581d == EnumC2758b.TXT || enumC2758bM11581d == EnumC2758b.XLS) {
                                intent2.setData(uri4);
                                m8120c(intent2);
                            } else {
                                C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                            }
                        } else {
                            C4899t c4899tM18615c2 = C4894o.m18615c(itemAt2.getUri().toString());
                            if (c4899tM18615c2 != null && c4899tM18615c2.f17860b != null && c4899tM18615c2.f17859a != null) {
                                if (c4899tM18615c2.f17860b.contains("image/")) {
                                    m7927a(enumC1665ds, c4899tM18615c2.f17859a, EnumC2214ab.IMAGE, (String) null);
                                } else if (c4899tM18615c2.f17860b.contains("video/")) {
                                    m7927a(enumC1665ds, c4899tM18615c2.f17859a, EnumC2214ab.VIDEO, (String) null);
                                } else if (c4899tM18615c2.f17860b.contains("audio/") && this.f5637ca != EnumC2301u.LIVE) {
                                    m7927a(enumC1665ds, c4899tM18615c2.f17859a, EnumC2214ab.AUDIO, (String) null);
                                } else {
                                    C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                                }
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("onDrag_editview generate filepath : " + c4899tM18615c2.f17859a.getAbsolutePath(), f5461a);
                                }
                            } else {
                                C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                            }
                        }
                    } else if (Build.VERSION.SDK_INT >= 11 && itemAt2.getText() != null && itemAt2.getText().length() > 0) {
                        if (enumC1665ds == EnumC1665ds.EditTextSpace) {
                            String string3 = itemAt2.getText().toString();
                            if (!TextUtils.isEmpty(this.f5564bF.getText().toString())) {
                                string3 = this.f5564bF.getText().toString() + " " + string3;
                            }
                            this.f5564bF.setText(string3);
                            this.f5564bF.setSelection(string3.length());
                        } else if (enumC1665ds == EnumC1665ds.ChatSpace) {
                            m7942a(itemAt2.getText().toString(), "", true);
                        }
                    } else if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(itemAt2.getHtmlText())) {
                        if (enumC1665ds == EnumC1665ds.EditTextSpace) {
                            String htmlText = itemAt2.getHtmlText();
                            if (!TextUtils.isEmpty(this.f5564bF.getText().toString())) {
                                htmlText = this.f5564bF.getText().toString() + " " + htmlText;
                            }
                            this.f5564bF.setText(htmlText);
                            this.f5564bF.setSelection(htmlText.length());
                        } else if (enumC1665ds == EnumC1665ds.ChatSpace) {
                            m7942a(itemAt2.getHtmlText(), "", true);
                        }
                    } else {
                        C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                    }
                    return true;
                }
                return true;
            }
            C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
            return true;
        }
        return false;
    }

    /* renamed from: I */
    private void m7843I() {
        this.f5680dS.add("image/");
        this.f5680dS.add("text/plain");
        this.f5680dS.add("video/");
        this.f5680dS.add("audio/");
        this.f5680dS.add("application/");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.chaton.p057e.EnumC2214ab m8168j(java.lang.String r5) {
        /*
            r4 = this;
            r1 = 0
            java.util.ArrayList<java.lang.String> r0 = r4.f5680dS
            java.util.Iterator r0 = r0.iterator()
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L6b
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = r5.contains(r0)
            if (r2 == 0) goto L6b
        L19:
            java.lang.String r2 = "image/"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L37
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.IMAGE
        L24:
            com.sec.chaton.e.u r2 = r4.f5637ca
            com.sec.chaton.e.u r3 = com.sec.chaton.p057e.EnumC2301u.LIVE
            if (r2 != r3) goto L67
            com.sec.chaton.e.ab r2 = com.sec.chaton.p057e.EnumC2214ab.IMAGE
            if (r0 == r2) goto L67
            com.sec.chaton.e.ab r2 = com.sec.chaton.p057e.EnumC2214ab.VIDEO
            if (r0 == r2) goto L67
            com.sec.chaton.e.ab r2 = com.sec.chaton.p057e.EnumC2214ab.TEXT
            if (r0 == r2) goto L67
        L36:
            return r1
        L37:
            java.lang.String r2 = "video/"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L43
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.VIDEO
            goto L24
        L43:
            java.lang.String r2 = "audio/"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4f
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.AUDIO
            goto L24
        L4f:
            java.lang.String r2 = "text/plain"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L5b
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.TEXT
            goto L24
        L5b:
            java.lang.String r2 = "application/"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L69
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.DOCUMENT
            goto L24
        L67:
            r1 = r0
            goto L36
        L69:
            r0 = r1
            goto L24
        L6b:
            r0 = r1
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.m8168j(java.lang.String):com.sec.chaton.e.ab");
    }

    /* renamed from: a */
    private void m7927a(EnumC1665ds enumC1665ds, File file, EnumC2214ab enumC2214ab, String str) {
        if (file == null) {
            C4904y.m18641c("sendDraggingFile() - file is null", f5461a);
            return;
        }
        if (enumC1665ds == EnumC1665ds.ChatSpace) {
            EnumC2758b enumC2758bM11581d = FileExplorerActivity.m11581d(file.getPath());
            if (enumC2214ab == EnumC2214ab.IMAGE) {
                if (enumC2758bM11581d == EnumC2758b.UNKNOWN) {
                    C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                    return;
                } else {
                    m7895a(file.getAbsolutePath(), false, false);
                    return;
                }
            }
            if (enumC2214ab == EnumC2214ab.AUDIO) {
                m7936a(file, (String) null, (String) null, enumC2214ab, (String) null);
                return;
            }
            if (enumC2214ab == EnumC2214ab.VIDEO) {
                if (enumC2758bM11581d == EnumC2758b.UNKNOWN) {
                    C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                    return;
                } else {
                    m7936a(file, (String) null, (String) null, enumC2214ab, (String) null);
                    return;
                }
            }
            if (enumC2214ab == EnumC2214ab.TEXT && str != null) {
                m7942a(str, "", true);
                return;
            }
            return;
        }
        if (enumC1665ds == EnumC1665ds.EditTextSpace) {
            if (enumC2214ab == EnumC2214ab.AUDIO) {
                m7936a(file, (String) null, (String) null, enumC2214ab, (String) null);
                return;
            }
            if (enumC2214ab == EnumC2214ab.IMAGE || enumC2214ab == EnumC2214ab.VIDEO) {
                if (FileExplorerActivity.m11581d(file.getPath()) == EnumC2758b.UNKNOWN) {
                    C5179v.m19810a(this.f5624cN, R.string.toast_supported_format, 0).show();
                    return;
                } else {
                    m7934a(file, enumC2214ab, (String) null, (String) null, false);
                    return;
                }
            }
            if (enumC2214ab == EnumC2214ab.TEXT && str != null) {
                this.f5564bF.setText(str);
            }
        }
    }

    /* renamed from: J */
    private void m7844J() {
        this.f5498O = new ArrayList<>();
        this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_picture, R.drawable.co_attach_p_image_normal, 0));
        if (C4822an.m18251s()) {
            this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_capture_picture, R.drawable.co_attach_p_camera_normal, 1));
        }
        this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_video, R.drawable.co_attach_p_video_normal, 2));
        if (C4822an.m18251s()) {
            this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_record_video, R.drawable.co_attach_p_record_normal, 3));
        }
        if (this.f5637ca == EnumC2301u.NORMAL) {
            if (!C4822an.m18206P() && !C4822an.m18207Q() && (C4859bx.m18396c() || C5047m.m19188a(getActivity(), C2722d.m11408a(getActivity())))) {
                this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.glympse, R.drawable.co_attach_p_glympse_normal, 12));
            }
            if (C1427a.m7518a()) {
                this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_geo_tag, R.drawable.co_attach_p_location_normal, 8));
            }
            if (this.f5637ca == EnumC2301u.NORMAL && !C4822an.m18206P() && !C4822an.m18207Q()) {
                this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_animessage, R.drawable.co_attach_p_ams_normal, 9));
            }
            this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.media_voice, R.drawable.co_attach_p_voice_normal, 4));
            if (this.f5487D != EnumC2300t.TOPIC) {
                this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_contact, R.drawable.co_attach_p_contact_normal, 6));
            }
            this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_calendar, R.drawable.co_attach_p_calendar_normal, 7));
            if (C1427a.m7520c()) {
                this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_snote, R.drawable.co_attach_p_s_note_normal, 11));
            }
            this.f5498O.add(new C2337g(GlobalApplication.m10283b(), R.string.menu_multimedia_files, R.drawable.co_attach_p_document_normal, 10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m8175k(String str) {
        if (!TextUtils.isEmpty(str)) {
            m7936a(new File(str), (String) null, (String) null, EnumC2214ab.AUDIO, (String) null);
            C2726b.m11429a().m11438a(this.f5750v);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() throws RemoteException, OperationApplicationException {
        super.onDestroyView();
        this.f5659cw.m19014a();
        this.f5528aU.m8580i();
        this.f5527aT.setAdapter((ListAdapter) null);
        m7839G();
        if (this.f5621cK != null && this.f5621cK.isShowing()) {
            this.f5621cK.dismiss();
        }
        Cursor cursorA = this.f5528aU.mo871a();
        if (cursorA != null && !cursorA.isClosed()) {
            cursorA.close();
            if (C4904y.f17872b) {
                C4904y.m18639b("The Cursor of Adapter was closed", getClass().getSimpleName());
            }
        }
        this.f5528aU.m8564a((InterfaceC1773hs) null);
        m8038ap();
        try {
            if (this.f5622cL != null) {
                this.f5622cL.mo19817d();
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f5461a);
            }
        }
        if (C4825aq.m18259a()) {
            m8039aq();
            if (this.f5676dO != null) {
                this.f5676dO.cancel(true);
            }
        }
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            getActivity().getContentResolver().unregisterContentObserver(this.f5504W);
        }
        if (this.f5730ei != null) {
            this.f5730ei.cancel(false);
        }
        if (this.f5731ej != null) {
            this.f5731ej.m14355b();
            if (C2202p.m9990g(this.f5733el, this.f5750v) != 0) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                arrayList.add(C2202p.m9970a(this.f5750v, 0));
                try {
                    this.f5733el.applyBatch("com.sec.chaton.provider", arrayList);
                } catch (OperationApplicationException e2) {
                    e2.printStackTrace();
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                }
                C0991aa.m6037a().m18961c(new C1015an(new String[0]));
                C0991aa.m6037a().m18961c(new C1066bf(C1828q.f6913a, -1));
            }
        }
        m8279y();
        if (this.f5735en != null) {
            this.f5735en.m11236a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) throws Resources.NotFoundException {
        int i;
        String[] strArr;
        super.onActivityCreated(bundle);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.f5647ck = getArguments();
        if (this.f5647ck != null && this.f5647ck.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("InBoxNO : ");
            if (this.f5647ck.containsKey("smsmode")) {
            }
            if (this.f5647ck.containsKey("inboxNO")) {
                this.f5750v = this.f5647ck.getString("inboxNO");
                sb.append(this.f5750v);
            } else if (bundle != null && bundle.containsKey("inbox_no")) {
                this.f5750v = bundle.getString("inbox_no");
                sb.append(this.f5750v).append(" from SavedInstance");
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("ChatType : ");
            if (this.f5647ck.containsKey("chatType")) {
                this.f5487D = EnumC2300t.m10207a(this.f5647ck.getInt("chatType"));
                if (this.f5487D != null) {
                    sb.append(this.f5487D.toString());
                }
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("Participants : ");
            if (this.f5588bd != null) {
                this.f5588bd.clear();
            } else {
                this.f5588bd = new ArrayList<>();
            }
            if (this.f5591bg != null) {
                this.f5591bg.clear();
            } else {
                this.f5591bg = new HashMap<>();
            }
            if (this.f5647ck.containsKey("receivers")) {
                String[] stringArray = this.f5647ck.getStringArray("receivers");
                if (this.f5487D == EnumC2300t.ONETOONE) {
                    this.f5752x = stringArray[0];
                }
                synchronized (this.f5545an) {
                    for (String str : stringArray) {
                        this.f5588bd.add(str);
                        this.f5591bg.put(str, new C0777a(str));
                        sb.append(str + " ");
                    }
                }
            } else {
                sb.append("Not Contained");
                if (this.f5647ck.containsKey("groupId")) {
                    if (this.f5487D != EnumC2300t.GROUPCHAT && this.f5487D != EnumC2300t.TOPIC) {
                        strArr = null;
                    } else {
                        strArr = (String[]) C2191e.m9852a(CommonApplication.m18732r().getContentResolver(), Integer.parseInt(this.f5647ck.getString("groupId"))).toArray(new String[0]);
                    }
                    if (strArr != null) {
                        synchronized (this.f5545an) {
                            for (String str2 : strArr) {
                                this.f5588bd.add(str2);
                                this.f5591bg.put(str2, new C0777a(str2));
                                sb.append(str2 + " ");
                            }
                        }
                    } else {
                        C4904y.m18634a("onActivityCreated() receiverList is NULL. ERROR!", getClass().getSimpleName());
                    }
                }
            }
            C4904y.m18646e(sb.toString(), getClass().getSimpleName());
            if (arrayList != null) {
                arrayList.clear();
            }
            if (this.f5487D == EnumC2300t.GROUPCHAT && this.f5647ck.containsKey("contact_receivers_id")) {
                for (String str3 : this.f5647ck.getStringArray("contact_receivers_id")) {
                    if (!arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                }
            }
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (this.f5487D == EnumC2300t.GROUPCHAT && this.f5647ck.containsKey("contact_receivers_phone")) {
                for (String str4 : this.f5647ck.getStringArray("contact_receivers_phone")) {
                    if (!arrayList2.contains(str4)) {
                        arrayList2.add(str4);
                    }
                }
            }
            sb.append("KEY_GROUP_NAME : ");
            if (this.f5647ck.containsKey("groupnmae")) {
                this.f5490G = this.f5647ck.getString("groupnmae");
                sb.append(this.f5490G.toString());
                C4904y.m18644d("mGroupName:" + this.f5490G);
                this.f5596bl = this.f5490G;
                this.f5692de.setText(this.f5490G);
                this.f5595bk = this.f5490G;
                this.f5601bq = this.f5490G;
            }
            if (this.f5647ck.containsKey("roomType")) {
                this.f5637ca = EnumC2301u.m10211a(this.f5647ck.getInt("roomType"));
                if (C4904y.f17873c) {
                    C4904y.m18641c("room type:" + this.f5637ca, f5461a);
                }
            }
            if (this.f5647ck.containsKey("content_type")) {
                this.f5574bP = this.f5647ck.getInt("content_type");
                this.f5647ck.remove("content_type");
                C4904y.m18644d("ChatView content_type:" + this.f5574bP);
                this.f5581bW = true;
            }
            if (this.f5647ck.containsKey("download_uri")) {
                this.f5575bQ = this.f5647ck.getString("download_uri");
                C4904y.m18644d("ChatView download_uri:" + this.f5575bQ);
            }
            if (this.f5647ck.containsKey("sub_content")) {
                this.f5576bR = this.f5647ck.getString("sub_content");
                C4904y.m18644d("ChatView sub_content:" + this.f5576bR);
            }
            if (this.f5647ck.containsKey("forward_chat_message")) {
                this.f5552au = this.f5647ck.getBoolean("forward_chat_message");
                C4904y.m18644d("ChatView mForwardFromShop:" + this.f5552au);
            }
            if (this.f5647ck.containsKey("forward_sender_name")) {
                this.f5577bS = this.f5647ck.getString("forward_sender_name");
                C4904y.m18644d("ChatView forward_sender_name:" + this.f5577bS);
            }
            if (this.f5647ck.containsKey("is_forward_mode")) {
                this.f5578bT = this.f5647ck.getBoolean("is_forward_mode");
                C4904y.m18644d("ChatView forward_mode:" + this.f5578bT);
            }
            if (this.f5647ck.containsKey(f5473i)) {
                this.f5678dQ = this.f5647ck.getBoolean(f5473i);
                if (this.f5678dQ && this.f5564bF != null) {
                    m8218a();
                }
                C4904y.m18644d("misForceShowKeyboard:" + this.f5678dQ);
            }
            if (this.f5647ck.containsKey(f5472h)) {
                this.f5579bU = this.f5647ck.getString(f5472h);
                this.f5583bY = this.f5647ck.getBoolean(f5474j);
                if (this.f5583bY) {
                    this.f5595bk = this.f5579bU;
                    this.f5601bq = this.f5595bk;
                    this.f5580bV = true;
                }
            }
            if (this.f5647ck.containsKey(f5475k)) {
                this.f5582bX = this.f5647ck.getBoolean(f5475k);
            }
            if (this.f5647ck.containsKey("inboxValid")) {
                this.f5560bB = this.f5647ck.getBoolean("inboxValid");
                if (!this.f5560bB) {
                    this.f5518aK.setVisibility(8);
                }
            }
            if (this.f5647ck.containsKey("trunkUnreadCount")) {
                this.f5605bu = this.f5647ck.getInt("trunkUnreadCount");
            } else {
                this.f5605bu = 0;
            }
            if (this.f5647ck.containsKey("lastTempMessage")) {
                this.f5484A = this.f5647ck.getString("lastTempMessage");
            }
            if (this.f5647ck.containsKey("showPhoneNumber")) {
                this.f5533aZ = this.f5647ck.getInt("showPhoneNumber", 0);
            }
            if (this.f5647ck.containsKey("extraInfo")) {
                this.f5585ba = this.f5647ck.getString("extraInfo");
            }
            if (this.f5647ck.containsKey("msisdns")) {
                this.f5586bb = this.f5647ck.getString("msisdns");
                if (TextUtils.isEmpty(this.f5752x)) {
                    this.f5533aZ = 0;
                } else if (m8257e(this.f5586bb)) {
                    if (m8204s(this.f5586bb).size() == 0) {
                        this.f5533aZ = 0;
                    } else {
                        this.f5533aZ = 1;
                    }
                }
            }
            if (this.f5647ck.containsKey("groupId")) {
                this.f5658cv = this.f5647ck.getString("groupId");
            }
            if (this.f5647ck.containsKey("is_attach_on_the_edittext")) {
                this.f5672dK = this.f5647ck.getBoolean("is_attach_on_the_edittext");
            }
            if (this.f5647ck.containsKey(C1071bk.f3371e)) {
                this.f5584bZ = (EnumC1094bm) this.f5647ck.get(C1071bk.f3371e);
            }
            if (this.f5647ck.containsKey("msgbox")) {
                this.f5647ck.remove("msgbox");
                this.f5634cX = true;
                m8067b(this.f5647ck);
            }
            if (this.f5647ck.containsKey("liveUserType")) {
                this.f5640cd = EnumC1109f.m7094a(this.f5647ck.getString("liveUserType"));
            }
            if (this.f5647ck.containsKey("sessionID")) {
                this.f5488E = this.f5647ck.getString("sessionID");
            }
            if (this.f5647ck.containsKey("fromUpdatePush")) {
                this.f5667dF = this.f5647ck.getBoolean("fromUpdatePush");
            }
            if (this.f5647ck.containsKey("updatePushName")) {
                this.f5668dG = this.f5647ck.getString("updatePushName");
            }
        }
        if (TextUtils.isEmpty(this.f5488E) && bundle != null && bundle.containsKey("session_id")) {
            this.f5488E = bundle.getString("session_id");
        }
        registerForContextMenu(this.f5527aT);
        BaseActivity.m6160a((Fragment) this, true);
        this.f5528aU = new C1723fw(this.f5624cN, this.f5527aT, null, this.f5487D, this.f5637ca, m7985aP(), m7983aO(), this.f5659cw, this.f5622cL, this.f5717eF);
        if (C4822an.m18203M()) {
            m7996aU();
            if (!TextUtils.isEmpty(this.f5750v)) {
                m8259f(this.f5750v);
            }
        }
        this.f5527aT.setAdapter((ListAdapter) this.f5528aU);
        if (this.f5731ej != null) {
            this.f5528aU.m8565a(this.f5731ej);
            this.f5528aU.m8561a(this.f5715eD);
            this.f5528aU.m8568b(this.f5534aa);
        }
        this.f5528aU.m8564a(this);
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            this.f5500S = new C2608a(getActivity(), this.f5681dT, R.layout.list_item_common_6, null, this.f5659cw, this.f5717eF);
            this.f5500S.m11158a(this.f5750v);
            getActivity().getContentResolver().registerContentObserver(C2299s.f8209a, true, this.f5504W);
            this.f5681dT.setAdapter((ListAdapter) this.f5500S);
            this.f5683dV = true;
            this.f5527aT.setItemsCanFocus(false);
            this.f5527aT.setChoiceMode(0);
            this.f5500S.m11156a(0);
        }
        if (this.f5647ck != null && "file".equals(this.f5647ck.getString(C1071bk.f3368b))) {
            m8010ab();
            this.f5647ck.remove(C1071bk.f3368b);
        }
        this.f5527aT.setTranscriptMode(2);
        this.f5527aT.setSelection(this.f5527aT.getCount());
        this.f5614cD = new C1876w(this);
        this.f5528aU.registerDataSetObserver(this.f5614cD);
        m7867U();
        if (this.f5750v != null) {
            m8208t(this.f5750v);
        }
        m7945a(arrayList, arrayList2);
        if (this.f5637ca == EnumC2301u.LIVE && this.f5647ck != null && this.f5647ck.containsKey("inbox_unread_count") && (i = this.f5647ck.getInt("inbox_unread_count")) > 0) {
            C5043h.m19179a().m19186a("2000", "2125", false, i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (getActivity() != null && this.f5750v != null) {
            boolean zM9962o = C2198l.m9962o(GlobalApplication.m18732r().getContentResolver(), this.f5750v);
            if (C4904y.f17873c) {
                C4904y.m18641c("[onResume() ChatRoom] isTranslateEnabled : " + zM9962o, getClass().getSimpleName());
            }
            this.f5698dm = C1850c.m9021a(getActivity());
            if (!this.f5698dm) {
                C2198l.m9937b(GlobalApplication.m18732r().getContentResolver(), this.f5750v, this.f5698dm);
                this.f5699dn = this.f5698dm;
            }
        }
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            if (!C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
                m7840H();
            }
            this.f5527aT.setChoiceMode(0);
            this.f5500S.m11156a(0);
            this.f5527aT.setItemsCanFocus(false);
        }
        if (((KeyguardManager) getActivity().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("keyguard is displayed. Do not anything", f5461a);
            }
            m8093bg();
        } else {
            if (C4904y.f17873c) {
                C4904y.m18641c("keyguard is not displayed", f5461a);
            }
            m7846K();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m7846K() {
        if (this.f5624cN == null) {
            C4904y.m18641c("[initializeChatRoom] attach activity is null. return", f5461a);
            return;
        }
        C0991aa.m6037a().m18962d(new C1009ah());
        this.f5654cr = false;
        this.f5665dC = false;
        this.f5534aa.sendEmptyMessageDelayed(100, 10L);
        PushReceiver.m12761a(this);
        SmsReceiverService.m15558a(this);
        m8246c();
        C1850c.m9024d().m9039e().m9007a();
        m7850M();
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            this.f5654cr = false;
            C4904y.m18646e("[MSGBOX] onResume()", getClass().getSimpleName());
            if (!TextUtils.isEmpty(GlobalApplication.f8359e)) {
                GlobalApplication.f8359e = null;
                this.f5659cw.m19014a();
                this.f5659cw = new C5007c();
                this.f5500S.m11157a(this.f5659cw);
            }
            m7848L();
        }
        this.f5669dH.m8687b();
        if (this.f5487D == EnumC2300t.ONETOONE || this.f5487D == EnumC2300t.GROUPCHAT || this.f5487D == EnumC2300t.TOPIC) {
            C1856i.m9048a(this.f5527aT);
            C1856i.m9053b();
            if (!C1856i.m9049a()) {
                C1856i.m9056c();
            }
        }
        if (this.f5603bs.equals("-1")) {
            m7981aN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m7848L() {
        if (this.f5683dV) {
            this.f5683dV = false;
            C4904y.m18646e("[MSGBOX] updateMsgbox()", getClass().getSimpleName());
            this.f5546ao.startQuery(99, null, C2299s.m10188b(), null, null, new String[]{this.f5750v}, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public void m7850M() {
        int length = this.f5564bF.getText() != null ? this.f5564bF.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() : 0;
        if (m8277v()) {
            if (this.f5698dm && this.f5699dn && !this.f5700do) {
                this.f5641ce.setVisibility(8);
                if (length > 0) {
                    this.f5662cz.setVisibility(8);
                    this.f5642cf.setEnabled(true);
                    this.f5642cf.setVisibility(0);
                    return;
                } else {
                    if (this.f5548aq) {
                        this.f5662cz.setVisibility(8);
                        this.f5642cf.setVisibility(8);
                        this.f5641ce.setEnabled(true);
                        this.f5641ce.setVisibility(0);
                        return;
                    }
                    this.f5662cz.setVisibility(0);
                    this.f5642cf.setVisibility(8);
                    this.f5641ce.setVisibility(8);
                    return;
                }
            }
            this.f5642cf.setVisibility(8);
            if (this.f5548aq || length > 0) {
                this.f5662cz.setVisibility(8);
                this.f5641ce.setVisibility(0);
                return;
            } else {
                this.f5662cz.setVisibility(0);
                this.f5641ce.setVisibility(8);
                return;
            }
        }
        this.f5662cz.setVisibility(8);
        if (this.f5698dm && this.f5699dn && !this.f5700do) {
            if (length > 0) {
                this.f5642cf.setEnabled(true);
                this.f5642cf.setVisibility(0);
                this.f5641ce.setVisibility(8);
                return;
            } else if (this.f5548aq) {
                this.f5641ce.setEnabled(true);
                this.f5641ce.setVisibility(0);
                this.f5642cf.setVisibility(8);
                return;
            } else {
                this.f5642cf.setEnabled(false);
                this.f5642cf.setVisibility(0);
                this.f5641ce.setVisibility(8);
                return;
            }
        }
        this.f5641ce.setEnabled(length > 0 || this.f5548aq);
        this.f5641ce.setVisibility(0);
        this.f5642cf.setVisibility(8);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() throws IllegalStateException {
        super.onPause();
        if (C2349a.m10301a("chatroom_draw_menu_feature") && C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue() && !C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
            this.f5729eh.removeView(this.f5727ef);
            C4809aa.m18105a("show_draw_menu_info", (Boolean) false);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[onPause() ChatRoom] InboxNO : " + this.f5750v, getClass().getSimpleName());
        }
        this.f5654cr = true;
        if (!this.f5665dC) {
            this.f5484A = this.f5564bF.getText().toString();
            m7859Q();
        }
        m8267l();
        m8250d();
        m8258f();
        m8096bh();
        if (this.f5531aX != null) {
            this.f5531aX.mo9243a(SystemClock.elapsedRealtime() + 300000);
            this.f5531aX.mo9279r();
        }
        C1813b.m8906b().m8939d(this.f5750v);
        PushReceiver.m12761a((InterfaceC1762hh) null);
        if (this.f5612cB != null) {
            this.f5612cB.m8812a();
            this.f5612cB = null;
        }
        C2726b.m11429a().m11445c();
        if (this.f5513aF != null) {
            this.f5513aF.m11538a();
        }
        mo8272q();
        this.f5669dH.m8688c();
        C3460d.f12913a.clear();
        C2780l.m11679a().m11684b();
    }

    /* renamed from: l */
    private void m8181l(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f5532aY.m17517a(arrayList);
    }

    /* renamed from: a */
    public void m8218a() {
        this.f5564bF.requestFocus();
        long j = 200;
        if (!this.f5564bF.isShown()) {
            j = 1000;
        }
        new Timer(true).schedule(new C1554aa(this, new Handler()), j);
    }

    /* renamed from: N */
    private void m7853N() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        if (this.f5637ca == EnumC2301u.LIVE) {
            this.f5546ao.startUpdate(24, null, C2299s.m10186a(this.f5750v, EnumC4549n.LIVECHAT), contentValues, null, null);
        } else {
            this.f5546ao.startUpdate(24, null, C2299s.m10198k(), contentValues, "inbox_no = ?", new String[]{this.f5750v});
        }
        if (this.f5637ca == EnumC2301u.NORMAL) {
            if (this.f5531aX == null) {
                m7855O();
            }
            if ((this.f5531aX instanceof C2142w) && ((C2142w) this.f5531aX).m9652j() == null) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("updateUnreadCount() - tcpContext is null, so do not call readMessage", f5461a);
                    return;
                }
                return;
            }
            this.f5531aX.mo9227a(this.f5487D, this.f5488E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public boolean m7855O() {
        switch (C1791m.f6702a[this.f5637ca.ordinal()]) {
            case 1:
                this.f5531aX = C2136q.m9582a(this.f5750v, this.f5487D);
                break;
            case 2:
                this.f5531aX = C2142w.m9593a(this.f5750v, this.f5487D);
                break;
        }
        if (this.f5531aX == null) {
            C4904y.m18634a("false : mMessageControl null", getClass().getSimpleName());
            return false;
        }
        if (this.f5654cr) {
            C4904y.m18634a("false : already paused", getClass().getSimpleName());
            return false;
        }
        if (this.f5637ca == EnumC2301u.NORMAL) {
            this.f5531aX.m9246a(this.f5536ac);
            this.f5531aX.mo9244a(this.f5488E);
            this.f5531aX.mo9266b(this.f5602br);
        }
        if (this.f5531aX.mo9272c() && !C2717y.m11395a(this.f5637ca)) {
            m8274s();
        }
        if (this.f5661cy != null) {
            m7857P();
        }
        if (this.f5637ca == EnumC2301u.NORMAL && this.f5487D != EnumC2300t.TOPIC) {
            this.f5612cB = new C1779hy((C2142w) this.f5531aX, this);
        }
        return true;
    }

    /* renamed from: P */
    private void m7857P() {
        switch (this.f5661cy.getIntExtra("requestCode", -1)) {
            case 0:
                m8221a(this.f5559bA, true);
                break;
            case 1:
                this.f5546ao.startQuery(26, this.f5661cy.getData(), this.f5661cy.getData(), null, null, null, null);
                break;
            case 5:
                m8163i(this.f5661cy);
                break;
            case 6:
                m8149g(this.f5661cy);
                break;
            case 7:
                m8156h(this.f5661cy);
                break;
            case 9:
                m8130d(this.f5661cy);
                break;
            case 11:
            case 12:
                m8170j(this.f5661cy);
                break;
            case 15:
                m8065b(this.f5661cy);
                break;
            case 16:
            case 21:
                m7901a(this.f5661cy.getExtras());
                break;
            case 18:
                m8120c(this.f5661cy);
                break;
            case 19:
                m8136e(this.f5661cy);
                break;
            case 22:
                m8174k(this.f5661cy);
                break;
            case 25:
                m8144f(this.f5661cy);
                break;
        }
        this.f5661cy = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m7859Q() {
        /*
            r9 = this;
            r1 = -1
            java.lang.String r0 = r9.f5750v
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L93
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.sec.chaton.chat.MyEditText r0 = r9.f5564bF
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.sec.chaton.chat.C1736gi.m8632a(r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.String r2 = ";"
            r0.append(r2)
            java.lang.String r2 = ""
            java.lang.String r0 = ""
            boolean r3 = r9.f5548aq
            if (r3 == 0) goto La3
            com.sec.chaton.e.ab r3 = r9.f5551at
            com.sec.chaton.e.ab r6 = com.sec.chaton.p057e.EnumC2214ab.IMAGE
            if (r3 == r6) goto L47
            com.sec.chaton.e.ab r3 = r9.f5551at
            com.sec.chaton.e.ab r6 = com.sec.chaton.p057e.EnumC2214ab.AMS
            if (r3 == r6) goto L47
            com.sec.chaton.e.ab r3 = r9.f5551at
            com.sec.chaton.e.ab r6 = com.sec.chaton.p057e.EnumC2214ab.VIDEO
            if (r3 != r6) goto L94
        L47:
            java.io.File r3 = r9.f5550as
            if (r3 == 0) goto La3
            com.sec.chaton.e.ab r2 = r9.f5551at
            int r3 = r2.m10076a()
            java.io.File r2 = r9.f5550as
            java.lang.String r2 = r2.getAbsolutePath()
            boolean r6 = r9.f5508aA
            if (r6 == 0) goto L5d
            java.lang.String r0 = r9.f5510aC
        L5d:
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
            com.sec.chaton.e.a.x r0 = r9.f5546ao
            r2 = 0
            android.net.Uri r3 = com.sec.chaton.p057e.C2299s.f8209a
            java.lang.String r5 = "inbox_no=?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]
            r7 = 0
            java.lang.String r8 = r9.f5750v
            r6[r7] = r8
            r0.startUpdate(r1, r2, r3, r4, r5, r6)
        L93:
            return
        L94:
            com.sec.chaton.e.ab r3 = r9.f5551at
            com.sec.chaton.e.ab r6 = com.sec.chaton.p057e.EnumC2214ab.ANICON
            if (r3 != r6) goto La3
            com.sec.chaton.e.ab r2 = r9.f5551at
            int r3 = r2.m10076a()
            java.lang.String r2 = r9.f5609by
            goto L5d
        La3:
            r3 = r1
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.m7859Q():void");
    }

    /* renamed from: R */
    private void m7861R() {
        if (this.f5509aB) {
            this.f5547ap.setGroupVisible(R.id.chat_menu_group, false);
            this.f5547ap.setGroupVisible(R.id.chat_menu_group_delete, true);
            if (this.f5528aU == null || this.f5528aU.m8579h() == EnumC1731gd.SELECT_NONE) {
                this.f5547ap.findItem(R.id.chat_menu_delete_confirm).setEnabled(false);
            } else {
                this.f5547ap.findItem(R.id.chat_menu_delete_confirm).setEnabled(true);
            }
        } else {
            this.f5547ap.setGroupVisible(R.id.chat_menu_group, true);
            this.f5547ap.setGroupVisible(R.id.chat_menu_group_delete, false);
        }
        m7863S();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f5547ap = menu;
        if (this.f5547ap != null) {
            if (this.f5547ap.findItem(R.id.chat_menu_trunk) != null) {
                C4880cr.m18526b(this.f5547ap.findItem(R.id.chat_menu_trunk));
                C4880cr.m18524a(this.f5547ap.findItem(R.id.chat_menu_trunk), false);
            }
            if (this.f5547ap.findItem(R.id.chat_menu_livepartner) != null) {
                C4880cr.m18526b(this.f5547ap.findItem(R.id.chat_menu_livepartner));
                C4880cr.m18524a(this.f5547ap.findItem(R.id.chat_menu_livepartner), false);
            }
            m7861R();
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        if (C4904y.f17873c) {
            C4904y.m18641c("onPrepareOptionsMenu called", f5461a);
        }
        super.onPrepareOptionsMenu(menu);
        boolean zM777j = C2349a.m10301a("chatroom_draw_menu_feature") ? this.f5686dY.m777j(this.f5722ea) : false;
        MenuItem menuItemFindItem = menu.findItem(R.id.chat_menu_info);
        if (menuItemFindItem != null) {
            if (this.f5637ca == EnumC2301u.LIVE) {
                menu.removeItem(R.id.chat_menu_info);
            } else {
                if (!this.f5753y) {
                    menuItemFindItem.setEnabled(false);
                } else {
                    menuItemFindItem.setEnabled(this.f5560bB);
                }
                C4880cr.m18523a(menuItemFindItem);
                menuItemFindItem.setVisible(!zM777j);
            }
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.chat_menu_delete);
        if (this.f5487D == EnumC2300t.TOPIC) {
            menu.removeItem(R.id.chat_menu_delete);
        } else if (menuItemFindItem2 != null) {
            if (this.f5753y && m8006aZ()) {
                menuItemFindItem2.setEnabled(true);
            } else {
                menuItemFindItem2.setEnabled(false);
            }
            C4880cr.m18523a(menuItemFindItem2);
            menuItemFindItem2.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem3 = menu.findItem(R.id.chat_menu_setting);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setEnabled(true);
            C4880cr.m18523a(menuItemFindItem3);
            menuItemFindItem3.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem4 = menu.findItem(R.id.chat_menu_closechat);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setEnabled(this.f5753y);
            C4880cr.m18523a(menuItemFindItem4);
            menuItemFindItem4.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem5 = menu.findItem(R.id.chat_menu_forward);
        if (this.f5487D == EnumC2300t.TOPIC) {
            menu.removeItem(R.id.chat_menu_forward);
        } else if (menuItemFindItem5 != null) {
            if (this.f5753y && m8006aZ()) {
                menuItemFindItem5.setEnabled(true);
            } else {
                menuItemFindItem5.setEnabled(false);
            }
            C4880cr.m18523a(menuItemFindItem5);
            menuItemFindItem5.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem6 = menu.findItem(R.id.chat_menu_invitebuddy);
        if (menuItemFindItem6 != null) {
            if (this.f5487D == EnumC2300t.MONOLOGUE || this.f5637ca == EnumC2301u.LIVE || this.f5487D == EnumC2300t.TOPIC) {
                menu.removeItem(R.id.chat_menu_invitebuddy);
            } else {
                menuItemFindItem6.setEnabled(this.f5560bB);
            }
            C4880cr.m18523a(menuItemFindItem6);
            menuItemFindItem6.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem7 = menu.findItem(R.id.chat_menu_alert);
        if (menuItemFindItem7 != null) {
            if (EnumC2300t.m10208a(this.f5487D) || this.f5487D == EnumC2300t.MONOLOGUE) {
                menu.removeItem(R.id.chat_menu_alert);
            } else if (this.f5563bE) {
                menuItemFindItem7.setTitle(R.string.chaton_live_buddy_alert_off).setIcon(R.drawable.more_option_alert_off_white);
            } else {
                menuItemFindItem7.setTitle(R.string.chaton_live_buddy_alert_on).setIcon(R.drawable.more_option_alert_white);
            }
            if (!this.f5753y) {
                menuItemFindItem7.setEnabled(false);
            } else {
                menuItemFindItem7.setEnabled(this.f5560bB);
            }
            C4880cr.m18523a(menuItemFindItem7);
            menuItemFindItem7.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem8 = menu.findItem(R.id.chat_menu_translate);
        if (menuItemFindItem8 != null) {
            if ((this.f5487D == EnumC2300t.ONETOONE || this.f5487D == EnumC2300t.TOPIC || this.f5487D == EnumC2300t.GROUPCHAT) && this.f5637ca == EnumC2301u.NORMAL && this.f5698dm) {
                if (!this.f5753y) {
                    menuItemFindItem8.setEnabled(false);
                } else {
                    menuItemFindItem8.setEnabled(this.f5560bB);
                }
                C4880cr.m18523a(menuItemFindItem8);
                menuItemFindItem8.setVisible(!zM777j);
            } else {
                menu.removeItem(R.id.chat_menu_translate);
            }
        }
        MenuItem menuItemFindItem9 = menu.findItem(R.id.chat_menu_export);
        if (menuItemFindItem9 != null) {
            if (this.f5487D == EnumC2300t.TOPIC) {
                menu.removeItem(R.id.chat_menu_export);
            } else {
                if (this.f5753y && m8006aZ()) {
                    menuItemFindItem9.setEnabled(true);
                } else {
                    menuItemFindItem9.setEnabled(false);
                }
                C4880cr.m18523a(menuItemFindItem9);
                menuItemFindItem9.setVisible(!zM777j);
            }
        }
        boolean zM12153h = C2923b.m12153h(getActivity());
        if (zM12153h && (this.f5487D != EnumC2300t.MONOLOGUE || this.f5637ca != EnumC2301u.LIVE || this.f5487D != EnumC2300t.TOPIC)) {
            MenuItem menuItemFindItem10 = menu.findItem(R.id.chat_menu_chatonvoice);
            if (menuItemFindItem10 != null) {
                if (!(this.f5588bd.size() > 0 ? m8152g(false) : false)) {
                    menu.removeItem(R.id.chat_menu_chatonvoice);
                }
                C4880cr.m18523a(menuItemFindItem10);
                menuItemFindItem10.setVisible(!zM777j);
            }
        } else {
            menu.removeItem(R.id.chat_menu_chatonvoice);
        }
        if (zM12153h && (this.f5487D != EnumC2300t.MONOLOGUE || this.f5637ca != EnumC2301u.LIVE || this.f5487D != EnumC2300t.TOPIC)) {
            MenuItem menuItemFindItem11 = menu.findItem(R.id.chat_menu_chatonvideo);
            if (menuItemFindItem11 != null) {
                if (!(this.f5588bd.size() > 0 ? m8152g(true) : false)) {
                    menu.removeItem(R.id.chat_menu_chatonvideo);
                }
                C4880cr.m18523a(menuItemFindItem11);
                menuItemFindItem11.setVisible(zM777j ? false : true);
            }
        } else {
            menu.removeItem(R.id.chat_menu_chatonvideo);
        }
        if (this.f5637ca != EnumC2301u.NORMAL || this.f5487D == EnumC2300t.TOPIC) {
            menu.removeItem(R.id.chat_menu_invitebuddy);
            menu.removeItem(R.id.chat_menu_chatonvoice);
            menu.removeItem(R.id.chat_menu_chatonvideo);
        }
        if (!zM777j) {
            m7861R();
        }
    }

    /* renamed from: S */
    private void m7863S() {
        if (this.f5547ap == null) {
            C4904y.m18641c("mChatRoomMenu is null", f5461a);
            return;
        }
        boolean zM777j = C2349a.m10301a("chatroom_draw_menu_feature") ? this.f5686dY.m777j(this.f5722ea) : false;
        MenuItem menuItemFindItem = this.f5547ap.findItem(R.id.chat_menu_trunk);
        if (menuItemFindItem != null) {
            if (this.f5605bu > 0) {
                C4880cr.m18524a(menuItemFindItem, true);
            } else {
                C4880cr.m18524a(menuItemFindItem, false);
            }
            if (this.f5487D == EnumC2300t.TOPIC || this.f5487D == EnumC2300t.BROADCAST || (this.f5646cj != null && this.f5646cj.isShown())) {
                menuItemFindItem.setVisible(false);
            }
            MenuItem menuItemFindItem2 = this.f5547ap.findItem(R.id.chat_menu_livepartner);
            if (this.f5637ca == EnumC2301u.LIVE) {
                menuItemFindItem.setVisible(false);
                if (this.f5640cd != null && this.f5640cd.m7096b()) {
                    if (C2349a.m10301a("chatroom_draw_menu_feature")) {
                        menuItemFindItem2.setVisible(!zM777j);
                    }
                    if (this.f5606bv > 0) {
                        C4880cr.m18524a(menuItemFindItem2, true);
                    } else {
                        C4880cr.m18524a(menuItemFindItem2, false);
                    }
                    if (this.f5646cj != null && this.f5646cj.isShown()) {
                        menuItemFindItem2.setVisible(false);
                        return;
                    }
                    return;
                }
                menuItemFindItem2.setVisible(false);
                return;
            }
            menuItemFindItem2.setVisible(false);
            if (C2349a.m10301a("chatroom_draw_menu_feature")) {
                menuItemFindItem.setVisible(zM777j ? false : true);
            }
        }
    }

    /* renamed from: T */
    private void m7865T() {
        if (C4904y.f17872b) {
            C4904y.m18639b("removeTrunkMenu is called", f5461a);
        }
        if (this.f5547ap == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("mChatRoomMenu is null", f5461a);
                return;
            }
            return;
        }
        MenuItem menuItemFindItem = this.f5547ap.findItem(R.id.chat_menu_trunk);
        if (menuItemFindItem != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("trunkMenu will be hidden", f5461a);
            }
            menuItemFindItem.setVisible(false);
        }
        MenuItem menuItemFindItem2 = this.f5547ap.findItem(R.id.chat_menu_livepartner);
        if (menuItemFindItem2 != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("contentsMenu will be hidden", f5461a);
            }
            menuItemFindItem2.setVisible(false);
        }
    }

    /* renamed from: U */
    private void m7867U() {
        if (this.f5624cN != null) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f5624cN);
            if (this.f5688da == null) {
                this.f5688da = layoutInflaterFrom.inflate(R.layout.actionbar_custom_layout_chatroom, (ViewGroup) null, false);
            }
            ((ActionBarFragmentActivity) this.f5624cN).m18784t().mo18820a(this.f5688da);
            if (this.f5692de == null) {
                this.f5692de = (TextView) this.f5688da.findViewById(R.id.chatroom_custom_title);
            }
            if (this.f5691dd == null) {
                this.f5691dd = (ViewGroup) this.f5688da.findViewById(R.id.subtitle_group);
            }
            if (this.f5693df == null) {
                this.f5693df = (TextView) this.f5688da.findViewById(R.id.chatroom_custom_sub_title);
            }
            if (this.f5566bH == null) {
                this.f5566bH = (ImageView) this.f5688da.findViewById(R.id.image_typing);
                if (this.f5566bH != null) {
                    this.f5566bH.setBackgroundResource(R.drawable.typing_icon_02);
                }
            }
            if (this.f5690dc == null) {
                this.f5690dc = (ImageView) this.f5688da.findViewById(R.id.title_alert_off_indicator);
            }
            if (this.f5694dg == null) {
                this.f5694dg = (LinearLayout) this.f5688da.findViewById(R.id.chatroom_custom_layout);
                if (this.f5637ca != EnumC2301u.LIVE) {
                    this.f5694dg.setFocusable(true);
                    this.f5694dg.setPadding(3, 0, 0, 0);
                    this.f5694dg.setOnClickListener(new ViewOnClickListenerC1556ac(this));
                }
            }
            if (this.f5689db == null) {
                this.f5689db = layoutInflaterFrom.inflate(R.layout.actionbar_custom_layout_anicon, (ViewGroup) null, false);
            }
            ((ActionBarFragmentActivity) this.f5624cN).m18784t().mo18836e(23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m7869V() {
        if (this.f5560bB && this.f5753y && this.f5595bk != null && !this.f5509aB) {
            Intent intent = new Intent(this.f5624cN, (Class<?>) ChatInfoActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 6);
            String str = this.f5595bk;
            intent.putExtra(f5472h, this.f5753y);
            intent.putExtra(f5469e, str);
            intent.putExtra("inboxNO", this.f5750v);
            intent.putExtra("chatType", this.f5487D.m10210a());
            intent.putExtra(f5474j, this.f5583bY);
            intent.putExtra("buddyNO", this.f5752x);
            intent.putExtra("inboxValid", this.f5560bB);
            intent.putExtra(f5476l, this.f5563bE);
            intent.putExtra("ACTIVITY_PURPOSE_ARG", true);
            synchronized (this.f5545an) {
                intent.putExtra(f5465d, this.f5588bd);
            }
            intent.putExtra("contact_receivers_id", this.f5589be);
            intent.putExtra("contact_receivers_phone", this.f5590bf);
            intent.putExtra("inbox_title_fixed", this.f5598bn);
            intent.putExtra("inbox_is_change_skin", this.f5754z);
            intent.putExtra("inbox_background_style", this.f5567bI);
            intent.putExtra("inbox_send_bubble_style", this.f5570bL);
            intent.putExtra("inbox_receive_bubble_style", this.f5571bM);
            if (!TextUtils.isEmpty(this.f5658cv)) {
                intent.putExtra("groupId", this.f5658cv);
            }
            intent.putExtra("sessionID", this.f5488E);
            intent.addFlags(67108864);
            intent.putExtra("roomType", this.f5637ca.m10212a());
            if (this.f5487D == EnumC2300t.TOPIC && this.f5604bt != null) {
                intent.putExtra("topicChatCtid", this.f5604bt.ctid);
                intent.putExtra("topicChatChannelName", this.f5604bt.channelname);
                intent.putExtra("topicChatLiveId", this.f5604bt.suid);
            }
            startActivityForResult(intent, 17);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z;
        View viewInflate;
        String str;
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.chat_menu_invitebuddy /* 2131166626 */:
                int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(this.f5624cN, R.string.popup_no_network_connection, 0).show();
                } else if (this.f5560bB) {
                    Uri uriM10160a = C2289i.m10160a();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f5588bd);
                    arrayList.addAll(this.f5589be);
                    String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (strArr.length <= 0) {
                        str = "";
                    } else {
                        String str2 = "buddy_no NOT IN ( ";
                        for (String str3 : strArr) {
                            stringBuffer.append(", '" + str3 + "'");
                        }
                        str = (str2 + stringBuffer.toString().substring(1) + " )") + " AND ";
                    }
                    this.f5546ao.startQuery(13, null, uriM10160a, null, str + "buddy_contact_buddy = 0", null, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
                }
                return true;
            case R.id.chat_menu_info /* 2131166627 */:
                m7869V();
                return true;
            case R.id.chat_menu_alert /* 2131166628 */:
                if (this.f5563bE) {
                    C2198l.m9913a(GlobalApplication.m18732r().getContentResolver(), this.f5750v, false);
                    this.f5563bE = false;
                } else {
                    C2198l.m9913a(GlobalApplication.m18732r().getContentResolver(), this.f5750v, true);
                    this.f5563bE = true;
                }
                m8157h(this.f5563bE);
                return true;
            case R.id.chat_menu_translate /* 2131166629 */:
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
                abstractC4932aM18733a.mo18742a(true);
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f5624cN);
                abstractC4932aM18733a.mo18734a(R.string.translate);
                C1505a c1505a = new C1505a();
                if (C1865r.m9070b()) {
                    View viewInflate2 = layoutInflaterFrom.inflate(R.layout.translate_popup_title, (ViewGroup) null);
                    c1505a.m8354a((Switch) viewInflate2.findViewById(R.id.translate_switch));
                    viewInflate = viewInflate2;
                } else {
                    viewInflate = layoutInflaterFrom.inflate(R.layout.layout_translate_title, (ViewGroup) null);
                }
                TextView textView = (TextView) viewInflate.findViewById(R.id.title);
                textView.setSelected(true);
                View viewM7886a = m7886a(layoutInflaterFrom, false, c1505a);
                CheckBox checkBox = (CheckBox) viewM7886a.findViewById(R.id.checkbox_translate_incoming_msg);
                CheckBox checkBox2 = (CheckBox) viewM7886a.findViewById(R.id.only_below_ics_checkbox_translate_incoming_msg);
                View viewFindViewById = viewM7886a.findViewById(R.id.linearlayout_translate_incoming_msg);
                Spinner spinner = (Spinner) viewM7886a.findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner) viewM7886a.findViewById(R.id.spinner2);
                C1850c c1850cM9024d = C1850c.m9024d();
                abstractC4932aM18733a.mo18748b(viewM7886a);
                abstractC4932aM18733a.mo18738a(viewInflate);
                textView.setText(R.string.translate);
                if (C1865r.m9070b()) {
                    checkBox.setOnClickListener(new ViewOnClickListenerC1557ad(this, c1505a, checkBox));
                } else {
                    checkBox2.setOnClickListener(new ViewOnClickListenerC1558ae(this, c1505a, checkBox2));
                }
                viewFindViewById.setSoundEffectsEnabled(false);
                viewFindViewById.setOnClickListener(new ViewOnClickListenerC1559af(this, checkBox, c1505a, checkBox2));
                spinner.setOnItemSelectedListener(new C1560ag(this, c1850cM9024d, spinner, spinner2, checkBox, checkBox2));
                spinner2.setOnItemSelectedListener(new C1561ah(this, c1850cM9024d, spinner2));
                abstractC4932aM18733a.mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1562ai(this, c1505a, checkBox, checkBox2));
                abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1564ak(this));
                abstractC4932aM18733a.mo18752b();
                return true;
            case R.id.chat_menu_delete /* 2131166630 */:
                if (m8006aZ()) {
                    this.f5528aU.m8578g();
                    this.f5546ao.startQuery(12, null, C2306z.m10220b(this.f5750v), null, null, null, null);
                } else {
                    C5179v.m19810a(this.f5624cN, R.string.toast_no_delete_data, 0).show();
                }
                return true;
            case R.id.chat_menu_forward /* 2131166631 */:
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
                } else if (m7957aB()) {
                    new AsyncTaskC1677ed(this).execute(4);
                }
                return true;
            case R.id.chat_menu_export /* 2131166632 */:
                View viewInflate3 = ((LayoutInflater) this.f5624cN.getSystemService("layout_inflater")).inflate(R.layout.backup_dialog, (ViewGroup) null);
                CheckBox checkBox3 = (CheckBox) viewInflate3.findViewById(R.id.includeAttach);
                checkBox3.setOnClickListener(new ViewOnClickListenerC1565al(this));
                CharSequence[] charSequenceArr = {getString(R.string.option_save_to_device_memory), getString(R.string.option_send_email)};
                InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.backup).mo18751b(true).mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC1566am(this, checkBox3, charSequenceArr)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1567an(this)).mo18745a();
                ListView listViewMo18760b = interfaceC4936eMo18745a.mo18760b();
                listViewMo18760b.addFooterView(viewInflate3);
                listViewMo18760b.setItemsCanFocus(true);
                interfaceC4936eMo18745a.show();
                return true;
            case R.id.chat_menu_chatonvoice /* 2131166633 */:
                z = false;
                break;
            case R.id.chat_menu_chatonvideo /* 2131166634 */:
                z = true;
                break;
            case R.id.chat_menu_setting /* 2131166635 */:
                startActivityForResult(new Intent(this.f5624cN, (Class<?>) ActivityChat.class), 24);
                return true;
            case R.id.chat_menu_closechat /* 2131166636 */:
                f5483s = false;
                int iM10677a2 = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a2 || -2 == iM10677a2) {
                    C5179v.m19810a(this.f5624cN, R.string.popup_no_network_connection, 0).show();
                } else {
                    m8007aa();
                }
                return true;
            case R.id.chat_menu_trunk /* 2131166637 */:
                if (!C4847bl.m18333a()) {
                    m8181l(this.f5488E);
                    Intent intent = new Intent();
                    intent.setClass(GlobalApplication.m10279a(), TrunkActivity.class);
                    intent.putExtra("sessionId", this.f5488E);
                    intent.putExtra("inboxNO", this.f5750v);
                    intent.putExtra("isValid", this.f5560bB);
                    startActivity(intent);
                }
                return true;
            case R.id.chat_menu_livepartner /* 2131166638 */:
                mo8272q();
                if (!C4847bl.m18333a()) {
                    ((InterfaceC1668dv) getActivity()).mo7822g();
                }
                return true;
            case R.id.chat_menu_group_delete /* 2131166639 */:
            default:
                return true;
            case R.id.chat_menu_delete_cancel /* 2131166640 */:
                m8270o();
                return true;
            case R.id.chat_menu_delete_confirm /* 2131166641 */:
                m8047au();
                return true;
        }
        if (this.f5549ar == null) {
            C4904y.m18634a("ChatONV is not available", f5461a);
        } else if (m7875Y()) {
            if (m7871W()) {
                C4904y.m18639b("trying to connect " + (z ? "video" : "voice") + " call...", f5461a);
                mo8272q();
                if (this.f5487D == EnumC2300t.ONETOONE) {
                    if (this.f5549ar.m1487a(getActivity(), z, this.f5588bd.get(0), C4809aa.m18104a().m18121a("Push Name", ""), null) != 0) {
                        C5179v.m19810a(this.f5624cN, R.string.tellfriends_message_not_supported, 0).show();
                    }
                } else {
                    synchronized (this.f5545an) {
                        int iM1493b = this.f5549ar.m1493b(getActivity(), z) - 1;
                        if (this.f5588bd.size() > iM1493b) {
                            C4904y.m18639b("[ChatONV] participants limit exceed - " + (z ? "video" : "voice"), getClass().getSimpleName());
                            C5179v.m19811a(this.f5624cN, getResources().getString(R.string.chaton_buddies_voice_group_limit, Integer.valueOf(iM1493b)), 0).show();
                        } else if (this.f5549ar.m1488a(getActivity(), z, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), C4809aa.m18104a().m18121a("Push Name", ""), null, C2191e.m9868e(GlobalApplication.m10279a().getContentResolver(), this.f5658cv)) != 0) {
                            C5179v.m19810a(this.f5624cN, R.string.tellfriends_message_not_supported, 0).show();
                        }
                    }
                }
            } else {
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVInstallDialog.class));
            }
        } else if (!m7872X()) {
            startActivity(new Intent(getActivity(), (Class<?>) ChatONVRedirectDialog.class));
        }
        return true;
    }

    /* renamed from: W */
    private boolean m7871W() {
        boolean zM1495d;
        Exception e;
        try {
            zM1495d = this.f5549ar.m1495d(getActivity());
            try {
                C4904y.m18639b("[ChatONV] isReadyToCall : " + zM1495d, f5461a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f5461a);
                return zM1495d;
            }
        } catch (Exception e3) {
            zM1495d = false;
            e = e3;
        }
        C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f5461a);
        return zM1495d;
    }

    /* renamed from: X */
    private boolean m7872X() {
        boolean z = false;
        try {
            C0416a c0416a = this.f5549ar;
            if (C0416a.m1477b(getActivity())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVInstalled : " + z, f5461a);
        return z;
    }

    /* renamed from: Y */
    private boolean m7875Y() {
        boolean z = false;
        try {
            if (C2948h.m12190a().m12192a(getActivity(), EnumC2949i.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVAvaiable : " + z, f5461a);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7898a(DialogInterface.OnClickListener onClickListener, boolean z) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        abstractC4932aM18733a.mo18734a(R.string.menu_chat_delete);
        abstractC4932aM18733a.mo18746b(z ? R.string.confirm_delete_locked_message : R.string.confirm_delete_message);
        abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, onClickListener);
        abstractC4932aM18733a.mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7932a(C4108aq c4108aq) {
        Intent intentM15010a = C3892o.m15010a(this.f5624cN, 0L);
        intentM15010a.putExtra("forwarded_message", true);
        if (c4108aq.f15267b.equals("sms")) {
            intentM15010a.putExtra("sms_body", c4108aq.f15277l);
        } else {
            C5103z c5103z = new C5103z();
            c5103z.m19312a(c4108aq.m16305h().m14909b(this.f5624cN));
            try {
                intentM15010a.putExtra("msg_uri", C5097t.m19426a(this.f5624cN).m19447a(c5103z, C3960r.f14254a));
            } catch (C5111c e) {
                C3890m.m14999e(f5461a, "Failed to copy message: " + c4108aq.m16302e());
                Toast.makeText(this.f5624cN, R.string.cannot_save_message, 0).show();
                return;
            }
        }
        intentM15010a.setClassName(this.f5624cN, "com.sec.chaton.smsplugin.ui.ForwardMessageActivity");
        startActivity(intentM15010a);
    }

    /* renamed from: a */
    public void m8222a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Cursor cursorA = this.f5528aU.mo871a();
        C1730gc c1730gc = new C1730gc(cursorA);
        String string = cursorA.getString(c1730gc.f6497a);
        long j = cursorA.getLong(c1730gc.f6498b);
        C4108aq c4108aqM8557a = this.f5528aU.m8557a(string, j, cursorA);
        if (c4108aqM8557a == null) {
            C3890m.m14999e(f5461a, "Cannot load message item for type = " + string + ", msgId = " + j);
            return;
        }
        contextMenu.setHeaderTitle(R.string.search);
        MenuItemOnMenuItemClickListenerC1675eb menuItemOnMenuItemClickListenerC1675eb = new MenuItemOnMenuItemClickListenerC1675eb(this, c4108aqM8557a);
        if (c4108aqM8557a.m16312o() || (c4108aqM8557a.m16311n() && c4108aqM8557a.m16303f() == 0)) {
            contextMenu.add(0, 24, 0, R.string.chat_view_menu_copy).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
        }
        if (c4108aqM8557a.m16304g()) {
            contextMenu.add(0, 29, 0, R.string.menu_unlock).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
        } else {
            contextMenu.add(0, 28, 0, R.string.menu_lock).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
        }
        if (c4108aqM8557a.m16311n()) {
            if (c4108aqM8557a.m16299b() == EnumC2214ab.TEXT) {
                contextMenu.setHeaderTitle(R.string.media_text);
            } else if (c4108aqM8557a.m16299b() == EnumC2214ab.VIDEO) {
                contextMenu.setHeaderTitle(R.string.media_video);
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            } else if (c4108aqM8557a.m16299b() == EnumC2214ab.IMAGE) {
                contextMenu.setHeaderTitle(R.string.media_photo);
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            } else if (c4108aqM8557a.m16299b() == EnumC2214ab.CALENDAR) {
                contextMenu.setHeaderTitle(R.string.media_calendar);
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
                if (C3892o.m15024b(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 30, 0, C3892o.m15028d(c4108aqM8557a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            } else if (c4108aqM8557a.m16299b() == EnumC2214ab.AUDIO) {
                contextMenu.setHeaderTitle(R.string.media_voice);
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
                if (C3892o.m15024b(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 30, 0, C3892o.m15028d(c4108aqM8557a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            } else if (c4108aqM8557a.m16299b() == EnumC2214ab.CONTACT) {
                contextMenu.setHeaderTitle(R.string.media_contact);
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
                if (C3892o.m15024b(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 30, 0, C3892o.m15028d(c4108aqM8557a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            } else if (c4108aqM8557a.m16299b() == EnumC2214ab.GEO) {
                contextMenu.setHeaderTitle(R.string.layout_calendar_location);
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
                if (C3892o.m15024b(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 30, 0, C3892o.m15028d(c4108aqM8557a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            } else if (c4108aqM8557a.m16299b() == EnumC2214ab.ANICON) {
                contextMenu.setHeaderTitle(R.string.media_anicon);
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
                if (C3892o.m15024b(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 30, 0, C3892o.m15028d(c4108aqM8557a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            } else {
                if (C3892o.m15017a(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 25, 0, R.string.copy_to_sdcard).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
                if (C3892o.m15024b(c4108aqM8557a.f15268c)) {
                    contextMenu.add(0, 30, 0, C3892o.m15028d(c4108aqM8557a.f15268c)).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                }
            }
        }
        if (c4108aqM8557a.m16313p()) {
            contextMenu.add(0, 21, 0, C4822an.m18218a() ? R.string.menu_forward_via_message : R.string.menu_forward).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
        }
        if (c4108aqM8557a.m16313p() && C4822an.m18218a()) {
            if (c4108aqM8557a.m16305h() != null) {
                if (c4108aqM8557a.m16305h().size() == 1) {
                    if (c4108aqM8557a.m16305h().m14921j()) {
                        if (!c4108aqM8557a.m16305h().f13925a.get(0).m14869i()) {
                            contextMenu.add(0, 35, 0, R.string.menu_forward_via_chat).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                        }
                    } else if (c4108aqM8557a.m16305h().f13925a.size() == 1 && c4108aqM8557a.m16305h().f13925a.get(0).m14879s()) {
                        contextMenu.add(0, 35, 0, R.string.menu_forward_via_chat).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
                    }
                }
            } else {
                contextMenu.add(0, 35, 0, R.string.menu_forward_via_chat).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
            }
        }
        if (c4108aqM8557a.m16313p()) {
            contextMenu.add(0, 36, 0, R.string.share).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
        }
        contextMenu.add(0, 18, 0, R.string.delete_message).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1675eb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (!this.f5509aB && this.f5527aT != null) {
            ContextMenuC1056a contextMenuC1056a = new ContextMenuC1056a(this.f5624cN, contextMenu);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            if (C4822an.m18203M() && (adapterContextMenuInfo.targetView instanceof MessageListItem)) {
                m8222a(contextMenu, view, contextMenuInfo);
                return;
            }
            C1729gb c1729gb = (C1729gb) adapterContextMenuInfo.targetView.getTag();
            if (c1729gb != null && (c1729gb.f6421aL instanceof AbstractViewOnClickListenerC1514ah)) {
                AbstractViewOnClickListenerC1514ah abstractViewOnClickListenerC1514ah = (AbstractViewOnClickListenerC1514ah) c1729gb.f6421aL;
                contextMenuC1056a.setHeaderTitle(abstractViewOnClickListenerC1514ah.mo8368a(this.f5624cN));
                contextMenuC1056a.clear();
                boolean z = c1729gb.f6430aU == EnumC2216ad.WITHDRAW_SUCCESS;
                if (this.f5637ca == EnumC2301u.NORMAL && (abstractViewOnClickListenerC1514ah instanceof InterfaceC1549v)) {
                    int i = adapterContextMenuInfo.position;
                    if (abstractViewOnClickListenerC1514ah.mo8402p() && C2349a.m10301a("chat_message_withdraw")) {
                        Cursor cursor = (Cursor) this.f5527aT.getAdapter().getItem(i);
                        contextMenuC1056a.add(R.string.chat_view_menu_recall).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1568ao(this, abstractViewOnClickListenerC1514ah, cursor.getLong(cursor.getColumnIndex("_id"))));
                    }
                }
                if ((abstractViewOnClickListenerC1514ah instanceof InterfaceC1541n) && (!z || c1729gb.f6428aS)) {
                    InterfaceC1541n interfaceC1541n = (InterfaceC1541n) abstractViewOnClickListenerC1514ah;
                    if (interfaceC1541n.mo8390k()) {
                        contextMenuC1056a.add(R.string.chat_view_menu_copy).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1571ar(this, interfaceC1541n));
                    }
                }
                if (C2349a.m10301a("sms_feature") && C4822an.m18226c() && (abstractViewOnClickListenerC1514ah instanceof InterfaceC1545r) && !z) {
                    InterfaceC1545r interfaceC1545r = (InterfaceC1545r) abstractViewOnClickListenerC1514ah;
                    if (interfaceC1545r.mo8413o()) {
                        contextMenuC1056a.add(R.string.menu_forward_via_message).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1572as(this, interfaceC1545r));
                    }
                }
                if ((abstractViewOnClickListenerC1514ah instanceof InterfaceC1544q) && !z) {
                    InterfaceC1544q interfaceC1544q = (InterfaceC1544q) abstractViewOnClickListenerC1514ah;
                    if (interfaceC1544q.mo8373i()) {
                        int i2 = R.string.chatview_menu_forward;
                        if (C2349a.m10301a("sms_feature") && C4822an.m18226c()) {
                            i2 = R.string.menu_forward_via_chat;
                        }
                        contextMenuC1056a.add(i2).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1573at(this, interfaceC1544q));
                    }
                }
                if ((abstractViewOnClickListenerC1514ah instanceof InterfaceC1548u) && !z) {
                    InterfaceC1548u interfaceC1548u = (InterfaceC1548u) abstractViewOnClickListenerC1514ah;
                    if (interfaceC1548u.mo8412h()) {
                        contextMenuC1056a.add(R.string.live_partner_share).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1574au(this, interfaceC1548u));
                    }
                }
                if ((abstractViewOnClickListenerC1514ah instanceof InterfaceC1547t) && !z) {
                    InterfaceC1547t interfaceC1547t = (InterfaceC1547t) abstractViewOnClickListenerC1514ah;
                    if (interfaceC1547t.mo8415m() && C4873ck.m18500a()) {
                        contextMenuC1056a.add(R.string.save).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1576aw(this, interfaceC1547t));
                    }
                }
                if ((this.f5487D == EnumC2300t.ONETOONE || this.f5487D == EnumC2300t.TOPIC || this.f5487D == EnumC2300t.GROUPCHAT) && this.f5637ca == EnumC2301u.NORMAL && this.f5698dm && !z) {
                    EnumC2214ab enumC2214ab = c1729gb.f6420aK;
                    C1850c c1850cM9024d = C1850c.m9024d();
                    boolean zM8079b = m8079b(c1729gb);
                    String[] strArrSplit = c1729gb.f6422aM.split("\n");
                    if (!c1729gb.f6428aS && zM8079b && ("mixed".equals(strArrSplit[0]) || enumC2214ab == EnumC2214ab.TEXT)) {
                        contextMenuC1056a.add(R.string.translate).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1578ay(this, zM8079b, c1850cM9024d, c1729gb));
                    }
                }
                if ((abstractViewOnClickListenerC1514ah instanceof InterfaceC1543p) && !z) {
                    InterfaceC1543p interfaceC1543p = (InterfaceC1543p) abstractViewOnClickListenerC1514ah;
                    if (interfaceC1543p.mo8427m()) {
                        contextMenuC1056a.add(R.string.download_title).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1579az(this, interfaceC1543p));
                    }
                }
                if (abstractViewOnClickListenerC1514ah instanceof InterfaceC1542o) {
                    int i3 = adapterContextMenuInfo.position;
                    if (abstractViewOnClickListenerC1514ah.mo8369b()) {
                        contextMenuC1056a.add(R.string.chat_view_menu_delete).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1581ba(this, i3, abstractViewOnClickListenerC1514ah));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Intent m7884a(EnumC2214ab enumC2214ab, String str, String str2) {
        Intent intent = new Intent(this.f5624cN, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC2214ab.m10076a());
        intent.putExtra("inboxNO", this.f5750v);
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        intent.putExtra("chatType", this.f5487D.m10210a());
        intent.putExtra("is_forward_mode", true);
        return intent;
    }

    /* renamed from: a */
    public void m8229a(EnumC2214ab enumC2214ab, String str, String str2, String str3) {
        mo8272q();
        Intent intent = new Intent(this.f5624cN, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC2214ab.m10076a());
        intent.putExtra("inboxNO", this.f5750v);
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.GEO) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("forward_sender_name", str3);
        }
        intent.putExtra("chatType", this.f5487D.m10210a());
        startActivity(intent);
    }

    /* renamed from: a */
    public void m8220a(long j) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        abstractC4932aM18733a.mo18734a(R.string.ams_attention_title);
        abstractC4932aM18733a.mo18746b(R.string.contact_mapping_resend_message);
        abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1597be(this, j)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1596bd(this));
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: b */
    public void m8242b() {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        abstractC4932aM18733a.mo18734a(R.string.ams_attention_title);
        abstractC4932aM18733a.mo18746b(R.string.buddy_mapping_alert_message);
        abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1598bf(this));
        abstractC4932aM18733a.mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public void m7877Z() {
        if (this.f5495L == null || !this.f5495L.isShowing()) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
            abstractC4932aM18733a.mo18734a(R.string.menu_chat_close);
            abstractC4932aM18733a.mo18746b(R.string.close_chat_on_another_device);
            abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1599bg(this));
            this.f5495L = abstractC4932aM18733a.mo18745a();
            this.f5495L.show();
        }
    }

    /* renamed from: aa */
    private void m8007aa() {
        this.f5735en = new C2660e(getActivity(), this.f5750v, 7);
        this.f5735en.m11239a(new C2679x(this.f5750v, this.f5487D, this.f5488E, this.f5637ca, true), this.f5713eB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ab */
    public void m8010ab() {
        m7973aJ();
        m7833D();
        mo8272q();
        if (this.f5497N == null) {
            m7844J();
            this.f5497N = new DialogC2331a(this, this.f5498O);
        }
        if (!this.f5497N.isShowing()) {
            this.f5497N.show();
        }
    }

    /* renamed from: a */
    public void m8231a(File file, boolean z) {
        C4904y.m18639b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(this.f5624cN, (Class<?>) ImageModify.class);
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
    public void m8221a(Uri uri, boolean z) {
        C4904y.m18639b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(this.f5624cN, (Class<?>) ImageModify.class);
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
    public void m7936a(File file, String str, String str2, EnumC2214ab enumC2214ab, String str3) {
        m7938a(file, str, str2, enumC2214ab, str3, (String) null, (String) null, (String) null, true);
    }

    /* renamed from: a */
    private void m7937a(File file, String str, String str2, EnumC2214ab enumC2214ab, String str3, String str4) {
        m7938a(file, str, str2, enumC2214ab, str3, str4, (String) null, (String) null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m7938a(File file, String str, String str2, EnumC2214ab enumC2214ab, String str3, String str4, String str5, String str6, boolean z) {
        if (this.f5624cN != null) {
            if (file != null) {
                if (C4894o.m18601a(file, enumC2214ab, this.f5624cN) == EnumC4900u.NORMAL) {
                    if (C2471v.m10677a(this.f5624cN) != 0 && file.length() > 20971520 && !C4809aa.m18104a().m18119a("file_upload_warning_check", (Boolean) false).booleanValue()) {
                        if (this.f5624cN != null) {
                            C4894o.m18602a(this.f5624cN, new DialogInterfaceOnClickListenerC1601bi(this, file, str, str2, enumC2214ab, str3, str4, str5, str6, z)).mo18752b();
                            return;
                        }
                        return;
                    } else if (file.length() > 31457280) {
                        m7933a(file);
                        return;
                    }
                } else {
                    return;
                }
            }
            m8073b(file, str, str2, enumC2214ab, str3, str4, str5, str6, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m8073b(File file, String str, String str2, EnumC2214ab enumC2214ab, String str3, String str4, String str5, String str6, boolean z) {
        if (this.f5531aX != null) {
            if (this.f5637ca == EnumC2301u.NORMAL && ((TextUtils.isEmpty(this.f5488E) || this.f5487D == EnumC2300t.BROADCAST || "null".equals(this.f5488E)) && this.f5487D != EnumC2300t.BROADCAST && !C2717y.m11395a(this.f5637ca))) {
                m8274s();
            }
            this.f5527aT.setSelectionFromTop(this.f5527aT.getCount(), 0);
            this.f5527aT.setTranscriptMode(2);
            this.f5730ei = new C2756f(file, enumC2214ab, this.f5487D, this.f5488E, this.f5531aX, (String[]) this.f5588bd.toArray(new String[0]), this.f5637ca, str5, str6, z).m11573b(str).m11574c(str2).m11572a(str3).m11570a(this.f5624cN).m11575d(str4).m11571a(this.f5534aa).m11576e(this.f5750v).m11569a();
            if (Build.VERSION.SDK_INT < 11) {
                this.f5730ei.execute(new Void[0]);
            } else {
                this.f5730ei.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
            m8011ac();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m7933a(File file) {
        if (file != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_inbox_no", this.f5750v);
            contentValues.put("message_download_uri", file.getAbsolutePath());
            contentValues.putStringArrayList("receivers", this.f5588bd);
            if (Build.VERSION.SDK_INT < 11) {
                AsyncTaskC2389c.m10387a(1, contentValues, this.f5487D).execute(new Void[0]);
            } else {
                AsyncTaskC2389c.m10387a(1, contentValues, this.f5487D).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7949a(String[] strArr, String[] strArr2, String[] strArr3) {
        int i = 0;
        if (strArr != null) {
            synchronized (this.f5545an) {
                if (this.f5487D == EnumC2300t.ONETOONE) {
                    if (strArr != null && strArr.length > 0) {
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            this.f5588bd.add(strArr[i2]);
                            this.f5591bg.put(strArr[i2], new C0777a(strArr[i2]));
                        }
                    }
                    if (strArr2 != null && strArr2.length > 0) {
                        while (i < strArr2.length) {
                            this.f5589be.add(strArr2[i]);
                            i++;
                        }
                    }
                    Intent intent = new Intent(this.f5624cN, (Class<?>) ChatActivity.class);
                    intent.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
                    intent.putExtra("receivers", (String[]) this.f5588bd.toArray(new String[0]));
                    intent.putExtra("contact_receivers_id", (String[]) this.f5589be.toArray(new String[0]));
                    intent.putExtra("contact_receivers_phone", strArr3);
                    String string = this.f5564bF.getText().toString();
                    if (!TextUtils.isEmpty(string)) {
                        intent.putExtra("lastTempMessage", string);
                    }
                    startActivity(intent);
                    ((InterfaceC1668dv) getActivity()).mo7821f();
                } else if (this.f5487D == EnumC2300t.BROADCAST) {
                    if (!this.f5753y) {
                        if (this.f5588bd == null) {
                            this.f5588bd = new ArrayList<>();
                        }
                        this.f5591bg = new HashMap<>();
                        while (i < strArr.length) {
                            this.f5588bd.add(strArr[i]);
                            this.f5591bg.put(strArr[i], new C0777a(strArr[i]));
                            i++;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        while (i < strArr.length) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.INVITE.m10100a()), strArr[i], C1736gi.m8632a(C2190d.m9827c(this.f5624cN.getContentResolver(), strArr[i])))).append(Config.KEYVALUE_SPLIT);
                            C2176ab.m9688c(this.f5624cN.getContentResolver(), this.f5750v, strArr[i]);
                            this.f5588bd.add(strArr[i]);
                            this.f5591bg.put(strArr[i], new C0777a(strArr[i]));
                            i++;
                        }
                        C2204r.m10033a(this.f5546ao, 1, this.f5750v, sb.toString(), C4809aa.m18104a().m18121a("chaton_id", ""));
                    }
                    if (strArr2 != null && strArr2.length > 0 && C4904y.f17875e) {
                        C4904y.m18634a("setInvite() BR chatroom does not support invite contact buddy.", f5461a);
                    }
                    C2198l.m9949d(this.f5624cN.getContentResolver(), this.f5750v);
                    C0991aa.m6037a().m18962d(new C1015an(new String[]{this.f5750v}));
                } else {
                    if (strArr != null && strArr.length > 0) {
                        if (TextUtils.isEmpty(this.f5488E)) {
                            for (int i3 = 0; i3 < strArr.length; i3++) {
                                this.f5588bd.add(strArr[i3]);
                                this.f5591bg.put(strArr[i3], new C0777a(strArr[i3]));
                            }
                            C2198l.m9957j(this.f5624cN.getContentResolver(), this.f5750v);
                        } else {
                            if (this.f5531aX == null) {
                                m7855O();
                            }
                            if (this.f5487D == EnumC2300t.GROUPCHAT) {
                                if (this.f5531aX != null) {
                                    this.f5531aX.mo9226a(EnumC2214ab.TEXT, this.f5488E, (String[]) this.f5588bd.toArray(new String[0]), strArr);
                                }
                            } else if (this.f5487D == EnumC2300t.BROADCAST2 && this.f5531aX != null) {
                                this.f5531aX.mo9241a(this.f5488E, (String[]) this.f5588bd.toArray(new String[0]), strArr, true);
                            }
                            m8274s();
                        }
                    }
                    if (strArr2 != null && strArr2.length > 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int i4 = 0; i4 < strArr2.length; i4++) {
                            if (!this.f5589be.contains(strArr2[i4])) {
                                arrayList.add(strArr2[i4]);
                                arrayList2.add(strArr3[i4]);
                            }
                        }
                        if (arrayList.size() > 0) {
                            m7945a(arrayList, arrayList2);
                        } else if (C4904y.f17872b) {
                            C4904y.m18639b("setInvite() :: user invited some contact buddy but every contact buddy already invited on this room and do nothing.", f5461a);
                        }
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IOException {
        C4892m.m18584f(false);
        if (i2 == -1) {
            switch (i) {
                case 0:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Capture Picture", f5461a);
                    }
                    if (this.f5559bA != null) {
                        MediaScannerConnection.scanFile(this.f5624cN, new String[]{this.f5559bA.getPath()}, null, null);
                    }
                    if (this.f5637ca == null && this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else if (this.f5559bA != null) {
                        m8231a(new File(this.f5559bA.getPath()), true);
                        break;
                    }
                    break;
                case 1:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Crop picture", f5461a);
                    }
                    if (this.f5637ca == EnumC2301u.NORMAL && this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else if (intent != null && intent.getData() != null) {
                        this.f5546ao.startQuery(26, intent.getData(), intent.getData(), null, null, null, null);
                        break;
                    }
                    break;
                case 4:
                    m7949a(intent.getStringArrayExtra("receivers"), intent.getStringArrayExtra("contact_receivers_id"), intent.getStringArrayExtra("contact_receivers_phone"));
                    break;
                case 5:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Calendar", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8163i(intent);
                        break;
                    }
                case 6:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Geo tag", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8149g(intent);
                        break;
                    }
                case 7:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Contact", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8156h(intent);
                        break;
                    }
                case 9:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Voice", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8130d(intent);
                        break;
                    }
                case 11:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Video", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8170j(intent);
                        break;
                    }
                case 12:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Record Video", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8170j(intent);
                        break;
                    }
                case 15:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Animessage", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8065b(intent);
                        break;
                    }
                case 16:
                case 21:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Picture", f5461a);
                    }
                    if (this.f5637ca == EnumC2301u.NORMAL && this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else if (intent != null && intent.getExtras() != null) {
                        m7901a(intent.getExtras());
                        break;
                    }
                    break;
                case 17:
                    if (intent.hasExtra("isClosing")) {
                        Boolean boolValueOf = Boolean.valueOf(intent.getBooleanExtra("isMapping", false));
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("mappedSMS");
                        boolean booleanExtra = intent.getBooleanExtra("removeLockedSMS", false);
                        this.f5735en = new C2660e(getActivity(), this.f5750v, 7);
                        this.f5735en.m11240a(new C2680y(new C2679x(this.f5750v, this.f5487D, this.f5488E, this.f5637ca, boolValueOf), stringArrayListExtra, booleanExtra), this.f5713eB);
                        break;
                    } else {
                        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                        String[] stringArrayExtra2 = intent.getStringArrayExtra("contact_receivers_id");
                        String[] stringArrayExtra3 = intent.getStringArrayExtra("contact_receivers_phone");
                        this.f5579bU = intent.getStringExtra(f5472h);
                        this.f5583bY = intent.getBooleanExtra(f5474j, false);
                        C4904y.m18644d("mTmpTitle:" + this.f5601bq);
                        if (stringArrayExtra == null) {
                            C4904y.m18644d("null arrayResult");
                        } else {
                            C4904y.m18644d("Not null arrayResult");
                        }
                        if (this.f5583bY) {
                            C4904y.m18644d("mTmpTitle not null!!!");
                            this.f5601bq = this.f5579bU;
                            String str = this.f5601bq;
                            this.f5596bl = str;
                            this.f5692de.setText(str);
                            this.f5595bk = this.f5601bq;
                        }
                        m7949a(stringArrayExtra, stringArrayExtra2, stringArrayExtra3);
                        break;
                    }
                case 18:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Document", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8120c(intent);
                        break;
                    }
                case 19:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - S Note", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8136e(intent);
                        break;
                    }
                case 22:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Multiple Pictures", f5461a);
                    }
                    if (this.f5637ca == EnumC2301u.NORMAL && this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8174k(intent);
                        break;
                    }
                    break;
                case 25:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SendingMedia] Start - Glympse", f5461a);
                    }
                    if (this.f5531aX == null) {
                        m7899a(intent, i);
                        break;
                    } else {
                        m8144f(intent);
                        break;
                    }
                case 201:
                    if (i2 == -1) {
                        String stringExtra = intent.getStringExtra("source_language");
                        String stringExtra2 = intent.getStringExtra("source_text");
                        String stringExtra3 = intent.getStringExtra("target_language");
                        String stringExtra4 = intent.getStringExtra("target_text");
                        if (!TextUtils.isEmpty(stringExtra4)) {
                            m7941a(stringExtra2, stringExtra4, stringExtra, stringExtra3);
                        } else {
                            this.f5564bF.setText(f5466dE);
                            this.f5564bF.setSelection(f5466dE.length());
                        }
                        this.f5666dD = true;
                    }
                    if (this.f5636cZ) {
                        m8218a();
                        break;
                    }
                    break;
            }
            return;
        }
        if (i == 201 && i2 == 0) {
            this.f5666dD = true;
            this.f5564bF.setText(f5466dE);
            this.f5564bF.setSelection(f5466dE.length());
            if (this.f5636cZ) {
                m8218a();
                return;
            }
            return;
        }
        if (!m7950a(i, intent)) {
            if (i == 24) {
                if (this.f5528aU != null) {
                    m8044as();
                    this.f5528aU.m8560a(m7985aP(), m7983aO(), this.f5570bL, this.f5571bM);
                    return;
                }
                return;
            }
            C5179v.m19810a(this.f5624cN, R.string.cancel, 1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f5559bA != null) {
            bundle.putString("captureUri", this.f5559bA.toString());
        }
        if (!TextUtils.isEmpty(this.f5750v)) {
            bundle.putString("inbox_no", this.f5750v);
        }
        if (!TextUtils.isEmpty(this.f5488E)) {
            bundle.putString("session_id", this.f5488E);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8119c(int i) {
        if (i != 0) {
            getActivity().runOnUiThread(new RunnableC1604bl(this, i));
        }
    }

    /* renamed from: b */
    private void m8065b(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            boolean z = extras.getBoolean("AMS_WITH_TEXT", false);
            int i = extras.getInt("IS_AMS", 0);
            if (intent.getData() != null) {
                EnumC2214ab enumC2214ab = EnumC2214ab.IMAGE;
                if (i != 0) {
                    enumC2214ab = EnumC2214ab.AMS;
                }
                if (!z) {
                    m7938a((File) null, (String) null, (String) null, enumC2214ab, (String) null, intent.getData().toString(), (String) null, (String) null, enumC2214ab != EnumC2214ab.AMS);
                } else {
                    m7935a((File) null, enumC2214ab, (String) null, (String) null, false, intent.getData().toString());
                }
            }
        }
    }

    /* renamed from: c */
    private void m8120c(Intent intent) {
        File file = new File(intent.getData().getPath());
        m7938a(file, (String) null, (String) null, FileExplorerActivity.m11577a(FileExplorerActivity.m11581d(file.getName())), file.getName(), (String) null, (String) null, (String) null, false);
    }

    /* renamed from: d */
    private void m8130d(Intent intent) {
        if (intent != null) {
            m7936a(new File(intent.getData().getPath()), (String) null, (String) null, EnumC2214ab.AUDIO, (String) null);
        }
    }

    /* renamed from: e */
    private void m8136e(Intent intent) {
        Object obj = intent.getExtras().get("android.intent.extra.STREAM");
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.size() > 0) {
                File file = new File(((Uri) arrayList.get(0)).getPath());
                m7936a(file, (String) null, (String) null, EnumC2214ab.IMAGE, file.getName());
            }
        }
    }

    /* renamed from: f */
    private void m8144f(Intent intent) {
        String strM11410a = C2722d.m11410a(intent);
        if ((TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E)) && this.f5487D != EnumC2300t.BROADCAST) {
            m8274s();
        }
        synchronized (this.f5545an) {
            this.f5531aX.m9218a(EnumC2214ab.GLYMPSE, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), strM11410a);
        }
    }

    /* renamed from: g */
    private void m8149g(Intent intent) {
        if (intent != null && intent.getStringExtra("GEOPOINT") != null) {
            boolean z = false;
            if (this.f5637ca == EnumC2301u.NORMAL && (TextUtils.isEmpty(this.f5488E) || this.f5487D == EnumC2300t.BROADCAST || "null".equals(this.f5488E))) {
                if (this.f5487D != EnumC2300t.BROADCAST && !C2717y.m11395a(this.f5637ca)) {
                    m8274s();
                }
                z = true;
            }
            synchronized (this.f5545an) {
                this.f5531aX.m9235a(this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, intent.getStringExtra("GEOPOINT"), intent.getStringExtra("GEOADDRESS"));
            }
        }
    }

    /* renamed from: h */
    private void m8156h(Intent intent) {
        if (intent != null) {
            m7936a(new File(intent.getStringExtra(f5464c)), (String) null, (String) null, EnumC2214ab.CONTACT, intent.getStringExtra(f5471g));
        }
    }

    /* renamed from: i */
    private void m8163i(Intent intent) {
        if (intent != null) {
            m7936a(new File(intent.getStringExtra(f5464c)), (String) null, (String) null, EnumC2214ab.CALENDAR, intent.getStringExtra(f5470f));
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: j */
    private void m8170j(Intent intent) {
        if (intent != null && intent.getData() != null) {
            this.f5546ao.startQuery(25, null, intent.getData(), null, null, null, null);
        }
    }

    /* renamed from: k */
    private void m8174k(Intent intent) {
        if (intent != null) {
            this.f5623cM = intent.getParcelableArrayListExtra("preview_data");
            new AsyncTaskC1676ec(this, null).execute(new Void[0]);
        }
    }

    /* renamed from: a */
    private void m7899a(Intent intent, int i) {
        try {
            this.f5661cy = intent;
            if (this.f5661cy == null) {
                this.f5661cy = new Intent();
            }
            this.f5661cy.putExtra("requestCode", i);
        } catch (Exception e) {
            C4904y.m18635a(e, f5461a);
        }
    }

    /* renamed from: a */
    private boolean m7950a(int i, Intent intent) {
        switch (i) {
            case 16:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m8030al();
                    return true;
                }
                break;
            case 21:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m8027ak();
                    return true;
                }
                break;
        }
        return false;
    }

    /* renamed from: a */
    private void m7901a(Bundle bundle) {
        File file = new File(bundle.getString("temp_file_path"));
        if (bundle.getBoolean("sendWithText", false)) {
            m7934a(file, EnumC2214ab.IMAGE, (String) null, (String) null, false);
        } else {
            m7936a(file, (String) null, (String) null, EnumC2214ab.IMAGE, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public File m7895a(String str, boolean z, boolean z2) {
        File file;
        if ("content".equals(Uri.parse(str).getScheme())) {
            C4899t c4899tM18615c = C4894o.m18615c(str);
            file = c4899tM18615c != null ? c4899tM18615c.f17859a : null;
        } else {
            file = new File(str);
        }
        if (file != null && !z2) {
            if (!z) {
                m7936a(file, (String) null, (String) null, EnumC2214ab.IMAGE, (String) null);
            } else {
                m7934a(file, EnumC2214ab.IMAGE, (String) null, (String) null, false);
            }
        }
        return file;
    }

    /* renamed from: a */
    public void m8230a(EnumC2214ab enumC2214ab, String str, String str2, String str3, String str4) {
        boolean z = false;
        if (this.f5637ca == EnumC2301u.NORMAL && (TextUtils.isEmpty(this.f5488E) || this.f5487D == EnumC2300t.BROADCAST || "null".equals(this.f5488E))) {
            if (this.f5487D != EnumC2300t.BROADCAST && !C2717y.m11395a(this.f5637ca)) {
                m8274s();
            }
            z = true;
        }
        if (this.f5508aA) {
            m7939a(this.f5550as, z, this.f5510aC, this.f5511aD, this.f5564bF.getText().toString().trim(), this.f5551at);
            m8011ac();
        }
        switch (C1791m.f6703b[enumC2214ab.ordinal()]) {
            case 3:
                if (this.f5531aX == null) {
                    m7855O();
                }
                this.f5531aX.m9233a(this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, this.f5609by, -1L, this.f5564bF.getText().toString().trim(), str2, str3, str4);
                m8011ac();
                break;
            case 5:
            case 7:
                m7938a(this.f5550as, str.trim(), str2, this.f5551at, (String) null, this.f5512aE, str3, str4, true);
                break;
            case 6:
                m7938a((File) null, str.trim(), str2, EnumC2214ab.AMS, (String) null, this.f5512aE, str3, str4, false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ac */
    public void m8011ac() {
        this.f5554aw.setVisibility(8);
        this.f5556ay.setVisibility(8);
        this.f5548aq = false;
        this.f5550as = null;
        this.f5551at = null;
        this.f5510aC = null;
        this.f5511aD = null;
        this.f5508aA = false;
        this.f5512aE = null;
        if (TextUtils.isEmpty(this.f5564bF.getText().toString())) {
            this.f5641ce.setEnabled(false);
            this.f5642cf.setEnabled(false);
            if (m8277v()) {
                this.f5641ce.setVisibility(8);
                this.f5662cz.setVisibility(0);
                this.f5642cf.setVisibility(8);
            } else if (this.f5698dm && this.f5699dn && !this.f5700do) {
                this.f5642cf.setVisibility(0);
                this.f5662cz.setVisibility(8);
                this.f5641ce.setVisibility(8);
            } else {
                this.f5641ce.setVisibility(0);
                this.f5642cf.setVisibility(8);
                this.f5662cz.setVisibility(8);
            }
        }
        this.f5555ax.setOnClickListener(null);
        this.f5556ay.setOnClickListener(null);
        this.f5609by = null;
        m7859Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7934a(File file, EnumC2214ab enumC2214ab, String str, String str2, boolean z) {
        m7935a(file, enumC2214ab, str, str2, z, (String) null);
    }

    /* renamed from: a */
    private void m7935a(File file, EnumC2214ab enumC2214ab, String str, String str2, boolean z, String str3) {
        String path;
        String strValueOf;
        if (str3 != null) {
            strValueOf = String.valueOf(str3.hashCode());
            path = str3.toString();
        } else if (file != null) {
            strValueOf = file.getPath() + file.lastModified();
            path = file.getPath();
        } else {
            path = null;
            strValueOf = null;
        }
        if (strValueOf != null) {
            if (enumC2214ab == EnumC2214ab.AMS) {
                this.f5659cw.m19023b(this.f5555ax, new C2815a(strValueOf, path, false));
            } else {
                this.f5659cw.m19023b(this.f5555ax, new C2844d(strValueOf, path, enumC2214ab != EnumC2214ab.VIDEO, false, enumC2214ab));
            }
            this.f5554aw.setVisibility(0);
            this.f5556ay.setVisibility(8);
            this.f5548aq = true;
            this.f5550as = file;
            this.f5551at = enumC2214ab;
            this.f5510aC = str;
            this.f5511aD = str2;
            this.f5508aA = z;
            this.f5512aE = str3;
            if (EnumC2214ab.AMS == enumC2214ab) {
                this.f5555ax.setOnClickListener(this.f5538ae);
            } else {
                this.f5555ax.setOnClickListener(null);
            }
            this.f5556ay.setOnClickListener(null);
            m8088bd();
            m8218a();
        }
    }

    /* renamed from: c */
    public void m8246c() {
        if (this.f5624cN != null && this.f5506Y == null) {
            this.f5506Y = new C1605bm(this, new Handler());
            this.f5624cN.getContentResolver().registerContentObserver(C2306z.f8229a, true, this.f5506Y);
            if (C4904y.f17873c) {
                C4904y.m18641c("registerContentObserver - message", f5461a);
            }
        }
    }

    /* renamed from: d */
    public void m8250d() {
        if (this.f5624cN != null && this.f5506Y != null) {
            this.f5624cN.getContentResolver().unregisterContentObserver(this.f5506Y);
            this.f5506Y = null;
            if (C4904y.f17873c) {
                C4904y.m18641c("unregisterContentObserver - message", f5461a);
            }
        }
    }

    /* renamed from: e */
    public void m8254e() {
        if (this.f5624cN != null && this.f5507Z == null) {
            this.f5507Z = new C1606bn(this, new Handler());
            this.f5624cN.getContentResolver().registerContentObserver(C2220ah.m10090b(this.f5750v), true, this.f5507Z);
            if (C4904y.f17873c) {
                C4904y.m18641c("registerContentObserver - participant", f5461a);
            }
        }
    }

    /* renamed from: f */
    public void m8258f() {
        if (this.f5624cN != null && this.f5507Z != null) {
            this.f5624cN.getContentResolver().unregisterContentObserver(this.f5507Z);
            this.f5507Z = null;
            if (C4904y.f17873c) {
                C4904y.m18641c("unregisterContentObserver - participant", f5461a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ad */
    public void m8014ad() {
        if (GlobalApplication.m10283b().getString(R.string.unknown).equals(this.f5595bk) && this.f5667dF && !TextUtils.isEmpty(this.f5668dG) && this.f5588bd.size() > 0) {
            this.f5591bg.get(this.f5588bd.get(0)).m3100b(this.f5668dG);
            this.f5595bk = this.f5668dG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m8126d(int i) {
        if (this.f5731ej == null) {
            return 0;
        }
        int iM14365j = this.f5731ej.m14365j() - i;
        if (C4904y.f17872b) {
            C4904y.m18639b("decreaseConversationMessageCount() conversation message count is " + iM14365j, f5461a);
        }
        this.f5731ej.m14351a(iM14365j > 0 ? iM14365j : 0);
        return iM14365j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7947a(boolean z, boolean z2) {
        if (z) {
            if (this.f5615cE != null && !z2) {
                this.f5615cE.m11426a("TRANS_FAIL");
                return;
            }
            return;
        }
        if (this.f5615cE != null && z2) {
            this.f5615cE.m11426a("RECV_SUCC");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ae */
    public void m8016ae() {
        this.f5527aT.setChoiceMode(0);
        if (m7989aR() != null) {
            this.f5747ez.m8774c();
        }
        this.f5527aT.clearChoices();
        if (this.f5560bB) {
            this.f5518aK.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ContentValues m7881a(Cursor cursor) {
        ContentValues contentValues = new ContentValues();
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToLast();
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            int i = cursor.getInt(cursor.getColumnIndex("message_type"));
            EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
            long j = cursor.getLong(cursor.getColumnIndex("message_time"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_sever_id"));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            contentValues.put("inbox_last_message", String.format("%d;%d;%s;%s", Integer.valueOf(i), Integer.valueOf(enumC2214abM10070a.m10076a()), C1736gi.m8632a(string), C1736gi.m8632a(string2)));
            contentValues.put("inbox_last_msg_no", string3);
            contentValues.put("inbox_last_time", Long.valueOf(j));
            contentValues.put("inbox_last_msg_sender", string4);
        } else {
            contentValues.put("inbox_last_message", "");
        }
        if (cursor != null) {
            m8121c(cursor);
        }
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: af */
    public void m8017af() {
        C4904y.m18639b("updateLastMsg", f5461a);
        this.f5546ao.startQuery(11, null, C2306z.m10218b(), null, "message_inbox_no = ? AND ( message_type = ? OR message_type = ? ) AND message_content_type != ?", new String[]{this.f5750v, String.valueOf(1), String.valueOf(2), String.valueOf(EnumC2214ab.SYSTEM.m10076a())}, "message_is_failed , message_time , _id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8132d(boolean z) {
        this.f5546ao.startQuery(11, Boolean.valueOf(z), C2306z.m10218b(), null, "message_inbox_no = ? AND ( message_type = ? OR message_type = ? ) AND message_content_type != ?", new String[]{this.f5750v, String.valueOf(1), String.valueOf(2), String.valueOf(EnumC2214ab.SYSTEM.m10076a())}, "message_is_failed , message_time , _id");
        C4904y.m18639b("updateLastMsg isForcedChatonUpdate : " + z, f5461a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: ag */
    public void m8019ag() {
        C1646d c1646d = null;
        if (this.f5625cO) {
            this.f5623cM.remove(0);
            if (Build.VERSION.SDK_INT < 11) {
                new AsyncTaskC1676ec(this, c1646d).execute(new Void[0]);
            } else {
                new AsyncTaskC1676ec(this, c1646d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
    }

    /* renamed from: b */
    private void m8074b(String str, String str2, String str3) {
        if (!this.f5548aq) {
            try {
                EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(Integer.parseInt(str));
                if (enumC2214abM10070a == EnumC2214ab.IMAGE || enumC2214abM10070a == EnumC2214ab.AMS || enumC2214abM10070a == EnumC2214ab.VIDEO) {
                    File file = new File(str2);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("restoreMediaFile uri:" + str2, f5461a);
                    }
                    if (file.exists()) {
                        if (!TextUtils.isEmpty(str3)) {
                            StringTokenizer stringTokenizer = new StringTokenizer(file.getName(), ".");
                            String strNextToken = null;
                            while (stringTokenizer.hasMoreTokens()) {
                                strNextToken = stringTokenizer.nextToken();
                            }
                            m7934a(file, enumC2214abM10070a, str3, strNextToken, true);
                            return;
                        }
                        m7934a(file, enumC2214abM10070a, (String) null, (String) null, false);
                        return;
                    }
                    return;
                }
                if (enumC2214abM10070a == EnumC2214ab.ANICON) {
                    mo8233a(str2, (String) null);
                }
            } catch (NumberFormatException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: g */
    public void m8261g() {
        String strTrim;
        String strSubstring;
        boolean z;
        if (this.f5581bW) {
            mo8272q();
            if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.TEXT) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(this.f5577bS)) {
                    sb.append("Original name : ").append(this.f5577bS).append("\n----------------\n");
                }
                if (!TextUtils.isEmpty(this.f5575bQ)) {
                    String string = sb.append(this.f5575bQ).toString();
                    if (string.length() > 10000) {
                        string = string.substring(0, 9999);
                        Toast.makeText(CommonApplication.m18732r(), R.string.toast_text_max_Length, 0).show();
                    }
                    if (this.f5584bZ == EnumC1094bm.API) {
                        if (this.f5637ca == EnumC2301u.NORMAL && (TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E))) {
                            if (this.f5487D != EnumC2300t.BROADCAST && !C2717y.m11395a(this.f5637ca)) {
                                m8274s();
                            }
                            synchronized (this.f5545an) {
                                this.f5531aX.mo9240a(this.f5750v, EnumC2214ab.m10070a(this.f5574bP), this.f5487D, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), string, (String) null);
                            }
                            return;
                        }
                        synchronized (this.f5545an) {
                            this.f5531aX.m9220a(EnumC2214ab.m10070a(this.f5574bP), this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), string, (String) null);
                        }
                        return;
                    }
                    CharSequence charSequenceM11709a = C2799k.m11709a(this.f5624cN, string, (int) C5034k.m19088a(30.0f));
                    this.f5564bF.setText(charSequenceM11709a);
                    this.f5564bF.setSelection(charSequenceM11709a.length());
                    return;
                }
                return;
            }
            if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.GEO) {
                if (TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E)) {
                    if (this.f5487D != EnumC2300t.BROADCAST) {
                        m8274s();
                    }
                    z = true;
                } else {
                    z = false;
                }
                synchronized (this.f5545an) {
                    this.f5531aX.m9236a(this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, this.f5575bQ, (String) null, EnumC2706n.f9699d);
                }
                return;
            }
            if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.APPLINK) {
                if ((TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E)) && this.f5487D != EnumC2300t.BROADCAST) {
                    m8274s();
                }
                synchronized (this.f5545an) {
                    this.f5531aX.m9228a(this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), this.f5575bQ, this.f5576bR);
                }
                return;
            }
            if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.LIVESHARE) {
                if ((TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E)) && this.f5487D != EnumC2300t.BROADCAST) {
                    m8274s();
                }
                synchronized (this.f5545an) {
                    this.f5531aX.m9261b(this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), this.f5575bQ, this.f5576bR);
                }
                return;
            }
            if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.LIVERECOMMEND) {
                if ((TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E)) && this.f5487D != EnumC2300t.BROADCAST) {
                    m8274s();
                }
                synchronized (this.f5545an) {
                    this.f5531aX.m9270c(this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), this.f5575bQ, this.f5576bR);
                }
                return;
            }
            if (EnumC2214ab.m10070a(this.f5574bP) != EnumC2214ab.LIVECONTENTS) {
                if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.GLYMPSE) {
                    if ((TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E)) && this.f5487D != EnumC2300t.BROADCAST) {
                        m8274s();
                    }
                    synchronized (this.f5545an) {
                        this.f5531aX.m9218a(EnumC2214ab.GLYMPSE, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), this.f5575bQ);
                    }
                    return;
                }
                if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.HUGEFILE) {
                    if ((TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E)) && this.f5487D != EnumC2300t.BROADCAST) {
                        m8274s();
                    }
                    synchronized (this.f5545an) {
                        this.f5531aX.m9218a(EnumC2214ab.HUGEFILE, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), this.f5575bQ);
                    }
                    return;
                }
                if (!C4873ck.m18500a()) {
                    C4904y.m18634a("[sendForward()] No sdcard", f5461a);
                    return;
                }
                C4904y.m18639b("Forward download_uri:" + this.f5575bQ, f5461a);
                C4904y.m18639b("Forward content:" + this.f5576bR, f5461a);
                String str = this.f5575bQ;
                boolean z2 = this.f5637ca == EnumC2301u.NORMAL && (TextUtils.isEmpty(this.f5488E) || "null".equals(this.f5488E));
                if (this.f5578bT) {
                    String[] strArrSplit = this.f5576bR != null ? this.f5576bR.split("\n") : null;
                    if (this.f5552au) {
                        m7948a(strArrSplit, (String) null);
                        return;
                    }
                    if (str != null) {
                        boolean z3 = (!C4873ck.m18500a() || CommonApplication.m18732r().getExternalFilesDir(null) == null || str.contains(CommonApplication.m18732r().getExternalFilesDir(null).getAbsolutePath())) ? false : true;
                        if ((strArrSplit != null && strArrSplit.length > 4) || z3) {
                            File file = str.startsWith("file") ? new File(Uri.parse(str).getPath()) : null;
                            if (file != null) {
                                String strSubstring2 = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                                if (z3 || strArrSplit.length <= 6 || !"mixed".equals(strArrSplit[0])) {
                                    strSubstring = null;
                                } else {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    for (int i = 6; i < strArrSplit.length; i++) {
                                        stringBuffer.append(strArrSplit[i] + "\n");
                                    }
                                    strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                                }
                                if (EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.IMAGE || EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.AMS || EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.VIDEO) {
                                    m7934a(file, EnumC2214ab.m10070a(this.f5574bP), this.f5576bR, strSubstring2.toUpperCase(), z3 ? false : true);
                                    if (!TextUtils.isEmpty(strSubstring)) {
                                        CharSequence charSequenceM11709a2 = C2799k.m11709a(this.f5624cN, strSubstring, (int) C5034k.m19088a(30.0f));
                                        this.f5564bF.setText(charSequenceM11709a2);
                                        try {
                                            this.f5564bF.setSelection(charSequenceM11709a2.length());
                                            return;
                                        } catch (Exception e) {
                                            C4904y.m18634a("Exception occurred while setting selection on edit text", getClass().getSimpleName());
                                            return;
                                        }
                                    }
                                    return;
                                }
                                if (z3) {
                                    m7937a(file, strSubstring, (String) null, EnumC2214ab.m10070a(this.f5574bP), this.f5576bR, str);
                                    return;
                                } else {
                                    m7939a(file, z2, this.f5576bR, strSubstring2, strSubstring, EnumC2214ab.m10070a(this.f5574bP));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f5647ck != null && this.f5647ck.containsKey("buddy_dragdata") && this.f5647ck.containsKey("key_clipdata")) {
                    if (this.f5647ck.getBoolean("buddy_dragdata", false)) {
                        ClipData clipData = (ClipData) this.f5647ck.getParcelable("key_clipdata");
                        if (this.f5672dK) {
                            m7951a(clipData, EnumC1665ds.EditTextSpace);
                            return;
                        } else {
                            m7951a(clipData, EnumC1665ds.ChatSpace);
                            return;
                        }
                    }
                    return;
                }
                if (str != null) {
                    File file2 = str.startsWith("file") ? new File(Uri.parse(str).getPath()) : null;
                    if ((this.f5584bZ == EnumC1094bm.API || EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.IMAGE || EnumC2214ab.m10070a(this.f5574bP) == EnumC2214ab.VIDEO) && !TextUtils.isEmpty(this.f5576bR)) {
                        String str2 = this.f5576bR;
                        strTrim = C2799k.m11709a(this.f5624cN, str2.length() > 10000 ? str2.substring(0, 9999) : str2, (int) C5034k.m19088a(30.0f)).toString().trim();
                    } else {
                        strTrim = null;
                    }
                    m7937a(file2, strTrim, (String) null, EnumC2214ab.m10070a(this.f5574bP), this.f5576bR, str);
                }
            }
        }
    }

    /* renamed from: a */
    private void m7948a(String[] strArr, String str) {
        if (strArr == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("token is null. return", f5461a);
                return;
            }
            return;
        }
        if (this.f5531aX == null) {
            m7855O();
        }
        String str2 = "";
        if (strArr.length > 1) {
            str2 = strArr[1];
        }
        String strSubstring = "";
        if (strArr.length > 2) {
            this.f5609by = C3460d.m13781c(strArr[2]);
            strSubstring = strArr[2].substring(0, (strArr[2].length() - this.f5609by.length()) - 1);
        }
        String str3 = "";
        if (strArr.length > 3) {
            str3 = strArr[3];
        }
        if (!TextUtils.isEmpty(this.f5576bR) && strArr.length > 6 && "mixed".equals(strArr[0])) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 6; i < strArr.length; i++) {
                stringBuffer.append(strArr[i] + "\n");
            }
            str = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
        }
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("message is null", f5461a);
        } else {
            C4904y.m18639b("message[" + str + "]", f5461a);
        }
        if (str2 != null && str2.length() > 0) {
            if (str2.equals("anicon")) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("anicon_id", this.f5609by);
                if (!TextUtils.isEmpty(str3)) {
                    contentValues.put("delegate_url", str3);
                }
                if (!TextUtils.isEmpty(strSubstring)) {
                    contentValues.put("cd_proxy_url", strSubstring);
                }
                contentValues.put("package_id", "-100");
                if (C4904y.f17872b) {
                    C4904y.m18639b("QUERY_INSERT_ANICON_ITEM_FOR_SHOP_FORWARD - is start", f5461a);
                }
                this.f5546ao.startInsert(23, str, C2255ba.f8038a, contentValues);
            } else if (C4904y.f17875e) {
                C4904y.m18634a("doForwardforShop() forwardType[" + str2 + "] is not handled and do nothing.", f5461a);
            }
        } else if (C4904y.f17875e) {
            C4904y.m18634a("doForwardforShop() forwardType has err!!!", f5461a);
        }
        this.f5552au = false;
    }

    /* renamed from: a */
    private void m7939a(File file, boolean z, String str, String str2, String str3, EnumC2214ab enumC2214ab) {
        if (this.f5637ca == EnumC2301u.NORMAL && z && this.f5487D != EnumC2300t.BROADCAST && !C2717y.m11395a(this.f5637ca)) {
            m8274s();
        }
        this.f5531aX.m9250a(file, z, str, str2, str3, enumC2214ab, this.f5588bd);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.layout_preview /* 2131165435 */:
                this.f5527aT.setSelection(this.f5527aT.getCount() - 1);
                m8265j();
                break;
            case R.id.btnAdd /* 2131165442 */:
                if (!C4847bl.m18333a()) {
                    if ((C2717y.m11395a(this.f5637ca) || m7960aC()) && m7962aD() && m7957aB()) {
                        m8010ab();
                        break;
                    }
                }
                break;
            case R.id.btnChatImage /* 2131165443 */:
                if (m7957aB()) {
                    if (!m7970aH()) {
                        m7971aI();
                        if (getResources().getConfiguration().orientation == 2) {
                            mo8272q();
                        }
                        this.f5527aT.setFocusable(false);
                        this.f5527aT.setItemsCanFocus(false);
                        this.f5527aT.setFocusable(false);
                        break;
                    } else {
                        m7973aJ();
                        this.f5527aT.setFocusable(true);
                        m7833D();
                        break;
                    }
                }
                break;
            case R.id.btnChatSend /* 2131165450 */:
                this.f5564bF.requestFocus();
                m8123c(this.f5564bF.getText().toString(), (String) null);
                break;
            case R.id.btnChatTranslate /* 2131165453 */:
                if (this.f5699dn) {
                    this.f5665dC = true;
                    C1850c c1850cM9024d = C1850c.m9024d();
                    if (!C2349a.m10301a("chaton_translator")) {
                        intent = new Intent();
                        intent.setAction("com.sec.android.app.translator.TRANSLATE");
                        intent.putExtra("do_not_use_select_result_dialog", true);
                        intent.putExtra("mode", "input");
                        String strM9038d = c1850cM9024d.m9038d(f5459P);
                        String strM9038d2 = c1850cM9024d.m9038d(f5460Q);
                        intent.putExtra("source_language", strM9038d);
                        intent.putExtra("source_text", this.f5564bF.getText().toString());
                        intent.putExtra("target_language", strM9038d2);
                        intent.putExtra("auto_start_translation", true);
                        f5466dE = this.f5564bF.getText().toString();
                        C4904y.m18639b("Source Lang Code(DB) : " + f5459P, f5461a);
                        C4904y.m18639b("Target Lang Code(DB) : " + f5460Q, f5461a);
                        C4904y.m18639b("Source Lang Code for S-Translator : " + strM9038d, f5461a);
                        C4904y.m18639b("Target Lang Code for S-Translator : " + strM9038d2, f5461a);
                    } else {
                        intent = new Intent(this.f5624cN, (Class<?>) TranslatorActivity.class);
                        intent.putExtra("source_language", f5459P);
                        intent.putExtra("source_text", this.f5564bF.getText().toString());
                        intent.putExtra("target_language", f5460Q);
                        f5466dE = this.f5564bF.getText().toString();
                        intent.putExtra("TRANSLATOR_INBOX_NO", this.f5750v);
                    }
                    C4904y.m18639b("Calling Intent for translator App: com.sec.android.app.translator.TRANSLATE", getClass().getSimpleName());
                    startActivityForResult(intent, 201);
                    this.f5636cZ = this.f5635cY;
                    break;
                } else {
                    m8123c(this.f5564bF.getText().toString(), (String) null);
                    break;
                }
        }
    }

    /* renamed from: a */
    private void m7942a(String str, String str2, boolean z) {
        if (C2717y.m11395a(this.f5637ca) || !m7960aC()) {
        }
        if (m7962aD()) {
            this.f5613cC = true;
            if (!z && !m7964aE() && !this.f5548aq) {
                this.f5564bF.setText("");
                return;
            }
            if (!z && this.f5548aq) {
                m8230a(this.f5551at, str, str2, (String) null, (String) null);
                return;
            }
            if (this.f5531aX == null) {
                if (m7855O()) {
                    if (!TextUtils.isEmpty(this.f5594bj)) {
                        this.f5531aX.mo9252a(this.f5750v, this.f5594bj, this.f5610bz);
                    } else {
                        this.f5531aX.mo9252a(this.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                    }
                } else {
                    return;
                }
            }
            synchronized (this.f5545an) {
                if (!C2142w.m9613f(this.f5488E) && !C2717y.m11395a(this.f5637ca) && this.f5637ca == EnumC2301u.NORMAL) {
                    if (this.f5487D != EnumC2300t.BROADCAST) {
                        m8274s();
                    }
                    this.f5531aX.mo9240a(this.f5750v, EnumC2214ab.TEXT, this.f5487D, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), str, str2);
                } else {
                    this.f5531aX.m9220a(EnumC2214ab.TEXT, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), str, str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8123c(String str, String str2) {
        boolean z = this.f5548aq;
        EnumC2214ab enumC2214ab = this.f5551at;
        String str3 = this.f5609by;
        m7942a(str, str2, false);
        new Thread(new RunnableC1615bw(this, str, z, enumC2214ab, str3)).start();
        m7973aJ();
        this.f5564bF.setText("");
        this.f5527aT.setSelectionFromTop(this.f5527aT.getCount(), 0);
        m8265j();
        m7833D();
        if (this.f5612cB != null) {
            this.f5612cB.m8815c();
        }
    }

    /* renamed from: a */
    private void m7944a(String str, String str2, boolean z, String str3, String str4) {
        if (C2717y.m11395a(this.f5637ca) || !m7960aC()) {
        }
        if (m7962aD()) {
            this.f5613cC = true;
            if (!z && !m7964aE() && !this.f5548aq) {
                this.f5564bF.setText("");
                return;
            }
            if (!z && this.f5548aq) {
                m8230a(this.f5551at, str, str2, str3, str4);
                m8011ac();
                return;
            }
            if (this.f5531aX == null) {
                if (m7855O()) {
                    if (!TextUtils.isEmpty(this.f5594bj)) {
                        this.f5531aX.mo9252a(this.f5750v, this.f5594bj, this.f5610bz);
                    } else {
                        this.f5531aX.mo9252a(this.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                    }
                } else {
                    return;
                }
            }
            synchronized (this.f5545an) {
                if (!C2142w.m9613f(this.f5488E) && !C2717y.m11395a(this.f5637ca) && this.f5637ca == EnumC2301u.NORMAL) {
                    if (this.f5487D != EnumC2300t.BROADCAST) {
                        m8274s();
                    }
                    this.f5531aX.mo9240a(this.f5750v, EnumC2214ab.TEXT, this.f5487D, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), str, str2);
                } else {
                    this.f5531aX.m9225a(EnumC2214ab.TEXT, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), str, str2, str3, str4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7941a(String str, String str2, String str3, String str4) throws IOException {
        m7944a(str, str2, false, str3, str4);
        C2797i.m11705a().m19003a(C2799k.m11710a(this.f5624cN, str), true);
        m7973aJ();
        this.f5564bF.setText("");
        this.f5527aT.setSelectionFromTop(this.f5527aT.getCount(), 0);
        m8265j();
        m7833D();
        if (this.f5612cB != null) {
            this.f5612cB.m8815c();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: a */
    public void mo8224a(View view, long j, boolean z) {
        CharSequence[] charSequenceArr;
        if (!C4847bl.m18333a() && this.f5560bB && m7962aD() && view != null && view.getParent() != null) {
            int positionForView = this.f5527aT.getPositionForView(view) - 1;
            Cursor cursorA = this.f5528aU.mo871a();
            cursorA.moveToPosition(positionForView);
            if (z && this.f5533aZ != 0 && this.f5657cu) {
                charSequenceArr = new CharSequence[]{GlobalApplication.m10283b().getString(R.string.view_resend), GlobalApplication.m10283b().getString(R.string.chat_send_sms), GlobalApplication.m10283b().getString(R.string.menu_chat_delete)};
            } else {
                charSequenceArr = new CharSequence[]{GlobalApplication.m10283b().getString(R.string.view_resend), GlobalApplication.m10283b().getString(R.string.menu_chat_delete)};
            }
            String strM10071a = EnumC2214ab.m10071a(EnumC2214ab.m10070a(cursorA.getInt(cursorA.getColumnIndex("message_content_type"))));
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
            abstractC4932aM18733a.mo18740a(strM10071a);
            abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC1617by(this, view, j, z));
            abstractC4932aM18733a.mo18751b(true);
            abstractC4932aM18733a.mo18752b();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1762hh
    /* renamed from: a */
    public void mo8234a(String str, String str2, int i, String str3, String str4, EnumC2300t enumC2300t) {
        if (!str.equals(this.f5750v)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("inboxNo is not equal - arg inboxNo(" + str + "), chatfragment inboxNo(" + this.f5750v + ")", f5461a);
                return;
            }
            return;
        }
        if (this.f5531aX == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("message control is null. return", f5461a);
                return;
            }
            return;
        }
        if (EnumC2300t.m10209b(enumC2300t) || TextUtils.isEmpty(str4) || "null".equals(str4)) {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            C2142w c2142wM9593a = C2142w.m9593a(strValueOf, enumC2300t);
            if (c2142wM9593a != null) {
                c2142wM9593a.m9246a(this.f5536ac);
                c2142wM9593a.mo9252a(strValueOf, str2, i);
                c2142wM9593a.m9642a(true);
                c2142wM9593a.m9648e(this.f5750v);
                this.f5531aX.mo9243a(Long.MAX_VALUE);
                c2142wM9593a.mo9247a(EnumC2300t.BROADCAST, str3, this.f5593bi, "", this.f5750v, this.f5562bD);
                return;
            }
            return;
        }
        boolean zM9656o = false;
        if (this.f5531aX instanceof C2142w) {
            zM9656o = ((C2142w) this.f5531aX).m9656o();
        }
        if (!zM9656o) {
            this.f5531aX.mo9274d();
        }
        this.f5531aX.mo9252a(this.f5750v, str2, i);
        this.f5531aX.mo9248a(enumC2300t, str3, this.f5593bi, str4, this.f5750v, this.f5562bD, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7940a(String str, EnumC2214ab enumC2214ab) {
        if (this.f5487D == EnumC2300t.ONETOONE) {
            Cursor cursorM9843h = C2190d.m9843h(CommonApplication.m18732r().getContentResolver(), this.f5752x);
            if (cursorM9843h != null && cursorM9843h.getCount() > 0) {
                cursorM9843h.moveToFirst();
                String string = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_orginal_number"));
                String string2 = null;
                if (cursorM9843h.getColumnIndex("buddy_msisdns") > 0) {
                    string2 = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_msisdns"));
                }
                String strM8241b = m8241b(string, string2);
                if (TextUtils.isEmpty(strM8241b)) {
                    if (cursorM9843h != null && !cursorM9843h.isClosed()) {
                        cursorM9843h.close();
                        return;
                    }
                    return;
                }
                startActivity(C5034k.m19091a(strM8241b, str));
            }
            if (cursorM9843h != null) {
                cursorM9843h.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m7903a(View view, long j, String str, String str2, String str3, EnumC2214ab enumC2214ab, String str4, int i) {
        String str5;
        String strNextToken = "";
        File file = null;
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f5529aV.setText(R.string.popup_no_network_connection);
            this.f5529aV.setDuration(0);
            this.f5529aV.show();
            return;
        }
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.GEO || enumC2214ab == EnumC2214ab.ANICON || enumC2214ab == EnumC2214ab.POLL || enumC2214ab == EnumC2214ab.APPLINK || enumC2214ab == EnumC2214ab.LIVESHARE || enumC2214ab == EnumC2214ab.LIVERECOMMEND || enumC2214ab == EnumC2214ab.LIVECONTENTS || enumC2214ab == EnumC2214ab.GLYMPSE) {
            str5 = "";
        } else {
            if (TextUtils.isEmpty(str3)) {
                C5179v.m19810a(this.f5624cN, R.string.chat_send_recordvodeo_toast_failed, 0).show();
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
        if (this.f5637ca == EnumC2301u.NORMAL && TextUtils.isEmpty(this.f5488E)) {
            if (this.f5487D != EnumC2300t.BROADCAST && !C2717y.m11395a(this.f5637ca)) {
                m8274s();
            }
            z = true;
        }
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.LIVESHARE || enumC2214ab == EnumC2214ab.LIVERECOMMEND || enumC2214ab == EnumC2214ab.LIVECONTENTS || enumC2214ab == EnumC2214ab.GLYMPSE) {
            this.f5531aX.m9214a(j, str2, enumC2214ab, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), str, z);
            return;
        }
        if (enumC2214ab == EnumC2214ab.GEO) {
            this.f5531aX.m9206a(j, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, str);
            return;
        }
        if (enumC2214ab == EnumC2214ab.ANICON) {
            String[] strArr = new String[0];
            String[] strArrSplit = str.split("\n");
            String strM13781c = C3460d.m13781c(strArrSplit[2]);
            if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 6; i2 < strArrSplit.length; i2++) {
                    stringBuffer.append(strArrSplit[i2] + "\n");
                }
                this.f5531aX.m9269c(j, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, strM13781c, -1L, stringBuffer.toString().substring(0, stringBuffer.length() - 1));
                return;
            }
            this.f5531aX.m9269c(j, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, strM13781c, -1L, null);
            return;
        }
        if (enumC2214ab == EnumC2214ab.APPLINK) {
            this.f5531aX.m9254b(j, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), str);
            return;
        }
        if (enumC2214ab == EnumC2214ab.POLL) {
            this.f5531aX.m9204a(j, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), str);
            return;
        }
        if (enumC2214ab == EnumC2214ab.HUGEFILE) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Long.valueOf(j));
            contentValues.put("message_inbox_no", this.f5750v);
            contentValues.put("message_download_uri", str3);
            contentValues.putStringArrayList("receivers", this.f5588bd);
            if (Build.VERSION.SDK_INT < 11) {
                AsyncTaskC2389c.m10387a(2, contentValues, this.f5487D).execute(new Void[0]);
                return;
            } else {
                AsyncTaskC2389c.m10387a(2, contentValues, this.f5487D).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
        }
        boolean z2 = false;
        if (i == 1 && C1998dq.m9146a(str)) {
            z2 = true;
        }
        if (z2) {
            this.f5531aX.m9202a(j, this.f5487D, str, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, str4, str5, enumC2214ab);
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
            this.f5531aX.m9212a(j, file, (String) null, enumC2214ab, this.f5487D, this.f5488E, (String[]) this.f5588bd.toArray(new String[this.f5588bd.size()]), z, str4, strSubstring);
            RunnableC2440g runnableC2440gM10573a = C2438e.m10572a().m10573a(j);
            if (runnableC2440gM10573a != null) {
                runnableC2440gM10573a.m10593a(new HandlerC1621cb(this, enumC2214ab, view));
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: a */
    public void mo8226a(View view, String str, long j, EnumC2214ab enumC2214ab) {
        C2438e.m10572a().m10577a(str, j);
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: a */
    public void mo8223a(View view, long j) {
        C2434a.m10540a().m10546c(j);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: h */
    public void mo8263h() {
        if (!this.f5509aB) {
            Intent intent = new Intent(this.f5624cN, (Class<?>) MeDialog.class);
            intent.putExtra("ME_DIALOG_NAME", C4809aa.m18104a().m18121a("Push Name", ""));
            intent.putExtra("ME_DIALOG_STATUSMSG", C4809aa.m18104a().m18121a("status_message", ""));
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: a */
    public void mo8225a(View view, ProfileImageView profileImageView, String str, String str2) {
        if (!this.f5509aB && !C4847bl.m18333a()) {
            if (str.startsWith("0999")) {
                Intent intentM17225a = C4542g.m17225a(this.f5624cN, String.valueOf(str));
                intentM17225a.putExtra("key_buddy_name", str2);
                if (str.equals(this.f5752x)) {
                    mo8272q();
                    ((InterfaceC1668dv) getActivity()).mo7820a(intentM17225a.getExtras());
                    return;
                } else {
                    startActivity(intentM17225a);
                    return;
                }
            }
            Intent intent = new Intent(this.f5624cN, (Class<?>) BuddyDialog.class);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
            startActivityForResult(intent, 20);
        }
    }

    /* renamed from: ah */
    private void m8021ah() {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        abstractC4932aM18733a.mo18734a(R.string.menu_chat_insert).mo18736a(R.array.attach_list, new DialogInterfaceOnClickListenerC1622cc(this));
        InterfaceC4936e interfaceC4936eMo18745a = abstractC4932aM18733a.mo18745a();
        interfaceC4936eMo18745a.setCanceledOnTouchOutside(true);
        interfaceC4936eMo18745a.show();
    }

    @Override // com.sec.chaton.p060f.InterfaceC2336f
    /* renamed from: a */
    public boolean mo8239a(int i) {
        if (C4847bl.m18333a()) {
            return true;
        }
        switch (i) {
            case 0:
                m8021ah();
                break;
            case 1:
                m8027ak();
                break;
            case 2:
                m8025aj();
                break;
            case 3:
                m8023ai();
                break;
            case 4:
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
                    return false;
                }
                AbstractC4932a.m18733a(getActivity()).mo18740a(getString(R.string.menu_chat_insert)).mo18751b(true).mo18744a(new CharSequence[]{getString(R.string.attach_voice_recorded_file), getString(R.string.attach_voice_create_recording)}, new DialogInterfaceOnClickListenerC1623cd(this)).mo18745a().show();
                break;
            case 6:
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    Intent intent = new Intent(this.f5624cN, (Class<?>) VCardReadContactActivity.class);
                    intent.putExtra("inbox_NO", this.f5750v);
                    startActivityForResult(intent, 7);
                    break;
                }
            case 7:
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    Intent intent2 = new Intent(this.f5624cN, (Class<?>) VCalendarListActivity2.class);
                    intent2.putExtra("inbox_NO", this.f5750v);
                    startActivityForResult(intent2, 5);
                    break;
                }
            case 8:
                startActivityForResult(new Intent(this.f5624cN, (Class<?>) GeotagActivity.class), 6);
                break;
            case 9:
                if (m7957aB() && this.f5624cN != null) {
                    if (C2948h.m12190a().m12192a(this.f5624cN, EnumC2949i.Animessage)) {
                        startActivityForResult(C2921a.m12140h(this.f5624cN), 15);
                        C4892m.m18584f(true);
                        break;
                    } else {
                        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
                        abstractC4932aM18733a.mo18734a(R.string.media_animessage).mo18746b(R.string.ams_install_message).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1625cf(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1624ce(this));
                        abstractC4932aM18733a.mo18752b();
                        break;
                    }
                }
                return false;
            case 10:
                if (C1427a.m7519b()) {
                    Intent intent3 = new Intent();
                    intent3.setAction("com.sec.android.app.myfiles.PICK_DATA");
                    intent3.setComponent(new ComponentName("com.sec.android.app.myfiles", "com.sec.android.app.myfiles.fileselector.SingleSelectorActivity"));
                    intent3.putExtra("CONTENT_TYPE", FileExplorerActivity.m11582h());
                    intent3.putExtra("CONTENT_EXTENSION", "scc");
                    try {
                        startActivityForResult(intent3, 18);
                        break;
                    } catch (ActivityNotFoundException e) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ActivityNotFound(My files)", f5461a);
                        }
                        Intent intent4 = new Intent();
                        intent4.setAction("com.sec.android.app.myfiles.PICK_DATA");
                        intent4.putExtra("CONTENT_TYPE", FileExplorerActivity.m11582h());
                        intent4.putExtra("CONTENT_EXTENSION", "scc");
                        try {
                            startActivityForResult(intent4, 18);
                            break;
                        } catch (ActivityNotFoundException e2) {
                            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e2, f5461a);
                            }
                            return false;
                        }
                    }
                } else {
                    startActivityForResult(new Intent(this.f5624cN, (Class<?>) FileExplorerActivity.class), 18);
                    break;
                }
            case 11:
                Intent intent5 = new Intent("android.intent.action.SNOTE_PICK");
                intent5.putExtra("SelectMode", "single");
                intent5.putExtra("ReturnType", "Imageonly");
                startActivityForResult(intent5, 19);
                C4892m.m18584f(true);
                break;
            case 12:
                if (C5047m.m19188a(getActivity(), C2722d.m11408a(getActivity()))) {
                    startActivityForResult(C2722d.m11408a(getActivity()), 25);
                    C4892m.m18584f(true);
                    break;
                } else {
                    DialogC2719a dialogC2719a = new DialogC2719a(getActivity());
                    dialogC2719a.setOnCancelListener(new DialogInterfaceOnCancelListenerC1626cg(this));
                    dialogC2719a.show();
                    break;
                }
        }
        return false;
    }

    /* renamed from: ai */
    private void m8023ai() {
        if (!C4822an.m18245m() || !C4822an.m18246n()) {
            C5179v.m19810a(this.f5624cN, R.string.recordvideo_unable_to_record_during_call, 0).show();
            return;
        }
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 1);
        intent.putExtra("return-data", true);
        if (C4822an.m18205O()) {
            intent.putExtra("android.intent.extra.sizeLimit", 1073217536L);
        } else {
            intent.putExtra("android.intent.extra.sizeLimit", 30932992L);
        }
        intent.putExtra("video-size", "1280x720");
        try {
            startActivityForResult(intent, 12);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f5461a);
            }
        }
    }

    /* renamed from: aj */
    private void m8025aj() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
        }
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("video/*");
        if (!BuddyProfileActivity.m6743a(this.f5624cN, intent)) {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("video/*");
        }
        try {
            startActivityForResult(intent, 11);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f5461a);
            }
        }
    }

    /* renamed from: ak */
    private void m8027ak() {
        if (!C4822an.m18245m() || !C4822an.m18246n()) {
            C5179v.m19810a(this.f5624cN, R.string.recordvideo_unable_to_record_during_call, 0).show();
            return;
        }
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.f5559bA = null;
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".jpg";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//");
        if (!file.exists()) {
            file.mkdir();
        }
        this.f5559bA = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//", str));
        intent.putExtra("output", this.f5559bA);
        intent.putExtra("return-data", true);
        try {
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f5461a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: al */
    public void m8030al() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
            return;
        }
        try {
            startActivityForResult(m7882a(this.f5624cN), 1);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f5461a);
            }
        }
    }

    /* renamed from: a */
    public static Intent m7882a(Context context) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        if (!BuddyProfileActivity.m6743a(context, intent)) {
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.GET_CONTENT");
            intent2.setType("image/*");
            return intent2;
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: am */
    public void m8031am() {
        this.f5528aU.m8560a(m7985aP(), m7983aO(), this.f5570bL, this.f5571bM);
        this.f5527aT.setAdapter((ListAdapter) this.f5528aU);
        this.f5527aT.setTranscriptMode(2);
        this.f5527aT.setSelection(this.f5527aT.getCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: an */
    public void m8034an() {
        m8038ap();
        m8036ao();
    }

    /* renamed from: ao */
    private void m8036ao() {
        this.f5639cc = C1735gh.m8610a(getResources().getConfiguration().orientation, this.f5567bI);
        if (this.f5639cc != null) {
            if (this.f5568bJ.equals("pa")) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f5639cc);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                this.f5644ch.setBackgroundDrawable(bitmapDrawable);
                return;
            }
            this.f5644ch.setImageBitmap(this.f5639cc);
            return;
        }
        m8264i();
    }

    /* renamed from: i */
    public void m8264i() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f5644ch.setBackgroundDrawable(bitmapDrawable);
    }

    /* renamed from: ap */
    private void m8038ap() {
        if (this.f5639cc != null) {
            this.f5644ch.setImageBitmap(null);
            this.f5639cc = null;
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.f5635cY) {
                if (m7970aH()) {
                    mo8272q();
                } else {
                    m8091bf();
                }
            }
            this.f5564bF.setMaxLines(4);
        } else {
            m8090be();
            this.f5564bF.setMaxLines(5);
        }
        if (this.f5624cN != null && C4904y.f17872b) {
            C4904y.m18639b("root w:" + this.f5644ch.getWidth(), f5461a);
            C4904y.m18639b("root h:" + this.f5644ch.getHeight(), f5461a);
        }
    }

    @Override // com.sec.chaton.base.InterfaceC1061c
    public boolean onBackKeyPressed() {
        if (this.f5635cY) {
            this.f5635cY = false;
            m8090be();
        }
        if (C2349a.m10301a("chatroom_draw_menu_feature") && C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue()) {
            this.f5729eh.removeView(this.f5727ef);
            C4809aa.m18105a("draw_menu_info", (Boolean) true);
            C4809aa.m18105a("show_draw_menu_info", (Boolean) false);
            m8273r();
            return true;
        }
        if (this.f5527aT.getChoiceMode() == 2) {
            m8270o();
            return true;
        }
        if (m7970aH()) {
            m7973aJ();
            this.f5527aT.setFocusable(true);
            m7833D();
            return true;
        }
        C2726b.m11429a().m11442b();
        C2726b.m11429a().m11445c();
        C2726b.m11429a().m11447d();
        return false;
    }

    /* renamed from: aq */
    private void m8039aq() {
        if (this.f5673dL != null) {
            this.f5673dL.dismiss();
        }
        if (this.f5674dM != null) {
            this.f5674dM.dismiss();
        }
        if (this.f5675dN != null) {
            this.f5675dN.dismiss();
        }
    }

    /* renamed from: ar */
    private void m8041ar() {
        if (this.f5673dL != null) {
            this.f5673dL.hide();
        }
        if (this.f5674dM != null) {
            this.f5674dM.hide();
        }
        if (this.f5675dN != null) {
            this.f5675dN.hide();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0346  */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onItemClick(android.widget.AdapterView<?> r12, android.view.View r13, int r14, long r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        C4904y.m18644d("onContextItemSelected!!!!");
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C4904y.f17873c) {
            C4904y.m18641c("[Go out the ChatRoom] inboxNO : " + this.f5750v, getClass().getSimpleName());
        }
        if (this.f5643cg != null && this.f5564bF != null) {
            mo8272q();
            this.f5643cg = null;
        }
        if (this.f5531aX != null) {
            this.f5531aX.m9267b(this.f5536ac);
            this.f5531aX = null;
        }
        if (C4822an.m18203M() && this.f5624cN != null) {
            this.f5624cN.getContentResolver().unregisterContentObserver(this.f5543aj);
            this.f5624cN.getContentResolver().unregisterContentObserver(this.f5544ak);
        }
        super.onDestroy();
        if (this.f5615cE != null) {
            this.f5615cE.m11425a();
        }
        C2726b.m11429a().m11442b();
        C2726b.m11429a().m11445c();
        C2726b.m11429a().m11447d();
        if (!C2349a.m10301a("chaton_translator")) {
            C0096i.m358a(getActivity()).m361a(this.f5746ey);
        }
        C1856i.m9056c();
        m8096bh();
        C0991aa.m6037a().m18960b(this.f5514aG);
    }

    /* renamed from: a */
    public AbstractC4932a m8217a(EnumC0789m enumC0789m) {
        this.f5649cm = AbstractC4932a.m18733a(this.f5624cN);
        if (enumC0789m == EnumC0789m.END_APP) {
            this.f5649cm.mo18746b(R.string.provision_error_end).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1627ch(this));
            return this.f5649cm;
        }
        if (enumC0789m == EnumC0789m.RESTART_APP) {
            this.f5649cm.mo18746b(R.string.auth_error_restart).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1628ci(this));
            return this.f5649cm;
        }
        return null;
    }

    @Override // com.sec.chaton.chat.InterfaceC1762hh
    /* renamed from: a */
    public void mo8219a(int i, String str, String str2, EnumC2214ab enumC2214ab) throws Resources.NotFoundException {
        String strM3099b;
        if (this.f5624cN == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("setPreviewText - attach activity is null. return", f5461a);
                return;
            }
            return;
        }
        if (i == 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("setPreviewText - newMsgCount is zero. return", f5461a);
                return;
            }
            return;
        }
        if (str2 != null && !str2.equals(C4809aa.m18104a().m18121a("chaton_id", "")) && str != null && enumC2214ab != null) {
            if (enumC2214ab == EnumC2214ab.TEXT) {
                if (C1736gi.m8652d(str)) {
                    str = str.substring(1);
                }
                this.f5620cJ.setText(C2799k.m11709a(this.f5624cN, str, (int) C5034k.m19088a(30.0f)));
            } else if (enumC2214ab == EnumC2214ab.APPLINK) {
                this.f5620cJ.setText(ApplinkMsgEntry.getDisplayMessage(str));
            } else {
                C0777a c0777a = this.f5591bg.get(str2);
                if (c0777a == null) {
                    strM3099b = getResources().getString(R.string.unknown);
                } else {
                    strM3099b = c0777a.m3099b();
                }
                boolean zEquals = "mixed".equals(str.split("\n")[0]);
                if (this.f5487D == EnumC2300t.GROUPCHAT || this.f5487D == EnumC2300t.TOPIC) {
                    this.f5620cJ.setText(EnumC2214ab.m10073a(enumC2214ab, str, strM3099b, zEquals));
                } else if (this.f5487D == EnumC2300t.ONETOONE) {
                    this.f5620cJ.setText(enumC2214ab == EnumC2214ab.POLL ? EnumC2214ab.m10073a(enumC2214ab, str, strM3099b, zEquals) : EnumC2214ab.m10074a(enumC2214ab, str, zEquals));
                } else {
                    return;
                }
            }
            C2496n.m10765a(this.f5619cI, str2, EnumC2498p.ROUND);
            this.f5619cI.setBackgroundResource(R.drawable.circle_background);
            this.f5618cH.setVisibility(0);
        }
    }

    /* renamed from: j */
    public void m8265j() {
        if (this.f5527aT != null) {
            this.f5527aT.setTranscriptMode(2);
        }
        this.f5618cH.setVisibility(8);
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC2798j
    /* renamed from: a */
    public void mo8232a(String str) {
        int selectionStart = this.f5564bF.getSelectionStart();
        int selectionEnd = this.f5564bF.getSelectionEnd();
        CharSequence charSequenceM11712b = C2799k.m11712b(this.f5624cN, str, (int) (this.f5564bF.getLineHeight() * 1.2f));
        if ((this.f5564bF.getText().length() + charSequenceM11712b.length()) - (selectionEnd - selectionStart) >= 10000) {
            Toast.makeText(CommonApplication.m18732r(), R.string.toast_text_max_Length, 0).show();
            return;
        }
        if (this.f5564bF.getEditableText() != null) {
            this.f5564bF.getEditableText().replace(selectionStart, selectionEnd, charSequenceM11712b, 0, charSequenceM11712b.length());
        }
        this.f5564bF.setSelection(charSequenceM11712b.length() + selectionStart, selectionStart + charSequenceM11712b.length());
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC2798j
    /* renamed from: a */
    public void mo8233a(String str, String str2) {
        m7973aJ();
        m7833D();
        if (this.f5527aT != null) {
            this.f5527aT.setSelectionFromTop(this.f5527aT.getCount(), 0);
            this.f5527aT.setTranscriptMode(2);
        }
        this.f5609by = str;
        EnumC3465i enumC3465iM13788h = C3460d.m13788h(this.f5624cN, str);
        if (enumC3465iM13788h == EnumC3465i.NORMAL) {
            this.f5556ay.setVisibility(8);
        } else {
            this.f5556ay.setVisibility(0);
            if (enumC3465iM13788h == EnumC3465i.SOUND) {
                this.f5556ay.setBackgroundResource(R.drawable.chat_haptic_sound_nor);
            } else if (enumC3465iM13788h == EnumC3465i.HAPTIC_SOUND) {
                this.f5556ay.setBackgroundResource(R.drawable.chat_haptic_sound_vi2_nor);
            } else {
                this.f5556ay.setBackgroundResource(R.drawable.chat_haptic_vibration_nor);
            }
        }
        AnimationDrawable animationDrawableM13772b = C3460d.m13772b(CommonApplication.m18732r(), str);
        this.f5555ax.setBackgroundDrawable(null);
        if (animationDrawableM13772b != null) {
            this.f5555ax.setImageDrawable(animationDrawableM13772b);
        } else {
            this.f5555ax.setImageResource(R.drawable.anicon_broken);
        }
        if (enumC3465iM13788h != EnumC3465i.NORMAL) {
            this.f5556ay.setOnClickListener(new ViewOnClickListenerC1629cj(this));
        } else {
            this.f5556ay.setOnClickListener(null);
        }
        this.f5555ax.setOnClickListener(null);
        this.f5554aw.setVisibility(0);
        this.f5548aq = true;
        m8088bd();
        this.f5551at = EnumC2214ab.ANICON;
        if (animationDrawableM13772b != null) {
            animationDrawableM13772b.start();
        }
        m8218a();
        if (this.f5659cw != null) {
            this.f5659cw.m19015a((View) this.f5555ax);
        }
        this.f5508aA = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: as */
    public void m8044as() {
        this.f5567bI = C4809aa.m18104a().m18121a("setting_change_skin", "-1");
        this.f5568bJ = C4809aa.m18104a().m18121a("setting_change_skin_type", "pa");
        this.f5569bK = C4809aa.m18104a().m18121a("Default Font Size", "");
        this.f5570bL = C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1");
        this.f5571bM = C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1");
        this.f5572bN = C4809aa.m18104a().m18119a("Setting enter key", (Boolean) false).booleanValue();
        this.f5573bO = C4809aa.m18104a().m18119a("Setting push to talk", (Boolean) true).booleanValue();
        m8266k();
        if (C4904y.f17872b) {
            C4904y.m18639b("Preference information for chat room.", f5461a);
            C4904y.m18639b(C5052r.m19199a(" > Skin Id: ", this.f5567bI), f5461a);
            C4904y.m18639b(C5052r.m19199a(" > Font Size: ", this.f5569bK), f5461a);
            C4904y.m18639b(C5052r.m19199a(" > Send Bubble: ", this.f5570bL), f5461a);
            C4904y.m18639b(C5052r.m19199a(" > Receive Bubble: ", this.f5571bM), f5461a);
            C4904y.m18639b(C5052r.m19199a(" > Send With Enter: ", Boolean.valueOf(this.f5572bN)), f5461a);
            C4904y.m18639b(C5052r.m19199a(" > Push to talk: ", Boolean.valueOf(this.f5573bO)), f5461a);
            C4904y.m18639b(C5052r.m19199a(" > Compatibility: ", C4809aa.m18104a().m18121a("compatibility", "")), f5461a);
        }
    }

    /* renamed from: k */
    public void m8266k() {
        if (this.f5567bI.equals("skin_01")) {
            this.f5567bI = "-1";
        } else if (this.f5567bI.equals("skin_bg_02")) {
            this.f5567bI = "-2";
        } else if (this.f5567bI.equals("skin_bg_03")) {
            this.f5567bI = "-3";
        } else if (this.f5567bI.equals("skin_bg_04")) {
            this.f5567bI = "-4";
        } else if (this.f5567bI.equals("skin_bg_05")) {
            this.f5567bI = "-5";
        }
        if (this.f5570bL.equals("bubble_01")) {
            this.f5570bL = "-1";
        } else if (this.f5570bL.equals("bubble_02")) {
            this.f5570bL = "-2";
        } else if (this.f5570bL.equals("bubble_03")) {
            this.f5570bL = "-3";
        } else if (this.f5570bL.equals("bubble_04")) {
            this.f5570bL = "-4";
        } else if (this.f5570bL.equals("bubble_05")) {
            this.f5570bL = "-5";
        }
        if (this.f5571bM.equals("bubble_01")) {
            this.f5571bM = "-1";
            return;
        }
        if (this.f5571bM.equals("bubble_02")) {
            this.f5571bM = "-2";
            return;
        }
        if (this.f5571bM.equals("bubble_03")) {
            this.f5571bM = "-3";
        } else if (this.f5571bM.equals("bubble_04")) {
            this.f5571bM = "-4";
        } else if (this.f5571bM.equals("bubble_05")) {
            this.f5571bM = "-5";
        }
    }

    @Override // com.sec.widget.InterfaceC5181x
    /* renamed from: a */
    public void mo8227a(View view, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("OnHeightChanged - " + String.valueOf(z), "ChatFragment");
        }
    }

    /* renamed from: l */
    public void m8267l() {
        if (this.f5608bx && this.f5546ao != null) {
            this.f5546ao.startDelete(3, null, C2306z.f8229a, "message_sender=? AND message_inbox_no=? AND message_content_type=?", new String[]{this.f5750v, this.f5750v, String.valueOf(EnumC2214ab.SYSTEM.m10076a())});
        }
        this.f5608bx = false;
    }

    /* renamed from: m */
    public void m8268m() {
    }

    /* renamed from: n */
    public void m8269n() {
        this.f5509aB = true;
        if (m7970aH()) {
            m7973aJ();
        }
        m7861R();
        this.f5547ap.findItem(R.id.chat_menu_delete_confirm).setEnabled(false);
        m8049av();
        this.f5692de.setText(getResources().getString(R.string.chat_view_menu_delete_chats));
        mo8272q();
        this.f5527aT.setChoiceMode(2);
        this.f5527aT.setTranscriptMode(0);
        this.f5518aK.setVisibility(8);
        this.f5517aJ.setVisibility(0);
        this.f5517aJ.setChecked(false);
        C2726b.m11429a().m11442b();
        if (this.f5528aU != null) {
            this.f5528aU.m8562a(EnumC1731gd.SELECT_NONE);
        }
        this.f5694dg.setEnabled(false);
    }

    /* renamed from: o */
    public void m8270o() {
        this.f5509aB = false;
        m7861R();
        m8049av();
        this.f5692de.setText(this.f5596bl);
        this.f5517aJ.setVisibility(8);
        if (this.f5527aT != null) {
            this.f5527aT.setChoiceMode(0);
            this.f5527aT.clearChoices();
        }
        if (this.f5560bB) {
            this.f5518aK.setVisibility(0);
        }
        this.f5694dg.setEnabled(true);
    }

    /* renamed from: at */
    private boolean m8046at() {
        HashMap<Long, C4108aq> mapM8575e;
        if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_ALL) {
            mapM8575e = this.f5528aU.m8577f();
        } else {
            mapM8575e = this.f5528aU.m8575e();
        }
        if (mapM8575e != null && !mapM8575e.isEmpty()) {
            for (Map.Entry<Long, C4108aq> entry : mapM8575e.entrySet()) {
                entry.getKey();
                if (entry.getValue().m16304g()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8137e(boolean z) {
        String str;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_ALL) {
            C2726b.m11429a().m11442b();
            C2726b.m11429a().m11447d();
            ArrayList arrayList = new ArrayList();
            arrayList.add(0);
            arrayList.add(3);
            C2716x.m11385b(this.f5750v, arrayList);
            this.f5546ao.startDelete(3, null, C2306z.f8229a, "message_inbox_no = ? AND message_type != ? AND message_type != ?", new String[]{this.f5750v, Integer.toString(0), Integer.toString(3)});
        } else {
            HashMap<Long, Boolean> mapM8570c = this.f5528aU.m8570c();
            HashMap<Long, Boolean> mapM8573d = this.f5528aU.m8573d();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(-1);
            arrayList3.add(1);
            arrayList3.add(6);
            if (mapM8570c != null && !mapM8570c.isEmpty()) {
                for (Map.Entry<Long, Boolean> entry : mapM8570c.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        Long key = entry.getKey();
                        sb.append(key.toString()).append(",");
                        arrayList2.add(key);
                    }
                }
            }
            if (mapM8573d != null && !mapM8573d.isEmpty()) {
                for (Map.Entry<Long, Boolean> entry2 : mapM8573d.entrySet()) {
                    if (entry2.getValue().booleanValue()) {
                        sb2.append(entry2.getKey().toString()).append(",");
                    }
                }
            }
            Uri uri = C2306z.f8229a;
            String str2 = null;
            String[] strArr4 = null;
            if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_PART) {
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                    str2 = "message_inbox_no = ? AND _id IN (" + sb.toString() + ") AND ( message_type = ? OR message_type = ? OR message_type = ? )";
                    strArr4 = new String[]{this.f5750v, Integer.toString(-1), Integer.toString(1), Integer.toString(6)};
                    C2716x.m11386b(this.f5750v, (ArrayList<Long>) arrayList2, (ArrayList<Integer>) arrayList3);
                }
                if (sb2.length() <= 0) {
                    str = null;
                    strArr = null;
                    strArr2 = strArr4;
                } else {
                    sb2.setLength(sb2.length() - 1);
                    str = "message_inbox_no = ? AND message_sever_id IN (" + sb2.toString() + ") AND message_type != ? AND message_type != ? AND message_type != ?";
                    strArr = new String[]{this.f5750v, Integer.toString(1), Integer.toString(0), Integer.toString(3)};
                    strArr2 = strArr4;
                }
            } else if (this.f5528aU.m8579h() != EnumC1731gd.SELECT_PART_AFTER_ALL) {
                str = null;
                strArr = null;
                strArr2 = null;
            } else {
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                    str2 = "message_inbox_no = ? AND _id NOT IN (" + sb.toString() + ") AND ( message_type = ? OR message_type = ? OR message_type = ? )";
                    strArr3 = new String[]{this.f5750v, Integer.toString(-1), Integer.toString(1), Integer.toString(6)};
                    C2716x.m11368a(this.f5750v, (ArrayList<Long>) arrayList2, (ArrayList<Integer>) arrayList3);
                } else {
                    str2 = "message_inbox_no = ? AND message_sender = ? AND ( message_type = ? OR message_type = ? OR message_type = ? )";
                    strArr3 = new String[]{this.f5750v, C4809aa.m18104a().m18121a("chaton_id", ""), Integer.toString(-1), Integer.toString(1), Integer.toString(6)};
                    C2716x.m11383a(this.f5750v, (ArrayList<Integer>) arrayList3);
                }
                if (sb2.length() > 0) {
                    sb2.setLength(sb2.length() - 1);
                    str = "message_inbox_no = ? AND message_sever_id NOT IN (" + sb2.toString() + ") AND message_type != ? AND message_type != ? AND message_type != ?";
                    strArr = new String[]{this.f5750v, Integer.toString(1), Integer.toString(0), Integer.toString(3)};
                    strArr2 = strArr3;
                } else {
                    str = "message_inbox_no = ? AND message_sender != ? AND message_type != ? AND message_type != ? AND message_type != ?";
                    strArr = new String[]{this.f5750v, C4809aa.m18104a().m18121a("chaton_id", ""), Integer.toString(1), Integer.toString(0), Integer.toString(3)};
                    strArr2 = strArr3;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f5546ao.startDelete(3, null, uri, str2, strArr2);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f5546ao.startDelete(3, null, uri, str, strArr);
            }
        }
        if (C4822an.m18203M()) {
            m7930a(this.f5528aU.m8579h(), z);
        }
        m8270o();
    }

    /* renamed from: au */
    private void m8047au() {
        if (!m8006aZ()) {
            C5179v.m19810a(this.f5624cN, R.string.toast_no_delete_data, 0).show();
            m8270o();
            return;
        }
        if (C4822an.m18203M() && m8046at()) {
            m7926a(new DialogInterfaceOnClickListenerC1664dr(this, true), true);
            return;
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_ALL) {
            abstractC4932aM18733a.mo18734a(R.string.delete_all_items);
            abstractC4932aM18733a.mo18746b(R.string.all_messages_will_be_deleted);
        } else {
            abstractC4932aM18733a.mo18734a(R.string.layout_chat_fragment_delete);
            abstractC4932aM18733a.mo18746b(R.string.selected_messages_will_be_deleted);
        }
        abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1634co(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1633cn(this));
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: a */
    private void m7926a(DialogInterfaceOnClickListenerC1664dr dialogInterfaceOnClickListenerC1664dr, boolean z) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        View viewInflate = ((LayoutInflater) this.f5624cN.getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.commenttextview);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_packet_chekcbox);
        textView.setVisibility(8);
        checkBox.setText(getString(R.string.delete_unlocked));
        if (!z) {
            linearLayout.setVisibility(8);
            checkBox.setVisibility(8);
        } else {
            dialogInterfaceOnClickListenerC1664dr.m8499a(checkBox.isChecked());
            checkBox.setOnClickListener(new ViewOnClickListenerC1635cp(this, dialogInterfaceOnClickListenerC1664dr));
            linearLayout.setVisibility(0);
            checkBox.setVisibility(0);
        }
        if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_ALL) {
            abstractC4932aM18733a.mo18734a(R.string.delete_all_items).mo18746b(R.string.all_messages_will_be_deleted).mo18748b(viewInflate).mo18742a(true).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null).mo18756d(R.string.dialog_ok, dialogInterfaceOnClickListenerC1664dr);
        } else {
            abstractC4932aM18733a.mo18734a(R.string.menu_chat_delete).mo18746b(R.string.confirm_delete_messages).mo18748b(viewInflate).mo18742a(true).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null).mo18756d(R.string.dialog_ok, dialogInterfaceOnClickListenerC1664dr);
        }
        abstractC4932aM18733a.mo18745a().show();
    }

    /* renamed from: a */
    private void m7930a(EnumC1731gd enumC1731gd, boolean z) {
        HashMap<Long, C4108aq> mapM8575e;
        if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_ALL) {
            mapM8575e = this.f5528aU.m8577f();
        } else if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_PART_AFTER_ALL) {
            HashMap<Long, C4108aq> mapM8577f = this.f5528aU.m8577f();
            Iterator<Map.Entry<Long, C4108aq>> it = this.f5528aU.m8575e().entrySet().iterator();
            while (it.hasNext()) {
                Long key = it.next().getKey();
                if (mapM8577f.containsKey(key)) {
                    mapM8577f.remove(key);
                }
            }
            mapM8575e = mapM8577f;
        } else {
            mapM8575e = this.f5528aU.m8575e();
        }
        if (mapM8575e != null && !mapM8575e.isEmpty()) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            Iterator<Map.Entry<Long, C4108aq>> it2 = mapM8575e.entrySet().iterator();
            while (it2.hasNext()) {
                C4108aq value = it2.next().getValue();
                boolean zM16304g = value.m16304g();
                if (z || !zM16304g) {
                    C5108d.m19487b().mo19484b(value.m16302e());
                    arrayList.add(value.m16302e());
                }
            }
            if (arrayList.size() != 0) {
                this.f5732ek.m15243a(this.f5534aa, arrayList, 9700, (Object) null, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: av */
    public void m8049av() {
        int i;
        int size;
        int i2;
        if (this.f5509aB) {
            if (this.f5691dd != null) {
                this.f5691dd.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f5691dd != null) {
            this.f5691dd.setVisibility(0);
        }
        if (this.f5487D == EnumC2300t.ONETOONE || this.f5487D == EnumC2300t.MONOLOGUE) {
            i = R.string.dialog_header_text;
            size = 0;
        } else if (this.f5487D == EnumC2300t.GROUPCHAT || this.f5487D == EnumC2300t.TOPIC) {
            if (this.f5487D == EnumC2300t.GROUPCHAT) {
                i2 = R.string.buddy_list_optionmenu_groupchat;
            } else {
                i2 = R.string.topic_chat;
            }
            int size2 = this.f5588bd.size() + 1;
            if (this.f5632cV == 10 && this.f5588bd.size() == 1 && this.f5696di > 1) {
                i = i2;
                size = this.f5696di + 1;
            } else {
                i = i2;
                size = size2;
            }
        } else if (EnumC2300t.m10208a(this.f5487D)) {
            i = R.string.buddy_list_optionmenu_broadcast;
            size = this.f5588bd.size();
            if (this.f5632cV == 10 && this.f5588bd.size() == 1 && this.f5696di > 1) {
                size = this.f5696di;
            }
        } else {
            C4904y.m18634a("unknown ChatType : " + this.f5487D, f5461a);
            i = R.string.dialog_header_text;
            size = 0;
        }
        StringBuilder sb = new StringBuilder(GlobalApplication.m10283b().getString(i));
        if (size > 0) {
            sb.append("(").append(String.valueOf(size)).append(")");
        }
        this.f5565bG = sb.toString();
        this.f5693df.setText(this.f5565bG);
        this.f5693df.setVisibility(0);
        m8157h(this.f5563bE);
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: a */
    public void mo8236a(boolean z) {
        if (this.f5509aB) {
            this.f5547ap.findItem(R.id.chat_menu_delete_confirm).setEnabled(z);
            if (this.f5528aU.m8579h() == EnumC1731gd.SELECT_ALL) {
                this.f5517aJ.setChecked(true);
            } else {
                this.f5517aJ.setChecked(false);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1786ie
    /* renamed from: a */
    public void mo8228a(EnumC1787if enumC1787if) {
        if (!this.f5509aB) {
            if (C4904y.f17873c) {
                C4904y.m18641c("TypingState was changed " + EnumC1787if.m8817a(enumC1787if), f5461a);
            }
            switch (C1791m.f6705d[enumC1787if.ordinal()]) {
                case 1:
                    if (this.f5566bH != null) {
                        this.f5566bH.setVisibility(0);
                    }
                    this.f5565bG = GlobalApplication.m10283b().getString(R.string.chat_room_typing_state);
                    this.f5693df.setText(this.f5565bG);
                    this.f5693df.setVisibility(0);
                    break;
                case 2:
                    if (this.f5566bH != null) {
                        this.f5566bH.setVisibility(8);
                    }
                    m8049av();
                    break;
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1762hh
    /* renamed from: p */
    public boolean mo8271p() {
        return this.f5527aT != null && this.f5527aT.getTranscriptMode() == 2;
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: a */
    public void mo8238a(boolean z, Cursor cursor, View view) {
        if (m8053ax() && m8056ay() && m8058az() && m7957aB()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
            if (!C2434a.m10540a().m10543a(j, false)) {
                C2434a.m10540a().m10541a(view, this, this.f5536ac, cursor.getPosition(), string2, false, string, j, enumC2214abM10070a, this.f5487D, string3);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: q */
    public void mo8272q() {
        this.f5643cg.hideSoftInputFromWindow(this.f5564bF.getWindowToken(), 0);
        this.f5635cY = false;
        m8090be();
        if (C4825aq.m18259a()) {
            m8041ar();
        }
    }

    /* renamed from: r */
    public void m8273r() {
        boolean zShowSoftInput;
        if (!this.f5635cY && getResources() != null) {
            Configuration configuration = getResources().getConfiguration();
            if (configuration.orientation == 2) {
                zShowSoftInput = this.f5643cg.showSoftInput(this.f5564bF, 0);
                m8091bf();
            } else {
                zShowSoftInput = configuration.orientation == 1 ? this.f5643cg.showSoftInput(this.f5564bF, 1) : true;
            }
            if (GlobalApplication.m10287f() && !zShowSoftInput && !this.f5635cY) {
                this.f5643cg.toggleSoftInput(0, 0);
            }
            this.f5635cY = true;
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: a */
    public void mo8237a(boolean z, Cursor cursor) {
        if (m8053ax() && m8056ay() && m8058az()) {
            if (cursor.isClosed()) {
                C4904y.m18641c("onImageClickListener: cursor got closed", f5461a);
                return;
            }
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            Intent intent = new Intent(this.f5624cN, (Class<?>) ImagePagerActivity.class);
            if (j != 0) {
                j2 = j;
            }
            intent.putExtra("messageId", j2);
            intent.putExtra("inboxNo", string);
            intent.putExtra("isValid", this.f5560bB);
            intent.putExtra("chatType", this.f5487D.m10210a());
            intent.putExtra("sessionID", this.f5488E);
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: b */
    public void mo8243b(boolean z, Cursor cursor) {
        if (m8053ax() && m8056ay() && m8058az()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            Intent intent = new Intent(this.f5624cN, (Class<?>) ImagePagerActivity.class);
            if (j != 0) {
                j2 = j;
            }
            intent.putExtra("messageId", j2);
            intent.putExtra("inboxNo", string);
            intent.putExtra("isValid", this.f5560bB);
            intent.putExtra("chatType", this.f5487D.m10210a());
            intent.putExtra("sessionID", this.f5488E);
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: b */
    public void mo8244b(boolean z, Cursor cursor, View view) {
        if (m8053ax() && m8056ay() && m8058az() && m7956aA()) {
            String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
            if ((TextUtils.isEmpty(string3) || C1427a.f5066d.equals(string3)) && !C2434a.m10540a().m10542a(j)) {
                if (m7957aB()) {
                    C2434a.m10540a().m10541a(view, this, this.f5536ac, cursor.getPosition(), string2, false, string, j, enumC2214abM10070a, this.f5487D, string4);
                    if (z) {
                        this.f5660cx = m8063b(j);
                        this.f5660cx.m18719a(0);
                        this.f5660cx.show();
                        AsyncTaskC2436c asyncTaskC2436cM10545b = C2434a.m10540a().m10545b(j);
                        if (asyncTaskC2436cM10545b != null) {
                            asyncTaskC2436cM10545b.m10554a(this.f5660cx);
                        }
                    }
                } else {
                    return;
                }
            }
            C2726b.m11429a().m11439a(string3, j, view, z, cursor, cursor.getPosition(), this.f5536ac, this.f5487D);
            C2726b.m11429a().m11438a(this.f5750v);
        }
    }

    /* renamed from: aw */
    private boolean m8052aw() {
        return m8053ax() && m8056ay() && m8058az();
    }

    /* renamed from: a */
    private void m7900a(Cursor cursor, View view) {
        String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
        if (!C2434a.m10540a().m10542a(j) && m7957aB()) {
            C2434a.m10540a().m10541a(view, this, this.f5536ac, cursor.getPosition(), string2, false, string, j, enumC2214abM10070a, this.f5487D, string3);
            this.f5660cx = m8063b(j);
            this.f5660cx.m18719a(0);
            this.f5660cx.show();
            AsyncTaskC2436c asyncTaskC2436cM10545b = C2434a.m10540a().m10545b(j);
            if (asyncTaskC2436cM10545b != null) {
                asyncTaskC2436cM10545b.m10554a(this.f5660cx);
                asyncTaskC2436cM10545b.m10552a(this.f5539af);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: c */
    public void mo8249c(boolean z, Cursor cursor, View view) {
        if (m8052aw()) {
            String string = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            if (TextUtils.isEmpty(string) || C1427a.f5066d.equals(string)) {
                m7900a(cursor, view);
            } else {
                m8185m(string);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: d */
    public void mo8253d(boolean z, Cursor cursor, View view) {
        if (m8052aw()) {
            String string = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            if (TextUtils.isEmpty(string) || C1427a.f5066d.equals(string)) {
                m7900a(cursor, view);
            } else {
                m8190n(string);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: e */
    public void mo8256e(boolean z, Cursor cursor, View view) {
        if (m8052aw()) {
            String string = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            if (TextUtils.isEmpty(string) || C1427a.f5066d.equals(string)) {
                m7900a(cursor, view);
            } else {
                m8192o(string);
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: c */
    public void mo8248c(boolean z, Cursor cursor) {
        String strSubstring;
        if (m8053ax() && m8056ay()) {
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            if (!C1427a.m7518a()) {
                C5179v.m19810a(this.f5624cN, R.string.toast_googleMAP_unavailable, 0).show();
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
                        this.f5624cN.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer2.toString())));
                    } catch (ActivityNotFoundException e) {
                        C5179v.m19810a(this.f5624cN, R.string.no_applications_can_perform_this_action, 0).show();
                    }
                }
            }
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: d */
    public void mo8252d(boolean z, Cursor cursor) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onAppLinkClickListener()", f5461a);
        }
        String string = cursor.getString(cursor.getColumnIndex("message_content"));
        if (TextUtils.isEmpty(string)) {
            if (C4904y.f17875e) {
                C4904y.m18634a(" - error #0. message contents is empty error", f5461a);
                return;
            }
            return;
        }
        try {
            MessageType4Entry messageType4Entry = ApplinkMsgEntry.parse(string);
            if (messageType4Entry == null || !(messageType4Entry instanceof ApplinkMsgEntry)) {
                if (C4904y.f17875e) {
                    C4904y.m18634a(" - error #2. type error (not a full message)", f5461a);
                    return;
                }
                return;
            }
            ApplinkMsgEntry applinkMsgEntry = (ApplinkMsgEntry) messageType4Entry;
            if (C4904y.f17872b) {
                C4904y.m18639b("applink info : " + applinkMsgEntry.toString(), f5461a);
            }
            String appName = applinkMsgEntry.getAppName();
            ApplinkMsgEntry.ContentEntry.AppInfoEntry.ParamEntry param = applinkMsgEntry.getParam("android", "phone");
            if (param == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a(" - error #3. there's not link action for android-phone", f5461a);
                    return;
                }
                return;
            }
            if (m8245b(param.f8552id)) {
                if (TextUtils.isEmpty(param.executeUri)) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a(" - error #4. there's not executeUri", f5461a);
                        return;
                    }
                    return;
                }
                try {
                    Uri uri = Uri.parse(param.executeUri);
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    boolean zM8240a = m8240a(intent);
                    if (!zM8240a) {
                        intent = new Intent("android.intent.action.SEND", uri);
                        zM8240a = m8240a(intent);
                    }
                    if (zM8240a) {
                        startActivity(intent);
                        return;
                    } else {
                        if (C4904y.f17875e) {
                            C4904y.m18634a(" - error #5. 3rd party does not support properly applink", f5461a);
                            return;
                        }
                        return;
                    }
                } catch (NullPointerException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f5461a);
                        return;
                    }
                    return;
                }
            }
            if (C4904y.f17872b) {
                C4904y.m18639b(param.f8552id + " is not installed", f5461a);
            }
            if (TextUtils.isEmpty(param.installUrl)) {
                if (C4904y.f17875e) {
                    C4904y.m18634a(" - error #6. there's not install info", f5461a);
                }
            } else {
                String str = param.installUrl;
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
                abstractC4932aM18733a.mo18734a(R.string.setting_category_notice);
                abstractC4932aM18733a.mo18749b(String.format(getResources().getString(R.string.applink_popup_install), appName));
                abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1637cr(this, str)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1636cq(this));
                abstractC4932aM18733a.mo18752b();
            }
        } catch (Exception e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f5461a);
                C4904y.m18634a(" - error #1. data parsing error", f5461a);
            }
        }
    }

    /* renamed from: a */
    boolean m8240a(Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = this.f5624cN.getPackageManager().queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    boolean m8245b(String str) {
        try {
            if (this.f5624cN.getPackageManager().getPackageInfo(str, 64) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m8185m(String str) {
        Intent intent = new Intent(this.f5624cN, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 2);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m8190n(String str) {
        Intent intent = new Intent(this.f5624cN, (Class<?>) ReadVCardActivity.class);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m8192o(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse("file://" + (str.startsWith("file://") ? str.substring(6) : str)), FileExplorerActivity.m11579b(str.substring(str.lastIndexOf(".") + 1)));
            boolean zM6743a = BuddyProfileActivity.m6743a(this.f5624cN, intent);
            if (zM6743a) {
                try {
                    startActivity(intent);
                } catch (SecurityException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f5461a);
                    }
                    zM6743a = false;
                }
            }
            if (!zM6743a) {
                EnumC2758b enumC2758bM11581d = FileExplorerActivity.m11581d(str);
                if (enumC2758bM11581d == EnumC2758b.SNB || enumC2758bM11581d == EnumC2758b.SPD) {
                    AbstractC4932a.m18733a(this.f5624cN).mo18734a(R.string.attach_title_announcements).mo18746b(R.string.popup_install_office_viewer).mo18756d(R.string.dialog_ok, null).mo18752b();
                    return;
                }
                if (enumC2758bM11581d != EnumC2758b.UNKNOWN && enumC2758bM11581d != EnumC2758b.DIRECTORY) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    String string = getString(R.string.doc_query_viewer);
                    if (enumC2758bM11581d == EnumC2758b.HWP) {
                        string = getString(R.string.doc_query_hwp);
                    } else if (enumC2758bM11581d == EnumC2758b.GUL) {
                        string = getString(R.string.doc_query_gul);
                    } else if (enumC2758bM11581d == EnumC2758b.XLS || enumC2758bM11581d == EnumC2758b.PDF || enumC2758bM11581d == EnumC2758b.DOC || enumC2758bM11581d == EnumC2758b.PPT) {
                        string = getString(R.string.doc_query_viewer);
                    }
                    String str2 = "market://search?q=" + string + "&c=apps";
                    if (enumC2758bM11581d == EnumC2758b.SCC) {
                        str2 = "market://details?id=com.sec.android.app.contentviewer";
                    }
                    intent2.setData(Uri.parse(str2));
                    boolean zM6743a2 = BuddyProfileActivity.m6743a(this.f5624cN, intent2);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("isMarketAvailable: " + zM6743a2 + ", strUri : " + str2, f5461a);
                    }
                    AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
                    abstractC4932aM18733a.mo18734a(R.string.attach_title_announcements).mo18746b(R.string.insert_need_install_viewer).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1639ct(this, zM6743a2, intent2));
                    abstractC4932aM18733a.mo18752b();
                }
            }
        }
    }

    /* renamed from: b */
    private AlertDialogC4916i m8063b(long j) {
        if (this.f5660cx == null) {
            this.f5660cx = new AlertDialogC4916i(this.f5624cN);
            this.f5660cx.setTitle(R.string.download_title);
            this.f5660cx.setMessage(getString(R.string.anicon_file_downloading));
            this.f5660cx.setCancelable(false);
        }
        this.f5660cx.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1640cu(this, j));
        return this.f5660cx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ax */
    public boolean m8053ax() {
        if (this.f5624cN != null) {
            return true;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("mAttachedActivity is null", ChatFragment.class.getSimpleName());
        }
        return false;
    }

    /* renamed from: ay */
    private boolean m8056ay() {
        return !C4847bl.m18333a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: az */
    public boolean m8058az() {
        if (C4873ck.m18500a()) {
            return true;
        }
        C5179v.m19810a(this.f5624cN, R.string.sdcard_not_found, 0).show();
        return false;
    }

    /* renamed from: aA */
    private boolean m7956aA() {
        if (C4822an.m18245m() && C4822an.m18246n()) {
            return true;
        }
        C5179v.m19810a(this.f5624cN, R.string.chatroom_unable_to_record_during_call, 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aB */
    public boolean m7957aB() {
        if (C4873ck.m18504e()) {
            return true;
        }
        AbstractC4932a.m18733a(this.f5624cN).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
        return false;
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: c */
    public void mo8247c(String str) {
        Intent intent = new Intent(this.f5624cN, (Class<?>) DetailTextView.class);
        intent.putExtra("fulltext", str);
        intent.putExtra("View All", this.f5596bl);
        startActivity(intent);
    }

    /* renamed from: aC */
    private boolean m7960aC() {
        return m8146f(true);
    }

    /* renamed from: f */
    private boolean m8146f(boolean z) {
        int iM10677a = C2471v.m10677a(this.f5624cN);
        if (-3 != iM10677a && -2 != iM10677a) {
            return true;
        }
        this.f5529aV.setText(R.string.popup_no_network_connection);
        this.f5529aV.setDuration(0);
        if (!z) {
            return false;
        }
        this.f5529aV.show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m8138e(int i) {
        int iM10677a = C2471v.m10677a(this.f5624cN);
        if (-3 != iM10677a && -2 != iM10677a) {
            return true;
        }
        this.f5529aV.setText(i);
        this.f5529aV.setDuration(0);
        this.f5529aV.show();
        return false;
    }

    /* renamed from: aD */
    private boolean m7962aD() {
        if (!EnumC2300t.m10208a(this.f5487D) || this.f5588bd.size() != 0) {
            return true;
        }
        this.f5529aV.setText(R.string.no_contacts);
        this.f5529aV.setDuration(0);
        this.f5529aV.show();
        return false;
    }

    /* renamed from: aE */
    private boolean m7964aE() {
        return !TextUtils.isEmpty(this.f5564bF.getText().toString().trim().replaceAll("\n", ""));
    }

    /* renamed from: s */
    public void m8274s() {
        if (this.f5492I == null && this.f5624cN != null) {
            this.f5492I = (ProgressDialog) new C4923p(this.f5624cN).m18724a(R.string.setting_webview_please_wait);
        }
        if (this.f5492I != null && !this.f5492I.isShowing()) {
            this.f5492I.show();
        }
    }

    /* renamed from: t */
    public void m8275t() {
        if (this.f5624cN != null && this.f5492I != null && this.f5492I.isShowing()) {
            this.f5492I.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aF */
    public void m7966aF() {
        if (this.f5493J == null) {
            this.f5493J = (ProgressDialog) new C4923p(this.f5624cN).m18724a(R.string.chat_sync_wait);
        }
        if (!this.f5493J.isShowing()) {
            this.f5493J.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m7968aG() {
        if (this.f5493J != null && this.f5493J.isShowing()) {
            this.f5493J.dismiss();
        }
    }

    /* renamed from: aH */
    private boolean m7970aH() {
        return this.f5646cj != null && this.f5646cj.getVisibility() == 0;
    }

    /* renamed from: aI */
    private void m7971aI() {
        if (C4904y.f17872b) {
            C4904y.m18639b("showEmoticonSelectionView is called", f5461a);
        }
        if (!isAdded() || this.f5624cN == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Fragment isn't added or activity is null", f5461a);
                return;
            }
            return;
        }
        ((ActionBarFragmentActivity) this.f5624cN).m18784t().mo18820a(this.f5689db);
        ((ActionBarFragmentActivity) this.f5624cN).m18784t().mo18836e(16);
        m7865T();
        if (this.f5646cj == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Initialize emoticon selection view.", f5461a);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.emoticon_selection_view_height));
            this.f5646cj = new EmoticonSelectionView(this.f5624cN, this.f5637ca);
            if (layoutParams.height > 0) {
                layoutParams.height -= (int) C5034k.m19088a(49.5f);
            }
            this.f5646cj.setLayoutParams(layoutParams);
            this.f5646cj.setVisibility(8);
            this.f5646cj.setEmoticonSelectedListener(this);
            this.f5645ci.addView(this.f5646cj);
            if (this.f5695dh == null) {
                this.f5695dh = new View(this.f5624cN);
                this.f5695dh.setBackgroundColor(getResources().getColor(R.color.emoticon_under_background));
                this.f5695dh.setOnClickListener(new ViewOnClickListenerC1642cw(this));
            }
            this.f5519aL.addView(this.f5695dh);
            getFragmentManager().mo186b();
        }
        this.f5646cj.setVisibility(0);
        this.f5695dh.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aJ */
    public void m7973aJ() {
        if (this.f5646cj != null && this.f5695dh != null) {
            this.f5646cj.setVisibility(8);
            this.f5695dh.setVisibility(8);
            m7867U();
            if (!this.f5509aB) {
                m7861R();
                this.f5692de.setText(this.f5596bl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7943a(String str, String str2, boolean z, int i, int i2) {
        Bitmap bitmapM18142a;
        if (!this.f5560bB) {
            m7977aL();
            return;
        }
        String strM18257y = C4822an.m18257y();
        if (this.f5627cQ == null && (!strM18257y.equalsIgnoreCase(str2) || !z)) {
            if (!z) {
                this.f5627cQ = BitmapFactory.decodeResource(getResources(), R.drawable.download_ic_noti);
                m7976aK();
            } else if (!"NO_SEARCH".equalsIgnoreCase(str2)) {
                if (!m8197p(str2)) {
                    this.f5626cP = str2;
                    m8199q(str2);
                } else {
                    File file = new File(this.f5628cR, str2 + ".png");
                    if (file.exists()) {
                        try {
                            if (file.length() > 0 && (bitmapM18142a = C4812ad.m18142a(GlobalApplication.m18732r(), Uri.fromFile(file))) != null) {
                                this.f5627cQ = bitmapM18142a;
                                m7976aK();
                            }
                        } catch (Exception e) {
                            C4904y.m18635a(e, f5461a);
                        }
                    }
                }
            }
        }
        this.f5520aM.setVisibility(0);
        this.f5525aR.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("\n", " ");
        }
        if (i2 > 0) {
            this.f5525aR.setText(getResources().getString(R.string.privacy_dialog_spam_reported_user, str, Integer.valueOf(i2)));
        } else if (z) {
            this.f5525aR.setText(getResources().getString(R.string.privacy_dialog_not_match_location_user, str));
        } else {
            this.f5525aR.setText(getResources().getString(R.string.privacy_dialog_not_identified_user, str));
        }
        this.f5521aN.setVisibility(0);
        this.f5522aO.setOnClickListener(new ViewOnClickListenerC1643cx(this));
        this.f5524aQ.setOnClickListener(new ViewOnClickListenerC1644cy(this));
        this.f5523aP.setOnClickListener(new ViewOnClickListenerC1645cz(this));
    }

    /* renamed from: d */
    public void m8251d(String str) {
        String strM3099b;
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        abstractC4932aM18733a.mo18734a(R.string.spammer_report_title);
        C0777a c0777a = this.f5591bg.get(str);
        if (c0777a == null) {
            strM3099b = "";
        } else {
            strM3099b = c0777a.m3099b();
        }
        abstractC4932aM18733a.mo18749b(this.f5487D == EnumC2300t.GROUPCHAT ? getResources().getString(R.string.spammer_groupchat_report_guide, strM3099b) : getResources().getString(R.string.spammer_report_guide, strM3099b));
        abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1648db(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1647da(this));
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: aK */
    private void m7976aK() {
        this.f5528aU.m8559a(this.f5627cQ);
        if (this.f5527aT != null) {
            this.f5527aT.invalidateViews();
        }
    }

    /* renamed from: p */
    private boolean m8197p(String str) {
        return new File(this.f5628cR).exists() && new File(this.f5628cR, new StringBuilder().append(str).append(".png").toString()).exists();
    }

    /* renamed from: q */
    private void m8199q(String str) {
        new C2128i(this.f5540ag).m9531g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aL */
    public void m7977aL() {
        this.f5525aR.setVisibility(8);
        this.f5521aN.setVisibility(8);
        if (this.f5627cQ != null) {
            if (!this.f5627cQ.isRecycled()) {
                this.f5627cQ.recycle();
            }
            this.f5627cQ = null;
            m7976aK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aM */
    public void m7980aM() {
        if (this.f5526aS != null) {
            this.f5526aS.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aN */
    public void m7981aN() {
        if (this.f5526aS != null) {
            this.f5526aS.setVisibility(8);
        }
    }

    /* renamed from: aO */
    private float m7983aO() {
        String strM18121a = C4809aa.m18104a().m18121a("Default Font Size", EnumC3594ed.Normal.m13900a());
        if (C4904y.f17873c) {
            C4904y.m18641c("sizeString : " + strM18121a, f5461a);
        }
        EnumC3594ed enumC3594edM13899a = EnumC3594ed.Normal;
        try {
            enumC3594edM13899a = EnumC3594ed.m13899a(strM18121a);
        } catch (Exception e) {
            e.printStackTrace();
            C4904y.m18634a("cannot get font size : " + strM18121a, f5461a);
        }
        String strName = enumC3594edM13899a.name();
        if (C4904y.f17873c) {
            C4904y.m18641c("fontSizeName : " + strName, f5461a);
        }
        if (strName.equals(EnumC3594ed.System.name())) {
            return C4822an.m18220b(this.f5624cN);
        }
        if (strName.equals(EnumC3594ed.Tiny.name())) {
            return getResources().getDimension(R.dimen.font_size_tiny);
        }
        if (strName.equals(EnumC3594ed.Small.name())) {
            return getResources().getDimension(R.dimen.font_size_small);
        }
        if (strName.equals(EnumC3594ed.Normal.name())) {
            return getResources().getDimension(R.dimen.font_size_normal);
        }
        if (strName.equals(EnumC3594ed.Large.name())) {
            return getResources().getDimension(R.dimen.font_size_large);
        }
        if (strName.equals(EnumC3594ed.Huge.name())) {
            return getResources().getDimension(R.dimen.font_size_huge);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("unknown fontSizeName : " + strName, f5461a);
        }
        return getResources().getDimension(R.dimen.font_size_normal);
    }

    /* renamed from: aP */
    private Typeface m7985aP() {
        int iIntValue;
        try {
            iIntValue = C4809aa.m18104a().m18120a("Default Font Typeface", (Integer) (-1)).intValue();
        } catch (Exception e) {
            iIntValue = -1;
        }
        if (iIntValue == -1) {
            return Typeface.DEFAULT;
        }
        String path = C3471o.m13807c(CommonApplication.m18732r(), Integer.toString(iIntValue)).getPath();
        C4904y.m18639b(path, getClass().getSimpleName());
        try {
            return Typeface.createFromFile(path);
        } catch (Exception e2) {
            C4904y.m18639b("Cannot make font from file", getClass().getSimpleName());
            return Typeface.DEFAULT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aQ */
    public void m7988aQ() throws Resources.NotFoundException {
        String str;
        if (this.f5634cX) {
            m7991aS();
            if (C2349a.m10301a("chatroom_draw_menu_feature")) {
                m7848L();
            }
            m7993aT();
            this.f5634cX = false;
            return;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[onResume() ChatRoom] InboxNO : " + this.f5750v, getClass().getSimpleName());
        }
        C4904y.m18639b("onResume - QUERY_INBOX", getClass().getSimpleName());
        if (TextUtils.isEmpty(this.f5750v)) {
            String str2 = "";
            if (this.f5487D == EnumC2300t.ONETOONE) {
                str2 = "buddy_no=?";
                str = this.f5588bd.get(0);
            } else if (this.f5487D != EnumC2300t.GROUPCHAT && this.f5487D != EnumC2300t.TOPIC) {
                str = "";
            } else {
                str2 = "inbox_no = ( SELECT inbox_no FROM inbox_buddy_relation WHERE buddy_no = ? )";
                str = this.f5658cv;
            }
            if (TextUtils.isEmpty(str)) {
                this.f5546ao.startQuery(1, null, C2299s.m10184a(), null, "inbox_no=?", new String[]{""}, null);
                return;
            } else {
                this.f5546ao.startQuery(1, null, C2299s.m10201n(), null, str2, new String[]{str, this.f5488E, String.valueOf(this.f5487D.m10210a()), this.f5640cd.m7095a()}, null);
                return;
            }
        }
        this.f5546ao.startQuery(1, null, C2299s.m10184a(), null, "inbox_no=?", new String[]{this.f5750v}, null);
    }

    /* renamed from: g */
    private boolean m8152g(boolean z) {
        boolean z2;
        if (!this.f5753y) {
            return false;
        }
        if ((this.f5487D != EnumC2300t.ONETOONE && this.f5487D != EnumC2300t.GROUPCHAT) || this.f5549ar == null || C4822an.m18227c(getActivity())) {
            return false;
        }
        if (m7872X() && !C2948h.m12190a().m12192a(getActivity(), EnumC2949i.ChatONV)) {
            return false;
        }
        Iterator<Map.Entry<String, C0777a>> it = this.f5591bg.entrySet().iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = z3;
                break;
            }
            C0777a value = it.next().getValue();
            z2 = !TextUtils.isEmpty(value.m3103d()) && value.m3103d().contains("voip=1");
            if (!z2) {
                C4904y.m18639b("[ChatONV] voip not supported : " + value.m3096a(), f5461a);
                break;
            }
            z3 = z2;
        }
        return z2;
    }

    /* renamed from: e */
    public boolean m8257e(String str) {
        if (TextUtils.isEmpty(this.f5752x)) {
            return false;
        }
        return ((this.f5752x.length() >= 19 && this.f5752x.startsWith("10")) || this.f5752x.startsWith(Spam.ACTIVITY_CANCEL)) && !TextUtils.isEmpty(str);
    }

    /* renamed from: b */
    public String m8241b(String str, String str2) {
        if (!m8257e(str2)) {
            if (!m8203r(str)) {
                return "+" + this.f5752x;
            }
            return str;
        }
        List<String> listM8204s = m8204s(str2);
        if (listM8204s.size() > 0) {
            return "+" + listM8204s.get(0);
        }
        return null;
    }

    /* renamed from: r */
    private boolean m8203r(String str) {
        if (TextUtils.isEmpty(this.f5752x) || this.f5752x.length() < 19 || !this.f5752x.startsWith("10") || TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public List<String> m8204s(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, f5461a);
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, f5461a);
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, f5461a);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m8067b(Bundle bundle) throws Resources.NotFoundException {
        InboxExtraEntry inboxExtraEntry;
        this.f5632cV = bundle.getInt("inbox_last_chat_type");
        this.f5488E = bundle.getString("inbox_session_id");
        this.f5593bi = Long.valueOf(bundle.getLong("inbox_last_msg_no"));
        this.f5597bm = bundle.getString("inbox_title");
        this.f5489F = bundle.getInt("_id");
        this.f5594bj = bundle.getString("inbox_server_ip");
        this.f5610bz = bundle.getInt("inbox_server_port");
        if (TextUtils.isEmpty(this.f5594bj)) {
            this.f5594bj = C4844bi.m18323a().m18328c().m18329a();
            this.f5610bz = C4844bi.m18323a().m18328c().m18332b();
        }
        this.f5598bn = bundle.getString("inbox_title_fixed");
        this.f5599bo = bundle.getString("inbox_last_msg_sender");
        this.f5633cW = bundle.getString("inbox_last_temp_msg");
        this.f5600bp = bundle.getString("buddy_name");
        this.f5605bu = bundle.getInt("inbox_trunk_unread_count");
        this.f5752x = bundle.getString("buddy_no");
        this.f5562bD = bundle.getLong("inbox_last_timestamp");
        this.f5563bE = "Y".equals(bundle.getString("inbox_enable_noti"));
        this.f5607bw = bundle.getInt("inbox_unread_count");
        this.f5561bC = "Y".equals(bundle.getString("inbox_is_entered"));
        this.f5602br = bundle.getLong("lasst_session_merge_time");
        this.f5603bs = bundle.getString("inbox_last_tid");
        this.f5699dn = "Y".equals(bundle.getString("inbox_enable_translate"));
        this.f5700do = "Y".equals(bundle.getString("translate_outgoing_message"));
        f5459P = bundle.getString("inbox_translate_my_language");
        if (TextUtils.isEmpty(f5459P)) {
            f5459P = C1850c.m9024d().m9039e().m9013d(f5459P);
            this.f5697dj = false;
        } else {
            this.f5697dj = true;
        }
        f5460Q = bundle.getString("inbox_translate_buddy_language");
        f5460Q = C1850c.m9024d().m9039e().m9014e(f5460Q);
        this.f5696di = bundle.getInt("inbox_participants");
        String string = bundle.getString("inbox_topic_type");
        if (!TextUtils.isEmpty(string)) {
            try {
                inboxExtraEntry = (InboxExtraEntry) new C2477a(string).m10709a(InboxExtraEntry.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                inboxExtraEntry = null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                inboxExtraEntry = null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                inboxExtraEntry = null;
            } catch (JSONException e4) {
                e4.printStackTrace();
                inboxExtraEntry = null;
            }
            if (inboxExtraEntry != null && inboxExtraEntry.topicchattype != null) {
                this.f5604bt = inboxExtraEntry.topicchattype;
            }
        }
        m8280z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8066b(Cursor cursor) throws Resources.NotFoundException {
        InboxExtraEntry inboxExtraEntry;
        if (cursor.moveToFirst()) {
            this.f5632cV = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
            this.f5750v = cursor.getString(cursor.getColumnIndex("inbox_no"));
            if (this.f5487D == null && C4904y.f17873c) {
                C4904y.m18641c("ChatType is null", f5461a);
            }
            this.f5487D = EnumC2300t.m10207a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
            if (C4904y.f17873c) {
                C4904y.m18641c("retrieveInboxInfoFromCursor - inboxNo : " + this.f5750v + ", chatType : " + this.f5487D, f5461a);
            }
            if (this.f5632cV == 12) {
                if (!m7855O()) {
                    cursor.close();
                    return;
                }
                this.f5753y = false;
            } else {
                this.f5488E = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                this.f5593bi = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                this.f5597bm = cursor.getString(cursor.getColumnIndex("inbox_title"));
                this.f5489F = cursor.getInt(cursor.getColumnIndex("_id"));
                this.f5594bj = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
                this.f5610bz = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
                if (TextUtils.isEmpty(this.f5594bj)) {
                    this.f5594bj = C4844bi.m18323a().m18328c().m18329a();
                    this.f5610bz = C4844bi.m18323a().m18328c().m18332b();
                }
                this.f5598bn = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
                this.f5599bo = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
                this.f5633cW = cursor.getString(cursor.getColumnIndex("inbox_last_temp_msg"));
                this.f5600bp = cursor.getString(cursor.getColumnIndex("buddy_name"));
                this.f5605bu = cursor.getInt(cursor.getColumnIndex("inbox_trunk_unread_count"));
                this.f5752x = cursor.getString(cursor.getColumnIndex("buddy_no"));
                this.f5560bB = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                this.f5562bD = cursor.getLong(cursor.getColumnIndex("inbox_last_timestamp"));
                this.f5563bE = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                this.f5607bw = cursor.getInt(cursor.getColumnIndex("inbox_unread_count"));
                this.f5561bC = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_is_entered")));
                this.f5602br = cursor.getLong(cursor.getColumnIndex("lasst_session_merge_time"));
                this.f5603bs = cursor.getString(cursor.getColumnIndex("inbox_last_tid"));
                this.f5699dn = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_translate")));
                this.f5700do = "Y".equals(cursor.getString(cursor.getColumnIndex("translate_outgoing_message")));
                f5459P = cursor.getString(cursor.getColumnIndex("inbox_translate_my_language"));
                f5460Q = cursor.getString(cursor.getColumnIndex("inbox_translate_buddy_language"));
                String string = cursor.getString(cursor.getColumnIndex("usertype"));
                if (!TextUtils.isEmpty(string)) {
                    this.f5640cd = EnumC1109f.m7094a(string);
                }
                this.f5696di = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
                String string2 = cursor.getString(cursor.getColumnIndex("inbox_topic_type"));
                if (!TextUtils.isEmpty(string2)) {
                    try {
                        inboxExtraEntry = (InboxExtraEntry) new C2477a(string2).m10709a(InboxExtraEntry.class);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        inboxExtraEntry = null;
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                        inboxExtraEntry = null;
                    } catch (InstantiationException e3) {
                        e3.printStackTrace();
                        inboxExtraEntry = null;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        inboxExtraEntry = null;
                    }
                    if (inboxExtraEntry != null && inboxExtraEntry.topicchattype != null) {
                        this.f5604bt = inboxExtraEntry.topicchattype;
                    }
                }
            }
            f5459P = C1850c.m9024d().m9039e().m9013d(f5459P);
            f5460Q = C1850c.m9024d().m9039e().m9014e(f5460Q);
            m8280z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aR */
    public C1763hi m7989aR() {
        if (this.f5747ez == null && !TextUtils.isEmpty(this.f5750v)) {
            this.f5747ez = new C1763hi(this.f5624cN, this.f5527aT, this.f5528aU, this.f5750v, this.f5542ai);
        }
        return this.f5747ez;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aS */
    public void m7991aS() throws Resources.NotFoundException {
        if (!TextUtils.isEmpty(this.f5750v)) {
            m7989aR();
            if (C4822an.m18203M() && (this.f5731ej == null || !this.f5731ej.m14354a())) {
                if (this.f5733el == null) {
                    this.f5733el = this.f5624cN.getContentResolver();
                }
                if (this.f5732ek == null) {
                    this.f5732ek = new C3942a(this.f5733el);
                }
                m8259f(this.f5750v);
            }
            if (this.f5632cV == 12) {
                if (this.f5637ca == EnumC2301u.NORMAL) {
                    if (this.f5531aX != null) {
                        this.f5531aX.mo9252a(this.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                        this.f5531aX.mo9243a(Long.MAX_VALUE);
                        if (!this.f5531aX.mo9272c()) {
                            this.f5531aX.mo9278f();
                        }
                    } else if (C4904y.f17875e) {
                        C4904y.m18634a("initInboxInfoAndQueryParticipant() - mMessageControl is null", f5461a);
                    }
                    synchronized (this.f5545an) {
                        this.f5546ao.startQuery(2, null, C2289i.m10169g(), null, "buddy_no IN" + C1736gi.m8637a(this.f5588bd), null, null);
                    }
                } else {
                    this.f5546ao.startQuery(2, null, C2230ar.m10097b(), null, "buddy_no IN" + C1736gi.m8637a(this.f5588bd), null, null);
                }
            } else {
                String[] strArrSplit = this.f5633cW.split(Config.KEYVALUE_SPLIT);
                if (strArrSplit.length > 2 && !TextUtils.isEmpty(strArrSplit[2])) {
                    m8074b(strArrSplit[1], strArrSplit[2], strArrSplit.length > 3 ? strArrSplit[3] : null);
                    m7850M();
                }
                if (TextUtils.isEmpty(this.f5484A)) {
                    this.f5484A = strArrSplit.length > 0 ? C1736gi.m8646b(strArrSplit[0]) : "";
                }
                String str = this.f5752x;
                if (this.f5487D == EnumC2300t.GROUPCHAT || this.f5487D == EnumC2300t.TOPIC) {
                    str = this.f5750v;
                }
                if (m7855O()) {
                    if (this.f5484A != null) {
                        CharSequence charSequenceM11709a = C2799k.m11709a(this.f5624cN, this.f5484A, (int) (this.f5564bF.getLineHeight() * 1.2f));
                        if (!this.f5666dD && TextUtils.isEmpty(this.f5564bF.getText().toString()) && !TextUtils.isEmpty(charSequenceM11709a)) {
                            this.f5564bF.setText(charSequenceM11709a);
                            this.f5564bF.setSelection(charSequenceM11709a.length());
                        }
                    }
                    m8208t(this.f5750v);
                    if (this.f5637ca == EnumC2301u.NORMAL) {
                        if (this.f5488E != null && !"null".equals(this.f5488E) && !"".equals(this.f5488E)) {
                            if (this.f5531aX.mo9252a(this.f5750v, this.f5594bj, this.f5610bz)) {
                                this.f5531aX.mo9243a(Long.MAX_VALUE);
                                if (this.f5560bB) {
                                    this.f5531aX.mo9247a(this.f5487D, str, this.f5593bi, this.f5488E, this.f5750v, this.f5562bD);
                                }
                            }
                            if (this.f5487D == EnumC2300t.BROADCAST2) {
                                C2134o.m9567a(null);
                            }
                        } else {
                            this.f5531aX.mo9252a(this.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                            this.f5531aX.mo9243a(Long.MAX_VALUE);
                            if (this.f5487D == EnumC2300t.BROADCAST) {
                                C2134o.m9567a(null);
                            } else if (this.f5487D == EnumC2300t.ONETOONE) {
                                if (this.f5560bB) {
                                    this.f5531aX.mo9247a(EnumC2300t.BROADCAST, str, this.f5593bi, this.f5488E, this.f5750v, this.f5562bD);
                                }
                            } else if (this.f5560bB) {
                                if (this.f5594bj == null) {
                                    mo8234a(this.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b(), str, this.f5488E, this.f5487D);
                                } else {
                                    mo8234a(this.f5750v, this.f5594bj, this.f5610bz, str, this.f5488E, this.f5487D);
                                }
                            }
                        }
                    }
                    if (!this.f5560bB) {
                        mo8272q();
                        this.f5518aK.setVisibility(8);
                        m7977aL();
                    }
                    if (this.f5487D != EnumC2300t.MONOLOGUE) {
                        C4904y.m18641c("initInboxInfoAndQueryParticipant_QUERY_PARTICIPANTS_AFTER_INSERTED", f5461a);
                        this.f5546ao.startQuery(5, null, C2220ah.m10090b(this.f5750v), null, null, null, null);
                        m8254e();
                    } else {
                        if (TextUtils.isEmpty(this.f5595bk)) {
                            String string = GlobalApplication.m10283b().getString(R.string.buddy_profile_interaction_me);
                            this.f5595bk = string;
                            this.f5596bl = string;
                        }
                        this.f5692de.setText(this.f5595bk);
                    }
                    if (C4822an.m18255w() && this.f5637ca == EnumC2301u.NORMAL && this.f5753y && this.f5560bB && this.f5487D != EnumC2300t.BROADCAST && this.f5487D != EnumC2300t.TOPIC) {
                        C2134o.m9577d(this.f5540ag, this.f5488E, this.f5750v);
                    }
                } else {
                    return;
                }
            }
            ((ActionBarFragmentActivity) getActivity()).mo51u_();
            if (this.f5531aX != null) {
                this.f5531aX.mo9280s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aT */
    public void m7993aT() {
        if (!this.f5654cr) {
            if (this.f5637ca == EnumC2301u.LIVE) {
                C1813b.m8906b().m8924a(this.f5750v, EnumC4549n.LIVECHAT);
            } else {
                C1813b.m8906b().m8937c(this.f5750v);
            }
        }
        m7853N();
        this.f5528aU.m8566a(this.f5560bB);
        C4904y.m18639b("QUERY_INBOX - QUERY_MESSAGE", getClass().getSimpleName());
        if (this.f5561bC && this.f5607bw >= 20) {
            this.f5546ao.startQuery(15, null, C2306z.m10214a(this.f5607bw), null, "message_inbox_no=?", new String[]{this.f5750v}, null);
            if (m7989aR() != null) {
                this.f5747ez.m8769a(this.f5607bw + 50, this.f5607bw);
            }
        } else if (m7989aR() != null) {
            this.f5747ez.m8774c();
        }
        if (!this.f5561bC && this.f5753y) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_is_entered", "Y");
            this.f5546ao.startUpdate(-1, null, C2299s.f8209a, contentValues, "inbox_no='" + this.f5750v + "'", null);
        }
        if (this.f5560bB && !TextUtils.isEmpty(this.f5752x) && this.f5487D == EnumC2300t.ONETOONE) {
            if (this.f5637ca == EnumC2301u.NORMAL) {
                this.f5546ao.startQuery(17, null, C2289i.f8196a, new String[]{"buddy_show_phone_number", "buddy_extra_info", "buddy_msisdns"}, "buddy_no = ?", new String[]{this.f5752x}, null);
                return;
            } else {
                this.f5546ao.startQuery(17, null, C2289i.m10170h(), null, "buddy_no=?", new String[]{this.f5752x}, null);
                return;
            }
        }
        m7977aL();
    }

    /* renamed from: aU */
    private void m7996aU() {
        C4904y.m18639b("initiallizeMixtureRoom", f5461a);
        ContentResolver contentResolver = this.f5624cN.getContentResolver();
        contentResolver.registerContentObserver(C3961s.f14255a, true, this.f5543aj);
        contentResolver.registerContentObserver(C2302v.f8225a, true, this.f5544ak);
        this.f5733el = this.f5624cN.getContentResolver();
        this.f5732ek = new C3942a(this.f5733el);
        this.f5731ej = C3790i.m14316a(this.f5624cN);
    }

    /* renamed from: u */
    protected synchronized void m8276u() {
        if (C4904y.f17872b) {
            C4904y.m18639b("initiallizeConversation()", f5461a);
        }
        if (this.f5731ej.m14354a()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("initiallizeConversation() conversation is valid - return", f5461a);
            }
        } else {
            new AsyncTaskC1654dh(this).execute(new ArrayList[0]);
        }
    }

    /* renamed from: f */
    protected synchronized void m8259f(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("asyncQueryGetThreadId() inboxNo " + str, f5461a);
        }
        if (this.f5731ej == null && this.f5624cN != null) {
            this.f5731ej = C3790i.m14316a(this.f5624cN);
        }
        this.f5546ao.startQuery(874, null, C2302v.f8225a, new String[]{"inboxsms_mapping_sms_no"}, "inboxsms_mapping_inbox_no =? ", new String[]{str}, null);
    }

    /* renamed from: g */
    protected synchronized void m8262g(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("asyncQueryRemoveThreadId() threadId " + str, f5461a);
        }
        this.f5546ao.startDelete(875, str, C2302v.f8225a, "inboxsms_mapping_sms_no = ?", new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aV */
    public void m7998aV() {
        if (this.f5731ej == null) {
            C4904y.m18639b("startMsgListQuery mSmsConversation is null. do nothing", f5461a);
            return;
        }
        Uri uriM14357c = this.f5731ej.m14357c();
        if (uriM14357c == null) {
            C4904y.m18639b("##### startMsgListQuery: conversationUri is null, bail!", f5461a);
            return;
        }
        long jM14359d = this.f5731ej.m14359d();
        C4904y.m18639b("startMsgListQuery for " + uriM14357c + ", threadId=" + jM14359d, f5461a);
        this.f5732ek.m15232a(9527);
        try {
            this.f5732ek.m15238a(this.f5534aa, 9527, Long.valueOf(jM14359d), C3847e.m14679ak() ? C4110as.f15298l : C4110as.f15299m, jM14359d, this.f5656ct);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aW */
    public void m7999aW() {
        if (this.f5731ej == null) {
            C4904y.m18639b("startMoreMsgListQuery mSmsConversation is null. do nothing", f5461a);
            return;
        }
        Uri uriM14357c = this.f5731ej.m14357c();
        if (uriM14357c == null) {
            C4904y.m18639b("##### startMoreMsgListQuery: conversationUri is null, bail!", f5461a);
            return;
        }
        long jM14359d = this.f5731ej.m14359d();
        C4904y.m18639b("startMoreMsgListQuery for " + uriM14357c + ", threadId=" + jM14359d, f5461a);
        this.f5732ek.m15232a(9528);
        try {
            this.f5732ek.m15238a(this.f5534aa, 9528, Long.valueOf(jM14359d), C3847e.m14679ak() ? C4110as.f15298l : C4110as.f15299m, jM14359d, this.f5656ct);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aX */
    public void m8002aX() {
        if (this.f5731ej == null || !this.f5731ej.m14354a()) {
            C4904y.m18639b("startSmsDraftListQuery mSmsConversation is wrong. do nothing", f5461a);
            return;
        }
        Uri uriM14357c = this.f5731ej.m14357c();
        if (uriM14357c == null) {
            C4904y.m18639b("##### startSmsDraftListQuery: conversationUri is null, bail!", f5461a);
            return;
        }
        long jM14359d = this.f5731ej.m14359d();
        C4904y.m18639b("startSmsDraftListQuery for " + uriM14357c + ", threadId=" + jM14359d, f5461a);
        this.f5732ek.m15232a(9702);
        try {
            this.f5732ek.m15244b(this.f5534aa, 9702, Long.valueOf(jM14359d), jM14359d);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aY */
    public void m8003aY() {
        new Handler().postDelayed(new RunnableC1656dj(this), 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8121c(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aZ */
    public boolean m8006aZ() {
        return this.f5527aT != null && this.f5527aT.getCount() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ba */
    public void m8081ba() {
        if (this.f5592bh.size() != 0) {
            this.f5546ao.startQuery(21, null, C2306z.f8229a, null, "message_inbox_no = ? AND message_sender = ?", new String[]{this.f5750v, "web_only"}, "message_time DESC");
        }
    }

    /* renamed from: a */
    private View m7886a(LayoutInflater layoutInflater, boolean z, C1505a c1505a) {
        boolean z2;
        C1850c c1850cM9024d = C1850c.m9024d();
        View viewInflate = layoutInflater.inflate(R.layout.language_translate, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.only_below_ics_translate_switch_layout);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.only_below_ics_translate_incoming_msg);
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.linearlayout_translate_incoming_msg);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.only_below_ics_translation_on_off_divider);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.only_below_ics_translation_incoming_msg_divider);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox_translate_incoming_msg);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.only_below_ics_checkbox_translate_incoming_msg);
        try {
            try {
                viewFindViewById.setVisibility(8);
                if (!C1865r.m9070b()) {
                    if (c1505a != null) {
                        c1505a.m8352a((CheckBox) viewInflate.findViewById(R.id.only_below_ics_translation_on_off_checkbox));
                        viewFindViewById.setVisibility(0);
                        viewGroup.setVisibility(0);
                        imageView.setVisibility(0);
                        imageView2.setVisibility(0);
                        viewGroup2.setVisibility(8);
                    }
                } else if (this.f5698dm) {
                    viewGroup2.setVisibility(0);
                } else {
                    viewGroup2.setVisibility(8);
                }
                Spinner spinner = (Spinner) viewInflate.findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.spinner2);
                ViewGroup viewGroup3 = (ViewGroup) viewInflate.findViewById(R.id.linearlayout_myLanguage);
                ViewGroup viewGroup4 = (ViewGroup) viewInflate.findViewById(R.id.linearlayout_buddyLanguage);
                C1670dx c1670dx = new C1670dx(this, viewGroup2, viewGroup3, viewGroup4);
                C1670dx c1670dx2 = new C1670dx(this, viewGroup, viewGroup3, viewGroup4);
                if (c1505a != null) {
                    c1505a.m8355a(this.f5699dn);
                }
                if (this.f5698dm) {
                    if (C1865r.m9070b()) {
                        checkBox.setChecked(this.f5700do);
                    } else {
                        checkBox2.setChecked(this.f5700do);
                    }
                } else if (C1865r.m9070b()) {
                    checkBox.setChecked(true);
                    checkBox.setEnabled(false);
                } else {
                    checkBox2.setChecked(true);
                    checkBox2.setEnabled(false);
                }
                this.f5702dq = (ImageView) viewInflate.findViewById(R.id.me_image);
                C2496n.m10763a(this.f5702dq, EnumC2498p.ROUND);
                this.f5702dq.setBackgroundResource(R.drawable.circle_background);
                this.f5701dp = (ImageView) viewInflate.findViewById(R.id.buddy_image);
                this.f5701dp.setBackgroundResource(R.drawable.circle_background);
                this.f5703dr = (FrameLayout) viewInflate.findViewById(R.id.translator_popup_bubby_side);
                this.f5704ds = (LinearLayout) viewInflate.findViewById(R.id.translator_popup_bubby_side_dimmer);
                this.f5705dt = (TextView) viewInflate.findViewById(R.id.translator_popup_bubby_msg_original);
                this.f5706du = (TextView) viewInflate.findViewById(R.id.translator_popup_bubby_msg_translated);
                this.f5707dv = (FrameLayout) viewInflate.findViewById(R.id.translator_popup_me_side);
                this.f5708dw = (LinearLayout) viewInflate.findViewById(R.id.translator_popup_me_side_dimmer);
                this.f5709dx = (TextView) viewInflate.findViewById(R.id.translator_popup_me_msg_original);
                this.f5710dy = (TextView) viewInflate.findViewById(R.id.translator_popup_me_msg_translated);
                this.f5711dz = viewInflate.findViewById(R.id.translator_popup_buddy_msg_divider);
                this.f5663dA = viewInflate.findViewById(R.id.translator_popup_me_msg_divider);
                try {
                    if (this.f5487D == EnumC2300t.ONETOONE) {
                        C2496n.m10765a(this.f5701dp, this.f5752x, EnumC2498p.ROUND);
                    } else if (this.f5487D == EnumC2300t.GROUPCHAT) {
                        C2496n.m10766a(this.f5701dp, this.f5750v, this.f5658cv, EnumC2300t.GROUPCHAT, EnumC2498p.ROUND);
                        this.f5701dp.setBackgroundResource(R.drawable.circle_background);
                    } else if (this.f5487D == EnumC2300t.TOPIC) {
                        this.f5701dp.setImageDrawable(C2496n.m10753a(EnumC2300t.TOPIC, EnumC2498p.ROUND));
                        this.f5701dp.setBackgroundResource(R.drawable.circle_background);
                    }
                    if (EnumC2300t.MONOLOGUE == this.f5487D) {
                        C2496n.m10763a(this.f5701dp, EnumC2498p.ROUND);
                    }
                } catch (OutOfMemoryError e) {
                    C4904y.m18635a(e, f5461a);
                }
                C1849b c1849bM9017a = C1849b.m9017a(this.f5624cN, android.R.layout.simple_spinner_item, android.R.id.text1, new ArrayList());
                C1849b c1849bM9017a2 = C1849b.m9017a(this.f5624cN, android.R.layout.simple_spinner_item, android.R.id.text1, new ArrayList());
                Iterator<String> it = c1850cM9024d.m9039e().f6998I.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    c1849bM9017a.add(next);
                    c1849bM9017a2.add(next);
                }
                c1849bM9017a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                c1849bM9017a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter((SpinnerAdapter) c1849bM9017a);
                spinner2.setAdapter((SpinnerAdapter) c1849bM9017a2);
                if (f5459P.equals(f5460Q) && f5459P.equals("en-US")) {
                    if (C1865r.m9072c()) {
                        f5460Q = "ar-SA";
                    } else {
                        f5460Q = "zh-CN";
                    }
                }
                if (f5460Q.equals("en-US") && f5459P.equals("en-UK")) {
                    if (C1865r.m9072c()) {
                        f5460Q = "ar-SA";
                    } else {
                        f5460Q = "fr-FR";
                    }
                }
                f5467dk = C1850c.m9024d().m9039e().m9013d(f5459P);
                f5468dl = C1850c.m9024d().m9039e().m9014e(f5460Q);
                int iM7878a = m7878a(c1850cM9024d, f5468dl, spinner);
                int iM7878a2 = m7878a(c1850cM9024d, f5467dk, spinner2);
                spinner.setSelection(iM7878a);
                spinner2.setSelection(iM7878a2);
                f5468dl = c1850cM9024d.m9034b((String) ((ArrayAdapter) spinner.getAdapter()).getItem(iM7878a));
                f5467dk = c1850cM9024d.m9034b((String) ((ArrayAdapter) spinner2.getAdapter()).getItem(iM7878a2));
                if (!z && c1505a != null) {
                    if (c1505a.m8356a()) {
                        if (C1865r.m9070b()) {
                            if (checkBox.isChecked()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else if (checkBox2.isChecked()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = true;
                    }
                    m8076b(c1505a.m8356a(), z2);
                    if (C1865r.m9070b()) {
                        m7928a(c1670dx, c1505a.m8356a());
                    } else {
                        m7928a(c1670dx2, c1505a.m8356a());
                    }
                    c1505a.m8353a(new C1657dk(this, checkBox, checkBox2, c1670dx, c1670dx2));
                }
                if (z) {
                    this.f5704ds.setVisibility(8);
                    this.f5707dv.setVisibility(8);
                }
            } catch (OutOfMemoryError e2) {
                C4904y.m18635a(e2, f5461a);
            }
        } catch (Exception e3) {
            C4904y.m18635a(e3, f5461a);
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7928a(C1670dx c1670dx, boolean z) {
        TextView textView;
        TextView textView2;
        if (this.f5698dm) {
            m7904a(c1670dx.f6218a, z);
        } else {
            m7904a(c1670dx.f6218a, false);
        }
        m8084bb();
        if (c1670dx.f6219b != null) {
            m7904a(c1670dx.f6219b, z);
            Spinner spinner = (Spinner) c1670dx.f6219b.findViewById(R.id.spinner2);
            if (spinner != null && (textView2 = (TextView) spinner.findViewById(android.R.id.text1)) != null) {
                if (z) {
                    textView2.setTextColor(getResources().getColor(R.color.translation_popup_text_normal));
                } else {
                    textView2.setTextColor(getResources().getColor(R.color.translation_popup_text_disable));
                }
            }
        }
        if (c1670dx.f6220c != null) {
            m7904a(c1670dx.f6220c, z);
            Spinner spinner2 = (Spinner) c1670dx.f6220c.findViewById(R.id.spinner1);
            if (spinner2 != null && (textView = (TextView) spinner2.findViewById(android.R.id.text1)) != null) {
                if (z) {
                    textView.setTextColor(getResources().getColor(R.color.translation_popup_text_normal));
                } else {
                    textView.setTextColor(getResources().getColor(R.color.translation_popup_text_disable));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8076b(boolean z, boolean z2) {
        if (z) {
            m8068b(this.f5704ds);
            m8084bb();
        } else {
            m7905a(this.f5704ds);
            m8084bb();
        }
        if (!z2) {
            m8068b(this.f5708dw);
            m8086bc();
        } else {
            m7905a(this.f5708dw);
            m8086bc();
        }
    }

    /* renamed from: a */
    private void m7905a(LinearLayout linearLayout) {
        linearLayout.setVisibility(0);
    }

    /* renamed from: b */
    private void m8068b(LinearLayout linearLayout) {
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bb */
    public void m8084bb() {
        this.f5705dt.setText(m7897a(f5468dl, R.string.translator_popup_friend_msg));
        this.f5706du.setText(m7897a(f5467dk, R.string.translator_popup_friend_msg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bc */
    public void m8086bc() {
        this.f5709dx.setText(m7897a(f5467dk, R.string.translator_popup_me_msg));
        this.f5710dy.setText(m7897a(f5468dl, R.string.translator_popup_me_msg));
    }

    /* renamed from: a */
    private String m7897a(String str, int i) throws Resources.NotFoundException {
        Locale localeM9037c;
        String string = null;
        if (this.f5624cN == null || str == null) {
            return null;
        }
        try {
            Locale locale = getResources().getConfiguration().locale;
            C1850c c1850cM9024d = C1850c.m9024d();
            if (str.equals("es-ES")) {
                localeM9037c = new Locale("es", "ES");
            } else if (str.equals("zh-CN")) {
                localeM9037c = new Locale("zh", "CN");
            } else {
                localeM9037c = c1850cM9024d.m9037c(str);
            }
            Configuration configuration = new Configuration(getResources().getConfiguration());
            configuration.locale = localeM9037c;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f5624cN.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            string = new Resources(this.f5624cN.getAssets(), displayMetrics, configuration).getString(i);
            configuration.locale = locale;
            this.f5624cN.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            new Resources(this.f5624cN.getAssets(), displayMetrics, configuration);
            return string;
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f5461a);
                return string;
            }
            return string;
        }
    }

    /* renamed from: a */
    private void m7904a(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            viewGroup.setEnabled(z);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setEnabled(z);
            }
        }
    }

    /* renamed from: a */
    private int m7878a(C1850c c1850c, String str, Spinner spinner) {
        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        for (int i = 0; i < arrayAdapter.getCount(); i++) {
            if (str.equals(c1850c.m9034b((String) arrayAdapter.getItem(i)))) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7929a(C1729gb c1729gb) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5624cN);
        abstractC4932aM18733a.mo18742a(true);
        LayoutInflater layoutInflater = (LayoutInflater) this.f5624cN.getSystemService("layout_inflater");
        abstractC4932aM18733a.mo18734a(R.string.translate);
        View viewM7886a = m7886a(layoutInflater, true, (C1505a) null);
        abstractC4932aM18733a.mo18742a(true);
        abstractC4932aM18733a.mo18748b(viewM7886a);
        viewM7886a.findViewById(R.id.linearlayout_translate_incoming_msg).setVisibility(8);
        viewM7886a.findViewById(R.id.layout_auto_translate).setVisibility(8);
        Spinner spinner = (Spinner) viewM7886a.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) viewM7886a.findViewById(R.id.spinner2);
        C1850c c1850cM9024d = C1850c.m9024d();
        spinner.setOnItemSelectedListener(new C1658dl(this, c1850cM9024d, spinner, spinner2, (CheckBox) viewM7886a.findViewById(R.id.checkbox_translate_incoming_msg)));
        spinner2.setOnItemSelectedListener(new C1659dm(this, c1850cM9024d, spinner2));
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1660dn(this, c1850cM9024d, c1729gb));
        abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1661do(this));
        abstractC4932aM18733a.mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7931a(C1850c c1850c, C1729gb c1729gb, String str, String str2) {
        this.f5664dB = new ProgressDialog(getActivity());
        this.f5664dB.setMessage(getResources().getString(R.string.dialog_connecting_server));
        this.f5664dB.show();
        new AsyncTaskC1674ea(this, c1850c, str, str2).execute(c1729gb);
    }

    /* renamed from: b */
    private boolean m8079b(C1729gb c1729gb) {
        boolean z = true;
        if (!TextUtils.isEmpty(c1729gb.f6429aT) && (TextUtils.isEmpty(c1729gb.f6422aM) || !c1729gb.f6422aM.equals(c1729gb.f6429aT))) {
            z = false;
        }
        if (c1729gb.f6430aU == EnumC2216ad.WITHDRAW_SUCCESS) {
            return false;
        }
        return z;
    }

    /* renamed from: bd */
    private void m8088bd() {
        Editable text = this.f5564bF.getText();
        if (text != null) {
            String string = text.toString();
            if (this.f5560bB && string.replaceAll(" ", "").replaceAll("\n", "").length() > 0) {
                this.f5641ce.setEnabled(true);
                this.f5642cf.setEnabled(true);
                if (this.f5699dn) {
                    if (this.f5700do) {
                        this.f5642cf.setVisibility(8);
                        this.f5641ce.setVisibility(0);
                    } else {
                        this.f5642cf.setVisibility(0);
                        this.f5641ce.setVisibility(8);
                    }
                } else {
                    this.f5641ce.setVisibility(0);
                    this.f5642cf.setVisibility(8);
                }
                this.f5662cz.setVisibility(8);
                return;
            }
            if (string.replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
                this.f5642cf.setEnabled(false);
                this.f5642cf.setVisibility(8);
                if (this.f5548aq) {
                    this.f5641ce.setEnabled(true);
                    this.f5641ce.setVisibility(0);
                    this.f5642cf.setVisibility(8);
                    this.f5662cz.setVisibility(8);
                    return;
                }
                this.f5641ce.setEnabled(false);
                if (m8277v()) {
                    this.f5641ce.setVisibility(8);
                    this.f5642cf.setVisibility(8);
                    this.f5662cz.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: v */
    boolean m8277v() {
        return this.f5573bO && this.f5637ca != EnumC2301u.LIVE;
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: e */
    public void mo8255e(boolean z, Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("message_content"));
        SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17227a = C4542g.m17227a(string);
        if (specialBuddyShareContentsEntryM17227a == null) {
            C4904y.m18639b("onLiveShareClickListener(), parsing error : " + string, f5461a);
            return;
        }
        if (TextUtils.isEmpty(specialBuddyShareContentsEntryM17227a.f8585id)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("onLiveShareClickListener(), parsing error #2 : " + string, f5461a);
                return;
            }
            return;
        }
        C4904y.m18639b("onLiveShareClickListener(), request entry : " + specialBuddyShareContentsEntryM17227a, f5461a);
        Intent intentM17225a = C4542g.m17225a(this.f5624cN, String.valueOf(specialBuddyShareContentsEntryM17227a.f8585id));
        intentM17225a.putExtra("key_intent_ctid", specialBuddyShareContentsEntryM17227a.hash);
        intentM17225a.putExtra("key_buddy_name", specialBuddyShareContentsEntryM17227a.name);
        if (specialBuddyShareContentsEntryM17227a.f8585id.equals(this.f5752x)) {
            mo8272q();
            if (!C4847bl.m18333a()) {
                ((InterfaceC1668dv) getActivity()).mo7820a(intentM17225a.getExtras());
                return;
            }
            return;
        }
        intentM17225a.putExtra(C4892m.f17834a, true);
        startActivity(intentM17225a);
    }

    @Override // com.sec.chaton.chat.InterfaceC1773hs
    /* renamed from: f */
    public void mo8260f(boolean z, Cursor cursor) {
        if (this.f5624cN != null && cursor != null && !cursor.isClosed()) {
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17238c = C4542g.m17238c(string);
            if (specialBuddyRecommendBuddyEntryM17238c == null) {
                C4904y.m18639b("onLiveRecommendClickListener(), parsing error : " + string, f5461a);
                return;
            }
            C4904y.m18639b("onLIveRecommendClickListener(), request entry : " + specialBuddyRecommendBuddyEntryM17238c, f5461a);
            Intent intentM17225a = C4542g.m17225a(this.f5624cN, String.valueOf(specialBuddyRecommendBuddyEntryM17238c.f8584id));
            intentM17225a.putExtra("key_buddy_name", specialBuddyRecommendBuddyEntryM17238c.name);
            if (specialBuddyRecommendBuddyEntryM17238c.f8584id.equals(this.f5752x)) {
                mo8272q();
                if (!C4847bl.m18333a()) {
                    ((InterfaceC1668dv) getActivity()).mo7820a(intentM17225a.getExtras());
                    return;
                }
                return;
            }
            intentM17225a.putExtra(C4892m.f17834a, true);
            startActivity(intentM17225a);
        }
    }

    /* renamed from: a */
    private SlookAirButton m7888a(View view, int i) {
        C4887j c4887j = new C4887j(EnumC2214ab.ANICON);
        c4887j.setEmptyText(getString(R.string.airbutton_no_emoticon));
        SlookAirButton slookAirButton = new SlookAirButton(view, c4887j, i);
        slookAirButton.setItemSelectListener(new C1700f(this));
        slookAirButton.setGravity(1);
        slookAirButton.setDirection(-1);
        slookAirButton.setScrollEnabled(true);
        slookAirButton.setPosition(20, 0);
        return slookAirButton;
    }

    /* renamed from: b */
    private SlookAirButton m8062b(View view, int i) {
        C4887j c4887j = new C4887j(EnumC2214ab.IMAGE);
        c4887j.setEmptyText(getString(R.string.airbutton_no_image));
        SlookAirButton slookAirButton = new SlookAirButton(view, c4887j, i);
        slookAirButton.setItemSelectListener(new C1727g(this));
        slookAirButton.setGravity(1);
        slookAirButton.setDirection(-1);
        slookAirButton.setScrollEnabled(true);
        slookAirButton.setPosition(120, 0);
        return slookAirButton;
    }

    /* renamed from: w */
    public ArrayList<String> m8278w() {
        return this.f5588bd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: be */
    public void m8090be() {
        if (this.f5624cN != null) {
            ((ActionBarFragmentActivity) this.f5624cN).m18784t().mo18835e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bf */
    public void m8091bf() {
        if (!GlobalApplication.m10286e() && this.f5624cN != null) {
            ((ActionBarFragmentActivity) this.f5624cN).m18784t().mo18837f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m8208t(String str) {
        int iM3094l;
        if (GlobalApplication.m10286e() && (getActivity() instanceof TabActivity) && (iM3094l = ((TabActivity) getActivity()).m3094l()) == R.id.fragment_msg_box) {
            Fragment fragmentMo180a = getActivity().m50e().mo180a(iM3094l);
            if (fragmentMo180a instanceof MsgboxFragment) {
                ((MsgboxFragment) fragmentMo180a).m11099b(this.f5750v);
            }
        }
    }

    /* renamed from: h */
    private void m8157h(boolean z) {
        if (!GlobalApplication.m10286e() && !this.f5509aB && this.f5693df != null && this.f5690dc != null) {
            int visibility = this.f5693df.getVisibility();
            int i = z ? 8 : 0;
            this.f5690dc.setVisibility(i);
            if (this.f5691dd != null) {
                if (visibility == 8 && i == 8) {
                    this.f5691dd.setVisibility(8);
                } else {
                    this.f5691dd.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: bg */
    private void m8093bg() {
        if (this.f5624cN != null && this.f5679dR == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f5679dR = new C1671dy(this, null);
            this.f5624cN.registerReceiver(this.f5679dR, intentFilter);
            if (C4904y.f17873c) {
                C4904y.m18641c("Register lockreceiver", f5461a);
            }
        }
    }

    /* renamed from: bh */
    private void m8096bh() {
        if (this.f5624cN != null && this.f5679dR != null) {
            this.f5624cN.unregisterReceiver(this.f5679dR);
            this.f5679dR = null;
            if (C4904y.f17873c) {
                C4904y.m18641c("Unregister lockreceiver", f5461a);
            }
        }
    }

    /* renamed from: a */
    private void m7945a(ArrayList<String> arrayList, ArrayList<String> arrayList2) throws Resources.NotFoundException {
        String string;
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
            abstractC4932aM18733a.mo18734a(R.string.invite_contact_buddy_popup_title);
            if (C3847e.m14691aw()) {
                string = CommonApplication.m18732r().getResources().getString(R.string.invite_contact_buddy_popup_message_for_free, Integer.valueOf(size));
            } else {
                string = CommonApplication.m18732r().getResources().getString(R.string.invite_contact_buddy_popup_message_for_charging, Integer.valueOf(size));
            }
            abstractC4932aM18733a.mo18749b(string);
            abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.layout_chat_fragment_send, new DialogInterfaceOnClickListenerC1781i(this, arrayList, arrayList2)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1754h(this));
            abstractC4932aM18733a.mo18745a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7946a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) throws Resources.NotFoundException {
        String string = CommonApplication.m18732r().getResources().getString(R.string.invite_message, "\nhttp://www.chaton.com/invite.html");
        Iterator<String> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            String str = (arrayList3 == null || arrayList3.size() < i + 1) ? string : arrayList3.get(i);
            i++;
            BackgroundSenderService.m15513a(this.f5624cN, str, new String[]{next});
        }
        Iterator<String> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            i++;
            BackgroundSenderService.m15513a(this.f5624cN, string, new String[]{it2.next()});
        }
        m8143f(i);
        if (C4904y.f17872b) {
            C4904y.m18639b("sendSmsInternal() to [" + arrayList + "] with server message and [" + arrayList2 + "] with default message.", f5461a);
        }
        if (this.f5753y && this.f5487D == EnumC2300t.GROUPCHAT && this.f5590bf != null && this.f5590bf.size() > 0) {
            this.f5546ao.startInsert(22, null, C2220ah.m10087a(this.f5750v, this.f5590bf), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bi */
    public void m8098bi() {
        this.f5546ao.startDelete(1, null, C2306z.f8229a, "message_inbox_no=? AND message_sender=?", new String[]{this.f5750v, "push_connectivity"});
        m8075b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8143f(int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("updateContactBuddyIsInvitedSystemMessage(count[" + i + "])", f5461a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d,%s", Integer.valueOf(EnumC2231as.INVITE_CONTACT.m10100a()), Integer.valueOf(i))).append(Config.KEYVALUE_SPLIT);
        C2204r.m10054c(this.f5546ao, 1, this.f5750v, sb.toString(), C4809aa.m18104a().m18121a("chaton_id", ""));
    }

    /* renamed from: a */
    public void m8235a(String str, String str2, String str3) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f5624cN, R.string.popup_no_network_connection, 0).show();
        } else {
            new AsyncTaskC1672dz(this, str, str2, str3).execute(new Void[0]);
        }
    }

    /* renamed from: b */
    public static void m8075b(boolean z) {
        f5462al = z;
    }

    /* renamed from: x */
    public static boolean m8214x() {
        return f5462al;
    }

    /* renamed from: y */
    public void m8279y() {
        C4904y.m18634a("clearToGoSMSMsg SMS Bubble shown state : " + m8214x(), f5461a);
        if (m8214x()) {
            try {
                m8098bi();
            } catch (Exception e) {
                m8075b(false);
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f5461a);
                }
            }
        }
    }

    /* renamed from: z */
    public void m8280z() throws Resources.NotFoundException {
        String string;
        if (this.f5487D == EnumC2300t.TOPIC && this.f5604bt != null) {
            this.f5719eH = (FrameLayout) this.f5558b.findViewById(R.id.layoutTopicChatWelcome);
            this.f5719eH.setVisibility(0);
            TextView textView = (TextView) this.f5719eH.findViewById(R.id.textTopicWelcome);
            if (!TextUtils.isEmpty(this.f5604bt.ctid)) {
                string = CommonApplication.m18732r().getResources().getString(R.string.topic_cp_chat_welcome_message, this.f5604bt.channelname + ": " + this.f5597bm);
            } else {
                string = CommonApplication.m18732r().getResources().getString(R.string.topic_cp_chat_welcome_message, this.f5597bm);
            }
            textView.setText(string);
            this.f5720eI = AnimationUtils.loadAnimation(CommonApplication.m18732r(), R.anim.bottom_up);
            this.f5720eI.setAnimationListener(this.f5721eJ);
            new Handler().postDelayed(new RunnableC1789k(this), 3000L);
        }
    }
}
