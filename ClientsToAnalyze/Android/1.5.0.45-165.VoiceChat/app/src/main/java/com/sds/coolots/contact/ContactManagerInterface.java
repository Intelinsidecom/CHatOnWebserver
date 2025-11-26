package com.sds.coolots.contact;

import android.os.Handler;
import com.coolots.p2pmsg.model.ConferenceInfo;
import com.sds.coolots.call.BlockCallHandler;
import com.sds.coolots.call.model.Destination;
import java.util.Date;

/* loaded from: classes.dex */
public interface ContactManagerInterface {
    String getUserNameByUserID(String str);

    boolean isBlockPhoneNo(String str, Handler handler);

    boolean isBlockUser(String str, Handler handler);

    boolean isBlockUserForCall(String str, short s, Destination destination, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, Date date, BlockCallHandler blockCallHandler);

    boolean isBlockUserForConf(String str, Destination destination, ConferenceInfo conferenceInfo, Date date, String str2, BlockCallHandler blockCallHandler, String str3);

    boolean isFriend(String str);
}
