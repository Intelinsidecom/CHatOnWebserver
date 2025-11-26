package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestBatch.java */
/* renamed from: com.facebook.ax */
/* loaded from: classes.dex */
public class C0083ax extends AbstractList<C0072am> {

    /* renamed from: a */
    private static AtomicInteger f138a = new AtomicInteger();

    /* renamed from: b */
    private Handler f139b;

    /* renamed from: c */
    private List<C0072am> f140c;

    /* renamed from: d */
    private int f141d = 0;

    /* renamed from: e */
    private final String f142e = Integer.valueOf(f138a.incrementAndGet()).toString();

    /* renamed from: f */
    private List<InterfaceC0084ay> f143f = new ArrayList();

    /* renamed from: g */
    private String f144g;

    public C0083ax() {
        this.f140c = new ArrayList();
        this.f140c = new ArrayList();
    }

    public C0083ax(Collection<C0072am> collection) {
        this.f140c = new ArrayList();
        this.f140c = new ArrayList(collection);
    }

    public C0083ax(C0072am... c0072amArr) {
        this.f140c = new ArrayList();
        this.f140c = Arrays.asList(c0072amArr);
    }

    /* renamed from: a */
    public int m191a() {
        return this.f141d;
    }

    /* renamed from: a */
    public void m195a(InterfaceC0084ay interfaceC0084ay) {
        if (!this.f143f.contains(interfaceC0084ay)) {
            this.f143f.add(interfaceC0084ay);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean add(C0072am c0072am) {
        return this.f140c.add(c0072am);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void add(int i, C0072am c0072am) {
        this.f140c.add(i, c0072am);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f140c.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C0072am get(int i) {
        return this.f140c.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C0072am remove(int i) {
        return this.f140c.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C0072am set(int i, C0072am c0072am) {
        return this.f140c.set(i, c0072am);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f140c.size();
    }

    /* renamed from: b */
    final String m200b() {
        return this.f142e;
    }

    /* renamed from: c */
    final Handler m201c() {
        return this.f139b;
    }

    /* renamed from: a */
    final void m194a(Handler handler) {
        this.f139b = handler;
    }

    /* renamed from: d */
    final List<C0072am> m202d() {
        return this.f140c;
    }

    /* renamed from: e */
    final List<InterfaceC0084ay> m203e() {
        return this.f143f;
    }

    /* renamed from: f */
    final String m204f() {
        return this.f144g;
    }

    /* renamed from: a */
    final void m196a(String str) {
        this.f144g = str;
    }

    /* renamed from: g */
    public final List<C0085az> m205g() {
        return m207i();
    }

    /* renamed from: h */
    public final AsyncTaskC0082aw m206h() {
        return m208j();
    }

    /* renamed from: i */
    List<C0085az> m207i() {
        return C0072am.m156b(this);
    }

    /* renamed from: j */
    AsyncTaskC0082aw m208j() {
        return C0072am.m159c(this);
    }
}
