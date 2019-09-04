> docker kill $(docker ps -aq); docker rm $(docker ps -aq); docker-compose up

> docker exec -it helloworldapp_helloworld-query_1 bash

> pg_dump -d helloworld -U postgres

> psql -d helloworld -U postgres

> DROP SCHEMA public CASCADE;CREATE SCHEMA public;
