package com.sec.chaton.event;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.util.C4809aa;
import com.sec.common.util.log.collector.C5043h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NewFeatureFragment extends Fragment {

    /* renamed from: a */
    private ViewPager f8244a;

    /* renamed from: b */
    private C2321b f8245b;

    /* renamed from: c */
    private List<String> f8246c;

    /* renamed from: d */
    private LinearLayout f8247d;

    /* renamed from: e */
    private View f8248e;

    /* renamed from: f */
    private NewFeature f8249f;

    /* renamed from: g */
    private int f8250g = 0;

    /* renamed from: h */
    private int f8251h = 0;

    /* renamed from: i */
    private ArrayList<String> f8252i;

    /* renamed from: j */
    private WebView f8253j;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10236a() {
        this.f8247d = (LinearLayout) this.f8248e.findViewById(R.id.ll_title_layout);
        this.f8247d.removeAllViewsInLayout();
        for (int i = 0; i < this.f8251h; i++) {
            ImageView imageView = new ImageView(this.f8249f);
            if (this.f8250g == i) {
                imageView.setBackgroundResource(R.drawable.device_page_indicator_02);
            } else {
                imageView.setBackgroundResource(R.drawable.device_page_indicator_01);
            }
            if (i < this.f8251h - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, 13, 0);
                imageView.setLayoutParams(layoutParams);
            }
            this.f8247d.addView(imageView);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8249f = (NewFeature) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("new_feature_url_list", this.f8252i);
        bundle.putInt("new_feature_count", this.f8251h);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        C5043h.m19179a().m19185a("5000", "2122", false);
        this.f8248e = layoutInflater.inflate(R.layout.new_feature_content, viewGroup, false);
        String str = C1427a.f5063a;
        if (bundle != null) {
            this.f8252i = bundle.getStringArrayList("new_feature_url_list");
            this.f8251h = bundle.getInt("new_feature_count");
        } else {
            this.f8252i = new ArrayList<>();
            this.f8251h = C4809aa.m18104a().m18120a("new_feature_count", (Integer) 0).intValue();
            try {
                JSONObject jSONObject = new JSONObject(C4809aa.m18104a().m18121a("new_feature_url_list", ""));
                for (int i = 0; i < this.f8251h; i++) {
                    String str2 = jSONObject.getString(String.valueOf(i)) + "&chaton=" + str;
                    if (!TextUtils.isEmpty(str2)) {
                        this.f8252i.add(str2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.f8251h > 1) {
            m10236a();
        }
        this.f8246c = new ArrayList();
        for (int i2 = 0; i2 < this.f8251h; i2++) {
            this.f8246c.add("");
        }
        Button button = (Button) this.f8248e.findViewById(R.id.button1);
        button.setText(R.string.close);
        button.setOnClickListener(new ViewOnClickListenerC2320a(this));
        C4809aa.m18106a("new_feature_count", (Integer) 0);
        C4809aa.m18108a("new_feature_url_list", "");
        C4809aa.m18105a("new_feature_check", (Boolean) true);
        C4809aa.m18107a("new_feature_dont_show_check_time", Long.valueOf(System.currentTimeMillis()));
        this.f8244a = (ViewPager) this.f8248e.findViewById(R.id.content_pager);
        this.f8245b = new C2321b(this);
        this.f8244a.setAdapter(this.f8245b);
        this.f8244a.setOffscreenPageLimit(this.f8251h);
        this.f8244a.setOnPageChangeListener(new C2324e(this));
        this.f8244a.setCurrentItem(0);
        return this.f8248e;
    }
}
