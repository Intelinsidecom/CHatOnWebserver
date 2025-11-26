package com.sec.chaton.chat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
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
import android.widget.Toast;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.audio.PlayAudio;
import com.sec.chaton.multimedia.doc.EnumC0905b;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.multimedia.emoticon.C0968n;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC0916aa;
import com.sec.chaton.multimedia.geotag.GeotagActivity;
import com.sec.chaton.multimedia.image.C0983a;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p015d.p016a.AsyncTaskC0607w;
import com.sec.chaton.p015d.p016a.AsyncTaskC0608x;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p022h.p025c.C0777a;
import com.sec.chaton.p022h.p025c.C0779c;
import com.sec.chaton.p022h.p025c.RunnableC0781e;
import com.sec.chaton.util.C1722ae;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1769by;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1748bd;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C2153y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.as */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0477as extends SimpleCursorAdapter implements View.OnClickListener {

    /* renamed from: A */
    private C1821b f1962A;

    /* renamed from: B */
    private ListView f1963B;

    /* renamed from: C */
    private String f1964C;

    /* renamed from: D */
    private String f1965D;

    /* renamed from: E */
    private String f1966E;

    /* renamed from: F */
    private boolean f1967F;

    /* renamed from: G */
    private InterfaceC0496bj f1968G;

    /* renamed from: H */
    private Button f1969H;

    /* renamed from: I */
    private int f1970I;

    /* renamed from: J */
    private int f1971J;

    /* renamed from: K */
    private HashMap f1972K;

    /* renamed from: L */
    private HashMap f1973L;

    /* renamed from: M */
    private long f1974M;

    /* renamed from: N */
    private long f1975N;

    /* renamed from: O */
    private Drawable f1976O;

    /* renamed from: P */
    private Drawable f1977P;

    /* renamed from: Q */
    private EnumC0487ba f1978Q;

    /* renamed from: R */
    private EnumC0487ba f1979R;

    /* renamed from: S */
    private EnumC0487ba f1980S;

    /* renamed from: a */
    String f1981a;

    /* renamed from: b */
    String f1982b;

    /* renamed from: c */
    String f1983c;

    /* renamed from: d */
    String[] f1984d;

    /* renamed from: e */
    String f1985e;

    /* renamed from: f */
    String f1986f;

    /* renamed from: g */
    String f1987g;

    /* renamed from: h */
    String f1988h;

    /* renamed from: i */
    String f1989i;

    /* renamed from: j */
    String f1990j;

    /* renamed from: k */
    String f1991k;

    /* renamed from: l */
    int f1992l;

    /* renamed from: m */
    int f1993m;

    /* renamed from: n */
    int f1994n;

    /* renamed from: o */
    int f1995o;

    /* renamed from: p */
    int f1996p;

    /* renamed from: q */
    int f1997q;

    /* renamed from: r */
    int f1998r;

    /* renamed from: s */
    public ArrayList f1999s;

    /* renamed from: t */
    Float f2000t;

    /* renamed from: u */
    int f2001u;

    /* renamed from: v */
    int f2002v;

    /* renamed from: x */
    private LayoutInflater f2003x;

    /* renamed from: y */
    private Context f2004y;

    /* renamed from: z */
    private EnumC0695j f2005z;

    /* renamed from: w */
    public static final String[] f1961w = {"_id", "message_inbox_no", "message_sever_id", "message_session_id", "message_read_status", "message_time", "message_content", "message_translated", "message_type", "message_sender", "message_is_failed", "buddy_name", "buddy_profile_status"};

    /* renamed from: T */
    private static HashMap f1960T = new HashMap();

    static {
        f1960T.put(EnumC0905b.DOC, Integer.valueOf(R.drawable.messenger_chat_word_icon));
        f1960T.put(EnumC0905b.GUL, Integer.valueOf(R.drawable.messenger_chat_hun_icon));
        f1960T.put(EnumC0905b.HWP, Integer.valueOf(R.drawable.messenger_chat_han_icon));
        f1960T.put(EnumC0905b.PDF, Integer.valueOf(R.drawable.messenger_chat_pdf_icon));
        f1960T.put(EnumC0905b.PPT, Integer.valueOf(R.drawable.messenger_chat_ppt_icon));
        f1960T.put(EnumC0905b.XLS, Integer.valueOf(R.drawable.messenger_chat_excel_icon));
    }

    public ViewOnClickListenerC0477as(Context context, ListView listView, int i, Cursor cursor, EnumC0695j enumC0695j, ArrayList arrayList, Button button, C1821b c1821b) {
        super(context, i, cursor, f1961w, null, 2);
        this.f1981a = "";
        this.f1982b = "";
        this.f1983c = "";
        this.f1985e = "///mnt/sdcard/ChatON/";
        this.f1986f = "/mnt/sdcard/ChatON/audio/";
        this.f1987g = "/mnt/sdcard/ChatON/contact/";
        this.f1988h = "/mnt/sdcard/ChatON/geo/";
        this.f1989i = "/mnt/sdcard/ChatON/calendar/";
        this.f1990j = "/mnt/sdcard/ChatON/video/";
        this.f1991k = "/mnt/sdcard/ChatON/downloads/";
        this.f1999s = new ArrayList();
        this.f2000t = Float.valueOf(0.0f);
        this.f2001u = 0;
        this.f2002v = 0;
        this.f1967F = true;
        this.f1976O = null;
        this.f1977P = null;
        this.f1978Q = EnumC0487ba.SELECT_NONE;
        this.f1979R = EnumC0487ba.SELECT_NONE;
        this.f1980S = EnumC0487ba.SELECT_NONE;
        this.f1969H = button;
        this.f1963B = listView;
        this.f1962A = c1821b;
        this.f2004y = context;
        this.f2005z = enumC0695j;
        this.f2003x = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1966E = C1789u.m6075a().getString("Default Font Size", "");
        this.f1972K = new HashMap();
        this.f1973L = new HashMap();
        if (!GlobalApplication.m3265f()) {
            if ("size50".equals(this.f1966E)) {
                this.f2000t = Float.valueOf(8.0f);
                this.f2001u = 14;
                this.f2002v = 22;
                return;
            }
            if ("size70".equals(this.f1966E)) {
                this.f2000t = Float.valueOf(11.2f);
                this.f2001u = 10;
                this.f2002v = 16;
                return;
            }
            if ("size100".equals(this.f1966E)) {
                this.f2000t = Float.valueOf(16.0f);
                this.f2001u = 4;
                this.f2002v = 10;
                return;
            } else if ("size150".equals(this.f1966E)) {
                this.f2000t = Float.valueOf(24.0f);
                this.f2001u = 4;
                this.f2002v = 10;
                return;
            } else if ("size200".equals(this.f1966E)) {
                this.f2000t = Float.valueOf(32.0f);
                this.f2001u = 4;
                this.f2002v = 10;
                return;
            } else {
                this.f2000t = Float.valueOf(16.0f);
                this.f2001u = 4;
                this.f2002v = 10;
                return;
            }
        }
        if ("size50".equals(this.f1966E)) {
            this.f2000t = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_tiny));
            this.f2001u = 14;
            this.f2002v = 22;
            return;
        }
        if ("size70".equals(this.f1966E)) {
            this.f2000t = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_small));
            this.f2001u = 12;
            this.f2002v = 18;
            return;
        }
        if ("size100".equals(this.f1966E)) {
            this.f2000t = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_normal));
            this.f2001u = 10;
            this.f2002v = 16;
        } else if ("size150".equals(this.f1966E)) {
            this.f2000t = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_large));
            this.f2001u = 4;
            this.f2002v = 10;
        } else if ("size200".equals(this.f1966E)) {
            this.f2000t = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_huge));
            this.f2001u = 4;
            this.f2002v = 10;
        } else {
            this.f2000t = Float.valueOf(context.getResources().getDimension(R.dimen.font_size_normal));
            this.f2001u = 4;
            this.f2002v = 10;
        }
    }

    /* renamed from: a */
    public void m2662a(long j) {
        this.f1975N = j;
    }

    /* renamed from: b */
    public void m2670b(long j) {
        this.f1974M = j;
    }

    /* renamed from: a */
    public HashMap m2661a() {
        return this.f1972K;
    }

    /* renamed from: b */
    public HashMap m2669b() {
        return this.f1973L;
    }

    /* renamed from: a */
    public Boolean m2660a(Long l, Boolean bool) {
        if (this.f1972K == null) {
            return null;
        }
        return (Boolean) this.f1972K.put(l, bool);
    }

    /* renamed from: b */
    public Boolean m2668b(Long l, Boolean bool) {
        if (this.f1973L == null) {
            return null;
        }
        return (Boolean) this.f1973L.put(l, bool);
    }

    /* renamed from: c */
    public void m2672c() {
        if (this.f1972K != null && !this.f1972K.isEmpty()) {
            this.f1972K.clear();
        }
        if (this.f1973L != null && !this.f1973L.isEmpty()) {
            this.f1973L.clear();
        }
    }

    /* renamed from: a */
    public void m2664a(EnumC0487ba enumC0487ba) {
        this.f1978Q = enumC0487ba;
    }

    /* renamed from: d */
    public EnumC0487ba m2674d() {
        return this.f1978Q;
    }

    /* renamed from: b */
    public void m2671b(EnumC0487ba enumC0487ba) {
        this.f1979R = enumC0487ba;
    }

    /* renamed from: e */
    public EnumC0487ba m2675e() {
        return this.f1979R;
    }

    /* renamed from: c */
    public void m2673c(EnumC0487ba enumC0487ba) {
        this.f1980S = enumC0487ba;
    }

    /* renamed from: f */
    public EnumC0487ba m2676f() {
        return this.f1980S;
    }

    /* renamed from: a */
    public void m2665a(InterfaceC0496bj interfaceC0496bj) {
        this.f1968G = interfaceC0496bj;
    }

    /* renamed from: a */
    public void m2667a(boolean z) {
        this.f1967F = z;
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f2003x.inflate(R.layout.item_balloon_skin0, viewGroup, false);
        C0484az c0484az = new C0484az();
        c0484az.f2042b = (TextView) viewInflate.findViewById(R.id.textDate);
        c0484az.f2043c = (TextView) viewInflate.findViewById(R.id.textInvite);
        c0484az.f2053m = (ViewGroup) viewInflate.findViewById(R.id.parentRcv);
        c0484az.f2053m.setOnClickListener(this);
        c0484az.f2055o = (ImageView) viewInflate.findViewById(R.id.imageProfile);
        c0484az.f2054n = (TextView) viewInflate.findViewById(R.id.textName);
        c0484az.f2056p = (LinearLayout) viewInflate.findViewById(R.id.lLayoutRcvContent);
        c0484az.f2056p.setOnLongClickListener(null);
        c0484az.f2056p.setOnClickListener(this);
        c0484az.f2056p.setTag(viewInflate);
        c0484az.f2057q = (TextView) viewInflate.findViewById(R.id.textRcvContent);
        c0484az.f2060t = (ImageView) viewInflate.findViewById(R.id.imageRcvContent);
        c0484az.f2060t.setTag(viewInflate);
        c0484az.f2060t.setOnLongClickListener(null);
        c0484az.f2061u = (LinearLayout) viewInflate.findViewById(R.id.lLayoutETC);
        c0484az.f2062v = (ImageView) viewInflate.findViewById(R.id.imageEtcContent);
        c0484az.f2062v.setTag(viewInflate);
        c0484az.f2062v.setOnLongClickListener(null);
        c0484az.f2063w = (TextView) viewInflate.findViewById(R.id.textEtcContent);
        c0484az.f2064x = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutDate);
        c0484az.f2058r = (TextView) viewInflate.findViewById(R.id.textRcvTranslated);
        c0484az.f2059s = (ImageView) viewInflate.findViewById(R.id.imageRcvTranIcon);
        c0484az.f2065y = (TextView) viewInflate.findViewById(R.id.textRcvTime);
        c0484az.f2066z = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutInvite);
        c0484az.f2019A = (ProgressBar) viewInflate.findViewById(R.id.progressbarDown);
        c0484az.f2019A.setVisibility(4);
        c0484az.f2019A.setMax(100);
        c0484az.f2021C = (Button) viewInflate.findViewById(R.id.btnDownCancel);
        c0484az.f2021C.setVisibility(4);
        c0484az.f2022D = (CheckBox) viewInflate.findViewById(R.id.chkRcvId);
        c0484az.f2023E = (CheckBox) viewInflate.findViewById(R.id.DateRcvId);
        c0484az.f2020B = (ProgressBar) viewInflate.findViewById(R.id.DownProgressBalloon);
        c0484az.f2051k = (ViewGroup) viewInflate.findViewById(R.id.rSendRoot);
        c0484az.f2052l = (RelativeLayout) this.f2003x.inflate(R.layout.item_balloon_sent, c0484az.f2051k, true);
        c0484az.f2052l.setOnClickListener(this);
        c0484az.f2039U = (ProgressBar) viewInflate.findViewById(R.id.imageLoadingProgressbar);
        c0484az.f2025G = (LinearLayout) c0484az.f2052l.findViewById(R.id.lLayoutSndContent);
        c0484az.f2025G.setOnLongClickListener(null);
        c0484az.f2025G.setOnClickListener(this);
        c0484az.f2025G.setTag(viewInflate);
        c0484az.f2026H = (TextView) c0484az.f2052l.findViewById(R.id.textSndContent);
        c0484az.f2026H.setOnClickListener(this);
        c0484az.f2028J = (TextView) c0484az.f2052l.findViewById(R.id.textSndTranslated);
        c0484az.f2027I = (ImageView) c0484az.f2052l.findViewById(R.id.imageSndTranIcon);
        c0484az.f2029K = (ImageView) c0484az.f2052l.findViewById(R.id.imageSndContent);
        c0484az.f2029K.setOnLongClickListener(null);
        c0484az.f2030L = (LinearLayout) c0484az.f2052l.findViewById(R.id.lLayoutSndETC);
        c0484az.f2031M = (ImageView) c0484az.f2052l.findViewById(R.id.imageEtcSndContent);
        c0484az.f2031M.setOnLongClickListener(null);
        c0484az.f2032N = (TextView) c0484az.f2052l.findViewById(R.id.textEtcSndContent);
        c0484az.f2033O = (TextView) c0484az.f2052l.findViewById(R.id.textSndTime);
        c0484az.f2034P = (TextView) c0484az.f2052l.findViewById(R.id.textSndStatus);
        c0484az.f2035Q = (CheckBox) c0484az.f2052l.findViewById(R.id.chkSndId);
        c0484az.f2045e = (LinearLayout) c0484az.f2052l.findViewById(R.id.detailLayout);
        c0484az.f2045e.setOnClickListener(this);
        c0484az.f2046f = (ImageView) c0484az.f2052l.findViewById(R.id.detailImageView);
        c0484az.f2046f.setOnClickListener(this);
        c0484az.f2047g = (TextView) c0484az.f2052l.findViewById(R.id.detailTextView);
        c0484az.f2047g.setOnClickListener(this);
        c0484az.f2045e.setTag(viewInflate);
        c0484az.f2048h = (LinearLayout) c0484az.f2053m.findViewById(R.id.detailLayout_R);
        c0484az.f2048h.setOnClickListener(this);
        c0484az.f2049i = (ImageView) c0484az.f2053m.findViewById(R.id.detailImageView_R);
        c0484az.f2049i.setOnClickListener(this);
        c0484az.f2050j = (TextView) c0484az.f2053m.findViewById(R.id.detailTextView_R);
        c0484az.f2050j.setOnClickListener(this);
        c0484az.f2048h.setTag(viewInflate);
        c0484az.f2024F = (Button) c0484az.f2052l.findViewById(R.id.btnSendCancel);
        c0484az.f2036R = (ProgressBar) c0484az.f2052l.findViewById(R.id.progressBalloon);
        c0484az.f2036R.setVisibility(4);
        c0484az.f2037S = (ProgressBar) c0484az.f2052l.findViewById(R.id.progressbarUp);
        c0484az.f2037S.setVisibility(4);
        c0484az.f2037S.setMax(100);
        c0484az.f2044d = (TextView) c0484az.f2052l.findViewById(R.id.chat_ack);
        c0484az.f2038T = (Button) c0484az.f2052l.findViewById(R.id.btnError);
        c0484az.f2038T.setTag(viewInflate);
        c0484az.f2040V = (Button) viewInflate.findViewById(R.id.download_completed);
        c0484az.f2040V.setTag(viewInflate);
        m2643b(c0484az);
        viewInflate.setTag(c0484az);
        return viewInflate;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException {
        boolean z;
        boolean z2;
        String[] strArr;
        String strSubstring;
        String str;
        boolean z3;
        String str2;
        C0484az c0484az = (C0484az) view.getTag();
        int position = cursor.getPosition();
        if (GlobalApplication.m3265f()) {
            int iM5894a = (int) C1722ae.m5894a(C1722ae.m5895b(((Activity) this.f2004y).findViewById(R.id.fragment_container).getWidth()));
            this.f1970I = (int) (iM5894a - C1722ae.m5894a(45.0f));
            this.f1971J = (int) (iM5894a - C1722ae.m5894a(95.0f));
        } else {
            int i = this.f2004y.getResources().getDisplayMetrics().widthPixels;
            this.f1970I = (int) (i * 0.75d);
            this.f1971J = (int) (i * 0.6d);
        }
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("message_sever_id"));
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string4 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        int i2 = cursor.getInt(cursor.getColumnIndex("message_read_status"));
        int i3 = cursor.getInt(cursor.getColumnIndex("message_type"));
        String string5 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        int i4 = cursor.getInt(cursor.getColumnIndex("buddy_profile_status"));
        String string7 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        String string8 = cursor.getString(cursor.getColumnIndex("message_formatted"));
        int i5 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
        int i6 = cursor.getInt(cursor.getColumnIndex("message_stored_ext"));
        if (enumC0699nM3160a != EnumC0699n.ANICON && enumC0699nM3160a != EnumC0699n.IMAGE && enumC0699nM3160a != EnumC0699n.VIDEO) {
            c0484az.f2029K.setImageBitmap(null);
            c0484az.f2060t.setImageBitmap(null);
            this.f1962A.m6192a(c0484az.f2029K);
            this.f1962A.m6192a(c0484az.f2060t);
        }
        m2643b(c0484az);
        String strM2642b = m2642b(string3, string4);
        if (strM2642b == null) {
            strM2642b = string6;
        }
        String string9 = TextUtils.isEmpty(strM2642b) ? GlobalApplication.m3262c().getString(R.string.unknown) : strM2642b;
        String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
        if (cursor.getCount() > 1) {
            if (cursor.getPosition() != 0) {
                cursor.moveToPosition(cursor.getPosition() - 1);
            } else {
                cursor.moveToPosition(cursor.getPosition() + 1);
            }
            this.f1984d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")))).split(" ");
        }
        if (strArrSplit.length == 2) {
            this.f1981a = strArrSplit[0];
            this.f1982b = strArrSplit[1];
        }
        if (i5 == 0 && i3 != 0 && !string4.equals(string3)) {
            m2629a(c0484az.f2042b, position, this.f1984d, string4, c0484az.f2023E, this.f1981a, lValueOf.longValue(), c0484az.f2064x);
            z = true;
        } else {
            c0484az.f2064x.setVisibility(8);
            c0484az.f2023E.setVisibility(8);
            z = false;
        }
        if (C1789u.m6075a().getString("msisdn", "").equals(string3)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            c0484az.f2041a = String.valueOf(j);
        } else {
            c0484az.f2041a = string;
        }
        if (i3 != 0 && i3 != 3 && this.f1963B.getChoiceMode() == 2) {
            m2633a(c0484az, position, z2, this.f1981a);
        } else {
            c0484az.f2022D.setVisibility(8);
            c0484az.f2023E.setVisibility(8);
            c0484az.f2035Q.setVisibility(8);
            this.f1999s.clear();
        }
        if (enumC0699nM3160a != EnumC0699n.SYSTEM) {
            c0484az.f2066z.setVisibility(8);
            if (z2) {
                c0484az.f2052l.setVisibility(0);
                c0484az.f2053m.setVisibility(8);
                m2632a(c0484az, cursor.getPosition(), lValueOf);
                if (i3 == 0) {
                    c0484az.f2044d.setVisibility(8);
                    c0484az.f2038T.setVisibility(8);
                    if (enumC0699nM3160a != EnumC0699n.TEXT && enumC0699nM3160a != EnumC0699n.GEO && enumC0699nM3160a != EnumC0699n.ANICON) {
                        RunnableC0781e runnableC0781eM3336a = C0779c.m3335a().m3336a(j);
                        if (runnableC0781eM3336a != null) {
                            c0484az.f2037S.setVisibility(0);
                            ProgressBar progressBar = c0484az.f2037S;
                            runnableC0781eM3336a.m3353a(new HandlerC0478at(this, progressBar));
                            progressBar.setProgress(runnableC0781eM3336a.m3362i());
                            c0484az.f2036R.setVisibility(8);
                            c0484az.f2024F.setVisibility(0);
                        } else {
                            c0484az.f2037S.setVisibility(8);
                            if (i5 == 3) {
                                c0484az.f2036R.setVisibility(0);
                            } else {
                                c0484az.f2036R.setVisibility(8);
                            }
                            c0484az.f2024F.setVisibility(8);
                        }
                        c0484az.f2024F.setOnClickListener(new ViewOnClickListenerC0489bc(this, j, enumC0699nM3160a));
                    } else {
                        c0484az.f2037S.setVisibility(8);
                        c0484az.f2036R.setVisibility(0);
                        c0484az.f2024F.setVisibility(8);
                    }
                    if (GlobalApplication.m3265f()) {
                        c0484az.f2033O.setVisibility(8);
                    } else {
                        c0484az.f2033O.setVisibility(8);
                    }
                } else if (i3 == 1 || i3 == 4 || i3 == 2) {
                    c0484az.f2037S.setVisibility(8);
                    c0484az.f2036R.setVisibility(8);
                    c0484az.f2038T.setVisibility(8);
                    c0484az.f2024F.setVisibility(8);
                    c0484az.f2033O.setVisibility(0);
                    if (i2 > 0) {
                        c0484az.f2044d.setText("(" + i2 + ")");
                        c0484az.f2044d.setVisibility(0);
                    } else {
                        c0484az.f2044d.setVisibility(4);
                    }
                } else if (i3 == -1) {
                    c0484az.f2037S.setVisibility(8);
                    c0484az.f2036R.setVisibility(8);
                    C1786r.m6064d("MSG_TYPE_FAIL!!!!!!!!!!");
                    m2628a(view, c0484az, j, this.f2005z, enumC0699nM3160a);
                }
            } else {
                m2635a(c0484az, string5, string9, string3, i4);
                c0484az.f2052l.setVisibility(8);
                c0484az.f2053m.setVisibility(0);
                c0484az.f2066z.setVisibility(8);
                m2644b(c0484az, cursor.getPosition(), lValueOf);
                if (enumC0699nM3160a != EnumC0699n.TEXT && enumC0699nM3160a != EnumC0699n.GEO && enumC0699nM3160a != EnumC0699n.ANICON) {
                    if (i3 == 3) {
                        C0639k.m2914b(string4);
                        AsyncTaskC0608x asyncTaskC0608xM3330b = C0777a.m3326a().m3330b(Long.parseLong(string));
                        if (asyncTaskC0608xM3330b != null) {
                            c0484az.f2019A.setVisibility(0);
                            c0484az.f2020B.setVisibility(8);
                            c0484az.f2021C.setVisibility(0);
                            asyncTaskC0608xM3330b.m2792a(view);
                            c0484az.f2021C.setOnClickListener(new ViewOnClickListenerC0492bf(this, Long.parseLong(string)));
                        } else {
                            c0484az.f2019A.setVisibility(4);
                            c0484az.f2020B.setVisibility(4);
                            c0484az.f2021C.setVisibility(4);
                        }
                    } else {
                        c0484az.f2020B.setVisibility(4);
                        c0484az.f2019A.setVisibility(4);
                        c0484az.f2021C.setVisibility(4);
                    }
                    if (i3 != 4 && i3 != 3) {
                        c0484az.f2040V.setVisibility(0);
                        c0484az.f2040V.setOnClickListener(this);
                    } else {
                        c0484az.f2040V.setVisibility(8);
                    }
                } else {
                    c0484az.f2020B.setVisibility(4);
                    c0484az.f2019A.setVisibility(4);
                    c0484az.f2021C.setVisibility(4);
                    c0484az.f2040V.setVisibility(8);
                }
                if (enumC0699nM3160a != EnumC0699n.ANICON) {
                    int dimensionPixelSize = this.f2004y.getResources().getDimensionPixelSize(R.dimen.bubble_anicon_size);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0484az.f2060t.getLayoutParams();
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    c0484az.f2060t.setLayoutParams(layoutParams);
                    c0484az.f2060t.setScaleType(ImageView.ScaleType.FIT_XY);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0484az.f2029K.getLayoutParams();
                    layoutParams2.width = dimensionPixelSize;
                    layoutParams2.height = dimensionPixelSize;
                    c0484az.f2029K.setLayoutParams(layoutParams2);
                    c0484az.f2029K.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
            String[] strArr2 = new String[0];
            if (string2 == null) {
                strArr = strArr2;
                strSubstring = null;
            } else {
                String[] strArrSplit2 = string2.split("\n");
                if (strArrSplit2.length <= 6) {
                    strArr = strArrSplit2;
                    strSubstring = null;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i7 = 6; i7 < strArrSplit2.length; i7++) {
                        stringBuffer.append(strArrSplit2[i7] + "\n");
                    }
                    Log.d("sb", stringBuffer.toString());
                    strArr = strArrSplit2;
                    strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                }
            }
            if (z2) {
                this.f1992l = (int) c0484az.f2033O.getPaint().measureText(c0484az.f2033O.getText().toString());
                this.f1993m = (int) c0484az.f2044d.getPaint().measureText(c0484az.f2044d.getText().toString());
                this.f1994n = this.f1992l + this.f1993m;
                this.f1996p = this.f2004y.getResources().getDimensionPixelSize(R.dimen.bubble_img_marginLeft);
                this.f1997q = this.f2004y.getResources().getDimensionPixelSize(R.dimen.bubble_img_marginRight);
                if (!TextUtils.isEmpty(strSubstring)) {
                    this.f1995o = this.f2004y.getResources().getDimensionPixelSize(R.dimen.upload_progressbar_width);
                    this.f1995o += this.f2004y.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
                    this.f1994n = this.f1994n > this.f1995o ? this.f1994n : this.f1995o;
                }
                c0484az.f2026H.setMaxWidth(((this.f1970I - this.f1994n) - this.f1996p) - this.f1997q);
            } else {
                this.f1992l = (int) c0484az.f2065y.getPaint().measureText(c0484az.f2065y.getText().toString());
                this.f1992l = (int) c0484az.f2065y.getPaint().measureText(c0484az.f2065y.getText().toString());
                this.f1994n = this.f1992l;
                this.f1996p = this.f2004y.getResources().getDimensionPixelSize(R.dimen.bubble_img_marginLeft);
                this.f1997q = this.f2004y.getResources().getDimensionPixelSize(R.dimen.bubble_img_marginRight);
                this.f1998r = this.f2004y.getResources().getDimensionPixelSize(R.dimen.profile_image_size);
                Configuration configuration = this.f2004y.getResources().getConfiguration();
                if (!TextUtils.isEmpty(strSubstring)) {
                    this.f1995o = this.f2004y.getResources().getDimensionPixelSize(R.dimen.upload_progressbar_width);
                    this.f1995o += this.f2004y.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
                    this.f1995o += this.f1998r;
                    this.f1994n = this.f1994n > this.f1995o ? this.f1994n : this.f1995o;
                    if (configuration.orientation == 2) {
                        c0484az.f2057q.setMaxWidth(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    } else if (configuration.orientation == 1) {
                        c0484az.f2057q.setMaxWidth(120);
                    }
                } else if (configuration.orientation == 2) {
                    c0484az.f2057q.setMaxWidth(HttpResponseCode.INTERNAL_SERVER_ERROR);
                } else if (configuration.orientation == 1) {
                    c0484az.f2057q.setMaxWidth(HttpResponseCode.f7897OK);
                }
            }
            switch (enumC0699nM3160a) {
                case TEXT:
                    m2637a(c0484az, string2, z2, z);
                    break;
                case IMAGE:
                    if (string2 != null) {
                        C1786r.m6061b("token:" + Arrays.toString(strArr), getClass().getSimpleName());
                        if (i6 == 1 && !C1767bw.m6002a()) {
                            z3 = true;
                            str = string7;
                        } else if (i6 != 0 || !C1767bw.m6002a()) {
                            z3 = false;
                            str = string7;
                        } else {
                            if (z2) {
                                str2 = GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() + "/" + string4 + "/" + strArr[3];
                            } else {
                                str2 = GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() + "/" + string4 + "/thumbnail//" + strArr[3];
                            }
                            if (!C1783o.m6039b(str2)) {
                                z3 = true;
                                str = string7;
                            } else {
                                String string10 = Uri.fromFile(new File(str2)).toString();
                                C0665i.m3058a(GlobalApplication.m3260b().getContentResolver(), string3, string4, Long.valueOf(Long.parseLong(string)), string10, this.f2005z, true, true);
                                z3 = false;
                                str = string10;
                            }
                        }
                        if (z3) {
                            if (i5 == 2) {
                                str = C0452a.f1724c;
                            } else {
                                new AsyncTaskC0607w(strArr[2], strArr[4], strArr[3], true, string4, Long.parseLong(string), EnumC0695j.ONETOONE, string3).execute(new String[0]);
                                str = null;
                            }
                        }
                    } else {
                        str = string7;
                    }
                    m2639a(c0484az, str, z2, z, z2 ? String.valueOf(j) : string, strSubstring);
                    break;
                case VIDEO:
                    m2638a(c0484az, string7, z2, z, strSubstring);
                    break;
                case AUDIO:
                    m2646b(c0484az, string2, z2, z);
                    break;
                case CALENDAR:
                    m2636a(c0484az, string2, z2, string8, z);
                    break;
                case ANICON:
                    m2651c(c0484az, string2, z2, z);
                    break;
                case DOCUMENT:
                    m2645b(c0484az, string2, z2, string8, z);
                    break;
                case CONTACT:
                    m2650c(c0484az, string2, z2, string8, z);
                    break;
                case GEO:
                    m2647b(c0484az, string2, z2, z, strSubstring);
                    break;
                case UNDEFINED:
                    m2637a(c0484az, this.f2004y.getString(R.string.toast_supported_format), z2, z);
                    break;
            }
        } else {
            m2634a(c0484az, string5, string9, string2);
        }
        view.setTag(c0484az);
    }

    /* renamed from: b */
    private String m2642b(String str, String str2) {
        Cursor cursorQuery = this.f2004y.getContentResolver().query(C0698m.f2626a, new String[]{"message_content"}, "message_inbox_no='" + str2 + "'", null, null);
        if (cursorQuery != null) {
            String strM2689b = null;
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
                if (string != null) {
                    String[] strArrSplit = string.split(";");
                    if (strArrSplit.length > 0) {
                        int length = strArrSplit.length;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                String[] strArrSplit2 = strArrSplit[i].split(",");
                                if (strArrSplit2.length > 2) {
                                    try {
                                        if (strArrSplit2[1].trim().equals(str)) {
                                            strM2689b = C0493bg.m2689b(strArrSplit2[2].replace('\n', ' '));
                                            break;
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                                i++;
                            }
                        }
                    }
                }
            }
            cursorQuery.close();
            if (strM2689b != null) {
                return strM2689b;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m2633a(C0484az c0484az, int i, boolean z, String str) {
        boolean z2;
        if (!TextUtils.isEmpty(c0484az.f2041a)) {
            if (z) {
                c0484az.f2035Q.setVisibility(0);
                c0484az.f2035Q.setOnClickListener(new ViewOnClickListenerC0479au(this, c0484az, str));
                if (this.f1978Q == EnumC0487ba.SELECT_ALL || this.f1979R == EnumC0487ba.SELECT_ALL) {
                    this.f1972K.put(Long.valueOf(c0484az.f2041a), true);
                    c0484az.f2035Q.setChecked(true);
                } else if (!this.f1972K.isEmpty() && this.f1972K.containsKey(Long.valueOf(c0484az.f2041a))) {
                    c0484az.f2035Q.setChecked(((Boolean) this.f1972K.get(Long.valueOf(c0484az.f2041a))).booleanValue());
                } else {
                    z2 = this.f1979R == EnumC0487ba.SELECT_PART || this.f1978Q == EnumC0487ba.SELECT_PART;
                    this.f1972K.put(Long.valueOf(c0484az.f2041a), Boolean.valueOf(z2));
                    c0484az.f2035Q.setChecked(z2);
                }
                m2663a(c0484az.f2035Q, c0484az.f2023E, str);
                return;
            }
            c0484az.f2022D.setVisibility(0);
            c0484az.f2022D.setOnClickListener(new ViewOnClickListenerC0480av(this, c0484az, str));
            if (this.f1978Q == EnumC0487ba.SELECT_ALL || this.f1980S == EnumC0487ba.SELECT_ALL) {
                this.f1973L.put(Long.valueOf(c0484az.f2041a), true);
                c0484az.f2022D.setChecked(true);
            } else if (!this.f1973L.isEmpty() && this.f1973L.containsKey(Long.valueOf(c0484az.f2041a))) {
                c0484az.f2022D.setChecked(((Boolean) this.f1973L.get(Long.valueOf(c0484az.f2041a))).booleanValue());
            } else {
                z2 = this.f1980S == EnumC0487ba.SELECT_PART || this.f1978Q == EnumC0487ba.SELECT_PART;
                this.f1973L.put(Long.valueOf(c0484az.f2041a), Boolean.valueOf(z2));
                c0484az.f2022D.setChecked(z2);
            }
            m2663a(c0484az.f2022D, c0484az.f2023E, str);
        }
    }

    /* renamed from: a */
    private void m2628a(View view, C0484az c0484az, long j, EnumC0695j enumC0695j, EnumC0699n enumC0699n) {
        c0484az.f2036R.setVisibility(8);
        c0484az.f2024F.setVisibility(8);
        c0484az.f2038T.setVisibility(0);
        if (GlobalApplication.m3265f()) {
            c0484az.f2033O.setVisibility(8);
        } else {
            c0484az.f2033O.setVisibility(8);
        }
        c0484az.f2044d.setVisibility(4);
        if (this.f1967F) {
            if (enumC0695j == EnumC0695j.ONETOONE && enumC0699n == EnumC0699n.TEXT) {
                c0484az.f2038T.setOnClickListener(new ViewOnClickListenerC0490bd(this, j, true));
            } else {
                c0484az.f2038T.setOnClickListener(new ViewOnClickListenerC0490bd(this, j, false));
            }
        }
    }

    /* renamed from: a */
    private void m2632a(C0484az c0484az, int i, Long l) {
        if (this.f1982b != null) {
            c0484az.f2033O.setVisibility(0);
            String str = "h:mm aa";
            if (DateFormat.is24HourFormat(this.f2004y)) {
                str = "HH:mm";
            }
            c0484az.f2033O.setText(C1769by.m6006a(l.longValue(), str));
            return;
        }
        c0484az.f2033O.setVisibility(8);
    }

    /* renamed from: b */
    private void m2644b(C0484az c0484az, int i, Long l) {
        if (this.f1982b != null) {
            c0484az.f2065y.setVisibility(0);
            String str = "h:mm aa";
            if (DateFormat.is24HourFormat(this.f2004y)) {
                str = "HH:mm";
            }
            c0484az.f2065y.setText(C1769by.m6006a(l.longValue(), str));
            return;
        }
        c0484az.f2065y.setVisibility(8);
    }

    /* renamed from: a */
    private void m2629a(TextView textView, int i, String[] strArr, String str, CheckBox checkBox, String str2, long j, RelativeLayout relativeLayout) {
        if (i == 0) {
            relativeLayout.setVisibility(0);
            textView.setText(java.text.DateFormat.getDateInstance(1, GlobalApplication.m3262c().getConfiguration().locale).format(new Date(j)));
            if (this.f1963B.getChoiceMode() == 2) {
                checkBox.setVisibility(0);
                checkBox.setOnClickListener(new ViewOnClickListenerC0488bb(this, checkBox, str2));
            }
        } else if (this.f1981a.equals(strArr[0])) {
            relativeLayout.setVisibility(8);
            if (this.f1963B.getChoiceMode() == 2) {
                checkBox.setVisibility(8);
                checkBox.setOnClickListener(new ViewOnClickListenerC0488bb(this, checkBox, str2));
            }
        } else {
            relativeLayout.setVisibility(0);
            textView.setText(C1769by.m6006a(System.currentTimeMillis(), "yyyy.MM.dd"));
            textView.setText(str2);
            if (this.f1963B.getChoiceMode() == 2) {
                checkBox.setVisibility(0);
                checkBox.setOnClickListener(new ViewOnClickListenerC0488bb(this, checkBox, str2));
            }
        }
        textView.setOnLongClickListener(new ViewOnLongClickListenerC0481aw(this));
        textView.setOnClickListener(new ViewOnClickListenerC0482ax(this, str, str2));
    }

    /* renamed from: a */
    private void m2635a(C0484az c0484az, String str, String str2, String str3, int i) {
        ProfileImageView profileImageView = (ProfileImageView) c0484az.f2055o;
        if (str != null) {
            if (this.f1967F) {
                C1746bb.m5945a(this.f2004y).m5960a(profileImageView, str, i);
            } else {
                C1746bb.m5945a(this.f2004y).m5958a(profileImageView, EnumC1748bd.BUDDY);
            }
            profileImageView.setOnClickListener(new ViewOnClickListenerC0491be(this, profileImageView, str, str2));
            c0484az.f2054n.setText(str2);
            return;
        }
        C1746bb.m5945a(this.f2004y).m5958a(profileImageView, EnumC1748bd.BUDDY);
        c0484az.f2054n.setText(GlobalApplication.m3262c().getString(R.string.unknown));
    }

    /* renamed from: a */
    private void m2634a(C0484az c0484az, String str, String str2, String str3) throws Resources.NotFoundException {
        String str4;
        c0484az.f2052l.setVisibility(8);
        c0484az.f2053m.setVisibility(8);
        c0484az.f2066z.setVisibility(0);
        String[] strArrSplit = str3.split(";");
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length > 0) {
            EnumC0705t enumC0705tM3169a = EnumC0705t.UNKNOWN;
            for (String str5 : strArrSplit) {
                String[] strArrSplit2 = str5.split(",");
                if (strArrSplit2.length > 2) {
                    try {
                        enumC0705tM3169a = EnumC0705t.m3169a(Integer.parseInt(strArrSplit2[0]));
                        sb.append(C0493bg.m2689b(strArrSplit2[2].replace('\n', ' '))).append(",");
                    } catch (Exception e) {
                        C1786r.m6054a("Caught Exception while parsing system message " + str5, getClass().getSimpleName());
                    }
                }
            }
            String string = "";
            if (enumC0705tM3169a == EnumC0705t.ENTER) {
                if (TextUtils.isEmpty(str2)) {
                    string = GlobalApplication.m3262c().getString(R.string.chat_view_system_invite);
                } else {
                    string = GlobalApplication.m3262c().getString(R.string.chat_view_system_invite_2);
                }
            } else if (enumC0705tM3169a == EnumC0705t.LEAVE) {
                string = GlobalApplication.m3262c().getString(R.string.chat_view_system_leave);
            } else if (enumC0705tM3169a == EnumC0705t.INVITE) {
                string = GlobalApplication.m3262c().getString(R.string.noti_invite_member);
            } else if (enumC0705tM3169a == EnumC0705t.INVALID_USER) {
                string = GlobalApplication.m3262c().getString(R.string.toast_chat_change_account_info);
            } else if (enumC0705tM3169a == EnumC0705t.MEMBER) {
                string = GlobalApplication.m3262c().getString(R.string.chat_view_chat_member);
                c0484az.f2043c.setLayoutParams(new RelativeLayout.LayoutParams(400, -2));
                c0484az.f2043c.setGravity(17);
            }
            if (string.length() <= 0) {
                str4 = "";
            } else if (sb.length() > 1) {
                if (!TextUtils.isEmpty(str2) && enumC0705tM3169a == EnumC0705t.ENTER) {
                    str4 = String.format(string, str2, sb.substring(0, sb.length() - 1));
                } else {
                    str4 = String.format(string, sb.substring(0, sb.length() - 1));
                }
            } else {
                str4 = String.format(string, GlobalApplication.m3262c().getString(R.string.unknown));
            }
        } else {
            str4 = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            c0484az.f2043c.setText(str4);
        }
    }

    /* renamed from: a */
    private void m2637a(C0484az c0484az, String str, boolean z, boolean z2) {
        m2631a(c0484az);
        Float fValueOf = this.f2000t;
        if (!TextUtils.isEmpty(str) && !"#".equals(str.trim()) && str.charAt(0) == '#') {
            str = new StringBuilder(str).substring(1);
            fValueOf = Float.valueOf(this.f2004y.getResources().getDimension(R.dimen.font_size_big_text));
            if (C1786r.f6452b) {
                C1786r.m6061b(str, "ChatListAdapter");
            }
        }
        CharSequence charSequenceM3825a = C0968n.m3825a(this.f2004y, str, (int) C1722ae.m5894a(26.0f));
        C0968n.m3826a(this.f2004y, str, "%8|3&");
        if (z) {
            if (str == null || str == "") {
                C1786r.m6061b("Abhishek, setText pos 1", getClass().getSimpleName());
                c0484az.f2026H.setText(str);
                c0484az.f2026H.setTextSize(1, fValueOf.floatValue());
            } else {
                c0484az.f2026H.setTextSize(1, fValueOf.floatValue());
                C1786r.m6061b("Abhishek, setText pos 2", getClass().getSimpleName());
                c0484az.f2026H.setText(charSequenceM3825a);
            }
            c0484az.f2026H.setTextColor(-16777216);
            c0484az.f2026H.setVisibility(0);
            c0484az.f2029K.setVisibility(8);
            c0484az.f2030L.setVisibility(8);
            return;
        }
        c0484az.f2054n.setVisibility(0);
        c0484az.f2065y.setVisibility(0);
        if (str == null || str == "") {
            c0484az.f2057q.setText(str);
            c0484az.f2057q.setTextSize(1, fValueOf.floatValue());
        } else {
            c0484az.f2057q.setTextSize(1, fValueOf.floatValue());
            c0484az.f2057q.setText(charSequenceM3825a);
        }
        c0484az.f2057q.setTextColor(-16777216);
        c0484az.f2057q.setVisibility(0);
        c0484az.f2060t.setVisibility(8);
        c0484az.f2061u.setVisibility(8);
        c0484az.f2039U.setVisibility(8);
    }

    /* renamed from: a */
    private void m2631a(C0484az c0484az) {
        m2643b(c0484az);
    }

    /* renamed from: a */
    private void m2639a(C0484az c0484az, String str, boolean z, boolean z2, String str2, String str3) {
        m2631a(c0484az);
        if (z) {
            C1786r.m6064d("Uri.parse(content):" + str);
            C0983a c0983a = new C0983a(str2 + str, str, true, true);
            c0983a.m6172a((View) c0484az.f2029K);
            this.f1962A.m6190a(c0484az.f2029K, c0983a);
            if (str == null) {
                c0484az.f2029K.setImageBitmap(null);
            } else if (C0452a.f1724c.equals(str)) {
                c0484az.f2029K.setImageResource(R.drawable.slideshow_error_top);
            }
            c0484az.f2029K.setOnClickListener(this);
            c0484az.f2026H.setTextSize(0, this.f2000t.floatValue());
            if (TextUtils.isEmpty(str3)) {
                c0484az.f2026H.setVisibility(8);
            } else {
                c0484az.f2026H.setText(C0968n.m3825a(this.f2004y, str3, (int) C1722ae.m5894a(26.0f)));
                c0484az.f2026H.setVisibility(0);
            }
            c0484az.f2030L.setVisibility(8);
            c0484az.f2029K.setVisibility(0);
            return;
        }
        C0983a c0983a2 = new C0983a(str2 + str, str, true, true);
        c0983a2.m6172a((View) c0484az.f2060t);
        this.f1962A.m6190a(c0484az.f2060t, c0983a2);
        C1786r.m6064d("Uri.parse(content):" + str);
        if (C0452a.f1724c.equals(str)) {
            c0484az.f2060t.setImageResource(R.drawable.slideshow_error_top);
            c0484az.f2060t.setOnClickListener(this);
        } else if (str != null) {
            if (GlobalApplication.m3265f()) {
            }
            c0484az.f2060t.setOnClickListener(this);
            c0484az.f2057q.setTextSize(0, this.f2000t.floatValue());
        }
        if (TextUtils.isEmpty(str3)) {
            c0484az.f2057q.setVisibility(8);
        } else {
            c0484az.f2057q.setText(C0968n.m3825a(this.f2004y, str3, (int) C1722ae.m5894a(26.0f)));
            c0484az.f2057q.setVisibility(0);
        }
        if (str == null) {
            c0484az.f2060t.setVisibility(8);
            c0484az.f2039U.setVisibility(0);
        } else {
            c0484az.f2060t.setVisibility(0);
            c0484az.f2039U.setVisibility(8);
        }
        c0484az.f2061u.setVisibility(8);
    }

    /* renamed from: b */
    private void m2646b(C0484az c0484az, String str, boolean z, boolean z2) {
        m2631a(c0484az);
        if (z) {
            c0484az.f2031M.setImageResource(R.drawable.message_chat_audio);
            c0484az.f2031M.setOnClickListener(this);
            c0484az.f2032N.setVisibility(8);
            c0484az.f2031M.setVisibility(0);
            c0484az.f2030L.setVisibility(0);
            c0484az.f2029K.setVisibility(8);
            c0484az.f2026H.setVisibility(8);
            return;
        }
        c0484az.f2062v.setImageResource(R.drawable.message_chat_audio);
        c0484az.f2062v.setOnClickListener(this);
        c0484az.f2063w.setVisibility(8);
        c0484az.f2062v.setVisibility(0);
        c0484az.f2061u.setVisibility(0);
        c0484az.f2060t.setVisibility(8);
        c0484az.f2057q.setVisibility(8);
        c0484az.f2039U.setVisibility(8);
    }

    /* renamed from: a */
    private void m2638a(C0484az c0484az, String str, boolean z, boolean z2, String str2) {
        Bitmap bitmapCreateScaledBitmap = null;
        if (str != null && str.contains("file://")) {
            str = str.substring(7);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 3);
                if (bitmapCreateVideoThumbnail != null) {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateVideoThumbnail, 120, 120, true);
                }
            } catch (OutOfMemoryError e) {
                Toast.makeText(this.f2004y, R.string.chat_view_memory_error, 0).show();
            }
        }
        C1786r.m6061b("*********** video file path : " + str, null);
        m2631a(c0484az);
        if (z) {
            if (bitmapCreateScaledBitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f2004y.getResources(), bitmapCreateScaledBitmap);
                BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.f2004y.getResources().getDrawable(R.drawable.chaton_icon_play);
                bitmapDrawable2.setGravity(17);
                c0484az.f2029K.setImageDrawable(new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable2}));
            } else {
                c0484az.f2029K.setImageResource(R.drawable.messenger_chat_video);
            }
            c0484az.f2029K.setOnClickListener(this);
            if (TextUtils.isEmpty(str2)) {
                c0484az.f2026H.setVisibility(8);
            } else {
                C1786r.m6061b("Abhishek, setText pos 5", getClass().getSimpleName());
                c0484az.f2026H.setText(C0968n.m3825a(this.f2004y, str2, (int) C1722ae.m5894a(26.0f)));
                c0484az.f2026H.setVisibility(0);
            }
            c0484az.f2030L.setVisibility(8);
            c0484az.f2029K.setVisibility(0);
            c0484az.f2039U.setVisibility(8);
            return;
        }
        if (bitmapCreateScaledBitmap != null) {
            BitmapDrawable bitmapDrawable3 = new BitmapDrawable(this.f2004y.getResources(), bitmapCreateScaledBitmap);
            BitmapDrawable bitmapDrawable4 = (BitmapDrawable) this.f2004y.getResources().getDrawable(R.drawable.chaton_icon_play);
            bitmapDrawable4.setGravity(17);
            c0484az.f2060t.setImageDrawable(new LayerDrawable(new Drawable[]{bitmapDrawable3, bitmapDrawable4}));
        } else {
            c0484az.f2060t.setImageResource(R.drawable.messenger_chat_video);
        }
        c0484az.f2060t.setOnClickListener(this);
        c0484az.f2057q.setTextSize(0, this.f2000t.floatValue());
        if (TextUtils.isEmpty(str2)) {
            c0484az.f2057q.setVisibility(8);
        } else {
            c0484az.f2057q.setText(C0968n.m3825a(this.f2004y, str2, (int) C1722ae.m5894a(26.0f)));
            c0484az.f2057q.setVisibility(0);
        }
        c0484az.f2061u.setVisibility(8);
        c0484az.f2060t.setVisibility(0);
        c0484az.f2039U.setVisibility(8);
    }

    /* renamed from: b */
    private void m2647b(C0484az c0484az, String str, boolean z, boolean z2, String str2) {
        m2631a(c0484az);
        if (z) {
            if (C0452a.m2468a()) {
                c0484az.f2031M.setImageResource(R.drawable.message_chat_location);
            } else {
                c0484az.f2031M.setImageResource(R.drawable.message_chat_location_error);
            }
            c0484az.f2031M.setOnClickListener(this);
            c0484az.f2031M.setVisibility(0);
            c0484az.f2030L.setVisibility(0);
            c0484az.f2030L.setOrientation(1);
            if (TextUtils.isEmpty(str2)) {
                c0484az.f2032N.setVisibility(8);
            } else {
                c0484az.f2032N.setText(str2);
                c0484az.f2032N.setVisibility(0);
            }
            c0484az.f2029K.setVisibility(8);
            c0484az.f2026H.setVisibility(8);
            return;
        }
        if (C0452a.m2468a()) {
            c0484az.f2062v.setImageResource(R.drawable.message_chat_location);
        } else {
            c0484az.f2062v.setImageResource(R.drawable.message_chat_location_error);
        }
        c0484az.f2062v.setOnClickListener(this);
        c0484az.f2062v.setVisibility(0);
        c0484az.f2061u.setVisibility(0);
        c0484az.f2061u.setOrientation(1);
        if (TextUtils.isEmpty(str2)) {
            c0484az.f2063w.setVisibility(8);
        } else {
            c0484az.f2063w.setText(str2);
            c0484az.f2063w.setVisibility(0);
        }
        c0484az.f2060t.setVisibility(8);
        c0484az.f2057q.setVisibility(8);
        c0484az.f2039U.setVisibility(8);
    }

    /* renamed from: a */
    private void m2636a(C0484az c0484az, String str, boolean z, String str2, boolean z2) {
        m2631a(c0484az);
        if (z) {
            c0484az.f2031M.setImageResource(R.drawable.message_chat_calender);
            c0484az.f2031M.setOnClickListener(this);
            c0484az.f2032N.setText(str2);
            c0484az.f2032N.setVisibility(0);
            c0484az.f2031M.setVisibility(0);
            c0484az.f2030L.setVisibility(0);
            c0484az.f2030L.setOrientation(1);
            c0484az.f2029K.setVisibility(8);
            c0484az.f2026H.setVisibility(8);
            return;
        }
        c0484az.f2062v.setImageResource(R.drawable.message_chat_calender);
        c0484az.f2062v.setOnClickListener(this);
        c0484az.f2062v.setVisibility(0);
        c0484az.f2060t.setVisibility(8);
        c0484az.f2057q.setVisibility(8);
        c0484az.f2063w.setText(str2);
        c0484az.f2063w.setVisibility(0);
        c0484az.f2061u.setVisibility(0);
        c0484az.f2061u.setOrientation(1);
        c0484az.f2039U.setVisibility(8);
    }

    /* renamed from: b */
    private void m2645b(C0484az c0484az, String str, boolean z, String str2, boolean z2) {
        m2631a(c0484az);
        EnumC0905b enumC0905bM3631b = EnumC0905b.DOC;
        if (!TextUtils.isEmpty(str2)) {
            enumC0905bM3631b = FileExplorerActivity.m3631b(str2.substring(str2.lastIndexOf(".") + 1));
        }
        if (z) {
            c0484az.f2031M.setImageResource(((Integer) f1960T.get(enumC0905bM3631b)).intValue());
            c0484az.f2031M.setOnClickListener(this);
            c0484az.f2032N.setText(str2);
            c0484az.f2032N.setVisibility(0);
            c0484az.f2031M.setVisibility(0);
            c0484az.f2030L.setVisibility(0);
            c0484az.f2030L.setOrientation(1);
            c0484az.f2029K.setVisibility(8);
            c0484az.f2026H.setVisibility(8);
            return;
        }
        c0484az.f2062v.setImageResource(((Integer) f1960T.get(enumC0905bM3631b)).intValue());
        c0484az.f2062v.setOnClickListener(this);
        c0484az.f2063w.setText(str2);
        c0484az.f2063w.setVisibility(0);
        c0484az.f2062v.setVisibility(0);
        c0484az.f2061u.setVisibility(0);
        c0484az.f2061u.setOrientation(1);
        c0484az.f2060t.setVisibility(8);
        c0484az.f2057q.setVisibility(8);
        c0484az.f2039U.setVisibility(8);
    }

    /* renamed from: c */
    private void m2651c(C0484az c0484az, String str, boolean z, boolean z2) {
        ImageView imageView;
        String[] strArrSplit;
        if (z) {
            C1786r.m6064d("Uri.parse(content):" + str);
            c0484az.f2025G.setBackgroundColor(0);
            imageView = c0484az.f2029K;
            c0484az.f2029K.setOnClickListener(this);
            c0484az.f2026H.setVisibility(8);
            c0484az.f2029K.setVisibility(0);
            c0484az.f2030L.setVisibility(8);
        } else {
            imageView = c0484az.f2060t;
            c0484az.f2056p.setBackgroundColor(0);
            C1786r.m6064d("Uri.parse(content):" + str);
            c0484az.f2060t.setOnClickListener(this);
            c0484az.f2057q.setVisibility(8);
            c0484az.f2061u.setVisibility(8);
            if (str == null) {
                c0484az.f2060t.setVisibility(8);
                c0484az.f2039U.setVisibility(0);
            } else {
                c0484az.f2060t.setVisibility(0);
                c0484az.f2039U.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split("\n")) != null && strArrSplit.length >= 3) {
            try {
                this.f1962A.m6190a(imageView, new CallableC0916aa(C0921d.m3797c(strArrSplit[2]), 116, 116));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m2650c(C0484az c0484az, String str, boolean z, String str2, boolean z2) {
        m2631a(c0484az);
        if (z) {
            c0484az.f2031M.setImageResource(R.drawable.message_chat_contact);
            c0484az.f2031M.setOnClickListener(this);
            c0484az.f2032N.setText(str2);
            c0484az.f2032N.setVisibility(0);
            c0484az.f2031M.setVisibility(0);
            c0484az.f2029K.setVisibility(8);
            c0484az.f2026H.setVisibility(8);
            c0484az.f2030L.setVisibility(0);
            c0484az.f2030L.setOrientation(1);
            return;
        }
        c0484az.f2062v.setImageResource(R.drawable.message_chat_contact);
        c0484az.f2062v.setOnClickListener(this);
        c0484az.f2063w.setText(str2);
        c0484az.f2063w.setVisibility(0);
        c0484az.f2062v.setVisibility(0);
        c0484az.f2060t.setVisibility(8);
        c0484az.f2057q.setVisibility(8);
        c0484az.f2061u.setVisibility(0);
        c0484az.f2061u.setOrientation(1);
        c0484az.f2039U.setVisibility(8);
    }

    /* renamed from: a */
    public void m2663a(CheckBox checkBox, CheckBox checkBox2, String str) {
        Boolean bool;
        String string;
        if (!checkBox.isChecked()) {
            Boolean bool2 = false;
            if (this.f1978Q == EnumC0487ba.SELECT_ALL || this.f1978Q == EnumC0487ba.SELECT_PART || this.f1980S == EnumC0487ba.SELECT_ALL || this.f1980S == EnumC0487ba.SELECT_PART || this.f1979R == EnumC0487ba.SELECT_ALL || this.f1979R == EnumC0487ba.SELECT_PART) {
                bool2 = true;
            } else {
                if (this.f1972K != null && !this.f1972K.isEmpty()) {
                    Iterator it = this.f1972K.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                            bool2 = true;
                            break;
                        }
                    }
                }
                if (!bool2.booleanValue() && this.f1973L != null && !this.f1973L.isEmpty()) {
                    Iterator it2 = this.f1973L.entrySet().iterator();
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
            this.f1969H.setEnabled(bool2.booleanValue());
            bool = false;
        } else {
            int i = 0;
            while (true) {
                if (i >= this.f1963B.getAdapter().getCount()) {
                    bool = true;
                    break;
                }
                Cursor cursor = (Cursor) this.f1963B.getAdapter().getItem(i);
                Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
                EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
                if (enumC0699nM3160a != EnumC0699n.SYSTEM && strArrSplit[0].equals(str) && (string = cursor.getString(cursor.getColumnIndex("message_sender"))) != null) {
                    if (string.equals(C1789u.m6075a().getString("msisdn", ""))) {
                        Boolean bool3 = (Boolean) this.f1972K.get(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
                        if (bool3 != null && !bool3.booleanValue()) {
                            bool = false;
                            break;
                        }
                    } else {
                        Boolean bool4 = (Boolean) this.f1973L.get(Long.valueOf(Long.valueOf(cursor.getString(cursor.getColumnIndex("message_sever_id"))).longValue()));
                        if (bool4 != null && !bool4.booleanValue()) {
                            bool = false;
                            break;
                        }
                    }
                }
                i++;
            }
            this.f1969H.setEnabled(true);
        }
        if (bool.booleanValue()) {
            if (!this.f1999s.contains(str)) {
                this.f1999s.add(str);
            }
            checkBox2.setChecked(true);
        } else {
            if (this.f1999s.contains(str)) {
                this.f1999s.remove(str);
            }
            checkBox2.setChecked(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1968G.mo2589a(view);
    }

    /* renamed from: a */
    public static void m2630a(ChatFragment chatFragment, EnumC0699n enumC0699n, String str, ProgressDialog progressDialog, long j) {
        if (enumC0699n != EnumC0699n.IMAGE && (str == null || C0452a.f1724c.equals(str))) {
            Toast.makeText(chatFragment.getActivity(), R.string.media_download_fail, 0).show();
            return;
        }
        C1786r.m6064d("file uri:" + str);
        if (!TextUtils.isEmpty(str) && str.startsWith("file:") && enumC0699n != EnumC0699n.AUDIO) {
            str = str.substring(6);
        }
        C1786r.m6064d("Download_uri:" + str);
        if (enumC0699n == EnumC0699n.CALENDAR) {
            if (str != null) {
                Intent intent = new Intent(chatFragment.getActivity(), (Class<?>) VCalendarDetailActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                intent.putExtra("URI", str);
                chatFragment.startActivity(intent);
                return;
            }
            return;
        }
        if (enumC0699n == EnumC0699n.DOCUMENT) {
            if (str != null) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse("file://" + str), FileExplorerActivity.m3628a(str.substring(str.lastIndexOf(".") + 1)));
                if (BuddyProfileActivity.m2103a(chatFragment.getActivity(), intent2)) {
                    chatFragment.startActivity(intent2);
                    return;
                } else {
                    C2153y.m7535a(chatFragment.getActivity(), R.string.popup_install_office_viewer, 0).show();
                    return;
                }
            }
            return;
        }
        if (enumC0699n == EnumC0699n.CONTACT) {
            if (str != null) {
                Intent intent3 = new Intent(chatFragment.getActivity(), (Class<?>) ReadVCardActivity.class);
                intent3.putExtra("URI", str);
                intent3.putExtra("VCARD_SAVE", true);
                chatFragment.startActivity(intent3);
                return;
            }
            return;
        }
        if (enumC0699n == EnumC0699n.AUDIO) {
            if (!C1767bw.m6002a()) {
                Toast.makeText(chatFragment.getActivity(), R.string.sdcard_not_found, 0).show();
                return;
            }
            Intent intent4 = new Intent();
            intent4.setAction("android.intent.action.VIEW");
            intent4.setDataAndType(Uri.parse(str), "audio/*");
            intent4.putExtra(ChatFragment.f1748d, str);
            intent4.putExtra(PlayAudio.f3207a, PlayAudio.f3209c);
            chatFragment.startActivity(intent4);
            return;
        }
        if (enumC0699n == EnumC0699n.VIDEO) {
            if (!C1767bw.m6002a()) {
                Toast.makeText(chatFragment.getActivity(), R.string.sdcard_not_found, 0).show();
                return;
            }
            Intent intent5 = new Intent(chatFragment.getActivity(), (Class<?>) VideoPreviewActivity.class);
            intent5.putExtra("URI", str);
            chatFragment.startActivityForResult(intent5, 14);
            return;
        }
        if (enumC0699n == EnumC0699n.IMAGE) {
            int iVipAMS_IsAMSJPEGFile = -1;
            if (!TextUtils.isEmpty(str)) {
                AMSLibs aMSLibs = new AMSLibs();
                aMSLibs.VipAMS_Init();
                AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
                AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
                ams_coding_file_infoArr[0].setM_eExportType(0);
                ams_coding_file_infoArr[0].setM_strFileName(str);
                iVipAMS_IsAMSJPEGFile = aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr);
            }
            if (iVipAMS_IsAMSJPEGFile == 0) {
                Intent intent6 = new Intent(chatFragment.getActivity(), (Class<?>) AMSPlayerActivity.class);
                intent6.putExtra("AMS_FILE_PATH", str);
                intent6.putExtra("VIEWER_MODE", 1002);
                chatFragment.startActivity(intent6);
                return;
            }
            Intent intent7 = new Intent(chatFragment.getActivity(), (Class<?>) ViewOriginalImage.class);
            intent7.putExtra("uri", str);
            intent7.putExtra("messageId", j);
            intent7.putExtra(C0452a.f1727f, true);
            chatFragment.startActivityForResult(intent7, 13);
            return;
        }
        if (enumC0699n == EnumC0699n.GEO) {
            if (!C0452a.m2468a()) {
                C2153y.m7535a(chatFragment.getActivity(), R.string.toast_googleMAP_unavailable, 0).show();
                return;
            } else {
                if (!TextUtils.isEmpty(str)) {
                    String[] strArrSplit = str.split("\n");
                    Intent intent8 = new Intent(chatFragment.getActivity(), (Class<?>) GeotagActivity.class);
                    intent8.putExtra("Geo Point", strArrSplit[5]);
                    chatFragment.getActivity().startActivity(intent8);
                    return;
                }
                return;
            }
        }
        chatFragment.startActivity(new Intent("android.intent.action.VIEW"));
    }

    /* renamed from: b */
    private void m2643b(C0484az c0484az) {
        if (!TextUtils.isEmpty(this.f1964C) && !TextUtils.isEmpty(this.f1965D)) {
            c0484az.f2056p.setBackgroundDrawable(m2655g());
            c0484az.f2025G.setBackgroundDrawable(m2657h());
        }
    }

    /* renamed from: g */
    private Drawable m2655g() {
        if (this.f1977P == null) {
            this.f1977P = C1003c.m3952i(this.f2004y, this.f1965D);
        }
        return this.f1977P != null ? this.f1977P.getConstantState().newDrawable() : this.f2004y.getResources().getDrawable(R.drawable.bubble_receive_01_normal);
    }

    /* renamed from: h */
    private Drawable m2657h() {
        if (this.f1976O == null) {
            this.f1976O = C1003c.m3950g(this.f2004y, this.f1964C);
        }
        return this.f1976O != null ? this.f1976O.getConstantState().newDrawable() : this.f2004y.getResources().getDrawable(R.drawable.bubble_send_01_normal);
    }

    /* renamed from: a */
    public void m2666a(String str, String str2) {
        this.f1964C = str;
        this.f1965D = str2;
    }
}
