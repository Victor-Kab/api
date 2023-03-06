package io.studerd.api.service;

import io.studerd.api.entity.Cursus;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public interface CursusService {
    void createCursus(Cursus cursus);
    List<Cursus>getcursus();
    Cursus getOneCursus(UUID uuid);
    Cursus updateCursus(Cursus cursus, UUID uuid);
    void delete(UUID uuid);
    Map<String, Object>findAllCursus(int page, int size);
}
