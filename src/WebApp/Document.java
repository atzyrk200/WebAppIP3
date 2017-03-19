package WebApp;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.*;

public class Document {

    /**
     * Module for handling downloading of documents VIA DropBox.
     *
     * @param filePath Location of file we want to download.
     * @param client   DropBox connection instance
     * @return Object downloaded from DropBox.
     */
    static OutputStream downloadFile(String filePath, DbxClientV2 client) {
        try {
            OutputStream os = new FileOutputStream(filePath);
            FileMetadata metadata = client.files().downloadBuilder(filePath).download(os);
            return os;
        } catch (DbxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Module for handling uploading of documents VIA DropBox.
     *
     * @param user_id     User ID.
     * @param document_id Document ID. (For this instance, the file path.)
     * @param client      DropBox connection instance.
     * @return Location of the newly uploaded file.
     */
    static String uploadFile(String user_id, String document_id, DbxClientV2 client) {
        final String filePath = String.format("/%s/%s", user_id, document_id); // Renaming for versions?
        try (InputStream in = new FileInputStream(filePath)) {
            FileMetadata metadata = client.files().uploadBuilder(filePath).uploadAndFinish(in);
            System.out.println("Successfully uploaded " + document_id);
            return filePath;
        } catch (IOException | DbxException e) {
            e.printStackTrace();
            return null;
        }
    }

}
