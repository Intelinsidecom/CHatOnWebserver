package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.p024b.C0958i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3208bw;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.util.C3347i;

/* compiled from: MessageBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.x */
/* loaded from: classes.dex */
public abstract class AbstractViewOnClickListenerC0920x extends AbstractC0888a implements View.OnClickListener, InterfaceC0908l {

    /* renamed from: F */
    private boolean f3854F;

    /* renamed from: G */
    private Boolean f3855G;

    /* renamed from: H */
    private int f3856H = (int) C3172an.m11085a(30.0f);

    /* renamed from: I */
    private ColorStateList f3857I;

    /* renamed from: a */
    public String mo5092a(Context context) {
        return context.getString(R.string.dialog_header_text);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() throws Resources.NotFoundException {
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(this.f3808v)) {
            this.f3854F = true;
        } else {
            this.f3854F = false;
        }
        if (m5123n()) {
            this.f3794h.f4279i.setVisibility(0);
            this.f3794h.f4279i.setOnClickListener(this);
        } else {
            this.f3794h.f4280j.setVisibility(0);
            this.f3794h.f4280j.setOnClickListener(this);
        }
        m5124o();
        m5125p();
        mo5093a_();
        mo5114b_();
        mo5100d();
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        this.f3855G = null;
        if (m5123n()) {
            this.f3794h.f4279i.setVisibility(8);
            this.f3794h.f4279i.setOnClickListener(null);
            this.f3794h.f4223L.setOnClickListener(null);
            this.f3794h.f4248ac.setVisibility(8);
            this.f3794h.f4248ac.setOnClickListener(null);
            this.f3794h.f4252ag.setVisibility(8);
            this.f3794h.f4252ag.setOnClickListener(null);
            return;
        }
        this.f3794h.f4280j.setVisibility(8);
        this.f3794h.f4280j.setOnClickListener(null);
        this.f3794h.f4282l.setOnClickListener(null);
        this.f3794h.f4248ac.setOnClickListener(null);
        this.f3794h.f4287q.setOnClickListener(null);
        this.f3794h.f4287q.setTextColor(this.f3857I);
        this.f3794h.f4251af.setVisibility(8);
        this.f3794h.f4251af.setOnClickListener(null);
    }

    public void onClick(View view) {
        if (view == this.f3794h.f4279i || view == this.f3794h.f4280j) {
            this.f3797k.mo5019t();
            return;
        }
        if (view == this.f3794h.f4282l) {
            this.f3797k.mo4968a(view, (ProfileImageView) this.f3794h.f4282l, this.f3782C, this.f3783D);
            return;
        }
        if (view == this.f3794h.f4283m) {
            this.f3797k.mo5008i();
            return;
        }
        if (view == this.f3794h.f4248ac) {
            this.f3797k.mo4967a(view, this.f3801o, false);
        } else if (view == this.f3794h.f4252ag || view == this.f3794h.f4251af) {
            this.f3797k.mo4991c(mo5103c());
        }
    }

    /* renamed from: n */
    protected boolean m5123n() {
        return this.f3854F;
    }

    /* renamed from: o */
    protected void m5124o() {
        ProfileImageView profileImageView;
        if (m5123n()) {
            profileImageView = (ProfileImageView) this.f3794h.f4283m;
            this.f3794h.f4260ao.setVisibility(0);
            C3205bt.m11182a(this.f3789c).m11231c(profileImageView, C3159aa.m10962a().m10979a("chaton_id", ""));
        } else {
            profileImageView = (ProfileImageView) this.f3794h.f4282l;
            this.f3794h.f4259an.setVisibility(0);
            this.f3794h.f4281k.setVisibility(0);
            if (!TextUtils.isEmpty(this.f3800n)) {
                if (this.f3793g) {
                    C3205bt.m11182a(this.f3789c).m11211a(profileImageView, this.f3782C, this.f3784E);
                } else {
                    C3205bt.m11182a(this.f3789c).m11225b(profileImageView, EnumC3208bw.BUDDY);
                }
                this.f3794h.f4281k.setText(this.f3783D);
            } else {
                C3205bt.m11182a(this.f3789c).m11225b(profileImageView, EnumC3208bw.BUDDY);
                this.f3794h.f4281k.setText(GlobalApplication.m6451b().getString(R.string.unknown));
            }
        }
        profileImageView.setOnClickListener(this);
    }

    /* renamed from: p */
    protected void m5125p() {
        TextView textView;
        if (m5123n()) {
            textView = this.f3794h.f4233V;
        } else {
            textView = this.f3794h.f4214C;
        }
        if (this.f3811y == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(DateFormat.getTimeFormat(this.f3789c).format(this.f3788b));
        }
    }

