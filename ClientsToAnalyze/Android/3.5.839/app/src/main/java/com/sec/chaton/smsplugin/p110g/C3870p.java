package com.sec.chaton.smsplugin.p110g;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3781b;
import com.sec.chaton.smsplugin.C3805c;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p104d.p106b.p107a.C3820c;
import com.sec.chaton.smsplugin.p109f.C3852b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.mobile1.C5112a;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5083f;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;
import com.sec.google.android.p134a.p135a.C5095r;
import com.sec.google.android.p134a.p135a.C5097t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.p146b.p147a.p148a.InterfaceC5240e;
import org.p146b.p147a.p149b.InterfaceC5246f;
import org.p146b.p147a.p149b.InterfaceC5248h;
import org.p146b.p147a.p149b.InterfaceC5249i;
import org.p146b.p147a.p149b.InterfaceC5250j;
import org.p146b.p147a.p149b.InterfaceC5252l;
import org.p146b.p147a.p149b.InterfaceC5255o;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: SlideshowModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.p */
/* loaded from: classes.dex */
public class C3870p extends C3866l implements InterfaceC3860f, List<C3869o> {

    /* renamed from: i */
    private static boolean f13922i = false;

    /* renamed from: j */
    private static boolean f13923j = false;

    /* renamed from: k */
    private static boolean f13924k = true;

    /* renamed from: a */
    public final ArrayList<C3869o> f13925a;

    /* renamed from: b */
    public final ArrayList<C3855a> f13926b;

    /* renamed from: c */
    private final C3862h f13927c;

    /* renamed from: d */
    private InterfaceC5246f f13928d;

    /* renamed from: e */
    private C5086i f13929e;

    /* renamed from: f */
    private int f13930f;

    /* renamed from: g */
    private int f13931g;

    /* renamed from: h */
    private final Context f13932h;

    private C3870p(Context context) {
        this.f13927c = new C3862h();
        this.f13925a = new ArrayList<>();
        this.f13932h = context;
        this.f13926b = new ArrayList<>();
    }

    private C3870p(C3862h c3862h, ArrayList<C3869o> arrayList, ArrayList<C3855a> arrayList2, InterfaceC5246f interfaceC5246f, C5086i c5086i, Context context) {
        this.f13927c = c3862h;
        this.f13925a = arrayList;
        this.f13932h = context;
        this.f13926b = arrayList2;
        this.f13928d = interfaceC5246f;
        this.f13929e = c5086i;
        Iterator<C3869o> it = this.f13925a.iterator();
        while (it.hasNext()) {
            C3869o next = it.next();
            m14910b(next.m14855b());
            next.m14852a(this);
        }
        Iterator<C3855a> it2 = this.f13926b.iterator();
        while (it2.hasNext()) {
            m14910b(it2.next().m14749e());
        }
    }

    /* renamed from: a */
    public static C3870p m14880a(Context context) {
        return new C3870p(context);
    }

    /* renamed from: a */
    public static C3870p m14881a(Context context, Uri uri) {
        return m14882a(context, m14893b(context, uri));
    }

