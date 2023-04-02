package io.ansan.sistemaexamenes.services.impl;

import io.ansan.sistemaexamenes.entity.Test;
import io.ansan.sistemaexamenes.repository.TestRepo;
import io.ansan.sistemaexamenes.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepo testRepo;

	@Override
	public Test createTest(Test test) {
		return testRepo.save(test);
	}

	@Override
	public Test updateTest(Test test) {
		return testRepo.save(test);
	}

	@Override
	public Set<Test> getTests() {
		return new LinkedHashSet<>(testRepo.findAll());
	}

	@Override
	public Test getTest(Long id) {
		return testRepo.findById(id).get();
	}

	@Override
	public void deleteTest(Long id) {
		Test test = new Test();
		test.setTestId(id);
		testRepo.delete(test);
	}
}