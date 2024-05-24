package com.project.mentorbabaa.insureme;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

	@Autowired
	PolicyRepository policyRepository;

	public Policy CreatePolicy() {
		Policy policy = generateDummyPolicy();
		return policyRepository.save(policy);
	}

	public Policy updatePolicy(int policyId, Policy updatedPolicy) {
		Optional<Policy> policy = policyRepository.findById(policyId);
		if (policy.isPresent()) {
			Policy existingPolicy = policy.get();
			existingPolicy.setPolicyHolderName(updatedPolicy.getPolicyHolderName());
			existingPolicy.setPolicyType(updatedPolicy.getPolicyType());
			existingPolicy.setPolicyAmount(updatedPolicy.getPolicyAmount());
			existingPolicy.setStartDate(updatedPolicy.getStartDate());
			existingPolicy.setEndDate(updatedPolicy.getEndDate());
			return policyRepository.save(existingPolicy);
		}
		return null;
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
		return policyRepository.findById(policyId).get();
	}

	public Policy generateDummyPolicy() {
		return new Policy(1, "Shubham", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
	}

	public Policy registerPolicy(Policy policy) {
		return policyRepository.save(policy);
	}

	public Policy getPolicyDetails(int policyId) {
		return policyRepository.findById(policyId).get();
	}

}
