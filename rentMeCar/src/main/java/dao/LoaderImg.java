package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class LoaderImg {
    
    public String load(HttpServletRequest request, String chemin) throws IOException, ServletException {
        Part part = request.getPart( "photo" );
        String fileName = part.getSubmittedFileName();
        String path = chemin + File.separator + fileName;

        InputStream is = part.getInputStream();

        byte[] byt = new byte[is.available()];
        is.read( byt );

        FileOutputStream fos = new FileOutputStream( path );
        fos.write( byt );
        fos.flush();
        fos.close();
        
        return fileName;
    }

}
