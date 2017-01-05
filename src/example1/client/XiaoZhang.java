package example1.client;

import example1.io.FileIO;

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
        boolean isSave = fileIO.saveStrToFile(fileName, str);   //调用FileIO的saveStrToFile方法
        System.out.println(isSave ? "保存成功" : "保存失败");
    }
}
