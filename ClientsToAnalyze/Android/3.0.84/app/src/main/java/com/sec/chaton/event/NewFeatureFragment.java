package com.sec.chaton.event;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NewFeatureFragment extends Fragment {

    /* renamed from: a */
    private ViewPager f5424a;

    /* renamed from: b */
    private C1467i f5425b;

    /* renamed from: c */
    private List<String> f5426c;

    /* renamed from: d */
    private LinearLayout f5427d;

    /* renamed from: e */
    private LinearLayout f5428e;

    /* renamed from: f */
    private View f5429f;

    /* renamed from: g */
    private NewFeature f5430g;

    /* renamed from: h */
    private int f5431h = 0;

    /* renamed from: i */
    private int f5432i = 0;

    /* renamed from: j */
    private ArrayList<String> f5433j;

    /* renamed from: k */
    private WebView f5434k;

    /* renamed from: l */
    private CheckBox f5435l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6375a() {
        this.f5428e = (LinearLayout) this.f5429f.findViewById(R.id.ll_title_layout);
        this.f5428e.removeAllViewsInLayout();
        for (int i = 0; i < this.f5432i; i++) {
            ImageView imageView = new ImageView(this.f5430g);
            if (this.f5431h == i) {
                imageView.setBackgroundResource(R.drawable.device_page_indicator_02);
            } else {
                imageView.setBackgroundResource(R.drawable.device_page_indicator_01);
            }
            if (i < this.f5432i - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, 13, 0);
                imageView.setLayoutParams(layoutParams);
            }
            this.f5428e.addView(imageView);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5430g = (NewFeature) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        this.f5429f = layoutInflater.inflate(R.layout.new_feature_content, viewGroup, false);
        this.f5427d = (LinearLayout) this.f5429f.findViewById(R.id.new_feature_loading);
        this.f5435l = (CheckBox) this.f5429f.findViewById(R.id.new_feature_checkbox);
        this.f5435l.setVisibility(8);
        this.f5433j = new ArrayList<>();
        this.f5432i = C3159aa.m10962a().m10978a("new_feature_count", (Integer) 0).intValue();
        try {
            JSONObject jSONObject = new JSONObject(C3159aa.m10962a().m10979a("new_feature_url_list", ""));
            for (int i = 0; i < this.f5432i; i++) {
                this.f5433j.add(jSONObject.getString(String.valueOf(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.f5432i > 1) {
            m6375a();
        }
        this.f5426c = new ArrayList();
        for (int i2 = 0; i2 < this.f5432i; i2++) {
            this.f5426c.add("");
        }
        Button button = (Button) this.f5429f.findViewById(R.id.button1);
        button.setText(R.string.newfeature_get_started);
        button.setOnClickListener(new ViewOnClickListenerC1466h(this));
        C3159aa.m10964a("new_feature_count", (Integer) 0);
        C3159aa.m10966a("new_feature_url_list", "");
        C3159aa.m10963a("new_feature_check", (Boolean) true);
        C3159aa.m10965a("new_feature_dont_show_check_time", Long.valueOf(System.currentTimeMillis()));
        this.f5424a = (ViewPager) this.f5429f.findViewById(R.id.content_pager);
        this.f5425b = new C1467i(this);
        this.f5424a.setAdapter(this.f5425b);
        this.f5424a.setOffscreenPageLimit(this.f5432i);
        this.f5424a.setOnPageChangeListener(new C1470l(this));
        this.f5424a.setCurrentItem(0);
        this.f5427d.setVisibility(0);
        return this.f5429f;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
