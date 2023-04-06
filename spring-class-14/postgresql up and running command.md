```
docker run 
-d --name clinton_letting_db 
-e POSTGRES_USER=postgres 
-e POSTGRES_DB=clinton_letting_db 
-e POSTGRES_PASSWORD=secret 
-e PGDATA=/var/lib/postgresql/data/pgdata 
-v /home/mainul35/custom/mount:/var/lib/postgresql/data 
-p 5432:5432 
postgres
```