package com.github.kingbbode.admin.client.web.cache;

import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class TestEntityListDto {
    public static final TestEntityListDto EMPTY = TestEntityListDto.builder().ids(Collections.emptyList()).build();
    private List<Long> ids;

    @Builder
    public TestEntityListDto(List<Long> ids) {
        this.ids = ids;
    }
}
