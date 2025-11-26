package com.coolots.chaton.common.util;

import com.sds.coolots.common.controller.ConfigInterface;
import java.util.List;

/* loaded from: classes.dex */
public interface ChatOnConfigInterface extends ConfigInterface {
    public static final int CALL_STATUS_TONES_INDEX_CALL_CONNECT_TONES = 0;
    public static final int CALL_STATUS_TONES_INDEX_CALL_END_TONES = 2;
    public static final int CALL_STATUS_TONES_INDEX_MAX = 3;
    public static final int CALL_STATUS_TONES_INDEX_MINUTE_MINDER = 1;
    public static final boolean IS_ACTIVATION = true;

    String getBTAudioPathActionName();

    String getBTConnectActionName();

    String getBackupJoinCountryCode();

    String getBackupJoinUserID();

    String getBackupLinkAccount();

    String getBackupLinkCountryCode();

    String getBackupLinkEmail();

    String getBackupLinkPhoneNo();

    String getBackupLinkUserName();

    String getChatONUserNO();

    String getChatonSerialNumber();

    int getConferenceCallMaxPeopleNumP2PConf(boolean z);

    String getDeviceMACAddress();

    int getInitBitrate(boolean z);

    @Override // com.sds.coolots.common.controller.ConfigInterface
    boolean getSDCardWritable(boolean z);

    String getSMSAuthCountryCode();

    String getSMSAuthNumber();

    String getSamsugnAccoutCountryCode();

    String getSamsungAccount();

    String getSamsungAccountBirthday();

    String getSamsungAccountGUID();

    Long getSamsungAccountUserNo();

    boolean isAbsentcallNoti();

    boolean isAlwaysStartService();

    boolean isCheckShareScreenChangeVoice();

    boolean isShareScreenCopyRight();

    boolean isSkipRestrictAccessCheck();

    List<Boolean> parseStoredValueMultiSelectPopup(String str, List<Boolean> list);

    void setBackupJoinCountryCode(String str);

    void setBackupJoinUserID(String str);

    void setBackupLinkAccount(String str);

    void setBackupLinkCountryCode(String str);

    void setBackupLinkEmail(String str);

    void setBackupLinkPhoneNo(String str);

    void setBackupLinkUserName(String str);

    void setChatONUID(String str);

    void setChatONUserNO(String str);

    void setCheckShareScreenChangeVoice(boolean z);

    void setSMSAuthCountryCode(String str);

    void setSMSAuthNumber(String str);

    void setSamsungAccount(String str);

    void setSamsungAccountBirthday(String str);

    void setSamsungAccountCountryCode(String str);

    void setSamsungAccountGUID(String str);

    void setSamsungAccountUserNo(Long l);

    void setShareScreenCopyRight(boolean z);

    void setVoIPInCallAlert(boolean z);
}
