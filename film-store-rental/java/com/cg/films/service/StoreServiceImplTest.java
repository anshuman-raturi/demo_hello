package com.cg.films.service;
import com.cg.films.entity.Staff;
import com.cg.films.entity.Store;
import com.cg.films.repository.StoreRepository;
import com.cg.films.serviceImpl.StoreServiceImpl;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
class StoreServiceImplTest {
 
    @Mock
    private StoreRepository storeRepository;
 
    @InjectMocks
    private StoreServiceImpl storeService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testGetAllManagerIds_ReturnsManagerIds() {
        Staff manager1 = new Staff();
        manager1.setStaffId(101L);
 
        Staff manager2 = new Staff();
        manager2.setStaffId(102L);
 
        Store store1 = new Store();
        store1.setManager(manager1);
 
        Store store2 = new Store();
        store2.setManager(manager2);
 
        when(storeRepository.findAll()).thenReturn(Arrays.asList(store1, store2));
        List<Long> result = storeService.getAllManagerIds();
        assertEquals(Arrays.asList(101L, 102L), result);
    }
 
    @Test
    void testGetAllManagerIds_EmptyStoreList() {
        when(storeRepository.findAll()).thenReturn(Collections.emptyList());
        List<Long> result = storeService.getAllManagerIds();
        assertEquals(Collections.emptyList(), result);
    }
}