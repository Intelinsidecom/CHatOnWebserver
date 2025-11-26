package com.sec.chaton.registration;

import android.app.Activity;
import android.content.Context;
import android.hardware.motion.MotionRecognitionManager;
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
import com.sec.chaton.util.C4827as;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SelectLanguageFragment extends ListFragment implements TextWatcher, AdapterView.OnItemClickListener {

    /* renamed from: i */
    private ClearableEditText f11851i;

    /* renamed from: k */
    private CharSequence[] f11853k;

    /* renamed from: l */
    private Context f11854l;

    /* renamed from: p */
    private View f11858p;

    /* renamed from: q */
    private FragmentActivity f11859q;

    /* renamed from: r */
    private View f11860r;

    /* renamed from: j */
    private String f11852j = null;

    /* renamed from: m */
    private C3298ge f11855m = null;

    /* renamed from: n */
    private ArrayList<String> f11856n = null;

    /* renamed from: o */
    private ArrayList<String> f11857o = null;

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f11860r = layoutInflater.inflate(R.layout.activity_country, viewGroup, false);
        this.f11854l = this.f11859q;
        this.f11851i = (ClearableEditText) this.f11860r.findViewById(R.id.text1);
        this.f11851i.setHint(getResources().getText(R.string.select_language));
        this.f11851i.setImeOptions(268435462);
        this.f11851i.setInputType(MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND);
        this.f11851i.setMaxLength(30);
        this.f11851i.m18659a(this);
        this.f11853k = getResources().getTextArray(R.array.ACS_Locale_Language);
        this.f11857o = new ArrayList<>();
        this.f11858p = this.f11860r.findViewById(R.id.country_list_no_search_result);
        String stringExtra = this.f11859q.getIntent().getStringExtra("extra_hide_language");
        if (stringExtra != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f11853k.length; i++) {
                if (!stringExtra.equals(this.f11853k[i])) {
                    arrayList.add(this.f11853k[i]);
                }
            }
            this.f11853k = new CharSequence[arrayList.size()];
            arrayList.toArray(this.f11853k);
        }
        for (int i2 = 0; i2 < this.f11853k.length; i2++) {
            this.f11857o.add(this.f11853k[i2].toString());
        }
        this.f11855m = new C3298ge(this);
        m61a(this.f11855m);
        return this.f11860r;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ListView listViewA = m60a();
        listViewA.setItemsCanFocus(false);
        listViewA.setOnItemClickListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11859q = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f11859q = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f11852j = (String) ((TextView) view.findViewById(R.id.text1)).getText();
        C4904y.m18639b("selectedLanguage =" + this.f11852j, getClass().getSimpleName());
        this.f11859q.setResult(-1, this.f11859q.getIntent().putExtra("LANGUAGE_NAME", this.f11852j));
        this.f11859q.finish();
        ((C3298ge) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = this.f11851i.m18658a().toString();
        this.f11856n = new ArrayList<>();
        this.f11857o.clear();
        for (int i = 0; i < this.f11853k.length; i++) {
            if (string.length() <= this.f11853k[i].length() && C4827as.m18270b(this.f11853k[i].toString(), string)) {
                this.f11856n.add(this.f11853k[i].toString());
                this.f11857o.add(this.f11853k[i].toString());
                C4904y.m18639b("mFilteredCountry = " + this.f11856n, getClass().getSimpleName());
            }
        }
        this.f11855m.notifyDataSetChanged();
        if (this.f11856n != null && this.f11856n.size() == 0 && !this.f11851i.m18658a().toString().equals("")) {
            C4904y.m18634a("YES", getClass().getSimpleName());
            m60a().setVisibility(8);
            this.f11858p.setVisibility(0);
        } else {
            m60a().setVisibility(0);
            this.f11858p.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30) {
            C5179v.m19810a(this.f11859q, R.string.toast_text_max_Length, 0).show();
        }
    }
}
