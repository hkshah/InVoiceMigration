CREATE DATABASE `invoice` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `invoice`.`customer_info` (
  `pet_sitting_price` decimal(10,0) DEFAULT NULL,
  `boarding_price` decimal(10,0) DEFAULT NULL,
  `uid` int(11) NOT NULL DEFAULT '0',
  `customer_first_name` text,
  `customer_last_name` text,
  `pet_name1` text,
  `pet_name2` text,
  `pet_name3` text,
  `pet_name4` text,
  `customer_address1` text,
  `customer_address2` text,
  `customer_city` text,
  `customer_state` text,
  `customer_zip` text,
  `fifteen_minute_price` decimal(10,0) DEFAULT NULL,
  `thirty_minute_price` decimal(10,0) DEFAULT NULL,
  `fortyfive_minute_price` decimal(10,0) DEFAULT NULL,
  `sixty_minute_price` decimal(10,0) DEFAULT NULL,
  `drop_off_pick_up_price` decimal(10,0) DEFAULT '0',
  `drop_off_pick_up_fl` varchar(1) DEFAULT 'F',
  `fb_client_id` int(11) DEFAULT NULL,
  `training_price` decimal(10,0) DEFAULT '50',
  `client_meeting_price` decimal(10,0) DEFAULT '12',
  `email` text,
  `twenty_minute_price` decimal(10,0) DEFAULT '0',
  `pet_sitting_11_hr_price` decimal(10,0) DEFAULT '0',
  `pet_sitting_12_hr_price` decimal(10,0) DEFAULT '0',
  `pet_sitting_14_hr_price` decimal(10,0) DEFAULT '0',
  `daycare_price` decimal(10,0) DEFAULT '0',
  `pet_sitting_10_hr_price` decimal(10,0) DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
