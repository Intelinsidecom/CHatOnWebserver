package com.sec.chaton.chat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
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
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.common.entry.BuddyEntry;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.HttpMessageControl;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.control.task.FileDownloadTask2;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.dialogmenu.DialogMenu;
import com.sec.chaton.dialogmenu.DialogMenuOnClickListener;
import com.sec.chaton.dialogmenu.ListItem;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.audio.RecordAudio;
import com.sec.chaton.multimedia.emoticon.EmoticonAdapter;
import com.sec.chaton.multimedia.emoticon.EmoticonUsage;
import com.sec.chaton.multimedia.emoticon.EmoticonUsageManager;
import com.sec.chaton.multimedia.emoticon.RichString;
import com.sec.chaton.multimedia.geotag.GeotagActivity;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcalendar.VCalendarListActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.multimedia.vcard.VCardReadContactActivity;
import com.sec.chaton.multimedia.video.VideoRecordActivity;
import com.sec.chaton.network.NetState;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.settings.ActivitySkinChange;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.Dip;
import com.sec.chaton.util.InBoxNoGenerator;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.chaton.widget.SMSProgressBar;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.cropimage.ImageModify;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Timer;

/* loaded from: classes.dex */
public class ChatFragment extends Fragment implements MediaPlayer.OnCompletionListener, View.OnClickListener, AdapterView.OnItemClickListener, ChatActivity.OnBackKeyListener, OnChatItemClickListener, DialogMenuOnClickListener {

    /* renamed from: a */
    public static final String f722a = ChatFragment.class.getSimpleName();

    /* renamed from: b */
    public static String f723b = "extra fileuri";

    /* renamed from: c */
    public static String f724c = "extra participant";

    /* renamed from: d */
    public static String f725d = "extra title";

    /* renamed from: e */
    public static String f726e = "extra vcalendar";

    /* renamed from: f */
    public static String f727f = "extra vard name";

    /* renamed from: g */
    public static String f728g = "extra initchat";

    /* renamed from: h */
    public static String f729h = "extra showinput";

    /* renamed from: n */
    static boolean f730n = false;

    /* renamed from: A */
    ChatONContract.MessageTable.MsgContentType f731A;

    /* renamed from: B */
    Dialog f732B;

    /* renamed from: C */
    ArrayList f733C;

    /* renamed from: D */
    public ProgressDialog f734D;

    /* renamed from: E */
    View.OnClickListener f735E;

    /* renamed from: F */
    ContentObserver f736F;

    /* renamed from: G */
    ContentObserver f737G;

    /* renamed from: H */
    ContentObserver f738H;

    /* renamed from: I */
    ContentObserver f739I;

    /* renamed from: J */
    Handler f740J;

    /* renamed from: K */
    NotifyingAsyncQueryHandler.AsyncQueryListener f741K;

    /* renamed from: L */
    private Object f742L = new Object();

    /* renamed from: M */
    private NotifyingAsyncQueryHandler f743M;

    /* renamed from: N */
    private File f744N;

    /* renamed from: O */
    private ImageButton f745O;

    /* renamed from: P */
    private ImageButton f746P;

    /* renamed from: Q */
    private Button f747Q;

    /* renamed from: R */
    private Button f748R;

    /* renamed from: S */
    private Button f749S;

    /* renamed from: T */
    private Button f750T;

    /* renamed from: U */
    private Button f751U;

    /* renamed from: V */
    private LinearLayout f752V;

    /* renamed from: W */
    private LinearLayout f753W;

    /* renamed from: X */
    private LinearLayout f754X;

    /* renamed from: Y */
    private ListView f755Y;

    /* renamed from: Z */
    private ChatListAdapter f756Z;

    /* renamed from: aA */
    private String f757aA;

    /* renamed from: aB */
    private int f758aB;

    /* renamed from: aC */
    private String f759aC;

    /* renamed from: aD */
    private String f760aD;

    /* renamed from: aE */
    private boolean f761aE;

    /* renamed from: aF */
    private int f762aF;

    /* renamed from: aG */
    private ImageButton f763aG;

    /* renamed from: aH */
    private ImageView f764aH;

    /* renamed from: aI */
    private TextView f765aI;

    /* renamed from: aJ */
    private Button f766aJ;

    /* renamed from: aK */
    private CheckBox f767aK;

    /* renamed from: aL */
    private InputMethodManager f768aL;

    /* renamed from: aM */
    private TextView f769aM;

    /* renamed from: aN */
    private TextView f770aN;

    /* renamed from: aO */
    private ImageView f771aO;

    /* renamed from: aP */
    private ImageView f772aP;

    /* renamed from: aQ */
    private ImageView f773aQ;

    /* renamed from: aR */
    private GridView f774aR;

    /* renamed from: aS */
    private GridView f775aS;

    /* renamed from: aT */
    private ScrollView f776aT;

    /* renamed from: aU */
    private Bundle f777aU;

    /* renamed from: aV */
    private HttpMessageControl f778aV;

    /* renamed from: aW */
    private boolean f779aW;

    /* renamed from: aX */
    private int f780aX;

    /* renamed from: aY */
    private AlertDialog.Builder f781aY;

    /* renamed from: aZ */
    private final long f782aZ;

    /* renamed from: aa */
    private Cursor f783aa;

    /* renamed from: ab */
    private ProgressDialog f784ab;

    /* renamed from: ac */
    private MessageControl f785ac;

    /* renamed from: ad */
    private ArrayList f786ad;

    /* renamed from: ae */
    private HashMap f787ae;

    /* renamed from: af */
    private Long f788af;

    /* renamed from: ag */
    private String f789ag;

    /* renamed from: ah */
    private String f790ah;

    /* renamed from: ai */
    private String f791ai;

    /* renamed from: aj */
    private String f792aj;

    /* renamed from: ak */
    private String f793ak;

    /* renamed from: al */
    private String f794al;

    /* renamed from: am */
    private String f795am;

    /* renamed from: an */
    private String f796an;

    /* renamed from: ao */
    private String f797ao;

    /* renamed from: ap */
    private int f798ap;

    /* renamed from: aq */
    private Uri f799aq;

    /* renamed from: ar */
    private boolean f800ar;

    /* renamed from: as */
    private EditText f801as;

    /* renamed from: at */
    private long f802at;

    /* renamed from: au */
    private TextView f803au;

    /* renamed from: av */
    private TextView f804av;

    /* renamed from: aw */
    private EmoticonUsageManager f805aw;

    /* renamed from: ax */
    private EmoticonUsageManager f806ax;

    /* renamed from: ay */
    private String f807ay;

    /* renamed from: az */
    private String f808az;

    /* renamed from: ba */
    private final long f809ba;

    /* renamed from: bb */
    private boolean f810bb;

    /* renamed from: bc */
    private TrunkMessageControl f811bc;

    /* renamed from: bd */
    private Handler f812bd;

    /* renamed from: i */
    String f813i;

    /* renamed from: j */
    LinearLayout f814j;

    /* renamed from: k */
    LinearLayout f815k;

    /* renamed from: l */
    LinearLayout f816l;

    /* renamed from: m */
    LinearLayout f817m;

    /* renamed from: o */
    public boolean f818o;

    /* renamed from: p */
    public boolean f819p;

    /* renamed from: q */
    public boolean f820q;

    /* renamed from: r */
    public Boolean f821r;

    /* renamed from: s */
    public String f822s;

    /* renamed from: t */
    public boolean f823t;

    /* renamed from: u */
    public String f824u;

    /* renamed from: v */
    public int f825v;

    /* renamed from: w */
    ChatONContract.InBoxTable.ChatType f826w;

    /* renamed from: x */
    String f827x;

    /* renamed from: y */
    int f828y;

    /* renamed from: z */
    String f829z;

