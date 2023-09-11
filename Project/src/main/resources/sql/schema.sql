create table Article(ArticleID identity primary key,
                      ArticleName VARCHAR(500),
                      ArticleDescription VARCHAR(5000));

create table Sessions(SessionID identity primary key,
                     SessionName VARCHAR(100),
                     StartDate DATE,
                     Duration integer);
                                           
create table Speaker(id identity primary key,
                     SpeakerName VARCHAR(100),
                     Email  VARCHAR(100),
                     Phone  VARCHAR(100),
                     Password VARCHAR(10)
                     );
                                            
create table Attendee(AttendeeID identity primary key,
                      AttendeeName VARCHAR(100),
                      Email  VARCHAR(100),
                      Phone VARCHAR(100),
                      Password VARCHAR(10));

create table sp_art(sp_id bigint,
                    a_id bigint,
                    foreign key(sp_id) references Speaker(id),
                    foreign key(a_id) references Article(ArticleID));

 create table conferences(s_id bigint,foreign key(s_id) references Sessions(SessionID),
                                            sp_id bigint,foreign key(sp_id) references Speaker(id),
                                            a_id bigint,foreign key(a_id) references Article(ArticleID));