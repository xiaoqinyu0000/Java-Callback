package example5.callback;


import example5.io.FileIO;

/**
 * {@link FileIO}指定的令牌
 * Created by XiaoQin on 16/12/7.
 */
public interface IFileIOCallback {

    void onResult(boolean isSave);

}
