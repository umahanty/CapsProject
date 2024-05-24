package com.project.mentorbabaa.insureme;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.project.mentorbabaa.insureme.Policy;
import com.project.mentorbabaa.insureme.PolicyRepository;
import com.project.mentorbabaa.insureme.PolicyService;
import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class InsureMeApplicationTests {

    @Mock
    private PolicyRepository policyRepository;

    @InjectMocks
    private PolicyService policyService;

    @Test
    void testSearchPolicy() {
        Policy policy = new Policy(1, "Shubham", "Individual", BigDecimal.valueOf(10000), "10-Sep-2021", "10-Sep-2022");
        when(policyRepository.findById(1)).thenReturn(java.util.Optional.of(policy));
        assertEquals(policy, policyService.searchPolicy(1));
    }

    @Test
    void testCreatePolicy() {
        Policy policy = new Policy(1, "Shubham", "Individual", BigDecimal.valueOf(10000), "10-Sep-2021", "10-Sep-2022");
        when(policyRepository.save(policy)).thenReturn(policy);
        assertEquals(policy, policyService.createPolicy(policy));
    }
}
