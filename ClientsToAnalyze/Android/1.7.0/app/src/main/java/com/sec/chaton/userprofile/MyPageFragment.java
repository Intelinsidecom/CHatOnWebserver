package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.InterfaceC0726l;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.C0729b;
import com.sec.chaton.memo.C0734g;
import com.sec.chaton.p013a.C0224w;
import com.sec.chaton.p013a.C0226y;
import com.sec.chaton.p025d.C0658k;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.trunk.p045d.C1169g;
import com.sec.chaton.util.C1301ax;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.C1356c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.HorizontalListView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class MyPageFragment extends Fragment implements InterfaceC0726l {

    /* renamed from: a */
    public static final String f4102a = MyPageFragment.class.getSimpleName();

    /* renamed from: A */
    private C1270t f4103A;

    /* renamed from: B */
    private ArrayList f4104B;

    /* renamed from: C */
    private ProgressDialog f4105C;

    /* renamed from: D */
    private ImageButton f4106D;

    /* renamed from: E */
    private LinearLayout f4107E;

    /* renamed from: F */
    private LinearLayout f4108F;

    /* renamed from: G */
    private LinearLayout f4109G;

    /* renamed from: H */
    private String f4110H;

    /* renamed from: I */
    private String f4111I;

    /* renamed from: J */
    private String f4112J;

    /* renamed from: M */
    private Uri f4115M;

    /* renamed from: N */
    private Context f4116N;

    /* renamed from: O */
    private C0729b f4117O;

    /* renamed from: P */
    private ListView f4118P;

    /* renamed from: R */
    private C0224w f4120R;

    /* renamed from: S */
    private View f4121S;

    /* renamed from: T */
    private View f4122T;

    /* renamed from: U */
    private View f4123U;

    /* renamed from: V */
    private View f4124V;

    /* renamed from: W */
    private View f4125W;

    /* renamed from: X */
    private View f4126X;

    /* renamed from: Y */
    private LinearLayout f4127Y;

    /* renamed from: Z */
    private LinearLayout f4128Z;

    /* renamed from: aa */
    private String f4129aa;

    /* renamed from: ab */
    private String f4130ab;

    /* renamed from: ac */
    private boolean f4131ac;

    /* renamed from: ad */
    private ProgressDialog f4132ad;

    /* renamed from: ae */
    private Toast f4133ae;

    /* renamed from: af */
    private LinearLayout f4134af;

    /* renamed from: ag */
    private LinearLayout f4135ag;

    /* renamed from: ah */
    private LinearLayout f4136ah;

    /* renamed from: c */
    View f4141c;

    /* renamed from: p */
    private File f4154p;

    /* renamed from: r */
    private C0226y f4156r;

    /* renamed from: s */
    private C0630j f4157s;

    /* renamed from: t */
    private ImageButton f4158t;

    /* renamed from: u */
    private TextView f4159u;

    /* renamed from: v */
    private TextView f4160v;

    /* renamed from: w */
    private TextView f4161w;

    /* renamed from: x */
    private TextView f4162x;

    /* renamed from: y */
    private TextView f4163y;

    /* renamed from: z */
    private HorizontalListView f4164z;

    /* renamed from: f */
    private final int f4144f = 0;

    /* renamed from: g */
    private final int f4145g = 1;

    /* renamed from: h */
    private final int f4146h = 2;

    /* renamed from: i */
    private final int f4147i = 3;

    /* renamed from: j */
    private final int f4148j = 5;

    /* renamed from: k */
    private final int f4149k = 6;

    /* renamed from: b */
    final String f4140b = C1327bw.m4596b();

    /* renamed from: l */
    private File f4150l = new File(this.f4140b + "/profile/");

    /* renamed from: m */
    private File f4151m = GlobalApplication.m3100a().getFilesDir().getAbsoluteFile();

    /* renamed from: n */
    private boolean f4152n = false;

    /* renamed from: o */
    private boolean f4153o = false;

    /* renamed from: q */
    private String f4155q = "";

    /* renamed from: K */
    private boolean f4113K = false;

    /* renamed from: L */
    private boolean f4114L = true;

    /* renamed from: Q */
    private ArrayList f4119Q = new ArrayList();

    /* renamed from: ai */
    private ContentObserver f4137ai = new C1202a(this, new Handler());

    /* renamed from: d */
    AdapterView.OnItemClickListener f4142d = new C1255e(this);

    /* renamed from: aj */
    private InterfaceC0626f f4138aj = new C1229az(this);

    /* renamed from: ak */
    private Handler f4139ak = new HandlerC1225av(this);

    /* renamed from: e */
    AbsListView.OnScrollListener f4143e = new C1231ba(this);

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: a */
    public void mo2192a() {
        BaseActivity.m2041a(this, true);
        m4306g();
        m4308h();
        getActivity().getContentResolver().registerContentObserver(C0658k.f2285a, true, this.f4137ai);
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: b */
    public void mo2200b() {
        BaseActivity.m2041a(this, false);
        getActivity().getContentResolver().unregisterContentObserver(this.f4137ai);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4116N = GlobalApplication.m3100a();
        m4304f();
        this.f4129aa = "";
        this.f4130ab = "";
        this.f4131ac = true;
    }

    /* renamed from: f */
    private void m4304f() {
        this.f4156r = new C0226y(this.f4139ak);
        this.f4120R = new C0224w(this.f4139ak);
        this.f4157s = new C0630j(getActivity().getContentResolver(), this.f4138aj);
        this.f4110H = C1323bs.m4575a().getString("msisdn", "");
        this.f4111I = C1323bs.m4575a().getString("Push Name", "");
        this.f4112J = C1323bs.m4575a().getString("status_message", "");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_user_profile, viewGroup, false);
        this.f4121S = layoutInflater.inflate(R.layout.user_porfile_fragment_header2, (ViewGroup) null);
        this.f4123U = layoutInflater.inflate(R.layout.user_profile_fragment_header3, (ViewGroup) null);
        this.f4124V = layoutInflater.inflate(R.layout.user_profile_fragment_header4, (ViewGroup) null);
        this.f4125W = layoutInflater.inflate(R.layout.user_profile_fragment_header5, (ViewGroup) null);
        this.f4126X = layoutInflater.inflate(R.layout.user_profile_fragment_header6, (ViewGroup) null);
        this.f4122T = layoutInflater.inflate(R.layout.memo_refresh_footer, (ViewGroup) null);
        this.f4127Y = (LinearLayout) this.f4122T.findViewById(R.id.footer_progress);
        this.f4128Z = (LinearLayout) this.f4122T.findViewById(R.id.footer_memo_content_layout);
        this.f4158t = (ImageButton) this.f4121S.findViewById(R.id.imgbtnUPPhoto);
        this.f4159u = (TextView) this.f4124V.findViewById(R.id.user_Pno);
        this.f4160v = (TextView) this.f4123U.findViewById(R.id.textPersonalMsg);
        this.f4161w = (TextView) this.f4121S.findViewById(R.id.textPersonalName);
        this.f4136ah = (LinearLayout) this.f4126X.findViewById(R.id.interaction_title);
        this.f4162x = (TextView) this.f4125W.findViewById(R.id.dateDisplay);
        this.f4163y = (TextView) this.f4126X.findViewById(R.id.no_interactions);
        this.f4164z = (HorizontalListView) this.f4126X.findViewById(R.id.interaction_horizontal_listview);
        this.f4164z.setOnItemClickListener(this.f4142d);
        this.f4104B = new ArrayList();
        this.f4103A = new C1270t(this, getActivity(), this.f4104B);
        this.f4164z.setAdapter((ListAdapter) this.f4103A);
        this.f4106D = (ImageButton) this.f4121S.findViewById(R.id.userprofile_detail);
        this.f4107E = (LinearLayout) this.f4121S.findViewById(R.id.layout3);
        this.f4108F = (LinearLayout) this.f4124V.findViewById(R.id.user_profile_phone);
        this.f4109G = (LinearLayout) this.f4125W.findViewById(R.id.user_profile_birthday);
        this.f4134af = (LinearLayout) this.f4126X.findViewById(R.id.interaction_rank_subtitle);
        this.f4135ag = (LinearLayout) this.f4126X.findViewById(R.id.buddies_say_subtitle);
        this.f4105C = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.dialog_userprofile_updating);
        this.f4132ad = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.wait_sending);
        this.f4118P = (ListView) viewInflate.findViewById(R.id.mypage_memo_list);
        registerForContextMenu(this.f4118P);
        this.f4119Q.clear();
        this.f4117O = new C0729b(this.f4118P, this.f4116N, this.f4119Q, R.layout.memo_adapter_item);
        this.f4118P.addHeaderView(this.f4121S, null, true);
        this.f4118P.addHeaderView(this.f4123U, null, true);
        this.f4118P.addHeaderView(this.f4124V, null, true);
        this.f4118P.addHeaderView(this.f4125W, null, true);
        this.f4118P.addHeaderView(this.f4126X, null, true);
        this.f4118P.addFooterView(this.f4122T);
        this.f4118P.setAdapter((ListAdapter) this.f4117O);
        this.f4118P.setSelection(this.f4118P.getHeaderViewsCount());
        this.f4118P.setScrollbarFadingEnabled(true);
        this.f4118P.setOnScrollListener(this.f4143e);
        m4310i();
        m4314k();
        m4312j();
        m4306g();
        this.f4118P.setOnItemSelectedListener(new C1253c(this));
        this.f4118P.setOnKeyListener(new ViewOnKeyListenerC1230b(this));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4290a(Cursor cursor) {
        this.f4104B.clear();
        for (int i = 0; i < 30 && cursor != null; i++) {
            try {
                if (!cursor.moveToPosition(i)) {
                    break;
                }
                this.f4104B.add(m4296b(cursor));
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (this.f4104B.size() > 0) {
            this.f4163y.setVisibility(8);
            this.f4164z.setVisibility(0);
        } else {
            this.f4163y.setVisibility(0);
            this.f4164z.setVisibility(8);
        }
        this.f4103A.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4306g() {
        new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        this.f4157s.startQuery(-1, null, C0658k.m2990a(), null, "relation_date = ? AND buddy_relation_hide = 'N'  AND relation_rank != 0 ", new String[]{Integer.toString(1)}, "relation_rank ASC LIMIT 30");
    }

    /* renamed from: h */
    private void m4308h() {
        this.f4128Z.setVisibility(8);
        this.f4127Y.setVisibility(0);
        this.f4131ac = true;
        this.f4120R.m864a(this.f4110H);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4304f();
        m4310i();
        if (this.f4113K) {
            m4314k();
            m4306g();
            m4308h();
            this.f4113K = false;
        }
    }

    /* renamed from: i */
    private void m4310i() {
        this.f4159u.setText("+" + this.f4110H);
        this.f4161w.setText(this.f4111I);
        this.f4160v.setText(this.f4112J);
        if (C1323bs.m4575a().getBoolean("show_phone_number_to_all", false)) {
            this.f4159u.setTextColor(getResources().getColor(R.color.buddy_profile_item));
        } else {
            this.f4159u.setTextColor(getResources().getColor(R.color.gray2));
        }
        if (this.f4112J.length() != 0) {
            this.f4160v.setBackgroundResource(R.drawable.input_filed_empty);
            this.f4160v.setPadding((int) C1301ax.m4544a(11.0f), (int) C1301ax.m4544a(13.0f), (int) C1301ax.m4544a(11.0f), (int) C1301ax.m4544a(13.0f));
        } else {
            this.f4160v.setBackgroundResource(R.drawable.edit_chat_selector);
            this.f4160v.setPadding((int) C1301ax.m4544a(11.0f), (int) C1301ax.m4544a(13.0f), (int) C1301ax.m4544a(11.0f), (int) C1301ax.m4544a(13.0f));
        }
        if (this.f4160v.getLineCount() == 3) {
        }
        m4291a(this.f4162x);
    }

    /* renamed from: j */
    private void m4312j() {
        this.f4158t.setOnClickListener(new ViewOnClickListenerC1254d(this));
        this.f4160v.setOnClickListener(new ViewOnClickListenerC1257g(this));
        this.f4136ah.setOnClickListener(new ViewOnClickListenerC1256f(this));
        this.f4107E.setOnClickListener(new ViewOnClickListenerC1259i(this));
        this.f4106D.setOnClickListener(new ViewOnClickListenerC1258h(this));
        this.f4108F.setOnClickListener(new ViewOnClickListenerC1237bg(this));
        this.f4108F.setOnTouchListener(new ViewOnTouchListenerC1236bf(this));
        this.f4109G.setOnClickListener(new ViewOnClickListenerC1235be(this));
        this.f4109G.setOnTouchListener(new ViewOnTouchListenerC1234bd(this));
        this.f4136ah.setOnTouchListener(new ViewOnTouchListenerC1233bc(this));
        this.f4135ag.setOnTouchListener(new ViewOnTouchListenerC1226aw(this));
    }

    /* renamed from: a */
    public static void m4291a(TextView textView) {
        String string = C1323bs.m4575a().getString("birthday_type", "");
        String string2 = C1323bs.m4575a().getString("birthday", GlobalApplication.m3100a().getResources().getString(R.string.add_your_birthday));
        if (string.equals("FULL")) {
            textView.setText(m4289a(string2));
            return;
        }
        if (string.equals("SHORT")) {
            String[] strArrSplit = string2.split("-");
            textView.setText(m4289a(strArrSplit[1] + "-" + strArrSplit[2]));
        } else if (string2.equals(GlobalApplication.m3100a().getResources().getString(R.string.add_your_birthday))) {
            textView.setText(GlobalApplication.m3100a().getResources().getString(R.string.add_your_birthday));
        } else {
            textView.setText(GlobalApplication.m3100a().getResources().getString(R.string.add_your_birthday));
        }
    }

    /* renamed from: a */
    public static String m4289a(String str) throws NumberFormatException {
        String strReplaceAll;
        int i;
        int i2;
        int i3;
        C1341p.m4662e("original birthday str:" + str, f4102a);
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.contains(" ") && (str.contains("-") || str.contains("/") || str.contains(".") || str.contains(","))) {
            strReplaceAll = str.replaceAll("\\s", "");
            C1341p.m4662e("trimmed birthday str:" + strReplaceAll, f4102a);
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
            String string = DateFormat.getDateFormat(GlobalApplication.m3100a()).format(new Date(i, i2, i3)).toString();
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
            C1341p.m4658b("change date format error", f4102a);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m4314k() {
        C1341p.m4662e("UserProfile initialize() - img status: " + C1323bs.m4575a().getString("profile_image_status", ""), f4102a);
        if (C1323bs.m4575a().getString("profile_image_status", "").equals("updated")) {
            File file = new File(this.f4151m, "myprofile.png_");
            C1341p.m4658b("photoFile=" + file, getClass().getSimpleName());
            if (file.exists()) {
                new AsyncTaskC1227ax(this, file).execute(new Void[0]);
                return;
            } else {
                m4316l();
                return;
            }
        }
        m4316l();
    }

    /* renamed from: c */
    public void m4332c() throws IOException {
        int i;
        try {
            if (!this.f4150l.canRead()) {
                this.f4150l.mkdirs();
            }
            m4318m();
            this.f4155q = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f4154p = new File(this.f4150l + "/", this.f4155q);
            C1341p.m4658b("[Create File] " + this.f4150l.toString() + this.f4155q + " : " + this.f4154p.createNewFile(), f4102a);
            this.f4115M = Uri.fromFile(this.f4154p);
            if (!C1327bw.m4595a()) {
                if (this.f4133ae == null) {
                    this.f4133ae = C1619g.m5889a(getActivity(), getString(R.string.toast_sdcard_amount), 1);
                }
                this.f4133ae.show();
            } else {
                if (C1323bs.m4575a().getString("profile_image_status", "").equals("updated")) {
                    i = R.array.selphoto;
                } else {
                    i = R.array.selphoto_first;
                }
                new AlertDialogBuilderC1625m(getActivity()).setTitle(R.string.select_photo).setItems(i, new DialogInterfaceOnClickListenerC1228ay(this)).create().show();
            }
        } catch (IOException e) {
            C1341p.m4653a(e, f4102a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                    if (file.length() <= 0) {
                        C1341p.m4651a("Crop return null!", f4102a);
                        break;
                    } else {
                        try {
                            C1169g.m4215a(file, this.f4154p);
                            this.f4113K = true;
                            this.f4156r.m874a(this.f4154p.getPath());
                            this.f4105C.show();
                            break;
                        } catch (Exception e) {
                            C1341p.m4653a(e, getClass().getSimpleName());
                            m4316l();
                            return;
                        }
                    }
                }
                break;
            case 5:
                if (intent == null) {
                    C1341p.m4658b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f4115M = intent.getData();
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f4115M, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
            case 6:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f4116N, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f4115M, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 3);
                    break;
                } else {
                    C1341p.m4658b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f4113K = true;
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
            default:
                return true;
        }
    }

    /* renamed from: b */
    private C0363a m4296b(Cursor cursor) {
        return new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
    }

    /* renamed from: l */
    private void m4316l() {
        try {
            this.f4158t.setImageBitmap(C1348w.m4680a(this.f4116N, R.drawable.propile_default_image));
            C1348w.m4685a(GlobalApplication.m3100a()).m4701a(this.f4110H);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        C0734g c0734g = (C0734g) this.f4118P.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (c0734g != null) {
            String strM3138a = c0734g.m3138a();
            String strM3141d = c0734g.m3141d();
            contextMenu.setHeaderTitle(c0734g.m3139b());
            contextMenu.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1232bb(this, strM3138a, strM3141d));
        }
    }

    /* renamed from: m */
    private void m4318m() {
        if (!m4333d() || !m4334e()) {
            C1341p.m4651a("[deleteTempFolder] External Storage Is Not Available or Writable!", f4102a);
            if (this.f4133ae == null) {
                this.f4133ae = C1619g.m5889a(getActivity(), getString(R.string.toast_sdcard_amount), 1);
            }
            this.f4133ae.show();
            return;
        }
        String strM4596b = C1327bw.m4596b();
        if (strM4596b.length() == 0) {
            this.f4133ae.show();
            return;
        }
        try {
            String[] list = new File(strM4596b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C1341p.m4658b("[Delete File] " + strM4596b + "/profile/" + str + " : " + new File(strM4596b + "/profile/" + str).delete(), f4102a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    protected boolean m4333d() {
        m4320n();
        return this.f4152n;
    }

    /* renamed from: e */
    protected boolean m4334e() {
        m4320n();
        return this.f4153o;
    }

    /* renamed from: n */
    private void m4320n() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f4152n = true;
            this.f4153o = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f4152n = true;
            this.f4153o = false;
        } else {
            this.f4152n = false;
            this.f4153o = false;
        }
    }
}
