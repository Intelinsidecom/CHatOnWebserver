package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.C0837a;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.p015d.C0647s;
import com.sec.chaton.p017e.C0703r;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.settings.SettingActivity;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.C1805i;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.HorizontalListView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class MyPageFragment extends Fragment implements InterfaceC0221al {

    /* renamed from: a */
    public static final String f5812a = MyPageFragment.class.getSimpleName();

    /* renamed from: A */
    private String f5813A;

    /* renamed from: B */
    private String f5814B;

    /* renamed from: C */
    private boolean f5815C;

    /* renamed from: D */
    private boolean f5816D;

    /* renamed from: E */
    private Uri f5817E;

    /* renamed from: F */
    private File f5818F;

    /* renamed from: G */
    private LinearLayout f5819G;

    /* renamed from: H */
    private Context f5820H;

    /* renamed from: I */
    private C0837a f5821I;

    /* renamed from: J */
    private ListView f5822J;

    /* renamed from: K */
    private ArrayList f5823K;

    /* renamed from: L */
    private C0638j f5824L;

    /* renamed from: M */
    private View f5825M;

    /* renamed from: N */
    private View f5826N;

    /* renamed from: O */
    private ProgressBar f5827O;

    /* renamed from: P */
    private Button f5828P;

    /* renamed from: Q */
    private String f5829Q;

    /* renamed from: R */
    private String f5830R;

    /* renamed from: S */
    private boolean f5831S;

    /* renamed from: T */
    private ProgressDialog f5832T;

    /* renamed from: U */
    private InterfaceC0667k f5833U;

    /* renamed from: V */
    private Handler f5834V;

    /* renamed from: b */
    final String f5835b;

    /* renamed from: c */
    AdapterView.OnItemClickListener f5836c;

    /* renamed from: d */
    AbsListView.OnScrollListener f5837d;

    /* renamed from: e */
    private final int f5838e = 0;

    /* renamed from: f */
    private final int f5839f = 1;

    /* renamed from: g */
    private final int f5840g = 2;

    /* renamed from: h */
    private final int f5841h = 3;

    /* renamed from: i */
    private final int f5842i = 5;

    /* renamed from: j */
    private final int f5843j = 6;

    /* renamed from: k */
    private File f5844k;

    /* renamed from: l */
    private C0647s f5845l;

    /* renamed from: m */
    private C0666j f5846m;

    /* renamed from: n */
    private ImageButton f5847n;

    /* renamed from: o */
    private TextView f5848o;

    /* renamed from: p */
    private TextView f5849p;

    /* renamed from: q */
    private TextView f5850q;

    /* renamed from: r */
    private TextView f5851r;

    /* renamed from: s */
    private HorizontalListView f5852s;

    /* renamed from: t */
    private C1714x f5853t;

    /* renamed from: u */
    private ArrayList f5854u;

    /* renamed from: v */
    private ProgressDialog f5855v;

    /* renamed from: w */
    private ImageButton f5856w;

    /* renamed from: x */
    private ImageView f5857x;

    /* renamed from: y */
    private LinearLayout f5858y;

    /* renamed from: z */
    private String f5859z;

    public MyPageFragment() {
        this.f5835b = C1767bw.m6002a() ? GlobalApplication.m3256a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
        this.f5844k = new File(this.f5835b + "/profile/");
        this.f5815C = false;
        this.f5816D = true;
        this.f5823K = new ArrayList();
        this.f5836c = new C1702l(this);
        this.f5833U = new C1713w(this);
        this.f5834V = new HandlerC1703m(this);
        this.f5837d = new C1705o(this);
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
        BaseActivity.m1827a(this, true);
        m5594e();
        m5596f();
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
        BaseActivity.m1827a(this, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5820H = GlobalApplication.m3260b();
        m5592d();
        this.f5829Q = "";
        this.f5830R = "";
        this.f5831S = true;
    }

    /* renamed from: d */
    private void m5592d() {
        this.f5845l = new C0647s(this.f5834V);
        this.f5824L = new C0638j(this.f5834V);
        this.f5846m = new C0666j(getActivity().getContentResolver(), this.f5833U);
        this.f5859z = C1789u.m6075a().getString("msisdn", "");
        this.f5813A = C1789u.m6075a().getString("Push Name", "");
        this.f5814B = C1789u.m6075a().getString("status_message", "");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        View viewInflate = layoutInflater.inflate(R.layout.layout_user_profile, viewGroup, false);
        this.f5825M = layoutInflater.inflate(R.layout.user_porfile_fragment_header2, (ViewGroup) null);
        this.f5826N = layoutInflater.inflate(R.layout.memo_refresh_footer, (ViewGroup) null);
        this.f5827O = (ProgressBar) this.f5826N.findViewById(R.id.footer_progress);
        this.f5828P = (Button) this.f5826N.findViewById(R.id.footer_memo_content);
        this.f5847n = (ImageButton) this.f5825M.findViewById(R.id.imgbtnUPPhoto);
        this.f5847n.requestFocus();
        this.f5848o = (TextView) this.f5825M.findViewById(R.id.user_Pno);
        this.f5849p = (TextView) this.f5825M.findViewById(R.id.textPersonalMsg);
        this.f5819G = (LinearLayout) this.f5825M.findViewById(R.id.linear_status_message);
        this.f5850q = (TextView) this.f5825M.findViewById(R.id.textPersonalName);
        this.f5851r = (TextView) this.f5825M.findViewById(R.id.dateDisplay);
        this.f5852s = (HorizontalListView) this.f5825M.findViewById(R.id.interaction_horizontal_listview);
        this.f5852s.setOnItemClickListener(this.f5836c);
        this.f5854u = new ArrayList();
        this.f5853t = new C1714x(this, getActivity(), this.f5854u);
        this.f5852s.setAdapter((ListAdapter) this.f5853t);
        this.f5856w = (ImageButton) this.f5825M.findViewById(R.id.userprofile_detail);
        this.f5857x = (ImageView) this.f5825M.findViewById(R.id.userprofile_interaction_rank);
        this.f5858y = (LinearLayout) this.f5825M.findViewById(R.id.layout3);
        this.f5855v = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_userprofile_updating);
        this.f5832T = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.wait_sending);
        this.f5822J = (ListView) viewInflate.findViewById(R.id.mypage_memo_list);
        registerForContextMenu(this.f5822J);
        this.f5823K.clear();
        this.f5821I = new C0837a(this.f5822J, this.f5820H, this.f5823K, R.layout.memo_adapter_item);
        this.f5822J.addHeaderView(this.f5825M, null, false);
        this.f5822J.addFooterView(this.f5826N);
        this.f5822J.setAdapter((ListAdapter) this.f5821I);
        this.f5822J.setSelection(this.f5822J.getHeaderViewsCount());
        this.f5822J.setScrollbarFadingEnabled(true);
        this.f5822J.setOnScrollListener(this.f5837d);
        m5598g();
        m5602i();
        m5599h();
        m5594e();
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {all -> 0x0029, blocks: (B:6:0x000c, B:8:0x0012, B:9:0x001b, B:10:0x001e), top: B:20:0x000c }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5581a(android.database.Cursor r4) {
        /*
            r3 = this;
            java.util.ArrayList r0 = r3.f5854u
            r0.clear()
            r0 = 0
        L6:
            r1 = 30
            if (r0 >= r1) goto L30
            if (r4 == 0) goto L1e
            boolean r1 = r4.moveToPosition(r0)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L1e
            java.util.ArrayList r1 = r3.f5854u     // Catch: java.lang.Throwable -> L29
            com.sec.chaton.buddy.a.c r2 = r3.m5585b(r4)     // Catch: java.lang.Throwable -> L29
            r1.add(r2)     // Catch: java.lang.Throwable -> L29
        L1b:
            int r0 = r0 + 1
            goto L6
        L1e:
            java.util.ArrayList r1 = r3.f5854u     // Catch: java.lang.Throwable -> L29
            com.sec.chaton.buddy.a.c r2 = new com.sec.chaton.buddy.a.c     // Catch: java.lang.Throwable -> L29
            r2.<init>()     // Catch: java.lang.Throwable -> L29
            r1.add(r2)     // Catch: java.lang.Throwable -> L29
            goto L1b
        L29:
            r0 = move-exception
            if (r4 == 0) goto L2f
            r4.close()
        L2f:
            throw r0
        L30:
            if (r4 == 0) goto L35
            r4.close()
        L35:
            com.sec.chaton.userprofile.x r0 = r3.f5853t
            r0.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.userprofile.MyPageFragment.m5581a(android.database.Cursor):void");
    }

    /* renamed from: e */
    private void m5594e() {
        if (this.f5852s != null && this.f5852s.getVisibility() == 0) {
            this.f5846m.startQuery(-1, null, C0703r.m3166a(), null, "relation_date = ? AND buddy_relation_hide = 'N'  AND relation_rank != 0 ", new String[]{new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()))}, "relation_rank ASC LIMIT 30");
        }
    }

    /* renamed from: f */
    private void m5596f() {
        this.f5831S = true;
        this.f5824L.m2897a(this.f5859z);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m5592d();
        m5598g();
        if (this.f5815C) {
            m5602i();
            m5594e();
            m5596f();
            this.f5815C = false;
        }
    }

    /* renamed from: g */
    private void m5598g() throws Resources.NotFoundException {
        this.f5848o.setText("+" + this.f5859z);
        this.f5850q.setText(this.f5813A);
        this.f5849p.setText(this.f5814B);
        if (this.f5814B.length() != 0) {
            this.f5849p.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f5849p.setPadding(11, 10, 11, 10);
        } else {
            this.f5849p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mypage_status_input_background_xml, 0, 0, 0);
        }
        m5582a(this.f5851r);
    }

    /* renamed from: h */
    private void m5599h() {
        this.f5847n.setOnClickListener(new ViewOnClickListenerC1706p(this));
        this.f5819G.setOnClickListener(new ViewOnClickListenerC1707q(this));
        this.f5856w.setOnClickListener(new ViewOnClickListenerC1708r(this));
        this.f5857x.setOnClickListener(new ViewOnClickListenerC1709s(this));
        this.f5858y.setOnClickListener(new ViewOnClickListenerC1710t(this));
    }

    /* renamed from: a */
    public static void m5582a(TextView textView) throws Resources.NotFoundException {
        String string = C1789u.m6075a().getString("birthday_type", "");
        String string2 = GlobalApplication.m3260b().getResources().getString(R.string.add_your_birthday);
        String string3 = C1789u.m6075a().getString("birthday", string2);
        if (string.equals("FULL")) {
            textView.setText(m5579a(string3));
            return;
        }
        if (string.equals("SHORT")) {
            String[] strArrSplit = string3.split("-");
            textView.setText(m5579a(strArrSplit[1] + "-" + strArrSplit[2]));
            return;
        }
        if (string3.equals(string2)) {
            textView.setText(R.string.add_your_birthday);
            return;
        }
        if (string3 != null && !"".equals(string3)) {
            if (!string3.startsWith("0000")) {
                if (C1789u.m6075a().getBoolean("birthday_year_show", false)) {
                    textView.setText(m5579a(string3));
                    return;
                } else {
                    String[] strArrSplit2 = string3.split("-");
                    textView.setText(m5579a(strArrSplit2[1] + "-" + strArrSplit2[2]));
                    return;
                }
            }
            textView.setText(R.string.add_your_birthday);
            return;
        }
        textView.setText(R.string.add_your_birthday);
    }

    /* renamed from: a */
    public static String m5579a(String str) throws NumberFormatException {
        String strReplaceAll;
        int i;
        int i2;
        int i3;
        C1786r.m6066e("original birthday str:" + str, f5812a);
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.contains(" ") && (str.contains("-") || str.contains("/") || str.contains(".") || str.contains(","))) {
            strReplaceAll = str.replaceAll("\\s", "");
            C1786r.m6066e("trimmed birthday str:" + strReplaceAll, f5812a);
        } else {
            strReplaceAll = str;
        }
        String[] strArrSplit = strReplaceAll.split("-|\\/|\\s|\\.|\\,");
        if (strReplaceAll.length() == 10) {
            i = Integer.parseInt(strArrSplit[0]) - 1900;
            i2 = Integer.parseInt(strArrSplit[1]) - 1;
            i3 = Integer.parseInt(strArrSplit[2]);
        } else {
            i = 100;
            i2 = Integer.parseInt(strArrSplit[0]) - 1;
            i3 = Integer.parseInt(strArrSplit[1]);
        }
        try {
            String string = DateFormat.getDateFormat(GlobalApplication.m3260b()).format(new Date(i, i2, i3)).toString();
            if (str.length() != 10) {
                if (string.contains(" ") && (string.contains("-") || string.contains("/") || string.contains(".") || string.contains(","))) {
                    string = string.replaceAll("\\s", "");
                }
                String[] strArrSplit2 = string.split("-|\\/|\\s|\\.|\\,");
                if (strArrSplit2[0].length() == 4) {
                    return string.substring(5);
                }
                if (strArrSplit2[2].length() == 4) {
                    return string.substring(0, strArrSplit2[1].length() + strArrSplit2[0].length() + 1);
                }
                return string;
            }
            return string;
        } catch (Exception e) {
            C1786r.m6061b("change date format error", f5812a);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5602i() {
        C1786r.m6066e("UserProfile initialize() - img status: " + C1789u.m6075a().getString("profile_image_status", ""), f5812a);
        if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
            File file = new File(this.f5844k, "myprofile.png_");
            if (file.exists()) {
                new AsyncTaskC1711u(this, file).execute(new Void[0]);
                return;
            } else {
                m5604j();
                return;
            }
        }
        m5604j();
    }

    /* renamed from: c */
    public void m5615c() throws IOException {
        int i;
        try {
            if (!this.f5844k.canRead()) {
                this.f5844k.mkdirs();
            }
            this.f5818F = new File(this.f5844k + "/", "tmp_myprofile.png_");
            this.f5818F.createNewFile();
            this.f5817E = Uri.fromFile(this.f5818F);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1).show();
                return;
            }
            if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
                i = R.array.selphoto;
            } else {
                i = R.array.selphoto_first;
            }
            new AlertDialog.Builder(getActivity()).setTitle(R.string.select_photo).setItems(i, new DialogInterfaceOnClickListenerC1712v(this)).create().show();
        } catch (IOException e) {
            C1786r.m6056a(e, f5812a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (intent == null) {
                    C1786r.m6061b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    try {
                        C1791w.m6092a(C1791w.m6093a(Bitmap.createScaledBitmap(C1791w.m6100b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true)), "/profile/", "tmp_myprofile.png_");
                        this.f5815C = true;
                        if (!this.f5816D) {
                            this.f5845l.m2964a(this.f5844k + "/tmp_myprofile.png_");
                            this.f5855v.show();
                        } else if (this.f5818F.length() > 1000000) {
                            File fileM6094a = C1791w.m6094a(getActivity(), this.f5818F);
                            if (fileM6094a != null) {
                                this.f5845l.m2964a(fileM6094a.getPath());
                                this.f5855v.show();
                            }
                        } else {
                            this.f5845l.m2964a(this.f5818F.getPath());
                            this.f5855v.show();
                        }
                        break;
                    } catch (Exception e) {
                        C1786r.m6056a(e, getClass().getSimpleName());
                        m5604j();
                        return;
                    }
                }
            case 5:
                if (intent == null) {
                    C1786r.m6061b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f5817E = intent.getData();
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f5817E, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
            case 6:
                Intent intent3 = new Intent(this.f5820H, (Class<?>) ImageModify.class);
                intent3.setDataAndType(this.f5817E, "image/*");
                intent3.putExtra("outputX", 600);
                intent3.putExtra("outputY", 600);
                intent3.putExtra("aspectX", 1);
                intent3.putExtra("aspectY", 1);
                intent3.putExtra("return-data", true);
                startActivityForResult(intent3, 3);
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
        if (C1789u.m6075a().contains("UpdateIsCritical")) {
            menu.addSubMenu(0, 1, 0, getResources().getString(R.string.setting_settings_title)).setIcon(R.drawable.settings_new);
        } else {
            menu.addSubMenu(0, 1, 0, getResources().getString(R.string.setting_settings_title)).setIcon(R.drawable.ic_menu_settings);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f5815C = true;
                startActivity(new Intent(getActivity(), (Class<?>) (GlobalApplication.m3265f() ? SettingActivity.class : ActivitySettings.class)));
            default:
                return true;
        }
    }

    /* renamed from: b */
    private C0257c m5585b(Cursor cursor) {
        return new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
    }

    /* renamed from: j */
    private void m5604j() {
        try {
            this.f5847n.setImageBitmap(C1746bb.m5940a(this.f5820H, R.drawable.co_default_image_add));
            C1746bb.m5945a(GlobalApplication.m3260b()).m5961a(this.f5859z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        C0839c c0839c = (C0839c) this.f5822J.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (c0839c != null) {
            String strM3495a = c0839c.m3495a();
            String strM3498d = c0839c.m3498d();
            contextMenu.setHeaderTitle(R.string.mypage_buddies_say);
            contextMenu.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1704n(this, strM3495a, strM3498d));
        }
    }
}
