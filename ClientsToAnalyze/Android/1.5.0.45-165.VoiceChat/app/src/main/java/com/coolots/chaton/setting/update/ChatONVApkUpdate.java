package com.coolots.chaton.setting.update;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.coolots.chaton.join.adaptor.VersionInfoAdaptor;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.model.URL;
import com.coolots.p2pmsg.model.VersionInfoAsk;
import com.coolots.p2pmsg.model.VersionInfoRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.coolotsinterface.ApkUpdateInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import java.util.List;

/* loaded from: classes.dex */
public final class ChatONVApkUpdate implements ApkUpdateInterface {
    public static final int CRITICAL_UPDATE = 3;
    public static final int MINOR_UPDATE = 2;
    public static final int NORMAL_UPDATE = 1;
    public static final int SAME_VERSION = 0;
    private static ChatONVApkUpdate instance = new ChatONVApkUpdate();
    private static String mGooglePlayURL = null;
    private static String mSamsungAppsURL = null;

    private static void logI(String message) {
        Log.m2963i("[ChatONVApkUpdate]" + message);
    }

    private static void logE(String message) {
        Log.m2958e("[ChatONVApkUpdate]" + message);
    }

    public static ChatONVApkUpdate getInstance() {
        return instance;
    }

    private ChatONVApkUpdate() {
        logI("ChatONVApkUpdate() create");
    }

    public void checkVersion(Handler handler) {
        if (handler != null) {
            VersionInfoAsk ask = new VersionInfoAsk();
            ask.setDeviceModel(ModelInfoUtil.MODEL);
            ask.setAppVersion(ModelInfoUtil.getAppVersion(MainApplication.mContext));
            ask.setAppId(MainApplication.mPhoneManager.getApplicationID());
            VersionInfoAdaptor adaptor = new VersionInfoAdaptor(ask, handler);
            adaptor.start();
        }
    }

    public int isLatestVersionNSaveVersionInfo(Message msg) {
        String latestVersion = ModelInfoUtil.getAppVersion(MainApplication.mContext);
        int retV = 0;
        if (msg.arg1 == 0 && msg.obj != null) {
            VersionInfoRep rep = (VersionInfoRep) msg.obj;
            String verName = rep.getLatestVersion();
            if (verName == null || verName.isEmpty()) {
                logI("verName is null");
            } else {
                logI("getLatestVersion : " + verName);
                logI("handleCheckVersionUpdate : " + rep.getResult());
                if (!rep.getResult().equals("0")) {
                    if (rep.getResult().equals("1")) {
                        latestVersion = verName;
                        retV = 1;
                    } else if (rep.getResult().equals("2")) {
                        latestVersion = verName;
                        retV = 2;
                    } else if (rep.getResult().equals("3")) {
                        latestVersion = verName;
                        retV = 3;
                    } else {
                        logI("version type is wrong");
                    }
                }
            }
            setDownLoadURL(change2StringArrayServer(rep.getDownloadUrlList()));
        } else {
            logI("VersionInfoAsk error");
        }
        ChatONSettingData.getInstance().setLastVersionName(latestVersion);
        return retV;
    }

    public void gotoUpdatePage() {
        if (isInstalledSamsungApps()) {
            gotoSamsungApps();
        } else if (isInstalledGooglePlay()) {
            gotoGooglePlay();
        } else if (MainApplication.mInformationActivityGenerator != null) {
            MainApplication.mInformationActivityGenerator.showInformationActivity(27);
        }
    }

    private boolean isInstalledSamsungApps() {
        return isInstalled("com.sec.android.app.samsungapps");
    }

    private boolean isInstalledGooglePlay() {
        return isInstalled("com.android.vending");
    }

    private boolean isInstalled(String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = MainApplication.mContext.getPackageManager();
        try {
            pm.getApplicationInfo(packageName, 128);
            logI("isInstalled(" + packageName + ") true");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            logE("isInstalled(" + packageName + ") false");
            return false;
        }
    }

