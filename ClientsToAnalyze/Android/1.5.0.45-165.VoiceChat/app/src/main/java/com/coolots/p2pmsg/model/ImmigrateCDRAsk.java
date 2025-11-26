package com.coolots.p2pmsg.model;

import java.util.List;
import javax.validation.Valid;

/* loaded from: classes.dex */
public class ImmigrateCDRAsk extends MsgBody {

    @Valid
    private List<CdrReceiveDump> CdrReceiveDumpList;

    @Valid
    private List<CdrSendCalleeDump> CdrSendCalleeDumpList;

    @Valid
    private List<CdrSendDump> CdrSendDumpList;

    public List<CdrSendDump> getCdrSendDumpList() {
        return this.CdrSendDumpList;
    }

    public void setCdrSendDumpList(List<CdrSendDump> cdrSendDumpList) {
        this.CdrSendDumpList = cdrSendDumpList;
    }

    public List<CdrSendCalleeDump> getCdrSendCalleeDumpList() {
        return this.CdrSendCalleeDumpList;
    }

    public void setCdrSendCalleeDumpList(List<CdrSendCalleeDump> cdrSendCalleeDumpList) {
        this.CdrSendCalleeDumpList = cdrSendCalleeDumpList;
    }

    public List<CdrReceiveDump> getCdrReceiveDumpList() {
        return this.CdrReceiveDumpList;
    }

    public void setCdrReceiveDumpList(List<CdrReceiveDump> cdrReceiveDumpList) {
        this.CdrReceiveDumpList = cdrReceiveDumpList;
    }
}