    public ChatFragment() {
        this.f813i = StorageStateInfoUtil.m3677a() ? GlobalApplication.m2386d().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
        this.f744N = new File(this.f813i + "/skins/");
        this.f818o = false;
        this.f819p = false;
        this.f820q = false;
        this.f821r = false;
        this.f784ab = null;
        this.f823t = true;
        this.f824u = "";
        this.f825v = 0;
        this.f800ar = true;
        this.f761aE = false;
        this.f762aF = 0;
        this.f732B = null;
        this.f733C = new ArrayList();
        this.f782aZ = 10485760L;
        this.f809ba = 3145728L;
        this.f810bb = false;
        this.f812bd = new HandlerC0143e(this);
        this.f735E = new ViewOnClickListenerC0159u(this);
        this.f736F = new C0158t(this, new Handler());
        this.f737G = new C0161w(this, new Handler());
        this.f738H = new C0160v(this, new Handler());
        this.f739I = new C0162x(this, new Handler());
        this.f740J = new HandlerC0137ab(this);
        this.f741K = new C0136aa(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x025c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0 A[Catch: all -> 0x0311, Exception -> 0x031f, FileNotFoundException -> 0x0329, TryCatch #14 {FileNotFoundException -> 0x0329, Exception -> 0x031f, all -> 0x0311, blocks: (B:31:0x00cd, B:32:0x00d0, B:34:0x00d6, B:35:0x00e3, B:37:0x0105, B:38:0x0108, B:39:0x0128, B:40:0x0137, B:62:0x01b0, B:60:0x01a1), top: B:145:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d6 A[Catch: all -> 0x0311, Exception -> 0x031f, FileNotFoundException -> 0x0329, TryCatch #14 {FileNotFoundException -> 0x0329, Exception -> 0x031f, all -> 0x0311, blocks: (B:31:0x00cd, B:32:0x00d0, B:34:0x00d6, B:35:0x00e3, B:37:0x0105, B:38:0x0108, B:39:0x0128, B:40:0x0137, B:62:0x01b0, B:60:0x01a1), top: B:145:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0105 A[Catch: all -> 0x0311, Exception -> 0x031f, FileNotFoundException -> 0x0329, TryCatch #14 {FileNotFoundException -> 0x0329, Exception -> 0x031f, all -> 0x0311, blocks: (B:31:0x00cd, B:32:0x00d0, B:34:0x00d6, B:35:0x00e3, B:37:0x0105, B:38:0x0108, B:39:0x0128, B:40:0x0137, B:62:0x01b0, B:60:0x01a1), top: B:145:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1 A[Catch: all -> 0x0311, Exception -> 0x031f, FileNotFoundException -> 0x0329, TRY_ENTER, TryCatch #14 {FileNotFoundException -> 0x0329, Exception -> 0x031f, all -> 0x0311, blocks: (B:31:0x00cd, B:32:0x00d0, B:34:0x00d6, B:35:0x00e3, B:37:0x0105, B:38:0x0108, B:39:0x0128, B:40:0x0137, B:62:0x01b0, B:60:0x01a1), top: B:145:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a0  */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r0v71 */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m708a(android.content.Context r11, java.io.File r12, java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 829
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.m708a(android.content.Context, java.io.File, java.lang.String):java.io.File");
    }

    /* renamed from: a */
    static /* synthetic */ String m710a(ChatFragment chatFragment, Object obj) {
        String str = chatFragment.f790ah + obj;
        chatFragment.f790ah = str;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m712a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f811bc.retrieveTrunkList(arrayList);
    }

    /* renamed from: a */
    private void m713a(String str, ChatONContract.MessageTable.MsgContentType msgContentType) {
        String str2 = "";
        for (int i = 0; i < this.f786ad.size(); i++) {
            str2 = str2 + "+" + ((String) this.f786ad.get(i)) + ";";
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        Intent intent = new Intent("android.intent.action.VIEW");
        if (msgContentType == ChatONContract.MessageTable.MsgContentType.TEXT) {
            intent.putExtra("sms_body", str);
        }
        ChatONLogWriter.m3509d("number:" + strSubstring);
        intent.putExtra("sms_body", str);
        intent.putExtra("address", strSubstring);
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }

    /* renamed from: e */
    private void m724e() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_temp_msg", this.f801as.getText().toString());
        this.f743M.startUpdate(-1, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no=?", new String[]{this.f822s});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m726f() {
        ChatONFileUtil.m3483a((StorageStateInfoUtil.m3677a() ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath()) + "/" + this.f822s);
        this.f785ac.m2057d();
        getActivity().finish();
    }

    /* renamed from: g */
    private void m729g() {
        this.f776aT.setVisibility(8);
        this.f819p = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_animation_msg, C0062R.drawable.attach_ani_message, 9));
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_picture, C0062R.drawable.attach_pictures, 0));
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_capture_picture, C0062R.drawable.attach_capture_picture, 1));
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_video, C0062R.drawable.attach_video, 2));
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_record_video, C0062R.drawable.attach_record_video, 3));
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_reocrd_audio, C0062R.drawable.attach_record_audio, 4));
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_contact, C0062R.drawable.attach_namecard, 6));
        arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_calendar, C0062R.drawable.attach_calendar, 7));
        if (ChatONConst.m1972a()) {
            arrayList.add(new ListItem(getResources(), C0062R.string.menu_multimedia_geo_tag, C0062R.drawable.attach_geotag, 8));
        }
        new DialogMenu(this, null, arrayList).m2339a().show();
    }

    /* renamed from: a */
    public AlertDialog.Builder m753a(MessageResultEntry.errorCode errorcode) {
        this.f781aY = new AlertDialog.Builder(getActivity());
        if (errorcode == MessageResultEntry.errorCode.END_APP) {
            this.f781aY.setMessage(C0062R.string.auth_error_end).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0163y(this));
            return this.f781aY;
        }
        if (errorcode != MessageResultEntry.errorCode.RESTART_APP) {
            return null;
        }
        this.f781aY.setMessage(C0062R.string.auth_error_restart).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0138ac(this));
        return this.f781aY;
    }

    /* renamed from: a */
    public void m754a() {
        if (this.f820q) {
            return;
        }
        this.f801as.requestFocus();
        if (this.f762aF == 1) {
            this.f768aL.hideSoftInputFromWindow(this.f801as.getWindowToken(), 0);
        } else {
            this.f768aL.showSoftInput(this.f801as, 2);
        }
        this.f820q = true;
    }

    /* renamed from: a */
    public void m755a(Display display) {
        float count = this.f775aS.getCount() / ((int) (Dip.m3572b(display.getWidth()) / 42.6d));
        String strSubstring = Float.toString(count).substring(2, 3);
        ChatONLogWriter.m3509d("ch:" + ((int) ((((int) count) + 1) * 45.5d)));
        if (strSubstring.equals("0")) {
            this.f775aS.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) Dip.m3571a((int) (((int) count) * 45.5d))));
            ChatONLogWriter.m3509d("rowcount" + ((int) count));
        } else {
            this.f775aS.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) Dip.m3571a((int) ((((int) count) + 1) * 45.5d))));
            ChatONLogWriter.m3509d("rowcount" + (((int) count) + 1));
        }
    }

    @Override // com.sec.chaton.chat.OnChatItemClickListener
    /* renamed from: a */
    public void mo756a(View view) {
        String strReplace;
        this.f768aL.hideSoftInputFromWindow(this.f801as.getWindowToken(), 0);
        int positionForView = this.f755Y.getPositionForView(view);
        Cursor cursor = this.f756Z.getCursor();
        cursor.moveToPosition(positionForView);
        ChatONContract.MessageTable.MsgContentType msgContentTypeM2195a = ChatONContract.MessageTable.MsgContentType.m2195a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        String string = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
        int i = cursor.getInt(cursor.getColumnIndex("message_stored_ext"));
        ChatONLogWriter.m3506b("[onItemClickListener] view:" + view + " v.getTag():" + view.getTag(), getClass().getName());
        View view2 = (View) view.getTag();
        if (view.getId() == C0062R.id.imageSndContent) {
            ChatONLogWriter.m3509d("file uri:" + string2);
            if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.CALENDAR) {
                if (string2 != null) {
                    if ((!StorageStateInfoUtil.m3677a() && i == 1) || (StorageStateInfoUtil.m3677a() && i == 0)) {
                        this.f784ab.show();
                        this.f785ac.m2046a(string2, false, string, j, msgContentTypeM2195a, this.f826w, string4, this.f784ab);
                        return;
                    } else {
                        Intent intent = new Intent(getActivity(), (Class<?>) VCalendarDetailActivity2.class);
                        intent.putExtra("ACTIVITY_PURPOSE", 3);
                        intent.putExtra("URI", string3);
                        getActivity().startActivity(intent);
                        return;
                    }
                }
                return;
            }
            if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                if (string2 != null) {
                    if ((!StorageStateInfoUtil.m3677a() && i == 1) || (StorageStateInfoUtil.m3677a() && i == 0)) {
                        this.f784ab.show();
                        this.f785ac.m2046a(string2, false, string, j, msgContentTypeM2195a, this.f826w, string4, this.f784ab);
                        return;
                    } else {
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ReadVCardActivity.class);
                        intent2.putExtra("URI", string3);
                        intent2.putExtra("VCARD_SAVE", false);
                        getActivity().startActivity(intent2);
                        return;
                    }
                }
                return;
            }
            if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.GEO) {
                StringTokenizer stringTokenizer = new StringTokenizer(string2.toString(), "\n");
                String strNextToken = null;
                while (stringTokenizer.hasMoreTokens()) {
                    strNextToken = stringTokenizer.nextToken();
                }
                Intent intent3 = new Intent(getActivity(), (Class<?>) GeotagActivity.class);
                intent3.putExtra("Geo Point", strNextToken);
                getActivity().startActivity(intent3);
                return;
            }
            if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.AUDIO) {
                if (StorageStateInfoUtil.m3677a()) {
                    ChatListAdapter.m777a(this, msgContentTypeM2195a, string3, this.f784ab);
                    return;
                } else {
                    Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                    return;
                }
            }
            if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.VIDEO) {
                ChatListAdapter.m777a(this, msgContentTypeM2195a, string3, this.f784ab);
                return;
            }
            if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.IMAGE) {
                getActivity().startActivity(new Intent("android.intent.action.VIEW"));
                return;
            }
            if (string3 == null || !string3.contains(DatabaseConstant.TrunkItemColumns.KEY_THUMBNAIL)) {
                strReplace = string3;
            } else {
                if (!StorageStateInfoUtil.m3677a()) {
                    Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                    return;
                }
                strReplace = string3.replace("thumbnail/", "");
            }
            ChatListAdapter.m777a(this, msgContentTypeM2195a, strReplace, this.f784ab);
            return;
        }
        if (view.getId() == C0062R.id.imageRcvContent) {
            if (string3 != null && string3.length() != 0 && ((i != 0 || !string3.contains(DatabaseConstant.TrunkItemColumns.KEY_THUMBNAIL)) && ((i != 1 || !string3.contains(DatabaseConstant.TrunkItemColumns.KEY_THUMBNAIL)) && !ChatONConst.f1339c.equals(string3) && (i != 0 || !StorageStateInfoUtil.m3677a())))) {
                ChatListAdapter.m777a(this, msgContentTypeM2195a, string3, this.f784ab);
                return;
            }
            if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.GEO) {
                if ((msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.VIDEO && !StorageStateInfoUtil.m3677a()) || (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.AUDIO && !StorageStateInfoUtil.m3677a())) {
                    Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                    return;
                } else {
                    if (((FileDownloadTask2) MessageControl.m2012a(this.f822s).f1367d.get(Long.valueOf(j))) == null) {
                        this.f785ac.m2033a(view2, positionForView, string2, false, string, j, msgContentTypeM2195a, this.f826w, string4);
                        return;
                    }
                    return;
                }
            }
            if (!ChatONConst.m1972a()) {
                Toast.makeText(getActivity(), C0062R.string.toast_googleMAP_unavailable, 0).show();
                return;
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(string2.toString(), "\n");
            String strNextToken2 = null;
            while (stringTokenizer2.hasMoreTokens()) {
                strNextToken2 = stringTokenizer2.nextToken();
            }
            Intent intent4 = new Intent(getActivity(), (Class<?>) GeotagActivity.class);
            intent4.putExtra("Geo Point", strNextToken2);
            getActivity().startActivity(intent4);
            return;
        }
        if (view.getId() == C0062R.id.imageEtcSndContent || view.getId() == C0062R.id.lLayoutSndContent) {
            if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.CALENDAR) {
                if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                    if (StorageStateInfoUtil.m3677a()) {
                        ChatListAdapter.m777a(this, msgContentTypeM2195a, string3, this.f784ab);
                        return;
                    } else {
                        Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                        return;
                    }
                }
                return;
            }
            if (!StorageStateInfoUtil.m3677a()) {
                Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                return;
            } else {
                if (string3 != null) {
                    Intent intent5 = new Intent(getActivity(), (Class<?>) VCalendarDetailActivity2.class);
                    intent5.putExtra("ACTIVITY_PURPOSE", 3);
                    intent5.putExtra("URI", string3);
                    getActivity().startActivity(intent5);
                    return;
                }
                return;
            }
        }
        if (view.getId() != C0062R.id.imageEtcContent && view.getId() != C0062R.id.lLayoutRcvContent) {
            if (view.getId() == C0062R.id.lLayoutRcvContent || view.getId() == C0062R.id.lLayoutSndContent) {
                this.f768aL.hideSoftInputFromWindow(this.f801as.getWindowToken(), 0);
                return;
            }
            return;
        }
        if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.CALENDAR || msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.CONTACT) {
            if (string3 == null || string3.length() == 0 || ChatONConst.f1339c.equals(string3) || ((!StorageStateInfoUtil.m3677a() && i == 1) || (StorageStateInfoUtil.m3677a() && i == 0))) {
                this.f785ac.m2033a(view2, positionForView, string2, false, string, j, msgContentTypeM2195a, this.f826w, string4);
            } else {
                ChatListAdapter.m777a(this, msgContentTypeM2195a, string3, this.f784ab);
            }
        }
    }

    @Override // com.sec.chaton.chat.OnChatItemClickListener
    /* renamed from: a */
    public void mo757a(View view, long j) {
        this.f785ac.m2052b(j);
    }

    @Override // com.sec.chaton.chat.OnChatItemClickListener
    /* renamed from: a */
    public void mo758a(View view, long j, int i) {
        File file;
        String str;
        int positionForView = this.f755Y.getPositionForView(view);
        Cursor cursor = this.f756Z.getCursor();
        cursor.moveToPosition(positionForView);
        long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("message_content"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        ChatONContract.MessageTable.MsgContentType msgContentTypeM2195a = ChatONContract.MessageTable.MsgContentType.m2195a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        String string4 = cursor.getString(cursor.getColumnIndex("message_formatted"));
        int i2 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
        View view2 = (View) view.getTag();
        switch (i) {
            case 1:
                m713a(string, msgContentTypeM2195a);
                break;
            case 2:
                int iM2753a = NetState.m2753a(GlobalApplication.m2387e());
                if (-3 != iM2753a && -2 != iM2753a) {
                    Button button = (Button) view2.findViewById(C0062R.id.btnResend);
                    Button button2 = (Button) view2.findViewById(C0062R.id.btnFailCancel);
                    if (button != null) {
                        button.setVisibility(8);
                    }
                    if (button2 != null) {
                        button2.setVisibility(8);
                    }
                    if (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.TEXT || msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.GEO) {
                        file = null;
                        str = "";
                    } else {
                        File file2 = new File(URI.create(string3));
                        StringTokenizer stringTokenizer = new StringTokenizer(string3, ".");
                        String strNextToken = "";
                        while (stringTokenizer.hasMoreTokens()) {
                            strNextToken = stringTokenizer.nextToken();
                        }
                        file = file2;
                        str = "." + strNextToken.toUpperCase();
                    }
                    boolean z = this.f827x == null || this.f827x.equals("");
                    if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.TEXT) {
                        if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.GEO) {
                            View view3 = (msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.IMAGE || msgContentTypeM2195a == ChatONContract.MessageTable.MsgContentType.VIDEO) ? (View) view.getTag() : view2;
                            if (i2 != 3) {
                                this.f785ac.m2034a(view3, file, str, msgContentTypeM2195a, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), z, string4, j2);
                                break;
                            } else if (string != null) {
                                String[] strArrSplit = string.split("\n");
                                if (strArrSplit.length > 4) {
                                    ChatONLogWriter.m3506b("[Start Media Chat] " + file.getName(), getClass().getSimpleName());
                                    MessageDatabaseHelper.m2301c(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(j2));
                                    this.f785ac.m2031a(j2, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), z, string4, file, str, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], msgContentTypeM2195a);
                                    break;
                                }
                            }
                        } else {
                            this.f785ac.m2030a(j2, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), z, string);
                            break;
                        }
                    } else {
                        this.f785ac.m2032a(j2, string2, msgContentTypeM2195a, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), string, z);
                        break;
                    }
                } else {
                    Toast.makeText(getActivity(), C0062R.string.toast_network_unable, 0).show();
                    break;
                }
                break;
            case 3:
                this.f743M.startDelete(3, null, ChatONContract.MessageTable.f1726a, "_id='" + j + "'", null);
                break;
        }
    }

    @Override // com.sec.chaton.chat.OnChatItemClickListener
    /* renamed from: a */
    public void mo759a(View view, long j, ChatONContract.MessageTable.MsgContentType msgContentType) {
        this.f785ac.m2029a(j);
    }

    @Override // com.sec.chaton.chat.OnChatItemClickListener
    /* renamed from: a */
    public void mo760a(View view, Uri uri) {
    }

    @Override // com.sec.chaton.chat.OnChatItemClickListener
    /* renamed from: a */
    public void mo761a(View view, ProfileImageView profileImageView, String str, String str2) {
        Intent intent = new Intent(getActivity(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", str);
        intent.putExtra("PROFILE_BUDDY_NAME", str2);
        startActivityForResult(intent, 20);
    }

    @Override // com.sec.chaton.chat.OnChatItemClickListener
    /* renamed from: a */
    public void mo762a(View view, String str, String str2) {
    }

    /* renamed from: a */
    public void m763a(File file) {
        ChatONLogWriter.m3506b("[SendingMedia] Start - Picture", getClass().getSimpleName());
        Intent intent = new Intent(getActivity(), (Class<?>) ImageModify.class);
        intent.setDataAndType(Uri.fromFile(file), "image/*");
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 16);
    }

    /* renamed from: a */
    public void m764a(File file, String str) {
        if (file != null) {
            String upperCase = str.toUpperCase();
            if (!upperCase.equals("MP4") && !upperCase.equals("3GP")) {
                Toast.makeText(getActivity(), getActivity().getResources().getString(C0062R.string.toast_supported_format) + " (" + upperCase + ")", 0).show();
                return;
            }
            String str2 = "." + upperCase.toUpperCase();
            if (file.length() > 10485760) {
                Toast.makeText(getActivity(), C0062R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.f827x) || this.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                MessageControl messageControl = this.f785ac;
                ChatONContract.MessageTable.MsgContentType msgContentType = this.f731A;
                messageControl.m2044a(file, str2, ChatONContract.MessageTable.MsgContentType.VIDEO, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), true, (String) null);
            } else {
                MessageControl messageControl2 = this.f785ac;
                ChatONContract.MessageTable.MsgContentType msgContentType2 = this.f731A;
                messageControl2.m2044a(file, str2, ChatONContract.MessageTable.MsgContentType.VIDEO, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), false, (String) null);
            }
        }
    }

    /* renamed from: a */
    public void m765a(String str, int i, String str2, ChatONContract.InBoxTable.ChatType chatType) {
        if (chatType != ChatONContract.InBoxTable.ChatType.BROADCAST && str2 != null && !str2.equals("null")) {
            this.f785ac.m2057d();
            this.f785ac.m2050a(this.f822s, str, i);
            this.f785ac.m2049a(chatType, this.f822s, this.f788af, str2, this.f822s);
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        MessageControl messageControlM2011a = MessageControl.m2011a(this.f740J, strValueOf);
        messageControlM2011a.m2050a(strValueOf, str, i);
        messageControlM2011a.m2048a(true);
        messageControlM2011a.m2053b(this.f822s);
        this.f785ac.m2056c(Long.MAX_VALUE);
        messageControlM2011a.m2049a(ChatONContract.InBoxTable.ChatType.BROADCAST, this.f822s, this.f788af, str2, this.f822s);
    }

    /* renamed from: a */
    public void m766a(String str, ChatONContract.InBoxTable.ChatType chatType, String str2, String str3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(C0062R.string.menu_chat_close);
        builder.setMessage(C0062R.string.dialog_title_msgbox_delete).setCancelable(false).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0156r(this, str2, chatType, str)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0157s(this));
        builder.setCancelable(true);
        builder.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.chaton.dialogmenu.DialogMenuOnClickListener
    /* renamed from: a */
    public boolean mo767a(Object obj, int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                this.f818o = true;
                return false;
            case 1:
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                this.f799aq = null;
                this.f799aq = Uri.fromFile(new File(StorageStateInfoUtil.m3677a() ? GlobalApplication.m2387e().getExternalCacheDir() : GlobalApplication.m2387e().getCacheDir(), "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));
                intent2.putExtra("output", this.f799aq);
                intent2.putExtra("return-data", true);
                startActivityForResult(intent2, 0);
                this.f818o = true;
                return false;
            case 2:
                Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
                intent3.setType("video/*");
                startActivityForResult(Intent.createChooser(intent3, getActivity().getResources().getString(C0062R.string.dialog_select_video)), 11);
                return false;
            case 3:
                if (StorageStateInfoUtil.m3677a()) {
                    startActivityForResult(new Intent(getActivity(), (Class<?>) VideoRecordActivity.class), 12);
                } else {
                    Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                }
                return false;
            case 4:
                if (StorageStateInfoUtil.m3677a()) {
                    Intent intent4 = new Intent(getActivity(), (Class<?>) RecordAudio.class);
                    intent4.putExtra("inbox_NO", this.f822s);
                    startActivityForResult(intent4, 10);
                } else {
                    Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                }
                return false;
            case 5:
            default:
                return false;
            case 6:
                if (StorageStateInfoUtil.m3677a()) {
                    Intent intent5 = new Intent(getActivity(), (Class<?>) VCardReadContactActivity.class);
                    intent5.putExtra("inbox_NO", this.f822s);
                    startActivityForResult(intent5, 7);
                    this.f818o = true;
                } else {
                    Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                }
                return false;
            case 7:
                if (StorageStateInfoUtil.m3677a()) {
                    Intent intent6 = new Intent(getActivity(), (Class<?>) VCalendarListActivity2.class);
                    intent6.putExtra("inbox_NO", this.f822s);
                    startActivityForResult(intent6, 5);
                    this.f818o = true;
                } else {
                    Toast.makeText(getActivity(), C0062R.string.sdcard_not_found, 0).show();
                }
                return false;
            case 8:
                Intent intent7 = new Intent(getActivity(), (Class<?>) GeotagActivity.class);
                intent7.putExtra("current only", false);
                startActivityForResult(intent7, 6);
                return false;
            case 9:
                startActivityForResult(new Intent(getActivity(), (Class<?>) AMSFileListActivity.class), 15);
                return false;
        }
    }

    /* renamed from: b */
    public void m768b() {
        getActivity().getContentResolver().registerContentObserver(ChatONContract.ParticipantTable.m2199a(this.f822s), true, this.f737G);
    }

    /* renamed from: b */
    public void m769b(Display display) {
        if (display.getHeight() > 480) {
            this.f772aP.setLayoutParams(this.f807ay.equals("skin_myskin.png_") ? new FrameLayout.LayoutParams(1132, 800) : new FrameLayout.LayoutParams(1280, 800));
            if (this.f807ay.equals("skin_bg_02")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern2);
                return;
            }
            if (this.f807ay.equals("pad_chat_bg_01")) {
                this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01_h);
                return;
            }
            if (this.f807ay.equals("skin_bg_04")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern4);
                return;
            }
            if (this.f807ay.equals("skin_bg_05")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern5);
                return;
            }
            if (this.f807ay.equals("skin_bg_06")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern6);
                return;
            }
            if (this.f807ay.equals("skin_bg_03")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern3);
                return;
            }
            if (this.f807ay.equals("skin_bg_07")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern7);
                return;
            }
            if (this.f807ay.equals("skin_bg_08")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern8);
                return;
            }
            if (this.f807ay.equals("skin_bg_09")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern9);
                return;
            }
            if (!this.f807ay.equals("skin_myskin.png_")) {
                this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01_h);
                return;
            }
            try {
                this.f772aP.setImageBitmap(Bitmap.createScaledBitmap(ActivitySkinChange.m3157a(getActivity(), Uri.parse(this.f744N + "/" + this.f807ay), 800), 1132, 800, true));
                return;
            } catch (IOException e) {
                this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01_h);
                e.printStackTrace();
                return;
            }
        }
        this.f772aP.setLayoutParams(this.f807ay.equals("skin_myskin.png_") ? new FrameLayout.LayoutParams(800, 600) : new FrameLayout.LayoutParams(800, 500));
        if (this.f807ay.equals("skin_bg_02")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern2);
            return;
        }
        if (this.f807ay.equals("pad_chat_bg_01")) {
            this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01_h);
            return;
        }
        if (this.f807ay.equals("skin_bg_04")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern4);
            return;
        }
        if (this.f807ay.equals("skin_bg_05")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern5);
            return;
        }
        if (this.f807ay.equals("skin_bg_06")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern6);
            return;
        }
        if (this.f807ay.equals("skin_bg_03")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern3);
            return;
        }
        if (this.f807ay.equals("skin_bg_07")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern7);
            return;
        }
        if (this.f807ay.equals("skin_bg_08")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern8);
            return;
        }
        if (this.f807ay.equals("skin_bg_09")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern9);
            return;
        }
        if (!this.f807ay.equals("skin_myskin.png_")) {
            this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01_h);
            return;
        }
        try {
            this.f772aP.setImageBitmap(Bitmap.createScaledBitmap(ActivitySkinChange.m3157a(getActivity(), Uri.parse(this.f744N + "/" + this.f807ay), 800), 800, 600, true));
        } catch (IOException e2) {
            this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01_h);
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m770b(File file, String str) {
        if (file != null) {
            String upperCase = str.toUpperCase();
            if (!upperCase.equals("MP3") && !upperCase.equals("3GP") && !upperCase.equals("AAC") && !upperCase.equals("AMR") && !upperCase.equals("AMR-NB")) {
                Toast.makeText(getActivity(), getActivity().getResources().getString(C0062R.string.toast_supported_format) + " (" + upperCase + ")", 0).show();
                return;
            }
            String str2 = "." + upperCase.toUpperCase();
            if (file.length() > 3145728) {
                Toast.makeText(getActivity(), C0062R.string.record_video_dialog_limit_title_max_size_reached, 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.f827x) || this.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                MessageControl messageControl = this.f785ac;
                ChatONContract.MessageTable.MsgContentType msgContentType = this.f731A;
                messageControl.m2044a(file, str2, ChatONContract.MessageTable.MsgContentType.AUDIO, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), true, (String) null);
            } else {
                MessageControl messageControl2 = this.f785ac;
                ChatONContract.MessageTable.MsgContentType msgContentType2 = this.f731A;
                messageControl2.m2044a(file, str2, ChatONContract.MessageTable.MsgContentType.AUDIO, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), false, (String) null);
            }
        }
    }

    /* renamed from: c */
    public void m771c() {
        if (this.f761aE) {
            this.f768aL.hideSoftInputFromWindow(this.f801as.getWindowToken(), 0);
            if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB) == ChatONContract.MessageTable.MsgContentType.TEXT || ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB) == ChatONContract.MessageTable.MsgContentType.GEO) {
                synchronized (this.f742L) {
                    if (TextUtils.isEmpty(this.f827x) || this.f827x.equals("null")) {
                        if (this.f826w != ChatONContract.InBoxTable.ChatType.BROADCAST && !this.f734D.isShowing()) {
                            this.f734D.show();
                        }
                        this.f785ac.m2045a(this.f822s, ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB), this.f826w, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), this.f759aC);
                    } else {
                        this.f785ac.m2042a(ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB), this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), this.f759aC);
                    }
                }
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(this.f759aC, ".");
            String strNextToken = "";
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            String str = "." + strNextToken.toUpperCase();
            File file = new File(URI.create(this.f759aC));
            if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB) != ChatONContract.MessageTable.MsgContentType.IMAGE) {
                if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB) == ChatONContract.MessageTable.MsgContentType.VIDEO) {
                    m764a(file, str.substring(1));
                    return;
                }
                if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB) == ChatONContract.MessageTable.MsgContentType.AUDIO) {
                    m770b(file, str.substring(1));
                    return;
                } else if (TextUtils.isEmpty(this.f827x) || this.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                    this.f785ac.m2044a(file, str, ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB), this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), true, this.f760aD);
                    return;
                } else {
                    this.f785ac.m2044a(file, str, ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB), this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), false, this.f760aD);
                    return;
                }
            }
            AMSLibs aMSLibs = new AMSLibs();
            aMSLibs.VipAMS_Init();
            AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
            AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
            ams_coding_file_infoArr[0].setM_eExportType(0);
            ams_coding_file_infoArr[0].setM_strFileName(this.f759aC.substring(6));
            if (aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr) != 0) {
                m763a(file);
            } else if (TextUtils.isEmpty(this.f827x) || this.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                this.f785ac.m2044a(file, str, ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB), this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), true, this.f760aD);
            } else {
                this.f785ac.m2044a(file, str, ChatONContract.MessageTable.MsgContentType.m2195a(this.f758aB), this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[0]), false, this.f760aD);
            }
        }
    }

    /* renamed from: c */
    public void m772c(Display display) {
        if (display.getHeight() > 800) {
            this.f772aP.setLayoutParams(this.f807ay.equals("skin_myskin.png_") ? new FrameLayout.LayoutParams(800, 1132) : new FrameLayout.LayoutParams(800, 1280));
            if (this.f807ay.equals("skin_bg_02")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern2);
                return;
            }
            if (this.f807ay.equals("pad_chat_bg_01")) {
                this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01);
                return;
            }
            if (this.f807ay.equals("skin_bg_04")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern4);
                return;
            }
            if (this.f807ay.equals("skin_bg_05")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern5);
                return;
            }
            if (this.f807ay.equals("skin_bg_06")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern6);
                return;
            }
            if (this.f807ay.equals("skin_bg_03")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern3);
                return;
            }
            if (this.f807ay.equals("skin_bg_07")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern7);
                return;
            }
            if (this.f807ay.equals("skin_bg_08")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern8);
                return;
            }
            if (this.f807ay.equals("skin_bg_09")) {
                this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern9);
                return;
            }
            if (!this.f807ay.equals("skin_myskin.png_")) {
                this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01);
                return;
            }
            try {
                this.f772aP.setImageBitmap(Bitmap.createScaledBitmap(ActivitySkinChange.m3157a(getActivity(), Uri.parse(this.f744N + "/" + this.f807ay), 800), 800, 1132, true));
                return;
            } catch (IOException e) {
                this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01);
                e.printStackTrace();
                return;
            }
        }
        this.f772aP.setLayoutParams(this.f807ay.equals("skin_myskin.png_") ? new FrameLayout.LayoutParams(480, 600) : new FrameLayout.LayoutParams(480, 768));
        if (this.f807ay.equals("skin_bg_02")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern2);
            return;
        }
        if (this.f807ay.equals("pad_chat_bg_01")) {
            this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01);
            return;
        }
        if (this.f807ay.equals("skin_bg_04")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern4);
            return;
        }
        if (this.f807ay.equals("skin_bg_05")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern5);
            return;
        }
        if (this.f807ay.equals("skin_bg_06")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern6);
            return;
        }
        if (this.f807ay.equals("skin_bg_03")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern3);
            return;
        }
        if (this.f807ay.equals("skin_bg_07")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern7);
            return;
        }
        if (this.f807ay.equals("skin_bg_08")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern8);
            return;
        }
        if (this.f807ay.equals("skin_bg_09")) {
            this.f772aP.setBackgroundResource(C0062R.drawable.chat_background_pattern9);
            return;
        }
        if (!this.f807ay.equals("skin_myskin.png_")) {
            this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01);
            return;
        }
        try {
            this.f772aP.setImageBitmap(Bitmap.createScaledBitmap(ActivitySkinChange.m3157a(getActivity(), Uri.parse(this.f744N + "/" + this.f807ay), 800), 480, 600, true));
        } catch (IOException e2) {
            this.f772aP.setImageResource(C0062R.drawable.pad_chat_bg_01);
            e2.printStackTrace();
        }
    }

    @Override // com.sec.chaton.chat.ChatActivity.OnBackKeyListener
    /* renamed from: d */
    public boolean mo526d() {
        if (this.f755Y.getChoiceMode() != 2) {
            if (!this.f819p) {
                return true;
            }
            this.f776aT.setVisibility(8);
            this.f819p = false;
            return false;
        }
        this.f755Y.setChoiceMode(0);
        this.f755Y.setTranscriptMode(2);
        setHasOptionsMenu(true);
        this.f755Y.clearChoices();
        this.f814j.setVisibility(8);
        this.f815k.setVisibility(8);
        this.f770aN.setVisibility(8);
        this.f816l.setVisibility(0);
        this.f817m.setVisibility(0);
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f743M = new NotifyingAsyncQueryHandler(getActivity().getContentResolver(), this.f741K);
        this.f777aU = getArguments();
        if (this.f777aU != null && this.f777aU.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("InBoxNO : ");
            if (this.f777aU.containsKey("inboxNO")) {
                this.f822s = this.f777aU.getString("inboxNO");
                sb.append(this.f822s);
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("ChatType : ");
            if (this.f777aU.containsKey("chatType")) {
                this.f826w = ChatONContract.InBoxTable.ChatType.m2188a(this.f777aU.getInt("chatType"));
                sb.append(this.f826w.toString());
            } else {
                sb.append("Not Contained");
            }
            sb.append("\t");
            sb.append("Participants : ");
            if (this.f777aU.containsKey("receivers")) {
                synchronized (this.f742L) {
                    for (String str : this.f777aU.getStringArray("receivers")) {
                        this.f786ad.add(str);
                        this.f787ae.put(str, new BuddyEntry(str));
                        sb.append(str + " ");
                    }
                }
            } else {
                sb.append("Not Contained");
            }
            ChatONLogWriter.m3511e(sb.toString(), getClass().getSimpleName());
            sb.append("KEY_GROUP_NAME : ");
            if (this.f777aU.containsKey("groupnmae")) {
                this.f829z = this.f777aU.getString("groupnmae");
                sb.append(this.f829z.toString());
                ChatONLogWriter.m3509d("mGroupName:" + this.f829z);
                this.f803au.setText(this.f829z);
                this.f790ah = this.f829z;
                this.f797ao = this.f829z;
            }
            if (this.f822s == null) {
                this.f743M.startQuery(8, null, ChatONContract.InBoxTable.f1717a, null, "inbox_chat_type=" + ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a(), null, null);
                synchronized (this.f742L) {
                    this.f822s = InBoxNoGenerator.m3595a(this.f826w, this.f786ad);
                }
            }
            if (this.f777aU.containsKey("fromPush")) {
                this.f810bb = this.f777aU.getInt("fromPush") == 1;
            } else {
                this.f810bb = false;
            }
            if (this.f777aU.containsKey(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE)) {
                this.f758aB = this.f777aU.getInt(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE);
                ChatONLogWriter.m3509d("ChatView content_type:" + this.f758aB);
                this.f761aE = true;
            }
            if (this.f777aU.containsKey("download_uri")) {
                this.f759aC = this.f777aU.getString("download_uri");
                ChatONLogWriter.m3509d("ChatView download_uri:" + this.f759aC);
            }
            if (this.f777aU.containsKey("sub_content")) {
                this.f760aD = this.f777aU.getString("sub_content");
                ChatONLogWriter.m3509d("ChatView sub_content:" + this.f760aD);
            }
            if (this.f777aU.containsKey(f729h)) {
                this.f762aF = this.f777aU.getInt(f729h);
                ChatONLogWriter.m3509d("misShowinput:" + this.f762aF);
            }
        }
        this.f801as.requestFocus();
        registerForContextMenu(this.f755Y);
        setHasOptionsMenu(true);
        this.f816l.setOnClickListener(this);
        if (this.f826w == ChatONContract.InBoxTable.ChatType.ONETOONE) {
            this.f771aO.setImageResource(C0062R.drawable.contacts_default_img);
            ProfileImageLoader.m3610a(getActivity()).m3623a(this.f771aO, this.f822s);
        } else if (this.f826w == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
            this.f771aO.setImageResource(C0062R.drawable.contacts_default_image_group);
        } else if (this.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
            this.f771aO.setImageResource(C0062R.drawable.contacts_default_image_cb);
            this.f763aG.setVisibility(4);
            this.f764aH.setVisibility(4);
        }
        this.f771aO.setOnClickListener(this);
        this.f756Z = new ChatListAdapter(getActivity(), this.f755Y, C0062R.layout.item_balloon_skin0, null, this.f826w, null, this.f747Q);
        this.f755Y.setAdapter((ListAdapter) this.f756Z);
        this.f756Z.m791a(this);
        this.f784ab = (ProgressDialog) new SMSProgressBar(getActivity()).onCreate(C0062R.string.media_file_download);
        this.f734D = (ProgressDialog) new SMSProgressBar(getActivity()).onCreate(C0062R.string.setting_webview_please_wait);
        this.f779aW = false;
        this.f765aI.setVisibility(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:261:0x09a1  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r13, int r14, android.content.Intent r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.lLayoutProfile /* 2131427536 */:
                if (this.f790ah != null) {
                    Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                    intent.putExtra("ACTIVITY_PURPOSE", 6);
                    ChatONLogWriter.m3509d("namelist:" + this.f790ah);
                    String strSubstring = this.f826w != ChatONContract.InBoxTable.ChatType.ONETOONE ? this.f790ah.substring(0, this.f790ah.length() - (Integer.toString(this.f786ad.size()).length() + 3)) : this.f790ah;
                    intent.putExtra(f728g, this.f823t);
                    intent.putExtra(f725d, strSubstring);
                    intent.putExtra("inboxNO", this.f822s);
                    intent.putExtra("chatType", this.f826w.m2189a());
                    synchronized (this.f742L) {
                        intent.putExtra(f724c, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]));
                    }
                    synchronized (this.f742L) {
                        intent.putExtra(f724c, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]));
                    }
                    startActivityForResult(intent, 17);
                    return;
                }
                return;
            case C0062R.id.Chaticon /* 2131427582 */:
                if (this.f826w == ChatONContract.InBoxTable.ChatType.ONETOONE) {
                    Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyProfileActivity.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", this.f822s);
                    intent2.putExtra("PROFILE_BUDDY_NAME", this.f795am);
                    getActivity().startActivity(intent2);
                    return;
                }
                return;
            case C0062R.id.btnAdd /* 2131427596 */:
                int iM2753a = NetState.m2753a(GlobalApplication.m2387e());
                if (-3 == iM2753a || -2 == iM2753a) {
                    Toast.makeText(getActivity(), C0062R.string.toast_network_unable, 0).show();
                    return;
                } else {
                    m729g();
                    return;
                }
            case C0062R.id.btnChatImage /* 2131427597 */:
                if (this.f819p) {
                    this.f776aT.setVisibility(8);
                    this.f819p = false;
                    return;
                } else {
                    this.f776aT.setVisibility(0);
                    this.f819p = true;
                    return;
                }
            case C0062R.id.btnChatSend /* 2131427599 */:
                if (this.f801as.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
                    this.f801as.setText("");
                    return;
                }
                int iM2753a2 = NetState.m2753a(GlobalApplication.m2387e());
                if (-3 == iM2753a2 || -2 == iM2753a2) {
                    Toast.makeText(getActivity(), C0062R.string.toast_network_unable, 0).show();
                    return;
                }
                synchronized (this.f742L) {
                    if (TextUtils.isEmpty(this.f827x) || this.f827x.equals("null")) {
                        if (this.f826w != ChatONContract.InBoxTable.ChatType.BROADCAST && !this.f734D.isShowing()) {
                            this.f734D.show();
                        }
                        MessageControl messageControl = this.f785ac;
                        String str = this.f822s;
                        ChatONContract.MessageTable.MsgContentType msgContentType = this.f731A;
                        messageControl.m2045a(str, ChatONContract.MessageTable.MsgContentType.TEXT, this.f826w, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), this.f801as.getText().toString());
                    } else {
                        this.f785ac.m2042a(ChatONContract.MessageTable.MsgContentType.TEXT, this.f826w, this.f827x, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]), this.f801as.getText().toString());
                    }
                }
                this.f819p = false;
                this.f776aT.setVisibility(8);
                this.f801as.setText("");
                return;
            case C0062R.id.btnDelete /* 2131427602 */:
                SparseBooleanArray checkedItemPositions = this.f755Y.getCheckedItemPositions();
                Boolean bool = false;
                if (checkedItemPositions.size() != 0) {
                    int i = 0;
                    while (true) {
                        if (i < this.f755Y.getAdapter().getCount()) {
                            if (checkedItemPositions.get(i)) {
                                bool = true;
                            } else {
                                i++;
                            }
                        }
                    }
                } else {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Toast.makeText(getActivity(), C0062R.string.toast_no_delete_data, 0).show();
                    return;
                }
                String str2 = "";
                if (checkedItemPositions.size() == 0) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    String str3 = str2;
                    if (i2 >= this.f755Y.getAdapter().getCount()) {
                        this.f743M.startDelete(3, null, ChatONContract.MessageTable.f1726a, "_id IN (" + (str3.length() != 0 ? str3.substring(0, str3.length() - 1) : str3) + ")", null);
                        this.f755Y.clearChoices();
                        return;
                    } else {
                        if (checkedItemPositions.get(i2)) {
                            Cursor cursor = (Cursor) this.f755Y.getAdapter().getItem(i2);
                            str2 = str3 + cursor.getString(cursor.getColumnIndex("_id")) + ",";
                        } else {
                            str2 = str3;
                        }
                        i2++;
                    }
                }
            case C0062R.id.btnDelCancel /* 2131427603 */:
                this.f755Y.setChoiceMode(0);
                this.f755Y.setTranscriptMode(2);
                setHasOptionsMenu(true);
                this.f755Y.clearChoices();
                this.f814j.setVisibility(8);
                this.f815k.setVisibility(8);
                this.f770aN.setVisibility(8);
                this.f816l.setVisibility(0);
                this.f817m.setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        ChatONLogWriter.m3509d("w:" + defaultDisplay.getWidth());
        ChatONLogWriter.m3509d("h:" + defaultDisplay.getHeight());
        m755a(defaultDisplay);
        if (configuration.orientation == 2) {
            m769b(defaultDisplay);
        } else if (configuration.orientation == 1) {
            m772c(defaultDisplay);
        }
        new Timer(true).schedule(new C0164z(this, new Handler()), 100L);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        ChatONLogWriter.m3509d("onContextItemSelected!!!!");
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f786ad = new ArrayList();
        this.f787ae = new HashMap();
        this.f778aV = new HttpMessageControl(new Handler());
        this.f768aL = (InputMethodManager) getActivity().getSystemService("input_method");
        this.f811bc = new TrunkMessageControl(GlobalApplication.m2387e(), this.f812bd);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0156  */
    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreateContextMenu(android.view.ContextMenu r11, android.view.View r12, android.view.ContextMenu.ContextMenuInfo r13) {
        /*
            Method dump skipped, instructions count: 772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.ChatFragment.onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.add(0, 1, 1, C0062R.string.chat_view_menu_invite).setIcon(C0062R.drawable.invite_buddy);
        menu.add(0, 4, 2, C0062R.string.chat_view_menu_close).setIcon(C0062R.drawable.close_chat);
        menu.add(0, 5, 3, C0062R.string.chat_view_menu_delete_message).setIcon(C0062R.drawable.delete);
        if (ChatONPref.m3519a().contains("UpdateIsCritical")) {
            menu.add(0, 7, 4, getResources().getString(C0062R.string.menu_inbox_setting)).setIcon(C0062R.drawable.settings_new);
        } else {
            menu.add(0, 7, 4, C0062R.string.menu_inbox_setting).setIcon(C0062R.drawable.ic_menu_settings);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C0062R.layout.chat_fragment, viewGroup, false);
        this.f807ay = ChatONPref.m3519a().getString("setting_change_skin", "");
        this.f808az = ChatONPref.m3519a().getString("Default Font Size", "");
        this.f757aA = ChatONPref.m3519a().getString("setting_change_bubble", "");
        this.f752V = (LinearLayout) viewInflate.findViewById(C0062R.id.lLayoutChat);
        this.f816l = (LinearLayout) viewInflate.findViewById(C0062R.id.lLayoutProfile);
        this.f814j = (LinearLayout) viewInflate.findViewById(C0062R.id.ldeletetop);
        this.f815k = (LinearLayout) viewInflate.findViewById(C0062R.id.ldeletebot);
        this.f817m = (LinearLayout) viewInflate.findViewById(C0062R.id.lLayoutMsgEdit);
        this.f753W = (LinearLayout) viewInflate.findViewById(C0062R.id.linearemoticon);
        this.f754X = (LinearLayout) viewInflate.findViewById(C0062R.id.linearemoticontop);
        this.f776aT = (ScrollView) viewInflate.findViewById(C0062R.id.scrollemoticon);
        this.f755Y = (ListView) viewInflate.findViewById(C0062R.id.chat_listview);
        this.f763aG = (ImageButton) viewInflate.findViewById(C0062R.id.imageTrunk);
        this.f764aH = (ImageView) viewInflate.findViewById(C0062R.id.imageTrunkBg);
        this.f763aG.setOnClickListener(new ViewOnClickListenerC0148j(this));
        this.f765aI = (TextView) viewInflate.findViewById(C0062R.id.unReadTrunkCount);
        this.f801as = (EditText) viewInflate.findViewById(C0062R.id.editChatMsg);
        this.f801as.addTextChangedListener(new C0147i(this));
        this.f801as.setOnEditorActionListener(new C0146h(this));
        this.f801as.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC0145g(this));
        this.f766aJ = (Button) viewInflate.findViewById(C0062R.id.btnChatSend);
        this.f766aJ.setOnClickListener(this);
        this.f746P = (ImageButton) viewInflate.findViewById(C0062R.id.btnChatImage);
        this.f746P.setOnClickListener(this);
        this.f745O = (ImageButton) viewInflate.findViewById(C0062R.id.btnAdd);
        this.f745O.setOnClickListener(this);
        this.f748R = (Button) viewInflate.findViewById(C0062R.id.btnDelCancel);
        this.f748R.setOnClickListener(this);
        this.f747Q = (Button) viewInflate.findViewById(C0062R.id.btnDelete);
        this.f747Q.setOnClickListener(this);
        this.f749S = (Button) viewInflate.findViewById(C0062R.id.btnRangeAll);
        this.f749S.setOnClickListener(this.f735E);
        this.f750T = (Button) viewInflate.findViewById(C0062R.id.btnRangeRcv);
        this.f750T.setOnClickListener(this.f735E);
        this.f751U = (Button) viewInflate.findViewById(C0062R.id.btnRangeSnt);
        this.f751U.setOnClickListener(this.f735E);
        this.f803au = (TextView) viewInflate.findViewById(C0062R.id.textNames);
        this.f804av = (TextView) viewInflate.findViewById(C0062R.id.textStatus);
        this.f767aK = (CheckBox) viewInflate.findViewById(C0062R.id.chkEditTrans);
        this.f769aM = (TextView) viewInflate.findViewById(C0062R.id.unReadCount);
        this.f771aO = (ProfileImageView) viewInflate.findViewById(C0062R.id.Chaticon);
        this.f772aP = (ImageView) viewInflate.findViewById(C0062R.id.imagebackgroup);
        this.f773aQ = (ImageView) viewInflate.findViewById(C0062R.id.imageline);
        this.f770aN = (TextView) viewInflate.findViewById(C0062R.id.title_menu);
        this.f770aN.setVisibility(8);
        this.f769aM.setVisibility(8);
        this.f767aK.setVisibility(8);
        this.f805aw = new EmoticonUsageManager(GlobalApplication.m2387e(), 1);
        this.f774aR = (GridView) viewInflate.findViewById(C0062R.id.emoticonGrid1);
        if (this.f805aw.m2517b()) {
            this.f774aR.setAdapter((ListAdapter) new EmoticonAdapter(getActivity(), 0, this.f805aw, 1));
        }
        this.f774aR.setOnItemClickListener(this);
        this.f775aS = (GridView) viewInflate.findViewById(C0062R.id.emoticonGrid0);
        this.f806ax = new EmoticonUsageManager(GlobalApplication.m2387e(), 2);
        this.f775aS.setAdapter((ListAdapter) new EmoticonAdapter(getActivity(), 0, this.f806ax, 2));
        this.f775aS.setOnItemClickListener(this);
        this.f775aS.setOnScrollListener(new C0144f(this));
        if (this.f774aR.getCount() != 0) {
            this.f754X.setVisibility(0);
            this.f773aQ.setVisibility(0);
        } else {
            this.f754X.setVisibility(8);
            this.f773aQ.setVisibility(8);
        }
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        ChatONLogWriter.m3509d("w:" + defaultDisplay.getWidth());
        ChatONLogWriter.m3509d("h:" + defaultDisplay.getHeight());
        m755a(defaultDisplay);
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            m769b(defaultDisplay);
        } else if (configuration.orientation == 1) {
            m772c(defaultDisplay);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f768aL.hideSoftInputFromWindow(this.f801as.getWindowToken(), 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        RichString richString = null;
        if (adapterView.getId() == C0062R.id.emoticonGrid0) {
            ChatONLogWriter.m3509d("editText.getText().length()+usageManagerbottom.getitem().get((int) id).mKey.length():" + (((EmoticonUsage.EmoticonUsageItem) this.f806ax.m2515a().get((int) j)).f2126a.length() + this.f801as.getText().length()));
            if (((EmoticonUsage.EmoticonUsageItem) this.f806ax.m2515a().get((int) j)).f2126a.length() + this.f801as.getText().length() >= 2000) {
                Toast.makeText(getActivity(), C0062R.string.toast_text_max_Length, 0).show();
                return;
            } else {
                RichString richString2 = new RichString(((EmoticonUsage.EmoticonUsageItem) this.f806ax.m2515a().get((int) j)).f2126a, (int) (this.f801as.getLineHeight() * 1.2f));
                this.f805aw.m2516a(((EmoticonUsage.EmoticonUsageItem) this.f806ax.m2515a().get((int) j)).f2126a, ((EmoticonUsage.EmoticonUsageItem) this.f806ax.m2515a().get((int) j)).f2127b, (int) j);
                richString = richString2;
            }
        } else if (adapterView.getId() == C0062R.id.emoticonGrid1) {
            ChatONLogWriter.m3509d("editText.getText().length()+usageManager.getitem().get((int) id).mKey.length():" + this.f801as.getText().length() + ((EmoticonUsage.EmoticonUsageItem) this.f805aw.m2515a().get((int) j)).f2126a.length());
            if (((EmoticonUsage.EmoticonUsageItem) this.f805aw.m2515a().get((int) j)).f2126a.length() + this.f801as.getText().length() >= 2000) {
                Toast.makeText(getActivity(), C0062R.string.toast_text_max_Length, 0).show();
                return;
            }
            richString = new RichString(((EmoticonUsage.EmoticonUsageItem) this.f805aw.m2515a().get((int) j)).f2126a, (int) (this.f801as.getLineHeight() * 1.2f));
        }
        if (richString != null) {
            richString.m2532a(this.f801as);
        }
        Collections.sort(this.f805aw.m2519d().m2511a());
        this.f774aR.setAdapter((ListAdapter) new EmoticonAdapter(getActivity(), 0, this.f805aw, 1));
        this.f754X.setVisibility(0);
        this.f773aQ.setVisibility(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 5);
                intent.putExtra("chatType", this.f826w.m2189a());
                synchronized (this.f742L) {
                    intent.putExtra(f724c, (String[]) this.f786ad.toArray(new String[this.f786ad.size()]));
                }
                startActivityForResult(intent, 4);
                this.f818o = true;
                return true;
            case 2:
            case 3:
            case 6:
            default:
                return true;
            case 4:
                f730n = false;
                m766a(this.f822s, this.f826w, this.f827x, this.f794al);
                return true;
            case 5:
                if (this.f755Y.getCount() != 0) {
                    this.f768aL.hideSoftInputFromWindow(this.f801as.getWindowToken(), 0);
                    this.f755Y.setChoiceMode(2);
                    this.f755Y.setTranscriptMode(0);
                    setHasOptionsMenu(false);
                    this.f814j.setVisibility(0);
                    this.f815k.setVisibility(0);
                    this.f770aN.setVisibility(0);
                    this.f816l.setVisibility(8);
                    this.f817m.setVisibility(8);
                } else {
                    Toast.makeText(getActivity(), C0062R.string.toast_no_delete_data, 0).show();
                }
                return true;
            case 7:
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                return true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() throws IOException {
        super.onPause();
        this.f768aL.hideSoftInputFromWindow(this.f801as.getWindowToken(), 0);
        m724e();
        getActivity().getContentResolver().unregisterContentObserver(this.f738H);
        getActivity().getContentResolver().unregisterContentObserver(this.f737G);
        getActivity().getContentResolver().unregisterContentObserver(this.f736F);
        this.f785ac.m2056c(SystemClock.elapsedRealtime() + 480000);
        GlobalApplication.f1896c = null;
        PushReceiver.m3044a((ChatFragment) null);
        this.f785ac.f1365b = false;
        this.f805aw.m2522g();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f772aP.setImageBitmap(null);
        this.f807ay = ChatONPref.m3519a().getString("setting_change_skin", "");
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            m769b(defaultDisplay);
        } else if (configuration.orientation == 1) {
            m772c(defaultDisplay);
        }
        if (!this.f808az.equals(ChatONPref.m3519a().getString("Default Font Size", "")) || !this.f757aA.equals(ChatONPref.m3519a().getString("setting_change_bubble", ""))) {
            this.f808az = ChatONPref.m3519a().getString("Default Font Size", "");
            this.f757aA = ChatONPref.m3519a().getString("setting_change_bubble", "");
            this.f756Z = new ChatListAdapter(getActivity(), this.f755Y, C0062R.layout.item_balloon_skin0, null, this.f826w, null, this.f747Q);
            this.f755Y.setAdapter((ListAdapter) this.f756Z);
            this.f756Z.m791a(this);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f743M.startUpdate(4, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no='" + this.f822s + "'", null);
        this.f743M.startQuery(1, null, ChatONContract.InBoxTable.m2184a(), null, "inbox_no=?", new String[]{this.f822s}, null);
        this.f743M.startQuery(0, null, ChatONContract.MessageTable.m2190a(), null, "message_inbox_no=?", new String[]{this.f822s}, "message_is_failed , message_time , _id");
        PushReceiver.m3044a(this);
        GlobalApplication.f1896c = this.f822s;
        this.f785ac = MessageControl.m2011a(this.f740J, this.f822s);
        this.f785ac.m2035a(this);
        getActivity().getContentResolver().registerContentObserver(ChatONContract.MessageTable.f1726a, true, this.f738H);
        this.f743M.startQuery(9, null, DatabaseConstant.TrunkTable.CONTENT_URI, null, "session_id=?", new String[]{this.f827x}, null);
        getActivity().getContentResolver().registerContentObserver(DatabaseConstant.TrunkTable.CONTENT_URI, true, this.f736F);
        if (this.f785ac.f1365b) {
            this.f785ac.m2062i();
        } else {
            this.f785ac.f1365b = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }
}
