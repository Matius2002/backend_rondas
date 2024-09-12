package com.backend.production.service.torre;

import com.backend.production.dto.TorreRequest;
import com.backend.production.models.Torre;

import java.util.List;

public interface TorreService {

    List<Torre> listarTorres();

    String save(TorreRequest request);
}
