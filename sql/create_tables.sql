CREATE TABLE workers (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    profile_picture TEXT NOT NULL,
    department VARCHAR(50) NOT NULL,
    position VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    work_id VARCHAR(50) NOT NULL UNIQUE,
    check_in_time TIME NOT NULL,
    check_out_time TIME NOT NULL,
    date_of_birth DATE NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE supervisors (
    id SERIAL PRIMARY KEY,
    worker_id INT NOT NULL REFERENCES workers(id),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE leave_requests (
    id SERIAL PRIMARY KEY,
    worker_id INT NOT NULL REFERENCES workers(id),
    reason VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);
