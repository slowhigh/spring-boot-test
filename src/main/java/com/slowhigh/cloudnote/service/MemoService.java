package com.slowhigh.cloudnote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.slowhigh.cloudnote.dto.MemoCreateDto;
import com.slowhigh.cloudnote.dto.MemoUpdateDto;
import com.slowhigh.cloudnote.entity.MemoEntity;

@Service
public interface MemoService {
    List<MemoEntity> getMemoList();

    MemoEntity getMemoByMemoId(long id);

    MemoEntity createMemo(MemoCreateDto memoCreateDto);

    MemoEntity updateMemo(long id, MemoUpdateDto memoUpdateDto);

    void deleteMemoByMemoId(long id);
}
