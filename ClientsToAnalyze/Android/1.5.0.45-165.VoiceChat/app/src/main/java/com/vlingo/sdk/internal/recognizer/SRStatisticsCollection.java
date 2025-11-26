package com.vlingo.sdk.internal.recognizer;

import com.vlingo.sdk.internal.http.BaseHttpCallback;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes.dex */
public class SRStatisticsCollection extends BaseHttpCallback {
    private static final int SEND_WAIT_TIME = 10000;
    private static final Logger log = Logger.getLogger(SRStatisticsCollection.class);
    private String acceptedText;
    private final Vector<Object> collection = new Vector<>();

    public void addStatistics(SRStatistics statistics) {
        if (statistics != null) {
            int size = this.collection.size();
            for (int i = 0; i < size; i++) {
                SRStatisticsGroup group = (SRStatisticsGroup) this.collection.elementAt(i);
                if (group.mergeStatistics(statistics)) {
                    return;
                }
            }
            SRStatisticsGroup group2 = new SRStatisticsGroup(statistics, null);
            this.collection.addElement(group2);
        }
    }

    public void setAcceptedText(String acceptedText) {
        this.acceptedText = acceptedText;
    }

    public Enumeration<?> getCollectionElements() {
        return this.collection.elements();
    }

    public String getAcceptedText() {
        return this.acceptedText;
    }

    public void schedule(SRServerDetails serverDetails, ClientMeta clientMeta, SoftwareMeta softwareMeta) {
        Enumeration<?> en = this.collection.elements();
        while (en.hasMoreElements()) {
            SRStatisticsGroup group = (SRStatisticsGroup) en.nextElement();
            group.schedule(serverDetails, clientMeta, softwareMeta);
        }
    }

    public void onRetrysExhausted() {
    }

    public static final class SRStatisticsGroup {
        private final Vector<Object> groupedStatistics;
        private final String guttID;

        private SRStatisticsGroup(SRStatistics newStatistics) {
            this.groupedStatistics = new Vector<>();
            this.guttID = newStatistics.getGuttId();
            this.groupedStatistics.addElement(newStatistics);
        }

        /* synthetic */ SRStatisticsGroup(SRStatistics sRStatistics, SRStatisticsGroup sRStatisticsGroup) {
            this(sRStatistics);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean mergeStatistics(SRStatistics statsToMerge) {
            if (!this.guttID.equals(statsToMerge.getGuttId())) {
                return false;
            }
            this.groupedStatistics.addElement(statsToMerge);
            return true;
        }

        private String getXML() {
            StringBuffer sb = new StringBuffer();
            sb.append("<Stats ");
            sb.append(HttpUtil.genAtr("guttid", this.guttID));
            sb.append(">");
            int size = this.groupedStatistics.size();
            for (int i = 0; i < size; i++) {
                SRStatistics stats = (SRStatistics) this.groupedStatistics.elementAt(i);
                sb.append(stats.getXML(false));
            }
            sb.append("</Stats>");
            return sb.toString();
        }

        public void schedule(SRServerDetails serverDetails, ClientMeta clientMeta, SoftwareMeta softwareMeta) {
            SRStatisticsCollection.log.debug("Begin Send Stats");
            try {
                String xml = getXML();
                SRStatisticsCollection.log.debug(xml);
                VLHttpServiceRequest request = VLHttpServiceRequest.createVLRequest("SRStats", new BaseHttpCallback(), serverDetails.getStatsURL(), xml);
                request.setClientMeta(clientMeta);
                request.setSoftwareMeta(softwareMeta);
                request.setMaxRetry(2);
                request.schedule(10000L, false, false);
            } catch (Exception ex) {
                SRStatisticsCollection.log.debug("SendStats: " + ex.toString());
            } finally {
                SRStatisticsCollection.log.debug("End Send Stats");
            }
        }
    }
}
