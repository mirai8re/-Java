package Platform;

import Action.AndroidAction_12;
import Option.AndroidOption_12;
import SuperAction.AndroidSAction_12;

import Interface.IPlatform;
import Interface.IAction;
import Interface.ISuperAction;
import Interface.IOptions;

public class AndroidPlatform_12 implements IPlatform{
    @Override
    public IAction ACTION() {
        return new AndroidAction_12();
    }

    @Override
    public IOptions OPTIONS() {
        return new AndroidOption_12();
    }

    @Override
    public ISuperAction SUPER_ACTION() {
        return new AndroidSAction_12();
    }
}
