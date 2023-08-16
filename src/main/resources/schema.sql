-- Create the Board table
CREATE TABLE IF NOT EXISTS board_table (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

-- Create the Column table
CREATE TABLE column_table (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    board_id INT NOT NULL,
    FOREIGN KEY (board_id) REFERENCES board_table(id) ON DELETE CASCADE
);

-- Create the Task table
CREATE TABLE task_table (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    current_column_title VARCHAR(255) NOT NULL,
    column_id INT NOT NULL,
    FOREIGN KEY (column_id) REFERENCES column_table(id) ON DELETE CASCADE
);

-- Create the Subtask table
CREATE TABLE subtask_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    completed BOOLEAN NOT NULL,
    task_id INT NOT NULL,
    FOREIGN KEY (task_id) REFERENCES task_table(id) ON DELETE CASCADE
);

