package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Color;
import com.samsung.sdraw.StrokeSprite;

/* loaded from: classes.dex */
public class PenSettingInfo {
    public static final int MAX_ERASER_WIDTH = 89;
    public static final int MAX_PEN_WIDTH = 72;
    public static final int MIN_PEN_WIDTH = 1;
    public static final int PEN_TYPE_BRUSH = 1;
    public static final int PEN_TYPE_ERASER = 4;
    public static final int PEN_TYPE_MARKER = 3;
    public static final int PEN_TYPE_MAX = 6;
    public static final int PEN_TYPE_PENCIL = 2;
    public static final int PEN_TYPE_SOLID = 0;
    public static final int PEN_TYPE_ZENBRUSH = 5;

    /* renamed from: b */
    private static final int f1105b = Color.argb(254, 19, 19, 19);

    /* renamed from: a */
    int[] f1106a;

    /* renamed from: c */
    private int f1107c;

    /* renamed from: d */
    private int[] f1108d;

    /* renamed from: e */
    private int[] f1109e;

    /* renamed from: f */
    private int[] f1110f;

    /* renamed from: g */
    private int f1111g;

    /* renamed from: h */
    private int f1112h;

    /* renamed from: i */
    private int f1113i;

    /* renamed from: j */
    private InterfaceC0976a f1114j;

    /* renamed from: k */
    private InterfaceC0977b f1115k;

    /* renamed from: l */
    private OnSettingInfoChangedListener f1116l;

    public interface OnSettingInfoChangedListener {
        void onEraserWidthChanged(int i);

        void onPenAlphaChanged(int i, int i2);

        void onPenColorChanged(int i, int i2);

        void onPenTypeChanged(int i);

        void onPenWidthChanged(int i, int i2);
    }

    /* renamed from: com.samsung.sdraw.PenSettingInfo$a */
    interface InterfaceC0976a {
        /* renamed from: a */
        void mo981a(int i);

        /* renamed from: a */
        void mo982a(int i, int i2);

        /* renamed from: b */
        void mo983b(int i);

        /* renamed from: b */
        void mo984b(int i, int i2);

        /* renamed from: c */
        void mo985c(int i, int i2);
    }

    /* renamed from: com.samsung.sdraw.PenSettingInfo$b */
    interface InterfaceC0977b {
        /* renamed from: a */
        void m1026a(int i);

        /* renamed from: a */
        void m1027a(int i, int i2);

        /* renamed from: b */
        void m1028b(int i);

        /* renamed from: b */
        void m1029b(int i, int i2);

        /* renamed from: c */
        void m1030c(int i, int i2);
    }

    public PenSettingInfo(Context context) {
        this.f1108d = new int[6];
        this.f1109e = new int[6];
        this.f1110f = new int[6];
        this.f1106a = new int[6];
        m1024a(null, null, null);
    }

    public PenSettingInfo() {
        this.f1108d = new int[6];
        this.f1109e = new int[6];
        this.f1110f = new int[6];
        this.f1106a = new int[6];
        m1024a(null, null, null);
    }

    public PenSettingInfo(int mustZero) {
        this.f1108d = new int[6];
        this.f1109e = new int[6];
        this.f1110f = new int[6];
        this.f1106a = new int[6];
        m1024a(null, null, null);
    }

    public int getPenType() {
        return this.f1107c;
    }

    public int getPenWidth(int type) {
        if (type < 0 || type > 5) {
            type = 0;
        }
        return this.f1108d[type];
    }

    public int getPenColor(int type) {
        if (type < 0 || type > 5 || type == 4) {
            type = 0;
        }
        return 16777215 & this.f1109e[type];
    }

    public int getPenAlpha(int type) {
        if (type < 0 || type > 5 || type == 4) {
            type = 0;
        }
        return this.f1110f[type];
    }

    public int getPenWidth() {
        return this.f1108d[this.f1107c];
    }

    public int getPenAlphaColor() {
        return (this.f1110f[this.f1107c] << 24) | (16777215 & this.f1109e[this.f1107c]);
    }

    public int getPenColor() {
        return 16777215 & this.f1109e[this.f1107c];
    }

    public int getPenAlpha() {
        return this.f1110f[this.f1107c];
    }

    public int getEraserWidth() {
        return this.f1111g;
    }

    public void setPenType(int type) {
        if (type < 0 || type > 5) {
            type = 0;
        }
        this.f1107c = type;
        if (this.f1114j != null) {
            this.f1114j.mo981a(type);
        }
        if (this.f1115k != null) {
            this.f1115k.m1026a(type);
        }
        if (this.f1116l != null) {
            this.f1116l.onPenTypeChanged(type);
        }
    }

