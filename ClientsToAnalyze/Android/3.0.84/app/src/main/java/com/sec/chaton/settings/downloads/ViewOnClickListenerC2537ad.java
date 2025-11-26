package com.sec.chaton.settings.downloads;

import android.content.Context;
import android.database.Cursor;
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
import com.sec.chaton.multimedia.emoticon.anicon.CallableC1825o;
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1358b;
import com.sec.chaton.p027e.p028a.C1359c;
import com.sec.chaton.settings.downloads.p056a.C2514e;
import com.sec.chaton.settings.downloads.p056a.C2521l;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.settings.downloads.p056a.InterfaceC2526q;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: AniconPackageAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.ad */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2537ad extends CursorAdapter implements View.OnClickListener, InterfaceC2526q {

    /* renamed from: b */
    private static final String f9669b = ViewOnClickListenerC2537ad.class.getSimpleName();

    /* renamed from: a */
    C2556aw f9670a;

    /* renamed from: c */
    private int f9671c;

    /* renamed from: d */
    private int f9672d;

    /* renamed from: e */
    private C3326c f9673e;

    /* renamed from: f */
    private HashMap<String, C2539af> f9674f;

    /* renamed from: g */
    private C1332j f9675g;

    /* renamed from: h */
    private InterfaceC2540ag f9676h;

    /* renamed from: i */
    private Handler f9677i;

    /* renamed from: a */
    public String m9478a(View view) {
        if (view == null) {
            return null;
        }
        C2539af c2539af = (C2539af) view.getTag();
        Cursor cursor = getCursor();
        cursor.moveToPosition(c2539af.f9679a);
        return cursor.getString(cursor.getColumnIndex("item_id"));
    }

    /* renamed from: a */
    public void m9479a(InterfaceC2540ag interfaceC2540ag) {
        this.f9676h = interfaceC2540ag;
    }

    /* renamed from: a */
    public boolean m9481a() {
        return C2525p.m9458a().m9462a(EnumC1399aq.Anicon);
    }

    /* renamed from: b */
    public void m9482b() {
        C2525p.m9458a().m9463b(EnumC1399aq.Anicon);
    }

    /* renamed from: c */
    public void m9483c() {
        C2525p.m9458a().m9466c(EnumC1399aq.Anicon);
    }

    public ViewOnClickListenerC2537ad(Context context, Cursor cursor, boolean z, C3326c c3326c) {
        super(context, cursor, z);
        this.f9677i = new HandlerC2538ae(this);
        this.f9671c = context.getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_width);
        this.f9672d = context.getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_height);
        this.f9673e = c3326c;
        this.f9674f = new HashMap<>();
        this.f9675g = new C1332j(context, null);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.item_list_anicon_package, viewGroup, false);
        C2539af c2539af = new C2539af(this, null);
        c2539af.f9680b = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_thumbnail);
        c2539af.f9681c = (TextView) viewInflate.findViewById(R.id.anicon_package_item_name);
        c2539af.f9682d = (TextView) viewInflate.findViewById(R.id.anicon_package_item_volume);
        c2539af.f9683e = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_download);
        c2539af.f9683e.setOnClickListener(this);
        c2539af.f9684f = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_ribbon);
        c2539af.f9685g = (ProgressBar) viewInflate.findViewById(R.id.anicon_package_item_progress);
        viewInflate.setTag(c2539af);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C2539af c2539af = (C2539af) view.getTag();
        C1359c c1359cM6004a = null;
        try {
            c1359cM6004a = C1358b.m6004a(cursor.getString(cursor.getColumnIndex("extras")));
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9669b);
            }
        }
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        int i = cursor.getInt(cursor.getColumnIndex("new"));
        int i2 = cursor.getInt(cursor.getColumnIndex("special"));
        String strM6011b = null;
        String strValueOf = String.valueOf(0);
        long jM6015d = 0;
        if (c1359cM6004a != null) {
            strM6011b = c1359cM6004a.m6011b();
            strValueOf = String.valueOf(c1359cM6004a.m6013c());
            jM6015d = c1359cM6004a.m6015d();
        }
        if (C3250y.f11734b) {
            long j = cursor.getLong(cursor.getColumnIndex("down_rank"));
            String string3 = cursor.getString(cursor.getColumnIndex("data1"));
            String string4 = cursor.getString(cursor.getColumnIndex("data2"));
            String string5 = cursor.getString(cursor.getColumnIndex("data3"));
            Object[] objArr = new Object[11];
            objArr[0] = string.toString();
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Long.valueOf(j);
            objArr[5] = string3;
            objArr[6] = string4;
            objArr[7] = string5;
            objArr[8] = Long.valueOf(jM6015d);
            objArr[9] = strValueOf;
            objArr[10] = string2 == null ? "(null)" : string2.toString();
            C3250y.m11450b(String.format("anicon_list, bindView() : [id:%s] [installed:%s] [special:%d] [new:%d] [downrank:%03d] [group:%s-%s-%s] [volume:%d] [piece:%s] [title:%s] ", objArr).toString(), f9669b);
        }
        this.f9674f.values().remove(c2539af);
        this.f9674f.put(string, c2539af);
        C2514e c2514e = (C2514e) C2525p.m9458a().m9459a(EnumC1399aq.Anicon, string);
        if (c2514e != null) {
            c2514e.m9446a(this.f9677i);
        }
        c2539af.f9679a = cursor.getPosition();
        c2539af.f9681c.setText(string2);
        c2539af.f9683e.setVisibility(0);
        c2539af.f9685g.setVisibility(8);
        if (z) {
            c2539af.f9683e.setImageResource(R.drawable.anicon_package_item_uninstall_event_xml);
            c2539af.f9682d.setText(C3364o.m11849a(strValueOf, " (", Long.valueOf(jM6015d / 1000), "KB) / ", this.mContext.getString(R.string.anicon_package_downloaded)));
            C2646u.m9657b(c2539af.f9682d);
        } else if (c2514e == null) {
            c2539af.f9683e.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            c2539af.f9685g.setVisibility(8);
            c2539af.f9682d.setText(C3364o.m11849a(strValueOf, " (", Long.valueOf(jM6015d / 1000), "KB)"));
            C2646u.m9649a(c2539af.f9682d);
        } else if (c2514e.m9455d() == 5) {
            c2539af.f9683e.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
            c2539af.f9685g.setVisibility(8);
            c2539af.f9682d.setText(C3364o.m11849a(strValueOf, " (", Long.valueOf(jM6015d / 1000), "KB)"));
            C2646u.m9649a(c2539af.f9682d);
        } else {
            c2539af.f9685g.setVisibility(0);
            switch (c2514e.m9455d()) {
                case 0:
                    c2539af.f9683e.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (!c2539af.f9685g.isIndeterminate()) {
                        c2539af.f9685g.setIndeterminate(true);
                    }
                    c2539af.f9682d.setText(C3364o.m11849a(strValueOf, " (", this.mContext.getString(R.string.download_progressing), ")"));
                    C2646u.m9665c(c2539af.f9682d);
                    break;
                case 1:
                    c2539af.f9683e.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                    if (c2539af.f9685g.isIndeterminate()) {
                        c2539af.f9685g.setIndeterminate(false);
                    }
                    c2539af.f9685g.setProgress(c2514e.m11747g().intValue());
                    c2539af.f9682d.setText(C3364o.m11849a(strValueOf, " (", Long.valueOf(jM6015d / 1000), "KB)"));
                    C2646u.m9665c(c2539af.f9682d);
                    break;
                case 2:
                    c2539af.f9683e.setVisibility(4);
                    c2539af.f9685g.setVisibility(8);
                    c2539af.f9682d.setText(this.mContext.getString(R.string.download_installing));
                    C2646u.m9668d(c2539af.f9682d);
                    break;
            }
        }
        c2539af.f9683e.setTag(c2539af);
        if (i2 != 0) {
            c2539af.f9684f.setVisibility(0);
            c2539af.f9684f.setImageResource(R.drawable.download_list_ic_special);
        } else if (i != 0) {
            c2539af.f9684f.setVisibility(0);
            c2539af.f9684f.setImageResource(R.drawable.download_list_ic_new);
        } else {
            c2539af.f9684f.setVisibility(8);
        }
        this.f9673e.m11730a(c2539af.f9680b, new CallableC1825o(strM6011b, this.f9671c, this.f9672d));
    }

    /* renamed from: a */
    private void m9476a(String str, boolean z) {
        C2514e c2514e = (C2514e) C2525p.m9458a().m9459a(EnumC1399aq.Anicon, str);
        if (c2514e == null) {
            new C2514e(this.f9675g, str).m11745d(new Void[0]);
        }
        if (c2514e.m9455d() == 5) {
            new C2514e(this.f9675g, str).m11745d(new Void[0]);
            return;
        }
        if (z) {
            switch (c2514e.m9455d()) {
                case 0:
                case 1:
                case 2:
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_anicon, download all - requestInstall : cancel(), id/status : " + str + "/" + c2514e.m9455d(), f9669b);
                    }
                    c2514e.m11744a(true);
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m9475a(String str, String str2) {
        if (this.f9676h != null) {
            this.f9676h.mo9334a(str, str2);
        }
    }

    /* renamed from: d */
    public void m9484d() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = getCursor();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("name"));
            boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            if (C3250y.f11734b && string2 != null) {
                C3250y.m11450b("download_anicon, download all, add into list,  id/name/install : " + string + "/" + string2.toString() + "/" + z, f9669b);
            }
            if (!TextUtils.isEmpty(string) && !z) {
                arrayList.add(string);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m9476a((String) it.next(), false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C2539af c2539af = (C2539af) view.getTag();
        Cursor cursor = getCursor();
        cursor.moveToPosition(c2539af.f9679a);
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        if (!TextUtils.isEmpty(string)) {
            if (z) {
                m9475a(string, string2);
            } else {
                m9476a(string, true);
            }
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("swapCursor(), newCursor : ", f9669b);
        }
        if (cursor == null) {
            if (this.f9670a != null) {
                this.f9670a.m9498a();
            }
        } else if (this.f9670a != null) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("item_id"));
                if (cursor.getInt(cursor.getColumnIndex("install")) != 0) {
                    this.f9670a.m9502a(string, EnumC2558ay.STATUS_INSTALLED);
                } else {
                    C2514e c2514e = (C2514e) C2525p.m9458a().m9459a(EnumC1399aq.Anicon, string);
                    if (c2514e == null) {
                        this.f9670a.m9502a(string, EnumC2558ay.STATUS_NOT_INSTALLED);
                    } else {
                        this.f9670a.m9500a(c2514e);
                    }
                }
            }
            this.f9670a.m9503b();
        }
        return super.swapCursor(cursor);
    }

    /* renamed from: a */
    public void m9480a(C2556aw c2556aw) {
        this.f9670a = c2556aw;
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: a */
    public void mo9422a(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9670a != null) {
            this.f9670a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALL_PROGRESSING);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: b */
    public void mo9428b(C2521l c2521l) {
        if (c2521l.m9455d() == 5 && this.f9670a != null) {
            this.f9670a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: c */
    public void mo9430c(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9670a != null) {
            switch (c2521l.m9455d()) {
                case 3:
                case 5:
                    this.f9670a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
                    break;
                case 4:
                    this.f9670a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALLED);
                    break;
            }
        }
    }
}
