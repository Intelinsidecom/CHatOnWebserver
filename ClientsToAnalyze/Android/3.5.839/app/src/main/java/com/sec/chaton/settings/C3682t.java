package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.widget.AdaptableTextView;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.t */
/* loaded from: classes.dex */
public class C3682t extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13282a;

    /* renamed from: b */
    private ImageView f13283b;

    /* renamed from: c */
    private TextView f13284c;

    /* renamed from: d */
    private TextView f13285d;

    /* renamed from: e */
    private Button f13286e;

    /* renamed from: f */
    private AdaptableTextView f13287f;

    public C3682t(AccountFragment accountFragment) {
        this.f13282a = accountFragment;
        accountFragment.m13335b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13282a.f12499z;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            if (i == 2) {
                view = this.f13282a.f12492s.inflate(R.layout.layout_common_text_line, viewGroup, false);
                this.f13287f = (AdaptableTextView) view.findViewById(R.id.text1);
                this.f13287f.setText("SNS");
            } else {
                view = this.f13282a.f12492s.inflate(R.layout.layout_image_text_button, viewGroup, false);
                this.f13283b = (ImageView) view.findViewById(R.id.image);
                this.f13284c = (TextView) view.findViewById(R.id.main_title);
                this.f13285d = (TextView) view.findViewById(R.id.sub_title);
                this.f13286e = (Button) view.findViewById(R.id.button);
                this.f13286e.setVisibility(8);
            }
        }
        switch (i) {
            case 0:
                this.f13283b.setImageResource(R.drawable.profile_info_ic_account);
                this.f13286e.setVisibility(8);
                if (C4822an.m18255w()) {
                    this.f13284c.setText(C4822an.m18254v());
                    this.f13285d.setText(R.string.setting_samsung_account);
                } else {
                    this.f13284c.setText(R.string.setting_samsung_account);
                    this.f13285d.setText(R.string.settings_account_samsung_account_comment2);
                }
                return view;
            case 1:
                this.f13283b.setImageResource(R.drawable.profile_info_ic_call);
                String strM18121a = C4809aa.m18104a().m18121a("msisdn", "");
                this.f13286e.setVisibility(8);
                if (TextUtils.isEmpty(strM18121a)) {
                    this.f13284c.setText(R.string.buddy_phone_number);
                    this.f13285d.setText(R.string.regist_inputPno);
                } else {
                    this.f13284c.setText("+" + strM18121a);
                    this.f13285d.setText(R.string.buddy_phone_number);
                }
                return view;
            case 2:
                view.setEnabled(false);
                return view;
            case 3:
                if (!this.f13282a.f12469D) {
                    if (this.f13282a.f12471F) {
                        m13945a();
                    } else {
                        m13946b();
                    }
                } else {
                    m13947c();
                }
                return view;
            case 4:
                if (this.f13282a.f12469D && this.f13282a.f12471F) {
                    m13945a();
                } else {
                    m13946b();
                }
                return view;
            case 5:
                m13946b();
                return view;
            default:
                return view;
        }
    }

    /* renamed from: a */
    private void m13945a() {
        this.f13283b.setImageResource(R.drawable.odnoklassniki_btn_normal);
        if (this.f13282a.f12467B && m13948d()) {
            this.f13284c.setText(this.f13282a.f12494u.mo16647b());
            this.f13285d.setText(R.string.tellfriends_via_odnoklassniki);
            this.f13286e.setVisibility(8);
            return;
        }
        this.f13284c.setText(R.string.tellfriends_via_odnoklassniki);
        if ((!this.f13282a.m13338b("register_od_sns_type") || this.f13282a.m13334a(C4368e.f15818d)) && this.f13282a.m13341d()) {
            if (this.f13282a.m13334a(C4368e.f15818d)) {
                this.f13284c.setText(this.f13282a.f12494u.mo16647b());
            } else if (!this.f13282a.m13338b("register_od_sns_type")) {
                this.f13284c.setText(this.f13282a.f12496w.mo16647b());
            }
            this.f13285d.setText(R.string.tellfriends_via_odnoklassniki);
            this.f13286e.setText(R.string.settings_account_sns_unlink);
            if (!C4822an.m18255w() && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", "")) && this.f13282a.m13334a(C4368e.f15818d)) {
                this.f13286e.setVisibility(8);
            } else {
                this.f13286e.setVisibility(0);
            }
            this.f13286e.setOnClickListener(new ViewOnClickListenerC3683u(this));
            return;
        }
        this.f13285d.setText(this.f13282a.getString(R.string.settings_account_sns_title));
        this.f13286e.setVisibility(8);
    }

    /* renamed from: b */
    private void m13946b() {
        this.f13283b.setImageResource(R.drawable.vkontakte_btn_normal);
        if (this.f13282a.f12468C && m13948d()) {
            this.f13284c.setText(this.f13282a.f12494u.mo16647b());
            this.f13285d.setText(R.string.tellfriends_via_vkontakte);
            this.f13286e.setVisibility(8);
            return;
        }
        this.f13284c.setText(R.string.tellfriends_via_vkontakte);
        if ((!this.f13282a.m13338b("register_vk_sns_type") || this.f13282a.m13334a(C4368e.f15820f)) && this.f13282a.m13343e()) {
            if (this.f13282a.m13334a(C4368e.f15820f)) {
                this.f13284c.setText(this.f13282a.f12494u.mo16647b());
            } else if (!this.f13282a.m13338b("register_vk_sns_type")) {
                this.f13284c.setText(this.f13282a.f12497x.mo16647b());
            }
            this.f13285d.setText(R.string.tellfriends_via_vkontakte);
            this.f13286e.setText(R.string.settings_account_sns_unlink);
            if (!C4822an.m18255w() && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", "")) && this.f13282a.m13334a(C4368e.f15820f)) {
                this.f13286e.setVisibility(8);
            } else {
                this.f13286e.setVisibility(0);
            }
            this.f13286e.setOnClickListener(new ViewOnClickListenerC3686x(this));
            return;
        }
        this.f13285d.setText(this.f13282a.getString(R.string.settings_account_sns_title));
        this.f13286e.setVisibility(8);
    }

    /* renamed from: c */
    private void m13947c() {
        this.f13283b.setImageResource(R.drawable.facebook_btn_normal);
        if (this.f13282a.f12466A && m13948d()) {
            this.f13284c.setText(this.f13282a.f12494u.mo16647b());
            this.f13285d.setText(R.string.user_facebook_account);
            this.f13286e.setVisibility(8);
            return;
        }
        this.f13284c.setText(R.string.user_facebook_account);
        if ((!this.f13282a.m13338b("register_fb_sns_type") || this.f13282a.m13334a(C4368e.f15815a)) && this.f13282a.m13340c()) {
            if (this.f13282a.m13334a(C4368e.f15815a)) {
                this.f13284c.setText(this.f13282a.f12494u.mo16647b());
            } else if (!this.f13282a.m13338b("register_fb_sns_type")) {
                this.f13284c.setText(this.f13282a.f12495v.mo16647b());
            }
            this.f13285d.setText(R.string.user_facebook_account);
            this.f13286e.setText(R.string.settings_account_sns_unlink);
            if (!C4822an.m18255w() && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", "")) && this.f13282a.m13334a(C4368e.f15815a)) {
                this.f13286e.setVisibility(8);
            } else {
                this.f13286e.setVisibility(0);
            }
            this.f13286e.setOnClickListener(new ViewOnClickListenerC3483aa(this));
            return;
        }
        this.f13285d.setText(this.f13282a.getString(R.string.settings_account_sns_title));
        this.f13286e.setVisibility(8);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        switch (i) {
            case 0:
                return !C4822an.m18255w();
            case 1:
                return TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""));
            case 2:
            default:
                return super.isEnabled(i);
            case 3:
                if (this.f13282a.f12469D) {
                    if (this.f13282a.m13334a(C4368e.f15815a) && this.f13282a.m13340c()) {
                        return false;
                    }
                } else if (this.f13282a.f12471F) {
                    if (this.f13282a.m13334a(C4368e.f15818d) && this.f13282a.m13341d()) {
                        return false;
                    }
                } else if (this.f13282a.m13334a(C4368e.f15820f) && this.f13282a.m13343e()) {
                    return false;
                }
                return true;
            case 4:
                if (this.f13282a.f12469D) {
                    if (this.f13282a.f12471F) {
                        if (this.f13282a.m13334a(C4368e.f15818d) && this.f13282a.m13341d()) {
                            return false;
                        }
                    } else if (this.f13282a.m13334a(C4368e.f15820f) && this.f13282a.m13343e()) {
                        return false;
                    }
                } else if (this.f13282a.f12470E && this.f13282a.m13334a(C4368e.f15820f) && this.f13282a.m13343e()) {
                    return false;
                }
                return true;
            case 5:
                return (this.f13282a.m13334a(C4368e.f15820f) && this.f13282a.m13343e()) ? false : true;
        }
    }

    /* renamed from: d */
    private boolean m13948d() {
        return !C4822an.m18255w() && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", (String) null));
    }
}