    public void setPenWidth(int type, int width) {
        if (type < 0 || type > 5) {
            type = 0;
        }
        if (width < 1) {
            this.f1108d[type] = 1;
        } else if (width > 72 && type != 4) {
            this.f1108d[type] = 72;
        } else if (width > 89 && type == 4) {
            this.f1108d[type] = 89;
        } else {
            this.f1108d[type] = width;
        }
        if (this.f1114j != null) {
            this.f1114j.mo982a(type, width);
        }
        if (this.f1115k != null) {
            this.f1115k.m1029b(type, width);
        }
        if (this.f1116l != null) {
            this.f1116l.onPenWidthChanged(type, width);
        }
    }

    public void setPenColor(int type, int color) {
        if (type < 0 || type > 5 || type == 4) {
            type = 0;
        }
        this.f1109e[type] = 16777215 & color;
        if (this.f1114j != null) {
            this.f1114j.mo984b(type, color);
        }
        if (this.f1115k != null) {
            this.f1115k.m1027a(type, color);
        }
        if (this.f1116l != null) {
            this.f1116l.onPenColorChanged(type, color);
        }
    }

    public void setPenAlpha(int type, int alpha) {
        if (type < 0 || type > 5 || type == 4) {
            type = 0;
        }
        if (alpha < 0) {
            alpha = 0;
        } else if (alpha > 255) {
            alpha = 255;
        }
        if (type != 3) {
            alpha = 255;
        }
        this.f1110f[type] = alpha;
        if (this.f1114j != null) {
            this.f1114j.mo985c(type, alpha);
        }
        if (this.f1115k != null) {
            this.f1115k.m1030c(type, alpha);
        }
        if (this.f1116l != null) {
            this.f1116l.onPenAlphaChanged(type, alpha);
        }
    }

    public void setPenWidth(int width) {
        if (width < 1) {
            this.f1108d[this.f1107c] = 1;
        } else if (width > 72 && this.f1107c != 4) {
            this.f1108d[this.f1107c] = 72;
        } else if (width > 89 && this.f1107c == 4) {
            this.f1108d[this.f1107c] = 89;
        } else {
            this.f1108d[this.f1107c] = width;
        }
        if (this.f1114j != null) {
            this.f1114j.mo982a(this.f1107c, width);
        }
        if (this.f1115k != null) {
            this.f1115k.m1029b(this.f1107c, width);
        }
        if (this.f1116l != null) {
            this.f1116l.onPenWidthChanged(this.f1107c, width);
        }
    }

    public void setPenColor(int color) {
        int i;
        this.f1109e[this.f1107c] = 16777215 & color;
        if ((this.f1106a[this.f1107c] & 16777215) != this.f1109e[this.f1107c]) {
            this.f1106a[this.f1107c] = this.f1109e[this.f1107c] | (-16777216);
        }
        if (this.f1114j != null) {
            this.f1114j.mo984b(this.f1107c, color);
        }
        if (this.f1115k != null) {
            if ((color & (-16777216)) == -16777216) {
                i = (16777215 & color) | (-33554432);
            } else if ((color & (-16777216)) == -33554432) {
                i = (16777215 & color) | (-16777216);
            } else {
                i = (16777215 & color) | (-16777216);
            }
            this.f1115k.m1027a(this.f1107c, i);
        }
        if (this.f1116l != null) {
            this.f1116l.onPenColorChanged(this.f1107c, color);
        }
    }

    public void setPenAlpha(int alpha) {
        if (alpha < 0) {
            alpha = 0;
        } else if (alpha > 255) {
            alpha = 255;
        }
        if (this.f1107c != 3) {
            alpha = 255;
        }
        this.f1110f[this.f1107c] = alpha;
        if (this.f1114j != null) {
            this.f1114j.mo985c(this.f1107c, alpha);
        }
        if (this.f1115k != null) {
            this.f1115k.m1030c(this.f1107c, alpha);
        }
        if (this.f1116l != null) {
            this.f1116l.onPenAlphaChanged(this.f1107c, alpha);
        }
    }

    public void setEraserWidth(int width) {
        if (1 > width) {
            width = 1;
        } else if (width > 89) {
            width = 89;
        }
        this.f1111g = width;
        this.f1108d[4] = this.f1111g;
        if (this.f1114j != null) {
            this.f1114j.mo983b(width);
        }
        if (this.f1115k != null) {
            this.f1115k.m1028b(width);
        }
        if (this.f1116l != null) {
            this.f1116l.onEraserWidthChanged(width);
        }
    }

