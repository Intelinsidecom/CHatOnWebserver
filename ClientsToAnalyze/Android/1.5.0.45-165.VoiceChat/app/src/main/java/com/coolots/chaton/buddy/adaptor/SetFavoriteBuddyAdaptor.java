package com.coolots.chaton.buddy.adaptor;

import android.os.Handler;
import com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.SetFavoriteBuddyAsk;
import com.coolots.p2pmsg.model.SetFavoriteBuddyRep;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class SetFavoriteBuddyAdaptor extends HttpAdaptor {
    public static final String CLASSNAME = "[SetFavoriteBuddyAdaptor]";
    private final BuddyAdaptorHandlerInterface mResultHandler;

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public SetFavoriteBuddyAdaptor(long userNo, boolean isFavorite, Handler handler, BuddyAdaptorHandlerInterface resultHandler) {
        super(MessageInfo.SetFavoriteBuddyAsk, null, handler, 6000);
        SetFavoriteBuddyAsk ask = new SetFavoriteBuddyAsk();
        ask.setUserNo(userNo);
        if (isFavorite) {
            ask.setFavorite("Y");
        } else {
            ask.setFavorite("N");
        }
        this.mMsgBody = ask;
        this.mResultHandler = resultHandler;
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE SetFavoriteBuddyAdaptor SetFavoriteBuddyAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2pMsg) {
        if ((p2pMsg.getMsgBody() instanceof SetFavoriteBuddyRep) && this.mResultHandler != null) {
            boolean isFavorite = true;
            if (((SetFavoriteBuddyRep) p2pMsg.getMsgBody()).getFavorite().equals("N")) {
                isFavorite = false;
            }
            this.mResultHandler.favoriteBuddy(((SetFavoriteBuddyRep) p2pMsg.getMsgBody()).getUserNo(), isFavorite);
            sendEvent(0, 0, null);
        }
    }
}
