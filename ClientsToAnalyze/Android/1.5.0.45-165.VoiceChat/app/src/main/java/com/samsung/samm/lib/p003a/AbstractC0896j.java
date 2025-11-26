package com.samsung.samm.lib.p003a;

import android.graphics.RectF;
import android.util.Log;
import com.google.protobuf.CodedOutputStream;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectFilling;
import com.samsung.samm.common.SObjectImage;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.samm.lib.a.j */
/* loaded from: classes.dex */
public abstract class AbstractC0896j {

    /* renamed from: a */
    protected int f603a;

    /* renamed from: b */
    protected int f604b;

    /* renamed from: c */
    protected int f605c;

    /* renamed from: d */
    protected SObject f606d = null;

    /* renamed from: e */
    protected AbstractC0896j f607e = null;

    /* renamed from: f */
    private int f608f = 0;

    /* renamed from: g */
    private SObject f609g = null;

    /* renamed from: h */
    private int f610h = 0;

    /* renamed from: i */
    private int f611i = 0;

    /* renamed from: j */
    private C0891e f612j;

    /* renamed from: a */
    public abstract int mo519a(byte[] bArr, int i);

    /* renamed from: a */
    public abstract byte[] mo525a(int i, int i2);

    /* renamed from: g */
    public abstract int mo534g();

    public AbstractC0896j() {
        this.f612j = null;
        this.f612j = new C0891e();
    }

    /* renamed from: a */
    protected void mo521a() {
        m522a(this.f603a);
        m528b(this.f606d.getStyle());
        m511b(this.f606d.getSize());
        m515e(this.f606d.getColor());
        m530c(this.f604b);
        m516f(this.f605c);
        m524a(this.f606d.getRect());
        m508a(this.f606d.getRotateAngle());
        m510a(this.f606d.getDescription());
        m513b(this.f606d.getHyperText());
        m512b(this.f606d.getLatitude(), this.f606d.getLongitude());
        m509a((C0891e) this.f606d.getObjectData());
    }

    /* renamed from: a */
    protected void m522a(int i) {
        int i2 = i & 255;
        if (this.f609g == null || (this.f607e.f603a & 255) != i2) {
            this.f610h |= 1;
        } else {
            this.f610h &= -2;
        }
        this.f603a = i2;
    }

    /* renamed from: b */
    protected void m528b(int i) {
        int i2 = i & 255;
        if (this.f609g == null) {
            this.f610h |= 2;
        } else if ((this.f609g.getStyle() & 255) != i2) {
            this.f610h |= 2;
        } else {
            this.f610h &= -3;
        }
    }

    /* renamed from: d */
    private void m514d(int i) {
        int i2 = i & 255;
        if (this.f609g == null) {
            this.f610h |= 4;
        } else if ((((int) this.f609g.getSize()) & 255) != i2) {
            this.f610h |= 4;
        } else {
            this.f610h &= -5;
        }
    }

    /* renamed from: e */
    private void m515e(int i) {
        if (this.f609g == null) {
            this.f610h |= 8;
        } else if (this.f609g.getColor() != i) {
            this.f610h |= 8;
        } else {
            this.f610h &= -9;
        }
    }

    /* renamed from: c */
    protected void m530c(int i) {
        int i2 = i & 255;
        if (this.f609g == null || (this.f607e.f604b & 255) != i2) {
            this.f610h |= 512;
        } else {
            this.f610h &= -513;
        }
        this.f604b = i2;
    }

    /* renamed from: f */
    private void m516f(int i) {
        int i2 = i & 255;
        if (this.f609g == null || (this.f607e.f605c & 255) != i2) {
            this.f610h |= 1024;
        } else {
            this.f610h &= -1025;
        }
        this.f605c = i2;
    }

    /* renamed from: a */
    protected boolean m524a(RectF rectF) {
        if (rectF == null) {
            return false;
        }
        int i = ((int) rectF.left) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        int i2 = ((int) rectF.top) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        int i3 = ((int) rectF.right) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        int i4 = ((int) rectF.bottom) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        if (this.f609g == null || (((int) this.f609g.getRect().left) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) != i || (((int) this.f609g.getRect().right) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) != i3 || (((int) this.f609g.getRect().top) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) != i2 || (((int) this.f609g.getRect().bottom) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) != i4) {
            this.f610h |= 2048;
        } else {
            this.f610h &= -2049;
        }
        return true;
    }

