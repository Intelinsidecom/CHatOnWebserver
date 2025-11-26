package com.sec.chaton.registration;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3177as;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3226cn;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.actionbar.ActionBarListActivity;
import com.sec.widget.C3641ai;
import com.sec.widget.FastScrollableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class CountryActivity extends ActionBarListActivity implements TextWatcher, AdapterView.OnItemClickListener, InterfaceC3226cn {

    /* renamed from: c */
    private ClearableEditText f8178c;

    /* renamed from: e */
    private CharSequence[] f8180e;

    /* renamed from: f */
    private CharSequence[] f8181f;

    /* renamed from: g */
    private Context f8182g;

    /* renamed from: h */
    private CharSequence[] f8183h;

    /* renamed from: l */
    private View f8187l;

    /* renamed from: n */
    private FastScrollableListView f8189n;

    /* renamed from: d */
    private String f8179d = null;

    /* renamed from: a */
    Map<CharSequence, CharSequence> f8176a = new HashMap();

    /* renamed from: b */
    Map<CharSequence, CharSequence> f8177b = new HashMap();

    /* renamed from: i */
    private C2161bl f8184i = null;

    /* renamed from: j */
    private ArrayList<String> f8185j = null;

    /* renamed from: k */
    private final int f8186k = 1;

    /* renamed from: m */
    private int f8188m = 1;

    /* renamed from: o */
    private Boolean f8190o = false;

    @Override // com.sec.common.actionbar.ActionBarListActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        setContentView(R.layout.activity_country);
        this.f8182g = this;
        this.f8190o = Boolean.valueOf(getIntent().getExtras().getBoolean("needBackKey"));
        if (!GlobalApplication.m6456e()) {
            m11544a().mo11584a(false);
            m11544a().mo11593d(false);
            if (this.f8190o.booleanValue()) {
                m11544a().mo11584a(true);
                m11544a().mo11593d(true);
            }
        } else {
            m11544a().mo11584a(true);
            m11544a().mo11593d(true);
        }
        this.f8178c = (ClearableEditText) findViewById(R.id.editCountry);
        this.f8178c.m11464a(this);
        this.f8180e = getResources().getTextArray(R.array.country);
        this.f8181f = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        this.f8187l = findViewById(R.id.country_list_no_search_result);
        this.f8183h = getResources().getTextArray(R.array.country_code);
        String stringExtra = getIntent().getStringExtra("extra_hide_country_calling_code");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < this.f8183h.length; i++) {
                if (!stringExtra.equals(this.f8183h[i])) {
                    arrayList.add(this.f8180e[i]);
                    arrayList2.add(this.f8183h[i]);
                    arrayList3.add(this.f8181f[i]);
                }
            }
            this.f8180e = new CharSequence[arrayList.size()];
            this.f8183h = new CharSequence[arrayList2.size()];
            this.f8181f = new CharSequence[arrayList3.size()];
            arrayList.toArray(this.f8180e);
            arrayList2.toArray(this.f8183h);
            arrayList3.toArray(this.f8181f);
        }
        for (int i2 = 0; i2 < this.f8180e.length; i2++) {
            this.f8176a.put(this.f8180e[i2], this.f8183h[i2]);
            this.f8177b.put(this.f8180e[i2], this.f8181f[i2]);
        }
        this.f8189n = (FastScrollableListView) getListView();
        this.f8184i = new C2161bl(this);
        setListAdapter(this.f8184i);
        this.f8189n.setItemsCanFocus(false);
        this.f8189n.setOnItemClickListener(this);
        this.f8189n.setFastScrollEnabled(true);
        if (getIntent() != null) {
            this.f8188m = getIntent().getIntExtra(RtspHeaders.Values.MODE, 1);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        int intExtra = getIntent().getIntExtra("ADD_BUDDY_TYPE", 0);
        if (GlobalApplication.m6456e() && intExtra == 100) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // com.sec.common.actionbar.ActionBarListActivity, com.sec.common.actionbar.InterfaceC3302s
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
        this.f8179d = ((TextView) view.findViewById(R.id.text1)).getText().toString();
        C3250y.m11450b("selectedCountry =" + this.f8179d, getClass().getSimpleName());
        setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_NAME", String.valueOf(this.f8177b.get(this.f8179d))));
        finish();
        ((C2161bl) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f8178c.m11463a().toString();
        this.f8176a.clear();
        this.f8185j = new ArrayList<>();
        if (string.startsWith("+") && string.length() > 1) {
            string = string.substring(1);
        }
        for (int i = 0; i < this.f8180e.length; i++) {
            if (string.length() <= this.f8180e[i].length() && (C3177as.m11097b(this.f8180e[i].toString(), string) || String.valueOf(this.f8183h[i]).indexOf(string) != -1 || string.equals("+"))) {
                this.f8176a.put(this.f8180e[i], this.f8183h[i]);
                this.f8185j.add(this.f8180e[i].toString());
            }
        }
        this.f8184i.m8675a(string);
        this.f8184i.notifyDataSetChanged();
        if (this.f8185j != null && this.f8185j.size() == 0 && !this.f8178c.m11463a().toString().equals("")) {
            C3250y.m11442a("YES", getClass().getSimpleName());
            getListView().setVisibility(8);
            this.f8187l.setVisibility(0);
        } else {
            getListView().setVisibility(0);
            this.f8187l.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30) {
            C3641ai.m13210a(this, R.string.toast_text_max_Length, 0).show();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: b */
    private void m8493b() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        int intExtra = getIntent().getIntExtra("ADD_BUDDY_TYPE", 0);
        if (GlobalApplication.m6456e() && intExtra == 100) {
            BaseActivity.m3080a(this);
        }
        m8493b();
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme;
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Black;
    }
}
