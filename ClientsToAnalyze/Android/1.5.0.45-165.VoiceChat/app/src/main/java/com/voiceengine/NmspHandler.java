package com.voiceengine;

import android.content.Context;
import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.components.general.TransactionProcessingException;
import com.nuance.nmsp.client.sdk.components.resource.common.Manager;
import com.nuance.nmsp.client.sdk.components.resource.common.ManagerFactory;
import com.nuance.nmsp.client.sdk.components.resource.common.ManagerListener;
import com.nuance.nmsp.client.sdk.components.resource.common.Resource;
import com.nuance.nmsp.client.sdk.components.resource.common.ResourceException;
import com.nuance.nmsp.client.sdk.components.resource.common.ResourceUtil;
import com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXDictionary;
import com.nuance.nmsp.client.sdk.components.resource.nmas.AudioParam;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Command;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceListener;
import com.nuance.nmsp.client.sdk.components.resource.nmas.PDXCommandListener;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;
import com.nuance.nmsp.client.sdk.components.resource.nmas.QueryError;
import com.nuance.nmsp.client.sdk.components.resource.nmas.QueryResult;
import com.nuance.nmsp.client.sdk.components.resource.nmas.QueryRetry;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Sequence;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.sds.coolots.login.p018a.C1268d;
import com.sec.spp.push.Config;
import java.util.Vector;

