package com.sec.chaton.userprofile;

import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p057e.C2227ao;
import com.sec.chaton.p057e.p058a.C2195i;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p065io.entry.inner.CoverStory;
import com.sec.chaton.p065io.entry.inner.CoverStoryAdd;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.smsplugin.p111h.C3880c;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: MyPageManager.java */
/* renamed from: com.sec.chaton.userprofile.bm */
/* loaded from: classes.dex */
public class C4754bm {

    /* renamed from: a */
    public static final String f17418a = C4754bm.class.getSimpleName();

    /* renamed from: j */
    private static String f17427j = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";

    /* renamed from: k */
    private static String f17428k = C4873ck.m18501b();

    /* renamed from: l */
    private static String f17429l = Integer.toString(CommonApplication.m18732r().getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width));

    /* renamed from: m */
    private static String f17430m = Integer.toString(CommonApplication.m18732r().getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height));

    /* renamed from: n */
    private static String f17431n = C4809aa.m18104a().m18121a("chaton_id", "");

    /* renamed from: b */
    public static String f17419b = "profile_f_mine_";

    /* renamed from: c */
    public static String f17420c = "profile_t_mine_";

    /* renamed from: d */
    public static String f17421d = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");

    /* renamed from: e */
    public static final int f17422e = (int) C3880c.m14962a(97.0f);

    /* renamed from: f */
    public static final int f17423f = (int) C3880c.m14962a(29.0f);

    /* renamed from: g */
    public static final int f17424g = (int) C3880c.m14962a(365.0f);

    /* renamed from: o */
    private static File f17432o = new File(f17428k + "/coverstory/");

    /* renamed from: h */
    public static int f17425h = C5034k.m19096b();

    /* renamed from: i */
    public static int f17426i = C5034k.m19098c();

    /* renamed from: a */
    private static boolean m18053a(String str, ImageView imageView) throws IOException {
        boolean z = false;
        if (!new File(f17427j).exists()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages No random images in file folder ", f17418a);
            }
        } else {
            String str2 = f17427j + "/coverstory/random/" + str + ".jpg";
            File file = new File(str2);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages file size is 0.", f17418a);
                    }
                    file.delete();
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f17418a);
                    }
                    z = true;
                    if (imageView != null) {
                        imageView.setImageURI(Uri.parse(str2));
                        m18059d(str);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f17418a);
                    }
                }
            } else if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f17418a);
            }
        }
        return z;
    }

    /* renamed from: d */
    private static void m18059d(String str) throws IOException {
        String str2 = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        String str3 = f17427j + "mycoverstory.jpg";
        if (C4904y.f17872b) {
            C4904y.m18639b("dirInternalPath : " + f17427j + str + ".jpg", "copyCoverStoryforMyProfile");
            C4904y.m18639b("myCoverstoryPath : " + str3, "copyCoverStoryforMyProfile");
        }
        try {
            File file = new File(str3);
            File file2 = new File(str2 + str + ".jpg");
            if (file2.length() > 0) {
                new FileOutputStream(file).close();
                C4636a.m17602a(file2, file);
            }
        } catch (FileNotFoundException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17418a);
            }
        } catch (IOException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f17418a);
            }
        }
    }

    /* renamed from: a */
    public static boolean m18052a(ImageView imageView, C2130k c2130k) {
        C4904y.m18639b("Buddy didn't set Coverstory ", f17418a);
        String strM9895a = C2195i.m9895a();
        if (strM9895a != null) {
            if (!m18053a(strM9895a, imageView)) {
                m18051a(strM9895a, f17429l, f17430m, c2130k);
            }
            C4809aa.m18108a("coverstory_contentid", strM9895a);
            c2130k.m9542b(strM9895a);
            return true;
        }
        C4904y.m18639b(" Random ERROR !!", f17418a);
        if (!new File(f17427j + "mycoverstory.jpg").exists()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("First time loadDefaultCoverStory in MypageFragment ", f17418a);
            }
            C1331gk.m7458a(imageView);
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b(" downloadRandomCoverStory in setRandomImages ", f17418a);
            }
            c2130k.m9543b(f17429l, f17430m);
        }
        return false;
    }

    /* renamed from: a */
    private static void m18051a(String str, String str2, String str3, C2130k c2130k) {
        if (c2130k != null) {
            c2130k.m9540a(str, str2, str3);
        }
        C4809aa.m18108a("coverstory_contentid", str);
    }

    /* renamed from: a */
    public static void m18047a(CoverStory coverStory, ImageView imageView, C2130k c2130k, C5007c c5007c) {
        String strM18121a = C4809aa.m18104a().m18121a("coverstory_metaid", "");
        if (coverStory.metaid != null) {
            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY previousMetaId : " + strM18121a, f17418a);
            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY coverStoryInfo.metaid : " + coverStory.metaid, f17418a);
            if (!TextUtils.isEmpty(strM18121a) && TextUtils.isEmpty(coverStory.contentid) && strM18121a.equals(coverStory.metaid)) {
                File file = new File(f17427j + "mycoverstory.jpg");
                if (file.exists() && file.length() > 0) {
                    C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same coverstory~ PASS!!!", f17418a);
                    return;
                }
                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same metaid but there is no coverstoryfile~!!!", f17418a);
            }
            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Update coverstory~!!!", f17418a);
            if (coverStory.contentid != null) {
                if (!m18053a(coverStory.contentid, imageView)) {
                    m18051a(coverStory.contentid, f17429l, f17430m, c2130k);
                }
                C4809aa.m18108a("coverstory_contentid", coverStory.contentid);
            } else {
                C4809aa.m18108a("coverstory_contentid", (String) null);
                c5007c.m19023b(imageView, new C2955a(coverStory.host + coverStory.metacontents, f17431n, "mypage", CommonApplication.m18732r(), f17427j, "mycoverstory.jpg", coverStory.metaid));
            }
            C4809aa.m18108a("mypage_coverstory_state", "updated");
            C4809aa.m18108a("coverstory_metaid", coverStory.metaid);
            return;
        }
        C4904y.m18639b("Set RandomCoverStory as randomId coverStoryInfo.metaid is null", f17418a);
        m18052a(imageView, c2130k);
    }

    /* renamed from: a */
    public static void m18049a(String str) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            if (C4904y.f17875e) {
                C4904y.m18634a("[deleteTempFolder] External Storage Is Not Available or Writable!", f17418a);
            }
            C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_sdcard_amount, 1).show();
            return;
        }
        String strM18501b = C4873ck.m18501b();
        if (strM18501b.length() == 0) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_sdcard_amount, 1).show();
            return;
        }
        try {
            String[] list = new File(strM18501b + str).list();
            if (list != null) {
                for (String str2 : list) {
                    boolean zDelete = new File(strM18501b + str + str2).delete();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[Delete File] " + strM18501b + str + str2 + " : " + zDelete, f17418a);
                    }
                }
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17418a);
            }
        }
    }

    /* renamed from: b */
    public static C4756bo m18054b(String str) {
        C4756bo c4756bo = new C4756bo();
        String[] strArrSplit = str.split("\n");
        if (strArrSplit != null) {
            for (int i = 0; i < strArrSplit.length; i++) {
                C4904y.m18646e(" strArray[" + i + "]= " + strArrSplit[i], f17418a);
            }
            if (strArrSplit.length == 3) {
                c4756bo.f17435a = strArrSplit[0].substring(0, strArrSplit[0].indexOf("/file"));
                c4756bo.f17436b = "/file/" + strArrSplit[2] + "/" + strArrSplit[1];
                C4904y.m18646e(" Coverstory Added host [" + c4756bo.f17435a + "] metacontents : " + c4756bo.f17436b, f17418a);
            }
        }
        return c4756bo;
    }

    /* renamed from: a */
    public static void m18042a(ImageView imageView) {
        new AsyncTaskC4759br(imageView).execute(new Void[0]);
    }

    /* renamed from: a */
    public static File m18041a() {
        if (!f17432o.exists()) {
            f17432o.mkdirs();
        }
        m18049a("/coverstory/");
        String str = "tmp_" + System.currentTimeMillis() + ".jpeg_";
        File file = new File(f17432o + "/", str);
        if (C4904y.f17872b) {
            C4904y.m18639b("[Create File] " + f17432o.toString() + str + " : " + file.getName(), f17418a);
        }
        return file;
    }

    /* renamed from: a */
    public static void m18048a(File file, Uri uri, ImageView imageView, CoverStoryAdd coverStoryAdd) {
        if (coverStoryAdd.metaid != null) {
            C4809aa.m18108a("mypage_coverstory_state", "updated");
            C4809aa.m18108a("coverstory_metaid", coverStoryAdd.metaid);
            if (coverStoryAdd.contentid != null) {
                if (C4904y.f17871a) {
                    C4904y.m18646e("CoverStoryControl.METHOD_ADD_COVERSTORY entry.contentid : " + coverStoryAdd.contentid, f17418a);
                }
                C4809aa.m18108a("coverstory_contentid", coverStoryAdd.contentid);
            } else {
                C4809aa.m18108a("coverstory_contentid", (String) null);
            }
        }
        if (file != null && uri != null) {
            new AsyncTaskC4758bq(file, imageView, coverStoryAdd).execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public static void m18046a(C2210x c2210x) {
        if (C4904y.f17871a) {
            C4904y.m18646e("queryProfileImage", f17418a);
        }
        c2210x.startQuery(6, null, C2227ao.f7955a, null, null, null, null);
    }

    /* renamed from: a */
    public static void m18044a(ImageView imageView, C5007c c5007c) {
        imageView.setImageDrawable(CommonApplication.m18732r().getResources().getDrawable(R.drawable.profile_photo_buddy_default));
        c5007c.m19015a((View) imageView);
        if (C4904y.f17872b) {
            C4904y.m18639b("[setDefaultImage]", f17418a);
        }
    }

    /* renamed from: b */
    public static void m18056b(ImageView imageView, C5007c c5007c) {
        imageView.setVisibility(8);
        c5007c.m19015a((View) imageView);
        if (C4904y.f17872b) {
            C4904y.m18639b("[hideProfileImage]", f17418a);
        }
    }

    /* renamed from: a */
    public static void m18043a(ImageView imageView, ImageView imageView2, ImageView imageView3, C5007c c5007c, ArrayList<C4757bp> arrayList, Handler handler) {
        if (arrayList.size() == 0) {
            m18056b(imageView, c5007c);
            m18056b(imageView2, c5007c);
            m18056b(imageView3, c5007c);
            return;
        }
        if (arrayList.size() == 1) {
            m18050a(arrayList.get(0).f17438b, arrayList.get(0).f17439c, imageView, false, c5007c, handler);
            m18056b(imageView2, c5007c);
            m18056b(imageView3, c5007c);
        } else if (arrayList.size() == 2) {
            m18050a(arrayList.get(0).f17438b, arrayList.get(0).f17439c, imageView, false, c5007c, handler);
            m18050a(arrayList.get(1).f17438b, arrayList.get(1).f17439c, imageView2, false, c5007c, handler);
            m18056b(imageView3, c5007c);
        } else if (arrayList.size() >= 3) {
            m18050a(arrayList.get(0).f17438b, arrayList.get(0).f17439c, imageView, false, c5007c, handler);
            m18050a(arrayList.get(1).f17438b, arrayList.get(1).f17439c, imageView2, false, c5007c, handler);
            m18050a(arrayList.get(2).f17438b, arrayList.get(2).f17439c, imageView3, false, c5007c, handler);
        }
    }

    /* renamed from: a */
    public static void m18050a(String str, String str2, ImageView imageView, boolean z, C5007c c5007c, Handler handler) {
        CallableC4762bu callableC4762bu;
        imageView.setVisibility(0);
        if (z) {
            callableC4762bu = new CallableC4762bu(str, str2, true, f17422e, handler);
        } else {
            callableC4762bu = new CallableC4762bu(str, str2, false, f17423f, handler);
        }
        c5007c.m19023b(imageView, callableC4762bu);
    }

    /* renamed from: b */
    public static String m18055b() {
        String strM18058c;
        String strM18121a = C4809aa.m18104a().m18121a("birthday_type", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("birthday", "");
        if (strM18121a2 == null || strM18121a2.length() == 0) {
            return "";
        }
        if ("".equals(strM18121a)) {
            strM18121a = "SHORT_HIDE";
        }
        C4904y.m18646e("setBirthDay birthday : " + strM18121a2, f17418a);
        try {
            if (strM18121a.equals("FULL") || strM18121a.equals("FULL_HIDE")) {
                strM18058c = m18058c(strM18121a2);
            } else if (!strM18121a.equals("SHORT") && !strM18121a.equals("SHORT_HIDE")) {
                strM18058c = "";
            } else {
                String[] strArrSplit = strM18121a2.split("-");
                strM18058c = m18058c(strArrSplit[1] + "-" + strArrSplit[2]);
            }
            return strM18058c;
        } catch (Exception e) {
            if (C4904y.f17872b) {
                C4904y.m18639b("setBirthDay error", f17418a);
            }
            return "";
        }
    }

    /* renamed from: c */
    public static String m18058c(String str) throws NumberFormatException {
        String strReplaceAll;
        int i;
        int i2;
        int i3;
        C4904y.m18646e("original birthday str:" + str, f17418a);
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.contains(" ") && (str.contains("-") || str.contains("/") || str.contains(".") || str.contains(","))) {
            strReplaceAll = str.replaceAll("\\s", "");
            C4904y.m18646e("trimmed birthday str:" + strReplaceAll, f17418a);
        } else {
            strReplaceAll = str;
        }
        String[] strArrSplit = strReplaceAll.split("-|\\/|\\s|\\.|\\,");
        try {
            if (strReplaceAll.length() == 10) {
                i = Integer.parseInt(strArrSplit[0]) - 1900;
                i2 = Integer.parseInt(strArrSplit[1]) - 1;
                i3 = Integer.parseInt(strArrSplit[2]);
            } else {
                i = 100;
                i2 = Integer.parseInt(strArrSplit[0]) - 1;
                i3 = Integer.parseInt(strArrSplit[1]);
            }
            try {
                String string = DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(i, i2, i3)).toString();
                if (str.length() != 10) {
                    if (string.contains(" ") && (string.contains("-") || string.contains("/") || string.contains(".") || string.contains(","))) {
                        string = string.replaceAll("\\s", "");
                    }
                    String[] strArrSplit2 = string.split("-|\\/|\\s|\\.|\\,");
                    if (strArrSplit2[0].length() == 4) {
                        return string.substring(5);
                    }
                    if (strArrSplit2[2].length() == 4) {
                        return string.substring(0, strArrSplit2[1].length() + strArrSplit2[0].length() + 1);
                    }
                    return string;
                }
                return string;
            } catch (Exception e) {
                C4904y.m18639b("change date format error", f17418a);
                return str;
            }
        } catch (Exception e2) {
            C4904y.m18639b("change date format error", f17418a);
            return str;
        }
    }

    /* renamed from: a */
    public static void m18045a(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        String strM18121a = C4809aa.m18104a().m18121a("msisdn1", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("msisdn2", "");
        String strM18121a3 = C4809aa.m18104a().m18121a("msisdn3", "");
        String strM18121a4 = C4809aa.m18104a().m18121a("msisdn4", "");
        if (!TextUtils.isEmpty(strM18121a)) {
            textView.setText("+" + strM18121a);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(strM18121a2)) {
            textView2.setText("+" + strM18121a2);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(strM18121a3)) {
            textView3.setText("+" + strM18121a3);
            textView3.setVisibility(0);
        } else {
            textView3.setVisibility(8);
        }
        if (!TextUtils.isEmpty(strM18121a4)) {
            textView4.setText("+" + strM18121a4);
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
    }
}
