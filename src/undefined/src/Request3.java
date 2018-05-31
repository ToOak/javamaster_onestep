package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Request3 extends AbstractReqest {
    public Request3(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 3;
    }
}
