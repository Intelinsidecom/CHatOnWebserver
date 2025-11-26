package com.sec.chaton.smsplugin.p110g;

import android.text.TextUtils;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p148a.InterfaceC5239d;

/* compiled from: SlideModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.o */
/* loaded from: classes.dex */
public class C3869o extends C3866l implements List<AbstractC3863i>, InterfaceC5239d {

    /* renamed from: a */
    public C3870p f13909a;

    /* renamed from: b */
    private final ArrayList<AbstractC3863i> f13910b;

    /* renamed from: c */
    private AbstractC3863i f13911c;

    /* renamed from: d */
    private AbstractC3863i f13912d;

    /* renamed from: e */
    private AbstractC3863i f13913e;

    /* renamed from: f */
    private AbstractC3863i f13914f;

    /* renamed from: g */
    private boolean f13915g;

    /* renamed from: h */
    private boolean f13916h;

    /* renamed from: i */
    private boolean f13917i;

    /* renamed from: j */
    private int f13918j;

    /* renamed from: k */
    private boolean f13919k;

    /* renamed from: m */
    private short f13920m;

    /* renamed from: n */
    private int f13921n;

    public C3869o(C3870p c3870p) {
        this(5000, c3870p);
    }

    public C3869o(int i, C3870p c3870p) {
        this.f13910b = new ArrayList<>();
        this.f13915g = true;
        this.f13916h = true;
        this.f13917i = true;
        this.f13919k = true;
        this.f13918j = i;
        this.f13909a = c3870p;
    }

    public C3869o(int i, ArrayList<AbstractC3863i> arrayList) {
        this.f13910b = new ArrayList<>();
        this.f13915g = true;
        this.f13916h = true;
        this.f13917i = true;
        this.f13919k = true;
        this.f13918j = i;
        int iM14811l = 0;
        Iterator<AbstractC3863i> it = arrayList.iterator();
        while (true) {
            int i2 = iM14811l;
            if (it.hasNext()) {
                AbstractC3863i next = it.next();
                m14848b(next);
                iM14811l = next.m14811l();
                if (iM14811l <= i2) {
                    iM14811l = i2;
                }
            } else {
                m14868h(i2);
                return;
            }
        }
    }

    /* renamed from: b */
    private void m14848b(AbstractC3863i abstractC3863i) {
        if (abstractC3863i != null) {
            if (abstractC3863i.m14818s()) {
                String strM14812m = abstractC3863i.m14812m();
                if (TextUtils.isEmpty(strM14812m) || "text/plain".equals(strM14812m) || "text/html".equals(strM14812m)) {
                    m14846a(this.f13911c, abstractC3863i);
                    this.f13911c = abstractC3863i;
                    return;
                } else {
                    C3890m.m14997c("Mms/slideshow", "[SlideModel] content type " + abstractC3863i.m14812m() + " isn't supported (as text)");
                    return;
                }
            }
            if (abstractC3863i.m14819t()) {
                if (this.f13915g) {
                    m14846a(this.f13912d, abstractC3863i);
                    this.f13912d = abstractC3863i;
                    this.f13917i = false;
                    return;
                }
                C3890m.m14997c("Mms/slideshow", "[SlideModel] content type " + abstractC3863i.m14812m() + " - can't add image in this state");
                return;
            }
            if (abstractC3863i.m14821v()) {
                if (this.f13916h) {
                    m14846a(this.f13913e, abstractC3863i);
                    this.f13913e = abstractC3863i;
                    this.f13917i = false;
                    return;
                }
                C3890m.m14997c("Mms/slideshow", "[SlideModel] content type " + abstractC3863i.m14812m() + " - can't add audio in this state");
                return;
            }
            if (abstractC3863i.m14820u()) {
                if (this.f13917i) {
                    m14846a(this.f13914f, abstractC3863i);
                    this.f13914f = abstractC3863i;
                    this.f13915g = false;
                    this.f13916h = false;
                    return;
                }
                C3890m.m14997c("Mms/slideshow", "[SlideModel] content type " + abstractC3863i.m14812m() + " - can't add video in this state");
            }
        }
    }

