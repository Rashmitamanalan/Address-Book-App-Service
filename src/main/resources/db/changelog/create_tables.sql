CREATE TABLE IF NOT EXISTS users (
   user_id int8 NOT NULL,
   name varchar(255) NOT NULL,
   email varchar(255) NOT NULL,
   phone varchar(15) NOT NULL,
   profile_image varchar(255),
   PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS education (
   id INT GENERATED ALWAYS AS IDENTITY,
   user_id int8 NOT null,
   institution varchar(255) NOT NULL,
   start_year int8 NOT NULL,
   end_year int8,
   degree varchar(255),
   PRIMARY KEY(id),
   CONSTRAINT fk_user
      FOREIGN KEY(user_id) 
	   REFERENCES users(user_id) 
);

CREATE TABLE IF NOT EXISTS experience (
   id INT GENERATED ALWAYS AS IDENTITY,
   user_id int8 NOT null,
   institution varchar(255) NOT NULL,
   start_year int8 NOT NULL,
   end_year int8,
   title varchar(255),
   PRIMARY KEY(id),
   CONSTRAINT fk_user
      FOREIGN KEY(user_id) 
	   REFERENCES users(user_id) 
);