/* loaded from: classes.dex */
public class NmspHandler {
    static final String APP_ID = "NMDPTRIAL_w_lim012020121120140604";
    static final byte[] APP_KEY = {SObjectStroke.SAMM_DEFAULT_MAX_ERASERSIZE, -89, 6, -91, ProtocolDefines.XMODE_PROTOCOL_BB_HANDSHAKE, -11, -127, -20, -15, -101, -89, 74, -115, -12, -25, -66, 45, -24, 102, 119, -42, -100, -24, -19, 38, -68, -14, 1, 6, 82, 73, 95, -7, 80, 4, 8, 69, -122, -12, 54, 33, -100, -128, -81, -112, 104, 109, -67, 80, -45, 52, 38, 111, 28, SObjectText.SAMM_DEFAULT_MAX_TEXTSIZE, -106, -40, 6, -105, -33, 88, -31, 62, 81};
    static final String SERVER_IP = "sandbox.nmdp.nuancemobility.net";
    static final short SERVER_PORT = 443;
    public static final int STATE_IDLE = 0;
    public static final int STATE_LISTENING = 1;
    public static final int STATE_THINKING = 2;
    private Command mCommand;
    private Context mContext;
    private boolean mIsStarted;
    private Manager mManager;
    private NMASResource mNmasResource;
    private OnAsrResultListener mOnAsrResultListener;
    private Parameter mQueryRequestParam;
    private String client_uid = "0123456789";
    private String phone_model = "PHONE_MODEL_PLACE_HOLDER";
    private String carrier_name = "CARRIER_NAME_PLACE_HOLDER";
    private String commandAsr = "NMDP_ASR_CMD";
    private String commandAsrFirstParam = "REQUEST_INFO";
    private String commandAsrSecondParam = "AUDIO_INFO";
    private AudioParam mAudioParam = null;
    private Object mLock = new Object();
    private ManagerListener mManagerListener = new ManagerListener() { // from class: com.voiceengine.NmspHandler.1
        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ManagerListener
        public void connected(String sessionId, Resource resource) {
            NmspHandler.this.showLogcat("We're now connected to the GW!\n(" + sessionId + ")");
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ManagerListener
        public void disconnected(Resource resource, short reasonCode) {
            NmspHandler.this.showLogcat("We're now disconnected from the GW! Reason code is :" + ((int) reasonCode));
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ManagerListener
        public void connectionFailed(Resource resource) {
            NmspHandler.this.showLogcat("Connection to the GW failed!");
        }
    };
    private NMASResourceListener mNmasListener = new NMASResourceListener() { // from class: com.voiceengine.NmspHandler.2
        @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceListener
        public void PDXCommandCreated(String sessionId) {
            NmspHandler.this.showLogcat("Command successfully created!");
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceListener
        public void PDXCreateCommandFailed() {
            NmspHandler.this.showLogcat("Failed to create command!");
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ResourceListener
        public void getParameterCompleted(short statusCode, Vector parameters, long requestId) {
            NmspHandler.this.showLogcat("Parameter(s) successfully retrieved!");
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ResourceListener
        public void getParameterFailed(short statusCode, short completionCause, long requestId) {
            NmspHandler.this.showLogcat("Failed to retrieve Parameter(s)!");
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ResourceListener
        public void resourceUnloaded(short eventCode) {
            NmspHandler.this.showLogcat("Resource unloaded!");
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ResourceListener
        public void setParameterCompleted(short statusCode, Vector parameters, long requestId) {
            NmspHandler.this.showLogcat("Parameter(s) successfully set!");
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.common.ResourceListener
        public void setParameterFailed(short statusCode, short completionCause, long requestId) {
            NmspHandler.this.showLogcat("Failed to set Parameter(s)!");
        }
    };
    private PDXCommandListener mCommandListener = new PDXCommandListener() { // from class: com.voiceengine.NmspHandler.3
        @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.PDXCommandListener
        public void PDXQueryResultReturned(QueryResult result) {
            Sequence transc = result.getSequence("transcriptions");
            String AsrResult = "--> Speech recognition result is: " + transc.getUTF8String(0);
            NmspHandler.this.showLogcat(AsrResult);
            if (NmspHandler.this.mOnAsrResultListener != null) {
                NmspHandler.this.mOnAsrResultListener.onAsrResult(transc.getUTF8String(0));
                if (!NmspHandler.this.mIsStarted) {
                    NmspHandler.this.mOnAsrResultListener.onAsrStateChanged(0);
                }
            }
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.PDXCommandListener
        public void PDXQueryErrorReturned(QueryError error) {
            NmspHandler.this.showLogcat("Received QueryError: " + error.getDescription());
            if (NmspHandler.this.mOnAsrResultListener != null) {
                NmspHandler.this.mOnAsrResultListener.onAsrError(error.getError());
            }
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.PDXCommandListener
        public void PDXQueryRetryReturned(QueryRetry retry) {
            NmspHandler.this.showLogcat("Received QueryRetry: " + retry.getName() + ", " + retry.getPrompt());
            if (NmspHandler.this.mOnAsrResultListener != null) {
                NmspHandler.this.mOnAsrResultListener.onAsrError(retry.getCause());
            }
        }

        @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.PDXCommandListener
        public void PDXCommandEvent(short eventCode) {
            NmspHandler.this.showLogcat("Received command event: " + ((int) eventCode));
            if (eventCode == 1 && NmspHandler.this.mOnAsrResultListener != null) {
                NmspHandler.this.mOnAsrResultListener.onAsrError(eventCode);
            }
        }
    };

    public interface OnAsrResultListener {
        void onAsrError(int i);

        void onAsrResult(String str);

        void onAsrStateChanged(int i);
    }

    public NmspHandler(Context context, OnAsrResultListener listener) {
        this.mManager = null;
        this.mNmasResource = null;
        this.mContext = context;
        this.mOnAsrResultListener = listener;
        initIdentities();
        this.mManager = ManagerFactory.createManager(SERVER_IP, SERVER_PORT, APP_ID, APP_KEY, this.client_uid, NMSPDefines.Codec.SPEEX_16K, NMSPDefines.Codec.SPEEX_16K, null, this.mManagerListener);
        Vector parameters = new Vector();
        parameters.add(new com.nuance.nmsp.client.sdk.components.general.Parameter(NMSPDefines.NMSP_DEFINES_ANDROID_CONTEXT, this.mContext, Parameter.Type.SDK));
        this.mNmasResource = NMASResourceFactory.createNMASResource(this.mManager, this.mNmasListener, parameters, "applicationName");
        Dictionary reqInfoParamDict = createRequestInfoDict();
        this.mQueryRequestParam = this.mNmasResource.createPDXDictParam(this.commandAsrFirstParam, reqInfoParamDict);
    }

    public void start(String language) {
        showLogcat("NmspHandler#start");
        this.mAudioParam = this.mNmasResource.createPDXAudioParam(this.commandAsrSecondParam);
        try {
            Dictionary commandDetails = createAsrCommandSettingsDict();
            this.mCommand = this.mNmasResource.createCommand(this.mCommandListener, this.commandAsr, "1", language, this.carrier_name, this.phone_model, commandDetails, Config.CONNECTION_TIMEOUT);
        } catch (ResourceException e) {
        }
        try {
            this.mCommand.sendParam(this.mQueryRequestParam);
            this.mCommand.sendParam(this.mAudioParam);
            this.mCommand.end();
            synchronized (this.mLock) {
                this.mIsStarted = true;
            }
            if (this.mOnAsrResultListener != null) {
                this.mOnAsrResultListener.onAsrStateChanged(1);
            }
        } catch (Exception e2) {
            showLogcat("Failed to send the parameter [" + e2.getClass().getName() + "] msg [" + e2.getMessage() + "]");
        }
    }

    public void addAudioBuf(byte[] buffer) {
        try {
            synchronized (this.mLock) {
                if (this.mIsStarted) {
                    this.mAudioParam.addAudioBuf(buffer, 0, buffer.length, false);
                }
            }
        } catch (TransactionProcessingException e) {
        }
    }

    public void stop() {
        showLogcat("NmspHandler#stop");
        synchronized (this.mLock) {
            this.mIsStarted = false;
        }
        try {
            if (this.mAudioParam != null) {
                this.mAudioParam.addAudioBuf(null, 0, 0, true);
            }
        } catch (TransactionProcessingException e) {
        }
        if (this.mOnAsrResultListener != null) {
            this.mOnAsrResultListener.onAsrStateChanged(2);
        }
    }

    public void shutdown() {
        showLogcat("NmspHandler#shutdown");
        if (this.mManager != null) {
            this.mManager.shutdown();
        }
    }

    private void initIdentities() {
        String tmp_client_uid = ResourceUtil.getUniqueID(this.mContext);
        if (tmp_client_uid != null && !tmp_client_uid.equals("")) {
            this.client_uid = tmp_client_uid;
        }
        String tmp_phone_model = ResourceUtil.getDeviceModel(this.mContext);
        if (tmp_phone_model != null && !tmp_phone_model.equals("")) {
            this.phone_model = tmp_phone_model;
        }
        String tmp_carrier_name = ResourceUtil.getOperatorName(this.mContext);
        if (tmp_carrier_name != null && !tmp_carrier_name.equals("")) {
            this.carrier_name = tmp_carrier_name;
        }
    }

    private Dictionary createRequestInfoDict() {
        Dictionary dict = new PDXDictionary();
        dict.addInteger("start", 0);
        dict.addInteger("end", 0);
        dict.addUTF8String("text", "");
        return dict;
    }

    private Dictionary createAsrCommandSettingsDict() {
        Dictionary dict = new PDXDictionary();
        dict.addAsciiString("dictation_type", "dictation");
        dict.addAsciiString("locale", "canada");
        dict.addAsciiString("nmaid", APP_ID);
        dict.addAsciiString("application_name", "email_client");
        dict.addAsciiString("field_id", "To_Field");
        dict.addAsciiString("phone_OS", "4.0");
        dict.addAsciiString("phone_network", "3G");
        dict.addAsciiString("audio_source", "SpeakerAndMicrophone");
        dict.addAsciiString("location", "<+29.59300303, -98.37395602> +/- 2252.00m");
        dict.addAsciiString("application_session_id", "1234567890");
        dict.addAsciiString("utterance_number", "5");
        dict.addAsciiString("ui_language", C1268d.f3196f);
        dict.addAsciiString("phone_submodel", "iPhone2,1");
        dict.addAsciiString("application_state_id", "45");
        return dict;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLogcat(String result) {
    }
}
