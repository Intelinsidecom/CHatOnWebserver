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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class UsingChatONDialogFragment extends Fragment {

    /* renamed from: a */
    private static ViewPager f8255a;

    /* renamed from: b */
    private C2327h f8256b;

    /* renamed from: c */
    private List<String> f8257c;

    /* renamed from: d */
    private LinearLayout f8258d;

    /* renamed from: e */
    private View f8259e;

    /* renamed from: f */
    private int f8260f = 0;

    /* renamed from: g */
    private int f8261g = 0;

    /* renamed from: h */
    private Button f8262h;

    /* renamed from: i */
    private Button f8263i;

    /* renamed from: j */
    private RelativeLayout f8264j;

    /* renamed from: k */
    private TextView f8265k;

    /* renamed from: l */
    private UsingChatONDialogActivity f8266l;

    /* renamed from: m */
    private HashMap<Integer, Fragment> f8267m;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10247b() {
        this.f8258d = (LinearLayout) this.f8259e.findViewById(R.id.ll_title_layout);
        this.f8258d.removeAllViewsInLayout();
        for (int i = 0; i < this.f8261g; i++) {
            ImageView imageView = new ImageView(this.f8266l);
            if (this.f8260f == i) {
                imageView.setBackgroundResource(R.drawable.device_page_indicator_02);
            } else {
                imageView.setBackgroundResource(R.drawable.device_page_indicator_01);
            }
            if (i < this.f8261g - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, 13, 0);
                imageView.setLayoutParams(layoutParams);
            }
            this.f8258d.addView(imageView);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8267m = new HashMap<>();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8266l = (UsingChatONDialogActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        this.f8259e = layoutInflater.inflate(R.layout.layout_using_chaton_dialog, viewGroup, false);
        this.f8264j = (RelativeLayout) this.f8259e.findViewById(R.id.using_chaton);
        this.f8264j.setBackgroundResource(R.drawable.item_using_chaton_dialog_background_first);
        this.f8265k = (TextView) this.f8259e.findViewById(R.id.using_chaton_fotter);
        this.f8265k.setText(R.string.chaton_sms_regi_intro_fotter);
        this.f8261g = 3;
        m10247b();
        this.f8257c = new ArrayList();
        for (int i = 0; i < this.f8261g; i++) {
            this.f8257c.add("");
        }
        this.f8262h = (Button) this.f8259e.findViewById(R.id.btn_regi_full);
        this.f8262h.setText(R.string.chaton_sms_regi_intro_button_full_feature_user);
        this.f8262h.setOnClickListener(new ViewOnClickListenerC2325f(this));
        this.f8263i = (Button) this.f8259e.findViewById(R.id.btn_regi_lite);
        this.f8263i.setText(R.string.chaton_sms_regi_intro_button_lite_feature_user);
        this.f8263i.setOnClickListener(new ViewOnClickListenerC2326g(this));
        f8255a = (ViewPager) this.f8259e.findViewById(R.id.using_chaton_content_pager);
        this.f8256b = new C2327h(this, this.f8266l.m50e(), null);
        f8255a.setAdapter(this.f8256b);
        f8255a.setOffscreenPageLimit(this.f8261g);
        f8255a.setOnPageChangeListener(new C2329j(this));
        f8255a.setCurrentItem(0);
        return this.f8259e;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public class UsingChatONDialogContentPagerFragment extends Fragment {

        /* renamed from: a */
        private int f8268a;

        /* renamed from: b */
        private View f8269b;

        /* renamed from: c */
        private TextView f8270c;

        /* renamed from: d */
        private TextView f8271d;

        /* renamed from: e */
        private ImageView f8272e;

        public UsingChatONDialogContentPagerFragment() {
        }

        public UsingChatONDialogContentPagerFragment(int i) {
            this.f8268a = i;
        }

        @Override // android.support.v4.app.Fragment
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("index", this.f8268a);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f8268a = bundle.getInt("index");
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f8269b = LayoutInflater.from(CommonApplication.m18732r()).inflate(R.layout.layout_using_chaton_dialog_pager, (ViewGroup) UsingChatONDialogFragment.f8255a, false);
            this.f8270c = (TextView) this.f8269b.findViewById(R.id.pager_header);
            this.f8271d = (TextView) this.f8269b.findViewById(R.id.pager_body);
            this.f8272e = (ImageView) this.f8269b.findViewById(R.id.pager_image);
            m10250a(this.f8268a);
            return this.f8269b;
        }

        /* renamed from: a */
        public void m10250a(int i) {
            this.f8268a = i;
            if (this.f8268a == 1) {
                this.f8272e.setImageResource(R.drawable.sms_introduce_img_02);
                this.f8270c.setText(R.string.chaton_sms_regi_intro_second_header);
                this.f8271d.setText(R.string.chaton_sms_regi_intro_second_body);
            } else if (this.f8268a == 2) {
                this.f8272e.setImageResource(R.drawable.sms_introduce_img_03);
                this.f8270c.setText(R.string.chaton_sms_regi_intro_third_header);
                this.f8271d.setText(R.string.chaton_sms_regi_intro_third_body);
            } else {
                this.f8272e.setImageResource(R.drawable.sms_introduce_img_01);
                this.f8270c.setText(R.string.chaton_sms_regi_intro_first_header);
                this.f8271d.setText("");
                this.f8271d.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.f8271d.getText().toString())) {
                this.f8271d.setVisibility(8);
            } else {
                this.f8271d.setVisibility(0);
            }
        }
    }
}
