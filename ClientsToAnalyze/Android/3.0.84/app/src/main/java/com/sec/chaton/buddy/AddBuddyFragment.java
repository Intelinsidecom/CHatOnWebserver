package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.AdaptableEditText;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.C3347i;
import com.sec.common.util.log.collector.C3358h;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class AddBuddyFragment extends Fragment {

    /* renamed from: f */
    private static int f1652f;

    /* renamed from: A */
    private Button f1653A;

    /* renamed from: B */
    private View f1654B;

    /* renamed from: C */
    private View f1655C;

    /* renamed from: D */
    private View f1656D;

    /* renamed from: E */
    private View f1657E;

    /* renamed from: F */
    private View f1658F;

    /* renamed from: G */
    private ViewGroup f1659G;

    /* renamed from: H */
    private ViewGroup f1660H;

    /* renamed from: I */
    private ViewGroup f1661I;

    /* renamed from: J */
    private ViewGroup f1662J;

    /* renamed from: K */
    private TextView f1663K;

    /* renamed from: L */
    private TextView f1664L;

    /* renamed from: M */
    private TextView f1665M;

    /* renamed from: P */
    private ImageButton f1668P;

    /* renamed from: Q */
    private String[] f1669Q;

    /* renamed from: S */
    private String f1671S;

    /* renamed from: T */
    private String f1672T;

    /* renamed from: X */
    private Activity f1676X;

    /* renamed from: Y */
    private String f1677Y;

    /* renamed from: g */
    private int f1686g;

    /* renamed from: h */
    private Map<CharSequence, CharSequence> f1687h;

    /* renamed from: i */
    private Map<CharSequence, CharSequence> f1688i;

    /* renamed from: j */
    private Map<CharSequence, CharSequence> f1689j;

    /* renamed from: k */
    private CharSequence[] f1690k;

    /* renamed from: l */
    private CharSequence[] f1691l;

    /* renamed from: m */
    private CharSequence[] f1692m;

    /* renamed from: n */
    private String f1693n;

    /* renamed from: o */
    private View f1694o;

    /* renamed from: p */
    private AdaptableEditText f1695p;

    /* renamed from: q */
    private ImageButton f1696q;

    /* renamed from: r */
    private TextView f1697r;

    /* renamed from: s */
    private View f1698s;

    /* renamed from: t */
    private AdaptableEditText f1699t;

    /* renamed from: u */
    private TextView f1700u;

    /* renamed from: w */
    private Button f1702w;

    /* renamed from: x */
    private Button f1703x;

    /* renamed from: y */
    private Button f1704y;

    /* renamed from: z */
    private Button f1705z;

    /* renamed from: a */
    final int f1679a = 16;

    /* renamed from: v */
    private ProgressDialog f1701v = null;

    /* renamed from: N */
    private final int f1666N = 1;

    /* renamed from: O */
    private final int f1667O = 2;

    /* renamed from: R */
    private C0520ae f1670R = null;

    /* renamed from: U */
    private final String f1673U = C3159aa.m10962a().m10979a("country_letter", "");

    /* renamed from: V */
    private BuddyRecommendFragment f1674V = new BuddyRecommendFragment();

    /* renamed from: W */
    private TellFriendsFragment f1675W = new TellFriendsFragment();

    /* renamed from: b */
    ContentObserver f1682b = new C0510a(this, new Handler());

    /* renamed from: c */
    View.OnClickListener f1683c = new ViewOnClickListenerC0795j(this);

    /* renamed from: d */
    Handler f1684d = new HandlerC0801p(this);

    /* renamed from: Z */
    private TextWatcher f1678Z = new C0805t(this);

    /* renamed from: aa */
    private TextWatcher f1680aa = new C0806u(this);

    /* renamed from: ab */
    private TextWatcher f1681ab = new C0807v(this);

    /* renamed from: e */
    AdapterView.OnItemClickListener f1685e = new C0808w(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f1676X = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f1676X = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        Cursor cursorQuery;
        int count;
        super.onResume();
        boolean zBooleanValue = C3159aa.m10962a().m10977a("recomned_receive", (Boolean) true).booleanValue();
        this.f1670R.m4014a();
        this.f1676X.getContentResolver().registerContentObserver(C1388af.f5186a, true, this.f1682b);
        if (zBooleanValue) {
            try {
                cursorQuery = this.f1676X.getApplicationContext().getContentResolver().query(C1388af.f5186a, null, "type='200' AND timestamp>" + C3159aa.m10962a().m10976a("recommend_timestamp", 0L), null, null);
                if (cursorQuery != null) {
                    try {
                        count = cursorQuery.getCount();
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } else {
                    count = 0;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                m3198a(count);
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        } else {
            m3198a(0);
        }
        if (!GlobalApplication.m6456e()) {
            if (this.f1695p != null && this.f1695p.hasFocus()) {
                m3167a((EditText) this.f1695p, true);
            }
            if (this.f1699t == null || !this.f1699t.hasFocus()) {
                return;
            }
            m3167a((EditText) this.f1699t, true);
            return;
        }
        if (GlobalApplication.m6458g()) {
            m3197a();
            return;
        }
        if (this.f1695p != null && this.f1695p.hasFocus()) {
            m3167a((EditText) this.f1695p, true);
        }
        if (this.f1699t == null || !this.f1699t.hasFocus()) {
            return;
        }
        m3167a((EditText) this.f1699t, true);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11450b("onCreate..." + getArguments().get("id"), getClass().getSimpleName());
        if (getArguments().getInt("ADD_BUDDY_TYPE") == 101) {
            this.f1686g = 101;
        } else if (getArguments().getInt("ADD_BUDDY_TYPE") == 100) {
            this.f1686g = 100;
        } else if (getArguments().getInt("ADD_BUDDY_TYPE") == 103) {
            this.f1686g = 103;
        } else if (getArguments().getInt("ADD_BUDDY_TYPE") == 102) {
            this.f1686g = 102;
        } else {
            this.f1686g = 100;
        }
        if (getArguments().get("id") instanceof String) {
            this.f1669Q = new String[]{getArguments().getString("id")};
        } else if (getArguments().get("id") instanceof String[]) {
            this.f1669Q = getArguments().getStringArray("id");
        }
        this.f1701v = new ProgressDialogC3265l(this.f1676X, false);
        this.f1701v.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f1687h = new HashMap();
        this.f1688i = new HashMap();
        this.f1689j = new HashMap();
        this.f1690k = getResources().getTextArray(R.array.country);
        this.f1691l = getResources().getTextArray(R.array.country_code);
        this.f1692m = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        for (int i = 0; i < this.f1690k.length; i++) {
            this.f1687h.put(this.f1690k[i], this.f1691l[i]);
            this.f1688i.put(this.f1692m[i], this.f1690k[i]);
            this.f1689j.put(this.f1692m[i], this.f1691l[i]);
        }
        this.f1670R = new C0520ae(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        if (this.f1674V != null) {
            fragmentTransactionBeginTransaction.replace(R.id.layoutAddBuddyBySuggestion, this.f1674V);
            fragmentTransactionBeginTransaction.replace(R.id.layoutAddBuddyByTellFriends, this.f1675W);
            fragmentTransactionBeginTransaction.commit();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException, UnsupportedEncodingException {
        C3250y.m11450b("onCreateView...", getClass().getSimpleName());
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00030020");
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_add_buddy, viewGroup, false);
        ArrayList arrayList = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.tell_friends)));
        if (this.f1676X.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("smsto:9000000000")), 65536).size() < 1) {
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                if (!((String) arrayList.get(i)).equals(getString(R.string.tellfriends_via_message))) {
                    i++;
                } else {
                    arrayList.remove(i);
                    break;
                }
            }
        }
        new C0521af(this, this.f1676X, arrayList);
        this.f1694o = viewInflate.findViewById(R.id.addbuddylayout_search);
        this.f1695p = (AdaptableEditText) this.f1694o.findViewById(R.id.search_edit_text);
        this.f1695p.setFilters(new InputFilter[]{new C3248w(this.f1676X, 20)});
        this.f1696q = (ImageButton) this.f1694o.findViewById(R.id.search_icon);
        this.f1698s = viewInflate.findViewById(R.id.addbuddy_id_layout_search);
        this.f1699t = (AdaptableEditText) this.f1698s.findViewById(R.id.search_edit_text);
        this.f1699t.setFilters(new InputFilter[]{new C3248w(this.f1676X, 64)});
        this.f1668P = (ImageButton) this.f1698s.findViewById(R.id.search_icon);
        this.f1697r = (TextView) viewInflate.findViewById(R.id.editCountryName).findViewById(R.id.text1);
        if (!GlobalApplication.m6456e()) {
            this.f1697r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        }
        this.f1697r.setHint(R.string.regist_select_country_or_region_code);
        this.f1695p.setInputType(2);
        this.f1668P.setEnabled(false);
        this.f1696q.setEnabled(false);
        this.f1695p.addTextChangedListener(this.f1678Z);
        this.f1699t.addTextChangedListener(this.f1678Z);
        this.f1699t.setHint("example@samsung.com");
        if (GlobalApplication.m6456e() && getResources() != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            this.f1699t.setLayoutParams(layoutParams);
            this.f1695p.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(C3172an.m11087c(getResources().getDimension(R.dimen.search_buddy_button_width)), -2);
            this.f1668P.setLayoutParams(layoutParams2);
            this.f1696q.setLayoutParams(layoutParams2);
        }
        this.f1699t.setInputType(209);
        this.f1695p.setOnEditorActionListener(new C0797l(this));
        this.f1668P.setOnClickListener(new ViewOnClickListenerC0809x(this));
        this.f1696q.setOnClickListener(new ViewOnClickListenerC0810y(this));
        this.f1695p.setOnKeyListener(new ViewOnKeyListenerC0811z(this));
        this.f1699t.setOnEditorActionListener(new C0516aa(this));
        this.f1699t.setOnKeyListener(new ViewOnKeyListenerC0517ab(this));
        viewInflate.findViewById(R.id.editCountryName).setOnClickListener(this.f1683c);
        this.f1662J = (ViewGroup) viewInflate.findViewById(R.id.tabAddBuddyBySuggestionFrame);
        this.f1702w = (Button) viewInflate.findViewById(R.id.tabAddBuddyBySuggestion);
        this.f1700u = (TextView) viewInflate.findViewById(R.id.buddy_suggestion_badge);
        this.f1653A = (Button) viewInflate.findViewById(R.id.tabAddBuddyByTellFriends);
        this.f1703x = (Button) viewInflate.findViewById(R.id.tabAddBuddyByPhone);
        this.f1704y = (Button) viewInflate.findViewById(R.id.tabAddBuddyById);
        this.f1702w.setOnClickListener(this.f1683c);
        this.f1653A.setOnClickListener(this.f1683c);
        this.f1703x.setOnClickListener(this.f1683c);
        this.f1704y.setOnClickListener(this.f1683c);
        this.f1703x.setOnKeyListener(new ViewOnKeyListenerC0518ac(this));
        this.f1704y.setOnKeyListener(new ViewOnKeyListenerC0519ad(this));
        this.f1695p.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0542b(this));
        this.f1699t.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0569c(this));
        this.f1654B = viewInflate.findViewById(R.id.layoutAddBuddyBySuggestion);
        this.f1657E = viewInflate.findViewById(R.id.layoutAddBuddyByTellFriends);
        this.f1655C = viewInflate.findViewById(R.id.layoutAddBuddyByPhone);
        this.f1656D = viewInflate.findViewById(R.id.layoutAddBuddyById);
        this.f1659G = (ViewGroup) viewInflate.findViewById(R.id.layoutResultByPhone);
        this.f1660H = (ViewGroup) viewInflate.findViewById(R.id.layoutResultById);
        this.f1663K = (TextView) viewInflate.findViewById(R.id.selectCountryCodeIfDiffers);
        this.f1664L = (TextView) viewInflate.findViewById(R.id.enterPhoneNumber);
        this.f1665M = (TextView) viewInflate.findViewById(R.id.enterSamsungAccountID);
        this.f1663K.setOnTouchListener(new ViewOnTouchListenerC0596d(this));
        this.f1664L.setOnTouchListener(new ViewOnTouchListenerC0662e(this));
        this.f1665M.setOnTouchListener(new ViewOnTouchListenerC0689f(this));
        boolean zBooleanValue = C3159aa.m10962a().m10977a("recomned_receive", (Boolean) true).booleanValue();
        if (!zBooleanValue) {
            this.f1662J.setVisibility(8);
            int paddingTop = this.f1653A.getPaddingTop();
            int paddingBottom = this.f1653A.getPaddingBottom();
            this.f1653A.setBackgroundResource(R.drawable.tab_left_button_background);
            this.f1653A.setPadding(0, paddingTop, 0, paddingBottom);
        }
        int i2 = bundle != null ? bundle.getInt("current_tab") : 0;
        if (this.f1703x.getId() == i2) {
            m3166a(this.f1703x);
        } else if (this.f1704y.getId() == i2) {
            m3166a(this.f1704y);
        } else if (this.f1653A.getId() == i2) {
            m3166a(this.f1653A);
        } else if (this.f1686g == 100) {
            m3166a(this.f1703x);
        } else if (this.f1686g != 103 && zBooleanValue) {
            m3166a(this.f1702w);
        } else {
            m3166a(this.f1653A);
        }
        if (this.f1669Q != null) {
            viewInflate.findViewById(R.id.tabAddBuddyContainer).setVisibility(8);
            viewInflate.findViewById(R.id.inputCountryAndNumberContainer).setVisibility(8);
            m3175a(true);
            m3166a(this.f1703x);
        }
        new C1330h(null).m5732b();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f1682b != null) {
            this.f1676X.getContentResolver().unregisterContentObserver(this.f1682b);
        }
        m3197a();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_tab", m3186e());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x015a  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r12, int r13, android.content.Intent r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.AddBuddyFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            m3184d();
            return;
        }
        if (configuration.orientation == 2) {
            if (this.f1699t != null && this.f1699t.hasFocus() && !TextUtils.isEmpty(this.f1699t.getText().toString())) {
                m3181c();
            } else if (this.f1695p != null && this.f1695p.hasFocus() && !TextUtils.isEmpty(this.f1695p.getText().toString())) {
                m3181c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3181c() {
        if (!GlobalApplication.m6456e() && this.f1676X != null) {
            ((ActionBarFragmentActivity) this.f1676X).m11543k().mo11597f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3184d() {
        if (!GlobalApplication.m6456e() && this.f1676X != null) {
            ((ActionBarFragmentActivity) this.f1676X).m11543k().mo11595e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3174a(String str, String str2) {
        try {
            startActivity(C3347i.m11775a(str, str2));
        } catch (ActivityNotFoundException e) {
            AbstractC3271a.m11494a(this.f1676X).mo11495a(R.string.tellfriends_warning_title).mo11506b(R.string.tellfriends_message_not_supported).mo11511b(false).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0770i(this)).mo11512b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3175a(boolean z) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (this.f1661I != null) {
            this.f1661I.setVisibility(8);
        }
        if (this.f1669Q == null) {
            if (m3186e() == R.id.tabAddBuddyByPhone) {
                m3179b(z);
                return;
            } else {
                m3182c(z);
                return;
            }
        }
        m3185d(z);
    }

    /* renamed from: a */
    public void m3198a(int i) {
        if (this.f1700u != null) {
            if (i > 0) {
                if (i >= 100) {
                    this.f1700u.setText(R.string.chat_max_unread);
                } else {
                    this.f1700u.setText(String.valueOf(i));
                }
                this.f1700u.setVisibility(0);
                return;
            }
            this.f1700u.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m3179b(boolean z) throws UnsupportedEncodingException {
        String strTrim;
        if (z && TextUtils.isEmpty(this.f1695p.getText())) {
            C3250y.m11450b("EditText Phone is empty", getClass().getSimpleName());
            return;
        }
        this.f1701v.show();
        C1330h c1330h = new C1330h(this.f1684d);
        if (this.f1693n == null) {
            if (!TextUtils.isEmpty(this.f1673U)) {
                this.f1693n = String.valueOf(this.f1689j.get(this.f1673U));
                if (this.f1693n != null) {
                    strTrim = this.f1693n + this.f1695p.getText().toString().trim();
                } else {
                    strTrim = this.f1695p.getText().toString().trim();
                }
            } else {
                strTrim = this.f1695p.getText().toString().trim();
            }
        } else {
            strTrim = this.f1693n + this.f1695p.getText().toString().trim();
            C3250y.m11450b("addBuddyInternalByPhone orgnum=" + strTrim + ", country code=" + this.f1693n, getClass().getSimpleName());
        }
        this.f1677Y = (this.f1693n != null ? "+" : "") + strTrim;
        if (z) {
            c1330h.m5738c(strTrim, this.f1693n != null);
        } else {
            c1330h.m5731b(strTrim, this.f1693n != null);
        }
    }

    /* renamed from: c */
    private void m3182c(boolean z) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (z && TextUtils.isEmpty(this.f1699t.getText())) {
            C3250y.m11450b("EditText Id is empty", getClass().getSimpleName());
            return;
        }
        this.f1701v.show();
        String strTrim = this.f1699t.getText().toString().trim();
        C1330h c1330h = new C1330h(this.f1684d);
        if (!strTrim.contains("@") || !strTrim.contains(".")) {
            String string = getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invalid_email);
            this.f1701v.dismiss();
            AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.pop_up_attention)).mo11509b(string).mo11510b(getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo11512b();
        } else {
            C3250y.m11450b("addBuddyInternalById orgnum=" + strTrim, getClass().getSimpleName());
            this.f1677Y = strTrim;
            if (z) {
                c1330h.m5738c(strTrim, false);
            } else {
                c1330h.m5731b(strTrim, false);
            }
        }
    }

    /* renamed from: d */
    private void m3185d(boolean z) throws UnsupportedEncodingException {
        this.f1701v.show();
        String str = this.f1669Q[0];
        C1330h c1330h = new C1330h(this.f1684d);
        if (!TextUtils.isEmpty(this.f1673U)) {
            this.f1693n = String.valueOf(this.f1689j.get(this.f1673U));
        }
        C3250y.m11450b("addBuddyInternalFromIntent orgnum=" + str + ", country code=" + this.f1693n, getClass().getSimpleName());
        this.f1677Y = str;
        if (z) {
            c1330h.m5738c(str, false);
        } else {
            c1330h.m5731b(str, false);
        }
    }

    /* renamed from: e */
    private int m3186e() {
        if (this.f1702w.isSelected()) {
            return this.f1702w.getId();
        }
        if (this.f1653A.isSelected()) {
            return this.f1653A.getId();
        }
        if (this.f1703x.isSelected()) {
            return this.f1703x.getId();
        }
        if (this.f1704y.isSelected()) {
            return this.f1704y.getId();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3166a(View view) {
        if (this.f1658F != null) {
            this.f1658F.setVisibility(8);
        }
        if (this.f1705z != null) {
            this.f1705z.setSelected(false);
        }
        if (view.getId() == this.f1703x.getId()) {
            this.f1705z = this.f1703x;
            this.f1658F = this.f1655C;
            this.f1661I = this.f1659G;
        } else if (view.getId() == this.f1704y.getId()) {
            this.f1705z = this.f1704y;
            this.f1658F = this.f1656D;
            this.f1661I = this.f1660H;
        } else if (view.getId() == this.f1702w.getId()) {
            this.f1705z = this.f1702w;
            this.f1658F = this.f1654B;
            this.f1661I = null;
        } else {
            this.f1705z = this.f1653A;
            this.f1658F = this.f1657E;
            this.f1661I = null;
        }
        this.f1705z.setSelected(true);
        this.f1658F.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3173a(GetBuddyList getBuddyList) {
        this.f1661I.removeAllViews();
        if (getBuddyList != null && getBuddyList.buddy.size() > 0) {
            TextView textView = (TextView) this.f1676X.getLayoutInflater().inflate(R.layout.layout_common_header, this.f1661I, true).findViewById(R.id.text1);
            textView.setText(R.string.results);
            textView.setOnTouchListener(new ViewOnTouchListenerC0796k(this));
            Iterator<Buddy> it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                View viewInflate = this.f1676X.getLayoutInflater().inflate(R.layout.list_item_common_11, this.f1661I, false);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image1);
                imageView.setBackgroundResource(R.drawable.frame_background);
                C3205bt.m11182a(this.f1676X).m11210a(imageView, next.value);
                C3205bt.m11182a(getActivity()).m11227b(next.value);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.text1);
                textView2.setText(next.name);
                textView2.setOnTouchListener(new ViewOnTouchListenerC0798m(this, next));
                int paddingLeft = viewInflate.getPaddingLeft();
                int paddingTop = viewInflate.getPaddingTop();
                int paddingRight = viewInflate.getPaddingRight();
                int paddingBottom = viewInflate.getPaddingBottom();
                if (!GlobalApplication.m6456e()) {
                    viewInflate.setBackgroundResource(R.drawable.listview_selector);
                    viewInflate.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                } else {
                    viewInflate.setPadding(0, paddingTop, paddingRight, paddingBottom);
                }
                if (next.value != null) {
                    this.f1671S = next.value;
                }
                if (next.name != null) {
                    this.f1672T = next.name;
                }
                viewInflate.setOnClickListener(new ViewOnClickListenerC0799n(this));
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.image2);
                imageView2.setImageResource(R.drawable.list_ic_add);
                imageView2.setBackgroundResource(R.drawable.actionbar_item_background);
                imageView2.setFocusable(true);
                imageView2.setOnClickListener(this.f1683c);
                imageView2.setOnTouchListener(new ViewOnTouchListenerC0800o(this));
                this.f1661I.addView(viewInflate);
                if (GlobalApplication.m6456e()) {
                    getActivity().getLayoutInflater().inflate(R.layout.layout_common_divider2, this.f1661I, true);
                }
            }
        }
        this.f1661I.setVisibility(0);
    }

    /* renamed from: a */
    void m3197a() {
        m3167a((EditText) this.f1699t, false);
        m3167a((EditText) this.f1695p, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3167a(EditText editText, boolean z) {
        if (editText != null) {
            if (!GlobalApplication.m6456e() || !GlobalApplication.m6458g()) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f1676X.getSystemService("input_method");
                if (z) {
                    inputMethodManager.showSoftInput(editText, 2);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                }
            }
        }
    }
}
