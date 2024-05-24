package com.project.mentorbabaa.insureme;

import java.util.Optional;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    @Autowired
    PolicyRepository policyRepository;

    public Policy createPolicy(Policy policy) {
        // Use the passed policy object instead of creating a new one
        return policyRepository.save(policy);
    }

    public Policy updatePolicy(Policy updatedPolicy) {
        Policy existingPolicy = policyRepository.findById(updatedPolicy.getPolicyId()).orElseThrow(() -> new RuntimeException("Policy not found"));
        existingPolicy.setPolicyHolderName(updatedPolicy.getPolicyHolderName());
        existingPolicy.setPolicyType(updatedPolicy.getPolicyType());
        existingPolicy.setPolicyPrice(updatedPolicy.getPolicyPrice());
        existingPolicy.setPolicyStartDate(updatedPolicy.getPolicyStartDate());
        existingPolicy.setPolicyEndDate(updatedPolicy.getPolicyEndDate());
        return policyRepository.save(existingPolicy);
    }

    public Policy deletePolicy(int policyId) {
        Optional<Policy> policy = policyRepository.findById(policyId);
        if (policy.isPresent()) {
            policyRepository.deleteById(policyId);
            return policy.get();
        }
        return null;
    }

    public Policy searchPolicy(int policyId) {
        return policyRepository.findById(policyId).orElse(null);
    }

    public Policy generateDummyPolicy() {
        return new Policy(1, "Shubham", "Individual", new BigDecimal(10000), "10-Sep-2021", "10-Sep-2022");
    }

    public Policy registerPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy getPolicyDetails(int policyId) {
        return policyRepository.findById(policyId).orElse(null);
    }
}