    /* renamed from: a_ */
    protected void mo5093a_() {
        if (m5123n()) {
            if (this.f3780A == 0) {
                this.f3794h.f4277g.setVisibility(8);
                this.f3794h.f4248ac.setVisibility(8);
                this.f3794h.f4237Z.setVisibility(8);
                this.f3794h.f4247ab.setVisibility(8);
                if (C1757q.m7251b()) {
                    this.f3794h.f4246aa.setVisibility(0);
                    this.f3794h.f4236Y.setVisibility(8);
                } else {
                    this.f3794h.f4246aa.setVisibility(8);
                    this.f3794h.f4236Y.setVisibility(0);
                }
                this.f3794h.f4220I.setVisibility(8);
                this.f3794h.f4233V.setVisibility(8);
                return;
            }
            if (this.f3780A == 6) {
                this.f3794h.f4277g.setVisibility(8);
                this.f3794h.f4248ac.setVisibility(8);
                this.f3794h.f4237Z.setVisibility(8);
                this.f3794h.f4246aa.setVisibility(8);
                this.f3794h.f4236Y.setVisibility(8);
                this.f3794h.f4247ab.setVisibility(0);
                this.f3794h.f4220I.setVisibility(8);
                this.f3794h.f4233V.setVisibility(8);
                return;
            }
            if (this.f3780A == 1) {
                if (this.f3781B > 0) {
                    this.f3794h.f4277g.setVisibility(0);
                    this.f3794h.f4277g.setText(String.format("(%d)", Integer.valueOf(this.f3781B)));
                } else {
                    this.f3794h.f4277g.setVisibility(8);
                }
                this.f3794h.f4237Z.setVisibility(8);
                this.f3794h.f4246aa.setVisibility(8);
                this.f3794h.f4236Y.setVisibility(8);
                this.f3794h.f4247ab.setVisibility(8);
                this.f3794h.f4248ac.setVisibility(8);
                this.f3794h.f4220I.setVisibility(8);
                this.f3794h.f4233V.setVisibility(0);
                return;
            }
            if (this.f3780A == -1) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("Message type is fail.", AbstractViewOnClickListenerC0920x.class.getSimpleName());
                }
                this.f3794h.f4277g.setVisibility(8);
                this.f3794h.f4248ac.setVisibility(0);
                if (this.f3793g) {
                    this.f3794h.f4248ac.setOnClickListener(this);
                }
                this.f3794h.f4237Z.setVisibility(8);
                this.f3794h.f4246aa.setVisibility(8);
                this.f3794h.f4236Y.setVisibility(8);
                this.f3794h.f4247ab.setVisibility(8);
                this.f3794h.f4220I.setVisibility(8);
                this.f3794h.f4233V.setVisibility(8);
                return;
            }
            if (C3250y.f11735c) {
                C3250y.m11453c("Exceptional Message type : " + this.f3780A, AbstractViewOnClickListenerC0920x.class.getSimpleName());
                return;
            }
            return;
        }
        this.f3794h.f4217F.setVisibility(4);
        this.f3794h.f4216E.setVisibility(4);
        this.f3794h.f4218G.setVisibility(4);
        this.f3794h.f4250ae.setVisibility(8);
    }

    /* renamed from: b_ */
    protected void mo5114b_() throws Resources.NotFoundException {
        TextView textView;
        TextView textView2;
        TextView textView3;
        String strSubstring;
        float dimension;
        ImageView imageView = null;
        String strMo5103c = mo5103c();
        float f = this.f3795i;
        if (m5123n()) {
            textView3 = this.f3794h.f4223L;
            textView2 = this.f3794h.f4224M;
            textView = this.f3794h.f4225N;
            if (strMo5103c != null && m5121a(strMo5103c)) {
                this.f3794h.f4223L.setOnClickListener(this);
                this.f3794h.f4252ag.setOnClickListener(this);
                this.f3794h.f4252ag.setVisibility(0);
                if (C1075eq.m5326c(strMo5103c)) {
                    strSubstring = strMo5103c.substring(0, 100);
                } else {
                    strSubstring = strMo5103c.substring(0, 1000);
                }
            } else {
                this.f3794h.f4223L.setOnClickListener(this);
                this.f3794h.f4252ag.setOnClickListener(null);
                this.f3794h.f4252ag.setVisibility(8);
                strSubstring = strMo5103c;
            }
        } else {
            TextView textView4 = this.f3794h.f4287q;
            TextView textView5 = this.f3794h.f4288r;
            TextView textView6 = this.f3794h.f4289s;
            ImageView imageView2 = this.f3794h.f4290t;
            if (strMo5103c != null && m5121a(strMo5103c)) {
                this.f3794h.f4287q.setOnClickListener(this);
                this.f3794h.f4251af.setOnClickListener(this);
                this.f3794h.f4251af.setVisibility(0);
                if (C1075eq.m5326c(strMo5103c)) {
                    textView = textView6;
                    textView2 = textView5;
                    textView3 = textView4;
                    strSubstring = strMo5103c.substring(0, 100);
                    imageView = imageView2;
                } else {
                    textView = textView6;
                    textView2 = textView5;
                    textView3 = textView4;
                    strSubstring = strMo5103c.substring(0, 1000);
                    imageView = imageView2;
                }
            } else {
                this.f3794h.f4287q.setOnClickListener(null);
                this.f3794h.f4251af.setOnClickListener(null);
                this.f3794h.f4251af.setVisibility(8);
                imageView = imageView2;
                textView = textView6;
                textView2 = textView5;
                textView3 = textView4;
                strSubstring = strMo5103c;
            }
        }
        this.f3857I = textView3.getTextColors();
        if (!TextUtils.isEmpty(this.f3803q)) {
            textView3.setTextColor(this.f3789c.getResources().getColor(R.color.translate_source_text));
        } else {
            textView3.setTextColor(this.f3789c.getResources().getColor(R.color.disclaimer_text_color));
        }
        textView2.setVisibility(8);
        if (TextUtils.isEmpty(strSubstring)) {
            textView3.setText(strSubstring);
            textView3.setVisibility(8);
            textView.setText(strSubstring);
            textView.setVisibility(8);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            if (C1075eq.m5326c(strSubstring)) {
                strSubstring = new StringBuilder(strSubstring).substring(1);
                dimension = this.f3789c.getResources().getDimension(R.dimen.font_size_big_text);
            } else {
                dimension = f;
            }
            textView3.setTextSize(0, dimension);
            textView.setTextSize(0, dimension);
            if (!TextUtils.isEmpty(this.f3803q)) {
                textView3.setText(C1835j.m7508a(this.f3789c, strSubstring, this.f3856H));
                textView3.setVisibility(0);
                textView.setText(C1835j.m7508a(this.f3789c, this.f3803q, this.f3856H));
                textView.setVisibility(0);
                if (imageView != null && C0958i.m5166a()) {
                    imageView.setVisibility(0);
                    imageView.setOnClickListener(new ViewOnClickListenerC0921y(this));
                }
            } else {
                textView.setVisibility(8);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                textView3.setText(C1835j.m7508a(this.f3789c, strSubstring, this.f3856H));
                textView3.setVisibility(0);
            }
        }
        this.f3794h.f4231T.setVisibility(8);
        this.f3794h.f4295y.setVisibility(8);
        this.f3794h.f4296z.setVisibility(8);
    }

    /* renamed from: c */
    protected String mo5103c() {
        return this.f3802p;
    }

    /* renamed from: d */
    protected void mo5100d() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM11779b = C3347i.m11779b() - C3172an.m11085a(105.0f);
        if (m5123n()) {
            textView = this.f3794h.f4223L;
            textView2 = this.f3794h.f4225N;
            textView3 = this.f3794h.f4233V;
            textView4 = this.f3794h.f4277g;
        } else {
            textView = this.f3794h.f4287q;
            textView2 = this.f3794h.f4289s;
            textView3 = this.f3794h.f4214C;
        }
        float fMeasureText = fM11779b - textView3.getPaint().measureText(textView3.getText().toString());
        float fM5122a = m5122a(textView4 != null ? fMeasureText - textView4.getPaint().measureText(textView4.getText().toString()) : fMeasureText);
        textView.setMaxWidth((int) fM5122a);
        if (this.f3794h.f4290t != null && this.f3794h.f4290t.getVisibility() == 0) {
            textView2.setMaxWidth((int) (fM5122a - C3172an.m11085a(41.0f)));
        } else {
            textView2.setMaxWidth((int) fM5122a);
        }
    }

    /* renamed from: a */
    protected float m5122a(float f) {
        return f;
    }

    /* renamed from: a */
    private boolean m5121a(String str) {
        int i = 1000;
        if (this.f3855G == null) {
            if (!TextUtils.isEmpty(str)) {
                if (C1075eq.m5326c(str)) {
                    i = 100;
                }
                if (str.length() > i) {
                    this.f3855G = true;
                } else {
                    this.f3855G = false;
                }
            } else {
                this.f3855G = false;
            }
        }
        return this.f3855G.booleanValue();
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0908l
    /* renamed from: b */
    public boolean mo5112b() {
        return true;
    }

    /* renamed from: c_ */
    public void mo5106c_() {
    }

    /* renamed from: l */
    public String mo5107l() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON";
    }

    /* renamed from: q */
    protected String m5126q() {
        return TextUtils.isEmpty(this.f3803q) ? "" : "\n\n" + this.f3803q;
    }
}
