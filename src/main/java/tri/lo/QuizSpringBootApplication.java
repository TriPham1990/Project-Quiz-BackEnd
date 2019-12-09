package tri.lo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tri.lo.security.CustomUserDetailsService;
import tri.lo.security.JwtAuthenticationEntryPoint;
import tri.lo.service.quiz.AnswerService;
import tri.lo.service.quiz.KindOfQuestionService;
import tri.lo.service.quiz.QuestionService;
import tri.lo.service.quiz.impl.AnswerServiceImpl;
import tri.lo.service.quiz.impl.KindOfQuestionServiceImpl;
import tri.lo.service.quiz.impl.QuestionServiceImpl;

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

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public JwtAuthenticationEntryPoint unauthorizedHandler() {
        return new JwtAuthenticationEntryPoint();
    }
}
