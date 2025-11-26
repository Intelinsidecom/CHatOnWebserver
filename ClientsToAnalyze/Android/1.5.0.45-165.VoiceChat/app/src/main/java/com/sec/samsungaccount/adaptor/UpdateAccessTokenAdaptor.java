package com.sec.samsungaccount.adaptor;

import android.os.Handler;
import com.sds.coolots.common.util.Log;
import com.sec.samsungaccount.msg.JasonParser;
import com.sec.samsungaccount.msg.UpdateAccessTokenRep;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UpdateAccessTokenAdaptor extends AccountAdaptor {
    public static final String CLASSNAME = "[UpdateAccessTokenAdaptor]";
    private static final String PARAM_CLIENT_ID = "client_id";
    private static final String PARAM_CLIENT_SECRET = "client_secret";
    private static final String PARAM_GRANT_TYPE = "grant_type";
    private static final String PARAM_PHYSICAL_ADDRESS_TEXT = "physical_address_text";
    private static final String PARAM_REFRESH_TOKEN = "refresh_token";
    private static final String PARAM_SCPOE = "scope";
    private static final String PARAM_SERVICE_TYPE = "service_type";
    private static final String PATH = "/auth/oauth2/token";

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public UpdateAccessTokenAdaptor(String refreshToken, String clientID, String clientSecret, String physicalAddress, Handler handler) {
        super(JasonParser.UPDATE_ACCESS_TOKEN, PATH, 0, 6000, handler);
        ArrayList<AccountParameter> params = new ArrayList<>();
        params.add(new AccountParameter(PARAM_REFRESH_TOKEN, refreshToken));
        params.add(new AccountParameter(PARAM_SCPOE, "test"));
        params.add(new AccountParameter(PARAM_CLIENT_ID, clientID));
        params.add(new AccountParameter(PARAM_GRANT_TYPE, PARAM_REFRESH_TOKEN));
        params.add(new AccountParameter(PARAM_SERVICE_TYPE, "M"));
        params.add(new AccountParameter(PARAM_CLIENT_SECRET, clientSecret));
        params.add(new AccountParameter(PARAM_PHYSICAL_ADDRESS_TEXT, physicalAddress));
        setParameters(params);
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void processRecvMessage(JasonParser receivedMsg) {
        if (receivedMsg instanceof UpdateAccessTokenRep) {
        }
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE UpdateAccessTokenAdaptor");
    }
}
