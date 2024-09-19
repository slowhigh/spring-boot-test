package com.slowhigh.cloudnote.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.slowhigh.cloudnote.dto.MemoCreateDto;
import com.slowhigh.cloudnote.dto.MemoUpdateDto;
import com.slowhigh.cloudnote.entity.MemoEntity;
import com.slowhigh.cloudnote.exception.DuplicateException;
import com.slowhigh.cloudnote.exception.NotFoundException;
import com.slowhigh.cloudnote.repository.MemoRepository;
import com.slowhigh.cloudnote.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemoEntity> getMemoList() {
        return this.memoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MemoEntity getMemoByMemoId(long id) {
        return this.memoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Memo not found with ID: " + id));
    }

    @Override
    @Transactional
    public MemoEntity createMemo(MemoCreateDto memoCreateDto) {
        if (this.memoRepository.existsByTitle(memoCreateDto.getTitle())) {
            throw new DuplicateException(
                    "A memo with the same title already exists: " + memoCreateDto.getTitle());
        }

        return this.memoRepository.save(MemoEntity.builder()
                .title(memoCreateDto.getTitle())
                .content(memoCreateDto.getContent())
                .build());
    }

    @Override
    @Transactional
    public MemoEntity updateMemo(long id, MemoUpdateDto memoUpdateDto) {
        final String newTitle = memoUpdateDto.getTitle();
        final String newContent = memoUpdateDto.getContent();

        MemoEntity existingMemo = this.memoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Memo not found with ID: " + id));

        MemoEntity.MemoEntityBuilder newMemo = existingMemo.toBuilder();

        if (StringUtils.hasText(newTitle)) {
            if (this.memoRepository.existsByTitleAndIdNot(newTitle, id)) {
                throw new DuplicateException(
                        "A memo with the same title already exists: " + newTitle);
            }

            newMemo.title(newTitle);
        }

        if (StringUtils.hasText(newContent)) {
            newMemo.content(newContent);
        }

        return this.memoRepository.save(newMemo.build());
    }

    @Override
    @Transactional
    public void deleteMemoByMemoId(long id) {
        if (!this.memoRepository.existsById(id)) {
            throw new NotFoundException("Memo not found with ID: " + id);
        }

        this.memoRepository.deleteById(id);
    }
}
