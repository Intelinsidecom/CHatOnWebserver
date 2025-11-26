package com.coolots.chaton.profile;

import android.os.Handler;
import com.coolots.p2pmsg.model.PhoneNoInfo;
import com.coolots.p2pmsg.model.ProfileInfo;
import com.coolots.p2pmsg.model.RefreshProfileAsk;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface ProfileManagerInterface {
    HttpAdaptor changeProfileImage(int i, byte[] bArr, byte[] bArr2, long j, Handler handler);

    void changeProfileInfo(String str, String str2, List<PhoneNoInfo> list, String str3, String str4, String str5, Handler handler);

    void deleteProfileImage(int i, long j, Handler handler);

    void deleteProfilePhoneNo(ArrayList<PhoneNoInfo> arrayList, Handler handler);

    ArrayList<PhoneNoInfo> getMyNumberList();

    ProfileInfo getProfileInfo();

    void handleRefreshProfileAsk(RefreshProfileAsk refreshProfileAsk);

    void saveProfileInfo(ProfileInfo profileInfo);

    void saveProfileInfoForUpdate(ProfileInfo profileInfo);

    void updateProfileInfo(Handler handler);
}