    /* renamed from: a */
    private void m508a(float f) {
        float f2 = f - (((int) (f / 360.0f)) * 360);
        if (f2 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            f2 += 360.0f;
        }
        int i = ((int) (f2 * 100.0f)) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT;
        if (this.f609g == null) {
            this.f610h |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
            return;
        }
        float rotateAngle = this.f609g.getRotateAngle() - (((int) (r0 / 360.0f)) * 360);
        if (rotateAngle < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            rotateAngle += 360.0f;
        }
        if ((((int) (rotateAngle * 100.0f)) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) != i) {
            this.f610h |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        } else {
            this.f610h &= -4097;
        }
    }

    /* renamed from: b */
    private void m511b(float f) {
        int i = (int) f;
        m514d(i);
        if (this.f609g == null) {
            this.f610h |= 8192;
            return;
        }
        if ((((int) ((this.f609g.getSize() - ((int) r1)) * 10000.0f)) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) != (((int) ((f - i) * 10000.0f)) & InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT)) {
            this.f610h |= 8192;
        } else {
            this.f610h &= -8193;
        }
    }

    /* renamed from: a */
    private void m510a(String str) {
        if (this.f609g == null) {
            this.f610h |= 16384;
            return;
        }
        String description = this.f609g.getDescription();
        if (description != null) {
            if (!description.equals(str)) {
                this.f610h |= 16384;
                return;
            } else {
                this.f610h &= -16385;
                return;
            }
        }
        if (str != null) {
            this.f610h |= 16384;
        } else {
            this.f610h &= -16385;
        }
    }

    /* renamed from: b */
    private void m513b(String str) {
        if (this.f609g == null) {
            this.f610h |= 32768;
            return;
        }
        String hyperText = this.f609g.getHyperText();
        if (hyperText != null) {
            if (!hyperText.equals(str)) {
                this.f610h |= 32768;
                return;
            } else {
                this.f610h &= -32769;
                return;
            }
        }
        if (str != null) {
            this.f610h |= 32768;
        } else {
            this.f610h &= -32769;
        }
    }

    /* renamed from: b */
    private void m512b(int i, int i2) {
        if (this.f609g == null) {
            this.f610h |= 65536;
        } else if (this.f609g.getLatitude() != i || this.f609g.getLongitude() != i2) {
            this.f610h |= 65536;
        } else {
            this.f610h &= -65537;
        }
    }

    /* renamed from: a */
    private void m509a(C0891e c0891e) {
        this.f612j = null;
        if (c0891e != null) {
            if (c0891e.m402b() > 0) {
                this.f610h |= 131072;
                this.f612j = c0891e;
                this.f611i = this.f612j.m411c();
                return;
            } else {
                this.f610h &= -131073;
                this.f611i = 0;
                return;
            }
        }
        this.f610h &= -131073;
        this.f611i = 0;
    }

    /* renamed from: b */
    protected int m526b() {
        return this.f603a;
    }

    /* renamed from: c */
    protected int m529c() {
        return this.f604b;
    }

    /* renamed from: d */
    protected int m531d() {
        return this.f605c;
    }

    /* renamed from: a */
    protected void m523a(AbstractC0896j abstractC0896j) {
        this.f607e = abstractC0896j;
        if (abstractC0896j != null) {
            this.f609g = abstractC0896j.f606d;
        } else {
            this.f609g = null;
        }
    }

    /* renamed from: e */
    public int m532e() {
        return m533f() + mo534g();
    }

