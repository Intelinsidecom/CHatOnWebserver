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
public class C0454ax extends AbstractList<C0443am> {

    /* renamed from: a */
    private static AtomicInteger f1107a = new AtomicInteger();

    /* renamed from: b */
    private Handler f1108b;

    /* renamed from: c */
    private List<C0443am> f1109c;

    /* renamed from: d */
    private int f1110d = 0;

    /* renamed from: e */
    private final String f1111e = Integer.valueOf(f1107a.incrementAndGet()).toString();

    /* renamed from: f */
    private List<InterfaceC0455ay> f1112f = new ArrayList();

    /* renamed from: g */
    private String f1113g;

    public C0454ax() {
        this.f1109c = new ArrayList();
        this.f1109c = new ArrayList();
    }

    public C0454ax(Collection<C0443am> collection) {
        this.f1109c = new ArrayList();
        this.f1109c = new ArrayList(collection);
    }

    public C0454ax(C0443am... c0443amArr) {
        this.f1109c = new ArrayList();
        this.f1109c = Arrays.asList(c0443amArr);
    }

    /* renamed from: a */
    public int m1635a() {
        return this.f1110d;
    }

    /* renamed from: a */
    public void m1639a(InterfaceC0455ay interfaceC0455ay) {
        if (!this.f1112f.contains(interfaceC0455ay)) {
            this.f1112f.add(interfaceC0455ay);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean add(C0443am c0443am) {
        return this.f1109c.add(c0443am);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void add(int i, C0443am c0443am) {
        this.f1109c.add(i, c0443am);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f1109c.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C0443am get(int i) {
        return this.f1109c.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C0443am remove(int i) {
        return this.f1109c.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C0443am set(int i, C0443am c0443am) {
        return this.f1109c.set(i, c0443am);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1109c.size();
    }

    /* renamed from: b */
    final String m1644b() {
        return this.f1111e;
    }

    /* renamed from: c */
    final Handler m1645c() {
        return this.f1108b;
    }

    /* renamed from: a */
    final void m1638a(Handler handler) {
        this.f1108b = handler;
    }

    /* renamed from: d */
    final List<C0443am> m1646d() {
        return this.f1109c;
    }

    /* renamed from: e */
    final List<InterfaceC0455ay> m1647e() {
        return this.f1112f;
    }

    /* renamed from: f */
    final String m1648f() {
        return this.f1113g;
    }

    /* renamed from: a */
    final void m1640a(String str) {
        this.f1113g = str;
    }

    /* renamed from: g */
    public final List<C0456az> m1649g() {
        return m1651i();
    }

    /* renamed from: h */
    public final AsyncTaskC0453aw m1650h() {
        return m1652j();
    }

    /* renamed from: i */
    List<C0456az> m1651i() {
        return C0443am.m1600b(this);
    }

    /* renamed from: j */
    AsyncTaskC0453aw m1652j() {
        return C0443am.m1603c(this);
    }
}
