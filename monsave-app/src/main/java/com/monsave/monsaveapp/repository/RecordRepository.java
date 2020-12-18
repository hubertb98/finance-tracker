package com.monsave.monsaveapp.repository;

import com.monsave.monsaveapp.domain.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {
    @Override
    Record save(Record record);

    @Override
    Optional<Record> findById(Long id);

    @Override
    List<Record> findAll();

    @Override
    void deleteById(Long id);
}
