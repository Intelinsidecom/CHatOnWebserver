package com.sec.chaton.registration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3177as;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SelectLanguageFragment extends ListFragment implements TextWatcher, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private ClearableEditText f8377a;

    /* renamed from: c */
    private CharSequence[] f8379c;

    /* renamed from: d */
    private Context f8380d;

    /* renamed from: h */
    private View f8384h;

    /* renamed from: i */
    private FragmentActivity f8385i;

    /* renamed from: j */
    private View f8386j;

    /* renamed from: b */
    private String f8378b = null;

    /* renamed from: e */
    private C2290gf f8381e = null;

    /* renamed from: f */
    private ArrayList<String> f8382f = null;

    /* renamed from: g */
    private ArrayList<String> f8383g = null;

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f8386j = layoutInflater.inflate(R.layout.activity_country, viewGroup, false);
        this.f8380d = this.f8385i;
        this.f8377a = (ClearableEditText) this.f8386j.findViewById(R.id.editCountry);
        this.f8377a.setHint(getResources().getText(R.string.select_language));
        this.f8377a.m11464a(this);
        this.f8379c = getResources().getTextArray(R.array.ACS_Locale_Language);
        this.f8383g = new ArrayList<>();
        this.f8384h = this.f8386j.findViewById(R.id.country_list_no_search_result);
        String stringExtra = this.f8385i.getIntent().getStringExtra("extra_hide_language");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f8379c.length; i++) {
                if (!stringExtra.equals(this.f8379c[i])) {
                    arrayList.add(this.f8379c[i]);
                }
            }
            this.f8379c = new CharSequence[arrayList.size()];
            arrayList.toArray(this.f8379c);
        }
        for (int i2 = 0; i2 < this.f8379c.length; i2++) {
            this.f8383g.add(this.f8379c[i2].toString());
        }
        this.f8381e = new C2290gf(this);
        setListAdapter(this.f8381e);
        return this.f8386j;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ListView listView = getListView();
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8385i = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8385i = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f8378b = (String) ((TextView) view.findViewById(R.id.text1)).getText();
        C3250y.m11450b("selectedLanguage =" + this.f8378b, getClass().getSimpleName());
        this.f8385i.setResult(-1, this.f8385i.getIntent().putExtra("LANGUAGE_NAME", this.f8378b));
        this.f8385i.finish();
        ((C2290gf) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f8377a.m11463a().toString();
        this.f8382f = new ArrayList<>();
        this.f8383g.clear();
        for (int i = 0; i < this.f8379c.length; i++) {
            if (string.length() <= this.f8379c[i].length() && C3177as.m11097b(this.f8379c[i].toString(), string)) {
                this.f8382f.add(this.f8379c[i].toString());
                this.f8383g.add(this.f8379c[i].toString());
                C3250y.m11450b("mFilteredCountry = " + this.f8382f, getClass().getSimpleName());
            }
        }
        this.f8381e.notifyDataSetChanged();
        if (this.f8382f != null && this.f8382f.size() == 0 && !this.f8377a.m11463a().toString().equals("")) {
            C3250y.m11442a("YES", getClass().getSimpleName());
            getListView().setVisibility(8);
            this.f8384h.setVisibility(0);
        } else {
            getListView().setVisibility(0);
            this.f8384h.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30) {
            C3641ai.m13210a(this.f8385i, R.string.toast_text_max_Length, 0).show();
        }
    }
}
