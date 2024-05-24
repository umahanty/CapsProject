package com.project.mentorbabaa.insureme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

	@Autowired
	PolicyService policyService;


	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/createPolicy")
	public Policy createPolicy() {
		return policyService.CreatePolicy();
	}

	@PostMapping("/createPolicy")
	public Policy createPolicy(@RequestBody Policy policy) {
		if(policy!=null) {
			return policyService.registerPolicy(policy);
		}
		return null;
	}

	@GetMapping("/getPolicy/{policyId}")
	public Policy getPolicyDetails(@PathVariable(value="policyId") int policyId) {
		return policyService.getPolicyDetails(policyId);
	}

	@PutMapping("/updatePolicy/{policyId}")
	public Policy updatePolicy(@PathVariable(value="policyId") int policyId, @RequestBody Policy policy) {
		return policyService.updatePolicy(policyId, policy);
	}

	@GetMapping("/viewPolicy/{policyId}")
	public Policy viewPolicy(@PathVariable(value="policyId") int policyId) {
		return policyService.getPolicyDetails(policyId);
	}

	@DeleteMapping("/deletePolicy/{policyId}")
	public String deletePolicy(@PathVariable(value="policyId") int policyId) {
		policyService.deletePolicy(policyId);
		return "Policy deleted successfully";
	}
}
