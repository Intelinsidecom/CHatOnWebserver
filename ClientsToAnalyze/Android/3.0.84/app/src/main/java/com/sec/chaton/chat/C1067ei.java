package com.sec.chaton.chat;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.R;
import com.sec.chaton.chat.p023a.AbstractC0888a;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;
import java.util.HashMap;
import org.p072a.p073a.p074a.p075a.C3702j;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.ei */
/* loaded from: classes.dex */
public class C1067ei extends SimpleCursorAdapter {

    /* renamed from: c */
    private Context f4186c;

    /* renamed from: d */
    private LayoutInflater f4187d;

    /* renamed from: e */
    private ListView f4188e;

    /* renamed from: f */
    private C3326c f4189f;

    /* renamed from: g */
    private C3702j<EnumC1455w, AbstractC0888a> f4190g;

    /* renamed from: h */
    private EnumC1450r f4191h;

    /* renamed from: i */
    private boolean f4192i;

    /* renamed from: j */
    private String f4193j;

    /* renamed from: k */
    private Drawable f4194k;

    /* renamed from: l */
    private String f4195l;

    /* renamed from: m */
    private Drawable f4196m;

    /* renamed from: n */
    private float f4197n;

    /* renamed from: o */
    private Typeface f4198o;

    /* renamed from: p */
    private ArrayList<String> f4199p;

    /* renamed from: q */
    private HashMap<Long, Boolean> f4200q;

    /* renamed from: r */
    private long f4201r;

    /* renamed from: s */
    private HashMap<Long, Boolean> f4202s;

    /* renamed from: t */
    private long f4203t;

    /* renamed from: u */
    private EnumC1071em f4204u;

    /* renamed from: v */
    private long f4205v;

    /* renamed from: w */
    private InterfaceC1093fh f4206w;

    /* renamed from: x */
    private Bitmap f4207x;

    /* renamed from: b */
    private static final String f4185b = C1067ei.class.getSimpleName();

    /* renamed from: a */
    public static final String[] f4184a = {"_id", "message_inbox_no", "message_sever_id", "message_session_id", "message_read_status", "message_time", "message_content", "message_translated", "message_type", "message_sender", "message_is_failed", "buddy_name", "buddy_profile_status"};

    public C1067ei(Context context, ListView listView, Cursor cursor, EnumC1450r enumC1450r, Typeface typeface, float f, C3326c c3326c, C3702j<EnumC1455w, AbstractC0888a> c3702j, SlookAirButton.ItemSelectListener itemSelectListener) {
        super(context, R.layout.item_balloon_skin0, cursor, f4184a, null, 2);
        this.f4204u = EnumC1071em.SELECT_NONE;
        this.f4207x = null;
        this.f4187d = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f4192i = true;
        this.f4186c = context;
        this.f4188e = listView;
        this.f4191h = enumC1450r;
        this.f4189f = c3326c;
        this.f4190g = c3702j;
        this.f4198o = typeface;
        this.f4197n = f;
        this.f4199p = new ArrayList<>();
        this.f4200q = new HashMap<>();
        this.f4202s = new HashMap<>();
        this.f4193j = C3159aa.m10962a().m10979a("setting_change_bubble_send", "-1");
        this.f4195l = C3159aa.m10962a().m10979a("setting_change_bubble_receive", "-1");
        if (C3250y.f11735c) {
            C3250y.m11453c("[constructor] send bubble:" + this.f4193j + " recv bubble:" + this.f4195l, f4185b);
        }
    }

    /* renamed from: a */
    public void m5283a(long j) {
        this.f4203t = j;
    }

    /* renamed from: b */
    public void m5289b(long j) {
        this.f4201r = j;
    }

    /* renamed from: a */
    public HashMap<Long, Boolean> m5282a() {
        return this.f4200q;
    }

    /* renamed from: b */
    public HashMap<Long, Boolean> m5288b() {
        return this.f4202s;
    }

