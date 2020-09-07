DROP TABLE IF EXISTS user_credit_score;
DROP TABLE IF EXISTS user_credit_loan;

CREATE TABLE user_credit_score (
  tc VARCHAR(11) NOT NULL,
  score number NOT NULL,
  primary key(tc)
);

CREATE TABLE user_credit_loan (
  tc VARCHAR(11) NOT NULL,
  name VARCHAR(100) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  credit_limit number NOT NULL,
  primary key(tc)
);