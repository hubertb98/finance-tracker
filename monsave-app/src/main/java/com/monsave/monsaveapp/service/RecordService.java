package com.monsave.monsaveapp.service;

import com.monsave.monsaveapp.domain.Record;
import com.monsave.monsaveapp.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private RecordRepository repository;

    public List<Record> getAllRecords() {
        return repository.findAll();
    }

    public Record saveRecord(final Record record ) {
        return repository.save(record);
    }

    public Optional<Record> getRecord(final Long id) {
        return repository.findById(id);
    }

    public void deleteRecord(final Long id) {
        repository.deleteById(id);
    }
}
