create table if not exists patients
(
    id int auto_increment primary key,
    name varchar(255) null,
    blood_type enum ('ABNegative', 'ABPositive', 'ANegative', 'APositive', 'BNegative', 'BPositive', 'ONegative', 'OPositive') null,
    medical_report varchar(255) null,
    address  varchar(255) null,
    contact_number varchar(255) null,
    constraint patients_id_uindex unique (id)
    );

create table if not exists donors
(
    id             int auto_increment
    primary key,
    name           varchar(255)                                                                                                    null,
    blood_type     enum ('ABNegative', 'ABPositive', 'ANegative', 'APositive', 'BNegative', 'BPositive', 'ONegative', 'OPositive') null,
    medical_report varchar(255)                                                                                                    null,
    address        varchar(255)                                                                                                    null,
    contact_number varchar(255)                                                                                                    null,
    constraint donors_id_uindex
    unique (id)
    );

