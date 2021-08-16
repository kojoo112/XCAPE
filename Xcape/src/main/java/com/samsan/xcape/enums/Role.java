package com.samsan.xcape.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "게스트"),
    USER("ROLE_USER", "일반 사용자"),
    DEVELOPER("ROLE_DEVELOPER", "개발자");

    private final String key;
    private final String title;
}
