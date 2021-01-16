CREATE TABLE "image"
(
    id            UUID         NOT NULL DEFAULT gen_random_uuid(),
    version       INT          NOT NULL,
    filename      VARCHAR(255) NOT NULL,
    original_name VARCHAR(255)          DEFAULT NULL,
    when_created  TIMESTAMP    NOT NULL DEFAULT now(),
    when_modified TIMESTAMP             DEFAULT NULL,
    PRIMARY KEY (id)
);
CREATE INDEX idx_image_filename ON "image" (filename);

CREATE TABLE "article"
(
    id            UUID         NOT NULL DEFAULT gen_random_uuid(),
    version       INT          NOT NULL,
    title         VARCHAR(255) NOT NULL,
    abstract      TEXT                  DEFAULT NULL,
    body          TEXT,
    image_fk      UUID REFERENCES "image" (id),
    published_at  TIMESTAMP             DEFAULT NULL,
    when_created  TIMESTAMP    NOT NULL DEFAULT now(),
    when_modified TIMESTAMP             DEFAULT NULL,
    PRIMARY KEY (id)
);
CREATE INDEX idx_article_title ON "article" (title);

CREATE TABLE "keyword"
(
    id            UUID         NOT NULL DEFAULT gen_random_uuid(),
    version       INT          NOT NULL,
    article_fk    UUID         NOT NULL REFERENCES "article" (id),
    name          VARCHAR(255) NOT NULL,
    when_created  TIMESTAMP    NOT NULL DEFAULT now(),
    when_modified TIMESTAMP             DEFAULT NULL,
    PRIMARY KEY (id)
);
CREATE INDEX id_keyword_name ON "keyword" (name);

---
-- Can you hear the Data laughing?
---

INSERT INTO "image" (id, version, filename)
VALUES ('5cd4b7df-9f8b-4d6c-83db-89d79a5ddde9', 0, 'image01.jpg');

INSERT INTO "article" (id, version, title, body, image_fk)
VALUES ('ea745416-71be-44c4-a12e-3720f8ad6332', 0, 'Demo 1', 'Really long text',
        '5cd4b7df-9f8b-4d6c-83db-89d79a5ddde9');

INSERT INTO "keyword" (version, article_fk, name)
VALUES (0, 'ea745416-71be-44c4-a12e-3720f8ad6332', 'Kultur'),
       (1, 'ea745416-71be-44c4-a12e-3720f8ad6332', 'Wissen');