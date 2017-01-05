package example4.client;


/**
 * Client家族的标志，所有Client家族的成员都继承{@link ZhangClient}
 * Created by XiaoQin on 16/12/7.
 */
public abstract class ZhangClient {

    /**
     * 子类需要实现这个抽象方法
     *
     * @param isSave
     */
    public abstract void onResult(boolean isSave);

}
