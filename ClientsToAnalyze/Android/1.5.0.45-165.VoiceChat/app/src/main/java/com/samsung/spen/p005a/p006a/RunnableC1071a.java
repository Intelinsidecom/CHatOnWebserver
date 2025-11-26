package com.samsung.spen.p005a.p006a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.samsung.samm.common.SOptionPlay;
import com.samsung.spen.p005a.p007b.InterfaceC1075c;
import com.samsung.spen.p005a.p008c.InterfaceC1080c;
import com.samsung.spen.p005a.p010e.InterfaceC1092a;
import com.samsung.spensdk.applistener.AnimationProcessListener;
import com.samsung.spensdk.applistener.CustomSoundEffectSettingListener;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.spen.a.a.a */
/* loaded from: classes.dex */
public class RunnableC1071a implements InterfaceC1072b, Runnable {

    /* renamed from: n */
    private SOptionPlay f1846n;

    /* renamed from: a */
    private Handler f1833a = null;

    /* renamed from: b */
    private int f1834b = 0;

    /* renamed from: c */
    private long f1835c = 0;

    /* renamed from: d */
    private long f1836d = 0;

    /* renamed from: e */
    private int f1837e = 1;

    /* renamed from: f */
    private int f1838f = 0;

    /* renamed from: g */
    private int f1839g = 0;

    /* renamed from: h */
    private int f1840h = 0;

    /* renamed from: i */
    private LinkedList<SObject> f1841i = null;

    /* renamed from: j */
    private int f1842j = 0;

    /* renamed from: k */
    private int f1843k = 0;

    /* renamed from: l */
    private int f1844l = 0;

    /* renamed from: m */
    private String f1845m = null;

    /* renamed from: o */
    private int f1847o = 0;

    /* renamed from: p */
    private long f1848p = 10;

    /* renamed from: q */
    private int f1849q = 0;

    /* renamed from: r */
    private int f1850r = 0;

    /* renamed from: s */
    private int f1851s = 0;

    /* renamed from: t */
    private boolean f1852t = false;

    /* renamed from: u */
    private int f1853u = 0;

    /* renamed from: v */
    private int f1854v = 0;

