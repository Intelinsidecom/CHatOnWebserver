package com.sec.chaton.registration;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C1303az;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.FastScrollableListView;
import com.sec.widget.GeneralHeaderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class CountryActivity extends ListActivity implements TextWatcher, AdapterView.OnItemClickListener {

    /* renamed from: c */
    private EditTextWithClearButton f3284c;

    /* renamed from: f */
    private CharSequence[] f3287f;

    /* renamed from: g */
    private CharSequence[] f3288g;

    /* renamed from: h */
    private Context f3289h;

    /* renamed from: i */
    private CharSequence[] f3290i;

    /* renamed from: m */
    private CheckBox f3294m;

    /* renamed from: o */
    private GeneralHeaderView f3296o;

    /* renamed from: p */
    private View f3297p;

    /* renamed from: r */
    private Toast f3299r;

    /* renamed from: s */
    private FastScrollableListView f3300s;

    /* renamed from: d */
    private String f3285d = null;

    /* renamed from: e */
    private int f3286e = -1;

    /* renamed from: a */
    Map f3282a = new HashMap();

    /* renamed from: b */
    Map f3283b = new HashMap();

    /* renamed from: j */
    private C0946ar f3291j = null;

    /* renamed from: k */
    private ArrayList f3292k = null;

    /* renamed from: l */
    private final int f3293l = 1;

    /* renamed from: n */
    private boolean f3295n = false;

    /* renamed from: q */
    private int f3298q = 1;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_country);
        this.f3289h = this;
        this.f3296o = (GeneralHeaderView) findViewById(R.id.subTitle);
        this.f3284c = (EditTextWithClearButton) findViewById(R.id.editCountry);
        this.f3284c.setMaxLengthString(R.string.toast_text_max_Length);
        this.f3284c.setShowClear(false);
        this.f3284c.setShowSearch(true);
        this.f3284c.addTextChangedListener(this);
        this.f3287f = getResources().getTextArray(R.array.country);
        this.f3288g = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        this.f3297p = (TextView) findViewById(R.id.country_list_no_search_result);
        this.f3299r = C1619g.m5889a(this.f3289h, (CharSequence) null, 0);
        this.f3290i = getResources().getTextArray(R.array.country_code);
        String stringExtra = getIntent().getStringExtra("extra_hide_country_calling_code");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < this.f3290i.length; i++) {
                if (!stringExtra.equals(this.f3290i[i])) {
                    arrayList.add(this.f3287f[i]);
                    arrayList2.add(this.f3290i[i]);
                    arrayList3.add(this.f3288g[i]);
                }
            }
            this.f3287f = new CharSequence[arrayList.size()];
            this.f3290i = new CharSequence[arrayList2.size()];
            this.f3288g = new CharSequence[arrayList3.size()];
            arrayList.toArray(this.f3287f);
            arrayList2.toArray(this.f3290i);
            arrayList3.toArray(this.f3288g);
        }
        for (int i2 = 0; i2 < this.f3287f.length; i2++) {
            this.f3282a.put(this.f3287f[i2], this.f3290i[i2]);
            this.f3283b.put(this.f3287f[i2], this.f3288g[i2]);
        }
        this.f3300s = (FastScrollableListView) getListView();
        this.f3291j = new C0946ar(this);
        setListAdapter(this.f3291j);
        this.f3300s.setItemsCanFocus(false);
        this.f3300s.setOnItemClickListener(this);
        this.f3300s.setFastScrollEnabled(true);
        if (getIntent() != null) {
            this.f3298q = getIntent().getIntExtra(RtspHeaders.Values.MODE, 1);
        }
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
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f3285d = (String) ((TextView) view.findViewById(R.id.country_item_text)).getText();
        this.f3286e = i;
        this.f3295n = true;
        C1341p.m4658b("selectedCountry =" + this.f3285d, getClass().getSimpleName());
        setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_NAME", String.valueOf(this.f3283b.get(this.f3285d))));
        finish();
        ((C0946ar) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f3284c.getText().toString();
        this.f3282a.clear();
        this.f3295n = false;
        this.f3292k = new ArrayList();
        for (int i = 0; i < this.f3287f.length; i++) {
            if (string.length() <= this.f3287f[i].length() && (C1303az.m4552a(this.f3287f[i].toString(), string) || String.valueOf(this.f3290i[i]).indexOf(string) != -1)) {
                this.f3282a.put(this.f3287f[i], this.f3290i[i]);
                this.f3292k.add(this.f3287f[i].toString());
            }
        }
        this.f3291j.notifyDataSetChanged();
        if (this.f3292k != null && this.f3292k.size() == 0 && !this.f3284c.getText().toString().equals("")) {
            C1341p.m4651a("YES", getClass().getSimpleName());
            getListView().setVisibility(8);
            this.f3297p.setVisibility(0);
        } else {
            getListView().setVisibility(0);
            this.f3297p.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30) {
            this.f3299r.cancel();
            this.f3299r.setText(R.string.toast_text_max_Length);
            this.f3299r.setDuration(0);
            this.f3299r.show();
        }
        if (charSequence.length() > 0) {
            this.f3284c.setShowClear(true);
        } else {
            this.f3284c.setShowClear(false);
        }
    }
}
