package com.fg.util.babylon.imp0rt;

public interface MessageWriter {

    void storePrimaryMessage(String msgKey, String msgValue);

    void storeTranslation(String language, String msgKey, String msgValue);

}
