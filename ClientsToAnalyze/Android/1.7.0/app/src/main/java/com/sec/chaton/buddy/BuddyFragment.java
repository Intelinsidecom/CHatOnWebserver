package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.motion.MREvent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.InterfaceC0726l;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.buddy.p017a.C0364b;
import com.sec.chaton.buddy.p017a.C0365c;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.InterfaceC0531ag;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.coolots.C0613d;
import com.sec.chaton.p013a.C0217p;
import com.sec.chaton.p013a.p014a.C0159bh;
import com.sec.chaton.p025d.C0661n;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0668u;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.p025d.p027b.C0649l;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1303az;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1337l;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1344s;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.C1632t;
import com.sec.widget.ChoicePanel;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.FastScrollableExpandableListView;
import com.sec.widget.GeneralHeaderView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, InterfaceC0427ch, InterfaceC0531ag, InterfaceC0726l {

    /* renamed from: a */
    public static final String f1090a = BuddyFragment.class.getSimpleName();

    /* renamed from: A */
    private String f1091A;

    /* renamed from: B */
    private String f1092B;

    /* renamed from: C */
    private int f1093C;

    /* renamed from: D */
    private String[] f1094D;

    /* renamed from: E */
    private String f1095E;

    /* renamed from: F */
    private LinearLayout f1096F;

    /* renamed from: G */
    private C1632t f1097G;

    /* renamed from: H */
    private ImageButton f1098H;

    /* renamed from: I */
    private ImageButton f1099I;

    /* renamed from: J */
    private Bundle f1100J;

    /* renamed from: V */
    private C0363a f1112V;

    /* renamed from: W */
    private C0370ae f1113W;

    /* renamed from: Y */
    private ChoicePanel f1115Y;

    /* renamed from: af */
    private int f1123af;

    /* renamed from: ag */
    private String f1124ag;

    /* renamed from: ah */
    private String f1125ah;

    /* renamed from: ai */
    private String f1126ai;

    /* renamed from: al */
    private Toast f1129al;

    /* renamed from: am */
    private LinearLayout f1130am;

    /* renamed from: an */
    private TextView f1131an;

    /* renamed from: ao */
    private C0630j f1132ao;

    /* renamed from: ap */
    private InterfaceC0387av f1133ap;

    /* renamed from: au */
    private int f1138au;

    /* renamed from: b */
    protected C0365c f1144b;

    /* renamed from: c */
    public BuddyFragment f1145c;

    /* renamed from: k */
    private Context f1153k;

    /* renamed from: l */
    private LinearLayout f1154l;

    /* renamed from: m */
    private LinearLayout f1155m;

    /* renamed from: n */
    private FastScrollableExpandableListView f1156n;

    /* renamed from: o */
    private TextView f1157o;

    /* renamed from: p */
    private EditTextWithClearButton f1158p;

    /* renamed from: q */
    private Button f1159q;

    /* renamed from: r */
    private View f1160r;

    /* renamed from: s */
    private LinearLayout f1161s;

    /* renamed from: t */
    private GeneralHeaderView f1162t;

    /* renamed from: x */
    private EditTextWithClearButton f1166x;

    /* renamed from: y */
    private ViewGroup f1167y;

    /* renamed from: z */
    private String f1168z;

    /* renamed from: j */
    private int f1152j = 0;

    /* renamed from: u */
    private boolean f1163u = false;

    /* renamed from: v */
    private boolean f1164v = false;

    /* renamed from: w */
    private boolean f1165w = false;

    /* renamed from: K */
    private int f1101K = 11;

    /* renamed from: L */
    private int f1102L = 0;

    /* renamed from: M */
    private int f1103M = 1;

    /* renamed from: N */
    private String[] f1104N = null;

    /* renamed from: O */
    private String[] f1105O = null;

    /* renamed from: P */
    private ArrayList f1106P = new ArrayList();

    /* renamed from: Q */
    private ArrayList f1107Q = new ArrayList();

    /* renamed from: R */
    private final ArrayList f1108R = new ArrayList();

    /* renamed from: S */
    private final ArrayList f1109S = new ArrayList();

    /* renamed from: T */
    private final ArrayList f1110T = new ArrayList();

    /* renamed from: U */
    private final ArrayList f1111U = new ArrayList();

    /* renamed from: X */
    private C0368ac f1114X = null;

    /* renamed from: Z */
    private boolean f1116Z = false;

    /* renamed from: aa */
    private ProgressDialog f1118aa = null;

    /* renamed from: ab */
    private AlertDialog f1119ab = null;

    /* renamed from: ac */
    private boolean f1120ac = true;

    /* renamed from: ad */
    private boolean f1121ad = false;

    /* renamed from: ae */
    private boolean f1122ae = false;

    /* renamed from: aj */
    private ArrayList f1127aj = new ArrayList();

    /* renamed from: ak */
    private ArrayList f1128ak = null;

    /* renamed from: d */
    InterfaceC0626f f1146d = new C0428ci(this);

    /* renamed from: aq */
    private View.OnClickListener f1134aq = new ViewOnClickListenerC0440e(this);

    /* renamed from: ar */
    private TextWatcher f1135ar = new C0439d(this);

    /* renamed from: as */
    private TextWatcher f1136as = new C0419c(this);

    /* renamed from: at */
    private ArrayList f1137at = new ArrayList();

    /* renamed from: e */
    Handler f1147e = new HandlerC0443h(this);

    /* renamed from: f */
    InterfaceC0641d f1148f = new C0442g(this);

    /* renamed from: g */
    InterfaceC0641d f1149g = new C0446k(this);

    /* renamed from: h */
    InterfaceC0641d f1150h = new C0447l(this);

    /* renamed from: i */
    ContentObserver f1151i = new C0450o(this, new Handler());

    /* renamed from: av */
    private int f1139av = 0;

    /* renamed from: aw */
    private int f1140aw = -1;

    /* renamed from: ax */
    private int f1141ax = -1;

    /* renamed from: ay */
    private int f1142ay = 0;

    /* renamed from: az */
    private boolean f1143az = false;

    /* renamed from: aA */
    private int f1117aA = 0;

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: a */
    public void mo2192a() {
        BaseActivity.m2041a(this, true);
        m2181u();
        this.f1120ac = true;
        C1341p.m4663f("onTabSelected() : " + this.f1120ac, f1090a);
        if (this.f1121ad) {
            this.f1114X.m2351a();
        }
        this.f1121ad = false;
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: b */
    public void mo2200b() {
        BaseActivity.m2041a(this, false);
        this.f1158p.setText("");
        m2183v();
        m2185w();
        m2181u();
        this.f1120ac = false;
        C1341p.m4663f("onTabUnSelected() : " + this.f1120ac, f1090a);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C1341p.m4663f("onCreate()", f1090a);
        super.onCreate(bundle);
        this.f1145c = this;
        this.f1153k = getActivity();
        this.f1114X = new C0368ac(this);
        this.f1129al = C1619g.m5889a(this.f1153k, (CharSequence) null, 0);
        this.f1153k.getContentResolver().registerContentObserver(C0667t.f2310a, true, this.f1151i);
        this.f1153k.getContentResolver().registerContentObserver(C0661n.f2288a, true, this.f1151i);
        this.f1153k.getContentResolver().registerContentObserver(C0668u.f2311a, true, this.f1151i);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1341p.m4663f("onCreateView()", f1090a);
        return layoutInflater.inflate(R.layout.buddy_layout2, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C1341p.m4663f("onActivityCreated()", f1090a);
        super.onActivityCreated(bundle);
        this.f1132ao = new C0630j(getActivity().getContentResolver(), this.f1146d);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f1123af = arguments.getInt("content_type");
                C1341p.m4659c("Buddy content_type:" + this.f1123af);
                this.f1122ae = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f1124ag = arguments.getString("download_uri");
                C1341p.m4659c("Buddy download_uri:" + this.f1124ag);
            }
            if (arguments.containsKey("sub_content")) {
                this.f1125ah = arguments.getString("sub_content");
                C1341p.m4659c("Buddy sub_content:" + this.f1125ah);
            }
        }
        m2177s();
        m2160k();
        if (this.f1103M == 9 && bundle == null) {
            this.f1127aj.clear();
            this.f1127aj = getArguments().getStringArrayList("ACTIVITY_PURPOSE_ARG");
        }
        if (this.f1120ac) {
            if (this.f1103M == 6) {
                if (this.f1094D == null || this.f1094D.length == 0) {
                    this.f1114X.m2355b();
                } else {
                    m2167n();
                }
            } else {
                this.f1114X.m2351a();
            }
        }
        if (getActivity() instanceof InterfaceC0387av) {
            this.f1133ap = (InterfaceC0387av) getActivity();
            this.f1162t.setVisibility(8);
        } else {
            this.f1133ap = new C0429cj(this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        int i = 0;
        C1341p.m4663f("onStart() : " + this.f1120ac, f1090a);
        super.onStart();
        if (this.f1103M == 1 && this.f1106P.size() > 0) {
            boolean z = C1323bs.m4575a().getBoolean("Profile Birth Chk", true);
            C1341p.m4663f("onStart() isShowBirthdayCategory : " + z, f1090a);
            if (z) {
                while (true) {
                    int i2 = i;
                    if (i2 < this.f1106P.size()) {
                        if (((C0364b) this.f1106P.get(i2)).m2343d() != 0) {
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    } else {
                        if (m2171p()) {
                            m2125a(this.f1106P, this.f1107Q);
                            return;
                        }
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = i;
                    if (i3 < this.f1106P.size()) {
                        if (((C0364b) this.f1106P.get(i3)).m2343d() != 0) {
                            i = i3 + 1;
                        } else {
                            this.f1106P.remove(i3);
                            this.f1107Q.remove(i3);
                            m2125a(this.f1106P, this.f1107Q);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f1120ac = true;
        C1341p.m4663f("onResume() : " + this.f1120ac, f1090a);
        C1341p.m4663f("isChanged : " + this.f1121ad, f1090a);
        this.f1158p.addTextChangedListener(this.f1135ar);
        this.f1166x.addTextChangedListener(this.f1136as);
        if (this.f1121ad) {
            this.f1114X.m2351a();
        } else {
            this.f1121ad = false;
        }
        this.f1159q.setEnabled(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f1120ac = false;
        this.f1158p.removeTextChangedListener(this.f1135ar);
        this.f1166x.removeTextChangedListener(this.f1136as);
        m2174r();
        C1341p.m4663f("onPause() : " + this.f1120ac, f1090a);
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        C1341p.m4663f("onStop()", f1090a);
        try {
            this.f1158p.removeTextChangedListener(this.f1135ar);
        } catch (Exception e) {
        }
        m2183v();
        m2185w();
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f1153k.getContentResolver().unregisterContentObserver(this.f1151i);
        super.onDestroy();
    }

    /* renamed from: j */
    private boolean m2159j() {
        return (this.f1116Z || this.f1117aA == 2 || this.f1117aA == 3) ? false : true;
    }

    /* renamed from: k */
    private void m2160k() {
        C1341p.m4663f("initView() " + this.f1103M, f1090a);
        this.f1154l = (LinearLayout) getView().findViewById(R.id.buddy_list_layout);
        this.f1155m = (LinearLayout) getView().findViewById(R.id.tell_friends_layout);
        this.f1160r = getView().findViewById(R.id.buddy_list_no_search_result);
        this.f1161s = (LinearLayout) getView().findViewById(R.id.no_item_layout);
        this.f1162t = (GeneralHeaderView) getView().findViewById(R.id.title_menu);
        this.f1166x = (EditTextWithClearButton) getView().findViewById(R.id.edit_title);
        this.f1167y = (ViewGroup) getView().findViewById(R.id.chat_title_bar);
        this.f1096F = (LinearLayout) getView().findViewById(R.id.searcdh_bar);
        this.f1156n = (FastScrollableExpandableListView) getView().findViewById(R.id.buddy_list);
        this.f1156n.setOnGroupClickListener(this);
        this.f1156n.setOnGroupCollapseListener(this);
        this.f1156n.setOnGroupExpandListener(this);
        this.f1156n.setOnChildClickListener(this);
        this.f1158p = (EditTextWithClearButton) getView().findViewById(R.id.buddy_search);
        this.f1158p.setShowSearch(true);
        this.f1158p.setMaxLengthString(R.string.toast_text_max_Length);
        this.f1159q = (Button) getView().findViewById(R.id.tell_friends_button);
        this.f1115Y = (ChoicePanel) getView().findViewById(R.id.buddy_choice_panel);
        this.f1115Y.setButtonClickListener(this.f1134aq);
        this.f1101K = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getInt("BUDDY_SORT_STYLE", 11);
        if (this.f1101K == 12) {
            getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putInt("BUDDY_SORT_STYLE", 11).commit();
            this.f1101K = 11;
        }
        if (this.f1101K == 13) {
            this.f1101K = 11;
        }
        this.f1100J = getArguments();
        m2120a(this.f1100J);
        if (this.f1152j != 0) {
            this.f1156n.setChoiceMode(2);
            this.f1156n.setItemsCanFocus(false);
        }
        if (this.f1103M == 9) {
            this.f1156n.setChildCheckInverse(true);
        }
        if (this.f1103M == 18) {
            this.f1096F.setVisibility(8);
        }
        if (this.f1103M == 1) {
            this.f1097G = new C1632t(this);
            this.f1162t.setVisibility(8);
            ImageButton imageButton = (ImageButton) getView().findViewById(R.id.buddy_dropdown);
            this.f1097G = new C1632t(this);
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new ViewOnClickListenerC0432cm(this));
        } else if (this.f1103M == 14 || this.f1103M == 15) {
            if (this.f1152j == 0) {
                this.f1162t.setButtonImageResource(0);
            } else {
                this.f1162t.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
                this.f1162t.setButtonClickListener(new ViewOnClickListenerC0433cn(this));
            }
        } else if (this.f1103M == 8) {
            getView().findViewById(R.id.layoutChatButtons).setVisibility(0);
            this.f1098H = (ImageButton) getView().findViewById(R.id.button_start_chat);
            this.f1099I = (ImageButton) getView().findViewById(R.id.button_broadcast);
            ViewOnClickListenerC0430ck viewOnClickListenerC0430ck = new ViewOnClickListenerC0430ck(this);
            this.f1098H.setOnClickListener(viewOnClickListenerC0430ck);
            this.f1099I.setOnClickListener(viewOnClickListenerC0430ck);
        } else if (this.f1103M == 1000 && this.f1152j == 0) {
            this.f1162t.setButtonImageResource(0);
        } else {
            this.f1162t.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
            this.f1162t.setButtonClickListener(new ViewOnClickListenerC0431cl(this));
        }
        if (this.f1103M == 1) {
            registerForContextMenu(this.f1156n);
        } else if (this.f1103M == 6) {
            this.f1097G = new C1632t(this);
            this.f1162t.setButtonImageResource(R.drawable.general_btn_down_arrow_xml);
            this.f1162t.setButtonClickListener(new ViewOnClickListenerC0435cp(this));
            this.f1162t.setButtonEnabled(true);
            BaseActivity.m2041a(this, true);
            this.f1101K = 11;
            this.f1158p.setVisibility(8);
            this.f1166x.setVisibility(0);
            this.f1167y.setVisibility(0);
            this.f1166x.setSingleLine();
            this.f1095E = this.f1100J.getString(ChatFragment.f1731d);
            this.f1168z = this.f1100J.getString("inboxNO");
            this.f1091A = this.f1100J.getString("buddyNO");
            this.f1093C = this.f1100J.getInt("chatType");
            this.f1163u = this.f1100J.getBoolean(ChatFragment.f1734g);
            if (this.f1100J.containsKey(ChatFragment.f1730c)) {
                this.f1094D = this.f1100J.getStringArray(ChatFragment.f1730c);
            }
            this.f1165w = this.f1100J.getBoolean(ChatFragment.f1736i);
            this.f1131an = (TextView) getView().findViewById(R.id.ChatInfoBuddyTitle);
            if (this.f1094D != null) {
                this.f1131an.setText(getString(R.string.chat_info_buddy_title, Integer.valueOf(this.f1094D.length)));
            }
            this.f1131an.setVisibility(0);
            if (this.f1100J.containsKey(ChatFragment.f1738k)) {
                this.f1100J.getBoolean(ChatFragment.f1738k);
            }
            this.f1130am = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.buddy_adapter_footer_chatinfo, (ViewGroup) this.f1156n, false);
            this.f1130am.setVisibility(0);
            this.f1096F.setVisibility(8);
            this.f1166x.setText(this.f1095E);
            this.f1166x.setMaxLengthString(R.string.toast_text_max_Length);
            C1341p.m4659c("mChattitle:" + this.f1095E);
            this.f1166x.setLongClickable(false);
            this.f1166x.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0436cq(this));
            this.f1166x.setOnEditorActionListener(new C0434co(this));
        }
        this.f1159q.setOnClickListener(new ViewOnClickListenerC0441f(this));
        m2162l();
    }

    /* renamed from: l */
    private void m2162l() {
        m2193a(-1);
    }

    /* renamed from: a */
    void m2193a(int i) {
        C1341p.m4663f("setTitle() : " + i, "BuddyFragment");
        String string = null;
        if (this.f1103M != 1) {
            if (this.f1103M == 2) {
                this.f1162t.setVisibility(0);
                string = getString(R.string.menu_button_start_chat);
            } else if (this.f1103M == 3) {
                string = getString(R.string.buddy_list_optionmenu_broadcast);
            } else if (this.f1103M == 12) {
                string = getString(R.string.tab_chat);
            } else if (this.f1103M == 13) {
                string = getString(R.string.menu_call);
            } else if (this.f1103M == 14 || this.f1103M == 15) {
                string = getString(this.f1103M == 14 ? R.string.menu_voice_call : R.string.menu_video_call);
                if (this.f1152j == 0) {
                    i = -1;
                }
            } else if (this.f1103M == 5) {
                string = getString(R.string.chat_view_menu_invite);
            } else if (this.f1103M == 6) {
                if (EnumC0665r.m3011a(this.f1093C) == EnumC0665r.GROUPCHAT) {
                    string = getString(R.string.chat_info_title, Integer.valueOf(this.f1094D.length));
                } else {
                    string = getString(R.string.chat_info_title, Integer.valueOf(this.f1094D.length));
                }
                i = -1;
            } else if (this.f1103M != 8) {
                if (this.f1103M == 9) {
                    string = getString(R.string.mypage_buddies_say);
                    i = -1;
                } else if (this.f1103M == 10) {
                    string = getString(R.string.buddy_list_optionmenu_addgroup);
                } else {
                    string = getString(R.string.buddy_select_no_list_select_buddies);
                    if (this.f1152j == 0) {
                        i = -1;
                    }
                }
            }
        }
        if (string != null) {
            if (i >= 0) {
                string = string + " (" + i + ")";
            }
            this.f1162t.setVisibility(0);
            this.f1162t.setText(string);
            return;
        }
        this.f1162t.setVisibility(8);
    }

    /* renamed from: a */
    public void m2195a(String str, String str2) {
        m2199a(str, !this.f1156n.m5848b(str), str2, false);
    }

    /* renamed from: a */
    public void m2196a(String str, boolean z, String str2) {
        m2199a(str, z, str2, false);
    }

    /* renamed from: a */
    public boolean m2199a(String str, boolean z, String str2, boolean z2) {
        if (z) {
            if (str2 == null) {
                C0363a c0363aM2117a = m2117a(str, this.f1107Q);
                if (c0363aM2117a == null) {
                    return true;
                }
                str2 = c0363aM2117a.m2314b();
            }
            if (m2094H()) {
                this.f1156n.setChildChecked(str, z);
                if (this.f1152j == 2) {
                    this.f1115Y.m5837a(str, str2);
                }
            } else if (this.f1156n.m5846a(str) != z) {
                m2095I();
                return false;
            }
        } else {
            this.f1156n.setChildChecked(str, z);
            if (this.f1152j == 2) {
                this.f1115Y.m5836a(str);
            }
        }
        if (z2 || this.f1133ap == null) {
            return true;
        }
        this.f1133ap.mo2218a(this.f1156n.m5845a());
        return true;
    }

    /* renamed from: b */
    private boolean m2137b(String str) {
        if (this.f1126ai == null) {
            return true;
        }
        return mo2198a(m2117a(str, this.f1107Q));
    }

    @Override // com.sec.chaton.buddy.InterfaceC0427ch
    /* renamed from: a */
    public boolean mo2198a(C0363a c0363a) {
        return this.f1126ai == null || c0363a.m2336v() || c0363a.m2313a(this.f1126ai);
    }

    /* renamed from: a */
    public void m2197a(ArrayList arrayList) {
        if (this.f1152j == 1 || this.f1152j == 2) {
            Iterator it = this.f1156n.m5847b().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (m2117a(str, this.f1107Q) == null) {
                    m2199a(str, false, null, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m2164m() {
        this.f1103M = 7;
        this.f1154l.setVisibility(8);
        this.f1155m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m2167n() {
        if (this.f1103M == 7) {
            this.f1103M = 1;
        }
        C1341p.m4663f("viewBuddyList() : " + this.f1103M, f1090a);
        this.f1154l.setVisibility(0);
        this.f1155m.setVisibility(8);
        if (this.f1113W == null) {
            this.f1113W = new C0370ae(this.f1156n, getActivity(), this.f1108R, R.layout.buddy_adapter_group_item, this.f1109S, R.layout.buddy_adapter_child_item, this.f1152j != 0, m2159j(), this, this.f1103M != 1000);
            this.f1156n.setAdapter(this.f1113W);
        }
        m2169o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m2169o() {
        C1341p.m4663f("refreshList()", f1090a);
        this.f1158p.removeTextChangedListener(this.f1135ar);
        this.f1158p.setText("");
        this.f1116Z = false;
        this.f1158p.addTextChangedListener(this.f1135ar);
        if (this.f1113W != null) {
            this.f1114X.m2352a(this.f1101K);
        }
    }

    /* renamed from: a */
    private boolean m2128a(Cursor cursor) {
        C1341p.m4658b("addFavoriteDataSetFromCursor " + cursor, f1090a);
        ArrayList arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("group_type");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_name");
        int columnIndex4 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex5 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex6 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex7 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex8 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex9 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex10 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex11 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex12 = cursor.getColumnIndex("relation_send");
        int columnIndex13 = cursor.getColumnIndex("relation_received");
        int columnIndex14 = cursor.getColumnIndex("relation_point");
        int columnIndex15 = cursor.getColumnIndex("relation_icon");
        int columnIndex16 = cursor.getColumnIndex("relation_increase");
        int columnIndex17 = cursor.getColumnIndex("relation_rank");
        int columnIndex18 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex21 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex22 = cursor.getColumnIndex("buddy_extra_info");
        cursor.moveToPosition(-1);
        while (cursor.moveToNext() && cursor.getInt(columnIndex) <= 1) {
            arrayList.add(new C0363a(cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), cursor.getString(columnIndex7), !"Y".equals(cursor.getString(columnIndex8)), cursor.getInt(columnIndex9), cursor.getString(columnIndex10), "Y".equals(cursor.getString(columnIndex11)), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), cursor.getInt(columnIndex18), "Y".equals(cursor.getString(columnIndex19)), "Y".equals(cursor.getString(columnIndex20)), cursor.getInt(columnIndex21), cursor.getString(columnIndex22)));
        }
        if (arrayList.size() > 0) {
            this.f1106P.add(new C0364b(1, getResources().getString(R.string.buddy_list_group_favorites), arrayList.size(), 1, false, false, 0));
            this.f1107Q.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: b */
    private boolean m2135b(Cursor cursor) {
        String strValueOf;
        String string;
        String[] strArrSplit;
        C1341p.m4658b("addGroupDataSetFromCursor " + cursor, f1090a);
        ArrayList arrayList = new ArrayList();
        if (this.f1103M != 19) {
            strValueOf = null;
        } else {
            strValueOf = String.valueOf(this.f1144b.m2347a());
        }
        int columnIndex = cursor.getColumnIndex("group_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_email");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_is_new");
        cursor.moveToPrevious();
        while (cursor.moveToNext() && (string = cursor.getString(columnIndex)) != null && string.length() != 0) {
            C0363a c0363a = new C0363a(cursor.getString(columnIndex2), cursor.getString(columnIndex), null, null, null, null, true, 0, cursor.getString(columnIndex), "Y".equals(cursor.getString(columnIndex5)), 0, 0, 0, 0, 0, 0, 0, false, false);
            HashMap map = new HashMap();
            String str = "%%" + cursor.getString(columnIndex2) + "%%";
            c0363a.m2312a(true);
            String[] strArrSplit2 = null;
            if (cursor.getString(columnIndex3) != null) {
                strArrSplit2 = cursor.getString(columnIndex3).split(str);
            }
            if (cursor.getString(columnIndex4) == null) {
                strArrSplit = null;
            } else {
                strArrSplit = cursor.getString(columnIndex4).split(str);
            }
            if (strArrSplit2 != null && strArrSplit != null) {
                if (strArrSplit2.length > 0 && strArrSplit2.length == strArrSplit.length) {
                    for (int i = 0; i < strArrSplit2.length; i++) {
                        map.put(strArrSplit2[i], strArrSplit[i]);
                    }
                }
                c0363a.m2311a(map);
            }
            if (strValueOf != null && c0363a.m2308a().equals(strValueOf)) {
                this.f1128ak = new ArrayList();
                if (strArrSplit2 != null && strArrSplit2.length > 0) {
                    for (String str2 : strArrSplit2) {
                        this.f1128ak.add(str2);
                    }
                }
            } else {
                arrayList.add(c0363a);
            }
        }
        if (arrayList.size() > 0) {
            this.f1106P.add(new C0364b(1, getResources().getString(R.string.buddy_list_optionmenu_sortby_group), arrayList.size(), 4, false, false, 0));
            this.f1107Q.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: a */
    private void m2119a(Cursor cursor, boolean z) {
        int i;
        ArrayList arrayList;
        C1341p.m4658b("addBuddiesByNameDataSetFromCursor " + cursor, f1090a);
        ArrayList arrayList2 = new ArrayList();
        char c = 0;
        int i2 = 2;
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex12 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex13 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex14 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex15 = cursor.getColumnIndex("buddy_extra_info");
        int columnIndexOrThrow = z ? cursor.getColumnIndexOrThrow("relation_send") : -1;
        int columnIndexOrThrow2 = z ? cursor.getColumnIndexOrThrow("relation_received") : -1;
        int columnIndexOrThrow3 = z ? cursor.getColumnIndexOrThrow("relation_point") : -1;
        int columnIndexOrThrow4 = z ? cursor.getColumnIndexOrThrow("relation_icon") : -1;
        int columnIndexOrThrow5 = z ? cursor.getColumnIndexOrThrow("relation_increase") : -1;
        int columnIndexOrThrow6 = z ? cursor.getColumnIndexOrThrow("relation_rank") : -1;
        this.f1137at.clear();
        cursor.moveToPrevious();
        ArrayList arrayList3 = arrayList2;
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex2);
            if (string != null && string.trim().length() != 0) {
                char cM4638a = C1337l.m4638a(Character.toUpperCase(string.charAt(0)));
                if (c == cM4638a || c == 0) {
                    i = i2;
                    arrayList = arrayList3;
                } else {
                    this.f1107Q.add(arrayList3);
                    i = i2 + 1;
                    this.f1106P.add(new C0364b(i2, String.valueOf(c), arrayList3.size(), 2, false, false, 0));
                    arrayList = new ArrayList();
                }
                C0363a c0363a = new C0363a(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), z ? cursor.getInt(columnIndexOrThrow) : 0, z ? cursor.getInt(columnIndexOrThrow2) : 0, z ? cursor.getInt(columnIndexOrThrow3) : 0, z ? cursor.getInt(columnIndexOrThrow4) : 0, z ? cursor.getInt(columnIndexOrThrow5) : 0, z ? cursor.getInt(columnIndexOrThrow6) : 0, cursor.getInt(columnIndex11), "Y".equals(cursor.getString(columnIndex12)), "Y".equals(cursor.getString(columnIndex13)), cursor.getInt(columnIndex14), cursor.getString(columnIndex15));
                arrayList.add(c0363a);
                this.f1137at.add(c0363a.m2308a());
                i2 = i;
                c = cM4638a;
                arrayList3 = arrayList;
            }
        }
        if (arrayList3.size() > 0) {
            int i3 = i2 + 1;
            this.f1106P.add(new C0364b(i2, String.valueOf(c), arrayList3.size(), 2, false, false, 0));
            this.f1107Q.add(arrayList3);
        }
        if (this.f1133ap != null) {
            this.f1133ap.mo2219b(this.f1137at.size());
        }
    }

    /* renamed from: c */
    private void m2138c(Cursor cursor) {
        int i;
        ArrayList arrayList;
        C1341p.m4658b("addBuddiesByRelationDataSetFromCursor " + cursor, f1090a);
        ArrayList arrayList2 = new ArrayList();
        int i2 = -1;
        int i3 = 2;
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("relation_send");
        int columnIndex12 = cursor.getColumnIndex("relation_received");
        int columnIndex13 = cursor.getColumnIndex("relation_point");
        int columnIndex14 = cursor.getColumnIndex("relation_icon");
        int columnIndex15 = cursor.getColumnIndex("relation_increase");
        int columnIndex16 = cursor.getColumnIndex("relation_rank");
        int columnIndex17 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex18 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex21 = cursor.getColumnIndex("buddy_extra_info");
        cursor.moveToPrevious();
        ArrayList arrayList3 = arrayList2;
        while (cursor.moveToNext()) {
            int i4 = cursor.getInt(columnIndex14);
            if (i4 == i2 || i2 == -1) {
                i = i3;
                arrayList = arrayList3;
            } else {
                this.f1107Q.add(arrayList3);
                i = i3 + 1;
                this.f1106P.add(new C0364b(i3, getResources().getString(R.string.buddy_list_group_level) + " " + String.valueOf(i2), arrayList3.size(), 2, false, false, i2));
                arrayList = new ArrayList();
            }
            arrayList.add(new C0363a(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21)));
            i3 = i;
            i2 = i4;
            arrayList3 = arrayList;
        }
        if (arrayList3.size() > 0) {
            int i5 = i3 + 1;
            this.f1106P.add(new C0364b(i3, getResources().getString(R.string.buddy_list_group_level) + " " + String.valueOf(i2), arrayList3.size(), 2, false, false, i2));
            this.f1107Q.add(arrayList3);
        }
    }

    /* renamed from: p */
    private boolean m2171p() {
        C1341p.m4658b("addBirthdayDataSet", f1090a);
        String str = new SimpleDateFormat("MM-dd").format(new Date());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f1106P.size(); i++) {
            C0364b c0364b = (C0364b) this.f1106P.get(i);
            if (c0364b.m2343d() == 2 || c0364b.m2343d() == 3) {
                Iterator it = ((ArrayList) this.f1107Q.get(i)).iterator();
                while (it.hasNext()) {
                    C0363a c0363a = (C0363a) it.next();
                    if ((c0363a.m2320f().length() == 10 && c0363a.m2320f().substring(5).equals(str)) || (c0363a.m2320f().length() == 5 && c0363a.m2320f().equals(str))) {
                        arrayList.add(c0363a);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.f1106P.size(); i2++) {
                if (((C0364b) this.f1106P.get(i2)).m2343d() > 0) {
                    this.f1106P.add(i2, new C0364b(0, getResources().getString(R.string.buddy_list_group_birthday), arrayList.size(), 0, true, false, 0));
                    this.f1107Q.add(i2, arrayList);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m2143d(Cursor cursor) {
        this.f1106P.clear();
        this.f1107Q.clear();
        if (cursor.getCount() == 0 && this.f1103M == 5) {
            C1619g.m5889a(this.f1153k, getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
            Intent intent = new Intent();
            intent.putExtra("receivers", new String[0]);
            getActivity().setResult(0, intent);
            getActivity().finish();
            return;
        }
        m2128a(cursor);
        m2135b(cursor);
        m2119a(cursor, true);
        if (C1323bs.m4575a().getBoolean("Profile Birth Chk", true) && this.f1103M == 1) {
            m2171p();
        }
        m2172q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2147e(Cursor cursor) {
        this.f1106P.clear();
        this.f1107Q.clear();
        m2128a(cursor);
        m2119a(cursor, true);
        if (C1323bs.m4575a().getBoolean("Profile Birth Chk", true)) {
            m2171p();
        }
        m2172q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2150f(Cursor cursor) {
        this.f1106P.clear();
        this.f1107Q.clear();
        m2119a(cursor, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2153g(Cursor cursor) {
        this.f1106P.clear();
        this.f1107Q.clear();
        m2119a(cursor, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m2155h(Cursor cursor) {
        this.f1106P.clear();
        this.f1107Q.clear();
        m2128a(cursor);
        m2138c(cursor);
        if (C1323bs.m4575a().getBoolean("Profile Birth Chk", true) && this.f1103M == 1) {
            m2171p();
        }
        m2172q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2156i(Cursor cursor) {
        int i;
        char c;
        this.f1110T.clear();
        this.f1111U.clear();
        String string = this.f1158p.getText().toString();
        new ArrayList();
        if (cursor.getCount() != 0) {
            if (!cursor.isBeforeFirst()) {
                cursor.moveToPosition(-1);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            char c2 = 0;
            while (cursor.moveToNext()) {
                String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                boolean z = false;
                if (C1303az.m4552a(string2.toUpperCase(), string.toUpperCase())) {
                    if (this.f1143az) {
                        String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                        Iterator it = this.f1107Q.iterator();
                        while (true) {
                            boolean z2 = z;
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            Iterator it2 = ((ArrayList) it.next()).iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z = z2;
                                    break;
                                }
                                C0363a c0363a = (C0363a) it2.next();
                                if (!c0363a.m2336v() && string3.equals(c0363a.m2308a())) {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                break;
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (z) {
                        char cM4638a = C1337l.m4638a(Character.toUpperCase(string2.charAt(0)));
                        if (cursor.getInt(cursor.getColumnIndex("group_relation_group")) != 1) {
                            arrayList.add(new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")), cursor.getString(cursor.getColumnIndex("buddy_extra_info"))));
                            i = i2 + 1;
                            c = cM4638a;
                        }
                    }
                } else {
                    i = i2;
                    c = c2;
                }
                i2 = i;
                c2 = c;
            }
            if (c2 != 0) {
                this.f1111U.add(arrayList);
                this.f1110T.add(new C0364b(2, String.valueOf(c2), i2, 2, false, false, 0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2125a(ArrayList arrayList, ArrayList arrayList2) {
        if (this.f1157o != null) {
            int size = this.f1138au;
            if (this.f1116Z && arrayList2.size() > 0) {
                size = ((ArrayList) arrayList2.get(0)).size();
            }
            if (size > 1) {
                this.f1157o.setText(getResources().getString(R.string.buddy_list_total_count, Integer.valueOf(size)));
            } else {
                this.f1157o.setText(getResources().getString(R.string.buddy_list_total_count_1));
            }
        }
        this.f1108R.clear();
        this.f1109S.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f1108R.add(new C0364b((C0364b) it.next()));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList3 = (ArrayList) it2.next();
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                arrayList4.add(new C0363a((C0363a) it3.next()));
            }
            this.f1109S.add(arrayList4);
        }
        if (this.f1103M == 19) {
            this.f1127aj = this.f1128ak;
        }
        if (this.f1127aj.size() > 0) {
            Iterator it4 = this.f1127aj.iterator();
            while (it4.hasNext()) {
                m2199a((String) it4.next(), true, null, true);
            }
            this.f1127aj.clear();
        }
        this.f1113W.m2363a(m2159j());
        this.f1113W.notifyDataSetChanged();
        if (this.f1133ap != null) {
            this.f1133ap.mo2218a(this.f1156n.m5845a());
        }
    }

    /* renamed from: q */
    private void m2172q() {
        C1341p.m4658b("createNewBuddyGroup", f1090a);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f1107Q.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0363a c0363a = (C0363a) it2.next();
                if (c0363a.m2324j() && !c0363a.m2336v() && !arrayList2.contains(c0363a.m2308a())) {
                    arrayList.add(c0363a);
                    arrayList2.add(c0363a.m2308a());
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f1106P.add(0, new C0364b(-1, getResources().getString(R.string.buddy_list_group_new_buddy), arrayList.size(), -1, true, false, 0));
            this.f1107Q.add(0, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m2174r() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.f1116Z && this.f1108R.size() != 0) {
            for (int i = 0; i < this.f1108R.size(); i++) {
                if (!this.f1156n.isGroupExpanded(i) && ((C0364b) this.f1108R.get(i)).m2343d() != -1) {
                    stringBuffer.append("," + ((C0364b) this.f1108R.get(i)).m2341b());
                }
            }
            if (this.f1103M == 1) {
                getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putInt("BUDDY_SORT_STYLE", this.f1101K).commit();
                if (this.f1101K == 12) {
                    if (stringBuffer.toString().length() > 0) {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                        return;
                    } else {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", null).commit();
                        return;
                    }
                }
                if (this.f1101K == 11) {
                    if (stringBuffer.toString().length() > 0) {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                    } else {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", null).commit();
                    }
                }
            }
        }
    }

    /* renamed from: s */
    private void m2177s() {
        String string = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("RELATIONSHIP_FOLDER_STATE", null);
        if (string != null) {
            this.f1104N = string.split(",");
        } else {
            this.f1104N = new String[0];
        }
        String string2 = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("ALPHABET_FOLDER_STATE", null);
        if (string2 != null) {
            this.f1105O = string2.split(",");
        } else {
            this.f1105O = new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m2178t() {
        String[] strArr;
        if (this.f1116Z || this.f1103M == 6) {
            for (int i = 0; i < this.f1108R.size(); i++) {
                this.f1156n.expandGroup(i);
            }
            return;
        }
        if (this.f1103M == 5) {
            for (int i2 = 0; i2 < this.f1108R.size(); i2++) {
                if (((C0364b) this.f1108R.get(i2)).m2343d() < 2) {
                    this.f1156n.collapseGroup(i2);
                } else {
                    this.f1156n.expandGroup(i2);
                }
            }
            return;
        }
        m2177s();
        for (int i3 = 0; i3 < this.f1108R.size(); i3++) {
            this.f1156n.expandGroup(i3);
        }
        if (this.f1101K == 12 && this.f1104N != null) {
            strArr = this.f1104N;
        } else if (this.f1101K != 11 || this.f1105O == null) {
            strArr = null;
        } else {
            strArr = this.f1105O;
        }
        if (strArr != null) {
            for (int i4 = 0; i4 < this.f1108R.size(); i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= strArr.length) {
                        break;
                    }
                    if (!((C0364b) this.f1108R.get(i4)).m2341b().equals(strArr[i5])) {
                        i5++;
                    } else {
                        this.f1156n.collapseGroup(i4);
                        break;
                    }
                }
                if (this.f1103M == 1 && this.f1102L != this.f1101K && ((C0364b) this.f1108R.get(i4)).m2343d() < 2) {
                    this.f1156n.collapseGroup(i4);
                }
            }
        }
        if (this.f1108R.size() > 0 && ((C0364b) this.f1108R.get(0)).m2343d() == -1) {
            this.f1156n.expandGroup(0);
        }
        this.f1102L = this.f1101K;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        C1341p.m4663f("onCreateOptionsMenu()", f1090a);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C1341p.m4663f("onPrepareOptionsMenu()", f1090a);
        menu.clear();
        if (this.f1103M == 1) {
            menu.add(0, 2, 1, getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setIcon(R.drawable.add_buddy);
            if (this.f1101K == 11) {
                if (menu.findItem(3) == null) {
                    menu.add(0, 3, 2, getResources().getString(R.string.buddy_list_optionmenu_addgroup)).setIcon(R.drawable.group_add);
                }
            } else {
                menu.removeItem(3);
            }
            menu.add(0, 13, 3, R.string.recommendation).setIcon(R.drawable.broadcast);
            menu.add(0, 4, 4, getResources().getString(R.string.menu_button_start_chat)).setIcon(R.drawable.start_chat);
            menu.add(0, 5, 5, getResources().getString(R.string.buddy_list_optionmenu_broadcast)).setIcon(R.drawable.broadcast);
            if (AbstractC0617h.m2831a(getActivity())) {
                if (C0159bh.m694g() && C0159bh.m695h()) {
                    menu.add(0, 11, 6, R.string.menu_voice_call).setIcon(R.drawable.voice_chat);
                    menu.add(0, 12, 7, R.string.menu_video_call).setIcon(R.drawable.video_chat);
                    return;
                } else if (!C0159bh.m694g() && C0159bh.m695h()) {
                    menu.add(0, 12, 6, R.string.menu_video_call).setIcon(R.drawable.video_chat);
                    return;
                } else {
                    if (C0159bh.m694g() && !C0159bh.m695h()) {
                        menu.add(0, 11, 6, R.string.menu_voice_call).setIcon(R.drawable.voice_chat);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.f1103M == 7) {
            menu.clear();
            menu.add(0, 2, 2, getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setIcon(R.drawable.add_buddy);
            menu.add(0, 13, 6, R.string.recommendation).setIcon(R.drawable.broadcast);
        } else if (this.f1103M == 6) {
            menu.clear();
            menu.add(0, 8, 1, getResources().getString(R.string.chat_view_menu_invite)).setIcon(R.drawable.invite_buddy);
            menu.add(0, 14, 2, getResources().getString(R.string.chat_info_delete_all)).setIcon(R.drawable.ic_menu_delete);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Bitmap bitmap;
        this.f1158p.setText("");
        m2181u();
        switch (menuItem.getItemId()) {
            case 1:
                this.f1119ab = new AlertDialogBuilderC1625m(this.f1153k).setTitle(getString(R.string.buddy_list_optionmenu_listby)).setSingleChoiceItems(new String[]{getString(R.string.buddy_list_optionmenu_sortby_option_buddy), getString(R.string.buddy_list_optionmenu_sortby_option_interaction)}, this.f1101K - 11, new DialogInterfaceOnClickListenerC0392b(this)).show();
                return true;
            case 2:
                m2187x();
                return true;
            case 3:
                new AlertDialogC0426cg(getActivity()).show();
                return true;
            case 4:
                m2174r();
                Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("BUDDY_SORT_STYLE", this.f1101K);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                startActivity(intent);
                return true;
            case 5:
                m2174r();
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent2.putExtra("BUDDY_SORT_STYLE", this.f1101K);
                intent2.putExtra("ACTIVITY_PURPOSE", 3);
                startActivity(intent2);
                return true;
            case 6:
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                return true;
            case 7:
                String str = this.f1168z;
                EnumC0665r enumC0665rM3011a = EnumC0665r.m3011a(this.f1093C);
                ProfileImageView profileImageView = new ProfileImageView(getActivity());
                profileImageView.m4722a(profileImageView, EnumC0665r.m3011a(this.f1093C));
                if (enumC0665rM3011a == EnumC0665r.ONETOONE) {
                    str = this.f1091A;
                    C1348w.m4685a(getActivity()).m4699a(profileImageView, this.f1091A);
                    profileImageView.setBuddyNo(this.f1091A);
                }
                Intent intentM4673a = C1344s.m4673a(getActivity(), str, enumC0665rM3011a);
                String str2 = this.f1095E;
                String str3 = enumC0665rM3011a == EnumC0665r.GROUPCHAT ? String.format("%s(%d)", str2, Integer.valueOf(this.f1094D.length + 1)) : str2;
                try {
                    bitmap = ((BitmapDrawable) profileImageView.getDrawable()).getBitmap();
                } catch (Exception e) {
                    bitmap = null;
                }
                C1344s.m4675a(getActivity(), intentM4673a, str3, Bitmap.createScaledBitmap(C1294aq.m4497a(getActivity(), bitmap), C1344s.m4672a(getResources().getDisplayMetrics().density), C1344s.m4672a(getResources().getDisplayMetrics().density), true));
                return true;
            case 8:
                if (this.f1114X != null) {
                    this.f1114X.m2359e();
                }
                return true;
            case 9:
                m2174r();
                Intent intent3 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent3.putExtra("BUDDY_SORT_STYLE", this.f1101K);
                intent3.putExtra("ACTIVITY_PURPOSE", 12);
                startActivity(intent3);
                return true;
            case 10:
            default:
                return true;
            case 11:
                m2174r();
                Intent intent4 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent4.putExtra("BUDDY_SORT_STYLE", this.f1101K);
                intent4.putExtra("ACTIVITY_PURPOSE", 14);
                startActivity(intent4);
                return true;
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                m2174r();
                Intent intent5 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent5.putExtra("BUDDY_SORT_STYLE", this.f1101K);
                intent5.putExtra("ACTIVITY_PURPOSE", 15);
                startActivity(intent5);
                return true;
            case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                startActivity(new Intent(getActivity(), (Class<?>) BuddyRecommendActivity.class));
                return true;
            case 14:
                AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
                alertDialogBuilderC1625m.setTitle(R.string.chat_info_delete_all);
                alertDialogBuilderC1625m.setMessage(R.string.chat_deleted_popup).setCancelable(true).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0445j(this)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0362a(this));
                alertDialogBuilderC1625m.show();
                return true;
            case 15:
                new AlertDialogC0426cg(getActivity(), 101, this.f1145c).show();
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x025d  */
    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreateContextMenu(android.view.ContextMenu r11, android.view.View r12, android.view.ContextMenu.ContextMenuInfo r13) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        Intent intentM4674a;
        Bitmap bitmap;
        C0363a c0363a = this.f1112V;
        switch (menuItem.getItemId()) {
            case 101:
                Intent intent = new Intent(this.f1153k, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", c0363a.m2308a());
                intent.putExtra("PROFILE_BUDDY_NAME", c0363a.m2314b());
                startActivityForResult(intent, 11);
                return true;
            case 102:
                this.f1114X.m2353a(c0363a);
                return true;
            case 103:
                this.f1114X.m2356b(c0363a);
                return true;
            case 104:
                m2085D();
                new C0217p(this.f1147e).m798a(c0363a.m2308a(), 1);
                return true;
            case 105:
            default:
                return true;
            case 106:
            case 107:
            case 108:
                C1341p.m4660c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT item=" + menuItem.getItemId() + ", buddy=" + c0363a.m2308a(), getClass().getSimpleName());
                int i = R.drawable.chaton_shortcut;
                if (menuItem.getItemId() == 106) {
                    intentM4674a = C1344s.m4673a(getActivity(), c0363a.m2308a(), EnumC0665r.ONETOONE);
                } else {
                    intentM4674a = C1344s.m4674a(getActivity(), c0363a.m2308a(), menuItem.getItemId() == 108);
                    i = menuItem.getItemId() == 108 ? R.drawable.chaton_shortcut_video_call : R.drawable.chaton_shortcut_voice_call;
                }
                try {
                    bitmap = ((BitmapDrawable) this.f1112V.m2333s().getDrawable()).getBitmap();
                } catch (Exception e) {
                    bitmap = null;
                }
                C1344s.m4675a(getActivity(), intentM4674a, c0363a.m2314b(), Bitmap.createScaledBitmap(C1294aq.m4498a(getActivity(), bitmap, i), C1344s.m4672a(getResources().getDisplayMetrics().density), C1344s.m4672a(getResources().getDisplayMetrics().density), true));
                return true;
            case 109:
            case 110:
                if (!new C0613d(getActivity(), null, new String[]{c0363a.m2308a()}, menuItem.getItemId() == 109).m2832b()) {
                    C1619g.m5889a(getActivity(), "Install Coolots app first.", 0).show();
                }
                return true;
            case 111:
                new AlertDialogBuilderC1625m(this.f1153k).setTitle(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).setMessage(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0444i(this, c0363a)).setNegativeButton(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
                return true;
            case 112:
                HashMap mapM2337w = c0363a.m2337w();
                C0365c c0365c = new C0365c(Integer.parseInt(c0363a.m2308a()), c0363a.m2314b(), mapM2337w != null ? mapM2337w.size() : 0, 2);
                Intent intent2 = new Intent(this.f1153k, (Class<?>) BuddyGroupProfileActivity.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 18);
                intent2.putExtra("groupInfo", c0365c);
                startActivity(intent2);
                return true;
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C0363a c0363a = (C0363a) ((ArrayList) this.f1109S.get(i)).get(i2);
        if (c0363a.m2336v()) {
            if (this.f1152j == 1 || this.f1152j == 2) {
                HashMap mapM2337w = c0363a.m2337w();
                if (mapM2337w != null && mapM2337w.size() > 0) {
                    Iterator it = mapM2337w.keySet().iterator();
                    while (it.hasNext()) {
                        String strValueOf = String.valueOf(it.next());
                        String str = (String) mapM2337w.get(strValueOf);
                        C1341p.m4663f(strValueOf + ", " + str, f1090a);
                        if (this.f1143az) {
                            str = null;
                        }
                        if (m2137b(strValueOf)) {
                            if (!m2199a(strValueOf, !this.f1156n.m5850d(), str, true)) {
                                break;
                            }
                        }
                    }
                    if (this.f1133ap != null) {
                        this.f1133ap.mo2218a(this.f1156n.m5845a());
                    }
                }
            } else if (c0363a.m2337w().size() + 1 > 200) {
                m2124a((CharSequence) getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed, 199));
            } else {
                Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                intent.putExtra("receivers", (String[]) c0363a.m2337w().keySet().toArray(new String[0]));
                intent.putExtra("groupId", c0363a.m2308a());
                startActivity(intent);
            }
        } else if (this.f1152j == 0) {
            this.f1113W.m2362a((String) null);
            if (this.f1103M == 14 || this.f1103M == 15) {
                if (!new C0613d(getActivity(), new C0448m(this), new String[]{c0363a.m2308a()}, this.f1103M == 14).m2832b()) {
                    C1619g.m5889a(getActivity(), "Install Coolots app first.", 0).show();
                }
            } else if (this.f1103M == 1000) {
                m2127a(new String[]{c0363a.m2308a()});
            } else {
                this.f1114X.m2354a(c0363a.m2308a());
            }
        } else {
            m2195a(c0363a.m2308a(), c0363a.m2314b());
        }
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m2181u() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f1158p.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        C1341p.m4663f("onActivityResult()", f1090a);
        if (i == 100) {
            if (i2 == -1) {
                C1341p.m4663f("Add buddy success", f1090a);
                if (this.f1114X != null) {
                    this.f1114X.m2351a();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 5 && i2 == -1) {
            String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
            Intent intent2 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent2.putExtra("receivers", stringArrayExtra);
            intent2.putExtra("inboxNO", this.f1168z);
            intent2.putExtra("buddyNO", this.f1091A);
            intent2.putExtra("chatType", this.f1093C);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
        }
    }

    /* renamed from: v */
    private void m2183v() {
        Iterator it = this.f1107Q.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0363a c0363a = (C0363a) it2.next();
                if (c0363a.m2324j() || c0363a.m2335u() || c0363a.m2334t()) {
                    this.f1114X.m2357c();
                    return;
                }
            }
        }
    }

    /* renamed from: w */
    private void m2185w() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f1107Q.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0363a c0363a = (C0363a) it2.next();
                if (c0363a.m2336v() && c0363a.m2324j()) {
                    stringBuffer.append(c0363a.m2308a() + ",");
                }
            }
        }
        if (this.f1103M != 10 && stringBuffer.toString().length() > 0) {
            this.f1114X.m2358d();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0531ag
    /* renamed from: d */
    public boolean mo2202d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C0363a m2117a(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0363a c0363a = (C0363a) it2.next();
                if (c0363a.m2308a().equals(str)) {
                    return c0363a;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m2187x() {
        startActivityForResult(new Intent(getActivity(), (Class<?>) AddBuddyActivity.class), 100);
    }

    /* renamed from: a */
    public void m2194a(String str) {
        C1341p.m4663f("NEW GROUP NAME : " + str, f1090a);
        C1341p.m4663f("MEMBER COUNT  : " + this.f1094D.length, f1090a);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f1094D.length; i++) {
            arrayList.add(this.f1094D[i]);
        }
        arrayList.add(0, str);
        C0627g.m2858a(new C0627g(), 2, new C0649l(this.f1150h, (String[]) arrayList.toArray(new String[0]), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m2188y() {
        int iM2204f = m2204f();
        if (iM2204f > 0) {
            if (iM2204f + 1 <= 200) {
                if (iM2204f == 1) {
                    this.f1114X.m2354a(m2203e()[0]);
                    return;
                }
                Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                intent.putExtra("receivers", m2203e());
                if (this.f1122ae) {
                    intent.putExtra("content_type", this.f1123af);
                    intent.putExtra("download_uri", this.f1124ag);
                    intent.putExtra("sub_content", this.f1125ah);
                }
                startActivity(intent);
                getActivity().finish();
                return;
            }
            C1619g.m5889a(getActivity(), String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m2191z() {
        int iM2204f = m2204f();
        if (iM2204f > 0) {
            if (iM2204f <= 200) {
                Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("chatType", EnumC0665r.BROADCAST.m3012a());
                intent.putExtra("receivers", m2203e());
                if (this.f1122ae) {
                    intent.putExtra("content_type", this.f1123af);
                    intent.putExtra("download_uri", this.f1124ag);
                    intent.putExtra("sub_content", this.f1125ah);
                }
                startActivity(intent);
                getActivity().finish();
                return;
            }
            C1619g.m5889a(getActivity(), String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), 200), 0).show();
        }
    }

    /* renamed from: a */
    private void m2126a(boolean z) {
        int iM2204f = m2204f();
        if (iM2204f > 0) {
            int i = C1323bs.m4575a().getInt(z ? "group_voice_call_max_count" : "group_video_call_max_count", 1);
            if (iM2204f <= i - 1) {
                if (!new C0613d(getActivity(), new C0449n(this), m2203e(), z).m2832b()) {
                    C1619g.m5889a(getActivity(), "Install Coolots app first.", 0).show();
                    return;
                }
                return;
            }
            C1619g.m5889a(this.f1153k, getResources().getString(R.string.buddy_list_select_maximum_failed, Integer.valueOf(i)), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2141c(String str) {
        int iM2204f = m2204f();
        if (iM2204f > 0) {
            m2085D();
            C1341p.m4663f("NEW GROUP NAME : " + this.f1100J.getString("ACTIVITY_PURPOSE_ARG2"), f1090a);
            C1341p.m4663f("MEMBER COUNT  : " + iM2204f, f1090a);
            C0627g.m2858a(new C0627g(), 2, new C0649l(this.f1150h, str, m2203e(), 2));
        }
    }

    /* renamed from: A */
    private void m2079A() {
        int iM2204f = m2204f();
        C1341p.m4663f("Button.OnClickListener() : INVITE BUDDY", f1090a);
        C1341p.m4663f("count : " + iM2204f, f1090a);
        C1341p.m4663f("mBundle.getStringArray(ChatFragment.EXTRA_PARTICIPANT).length : " + this.f1100J.getStringArray(ChatFragment.f1730c).length, f1090a);
        C1341p.m4663f("mBundle.getInt(ChatFragment.KEY_CHAT_TYPE) : " + this.f1100J.getInt("chatType"), f1090a);
        if (iM2204f > 0) {
            if (this.f1100J.getInt("chatType") == EnumC0665r.GROUPCHAT.m3012a() || this.f1100J.getInt("chatType") == EnumC0665r.ONETOONE.m3012a()) {
                if (iM2204f + this.f1100J.getStringArray(ChatFragment.f1730c).length + 1 > 200) {
                    C1619g.m5889a(this.f1153k, String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                    return;
                }
            } else if (this.f1100J.getInt("chatType") == EnumC0665r.BROADCAST.m3012a() && iM2204f + this.f1100J.getStringArray(ChatFragment.f1730c).length > 200) {
                C1619g.m5889a(this.f1153k, String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), 200), 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("receivers", m2203e());
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    /* renamed from: B */
    private void m2082B() {
        Intent intent = new Intent();
        intent.putExtra("blindlist", m2203e());
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m2084C() {
        if (this.f1103M == 2) {
            m2188y();
            return;
        }
        if (this.f1103M == 3) {
            m2191z();
            return;
        }
        if (this.f1103M == 14 || this.f1103M == 15) {
            m2126a(this.f1103M == 14);
            return;
        }
        if (this.f1103M == 10) {
            m2141c(this.f1100J.getString("ACTIVITY_PURPOSE_ARG2"));
            return;
        }
        if (this.f1103M == 5) {
            m2079A();
        } else if (this.f1103M == 9) {
            m2082B();
        } else if (this.f1103M == 1000) {
            m2127a(m2203e());
        }
    }

    /* renamed from: a */
    private void m2127a(String[] strArr) {
        Intent intent = new Intent();
        intent.putExtra("result", strArr);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: c */
    public HashSet m2201c() {
        return this.f1156n.m5847b();
    }

    /* renamed from: e */
    public String[] m2203e() {
        return this.f1156n.m5849c();
    }

    /* renamed from: f */
    public int m2204f() {
        return this.f1156n.m5845a();
    }

    /* renamed from: g */
    public String[] m2205g() {
        return (String[]) this.f1137at.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m2085D() {
        if (getActivity() != null) {
            if (this.f1118aa == null) {
                this.f1118aa = ProgressDialogC1354a.m4724a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f1118aa.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m2088E() {
        if (getActivity() != null && this.f1118aa != null) {
            this.f1118aa.dismiss();
        }
    }

    /* renamed from: a */
    private void m2124a(CharSequence charSequence) {
        if (this.f1129al == null) {
            this.f1129al = C1619g.m5889a(this.f1153k, (CharSequence) null, 0);
        }
        this.f1129al.setText(charSequence);
        this.f1129al.show();
    }

    /* renamed from: a */
    private void m2120a(Bundle bundle) {
        if (bundle == null) {
            this.f1103M = 1;
            this.f1102L = this.f1101K;
        } else {
            this.f1103M = bundle.getInt("ACTIVITY_PURPOSE", 1);
            this.f1126ai = bundle.getString("require");
            if (this.f1103M == 13) {
                this.f1126ai = "voip";
            } else if (this.f1103M == 14) {
                this.f1126ai = "call";
            } else if (this.f1103M == 15) {
                this.f1126ai = "vcall";
            }
            this.f1094D = this.f1100J.getStringArray(ChatFragment.f1730c);
            this.f1144b = (C0365c) bundle.get("groupInfo");
        }
        if (this.f1103M == 2 || this.f1103M == 3 || this.f1103M == 12 || this.f1103M == 10 || this.f1103M == 11 || this.f1103M == 19 || this.f1103M == 5 || this.f1103M == 8) {
            this.f1152j = 2;
        } else if (this.f1103M == 14 || this.f1103M == 15) {
            if (C1323bs.m4575a().getInt(this.f1103M == 14 ? "group_voice_call_max_count" : "group_video_call_max_count", 1) == 1) {
                this.f1152j = 0;
            } else {
                this.f1152j = 2;
            }
        } else if (this.f1103M == 9) {
            this.f1152j = 1;
        } else {
            this.f1152j = 0;
        }
        this.f1140aw = 1;
        this.f1139av = 0;
        if (this.f1103M == 2) {
            this.f1141ax = 199;
            this.f1142ay = R.string.buddy_list_groupchat_toast_failed_exceed;
        } else if (this.f1103M == 3) {
            this.f1141ax = 200;
            this.f1142ay = R.string.buddy_list_broadcast_toast_failed_exceed;
        } else if (this.f1103M == 5) {
            this.f1139av = this.f1100J.getStringArray(ChatFragment.f1730c).length;
            int i = this.f1100J.getInt("chatType");
            if (i == EnumC0665r.ONETOONE.m3012a() || i == EnumC0665r.GROUPCHAT.m3012a()) {
                this.f1141ax = 199;
                this.f1142ay = R.string.buddy_list_groupchat_toast_failed_exceed;
            } else if (i == EnumC0665r.BROADCAST.m3012a()) {
                this.f1141ax = 200;
                this.f1142ay = R.string.buddy_list_broadcast_toast_failed_exceed;
            }
            this.f1142ay = R.string.buddy_list_groupchat_toast_failed_exceed;
        } else if (this.f1103M == 9 || this.f1103M == 6) {
            this.f1140aw = -1;
            this.f1141ax = -1;
        } else if (this.f1103M == 10 || this.f1103M == 19) {
            this.f1141ax = 199;
            this.f1142ay = R.string.buddy_list_select_maximum_failed;
        } else if (this.f1103M == 14) {
            this.f1141ax = C1323bs.m4575a().getInt("group_voice_call_max_count", 1) - 1;
            this.f1142ay = R.string.buddy_list_select_maximum_failed;
        } else if (this.f1103M == 15) {
            this.f1141ax = C1323bs.m4575a().getInt("group_video_call_max_count", 1) - 1;
            this.f1142ay = R.string.buddy_list_select_maximum_failed;
        }
        if (this.f1103M == 6) {
            this.f1117aA = 3;
        } else if (this.f1103M == 8) {
            this.f1117aA = 0;
        } else if (this.f1103M == 18) {
            this.f1117aA = 2;
        } else if (this.f1103M == 14 || this.f1103M == 15) {
            this.f1117aA = bundle.getInt("range", this.f1152j == 0 ? 1 : 0);
        } else {
            this.f1117aA = 0;
        }
        if (this.f1103M == 5 || this.f1103M == 8) {
            this.f1143az = true;
        } else {
            this.f1143az = false;
        }
        if (this.f1103M == 1000) {
            this.f1141ax = bundle.getInt("max", -1);
            this.f1140aw = bundle.getInt("min", 1);
            this.f1142ay = R.string.buddy_list_select_maximum_failed;
            this.f1094D = bundle.getStringArray("except");
            if (this.f1094D != null && this.f1094D.length > 0) {
                this.f1143az = true;
                this.f1139av = 0;
            } else {
                this.f1143az = false;
                this.f1139av = 0;
            }
            if (bundle.getBoolean("single", false)) {
                this.f1152j = 0;
                this.f1117aA = 1;
            } else {
                this.f1152j = 2;
                this.f1117aA = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m2089F() {
        int iM5845a = this.f1156n.m5845a();
        C1341p.m4658b("check=" + iM5845a + ", def=" + this.f1139av + ", min=" + this.f1140aw + ", max=" + this.f1141ax, f1090a);
        if (this.f1140aw != -1 && iM5845a < this.f1140aw) {
            this.f1162t.setButtonEnabled(false);
        } else if (this.f1141ax != -1 && iM5845a + this.f1139av > this.f1141ax) {
            this.f1162t.setButtonEnabled(false);
            m2095I();
        } else {
            this.f1162t.setButtonEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m2091G() {
        int iM5845a = this.f1156n != null ? this.f1156n.m5845a() : 0;
        C1341p.m4658b("check=" + iM5845a, f1090a);
        if (iM5845a == 0) {
            this.f1098H.setEnabled(false);
            this.f1099I.setEnabled(false);
            return;
        }
        if (iM5845a > 199) {
            m2124a((CharSequence) getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed, 199));
            this.f1098H.setEnabled(false);
        } else {
            this.f1098H.setEnabled(true);
        }
        if (iM5845a > 200) {
            m2124a((CharSequence) getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed, 200));
            this.f1099I.setEnabled(false);
        } else {
            this.f1099I.setEnabled(true);
        }
    }

    /* renamed from: H */
    private boolean m2094H() {
        if (this.f1141ax == -1) {
            return true;
        }
        int iM5845a = this.f1156n.m5845a();
        C1341p.m4658b("canSelectMore check=" + iM5845a + ", def=" + this.f1139av + ", min=" + this.f1140aw + ", max=" + this.f1141ax, f1090a);
        return iM5845a + this.f1139av < this.f1141ax;
    }

    /* renamed from: I */
    private void m2095I() {
        C1341p.m4658b("showSelectionReachedMaximumPopup " + this.f1141ax, f1090a);
        m2124a((CharSequence) this.f1153k.getString(this.f1142ay, Integer.valueOf(this.f1141ax)));
    }

    /* renamed from: h */
    public void m2206h() {
        if (this.f1120ac) {
            this.f1097G.m5919a(getView().findViewById(R.id.buddy_dropdown));
        }
    }

    /* renamed from: i */
    public void m2207i() {
        this.f1097G.m5919a(getView().findViewById(R.id.header_button1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m2097J() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f1166x.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
        if (this.f1166x.getText().toString().matches(".*,.*")) {
            C1619g.m5888a(getActivity(), R.string.group_name_save, 0).show();
            this.f1166x.setText(this.f1166x.getText().toString().replace(",", ""));
        }
        if (this.f1166x.getText().toString().replaceAll(" ", "").replaceAll("\n", "").replaceAll(",", "").length() == 0) {
            this.f1166x.clearFocus();
            return;
        }
        if (this.f1163u) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_title", this.f1166x.getText().toString());
            contentValues.put("inbox_title_fixed", "Y");
            if (this.f1153k.getContentResolver().update(C0671x.f2315a, contentValues, "inbox_no='" + this.f1168z + "'", null) > 0) {
                C1619g c1619g = new C1619g(getActivity());
                c1619g.setText(R.string.buddy_profile_saveprofile_toast_success);
                c1619g.show();
                this.f1095E = this.f1166x.getText().toString();
            } else {
                C1619g.m5888a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        } else {
            C1619g c1619g2 = new C1619g(getActivity());
            c1619g2.setText(R.string.buddy_profile_saveprofile_toast_success);
            c1619g2.show();
            this.f1092B = this.f1166x.getText().toString();
            this.f1095E = this.f1166x.getText().toString();
        }
        this.f1165w = true;
        this.f1166x.clearFocus();
    }
}
