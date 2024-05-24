package com.project.mentorbabaa.insureme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/createDummyPolicy")
    public Policy createDummyPolicy() {
        Policy dummyPolicy = policyService.generateDummyPolicy();
        return policyService.createPolicy(dummyPolicy);
    }

    @PostMapping("/createPolicy")
    public Policy createPolicy(@RequestBody Policy policy) {
        if (policy != null) {
            return policyService.registerPolicy(policy);
        }
        return null;
    }

    @GetMapping("/getPolicy/{policyId}")
    public Policy getPolicyDetails(@PathVariable(value = "policyId") int policyId) {
        return policyService.getPolicyDetails(policyId);
    }

    @PutMapping("/updatePolicy/{policyId}")
    public Policy updatePolicy(@PathVariable(value = "policyId") int policyId, @RequestBody Policy policy) {
        Policy existingPolicy = policyService.getPolicyDetails(policyId);
        if (existingPolicy != null) {
            policy.setPolicyId(policyId);
            return policyService.updatePolicy(policy);
        }
        return null;
    }

    @GetMapping("/viewPolicy/{policyId}")
    public Policy viewPolicy(@PathVariable(value = "policyId") int policyId) {
        return policyService.getPolicyDetails(policyId);
    }

    @DeleteMapping("/deletePolicy/{policyId}")
    public String deletePolicy(@PathVariable(value = "policyId") int policyId) {
        policyService.deletePolicy(policyId);
        return "Policy deleted successfully";
    }
}
