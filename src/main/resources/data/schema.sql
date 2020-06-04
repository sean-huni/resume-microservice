DROP SCHEMA IF EXISTS dr_schema;
CREATE SCHEMA IF NOT EXISTS dr_schema;

USE dr_schema;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE user
(
    id        INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(255)  NOT NULL UNIQUE,
    password  VARCHAR(1000) NULL     DEFAULT NULL,
    enabled   BOOLEAN       NOT NULL,
    dtCreated TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version   INT                    DEFAULT 1
);

CREATE TABLE emailMsg
(
    id        INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id   INT            NOT NULL,
    name      VARCHAR(255)   NOT NULL,
    subject   VARCHAR(255)   NOT NULL,
    message   VARCHAR(20000) NOT NULL,
    dtSent    TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    dtCreated TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version   INT                     DEFAULT 1,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user (id)
);

# Table Updates

alter table dr_schema.user
    modify username varchar(255);

alter table dr_schema.emailMsg
    modify name varchar(255);

alter table dr_schema.emailMsg
    modify subject varchar(255);

alter table dr_schema.emailMsg
    modify message varchar(20000);

CREATE TABLE questAns
(
    id        INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quest     VARCHAR(600)   NOT NULL
        COMMENT 'Question asked',
    ans       VARCHAR(20000) NOT NULL
        COMMENT 'Answer to the question',
    dtCreated TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version   INT                     DEFAULT 1
);

CREATE TABLE questInfo
(
    id          INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    questAns_id INT            NOT NULL,
    bInfo       VARCHAR(20000) NOT NULL
        COMMENT 'Bullet-points, as additional information.',
    dtCreated   TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated   TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version     INT                     DEFAULT 1,
    CONSTRAINT que_oint_ansFk FOREIGN KEY (questAns_id) REFERENCES questAns (id)
);

CREATE TABLE recommend
(
    id        INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(100)   NOT NULL,
    design    VARCHAR(2000)  NOT NULL
        COMMENT 'Designation of the person who posted the recommendation.',
    note      VARCHAR(10000) NOT NULL
        COMMENT 'The actual recommendation-note given to the user.',
    dtCreated TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version   INT                     DEFAULT 1
);

CREATE TABLE education
(
    id        INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dtStart   DATE          NOT NULL
        COMMENT 'Start date of the qualification.',
    dtEnd     DATE                   DEFAULT NULL
        COMMENT 'End date of the qualification.',
    currQ     BOOLEAN                DEFAULT FALSE NOT NULL
        COMMENT 'Is the qualification completed?',
    inst      VARCHAR(100)  NOT NULL
        COMMENT 'Name of the institution.',
    qual      VARCHAR(5000) NOT NULL
        COMMENT 'Name of the qualification offered by the institution.',
    highs     VARCHAR(5000) NOT NULL
        COMMENT 'Highlights of the qualification.',
    oGrade    VARCHAR(75)   NOT NULL
        COMMENT 'Overall grade of the qualification.',
    dtCreated TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version   INT                    DEFAULT 1
)
    COMMENT
        = 'Capture the educational details of the resume.';

CREATE TABLE experience
(
    id        INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dtStart   DATE         NOT NULL
        COMMENT 'Start date of the designation.',
    dtEnd     DATE                  DEFAULT NULL
        COMMENT 'End date of the designation.',
    currP     BOOLEAN               DEFAULT 0 NOT NULL
        COMMENT 'Still holding current post?',
    desig     VARCHAR(100) NOT NULL
        COMMENT 'Designation of the employment position',
    natow     VARCHAR(900) NOT NULL
        COMMENT 'Nature of Work, job-description.',
    dtCreated TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version   INT                   DEFAULT 1
);

CREATE TABLE responsibility
(
    id            INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    experience_id INT          NOT NULL
        COMMENT 'Foreign key for Experience table.',
    resp          VARCHAR(500) NOT NULL
        COMMENT 'Each responsibility saved here.',
    dtCreated     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dtUpdated     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version       INT                   DEFAULT 1,
    CONSTRAINT fk_experience FOREIGN KEY (experience_id) REFERENCES experience (id)
)
    COMMENT
        = 'Responsibility table captures all of the responsibilities performed at each workplace.';


# ALTER TABLE dr_schema.education
#     DROP INDEX inx_username;