    /* renamed from: w */
    private Handler f1855w = new Handler() { // from class: com.samsung.spen.a.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (RunnableC1071a.this.f1852t) {
                        Log.w("AnimationManager", "Skip handler task");
                        break;
                    } else if (!RunnableC1071a.this.m1662c(true)) {
                        RunnableC1071a.this.f1852t = true;
                        Log.w("AnimationManager", "Animation Completed or error occurred. Set TaskNum(" + RunnableC1071a.this.f1853u + ") to " + RunnableC1071a.this.f1854v);
                        RunnableC1071a.this.f1853u = RunnableC1071a.this.f1854v;
                        break;
                    } else {
                        RunnableC1071a.this.f1854v++;
                        break;
                    }
            }
            super.handleMessage(message);
        }
    };

    /* renamed from: x */
    private AnimationProcessListener f1856x = new AnimationProcessListener() { // from class: com.samsung.spen.a.a.a.2
        @Override // com.samsung.spensdk.applistener.AnimationProcessListener
        public void onPlayComplete() {
        }

        @Override // com.samsung.spensdk.applistener.AnimationProcessListener
        public void onChangeProgress(int i) {
        }
    };

    /* renamed from: y */
    private InterfaceC1080c f1857y = new InterfaceC1080c() { // from class: com.samsung.spen.a.a.a.3
        @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
        /* renamed from: a */
        public boolean mo1669a(SObject sObject) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
        /* renamed from: a */
        public boolean mo1668a(int i, float f, float f2, float f3, int i2, long j, long j2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
        /* renamed from: a */
        public boolean mo1667a() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
        /* renamed from: b */
        public boolean mo1670b(SObject sObject) {
            return false;
        }
    };

    /* renamed from: z */
    private InterfaceC1075c f1858z = new InterfaceC1075c() { // from class: com.samsung.spen.a.a.a.4
        @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
        /* renamed from: a */
        public boolean mo1673a(int i, float f, int i2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
        /* renamed from: a */
        public boolean mo1674a(int i, float f, int i2, String str) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
        /* renamed from: a */
        public boolean mo1672a() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
        /* renamed from: a */
        public void mo1671a(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
        /* renamed from: b */
        public void mo1675b(boolean z) {
        }
    };

    /* renamed from: A */
    private InterfaceC1092a f1832A = new InterfaceC1092a() { // from class: com.samsung.spen.a.a.a.5
        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public boolean mo1677a() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: b */
        public boolean mo1684b() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public boolean mo1682a(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public boolean mo1681a(String str, boolean z, float f, boolean z2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public boolean mo1683a(boolean z, boolean z2, boolean z3) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public boolean mo1678a(float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public boolean mo1680a(int i, float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: b */
        public boolean mo1686b(int i, float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: c */
        public boolean mo1690c(int i, float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: b */
        public boolean mo1685b(float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: c */
        public boolean mo1689c(float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: c */
        public boolean mo1688c() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: b */
        public boolean mo1687b(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public boolean mo1679a(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: d */
        public boolean mo1691d() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: e */
        public boolean mo1692e() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
        /* renamed from: a */
        public void mo1676a(CustomSoundEffectSettingListener customSoundEffectSettingListener) {
        }
    };

    public RunnableC1071a(Context context, int i, int i2) {
        this.f1846n = null;
        this.f1846n = new SOptionPlay();
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public boolean mo1654a(SOptionPlay sOptionPlay) {
        if (sOptionPlay == null) {
            Log.e("AnimationManager", "playOption is null");
            return false;
        }
        if (this.f1846n == null) {
            Log.e("AnimationManager", "mPlayOption is null");
            return false;
        }
        this.f1846n.setInvisibleBGImageAnimationOption(sOptionPlay.getInvisibleBGImageAnimationOption());
        this.f1846n.setAnimationSpeed(sOptionPlay.getAnimationSpeed());
        this.f1846n.setPlayBGAudioOption(sOptionPlay.getPlayBGAudioOption());
        this.f1846n.setRepeatBGAudioOption(sOptionPlay.getRepeatBGAudioOption());
        this.f1846n.setStopBGAudioOption(sOptionPlay.getStopBGAudioOption());
        this.f1846n.setBGAudioVolume(sOptionPlay.getBGAudioVolume());
        this.f1846n.setSoundEffectOption(sOptionPlay.getSoundEffectOption());
        this.f1846n.setSoundEffectVolume(sOptionPlay.getSoundEffectVolume());
        return true;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public SOptionPlay mo1646a() {
        return this.f1846n;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public void mo1651a(boolean z) {
        if (z) {
            this.f1851s = 1;
        } else {
            mo1657a(true, true);
            this.f1851s = 0;
        }
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: b */
    public boolean mo1659b() {
        return this.f1851s != 0;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: c */
    public int mo1661c() {
        return this.f1851s;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public boolean mo1656a(boolean z, LinkedList<SObject> linkedList, String str) {
        if (!mo1659b()) {
            Log.e("AnimationManager", "Not Animation Mode");
            return false;
        }
        if (this.f1846n == null) {
            Log.e("AnimationManager", "doAnimationStart : mPlayOption is null");
            return false;
        }
        if (this.f1846n.getPlayBGAudioOption()) {
            this.f1832A.mo1681a(str, this.f1846n.getStopBGAudioOption(), this.f1846n.getBGAudioVolume(), this.f1846n.getRepeatBGAudioOption());
        }
        if (this.f1846n.getSoundEffectOption()) {
            this.f1832A.mo1684b();
        }
        if (this.f1833a == null) {
            this.f1833a = new Handler();
        }
        if (!m1655a(z, linkedList)) {
            Log.e("AnimationManager", "Initilize animation fail");
            return false;
        }
        m1658b(true);
        return mo1663d();
    }

    /* renamed from: a */
    boolean m1655a(boolean z, LinkedList<SObject> linkedList) {
        if (z) {
            this.f1857y.mo1667a();
        }
        this.f1835c = SystemClock.uptimeMillis();
        this.f1836d = this.f1835c;
        this.f1840h = 0;
        this.f1839g = 0;
        this.f1842j = 0;
        this.f1841i = linkedList;
        if (this.f1841i != null) {
            this.f1847o = this.f1841i.size();
        } else {
            this.f1847o = 0;
        }
        this.f1843k = m1643h();
        this.f1844l = 0;
        return m1645j();
    }

    /* renamed from: h */
    private int m1643h() {
        if (this.f1841i == null) {
            Log.w("AnimationManager", "There is no animation object list");
            return 0;
        }
        Iterator<SObject> it = this.f1841i.iterator();
        int pointNum = 0;
        while (it.hasNext()) {
            SObject next = it.next();
            if (next instanceof SObjectStroke) {
                pointNum = ((SObjectStroke) next).getPointNum() + pointNum;
            } else if (next instanceof SObjectText) {
                String text = ((SObjectText) next).getText();
                if (text != null && text.length() > 0) {
                    pointNum = (text.length() * 10) + pointNum;
                }
            } else {
                pointNum += 40;
            }
        }
        return pointNum;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: d */
    public boolean mo1663d() {
        if (!mo1659b()) {
            Log.e("AnimationManager", "Not Animation Mode");
            return false;
        }
        if (this.f1846n == null) {
            Log.e("AnimationManager", "mPlayOption is null");
            return false;
        }
        this.f1851s = 3;
        this.f1832A.mo1683a(this.f1846n.getPlayBGAudioOption(), this.f1846n.getSoundEffectOption(), this.f1846n.getStopBGAudioOption());
        this.f1833a.postDelayed(this, this.f1834b);
        return true;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: e */
    public boolean mo1664e() {
        if (!mo1659b()) {
            Log.e("AnimationManager", "Not Animation Mode");
            return false;
        }
        if (this.f1846n == null) {
            Log.e("AnimationManager", "mPlayOption is null");
            return false;
        }
        this.f1851s = 2;
        this.f1832A.mo1682a(this.f1846n.getStopBGAudioOption());
        return true;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public boolean mo1657a(boolean z, boolean z2) {
        if (!mo1659b()) {
            Log.e("AnimationManager", "Not Animation Mode");
            return false;
        }
        if (this.f1846n == null) {
            Log.e("AnimationManager", "mPlayOption is null");
            return false;
        }
        this.f1851s = 1;
        if (z2) {
            this.f1832A.mo1687b(this.f1846n.getStopBGAudioOption());
        }
        if ((this.f1839g != 0 || this.f1842j != 0) && z) {
            m1644i();
        }
        this.f1844l = this.f1843k;
        m1658b(true);
        this.f1839g = 0;
        this.f1842j = 0;
        if (this.f1856x == null) {
            Log.w("AnimationManager", "mAnimationCB is null");
        } else {
            this.f1856x.onPlayComplete();
        }
        return true;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: f */
    public void mo1665f() {
        if (this.f1833a != null) {
            this.f1833a = null;
        }
        this.f1832A.mo1677a();
        this.f1851s = 0;
    }

    /* renamed from: b */
    void m1658b(boolean z) {
        int i = (int) ((this.f1844l * 100) / this.f1843k);
        if (z) {
            if (this.f1856x != null) {
                this.f1856x.onChangeProgress(i);
            }
            this.f1840h = i;
        } else if (i != this.f1840h) {
            if (this.f1856x != null) {
                this.f1856x.onChangeProgress(this.f1840h);
            }
            this.f1840h = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x03e4  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean m1662c(boolean r20) {
        /*
            Method dump skipped, instructions count: 1536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.spen.p005a.p006a.RunnableC1071a.m1662c(boolean):boolean");
    }

    /* renamed from: i */
    private void m1644i() {
        while (m1642d(false)) {
            m1658b(false);
        }
        this.f1844l = this.f1843k;
        m1658b(true);
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public boolean mo1652a(int i) {
        if (i < 0 || i > 4) {
            return false;
        }
        if (this.f1846n == null) {
            Log.e("AnimationManager", "mPlayOption is null");
            return false;
        }
        this.f1846n.setAnimationSpeed(i);
        m1645j();
        return true;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: g */
    public int mo1666g() {
        if (this.f1846n != null) {
            return this.f1846n.getAnimationSpeed();
        }
        Log.e("AnimationManager", "mPlayOption is null");
        return -1;
    }

    /* renamed from: j */
    private boolean m1645j() {
        if (this.f1846n == null) {
            Log.e("AnimationManager", "mPlayOption is null");
            return false;
        }
        switch (this.f1846n.getAnimationSpeed()) {
            case 0:
                this.f1834b = 10;
                this.f1837e = 1;
                break;
            case 1:
                this.f1834b = 0;
                this.f1837e = 3;
                break;
            case 2:
                this.f1834b = 0;
                this.f1837e = 10;
                break;
            case 3:
                this.f1834b = 0;
                break;
            case 4:
                this.f1834b = 0;
                this.f1837e = this.f1843k / 200;
                break;
            default:
                this.f1834b = 0;
                this.f1837e = 1;
                break;
        }
        if (this.f1837e <= 0) {
            this.f1837e = 1;
        }
        this.f1838f = 0;
        return true;
    }

    /* renamed from: b */
    boolean m1660b(int i) {
        int i2 = this.f1847o;
        if (i2 == 0) {
            return true;
        }
        if (i < 0 || i >= i2) {
            Log.w("AnimationManager", "Invalid Drawing Object Index : " + i + "/" + i2);
            return false;
        }
        if (this.f1841i == null) {
            Log.w("AnimationManager", "There is no animation object list");
            return false;
        }
        if (this.f1857y == null) {
            Log.e("AnimationManager", "mDrawingCB is null");
            return false;
        }
        return this.f1857y.mo1669a(this.f1841i.get(i));
    }

    /* renamed from: a */
    boolean m1653a(int i, boolean z, String str) {
        int i2 = this.f1847o;
        if (i2 == 0) {
            return true;
        }
        if (i < 0 || i >= i2) {
            Log.w("AnimationManager", "Invalid Drawing Object Index : " + i + "/" + i2);
            return false;
        }
        if (this.f1841i == null) {
            Log.w("AnimationManager", "There is no animation object list");
            return false;
        }
        if (this.f1857y == null) {
            Log.e("AnimationManager", "mDrawingCB is null");
            return false;
        }
        SObject sObject = this.f1841i.get(i);
        if (!(sObject instanceof SObjectText)) {
            return false;
        }
        SObjectText sObjectText = (SObjectText) sObject;
        sObjectText.setText(str);
        if (z) {
            return this.f1857y.mo1669a(sObjectText);
        }
        return this.f1857y.mo1670b(sObjectText);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (mo1659b() && this.f1851s == 3) {
            if (m1642d(true)) {
                if (this.f1833a != null) {
                    this.f1833a.postDelayed(this, this.f1834b);
                    return;
                }
                return;
            }
            mo1657a(false, false);
        }
    }

    /* renamed from: d */
    private boolean m1642d(boolean z) {
        if (!m1662c(z)) {
            return false;
        }
        m1658b(false);
        return true;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public void mo1650a(AnimationProcessListener animationProcessListener) {
        this.f1856x = animationProcessListener;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public void mo1648a(InterfaceC1080c interfaceC1080c) {
        this.f1857y = interfaceC1080c;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public void mo1647a(InterfaceC1075c interfaceC1075c) {
        this.f1858z = interfaceC1075c;
    }

    @Override // com.samsung.spen.p005a.p006a.InterfaceC1072b
    /* renamed from: a */
    public void mo1649a(InterfaceC1092a interfaceC1092a) {
        this.f1832A = interfaceC1092a;
    }
}
