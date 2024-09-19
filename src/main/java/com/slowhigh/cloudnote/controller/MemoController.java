package com.slowhigh.cloudnote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slowhigh.cloudnote.dto.MemoCreateDto;
import com.slowhigh.cloudnote.dto.MemoUpdateDto;
import com.slowhigh.cloudnote.entity.MemoEntity;
import com.slowhigh.cloudnote.service.MemoService;

import jakarta.validation.Valid;

@RequestMapping("api/v1/memo")
@RestController
public class MemoController {
    @Autowired
    private MemoService memoService;

    @GetMapping({ "", "/" })
    public ResponseEntity<List<MemoEntity>> getMemoList() {
        return new ResponseEntity<>(this.memoService.getMemoList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoEntity> getMemoById(@PathVariable long id) {
        return new ResponseEntity<>(this.memoService.getMemoByMemoId(id), HttpStatus.OK);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<MemoEntity> createMemo(@RequestBody @Valid MemoCreateDto dto) {
        return new ResponseEntity<>(this.memoService.createMemo(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemoEntity> updateMemo(@PathVariable long id, @RequestBody @Valid MemoUpdateDto dto) {
        return new ResponseEntity<>(this.memoService.updateMemo(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MemoEntity> deleteMemo(@PathVariable long id) {
        this.memoService.deleteMemoByMemoId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
