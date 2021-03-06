package edu.blog.core.base.controller;


import edu.blog.core.context.Constant;
import edu.blog.core.util.ParamUtils;
import edu.blog.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 执笔
 * @date 2019/4/9 21:48
 */
@Slf4j
public abstract class BaseController implements Constant {

    @Autowired
    protected HttpSession        session;
    @Autowired
    private   HttpServletRequest request;

    protected User sessionUser() {
        return (User) session.getAttribute(SESSION_USER);
    }

    /**
     * 保存文件
     *
     * @param file
     * @return
     */
    protected String saveFile(MultipartFile file) {
        String rootPath = null;
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath() + "/public/upload/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String back     = file.getOriginalFilename().substring(("." + file.getOriginalFilename()).lastIndexOf("."));
        String fileName = UUID.randomUUID() + "." + back;
        File   newFile  = new File(rootPath + "/" + fileName);
        newFile.getParentFile().mkdirs();
        try {
            newFile.createNewFile();
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("上传文件: " + newFile.getAbsolutePath());
        return "/upload/" + fileName;
    }

    /**
     * 将数据放在model里面
     *
     * @param model
     * @param attributes
     */
    protected void setModelAttribute(Model model, Object... attributes) {
        if (attributes != null && attributes.length > 0) {
            for (Object object : attributes) {
                if (null != object) {
                    model.addAttribute(object);
                }
            }
        }
        model.addAttribute("requestUrl", request.getRequestURI() + "?" + ParamUtils.params2String(request));
    }

    /**
     * 刷新页面
     *
     * @return
     * @Date 2016年2月24日 上午11:16:22
     */
    protected String refresh() {
        return "redirect:" + request.getHeader("Referer");
    }

    /**
     * 重定向
     *
     * @param viewName
     * @return
     */
    protected String redirect(String viewName) {
        return "redirect:" + viewName;
    }

    /**
     * 提示
     *
     * @param message
     * @return
     */
    protected String prompt(String message) {
        request.setAttribute(Constant.ERROR_MESSAGE, message);
        request.setAttribute(Constant.BACK_RUL, request.getHeader("Referer"));
        return "error";
    }

    /**
     * 提示
     *
     * @param message
     * @param backUrl
     * @return
     */
    protected String prompt(String message, String backUrl) {
        request.setAttribute(Constant.ERROR_MESSAGE, message);
        request.setAttribute(Constant.BACK_RUL, backUrl);
        return "error";
    }
}
