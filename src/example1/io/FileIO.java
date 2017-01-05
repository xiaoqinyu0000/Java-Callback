package example1.io;

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
     *
     * @param fileName 文件名
     * @param content      保存的数据
     * @return 如果保存成功{@code true}，如果保存失败{@code false}
     */
    public boolean saveStrToFile(String fileName, String content) {
        try {
            File file = getExistsFile(fileName);    //伪代码，通过文件名获取一个存在的File对象
            writeStrToFile(content, file);        //伪代码，把str写入File对象中
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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
