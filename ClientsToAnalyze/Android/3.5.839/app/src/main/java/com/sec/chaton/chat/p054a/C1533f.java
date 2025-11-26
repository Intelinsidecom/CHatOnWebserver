package com.sec.chaton.chat.p054a;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.p065io.entry.MessageType4Entry;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import org.json.JSONException;

/* compiled from: AppLinkBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.f */
/* loaded from: classes.dex */
public class C1533f extends AbstractViewOnClickListenerC1514ah {
    /* renamed from: f */
    void m8428f() {
        if (m8404s()) {
            this.f5861h.f6464i.setVisibility(8);
            this.f5861h.f6464i.setOnClickListener(null);
        } else {
            this.f5861h.f6465j.setVisibility(8);
            this.f5861h.f6465j.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() throws Resources.NotFoundException {
        String str;
        String str2;
        super.mo8357a();
        String str3 = this.f5869p;
        try {
            MessageType4Entry messageType4Entry = ApplinkMsgEntry.parse(this.f5869p);
            if (messageType4Entry == null) {
                C4904y.m18639b("onDrawBubble(), hide bubble,  empty parse result", getClass().getSimpleName());
                m8428f();
                return;
            }
            if (!(messageType4Entry instanceof ApplinkMsgEntry)) {
                C4904y.m18639b("onDrawBubble(), hide bubble,  not received full-contents yet", getClass().getSimpleName());
                m8428f();
                return;
            }
            String displayMessage = messageType4Entry.getDisplayMessage();
            ApplinkMsgEntry applinkMsgEntry = (ApplinkMsgEntry) messageType4Entry;
            ApplinkMsgEntry.ContentEntry.AppInfoEntry.ParamEntry param = applinkMsgEntry.getParam("android", "phone");
            String appName = applinkMsgEntry.getAppName();
            if (param != null) {
                str2 = String.format(GlobalApplication.m10283b().getString(R.string.applink_open_using), appName);
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
                Float fValueOf = Float.valueOf(this.f5862i);
                CharSequence charSequenceM11709a = C2799k.m11709a(this.f5856c, str, (int) C5034k.m19088a(30.0f));
                if (m8404s()) {
                    if (TextUtils.isEmpty(str)) {
                        this.f5861h.f6455ay.setText(str);
                    } else {
                        this.f5861h.f6455ay.setText(charSequenceM11709a);
                    }
                    this.f5861h.f6456az.setOnClickListener(this);
                    this.f5861h.f6410aA.setText(str2);
                    this.f5861h.f6455ay.setTextSize(0, fValueOf.floatValue());
                    this.f5861h.f6410aA.setTextSize(0, fValueOf.floatValue());
                    this.f5861h.f6455ay.setTextColor(-16777216);
                    this.f5861h.f6454ax.setVisibility(0);
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f5861h.f6415aF.setText(str);
                } else {
                    this.f5861h.f6415aF.setText(charSequenceM11709a);
                }
                this.f5861h.f6416aG.setOnClickListener(this);
                this.f5861h.f6417aH.setText(str2);
                this.f5861h.f6415aF.setTextSize(0, fValueOf.floatValue());
                this.f5861h.f6417aH.setTextSize(0, fValueOf.floatValue());
                this.f5861h.f6472q.setTextColor(-16777216);
                this.f5861h.f6414aE.setVisibility(0);
                return;
            }
            Float fValueOf2 = Float.valueOf(this.f5862i);
            CharSequence charSequenceM11709a2 = C2799k.m11709a(this.f5856c, str, (int) C5034k.m19088a(30.0f));
            if (m8404s()) {
                if (TextUtils.isEmpty(str)) {
                    this.f5861h.f6455ay.setText(str);
                } else {
                    this.f5861h.f6455ay.setText(charSequenceM11709a2);
                }
                this.f5861h.f6456az.setVisibility(8);
                this.f5861h.f6455ay.setTextSize(0, fValueOf2.floatValue());
                this.f5861h.f6455ay.setTextColor(-16777216);
                this.f5861h.f6454ax.setVisibility(0);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                this.f5861h.f6415aF.setText(str);
            } else {
                this.f5861h.f6415aF.setText(charSequenceM11709a2);
            }
            this.f5861h.f6416aG.setVisibility(8);
            this.f5861h.f6415aF.setTextSize(0, fValueOf2.floatValue());
            this.f5861h.f6415aF.setTextColor(-16777216);
            this.f5861h.f6414aE.setVisibility(0);
        } catch (JSONException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            C4904y.m18639b("onDrawBubble(), exceptions!!!", getClass().getSimpleName());
            m8428f();
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6454ax.setVisibility(8);
            this.f5861h.f6456az.setVisibility(0);
            this.f5861h.f6456az.setOnClickListener(null);
        } else {
            this.f5861h.f6414aE.setVisibility(8);
            this.f5861h.f6416aG.setVisibility(0);
            this.f5861h.f6416aG.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return "";
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if ((view.equals(this.f5861h.f6456az) || view.equals(this.f5861h.f6416aG)) && this.f5858e.moveToPosition(this.f5859f)) {
                this.f5864k.mo8252d(m8404s(), this.f5858e);
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g */
    protected void mo8371g() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM19096b = C5034k.m19096b() - this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_default_subtraction_width);
        if (m8404s()) {
            textView = this.f5861h.f6455ay;
            textView2 = this.f5861h.f6410aA;
            textView3 = this.f5861h.f6435ae;
            textView4 = this.f5861h.f6462g;
        } else {
            textView = this.f5861h.f6415aF;
            textView2 = this.f5861h.f6417aH;
            textView3 = this.f5861h.f6388F;
        }
        float fA = m8398a(fM19096b - m8399a(textView3, textView4));
        textView.setMaxWidth((int) fA);
        textView2.setMaxWidth((int) (fA - C5034k.m19088a(45.0f)));
    }
}