    private void gotoSamsungApps() {
        Uri uri;
        if (mSamsungAppsURL == null || mSamsungAppsURL.isEmpty()) {
            uri = Uri.parse("samsungapps://ProductDetail/com.sec.chaton");
        } else {
            uri = Uri.parse(mSamsungAppsURL);
        }
        gotoDownLoadPage(uri);
    }

    private void gotoGooglePlay() {
        Uri uri;
        if (mGooglePlayURL == null || mGooglePlayURL.isEmpty()) {
            uri = Uri.parse("market://details?id=com.sec.chaton");
        } else {
            uri = Uri.parse(mGooglePlayURL);
        }
        gotoDownLoadPage(uri);
    }

    private void gotoDownLoadPage(Uri uri) {
        logI("gotoDownLoadPage(" + uri + ")");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(32);
            MainApplication.mContext.startActivity(intent);
        } catch (ActivityNotFoundException anfe) {
            logE("[ActivityNotFoundException] \n" + anfe);
            if (MainApplication.mInformationActivityGenerator != null) {
                MainApplication.mInformationActivityGenerator.showInformationActivity(27);
            }
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.ApkUpdateInterface
    public String[] change2StringArrayServer(Object url) {
        List<URL> urlList = (List) url;
        if (urlList == null || urlList.isEmpty() || urlList.size() != 2 || urlList.get(0) == null || urlList.get(0).getURL() == null || urlList.get(0).getURL().isEmpty() || urlList.get(1) == null || urlList.get(1).getURL() == null || urlList.get(1).getURL().isEmpty()) {
            return null;
        }
        String[] urlArray = {urlList.get(0).getURL(), urlList.get(1).getURL()};
        return urlArray;
    }

    @Override // com.sds.coolots.common.coolotsinterface.ApkUpdateInterface
    public String[] change2StringArrayEngine(String url) {
        logI("change2StringArrayEngine " + url);
        if (url == null || url.isEmpty()) {
            return null;
        }
        int start = url.indexOf("<url>");
        int end = url.indexOf("</url>");
        if (start == -1 || end == -1) {
            return null;
        }
        String[] urlList = new String[2];
        urlList[0] = url.substring("<url>".length() + start, end);
        String secondURL = url.substring("</url>".length() + end);
        if (secondURL == null || secondURL.isEmpty()) {
            return null;
        }
        int start2 = secondURL.indexOf("<url>");
        int end2 = secondURL.indexOf("</url>");
        if (start2 == -1 || end2 == -1) {
            return null;
        }
        urlList[1] = secondURL.substring("<url>".length() + start2, end2);
        logI("change2StringArrayEngine " + urlList[0] + ", " + urlList[1]);
        return urlList;
    }

    @Override // com.sds.coolots.common.coolotsinterface.ApkUpdateInterface
    public void setDownLoadURL(String[] url) {
        mSamsungAppsURL = "samsungapps://ProductDetail/com.sec.chaton";
        mGooglePlayURL = "market://details?id=com.sec.chaton";
        logI("setDownLoadURL(): ");
        if (url != null && url.length == 2) {
            if (url[0] != null && url[0].contains("samsungapps://")) {
                mSamsungAppsURL = url[0];
            } else if (url[0] != null && url[0].contains("market://")) {
                mGooglePlayURL = url[0];
            }
            if (url[1] != null && url[1].contains("samsungapps://")) {
                mSamsungAppsURL = url[1];
            } else if (url[1] != null && url[1].contains("market://")) {
                mGooglePlayURL = url[1];
            }
            logI("samsung apps url: " + mSamsungAppsURL);
            logI("google play url: " + mGooglePlayURL);
        }
    }

    public String[] getDownloadURL() {
        String[] urls = {mSamsungAppsURL, mGooglePlayURL};
        return urls;
    }
}
