package com.sec.chaton.p067j;

import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TcpNetworkQueue.java */
/* renamed from: com.sec.chaton.j.aq */
/* loaded from: classes.dex */
public class C2428aq {

    /* renamed from: a */
    static final String f8649a = C2428aq.class.getSimpleName();

    /* renamed from: b */
    private static LinkedHashMap<Long, AbstractC2429ar> f8650b = null;

    /* renamed from: c */
    private static ExecutorService f8651c = null;

    static {
        m10528c();
    }

    /* renamed from: a */
    public static synchronized void m10523a(boolean z) {
        if (f8650b == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("tcp_queue, mWorker is null", f8649a);
            }
        } else {
            HashMap map = new HashMap();
            Iterator<Map.Entry<Long, AbstractC2429ar>> it = f8650b.entrySet().iterator();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (it.hasNext()) {
                String strM10531g = it.next().getValue().m10531g();
                int i2 = i + 1;
                if (i < 100) {
                    sb.append(", " + strM10531g);
                }
                Integer num = (Integer) map.get(strM10531g);
                if (num == null) {
                    map.put(strM10531g, 1);
                } else {
                    map.put(strM10531g, Integer.valueOf(num.intValue() + 1));
                }
                i = i2;
            }
            if (C4904y.f17872b) {
                if (z) {
                    C4904y.m18639b("tcp_queue, queue status (count based) : " + map.toString() + ((Object) sb), f8649a);
                } else {
                    C4904y.m18639b("tcp_queue, queue status (count based) : " + map.toString(), f8649a);
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized boolean m10526a(AbstractC2429ar abstractC2429ar) {
        boolean z = false;
        synchronized (C2428aq.class) {
            if (f8650b.size() >= 100) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("tcp_queue, add(), TCP NETWORK QUEUE IS FULL, queue size is: " + f8650b.size() + ", " + abstractC2429ar, f8649a);
                }
                if (C4904y.f17872b) {
                    m10523a(true);
                }
                if (m10524a()) {
                }
            }
            if (f8650b.put(Long.valueOf(abstractC2429ar.m10530f()), abstractC2429ar) != null && C4904y.f17872b) {
                C4904y.m18639b("tcp_queue, add(), worker already exist", f8649a);
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("tcp_queue, add() success, queue size is: " + f8650b.size() + ", " + abstractC2429ar, f8649a);
            }
            if (C4904y.f17872b) {
                m10523a(false);
            }
            abstractC2429ar.m10699a((Object[]) new Void[0]);
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized boolean m10525a(long j) {
        boolean z;
        AbstractC2429ar abstractC2429arRemove = f8650b.remove(Long.valueOf(j));
        if (abstractC2429arRemove == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("tcp_queue, remove(), worker does not exist, key: " + j, f8649a);
            }
            z = false;
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b("tcp_queue, remove() success, queue size is: " + f8650b.size() + ", " + abstractC2429arRemove, f8649a);
            }
            if (C4904y.f17872b) {
                m10523a(false);
            }
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    static synchronized boolean m10524a() {
        boolean z;
        ArrayList<Long> arrayList = new ArrayList();
        Iterator<Map.Entry<Long, AbstractC2429ar>> it = f8650b.entrySet().iterator();
        if (it.hasNext()) {
            AbstractC2429ar value = it.next().getValue();
            arrayList.add(Long.valueOf(value.m10530f()));
            value.m10701a(true);
        }
        z = false;
        for (Long l : arrayList) {
            if (l != null && l.longValue() > 0) {
                m10525a(l.longValue());
            }
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public static ExecutorService m10527b() {
        return f8651c;
    }

    /* renamed from: c */
    public static synchronized void m10528c() {
        if (f8650b == null) {
            f8650b = new LinkedHashMap<>();
        }
        if (f8651c == null) {
            f8651c = Executors.newSingleThreadExecutor();
        }
    }
}
