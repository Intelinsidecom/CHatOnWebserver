package com.sec.chaton.multimedia.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import java.util.HashMap;

/* loaded from: classes.dex */
public class RichString extends SpannableStringBuilder {

    /* renamed from: a */
    public static String[] f2133a;

    /* renamed from: b */
    public static int[] f2134b;

    /* renamed from: c */
    protected static int[][] f2135c;

    /* renamed from: d */
    private static HashMap f2136d;

    /* renamed from: e */
    private static EmoticonUsageManager f2137e = null;

    static {
        m2528b();
        f2135c = new int[][]{new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}};
    }

    public RichString(Resources resources, String str, int i) throws Resources.NotFoundException {
        super(str);
        m2526a(resources, str, i);
    }

    public RichString(String str, int i) throws Resources.NotFoundException {
        super(str);
        m2526a(GlobalApplication.m2388f(), str, i);
    }

    /* renamed from: a */
    public static int m2523a() {
        return f2133a.length;
    }

    /* renamed from: a */
    public static Integer m2524a(String str) {
        if (f2136d.containsKey(str)) {
            return (Integer) f2136d.get(str);
        }
        return 0;
    }

    /* renamed from: a */
    public static String m2525a(int i) {
        return f2133a[i];
    }

    /* renamed from: a */
    private void m2526a(Resources resources, String str, int i) throws Resources.NotFoundException {
        if (f2133a == null || f2134b == null) {
            return;
        }
        for (int i2 = 0; i2 < f2133a.length; i2++) {
            String str2 = f2133a[i2];
            if (str2 != null && !"".equals(str2)) {
                int length = str2.length();
                int i3 = f2134b[i2];
                int iIndexOf = 0;
                int i4 = 0;
                while (true) {
                    iIndexOf = str.indexOf(str2, iIndexOf + i4);
                    if (-1 < iIndexOf) {
                        Drawable drawable = resources.getDrawable(i3);
                        if (i < 0) {
                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        } else {
                            drawable.setBounds(0, 0, i, i);
                        }
                        setSpan(new ImageSpan(drawable, 0), iIndexOf, iIndexOf + length, 33);
                        i4 = length;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static int m2527b(int i) {
        return f2134b[i];
    }

    /* renamed from: b */
    private static void m2528b() {
        m2529c();
        m2530d();
        m2531e();
    }

    /* renamed from: c */
    private static void m2529c() {
        f2133a = new String[57];
        f2133a[0] = "[(:]";
        int i = 0 + 1;
        f2133a[i] = "[x_x]";
        int i2 = i + 1;
        f2133a[i2] = "[-_-]";
        int i3 = i2 + 1;
        f2133a[i3] = "[):]";
        int i4 = i3 + 1;
        f2133a[i4] = "[^^]";
        int i5 = i4 + 1;
        f2133a[i5] = "[~_~]";
        int i6 = i5 + 1;
        f2133a[i6] = "[-_-*]";
        int i7 = i6 + 1;
        f2133a[i7] = "[*_*]";
        int i8 = i7 + 1;
        f2133a[i8] = "[:>]";
        int i9 = i8 + 1;
        f2133a[i9] = "[d:]";
        int i10 = i9 + 1;
        f2133a[i10] = "[,_@]";
        int i11 = i10 + 1;
        f2133a[i11] = "[T_T]";
        int i12 = i11 + 1;
        f2133a[i12] = "[+-_-]";
        int i13 = i12 + 1;
        f2133a[i13] = "[5(ll)]";
        int i14 = i13 + 1;
        f2133a[i14] = "[hm]";
        int i15 = i14 + 1;
        f2133a[i15] = "[}}=]";
        int i16 = i15 + 1;
        f2133a[i16] = "[o:]";
        int i17 = i16 + 1;
        f2133a[i17] = "[$:]";
        int i18 = i17 + 1;
        f2133a[i18] = "[u@--]";
        int i19 = i18 + 1;
        f2133a[i19] = "[l3]";
        int i20 = i19 + 1;
        f2133a[i20] = "[i*(((=]";
        int i21 = i20 + 1;
        f2133a[i21] = "[z88]";
        int i22 = i21 + 1;
        f2133a[i22] = "[n@]";
        int i23 = i22 + 1;
        f2133a[i23] = "[a*]";
        int i24 = i23 + 1;
        f2133a[i24] = "[y8]";
        int i25 = i24 + 1;
        f2133a[i25] = "[c~]";
        int i26 = i25 + 1;
        f2133a[i26] = "[;;]";
        int i27 = i26 + 1;
        f2133a[i27] = "[%]";
        int i28 = i27 + 1;
        f2133a[i28] = "[m-\"-]";
        int i29 = i28 + 1;
        f2133a[i29] = "[b-m-]";
        int i30 = i29 + 1;
        f2133a[i30] = "[>:]";
        int i31 = i30 + 1;
        f2133a[i31] = "[=:]";
        int i32 = i31 + 1;
        f2133a[i32] = "[<((<]";
        int i33 = i32 + 1;
        f2133a[i33] = "[{@}--]";
        int i34 = i33 + 1;
        f2133a[i34] = "[9&7]";
        int i35 = i34 + 1;
        f2133a[i35] = "[f&F]";
        int i36 = i35 + 1;
        f2133a[i36] = "[g&S]";
        int i37 = i36 + 1;
        f2133a[i37] = "['-3-]";
        int i38 = i37 + 1;
        f2133a[i38] = "[v]";
        int i39 = i38 + 1;
        f2133a[i39] = "[1S2]";
        int i40 = i39 + 1;
        f2133a[i40] = "[3S2]";
        int i41 = i40 + 1;
        f2133a[i41] = "[2S2]";
        int i42 = i41 + 1;
        f2133a[i42] = "[p_ _;]";
        int i43 = i42 + 1;
        f2133a[i43] = "[r=3]";
        int i44 = i43 + 1;
        f2133a[i44] = "[@]";
        int i45 = i44 + 1;
        f2133a[i45] = "[8->]";
        int i46 = i45 + 1;
        f2133a[i46] = "[\"o.o.]";
        int i47 = i46 + 1;
        f2133a[i47] = "[k><]";
        int i48 = i47 + 1;
        f2133a[i48] = "[s$]";
        int i49 = i48 + 1;
        f2133a[i49] = "[#]";
        int i50 = i49 + 1;
        f2133a[i50] = "[..x]";
        int i51 = i50 + 1;
        f2133a[i51] = "[eez]";
        int i52 = i51 + 1;
        f2133a[i52] = "[j>_<]";
        int i53 = i52 + 1;
        f2133a[i53] = "[7:]";
        int i54 = i53 + 1;
        f2133a[i54] = "[6:]";
        int i55 = i54 + 1;
        f2133a[i55] = "[4:]";
        int i56 = i55 + 1;
        f2133a[i56] = "[w*]";
        int i57 = i56 + 1;
    }

    /* renamed from: d */
    private static void m2530d() {
        f2134b = new int[57];
        f2134b[0] = C0062R.drawable.ssm_emoticon_60x60_01;
        int i = 0 + 1;
        f2134b[i] = C0062R.drawable.ssm_emoticon_60x60_02;
        int i2 = i + 1;
        f2134b[i2] = C0062R.drawable.ssm_emoticon_60x60_03;
        int i3 = i2 + 1;
        f2134b[i3] = C0062R.drawable.ssm_emoticon_60x60_04;
        int i4 = i3 + 1;
        f2134b[i4] = C0062R.drawable.ssm_emoticon_60x60_05;
        int i5 = i4 + 1;
        f2134b[i5] = C0062R.drawable.ssm_emoticon_60x60_06;
        int i6 = i5 + 1;
        f2134b[i6] = C0062R.drawable.ssm_emoticon_60x60_07;
        int i7 = i6 + 1;
        f2134b[i7] = C0062R.drawable.ssm_emoticon_60x60_08;
        int i8 = i7 + 1;
        f2134b[i8] = C0062R.drawable.ssm_emoticon_60x60_09;
        int i9 = i8 + 1;
        f2134b[i9] = C0062R.drawable.ssm_emoticon_60x60_10;
        int i10 = i9 + 1;
        f2134b[i10] = C0062R.drawable.ssm_emoticon_60x60_11;
        int i11 = i10 + 1;
        f2134b[i11] = C0062R.drawable.ssm_emoticon_60x60_12;
        int i12 = i11 + 1;
        f2134b[i12] = C0062R.drawable.ssm_emoticon_60x60_13;
        int i13 = i12 + 1;
        f2134b[i13] = C0062R.drawable.ssm_emoticon_60x60_26;
        int i14 = i13 + 1;
        f2134b[i14] = C0062R.drawable.ssm_emoticon_60x60_27;
        int i15 = i14 + 1;
        f2134b[i15] = C0062R.drawable.ssm_emoticon_60x60_28;
        int i16 = i15 + 1;
        f2134b[i16] = C0062R.drawable.ssm_emoticon_60x60_29;
        int i17 = i16 + 1;
        f2134b[i17] = C0062R.drawable.ssm_emoticon_60x60_30;
        int i18 = i17 + 1;
        f2134b[i18] = C0062R.drawable.ssm_emoticon_60x60_33;
        int i19 = i18 + 1;
        f2134b[i19] = C0062R.drawable.ssm_emoticon_60x60_34;
        int i20 = i19 + 1;
        f2134b[i20] = C0062R.drawable.ssm_emoticon_60x60_35;
        int i21 = i20 + 1;
        f2134b[i21] = C0062R.drawable.ssm_emoticon_60x60_38;
        int i22 = i21 + 1;
        f2134b[i22] = C0062R.drawable.ssm_emoticon_60x60_41;
        int i23 = i22 + 1;
        f2134b[i23] = C0062R.drawable.ssm_emoticon_60x60_42;
        int i24 = i23 + 1;
        f2134b[i24] = C0062R.drawable.ssm_emoticon_60x60_43;
        int i25 = i24 + 1;
        f2134b[i25] = C0062R.drawable.ssm_emoticon_60x60_44;
        int i26 = i25 + 1;
        f2134b[i26] = C0062R.drawable.ssm_emoticon_60x60_45;
        int i27 = i26 + 1;
        f2134b[i27] = C0062R.drawable.ssm_emoticon_60x60_46;
        int i28 = i27 + 1;
        f2134b[i28] = C0062R.drawable.ssm_emoticon_60x60_47;
        int i29 = i28 + 1;
        f2134b[i29] = C0062R.drawable.ssm_emoticon_60x60_48;
        int i30 = i29 + 1;
        f2134b[i30] = C0062R.drawable.ssm_emoticon_60x60_49;
        int i31 = i30 + 1;
        f2134b[i31] = C0062R.drawable.ssm_emoticon_60x60_50;
        int i32 = i31 + 1;
        f2134b[i32] = C0062R.drawable.ssm_emoticon_60x60_51;
        int i33 = i32 + 1;
        f2134b[i33] = C0062R.drawable.ssm_emoticon_60x60_52;
        int i34 = i33 + 1;
        f2134b[i34] = C0062R.drawable.ssm_emoticon_60x60_53;
        int i35 = i34 + 1;
        f2134b[i35] = C0062R.drawable.ssm_emoticon_60x60_54;
        int i36 = i35 + 1;
        f2134b[i36] = C0062R.drawable.ssm_emoticon_60x60_55;
        int i37 = i36 + 1;
        f2134b[i37] = C0062R.drawable.ssm_emoticon_60x60_56;
        int i38 = i37 + 1;
        f2134b[i38] = C0062R.drawable.ssm_emoticon_60x60_57;
        int i39 = i38 + 1;
        f2134b[i39] = C0062R.drawable.ssm_emoticon_60x60_60;
        int i40 = i39 + 1;
        f2134b[i40] = C0062R.drawable.ssm_emoticon_60x60_61;
        int i41 = i40 + 1;
        f2134b[i41] = C0062R.drawable.ssm_emoticon_60x60_62;
        int i42 = i41 + 1;
        f2134b[i42] = C0062R.drawable.ssm_emoticon_60x60_64;
        int i43 = i42 + 1;
        f2134b[i43] = C0062R.drawable.ssm_emoticon_60x60_65;
        int i44 = i43 + 1;
        f2134b[i44] = C0062R.drawable.ssm_emoticon_60x60_66;
        int i45 = i44 + 1;
        f2134b[i45] = C0062R.drawable.ssm_emoticon_60x60_67;
        int i46 = i45 + 1;
        f2134b[i46] = C0062R.drawable.ssm_emoticon_60x60_68;
        int i47 = i46 + 1;
        f2134b[i47] = C0062R.drawable.ssm_emoticon_60x60_69;
        int i48 = i47 + 1;
        f2134b[i48] = C0062R.drawable.ssm_emoticon_60x60_70;
        int i49 = i48 + 1;
        f2134b[i49] = C0062R.drawable.ssm_emoticon_60x60_71;
        int i50 = i49 + 1;
        f2134b[i50] = C0062R.drawable.ssm_emoticon_60x60_72;
        int i51 = i50 + 1;
        f2134b[i51] = C0062R.drawable.ssm_emoticon_60x60_73;
        int i52 = i51 + 1;
        f2134b[i52] = C0062R.drawable.ssm_emoticon_60x60_74;
        int i53 = i52 + 1;
        f2134b[i53] = C0062R.drawable.ssm_emoticon_60x60_77;
        int i54 = i53 + 1;
        f2134b[i54] = C0062R.drawable.ssm_emoticon_60x60_78;
        int i55 = i54 + 1;
        f2134b[i55] = C0062R.drawable.ssm_emoticon_60x60_79;
        int i56 = i55 + 1;
        f2134b[i56] = C0062R.drawable.ssm_emoticon_60x60_80;
        int i57 = i56 + 1;
    }

    /* renamed from: e */
    private static void m2531e() {
        f2136d = new HashMap();
        for (int i = 0; i < f2134b.length; i++) {
            f2136d.put(f2133a[i], Integer.valueOf(f2134b[i]));
        }
    }

    /* renamed from: a */
    public void m2532a(EditText editText) {
        int selectionStart = editText.getSelectionStart();
        editText.getEditableText().replace(selectionStart, editText.getSelectionEnd(), this, 0, length());
        editText.setSelection(length() + selectionStart, selectionStart + length());
    }
}
