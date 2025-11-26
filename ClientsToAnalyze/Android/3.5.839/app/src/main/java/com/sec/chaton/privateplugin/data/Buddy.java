package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class Buddy {
    private Boolean authenticated;
    private String birthday;
    private String countrycode;
    private String devicetype;
    private String einfo;
    private String email;
    private String group;

    /* renamed from: id */
    private String f11227id;
    private String imgstatus;
    private Boolean isblind;
    private String msisdns;
    private String name;
    private String orgname;
    private String orgnum;
    private String sainfo;
    private String samsungemail;
    private Boolean showphonenumber;
    private String status;
    private Long statusupdatetime;

    public enum BuddyImageStatus {
        PROFILE_UPDATED(1),
        PROFILE_DELETED(2),
        NONE_PROFILE(3),
        NOT_CHANGE(4);

        private int code;

        BuddyImageStatus(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public BuddyImageStatus getImagestatus() throws NumberFormatException {
        if (this.imgstatus == null || this.imgstatus.equals("")) {
            return BuddyImageStatus.NOT_CHANGE;
        }
        return BuddyImageStatus.values()[Integer.parseInt(this.imgstatus) - 1];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Buddy [name=").append(this.name).append(", group=").append(this.group).append(", status=").append(this.status).append(", einfo=").append(this.einfo).append(", birthday=").append(this.birthday).append(", orgname=").append(this.orgname).append(", id=").append(this.f11227id).append(", orgnum=").append(this.orgnum).append(", email=").append(this.email).append(", showphonenumber=").append(this.showphonenumber).append(", msisdns=").append(this.msisdns).append(", samsungemail=").append(this.samsungemail).append(", isblind=").append(this.isblind).append(", statusupdatetime=").append(this.statusupdatetime).append(", sainfo=").append(this.sainfo).append(", imgstatus=").append(this.imgstatus).append(", devicetype=").append(this.devicetype).append(", authenticated=").append(this.authenticated).append(", countrycode=").append(this.countrycode).append("]");
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public String getGroup() {
        return this.group;
    }

    public String getStatus() {
        return this.status;
    }

    public String getOrgname() {
        return this.orgname;
    }

    public String getEinfo() {
        return this.einfo;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getId() {
        return this.f11227id;
    }

    public String getOrgnum() {
        return this.orgnum;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isShowphonenumber() {
        return this.showphonenumber.booleanValue();
    }

    public String getMsisdns() {
        return this.msisdns;
    }

    public String getSamsungemail() {
        return this.samsungemail;
    }

    public Long getStatusupdatetime() {
        return this.statusupdatetime;
    }

    public String getSainfo() {
        return this.sainfo;
    }

    public String getImgstatus() {
        return this.imgstatus;
    }

    public Boolean getAuthenticated() {
        return this.authenticated;
    }

    public void setAuthenticated(Boolean bool) {
        this.authenticated = bool;
    }

    public String getCountryCode() {
        return this.countrycode;
    }

    public void setCountryCode(String str) {
        this.countrycode = str;
    }
}
