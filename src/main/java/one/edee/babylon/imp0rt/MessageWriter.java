package one.edee.babylon.imp0rt;

public interface MessageWriter {

    void storePrimaryMessage(String msgKey, String msgValue);

    void storeTranslation(String language, String msgKey, String msgValue);

}
