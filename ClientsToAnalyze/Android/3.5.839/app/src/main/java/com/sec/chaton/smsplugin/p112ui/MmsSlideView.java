package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p110g.AbstractC3863i;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3861g;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3872r;
import com.sec.chaton.smsplugin.p110g.C3873s;
import com.sec.chaton.smsplugin.p111h.C3878ac;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import java.io.IOException;
import java.util.regex.Pattern;

@TargetApi(14)
/* loaded from: classes.dex */
public class MmsSlideView extends LinearLayout implements View.OnClickListener, Runnable {

    /* renamed from: v */
    private static Bitmap f14893v = null;

    /* renamed from: a */
    private ImageView f14894a;

    /* renamed from: b */
    private TextView f14895b;

    /* renamed from: c */
    private TextView f14896c;

    /* renamed from: d */
    private ImageView f14897d;

    /* renamed from: e */
    private LinearLayout f14898e;

    /* renamed from: f */
    private FrameLayout f14899f;

    /* renamed from: g */
    private ImageView f14900g;

    /* renamed from: h */
    private View f14901h;

    /* renamed from: i */
    private ImageView f14902i;

    /* renamed from: j */
    private TextView f14903j;

    /* renamed from: k */
    private TextView f14904k;

    /* renamed from: l */
    private TextView f14905l;

    /* renamed from: m */
    private TextView f14906m;

    /* renamed from: n */
    private boolean f14907n;

    /* renamed from: o */
    private boolean f14908o;

    /* renamed from: p */
    private C4129bk f14909p;

    /* renamed from: q */
    private C3869o f14910q;

    /* renamed from: r */
    private Pattern f14911r;

    /* renamed from: s */
    private final Handler f14912s;

    /* renamed from: t */
    private final Point f14913t;

    /* renamed from: u */
    private Bitmap f14914u;

    /* renamed from: w */
    private MessageListItem f14915w;

    /* renamed from: x */
    private boolean f14916x;

    /* renamed from: y */
    private C3861g f14917y;

    /* renamed from: z */
    private final View.OnClickListener f14918z;

    /* renamed from: a */
    private static Bitmap m15855a(Resources resources) throws IOException {
        if (f14893v == null) {
            try {
                f14893v = BitmapFactory.decodeResource(resources, R.drawable.bubble_image_error_icon);
            } catch (OutOfMemoryError e) {
                C4149cd.m16420b();
                C3890m.m14995a("Mms/MmsSlideView", "OutOfMemoryError caught @ BitmapFactory.decodeResource and throw", e);
                throw e;
            }
        }
        return f14893v;
    }

    public MmsSlideView(Context context) {
        super(context);
        this.f14895b = null;
        this.f14896c = null;
        this.f14897d = null;
        this.f14898e = null;
        this.f14899f = null;
        this.f14906m = null;
        this.f14907n = false;
        this.f14908o = false;
        this.f14910q = null;
        this.f14912s = new Handler();
        this.f14913t = new Point();
        this.f14915w = null;
        this.f14916x = false;
        this.f14918z = new ViewOnClickListenerC4169cx(this);
    }

