package example2.io;

import example2.client.XiaoZhang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xiaoqin on 17-1-5.
 */
public class FileIO {

    /**
     * 把String保存到指定文件中
     * 开启子线程保存，不考虑线程复用的情况，不考虑线程间通讯
     *
     * @param fileName 文件名
     * @param content      保存的数据
     * @param xiaoZhang  XiaoZhang的实例，用于通过这个实例回调保存结果
     * @return 如果保存成功{@code true}，如果保存失败{@code false}
     */
    public void saveStrToFile(final String fileName, String content, final XiaoZhang xiaoZhang) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = getExistsFile(fileName);    //伪代码，通过文件名获取一个存在的File对象
                    writeStrToFile(content, file);        //伪代码，把str写入File对象中
                    xiaoZhang.onResult(true);     //调用Client1的onResult方法返回结果
                } catch (IOException e) {
                    e.printStackTrace();
                    xiaoZhang.onResult(false);     //调用Client1的onResult方法返回结果
                }
            }
        }).start();
    }

    private File getExistsFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private void writeStrToFile(String str, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
