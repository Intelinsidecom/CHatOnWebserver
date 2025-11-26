package com.coolots.chaton.profile;

import android.os.Handler;
import com.coolots.chaton.buddy.adaptor.DeleteImageAdaptor;
import com.coolots.chaton.buddy.adaptor.UploadImageAdaptor;
import com.coolots.chaton.buddy.util.BuddyImageUtil;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.profile.adaptor.ProfileAdaptor;
import com.coolots.chaton.profile.adaptor.UnRegisterPhoneNoAdaptor;
import com.coolots.chaton.profile.adaptor.UpdateProfileAdaptor;
import com.coolots.chaton.profile.model.MyNumberDBAdaptor;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.model.PhoneNoInfo;
import com.coolots.p2pmsg.model.ProfileInfo;
import com.coolots.p2pmsg.model.RefreshProfileAsk;
import com.google.protobuf.ByteString;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ProfileManager implements ProfileManagerInterface {
    public static final String CLASSNAME = "[ProfileManager]";
    private final MyNumberDBAdaptor mDBAdaptor = new MyNumberDBAdaptor();

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public void updateProfileInfo(Handler handler) {
        ProfileAdaptor adaptor = new ProfileAdaptor(handler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public void changeProfileInfo(String userName, String statusMessage, List<PhoneNoInfo> phoneNoInfoList, String excluesMe, String showCamOnRecv, String suggestion, Handler handler) {
        ProfileInfo info = new ProfileInfo();
        if (phoneNoInfoList != null && !phoneNoInfoList.isEmpty()) {
            info.setPhoneNoList(phoneNoInfoList);
        }
        if (statusMessage != null) {
            info.setComment(statusMessage);
        }
        if (userName != null) {
            info.setUserName(userName);
        }
        if (excluesMe != null) {
            info.setExcludeMe(excluesMe);
        }
        if (suggestion != null) {
            info.setBuddySuggestion(suggestion);
        }
        if (showCamOnRecv != null) {
            info.setShowCamOnRecv(showCamOnRecv);
        }
        UpdateProfileAdaptor adaptor = new UpdateProfileAdaptor(info, handler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public HttpAdaptor changeProfileImage(int imageType, byte[] profileImage, byte[] thumbnailImage, long groupCode, Handler handler) {
        UploadImageAdaptor adaptor = new UploadImageAdaptor(imageType, profileImage != null ? ByteString.copyFrom(profileImage) : null, thumbnailImage != null ? ByteString.copyFrom(thumbnailImage) : null, groupCode, handler);
        adaptor.start();
        return adaptor;
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public void deleteProfileImage(int imageType, long groupCode, Handler handler) {
        DeleteImageAdaptor adaptor = new DeleteImageAdaptor(imageType, groupCode, handler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public ProfileInfo getProfileInfo() {
        ProfileInfo profile = new ProfileInfo();
        profile.setUserNo(ConfigActivity.getUserNo());
        profile.setUserID(ConfigActivity.getProfileUserID());
        profile.setUserName(ConfigActivity.getProfileUserName());
        profile.setEmail(ConfigActivity.getProfileUserEmail());
        profile.setComment(ConfigActivity.getProfileNickName());
        profile.setRegion(ConfigActivity.getProfileNationalCode());
        profile.setProfileUpdateDate(ConfigActivity.getProfileUpdateDate());
        profile.setPhoneNoList(this.mDBAdaptor.selectMyNumber());
        profile.setProfileImgUpdateDate(ConfigActivity.getProfileImgUpdateDate());
        profile.setVideoCallImgUpdateDate(ConfigActivity.getVideoCallImgUpdateDate());
        if (ChatONSettingData.getInstance().isUseBuddySuggestion()) {
            profile.setBuddySuggestion("Y");
        } else {
            profile.setBuddySuggestion("N");
        }
        if (ChatONSettingData.getInstance().isUseExcludeMe()) {
            profile.setExcludeMe("Y");
        } else {
            profile.setExcludeMe("N");
        }
        if (ChatONSettingData.getInstance().isOwnVideo()) {
            profile.setShowCamOnRecv("Y");
        } else {
            profile.setShowCamOnRecv("N");
        }
        return profile;
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public void handleRefreshProfileAsk(RefreshProfileAsk msg) {
        saveProfileInfo(msg.getProfileInfo());
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public void saveProfileInfoForUpdate(ProfileInfo profile) {
        if (profile != null && profile.getUserNo() == ConfigActivity.getUserNo()) {
            if (profile.getUserName() != null) {
                ConfigActivity.setProfileUserName(profile.getUserName());
            }
            if (profile.getComment() != null) {
                ConfigActivity.setProfileNickName(profile.getComment());
            }
            if (profile.getBuddySuggestion() != null) {
                if (profile.getBuddySuggestion().equals("Y")) {
                    if (!ChatONSettingData.getInstance().isUseBuddySuggestion()) {
                        ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().setBuddyUpdatedSuggestion(true);
                    }
                    ChatONSettingData.getInstance().setBuddySuggestion(true);
                } else {
                    if (ChatONSettingData.getInstance().isUseBuddySuggestion()) {
                        ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().deleteAllSuggestionBuddy();
                        ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().setBuddyUpdatedSuggestion(false);
                    }
                    ChatONSettingData.getInstance().setBuddySuggestion(false);
                }
            }
            if (profile.getExcludeMe() != null) {
                if (profile.getExcludeMe().equals("Y")) {
                    ChatONSettingData.getInstance().setExcludeMe(true);
                } else {
                    ChatONSettingData.getInstance().setExcludeMe(false);
                }
            }
            if (profile.getShowCamOnRecv() != null) {
                logE("profile.getShowCamOnRecv()");
                if (profile.getShowCamOnRecv() != null && !profile.getShowCamOnRecv().equals("Y") && profile.getShowCamOnRecv().equals("N")) {
                    ChatONSettingData.getInstance().setOwnVideo(false);
                } else {
                    ChatONSettingData.getInstance().setOwnVideo(true);
                }
            }
            this.mDBAdaptor.updatePhoneNoList(profile.getPhoneNoList());
            if (profile.getProfileUpdateDate() != null) {
                ConfigActivity.setProfileUpdateDate(profile.getProfileUpdateDate());
            }
        }
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public void saveProfileInfo(ProfileInfo profile) {
        if (profile == null) {
            logE("profile is null");
            return;
        }
        if (profile.getUserNo() != ConfigActivity.getUserNo()) {
            logE("userNo is wrong");
            return;
        }
        if (profile.getProfileUpdateDate() == null) {
            logE("<<YHT10>> [saveProfileInfo] getProfileUpdateDate is null!!");
        }
        if (profile.getProfileImgUpdateDate() == null) {
            logE("<<YHT10>> [saveProfileInfo] profileImageUpdateDate is null!!");
        } else {
            logE("<<YHT10>> [saveProfileInfo] saved:" + ConfigActivity.getProfileImgUpdateDate().getTime() + ", updated:" + profile.getProfileImgUpdateDate().getTime());
        }
        if (profile.getProfileImgUpdateDate() == null) {
            BuddyImageUtil.deleteMyImageInLocal();
        } else if (ConfigActivity.getProfileImgUpdateDate().getTime() < profile.getProfileImgUpdateDate().getTime()) {
            updateMyProfileImage();
        }
        if (profile.getVideoCallImgUpdateDate() == null) {
            BuddyImageUtil.deleteVideoCallPortraitImage();
            BuddyImageUtil.deleteVideoCallLandscapeImage();
        } else if (ConfigActivity.getVideoCallImgUpdateDate().getTime() < profile.getVideoCallImgUpdateDate().getTime()) {
            updatVideoCallPortraitImage();
            updatVideoCallLandscapeImage();
        }
        ConfigActivity.setUserNo(profile.getUserNo());
        ConfigActivity.setProfileUserID(profile.getUserID());
        ConfigActivity.setProfileUserName(profile.getUserName());
        ConfigActivity.setProfileUserEmail(profile.getEmail());
        ConfigActivity.setProfileNickName(profile.getComment());
        ConfigActivity.setProfileNationalCode(profile.getRegion());
        if (profile.getProfileUpdateDate() != null) {
            ConfigActivity.setProfileUpdateDate(profile.getProfileUpdateDate());
        }
        if (profile.getProfileImgUpdateDate() != null) {
            ConfigActivity.setProfileImgUpdateDate(profile.getProfileImgUpdateDate());
        } else {
            Date resetDate = new Date();
            resetDate.setTime(0L);
            ConfigActivity.setProfileImgUpdateDate(resetDate);
        }
        if (profile.getVideoCallImgUpdateDate() != null) {
            ConfigActivity.setVideoCallImgUpdateDate(profile.getVideoCallImgUpdateDate());
        } else {
            Date resetDate2 = new Date();
            resetDate2.setTime(0L);
            ConfigActivity.setVideoCallImgUpdateDate(resetDate2);
        }
        if (profile.getExcludeMe() != null) {
            if (profile.getExcludeMe().equals("Y")) {
                Log.m2958e("BUDDY_TRACE ProfileRep ExcludeMe is YES");
                ChatONSettingData.getInstance().setExcludeMe(true);
            } else {
                Log.m2958e("BUDDY_TRACE ProfileRep ExcludeMe is NO");
                ChatONSettingData.getInstance().setExcludeMe(false);
            }
        }
        if (profile.getBuddySuggestion() != null) {
            if (profile.getBuddySuggestion().equals("Y")) {
                Log.m2958e("BUDDY_TRACE ProfileRep buddysuggestion is YES");
                if (!ChatONSettingData.getInstance().isUseBuddySuggestion()) {
                    ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().setBuddyUpdatedSuggestion(true);
                }
                ChatONSettingData.getInstance().setBuddySuggestion(true);
            } else {
                Log.m2958e("BUDDY_TRACE ProfileRep buddysuggestion is NO");
                if (ChatONSettingData.getInstance().isUseBuddySuggestion()) {
                    ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().deleteAllSuggestionBuddy();
                    ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().setBuddyUpdatedSuggestion(false);
                }
                ChatONSettingData.getInstance().setBuddySuggestion(false);
            }
        }
        if (profile.getShowCamOnRecv() != null) {
            if (profile.getShowCamOnRecv().equals("Y")) {
                Log.m2958e("BUDDY_TRACE ProfileRep ShowCamOnRecv is YES");
                ChatONSettingData.getInstance().setOwnVideo(true);
            } else if (profile.getShowCamOnRecv().equals("N")) {
                Log.m2958e("BUDDY_TRACE ProfileRep ShowCamOnRecv is NO");
                ChatONSettingData.getInstance().setOwnVideo(false);
            }
        }
        this.mDBAdaptor.updatePhoneNoList(profile.getPhoneNoList());
    }

    private void updateMyProfileImage() {
        BuddyImageUtil.updateMyProfile();
    }

    private void updatVideoCallPortraitImage() {
        BuddyImageUtil.updateVideoCallPortrait();
    }

    private void updatVideoCallLandscapeImage() {
        BuddyImageUtil.updateVideoCallLandscape();
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public ArrayList<PhoneNoInfo> getMyNumberList() {
        return this.mDBAdaptor.selectMyNumber();
    }

    @Override // com.coolots.chaton.profile.ProfileManagerInterface
    public void deleteProfilePhoneNo(ArrayList<PhoneNoInfo> phoneNoList, Handler handler) {
        UnRegisterPhoneNoAdaptor adaptor = new UnRegisterPhoneNoAdaptor(phoneNoList, handler);
        adaptor.start();
    }
}
