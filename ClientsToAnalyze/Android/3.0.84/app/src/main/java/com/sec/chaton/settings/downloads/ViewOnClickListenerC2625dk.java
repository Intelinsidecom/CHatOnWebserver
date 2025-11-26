package com.sec.chaton.settings.downloads;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.AsyncTaskC1772d;
import com.sec.chaton.multimedia.audio.EnumC1774f;
import com.sec.chaton.p025d.C1317bc;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1355ad;
import com.sec.chaton.p027e.p028a.C1356ae;
import com.sec.chaton.settings.downloads.p056a.C2521l;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.settings.downloads.p056a.C2531v;
import com.sec.chaton.settings.downloads.p056a.InterfaceC2526q;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.widget.C3641ai;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: SoundListAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.dk */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2625dk extends CursorAdapter implements View.OnClickListener, InterfaceC2526q {

    /* renamed from: b */
    C2556aw f9856b;

    /* renamed from: c */
    C2580bt f9857c;

    /* renamed from: e */
    private HashMap<String, C2629do> f9858e;

    /* renamed from: f */
    private C1317bc f9859f;

    /* renamed from: g */
    private InterfaceC2628dn f9860g;

    /* renamed from: h */
    private Handler f9861h;

    /* renamed from: i */
    private Handler f9862i;

    /* renamed from: d */
    private static final String f9855d = ViewOnClickListenerC2625dk.class.getSimpleName();

    /* renamed from: a */
    static final String f9854a = ViewOnClickListenerC2625dk.class.getName();

    @Override // android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("swapCursor(), newCursor : ", f9855d);
        }
        if (cursor == null) {
            if (this.f9856b != null) {
                this.f9856b.m9498a();
            }
        } else if (this.f9856b != null) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("item_id"));
                if (cursor.getInt(cursor.getColumnIndex("install")) != 0) {
                    this.f9856b.m9502a(string, EnumC2558ay.STATUS_INSTALLED);
                } else {
                    C2531v c2531v = (C2531v) C2525p.m9458a().m9459a(EnumC1399aq.Sound, string);
                    if (c2531v == null) {
                        this.f9856b.m9502a(string, EnumC2558ay.STATUS_NOT_INSTALLED);
                    } else {
                        this.f9856b.m9500a(c2531v);
                    }
                }
            }
            this.f9856b.m9503b();
        }
        return super.swapCursor(cursor);
    }

    /* renamed from: a */
    public boolean m9625a(String str, EnumC1774f enumC1774f) {
        if (TextUtils.isEmpty(str) || enumC1774f == null) {
            return false;
        }
        notifyDataSetChanged();
        return true;
    }

    /* renamed from: a */
    public void m9623a(InterfaceC2628dn interfaceC2628dn) {
        this.f9860g = interfaceC2628dn;
    }

    /* renamed from: a */
    public void m9622a(C2556aw c2556aw) {
        this.f9856b = c2556aw;
    }

    /* renamed from: a */
    public boolean m9624a() {
        return C2525p.m9458a().m9462a(EnumC1399aq.Sound);
    }

    /* renamed from: b */
    public void m9626b() {
        C2525p.m9458a().m9463b(EnumC1399aq.Sound);
    }

    /* renamed from: c */
    public void m9628c() {
        C2525p.m9458a().m9466c(EnumC1399aq.Sound);
    }

    public ViewOnClickListenerC2625dk(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f9861h = new HandlerC2626dl(this);
        this.f9862i = new HandlerC2627dm(this);
        this.f9857c = C2580bt.m9540a(f9854a, this.f9861h);
        this.f9858e = new HashMap<>();
        this.f9859f = new C1317bc(context, null);
    }

    /* renamed from: d */
    void m9629d() {
        C2580bt.m9541b(f9854a, this.f9861h);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.item_list_download_sound, viewGroup, false);
        C2629do c2629do = new C2629do();
        c2629do.f9867c = (ImageView) viewInflate.findViewById(R.id.item_thumbnail);
        c2629do.f9867c.setOnClickListener(this);
        c2629do.f9868d = (TextView) viewInflate.findViewById(R.id.item_name);
        c2629do.f9869e = (TextView) viewInflate.findViewById(R.id.item_volume);
        c2629do.f9870f = (ImageView) viewInflate.findViewById(R.id.item_download);
        c2629do.f9870f.setOnClickListener(this);
        c2629do.f9871g = (TextView) viewInflate.findViewById(R.id.item_ribbon);
        c2629do.f9872h = (ProgressBar) viewInflate.findViewById(R.id.item_download_progress);
        viewInflate.setTag(c2629do);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException {
        C2629do c2629do = (C2629do) view.getTag();
        C1356ae c1356aeM5977a = null;
        try {
            c1356aeM5977a = C1355ad.m5977a(cursor.getString(cursor.getColumnIndex("extras")));
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9855d);
            }
        }
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        long jM5980a = 0;
        if (c1356aeM5977a != null) {
            jM5980a = c1356aeM5977a.m5980a();
        }
        boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        int i = cursor.getInt(cursor.getColumnIndex("new"));
        int i2 = cursor.getInt(cursor.getColumnIndex("special"));
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("download_sound, bindView() : [id:%s] [install:%s] [special:%d] [new:%d] [downrank:%03d] [group:%s-%s-%s] [volume:%d] [piece:%s] [title:%s] ", string.toString(), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(cursor.getLong(cursor.getColumnIndex("down_rank"))), cursor.getString(cursor.getColumnIndex("data1")), cursor.getString(cursor.getColumnIndex("data2")), cursor.getString(cursor.getColumnIndex("data3")), Long.valueOf(jM5980a), "(n/a)", string2.toString()).toString(), f9855d);
        }
        this.f9858e.values().remove(c2629do);
        this.f9858e.put(string, c2629do);
        C2531v c2531v = (C2531v) C2525p.m9458a().m9459a(EnumC1399aq.Sound, string);
        if (c2531v != null) {
            c2531v.m9446a(this.f9862i);
        }
        c2629do.f9865a = cursor.getPosition();
        c2629do.f9866b = string;
        c2629do.f9868d.setText(string2);
        c2629do.f9870f.setVisibility(0);
        c2629do.f9872h.setVisibility(8);
        EnumC1774f enumC1774fM9549c = this.f9857c.m9549c(string);
        if (enumC1774fM9549c == null) {
            enumC1774fM9549c = EnumC1774f.PLAY_STATUS_FINISHED;
        }
        C2620df.m9598a(c2629do.f9867c, enumC1774fM9549c);
        if (z) {
            if (C2620df.m9599a(string)) {
                c2629do.f9870f.setImageResource(R.drawable.download_ic_apply_02);
                c2629do.f9870f.setEnabled(false);
            } else {
                c2629do.f9870f.setImageResource(R.drawable.download_ic_apply_01);
                c2629do.f9870f.setEnabled(true);
            }
            c2629do.f9869e.setText(C3364o.m11849a(" (", Long.valueOf(jM5980a / 1000), "KB) / ", this.mContext.getString(R.string.anicon_package_downloaded)));
            C2620df.m9605b(c2629do.f9869e);
        } else if (c2531v == null) {
            c2629do.f9870f.setImageResource(R.drawable.download_ic_download_01);
            c2629do.f9870f.setEnabled(true);
            c2629do.f9872h.setVisibility(8);
            c2629do.f9869e.setText(C3364o.m11849a(" (", Long.valueOf(jM5980a / 1000), "KB)"));
            C2620df.m9597a(c2629do.f9869e);
        } else if (c2531v.m9455d() == 5) {
            c2629do.f9870f.setImageResource(R.drawable.download_ic_fail_01);
            c2629do.f9872h.setVisibility(8);
            c2629do.f9869e.setText(C3364o.m11849a(" (", Long.valueOf(jM5980a / 1000), "KB)"));
            C2620df.m9597a(c2629do.f9869e);
        } else {
            c2629do.f9872h.setVisibility(0);
            switch (c2531v.m9455d()) {
                case 0:
                    c2629do.f9870f.setImageResource(R.drawable.download_ic_cancel_01);
                    if (!c2629do.f9872h.isIndeterminate()) {
                        c2629do.f9872h.setIndeterminate(true);
                    }
                    c2629do.f9869e.setText(C3364o.m11849a(" (", this.mContext.getString(R.string.download_progressing), ")"));
                    C2620df.m9607c(c2629do.f9869e);
                    break;
                case 1:
                    c2629do.f9870f.setImageResource(R.drawable.download_ic_cancel_01);
                    if (c2629do.f9872h.isIndeterminate()) {
                        c2629do.f9872h.setIndeterminate(false);
                    }
                    c2629do.f9872h.setProgress(c2531v.m11747g().intValue());
                    c2629do.f9869e.setText(C3364o.m11849a(" (", Long.valueOf(jM5980a / 1000), "KB)"));
                    C2620df.m9607c(c2629do.f9869e);
                    break;
                case 2:
                    c2629do.f9870f.setVisibility(4);
                    c2629do.f9872h.setVisibility(8);
                    c2629do.f9869e.setText(this.mContext.getString(R.string.download_installing));
                    C2620df.m9609d(c2629do.f9869e);
                    break;
            }
        }
        c2629do.f9867c.setTag(c2629do);
        c2629do.f9870f.setTag(c2629do);
        if (i2 != 0) {
            c2629do.f9871g.setVisibility(0);
            c2629do.f9871g.setText(R.string.download_special_ribbon_text);
            c2629do.f9871g.setBackgroundColor(Color.parseColor("#3eb1b9"));
        } else {
            if (i != 0) {
                c2629do.f9871g.setVisibility(0);
                c2629do.f9871g.setText(R.string.download_new_ribbon_text);
                c2629do.f9871g.setBackgroundColor(Color.parseColor("#e86d00"));
                return;
            }
            c2629do.f9871g.setVisibility(8);
        }
    }

    /* renamed from: a */
    public String m9620a(View view) {
        if (view == null) {
            return null;
        }
        return m9619a(((C2629do) view.getTag()).f9865a);
    }

    /* renamed from: a */
    public String m9619a(int i) {
        Cursor cursor = getCursor();
        cursor.moveToPosition(i);
        return cursor.getString(cursor.getColumnIndex("item_id"));
    }

    /* renamed from: a */
    public String m9621a(String str) {
        String strM5983b;
        C2629do c2629do = this.f9858e.get(str);
        if (c2629do == null) {
            return null;
        }
        Cursor cursor = getCursor();
        cursor.moveToPosition(c2629do.f9865a);
        try {
            strM5983b = C1355ad.m5977a(cursor.getString(cursor.getColumnIndex("extras"))).m5983b();
        } catch (JSONException e) {
            e.printStackTrace();
            strM5983b = null;
        }
        return strM5983b;
    }

    /* renamed from: a */
    private void m9616a(String str, boolean z) {
        C2531v c2531v = (C2531v) C2525p.m9458a().m9459a(EnumC1399aq.Sound, str);
        if (c2531v == null) {
            new C2531v(this.f9859f, str).m11745d(new Void[0]);
        }
        if (c2531v.m9455d() == 5) {
            new C2531v(this.f9859f, str).m11745d(new Void[0]);
            return;
        }
        if (z) {
            switch (c2531v.m9455d()) {
                case 0:
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_sound, download all - requestInstall : cancel(), id/status : " + str + "/" + c2531v.m9455d(), f9855d);
                    }
                    c2531v.m11744a(true);
                    break;
            }
        }
    }

    /* renamed from: e */
    public void m9630e() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = getCursor();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("name"));
            boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            if (C3250y.f11734b) {
                C3250y.m11450b("download_sound, download all, add into list,  id/name/install : " + string + "/" + string2.toString() + "/" + z, f9855d);
            }
            if (!TextUtils.isEmpty(string) && !z) {
                arrayList.add(string);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m9616a((String) it.next(), false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_thumbnail /* 2131165644 */:
                C2629do c2629do = (C2629do) view.getTag();
                if (c2629do != null && this.f9860g != null) {
                    m9627b(c2629do.f9866b);
                    break;
                }
                break;
            case R.id.item_download /* 2131165646 */:
                C2629do c2629do2 = (C2629do) view.getTag();
                Cursor cursor = getCursor();
                cursor.moveToPosition(c2629do2.f9865a);
                String string = cursor.getString(cursor.getColumnIndex("item_id"));
                String string2 = cursor.getString(cursor.getColumnIndex("name"));
                boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
                if (!TextUtils.isEmpty(string)) {
                    if (z) {
                        if (C2620df.m9600a(string, string2)) {
                            C2555av.m9495g(this.mContext).show();
                            notifyDataSetChanged();
                            break;
                        } else {
                            C2555av.m9496h(this.mContext).show();
                            break;
                        }
                    } else {
                        m9616a(string, true);
                        break;
                    }
                }
                break;
        }
    }

    /* renamed from: b */
    void m9627b(String str) {
        if (TextUtils.isEmpty(str)) {
            if (C3250y.f11734b) {
                C3250y.m11450b("download_sound, requestPlaySample(), itemid is (empty)", f9855d);
                return;
            }
            return;
        }
        try {
            try {
                File file = new File(new URI(C2620df.m9606c(CommonApplication.m11493l(), str).toString()));
                if (file != null && file.exists()) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("download_sound, requestPlaySample(), play installed file : ", str), f9855d);
                    }
                    m9615a(str, file.getPath());
                    return;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("download_sound, requestPlaySample(), play download file : ", str), f9855d);
                }
                String strM9621a = m9621a(str);
                if (TextUtils.isEmpty(strM9621a)) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_sound, requestPlaySample(), sample url is (empty)", f9855d);
                    }
                    m9631f();
                    return;
                }
                m9617b(str, strM9621a);
            } catch (IllegalArgumentException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9855d);
                }
                m9631f();
            }
        } catch (URISyntaxException e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f9855d);
            }
            m9631f();
        }
    }

    /* renamed from: f */
    void m9631f() {
        C3641ai.m13211a(CommonApplication.m11493l(), CommonApplication.m11493l().getString(R.string.download_failed), 0).show();
    }

    /* renamed from: a */
    private void m9615a(String str, String str2) {
        if (this.f9857c != null) {
            this.f9857c.m9547b(new AsyncTaskC1772d(str, str2, null));
        }
    }

    /* renamed from: b */
    private void m9617b(String str, String str2) {
        if (this.f9857c != null) {
            this.f9857c.m9547b(new AsyncTaskC1772d(str, str2, null, true));
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: a */
    public void mo9422a(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9856b != null) {
            this.f9856b.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALL_PROGRESSING);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: b */
    public void mo9428b(C2521l c2521l) {
        if (c2521l.m9455d() == 5 && this.f9856b != null) {
            this.f9856b.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: c */
    public void mo9430c(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9856b != null) {
            switch (c2521l.m9455d()) {
                case 3:
                case 5:
                    this.f9856b.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
                    break;
                case 4:
                    this.f9856b.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALLED);
                    break;
            }
        }
    }
}