#
# ALTER TABLE dr_schema.experience
#     DROP
#         COLUMN version;

#
# ALTER TABLE dr_schema.experience
#   ADD COLUMN version INT DEFAULT 1;
#
#
#     ALTER TABLE dr_schema.responsibility
#   ADD COLUMN version INT DEFAULT 1;
#
#
# ALTER TABLE dr_schema.quest_ans
#   ADD COLUMN version INT DEFAULT 1;
#
#
#     ALTER TABLE dr_schema.quest_info
#   ADD COLUMN version INT DEFAULT 1;
#
#
# ALTER TABLE dr_schema.education
#   ADD COLUMN version INT DEFAULT 1;
#
#
#     ALTER TABLE dr_schema.recommend
#   ADD COLUMN version INT DEFAULT 1;

#
# ALTER TABLE emailMsg
#     CHANGE user_fk user_pk INT(11) NOT NULL;
#
# ALTER TABLE responsibility
#     CHANGE exp_fk experience_pk INT(11) NOT NULL;

SET FOREIGN_KEY_CHECKS = 1;

#
SELECT *
FROM dr_schema.user AS u
         LEFT JOIN dr_schema.emailMsg AS e ON u.id = e.id;


/*******************************************************************************************/
/**************************************BEGIN-PROC-SCRIPT************************************/
/*******************************************************************************************/
DELIMITER $$
use dr_schema;
$$
-- SET SQL_SAFE_UPDATES = 0; $$

-- CREATE DEFINER=`mysql`@`%`

Drop
    procedure if exists delete_test_files $$
CREATE
    DEFINER = `mysql`@`%` PROCEDURE delete_test_files(IN strVar VARCHAR(255))
BEGIN
    -- Declaring & instantiating variable
    -- ================================
    DECLARE strVar2 varchar(255);
    SET strVar2 := strVar;

    SET SQL_SAFE_UPDATES = 0; -- set safe_updates off
    delete
    from dr_schema.questAns
    where lower(quest) like CONCAT('%', strVar2, '%');
-- =================================

    SET SQL_SAFE_UPDATES = 1; -- set safe_updates back onn
    ALTER TABLE dr_schema.questAns
        AUTO_INCREMENT = 1; -- reset the primary key value of the table.

END $$
DELIMITER ;

/*******************************************************************************************/
/**************************************END-PROC-SCRIPT************************************/
/*******************************************************************************************/


/*******************************************************************************************/
/**************************************BEGIN-DATA-SCRIPT************************************/
/*******************************************************************************************/

USE dr_schema;

#
SET FOREIGN_KEY_CHECKS = 0;

