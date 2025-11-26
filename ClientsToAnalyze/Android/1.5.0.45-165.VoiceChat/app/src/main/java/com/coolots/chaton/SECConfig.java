package com.coolots.chaton;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.KeyEvent;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.model.PhoneNoAuthRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.NativeFormatInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class SECConfig extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String AEC_DT_GCGAIN1ST = "aec_dt_gcgain1st";
    public static final String AEC_DT_GCGAIN2ST = "aec_dt_gcgain2st";
    public static final String AEC_IN_TX_GAIN = "aec_in_tx_gain";
    public static final String AEC_NSGAIN_NS = "aec_nsgain_ns";
    public static final String AEC_NS_ONOFF = "aec_ns_onoff";
    public static final String AEC_OUT_TX_GAIN = "aec_out_tx_gain";
    public static final String AEC_POST_GAIN = "aec_post_gain";
    public static final String AEC_POST_MIN = "aec_post_min";
    public static final String AEC_RX_DETHANGMAX1ST = "aec_rx_dethangmax1st";
    public static final String AEC_RX_DETHANGMAX2ST = "aec_rx_dethangmax2st";
    public static final String AEC_RX_DETTH1ST = "aec_rx_detth1st";
    public static final String AEC_RX_DETTH2ST = "aec_rx_detth2st";
    public static final String AEC_RX_GAIN = "aec_rx_gain";
    public static final String AEC_SETTING = "aec_setting";
    public static final String AEC_SPK_DT_GCGAIN1ST = "aec_spk_dt_gcgain1st";
    public static final String AEC_SPK_DT_GCGAIN2ST = "aec_spk_dt_gcgain2st";
    public static final String AEC_SPK_IN_TX_GAIN = "aec_spk_in_tx_gain";
    public static final String AEC_SPK_NSGAIN_NS = "aec_spk_nsgain_ns";
    public static final String AEC_SPK_NS_ONOFF = "aec_spk_ns_onoff";
    public static final String AEC_SPK_OUT_TX_GAIN = "aec_spk_out_tx_gain";
    public static final String AEC_SPK_POST_GAIN = "aec_spk_post_gain";
    public static final String AEC_SPK_POST_MIN = "aec_spk_post_min";
    public static final String AEC_SPK_RX_DETHANGMAX1ST = "aec_spk_rx_dethangmax1st";
    public static final String AEC_SPK_RX_DETHANGMAX2ST = "aec_spk_rx_dethangmax2st";
    public static final String AEC_SPK_RX_DETTH1ST = "aec_spk_rx_detth1st";
    public static final String AEC_SPK_RX_DETTH2ST = "aec_spk_rx_detth2st";
    public static final String AEC_SPK_RX_GAIN = "aec_spk_rx_gain";
    public static final String AEC_SPK_SETTING = "aec_spk_setting";
    public static final String AEC_SPK_SSGAIN_NS = "aec_spk_ssgain_ns";
    public static final String AEC_SPK_WEIGHT_SSNS = "aec_spk_weight_ssns";
    public static final String AEC_SSGAIN_NS = "aec_ssgain_ns";
    public static final String AEC_WEIGHT_SSNS = "aec_weight_ssns";
    public static final String AUDIO_CODEC_NAME = "set_audio_codec";
    public static final String AUDIO_CODEC_NAME_MCU = "set_audio_codec_mcu";
    public static final String AUDIO_FREQ_NAME = "set_audio_freq";
    public static final String AUDIO_FREQ_NAME_MCU = "set_audio_freq_mcu";
    public static final String AUDIO_USE_SRTP = "set_audio_srtp";
    public static final String AUDIO_USE_SRTP_MCU = "set_audio_srtp_mcu";
    public static final String RX_AGC = "rx_agc";
    public static final String RX_CNG = "rx_cng";
    public static final String RX_FILTER = "rx_filter";
    public static final String RX_LIVEVOLUME = "rx_livevolume";
    public static final String SELECT_SIP_DEST_PORT = "select_sip_dest_port";
    public static final String SPK_RX_AGC = "spk_rx_agc";
    public static final String SPK_RX_FILTER = "spk_rx_filter";
    public static final String SPK_RX_LIVEVOLUME = "spk_rx_livevolume";
    public static final String SPK_RX_VB = "spk_rx_vb";
    public static final String SPK_TX_AGC = "spk_tx_agc";
    public static final String SPK_TX_FILTER = "spk_tx_filter";
    public static final String SPK_TX_LIVEVOLUME = "spk_tx_livevolume";
    public static final String SRTP_DOMAIN_NAME = "set_srtp_domain";
    public static final String SRTP_DOMAIN_NAME_MCU = "set_srtp_domain_mcu";
    public static final String SRTP_PROXY_NAME = "set_srtp_proxy";
    public static final String SRTP_PROXY_NAME_MCU = "set_srtp_proxy_mcu";
    public static final String TX_AGC = "tx_agc";
    public static final String TX_FILTER = "tx_filter";
    public static final String TX_LIVEVOLUME = "tx_livevolume";
    public static final String USE_RX_AGC = "use_rx_agc";
    public static final String USE_RX_CNG = "use_rx_cng";
    public static final String USE_RX_FILTER = "use_rx_filter";
    public static final String USE_RX_LIVEVOLUME = "use_rx_livevolume";
    public static final String USE_SPK_RX_AGC = "use_spk_rx_agc";
    public static final String USE_SPK_RX_FILTER = "use_spk_rx_filter";
    public static final String USE_SPK_RX_LIVEVOLUME = "use_spk_rx_livevolume";
    public static final String USE_SPK_RX_VB = "use_spk_rx_vb";
    public static final String USE_SPK_TX_AEC = "use_spk_tx_aec";
    public static final String USE_SPK_TX_AGC = "use_spk_tx_agc";
    public static final String USE_SPK_TX_FILTER = "use_spk_tx_filter";
    public static final String USE_SPK_TX_LIVEVOLUME = "use_spk_tx_livevolume";
    public static final String USE_TX_AEC = "use_tx_aec";
    public static final String USE_TX_AGC = "use_tx_agc";
    public static final String USE_TX_FILTER = "use_tx_filter";
    public static final String USE_TX_LIVEVOLUME = "use_tx_livevolume";
    public static final String VIDEO_CODEC_NAME = "set_video_codec";
    public static final String VIDEO_CODEC_NAME_MCU = "set_video_codec_mcu";
    public static final String VIDEO_SAVE_STREAM = "save_videostream";
    public static final String VIDEO_SELECT_APP_ORIENT = "select_app_orient";
    public static final String VIDEO_SELECT_APP_ORIENT_MCU = "select_app_orient_mcu";
    public static final String VIDEO_SELECT_BACK_ROTATION_DIRECTION = "select_back_rotatedir";
    public static final String VIDEO_SELECT_BACK_ROTATION_DIRECTION_MCU = "select_back_rotatedir_mcu";
    public static final String VIDEO_SELECT_BITRATE = "select_bitrate";
    public static final String VIDEO_SELECT_BITRATE_3G = "select_bitrate_3g";
    public static final String VIDEO_SELECT_BITRATE_MCU = "select_bitrate_mcu";
    public static final String VIDEO_SELECT_BITRATE_MCU_3G = "select_bitrate_mcu_3g";
    public static final String VIDEO_SELECT_CAMERA = "select_camera";
    public static final String VIDEO_SELECT_CAMERA_FPS = "select_camera_fps";
    public static final String VIDEO_SELECT_CAMERA_FPS_MCU = "select_camera_fps_mcu";
    public static final String VIDEO_SELECT_CAMERA_MCU = "select_camera_mcu";
    public static final String VIDEO_SELECT_CAMERA_RESOLUTION = "select_camera_resolution";
    public static final String VIDEO_SELECT_CAMERA_RESOLUTION_MCU = "select_camera_resolution_mcu";
    public static final String VIDEO_SELECT_CAMERA_WHITEBALANCE = "select_camera_whitebalance";
    public static final String VIDEO_SELECT_CAMERA_WHITEBALANCE_MCU = "select_camera_whitebalance_mcu";
    public static final String VIDEO_SELECT_DEBUGLEVEL = "select_debuglevel";
    public static final String VIDEO_SELECT_FLIP_OPTION = "select_cameraflip";
    public static final String VIDEO_SELECT_FLIP_OPTION2 = "select_cameraflip2";
    public static final String VIDEO_SELECT_FLIP_OPTION2_MCU = "select_cameraflip2_mcu";
    public static final String VIDEO_SELECT_FLIP_OPTION_MCU = "select_cameraflip_mcu";
    public static final String VIDEO_SELECT_FPS = "select_fps";
    public static final String VIDEO_SELECT_FPS_MCU = "select_fps_mcu";
    public static final String VIDEO_SELECT_FRONT_ROTATION_DIRECTION = "select_front_rotatedir";
    public static final String VIDEO_SELECT_FRONT_ROTATION_DIRECTION_MCU = "select_front_rotatedir_mcu";
    public static final String VIDEO_SELECT_GOP = "select_gop";
    public static final String VIDEO_SELECT_GOP_MCU = "select_gop_mcu";
    public static final String VIDEO_SELECT_HEADERSPACING = "select_headerspacing";
    public static final String VIDEO_SELECT_HEADERSPACING_MCU = "select_headerspacing_mcu";
    public static final String VIDEO_SELECT_INITBITRATE = "select_initbitrate";
    public static final String VIDEO_SELECT_INITBITRATE_MCU = "select_initbitrate_mcu";
    public static final String VIDEO_SELECT_LEVEL_ID_MCU = "select_level_id_mcu";
    public static final String VIDEO_SELECT_LEVEL_ID_MCU_3G = "select_level_id_mcu_3g";
    public static final String VIDEO_SELECT_MAXBITRATE = "select_maxbitrate";
    public static final String VIDEO_SELECT_MAXBITRATE_3G = "select_maxbitrate_3g";
    public static final String VIDEO_SELECT_MAXBITRATE_MCU = "select_maxbitrate_mcu";
    public static final String VIDEO_SELECT_MAXBITRATE_MCU_3G = "select_maxbitrate_mcu_3g";
    public static final String VIDEO_SELECT_MAXFPS = "select_maxfps";
    public static final String VIDEO_SELECT_MAXFPS_MCU = "select_maxfps_mcu";
    public static final String VIDEO_SELECT_MAXRESOL = "select_maxresol";
    public static final String VIDEO_SELECT_MAXRESOL_3G = "select_maxresol_3g";
    public static final String VIDEO_SELECT_MAXRESOL_MCU = "select_maxresol_mcu";
    public static final String VIDEO_SELECT_MAXRESOL_MCU_3G = "select_maxresol_mcu_3g";
    public static final String VIDEO_SELECT_MINFPS = "select_minfps";
    public static final String VIDEO_SELECT_MINFPS_MCU = "select_minfps_mcu";
    public static final String VIDEO_SELECT_MINRESOL = "select_minresol";
    public static final String VIDEO_SELECT_MINRESOL_3G = "select_minresol_3g";
    public static final String VIDEO_SELECT_MINRESOL_MCU = "select_minresol_mcu";
    public static final String VIDEO_SELECT_MINRESOL_MCU_3G = "select_minresol_mcu_3g";
    public static final String VIDEO_SELECT_ORIENT = "select_orientation";
    public static final String VIDEO_SELECT_ORIENT_BCAMERA = "select_orientation_bcamera";
    public static final String VIDEO_SELECT_ORIENT_BCAMERA_MCU = "select_orientation_bcamera_mcu";
    public static final String VIDEO_SELECT_ORIENT_MCU = "select_orientation_mcu";
    public static final String VIDEO_SELECT_ORIENT_PREVIEW = "select_orientation_preview";
    public static final String VIDEO_SELECT_ORIENT_PREVIEW_MCU = "select_orientation_preview_mcu";
    public static final String VIDEO_SELECT_PKTMODE = "select_pktmode";
    public static final String VIDEO_SELECT_PKTMODE_MCU = "select_pktmode_mcu";
    public static final String VIDEO_SELECT_PTTYPE = "select_fec_payloadtype";
    public static final String VIDEO_SELECT_PTTYPE_MCU = "select_fec_payloadtype_mcu";
    public static final String VIDEO_SELECT_REMOTE_FPS_MCU = "select_remote_fps_mcu";
    public static final String VIDEO_SELECT_REMOTE_INITBITRATE_MCU = "select_remote_initbitrate_mcu";
    public static final String VIDEO_SELECT_REMOTE_INITBITRATE_MCU_3G = "select_remote_initbitrate_mcu_3g";
    public static final String VIDEO_SELECT_REMOTE_QUALITY_MCU = "select_remote_quality_mcu";
    public static final String VIDEO_SELECT_REMOTE_RESOL_MCU = "select_remote_resolution_mcu";
    public static final String VIDEO_SELECT_RENDER_ROTATION = "select_render_rotate";
    public static final String VIDEO_SELECT_RENDER_ROTATION_MCU = "select_render_rotate_mcu";
    public static final String VIDEO_SELECT_RESOLUTION = "select_resolution";
    public static final String VIDEO_SELECT_RESOLUTION_MCU = "select_resolution_mcu";
    public static final String VIDEO_SELECT_RTCPBANDWIDTH = "select_rtcp_bandwidth";
    public static final String VIDEO_SELECT_RTCPBANDWIDTH_MCU = "select_rtcp_bandwidth_mcu";
    public static final String VIDEO_SELECT_RTCPINTERVAL = "select_rtcp_interval";
    public static final String VIDEO_SELECT_RTCPINTERVAL_MCU = "select_rtcp_interval_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_HEIGHT = "select_sharescreen_height";
    public static final String VIDEO_SELECT_SHARESCREEN_HEIGHT_MCU = "select_sharescreen_height_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_INIT_BITRATE = "select_sharescreen_init_bitrate";
    public static final String VIDEO_SELECT_SHARESCREEN_INIT_BITRATE_MCU = "select_sharescreen_init_bitrate_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_LEVEL_ID_MCU = "select_level_id_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_MAX_BITRATE = "select_sharescreen_max_bitrate";
    public static final String VIDEO_SELECT_SHARESCREEN_MAX_BITRATE_MCU = "select_sharescreen_max_bitrate_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_MAX_FPS = "select_sharescreen_max_fps";
    public static final String VIDEO_SELECT_SHARESCREEN_MAX_FPS_MCU = "select_sharescreen_max_fps_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_MIN_BITRATE = "select_sharescreen_min_bitrate";
    public static final String VIDEO_SELECT_SHARESCREEN_MIN_BITRATE_MCU = "select_sharescreen_min_bitrate_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_MIN_FPS = "select_sharescreen_min_fps";
    public static final String VIDEO_SELECT_SHARESCREEN_MIN_FPS_MCU = "select_sharescreen_min_fps_mcu";
    public static final String VIDEO_SELECT_SHARESCREEN_WIDTH = "select_sharescreen_width";
    public static final String VIDEO_SELECT_SHARESCREEN_WIDTH_MCU = "select_sharescreen_width_mcu";
    public static final String VIDEO_SELECT_VFU = "select_vfu";
    public static final String VIDEO_SELECT_VFU_MCU = "select_vfu_mcu";
    public static final String VIDEO_USE_FEC = "set_video_fec";
    public static final String VIDEO_USE_FEC_MCU = "set_video_fec_mcu";
    public static final String VIDEO_USE_QOS = "set_video_qos";
    public static final String VIDEO_USE_QOS_MCU = "set_video_qos_mcu";
    public static final String VIDEO_USE_SRTP = "set_video_srtp";
    public static final String VIDEO_USE_SRTP_MCU = "set_video_srtp_mcu";
    public static int aecDtGcgain1st;
    public static int aecDtGcgain2st;
    public static int aecInTxGain;
    public static int aecNsOnOff;
    public static int aecNsgainNs;
    public static int aecOutTxGain;
    public static int aecPostGain;
    public static int aecPostMin;
    public static int aecRxDethangmax1st;
    public static int aecRxDethangmax2st;
    public static int aecRxDetth1st;
    public static int aecRxDetth2st;
    public static int aecRxGain;
    public static int aecSpkDtGcgain1st;
    public static int aecSpkDtGcgain2st;
    public static int aecSpkInTxGain;
    public static int aecSpkNsOnOff;
    public static int aecSpkNsgainNs;
    public static int aecSpkOutTxGain;
    public static int aecSpkPostGain;
    public static int aecSpkPostMin;
    public static int aecSpkRxDethangmax1st;
    public static int aecSpkRxDethangmax2st;
    public static int aecSpkRxDetth1st;
    public static int aecSpkRxDetth2st;
    public static int aecSpkRxGain;
    public static int aecSpkSsgainNs;
    public static int aecSpkWeightSsns;
    public static int aecSsgainNs;
    public static int aecWeightSsns;
    public static int audioFreq;
    public static int audioFreq_mcu;
    public static int audioUseSRTP;
    public static int audioUseSRTP_mcu;
    public static int rxAgcComslope;
    public static int rxAgcComth;
    public static int rxAgcExpslope;
    public static int rxAgcExpth;
    public static int rxCngGain;
    public static int rxFilterCo0;
    public static int rxFilterCo1;
    public static int rxFilterCo2;
    public static int rxFilterCo3;
    public static int rxFilterCo4;
    public static int rxFilterCo5;
    public static int rxFilterCo6;
    public static int rxLiveVolume;
    public static int sharescreen_height;
    public static int sharescreen_height_mcu;
    public static int sharescreen_init_bitrate;
    public static int sharescreen_init_bitrate_mcu;
    public static int sharescreen_max_bitrate;
    public static int sharescreen_max_bitrate_mcu;
    public static int sharescreen_max_fps;
    public static int sharescreen_max_fps_mcu;
    public static int sharescreen_min_bitrate;
    public static int sharescreen_min_bitrate_mcu;
    public static int sharescreen_min_fps;
    public static int sharescreen_min_fps_mcu;
    public static int sharescreen_width;
    public static int sharescreen_width_mcu;
    public static int sipdestport;
    public static int spkRxAgcComslope;
    public static int spkRxAgcComth;
    public static int spkRxAgcExpslope;
    public static int spkRxAgcExpth;
    public static int spkRxFilterCo0;
    public static int spkRxFilterCo1;
    public static int spkRxFilterCo2;
    public static int spkRxFilterCo3;
    public static int spkRxFilterCo4;
    public static int spkRxFilterCo5;
    public static int spkRxFilterCo6;
    public static int spkRxLiveVolume;
    public static int spkRxVbGain;
    public static int spkRxVbHarmonic;
    public static int spkRxVbHpfcutoff;
    public static int spkRxVbPcmlimit;
    public static int spkTxAgcComslope;
    public static int spkTxAgcComth;
    public static int spkTxAgcExpslope;
    public static int spkTxAgcExpth;
    public static int spkTxFilterCo0;
    public static int spkTxFilterCo1;
    public static int spkTxFilterCo2;
    public static int spkTxFilterCo3;
    public static int spkTxFilterCo4;
    public static int spkTxFilterCo5;
    public static int spkTxFilterCo6;
    public static int spkTxLiveVolume;
    public static int txAgcComslope;
    public static int txAgcComth;
    public static int txAgcExpslope;
    public static int txAgcExpth;
    public static int txFilterCo0;
    public static int txFilterCo1;
    public static int txFilterCo2;
    public static int txFilterCo3;
    public static int txFilterCo4;
    public static int txFilterCo5;
    public static int txFilterCo6;
    public static int txLiveVolume;
    public static boolean useRxAgc;
    public static boolean useRxCng;
    public static boolean useRxFilter;
    public static boolean useRxLiveVolume;
    public static boolean useSpkRxAgc;
    public static boolean useSpkRxFilter;
    public static boolean useSpkRxLiveVolume;
    public static boolean useSpkRxVb;
    public static boolean useSpkTxAec;
    public static boolean useSpkTxAgc;
    public static boolean useSpkTxFilter;
    public static boolean useSpkTxLiveVolume;
    public static boolean useTxAec;
    public static boolean useTxAgc;
    public static boolean useTxFilter;
    public static boolean useTxLiveVolume;
    public static int videoRemoteFPS_mcu;
    public static int videoRemoteInitbitrate_mcu;
    public static int videoRemoteQuality_mcu;
    public static int videoRemoteResolution_mcu;
    public static int videoUseSRTP;
    public static int videoUseSRTP_mcu;
    public static int videoapporient;
    public static int videoapporient_mcu;
    public static int videobackrotatedir;
    public static int videobackrotatedir_mcu;
    public static int videobitrate;
    public static int videobitrate_mcu;
    public static int videocameraflip;
    public static int videocameraflip2;
    public static int videocameraflip2_mcu;
    public static int videocameraflip_mcu;
    public static int videocamerafps;
    public static int videocamerafps_mcu;
    public static int videocameraresolution;
    public static int videocameraresolution_mcu;
    public static int videodebuglevel;
    public static int videofecpttype;
    public static int videofecpttype_mcu;
    public static int videofps;
    public static int videofps_mcu;
    public static int videofrontrotatedir;
    public static int videofrontrotatedir_mcu;
    public static int videogop;
    public static int videogop_mcu;
    public static int videoheaderspacing;
    public static int videoheaderspacing_mcu;
    public static int videoinitbitrate;
    public static int videoinitbitrate_mcu;
    public static int videomaxbitrate;
    public static int videomaxbitrate_mcu;
    public static int videomaxfps;
    public static int videomaxfps_mcu;
    public static int videomaxresol;
    public static int videomaxresol_mcu;
    public static int videominfps;
    public static int videominfps_mcu;
    public static int videominresol;
    public static int videominresol_mcu;
    public static int videoorient;
    public static int videoorient_bcamera;
    public static int videoorient_bcamera_mcu;
    public static int videoorient_mcu;
    public static int videoorientpreview;
    public static int videoorientpreview_mcu;
    public static int videopktmode;
    public static int videopktmode_mcu;
    public static int videorenerrotate;
    public static int videorenerrotate_mcu;
    public static int videoresolution;
    public static int videoresolution_mcu;
    public static int videortcpbandwidth;
    public static int videortcpbandwidth_mcu;
    public static int videortcpinterval;
    public static int videortcpinterval_mcu;
    public static int videosavestream;
    public static int videousefec;
    public static int videousefec_mcu;
    public static int videouseqos;
    public static int videouseqos_mcu;
    public static int videovfu;
    public static int videovfu_mcu;
    public static String videowhitebalance;
    public static String videowhitebalance_mcu;
    public static String audioCodecName = "";
    public static String audioSrtpDomain = "";
    public static String audioSrtpProxy = "";
    public static String audioCodecName_mcu = "";
    public static String audioSrtpDomain_mcu = "";
    public static String audioSrtpProxy_mcu = "";
    public static String videoCodecName = "";
    public static String videoCamera = "";
    public static String videoCodecName_mcu = "";
    public static String videoCamera_mcu = "";
    public static String videolevelid_mcu = "";
    public static String sharescreen_level_id_mcu = "";
    public static boolean isInitialized = false;
    public static boolean isChangedAec = false;
    public static boolean isChangedSpkAec = false;
    public static int rcvMode = 0;
    public static int videoType = 0;

    public static native int jniGetTxPCM(byte[] bArr, int i, int i2);

    public static native int jniReplaceImage(int i, int i2, Object obj, int i3, int i4, int i5, int i6, int i7);

    public static native int jniSetAEC(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16);

    public static native int jniSetAGC(int i, int i2, int i3, int i4, int i5, int i6);

    public static native int jniSetAudioCodec(Object obj, int i, Object obj2, Object obj3, int i2);

    public static native int jniSetAudioConfigStatus(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8);

    public static native int jniSetFilter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static native int jniSetLiveVolume(int i, int i2, int i3);

    public static native int jniSetPreview(Object obj);

    public static native int jniSetPreviewRotation(int i, boolean z);

    public static native int jniSetRxCNG(int i);

    public static native int jniSetRxVB(int i, int i2, int i3, int i4);

    public static native int jniSetSurface(int i, Object obj);

    public static native int jniSetTxPCMCaptureMode(int i);

    public static native int jniSetVideoCodec(Object obj, int i, Object obj2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, Object obj3, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, Object obj4, int i37, int i38, int i39, int i40, int i41, int i42, int i43, Object obj5);

    public static native int jniSwitchCamera(int i);

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Samsung Audio Setting");
        addPreferencesFromResource(C0000R.xml.audio_setting);
        updateAllPreferenceSummury();
        setReceiverMode();
        initializeSECConfigData();
        updateAllPreferenceStatus();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    public static void setReceiverMode() {
        AudioManager manager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (manager.isSpeakerphoneOn()) {
            rcvMode = 1;
        } else {
            rcvMode = 0;
        }
    }

    public static void initializeReceiverModeFlag() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        useRxLiveVolume = sharedPreferences.getBoolean(USE_RX_LIVEVOLUME, false);
        useTxLiveVolume = sharedPreferences.getBoolean(USE_TX_LIVEVOLUME, false);
        useRxAgc = sharedPreferences.getBoolean(USE_RX_AGC, false);
        useTxAgc = sharedPreferences.getBoolean(USE_TX_AGC, false);
        useRxFilter = sharedPreferences.getBoolean(USE_RX_FILTER, false);
        useTxFilter = sharedPreferences.getBoolean(USE_TX_FILTER, false);
        useRxCng = sharedPreferences.getBoolean(USE_RX_CNG, false);
        useTxAec = sharedPreferences.getBoolean(USE_TX_AEC, false);
    }

    public static void initializeSpeakerModeFlag() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        useSpkRxLiveVolume = sharedPreferences.getBoolean(USE_SPK_RX_LIVEVOLUME, false);
        useSpkTxLiveVolume = sharedPreferences.getBoolean(USE_SPK_TX_LIVEVOLUME, false);
        useSpkRxAgc = sharedPreferences.getBoolean(USE_SPK_RX_AGC, false);
        useSpkTxAgc = sharedPreferences.getBoolean(USE_SPK_TX_AGC, false);
        useSpkRxFilter = sharedPreferences.getBoolean(USE_SPK_RX_FILTER, false);
        useSpkTxFilter = sharedPreferences.getBoolean(USE_SPK_TX_FILTER, false);
        useSpkRxVb = sharedPreferences.getBoolean(USE_SPK_RX_VB, false);
        useSpkTxAec = sharedPreferences.getBoolean(USE_SPK_TX_AEC, false);
    }

    public static int requestSetAudioConfigStatus(int mode) {
        if (mode == 0) {
            int re = jniSetAudioConfigStatus(0, useRxLiveVolume, useTxLiveVolume, useRxAgc, useTxAgc, useRxFilter, useTxFilter, useRxCng, useTxAec);
            return re;
        }
        int re2 = jniSetAudioConfigStatus(1, useSpkRxLiveVolume, useSpkTxLiveVolume, useSpkRxAgc, useSpkTxAgc, useSpkRxFilter, useSpkTxFilter, useSpkRxVb, useSpkTxAec);
        return re2;
    }

    public static int setAudioConfigStatus(String key, boolean useThisSetting) {
        int re = 0;
        if (key.equals(USE_RX_LIVEVOLUME)) {
            useRxLiveVolume = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useRxLiveVolume) {
                re = jniSetLiveVolume(0, 0, rxLiveVolume);
            }
        } else if (key.equals(USE_TX_LIVEVOLUME)) {
            useTxLiveVolume = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useTxLiveVolume) {
                re = jniSetLiveVolume(0, 1, txLiveVolume);
            }
        } else if (key.equals(USE_RX_AGC)) {
            useRxAgc = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useRxAgc) {
                re = jniSetAGC(0, 0, rxAgcComth, rxAgcComslope, rxAgcExpth, rxAgcExpslope);
            }
        } else if (key.equals(USE_TX_AGC)) {
            useTxAgc = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useTxAgc) {
                re = jniSetAGC(0, 1, txAgcComth, txAgcComslope, txAgcExpth, txAgcExpslope);
            }
        } else if (key.equals(USE_RX_FILTER)) {
            useRxFilter = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useRxFilter) {
                re = jniSetFilter(0, 0, rxFilterCo0, rxFilterCo1, rxFilterCo2, rxFilterCo3, rxFilterCo4, rxFilterCo5, rxFilterCo6);
            }
        } else if (key.equals(USE_TX_FILTER)) {
            useTxFilter = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useTxFilter) {
                re = jniSetFilter(0, 1, txFilterCo0, txFilterCo1, txFilterCo2, txFilterCo3, txFilterCo4, txFilterCo5, txFilterCo6);
            }
        } else if (key.equals(USE_RX_CNG)) {
            useRxCng = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useRxCng) {
                re = jniSetRxCNG(rxCngGain);
            }
        } else if (key.equals(USE_TX_AEC)) {
            useTxAec = useThisSetting;
            if (rcvMode == 1) {
                return 0;
            }
            re = requestSetAudioConfigStatus(0);
            if (useTxAec) {
                re = jniSetAEC(0, aecRxGain, aecPostMin, aecPostGain, aecRxDetth1st, aecRxDethangmax1st, aecDtGcgain1st, aecRxDetth2st, aecRxDethangmax2st, aecDtGcgain2st, aecNsOnOff, aecWeightSsns, aecSsgainNs, aecNsgainNs, aecInTxGain, aecOutTxGain);
            }
        } else if (key.equals(USE_SPK_RX_LIVEVOLUME)) {
            useSpkRxLiveVolume = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkRxLiveVolume) {
                re = jniSetLiveVolume(1, 0, spkRxLiveVolume);
            }
        } else if (key.equals(USE_SPK_TX_LIVEVOLUME)) {
            useSpkTxLiveVolume = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkTxLiveVolume) {
                re = jniSetLiveVolume(1, 1, spkTxLiveVolume);
            }
        } else if (key.equals(USE_SPK_RX_AGC)) {
            useSpkRxAgc = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkRxAgc) {
                re = jniSetAGC(1, 0, spkRxAgcComth, spkRxAgcComslope, spkRxAgcExpth, spkRxAgcExpslope);
            }
        } else if (key.equals(USE_SPK_TX_AGC)) {
            useSpkTxAgc = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkTxAgc) {
                re = jniSetAGC(1, 1, spkTxAgcComth, spkTxAgcComslope, spkTxAgcExpth, spkTxAgcExpslope);
            }
        } else if (key.equals(USE_SPK_RX_FILTER)) {
            useSpkRxFilter = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkRxFilter) {
                re = jniSetFilter(1, 0, spkRxFilterCo0, spkRxFilterCo1, spkRxFilterCo2, spkRxFilterCo3, spkRxFilterCo4, spkRxFilterCo5, spkRxFilterCo6);
            }
        } else if (key.equals(USE_SPK_TX_FILTER)) {
            useSpkTxFilter = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkTxFilter) {
                re = jniSetFilter(1, 1, spkTxFilterCo0, spkTxFilterCo1, spkTxFilterCo2, spkTxFilterCo3, spkTxFilterCo4, spkTxFilterCo5, spkTxFilterCo6);
            }
        } else if (key.equals(USE_SPK_RX_VB)) {
            useSpkRxVb = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkRxVb) {
                re = jniSetRxVB(spkRxVbHpfcutoff, spkRxVbHarmonic, spkRxVbGain, spkRxVbPcmlimit);
            }
        } else if (key.equals(USE_SPK_TX_AEC)) {
            useSpkTxAec = useThisSetting;
            if (rcvMode == 0) {
                return 0;
            }
            re = requestSetAudioConfigStatus(1);
            if (useSpkTxAec) {
                re = jniSetAEC(1, aecSpkRxGain, aecSpkPostMin, aecSpkPostGain, aecSpkRxDetth1st, aecSpkRxDethangmax1st, aecSpkDtGcgain1st, aecSpkRxDetth2st, aecSpkRxDethangmax2st, aecSpkDtGcgain2st, aecSpkNsOnOff, aecSpkWeightSsns, aecSpkSsgainNs, aecSpkNsgainNs, aecSpkInTxGain, aecSpkOutTxGain);
            }
        }
        return re;
    }

    public static void setReceiverModeRxVolume() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        rxLiveVolume = Integer.parseInt(sharedPreferences.getString(RX_LIVEVOLUME, "7"));
    }

    public static void setReceiverModeTxVolume() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        txLiveVolume = Integer.parseInt(sharedPreferences.getString(TX_LIVEVOLUME, "5"));
    }

    public static void setReceiverModeRxAGC() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(RX_AGC, "0 0 0 0");
        StringTokenizer tokenizer = new StringTokenizer(args);
        rxAgcComth = Integer.parseInt(tokenizer.nextToken());
        rxAgcComslope = Integer.parseInt(tokenizer.nextToken());
        rxAgcExpth = Integer.parseInt(tokenizer.nextToken());
        rxAgcExpslope = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setReceiverModeTxAGC() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(TX_AGC, "0 0 0 0");
        StringTokenizer tokenizer = new StringTokenizer(args);
        txAgcComth = Integer.parseInt(tokenizer.nextToken());
        txAgcComslope = Integer.parseInt(tokenizer.nextToken());
        txAgcExpth = Integer.parseInt(tokenizer.nextToken());
        txAgcExpslope = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setReceiverModeRxFilter() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(RX_FILTER, "0 0 0 0 0 0 0");
        StringTokenizer tokenizer = new StringTokenizer(args);
        rxFilterCo0 = Integer.parseInt(tokenizer.nextToken());
        rxFilterCo1 = Integer.parseInt(tokenizer.nextToken());
        rxFilterCo2 = Integer.parseInt(tokenizer.nextToken());
        rxFilterCo3 = Integer.parseInt(tokenizer.nextToken());
        rxFilterCo4 = Integer.parseInt(tokenizer.nextToken());
        rxFilterCo5 = Integer.parseInt(tokenizer.nextToken());
        rxFilterCo6 = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setReceiverModeTxFilter() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(TX_FILTER, "84 290 165 457 -720 1737 14208");
        StringTokenizer tokenizer = new StringTokenizer(args);
        txFilterCo0 = Integer.parseInt(tokenizer.nextToken());
        txFilterCo1 = Integer.parseInt(tokenizer.nextToken());
        txFilterCo2 = Integer.parseInt(tokenizer.nextToken());
        txFilterCo3 = Integer.parseInt(tokenizer.nextToken());
        txFilterCo4 = Integer.parseInt(tokenizer.nextToken());
        txFilterCo5 = Integer.parseInt(tokenizer.nextToken());
        txFilterCo6 = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setReceiverModeRxCNG() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        rxCngGain = Integer.parseInt(sharedPreferences.getString(RX_CNG, "1"));
    }

    public static void setReceiverModeTxAEC() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        aecRxGain = Integer.parseInt(sharedPreferences.getString(AEC_RX_GAIN, "256"));
        aecPostMin = Integer.parseInt(sharedPreferences.getString(AEC_POST_MIN, "11"));
        aecPostGain = Integer.parseInt(sharedPreferences.getString(AEC_POST_GAIN, "5"));
        aecRxDetth1st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETTH1ST, "-35"));
        aecRxDethangmax1st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETHANGMAX1ST, "20"));
        aecDtGcgain1st = Integer.parseInt(sharedPreferences.getString(AEC_DT_GCGAIN1ST, "16384"));
        aecRxDetth2st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETTH2ST, "-35"));
        aecRxDethangmax2st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETHANGMAX2ST, "20"));
        aecDtGcgain2st = Integer.parseInt(sharedPreferences.getString(AEC_DT_GCGAIN2ST, "16384"));
        aecNsOnOff = Integer.parseInt(sharedPreferences.getString(AEC_NS_ONOFF, "1"));
        aecWeightSsns = Integer.parseInt(sharedPreferences.getString(AEC_WEIGHT_SSNS, "20"));
        aecSsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_SSGAIN_NS, "11"));
        aecNsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_NSGAIN_NS, "21"));
        aecInTxGain = Integer.parseInt(sharedPreferences.getString(AEC_IN_TX_GAIN, "1024"));
        aecOutTxGain = Integer.parseInt(sharedPreferences.getString(AEC_OUT_TX_GAIN, "1024"));
    }

    public static void initializeReceiverModeData() {
        setReceiverModeRxVolume();
        setReceiverModeTxVolume();
        setReceiverModeRxAGC();
        setReceiverModeTxAGC();
        setReceiverModeRxFilter();
        setReceiverModeTxFilter();
        setReceiverModeRxCNG();
        setReceiverModeTxAEC();
    }

    public static void setSpeakerModeRxVolume() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        spkRxLiveVolume = Integer.parseInt(sharedPreferences.getString(SPK_RX_LIVEVOLUME, "9"));
    }

    public static void setSpeakerModeTxVolume() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        spkTxLiveVolume = Integer.parseInt(sharedPreferences.getString(SPK_TX_LIVEVOLUME, "3"));
    }

    public static void setSpeakerModeRxAGC() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(SPK_RX_AGC, "-2304 1638 -8320 -6144");
        StringTokenizer tokenizer = new StringTokenizer(args);
        spkRxAgcComth = Integer.parseInt(tokenizer.nextToken());
        spkRxAgcComslope = Integer.parseInt(tokenizer.nextToken());
        spkRxAgcExpth = Integer.parseInt(tokenizer.nextToken());
        spkRxAgcExpslope = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setSpeakerModeTxAGC() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(SPK_TX_AGC, "-1152 0 -8320 -6144");
        StringTokenizer tokenizer = new StringTokenizer(args);
        spkTxAgcComth = Integer.parseInt(tokenizer.nextToken());
        spkTxAgcComslope = Integer.parseInt(tokenizer.nextToken());
        spkTxAgcExpth = Integer.parseInt(tokenizer.nextToken());
        spkTxAgcExpslope = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setSpeakerModeRxFilter() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(SPK_RX_FILTER, "243 191 120 45 -21 -65 16302");
        StringTokenizer tokenizer = new StringTokenizer(args);
        spkRxFilterCo0 = Integer.parseInt(tokenizer.nextToken());
        spkRxFilterCo1 = Integer.parseInt(tokenizer.nextToken());
        spkRxFilterCo2 = Integer.parseInt(tokenizer.nextToken());
        spkRxFilterCo3 = Integer.parseInt(tokenizer.nextToken());
        spkRxFilterCo4 = Integer.parseInt(tokenizer.nextToken());
        spkRxFilterCo5 = Integer.parseInt(tokenizer.nextToken());
        spkRxFilterCo6 = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setSpeakerModeTxFilter() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(SPK_TX_FILTER, "0 0 0 0 0 0 0");
        StringTokenizer tokenizer = new StringTokenizer(args);
        spkTxFilterCo0 = Integer.parseInt(tokenizer.nextToken());
        spkTxFilterCo1 = Integer.parseInt(tokenizer.nextToken());
        spkTxFilterCo2 = Integer.parseInt(tokenizer.nextToken());
        spkTxFilterCo3 = Integer.parseInt(tokenizer.nextToken());
        spkTxFilterCo4 = Integer.parseInt(tokenizer.nextToken());
        spkTxFilterCo5 = Integer.parseInt(tokenizer.nextToken());
        spkTxFilterCo6 = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setSpeakerModeRxVB() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String args = sharedPreferences.getString(SPK_RX_VB, "2 0 8 12");
        StringTokenizer tokenizer = new StringTokenizer(args);
        spkRxVbHpfcutoff = Integer.parseInt(tokenizer.nextToken());
        spkRxVbHarmonic = Integer.parseInt(tokenizer.nextToken());
        spkRxVbGain = Integer.parseInt(tokenizer.nextToken());
        spkRxVbPcmlimit = Integer.parseInt(tokenizer.nextToken());
    }

    public static void setSpeakerModeTxAEC() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        aecSpkRxGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_GAIN, "1024"));
        aecSpkPostMin = Integer.parseInt(sharedPreferences.getString(AEC_SPK_POST_MIN, "11"));
        aecSpkPostGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_POST_GAIN, SimpleUserInfo.STATE_DENY));
        aecSpkRxDetth1st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETTH1ST, "-35"));
        aecSpkRxDethangmax1st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETHANGMAX1ST, "20"));
        aecSpkDtGcgain1st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_DT_GCGAIN1ST, "16384"));
        aecSpkRxDetth2st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETTH2ST, "-35"));
        aecSpkRxDethangmax2st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETHANGMAX2ST, "20"));
        aecSpkDtGcgain2st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_DT_GCGAIN2ST, "16384"));
        aecSpkNsOnOff = Integer.parseInt(sharedPreferences.getString(AEC_SPK_NS_ONOFF, "1"));
        aecSpkWeightSsns = Integer.parseInt(sharedPreferences.getString(AEC_SPK_WEIGHT_SSNS, "20"));
        aecSpkSsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_SPK_SSGAIN_NS, "11"));
        aecSpkNsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_SPK_NSGAIN_NS, "21"));
        aecSpkInTxGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_IN_TX_GAIN, "1024"));
        aecSpkOutTxGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_OUT_TX_GAIN, "1024"));
    }

    public static void initializeSpeakerModeData() {
        setSpeakerModeRxVolume();
        setSpeakerModeTxVolume();
        setSpeakerModeRxAGC();
        setSpeakerModeTxAGC();
        setSpeakerModeRxFilter();
        setSpeakerModeTxFilter();
        setSpeakerModeRxVB();
        setSpeakerModeTxAEC();
    }

    public static void initializeAudioCodec() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        audioCodecName = sharedPreferences.getString(AUDIO_CODEC_NAME, "AMR-WB");
        audioFreq = Integer.parseInt(sharedPreferences.getString(AUDIO_FREQ_NAME, "16000"));
        audioCodecName_mcu = sharedPreferences.getString(AUDIO_CODEC_NAME_MCU, "AMR-WB");
        audioFreq_mcu = Integer.parseInt(sharedPreferences.getString(AUDIO_FREQ_NAME_MCU, "16000"));
    }

    public static void initializeVideoCodec() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videoCodecName = sharedPreferences.getString(VIDEO_CODEC_NAME, "H264");
        videoCodecName_mcu = sharedPreferences.getString(VIDEO_CODEC_NAME_MCU, "H264");
    }

    public static void initializeCodec() {
        initializeAudioCodec();
        initializeVideoCodec();
    }

    public static void initializeAudioSRTP() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (sharedPreferences.getBoolean(AUDIO_USE_SRTP, true)) {
            audioUseSRTP = 1;
        } else {
            audioUseSRTP = 0;
        }
        audioSrtpDomain = sharedPreferences.getString(SRTP_DOMAIN_NAME, "samsung070.com");
        audioSrtpProxy = sharedPreferences.getString(SRTP_PROXY_NAME, "dankook.samsung070.com");
        if (sharedPreferences.getBoolean(AUDIO_USE_SRTP_MCU, true)) {
            audioUseSRTP_mcu = 1;
        } else {
            audioUseSRTP_mcu = 0;
        }
        audioSrtpDomain_mcu = sharedPreferences.getString(SRTP_DOMAIN_NAME_MCU, "stgproxy.coolots.com");
        audioSrtpProxy_mcu = sharedPreferences.getString(SRTP_PROXY_NAME_MCU, "stgproxy.coolots.com");
        Log.m2958e("SRTP initializeAudioSRTP: " + audioUseSRTP + ", " + audioUseSRTP_mcu);
    }

    public static void initializeVideoSRTP() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (sharedPreferences.getBoolean(VIDEO_USE_SRTP, true)) {
            videoUseSRTP = 1;
        } else {
            videoUseSRTP = 0;
        }
        if (sharedPreferences.getBoolean(VIDEO_USE_SRTP_MCU, true)) {
            videoUseSRTP_mcu = 1;
        } else {
            videoUseSRTP_mcu = 0;
        }
        Log.m2958e("SRTP initializeVideoSRTP: " + videoUseSRTP + ", " + videoUseSRTP_mcu);
    }

    public static void initializeSRTP() {
        initializeAudioSRTP();
        initializeVideoSRTP();
    }

    public static void initializeVideoCamera() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (Camera.getNumberOfCameras() == 1) {
            Camera.CameraInfo cam_info = new Camera.CameraInfo();
            Camera.getCameraInfo(0, cam_info);
            if (cam_info.facing == 0) {
                videoCamera = sharedPreferences.getString(VIDEO_SELECT_CAMERA, "cam_back");
                videoCamera_mcu = sharedPreferences.getString(VIDEO_SELECT_CAMERA_MCU, "cam_back");
                return;
            } else {
                videoCamera = sharedPreferences.getString(VIDEO_SELECT_CAMERA, "cam_front");
                videoCamera_mcu = sharedPreferences.getString(VIDEO_SELECT_CAMERA_MCU, "cam_front");
                return;
            }
        }
        videoCamera = sharedPreferences.getString(VIDEO_SELECT_CAMERA, "cam_front");
        videoCamera_mcu = sharedPreferences.getString(VIDEO_SELECT_CAMERA_MCU, "cam_front");
    }

    public static void initializeVideoFPS() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videofps = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FPS, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
        videocamerafps = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_CAMERA_FPS, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
        videofps_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FPS_MCU, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
        videocamerafps_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_CAMERA_FPS_MCU, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
    }

    public static void initializeVideoQoS() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (sharedPreferences.getBoolean(VIDEO_USE_QOS, true)) {
            videouseqos = 1;
        } else {
            videouseqos = 0;
        }
        videoinitbitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_INITBITRATE, "192000"));
        if (PhoneManager.is3GNetworkConnected(MainApplication.mContext) && !ChatONSettingData.getInstance().isUseHighQuality()) {
            videobitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_BITRATE_3G, "16000"));
            videomaxbitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXBITRATE_3G, "384000"));
            videominresol = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MINRESOL_3G, "1"));
            videomaxresol = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXRESOL_3G, "1"));
        } else {
            videobitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_BITRATE, "16000"));
            videomaxbitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXBITRATE, "650000"));
            videominresol = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MINRESOL, "1"));
            videomaxresol = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXRESOL, "2"));
        }
        videominfps = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MINFPS, "5"));
        videomaxfps = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXFPS, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
        videovfu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_VFU, "0"));
        videoinitbitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_INITBITRATE_MCU, "192000"));
        if (sharedPreferences.getBoolean(VIDEO_USE_QOS_MCU, true)) {
            videouseqos_mcu = 1;
        } else {
            videouseqos_mcu = 0;
        }
        if (PhoneManager.is3GNetworkConnected(MainApplication.mContext) && !ChatONSettingData.getInstance().isUseHighQuality()) {
            Log.m2958e("3gConnected");
            videobitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_BITRATE_MCU_3G, "16000"));
            videomaxbitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXBITRATE_MCU_3G, "384000"));
            videominresol_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MINRESOL_MCU_3G, "1"));
            videomaxresol_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXRESOL_MCU_3G, "1"));
            Log.m2958e("MJH 3gConnected bitrate " + videoinitbitrate_mcu);
        } else {
            videobitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_BITRATE_MCU, "16000"));
            videomaxbitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXBITRATE_MCU, "650000"));
            videominresol_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MINRESOL_MCU, "1"));
            videomaxresol_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXRESOL_MCU, "1"));
            Log.m2958e("wificonnected");
        }
        videominfps_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MINFPS_MCU, "1"));
        videomaxfps_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_MAXFPS_MCU, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
        videovfu_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_VFU_MCU, "0"));
    }

    public static void initializeVideoGOP() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videogop = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_GOP, "1440"));
        videogop_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_GOP_MCU, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
    }

    public static void initializeVideoResolution() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videoresolution = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RESOLUTION, "1"));
        videocameraresolution = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_CAMERA_RESOLUTION, "1"));
        videoresolution_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RESOLUTION_MCU, "1"));
        videocameraresolution_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_CAMERA_RESOLUTION_MCU, "1"));
    }

    public static void initializeVideoOrient() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (ModelInfoUtil.IS_MODEL_GALAXY_TAB_GT_N8P5) {
            videoorient = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT, "0"));
            videoorient_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_MCU, "0"));
            videoorient_bcamera = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_BCAMERA, "0"));
            videoorient_bcamera_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_BCAMERA_MCU, "0"));
            videoorientpreview = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_PREVIEW, "0"));
            videoorientpreview_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_PREVIEW_MCU, "0"));
            return;
        }
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            videoorient = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT, "0"));
            videoorient_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_MCU, "0"));
            videoorient_bcamera = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_BCAMERA, "0"));
            videoorient_bcamera_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_BCAMERA_MCU, "0"));
            videoorientpreview = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_PREVIEW, "1"));
            videoorientpreview_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_PREVIEW_MCU, "1"));
            return;
        }
        videoorient = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT, "2"));
        videoorient_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_MCU, "2"));
        videoorient_bcamera = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_BCAMERA, "0"));
        videoorient_bcamera_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_BCAMERA_MCU, "0"));
        videoorientpreview = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_PREVIEW, "1"));
        videoorientpreview_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_ORIENT_PREVIEW_MCU, "1"));
    }

    public static void initializeSipDestPort() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        sipdestport = Integer.parseInt(sharedPreferences.getString(SELECT_SIP_DEST_PORT, "5060"));
    }

    public static void initializeVideoHeaderSpacing() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videoheaderspacing = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_HEADERSPACING, "0"));
        videoheaderspacing_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_HEADERSPACING_MCU, "7000"));
    }

    public static void initializeVideoDebugLevel() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videodebuglevel = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_DEBUGLEVEL, "0"));
    }

    public static void initializeVideoRTCPInterval() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videortcpinterval = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RTCPINTERVAL, "100"));
        videortcpinterval_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RTCPINTERVAL_MCU, "100"));
    }

    public static void initializeVideoRTCPBandwidth() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videortcpbandwidth = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RTCPBANDWIDTH, "10000"));
        videortcpbandwidth_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RTCPBANDWIDTH_MCU, "500"));
    }

    public static void initializeVideoPktMode() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videopktmode = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_PKTMODE, "0"));
        videopktmode_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_PKTMODE_MCU, "1"));
    }

    public static void initializeVideoCameraFlip() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (ModelInfoUtil.IS_MODEL_GALAXY_TAB_GT_N8P5) {
            videocameraflip = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION, "2"));
            videocameraflip_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION_MCU, "2"));
            videocameraflip2 = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION2, "0"));
            videocameraflip2_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION2_MCU, "0"));
            return;
        }
        videocameraflip = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION, "1"));
        videocameraflip_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION_MCU, "1"));
        videocameraflip2 = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION2, "0"));
        videocameraflip2_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FLIP_OPTION2_MCU, "0"));
    }

    public static void initializeVideoRotateDir() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videofrontrotatedir = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FRONT_ROTATION_DIRECTION, "1"));
        videobackrotatedir = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_BACK_ROTATION_DIRECTION, PhoneNoAuthRep.AUTH_RESULT_FAIL));
        videofrontrotatedir_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_FRONT_ROTATION_DIRECTION_MCU, "1"));
        videobackrotatedir_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_BACK_ROTATION_DIRECTION_MCU, PhoneNoAuthRep.AUTH_RESULT_FAIL));
    }

    public static void initializeVideoAppOrient() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videoapporient = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_APP_ORIENT, "0"));
        videoapporient_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_APP_ORIENT_MCU, "0"));
    }

    public static void initializeVideoWhiteBalance() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        videowhitebalance = sharedPreferences.getString(VIDEO_SELECT_CAMERA_WHITEBALANCE, "auto");
        videowhitebalance_mcu = sharedPreferences.getString(VIDEO_SELECT_CAMERA_WHITEBALANCE_MCU, "auto");
    }

    public static void initializeVideoFEC() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (sharedPreferences.getBoolean(VIDEO_USE_FEC, true)) {
            videousefec = 1;
        } else {
            videousefec = 0;
        }
        videofecpttype = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_PTTYPE, "120"));
        if (sharedPreferences.getBoolean(VIDEO_USE_FEC_MCU, false)) {
            videousefec_mcu = 1;
        } else {
            videousefec_mcu = 0;
        }
        videofecpttype_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_PTTYPE_MCU, "120"));
    }

    public static void initializeVideoSaveStream() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (sharedPreferences.getBoolean(VIDEO_SAVE_STREAM, false)) {
            videosavestream = 1;
        } else {
            videosavestream = 0;
        }
    }

    public static void initializeVideoLevelID() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (PhoneManager.is3GNetworkConnected(MainApplication.mContext) && !ChatONSettingData.getInstance().isUseHighQuality()) {
            videolevelid_mcu = sharedPreferences.getString(VIDEO_SELECT_LEVEL_ID_MCU_3G, "42800D");
        } else {
            videolevelid_mcu = sharedPreferences.getString("select_level_id_mcu", "42801E");
        }
        if (PhoneManager.is3GNetworkConnected(MainApplication.mContext) && !ChatONSettingData.getInstance().isUseHighQuality()) {
            videoRemoteInitbitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_REMOTE_INITBITRATE_MCU_3G, "384000"));
            Log.m2958e("MJH 3gConnected remote bitrate " + videoRemoteInitbitrate_mcu);
        } else {
            videoRemoteInitbitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_REMOTE_INITBITRATE_MCU, "700000"));
        }
        videoRemoteFPS_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_REMOTE_FPS_MCU, NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS));
        videoRemoteResolution_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_REMOTE_RESOL_MCU, "1200"));
        videoRemoteQuality_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_REMOTE_QUALITY_MCU, SimpleUserInfo.STATE_DENY));
    }

    public static void initializeVideoRotate() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (ModelInfoUtil.IS_MODEL_GALAXY_TAB_GT_N8P5) {
            videorenerrotate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RENDER_ROTATION, "0"));
            videorenerrotate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RENDER_ROTATION_MCU, "0"));
        } else {
            videorenerrotate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RENDER_ROTATION, "90"));
            videorenerrotate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_RENDER_ROTATION_MCU, "90"));
        }
    }

    public static void initializeShareScreenParam() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        sharescreen_width = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_WIDTH, "576"));
        sharescreen_height = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_HEIGHT, "1024"));
        sharescreen_init_bitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_INIT_BITRATE, "384000"));
        sharescreen_min_bitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MIN_BITRATE, "16000"));
        sharescreen_max_bitrate = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MAX_BITRATE, "700000"));
        sharescreen_min_fps = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MIN_FPS, "5"));
        sharescreen_max_fps = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MAX_FPS, SimpleUserInfo.STATE_DENY));
        sharescreen_width_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_WIDTH_MCU, "576"));
        sharescreen_height_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_HEIGHT_MCU, "1024"));
        sharescreen_init_bitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_INIT_BITRATE_MCU, "384000"));
        sharescreen_min_bitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MIN_BITRATE_MCU, "16000"));
        sharescreen_max_bitrate_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MAX_BITRATE_MCU, "700000"));
        sharescreen_min_fps_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MIN_FPS_MCU, "5"));
        sharescreen_max_fps_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_MAX_FPS_MCU, SimpleUserInfo.STATE_DENY));
        sharescreen_level_id_mcu = sharedPreferences.getString("select_level_id_mcu", "42801E");
        if (ModelInfoUtil.IS_MODEL_MCAMERA) {
            sharescreen_width = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_WIDTH, "540"));
            sharescreen_height = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_HEIGHT, "960"));
            sharescreen_width_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_WIDTH_MCU, "540"));
            sharescreen_height_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_HEIGHT_MCU, "960"));
        }
        if (Camera.getNumberOfCameras() == 1) {
            sharescreen_width = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_WIDTH, "288"));
            sharescreen_height = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_HEIGHT, "512"));
            sharescreen_width_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_WIDTH_MCU, "288"));
            sharescreen_height_mcu = Integer.parseInt(sharedPreferences.getString(VIDEO_SELECT_SHARESCREEN_HEIGHT_MCU, "512"));
        }
    }

    public static void initializeVideoParams() {
        initializeVideoCamera();
        initializeVideoFPS();
        initializeVideoQoS();
        initializeVideoGOP();
        initializeVideoResolution();
        initializeVideoOrient();
        initializeVideoHeaderSpacing();
        initializeVideoDebugLevel();
        initializeVideoRTCPInterval();
        initializeVideoRTCPBandwidth();
        initializeVideoPktMode();
        initializeVideoFEC();
        initializeVideoSaveStream();
        initializeVideoLevelID();
        initializeVideoRotate();
        initializeVideoCameraFlip();
        initializeVideoRotateDir();
        initializeVideoAppOrient();
        initializeVideoWhiteBalance();
        initializeShareScreenParam();
    }

    public static void initializeSECConfigData() {
        if (!isInitialized) {
            initializeReceiverModeFlag();
            initializeSpeakerModeFlag();
            initializeReceiverModeData();
            initializeSpeakerModeData();
            initializeCodec();
            initializeSRTP();
            initializeVideoParams();
            isInitialized = true;
        }
        initializeVideoQoS();
        initializeVideoLevelID();
        initializeSipDestPort();
    }

    public boolean updatePreferenceStatus(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        boolean useThisSetting = sharedPreferences.getBoolean(key, false);
        EditTextPreference editPref = (EditTextPreference) getPreferenceScreen().findPreference(key.substring(4));
        if (editPref != null) {
            if (useThisSetting) {
                editPref.setEnabled(true);
            } else {
                editPref.setEnabled(false);
            }
        }
        return useThisSetting;
    }

    public void updateAllPreferenceStatus() {
        updatePreferenceStatus(USE_RX_LIVEVOLUME);
        updatePreferenceStatus(USE_TX_LIVEVOLUME);
        updatePreferenceStatus(USE_RX_AGC);
        updatePreferenceStatus(USE_TX_AGC);
        updatePreferenceStatus(USE_RX_FILTER);
        updatePreferenceStatus(USE_TX_FILTER);
        updatePreferenceStatus(USE_RX_CNG);
        updatePreferenceStatus(USE_TX_AEC);
        updatePreferenceStatus(USE_SPK_RX_LIVEVOLUME);
        updatePreferenceStatus(USE_SPK_TX_LIVEVOLUME);
        updatePreferenceStatus(USE_SPK_RX_AGC);
        updatePreferenceStatus(USE_SPK_TX_AGC);
        updatePreferenceStatus(USE_SPK_RX_FILTER);
        updatePreferenceStatus(USE_SPK_TX_FILTER);
        updatePreferenceStatus(USE_SPK_RX_VB);
        updatePreferenceStatus(USE_SPK_TX_AEC);
        if (audioUseSRTP == 1) {
            getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME).setEnabled(true);
            getPreferenceScreen().findPreference(SRTP_PROXY_NAME).setEnabled(true);
        } else {
            getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME).setEnabled(false);
            getPreferenceScreen().findPreference(SRTP_PROXY_NAME).setEnabled(false);
        }
        if (audioUseSRTP_mcu == 1) {
            getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME_MCU).setEnabled(true);
            getPreferenceScreen().findPreference(SRTP_PROXY_NAME_MCU).setEnabled(true);
        } else {
            getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(SRTP_PROXY_NAME_MCU).setEnabled(false);
        }
        if (videouseqos == 1) {
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS).setEnabled(true);
        } else {
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS).setEnabled(false);
        }
        if (videousefec == 1) {
            getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE).setEnabled(true);
        } else {
            getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE).setEnabled(false);
        }
        if (videouseqos_mcu == 1) {
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU_3G).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS_MCU).setEnabled(true);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS_MCU).setEnabled(true);
        } else {
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS_MCU).setEnabled(false);
        }
        if (videousefec_mcu == 1) {
            getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE_MCU).setEnabled(true);
        } else {
            getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE_MCU).setEnabled(false);
        }
    }

    public void updateEditTextPreferenceSummury(String key) {
        EditTextPreference editPref = (EditTextPreference) getPreferenceScreen().findPreference(key);
        if (editPref != null) {
            Log.m2958e("SEC" + key + ": " + editPref.getText().toString());
            editPref.setSummary(editPref.getText().toString());
        }
    }

    public void updateListPreferenceSummury(String key) {
        ListPreference listPref = (ListPreference) getPreferenceScreen().findPreference(key);
        if (listPref != null) {
            listPref.setSummary(listPref.getEntry());
        }
    }

    public void updateAllPreferenceSummury() {
        updateEditTextPreferenceSummury(RX_LIVEVOLUME);
        updateEditTextPreferenceSummury(TX_LIVEVOLUME);
        updateEditTextPreferenceSummury(RX_AGC);
        updateEditTextPreferenceSummury(TX_AGC);
        updateEditTextPreferenceSummury(RX_FILTER);
        updateEditTextPreferenceSummury(TX_FILTER);
        updateEditTextPreferenceSummury(RX_CNG);
        updateEditTextPreferenceSummury(AEC_RX_GAIN);
        updateEditTextPreferenceSummury(AEC_POST_MIN);
        updateEditTextPreferenceSummury(AEC_POST_GAIN);
        updateEditTextPreferenceSummury(AEC_RX_DETTH1ST);
        updateEditTextPreferenceSummury(AEC_RX_DETHANGMAX1ST);
        updateEditTextPreferenceSummury(AEC_DT_GCGAIN1ST);
        updateEditTextPreferenceSummury(AEC_RX_DETTH2ST);
        updateEditTextPreferenceSummury(AEC_RX_DETHANGMAX2ST);
        updateEditTextPreferenceSummury(AEC_DT_GCGAIN2ST);
        updateEditTextPreferenceSummury(AEC_NS_ONOFF);
        updateEditTextPreferenceSummury(AEC_WEIGHT_SSNS);
        updateEditTextPreferenceSummury(AEC_SSGAIN_NS);
        updateEditTextPreferenceSummury(AEC_NSGAIN_NS);
        updateEditTextPreferenceSummury(AEC_IN_TX_GAIN);
        updateEditTextPreferenceSummury(AEC_OUT_TX_GAIN);
        updateEditTextPreferenceSummury(SPK_RX_LIVEVOLUME);
        updateEditTextPreferenceSummury(SPK_TX_LIVEVOLUME);
        updateEditTextPreferenceSummury(SPK_RX_AGC);
        updateEditTextPreferenceSummury(SPK_TX_AGC);
        updateEditTextPreferenceSummury(SPK_RX_FILTER);
        updateEditTextPreferenceSummury(SPK_TX_FILTER);
        updateEditTextPreferenceSummury(SPK_RX_VB);
        updateEditTextPreferenceSummury(AEC_SPK_RX_GAIN);
        updateEditTextPreferenceSummury(AEC_SPK_POST_MIN);
        updateEditTextPreferenceSummury(AEC_SPK_POST_GAIN);
        updateEditTextPreferenceSummury(AEC_SPK_RX_DETTH1ST);
        updateEditTextPreferenceSummury(AEC_SPK_RX_DETHANGMAX1ST);
        updateEditTextPreferenceSummury(AEC_SPK_DT_GCGAIN1ST);
        updateEditTextPreferenceSummury(AEC_SPK_RX_DETTH2ST);
        updateEditTextPreferenceSummury(AEC_SPK_RX_DETHANGMAX2ST);
        updateEditTextPreferenceSummury(AEC_SPK_DT_GCGAIN2ST);
        updateEditTextPreferenceSummury(AEC_SPK_NS_ONOFF);
        updateEditTextPreferenceSummury(AEC_SPK_WEIGHT_SSNS);
        updateEditTextPreferenceSummury(AEC_SPK_SSGAIN_NS);
        updateEditTextPreferenceSummury(AEC_SPK_NSGAIN_NS);
        updateEditTextPreferenceSummury(AEC_SPK_IN_TX_GAIN);
        updateEditTextPreferenceSummury(AEC_SPK_OUT_TX_GAIN);
        updateEditTextPreferenceSummury(SRTP_DOMAIN_NAME);
        updateEditTextPreferenceSummury(SRTP_PROXY_NAME);
        updateListPreferenceSummury(AUDIO_CODEC_NAME);
        updateListPreferenceSummury(AUDIO_FREQ_NAME);
        updateEditTextPreferenceSummury(SRTP_DOMAIN_NAME_MCU);
        updateEditTextPreferenceSummury(SRTP_PROXY_NAME_MCU);
        updateListPreferenceSummury(AUDIO_CODEC_NAME_MCU);
        updateListPreferenceSummury(AUDIO_FREQ_NAME_MCU);
        updateListPreferenceSummury(VIDEO_CODEC_NAME);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA);
        updateListPreferenceSummury(VIDEO_SELECT_FPS);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA_FPS);
        updateListPreferenceSummury(VIDEO_SELECT_BITRATE);
        updateListPreferenceSummury(VIDEO_SELECT_BITRATE_3G);
        updateListPreferenceSummury(VIDEO_SELECT_INITBITRATE);
        updateListPreferenceSummury(VIDEO_SELECT_MAXBITRATE);
        updateListPreferenceSummury(VIDEO_SELECT_MAXBITRATE_3G);
        updateListPreferenceSummury(VIDEO_SELECT_MINRESOL);
        updateListPreferenceSummury(VIDEO_SELECT_MAXRESOL);
        updateListPreferenceSummury(VIDEO_SELECT_MINRESOL_3G);
        updateListPreferenceSummury(VIDEO_SELECT_MAXRESOL_3G);
        updateListPreferenceSummury(VIDEO_SELECT_MINFPS);
        updateListPreferenceSummury(VIDEO_SELECT_MAXFPS);
        updateListPreferenceSummury(VIDEO_SELECT_VFU);
        updateListPreferenceSummury(VIDEO_SELECT_GOP);
        updateListPreferenceSummury(VIDEO_SELECT_RESOLUTION);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA_RESOLUTION);
        updateListPreferenceSummury(VIDEO_SELECT_ORIENT);
        updateListPreferenceSummury(VIDEO_SELECT_ORIENT_BCAMERA);
        updateListPreferenceSummury(VIDEO_SELECT_ORIENT_PREVIEW);
        updateEditTextPreferenceSummury(SELECT_SIP_DEST_PORT);
        updateEditTextPreferenceSummury(VIDEO_SELECT_HEADERSPACING);
        updateEditTextPreferenceSummury(VIDEO_SELECT_RTCPINTERVAL);
        updateEditTextPreferenceSummury(VIDEO_SELECT_RTCPBANDWIDTH);
        updateListPreferenceSummury(VIDEO_SELECT_PKTMODE);
        updateEditTextPreferenceSummury(VIDEO_SELECT_PTTYPE);
        updateListPreferenceSummury(VIDEO_SELECT_RENDER_ROTATION);
        updateListPreferenceSummury(VIDEO_SELECT_FLIP_OPTION);
        updateListPreferenceSummury(VIDEO_SELECT_FLIP_OPTION2);
        updateListPreferenceSummury(VIDEO_SELECT_FRONT_ROTATION_DIRECTION);
        updateListPreferenceSummury(VIDEO_SELECT_BACK_ROTATION_DIRECTION);
        updateListPreferenceSummury(VIDEO_SELECT_APP_ORIENT);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA_WHITEBALANCE);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_WIDTH);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_HEIGHT);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_INIT_BITRATE);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MIN_BITRATE);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MAX_BITRATE);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MIN_FPS);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MAX_FPS);
        updateListPreferenceSummury(VIDEO_CODEC_NAME_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_FPS_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA_FPS_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_BITRATE_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_BITRATE_MCU_3G);
        updateListPreferenceSummury(VIDEO_SELECT_INITBITRATE_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_MAXBITRATE_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_MAXBITRATE_MCU_3G);
        updateListPreferenceSummury(VIDEO_SELECT_MINRESOL_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_MINRESOL_MCU_3G);
        updateListPreferenceSummury(VIDEO_SELECT_MAXRESOL_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_MAXRESOL_MCU_3G);
        updateListPreferenceSummury(VIDEO_SELECT_MINFPS_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_MAXFPS_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_VFU_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_GOP_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_RESOLUTION_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA_RESOLUTION_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_ORIENT_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_ORIENT_BCAMERA_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_ORIENT_PREVIEW_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_HEADERSPACING_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_RTCPINTERVAL_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_RTCPBANDWIDTH_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_PKTMODE_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_PTTYPE_MCU);
        updateEditTextPreferenceSummury("select_level_id_mcu");
        updateEditTextPreferenceSummury(VIDEO_SELECT_LEVEL_ID_MCU_3G);
        updateListPreferenceSummury(VIDEO_SELECT_REMOTE_INITBITRATE_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_REMOTE_INITBITRATE_MCU_3G);
        updateListPreferenceSummury(VIDEO_SELECT_REMOTE_FPS_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_REMOTE_RESOL_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_REMOTE_QUALITY_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_RENDER_ROTATION_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_FLIP_OPTION_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_FLIP_OPTION2_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_FRONT_ROTATION_DIRECTION_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_APP_ORIENT_MCU);
        updateListPreferenceSummury(VIDEO_SELECT_CAMERA_WHITEBALANCE_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_WIDTH_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_HEIGHT_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_INIT_BITRATE_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MIN_BITRATE_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MAX_BITRATE_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MIN_FPS_MCU);
        updateEditTextPreferenceSummury(VIDEO_SELECT_SHARESCREEN_MAX_FPS_MCU);
        updateEditTextPreferenceSummury("select_level_id_mcu");
        updateListPreferenceSummury(VIDEO_SELECT_DEBUGLEVEL);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(AUDIO_CODEC_NAME) || key.equals(AUDIO_CODEC_NAME_MCU) || key.equals(AUDIO_FREQ_NAME) || key.equals(AUDIO_FREQ_NAME_MCU)) {
            updateListPreferenceSummury(key);
            initializeAudioCodec();
            return;
        }
        if (key.equals(VIDEO_CODEC_NAME) || key.equals(VIDEO_CODEC_NAME_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoCodec();
            return;
        }
        if (key.equals(AUDIO_USE_SRTP) || key.equals(SRTP_DOMAIN_NAME) || key.equals(SRTP_PROXY_NAME) || key.equals(AUDIO_USE_SRTP_MCU) || key.equals(SRTP_DOMAIN_NAME_MCU) || key.equals(SRTP_PROXY_NAME_MCU)) {
            if (!key.equals(AUDIO_USE_SRTP) && !key.equals(AUDIO_USE_SRTP_MCU)) {
                updateEditTextPreferenceSummury(key);
            }
            initializeAudioSRTP();
            if (audioUseSRTP == 1) {
                getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME).setEnabled(true);
                getPreferenceScreen().findPreference(SRTP_PROXY_NAME).setEnabled(true);
            } else {
                getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME).setEnabled(false);
                getPreferenceScreen().findPreference(SRTP_PROXY_NAME).setEnabled(false);
            }
            if (audioUseSRTP_mcu == 1) {
                getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME_MCU).setEnabled(true);
                getPreferenceScreen().findPreference(SRTP_PROXY_NAME_MCU).setEnabled(true);
                return;
            } else {
                getPreferenceScreen().findPreference(SRTP_DOMAIN_NAME_MCU).setEnabled(false);
                getPreferenceScreen().findPreference(SRTP_PROXY_NAME_MCU).setEnabled(false);
                return;
            }
        }
        if (key.equals(VIDEO_USE_SRTP) || key.equals(VIDEO_USE_SRTP_MCU)) {
            initializeVideoSRTP();
            return;
        }
        if (key.equals(VIDEO_SELECT_CAMERA) || key.equals(VIDEO_SELECT_CAMERA_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoCamera();
            return;
        }
        if (key.equals(VIDEO_SELECT_RENDER_ROTATION) || key.equals(VIDEO_SELECT_RENDER_ROTATION_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoRotate();
            return;
        }
        if (key.equals(VIDEO_SELECT_FPS) || key.equals(VIDEO_SELECT_CAMERA_FPS) || key.equals(VIDEO_SELECT_FPS_MCU) || key.equals(VIDEO_SELECT_CAMERA_FPS_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoFPS();
            return;
        }
        if (key.equals(VIDEO_USE_QOS) || key.equals(VIDEO_USE_QOS_MCU)) {
            initializeVideoQoS();
            if (videouseqos == 1) {
                getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS).setEnabled(true);
            } else {
                getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_3G).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_3G).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_3G).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_3G).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS).setEnabled(false);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS).setEnabled(false);
            }
            if (videouseqos_mcu == 1) {
                getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU_3G).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS_MCU).setEnabled(true);
                getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS_MCU).setEnabled(true);
                return;
            }
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_BITRATE_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXBITRATE_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINRESOL_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXRESOL_MCU_3G).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MINFPS_MCU).setEnabled(false);
            getPreferenceScreen().findPreference(VIDEO_SELECT_MAXFPS_MCU).setEnabled(false);
            return;
        }
        if (key.equals(VIDEO_SELECT_BITRATE) || key.equals(VIDEO_SELECT_INITBITRATE) || key.equals(VIDEO_SELECT_MAXBITRATE) || key.equals(VIDEO_SELECT_BITRATE_3G) || key.equals(VIDEO_SELECT_MAXBITRATE_3G) || key.equals(VIDEO_SELECT_BITRATE_MCU) || key.equals(VIDEO_SELECT_INITBITRATE_MCU) || key.equals(VIDEO_SELECT_MAXBITRATE_MCU) || key.equals(VIDEO_SELECT_BITRATE_MCU_3G) || key.equals(VIDEO_SELECT_MAXBITRATE_3G) || key.equals(VIDEO_SELECT_MINRESOL) || key.equals(VIDEO_SELECT_MAXRESOL) || key.equals(VIDEO_SELECT_MINRESOL_3G) || key.equals(VIDEO_SELECT_MAXRESOL_3G) || key.equals(VIDEO_SELECT_MINRESOL_MCU) || key.equals(VIDEO_SELECT_MAXRESOL_MCU) || key.equals(VIDEO_SELECT_MINRESOL_MCU_3G) || key.equals(VIDEO_SELECT_MAXRESOL_MCU_3G) || key.equals(VIDEO_SELECT_MINFPS) || key.equals(VIDEO_SELECT_MAXFPS) || key.equals(VIDEO_SELECT_MINFPS_MCU) || key.equals(VIDEO_SELECT_MAXFPS_MCU) || key.equals(VIDEO_SELECT_VFU) || key.equals(VIDEO_SELECT_VFU_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoQoS();
            return;
        }
        if (key.equals(VIDEO_SELECT_GOP) || key.equals(VIDEO_SELECT_GOP_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoGOP();
            return;
        }
        if (key.equals(VIDEO_SELECT_RESOLUTION) || key.equals(VIDEO_SELECT_CAMERA_RESOLUTION) || key.equals(VIDEO_SELECT_RESOLUTION_MCU) || key.equals(VIDEO_SELECT_CAMERA_RESOLUTION_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoResolution();
            return;
        }
        if (key.equals(VIDEO_SELECT_CAMERA_WHITEBALANCE) || key.equals(VIDEO_SELECT_CAMERA_WHITEBALANCE_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoWhiteBalance();
            return;
        }
        if (key.equals(VIDEO_SELECT_ORIENT) || key.equals(VIDEO_SELECT_ORIENT_MCU) || key.equals(VIDEO_SELECT_ORIENT_BCAMERA) || key.equals(VIDEO_SELECT_ORIENT_BCAMERA_MCU) || key.equals(VIDEO_SELECT_ORIENT_PREVIEW) || key.equals(VIDEO_SELECT_ORIENT_PREVIEW_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoOrient();
            return;
        }
        if (key.equals(VIDEO_SELECT_HEADERSPACING) || key.equals(VIDEO_SELECT_HEADERSPACING_MCU)) {
            updateEditTextPreferenceSummury(key);
            initializeVideoHeaderSpacing();
            return;
        }
        if (key.equals(VIDEO_SELECT_RTCPINTERVAL) || key.equals(VIDEO_SELECT_RTCPINTERVAL_MCU)) {
            updateEditTextPreferenceSummury(key);
            initializeVideoRTCPInterval();
            return;
        }
        if (key.equals(SELECT_SIP_DEST_PORT)) {
            updateEditTextPreferenceSummury(key);
            initializeSipDestPort();
            return;
        }
        if (key.equals(VIDEO_SELECT_RTCPBANDWIDTH) || key.equals(VIDEO_SELECT_RTCPBANDWIDTH_MCU)) {
            updateEditTextPreferenceSummury(key);
            initializeVideoRTCPBandwidth();
            return;
        }
        if (key.equals(VIDEO_SELECT_PKTMODE) || key.equals(VIDEO_SELECT_PKTMODE_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoPktMode();
            return;
        }
        if (key.equals(VIDEO_SELECT_FLIP_OPTION) || key.equals(VIDEO_SELECT_FLIP_OPTION_MCU) || key.equals(VIDEO_SELECT_FLIP_OPTION2) || key.equals(VIDEO_SELECT_FLIP_OPTION2_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoCameraFlip();
            return;
        }
        if (key.equals(VIDEO_SELECT_FRONT_ROTATION_DIRECTION) || key.equals(VIDEO_SELECT_BACK_ROTATION_DIRECTION) || key.equals(VIDEO_SELECT_FRONT_ROTATION_DIRECTION_MCU) || key.equals(VIDEO_SELECT_BACK_ROTATION_DIRECTION_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoRotateDir();
            return;
        }
        if (key.equals(VIDEO_SELECT_APP_ORIENT) || key.equals(VIDEO_SELECT_APP_ORIENT_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoAppOrient();
            return;
        }
        if (key.equals(VIDEO_USE_FEC) || key.equals(VIDEO_USE_FEC_MCU)) {
            initializeVideoFEC();
            if (videousefec == 1) {
                getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE).setEnabled(true);
            } else {
                getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE).setEnabled(false);
            }
            if (videousefec_mcu == 1) {
                getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE_MCU).setEnabled(true);
                return;
            } else {
                getPreferenceScreen().findPreference(VIDEO_SELECT_PTTYPE_MCU).setEnabled(false);
                return;
            }
        }
        if (key.equals(VIDEO_SELECT_PTTYPE) || key.equals(VIDEO_SELECT_PTTYPE_MCU)) {
            updateEditTextPreferenceSummury(key);
            initializeVideoFEC();
            return;
        }
        if (key.equals(VIDEO_SELECT_DEBUGLEVEL)) {
            updateListPreferenceSummury(VIDEO_SELECT_DEBUGLEVEL);
            initializeVideoDebugLevel();
            return;
        }
        if (key.equals("select_level_id_mcu") || key.equals(VIDEO_SELECT_REMOTE_RESOL_MCU)) {
            updateEditTextPreferenceSummury(key);
            initializeVideoLevelID();
            return;
        }
        if (key.equals(VIDEO_SELECT_REMOTE_INITBITRATE_MCU) || key.equals(VIDEO_SELECT_REMOTE_FPS_MCU) || key.equals(VIDEO_SELECT_REMOTE_QUALITY_MCU)) {
            updateListPreferenceSummury(key);
            initializeVideoLevelID();
            return;
        }
        if (key.equals(VIDEO_SAVE_STREAM)) {
            initializeVideoSaveStream();
            return;
        }
        if (key.equals(VIDEO_SELECT_SHARESCREEN_WIDTH) || key.equals(VIDEO_SELECT_SHARESCREEN_HEIGHT) || key.equals(VIDEO_SELECT_SHARESCREEN_INIT_BITRATE) || key.equals(VIDEO_SELECT_SHARESCREEN_MIN_BITRATE) || key.equals(VIDEO_SELECT_SHARESCREEN_MAX_BITRATE) || key.equals(VIDEO_SELECT_SHARESCREEN_MIN_FPS) || key.equals(VIDEO_SELECT_SHARESCREEN_MAX_FPS) || key.equals(VIDEO_SELECT_SHARESCREEN_WIDTH_MCU) || key.equals(VIDEO_SELECT_SHARESCREEN_HEIGHT_MCU) || key.equals(VIDEO_SELECT_SHARESCREEN_INIT_BITRATE_MCU) || key.equals(VIDEO_SELECT_SHARESCREEN_MIN_BITRATE_MCU) || key.equals(VIDEO_SELECT_SHARESCREEN_MAX_BITRATE_MCU) || key.equals(VIDEO_SELECT_SHARESCREEN_MIN_FPS_MCU) || key.equals(VIDEO_SELECT_SHARESCREEN_MAX_FPS_MCU) || key.equals("select_level_id_mcu")) {
            initializeShareScreenParam();
            return;
        }
        if (key.startsWith("use_")) {
            Log.m2958e("SASQP" + key);
            boolean flag = updatePreferenceStatus(key);
            setAudioConfigStatus(key, flag);
            return;
        }
        if (key.equals(RX_LIVEVOLUME)) {
            updateEditTextPreferenceSummury(RX_LIVEVOLUME);
            setReceiverModeRxVolume();
            if (rcvMode != 1) {
                jniSetLiveVolume(0, 0, rxLiveVolume);
                return;
            }
            return;
        }
        if (key.equals(TX_LIVEVOLUME)) {
            updateEditTextPreferenceSummury(TX_LIVEVOLUME);
            setReceiverModeTxVolume();
            if (rcvMode != 1) {
                jniSetLiveVolume(0, 1, txLiveVolume);
                return;
            }
            return;
        }
        if (key.equals(RX_AGC)) {
            updateEditTextPreferenceSummury(RX_AGC);
            setReceiverModeRxAGC();
            if (rcvMode != 1) {
                jniSetAGC(0, 0, rxAgcComth, rxAgcComslope, rxAgcExpth, rxAgcExpslope);
                return;
            }
            return;
        }
        if (key.equals(TX_AGC)) {
            updateEditTextPreferenceSummury(TX_AGC);
            setReceiverModeTxAGC();
            if (rcvMode != 1) {
                jniSetAGC(0, 1, txAgcComth, txAgcComslope, txAgcExpth, txAgcExpslope);
                return;
            }
            return;
        }
        if (key.equals(RX_FILTER)) {
            updateEditTextPreferenceSummury(RX_FILTER);
            setReceiverModeRxFilter();
            if (rcvMode != 1) {
                jniSetFilter(0, 0, rxFilterCo0, rxFilterCo1, rxFilterCo2, rxFilterCo3, rxFilterCo4, rxFilterCo5, rxFilterCo6);
                return;
            }
            return;
        }
        if (key.equals(TX_FILTER)) {
            updateEditTextPreferenceSummury(TX_FILTER);
            setReceiverModeTxFilter();
            if (rcvMode != 1) {
                jniSetFilter(0, 1, txFilterCo0, txFilterCo1, txFilterCo2, txFilterCo3, txFilterCo4, txFilterCo5, txFilterCo6);
                return;
            }
            return;
        }
        if (key.equals(RX_CNG)) {
            updateEditTextPreferenceSummury(RX_CNG);
            setReceiverModeRxCNG();
            if (rcvMode != 1) {
                jniSetRxCNG(rxCngGain);
                return;
            }
            return;
        }
        if (key.equals(AEC_RX_GAIN)) {
            updateEditTextPreferenceSummury(AEC_RX_GAIN);
            aecRxGain = Integer.parseInt(sharedPreferences.getString(AEC_RX_GAIN, "256"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_POST_MIN)) {
            updateEditTextPreferenceSummury(AEC_POST_MIN);
            aecPostMin = Integer.parseInt(sharedPreferences.getString(AEC_POST_MIN, "11"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_POST_GAIN)) {
            updateEditTextPreferenceSummury(AEC_POST_GAIN);
            aecPostGain = Integer.parseInt(sharedPreferences.getString(AEC_POST_GAIN, SimpleUserInfo.STATE_DENY));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_RX_DETTH1ST)) {
            updateEditTextPreferenceSummury(AEC_RX_DETTH1ST);
            aecRxDetth1st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETTH1ST, "-35"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_RX_DETHANGMAX1ST)) {
            updateEditTextPreferenceSummury(AEC_RX_DETHANGMAX1ST);
            aecRxDethangmax1st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETHANGMAX1ST, "20"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_DT_GCGAIN1ST)) {
            updateEditTextPreferenceSummury(AEC_DT_GCGAIN1ST);
            aecDtGcgain1st = Integer.parseInt(sharedPreferences.getString(AEC_DT_GCGAIN1ST, "16384"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_RX_DETTH2ST)) {
            updateEditTextPreferenceSummury(AEC_RX_DETTH2ST);
            aecRxDetth2st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETTH2ST, "-35"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_RX_DETHANGMAX2ST)) {
            updateEditTextPreferenceSummury(AEC_RX_DETHANGMAX2ST);
            aecRxDethangmax2st = Integer.parseInt(sharedPreferences.getString(AEC_RX_DETHANGMAX2ST, "20"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_DT_GCGAIN2ST)) {
            updateEditTextPreferenceSummury(AEC_DT_GCGAIN2ST);
            aecDtGcgain2st = Integer.parseInt(sharedPreferences.getString(AEC_DT_GCGAIN2ST, "16384"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_NS_ONOFF)) {
            updateEditTextPreferenceSummury(AEC_NS_ONOFF);
            aecNsOnOff = Integer.parseInt(sharedPreferences.getString(AEC_NS_ONOFF, "1"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_WEIGHT_SSNS)) {
            updateEditTextPreferenceSummury(AEC_WEIGHT_SSNS);
            aecWeightSsns = Integer.parseInt(sharedPreferences.getString(AEC_WEIGHT_SSNS, "20"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_SSGAIN_NS)) {
            updateEditTextPreferenceSummury(AEC_SSGAIN_NS);
            aecSsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_SSGAIN_NS, "11"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_NSGAIN_NS)) {
            updateEditTextPreferenceSummury(AEC_NSGAIN_NS);
            aecNsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_NSGAIN_NS, "21"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_IN_TX_GAIN)) {
            updateEditTextPreferenceSummury(AEC_IN_TX_GAIN);
            aecInTxGain = Integer.parseInt(sharedPreferences.getString(AEC_IN_TX_GAIN, "1024"));
            isChangedAec = true;
            return;
        }
        if (key.equals(AEC_OUT_TX_GAIN)) {
            updateEditTextPreferenceSummury(AEC_OUT_TX_GAIN);
            aecOutTxGain = Integer.parseInt(sharedPreferences.getString(AEC_OUT_TX_GAIN, "1024"));
            isChangedAec = true;
            return;
        }
        if (key.equals(SPK_RX_LIVEVOLUME)) {
            updateEditTextPreferenceSummury(SPK_RX_LIVEVOLUME);
            setSpeakerModeRxVolume();
            if (rcvMode != 0) {
                jniSetLiveVolume(1, 0, spkRxLiveVolume);
                return;
            }
            return;
        }
        if (key.equals(SPK_TX_LIVEVOLUME)) {
            updateEditTextPreferenceSummury(SPK_TX_LIVEVOLUME);
            setSpeakerModeTxVolume();
            if (rcvMode != 0) {
                jniSetLiveVolume(1, 1, spkTxLiveVolume);
                return;
            }
            return;
        }
        if (key.equals(SPK_RX_AGC)) {
            updateEditTextPreferenceSummury(SPK_RX_AGC);
            setSpeakerModeRxAGC();
            if (rcvMode != 0) {
                jniSetAGC(1, 0, spkRxAgcComth, spkRxAgcComslope, spkRxAgcExpth, spkRxAgcExpslope);
                return;
            }
            return;
        }
        if (key.equals(SPK_TX_AGC)) {
            updateEditTextPreferenceSummury(SPK_TX_AGC);
            setSpeakerModeTxAGC();
            if (rcvMode != 0) {
                jniSetAGC(1, 1, spkTxAgcComth, spkTxAgcComslope, spkTxAgcExpth, spkTxAgcExpslope);
                return;
            }
            return;
        }
        if (key.equals(SPK_RX_FILTER)) {
            updateEditTextPreferenceSummury(SPK_RX_FILTER);
            setSpeakerModeRxFilter();
            if (rcvMode != 0) {
                jniSetFilter(1, 0, spkRxFilterCo0, spkRxFilterCo1, spkRxFilterCo2, spkRxFilterCo3, spkRxFilterCo4, spkRxFilterCo5, spkRxFilterCo6);
                return;
            }
            return;
        }
        if (key.equals(SPK_TX_FILTER)) {
            updateEditTextPreferenceSummury(SPK_TX_FILTER);
            setSpeakerModeTxFilter();
            if (rcvMode != 0) {
                jniSetFilter(1, 1, spkTxFilterCo0, spkTxFilterCo1, spkTxFilterCo2, spkTxFilterCo3, spkTxFilterCo4, spkTxFilterCo5, spkTxFilterCo6);
                return;
            }
            return;
        }
        if (key.equals(SPK_RX_VB)) {
            updateEditTextPreferenceSummury(SPK_RX_VB);
            setSpeakerModeRxVB();
            if (rcvMode != 0) {
                jniSetRxVB(spkRxVbHpfcutoff, spkRxVbHarmonic, spkRxVbGain, spkRxVbPcmlimit);
                return;
            }
            return;
        }
        if (key.equals(AEC_SPK_RX_GAIN)) {
            updateEditTextPreferenceSummury(AEC_SPK_RX_GAIN);
            aecSpkRxGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_GAIN, "1024"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_POST_MIN)) {
            updateEditTextPreferenceSummury(AEC_SPK_POST_MIN);
            aecSpkPostMin = Integer.parseInt(sharedPreferences.getString(AEC_SPK_POST_MIN, "11"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_POST_GAIN)) {
            updateEditTextPreferenceSummury(AEC_SPK_POST_GAIN);
            aecSpkPostGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_POST_GAIN, SimpleUserInfo.STATE_DENY));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_RX_DETTH1ST)) {
            updateEditTextPreferenceSummury(AEC_SPK_RX_DETTH1ST);
            aecSpkRxDetth1st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETTH1ST, "-35"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_RX_DETHANGMAX1ST)) {
            updateEditTextPreferenceSummury(AEC_SPK_RX_DETHANGMAX1ST);
            aecSpkRxDethangmax1st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETHANGMAX1ST, "20"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_DT_GCGAIN1ST)) {
            updateEditTextPreferenceSummury(AEC_SPK_DT_GCGAIN1ST);
            aecSpkDtGcgain1st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_DT_GCGAIN1ST, "16384"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_RX_DETTH2ST)) {
            updateEditTextPreferenceSummury(AEC_SPK_RX_DETTH2ST);
            aecSpkRxDetth2st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETTH2ST, "-35"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_RX_DETHANGMAX2ST)) {
            updateEditTextPreferenceSummury(AEC_SPK_RX_DETHANGMAX2ST);
            aecSpkRxDethangmax2st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_RX_DETHANGMAX2ST, "20"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_DT_GCGAIN2ST)) {
            updateEditTextPreferenceSummury(AEC_SPK_DT_GCGAIN2ST);
            aecSpkDtGcgain2st = Integer.parseInt(sharedPreferences.getString(AEC_SPK_DT_GCGAIN2ST, "16384"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_NS_ONOFF)) {
            updateEditTextPreferenceSummury(AEC_SPK_NS_ONOFF);
            aecSpkNsOnOff = Integer.parseInt(sharedPreferences.getString(AEC_SPK_NS_ONOFF, "1"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_WEIGHT_SSNS)) {
            updateEditTextPreferenceSummury(AEC_SPK_WEIGHT_SSNS);
            aecSpkWeightSsns = Integer.parseInt(sharedPreferences.getString(AEC_SPK_WEIGHT_SSNS, "20"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_SSGAIN_NS)) {
            updateEditTextPreferenceSummury(AEC_SPK_SSGAIN_NS);
            aecSpkSsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_SPK_SSGAIN_NS, "11"));
            isChangedSpkAec = true;
            return;
        }
        if (key.equals(AEC_SPK_NSGAIN_NS)) {
            updateEditTextPreferenceSummury(AEC_SPK_NSGAIN_NS);
            aecSpkNsgainNs = Integer.parseInt(sharedPreferences.getString(AEC_SPK_NSGAIN_NS, "21"));
            isChangedSpkAec = true;
        } else if (key.equals(AEC_SPK_IN_TX_GAIN)) {
            updateEditTextPreferenceSummury(AEC_SPK_IN_TX_GAIN);
            aecInTxGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_IN_TX_GAIN, "1024"));
            isChangedAec = true;
        } else if (key.equals(AEC_SPK_OUT_TX_GAIN)) {
            updateEditTextPreferenceSummury(AEC_SPK_OUT_TX_GAIN);
            aecOutTxGain = Integer.parseInt(sharedPreferences.getString(AEC_SPK_OUT_TX_GAIN, "1024"));
            isChangedAec = true;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean is_changed = false;
        Log.m2958e("SASQP onKeyDown");
        if (keyCode == 4) {
            Log.m2958e("SASQP onKeyDown: KEYCODE_BACK");
            if (isChangedAec && useTxAec) {
                if (rcvMode == 0) {
                    jniSetAEC(0, aecRxGain, aecPostMin, aecPostGain, aecRxDetth1st, aecRxDethangmax1st, aecDtGcgain1st, aecRxDetth2st, aecRxDethangmax2st, aecDtGcgain2st, aecNsOnOff, aecWeightSsns, aecSsgainNs, aecNsgainNs, aecInTxGain, aecOutTxGain);
                }
                isChangedAec = false;
                is_changed = true;
            }
            if (isChangedSpkAec && useSpkTxAec) {
                if (rcvMode == 1) {
                    jniSetAEC(1, aecSpkRxGain, aecSpkPostMin, aecSpkPostGain, aecSpkRxDetth1st, aecSpkRxDethangmax1st, aecSpkDtGcgain1st, aecSpkRxDetth2st, aecSpkRxDethangmax2st, aecSpkDtGcgain2st, aecSpkNsOnOff, aecSpkWeightSsns, aecSpkSsgainNs, aecSpkNsgainNs, aecSpkInTxGain, aecSpkOutTxGain);
                }
                isChangedSpkAec = false;
                is_changed = true;
            }
        }
        if (is_changed) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.preference.PreferenceActivity
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference != null && preference.getKey() != null) {
            if (preference.getKey().equals(AEC_SETTING)) {
                isChangedAec = false;
            } else if (preference.getKey().equals(AEC_SPK_SETTING)) {
                isChangedSpkAec = false;
            }
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    public static int setSAESVEConfigData(int mode) {
        int re;
        Log.m2958e("SASQP setSAESVEConfigData: " + mode);
        initializeSECConfigData();
        if (mode == 0) {
            videoType = 0;
            int re2 = jniSetVideoCodec(videoCodecName, videoUseSRTP, videoCamera, videofps, videouseqos, videobitrate, videoinitbitrate, videomaxbitrate, videogop, videoresolution, videoorient, videoheaderspacing, videodebuglevel, videortcpinterval, videortcpbandwidth, videousefec, videofecpttype, videopktmode, videocameraresolution, videocamerafps, videosavestream, videolevelid_mcu, videoorientpreview, videorenerrotate, 0, 0, 0, 0, videofrontrotatedir, videobackrotatedir, videocameraflip, videocameraflip2, videovfu, videominresol, videomaxresol, videominfps, videomaxfps, videoapporient, videoorient_bcamera, videowhitebalance, sharescreen_width, sharescreen_height, sharescreen_init_bitrate, sharescreen_min_bitrate, sharescreen_max_bitrate, sharescreen_min_fps, sharescreen_max_fps, sharescreen_level_id_mcu);
            return re2;
        }
        if (mode == 1) {
            videoType = 1;
            int re3 = jniSetVideoCodec(videoCodecName_mcu, videoUseSRTP_mcu, videoCamera_mcu, videofps_mcu, videouseqos_mcu, videobitrate_mcu, videoinitbitrate_mcu, videomaxbitrate_mcu, videogop_mcu, videoresolution_mcu, videoorient_mcu, videoheaderspacing_mcu, videodebuglevel, videortcpinterval_mcu, videortcpbandwidth_mcu, videousefec_mcu, videofecpttype_mcu, videopktmode_mcu, videocameraresolution_mcu, videocamerafps_mcu, videosavestream, videolevelid_mcu, videoorientpreview_mcu, videorenerrotate_mcu, videoRemoteInitbitrate_mcu, videoRemoteFPS_mcu, videoRemoteResolution_mcu, videoRemoteQuality_mcu, videofrontrotatedir_mcu, videobackrotatedir_mcu, videocameraflip_mcu, videocameraflip2_mcu, videovfu_mcu, videominresol_mcu, videomaxresol_mcu, videominfps_mcu, videomaxfps_mcu, videoapporient_mcu, videoorient_bcamera_mcu, videowhitebalance_mcu, sharescreen_width_mcu, sharescreen_height_mcu, sharescreen_init_bitrate_mcu, sharescreen_min_bitrate_mcu, sharescreen_max_bitrate_mcu, sharescreen_min_fps_mcu, sharescreen_max_fps_mcu, sharescreen_level_id_mcu);
            return re3;
        }
        if (mode == 2) {
            int re4 = jniSetAudioCodec(audioCodecName, audioFreq, audioSrtpDomain, audioSrtpProxy, audioUseSRTP);
            return re4;
        }
        if (mode == 3) {
            int re5 = jniSetAudioCodec(audioCodecName_mcu, audioFreq_mcu, audioSrtpDomain_mcu, audioSrtpProxy_mcu, audioUseSRTP_mcu);
            return re5;
        }
        if (mode == 4) {
            re = jniSetAudioCodec(audioCodecName, audioFreq, audioSrtpDomain, audioSrtpProxy, audioUseSRTP);
        } else {
            re = jniSetAudioCodec(audioCodecName_mcu, audioFreq_mcu, audioSrtpDomain_mcu, audioSrtpProxy_mcu, audioUseSRTP_mcu);
        }
        setReceiverMode();
        if (rcvMode == 0) {
            int re6 = jniSetAudioConfigStatus(0, useRxLiveVolume, useTxLiveVolume, useRxAgc, useTxAgc, useRxFilter, useTxFilter, useRxCng, useTxAec);
            if (useRxLiveVolume) {
                re6 = jniSetLiveVolume(0, 0, rxLiveVolume);
            }
            if (useTxLiveVolume) {
                re6 = jniSetLiveVolume(0, 1, txLiveVolume);
            }
            if (useRxAgc) {
                re6 = jniSetAGC(0, 0, rxAgcComth, rxAgcComslope, rxAgcExpth, rxAgcExpslope);
            }
            if (useTxAgc) {
                re6 = jniSetAGC(0, 1, txAgcComth, txAgcComslope, txAgcExpth, txAgcExpslope);
            }
            if (useRxFilter) {
                re6 = jniSetFilter(0, 0, rxFilterCo0, rxFilterCo1, rxFilterCo2, rxFilterCo3, rxFilterCo4, rxFilterCo5, rxFilterCo6);
            }
            if (useTxFilter) {
                re6 = jniSetFilter(0, 1, txFilterCo0, txFilterCo1, txFilterCo2, txFilterCo3, txFilterCo4, txFilterCo5, txFilterCo6);
            }
            if (useRxCng) {
                re6 = jniSetRxCNG(rxCngGain);
            }
            if (useTxAec) {
                int re7 = jniSetAEC(0, aecRxGain, aecPostMin, aecPostGain, aecRxDetth1st, aecRxDethangmax1st, aecDtGcgain1st, aecRxDetth2st, aecRxDethangmax2st, aecDtGcgain2st, aecNsOnOff, aecWeightSsns, aecSsgainNs, aecNsgainNs, aecInTxGain, aecOutTxGain);
                return re7;
            }
            return re6;
        }
        if (rcvMode == 1) {
            int re8 = jniSetAudioConfigStatus(1, useSpkRxLiveVolume, useSpkTxLiveVolume, useSpkRxAgc, useSpkTxAgc, useSpkRxFilter, useSpkTxFilter, useSpkRxVb, useSpkTxAec);
            if (useSpkRxLiveVolume) {
                re8 = jniSetLiveVolume(1, 0, spkRxLiveVolume);
            }
            if (useSpkTxLiveVolume) {
                re8 = jniSetLiveVolume(1, 1, spkTxLiveVolume);
            }
            if (useSpkRxAgc) {
                re8 = jniSetAGC(1, 0, spkRxAgcComth, spkRxAgcComslope, spkRxAgcExpth, spkRxAgcExpslope);
            }
            if (useSpkTxAgc) {
                re8 = jniSetAGC(1, 1, spkTxAgcComth, spkTxAgcComslope, spkTxAgcExpth, spkTxAgcExpslope);
            }
            if (useSpkRxFilter) {
                re8 = jniSetFilter(1, 0, spkRxFilterCo0, spkRxFilterCo1, spkRxFilterCo2, spkRxFilterCo3, spkRxFilterCo4, spkRxFilterCo5, spkRxFilterCo6);
            }
            if (useSpkTxFilter) {
                re8 = jniSetFilter(1, 1, spkTxFilterCo0, spkTxFilterCo1, spkTxFilterCo2, spkTxFilterCo3, spkTxFilterCo4, spkTxFilterCo5, spkTxFilterCo6);
            }
            if (useSpkRxVb) {
                re8 = jniSetRxVB(spkRxVbHpfcutoff, spkRxVbHarmonic, spkRxVbGain, spkRxVbPcmlimit);
            }
            if (useSpkTxAec) {
                int re9 = jniSetAEC(1, aecSpkRxGain, aecSpkPostMin, aecSpkPostGain, aecSpkRxDetth1st, aecSpkRxDethangmax1st, aecSpkDtGcgain1st, aecSpkRxDetth2st, aecSpkRxDethangmax2st, aecSpkDtGcgain2st, aecSpkNsOnOff, aecSpkWeightSsns, aecSpkSsgainNs, aecSpkNsgainNs, aecSpkInTxGain, aecSpkOutTxGain);
                return re9;
            }
            return re8;
        }
        return re;
    }

    public static int getSipDestPort() {
        return sipdestport;
    }

    public static int setVideoSurfaceData(int isRemote, Object surface) {
        return jniSetSurface(isRemote, surface);
    }

    public static int setVideoPreviewData(Object surface) {
        return jniSetPreview(surface);
    }

    public static int setPreivewRotation(int degree, boolean appRotate) {
        return jniSetPreviewRotation(degree, appRotate);
    }

    public static boolean isUseFrontCamera(boolean is_conference) {
        String curCamera;
        initializeVideoCamera();
        if (is_conference) {
            curCamera = videoCamera_mcu;
        } else {
            curCamera = videoCamera;
        }
        Log.m2958e("COOLOTS currentCamera: " + curCamera);
        if ("cam_front".equals(curCamera)) {
            return true;
        }
        return false;
    }

    public static int getResolution(boolean is_conference) {
        int resolution;
        initializeVideoResolution();
        if (is_conference) {
            resolution = videoresolution_mcu;
        } else {
            resolution = videoresolution;
        }
        if (resolution == 0) {
            return 2;
        }
        if (resolution == 1) {
            return 3;
        }
        if (resolution == 2) {
            return 4;
        }
        return 5;
    }

    public static int getInitVideoBirtate(boolean is_conference) {
        initializeVideoQoS();
        return is_conference ? videoinitbitrate_mcu : videoinitbitrate;
    }

    public static int switchCamera() {
        initializeVideoCamera();
        return jniSwitchCamera(0);
    }
}
