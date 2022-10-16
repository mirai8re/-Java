package Platform;

import Interface.IAction;
import Interface.IPlatform;
import Interface.ISuperAction;
import Interface.IOptions;

import Action.IOSAction_13;
import Option.IOSOption_13;
import SuperAction.IOSSAction_13;

public class IOSPlatform_13 implements IPlatform {
    @Override
    public IAction ACTION() {
        return new IOSAction_13();
    }

    @Override
    public IOptions OPTIONS() {
        return new IOSOption_13();
    }

    @Override
    public ISuperAction SUPER_ACTION() {
        return new IOSSAction_13();
    }
}
