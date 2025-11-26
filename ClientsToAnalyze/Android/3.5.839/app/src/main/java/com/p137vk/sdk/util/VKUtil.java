package com.p137vk.sdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.p137vk.sdk.api.VKParameters;
import com.sec.chaton.privateplugin.data.Spam;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class VKUtil {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !VKUtil.class.desiredAssertionStatus();
    }

    public static Map<String, String> explodeQueryString(String str) {
        String[] strArrSplit = str.split("&");
        HashMap map = new HashMap(strArrSplit.length);
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("=");
            map.put(strArrSplit2[0], strArrSplit2[1]);
        }
        return map;
    }

    public static String fileToString(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public static void stringToFile(String str, String str2) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
        }
    }

    public static String md5(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = Spam.ACTIVITY_CANCEL + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String[] getCertificateFingerprint(Context context, String str) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        int i = 0;
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                    if (!$assertionsDisabled && packageInfo.signatures == null) {
                        throw new AssertionError();
                    }
                    String[] strArr = new String[packageInfo.signatures.length];
                    Signature[] signatureArr = packageInfo.signatures;
                    int length = signatureArr.length;
                    int i2 = 0;
                    while (i < length) {
                        Signature signature = signatureArr[i];
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                        messageDigest.update(signature.toByteArray());
                        int i3 = i2 + 1;
                        strArr[i2] = toHex(messageDigest.digest());
                        i++;
                        i2 = i3;
                    }
                    return strArr;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static String toHex(byte[] bArr) {
        return String.format("%0" + (bArr.length << 1) + "X", new BigInteger(1, bArr));
    }

    public static Map<String, Object> mapFrom(Object... objArr) {
        if (objArr.length % 2 != 0) {
            Log.w("VKUtil", "Params must be paired. Last one is ignored");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(objArr.length / 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 + 1 < objArr.length) {
                if (!(objArr[i2] instanceof String)) {
                    Log.e("VK SDK", "Error while using mapFrom", new InvalidParameterSpecException("Key must be string"));
                }
                linkedHashMap.put((String) objArr[i2], objArr[i2 + 1]);
                i = i2 + 2;
            } else {
                return linkedHashMap;
            }
        }
    }

    public static VKParameters paramsFrom(Object... objArr) {
        return new VKParameters(mapFrom(objArr));
    }

    public static boolean isAppInstalled(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (!$assertionsDisabled && packageManager == null) {
                throw new AssertionError();
            }
            packageManager.getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static String getApplicationName(Context context) throws PackageManager.NameNotFoundException {
        try {
            Context applicationContext = context.getApplicationContext();
            if (!$assertionsDisabled && applicationContext == null) {
                throw new AssertionError();
            }
            PackageManager packageManager = applicationContext.getPackageManager();
            if (!$assertionsDisabled && packageManager == null) {
                throw new AssertionError();
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
        } catch (Exception e) {
            return null;
        }
    }
}
