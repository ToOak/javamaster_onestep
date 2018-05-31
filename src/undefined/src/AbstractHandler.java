package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public abstract class AbstractHandler {
    protected AbstractHandler nextHandler;
    public final void handleRequest(AbstractReqest reqest){
        if (getHandleLevel() == reqest.getRequestLevel()){
            handle(reqest);
        }else {
            if (nextHandler != null){
                nextHandler.handleRequest(reqest);
            }else {
                System.out.println("All of handler can not handle the request");
            }
        }
    }
    protected abstract int getHandleLevel();
    protected abstract void handle(AbstractReqest reqest);
}
