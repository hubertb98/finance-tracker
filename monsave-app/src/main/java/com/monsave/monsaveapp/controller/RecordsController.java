package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.controller.exception.RecordNotFoundException;
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
        return mapper.toRecordDtoList(service.getAllRecords());
    }

    @GetMapping(value = "/records/{recordId}")
    public RecordDto getRecord(@PathVariable("recordId") long recordId) throws RecordNotFoundException {
        return mapper.toRecordDto(service.getRecord(recordId).orElseThrow(RecordNotFoundException::new));
    }

    @PostMapping(value = "/records", consumes = APPLICATION_JSON_VALUE)
    public void createRecord(@RequestBody RecordDto recordDto) {
        service.saveRecord(mapper.toRecord(recordDto));
    }

    @PutMapping(value = "/records")
    public RecordDto updateRecord(@RequestBody RecordDto recordDto) {
        return mapper.toRecordDto(service.saveRecord(mapper.toRecord(recordDto)));
    }

    @DeleteMapping(value = "/records/{recordId}")
    public void deleteRecord(@PathVariable("recordId") long recordId) {
        service.deleteRecord(recordId);
    }

}
