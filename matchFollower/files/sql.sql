CREATE TABLE TEAM(
idTeam number (10) CONSTRAINT Team_id_pk PRIMARY KEY,
name varchar2(30),
country varchar2(30),
city varchar2(30),
year number(4),
website varchar2(50)
);

CREATE TABLE MAT(
idMat number(5) CONSTRAINT MAT_idMat_PK PRIMARY KEY,
idTeam1 number(10),
idTeam2 number(10),
place varchar2(30),
dateMatch date,
CONSTRAINT MAT_Team1_TEAM_FK FOREIGN KEY (idTeam1) references TEAM(idTeam),
CONSTRAINT MAT_Team2_TEAM_FK FOREIGN KEY (idTeam2) references TEAM(idTeam)
);
DROP TABLE SCORE;
CREATE TABLE SCORE(
idMat number(5), 
idTeam number(10),
score number(3),
CONSTRAINT RESULT_idMat_MAT_FK FOREIGN KEY (idMat) REFERENCES MAT(idMat),
CONSTRAINT RESULT_team_name_FK FOREIGN KEY (idTeam) REFERENCES TEAM(idTeam)
);

--Add teams
insert into team values(1,'Orlando City','Usa', 'Orlando',1999,'www.orlandocitysc.com');
insert into team values(2,'Palmeiras','Brazil', 'Sao Paulo',1914,'www.palmeiras.com.br');
insert into team values(3,'São Paulo','Brazil', 'Sao Paulo',1908,'www.saopaulors.com.br');
insert into team values(4,'Atlético Nacional','Colombia', 'Medellín',1947,'www.atlnacional.com.co');

--Add Matches
insert into mat values(1,1,2,'Allianz Parque',sysdate);
insert into mat values(2,3,4,'Estadio Atanasio Girardot',sysdate);

--Add goals
insert into SCORE values(2,3,1);

SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW"
     FROM DUAL;

select sysdate from dual;

select TO_CHAR(sysdate, 'DD-MON-YYYY HH24:MI:SSxFF') from dual;

select * from mat;