    /* renamed from: c */
    public void m5290c() {
        if (this.f4200q != null && !this.f4200q.isEmpty()) {
            this.f4200q.clear();
        }
        if (this.f4202s != null && !this.f4202s.isEmpty()) {
            this.f4202s.clear();
        }
    }

    /* renamed from: a */
    public void m5285a(EnumC1071em enumC1071em) {
        this.f4204u = enumC1071em;
    }

    /* renamed from: d */
    public EnumC1071em m5291d() {
        return this.f4204u;
    }

    /* renamed from: a */
    public void m5286a(InterfaceC1093fh interfaceC1093fh) {
        this.f4206w = interfaceC1093fh;
    }

    /* renamed from: a */
    public void m5287a(boolean z) {
        this.f4192i = z;
    }

    /* renamed from: e */
    public void m5292e() {
        this.f4188e = null;
    }

    /* renamed from: a */
    public void m5284a(Bitmap bitmap) {
        this.f4207x = bitmap;
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f4187d.inflate(R.layout.item_balloon_skin0, viewGroup, false);
        C1070el c1070el = new C1070el();
        c1070el.f4238a = viewInflate;
        c1070el.f4212A = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutDate);
        c1070el.f4274d = (TextView) viewInflate.findViewById(R.id.textDate);
        c1070el.f4274d.setLongClickable(false);
        c1070el.f4215D = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutInvite);
        c1070el.f4215D.setVisibility(8);
        c1070el.f4275e = (TextView) viewInflate.findViewById(R.id.textInvite);
        c1070el.f4275e.setLongClickable(false);
        c1070el.f4276f = (TextView) viewInflate.findViewById(R.id.reInvite);
        c1070el.f4280j = (ViewGroup) viewInflate.findViewById(R.id.parentRcv);
        c1070el.f4280j.setVisibility(8);
        c1070el.f4282l = (ImageView) viewInflate.findViewById(R.id.imageProfile);
        c1070el.f4284n = (ImageView) viewInflate.findViewById(R.id.countryFlag);
        c1070el.f4281k = (TextView) viewInflate.findViewById(R.id.textName);
        c1070el.f4213B = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutTime);
        c1070el.f4214C = (TextView) viewInflate.findViewById(R.id.textRcvTime);
        c1070el.f4217F = (ProgressBar) viewInflate.findViewById(R.id.DownProgressBalloon);
        c1070el.f4250ae = (Button) viewInflate.findViewById(R.id.download_completed);
        c1070el.f4216E = (ProgressBar) viewInflate.findViewById(R.id.progressbarDown);
        c1070el.f4216E.setVisibility(4);
        c1070el.f4218G = (Button) viewInflate.findViewById(R.id.btnDownCancel);
        c1070el.f4218G.setVisibility(4);
        c1070el.f4218G.setTag(viewInflate);
        c1070el.f4219H = (CheckBox) viewInflate.findViewById(R.id.chkRcvId);
        c1070el.f4285o = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvContent);
        c1070el.f4285o.setLongClickable(true);
        c1070el.f4285o.setTag(viewInflate);
        c1070el.f4286p = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvText);
        c1070el.f4287q = (TextView) viewInflate.findViewById(R.id.textRcvContent);
        c1070el.f4287q.setVisibility(8);
        c1070el.f4287q.setTypeface(this.f4198o);
        c1070el.f4287q.setLongClickable(true);
        c1070el.f4288r = (TextView) viewInflate.findViewById(R.id.textRcvContentDivider);
        c1070el.f4288r.setVisibility(8);
        c1070el.f4289s = (TextView) viewInflate.findViewById(R.id.textRcvContentTranslated);
        c1070el.f4289s.setTypeface(this.f4198o);
        c1070el.f4289s.setVisibility(8);
        c1070el.f4290t = (ImageView) viewInflate.findViewById(R.id.icon_translate);
        c1070el.f4290t.setVisibility(8);
        c1070el.f4251af = (LinearLayout) viewInflate.findViewById(R.id.recvLongMessageAddLayout);
        c1070el.f4253ah = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutRcvLiveText);
        c1070el.f4253ah.setLongClickable(true);
        c1070el.f4254ai = (TextView) viewInflate.findViewById(R.id.textRcvLiveContent);
        c1070el.f4255aj = (TextView) viewInflate.findViewById(R.id.recv_live_body_text);
        c1070el.f4291u = (ImageView) viewInflate.findViewById(R.id.imageRcvContent);
        c1070el.f4291u.setVisibility(8);
        c1070el.f4291u.setLongClickable(true);
        c1070el.f4291u.setTag(viewInflate);
        c1070el.f4292v = (LinearLayout) viewInflate.findViewById(R.id.lLayoutETC);
        c1070el.f4292v.setVisibility(8);
        c1070el.f4292v.setLongClickable(true);
        c1070el.f4293w = (ImageView) viewInflate.findViewById(R.id.imageEtcContent);
        c1070el.f4293w.setLongClickable(true);
        c1070el.f4293w.setTag(viewInflate);
        c1070el.f4294x = (TextView) viewInflate.findViewById(R.id.textEtcContent);
        c1070el.f4294x.setTypeface(this.f4198o);
        c1070el.f4295y = (TextView) viewInflate.findViewById(R.id.textEtcContentTranslated);
        c1070el.f4295y.setTypeface(this.f4198o);
        c1070el.f4296z = (ImageView) viewInflate.findViewById(R.id.etc_icon_translate);
        c1070el.f4296z.setVisibility(8);
        c1070el.f4249ad = (ProgressBar) viewInflate.findViewById(R.id.imageLoadingProgressbar);
        c1070el.f4278h = (ViewGroup) viewInflate.findViewById(R.id.rSendRoot);
        c1070el.f4279i = (RelativeLayout) this.f4187d.inflate(R.layout.item_balloon_sent, c1070el.f4278h, true);
        c1070el.f4279i.setVisibility(8);
        c1070el.f4283m = (ImageView) c1070el.f4279i.findViewById(R.id.imageMeProfile);
        c1070el.f4260ao = (LinearLayout) c1070el.f4279i.findViewById(R.id.lLayoutSndContent2);
        c1070el.f4232U = (LinearLayout) c1070el.f4279i.findViewById(R.id.lLayoutSndTime);
        c1070el.f4233V = (TextView) c1070el.f4279i.findViewById(R.id.textSndTime);
        c1070el.f4234W = (CheckBox) c1070el.f4279i.findViewById(R.id.chkSndId);
        c1070el.f4220I = (Button) c1070el.f4279i.findViewById(R.id.btnSendCancel);
        c1070el.f4236Y = (ProgressBar) c1070el.f4279i.findViewById(R.id.progressBalloon);
        c1070el.f4236Y.setVisibility(4);
        c1070el.f4237Z = (ProgressBar) c1070el.f4279i.findViewById(R.id.progressbarUp);
        c1070el.f4237Z.setVisibility(4);
        c1070el.f4246aa = (ProgressBar) c1070el.f4279i.findViewById(R.id.progressClock);
        c1070el.f4237Z.setVisibility(4);
        c1070el.f4247ab = (ImageView) c1070el.f4279i.findViewById(R.id.btnSendPended);
        c1070el.f4247ab.setVisibility(4);
        c1070el.f4277g = (TextView) c1070el.f4279i.findViewById(R.id.chat_ack);
        c1070el.f4248ac = (Button) c1070el.f4279i.findViewById(R.id.btnError);
        c1070el.f4248ac.setTag(viewInflate);
        c1070el.f4221J = (LinearLayout) c1070el.f4279i.findViewById(R.id.lLayoutSndContent);
        c1070el.f4221J.setLongClickable(true);
        c1070el.f4221J.setTag(viewInflate);
        c1070el.f4222K = (LinearLayout) c1070el.f4279i.findViewById(R.id.lLayoutSndText);
        c1070el.f4223L = (TextView) c1070el.f4279i.findViewById(R.id.textSndContent);
        c1070el.f4223L.setTypeface(this.f4198o);
        c1070el.f4223L.setVisibility(8);
        c1070el.f4223L.setLongClickable(true);
        c1070el.f4224M = (TextView) c1070el.f4279i.findViewById(R.id.textSndContentDivider);
        c1070el.f4224M.setVisibility(8);
        c1070el.f4225N = (TextView) c1070el.f4279i.findViewById(R.id.textSndContentTranslated);
        c1070el.f4225N.setTypeface(this.f4198o);
        c1070el.f4225N.setVisibility(8);
        c1070el.f4252ag = (LinearLayout) viewInflate.findViewById(R.id.sendLongMessageAddLayout);
        c1070el.f4252ag.setVisibility(8);
        c1070el.f4252ag.setLongClickable(true);
        c1070el.f4256ak = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutSndLiveText);
        c1070el.f4256ak.setLongClickable(true);
        c1070el.f4257al = (TextView) viewInflate.findViewById(R.id.textSndLiveContent);
        c1070el.f4258am = (TextView) viewInflate.findViewById(R.id.send_live_body_text);
        c1070el.f4226O = (ImageView) c1070el.f4279i.findViewById(R.id.imageSndContent);
        c1070el.f4226O.setVisibility(8);
        c1070el.f4226O.setLongClickable(true);
        c1070el.f4235X = (ProgressBar) c1070el.f4279i.findViewById(R.id.sendImageLoadingProgressbar);
        c1070el.f4227P = (ImageView) c1070el.f4279i.findViewById(R.id.imageSndAniContent);
        c1070el.f4227P.setVisibility(8);
        c1070el.f4227P.setLongClickable(true);
        c1070el.f4228Q = (LinearLayout) c1070el.f4279i.findViewById(R.id.lLayoutSndETC);
        c1070el.f4228Q.setVisibility(8);
        c1070el.f4228Q.setLongClickable(true);
        c1070el.f4229R = (ImageView) c1070el.f4279i.findViewById(R.id.imageEtcSndContent);
        c1070el.f4229R.setLongClickable(true);
        c1070el.f4229R.setTag(viewInflate);
        c1070el.f4230S = (TextView) c1070el.f4279i.findViewById(R.id.textEtcSndContent);
        c1070el.f4230S.setTypeface(this.f4198o);
        c1070el.f4231T = (TextView) c1070el.f4279i.findViewById(R.id.textEtcSndContentTranslated);
        c1070el.f4231T.setTypeface(this.f4198o);
        c1070el.f4259an = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvContent2);
        c1070el.f4261ap = (RelativeLayout) viewInflate.findViewById(R.id.sendAppLinkLayout);
        c1070el.f4262aq = (TextView) viewInflate.findViewById(R.id.appLinkSndText);
        c1070el.f4263ar = (RelativeLayout) viewInflate.findViewById(R.id.sendAppLinkConnectLayout);
        c1070el.f4264as = (TextView) viewInflate.findViewById(R.id.appLinkSndConnectText);
        c1070el.f4265at = (RelativeLayout) viewInflate.findViewById(R.id.rcvAppLinkLayout);
        c1070el.f4266au = (TextView) viewInflate.findViewById(R.id.appLinkRcvText);
        c1070el.f4267av = (RelativeLayout) viewInflate.findViewById(R.id.rcvAppLinkConnectLayout);
        c1070el.f4268aw = (TextView) viewInflate.findViewById(R.id.appLinkRcvConnectText);
        m5271a(c1070el);
        viewInflate.setTag(c1070el);
        return viewInflate;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C1070el c1070el = (C1070el) view.getTag();
        int position = cursor.getPosition();
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        long j2 = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        long j3 = c1070el.f4273c;
        c1070el.f4273c = j2;
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
        String string = cursor.getString(cursor.getColumnIndex("message_sender"));
        EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        int i = cursor.getInt(cursor.getColumnIndex("message_type"));
        boolean z = true;
        if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(string)) {
            z = false;
        }
        if (z) {
            c1070el.f4272b = String.valueOf(j);
        } else {
            c1070el.f4272b = String.valueOf(j2);
        }
        if (enumC1455wM6358a != EnumC1455w.SYSTEM && i != 0 && i != 3 && this.f4188e.getChoiceMode() == 2) {
            m5272a(c1070el, position, z, lValueOf.longValue());
        } else {
            c1070el.f4219H.setVisibility(8);
            c1070el.f4234W.setVisibility(8);
            this.f4199p.clear();
        }
        if (this.f4207x != null) {
            c1070el.f4284n.setImageDrawable(new BitmapDrawable(this.f4186c.getResources(), this.f4207x));
            c1070el.f4284n.setVisibility(0);
        } else {
            c1070el.f4284n.setImageDrawable(null);
            c1070el.f4284n.setVisibility(8);
        }
        AbstractC0888a abstractC0888aM13338b = null;
        try {
            if (c1070el.f4270ay != null) {
                if (c1070el.f4269ax == enumC1455wM6358a) {
                    abstractC0888aM13338b = c1070el.f4270ay;
                    if (j3 != j2) {
                        abstractC0888aM13338b.mo5090a(false);
                    } else {
                        abstractC0888aM13338b.mo5090a(true);
                    }
                } else {
                    this.f4190g.m13337a((C3702j<EnumC1455w, AbstractC0888a>) c1070el.f4269ax, (EnumC1455w) c1070el.f4270ay);
                }
            }
            if (abstractC0888aM13338b == null) {
                abstractC0888aM13338b = this.f4190g.m13338b((C3702j<EnumC1455w, AbstractC0888a>) enumC1455wM6358a);
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("NumActive: " + this.f4190g.mo13287b() + ", NumIdle: " + this.f4190g.mo13285a(), f4185b);
            }
            c1070el.f4269ax = enumC1455wM6358a;
            c1070el.f4270ay = abstractC0888aM13338b;
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f4185b);
            }
        }
        if (abstractC0888aM13338b != null) {
            try {
                abstractC0888aM13338b.m5089a(this.f4206w);
                abstractC0888aM13338b.m5088a(this.f4186c, this.f4191h, view, this.mCursor, c1070el, this.f4192i, this.f4189f, this.f4197n);
            } catch (Exception e2) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e2, f4185b);
                }
            }
        }
        C1770b.m7289a().m7295a(j2 == 0 ? j : j2, view);
    }

    /* renamed from: f */
    public void m5293f() {
        this.f4204u = EnumC1071em.SELECT_NONE;
        m5290c();
    }

    /* renamed from: g */
    public void m5294g() {
        this.f4204u = EnumC1071em.SELECT_ALL;
        m5290c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5278h() {
        long j = this.f4203t + this.f4201r;
        long size = this.f4200q.size() + this.f4202s.size();
        if (size == 0) {
            m5293f();
        } else if (j == size) {
            m5294g();
        } else {
            this.f4204u = EnumC1071em.SELECT_PART;
        }
        this.f4206w.mo4979a(size > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5279i() {
        long j = this.f4203t + this.f4201r;
        long size = j - (this.f4200q.size() + this.f4202s.size());
        if (j == 0) {
            m5293f();
        } else if (j == size) {
            m5294g();
        } else {
            this.f4204u = EnumC1071em.SELECT_PART_AFTER_ALL;
            Cursor cursor = getCursor();
            cursor.moveToLast();
            this.f4205v = cursor.getLong(cursor.getColumnIndex("message_time"));
        }
        this.f4206w.mo4979a(size > 0);
    }

    /* renamed from: a */
    private void m5272a(C1070el c1070el, int i, boolean z, long j) {
        if (!TextUtils.isEmpty(c1070el.f4272b)) {
            if (z) {
                c1070el.f4234W.setVisibility(0);
                c1070el.f4234W.setOnClickListener(new ViewOnClickListenerC1068ej(this, c1070el));
                if (this.f4204u == EnumC1071em.SELECT_NONE) {
                    c1070el.f4234W.setChecked(false);
                    return;
                }
                if (this.f4204u == EnumC1071em.SELECT_PART) {
                    if (!this.f4200q.isEmpty() && this.f4200q.containsKey(Long.valueOf(c1070el.f4272b))) {
                        c1070el.f4234W.setChecked(true);
                        return;
                    } else {
                        c1070el.f4234W.setChecked(false);
                        return;
                    }
                }
                if (this.f4204u == EnumC1071em.SELECT_PART_AFTER_ALL) {
                    if (!this.f4200q.isEmpty() && this.f4200q.containsKey(Long.valueOf(c1070el.f4272b))) {
                        c1070el.f4234W.setChecked(false);
                        return;
                    } else {
                        c1070el.f4234W.setChecked(true);
                        return;
                    }
                }
                if (this.f4204u == EnumC1071em.SELECT_ALL) {
                    c1070el.f4234W.setChecked(true);
                    return;
                }
                return;
            }
            c1070el.f4219H.setVisibility(0);
            c1070el.f4219H.setOnClickListener(new ViewOnClickListenerC1069ek(this, c1070el));
            if (this.f4204u == EnumC1071em.SELECT_NONE) {
                c1070el.f4219H.setChecked(false);
                return;
            }
            if (this.f4204u == EnumC1071em.SELECT_PART) {
                if (!this.f4202s.isEmpty() && this.f4202s.containsKey(Long.valueOf(c1070el.f4272b))) {
                    c1070el.f4219H.setChecked(true);
                    return;
                } else {
                    c1070el.f4219H.setChecked(false);
                    return;
                }
            }
            if (this.f4204u == EnumC1071em.SELECT_PART_AFTER_ALL) {
                if (!this.f4202s.isEmpty() && this.f4202s.containsKey(Long.valueOf(c1070el.f4272b))) {
                    c1070el.f4219H.setChecked(false);
                    return;
                } else if (j <= this.f4205v) {
                    c1070el.f4219H.setChecked(true);
                    return;
                } else {
                    c1070el.f4219H.setChecked(false);
                    this.f4202s.put(Long.valueOf(c1070el.f4272b), true);
                    return;
                }
            }
            if (this.f4204u == EnumC1071em.SELECT_ALL) {
                c1070el.f4219H.setChecked(true);
            }
        }
    }

    /* renamed from: a */
    private void m5271a(C1070el c1070el) {
        if (TextUtils.isEmpty(this.f4193j) || TextUtils.isEmpty(this.f4195l)) {
            if (C3250y.f11735c) {
                C3250y.m11453c("send or receive bubble ID is empty", f4185b);
            }
        } else {
            c1070el.f4285o.setBackgroundDrawable(m5280j());
            c1070el.f4221J.setBackgroundDrawable(m5281k());
        }
    }

    /* renamed from: j */
    private Drawable m5280j() {
        if (this.f4196m == null) {
            this.f4196m = C2591cd.m9586i(this.f4186c, this.f4195l);
        }
        if (this.f4196m != null) {
            if (C3250y.f11735c) {
                C3250y.m11453c("success to get drawable. Receive bubble ID:" + this.f4195l, f4185b);
            }
            return this.f4196m.getConstantState().newDrawable();
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("Fail to get drawable. Receive bubble ID:" + this.f4195l, f4185b);
        }
        return this.f4186c.getResources().getDrawable(R.drawable.bubble_receive_01_normal);
    }

    /* renamed from: k */
    private Drawable m5281k() {
        if (this.f4194k == null) {
            this.f4194k = C2591cd.m9584g(this.f4186c, this.f4193j);
        }
        if (this.f4194k != null) {
            if (C3250y.f11735c) {
                C3250y.m11453c("success to get drawable. Send bubble ID:" + this.f4193j, f4185b);
            }
            return this.f4194k.getConstantState().newDrawable();
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("Fail to get drawable. Send bubble ID:" + this.f4193j, f4185b);
        }
        return this.f4186c.getResources().getDrawable(R.drawable.bubble_send_01_normal);
    }
}
