package com.sec.chaton.msgbox;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.widget.C0266z;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.CheckableRelativeLayout;
import com.sec.chaton.widget.WeightHorizontalLayout;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.a */
/* loaded from: classes.dex */
public class C2608a extends C0266z {

    /* renamed from: m */
    public static final String[] f9415m = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: r */
    private static int f9416r = 0;

    /* renamed from: n */
    public ArrayList<Integer> f9417n;

    /* renamed from: o */
    InterfaceC2211y f9418o;

    /* renamed from: p */
    private LayoutInflater f9419p;

    /* renamed from: q */
    private int f9420q;

    /* renamed from: s */
    private String f9421s;

    /* renamed from: t */
    private String f9422t;

    /* renamed from: u */
    private boolean f9423u;

    /* renamed from: v */
    private DateFormat f9424v;

    /* renamed from: w */
    private DateFormat f9425w;

    /* renamed from: x */
    private int f9426x;

    /* renamed from: a */
    public void m11157a(C5007c c5007c) {
    }

    public C2608a(Context context, ListView listView, int i, Cursor cursor, C5007c c5007c, SlookAirButton.ItemSelectListener itemSelectListener) {
        super(context, i, cursor, f9415m, null, -1);
        this.f9421s = null;
        this.f9423u = false;
        this.f9426x = 0;
        this.f9418o = new C2635b(this);
        this.f9419p = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f9420q = i;
        this.f9417n = new ArrayList<>();
        m11160c();
        f9416r = -1;
    }

