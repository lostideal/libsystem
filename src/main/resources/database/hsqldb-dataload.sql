
INSERT INTO user VALUES('j2ee','j2ee','J2EE','A',0,null,null);

INSERT INTO product(id, category, name, description) VALUES ('FI-SW-01','F','Angelfish','Salt Water fish from Australia');
INSERT INTO product(id, category, name, description) VALUES ('FI-SW-02','F','Tiger Shark','Salt Water fish from Australia');
INSERT INTO product(id, category, name, description) VALUES ('FI-FW-01','F', 'Koi','Fresh Water fish from Japan');
INSERT INTO product(id, category, name, description) VALUES ('FI-FW-02','F', 'Goldfish','Fresh Water fish from China');
INSERT INTO product(id, category, name, description) VALUES ('K9-BD-01','D','Bulldog','Friendly dog from England');
INSERT INTO product(id, category, name, description) VALUES ('K9-PO-02','D','Poodle','Cute dog from France');
INSERT INTO product(id, category, name, description) VALUES ('K9-DL-01','D', 'Dalmation','Great dog for a Fire Station');
INSERT INTO product(id, category, name, description) VALUES ('K9-RT-01','D', 'Golden Retriever','Great family dog');
INSERT INTO product(id, category, name, description) VALUES ('K9-RT-02','D', 'Labrador Retriever','Great hunting dog');
INSERT INTO product(id, category, name, description) VALUES ('K9-CW-01','D', 'Chihuahua','Great companion dog');
INSERT INTO product(id, category, name, description) VALUES ('RP-SN-01','R','Rattlesnake','Doubles as a watch dog');
INSERT INTO product(id, category, name, description) VALUES ('RP-LI-02','R','Iguana','Friendly green friend');
INSERT INTO product(id, category, name, description) VALUES ('FL-DSH-01','C','Manx','Great for reducing mouse populations');
INSERT INTO product(id, category, name, description) VALUES ('FL-DLH-02','C','Persian','Friendly house cat, doubles as a princess');
INSERT INTO product(id, category, name, description) VALUES ('AV-CB-01','B','Amazon Parrot','Great companion for up to 75 years');
INSERT INTO product(id, category, name, description) VALUES ('AV-SB-02','B','Finch','Great stress reliever');

INSERT INTO ROLE VALUES ('admin', 'the admin role');
INSERT INTO ROLE VALUES ('role1', 'role1');
INSERT INTO PERMISSION VALUES ('account:admin', 'account permission');
INSERT INTO PERMISSION VALUES ('auth:admin', 'auth permission');
INSERT INTO USER_ROLE VALUES ('j2ee', 'admin');
INSERT INTO USER_ROLE VALUES ('j2ee', 'role1');
INSERT INTO ROLE_PERMISSION VALUES ('admin', 'account:admin');
INSERT INTO ROLE_PERMISSION VALUES ('admin', 'auth:admin');
