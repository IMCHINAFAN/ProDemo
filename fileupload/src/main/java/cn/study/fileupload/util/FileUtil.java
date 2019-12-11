package cn.study.fileupload.util;

import java.util.UUID;

/**
 * @ClassName: FileUtil
 * @author: 10724
 * @date: Created in 2019/11/8
 * @Description:
 */
public class FileUtil {

    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getFileName(String fileOriginName) {
        return UUID.randomUUID().toString().replace("-", "") + getSuffix(fileOriginName);
    }
}