    /* renamed from: a */
    private void m14846a(AbstractC3863i abstractC3863i, AbstractC3863i abstractC3863i2) {
        int iM14817r = abstractC3863i2.mo14778g() ? 0 : abstractC3863i2.m14817r();
        if (abstractC3863i == null) {
            if (this.f13909a != null) {
                this.f13909a.m14918f(iM14817r);
            }
            this.f13910b.add(abstractC3863i2);
            m14857b(iM14817r);
            m14860d(iM14817r);
        } else {
            int iM14817r2 = abstractC3863i.mo14778g() ? 0 : abstractC3863i.m14817r();
            if (iM14817r > iM14817r2) {
                if (this.f13909a != null) {
                    this.f13909a.m14918f(iM14817r - iM14817r2);
                }
                m14857b(iM14817r - iM14817r2);
                m14860d(iM14817r - iM14817r2);
            } else {
                m14858c(iM14817r2 - iM14817r);
                m14862e(iM14817r2 - iM14817r);
            }
            this.f13910b.set(this.f13910b.indexOf(abstractC3863i), abstractC3863i2);
            abstractC3863i.m14832E();
        }
        Iterator<InterfaceC3860f> it = this.f13899l.iterator();
        while (it.hasNext()) {
            abstractC3863i2.m14834c(it.next());
        }
    }

    /* renamed from: a */
    private boolean m14847a(Object obj) {
        if (!this.f13910b.remove(obj)) {
            return false;
        }
        if (obj instanceof C3872r) {
            this.f13911c = null;
        } else if (obj instanceof C3861g) {
            this.f13912d = null;
            this.f13917i = true;
        } else if (obj instanceof C3856b) {
            this.f13913e = null;
            this.f13917i = true;
        } else if (obj instanceof C3873s) {
            this.f13914f = null;
            this.f13915g = true;
            this.f13916h = true;
        }
        int iM14817r = ((AbstractC3863i) obj).mo14778g() ? 0 : ((AbstractC3863i) obj).m14817r();
        m14858c(iM14817r);
        m14862e(iM14817r);
        ((C3866l) obj).m14832E();
        return true;
    }

    /* renamed from: a */
    public int m14849a() {
        return this.f13918j;
    }

    /* renamed from: a */
    public void m14850a(int i) {
        this.f13918j = i;
        m14833a(true);
    }

    /* renamed from: b */
    public int m14855b() {
        return this.f13921n;
    }

    /* renamed from: b */
    public void m14857b(int i) {
        if (i > 0) {
            this.f13921n += i;
        }
    }

    /* renamed from: c */
    public void m14858c(int i) {
        if (i > 0) {
            this.f13921n -= i;
        }
    }

    /* renamed from: a */
    public void m14852a(C3870p c3870p) {
        this.f13909a = c3870p;
    }

    /* renamed from: d */
    public void m14860d(int i) {
        if (i > 0 && this.f13909a != null) {
            this.f13909a.m14900a(this.f13909a.m14907b() + i);
        }
    }

    /* renamed from: e */
    public void m14862e(int i) {
        if (i > 0 && this.f13909a != null) {
            this.f13909a.m14900a(this.f13909a.m14907b() - i);
        }
    }

    @Override // java.util.List, java.util.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(AbstractC3863i abstractC3863i) {
        m14848b(abstractC3863i);
        m14833a(true);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends AbstractC3863i> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (this.f13910b.size() > 0) {
            Iterator<AbstractC3863i> it = this.f13910b.iterator();
            while (it.hasNext()) {
                AbstractC3863i next = it.next();
                next.m14832E();
                int iM14817r = next.m14817r();
                m14858c(iM14817r);
                m14862e(iM14817r);
            }
            this.f13910b.clear();
            this.f13911c = null;
            this.f13912d = null;
            this.f13913e = null;
            this.f13914f = null;
            this.f13915g = true;
            this.f13916h = true;
            this.f13917i = true;
            m14833a(true);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f13910b.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f13910b.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f13910b.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<AbstractC3863i> iterator() {
        return this.f13910b.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null || !(obj instanceof AbstractC3863i) || !m14847a(obj)) {
            return false;
        }
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
        return this.f13910b.size();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f13910b.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f13910b.toArray(tArr);
    }

