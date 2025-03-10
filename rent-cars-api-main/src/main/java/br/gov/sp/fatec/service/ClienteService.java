package br.gov.sp.fatec.service;

import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    ClienteResponse save(ClienteRequest clienteRequest);
    ClienteResponse findById(Long id);
    List<ClienteResponse> findAll();
    ClienteResponse update(Long id, ClienteRequest clienteRequest);
    void deleteById(Long id);
}
