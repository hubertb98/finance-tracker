package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.controller.exception.NotFoundException;
import com.monsave.monsaveapp.domain.dto.RecordDto;
import com.monsave.monsaveapp.mapper.RecordMapper;
import com.monsave.monsaveapp.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class RecordsController {
    @Autowired
    private RecordMapper mapper;
    @Autowired
    private RecordService service;

    @GetMapping(value = "/records")
    public List<RecordDto> getRecords() {
        return service.getAllRecords();
    }

    @GetMapping(value = "/records/{recordId}")
    public RecordDto getRecord(@PathVariable("recordId") long recordId) throws NotFoundException {
        return mapper.toRecordDto(service.getRecord(recordId).orElseThrow(NotFoundException::new));
    }

    @PostMapping(value = "/records", consumes = APPLICATION_JSON_VALUE)
    public void createRecord(@RequestBody RecordDto recordDto) {
        service.createRecord(recordDto);
    }

    @PutMapping(value = "/records")
    public RecordDto updateRecord(@RequestBody RecordDto recordDto) {
        return service.createRecord(recordDto);
    }

    @DeleteMapping(value = "/records/{recordId}")
    public void removeRecord(@PathVariable("recordId") long recordId) {
        service.removeRecord(recordId);
    }

}
