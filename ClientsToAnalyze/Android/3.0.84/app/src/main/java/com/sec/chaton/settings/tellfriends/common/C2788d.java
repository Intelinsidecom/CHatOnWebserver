package com.sec.chaton.settings.tellfriends.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.p009c.C0132a;
import com.facebook.p009c.C0139g;
import com.facebook.p009c.C0141i;
import com.facebook.p009c.C0143k;
import com.facebook.p009c.InterfaceC0142j;
import com.sec.chaton.R;
import com.sec.chaton.settings.tellfriends.C2732ai;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SnsFriendsAdapter.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.d */
/* loaded from: classes.dex */
public class C2788d extends ArrayAdapter<C2732ai> {

    /* renamed from: c */
    private static final String f10268c = C2788d.class.getSimpleName();

    /* renamed from: a */
    ArrayList<C2732ai> f10269a;

    /* renamed from: b */
    InterfaceC2791g f10270b;

    /* renamed from: d */
    private Context f10271d;

    /* renamed from: e */
    private LayoutInflater f10272e;

    /* renamed from: f */
    private C2792h f10273f;

    /* renamed from: g */
    private final Map<String, C0139g> f10274g;

    /* renamed from: h */
    private Map<String, C0143k> f10275h;

    /* renamed from: i */
    private ArrayList<String> f10276i;

    /* renamed from: a */
    public void m10003a(InterfaceC2791g interfaceC2791g) {
        this.f10270b = interfaceC2791g;
    }

    public C2788d(Context context, int i, ArrayList<C2732ai> arrayList) {
        this(context, i, arrayList, null);
    }

    C2788d(Context context, int i, ArrayList<C2732ai> arrayList, C2792h c2792h) {
        super(context, i, arrayList);
        this.f10274g = new HashMap();
        this.f10275h = new HashMap();
        this.f10276i = new ArrayList<>();
        this.f10271d = context;
        this.f10272e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f10269a = arrayList;
        this.f10273f = c2792h;
    }

    @Override // android.widget.ArrayAdapter
    public void addAll(Collection<? extends C2732ai> collection) {
        this.f10269a.addAll(collection);
        super.addAll(collection);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2732ai c2732ai = this.f10269a.get(i);
        if (view == null) {
            view = this.f10272e.inflate(R.layout.list_item_sns_friend, (ViewGroup) null);
        }
        m10002a(view, c2732ai);
        return view;
    }

    /* renamed from: a */
    public void m10004a(C2792h c2792h) {
        this.f10273f = c2792h;
    }

    /* renamed from: a */
    protected void m10002a(View view, C2732ai c2732ai) {
        String strM9783a = c2732ai.m9783a();
        view.setTag(strM9783a);
        Button button = (Button) view.findViewById(R.id.button1);
        if (button != null) {
            if (this.f10273f != null) {
                button.setBackgroundResource(this.f10273f.m10005a());
            } else {
                button.setText(R.string.chat_info_invite);
            }
            if (this.f10270b != null) {
                button.setOnClickListener(new ViewOnClickListenerC2789e(this, c2732ai));
            }
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image1);
        if (this.f10275h.containsKey(strM9783a)) {
            C0143k c0143k = this.f10275h.get(strM9783a);
            imageView.setImageBitmap(c0143k.m436c());
            imageView.setTag(c0143k.m434a().m421b());
        } else {
            m9999a(strM9783a, m10000a(c2732ai), imageView);
        }
        m9995a((ImageView) view.findViewById(R.id.sub_icon));
        TextView textView = (TextView) view.findViewById(R.id.text1);
        if (textView != null) {
            textView.setText(c2732ai.m9789f());
        }
    }

    /* renamed from: a */
    protected URL m10000a(C2732ai c2732ai) {
        String strM9786c = c2732ai.m9786c();
        if (strM9786c != null) {
            try {
                return new URL(strM9786c);
            } catch (MalformedURLException e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m9995a(ImageView imageView) {
        if (this.f10273f != null && this.f10273f.m10007c()) {
            m9998a("downloadProfilePicture() : set sns type icon");
            imageView.setImageDrawable(this.f10271d.getResources().getDrawable(this.f10273f.m10006b()));
            imageView.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m9999a(String str, URL url, ImageView imageView) {
        if (url != null) {
            boolean z = imageView == null;
            if (z || !url.equals(imageView.getTag())) {
                if (!z) {
                    m9998a("downloadProfilePicture() : set default image");
                    imageView.setTag(str);
                    imageView.setImageResource(R.drawable.contacts_default_01);
                }
                C0139g c0139gM430a = new C0141i(CommonApplication.m11493l(), url).m432a(this).m431a((InterfaceC0142j) new C2790f(this, str, imageView)).m430a();
                this.f10274g.put(str, c0139gM430a);
                C0132a.m407a(c0139gM430a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9996a(C0143k c0143k, String str, ImageView imageView) {
        this.f10274g.remove(str);
        if (imageView == null) {
            if (c0143k.m436c() != null) {
                if (this.f10275h.size() >= 100) {
                    this.f10275h.remove(this.f10276i.remove(0));
                }
                this.f10275h.put(str, c0143k);
                return;
            }
            return;
        }
        if (imageView != null && str.equals(imageView.getTag())) {
            Exception excM435b = c0143k.m435b();
            Bitmap bitmapM436c = c0143k.m436c();
            if (excM435b == null && bitmapM436c != null) {
                imageView.setImageBitmap(bitmapM436c);
                imageView.setTag(c0143k.m434a().m421b());
            }
        }
    }

    /* renamed from: a */
    public void m10001a(int i, int i2, int i3) {
        if (i2 >= i) {
            for (int i4 = i2; i4 >= 0; i4--) {
                if (i4 >= 0 && i4 < this.f10269a.size()) {
                    C0139g c0139g = this.f10274g.get(this.f10269a.get(i4).m9783a());
                    if (c0139g != null) {
                        C0132a.m413b(c0139g);
                    }
                }
            }
            int iMax = Math.max(0, i - i3);
            int iMin = Math.min(i2 + i3, getCount() - 1);
            ArrayList arrayList = new ArrayList();
            for (int i5 = iMax; i5 < i; i5++) {
                if (i5 >= 0 && i5 < this.f10269a.size()) {
                    arrayList.add(this.f10269a.get(i5));
                }
            }
            for (int i6 = i2 + 1; i6 <= iMin; i6++) {
                if (i6 >= 0 && i6 < this.f10269a.size()) {
                    arrayList.add(this.f10269a.get(i6));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C2732ai c2732ai = (C2732ai) it.next();
                URL urlM10000a = m10000a(c2732ai);
                String strM9783a = c2732ai.m9783a();
                boolean zRemove = this.f10276i.remove(strM9783a);
                this.f10276i.add(strM9783a);
                if (!zRemove) {
                    m9999a(strM9783a, urlM10000a, (ImageView) null);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m9998a(String str) {
        C3250y.m11450b(str, f10268c);
    }
}
