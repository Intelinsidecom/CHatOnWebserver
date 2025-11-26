package com.sec.chaton.chat.p023a;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.p035io.entry.MessageType4Entry;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3347i;
import org.json.JSONException;

/* compiled from: AppLinkBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.c */
/* loaded from: classes.dex */
public class C0899c extends AbstractViewOnClickListenerC0920x {
    /* renamed from: e */
    void m5104e() {
        if (m5123n()) {
            this.f3794h.f4279i.setVisibility(8);
            this.f3794h.f4279i.setOnClickListener(null);
        } else {
            this.f3794h.f4280j.setVisibility(8);
            this.f3794h.f4280j.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() throws Resources.NotFoundException {
        String str;
        String str2;
        super.mo5087a();
        String str3 = this.f3802p;
        try {
            MessageType4Entry messageType4Entry = ApplinkMsgEntry.parse(this.f3802p);
            if (messageType4Entry == null) {
                C3250y.m11450b("onDrawBubble(), hide bubble,  empty parse result", getClass().getSimpleName());
                m5104e();
                return;
            }
            if (!(messageType4Entry instanceof ApplinkMsgEntry)) {
                C3250y.m11450b("onDrawBubble(), hide bubble,  not received full-contents yet", getClass().getSimpleName());
                m5104e();
                return;
            }
            String displayMessage = messageType4Entry.getDisplayMessage();
            ApplinkMsgEntry applinkMsgEntry = (ApplinkMsgEntry) messageType4Entry;
            ApplinkMsgEntry.ContentEntry.AppInfoEntry.ParamEntry param = applinkMsgEntry.getParam("android", "phone");
            String appName = applinkMsgEntry.getAppName();
            if (param != null) {
                str2 = String.format(GlobalApplication.m6451b().getString(R.string.applink_open_using), appName);
                str = displayMessage;
            } else {
                String anythingExecuteUri = applinkMsgEntry.getAnythingExecuteUri();
                if (TextUtils.isEmpty(anythingExecuteUri)) {
                    str = String.format("%s", displayMessage);
                    str2 = null;
                } else {
                    str = String.format("%s\n\n%s", displayMessage, anythingExecuteUri);
                    str2 = null;
                }
            }
            if (param != null) {
                Float fValueOf = Float.valueOf(this.f3795i);
                CharSequence charSequenceM7508a = C1835j.m7508a(this.f3789c, str, (int) C3172an.m11085a(30.0f));
                if (m5123n()) {
                    if (TextUtils.isEmpty(str)) {
                        this.f3794h.f4262aq.setText(str);
                    } else {
                        this.f3794h.f4262aq.setText(charSequenceM7508a);
                    }
                    this.f3794h.f4263ar.setOnClickListener(this);
                    this.f3794h.f4264as.setText(str2);
                    this.f3794h.f4262aq.setTextSize(0, fValueOf.floatValue());
                    this.f3794h.f4264as.setTextSize(0, fValueOf.floatValue());
                    this.f3794h.f4262aq.setTextColor(-16777216);
                    this.f3794h.f4261ap.setVisibility(0);
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f3794h.f4266au.setText(str);
                } else {
                    this.f3794h.f4266au.setText(charSequenceM7508a);
                }
                this.f3794h.f4267av.setOnClickListener(this);
                this.f3794h.f4268aw.setText(str2);
                this.f3794h.f4266au.setTextSize(0, fValueOf.floatValue());
                this.f3794h.f4268aw.setTextSize(0, fValueOf.floatValue());
                this.f3794h.f4287q.setTextColor(-16777216);
                this.f3794h.f4265at.setVisibility(0);
                return;
            }
            Float fValueOf2 = Float.valueOf(this.f3795i);
            CharSequence charSequenceM7508a2 = C1835j.m7508a(this.f3789c, str, (int) C3172an.m11085a(30.0f));
            if (m5123n()) {
                if (TextUtils.isEmpty(str)) {
                    this.f3794h.f4262aq.setText(str);
                } else {
                    this.f3794h.f4262aq.setText(charSequenceM7508a2);
                }
                this.f3794h.f4263ar.setVisibility(8);
                this.f3794h.f4262aq.setTextSize(0, fValueOf2.floatValue());
                this.f3794h.f4262aq.setTextColor(-16777216);
                this.f3794h.f4261ap.setVisibility(0);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                this.f3794h.f4266au.setText(str);
            } else {
                this.f3794h.f4266au.setText(charSequenceM7508a2);
            }
            this.f3794h.f4267av.setVisibility(8);
            this.f3794h.f4266au.setTextSize(0, fValueOf2.floatValue());
            this.f3794h.f4266au.setTextColor(-16777216);
            this.f3794h.f4265at.setVisibility(0);
        } catch (JSONException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            C3250y.m11450b("onDrawBubble(), exceptions!!!", getClass().getSimpleName());
            m5104e();
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4261ap.setVisibility(8);
            this.f3794h.f4263ar.setVisibility(0);
            this.f3794h.f4263ar.setOnClickListener(null);
        } else {
            this.f3794h.f4265at.setVisibility(8);
            this.f3794h.f4267av.setVisibility(0);
            this.f3794h.f4267av.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    protected String mo5103c() {
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4263ar || view == this.f3794h.f4267av) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo4996d(m5123n(), this.f3791e);
            }
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: d */
    protected void mo5100d() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM11779b = C3347i.m11779b() - C3172an.m11085a(105.0f);
        if (m5123n()) {
            textView = this.f3794h.f4262aq;
            textView2 = this.f3794h.f4264as;
            textView3 = this.f3794h.f4233V;
            textView4 = this.f3794h.f4277g;
        } else {
            textView = this.f3794h.f4266au;
            textView2 = this.f3794h.f4268aw;
            textView3 = this.f3794h.f4214C;
        }
        float fMeasureText = fM11779b - textView3.getPaint().measureText(textView3.getText().toString());
        float fA = m5122a(textView4 != null ? fMeasureText - textView4.getPaint().measureText(textView4.getText().toString()) : fMeasureText);
        textView.setMaxWidth((int) fA);
        textView2.setMaxWidth((int) (fA - C3172an.m11085a(45.0f)));
    }
}
