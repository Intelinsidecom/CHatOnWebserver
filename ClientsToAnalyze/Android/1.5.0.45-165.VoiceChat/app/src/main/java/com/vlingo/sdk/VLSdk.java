package com.vlingo.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.vlingo.sdk.internal.AndroidServerDetails;
import com.vlingo.sdk.internal.VLComponentManager;
import com.vlingo.sdk.internal.audio.AudioDevice;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.deviceinfo.PhoneInfo;
import com.vlingo.sdk.internal.http.HttpManager;
import com.vlingo.sdk.internal.http.cookies.AndroidCookieJar;
import com.vlingo.sdk.internal.http.cookies.CookieJarFactory;
import com.vlingo.sdk.internal.http.cookies.CookieJarManagerSingleton;
import com.vlingo.sdk.internal.location.LocationUtils;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.settings.Settings;
import com.vlingo.sdk.internal.util.FileUtils;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.util.TimerSingleton;
import com.vlingo.sdk.internal.vlservice.AndroidVLServiceCookieManager;
import com.vlingo.sdk.recognition.VLRecognizer;
import com.vlingo.sdk.recognition.speech.VLSpeechDetector;
import com.vlingo.sdk.recognition.spotter.VLSpotter;
import com.vlingo.sdk.services.VLServices;
import com.vlingo.sdk.training.VLTrainer;
import com.vlingo.sdk.tts.VLTextToSpeech;
import com.vlingo.sdk.util.SDKDebugSettings;
import java.io.File;

/* loaded from: classes.dex */
public class VLSdk {
    public static String VERSION = "2.0.0";
    public static boolean smAssetsExtracted = false;
    private static VLSdk smInstance;
    private VLComponentManager mComponentManager;
    private SDKDebugSettings mDebugSettings;
    private boolean mIsInvalid = false;
    private boolean mLocationOn;
    private String mRecoServerURI;
    private Handler mSdkHandler;
    private String mTTSServerURI;

    public static VLSdk create(Context context, String appId, String appName, String appVersion, String appChannel, boolean locationOn, String recoServerURI, String ttsServerURI, SDKDebugSettings debugSettings) {
        if (smInstance != null) {
            throw new IllegalStateException("singelton VLSdk already exists!");
        }
        smInstance = new VLSdk(context, appId, appName, appVersion, appChannel, locationOn, recoServerURI, ttsServerURI, debugSettings);
        return smInstance;
    }

    public static VLSdk getInstance() {
        if (smInstance == null) {
            throw new IllegalStateException("VLSdk not initialized!");
        }
        return smInstance;
    }

