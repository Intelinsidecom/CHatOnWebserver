package com.samsung.sdraw;

import java.util.ArrayList;

/* loaded from: classes.dex */
class PresetDataManager {

    /* renamed from: d */
    private SharedPreferencesManager f1133d;

    /* renamed from: b */
    private ArrayList<C1005ar> f1131b = new ArrayList<>();

    /* renamed from: c */
    private ArrayList<Integer> f1132c = new ArrayList<>();

    /* renamed from: e */
    private boolean f1134e = false;

    /* renamed from: f */
    private int f1135f = -1;

    /* renamed from: a */
    NotifyListener f1130a = null;

    public interface NotifyListener {
        void dataChanged(int i);
    }

    PresetDataManager() {
    }

    /* renamed from: a */
    public void m1039a(SharedPreferencesManager sharedPreferencesManager) {
        this.f1133d = sharedPreferencesManager;
    }

    /* renamed from: a */
    public void m1040a(C1005ar c1005ar) {
        if (this.f1131b != null && c1005ar != null && this.f1131b.size() < 12) {
            c1005ar.m1380a(m1035h());
            m1033a(0, c1005ar);
            this.f1133d.m1126a(c1005ar.m1393i(), c1005ar.m1384c(), m1037a());
            if (this.f1130a != null) {
                this.f1130a.dataChanged(this.f1131b.size());
            }
        }
    }

    /* renamed from: b */
    public boolean m1044b(C1005ar c1005ar) {
        return this.f1131b.contains(c1005ar);
    }

    /* renamed from: a */
    protected String m1037a() {
        StringBuilder sb = new StringBuilder();
        if (this.f1132c == null) {
            return sb.toString();
        }
        for (int i = 0; i < this.f1132c.size(); i++) {
            sb.append(this.f1132c.get(i));
            if (i != this.f1132c.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* renamed from: h */
    private int m1035h() {
        if (this.f1132c == null || this.f1132c.isEmpty()) {
            return 0;
        }
        return this.f1132c.get(0).intValue() + 1;
    }

    /* renamed from: a */
    public C1005ar m1036a(int i) {
        if (i < 0 || i >= this.f1131b.size()) {
            return null;
        }
        return this.f1131b.get(i);
    }

    /* renamed from: b */
    public void m1043b(int i) {
        if (i >= 0 && i < this.f1131b.size()) {
            C1005ar c1005arRemove = this.f1131b.remove(i);
            if (i < this.f1135f || this.f1135f >= m1047d()) {
                this.f1135f--;
            }
            if (this.f1132c.contains(Integer.valueOf(c1005arRemove.m1384c()))) {
                this.f1132c.remove(Integer.valueOf(c1005arRemove.m1384c()));
            }
            m1034d(c1005arRemove.m1384c());
            c1005arRemove.m1379a();
            if (this.f1130a != null) {
                this.f1130a.dataChanged(this.f1131b.size());
            }
        }
    }

    /* renamed from: d */
    private void m1034d(int i) {
        this.f1133d.m1125a(i);
        this.f1133d.m1127a(m1037a());
    }

    /* renamed from: b */
    public ArrayList<C1005ar> m1042b() {
        return this.f1131b;
    }

    /* renamed from: c */
    public void m1045c() {
        C1005ar[] c1005arArrM1128a = this.f1133d.m1128a();
        if (c1005arArrM1128a != null) {
            for (int i = 0; i < c1005arArrM1128a.length; i++) {
                m1033a(i, c1005arArrM1128a[i]);
            }
        }
    }

    /* renamed from: a */
    private void m1033a(int i, C1005ar c1005ar) {
        if (c1005ar != null && this.f1131b != null) {
            if (!this.f1131b.contains(c1005ar)) {
                this.f1131b.add(i, c1005ar);
            }
            if (!this.f1132c.contains(Integer.valueOf(c1005ar.m1384c()))) {
                this.f1132c.add(i, Integer.valueOf(c1005ar.m1384c()));
            }
        }
    }

    /* renamed from: a */
    public void m1038a(NotifyListener notifyListener) {
        this.f1130a = notifyListener;
    }

    /* renamed from: d */
    public int m1047d() {
        return this.f1131b.size();
    }

    /* renamed from: c */
    public void m1046c(int i) {
        if (i < m1047d() && i >= 0) {
            this.f1135f = i;
        }
    }

    /* renamed from: e */
    public void m1048e() {
        this.f1135f = -1;
    }

    /* renamed from: f */
    public boolean m1049f() {
        return this.f1135f + 1 < m1047d();
    }

    /* renamed from: g */
    public C1005ar m1050g() {
        this.f1135f++;
        if (this.f1135f >= m1047d()) {
            this.f1135f = 0;
        }
        return m1036a(this.f1135f);
    }

    /* renamed from: a */
    public boolean m1041a(PenSettingInfo penSettingInfo, boolean z) {
        int i = 0;
        while (i < this.f1131b.size()) {
            C1005ar c1005ar = this.f1131b.get(i);
            if (penSettingInfo.getPenType() == c1005ar.m1390f() && penSettingInfo.getPenColor() == c1005ar.m1391g() && penSettingInfo.getPenAlpha() == c1005ar.m1388e() && penSettingInfo.getPenWidth() == c1005ar.m1386d()) {
                break;
            }
            i++;
        }
        if (i == this.f1131b.size()) {
            if (!z) {
                return false;
            }
            this.f1135f = 0;
            return false;
        }
        if (z) {
            this.f1135f = i;
        }
        return true;
    }
}
