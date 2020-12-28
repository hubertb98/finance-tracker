package com.monsave.monsaveapp.mapper;

import com.monsave.monsaveapp.domain.Record;
import com.monsave.monsaveapp.domain.dto.RecordDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordMapper {
    public Record toRecord(final RecordDto recordDto) {
        return new Record(
                recordDto.getId(),
                recordDto.getRecordName(),
                recordDto.getAmount(),
                recordDto.getType(),
                recordDto.getDate());
    }

    public RecordDto toRecordDto(final Record record) {
        return new RecordDto(
                record.getId(),
                record.getRecordName(),
                record.getAmount(),
                record.getType(),
                record.getDate());
    }

    public List<Record> toRecordList(final List<RecordDto> recordsDto) {
        return recordsDto.stream()
                .map(this::toRecord)
                .collect(Collectors.toList());
    }

    public List<RecordDto> toRecordDtoList(final List<Record> records) {
        return records.stream()
                .map(this::toRecordDto)
                .collect(Collectors.toList());
    }
}
