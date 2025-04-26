package one.edee.babylon.git;

import lombok.extern.apachecommons.CommonsLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;

@CommonsLog
public class RuntimeExecGitAdd implements GitAdd {

    @Override
    public void gitAddFile(String pathFileName) {
        try {
            doGitAddFile(pathFileName);
        } catch (Exception e) {
            throw new RuntimeException("Error when trying to perform Git add on file '" + pathFileName + "'.", e);
        }
    }

    private void doGitAddFile(String pathFileName) throws IOException, InterruptedException {
        /* Doesn't matter whether it is already added or existing */
        log.info(FileSystems.getDefault().getPath(".").toAbsolutePath());
        int exdCode = Runtime.getRuntime().exec("git add " + pathFileName).waitFor();
        log.info("file git add ended with code : " + exdCode + " for file : " + pathFileName);
        // Try it again
        if (exdCode != 0) {
            Process p = Runtime.getRuntime().exec("git add " + pathFileName);
            exdCode = p.waitFor();
            if (exdCode != 0) {
                log.info("Process exit code: " + exdCode);
                log.info("Result:");
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    log.warn(line);
                }
            }
        }
    }

}
