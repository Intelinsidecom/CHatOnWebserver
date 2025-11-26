package com.coolots.chaton.buddy.model;

import com.coolots.p2pmsg.model.PhoneBookInfo;
import java.util.List;

/* loaded from: classes.dex */
public class NativePhoneBookInfo {
    private List<NativeNameAndPhoneNumberInfo> nativeNameInfoList;
    private List<PhoneBookInfo> phoneBookInfoList;

    public void setPhoneBookInfoList(List<PhoneBookInfo> phoneBookInfoList) {
        this.phoneBookInfoList = phoneBookInfoList;
    }

    public List<PhoneBookInfo> getPhoneBookInfoList() {
        return this.phoneBookInfoList;
    }

    public void setNativeNameInfoList(List<NativeNameAndPhoneNumberInfo> nativeNameInfoList) {
        this.nativeNameInfoList = nativeNameInfoList;
    }

    public List<NativeNameAndPhoneNumberInfo> getNativeNameInfoList() {
        return this.nativeNameInfoList;
    }
}
