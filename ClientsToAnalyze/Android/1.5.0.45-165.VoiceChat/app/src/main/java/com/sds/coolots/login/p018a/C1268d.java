package com.sds.coolots.login.p018a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.sds.coolots.MainApplication;
import com.sds.coolots.login.model.NationalCode;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.sds.coolots.login.a.d */
/* loaded from: classes.dex */
public final class C1268d {

    /* renamed from: a */
    public static final int f3191a = MainApplication.mResources.getXmlNationalCodeList();

    /* renamed from: b */
    public static final String f3192b = "nc";

    /* renamed from: c */
    public static final String f3193c = "mcc";

    /* renamed from: d */
    public static final String f3194d = "iso2";

    /* renamed from: e */
    public static final String f3195e = "kr";

    /* renamed from: f */
    public static final String f3196f = "en";

    /* renamed from: g */
    public static final String f3197g = "cc";

    /* renamed from: h */
    public static final String f3198h = "ac";

    /* renamed from: i */
    public static final String f3199i = "zero_space";

    /* renamed from: a */
    public static ArrayList m3064a(Context context, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xml = context.getResources().getXml(i);
        String name = "";
        NationalCode nationalCode = null;
        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
            switch (eventType) {
                case 2:
                    name = xml.getName();
                    if (name.equals(f3192b)) {
                        nationalCode = new NationalCode();
                        break;
                    } else {
                        break;
                    }
                case 3:
                    name = xml.getName();
                    if (name.equals(f3192b)) {
                        arrayList.add(nationalCode);
                        nationalCode = null;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (nationalCode == null) {
                        break;
                    } else if (name.equals("iso2")) {
                        nationalCode.setIso2(xml.getText());
                        break;
                    } else if (name.equals(f3195e)) {
                        nationalCode.setnameKor(xml.getText());
                        break;
                    } else if (name.equals(f3196f)) {
                        nationalCode.setnameEng(xml.getText());
                        break;
                    } else if (name.equals(f3197g)) {
                        nationalCode.setcountryCode(xml.getText());
                        break;
                    } else if (name.equals(f3198h)) {
                        nationalCode.setAreaCode(xml.getText());
                        break;
                    } else if (name.equals("mcc")) {
                        nationalCode.setMCC(xml.getText());
                        break;
                    } else if (name.equals("zero_space")) {
                        if (Integer.parseInt(xml.getText()) == 0) {
                            nationalCode.setZeroSpace(false);
                            break;
                        } else {
                            nationalCode.setZeroSpace(true);
                            break;
                        }
                    } else {
                        break;
                    }
            }
        }
        return arrayList;
    }
}
