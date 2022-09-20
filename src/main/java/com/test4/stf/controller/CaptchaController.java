package com.test4.stf.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public void getCode(HttpServletRequest httpServletRequest, HttpServletResponse response) {

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
        response.addHeader("Cache-Control", "post-check=0,pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capStr = null;
        BufferedImage image = null;
        ServletOutputStream outputStream = null;

        // 生成验证码
        capStr = defaultKaptcha.createText();
        image = defaultKaptcha.createImage(capStr);

        try {
            outputStream=response.getOutputStream();
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=outputStream){
                try {
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}