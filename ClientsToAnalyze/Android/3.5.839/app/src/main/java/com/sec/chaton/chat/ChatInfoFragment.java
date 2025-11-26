package com.sec.chaton.chat;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0991aa;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.C2660e;
import com.sec.chaton.msgbox.C2679x;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2297q;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4875cm;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5051q;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import com.sec.widget.FastScrollableExpandableListView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class ChatInfoFragment extends Fragment implements View.OnClickListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, InterfaceC1691er, InterfaceC1752gy {

    /* renamed from: a */
    public static final String f5755a = ChatInfoActivity.class.getSimpleName();

    /* renamed from: A */
    private C2210x f5756A;

    /* renamed from: B */
    private Toast f5757B;

    /* renamed from: C */
    private String f5758C;

    /* renamed from: D */
    private String f5759D;

    /* renamed from: E */
    private String f5760E;

    /* renamed from: G */
    private String f5762G;

    /* renamed from: H */
    private String f5763H;

    /* renamed from: J */
    private File f5765J;

    /* renamed from: N */
    private Uri f5769N;

    /* renamed from: O */
    private Toast f5770O;

    /* renamed from: Q */
    private ProgressDialog f5772Q;

    /* renamed from: R */
    private String f5773R;

    /* renamed from: S */
    private String f5774S;

    /* renamed from: T */
    private C5007c f5775T;

    /* renamed from: U */
    private EnumC2301u f5776U;

    /* renamed from: W */
    private String f5778W;

    /* renamed from: X */
    private String f5779X;

    /* renamed from: Y */
    private C2660e f5780Y;

    /* renamed from: aa */
    private TextView f5782aa;

    /* renamed from: af */
    private C1711fk f5787af;

    /* renamed from: e */
    private TextView f5794e;

    /* renamed from: f */
    private String f5795f;

    /* renamed from: g */
    private String f5796g;

    /* renamed from: h */
    private Context f5797h;

    /* renamed from: i */
    private InterfaceC1752gy f5798i;

    /* renamed from: j */
    private String f5799j;

    /* renamed from: k */
    private int f5800k;

    /* renamed from: l */
    private ArrayList<String> f5801l;

    /* renamed from: m */
    private ArrayList<String> f5802m;

    /* renamed from: n */
    private LinearLayout f5803n;

    /* renamed from: o */
    private ViewGroup f5804o;

    /* renamed from: p */
    private ViewGroup f5805p;

    /* renamed from: q */
    private CheckBox f5806q;

    /* renamed from: r */
    private Button f5807r;

    /* renamed from: s */
    private Button f5808s;

    /* renamed from: t */
    private ImageView f5809t;

    /* renamed from: u */
    private ImageButton f5810u;

    /* renamed from: v */
    private LinearLayout f5811v;

    /* renamed from: w */
    private TextView f5812w;

    /* renamed from: x */
    private FastScrollableExpandableListView f5813x;

    /* renamed from: z */
    private C1688eo f5815z;

    /* renamed from: y */
    private View f5814y = null;

    /* renamed from: F */
    private boolean f5761F = true;

    /* renamed from: b */
    String f5791b = C4873ck.m18501b();

    /* renamed from: I */
    private File f5764I = new File(this.f5791b + "/profile/");

    /* renamed from: K */
    private String f5766K = "";

    /* renamed from: L */
    private boolean f5767L = false;

    /* renamed from: M */
    private boolean f5768M = false;

    /* renamed from: P */
    private boolean f5771P = false;

    /* renamed from: V */
    private int f5777V = 11;

    /* renamed from: Z */
    private boolean f5781Z = true;

    /* renamed from: ab */
    private String f5783ab = null;

    /* renamed from: ac */
    private String f5784ac = null;

    /* renamed from: ad */
    private String f5785ad = null;

    /* renamed from: ae */
    private int f5786ae = 0;

    /* renamed from: ag */
    private boolean f5788ag = false;

    /* renamed from: ah */
    private Handler f5789ah = new HandlerC1701fa(this);

    /* renamed from: c */
    File f5792c = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile();

    /* renamed from: ai */
    private Handler f5790ai = new HandlerC1704fd(this);

    /* renamed from: d */
    InterfaceC2211y f5793d = new C1708fh(this);

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C4875cm.m18511a(getActivity());
    }

    @Override // com.sec.chaton.chat.InterfaceC1752gy
    /* renamed from: a */
    public void mo8326a(String str) {
        m8330b(str);
    }

    @Override // com.sec.chaton.chat.InterfaceC1691er
    /* renamed from: a */
    public void mo8327a(String str, String str2) {
        if (this.f5772Q != null) {
            this.f5772Q.show();
        }
        C2128i c2128i = new C2128i(this.f5790ai);
        this.f5779X = str;
        this.f5778W = str2;
        if (this.f5776U == EnumC2301u.NORMAL) {
            c2128i.m9508b(str);
        } else {
            c2128i.m9511b(str, true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C1696ew c1696ew = null;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            m8286a(arguments);
        }
        if (EnumC2300t.m10207a(this.f5800k) != EnumC2300t.TOPIC) {
            this.f5801l = new ArrayList<>();
            this.f5802m = new ArrayList<>();
        }
        m8293b(bundle);
        this.f5797h = getActivity();
        this.f5798i = this;
        this.f5757B = C5179v.m19811a(this.f5797h, (CharSequence) null, 0);
        this.f5756A = new C2210x(getActivity().getContentResolver(), this.f5793d);
        if (EnumC2300t.m10208a(EnumC2300t.m10207a(this.f5800k))) {
            int iIndexOf = this.f5795f.indexOf(":");
            if (this.f5796g != null) {
                if (!this.f5796g.equals("Y") && iIndexOf > 0) {
                    this.f5795f = this.f5795f.substring(iIndexOf + 2);
                }
            } else if (iIndexOf > 0) {
                this.f5795f = this.f5795f.substring(iIndexOf + 2);
            }
        }
        if (this.f5772Q == null) {
            this.f5772Q = (ProgressDialog) new C4923p(this.f5797h).m18724a(R.string.dialog_userprofile_updating);
        }
        this.f5775T = new C5007c();
        BaseActivity.m6160a((Fragment) this, true);
        if (this.f5777V == 10) {
            C2134o.m9571a(this.f5790ai, this.f5799j, this.f5773R, 0L, true);
        }
        this.f5780Y = new C2660e(this.f5797h, this.f5799j, 6);
        this.f5787af = new C1711fk(this, c1696ew);
        C0991aa.m6037a().m18959a(this.f5787af);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        View viewInflate = layoutInflater.inflate(R.layout.chat_info, viewGroup, false);
        this.f5813x = (FastScrollableExpandableListView) viewInflate.findViewById(R.id.listview);
        this.f5813x.setOnGroupClickListener(this);
        this.f5813x.setOnGroupCollapseListener(this);
        this.f5813x.setOnGroupExpandListener(this);
        this.f5813x.setOnChildClickListener(this);
        this.f5813x.setChoiceMode(0);
        this.f5813x.setOnScrollListener(new C1696ew(this));
        this.f5814y = LayoutInflater.from(getActivity()).inflate(R.layout.chat_info_header, (ViewGroup) this.f5813x, false);
        this.f5810u = (ImageButton) this.f5814y.findViewById(R.id.btn_edit);
        this.f5810u.setOnClickListener(this);
        if (this.f5776U != EnumC2301u.LIVE && EnumC2300t.m10207a(this.f5800k) != EnumC2300t.TOPIC) {
            this.f5810u.setVisibility(0);
        }
        this.f5809t = (ImageView) this.f5814y.findViewById(R.id.profile_image);
        if (EnumC2300t.m10207a(this.f5800k) != EnumC2300t.TOPIC) {
            this.f5809t.setOnClickListener(this);
        }
        m8325a();
        this.f5794e = (TextView) this.f5814y.findViewById(R.id.title_name);
        this.f5794e.setText(this.f5795f);
        this.f5804o = (ViewGroup) this.f5814y.findViewById(R.id.alert_space);
        this.f5805p = (ViewGroup) this.f5814y.findViewById(R.id.alert_layout);
        this.f5806q = (CheckBox) this.f5805p.findViewById(R.id.checkbox);
        this.f5803n = (LinearLayout) this.f5814y.findViewById(R.id.layoutCenterButton);
        this.f5804o.setVisibility(0);
        this.f5806q.setChecked(this.f5761F);
        this.f5806q.setOnCheckedChangeListener(new C1698ey(this));
        this.f5806q.setOnClickListener(new ViewOnClickListenerC1699ez(this));
        if (EnumC2300t.m10208a(EnumC2300t.m10207a(this.f5800k)) || EnumC2300t.m10207a(this.f5800k) == EnumC2300t.MONOLOGUE) {
            this.f5804o.setVisibility(8);
        } else {
            this.f5804o.setVisibility(0);
        }
        this.f5807r = (Button) this.f5814y.findViewById(R.id.invite_button);
        this.f5807r.setOnClickListener(this);
        this.f5808s = (Button) this.f5814y.findViewById(R.id.create_group_button);
        this.f5808s.setOnClickListener(this);
        if (EnumC2300t.m10207a(this.f5800k) == EnumC2300t.MONOLOGUE || EnumC2300t.m10207a(this.f5800k) == EnumC2300t.TOPIC) {
            this.f5803n.setVisibility(8);
        }
        ((LinearLayout) this.f5814y.findViewById(R.id.ChatInfoSubtitle)).setVisibility(8);
        this.f5813x.addHeaderView(this.f5814y);
        this.f5815z = new C1688eo(this.f5797h, null, null);
        this.f5815z.m8523a(this);
        this.f5813x.setAdapter(this.f5815z);
        this.f5813x.setItemsCanFocus(true);
        if (EnumC2300t.m10207a(this.f5800k) == EnumC2300t.TOPIC) {
            m8304h();
        } else {
            m8297e();
        }
        return viewInflate;
    }

    /* renamed from: e */
    private void m8297e() {
        this.f5782aa = new TextView(getActivity());
        this.f5782aa.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.f5782aa.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f5782aa.setGravity(17);
        this.f5782aa.setVisibility(0);
        this.f5782aa.setPadding(15, 5, 15, 5);
        this.f5782aa.setTextSize(1, 15.0f);
        this.f5782aa.setTextColor(CommonApplication.m18732r().getResources().getColor(R.color.translate_source_text));
        this.f5782aa.setText(R.string.chat_info_invited_contact_buddy_description);
        m8288a(true);
    }

    /* renamed from: a */
    private void m8288a(boolean z) {
        if (this.f5782aa != null) {
            if (this.f5815z.getGroupCount() > 1 && z) {
                this.f5813x.addFooterView(this.f5782aa);
            } else {
                this.f5813x.removeFooterView(this.f5782aa);
            }
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C1692es c1692es = (C1692es) this.f5815z.getChild(i, i2);
        if (this.f5776U == EnumC2301u.NORMAL) {
            Intent intent = new Intent(this.f5797h, (Class<?>) BuddyDialog.class);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NO", c1692es.m8525a());
            intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", c1692es.m8526b());
            this.f5797h.startActivity(intent);
            return true;
        }
        Intent intent2 = new Intent(this.f5797h, (Class<?>) SpecialBuddyDialog.class);
        intent2.putExtra("specialuserid", c1692es.m8525a());
        if (!TextUtils.isEmpty(c1692es.m8526b())) {
            intent2.putExtra("speicalusername", c1692es.m8526b());
        }
        startActivity(intent2);
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i) {
        if (i == 1) {
            m8288a(true);
        }
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i) {
        if (i == 1) {
            m8288a(false);
        }
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return this.f5815z.getGroupCount() <= 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        String str;
        switch (view.getId()) {
            case R.id.profile_image /* 2131165297 */:
                m8329b();
                break;
            case R.id.btn_edit /* 2131165463 */:
                new AlertDialogC1747gt(this.f5798i, this.f5797h, this.f5795f, this.f5799j, this.f5773R).show();
                break;
            case R.id.invite_button /* 2131165472 */:
                if (!C4847bl.m18333a()) {
                    int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        C5179v.m19810a(this.f5797h, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else if (this.f5756A != null) {
                        Uri uriM10160a = C2289i.m10160a();
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(this.f5801l);
                        if (this.f5802m != null && this.f5802m.size() > 0) {
                            arrayList.addAll(this.f5802m);
                        }
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
                        this.f5756A.startQuery(70, null, uriM10160a, null, str + "buddy_contact_buddy = 0", null, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
                        break;
                    }
                }
                break;
            case R.id.create_group_button /* 2131165473 */:
                Intent intent = new Intent(this.f5797h, (Class<?>) ChatInfoMoreActivity.class);
                Bundle bundle = new Bundle(getArguments());
                bundle.putBoolean("ACTIVITY_PURPOSE_ARG", false);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f5801l);
                bundle.putStringArray(ChatFragment.f5465d, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8300f() {
        if (EnumC2300t.m10207a(this.f5800k) != EnumC2300t.TOPIC) {
            C4904y.m18639b("initListView()", f5755a);
            if (this.f5776U == EnumC2301u.NORMAL) {
                this.f5756A.startQuery(2, null, C2220ah.m10091c(), null, "participants_inbox_no=?", new String[]{this.f5799j}, "buddy_name COLLATE LOCALIZED ASC");
            } else {
                this.f5756A.startQuery(2, null, C2220ah.m10093d(), null, "participants_inbox_no=?", new String[]{this.f5799j}, null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f5788ag = false;
        if (EnumC2300t.m10207a(this.f5800k) == EnumC2300t.ONETOONE || EnumC2300t.m10207a(this.f5800k) == EnumC2300t.MONOLOGUE || EnumC2300t.m10207a(this.f5800k) == EnumC2300t.TOPIC) {
            this.f5808s.setVisibility(8);
            if (this.f5776U != EnumC2301u.NORMAL) {
                this.f5803n.setVisibility(8);
            }
        } else {
            this.f5756A.startQuery(1, null, C2297q.f8207a, null, "inbox_no=?", new String[]{this.f5799j}, null);
        }
        m8300f();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f5788ag = true;
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.add(0, 1, 1, getResources().getString(R.string.menu_chat_close)).setIcon(R.drawable.more_option_closechat_white);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(this.f5797h, R.string.popup_no_network_connection, 0).show();
                } else {
                    this.f5780Y.m11239a(new C2679x(this.f5799j, EnumC2300t.m10207a(this.f5800k), this.f5773R, this.f5776U, Boolean.valueOf(this.f5781Z)), this.f5789ah);
                }
                break;
            default:
                return true;
        }
    }

    /* renamed from: a */
    public void m8328a(boolean z, boolean z2, ArrayList<String> arrayList, boolean z3) {
        RunnableC1702fb runnableC1702fb = new RunnableC1702fb(this, z2, arrayList, z3);
        C2660e.m11192a(z, z3, runnableC1702fb, runnableC1702fb, this.f5797h, 6).show();
    }

    /* renamed from: a */
    public void m8325a() {
        if (EnumC2300t.m10207a(this.f5800k) == EnumC2300t.ONETOONE) {
            this.f5809t.setClickable(false);
            C2496n.m10765a(this.f5809t, this.f5762G, EnumC2498p.ROUND);
            this.f5809t.setBackgroundResource(R.drawable.circle_background);
        } else if (EnumC2300t.m10207a(this.f5800k) == EnumC2300t.MONOLOGUE) {
            this.f5809t.setClickable(false);
            C2496n.m10763a(this.f5809t, EnumC2498p.ROUND);
            this.f5809t.setBackgroundResource(R.drawable.circle_background);
        } else if (EnumC2300t.m10207a(this.f5800k) == EnumC2300t.GROUPCHAT || EnumC2300t.m10207a(this.f5800k) == EnumC2300t.BROADCAST2) {
            C2496n.m10766a(this.f5809t, this.f5799j, this.f5763H, EnumC2300t.m10207a(this.f5800k), EnumC2498p.ROUND);
            this.f5809t.setBackgroundResource(R.drawable.circle_background);
        } else {
            C2496n.m10766a(this.f5809t, this.f5799j, this.f5763H, EnumC2300t.m10207a(this.f5800k), EnumC2498p.ROUND);
            this.f5809t.setBackgroundResource(R.drawable.circle_background);
        }
    }

    /* renamed from: b */
    public void m8329b() throws IOException {
        int i;
        try {
            if (!this.f5764I.canRead()) {
                this.f5764I.mkdirs();
            }
            m8302g();
            this.f5766K = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f5765J = new File(this.f5764I + "/", this.f5766K);
            C4904y.m18639b("[Create File] " + this.f5764I.toString() + this.f5766K + " : " + this.f5765J.createNewFile(), f5755a);
            this.f5769N = Uri.fromFile(this.f5765J);
            if (!m8331c() || !m8332d()) {
                if (this.f5770O == null) {
                    this.f5770O = C5179v.m19811a(GlobalApplication.m18732r(), getString(R.string.toast_sdcard_amount), 1);
                }
                this.f5770O.show();
                return;
            }
            if (C4822an.m18251s()) {
                i = R.array.selphoto_first;
            } else {
                i = R.array.selphoto_first_nocamera_nodelete;
            }
            AbstractC4932a abstractC4932aMo18736a = AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.ams_add_frame_title).mo18736a(i, new DialogInterfaceOnClickListenerC1703fc(this));
            abstractC4932aMo18736a.mo18745a().show();
            if (this.f5771P) {
                abstractC4932aMo18736a.mo18745a().dismiss();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m8286a(Bundle bundle) {
        if (bundle.containsKey(ChatFragment.f5476l)) {
            this.f5761F = bundle.getBoolean(ChatFragment.f5476l);
        }
        this.f5758C = bundle.getString("inbox_background_style");
        this.f5759D = bundle.getString("inbox_send_bubble_style");
        this.f5760E = bundle.getString("inbox_receive_bubble_style");
        this.f5800k = bundle.getInt("chatType");
        this.f5795f = bundle.getString(ChatFragment.f5469e);
        this.f5796g = bundle.getString("inbox_title_fixed");
        this.f5799j = bundle.getString("inboxNO");
        this.f5762G = bundle.getString("buddyNO");
        if (bundle.containsKey("groupId")) {
            this.f5763H = bundle.getString("groupId");
        }
        if (bundle.containsKey(ChatFragment.f5465d)) {
            this.f5801l = bundle.getStringArrayList(ChatFragment.f5465d);
        }
        if (bundle.containsKey("contact_receivers_id")) {
            this.f5802m = bundle.getStringArrayList("contact_receivers_id");
        }
        if (bundle.containsKey("sessionID")) {
            this.f5773R = bundle.getString("sessionID");
        }
        if (bundle.containsKey("roomType")) {
            this.f5776U = EnumC2301u.m10211a(bundle.getInt("roomType"));
        }
        if (bundle.containsKey("inbox_last_chat_type")) {
            this.f5777V = bundle.getInt("inbox_last_chat_type");
        }
        if (bundle.containsKey("isMapping")) {
            this.f5781Z = bundle.getBoolean("isMapping");
        }
        if (bundle.containsKey("topicChatCtid")) {
            this.f5783ab = bundle.getString("topicChatCtid");
        }
        if (bundle.containsKey("topicChatChannelName")) {
            this.f5784ac = bundle.getString("topicChatChannelName");
        }
        if (bundle.containsKey("topicChatLiveId")) {
            this.f5785ad = bundle.getString("topicChatLiveId");
        }
        if (bundle.containsKey("inbox_participants")) {
            this.f5786ae = bundle.getInt("inbox_participants");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(ChatFragment.f5476l, this.f5761F);
        bundle.putInt("chatType", this.f5800k);
        bundle.putString(ChatFragment.f5469e, this.f5795f);
        bundle.putString("inbox_title_fixed", this.f5796g);
        bundle.putString("inboxNO", this.f5799j);
        bundle.putString("buddyNO", this.f5762G);
        bundle.putString("groupId", this.f5763H);
        bundle.putInt("inbox_participants", this.f5786ae);
        if (!TextUtils.isEmpty(this.f5783ab)) {
            bundle.putString("topicChatCtid", this.f5783ab);
        }
        if (!TextUtils.isEmpty(this.f5785ad)) {
            bundle.putString("topicChatLiveId", this.f5785ad);
        }
        if (!TextUtils.isEmpty(this.f5784ac)) {
            bundle.putString("topicChatChannelName", this.f5784ac);
        }
        if (this.f5801l != null) {
            bundle.putStringArrayList(ChatFragment.f5465d, this.f5801l);
        }
        if (this.f5802m != null) {
            bundle.putStringArrayList("contact_receivers_id", this.f5802m);
        }
        bundle.putString("inbox_session_id", this.f5773R);
        if (this.f5769N != null) {
            bundle.putString("captureUri", this.f5769N.toString());
        }
        bundle.putString("profileName", this.f5766K);
        bundle.putInt("roomType", this.f5776U.m10212a());
        bundle.putBoolean("isMapping", this.f5781Z);
    }

    /* renamed from: b */
    private void m8293b(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(ChatFragment.f5476l)) {
                this.f5761F = bundle.getBoolean(ChatFragment.f5476l);
            }
            if (bundle.containsKey("chatType")) {
                this.f5800k = bundle.getInt("chatType");
            }
            if (bundle.containsKey(ChatFragment.f5469e)) {
                this.f5795f = bundle.getString(ChatFragment.f5469e);
            }
            if (bundle.containsKey("inbox_title_fixed")) {
                this.f5796g = bundle.getString("inbox_title_fixed");
            }
            if (bundle.containsKey("inboxNO")) {
                this.f5799j = bundle.getString("inboxNO");
            }
            if (bundle.containsKey("buddyNO")) {
                this.f5762G = bundle.getString("buddyNO");
            }
            if (bundle.containsKey("groupId")) {
                this.f5763H = bundle.getString("groupId");
            }
            if (bundle.containsKey(ChatFragment.f5465d)) {
                this.f5801l = bundle.getStringArrayList(ChatFragment.f5465d);
            }
            if (bundle.containsKey("contact_receivers_id")) {
                this.f5802m = bundle.getStringArrayList("contact_receivers_id");
            }
            if (bundle.containsKey("inbox_session_id")) {
                this.f5773R = bundle.getString("inbox_session_id");
            }
            if (bundle.containsKey("captureUri")) {
                this.f5769N = Uri.parse(bundle.getString("captureUri"));
            }
            if (bundle.containsKey("profileName")) {
                this.f5766K = bundle.getString("profileName");
            }
            if (bundle.containsKey("roomType")) {
                this.f5776U = EnumC2301u.m10211a(bundle.getInt("roomType"));
            }
            if (bundle.containsKey("isMapping")) {
                this.f5781Z = bundle.getBoolean("isMapping");
            }
            if (bundle.containsKey("topicChatCtid")) {
                this.f5783ab = bundle.getString("topicChatCtid");
            }
            if (bundle.containsKey("topicChatChannelName")) {
                this.f5784ac = bundle.getString("topicChatChannelName");
            }
            if (bundle.containsKey("topicChatLiveId")) {
                this.f5785ad = bundle.getString("topicChatLiveId");
            }
            if (bundle.containsKey("inbox_participants")) {
                this.f5786ae = bundle.getInt("inbox_participants");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8285a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws ExecutionException, InterruptedException {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                    if (file.length() <= 0) {
                        C4904y.m18634a("Crop return null!", f5755a);
                        break;
                    } else {
                        if (this.f5765J == null) {
                            this.f5765J = new File(this.f5764I + "/", this.f5766K);
                        }
                        C4636a.m17602a(file, this.f5765J);
                        this.f5774S = this.f5765J.getName();
                        if (C4822an.m18255w() && (EnumC2300t.m10207a(this.f5800k) == EnumC2300t.GROUPCHAT || EnumC2300t.m10207a(this.f5800k) == EnumC2300t.BROADCAST2)) {
                            C2134o.m9569a(this.f5790ai, this.f5765J.getPath(), this.f5774S);
                            if (this.f5772Q != null) {
                                this.f5772Q.show();
                                break;
                            }
                        } else {
                            try {
                                C2496n.m10773b(GlobalApplication.m18732r(), this.f5799j, Bitmap.createScaledBitmap(C4812ad.m18157b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true)).get();
                                C2496n.m10766a(this.f5809t, this.f5799j, this.f5763H, EnumC2300t.m10207a(this.f5800k), EnumC2498p.ROUND);
                                this.f5809t.setBackgroundResource(R.drawable.circle_background);
                                break;
                            } catch (Exception e) {
                                C4904y.m18635a(e, getClass().getSimpleName());
                                return;
                            }
                        }
                    }
                }
                break;
            case 4:
                if (intent == null) {
                    C4904y.m18639b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f5769N = intent.getData();
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f5769N, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
            case 5:
                if (i2 == -1) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    String[] stringArrayExtra2 = intent.getStringArrayExtra("contact_receivers_id");
                    String[] stringArrayExtra3 = intent.getStringArrayExtra("contact_receivers_phone");
                    Log.e("MSCI", "onActivityResult.ACTIVITY_PURPOSE_INVITE_BUDDY.result : " + Arrays.toString(stringArrayExtra));
                    Intent intent3 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                    intent3.putExtra("receivers", stringArrayExtra);
                    intent3.putExtra("contact_receivers_id", stringArrayExtra2);
                    intent3.putExtra("contact_receivers_phone", stringArrayExtra3);
                    intent3.putExtra("inboxNO", this.f5799j);
                    intent3.putExtra("buddyNO", this.f5762G);
                    intent3.putExtra("chatType", this.f5800k);
                    getActivity().setResult(-1, intent3);
                    ((InterfaceC1710fj) getActivity()).mo8281h();
                    break;
                }
                break;
            case 6:
            case 7:
                this.f5758C = intent.getStringExtra("backgroundStyle");
                this.f5759D = intent.getStringExtra("sendBubbleStyle");
                this.f5760E = intent.getStringExtra("receiveBubbleStyle");
                ContentValues contentValues = new ContentValues();
                contentValues.put("inbox_is_change_skin", "Y");
                contentValues.put("inbox_background_style", this.f5758C);
                contentValues.put("inbox_send_bubble_style", this.f5759D);
                contentValues.put("inbox_receive_bubble_style", this.f5760E);
                this.f5756A.startUpdate(0, null, C2299s.f8209a, contentValues, "inbox_no='" + this.f5799j + "'", null);
                break;
            case 8:
                if (i2 == -1) {
                    this.f5795f = intent.getStringExtra(ChatFragment.f5469e);
                    this.f5794e.setText(this.f5795f);
                    break;
                }
                break;
            case 9:
                if (i2 == -1) {
                    Intent intent4 = new Intent(this.f5797h, (Class<?>) ImageModify.class);
                    intent4.setDataAndType(this.f5769N, "image/*");
                    intent4.putExtra("outputX", 600);
                    intent4.putExtra("outputY", 600);
                    intent4.putExtra("aspectX", 1);
                    intent4.putExtra("aspectY", 1);
                    intent4.putExtra("return-data", true);
                    startActivityForResult(intent4, 3);
                    break;
                } else {
                    C4904y.m18639b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    /* renamed from: g */
    private void m8302g() {
        if (!m8331c() || !m8332d()) {
            C4904y.m18634a("[deleteTempFolder] External Storage Is Not Available or Writable!", f5755a);
            if (this.f5770O == null) {
                this.f5770O = C5179v.m19811a(GlobalApplication.m18732r(), getString(R.string.toast_sdcard_amount), 1);
            }
            this.f5770O.show();
            return;
        }
        String strM18501b = C4873ck.m18501b();
        if (strM18501b.length() == 0) {
            this.f5770O.show();
            return;
        }
        try {
            String[] list = new File(strM18501b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C4904y.m18639b("[Delete File] " + strM18501b + "/profile/" + str + " : " + new File(strM18501b + "/profile/" + str).delete(), f5755a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    private void m8304h() throws Resources.NotFoundException {
        int size;
        String string;
        String str;
        this.f5811v = (LinearLayout) this.f5814y.findViewById(R.id.layoutCenterButtonForTopic);
        this.f5811v.setVisibility(0);
        this.f5812w = (TextView) this.f5814y.findViewById(R.id.textViewForTopic);
        if (this.f5801l == null) {
            size = this.f5786ae;
        } else {
            size = this.f5801l.size();
        }
        if (!TextUtils.isEmpty(this.f5783ab)) {
            if (TextUtils.isEmpty(this.f5784ac)) {
                str = this.f5795f;
            } else {
                str = this.f5784ac + ": " + this.f5795f;
            }
            string = CommonApplication.m18732r().getResources().getString(R.string.topic_chatinfo, str, Integer.valueOf(size));
        } else {
            string = CommonApplication.m18732r().getResources().getString(R.string.topic_chatinfo, this.f5795f, Integer.valueOf(size));
        }
        ((Button) this.f5814y.findViewById(R.id.buttonGoToTopic)).setOnClickListener(new ViewOnClickListenerC1697ex(this));
        this.f5812w.setText(string);
    }

    /* renamed from: c */
    protected boolean m8331c() {
        m8306i();
        return this.f5767L;
    }

    /* renamed from: d */
    protected boolean m8332d() {
        m8306i();
        return this.f5768M;
    }

    /* renamed from: i */
    private void m8306i() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f5767L = true;
            this.f5768M = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f5767L = true;
            this.f5768M = false;
        } else {
            this.f5767L = false;
            this.f5768M = false;
        }
    }

    /* renamed from: b */
    public void m8330b(String str) {
        this.f5795f = str;
        this.f5794e.setText(this.f5795f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m8308j() throws ExecutionException, InterruptedException {
        String strM10534a;
        try {
            ContentValues contentValues = new ContentValues();
            if (C4809aa.m18104a().m18119a("is_file_server_primary ", (Boolean) true).booleanValue()) {
                strM10534a = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.FILE);
            } else {
                strM10534a = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.FILE);
            }
            contentValues.put("profile_url", String.format("%s%s?%s=%s&%s=%s&%s=%s&%s=%s", strM10534a, "/profileimage", "uid", C4809aa.m18104a().m18121a("uid", ""), "imei", C4822an.m18228d(), "size", 160, "filename", this.f5774S));
            CommonApplication.m18732r().getContentResolver().update(C2299s.f8209a, contentValues, "inbox_no='" + this.f5799j + "'", null);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C4812ad.m18157b(GlobalApplication.m18732r(), Uri.parse(this.f5765J.getPath()), 600), 600, 600, true);
            this.f5809t.setImageDrawable(new C5051q(bitmapCreateScaledBitmap));
            C2496n.m10773b(this.f5797h, this.f5799j, bitmapCreateScaledBitmap).get();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f5772Q.isShowing()) {
            this.f5772Q.dismiss();
        }
        if (this.f5775T != null) {
            this.f5775T.m19014a();
        }
        C0991aa.m6037a().m18960b(this.f5787af);
    }
}
