package com.samsung.sdraw;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.samsung.sdraw.cc */
/* loaded from: classes.dex */
class C1044cc {
    public static final int ID_ALIGN_CENTER = 3009;
    public static final int ID_ALIGN_LEFT = 3008;
    public static final int ID_ALIGN_RIGHT = 3010;
    public static final int ID_ATTRIBUTE_BOLD = 3005;
    public static final int ID_ATTRIBUTE_ITALIC = 3006;
    public static final int ID_ATTRIBUTE_UNDER = 3007;
    public static final int ID_CLEAR_ALL_BTN = 2001;
    public static final int ID_CLOSE_BTN_ERASER = 2000;
    public static final int ID_CLOSE_BTN_FILL = 4000;
    public static final int ID_CLOSE_BTN_PEN = 1000;
    public static final int ID_CLOSE_BTN_TEXT = 3000;
    public static final int ID_COLOR_PICKER_PEN = 1012;
    public static final int ID_COLOR_SELECT_FILL = 4011;
    public static final int ID_COLOR_SELECT_PEN = 1011;
    public static final int ID_COLOR_SELECT_TEXT = 3011;
    public static final int ID_FIELD_ALIGN = 3002;
    public static final int ID_FIELD_FONT = 3001;
    public static final int ID_PRESET_PREVIEW = 1003;
    public static final int ID_PRESET_SAVE = 1002;
    public static final int ID_SEEKBAR_OPACITY = 1010;
    public static final int ID_SEEKBAR_SIZE = 1009;
    public static final int ID_SEEKBAR_SIZE_ERASER = 2009;
    public static final int ID_SPINNER_FONT = 3003;
    public static final int ID_SPINNER_SIZE = 3004;
    public static final int ID_TYPE_BRUSH = 1005;
    public static final int ID_TYPE_MAKER = 1008;
    public static final int ID_TYPE_PENCIL = 1007;
    public static final int ID_TYPE_SOLID = 1004;
    public static final int ID_TYPE_ZEN_BRUSH = 1006;

    /* renamed from: af */
    protected static String f1690af = "/resource/drawable-xhdpi";

    /* renamed from: a */
    private float f1691a;

    /* renamed from: ag */
    protected String f1692ag;

    /* renamed from: ah */
    protected View f1693ah;

    /* renamed from: ai */
    protected ImageView f1694ai;

    /* renamed from: aj */
    protected PenSettingScrollView f1695aj;

    /* renamed from: ak */
    protected int f1696ak;

    /* renamed from: al */
    protected int f1697al;

    /* renamed from: am */
    protected Context f1698am;

    /* renamed from: an */
    protected int f1699an;

    /* renamed from: ao */
    protected float f1700ao;

    /* renamed from: ap */
    protected View.OnTouchListener f1701ap;

    /* renamed from: b */
    private int f1702b;

    public C1044cc(Context context, String str) {
        this.f1692ag = "";
        this.f1691a = 1.0f;
        this.f1699an = 160;
        this.f1700ao = 1.0f;
        this.f1701ap = new View.OnTouchListener() { // from class: com.samsung.sdraw.cc.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        };
        this.f1698am = context;
        this.f1692ag = str;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f1691a = displayMetrics.density;
        this.f1699an = displayMetrics.densityDpi;
        if (this.f1699an == 160) {
            this.f1702b = 160;
        } else {
            this.f1702b = (int) ((320.0f / this.f1699an) * 160.0f);
        }
        this.f1696ak = displayMetrics.widthPixels;
        this.f1697al = displayMetrics.heightPixels;
    }

    public C1044cc() {
        this.f1692ag = "";
        this.f1691a = 1.0f;
        this.f1699an = 160;
        this.f1700ao = 1.0f;
        this.f1701ap = new View.OnTouchListener() { // from class: com.samsung.sdraw.cc.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        };
    }

    /* renamed from: b */
    protected Drawable m1527b(String str) throws IOException {
        InputStream inputStreamOpenStream;
        URL resource;
        Drawable bitmapDrawable;
        Rect rect = new Rect();
        try {
            inputStreamOpenStream = this.f1698am.getAssets().open(String.valueOf(this.f1692ag) + str);
        } catch (IOException e) {
            if (0 != 0 || (resource = getClass().getResource(String.valueOf(f1690af) + str)) == null) {
                inputStreamOpenStream = null;
            } else {
                try {
                    inputStreamOpenStream = resource.openStream();
                } catch (IOException e2) {
                    return null;
                }
            }
        }
        new BitmapFactory.Options().inDensity = this.f1702b;
        if (inputStreamOpenStream != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream);
            try {
                inputStreamOpenStream.close();
                if (bitmapDecodeStream != null) {
                    byte[] ninePatchChunk = bitmapDecodeStream.getNinePatchChunk();
                    if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        bitmapDrawable = new NinePatchDrawable(this.f1698am.getResources(), bitmapDecodeStream, ninePatchChunk, rect, null);
                    } else {
                        bitmapDrawable = new BitmapDrawable(this.f1698am.getResources(), bitmapDecodeStream);
                    }
                } else {
                    bitmapDrawable = null;
                }
                return bitmapDrawable;
            } catch (IOException e3) {
                return null;
            }
        }
        Log.e("SPen", String.format("Loading resource failed: %s", String.valueOf(this.f1692ag) + str));
        return null;
    }