    /* renamed from: f */
    public int m533f() {
        int iM517h = (this.f610h & 1) != 0 ? 1 : 0;
        if ((this.f610h & 2) != 0) {
            iM517h++;
        }
        if ((this.f610h & 4) != 0) {
            iM517h++;
        }
        if ((this.f610h & 8) != 0) {
            iM517h += 4;
        }
        if ((this.f610h & 16) != 0) {
            iM517h++;
        }
        if ((this.f610h & 32) != 0) {
            iM517h++;
        }
        if ((this.f610h & 64) != 0) {
            iM517h++;
        }
        if ((this.f610h & 128) != 0) {
            iM517h += 2;
        }
        if ((this.f610h & 256) != 0) {
            iM517h++;
        }
        if ((this.f610h & 512) != 0) {
            iM517h++;
        }
        if ((this.f610h & 1024) != 0) {
            iM517h++;
        }
        if ((this.f610h & 2048) != 0) {
            iM517h += 8;
        }
        if ((this.f610h & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0) {
            iM517h += 2;
        }
        if ((this.f610h & 8192) != 0) {
            iM517h += 2;
        }
        if ((this.f610h & 16384) != 0) {
            iM517h = iM517h + 2 + (m518i() * 2);
        }
        if ((this.f610h & 32768) != 0) {
            iM517h = iM517h + 2 + (m517h() * 2);
        }
        if ((this.f610h & 65536) != 0) {
            iM517h += 8;
        }
        if ((this.f610h & 131072) != 0) {
            iM517h += this.f611i;
        }
        this.f608f = iM517h + 4 + 4;
        return this.f608f;
    }

    /* renamed from: h */
    private int m517h() {
        String hyperText = this.f606d.getHyperText();
        if (hyperText != null) {
            return hyperText.length();
        }
        return 0;
    }

    /* renamed from: i */
    private int m518i() {
        String description = this.f606d.getDescription();
        if (description != null) {
            return description.length();
        }
        return 0;
    }

    /* renamed from: b */
    public int m527b(byte[] bArr, int i) {
        int iM581a;
        int iM593b;
        String str;
        String str2 = null;
        int[] iArr = new int[1];
        if (this.f609g != null) {
            int style = this.f609g.getStyle();
            if (this.f606d instanceof SObjectStroke) {
                ((SObjectStroke) this.f606d).setStyle(style);
            } else if (this.f606d instanceof SObjectImage) {
                ((SObjectImage) this.f606d).setStyle(style);
            } else if (this.f606d instanceof SObjectText) {
                ((SObjectText) this.f606d).setStyle(style);
            } else if (this.f606d instanceof SObjectFilling) {
                ((SObjectFilling) this.f606d).setStyle(style);
            } else {
                Log.e("SAMMLibraryCore", "Unknown SAMM Object");
                return -1;
            }
            this.f606d.setSize(this.f609g.getSize());
            this.f606d.setColor(this.f609g.getColor());
            this.f606d.setRect(this.f609g.getRect());
            this.f606d.setRotateAngle(this.f609g.getRotateAngle());
            this.f606d.setHyperText(this.f609g.getHyperText());
            this.f606d.setDescription(this.f609g.getDescription());
            this.f606d.setLatitude(this.f609g.getLatitude());
            this.f606d.setLongitude(this.f609g.getLongitude());
            this.f604b = this.f607e.m529c();
            this.f605c = this.f607e.m531d();
        }
        int iM581a2 = C0903q.m581a(bArr, i, iArr);
        int i2 = iArr[0];
        if (i2 == 0) {
            return iM581a2 - i;
        }
        if (i2 < 0) {
            Log.e("SAMMLibraryCore", "SAMM Object Data is Invalid");
            return -1;
        }
        int i3 = iM581a2 + i2;
        int iM581a3 = C0903q.m581a(bArr, iM581a2, iArr);
        this.f610h = iArr[0];
        if ((this.f610h & 1) != 0) {
            iM581a = iM581a3 + 1;
            this.f603a = bArr[iM581a3] & 255;
        } else {
            iM581a = iM581a3;
        }
        if ((this.f610h & 2) != 0) {
            int i4 = iM581a + 1;
            int i5 = bArr[iM581a] & 255;
            if (this.f606d instanceof SObjectStroke) {
                ((SObjectStroke) this.f606d).setStyle(i5);
                iM581a = i4;
            } else if (this.f606d instanceof SObjectImage) {
                ((SObjectImage) this.f606d).setStyle(i5);
                iM581a = i4;
            } else if (this.f606d instanceof SObjectText) {
                ((SObjectText) this.f606d).setStyle(i5);
                iM581a = i4;
            } else if (this.f606d instanceof SObjectFilling) {
                ((SObjectFilling) this.f606d).setStyle(i5);
                iM581a = i4;
            } else {
                Log.e("SAMMLibraryCore", "Unknown SAMM Object");
                return -1;
            }
        }
        if ((this.f610h & 4) != 0) {
            this.f606d.setSize(bArr[iM581a] & 255);
            iM581a++;
        }
        if ((this.f610h & 8) != 0) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < 4) {
                i7 = (i7 << 8) + (bArr[iM581a] & 255);
                i6++;
                iM581a++;
            }
            this.f606d.setColor(i7);
        }
        if ((this.f610h & 16) != 0) {
            iM581a++;
        }
        if ((this.f610h & 32) != 0) {
            iM581a++;
        }
        if ((this.f610h & 64) != 0) {
            iM581a++;
        }
        if ((this.f610h & 128) != 0) {
            iM581a += 2;
        }
        if ((this.f610h & 256) != 0) {
            iM581a++;
        }
        if ((this.f610h & 512) != 0) {
            this.f604b = bArr[iM581a] & 255;
            iM581a++;
        }
        if ((this.f610h & 1024) != 0) {
            this.f605c = bArr[iM581a] & 255;
            iM581a++;
        }
        if ((this.f610h & 2048) != 0) {
            RectF rectF = new RectF();
            int iM593b2 = C0903q.m593b(bArr, iM581a, iArr);
            rectF.left = (short) iArr[0];
            int iM593b3 = C0903q.m593b(bArr, iM593b2, iArr);
            rectF.top = (short) iArr[0];
            int iM593b4 = C0903q.m593b(bArr, iM593b3, iArr);
            rectF.right = (short) iArr[0];
            iM581a = C0903q.m593b(bArr, iM593b4, iArr);
            rectF.bottom = (short) iArr[0];
            this.f606d.setRect(rectF);
        }
        if (iM581a < i3) {
            if ((this.f610h & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0) {
                iM581a = C0903q.m593b(bArr, iM581a, iArr);
                this.f606d.setRotateAngle(iArr[0] / 100.0f);
            }
            if ((this.f610h & 8192) != 0) {
                float size = this.f606d.getSize();
                iM581a = C0903q.m593b(bArr, iM581a, iArr);
                this.f606d.setSize(size + (((short) iArr[0]) / 10000.0f));
            }
            if ((this.f610h & 16384) != 0) {
                int iM593b5 = C0903q.m593b(bArr, iM581a, iArr);
                int i8 = (char) iArr[0];
                if (i8 > 0) {
                    char[] cArr = new char[i8];
                    iM593b = iM593b5;
                    for (int i9 = 0; i9 < i8 && iM593b < i3; i9++) {
                        iM593b = C0903q.m593b(bArr, iM593b, iArr);
                        cArr[i9] = (char) iArr[0];
                    }
                    str = new String(cArr);
                } else {
                    iM593b = iM593b5;
                    str = null;
                }
                this.f606d.setDescription(str);
            } else {
                iM593b = iM581a;
            }
            if ((this.f610h & 32768) != 0) {
                iM581a = C0903q.m593b(bArr, iM593b, iArr);
                int i10 = (char) iArr[0];
                if (i10 > 0) {
                    char[] cArr2 = new char[i10];
                    int i11 = 0;
                    while (i11 < i10 && iM581a < i3) {
                        int iM593b6 = C0903q.m593b(bArr, iM581a, iArr);
                        cArr2[i11] = (char) iArr[0];
                        i11++;
                        iM581a = iM593b6;
                    }
                    str2 = new String(cArr2);
                }
                this.f606d.setHyperText(str2);
            } else {
                iM581a = iM593b;
            }
            if ((this.f610h & 65536) != 0) {
                int iM581a4 = C0903q.m581a(bArr, iM581a, iArr);
                this.f606d.setLatitude(iArr[0]);
                iM581a = C0903q.m581a(bArr, iM581a4, iArr);
                this.f606d.setLongitude(iArr[0]);
            }
            if ((this.f610h & 131072) != 0) {
                this.f611i = this.f612j.m393a(bArr, iM581a);
                if (this.f611i < 0) {
                    return -1;
                }
                this.f606d.setObjectData(this.f612j);
                iM581a += this.f611i;
            }
        }
        return iM581a - i;
    }

