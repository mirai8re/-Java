import Interface.IPlatform;

public class Abstract_Fabric {

    public static void main(String[] args) throws Exception {
        Platform_Builder builder = new Platform_Builder();
        IPlatform platform = builder.CreatePlatform(Platform_Version.OS.IOS_13);

        platform.ACTION().getAction();
        platform.OPTIONS().GetOption();
        platform.SUPER_ACTION().GetSuperAction();
    }
}
