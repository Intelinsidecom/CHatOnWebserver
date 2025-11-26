package com.samsung.spen.p005a.p010e;

import android.content.Context;
import android.util.Log;
import com.samsung.samm.lib.engine.p004a.C0908a;
import com.samsung.samm.lib.engine.p004a.C0909b;
import com.samsung.samm.lib.p003a.C0888b;
import com.samsung.spensdk.applistener.CustomSoundEffectSettingListener;

/* renamed from: com.samsung.spen.a.e.b */
/* loaded from: classes.dex */
public class C1093b implements InterfaceC1092a {

    /* renamed from: a */
    private Context f1964a;

    /* renamed from: b */
    private C0908a f1965b = null;

    /* renamed from: c */
    private C0909b f1966c = null;

    /* renamed from: d */
    private C0909b f1967d = null;

    /* renamed from: e */
    private C0909b f1968e = null;

    /* renamed from: f */
    private C0909b f1969f = null;

    /* renamed from: g */
    private C0909b f1970g = null;

    /* renamed from: h */
    private C0909b f1971h = null;

    /* renamed from: i */
    private C0909b f1972i = null;

    /* renamed from: j */
    private C0909b f1973j = null;

    /* renamed from: k */
    private C0909b f1974k = null;

    /* renamed from: l */
    private C0909b f1975l = null;

    /* renamed from: m */
    private C0909b f1976m = null;

    /* renamed from: n */
    private C0909b f1977n = null;

    /* renamed from: o */
    private C0909b f1978o = null;

    /* renamed from: p */
    private C0909b f1979p = null;

    /* renamed from: q */
    private C0909b f1980q = null;

    /* renamed from: r */
    private C0909b f1981r = null;

    /* renamed from: s */
    private C0909b f1982s = null;

    /* renamed from: t */
    private C0909b f1983t = null;

    /* renamed from: u */
    private C0909b f1984u = null;

    /* renamed from: v */
    private CustomSoundEffectSettingListener f1985v = null;

