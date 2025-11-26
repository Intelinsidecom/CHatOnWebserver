package com.sec.samsungaccount.adaptor;

import android.os.Handler;
import com.sds.coolots.common.util.Log;
import com.sec.samsungaccount.msg.CreateAuthTokenRep;
import com.sec.samsungaccount.msg.JasonParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CreateUserAuthTokenAdaptor extends AccountAdaptor {
    public static final String CLASSNAME = "[CreateUserAuthTokenAdaptor]";
    private static final String PARAM_CLIENT_ID = "client_id";
    private static final String PARAM_CLIENT_SECRET = "client_secret";
    private static final String PARAM_GRANT_TYPE = "grant_type";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_PHYSICAL_ADDRESS_TEXT = "physical_address_text";
    private static final String PARAM_SCPOE = "scope";
    private static final String PARAM_SERVICE_TYPE = "service_type";
    private static final String PARAM_USERNAME = "username";
    private static final String PATH = "/auth/oauth2/authenticate";

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public CreateUserAuthTokenAdaptor(String clientID, String userName, String password, String clientSecret, String physicalAddress, Handler handler) {
        super(90001, PATH, 0, 6000, handler);
        ArrayList<AccountParameter> params = new ArrayList<>();
        params.add(new AccountParameter(PARAM_SCPOE, "test"));
        params.add(new AccountParameter(PARAM_GRANT_TYPE, PARAM_PASSWORD));
        params.add(new AccountParameter(PARAM_CLIENT_ID, clientID));
        params.add(new AccountParameter("username", userName));
        params.add(new AccountParameter(PARAM_SERVICE_TYPE, "M"));
        params.add(new AccountParameter(PARAM_PASSWORD, password));
        params.add(new AccountParameter(PARAM_CLIENT_SECRET, clientSecret));
        params.add(new AccountParameter(PARAM_PHYSICAL_ADDRESS_TEXT, physicalAddress));
        setParameters(params);
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void processRecvMessage(JasonParser receivedMsg) {
        if (receivedMsg instanceof CreateAuthTokenRep) {
            logE("<<YHT99>> processRecvMessage SUCCESS!!!");
        }
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void printAdaptorKind() {
        logE("<<YHT99>> ADAPTOR_TRACE CreateUserAuthTokenAdaptor");
    }
}
