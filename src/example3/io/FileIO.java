package example3.io;

import example3.client.XiaoLiu;
import example3.client.XiaoWang;
import example3.client.XiaoZhang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

    /**
     * 把String保存到指定文件中
     * 开启子线程保存，不考虑线程复用的情况，不考虑线程间通讯
     *
     * @param fileName 文件名
     * @param str      保存的数据
     * @param xiaoLiu  zClient的实例，用于通过这个实例回调保存结果
     * @return 如果保存成功{@code true}，如果保存失败{@code false}
     */
    public void saveStrToFile(String fileName, String str, XiaoLiu xiaoLiu) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = getExistsFile(fileName);    //伪代码，通过文件名获取一个存在的File对象
                    writeStrToFile(str, file);        //伪代码，把str写入File对象中
                    xiaoLiu.onResult(true);
                } catch (IOException e) {
                    e.printStackTrace();
                    xiaoLiu.onResult(false);
                }
            }
        }).start();
    }

    /**
     * 把String保存到指定文件中
     * 开启子线程保存，不考虑线程复用的情况，不考虑线程间通讯
     *
     * @param fileName 文件名
     * @param str      保存的数据
     * @param xiaoWang  zClient的实例，用于通过这个实例回调保存结果
     * @return 如果保存成功{@code true}，如果保存失败{@code false}
     */
    public void saveStrToFile(String fileName, String str, XiaoWang xiaoWang) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = getExistsFile(fileName);    //伪代码，通过文件名获取一个存在的File对象
                    writeStrToFile(str, file);        //伪代码，把str写入File对象中
                    xiaoWang.onResult(true);
                } catch (IOException e) {
                    e.printStackTrace();
                    xiaoWang.onResult(false);
                }
            }
        }).start();
    }

    /**
     * 把String保存到指定文件中
     * 开启子线程保存，不考虑线程复用的情况，不考虑线程间通讯
     *
     * @param fileName 文件名
     * @param str      保存的数据
     * @param xiaoZhang  zClient的实例，用于通过这个实例回调保存结果
     * @return 如果保存成功{@code true}，如果保存失败{@code false}
     */
    public void saveStrToFile(String fileName, String str, XiaoZhang xiaoZhang) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = getExistsFile(fileName);    //伪代码，通过文件名获取一个存在的File对象
                    writeStrToFile(str, file);        //伪代码，把str写入File对象中
                    xiaoZhang.onResult(true);
                } catch (IOException e) {
                    e.printStackTrace();
                    xiaoZhang.onResult(false);
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
