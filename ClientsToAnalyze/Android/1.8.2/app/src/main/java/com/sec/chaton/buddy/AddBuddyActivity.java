package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.sec.chaton.C0229at;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.BuddyRecommendActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p028io.entry.GetBuddyList;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.registration.CountryActivity;
import com.sec.chaton.util.C1739av;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.common.p056b.C1816b;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class AddBuddyActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private Menu f842a = null;

    /* renamed from: b */
    private AddBuddyFragment f843b = null;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        this.f843b = new AddBuddyFragment();
        return this.f843b;
    }

    /* renamed from: c */
    public Menu m1860c() {
        return this.f842a;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f()) {
            if (Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
            }
            getWindow().setLayout(798, 738);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() != R.id.actionbar_title_done || this.f843b == null) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f843b.f886y.removeAllViews();
        this.f843b.m1874b();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.removeItem(R.id.actionbar_title_next);
        menu.removeItem(R.id.actionbar_title_cancel);
        menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
        menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        this.f842a = menu;
        return true;
    }

    public class AddBuddyFragment extends Fragment implements View.OnClickListener {

        /* renamed from: M */
        private static int f844M;

        /* renamed from: A */
        private TextView f845A;

        /* renamed from: B */
        private String f846B;

        /* renamed from: C */
        private String f847C;

        /* renamed from: D */
        private TextView f848D;

        /* renamed from: F */
        private TextView f850F;

        /* renamed from: G */
        private TextView f851G;

        /* renamed from: H */
        private TextView f852H;

        /* renamed from: I */
        private TextView f853I;

        /* renamed from: J */
        private TabHost f854J;

        /* renamed from: K */
        private TabWidget f855K;

        /* renamed from: O */
        private String f858O;

        /* renamed from: P */
        private AbstractRunnableC0532a f859P;

        /* renamed from: b */
        public boolean f863b;

        /* renamed from: e */
        private Map f866e;

        /* renamed from: f */
        private Map f867f;

        /* renamed from: g */
        private CharSequence[] f868g;

        /* renamed from: h */
        private CharSequence[] f869h;

        /* renamed from: i */
        private CharSequence[] f870i;

        /* renamed from: j */
        private String f871j;

        /* renamed from: k */
        private EditText f872k;

        /* renamed from: l */
        private TextView f873l;

        /* renamed from: m */
        private TextView f874m;

        /* renamed from: n */
        private EditText f875n;

        /* renamed from: o */
        private ImageButton f876o;

        /* renamed from: q */
        private View f878q;

        /* renamed from: r */
        private View f879r;

        /* renamed from: s */
        private View f880s;

        /* renamed from: t */
        private View f881t;

        /* renamed from: u */
        private ViewGroup f882u;

        /* renamed from: v */
        private ViewGroup f883v;

        /* renamed from: w */
        private ViewGroup f884w;

        /* renamed from: x */
        private ViewGroup f885x;

        /* renamed from: y */
        private ViewGroup f886y;

        /* renamed from: z */
        private TextView f887z;

        /* renamed from: a */
        final int f862a = 16;

        /* renamed from: p */
        private ProgressDialog f877p = null;

        /* renamed from: E */
        private final int f849E = 1;

        /* renamed from: L */
        private String f856L = "Phone Number";

        /* renamed from: N */
        private C0441q f857N = null;

        /* renamed from: c */
        ContentObserver f864c = new C0254a(this, new Handler());

        /* renamed from: d */
        Handler f865d = new HandlerC0342d(this);

        /* renamed from: Q */
        private TextWatcher f860Q = new C0396f(this);

        /* renamed from: R */
        private TextWatcher f861R = new C0416g(this);

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            C1786r.m6061b("onCreate...", getClass().getSimpleName());
            this.f877p = new ProgressDialogC1806j(getActivity(), true);
            this.f877p.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            this.f877p.setOnCancelListener(new DialogInterfaceOnCancelListenerC0433i(this));
            this.f866e = new HashMap();
            this.f867f = new HashMap();
            this.f868g = getResources().getTextArray(R.array.country);
            this.f869h = getResources().getTextArray(R.array.country_code);
            this.f870i = getResources().getTextArray(R.array.ISO_country_code_Letter2);
            for (int i = 0; i < this.f868g.length; i++) {
                this.f866e.put(this.f868g[i], this.f869h[i]);
                this.f867f.put(this.f870i[i], this.f868g[i]);
            }
            this.f857N = new C0441q(this);
            getActivity().getContentResolver().registerContentObserver(C0702q.f2645a, true, this.f864c);
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            boolean z = C1789u.m6075a().getBoolean("recomned_receive", true);
            this.f857N.m2440a();
            if (z) {
                Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0702q.f2645a, null, "type='200'", null, null);
                int count = cursorQuery.getCount();
                cursorQuery.close();
                m1891a(count);
                return;
            }
            if (!z) {
                m1891a(0);
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            C1786r.m6061b("onCreateView...", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(R.layout.layout_add_buddy, viewGroup, false);
            int i = getActivity().getIntent().hasExtra("ADD_BUDDY_DEFAULT_TAB") ? getActivity().getIntent().getExtras().getInt("ADD_BUDDY_DEFAULT_TAB") : 0;
            this.f854J = (TabHost) viewInflate.findViewById(R.id.tabhost);
            this.f855K = (TabWidget) viewInflate.findViewById(android.R.id.tabs);
            this.f873l = (TextView) viewInflate.findViewById(R.id.editCountryCode);
            this.f874m = (TextView) viewInflate.findViewById(R.id.editCountryName);
            this.f872k = (EditText) viewInflate.findViewById(R.id.editPno);
            this.f875n = (EditText) viewInflate.findViewById(R.id.editId);
            this.f872k.addTextChangedListener(this.f861R);
            this.f875n.addTextChangedListener(this.f860Q);
            this.f872k.setOnEditorActionListener(new C0434j(this));
            this.f875n.setOnEditorActionListener(new C0435k(this));
            if (viewInflate.findViewById(R.id.btnCancel) != null) {
                this.f876o = (ImageButton) viewInflate.findViewById(R.id.btnCancel);
                this.f876o.setOnClickListener(this);
            }
            viewInflate.findViewById(R.id.pickCountry).setOnClickListener(this);
            this.f878q = viewInflate.findViewById(R.id.layoutAddBuddyByPhone);
            this.f879r = viewInflate.findViewById(R.id.layoutAddBuddyById);
            this.f880s = viewInflate.findViewById(R.id.layoutTellFriends);
            this.f881t = viewInflate.findViewById(R.id.layoutAddBuddyBySuggestions);
            this.f881t.setVisibility(0);
            this.f882u = (ViewGroup) viewInflate.findViewById(R.id.layoutResultByPhone);
            this.f883v = (ViewGroup) viewInflate.findViewById(R.id.layoutResultById);
            this.f884w = (ViewGroup) viewInflate.findViewById(R.id.layoutTellFriends);
            this.f885x = (ViewGroup) viewInflate.findViewById(R.id.layoutAddBuddyBySuggestions);
            this.f850F = (TextView) viewInflate.findViewById(R.id.tellfriends_via_message);
            this.f851G = (TextView) viewInflate.findViewById(R.id.tellfriends_via_facebook);
            this.f852H = (TextView) viewInflate.findViewById(R.id.tellfriends_via_twitter);
            this.f853I = (TextView) viewInflate.findViewById(R.id.tellfriends_via_weibo);
            if (getActivity().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("smsto:9000000000")), 65536).size() < 1) {
                this.f850F.setEnabled(false);
            }
            C0452a.m2470c();
            if (!C0452a.m2471d()) {
                this.f851G.setEnabled(false);
                this.f852H.setEnabled(false);
            }
            this.f850F.setOnClickListener(new ViewOnClickListenerC0436l(this));
            this.f851G.setOnClickListener(new ViewOnClickListenerC0437m(this));
            this.f852H.setOnClickListener(new ViewOnClickListenerC0438n(this));
            this.f853I.setOnClickListener(new ViewOnClickListenerC0439o(this));
            this.f854J.setup();
            this.f854J.setOnTabChangedListener(new C0440p(this));
            m1883d(layoutInflater);
            m1864a(layoutInflater);
            m1875b(layoutInflater);
            m1880c(layoutInflater);
            int i2 = bundle != null ? bundle.getInt("current_tab") : 0;
            if (R.id.layoutAddBuddyById == i2) {
                m1865a(viewInflate.findViewById(R.id.layoutAddBuddyById));
            } else if (R.id.layoutTellFriends == i2 || R.id.layoutAddBuddyBySuggestions == i2) {
                m1865a(viewInflate.findViewById(R.id.layoutTellFriends));
            } else {
                m1865a(viewInflate.findViewById(R.id.layoutAddBuddyByPhone));
            }
            if (i == 3) {
                m1865a(viewInflate.findViewById(R.id.layoutTellFriends));
            }
            this.f854J.setCurrentTab(i);
            this.f845A = (TextView) viewInflate.findViewById(R.id.buddy_found2);
            this.f887z = (TextView) viewInflate.findViewById(R.id.buddy_found);
            FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
            BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment = new BuddyRecommendActivity.BuddyRecommendFragment();
            if (buddyRecommendFragment != null) {
                fragmentTransactionBeginTransaction.replace(R.id.layoutAddBuddyBySuggestion, buddyRecommendFragment);
                fragmentTransactionBeginTransaction.commit();
            }
            return viewInflate;
        }

        /* renamed from: a */
        private void m1864a(LayoutInflater layoutInflater) {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f855K, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            if (!GlobalApplication.m3265f()) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_chat_background));
            }
            textView.setText(getString(R.string.add_buddy_phone_number));
            textView.setTextColor(getResources().getColorStateList(R.drawable.tab_title_font_color));
            this.f854J.addTab(this.f854J.newTabSpec("Phone Number").setIndicator(relativeLayout).setContent(R.id.layoutAddBuddyByPhone));
        }

        /* renamed from: b */
        private void m1875b(LayoutInflater layoutInflater) {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f855K, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            if (!GlobalApplication.m3265f()) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_chat_background));
            }
            textView.setText(getString(R.string.add_buddy_search_by_id));
            textView.setTextColor(getResources().getColorStateList(R.drawable.tab_title_font_color));
            this.f854J.addTab(this.f854J.newTabSpec("Search by ID").setIndicator(relativeLayout).setContent(R.id.layoutAddBuddyById));
        }

        /* renamed from: c */
        private void m1880c(LayoutInflater layoutInflater) {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f855K, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            if (!GlobalApplication.m3265f()) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_chat_background));
            }
            textView.setText(getString(R.string.settings_invite_friend));
            textView.setTextColor(getResources().getColorStateList(R.drawable.tab_title_font_color));
            this.f854J.addTab(this.f854J.newTabSpec("Tellfriends").setIndicator(relativeLayout).setContent(R.id.layoutTellFriends));
        }

        /* renamed from: d */
        private void m1883d(LayoutInflater layoutInflater) {
            RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f855K, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            this.f848D = (TextView) relativeLayout.findViewById(R.id.tab_badge);
            if (!GlobalApplication.m3265f()) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_chat_background));
            }
            textView.setText(getString(R.string.recommendation));
            textView.setTextColor(getResources().getColorStateList(R.drawable.tab_title_font_color));
            this.f854J.addTab(this.f854J.newTabSpec("Suggestions").setIndicator(relativeLayout).setContent(R.id.layoutAddBuddyBySuggestions));
        }

        @Override // android.support.v4.app.Fragment
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
            String string = null;
            if (i2 == -1) {
                String string2 = getResources().getString(R.string.tellfriends_post_message);
                switch (i) {
                    case 1:
                        if (i2 == -1) {
                            Cursor cursorManagedQuery = getActivity().managedQuery(intent.getData(), null, null, null, null);
                            if (cursorManagedQuery.moveToFirst()) {
                                String string3 = cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("display_name"));
                                String string4 = cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("_id"));
                                if (cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("has_phone_number")).equals("1")) {
                                    Cursor cursorQuery = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + string4, null, null);
                                    ArrayList arrayList = new ArrayList();
                                    while (cursorQuery.moveToNext()) {
                                        string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                                        arrayList.add(string);
                                    }
                                    if (arrayList.size() == 1) {
                                        m1871a(string, string2);
                                        break;
                                    } else {
                                        new AlertDialogBuilderC2120a(getActivity()).setTitle(string3).setItems((CharSequence[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterfaceOnClickListenerC0285b(this, arrayList, string2)).show();
                                        break;
                                    }
                                } else {
                                    new AlertDialogBuilderC2120a(getActivity()).setMessage(R.string.vcard_nocontact_message).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0315c(this)).show();
                                    break;
                                }
                            }
                        }
                        break;
                    case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                        Bundle extras = intent.getExtras();
                        String string5 = extras.getString("PARAMS_COUNTRY_NAME");
                        if (string5 != null) {
                            this.f871j = String.valueOf(this.f866e.get(string5));
                            this.f873l.setText(" (+" + this.f871j + ")");
                            this.f874m.setText(string5);
                            C1786r.m6061b("[addBuddy] mCountryCallingCode : " + this.f871j + " selectedCountryName : " + string5, getClass().getSimpleName());
                            if (GlobalApplication.m3265f()) {
                                C1789u.m6075a().edit().putString("last_add_buddy_country", string5).commit();
                                C1789u.m6075a().edit().putString("last_add_buddy_country_code", String.valueOf(this.f866e.get(string5))).commit();
                                break;
                            }
                        } else {
                            String string6 = extras.getString("PARAMS_COUNTRY_CODE");
                            this.f874m.setText("");
                            this.f871j = string6;
                            this.f873l.setText(" (+" + string6 + ")");
                            break;
                        }
                        break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m1874b() {
            m1872a(this.f886y.getChildCount() == 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1872a(boolean z) {
            this.f863b = false;
            this.f877p.show();
            this.f877p.setCancelable(z);
            this.f877p.setCanceledOnTouchOutside(false);
            if (this.f856L == "Phone Number") {
                m1877b(z);
            } else {
                m1881c(z);
            }
        }

        /* renamed from: b */
        private void m1877b(boolean z) {
            String string;
            String strTrim;
            if (z) {
                string = this.f872k.getText().toString();
            } else {
                string = this.f846B;
            }
            C0633e c0633e = new C0633e(this.f865d);
            if (this.f871j != null) {
                strTrim = this.f871j + string.trim();
            } else {
                strTrim = string.trim();
            }
            C1786r.m6061b("addBuddyInternalByPhone orgnum=" + strTrim + ", country code=" + this.f871j, getClass().getSimpleName());
            this.f858O = (this.f871j != null ? "+" : "") + strTrim;
            if (!z) {
                c0633e.m2869b(strTrim, this.f871j != null);
            } else {
                this.f859P = c0633e.m2871c(strTrim, this.f871j != null);
            }
        }

        /* renamed from: c */
        private void m1881c(boolean z) {
            String strTrim;
            if (z) {
                strTrim = this.f875n.getText().toString().trim();
            } else {
                strTrim = this.f847C.trim();
            }
            C0633e c0633e = new C0633e(this.f865d);
            C1786r.m6061b("addBuddyInternalById orgnum=" + strTrim, getClass().getSimpleName());
            this.f858O = strTrim;
            if (z) {
                this.f859P = c0633e.m2871c(strTrim, false);
            } else {
                c0633e.m2869b(strTrim, false);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C1739av.m5927a()) {
                switch (view.getId()) {
                    case R.id.btnCancel /* 2131493037 */:
                        this.f872k.setText("");
                        break;
                    case R.id.pickCountry /* 2131493475 */:
                        startActivityForResult(new Intent(getActivity(), (Class<?>) CountryActivity.class), 16);
                        break;
                    case R.id.listItemButton /* 2131493961 */:
                        m1874b();
                        break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1865a(View view) {
            Menu menuM1860c;
            Menu menuM1860c2;
            Menu menuM1860c3;
            Menu menuM1860c4;
            if (view.getId() == R.id.layoutAddBuddyByPhone) {
                this.f886y = this.f882u;
                AddBuddyActivity addBuddyActivity = (AddBuddyActivity) getActivity();
                if (addBuddyActivity != null && (menuM1860c4 = addBuddyActivity.m1860c()) != null) {
                    boolean z = !TextUtils.isEmpty(this.f872k.getText());
                    MenuItem menuItemFindItem = menuM1860c4.findItem(R.id.actionbar_title_done);
                    MenuItem menuItemFindItem2 = menuM1860c4.findItem(R.id.actionbar_title_done_dim);
                    if (z) {
                        if (menuItemFindItem != null) {
                            menuItemFindItem.setVisible(true).setEnabled(true);
                        }
                        if (menuItemFindItem2 != null) {
                            menuItemFindItem2.setVisible(false).setEnabled(false);
                            return;
                        }
                        return;
                    }
                    if (menuItemFindItem != null) {
                        menuItemFindItem.setVisible(false).setEnabled(false);
                    }
                    if (menuItemFindItem2 != null) {
                        menuItemFindItem2.setVisible(true).setEnabled(false);
                        return;
                    }
                    return;
                }
                return;
            }
            if (view.getId() == R.id.layoutTellFriends) {
                m1879c();
                this.f886y = this.f884w;
                AddBuddyActivity addBuddyActivity2 = (AddBuddyActivity) getActivity();
                if (addBuddyActivity2 != null && (menuM1860c3 = addBuddyActivity2.m1860c()) != null) {
                    MenuItem menuItemFindItem3 = menuM1860c3.findItem(R.id.actionbar_title_done);
                    MenuItem menuItemFindItem4 = menuM1860c3.findItem(R.id.actionbar_title_done_dim);
                    if (menuItemFindItem3 != null) {
                        menuItemFindItem3.setVisible(false).setEnabled(false);
                    }
                    if (menuItemFindItem4 != null) {
                        menuItemFindItem4.setVisible(true).setEnabled(false);
                        return;
                    }
                    return;
                }
                return;
            }
            if (view.getId() == R.id.layoutAddBuddyBySuggestions) {
                m1879c();
                this.f886y = this.f885x;
                AddBuddyActivity addBuddyActivity3 = (AddBuddyActivity) getActivity();
                if (addBuddyActivity3 != null && (menuM1860c2 = addBuddyActivity3.m1860c()) != null) {
                    MenuItem menuItemFindItem5 = menuM1860c2.findItem(R.id.actionbar_title_done);
                    MenuItem menuItemFindItem6 = menuM1860c2.findItem(R.id.actionbar_title_done_dim);
                    if (menuItemFindItem5 != null) {
                        menuItemFindItem5.setVisible(false).setEnabled(false);
                    }
                    if (menuItemFindItem6 != null) {
                        menuItemFindItem6.setVisible(true).setEnabled(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f886y = this.f883v;
            AddBuddyActivity addBuddyActivity4 = (AddBuddyActivity) getActivity();
            if (addBuddyActivity4 != null && (menuM1860c = addBuddyActivity4.m1860c()) != null) {
                boolean z2 = !TextUtils.isEmpty(this.f875n.getText());
                MenuItem menuItemFindItem7 = menuM1860c.findItem(R.id.actionbar_title_done);
                MenuItem menuItemFindItem8 = menuM1860c.findItem(R.id.actionbar_title_done_dim);
                if (z2) {
                    if (menuItemFindItem7 != null) {
                        menuItemFindItem7.setVisible(true).setEnabled(true);
                    }
                    if (menuItemFindItem8 != null) {
                        menuItemFindItem8.setVisible(false).setEnabled(false);
                        return;
                    }
                    return;
                }
                if (menuItemFindItem7 != null) {
                    menuItemFindItem7.setVisible(false).setEnabled(false);
                }
                if (menuItemFindItem8 != null) {
                    menuItemFindItem8.setVisible(true).setEnabled(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1870a(GetBuddyList getBuddyList) {
            this.f886y.removeAllViews();
            if (getBuddyList != null) {
                Iterator it = getBuddyList.buddy.iterator();
                while (it.hasNext()) {
                    Buddy buddy = (Buddy) it.next();
                    if (this.f886y.getChildCount() == 0) {
                        getActivity().getLayoutInflater().inflate(R.layout.list_divider, this.f886y, true);
                    }
                    if (this.f856L == "Phone Number") {
                        this.f887z.setVisibility(0);
                    } else {
                        this.f845A.setVisibility(0);
                    }
                    View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.list_item_add_buddy, this.f886y, false);
                    C1746bb.m5945a(getActivity()).m5959a((ImageView) viewInflate.findViewById(R.id.listItemImage), buddy.value);
                    ((TextView) viewInflate.findViewById(R.id.listItemText1)).setText(buddy.name);
                    viewInflate.findViewById(R.id.listItemButton).setOnClickListener(this);
                    this.f886y.addView(viewInflate);
                    if (this.f856L == "Phone Number") {
                        this.f846B = this.f872k.getText().toString();
                    } else {
                        this.f847C = this.f875n.getText().toString();
                    }
                    getActivity().getLayoutInflater().inflate(R.layout.list_divider, this.f886y, true);
                }
            }
            this.f886y.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m1879c() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f872k.getWindowToken(), 0);
                }
            } catch (Exception e) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1871a(String str, String str2) {
            try {
                startActivity(C1816b.m6157a(str, str2));
            } catch (ActivityNotFoundException e) {
                new AlertDialogBuilderC2120a(getActivity()).setTitle(R.string.tellfriends_warning_title).setMessage(R.string.tellfriends_message_not_supported).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0417h(this)).show();
            }
        }

        /* renamed from: a */
        public void m1891a(int i) {
            if (i > 0) {
                this.f848D.setVisibility(0);
                if (i >= 100) {
                    this.f848D.setText(R.string.chat_max_unread);
                    this.f848D.setTextSize(0, this.f848D.getResources().getDimension(R.dimen.text_size_10));
                    return;
                }
                this.f848D.setText(String.valueOf(i));
                if (i >= 10) {
                    this.f848D.setTextSize(0, this.f848D.getResources().getDimension(R.dimen.text_size_12));
                    return;
                } else {
                    this.f848D.setTextSize(0, this.f848D.getResources().getDimension(R.dimen.text_size_13));
                    return;
                }
            }
            this.f848D.setVisibility(8);
        }
    }
}
