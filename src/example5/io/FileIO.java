package example5.io;

import example5.callback.IFileIOCallback;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

    /**
     * 把String添加到文件中
     * 开启子线程保存，不考虑线程复用的情况，不考虑线程间通讯
     *
     * @param fileName 文件名
     * @param str      保存的数据
     * @param callback 接收携带{@link IFileIOCallback}令牌的类
     */
    public void saveStrToFile(String fileName, String str, IFileIOCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = getExistsFile(fileName);    //伪代码，通过文件名获取一个存在的File对象
                    writeStrToFile(str, file);        //伪代码，把str写入File对象中
                    callback.onResult(true);
                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onResult(false);
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
