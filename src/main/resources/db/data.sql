DELETE FROM user;

INSERT INTO user (id, username, password,email,type) VALUES
(1, 'Jone', '123','test1@baomidou.com','user'),
(2, 'Jack', '123','test2@baomidou.com','administrators'),
(3, 'Tom', '123','test3@baomidou.com','customer'),
(4, 'Sandy', '123','test4@baomidou.com','administerer'),
(5, 'Billie', '123','test5@baomidou.com','administrators');

INSERT INTO site (id, name, place,type,status,book,time) VALUES
(1,'a','locate:a','hospital','open','15','yes'),
(2,'b','locate:b','Clinics,','close','5','no'),
(3,'c','locate:c','hospital','open','10','yes'),
(4,'d','locate:d','GPs','open','15','no'),
(5,'e','locate:e','Walk-in','close','20','yes');

