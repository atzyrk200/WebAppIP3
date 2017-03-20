package WebApp;

public class document {

    private String revisionNumber;
    private String documentTitle;
    private String documentAuthor;
    private String documentCreationDate;
    private String documentPath;
    private String documentStatus;

    public document(String name, String documentTitle, String author)
    {
    }

    public document(String revisionNumber, String documentTitle, String documentAuthor, String documentCreationDate, String documentPath, String documentStatus)
    {
        this.revisionNumber = revisionNumber;
        this.documentAuthor = documentAuthor;
        this.documentCreationDate = documentCreationDate;
        this.documentPath = documentPath;
        this.documentStatus = documentStatus;
    }

    public document() {

    }

    public String getRevisionNumber(){
        return revisionNumber;
    }

    public void setRivisionNumber(String revisionNumber){
        this.revisionNumber = revisionNumber;
    }

    public String getDocumentTitle(){
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle){
        this.documentTitle = documentTitle;
    }

    public String getDocumentAuthor(){
        return documentAuthor;
    }

    public void setDocumentAuthor(String documentAuthor){
        this.documentAuthor = documentAuthor;
    }

    public String getDocumentCreationDate(){
        return  documentCreationDate;
    }

    public void setDocumentCreationDate(String documentCreationDate){
        this.documentCreationDate= documentCreationDate;
    }
    public String getDocumentPath(){
        return documentPath;
    }
    public void setDocumentPath(String documentPath){
        this.documentPath = documentPath;
    }
    public String getDocumentStatus(){
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus){
        this.documentStatus= documentStatus;
    }



}
