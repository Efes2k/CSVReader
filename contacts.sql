CREATE TABLE `contacts` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL ,
  `name` varchar(20) NOT NULL DEFAULT '',
  `surname` varchar(20) DEFAULT '',
  `email` varchar(20) NOT NULL DEFAULT '',
  `phone_number` int (20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
