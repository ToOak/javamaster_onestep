package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public abstract class AbstractReqest {
    private Object obj;
    public AbstractReqest(Object obj){
        this.obj = obj;
    }
    public Object getContent(){
        return obj;
    }
    public abstract int getRequestLevel();
}
