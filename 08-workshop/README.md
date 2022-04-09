# Course of Development

### Introduction
Workshop 08 - Backend part for blog.
Contains users, posts and commentaries to posts.

User has id, name. Can't be updated or deleted in this project, just get list of precreated users.

Post has id, authorId (userId), list of commentaryId(commentaryId), date and text, 
Only text and commentaryIdList can be updated  

Commentary has id, authorId(userId), date, text
Only text can be updated

### Description
Project includes base spring application


### Different versions of getAll method in service/repository

There is three versions of getAll for Posts and Commentaries

Simple - return all objects in repository, Controller should use All<Posts|Commentaries>Response

Pagination - return all objects in repository paginated.
Controller should use All<Posts|Commentaries>MetaResponse with Meta as extra parameter

Pagination and filter - return paginated objects in repository.
Could be filtered by authorId or just all objects.

Controller should use All<Posts|Commentaries>MetaResponse with Meta as extra parameter


By default in code set version "Pagination and filter"

### API

`GET: /users` - returns all users


`GET: /posts` - returns all posts

Query Params:

(not required) String order, default = "desc", available value: "desc" | "asc"
(not required) String authorId - UUID format
(not required) String page, default = "1", interval - 1 or more
(not required) String page, default = "25", interval - 1 or more


`POST: /posts` - create new post

Body (JSON):

(required) String text
(required) String authorId - UUID format

`GET: /posts/{id}` - find post by id

`PATCH: /posts/{id}` - update an existing post

Body (JSON):

(not required) String text
Example: "text of my post"

(not required) List<String> commentaryIdList
Example:
[ "0564200a-1ddd-43c3-9533-b35ea460e6ac", "28718968-d439-48d1-ba3d-cc72aa3b7ffb" ]

`DELETE: /posts/{id}` - deletes a post


`GET: /commentaries` - returns all commentaries

Query Params:

(not required) String order, default = "desc", available value: "desc" | "asc"
(not required) String authorId - UUID format
(not required) String page, default = "1", interval - 1 or more
(not required) String page, default = "25", interval - 1 or more

`POST: /commentaries` - create new commentary

Body (JSON):

(required) String text
(required) String authorId - UUID format

`GET: /commentaries/{id}` - find commentary by id

`PATCH: /commentaries/{id}` - update an existing commentary

Body (JSON):

(not required) String text
Example: "text of my commentary"


`DELETE: /commentaries/{id}` - deletes a commentary


### Getting started
You have to execute next instructions to run

`$ mvn package`

`java -jar %name_jar%.jar`