    /* renamed from: a */
    public static C3870p m14882a(Context context, C5086i c5086i) {
        int iM14817r;
        f13922i = false;
        InterfaceC5246f interfaceC5246fM14927a = C3871q.m14927a(c5086i);
        InterfaceC5248h interfaceC5248hMo14530m = interfaceC5246fM14927a.mo14530m();
        InterfaceC5255o interfaceC5255oMo14537b = interfaceC5248hMo14530m.mo14537b();
        int iF = interfaceC5255oMo14537b.mo14603f();
        int iE = interfaceC5255oMo14537b.mo14602e();
        if (iF == 0 || iE == 0) {
            iF = C3852b.m14736a().m14740b().mo14732a();
            iE = C3852b.m14736a().m14740b().mo14733b();
            interfaceC5255oMo14537b.mo14601d(iF);
            interfaceC5255oMo14537b.mo14598c(iE);
        }
        C3868n c3868n = new C3868n(null, 0, 0, iF, iE);
        ArrayList arrayList = new ArrayList();
        NodeList nodeListMo14536a = interfaceC5248hMo14530m.mo14536a();
        int length = nodeListMo14536a.getLength();
        for (int i = 0; i < length; i++) {
            InterfaceC5252l interfaceC5252l = (InterfaceC5252l) nodeListMo14536a.item(i);
            arrayList.add(new C3868n(interfaceC5252l.mo14535j(), interfaceC5252l.mo14592a(), interfaceC5252l.mo14594b(), interfaceC5252l.mo14597c(), interfaceC5252l.mo14603f(), interfaceC5252l.mo14602e(), interfaceC5252l.mo14600d()));
        }
        C3862h c3862h = new C3862h(c3868n, arrayList);
        NodeList childNodes = interfaceC5246fM14927a.mo14529l().getChildNodes();
        int length2 = childNodes.getLength();
        ArrayList arrayList2 = new ArrayList(length2);
        int i2 = 0;
        ArrayList<C3855a> arrayListM14888a = m14888a(context, c5086i, childNodes);
        for (int i3 = 0; i3 < length2; i3++) {
            InterfaceC5250j interfaceC5250jM14889a = null;
            if (childNodes.item(i3) instanceof InterfaceC5250j) {
                interfaceC5250jM14889a = (InterfaceC5250j) childNodes.item(i3);
            } else if (childNodes.item(i3).getNodeName().equals("seq")) {
                interfaceC5250jM14889a = m14889a(interfaceC5246fM14927a, childNodes.item(i3));
            }
            if (interfaceC5250jM14889a != null) {
                NodeList childNodes2 = interfaceC5250jM14889a.getChildNodes();
                int length3 = childNodes2.getLength();
                ArrayList arrayList3 = new ArrayList(length3);
                int i4 = 0;
                while (i4 < length3) {
                    InterfaceC5249i interfaceC5249i = (InterfaceC5249i) childNodes2.item(i4);
                    try {
                        AbstractC3863i abstractC3863iM14829a = C3865k.m14829a(context, interfaceC5249i, c3862h, c5086i);
                        if (C3847e.m14636T()) {
                            if (!abstractC3863iM14829a.m14822w() && (abstractC3863iM14829a.m14812m().equalsIgnoreCase("text/x-vCard") || abstractC3863iM14829a.m14812m().equalsIgnoreCase("text/x-vCalendar"))) {
                                f13922i = true;
                                iM14817r = i2;
                            } else {
                                if (abstractC3863iM14829a.m14822w()) {
                                    C3890m.m14996b("NGM", "Raw Attachment Size" + arrayListM14888a.size() + " " + abstractC3863iM14829a.m14813n());
                                    Iterator<C3855a> it = arrayListM14888a.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        C3855a next = it.next();
                                        C3890m.m14996b("NGM", "Raw Attachment URI" + next.m14746b());
                                        if (next.m14746b() != null && next.m14746b().compareTo(abstractC3863iM14829a.m14813n()) == 0) {
                                            arrayListM14888a.remove(next);
                                            break;
                                        }
                                    }
                                    C3890m.m14996b("NGM", "Raw Attachment Size" + arrayListM14888a.size());
                                    if (arrayListM14888a.size() == 0) {
                                        f13922i = false;
                                    }
                                }
                                if (!abstractC3863iM14829a.m14822w()) {
                                    m14892a(interfaceC5250jM14889a, interfaceC5249i, abstractC3863iM14829a);
                                }
                                C3871q.m14932a((InterfaceC5240e) interfaceC5249i, abstractC3863iM14829a);
                                arrayList3.add(abstractC3863iM14829a);
                                iM14817r = abstractC3863iM14829a.m14817r() + i2;
                            }
                        } else if (abstractC3863iM14829a.m14812m().equalsIgnoreCase("text/x-vCard") || abstractC3863iM14829a.m14812m().equalsIgnoreCase("text/x-vCalendar")) {
                            f13922i = true;
                            iM14817r = i2;
                        } else {
                            if (C3847e.m14640X()) {
                                m14892a(interfaceC5250jM14889a, interfaceC5249i, abstractC3863iM14829a);
                            }
                            C3871q.m14932a((InterfaceC5240e) interfaceC5249i, abstractC3863iM14829a);
                            arrayList3.add(abstractC3863iM14829a);
                            iM14817r = abstractC3863iM14829a.m14817r() + i2;
                        }
                    } catch (C5112a e) {
                        C3890m.m14995a("Mms/slideshow", e.getMessage(), e);
                        iM14817r = i2;
                    } catch (IOException e2) {
                        C3890m.m14995a("Mms/slideshow", e2.getMessage(), e2);
                        iM14817r = i2;
                    } catch (IllegalArgumentException e3) {
                        C3890m.m14995a("Mms/slideshow", e3.getMessage(), e3);
                        iM14817r = i2;
                    }
                    i4++;
                    i2 = iM14817r;
                }
                C3869o c3869o = new C3869o((int) (interfaceC5250jM14889a.mo14506b() * 1000.0f), (ArrayList<AbstractC3863i>) arrayList3);
                c3869o.m14853a(interfaceC5250jM14889a.mo14520i());
                C3871q.m14933a((InterfaceC5240e) interfaceC5250jM14889a, c3869o);
                arrayList2.add(c3869o);
            }
        }
        arrayListM14888a.trimToSize();
        C3870p c3870pM14883a = m14883a(context, c5086i, interfaceC5246fM14927a, c3862h, arrayList2, 0, arrayListM14888a);
        c3870pM14883a.f13931g = i2;
        return c3870pM14883a;
    }

    /* renamed from: a */
    private static InterfaceC5250j m14889a(InterfaceC5246f interfaceC5246f, Node node) {
        ArrayList arrayList = new ArrayList();
        InterfaceC5250j interfaceC5250j = (InterfaceC5250j) interfaceC5246f.createElement("par");
        if (!C3847e.m14640X()) {
            interfaceC5250j.mo14515b(8.0f);
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            arrayList.add(firstChild);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                interfaceC5250j.appendChild((Node) arrayList.get(i2));
                i = i2 + 1;
            } else {
                return interfaceC5250j;
            }
        }
    }

    /* renamed from: a */
    public C5086i m14899a() {
        if (this.f13929e == null || this.f13926b != null) {
            this.f13928d = C3871q.m14926a(this);
            this.f13929e = m14885a(this.f13928d);
        }
        return this.f13929e;
    }

    /* renamed from: a */
    private C5086i m14885a(InterfaceC5246f interfaceC5246f) {
        return m14884a((Context) null, interfaceC5246f, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.google.android.p134a.p135a.C5086i m14884a(android.content.Context r14, org.p146b.p147a.p149b.InterfaceC5246f r15, boolean r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p110g.C3870p.m14884a(android.content.Context, org.b.a.b.f, boolean):com.sec.google.android.a.a.i");
    }

    /* renamed from: a */
    private String m14886a(int i, int i2, AbstractC3863i abstractC3863i, C5094q c5094q, String str) {
        String string;
        int i3 = i + 1;
        while (true) {
            int i4 = i3;
            if (i4 < this.f13925a.size()) {
                C3869o c3869o = this.f13925a.get(i4);
                if (c3869o != null) {
                    for (int i5 = 0; i5 < c3869o.size(); i5++) {
                        if (i != i4 && c3869o.get(i5) != null && str.equals(c3869o.get(i5).m14816q())) {
                            int iLastIndexOf = str.lastIndexOf(46);
                            if (iLastIndexOf != -1) {
                                string = new StringBuffer(str.substring(0, iLastIndexOf)).append("_").append(i4).append(str.substring(iLastIndexOf)).toString();
                            } else {
                                string = new StringBuffer(str).append("_").append(i4).toString();
                            }
                            C3890m.m14997c("Mms/slideshow", "changed file name = " + string);
                            str = string;
                        }
                    }
                }
                i3 = i4 + 1;
            } else {
                return str;
            }
        }
    }

    /* renamed from: b */
    private synchronized void m14894b(C5086i c5086i) {
        String string;
        for (int i = 0; i < this.f13926b.size(); i++) {
            C3855a c3855a = this.f13926b.get(i);
            C5094q c5094q = new C5094q();
            String strM14748d = c3855a.m14748d();
            int i2 = 0;
            while (i2 < this.f13926b.size()) {
                if (i2 == i || !strM14748d.equals(this.f13926b.get(i2).m14748d())) {
                    string = strM14748d;
                } else {
                    int iLastIndexOf = strM14748d.lastIndexOf(46);
                    if (iLastIndexOf != -1) {
                        string = new StringBuffer(strM14748d.substring(0, iLastIndexOf)).append("_").append(i).append(strM14748d.substring(iLastIndexOf)).toString();
                    } else {
                        string = new StringBuffer(strM14748d).append("_").append(i).toString();
                    }
                }
                i2++;
                strM14748d = string;
            }
            c5094q.m19384b(strM14748d.getBytes());
            c5094q.m19385c(strM14748d.getBytes());
            c5094q.m19389e(c3855a.f13856c.getBytes());
            c5094q.m19381a(c3855a.m14747c());
            if (c3855a.m14746b() != null) {
                c5094q.m19380a(c3855a.m14746b());
            }
            c5086i.m19332a(c5094q);
        }
    }

    /* renamed from: a */
    private void m14891a(InterfaceC5246f interfaceC5246f, C5086i c5086i) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            C3820c.m14513a(interfaceC5246f, byteArrayOutputStream);
            C5094q c5094q = new C5094q();
            c5094q.m19384b("smil".getBytes());
            c5094q.m19385c("smil.xml".getBytes());
            c5094q.m19389e("application/smil".getBytes());
            c5094q.m19381a(byteArrayOutputStream.toByteArray());
            c5086i.m19332a(c5094q);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    C3890m.m14995a("Mms/slideshow", e.getMessage(), e);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    C3890m.m14995a("Mms/slideshow", e2.getMessage(), e2);
                }
            }
            throw th;
        }
    }

    /* renamed from: b */
    public C5086i m14909b(Context context) {
        return m14884a(context, C3871q.m14926a(this), true);
    }

    /* renamed from: b */
    public static C5086i m14893b(Context context, Uri uri) {
        C5095r c5095rM19449a = C5097t.m19426a(context).m19449a(uri);
        int iM19403h = c5095rM19449a.m19403h();
        if (iM19403h == 128 || iM19403h == 132) {
            return ((C5083f) c5095rM19449a).m19309a();
        }
        throw new C5111c();
    }

    /* renamed from: a */
    public void m14900a(int i) {
        this.f13930f = i;
    }

    /* renamed from: b */
    public int m14907b() {
        return this.f13930f;
    }

    /* renamed from: c */
    public int m14911c() {
        return this.f13931g;
    }

    /* renamed from: b */
    public void m14910b(int i) {
        if (i > 0) {
            this.f13930f += i;
        }
    }

    /* renamed from: c */
    public void m14912c(int i) {
        if (i > 0) {
            this.f13930f -= i;
        }
    }

    /* renamed from: d */
    public C3862h m14913d() {
        return this.f13927c;
    }

    @Override // java.util.List, java.util.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(C3869o c3869o) {
        if (c3869o == null) {
            C3890m.m14994a("Mms/slideshow", "add(SlideModel object) return false. object may not be null");
            return false;
        }
        int iM14855b = c3869o.m14855b();
        m14918f(iM14855b);
        if (!this.f13925a.add(c3869o)) {
            return false;
        }
        m14910b(iM14855b);
        c3869o.m14834c(this);
        Iterator<InterfaceC3860f> it = this.f13899l.iterator();
        while (it.hasNext()) {
            c3869o.m14834c(it.next());
        }
        m14833a(true);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends C3869o> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (this.f13925a.size() > 0) {
            Iterator<C3869o> it = this.f13925a.iterator();
            while (it.hasNext()) {
                C3869o next = it.next();
                next.m14835d(this);
                Iterator<InterfaceC3860f> it2 = this.f13899l.iterator();
                while (it2.hasNext()) {
                    next.m14835d(it2.next());
                }
            }
            this.f13930f = 0;
            this.f13925a.clear();
            m14833a(true);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f13925a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f13925a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f13925a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<C3869o> iterator() {
        return this.f13925a.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null || !this.f13925a.remove(obj)) {
            return false;
        }
        C3869o c3869o = (C3869o) obj;
        m14912c(c3869o.m14855b());
        c3869o.m14832E();
        m14833a(true);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f13925a.size();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f13925a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f13925a.toArray(tArr);
    }

    @Override // java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i, C3869o c3869o) {
        if (c3869o != null) {
            int iM14855b = c3869o.m14855b();
            m14918f(iM14855b);
            this.f13925a.add(i, c3869o);
            m14910b(iM14855b);
            c3869o.m14834c(this);
            Iterator<InterfaceC3860f> it = this.f13899l.iterator();
            while (it.hasNext()) {
                c3869o.m14834c(it.next());
            }
            m14833a(true);
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends C3869o> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C3869o get(int i) {
        if (i < 0 || i >= this.f13925a.size()) {
            return null;
        }
        return this.f13925a.get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f13925a.indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f13925a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<C3869o> listIterator() {
        return this.f13925a.listIterator();
    }

    @Override // java.util.List
    public ListIterator<C3869o> listIterator(int i) {
        return this.f13925a.listIterator(i);
    }

    @Override // java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C3869o remove(int i) {
        C3869o c3869oRemove = this.f13925a.remove(i);
        if (c3869oRemove != null) {
            m14912c(c3869oRemove.m14855b());
            c3869oRemove.m14832E();
            m14833a(true);
        }
        return c3869oRemove;
    }

    @Override // java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C3869o set(int i, C3869o c3869o) {
        int iM14855b;
        C3869o c3869o2 = this.f13925a.get(i);
        if (c3869o != null) {
            int iM14855b2 = c3869o.m14855b();
            if (c3869o2 == null) {
                iM14855b = 0;
            } else {
                iM14855b = c3869o2.m14855b();
            }
            if (iM14855b2 > iM14855b) {
                m14918f(iM14855b2 - iM14855b);
                m14910b(iM14855b2 - iM14855b);
            } else {
                m14912c(iM14855b - iM14855b2);
            }
        }
        C3869o c3869o3 = this.f13925a.set(i, c3869o);
        if (c3869o3 != null) {
            c3869o3.m14832E();
        }
        if (c3869o != null) {
            c3869o.m14834c(this);
            Iterator<InterfaceC3860f> it = this.f13899l.iterator();
            while (it.hasNext()) {
                c3869o.m14834c(it.next());
            }
        }
        m14833a(true);
        return c3869o3;
    }

    @Override // java.util.List
    public List<C3869o> subList(int i, int i2) {
        return this.f13925a.subList(i, i2);
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: a */
    protected void mo14789a(InterfaceC3860f interfaceC3860f) {
        this.f13927c.m14834c(interfaceC3860f);
        Iterator<C3869o> it = this.f13925a.iterator();
        while (it.hasNext()) {
            it.next().m14834c(interfaceC3860f);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: b */
    protected void mo14791b(InterfaceC3860f interfaceC3860f) {
        this.f13927c.m14835d(interfaceC3860f);
        Iterator<C3869o> it = this.f13925a.iterator();
        while (it.hasNext()) {
            it.next().m14835d(interfaceC3860f);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: t_ */
    protected void mo14797t_() {
        this.f13927c.m14832E();
        Iterator<C3869o> it = this.f13925a.iterator();
        while (it.hasNext()) {
            it.next().m14832E();
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3860f
    public void onModelChanged(C3866l c3866l, boolean z) {
        if (z) {
            this.f13928d = null;
            this.f13929e = null;
        }
    }

    /* renamed from: a */
    public void m14905a(C5086i c5086i) {
        Iterator<C3869o> it = this.f13925a.iterator();
        while (it.hasNext()) {
            Iterator<AbstractC3863i> it2 = it.next().iterator();
            while (it2.hasNext()) {
                AbstractC3863i next = it2.next();
                C5094q c5094qM19334b = c5086i.m19334b(next.m14816q());
                if (c5094qM19334b != null) {
                    next.m14805a(c5094qM19334b.m19383b());
                }
            }
        }
    }

    /* renamed from: f */
    public void m14918f(int i) {
        C3859e.m14762a().mo14757a(this.f13930f, i, this.f13932h.getContentResolver());
    }

    /* renamed from: e */
    public boolean m14916e() {
        if (size() != 1) {
            return false;
        }
        C3869o c3869o = get(0);
        return c3869o.m14865f() ^ (c3869o.m14863e() ^ c3869o.m14867g());
    }

    /* renamed from: f */
    public void m14917f() {
        C3872r c3872rM14874n;
        if (size() == 1 && (c3872rM14874n = get(0).m14874n()) != null) {
            c3872rM14874n.m14943b();
        }
    }

    /* renamed from: a */
    public void m14904a(C3855a c3855a) {
        m14901a(this.f13926b.size(), c3855a);
    }

    /* renamed from: a */
    public synchronized void m14901a(int i, C3855a c3855a) {
        if (c3855a != null) {
            int iM14749e = c3855a.m14749e();
            m14918f(iM14749e);
            this.f13926b.add(i, c3855a);
            m14910b(iM14749e);
            m14890a((C3866l) c3855a);
            m14833a(true);
        }
    }

    /* renamed from: a */
    private void m14890a(C3866l c3866l) {
        c3866l.m14834c(this);
        Iterator<InterfaceC3860f> it = this.f13899l.iterator();
        while (it.hasNext()) {
            c3866l.m14834c(it.next());
        }
    }

    /* renamed from: g */
    public boolean m14919g() {
        while (this.f13926b != null && !this.f13926b.isEmpty()) {
            C3855a c3855aRemove = this.f13926b.remove(0);
            m14912c(c3855aRemove.f13857d);
            c3855aRemove.m14832E();
        }
        m14833a(true);
        return true;
    }

    /* renamed from: i */
    public synchronized String m14920i() {
        String str;
        str = "";
        if (!this.f13926b.isEmpty()) {
            Iterator<C3855a> it = this.f13926b.iterator();
            String strConcat = "";
            while (it.hasNext()) {
                C3855a next = it.next();
                String strConcat2 = !TextUtils.isEmpty(strConcat) ? strConcat.concat("\n") : strConcat;
                String strM14748d = next.m14748d();
                String strM14744a = next.m14744a();
                strConcat = strConcat2.concat((strM14744a == null || !"text/x-vCard".equals(strM14744a) || strM14748d.endsWith(".vcf")) ? strM14748d : strM14748d + ".vcf");
            }
            str = strConcat;
        }
        return str;
    }

    /* renamed from: j */
    public boolean m14921j() {
        return m14922k() > 0;
    }

    /* renamed from: k */
    public int m14922k() {
        return this.f13926b.size();
    }

    /* renamed from: l */
    public ArrayList<C3855a> m14923l() {
        return this.f13926b;
    }

    /* renamed from: m */
    public C3855a m14924m() {
        return this.f13926b.get(0);
    }

    /* renamed from: a */
    public void m14903a(Uri uri) {
        int iM14817r = 0;
        Iterator<C3869o> it = this.f13925a.iterator();
        int iM14817r2 = 0;
        int i = 0;
        while (it.hasNext()) {
            Iterator<AbstractC3863i> it2 = it.next().iterator();
            while (it2.hasNext()) {
                AbstractC3863i next = it2.next();
                if (next.mo14778g()) {
                    i++;
                } else {
                    iM14817r2 += next.m14817r();
                }
            }
        }
        C3890m.m14994a("Mms/slideshow", "finalResize: original message size: " + m14907b() + " getMaxMessageSize: " + C3847e.m14697c() + " fixedSizeTotal: " + iM14817r2);
        if (i > 0) {
            int iM14697c = (C3847e.m14697c() - iM14817r2) - 1024;
            if (iM14697c <= 0) {
                throw new C3781b("No room for pictures");
            }
            long id = ContentUris.parseId(uri);
            int i2 = iM14697c / i;
            Iterator<C3869o> it3 = this.f13925a.iterator();
            while (it3.hasNext()) {
                Iterator<AbstractC3863i> it4 = it3.next().iterator();
                while (it4.hasNext()) {
                    AbstractC3863i next2 = it4.next();
                    if (next2.mo14778g()) {
                        next2.mo14773a(i2, id);
                    }
                }
            }
            Iterator<C3869o> it5 = this.f13925a.iterator();
            while (it5.hasNext()) {
                Iterator<AbstractC3863i> it6 = it5.next().iterator();
                while (it6.hasNext()) {
                    iM14817r += it6.next().m14817r();
                }
            }
            C3890m.m14994a("Mms/slideshow", "finalResize: new message size: " + iM14817r);
            if (iM14817r > C3847e.m14653aD()) {
                throw new C3781b("After compressing pictures, message too big, ExceedLargeFileSizeException");
            }
            if (iM14817r > C3847e.m14697c()) {
                throw new C3805c("After compressing pictures, message too big, ExceedMessageSizeException");
            }
            m14900a(iM14817r);
            onModelChanged(this, true);
            C5097t.m19426a(this.f13932h).m19450a(uri, m14899a());
        }
    }

    /* renamed from: a */
    private static void m14892a(InterfaceC5250j interfaceC5250j, InterfaceC5249i interfaceC5249i, AbstractC3863i abstractC3863i) {
        int iM14811l = abstractC3863i.m14811l();
        float fB = interfaceC5250j.mo14506b();
        if (fB == 0.0f) {
            abstractC3863i.m14809b(iM14811l);
            if (iM14811l / 1000.0d > fB) {
                String tagName = interfaceC5249i.getTagName();
                if (C5077a.m19291d(abstractC3863i.f13884f) || tagName.equals("video") || C5077a.m19290c(abstractC3863i.f13884f) || tagName.equals("audio")) {
                    interfaceC5250j.mo14515b(iM14811l / 1000.0f);
                } else if (iM14811l / 1000.0d < fB || ((int) fB) != 0) {
                    abstractC3863i.m14809b(((int) fB) * 1000);
                } else {
                    interfaceC5250j.mo14515b(iM14811l / 1000.0f);
                }
            }
            abstractC3863i.m14808a((short) 1);
        }
    }

    /* renamed from: a */
    private static C3870p m14883a(Context context, C5086i c5086i, InterfaceC5246f interfaceC5246f, C3862h c3862h, ArrayList<C3869o> arrayList, int i, ArrayList<C3855a> arrayList2) {
        String string;
        C3870p c3870p = new C3870p(c3862h, arrayList, arrayList2, interfaceC5246f, c5086i, context);
        boolean zM14897n = m14897n();
        C3890m.m14996b("Mms/slideshow", "isRaw:" + f13922i + ",addAttach:" + zM14897n);
        if (arrayList.size() == 0 && f13922i && !zM14897n) {
            arrayList.add(new C3869o(c3870p));
        }
        if (f13922i && m14897n()) {
            int size = c3870p.size();
            C3869o c3869o = new C3869o(c3870p);
            C3872r c3872r = new C3872r(context, "text/plain", "cid:text_" + size + ".txt", c3870p.m14913d().m14790b());
            if (c3870p.m14922k() == 1) {
                string = context.getString(R.string.not_shown_oneFile);
            } else {
                string = context.getString(R.string.not_shown_twoMoreFile);
            }
            c3872r.m14941a((CharSequence) new StringBuffer(string).append("\n\n").append(c3870p.m14920i()).toString());
            c3869o.add((AbstractC3863i) c3872r);
            if (size == 1 && i == 0) {
                c3870p.add(size - 1, c3869o);
                c3870p.remove(size);
            } else {
                c3870p.add(size, c3869o);
            }
            m14895b(false);
            if (!m14898o()) {
                m14896c(true);
            }
        }
        if (m14897n()) {
            m14895b(false);
        }
        if (!m14898o()) {
            m14896c(true);
        }
        c3870p.m14834c(c3870p);
        return c3870p;
    }

    /* renamed from: n */
    public static boolean m14897n() {
        boolean z = f13923j ? f13923j : false;
        f13923j = false;
        return z;
    }

    /* renamed from: b */
    public static void m14895b(boolean z) {
        f13923j = z;
    }

    /* renamed from: c */
    public static void m14896c(boolean z) {
        f13924k = z;
    }

    /* renamed from: o */
    public static boolean m14898o() {
        return f13924k;
    }

    /* renamed from: a */
    private static String m14887a(C5094q c5094q) {
        if (c5094q.m19390e() != null) {
            return new String(c5094q.m19390e());
        }
        return c5094q.m19399k();
    }

    /* renamed from: a */
    private static ArrayList<C3855a> m14888a(Context context, C5086i c5086i, NodeList nodeList) {
        C3855a c3855a;
        int iM19333b = c5086i.m19333b();
        ArrayList<C3855a> arrayList = new ArrayList<>();
        for (int i = 0; i < iM19333b; i++) {
            C5094q c5094qM19328a = c5086i.m19328a(i);
            String str = new String(c5094qM19328a.m19394g());
            if ("text/x-vCard".equalsIgnoreCase(str) || "text/x-vCalendar".equalsIgnoreCase(str) || "text/x-vNote".equalsIgnoreCase(str) || "text/x-vtodo".equalsIgnoreCase(str)) {
                try {
                    c3855a = new C3855a(context, str, m14887a(c5094qM19328a), c5094qM19328a.m19383b());
                } catch (C5111c e) {
                    e.printStackTrace();
                    c3855a = null;
                }
                if (c3855a != null && !"text/plain".equals(str) && !C5077a.m19288b(str)) {
                    arrayList.add(arrayList.size(), c3855a);
                    f13922i = true;
                }
            }
        }
        return arrayList;
    }
}
