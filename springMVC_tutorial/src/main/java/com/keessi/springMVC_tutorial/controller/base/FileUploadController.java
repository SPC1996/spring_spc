package com.keessi.springMVC_tutorial.controller.base;

import com.keessi.springMVC_tutorial.form.UploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target = " + target);
        if (target.getClass() == UploadForm.class) {
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }

    @GetMapping("/uploadOneFile")
    public String uploadOneFileHandler(Model model) {
        UploadForm uploadForm = new UploadForm();
        model.addAttribute("uploadForm", uploadForm);
        return "uploadOneFile";
    }

    @PostMapping("/uploadOneFile")
    public String uploadOneFileHandlerPost(HttpServletRequest request,
                                           Model model,
                                           @ModelAttribute("uploadForm") UploadForm uploadForm) {
        return this.doUpload(request, model, uploadForm);
    }

    @GetMapping("/uploadMultiFile")
    public String uploadMultiFileHandler(Model model) {
        UploadForm uploadForm = new UploadForm();
        model.addAttribute("uploadForm", uploadForm);
        return "uploadMultiFile";
    }

    @PostMapping("/uploadMultiFile")
    public String uploadMultiFileHandlerPost(HttpServletRequest request,
                                             Model model,
                                             @ModelAttribute("uploadForm") UploadForm uploadForm) {
        return this.doUpload(request, model, uploadForm);
    }

    private String doUpload(HttpServletRequest request,
                            Model model,
                            UploadForm uploadForm) {
        String description = uploadForm.getDescription();
        System.out.println("Description: " + description);

        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("UploadRootPath = " + uploadRootPath);

        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] fileDatas = uploadForm.getFileDatas();
        List<File> uploadFiles = new ArrayList<>();
        for (CommonsMultipartFile fileData : fileDatas) {
            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = " + name);
            if (name != null && name.length() > 0) {
                try {
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    uploadFiles.add(serverFile);
                    System.out.println("Write File : " + serverFile);
                } catch (IOException e) {
                    System.out.println("Error Write File " + name);
                }
            }
        }
        model.addAttribute("description", description);
        model.addAttribute("uploadFiles", uploadFiles);
        return "uploadResult";
    }

}
