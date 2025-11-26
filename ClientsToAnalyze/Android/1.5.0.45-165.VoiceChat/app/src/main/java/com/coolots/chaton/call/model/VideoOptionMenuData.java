package com.coolots.chaton.call.model;

import android.content.Context;
import android.view.Menu;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.controller.VideoShareViewController;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class VideoOptionMenuData implements DisposeInterface {
    private static final String CLASSNAME = "[VideoOptionMenuData]";
    public static final int OPT_AVATAR = 16;
    public static final int OPT_BT_HEADSET = 5;
    public static final int OPT_CARTOON_VIEW = 9;
    public static final int OPT_CHANGE_DUAL_CAMERA = 13;
    public static final int OPT_DOCS_VIEW = 42;
    public static final int OPT_EMOTI_ANI = 7;
    public static final int OPT_INVITE_BUDDIES = 3;
    public static final int OPT_LAYOUT = 43;
    public static final int OPT_MANAGE_CONFERENCE_CALL = 12;
    public static final int OPT_OPEN_CHAT_ROOM = 44;
    public static final int OPT_SEND_VIA_CHATON = 40;
    public static final int OPT_SHARE_SCREEN = 10;
    public static final int OPT_SHARE_VIEW = 11;
    public static final int OPT_SHOW_ME = 1;
    public static final int OPT_SPEAKER_OFF = 4;
    public static final int OPT_SWITCH_CALL = 6;
    public static final int OPT_SWITCH_VIDEO = 2;
    public static final int OPT_THEME_SHOT = 8;
    public static final int OPT_TRANSLATOR_OFF = 15;
    public static final int OPT_TRANSLATOR_ON = 14;
    private Context mContext;
    private LinkedHashMap<Integer, OptionMenuData> mList = new LinkedHashMap<>();

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VideoOptionMenuData(Context context) {
        this.mContext = context;
    }

    public void loadMenu(VideoShareViewController shareViewCtrl, boolean isShareScreenWaitForAccepting, boolean isShareViewStart, boolean isConference, boolean isHost, boolean isExitWaitMember, boolean isTranslatorOptionMenuEnable) {
        boolean isShareViewActive = shareViewCtrl.isActive();
        boolean isShareViewStarter = isShareViewActive ? shareViewCtrl.isStarter() : false;
        boolean isTranslator = MainApplication.mPhoneManager.isTranslateTest();
        this.mList.clear();
        if (isExitWaitMember) {
            logI("loadMenu: inviting..");
            this.mList.put(1, new OptionMenuData(0, this.mContext.getResources().getString(C0000R.string.call_menu_show_me)));
            if (!ModelInfoUtil.IS_MODEL_SCAMERA) {
                if (MainApplication.mConfig.isHostInviteOnly()) {
                    if (isHost && ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true) >= 3) {
                        this.mList.put(3, new OptionMenuData(C0000R.drawable.invite_buddy, this.mContext.getResources().getString(C0000R.string.call_btn_invite_buddy)));
                    }
                } else {
                    this.mList.put(3, new OptionMenuData(C0000R.drawable.invite_buddy, this.mContext.getResources().getString(C0000R.string.call_btn_invite_buddy)));
                }
                this.mList.put(4, new OptionMenuData(0, this.mContext.getResources().getString(C0000R.string.call_menu_speaker_off)));
            }
            this.mList.put(5, new OptionMenuData(C0000R.drawable.switch_to_headset, this.mContext.getResources().getString(C0000R.string.call_menu_switch_headset)));
            if (isConference) {
                this.mList.put(12, new OptionMenuData(C0000R.drawable.show_members, this.mContext.getResources().getString(C0000R.string.call_btn_member_list)));
                return;
            }
            return;
        }
        if ((isShareViewActive || !isShareViewStart) && !isConference) {
            logI("loadMenu: share view..");
            if (!ModelInfoUtil.IS_MODEL_SCAMERA) {
                this.mList.put(4, new OptionMenuData(0, this.mContext.getResources().getString(C0000R.string.call_menu_speaker_off)));
            }
            this.mList.put(5, new OptionMenuData(C0000R.drawable.switch_to_headset, this.mContext.getResources().getString(C0000R.string.call_menu_switch_headset)));
            if (isShareViewStarter) {
                this.mList.put(13, new OptionMenuData(C0000R.drawable.show_members, this.mContext.getResources().getString(C0000R.string.call_btn_dual_camera)));
                return;
            }
            return;
        }
        logI("loadMenu: normal");
        this.mList.put(1, new OptionMenuData(0, this.mContext.getResources().getString(C0000R.string.call_menu_show_me)));
        if (!isConference) {
            this.mList.put(2, new OptionMenuData(C0000R.drawable.switch_video, this.mContext.getResources().getString(C0000R.string.call_menu_switch_video)));
        }
        if (!ModelInfoUtil.IS_MODEL_SCAMERA) {
            if (MainApplication.mConfig.isHostInviteOnly()) {
                if (isHost && ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true) >= 3) {
                    this.mList.put(3, new OptionMenuData(C0000R.drawable.invite_buddy, this.mContext.getResources().getString(C0000R.string.call_btn_invite_buddy)));
                }
            } else {
                this.mList.put(3, new OptionMenuData(C0000R.drawable.invite_buddy, this.mContext.getResources().getString(C0000R.string.call_btn_invite_buddy)));
            }
            this.mList.put(4, new OptionMenuData(0, this.mContext.getResources().getString(C0000R.string.call_menu_speaker_off)));
        }
        this.mList.put(5, new OptionMenuData(C0000R.drawable.switch_to_headset, this.mContext.getResources().getString(C0000R.string.call_menu_switch_headset)));
        if (!isConference) {
            this.mList.put(6, new OptionMenuData(C0000R.drawable.switch_to_voice_call, this.mContext.getResources().getString(C0000R.string.call_menu_switch_voicecall)));
        }
        if (isTranslator && !isConference) {
            if (isTranslatorOptionMenuEnable) {
                this.mList.put(15, new OptionMenuData(C0000R.drawable.option_menu_translator_dim, this.mContext.getResources().getString(C0000R.string.call_btn_translator_off)));
            } else {
                this.mList.put(14, new OptionMenuData(C0000R.drawable.option_menu_translator, this.mContext.getResources().getString(C0000R.string.call_btn_translator_on)));
            }
        }
        if (!isShareScreenWaitForAccepting) {
            this.mList.put(10, new OptionMenuData(C0000R.drawable.action_bar_share_screen, this.mContext.getResources().getString(C0000R.string.call_btn_share_screen)));
        }
        if (!isShareViewActive && !isConference) {
            this.mList.put(11, new OptionMenuData(C0000R.drawable.share_camera, this.mContext.getResources().getString(C0000R.string.call_btn_share_camera)));
        }
        if (isConference) {
            this.mList.put(12, new OptionMenuData(C0000R.drawable.show_members, this.mContext.getResources().getString(C0000R.string.call_btn_member_list)));
        }
        this.mList.put(13, new OptionMenuData(C0000R.drawable.show_members, this.mContext.getResources().getString(C0000R.string.call_btn_dual_camera)));
    }

    public void setAttribute(boolean mUseAlterImage, boolean mIsSpeaker, int mIsBlueTooth, boolean mIsDualCamera) {
        setShowMe(mUseAlterImage);
        setSpeakerOff(mIsSpeaker);
        setHeadset(mIsBlueTooth);
        setDualCamera(mIsDualCamera);
    }

    private void setDualCamera(boolean isDualCamera) {
        if (this.mList.containsKey(13)) {
            logI("setDualCamera(" + isDualCamera + ")");
            if (isDualCamera) {
                this.mList.get(13).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_dual_camera_disable));
                this.mList.get(13).setIcon(C0000R.drawable.dual_camera_off_icon_selector);
            } else {
                this.mList.get(13).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_dual_camera_enable));
                this.mList.get(13).setIcon(C0000R.drawable.dual_camera_icon_selector);
            }
        }
    }

    private void setShowMe(boolean isHideme) {
        if (this.mList.containsKey(1)) {
            logI("setShowMe(" + isHideme + ")");
            if (isHideme) {
                this.mList.get(1).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_show_me));
                this.mList.get(1).setIcon(C0000R.drawable.show_me);
            } else {
                this.mList.get(1).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_hide_me));
                this.mList.get(1).setIcon(C0000R.drawable.hide_me);
            }
        }
    }

    private void setSpeakerOff(boolean isON) {
        if (this.mList.containsKey(4)) {
            logI("setSpeakerOff(" + isON + ")");
            if (isON) {
                this.mList.get(4).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_speaker_off));
                this.mList.get(4).setIcon(C0000R.drawable.speaker_off);
            } else {
                this.mList.get(4).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_speaker_on));
                this.mList.get(4).setIcon(C0000R.drawable.speaker_on);
            }
        }
    }

    public void setHeadset(int state) {
        if (this.mList.containsKey(5)) {
            logI("setHeadset(" + state + ")");
            this.mList.get(5).setEnable(state != 2);
            switch (state) {
                case 1:
                    this.mList.get(5).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_switch_speaker));
                    this.mList.get(5).setIcon(C0000R.drawable.switch_to_phone);
                    break;
                case 2:
                    this.mList.get(5).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_switch_headset));
                    this.mList.get(5).setIcon(C0000R.drawable.switch_to_headset_dim);
                    break;
                default:
                    this.mList.get(5).setTitle(this.mContext.getResources().getString(C0000R.string.call_menu_switch_headset));
                    this.mList.get(5).setIcon(C0000R.drawable.switch_to_headset);
                    break;
            }
        }
    }

    private void setSendViaChaton(boolean enable) {
    }

    private void setShareView(boolean enable) {
        if (this.mList.containsKey(11)) {
            logI("setShareViewEnable(" + enable + ")");
            this.mList.get(11).setEnable(enable);
            if (enable) {
                this.mList.get(11).setIcon(C0000R.drawable.share_camera);
            } else {
                this.mList.get(11).setIcon(C0000R.drawable.share_camera_dim);
            }
        }
    }

    private void setManageConference(boolean enable) {
        if (this.mList.containsKey(12)) {
            logI("setManageConfEnable(" + enable + ")");
            this.mList.get(12).setEnable(enable);
            if (enable) {
                this.mList.get(12).setIcon(C0000R.drawable.show_members);
            } else {
                this.mList.get(12).setIcon(C0000R.drawable.show_members_dim);
            }
        }
    }

    public void addToMenu(Menu menu) {
        menu.clear();
        Iterator<Integer> iter = this.mList.keySet().iterator();
        while (iter.hasNext()) {
            int key = iter.next().intValue();
            menu.add(0, key, 0, this.mList.get(Integer.valueOf(key)).getTitle()).setIcon(this.mList.get(Integer.valueOf(key)).getIcon());
        }
    }

    public void addToMenu(Menu menu, ArrayList<String> disableStringList) {
        menu.clear();
        Iterator<Integer> iter = this.mList.keySet().iterator();
        while (iter.hasNext()) {
            int key = iter.next().intValue();
            menu.add(0, key, 0, this.mList.get(Integer.valueOf(key)).getTitle()).setIcon(this.mList.get(Integer.valueOf(key)).getIcon());
            if (disableStringList != null && disableStringList.contains(this.mList.get(Integer.valueOf(key)).getTitle())) {
                menu.getItem(menu.size() - 1).setEnabled(false);
            }
        }
    }

    public boolean isEnabledMenu(int key) {
        logI("isEnabledMenu(" + key + ") : " + this.mList.get(Integer.valueOf(key)).isEnable());
        return this.mList.get(Integer.valueOf(key)).isEnable();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mList != null) {
            this.mList.clear();
            this.mList = null;
        }
        this.mContext = null;
    }
}
