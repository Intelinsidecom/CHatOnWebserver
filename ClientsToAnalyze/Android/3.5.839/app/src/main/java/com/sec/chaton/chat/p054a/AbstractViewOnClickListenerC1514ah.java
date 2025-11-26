package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.translate.C1856i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p057e.EnumC2216ad;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.util.C5034k;

/* compiled from: MessageBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ah */
/* loaded from: classes.dex */
public abstract class AbstractViewOnClickListenerC1514ah extends AbstractC1506a implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, InterfaceC1542o, InterfaceC1549v {

    /* renamed from: L */
    private boolean f5901L;

    /* renamed from: M */
    private Boolean f5902M;

    /* renamed from: O */
    private ColorStateList f5904O;

    /* renamed from: P */
    private boolean f5905P = false;

    /* renamed from: N */
    private int f5903N = (int) C5034k.m19088a(30.0f);

    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.dialog_header_text);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() throws Resources.NotFoundException {
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f5875v)) {
            this.f5901L = true;
        } else {
            this.f5901L = false;
        }
        if (m8404s()) {
            this.f5861h.f6464i.setVisibility(0);
            this.f5861h.f6464i.setOnClickListener(this);
        } else {
            this.f5861h.f6465j.setVisibility(0);
            this.f5861h.f6465j.setOnClickListener(this);
        }
        m8405t();
        m8406u();
        mo8372g_();
        mo8389i_();
        mo8371g();
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        this.f5902M = null;
        if (m8404s()) {
            this.f5861h.f6464i.setVisibility(8);
            this.f5861h.f6464i.setOnClickListener(null);
            this.f5861h.f6397O.setOnClickListener(null);
            this.f5861h.f6441ak.setVisibility(8);
            this.f5861h.f6441ak.setOnClickListener(null);
            this.f5861h.f6445ao.setVisibility(8);
            this.f5861h.f6445ao.setOnClickListener(null);
            return;
        }
        this.f5861h.f6465j.setVisibility(8);
        this.f5861h.f6465j.setOnClickListener(null);
        this.f5861h.f6467l.setOnClickListener(null);
        this.f5861h.f6441ak.setOnClickListener(null);
        this.f5861h.f6472q.setOnClickListener(null);
        this.f5861h.f6472q.setTextColor(this.f5904O);
        this.f5861h.f6444an.setVisibility(8);
        this.f5861h.f6444an.setOnClickListener(null);
    }

    public void onClick(View view) {
        if (view.equals(this.f5861h.f6464i) || view.equals(this.f5861h.f6465j)) {
            this.f5864k.mo8272q();
            return;
        }
        if (view.equals(this.f5861h.f6467l)) {
            if (this.f5865l != EnumC2300t.TOPIC) {
                this.f5864k.mo8225a(view, (ProfileImageView) this.f5861h.f6467l, this.f5842C, this.f5843D);
                return;
            }
            return;
        }
        if (view.equals(this.f5861h.f6468m)) {
            this.f5864k.mo8263h();
            return;
        }
        if (view.equals(this.f5861h.f6441ak)) {
            this.f5864k.mo8224a(view, this.f5868o, false);
            return;
        }
        if (view.equals(this.f5861h.f6445ao) || view.equals(this.f5861h.f6444an)) {
            if (TextUtils.isEmpty(m8407v())) {
                this.f5864k.mo8247c(mo8370e());
            } else {
                if (!TextUtils.isEmpty(mo8370e())) {
                    this.f5864k.mo8247c(mo8370e() + m8407v());
                    return;
                }
                if (C4904y.f17873c) {
                    C4904y.m18641c("onShare() - getTextContent() is null", "MessageBubbleDrawer");
                }
                this.f5864k.mo8247c("" + m8407v());
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        boolean z = this.f5905P;
        if (z) {
            this.f5905P = false;
            return z;
        }
        return z;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f5905P = true;
        return false;
    }

    /* renamed from: s */
    protected boolean m8404s() {
        return this.f5901L;
    }

    /* renamed from: t */
    protected void m8405t() {
        ProfileImageView profileImageView;
        if (m8404s()) {
            profileImageView = (ProfileImageView) this.f5861h.f6468m;
            this.f5861h.f6453aw.setVisibility(0);
            this.f5861h.f6468m.setContentDescription(GlobalApplication.m10283b().getString(R.string.setting_interaction_me));
            C2496n.m10763a(profileImageView, EnumC2498p.ROUND);
            profileImageView.setBackgroundResource(R.drawable.circle_background);
        } else {
            profileImageView = (ProfileImageView) this.f5861h.f6467l;
            this.f5861h.f6452av.setVisibility(0);
            this.f5861h.f6466k.setVisibility(0);
            C2496n.m10765a(profileImageView, this.f5842C, EnumC2498p.ROUND);
            profileImageView.setBackgroundResource(R.drawable.circle_background);
            if (TextUtils.isEmpty(this.f5843D)) {
                this.f5843D = GlobalApplication.m10283b().getString(R.string.unknown);
            }
            this.f5861h.f6466k.setText(this.f5843D);
            this.f5861h.f6467l.setContentDescription(this.f5843D);
        }
        profileImageView.setOnClickListener(this);
    }

    /* renamed from: u */
    protected void m8406u() {
        TextView textView;
        if (m8404s()) {
            textView = this.f5861h.f6435ae;
        } else {
            textView = this.f5861h.f6388F;
        }
        if (this.f5878y == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(DateFormat.getTimeFormat(this.f5856c).format(this.f5855b));
        }
    }

    /* renamed from: g_ */
    protected void mo8372g_() {
        if (m8404s()) {
            if (this.f5840A == 0) {
                this.f5861h.f6462g.setVisibility(8);
                this.f5861h.f6441ak.setVisibility(8);
                this.f5861h.f6438ah.setVisibility(8);
                this.f5861h.f6440aj.setVisibility(8);
                if (C2717y.m11395a(this.f5845F)) {
                    this.f5861h.f6439ai.setVisibility(0);
                } else {
                    this.f5861h.f6439ai.setVisibility(8);
                }
                this.f5861h.f6394L.setVisibility(8);
                this.f5861h.f6435ae.setVisibility(8);
            } else if (this.f5840A == 6) {
                this.f5861h.f6462g.setVisibility(8);
                this.f5861h.f6441ak.setVisibility(8);
                this.f5861h.f6438ah.setVisibility(8);
                this.f5861h.f6439ai.setVisibility(8);
                this.f5861h.f6440aj.setVisibility(0);
                this.f5861h.f6394L.setVisibility(8);
                this.f5861h.f6435ae.setVisibility(8);
            } else if (this.f5840A == 1 || this.f5840A == 4) {
                this.f5861h.f6462g.setVisibility(0);
                if (this.f5841B > 0) {
                    if (this.f5865l == EnumC2300t.ONETOONE || this.f5845F == EnumC2301u.LIVE) {
                        this.f5861h.f6462g.setText(R.string.read);
                    } else {
                        this.f5861h.f6462g.setText(this.f5856c.getString(R.string.read_by_count, Integer.valueOf(this.f5841B)));
                    }
                } else {
                    this.f5861h.f6462g.setText("(" + GlobalApplication.m18732r().getString(R.string.unread) + ")");
                }
                this.f5861h.f6438ah.setVisibility(8);
                this.f5861h.f6439ai.setVisibility(8);
                this.f5861h.f6440aj.setVisibility(8);
                this.f5861h.f6441ak.setVisibility(8);
                this.f5861h.f6394L.setVisibility(8);
                this.f5861h.f6435ae.setVisibility(0);
                if (this.f5865l == EnumC2300t.TOPIC) {
                    this.f5861h.f6462g.setVisibility(8);
                }
            } else if (this.f5840A == -1) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("Message type is fail.", AbstractViewOnClickListenerC1514ah.class.getSimpleName());
                }
                this.f5861h.f6462g.setVisibility(8);
                this.f5861h.f6441ak.setVisibility(0);
                if (this.f5860g) {
                    this.f5861h.f6441ak.setOnClickListener(this);
                }
                this.f5861h.f6438ah.setVisibility(8);
                this.f5861h.f6439ai.setVisibility(8);
                this.f5861h.f6440aj.setVisibility(8);
                this.f5861h.f6394L.setVisibility(8);
                this.f5861h.f6435ae.setVisibility(8);
            } else if (C4904y.f17873c) {
                C4904y.m18641c("Exceptional Message type : " + this.f5840A, AbstractViewOnClickListenerC1514ah.class.getSimpleName());
            }
            if (this.f5848I != EnumC2216ad.WITHDRAWING && this.f5848I == EnumC2216ad.WITHDRAW_SUCCESS) {
                this.f5861h.f6462g.setText("(" + GlobalApplication.m18732r().getString(R.string.message_cancelled) + ")");
                return;
            }
            return;
        }
        this.f5861h.f6391I.setVisibility(4);
        this.f5861h.f6390H.setVisibility(4);
        this.f5861h.f6392J.setVisibility(4);
        this.f5861h.f6443am.setVisibility(8);
    }

    /* renamed from: i_ */
    protected void mo8389i_() throws Resources.NotFoundException {
        TextView textView;
        View view;
        TextView textView2;
        String strM8633a;
        ImageView imageView;
        String strSubstring;
        float dimension;
        String strMo8370e = mo8370e();
        float f = this.f5862i;
        if (m8404s()) {
            TextView textView3 = this.f5861h.f6397O;
            View view2 = this.f5861h.f6398P;
            TextView textView4 = this.f5861h.f6399Q;
            ImageView imageView2 = this.f5861h.f6400R;
            this.f5861h.f6397O.setOnClickListener(this);
            this.f5861h.f6397O.setOnTouchListener(this);
            this.f5861h.f6397O.setOnLongClickListener(this);
            if (!TextUtils.isEmpty(strMo8370e) && m8397a(strMo8370e)) {
                this.f5861h.f6445ao.setOnClickListener(this);
                this.f5861h.f6445ao.setVisibility(0);
                if (C1736gi.m8652d(strMo8370e)) {
                    textView = textView4;
                    view = view2;
                    textView2 = textView3;
                    strM8633a = C1736gi.m8633a(strMo8370e.substring(0, 100), 100, false);
                    imageView = imageView2;
                } else {
                    textView = textView4;
                    view = view2;
                    textView2 = textView3;
                    strM8633a = C1736gi.m8633a(strMo8370e.substring(0, 1000), 1000, false);
                    imageView = imageView2;
                }
            } else {
                this.f5861h.f6445ao.setOnClickListener(null);
                this.f5861h.f6445ao.setVisibility(8);
                textView = textView4;
                view = view2;
                textView2 = textView3;
                strM8633a = strMo8370e;
                imageView = imageView2;
            }
        } else {
            TextView textView5 = this.f5861h.f6472q;
            View view3 = this.f5861h.f6473r;
            TextView textView6 = this.f5861h.f6474s;
            ImageView imageView3 = this.f5861h.f6475t;
            this.f5861h.f6472q.setOnClickListener(this);
            this.f5861h.f6472q.setOnTouchListener(this);
            this.f5861h.f6472q.setOnLongClickListener(this);
            if (!TextUtils.isEmpty(strMo8370e) && m8397a(strMo8370e)) {
                this.f5861h.f6444an.setOnClickListener(this);
                this.f5861h.f6444an.setVisibility(0);
                if (C1736gi.m8652d(strMo8370e)) {
                    strMo8370e = C1736gi.m8633a(strMo8370e.substring(0, 100), 100, false);
                } else {
                    strMo8370e = C1736gi.m8633a(strMo8370e.substring(0, 1000), 1000, false);
                }
            } else {
                this.f5861h.f6444an.setOnClickListener(null);
                this.f5861h.f6444an.setVisibility(8);
            }
            if (this.f5848I == EnumC2216ad.WITHDRAW_SUCCESS) {
                this.f5870q = "";
            }
            textView = textView6;
            view = view3;
            textView2 = textView5;
            strM8633a = strMo8370e;
            imageView = imageView3;
        }
        this.f5904O = textView2.getTextColors();
        if (m8404s()) {
            if (!TextUtils.isEmpty(this.f5870q)) {
                textView2.setTextColor(this.f5856c.getResources().getColor(R.color.translate_source_text));
            } else {
                textView2.setTextColor(this.f5856c.getResources().getColor(R.color.disclaimer_text_color));
            }
        } else {
            textView2.setTextColor(this.f5856c.getResources().getColor(R.color.disclaimer_text_color));
            if (!TextUtils.isEmpty(this.f5869p) && !TextUtils.isEmpty(this.f5870q)) {
                if (this.f5869p.equals(this.f5870q)) {
                    this.f5870q = null;
                } else {
                    textView2.setTextColor(this.f5856c.getResources().getColor(R.color.translate_source_text));
                }
            }
        }
        view.setVisibility(8);
        if (TextUtils.isEmpty(strM8633a)) {
            textView2.setText(strM8633a);
            textView2.setVisibility(8);
            textView.setText(strM8633a);
            textView.setVisibility(8);
            if (imageView != null) {
                imageView.setVisibility(8);
                strSubstring = strM8633a;
            } else {
                strSubstring = strM8633a;
            }
        } else {
            if (strM8633a == null || !C1736gi.m8652d(strM8633a)) {
                strSubstring = strM8633a;
                dimension = f;
            } else {
                strSubstring = new StringBuilder(strM8633a).substring(1);
                dimension = this.f5856c.getResources().getDimension(R.dimen.font_size_big_text);
            }
            textView2.setTextSize(0, dimension);
            textView.setTextSize(0, dimension);
            if (!TextUtils.isEmpty(this.f5870q)) {
                view.setVisibility(0);
                textView2.setText(C2799k.m11709a(this.f5856c, strSubstring, this.f5903N));
                textView2.setVisibility(0);
                if (C1736gi.m8652d(this.f5870q)) {
                    this.f5870q = new StringBuilder(this.f5870q).substring(1);
                }
                textView.setText(C2799k.m11709a(this.f5856c, this.f5870q, this.f5903N));
                if (strSubstring != null && m8397a(strSubstring)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                }
                if (imageView != null && C1856i.m9049a() && C1856i.m9051a(this.f5872s) && !C2799k.m11711a(this.f5870q)) {
                    imageView.setVisibility(0);
                    imageView.setOnClickListener(new ViewOnClickListenerC1515ai(this));
                } else if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else {
                view.setVisibility(8);
                textView.setVisibility(8);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                textView2.setText(C2799k.m11709a(this.f5856c, strSubstring, this.f5903N));
                textView2.setVisibility(0);
            }
        }
        if (!m8404s() && this.f5848I == EnumC2216ad.WITHDRAW_SUCCESS) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strSubstring + " [Recalled]");
            Drawable drawable = this.f5856c.getResources().getDrawable(R.drawable.chats_img_recalled_message);
            drawable.setBounds(0, 0, this.f5903N, this.f5903N);
            ImageSpan imageSpan = new ImageSpan(drawable, 0);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5856c.getResources().getColor(R.color.recall_text_color)), 0, spannableStringBuilder.length() - "[Recalled]".length(), 33);
            spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length() - "[Recalled]".length(), spannableStringBuilder.length(), 33);
            textView2.setText(spannableStringBuilder);
        }
        this.f5861h.f6432ab.setVisibility(8);
        this.f5861h.f6433ac.setVisibility(8);
        this.f5861h.f6384B.setVisibility(8);
        this.f5861h.f6385C.setVisibility(8);
    }

    /* renamed from: e */
    protected String mo8370e() {
        return this.f5869p;
    }

    /* renamed from: g */
    protected void mo8371g() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM19096b = C5034k.m19096b() - this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_default_subtraction_width);
        if (m8404s()) {
            textView = this.f5861h.f6397O;
            textView2 = this.f5861h.f6399Q;
            textView3 = this.f5861h.f6435ae;
            textView4 = this.f5861h.f6462g;
        } else {
            textView = this.f5861h.f6472q;
            textView2 = this.f5861h.f6474s;
            textView3 = this.f5861h.f6388F;
        }
        float fM8398a = m8398a(fM19096b - m8399a(textView3, textView4));
        textView.setMaxWidth((int) fM8398a);
        if (this.f5861h.f6475t != null && this.f5861h.f6475t.getVisibility() == 0) {
            textView2.setMaxWidth((int) (fM8398a - C5034k.m19088a(41.0f)));
        } else if (this.f5861h.f6400R != null && this.f5861h.f6400R.getVisibility() == 0) {
            textView2.setMaxWidth((int) (fM8398a - C5034k.m19088a(41.0f)));
        } else {
            textView2.setMaxWidth((int) fM8398a);
        }
    }

    /* renamed from: a */
    protected float m8398a(float f) {
        return f;
    }

    /* renamed from: a */
    private boolean m8397a(String str) {
        int i = 1000;
        if (this.f5902M == null) {
            if (!TextUtils.isEmpty(str)) {
                if (C1736gi.m8652d(str)) {
                    i = 100;
                }
                if (str.length() > i) {
                    this.f5902M = true;
                } else {
                    this.f5902M = false;
                }
            } else {
                this.f5902M = false;
            }
        }
        return this.f5902M.booleanValue();
    }

    /* renamed from: b */
    public boolean mo8369b() {
        return true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1542o
    /* renamed from: h_ */
    public void mo8400h_() {
    }

    /* renamed from: n */
    public String mo8401n() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON";
    }

    /* renamed from: v */
    protected String m8407v() {
        return TextUtils.isEmpty(this.f5870q) ? "" : "\n\n" + this.f5870q;
    }

    /* renamed from: a */
    protected float m8399a(TextView textView, TextView textView2) {
        float fMeasureText = textView.getPaint().measureText(textView.getText().toString());
        float fMeasureText2 = 0.0f;
        if (textView2 != null) {
            fMeasureText2 = textView2.getPaint().measureText(textView2.getText().toString());
        }
        return fMeasureText > fMeasureText2 ? fMeasureText : fMeasureText2;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1549v
    /* renamed from: p */
    public boolean mo8402p() {
        if (this.f5865l != EnumC2300t.ONETOONE) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("isWithDrawable()-false : mChatType(" + this.f5865l + ")", "MessageBubbleDrawer");
            return false;
        }
        if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f5875v)) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("isWithDrawable()-false : mSender(" + this.f5875v + ")", "MessageBubbleDrawer");
            return false;
        }
        if (this.f5840A != 1 && this.f5840A != 4) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("isWithDrawable()-false : mMsgType(" + this.f5840A + ")", "MessageBubbleDrawer");
            return false;
        }
        if (this.f5848I != EnumC2216ad.WITHDRAWING && this.f5848I != EnumC2216ad.WITHDRAW_SUCCESS && this.f5848I != EnumC2216ad.WITHDRAW_FAIL) {
            return true;
        }
        if (!C4904y.f17873c) {
            return false;
        }
        C4904y.m18641c("isWithDrawable()-false : mMsgStatusType(" + this.f5848I + ")", "MessageBubbleDrawer");
        return false;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1549v
    /* renamed from: q */
    public void mo8403q() {
    }
}
