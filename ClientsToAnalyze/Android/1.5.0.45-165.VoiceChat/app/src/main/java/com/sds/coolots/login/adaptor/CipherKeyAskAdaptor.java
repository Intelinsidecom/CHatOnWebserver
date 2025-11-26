package com.sds.coolots.login.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.CipherKeyAsk;
import com.coolots.p2pmsg.model.CipherKeyRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.EncodingUtil;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

/* loaded from: classes.dex */
public class CipherKeyAskAdaptor extends HttpAdaptor {
    public CipherKeyAskAdaptor(Handler handler) {
        super(MessageInfo.CipherKeyAsk, null, handler, 6000);
        CipherKeyAsk cipherKeyAsk = new CipherKeyAsk();
        String strEncodeBase64 = "";
        try {
            KeyPair rSAKeyPair = EncodingUtil.getRSAKeyPair();
            PublicKey publicKey = rSAKeyPair.getPublic();
            this.mPrivateKey = rSAKeyPair.getPrivate();
            strEncodeBase64 = EncodingUtil.encodeBase64(publicKey.getEncoded());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        cipherKeyAsk.setPublicKey(strEncodeBase64);
        cipherKeyAsk.setRequestTime(Long.valueOf(System.currentTimeMillis()));
        this.mMsgBody = cipherKeyAsk;
    }

    /* renamed from: a */
    private void m3065a() {
        logE("<<YHT100>> retryHttp!!!");
        this.mUriScheme = 0;
        this.mPath = HttpAdaptor.HTTP_DO_PATH;
        runProcess();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNetworkError(int i) {
        logE("<<YHT100>> handleNetworkError!!!");
        if (this.mUriScheme == 1) {
            m3065a();
        } else {
            super.handleNetworkError(i);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNormalError(P2PMsg p2PMsg) {
        logE("<<YHT100>> handleNormalError!!!");
        if (this.mUriScheme == 1) {
            m3065a();
        } else {
            super.handleNormalError(p2PMsg);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE CipherKeyAskAdaptor CipherKeyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof CipherKeyRep) {
            sendEvent(0, 0, msgBody);
        } else {
            sendEvent(-1, 0, null);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("<<YHT100>> processTimeOutError!!!");
        if (this.mUriScheme == 1) {
            m3065a();
        } else {
            super.processTimeOutError();
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setServerInfo() {
        super.setServerInfo();
        this.mUriScheme = 1;
        this.mPath = this.mUriScheme == 1 ? HttpAdaptor.HTTPS_DO_PATH : HttpAdaptor.HTTP_DO_PATH;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        super.setUserInfo();
        if (this.mUserID == null || this.mUserID.isEmpty()) {
            this.mUserID = "Client";
        }
    }
}
