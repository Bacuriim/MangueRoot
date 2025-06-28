DROP TABLE IF EXISTS users_messages;
DROP TABLE IF EXISTS users_friends;
DROP TABLE IF EXISTS friend_requests;
DROP TABLE IF EXISTS user_sessions;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id UUID PRIMARY KEY NOT NULL,
    username VARCHAR unique NOT NULL,
    password VARCHAR NOT NULL,
    profile_image BYTEA,
    role VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_enabled BOOL,
    last_time_online TIMESTAMP
);

CREATE TABLE messages
(
    id          INTEGER PRIMARY KEY NOT NULL,
    body        TEXT NOT NULL,
    image_path  VARCHAR unique,
    audio_path  VARCHAR unique,
    sent_at     TIMESTAMP NOT NULL,
    received_at TIMESTAMP,
    read_at     TIMESTAMP
);

CREATE TABLE user_sessions
(
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    connected_at TIMESTAMP NOT NULL,
    disconnected_at TIMESTAMP
);

CREATE TABLE users_messages
(
    messages_id INTEGER NOT NULL REFERENCES messages(id) ON DELETE CASCADE,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    
    PRIMARY KEY (messages_id, user_id)
);

CREATE TABLE users_friends
(
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    friend_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

    PRIMARY KEY (user_id, friend_id)
);

CREATE TABLE friend_requests
(
    id           SERIAL PRIMARY KEY,
    sender_id    UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    receiver_id  UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    status       VARCHAR,
    sent_at      TIMESTAMP NOT NULL,
    responded_at TIMESTAMP,

    CONSTRAINT unique_sender_receiver UNIQUE (sender_id, receiver_id)
);