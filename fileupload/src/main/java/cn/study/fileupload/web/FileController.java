package cn.study.fileupload.web;

import cn.study.fileupload.bean.FilePath;
import cn.study.fileupload.util.FileUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: FileController
 * @author: 10724
 * @date: Created in 2019/11/8
 * @Description:
 */
@Controller
public class FileController {

    private final ResourceLoader resourceLoader;

    private String path = "D:/fileUpload/";
    private String virtualPath = "file/virtual/";

    @PostMapping("/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile file) {
        JSONObject json = new JSONObject();


        String fileName = file.getOriginalFilename();
        //更新文件名称
        fileName = FileUtil.getFileName(fileName);
        //生成文件
        File dest = new File(path + fileName);
        // 若文件路径不存在则创建文件
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            //将上传的文件写入dest中
            file.transferTo(dest);

            //将文件信息存入对象中
            FilePath filePath = new FilePath();
            filePath.setFileName(fileName);
            //返回的是映射后的虚拟路径
            filePath.setPath(virtualPath + fileName);

            json.put("msg", "上传成功");
            json.put("fileName", filePath.getFileName());
            json.put("filePath", filePath.getPath());
        } catch (IOException e) {
            json.put("msg", "上传失败");
            e.printStackTrace();
        }
        return json;
    }

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