    public C1093b(Context context) {
        this.f1964a = null;
        this.f1964a = context;
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: b */
    public boolean mo1684b() {
        return m1870f();
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public boolean mo1677a() {
        return m1873g();
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public boolean mo1681a(String str, boolean z, float f, boolean z2) {
        if (str != null) {
            return m1862b(str, z, f, z2);
        }
        return false;
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public boolean mo1683a(boolean z, boolean z2, boolean z3) {
        return m1863b(z, z2, z3);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public boolean mo1682a(boolean z) {
        return m1864c(z);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: b */
    public boolean mo1687b(boolean z) {
        return m1867d(z);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public boolean mo1680a(int i, float f) {
        return m1866d(i, f);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: b */
    public boolean mo1686b(int i, float f) {
        return m1869e(i, f);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: c */
    public boolean mo1690c(int i, float f) {
        return m1872f(i, f);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public boolean mo1678a(float f) {
        return m1865d(f);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: b */
    public boolean mo1685b(float f) {
        return m1868e(f);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: c */
    public boolean mo1689c(float f) {
        return m1871f(f);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public boolean mo1679a(int i) {
        return m1861b(i);
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: c */
    public boolean mo1688c() {
        return m1874h();
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: d */
    public boolean mo1691d() {
        return m1875i();
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: e */
    public boolean mo1692e() {
        return m1876j();
    }

    /* renamed from: f */
    public boolean m1870f() {
        String strOnLoadCustomSoundEffect;
        String strOnLoadCustomSoundEffect2;
        String strOnLoadCustomSoundEffect3;
        String strOnLoadCustomSoundEffect4;
        String strOnLoadCustomSoundEffect5;
        String strOnLoadCustomSoundEffect6;
        String strOnLoadCustomSoundEffect7;
        String strOnLoadCustomSoundEffect8;
        if (this.f1966c == null) {
            this.f1966c = new C0909b();
            if (!m1860a(this.f1966c, "assets/samm_embeded_soundeffect/pen_click.ogg", 10)) {
                return false;
            }
        }
        if (this.f1967d == null) {
            this.f1967d = new C0909b();
            if (!m1860a(this.f1967d, "assets/samm_embeded_soundeffect/crayon_click.ogg", 20)) {
                return false;
            }
        }
        if (this.f1968e == null && this.f1985v != null && (strOnLoadCustomSoundEffect8 = this.f1985v.onLoadCustomSoundEffect(30)) != null) {
            this.f1968e = new C0909b();
            if (!this.f1968e.m651a(strOnLoadCustomSoundEffect8)) {
                return false;
            }
        }
        if (this.f1969f == null && this.f1985v != null && (strOnLoadCustomSoundEffect7 = this.f1985v.onLoadCustomSoundEffect(40)) != null) {
            this.f1969f = new C0909b();
            if (!this.f1969f.m651a(strOnLoadCustomSoundEffect7)) {
                return false;
            }
        }
        if (this.f1970g == null && this.f1985v != null && (strOnLoadCustomSoundEffect6 = this.f1985v.onLoadCustomSoundEffect(50)) != null) {
            this.f1970g = new C0909b();
            if (!this.f1970g.m651a(strOnLoadCustomSoundEffect6)) {
                return false;
            }
        }
        if (this.f1971h == null) {
            this.f1971h = new C0909b();
            if (!m1860a(this.f1971h, "assets/samm_embeded_soundeffect/pen_draw.ogg", 11)) {
                return false;
            }
        }
        if (this.f1972i == null) {
            this.f1972i = new C0909b();
            if (!m1860a(this.f1972i, "assets/samm_embeded_soundeffect/crayon_draw.ogg", 21)) {
                return false;
            }
        }
        if (this.f1973j == null) {
            this.f1973j = new C0909b();
            if (!m1860a(this.f1973j, "assets/samm_embeded_soundeffect/shiny_draw.ogg", 31)) {
                return false;
            }
        }
        if (this.f1974k == null) {
            this.f1974k = new C0909b();
            if (!m1860a(this.f1974k, "assets/samm_embeded_soundeffect/brush_draw.ogg", 41)) {
                return false;
            }
        }
        if (this.f1975l == null) {
            this.f1975l = new C0909b();
            if (!m1860a(this.f1975l, "assets/samm_embeded_soundeffect/chinese_brush_draw.ogg", 51)) {
                return false;
            }
        }
        if (this.f1976m == null && this.f1985v != null && (strOnLoadCustomSoundEffect5 = this.f1985v.onLoadCustomSoundEffect(12)) != null) {
            this.f1976m = new C0909b();
            if (!this.f1976m.m651a(strOnLoadCustomSoundEffect5)) {
                return false;
            }
        }
        if (this.f1977n == null && this.f1985v != null && (strOnLoadCustomSoundEffect4 = this.f1985v.onLoadCustomSoundEffect(22)) != null) {
            this.f1977n = new C0909b();
            if (!this.f1977n.m651a(strOnLoadCustomSoundEffect4)) {
                return false;
            }
        }
        if (this.f1978o == null && this.f1985v != null && (strOnLoadCustomSoundEffect3 = this.f1985v.onLoadCustomSoundEffect(32)) != null) {
            this.f1978o = new C0909b();
            if (!this.f1978o.m651a(strOnLoadCustomSoundEffect3)) {
                return false;
            }
        }
        if (this.f1979p == null && this.f1985v != null && (strOnLoadCustomSoundEffect2 = this.f1985v.onLoadCustomSoundEffect(42)) != null) {
            this.f1979p = new C0909b();
            if (!this.f1979p.m651a(strOnLoadCustomSoundEffect2)) {
                return false;
            }
        }
        if (this.f1980q == null && this.f1985v != null && (strOnLoadCustomSoundEffect = this.f1985v.onLoadCustomSoundEffect(52)) != null) {
            this.f1980q = new C0909b();
            if (!this.f1980q.m651a(strOnLoadCustomSoundEffect)) {
                return false;
            }
        }
        if (this.f1981r == null) {
            this.f1981r = new C0909b();
            if (!m1860a(this.f1981r, "assets/samm_embeded_soundeffect/eraser_draw.ogg", 100)) {
                return false;
            }
        }
        if (this.f1982s == null) {
            this.f1982s = new C0909b();
            if (!m1860a(this.f1982s, "assets/samm_embeded_soundeffect/image_insert.ogg", 200)) {
                return false;
            }
        }
        if (this.f1983t == null) {
            this.f1983t = new C0909b();
            if (!m1860a(this.f1983t, "assets/samm_embeded_soundeffect/text_type_char1.ogg", 300)) {
                return false;
            }
        }
        if (this.f1984u == null) {
            this.f1984u = new C0909b();
            if (!m1860a(this.f1984u, "assets/samm_embeded_soundeffect/color_filling.ogg", 400)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    boolean m1860a(C0909b c0909b, String str, int i) {
        if (this.f1985v == null) {
            if (!c0909b.m650a(this.f1964a, str, i)) {
                return false;
            }
        } else {
            String strOnLoadCustomSoundEffect = this.f1985v.onLoadCustomSoundEffect(i);
            if (strOnLoadCustomSoundEffect != null) {
                if (!c0909b.m651a(strOnLoadCustomSoundEffect)) {
                    return false;
                }
            } else if (!c0909b.m650a(this.f1964a, str, i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m1862b(String str, boolean z, float f, boolean z2) throws IllegalStateException {
        int iM250b = C0888b.m250b(str);
        if (iM250b != 1) {
            if (iM250b < 2 || iM250b > 11) {
                return false;
            }
            if (z) {
                if (this.f1965b != null) {
                    this.f1965b.m644b();
                    this.f1965b.m642a();
                    this.f1965b = null;
                }
                this.f1965b = new C0908a();
                if (this.f1965b == null) {
                    Log.e("EffectManager", "Fail to create mAudioPlayer");
                    return false;
                }
                if (!this.f1965b.m643a(str, f, z2)) {
                    return false;
                }
            } else if (this.f1965b != null) {
                if (!this.f1965b.m647e() && !this.f1965b.m643a(str, f, z2)) {
                    return false;
                }
            } else {
                this.f1965b = new C0908a();
                if (this.f1965b == null) {
                    Log.e("EffectManager", "Fail to create mAudioPlayer");
                    return false;
                }
                if (!this.f1965b.m643a(str, f, z2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m1863b(boolean z, boolean z2, boolean z3) throws IllegalStateException {
        if (this.f1965b != null && z && z3) {
            this.f1965b.m646d();
        }
        if (z2) {
            if (this.f1971h != null) {
                this.f1971h.m655d();
            }
            if (this.f1972i != null) {
                this.f1972i.m655d();
            }
            if (this.f1973j != null) {
                this.f1973j.m655d();
            }
            if (this.f1974k != null) {
                this.f1974k.m655d();
            }
            if (this.f1975l != null) {
                this.f1975l.m655d();
            }
            if (this.f1981r != null) {
                this.f1981r.m655d();
            }
            if (this.f1982s != null) {
                this.f1982s.m655d();
            }
            if (this.f1983t != null) {
                this.f1983t.m655d();
            }
            if (this.f1984u != null) {
                this.f1984u.m655d();
                return true;
            }
            return true;
        }
        return true;
    }

    /* renamed from: c */
    public boolean m1864c(boolean z) throws IllegalStateException {
        if (this.f1965b != null && z) {
            this.f1965b.m645c();
        }
        if (this.f1971h != null) {
            this.f1971h.m654c();
        }
        if (this.f1972i != null) {
            this.f1972i.m654c();
        }
        if (this.f1973j != null) {
            this.f1973j.m654c();
        }
        if (this.f1974k != null) {
            this.f1974k.m654c();
        }
        if (this.f1975l != null) {
            this.f1975l.m654c();
        }
        if (this.f1981r != null) {
            this.f1981r.m654c();
        }
        if (this.f1982s != null) {
            this.f1982s.m654c();
        }
        if (this.f1983t != null) {
            this.f1983t.m654c();
        }
        if (this.f1984u != null) {
            this.f1984u.m654c();
            return true;
        }
        return true;
    }

    /* renamed from: d */
    public boolean m1867d(boolean z) throws IllegalStateException {
        if (this.f1965b != null && z) {
            this.f1965b.m644b();
        }
        if (this.f1971h != null) {
            this.f1971h.m653b();
        }
        if (this.f1972i != null) {
            this.f1972i.m653b();
        }
        if (this.f1973j != null) {
            this.f1973j.m653b();
        }
        if (this.f1974k != null) {
            this.f1974k.m653b();
        }
        if (this.f1975l != null) {
            this.f1975l.m653b();
        }
        if (this.f1981r != null) {
            this.f1981r.m653b();
        }
        if (this.f1982s != null) {
            this.f1982s.m653b();
        }
        if (this.f1983t != null) {
            this.f1983t.m653b();
        }
        if (this.f1984u != null) {
            this.f1984u.m653b();
            return true;
        }
        return true;
    }

    /* renamed from: g */
    public boolean m1873g() throws IllegalStateException {
        if (this.f1965b != null) {
            this.f1965b.m644b();
            this.f1965b.m642a();
            this.f1965b = null;
        }
        if (this.f1966c != null) {
            this.f1966c.m653b();
            this.f1966c.m649a();
            this.f1966c = null;
        }
        if (this.f1967d != null) {
            this.f1967d.m653b();
            this.f1967d.m649a();
            this.f1967d = null;
        }
        if (this.f1968e != null) {
            this.f1968e.m653b();
            this.f1968e.m649a();
            this.f1968e = null;
        }
        if (this.f1969f != null) {
            this.f1969f.m653b();
            this.f1969f.m649a();
            this.f1969f = null;
        }
        if (this.f1970g != null) {
            this.f1970g.m653b();
            this.f1970g.m649a();
            this.f1970g = null;
        }
        if (this.f1971h != null) {
            this.f1971h.m653b();
            this.f1971h.m649a();
            this.f1971h = null;
        }
        if (this.f1972i != null) {
            this.f1972i.m653b();
            this.f1972i.m649a();
            this.f1972i = null;
        }
        if (this.f1973j != null) {
            this.f1973j.m653b();
            this.f1973j.m649a();
            this.f1973j = null;
        }
        if (this.f1974k != null) {
            this.f1974k.m653b();
            this.f1974k.m649a();
            this.f1974k = null;
        }
        if (this.f1975l != null) {
            this.f1975l.m653b();
            this.f1975l.m649a();
            this.f1975l = null;
        }
        if (this.f1976m != null) {
            this.f1976m.m653b();
            this.f1976m.m649a();
            this.f1976m = null;
        }
        if (this.f1977n != null) {
            this.f1977n.m653b();
            this.f1977n.m649a();
            this.f1977n = null;
        }
        if (this.f1978o != null) {
            this.f1978o.m653b();
            this.f1978o.m649a();
            this.f1978o = null;
        }
        if (this.f1979p != null) {
            this.f1979p.m653b();
            this.f1979p.m649a();
            this.f1979p = null;
        }
        if (this.f1980q != null) {
            this.f1980q.m653b();
            this.f1980q.m649a();
            this.f1980q = null;
        }
        if (this.f1981r != null) {
            this.f1981r.m653b();
            this.f1981r.m649a();
            this.f1981r = null;
        }
        if (this.f1982s != null) {
            this.f1982s.m653b();
            this.f1982s.m649a();
            this.f1982s = null;
        }
        if (this.f1983t != null) {
            this.f1983t.m653b();
            this.f1983t.m649a();
            this.f1983t = null;
        }
        if (this.f1984u != null) {
            this.f1984u.m653b();
            this.f1984u.m649a();
            this.f1984u = null;
            return true;
        }
        return true;
    }

    /* renamed from: d */
    public boolean m1866d(int i, float f) {
        if (i == 0) {
            if (this.f1966c != null) {
                this.f1966c.m652a(false, f, 1.0f);
            }
        } else if (i == 1) {
            if (this.f1967d != null) {
                this.f1967d.m652a(false, f, 1.0f);
            }
        } else if (i == 2) {
            if (this.f1968e != null) {
                this.f1968e.m652a(false, f, 1.0f);
            }
        } else if (i != 4) {
            if (i == 6) {
                if (this.f1969f != null) {
                    this.f1969f.m652a(false, f, 1.0f);
                }
            } else if (i == 7 && this.f1970g != null) {
                this.f1970g.m652a(false, f, 1.0f);
            }
        }
        return true;
    }

    /* renamed from: e */
    public boolean m1869e(int i, float f) {
        if (i == 0) {
            if (this.f1971h != null) {
                this.f1971h.m652a(true, f, 1.0f);
            }
        } else if (i == 1) {
            if (this.f1972i != null) {
                this.f1972i.m652a(true, f, 1.0f);
            }
        } else if (i == 2) {
            if (this.f1973j != null) {
                this.f1973j.m652a(true, f, 1.0f);
            }
        } else if (i == 4) {
            if (this.f1981r != null) {
                this.f1981r.m652a(true, f, 1.0f);
            }
        } else if (i == 6) {
            if (this.f1974k != null) {
                this.f1974k.m652a(true, f, 1.0f);
            }
        } else if (i == 7 && this.f1975l != null) {
            this.f1975l.m652a(true, f, 1.0f);
        }
        return true;
    }

    /* renamed from: f */
    public boolean m1872f(int i, float f) {
        if (i == 0) {
            if (this.f1976m != null) {
                this.f1976m.m652a(false, f, 1.0f);
            }
        } else if (i == 1) {
            if (this.f1977n != null) {
                this.f1977n.m652a(false, f, 1.0f);
            }
        } else if (i == 2) {
            if (this.f1978o != null) {
                this.f1978o.m652a(false, f, 1.0f);
            }
        } else if (i != 4) {
            if (i == 6) {
                if (this.f1979p != null) {
                    this.f1979p.m652a(false, f, 1.0f);
                }
            } else if (i == 7 && this.f1980q != null) {
                this.f1980q.m652a(false, f, 1.0f);
            }
        }
        return true;
    }

    /* renamed from: d */
    public boolean m1865d(float f) {
        if (this.f1982s != null) {
            this.f1982s.m652a(false, f, 1.0f);
            return true;
        }
        return true;
    }

    /* renamed from: e */
    public boolean m1868e(float f) {
        if (this.f1983t != null) {
            this.f1983t.m652a(false, f, 1.0f);
            return true;
        }
        return true;
    }

    /* renamed from: f */
    public boolean m1871f(float f) {
        if (this.f1984u != null) {
            this.f1984u.m652a(false, f, 1.0f);
            return true;
        }
        return true;
    }

    /* renamed from: b */
    public boolean m1861b(int i) {
        if (i == 0) {
            if (this.f1971h != null) {
                this.f1971h.m653b();
            }
        } else if (i == 1) {
            if (this.f1972i != null) {
                this.f1972i.m653b();
            }
        } else if (i == 2) {
            if (this.f1973j != null) {
                this.f1973j.m653b();
            }
        } else if (i == 4) {
            if (this.f1981r != null) {
                this.f1981r.m653b();
            }
        } else if (i == 6) {
            if (this.f1974k != null) {
                this.f1974k.m653b();
            }
        } else if (i == 7 && this.f1975l != null) {
            this.f1975l.m653b();
        }
        return true;
    }

    /* renamed from: h */
    public boolean m1874h() {
        if (this.f1982s != null) {
            this.f1982s.m653b();
            return true;
        }
        return true;
    }

    /* renamed from: i */
    public boolean m1875i() {
        if (this.f1983t != null) {
            this.f1983t.m653b();
            return true;
        }
        return true;
    }

    /* renamed from: j */
    public boolean m1876j() {
        if (this.f1984u != null) {
            this.f1984u.m653b();
            return true;
        }
        return true;
    }

    @Override // com.samsung.spen.p005a.p010e.InterfaceC1092a
    /* renamed from: a */
    public void mo1676a(CustomSoundEffectSettingListener customSoundEffectSettingListener) {
        this.f1985v = customSoundEffectSettingListener;
    }
}
