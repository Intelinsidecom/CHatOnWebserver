package com.sec.chaton.smsplugin.p112ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineHeightSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.settings.EnumC3594ed;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p111h.C3878ac;
import com.sec.chaton.smsplugin.p111h.C3881d;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class MessageListItem extends LinearLayout implements InterfaceC4315ih {

    /* renamed from: C */
    private static Drawable f14794C;

    /* renamed from: A */
    private TextView f14800A;

    /* renamed from: B */
    private ImageView f14801B;

    /* renamed from: D */
    private LinearLayout f14802D;

    /* renamed from: E */
    private LinearLayout f14803E;

    /* renamed from: F */
    private C4130bl f14804F;

    /* renamed from: G */
    private Calendar f14805G;

    /* renamed from: H */
    private Date f14806H;

    /* renamed from: I */
    private ViewGroup f14807I;

    /* renamed from: J */
    private ViewGroup f14808J;

    /* renamed from: K */
    private TextView f14809K;

    /* renamed from: L */
    private String f14810L;

    /* renamed from: M */
    private String f14811M;

    /* renamed from: N */
    private final ForegroundColorSpan f14812N;

    /* renamed from: O */
    private final float f14813O;

    /* renamed from: R */
    private float f14814R;

    /* renamed from: S */
    private float f14815S;

    /* renamed from: T */
    private float f14816T;

    /* renamed from: U */
    private TextView f14817U;

    /* renamed from: V */
    private TextView f14818V;

    /* renamed from: W */
    private final View.OnClickListener f14819W;

    /* renamed from: Z */
    private final LineHeightSpan f14820Z;

    /* renamed from: a */
    public View f14821a;

    /* renamed from: aa */
    private final View.OnClickListener f14822aa;

    /* renamed from: ad */
    private final Handler f14823ad;

    /* renamed from: ae */
    private final View.OnTouchListener f14824ae;

    /* renamed from: b */
    protected VAttachmentListView f14825b;

    /* renamed from: c */
    protected View f14826c;

    /* renamed from: d */
    protected Calendar f14827d;

    /* renamed from: e */
    protected Date f14828e;

    /* renamed from: g */
    private final String f14829g;

    /* renamed from: h */
    private Drawable f14830h;

    /* renamed from: i */
    private final String f14831i;

    /* renamed from: j */
    private Drawable f14832j;

    /* renamed from: k */
    private View f14833k;

    /* renamed from: l */
    private FrameLayout f14834l;

    /* renamed from: m */
    private ImageView f14835m;

    /* renamed from: n */
    private ImageView f14836n;

    /* renamed from: o */
    private ImageView f14837o;

    /* renamed from: p */
    private ImageButton f14838p;

    /* renamed from: q */
    private TextView f14839q;

    /* renamed from: r */
    private ImageButton f14840r;

    /* renamed from: s */
    private Handler f14841s;

    /* renamed from: t */
    private C4108aq f14842t;

    /* renamed from: u */
    private final String f14843u;

    /* renamed from: v */
    private TextView f14844v;

    /* renamed from: w */
    private final Path f14845w;

    /* renamed from: x */
    private final Paint f14846x;

    /* renamed from: y */
    private ProfileImageView f14847y;

    /* renamed from: z */
    private CheckBox f14848z;

    /* renamed from: f */
    private static final StyleSpan f14799f = new StyleSpan(1);

    /* renamed from: P */
    private static int f14795P = -1;

    /* renamed from: Q */
    private static int f14796Q = -1;

    /* renamed from: ab */
    private static final int f14797ab = ViewConfiguration.getLongPressTimeout();

    /* renamed from: ac */
    private static final int f14798ac = ViewConfiguration.getTapTimeout();

    public MessageListItem(Context context) {
        super(context);
        this.f14845w = new Path();
        this.f14846x = new Paint();
        this.f14812N = new ForegroundColorSpan(-1);
        this.f14813O = m15825u();
        this.f14815S = 0.0f;
        this.f14816T = 0.0f;
        this.f14819W = new ViewOnClickListenerC4121bc(this);
        this.f14820Z = new C4124bf(this);
        this.f14822aa = new ViewOnClickListenerC4117az(this);
        this.f14823ad = new HandlerC4119ba(this);
        this.f14824ae = new ViewOnTouchListenerC4120bb(this);
        this.f14843u = GlobalApplication.m10279a().m10297l();
        if (f14794C == null) {
            f14794C = context.getResources().getDrawable(R.drawable.profile_photo_buddy_default);
        }
        this.f14829g = C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1");
        this.f14831i = C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1");
    }

    public MessageListItem(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f14845w = new Path();
        this.f14846x = new Paint();
        this.f14812N = new ForegroundColorSpan(-1);
        this.f14813O = m15825u();
        this.f14815S = 0.0f;
        this.f14816T = 0.0f;
        this.f14819W = new ViewOnClickListenerC4121bc(this);
        this.f14820Z = new C4124bf(this);
        this.f14822aa = new ViewOnClickListenerC4117az(this);
        this.f14823ad = new HandlerC4119ba(this);
        this.f14824ae = new ViewOnTouchListenerC4120bb(this);
        this.mContext.getResources().getColor(R.color.timestamp_color);
        this.f14843u = GlobalApplication.m10279a().m10297l();
        if (f14794C == null) {
            f14794C = context.getResources().getDrawable(R.drawable.profile_photo_buddy_default);
        }
        this.f14829g = C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1");
        this.f14831i = C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1");
        this.f14827d = Calendar.getInstance();
        this.f14805G = Calendar.getInstance();
        this.f14828e = new Date();
        this.f14806H = new Date();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f14839q = (TextView) findViewById(R.id.text_view);
        this.f14844v = (TextView) findViewById(R.id.date_view);
        this.f14836n = (ImageView) findViewById(R.id.locked_indicator);
        this.f14837o = (ImageView) findViewById(R.id.failed_indicator);
        this.f14847y = (ProfileImageView) findViewById(R.id.avatar);
        this.f14821a = findViewById(R.id.message_block);
        this.f14848z = (CheckBox) findViewById(R.id.checkbox);
        this.f14800A = (TextView) findViewById(R.id.broadcast_bubble_text);
        this.f14801B = (ImageView) findViewById(R.id.progressClock);
        this.f14803E = (LinearLayout) findViewById(R.id.mms_page_container);
        this.f14804F = new C4130bl(this.f14803E);
        this.f14826c = findViewById(R.id.vattachment_separator);
        this.f14825b = (VAttachmentListView) findViewById(R.id.vattachment_list);
        this.f14807I = (LinearLayout) findViewById(R.id.mms_layout_view_parent);
        this.f14808J = (RelativeLayout) this.f14807I.findViewById(R.id.dateseparator);
        this.f14809K = (TextView) this.f14807I.findViewById(R.id.textDate);
        this.f14817U = (TextView) findViewById(R.id.sms_mark);
        this.f14818V = (TextView) findViewById(R.id.textName);
    }

    /* renamed from: a */
    public void m15830a(Cursor cursor, C4108aq c4108aq) {
        this.f14806H.setTime(0L);
        if (cursor.getCount() > 1) {
            int position = cursor.getPosition();
            if (cursor.getPosition() != 0) {
                cursor.moveToPosition(cursor.getPosition() - 1);
            }
            this.f14806H.setTime(C1736gi.m8645b(cursor));
            cursor.moveToPosition(position);
            this.f14828e.setTime(C1736gi.m8645b(cursor));
            this.f14827d.setTime(this.f14828e);
        }
        this.f14805G.setTime(this.f14806H);
        if (cursor.getPosition() == 0 || this.f14827d.get(1) != this.f14805G.get(1) || this.f14827d.get(2) != this.f14805G.get(2) || this.f14827d.get(5) != this.f14805G.get(5)) {
            this.f14808J.setVisibility(0);
            this.f14809K.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(this.f14828e));
        } else {
            this.f14808J.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m15832a(C4108aq c4108aq, boolean z, boolean z2) {
        this.f14842t = c4108aq;
        setLongClickable(false);
        setClickable(false);
        m15828x();
        this.f14837o.setOnClickListener(this.f14822aa);
        this.f14825b.setItemClickable(true);
        this.f14839q.setOnTouchListener(this.f14824ae);
        this.f14804F.m16345a(this.f14824ae);
        C3892o.m15015a(this.f14839q, C3892o.m15007a());
        this.f14804F.m16342a(C3892o.m15007a());
        this.f14839q.setTextSize(0, m15825u());
        this.f14804F.m16343a(0, m15825u());
        if (c4108aq.m16312o()) {
            this.f14817U.setText(R.string.sms);
        } else if (c4108aq.m16311n()) {
            this.f14817U.setText(R.string.mms);
        }
        if (this.f14818V != null) {
            this.f14818V.setText(c4108aq.f15276k);
        }
        switch (c4108aq.f15284s) {
            case 130:
                m15796a(c4108aq, z2);
                break;
            default:
                m15803b(c4108aq, z2);
                break;
        }
        m15835j();
    }

    /* renamed from: h */
    public void m15833h() {
        this.f14842t = null;
        if (this.f14834l != null) {
            this.f14834l.setOnClickListener(null);
        }
        if (this.f14838p != null) {
            this.f14838p.setTag(null);
        }
        if (this.f14802D != null) {
            this.f14802D.setOnClickListener(null);
        }
    }

    /* renamed from: i */
    public C4108aq m15834i() {
        return this.f14842t;
    }

    public void setMsgListItemHandler(Handler handler) {
        this.f14841s = handler;
    }

    /* renamed from: a */
    private void m15796a(C4108aq c4108aq, boolean z) throws Throwable {
        m15821q();
        this.f14839q.setText(this.mContext.getString(R.string.message_size_label) + String.valueOf((c4108aq.f15288w + 1023) / 1024) + this.mContext.getString(R.string.kilobyte));
        this.f14844v.setText(c4108aq.f15274i);
        if (z && !C3847e.m14679ak()) {
            this.f14800A.setVisibility(0);
            if (c4108aq.f15275j != null) {
                this.f14800A.setText(C2190d.m9840f(c4108aq.f15275j));
            }
        }
        switch (C3881d.m14970b().m14975a(c4108aq.f15283r)) {
            case 129:
                m15823s();
                this.f14840r.setVisibility(8);
                break;
            default:
                setLongClickable(true);
                m15823s();
                this.f14840r.setVisibility(0);
                this.f14840r.setOnClickListener(new ViewOnClickListenerC4116ay(this, c4108aq));
                break;
        }
        m15798a(c4108aq.f15275j, false);
        this.f14826c.setVisibility(8);
        this.f14825b.setVisibility(8);
        m15809e(c4108aq);
    }

    /* renamed from: a */
    public void m15831a(C4108aq c4108aq) {
        C3892o.m15014a(this.f14825b, c4108aq.f15243B);
        this.f14825b.m16284a();
        if (c4108aq.f15243B) {
            Iterator<C3855a> it = c4108aq.f15287v.f13926b.iterator();
            while (it.hasNext()) {
                this.f14825b.m16285a(it.next(), this.f14819W);
            }
        }
    }

    /* renamed from: a */
    private void m15797a(C4108aq c4108aq, boolean z, MessageListItem messageListItem) {
        int size = z ? 1 : c4108aq.f15287v.size();
        if (C3847e.m14682an() && z) {
            size = m15800b(c4108aq);
        }
        this.f14804F.m16344a(size, c4108aq);
        C3890m.m14996b("MessageListItem", "present " + this.f14842t.m16302e());
        this.f14804F.m16346a(messageListItem);
        m15807d(c4108aq);
    }

    /* renamed from: b */
    private int m15800b(C4108aq c4108aq) {
        if (!c4108aq.m16313p() || c4108aq.f15287v == null || c4108aq.f15287v.size() == 0) {
            return 0;
        }
        int size = c4108aq.f15287v.size();
        boolean z = true;
        int i = 0;
        for (int i2 = 0; i2 < size && z; i2++) {
            C3869o c3869o = c4108aq.f15287v.get(i2);
            if (c3869o != null && (c3869o.m14863e() || ((c3869o.m14861d() && !TextUtils.isEmpty(c3869o.m14874n().m14940a())) || c3869o.m14867g() || c3869o.m14865f()))) {
                C3890m.m14997c("MessageListItem", "vSlideModel not null, count=" + i2);
                i = i2 + 1;
                z = false;
            }
        }
        C3890m.m14997c("MessageListItem", "findFirstValidSlide=" + i);
        return i;
    }

    /* renamed from: a */
    private void m15798a(String str, boolean z) {
        if (z || !TextUtils.isEmpty(str)) {
            C3782a c3782aM14205a = z ? C3782a.m14205a(false) : C3782a.m14204a(str, false);
            c3782aM14205a.m14256a(this.mContext, f14794C);
            if (z) {
                if (C4822an.m18218a()) {
                    C2496n.m10763a(this.f14847y, EnumC2498p.ROUND);
                    this.f14847y.setBackgroundResource(R.drawable.circle_background);
                    return;
                } else {
                    C2496n.m10775b(this.f14847y, EnumC2498p.SQUARE);
                    this.f14847y.setBackgroundResource(R.drawable.frame_background);
                    return;
                }
            }
            if (c3782aM14205a.m14269k() == null || c3782aM14205a.m14269k().equals("")) {
                C2496n.m10765a(this.f14847y, c3782aM14205a.m14269k(), EnumC2498p.SQUARE);
                this.f14847y.setBackgroundResource(R.drawable.frame_background);
                return;
            } else if (c3782aM14205a.m14270l() == 1) {
                C2496n.m10784c(this.f14847y, c3782aM14205a.m14269k(), EnumC2498p.SQUARE);
                this.f14847y.setBackgroundResource(R.drawable.frame_background);
                return;
            } else {
                C2496n.m10765a(this.f14847y, c3782aM14205a.m14269k(), EnumC2498p.ROUND);
                this.f14847y.setBackgroundResource(R.drawable.circle_background);
                return;
            }
        }
        this.f14847y.setImageDrawable(f14794C);
    }

    /* renamed from: b */
    private void m15803b(C4108aq c4108aq, boolean z) throws Throwable {
        if (z && !C3847e.m14679ak() && this.f14800A != null) {
            this.f14800A.setVisibility(0);
            if (c4108aq.f15275j != null) {
                String strM9840f = C2190d.m9840f(c4108aq.f15275j);
                if (c4108aq.m16311n()) {
                    this.f14800A.setText("");
                } else {
                    this.f14800A.setText(strM9840f);
                }
            }
        }
        if (this.f14840r != null) {
            this.f14840r.setVisibility(8);
        }
        boolean zIsOutgoingFolder = Telephony.Sms.isOutgoingFolder(c4108aq.m16306i());
        m15798a(zIsOutgoingFolder ? null : c4108aq.f15275j, zIsOutgoingFolder);
        if (!c4108aq.f15282q) {
            m15795a(c4108aq, this.f14847y);
        }
        if (c4108aq.m16316s()) {
            this.f14801B.setVisibility(0);
            this.f14844v.setVisibility(8);
        } else {
            this.f14801B.setVisibility(8);
            this.f14844v.setVisibility(0);
            this.f14844v.setText(c4108aq.f15274i);
        }
        m15831a(c4108aq);
        C3892o.m15014a(this.f14839q, !c4108aq.m16311n());
        if (c4108aq.m16311n()) {
            m15797a(c4108aq, C3847e.m14682an(), this);
        } else {
            m15805c(c4108aq);
            m15821q();
        }
        this.f14821a.setOnClickListener(new ViewOnClickListenerC4122bd(this));
        this.f14821a.setOnLongClickListener(new ViewOnLongClickListenerC4123be(this));
        this.f14821a.setFocusable(true);
        this.f14821a.setClickable(true);
        m15809e(c4108aq);
        requestLayout();
    }

    /* renamed from: c */
    private void m15805c(C4108aq c4108aq) {
        CharSequence charSequenceM16297a = c4108aq.m16297a();
        if (charSequenceM16297a == null) {
            charSequenceM16297a = m15829a(this.mContext, c4108aq.f15277l, c4108aq.f15279n, c4108aq.f15278m, this.f14839q);
            c4108aq.m16298a(charSequenceM16297a);
        }
        if (C3847e.m14682an()) {
            String string = charSequenceM16297a.toString();
            if (!TextUtils.isEmpty(string)) {
                String str = C3878ac.m14956a(string, m15818n()) + "...";
                charSequenceM16297a = str.subSequence(0, str.length());
            }
        }
        this.f14839q.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.f14839q.setText(charSequenceM16297a);
        this.f14839q.setTextSize(0, m15825u());
        this.f14839q.setVisibility(0);
        m15794a(this.f14839q, c4108aq.m16317t());
    }

    /* renamed from: j */
    protected void m15835j() {
        float fM19096b = ((C5034k.m19096b() - C5034k.m19088a(80.0f)) - C5034k.m19088a(41.0f)) - this.f14844v.getPaint().measureText(this.f14844v.getText().toString());
        if (this.f14837o.getVisibility() == 0) {
            fM19096b -= C5034k.m19088a(30.0f);
        }
        if (this.f14839q != null) {
            this.f14839q.setMaxWidth((int) fM19096b);
        }
        if (this.f14804F != null) {
            this.f14804F.m16349b((int) fM19096b);
        }
    }

    /* renamed from: k */
    protected float m15836k() {
        this.f14814R = 0.0f;
        this.f14814R = C5034k.m19096b() - C5034k.m19088a(80.0f);
        this.f14814R -= C5034k.m19088a(41.0f);
        this.f14814R -= this.f14844v.getPaint().measureText(this.f14844v.getText().toString());
        this.f14814R -= C5034k.m19088a(8.0f);
        if (this.f14836n.getVisibility() == 0) {
            this.f14814R -= this.f14836n.getWidth();
        }
        this.f14835m.setMaxWidth((int) this.f14814R);
        return this.f14814R;
    }

    /* renamed from: q */
    private void m15821q() {
        this.f14803E.setVisibility(8);
        if (this.f14804F != null) {
            Iterator<MmsSlideView> it = this.f14804F.iterator();
            while (it.hasNext()) {
                C3892o.m15014a((View) it.next(), false);
            }
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: a */
    public void mo15728a() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: b */
    public void mo15730b() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setAudio(Uri uri, String str, Map<String, ?> map) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImage(String str, Bitmap bitmap) {
        m15822r();
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_missing_thumbnail_picture);
            } catch (OutOfMemoryError e) {
                C3890m.m14995a("MessageListItem", "setImage: out of memory: ", e);
                return;
            }
        }
        this.f14815S = bitmap.getWidth();
        this.f14816T = bitmap.getHeight();
        m15836k();
        if (this.f14815S * 1.5d < this.f14814R) {
            this.f14835m.setLayoutParams(new FrameLayout.LayoutParams((int) (this.f14815S * 1.5d), (int) (this.f14816T * 1.5d)));
        } else {
            this.f14835m.setLayoutParams(new FrameLayout.LayoutParams((int) this.f14814R, (int) (this.f14814R * (this.f14816T / this.f14815S))));
        }
        this.f14835m.setImageBitmap(bitmap);
        this.f14835m.setVisibility(0);
        this.f14835m.setFocusable(false);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setRawAttachment(String str) {
        m15822r();
        ImageView imageView = (ImageView) findViewById(R.id.attachment_icon);
        if (str.toLowerCase().endsWith("vcf")) {
            imageView.setImageResource(R.drawable.co_attach_p_contact_normal);
        } else if (str.toLowerCase().endsWith("vcs")) {
            imageView.setImageResource(R.drawable.co_attach_p_calendar_normal);
        }
        ((TextView) findViewById(R.id.attach_file_name)).setText(str.split("\\.")[0]);
        this.f14802D.setVisibility(0);
        this.f14802D.setFocusable(false);
    }

    public void setRawAttachmentVisibility(boolean z) {
    }

    /* renamed from: r */
    private void m15822r() {
        if (this.f14833k == null) {
            this.f14833k = findViewById(R.id.mms_view);
            this.f14834l = (FrameLayout) findViewById(R.id.thumbnail);
            this.f14835m = (ImageView) findViewById(R.id.image_view);
            this.f14838p = (ImageButton) findViewById(R.id.play_slideshow_button);
            this.f14802D = (LinearLayout) findViewById(R.id.attachment_view);
            m15836k();
        }
    }

    /* renamed from: s */
    private void m15823s() {
        if (this.f14840r == null) {
            findViewById(R.id.mms_downloading_view_stub).setVisibility(0);
            this.f14840r = (ImageButton) findViewById(R.id.btn_download_msg);
        }
    }

    /* renamed from: a */
    public CharSequence m15829a(Context context, String str, Pattern pattern, String str2, TextView textView) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            if (str2 != null && "text/html".equals(str2)) {
                spannableStringBuilder.append((CharSequence) "\n");
                spannableStringBuilder.append((CharSequence) Html.fromHtml(str));
            } else if (C3847e.m14694az()) {
                spannableStringBuilder.append(C2799k.m11709a(context, str, (int) (textView.getLineHeight() * 1.2f)));
            } else {
                spannableStringBuilder.append((CharSequence) str);
            }
        }
        if (pattern != null) {
            Matcher matcher = pattern.matcher(spannableStringBuilder.toString());
            while (matcher.find()) {
                spannableStringBuilder.setSpan(new StyleSpan(1), matcher.start(), matcher.end(), 0);
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: d */
    private void m15807d(C4108aq c4108aq) {
        switch (c4108aq.f15285t) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
                setLongClickable(false);
                setClickable(true);
                break;
        }
    }

    /* renamed from: l */
    public void m15837l() {
        if (this.f14842t != null && this.f14842t.m16314q() && this.f14842t.m16317t()) {
            m15824t();
            return;
        }
        URLSpan[] urls = this.f14839q.getUrls();
        if (urls.length != 0) {
            if (urls.length == 1) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(urls[0].getURL()));
                intent.putExtra("com.android.browser.application_id", this.mContext.getPackageName());
                intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
                this.mContext.startActivity(intent);
                return;
            }
            ArrayList<String> arrayListM16397a = C4149cd.m16397a(urls);
            C4125bg c4125bg = new C4125bg(this, this.mContext, android.R.layout.select_dialog_item, arrayListM16397a);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            DialogInterfaceOnClickListenerC4126bh dialogInterfaceOnClickListenerC4126bh = new DialogInterfaceOnClickListenerC4126bh(this, arrayListM16397a);
            builder.setTitle(R.string.select_link_title);
            builder.setCancelable(true);
            builder.setAdapter(c4125bg, dialogInterfaceOnClickListenerC4126bh);
            builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC4127bi(this));
            builder.show();
        }
    }

    /* renamed from: a */
    private void m15795a(C4108aq c4108aq, ProfileImageView profileImageView) {
        profileImageView.setFocusable(true);
        profileImageView.setClickable(true);
        profileImageView.setOnClickListener(new ViewOnClickListenerC4128bj(this, c4108aq));
    }

    /* renamed from: t */
    private void m15824t() {
        int i;
        if (this.f14842t.f15267b.equals("sms")) {
            i = 2;
        } else {
            i = 1;
        }
        if (this.f14841s != null) {
            Message messageObtain = Message.obtain(this.f14841s, i);
            messageObtain.obj = new Long(this.f14842t.f15268c);
            messageObtain.sendToTarget();
        }
    }

    /* renamed from: e */
    private void m15809e(C4108aq c4108aq) {
        if (c4108aq.f15273h) {
            this.f14836n.setImageResource(R.drawable.ic_lock_message_sms);
            this.f14836n.setVisibility(0);
        } else {
            this.f14836n.setVisibility(8);
        }
        if ((c4108aq.m16314q() && c4108aq.m16317t()) || c4108aq.f15271f == EnumC4109ar.FAILED) {
            this.f14837o.setImageResource(R.drawable.download_ic_noti);
            this.f14837o.setVisibility(0);
            C3892o.m15014a((View) this.f14844v, false);
        } else if (!c4108aq.m16312o() || c4108aq.f15271f != EnumC4109ar.RECEIVED) {
            this.f14837o.setVisibility(8);
        }
        if (c4108aq.f15271f == EnumC4109ar.INFO || c4108aq.f15272g || !c4108aq.m16311n() || c4108aq.f15271f == EnumC4109ar.RECEIVED) {
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageRegionFit(String str) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setText(String str, String str2) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setTextVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideo(String str, Uri uri) throws IOException {
        m15822r();
        try {
            Bitmap bitmapM16286a = VideoAttachmentView.m16286a(this.mContext, uri);
            if (bitmapM16286a == null) {
                bitmapM16286a = BitmapFactory.decodeResource(getResources(), R.drawable.ic_missing_thumbnail_video);
            }
            this.f14815S = bitmapM16286a.getWidth();
            this.f14816T = bitmapM16286a.getHeight();
            m15836k();
            if (this.f14815S < this.f14814R) {
                this.f14835m.setLayoutParams(new FrameLayout.LayoutParams((int) this.f14815S, (int) this.f14816T));
            }
            this.f14835m.setImageBitmap(bitmapM16286a);
            this.f14835m.setVisibility(0);
            this.f14835m.setFocusable(false);
        } catch (OutOfMemoryError e) {
            C3890m.m14995a("MessageListItem", "setVideo: out of memory: ", e);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideoVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: c */
    public void mo15732c() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: d */
    public void mo15733d() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4343ji
    /* renamed from: e */
    public void mo15734e() {
        if (this.f14835m != null) {
            this.f14835m.setVisibility(8);
        }
        if (this.f14838p != null) {
            this.f14838p.setVisibility(8);
        }
        if (this.f14802D != null) {
            this.f14802D.setVisibility(8);
        }
    }

    public void setVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: f */
    public void mo15735f() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: g */
    public void mo15736g() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: a */
    public void mo15729a(int i) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: b */
    public void mo15731b(int i) {
    }

    /* renamed from: u */
    private float m15825u() {
        String strM18121a = C4809aa.m18104a().m18121a("Default Font Size", EnumC3594ed.Normal.m13900a());
        EnumC3594ed enumC3594edM13899a = EnumC3594ed.Normal;
        try {
            enumC3594edM13899a = EnumC3594ed.m13899a(strM18121a);
        } catch (Exception e) {
            C4904y.m18634a("cannot get font size : " + strM18121a, "MessageListItem");
        }
        String strName = enumC3594edM13899a.name();
        if (strName.equals(EnumC3594ed.System.name())) {
            return C4822an.m18220b(CommonApplication.m18732r());
        }
        if (strName.equals(EnumC3594ed.Tiny.name())) {
            return getResources().getDimension(R.dimen.font_size_tiny);
        }
        if (strName.equals(EnumC3594ed.Small.name())) {
            return getResources().getDimension(R.dimen.font_size_small);
        }
        if (strName.equals(EnumC3594ed.Normal.name())) {
            return getResources().getDimension(R.dimen.font_size_normal);
        }
        if (strName.equals(EnumC3594ed.Large.name())) {
            return getResources().getDimension(R.dimen.font_size_large);
        }
        if (strName.equals(EnumC3594ed.Huge.name())) {
            return getResources().getDimension(R.dimen.font_size_huge);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("unknown fontSizeName : " + strName, "MessageListItem");
        }
        return getResources().getDimension(R.dimen.font_size_normal);
    }

    public void setAdapter(C4110as c4110as) {
    }

    public void setCheckBox(int i, boolean z) {
        this.f14848z.setVisibility(i);
        this.f14848z.setChecked(z);
    }

    /* renamed from: m */
    public View m15838m() {
        return this.f14848z;
    }

    public void setBodyTextViewVisibility(boolean z) {
        if (z) {
            this.f14839q.setVisibility(0);
        } else {
            this.f14839q.setVisibility(8);
        }
    }

    /* renamed from: n */
    public static int m15818n() {
        return 140;
    }

    /* renamed from: a */
    public static void m15794a(TextView textView, boolean z) {
        textView.setTextColor(z ? -13487566 : m15791a(textView.getContext()));
        textView.setLinkTextColor(m15799b(textView.getContext()));
    }

    /* renamed from: a */
    private static int m15791a(Context context) {
        if (-1 == f14795P) {
            f14795P = context.getResources().getColor(R.drawable.text_color_black);
        }
        return f14795P;
    }

    /* renamed from: b */
    private static int m15799b(Context context) {
        if (-1 == f14796Q) {
            f14796Q = context.getResources().getColor(R.color.message_link_text_color);
        }
        return f14796Q;
    }

    /* renamed from: v */
    private Drawable m15826v() {
        if (this.f14832j == null) {
            this.f14832j = C3474r.m13840i(this.mContext, this.f14831i);
        }
        if (this.f14832j != null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("success to get drawable. Receive bubble ID:" + this.f14831i, "MessageListItem");
            }
            return this.f14832j.getConstantState().newDrawable();
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("Fail to get drawable. Receive bubble ID:" + this.f14831i, "MessageListItem");
        }
        return this.mContext.getResources().getDrawable(R.drawable.bubble_receive_01_normal);
    }

    /* renamed from: w */
    private Drawable m15827w() {
        if (this.f14830h == null) {
            this.f14830h = C3474r.m13838g(this.mContext, this.f14829g);
        }
        if (this.f14830h != null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("success to get drawable. Send bubble ID:" + this.f14829g, "MessageListItem");
            }
            return this.f14830h.getConstantState().newDrawable();
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("Fail to get drawable. Send bubble ID:" + this.f14829g, "MessageListItem");
        }
        return this.mContext.getResources().getDrawable(R.drawable.bubble_send_01_normal);
    }

    /* renamed from: x */
    private void m15828x() {
        if (TextUtils.isEmpty(this.f14829g) || TextUtils.isEmpty(this.f14831i)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("send or receive bubble ID is empty", "MessageListItem");
            }
        } else if (this.f14842t.m16315r()) {
            this.f14821a.setBackgroundDrawable(m15826v());
        } else {
            this.f14821a.setBackgroundDrawable(m15827w());
        }
    }
}
