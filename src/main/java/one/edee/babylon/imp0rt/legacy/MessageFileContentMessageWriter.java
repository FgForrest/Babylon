package one.edee.babylon.imp0rt.legacy;

import one.edee.babylon.entity.MessageFileContent;
import one.edee.babylon.imp0rt.MessageWriter;

public class MessageFileContentMessageWriter implements MessageWriter {

    private final MessageFileContent messageFiles;

    public MessageFileContentMessageWriter(MessageFileContent messageFiles) {
        this.messageFiles = messageFiles;
    }

    @Override
    public void storePrimaryMessage(String msgKey, String msgValue) {
        messageFiles.putProperty(msgKey, msgValue);
    }

    @Override
    public void storeTranslation(String language, String msgKey, String msgValue) {
        messageFiles.putMutationProperty(language, msgKey, msgValue);
    }

}
