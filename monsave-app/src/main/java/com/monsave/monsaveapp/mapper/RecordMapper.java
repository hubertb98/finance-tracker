package com.monsave.monsaveapp.mapper;

import com.monsave.monsaveapp.domain.Record;
import com.monsave.monsaveapp.domain.dto.RecordDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordMapper {
    public Record mapToRecord(final RecordDto recordDto) {
        return new Record(
                recordDto.getId(),
                recordDto.getRecordName(),
                recordDto.getAmount(),
                recordDto.getType(),
                recordDto.getDate());
    }

    public RecordDto mapToRecordDto(final Record record) {
        return new RecordDto(
                record.getId(),
                record.getRecordName(),
                record.getAmount(),
                record.getType(),
                record.getDate());
    }

    public List<Record> mapToRecordList(final List<RecordDto> recordsDto) {
        return recordsDto.stream()
                .map(rDl -> new Record(rDl.getId(), rDl.getRecordName(), rDl.getAmount(), rDl.getType(), rDl.getDate()))
                .collect(Collectors.toList());
    }

    public List<RecordDto> maoToRecordDtoList(final List<Record> records) {
        return records.stream()
                .map(r -> new RecordDto(r.getId(), r.getRecordName(), r.getAmount(), r.getType(), r.getDate()))
                .collect(Collectors.toList());
    }
}
