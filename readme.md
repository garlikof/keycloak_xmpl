# установка keycloak
1. установка в docker
   1. src\main\resources\keycloak\docker-compose.yml
   2. инструкция здесь https://habr.com/ru/articles/716232/
2. установка в kubernetes
   1. см файл resources/keycloak/keycloak.yaml
   2. kubectl apply -f keycloak.yaml
   3. minikube tunnel
   4. но так поднимается с внутренней БД. Подробней для пром конфигурации надо смотреть здесь https://www.keycloak.org/getting-started/getting-started-kube#_secure_the_first_application
      1. настроить БД https://www.keycloak.org/server/db будем пробовать постгре
   4. настройка подключения к постгре, который находится вне кубера находится внутри файла resources/keycloak/keycloak.yaml. Для прома надо будет актуализировать это вот всё
   5. для настройки пользователей внутри реалмов воспользовался вот этим (хотя по уму надо глубже кейклоак копать) https://stackoverflow.com/questions/56743109/keycloak-create-admin-user-in-a-realm
   6. 