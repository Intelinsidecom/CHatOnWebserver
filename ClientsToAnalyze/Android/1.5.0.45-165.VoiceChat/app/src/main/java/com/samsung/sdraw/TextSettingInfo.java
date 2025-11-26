package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TextSettingInfo {
    public static final int MAX_TEXT_SIZE = 20;
    public static final int MIN_TEXT_SIZE = 5;
    public static final int TEXT_TYPE_BOLD = 1;
    public static final int TEXT_TYPE_ITALIC = 2;
    public static final int TEXT_TYPE_NONE = 0;
    public static final int TEXT_TYPE_UNDERLINE = 4;

    /* renamed from: a */
    private static String f1347a = "Sans serif";

    /* renamed from: b */
    private static final int f1348b = Color.rgb(19, 19, 19);

    /* renamed from: c */
    private static Layout.Alignment f1349c = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: d */
    private int f1350d;

    /* renamed from: e */
    private int f1351e;

    /* renamed from: f */
    private int f1352f;

    /* renamed from: g */
    private int f1353g;

    /* renamed from: h */
    private int f1354h;

    /* renamed from: i */
    private String f1355i;

    /* renamed from: j */
    private Layout.Alignment f1356j;

    /* renamed from: k */
    private InterfaceC0985a f1357k;

    /* renamed from: l */
    private InterfaceC0986b f1358l;

    /* renamed from: com.samsung.sdraw.TextSettingInfo$a */
    interface InterfaceC0985a {
        /* renamed from: a */
        void mo987a(int i);

        /* renamed from: a */
        void mo988a(Layout.Alignment alignment);

        /* renamed from: a */
        void mo989a(String str);

        /* renamed from: b */
        void mo990b(int i);

        /* renamed from: c */
        void mo991c(int i);
    }

    /* renamed from: com.samsung.sdraw.TextSettingInfo$b */
    interface InterfaceC0986b {
        /* renamed from: a */
        void mo794a(int i);

        /* renamed from: a */
        void mo795a(Layout.Alignment alignment);

        /* renamed from: a */
        void mo796a(String str);

        /* renamed from: b */
        void mo797b(int i);

        /* renamed from: c */
        void mo798c(int i);
    }

    public TextSettingInfo(Context context) {
        m1187a(null, null, null, null, null);
        m1183a();
    }

    public TextSettingInfo() {
        m1187a(null, null, null, null, null);
        m1183a();
    }

    public TextSettingInfo(int mustZero) {
        m1187a(null, null, null, null, null);
        m1183a();
    }

    public int getTextType() {
        return this.f1350d;
    }

    public int getTextColor() {
        return this.f1352f;
    }

    public int getTextSize() {
        return this.f1351e;
    }

    public void setTextType(int type) {
        if (type < 0 || type > 7) {
            type = 0;
        }
        this.f1350d = type;
        if (this.f1357k != null) {
            this.f1357k.mo987a(type);
        }
        if (this.f1358l != null) {
            this.f1358l.mo794a(type);
        }
    }

    public void setTextSize(int size) {
        if (size < 5) {
            this.f1351e = 5;
        } else if (size > 20) {
            this.f1351e = 20;
        } else {
            this.f1351e = size;
        }
        if (this.f1357k != null) {
            this.f1357k.mo991c(size);
        }
        if (this.f1358l != null) {
            this.f1358l.mo798c(size);
        }
    }

    public void setTextColor(int color) {
        this.f1352f = (-16777216) | color;
        if (this.f1357k != null) {
            this.f1357k.mo990b(color);
        }
        if (this.f1358l != null) {
            this.f1358l.mo797b(color);
        }
    }

    public void setTextFont(String font) {
        if (!isValidFont(font)) {
            font = null;
        }
        this.f1355i = font;
        if (this.f1357k != null) {
            this.f1357k.mo989a(font);
        }
        if (this.f1358l != null) {
            this.f1358l.mo796a(font);
        }
    }

    /* renamed from: a */
    void m1184a(int i, int i2) {
        this.f1353g = i;
        this.f1354h = i2;
    }

    /* renamed from: a */
    void m1187a(String str, String str2, String str3, String str4, Layout.Alignment alignment) {
        if (str != null) {
            this.f1351e = Integer.parseInt(str);
        } else {
            this.f1351e = 10;
        }
        if (str2 != null) {
            this.f1352f = Integer.parseInt(str2);
        } else {
            this.f1352f = f1348b;
        }
        if (str3 != null) {
            this.f1350d = Integer.parseInt(str3);
        } else {
            this.f1350d = 0;
        }
        if (!isValidFont(str4)) {
            str4 = null;
        }
        this.f1355i = str4;
        if (alignment != null) {
            this.f1356j = alignment;
        } else {
            this.f1356j = f1349c;
        }
    }

    /* renamed from: a */
    void m1185a(InterfaceC0985a interfaceC0985a) {
        this.f1357k = interfaceC0985a;
    }

    /* renamed from: a */
    void m1186a(InterfaceC0986b interfaceC0986b) {
        this.f1358l = interfaceC0986b;
    }

    public String getTextFont() {
        return this.f1355i;
    }

    /* renamed from: a */
    private void m1183a() {
        File[] fileArrListFiles = new File("/system/fonts/").listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.getName().endsWith("Sans.ttf")) {
                    f1347a = "Sans serif";
                    return;
                }
            }
        }
    }

    public Layout.Alignment getTextAlignment() {
        return this.f1356j;
    }

    public void setTextAlignment(Layout.Alignment align) {
        this.f1356j = align;
        if (this.f1357k != null) {
            this.f1357k.mo988a(align);
        }
        if (this.f1358l != null) {
            this.f1358l.mo795a(align);
        }
    }

    public static boolean isValidFont(String fontName) {
        if (C1040bz.f1673c.size() != 0) {
            Iterator<String> it = C1040bz.f1673c.iterator();
            while (it.hasNext()) {
                if (it.next().equals(fontName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
