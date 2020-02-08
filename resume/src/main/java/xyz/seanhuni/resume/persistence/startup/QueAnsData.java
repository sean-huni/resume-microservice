package xyz.seanhuni.resume.persistence.startup;

import xyz.seanhuni.resume.persistence.entity.QuestionAns;
import xyz.seanhuni.resume.persistence.entity.QuestionInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QueAnsData {
    private static final Integer VERSION = 1;

    public List<QuestionAns> questionAnsList() {
        List<QuestionAns> questionAnsList = new ArrayList<>();

        QuestionAns questionAns1 = new QuestionAns();
        questionAns1.setQuest("Can you show us the way with a quick intro about yourself");
        questionAns1.setAns("Most people know me as Kudzai or Sean. I am an experienced Software Engineer. " +
                "My passion is in designing, modelling & developing software systems that can do " +
                "some cool stuff with Machine Learning.");
        questionAns1.setVersion(VERSION);
        questionAns1.setDtUpdated(LocalDateTime.now());
        questionAns1.setDtCreated(LocalDateTime.now());
        questionAnsList.add(questionAns1);

        QuestionAns questionAns2 = new QuestionAns();
        questionAns2.setQuest("In just 40 words or so, tell us more about who you are");
        questionAns2.setAns("I'm usually involved in the full-lifecycle of software projects, " +
                "since I'm good in almost all aspects concerned with software development. " +
                "That's what I enjoy doing and it enables me to put Bread & Butter on the table.");
        questionAns2.setVersion(VERSION);
        questionAns2.setDtUpdated(LocalDateTime.now());
        questionAns2.setDtCreated(LocalDateTime.now());
        questionAnsList.add(questionAns2);

        QuestionAns questionAns3 = new QuestionAns();
        questionAns3.setQuest("Can you briefly highlight some of the interesting projects from various " +
                "industries that you've done in the past");
        questionAns3.setAns("Some of the interesting projects that I participated in included industries in:");
        questionAns3.setVersion(VERSION);
        questionAns3.setDtUpdated(LocalDateTime.now());
        questionAns3.setDtCreated(LocalDateTime.now());
        QuestionInfo question3Info1 = new QuestionInfo();
        question3Info1.setBInfo("Commercial: Crowd management software systems e.g. managing groups of students, club members e.t.c.");
        question3Info1.setVersion(VERSION);
        question3Info1.setDtUpdated(LocalDateTime.now());
        question3Info1.setDtCreated(LocalDateTime.now());

        QuestionInfo question3Info2 = new QuestionInfo();
        question3Info2.setBInfo("Telecoms: Call recording software system, recording calls on behalf of call-centers.");
        question3Info2.setVersion(VERSION);
        question3Info2.setDtUpdated(LocalDateTime.now());
        question3Info2.setDtCreated(LocalDateTime.now());

        QuestionInfo question3Info3 = new QuestionInfo();
        question3Info3.setBInfo("Academic: Evaluated Ensemble algorithms towards predicting student performance with a 97.3% accuracy.");
        question3Info3.setVersion(VERSION);
        question3Info3.setDtUpdated(LocalDateTime.now());
        question3Info3.setDtCreated(LocalDateTime.now());

        List<QuestionInfo> questionInfo3List = new ArrayList<>();
        questionInfo3List.add(question3Info1);
        questionInfo3List.add(question3Info2);
        questionInfo3List.add(question3Info3);
        questionAns3.setQuestionInfoList(questionInfo3List);
        questionAnsList.add(questionAns3);

        QuestionAns questionAns4 = new QuestionAns();
        questionAns4.setQuest("What software tools are you good at");
        questionAns4.setAns("I've done several projects using software tools such as; MATLAB R2015, Java, Spring Framework, Jenkins, " +
                "Gradle, Twitter Bootstrap, Bower, HTML5, JavaScript, JQuery, JSP, JPA, JPQL. Interesting projects " +
                "include a lot of these awesome latest software tools.");
        questionAns4.setVersion(VERSION);
        questionAns4.setDtUpdated(LocalDateTime.now());
        questionAns4.setDtCreated(LocalDateTime.now());
        questionAnsList.add(questionAns4);

        QuestionAns questionAns5 = new QuestionAns();
        questionAns5.setQuest("Now that we've established that you posses a unique set of skills. What interesting things can you practically do with them");
        questionAns5.setAns("I''ve done several projects using software tools such as; MATLAB R2015, Java, Spring Framework, Jenkins, " +
                "Gradle, Twitter Bootstrap, Bower, HTML5, JavaScript, JQuery, JSP, JPA, JPQL. Interesting projects " +
                "include a lot of these awesome latest software tools.");
        questionAns5.setVersion(VERSION);
        questionAns5.setDtUpdated(LocalDateTime.now());
        questionAns5.setDtCreated(LocalDateTime.now());

        QuestionInfo question5Info1 = new QuestionInfo();
        question5Info1.setBInfo("Pattern-recognition: Big-data, Credit Rating, Image Classification, Facial Recognition");
        question5Info1.setVersion(VERSION);
        question5Info1.setDtUpdated(LocalDateTime.now());
        question5Info1.setDtCreated(LocalDateTime.now());

        QuestionInfo question5Info2 = new QuestionInfo();
        question5Info2.setBInfo("Anomaly-detection: Fraud detection, Network Intrusions");
        question5Info2.setVersion(VERSION);
        question5Info2.setDtUpdated(LocalDateTime.now());
        question5Info2.setDtCreated(LocalDateTime.now());

        QuestionInfo question5Info3 = new QuestionInfo();
        question5Info3.setBInfo("Prediction: Performance Prediction");
        question5Info3.setVersion(VERSION);
        question5Info3.setDtUpdated(LocalDateTime.now());
        question5Info3.setDtCreated(LocalDateTime.now());

        QuestionInfo question5Info4 = new QuestionInfo();
        question5Info4.setBInfo("Recommendation: Decision Support Systems");
        question5Info4.setVersion(VERSION);
        question5Info4.setDtUpdated(LocalDateTime.now());
        question5Info4.setDtCreated(LocalDateTime.now());

        List<QuestionInfo> questionInfo5List = new ArrayList<>();
        questionInfo5List.add(question5Info1);
        questionInfo5List.add(question5Info2);
        questionInfo5List.add(question5Info3);
        questionInfo5List.add(question5Info4);
        questionAns5.setQuestionInfoList(questionInfo5List);
        questionAnsList.add(questionAns5);

        QuestionAns questionAns6 = new QuestionAns();
        questionAns6.setQuest("What are some of your future/anticipated experiments");
        questionAns6.setAns("My current/future/anticipated experiments are: ");
        questionAns6.setVersion(VERSION);
        questionAns6.setDtUpdated(LocalDateTime.now());
        questionAns6.setDtCreated(LocalDateTime.now());

        QuestionInfo question6Info1 = new QuestionInfo();
        question6Info1.setBInfo("Evaluating Deep Neural Networks for collision detection & avoidance in UAV/Drones.");
        question6Info1.setVersion(VERSION);
        question6Info1.setDtUpdated(LocalDateTime.now());
        question6Info1.setDtCreated(LocalDateTime.now());

        QuestionInfo question6Info2 = new QuestionInfo();
        question6Info2.setBInfo("Deep Learning & Computer Vision for Security (criminal activity tracking & mobility) & Neighborhood Surveillance.");
        question6Info2.setVersion(VERSION);
        question6Info2.setDtUpdated(LocalDateTime.now());
        question6Info2.setDtCreated(LocalDateTime.now());

        QuestionInfo question6Info3 = new QuestionInfo();
        question6Info3.setBInfo("Proving the possibility of Free Calling. The aim of this experiment is\n" +
                "to help villagers access good quality communication signal coverage at free OF charge IN rural areas.\n" +
                "Alongside me on this project, IS my dear friend Dr.Geneviève Tan Shu Thung.");
        question6Info3.setVersion(VERSION);
        question6Info3.setDtUpdated(LocalDateTime.now());
        question6Info3.setDtCreated(LocalDateTime.now());

        List<QuestionInfo> questionInfo6List = new ArrayList<>();
        questionInfo6List.add(question6Info1);
        questionInfo6List.add(question6Info2);
        questionInfo6List.add(question6Info3);
        questionAns6.setQuestionInfoList(questionInfo6List);
        questionAnsList.add(questionAns6);

        QuestionAns questionAns7 = new QuestionAns();
        questionAns7.setQuest("Aside from all the gimmicks, what else do you do for fun");
        questionAns7.setAns("I embrace creativity, and as a pianist/music producer, music has become " +
                "that part of me that opens up my mind to a free-flow of ideas in the form of sound. " +
                "Like any mathematician, Chess is always a great game for training the brain's muscles. E.g. weighing up " +
                "all options before dicing up opportunities. I like recreational activities, " +
                "so here and there, if I'm not coding or experimenting you'll find me: ");
        questionAns7.setVersion(VERSION);
        questionAns7.setDtUpdated(LocalDateTime.now());
        questionAns7.setDtCreated(LocalDateTime.now());

        QuestionInfo question7Info1 = new QuestionInfo();
        question7Info1.setBInfo("Sports: indoor soccer (as a goal-keeper), rugby (left-winger), basketball.");
        question7Info1.setVersion(VERSION);
        question7Info1.setDtUpdated(LocalDateTime.now());
        question7Info1.setDtCreated(LocalDateTime.now());

        QuestionInfo question7Info2 = new QuestionInfo();
        question7Info2.setBInfo("Action: Sky-Diving, Go-Karting, Jet-Skiing.");
        question7Info2.setVersion(VERSION);
        question7Info2.setDtUpdated(LocalDateTime.now());
        question7Info2.setDtCreated(LocalDateTime.now());

        QuestionInfo question7Info3 = new QuestionInfo();
        question7Info3.setBInfo("Adventure: Exploring other places in nature with the intention to learn more about the field of Biologically Inspired Computation.");
        question7Info3.setVersion(VERSION);
        question7Info3.setDtUpdated(LocalDateTime.now());
        question7Info3.setDtCreated(LocalDateTime.now());

        QuestionInfo question7Info4 = new QuestionInfo();
        question7Info4.setBInfo("Computer Gaming: I think of this activity as a way of " +
                "imitating reality through Simulation Training e.g Aviation Industries. I am also curious of how Machine Learning " +
                "has been applied to improve computer graphics in gaming e.g. Grand Theft Auto V - ''Alireza Shafaei, a " +
                "''PhD student AT UBC'' Play and Learn: Using Video Games to Train Computer Vision Models.");
        question7Info4.setVersion(VERSION);
        question7Info4.setDtUpdated(LocalDateTime.now());
        question7Info4.setDtCreated(LocalDateTime.now());

        List<QuestionInfo> questionInfo7List = new ArrayList<>();
        questionInfo7List.add(question7Info1);
        questionInfo7List.add(question7Info2);
        questionInfo7List.add(question7Info3);
        questionInfo7List.add(question7Info4);
        questionAns7.setQuestionInfoList(questionInfo7List);
        questionAnsList.add(questionAns7);

        QuestionAns questionAns8 = new QuestionAns();
        questionAns8.setQuest("Anything else that you like doing");
        questionAns8.setAns("Yes of course, besides building my career from teamwork and practical experience alone, we " +
                "live in an era where good education is free. In my relaxing time I participate in free-online courses " +
                "from world-class universities. The likes of Stanford University, University of California, " +
                "Johns Hopkins University, University of Cape Town e.t.c. My attitude towards my career is equipped " +
                "with a sort of a mindset that embraces continuous-learning/sharing knowledge through: ");
        questionAns8.setVersion(VERSION);
        questionAns8.setDtUpdated(LocalDateTime.now());
        questionAns8.setDtCreated(LocalDateTime.now());

        QuestionInfo question8Info1 = new QuestionInfo();
        question8Info1.setBInfo("Witting and publishing articles in line with my skills that I am passionate about.");
        question8Info1.setVersion(VERSION);
        question8Info1.setDtUpdated(LocalDateTime.now());
        question8Info1.setDtCreated(LocalDateTime.now());

        QuestionInfo question8Info2 = new QuestionInfo();
        question8Info2.setBInfo("Coursera - An online platform with free online courses from world class universities.");
        question8Info2.setVersion(VERSION);
        question8Info2.setDtUpdated(LocalDateTime.now());
        question8Info2.setDtCreated(LocalDateTime.now());

        QuestionInfo question8Info3 = new QuestionInfo();
        question8Info3.setBInfo("Udacity - Another online platform with free online courses developed by experts from the " +
                "likes of Google, Amazon, WhatsApp, Facebook e.t.c");
        question8Info3.setVersion(VERSION);
        question8Info3.setDtUpdated(LocalDateTime.now());
        question8Info3.setDtCreated(LocalDateTime.now());

        QuestionInfo question8Info4 = new QuestionInfo();
        question8Info4.setBInfo("Hackathon Events/Challenges.");
        question8Info4.setVersion(VERSION);
        question8Info4.setDtUpdated(LocalDateTime.now());
        question8Info4.setDtCreated(LocalDateTime.now());

        List<QuestionInfo> questionInfo8List = new ArrayList<>();
        questionInfo8List.add(question8Info1);
        questionInfo8List.add(question8Info2);
        questionInfo8List.add(question8Info3);
        questionInfo8List.add(question8Info4);
        questionAns8.setQuestionInfoList(questionInfo8List);
        questionAnsList.add(questionAns8);
        return questionAnsList;
    }
}
