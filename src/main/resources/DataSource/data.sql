INSERT INTO types (typeId, name, description, extension) VALUES
('41e2d211-6396-4f23-9690-77bc2820d84b', 'PDF', 'Portable Document Format', '.pdf');
INSERT INTO types (typeId, name, description, extension) VALUES
('e8e5310b-6345-4d08-86b6-d5c3c299aa7f', 'NOTE', 'Notatki tekstowe', '.txt');
INSERT INTO types (typeId, name, description, extension) VALUES
('4980d2e4-a424-4ff4-a0b2-476039682f43', 'WEB', 'Łącze sieciowe', '.url');
INSERT INTO types (typeId, name, description, extension) VALUES
('c9f1a16d-852d-4132-b4b8-ead20aafc6ef', 'WORD', 'Microsoft Word', '.doc?');
INSERT INTO documents (documentId, name, location, description, typeId, created, modified) VALUES('1acbb68a-a859-49c9-ac88-d9e9322bac55', 'Szablon książki', '/docs/isfbook/Documents/Random/BookTemplate.pdf', 'Szablon do tworzenia nowych książek', '41e2d211-6396-4f23-9690-77bc2820d84b','2014-02-24 11:52:00', '2014-02-26 13:45:00');
INSERT INTO documents (documentId, name, location, description, typeId, created, modified) VALUES('cf7fec3e-55bf-426d-8a6f-2ca752ae34ac', 'Przykładowa umowa', '/docs/isfbook/Documents/Contracts/Sample Contract.pdf', 'To tylko umowa', '41e2d211-6396-4f23-9690-77bc2820d84b', '2014-02-24 15:23:00','2014-02-28 10:20:00');
INSERT INTO documents (documentId, name, location, description, typeId, created, modified) VALUES('3580f482-7f12-4787-bb60-c98023d47b6c', 'Clustering with RabbitMQ', '/Users/isfbook/Documents/Random/Clustering with RabbitMQ.txt', 'Proste notatki', 'e8e5310b-6345-4d08-86b6-d5c3c299aa7f','2014-02-18 00:00:00', '2014-02-20 14:50:00');
INSERT INTO documents (documentId, name, location, description, typeId, created, modified) VALUES('431cddbf-f3c0-4076-8c1c-564e7dce16c9', 'Pro Spring Security Book', 'http://www.apress.com/9781430248187', 'Świetna książka', '4980d2e4-a424-4ff4-a0b2-476039682f43', '2014-02-14 00:00:00', '2014-02-20 00:00:00');