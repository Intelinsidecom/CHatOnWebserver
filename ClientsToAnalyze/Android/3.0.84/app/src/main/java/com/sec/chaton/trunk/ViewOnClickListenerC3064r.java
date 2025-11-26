package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.trunk.database.EnumC3048d;
import com.sec.chaton.trunk.p058a.EnumC2959b;
import com.sec.chaton.trunk.p060b.AsyncTaskC2988b;
import com.sec.chaton.trunk.p060b.C2987a;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3347i;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.r */
/* loaded from: classes.dex */
public class ViewOnClickListenerC3064r extends BaseAdapter implements View.OnClickListener {

    /* renamed from: o */
    private static C1377u f10963o;

    /* renamed from: a */
    public boolean f10965a;

    /* renamed from: e */
    private C3326c f10968e;

    /* renamed from: f */
    private Context f10969f;

    /* renamed from: g */
    private EnumC2959b f10970g;

    /* renamed from: h */
    private String f10971h;

    /* renamed from: i */
    private TrunkView f10972i;

    /* renamed from: j */
    private int f10973j;

    /* renamed from: l */
    private Cursor f10975l;

    /* renamed from: m */
    private List<String> f10976m;

    /* renamed from: n */
    private LayoutInflater f10977n;

    /* renamed from: b */
    private static final String f10962b = ViewOnClickListenerC3064r.class.getSimpleName();

    /* renamed from: q */
    private static InterfaceC1378v f10964q = new C3066t();

    /* renamed from: k */
    private int f10974k = 9;

    /* renamed from: p */
    private Handler f10978p = new HandlerC3065s(this);

    /* renamed from: d */
    private Map<View, AsyncTaskC2988b> f10967d = new HashMap();

    /* renamed from: c */
    private HashMap<String, Boolean> f10966c = new HashMap<>();

