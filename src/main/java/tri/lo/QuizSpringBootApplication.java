package tri.lo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tri.lo.security.CustomUserDetailsService;
import tri.lo.security.JwtAuthenticationEntryPoint;
import tri.lo.service.quiz.*;
import tri.lo.service.quiz.impl.*;

@SpringBootApplication
public class QuizSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizSpringBootApplication.class, args);
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryServiceImpl();
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
    public QuizService quizService() {
        return new QuizServiceImpl();
    }

    @Bean
    public KindOfQuestionService kindOfQuestionService() {
        return new KindOfQuestionServiceImpl();
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
