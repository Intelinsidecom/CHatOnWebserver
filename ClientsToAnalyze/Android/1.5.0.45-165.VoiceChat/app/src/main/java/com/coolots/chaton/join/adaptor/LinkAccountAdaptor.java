package com.coolots.chaton.join.adaptor;

import android.os.Handler;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.LinkAccountAsk;
import com.coolots.p2pmsg.model.LinkAccountRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sds.coolots.login.model.NationalCode;

/* loaded from: classes.dex */
public class LinkAccountAdaptor extends HttpAdaptor implements DisposeInterface {
    public static final String CLASSNAME = "[LinkAccountAdaptor]";

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public LinkAccountAdaptor(String samsungAccount, String password, NationalCode nationalCode, String phoneNo, String userName, String email, Handler handler) {
        super(MessageInfo.LinkAccountAsk, null, handler, 6000);
        LinkAccountAsk ask = new LinkAccountAsk();
        ask.setUserID(samsungAccount);
        ask.setPasswd(password);
        ask.setNationalCode(nationalCode.getIso2());
        ask.setCountryCode(Integer.valueOf(Integer.parseInt(nationalCode.getcountryCode())));
        ask.setPhoneNo(phoneNo);
        ask.setUserName(userName);
        ask.setEmail(email);
        this.mMsgBody = ask;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE LinkAccountAdaptor LinkAccountAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        MsgBody msgBody = p2pMsg.getMsgBody();
        if (msgBody instanceof LinkAccountRep) {
            handleLinkAccountRep((LinkAccountRep) msgBody);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processErrorMessage(P2PMsg p2pMsg) {
        super.processErrorMessage(p2pMsg);
    }

    private void handleLinkAccountRep(LinkAccountRep rep) {
        if ("1".equals(rep.getResult())) {
            sendEvent(0, 0, rep);
        } else {
            sendEvent(-1, 0, null);
        }
    }
}
