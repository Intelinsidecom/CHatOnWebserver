package com.sds.coolots.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class ModelInfoUtil {
    public static final String APPID = "CHATON_ANDROID";
    public static final String CSC_FILE_PATH = "/system/csc/sales_code.dat";
    public static final boolean IS_MODEL_ATRIX;
    public static final boolean IS_MODEL_GALAXY_S;
    public static final boolean IS_MODEL_GALAXY_S2;
    public static final boolean IS_MODEL_GALAXY_TAB_GT_N8P5;
    public static final boolean IS_MODEL_GALAXY_TAB_GT_P1000;
    public static final boolean IS_MODEL_GALAXY_TAB_KOR;
    public static final boolean IS_MODEL_H;
    public static final boolean IS_MODEL_J;
    public static final boolean IS_MODEL_MCAMERA;
    public static final boolean IS_MODEL_NEXUS_S;
    public static final boolean IS_MODEL_OPTIMUS2X;
    public static final boolean IS_MODEL_SCAMERA;
    public static final boolean IS_MODEL_UCAMERA;
    public static final String MODEL;
    public static final String OSVERSION;
    public static final String SYSTEM_OS = "ANDROID";

    /* renamed from: a */
    private static final String f3080a = "[ModelInfoUtil]";

    static {
        OSVERSION = Build.DISPLAY.length() > 50 ? Build.DISPLAY.substring(0, 49) : Build.DISPLAY;
        MODEL = Build.MODEL;
        if ("SHW-M110S".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = true;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("SHW-M250S".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = true;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("SHW-M180S".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = true;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("GT-P1000".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = true;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("GT-N8000".equals(Build.MODEL) || "GT-N8010".equals(Build.MODEL) || "GT-N8013".equals(Build.MODEL) || "GT-P5110".equals(Build.MODEL) || "GT-P5113".equals(Build.MODEL) || "SHW-M480K".equals(Build.MODEL) || "SM-P910".equals(Build.MODEL) || "SM-P905".equals(Build.MODEL) || "SM-P901".equals(Build.MODEL) || "SM-P600".equals(Build.MODEL) || "SM-P601".equals(Build.MODEL) || "SM-P605".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = true;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("Nexus S".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = true;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("LG-SU660".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = true;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("MB860".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = true;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("EK-GC100".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = true;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if ("SM-C101".equals(Build.MODEL)) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = true;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else if (m2975a()) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = true;
            IS_MODEL_H = false;
        } else if (m2977b()) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = true;
        } else if (m2978c()) {
            IS_MODEL_GALAXY_S = false;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = true;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        } else {
            IS_MODEL_GALAXY_S = true;
            IS_MODEL_GALAXY_S2 = false;
            IS_MODEL_GALAXY_TAB_KOR = false;
            IS_MODEL_GALAXY_TAB_GT_P1000 = false;
            IS_MODEL_GALAXY_TAB_GT_N8P5 = false;
            IS_MODEL_NEXUS_S = false;
            IS_MODEL_OPTIMUS2X = false;
            IS_MODEL_ATRIX = false;
            IS_MODEL_SCAMERA = false;
            IS_MODEL_MCAMERA = false;
            IS_MODEL_UCAMERA = false;
            IS_MODEL_J = false;
            IS_MODEL_H = false;
        }
        m2976b("IS_MODEL_SCAMERA is " + IS_MODEL_SCAMERA);
    }

    /* renamed from: a */
    private static void m2974a(String str) {
        Log.m2958e(f3080a + str);
    }

    /* renamed from: a */
    private static boolean m2975a() {
        return "GT-I9500".equals(Build.MODEL) || "SAMSUNG-SC-02F".equals(Build.MODEL) || "SC-02F".equals(Build.MODEL) || "SAMSUNG-GT-I9500".equals(Build.MODEL) || "GT-I9505".equals(Build.MODEL) || "SAMSUNG-GT-I9505".equals(Build.MODEL) || "GT-I9506".equals(Build.MODEL) || "SAMSUNG-GT-I9506".equals(Build.MODEL) || "SAMSUNG-SGH-I337".equals(Build.MODEL) || "SGH-I337".equals(Build.MODEL) || "SAMSUNG-SPH-L720".equals(Build.MODEL) || "SAMSUNG-SPH-L720T".equals(Build.MODEL) || "SPH-L720".equals(Build.MODEL) || "SPH-L720T".equals(Build.MODEL) || "SAMSUNG-SGH-M919".equals(Build.MODEL) || "SGH-M919".equals(Build.MODEL) || "SAMSUNG-SCH-R970".equals(Build.MODEL) || "SCH-R970".equals(Build.MODEL) || "SAMSUNG-SCH-I545".equals(Build.MODEL) || "SCH-I545".equals(Build.MODEL) || "SGH-I337Z".equals(Build.MODEL) || "SAMSUNG-SGH-I337Z".equals(Build.MODEL) || "SAMSUNG-SCH-R970C".equals(Build.MODEL) || "SCH-R970C".equals(Build.MODEL) || "SHV-E330S".equals(Build.MODEL) || "SHV-E330K".equals(Build.MODEL) || "SHV-E330L".equals(Build.MODEL) || "SAMSUNG-SHV-E330S".equals(Build.MODEL) || "SAMSUNG-SHV-E330K".equals(Build.MODEL) || "SAMSUNG-SHV-E330L".equals(Build.MODEL) || "SAMSUNG-SCH-R343".equals(Build.MODEL) || "SCH-R343".equals(Build.MODEL) || "SCH-R970X".equals(Build.MODEL) || "SAMSUNG-SCH-R970X".equals(Build.MODEL) || "SAMSUNG-SGH-M919N".equals(Build.MODEL) || "SGH-M919N".equals(Build.MODEL) || "SAMSUNG-SC-04E".equals(Build.MODEL) || "SAMSUNG-SGH-N045".equals(Build.MODEL) || "SC-04E".equals(Build.MODEL) || "SGH-N045".equals(Build.MODEL) || "SAMSUNG-SGH-I337M".equals(Build.MODEL) || "SGH-I337M".equals(Build.MODEL) || "SAMSUNG-SGH-M919V".equals(Build.MODEL) || "SGH-M919V".equals(Build.MODEL) || "SAMSUNG-SHV-E300K".equals(Build.MODEL) || "SHV-E300K".equals(Build.MODEL) || "SAMSUNG-SHV-E300L".equals(Build.MODEL) || "SHV-E300L".equals(Build.MODEL) || "SAMSUNG-SHV-E300S".equals(Build.MODEL) || "SHV-E300S".equals(Build.MODEL) || "GT-I9515".equals(Build.MODEL);
    }

    /* renamed from: b */
    private static void m2976b(String str) {
        Log.m2963i(f3080a + str);
    }

    /* renamed from: b */
    private static boolean m2977b() {
        return "SM-N900".equals(Build.MODEL) || "SAMSUNG-SM-N900".equals(Build.MODEL) || "SM-N900X".equals(Build.MODEL) || "SAMSUNG-SM-N900X".equals(Build.MODEL) || "SM-N9005".equals(Build.MODEL) || "SAMSUNG-SM-N9005".equals(Build.MODEL) || "SM-N9007".equals(Build.MODEL) || "SAMSUNG-SM-N9007".equals(Build.MODEL) || "SM-N900A".equals(Build.MODEL) || "SAMSUNG-SM-N900A".equals(Build.MODEL) || "SM-N900P".equals(Build.MODEL) || "SAMSUNG-SM-N900P".equals(Build.MODEL) || "SM-N900T".equals(Build.MODEL) || "SAMSUNG-SM-N900T".equals(Build.MODEL) || "SM-N900R4".equals(Build.MODEL) || "SAMSUNG-SM-N900R4".equals(Build.MODEL) || "SM-N900V".equals(Build.MODEL) || "SAMSUNG-SM-N900V".equals(Build.MODEL) || "SM-N900W9".equals(Build.MODEL) || "SAMSUNG-SM-N900W9".equals(Build.MODEL) || "SAMSUNG-SC-01F".equals(Build.MODEL) || "SAMSUNG-SCL22".equals(Build.MODEL) || "SC-01F".equals(Build.MODEL) || "SCL22".equals(Build.MODEL) || "SM-N900J".equals(Build.MODEL) || "SAMSUNG-SM-N900J".equals(Build.MODEL) || "SM-N900D".equals(Build.MODEL) || "SAMSUNG-SM-N900D".equals(Build.MODEL) || "SM-N900W8".equals(Build.MODEL) || "SAMSUNG-SM-N900W8".equals(Build.MODEL) || "SM-N9000Q".equals(Build.MODEL) || "SAMSUNG-SM-N9000Q".equals(Build.MODEL) || "SM-N900K".equals(Build.MODEL) || "SAMSUNG-SM-N900K".equals(Build.MODEL) || "SM-N900L".equals(Build.MODEL) || "SAMSUNG-SM-N900L".equals(Build.MODEL) || "SM-N900S".equals(Build.MODEL) || "SAMSUNG-SM-N900S".equals(Build.MODEL) || "SM-N900T_NA_TMB".equals(Build.MODEL) || "SM-N900P_NA_SPR".equals(Build.MODEL) || "SM-N900R4_NA_USC".equals(Build.MODEL) || "SM-N900V_NA_VZW".equals(Build.MODEL);
    }

    /* renamed from: c */
    private static boolean m2978c() {
        return "EK-GN120".equals(Build.MODEL) || "SAMSUNG-EK-GN120".equals(Build.MODEL);
    }

    public static String getAppVersion(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            str = "0.0";
            e.printStackTrace();
        }
        return str.length() > 10 ? str.substring(0, 10) : str;
    }

    public static String getCSC() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        String str = null;
        try {
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(CSC_FILE_PATH)));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            m2976b("CSC is " + str);
                            try {
                                bufferedReader2.close();
                                return str;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return str;
                            }
                        }
                        m2976b("CSC read " + line);
                        str = line;
                    } catch (FileNotFoundException e2) {
                        bufferedReader3 = bufferedReader2;
                        try {
                            m2974a("FileNotFoundException");
                            try {
                                bufferedReader3.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return "";
                        } catch (Throwable th2) {
                            bufferedReader = bufferedReader3;
                            th = th2;
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        m2974a("IOException");
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        return "";
                    }
                }
            } catch (FileNotFoundException e7) {
            } catch (IOException e8) {
                bufferedReader2 = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                bufferedReader.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader.close();
            throw th;
        }
    }
}
