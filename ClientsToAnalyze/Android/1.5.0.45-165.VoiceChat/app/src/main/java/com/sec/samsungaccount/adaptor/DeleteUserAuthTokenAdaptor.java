package com.sec.samsungaccount.adaptor;

import android.os.Handler;
import com.sds.coolots.common.util.Log;
import com.sec.samsungaccount.msg.DeleteUserAuthTokenRep;
import com.sec.samsungaccount.msg.JasonParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DeleteUserAuthTokenAdaptor extends AccountAdaptor {
    public static final String CLASSNAME = "[DeleteUserAuthTokenAdaptor]";
    private static final String PARAM_USERAUTH_TOKEN = "userauth_token";
    private static final String PATH = "/auth/oauth2/deauthenticate";

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public DeleteUserAuthTokenAdaptor(String userAuthToken, Handler handler) {
        super(JasonParser.DELETE_USER_AUTH_TOKEN, PATH, 0, 6000, handler);
        ArrayList<AccountParameter> params = new ArrayList<>();
        params.add(new AccountParameter(PARAM_USERAUTH_TOKEN, userAuthToken));
        setParameters(params);
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void processRecvMessage(JasonParser receivedMsg) {
        if (receivedMsg instanceof DeleteUserAuthTokenRep) {
        }
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE DeleteUserAuthTokenAdaptor");
    }
}
