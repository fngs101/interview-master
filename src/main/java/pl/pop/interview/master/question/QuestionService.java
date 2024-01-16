package pl.pop.interview.master.question;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService( QuestionRepository questionRepository ) {
        this.questionRepository = questionRepository;
    }

    public void addNewQuestion( QuestionDTO questionDTO ) {
        Question question = buildQuestionFromDTO( questionDTO );
        questionRepository.save( question );
    }

    private Question buildQuestionFromDTO( QuestionDTO questionDTO ) {
        return new Question(
                questionDTO.getContent(),
                questionDTO.getCorrectAnswer()
        );
    }
}