    /* renamed from: c */
    protected Drawable m1531c(String str) throws IOException {
        InputStream inputStreamOpenStream;
        URL resource;
        Rect rect = new Rect();
        try {
            inputStreamOpenStream = this.f1698am.getAssets().open(String.valueOf(this.f1692ag) + str);
        } catch (IOException e) {
            if (0 != 0 || (resource = getClass().getResource(String.valueOf(f1690af) + str)) == null) {
                inputStreamOpenStream = null;
            } else {
                try {
                    inputStreamOpenStream = resource.openStream();
                } catch (IOException e2) {
                    return null;
                }
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (inputStreamOpenStream != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream, rect, options);
            try {
                inputStreamOpenStream.close();
                if (bitmapDecodeStream == null) {
                    return null;
                }
                byte[] ninePatchChunk = bitmapDecodeStream.getNinePatchChunk();
                if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    return new NinePatchDrawable(bitmapDecodeStream, ninePatchChunk, rect, null);
                }
                return new BitmapDrawable(bitmapDecodeStream);
            } catch (IOException e3) {
                return null;
            }
        }
        Log.e("SPen", String.format("Loading resource failed: %s", String.valueOf(this.f1692ag) + str));
        return null;
    }

    /* renamed from: d */
    protected Bitmap m1532d(String str) throws IOException {
        InputStream inputStreamOpenStream;
        URL resource;
        try {
            inputStreamOpenStream = this.f1698am.getAssets().open(String.valueOf(this.f1692ag) + str);
        } catch (IOException e) {
            if (0 != 0 || (resource = getClass().getResource(String.valueOf(f1690af) + str)) == null) {
                inputStreamOpenStream = null;
            } else {
                try {
                    inputStreamOpenStream = resource.openStream();
                } catch (IOException e2) {
                    return null;
                }
            }
        }
        if (inputStreamOpenStream != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream);
            try {
                inputStreamOpenStream.close();
                return bitmapDecodeStream;
            } catch (IOException e3) {
                return null;
            }
        }
        Log.e("SPen", String.format("Loading resource failed: %s", String.valueOf(this.f1692ag) + str));
        return null;
    }

    /* renamed from: a */
    protected StateListDrawable m1525a(String str, String str2, String str3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (str != null) {
            stateListDrawable.addState(new int[]{-16842919, -16842908, -16842913}, m1527b(str));
        }
        if (str2 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, m1527b(str2));
            stateListDrawable.addState(new int[]{R.attr.state_selected}, m1527b(str2));
        }
        if (str3 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_focused}, m1527b(str3));
        }
        return stateListDrawable;
    }

    /* renamed from: b */
    protected StateListDrawable m1529b(String str, String str2, String str3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (str != null) {
            stateListDrawable.addState(new int[]{-16842919, -16842908, -16842913}, m1531c(str));
        }
        if (str2 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, m1531c(str2));
            stateListDrawable.addState(new int[]{R.attr.state_selected}, m1531c(str2));
        }
        if (str3 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_focused}, m1531c(str3));
        }
        return stateListDrawable;
    }

    /* renamed from: b */
    protected StateListDrawable m1528b(int i, int i2, int i3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919, -16842913}, new ColorDrawable(i));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(i2));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, new ColorDrawable(i3));
        return stateListDrawable;
    }

    /* renamed from: a */
    protected StateListDrawable m1526a(String str, String str2, String str3, String str4, String str5) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (str != null) {
            stateListDrawable.addState(new int[]{-16842919, -16842908, -16842913, R.attr.state_enabled}, m1527b(str));
        }
        if (str2 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, m1527b(str2));
        }
        if (str3 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_focused}, m1527b(str3));
        }
        if (str4 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_selected}, m1527b(str4));
        }
        if (str5 != null) {
            stateListDrawable.addState(new int[]{-16842910}, m1527b(str5));
        }
        return stateListDrawable;
    }

    /* renamed from: b */
    protected StateListDrawable m1530b(String str, String str2, String str3, String str4, String str5) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (str != null) {
            stateListDrawable.addState(new int[]{-16842919, -16842908, -16842913, R.attr.state_enabled}, m1531c(str));
        }
        if (str2 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, m1531c(str2));
        }
        if (str3 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_focused}, m1531c(str3));
        }
        if (str4 != null) {
            stateListDrawable.addState(new int[]{R.attr.state_selected}, m1531c(str4));
        }
        if (str5 != null) {
            stateListDrawable.addState(new int[]{-16842910}, m1531c(str5));
        }
        return stateListDrawable;
    }

    /* renamed from: a */
    protected int m1524a(float f) {
        return (int) (this.f1691a * f);
    }

    public int getThumbPaddingTop() {
        return m1524a(7.5f);
    }

    /* renamed from: h */
    protected void m1533h() {
        if (this.f1699an == 213) {
            this.f1700ao = 0.75f;
            return;
        }
        if (this.f1699an == 240) {
            if ((this.f1696ak == 720 && this.f1697al == 1280) || (this.f1696ak == 1280 && this.f1697al == 720)) {
                this.f1700ao = 1.1f;
                return;
            } else {
                this.f1700ao = 0.88f;
                return;
            }
        }
        this.f1700ao = 1.0f;
    }
}
