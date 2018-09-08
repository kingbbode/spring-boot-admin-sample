package com.github.kingbbode.admin.client.web.cache;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@ToString
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    public TestEntity() {
        this.text = UUID.randomUUID().toString();
    }
}
