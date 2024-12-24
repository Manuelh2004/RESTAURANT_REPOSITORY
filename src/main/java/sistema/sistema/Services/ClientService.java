package sistema.sistema.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.sistema.Repositories.ClientRepository;
import sistema.sistema.Repositories.TypeClientRepository;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TypeClientRepository typeClientRepository; 
    
}
