package com.sec.chaton.multimedia.p034a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.widget.C1619g;
import java.util.HashMap;

/* compiled from: RichString.java */
/* renamed from: com.sec.chaton.multimedia.a.c */
/* loaded from: classes.dex */
public class C0760c extends SpannableStringBuilder {

    /* renamed from: a */
    public static String[] f2589a;

    /* renamed from: b */
    public static int[] f2590b;

    /* renamed from: c */
    protected static int[][] f2591c;

    /* renamed from: d */
    private static HashMap f2592d;

    /* renamed from: e */
    private static C0758a f2593e = null;

    static {
        m3198b();
        f2591c = new int[][]{new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}};
    }

    public C0760c(Resources resources, String str, int i) throws Resources.NotFoundException {
        super(str);
        m3195a(resources, str, i);
    }

    /* renamed from: a */
    private void m3195a(Resources resources, String str, int i) throws Resources.NotFoundException {
        if (f2589a != null && f2590b != null) {
            for (int i2 = 0; i2 < f2589a.length; i2++) {
                String str2 = f2589a[i2];
                if (str2 != null && !"".equals(str2)) {
                    int length = str2.length();
                    int i3 = f2590b[i2];
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
    }

    /* renamed from: a */
    public static String m3194a(String str) {
        if (f2589a != null && f2590b != null) {
            for (int i = 0; i < f2589a.length; i++) {
                String str2 = f2589a[i];
                if (str2 != null && !"".equals(str2)) {
                    str = str.replace(str2, "%8|3&");
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public void m3202a(EditText editText) {
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        if ((editText.getText().length() + length()) - (selectionEnd - selectionStart) >= 2000) {
            C1619g.m5888a(GlobalApplication.m3100a(), R.string.toast_text_max_Length, 0).show();
        } else {
            editText.getEditableText().replace(selectionStart, selectionEnd, this, 0, length());
            editText.setSelection(length() + selectionStart, selectionStart + length());
        }
    }

    /* renamed from: a */
    public static int m3192a() {
        return f2589a.length;
    }

    /* renamed from: a */
    public static String m3193a(int i) {
        if (i < f2589a.length) {
            return f2589a[i];
        }
        return null;
    }

    /* renamed from: b */
    public static int m3196b(int i) {
        if (i < f2590b.length) {
            return f2590b[i];
        }
        return -1;
    }

    /* renamed from: b */
    public static Integer m3197b(String str) {
        if (f2592d.containsKey(str)) {
            return (Integer) f2592d.get(str);
        }
        return 0;
    }

    /* renamed from: b */
    private static void m3198b() {
        m3199c();
        m3200d();
        m3201e();
    }

    /* renamed from: c */
    private static void m3199c() {
        f2589a = new String[153];
        f2589a[0] = "[:>]";
        f2589a[1] = "[*_*]";
        f2589a[2] = "[(:]";
        f2589a[3] = "[-_-*]";
        f2589a[4] = "[B)]";
        f2589a[5] = "[:-\"]";
        f2589a[6] = "[v]";
        f2589a[7] = "[:-,]";
        f2589a[8] = "[%OD]";
        f2589a[9] = "[d:]";
        f2589a[10] = "[^^]";
        f2589a[11] = "[spicy]";
        f2589a[12] = "[AF]";
        f2589a[13] = "[IF]";
        f2589a[14] = "[8-0]";
        f2589a[15] = "[,_@]";
        f2589a[16] = "[:-S]";
        f2589a[17] = "[=:O]";
        f2589a[18] = "[~_~]";
        f2589a[19] = "[2S2]";
        f2589a[20] = "[b-(]";
        f2589a[21] = "[:-}]";
        f2589a[22] = "[=.=]";
        f2589a[23] = "[:-o]";
        f2589a[24] = "[:-~~~]";
        f2589a[25] = "['-3-]";
        f2589a[26] = "[3S2]";
        f2589a[27] = "[s$]";
        f2589a[28] = "[w*]";
        f2589a[29] = "[+-_-]";
        f2589a[30] = "[:(]";
        f2589a[31] = "[DF]";
        f2589a[32] = "[#]";
        f2589a[33] = "[:-L]";
        f2589a[34] = "[UT]";
        f2589a[35] = "[>:-<]";
        f2589a[36] = "[X-[]";
        f2589a[37] = "[X-(]";
        f2589a[38] = "[spit]";
        f2589a[39] = "[-_-]";
        f2589a[40] = "[:'(]";
        f2589a[41] = "[FF]";
        f2589a[42] = "[tears]";
        f2589a[43] = "[T_T]";
        f2589a[44] = "[CS]";
        f2589a[45] = "[:*(]";
        f2589a[46] = "[:-/]";
        f2589a[47] = "[):]";
        f2589a[48] = "[-_-+]";
        f2589a[49] = "[x_x]";
        f2589a[50] = "[%')]";
        f2589a[51] = "[:-`|]";
        f2589a[52] = "[-.-!]";
        f2589a[53] = "[medi]";
        f2589a[54] = "[:-(0)]";
        f2589a[55] = "[O.o]";
        f2589a[56] = "[>:-(]";
        f2589a[57] = "[:0]";
        f2589a[58] = "[~:-(]";
        f2589a[59] = "[eez]";
        f2589a[60] = "[(-.-)zzZZ]";
        f2589a[61] = "[lazy]";
        f2589a[62] = "[fussy]";
        f2589a[63] = "[>-)]";
        f2589a[64] = "[8-X]";
        f2589a[65] = "[crown]";
        f2589a[66] = "[~:0]";
        f2589a[67] = "[<:-)]";
        f2589a[68] = "[ghost]";
        f2589a[69] = "[angel]";
        f2589a[70] = "[devil]";
        f2589a[71] = "[j>_<]";
        f2589a[72] = "[P-(]";
        f2589a[73] = "[birthday]";
        f2589a[74] = "[8-/]";
        f2589a[75] = "[ON]";
        f2589a[76] = "[:P]";
        f2589a[77] = "[*B)]";
        f2589a[78] = "[hot]";
        f2589a[79] = "[..x]";
        f2589a[80] = "[^^>]";
        f2589a[81] = "[~~*]";
        f2589a[82] = "[7:]";
        f2589a[83] = "[6:]";
        f2589a[84] = "[4:]";
        f2589a[85] = "[@]";
        f2589a[86] = "[r=3]";
        f2589a[87] = "[k><]";
        f2589a[88] = "[p_ _;]";
        f2589a[89] = "[\"o.o.]";
        f2589a[90] = "[8->]";
        f2589a[91] = "[:$s]";
        f2589a[92] = "[coffee]";
        f2589a[93] = "[u@--]";
        f2589a[94] = "[Glass]";
        f2589a[95] = "[$:]";
        f2589a[96] = "[5(ll)]";
        f2589a[97] = "[}}=]";
        f2589a[98] = "[i*(((=]";
        f2589a[99] = "[hm]";
        f2589a[100] = "[l3]";
        f2589a[101] = "[o:]";
        f2589a[102] = "[apple]";
        f2589a[103] = "[dough nut]";
        f2589a[104] = "[cookie]";
        f2589a[105] = "[straw berry]";
        f2589a[106] = "[biscuit]";
        f2589a[107] = "[cherry]";
        f2589a[108] = "[hotdog]";
        f2589a[109] = "[(0)]";
        f2589a[110] = "[<((<]";
        f2589a[111] = "[=:]";
        f2589a[112] = "[>:]";
        f2589a[113] = "[b-m-]";
        f2589a[114] = "[m-\"-]";
        f2589a[115] = "[:@)]";
        f2589a[116] = "[cat]";
        f2589a[117] = "[tiger]";
        f2589a[118] = "[<:3)~]";
        f2589a[119] = "[~~~~8}]";
        f2589a[120] = "[@..@]";
        f2589a[121] = "[:(|)]";
        f2589a[122] = "[Horse]";
        f2589a[123] = "[~:>]";
        f2589a[124] = "[3:-O]";
        f2589a[125] = "[Dragon]";
        f2589a[126] = "[y8]";
        f2589a[127] = "[c~]";
        f2589a[128] = "[;;]";
        f2589a[129] = "[n@]";
        f2589a[130] = "[a*]";
        f2589a[131] = "[g&S]";
        f2589a[132] = "[%]";
        f2589a[133] = "[f&F]";
        f2589a[134] = "[9&7]";
        f2589a[135] = "[{@}--]";
        f2589a[136] = "[z88]";
        f2589a[137] = "[Jol]";
        f2589a[138] = "[Tree]";
        f2589a[139] = "[popper]";
        f2589a[140] = "[Present]";
        f2589a[141] = "[socks]";
        f2589a[142] = "[1S2]";
        f2589a[143] = "[{>O]";
        f2589a[144] = "[▶◀]";
        f2589a[145] = "[ET]";
        f2589a[146] = "[Big Ben]";
        f2589a[147] = "[pyramid]";
        f2589a[148] = "[Taj Mahal]";
        f2589a[149] = "[Opera House]";
        f2589a[150] = "[Namdaemun]";
        f2589a[151] = "[moai]";
        f2589a[152] = "[acropolis]";
    }

    /* renamed from: d */
    private static void m3200d() {
        f2590b = new int[153];
        f2590b[0] = R.drawable.emoticon_1_01;
        f2590b[1] = R.drawable.emoticon_1_02;
        f2590b[2] = R.drawable.emoticon_1_03;
        f2590b[3] = R.drawable.emoticon_1_04;
        f2590b[4] = R.drawable.emoticon_1_05;
        f2590b[5] = R.drawable.emoticon_1_06;
        f2590b[6] = R.drawable.emoticon_1_07;
        f2590b[7] = R.drawable.emoticon_1_08;
        f2590b[8] = R.drawable.emoticon_1_09;
        f2590b[9] = R.drawable.emoticon_1_10;
        f2590b[10] = R.drawable.emoticon_1_11;
        f2590b[11] = R.drawable.emoticon_1_12;
        f2590b[12] = R.drawable.emoticon_1_13;
        f2590b[13] = R.drawable.emoticon_1_14;
        f2590b[14] = R.drawable.emoticon_1_15;
        f2590b[15] = R.drawable.emoticon_1_16;
        f2590b[16] = R.drawable.emoticon_1_17;
        f2590b[17] = R.drawable.emoticon_1_18;
        f2590b[18] = R.drawable.emoticon_1_19;
        f2590b[19] = R.drawable.emoticon_1_20;
        f2590b[20] = R.drawable.emoticon_1_21;
        f2590b[21] = R.drawable.emoticon_1_22;
        f2590b[22] = R.drawable.emoticon_1_23;
        f2590b[23] = R.drawable.emoticon_1_24;
        f2590b[24] = R.drawable.emoticon_1_25;
        f2590b[25] = R.drawable.emoticon_1_26;
        f2590b[26] = R.drawable.emoticon_1_27;
        f2590b[27] = R.drawable.emoticon_1_28;
        f2590b[28] = R.drawable.emoticon_1_29;
        f2590b[29] = R.drawable.emoticon_1_30;
        f2590b[30] = R.drawable.emoticon_1_31;
        f2590b[31] = R.drawable.emoticon_1_32;
        f2590b[32] = R.drawable.emoticon_1_33;
        f2590b[33] = R.drawable.emoticon_1_34;
        f2590b[34] = R.drawable.emoticon_1_35;
        f2590b[35] = R.drawable.emoticon_1_36;
        f2590b[36] = R.drawable.emoticon_1_37;
        f2590b[37] = R.drawable.emoticon_1_38;
        f2590b[38] = R.drawable.emoticon_1_39;
        f2590b[39] = R.drawable.emoticon_1_40;
        f2590b[40] = R.drawable.emoticon_1_41;
        f2590b[41] = R.drawable.emoticon_1_42;
        f2590b[42] = R.drawable.emoticon_1_43;
        f2590b[43] = R.drawable.emoticon_1_44;
        f2590b[44] = R.drawable.emoticon_1_45;
        f2590b[45] = R.drawable.emoticon_1_46;
        f2590b[46] = R.drawable.emoticon_1_47;
        f2590b[47] = R.drawable.emoticon_1_48;
        f2590b[48] = R.drawable.emoticon_1_49;
        f2590b[49] = R.drawable.emoticon_1_50;
        f2590b[50] = R.drawable.emoticon_1_51;
        f2590b[51] = R.drawable.emoticon_1_52;
        f2590b[52] = R.drawable.emoticon_1_53;
        f2590b[53] = R.drawable.emoticon_1_54;
        f2590b[54] = R.drawable.emoticon_1_55;
        f2590b[55] = R.drawable.emoticon_1_56;
        f2590b[56] = R.drawable.emoticon_1_57;
        f2590b[57] = R.drawable.emoticon_1_58;
        f2590b[58] = R.drawable.emoticon_1_59;
        f2590b[59] = R.drawable.emoticon_1_60;
        f2590b[60] = R.drawable.emoticon_1_61;
        f2590b[61] = R.drawable.emoticon_1_62;
        f2590b[62] = R.drawable.emoticon_1_63;
        f2590b[63] = R.drawable.emoticon_1_64;
        f2590b[64] = R.drawable.emoticon_1_65;
        f2590b[65] = R.drawable.emoticon_1_66;
        f2590b[66] = R.drawable.emoticon_1_67;
        f2590b[67] = R.drawable.emoticon_1_68;
        f2590b[68] = R.drawable.emoticon_1_69;
        f2590b[69] = R.drawable.emoticon_1_70;
        f2590b[70] = R.drawable.emoticon_1_71;
        f2590b[71] = R.drawable.emoticon_1_72;
        f2590b[72] = R.drawable.emoticon_1_73;
        f2590b[73] = R.drawable.emoticon_1_74;
        f2590b[74] = R.drawable.emoticon_1_75;
        f2590b[75] = R.drawable.emoticon_1_76;
        f2590b[76] = R.drawable.emoticon_1_77;
        f2590b[77] = R.drawable.emoticon_1_78;
        f2590b[78] = R.drawable.emoticon_1_79;
        f2590b[79] = R.drawable.emoticon_1_80;
        f2590b[80] = R.drawable.emoticon_1_81;
        f2590b[81] = R.drawable.emoticon_1_82;
        f2590b[82] = R.drawable.emoticon_1_83;
        f2590b[83] = R.drawable.emoticon_1_84;
        f2590b[84] = R.drawable.emoticon_1_85;
        f2590b[85] = R.drawable.emoticon_2_01;
        f2590b[86] = R.drawable.emoticon_2_02;
        f2590b[87] = R.drawable.emoticon_2_03;
        f2590b[88] = R.drawable.emoticon_2_04;
        f2590b[89] = R.drawable.emoticon_2_05;
        f2590b[90] = R.drawable.emoticon_2_06;
        f2590b[91] = R.drawable.emoticon_2_07;
        f2590b[92] = R.drawable.emoticon_3_01;
        f2590b[93] = R.drawable.emoticon_3_02;
        f2590b[94] = R.drawable.emoticon_3_03;
        f2590b[95] = R.drawable.emoticon_3_04;
        f2590b[96] = R.drawable.emoticon_3_05;
        f2590b[97] = R.drawable.emoticon_3_06;
        f2590b[98] = R.drawable.emoticon_3_07;
        f2590b[99] = R.drawable.emoticon_3_08;
        f2590b[100] = R.drawable.emoticon_3_09;
        f2590b[101] = R.drawable.emoticon_3_10;
        f2590b[102] = R.drawable.emoticon_3_11;
        f2590b[103] = R.drawable.emoticon_3_12;
        f2590b[104] = R.drawable.emoticon_3_13;
        f2590b[105] = R.drawable.emoticon_3_14;
        f2590b[106] = R.drawable.emoticon_3_15;
        f2590b[107] = R.drawable.emoticon_3_16;
        f2590b[108] = R.drawable.emoticon_3_17;
        f2590b[109] = R.drawable.emoticon_3_18;
        f2590b[110] = R.drawable.emoticon_4_01;
        f2590b[111] = R.drawable.emoticon_4_02;
        f2590b[112] = R.drawable.emoticon_4_03;
        f2590b[113] = R.drawable.emoticon_4_04;
        f2590b[114] = R.drawable.emoticon_4_05;
        f2590b[115] = R.drawable.emoticon_4_06;
        f2590b[116] = R.drawable.emoticon_4_07;
        f2590b[117] = R.drawable.emoticon_4_08;
        f2590b[118] = R.drawable.emoticon_4_09;
        f2590b[119] = R.drawable.emoticon_4_10;
        f2590b[120] = R.drawable.emoticon_4_11;
        f2590b[121] = R.drawable.emoticon_4_12;
        f2590b[122] = R.drawable.emoticon_4_13;
        f2590b[123] = R.drawable.emoticon_4_14;
        f2590b[124] = R.drawable.emoticon_4_15;
        f2590b[125] = R.drawable.emoticon_4_16;
        f2590b[126] = R.drawable.emoticon_5_01;
        f2590b[127] = R.drawable.emoticon_5_02;
        f2590b[128] = R.drawable.emoticon_5_03;
        f2590b[129] = R.drawable.emoticon_5_04;
        f2590b[130] = R.drawable.emoticon_5_05;
        f2590b[131] = R.drawable.emoticon_5_06;
        f2590b[132] = R.drawable.emoticon_5_07;
        f2590b[133] = R.drawable.emoticon_5_08;
        f2590b[134] = R.drawable.emoticon_5_09;
        f2590b[135] = R.drawable.emoticon_5_10;
        f2590b[136] = R.drawable.emoticon_6_01;
        f2590b[137] = R.drawable.emoticon_6_02;
        f2590b[138] = R.drawable.emoticon_6_03;
        f2590b[139] = R.drawable.emoticon_6_04;
        f2590b[140] = R.drawable.emoticon_6_05;
        f2590b[141] = R.drawable.emoticon_6_06;
        f2590b[142] = R.drawable.emoticon_6_07;
        f2590b[143] = R.drawable.emoticon_6_08;
        f2590b[144] = R.drawable.emoticon_6_09;
        f2590b[145] = R.drawable.emoticon_7_01;
        f2590b[146] = R.drawable.emoticon_7_02;
        f2590b[147] = R.drawable.emoticon_7_03;
        f2590b[148] = R.drawable.emoticon_7_04;
        f2590b[149] = R.drawable.emoticon_7_05;
        f2590b[150] = R.drawable.emoticon_7_06;
        f2590b[151] = R.drawable.emoticon_7_07;
        f2590b[152] = R.drawable.emoticon_7_08;
    }

    /* renamed from: e */
    private static void m3201e() {
        f2592d = new HashMap();
        for (int i = 0; i < f2590b.length; i++) {
            f2592d.put(f2589a[i], Integer.valueOf(f2590b[i]));
        }
    }
}
