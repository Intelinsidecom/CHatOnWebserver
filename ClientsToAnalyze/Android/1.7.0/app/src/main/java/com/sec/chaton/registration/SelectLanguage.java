package com.sec.chaton.registration;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1303az;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.GeneralHeaderView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SelectLanguage extends ListActivity implements TextWatcher, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private EditTextWithClearButton f3304a;

    /* renamed from: d */
    private CharSequence[] f3307d;

    /* renamed from: e */
    private Context f3308e;

    /* renamed from: h */
    private CheckBox f3311h;

    /* renamed from: j */
    private GeneralHeaderView f3313j;

    /* renamed from: b */
    private String f3305b = null;

    /* renamed from: c */
    private int f3306c = -1;

    /* renamed from: f */
    private C0964bi f3309f = null;

    /* renamed from: g */
    private ArrayList f3310g = null;

    /* renamed from: i */
    private boolean f3312i = false;

    /* renamed from: k */
    private ArrayList f3314k = null;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_country);
        this.f3308e = this;
        this.f3313j = (GeneralHeaderView) findViewById(R.id.subTitle);
        this.f3304a = (EditTextWithClearButton) findViewById(R.id.editCountry);
        this.f3304a.setHint("");
        this.f3304a.addTextChangedListener(this);
        this.f3307d = getResources().getTextArray(R.array.ACS_Locale_Language);
        this.f3314k = new ArrayList();
        String stringExtra = getIntent().getStringExtra("extra_hide_language");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f3307d.length; i++) {
                if (!stringExtra.equals(this.f3307d[i])) {
                    arrayList.add(this.f3307d[i]);
                }
            }
            this.f3307d = new CharSequence[arrayList.size()];
            arrayList.toArray(this.f3307d);
        }
        for (int i2 = 0; i2 < this.f3307d.length; i2++) {
            this.f3314k.add(this.f3307d[i2].toString());
        }
        this.f3309f = new C0964bi(this);
        setListAdapter(this.f3309f);
        ListView listView = getListView();
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f3305b = (String) ((TextView) view.findViewById(R.id.country_item_text)).getText();
        this.f3306c = i;
        this.f3312i = true;
        C1341p.m4658b("selectedLanguage =" + this.f3305b, getClass().getSimpleName());
        setResult(-1, getIntent().putExtra("LANGUAGE_NAME", this.f3305b));
        finish();
        ((C0964bi) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f3304a.getText().toString();
        this.f3312i = false;
        this.f3310g = new ArrayList();
        this.f3314k.clear();
        for (int i = 0; i < this.f3307d.length; i++) {
            if (string.length() <= this.f3307d[i].length() && C1303az.m4552a(this.f3307d[i].toString(), string)) {
                this.f3310g.add(this.f3307d[i].toString());
                this.f3314k.add(this.f3307d[i].toString());
                C1341p.m4658b("mFilteredCountry = " + this.f3310g, getClass().getSimpleName());
            }
        }
        this.f3309f.notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30) {
            C1619g.m5888a(this, R.string.toast_text_max_Length, 0).show();
        }
    }
}
