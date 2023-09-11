insert into Article(ArticleName,ArticleDescription )
values('A', 'abcdefg');
insert into Article(ArticleName,ArticleDescription )
values('B', 'deabcfg');
insert into Article(ArticleName,ArticleDescription )
values('C', 'defgabc');

insert into Sessions(SessionName,StartDate,Duration)
values('ab',parsedatetime('24-04-2010', 'dd-MM-yyyy'),'120');
insert into Sessions(SessionName,StartDate,Duration)
values('cd',parsedatetime('24-04-2010', 'dd-MM-yyyy'),'90');
insert into Sessions(SessionName,StartDate,Duration)
values('ef',parsedatetime('24-04-2010', 'dd-MM-yyyy'),'180');

insert into Speaker(id,SpeakerName,Email,Phone,Password)
values('1','Deniz Isik','DenizIsik@gmail.com','05328718943','12v34');
insert into Speaker(id,SpeakerName,Email,Phone,Password)
values('2','Oyku Erdik','OykuErdik@gmail.com','05388713454','23b45');
insert into Speaker(id,SpeakerName,Email,Phone,Password)
values('3','Elif Keskin','ElifKeskin@gmail.com','05448818348','a3456');

insert into Attendee(AttendeeName,Email,Phone,Password)
values('Sena_Durkan','SenaDurkan@gmail.com','05338716944','4567');
insert into Attendee(AttendeeName,Email,Phone,Password)
values('Mecnun Cinar','MecnunCinar@gmail.com','05488715454','5678');
insert into Attendee(AttendeeName,Email,Phone,Password)
values('Leyle Yilmaz','LeyleYilmaz@gmail.com','05412818388','6789');