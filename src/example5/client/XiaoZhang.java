package example5.client;

import example5.callback.IFileIOCallback;
import example5.io.FileIO;

/**
 * 携带（实现）了{@link IFileIOCallback}的@{@link XiaoZhang}
 * Created by XiaoQin on 16/12/7.
 */
public class XiaoZhang implements IFileIOCallback {

    public static void main(String[] args) {
        new XiaoZhang().saveStr();
    }

    public void saveStr() {
        String fileName = "callback.txt";
        String str = "这是一个回调的例子。";
        FileIO fileIO = new FileIO();
        fileIO.saveStrToFile(fileName, str, this);

    }

    /**
     * 实现{@link IFileIOCallback#onResult(boolean)}
     *
     * @param isSave 保存成功{@code true}，保存失败{@code false}
     */
    @Override
    public void onResult(boolean isSave) {
        System.out.println(isSave ? "保存成功" : "保存失败");
    }

}
