package org.luffy.services;

import static org.luffy.jooq.tables.ImageUpload.IMAGE_UPLOAD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.jooq.DSLContext;
import org.luffy.handleException.HandleNullValue;
import org.luffy.handleException.Message;
import org.luffy.models.FormData;
import org.luffy.models.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UploadService {
  @Value(value = "quarkus.http.body.uploads-directory")
  private String directory;

  @Autowired
  DSLContext query;

  public Response sendUpload(FormData data) {
    try {
      List<String> mimetype = Arrays.asList("image/jpg", "image/jpeg", "image/gif", "image/png");

      if (!mimetype.contains(data.getFile().contentType())) {
        throw new IOException("File not supported");
      }

      if (data.getFile().size() > 1024 * 1024 * 4) {
        throw new IOException("File much large");
      }

      ImageUpload imageUpload = new ImageUpload();

      String fileName = UUID.randomUUID() + "-" + data.getFile().fileName();

      imageUpload.setOriginalName(data.getFile().fileName());

      imageUpload.setKeyName(fileName);

      imageUpload.setMimetype(data.getFile().contentType());

      imageUpload.setFileSize(data.getFile().size());

      query.insertInto(IMAGE_UPLOAD, IMAGE_UPLOAD.FILE_SIZE, IMAGE_UPLOAD.KEY_NAME,
              IMAGE_UPLOAD.ORIGINAL_NAME, IMAGE_UPLOAD.MIMETYPE)
          .values(imageUpload.getFileSize().intValue(), imageUpload.getKeyName(),
              imageUpload.getOriginalName(), imageUpload.getMimetype())
          .execute();

      Files.copy(data.getFile().filePath(),
          Paths.get(directory + fileName));

      return Response.ok(imageUpload).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

  public Response removeUpload(String fileName) {
    try {
      int result = query.delete(IMAGE_UPLOAD)
          .where(IMAGE_UPLOAD.KEY_NAME.eq(fileName))
          .execute();

      if (result == 0) {
        throw new HandleNullValue("This image does not exist!!");
      }

      Files.deleteIfExists(
          Paths.get(directory + fileName));

      return Response.ok(new Message("Delete Image Successful!")).build();
    } catch (Exception e) {
      return Response.status(Status.BAD_REQUEST)
          .entity(new Message(e.getMessage()))
          .build();
    }
  }

}
