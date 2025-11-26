package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5035l;
import com.sec.google.android.p134a.C5111c;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: MessageListAdapter.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.smsplugin.ui.as */
/* loaded from: classes.dex */
public class C4110as extends CursorAdapter implements AbsListView.OnScrollListener {

    /* renamed from: l */
    public static final String[] f15298l;

    /* renamed from: m */
    public static final String[] f15299m;

    /* renamed from: o */
    public static C4114aw f15300o;

    /* renamed from: A */
    private Handler f15301A;

    /* renamed from: B */
    private final Pattern f15302B;

    /* renamed from: C */
    private final ArrayList<Long> f15303C;

    /* renamed from: D */
    private final ArrayList<Long> f15304D;

    /* renamed from: E */
    private boolean f15305E;

    /* renamed from: F */
    private int f15306F;

    /* renamed from: G */
    private boolean f15307G;

    /* renamed from: a */
    public LinearLayout f15308a;

    /* renamed from: b */
    public LinearLayout f15309b;

    /* renamed from: c */
    public TextView f15310c;

    /* renamed from: d */
    public TextView f15311d;

    /* renamed from: e */
    public LinearLayout f15312e;

    /* renamed from: f */
    public LinearLayout f15313f;

    /* renamed from: g */
    public TextView f15314g;

    /* renamed from: h */
    public TextView f15315h;

    /* renamed from: i */
    public LinearLayout f15316i;

    /* renamed from: j */
    public LinearLayout f15317j;

    /* renamed from: k */
    public TextView f15318k;

    /* renamed from: n */
    protected LayoutInflater f15319n;

    /* renamed from: p */
    public final Context f15320p;

    /* renamed from: q */
    protected InterfaceC4174db f15321q;

    /* renamed from: r */
    private View.OnClickListener f15322r;

    /* renamed from: s */
    private Date f15323s;

    /* renamed from: t */
    private boolean f15324t;

    /* renamed from: u */
    private View.OnClickListener f15325u;

    /* renamed from: v */
    private boolean f15326v;

    /* renamed from: w */
    private int f15327w;

    /* renamed from: x */
    private final ListView f15328x;

    /* renamed from: y */
    private final LruCache<Long, C4108aq> f15329y;

    /* renamed from: z */
    private InterfaceC4115ax f15330z;

    static {
        String[] strArr = new String[24];
        strArr[0] = "transport_type";
        strArr[1] = "_id";
        strArr[2] = "thread_id";
        strArr[3] = "address";
        strArr[4] = "body";
        strArr[5] = "date";
        strArr[6] = "read";
        strArr[7] = "type";
        strArr[8] = "status";
        strArr[9] = "locked";
        strArr[10] = VKApiConst.ERROR_CODE;
        strArr[11] = "sub";
        strArr[12] = "sub_cs";
        strArr[13] = "date";
        strArr[14] = "read";
        strArr[15] = "m_type";
        strArr[16] = "msg_box";
        strArr[17] = "d_rpt";
        strArr[18] = "rr";
        strArr[19] = "err_type";
        strArr[20] = "locked";
        strArr[21] = C3847e.m14679ak() ? VKApiConst.GROUP_ID : null;
        strArr[22] = C3847e.m14679ak() ? "group_type" : null;
        strArr[23] = "normalized_date";
        f15298l = strArr;
        f15299m = new String[]{"transport_type", "_id", "thread_id", "address", "body", "date", "read", "type", "status", "locked", VKApiConst.ERROR_CODE, "sub", "sub_cs", "date", "read", "m_type", "msg_box", "d_rpt", "rr", "err_type", "locked", "normalized_date"};
    }

    public C4110as(Context context, Cursor cursor, ListView listView, boolean z, Pattern pattern) {
        super(context, cursor, 2);
        this.f15308a = null;
        this.f15309b = null;
        this.f15310c = null;
        this.f15311d = null;
        this.f15322r = null;
        this.f15323s = null;
        this.f15324t = false;
        this.f15312e = null;
        this.f15313f = null;
        this.f15314g = null;
        this.f15315h = null;
        this.f15325u = null;
        this.f15316i = null;
        this.f15317j = null;
        this.f15318k = null;
        this.f15326v = false;
        this.f15327w = -1;
        this.f15306F = -1;
        this.f15307G = false;
        this.f15320p = context;
        this.f15302B = pattern;
        this.f15319n = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f15328x = listView;
        this.f15329y = new LruCache<>(50);
        if (z) {
            f15300o = new C4114aw();
        } else {
            f15300o = new C4114aw(cursor);
        }
        this.f15303C = new ArrayList<>();
        this.f15304D = new ArrayList<>();
        listView.setRecyclerListener(new C4111at(this));
        this.f15305E = false;
        this.f15321q = (PluginComposeMessageActivity) this.f15320p;
    }

