package br.gov.sp.fatec.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.map(clienteRequest);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.map(cliente);
    }

    @Override
    public ClienteResponse findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return clienteMapper.map(cliente);
    }

    @Override
    public List<ClienteResponse> findAll() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponse update(Long id, ClienteRequest clienteRequest) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            clienteMapper.updateClienteFromRequest(clienteRequest, cliente);
            cliente = clienteRepository.save(cliente);
            return clienteMapper.map(cliente);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}

