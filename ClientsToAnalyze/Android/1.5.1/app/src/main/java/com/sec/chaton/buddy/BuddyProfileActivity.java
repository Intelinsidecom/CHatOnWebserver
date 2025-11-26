package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.control.BlockControl;
import com.sec.chaton.control.MemoControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.memo.MemoAdapter;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.userprofile.UserProfileDetail;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.widget.SMSProgressBar;
import com.sec.pns.msg.MsgResultCode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public class BuddyProfileActivity extends BaseActivity {

    /* renamed from: A */
    private ImageButton f554A;

    /* renamed from: B */
    private ImageButton f555B;

    /* renamed from: C */
    private Button f556C;

    /* renamed from: D */
    private Button f557D;

    /* renamed from: E */
    private Button f558E;

    /* renamed from: F */
    private Button f559F;

    /* renamed from: G */
    private TextView f560G;

    /* renamed from: I */
    private MemoAdapter f562I;

    /* renamed from: J */
    private ListView f563J;

    /* renamed from: L */
    private MemoControl f565L;

    /* renamed from: N */
    private Button f566N;

    /* renamed from: O */
    private ImageView f567O;

    /* renamed from: P */
    private View f568P;

    /* renamed from: Q */
    private View f569Q;

    /* renamed from: R */
    private ProgressBar f570R;

    /* renamed from: S */
    private Button f571S;

    /* renamed from: T */
    private String f572T;

    /* renamed from: U */
    private String f573U;

    /* renamed from: V */
    private String f574V;

    /* renamed from: W */
    private boolean f575W;

    /* renamed from: h */
    private NotifyingAsyncQueryHandler f583h;

    /* renamed from: i */
    private Context f584i;

    /* renamed from: j */
    private BuddyItem f585j;

    /* renamed from: k */
    private String f586k;

    /* renamed from: l */
    private String f587l;

    /* renamed from: m */
    private boolean f588m;

    /* renamed from: n */
    private ImageView f589n;

    /* renamed from: o */
    private TextView f590o;

    /* renamed from: p */
    private TextView f591p;

    /* renamed from: q */
    private CheckBox f592q;

    /* renamed from: r */
    private TextView f593r;

    /* renamed from: s */
    private TextView f594s;

    /* renamed from: t */
    private ImageView f595t;

    /* renamed from: u */
    private TextView f596u;

    /* renamed from: v */
    private TextView f597v;

    /* renamed from: w */
    private TextView f598w;

    /* renamed from: x */
    private ImageView f599x;

    /* renamed from: y */
    private ImageView f600y;

    /* renamed from: z */
    private ImageButton f601z;

    /* renamed from: a */
    public static final String f553a = BuddyProfileActivity.class.getSimpleName();

    /* renamed from: M */
    private static String f552M = "";

    /* renamed from: H */
    private ProgressDialog f561H = null;

    /* renamed from: K */
    private ArrayList f564K = new ArrayList();

    /* renamed from: b */
    View.OnClickListener f577b = new ViewOnClickListenerC0133z(this);

    /* renamed from: c */
    Handler f578c = new HandlerC0132y(this);

    /* renamed from: d */
    Handler f579d = new HandlerC0131x(this);

    /* renamed from: e */
    AbstractQueryTask.OnQueryTaskResult f580e = new C0130w(this);

    /* renamed from: f */
    NotifyingAsyncQueryHandler.AsyncQueryListener f581f = new C0080ad(this);

    /* renamed from: X */
    private Handler f576X = new HandlerC0079ac(this);

    /* renamed from: g */
    AbsListView.OnScrollListener f582g = new C0077aa(this);

    /* renamed from: a */
    private Cursor m601a(String[] strArr, String str, String str2) {
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
    private Uri m602a(int i, String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str2));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str2));
        calendar2.add(1, 195);
        String str3 = new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime());
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar_id", Integer.valueOf(i));
        contentValues.put("title", String.format(getString(C0062R.string.buddy_profile_save_birthday_calendar_title), str));
        contentValues.put("dtstart", Long.valueOf(calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()));
        contentValues.put("eventTimezone", calendar.getTimeZone().getID());
        contentValues.put("duration", "P1D");
        contentValues.put("allDay", (Integer) 1);
        contentValues.put("visibility", (Integer) 0);
        contentValues.put("transparency", (Integer) 0);
        contentValues.put("hasAlarm", (Integer) 0);
        contentValues.put("hasExtendedProperties", (Integer) 1);
        contentValues.put("hasAttendeeData", (Integer) 1);
        contentValues.put("rrule", "FREQ=YEARLY;UNTIL=" + str3 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
        contentValues.put("lastDate", Long.valueOf(calendar2.getTimeInMillis()));
        return getContentResolver().insert(Uri.parse(m616c() + "events"), contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Uri m603a(String str) {
        try {
            int iM611b = m611b();
            if (iM611b > 0) {
                return m602a(iM611b, this.f585j.m673b(), str);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private void m607a() {
        f552M = ChatONPref.m3519a().getString("msisdn", "");
        this.f565L = new MemoControl(this.f578c);
        this.f568P = getLayoutInflater().inflate(C0062R.layout.buddy_profile_header_layout, (ViewGroup) null);
        this.f569Q = getLayoutInflater().inflate(C0062R.layout.memo_refresh_footer, (ViewGroup) null);
        this.f570R = (ProgressBar) this.f569Q.findViewById(C0062R.id.footer_progress);
        this.f571S = (Button) this.f569Q.findViewById(C0062R.id.footer_memo_content);
        this.f572T = "";
        this.f573U = "";
        this.f574V = "";
        this.f575W = true;
        this.f561H = (ProgressDialog) new SMSProgressBar(this.f584i).onCreate(C0062R.string.buddy_list_progress_dialog_message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m608a(int i) throws NumberFormatException {
        int i2;
        int i3;
        if (i != 1) {
            setContentView(C0062R.layout.new_buddy_layout);
            this.f589n = (ImageView) findViewById(C0062R.id.profile_nonbuddy_image);
            this.f590o = (TextView) findViewById(C0062R.id.new_buddy_name);
            this.f560G = (TextView) findViewById(C0062R.id.new_buddy_information);
            if (this.f587l == null || this.f587l.equals("")) {
                this.f590o.setText(getString(C0062R.string.buddy_profile_no_name));
            } else {
                this.f590o.setText(this.f587l);
            }
            this.f558E = (Button) findViewById(C0062R.id.new_buddy_add);
            this.f556C = (Button) findViewById(C0062R.id.new_buddy_block);
            this.f557D = (Button) findViewById(C0062R.id.new_buddy_unblock);
            this.f559F = (Button) findViewById(C0062R.id.new_buddy_cancel);
            this.f558E.setOnClickListener(this.f577b);
            this.f556C.setOnClickListener(this.f577b);
            this.f557D.setOnClickListener(this.f577b);
            this.f559F.setOnClickListener(this.f577b);
            this.f585j = new BuddyItem(this.f586k, this.f587l, null, null, null, null, false, 0, null, true);
            ProfileImageLoader.m3610a(this.f584i).m3623a(this.f589n, this.f586k);
            new BlockControl(this.f576X).m1989a();
            this.f561H = ProgressDialog.show(this.f584i, null, getResources().getString(C0062R.string.buddy_list_progress_dialog_message), true);
            return;
        }
        setContentView(C0062R.layout.buddy_profile_layout);
        this.f589n = (ImageView) findViewById(C0062R.id.profile_image);
        this.f590o = (TextView) findViewById(C0062R.id.profile_name);
        this.f591p = (TextView) findViewById(C0062R.id.profile_status_message);
        this.f592q = (CheckBox) findViewById(C0062R.id.profile_is_favorite);
        this.f593r = (TextView) this.f568P.findViewById(C0062R.id.profile_phone_no);
        this.f594s = (TextView) this.f568P.findViewById(C0062R.id.profile_birthday);
        this.f595t = (ImageView) this.f568P.findViewById(C0062R.id.profile_calendar);
        this.f596u = (TextView) this.f568P.findViewById(C0062R.id.profile_relationship_status);
        this.f597v = (TextView) this.f568P.findViewById(C0062R.id.interaction_buddy_point);
        this.f598w = (TextView) this.f568P.findViewById(C0062R.id.interaction_me_point);
        this.f599x = (ImageView) this.f568P.findViewById(C0062R.id.interaction_buddy_weight);
        this.f600y = (ImageView) this.f568P.findViewById(C0062R.id.interaction_me_weight);
        this.f601z = (ImageButton) this.f568P.findViewById(C0062R.id.profile_chat);
        this.f554A = (ImageButton) this.f568P.findViewById(C0062R.id.profile_call);
        this.f555B = (ImageButton) this.f568P.findViewById(C0062R.id.profile_msg);
        ChatONLogWriter.m3512f("mBuddyInfo.getProfileStatus() : " + this.f585j.m693r(), f553a);
        if (this.f585j.m693r() == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || this.f585j.m693r() == Buddy.BuddyImageStatus.NOT_CHANGE.getCode()) {
            this.f589n.setOnClickListener(this.f577b);
        }
        this.f601z.setOnClickListener(this.f577b);
        this.f554A.setOnClickListener(this.f577b);
        this.f555B.setOnClickListener(this.f577b);
        this.f590o.setText(this.f585j.m673b());
        if (this.f585j.m676c() == null || this.f585j.m676c().trim().length() == 0) {
            this.f591p.setText("");
        } else {
            this.f591p.setText(this.f585j.m676c());
        }
        this.f592q.setChecked(this.f588m);
        this.f593r.setText("+" + this.f585j.m668a());
        if (this.f585j.m699x() == 1) {
            ChatONLogWriter.m3511e("Hide phone number because of privacy.", null);
            this.f568P.findViewById(C0062R.id.layout_profile_phone_no).setVisibility(8);
            this.f554A.setEnabled(false);
            this.f555B.setEnabled(false);
        } else {
            ChatONLogWriter.m3511e("Show phone number", null);
            this.f568P.findViewById(C0062R.id.layout_profile_phone_no).setVisibility(0);
            this.f554A.setEnabled(true);
            this.f555B.setEnabled(true);
        }
        ChatONLogWriter.m3506b("************** BIRTHDAY : " + this.f585j.m681f(), null);
        if (this.f585j.m681f().equals("0000-12-31") || this.f585j.m681f() == null || this.f585j.m681f().length() == 0) {
            ((LinearLayout) this.f568P.findViewById(C0062R.id.profile_birthday_area)).setVisibility(8);
            ((ImageView) this.f568P.findViewById(C0062R.id.profile_birthday_area_bottom_line)).setVisibility(8);
        } else {
            String strM3354a = UserProfileDetail.m3354a(this.f585j.m681f());
            if ((this.f585j.m681f().length() == 5 || this.f585j.m681f().length() == 10) && strM3354a.length() > 0) {
                this.f594s.setText(strM3354a);
                this.f595t.setOnClickListener(this.f577b);
                this.f595t.setVisibility(0);
            } else {
                this.f595t.setVisibility(8);
                this.f595t.setOnClickListener(null);
            }
        }
        this.f596u.setText(getResources().getString(C0062R.string.buddy_profile_rank) + " : " + (this.f585j.m691p() == 9999999 ? 0 : this.f585j.m691p()) + "  /  " + getResources().getString(C0062R.string.buddy_profile_point) + " : " + this.f585j.m688m());
        int iM687l = this.f585j.m687l() > 0 ? this.f585j.m687l() : 0;
        int iM686k = this.f585j.m686k() > 0 ? this.f585j.m686k() : 0;
        if (iM687l == 0 && iM686k == 0) {
            i3 = 1;
            i2 = 1;
        } else {
            int i4 = iM686k;
            i2 = iM687l;
            i3 = i4;
        }
        this.f599x.setLayoutParams(new LinearLayout.LayoutParams(0, -1, i2));
        this.f597v.setText("" + this.f585j.m687l());
        this.f600y.setLayoutParams(new LinearLayout.LayoutParams(0, -1, i3));
        this.f598w.setText("" + this.f585j.m686k());
        this.f592q.setOnClickListener(this.f577b);
        ProfileImageLoader.m3610a(this.f584i).m3624a(this.f589n, this.f585j.m668a(), this.f585j.m693r());
        this.f566N = (Button) this.f568P.findViewById(C0062R.id.memo_btn_write);
        this.f566N.setOnClickListener(this.f577b);
        this.f567O = (ImageView) this.f568P.findViewById(C0062R.id.memo_write_below_line);
        this.f563J = (ListView) findViewById(C0062R.id.profile_memo_list);
        registerForContextMenu(this.f563J);
        this.f575W = true;
        this.f565L.m2006a(this.f586k);
        this.f562I = new MemoAdapter(this.f563J, this.f584i, this.f564K, C0062R.layout.memo_adapter_item);
        this.f563J.addHeaderView(this.f568P, null, false);
        this.f563J.addFooterView(this.f569Q);
        this.f563J.setAdapter((ListAdapter) this.f562I);
        this.f563J.setSelection(this.f563J.getHeaderViewsCount());
        this.f563J.setScrollbarFadingEnabled(true);
        this.f563J.setOnScrollListener(this.f582g);
    }

    /* renamed from: b */
    private int m611b() {
        Cursor cursorM601a = m601a(new String[]{"_id", "name"}, "selected=1", "calendars");
        if (cursorM601a != null && cursorM601a.moveToFirst()) {
            int columnIndex = cursorM601a.getColumnIndex("name");
            int columnIndex2 = cursorM601a.getColumnIndex("_id");
            do {
                String string = cursorM601a.getString(columnIndex);
                String string2 = cursorM601a.getString(columnIndex2);
                if (string != null) {
                    return Integer.parseInt(string2);
                }
            } while (cursorM601a.moveToNext());
        }
        return 0;
    }

    /* renamed from: c */
    private String m616c() {
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

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9 && i2 == -1) {
            ChatONLogWriter.m3511e("Write memo Success", f553a);
            this.f575W = true;
            this.f565L.m2006a(this.f586k);
            this.f561H.show();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3508c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f584i = this;
        this.f583h = new NotifyingAsyncQueryHandler(getContentResolver(), this.f581f);
        this.f586k = getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f587l = getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        ChatONLogWriter.m3506b("*********** BUDDY NO" + this.f586k, "BUDDY PROFILE");
        ChatONLogWriter.m3506b("*********** BUDDY NAME" + this.f587l, "BUDDY PROFILE");
        if (this.f586k == null) {
            finish();
        }
        if (this.f587l == null) {
            this.f587l = "";
        }
        m607a();
        this.f583h.startQuery(3, null, ChatONContract.BuddyTable.m2173d(), null, "buddy_no = ? ", new String[]{this.f586k}, null);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view == null) {
            return;
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        MemoAdapter.MemoItem memoItem = (MemoAdapter.MemoItem) this.f563J.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (memoItem != null) {
            String strM2399a = memoItem.m2399a();
            String strM2402d = memoItem.m2402d();
            if (strM2399a.equals(f552M)) {
                contextMenu.setHeaderTitle(C0062R.string.memo_title);
                contextMenu.add(0, MsgResultCode.UNKNOWN_MESSAGE_TYPE, 1, C0062R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0078ab(this, strM2402d));
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3508c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ChatONLogWriter.m3508c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3508c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.f601z != null) {
            this.f601z.setEnabled(true);
            this.f601z.setClickable(true);
        }
    }
}
