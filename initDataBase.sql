create schema telecom;

create table telecom.PURCHASE
(
    id        integer primary key,
    msisdn    integer,
    timestamp timestamp
);

create table telecom.SUBSCRIPTION
(
    id        integer primary key,
    msisdn    integer,
    timestamp timestamp
)