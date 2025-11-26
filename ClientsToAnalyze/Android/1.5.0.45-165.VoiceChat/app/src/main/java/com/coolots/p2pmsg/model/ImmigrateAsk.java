package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class ImmigrateAsk extends MsgBody {

    @NotNull
    private short FromRegion;

    @Valid
    private List<MemberDeviceInfoDump> MemberDeviceInfoDumpList = new ArrayList();

    @NotNull
    private MemberDump MemberDump;

    public short getFromRegion() {
        return this.FromRegion;
    }

    public void setFromRegion(short fromRegion) {
        this.FromRegion = fromRegion;
    }

    public void setFromRegion(int fromRegion) {
        this.FromRegion = (short) fromRegion;
    }

    public MemberDump getMemberDump() {
        return this.MemberDump;
    }

    public void setMemberDump(MemberDump memberDump) {
        this.MemberDump = memberDump;
    }

    public List<MemberDeviceInfoDump> getMemberDeviceInfoDumpList() {
        return this.MemberDeviceInfoDumpList;
    }

    public void setMemberDeviceInfoDumpList(List<MemberDeviceInfoDump> memberDeviceInfoDumpList) {
        this.MemberDeviceInfoDumpList = memberDeviceInfoDumpList;
    }
}
