package com.doganmehmet.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(prefix = "m_")
public enum MyError {

    OWNER_NOT_FOUND("1000", "Owner Not Found!"),
    ANIMAL_NOT_FOUND("1001", "Animal Not Found!"),

    ;

    private final String m_errorCode;
    private final String m_errorMessage;
}
