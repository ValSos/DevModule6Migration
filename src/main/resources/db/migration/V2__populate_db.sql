INSERT INTO worker (name, birthday, level, salary)
VALUES
	('Petrenko Taras', '1998-04-26', 'Trainee', 500),
	('Dovhan Maxim', '2003-03-13', 'Junior', 1200),
	('Skrynnyk Kateryna', '1994-06-06', 'Middle', 2300),
	('Shevchenko Olha', '1991-12-24', 'Senior', 6000),
	('Dudnik Natalia', '1999-10-21', 'Trainee', 800),
	('Ivanenko Petro', '1995-05-25', 'Junior', 1000),
	('Melnik Dmytro', '2000-09-12', 'Middle', 1800),
	('Kolomiets Daryna', '1992-02-28', 'Senior', 7000),
	('Tkach Eygen', '2001-08-11', 'Trainee', 550),
	('Zubko Vasyl', '1988-09-23', 'Junior', 850);

INSERT INTO client (name)
VALUES
	('Klopotenko Ivan'),
	('Durnev Aleksey'),
	('Aminova Karyna'),
	('Slobodko Yana'),
	('Karpenko Alina');

INSERT INTO project (name, client_id, start_date, finish_date)
VALUES
	('Project A', 1, '2022-09-01', '2023-01-15'),
	('Project B', 2, '2023-01-01', '2023-03-15'),
	('Project C', 3, '2022-08-10', '2022-12-24'),
	('Project D', 4, '2021-09-01', '2023-01-15'),
	('Project E', 5, '2022-09-01', '2022-12-27'),
	('Project F', 1, '2021-05-01', '2022-01-01'),
	('Project G', 1, '2023-02-01', '2023-06-01'),
	('Project H', 2, '2023-03-01', '2023-04-01'),
	('Project I', 3, '2022-11-11', '2023-01-02'),
	('Project K', 5, '2022-09-15', '2023-01-15');


INSERT INTO project_worker (project_id , worker_id)
VALUES
	(1,3),
	(2,1),
	(3,2),
	(4,10),
	(5,8),
	(6,9),
	(7,4),
	(8,7),
	(9,5),
	(10,6),
	(5,3),
	(1,10),
	(1,7),
	(6,1),
	(6,3),
	(1,8),
	(1,9),
	(1,2),
	(1,5);