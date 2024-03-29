package com.example.TwitchBudgetTool.Streams;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StreamsService {

    @Autowired
    private StreamRepo repo;

    public List<Streams> listAll(long ID) {
        return repo.findAllStreams(ID);
    }

    public void save(Streams stream) {
        repo.save(stream);
    }

    public Streams get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}