package io.ansan.sistemaexamenes.services.impl;

import io.ansan.sistemaexamenes.entity.Question;
import io.ansan.sistemaexamenes.entity.Test;
import io.ansan.sistemaexamenes.repository.QuestionRepo;
import io.ansan.sistemaexamenes.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public Question addQuestion(Question question) {
		return questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
        return (Set<Question>) questionRepo.findAll();
	}

	@Override
	public Question getQuestion(Long id) {
		return questionRepo.getById(id);
	}

	@Override
	public Set<Question> getQuestionsOfTest(Test test) {
		return questionRepo.findByTest(test);
	}

	@Override
	public void deleteQuestion(Long id) {
		Question question = new Question();
		question.setQuestionId(id);
		questionRepo.delete(question);
	}
}