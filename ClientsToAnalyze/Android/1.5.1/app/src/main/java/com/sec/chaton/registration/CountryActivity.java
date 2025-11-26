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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.HangulJamoUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CountryActivity extends ListActivity implements TextWatcher, AdapterView.OnItemClickListener {

    /* renamed from: b */
    private EditText f2896b;

    /* renamed from: e */
    private CharSequence[] f2899e;

    /* renamed from: f */
    private Context f2900f;

    /* renamed from: g */
    private CharSequence[] f2901g;

    /* renamed from: k */
    private CheckBox f2905k;

    /* renamed from: c */
    private String f2897c = null;

    /* renamed from: d */
    private int f2898d = -1;

    /* renamed from: a */
    Map f2895a = new HashMap();

    /* renamed from: h */
    private C0413ak f2902h = null;

    /* renamed from: i */
    private ArrayList f2903i = null;

    /* renamed from: j */
    private final int f2904j = 1;

    /* renamed from: l */
    private boolean f2906l = false;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f2896b.getText().toString();
        this.f2895a.clear();
        this.f2906l = false;
        this.f2903i = new ArrayList();
        for (int i = 0; i < this.f2899e.length; i++) {
            if (string.length() <= this.f2899e[i].length() && (HangulJamoUtil.m3582a(this.f2899e[i].toString(), string) || String.valueOf(this.f2901g[i]).indexOf(string) != -1)) {
                this.f2895a.put(this.f2899e[i], this.f2901g[i]);
                this.f2903i.add(this.f2899e[i].toString());
            }
        }
        this.f2902h.notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
        }
        switch (i) {
            case 1:
                Bundle extras = intent.getExtras();
                getIntent().putExtras(extras);
                setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_CODE", extras.getString("PARAMS_COUNTRY_CODE")));
                finish();
                break;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.buttonSelect /* 2131427339 */:
                if (this.f2897c != null) {
                    setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_NAME", this.f2897c));
                    finish();
                    break;
                }
                break;
            case C0062R.id.buttonCancel /* 2131427340 */:
                setResult(0);
                finish();
                break;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.activity_country);
        this.f2900f = this;
        ((ImageButton) findViewById(C0062R.id.buttonAdd)).setOnClickListener(new ViewOnClickListenerC0417ao(this));
        this.f2896b = (EditText) findViewById(C0062R.id.editCountry);
        this.f2896b.addTextChangedListener(this);
        this.f2899e = getResources().getTextArray(C0062R.array.country);
        this.f2901g = getResources().getTextArray(C0062R.array.country_code);
        String stringExtra = getIntent().getStringExtra("extra_hide_country_calling_code");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.f2901g.length; i++) {
                if (!stringExtra.equals(this.f2901g[i])) {
                    arrayList.add(this.f2899e[i]);
                    arrayList2.add(this.f2901g[i]);
                }
            }
            this.f2899e = new CharSequence[arrayList.size()];
            this.f2901g = new CharSequence[arrayList2.size()];
            arrayList.toArray(this.f2899e);
            arrayList2.toArray(this.f2901g);
        }
        for (int i2 = 0; i2 < this.f2899e.length; i2++) {
            this.f2895a.put(this.f2899e[i2], this.f2901g[i2]);
        }
        this.f2902h = new C0413ak(this);
        setListAdapter(this.f2902h);
        ListView listView = getListView();
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        getWindow().setSoftInputMode(2);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2897c = (String) ((TextView) view.findViewById(C0062R.id.country_item_text)).getText();
        this.f2898d = i;
        this.f2906l = true;
        ChatONLogWriter.m3506b("selectedCountry =" + this.f2897c, getClass().getSimpleName());
        setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_NAME", this.f2897c));
        finish();
        ((C0413ak) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
