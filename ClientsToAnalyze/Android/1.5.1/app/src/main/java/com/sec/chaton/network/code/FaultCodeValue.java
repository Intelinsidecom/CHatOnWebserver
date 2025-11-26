package com.sec.chaton.network.code;

/* loaded from: classes.dex */
public class FaultCodeValue {

    public interface AddBuddyFaultCode extends CommonContactFaultCode {
    }

    public interface BlockBuddyFaultCode extends CommonContactFaultCode {
    }

    public interface CommonContactFaultCode {
    }

    public interface CommonFileFaultCode {
    }

    public interface DeRegistrationFaultCode extends CommonContactFaultCode {
    }

    public interface DownFileFaultCode extends CommonFileFaultCode {
    }

    public interface GLDFaultCode extends CommonContactFaultCode {
    }

    public interface GetAllUnReadMessageFaultCode extends CommonContactFaultCode {
    }

    public interface GetBlockBuddyFaultCode extends CommonContactFaultCode {
    }

    public interface GetBuddyFaultCode extends CommonContactFaultCode {
    }

    public interface GetSMSAuthTokenFaultCode {
    }

    public interface RegistrationFaultCode extends CommonContactFaultCode {
    }

    public interface SendSMSFaultCode {
    }

    public interface SetReadMessageFaultCode extends CommonContactFaultCode {
    }

    public interface TrunkFaultCode {
    }

    public interface UnBlockBuddyFaultCode extends CommonContactFaultCode {
    }

    public interface UploadAddressFaultCode extends CommonContactFaultCode {
    }

    public interface UploadFileFaultCode extends CommonFileFaultCode {
    }

    public interface UploadRelationFaultCode extends CommonContactFaultCode {
    }

    public interface UploadUserProfileDelteImageFaultCode extends CommonContactFaultCode {
    }

    public interface UploadUserProfileFaultCode extends CommonContactFaultCode {
    }

    public interface UploadUserProfileImageFaultCode extends CommonContactFaultCode {
    }

    public interface VersionFaultCode extends CommonContactFaultCode {
    }
}
