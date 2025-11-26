package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.C0266z;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4830av;
import com.sec.chaton.widget.CheckableRelativeLayout;
import com.sec.chaton.widget.WeightHorizontalLayout;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: ThreadListAdapter.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.smsplugin.ui.ix */
/* loaded from: classes.dex */
public class C4331ix extends C0266z {

    /* renamed from: m */
    public static final String[] f15742m = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: p */
    private static int f15743p = 0;

    /* renamed from: n */
    private LayoutInflater f15744n;

    /* renamed from: o */
    private int f15745o;

    /* renamed from: q */
    private ArrayList<C4830av> f15746q;

    /* renamed from: r */
    private ArrayList<String> f15747r;

    /* renamed from: s */
    private String f15748s;

    /* renamed from: t */
    private DateFormat f15749t;

    /* renamed from: u */
    private DateFormat f15750u;

    public C4331ix(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f15742m, null, -1);
        this.f15744n = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f15745o = i;
        m16508c();
    }

    /* renamed from: c */
    public void m16508c() {
        if (this.f580d != null) {
            this.f15749t = android.text.format.DateFormat.getDateFormat(this.f580d);
            this.f15750u = android.text.format.DateFormat.getTimeFormat(this.f580d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:255:0x08f2  */
    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo876a(android.view.View r28, android.content.Context r29, android.database.Cursor r30) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4331ix.mo876a(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    /* renamed from: a */
    private String m16504a(long j) {
        return C5034k.m19093a(j, System.currentTimeMillis()) ? this.f15750u.format(new Date(j)) : this.f15749t.format(new Date(j));
    }

    /* renamed from: a */
    public void m16506a(ClipData clipData, Context context, String str, boolean z, int i, String str2) throws Throwable {
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
        View viewInflate = this.f15744n.inflate(this.f15745o, (ViewGroup) null);
        if (f15743p != 0 && (viewInflate instanceof CheckableRelativeLayout)) {
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(f15743p);
        }
        C4333iz c4333iz = new C4333iz();
        c4333iz.f15762j = (FrameLayout) viewInflate.findViewById(R.id.space3);
        c4333iz.f15763k = (FrameLayout) viewInflate.findViewById(R.id.space4);
        View viewInflate2 = this.f15744n.inflate(R.layout.msgbox_list_item_unreadcoount, c4333iz.f15762j);
        View viewInflate3 = this.f15744n.inflate(R.layout.msgbox_list_item_message_last_time, c4333iz.f15763k);
        viewInflate2.setVisibility(0);
        viewInflate3.setVisibility(0);
        c4333iz.f15753a = (TextView) viewInflate.findViewById(R.id.text1);
        c4333iz.f15754b = (TextView) viewInflate.findViewById(R.id.text2);
        c4333iz.f15755c = (TextView) viewInflate.findViewById(R.id.chatRoomUnReadCount);
        c4333iz.f15756d = (TextView) viewInflate.findViewById(R.id.chatRoomTrunkUnReadCount);
        c4333iz.f15759g = (ImageView) viewInflate.findViewById(R.id.image1);
        WeightHorizontalLayout.LayoutParams layoutParams = (WeightHorizontalLayout.LayoutParams) c4333iz.f15753a.getLayoutParams();
        layoutParams.f17951a = 80;
        c4333iz.f15753a.setLayoutParams(layoutParams);
        WeightHorizontalLayout.LayoutParams layoutParams2 = (WeightHorizontalLayout.LayoutParams) c4333iz.f15762j.getLayoutParams();
        layoutParams2.f17951a = 80;
        c4333iz.f15762j.setLayoutParams(layoutParams2);
        ((WeightHorizontalLayout) viewInflate.findViewById(R.id.floor1)).setMinimumHeight((int) CommonApplication.m18732r().getResources().getDimension(R.dimen.chatlist_unread_bubble_minheight));
        c4333iz.f15757e = (TextView) viewInflate.findViewById(R.id.chatRoomLastMessageTime);
        c4333iz.f15758f = (TextView) viewInflate.findViewById(R.id.chatRoomParticipantsCount);
        c4333iz.f15760h = viewInflate;
        c4333iz.f15761i = (ImageView) viewInflate.findViewById(R.id.chatRoomMessageAlert);
        viewInflate.setTag(c4333iz);
        return viewInflate;
    }

    /* renamed from: a */
    public void m16507a(String str) {
        this.f15748s = str;
    }

    /* renamed from: a */
    public void m16505a(int i) {
        f15743p = i;
    }
}
