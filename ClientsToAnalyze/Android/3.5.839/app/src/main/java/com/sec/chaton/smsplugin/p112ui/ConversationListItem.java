package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p102b.InterfaceC3788g;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.CommonApplication;
import java.util.Date;

@TargetApi(14)
/* loaded from: classes.dex */
public class ConversationListItem extends RelativeLayout implements InterfaceC3788g {

    /* renamed from: g */
    private static Drawable f14758g;

    /* renamed from: k */
    private static final StyleSpan f14759k = new StyleSpan(1);

    /* renamed from: a */
    private TextView f14760a;

    /* renamed from: b */
    private TextView f14761b;

    /* renamed from: c */
    private TextView f14762c;

    /* renamed from: d */
    private TextView f14763d;

    /* renamed from: e */
    private ProfileImageView f14764e;

    /* renamed from: f */
    private CheckBox f14765f;

    /* renamed from: h */
    private RelativeLayout.LayoutParams f14766h;

    /* renamed from: i */
    private final Handler f14767i;

    /* renamed from: j */
    private C3790i f14768j;

    public ConversationListItem(Context context) {
        super(context);
        this.f14767i = new Handler();
    }

    public ConversationListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14767i = new Handler();
        if (f14758g == null) {
            f14758g = context.getResources().getDrawable(R.drawable.profile_photo_buddy_default);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f14761b = (TextView) findViewById(R.id.from);
        this.f14760a = (TextView) findViewById(R.id.subject);
        this.f14762c = (TextView) findViewById(R.id.unreadCount);
        this.f14763d = (TextView) findViewById(R.id.date);
        this.f14764e = (ProfileImageView) findViewById(R.id.avatar);
        this.f14765f = (CheckBox) findViewById(android.R.id.checkbox);
    }

    /* renamed from: b */
    private CharSequence m15750b() throws Resources.NotFoundException {
        String string;
        if (this.f14768j.m14362g().size() > 0) {
            string = this.f14768j.m14362g().m14310b(", ");
        } else {
            string = this.mContext.getResources().getString(R.string.no_name);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        if (!C3847e.m14627K() && this.f14768j.m14368m()) {
            spannableStringBuilder.setSpan(f14759k, 0, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    /* renamed from: c */
    private void m15751c() {
        if (this.f14768j.m14362g().size() == 1) {
            C3782a c3782a = this.f14768j.m14362g().get(0);
            Drawable drawableM14256a = c3782a.m14256a(this.mContext, f14758g);
            if (c3782a.m14271m()) {
                C2496n.m10784c(this.f14764e, c3782a.m14269k(), EnumC2498p.SQUARE);
            } else {
                this.f14764e.setImageDrawable(drawableM14256a);
            }
        } else {
            this.f14764e.setImageDrawable(f14758g);
        }
        this.f14764e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m15752d() {
        this.f14761b.setText(m15750b());
        m15751c();
    }

    @Override // com.sec.chaton.smsplugin.p102b.InterfaceC3788g
    /* renamed from: a */
    public void mo14300a(C3782a c3782a) {
        this.f14767i.post(new RunnableC4351r(this));
    }

    /* renamed from: a */
    public final void m15754a(Context context, C3790i c3790i) {
        this.f14768j = c3790i;
        if (((ListActivity) context).getListView().getCheckedItemCount() > 0) {
            this.f14765f.setVisibility(0);
            if (c3790i.m14369n()) {
                this.f14765f.setChecked(true);
            } else {
                this.f14765f.setChecked(false);
            }
        } else {
            this.f14765f.setVisibility(8);
        }
        if (C3847e.m14627K()) {
            int iM14366k = c3790i.m14366k();
            this.f14766h = (RelativeLayout.LayoutParams) this.f14762c.getLayoutParams();
            if (iM14366k > 0) {
                this.f14762c.setText(String.valueOf(iM14366k));
                this.f14762c.setVisibility(0);
                if (this.f14765f.getVisibility() == 0) {
                    this.f14766h.addRule(11, 0);
                    this.f14766h.addRule(0, android.R.id.checkbox);
                } else if (this.f14765f.getVisibility() == 8) {
                    this.f14766h.addRule(11, 1);
                }
            } else {
                this.f14762c.setVisibility(8);
            }
        }
        this.f14761b.setText(m15750b());
        this.f14763d.setText(m15748a(c3790i.m14364i()));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14761b.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14763d.getLayoutParams();
        if (this.f14765f.getVisibility() == 0) {
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, android.R.id.checkbox);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, android.R.id.checkbox);
        } else if (this.f14765f.getVisibility() == 8) {
            layoutParams.addRule(11, 1);
            layoutParams2.addRule(11, 1);
        }
        c3790i.m14362g();
        C3782a.m14212a(this);
        if (C3847e.m14694az()) {
            this.f14760a.setText(C2799k.m11709a(context, c3790i.m14367l(), (int) (this.f14760a.getLineHeight() * 1.2f)));
        } else {
            this.f14760a.setText(c3790i.m14367l());
        }
        ((RelativeLayout.LayoutParams) this.f14760a.getLayoutParams()).addRule(0, R.id.date);
        m15751c();
    }

    /* renamed from: a */
    public final void m15753a() {
        C3782a.m14221b(this);
    }

    /* renamed from: a */
    private String m15748a(long j) {
        return DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j));
    }
}
