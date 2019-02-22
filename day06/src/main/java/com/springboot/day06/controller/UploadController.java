package com.springboot.day06.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

  private static String UPLOADED_FOLDER = "/Users/czy/Downloads/ideUpLoad/";

  @RequestMapping("/uploadPage")
  public String uploadPage() {
    return "upload";
  }

  @RequestMapping("/uploadStatus")
  public String uploadStatus() {
    return "uploadStatus";
  }

  @RequestMapping(name = "/upload", method = RequestMethod.POST)
  public String singleFileUpload(@RequestParam("file") MultipartFile file,
      RedirectAttributes redirectAttributes) {
    if (file.isEmpty()) {
      redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
      return "redirect:uploadStatus";
    }
    try {
      // Get the file and save it somewhere
      byte[] bytes = file.getBytes();
      Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
      Files.write(path, bytes);

      redirectAttributes.addFlashAttribute("message",
          "You successfully uploaded '" + file.getOriginalFilename() + "'");

    } catch (IOException e) {
      e.printStackTrace();
    }

    return "redirect:/uploadStatus";
  }
}
