package example4.io;

import example4.client.ZhangClient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 将多个VIP通道合并成一个的{@link FileIO}
 */
public class FileIO {

    /**
     * 把String保存到指定文件中
     * 开启子线程保存，不考虑线程复用的情况，不考虑线程间通讯
     *
     * @param fileName 文件名
     * @param str      保存的数据
     * @param zhangClient  需要一个{@link ZhangClient}的实例
     * @return 如果保存成功{@code true}，如果保存失败{@code false}
     */
    public void saveStrToFile(String fileName, String str, ZhangClient zhangClient) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = getExistsFile(fileName);    //伪代码，通过文件名获取一个存在的File对象
                    writeStrToFile(str, file);        //伪代码，把str写入File对象中
                    zhangClient.onResult(true);
                } catch (IOException e) {
                    e.printStackTrace();
                    zhangClient.onResult(false);
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
