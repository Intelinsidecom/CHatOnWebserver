package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.C0837a;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.p015d.p016a.C0577br;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public class BuddyProfileFragment extends Fragment implements InterfaceC0299bk {

    /* renamed from: A */
    private TextView f1092A;

    /* renamed from: B */
    private CheckBox f1093B;

    /* renamed from: C */
    private TextView f1094C;

    /* renamed from: D */
    private TextView f1095D;

    /* renamed from: E */
    private Button f1096E;

    /* renamed from: F */
    private TextView f1097F;

    /* renamed from: G */
    private TextView f1098G;

    /* renamed from: H */
    private TextView f1099H;

    /* renamed from: I */
    private LinearLayout f1100I;

    /* renamed from: J */
    private LinearLayout f1101J;

    /* renamed from: K */
    private RelativeLayout f1102K;

    /* renamed from: L */
    private ImageView f1103L;

    /* renamed from: M */
    private ImageButton f1104M;

    /* renamed from: N */
    private ImageButton f1105N;

    /* renamed from: O */
    private ImageButton f1106O;

    /* renamed from: P */
    private Button f1107P;

    /* renamed from: Q */
    private Button f1108Q;

    /* renamed from: R */
    private Button f1109R;

    /* renamed from: S */
    private Button f1110S;

    /* renamed from: T */
    private TextView f1111T;

    /* renamed from: V */
    private C0837a f1113V;

    /* renamed from: W */
    private ListView f1114W;

    /* renamed from: X */
    private LinearLayout f1115X;

    /* renamed from: Y */
    private LinearLayout f1116Y;

    /* renamed from: aa */
    private C0638j f1118aa;

    /* renamed from: ab */
    private boolean f1119ab;

    /* renamed from: ac */
    private int f1120ac;

    /* renamed from: ae */
    private Button f1121ae;

    /* renamed from: af */
    private ImageView f1122af;

    /* renamed from: ag */
    private Button f1123ag;

    /* renamed from: ah */
    private EditText f1124ah;

    /* renamed from: ai */
    private LinearLayout f1125ai;

    /* renamed from: aj */
    private LinearLayout f1126aj;

    /* renamed from: ak */
    private ProgressBar f1127ak;

    /* renamed from: al */
    private Button f1128al;

    /* renamed from: am */
    private String f1129am;

    /* renamed from: an */
    private String f1130an;

    /* renamed from: ao */
    private String f1131ao;

    /* renamed from: ap */
    private boolean f1132ap;

    /* renamed from: aq */
    private LinearLayout f1133aq;

    /* renamed from: ar */
    private LinearLayout f1134ar;

    /* renamed from: as */
    private LinearLayout f1135as;

    /* renamed from: av */
    private View f1138av;

    /* renamed from: c */
    LinearLayout f1141c;

    /* renamed from: d */
    int f1142d;

    /* renamed from: e */
    int f1143e;

    /* renamed from: f */
    int f1144f;

    /* renamed from: g */
    int f1145g;

    /* renamed from: q */
    private View f1155q;

    /* renamed from: r */
    private C0666j f1156r;

    /* renamed from: s */
    private Context f1157s;

    /* renamed from: t */
    private C0257c f1158t;

    /* renamed from: u */
    private String f1159u;

    /* renamed from: v */
    private String f1160v;

    /* renamed from: w */
    private boolean f1161w;

    /* renamed from: x */
    private ImageView f1162x;

    /* renamed from: y */
    private ImageView f1163y;

    /* renamed from: z */
    private TextView f1164z;

    /* renamed from: a */
    public static final String f1089a = BuddyProfileFragment.class.getSimpleName();

    /* renamed from: b */
    static boolean f1091b = false;

    /* renamed from: ad */
    private static String f1090ad = "";

    /* renamed from: o */
    private boolean f1153o = false;

    /* renamed from: p */
    private int f1154p = 0;

    /* renamed from: U */
    private ProgressDialog f1112U = null;

    /* renamed from: Z */
    private ArrayList f1117Z = new ArrayList();

    /* renamed from: at */
    private boolean f1136at = false;

    /* renamed from: au */
    private boolean f1137au = false;

    /* renamed from: aw */
    private TextWatcher f1139aw = new C0332cq(this);

    /* renamed from: h */
    View.OnClickListener f1146h = new ViewOnClickListenerC0334cs(this);

    /* renamed from: i */
    Handler f1147i = new HandlerC0338cw(this);

    /* renamed from: j */
    Handler f1148j = new HandlerC0343da(this);

    /* renamed from: k */
    InterfaceC0677d f1149k = new C0344db(this);

    /* renamed from: l */
    InterfaceC0667k f1150l = new C0345dc(this);

    /* renamed from: ax */
    private Handler f1140ax = new HandlerC0346dd(this);

    /* renamed from: m */
    AbsListView.OnScrollListener f1151m = new C0348df(this);

    /* renamed from: n */
    ContentObserver f1152n = new C0333cr(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        Bundle extras = getActivity().getIntent().getExtras();
        this.f1157s = GlobalApplication.m3260b();
        this.f1156r = new C0666j(getActivity().getContentResolver(), this.f1150l);
        if (extras != null) {
            bundle = extras;
        } else if (bundle == null && (bundle = getArguments()) == null) {
            Log.e("BuddyProfileFragment", "onCreate Finish 1");
            getActivity().finish();
            return;
        }
        this.f1159u = bundle.getString("PROFILE_BUDDY_NO");
        this.f1160v = bundle.getString("PROFILE_BUDDY_NAME");
        if (this.f1159u == null) {
            bundle = getArguments();
            this.f1159u = bundle.getString("PROFILE_BUDDY_NO");
            this.f1160v = bundle.getString("PROFILE_BUDDY_NAME");
        }
        if (bundle.containsKey("BUDDY_PROFILE_UI_TYPE")) {
            this.f1154p = bundle.getInt("BUDDY_PROFILE_UI_TYPE");
            this.f1153o = this.f1154p == 1;
            this.f1157s.getContentResolver().registerContentObserver(C0688c.f2606a, true, this.f1152n);
        } else {
            this.f1154p = 0;
            this.f1153o = false;
        }
        this.f1137au = bundle.getBoolean("PROFILE_BUDDY_SUGGESTION");
        C1786r.m6061b("*********** BUDDY NO" + this.f1159u, "BUDDY PROFILE");
        C1786r.m6061b("*********** BUDDY NAME" + this.f1160v, "BUDDY PROFILE");
        C1786r.m6061b("*********** BUDDY SUGGESTION" + this.f1137au, "BUDDY SUGGESTION");
        if (this.f1159u == null) {
            Log.e("BuddyProfileFragment", "onCreate Finish 2");
            getActivity().finish();
        } else {
            if (this.f1160v == null) {
                this.f1160v = "";
            }
            m2147e();
            this.f1156r.startQuery(3, null, C0688c.m3126d(), null, "buddy_no = ? ", new String[]{this.f1159u}, null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.buddy_profile_list_layout, viewGroup, false);
        this.f1116Y = (LinearLayout) viewInflate.findViewById(R.id.buddy_profile_common_layout);
        this.f1114W = (ListView) viewInflate.findViewById(R.id.profile_memo_list);
        this.f1115X = (LinearLayout) viewInflate.findViewById(R.id.listlayout);
        this.f1155q = layoutInflater.inflate(R.layout.buddy_profile_list_header_layout, (ViewGroup) null);
        this.f1135as = (LinearLayout) this.f1155q.findViewById(R.id.profile_header_layout);
        if (getResources().getConfiguration().orientation == 2) {
            this.f1135as.setOrientation(0);
        } else if (getResources().getConfiguration().orientation == 1) {
            this.f1135as.setOrientation(1);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C1786r.m6063c("onActivityCreated()", f1089a);
        super.onActivityCreated(bundle);
        m2147e();
        if (this.f1159u != null) {
            BuddyFragment.m1954a(this, this.f1159u);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1141c != null) {
            new LinearLayout.LayoutParams(this.f1141c.getLayoutParams()).setMargins(this.f1142d, this.f1143e, this.f1144f, this.f1145g);
        }
        if (configuration.orientation == 2) {
            this.f1135as.setOrientation(0);
        } else if (configuration.orientation == 1) {
            this.f1135as.setOrientation(1);
        }
    }

    /* renamed from: e */
    private void m2147e() {
        f1090ad = C1789u.m6075a().getString("msisdn", "");
        this.f1118aa = new C0638j(this.f1147i);
        this.f1129am = "";
        this.f1130an = "";
        this.f1131ao = "";
        this.f1132ap = true;
        this.f1112U = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_userprofile_updating);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1786r.m6063c("[LIFE] onStart, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (this.f1104M != null) {
            this.f1104M.setEnabled(true);
            this.f1104M.setClickable(true);
        }
        m2150f();
    }

    /* renamed from: f */
    private void m2150f() {
        ImageButton imageButton = (ImageButton) this.f1155q.findViewById(R.id.profile_voice_call);
        ImageButton imageButton2 = (ImageButton) this.f1155q.findViewById(R.id.profile_video_call);
        if (AbstractC0521a.m2697a(this.f1157s)) {
            imageButton.setVisibility(0);
            imageButton2.setVisibility(0);
        } else {
            imageButton.setVisibility(8);
            imageButton2.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6063c("[LIFE] onResume, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (m2144d()) {
            this.f1159u = getActivity().getIntent().getExtras().getString("PROFILE_BUDDY_NO");
            this.f1160v = getActivity().getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
            if (this.f1159u == null) {
                Bundle arguments = getArguments();
                this.f1159u = arguments.getString("PROFILE_BUDDY_NO");
                this.f1160v = arguments.getString("PROFILE_BUDDY_NAME");
            }
            C1786r.m6061b("*********** BUDDY NO" + this.f1159u, "BUDDY PROFILE");
            C1786r.m6061b("*********** BUDDY NAME" + this.f1160v, "BUDDY PROFILE");
            if (this.f1159u == null) {
                Log.e("BuddyProfileFragment", "onResume Finish 3");
                getActivity().finish();
            }
            if (this.f1160v == null) {
                this.f1160v = "";
            }
            if (this.f1112U != null && this.f1112U.isShowing()) {
                this.f1112U.dismiss();
            }
            this.f1156r.startQuery(3, null, C0688c.m3126d(), null, "buddy_no = ? ", new String[]{this.f1159u}, null);
            m2131a(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6063c("[LIFE] onPause, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f1159u != null) {
            BuddyFragment.m1974b(this, this.f1159u);
        }
        if (this.f1152n != null) {
            this.f1157s.getContentResolver().unregisterContentObserver(this.f1152n);
        }
        C1786r.m6063c("[LIFE] onDestroy, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (this.f1112U != null && this.f1112U.isShowing()) {
            this.f1112U.dismiss();
        }
    }

    /* renamed from: d */
    public static boolean m2144d() {
        return f1091b;
    }

    /* renamed from: a */
    public static void m2131a(boolean z) {
        f1091b = z;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("PROFILE_BUDDY_NO", this.f1159u);
        bundle.putString("PROFILE_BUDDY_NAME", this.f1160v);
        bundle.putInt("BUDDY_PROFILE_UI_TYPE", this.f1154p);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2129a(int i) throws NumberFormatException {
        int i2;
        int i3;
        this.f1133aq = (LinearLayout) this.f1155q.findViewById(R.id.buddy_profile_llayout);
        if (getView() != null) {
            this.f1134ar = (LinearLayout) getView().findViewById(R.id.new_buddy_llayout);
            this.f1125ai = (LinearLayout) this.f1155q.findViewById(R.id.list_header);
            this.f1126aj = (LinearLayout) getView().findViewById(R.id.list_footer);
            this.f1127ak = (ProgressBar) getView().findViewById(R.id.footer_progress);
            this.f1128al = (Button) this.f1126aj.findViewById(R.id.footer_memo_content);
            if (i == 1) {
                this.f1133aq.setVisibility(0);
                this.f1134ar.setVisibility(8);
                this.f1126aj.setVisibility(0);
                if (GlobalApplication.m3265f()) {
                    this.f1162x = (ImageView) this.f1155q.findViewById(R.id.profile_image);
                    this.f1164z = (TextView) this.f1155q.findViewById(R.id.profile_name);
                    this.f1092A = (TextView) this.f1155q.findViewById(R.id.profile_status_message);
                    this.f1093B = (CheckBox) this.f1155q.findViewById(R.id.profile_is_favorite);
                    this.f1094C = (TextView) this.f1155q.findViewById(R.id.profile_phone_no);
                    this.f1095D = (TextView) this.f1155q.findViewById(R.id.profile_birthday);
                    this.f1096E = (Button) this.f1155q.findViewById(R.id.profile_calendar);
                    this.f1097F = (TextView) this.f1155q.findViewById(R.id.profile_relationship_status);
                    this.f1104M = (ImageButton) this.f1155q.findViewById(R.id.profile_chat);
                    this.f1105N = (ImageButton) this.f1155q.findViewById(R.id.profile_call);
                    this.f1106O = (ImageButton) this.f1155q.findViewById(R.id.profile_contact);
                    this.f1098G = (TextView) this.f1155q.findViewById(R.id.interaction_buddy_point);
                    this.f1099H = (TextView) this.f1155q.findViewById(R.id.interaction_me_point);
                    this.f1100I = (LinearLayout) this.f1155q.findViewById(R.id.interaction_left);
                    this.f1101J = (LinearLayout) this.f1155q.findViewById(R.id.interaction_right);
                    this.f1102K = (RelativeLayout) this.f1155q.findViewById(R.id.layout_birthday);
                    this.f1103L = (ImageView) this.f1155q.findViewById(R.id.layout_birthday_divider);
                    this.f1138av = (ImageButton) this.f1155q.findViewById(R.id.btn_edit_buddyname);
                }
                this.f1138av.setOnClickListener(this.f1146h);
                C1786r.m6067f("mBuddyInfo.getProfileStatus() : " + this.f1158t.m2346r(), f1089a);
                if (this.f1158t.m2346r() == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || this.f1158t.m2346r() == Buddy.BuddyImageStatus.NOT_CHANGE.getCode()) {
                    this.f1162x.setOnClickListener(this.f1146h);
                }
                this.f1104M.setOnClickListener(this.f1146h);
                this.f1105N.setOnClickListener(this.f1146h);
                this.f1106O.setOnClickListener(this.f1146h);
                if (this.f1158t.m2352x() == 1) {
                    this.f1106O.setEnabled(false);
                    this.f1106O.setVisibility(0);
                } else {
                    if (getActivity().getPackageManager().queryIntentActivities(new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI), 65536).size() >= 1) {
                        this.f1106O.setEnabled(true);
                    } else {
                        this.f1106O.setEnabled(false);
                    }
                    this.f1106O.setVisibility(0);
                }
                ImageButton imageButton = (ImageButton) this.f1155q.findViewById(R.id.profile_voice_call);
                ImageButton imageButton2 = (ImageButton) this.f1155q.findViewById(R.id.profile_video_call);
                imageButton.setOnClickListener(this.f1146h);
                imageButton2.setOnClickListener(this.f1146h);
                if (!C0577br.m2764a(this.f1158t.m2353y())) {
                    C1786r.m6066e("Disable voip " + C0577br.m2764a(this.f1158t.m2353y() + ", " + this.f1158t.m2352x()), null);
                    imageButton.setEnabled(false);
                    imageButton2.setEnabled(false);
                } else {
                    C1786r.m6066e("Enable voip " + C0577br.m2764a(this.f1158t.m2353y() + ", " + this.f1158t.m2352x()), null);
                    imageButton.setEnabled(true);
                    imageButton2.setEnabled(true);
                }
                this.f1164z.setText(this.f1158t.m2324b());
                if (this.f1158t.m2327c() == null || this.f1158t.m2327c().trim().length() == 0) {
                    this.f1092A.setText("");
                } else {
                    this.f1092A.setText(this.f1158t.m2327c());
                }
                this.f1093B.setChecked(this.f1161w);
                this.f1094C.setText("+" + this.f1158t.m2318a());
                if (this.f1158t.m2352x() == 1) {
                    C1786r.m6066e("Hide phone number because of privacy.", null);
                    if (GlobalApplication.m3265f()) {
                        this.f1094C.setText(" ");
                    }
                    this.f1105N.setEnabled(false);
                    this.f1105N.setVisibility(0);
                    this.f1106O.setEnabled(false);
                    this.f1106O.setVisibility(0);
                } else {
                    C1786r.m6066e("Show phone number", null);
                    int phoneType = ((TelephonyManager) getActivity().getSystemService("phone")).getPhoneType();
                    if (phoneType == 0) {
                        C1786r.m6066e(" Kmission phoneType=> PHONE_TYPE_NONE", null);
                    } else {
                        C1786r.m6066e(" Kmission phoneType=> PHONE_TYPE_CDMA/GSM", null);
                    }
                    if (phoneType != 0 && m2132a(this.f1157s, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")))) {
                        this.f1105N.setEnabled(true);
                        this.f1105N.setVisibility(0);
                    } else {
                        this.f1105N.setEnabled(false);
                        this.f1105N.setVisibility(0);
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("address", "000");
                    intent.setType("vnd.android-dir/mms-sms");
                }
                C1786r.m6061b("************** BIRTHDAY : " + this.f1158t.m2333f(), null);
                if (this.f1158t.m2333f().equals("0000-12-31") || this.f1158t.m2333f() == null || this.f1158t.m2333f().length() == 0) {
                    if (GlobalApplication.m3265f()) {
                        this.f1095D.setText(" ");
                        this.f1102K.setVisibility(8);
                        this.f1103L.setVisibility(8);
                    }
                } else {
                    String strM5579a = MyPageFragment.m5579a(this.f1158t.m2333f());
                    if ((this.f1158t.m2333f().length() == 5 || this.f1158t.m2333f().length() == 10) && strM5579a.length() > 0) {
                        this.f1095D.setText(strM5579a);
                        this.f1096E.setOnClickListener(this.f1146h);
                        this.f1102K.setVisibility(0);
                        this.f1103L.setVisibility(0);
                    } else {
                        this.f1102K.setVisibility(8);
                        this.f1103L.setVisibility(8);
                        this.f1096E.setOnClickListener(null);
                    }
                }
                if (GlobalApplication.m3265f()) {
                    this.f1097F.setText(this.f1157s.getString(R.string.buddy_profile_rank) + " " + (this.f1158t.m2344p() == 9999999 ? 0 : this.f1158t.m2344p()) + "  /  " + this.f1157s.getString(R.string.buddy_profile_point) + " " + this.f1158t.m2341m());
                }
                int iM2340l = this.f1158t.m2340l() > 0 ? this.f1158t.m2340l() : 0;
                int iM2339k = this.f1158t.m2339k() > 0 ? this.f1158t.m2339k() : 0;
                if (iM2340l == 0 && iM2339k == 0) {
                    i3 = 1;
                    i2 = 1;
                } else {
                    int i4 = iM2339k;
                    i2 = iM2340l;
                    i3 = i4;
                }
                if (GlobalApplication.m3265f()) {
                    this.f1098G.setText(this.f1157s.getString(R.string.buddy_profile_interaction_buddy) + " (" + this.f1158t.m2340l() + ")");
                    if (i2 > i3) {
                        i3 = 1;
                        i2 = 2;
                    } else if (i3 > i2) {
                        i3 = 2;
                        i2 = 1;
                    }
                    this.f1100I.setLayoutParams(new LinearLayout.LayoutParams(0, 25, i2));
                    this.f1101J.setLayoutParams(new LinearLayout.LayoutParams(0, 25, i3));
                } else {
                    this.f1098G.setText("" + this.f1158t.m2340l());
                }
                if (GlobalApplication.m3265f()) {
                    this.f1099H.setText(this.f1157s.getString(R.string.buddy_profile_interaction_me) + " (" + this.f1158t.m2339k() + ")");
                } else {
                    this.f1099H.setText("" + this.f1158t.m2339k());
                }
                this.f1093B.setOnClickListener(this.f1146h);
                C1746bb.m5945a(this.f1157s).m5960a(this.f1162x, this.f1158t.m2318a(), this.f1158t.m2346r());
                this.f1124ah = (EditText) this.f1155q.findViewById(R.id.txtName);
                this.f1121ae = (Button) this.f1155q.findViewById(R.id.memo_btn_write);
                this.f1163y = (ImageView) this.f1155q.findViewById(R.id.memo_below_line);
                this.f1123ag = (Button) this.f1155q.findViewById(R.id.buttonWriteText);
                this.f1121ae.setOnClickListener(this.f1146h);
                this.f1123ag.setOnClickListener(this.f1146h);
                this.f1122af = (ImageView) this.f1155q.findViewById(R.id.memo_write_below_line);
                this.f1124ah.addTextChangedListener(this.f1139aw);
                this.f1141c = (LinearLayout) this.f1155q.findViewById(R.id.interaction_point_bar_layout);
                this.f1142d = getResources().getDimensionPixelSize(R.dimen.buddy_profile_interaction_layout_margin_left);
                this.f1143e = getResources().getDimensionPixelSize(R.dimen.buddy_profile_interaction_layout_margin_top);
                this.f1144f = getResources().getDimensionPixelSize(R.dimen.buddy_profile_interaction_layout_margin_right);
                this.f1145g = getResources().getDimensionPixelSize(R.dimen.buddy_profile_interaction_layout_margin_bottom);
                new LinearLayout.LayoutParams(this.f1141c.getLayoutParams()).setMargins(this.f1142d, this.f1143e, this.f1144f, this.f1145g);
                if (getResources().getConfiguration().orientation == 2) {
                    this.f1135as.setOrientation(0);
                } else if (getResources().getConfiguration().orientation == 1) {
                    this.f1135as.setOrientation(1);
                }
                registerForContextMenu(this.f1114W);
                this.f1132ap = true;
                this.f1128al.setVisibility(8);
                this.f1127ak.setVisibility(0);
                this.f1118aa.m2897a(this.f1159u);
                this.f1113V = new C0837a(this.f1114W, this.f1157s, this.f1117Z, R.layout.memo_adapter_item);
                this.f1114W.addHeaderView(this.f1155q, null, false);
                this.f1114W.setAdapter((ListAdapter) this.f1113V);
                this.f1114W.setScrollbarFadingEnabled(true);
                this.f1114W.setOnScrollListener(this.f1151m);
                return;
            }
            if (GlobalApplication.m3265f()) {
                getActivity().getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), -2);
            }
            this.f1126aj.setVisibility(8);
            this.f1133aq.setVisibility(8);
            this.f1134ar.setVisibility(0);
            this.f1116Y.setGravity(16);
            this.f1162x = (ImageView) getView().findViewById(R.id.profile_nonbuddy_image);
            this.f1164z = (TextView) getView().findViewById(R.id.new_buddy_name);
            this.f1111T = (TextView) getView().findViewById(R.id.new_buddy_information);
            if (this.f1160v == null || this.f1160v.equals("")) {
                this.f1164z.setText(this.f1157s.getString(R.string.buddy_profile_no_name));
            } else {
                this.f1164z.setText(this.f1160v);
            }
            this.f1109R = (Button) getView().findViewById(R.id.new_buddy_add);
            this.f1107P = (Button) getView().findViewById(R.id.new_buddy_block);
            this.f1108Q = (Button) getView().findViewById(R.id.new_buddy_unblock);
            this.f1110S = (Button) getView().findViewById(R.id.new_buddy_cancel);
            this.f1109R.setOnClickListener(this.f1146h);
            this.f1107P.setOnClickListener(this.f1146h);
            this.f1108Q.setOnClickListener(this.f1146h);
            this.f1110S.setOnClickListener(this.f1146h);
            this.f1158t = new C0257c(this.f1159u, this.f1160v, null, null, null, null, false, 0, null, true);
            C1746bb.m5945a(this.f1157s).m5959a(this.f1162x, this.f1159u);
            new C0632d(this.f1140ax).m2844a();
            if (this.f1112U != null && this.f1112U.isShowing()) {
                this.f1112U.dismiss();
            }
            this.f1112U = ProgressDialogC1806j.m6141a(getActivity(), null, getActivity().getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long m2122a(String str) {
        long j;
        try {
            Cursor cursorQuery = getActivity().getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"_id", "display_name"}, null, null, null);
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                j = 0;
            } else {
                cursorQuery.moveToNext();
                cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
                return j;
            }
            return j;
        } catch (Exception e) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Uri m2135b(String str) {
        try {
            int iM2151g = m2151g();
            if (iM2151g <= 0) {
                return null;
            }
            return m2124a(iM2151g, this.f1158t.m2324b(), str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: g */
    private int m2151g() {
        String[] strArr = {"_id", "name"};
        String str = "selected=1";
        if (Build.VERSION.SDK_INT > 13) {
            str = "visible=1";
        }
        Cursor cursorM2123a = m2123a(strArr, str, "calendars");
        if (cursorM2123a != null && cursorM2123a.moveToFirst()) {
            int columnIndex = cursorM2123a.getColumnIndex("name");
            int columnIndex2 = cursorM2123a.getColumnIndex("_id");
            do {
                String string = cursorM2123a.getString(columnIndex);
                String string2 = cursorM2123a.getString(columnIndex2);
                if (string != null) {
                    return Integer.parseInt(string2);
                }
            } while (cursorM2123a.moveToNext());
        }
        return 0;
    }

    /* renamed from: a */
    private Cursor m2123a(String[] strArr, String str, String str2) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = getActivity().getContentResolver().query(Uri.parse("content://calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorQuery != null) {
            return cursorQuery;
        }
        try {
            return getActivity().getContentResolver().query(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorQuery;
        }
    }

    /* renamed from: a */
    private Uri m2124a(int i, String str, String str2) throws ClassNotFoundException {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (str2.contains("29")) {
            while (gregorianCalendar.isLeapYear(i2)) {
                i2++;
            }
        }
        String str3 = String.valueOf(i2) + "-" + str2;
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        calendar2.add(1, 40);
        String str4 = new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime());
        ContentValues contentValues = new ContentValues();
        if (m2128a(str, calendar.getTimeZone().getRawOffset() + calendar.getTimeInMillis(), calendar2.getTimeInMillis()).equals("Success")) {
            this.f1136at = true;
            return null;
        }
        this.f1136at = false;
        if (Build.VERSION.SDK_INT <= 13) {
            contentValues.put("calendar_id", Integer.valueOf(i));
            contentValues.put("title", String.format(this.f1157s.getString(R.string.buddy_profile_save_birthday_calendar_title), str));
            contentValues.put("dtstart", Long.valueOf(calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()));
            contentValues.put("eventTimezone", calendar.getTimeZone().getID());
            contentValues.put("duration", "P1D");
            contentValues.put("allDay", (Integer) 1);
            contentValues.put("visibility", (Integer) 0);
            contentValues.put("transparency", (Integer) 0);
            contentValues.put("hasAlarm", (Integer) 0);
            contentValues.put("hasExtendedProperties", (Integer) 1);
            contentValues.put("hasAttendeeData", (Integer) 1);
            contentValues.put("rrule", "FREQ=YEARLY;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
            contentValues.put("lastDate", Long.valueOf(calendar2.getTimeInMillis()));
            return getActivity().getContentResolver().insert(Uri.parse(m2153h() + "events"), contentValues);
        }
        try {
            Class<?> cls = Class.forName("android.provider.CalendarContract$Events");
            contentValues.put((String) cls.getField("CALENDAR_ID").get(new String()), Integer.valueOf(i));
            contentValues.put((String) cls.getField("TITLE").get(new String()), String.format(getString(R.string.buddy_profile_save_birthday_calendar_title), str));
            contentValues.put((String) cls.getField("DTSTART").get(new String()), Long.valueOf(calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()));
            contentValues.put((String) cls.getField("EVENT_TIMEZONE").get(new String()), calendar.getTimeZone().getID());
            contentValues.put((String) cls.getField("DURATION").get(new String()), "P1D");
            contentValues.put((String) cls.getField("ALL_DAY").get(new String()), (Integer) 1);
            contentValues.put((String) cls.getField("HAS_ALARM").get(new String()), (Integer) 0);
            contentValues.put((String) cls.getField("HAS_EXTENDED_PROPERTIES").get(new String()), (Integer) 1);
            contentValues.put((String) cls.getField("HAS_ATTENDEE_DATA").get(new String()), (Integer) 1);
            contentValues.put((String) cls.getField("RRULE").get(new String()), "FREQ=YEARLY;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
            contentValues.put((String) cls.getField("LAST_DATE").get(new String()), Long.valueOf(calendar2.getTimeInMillis()));
            return getActivity().getContentResolver().insert((Uri) cls.getField("CONTENT_URI").get(Uri.parse("")), contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    private String m2153h() {
        Cursor cursorQuery;
        Cursor cursorQuery2;
        try {
            cursorQuery = getActivity().getContentResolver().query(Uri.parse("content://calendar/calendars"), null, null, null, null);
        } catch (Exception e) {
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            return "content://calendar/";
        }
        try {
            cursorQuery2 = getActivity().getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), null, null, null, null);
        } catch (Exception e2) {
            cursorQuery2 = cursorQuery;
        }
        if (cursorQuery2 != null) {
            return "content://com.android.calendar/";
        }
        return null;
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view != null) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            C0839c c0839c = (C0839c) this.f1114W.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
            if (c0839c != null) {
                String strM3495a = c0839c.m3495a();
                String strM3498d = c0839c.m3498d();
                if (strM3495a.equals(f1090ad)) {
                    contextMenu.setHeaderTitle(R.string.mypage_buddies_say);
                    contextMenu.add(0, 2000, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0347de(this, strM3498d));
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9 && i2 == -1) {
            C1786r.m6066e("Write memo Success", f1089a);
            this.f1132ap = true;
            this.f1128al.setVisibility(8);
            this.f1127ak.setVisibility(0);
            this.f1118aa.m2897a(this.f1159u);
            return;
        }
        if (i == 8 && i2 == -1) {
            C1786r.m6066e("PROFILE_EDIT_BUDDY_NAME", f1089a);
            this.f1160v = intent.getExtras().getString("PROFILE_BUDDY_RENAME");
            this.f1164z.setText(this.f1160v);
        }
    }

    /* renamed from: a */
    public static boolean m2132a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null && this.f1124ah != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f1124ah.getWindowToken(), 0);
        }
        super.onStop();
    }

    @Override // com.sec.chaton.buddy.InterfaceC0299bk
    /* renamed from: a */
    public void mo2173a() {
        this.f1161w = true;
        this.f1093B.setChecked(true);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0299bk
    /* renamed from: b */
    public void mo2174b() {
        this.f1161w = false;
        this.f1093B.setChecked(false);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0299bk
    /* renamed from: c */
    public void mo2175c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x012b, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0131, code lost:
    
        if (r2.isClosed() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0133, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0167, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0168, code lost:
    
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x016c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0170, code lost:
    
        throw r3;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m2128a(java.lang.String r16, long r17, long r19) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyProfileFragment.m2128a(java.lang.String, long, long):java.lang.String");
    }
}
