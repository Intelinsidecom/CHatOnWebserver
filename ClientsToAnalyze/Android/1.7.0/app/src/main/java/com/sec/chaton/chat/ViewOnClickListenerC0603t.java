package com.sec.chaton.chat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.audio.PlayAudio;
import com.sec.chaton.multimedia.image.C0810c;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.p034a.C0760c;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p013a.p014a.AsyncTaskC0140ap;
import com.sec.chaton.p018c.p019a.AsyncTaskC0466c;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.p018c.p019a.C0473j;
import com.sec.chaton.p018c.p019a.RunnableC0474k;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1301ax;
import com.sec.chaton.util.C1302ay;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.util.EnumC1310bf;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.p007b.p008a.p011c.C0119d;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C1619g;
import java.io.File;
import java.lang.Character;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.t */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0603t extends SimpleCursorAdapter implements View.OnClickListener {

    /* renamed from: p */
    public static final String[] f2045p = {"_id", "message_inbox_no", "message_sever_id", "message_session_id", "message_read_status", "message_time", "message_content", "message_translated", "message_type", "message_sender", "message_is_failed", "buddy_name", "buddy_profile_status"};

    /* renamed from: A */
    private int f2046A;

    /* renamed from: B */
    private int f2047B;

    /* renamed from: C */
    private HashMap f2048C;

    /* renamed from: D */
    private HashMap f2049D;

    /* renamed from: E */
    private long f2050E;

    /* renamed from: F */
    private long f2051F;

    /* renamed from: G */
    private int f2052G;

    /* renamed from: H */
    private int f2053H;

    /* renamed from: I */
    private EnumC0542ar f2054I;

    /* renamed from: J */
    private EnumC0542ar f2055J;

    /* renamed from: K */
    private EnumC0542ar f2056K;

    /* renamed from: L */
    private ViewGroup.MarginLayoutParams f2057L;

    /* renamed from: M */
    private ViewGroup.MarginLayoutParams f2058M;

    /* renamed from: N */
    private ViewGroup.MarginLayoutParams f2059N;

    /* renamed from: O */
    private ViewGroup.MarginLayoutParams f2060O;

    /* renamed from: P */
    private C0119d f2061P;

    /* renamed from: a */
    String f2062a;

    /* renamed from: b */
    String f2063b;

    /* renamed from: c */
    String f2064c;

    /* renamed from: d */
    String[] f2065d;

    /* renamed from: e */
    String f2066e;

    /* renamed from: f */
    String f2067f;

    /* renamed from: g */
    String f2068g;

    /* renamed from: h */
    String f2069h;

    /* renamed from: i */
    String f2070i;

    /* renamed from: j */
    String f2071j;

    /* renamed from: k */
    String f2072k;

    /* renamed from: l */
    public ArrayList f2073l;

    /* renamed from: m */
    Float f2074m;

    /* renamed from: n */
    int f2075n;

    /* renamed from: o */
    int f2076o;

    /* renamed from: q */
    private LayoutInflater f2077q;

    /* renamed from: r */
    private Context f2078r;

    /* renamed from: s */
    private EnumC0665r f2079s;

    /* renamed from: t */
    private ListView f2080t;

    /* renamed from: u */
    private String f2081u;

    /* renamed from: v */
    private String f2082v;

    /* renamed from: w */
    private String f2083w;

    /* renamed from: x */
    private boolean f2084x;

    /* renamed from: y */
    private InterfaceC0532ah f2085y;

    /* renamed from: z */
    private Button f2086z;

    /* renamed from: a */
    public boolean m2819a(String str) {
        for (char c : str.toCharArray()) {
            if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN) {
                return false;
            }
        }
        return true;
    }

    public ViewOnClickListenerC0603t(Context context, ListView listView, int i, Cursor cursor, EnumC0665r enumC0665r, ArrayList arrayList, Button button, int i2, int i3, C0119d c0119d) {
        super(context, i, cursor, f2045p, null, 2);
        this.f2062a = "";
        this.f2063b = "";
        this.f2064c = "";
        this.f2066e = "///mnt/sdcard/ChatON/";
        this.f2067f = "/mnt/sdcard/ChatON/audio/";
        this.f2068g = "/mnt/sdcard/ChatON/contact/";
        this.f2069h = "/mnt/sdcard/ChatON/geo/";
        this.f2070i = "/mnt/sdcard/ChatON/calendar/";
        this.f2071j = "/mnt/sdcard/ChatON/video/";
        this.f2072k = "/mnt/sdcard/ChatON/downloads/";
        this.f2073l = new ArrayList();
        this.f2074m = Float.valueOf(0.0f);
        this.f2075n = 0;
        this.f2076o = 0;
        this.f2084x = true;
        this.f2054I = EnumC0542ar.SELECT_NONE;
        this.f2055J = EnumC0542ar.SELECT_NONE;
        this.f2056K = EnumC0542ar.SELECT_NONE;
        this.f2086z = button;
        this.f2080t = listView;
        this.f2078r = context;
        this.f2079s = enumC0665r;
        this.f2061P = c0119d;
        this.f2077q = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2083w = C1323bs.m4575a().getString("Default Font Size", "");
        this.f2081u = C1323bs.m4575a().getString("setting_change_bubble_send", "");
        this.f2082v = C1323bs.m4575a().getString("setting_change_bubble_receive", "");
        this.f2048C = new HashMap();
        this.f2049D = new HashMap();
        this.f2052G = i2;
        this.f2053H = i3;
        if ("size50".equals(this.f2083w)) {
            this.f2074m = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_tiny));
            this.f2075n = 14;
            this.f2076o = 22;
            return;
        }
        if ("size70".equals(this.f2083w)) {
            this.f2074m = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_small));
            this.f2075n = 10;
            this.f2076o = 16;
            return;
        }
        if ("size100".equals(this.f2083w)) {
            this.f2074m = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_normal));
            this.f2075n = 4;
            this.f2076o = 10;
        } else if ("size150".equals(this.f2083w)) {
            this.f2074m = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_large));
            this.f2075n = 4;
            this.f2076o = 10;
        } else if ("size200".equals(this.f2083w)) {
            this.f2074m = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_huge));
            this.f2075n = 4;
            this.f2076o = 10;
        } else {
            this.f2074m = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_normal));
            this.f2075n = 4;
            this.f2076o = 10;
        }
    }

    /* renamed from: a */
    public void m2813a() {
        this.f2080t = null;
    }

    /* renamed from: a */
    public void m2814a(long j) {
        this.f2051F = j;
    }

    /* renamed from: b */
    public void m2822b(long j) {
        this.f2050E = j;
    }

    /* renamed from: b */
    public HashMap m2821b() {
        return this.f2048C;
    }

    /* renamed from: c */
    public HashMap m2824c() {
        return this.f2049D;
    }

    /* renamed from: a */
    public Boolean m2812a(Long l, Boolean bool) {
        if (this.f2048C == null) {
            return null;
        }
        return (Boolean) this.f2048C.put(l, bool);
    }

    /* renamed from: b */
    public Boolean m2820b(Long l, Boolean bool) {
        if (this.f2049D == null) {
            return null;
        }
        return (Boolean) this.f2049D.put(l, bool);
    }

    /* renamed from: d */
    public void m2826d() {
        if (this.f2048C != null && !this.f2048C.isEmpty()) {
            this.f2048C.clear();
        }
        if (this.f2049D != null && !this.f2049D.isEmpty()) {
            this.f2049D.clear();
        }
    }

    /* renamed from: a */
    public void m2817a(EnumC0542ar enumC0542ar) {
        this.f2054I = enumC0542ar;
    }

    /* renamed from: e */
    public EnumC0542ar m2827e() {
        return this.f2054I;
    }

    /* renamed from: b */
    public void m2823b(EnumC0542ar enumC0542ar) {
        this.f2055J = enumC0542ar;
    }

    /* renamed from: f */
    public EnumC0542ar m2828f() {
        return this.f2055J;
    }

    /* renamed from: c */
    public void m2825c(EnumC0542ar enumC0542ar) {
        this.f2056K = enumC0542ar;
    }

    /* renamed from: g */
    public EnumC0542ar m2829g() {
        return this.f2056K;
    }

    /* renamed from: a */
    public void m2816a(InterfaceC0532ah interfaceC0532ah) {
        this.f2085y = interfaceC0532ah;
    }

    /* renamed from: a */
    public void m2818a(boolean z) {
        this.f2084x = z;
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f2077q.inflate(R.layout.item_balloon_skin0, viewGroup, false);
        C0606w c0606w = new C0606w();
        c0606w.f2115b = (TextView) viewInflate.findViewById(R.id.textDate);
        c0606w.f2116c = (TextView) viewInflate.findViewById(R.id.textInvite);
        c0606w.f2120g = (ViewGroup) viewInflate.findViewById(R.id.parentRcv);
        c0606w.f2120g.setOnClickListener(this);
        c0606w.f2122i = (ImageView) viewInflate.findViewById(R.id.imageProfile);
        c0606w.f2121h = (TextView) viewInflate.findViewById(R.id.textName);
        c0606w.f2123j = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvContent);
        c0606w.f2123j.setOnLongClickListener(null);
        c0606w.f2123j.setOnClickListener(this);
        c0606w.f2123j.setTag(viewInflate);
        c0606w.f2124k = (TextView) viewInflate.findViewById(R.id.textRcvContent);
        c0606w.f2127n = (ImageView) viewInflate.findViewById(R.id.imageRcvContent);
        c0606w.f2128o = (LinearLayout) viewInflate.findViewById(R.id.bubbleLayout_R);
        c0606w.f2129p = (TextView) viewInflate.findViewById(R.id.spaceText_R);
        c0606w.f2130q = (LinearLayout) viewInflate.findViewById(R.id.bubbleLayout_RE);
        c0606w.f2127n.setTag(viewInflate);
        c0606w.f2127n.setOnLongClickListener(null);
        c0606w.f2131r = (LinearLayout) viewInflate.findViewById(R.id.lLayoutETC);
        c0606w.f2132s = (ImageView) viewInflate.findViewById(R.id.imageEtcContent);
        c0606w.f2132s.setTag(viewInflate);
        c0606w.f2132s.setOnLongClickListener(null);
        c0606w.f2133t = (TextView) viewInflate.findViewById(R.id.textEtcContent);
        c0606w.f2134u = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutDate);
        c0606w.f2125l = (TextView) viewInflate.findViewById(R.id.textRcvTranslated);
        c0606w.f2126m = (ImageView) viewInflate.findViewById(R.id.imageRcvTranIcon);
        c0606w.f2135v = (TextView) viewInflate.findViewById(R.id.textRcvTime);
        c0606w.f2136w = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutInvite);
        c0606w.f2137x = (ProgressBar) viewInflate.findViewById(R.id.progressbarDown);
        c0606w.f2137x.setVisibility(4);
        c0606w.f2137x.setMax(100);
        c0606w.f2139z = (Button) viewInflate.findViewById(R.id.btnDownCancel);
        c0606w.f2139z.setVisibility(4);
        c0606w.f2089A = (CheckBox) viewInflate.findViewById(R.id.chkRcvId);
        c0606w.f2090B = (CheckBox) viewInflate.findViewById(R.id.DateRcvId);
        c0606w.f2138y = (ProgressBar) viewInflate.findViewById(R.id.DownProgressBalloon);
        c0606w.f2118e = (ViewGroup) viewInflate.findViewById(R.id.rSendRoot);
        c0606w.f2119f = (RelativeLayout) this.f2077q.inflate(R.layout.item_balloon_sent, c0606w.f2118e, true);
        c0606w.f2119f.setOnClickListener(this);
        c0606w.f2112X = (ProgressBar) viewInflate.findViewById(R.id.imageLoadingProgressbar);
        c0606w.f2092D = (LinearLayout) c0606w.f2119f.findViewById(R.id.lLayoutSndContent);
        c0606w.f2092D.setOnLongClickListener(null);
        c0606w.f2092D.setOnClickListener(this);
        c0606w.f2092D.setTag(viewInflate);
        c0606w.f2093E = (TextView) c0606w.f2119f.findViewById(R.id.textSndContent);
        c0606w.f2095G = (TextView) c0606w.f2119f.findViewById(R.id.textSndTranslated);
        c0606w.f2094F = (ImageView) c0606w.f2119f.findViewById(R.id.imageSndTranIcon);
        c0606w.f2096H = (ImageView) c0606w.f2119f.findViewById(R.id.imageSndContent);
        c0606w.f2096H.setOnLongClickListener(null);
        c0606w.f2097I = (LinearLayout) c0606w.f2119f.findViewById(R.id.lLayoutSndETC);
        c0606w.f2098J = (ImageView) c0606w.f2119f.findViewById(R.id.imageEtcSndContent);
        c0606w.f2098J.setOnLongClickListener(null);
        c0606w.f2099K = (TextView) c0606w.f2119f.findViewById(R.id.textEtcSndContent);
        c0606w.f2100L = (TextView) c0606w.f2119f.findViewById(R.id.textSndTime);
        c0606w.f2101M = (TextView) c0606w.f2119f.findViewById(R.id.textSndStatus);
        c0606w.f2102N = (CheckBox) c0606w.f2119f.findViewById(R.id.chkSndId);
        c0606w.f2103O = (TextView) c0606w.f2119f.findViewById(R.id.spaceText);
        c0606w.f2104P = (LinearLayout) c0606w.f2119f.findViewById(R.id.bubbleLayout);
        c0606w.f2105Q = (LinearLayout) c0606w.f2119f.findViewById(R.id.bubbleLayout_E);
        c0606w.f2091C = (Button) c0606w.f2119f.findViewById(R.id.btnSendCancel);
        c0606w.f2106R = (ImageView) c0606w.f2119f.findViewById(R.id.imgEnvelop);
        c0606w.f2107S = (TextView) c0606w.f2119f.findViewById(R.id.txtUnread);
        c0606w.f2108T = (ProgressBar) c0606w.f2119f.findViewById(R.id.progressBalloon);
        c0606w.f2108T.setVisibility(4);
        c0606w.f2109U = (ImageButton) c0606w.f2119f.findViewById(R.id.imageAlert);
        c0606w.f2110V = (ProgressBar) c0606w.f2119f.findViewById(R.id.progressbarUp);
        c0606w.f2110V.setVisibility(4);
        c0606w.f2110V.setMax(100);
        c0606w.f2117d = (TextView) c0606w.f2119f.findViewById(R.id.chat_ack);
        c0606w.f2111W = (Button) c0606w.f2119f.findViewById(R.id.btnError);
        c0606w.f2111W.setTag(viewInflate);
        c0606w.f2113Y = (Button) viewInflate.findViewById(R.id.download_completed);
        this.f2057L = new ViewGroup.MarginLayoutParams(c0606w.f2104P.getLayoutParams());
        this.f2058M = new ViewGroup.MarginLayoutParams(c0606w.f2093E.getLayoutParams());
        this.f2059N = new ViewGroup.MarginLayoutParams(c0606w.f2128o.getLayoutParams());
        this.f2060O = new ViewGroup.MarginLayoutParams(c0606w.f2124k.getLayoutParams());
        C1341p.m4659c("changeBubbleSend:" + this.f2081u + ", changeBubbleReceive:" + this.f2082v);
        if (!"bubble_01".equals(this.f2081u)) {
            if ("bubble_02".equals(this.f2081u)) {
                c0606w.f2092D.setBackgroundResource(R.drawable.message_bubble_sent2);
            } else if ("bubble_03".equals(this.f2081u)) {
                c0606w.f2092D.setBackgroundResource(R.drawable.message_bubble_sent3);
            } else if ("bubble_04".equals(this.f2081u)) {
                c0606w.f2092D.setBackgroundResource(R.drawable.message_bubble_sent4);
            } else if ("bubble_05".equals(this.f2081u)) {
                c0606w.f2092D.setBackgroundResource(R.drawable.message_bubble_sent5);
            } else if ("bubble_06".equals(this.f2081u)) {
                c0606w.f2092D.setBackgroundResource(R.drawable.message_bubble_sent6);
            }
        }
        if (!"bubble_01".equals(this.f2082v)) {
            if ("bubble_02".equals(this.f2082v)) {
                c0606w.f2123j.setBackgroundResource(R.drawable.message_bubble_receive2);
            } else if ("bubble_03".equals(this.f2082v)) {
                c0606w.f2123j.setBackgroundResource(R.drawable.message_bubble_receive3);
            } else if ("bubble_04".equals(this.f2082v)) {
                c0606w.f2123j.setBackgroundResource(R.drawable.message_bubble_receive4);
            } else if ("bubble_05".equals(this.f2082v)) {
                c0606w.f2123j.setBackgroundResource(R.drawable.message_bubble_receive5);
            } else if ("bubble_06".equals(this.f2082v)) {
                c0606w.f2123j.setBackgroundResource(R.drawable.message_bubble_receive6);
            }
        }
        viewInflate.setTag(c0606w);
        return viewInflate;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        C0606w c0606w = (C0606w) view.getTag();
        int position = cursor.getPosition();
        int i = this.f2078r.getResources().getDisplayMetrics().widthPixels;
        this.f2046A = (int) (i * 0.75d);
        this.f2047B = (int) (i * 0.6d);
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("message_sever_id"));
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string4 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        int i2 = cursor.getInt(cursor.getColumnIndex("message_read_status"));
        int i3 = cursor.getInt(cursor.getColumnIndex("message_type"));
        String string5 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        int i4 = cursor.getInt(cursor.getColumnIndex("buddy_profile_status"));
        String string7 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        String string8 = cursor.getString(cursor.getColumnIndex("message_formatted"));
        int i5 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
        int i6 = cursor.getInt(cursor.getColumnIndex("message_stored_ext"));
        String string9 = TextUtils.isEmpty(string6) ? GlobalApplication.m3106g().getString(R.string.unknown) : string6;
        String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
        if (cursor.getCount() > 1) {
            if (cursor.getPosition() != 0) {
                cursor.moveToPosition(cursor.getPosition() - 1);
            } else {
                cursor.moveToPosition(cursor.getPosition() + 1);
            }
            this.f2065d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")))).split(" ");
        }
        if (strArrSplit.length == 2) {
            this.f2062a = strArrSplit[0];
            this.f2063b = strArrSplit[1];
        }
        if (i5 == 0 && i3 != 0 && !string4.equals(string3)) {
            m2787a(c0606w.f2115b, position, this.f2065d, string4, c0606w.f2090B, this.f2062a, lValueOf.longValue(), c0606w.f2134u);
            z = true;
        } else {
            c0606w.f2134u.setVisibility(8);
            c0606w.f2090B.setVisibility(8);
            z = false;
        }
        if (C1323bs.m4575a().getString("msisdn", "").equals(string3)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            c0606w.f2114a = String.valueOf(j);
        } else {
            c0606w.f2114a = string;
        }
        if (i3 != 0 && i3 != 3 && this.f2080t.getChoiceMode() == 2) {
            m2790a(c0606w, position, z2, this.f2062a);
        } else {
            c0606w.f2089A.setVisibility(8);
            c0606w.f2090B.setVisibility(8);
            c0606w.f2102N.setVisibility(8);
            this.f2073l.clear();
        }
        if (enumC0651dM2976a != EnumC0651d.SYSTEM) {
            c0606w.f2136w.setVisibility(8);
            if (z2) {
                c0606w.f2119f.setVisibility(0);
                c0606w.f2120g.setVisibility(8);
                c0606w.f2106R.setVisibility(8);
                c0606w.f2107S.setVisibility(8);
                m2789a(c0606w, cursor.getPosition(), lValueOf);
                if (i3 == 0) {
                    c0606w.f2117d.setVisibility(4);
                    c0606w.f2111W.setVisibility(8);
                    if (enumC0651dM2976a != EnumC0651d.TEXT && enumC0651dM2976a != EnumC0651d.GEO) {
                        RunnableC0474k runnableC0474kM2390a = C0468e.m2389a().m2390a(j);
                        if (runnableC0474kM2390a != null) {
                            c0606w.f2110V.setVisibility(0);
                            ProgressBar progressBar = c0606w.f2110V;
                            runnableC0474kM2390a.m2424a(new HandlerC0534aj(this, progressBar));
                            progressBar.setProgress(runnableC0474kM2390a.m2432h());
                            c0606w.f2108T.setVisibility(8);
                            c0606w.f2091C.setVisibility(0);
                        } else {
                            c0606w.f2110V.setVisibility(8);
                            if (i5 == 1 || i5 == 3) {
                                c0606w.f2108T.setVisibility(0);
                            } else {
                                c0606w.f2108T.setVisibility(8);
                            }
                            c0606w.f2091C.setVisibility(8);
                        }
                        c0606w.f2091C.setOnClickListener(new ViewOnClickListenerC0583bw(this, j, enumC0651dM2976a));
                    } else {
                        c0606w.f2110V.setVisibility(8);
                        c0606w.f2108T.setVisibility(0);
                        c0606w.f2091C.setVisibility(8);
                    }
                    c0606w.f2100L.setVisibility(8);
                    c0606w.f2103O.setVisibility(8);
                } else if (i3 == 1 || i3 == 4 || i3 == 2) {
                    c0606w.f2110V.setVisibility(8);
                    c0606w.f2108T.setVisibility(8);
                    c0606w.f2111W.setVisibility(8);
                    c0606w.f2091C.setVisibility(8);
                    c0606w.f2100L.setVisibility(0);
                    if (i2 > 0) {
                        c0606w.f2117d.setText("(" + i2 + ")");
                        c0606w.f2117d.setVisibility(0);
                    } else {
                        c0606w.f2117d.setVisibility(4);
                    }
                } else if (i3 == -1) {
                    c0606w.f2110V.setVisibility(8);
                    c0606w.f2108T.setVisibility(8);
                    C1341p.m4659c("MSG_TYPE_FAIL!!!!!!!!!!");
                    m2786a(view, c0606w, j, this.f2079s, enumC0651dM2976a);
                }
            } else {
                m2792a(c0606w, string5, string9, string3, i4);
                c0606w.f2119f.setVisibility(8);
                c0606w.f2120g.setVisibility(0);
                c0606w.f2136w.setVisibility(8);
                m2798b(c0606w, cursor.getPosition(), lValueOf);
                if (enumC0651dM2976a != EnumC0651d.TEXT && enumC0651dM2976a != EnumC0651d.GEO && i3 == 3) {
                    AsyncTaskC0466c asyncTaskC0466cM2414b = C0473j.m2410a().m2414b(Long.parseLong(string));
                    if (asyncTaskC0466cM2414b != null) {
                        c0606w.f2137x.setVisibility(0);
                        c0606w.f2138y.setVisibility(8);
                        c0606w.f2139z.setVisibility(0);
                        asyncTaskC0466cM2414b.m2384a(view);
                        c0606w.f2139z.setOnClickListener(new ViewOnClickListenerC0605v(this, Long.parseLong(string)));
                    } else {
                        c0606w.f2137x.setVisibility(4);
                        c0606w.f2138y.setVisibility(4);
                        c0606w.f2139z.setVisibility(4);
                    }
                } else {
                    c0606w.f2138y.setVisibility(4);
                    c0606w.f2137x.setVisibility(4);
                    c0606w.f2139z.setVisibility(4);
                }
            }
            if (i3 == 4) {
                c0606w.f2113Y.setVisibility(0);
                c0606w.f2113Y.setOnClickListener(this);
            } else {
                c0606w.f2113Y.setVisibility(8);
            }
            switch (C0533ai.f1881a[enumC0651dM2976a.ordinal()]) {
                case 1:
                    m2794a(c0606w, string2, z2, z);
                    break;
                case 2:
                    if (string2 != null) {
                        String[] strArrSplit2 = string2.split("\n");
                        C1341p.m4658b("token:" + Arrays.toString(strArrSplit2), getClass().getSimpleName());
                        if (i6 == 1 && !C1327bw.m4595a()) {
                            z3 = true;
                            str = string7;
                        } else if (i6 != 0 || !C1327bw.m4595a()) {
                            z3 = false;
                            str = string7;
                        } else {
                            if (z2) {
                                str2 = GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() + "/" + string4 + "/" + strArrSplit2[3];
                            } else {
                                str2 = GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() + "/" + string4 + "/thumbnail//" + strArrSplit2[3];
                            }
                            if (!C1324bt.m4588b(str2)) {
                                z3 = true;
                                str = string7;
                            } else {
                                String string10 = Uri.fromFile(new File(str2)).toString();
                                C0635o.m2927a(GlobalApplication.m3100a().getContentResolver(), string3, string4, Long.valueOf(Long.parseLong(string)), string10, this.f2079s, true, true);
                                z3 = false;
                                str = string10;
                            }
                        }
                        if (z3) {
                            if (i5 == 2) {
                                str = C0684a.f2332c;
                            } else {
                                new AsyncTaskC0140ap(strArrSplit2[2], strArrSplit2[4], strArrSplit2[3], true, string4, Long.parseLong(string), EnumC0665r.ONETOONE, string3).execute(new String[0]);
                                str = null;
                            }
                        }
                    } else {
                        str = string7;
                    }
                    m2795a(c0606w, str, z2, z, z2 ? String.valueOf(j) : string);
                    break;
                case 3:
                    m2801b(c0606w, string7, z2, z, z2 ? String.valueOf(j) : string);
                    break;
                case 4:
                    m2800b(c0606w, string2, z2, z);
                    break;
                case 5:
                    m2793a(c0606w, string2, z2, string8, z);
                    break;
                case 6:
                    m2799b(c0606w, string2, z2, string8, z);
                    break;
                case 7:
                    m2804c(c0606w, string2, z2, z);
                    break;
                case 8:
                    m2794a(c0606w, this.f2078r.getString(R.string.toast_supported_format), z2, z);
                    break;
            }
        } else {
            m2791a(c0606w, string5, string9, string2);
        }
        view.setTag(c0606w);
    }

    /* renamed from: a */
    private void m2790a(C0606w c0606w, int i, boolean z, String str) {
        boolean z2;
        if (!TextUtils.isEmpty(c0606w.f2114a)) {
            if (z) {
                c0606w.f2102N.setVisibility(0);
                c0606w.f2102N.setOnClickListener(new ViewOnClickListenerC0537am(this, c0606w, str));
                if (this.f2054I == EnumC0542ar.SELECT_ALL || this.f2055J == EnumC0542ar.SELECT_ALL) {
                    this.f2048C.put(Long.valueOf(c0606w.f2114a), true);
                    c0606w.f2102N.setChecked(true);
                } else if (!this.f2048C.isEmpty() && this.f2048C.containsKey(Long.valueOf(c0606w.f2114a))) {
                    c0606w.f2102N.setChecked(((Boolean) this.f2048C.get(Long.valueOf(c0606w.f2114a))).booleanValue());
                } else {
                    z2 = this.f2055J == EnumC0542ar.SELECT_PART;
                    this.f2048C.put(Long.valueOf(c0606w.f2114a), Boolean.valueOf(z2));
                    c0606w.f2102N.setChecked(z2);
                }
                m2815a(c0606w.f2102N, c0606w.f2090B, str);
                return;
            }
            c0606w.f2089A.setVisibility(0);
            c0606w.f2089A.setOnClickListener(new ViewOnClickListenerC0538an(this, c0606w, str));
            if (this.f2054I == EnumC0542ar.SELECT_ALL || this.f2056K == EnumC0542ar.SELECT_ALL) {
                this.f2049D.put(Long.valueOf(c0606w.f2114a), true);
                c0606w.f2089A.setChecked(true);
            } else if (!this.f2049D.isEmpty() && this.f2049D.containsKey(Long.valueOf(c0606w.f2114a))) {
                c0606w.f2089A.setChecked(((Boolean) this.f2049D.get(Long.valueOf(c0606w.f2114a))).booleanValue());
            } else {
                z2 = this.f2056K == EnumC0542ar.SELECT_PART;
                this.f2049D.put(Long.valueOf(c0606w.f2114a), Boolean.valueOf(z2));
                c0606w.f2089A.setChecked(z2);
            }
            m2815a(c0606w.f2089A, c0606w.f2090B, str);
        }
    }

    /* renamed from: a */
    private void m2786a(View view, C0606w c0606w, long j, EnumC0665r enumC0665r, EnumC0651d enumC0651d) {
        c0606w.f2108T.setVisibility(8);
        c0606w.f2091C.setVisibility(8);
        c0606w.f2111W.setVisibility(0);
        c0606w.f2100L.setVisibility(8);
        c0606w.f2103O.setVisibility(8);
        c0606w.f2117d.setVisibility(4);
        if (this.f2084x) {
            if (enumC0665r == EnumC0665r.ONETOONE && enumC0651d == EnumC0651d.TEXT) {
                c0606w.f2111W.setOnClickListener(new ViewOnClickListenerC0586c(this, j, true));
            } else {
                c0606w.f2111W.setOnClickListener(new ViewOnClickListenerC0586c(this, j, false));
            }
        }
    }

    /* renamed from: a */
    private void m2789a(C0606w c0606w, int i, Long l) {
        String str;
        if (this.f2063b != null) {
            c0606w.f2100L.setVisibility(0);
            if (DateFormat.is24HourFormat(this.f2078r)) {
                str = "HH:mm";
            } else {
                str = "h:mm aa";
            }
            String strM4547a = C1302ay.m4547a(l.longValue(), str);
            c0606w.f2100L.setText(strM4547a);
            if (this.f2079s == EnumC0665r.BROADCAST) {
                c0606w.f2103O.setText("(9999) " + strM4547a);
                return;
            } else {
                c0606w.f2103O.setText("(000) " + strM4547a);
                return;
            }
        }
        c0606w.f2100L.setVisibility(8);
    }

    /* renamed from: b */
    private void m2798b(C0606w c0606w, int i, Long l) {
        String str;
        if (this.f2063b != null) {
            c0606w.f2135v.setVisibility(0);
            if (DateFormat.is24HourFormat(this.f2078r)) {
                str = "HH:mm";
            } else {
                str = "h:mm aa";
            }
            String strM4547a = C1302ay.m4547a(l.longValue(), str);
            c0606w.f2135v.setText(strM4547a);
            c0606w.f2129p.setText("(000)" + strM4547a);
            return;
        }
        c0606w.f2135v.setVisibility(8);
    }

    /* renamed from: a */
    private void m2787a(TextView textView, int i, String[] strArr, String str, CheckBox checkBox, String str2, long j, RelativeLayout relativeLayout) {
        if (i == 0) {
            relativeLayout.setVisibility(0);
            textView.setText(java.text.DateFormat.getDateInstance(1, GlobalApplication.m3106g().getConfiguration().locale).format(new Date(j)));
            if (this.f2080t.getChoiceMode() == 2) {
                checkBox.setVisibility(0);
                checkBox.setOnClickListener(new ViewOnClickListenerC0589f(this, checkBox, str2));
            }
        } else if (this.f2062a.equals(strArr[0])) {
            relativeLayout.setVisibility(8);
            if (this.f2080t.getChoiceMode() == 2) {
                checkBox.setVisibility(8);
                checkBox.setOnClickListener(new ViewOnClickListenerC0589f(this, checkBox, str2));
            }
        } else {
            relativeLayout.setVisibility(0);
            textView.setText(java.text.DateFormat.getDateInstance(1, GlobalApplication.m3106g().getConfiguration().locale).format(new Date(j)));
            if (this.f2080t.getChoiceMode() == 2) {
                checkBox.setVisibility(0);
                checkBox.setOnClickListener(new ViewOnClickListenerC0589f(this, checkBox, str2));
            }
        }
        textView.setOnLongClickListener(new ViewOnLongClickListenerC0535ak(this));
        textView.setOnClickListener(new ViewOnClickListenerC0536al(this, str, str2));
    }

    /* renamed from: a */
    private void m2792a(C0606w c0606w, String str, String str2, String str3, int i) {
        ProfileImageView profileImageView = (ProfileImageView) c0606w.f2122i;
        if (str != null) {
            if (this.f2084x) {
                C1348w.m4685a(this.f2078r).m4700a(profileImageView, str, i);
            } else {
                C1348w.m4685a(this.f2078r).m4698a(profileImageView, EnumC1310bf.BUDDY);
            }
            profileImageView.setOnClickListener(new ViewOnClickListenerC0587d(this, profileImageView, str, str2));
            c0606w.f2121h.setText(str2);
            return;
        }
        C1348w.m4685a(this.f2078r).m4698a(profileImageView, EnumC1310bf.BUDDY);
        c0606w.f2121h.setText(GlobalApplication.m3106g().getString(R.string.unknown));
    }

    /* renamed from: a */
    private void m2791a(C0606w c0606w, String str, String str2, String str3) throws Resources.NotFoundException {
        String str4;
        c0606w.f2119f.setVisibility(8);
        c0606w.f2120g.setVisibility(8);
        c0606w.f2136w.setVisibility(0);
        String[] strArrSplit = str3.split(";");
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length > 0) {
            EnumC0664q enumC0664qM3008a = EnumC0664q.UNKNOWN;
            for (String str5 : strArrSplit) {
                String[] strArrSplit2 = str5.split(",");
                if (strArrSplit2.length > 2) {
                    enumC0664qM3008a = EnumC0664q.m3008a(Integer.parseInt(strArrSplit2[0]));
                    sb.append(C0520a.m2718b(strArrSplit2[2].replace('\n', ' '))).append(",");
                }
            }
            String string = "";
            if (enumC0664qM3008a == EnumC0664q.ENTER) {
                if (TextUtils.isEmpty(str2)) {
                    string = GlobalApplication.m3106g().getString(R.string.chat_view_system_invite);
                } else {
                    string = GlobalApplication.m3106g().getString(R.string.chat_view_system_invite_2);
                }
            } else if (enumC0664qM3008a == EnumC0664q.LEAVE) {
                string = GlobalApplication.m3106g().getString(R.string.chat_view_system_leave);
            } else if (enumC0664qM3008a == EnumC0664q.INVITE) {
                string = GlobalApplication.m3106g().getString(R.string.noti_invite_member);
            } else if (enumC0664qM3008a == EnumC0664q.INVALID_USER) {
                string = GlobalApplication.m3106g().getString(R.string.toast_chat_change_account_info);
            } else if (enumC0664qM3008a == EnumC0664q.MEMBER) {
                string = GlobalApplication.m3106g().getString(R.string.chat_view_chat_member);
            }
            if (string.length() <= 0) {
                str4 = "";
            } else if (sb.length() > 1) {
                if (!TextUtils.isEmpty(str2) && enumC0664qM3008a == EnumC0664q.ENTER) {
                    str4 = String.format(string, str2, sb.substring(0, sb.length() - 1));
                } else {
                    str4 = String.format(string, sb.substring(0, sb.length() - 1));
                }
            } else {
                str4 = String.format(string, GlobalApplication.m3106g().getString(R.string.unknown));
            }
        } else {
            str4 = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            c0606w.f2116c.setText(str4);
        }
    }

    /* renamed from: a */
    private void m2794a(C0606w c0606w, String str, boolean z, boolean z2) {
        int i;
        C0760c c0760c = new C0760c(this.f2078r.getResources(), str, (int) C1301ax.m4544a(30.0f));
        String strM3194a = C0760c.m3194a(str);
        boolean zM2819a = m2819a(strM3194a);
        if (this.f2079s == EnumC0665r.BROADCAST) {
            i = 73;
        } else {
            i = 67;
        }
        if (z) {
            c0606w.f2093E.setMaxWidth(this.f2046A);
            float f = this.f2046A;
            TextPaint paint = c0606w.f2093E.getPaint();
            if (str == null || str == "") {
                c0606w.f2093E.setText(str);
                c0606w.f2093E.setTextSize(0, this.f2074m.floatValue());
            } else {
                c0606w.f2093E.setTextSize(0, this.f2074m.floatValue());
                c0606w.f2093E.setText(c0760c);
                C0564bd c0564bdM2811a = m2811a(strM3194a, paint, f, (int) C1301ax.m4544a(30.0f));
                if (!z2) {
                    c0606w.f2117d.setVisibility(8);
                    c0606w.f2103O.setVisibility(8);
                    this.f2057L.setMargins(0, 0, 0, 0);
                    c0606w.f2104P.setLayoutParams(new LinearLayout.LayoutParams(this.f2057L));
                    this.f2058M.setMargins((int) C1301ax.m4544a(8.0f), this.f2052G, (int) C1301ax.m4544a(20.0f), (int) C1301ax.m4544a(8.0f));
                    c0606w.f2093E.setLayoutParams(new LinearLayout.LayoutParams(this.f2058M));
                } else if (((int) f) - c0564bdM2811a.f1972b > ((int) C1301ax.m4544a(i)) && zM2819a) {
                    if (c0564bdM2811a.f1971a) {
                        this.f2057L.setMargins(0, 0, 0, -((int) C1301ax.m4544a(26.0f)));
                        c0606w.f2104P.setLayoutParams(new LinearLayout.LayoutParams(this.f2057L));
                        this.f2058M.setMargins((int) C1301ax.m4544a(8.0f), this.f2052G, (int) C1301ax.m4544a(20.0f), (int) C1301ax.m4544a(10.0f));
                        c0606w.f2093E.setLayoutParams(new LinearLayout.LayoutParams(this.f2058M));
                        c0606w.f2103O.setVisibility(8);
                    } else {
                        this.f2057L.setMargins(0, 0, 0, -((int) C1301ax.m4544a(24.0f)));
                        c0606w.f2104P.setLayoutParams(new LinearLayout.LayoutParams(this.f2057L));
                        this.f2058M.setMargins((int) C1301ax.m4544a(8.0f), this.f2052G, 0, (int) C1301ax.m4544a(8.0f));
                        c0606w.f2093E.setLayoutParams(new LinearLayout.LayoutParams(this.f2058M));
                        c0606w.f2103O.setVisibility(4);
                    }
                } else {
                    this.f2057L.setMargins(0, 0, 0, -((int) C1301ax.m4544a(8.0f)));
                    c0606w.f2104P.setLayoutParams(new LinearLayout.LayoutParams(this.f2057L));
                    this.f2058M.setMargins((int) C1301ax.m4544a(8.0f), this.f2052G, (int) C1301ax.m4544a(20.0f), (int) C1301ax.m4544a(8.0f));
                    c0606w.f2093E.setLayoutParams(new LinearLayout.LayoutParams(this.f2058M));
                    c0606w.f2103O.setVisibility(8);
                }
            }
            c0606w.f2093E.setTextColor(-16777216);
            c0606w.f2093E.setVisibility(0);
            c0606w.f2096H.setVisibility(8);
            c0606w.f2104P.setVisibility(0);
            c0606w.f2105Q.setVisibility(8);
            return;
        }
        c0606w.f2124k.setMaxWidth(this.f2047B);
        float f2 = this.f2047B;
        TextPaint paint2 = c0606w.f2124k.getPaint();
        if (str == null || str == "") {
            c0606w.f2124k.setText(str);
            c0606w.f2124k.setTextSize(0, this.f2074m.floatValue());
        } else {
            c0606w.f2124k.setTextSize(0, this.f2074m.floatValue());
            c0606w.f2124k.setText(c0760c);
            C0564bd c0564bdM2811a2 = m2811a(strM3194a, paint2, f2, (int) C1301ax.m4544a(30.0f));
            if (((int) f2) - c0564bdM2811a2.f1972b > ((int) C1301ax.m4544a(54.0f)) && zM2819a) {
                if (c0564bdM2811a2.f1971a) {
                    this.f2059N.setMargins((int) C1301ax.m4544a(6.0f), 0, 0, -((int) C1301ax.m4544a(26.0f)));
                    c0606w.f2128o.setLayoutParams(new LinearLayout.LayoutParams(this.f2059N));
                    this.f2060O.setMargins((int) C1301ax.m4544a(9.0f), this.f2053H, (int) C1301ax.m4544a(10.0f), (int) C1301ax.m4544a(10.0f));
                    c0606w.f2124k.setLayoutParams(new LinearLayout.LayoutParams(this.f2060O));
                    c0606w.f2129p.setVisibility(8);
                } else {
                    this.f2059N.setMargins((int) C1301ax.m4544a(6.0f), 0, 0, -((int) C1301ax.m4544a(24.0f)));
                    c0606w.f2128o.setLayoutParams(new LinearLayout.LayoutParams(this.f2059N));
                    this.f2060O.setMargins((int) C1301ax.m4544a(9.0f), this.f2053H, 0, (int) C1301ax.m4544a(8.0f));
                    c0606w.f2124k.setLayoutParams(new LinearLayout.LayoutParams(this.f2060O));
                    c0606w.f2129p.setVisibility(4);
                }
            } else {
                this.f2059N.setMargins((int) C1301ax.m4544a(6.0f), 0, 0, -((int) C1301ax.m4544a(8.0f)));
                c0606w.f2128o.setLayoutParams(new LinearLayout.LayoutParams(this.f2059N));
                this.f2060O.setMargins((int) C1301ax.m4544a(9.0f), this.f2053H, (int) C1301ax.m4544a(10.0f), (int) C1301ax.m4544a(8.0f));
                c0606w.f2124k.setLayoutParams(new LinearLayout.LayoutParams(this.f2060O));
                c0606w.f2129p.setVisibility(8);
            }
        }
        c0606w.f2124k.setTextColor(-16777216);
        c0606w.f2124k.setVisibility(0);
        c0606w.f2127n.setVisibility(8);
        c0606w.f2128o.setVisibility(0);
        c0606w.f2130q.setVisibility(8);
        c0606w.f2112X.setVisibility(8);
    }

    /* renamed from: a */
    public C0564bd m2811a(String str, Paint paint, float f, int i) {
        boolean z;
        float[] fArr = new float[str.length()];
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        C0564bd c0564bd = new C0564bd(this);
        c0564bd.f1971a = false;
        int textWidths = paint.getTextWidths(str, 0, length, fArr);
        do {
            c0564bd.f1972b = 0.0f;
            int i4 = i2;
            int i5 = i3;
            while (true) {
                if (i5 >= textWidths) {
                    i2 = i4;
                    break;
                }
                if (i5 + 4 < textWidths && str.substring(i5, i5 + 5).equals("%8|3&")) {
                    c0564bd.f1972b += i;
                    z = true;
                    i5 += 4;
                } else {
                    c0564bd.f1972b += fArr[i5];
                    z = false;
                }
                if (c0564bd.f1972b > f) {
                    if (z) {
                        i2 = i5 - 5;
                    } else {
                        i2 = i5 - 1;
                    }
                    c0564bd.f1971a = true;
                } else {
                    if (str.charAt(i5) == '\n') {
                        c0564bd.f1972b = 0.0f;
                    }
                    int i6 = i5 == textWidths + (-1) ? 0 : i4;
                    i5++;
                    i4 = i6;
                }
            }
            if (i2 > 0 && i2 < str.length()) {
                if ((i2 != 0 && str.charAt(i2) != ' ' && str.charAt(i2) != '\n' && str.charAt(i2) != '-' && str.charAt(i2) != '/' && str.charAt(i2) != ';' && str.charAt(i2) != ':' && str.charAt(i2) != ',' && str.charAt(i2) != '.') || ((str.charAt(i2 - 1) > '/' && str.charAt(i2 - 1) < ':') || (str.charAt(i2 + 1) > '/' && str.charAt(i2 + 1) < ':'))) {
                    int i7 = i2;
                    while (i7 >= i3) {
                        if (str.charAt(i7) == ' ' || str.charAt(i7) == '\n' || str.charAt(i7) == '-' || str.charAt(i7) == '/' || str.charAt(i7) == ';' || str.charAt(i7) == ':' || str.charAt(i7) == ',' || str.charAt(i7) == '.') {
                            if (str.charAt(i7) != ' ' && str.charAt(i7) != '\n') {
                                char cCharAt = str.charAt(i7 + 1);
                                char cCharAt2 = i7 > 0 ? str.charAt(i7 - 1) : (char) 0;
                                if ((cCharAt > '/' && cCharAt < ':') || (cCharAt2 > '/' && cCharAt2 < ':')) {
                                    if (i7 == i3) {
                                        i3 = i2 + 1;
                                    }
                                } else {
                                    i3 = i7 + 1;
                                    break;
                                }
                            } else {
                                i3 = i7 + 1;
                                break;
                            }
                        } else if (i7 == i3) {
                            i3 = i2 + 1;
                        }
                        i7--;
                    }
                } else {
                    i3 = i2 + 1;
                }
            } else {
                i3 = i2 + 1;
            }
        } while (i2 != 0);
        return c0564bd;
    }

    /* renamed from: a */
    private void m2795a(C0606w c0606w, String str, boolean z, boolean z2, String str2) {
        if (z) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(c0606w.f2104P.getLayoutParams());
            C1341p.m4659c("Uri.parse(content):" + str);
            C0810c c0810c = new C0810c(str2 + str, str, true);
            c0810c.m606a(c0606w.f2096H);
            this.f2061P.m603a(c0606w.f2096H, c0810c);
            c0606w.f2103O.setVisibility(8);
            marginLayoutParams.setMargins(0, 0, 0, 0);
            c0606w.f2104P.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams));
            if (!z2) {
                c0606w.f2117d.setVisibility(8);
            }
            c0606w.f2096H.setOnClickListener(this);
            c0606w.f2093E.setVisibility(8);
            c0606w.f2096H.setVisibility(0);
            c0606w.f2104P.setVisibility(0);
            c0606w.f2105Q.setVisibility(8);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(c0606w.f2128o.getLayoutParams());
        C1341p.m4659c("Uri.parse(content):" + str);
        C0810c c0810c2 = new C0810c(str2 + str, str, true);
        c0810c2.m606a(c0606w.f2127n);
        this.f2061P.m603a(c0606w.f2127n, c0810c2);
        marginLayoutParams2.setMargins(0, 0, 0, 0);
        c0606w.f2128o.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams2));
        c0606w.f2127n.setOnClickListener(this);
        c0606w.f2124k.setVisibility(8);
        c0606w.f2129p.setVisibility(8);
        if (str == null) {
            c0606w.f2127n.setVisibility(8);
            c0606w.f2112X.setVisibility(0);
        } else {
            c0606w.f2127n.setVisibility(0);
            c0606w.f2112X.setVisibility(8);
        }
        c0606w.f2128o.setVisibility(0);
        c0606w.f2130q.setVisibility(8);
    }

    /* renamed from: b */
    private void m2800b(C0606w c0606w, String str, boolean z, boolean z2) {
        if (z) {
            c0606w.f2098J.setImageResource(R.drawable.messenger_chat_audio_icon);
            if (!z2) {
                c0606w.f2117d.setVisibility(8);
            }
            c0606w.f2098J.setOnClickListener(this);
            c0606w.f2099K.setVisibility(8);
            c0606w.f2098J.setVisibility(0);
            c0606w.f2105Q.setVisibility(0);
            c0606w.f2104P.setVisibility(8);
            c0606w.f2103O.setVisibility(8);
            c0606w.f2096H.setVisibility(8);
            c0606w.f2093E.setVisibility(8);
            return;
        }
        c0606w.f2132s.setImageResource(R.drawable.messenger_chat_audio_icon);
        c0606w.f2132s.setOnClickListener(this);
        c0606w.f2133t.setVisibility(8);
        c0606w.f2132s.setVisibility(0);
        c0606w.f2130q.setVisibility(0);
        c0606w.f2128o.setVisibility(8);
        c0606w.f2129p.setVisibility(8);
        c0606w.f2127n.setVisibility(8);
        c0606w.f2124k.setVisibility(8);
    }

    /* renamed from: b */
    private void m2801b(C0606w c0606w, String str, boolean z, boolean z2, String str2) {
        if (z) {
            C0810c c0810c = new C0810c(str2 + str, str, false);
            c0810c.m606a(c0606w.f2096H);
            this.f2061P.m603a(c0606w.f2096H, c0810c);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(c0606w.f2104P.getLayoutParams());
            marginLayoutParams.setMargins(0, 0, 0, 0);
            if (!z2) {
                c0606w.f2117d.setVisibility(8);
            }
            c0606w.f2103O.setVisibility(8);
            c0606w.f2104P.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams));
            c0606w.f2096H.setOnClickListener(this);
            c0606w.f2093E.setVisibility(8);
            c0606w.f2096H.setVisibility(0);
            c0606w.f2104P.setVisibility(0);
            c0606w.f2105Q.setVisibility(8);
            c0606w.f2112X.setVisibility(8);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(c0606w.f2128o.getLayoutParams());
        C0810c c0810c2 = new C0810c(str2 + str, str, false);
        c0810c2.m606a(c0606w.f2127n);
        this.f2061P.m603a(c0606w.f2127n, c0810c2);
        marginLayoutParams2.setMargins(0, 0, 0, 0);
        c0606w.f2128o.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams2));
        c0606w.f2127n.setOnClickListener(this);
        c0606w.f2124k.setVisibility(8);
        c0606w.f2129p.setVisibility(8);
        c0606w.f2127n.setVisibility(0);
        c0606w.f2128o.setVisibility(0);
        c0606w.f2130q.setVisibility(8);
        c0606w.f2112X.setVisibility(8);
    }

    /* renamed from: c */
    private void m2804c(C0606w c0606w, String str, boolean z, boolean z2) {
        if (z) {
            if (C0684a.m3049a()) {
                c0606w.f2098J.setImageResource(R.drawable.messenger_chat_location_icon);
            } else {
                c0606w.f2098J.setImageResource(R.drawable.messenger_chat_location_error_icon);
            }
            if (!z2) {
                c0606w.f2117d.setVisibility(8);
            }
            c0606w.f2098J.setOnClickListener(this);
            c0606w.f2098J.setVisibility(0);
            c0606w.f2099K.setVisibility(8);
            c0606w.f2105Q.setVisibility(0);
            c0606w.f2104P.setVisibility(8);
            c0606w.f2103O.setVisibility(8);
            c0606w.f2096H.setVisibility(8);
            c0606w.f2093E.setVisibility(8);
            return;
        }
        if (C0684a.m3049a()) {
            c0606w.f2132s.setImageResource(R.drawable.messenger_chat_location_icon);
        } else {
            c0606w.f2132s.setImageResource(R.drawable.messenger_chat_location_error_icon);
        }
        c0606w.f2132s.setOnClickListener(this);
        c0606w.f2132s.setVisibility(0);
        c0606w.f2133t.setVisibility(8);
        c0606w.f2130q.setVisibility(0);
        c0606w.f2128o.setVisibility(8);
        c0606w.f2129p.setVisibility(8);
        c0606w.f2127n.setVisibility(8);
        c0606w.f2124k.setVisibility(8);
    }

    /* renamed from: a */
    private void m2793a(C0606w c0606w, String str, boolean z, String str2, boolean z2) {
        if (z) {
            c0606w.f2098J.setImageResource(R.drawable.messenger_chat_calendar_icon);
            if (!z2) {
                c0606w.f2117d.setVisibility(8);
            }
            c0606w.f2098J.setOnClickListener(this);
            c0606w.f2099K.setText(str2);
            c0606w.f2099K.setVisibility(0);
            c0606w.f2098J.setVisibility(0);
            c0606w.f2096H.setVisibility(8);
            c0606w.f2093E.setVisibility(8);
            c0606w.f2104P.setVisibility(8);
            c0606w.f2103O.setVisibility(8);
            c0606w.f2105Q.setVisibility(0);
            return;
        }
        c0606w.f2132s.setImageResource(R.drawable.messenger_chat_calendar_icon);
        c0606w.f2132s.setOnClickListener(this);
        c0606w.f2133t.setText(str2);
        c0606w.f2133t.setVisibility(0);
        c0606w.f2132s.setVisibility(0);
        c0606w.f2127n.setVisibility(8);
        c0606w.f2124k.setVisibility(8);
        c0606w.f2128o.setVisibility(8);
        c0606w.f2129p.setVisibility(8);
        c0606w.f2130q.setVisibility(0);
    }

    /* renamed from: b */
    private void m2799b(C0606w c0606w, String str, boolean z, String str2, boolean z2) {
        if (z) {
            c0606w.f2098J.setImageResource(R.drawable.messenger_chat_contact_icon);
            c0606w.f2098J.setOnClickListener(this);
            c0606w.f2099K.setText(str2);
            if (!z2) {
                c0606w.f2117d.setVisibility(8);
            }
            c0606w.f2099K.setVisibility(0);
            c0606w.f2098J.setVisibility(0);
            c0606w.f2096H.setVisibility(8);
            c0606w.f2093E.setVisibility(8);
            c0606w.f2104P.setVisibility(8);
            c0606w.f2103O.setVisibility(8);
            c0606w.f2105Q.setVisibility(0);
            return;
        }
        c0606w.f2132s.setImageResource(R.drawable.messenger_chat_contact_icon);
        c0606w.f2132s.setOnClickListener(this);
        c0606w.f2133t.setText(str2);
        c0606w.f2133t.setVisibility(0);
        c0606w.f2132s.setVisibility(0);
        c0606w.f2127n.setVisibility(8);
        c0606w.f2124k.setVisibility(8);
        c0606w.f2128o.setVisibility(8);
        c0606w.f2129p.setVisibility(8);
        c0606w.f2130q.setVisibility(0);
    }

    /* renamed from: a */
    public void m2815a(CheckBox checkBox, CheckBox checkBox2, String str) {
        Boolean bool;
        String string;
        if (!checkBox.isChecked()) {
            Boolean bool2 = false;
            if (this.f2054I == EnumC0542ar.SELECT_ALL || this.f2054I == EnumC0542ar.SELECT_PART || this.f2056K == EnumC0542ar.SELECT_ALL || this.f2056K == EnumC0542ar.SELECT_PART || this.f2055J == EnumC0542ar.SELECT_ALL || this.f2055J == EnumC0542ar.SELECT_PART) {
                bool2 = true;
            } else {
                if (this.f2048C != null && !this.f2048C.isEmpty()) {
                    Iterator it = this.f2048C.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                            bool2 = true;
                            break;
                        }
                    }
                }
                if (!bool2.booleanValue() && this.f2049D != null && !this.f2049D.isEmpty()) {
                    Iterator it2 = this.f2049D.entrySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (((Boolean) ((Map.Entry) it2.next()).getValue()).booleanValue()) {
                            bool2 = true;
                            break;
                        }
                    }
                }
            }
            this.f2086z.setEnabled(bool2.booleanValue());
            bool = false;
        } else {
            int i = 0;
            while (true) {
                if (i >= this.f2080t.getAdapter().getCount()) {
                    bool = true;
                    break;
                }
                Cursor cursor = (Cursor) this.f2080t.getAdapter().getItem(i);
                Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
                EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
                if (enumC0651dM2976a != EnumC0651d.SYSTEM && strArrSplit[0].equals(str) && (string = cursor.getString(cursor.getColumnIndex("message_sender"))) != null) {
                    if (string.equals(C1323bs.m4575a().getString("msisdn", ""))) {
                        Boolean bool3 = (Boolean) this.f2048C.get(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
                        if (bool3 != null && !bool3.booleanValue()) {
                            bool = false;
                            break;
                        }
                    } else {
                        Boolean bool4 = (Boolean) this.f2049D.get(Long.valueOf(Long.valueOf(cursor.getString(cursor.getColumnIndex("message_sever_id"))).longValue()));
                        if (bool4 != null && !bool4.booleanValue()) {
                            bool = false;
                            break;
                        }
                    }
                }
                i++;
            }
            this.f2086z.setEnabled(true);
        }
        if (bool.booleanValue()) {
            if (!this.f2073l.contains(str)) {
                this.f2073l.add(str);
            }
            checkBox2.setChecked(true);
        } else {
            if (this.f2073l.contains(str)) {
                this.f2073l.remove(str);
            }
            checkBox2.setChecked(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2085y.mo2703b(view);
    }

    /* renamed from: a */
    public static void m2788a(ChatFragment chatFragment, EnumC0651d enumC0651d, String str, ProgressDialog progressDialog) {
        if (str == null || C0684a.f2332c.equals(str)) {
            C1619g.m5888a(chatFragment.getActivity(), R.string.media_download_fail, 0).show();
            return;
        }
        C1341p.m4659c("file uri:" + str);
        if (str.startsWith("file:") && enumC0651d != EnumC0651d.AUDIO) {
            str = str.substring(6);
        }
        C1341p.m4659c("Download_uri:" + str);
        if (enumC0651d == EnumC0651d.CALENDAR) {
            if (str != null) {
                Intent intent = new Intent(chatFragment.getActivity(), (Class<?>) VCalendarDetailActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                intent.putExtra("URI", str);
                chatFragment.startActivity(intent);
                return;
            }
            return;
        }
        if (enumC0651d == EnumC0651d.CONTACT) {
            if (str != null) {
                Intent intent2 = new Intent(chatFragment.getActivity(), (Class<?>) ReadVCardActivity.class);
                intent2.putExtra("URI", str);
                intent2.putExtra("VCARD_SAVE", true);
                chatFragment.startActivity(intent2);
                return;
            }
            return;
        }
        if (enumC0651d == EnumC0651d.AUDIO) {
            if (!C1327bw.m4595a()) {
                C1619g.m5888a(chatFragment.getActivity(), R.string.sdcard_not_found, 0).show();
                return;
            }
            Intent intent3 = new Intent();
            intent3.setAction("android.intent.action.VIEW");
            intent3.setDataAndType(Uri.parse(str), "audio/*");
            intent3.putExtra(ChatFragment.f1727b, str);
            intent3.putExtra(PlayAudio.f2604a, PlayAudio.f2606c);
            chatFragment.startActivity(intent3);
            return;
        }
        if (enumC0651d == EnumC0651d.VIDEO) {
            if (!C1327bw.m4595a()) {
                C1619g.m5888a(chatFragment.getActivity(), R.string.sdcard_not_found, 0).show();
                return;
            }
            Intent intent4 = new Intent(chatFragment.getActivity(), (Class<?>) VideoPreviewActivity.class);
            intent4.putExtra("URI", str);
            chatFragment.startActivityForResult(intent4, 14);
            return;
        }
        if (enumC0651d == EnumC0651d.IMAGE) {
            AMSLibs aMSLibs = new AMSLibs();
            aMSLibs.VipAMS_Init();
            AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
            AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
            ams_coding_file_infoArr[0].setM_eExportType(0);
            ams_coding_file_infoArr[0].setM_strFileName(str);
            if (aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr) == 0) {
                Intent intent5 = new Intent(chatFragment.getActivity(), (Class<?>) AMSPlayerActivity.class);
                intent5.putExtra("AMS_FILE_PATH", str);
                intent5.putExtra("VIEWER_MODE", 1002);
                chatFragment.startActivity(intent5);
                return;
            }
            Intent intent6 = new Intent(chatFragment.getActivity(), (Class<?>) ViewOriginalImage.class);
            intent6.putExtra("URI", str);
            intent6.putExtra(C0684a.f2335f, true);
            chatFragment.startActivityForResult(intent6, 13);
            return;
        }
        chatFragment.startActivity(new Intent("android.intent.action.VIEW"));
    }
}
