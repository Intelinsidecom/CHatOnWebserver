package com.csli.eztalky;

import com.coolots.p2pmsg.model.EWalletAutoChargeRep;
import com.coolots.sso.util.ChatONVAPII;
import com.csli.eztalky.p001sp.CHttpConnection;
import com.csli.eztalky.p001sp.NetUtil;
import com.csli.eztalky.p001sp.VRListener;
import com.csli.eztalky.p001sp.VRecognizer;
import com.sec.spp.push.Config;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class CSVRecognizer {
    public static final int CONNECTION_RETRY_ALL = 2;
    public static final int CONNECTION_RETRY_ONLY_CONN_EXCEPTION = 1;
    public static final int CONNECTION_RETRY_PASS = 0;
    private static final int CONNECTION_TIME_OUT = 30000;
    private static final int TRANS_TIME_OUT = 20000;
    private CHttpConnection cHttp;
    private CSListener currentListener;
    private Exception exception;

    /* renamed from: ip */
    private String f28ip;
    private Thread pThread;
    private int port;
    private ByteBuffer tmpBuffer;
    private VRecognitionListener vRecognitionListener;
    private ByteBuffer writeBuffer;

    /* renamed from: in */
    private InputStream f27in = null;
    private BufferedWriter writer = null;
    private String recogPhrase = "";
    private OutputStream out = null;
    private volatile boolean responseResult = false;
    private Object lock = new Object();
    private VRecognizer recognizer = new VRecognizer();
    private boolean isRequesting = false;
    private int timeout = 20000;
    private volatile boolean headerSended = false;
    private volatile boolean checkedError = false;
    private int connectionRetry = 3;
    private int connectionOption = 0;
    private volatile boolean netProcessing = false;
    private NetUtil netUtil = new NetUtil();
    private String currentTransactionId = "";
    private Object listenerLock = new Object();
    private volatile long ppLimitTime = 0;
    private boolean isCancel = false;
    private boolean processed = false;

    public CSVRecognizer() {
        init();
    }

    public void setDebug(boolean debug) {
        this.recognizer.DEBUG = debug;
    }

    public boolean isDebug() {
        return this.recognizer.DEBUG;
    }

    public void setTimeout(int timeout) {
        if (timeout < 1) {
            this.timeout = 20000;
        } else {
            this.timeout = timeout * 1000;
        }
    }

    public int getTimeout() {
        return this.timeout / 1000;
    }

    public void setIp(String ip) {
        this.f28ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return this.f28ip;
    }

    public int getPort() {
        return this.port;
    }

    public void setVRecognitionListener(VRecognitionListener vRecognitionListener) {
        this.vRecognitionListener = vRecognitionListener;
    }

    private void init() {
        this.tmpBuffer = ByteBuffer.allocate(8192);
        this.tmpBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.writeBuffer = ByteBuffer.allocate(8192);
        this.writeBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.recognizer.setListener(new VRListener() { // from class: com.csli.eztalky.CSVRecognizer.1
            @Override // com.csli.eztalky.p001sp.VRListener
            public void onPreparedRecording(VRecognizer evr) {
            }

            @Override // com.csli.eztalky.p001sp.VRListener
            public void onStartRecording(VRecognizer evr) {
                try {
                    CSVRecognizer.this.vRecognitionListener.onStartVR();
                } catch (Exception e) {
                    Logger.getLogger("global").log(Level.WARNING, CSVRecognizer.this.getLogTag(), (Throwable) e);
                }
                if (!CSVRecognizer.this.isDebug()) {
                    return;
                }
                Logger.getLogger("global").info(String.valueOf(CSVRecognizer.this.getLogTag()) + "START");
            }

            @Override // com.csli.eztalky.p001sp.VRListener
            public void onError(VRecognizer evr, int errorCode) throws InterruptedException, IOException {
                switch (errorCode) {
                    case 0:
                        CSVRecognizer.this.callCSListenerError(4);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 1:
                    case 2:
                    case 4:
                        CSVRecognizer.this.callCSListenerError(12);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 3:
                        CSVRecognizer.this.callCSListenerError(6);
                        break;
                    case 5:
                        CSVRecognizer.this.callCSListenerError(5);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 6:
                        CSVRecognizer.this.callCSListenerError(7);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 7:
                    case 8:
                    case 15:
                        CSVRecognizer.this.callCSListenerError(3);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 9:
                        CSVRecognizer.this.callCSListenerError(1);
                        break;
                    case 10:
                        CSVRecognizer.this.callCSListenerError(CSListener.ERROR_SERVER_UNKNOWN);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 11:
                        CSVRecognizer.this.callCSListenerError(8);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 12:
                        CSVRecognizer.this.callCSListenerError(2);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 13:
                        CSVRecognizer.this.callCSListenerError(10);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 14:
                        CSVRecognizer.this.callCSListenerError(9);
                        CSVRecognizer.this.cancelVT();
                        break;
                    case 16:
                        CSVRecognizer.this.callCSListenerError(11);
                        CSVRecognizer.this.cancelVT();
                        break;
                    default:
                        CSVRecognizer.this.callCSListenerError(9999);
                        CSVRecognizer.this.cancelVT();
                        break;
                }
                if (!CSVRecognizer.this.recognizer.isPrivateD()) {
                    return;
                }
                Logger.getLogger("global").info(String.valueOf(CSVRecognizer.this.getLogTag()) + "[PERROR]:" + errorCode);
            }

            @Override // com.csli.eztalky.p001sp.VRListener
            public void onSent(VRecognizer evr) {
                CSVRecognizer.this.ppLimitTime = System.currentTimeMillis() + 20000;
            }

            @Override // com.csli.eztalky.p001sp.VRListener
            public int onEndRecording(VRecognizer evr) throws IOException {
                if (CSVRecognizer.this.isDebug()) {
                    Logger.getLogger("global").info(String.valueOf(CSVRecognizer.this.getLogTag()) + "END");
                }
                CHttpConnection httpCon = CSVRecognizer.this.cHttp;
                if (httpCon == null) {
                    return -2;
                }
                OutputStream out = httpCon.getOutputStream();
                if (out != null) {
                    CSVRecognizer.this.ppLimitTime = System.currentTimeMillis() + 20000;
                    try {
                        out.flush();
                        CSVRecognizer.this.vRecognitionListener.onEndVR();
                        return 1;
                    } catch (Exception e) {
                        Logger.getLogger("global").log(Level.WARNING, CSVRecognizer.this.getLogTag(), (Throwable) e);
                        return -1;
                    }
                }
                return -3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        return "[CSLI_VR][TID:" + this.currentTransactionId + "][VR]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callCSListenerError(int errorCode) {
        synchronized (this.listenerLock) {
            if (!this.checkedError && !this.isCancel) {
                this.checkedError = true;
                this.isRequesting = false;
                if (!this.recognizer.isHalted()) {
                    if (isDebug()) {
                        Logger.getLogger("global").info(String.valueOf(getLogTag()) + "[ERROR]:" + errorCode);
                    }
                    try {
                        this.currentListener.onError(errorCode);
                    } catch (Exception e) {
                        Logger.getLogger("global").log(Level.WARNING, getLogTag(), (Throwable) e);
                    }
                }
            }
        }
    }

    public boolean isVoiceRecording() {
        return this.recognizer.isRecording();
    }

    public synchronized void recognize(final InputStream pcmStream) {
        if (!this.isRequesting && pcmStream != null && !this.netProcessing && this.recognizer.isReady()) {
            final SampleRate sampleRate = SampleRate.F_16k;
            this.currentTransactionId = this.netUtil.generateTransactionId();
            this.checkedError = false;
            if (this.vRecognitionListener == null) {
                throw new RuntimeException("VRecognitionListener is null!");
            }
            this.currentListener = this.vRecognitionListener;
            if (isDebug()) {
                Logger.getLogger("global").info(String.valueOf(getLogTag()) + "[CALL]recognize");
            }
            this.vRecognitionListener.onPreparedVR();
            if (isDebug()) {
                Logger.getLogger("global").info(String.valueOf(getLogTag()) + "PREPARE");
            }
            this.isRequesting = true;
            this.headerSended = false;
            new Thread(new Runnable() { // from class: com.csli.eztalky.CSVRecognizer.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CSVRecognizer.this.recognizer.initialize();
                        if (CSVRecognizer.this.processETRI(sampleRate)) {
                            CSVRecognizer.this.vRecognitionListener.recognitionCompleted(CSVRecognizer.this.recogPhrase);
                        }
                    } catch (Exception e) {
                        Logger.getLogger("global").log(Level.WARNING, CSVRecognizer.this.getLogTag(), (Throwable) e);
                        CSVRecognizer.this.recognizer.haltVoiceRecognition();
                        if (!CSVRecognizer.this.checkedError) {
                            CSVRecognizer.this.callCSListenerError(9999);
                        }
                    } finally {
                        CSVRecognizer.this.isRequesting = false;
                    }
                }
            }).start();
            new Thread(new Runnable() { // from class: com.csli.eztalky.CSVRecognizer.3
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    while (CSVRecognizer.this.isRequesting && !CSVRecognizer.this.headerSended) {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e) {
                        }
                    }
                    CHttpConnection httpCon = CSVRecognizer.this.cHttp;
                    if (httpCon != null) {
                        OutputStream out = httpCon.getOutputStream();
                        if (CSVRecognizer.this.headerSended && CSVRecognizer.this.isRequesting && out != null) {
                            CSVRecognizer.this.recognizer.startVoiceRecognition(sampleRate, pcmStream, out);
                        }
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelVT() throws InterruptedException, IOException {
        closeNet();
        if (this.isRequesting) {
            this.recognizer.haltVoiceRecognition();
            this.pThread.interrupt();
        }
    }

    public void cancel() throws InterruptedException, IOException {
        if (!this.isCancel) {
            this.isCancel = true;
            if (isDebug()) {
                Logger.getLogger("global").info(String.valueOf(getLogTag()) + "[CALL]cancelVoiceAndTranslate");
            }
            cancelVT();
            this.currentListener.onError(6);
        }
    }

    public boolean isRequesting() {
        return this.isRequesting;
    }

    public void finishVR() throws InterruptedException {
        this.recognizer.finishVR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processETRI(SampleRate sampleRate) throws Exception {
        makeHeader(sampleRate);
        this.writeBuffer.flip();
        return processProtocol();
    }

    private void setConnectionRetry(int option, int retryCount) {
        switch (option) {
            case 0:
            case 1:
            case 2:
                this.connectionOption = option;
                break;
            default:
                this.connectionOption = 0;
                break;
        }
        this.connectionRetry = retryCount;
        if (this.connectionRetry < 1) {
            this.connectionRetry = 0;
        }
    }

    public int getConnectionOption() {
        return this.connectionOption;
    }

    public int getConnectionRetry() {
        return this.connectionRetry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connCHTTP() throws IOException {
        this.cHttp = new CHttpConnection();
        this.cHttp.connect(this.f28ip, this.port, 30000, this.timeout + 20000);
        if (isDebug()) {
            Logger.getLogger("global").info("[CSLI_VR][SERVER][CONNECTED]http://" + this.f28ip + ChatONVAPII.USERID_DELEMETER + this.port);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCHTTPError(int i, Exception e) throws Exception {
        if (isDebug()) {
            Logger.getLogger("global").info("[CSLI_VR][SERVER][CONNECTION_RETRY][" + (i + 1) + "/" + this.connectionRetry + "]");
        }
        if (i == this.connectionRetry - 1) {
            throw e;
        }
        Thread.sleep(100L);
    }

    private boolean processProtocol() throws Exception {
        long time;
        this.responseResult = false;
        this.exception = null;
        this.processed = false;
        this.ppLimitTime = System.currentTimeMillis() + Config.CONNECTION_TIMEOUT + Config.DISCONNECT_TIMEOUT;
        this.isCancel = false;
        this.headerSended = false;
        this.netProcessing = true;
        this.pThread = new Thread(new Runnable() { // from class: com.csli.eztalky.CSVRecognizer.4
            @Override // java.lang.Runnable
            public void run() throws IOException {
                try {
                    try {
                        if (CSVRecognizer.this.connectionOption == 0) {
                            CSVRecognizer.this.connCHTTP();
                        } else {
                            for (int i = 0; i < CSVRecognizer.this.connectionRetry; i++) {
                                try {
                                    CSVRecognizer.this.connCHTTP();
                                } catch (ConnectException e) {
                                    CSVRecognizer.this.processCHTTPError(i, e);
                                } catch (Exception e2) {
                                    if (CSVRecognizer.this.connectionOption == 2) {
                                        CSVRecognizer.this.processCHTTPError(i, e2);
                                    }
                                }
                            }
                        }
                        try {
                            CSVRecognizer.this.cHttp.writeHeader(CSVRecognizer.this.writeBuffer.array(), CSVRecognizer.this.writeBuffer.limit());
                            CSVRecognizer.this.cHttp.getOutputStream().flush();
                            CSVRecognizer.this.ppLimitTime = System.currentTimeMillis() + CSVRecognizer.this.timeout;
                            CHttpConnection httpCon = CSVRecognizer.this.cHttp;
                            CSVRecognizer.this.headerSended = true;
                            CSVRecognizer.this.f27in = httpCon.getInputStream();
                            NetUtil.getResString(CSVRecognizer.this.f27in, 5);
                            String resultCode = NetUtil.getResString(CSVRecognizer.this.f27in, 4);
                            NetUtil.getResString(CSVRecognizer.this.f27in, 39);
                            if (EWalletAutoChargeRep.RESULT_FAILE.equals(resultCode)) {
                                CSVRecognizer.this.callCSListenerError(CSListener.ERROR_SERVER_UNKNOWN);
                                CSVRecognizer.this.exception = new IllegalStateException("Server error");
                            } else if (EWalletAutoChargeRep.RESULT_SUCCESS_TEST.equals(resultCode)) {
                                CSVRecognizer.this.processTSAS001(resultCode);
                                CSVRecognizer.this.responseResult = true;
                            } else {
                                if ("1001".equals(resultCode) || "1004".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(8);
                                } else if ("1002".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(2);
                                } else if ("1003".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(3);
                                } else if ("1004".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(8);
                                } else if ("1005".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(10);
                                } else if ("1006".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(9);
                                } else if ("1007".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(7);
                                } else if ("1008".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(3);
                                } else if ("1009".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(8);
                                } else if ("1010".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(11);
                                } else if ("1011".equals(resultCode)) {
                                    CSVRecognizer.this.callCSListenerError(1);
                                } else {
                                    CSVRecognizer.this.callCSListenerError(9999);
                                }
                                CSVRecognizer.this.exception = new IllegalStateException("Server error: " + resultCode);
                            }
                        } catch (Exception e3) {
                            CSVRecognizer.this.callCSListenerError(3);
                            if (!CSVRecognizer.this.isCancel) {
                                CSVRecognizer.this.responseResult = false;
                                CSVRecognizer.this.exception = e3;
                            }
                        }
                    } catch (Exception e4) {
                        CSVRecognizer.this.callCSListenerError(1);
                        Logger.getLogger("global").log(Level.WARNING, String.valueOf(CSVRecognizer.this.getLogTag()) + "[FAIL][NET]", (Throwable) e4);
                        CSVRecognizer.this.closeNet();
                        if (!CSVRecognizer.this.isCancel) {
                            CSVRecognizer.this.responseResult = false;
                            CSVRecognizer.this.exception = e4;
                        }
                    }
                } catch (Exception e5) {
                    if (!CSVRecognizer.this.isCancel) {
                        CSVRecognizer.this.responseResult = false;
                        CSVRecognizer.this.exception = e5;
                    }
                } finally {
                    CSVRecognizer.this.headerSended = false;
                    CSVRecognizer.this.processed = true;
                    CSVRecognizer.this.closeNet();
                }
            }
        });
        this.pThread.start();
        do {
            try {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                }
                if (this.processed) {
                    if (this.exception != null) {
                        Exception ex = this.exception;
                        this.exception = null;
                        throw ex;
                    }
                    boolean res = this.isCancel ? false : this.responseResult;
                    this.responseResult = false;
                    this.netProcessing = false;
                    synchronized (this.lock) {
                        this.lock.notifyAll();
                    }
                    return res;
                }
                time = this.ppLimitTime;
            } catch (Throwable th) {
                this.netProcessing = false;
                synchronized (this.lock) {
                    this.lock.notifyAll();
                    throw th;
                }
            }
        } while (System.currentTimeMillis() < time);
        this.netProcessing = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        closeNet();
        if (this.checkedError) {
            return false;
        }
        callCSListenerError(10);
        cancelVT();
        throw new IllegalStateException("Server communicaton Time out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTSAS001(String resultCode) throws Exception {
        if (isDebug()) {
            Logger.getLogger("global").info(String.valueOf(getLogTag()) + "[RESPONSE_CODE]" + resultCode);
        }
        if (EWalletAutoChargeRep.RESULT_SUCCESS_TEST.equals(resultCode)) {
            int len = Integer.parseInt(NetUtil.getResString(this.f27in, 5));
            this.recogPhrase = NetUtil.getEncodingResString(this.f27in, len, "EUC-KR").trim();
        } else {
            this.exception = new IllegalStateException("Unknow result[" + resultCode + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeNet() throws IOException {
        if (isDebug()) {
            Logger.getLogger("global").info("[CSLI_VR][CLOSE_NET]");
        }
        if (this.out != null) {
            try {
                this.out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.cHttp != null) {
            this.cHttp.close();
            this.cHttp = null;
        }
        if (this.f27in != null) {
            try {
                this.f27in.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (this.writer != null) {
            try {
                this.writer.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void makeHeader(SampleRate sampleRate) {
        StringBuilder builder = new StringBuilder();
        builder.append("46");
        builder.append('0');
        builder.append('U');
        builder.append(SampleRate.F_16k.equals(sampleRate) ? '0' : '1');
        builder.append(EWalletAutoChargeRep.RESULT_SUCCESS);
        builder.append("000");
        builder.append(this.currentTransactionId);
        this.writeBuffer.clear();
        this.writeBuffer.put(builder.toString().getBytes());
    }

    public void close() {
        this.recognizer.close();
    }
}
