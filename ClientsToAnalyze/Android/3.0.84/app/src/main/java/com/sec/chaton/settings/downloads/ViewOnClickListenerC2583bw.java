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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0823h;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1353ab;
import com.sec.chaton.p027e.p028a.C1354ac;
import com.sec.chaton.settings.downloads.p056a.C2521l;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.settings.downloads.p056a.C2527r;
import com.sec.chaton.settings.downloads.p056a.InterfaceC2526q;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: SkinAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.bw */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2583bw extends CursorAdapter implements View.OnClickListener, InterfaceC2526q {

    /* renamed from: b */
    private static final String f9790b = ViewOnClickListenerC2583bw.class.getSimpleName();

    /* renamed from: a */
    C2556aw f9791a;

    /* renamed from: c */
    private C3326c f9792c;

    /* renamed from: d */
    private C0823h f9793d;

    /* renamed from: e */
    private HashMap<String, C2586bz> f9794e;

    /* renamed from: f */
    private InterfaceC2585by f9795f;

    /* renamed from: g */
    private Handler f9796g;

    public ViewOnClickListenerC2583bw(Context context, Cursor cursor, boolean z, C3326c c3326c) {
        super(context, cursor, z);
        this.f9796g = new HandlerC2584bx(this);
        this.f9792c = c3326c;
        this.f9793d = new C0823h(this.mContext, null);
        this.f9794e = new HashMap<>();
    }

    /* renamed from: a */
    public boolean m9560a() {
        return C2525p.m9458a().m9462a(EnumC1399aq.Skin);
    }

    /* renamed from: b */
    public void m9561b() {
        C2525p.m9458a().m9463b(EnumC1399aq.Skin);
    }

    /* renamed from: c */
    public void m9562c() {
        C2525p.m9458a().m9466c(EnumC1399aq.Skin);
    }

    /* renamed from: a */
    public void m9559a(InterfaceC2585by interfaceC2585by) {
        this.f9795f = interfaceC2585by;
    }

    /* renamed from: a */
    public String m9557a(View view) {
        if (view == null) {
            return null;
        }
        C2586bz c2586bz = (C2586bz) view.getTag();
        Cursor cursor = getCursor();
        cursor.moveToPosition(c2586bz.f9798a);
        return cursor.getString(cursor.getColumnIndex("item_id"));
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_theme, viewGroup, false);
        C2586bz c2586bz = new C2586bz(this);
        c2586bz.f9799b = (ImageView) viewInflate.findViewById(R.id.theme_item_ribbon);
        c2586bz.f9800c = (ImageView) viewInflate.findViewById(R.id.theme_preview);
        if (GlobalApplication.m6456e()) {
            c2586bz.f9800c.setOnClickListener(this);
        }
        c2586bz.f9802e = (ProgressBar) viewInflate.findViewById(R.id.theme_download_progress);
        c2586bz.f9801d = (ImageView) viewInflate.findViewById(R.id.theme_download_button);
        c2586bz.f9801d.setOnClickListener(this);
        c2586bz.f9803f = (TextView) viewInflate.findViewById(R.id.theme_download_installing);
        viewInflate.setTag(c2586bz);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        try {
            C2586bz c2586bz = (C2586bz) view.getTag();
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            int i = cursor.getInt(cursor.getColumnIndex("new"));
            int i2 = cursor.getInt(cursor.getColumnIndex("special"));
            C1354ac c1354acM5964a = C1353ab.m5964a(cursor.getString(cursor.getColumnIndex("extras")));
            c2586bz.f9798a = cursor.getPosition();
            this.f9794e.values().remove(c2586bz);
            this.f9794e.put(string, c2586bz);
            C2527r c2527r = (C2527r) C2525p.m9458a().m9459a(EnumC1399aq.Skin, string);
            if (c2527r != null) {
                c2527r.m9446a(this.f9796g);
            }
            C2607ct c2607ct = new C2607ct(c1354acM5964a.m5968a());
            c2607ct.m7494a(R.drawable.download_default);
            this.f9792c.m11730a(c2586bz.f9800c, c2607ct);
            c2586bz.f9801d.setVisibility(0);
            c2586bz.f9802e.setVisibility(8);
            c2586bz.f9803f.setVisibility(8);
            if (z) {
                c2586bz.f9801d.setImageResource(R.drawable.anicon_package_item_download_apply_xml);
                boolean zM9575b = C2591cd.m9575b(string);
                if (zM9575b) {
                    c2586bz.f9801d.setImageResource(R.drawable.download_ic_applied);
                    c2586bz.f9801d.setEnabled(false);
                } else {
                    c2586bz.f9801d.setEnabled(true);
                }
                if (GlobalApplication.m6456e()) {
                    c2586bz.f9801d.setFocusable(!zM9575b);
                }
                c2586bz.f9802e.setVisibility(4);
            } else if (c2527r == null) {
                c2586bz.f9801d.setImageResource(R.drawable.anicon_package_item_download_event_xml);
                c2586bz.f9802e.setVisibility(4);
            } else if (c2527r.m9455d() == 5) {
                c2586bz.f9801d.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
                c2586bz.f9802e.setVisibility(4);
            } else {
                switch (c2527r.m9455d()) {
                    case 0:
                        c2586bz.f9801d.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                        c2586bz.f9802e.setVisibility(0);
                        if (!c2586bz.f9802e.isIndeterminate()) {
                            c2586bz.f9802e.setIndeterminate(true);
                            break;
                        }
                        break;
                    case 1:
                        c2586bz.f9802e.setVisibility(0);
                        c2586bz.f9801d.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                        if (c2586bz.f9802e.isIndeterminate()) {
                            c2586bz.f9802e.setIndeterminate(false);
                        }
                        c2586bz.f9802e.setProgress(c2527r.m11747g().intValue());
                        break;
                    case 2:
                        c2586bz.f9801d.setVisibility(8);
                        c2586bz.f9802e.setVisibility(8);
                        c2586bz.f9803f.setVisibility(0);
                        break;
                }
            }
            c2586bz.f9801d.setTag(c2586bz);
            if (GlobalApplication.m6456e()) {
                c2586bz.f9800c.setTag(c2586bz);
            }
            if (i2 != 0) {
                c2586bz.f9799b.setVisibility(0);
                c2586bz.f9799b.setImageResource(R.drawable.download_ic_special);
            } else if (i != 0) {
                c2586bz.f9799b.setVisibility(0);
                c2586bz.f9799b.setImageResource(R.drawable.download_ic_new);
            } else {
                c2586bz.f9799b.setVisibility(8);
            }
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9790b);
            }
        }
    }

    /* renamed from: a */
    private void m9555a(String str, String str2, boolean z) {
        C2527r c2527r = (C2527r) C2525p.m9458a().m9459a(EnumC1399aq.Skin, str);
        if (c2527r == null) {
            new C2527r(this.f9793d, str, str2).m11745d(new Void[0]);
        }
        if (c2527r.m9455d() == 5) {
            new C2527r(this.f9793d, str, str2).m11745d(new Void[0]);
        } else if (z) {
            switch (c2527r.m9455d()) {
                case 0:
                case 1:
                case 2:
                    c2527r.m11744a(true);
                    break;
            }
        }
    }

    /* renamed from: d */
    public void m9563d() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = getCursor();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            C1354ac c1354acM5964a = C1353ab.m5964a(cursor.getString(cursor.getColumnIndex("extras")));
            String strM5971b = c1354acM5964a.m5971b();
            if (C3250y.f11734b) {
                C3250y.m11450b("download_skin, download all, add into list,  id/backgroudType/install : " + string + "/" + strM5971b + "/" + z, f9790b);
            }
            if (!TextUtils.isEmpty(string) && !z) {
                arrayList.add(new String[]{string, c1354acM5964a.m5971b()});
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] strArr = (String[]) it.next();
            m9555a(strArr[0], strArr[1], false);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0081 -> B:30:0x0023). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0083 -> B:30:0x0023). Please report as a decompilation issue!!! */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (GlobalApplication.m6456e() && view.getId() == R.id.theme_preview) {
            String strM9557a = m9557a(view);
            if (this.f9795f != null && !TextUtils.isEmpty(strM9557a)) {
                this.f9795f.mo9386a(strM9557a);
                return;
            }
            return;
        }
        try {
            C2586bz c2586bz = (C2586bz) view.getTag();
            Cursor cursor = getCursor();
            cursor.moveToPosition(c2586bz.f9798a);
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            C1354ac c1354acM5964a = C1353ab.m5964a(cursor.getString(cursor.getColumnIndex("extras")));
            if (!TextUtils.isEmpty(string)) {
                if (z) {
                    if (C2591cd.m9571a(string, c1354acM5964a.m5971b())) {
                        C2555av.m9495g(CommonApplication.m11493l()).show();
                        notifyDataSetChanged();
                        this.f9795f.mo9384a();
                    } else {
                        C2555av.m9496h(CommonApplication.m11493l()).show();
                    }
                } else {
                    m9555a(string, c1354acM5964a.m5971b(), true);
                }
            }
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9790b);
            }
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("swapCursor(), newCursor : ", f9790b);
        }
        if (cursor == null) {
            if (this.f9791a != null) {
                this.f9791a.m9498a();
            }
        } else if (this.f9791a != null) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("item_id"));
                if (cursor.getInt(cursor.getColumnIndex("install")) != 0) {
                    this.f9791a.m9502a(string, EnumC2558ay.STATUS_INSTALLED);
                } else {
                    C2527r c2527r = (C2527r) C2525p.m9458a().m9459a(EnumC1399aq.Skin, string);
                    if (c2527r == null) {
                        this.f9791a.m9502a(string, EnumC2558ay.STATUS_NOT_INSTALLED);
                    } else {
                        this.f9791a.m9500a(c2527r);
                    }
                }
            }
            this.f9791a.m9503b();
        }
        return super.swapCursor(cursor);
    }

    /* renamed from: a */
    public void m9558a(C2556aw c2556aw) {
        this.f9791a = c2556aw;
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: a */
    public void mo9422a(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9791a != null) {
            this.f9791a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALL_PROGRESSING);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: b */
    public void mo9428b(C2521l c2521l) {
        if (c2521l.m9455d() == 5 && this.f9791a != null) {
            this.f9791a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: c */
    public void mo9430c(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9791a != null) {
            switch (c2521l.m9455d()) {
                case 3:
                case 5:
                    this.f9791a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
                    break;
                case 4:
                    this.f9791a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALLED);
                    break;
            }
        }
    }
}
