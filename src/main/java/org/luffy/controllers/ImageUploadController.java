package org.luffy.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.reactive.MultipartForm;
import org.luffy.models.FormData;
import org.luffy.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class ImageUploadController {

  private final UploadService uploadService;

  @Autowired
  public ImageUploadController(UploadService uploadService) {
    this.uploadService = uploadService;
  }

  @PostMapping
  public Response sendUpload(@MultipartForm FormData data) {
    return uploadService.sendUpload(data);
  }

  @DeleteMapping("{fileName}")
  public Response removeUpload(@PathVariable("fileName") String fileName) {
    return uploadService.removeUpload(fileName);
  }
}
