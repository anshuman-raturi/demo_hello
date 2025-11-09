package com.cg.films.serviceImpl;
import java.util.List;
 
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.films.repository.StoreRepository; 
import com.cg.films.service.StoreService;

@Service 
public class StoreServiceImpl implements StoreService {
    
	@Autowired
    private StoreRepository storeRepository;
    @Override
 
       public List<Long> getAllManagerIds() {
           return storeRepository.findAll()
                                 .stream()
                                 .map(store -> store.getManager().getStaffId())
                                 .collect(Collectors.toList());

       }
 
}