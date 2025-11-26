package com.csli.eztalky;

import com.csli.eztalky.p001sp.CHttpConnection;
import com.csli.eztalky.p001sp.NetUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class CSTranslator {
    private static final int TRANS_TIME_OUT = 10000;
    private static boolean debug = false;
    private Exception currentException;

    /* renamed from: ip */
    private String f26ip;
    private int port;
    private String result;
    private int timeout = 10000;
    private NetUtil netUtil = new NetUtil();
    private String currentTransactionId = "";

    public static void setDebug(boolean on) {
        debug = on;
    }

    public static boolean isDebug() {
        return debug;
    }

    public void setTimeout(int timeout) {
        if (timeout < 1) {
            this.timeout = 10000;
        } else if (timeout > 10) {
            this.timeout = 10000;
        } else {
            this.timeout = timeout * 1000;
        }
    }

    public int getTimeout() {
        return this.timeout / 1000;
    }

    public void setIp(String ip) {
        this.f26ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return this.f26ip;
    }

    public int getPort() {
        return this.port;
    }

    public synchronized String translate(String source) throws Exception {
        if (source != null) {
            if (!source.equals("")) {
                final byte[] tmp = source.getBytes();
                if (tmp.length > 1024) {
                    throw new IllegalArgumentException("Too long source! max is 1024byte");
                }
                this.currentException = null;
                this.result = null;
                Thread thread = new Thread(new Runnable() { // from class: com.csli.eztalky.CSTranslator.1
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        CSTranslator.this.currentTransactionId = CSTranslator.this.netUtil.generateTransactionId();
                        CHttpConnection connection = new CHttpConnection();
                        try {
                            connection.connect(CSTranslator.this.f26ip, CSTranslator.this.port, CSTranslator.this.timeout, CSTranslator.this.timeout);
                            ByteBuffer buffer = ByteBuffer.allocate(2);
                            buffer.order(ByteOrder.LITTLE_ENDIAN);
                            buffer.putShort((short) tmp.length);
                            buffer.flip();
                            connection.getOutputStream().write(buffer.array());
                            connection.getOutputStream().write(tmp);
                            connection.getOutputStream().flush();
                            InputStream in = connection.getInputStream();
                            buffer.clear();
                            int tmp0 = in.read();
                            int tmp1 = in.read();
                            if (tmp0 == -1 || tmp1 == -1) {
                                CSTranslator.this.currentException = new IllegalStateException("Bad Network");
                            }
                            buffer.put((byte) tmp0);
                            buffer.put((byte) tmp1);
                            buffer.flip();
                            int len = buffer.getShort();
                            CSTranslator.this.result = NetUtil.replaceJapan(NetUtil.getResString(in, len).trim());
                        } catch (Exception e) {
                            Logger.getLogger("global").log(Level.WARNING, String.valueOf(CSTranslator.this.getLogTag()) + "[ERROR]", (Throwable) e);
                            CSTranslator.this.currentException = e;
                        } finally {
                            connection.close();
                        }
                    }
                });
                thread.start();
                long triggerTime = System.currentTimeMillis() + this.timeout;
                while (this.result == null && this.currentException == null && triggerTime - System.currentTimeMillis() >= 0) {
                    Thread.sleep(50L);
                }
                if (this.result != null) {
                } else {
                    if (this.currentException != null) {
                        throw this.currentException;
                    }
                    throw new IllegalStateException("Time out");
                }
            }
        }
        throw new IllegalArgumentException("Invalid source!");
        return this.result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        return "[CSLI_TR][TID:" + this.currentTransactionId + "][TRAN]";
    }
}
