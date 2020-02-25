-- Q1
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (1, 'Can you show us the way with a quick intro about yourself',
        'Most people know me as a Java/Spring Boot Software Engineer or Deep Learning Guru.',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q2
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (2, 'In just a few words or so, tell us more about who you are',
        'I''m usually involved in the full-lifecycle of software projects,since I''m good in almost all aspects concerned with software development. That''s what I enjoy doing and it enables me to put Bread & Butter on the table.',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q3
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (3,
        'Can you briefly highlight some of the interesting projects from various industries that you''ve done in the past',
        'Some of the interesting projects that I participated in included industries in:',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q3.1
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (1, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Commercial: Crowd management software systems e.g. managing groups of students, club members e.t.c.',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q3.2
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (2, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Telecoms: Call recording software system, recording calls on behalf of call-centers.',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q3.3
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (3, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Academic: Evaluated Ensemble algorithms towards predicting student performance with a 97.3% accuracy.',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q4
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (4,
        'What software tools are you good at',
        'I''ve done several projects using software tools such as; MATLAB R2015, Java, Spring Boot, Jenkins, Gradle, Twitter Bootstrap, Angular 8, HTML5, JavaScript, JQuery, JSP, JPA, JPQL. Interesting projects include a lot of these awesome latest software tools.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q5
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (5,
        'Now that we''ve established that you posses a unique set of skills. What interesting things can you practically do with them',
        'Although most of my experience comes from Software Development and Continuous Integration, I believe that we''re now in the Intelligence-Erra, where we develop software systems that can extract, model and derive intelligence from the data autonomously. Artificial Neural Networks, Optimization, and Deep Learning have made this possibility a reality, through: ',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q5.1
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (4, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Pattern-recognition: Big-data, Credit Rating, Image Classification, Facial Recognition',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q5.2
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (5, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Anomaly-detection: Fraud detection, Network Intrusions',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q5.3
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (6, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Prediction: Performance Prediction',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q5.4
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (7, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Recommendation: Decision Support Systems',
        1,
        CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());

-- Q6
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (6,
        'What are some of your future/anticipated experiments',
        'My current/future/anticipated experiments are: ',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q6.1
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (8, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Evaluating Deep Neural Networks for collision detection & avoidance in UAV/Drones.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q6.2
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (9, (SELECT max(id)
            FROM dr_schema.quest_ans),
        'Deep Learning & Computer Vision for Security (criminal activity tracking & mobility) & Neighborhood Surveillance.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q6.3
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (10, (SELECT max(id)
             FROM dr_schema.quest_ans),
        'Proving the possibility of Free Calling. The aim of this experiment is to help villagers access good quality communication signal coverage at free of charge in rural areas. Alongside me ON this project, is my dear friend Dr.Geneviève Tan Shu Thung.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q7
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (7, 'Aside from all the gimmicks, what else do you do for fun',
        'I embrace creativity, and as a pianist/music producer, music has become that part of me that opens up my mind to a free-flow of ideas in the form of sound. Like any mathematician, Chess is always a great game for training the brain''s muscles. E.g. weighing up all options before dicing up opportunities. I like recreational activities, so here and there, if I''m not coding or experimenting you''ll find me: ',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q7.1
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (11, (SELECT max(id) FROM dr_schema.quest_ans), 'Sports: indoor soccer (as a goal-keeper), rugby (left-winger), basketball.', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q7.2
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (12, (SELECT max(id) FROM dr_schema.quest_ans), 'Action: Skydiving, Go-Karting, Jet-Skiing.', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q7.3
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (13, (SELECT max(id) FROM dr_schema.quest_ans), 'Adventure: Exploring other places in nature with the intention to learn more about the field of Biologically Inspired Computation.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q7.4
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (14, (SELECT max(id) FROM dr_schema.quest_ans), 'Computer Gaming: I think of this activity as a way of imitating reality through Simulation Training e.g Aviation Industries. I am also curious of how Deep Learning has been applied to improve computer graphics in gaming e.g. Grand Theft Auto V - ''Alireza Shafaei, a ''PhD student AT UBC'' Play and Learn: Using Video Games to Train Computer Vision Models.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q8
INSERT INTO dr_schema.quest_ans (id, quest, ans, version, dt_created, dt_updated)
VALUES (8, 'Anything else that you like doing', 'Yes of course, besides building my career from teamwork and practical experience alone, we live in an era where good education is free. In my relaxing time I participate in free-online courses from world-class universities. The likes of Stanford University, University of California, University of Toronto, University of Liverpool e.t.c. My attitude towards my career is equipped with a sort of a mindset that embraces continuous-learning/sharing knowledge through: ',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q8.1
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (15, (SELECT max(id)
             FROM dr_schema.quest_ans),
        'Witting and publishing articles in line with my skills that I am passionate about.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q8.2
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (16, (SELECT max(id) FROM dr_schema.quest_ans), 'Coursera - An online platform with free online courses from world class universities.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q8.3
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (17, (SELECT max(id)
             FROM dr_schema.quest_ans),
        'Udacity - Another online platform with free online courses developed by experts from the likes of Google, Amazon, WhatsApp, Facebook e.t.c',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- Q8.4
INSERT INTO dr_schema.quest_info (id, QUEST_ANS_ID, B_INFO, version, dt_created, dt_updated)
VALUES (18, (SELECT max(id)
             FROM dr_schema.quest_ans),
        'Hackathon Events/Challenges.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

# --------------------------------------------------------------------------------------------
# -------------------------------Start-Experience-Data----------------------------------------
# --------------------------------------------------------------------------------------------

-- # Populating Experience Data
-- # SET FOREIGN_KEY_CHECKS = 0;
-- # TRUNCATE table experience;
-- # TRUNCATE table responsibility;
-- # SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO dr_schema.experience (id, dt_start, dt_end, currP, desig, comp, location, natow, version, dt_created, dt_updated)
VALUES (1, STR_TO_DATE('01-07-2019', '%d-%m-%Y'), STR_TO_DATE('20-04-1900', '%d-%m-%Y'), TRUE,
        'Founder & Software Engineer', 'Alpha Zeus', 'Norscot, ZAF', 'Responsibilities: ', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.experience (id, dt_start, dt_end, currP, desig, comp, location, natow, version, dt_created, dt_updated)
VALUES (2, STR_TO_DATE('01-03-2019', '%d-%m-%Y'), STR_TO_DATE('20-04-1900', '%d-%m-%Y'), TRUE,
        'Senior Java Consultant', 'Britehouse Mobility/Standard Bank', 'Sandton, ZAF','Responsibilities: ', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.experience (id, dt_start, dt_end, currP, desig, comp, location, natow, version, dt_created, dt_updated)
VALUES (3, STR_TO_DATE('19-12-2015', '%d-%m-%Y'), STR_TO_DATE('30-04-2019', '%d-%m-%Y'), FALSE,
        'Co-Founder & ML Engineer (Part-Time)', 'Tech Company Group', 'Sydney, AUS', 'Responsibilities: ', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.experience (id, dt_start, dt_end, currP, desig, comp, location, natow, version, dt_created, dt_updated)
VALUES (4, STR_TO_DATE('30-01-2017', '%d-%m-%Y'), STR_TO_DATE('31-08-2018', '%d-%m-%Y'), FALSE,
        'Java Consultant', 'Tangent Solutions/African Bank', 'Bryanston, ZAF','Responsibilities: ', 1, CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP()); # Fix the date, Currently working until NOW checkbox.

INSERT INTO dr_schema.experience (id, dt_start, dt_end, currP, desig, comp, location, natow, version, dt_created, dt_updated)
VALUES (5, STR_TO_DATE('16-04-2016', '%d-%m-%Y'), STR_TO_DATE('31-07-2016', '%d-%m-%Y'), FALSE, 'Java Operations Support',
        'VAS-X/Cell C', 'Woodmead, ZAF','Responsibilities: ', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.experience (id, dt_start, dt_end, currP, desig, comp, location,  natow, version, dt_created, dt_updated)
VALUES (6, STR_TO_DATE('01-03-2015', '%d-%m-%Y'), STR_TO_DATE('30-06-2015', '%d-%m-%Y'), FALSE, 'Java Software Developer',
        'ECN/Nashua', 'Midrand, ZAF','Responsibilities: ', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.experience (id, dt_start, dt_end, currP, desig, comp, location, natow, version, dt_created, dt_updated)
VALUES (7, STR_TO_DATE('01-02-2013', '%d-%m-%Y'), STR_TO_DATE('01-07-2014', '%d-%m-%Y'), FALSE, 'Java Software Developer',
        'Integrity IT Solutions', 'Centurion, ZAF','Responsibilities: ', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

# -------------------------------Responsibilities-Data------------------------------------------
# Populating Responsibility Config-Data

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (1, 1, 'Continuous Professional Development (CPD) – Special emphasis on continuous learning, acquiring new knowledge and skills to enhancing the level of professional competence within the modern industry.', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (2, 1, 'Designing, developing and implementing redundant cloud-driven software solutions that are scalable on demand, billable per usage, and reliable to end-users with minimal downtime.', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (3, 1, 'Supporting & maintaining existing Spring Cloud Netflix software systems.', 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (4, 1, 'Tech Stack: Spring-Cloud, Spring-Boot, Circle-Ci, Docker, Kubernetes, Jacoco, Sonarqube, Git, Java-11.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (5, 2, 'Refactoring & migrating back-end monolith systems to Spring Boot containerised microservices. A microservice ecosystem',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (6, 2, 'Redesigning and migrating legacy database structures into maintainable and scalable relational models.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (7, 2, 'High-quality production-ready code in agile environments through the use of test-driven methodologies.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (8, 2, 'Training & mentoring new developers and engaging in code-review sessions.', 1,
        CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (9, 2, 'Designing and implementing cloud-ready Prototypes/P.O.C''s for the proposed microservices architecture solutions',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (10, 3, 'Designing, developing & implementing upcoming systems using Scikit-Learn, Python, Matlab.', 1,
        CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (11, 3, 'Assisting clients on integrating Machine Learning within their current systems, with a significant added value on revenue',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (12, 3, 'Analysing trends, building statistical models for autonomous software systems such as Fraud Detection, Decision-Support Systems, Recommendations, Vision, Image & Handwriting/Text Recognition.', 1,
        current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (13, 4, 'Rewriting/Migrating traditional back-end monolith systems to containerized microservices.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (14, 4, 'Provided support for the African Bank website (Spring-Framework, Spring-MVC).', 1,
        CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (15, 4, 'Training Junior Developers and provided encouraging feedback ensuring quality work while adhering to coding standards.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (16, 4, 'Collaborated in an agile driven environment with the team where we utilise mostly the scrum development process to deliver solutions through iterative successful sprints.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (17, 4, 'Middleware microservices for transactional banking in an agile-driven team (scrum).', 1,
        CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (18, 4, 'Collaborated with Business Analysts, System Analysts and other stakeholders from various business units in redeveloping services for African Bank.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (19, 4, 'Involved in several 3rd party integrations with different stakeholders including Blue Label telecoms, Thunderhead, DEA, Direct-Transact for airtime, electricity, online bank statements, transactional banking, loan, documents, and notification services.',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (20, 4, 'Tech-Stack: Jenkins, Jacoco, Spring-MVC, Spring-Boot, Spring-Cloud, Docker, Docker-Swarm, Sonarqube, Artifactory, Git, Gitlab, Java-8',
        1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (21, 5, 'Supporting & resolving bugs.', 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (22, 5, 'Oracle PL/SQL, Web Services (SOAP, XML), Linux Ubuntu.', 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (23, 5, 'Implemented Jenkins & Nexus on Test servers as a new standard out of individual initiative', 1,
        current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (24, 5, 'Executed work strictly according to allocated support tickets.', 1,
        current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (25, 6, 'EJB3, Java EE, Java SE, JPA2, Spring MVC, JavaScript, HTML, JQuery.', 1, current_timestamp(),
        current_timestamp());
INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (26, 6, 'Application Servers (Glassfish, JBoss).', 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (27, 6, 'Linux Ubuntu, Code repositories (SVN/Git Version Control).', 1, current_timestamp(),
        current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (28, 6, 'Mule & ActiveMQ.', 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (29, 6, 'Unit Testing.', 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (30, 7, 'Back-end and Front-end programming in conjunction with the SmartClient Framework.', 1,
        current_timestamp(), current_timestamp());

INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (31, 7, 'Faund Cloud Directory Service.', 1, current_timestamp(), current_timestamp());
INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (32, 7, 'AdminOnline Management System.', 1, current_timestamp(), current_timestamp());
INSERT INTO dr_schema.responsibility (id, experience_id, resp, version, dt_created, dt_updated)
VALUES (33, 7, 'GSM & SMS enabled Memeza Alarm System.', 1, current_timestamp(), current_timestamp());

# --------------------------------------------------------------------------------------------
# -------------------------------End-Experience-Data------------------------------------------
# --------------------------------------------------------------------------------------------


# --------------------------------------------------------------------------------------------
# -------------------------------Start-Education-Data-----------------------------------------
# --------------------------------------------------------------------------------------------
INSERT INTO dr_schema.education (ID, DT_START, DT_END, INST, loca, QUAL, HIGHS, O_GRADE, CURRQ, VERSION, dt_created,
                                 dt_updated)
VALUES (1, STR_TO_DATE('02-05-2017', '%d-%m-%Y'), STR_TO_DATE('03-06-2017', '%d-%m-%Y'),
        'Udemy', 'Online',
        '<a type="button" class="btn btn-outline-success" target="_blank" href="assets/download/UC-4C1R999B.pdf">Cert in Spring Core Advanced</a>',
        'Aspect Oriented Programming, Spring-MVC, Spring Security, Spring Data JPA, Spring Application Events.',
        '{Completed}', 0, 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.education (id, DT_START, DT_END, INST, loca, QUAL, HIGHS, O_GRADE, CURRQ, VERSION, dt_created,
                                 dt_updated)
VALUES (2, STR_TO_DATE('02-10-2016', '%d-%m-%Y'), STR_TO_DATE('06-01-2017', '%d-%m-%Y'),
        'University of Toronto, Canada', 'Online (Coursera)',
        '<a type="button" class="btn btn-outline-success" target="_blank" href="https://www.coursera.org/account/accomplishments/records/FBTBQ9USJ3CB">Cert in Neural Networks</a>',
        'Convolutional Nets, Recurrent (LSTM) Nets, Echo State Nets, Hopefield Nets, R.B.M, D.B.Ns, G.A.Ns.',
        '{Grade Achieved: 100%}', 0, 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.education (id, DT_START, DT_END, INST, loca, QUAL, HIGHS, O_GRADE, CURRQ, VERSION, dt_created,
                                 dt_updated)
VALUES (3, STR_TO_DATE('03-10-2013', '%d-%m-%Y'), STR_TO_DATE('22-07-2016', '%d-%m-%Y'), 'University of Liverpool', 'Liverpool, England, UK',
        '<a type="button" class="btn btn-outline-success" target="_blank" href="assets/download/MSc_Software_Engineering.pdf">MSc in Software Engineering</a>',
        'Software & Security Engineering, Machine Learning, OOP (Java), System Analysis & Design.',
        '{Graduated with 4 Distinctions}', 0, 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.education (id, DT_START, DT_END, INST, loca, QUAL, HIGHS, O_GRADE, CURRQ, VERSION, dt_created,
                                 dt_updated)
VALUES (4, STR_TO_DATE('12-10-2015', '%d-%m-%Y'), STR_TO_DATE('19-12-2015', '%d-%m-%Y'),
        'Stanford University, USA', 'Online',
        '<a type="button" class="btn btn-outline-success" target="_blank" href="https://www.coursera.org/account/accomplishments/records/Y9GPAXXLQQ4X">Cert in Machine Learning</a>',
        'Linear/Logistic Regression, SVM, PCA, Neural Networks, Photo ORC.',
        '{Grade Achieved: 100%}', 0, 1, current_timestamp(),
        current_timestamp()); -- Serialize the data <a href="https://www.coursera.org/account/accomplishments/records/3JB37SHN3NTT">Cert in Machine Learning</a>

INSERT INTO dr_schema.education (id, DT_START, DT_END, INST, loca, QUAL, HIGHS, O_GRADE, CURRQ, VERSION, dt_created,
                                 dt_updated)
VALUES (5, STR_TO_DATE('01-02-2012', '%d-%m-%Y'), STR_TO_DATE('16-11-2013', '%d-%m-%Y'), 'Heriot-Watt University', 'Edinburgh, Scotland, UK',
        '<a type="button" class="btn btn-outline-success" target="_blank" href="assets/download/BSc_Computer_Systems_Degree.pdf">BSc in Computer Systems</a>',
        'Software Engineering, Artificial Intelligence & Intelligent Agents, Operating Systems & Concurrency.',
        '{Student Ambassador Rep., Grade: 67%}', 0, 1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.education (id, DT_START, DT_END, INST, loca, QUAL, HIGHS, O_GRADE, CURRQ, VERSION, dt_created,
                                 dt_updated)
VALUES (6, STR_TO_DATE('01-02-2010', '%d-%m-%Y'), STR_TO_DATE('16-11-2012', '%d-%m-%Y'),
        'London School of Business & Management', 'London, England, UK',
        '<a type="button" class="btn btn-outline-success" target="_blank" href="assets/download/BTEC_HND.pdf">BTEC HND in Information Technology</a>',
        'Mathematics, Data Structures & Algorithms, Software Development, Systems Analysis & Design.',
        '{Graduated with 10 Distinctions}', 0, 1, current_timestamp(), current_timestamp());

# --------------------------------------------------------------------------------------------
# -------------------------------End-Education-Data------------------------------------------
# --------------------------------------------------------------------------------------------


# --------------------------------------------------------------------------------------------
# -------------------------------Start-Recommendation-Data------------------------------------
# --------------------------------------------------------------------------------------------
INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (1, 'Dr. Tony Browne (BSc/MSc/PhD/CEng)', 'Senior Scientist at Data Predict',
        'I taught Kudzai on the Software Engineering module of the MSc offered by Liverpool University. Kudzai was an excellent student, achieving very high marks throughout the module. As well as his Software Engineering skills, Kudzai has very good research, communication and report writing skills. I wholeheartedly recommend Kudzai to any future employer or post-MSc programme of study.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (2, 'Mario Santos', 'Software Engineer at Microsoft (Skype Division)',
        'I had chance to work with Kudzai on a Quality Assurance project at University of Liverpool Software QA class. He is a very dedicated professional with strong critical skills, and with an intense commitment, he is able to assume tasks and meet his proposed goals. His positive approach to life is contagious and for sure an important skill as a highly capable professional that he is. With characteristics of a natural leader, his commitment and leadership are success keys for any position.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (3, 'Stefan Nicolet', 'Researcher at the Swiss Institute of Bioinformatics',
        'Kudzai Sean Huni and I have followed together online the System Analysis and Design using UML and Software Quality Assurance courses at the University of Liverpool. During those courses, Kudzai has always been highly participative and added to each online class discussion clever comments and answers that were original and very often thought out of the box. His comments were helping all of us to learn new concepts and progress together in our respective IT or management studies. In addition to its valuable participation, Kudzai always asked or answered questions with respect and encouragements, being positive and solution-oriented rather than problem-focused. He always demonstrates that he possess all the hard and soft skills to be an excellent project manager and/or a key team member. I highly recommend Kudzai, being certain that any employer would benefit of his high-skills, imaginative solutions and constant positive attitude.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (4, 'Karlyn Barilovits', 'Dean, School of Information Systems and Technology at Walden University',
        'I had the opportunity to teach Kudzai Sean Huni at the University of Liverpool. During that time, I found Kudzai to be intelligent and hard working. All work was submitted in a timely manner. Strong critical thinking skills were evident in the work that Kudzai submitted to the class. Kudzai interacted well with classmates and was a strong student!',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (5, 'Francois Combrink', 'Senior Architect (Permanent) at Quintica',
        'I studied with the Kudzai Sean at University of Liverpool, in the Security Engineering module. His class-participation and contribution to the Security Engineering Group Project was outstanding. Kudzai Sean demonstrated excellent skills in designing secure distributed networks relative to the network''s infrastructure and architecture. He possess fundamental skills necessary for teamwork settings. It was a pleasure to work with Kudzai Sean Huni.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (6, 'Tatyana Larikova',
        'Data scientist __ Machine Learning Engineer __ Technology Entrepreneur __ Social Media Marketer __ Assistant Professor',
        'I had an experience to study with Kudzai in University of Liverpool. He is outstanding student and great personality. I always enjoyed professional communication with him and found his critical thinking skills and study efforts on high level.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (7, 'Lionel Dupré', 'CISO at EBRC - Data Centre, Cloud & Managed Services',
        'Sean and I both worked during our MSc in the same group for a group project. Sean demonstrated a very clear thinking, a sharp out-of-the-box reasoning and a great capacity to deliver. I was very happy to work with him and I hope I will again one day.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (8, 'Calvin Kodisang', 'Licensing Specialist at Dimension Data',
        'Sean is very competent and eager to get task at hand complete and He is a friendly team player. He always professional and ethical.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (9, 'Rhet Evans', 'Security Analyst',
        'Sean is an extremely dedicated and focused individual. He is well coordinated and was our acting student representative. Sean performed his duties efficiently, as well as resolving any issues that arose. Sean shows a fine work ethic in any environment.',
        1, current_timestamp(), current_timestamp());

INSERT INTO dr_schema.recommend (id, name, design, note, VERSION, dt_created, dt_updated)
VALUES (10, 'Zulekha Dockrat', 'Senior Technical Business Analyst',
        'Sean is bright, studious, accomplished and articulate. I was fortunate to have had the opportunity to interact with a young man with such integrity and maturity. I have no reservations in recommending him.',
        1, current_timestamp(), current_timestamp());

# --------------------------------------------------------------------------------------------
# -------------------------------End-Recommendation-Data--------------------------------------
# --------------------------------------------------------------------------------------------

# INSERT INTO dr_schema.user (id, username, password, enabled, VERSION, dt_created, dt_updated) VALUES
# (1, 'sean2kay@gmail.com',  HASH('SHA256', STRINGTOUTF8('password'), 1000), 1, 39238, current_timestamp(), current_timestamp());