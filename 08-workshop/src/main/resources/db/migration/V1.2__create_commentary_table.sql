CREATE TABLE IF NOT EXISTS commentary (
    id TEXT PRIMARY KEY,
    text TEXT,
    authorId TEXT REFERENCES "user" (id) ON DELETE CASCADE,
    createdAt TEXT
)