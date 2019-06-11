package com.fg.util.babylon.exception;

import com.fg.util.babylon.entity.Configuration;

import java.io.IOException;

/**
 * Exception in case when in {@link Configuration#getMutations()} is mutation that not found in source google sheet while importing data to files.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class MutationNotFoundException extends IOException {

    public MutationNotFoundException(String message) {
        super(message);
    }
}
