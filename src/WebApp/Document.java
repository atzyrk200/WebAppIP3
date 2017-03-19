package WebApp;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.Metadata;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Document {

    // TODO variables and constructors.

    /**
     * Module for deleting a particular Document from DropBox.
     *
     * @param client   DropBox connection instance
     * @param filePath Location of file we want to delete.
     * @return true if file is deleted.
     */
    static Boolean deleteFile(DbxClientV2 client, String filePath) {
        try {
            Metadata metadata = client.files().delete(filePath);
            return true;
        } catch (DbxException e) {
            e.printStackTrace();
            return false;
        }
    }

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
     * Generates MD5 checksum from file.
     * TODO adapt for file object.
     *
     * @param filename name of file to generate checksum for.
     * @return MD5 checksum as string
     */
    static String generateChecksum(String filename) {

        try {
            // Instantiating file and Hashing Algorithm.
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream file = new FileInputStream(filename);

            // Generation of checksum.
            byte[] dataBytes = new byte[1024];
            int nread;

            while ((nread = file.read(dataBytes)) != -1)
                md.update(dataBytes, 0, nread);

            // Convert byte to hex.
            byte[] mdbytes = md.digest();
            StringBuilder hexString = new StringBuilder();

            for (byte mdbyte : mdbytes) {
                String hex = Integer.toHexString(0xff & mdbyte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Return checksum as completed string.
            return hexString.toString();

        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return null;
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
