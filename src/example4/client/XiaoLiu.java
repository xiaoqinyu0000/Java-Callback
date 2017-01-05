package example4.client;

import example4.io.FileIO;

/**
 * Created by XiaoQin on 16/12/7.
 */
public class XiaoLiu extends ZhangClient {

    public static void main(String[] args) {
        new XiaoLiu().saveStr();
    }

    public void saveStr() {
        String fileName = "callback.txt";
        String str = "这是一个回调的例子。";
        FileIO fileIO = new FileIO();
        fileIO.saveStrToFile(fileName, str, this);

    }

    /**
     * 用于回调的方法，FileIO通过这个方法回调保存结果
     *
     * @param isSave 保存成功{@code true}，保存失败{@code false}
     */
    @Override
    public void onResult(boolean isSave) {
        System.out.println(isSave ? "保存成功" : "保存失败");
    }

}
