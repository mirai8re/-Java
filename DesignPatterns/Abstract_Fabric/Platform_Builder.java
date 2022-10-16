import Interface.IPlatform;
import Platform.AndroidPlatform_12;
import Platform.IOSPlatform_13;

public class Platform_Builder {

    public static IPlatform CreatePlatform(Platform_Version.OS OperatingSystem) throws Exception {
        switch(OperatingSystem) {
            case IOS_13:
                return new IOSPlatform_13();

            case ANDROID_12:
                return new AndroidPlatform_12();

            default:
                throw new IllegalStateException("Unexpected value: " + OperatingSystem.toString());
        }

    }

}
