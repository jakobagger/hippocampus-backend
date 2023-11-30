package memgrp.memorize.configuration;


import memgrp.memorize.entity.*;

import memgrp.memorize.repository.*;
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
    ValueRepository valueRepository;
    SuitRepository suitRepository;
    QuizRepository quizRepository;
    CardRepository cardRepository;

    public DeveloperData(MemberRepository memberRepository, MatrixRepository matrixRepository, CardRepository cardRepository,  ValueRepository valueRepository, SuitRepository suitRepository, QuizRepository quizRepository) {
        this.memberRepository = memberRepository;
        this.matrixRepository = matrixRepository;
        this.valueRepository = valueRepository;
        this.suitRepository = suitRepository;
        this.quizRepository = quizRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        setupUserWithRoles();

        Member member = new Member("username", "email", "password");

        Matrix matrix3 = new Matrix();

        Quiz quiz = new Quiz();
        Quiz quiz2 = new Quiz();
        memberRepository.save(member);
        quiz2.setMember(member);
        quizRepository.save(quiz);
        quizRepository.save(quiz2);
        Matrix matrix1 = new Matrix(member);
        matrixRepository.save(matrix1);

        Value c1 = new Value();
        Value c2 = new Value();
        Value c3 = new Value();
        Value c4 = new Value();
        List<Value> values = new ArrayList<>();
        values.add(c1);
        values.add(c2);
        values.add(c3);
        values.add(c4);
        c1.setValueName("1");
        c1.setValueName("Ace");
        c1.setValueDescription("Strong");

        matrix1.addValue(c1);
        matrix1.addValue(c2);
        matrix1.addValue(c3);
        matrix1.addValue(c4);

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

        for(Value value : values){
            value.setMatrix(matrix1);
        }
        valueRepository.saveAll(values);

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

        UserWithRoles MemoryAdmin = new UserWithRoles("MemoryAdmin", "MemoryAdmin@memorygym.dk", "asd");
        UserWithRoles user1 = new UserWithRoles("user1", "user1@a.com", passwordUsedByAll);
        UserWithRoles user2 = new UserWithRoles("user2", "user2@a.com", passwordUsedByAll);
        UserWithRoles user3 = new UserWithRoles("user3", "user3@a.com", passwordUsedByAll);
        UserWithRoles user4 = new UserWithRoles("user4", "user4@a.com", passwordUsedByAll);
        UserWithRoles OnlyAdmin = new UserWithRoles("OnlyAdmin", "Only@admin.dk", "asd");
        MemoryAdmin.addRole(Role.USER);
        MemoryAdmin.addRole(Role.ADMIN);
        user1.addRole(Role.USER);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        OnlyAdmin.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(MemoryAdmin);
        userWithRolesRepository.save(OnlyAdmin);
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }
}