    /* renamed from: a */
    public void m16325a(int i, boolean z) {
        this.f15306F = i;
        this.f15307G = z;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = (i + i2) - 1;
        if (this.f15306F != -1) {
            if (i2 == i3) {
                this.f15306F = -1;
            } else if (i <= this.f15306F && this.f15306F <= i4) {
                this.f15306F = -1;
            }
        }
    }

    @Override // android.widget.CursorAdapter
    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
        if (this.f15306F != -1) {
            m16322a().setSelectionFromTop(this.f15306F, this.f15307G ? -10000 : 0);
        }
    }

    /* renamed from: a */
    public ListView m16322a() {
        return this.f15328x;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        String string;
        long j;
        C4108aq c4108aqM16323a;
        boolean zContains;
        if ((view instanceof MessageListItem) && (c4108aqM16323a = m16323a((string = cursor.getString(f15300o.f15335a)), (j = cursor.getLong(f15300o.f15336b)), cursor)) != null) {
            MessageListItem messageListItem = (MessageListItem) view;
            messageListItem.setAdapter(this);
            Long lValueOf = Long.valueOf(cursor.getLong(f15300o.f15340f));
            if (string.equals("mms")) {
                lValueOf = Long.valueOf(lValueOf.longValue() * 1000);
            }
            Date date = new Date(lValueOf.longValue());
            LinearLayout linearLayout = (LinearLayout) messageListItem.findViewById(R.id.mms_layout_view_parent);
            linearLayout.setOnClickListener(new ViewOnClickListenerC4112au(this));
            RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.dateseparator);
            TextView textView = (TextView) linearLayout.findViewById(R.id.textDate);
            relativeLayout.setVisibility(8);
            if (m16321b(cursor) != 0) {
                this.f15308a = (LinearLayout) messageListItem.findViewById(R.id.layout_invitation_guide_stamp);
                this.f15309b = (LinearLayout) messageListItem.findViewById(R.id.background_invitation_guide_stamp);
                this.f15310c = (TextView) messageListItem.findViewById(R.id.text_invitation_guide_stamp);
                this.f15311d = (TextView) messageListItem.findViewById(R.id.link_invitation_guide_stamp);
                this.f15308a.setVisibility(8);
                this.f15312e = (LinearLayout) messageListItem.findViewById(R.id.layout_invitation_for_freesms_stamp);
                this.f15313f = (LinearLayout) messageListItem.findViewById(R.id.background_invitation_for_freesms);
                this.f15314g = (TextView) messageListItem.findViewById(R.id.text_invitation_for_freesms);
                this.f15315h = (TextView) messageListItem.findViewById(R.id.link_invitation_for_freesms);
                this.f15312e.setVisibility(8);
            }
            this.f15316i = (LinearLayout) messageListItem.findViewById(R.id.layout_invitation_sent_stamp);
            this.f15317j = (LinearLayout) messageListItem.findViewById(R.id.background_invitation_sent);
            this.f15318k = (TextView) messageListItem.findViewById(R.id.text_invitation_sent);
            this.f15316i.setVisibility(8);
            if (cursor.isFirst()) {
                textView.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(date));
                relativeLayout.setVisibility(0);
                if (C3847e.m14693ay() && m16321b(cursor) != 0 && !this.f15305E && !this.f15324t && this.f15323s != null && (date.after(this.f15323s) || date.equals(this.f15323s))) {
                    this.f15309b.setBackgroundResource(R.drawable.chat_noti_bar);
                    if (C4822an.m18218a()) {
                        this.f15310c.setText(R.string.invite_suggestion);
                    } else {
                        this.f15310c.setText(R.string.invite_suggestion_lite);
                    }
                    this.f15311d.setText(C5035l.m19111a(this.f15320p.getResources().getString(R.string.send_invite_message)));
                    this.f15308a.setVisibility(0);
                    this.f15311d.setOnClickListener(this.f15322r);
                }
            } else if (cursor.moveToPrevious()) {
                String string2 = cursor.getString(f15300o.f15335a);
                Long lValueOf2 = Long.valueOf(cursor.getLong(f15300o.f15340f));
                if (string2.equals("mms")) {
                    lValueOf2 = Long.valueOf(lValueOf2.longValue() * 1000);
                }
                Date date2 = new Date(lValueOf2.longValue());
                cursor.moveToNext();
                if (date2.getDate() - date.getDate() != 0) {
                    textView.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(date));
                    relativeLayout.setVisibility(0);
                }
                if (C3847e.m14693ay() && m16321b(cursor) != 0 && !this.f15305E && !this.f15324t && this.f15323s != null && date2.before(this.f15323s) && (date.after(this.f15323s) || date.equals(this.f15323s))) {
                    this.f15309b.setBackgroundResource(R.drawable.chat_noti_bar);
                    if (C4822an.m18218a()) {
                        this.f15310c.setText(R.string.invite_suggestion);
                    } else {
                        this.f15310c.setText(R.string.invite_suggestion_lite);
                    }
                    this.f15311d.setText(C5035l.m19111a(this.f15320p.getResources().getString(R.string.send_invite_message)));
                    this.f15308a.setVisibility(0);
                    this.f15311d.setOnClickListener(this.f15322r);
                }
            }
            if (((int) j) == C4809aa.m18104a().m18120a("free_sms_reward_noti_msgid_int", (Integer) (-1)).intValue() || ((int) j) == C4809aa.m18104a().m18120a("free_sms_reward_1st_regular_msgid_int", (Integer) (-1)).intValue()) {
                this.f15313f.setBackgroundResource(R.drawable.chat_noti_bar);
                this.f15314g.setText(this.f15320p.getResources().getString(R.string.freesms_invite_control, Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_reward_base", (Integer) 20).intValue()), Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_reward_per_base", (Integer) 50).intValue()), 200));
                this.f15315h.setText(C5035l.m19111a(this.f15320p.getResources().getString(R.string.send_invite_message)));
                this.f15312e.setVisibility(0);
                this.f15315h.setOnClickListener(this.f15325u);
            }
            if (((int) j) == this.f15327w) {
                this.f15317j.setBackgroundResource(R.drawable.chat_noti_bar);
                this.f15318k.setText(R.string.freesms_invitation_sent);
                this.f15316i.setVisibility(0);
            }
            if (this.f15326v) {
                if ("sms".equals(c4108aqM16323a.f15267b)) {
                    zContains = this.f15303C.contains(Long.valueOf(j));
                } else {
                    zContains = this.f15304D.contains(Long.valueOf(j));
                }
                messageListItem.setCheckBox(0, zContains);
                messageListItem.m15838m().setOnClickListener(new ViewOnClickListenerC4113av(this, messageListItem));
                if (!zContains) {
                    ((PluginComposeMessageActivity) this.f15320p).m16120b(false);
                }
            } else {
                messageListItem.setCheckBox(8, false);
            }
            if (c4108aqM16323a.f15277l == null) {
                messageListItem.setBodyTextViewVisibility(false);
            } else {
                messageListItem.setBodyTextViewVisibility(true);
            }
            messageListItem.m15832a(c4108aqM16323a, cursor.getPosition() == cursor.getCount() + (-1), this.f15305E);
            messageListItem.setMsgListItemHandler(this.f15301A);
        }
    }

    /* renamed from: a */
    public void m16329a(InterfaceC4115ax interfaceC4115ax) {
        this.f15330z = interfaceC4115ax;
    }

    /* renamed from: a */
    public void m16327a(Handler handler) {
        this.f15301A = handler;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f15329y.evictAll();
        if (this.f15330z != null) {
            this.f15330z.mo16339a(this);
        }
    }

    @Override // android.widget.CursorAdapter
    protected void onContentChanged() {
        if (getCursor() != null && !getCursor().isClosed() && this.f15330z != null) {
            this.f15330z.mo16340b(this);
        }
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        MessageListItem messageListItem = (MessageListItem) this.f15319n.inflate(m16321b(cursor) == 0 ? R.layout.message_list_item_recv : R.layout.message_list_item_send, viewGroup, false);
        if (C3847e.m14693ay() && this.f15323s == null) {
            long jM18118a = C4809aa.m18104a().m18118a("pref_key_1st_sms_message_sent_time", 0L);
            if (jM18118a != 0) {
                this.f15323s = new Date(jM18118a);
            }
        }
        messageListItem.setAdapter(this);
        return messageListItem;
    }

    /* renamed from: a */
    public C4108aq m16323a(String str, long j, Cursor cursor) {
        C4108aq c4108aq;
        C4108aq c4108aq2 = this.f15329y.get(Long.valueOf(m16319a(str, j)));
        if (c4108aq2 == null && cursor != null && m16320a(cursor)) {
            try {
                c4108aq = new C4108aq(this.f15320p, str, cursor, f15300o, this.f15302B);
            } catch (C5111c e) {
                e = e;
            }
            try {
                this.f15329y.put(Long.valueOf(m16319a(c4108aq.f15267b, c4108aq.f15268c)), c4108aq);
                return c4108aq;
            } catch (C5111c e2) {
                c4108aq2 = c4108aq;
                e = e2;
                C3890m.m14995a("MessageListAdapter", "getCachedMessageItem: ", e);
                return c4108aq2;
            }
        }
        return c4108aq2;
    }

    /* renamed from: a */
    private boolean m16320a(Cursor cursor) {
        return (cursor.isClosed() || cursor.isBeforeFirst() || cursor.isAfterLast()) ? false : true;
    }

    /* renamed from: a */
    private static long m16319a(String str, long j) {
        if (str.equals("mms")) {
            return -j;
        }
        return j;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return m16321b((Cursor) getItem(i));
    }

    /* renamed from: b */
    private int m16321b(Cursor cursor) {
        int i;
        if ("sms".equals(cursor.getString(f15300o.f15335a))) {
            i = cursor.getInt(f15300o.f15341g);
        } else {
            i = cursor.getInt(f15300o.f15348n);
        }
        return i == 1 ? 0 : 1;
    }

    /* renamed from: a */
    public void m16328a(View.OnClickListener onClickListener) {
        this.f15322r = onClickListener;
    }

    /* renamed from: a */
    public void m16330a(boolean z) {
        this.f15324t = z;
    }

    /* renamed from: b */
    public void m16332b(View.OnClickListener onClickListener) {
        this.f15325u = onClickListener;
    }

    /* renamed from: b */
    public void m16333b(boolean z) {
        this.f15326v = z;
        if (this.f15326v) {
            this.f15303C.clear();
            this.f15304D.clear();
        }
    }

    /* renamed from: a */
    public void m16326a(long j, String str) {
        if ("sms".equals(str)) {
            if (!this.f15303C.contains(Long.valueOf(j))) {
                this.f15303C.add(Long.valueOf(j));
            }
        } else if (!this.f15304D.contains(Long.valueOf(j))) {
            this.f15304D.add(Long.valueOf(j));
        }
    }

    /* renamed from: b */
    public void m16331b() {
        C3890m.m14994a("MessageListAdapter", "clearCheckedList()");
        this.f15303C.clear();
        this.f15304D.clear();
    }

    /* renamed from: b */
    public boolean m16334b(long j, String str) {
        if ("sms".equals(str)) {
            if (this.f15303C.contains(Long.valueOf(j))) {
                this.f15303C.remove(Long.valueOf(j));
                return false;
            }
            this.f15303C.add(Long.valueOf(j));
        } else {
            if (this.f15304D.contains(Long.valueOf(j))) {
                this.f15304D.remove(Long.valueOf(j));
                return false;
            }
            this.f15304D.add(Long.valueOf(j));
        }
        return true;
    }

    /* renamed from: c */
    public int m16335c() {
        return this.f15303C.size() + this.f15304D.size();
    }

    /* renamed from: c */
    public boolean m16337c(long j, String str) {
        return "sms".equals(str) ? this.f15303C.contains(Long.valueOf(j)) : this.f15304D.contains(Long.valueOf(j));
    }

    /* renamed from: d */
    public boolean m16338d() {
        Cursor cursor = getCursor();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                if (m16337c(Long.valueOf(cursor.getLong(1)).longValue(), cursor.getString(0))) {
                    if (cursor.getInt(20) != 0) {
                        return true;
                    }
                }
            } while (cursor.moveToNext());
        }
        return false;
    }

    /* renamed from: c */
    public void m16336c(boolean z) {
        this.f15305E = z;
    }

    /* renamed from: a */
    public void m16324a(int i) {
        this.f15327w = i;
    }
}
