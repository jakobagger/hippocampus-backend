package memgrp.memorize.configuration;

import memgrp.memorize.entity.Quiz;
import memgrp.memorize.repository.QuizRepository;
import memgrp.memorize.entity.Category;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Member;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.repository.CategoryRepository;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.MemberRepository;
import memgrp.memorize.repository.SuitRepository;
import memgrp.security.entity.Role;
import memgrp.security.entity.UserWithRoles;
import memgrp.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {


    MemberRepository memberRepository;
    MatrixRepository matrixRepository;

    CategoryRepository categoryRepository;

    SuitRepository suitRepository;


    QuizRepository quizRepository;



    public DeveloperData(MemberRepository memberRepository, MatrixRepository matrixRepository, CategoryRepository categoryRepository, SuitRepository suitRepository, QuizRepository quizRepository) {
        this.memberRepository = memberRepository;
        this.matrixRepository = matrixRepository;
        this.categoryRepository = categoryRepository;
        this.suitRepository = suitRepository;
        this.quizRepository = quizRepository;

    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

        setupUserWithRoles();
      
        Member member = new Member("username", "email", "password");
        Quiz quiz = new Quiz();
        Quiz quiz2 = new Quiz();
        memberRepository.save(member);
        quiz2.setMember(member);
        quizRepository.save(quiz);
        quizRepository.save(quiz2);
        Matrix matrix1 = new Matrix(member);
        matrixRepository.save(matrix1);

        Category c1 = new Category();
        Category c2 = new Category();
        Category c3 = new Category();
        Category c4 = new Category();
        List<Category> cats = new ArrayList<>();
        cats.add(c1);
        cats.add(c2);
        cats.add(c3);
        cats.add(c4);
        c1.setCategoryNumber(1);
        c1.setCategoryDescription("Strong");

        matrix1.addCategories(c1);
        matrix1.addCategories(c2);
        matrix1.addCategories(c3);
        matrix1.addCategories(c4);

        Suit s1 = new Suit();
        Suit s2 = new Suit();
        Suit s3 = new Suit();
        Suit s4 = new Suit();
        List<Suit> suits = new ArrayList<>();
        suits.add(s1);
        suits.add(s2);
        suits.add(s3);
        suits.add(s4);
        s1.setSuitName("Heart");
        s1.setSuitDescription("Caring");

        matrix1.addSuits(s1);
        matrix1.addSuits(s2);
        matrix1.addSuits(s3);
        matrix1.addSuits(s4);
        matrixRepository.save(matrix1);

        for(Category cat : cats){
            cat.setMatrix(matrix1);
        }
        categoryRepository.saveAll(cats);

        for(Suit suit : suits){
            suit.setMatrix(matrix1);
        }
        suitRepository.saveAll(suits);

    }

    @Autowired
    UserWithRolesRepository userWithRolesRepository;
    final String passwordUsedByAll = "test12";

    private void setupUserWithRoles() {
        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");

        UserWithRoles user1 = new UserWithRoles("user1", "user1@a.com", passwordUsedByAll);
        UserWithRoles user2 = new UserWithRoles("user2", "user2@a.com", passwordUsedByAll);
        UserWithRoles user3 = new UserWithRoles("user3", "user3@a.com", passwordUsedByAll);
        UserWithRoles user4 = new UserWithRoles("user4", "user4@a.com", passwordUsedByAll);
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }



}
