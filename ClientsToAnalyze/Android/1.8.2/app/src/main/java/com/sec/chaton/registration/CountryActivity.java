package com.sec.chaton.registration;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1725ah;
import com.sec.chaton.util.C1786r;
import com.sec.widget.EditTextWithClearButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class CountryActivity extends ListActivity implements TextWatcher, AdapterView.OnItemClickListener {

    /* renamed from: b */
    private EditTextWithClearButton f4309b;

    /* renamed from: e */
    private CharSequence[] f4312e;

    /* renamed from: f */
    private Context f4313f;

    /* renamed from: g */
    private CharSequence[] f4314g;

    /* renamed from: k */
    private CheckBox f4318k;

    /* renamed from: m */
    private TextView f4320m;

    /* renamed from: n */
    private View f4321n;

    /* renamed from: p */
    private TextView f4323p;

    /* renamed from: c */
    private String f4310c = null;

    /* renamed from: d */
    private int f4311d = -1;

    /* renamed from: a */
    Map f4308a = new HashMap();

    /* renamed from: h */
    private C1179bf f4315h = null;

    /* renamed from: i */
    private ArrayList f4316i = null;

    /* renamed from: j */
    private final int f4317j = 1;

    /* renamed from: l */
    private boolean f4319l = false;

    /* renamed from: o */
    private int f4322o = 1;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_country);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f4313f = this;
        ((ImageButton) findViewById(R.id.buttonAdd)).setOnClickListener(new ViewOnClickListenerC1178be(this));
        this.f4320m = (TextView) findViewById(R.id.subTitle);
        this.f4323p = (TextView) findViewById(R.id.subTitle_tablet);
        this.f4309b = (EditTextWithClearButton) findViewById(R.id.editCountry);
        this.f4309b.setMaxLengthString(R.string.toast_text_max_Length);
        this.f4309b.setShowSearch(true);
        this.f4309b.addTextChangedListener(this);
        this.f4312e = getResources().getTextArray(R.array.country);
        if (GlobalApplication.m3265f()) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(530, -2);
        }
        if (GlobalApplication.m3265f()) {
            this.f4320m.setVisibility(8);
        }
        this.f4321n = (TextView) findViewById(R.id.country_list_no_search_result);
        this.f4314g = getResources().getTextArray(R.array.country_code);
        String stringExtra = getIntent().getStringExtra("extra_hide_country_calling_code");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.f4314g.length; i++) {
                if (!stringExtra.equals(this.f4314g[i])) {
                    arrayList.add(this.f4312e[i]);
                    arrayList2.add(this.f4314g[i]);
                }
            }
            this.f4312e = new CharSequence[arrayList.size()];
            this.f4314g = new CharSequence[arrayList2.size()];
            arrayList.toArray(this.f4312e);
            arrayList2.toArray(this.f4314g);
        }
        for (int i2 = 0; i2 < this.f4312e.length; i2++) {
            this.f4308a.put(this.f4312e[i2], this.f4314g[i2]);
        }
        this.f4315h = new C1179bf(this);
        setListAdapter(this.f4315h);
        ListView listView = getListView();
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        if (getIntent() != null) {
            this.f4322o = getIntent().getIntExtra(RtspHeaders.Values.MODE, 1);
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
        switch (view.getId()) {
            case R.id.buttonSelect /* 2131492884 */:
                if (this.f4310c != null) {
                    setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_NAME", this.f4310c));
                    finish();
                    break;
                }
                break;
            case R.id.buttonCancel /* 2131492885 */:
                setResult(0);
                finish();
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f4310c = ((TextView) view.findViewById(R.id.country_item_text)).getText().toString();
        this.f4311d = i;
        this.f4319l = true;
        C1786r.m6061b("selectedCountry =" + this.f4310c, getClass().getSimpleName());
        setResult(-1, getIntent().putExtra("PARAMS_COUNTRY_NAME", this.f4310c));
        finish();
        ((C1179bf) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f4309b.getText().toString();
        this.f4308a.clear();
        this.f4319l = false;
        this.f4316i = new ArrayList();
        for (int i = 0; i < this.f4312e.length; i++) {
            if (string.length() <= this.f4312e[i].length() && (C1725ah.m5900a(this.f4312e[i].toString(), string) || String.valueOf(this.f4314g[i]).indexOf(string) != -1)) {
                this.f4308a.put(this.f4312e[i], this.f4314g[i]);
                this.f4316i.add(this.f4312e[i].toString());
            }
        }
        this.f4315h.m4462a(string);
        this.f4315h.notifyDataSetChanged();
        if (this.f4316i != null && this.f4316i.size() == 0 && !this.f4309b.getText().toString().equals("")) {
            C1786r.m6054a("YES", getClass().getSimpleName());
            getListView().setVisibility(8);
            this.f4321n.setVisibility(0);
        } else {
            getListView().setVisibility(0);
            this.f4321n.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