# Question 1
INSERT INTO questAns (quest, ans)
VALUES ("Can you show us the way with a quick intro about yourself",
        "Most people know me as Kudzai or Sean. I am an experienced Software Engineer.
My passion is in designing, modelling & developing software systems that can do some cool stuff with Machine Learning.");

# Question 2
INSERT INTO questAns (quest, ans)
VALUES ("In just 40 words or so, tell us more about who you are", "I'm usually involved in the full-lifecycle of software projects,since I'm good in
        almost all aspects concerned with software development. That's what I enjoy doing
        and it enables me to put Bread & Butter on the table.");

# Question 3
INSERT INTO questAns (quest, ans)
VALUES ("Can you briefly highlight some of the interesting projects from various industries that you've done in the past",
        "Some of the interesting projects that I participated in included industries in:");

# Q 3.1
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Commercial: Crowd management software systems e.g. managing groups of students, club members e.t.c.");

# Q 3.2
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Telecoms: Call recording software system, recording calls on behalf of call-centers.");

# Q 3.3
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Academic: Evaluated Ensemble algorithms towards predicting student performance with a 97.3% accuracy.");

# Question 4
INSERT INTO questAns (quest, ans)
VALUES ("What software tools are you good at",
        "I've done several projects using software tools such as; MATLAB R2015, Java, Spring Framework, Jenkins, Gradle,
            Twitter Bootstrap, Bower, HTML5, JavaScript, JQuery, JSP, JPA, JPQL.Interesting projects include a lot of these awesome latest software tools.");

# Question 5
INSERT INTO questAns (quest, ans)
VALUES ("Now that we've established that you posses a unique set of skills. What interesting things can you practically do with them",
        "Although most of my experience comes from Software Development and Continuous Integration, I believe that
        we're now in the Intelligence-Erra, where we develop software systems that can extract, model and derive
        intelligence from the data autonomously. Artificial Neural Networks, Optimization, and Deep Learning have made this possibility a reality, through:");

# Q 5.1
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Pattern-recognition: Big-data, Credit Rating, Image Classification, Facial Recognition");

# Q 5.2
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Anomaly-detection: Fraud detection, Network Intrusions");

# Q 5.3
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns), "Prediction: Performance Prediction");

# Q 5.4
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Recommendation: Decision Support Systems");

# Question 6
INSERT INTO questAns (quest, ans)
VALUES ("What are some of your future/anticipated experiments", "My current/future/anticipated experiments are: ");

# Q 6.1
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Evaluating Deep Neural Networks for collision detection & avoidance in UAV/Drones.");

# Q 6.2
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Deep Learning & Computer Vision for Security (criminal activity tracking & mobility) & Neighborhood Surveillance.");

# Q 6.3
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns), "Proving the possibility of Free Calling. The aim of this experiment is
              to help villagers access good quality communication signal coverage at free of charge in rural areas.
              Alongside me on this project, is my dear friend Dr. Geneviève Tan Shu Thung.");

# Question 7.
INSERT INTO questAns (quest, ans)
VALUES ("Aside from all the gimmicks, what else do you do for fun", "I embrace creativity, and as a pianist/music producer, music has become
          that part of me that opens up my mind to a free-flow of ideas in the form of sound.
         Like any mathematician, Chess is always a great game for training the brain's muscles. E.g. weighing up
         all options before dicing up opportunities. I like recreational activities,
         so here and there, if I'm not coding or experimenting you'll find me:");

# Q 7.1
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Sports: indoor soccer (as a goal-keeper), rugby (left-winger), basketball.");

# Q 7.2
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Action: Sky-Diving, Go-Karting, Jet-Skiing.");

# Q 7.3
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Adventure: Exploring other places in nature with the intention to learn more about the field of Biologically Inspired Computation.");
# Q 7.4
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns), "Computer Gaming: I think of this activity as a way of
imitating reality through Simulation Training e.g Aviation Industries. I am also curious of how Machine Learning
has been applied to improve computer graphics in gaming e.g. Grand Theft Auto V - 'Alireza Shafaei, a
'PhD student AT UBC' Play and Learn: Using Video Games to Train Computer Vision Models.");

# Question 8
INSERT INTO questAns (quest, ans)
VALUES ("Anything else that you like doing",
        "Yes of course, besides building my career from teamwork and practical experience alone, we live in an erra where good education is free. In my relaxing time I participate in free-online courses from world-class universities. The likes of Stanford University, University of California, Johns Hopkins University, University of Cape Town e.t.c. My attitude towards my career is equipped with a sort of a mindset that embraces continuous-learning/sharing knowledge through: ");

# Q 8.1
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Witting and publishing articles in line with my skills that I am passionate about.");

# Q 8.2
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Coursera - An online platform with free online courses from world class universities.");

# Q 8.3
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns),
        "Udacity - Another online platform with free online courses developed by experts from the likes of Google, Amazon, WhatsApp, Facebook e.t.c");

# Q 8.4
INSERT INTO questInfo (questAns_id, bInfo)
VALUES ((SELECT max(id)
         FROM dr_schema.questAns), "Hackathon Events/Challenges.");

/*
  Recommendations
*/
INSERT INTO recommend (name, design, note)
VALUES ("Dr. Tony Browne (BSc/MSc/PhD/CEng)", "Senior Scientist at Data Predict",
        "I taught Kudzai on the Software Engineering module of the MSc offered by Liverpool University. Kudzai was an excellent student, achieving very high marks throughout the module. As well as his Software Engineering skills, Kudzai has very good research, communication and report writing skills. I wholeheartedly recommend Kudzai to any future employer or post-MSc programme of study.");
INSERT INTO recommend (name, design, note)
VALUES ("Mario Santos", "Software Engineer at Microsoft (Skype Division)",
        "I had chance to work with Kudzai on a Quality Assurance project at University of Liverpool Software QA class. He is a very dedicated professional with strong critical skills, and with an intense commitment, he is able to assume tasks and meet his proposed goals. His positive approach to life is contagious and for sure an important skill as a highly capable professional that he is. With characteristics of a natural leader, his commitment and leadership are success keys for any position.");
