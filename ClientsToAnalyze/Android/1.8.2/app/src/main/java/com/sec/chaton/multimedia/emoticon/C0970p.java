package com.sec.chaton.multimedia.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.sec.chaton.R;
import java.util.HashMap;
import twitter4j.MediaEntity;

/* compiled from: RichString.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.p */
/* loaded from: classes.dex */
public class C0970p extends SpannableStringBuilder {

    /* renamed from: a */
    public static String[] f3556a;

    /* renamed from: b */
    public static int[] f3557b;

    /* renamed from: c */
    protected static int[][] f3558c;

    /* renamed from: d */
    private static HashMap f3559d;

    /* renamed from: e */
    private static C0969o f3560e = null;

    static {
        m3829a();
        f3558c = new int[][]{new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, MediaEntity.Size.CROP, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}, new int[]{1, 24, 47, 69, 90, 2, 25, 48, 70, 91, 3, 26, 49, 71, 92, 4, 27, 50, 72, 93, 5, 28, 51, 73, 94, 6, 29, 52, 74, 95, 7, 30, 53, 75, 96, 8, 31, 54, 76, 97, 9, 32, 55, 77, 10, 33, 56, 78, 11, 34, 57, 79}};
    }

    public C0970p(Resources resources, String str, int i) throws Resources.NotFoundException {
        super(str);
        m3830a(resources, str, i);
    }

    /* renamed from: a */
    private void m3830a(Resources resources, String str, int i) throws Resources.NotFoundException {
        if (f3556a != null && f3557b != null) {
            for (int i2 = 0; i2 < f3556a.length; i2++) {
                String str2 = f3556a[i2];
                if (str2 != null && !"".equals(str2)) {
                    int length = str2.length();
                    int i3 = f3557b[i2];
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
    public void m3834a(EditText editText) {
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        int length = 2000 - (editText.length() - (selectionEnd - selectionStart));
        if (length >= length()) {
            editText.getEditableText().replace(selectionStart, selectionEnd, this, 0, length());
            editText.setSelection(length() + selectionStart, selectionStart + length());
        } else {
            editText.getEditableText().replace(selectionStart, selectionEnd, this, 0, length);
            editText.setSelection(selectionStart + length, selectionStart + length);
        }
    }

    /* renamed from: a */
    private static void m3829a() {
        m3831b();
        m3832c();
        m3833d();
    }

    /* renamed from: b */
    private static void m3831b() {
        f3556a = new String[153];
        f3556a[0] = "[:>]";
        f3556a[1] = "[*_*]";
        f3556a[2] = "[(:]";
        f3556a[3] = "[-_-*]";
        f3556a[4] = "[B)]";
        f3556a[5] = "[:-\"]";
        f3556a[6] = "[v]";
        f3556a[7] = "[:-,]";
        f3556a[8] = "[%OD]";
        f3556a[9] = "[d:]";
        f3556a[10] = "[^^]";
        f3556a[11] = "[spicy]";
        f3556a[12] = "[AF]";
        f3556a[13] = "[IF]";
        f3556a[14] = "[8-0]";
        f3556a[15] = "[,_@]";
        f3556a[16] = "[:-S]";
        f3556a[17] = "[=:O]";
        f3556a[18] = "[~_~]";
        f3556a[19] = "[2S2]";
        f3556a[20] = "[b-(]";
        f3556a[21] = "[:-}]";
        f3556a[22] = "[=.=]";
        f3556a[23] = "[:-o]";
        f3556a[24] = "[:-~~~]";
        f3556a[25] = "['-3-]";
        f3556a[26] = "[3S2]";
        f3556a[27] = "[s$]";
        f3556a[28] = "[w*]";
        f3556a[29] = "[+-_-]";
        f3556a[30] = "[:(]";
        f3556a[31] = "[DF]";
        f3556a[32] = "[#]";
        f3556a[33] = "[:-L]";
        f3556a[34] = "[UT]";
        f3556a[35] = "[>:-<]";
        f3556a[36] = "[X-[]";
        f3556a[37] = "[X-(]";
        f3556a[38] = "[spit]";
        f3556a[39] = "[-_-]";
        f3556a[40] = "[:'(]";
        f3556a[41] = "[FF]";
        f3556a[42] = "[tears]";
        f3556a[43] = "[T_T]";
        f3556a[44] = "[CS]";
        f3556a[45] = "[:*(]";
        f3556a[46] = "[:-/]";
        f3556a[47] = "[):]";
        f3556a[48] = "[-_-+]";
        f3556a[49] = "[x_x]";
        f3556a[50] = "[%')]";
        f3556a[51] = "[:-`|]";
        f3556a[52] = "[-.-!]";
        f3556a[53] = "[medi]";
        f3556a[54] = "[:-(0)]";
        f3556a[55] = "[O.o]";
        f3556a[56] = "[>:-(]";
        f3556a[57] = "[:0]";
        f3556a[58] = "[~:-(]";
        f3556a[59] = "[eez]";
        f3556a[60] = "[(-.-)zzZZ]";
        f3556a[61] = "[lazy]";
        f3556a[62] = "[fussy]";
        f3556a[63] = "[>-)]";
        f3556a[64] = "[8-X]";
        f3556a[65] = "[crown]";
        f3556a[66] = "[~:0]";
        f3556a[67] = "[<:-)]";
        f3556a[68] = "[ghost]";
        f3556a[69] = "[angel]";
        f3556a[70] = "[devil]";
        f3556a[71] = "[j>_<]";
        f3556a[72] = "[P-(]";
        f3556a[73] = "[birthday]";
        f3556a[74] = "[8-/]";
        f3556a[75] = "[ON]";
        f3556a[76] = "[:P]";
        f3556a[77] = "[*B)]";
        f3556a[78] = "[hot]";
        f3556a[79] = "[..x]";
        f3556a[80] = "[^^>]";
        f3556a[81] = "[~~*]";
        f3556a[82] = "[7:]";
        f3556a[83] = "[6:]";
        f3556a[84] = "[4:]";
        f3556a[85] = "[@]";
        f3556a[86] = "[r=3]";
        f3556a[87] = "[k><]";
        f3556a[88] = "[p_ _;]";
        f3556a[89] = "[\"o.o.]";
        f3556a[90] = "[8->]";
        f3556a[91] = "[:$s]";
        f3556a[92] = "[coffee]";
        f3556a[93] = "[u@--]";
        f3556a[94] = "[Glass]";
        f3556a[95] = "[$:]";
        f3556a[96] = "[5(ll)]";
        f3556a[97] = "[}}=]";
        f3556a[98] = "[i*(((=]";
        f3556a[99] = "[hm]";
        f3556a[100] = "[l3]";
        f3556a[101] = "[o:]";
        f3556a[102] = "[apple]";
        f3556a[103] = "[dough nut]";
        f3556a[104] = "[cookie]";
        f3556a[105] = "[straw berry]";
        f3556a[106] = "[biscuit]";
        f3556a[107] = "[cherry]";
        f3556a[108] = "[hotdog]";
        f3556a[109] = "[(0)]";
        f3556a[110] = "[<((<]";
        f3556a[111] = "[=:]";
        f3556a[112] = "[>:]";
        f3556a[113] = "[b-m-]";
        f3556a[114] = "[m-\"-]";
        f3556a[115] = "[:@)]";
        f3556a[116] = "[cat]";
        f3556a[117] = "[tiger]";
        f3556a[118] = "[<:3)~]";
        f3556a[119] = "[~~~~8}]";
        f3556a[120] = "[@..@]";
        f3556a[121] = "[:(|)]";
        f3556a[122] = "[Horse]";
        f3556a[123] = "[~:>]";
        f3556a[124] = "[3:-O]";
        f3556a[125] = "[Dragon]";
        f3556a[126] = "[y8]";
        f3556a[127] = "[c~]";
        f3556a[128] = "[;;]";
        f3556a[129] = "[n@]";
        f3556a[130] = "[a*]";
        f3556a[131] = "[g&S]";
        f3556a[132] = "[%]";
        f3556a[133] = "[f&F]";
        f3556a[134] = "[9&7]";
        f3556a[135] = "[{@}--]";
        f3556a[136] = "[z88]";
        f3556a[137] = "[Jol]";
        f3556a[138] = "[Tree]";
        f3556a[139] = "[popper]";
        f3556a[140] = "[Present]";
        f3556a[141] = "[socks]";
        f3556a[142] = "[1S2]";
        f3556a[143] = "[{>O]";
        f3556a[144] = "[▶◀]";
        f3556a[145] = "[ET]";
        f3556a[146] = "[Big Ben]";
        f3556a[147] = "[pyramid]";
        f3556a[148] = "[Taj Mahal]";
        f3556a[149] = "[Opera House]";
        f3556a[150] = "[Namdaemun]";
        f3556a[151] = "[moai]";
        f3556a[152] = "[acropolis]";
    }

    /* renamed from: c */
    private static void m3832c() {
        f3557b = new int[153];
        f3557b[0] = R.drawable.emoticon_1_01;
        f3557b[1] = R.drawable.emoticon_1_02;
        f3557b[2] = R.drawable.emoticon_1_03;
        f3557b[3] = R.drawable.emoticon_1_04;
        f3557b[4] = R.drawable.emoticon_1_05;
        f3557b[5] = R.drawable.emoticon_1_06;
        f3557b[6] = R.drawable.emoticon_1_07;
        f3557b[7] = R.drawable.emoticon_1_08;
        f3557b[8] = R.drawable.emoticon_1_09;
        f3557b[9] = R.drawable.emoticon_1_10;
        f3557b[10] = R.drawable.emoticon_1_11;
        f3557b[11] = R.drawable.emoticon_1_12;
        f3557b[12] = R.drawable.emoticon_1_13;
        f3557b[13] = R.drawable.emoticon_1_14;
        f3557b[14] = R.drawable.emoticon_1_15;
        f3557b[15] = R.drawable.emoticon_1_16;
        f3557b[16] = R.drawable.emoticon_1_17;
        f3557b[17] = R.drawable.emoticon_1_18;
        f3557b[18] = R.drawable.emoticon_1_19;
        f3557b[19] = R.drawable.emoticon_1_20;
        f3557b[20] = R.drawable.emoticon_1_21;
        f3557b[21] = R.drawable.emoticon_1_22;
        f3557b[22] = R.drawable.emoticon_1_23;
        f3557b[23] = R.drawable.emoticon_1_24;
        f3557b[24] = R.drawable.emoticon_1_25;
        f3557b[25] = R.drawable.emoticon_1_26;
        f3557b[26] = R.drawable.emoticon_1_27;
        f3557b[27] = R.drawable.emoticon_1_28;
        f3557b[28] = R.drawable.emoticon_1_29;
        f3557b[29] = R.drawable.emoticon_1_30;
        f3557b[30] = R.drawable.emoticon_1_31;
        f3557b[31] = R.drawable.emoticon_1_32;
        f3557b[32] = R.drawable.emoticon_1_33;
        f3557b[33] = R.drawable.emoticon_1_34;
        f3557b[34] = R.drawable.emoticon_1_35;
        f3557b[35] = R.drawable.emoticon_1_36;
        f3557b[36] = R.drawable.emoticon_1_37;
        f3557b[37] = R.drawable.emoticon_1_38;
        f3557b[38] = R.drawable.emoticon_1_39;
        f3557b[39] = R.drawable.emoticon_1_40;
        f3557b[40] = R.drawable.emoticon_1_41;
        f3557b[41] = R.drawable.emoticon_1_42;
        f3557b[42] = R.drawable.emoticon_1_43;
        f3557b[43] = R.drawable.emoticon_1_44;
        f3557b[44] = R.drawable.emoticon_1_45;
        f3557b[45] = R.drawable.emoticon_1_46;
        f3557b[46] = R.drawable.emoticon_1_47;
        f3557b[47] = R.drawable.emoticon_1_48;
        f3557b[48] = R.drawable.emoticon_1_49;
        f3557b[49] = R.drawable.emoticon_1_50;
        f3557b[50] = R.drawable.emoticon_1_51;
        f3557b[51] = R.drawable.emoticon_1_52;
        f3557b[52] = R.drawable.emoticon_1_53;
        f3557b[53] = R.drawable.emoticon_1_54;
        f3557b[54] = R.drawable.emoticon_1_55;
        f3557b[55] = R.drawable.emoticon_1_56;
        f3557b[56] = R.drawable.emoticon_1_57;
        f3557b[57] = R.drawable.emoticon_1_58;
        f3557b[58] = R.drawable.emoticon_1_59;
        f3557b[59] = R.drawable.emoticon_1_60;
        f3557b[60] = R.drawable.emoticon_1_61;
        f3557b[61] = R.drawable.emoticon_1_62;
        f3557b[62] = R.drawable.emoticon_1_63;
        f3557b[63] = R.drawable.emoticon_1_64;
        f3557b[64] = R.drawable.emoticon_1_65;
        f3557b[65] = R.drawable.emoticon_1_66;
        f3557b[66] = R.drawable.emoticon_1_67;
        f3557b[67] = R.drawable.emoticon_1_68;
        f3557b[68] = R.drawable.emoticon_1_69;
        f3557b[69] = R.drawable.emoticon_1_70;
        f3557b[70] = R.drawable.emoticon_1_71;
        f3557b[71] = R.drawable.emoticon_1_72;
        f3557b[72] = R.drawable.emoticon_1_73;
        f3557b[73] = R.drawable.emoticon_1_74;
        f3557b[74] = R.drawable.emoticon_1_75;
        f3557b[75] = R.drawable.emoticon_1_76;
        f3557b[76] = R.drawable.emoticon_1_77;
        f3557b[77] = R.drawable.emoticon_1_78;
        f3557b[78] = R.drawable.emoticon_1_79;
        f3557b[79] = R.drawable.emoticon_1_80;
        f3557b[80] = R.drawable.emoticon_1_81;
        f3557b[81] = R.drawable.emoticon_1_82;
        f3557b[82] = R.drawable.emoticon_1_83;
        f3557b[83] = R.drawable.emoticon_1_84;
        f3557b[84] = R.drawable.emoticon_1_85;
        f3557b[85] = R.drawable.emoticon_2_01;
        f3557b[86] = R.drawable.emoticon_2_02;
        f3557b[87] = R.drawable.emoticon_2_03;
        f3557b[88] = R.drawable.emoticon_2_04;
        f3557b[89] = R.drawable.emoticon_2_05;
        f3557b[90] = R.drawable.emoticon_2_06;
        f3557b[91] = R.drawable.emoticon_2_07;
        f3557b[92] = R.drawable.emoticon_3_01;
        f3557b[93] = R.drawable.emoticon_3_02;
        f3557b[94] = R.drawable.emoticon_3_03;
        f3557b[95] = R.drawable.emoticon_3_04;
        f3557b[96] = R.drawable.emoticon_3_05;
        f3557b[97] = R.drawable.emoticon_3_06;
        f3557b[98] = R.drawable.emoticon_3_07;
        f3557b[99] = R.drawable.emoticon_3_08;
        f3557b[100] = R.drawable.emoticon_3_09;
        f3557b[101] = R.drawable.emoticon_3_10;
        f3557b[102] = R.drawable.emoticon_3_11;
        f3557b[103] = R.drawable.emoticon_3_12;
        f3557b[104] = R.drawable.emoticon_3_13;
        f3557b[105] = R.drawable.emoticon_3_14;
        f3557b[106] = R.drawable.emoticon_3_15;
        f3557b[107] = R.drawable.emoticon_3_16;
        f3557b[108] = R.drawable.emoticon_3_17;
        f3557b[109] = R.drawable.emoticon_3_18;
        f3557b[110] = R.drawable.emoticon_4_01;
        f3557b[111] = R.drawable.emoticon_4_02;
        f3557b[112] = R.drawable.emoticon_4_03;
        f3557b[113] = R.drawable.emoticon_4_04;
        f3557b[114] = R.drawable.emoticon_4_05;
        f3557b[115] = R.drawable.emoticon_4_06;
        f3557b[116] = R.drawable.emoticon_4_07;
        f3557b[117] = R.drawable.emoticon_4_08;
        f3557b[118] = R.drawable.emoticon_4_09;
        f3557b[119] = R.drawable.emoticon_4_10;
        f3557b[120] = R.drawable.emoticon_4_11;
        f3557b[121] = R.drawable.emoticon_4_12;
        f3557b[122] = R.drawable.emoticon_4_13;
        f3557b[123] = R.drawable.emoticon_4_14;
        f3557b[124] = R.drawable.emoticon_4_15;
        f3557b[125] = R.drawable.emoticon_4_16;
        f3557b[126] = R.drawable.emoticon_5_01;
        f3557b[127] = R.drawable.emoticon_5_02;
        f3557b[128] = R.drawable.emoticon_5_03;
        f3557b[129] = R.drawable.emoticon_5_04;
        f3557b[130] = R.drawable.emoticon_5_05;
        f3557b[131] = R.drawable.emoticon_5_06;
        f3557b[132] = R.drawable.emoticon_5_07;
        f3557b[133] = R.drawable.emoticon_5_08;
        f3557b[134] = R.drawable.emoticon_5_09;
        f3557b[135] = R.drawable.emoticon_5_10;
        f3557b[136] = R.drawable.emoticon_6_01;
        f3557b[137] = R.drawable.emoticon_6_02;
        f3557b[138] = R.drawable.emoticon_6_03;
        f3557b[139] = R.drawable.emoticon_6_04;
        f3557b[140] = R.drawable.emoticon_6_05;
        f3557b[141] = R.drawable.emoticon_6_06;
        f3557b[142] = R.drawable.emoticon_6_07;
        f3557b[143] = R.drawable.emoticon_6_08;
        f3557b[144] = R.drawable.emoticon_6_09;
        f3557b[145] = R.drawable.emoticon_7_01;
        f3557b[146] = R.drawable.emoticon_7_02;
        f3557b[147] = R.drawable.emoticon_7_03;
        f3557b[148] = R.drawable.emoticon_7_04;
        f3557b[149] = R.drawable.emoticon_7_05;
        f3557b[150] = R.drawable.emoticon_7_06;
        f3557b[151] = R.drawable.emoticon_7_07;
        f3557b[152] = R.drawable.emoticon_7_08;
    }

    /* renamed from: d */
    private static void m3833d() {
        f3559d = new HashMap();
        for (int i = 0; i < f3557b.length; i++) {
            f3559d.put(f3556a[i], Integer.valueOf(f3557b[i]));
        }
    }
}
