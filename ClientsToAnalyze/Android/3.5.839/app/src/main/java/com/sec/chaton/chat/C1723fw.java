package com.sec.chaton.chat;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.p008c.C0083f;
import android.support.v4.widget.C0266z;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.chat.p054a.AbstractC1506a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.audio.C2726b;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.MessageListItem;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;
import com.sec.google.android.p134a.C5111c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.p138a.p139a.p140a.p141a.C5214j;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.fw */
/* loaded from: classes.dex */
public class C1723fw extends C0266z {

    /* renamed from: A */
    private String f6335A;

    /* renamed from: B */
    private Drawable f6336B;

    /* renamed from: C */
    private String f6337C;

    /* renamed from: D */
    private Drawable f6338D;

    /* renamed from: E */
    private float f6339E;

    /* renamed from: F */
    private Typeface f6340F;

    /* renamed from: G */
    private final ArrayList<String> f6341G;

    /* renamed from: H */
    private final HashMap<Long, Boolean> f6342H;

    /* renamed from: I */
    private long f6343I;

    /* renamed from: J */
    private final HashMap<Long, Boolean> f6344J;

    /* renamed from: K */
    private long f6345K;

    /* renamed from: L */
    private EnumC1731gd f6346L;

    /* renamed from: M */
    private long f6347M;

    /* renamed from: N */
    private InterfaceC1773hs f6348N;

    /* renamed from: O */
    private Bitmap f6349O;

    /* renamed from: P */
    private TabActivity f6350P;

    /* renamed from: Q */
    private final HashMap<Long, C4108aq> f6351Q;

    /* renamed from: R */
    private final HashMap<Long, C4108aq> f6352R;

    /* renamed from: S */
    private long f6353S;

    /* renamed from: T */
    private C3790i f6354T;

    /* renamed from: U */
    private final View f6355U;

    /* renamed from: V */
    private final MessageListItem f6356V;

    /* renamed from: W */
    private final C0083f<Long, C4108aq> f6357W;

    /* renamed from: X */
    private Handler f6358X;

    /* renamed from: Y */
    private Handler f6359Y;

    /* renamed from: Z */
    private C1763hi f6360Z;

    /* renamed from: n */
    public EnumC2301u f6361n;

    /* renamed from: o */
    public Cursor f6362o;

    /* renamed from: p */
    public Cursor f6363p;

    /* renamed from: q */
    public final Comparator<C4108aq> f6364q;

    /* renamed from: r */
    long f6365r;

    /* renamed from: t */
    private final Context f6366t;

    /* renamed from: u */
    private final LayoutInflater f6367u;

    /* renamed from: v */
    private ListView f6368v;

    /* renamed from: w */
    private final C5007c f6369w;

    /* renamed from: x */
    private final C5214j<EnumC2214ab, AbstractC1506a> f6370x;

    /* renamed from: y */
    private final EnumC2300t f6371y;

    /* renamed from: z */
    private boolean f6372z;

    /* renamed from: s */
    private static final String f6334s = C1723fw.class.getSimpleName();

    /* renamed from: m */
    public static final String[] f6333m = {"_id"};

    /* renamed from: a */
    public void m8563a(C1763hi c1763hi) {
        this.f6360Z = c1763hi;
    }

