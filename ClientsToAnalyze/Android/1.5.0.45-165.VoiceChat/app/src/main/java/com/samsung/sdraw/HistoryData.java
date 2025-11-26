package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Editable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class HistoryData implements Serializable {

    /* renamed from: a */
    private LinkedList<Integer> f1055a = new LinkedList<>();

    /* renamed from: b */
    private HashMap<Integer, LinkedList<C1069y>> f1056b = new HashMap<>();

    /* renamed from: c */
    private HashMap<Integer, LinkedList<C1069y>> f1057c = new HashMap<>();

    /* renamed from: d */
    private LinkedList<byte[]> f1058d = new LinkedList<>();

    /* renamed from: a */
    void m1003a(LinkedList<AbstractSprite> linkedList, Rect rect, Bitmap bitmap) {
        Bitmap bitmap2;
        this.f1058d.add(MemoDataUtils.makeByteData(MemoDataUtils.getAvailableSize(linkedList, null, null), linkedList, null, null, rect));
        Iterator<AbstractSprite> it = linkedList.iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if ((next instanceof C0989ab) && (bitmap2 = ((C0989ab) next).f1421h) != null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate((bitmap2.getWidth() * bitmap2.getHeight() * 4) + 8);
                byteBufferAllocate.position(8);
                bitmap2.copyPixelsToBuffer(byteBufferAllocate);
                byteBufferAllocate.rewind();
                byteBufferAllocate.putInt(bitmap2.getWidth());
                byteBufferAllocate.putInt(bitmap2.getHeight());
                this.f1058d.add(byteBufferAllocate.array());
            }
        }
        this.f1058d.add((byte[]) bitmap.mBuffer.clone());
    }

    /* renamed from: a */
    LinkedList<byte[]> m1001a() {
        return this.f1058d;
    }

    /* renamed from: a */
    void m1002a(int i, LinkedList<SpriteCommand> linkedList, LinkedList<SpriteCommand> linkedList2) {
        this.f1055a.add(Integer.valueOf(i));
        this.f1056b.put(Integer.valueOf(i), m1000a(linkedList));
        this.f1057c.put(Integer.valueOf(i), m1000a(linkedList2));
    }

    /* renamed from: b */
    LinkedList<Integer> m1004b() {
        return this.f1055a;
    }

    /* renamed from: c */
    HashMap<Integer, LinkedList<C1069y>> m1005c() {
        return this.f1056b;
    }

    /* renamed from: d */
    HashMap<Integer, LinkedList<C1069y>> m1006d() {
        return this.f1057c;
    }

    /* renamed from: a */
    private LinkedList<C1069y> m1000a(LinkedList<SpriteCommand> linkedList) {
        LinkedList<C1069y> linkedList2 = new LinkedList<>();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<SpriteCommand> it = linkedList.iterator();
        while (it.hasNext()) {
            SpriteCommand next = it.next();
            if (next instanceof SpriteCreateCommand) {
                C1069y c1069y = new C1069y();
                c1069y.f1810a = 0;
                c1069y.f1811b = ((SpriteCreateCommand) next).sprite.objectID;
                linkedList2.add(c1069y);
            } else if (next instanceof C1019be) {
                C1069y c1069y2 = new C1069y();
                c1069y2.f1810a = 1;
                c1069y2.f1811b = ((C1019be) next).f1558a.objectID;
                linkedList2.add(c1069y2);
            } else if (next instanceof C1021bg) {
                C1021bg c1021bg = (C1021bg) next;
                C1069y c1069y3 = new C1069y();
                c1069y3.f1810a = 0;
                c1069y3.f1811b = c1021bg.f1560a.objectID;
                c1069y3.f1813d = new PointF(c1021bg.f1563d);
                c1069y3.f1812c = new PointF(c1021bg.f1562c);
                linkedList2.add(c1069y3);
            } else if (next instanceof C1023bi) {
                C1023bi c1023bi = (C1023bi) next;
                C1069y c1069y4 = new C1069y();
                c1069y4.f1810a = 3;
                c1069y4.f1811b = c1023bi.f1570a.objectID;
                c1069y4.f1814e = c1023bi.f1572c;
                c1069y4.f1815f = c1023bi.f1573d;
                linkedList2.add(c1069y4);
            } else if (next instanceof C1022bh) {
                C1022bh c1022bh = (C1022bh) next;
                C1069y c1069y5 = new C1069y();
                c1069y5.f1810a = 4;
                c1069y5.f1811b = c1022bh.f1564a.objectID;
                c1069y5.f1816g = new RectF(c1022bh.f1566c);
                c1069y5.f1817h = new RectF(c1022bh.f1567d);
                c1069y5.f1819j = new PointF[4];
                c1069y5.f1819j[0] = new PointF(c1022bh.f1569f[0]);
                c1069y5.f1819j[1] = new PointF(c1022bh.f1569f[1]);
                c1069y5.f1819j[2] = new PointF(c1022bh.f1569f[2]);
                c1069y5.f1819j[3] = new PointF(c1022bh.f1569f[3]);
                c1069y5.f1818i = new PointF[4];
                c1069y5.f1819j[0] = new PointF(c1022bh.f1568e[0]);
                c1069y5.f1819j[1] = new PointF(c1022bh.f1568e[1]);
                c1069y5.f1819j[2] = new PointF(c1022bh.f1568e[2]);
                c1069y5.f1819j[3] = new PointF(c1022bh.f1568e[3]);
                linkedList2.add(c1069y5);
            } else if (next instanceof C1018bd) {
                C1069y c1069y6 = new C1069y();
                c1069y6.f1810a = 5;
                c1069y6.f1811b = ((C1018bd) next).f1556a.objectID;
                linkedList2.add(c1069y6);
            } else if (next instanceof C0990ac) {
                C0990ac c0990ac = (C0990ac) next;
                C1069y c1069y7 = new C1069y();
                c1069y7.f1810a = 6;
                c1069y7.f1811b = c0990ac.f1432a.objectID;
                c1069y7.f1816g = new RectF(c0990ac.f1434c);
                c1069y7.f1820k = new RectF(c0990ac.f1435d);
                c1069y7.f1821l = c0990ac.f1436e;
                c1069y7.f1814e = c0990ac.f1437f;
                linkedList2.add(c1069y7);
            } else if (next instanceof C1039by) {
                C1039by c1039by = (C1039by) next;
                C1069y c1069y8 = new C1069y();
                c1069y8.f1810a = 7;
                c1069y8.f1811b = c1039by.f1669k.objectID;
                c1069y8.f1822m = Editable.Factory.getInstance().newEditable(c1039by.f1659a);
                c1069y8.f1823n = Editable.Factory.getInstance().newEditable(c1039by.f1660b);
                c1069y8.f1824o = new PointF(c1039by.f1661c);
                c1069y8.f1825p = new PointF(c1039by.f1662d);
                c1069y8.f1826q = c1039by.f1663e;
                c1069y8.f1827r = c1039by.f1664f;
                c1069y8.f1828s = c1039by.f1665g;
                c1069y8.f1829t = c1039by.f1666h;
                c1069y8.f1830u = c1039by.f1667i;
                c1069y8.f1831v = c1039by.f1668j;
                linkedList2.add(c1069y8);
            }
        }
        return linkedList2;
    }
}
