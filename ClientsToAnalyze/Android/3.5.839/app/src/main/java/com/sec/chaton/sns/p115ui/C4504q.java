package com.sec.chaton.sns.p115ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.p033c.C0503a;
import com.facebook.p033c.C0510g;
import com.facebook.p033c.C0512i;
import com.facebook.p033c.C0514k;
import com.facebook.p033c.InterfaceC0513j;
import com.sec.chaton.R;
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SnsFriendsAdapter.java */
/* renamed from: com.sec.chaton.sns.ui.q */
/* loaded from: classes.dex */
public class C4504q extends ArrayAdapter<C4379ae> {

    /* renamed from: c */
    private static final String f16222c = C4504q.class.getSimpleName();

    /* renamed from: a */
    ArrayList<C4379ae> f16223a;

    /* renamed from: b */
    InterfaceC4511t f16224b;

    /* renamed from: d */
    private Context f16225d;

    /* renamed from: e */
    private LayoutInflater f16226e;

    /* renamed from: f */
    private C4514u f16227f;

    /* renamed from: g */
    private final Map<String, C0510g> f16228g;

    /* renamed from: h */
    private Map<String, C0514k> f16229h;

    /* renamed from: i */
    private ArrayList<String> f16230i;

    /* renamed from: a */
    public void m17055a(InterfaceC4511t interfaceC4511t) {
        this.f16224b = interfaceC4511t;
    }

    public C4504q(Context context, int i, ArrayList<C4379ae> arrayList) {
        this(context, i, arrayList, null);
    }

    C4504q(Context context, int i, ArrayList<C4379ae> arrayList, C4514u c4514u) {
        super(context, i, arrayList);
        this.f16228g = new HashMap();
        this.f16229h = new HashMap();
        this.f16230i = new ArrayList<>();
        this.f16225d = context;
        this.f16226e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f16223a = arrayList;
        this.f16227f = c4514u;
    }

    @Override // android.widget.ArrayAdapter
    public void addAll(Collection<? extends C4379ae> collection) {
        this.f16223a.addAll(collection);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C4379ae c4379ae = this.f16223a.get(i);
        if (view == null) {
            view = this.f16226e.inflate(R.layout.list_item_sns_friend, (ViewGroup) null);
        }
        m17054a(view, c4379ae);
        return view;
    }

    /* renamed from: a */
    public void m17056a(C4514u c4514u) {
        this.f16227f = c4514u;
    }

    /* renamed from: a */
    protected void m17054a(View view, C4379ae c4379ae) {
        String strM16625a = c4379ae.m16625a();
        view.setTag(strM16625a);
        Button button = (Button) view.findViewById(R.id.button1);
        if (button != null) {
            if (this.f16227f != null) {
                button.setBackgroundResource(this.f16227f.m17081a());
            } else {
                button.setText(R.string.chat_info_invite);
            }
            if (this.f16224b != null) {
                button.setOnClickListener(new ViewOnClickListenerC4505r(this, c4379ae));
            }
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image1);
        if (this.f16229h.containsKey(strM16625a)) {
            C0514k c0514k = this.f16229h.get(strM16625a);
            imageView.setImageBitmap(c0514k.m1879c());
            imageView.setTag(c0514k.m1877a().m1864b());
        } else {
            m17051a(strM16625a, m17052a(c4379ae), imageView);
        }
        m17047a((ImageView) view.findViewById(R.id.sub_icon));
        TextView textView = (TextView) view.findViewById(R.id.text1);
        if (textView != null) {
            textView.setText(c4379ae.m16631f());
        }
    }

    /* renamed from: a */
    protected URL m17052a(C4379ae c4379ae) {
        String strM16628c = c4379ae.m16628c();
        if (strM16628c != null) {
            try {
                return new URL(strM16628c);
            } catch (MalformedURLException e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m17047a(ImageView imageView) {
        if (this.f16227f != null && this.f16227f.m17083c()) {
            m17050a("downloadProfilePicture() : set sns type icon");
            imageView.setImageDrawable(this.f16225d.getResources().getDrawable(this.f16227f.m17082b()));
            imageView.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m17051a(String str, URL url, ImageView imageView) {
        if (url != null) {
            boolean z = imageView == null;
            if (z || !url.equals(imageView.getTag())) {
                if (!z) {
                    m17050a("downloadProfilePicture() : set default image");
                    imageView.setTag(str);
                    imageView.setImageResource(R.drawable.profile_photo_buddy_default);
                }
                C0510g c0510gM1873a = new C0512i(CommonApplication.m18732r(), url).m1875a(this).m1874a((InterfaceC0513j) new C4510s(this, str, imageView)).m1873a();
                this.f16228g.put(str, c0510gM1873a);
                C0503a.m1850a(c0510gM1873a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17048a(C0514k c0514k, String str, ImageView imageView) {
        this.f16228g.remove(str);
        if (imageView == null) {
            if (c0514k.m1879c() != null) {
                if (this.f16229h.size() >= 100) {
                    this.f16229h.remove(this.f16230i.remove(0));
                }
                this.f16229h.put(str, c0514k);
                return;
            }
            return;
        }
        if (imageView != null && str.equals(imageView.getTag())) {
            Exception excM1878b = c0514k.m1878b();
            Bitmap bitmapM1879c = c0514k.m1879c();
            if (excM1878b == null && bitmapM1879c != null) {
                imageView.setImageBitmap(bitmapM1879c);
                imageView.setTag(c0514k.m1877a().m1864b());
            }
        }
    }

    /* renamed from: a */
    public void m17053a(int i, int i2, int i3) {
        if (i2 >= i) {
            for (int i4 = i2; i4 >= 0; i4--) {
                if (i4 >= 0 && i4 < this.f16223a.size()) {
                    C0510g c0510g = this.f16228g.get(this.f16223a.get(i4).m16625a());
                    if (c0510g != null) {
                        C0503a.m1856b(c0510g);
                    }
                }
            }
            int iMax = Math.max(0, i - i3);
            int iMin = Math.min(i2 + i3, getCount() - 1);
            ArrayList arrayList = new ArrayList();
            for (int i5 = iMax; i5 < i; i5++) {
                if (i5 >= 0 && i5 < this.f16223a.size()) {
                    arrayList.add(this.f16223a.get(i5));
                }
            }
            for (int i6 = i2 + 1; i6 <= iMin; i6++) {
                if (i6 >= 0 && i6 < this.f16223a.size()) {
                    arrayList.add(this.f16223a.get(i6));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C4379ae c4379ae = (C4379ae) it.next();
                URL urlM17052a = m17052a(c4379ae);
                String strM16625a = c4379ae.m16625a();
                boolean zRemove = this.f16230i.remove(strM16625a);
                this.f16230i.add(strM16625a);
                if (!zRemove) {
                    m17051a(strM16625a, urlM17052a, (ImageView) null);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m17050a(String str) {
        C4904y.m18639b(str, f16222c);
    }
}
