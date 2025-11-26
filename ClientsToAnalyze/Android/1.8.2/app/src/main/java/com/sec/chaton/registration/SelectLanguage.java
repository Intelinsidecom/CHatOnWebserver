package com.sec.chaton.registration;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1725ah;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SelectLanguage extends ListActivity implements TextWatcher, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private EditText f4336a;

    /* renamed from: d */
    private CharSequence[] f4339d;

    /* renamed from: e */
    private Context f4340e;

    /* renamed from: h */
    private CheckBox f4343h;

    /* renamed from: j */
    private TextView f4345j;

    /* renamed from: l */
    private TextView f4347l;

    /* renamed from: b */
    private String f4337b = null;

    /* renamed from: c */
    private int f4338c = -1;

    /* renamed from: f */
    private C1189bp f4341f = null;

    /* renamed from: g */
    private ArrayList f4342g = null;

    /* renamed from: i */
    private boolean f4344i = false;

    /* renamed from: k */
    private ArrayList f4346k = null;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_country);
        this.f4340e = this;
        this.f4345j = (TextView) findViewById(R.id.subTitle);
        this.f4347l = (TextView) findViewById(R.id.subTitle_tablet);
        this.f4336a = (EditText) findViewById(R.id.editCountry);
        this.f4336a.addTextChangedListener(this);
        this.f4339d = getResources().getTextArray(R.array.ACS_Locale_Language);
        this.f4346k = new ArrayList();
        if (GlobalApplication.m3265f()) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(530, -2);
        }
        if (GlobalApplication.m3265f()) {
            this.f4345j.setVisibility(8);
        }
        String stringExtra = getIntent().getStringExtra("extra_hide_language");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f4339d.length; i++) {
                if (!stringExtra.equals(this.f4339d[i])) {
                    arrayList.add(this.f4339d[i]);
                }
            }
            this.f4339d = new CharSequence[arrayList.size()];
            arrayList.toArray(this.f4339d);
        }
        for (int i2 = 0; i2 < this.f4339d.length; i2++) {
            this.f4346k.add(this.f4339d[i2].toString());
        }
        this.f4341f = new C1189bp(this);
        setListAdapter(this.f4341f);
        ListView listView = getListView();
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4448a(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this.f4340e);
        linearLayout.setBackgroundResource(R.drawable.sub_title_bg);
        textView.setTextColor(-1);
        textView.setText(str.substring(0, 1).toUpperCase());
        textView.setTextSize(20.0f);
        textView.setPadding(5, 0, 0, 0);
        textView.setGravity(16);
        linearLayout.addView(textView);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f4337b = (String) ((TextView) view.findViewById(R.id.country_item_text)).getText();
        this.f4338c = i;
        this.f4344i = true;
        C1786r.m6061b("selectedLanguage =" + this.f4337b, getClass().getSimpleName());
        setResult(-1, getIntent().putExtra("LANGUAGE_NAME", this.f4337b));
        finish();
        ((C1189bp) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f4336a.getText().toString();
        this.f4344i = false;
        this.f4342g = new ArrayList();
        this.f4346k.clear();
        for (int i = 0; i < this.f4339d.length; i++) {
            if (string.length() <= this.f4339d[i].length() && C1725ah.m5900a(this.f4339d[i].toString(), string)) {
                this.f4342g.add(this.f4339d[i].toString());
                this.f4346k.add(this.f4339d[i].toString());
                C1786r.m6061b("mFilteredCountry = " + this.f4342g, getClass().getSimpleName());
            }
        }
        this.f4341f.notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
