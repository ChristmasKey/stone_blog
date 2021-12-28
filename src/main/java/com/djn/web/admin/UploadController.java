package com.djn.web.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 * @author ChristmasKey
 * @date 2021-12-29-1:57
 */
@RestController
@RequestMapping("/admin")
public class UploadController {

    @PostMapping("/upload")
    public UploadResult saveFile(@RequestParam("editormd-image-file") MultipartFile file,
                                 HttpServletRequest request) {
        // 得到上传的文件名
        String originalFilename = file.getOriginalFilename();
        // 截取文件后缀名
        assert originalFilename != null;
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 生成随机文件名
        String fileName = UUID.randomUUID() + suffix;

        // 得到项目的真实路径（项目部署时在jar包路径下新建static文件夹即可）
        String realPath = request.getServletContext().getRealPath("/");
        // String realPath = this.getClass().getClassLoader().getResource("static/").getPath();
        // 设置文件存放的路径
        File filePath = new File(realPath + "/upload/");
        // 判断文件目录是否存在，不存在，则新建
        if(!filePath.exists()) {
            // 目录不存在，则新建目录
            filePath.mkdir();
        }

        UploadResult uploadResult = new UploadResult();
        try {
            // 上传文件
            file.transferTo(new File(filePath, fileName));

            uploadResult.setSuccess(1);
            uploadResult.setMessage("上传成功");
            uploadResult.setUrl("http://"+
                    request.getLocalAddr() + ":"+
                    request.getServerPort() +
                    request.getContextPath() +"/upload/"+fileName);
        } catch (IOException e) {
            uploadResult.setSuccess(0);
            uploadResult.setMessage("上传失败："+e.getMessage());
            e.printStackTrace();
        }
        return uploadResult;
    }

    private class UploadResult {
        private Integer success;
        private String message;
        private String url;

        public UploadResult() {
        }

        public Integer getSuccess() {
            return success;
        }

        public void setSuccess(Integer success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "UploadResult{" +
                    "success=" + success +
                    ", message='" + message + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}