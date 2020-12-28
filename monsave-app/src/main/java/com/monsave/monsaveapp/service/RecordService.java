package com.monsave.monsaveapp.service;

import com.monsave.monsaveapp.domain.AmountType;
import com.monsave.monsaveapp.domain.Record;
import com.monsave.monsaveapp.domain.dto.RecordDto;
import com.monsave.monsaveapp.mapper.RecordMapper;
import com.monsave.monsaveapp.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private RecordMapper mapper;
    @Autowired
    private RecordRepository repository;

    public List<RecordDto> getAllRecords() {
        return mapper.toRecordDtoList(repository.findAll());
    }

    public RecordDto createRecord(final RecordDto recordDto ) {
        Record record = mapper.toRecord(recordDto);
        return mapper.toRecordDto(repository.save(record));
    }

    public Optional<Record> getRecord(final Long id) {
        return repository.findById(id);
    }

    public void removeRecord(final Long id) {
        repository.deleteById(id);
    }

    public String printAmount(Record record) {
        String printAmount = "";
        if (record.getType() == AmountType.LOSS) {
            printAmount = "-PLN " + record.getAmount();
        } else if (record.getType() == AmountType.PROFIT) {
            printAmount = "PLN " + record.getAmount();
        }
        return printAmount;
    }
}
