package com.sec.samsungaccount.adaptor;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Handler;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sec.samsungaccount.msg.CreateAccessTokenRep;
import com.sec.samsungaccount.msg.JasonParser;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CreateAccessTokenAdaptor extends AccountAdaptor {
    public static final String CLASSNAME = "[CreateAccessTokenAdaptor]";
    private static final String PARAM_CLIENT_ID = "client_id";
    private static final String PARAM_CLIENT_SECRET = "client_secret";
    private static final String PARAM_CODE = "code";
    private static final String PARAM_GRANT_TYPE = "grant_type";
    private static final String PARAM_PHYSICAL_ADDRESS_TEXT = "physical_address_text";
    private static final String PARAM_SCPOE = "scope";
    private static final String PARAM_SERVICE_TYPE = "service_type";
    private static final String PATH = "/auth/oauth2/token";

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public CreateAccessTokenAdaptor(String clientID, String clientSecret, String physicalAddress, String code, Handler handler) {
        super(JasonParser.CREATE_ACCESS_TOKEN, PATH, 0, 6000, handler);
        ArrayList<AccountParameter> params = new ArrayList<>();
        params.add(new AccountParameter(PARAM_SCPOE, "test"));
        params.add(new AccountParameter(PARAM_CLIENT_ID, clientID));
        params.add(new AccountParameter(PARAM_GRANT_TYPE, "authorization_code"));
        params.add(new AccountParameter(PARAM_SERVICE_TYPE, "M"));
        params.add(new AccountParameter(PARAM_CLIENT_SECRET, clientSecret));
        params.add(new AccountParameter(PARAM_PHYSICAL_ADDRESS_TEXT, physicalAddress));
        params.add(new AccountParameter("code", code));
        setParameters(params);
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void processRecvMessage(JasonParser receivedMsg) {
        if (receivedMsg instanceof CreateAccessTokenRep) {
            logE("ADAPTOR_TRACE CreateAccessTokenAdaptor processRecvMessage Success");
            ConfigActivity.setSamsungAccountGUID(((CreateAccessTokenRep) receivedMsg).parseUserID());
            ConfigActivity.setSamsungAccountAccessToken(((CreateAccessTokenRep) receivedMsg).parseAccessToken());
            AccountManager manager = AccountManager.get(MainApplication.mContext);
            Account[] accounts = manager.getAccounts();
            int count = accounts.length;
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                }
                Account account = accounts[i];
                if (!account.type.toString().equals(VAppPhoneManager.SAMSUNGACCOUNT_TYPESTRING)) {
                    i++;
                } else {
                    ConfigActivity.setSamsungAccountID(account.name);
                    break;
                }
            }
            sendEvent(0, 0, (CreateAccessTokenRep) receivedMsg);
        }
    }

    @Override // com.sec.samsungaccount.adaptor.AccountAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE CreateAccessTokenAdaptor");
    }
}
