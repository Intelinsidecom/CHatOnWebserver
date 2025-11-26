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
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.trunk.database.EnumC4668d;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import com.sec.chaton.trunk.p120b.AsyncTaskC4604b;
import com.sec.chaton.trunk.p120b.C4603a;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
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
public class ViewOnClickListenerC4684r extends BaseAdapter implements View.OnClickListener {

    /* renamed from: o */
    private static C2210x f16912o;

    /* renamed from: a */
    public boolean f16914a;

    /* renamed from: e */
    private C5007c f16917e;

    /* renamed from: f */
    private Context f16918f;

    /* renamed from: g */
    private EnumC4575b f16919g;

    /* renamed from: h */
    private String f16920h;

    /* renamed from: i */
    private TrunkView f16921i;

    /* renamed from: j */
    private int f16922j;

    /* renamed from: l */
    private Cursor f16924l;

    /* renamed from: m */
    private List<String> f16925m;

    /* renamed from: n */
    private LayoutInflater f16926n;

    /* renamed from: b */
    private static final String f16911b = ViewOnClickListenerC4684r.class.getSimpleName();

    /* renamed from: q */
    private static InterfaceC2211y f16913q = new C4686t();

    /* renamed from: k */
    private int f16923k = 9;

    /* renamed from: p */
    private Handler f16927p = new HandlerC4685s(this);

    /* renamed from: d */
    private Map<View, AsyncTaskC4604b> f16916d = new HashMap();

    /* renamed from: c */
    private HashMap<String, Boolean> f16915c = new HashMap<>();

