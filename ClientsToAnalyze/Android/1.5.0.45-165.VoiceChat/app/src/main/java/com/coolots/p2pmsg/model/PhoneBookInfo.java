package com.coolots.p2pmsg.model;

import com.coolots.common.util.StringUtil;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class PhoneBookInfo implements Comparable<PhoneBookInfo> {

    @Min(0)
    private int CountryCode;

    @NotNull
    @Size(max = 64, min = 1)
    private String PhoneNo;

    public int getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(int countryCode) {
        this.CountryCode = countryCode;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    @Override // java.lang.Comparable
    public int compareTo(PhoneBookInfo phoneBookInfo) {
        int oldCountryCode = this.CountryCode;
        int newCountryCode = phoneBookInfo.getCountryCode();
        if (oldCountryCode > newCountryCode) {
            return 1;
        }
        if (oldCountryCode == newCountryCode) {
            return 0;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        PhoneBookInfo phoneBookInfo = (PhoneBookInfo) obj;
        if (this.CountryCode == phoneBookInfo.getCountryCode()) {
            if ((this.PhoneNo != null && phoneBookInfo.getPhoneNo() != null && this.PhoneNo.equals(phoneBookInfo.getPhoneNo())) || (this.PhoneNo == null && phoneBookInfo.getPhoneNo() == null)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
