
    create table `work`.`user`(
        `id` int not null auto_increment,
       `name` varchar(20),
       `pwd` varchar(20),
        primary key (`id`)
    );

    create unique index `PRIMARY` on `work`.`user`(`id`);