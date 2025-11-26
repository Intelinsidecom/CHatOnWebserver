package com.sec.chaton.multimedia.emoticon;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.p132g.C5006b;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: EmoticonResourceManager.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.i */
/* loaded from: classes.dex */
public class C2797i {

    /* renamed from: b */
    private static SoftReference<String[]> f10109b;

    /* renamed from: c */
    private static SoftReference<Integer[]> f10110c;

    /* renamed from: d */
    private static C5006b f10111d = new C5006b(GlobalApplication.m18732r(), ".emoticon", 50);

    /* renamed from: e */
    private static C5006b f10112e = new C2796h(GlobalApplication.m18732r(), ".emoticon", 50);

    /* renamed from: a */
    private static Map<String, Integer> f10108a = new LinkedHashMap();

    static {
        f10109b = null;
        f10110c = null;
        f10109b = new SoftReference<>(null);
        f10110c = new SoftReference<>(null);
        f10108a.put("[:>]", Integer.valueOf(R.drawable.emoticon_01_01));
        f10108a.put("[*_*]", Integer.valueOf(R.drawable.emoticon_01_02));
        f10108a.put("[(:]", Integer.valueOf(R.drawable.emoticon_01_03));
        f10108a.put("[-_-*]", Integer.valueOf(R.drawable.emoticon_01_04));
        f10108a.put("[B)]", Integer.valueOf(R.drawable.emoticon_01_05));
        f10108a.put("[:-\"]", Integer.valueOf(R.drawable.emoticon_01_06));
        f10108a.put("[v]", Integer.valueOf(R.drawable.emoticon_01_07));
        f10108a.put("[:-,]", Integer.valueOf(R.drawable.emoticon_01_08));
        f10108a.put("[%OD]", Integer.valueOf(R.drawable.emoticon_01_09));
        f10108a.put("[d:]", Integer.valueOf(R.drawable.emoticon_01_10));
        f10108a.put("[^^]", Integer.valueOf(R.drawable.emoticon_01_11));
        f10108a.put("[spicy]", Integer.valueOf(R.drawable.emoticon_01_12));
        f10108a.put("[AF]", Integer.valueOf(R.drawable.emoticon_01_13));
        f10108a.put("[IF]", Integer.valueOf(R.drawable.emoticon_01_14));
        f10108a.put("[8-0]", Integer.valueOf(R.drawable.emoticon_01_15));
        f10108a.put("[,_@]", Integer.valueOf(R.drawable.emoticon_01_16));
        f10108a.put("[:-S]", Integer.valueOf(R.drawable.emoticon_01_17));
        f10108a.put("[=:O]", Integer.valueOf(R.drawable.emoticon_01_18));
        f10108a.put("[~_~]", Integer.valueOf(R.drawable.emoticon_01_19));
        f10108a.put("[2S2]", Integer.valueOf(R.drawable.emoticon_01_20));
        f10108a.put("[b-(]", Integer.valueOf(R.drawable.emoticon_01_21));
        f10108a.put("[:-}]", Integer.valueOf(R.drawable.emoticon_01_22));
        f10108a.put("[=.=]", Integer.valueOf(R.drawable.emoticon_01_23));
        f10108a.put("[:-o]", Integer.valueOf(R.drawable.emoticon_01_24));
        f10108a.put("[:-~~~]", Integer.valueOf(R.drawable.emoticon_01_25));
        f10108a.put("['-3-]", Integer.valueOf(R.drawable.emoticon_01_26));
        f10108a.put("[3S2]", Integer.valueOf(R.drawable.emoticon_01_27));
        f10108a.put("[s$]", Integer.valueOf(R.drawable.emoticon_01_28));
        f10108a.put("[w*]", Integer.valueOf(R.drawable.emoticon_01_29));
        f10108a.put("[+-_-]", Integer.valueOf(R.drawable.emoticon_01_30));
        f10108a.put("[:(]", Integer.valueOf(R.drawable.emoticon_01_31));
        f10108a.put("[DF]", Integer.valueOf(R.drawable.emoticon_01_32));
        f10108a.put("[#]", Integer.valueOf(R.drawable.emoticon_01_33));
        f10108a.put("[:-L]", Integer.valueOf(R.drawable.emoticon_01_34));
        f10108a.put("[UT]", Integer.valueOf(R.drawable.emoticon_01_35));
        f10108a.put("[>:-<]", Integer.valueOf(R.drawable.emoticon_01_36));
        f10108a.put("[X-[]", Integer.valueOf(R.drawable.emoticon_01_37));
        f10108a.put("[X-(]", Integer.valueOf(R.drawable.emoticon_01_38));
        f10108a.put("[spit]", Integer.valueOf(R.drawable.emoticon_01_39));
        f10108a.put("[-_-]", Integer.valueOf(R.drawable.emoticon_01_40));
        f10108a.put("[:'(]", Integer.valueOf(R.drawable.emoticon_01_41));
        f10108a.put("[FF]", Integer.valueOf(R.drawable.emoticon_01_42));
        f10108a.put("[tears]", Integer.valueOf(R.drawable.emoticon_01_43));
        f10108a.put("[T_T]", Integer.valueOf(R.drawable.emoticon_01_44));
        f10108a.put("[CS]", Integer.valueOf(R.drawable.emoticon_01_45));
        f10108a.put("[:*(]", Integer.valueOf(R.drawable.emoticon_01_46));
        f10108a.put("[:-/]", Integer.valueOf(R.drawable.emoticon_01_47));
        f10108a.put("[):]", Integer.valueOf(R.drawable.emoticon_01_48));
        f10108a.put("[-_-+]", Integer.valueOf(R.drawable.emoticon_01_49));
        f10108a.put("[x_x]", Integer.valueOf(R.drawable.emoticon_01_50));
        f10108a.put("[%')]", Integer.valueOf(R.drawable.emoticon_01_51));
        f10108a.put("[:-`|]", Integer.valueOf(R.drawable.emoticon_01_52));
        f10108a.put("[-.-!]", Integer.valueOf(R.drawable.emoticon_01_53));
        f10108a.put("[medi]", Integer.valueOf(R.drawable.emoticon_01_54));
        f10108a.put("[:-(0)]", Integer.valueOf(R.drawable.emoticon_01_55));
        f10108a.put("[O.o]", Integer.valueOf(R.drawable.emoticon_01_56));
        f10108a.put("[>:-(]", Integer.valueOf(R.drawable.emoticon_01_57));
        f10108a.put("[:0]", Integer.valueOf(R.drawable.emoticon_01_58));
        f10108a.put("[~:-(]", Integer.valueOf(R.drawable.emoticon_01_59));
        f10108a.put("[eez]", Integer.valueOf(R.drawable.emoticon_01_60));
        f10108a.put("[(-.-)zzZZ]", Integer.valueOf(R.drawable.emoticon_01_61));
        f10108a.put("[lazy]", Integer.valueOf(R.drawable.emoticon_01_62));
        f10108a.put("[fussy]", Integer.valueOf(R.drawable.emoticon_01_63));
        f10108a.put("[>-)]", Integer.valueOf(R.drawable.emoticon_01_64));
        f10108a.put("[8-X]", Integer.valueOf(R.drawable.emoticon_01_65));
        f10108a.put("[crown]", Integer.valueOf(R.drawable.emoticon_01_66));
        f10108a.put("[~:0]", Integer.valueOf(R.drawable.emoticon_01_67));
        f10108a.put("[<:-)]", Integer.valueOf(R.drawable.emoticon_01_68));
        f10108a.put("[ghost]", Integer.valueOf(R.drawable.emoticon_01_69));
        f10108a.put("[angel]", Integer.valueOf(R.drawable.emoticon_01_70));
        f10108a.put("[devil]", Integer.valueOf(R.drawable.emoticon_01_71));
        f10108a.put("[j>_<]", Integer.valueOf(R.drawable.emoticon_01_72));
        f10108a.put("[P-(]", Integer.valueOf(R.drawable.emoticon_01_73));
        f10108a.put("[birthday]", Integer.valueOf(R.drawable.emoticon_01_74));
        f10108a.put("[8-/]", Integer.valueOf(R.drawable.emoticon_01_75));
        f10108a.put("[ON]", Integer.valueOf(R.drawable.emoticon_01_76));
        f10108a.put("[:P]", Integer.valueOf(R.drawable.emoticon_01_77));
        f10108a.put("[*B)]", Integer.valueOf(R.drawable.emoticon_01_78));
        f10108a.put("[hot]", Integer.valueOf(R.drawable.emoticon_01_79));
        f10108a.put("[..x]", Integer.valueOf(R.drawable.emoticon_01_80));
        f10108a.put("[^^>]", Integer.valueOf(R.drawable.emoticon_01_81));
        f10108a.put("[~~*]", Integer.valueOf(R.drawable.emoticon_01_82));
        f10108a.put("[7:]", Integer.valueOf(R.drawable.emoticon_01_83));
        f10108a.put("[6:]", Integer.valueOf(R.drawable.emoticon_01_84));
        f10108a.put("[4:]", Integer.valueOf(R.drawable.emoticon_01_85));
        f10108a.put("[scissor]", Integer.valueOf(R.drawable.emoticon_01_86));
        f10108a.put("[rock]", Integer.valueOf(R.drawable.emoticon_01_87));
        f10108a.put("[paper]", Integer.valueOf(R.drawable.emoticon_01_88));
        f10108a.put("[victory]", Integer.valueOf(R.drawable.emoticon_01_89));
        f10108a.put("[okay]", Integer.valueOf(R.drawable.emoticon_01_90));
        f10108a.put("[best]", Integer.valueOf(R.drawable.emoticon_01_91));
        f10108a.put("[lowest]", Integer.valueOf(R.drawable.emoticon_01_92));
        f10108a.put("[@]", Integer.valueOf(R.drawable.emoticon_02_01));
        f10108a.put("[r=3]", Integer.valueOf(R.drawable.emoticon_02_02));
        f10108a.put("[k><]", Integer.valueOf(R.drawable.emoticon_02_03));
        f10108a.put("[p_ _;]", Integer.valueOf(R.drawable.emoticon_02_04));
        f10108a.put("[\"o.o.]", Integer.valueOf(R.drawable.emoticon_02_05));
        f10108a.put("[8->]", Integer.valueOf(R.drawable.emoticon_02_06));
        f10108a.put("[:$s]", Integer.valueOf(R.drawable.emoticon_02_07));
        f10108a.put("[coffee]", Integer.valueOf(R.drawable.emoticon_03_01));
        f10108a.put("[u@--]", Integer.valueOf(R.drawable.emoticon_03_02));
        f10108a.put("[Glass]", Integer.valueOf(R.drawable.emoticon_03_03));
        f10108a.put("[$:]", Integer.valueOf(R.drawable.emoticon_03_04));
        f10108a.put("[5(ll)]", Integer.valueOf(R.drawable.emoticon_03_05));
        f10108a.put("[}}=]", Integer.valueOf(R.drawable.emoticon_03_06));
        f10108a.put("[i*(((=]", Integer.valueOf(R.drawable.emoticon_03_07));
        f10108a.put("[hm]", Integer.valueOf(R.drawable.emoticon_03_08));
        f10108a.put("[l3]", Integer.valueOf(R.drawable.emoticon_03_09));
        f10108a.put("[o:]", Integer.valueOf(R.drawable.emoticon_03_10));
        f10108a.put("[apple]", Integer.valueOf(R.drawable.emoticon_03_11));
        f10108a.put("[dough nut]", Integer.valueOf(R.drawable.emoticon_03_12));
        f10108a.put("[cookie]", Integer.valueOf(R.drawable.emoticon_03_13));
        f10108a.put("[straw berry]", Integer.valueOf(R.drawable.emoticon_03_14));
        f10108a.put("[biscuit]", Integer.valueOf(R.drawable.emoticon_03_15));
        f10108a.put("[cherry]", Integer.valueOf(R.drawable.emoticon_03_16));
        f10108a.put("[hotdog]", Integer.valueOf(R.drawable.emoticon_03_17));
        f10108a.put("[(0)]", Integer.valueOf(R.drawable.emoticon_03_18));
        f10108a.put("[<((<]", Integer.valueOf(R.drawable.emoticon_04_01));
        f10108a.put("[=:]", Integer.valueOf(R.drawable.emoticon_04_02));
        f10108a.put("[>:]", Integer.valueOf(R.drawable.emoticon_04_03));
        f10108a.put("[b-m-]", Integer.valueOf(R.drawable.emoticon_04_04));
        f10108a.put("[m-\"-]", Integer.valueOf(R.drawable.emoticon_04_05));
        f10108a.put("[:@)]", Integer.valueOf(R.drawable.emoticon_04_06));
        f10108a.put("[cat]", Integer.valueOf(R.drawable.emoticon_04_07));
        f10108a.put("[tiger]", Integer.valueOf(R.drawable.emoticon_04_08));
        f10108a.put("[<:3)~]", Integer.valueOf(R.drawable.emoticon_04_09));
        f10108a.put("[~~~~8}]", Integer.valueOf(R.drawable.emoticon_04_10));
        f10108a.put("[@..@]", Integer.valueOf(R.drawable.emoticon_04_11));
        f10108a.put("[:(|)]", Integer.valueOf(R.drawable.emoticon_04_12));
        f10108a.put("[Horse]", Integer.valueOf(R.drawable.emoticon_04_13));
        f10108a.put("[~:>]", Integer.valueOf(R.drawable.emoticon_04_14));
        f10108a.put("[3:-O]", Integer.valueOf(R.drawable.emoticon_04_15));
        f10108a.put("[Dragon]", Integer.valueOf(R.drawable.emoticon_04_16));
        f10108a.put("[y8]", Integer.valueOf(R.drawable.emoticon_05_01));
        f10108a.put("[c~]", Integer.valueOf(R.drawable.emoticon_05_02));
        f10108a.put("[;;]", Integer.valueOf(R.drawable.emoticon_05_03));
        f10108a.put("[n@]", Integer.valueOf(R.drawable.emoticon_05_04));
        f10108a.put("[a*]", Integer.valueOf(R.drawable.emoticon_05_05));
        f10108a.put("[g&S]", Integer.valueOf(R.drawable.emoticon_05_06));
        f10108a.put("[%]", Integer.valueOf(R.drawable.emoticon_05_07));
        f10108a.put("[f&F]", Integer.valueOf(R.drawable.emoticon_05_08));
        f10108a.put("[9&7]", Integer.valueOf(R.drawable.emoticon_05_09));
        f10108a.put("[{@}--]", Integer.valueOf(R.drawable.emoticon_05_10));
        f10108a.put("[z88]", Integer.valueOf(R.drawable.emoticon_06_01));
        f10108a.put("[Jol]", Integer.valueOf(R.drawable.emoticon_06_02));
        f10108a.put("[Tree]", Integer.valueOf(R.drawable.emoticon_06_03));
        f10108a.put("[popper]", Integer.valueOf(R.drawable.emoticon_06_04));
        f10108a.put("[Present]", Integer.valueOf(R.drawable.emoticon_06_05));
        f10108a.put("[socks]", Integer.valueOf(R.drawable.emoticon_06_06));
        f10108a.put("[1S2]", Integer.valueOf(R.drawable.emoticon_06_07));
        f10108a.put("[{>O]", Integer.valueOf(R.drawable.emoticon_06_08));
        f10108a.put("[▶◀]", Integer.valueOf(R.drawable.emoticon_06_09));
        f10108a.put("[ET]", Integer.valueOf(R.drawable.emoticon_07_01));
        f10108a.put("[Big Ben]", Integer.valueOf(R.drawable.emoticon_07_02));
        f10108a.put("[pyramid]", Integer.valueOf(R.drawable.emoticon_07_03));
        f10108a.put("[Taj Mahal]", Integer.valueOf(R.drawable.emoticon_07_04));
        f10108a.put("[Opera House]", Integer.valueOf(R.drawable.emoticon_07_05));
        f10108a.put("[Namdaemun]", Integer.valueOf(R.drawable.emoticon_07_06));
        f10108a.put("[moai]", Integer.valueOf(R.drawable.emoticon_07_07));
        f10108a.put("[acropolis]", Integer.valueOf(R.drawable.emoticon_07_08));
    }

    /* renamed from: a */
    public static C5006b m11705a() {
        return f10111d;
    }

    /* renamed from: b */
    public static C5006b m11706b() {
        return f10112e;
    }

    /* renamed from: c */
    public static String[] m11707c() {
        String[] strArr = f10109b.get();
        if (strArr == null) {
            Set<String> setKeySet = f10108a.keySet();
            String[] strArr2 = new String[setKeySet.size()];
            setKeySet.toArray(strArr2);
            f10109b = new SoftReference<>(strArr2);
            return strArr2;
        }
        return strArr;
    }

    /* renamed from: a */
    public static int m11704a(String str) {
        Integer num = f10108a.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
