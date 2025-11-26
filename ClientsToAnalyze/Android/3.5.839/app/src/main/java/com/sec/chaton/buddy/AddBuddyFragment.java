package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.AbstractC0024aj;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.EnumC2129j;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4858bw;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class AddBuddyFragment extends Fragment {

    /* renamed from: e */
    private static int f3506e;

    /* renamed from: A */
    private View f3507A;

    /* renamed from: B */
    private View f3508B;

    /* renamed from: C */
    private View f3509C;

    /* renamed from: D */
    private View f3510D;

    /* renamed from: E */
    private View f3511E;

    /* renamed from: F */
    private ViewGroup f3512F;

    /* renamed from: G */
    private ViewGroup f3513G;

    /* renamed from: H */
    private ViewGroup f3514H;

    /* renamed from: I */
    private ViewGroup f3515I;

    /* renamed from: J */
    private TextView f3516J;

    /* renamed from: K */
    private TextView f3517K;

    /* renamed from: L */
    private TextView f3518L;

    /* renamed from: N */
    private ImageButton f3520N;

    /* renamed from: O */
    private String[] f3521O;

    /* renamed from: Q */
    private String f3523Q;

    /* renamed from: R */
    private String f3524R;

    /* renamed from: V */
    private Activity f3528V;

    /* renamed from: W */
    private String f3529W;

    /* renamed from: f */
    private int f3535f;

    /* renamed from: g */
    private Map<CharSequence, CharSequence> f3536g;

    /* renamed from: h */
    private Map<CharSequence, CharSequence> f3537h;

    /* renamed from: i */
    private Map<CharSequence, CharSequence> f3538i;

    /* renamed from: j */
    private CharSequence[] f3539j;

    /* renamed from: k */
    private CharSequence[] f3540k;

    /* renamed from: l */
    private CharSequence[] f3541l;

    /* renamed from: m */
    private String f3542m;

    /* renamed from: n */
    private View f3543n;

    /* renamed from: o */
    private ClearableEditText f3544o;

    /* renamed from: p */
    private ImageButton f3545p;

    /* renamed from: q */
    private TextView f3546q;

    /* renamed from: r */
    private View f3547r;

    /* renamed from: s */
    private ClearableEditText f3548s;

    /* renamed from: t */
    private TextView f3549t;

    /* renamed from: v */
    private Button f3551v;

    /* renamed from: w */
    private Button f3552w;

    /* renamed from: x */
    private Button f3553x;

    /* renamed from: y */
    private Button f3554y;

    /* renamed from: z */
    private Button f3555z;

    /* renamed from: a */
    final int f3531a = 16;

    /* renamed from: u */
    private ProgressDialog f3550u = null;

    /* renamed from: M */
    private final int f3519M = 2;

    /* renamed from: P */
    private C1112ac f3522P = null;

    /* renamed from: S */
    private final String f3525S = C4809aa.m18104a().m18121a("country_letter", "");

    /* renamed from: T */
    private BuddyRecommendFragment f3526T = new BuddyRecommendFragment();

    /* renamed from: U */
    private TellFriendsFragment f3527U = new TellFriendsFragment();

    /* renamed from: b */
    ContentObserver f3532b = new C1103a(this, new Handler());

    /* renamed from: c */
    View.OnClickListener f3533c = new ViewOnClickListenerC1374i(this);

    /* renamed from: d */
    Handler f3534d = new HandlerC1409o(this);

    /* renamed from: X */
    private TextWatcher f3530X = new C1415u(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f3528V = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f3528V = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f3528V.getContentResolver().registerContentObserver(C2228ap.f7956a, true, this.f3532b);
        if (this.f3522P != null) {
            this.f3522P.m7098a();
        }
        if (this.f3544o != null && this.f3544o.hasFocus() && this.f3508B.equals(this.f3511E)) {
            m6242a(this.f3544o, true);
            return;
        }
        if (this.f3548s != null && this.f3548s.hasFocus() && this.f3509C.equals(this.f3511E)) {
            m6242a(this.f3548s, true);
            return;
        }
        if (this.f3509C.equals(this.f3511E)) {
            if (this.f3544o != null) {
                this.f3544o.setText("");
            }
            if (this.f3548s != null) {
                this.f3548s.requestFocus();
                m6242a(this.f3548s, true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate..." + getArguments().get("id"), getClass().getSimpleName());
        if (getArguments().getInt("ADD_BUDDY_TYPE") == 101) {
            this.f3535f = 101;
        } else if (getArguments().getInt("ADD_BUDDY_TYPE") == 100) {
            this.f3535f = 100;
        } else if (getArguments().getInt("ADD_BUDDY_TYPE") == 103) {
            this.f3535f = 103;
        } else if (getArguments().getInt("ADD_BUDDY_TYPE") == 102) {
            this.f3535f = 102;
        } else {
            this.f3535f = 100;
        }
        if (getArguments().get("id") instanceof String) {
            this.f3521O = new String[]{getArguments().getString("id")};
        } else if (getArguments().get("id") instanceof String[]) {
            this.f3521O = getArguments().getStringArray("id");
        }
        this.f3550u = ProgressDialogC4926s.m18731a(this.f3528V, false);
        this.f3550u.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f3536g = new HashMap();
        this.f3537h = new HashMap();
        this.f3538i = new HashMap();
        this.f3539j = getResources().getTextArray(R.array.country);
        this.f3540k = getResources().getTextArray(R.array.country_code);
        this.f3541l = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        for (int i = 0; i < this.f3539j.length; i++) {
            this.f3536g.put(this.f3539j[i], this.f3540k[i]);
            this.f3537h.put(this.f3541l[i], this.f3539j[i]);
            this.f3538i.put(this.f3541l[i], this.f3540k[i]);
        }
        this.f3522P = new C1112ac(this);
        AbstractC0024aj abstractC0024ajMo183a = getFragmentManager().mo183a();
        if (this.f3526T != null) {
            if (C4809aa.m18104a().m18119a("recomned_receive", (Boolean) true).booleanValue()) {
                abstractC0024ajMo183a.mo100b(R.id.layoutAddBuddyBySuggestion, this.f3526T);
            }
            abstractC0024ajMo183a.mo100b(R.id.layoutAddBuddyByTellFriends, this.f3527U);
            abstractC0024ajMo183a.mo99b();
        }
        if (getArguments().getBoolean("ENTRY_THROUGH_DEEP_LINK")) {
            new C2128i(null).m9530g();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        C4904y.m18639b("onCreateView...", getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_add_buddy, viewGroup, false);
        this.f3543n = viewInflate.findViewById(R.id.addbuddylayout_search);
        this.f3544o = (ClearableEditText) this.f3543n.findViewById(R.id.search_edit_text);
        this.f3544o.setFilters(new InputFilter[]{new C4902w(this.f3528V, 20)});
        this.f3545p = (ImageButton) this.f3543n.findViewById(R.id.search_icon);
        this.f3545p.setContentDescription(getString(R.string.join_country_search_hint));
        this.f3547r = viewInflate.findViewById(R.id.addbuddy_id_layout_search);
        this.f3548s = (ClearableEditText) this.f3547r.findViewById(R.id.search_edit_text);
        this.f3548s.setFilters(new InputFilter[]{new C4902w(this.f3528V, 64)});
        this.f3520N = (ImageButton) this.f3547r.findViewById(R.id.search_icon);
        this.f3520N.setContentDescription(getString(R.string.join_country_search_hint));
        this.f3546q = (TextView) viewInflate.findViewById(R.id.editCountryName).findViewById(R.id.text1);
        this.f3546q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        this.f3546q.setHint(R.string.regist_select_country_or_region_code);
        this.f3544o.setInputType(2);
        this.f3520N.setEnabled(false);
        this.f3545p.setEnabled(false);
        this.f3544o.m18659a(this.f3530X);
        this.f3548s.m18659a(this.f3530X);
        this.f3548s.setHint("example@samsung.com");
        this.f3548s.setSearchIcon(0);
        this.f3548s.setInputType(209);
        this.f3544o.setOnEditorActionListener(new C1406l(this));
        this.f3520N.setOnClickListener(new ViewOnClickListenerC1416v(this));
        this.f3545p.setOnClickListener(new ViewOnClickListenerC1417w(this));
        this.f3544o.setOnKeyListener(new ViewOnKeyListenerC1418x(this));
        this.f3548s.setOnEditorActionListener(new C1419y(this));
        this.f3548s.setOnKeyListener(new ViewOnKeyListenerC1420z(this));
        this.f3548s.setClearButtonClickListener(new ViewOnClickListenerC1110aa(this));
        this.f3544o.setClearButtonClickListener(new ViewOnClickListenerC1111ab(this));
        viewInflate.findViewById(R.id.editCountryName).setOnClickListener(this.f3533c);
        this.f3515I = (ViewGroup) viewInflate.findViewById(R.id.tabAddBuddyBySuggestionFrame);
        this.f3551v = (Button) viewInflate.findViewById(R.id.tabAddBuddyBySuggestion);
        this.f3549t = (TextView) viewInflate.findViewById(R.id.buddy_suggestion_badge);
        this.f3555z = (Button) viewInflate.findViewById(R.id.tabAddBuddyByTellFriends);
        this.f3552w = (Button) viewInflate.findViewById(R.id.tabAddBuddyByPhone);
        this.f3553x = (Button) viewInflate.findViewById(R.id.tabAddBuddyById);
        this.f3551v.setOnClickListener(this.f3533c);
        this.f3555z.setOnClickListener(this.f3533c);
        this.f3552w.setOnClickListener(this.f3533c);
        this.f3553x.setOnClickListener(this.f3533c);
        this.f3552w.setOnKeyListener(new ViewOnKeyListenerC1136b(this));
        this.f3553x.setOnKeyListener(new ViewOnKeyListenerC1163c(this));
        this.f3544o.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1190d(this));
        this.f3548s.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1266e(this));
        this.f3507A = viewInflate.findViewById(R.id.layoutAddBuddyBySuggestion);
        this.f3510D = viewInflate.findViewById(R.id.layoutAddBuddyByTellFriends);
        this.f3508B = viewInflate.findViewById(R.id.layoutAddBuddyByPhone);
        this.f3509C = viewInflate.findViewById(R.id.layoutAddBuddyById);
        this.f3512F = (ViewGroup) viewInflate.findViewById(R.id.layoutResultByPhone);
        this.f3513G = (ViewGroup) viewInflate.findViewById(R.id.layoutResultById);
        this.f3516J = (TextView) viewInflate.findViewById(R.id.selectCountryCodeIfDiffers);
        this.f3517K = (TextView) viewInflate.findViewById(R.id.enterPhoneNumber);
        this.f3518L = (TextView) viewInflate.findViewById(R.id.enterSamsungAccountID);
        this.f3516J.setOnTouchListener(new ViewOnTouchListenerC1293f(this));
        this.f3517K.setOnTouchListener(new ViewOnTouchListenerC1320g(this));
        this.f3518L.setOnTouchListener(new ViewOnTouchListenerC1347h(this));
        boolean zBooleanValue = C4809aa.m18104a().m18119a("recomned_receive", (Boolean) true).booleanValue();
        if (!zBooleanValue) {
            this.f3515I.setVisibility(8);
            int paddingTop = this.f3555z.getPaddingTop();
            int paddingBottom = this.f3555z.getPaddingBottom();
            this.f3555z.setBackgroundResource(R.drawable.tab_left_button_background);
            this.f3555z.setPadding(0, paddingTop, 0, paddingBottom);
        }
        int i = bundle != null ? bundle.getInt("current_tab") : 0;
        if (this.f3552w.getId() == i) {
            m6237a(this.f3552w);
        } else if (this.f3553x.getId() == i) {
            m6237a(this.f3553x);
        } else if (this.f3555z.getId() == i) {
            m6237a(this.f3555z);
        } else if (this.f3535f == 100) {
            m6237a(this.f3552w);
        } else if (this.f3535f != 103 && zBooleanValue) {
            m6237a(this.f3551v);
        } else {
            m6237a(this.f3555z);
        }
        if (this.f3521O != null) {
            viewInflate.findViewById(R.id.tabAddBuddyContainer).setVisibility(8);
            viewInflate.findViewById(R.id.inputCountryAndNumberContainer).setVisibility(8);
            m6243a(true);
            m6237a(this.f3552w);
        }
        new C2128i(null).m9509b();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f3532b != null) {
            this.f3528V.getContentResolver().unregisterContentObserver(this.f3532b);
        }
        m6267a();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_tab", m6254e());
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        getResources().getString(R.string.setting_chaton_tell_friends_email_text, "\nwww.chaton.com/invite.html");
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (i2 == -1 && this.f3514H != null) {
                        this.f3514H.setVisibility(8);
                        break;
                    }
                    break;
                case 16:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("PARAMS_COUNTRY_NAME");
                    if (string != null) {
                        String strValueOf = String.valueOf(this.f3537h.get(string));
                        this.f3542m = String.valueOf(this.f3536g.get(strValueOf));
                        this.f3546q.setText(strValueOf + " (+" + this.f3542m + ")");
                        C4904y.m18639b("[addBuddy] mCountryCallingCode : " + this.f3542m + " selectedCountryName : " + strValueOf, getClass().getSimpleName());
                        break;
                    } else {
                        String string2 = extras.getString("PARAMS_COUNTRY_CODE");
                        this.f3546q.setText("");
                        this.f3542m = string2;
                        break;
                    }
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            m6252d();
            return;
        }
        if (configuration.orientation == 2) {
            if (this.f3548s != null && this.f3548s.hasFocus() && !TextUtils.isEmpty(this.f3548s.m18658a().toString())) {
                m6249c();
            } else if (this.f3544o != null && this.f3544o.hasFocus() && !TextUtils.isEmpty(this.f3544o.m18658a().toString())) {
                m6249c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6249c() {
        if (this.f3528V != null) {
            ((ActionBarFragmentActivity) this.f3528V).m18784t().mo18837f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6252d() {
        if (this.f3528V != null) {
            ((ActionBarFragmentActivity) this.f3528V).m18784t().mo18835e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6243a(boolean z) throws Resources.NotFoundException {
        if (this.f3514H != null) {
            this.f3514H.setVisibility(8);
        }
        if (this.f3521O == null) {
            if (m6254e() == R.id.tabAddBuddyByPhone) {
                m6247b(z);
                return;
            } else {
                m6250c(z);
                return;
            }
        }
        m6253d(z);
    }

    /* renamed from: a */
    public void m6268a(int i) {
        if (this.f3549t != null) {
            if (i > 0) {
                if (i >= 100) {
                    this.f3549t.setText(R.string.chat_max_unread);
                } else {
                    this.f3549t.setText(String.valueOf(i));
                }
                this.f3549t.setVisibility(0);
                return;
            }
            this.f3549t.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m6247b(boolean z) {
        String strTrim;
        if (z && TextUtils.isEmpty(this.f3544o.m18658a())) {
            C4904y.m18639b("EditText Phone is empty", getClass().getSimpleName());
            return;
        }
        this.f3550u.show();
        C2128i c2128i = new C2128i(this.f3534d);
        if (this.f3542m == null) {
            if (!TextUtils.isEmpty(this.f3525S)) {
                this.f3542m = String.valueOf(this.f3538i.get(this.f3525S));
                if (this.f3542m != null) {
                    strTrim = this.f3542m + this.f3544o.m18658a().toString().trim();
                } else {
                    strTrim = this.f3544o.m18658a().toString().trim();
                }
            } else {
                strTrim = this.f3544o.m18658a().toString().trim();
            }
        } else {
            strTrim = this.f3542m + this.f3544o.m18658a().toString().trim();
            C4904y.m18639b("addBuddyInternalByPhone orgnum=" + strTrim + ", country code=" + this.f3542m, getClass().getSimpleName());
        }
        this.f3529W = (this.f3542m != null ? "+" : "") + strTrim;
        if (z) {
            c2128i.m9514c(strTrim, this.f3542m != null);
        } else {
            c2128i.m9494a(strTrim, this.f3542m != null, EnumC2463n.UI);
        }
    }

    /* renamed from: c */
    private void m6250c(boolean z) throws Resources.NotFoundException {
        if (z && TextUtils.isEmpty(this.f3548s.m18658a())) {
            C4904y.m18639b("EditText Id is empty", getClass().getSimpleName());
            return;
        }
        this.f3550u.show();
        String strTrim = this.f3548s.m18658a().toString().trim();
        C2128i c2128i = new C2128i(this.f3534d);
        EnumC2129j enumC2129jM6235a = m6235a(strTrim);
        if (enumC2129jM6235a == EnumC2129j.NONE) {
            String string = getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_email);
            this.f3550u.dismiss();
            AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(string).mo18755c(getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("addBuddyInternalById orgnum=" + strTrim, getClass().getSimpleName());
        }
        this.f3529W = strTrim;
        if (z) {
            c2128i.m9490a(strTrim, enumC2129jM6235a);
        } else {
            c2128i.m9492a(strTrim, enumC2129jM6235a, EnumC2463n.UI);
        }
    }

    /* renamed from: d */
    private void m6253d(boolean z) {
        this.f3550u.show();
        String str = this.f3521O[0];
        C2128i c2128i = new C2128i(this.f3534d);
        if (!TextUtils.isEmpty(this.f3525S)) {
            this.f3542m = String.valueOf(this.f3538i.get(this.f3525S));
        }
        C4904y.m18639b("addBuddyInternalFromIntent orgnum=" + str + ", country code=" + this.f3542m, getClass().getSimpleName());
        this.f3529W = str;
        if (z) {
            c2128i.m9514c(str, false);
        } else {
            c2128i.m9494a(str, false, EnumC2463n.UI);
        }
    }

    /* renamed from: a */
    private EnumC2129j m6235a(String str) {
        EnumC2129j enumC2129j = EnumC2129j.NONE;
        if (C4858bw.m18368a(str)) {
            return EnumC2129j.EMAIL;
        }
        return enumC2129j;
    }

    /* renamed from: e */
    private int m6254e() {
        if (this.f3551v.isSelected()) {
            return this.f3551v.getId();
        }
        if (this.f3555z.isSelected()) {
            return this.f3555z.getId();
        }
        if (this.f3552w.isSelected()) {
            return this.f3552w.getId();
        }
        if (this.f3553x.isSelected()) {
            return this.f3553x.getId();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6237a(View view) {
        if (this.f3554y != null && view.getId() != this.f3554y.getId()) {
            this.f3511E.setVisibility(8);
            this.f3554y.setSelected(false);
            m6257f();
        } else if (this.f3554y != null) {
            return;
        }
        m6267a();
        if (view.getId() == this.f3552w.getId()) {
            this.f3554y = this.f3552w;
            this.f3511E = this.f3508B;
            this.f3514H = this.f3512F;
            m6242a(this.f3544o, true);
        } else if (view.getId() == this.f3553x.getId()) {
            this.f3554y = this.f3553x;
            this.f3511E = this.f3509C;
            this.f3514H = this.f3513G;
            m6242a(this.f3548s, true);
        } else if (view.getId() == this.f3551v.getId()) {
            this.f3554y = this.f3551v;
            this.f3511E = this.f3507A;
            this.f3514H = null;
        } else {
            this.f3554y = this.f3555z;
            this.f3511E = this.f3510D;
            this.f3514H = null;
        }
        this.f3554y.setSelected(true);
        this.f3511E.setVisibility(0);
    }

    /* renamed from: f */
    private void m6257f() {
        if (this.f3548s != null) {
            this.f3548s.setText("");
        }
        if (this.f3544o != null) {
            this.f3544o.setText("");
        }
        if (this.f3514H != null) {
            this.f3514H.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6241a(GetBuddyList getBuddyList) {
        this.f3514H.removeAllViews();
        if (getBuddyList != null && getBuddyList.buddy.size() > 0) {
            TextView textView = (TextView) this.f3528V.getLayoutInflater().inflate(R.layout.layout_common_header, this.f3514H, true).findViewById(R.id.text1);
            textView.setText(R.string.results);
            textView.setOnTouchListener(new ViewOnTouchListenerC1401j(this));
            Iterator<Buddy> it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                View viewInflate = this.f3528V.getLayoutInflater().inflate(R.layout.list_item_common_11, this.f3514H, false);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image1);
                imageView.setBackgroundResource(R.drawable.circle_background);
                C2496n.m10765a(imageView, next.value, EnumC2498p.ROUND);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.text1);
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setText(next.name);
                textView2.setOnTouchListener(new ViewOnTouchListenerC1405k(this, next));
                int paddingLeft = viewInflate.getPaddingLeft();
                int paddingTop = viewInflate.getPaddingTop();
                int paddingRight = viewInflate.getPaddingRight();
                int paddingBottom = viewInflate.getPaddingBottom();
                viewInflate.setBackgroundResource(R.drawable.listview_selector);
                viewInflate.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                if (next.value != null) {
                    this.f3523Q = next.value;
                }
                if (next.name != null) {
                    this.f3524R = next.name;
                }
                imageView.setOnClickListener(new ViewOnClickListenerC1407m(this));
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.image2);
                imageView.setBackgroundResource(R.drawable.circle_background);
                imageView.setFocusable(true);
                imageView2.setImageResource(R.drawable.list_ic_add);
                imageView2.setContentDescription(getResources().getString(R.string.buddy_add_contact));
                imageView2.setBackgroundResource(R.drawable.actionbar_item_background);
                imageView2.setFocusable(true);
                imageView2.setOnClickListener(this.f3533c);
                imageView2.setOnTouchListener(new ViewOnTouchListenerC1408n(this));
                this.f3514H.addView(viewInflate);
            }
        }
        this.f3514H.setVisibility(0);
    }

    /* renamed from: a */
    void m6267a() {
        m6242a(this.f3548s, false);
        m6242a(this.f3544o, false);
    }

    /* renamed from: a */
    private void m6242a(ClearableEditText clearableEditText, boolean z) {
        if (clearableEditText != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f3528V.getSystemService("input_method");
            if (z) {
                clearableEditText.requestFocus();
                inputMethodManager.showSoftInput(clearableEditText.findViewById(R.id.clearable_text1), 2);
            } else {
                inputMethodManager.hideSoftInputFromWindow(clearableEditText.getWindowToken(), 0);
            }
        }
    }
}
