package com.sec.samsungaccount.adaptor;

import android.os.Handler;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;
import com.sec.samsungaccount.msg.CreateAuthCodeRep;
import com.sec.samsungaccount.msg.JasonParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CreateAuthCodeAdaptor extends AccountAdaptor {
    public static final String CLASSNAME = "[CreateAuthCodeAdaptor]";
    private static final String PARAM_CLIENT_ID = "client_id";
    private static final String PARAM_PHYSICAL_ADDRESS_TEXT = "physical_address_text";
    private static final String PARAM_RESPONSE_TYPE = "response_type";
    private static final String PARAM_SCOPE = "scope";
    private static final String PARAM_SERVICE_TYPE = "service_type";
    private static final String PARAM_STATE = "state";
    private static final String PARAM_USERAUTH_TOKEN = "userauth_token";
    private static final String PATH = "/auth/oauth2/authorize";

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public CreateAuthCodeAdaptor(String clientID, String userAuthToken, String physicalAddress, Handler handler) {
        super(90002, PATH, 1, 6000, handler);
        ArrayList<AccountParameter> params = new ArrayList<>();
        params.add(new AccountParameter(PARAM_STATE, "test"));
        params.add(new AccountParameter(PARAM_SCOPE, "test"));
        params.add(new AccountParameter(PARAM_CLIENT_ID, clientID));
        params.add(new AccountParameter(PARAM_RESPONSE_TYPE, DatabaseHelper.KEY_REGIONCODE));
        params.add(new AccountParameter(PARAM_SERVICE_TYPE, "M"));
        params.add(new AccountParameter(PARAM_USERAUTH_TOKEN, userAuthToken));
        params.add(new AccountParameter(PARAM_PHYSICAL_ADDRESS_TEXT, physicalAddress));
        setParameters(params);
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void processRecvMessage(JasonParser receivedMsg) {
        if (receivedMsg instanceof CreateAuthCodeRep) {
        }
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE CreateAuthCodeAdaptor");
    }
}
