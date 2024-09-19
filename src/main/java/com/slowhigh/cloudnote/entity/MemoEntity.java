package com.slowhigh.cloudnote.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * MemoEntity
 */
@ToString
@Entity
@Getter
@Table(name = "tb_memo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemoEntity implements Serializable {
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID, unique = true)
    private long id;

    @Column(name = TITLE, length = 100)
    private String title;

    @Column(name = CONTENT, length = 2000)
    private String content;

    @Builder(toBuilder = true)
    public MemoEntity(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}