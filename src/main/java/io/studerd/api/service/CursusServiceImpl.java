package io.studerd.api.service;

import io.studerd.api.entity.Cursus;
import io.studerd.api.repository.CursusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.*;

@Service
@Slf4j

public class CursusServiceImpl implements CursusService {
    private final CursusRepository cursusRepository;

    public CursusServiceImpl(CursusRepository cursusRepository) {
        this.cursusRepository = cursusRepository;


    }

    @Override
    public void createCursus(Cursus cursus) {
        this.cursusRepository.save(cursus);

    }

    @Override
    public List<Cursus> getcursus() {
        return this.cursusRepository.findAll();
    }

    @Override
    public Cursus getOneCursus(UUID uuid) {
        return this.cursusRepository.findById(uuid).get();
    }

    @Override
    public Cursus updateCursus(Cursus cursus, UUID uuid) {
        Cursus cursusUpdate = cursusRepository.findById(uuid).get();
        cursusUpdate.setTitle(cursus.getTitle());
        cursusUpdate.setDescription(cursus.getDescription());
        return cursusRepository.saveAndFlush(cursus);
    }

    @Override
    public void delete(UUID uuid) {
        if (uuid == null) {
            log.error("l'Id de cursus est null");
            return;
        }
        cursusRepository.deleteById(uuid);

    }

    @Override
    public Map<String, Object> findAllCursus(int page, int size) {
        try {
            List<Cursus> cursusList = new ArrayList<>();
            Pageable pageable = (Pageable) PageRequest.of(page, size);
            Page<Cursus> cursusPage = (Page<Cursus>) this.cursusRepository.findAll((Sort) pageable);
            cursusList = cursusPage.getContent();

            Map<String, Object> cursus = new HashMap<>();

            cursus.put("cursus", cursusList);
            cursus.put("pageCurrent", cursusPage.getNumber());
            cursus.put("totalItems", cursusPage.getTotalElements());
            cursus.put("totalPages", cursusPage.getTotalPages());

            return cursus;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }
}