INSERT INTO recommend (name, design, note)
VALUES ("Stefan Nicolet", "Researcher at the Swiss Institute of Bioinformatics",
        "Kudzai Sean Huni and I have followed together online the System Analysis and Design using UML and Software Quality Assurance courses at the University of Liverpool. During those courses, Kudzai has always been highly participative and added to each online class discussion clever comments and answers that were original and very often thought out of the box. His comments were helping all of us to learn new concepts and progress together in our respective IT or management studies. In addition to its valuable participation, Kudzai always asked or answered questions with respect and encouragements, being positive and solution-oriented rather than problem-focused. He always demonstrates that he possess all the hard and soft skills to be an excellent project manager and/or a key team member. I highly recommend Kudzai, being certain that any employer would benefit of his high-skills, imaginative solutions and constant positive attitude.");
INSERT INTO recommend (name, design, note)
VALUES ("Karlyn Barilovits", "Dean, School of Information Systems and Technology at Walden University",
        "I had the opportunity to teach Kudzai Sean Huni at the University of Liverpool. During that time, I found Kudzai to be intelligent and hard working. All work was submitted in a timely manner. Strong critical thinking skills were evident in the work that Kudzai submitted to the class. Kudzai interacted well with classmates and was a strong student!");
INSERT INTO recommend (name, design, note)
VALUES ("Francois Combrink", "Senior Architect (Permanent) at Quintica",
        "I studied with the Kudzai Sean at University of Liverpool, in the Security Engineering module. His class-participation and contribution to the Security Engineering Group Project was outstanding. Kudzai Sean demonstrated excellent skills in designing secure distributed networks relative to the network's infrastructure and architecture. He possess fundamental skills necessary for teamwork settings. It was a pleasure to work with Kudzai Sean Huni.");
INSERT INTO recommend (name, design, note)
VALUES ("Tatyana Larikova",
        "Data scientist __ Machine Learning Engineer __ Technology Entrepreneur __ Social Media Marketer __ Assistant Professor",
        "I had an experience to study with Kudzai in University of Liverpool. He is outstanding student and great personality. I always enjoyed professional communication with him and found his critical thinking skills and study efforts on high level.");
INSERT INTO recommend (name, design, note)
VALUES ("Lionel Dupré", "CISO at EBRC - Data Centre, Cloud & Managed Services",
        "Sean and I both worked during our MSc in the same group for a group project. Sean demonstrated a very clear thinking, a sharp out-of-the-box reasoning and a great capacity to deliver. I was very happy to work with him and I hope I will again one day.");
INSERT INTO recommend (name, design, note)
VALUES ("Calvin Kodisang", "Licensing Specialist at Dimension Data",
        "Sean is very competent and eager to get task at hand complete and He is a friendly team player. He always professional and ethical.");
INSERT INTO recommend (name, design, note)
VALUES ("Rhet Evans", "Security Analyst",
        "Sean is an extremely dedicated and focused individual. He is well coordinated and was our acting student representative. Sean performed his duties efficiently, as well as resolving any issues that arose. Sean shows a fine work ethic in any environment.");
INSERT INTO recommend (name, design, note)
VALUES ("Zulekha Dockrat", "Senior Technical Business Analyst",
        "Sean is bright, studious, accomplished and articulate. I was fortunate to have had the opportunity to interact with a young man with such integrity and maturity. I have no reservations in recommending him.");

# Populating Education Data
# SET FOREIGN_KEY_CHECKS = 0;
# TRUNCATE table dr_schema.education;
# SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO education (dtStart, dtEnd, inst, qual, highs, oGrade)
VALUES (STR_TO_DATE('02-05-2017', '%d-%m-%Y'), STR_TO_DATE('03-06-2017', '%d-%m-%Y'),
        "Udemy (Online Course)",
        "<a type=\"button\" class=\"btn btn-outline-info\" target=\"_blank\" href=\"/resrc/int-doc/UC-4C1R999B.pdf\">Cert in Spring Core Advanced</a>",
        "Aspect Oriented Programming, Spring-MVC, Spring Security, Spring Data JPA, Spring Application Events.",
        "{Completed}");
