package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ServerInfoRep extends MsgBody {

    @NotNull
    @Valid
    @Size(min = 1)
    private List<Server> Servers = new ArrayList();

    public List<Server> getServers() {
        return this.Servers;
    }

    public void setServers(List<Server> servers) {
        this.Servers = servers;
    }
}
