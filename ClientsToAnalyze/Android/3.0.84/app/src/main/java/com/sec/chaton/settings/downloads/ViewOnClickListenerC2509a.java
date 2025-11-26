package com.sec.chaton.settings.downloads;

import android.content.Context;
import android.content.res.Resources;
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
import com.sec.chaton.multimedia.emoticon.anicon.CallableC1825o;
import com.sec.chaton.p025d.C1326d;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p027e.p028a.C1351a;
import com.sec.chaton.p035io.entry.inner.AmsItem;
import com.sec.chaton.settings.downloads.p056a.C2510a;
import com.sec.chaton.settings.downloads.p056a.C2521l;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.settings.downloads.p056a.InterfaceC2526q;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AmsItemAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC2509a extends CursorAdapter implements View.OnClickListener, InterfaceC2526q {

    /* renamed from: b */
    private static final String f9603b = ViewOnClickListenerC2509a.class.getSimpleName();

    /* renamed from: a */
    C2556aw f9604a;

    /* renamed from: c */
    private EnumC1327e f9605c;

    /* renamed from: d */
    private C1326d f9606d;

    /* renamed from: e */
    private C3326c f9607e;

    /* renamed from: f */
    private HashMap<String, C2587c> f9608f;

    /* renamed from: g */
    private InterfaceC2614d f9609g;

    /* renamed from: h */
    private Handler f9610h;

    /* renamed from: a */
    public boolean m9426a() {
        return C2525p.m9458a().m9462a(this.f9605c.m5703b());
    }

    /* renamed from: b */
    public void m9427b() {
        C2525p.m9458a().m9463b(this.f9605c.m5703b());
    }

    /* renamed from: c */
    public void m9429c() {
        C2525p.m9458a().m9466c(this.f9605c.m5703b());
    }

    /* renamed from: a */
    public AmsItem m9421a(String str) {
        C2587c c2587c;
        if (!TextUtils.isEmpty(str) && (c2587c = this.f9608f.get(str)) != null) {
            int i = c2587c.f9805a;
            Cursor cursor = getCursor();
            if (!cursor.moveToPosition(i)) {
                return null;
            }
            AmsItem amsItem = new AmsItem();
            try {
                C1351a.m5951a(amsItem, cursor.getString(cursor.getColumnIndex("extras")));
                amsItem.f5638id = cursor.getString(cursor.getColumnIndex("item_id"));
                amsItem.expirationdate = Long.valueOf(cursor.getLong(cursor.getColumnIndex("expiration_time")));
                return amsItem;
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9603b);
                }
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m9424a(InterfaceC2614d interfaceC2614d) {
        this.f9609g = interfaceC2614d;
    }

    public ViewOnClickListenerC2509a(Context context, Cursor cursor, boolean z, EnumC1327e enumC1327e, C3326c c3326c) {
        super(context, cursor, z);
        this.f9610h = new HandlerC2560b(this);
        this.f9605c = enumC1327e;
        this.f9606d = new C1326d(context, null);
        this.f9607e = c3326c;
        this.f9608f = new HashMap<>();
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_ams_item, viewGroup, false);
        if (this.f9605c == EnumC1327e.Stamp) {
            ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
            Resources resources = context.getResources();
            layoutParams.width = resources.getDimensionPixelOffset(R.dimen.ams_item_stamp_gridview_item_width);
            layoutParams.height = resources.getDimensionPixelOffset(R.dimen.ams_item_stamp_gridview_item_height);
            viewInflate.setLayoutParams(layoutParams);
            viewInflate.setBackgroundResource(R.color.bg_thumnail_background);
        }
        C2587c c2587c = new C2587c(this, null);
        c2587c.f9806b = (ImageView) viewInflate.findViewById(R.id.ams_item_ribbon);
        c2587c.f9807c = (ImageView) viewInflate.findViewById(R.id.ams_item_preview);
        if (this.f9605c == EnumC1327e.Stamp && GlobalApplication.m6456e()) {
            ViewGroup.LayoutParams layoutParams2 = c2587c.f9807c.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            c2587c.f9807c.setScaleType(ImageView.ScaleType.CENTER);
        }
        c2587c.f9808d = (ImageView) viewInflate.findViewById(R.id.ams_item_download_button);
        c2587c.f9809e = (ProgressBar) viewInflate.findViewById(R.id.ams_item_progress);
        c2587c.f9810f = (TextView) viewInflate.findViewById(R.id.ams_item_installing);
        c2587c.f9808d.setOnClickListener(this);
        viewInflate.setTag(c2587c);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws JSONException {
        try {
            C2587c c2587c = (C2587c) view.getTag();
            this.f9608f.values().remove(c2587c);
            JSONObject jSONObject = new JSONObject(cursor.getString(cursor.getColumnIndex("extras")));
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            String string2 = jSONObject.getString("thumbnailUrl");
            boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            int i = cursor.getInt(cursor.getColumnIndex("new"));
            int i2 = cursor.getInt(cursor.getColumnIndex("special"));
            c2587c.f9807c.setTag(c2587c);
            this.f9607e.m11730a(c2587c.f9807c, new CallableC1825o(string2));
            c2587c.f9805a = cursor.getPosition();
            this.f9608f.values().remove(c2587c);
            this.f9608f.put(string, c2587c);
            C2510a c2510a = (C2510a) C2525p.m9458a().m9459a(this.f9605c.m5703b(), string);
            if (c2510a != null) {
                c2510a.m9446a(this.f9610h);
            }
            c2587c.f9808d.setVisibility(0);
            c2587c.f9809e.setVisibility(8);
            c2587c.f9810f.setVisibility(8);
            if (z) {
                c2587c.f9808d.setImageResource(R.drawable.anicon_package_item_uninstall_event_xml);
                c2587c.f9809e.setVisibility(4);
            } else if (c2510a == null) {
                c2587c.f9808d.setImageResource(R.drawable.anicon_package_item_download_event_xml);
                c2587c.f9809e.setVisibility(4);
            } else if (c2510a.m9455d() == 5) {
                c2587c.f9808d.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
                c2587c.f9809e.setVisibility(4);
            } else {
                switch (c2510a.m9455d()) {
                    case 0:
                        c2587c.f9808d.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                        c2587c.f9809e.setVisibility(0);
                        if (!c2587c.f9809e.isIndeterminate()) {
                            c2587c.f9809e.setIndeterminate(true);
                            break;
                        }
                        break;
                    case 1:
                        c2587c.f9809e.setVisibility(0);
                        c2587c.f9808d.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                        if (c2587c.f9809e.isIndeterminate()) {
                            c2587c.f9809e.setIndeterminate(false);
                        }
                        c2587c.f9809e.setProgress(c2510a.m11747g().intValue());
                        break;
                    case 2:
                        c2587c.f9808d.setVisibility(8);
                        c2587c.f9809e.setVisibility(8);
                        c2587c.f9810f.setVisibility(0);
                        break;
                }
            }
            c2587c.f9808d.setTag(c2587c);
            if (i2 != 0) {
                c2587c.f9806b.setVisibility(0);
                c2587c.f9806b.setImageResource(R.drawable.download_ic_special);
            } else if (i != 0) {
                c2587c.f9806b.setVisibility(0);
                c2587c.f9806b.setImageResource(R.drawable.download_ic_new);
            } else {
                c2587c.f9806b.setVisibility(8);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public void m9425a(String str, boolean z) {
        C2510a c2510a = (C2510a) C2525p.m9458a().m9459a(this.f9605c.m5703b(), str);
        if (c2510a == null) {
            new C2510a(this.f9606d, this.f9605c, str).m11745d(new Void[0]);
        }
        if (c2510a.m9455d() == 5) {
            new C2510a(this.f9606d, this.f9605c, str).m11745d(new Void[0]);
        } else if (z) {
            switch (c2510a.m9455d()) {
                case 0:
                case 1:
                case 2:
                    c2510a.m11744a(true);
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m9419b(String str) {
        if (this.f9609g != null) {
            this.f9609g.mo9306a(this.f9605c, str);
        }
    }

    /* renamed from: d */
    public void m9431d() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = getCursor();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
            if (C3250y.f11734b) {
                C3250y.m11450b("download_ams, download all, add into list,  id/install : " + string + "/" + z, f9603b);
            }
            if (!TextUtils.isEmpty(string) && !z) {
                arrayList.add(string);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m9425a((String) it.next(), false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C2587c c2587c = (C2587c) view.getTag();
        Cursor cursor = getCursor();
        cursor.moveToPosition(c2587c.f9805a);
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        if (!TextUtils.isEmpty(string)) {
            if (z) {
                m9419b(string);
            } else {
                m9425a(string, true);
            }
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("swapCursor(), newCursor : ", f9603b);
        }
        if (cursor == null) {
            if (this.f9604a != null) {
                this.f9604a.m9498a();
            }
        } else if (this.f9604a != null) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("item_id"));
                if (cursor.getInt(cursor.getColumnIndex("install")) != 0) {
                    this.f9604a.m9502a(string, EnumC2558ay.STATUS_INSTALLED);
                } else {
                    C2510a c2510a = (C2510a) C2525p.m9458a().m9459a(this.f9605c.m5703b(), string);
                    if (c2510a == null) {
                        this.f9604a.m9502a(string, EnumC2558ay.STATUS_NOT_INSTALLED);
                    } else {
                        this.f9604a.m9500a(c2510a);
                    }
                }
            }
            this.f9604a.m9503b();
        }
        return super.swapCursor(cursor);
    }

    /* renamed from: a */
    public void m9423a(C2556aw c2556aw) {
        this.f9604a = c2556aw;
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: a */
    public void mo9422a(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9604a != null) {
            this.f9604a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALL_PROGRESSING);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: b */
    public void mo9428b(C2521l c2521l) {
        if (c2521l.m9455d() == 5 && this.f9604a != null) {
            this.f9604a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
        }
    }

    @Override // com.sec.chaton.settings.downloads.p056a.InterfaceC2526q
    /* renamed from: c */
    public void mo9430c(C2521l c2521l) {
        notifyDataSetChanged();
        if (this.f9604a != null) {
            switch (c2521l.m9455d()) {
                case 3:
                case 5:
                    this.f9604a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_NOT_INSTALLED);
                    break;
                case 4:
                    this.f9604a.m9504b(c2521l.m9454c(), EnumC2558ay.STATUS_INSTALLED);
                    break;
            }
        }
    }
}
