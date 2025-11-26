package com.samsung.spensdk.applistener;

import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectStroke;

/* loaded from: classes.dex */
public interface SObjectUpdateListener {
    void onSObjectChanged(SObject sObject, boolean z, boolean z2);

    void onSObjectDeleted(SObject sObject, boolean z, boolean z2, boolean z3);

    void onSObjectDeletedAll(boolean z, int i);

    void onSObjectInserted(SObject sObject, boolean z, boolean z2);

    void onSObjectSelected(SObject sObject, boolean z);

    boolean onSObjectStrokeInserting(SObjectStroke sObjectStroke);
}