    /* renamed from: a */
    void m1022a(int i, int i2) {
        this.f1112h = i;
        this.f1113i = i2;
    }

    /* renamed from: a */
    void m1024a(String[] strArr, String[] strArr2, String[] strArr3) {
        if (strArr != null && strArr.length == 6) {
            this.f1108d[0] = Integer.parseInt(strArr[0]);
            this.f1108d[1] = Integer.parseInt(strArr[1]);
            this.f1108d[2] = Integer.parseInt(strArr[2]);
            this.f1108d[3] = Integer.parseInt(strArr[3]);
            this.f1108d[5] = Integer.parseInt(strArr[4]);
        } else {
            int[] iArr = this.f1108d;
            int[] iArr2 = this.f1108d;
            int[] iArr3 = this.f1108d;
            this.f1108d[5] = 8;
            iArr3[2] = 8;
            iArr2[1] = 8;
            iArr[0] = 8;
            this.f1108d[3] = 24;
        }
        if (strArr2 != null && strArr2.length == 6) {
            this.f1109e[0] = Integer.parseInt(strArr2[0]);
            this.f1109e[1] = Integer.parseInt(strArr2[1]);
            this.f1109e[2] = Integer.parseInt(strArr2[2]);
            this.f1109e[3] = Integer.parseInt(strArr2[3]);
            this.f1109e[5] = Integer.parseInt(strArr2[4]);
        } else {
            int[] iArr4 = this.f1109e;
            int[] iArr5 = this.f1109e;
            int[] iArr6 = this.f1109e;
            int[] iArr7 = this.f1109e;
            int i = f1105b;
            iArr7[5] = i;
            iArr6[2] = i;
            iArr5[1] = i;
            iArr4[0] = i;
            this.f1109e[3] = Color.rgb(253, 255, 45);
            this.f1106a[0] = (-16777216) | (16777215 & this.f1109e[0]);
            this.f1106a[1] = (-16777216) | (16777215 & this.f1109e[1]);
            this.f1106a[2] = (-16777216) | (16777215 & this.f1109e[2]);
            this.f1106a[3] = (-16777216) | (16777215 & this.f1109e[3]);
            this.f1106a[5] = (-16777216) | (16777215 & this.f1109e[5]);
        }
        if (strArr3 != null && strArr3.length == 6) {
            this.f1110f[0] = Integer.parseInt(strArr3[0]);
            this.f1110f[1] = Integer.parseInt(strArr3[1]);
            this.f1110f[2] = Integer.parseInt(strArr3[2]);
            this.f1110f[3] = Integer.parseInt(strArr3[3]);
            this.f1110f[5] = Integer.parseInt(strArr3[5]);
        } else {
            int[] iArr8 = this.f1110f;
            int[] iArr9 = this.f1110f;
            int[] iArr10 = this.f1110f;
            this.f1110f[5] = 255;
            iArr10[2] = 255;
            iArr9[1] = 255;
            iArr8[0] = 255;
            this.f1110f[3] = 130;
        }
        this.f1111g = 30;
    }

    /* renamed from: a */
    void m1023a(InterfaceC0976a interfaceC0976a) {
        this.f1114j = interfaceC0976a;
    }

    public void setOnSettingInfoChangedListener(OnSettingInfoChangedListener listener) {
        this.f1116l = listener;
    }

    /* renamed from: a */
    static StrokeSprite.Type m1020a(int i) {
        StrokeSprite.Type type = StrokeSprite.Type.Solid;
        switch (i) {
            case 0:
                return StrokeSprite.Type.Solid;
            case 1:
                return StrokeSprite.Type.Brush;
            case 2:
                return StrokeSprite.Type.Pencil;
            case 3:
                return StrokeSprite.Type.Hightlighter;
            case 4:
                return StrokeSprite.Type.Eraser;
            case 5:
                return StrokeSprite.Type.Zenbrush;
            default:
                return type;
        }
    }

    /* renamed from: a */
    static int m1019a(StrokeSprite.Type type) {
        if (type == StrokeSprite.Type.Solid) {
            return 0;
        }
        if (type == StrokeSprite.Type.Hightlighter) {
            return 3;
        }
        if (type == StrokeSprite.Type.Brush) {
            return 1;
        }
        if (type == StrokeSprite.Type.Pencil) {
            return 2;
        }
        if (type == StrokeSprite.Type.Eraser) {
            return 4;
        }
        return type == StrokeSprite.Type.Zenbrush ? 5 : 0;
    }

    /* renamed from: b */
    void m1025b(int i) {
        this.f1106a[this.f1107c] = i;
    }

    /* renamed from: a */
    int m1021a() {
        return this.f1106a[this.f1107c];
    }
}
