package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.coolots.C0613d;
import com.sec.chaton.memo.C0729b;
import com.sec.chaton.memo.C0734g;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p013a.C0224w;
import com.sec.chaton.p013a.p014a.C0159bh;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.p032i.C0722a;
import com.sec.chaton.p032i.InterfaceC0723b;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.C1619g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public class BuddyProfileActivity extends BaseActivity implements InterfaceC0723b {

    /* renamed from: A */
    private LinearLayout f1199A;

    /* renamed from: B */
    private ImageButton f1200B;

    /* renamed from: C */
    private ImageButton f1201C;

    /* renamed from: D */
    private ImageButton f1202D;

    /* renamed from: E */
    private ImageButton f1203E;

    /* renamed from: F */
    private ImageButton f1204F;

    /* renamed from: G */
    private ImageButton f1205G;

    /* renamed from: H */
    private ViewGroup f1206H;

    /* renamed from: I */
    private Button f1207I;

    /* renamed from: J */
    private Button f1208J;

    /* renamed from: K */
    private Button f1209K;

    /* renamed from: L */
    private Button f1210L;

    /* renamed from: M */
    private TextView f1211M;

    /* renamed from: O */
    private C0729b f1213O;

    /* renamed from: P */
    private ListView f1214P;

    /* renamed from: R */
    private C0224w f1216R;

    /* renamed from: T */
    private TextView f1217T;

    /* renamed from: U */
    private View f1218U;

    /* renamed from: V */
    private View f1219V;

    /* renamed from: W */
    private LinearLayout f1220W;

    /* renamed from: X */
    private Button f1221X;

    /* renamed from: Y */
    private LinearLayout f1222Y;

    /* renamed from: Z */
    private String f1223Z;

    /* renamed from: aa */
    private String f1224aa;

    /* renamed from: ab */
    private String f1225ab;

    /* renamed from: ac */
    private boolean f1226ac;

    /* renamed from: ad */
    private boolean f1227ad;

    /* renamed from: ae */
    private int f1228ae;

    /* renamed from: af */
    private TextView f1229af;

    /* renamed from: i */
    private C0630j f1238i;

    /* renamed from: j */
    private Toast f1239j;

    /* renamed from: k */
    private Context f1240k;

    /* renamed from: l */
    private C0363a f1241l;

    /* renamed from: m */
    private String f1242m;

    /* renamed from: n */
    private String f1243n;

    /* renamed from: o */
    private boolean f1244o;

    /* renamed from: p */
    private ImageView f1245p;

    /* renamed from: q */
    private TextView f1246q;

    /* renamed from: r */
    private TextView f1247r;

    /* renamed from: s */
    private CheckBox f1248s;

    /* renamed from: t */
    private TextView f1249t;

    /* renamed from: u */
    private TextView f1250u;

    /* renamed from: v */
    private ImageView f1251v;

    /* renamed from: w */
    private TextView f1252w;

    /* renamed from: x */
    private TextView f1253x;

    /* renamed from: y */
    private TextView f1254y;

    /* renamed from: z */
    private LinearLayout f1255z;

    /* renamed from: a */
    public static final String f1198a = BuddyProfileActivity.class.getSimpleName();

    /* renamed from: S */
    private static String f1197S = "";

    /* renamed from: N */
    private ProgressDialog f1212N = null;

    /* renamed from: Q */
    private ArrayList f1215Q = new ArrayList();

    /* renamed from: ag */
    private boolean f1230ag = false;

    /* renamed from: b */
    View.OnClickListener f1232b = new ViewOnClickListenerC0398bf(this);

    /* renamed from: c */
    Handler f1233c = new HandlerC0397be(this);

    /* renamed from: d */
    Handler f1234d = new HandlerC0400bh(this);

    /* renamed from: e */
    InterfaceC0641d f1235e = new C0399bg(this);

    /* renamed from: f */
    InterfaceC0626f f1236f = new C0402bj(this);

    /* renamed from: ah */
    private Handler f1231ah = new HandlerC0401bi(this);

    /* renamed from: g */
    AbsListView.OnScrollListener f1237g = new C0395bc(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f1240k = this;
        this.f1238i = new C0630j(getContentResolver(), this.f1236f);
        this.f1239j = C1619g.m5889a(this, (CharSequence) null, 0);
        this.f1242m = getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f1243n = getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        C1341p.m4658b("*********** BUDDY NO" + this.f1242m, "BUDDY PROFILE");
        C1341p.m4658b("*********** BUDDY NAME" + this.f1243n, "BUDDY PROFILE");
        if (this.f1242m == null) {
            finish();
        }
        if (this.f1243n == null) {
            this.f1243n = "";
        }
        m2251a();
        this.f1238i.startQuery(3, null, C0667t.m3029d(), null, "buddy_no = ? ", new String[]{this.f1242m}, null);
    }

    /* renamed from: a */
    private void m2251a() {
        f1197S = C1323bs.m4575a().getString("msisdn", "");
        this.f1216R = new C0224w(this.f1233c);
        this.f1218U = getLayoutInflater().inflate(R.layout.buddy_profile_header_layout, (ViewGroup) null);
        this.f1219V = getLayoutInflater().inflate(R.layout.memo_refresh_footer, (ViewGroup) null);
        this.f1220W = (LinearLayout) this.f1219V.findViewById(R.id.footer_progress);
        this.f1221X = (Button) this.f1219V.findViewById(R.id.footer_memo_content);
        this.f1222Y = (LinearLayout) this.f1219V.findViewById(R.id.footer_memo_content_layout);
        this.f1223Z = "";
        this.f1224aa = "";
        this.f1225ab = "";
        this.f1226ac = true;
        this.f1212N = (ProgressDialog) new C1356c(this.f1240k).m4728a(R.string.buddy_list_progress_dialog_message);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() throws PackageManager.NameNotFoundException {
        super.onStart();
        C1341p.m4660c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        m2259b();
        this.f1230ag = C0722a.m3116a(this).m3120a(this, this);
    }

    /* renamed from: b */
    private void m2259b() throws PackageManager.NameNotFoundException {
        if (this.f1204F != null && this.f1205G != null && this.f1241l != null) {
            boolean zM2831a = AbstractC0617h.m2831a(this);
            boolean zM689a = C0159bh.m689a(this.f1241l.m2339y());
            boolean zM691b = C0159bh.m691b(this.f1241l.m2339y());
            boolean zM692c = C0159bh.m692c(this.f1241l.m2339y());
            boolean zM694g = C0159bh.m694g();
            boolean zM695h = C0159bh.m695h();
            boolean z = this.f1241l.m2338x() != 1;
            C1341p.m4658b("refreshCommunicationButtons voip support me " + zM2831a + ", buddy " + zM689a + ", phone number available " + z, null);
            if (zM2831a && zM689a) {
                this.f1204F.setVisibility(8);
                this.f1205G.setVisibility(8);
                if (zM694g && zM691b) {
                    this.f1204F.setVisibility(0);
                }
                if (zM695h && zM692c) {
                    this.f1205G.setVisibility(0);
                }
                this.f1201C.setVisibility(8);
                this.f1203E.setVisibility(8);
            } else {
                this.f1204F.setVisibility(8);
                this.f1205G.setVisibility(8);
                if (z && m2254a(this, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")))) {
                    this.f1201C.setVisibility(0);
                } else {
                    this.f1201C.setVisibility(8);
                }
                if (z) {
                    this.f1203E.setVisibility(0);
                } else {
                    this.f1203E.setVisibility(8);
                }
            }
            if (z) {
                this.f1218U.findViewById(R.id.layout_profile_phone_no).setVisibility(0);
                this.f1218U.findViewById(R.id.layout_profile_phone_no_line).setVisibility(0);
            } else {
                this.f1218U.findViewById(R.id.layout_profile_phone_no).setVisibility(8);
                this.f1218U.findViewById(R.id.layout_profile_phone_no_line).setVisibility(8);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4660c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f1238i.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode("+" + this.f1242m)), null, null, null, null);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C1341p.m4660c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (this.f1230ag) {
            C0722a.m3116a(this).m3122b(this, this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1341p.m4660c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address: " + isFinishing(), getClass().getSimpleName());
        m2272g();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2252a(int i) throws PackageManager.NameNotFoundException, NumberFormatException {
        int i2;
        int i3;
        if (i == 1) {
            setContentView(R.layout.buddy_profile_layout);
            this.f1245p = (ImageView) findViewById(R.id.profile_image);
            this.f1246q = (TextView) findViewById(R.id.profile_name);
            this.f1247r = (TextView) findViewById(R.id.profile_status_message);
            this.f1248s = (CheckBox) findViewById(R.id.profile_is_favorite);
            this.f1249t = (TextView) this.f1218U.findViewById(R.id.profile_phone_no);
            this.f1250u = (TextView) this.f1218U.findViewById(R.id.profile_birthday);
            this.f1251v = (ImageView) this.f1218U.findViewById(R.id.profile_calendar);
            this.f1252w = (TextView) this.f1218U.findViewById(R.id.profile_relationship_status);
            this.f1200B = (ImageButton) this.f1218U.findViewById(R.id.profile_chat);
            this.f1200B.setOnTouchListener(new ViewOnTouchListenerC0458w(this));
            this.f1201C = (ImageButton) this.f1218U.findViewById(R.id.profile_call);
            this.f1201C.setOnTouchListener(new ViewOnTouchListenerC0457v(this));
            this.f1202D = (ImageButton) this.f1218U.findViewById(R.id.profile_msg);
            this.f1202D.setOnTouchListener(new ViewOnTouchListenerC0456u(this));
            this.f1203E = (ImageButton) this.f1218U.findViewById(R.id.profile_contact);
            this.f1203E.setOnTouchListener(new ViewOnTouchListenerC0455t(this));
            this.f1253x = (TextView) this.f1218U.findViewById(R.id.interaction_buddy_point);
            this.f1254y = (TextView) this.f1218U.findViewById(R.id.interaction_me_point);
            this.f1255z = (LinearLayout) this.f1218U.findViewById(R.id.interaction_left);
            this.f1199A = (LinearLayout) this.f1218U.findViewById(R.id.interaction_right);
            C1341p.m4663f("mBuddyInfo.getProfileStatus() : " + this.f1241l.m2332r(), f1198a);
            if (this.f1241l.m2332r() == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || this.f1241l.m2332r() == Buddy.BuddyImageStatus.NOT_CHANGE.getCode()) {
                this.f1245p.setOnClickListener(this.f1232b);
            }
            this.f1200B.setOnClickListener(this.f1232b);
            this.f1201C.setOnClickListener(this.f1232b);
            this.f1202D.setOnClickListener(this.f1232b);
            this.f1203E.setOnClickListener(this.f1232b);
            if (this.f1241l.m2338x() == 1) {
                this.f1203E.setVisibility(8);
            } else {
                this.f1203E.setVisibility(0);
            }
            this.f1204F = (ImageButton) this.f1218U.findViewById(R.id.profile_voice_call);
            this.f1205G = (ImageButton) this.f1218U.findViewById(R.id.profile_video_call);
            this.f1204F.setOnClickListener(this.f1232b);
            this.f1204F.setOnTouchListener(new ViewOnTouchListenerC0367ab(this));
            this.f1205G.setOnClickListener(this.f1232b);
            this.f1205G.setOnTouchListener(new ViewOnTouchListenerC0366aa(this));
            m2259b();
            this.f1246q.setText(this.f1241l.m2314b());
            this.f1246q.setContentDescription(this.f1241l.m2314b());
            this.f1246q.setOnTouchListener(new ViewOnTouchListenerC0461z(this));
            if (TextUtils.isEmpty(this.f1241l.m2316c())) {
                this.f1247r.setVisibility(8);
            } else {
                this.f1247r.setText(this.f1241l.m2316c());
                this.f1247r.setOnTouchListener(new ViewOnTouchListenerC0460y(this));
            }
            this.f1248s.setChecked(this.f1244o);
            this.f1249t.setText("+" + this.f1241l.m2308a());
            this.f1249t.setContentDescription(this.f1241l.m2308a());
            this.f1249t.setOnTouchListener(new ViewOnTouchListenerC0459x(this));
            C1341p.m4658b("************** BIRTHDAY : " + this.f1241l.m2320f(), null);
            if (this.f1241l.m2320f().equals("0000-12-31") || this.f1241l.m2320f() == null || this.f1241l.m2320f().length() == 0) {
                ((LinearLayout) this.f1218U.findViewById(R.id.profile_birthday_area)).setVisibility(8);
                ((ImageView) this.f1218U.findViewById(R.id.profile_birthday_area_bottom_line)).setVisibility(8);
            } else {
                String strM4289a = MyPageFragment.m4289a(this.f1241l.m2320f());
                if ((this.f1241l.m2320f().length() == 5 || this.f1241l.m2320f().length() == 10) && strM4289a.length() > 0) {
                    this.f1250u.setText(strM4289a);
                    this.f1250u.setContentDescription(strM4289a);
                    this.f1250u.setOnTouchListener(new ViewOnTouchListenerC0390ay(this));
                    this.f1251v.setOnClickListener(this.f1232b);
                    this.f1251v.setVisibility(0);
                } else {
                    this.f1251v.setVisibility(4);
                    this.f1251v.setOnClickListener(null);
                }
            }
            this.f1252w.setText(getResources().getString(R.string.buddy_profile_rank) + " " + (this.f1241l.m2330p() == 9999999 ? 0 : this.f1241l.m2330p()) + "  /  " + getResources().getString(R.string.buddy_profile_point) + " " + this.f1241l.m2327m());
            this.f1252w.setContentDescription(getResources().getString(R.string.buddy_profile_rank) + " " + (this.f1241l.m2330p() == 9999999 ? 0 : this.f1241l.m2330p()) + "  /  " + getResources().getString(R.string.buddy_profile_point) + " " + this.f1241l.m2327m());
            this.f1252w.setOnTouchListener(new ViewOnTouchListenerC0391az(this));
            int iM2326l = this.f1241l.m2326l() > 0 ? this.f1241l.m2326l() : 0;
            int iM2325k = this.f1241l.m2325k() > 0 ? this.f1241l.m2325k() : 0;
            if (iM2326l == 0 && iM2325k == 0) {
                i3 = 1;
                i2 = 1;
            } else {
                int i4 = iM2325k;
                i2 = iM2326l;
                i3 = i4;
            }
            this.f1253x.setText(" (" + this.f1241l.m2326l() + ")");
            if (i2 > i3) {
                i2 = 2;
                i3 = 1;
            } else if (i3 > i2) {
                i3 = 2;
                i2 = 1;
            }
            this.f1255z.setLayoutParams(new LinearLayout.LayoutParams(0, -1, i2));
            this.f1199A.setLayoutParams(new LinearLayout.LayoutParams(0, -1, i3));
            this.f1254y.setText(" (" + this.f1241l.m2325k() + ")");
            if (this.f1241l.m2327m() > 0) {
                ((LinearLayout) this.f1218U.findViewById(R.id.buddy_profile_interation_graph)).setVisibility(0);
                ((LinearLayout) this.f1218U.findViewById(R.id.buddy_profile_no_interations)).setVisibility(8);
            } else {
                ((LinearLayout) this.f1218U.findViewById(R.id.buddy_profile_interation_graph)).setVisibility(8);
                ((LinearLayout) this.f1218U.findViewById(R.id.buddy_profile_no_interations)).setVisibility(0);
                ((LinearLayout) this.f1218U.findViewById(R.id.buddy_profile_no_interations)).setOnTouchListener(new ViewOnTouchListenerC0388aw(this));
            }
            this.f1248s.setOnClickListener(this.f1232b);
            C1348w.m4685a(this.f1240k).m4700a(this.f1245p, this.f1241l.m2308a(), this.f1241l.m2332r());
            this.f1217T = (TextView) this.f1218U.findViewById(R.id.memo_btn_write);
            this.f1217T.setOnClickListener(this.f1232b);
            this.f1214P = (ListView) findViewById(R.id.profile_memo_list);
            registerForContextMenu(this.f1214P);
            this.f1226ac = true;
            this.f1216R.m864a(this.f1242m);
            this.f1213O = new C0729b(this.f1214P, this.f1240k, this.f1215Q, R.layout.memo_adapter_item);
            this.f1214P.addHeaderView(this.f1218U, null, false);
            this.f1214P.addFooterView(this.f1219V);
            this.f1214P.setAdapter((ListAdapter) this.f1213O);
            this.f1214P.setSelection(this.f1214P.getHeaderViewsCount());
            this.f1214P.setScrollbarFadingEnabled(true);
            this.f1214P.setOnScrollListener(this.f1237g);
            this.f1229af = (TextView) findViewById(R.id.memo_layout_title);
            this.f1229af.setOnTouchListener(new ViewOnTouchListenerC0389ax(this));
            this.f1220W.setVisibility(0);
            return;
        }
        setContentView(R.layout.new_buddy_layout);
        this.f1246q = (TextView) findViewById(R.id.new_buddy_name);
        this.f1211M = (TextView) findViewById(R.id.new_buddy_information);
        if (this.f1243n == null || this.f1243n.equals("")) {
            this.f1246q.setText(getString(R.string.buddy_profile_no_name));
        } else {
            this.f1246q.setText(this.f1243n);
        }
        this.f1246q.setContentDescription(this.f1243n);
        this.f1206H = (ViewGroup) findViewById(R.id.new_buddy_menu);
        this.f1209K = (Button) findViewById(R.id.new_buddy_add);
        this.f1207I = (Button) findViewById(R.id.new_buddy_block);
        this.f1208J = (Button) findViewById(R.id.new_buddy_unblock);
        this.f1210L = (Button) findViewById(R.id.new_buddy_cancel);
        this.f1209K.setOnClickListener(this.f1232b);
        this.f1207I.setOnClickListener(this.f1232b);
        this.f1208J.setOnClickListener(this.f1232b);
        this.f1210L.setOnClickListener(this.f1232b);
        this.f1241l = new C0363a(this.f1242m, this.f1243n, null, null, null, null, false, 0, null, true);
        m2270e();
        new C0202ao(this.f1231ah).m770e(this.f1242m, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Uri m2247a(String str) {
        try {
            int iM2261c = m2261c();
            if (iM2261c <= 0) {
                return null;
            }
            return m2246a(iM2261c, this.f1241l.m2314b(), str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: c */
    private int m2261c() {
        String[] strArr = {"_id", "name"};
        String str = "selected=1";
        if (Build.VERSION.SDK_INT >= 14) {
            str = null;
        }
        Cursor cursorM2245a = m2245a(strArr, str, "calendars");
        if (cursorM2245a != null && cursorM2245a.moveToFirst()) {
            int columnIndex = cursorM2245a.getColumnIndex("name");
            int columnIndex2 = cursorM2245a.getColumnIndex("_id");
            do {
                String string = cursorM2245a.getString(columnIndex);
                String string2 = cursorM2245a.getString(columnIndex2);
                if (string != null) {
                    return Integer.parseInt(string2);
                }
            } while (cursorM2245a.moveToNext());
        }
        return 0;
    }

    /* renamed from: a */
    private Cursor m2245a(String[] strArr, String str, String str2) {
        Cursor cursorManagedQuery = null;
        try {
            cursorManagedQuery = managedQuery(Uri.parse("content://calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorManagedQuery != null) {
            return cursorManagedQuery;
        }
        try {
            return managedQuery(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorManagedQuery;
        }
    }

    /* renamed from: a */
    private Uri m2246a(int i, String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        String str3 = String.valueOf(calendar.get(1)) + "-" + str2;
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        calendar2.add(1, 40);
        String str4 = new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime());
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT < 14) {
            contentValues.put("calendar_id", Integer.valueOf(i));
            contentValues.put("title", String.format(getString(R.string.buddy_profile_save_birthday_calendar_title), str));
            contentValues.put("dtstart", Long.valueOf(calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()));
            contentValues.put("eventTimezone", calendar.getTimeZone().getID());
            contentValues.put("duration", "P1D");
            contentValues.put("allDay", (Integer) 1);
            contentValues.put("visibility", (Integer) 0);
            contentValues.put("transparency", (Integer) 0);
            contentValues.put("hasAlarm", (Integer) 0);
            contentValues.put("hasExtendedProperties", (Integer) 1);
            contentValues.put("hasAttendeeData", (Integer) 1);
            if (str2.contains("02-29")) {
                contentValues.put("rrule", "FREQ=YEARLY;INTERVAL=4;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
            } else {
                contentValues.put("rrule", "FREQ=YEARLY;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
            }
            contentValues.put("lastDate", Long.valueOf(calendar2.getTimeInMillis()));
            return getContentResolver().insert(Uri.parse(m2266d() + "events"), contentValues);
        }
        contentValues.put("calendar_id", Integer.valueOf(i));
        contentValues.put("title", String.format(getString(R.string.buddy_profile_save_birthday_calendar_title), str));
        contentValues.put("dtstart", Long.valueOf(calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()));
        contentValues.put("eventTimezone", calendar.getTimeZone().getID());
        contentValues.put("duration", "P1D");
        contentValues.put("allDay", (Integer) 1);
        contentValues.put("hasAlarm", (Integer) 0);
        contentValues.put("hasExtendedProperties", (Integer) 1);
        contentValues.put("hasAttendeeData", (Integer) 1);
        if (str2.contains("02-29")) {
            contentValues.put("rrule", "FREQ=YEARLY;INTERVAL=4;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
        } else {
            contentValues.put("rrule", "FREQ=YEARLY;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
        }
        contentValues.put("lastDate", Long.valueOf(calendar2.getTimeInMillis()));
        return getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
    }

    /* renamed from: d */
    private String m2266d() {
        Cursor cursorManagedQuery;
        Cursor cursorManagedQuery2;
        try {
            cursorManagedQuery = managedQuery(Uri.parse("content://calendar/calendars"), null, null, null, null);
        } catch (Exception e) {
            cursorManagedQuery = null;
        }
        if (cursorManagedQuery != null) {
            return "content://calendar/";
        }
        try {
            cursorManagedQuery2 = managedQuery(Uri.parse("content://com.android.calendar/calendars"), null, null, null, null);
        } catch (Exception e2) {
            cursorManagedQuery2 = cursorManagedQuery;
        }
        if (cursorManagedQuery2 != null) {
            return "content://com.android.calendar/";
        }
        return null;
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view != null) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            C0734g c0734g = (C0734g) this.f1214P.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
            if (c0734g != null) {
                String strM3138a = c0734g.m3138a();
                String strM3141d = c0734g.m3141d();
                if (strM3138a.equals(f1197S)) {
                    contextMenu.setHeaderTitle(R.string.setting_interaction_me);
                    contextMenu.add(0, 2000, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0394bb(this, strM3141d));
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9 && i2 == -1) {
            C1341p.m4662e("Write memo Success", f1198a);
            this.f1226ac = true;
            this.f1216R.m864a(this.f1242m);
            m2270e();
            return;
        }
        if (i == 5 && !this.f1227ad) {
            this.f1238i.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode("+" + this.f1242m)), null, null, null, null);
        }
    }

    /* renamed from: a */
    public static boolean m2254a(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null && packageManager.queryIntentActivities(intent, 65536).size() > 0;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f1242m = getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f1243n = getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        C1341p.m4658b("*********** BUDDY NO" + this.f1242m, "BUDDY PROFILE");
        C1341p.m4658b("*********** BUDDY NAME" + this.f1243n, "BUDDY PROFILE");
        if (this.f1242m == null) {
            finish();
        }
        if (this.f1243n == null) {
            this.f1243n = "";
        }
        m2272g();
        this.f1238i.startQuery(3, null, C0667t.m3029d(), null, "buddy_no = ? ", new String[]{this.f1242m}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2270e() {
        if (!isFinishing()) {
            this.f1212N.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2272g() {
        if (!isFinishing()) {
            this.f1212N.dismiss();
        }
    }

    @Override // com.sec.chaton.p032i.InterfaceC0723b
    /* renamed from: f */
    public void mo2293f() {
        Uri uri;
        C1341p.m4658b("onDirectCall", getClass().getSimpleName());
        if (C0722a.m3116a(this).m3121b(this) && this.f1241l != null) {
            int iM2338x = this.f1241l.m2338x();
            String strM2319e = this.f1241l.m2319e();
            String strM2308a = this.f1241l.m2308a();
            if (C0722a.m3116a(this).m3118a(this, this.f1241l.m2339y(), iM2338x) == 1) {
                if (!TextUtils.isEmpty(strM2319e)) {
                    uri = Uri.parse("tel:" + strM2319e);
                } else {
                    uri = Uri.parse("tel:+" + strM2308a);
                }
                Intent intent = new Intent("android.intent.action.CALL", uri);
                intent.setFlags(268435456);
                try {
                    startActivityForResult(intent, 0);
                } catch (ActivityNotFoundException e) {
                    C1341p.m4653a(e, getClass().getSimpleName());
                }
                C1341p.m4658b("onDirectCall-Normal Call", getClass().getSimpleName());
                return;
            }
            if (C0722a.m3116a(this).m3118a(this, this.f1241l.m2339y(), iM2338x) == 2) {
                if (!new C0613d(this, new C0396bd(this), new String[]{this.f1242m}, true).m2832b()) {
                    C1619g.m5889a(this, "Install Coolots app first.", 0).show();
                }
                C1341p.m4658b("onDirectCall-VOIP Call", getClass().getSimpleName());
                return;
            }
            C1341p.m4658b("onDirectCall-No Call", getClass().getSimpleName());
        }
    }
}
