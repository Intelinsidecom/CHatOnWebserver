package com.nuance.nmsp.client.sdk.components.resource.common;

import java.util.Vector;

/* loaded from: classes.dex */
public interface Resource {
    void freeResource(int i) throws ResourceException;

    long getParams(Vector vector) throws ResourceException;

    long setParams(Vector vector) throws ResourceException;
}
