package com.sec.chaton.registration;

import android.content.Context;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.util.C4827as;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4876cn;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.actionbar.ActionBarListActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import com.sec.widget.FastScrollableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CountryActivity extends ActionBarListActivity implements TextWatcher, AdapterView.OnItemClickListener, InterfaceC4876cn {

    /* renamed from: c */
    private ClearableEditText f11596c;

    /* renamed from: e */
    private CharSequence[] f11598e;

    /* renamed from: f */
    private CharSequence[] f11599f;

    /* renamed from: g */
    private Context f11600g;

    /* renamed from: h */
    private CharSequence[] f11601h;

    /* renamed from: l */
    private View f11605l;

    /* renamed from: n */
    private FastScrollableListView f11607n;

    /* renamed from: p */
    private String f11609p;

    /* renamed from: d */
    private String f11597d = null;

    /* renamed from: a */
    Map<CharSequence, CharSequence> f11594a = new HashMap();

    /* renamed from: b */
    Map<CharSequence, CharSequence> f11595b = new HashMap();

    /* renamed from: i */
    private C3319z f11602i = null;

    /* renamed from: j */
    private ArrayList<String> f11603j = null;

    /* renamed from: k */
    private final int f11604k = 1;

    /* renamed from: m */
    private int f11606m = 1;

    /* renamed from: o */
    private boolean f11608o = false;

    /* renamed from: q */
    private boolean f11610q = false;

    @Override // com.sec.common.actionbar.ActionBarListActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        setContentView(R.layout.activity_country);
        this.f11600g = this;
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.f11608o = intent.getExtras().getBoolean("needBackKey");
            this.f11609p = intent.getExtras().getString("sns_type");
        }
        m18785a().mo18824a(false);
        m18785a().mo18833d(false);
        if (this.f11608o) {
            m18785a().mo18824a(true);
            m18785a().mo18833d(true);
        }
        this.f11596c = (ClearableEditText) findViewById(R.id.text1);
        this.f11596c.m18659a(this);
        this.f11596c.setHint(getResources().getText(R.string.regist_select_country_or_region_code));
        this.f11596c.setImeOptions(268435462);
        this.f11596c.setInputType(MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND);
        this.f11596c.setMaxLength(30);
        this.f11598e = getResources().getTextArray(R.array.country);
        this.f11599f = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        this.f11605l = findViewById(R.id.country_list_no_search_result);
        this.f11601h = getResources().getTextArray(R.array.country_code);
        String stringExtra = getIntent().getStringExtra("extra_hide_country_calling_code");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < this.f11601h.length; i++) {
                if (!stringExtra.equals(this.f11601h[i])) {
                    arrayList.add(this.f11598e[i]);
                    arrayList2.add(this.f11601h[i]);
                    arrayList3.add(this.f11599f[i]);
                }
            }
            this.f11598e = new CharSequence[arrayList.size()];
            this.f11601h = new CharSequence[arrayList2.size()];
            this.f11599f = new CharSequence[arrayList3.size()];
            arrayList.toArray(this.f11598e);
            arrayList2.toArray(this.f11601h);
            arrayList3.toArray(this.f11599f);
        }
        for (int i2 = 0; i2 < this.f11598e.length; i2++) {
            this.f11594a.put(this.f11598e[i2], this.f11601h[i2]);
            this.f11595b.put(this.f11598e[i2], this.f11599f[i2]);
        }
        this.f11607n = (FastScrollableListView) getListView();
        this.f11602i = new C3319z(this);
        setListAdapter(this.f11602i);
        this.f11607n.setItemsCanFocus(false);
        this.f11607n.setOnItemClickListener(this);
        this.f11607n.setFastScrollEnabled(true);
        if (getIntent() != null) {
            this.f11606m = getIntent().getIntExtra("mode", 1);
        }
    }

    @Override // com.sec.common.actionbar.ActionBarListActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2);
        finish();
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1059a.m6169e(this);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    Bundle extras = intent.getExtras();
                    getIntent().putExtras(extras);
                    setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_CODE", extras.getString("PARAMS_COUNTRY_CODE")));
                    finish();
                    break;
            }
        }
    }

    public void onClick(View view) {
        view.getId();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f11597d = ((TextView) view.findViewById(R.id.text1)).getText().toString();
        String strValueOf = String.valueOf(this.f11595b.get(this.f11597d));
        C4904y.m18639b("selectedCountry =" + this.f11597d + " selectedISO =" + strValueOf, getClass().getSimpleName());
        if ((C4368e.f15815a.equals(this.f11609p) && !C4859bx.m18408f(strValueOf)) || ((C4368e.f15820f.equals(this.f11609p) && !C4859bx.m18411g(strValueOf)) || (C4368e.f15818d.equals(this.f11609p) && !C4859bx.m18413h(strValueOf)))) {
            m12817b();
        } else {
            finishActivity(-1);
        }
        ((C3319z) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        setResult(i, getIntent().putExtra("PARAMS_COUNTRY_NAME", String.valueOf(this.f11595b.get(this.f11597d))));
        finish();
    }

    /* renamed from: b */
    private void m12817b() {
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this).mo18742a(true).mo18751b(false).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(getResources().getString(R.string.register_with_sns_china_alert, this.f11609p)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3318y(this)).mo18745a();
        if (!this.f11610q) {
            interfaceC4936eMo18745a.show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f11596c.m18658a().toString();
        this.f11594a.clear();
        this.f11603j = new ArrayList<>();
        if (string.startsWith("+") && string.length() > 1) {
            string = string.substring(1);
        }
        for (int i = 0; i < this.f11598e.length; i++) {
            if (string.length() <= this.f11598e[i].length() && (C4827as.m18270b(this.f11598e[i].toString(), string) || String.valueOf(this.f11601h[i]).indexOf(string) != -1 || string.equals("+"))) {
                this.f11594a.put(this.f11598e[i], this.f11601h[i]);
                this.f11603j.add(this.f11598e[i].toString());
            }
        }
        this.f11602i.m13051a(string);
        this.f11602i.notifyDataSetChanged();
        if (this.f11603j != null && this.f11603j.size() == 0 && !this.f11596c.m18658a().toString().equals("")) {
            C4904y.m18634a("YES", getClass().getSimpleName());
            getListView().setVisibility(8);
            this.f11605l.setVisibility(0);
        } else {
            getListView().setVisibility(0);
            this.f11605l.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30) {
            C5179v.m19810a(this, R.string.toast_text_max_Length, 0).show();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        C1059a.m6168d(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1059a.m6166b(this);
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme;
    }

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f11610q = true;
        C1059a.m6171g(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        C1059a.m6163a(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        C1059a.m6170f(this);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1059a.m6167c(this);
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme;
    }
}
