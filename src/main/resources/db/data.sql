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

INSERT INTO booking (id, uid, pin,status,type,qrcode,url) VALUES
(1,1,'pin1','uncheck','RAT','c1','xx'),
(2,2,'pin2','uncheck,','RAT','c2','xx'),
(3,3,'pin3','uncheck','RAT','c3','xx'),
(4,4,'pin4','uncheck','RAT','c4','xx'),
(5,5,'pin5','done','PCR','c5','xx');

