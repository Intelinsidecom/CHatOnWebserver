package android.hardware.motion;

/* loaded from: classes.dex */
class MotionRecognitionEngineAppId {

    public enum eAPPID {
        NO_APPLICATION,
        APPID_MOTION_MODE_MAIN,
        APPID_MOTION_MODE_CAMERA,
        APPID_MOTION_MODE_MUSIC,
        APPID_MOTION_MODE_PHOTO,
        APPID_MOTION_MODE_RADIO,
        APPID_MOTION_MODE_TORCH_LIGHT,
        APPID_DICE,
        APPID_LOTTO,
        APPID_MOTION_DRIVE_GAME,
        APPID_MOTION_TUTORIAL_GAME,
        APPID_SPEAKER_PHONE_ON,
        APPID_SPEAKER_PHONE_OFF,
        APPID_MUTE_INCOMING_CALL,
        APPID_MUTE_ALARM,
        APPID_MUTE_MESSAGE_ALERT,
        APPID_MUTE_SCHEDULE_ALERT,
        APPID_MUTE_LOW_BATTERY_ALERT,
        APPID_MUTE_TIMER_ALERT,
        APPID_TIMER_ALL,
        APPID_TIMER_START,
        APPID_TIMER_PAUSE_RESTART,
        APPID_TIMER_RESET_END,
        APPID_UNLOCK_TOUCH,
        APPID_PSH_IDLE,
        APPID_PHOTO_BROWSER,
        APPID_IMAGE_VIEWER,
        APPID_BASIC_WINDOW_ROTATE,
        APPID_QUICK_VIEWER,
        APPID_WEB_BROWSER,
        APPID_DMB_PLAYER,
        APPID_WIDGET,
        APPID_BT_SHARING,
        APPID_INSTANT_START,
        APPID_INSTANT_ROTATE,
        APPID_INSTANT_TILT,
        APPID_INSTANT_LCD_UP_DOWN,
        APPID_INSTANT_NO_MOVE,
        APPID_INSTANT_END,
        APPID_MOTION_TEST_MODE,
        APPID_TEST,
        APPID_GSENSOR_DATA_ONLY,
        APPID_DISC_PLUS,
        APPID_MUSIC_PLAYER,
        APPID_VOICE_RECORDER,
        APPID_AUDIO_PLAYER,
        APPID_VIDEO_PLAYER,
        APPID_FM_RADIO,
        APPID_DBL_TO_SC,
        APPID_VOICE_COMMAND,
        APPID_KJAVA,
        APPID_DIGITAL_FRAME,
        APPID_FLASH_PLAYER,
        FINAL_APPLICATION;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static eAPPID[] valuesCustom() {
            eAPPID[] eappidArrValuesCustom = values();
            int length = eappidArrValuesCustom.length;
            eAPPID[] eappidArr = new eAPPID[length];
            System.arraycopy(eappidArrValuesCustom, 0, eappidArr, 0, length);
            return eappidArr;
        }
    }

    MotionRecognitionEngineAppId() {
    }
}