    public ViewOnClickListenerC3064r(Context context, Cursor cursor, int i, EnumC2959b enumC2959b, String str, C3326c c3326c, TrunkView trunkView, List<String> list) {
        this.f10968e = c3326c;
        this.f10969f = context;
        this.f10970g = enumC2959b;
        this.f10971h = str;
        this.f10972i = trunkView;
        this.f10975l = cursor;
        this.f10976m = list;
        this.f10977n = (LayoutInflater) this.f10969f.getSystemService("layout_inflater");
        if (context.getResources().getConfiguration().orientation == 1) {
            this.f10973j = C3347i.m11779b() / 3;
        } else {
            this.f10973j = C3347i.m11779b() / 5;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10976m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10976m.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3069w c3069w;
        int count;
        C3250y.m11456e("yeseul / getView Start ", f10962b);
        C3250y.m11456e("getTag position: " + i + " get: " + (i % this.f10974k), f10962b);
        if (view == null) {
            view = this.f10977n.inflate(R.layout.layout_trunk_gallery_view, viewGroup, false);
            C3069w c3069wM10584a = m10584a(view);
            view.setTag(c3069wM10584a);
            c3069w = c3069wM10584a;
        } else {
            C3069w c3069w2 = (C3069w) view.getTag();
            C3250y.m11456e("getTag sconvertView " + view.getId(), f10962b);
            c3069w = c3069w2;
        }
        if (this.f10974k * i <= this.f10975l.getCount()) {
            count = this.f10974k * i;
        } else {
            count = this.f10975l.getCount();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f10975l.moveToPosition(count)) {
            int i2 = 0;
            do {
                int i3 = i2;
                String string = this.f10975l.getString(this.f10975l.getColumnIndex("item_id"));
                EnumC3048d enumC3048dM10572a = EnumC3048d.m10572a(this.f10975l.getInt(this.f10975l.getColumnIndex("item_type")));
                int i4 = this.f10975l.getInt(this.f10975l.getColumnIndex("total_comment_count"));
                String string2 = this.f10975l.getString(this.f10975l.getColumnIndex("thumbnail"));
                int i5 = this.f10975l.getInt(this.f10975l.getColumnIndex("unread_comment_count"));
                String string3 = this.f10975l.getString(this.f10975l.getColumnIndex("isams"));
                arrayList.add(new C3068v(this, string, enumC3048dM10572a, i4, string2, i5, string3, C3025f.m10537a(this.f10975l.getString(this.f10975l.getColumnIndex("content_type")), "true".equals(string3)), this.f10975l.getString(this.f10975l.getColumnIndex("down_url")), this.f10975l.getString(this.f10975l.getColumnIndex("sender_uid"))));
                if (!this.f10975l.moveToNext()) {
                    break;
                }
                i2 = i3 + 1;
            } while (i2 < this.f10974k);
        }
        if (arrayList.size() < this.f10974k) {
            for (int size = arrayList.size(); size < this.f10974k; size++) {
                this.f10968e.m11732a(c3069w.f11001b[size].f10981b);
            }
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.f10974k) {
                if (arrayList.size() > i7) {
                    C3068v c3068v = (C3068v) arrayList.get(i7);
                    c3069w.f11001b[i7].f10983d.setVisibility(8);
                    m10590a(c3069w.f11001b[i7], c3068v);
                    c3069w.f11001b[i7].f10980a.setTag(c3069w);
                    c3069w.f11001b[i7].f10980a.setVisibility(0);
                    c3069w.f11002c[i7] = c3068v;
                    c3069w.f11002c[i7].f10998j = c3069w.f11001b[i7].f10982c;
                    if (c3068v.f10993e > 0) {
                        c3069w.f11001b[i7].f10985f.setImageResource(R.drawable.trunk_ic_comment_unread_chats);
                    } else {
                        c3069w.f11001b[i7].f10985f.setImageResource(R.drawable.trunk_ic_comment_read);
                    }
                    C3025f.m10539a(c3069w.f11001b[i7].f10984e, c3068v.f10991c);
                    if (c3068v.f10991c <= 0) {
                        c3069w.f11001b[i7].f10984e.setVisibility(8);
                        c3069w.f11001b[i7].f10985f.setVisibility(8);
                    } else {
                        c3069w.f11001b[i7].f10984e.setVisibility(0);
                        c3069w.f11001b[i7].f10985f.setVisibility(0);
                    }
                    if (this.f10965a) {
                        c3069w.f11002c[i7].f10998j.setVisibility(0);
                        c3069w.f11001b[i7].f10986g.setVisibility(0);
                        m10591a(c3069w, i7);
                    } else {
                        c3069w.f11002c[i7].f10998j.setVisibility(8);
                        c3069w.f11001b[i7].f10986g.setVisibility(8);
                    }
                } else {
                    c3069w.f11001b[i7].f10981b.setImageBitmap(null);
                    c3069w.f11001b[i7].f10980a.setVisibility(8);
                    c3069w.f11001b[i7].f10980a.setTag(null);
                    c3069w.f11002c[i7] = null;
                }
                i6 = i7 + 1;
            } else {
                C3250y.m11456e("yeseul / getView End ", f10962b);
                return view;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        char c = 0;
        C3069w c3069w = (C3069w) view.getTag();
        switch (view.getId()) {
            case R.id.image1 /* 2131165506 */:
                c = 1;
                break;
            case R.id.image2 /* 2131165911 */:
                c = 2;
                break;
            case R.id.image3 /* 2131166332 */:
                c = 3;
                break;
            case R.id.image4 /* 2131166333 */:
                c = 4;
                break;
            case R.id.image5 /* 2131166334 */:
                c = 5;
                break;
            case R.id.image6 /* 2131166335 */:
                c = 6;
                break;
            case R.id.image7 /* 2131166336 */:
                c = 7;
                break;
            case R.id.image8 /* 2131166337 */:
                c = '\b';
                break;
        }
        this.f10972i.m10407a(c3069w.f11002c[c]);
    }

    /* renamed from: a */
    public HashMap<String, Boolean> m10600a() {
        return this.f10966c;
    }

    /* renamed from: b */
    public void m10606b() {
        if (this.f10966c != null && !this.f10966c.isEmpty()) {
            this.f10966c.clear();
        }
    }

    /* renamed from: a */
    public void m10605a(boolean z) {
        if (this.f10975l != null) {
            int position = this.f10975l.getPosition();
            this.f10975l.moveToFirst();
            if (z && this.f10975l.getCount() > 0) {
                do {
                    if ("ME".equals(this.f10975l.getString(this.f10975l.getColumnIndex("sender_uid")))) {
                        this.f10966c.put(this.f10975l.getString(this.f10975l.getColumnIndex("item_id")), true);
                    }
                } while (this.f10975l.moveToNext());
            } else {
                do {
                    if ("ME".equals(this.f10975l.getString(this.f10975l.getColumnIndex("sender_uid")))) {
                        String string = this.f10975l.getString(this.f10975l.getColumnIndex("item_id"));
                        if (this.f10966c.containsKey(string)) {
                            this.f10966c.remove(string);
                        }
                    }
                } while (this.f10975l.moveToNext());
            }
            this.f10975l.moveToPosition(position);
        }
    }

    /* renamed from: c */
    public void m10607c() {
        Iterator<Map.Entry<View, AsyncTaskC2988b>> it = this.f10967d.entrySet().iterator();
        while (it.hasNext()) {
            AsyncTaskC2988b value = it.next().getValue();
            if (value != null) {
                value.m10488a((Object) null);
                value.cancel(true);
            }
        }
        this.f10967d.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10587a(ImageView imageView, EnumC3026g enumC3026g, ImageView imageView2) {
        if (imageView != null && imageView2 != null) {
            if (enumC3026g == EnumC3026g.IMAGE) {
                imageView.setImageResource(R.drawable.trunk_image_default);
                imageView2.setVisibility(8);
            }
            if (enumC3026g == EnumC3026g.VIDEO) {
                imageView.setImageResource(R.drawable.trunk_video_default);
            }
        }
    }

    /* renamed from: a */
    public void m10602a(EnumC2959b enumC2959b) {
        this.f10970g = enumC2959b;
    }

    /* renamed from: a */
    public void m10603a(C3068v c3068v, boolean z) {
        if (z) {
            this.f10966c.put(c3068v.f10989a, true);
        } else if (this.f10966c.containsKey(c3068v.f10989a)) {
            this.f10966c.remove(c3068v.f10989a);
        }
    }

    /* renamed from: a */
    public void m10604a(HashMap<String, Boolean> map) {
        this.f10966c = map;
    }

    /* renamed from: a */
    public void m10601a(Cursor cursor) {
        try {
            if (this.f10975l != null) {
                this.f10975l.close();
            }
        } finally {
            this.f10975l = cursor;
        }
    }

    /* renamed from: a */
    private void m10585a(int i, View view, C3069w c3069w) {
        c3069w.f11001b[i] = new C3067u(this, view, null);
        c3069w.f11001b[i].f10980a.setOnClickListener(this);
    }

    /* renamed from: a */
    private C3069w m10584a(View view) {
        C3069w c3069w = new C3069w(this);
        m10585a(0, view.findViewById(R.id.image0), c3069w);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c3069w.f11001b[0].f10980a.getLayoutParams();
        layoutParams.height = this.f10973j * 2;
        c3069w.f11001b[0].f10980a.setLayoutParams(layoutParams);
        m10585a(1, view.findViewById(R.id.image1), c3069w);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c3069w.f11001b[1].f10980a.getLayoutParams();
        layoutParams2.height = this.f10973j;
        c3069w.f11001b[1].f10980a.setLayoutParams(layoutParams2);
        m10585a(2, view.findViewById(R.id.image2), c3069w);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c3069w.f11001b[2].f10980a.getLayoutParams();
        layoutParams3.height = this.f10973j;
        c3069w.f11001b[2].f10980a.setLayoutParams(layoutParams3);
        m10585a(3, view.findViewById(R.id.image3), c3069w);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) c3069w.f11001b[3].f10980a.getLayoutParams();
        layoutParams4.height = this.f10973j;
        c3069w.f11001b[3].f10980a.setLayoutParams(layoutParams4);
        m10585a(4, view.findViewById(R.id.image4), c3069w);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) c3069w.f11001b[4].f10980a.getLayoutParams();
        layoutParams5.height = this.f10973j;
        c3069w.f11001b[4].f10980a.setLayoutParams(layoutParams5);
        m10585a(5, view.findViewById(R.id.image5), c3069w);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) c3069w.f11001b[5].f10980a.getLayoutParams();
        layoutParams6.height = this.f10973j;
        c3069w.f11001b[5].f10980a.setLayoutParams(layoutParams6);
        m10585a(6, view.findViewById(R.id.image6), c3069w);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) c3069w.f11001b[6].f10980a.getLayoutParams();
        layoutParams7.height = this.f10973j;
        c3069w.f11001b[6].f10980a.setLayoutParams(layoutParams7);
        m10585a(7, view.findViewById(R.id.image7), c3069w);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) c3069w.f11001b[7].f10980a.getLayoutParams();
        layoutParams8.height = this.f10973j;
        c3069w.f11001b[7].f10980a.setLayoutParams(layoutParams8);
        m10585a(8, view.findViewById(R.id.image8), c3069w);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) c3069w.f11001b[8].f10980a.getLayoutParams();
        layoutParams9.height = this.f10973j * 2;
        c3069w.f11001b[8].f10980a.setLayoutParams(layoutParams9);
        return c3069w;
    }

    /* renamed from: a */
    private void m10591a(C3069w c3069w, int i) {
        if (!TextUtils.isEmpty(c3069w.f11002c[i].f10989a)) {
            if ("ME".equals(c3069w.f11002c[i].f10997i)) {
                c3069w.f11001b[i].f10986g.setVisibility(8);
                if (this.f10966c.isEmpty() || !this.f10966c.containsKey(c3069w.f11002c[i].f10989a)) {
                    c3069w.f11002c[i].f10998j.setChecked(false);
                    return;
                } else {
                    c3069w.f11002c[i].f10998j.setChecked(this.f10966c.get(c3069w.f11002c[i].f10989a).booleanValue());
                    return;
                }
            }
            c3069w.f11002c[i].f10998j.setVisibility(8);
            c3069w.f11001b[i].f10986g.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m10590a(C3067u c3067u, C3068v c3068v) {
        String strM10599g;
        HandlerC3065s handlerC3065s = null;
        ImageView imageView = c3067u.f10981b;
        ImageView imageView2 = c3067u.f10987h;
        if (c3068v.f10995g == EnumC3026g.VIDEO) {
            strM10599g = m10598f();
        } else {
            strM10599g = m10599g();
        }
        try {
            String strM10538a = C3025f.m10538a(c3068v.f10992d);
            String str = strM10599g + File.separator + strM10538a;
            AsyncTaskC2988b asyncTaskC2988bRemove = this.f10967d.remove(imageView);
            if (asyncTaskC2988bRemove != null) {
                asyncTaskC2988bRemove.m10488a((Object) null);
                asyncTaskC2988bRemove.cancel(true);
            }
            C2987a c2987aM10482a = C2987a.m10482a();
            Uri uriM10524a = C3020a.m10524a(str);
            if (C3025f.m10540b(str)) {
                c3068v.f10995g = EnumC3026g.AMS;
            }
            if (uriM10524a == null) {
                imageView.setImageBitmap(null);
                this.f10968e.m11732a(imageView);
                C3070x c3070x = new C3070x(this, handlerC3065s);
                c3070x.m10615b(imageView2);
                if (c3068v.f10995g == EnumC3026g.IMAGE || c3068v.f10995g == EnumC3026g.AMS) {
                    C3250y.m11450b("Can't find cache data. Execting download.", f10962b);
                    c3070x.m10613a(c3068v.f10995g);
                    c3070x.m10611a(imageView);
                    c3070x.m10612a(c3067u.f10983d);
                    this.f10967d.put(imageView, c2987aM10482a.m10483a(this.f10978p, c3068v.f10992d, strM10599g, strM10538a, c3070x, true));
                    c3067u.f10983d.setVisibility(0);
                    imageView2.setVisibility(8);
                    return;
                }
                if (c3068v.f10995g == EnumC3026g.VIDEO) {
                    C3250y.m11450b("Can't find cache data. Show default image for video.", f10962b);
                    m10587a(imageView, EnumC3026g.VIDEO, imageView2);
                    m10586a(imageView2, EnumC3026g.VIDEO);
                    return;
                }
                return;
            }
            C3250y.m11450b("Found cached data.", f10962b);
            C3250y.m11450b("fileUri: " + uriM10524a, f10962b);
            C3250y.m11450b("item.contentType: " + c3068v.f10995g, f10962b);
            this.f10968e.m11730a(imageView, new C2970ak(uriM10524a, c3068v.f10995g, false, imageView2));
        } catch (MalformedURLException e) {
            C3250y.m11442a("TrunkAdapter.ExtractFileNameFromUrl", f10962b);
            C3250y.m11443a(e, f10962b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10586a(ImageView imageView, EnumC3026g enumC3026g) {
        if (imageView != null) {
            if (enumC3026g == EnumC3026g.VIDEO) {
                imageView.setImageResource(R.drawable.chat_btn_play);
            } else if (enumC3026g == EnumC3026g.AMS) {
                imageView.setImageResource(R.drawable.chat_btn_ams_play);
            }
            imageView.setVisibility(0);
        }
    }

    /* renamed from: f */
    private String m10598f() {
        return C3020a.m10526a() + File.separator + this.f10971h;
    }

    /* renamed from: g */
    private String m10599g() {
        return C3020a.m10526a() + File.separator + this.f10971h + File.separator + "thumbnail";
    }

    /* renamed from: a */
    public static void m10592a(String str, String str2, String str3, boolean z) {
        f10963o = new C1377u(CommonApplication.m11493l().getContentResolver(), f10964q);
        f10963o.startQuery(99, new String[]{str2, str3, String.valueOf(z)}, C1454v.f5393a, null, "message_inbox_no='" + str + "' AND (message_content_type='" + EnumC1455w.IMAGE.m6364a() + "' OR message_content_type='" + EnumC1455w.AMS.m6364a() + "' OR message_content_type='" + EnumC1455w.VIDEO.m6364a() + "' ) AND message_content is not null AND (message_type!=1 AND message_type!=4)", null, null);
    }
}