INSERT INTO education (dtStart, dtEnd, inst, qual, highs, oGrade)
VALUES (STR_TO_DATE('02-10-2016', '%d-%m-%Y'), STR_TO_DATE('06-01-2017', '%d-%m-%Y'),
        "University of Toronto, Canada (Coursera)",
        "<a type=\"button\" class=\"btn btn-outline-info\" target=\"_blank\" href=\"https://www.coursera.org/account/accomplishments/records/55NUESYZPL5G\">Cert in Neural Networks</a>",
        "Convolutional Nets, Recurrent (LSTM) Nets, Echo State Nets, Hopefield Nets, R.B.M, D.B.Ns, G.A.Ns.",
        "{Grade Achieved: 100%}");
INSERT INTO education (dtStart, dtEnd, inst, qual, highs, oGrade)
VALUES (STR_TO_DATE('03-10-2013', '%d-%m-%Y'), STR_TO_DATE('22-07-2016', '%d-%m-%Y'), "University of Liverpool",
        "<a type=\"button\" class=\"btn btn-outline-info\" target=\"_blank\" href=\"/resrc/int-doc/MSc_Software_Engineering.pdf\">MSc in Software Engineering</a>",
        "Software & Security Engineering, Machine Learning, OOP (Java), System Analysis & Design.",
        "{Graduated with 4 Distinctions}");
INSERT INTO education (dtStart, dtEnd, inst, qual, highs, oGrade)
VALUES (STR_TO_DATE('12-10-2015', '%d-%m-%Y'), STR_TO_DATE('19-12-2015', '%d-%m-%Y'),
        "Stanford University, USA (Coursera)",
        "<a type=\"button\" class=\"btn btn-outline-info\" target=\"_blank\" href=\"https://www.coursera.org/account/accomplishments/records/3JB37SHN3NTT\">Cert in Machine Learning</a>",
        "Linear/Logistic Regression, SVM, PCA, Neural Networks, Photo ORC.",
        "{Grade Achieved: 100%}"); # Serialize the data <a href="https://www.coursera.org/account/accomplishments/records/3JB37SHN3NTT">Cert in Machine Learning</a>
INSERT INTO education (dtStart, dtEnd, inst, qual, highs, oGrade)
VALUES (STR_TO_DATE('01-02-2012', '%d-%m-%Y'), STR_TO_DATE('16-11-2013', '%d-%m-%Y'), "Heriot-Watt University",
        "<a type=\"button\" class=\"btn btn-outline-info\" target=\"_blank\" href=\"/resrc/int-doc/BSc_Computer_Systems_Degree.pdf\">BSc in Computer Systems</a>",
        "Software Engineering, Artificial Intelligence & Intelligent Agents, Operating Systems & Concurrency.",
        "{Student Ambassador Rep., Grade: 67%}");
INSERT INTO education (dtStart, dtEnd, inst, qual, highs, oGrade)
VALUES (STR_TO_DATE('01-02-2010', '%d-%m-%Y'), STR_TO_DATE('16-11-2012', '%d-%m-%Y'),
        "London School of Business & Management",
        "<a type=\"button\" class=\"btn btn-outline-info\" target=\"_blank\" href=\"/resrc/int-doc/BTEC_HND.pdf\">BTEC HND in Information Technology</a>",
        "Mathematics, Data Structures & Algorithms, Software Development, Systems Analysis & Design.",
        "{Graduated with 10 Distinctions}");

# Populating Experience Data
# SET FOREIGN_KEY_CHECKS = 0;
# TRUNCATE table experience;
# TRUNCATE table responsibility;
# SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO experience (dtStart, dtEnd, currP, desig, natow)
VALUES (STR_TO_DATE('30-01-2017', '%d-%m-%Y'), STR_TO_DATE('31-08-2018', '%d-%m-%Y'), FALSE,
        "Consultant @African Bank", "Responsibilities:"); # Fix the date, Currently working until NOW checkbox.
INSERT INTO experience (dtStart, dtEnd, currP, desig, natow)
VALUES (STR_TO_DATE('19-12-2015', '%d-%m-%Y'), STR_TO_DATE('01-01-1900', '%d-%m-%Y'), TRUE, "Co-Founder & ML Engineer",
        "Responsibilities:"); # Fix the date, Currently working until NOW checkbox.
