INSERT INTO `user` (`id`, `email`, `firstname`, `lastname`, `password`, `type`) VALUES (1, 'admin@creditauven.ce', 'Administateur', 'Administateur', 'a12892155820f9b5c0ffa697e56968808ffa7cd4', 2), (2, 'sebastien.foray@ynov.com', 'Sébastien', 'Foray', '41bda204a2668ac6893ecaa282af9872b0522a55', 0);
INSERT INTO `customer` (`id`, `shares`, `checkingAccount_fk`, `savingAccount_fk`, `user_fk`) VALUES (1, 0, 1, 2, 2);
INSERT INTO `account` (`id`, `balance`, `creationDate`, `interest`, `label`) VALUES (1, 0, '2017-03-04 19:03:33', 0, 'Compte Courant'), (2, 0, '2017-03-04 19:03:33', 0.9, 'Livret A');