    public MmsSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14895b = null;
        this.f14896c = null;
        this.f14897d = null;
        this.f14898e = null;
        this.f14899f = null;
        this.f14906m = null;
        this.f14907n = false;
        this.f14908o = false;
        this.f14910q = null;
        this.f14912s = new Handler();
        this.f14913t = new Point();
        this.f14915w = null;
        this.f14916x = false;
        this.f14918z = new ViewOnClickListenerC4169cx(this);
    }

    public MmsSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14895b = null;
        this.f14896c = null;
        this.f14897d = null;
        this.f14898e = null;
        this.f14899f = null;
        this.f14906m = null;
        this.f14907n = false;
        this.f14908o = false;
        this.f14910q = null;
        this.f14912s = new Handler();
        this.f14913t = new Point();
        this.f14915w = null;
        this.f14916x = false;
        this.f14918z = new ViewOnClickListenerC4169cx(this);
    }

    public void setIsFailedMessage(boolean z) {
        this.f14908o = z;
    }

    public void setIsReservedMessage(boolean z) {
        this.f14916x = z;
    }

    public void setHighlight(Pattern pattern) {
        this.f14911r = pattern;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f14899f = (FrameLayout) findViewById(R.id.slide_frame);
        this.f14894a = (ImageView) findViewById(R.id.image_view);
        this.f14895b = (TextView) findViewById(R.id.location_title_view);
        this.f14896c = (TextView) findViewById(R.id.location_address_view);
        this.f14897d = (ImageView) findViewById(R.id.location_image_view);
        this.f14898e = (LinearLayout) findViewById(R.id.location_view);
        this.f14900g = (ImageView) findViewById(R.id.video_play_button);
        this.f14901h = findViewById(R.id.mms_audio_info);
        this.f14902i = (ImageView) findViewById(R.id.mms_audio_play);
        this.f14903j = (TextView) findViewById(R.id.mms_audio_text);
        this.f14904k = (TextView) findViewById(R.id.text_view_top);
        this.f14905l = (TextView) findViewById(R.id.text_view_bottom);
        this.f14906m = this.f14905l;
        C3892o.m15014a((View) this.f14904k, false);
        C3892o.m15014a((View) this.f14905l, false);
        this.f14894a.setOnClickListener(this);
        this.f14902i.setOnClickListener(this);
        if (C3847e.m14681am()) {
            this.f14903j.setOnClickListener(this.f14918z);
        }
        this.f14900g.setOnClickListener(this);
        this.f14898e.setOnClickListener(this);
        this.f14895b.setOnClickListener(this);
        this.f14897d.setOnClickListener(this);
        this.f14896c.setOnClickListener(this);
    }

    /* renamed from: a */
    public void m15863a() {
        C3892o.m15014a((View) this.f14899f, false);
        C3892o.m15014a((View) this.f14894a, false);
        C3892o.m15014a(this.f14901h, false);
        C3892o.m15014a((View) this.f14900g, false);
        C3892o.m15014a((View) this.f14898e, false);
    }

    /* renamed from: a */
    public boolean m15865a(int i, C3869o c3869o, MessageListItem messageListItem) {
        return m15866a(i, c3869o, messageListItem, false);
    }

    /* renamed from: a */
    public boolean m15866a(int i, C3869o c3869o, MessageListItem messageListItem, boolean z) throws IOException {
        boolean z2;
        boolean z3 = true;
        m15863a();
        m15860a(i == 1);
        C3890m.m14994a("NGM", "present layoutType: " + i);
        this.f14910q = c3869o;
        this.f14915w = messageListItem;
        if (c3869o == null) {
            C3890m.m14996b("Mms/MmsSlideView", "slide may not be null.");
            return false;
        }
        if (c3869o.m14863e()) {
            m15859a(c3869o.m14875o(), true);
            z2 = true;
        } else if (c3869o.m14867g()) {
            setVideo(c3869o.m14877q());
            z2 = true;
        } else {
            z2 = false;
        }
        if (c3869o.m14865f()) {
            setAudio(c3869o.m14876p());
            z2 = true;
        }
        if (c3869o.m14861d() && !TextUtils.isEmpty(c3869o.m14874n().m14940a())) {
            if (C3847e.m14682an()) {
                setText(c3869o.m14874n(), z);
            } else {
                setText(c3869o.m14874n());
            }
            if (!z2) {
                setPadding(0, 0, 0, 0);
            }
        } else {
            if (!z2) {
                setPadding(0, 0, 0, 0);
            }
            setTextVisibility(false);
            z3 = z2;
        }
        m15861d();
        return z3;
    }

    /* renamed from: d */
    private void m15861d() {
        this.f14917y = this.f14910q.m14875o();
    }

    /* renamed from: a */
    private void m15860a(boolean z) {
        if (this.f14907n != z) {
            C3892o.m15014a((View) this.f14906m, false);
            this.f14906m = z ? this.f14904k : this.f14905l;
            this.f14907n = z;
            m15864a(this.f14909p);
        }
    }

    /* renamed from: a */
    private void m15859a(C3861g c3861g, boolean z) {
        boolean zEquals = c3861g.equals(this.f14917y);
        this.f14917y = c3861g;
        C3890m.m14996b("Mms/MmsSlideView", "setImage");
        try {
            C3892o.m15014a((View) this.f14894a, true);
            C3892o.m15014a((View) this.f14899f, true);
            if (zEquals) {
                C3890m.m14996b("Mms/MmsSlideView", "same image");
                return;
            }
            if (c3861g.m14823x()) {
                m15857a(this.f14894a);
            } else {
                m15858a(this.f14894a, c3861g.m14772a(), c3861g.m14774b());
            }
            if (z) {
                C4171cz c4171czM16453a = C4171cz.m16453a();
                c4171czM16453a.m16459b(this);
                if (c3861g.m14781j()) {
                    m15862e();
                    m15867b();
                } else {
                    c4171czM16453a.m16457a(this);
                }
            } else {
                m15862e();
                m15867b();
            }
            this.f14894a.setContentDescription(getResources().getString(R.string.media_photo));
        } catch (OutOfMemoryError e) {
            C3890m.m14999e("Mms/MmsSlideView", "OutOfMemoryError" + e);
            this.f14894a.setTag(null);
            this.f14894a.setOnClickListener(null);
        }
    }

    /* renamed from: a */
    private void m15858a(ImageView imageView, int i, int i2) {
        C3861g.m14769a(this.f14913t, i, i2);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = this.f14913t.x + this.f14894a.getPaddingLeft() + this.f14894a.getPaddingRight();
        layoutParams.height = this.f14913t.y + this.f14894a.getPaddingTop() + this.f14894a.getPaddingBottom();
    }

    /* renamed from: b */
    protected void m15867b() {
        if (!this.f14910q.m14863e()) {
            this.f14914u = null;
            if (!this.f14910q.m14867g()) {
                this.f14894a.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f14914u == null) {
            this.f14894a.setTag(null);
            this.f14894a.setOnClickListener(null);
            this.f14894a.setImageBitmap(m15855a(getResources()));
        } else {
            this.f14894a.setTag(this.f14917y);
            this.f14894a.setOnClickListener(this);
            this.f14894a.setImageBitmap(this.f14914u);
        }
        this.f14894a.setVisibility(0);
        this.f14899f.setVisibility(0);
    }

    public void setVideo(C3873s c3873s) throws IOException {
        Bitmap bitmapM16390a;
        Uri uriN = c3873s.m14813n();
        try {
            if (c3873s.m14823x()) {
                C3890m.m14996b("Mms/MmsSlideView", "set DRM Video");
                bitmapM16390a = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.bubble_image_drm_icon);
                m15857a(this.f14894a);
            } else {
                C3890m.m14996b("Mms/MmsSlideView", "set Video");
                bitmapM16390a = C4149cd.m16390a(this.mContext, uriN);
            }
            if (bitmapM16390a == null) {
                C3890m.m14997c("Mms/MmsSlideView", "video thumbnail not created");
                bitmapM16390a = BitmapFactory.decodeResource(getResources(), R.drawable.bubble_video_error_icon);
                if (uriN == null) {
                    this.f14894a.setTag(null);
                    this.f14900g.setTag(null);
                    this.f14894a.setOnClickListener(null);
                } else {
                    this.f14894a.setTag(c3873s);
                    this.f14900g.setTag(c3873s);
                    this.f14894a.setOnClickListener(this);
                }
            } else {
                this.f14894a.setTag(c3873s);
                this.f14900g.setTag(c3873s);
                this.f14894a.setOnClickListener(this);
            }
            if (!c3873s.m14823x()) {
                m15858a(this.f14894a, bitmapM16390a.getWidth(), bitmapM16390a.getHeight());
            }
            this.f14894a.setImageBitmap(bitmapM16390a);
            this.f14894a.setContentDescription(getResources().getString(R.string.media_video));
            this.f14900g.setContentDescription(getResources().getString(R.string.media_video));
            this.f14894a.setVisibility(0);
            this.f14899f.setVisibility(0);
            this.f14900g.setVisibility(0);
        } catch (OutOfMemoryError e) {
            C3890m.m14999e("Mms/MmsSlideView", "OutOfMemoryError" + e);
            this.f14894a.setTag(null);
            this.f14894a.setOnClickListener(null);
        }
    }

    /* renamed from: a */
    private void m15857a(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
    }

    public void setAudio(C3856b c3856b) {
        if (c3856b.m14823x()) {
            C3890m.m14996b("Mms/MmsSlideView", "set DRM Audio");
            this.f14902i.setBackgroundResource(R.drawable.bubble_audio_drm_icon);
            this.f14902i.setContentDescription(getResources().getString(R.string.media_voice));
            this.f14903j.setText(c3856b.m14816q());
            this.f14901h.setVisibility(0);
            this.f14902i.setTag(c3856b);
            return;
        }
        C3890m.m14996b("Mms/MmsSlideView", "set Audio");
        this.f14902i.setBackgroundResource(R.drawable.selector_msg_play_button);
        this.f14902i.setContentDescription(getResources().getString(R.string.media_voice));
        this.f14903j.setText(c3856b.m14816q());
        this.f14901h.setVisibility(0);
        this.f14902i.setTag(c3856b);
    }

    public void setText(C3872r c3872r) {
        setText(c3872r, false);
    }

    public void setText(C3872r c3872r, boolean z) {
        if (c3872r == null) {
            setTextVisibility(false);
            return;
        }
        C3890m.m14996b("Mms/MmsSlideView", "set text");
        String strM14940a = c3872r.m14940a();
        if (C3847e.m14682an() && !TextUtils.isEmpty(strM14940a) && z) {
            strM14940a = C3878ac.m14956a(strM14940a, MessageListItem.m15818n()) + "...";
        }
        if (TextUtils.isEmpty(strM14940a)) {
            setTextVisibility(false);
            return;
        }
        CharSequence charSequenceM15829a = this.f14915w.m15829a(this.f14906m.getContext(), strM14940a, this.f14911r, this.f14915w.m15834i().f15278m, this.f14906m);
        this.f14906m.setText(charSequenceM15829a);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14906m.getLayoutParams();
        if (C4149cd.m16417a(charSequenceM15829a)) {
            layoutParams.gravity = 5;
        } else {
            layoutParams.gravity = 3;
        }
        this.f14906m.setLayoutParams(layoutParams);
        MessageListItem.m15794a(this.f14906m, this.f14908o || this.f14916x);
        setTextVisibility(true);
    }

    public void setTextVisibility(boolean z) {
        if (z) {
            C3892o.m15014a(this.f14906m, z);
        } else {
            C3892o.m15014a(this.f14904k, z);
            C3892o.m15014a(this.f14905l, z);
        }
    }

    /* renamed from: c */
    public TextView m15868c() {
        return this.f14906m;
    }

    /* renamed from: a */
    public void m15864a(C4129bk c4129bk) {
        this.f14909p = c4129bk;
        this.f14906m.setTextSize(this.f14909p.f15371b, this.f14909p.f15372c);
        this.f14906m.setOnTouchListener(this.f14909p.f15370a);
        C3892o.m15015a(this.f14906m, this.f14909p.f15373d);
    }

    public void setVisibility(boolean z) {
        C3892o.m15014a(this, z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4149cd.m16408a(getContext(), (AbstractC3863i) view.getTag());
    }

    @Override // java.lang.Runnable
    public void run() {
        if (m15862e()) {
            this.f14912s.post(new RunnableC4170cy(this));
        }
    }

    /* renamed from: e */
    private boolean m15862e() {
        Bitmap bitmapM14776e;
        if (this.f14917y == null) {
            return false;
        }
        Uri uriN = this.f14917y.m14813n();
        if (this.f14917y.m14823x()) {
            bitmapM14776e = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.bubble_image_drm_icon);
        } else {
            bitmapM14776e = this.f14917y.m14776e();
        }
        if (this.f14917y != null && uriN.equals(this.f14917y.m14813n())) {
            this.f14914u = bitmapM14776e;
            return true;
        }
        return false;
    }
}
