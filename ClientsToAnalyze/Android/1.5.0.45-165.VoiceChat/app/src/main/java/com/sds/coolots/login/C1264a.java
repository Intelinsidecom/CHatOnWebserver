package com.sds.coolots.login;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.EncodingUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.model.NationalCode;
import com.sds.coolots.login.p018a.C1266b;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* renamed from: com.sds.coolots.login.a */
/* loaded from: classes.dex */
public class C1264a implements ConfigManagerInterface {

    /* renamed from: a */
    public static final String f3162a = "[ConfigManager]";

    /* renamed from: b */
    public static List f3163b = null;

    /* renamed from: c */
    public static List f3164c = null;

    /* renamed from: d */
    private final Context f3165d = MainApplication.mContext;

    /* renamed from: e */
    private final C1266b f3166e = new C1266b();

    /* renamed from: f */
    private Handler f3167f = null;

    public C1264a() throws InterruptedException {
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            return;
        }
        this.f3166e.m3057a();
    }

    /* renamed from: a */
    private List m3033a() {
        return this.f3166e.m3062c("kor".equals(this.f3165d.getResources().getConfiguration().locale.getISO3Language()) ? 1 : 2);
    }

    /* renamed from: a */
    private void m3034a(Message message) {
        if (message.arg1 == 0) {
            if (message.obj != null) {
                ((Handler) message.obj).sendEmptyMessage(10002);
            }
        } else if (message.obj != null) {
            ((Handler) message.obj).sendEmptyMessage(10003);
        }
    }

    /* renamed from: a */
    private void m3035a(String str) {
        Log.m2958e(f3162a + str);
    }

    /* renamed from: b */
    private List m3036b() {
        return this.f3166e.m3059b("kor".equals(this.f3165d.getResources().getConfiguration().locale.getISO3Language()) ? 1 : 2);
    }

    /* renamed from: b */
    private void m3037b(Message message) {
        if (message.arg1 != 0) {
            if (this.f3167f != null) {
                this.f3167f.sendEmptyMessage(EventCode.EVENT_CONF_PW_CHANGE_FAIL);
            }
        } else {
            if (message.obj instanceof String) {
                MainApplication.mPhoneManager.getLoginManager().changePassword((String) message.obj);
            }
            if (this.f3167f != null) {
                this.f3167f.sendEmptyMessage(EventCode.EVENT_CONF_PW_CHANGE_SUCCESS);
            } else {
                m3035a("no handler");
            }
        }
    }

    /* renamed from: c */
    private void m3038c(Message message) {
        switch (message.arg1) {
            case 0:
                if ((message.obj instanceof String) && MainApplication.mConfig.getSipIdSendOnly().equals(message.obj)) {
                    MainApplication.mConfig.setSipIdSendOnly("");
                    break;
                }
                break;
            default:
                MainApplication.mConfig.setSipIdSendOnly("");
                break;
        }
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public String getCountryFromIso(String str) {
        NationalCode nationalCodeM3063d = this.f3166e.m3063d(str);
        if (nationalCodeM3063d == null) {
            return null;
        }
        return nationalCodeM3063d.getcountryCode();
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public NationalCode getNationaCodeByAreaCode(String str) {
        return this.f3166e.m3061c(str);
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public NationalCode getNationaCodeFromCountryCode(String str) {
        return this.f3166e.m3055a(str);
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public NationalCode getNationaCodeFromIso2(String str) {
        return this.f3166e.m3063d(str);
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public List getNationalCodeAreaListFromMemory() {
        return f3163b;
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public List getNationalCodeFromMCC(String str) {
        return this.f3166e.m3060b(str);
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public List getNationalCodeListFromMemory() {
        return f3164c;
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public List getNationalCodeListWithoutMCC() {
        return this.f3166e.m3056a(2);
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public String getPassword(String str) {
        return EncodingUtil.getSHAHash(EncodingUtil.getCipherKey(16));
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public String getTestPassword(String str) {
        try {
            return EncodingUtil.getMd5Hash(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void initCountryCode() {
        f3164c = m3033a();
        f3163b = m3036b();
        m3035a("Get National code in local db ");
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void requestReturnPhoneNoAsk() {
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void requestServerChangePasswordAsk(String str) {
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void requestServerProfileAsk(Handler handler) {
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void requestServerProfileImgDeleteAsk(Handler handler) {
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void requestServerProfileImgUploadAsk(byte[] bArr, Handler handler) {
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void requestServerUpdateSearchableAsk(boolean z) {
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public void setConfigActivityHandler(Handler handler) {
        this.f3167f = handler;
    }

    @Override // com.sds.coolots.login.ConfigManagerInterface
    public String writeErrorLog(String str) {
        return EncodingUtil.zipToBase64WithFile(str);
    }
}