    private VLSdk(Context context, String appId, String appName, String appVersion, String appChannel, boolean locationOn, String recoServerURI, String ttsServerURI, SDKDebugSettings debugSettings) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        if (StringUtils.isNullOrWhiteSpace(appId)) {
            throw new IllegalArgumentException("appId must be specified");
        }
        if (StringUtils.isNullOrWhiteSpace(appName)) {
            throw new IllegalArgumentException("appName must be specified");
        }
        if (StringUtils.isNullOrWhiteSpace(appVersion)) {
            throw new IllegalArgumentException("appVersion must be specified");
        }
        if (StringUtils.isNullOrWhiteSpace(appChannel)) {
            throw new IllegalArgumentException("appChannel must be specified");
        }
        if (StringUtils.isNullOrWhiteSpace(recoServerURI)) {
            throw new IllegalArgumentException("recoServerURI must be specified");
        }
        if (StringUtils.isNullOrWhiteSpace(ttsServerURI)) {
            throw new IllegalArgumentException("ttsServerURI must be specified");
        }
        HandlerThread ht = new HandlerThread("SDKWorker");
        ht.start();
        this.mSdkHandler = new Handler(ht.getLooper());
        this.mRecoServerURI = recoServerURI;
        this.mTTSServerURI = ttsServerURI;
        this.mLocationOn = locationOn;
        this.mDebugSettings = debugSettings;
        AndroidServerDetails.setServerName(recoServerURI);
        AndroidServerDetails.setTTSServerName(this.mTTSServerURI);
        ApplicationAdapter.getInstance().init(context.getApplicationContext());
        SoftwareMeta.getInstance().setAppId(appId);
        SoftwareMeta.getInstance().setAppName(appName);
        SoftwareMeta.getInstance().setAppVersion(appVersion);
        SoftwareMeta.getInstance().setAppChannel(appChannel);
        CookieJarManagerSingleton.setCookieJarManagerImpl(AndroidVLServiceCookieManager.class);
        CookieJarFactory.setCookieJarImpl(AndroidCookieJar.class);
        if (!smAssetsExtracted) {
            File libDir = context.getDir(Settings.LIB_PATH, 0);
            FileUtils.extractAssetZip(Settings.LIB_ZIP_FILENAME, libDir);
            File rawDir = context.getDir(Settings.RAW_PATH, 0);
            FileUtils.extractAssetZip(Settings.ACOUSTIC_RAW_ZIP_FILENAME, rawDir);
            FileUtils.extractAssetZip(Settings.LTS_RAW_ZIP_FILENAME, rawDir);
            smAssetsExtracted = true;
        }
        this.mComponentManager = new VLComponentManager(this.mSdkHandler);
    }

    public void destroy() {
        validateInstance();
        this.mComponentManager.destroyAll();
        ApplicationAdapter.destroy();
        SoftwareMeta.destroy();
        ClientMeta.destroy();
        AudioDevice.destroy();
        HttpManager.destroy();
        PhoneInfo.destroy();
        LocationUtils.destroy();
        TimerSingleton.destroy();
        ConnectionManager.destroy();
        CookieJarManagerSingleton.cleanup();
        CookieJarFactory.cleanup();
        this.mSdkHandler.getLooper().quit();
        this.mSdkHandler = null;
        this.mIsInvalid = true;
        smInstance = null;
    }

    public VLRecognizer getRecognizer() {
        validateInstance();
        return this.mComponentManager.getRecognizer();
    }

    public VLSpotter getSpotter() {
        validateInstance();
        return this.mComponentManager.getSpotter();
    }

    public VLSpeechDetector getSpeechDetector() {
        validateInstance();
        return this.mComponentManager.getSpeechDetector();
    }

    public VLTrainer getTrainer() {
        validateInstance();
        return this.mComponentManager.getTrainer();
    }

    public VLTextToSpeech getTextToSpeech() {
        validateInstance();
        return this.mComponentManager.getTextToSpeech();
    }

    public VLServices getVLServices() {
        validateInstance();
        return this.mComponentManager.getVLServices();
    }

    public String getRecoServerURI() {
        validateInstance();
        return this.mRecoServerURI;
    }

    public String getTTSServerURI() {
        validateInstance();
        return this.mTTSServerURI;
    }

    public boolean getLocationOn() {
        validateInstance();
        return this.mLocationOn;
    }

    public String getVersion() {
        return VERSION;
    }

    public String getDeviceID() {
        validateInstance();
        return ClientMeta.getInstance().getDeviceID();
    }

    public String getAppId() {
        return SoftwareMeta.getInstance().getAppId();
    }

    public String getAppName() {
        return SoftwareMeta.getInstance().getName();
    }

    public String getAppVersion() {
        return SoftwareMeta.getInstance().getVersion();
    }

    public String getAppChannel() {
        return SoftwareMeta.getInstance().getAppChannel();
    }

    public SDKDebugSettings getDebugSettings() {
        return this.mDebugSettings;
    }

    private void validateInstance() {
        if (this.mIsInvalid) {
            throw new IllegalStateException("VLSdk instance is no longer valid!");
        }
    }

    public void replaceRecognizer(VLRecognizer newRecognizer) {
        this.mComponentManager.replaceRecognizer(newRecognizer);
    }
}
