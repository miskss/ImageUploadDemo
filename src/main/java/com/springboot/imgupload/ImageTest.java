package com.springboot.imgupload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author peter
 * 2018/10/20 21:32
 */
@Controller
@Slf4j
public class ImageTest {

    private static String UPLOAD_PATH = "File/image/upload";

    //上传图片
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(MultipartFile image) {
        try {
            String name = image.getOriginalFilename();

            System.out.println(name);

            InputStream inputStream = image.getInputStream();
            Path directory = Paths.get(UPLOAD_PATH);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            long copy = Files.copy(inputStream, directory.resolve(name));

            return "上传成功，大小：" + copy+";url访问路径为："+UPLOAD_PATH+name;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "上传失败";
        }

    }

    //使用流将图片输出
    @GetMapping("/getImage/{name}")
    public void getImage(HttpServletResponse response, @PathVariable("name") String name) throws IOException {
        response.setContentType("image/jpeg;charset=utf-8");
        response.setHeader("Content-Disposition", "inline; filename=girls.png");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(Files.readAllBytes(Paths.get(UPLOAD_PATH).resolve(name)));
        outputStream.flush();
        outputStream.close();
    }


}

