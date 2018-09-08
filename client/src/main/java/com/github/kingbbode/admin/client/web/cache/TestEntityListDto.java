package com.github.kingbbode.admin.client.web.cache;

import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class TestEntityListDto {
    public static final TestEntityListDto EMPTY = TestEntityListDto.builder().data(Collections.emptyList()).build();
    private List<TestEntityDto> data;

    @Builder
    public TestEntityListDto(List<TestEntityDto> data) {
        this.data = data;
    }


    @Getter
    public static class TestEntityDto {
        private Long id;
        private String text;

        @Builder
        public TestEntityDto(Long id, String text) {
            this.id = id;
            this.text = text;
        }
    }
}
