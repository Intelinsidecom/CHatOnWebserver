package com.sec.chaton.settings.downloads;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC1825o;
import com.sec.chaton.p025d.C1333k;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1367k;
import com.sec.chaton.p027e.p028a.C1368l;
import com.sec.chaton.settings.downloads.p056a.C2518i;
import com.sec.chaton.settings.downloads.p056a.C2521l;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.settings.downloads.p056a.InterfaceC2526q;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: FontListAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.bm */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2573bm extends CursorTreeAdapter implements View.OnClickListener, InterfaceC2526q {

    /* renamed from: b */
    private static final String f9753b = ViewOnClickListenerC2573bm.class.getSimpleName();

    /* renamed from: a */
    C2556aw f9754a;

    /* renamed from: c */
    private int f9755c;

    /* renamed from: d */
    private int f9756d;

    /* renamed from: e */
    private C3326c f9757e;

    /* renamed from: f */
    private HashMap<String, C2579bs> f9758f;

    /* renamed from: g */
    private C1333k f9759g;

    /* renamed from: h */
    private InterfaceC2578br f9760h;

    /* renamed from: i */
    private Handler f9761i;

    /* renamed from: j */
    private View.OnLongClickListener f9762j;

    /* renamed from: k */
    private View.OnClickListener f9763k;

    public ViewOnClickListenerC2573bm(Cursor cursor, Context context, C3326c c3326c) {
        super(cursor, context);
        this.f9761i = new HandlerC2574bn(this);
        this.f9762j = new ViewOnLongClickListenerC2575bo(this);
        this.f9763k = new ViewOnClickListenerC2576bp(this);
        this.f9755c = context.getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_width);
        this.f9756d = context.getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_height);
        this.f9757e = c3326c;
        this.f9758f = new HashMap<>();
        this.f9759g = new C1333k(context, null);
    }

    @Override // android.widget.CursorTreeAdapter
    protected Cursor getChildrenCursor(Cursor cursor) throws Throwable {
        int i = cursor.getInt(cursor.getColumnIndex("filter_id"));
        Cursor cursorM9532a = m9532a(i);
        m9533a(cursorM9532a, i);
        return cursorM9532a;
    }

    /* renamed from: a */
    protected Cursor m9532a(int i) throws Throwable {
        String[] strArr;
        String str;
        String str2;
        if (i > 0) {
            str = "reference_id=?";
            strArr = new String[]{String.valueOf(i)};
        } else {
            strArr = null;
            str = null;
        }
        String strM11849a = C3364o.m11849a("special", " DESC,", "item_id", " DESC");
        if (C3250y.f11734b) {
            str2 = (new StringBuilder().append("download_font, getChildrenCursor(), key/value : ").append(str).toString() == null || new StringBuilder().append(str).append(strArr).toString() == null) ? "(null)" : strArr[0] + " orderyBy : " + strM11849a;
            C3250y.m11450b(str2, f9753b);
        }
        return CommonApplication.m11493l().getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Font), null, str, strArr, strM11849a);
    }

    @Override // android.widget.CursorTreeAdapter, android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof ExpandableListView)) {
            ((ExpandableListView) viewGroup).expandGroup(i);
        }
        return super.getGroupView(i, z, view, viewGroup);
    }

    @Override // android.widget.CursorTreeAdapter
    protected View newGroupView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.item_list_font_group, viewGroup, false);
        C2577bq c2577bq = new C2577bq(this, null);
        c2577bq.f9768b = (TextView) viewInflate.findViewById(R.id.group_title);
        viewInflate.setTag(c2577bq);
        return viewInflate;
    }

    @Override // android.widget.CursorTreeAdapter
    protected void bindGroupView(View view, Context context, Cursor cursor, boolean z) {
        C2577bq c2577bq = (C2577bq) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("filter_title"));
        c2577bq.f9767a = cursor.getPosition();
        c2577bq.f9768b.setText(string);
    }

    @Override // android.widget.CursorTreeAdapter
    protected View newChildView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.item_list_font, viewGroup, false);
        viewInflate.setOnClickListener(this.f9763k);
        viewInflate.setOnLongClickListener(this.f9762j);
        C2579bs c2579bs = new C2579bs(this, null);
        c2579bs.f9772c = (ImageView) viewInflate.findViewById(R.id.font_item_thumbnail);
        c2579bs.f9774e = (TextView) viewInflate.findViewById(R.id.font_item_name);
        c2579bs.f9773d = (TextView) viewInflate.findViewById(R.id.font_item_volume);
        c2579bs.f9775f = (ImageView) viewInflate.findViewById(R.id.font_item_download);
        c2579bs.f9775f.setOnClickListener(this);
        c2579bs.f9776g = (TextView) viewInflate.findViewById(R.id.font_item_ribbon);
        c2579bs.f9777h = (ProgressBar) viewInflate.findViewById(R.id.font_item_progress);
        viewInflate.setTag(c2579bs);
        return viewInflate;
    }

    @Override // android.widget.CursorTreeAdapter
    protected void bindChildView(View view, Context context, Cursor cursor, boolean z) {
        C2579bs c2579bs = (C2579bs) view.getTag();
        if (cursor == null) {
            if (C3250y.f11737e) {
                C3250y.m11442a("download_font, bindChildView(), cursor is (null)", f9753b);
                return;
            }
            return;
        }
        C1368l c1368lM6095a = null;
        try {
            c1368lM6095a = C1367k.m6095a(cursor.getString(cursor.getColumnIndex("extras")));
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9753b);
            }
        }
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        c2579bs.f9770a = string;
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        c2579bs.f9778i = string2;
        String str = null;
        long j = 0;
        if (c1368lM6095a != null) {
            str = c1368lM6095a.f5118b;
            j = c1368lM6095a.f5120d;
        }
        boolean z2 = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        c2579bs.f9779j = z2;
        int i = cursor.getInt(cursor.getColumnIndex("new"));
        int i2 = cursor.getInt(cursor.getColumnIndex("special"));
        this.f9758f.values().remove(c2579bs);
        this.f9758f.put(string, c2579bs);
        C2518i c2518i = (C2518i) C2525p.m9458a().m9459a(EnumC1399aq.Font, string);
        if (c2518i != null) {
            c2518i.m9446a(this.f9761i);
        }
        c2579bs.f9771b = cursor.getPosition();
        c2579bs.f9774e.setText(string2);
        c2579bs.f9775f.setVisibility(0);
        c2579bs.f9777h.setVisibility(8);
        if (z2) {
            if (C2570bj.m9514a(string)) {
                c2579bs.f9775f.setImageResource(R.drawable.download_ic_apply_02);
                c2579bs.f9775f.setEnabled(false);
            } else {
                c2579bs.f9775f.setImageResource(R.drawable.download_ic_apply_01);
                c2579bs.f9775f.setEnabled(true);
            }
            c2579bs.f9773d.setText(C3364o.m11849a(Long.valueOf(j / 1000), "KB / ", context.getString(R.string.anicon_package_downloaded)));
            C2570bj.m9520b(c2579bs.f9773d);
        } else if (c2518i == null) {
            c2579bs.f9775f.setImageResource(R.drawable.download_ic_download_01);
            c2579bs.f9775f.setEnabled(true);
            c2579bs.f9777h.setVisibility(8);
            c2579bs.f9773d.setText(C3364o.m11849a(Long.valueOf(j / 1000), "KB"));
            C2570bj.m9513a(c2579bs.f9773d);
        } else if (c2518i.m9455d() == 5) {
            c2579bs.f9775f.setImageResource(R.drawable.download_ic_fail_01);
            c2579bs.f9777h.setVisibility(8);
            c2579bs.f9773d.setText(C3364o.m11849a(Long.valueOf(j / 1000), "KB"));
            C2570bj.m9513a(c2579bs.f9773d);
        } else {
            c2579bs.f9777h.setVisibility(0);
            switch (c2518i.m9455d()) {
                case 0:
                    c2579bs.f9775f.setImageResource(R.drawable.download_ic_cancel_01);
                    if (!c2579bs.f9777h.isIndeterminate()) {
                        c2579bs.f9777h.setIndeterminate(true);
                    }
                    c2579bs.f9773d.setText(C3364o.m11849a(" (", context.getString(R.string.download_progressing), ")"));
                    C2570bj.m9522c(c2579bs.f9773d);
                    break;
                case 1:
                    c2579bs.f9775f.setImageResource(R.drawable.download_ic_cancel_01);
                    if (c2579bs.f9777h.isIndeterminate()) {
                        c2579bs.f9777h.setIndeterminate(false);
                    }
                    c2579bs.f9777h.setProgress(c2518i.m11747g().intValue());
                    c2579bs.f9773d.setText(C3364o.m11849a(Long.valueOf(j / 1000), "KB"));
                    C2570bj.m9522c(c2579bs.f9773d);
                    break;
                case 2:
                    c2579bs.f9775f.setVisibility(4);
                    c2579bs.f9777h.setVisibility(8);
                    c2579bs.f9773d.setText(context.getString(R.string.download_installing));
                    C2570bj.m9523d(c2579bs.f9773d);
                    break;
            }
        }
        c2579bs.f9775f.setTag(c2579bs);
        if (i2 != 0) {
            c2579bs.f9776g.setVisibility(0);
            c2579bs.f9776g.setText(R.string.download_special_ribbon_text);
            c2579bs.f9776g.setBackgroundColor(Color.parseColor("#3eb1b9"));
        } else if (i != 0) {
            c2579bs.f9776g.setVisibility(0);
            c2579bs.f9776g.setText(R.string.download_new_ribbon_text);
            c2579bs.f9776g.setBackgroundColor(Color.parseColor("#e86d00"));
        } else {
            c2579bs.f9776g.setVisibility(8);
        }
        this.f9757e.m11730a(c2579bs.f9772c, new CallableC1825o(str, this.f9755c, this.f9756d));
    }

    /* renamed from: a */
    public void m9535a(InterfaceC2578br interfaceC2578br) {
        this.f9760h = interfaceC2578br;
    }

    /* renamed from: a */
    public boolean m9536a() {
        return C2525p.m9458a().m9462a(EnumC1399aq.Font);
    }

    /* renamed from: b */
    public void m9537b() {
        C2525p.m9458a().m9463b(EnumC1399aq.Font);
    }

    /* renamed from: c */
    public void m9538c() {
        C2525p.m9458a().m9466c(EnumC1399aq.Font);
    }

    /* renamed from: a */
    private void m9529a(String str, boolean z) {
        C2518i c2518i = (C2518i) C2525p.m9458a().m9459a(EnumC1399aq.Font, str);
        if (c2518i == null) {
            new C2518i(this.f9759g, str).m11745d(new Void[0]);
        }
        if (c2518i.m9455d() == 5) {
            new C2518i(this.f9759g, str).m11745d(new Void[0]);
            return;
        }
        if (z) {
            switch (c2518i.m9455d()) {
                case 0:
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_font, download all - requestInstall : cancel(), id/status : " + str + "/" + c2518i.m9455d(), f9753b);
                    }
                    c2518i.m11744a(true);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9528a(String str, String str2) {
        if (this.f9760h != null) {
            this.f9760h.mo9361a(str, str2);
        }
    }

    /* renamed from: d */
    public void m9539d() throws Throwable {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = getCursor();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            Cursor childrenCursor = getChildrenCursor(cursor);
            if (childrenCursor != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_font, download all, (LOOP. GROUP - start) filter_id/count/title: " + cursor.getString(cursor.getColumnIndex("filter_id")) + "/" + childrenCursor.getCount() + "/" + cursor.getString(cursor.getColumnIndex("filter_title")), f9753b);
                }
                childrenCursor.moveToPosition(-1);
                while (childrenCursor.moveToNext()) {
                    String string = childrenCursor.getString(childrenCursor.getColumnIndex("item_id"));
                    String string2 = childrenCursor.getString(childrenCursor.getColumnIndex("name"));
                    boolean z = childrenCursor.getInt(childrenCursor.getColumnIndex("install")) != 0;
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_font, download all, (LOOP. CHILD) id/name/install : " + string + "/" + string2.toString() + "/" + z, f9753b);
                    }
                    if (!TextUtils.isEmpty(string) && !z) {
                        arrayList.add(string);
                    }
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_font, download all, (LOOP. GROUP - end) current list added : " + arrayList.size(), f9753b);
                }
                childrenCursor.close();
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m9529a((String) it.next(), false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = ((C2579bs) view.getTag()).f9770a;
        ArrayList<String> arrayListM6096a = C1367k.m6096a(CommonApplication.m11493l(), str);
        if (arrayListM6096a != null) {
            String str2 = arrayListM6096a.get(0);
            boolean z = Long.valueOf(arrayListM6096a.get(1)).longValue() != 0;
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    if (C2570bj.m9515a(str, str2)) {
                        C2555av.m9495g(CommonApplication.m11493l()).show();
                        notifyDataSetChanged();
                        return;
                    } else {
                        C2555av.m9496h(CommonApplication.m11493l()).show();
                        return;
                    }
                }
                m9529a(str, true);
            }
        }
    }

    /* renamed from: a */
    public Cursor m9533a(Cursor cursor, int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onChangedChildCursor(), filter id : " + i, f9753b);
        }
        if (cursor == null) {
            if (this.f9754a != null) {
                this.f9754a.m9498a();
            }
        } else if (this.f9754a != null) {
            cursor.moveToPosition(-1);
            int columnIndex = cursor.getColumnIndex("item_id");
            int columnIndex2 = cursor.getColumnIndex("install");
            while (cursor.moveToNext()) {
                String string = cursor.getString(columnIndex);
                if (cursor.getInt(columnIndex2) != 0) {
                    this.f9754a.m9502a(string, EnumC2558ay.STATUS_INSTALLED);
                } else {
                    C2518i c2518i = (C2518i) C2525p.m9458a().m9459a(EnumC1399aq.Font, string);
                    if (c2518i == null) {
                        this.f9754a.m9502a(string, EnumC2558ay.STATUS_NOT_INSTALLED);
                    } else {
                        this.f9754a.m9500a(c2518i);
                    }
                }
            }
            this.f9754a.m9503b();
        }
        return cursor;
    }

    /* renamed from: a */
    public void m9534a(C2556aw c2556aw) {
        this.f9754a = c2556aw;
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: a */
    public void mo9422a(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9754a != null) {
            this.f9754a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALL_PROGRESSING);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: b */
    public void mo9428b(C2521l c2521l) {
        if (c2521l.m9455d() == 5 && this.f9754a != null) {
            this.f9754a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: c */
    public void mo9430c(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9754a != null) {
            switch (c2521l.m9455d()) {
                case 3:
                case 5:
                    this.f9754a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
                    break;
                case 4:
                    this.f9754a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALLED);
                    break;
            }
        }
    }

    @Override // android.widget.CursorTreeAdapter
    public void setGroupCursor(Cursor cursor) {
        if (cursor == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("group cursor. position/total : (null)", f9753b);
            }
            if (this.f9754a != null) {
                this.f9754a.m9498a();
            }
        } else {
            if (C3250y.f11734b) {
                C3250y.m11450b("group cursor. position/total : " + cursor.getPosition() + " / " + cursor.getCount(), f9753b);
            }
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                int i = cursor.getInt(cursor.getColumnIndex("filter_id"));
                m9533a(m9532a(i), i);
            }
        }
        super.setGroupCursor(cursor);
    }
}