    public C2608a(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f9415m, null, -1);
        this.f9421s = null;
        this.f9423u = false;
        this.f9426x = 0;
        this.f9418o = new C2635b(this);
        this.f9419p = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f9420q = i;
        m11160c();
    }

    /* renamed from: c */
    public void m11160c() {
        if (this.f580d != null) {
            this.f9424v = android.text.format.DateFormat.getDateFormat(this.f580d);
            this.f9425w = android.text.format.DateFormat.getTimeFormat(this.f580d);
        }
    }

    /* renamed from: d */
    public void m11161d() {
    }

    /* renamed from: a */
    public void m11158a(String str) {
        this.f9421s = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11154a(String str, String str2) {
        if (str.startsWith("0999")) {
            Intent intent = new Intent(this.f580d, (Class<?>) SpecialBuddyDialog.class);
            intent.putExtra("specialuserid", str);
            intent.putExtra("speicalusername", str2);
            intent.setFlags(67108864);
            this.f580d.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f580d, (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
        intent2.setFlags(67108864);
        this.f580d.startActivity(intent2);
    }

    /* renamed from: a */
    private void m11149a(Paint paint) {
        if (paint == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("The object of paint is null", getClass().getSimpleName());
            }
            this.f9426x = Integer.MAX_VALUE;
            return;
        }
        if (this.f9426x == 0) {
            int iM19100e = C5034k.m19100e() > C5034k.m19101f() ? C5034k.m19100e() : C5034k.m19101f();
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("withPixels : ", Integer.valueOf(iM19100e)), getClass().getSimpleName());
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                if (i >= Integer.MAX_VALUE) {
                    break;
                }
                stringBuffer.append(i);
                if (paint.measureText(stringBuffer.toString()) <= iM19100e) {
                    i++;
                } else {
                    this.f9426x = stringBuffer.length();
                    break;
                }
            }
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("MaxLengthOfChatRoomTitleForDisplay : ", Integer.valueOf(this.f9426x)), getClass().getSimpleName());
            }
        }
    }

    /* renamed from: c */
    private String m11155c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.length() >= this.f9426x ? str.substring(0, this.f9426x) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:298:0x0964  */
    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo876a(android.view.View r29, android.content.Context r30, android.database.Cursor r31) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.msgbox.C2608a.mo876a(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m11150a(View view, int i) {
        if (GlobalApplication.m10289h()) {
            view.setOnDragListener(new C2658c(this, i));
        }
    }

    /* renamed from: a */
    private String m11147a(long j) {
        return C5034k.m19093a(j, System.currentTimeMillis()) ? this.f9425w.format(new Date(j)) : this.f9424v.format(new Date(j));
    }

    /* renamed from: a */
    private void m11153a(C2659d c2659d, int i) throws Resources.NotFoundException {
        c2659d.f9532g.setImageDrawable(GlobalApplication.m10279a().getResources().getDrawable(R.drawable.cmas_ic));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m11148a(ClipData clipData, Context context, String str, boolean z, int i, String str2) throws Throwable {
        int iM10076a;
        Cursor cursorQuery;
        Intent intentM2915a = HomeActivity.m2915a(context, true);
        intentM2915a.setFlags(67108864);
        intentM2915a.putExtra("chatType", i);
        if (str != null && !str.equals("")) {
            intentM2915a.putExtra("inboxNO", str);
            intentM2915a.putExtra("inboxValid", z);
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2220ah.m10086a(str), new String[]{"buddy_no"}, null, null, "rowid DESC");
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            str2 = cursorQuery.getString(0);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            intentM2915a.putExtra("receivers", new String[]{str2});
        }
        if (clipData == null || clipData.getItemCount() > 1) {
            return;
        }
        if (ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "image/*")) {
            iM10076a = EnumC2214ab.IMAGE.m10076a();
        } else if (!ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "video/*")) {
            return;
        } else {
            iM10076a = EnumC2214ab.VIDEO.m10076a();
        }
        ClipData.Item itemAt = clipData.getItemAt(0);
        if (itemAt.getUri() != null) {
            Uri uri = itemAt.getUri();
            if (iM10076a == EnumC2214ab.VIDEO.m10076a()) {
                intentM2915a.putExtra("content_type", EnumC2214ab.VIDEO.m10076a());
                intentM2915a.putExtra("download_uri", uri.toString());
            } else if (iM10076a == EnumC2214ab.IMAGE.m10076a()) {
                intentM2915a.putExtra("content_type", EnumC2214ab.IMAGE.m10076a());
                intentM2915a.putExtra("download_uri", uri.toString());
            }
            context.startActivity(intentM2915a);
        }
    }

    @Override // android.support.v4.widget.AbstractC0259s, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f9419p.inflate(this.f9420q, (ViewGroup) null);
        if (f9416r != 0 && (viewInflate instanceof CheckableRelativeLayout)) {
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(f9416r);
        }
        C2659d c2659d = new C2659d();
        c2659d.f9535j = (FrameLayout) viewInflate.findViewById(R.id.space3);
        c2659d.f9536k = (FrameLayout) viewInflate.findViewById(R.id.space4);
        View viewInflate2 = this.f9419p.inflate(R.layout.msgbox_list_item_unreadcoount, c2659d.f9535j);
        View viewInflate3 = this.f9419p.inflate(R.layout.msgbox_list_item_message_last_time, c2659d.f9536k);
        viewInflate2.setVisibility(0);
        viewInflate3.setVisibility(0);
        c2659d.f9526a = (TextView) viewInflate.findViewById(R.id.text1);
        c2659d.f9527b = (TextView) viewInflate.findViewById(R.id.text2);
        c2659d.f9528c = (TextView) viewInflate.findViewById(R.id.chatRoomUnReadCount);
        c2659d.f9529d = (TextView) viewInflate.findViewById(R.id.chatRoomTrunkUnReadCount);
        c2659d.f9532g = (ImageView) viewInflate.findViewById(R.id.image1);
        WeightHorizontalLayout.LayoutParams layoutParams = (WeightHorizontalLayout.LayoutParams) c2659d.f9526a.getLayoutParams();
        layoutParams.f17951a = 80;
        c2659d.f9526a.setLayoutParams(layoutParams);
        WeightHorizontalLayout.LayoutParams layoutParams2 = (WeightHorizontalLayout.LayoutParams) c2659d.f9535j.getLayoutParams();
        layoutParams2.f17951a = 80;
        c2659d.f9535j.setLayoutParams(layoutParams2);
        ((WeightHorizontalLayout) viewInflate.findViewById(R.id.floor1)).setMinimumHeight((int) CommonApplication.m18732r().getResources().getDimension(R.dimen.chatlist_unread_bubble_minheight));
        c2659d.f9530e = (TextView) viewInflate.findViewById(R.id.chatRoomLastMessageTime);
        c2659d.f9531f = (TextView) viewInflate.findViewById(R.id.chatRoomParticipantsCount);
        c2659d.f9533h = viewInflate;
        c2659d.f9534i = (ImageView) viewInflate.findViewById(R.id.chatRoomMessageAlert);
        viewInflate.setTag(c2659d);
        if (c2659d != null && c2659d.f9526a != null) {
            m11149a(c2659d.f9526a.getPaint());
        }
        return viewInflate;
    }

    /* renamed from: b */
    public void m11159b(String str) {
        this.f9422t = str;
    }

    /* renamed from: a */
    public void m11156a(int i) {
        f9416r = i;
    }
}
