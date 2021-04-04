package com.liger.common.file.controller;

import com.liger.common.common.result.LigerResult;
import org.apache.commons.httpclient.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class UploadController {

    @PostMapping("/upload")
    public LigerResult<?> upload(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return LigerResult.of(HttpStatus.SC_BAD_REQUEST, "请选择文件");
        }

        String fileName = file.getOriginalFilename();
        String filePath = "/root/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return LigerResult.ok("上传成功");
        } catch (IOException ignored) {
        }
        return LigerResult.of(HttpStatus.SC_BAD_GATEWAY, "上传失败");
    }

}