    public ViewOnClickListenerC4684r(Context context, Cursor cursor, int i, EnumC4575b enumC4575b, String str, C5007c c5007c, TrunkView trunkView, List<String> list) {
        this.f16917e = c5007c;
        this.f16918f = context;
        this.f16919g = enumC4575b;
        this.f16920h = str;
        this.f16921i = trunkView;
        this.f16924l = cursor;
        this.f16925m = list;
        this.f16926n = (LayoutInflater) this.f16918f.getSystemService("layout_inflater");
        if (context.getResources().getConfiguration().orientation == 1) {
            this.f16922j = C5034k.m19096b() / 3;
        } else {
            this.f16922j = C5034k.m19096b() / 5;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16925m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f16925m.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C4689w c4689w;
        int count;
        C4904y.m18646e("yeseul / getView Start ", f16911b);
        C4904y.m18646e("getTag position: " + i + " get: " + (i % this.f16923k), f16911b);
        if (view == null) {
            view = this.f16926n.inflate(R.layout.layout_trunk_gallery_view, viewGroup, false);
            C4689w c4689wM17678a = m17678a(view);
            view.setTag(c4689wM17678a);
            c4689w = c4689wM17678a;
        } else {
            C4689w c4689w2 = (C4689w) view.getTag();
            C4904y.m18646e("getTag sconvertView " + view.getId(), f16911b);
            c4689w = c4689w2;
        }
        if (this.f16923k * i <= this.f16924l.getCount()) {
            count = this.f16923k * i;
        } else {
            count = this.f16924l.getCount();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f16924l.moveToPosition(count)) {
            int i2 = 0;
            do {
                int i3 = i2;
                String string = this.f16924l.getString(this.f16924l.getColumnIndex("item_id"));
                EnumC4668d enumC4668dM17666a = EnumC4668d.m17666a(this.f16924l.getInt(this.f16924l.getColumnIndex("item_type")));
                int i4 = this.f16924l.getInt(this.f16924l.getColumnIndex("total_comment_count"));
                String string2 = this.f16924l.getString(this.f16924l.getColumnIndex("thumbnail"));
                int i5 = this.f16924l.getInt(this.f16924l.getColumnIndex("unread_comment_count"));
                String string3 = this.f16924l.getString(this.f16924l.getColumnIndex("isams"));
                arrayList.add(new C4688v(this, string, enumC4668dM17666a, i4, string2, i5, string3, C4641f.m17614a(this.f16924l.getString(this.f16924l.getColumnIndex("content_type")), "true".equals(string3)), this.f16924l.getString(this.f16924l.getColumnIndex("down_url")), this.f16924l.getString(this.f16924l.getColumnIndex("sender_uid"))));
                if (!this.f16924l.moveToNext()) {
                    break;
                }
                i2 = i3 + 1;
            } while (i2 < this.f16923k);
        }
        if (arrayList.size() < this.f16923k) {
            for (int size = arrayList.size(); size < this.f16923k; size++) {
                this.f16917e.m19015a((View) c4689w.f16950b[size].f16930b);
            }
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.f16923k) {
                if (arrayList.size() > i7) {
                    C4688v c4688v = (C4688v) arrayList.get(i7);
                    c4689w.f16950b[i7].f16932d.setVisibility(8);
                    m17684a(c4689w.f16950b[i7], c4688v);
                    c4689w.f16950b[i7].f16929a.setTag(c4689w);
                    c4689w.f16950b[i7].f16929a.setVisibility(0);
                    c4689w.f16951c[i7] = c4688v;
                    c4689w.f16951c[i7].f16947j = c4689w.f16950b[i7].f16931c;
                    if (c4688v.f16942e > 0) {
                        c4689w.f16950b[i7].f16934f.setImageResource(R.drawable.trunk_ic_comment_unread_chats);
                    } else {
                        c4689w.f16950b[i7].f16934f.setImageResource(R.drawable.trunk_ic_comment_read);
                    }
                    C4641f.m17616a(c4689w.f16950b[i7].f16933e, c4688v.f16940c);
                    if (c4688v.f16940c <= 0) {
                        c4689w.f16950b[i7].f16933e.setVisibility(8);
                        c4689w.f16950b[i7].f16934f.setVisibility(8);
                    } else {
                        c4689w.f16950b[i7].f16933e.setVisibility(0);
                        c4689w.f16950b[i7].f16934f.setVisibility(0);
                    }
                    if (this.f16914a) {
                        c4689w.f16951c[i7].f16947j.setVisibility(0);
                        c4689w.f16950b[i7].f16935g.setVisibility(0);
                        m17685a(c4689w, i7);
                    } else {
                        c4689w.f16951c[i7].f16947j.setVisibility(8);
                        c4689w.f16950b[i7].f16935g.setVisibility(8);
                    }
                } else {
                    c4689w.f16950b[i7].f16930b.setImageBitmap(null);
                    c4689w.f16950b[i7].f16929a.setVisibility(8);
                    c4689w.f16950b[i7].f16929a.setTag(null);
                    c4689w.f16951c[i7] = null;
                }
                i6 = i7 + 1;
            } else {
                C4904y.m18646e("yeseul / getView End ", f16911b);
                return view;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        char c2 = 0;
        if (!C4847bl.m18333a()) {
            C4689w c4689w = (C4689w) view.getTag();
            switch (view.getId()) {
                case R.id.image1 /* 2131165564 */:
                    c2 = 1;
                    break;
                case R.id.image2 /* 2131165831 */:
                    c2 = 2;
                    break;
                case R.id.image3 /* 2131166299 */:
                    c2 = 3;
                    break;
                case R.id.image4 /* 2131166300 */:
                    c2 = 4;
                    break;
                case R.id.image5 /* 2131166301 */:
                    c2 = 5;
                    break;
                case R.id.image6 /* 2131166302 */:
                    c2 = 6;
                    break;
                case R.id.image7 /* 2131166303 */:
                    c2 = 7;
                    break;
                case R.id.image8 /* 2131166304 */:
                    c2 = '\b';
                    break;
            }
            this.f16921i.m17504a(c4689w.f16951c[c2]);
        }
    }

    /* renamed from: a */
    public HashMap<String, Boolean> m17694a() {
        return this.f16915c;
    }

    /* renamed from: b */
    public void m17700b() {
        if (this.f16915c != null && !this.f16915c.isEmpty()) {
            this.f16915c.clear();
        }
    }

    /* renamed from: a */
    public void m17699a(boolean z) {
        if (this.f16924l != null) {
            int position = this.f16924l.getPosition();
            this.f16924l.moveToFirst();
            if (z && this.f16924l.getCount() > 0) {
                do {
                    if ("ME".equals(this.f16924l.getString(this.f16924l.getColumnIndex("sender_uid")))) {
                        this.f16915c.put(this.f16924l.getString(this.f16924l.getColumnIndex("item_id")), true);
                    }
                } while (this.f16924l.moveToNext());
            } else {
                do {
                    if ("ME".equals(this.f16924l.getString(this.f16924l.getColumnIndex("sender_uid")))) {
                        String string = this.f16924l.getString(this.f16924l.getColumnIndex("item_id"));
                        if (this.f16915c.containsKey(string)) {
                            this.f16915c.remove(string);
                        }
                    }
                } while (this.f16924l.moveToNext());
            }
            this.f16924l.moveToPosition(position);
        }
    }

    /* renamed from: c */
    public void m17701c() {
        Iterator<Map.Entry<View, AsyncTaskC4604b>> it = this.f16916d.entrySet().iterator();
        while (it.hasNext()) {
            AsyncTaskC4604b value = it.next().getValue();
            if (value != null) {
                value.m17560a((Object) null);
                value.cancel(true);
            }
        }
        this.f16916d.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17681a(ImageView imageView, EnumC4642g enumC4642g, ImageView imageView2) {
        if (imageView != null && imageView2 != null) {
            if (enumC4642g == EnumC4642g.IMAGE) {
                imageView.setImageResource(R.drawable.trunk_image_default);
                imageView2.setVisibility(8);
            }
            if (enumC4642g == EnumC4642g.VIDEO) {
                imageView.setImageResource(R.drawable.trunk_video_default);
            }
        }
    }

    /* renamed from: a */
    public void m17696a(EnumC4575b enumC4575b) {
        this.f16919g = enumC4575b;
    }

    /* renamed from: a */
    public void m17697a(C4688v c4688v, boolean z) {
        if (z) {
            this.f16915c.put(c4688v.f16938a, true);
        } else if (this.f16915c.containsKey(c4688v.f16938a)) {
            this.f16915c.remove(c4688v.f16938a);
        }
    }

    /* renamed from: a */
    public void m17698a(HashMap<String, Boolean> map) {
        this.f16915c = map;
    }

    /* renamed from: a */
    public void m17695a(Cursor cursor) {
        try {
            if (this.f16924l != null) {
                this.f16924l.close();
            }
        } finally {
            this.f16924l = cursor;
        }
    }

    /* renamed from: a */
    private void m17679a(int i, View view, C4689w c4689w) {
        c4689w.f16950b[i] = new C4687u(this, view, null);
        c4689w.f16950b[i].f16929a.setFocusable(true);
        c4689w.f16950b[i].f16929a.setOnClickListener(this);
    }

    /* renamed from: a */
    private C4689w m17678a(View view) {
        C4689w c4689w = new C4689w(this);
        m17679a(0, view.findViewById(R.id.image0), c4689w);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c4689w.f16950b[0].f16929a.getLayoutParams();
        layoutParams.height = this.f16922j * 2;
        c4689w.f16950b[0].f16929a.setLayoutParams(layoutParams);
        m17679a(1, view.findViewById(R.id.image1), c4689w);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c4689w.f16950b[1].f16929a.getLayoutParams();
        layoutParams2.height = this.f16922j;
        c4689w.f16950b[1].f16929a.setLayoutParams(layoutParams2);
        m17679a(2, view.findViewById(R.id.image2), c4689w);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c4689w.f16950b[2].f16929a.getLayoutParams();
        layoutParams3.height = this.f16922j;
        c4689w.f16950b[2].f16929a.setLayoutParams(layoutParams3);
        m17679a(3, view.findViewById(R.id.image3), c4689w);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) c4689w.f16950b[3].f16929a.getLayoutParams();
        layoutParams4.height = this.f16922j;
        c4689w.f16950b[3].f16929a.setLayoutParams(layoutParams4);
        m17679a(4, view.findViewById(R.id.image4), c4689w);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) c4689w.f16950b[4].f16929a.getLayoutParams();
        layoutParams5.height = this.f16922j;
        c4689w.f16950b[4].f16929a.setLayoutParams(layoutParams5);
        m17679a(5, view.findViewById(R.id.image5), c4689w);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) c4689w.f16950b[5].f16929a.getLayoutParams();
        layoutParams6.height = this.f16922j;
        c4689w.f16950b[5].f16929a.setLayoutParams(layoutParams6);
        m17679a(6, view.findViewById(R.id.image6), c4689w);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) c4689w.f16950b[6].f16929a.getLayoutParams();
        layoutParams7.height = this.f16922j;
        c4689w.f16950b[6].f16929a.setLayoutParams(layoutParams7);
        m17679a(7, view.findViewById(R.id.image7), c4689w);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) c4689w.f16950b[7].f16929a.getLayoutParams();
        layoutParams8.height = this.f16922j;
        c4689w.f16950b[7].f16929a.setLayoutParams(layoutParams8);
        m17679a(8, view.findViewById(R.id.image8), c4689w);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) c4689w.f16950b[8].f16929a.getLayoutParams();
        layoutParams9.height = this.f16922j * 2;
        c4689w.f16950b[8].f16929a.setLayoutParams(layoutParams9);
        return c4689w;
    }

    /* renamed from: a */
    private void m17685a(C4689w c4689w, int i) {
        if (!TextUtils.isEmpty(c4689w.f16951c[i].f16938a)) {
            if ("ME".equals(c4689w.f16951c[i].f16946i)) {
                c4689w.f16950b[i].f16935g.setVisibility(8);
                if (this.f16915c.isEmpty() || !this.f16915c.containsKey(c4689w.f16951c[i].f16938a)) {
                    c4689w.f16951c[i].f16947j.setChecked(false);
                    return;
                } else {
                    c4689w.f16951c[i].f16947j.setChecked(this.f16915c.get(c4689w.f16951c[i].f16938a).booleanValue());
                    return;
                }
            }
            c4689w.f16951c[i].f16947j.setVisibility(8);
            c4689w.f16950b[i].f16935g.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m17684a(C4687u c4687u, C4688v c4688v) {
        String strM17693g;
        HandlerC4685s handlerC4685s = null;
        ImageView imageView = c4687u.f16930b;
        ImageView imageView2 = c4687u.f16936h;
        if (c4688v.f16944g == EnumC4642g.VIDEO) {
            strM17693g = m17692f();
        } else {
            strM17693g = m17693g();
        }
        try {
            String strM17615a = C4641f.m17615a(c4688v.f16941d);
            if (strM17615a != null) {
                String str = strM17693g + File.separator + strM17615a;
                AsyncTaskC4604b asyncTaskC4604bRemove = this.f16916d.remove(imageView);
                if (asyncTaskC4604bRemove != null) {
                    asyncTaskC4604bRemove.m17560a((Object) null);
                    asyncTaskC4604bRemove.cancel(true);
                }
                C4603a c4603aM17553a = C4603a.m17553a();
                Uri uriM17601a = C4636a.m17601a(str);
                if (C4641f.m17617b(str)) {
                    c4688v.f16944g = EnumC4642g.AMS;
                }
                if (uriM17601a == null) {
                    imageView.setImageBitmap(null);
                    this.f16917e.m19015a((View) imageView);
                    C4690x c4690x = new C4690x(this, handlerC4685s);
                    c4690x.m17709b(imageView2);
                    if (c4688v.f16944g == EnumC4642g.IMAGE || c4688v.f16944g == EnumC4642g.AMS) {
                        C4904y.m18639b("Can't find cache data. Execting download.", f16911b);
                        c4690x.m17707a(c4688v.f16944g);
                        c4690x.m17705a(imageView);
                        c4690x.m17706a(c4687u.f16932d);
                        this.f16916d.put(imageView, c4603aM17553a.m17554a(this.f16927p, c4688v.f16941d, strM17693g, strM17615a, c4690x, true));
                        c4687u.f16932d.setVisibility(0);
                        imageView2.setVisibility(8);
                        return;
                    }
                    if (c4688v.f16944g == EnumC4642g.VIDEO) {
                        C4904y.m18639b("Can't find cache data. Show default image for video.", f16911b);
                        m17681a(imageView, EnumC4642g.VIDEO, imageView2);
                        m17680a(imageView2, EnumC4642g.VIDEO);
                        return;
                    }
                    return;
                }
                C4904y.m18639b("Found cached data.", f16911b);
                C4904y.m18639b("fileUri: " + uriM17601a, f16911b);
                C4904y.m18639b("item.contentType: " + c4688v.f16944g, f16911b);
                this.f16917e.m19023b(imageView, new C4589an(uriM17601a, c4688v.f16944g, false, imageView2));
            }
        } catch (MalformedURLException e) {
            C4904y.m18634a("TrunkAdapter.ExtractFileNameFromUrl", f16911b);
            C4904y.m18635a(e, f16911b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17680a(ImageView imageView, EnumC4642g enumC4642g) {
        if (imageView != null) {
            if (enumC4642g == EnumC4642g.VIDEO) {
                imageView.setImageResource(R.drawable.chat_btn_play_selector);
            } else if (enumC4642g == EnumC4642g.AMS) {
                imageView.setImageResource(R.drawable.chat_btn_ams_play_selector);
            }
            imageView.setVisibility(0);
        }
    }

    /* renamed from: f */
    private String m17692f() {
        return C4636a.m17603a() + File.separator + this.f16920h;
    }

    /* renamed from: g */
    private String m17693g() {
        return C4636a.m17603a() + File.separator + this.f16920h + File.separator + "thumbnail";
    }

    /* renamed from: a */
    public static void m17686a(String str, String str2, String str3, boolean z) {
        f16912o = new C2210x(CommonApplication.m18732r().getContentResolver(), f16913q);
        f16912o.startQuery(99, new String[]{str2, str3, String.valueOf(z)}, C2306z.f8229a, null, "message_inbox_no='" + str + "' AND (message_content_type='" + EnumC2214ab.IMAGE.m10076a() + "' OR message_content_type='" + EnumC2214ab.AMS.m10076a() + "' OR message_content_type='" + EnumC2214ab.VIDEO.m10076a() + "' ) AND message_content is not null AND (message_type!=1 AND message_type!=4)", null, null);
    }
}
