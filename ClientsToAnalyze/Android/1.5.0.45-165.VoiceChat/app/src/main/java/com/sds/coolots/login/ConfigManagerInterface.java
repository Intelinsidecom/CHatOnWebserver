package com.sds.coolots.login;

import android.os.Handler;
import com.sds.coolots.login.model.NationalCode;
import java.util.List;

/* loaded from: classes.dex */
public interface ConfigManagerInterface {
    String getCountryFromIso(String str);

    NationalCode getNationaCodeByAreaCode(String str);

    NationalCode getNationaCodeFromCountryCode(String str);

    NationalCode getNationaCodeFromIso2(String str);

    List getNationalCodeAreaListFromMemory();

    List getNationalCodeFromMCC(String str);

    List getNationalCodeListFromMemory();

    List getNationalCodeListWithoutMCC();

    String getPassword(String str);

    String getTestPassword(String str);

    void initCountryCode();

    void requestReturnPhoneNoAsk();

    void requestServerChangePasswordAsk(String str);

    void requestServerProfileAsk(Handler handler);

    void requestServerProfileImgDeleteAsk(Handler handler);

    void requestServerProfileImgUploadAsk(byte[] bArr, Handler handler);

    void requestServerUpdateSearchableAsk(boolean z);

    void setConfigActivityHandler(Handler handler);

    String writeErrorLog(String str);
}