    /* renamed from: a */
    public int m520a(byte[] bArr, int i, int i2, int i3) {
        int iM592b;
        mo521a();
        int iM579a = C0903q.m579a(bArr, C0903q.m579a(bArr, i, m533f() - 4), this.f610h);
        if ((this.f610h & 1) != 0) {
            iM592b = iM579a + 1;
            bArr[iM579a] = (byte) this.f603a;
        } else {
            iM592b = iM579a;
        }
        if ((this.f610h & 2) != 0) {
            bArr[iM592b] = (byte) this.f606d.getStyle();
            iM592b++;
        }
        if ((this.f610h & 4) != 0) {
            bArr[iM592b] = (byte) this.f606d.getSize();
            iM592b++;
        }
        if ((this.f610h & 8) != 0) {
            int color = this.f606d.getColor();
            int i4 = 24;
            while (i4 >= 0) {
                bArr[iM592b] = (byte) ((color >> i4) & 255);
                i4 -= 8;
                iM592b++;
            }
        }
        if ((this.f610h & 16) != 0) {
            bArr[iM592b] = 0;
            iM592b++;
        }
        if ((this.f610h & 32) != 0) {
            bArr[iM592b] = 0;
            iM592b++;
        }
        if ((this.f610h & 64) != 0) {
            bArr[iM592b] = 0;
            iM592b++;
        }
        if ((this.f610h & 128) != 0) {
            iM592b = C0903q.m592b(bArr, iM592b, 0);
        }
        if ((this.f610h & 256) != 0) {
            bArr[iM592b] = 0;
            iM592b++;
        }
        if ((this.f610h & 512) != 0) {
            bArr[iM592b] = (byte) this.f604b;
            iM592b++;
        }
        if ((this.f610h & 1024) != 0) {
            bArr[iM592b] = (byte) this.f605c;
            iM592b++;
        }
        if ((this.f610h & 2048) != 0) {
            iM592b = C0903q.m592b(bArr, C0903q.m592b(bArr, C0903q.m592b(bArr, C0903q.m592b(bArr, iM592b, ((int) this.f606d.getRect().left) + i2), ((int) this.f606d.getRect().top) + i3), ((int) this.f606d.getRect().right) + i2), ((int) this.f606d.getRect().bottom) + i3);
        }
        if ((this.f610h & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0) {
            float rotateAngle = this.f606d.getRotateAngle() - (((int) (r1 / 360.0f)) * 360);
            if (rotateAngle < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                rotateAngle += 360.0f;
            }
            iM592b = C0903q.m592b(bArr, iM592b, (int) (rotateAngle * 100.0f));
        }
        if ((this.f610h & 8192) != 0) {
            iM592b = C0903q.m592b(bArr, iM592b, (int) ((this.f606d.getSize() - ((int) r1)) * 10000.0f));
        }
        if ((this.f610h & 16384) != 0) {
            String description = this.f606d.getDescription();
            int iM518i = m518i();
            iM592b = C0903q.m592b(bArr, iM592b, iM518i);
            if (iM518i > 0) {
                char[] charArray = description.toCharArray();
                int i5 = 0;
                while (i5 < iM518i) {
                    int iM592b2 = C0903q.m592b(bArr, iM592b, charArray[i5]);
                    i5++;
                    iM592b = iM592b2;
                }
            }
        }
        if ((this.f610h & 32768) != 0) {
            String hyperText = this.f606d.getHyperText();
            int iM517h = m517h();
            iM592b = C0903q.m592b(bArr, iM592b, iM517h);
            if (iM517h > 0) {
                char[] charArray2 = hyperText.toCharArray();
                int i6 = 0;
                while (i6 < iM517h) {
                    int iM592b3 = C0903q.m592b(bArr, iM592b, charArray2[i6]);
                    i6++;
                    iM592b = iM592b3;
                }
            }
        }
        int iM579a2 = (this.f610h & 65536) != 0 ? C0903q.m579a(bArr, C0903q.m579a(bArr, iM592b, this.f606d.getLatitude()), this.f606d.getLongitude()) : iM592b;
        if ((this.f610h & 131072) != 0) {
            C0891e c0891e = (C0891e) this.f606d.getObjectData();
            int iM404b = c0891e != null ? c0891e.m404b(bArr, iM579a2) : 0;
            if (iM404b < 0) {
                return -1;
            }
            iM579a2 += iM404b;
        }
        return iM579a2 - i;
    }
}
