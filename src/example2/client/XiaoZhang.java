package example2.client;

import example2.io.FileIO;

/**
 * Created by xiaoqin on 17-1-5.
 */
public class XiaoZhang {

    public static void main(String[] args) {
        new XiaoZhang().saveStr();
    }

    public void saveStr() {
        String fileName = "callback.txt";
        String str = "这是一个普通的例子。";
        FileIO fileIO = new FileIO();   //初始化一个FileIO
        fileIO.saveStrToFile(fileName, str, this);   //调用FileIO的saveStrToFile方法
    }

    /**
     * 用于回调的方法，FileIO通过这个方法回调保存结果
     *
     * @param isSave 保存成功{@code true}，保存失败{@code false}
     */
    public void onResult(boolean isSave) {
        System.out.println(isSave ? "保存成功" : "保存失败");
    }
}
