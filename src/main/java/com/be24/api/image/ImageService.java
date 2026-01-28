package com.be24.api.image;

import java.io.IOException;
import jakarta.servlet.http.Part;

public interface ImageService {
    public String upload(Part file) throws IOException;
}