INSERT INTO experience (dtStart, dtEnd, desig, natow)
VALUES (STR_TO_DATE('16-04-2016', '%d-%m-%Y'), STR_TO_DATE('31-07-2016', '%d-%m-%Y'), "Operations Support",
        "Responsibilities:");
INSERT INTO experience (dtStart, dtEnd, desig, natow)
VALUES (STR_TO_DATE('01-03-2015', '%d-%m-%Y'), STR_TO_DATE('30-06-2015', '%d-%m-%Y'), "Jnr Software Developer",
        "Responsibilities:");
INSERT INTO experience (dtStart, dtEnd, desig, natow)
VALUES (STR_TO_DATE('01-02-2013', '%d-%m-%Y'), STR_TO_DATE('01-07-2014', '%d-%m-%Y'), "Jnr Software Developer",
        "Responsilities:");

# Populating Responsibility Config-Data
INSERT INTO responsibility (experience_id, resp)
VALUES (1, "Web/Java & Spring Framework development.");
INSERT INTO responsibility (experience_id, resp)
VALUES (1, "Design, implement, verify, validate and provide support to new/existing banking applications.");
INSERT INTO responsibility (experience_id, resp)
VALUES (1,
        "Training Junior Developers and provide encouraging feedback ensuring quality work while adhering to coding standards.");
INSERT INTO responsibility (experience_id, resp)
VALUES (1,
        "Proactively find problems that can be resolved with Machine Learning and liaise with the affected stakeholders for implementing the solution.");
INSERT INTO responsibility (experience_id, resp)
VALUES (1,
        "Collaborate in an agile driven environment with my team where we utilise mostly the scrum development process to deliver solutions through iterations of successive sprints.");
INSERT INTO responsibility (experience_id, resp)
VALUES (1, "Report on the daily progress.");

INSERT INTO responsibility (experience_id, resp)
VALUES (2, "Designing, developing & implementing upcoming systems using Scikit-Learn, Python, Matlab.");
INSERT INTO responsibility (experience_id, resp)
VALUES (2,
        "Assisting clients on how to integrate Machine Learning from their current software systems, with a significant reduction in costs and manpower.");
INSERT INTO responsibility (experience_id, resp)
VALUES (2,
        "Analysing trends, building statistical models for autonomous software systems such as Fraud Detection, Decision-Support Systems, Recommendations, Vision, Image & Handwriting/Text Recognition.");

INSERT INTO responsibility (experience_id, resp)
VALUES (3, "Supporting & resolving bugs.");
INSERT INTO responsibility (experience_id, resp)
VALUES (3, "Oracle PL/SQL, Web Services (SOAP, XML), Linux Ubuntu.");
INSERT INTO responsibility (experience_id, resp)
VALUES (3, "Implemented Jenkins & Nexus on Test servers as a new standard out of individual initiative.");
INSERT INTO responsibility (experience_id, resp)
VALUES (3, "Executed work strictly according to allocated support tickets.");

INSERT INTO responsibility (experience_id, resp)
VALUES (4, "EJB3, Java EE, Java SE, JPA2, Spring MVC, JavaScript, HTML, JQuery.");
INSERT INTO responsibility (experience_id, resp)
VALUES (4, "Application Servers (Glassfish, JBoss).");
INSERT INTO responsibility (experience_id, resp)
VALUES (4, "Linux Ubuntu, Code repositories (SVN/Git Version Control).");
INSERT INTO responsibility (experience_id, resp)
VALUES (4, "Mule & ActiveMQ.");
INSERT INTO responsibility (experience_id, resp)
VALUES (4, "Unit Testing.");

INSERT INTO responsibility (experience_id, resp)
VALUES (5, "Back-end and Front-end programming in conjunction with the SmartClient Framework.");
INSERT INTO responsibility (experience_id, resp)
VALUES (5, "Faund Cloud Directory Service.");
INSERT INTO responsibility (experience_id, resp)
VALUES (5, "AdminOnline Management System.");
INSERT INTO responsibility (experience_id, resp)
VALUES (5, "GSM & SMS enabled Memeza Alarm System.");


INSERT INTO dr_schema.user (username, password, enabled, version)
    VALUE ("sean2kay@gmail.com", MD5("password"), 1, 39238);

# SET FOREIGN_KEY_CHECKS = 0;

/*******************************************************************************************/
/**************************************END-DATA-SCRIPT************************************/
/*******************************************************************************************/
