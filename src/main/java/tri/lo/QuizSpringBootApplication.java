package tri.lo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tri.lo.service.AnswerService;
import tri.lo.service.KindOfQuestionService;
import tri.lo.service.QuestionService;
import tri.lo.service.impl.AnswerServiceImpl;
import tri.lo.service.impl.KindOfQuestionServiceImpl;
import tri.lo.service.impl.QuestionServiceImpl;

@SpringBootApplication
public class QuizSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizSpringBootApplication.class, args);
    }

    @Bean
    public KindOfQuestionService kindOfQuestionService() {
        return new KindOfQuestionServiceImpl();
    }

    @Bean
    public AnswerService answerService() {
        return new AnswerServiceImpl();
    }

    @Bean
    public QuestionService questionService() {
        return new QuestionServiceImpl();
    }
}
