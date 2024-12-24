package sistema.sistema.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.sistema.Repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository; 
    
}