    public C1723fw(Context context, ListView listView, Cursor cursor, EnumC2300t enumC2300t, EnumC2301u enumC2301u, Typeface typeface, float f, C5007c c5007c, C5214j<EnumC2214ab, AbstractC1506a> c5214j, SlookAirButton.ItemSelectListener itemSelectListener) {
        super(context, R.layout.item_balloon_skin0, cursor, f6333m, null, 2);
        this.f6346L = EnumC1731gd.SELECT_NONE;
        this.f6349O = null;
        this.f6362o = null;
        this.f6363p = null;
        this.f6355U = null;
        this.f6356V = null;
        this.f6364q = new C1724fx(this);
        this.f6365r = -1L;
        this.f6367u = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6372z = true;
        this.f6366t = context;
        this.f6368v = listView;
        this.f6371y = enumC2300t;
        this.f6361n = enumC2301u;
        this.f6369w = c5007c;
        this.f6370x = c5214j;
        this.f6340F = typeface;
        this.f6339E = f;
        this.f6341G = new ArrayList<>();
        this.f6342H = new HashMap<>();
        this.f6344J = new HashMap<>();
        this.f6351Q = new HashMap<>();
        this.f6352R = new HashMap<>();
        this.f6357W = new C0083f<>(50);
        this.f6335A = C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1");
        this.f6337C = C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1");
        if (C4904y.f17873c) {
            C4904y.m18641c("[constructor] send bubble:" + this.f6335A + " recv bubble:" + this.f6337C, f6334s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Date m8541a(C4108aq c4108aq) {
        long j;
        if (c4108aq.m16312o() || c4108aq.m16311n()) {
            j = c4108aq.f15244C;
        } else {
            j = c4108aq.f15247F;
        }
        return new Date(j);
    }

    /* renamed from: a */
    public void m8558a(long j) {
        this.f6345K = j;
    }

    /* renamed from: b */
    public void m8567b(long j) {
        this.f6343I = j;
    }

    /* renamed from: c */
    public void m8571c(long j) {
        this.f6353S = j;
    }

    /* renamed from: c */
    public HashMap<Long, Boolean> m8570c() {
        return this.f6342H;
    }

    /* renamed from: d */
    public HashMap<Long, Boolean> m8573d() {
        return this.f6344J;
    }

    /* renamed from: e */
    public HashMap<Long, C4108aq> m8575e() {
        return this.f6351Q;
    }

    /* renamed from: f */
    public HashMap<Long, C4108aq> m8577f() {
        return this.f6352R;
    }

    /* renamed from: g */
    public void m8578g() {
        if (this.f6342H != null && !this.f6342H.isEmpty()) {
            this.f6342H.clear();
        }
        if (this.f6344J != null && !this.f6344J.isEmpty()) {
            this.f6344J.clear();
        }
        if (this.f6351Q != null && !this.f6351Q.isEmpty()) {
            this.f6351Q.clear();
        }
    }

    /* renamed from: a */
    public void m8562a(EnumC1731gd enumC1731gd) {
        this.f6346L = enumC1731gd;
    }

    /* renamed from: h */
    public EnumC1731gd m8579h() {
        return this.f6346L;
    }

    /* renamed from: a */
    public void m8564a(InterfaceC1773hs interfaceC1773hs) {
        this.f6348N = interfaceC1773hs;
    }

    /* renamed from: a */
    public void m8566a(boolean z) {
        this.f6372z = z;
    }

    /* renamed from: i */
    public void m8580i() {
        this.f6368v = null;
    }

    /* renamed from: a */
    public void m8559a(Bitmap bitmap) {
        this.f6349O = bitmap;
    }

    /* renamed from: j */
    public void m8581j() {
        this.f6346L = EnumC1731gd.SELECT_NONE;
        m8578g();
    }

    /* renamed from: k */
    public void m8582k() {
        this.f6346L = EnumC1731gd.SELECT_ALL;
        m8578g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m8553l() {
        long j = this.f6345K + this.f6343I + this.f6353S;
        long size = this.f6342H.size() + this.f6344J.size() + this.f6351Q.size();
        if (size == 0) {
            m8581j();
        } else if (j == size) {
            m8582k();
        } else {
            this.f6346L = EnumC1731gd.SELECT_PART;
        }
        this.f6348N.mo8236a(size > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m8554m() {
        long j = this.f6345K + this.f6343I + this.f6353S;
        long size = j - ((this.f6342H.size() + this.f6344J.size()) + this.f6351Q.size());
        if (j == 0) {
            m8581j();
        } else if (j == size) {
            m8582k();
        } else {
            this.f6346L = EnumC1731gd.SELECT_PART_AFTER_ALL;
            Cursor cursorA = mo871a();
            cursorA.moveToLast();
            if (((C1732ge) ((C1776hv) cursorA).m8790a()).f6529a == EnumC1733gf.Sms) {
                C4108aq c4108aqM8576f = m8576f(cursorA);
                if (c4108aqM8576f != null) {
                    this.f6347M = c4108aqM8576f.f15244C;
                }
            } else {
                this.f6347M = cursorA.getLong(cursorA.getColumnIndex("message_time"));
            }
        }
        this.f6348N.mo8236a(size > 0);
    }

    /* renamed from: a */
    private void m8543a(C1729gb c1729gb, boolean z, long j) {
        if (!TextUtils.isEmpty(c1729gb.f6457b)) {
            if (z) {
                c1729gb.f6436af.setVisibility(0);
                c1729gb.f6436af.setOnClickListener(new ViewOnClickListenerC1725fy(this, c1729gb));
                if (this.f6346L == EnumC1731gd.SELECT_NONE) {
                    c1729gb.f6436af.setChecked(false);
                    return;
                }
                if (this.f6346L == EnumC1731gd.SELECT_PART) {
                    if (!this.f6342H.isEmpty() && this.f6342H.containsKey(Long.valueOf(c1729gb.f6457b))) {
                        c1729gb.f6436af.setChecked(true);
                        return;
                    } else {
                        c1729gb.f6436af.setChecked(false);
                        return;
                    }
                }
                if (this.f6346L == EnumC1731gd.SELECT_PART_AFTER_ALL) {
                    if (!this.f6342H.isEmpty() && this.f6342H.containsKey(Long.valueOf(c1729gb.f6457b))) {
                        c1729gb.f6436af.setChecked(false);
                        return;
                    } else {
                        c1729gb.f6436af.setChecked(true);
                        return;
                    }
                }
                if (this.f6346L == EnumC1731gd.SELECT_ALL) {
                    c1729gb.f6436af.setChecked(true);
                    return;
                }
                return;
            }
            c1729gb.f6393K.setVisibility(0);
            c1729gb.f6393K.setOnClickListener(new ViewOnClickListenerC1726fz(this, c1729gb));
            if (this.f6346L == EnumC1731gd.SELECT_NONE) {
                c1729gb.f6393K.setChecked(false);
                return;
            }
            if (this.f6346L == EnumC1731gd.SELECT_PART) {
                if (!this.f6344J.isEmpty() && this.f6344J.containsKey(Long.valueOf(c1729gb.f6457b))) {
                    c1729gb.f6393K.setChecked(true);
                    return;
                } else {
                    c1729gb.f6393K.setChecked(false);
                    return;
                }
            }
            if (this.f6346L == EnumC1731gd.SELECT_PART_AFTER_ALL) {
                if (!this.f6344J.isEmpty() && this.f6344J.containsKey(Long.valueOf(c1729gb.f6457b))) {
                    c1729gb.f6393K.setChecked(false);
                    return;
                } else if (j <= this.f6347M) {
                    c1729gb.f6393K.setChecked(true);
                    return;
                } else {
                    c1729gb.f6393K.setChecked(false);
                    this.f6344J.put(Long.valueOf(c1729gb.f6457b), true);
                    return;
                }
            }
            if (this.f6346L == EnumC1731gd.SELECT_ALL) {
                c1729gb.f6393K.setChecked(true);
            }
        }
    }

    /* renamed from: a */
    private void m8544a(MessageListItem messageListItem, C4108aq c4108aq) {
        messageListItem.setCheckBox(0, false);
        long jM16307j = c4108aq.m16307j();
        messageListItem.m15838m().setOnClickListener(new ViewOnClickListenerC1728ga(this, jM16307j, c4108aq, messageListItem));
        if (this.f6346L == EnumC1731gd.SELECT_NONE) {
            messageListItem.setCheckBox(0, false);
            return;
        }
        if (this.f6346L == EnumC1731gd.SELECT_PART) {
            if (!this.f6351Q.isEmpty() && this.f6351Q.containsKey(Long.valueOf(jM16307j))) {
                messageListItem.setCheckBox(0, true);
                return;
            } else {
                messageListItem.setCheckBox(0, false);
                return;
            }
        }
        if (this.f6346L == EnumC1731gd.SELECT_PART_AFTER_ALL) {
            if (!this.f6351Q.isEmpty() && this.f6351Q.containsKey(Long.valueOf(jM16307j))) {
                messageListItem.setCheckBox(0, false);
                return;
            } else {
                messageListItem.setCheckBox(0, true);
                return;
            }
        }
        if (this.f6346L == EnumC1731gd.SELECT_ALL) {
            messageListItem.setCheckBox(0, true);
        }
    }

    /* renamed from: a */
    public void m8560a(Typeface typeface, float f, String str, String str2) {
        this.f6340F = typeface;
        this.f6339E = f;
        this.f6335A = str;
        this.f6337C = str2;
    }

    /* renamed from: a */
    private void m8542a(C1729gb c1729gb) {
        if (TextUtils.isEmpty(this.f6335A) || TextUtils.isEmpty(this.f6337C)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("send or receive bubble ID is empty", f6334s);
            }
        } else {
            c1729gb.f6470o.setBackgroundDrawable(m8555n());
            c1729gb.f6395M.setBackgroundDrawable(m8556o());
        }
    }

    /* renamed from: n */
    private Drawable m8555n() {
        this.f6338D = C1735gh.m8620b(this.f6337C);
        if (this.f6338D != null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("success to get drawable. Receive bubble ID:" + this.f6337C, f6334s);
            }
            return this.f6338D.getConstantState().newDrawable();
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("Fail to get drawable. Receive bubble ID:" + this.f6337C, f6334s);
        }
        return this.f6366t.getResources().getDrawable(R.drawable.bubble_receive_01_normal);
    }

    /* renamed from: o */
    private Drawable m8556o() {
        this.f6336B = C1735gh.m8612a(this.f6335A);
        if (this.f6336B != null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("success to get drawable. Send bubble ID:" + this.f6335A, f6334s);
            }
            return this.f6336B.getConstantState().newDrawable();
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("Fail to get drawable. Send bubble ID:" + this.f6335A, f6334s);
        }
        return this.f6366t.getResources().getDrawable(R.drawable.bubble_send_01_normal);
    }

    /* renamed from: a */
    public void m8565a(C3790i c3790i) {
        this.f6354T = c3790i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Cursor cursorA = mo871a();
        if (cursorA.moveToPosition(i)) {
            C4108aq c4108aqM8576f = m8576f(cursorA);
            if (c4108aqM8576f == null) {
                C4904y.m18639b("getItemViewType cursor : " + cursorA + ", msgItem :" + c4108aqM8576f, f6334s);
                return super.getItemViewType(i);
            }
            if (c4108aqM8576f.m16312o() || c4108aqM8576f.m16311n()) {
                if (c4108aqM8576f.m16310m()) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.support.v4.widget.AbstractC0259s, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        int position = cursor.getPosition();
        int itemViewType = getItemViewType(position);
        C4108aq c4108aqM8576f = m8576f(cursor);
        if (c4108aqM8576f != null && (c4108aqM8576f.m16312o() || c4108aqM8576f.m16311n())) {
            C4904y.m18639b("newView type : SMS, position : " + position, f6334s);
            if (itemViewType == 1) {
                return (MessageListItem) this.f6367u.inflate(R.layout.message_list_item_recv, viewGroup, false);
            }
            if (itemViewType != 2) {
                return null;
            }
            return (MessageListItem) this.f6367u.inflate(R.layout.message_list_item_send, viewGroup, false);
        }
        C4904y.m18639b("newView type : ChatON, position : " + position, f6334s);
        View viewInflate = this.f6367u.inflate(R.layout.item_balloon_skin0, viewGroup, false);
        C1729gb c1729gb = new C1729gb();
        c1729gb.f6409a = viewInflate;
        c1729gb.f6386D = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutDate);
        c1729gb.f6459d = (TextView) viewInflate.findViewById(R.id.textDate);
        c1729gb.f6459d.setLongClickable(false);
        c1729gb.f6389G = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutInvite);
        c1729gb.f6389G.setVisibility(8);
        c1729gb.f6460e = (TextView) viewInflate.findViewById(R.id.textInvite);
        c1729gb.f6460e.setLongClickable(false);
        c1729gb.f6461f = (TextView) viewInflate.findViewById(R.id.reInvite);
        c1729gb.f6465j = (ViewGroup) viewInflate.findViewById(R.id.parentRcv);
        c1729gb.f6465j.setVisibility(8);
        c1729gb.f6467l = (ImageView) viewInflate.findViewById(R.id.imageProfile);
        c1729gb.f6469n = (ImageView) viewInflate.findViewById(R.id.countryFlag);
        c1729gb.f6466k = (TextView) viewInflate.findViewById(R.id.textName);
        c1729gb.f6387E = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutTime);
        c1729gb.f6388F = (TextView) viewInflate.findViewById(R.id.textRcvTime);
        c1729gb.f6391I = (ProgressBar) viewInflate.findViewById(R.id.DownProgressBalloon);
        c1729gb.f6443am = (Button) viewInflate.findViewById(R.id.download_completed);
        c1729gb.f6390H = (ProgressBar) viewInflate.findViewById(R.id.progressbarDown);
        c1729gb.f6390H.setVisibility(4);
        c1729gb.f6392J = (Button) viewInflate.findViewById(R.id.btnDownCancel);
        c1729gb.f6392J.setVisibility(4);
        c1729gb.f6392J.setTag(viewInflate);
        c1729gb.f6393K = (CheckBox) viewInflate.findViewById(R.id.chkRcvId);
        c1729gb.f6470o = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvContent);
        c1729gb.f6470o.setLongClickable(true);
        c1729gb.f6470o.setTag(viewInflate);
        c1729gb.f6471p = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvText);
        c1729gb.f6472q = (TextView) viewInflate.findViewById(R.id.textRcvContent);
        c1729gb.f6472q.setVisibility(8);
        c1729gb.f6472q.setTypeface(this.f6340F);
        c1729gb.f6472q.setLongClickable(true);
        c1729gb.f6473r = viewInflate.findViewById(R.id.textRcvContentDivider);
        c1729gb.f6473r.setVisibility(8);
        c1729gb.f6474s = (TextView) viewInflate.findViewById(R.id.textRcvContentTranslated);
        c1729gb.f6474s.setTypeface(this.f6340F);
        c1729gb.f6474s.setVisibility(8);
        c1729gb.f6475t = (ImageView) viewInflate.findViewById(R.id.icon_translate);
        c1729gb.f6475t.setVisibility(8);
        c1729gb.f6444an = (LinearLayout) viewInflate.findViewById(R.id.recvLongMessageAddLayout);
        c1729gb.f6446ap = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutRcvLiveText);
        c1729gb.f6446ap.setLongClickable(true);
        c1729gb.f6447aq = (TextView) viewInflate.findViewById(R.id.textRcvLiveContent);
        c1729gb.f6448ar = (TextView) viewInflate.findViewById(R.id.recv_live_body_text);
        c1729gb.f6447aq.setTypeface(this.f6340F);
        c1729gb.f6448ar.setTypeface(this.f6340F);
        c1729gb.f6478w = (FrameLayout) viewInflate.findViewById(R.id.imageRcvContentLayout);
        c1729gb.f6479x = (ImageButton) viewInflate.findViewById(R.id.agif_rcv_play_button);
        c1729gb.f6477v = (ImageView) viewInflate.findViewById(R.id.anicon_icon);
        c1729gb.f6476u = (ImageView) viewInflate.findViewById(R.id.imageRcvContent);
        c1729gb.f6476u.setVisibility(8);
        c1729gb.f6476u.setLongClickable(true);
        c1729gb.f6476u.setTag(viewInflate);
        c1729gb.f6480y = (LinearLayout) viewInflate.findViewById(R.id.lLayoutETC);
        c1729gb.f6480y.setVisibility(8);
        c1729gb.f6480y.setLongClickable(true);
        c1729gb.f6481z = (ImageView) viewInflate.findViewById(R.id.imageEtcContent);
        c1729gb.f6481z.setLongClickable(true);
        c1729gb.f6481z.setTag(viewInflate);
        c1729gb.f6383A = (TextView) viewInflate.findViewById(R.id.textEtcContent);
        c1729gb.f6383A.setTypeface(this.f6340F);
        c1729gb.f6384B = (TextView) viewInflate.findViewById(R.id.textEtcContentTranslated);
        c1729gb.f6384B.setTypeface(this.f6340F);
        c1729gb.f6385C = (ImageView) viewInflate.findViewById(R.id.etc_icon_translate);
        c1729gb.f6385C.setVisibility(8);
        c1729gb.f6442al = (ProgressBar) viewInflate.findViewById(R.id.imageLoadingProgressbar);
        c1729gb.f6463h = (ViewGroup) viewInflate.findViewById(R.id.rSendRoot);
        c1729gb.f6464i = (ViewGroup) this.f6367u.inflate(R.layout.item_balloon_sent, c1729gb.f6463h, true);
        c1729gb.f6464i.setVisibility(8);
        c1729gb.f6468m = (ImageView) c1729gb.f6464i.findViewById(R.id.imageMeProfile);
        c1729gb.f6453aw = (LinearLayout) c1729gb.f6464i.findViewById(R.id.lLayoutSndContent2);
        c1729gb.f6434ad = (LinearLayout) c1729gb.f6464i.findViewById(R.id.lLayoutSndTime);
        c1729gb.f6435ae = (TextView) c1729gb.f6464i.findViewById(R.id.textSndTime);
        c1729gb.f6436af = (CheckBox) c1729gb.f6464i.findViewById(R.id.chkSndId);
        c1729gb.f6394L = (Button) c1729gb.f6464i.findViewById(R.id.btnSendCancel);
        c1729gb.f6438ah = (ProgressBar) c1729gb.f6464i.findViewById(R.id.progressbarUp);
        c1729gb.f6438ah.setVisibility(4);
        c1729gb.f6439ai = (ImageView) c1729gb.f6464i.findViewById(R.id.progressClock);
        c1729gb.f6439ai.setVisibility(4);
        c1729gb.f6440aj = (ImageView) c1729gb.f6464i.findViewById(R.id.btnSendPended);
        c1729gb.f6440aj.setVisibility(4);
        c1729gb.f6462g = (TextView) c1729gb.f6464i.findViewById(R.id.chat_ack);
        c1729gb.f6441ak = (Button) c1729gb.f6464i.findViewById(R.id.btnError);
        c1729gb.f6441ak.setTag(viewInflate);
        c1729gb.f6395M = (LinearLayout) c1729gb.f6464i.findViewById(R.id.lLayoutSndContent);
        c1729gb.f6395M.setLongClickable(true);
        c1729gb.f6395M.setTag(viewInflate);
        c1729gb.f6396N = (LinearLayout) c1729gb.f6464i.findViewById(R.id.lLayoutSndText);
        c1729gb.f6397O = (TextView) c1729gb.f6464i.findViewById(R.id.textSndContent);
        c1729gb.f6397O.setTypeface(this.f6340F);
        c1729gb.f6397O.setVisibility(8);
        c1729gb.f6397O.setLongClickable(true);
        c1729gb.f6398P = c1729gb.f6464i.findViewById(R.id.textSndContentDivider);
        c1729gb.f6398P.setVisibility(8);
        c1729gb.f6399Q = (TextView) c1729gb.f6464i.findViewById(R.id.textSndContentTranslated);
        c1729gb.f6399Q.setTypeface(this.f6340F);
        c1729gb.f6399Q.setVisibility(8);
        c1729gb.f6400R = (ImageView) viewInflate.findViewById(R.id.icon_translate_sent);
        c1729gb.f6400R.setVisibility(8);
        c1729gb.f6445ao = (LinearLayout) viewInflate.findViewById(R.id.sendLongMessageAddLayout);
        c1729gb.f6445ao.setVisibility(8);
        c1729gb.f6445ao.setLongClickable(true);
        c1729gb.f6449as = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutSndLiveText);
        c1729gb.f6449as.setLongClickable(true);
        c1729gb.f6450at = (TextView) viewInflate.findViewById(R.id.textSndLiveContent);
        c1729gb.f6451au = (TextView) viewInflate.findViewById(R.id.send_live_body_text);
        c1729gb.f6450at.setTypeface(this.f6340F);
        c1729gb.f6451au.setTypeface(this.f6340F);
        c1729gb.f6401S = (ImageView) c1729gb.f6464i.findViewById(R.id.imageSndContent);
        c1729gb.f6401S.setVisibility(8);
        c1729gb.f6401S.setLongClickable(true);
        c1729gb.f6402T = (FrameLayout) c1729gb.f6464i.findViewById(R.id.imageSndContentLayout);
        c1729gb.f6403U = (ImageButton) c1729gb.f6464i.findViewById(R.id.agif_snd_play_button);
        c1729gb.f6437ag = (ProgressBar) c1729gb.f6464i.findViewById(R.id.sendImageLoadingProgressbar);
        c1729gb.f6404V = (ImageView) c1729gb.f6464i.findViewById(R.id.imageSndAniContent);
        c1729gb.f6404V.setVisibility(8);
        c1729gb.f6404V.setLongClickable(true);
        c1729gb.f6405W = (FrameLayout) c1729gb.f6464i.findViewById(R.id.imageSndAniContentLayout);
        c1729gb.f6406X = (ImageView) c1729gb.f6464i.findViewById(R.id.anicon_icon);
        c1729gb.f6407Y = (LinearLayout) c1729gb.f6464i.findViewById(R.id.lLayoutSndETC);
        c1729gb.f6407Y.setVisibility(8);
        c1729gb.f6407Y.setLongClickable(true);
        c1729gb.f6408Z = (ImageView) c1729gb.f6464i.findViewById(R.id.imageEtcSndContent);
        c1729gb.f6408Z.setLongClickable(true);
        c1729gb.f6408Z.setTag(viewInflate);
        c1729gb.f6431aa = (TextView) c1729gb.f6464i.findViewById(R.id.textEtcSndContent);
        c1729gb.f6431aa.setTypeface(this.f6340F);
        c1729gb.f6432ab = (TextView) c1729gb.f6464i.findViewById(R.id.textEtcSndContentTranslated);
        c1729gb.f6432ab.setTypeface(this.f6340F);
        c1729gb.f6433ac = (ImageView) viewInflate.findViewById(R.id.etc_icon_translate_sent);
        c1729gb.f6433ac.setVisibility(8);
        c1729gb.f6452av = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvContent2);
        c1729gb.f6454ax = (RelativeLayout) viewInflate.findViewById(R.id.sendAppLinkLayout);
        c1729gb.f6455ay = (TextView) viewInflate.findViewById(R.id.appLinkSndText);
        c1729gb.f6456az = (LinearLayout) viewInflate.findViewById(R.id.sendAppLinkConnectLayout);
        c1729gb.f6410aA = (TextView) viewInflate.findViewById(R.id.appLinkSndConnectText);
        c1729gb.f6411aB = (ImageView) viewInflate.findViewById(R.id.appLinkSndConnectIcon);
        c1729gb.f6412aC = (ProgressBar) viewInflate.findViewById(R.id.hugeFileSndProgress);
        c1729gb.f6413aD = (ImageView) viewInflate.findViewById(R.id.appLinkSendTitleIcon);
        c1729gb.f6455ay.setTypeface(this.f6340F);
        c1729gb.f6410aA.setTypeface(this.f6340F);
        c1729gb.f6414aE = (RelativeLayout) viewInflate.findViewById(R.id.rcvAppLinkLayout);
        c1729gb.f6415aF = (TextView) viewInflate.findViewById(R.id.appLinkRcvText);
        c1729gb.f6416aG = (RelativeLayout) viewInflate.findViewById(R.id.rcvAppLinkConnectLayout);
        c1729gb.f6417aH = (TextView) viewInflate.findViewById(R.id.appLinkRcvConnectText);
        c1729gb.f6418aI = (ImageView) viewInflate.findViewById(R.id.appLinkRcvConnectIcon);
        c1729gb.f6419aJ = (ImageView) viewInflate.findViewById(R.id.appLinkRcvTitleIcon);
        c1729gb.f6415aF.setTypeface(this.f6340F);
        c1729gb.f6417aH.setTypeface(this.f6340F);
        m8542a(c1729gb);
        viewInflate.setTag(c1729gb);
        return viewInflate;
    }

    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        C1732ge c1732ge = (C1732ge) ((C1776hv) cursor).m8790a();
        if (c1732ge.f6529a == EnumC1733gf.Sms) {
            m8546c(view, context, cursor);
            C4904y.m18639b("bindView type : SMS", f6334s);
        }
        if (c1732ge.f6529a == EnumC1733gf.chat) {
            m8569b(view, context, cursor);
            C4904y.m18639b("bindView type : ChatON", f6334s);
        }
    }

    /* renamed from: c */
    private void m8546c(View view, Context context, Cursor cursor) {
        C4108aq c4108aqM8576f = m8576f(cursor);
        if (c4108aqM8576f != null) {
            if (c4108aqM8576f.m16307j() == this.f6360Z.m8772b() && this.f6360Z != null) {
                this.f6360Z.m8776e();
            }
            MessageListItem messageListItem = null;
            if (view == null) {
                messageListItem = (MessageListItem) this.f6367u.inflate(c4108aqM8576f.m16310m() ? R.layout.message_list_item_recv : R.layout.message_list_item_send, (ViewGroup) view, false);
            }
            if ((messageListItem != null || (view instanceof MessageListItem)) && c4108aqM8576f != null) {
                MessageListItem messageListItem2 = view != null ? (MessageListItem) view : messageListItem;
                if (!c4108aqM8576f.m16310m()) {
                    LinearLayout linearLayout = (LinearLayout) messageListItem2.findViewById(R.id.layout_invitation_guide_stamp);
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    LinearLayout linearLayout2 = (LinearLayout) messageListItem2.findViewById(R.id.layout_invitation_for_freesms_stamp);
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                }
                if (c4108aqM8576f.f15277l == null) {
                    messageListItem2.setBodyTextViewVisibility(false);
                } else {
                    messageListItem2.setBodyTextViewVisibility(true);
                }
                messageListItem2.m15832a(c4108aqM8576f, false, false);
                messageListItem2.m15830a(cursor, c4108aqM8576f);
                messageListItem2.setMsgListItemHandler(this.f6358X);
                if (this.f6368v.getChoiceMode() == 2) {
                    m8544a(messageListItem2, c4108aqM8576f);
                } else {
                    messageListItem2.setCheckBox(8, false);
                }
                this.f6352R.put(Long.valueOf(c4108aqM8576f.m16307j()), c4108aqM8576f);
            }
        }
    }

    /* renamed from: b */
    public void m8569b(View view, Context context, Cursor cursor) {
        AbstractC1506a abstractC1506a;
        C1729gb c1729gb = (C1729gb) view.getTag();
        if (c1729gb != null) {
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            if (j == this.f6360Z.m8768a()) {
                this.f6360Z.m8775d();
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            long j3 = c1729gb.f6458c;
            c1729gb.f6458c = j2;
            Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
            String string = cursor.getString(cursor.getColumnIndex("message_sender"));
            EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            int i = cursor.getInt(cursor.getColumnIndex("message_type"));
            boolean z = true;
            if (!C4809aa.m18104a().m18121a("chaton_id", "").equals(string)) {
                z = false;
            }
            if (z) {
                c1729gb.f6457b = String.valueOf(j);
            } else {
                c1729gb.f6457b = String.valueOf(j2);
            }
            if (enumC2214abM10070a != EnumC2214ab.SYSTEM && i != 0 && i != 3 && this.f6368v.getChoiceMode() == 2) {
                m8543a(c1729gb, z, lValueOf.longValue());
            } else {
                c1729gb.f6393K.setVisibility(8);
                c1729gb.f6436af.setVisibility(8);
                this.f6341G.clear();
            }
            if (this.f6349O != null) {
                c1729gb.f6469n.setImageDrawable(new BitmapDrawable(this.f6366t.getResources(), this.f6349O));
                c1729gb.f6469n.setVisibility(0);
            } else {
                c1729gb.f6469n.setImageDrawable(null);
                c1729gb.f6469n.setVisibility(8);
            }
            AbstractC1506a abstractC1506aM19866b = null;
            try {
                if (c1729gb.f6421aL != null) {
                    if (c1729gb.f6420aK == enumC2214abM10070a) {
                        abstractC1506aM19866b = c1729gb.f6421aL;
                        if (j3 != j2) {
                            abstractC1506aM19866b.mo8361a(false);
                        } else {
                            abstractC1506aM19866b.mo8361a(true);
                        }
                    } else {
                        this.f6370x.m19865a((C5214j<EnumC2214ab, AbstractC1506a>) c1729gb.f6420aK, (EnumC2214ab) c1729gb.f6421aL);
                    }
                }
                if (abstractC1506aM19866b == null) {
                    abstractC1506aM19866b = this.f6370x.m19866b((C5214j<EnumC2214ab, AbstractC1506a>) enumC2214abM10070a);
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("NumActive: " + this.f6370x.mo19815b() + ", NumIdle: " + this.f6370x.mo19813a(), f6334s);
                }
                c1729gb.f6420aK = enumC2214abM10070a;
                c1729gb.f6421aL = abstractC1506aM19866b;
                abstractC1506a = abstractC1506aM19866b;
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f6334s);
                }
                abstractC1506a = abstractC1506aM19866b;
            }
            if (abstractC1506a != null) {
                try {
                    if (GlobalApplication.m10286e()) {
                        abstractC1506a.m8358a(this.f6350P.m3095m());
                    }
                    abstractC1506a.m8360a(this.f6348N);
                    abstractC1506a.m8359a(this.f6366t, this.f6371y, view, cursor, c1729gb, this.f6372z, this.f6369w, this.f6339E, this.f6361n);
                } catch (Exception e2) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, f6334s);
                    }
                }
            }
            C2726b.m11429a().m11435a(j2 == 0 ? j : j2, view);
        }
    }

    /* renamed from: d */
    public Cursor m8572d(Cursor cursor) {
        if (cursor == this.f6362o) {
            return null;
        }
        Cursor cursor2 = this.f6362o;
        this.f6362o = cursor;
        if (this.f6362o != null && this.f6362o.moveToFirst()) {
            this.f6360Z.m8770a(this.f6362o.getLong(this.f6362o.getColumnIndex("_id")));
        }
        if (this.f6363p != null && this.f6362o != null) {
            if (!this.f6363p.isClosed() && !this.f6362o.isClosed()) {
                mo877b(new C1776hv(new Cursor[]{new C1732ge(this.f6362o, EnumC1733gf.chat), new C1732ge(this.f6363p, EnumC1733gf.Sms)}, new String[]{"message_time", "normalized_date"}));
            } else {
                return cursor2;
            }
        } else if (this.f6362o == null || !this.f6362o.isClosed()) {
            mo877b(new C1776hv(new Cursor[]{new C1732ge(this.f6362o, EnumC1733gf.chat)}, new String[]{"message_time"}));
        } else {
            return cursor2;
        }
        notifyDataSetChanged();
        return cursor2;
    }

    /* renamed from: e */
    public Cursor m8574e(Cursor cursor) {
        if (cursor == this.f6363p) {
            return null;
        }
        Cursor cursor2 = this.f6363p;
        this.f6363p = cursor;
        if (this.f6363p != null && this.f6363p.moveToFirst()) {
            C4108aq c4108aqM8576f = m8576f(this.f6363p);
            if (this.f6360Z != null && c4108aqM8576f != null) {
                this.f6360Z.m8773b(c4108aqM8576f.m16307j());
            }
        }
        mo877b((Cursor) null);
        if (this.f6363p != null && this.f6362o != null) {
            if (this.f6363p.isClosed() || this.f6362o.isClosed()) {
                return cursor2;
            }
            mo877b(new C1776hv(new Cursor[]{new C1732ge(this.f6362o, EnumC1733gf.chat), new C1732ge(this.f6363p, EnumC1733gf.Sms)}, new String[]{"message_time", "normalized_date"}));
        } else if (this.f6363p == null && this.f6362o != null) {
            if (this.f6362o.isClosed()) {
                return cursor2;
            }
            mo877b(new C1776hv(new Cursor[]{new C1732ge(this.f6362o, EnumC1733gf.chat)}, new String[]{"message_time"}));
        } else if (this.f6363p != null && this.f6363p.isClosed()) {
            return cursor2;
        }
        notifyDataSetChanged();
        return cursor2;
    }

    /* renamed from: a */
    private long m8537a(String str, long j) {
        if (str.equals("mms")) {
            return -j;
        }
        return j;
    }

    /* renamed from: g */
    private boolean m8552g(Cursor cursor) {
        return (cursor.isClosed() || cursor.isBeforeFirst() || cursor.isAfterLast()) ? false : true;
    }

    /* renamed from: a */
    protected C4108aq m8557a(String str, long j, Cursor cursor) {
        return m8539a(str, j, cursor, new C1730gc(cursor));
    }

    /* renamed from: a */
    private C4108aq m8539a(String str, long j, Cursor cursor, C1730gc c1730gc) {
        C4108aq c4108aq;
        int i = 0;
        C4108aq c4108aqM265a = this.f6357W.m265a((C0083f<Long, C4108aq>) Long.valueOf(m8537a(str, j)));
        if (c4108aqM265a == null && cursor != null && m8552g(cursor)) {
            try {
                if (str.equals("sms")) {
                    i = 1;
                } else if (str.equals("mms")) {
                    i = 2;
                }
                c4108aq = new C4108aq(this.f6366t, cursor, c1730gc, i, (Pattern) null, false);
            } catch (C5111c e) {
                e = e;
            }
            try {
                this.f6357W.m266a(Long.valueOf(m8537a(c4108aq.f15267b, c4108aq.f15268c)), c4108aq);
                return c4108aq;
            } catch (C5111c e2) {
                c4108aqM265a = c4108aq;
                e = e2;
                e.printStackTrace();
                return c4108aqM265a;
            }
        }
        return c4108aqM265a;
    }

    /* renamed from: f */
    public C4108aq m8576f(Cursor cursor) {
        C4108aq c4108aq;
        try {
            if (cursor.getColumnIndex("buddy_no") == -1) {
                C1730gc c1730gc = new C1730gc(cursor);
                c4108aq = m8539a(cursor.getString(c1730gc.f6497a), cursor.getLong(c1730gc.f6498b), cursor, c1730gc);
            } else {
                c4108aq = new C4108aq(this.f6366t, cursor, new C1730gc(cursor), 0, (Pattern) null, false);
            }
            return c4108aq;
        } catch (C5111c e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f6357W.m267a();
    }

    /* renamed from: a */
    public void m8561a(Handler handler) {
        this.f6358X = handler;
    }

    /* renamed from: b */
    public void m8568b(Handler handler) {
        this.f6359Y = handler;
    }
}
