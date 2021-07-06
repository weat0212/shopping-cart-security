package net.javaguides.springboot.springsecurity.service;

import net.javaguides.springboot.springsecurity.model.Ordering;
import net.javaguides.springboot.springsecurity.repository.OrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderingServiceImpl implements OrderingService {

    @Autowired
    private OrderingRepository orderingRepository;

    @Override
    public List<Ordering> findAll() {
        return orderingRepository.findAll();
    }

    @Override
    public Optional<Ordering> findById(Long id) {
        return orderingRepository.findById(id);
    }

    @Override
    public void save(Ordering ordering) {
        orderingRepository.save(ordering);
    }

    @Override
    public void modify(Ordering ordering) {
        orderingRepository.save(ordering);
    }

    @Override
    public void delete(Long id) {
        orderingRepository.deleteById(id);
    }
}