    @Override // java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i, AbstractC3863i abstractC3863i) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends AbstractC3863i> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC3863i get(int i) {
        if (this.f13910b.size() == 0) {
            return null;
        }
        return this.f13910b.get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f13910b.indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f13910b.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<AbstractC3863i> listIterator() {
        return this.f13910b.listIterator();
    }

    @Override // java.util.List
    public ListIterator<AbstractC3863i> listIterator(int i) {
        return this.f13910b.listIterator(i);
    }

    @Override // java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC3863i remove(int i) {
        AbstractC3863i abstractC3863i = this.f13910b.get(i);
        if (abstractC3863i != null && m14847a((Object) abstractC3863i)) {
            m14833a(true);
        }
        return abstractC3863i;
    }

    @Override // java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC3863i set(int i, AbstractC3863i abstractC3863i) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public List<AbstractC3863i> subList(int i, int i2) {
        return this.f13910b.subList(i, i2);
    }

    /* renamed from: c */
    public boolean m14859c() {
        return this.f13919k;
    }

    /* renamed from: a */
    public void m14853a(short s) {
        this.f13920m = s;
        m14833a(true);
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: a */
    protected void mo14789a(InterfaceC3860f interfaceC3860f) {
        Iterator<AbstractC3863i> it = this.f13910b.iterator();
        while (it.hasNext()) {
            it.next().m14834c(interfaceC3860f);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: b */
    protected void mo14791b(InterfaceC3860f interfaceC3860f) {
        Iterator<AbstractC3863i> it = this.f13910b.iterator();
        while (it.hasNext()) {
            it.next().m14835d(interfaceC3860f);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: t_ */
    protected void mo14797t_() {
        Iterator<AbstractC3863i> it = this.f13910b.iterator();
        while (it.hasNext()) {
            it.next().m14832E();
        }
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5239d
    /* renamed from: a */
    public void mo14745a(InterfaceC5237b interfaceC5237b) {
        if (interfaceC5237b.mo14494b().equals("SmilSlideStart")) {
            this.f13919k = true;
        } else if (this.f13920m != 1) {
            this.f13919k = false;
        }
        m14833a(false);
    }

    /* renamed from: d */
    public boolean m14861d() {
        return this.f13911c != null;
    }

    /* renamed from: e */
    public boolean m14863e() {
        return this.f13912d != null;
    }

    /* renamed from: f */
    public boolean m14865f() {
        return this.f13913e != null;
    }

    /* renamed from: g */
    public boolean m14867g() {
        return this.f13914f != null;
    }

    /* renamed from: i */
    public boolean m14869i() {
        return m14863e() || m14867g() || m14865f();
    }

    /* renamed from: j */
    public boolean m14870j() {
        return remove(this.f13911c);
    }

    /* renamed from: k */
    public boolean m14871k() {
        return remove(this.f13912d);
    }

    /* renamed from: l */
    public boolean m14872l() {
        boolean zRemove = remove(this.f13913e);
        m14878r();
        return zRemove;
    }

    /* renamed from: m */
    public boolean m14873m() {
        boolean zRemove = remove(this.f13914f);
        m14878r();
        return zRemove;
    }

    /* renamed from: n */
    public C3872r m14874n() {
        return (C3872r) this.f13911c;
    }

    /* renamed from: o */
    public C3861g m14875o() {
        return (C3861g) this.f13912d;
    }

    /* renamed from: p */
    public C3856b m14876p() {
        return (C3856b) this.f13913e;
    }

    /* renamed from: q */
    public C3873s m14877q() {
        return (C3873s) this.f13914f;
    }

    /* renamed from: r */
    public void m14878r() {
        if (!m14865f() && !m14867g()) {
            this.f13918j = 5000;
        }
    }

    /* renamed from: h */
    public void m14868h(int i) {
        if (i > 0) {
            if (i > this.f13918j || this.f13918j == 5000) {
                this.f13918j = i;
            }
        }
    }

    /* renamed from: s */
    public boolean m14879s() {
        if (this.f13910b.size() == 1) {
            return true;
        }
        if (m14875o() != null && m14874n() != null && m14877q() == null && m14876p() == null) {
            return true;
        }
        if (m14875o() != null || m14874n() == null || m14877q() == null || m14876p() != null) {
            return m14875o() == null && m14874n() != null && m14877q() == null && m14876p() != null;
        }
        return true;
    }
}
