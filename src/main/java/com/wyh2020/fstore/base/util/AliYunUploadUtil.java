package com.wyh2020.fstore.base.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AliYunUploadUtil {

    private static String ALIYUN_BASE_PATH="cloud:/ehome/dev/";

    private static String ALIYUN_URL="https://img.1000.com";

    /**
     * 
    * @Title: uploadFileToServer
    * @param input
    * @param usercode
    * @return  json串
    * @throws IOException
    * @throws FileNotFoundException  String 返回类型
    * @throws
     */
    public static String uploadFileToServer(InputStream input, String filename, String usercode) throws IOException, FileNotFoundException {
        return uploadFileToServer(input, filename, usercode, ALIYUN_BASE_PATH);
    }


    /**
     *
     * @Title: uploadFileToServer
     * @param input
     * @param usercode
     * @param basePath
     * @return  json串
     * @throws IOException
     * @throws FileNotFoundException  String 返回类型
     * @throws
     */
    public static String uploadFileToServer(InputStream input, String filename, String usercode, String basePath) throws IOException, FileNotFoundException {
        Path cloudPath = Paths.get(URI.create(basePath + usercode + "/" + filename));
        Files.copy(input, cloudPath, StandardCopyOption.REPLACE_EXISTING);
        return ALIYUN_URL + cloudPath.toUri().toString();
    }

}
