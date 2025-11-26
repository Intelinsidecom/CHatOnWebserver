package com.sec.samsungaccount.adaptor;

import android.os.Handler;
import com.sds.coolots.common.util.Log;
import com.sec.samsungaccount.msg.DeleteAccessTokenRep;
import com.sec.samsungaccount.msg.JasonParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DeleteAccessTokenAdaptor extends AccountAdaptor {
    public static final String CLASSNAME = "[DeleteAccessTokenAdaptor]";
    private static final String PARAM_ACCESS_TOKEN = "access_token";
    private static final String PATH = "/auth/oauth2/revoke";

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public DeleteAccessTokenAdaptor(String accessToken, Handler handler) {
        super(JasonParser.DELETE_ACCESS_TOKEN, PATH, 0, 6000, handler);
        ArrayList<AccountParameter> params = new ArrayList<>();
        params.add(new AccountParameter(PARAM_ACCESS_TOKEN, accessToken));
        setParameters(params);
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void processRecvMessage(JasonParser receivedMsg) {
        if (receivedMsg instanceof DeleteAccessTokenRep) {
        }
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE DeleteAccessTokenAdaptor");
    }
}
