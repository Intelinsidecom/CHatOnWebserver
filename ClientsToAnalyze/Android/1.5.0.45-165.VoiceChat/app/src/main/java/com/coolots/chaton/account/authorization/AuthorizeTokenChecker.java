package com.coolots.chaton.account.authorization;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class AuthorizeTokenChecker {
    private static final String CLASSNAME = "[AuthorizeTokenChecker]";
    private static final String COOLOTS_PACKAGE = "com.coolots.chaton";
    private static final String SA_SIGN_IN_PACKAGE = "com.osp.app.signin";
    private static final String TOKEN_REQUEST_ACTION = "com.msc.action.ACCESSTOKEN_V02_REQUEST";
    private static AuthorizeTokenChecker instance = new AuthorizeTokenChecker();

    private AuthorizeTokenChecker() {
    }

    public static AuthorizeTokenChecker getInstance() {
        return instance;
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0189 -> B:67:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x018b -> B:67:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0191 -> B:67:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x01da -> B:67:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01dc -> B:67:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01e2 -> B:67:0x00ec). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.coolots.chaton.account.authorization.AuthorizeTokenVO checkAuthorizeToken() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.account.authorization.AuthorizeTokenChecker.checkAuthorizeToken():com.coolots.chaton.account.authorization.AuthorizeTokenVO");
    }

    public Document parseXMLString(String xmlString) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));
            return document;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
            return null;
        } catch (SAXException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void renewAuthorizeToken(String expiredToken) {
        AccountManager manager = AccountManager.get(MainApplication.mContext);
        Account[] accountArr = manager.getAccountsByType("com.osp.app.signin");
        if (accountArr.length > 0) {
            Intent intent = new Intent(TOKEN_REQUEST_ACTION);
            intent.putExtra("client_id", ConfigActivity.getSamsungAccountClient_id());
            intent.putExtra("client_secret", ConfigActivity.getSamsungAccountSecret_key());
            intent.putExtra("mypackage", COOLOTS_PACKAGE);
            intent.putExtra("OSP_VER", "OSP_02");
            intent.putExtra("MODE", "BACKGROUND");
            intent.putExtra("expired_access_token", expiredToken);
            MainApplication.mContext.sendBroadcast(intent);
            return;
        }
        Intent intent2 = new Intent(TOKEN_REQUEST_ACTION);
        intent2.putExtra("client_id", ConfigActivity.getSamsungAccountClient_id());
        intent2.putExtra("client_secret", ConfigActivity.getSamsungAccountSecret_key());
        intent2.putExtra("mypackage", COOLOTS_PACKAGE);
        intent2.putExtra("OSP_VER", "OSP_02");
        intent2.putExtra("MODE", "ADD_ACCOUNT");
        MainApplication.mContext.startActivity(intent2);
    }
}
