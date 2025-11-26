package com.sec.chaton.smsplugin.spam;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.C4114aw;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5083f;
import com.sec.google.android.p134a.p135a.C5084g;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: SpamMessageListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bv */
/* loaded from: classes.dex */
public class C4018bv extends CursorAdapter {

    /* renamed from: a */
    static final String[] f14488a = {"transport_type", "_id", "address", "body", "date", "read", "type", "status", "sub", "sub_cs", "m_type", "msg_box", "d_rpt", "rr", "err_type", "locked", "date"};

    /* renamed from: j */
    private static Drawable f14489j = null;

    /* renamed from: b */
    protected LayoutInflater f14490b;

    /* renamed from: c */
    protected C4114aw f14491c;

    /* renamed from: d */
    QuickContactBadge f14492d;

    /* renamed from: e */
    private final LinkedHashMap<Long, C4108aq> f14493e;

    /* renamed from: f */
    private InterfaceC4022bz f14494f;

    /* renamed from: g */
    private String f14495g;

    /* renamed from: h */
    private int f14496h;

    /* renamed from: i */
    private final ArrayList<Integer> f14497i;

    public C4018bv(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f14497i = new ArrayList<>();
        this.f14493e = new C4019bw(this, 10, 1.0f, true);
    }

    public C4018bv(Context context, Cursor cursor, ListView listView, boolean z, String str, boolean z2, int i) {
        this(context, cursor, z2);
        this.f14495g = str != null ? str.toLowerCase() : null;
        this.f14490b = (LayoutInflater) context.getSystemService("layout_inflater");
        if (z) {
            this.f14491c = new C4114aw();
        } else {
            this.f14491c = new C4114aw(cursor);
        }
        this.f14496h = i;
        this.f14497i.clear();
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f14490b.inflate(R.layout.spam_list_item, viewGroup, false);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException {
        String strM19308c;
        String string = cursor.getString(this.f14491c.f15335a);
        String string2 = cursor.getString(this.f14491c.f15338d);
        int i = cursor.getInt(this.f14491c.f15348n);
        String string3 = cursor.getString(this.f14491c.f15339e);
        int i2 = cursor.getInt(this.f14491c.f15347m);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.spam_list_item_checkbox);
        Drawable drawable = context.getResources().getDrawable(R.drawable.msg_list_id_default);
        ImageView imageView = (ImageView) view.findViewById(R.id.spam_list_item_msgicon);
        this.f14492d = (QuickContactBadge) view.findViewById(R.id.spam_avatar);
        m15462a(context, string2);
        this.f14492d.setClickable(this.f14496h == 0);
        if ("mms".equals(string)) {
            Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("date")) * 1000);
            String string4 = cursor.getString(this.f14491c.f15345k);
            Uri uriWithAppendedId = ContentUris.withAppendedId(C4012bp.f14473i, cursor.getLong(this.f14491c.f15336b));
            if (i2 == 130) {
                try {
                    C5084g c5084g = (C5084g) C5097t.m19426a(context).m19449a(uriWithAppendedId);
                    if (c5084g == null || c5084g.mo19324w_() == null) {
                        strM19308c = "";
                    } else {
                        strM19308c = c5084g.mo19324w_().m19308c();
                    }
                    if (TextUtils.isEmpty(strM19308c)) {
                        ((TextView) view.findViewById(R.id.spam_list_item_name)).setText(R.string.anonymous_recipient);
                        ((QuickContactBadge) view.findViewById(R.id.spam_avatar)).setImageDrawable(drawable);
                    } else {
                        C3782a c3782aM14204a = C3782a.m14204a(strM19308c, true);
                        String strM14264f = c3782aM14204a.m14264f();
                        Drawable drawableM14256a = c3782aM14204a.m14256a(context, drawable);
                        ((TextView) view.findViewById(R.id.spam_list_item_name)).setText(strM14264f);
                        ((QuickContactBadge) view.findViewById(R.id.spam_avatar)).setImageDrawable(drawableM14256a);
                    }
                } catch (C5111c e) {
                    C3890m.m14995a("Mms/SpamMessageListAdapter", "Failed to load the message: " + uriWithAppendedId, e);
                }
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.msg_view_icon_mms_noti);
            } else {
                try {
                    String strM19308c2 = ((C5083f) C5097t.m19426a(context).m19449a(uriWithAppendedId)).mo19324w_().m19308c();
                    if (TextUtils.isEmpty(strM19308c2)) {
                        ((TextView) view.findViewById(R.id.spam_list_item_name)).setText(" ");
                        ((QuickContactBadge) view.findViewById(R.id.spam_avatar)).setImageDrawable(drawable);
                    } else {
                        C3782a c3782aM14204a2 = C3782a.m14204a(strM19308c2, true);
                        String strM14264f2 = c3782aM14204a2.m14264f();
                        Drawable drawableM14256a2 = c3782aM14204a2.m14256a(context, drawable);
                        ((TextView) view.findViewById(R.id.spam_list_item_name)).setText(strM14264f2);
                        ((QuickContactBadge) view.findViewById(R.id.spam_avatar)).setImageDrawable(drawableM14256a2);
                    }
                } catch (C5111c e2) {
                    C3890m.m14995a("Mms/SpamMessageListAdapter", "Failed to load the message: " + uriWithAppendedId, e2);
                }
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.msg_icon_mms);
            }
            if (i == 1) {
                ((TextView) view.findViewById(R.id.spam_list_item_date)).setText(C4149cd.m16393a(context, lValueOf.longValue()));
            } else {
                ((TextView) view.findViewById(R.id.spam_list_item_date)).setText(" ");
            }
            if (!TextUtils.isEmpty(string4)) {
                ((TextView) view.findViewById(R.id.spam_list_item_line2)).setText(new C5082e(cursor.getInt(this.f14491c.f15346l), string4).m19308c());
            } else {
                ((TextView) view.findViewById(R.id.spam_list_item_line2)).setText(R.string.no_subject_view);
            }
        } else {
            int i3 = cursor.getInt(this.f14491c.f15341g);
            Long lValueOf2 = Long.valueOf(cursor.getLong(this.f14491c.f15340f));
            if (TextUtils.isEmpty(string2)) {
                ((TextView) view.findViewById(R.id.spam_list_item_name)).setText(" ");
                ((QuickContactBadge) view.findViewById(R.id.spam_avatar)).setImageDrawable(drawable);
            } else {
                C3782a c3782aM14204a3 = C3782a.m14204a(string2, true);
                String strM14264f3 = c3782aM14204a3.m14264f();
                Drawable drawableM14256a3 = c3782aM14204a3.m14256a(context, drawable);
                ((TextView) view.findViewById(R.id.spam_list_item_name)).setText(strM14264f3);
                ((QuickContactBadge) view.findViewById(R.id.spam_avatar)).setImageDrawable(drawableM14256a3);
            }
            if (i3 == 1) {
                ((TextView) view.findViewById(R.id.spam_list_item_date)).setText(C4149cd.m16393a(context, lValueOf2.longValue()));
            } else {
                ((TextView) view.findViewById(R.id.spam_list_item_date)).setText(" ");
            }
            if (TextUtils.isEmpty(string3)) {
                ((TextView) view.findViewById(R.id.spam_list_item_line2)).setText(" ");
            } else {
                ((TextView) view.findViewById(R.id.spam_list_item_line2)).setText(string3);
            }
            imageView.setVisibility(8);
        }
        view.findViewById(R.id.spam_list_item_checkbox_layout).setVisibility(this.f14496h != 0 ? 0 : 8);
        view.setTag(string + "/" + cursor.getLong(this.f14491c.f15336b) + "/" + i2);
        view.setOnClickListener(new ViewOnClickListenerC4020bx(this, checkBox));
        ((Activity) this.mContext).registerForContextMenu(view);
        checkBox.setTag(Integer.valueOf(cursor.getPosition()));
        checkBox.setOnCheckedChangeListener(new C4021by(this));
        if (this.f14496h != 0) {
            checkBox.setChecked(this.f14497i.contains(Integer.valueOf(cursor.getPosition())));
        }
    }

    /* renamed from: a */
    private void m15462a(Context context, String str) throws Resources.NotFoundException {
        Drawable drawableM14256a;
        if (this.f14492d != null) {
            this.f14492d.assignContactUri(null);
        }
        if (TextUtils.isEmpty(str)) {
            drawableM14256a = f14489j;
        } else {
            C3782a c3782aM14204a = C3782a.m14204a(str, true);
            f14489j = context.getResources().getDrawable(R.drawable.msg_list_id_1);
            if (str.contains(",") || str.contains(Config.KEYVALUE_SPLIT)) {
                drawableM14256a = c3782aM14204a.m14256a(context, context.getResources().getDrawable(R.drawable.msg_list_group_img));
            } else {
                drawableM14256a = c3782aM14204a.m14256a(context, f14489j);
            }
            if (!TextUtils.isEmpty(str) && this.f14492d != null) {
                if (c3782aM14204a.m14262d().equals("CBmessages") || c3782aM14204a.m14262d().equals("Pushmessage")) {
                    this.f14492d.assignContactUri(null);
                    drawableM14256a = context.getResources().getDrawable(R.drawable.msg_list_cb_img);
                } else if (c3782aM14204a.m14271m()) {
                    this.f14492d.assignContactUri(c3782aM14204a.m14268j());
                } else if (Telephony.Mms.isEmailAddress(c3782aM14204a.m14262d())) {
                    this.f14492d.assignContactFromEmail(c3782aM14204a.m14262d(), true);
                } else if (c3782aM14204a.m14273o()) {
                    this.f14492d.assignContactFromPhone(c3782aM14204a.m14262d(), true);
                } else {
                    this.f14492d.assignContactUri(null);
                }
            }
        }
        if (this.f14492d != null && this.f14492d.getVisibility() == 0) {
            this.f14492d.setImageDrawable(drawableM14256a);
        }
    }

    /* renamed from: a */
    public void m15467a() {
        if (this.f14492d != null) {
            this.f14492d = null;
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        C3890m.m14994a("Mms/SpamMessageListAdapter", "MessageListAdapter.notifyDataSetChanged().");
        this.f14493e.clear();
        if (this.f14494f != null) {
            this.f14494f.m15474a(this);
        }
    }

    @Override // android.widget.CursorAdapter
    protected void onContentChanged() {
        if (this.mAutoRequery) {
            super.onContentChanged();
        } else if (this.mCursor != null && !this.mCursor.isClosed() && this.f14494f != null) {
            this.f14494f.m15475b(this);
        }
    }

    /* renamed from: a */
    public void m15468a(int i) {
        this.f14496h = i;
        this.f14497i.clear();
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m15470b(int i) {
        if (!this.f14497i.contains(Integer.valueOf(i))) {
            this.f14497i.add(Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    public void m15472c(int i) {
        if (this.f14497i.contains(Integer.valueOf(i))) {
            this.f14497i.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: b */
    public ArrayList<Integer> m15469b() {
        return this.f14497i;
    }

    /* renamed from: c */
    public int m15471c() {
        return this.f14497i.size();
    }

    /* renamed from: d */
    public void m15473d() {
        this.f14497i.clear();
    }
}
