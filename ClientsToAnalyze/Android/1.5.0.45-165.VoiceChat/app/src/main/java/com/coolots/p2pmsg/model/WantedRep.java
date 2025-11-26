package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class WantedRep extends MsgBody {

    @Valid
    private List<MemberDeviceInfoDump> MemberDeviceInfoDumpList = new ArrayList();

    @NotNull
    private MemberDump MemberDump;

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
